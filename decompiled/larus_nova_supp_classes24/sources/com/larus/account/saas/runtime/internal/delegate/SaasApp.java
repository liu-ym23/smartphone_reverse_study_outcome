package com.larus.account.saas.runtime.internal.delegate;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import com.larus.account.saas.runtime.depend.ToastType;
import d48.c$a;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class SaasApp implements d48.c {
    public static final SaasApp a = null;
    public static final Lazy b = null;

    public SaasApp() {
    }

    static {
        a = new SaasApp();
        b = LazyKt.lazy(SaasApp$impl$2.INSTANCE);
    }

    public static d48.c a() {
        return (d48.c) b.getValue();
    }

    public final boolean b() {
        return a().b();
    }

    public final Activity currentActivity() {
        return a().currentActivity();
    }

    public final String e() {
        return a().e();
    }

    public final Application getApplication() {
        return a().getApplication();
    }

    public final boolean isTeenMode() {
        return a().isTeenMode();
    }

    public final String c(int r2) {
        return getApplication().getString(r2);
    }

    public final void g(c$a r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        a().g(r2);
    }

    public final void h(com.larus.account.saas.mfa.assist.c r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        a().h(r2);
    }

    public final boolean f(ToastType r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "type");
        Intrinsics.checkNotNullParameter(r3, "text");
        return a().f(r2, r3);
    }

    public boolean startActivity(Activity r2, Intent r3) {
        Intrinsics.checkNotNullParameter(r3, "intent");
        return a().startActivity(r2, r3);
    }
}
