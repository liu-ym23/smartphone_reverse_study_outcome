package p6b;

import android.app.Application;
import android.text.TextUtils;
import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.SendStatus;
import com.ss.android.lark.chat.entity.message.content.FileState;
import com.ss.android.lark.chat.entity.message.content.MediaContent;
import com.ss.android.lark.chat.service.impl.z0;
import com.ss.android.lark.im.sdk.ImSdkProxy;
import com.ss.android.lark.im.sdk.service.ImSdkService;
import com.ss.android.lark.im.sdk.utils.ImSdkMessageUtils;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.statistics.Statistics;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.videosend.compress.VideoCompressResult;
import com.ss.android.lark.videosend.tools.VideoCompressTools;
import com.ss.android.lark.videosend.tools.VideoTools;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import kotlin.jvm.internal.Intrinsics;
import m6b.p;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class d {
    public final Map<String, Long> a;

    public static final class a {
        public static final d a = null;

        static {
            a = new d();
        }
    }

    public static class b {
        public String a;
        public Message b;
        public int c;
        public boolean d;
        public IGetDataCallback<String> e;
        public boolean f;
        public boolean g;

        public final String toString() {
            return "message=" + this.b + ",mediaCount=" + this.c + ",isNeedUpdateProgress=" + this.d + ",isResend=" + this.f + ",needSendMessageAfterUpload=" + this.g;
        }

        public b() {
            this.g = true;
        }
    }

    public d() {
        this.a = Collections.synchronizedMap(new HashMap());
    }

    public static void c(b r4) {
        String r0 = ImSdkProxy.e().getCurrentUserId();
        if (TextUtils.isEmpty(r0) == false) goto L5;
    L21:
        Log.e("MediaSendDispatcher", "compress is success, but user id is switched, so stop send msg");
        return;
    L5:
        if (r0.equals(r4.a) == false) goto L21;
        pac.a.b();
        Message r1 = r4.b;
        z0.j(r1.getcId());
        Log.i("MediaSendDispatcher", "compress is success, start to send msg: " + r1.getcId());
        if ((r4.e instanceof p) == false) goto L14;
        if (r4.d == false) goto L12;
        MediaContent r2 = new MediaContent((MediaContent) r1.getContent());
        r2.setFileState(FileState.UPLOADING);
        r1.setMessageContent(r2);
    L12:
        r4.e.onBeginSendMessage(r1);
    L14:
        if (r4.g == true) goto L16;
        return;
    L16:
        Application r3 = LarkContext.getApplication();
        if (r4.f == false) goto L19;
        ImSdkService.f().p2(ImSdkMessageUtils.b(r3, r1), r4.e);
        return;
    L19:
        ImSdkService.f().l9(ImSdkMessageUtils.b(r3, r1), r4.e);
    }

    public final void a(String r4) {
        Long r5 = this.a.get(r4);
        if (r5 == null) goto L12;
        JSONObject r0 = new JSONObject();
        r0.put("cancel_reason", "user");     // Catch: JSONException -> L7
    L8:
        Statistics.sendEvent("video_send_cancel_event_dev", r0);
        int r1 = com.ss.android.lark.videosend.compress.d.d;
        com.ss.android.lark.videosend.compress.d.b.a.b(r5.longValue());
        return;
    L7:
        Log.i("MediaSendDispatcher", "cancel json exception");
        goto L8
    }

    public final void b(b r9) {
        Log.i("MediaSendDispatcher", "sendMessage: " + r9);
        if (r9.c != 0) goto L6;
        c(r9);
        return;
    L6:
        Message r0 = r9.b;
        String r2 = r0.getcId();
        if ((r0.getContent() instanceof MediaContent) == false) goto L11;
        String r3 = ((MediaContent) r0.getContent()).getCompressPath();
        if (r3 == null) goto L11;
        z0.h(r2, r3);
    L11:
        ImSdkService.f().f1(r2, SendStatus.SENDING);
        String r4 = r6b.a.b(r0);
        String r5 = r6b.a.a(r0);
        if (TextUtils.equals(r4, r5) == true) goto L14;
    L16:
        String r6 = r0.getcId();
        c r7 = new c(this, r9, r9, r6);
        Intrinsics.checkNotNullParameter(r0, "message");
        Intrinsics.checkNotNullParameter(r7, "callback");
        String r10 = r6b.a.b(r0);
        String r8 = r6b.a.a(r0);
        boolean r11 = false;
        if (r10.length() <= 0) goto L19;
        boolean r12 = true;
    L20:
        if (r12 == true) goto L22;
    L28:
        com.ss.android.lark.videosend.compress.a r13 = null;
    L29:
        if (r13 != null) goto L31;
        Log.e("MediaSendDispatcher", "no compress param, cId: " + r6);
        return;
    L31:
        r13.e = Boolean.TRUE;
        this.a.put(r6, Long.valueOf(r13.a));
        int r14 = com.ss.android.lark.videosend.compress.d.d;
        com.ss.android.lark.videosend.compress.d.b.a.c(r13);
        return;
    L22:
        if (r8.length() <= 0) goto L24;
        r11 = true;
    L24:
        if (r11 == false) goto L28;
        r13 = new com.ss.android.lark.videosend.compress.a(UUID.randomUUID().hashCode(), r10, r7);
        r13.d = r8;
        r13.f = r0.getChatId();
        r13.g = r0.getcId();
        if (r0.getType() != Message.Type.MEDIA) goto L29;
        r13.j = ((MediaContent) r0.getContent()).getMediaUploadId();
        ((MediaContent) r0.getContent()).getFirstScreenImageUploadId();
        goto L29
    L19:
        r12 = false;
        goto L20
    L14:
        if (TextUtils.isEmpty(r4) == true) goto L16;
        z0.c(r0.getcId());
        VideoCompressResult r1 = new VideoCompressResult(VideoCompressResult.ResultType.RAW);
        r1.b = VideoCompressTools.c(VideoTools.getVideoInfo(r4), new VideoTools.d(), r4, r5);
        z0.b(r0.getcId(), r1);
        c(r9);
    }
}
