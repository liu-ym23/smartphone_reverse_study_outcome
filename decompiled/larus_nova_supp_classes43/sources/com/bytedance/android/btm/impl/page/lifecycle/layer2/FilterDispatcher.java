package com.bytedance.android.btm.impl.page.lifecycle.layer2;

import android.app.Activity;
import android.app.Dialog;
import android.view.View;
import androidx.fragment.app.Fragment;
import cd.b;
import com.bytedance.android.btm.api.PageProp;
import com.bytedance.android.btm.api.inner.ALogger;
import com.bytedance.android.btm.api.model.BufferBtm;
import com.bytedance.android.btm.impl.page.BtmPageRecorder;
import com.bytedance.android.btm.impl.page.PageWoods;
import com.bytedance.android.btm.impl.page.lifecycle.PauseFuncOrigin;
import com.bytedance.android.btm.impl.page.lifecycle.ResumeFilterReason;
import com.bytedance.android.btm.impl.page.lifecycle.ResumeFuncOrigin;
import com.bytedance.android.btm.impl.page.lifecycle.layer3.BtmPageLifecycleCallbackV2;
import com.bytedance.android.btm.impl.page.model.PageInfoStack;
import com.bytedance.android.btm.impl.page.model.d;
import com.bytedance.android.btm.impl.page.model.h;
import com.bytedance.android.btm.impl.setting.BtmSetting;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class FilterDispatcher {
    public static final String a = "FilterDispatcher_onCreated";
    public static final String b = "FilterDispatcher_onResumed";
    public static final String c = "FilterDispatcher_onPaused";
    public static final String d = "FilterDispatcher_onDestroyed";

    static {
        a = "FilterDispatcher_onCreated";
        b = "FilterDispatcher_onResumed";
        c = "FilterDispatcher_onPaused";
        d = "FilterDispatcher_onDestroyed";
    }

    public static void c(Object r10) {
        final String r0 = r10.getClass().getName();
        ALogger.f(ALogger.d, d, new FilterDispatcher$onDestroyed$1(r0));
        if ((r10 instanceof Activity) == false) goto L6;
        ActivityFilter.k.c(r10);
        return;
    L6:
        if ((r10 instanceof Fragment) == false) goto L9;
        FragmentFilter.o.j((Fragment) r10);
        return;
    L9:
        if ((r10 instanceof Dialog) == false) goto L12;
        DialogFilter.k.c(r10);
        return;
    L12:
        if ((r10 instanceof View) == false) goto L18;
        a.j.c(r10);
        return;
    }

    public static ResumeFilterReason a(Object r1, ResumeFuncOrigin r10) {
        if ((r1 instanceof Activity) == false) goto L7;
        return ActivityFilter.k.g((Activity) r1, r10);
    L7:
        if ((r1 instanceof Fragment) == false) goto L11;
        return FragmentFilter.o.h((Fragment) r1, r10);
    L11:
        if ((r1 instanceof Dialog) == false) goto L15;
        return DialogFilter.k.g((Dialog) r1, r10);
    L15:
        if ((r1 instanceof View) == false) goto L19;
        return a.j.b(r1, r10);
    L19:
        return ResumeFilterReason.Other;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1, types: [android.os.Bundle] */
    /* JADX WARN: Type inference failed for: r2v11 */
    public static void b(Object r12, final PageProp r13) {
        final String r0 = r12.getClass().getName();
        ALogger r1 = ALogger.d;
        ALogger.f(r1, a, new FilterDispatcher$onCreated$1(r0));
        final h r10 = 0;
        h r11 = null;
        if ((r12 instanceof Activity) == false) goto L6;
        ActivityFilter.k.getClass();
        ActivityFilter.h((Activity) r12, null, r13);
        return;
    L6:
        if ((r12 instanceof Fragment) == false) goto L9;
        FragmentFilter.o.getClass();
        FragmentFilter.i((Fragment) r12, null, r13);
        return;
    L9:
        if ((r12 instanceof Dialog) == false) goto L21;
        final Dialog r14 = (Dialog) r12;
        DialogFilter.k.getClass();
        final String r15 = r14.getClass().getName();
        String r16 = BtmPageRecorder.a;
        final PageInfoStack r17 = BtmPageRecorder.k(r14);
        if (r17 == null) goto L13;
        ALogger.f(r1, DialogFilter.h, new DialogFilter$onCreated$1(r15, r17));
        return;
    L13:
        ALogger.f(r1, DialogFilter.h, new DialogFilter$onCreated$2(r15, r10, r13));
        boolean r18 = BtmPageLifecycleCallbackV2.a;
        BufferBtm r19 = BtmPageLifecycleCallbackV2.b(r14, r13, false, null, null);
        d.d0.getClass();
        final d r20 = d.a.a(r14);
        r20.e(true, false);
        BtmSetting.d.c().b().n();
        Activity r21 = com.bytedance.android.btm.impl.util.d.a.getActivity(r14);
        if (r21 == null) goto L19;
        final Ref.ObjectRef r22 = new Ref.ObjectRef();
        h r23 = PageWoods.a(r21);
        r22.element = r23;
        if (r23 != null) goto L18;
        h r24 = new h(r21);
        r24.c.e(false, false);
        r22.element = r24;
        PageWoods.b(r24);
    L18:
        h r25 = (h) r22.element;
        r25.k(r20, r25.c);
        final String r26 = r14.getClass().getName();
        final boolean r110 = true;
        final boolean r111 = false;
        ALogger.f(r1, DialogFilter.i, new DialogFilter$buildPageTree$$inlined$let$lambda$1(r26, r22, r20, r14, r110, r111));
        r11 = (h) r22.element;
    L19:
        BaseFilter.a(r14, r11, r19);
        return;
    L21:
        if ((r12 instanceof View) == false) goto L49;
        final View r112 = (View) r12;
        a.j.getClass();
        final String r27 = r112.getClass().getName();
        ALogger.f(r1, a.h, new ViewFilter$onCreated$1(r27, r10, r13));
        PageProp[] r28 = {r13, b.a(r112)};
        int r113 = 0;
    L23:
        if (r113 >= 2) goto L31;
        final PageProp r29 = r28[r113];
        if (r29 == null) goto L27;
        boolean r30 = true;
    L28:
        if (r30 == true) goto L32;
        r113 = r113 + 1;
    L32:
        ALogger r114 = ALogger.d;
        ALogger.f(r114, a.h, new ViewFilter$onCreated$2(r27, r29));
        boolean r31 = BtmPageLifecycleCallbackV2.a;
        if (r29 != null) goto L35;
        Intrinsics.throwNpe();
    L35:
        BufferBtm r32 = BtmPageLifecycleCallbackV2.b(r112, r29, false, null, null);
        d.d0.getClass();
        final d r33 = d.a.a(r112);
        r33.e(true, false);
        BtmSetting.d.c().b().n();
        Activity r34 = com.bytedance.android.btm.impl.util.d.a.getActivity(r112);
        if (r34 == null) goto L41;
        final Ref.ObjectRef r35 = new Ref.ObjectRef();
        h r36 = PageWoods.a(r34);
        r35.element = r36;
        if (r36 != null) goto L40;
        h r37 = new h(r34);
        r37.c.e(false, false);
        r35.element = r37;
        PageWoods.b(r37);
    L40:
        h r38 = (h) r35.element;
        r38.k(r33, r38.c);
        final String r39 = r112.getClass().getName();
        final boolean r115 = true;
        final boolean r116 = false;
        ALogger.f(r114, a.i, new ViewFilter$buildPageTree$$inlined$let$lambda$1(r39, r35, r33, r112, r115, r116));
        r10 = (h) r35.element;
    L41:
        BaseFilter.a(r112, r10, r32);
        return;
    L27:
        r30 = false;
        goto L28
    L31:
        r29 = null;
        goto L32
    }

    public static void d(Object r10, PauseFuncOrigin r11) {
        final String r0 = r10.getClass().getName();
        ALogger.f(ALogger.d, c, new FilterDispatcher$onPaused$1(r0));
        if ((r10 instanceof Activity) == false) goto L6;
        ActivityFilter.k.d(r10, r11);
        return;
    L6:
        if ((r10 instanceof Fragment) == false) goto L9;
        FragmentFilter.o.d(r10, r11);
        return;
    L9:
        if ((r10 instanceof Dialog) == false) goto L12;
        DialogFilter.k.d(r10, r11);
        return;
    L12:
        if ((r10 instanceof View) == false) goto L18;
        a.j.d(r10, r11);
        return;
    }

    public static ResumeFilterReason e(Object r10, ResumeFuncOrigin r11) {
        final String r0 = r10.getClass().getName();
        ALogger.f(ALogger.d, b, new FilterDispatcher$onResumed$1(r0));
        if ((r10 instanceof Activity) == false) goto L7;
        return ActivityFilter.k.e(r10, r11);
    L7:
        if ((r10 instanceof Fragment) == false) goto L11;
        return FragmentFilter.o.e(r10, r11);
    L11:
        if ((r10 instanceof Dialog) == false) goto L15;
        return DialogFilter.k.e(r10, r11);
    L15:
        if ((r10 instanceof View) == false) goto L19;
        return a.j.e(r10, r11);
    L19:
        return ResumeFilterReason.Other;
    }

    public static void f(Object r1, ResumeFuncOrigin r10) {
        if ((r1 instanceof Activity) == false) goto L6;
        ActivityFilter.k.f(r1, r10);
        return;
    L6:
        if ((r1 instanceof Fragment) == false) goto L9;
        FragmentFilter.o.f(r1, r10);
        return;
    L9:
        if ((r1 instanceof Dialog) == false) goto L12;
        DialogFilter.k.f(r1, r10);
        return;
    L12:
        if ((r1 instanceof View) == false) goto L18;
        a.j.f(r1, r10);
        return;
    }
}
