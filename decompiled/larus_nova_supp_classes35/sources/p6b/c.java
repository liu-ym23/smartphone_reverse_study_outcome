package p6b;

import com.larksuite.framework.callback.Entity.ErrorResult;
import com.ss.android.lark.chat.entity.message.SendStatus;
import com.ss.android.lark.chat.service.impl.v;
import com.ss.android.lark.chat.service.impl.z0;
import com.ss.android.lark.im.sdk.service.ImSdkService;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.statistics.Statistics;
import com.ss.android.lark.videosend.compress.VideoCompressErrorResult;
import com.ss.android.lark.videosend.compress.VideoCompressResult;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class c extends a {
    public final /* synthetic */ d.b c;
    public final /* synthetic */ String d;
    public final /* synthetic */ d e;

    public final void b(ErrorResult r5) {
        a(0.0f);
        if ((this.a.e instanceof v) == true) goto L5;
    L9:
        Log.e("MediaSendDispatcher", "compress video fail: " + r5);
        ImSdkService.f().f1(this.d, SendStatus.FAIL);
        Statistics.sendEvent("lark_android_compress_video", new JSONObject().put("compress_succ", "n"));     // Catch: JSONException -> L12
    L14:
        b r0 = this.c.e;
        if ((r0 instanceof b) == false) goto L20;
        r0.onInterrupted("compress video failed: " + r5);
        return;
    L20:
        return;
    L12:
        e = move-exception;
        e.printStackTrace();
        goto L14
    L5:
        if ((r5 instanceof VideoCompressErrorResult) == false) goto L9;
        VideoCompressResult r1 = ((VideoCompressErrorResult) r5).getVideoCompressResult();
        if (r1 == null) goto L9;
        this.a.e.onCompressMediaEnd(r1);
        goto L9
    }

    public final void c(VideoCompressResult r3) {
        a(1.0f);
        v r0 = this.a.e;
        if ((r0 instanceof v) == false) goto L6;
        r0.onCompressMediaEnd(r3);
    L6:
        if (r3.a != VideoCompressResult.ResultType.REUSE) goto L9;
        Log.i("MediaSendDispatcher", "compress success, prepare send message: " + this.c.b);
        d r4 = this.e;
        d.b r1 = this.c;
        r4.getClass();
        d.c(r1);
        return;
    }

    public final void f(ErrorResult r3) {
        Log.e("MediaSendDispatcher", "compress upload fail: " + r3 + " prepare send compress file");
        z0.d(this.d, r3);
        d r4 = this.e;
        d.b r0 = this.c;
        r4.getClass();
        d.c(r0);
    }

    public final void g(long r3) {
        Log.i("MediaSendDispatcher", "compress upload success, prepare send message: " + this.c.b);
        z0.e(this.d, r3);
        d r4 = this.e;
        d.b r5 = this.c;
        r4.getClass();
        d.c(r5);
    }

    public c(d r1, d.b r2, d.b r3, String r4) {
        this.e = r1;
        this.c = r3;
        this.d = r4;
        super(r2);
    }
}
