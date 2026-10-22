package com.obric.clockwidgets;

import android.content.Context;
import android.util.Log;
import com.lynx.tasm.behavior.v0;
import com.obric.clockwidgets.ui.d;
import com.obric.clockwidgets.ui.g;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public abstract class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ConcurrentHashMap f11255a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final LinkedHashSet f11256b = null;

    static {
        f11255a = new ConcurrentHashMap();
        f11256b = new LinkedHashSet();
    }

    public static final void a(int r5, Context r10) {
        Intrinsics.checkNotNullParameter(r10, "ctx");
        Set r11 = (Set) f11255a.get(Integer.valueOf(r5));
        if (r11 != null) goto L5;
        return;
    L5:
        ArrayList r12 = v0.v(r5, r10);
        Set r13 = r11;
        Iterator r14 = CollectionsKt.toList(r13).iterator();
    L7:
        if (r14.hasNext() == false) goto L11;
        b r15 = (b) ((WeakReference) r14.next()).get();
        if (r15 == null) goto L7;
        Intrinsics.checkNotNullParameter(r12, "cities");
        ((g) r15).b(r12);
        goto L7
    L11:
        CollectionsKt.x(r13, ClockWidgetSdk$notifyCitiesChanged$1.INSTANCE);
    }

    public static final void b(boolean r5) {
        LinkedHashSet r10 = f11256b;
        List r11 = CollectionsKt.toList(r10);
        CollectionsKt.x(r10, ClockWidgetSdk$notifyClockInstallStateChanged$1.INSTANCE);
        Iterator r12 = r11.iterator();
    L4:
        if (r12.hasNext() == false) goto L12;
        a r13 = (a) ((WeakReference) r12.next()).get();     // Catch: Exception -> L10
        if (r13 == null) goto L4;
        ((d) r13).a(r5);     // Catch: Exception -> L10
    L10:
        e = move-exception;
        Log.e("ClockWidgetSdk", "Error notifying install listener", e);
        goto L4
    }

    public static final void c(final a r5) {
        Intrinsics.checkNotNullParameter(r5, "listener");
        CollectionsKt.x(f11256b, new ClockWidgetSdk$unregisterInstallListener$1(r5));
    }

    public static final void d(int r5, final b r10) {
        Intrinsics.checkNotNullParameter(r10, "listener");
        Set r11 = (Set) f11255a.get(Integer.valueOf(r5));
        if (r11 == null) goto L6;
        CollectionsKt.x(r11, new ClockWidgetSdk$unregisterListener$1(r10));
        return;
    }
}
