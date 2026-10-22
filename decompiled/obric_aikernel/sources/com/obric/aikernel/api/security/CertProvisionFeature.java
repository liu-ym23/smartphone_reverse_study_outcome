package com.obric.aikernel.api.security;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlinx.coroutines.h;

/* JADX INFO: loaded from: classes2.dex */
public class CertProvisionFeature implements com.obric.aikernel.api.d {
    public CertProvisionFeature() {
    }

    static /* synthetic */ Object d(CertProvisionFeature r10, Continuation<? super Boolean> r11) {
        return Boxing.boxBoolean(true);
    }

    public String a() {
        return "ocean.device_intelligence.model_center_srv";
    }

    public boolean b() {
        return false;
    }

    public Object c(Continuation<? super Boolean> r10) {
        return d(this, r10);
    }

    public final boolean e() {
        return ((Boolean) h.f(null, new CertProvisionFeature$waitCertProvisionedBlocking$1(this, null), 1, null)).booleanValue();
    }
}
