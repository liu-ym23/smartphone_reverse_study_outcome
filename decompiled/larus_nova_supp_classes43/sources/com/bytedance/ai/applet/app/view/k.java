package com.bytedance.ai.applet.app.view;

import android.content.Context;
import android.view.ContextThemeWrapper;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class k {

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[AppletThemeMode.values().length];
            r0[AppletThemeMode.FOLLOW_SYSTEM.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[AppletThemeMode.LIGHT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[AppletThemeMode.DARK.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            a = r0;
        }
    }

    public static final int a(AppletThemeMode r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        int r10 = a.a[r1.ordinal()];
        if (r10 != 1) goto L5;
        return 2131951616;
    L5:
        if (r10 != 2) goto L7;
        return 2131951618;
    L7:
        if (r10 != 3) goto L10;
        return 2131951617;
    L10:
        throw new NoWhenBranchMatchedException();
    }

    public static final Context b(Context r1, AppletThemeMode r10) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r10, "mode");
        return new ContextThemeWrapper(r1, a(r10));
    }
}
