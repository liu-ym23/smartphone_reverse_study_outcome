package com.larus.camera.impl.utils;

import android.content.Context;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class c0 {
    public static final /* synthetic */ int d = 0;
    public Function1<? super Integer, Boolean> a;
    public int b;
    public d0 c;

    public static final class a {
        public static float a(int r1, boolean r2) {
            if (r1 != 90) goto L5;
            return -90.0f;
        L5:
            if (r1 == 270) goto L11;
            if (r2 == true) goto L8;
        L10:
            return 0.0f;
        L8:
            if (r1 != 180) goto L10;
            return 180.0f;
        L11:
            return 90.0f;
        }
    }

    static {
    }

    public c0(Context r2, com.larus.camera.impl.ui.viewmodel.g0 r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "onChange");
        this.a = r3;
        this.b = -1;
        d0 r4 = new d0(this, r2.getApplicationContext());
        this.c = r4;
        r4.enable();
    }
}
