package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.utils;

import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ExtendedToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.g3;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.x3;
import com.bytedance.android.livesdk.config.h21;
import com.bytedance.android.livesdk.reddot.RedDotDelegate;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class RedDotHelper {
    static {
    }

    public static void a(final x3 r6, final ExtendedToolbarButton r7, TreeSet r8) {
        c0.b r0 = r6.s(r7);
        final WeakReference r1 = new WeakReference(r0);
        if (r0 == null) goto L5;
        com.bytedance.android.livesdk.reddot.a r2 = r0.h7();
    L6:
        if (r2 != null) goto L8;
        return;
    L8:
        if (((Boolean) h21.b.getValue()).booleanValue() == false) goto L10;
        com.bytedance.android.livesdk.reddot.a r9 = r0.h7();
        Function0<Boolean> r3 = new RedDotHelper$addToSet$1(r1);
        int r4 = com.bytedance.android.livesdk.reddot.b.a;
        Intrinsics.checkNotNullParameter(r9, "redDot");
        Intrinsics.checkNotNullParameter(r8, "dotSet");
        RedDotDelegate r5 = new RedDotDelegate(r9);
        r5.g = r3;
        Intrinsics.checkNotNullParameter(r5, "redDotDelegate");
        Intrinsics.checkNotNullParameter(r8, "dotSet");
        r8.add(r5);
        r5.b = r8;
        r7.c = r5;
        return;
    L10:
        com.bytedance.android.livesdk.reddot.a r10 = r0.h7();
        Function0<Boolean> r11 = new RedDotHelper$addToSet$2(r7, r6);
        int r12 = com.bytedance.android.livesdk.reddot.b.a;
        Intrinsics.checkNotNullParameter(r10, "redDot");
        Intrinsics.checkNotNullParameter(r8, "dotSet");
        RedDotDelegate r13 = new RedDotDelegate(r10);
        r13.g = r11;
        Intrinsics.checkNotNullParameter(r13, "redDotDelegate");
        Intrinsics.checkNotNullParameter(r8, "dotSet");
        r8.add(r13);
        r13.b = r8;
        r7.c = r13;
        return;
    L5:
        r2 = null;
        goto L6
    }

    @JvmStatic
    public static final void b(List<? extends ExtendedToolbarButton> r1, x3 r2, TreeSet<RedDotDelegate> r3) {
        Intrinsics.checkNotNullParameter(r3, "dotSet");
        if (r2 != null) goto L5;
        return;
    L5:
        if (r1 == null) goto L10;
        Iterator<T> r4 = r1.iterator();
    L8:
        if (r4.hasNext() == false) goto L12;
        a(r2, (ExtendedToolbarButton) r4.next(), r3);
        goto L8
    L12:
        return;
    }

    @JvmStatic
    public static final void c(List r3, g3 r4, TreeSet r5, Function1 r6) {
        Intrinsics.checkNotNullParameter(r5, "dotSet");
        if (r4 != null) goto L5;
        return;
    L5:
        if (r3 == null) goto L15;
        Iterator r7 = r3.iterator();
    L8:
        if (r7.hasNext() == false) goto L22;
        ToolbarButton r0 = (ToolbarButton) r7.next();
        if (r6 == null) goto L14;
        if (((Boolean) r6.invoke(r0)).booleanValue() == true) goto L8;
    L14:
        ExtendedToolbarButton.h.getClass();
        a(r4, ExtendedToolbarButton.a.a(r0), r5);
        goto L8
    L22:
        return;
    }
}
