package com.ss.android.lark.conditional.access.nopermission.ui.custom;

import com.ss.android.lark.security.compliance.infra.log.ScsLogger;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class l<T> implements Consumer {
    public final /* synthetic */ String a;

    public l() {
        this.a = "fixed:advanced_login:geo_restricted";
    }

    public final void accept(Object r3) {
        int r0 = ScsLogger.a;
        ScsLogger.e("SecurityPolicy_CustomNoPermissionFragment", "loadDynamicPageTemplate failed, key=" + this.a + ", error=" + ((Throwable) r3).getMessage());
    }
}
