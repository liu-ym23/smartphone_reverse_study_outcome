package com.bytedance.android.live.liveinteract.digitavatar;

import com.bytedance.android.livesdkapi.depend.model.live.audio.UploadAvatar2AuditResponse;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class t<T> implements Consumer {
    public final /* synthetic */ DigitAvatarRecognitionDialog a;

    public t(DigitAvatarRecognitionDialog r1) {
        this.a = r1;
    }

    public final void accept(Object r5) {
        com.bytedance.android.live.network.response.e r6 = (com.bytedance.android.live.network.response.e) r5;
        DigitAvatarRecognitionDialog r0 = this.a;
        StringBuilder r1 = new StringBuilder("上传图片成功, auditId=");
        if (r6 == null) goto L7;
        UploadAvatar2AuditResponse r2 = (UploadAvatar2AuditResponse) r6.data;
        if (r2 == null) goto L7;
        Long r3 = Long.valueOf(r2.getAuditId());
    L8:
        r1.append(r3);
        r0.U90(r1.toString());
        if (r6 == null) goto L25;
        UploadAvatar2AuditResponse r7 = (UploadAvatar2AuditResponse) r6.data;
        if (r7 == null) goto L26;
        long r4 = r7.getAuditId();
        if (r4 <= 0) goto L27;
        DigitAvatarContext.a r8 = DigitAvatarContext.Companion;
        DigitAvatarContext r9 = r8.getContext();
        if (r9 == null) goto L21;
        com.bytedance.live.datacontext.m<n> r10 = r9.getDigitAvatar();
        if (r10 == null) goto L21;
        n r11 = (n) r10.getValue();
        if (r11 == null) goto L21;
        r11.f = r4;
    L21:
        DigitAvatarContext r12 = r8.getContext();
        if (r12 == null) goto L28;
        r12.saveDigitAvatar();
        return;
    L28:
        return;
    L27:
        return;
    L26:
        return;
    L25:
        return;
    L7:
        r3 = null;
        goto L8
    }
}
