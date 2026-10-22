package com.bytedance.bpea.basics;

import com.bytedance.android.livesdk.chatroom.vs_base.base.service.inner.ReplayUIStateCode;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0007\u001a\u001a\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0007¨\u0006\u0005"}, d2 = {"findCert", "Lcom/bytedance/bpea/basics/Cert;", "token", "", "auth", "basics_release"}, k = 2, mv = {1, 1, ReplayUIStateCode.IS_FOLD_OPEN})
public final class CertProviderManagerKt {
    public static final Cert findCert(String r3) {
        Cert r0 = CertProviderManager.INSTANCE.findCert(r3);
        if (r0 == null) goto L6;
        return r0;
    L6:
        return new DefaultCert(r3, null, 2, null);
    }

    public static final Cert findCert(String r1, String r2) {
        Cert r0 = CertProviderManager.INSTANCE.findCert(r1, r2);
        if (r0 == null) goto L6;
        return r0;
    L6:
        return new DefaultCert(r1, r2);
    }
}
