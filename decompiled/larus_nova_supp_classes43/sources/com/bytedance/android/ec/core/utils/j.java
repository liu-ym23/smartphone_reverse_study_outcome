package com.bytedance.android.ec.core.utils;

import android.view.View;
import android.view.ViewGroup;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class j {
    public static final /* synthetic */ int a = 0;

    public static final class a {
        @JvmStatic
        public static void a(View r1) {
            Intrinsics.checkNotNullParameter(r1, "view");
            ViewGroup.LayoutParams r0 = r1.getLayoutParams();
            r0.height = eh.b.b(r1.getContext());
        }
    }

    static {
    }
}
