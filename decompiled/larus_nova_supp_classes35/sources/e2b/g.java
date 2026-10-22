package e2b;

import android.text.TextUtils;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.android.lark.appreciablelib.Scene;
import com.ss.android.lark.biz.im.api.p0;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.MessageParams;
import com.ss.android.lark.chat.service.impl.MonitorMessageSendCallback;
import com.ss.android.lark.im.sdk.service.ImSdkService;
import com.ss.android.lark.im.sdk.service.p;
import com.ss.android.lark.image.uploader.upload.ImageUploadManager;
import com.ss.android.lark.image.uploader.upload.j;
import com.ss.android.lark.image.uploader.utils.ImageInfo;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class g extends j {
    public final /* synthetic */ String a;
    public final /* synthetic */ String b;
    public final /* synthetic */ String c;
    public final /* synthetic */ String d;
    public final /* synthetic */ h e;

    public final void a(com.ss.android.lark.image.uploader.entity.b r11, ImageUploadManager.wrapUploader.1.1 r12) {
        ImageInfo r0 = r11.k;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        if (r0 != null) goto L8;
        int r1 = 0;
    L9:
        String r3 = r11.a;
        this.e.a().r(new dcb.b(r11.j, new PolarisFileWrapper(r3), new int[]{r2, r1}));
        MonitorMessageSendCallback r4 = this.e.a();
        String r5 = r11.j;
        com.ss.android.lark.image.uploader.entity.a r13 = r11.m;
        MonitorMessageSendCallback.c r6 = (MonitorMessageSendCallback.c) ((ConcurrentHashMap) r4.o).get(r5);
        if (r6 == null) goto L14;
        if (r13 == null) goto L14;
        r6.z = r13.c;
        r6.A = r13.a;
        r6.B = r13.b;
    L14:
        MessageParams.a<?, ?> r14 = new p0.a();
        h r7 = this.e;
        r14.c = r7.a;
        r14.d = this.a;
        r14.a = this.b;
        r14.b = this.c;
        r14.e = r7.g;
        ((p0.a) r14).A = r3;
        ((p0.a) r14).B = r2;
        ((p0.a) r14).C = r1;
        ((p0.a) r14).F = this.d;
        ((p0.a) r14).D = false;
        ((p0.a) r14).E = r7.c;
        r14.m = false;
        r14.s = r7.f;
        if (r7.i != Scene.Share) goto L17;
        MessageParams.CreateScene r8 = MessageParams.CreateScene.COMMON_SHARE;
    L18:
        r14.n = r8;
        r14.l = r7.a().c;
        this.e.getClass();
        if (TextUtils.isEmpty(null) == true) goto L21;
        this.e.getClass();
        r14.i = null;
    L21:
        com.ss.android.lark.chat.entity.message.a r9 = this.e.m;
        if (r9 == null) goto L24;
        r9.a(r14);
    L24:
        this.e.getClass();
        this.e.a().k = new f(r12);
        p r15 = ImSdkService.f();
        r14.h = Message.Type.IMAGE;
        r15.ib(new p0(r14), this.e.a());
        return;
    L17:
        r8 = MessageParams.CreateScene.NORMAL;
        goto L18
    L8:
        r1 = r0.b;
        goto L9
    L5:
        r2 = r0.a;
        goto L6
    }

    public g(h r1, String r2, String r3, String r4, String r5) {
        this.e = r1;
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
    }
}
