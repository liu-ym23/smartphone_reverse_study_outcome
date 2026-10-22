package e2b;

import android.text.TextUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larksuite.framework.utils.CollectionUtils;
import com.ss.android.lark.biz.im.api.p0;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.MessageParams;
import com.ss.android.lark.chat.service.impl.MonitorMessageSendCallback;
import com.ss.android.lark.im.sdk.service.ImSdkService;
import com.ss.android.lark.im.sdk.service.p;
import com.ss.android.lark.image.uploader.utils.ImageInfo;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.vfs.VFSFiles;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class e extends dlb.b {
    public final /* synthetic */ String a;
    public final /* synthetic */ String b;
    public final /* synthetic */ String c;
    public final /* synthetic */ String d;
    public final /* synthetic */ String e;
    public final /* synthetic */ h f;

    public final void b(List<com.ss.android.lark.image.uploader.entity.b> r17) {
        h r1 = this.f;
        String r8 = "png";
        if (CollectionUtils.isNotEmpty(r17) == false) goto L8;
        com.ss.android.lark.image.uploader.entity.b r2 = (com.ss.android.lark.image.uploader.entity.b) ListProtector.get(r17, 0);
        String r9 = r2.j;
        ImageInfo r3 = r2.k;
        if (r3 == null) goto L7;
        int r5 = r3.a;
        int r6 = r3.b;
        long r7 = r3.c;
        r8 = r3.h.getValue();
    L10:
        MonitorMessageSendCallback r10 = r1.a();
        long r11 = r5;
        long r13 = r6;
        boolean r4 = r1.c;
        r10.getClass();
        if (TextUtils.isEmpty(r9) == false) goto L13;
        String r15 = "default";
    L14:
        MonitorMessageSendCallback.c r12 = (MonitorMessageSendCallback.c) ((ConcurrentHashMap) r10.o).get(r15);
        if (r12 == null) goto L18;
        VFSFiles.b.getClass();
        r12.e = VFSFiles.b(true).i(r9).length();
        r12.q = r7;
        r12.o = r11;
        r12.p = r13;
        r12.l = r8;
        r12.k = r4;
    L18:
        MessageParams.a<?, ?> r14 = new p0.a();
        h r16 = this.f;
        r14.c = r16.a;
        r14.d = this.b;
        r14.a = this.c;
        r14.b = this.d;
        r14.e = r16.g;
        ((p0.a) r14).A = this.a;
        ((p0.a) r14).B = r5;
        ((p0.a) r14).C = r6;
        ((p0.a) r14).F = this.e;
        ((p0.a) r14).D = false;
        ((p0.a) r14).E = r16.c;
        r14.m = false;
        r14.l = r16.a().c;
        this.f.getClass();
        if (TextUtils.isEmpty(null) == true) goto L21;
        this.f.getClass();
        r14.i = null;
    L21:
        com.ss.android.lark.chat.entity.message.a r18 = this.f.m;
        if (r18 == null) goto L24;
        r18.a(r14);
    L24:
        this.f.getClass();
        this.f.getClass();
        if (TextUtils.isEmpty(null) == true) goto L27;
        this.f.getClass();
        ((p0.a) r14).G = null;
    L27:
        p r19 = ImSdkService.f();
        r14.h = Message.Type.IMAGE;
        r19.a7(new p0(r14), this.f.a());
        return;
    L13:
        r15 = r9;
        goto L14
    L7:
        Log.e("ImageSenderV2", "imageInfo is empty");
        r5 = 0;
    L9:
        r7 = 0;
        r6 = 0;
        goto L10
    L8:
        Log.e("ImageSenderV2", "imageList is empty");
        r5 = 0;
        r9 = null;
        goto L9
    }

    public final void j(int r1, com.ss.android.lark.image.uploader.entity.b r2, long r3, int r5, int r6) {
        Log.i("ImageSenderV2", "send image , onUploadFileCheckInvalid, errorCode:" + r1 + ", imagePath:" + this.a + ", maxLimitValue:" + r3);
        PolarisFileWrapper r4 = new PolarisFileWrapper(r2.a);
        h.a r7 = this.f.k;
        if (r7 == null) goto L5;
        r7.a(r4);
        return;
    L5:
        Log.e("ImageSenderV2", "imageCallback is null, so image convert to file failed for " + r4.getName());
        this.f.a().r(null);
    }

    public e(h r1, String r2, String r3, String r4, String r5, String r6) {
        this.f = r1;
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
    }
}
