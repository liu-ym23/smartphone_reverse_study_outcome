package com.bytedance.android.ec.core.utils;

import android.content.Context;
import android.graphics.drawable.Drawable;
import androidx.core.content.ContextCompat;
import java.util.Arrays;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class g1 {
    public static final /* synthetic */ int a = 0;

    public static final class a {
        @JvmStatic
        public static int a(Context r1, int r10) {
            Intrinsics.checkNotNullParameter(r1, "context");
            return ContextCompat.getColor(th.a.e(r1, true), r10);
        }

        @JvmStatic
        public static Drawable b(Context r1, int r10) {
            Intrinsics.checkNotNullParameter(r1, "context");
            return ContextCompat.getDrawable(th.a.e(r1, true), r10);
        }

        @JvmStatic
        public static String c(Context r1, int r10, Object... r11) {
            Intrinsics.checkNotNullParameter(r1, "context");
            Intrinsics.checkNotNullParameter(r11, "formattedArgs");
            return th.a.e(r1, true).getString(r10, Arrays.copyOf(r11, r11.length));
        }
    }

    static {
    }
}
