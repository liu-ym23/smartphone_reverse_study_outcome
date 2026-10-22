package com.ss.android.lark.conditional.access.utils;

import android.content.Context;
import android.os.Bundle;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class g {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public g() {
    }

    public static void a(Context r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Bundle r0 = new Bundle();
        r0.putString("url", r3);
        r0.putBoolean("isNeedLogin", false);
        int r4 = g8b.b.a;
        g8b.b.a.a().getDependency().e().a(r2, r0);
    }
}
