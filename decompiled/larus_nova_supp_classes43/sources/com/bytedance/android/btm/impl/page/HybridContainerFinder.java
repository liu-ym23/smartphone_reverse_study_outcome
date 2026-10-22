package com.bytedance.android.btm.impl.page;

import android.app.Dialog;
import android.view.View;
import android.view.ViewParent;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import com.bytedance.android.btm.api.BtmHostDependManager;
import com.bytedance.android.btm.api.BtmHybridContainer;
import com.bytedance.android.btm.api.i;
import com.bytedance.android.btm.api.inner.ALogger;
import com.bytedance.android.btm.api.inner.g$a;
import com.bytedance.android.btm.impl.monitor.BtmMonitor;
import com.bytedance.android.btm.impl.page.model.d;
import com.bytedance.android.btm.impl.page.model.h;
import com.bytedance.android.btm.impl.util.f;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class HybridContainerFinder {
    public static final String a = "HybridContainerFinder_find";
    public static final String b = "finder";
    public static final HybridContainerFinder c = null;

    public HybridContainerFinder() {
    }

    static {
        c = new HybridContainerFinder();
        a = "HybridContainerFinder_find";
        b = "finder";
    }

    public static boolean b(Object r10) {
        if (r10 != null) goto L5;
        return false;
    L5:
        BtmHostDependManager.F.getClass();
        Iterator r1 = ((CopyOnWriteArraySet) BtmHostDependManager.A.getValue()).iterator();
    L7:
        if (r1.hasNext() == false) goto L13;
        i r11 = (i) r1.next();
        if (Intrinsics.areEqual(r11.a, r10.getClass()) == true) goto L12;
        if (r10.getClass().getName().equals(r11.b) == false) goto L7;
    L12:
        return true;
    L13:
        BtmHostDependManager r12 = BtmHostDependManager.F;
        r12.getClass();
        if (((Boolean) BtmHostDependManager.t.getValue(r12, BtmHostDependManager.a[18])).booleanValue() == true) goto L23;
    L22:
        return false;
    L23:
        Result.Companion r13 = Result.Companion;     // Catch: Throwable -> L20
        if (((BtmHybridContainer) r10.getClass().getAnnotation(BtmHybridContainer.class)) == null) goto L18;
        return true;
    L18:
        Result.constructor-impl(null);     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        Result.Companion r14 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L22
    }

    public final synchronized Object a(View r10) {
        monitor-enter(this);
        final String r0 = r10.getClass().getName();     // Catch: Throwable -> L52
        ALogger.j(ALogger.d, a, new HybridContainerFinder$find$1(r0));     // Catch: Throwable -> L52
        View r1 = r10;
    L4:
        ViewParent r11 = null;
        if (r1 == null) goto L35;
        String r12 = BtmPageRecorder.a;     // Catch: Throwable -> L52
        if (((ArrayList) BtmPageRecorder.q).contains(new f(r1)) == true) goto L8;
        Fragment r13 = BtmPageRecorder.d(r1);     // Catch: Throwable -> L52
        if (r13 != null) goto L12;
        f<DialogFragment> r14 = BtmPageRecorder.o.get(new f(r1));     // Catch: Throwable -> L52
        if (r14 == null) goto L18;
        DialogFragment r15 = r14.get();     // Catch: Throwable -> L52
    L19:
        if (r15 != null) goto L20;
        f<Dialog> r16 = BtmPageRecorder.p.get(new f(r1));     // Catch: Throwable -> L52
        if (r16 == null) goto L26;
        Dialog r17 = r16.get();     // Catch: Throwable -> L52
    L27:
        if (r17 != null) goto L28;
        ViewParent r18 = r1.getParent();     // Catch: Throwable -> L52
        if ((r18 instanceof View) == false) goto L34;
        r11 = r18;
    L34:
        r1 = (View) r11;     // Catch: Throwable -> L52
        goto L4
    L28:
        monitor-exit(this);
        return r17;
    L26:
        r17 = null;
        goto L27
    L20:
        monitor-exit(this);
        return r15;
    L18:
        r15 = null;
        goto L19
    L12:
        monitor-exit(this);
        return r13;
    L8:
        monitor-exit(this);
        return r1;
    L35:
        h r19 = PageWoods.a(r10);     // Catch: Throwable -> L52
        if (r19 == null) goto L38;
        d r110 = r19.c;     // Catch: Throwable -> L52
    L40:
        if (r110 != null) goto L42;
    L43:
        if (r110 != null) goto L45;
    L49:
        g$a.a(BtmMonitor.c, 1114, "find page error, view: " + r0, null, new HybridContainerFinder$find$2(r0), 28);     // Catch: Throwable -> L52
        monitor-exit(this);
        return null;
    L45:
        if (r110.isContainer() != true) goto L49;
    L46:
        Object r111 = r110.a();     // Catch: Throwable -> L52
        monitor-exit(this);
        return r111;
    L42:
        if (r110.i() == true) goto L46;
    L38:
        r110 = null;
    L52:
        th = move-exception;
        throw th;
    }
}
