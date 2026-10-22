package com.larksuite.component.card.navigation;

import android.content.Context;
import com.larksuite.component.card.utils.h;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.chat.entity.message.content.CardContent;
import com.ss.android.lark.utils.LarkContext;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class UniversalCardLargeScreenAdapt {
    public static final Lazy a = null;
    public static final Lazy b = null;

    public static final class a {
        public final int a;
        public final int b;
        public final int c;

        public a(int r1, int r2, int r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[CardContent.WidthMode.values().length];
            r0[CardContent.WidthMode.FILL.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[CardContent.WidthMode.COMPACT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    static {
        a = LazyKt.lazy(UniversalCardLargeScreenAdapt$enable$2.INSTANCE);
        b = LazyKt.lazy(UniversalCardLargeScreenAdapt$screenConfig$2.INSTANCE);
    }

    public static boolean b() {
        return ((Boolean) a.getValue()).booleanValue();
    }

    public static boolean c(Context r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        if (b() == true) goto L5;
        return false;
    L5:
        int r0 = h.a;
        Context r4 = UIUtils.getActivityFromContext(r2);
        if (r4 != null) goto L10;
        r4 = LarkContext.getApplication();
    L10:
        if (h.a(r4) == true) goto L13;
        return false;
    L13:
        if (r3 < ((a) b.getValue()).c) goto L16;
        return true;
    L16:
        return false;
    }

    public static boolean d(Context r2, CardContent.WidthMode r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "widthMode");
        if (b() == true) goto L5;
        return true;
    L5:
        int r0 = h.a;
        Context r4 = UIUtils.getActivityFromContext(r2);
        if (r4 != null) goto L10;
        r4 = LarkContext.getApplication();
    L10:
        if (h.a(r4) == true) goto L13;
        return true;
    L13:
        if (b.a[r3.ordinal()] == 1) goto L17;
        return false;
    L17:
        return true;
    }

    public static int a(Context r1, int r2, CardContent.WidthMode r3) {
        Intrinsics.checkNotNullParameter(r1, "context");
        Intrinsics.checkNotNullParameter(r3, "widthMode");
        if (b() == true) goto L5;
        return r2;
    L5:
        int r0 = h.a;
        Context r4 = UIUtils.getActivityFromContext(r1);
        if (r4 != null) goto L10;
        r4 = LarkContext.getApplication();
    L10:
        if (h.a(r4) == true) goto L12;
        return r2;
    L12:
        int r5 = b.a[r3.ordinal()];
        if (r5 != 1) goto L15;
        return r2;
    L15:
        if (r5 == 2) goto L18;
        return Math.min(r2, ((a) b.getValue()).a);
    L18:
        return Math.min(r2, ((a) b.getValue()).b);
    }
}
