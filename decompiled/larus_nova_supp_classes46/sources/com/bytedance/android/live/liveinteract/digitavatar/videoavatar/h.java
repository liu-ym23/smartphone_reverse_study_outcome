package com.bytedance.android.live.liveinteract.digitavatar.videoavatar;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdkapi.depend.model.live.audio.GetAvatarAuditResponse;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class h<T> implements Consumer {
    public final /* synthetic */ VideoDigitAvatarWidget a;

    public h(VideoDigitAvatarWidget r1) {
        this.a = r1;
    }

    public final void accept(Object r7) {
        com.bytedance.android.live.network.response.e r8 = (com.bytedance.android.live.network.response.e) r7;
        StringBuilder r0 = new StringBuilder("getAvatarAuditResult拉取审核结果得到回包, data=");
        if (r8 == null) goto L5;
        GetAvatarAuditResponse r1 = (GetAvatarAuditResponse) r8.data;
    L6:
        r0.append(r1);
        ALogger.i("KtvDigitAvatar", r0.toString());
        if (r8 == null) goto L12;
        GetAvatarAuditResponse r9 = (GetAvatarAuditResponse) r8.data;
        if (r9 == null) goto L13;
        VideoDigitAvatarWidget r2 = this.a;
        long r3 = r9.getAuditId();
        long r4 = r9.getAuditResult();
        String r5 = r9.getReason();
        int r10 = VideoDigitAvatarWidget.l;
        r2.xq(r3, r4, r5);
        return;
    L13:
        return;
    L12:
        return;
    L5:
        r1 = null;
        goto L6
    }
}
