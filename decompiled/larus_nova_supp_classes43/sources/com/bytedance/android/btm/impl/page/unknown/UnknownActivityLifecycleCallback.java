package com.bytedance.android.btm.impl.page.unknown;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.view.View;
import bd.c;
import com.bytedance.android.btm.api.BtmHostDependManager;
import com.bytedance.android.btm.api.inner.ALogger;
import com.bytedance.android.btm.impl.page.BtmPageRecorder;
import com.bytedance.android.btm.impl.page.BufferQueue;
import com.bytedance.android.btm.impl.page.lifecycle.layer3.BtmPageLifecycleCallbackV2;
import com.bytedance.android.btm.impl.page.model.PageInfo;
import com.bytedance.android.btm.impl.page.model.i;
import com.bytedance.android.btm.impl.pageshow.PageShowLog;
import com.bytedance.android.btm.impl.setting.BtmSetting;
import com.bytedance.android.btm.impl.util.d;
import com.bytedance.android.btm.impl.util.f;
import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class UnknownActivityLifecycleCallback implements Application.ActivityLifecycleCallbacks {
    public static final Set<c> a = null;
    public static final UnknownActivityLifecycleCallback b = null;

    public UnknownActivityLifecycleCallback() {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity r1) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity r1) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity r1) {
    }

    static {
        b = new UnknownActivityLifecycleCallback();
        a = new LinkedHashSet();
    }

    public static boolean a(Activity r1) {
        String r10 = r1.getClass().getName();
        BtmHostDependManager.F.getClass();
        return ((CopyOnWriteArraySet) BtmHostDependManager.B.getValue()).contains(r10);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity r10) {
        if (BtmSetting.d.c().c().L() == 1) goto L5;
        return;
    L5:
        if (a(r10) == false) goto L8;
        return;
    L8:
        if ((!Intrinsics.areEqual((Boolean) ((LinkedHashMap) BtmPageRecorder.s).get(new f(r10)), Boolean.TRUE)) == false) goto L13;
        b.c(r10);
        Iterator<T> r0 = a.iterator();
    L11:
        if (r0.hasNext() == false) goto L13;
        ((c) r0.next()).b();
    L13:
        UnknownPageInfo r1 = b.a.remove(r10);
        BtmPageRecorder.s.remove(new f(r10));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity r10) {
        BtmSetting r0 = BtmSetting.d;
        if (r0.c().c().L() == 1) goto L5;
        return;
    L5:
        if (a(r10) == true) goto L19;
        Map<f<Activity>, Boolean> r1 = BtmPageRecorder.s;
        LinkedHashMap r11 = (LinkedHashMap) r1;
        if (Intrinsics.areEqual((Boolean) r11.get(new f(r10)), Boolean.TRUE) == false) goto L10;
        return;
    L10:
        final UnknownPageInfo r12 = b.c(r10);
        ALogger.l(ALogger.d, "UnknownActivity_Paused", new AnonymousClass1(r12));
        UnionBufferBtm r13 = UnionBufferQueue.a;
        UnionBufferQueue.b(r12, r12.getBufferBtm());
        if (r0.c().b().T() != 1) goto L13;
        String r14 = BufferQueue.a;
        BufferQueue.k(r12.getBufferBtm());
    L13:
        Iterator<T> r15 = a.iterator();
    L15:
        if (r15.hasNext() == false) goto L20;
        ((c) r15.next()).a();
        goto L15
    L20:
        return;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPostResumed(Activity r10) {
        BtmSetting r0 = BtmSetting.d;
        if (r0.c().c().L() == 1) goto L5;
        return;
    L5:
        if (a(r10) == false) goto L8;
        return;
    L8:
        if (Intrinsics.areEqual((Boolean) ((LinkedHashMap) BtmPageRecorder.s).get(new f(r10)), Boolean.TRUE) == false) goto L10;
        return;
    L10:
        final UnknownPageInfo r11 = b.a(r10);
        final i r1 = BtmPageLifecycleCallbackV2.h;
        if (r1 == null) goto L13;
        PageInfo r12 = r1.b;
    L14:
        ALogger.l(ALogger.d, "UnknownActivity_PostResumed", new C02401(r11, r1));
        if (r12 == null) goto L29;
        if (r1.d == true) goto L29;
        if (r11.getUnionStep() <= r12.getUnionStep()) goto L24;
        if ((r0.c().b().S() & 1) == 0) goto L24;
        PageShowLog.e.getClass();
        PageShowLog.i(r12, false, null, null);
        r12.resetDataAfterPageShow();
        r1.d = true;
    L24:
        if (r11.getUnionStep() >= r12.getUnionStep()) goto L29;
        if ((r0.c().b().S() & 2) == 0) goto L29;
        PageShowLog.e.getClass();
        PageShowLog.i(r12, true, null, null);
        r12.resetDataAfterPageShow();
        r1.d = true;
    L29:
        if (r0.c().b().U() != 1) goto L33;
        String r13 = BufferQueue.a;
        BufferQueue.k(r11.getBufferBtm());
        return;
    L33:
        return;
    L13:
        r12 = null;
        goto L14
    }

    public static void b(final String r10, View r11) {
        ALogger.l(ALogger.d, "UnknownActivity_onSchemaLoadSucceed", new UnknownActivityLifecycleCallback$onSchemaLoadSucceed$1(r10));
        if (r10.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        return;
    L8:
        if (BtmSetting.d.c().c().H() != 1) goto L19;
        Activity r12 = d.a.getActivity(r11);
        if (r12 == null) goto L17;
        View r1 = r12.getWindow().peekDecorView();
        if (r1 == null) goto L18;
        r1.setTag(2131364612, r10);
        b.c(r12).setSchema(r10.substring(0, RangesKt.coerceAtMost(100, r10.length() - 1)));
        return;
    L18:
        return;
    L17:
        return;
    L19:
        return;
    L5:
        r0 = false;
        goto L6
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity r10, Bundle r11) {
        if (BtmSetting.d.c().c().L() == 1) goto L5;
        return;
    L5:
        if (a(r10) == true) goto L21;
        Serializable r0 = null;
        if (r11 == null) goto L10;
        Serializable r12 = r11.getSerializable("unknown_page_info");
    L12:
        if ((r12 instanceof UnknownPageInfo) == false) goto L15;
        r0 = r12;
    L15:
        UnknownPageInfo r1 = (UnknownPageInfo) r0;
        if (r1 == null) goto L20;
        b.a.put(r10, r1);
        return;
    L20:
        return;
    L10:
        r12 = null;
        goto L12
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity r10, Bundle r11) {
        if (BtmSetting.d.c().c().L() == 1) goto L5;
        return;
    L5:
        if (a(r10) == true) goto L13;
        Map<f<Activity>, Boolean> r0 = BtmPageRecorder.s;
        LinkedHashMap r1 = (LinkedHashMap) r0;
        if (Intrinsics.areEqual((Boolean) r1.get(new f(r10)), Boolean.TRUE) == false) goto L10;
        return;
    L10:
        r11.putSerializable("unknown_page_info", b.c(r10));
        return;
    }
}
