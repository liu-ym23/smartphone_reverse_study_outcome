package com.larus.bootprotector.activity;

import android.content.Intent;
import com.larus.bootprotector.utils.hook.RedirectActivityInstrumentation;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class a implements RedirectActivityInstrumentation.b {

    /* JADX INFO: renamed from: com.larus.bootprotector.activity.a$a, reason: collision with other inner class name */
    public static final class C0052a {
    }

    static {
    }

    public a() {
    }

    @Override // com.larus.bootprotector.utils.hook.RedirectActivityInstrumentation.b
    public final String a(String r2, Intent r3) {
        Intrinsics.checkNotNullParameter(r2, "className");
        Intrinsics.checkNotNullParameter(r3, "intent");
        nu8.a.a("BootProtectorActivityRedirect", "redirect to BootProtectorLandingActivity");
        return BootProtectorLandingActivity.class.getName();
    }
}
