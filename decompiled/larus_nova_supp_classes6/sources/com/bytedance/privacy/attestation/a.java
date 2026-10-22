package com.bytedance.privacy.attestation;

import android.text.TextUtils;
import com.bytedance.security.eventproto.monitor.ErrorEvent;
import com.bytedance.security.eventproto.monitor.NormalEvent;
import com.bytedance.security.eventproto.monitor.wrapper.AttestationConfigInfoWrapper;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final class a {
    public static void a(int r6, String r7, String r8, long r9, AttestationConfig r11) {
        if (r6 != 0) goto L5;
        NormalEvent.eventReport(1, 0, r7, r8, r9);
        return;
    L5:
        ErrorEvent.eventReport(1, 0, r7, r8, r6, AttestationConfigInfoWrapper.newBuilder().setReqUdid(r11.isIdRequested(AttestationConfig.IdType.UDID)).setReqRpdid(r11.isIdRequested(AttestationConfig.IdType.RPDID)).setReqRpuid(r11.isIdRequested(AttestationConfig.IdType.RPUID)).setAddCustomInfo(!TextUtils.isEmpty(r11.getCustomInfo())).setDevHealthStatusRequired(r11.isDevHealthStatusRequired()).build());
    }
}
