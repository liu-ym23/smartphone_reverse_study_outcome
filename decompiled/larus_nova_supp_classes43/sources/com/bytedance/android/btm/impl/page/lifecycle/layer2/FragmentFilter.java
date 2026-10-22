package com.bytedance.android.btm.impl.page.lifecycle.layer2;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import cd.b;
import com.bytedance.android.btm.api.BtmPageLifecycle;
import com.bytedance.android.btm.api.PageProp;
import com.bytedance.android.btm.api.inner.ALogger;
import com.bytedance.android.btm.api.model.BufferBtm;
import com.bytedance.android.btm.impl.page.BtmPageRecorder;
import com.bytedance.android.btm.impl.page.HybridContainerFinder;
import com.bytedance.android.btm.impl.page.PageWoods;
import com.bytedance.android.btm.impl.page.lifecycle.ResumeFilterReason;
import com.bytedance.android.btm.impl.page.lifecycle.ResumeFuncOrigin;
import com.bytedance.android.btm.impl.page.lifecycle.layer3.BtmPageLifecycleCallbackV2;
import com.bytedance.android.btm.impl.page.model.PageInfoStack;
import com.bytedance.android.btm.impl.page.model.d;
import com.bytedance.android.btm.impl.page.model.h;
import com.bytedance.android.btm.impl.setting.BtmSetting;
import com.bytedance.android.btm.impl.util.f;
import com.larus.home.impl.utils.c;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.io.Serializable;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class FragmentFilter extends BaseFilter<Fragment> {
    public static final String h = "FragmentFilter_";
    public static final String i = "FragmentFilter_onCreated";
    public static final String j = "FragmentFilter_observeView";
    public static final String k = "FragmentFilter_buildPageTree";
    public static final String l = "FragmentFilter_onFragmentViewCreated";
    public static final String m = "FragmentFilter_isResumeFiltered";
    public static final String n = "FragmentFilter_onFragmentActivityCreated";
    public static final FragmentFilter o = null;

    static {
        o = new FragmentFilter();
        h = "FragmentFilter_";
        i = "FragmentFilter_onCreated";
        j = "FragmentFilter_observeView";
        k = "FragmentFilter_buildPageTree";
        l = "FragmentFilter_onFragmentViewCreated";
        m = "FragmentFilter_isResumeFiltered";
        n = "FragmentFilter_onFragmentActivityCreated";
    }

    public FragmentFilter() {
    }

    public static void k(Fragment r10) {
        if ((r10 instanceof DialogFragment) == true) goto L5;
        return;
    L5:
        String r0 = BtmPageRecorder.a;
        PageInfoStack r1 = BtmPageRecorder.k(r10);
        if (r1 == null) goto L8;
        PageProp r11 = r1.getPageProp();
    L9:
        if (r11 == null) goto L11;
        boolean r12 = true;
    L12:
        String r13 = HybridContainerFinder.a;
        boolean r14 = HybridContainerFinder.b(r10);
        if (r12 == true) goto L15;
        if (r14 == true) goto L15;
        return;
    L15:
        Dialog r15 = ((DialogFragment) r10).getDialog();
        if (r15 == null) goto L28;
        Window r16 = r15.getWindow();
        if (r16 == null) goto L29;
        View r17 = r16.getDecorView();
        if (c.e == false) goto L24;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r18 = ThreadMethodProxy.currentThread();
        if (r18 == c.a) goto L24;
        c.a(r18, "getDecorView");
    L24:
        if (r17 == null) goto L30;
        final String r19 = r10.getClass().getName();
        BtmPageRecorder.o.put(new f(r17), new f(r10));
        ALogger.f(ALogger.d, n, new FragmentFilter$onFragmentActivityCreated$1$1(r19));
        return;
    L30:
        return;
    L29:
        return;
    L28:
        return;
    L11:
        r12 = false;
        goto L12
    L8:
        r11 = null;
        goto L9
    }

    public static void m(Fragment r10) {
        final String r11 = r10.getClass().getName();
        ALogger.f(ALogger.d, h + "onFragmentViewDestroyed", new FragmentFilter$onFragmentViewDestroyed$1(r11));
    }

    public final void j(Fragment r10) {
        c(r10);
        f r0 = new f(r10);
        Iterator<Map.Entry<f<View>, f<DialogFragment>>> r11 = BtmPageRecorder.o.entrySet().iterator();
    L4:
        if (r11.hasNext() == false) goto L9;
        Map.Entry<f<View>, f<DialogFragment>> r1 = r11.next();
        if (Intrinsics.areEqual(r1.getValue(), r0) == false) goto L4;
        BtmPageRecorder.o.remove(r1.getKey());
    L9:
        if (BtmSetting.d.c().d().v() == 1) goto L23;
        Iterator<Map.Entry<f<View>, f<Fragment>>> r12 = BtmPageRecorder.m.entrySet().iterator();
    L12:
        if (r12.hasNext() == false) goto L24;
        Map.Entry<f<View>, f<Fragment>> r13 = r12.next();
        if (Intrinsics.areEqual(r13.getValue(), r0) == false) goto L12;
        BtmPageRecorder.m.remove(r13.getKey());
        return;
    L24:
        return;
    }

    public static void l(Fragment r10, View r11) {
        final String r0 = r10.getClass().getName();
        final String r1 = r11.getClass().getName();
        ALogger.f(ALogger.d, l, new FragmentFilter$onFragmentViewCreated$1(r0, r1));
        String r12 = BtmPageRecorder.a;
        if (BtmSetting.d.c().d().v() != 1) goto L5;
        BtmPageRecorder.n.put(r11, new f(r10));
        return;
    L5:
        BtmPageRecorder.m.put(new f(r11), new f(r10));
    }

    @Override // com.bytedance.android.btm.impl.page.lifecycle.layer2.BaseFilter
    public final /* bridge */ /* synthetic */ ResumeFilterReason b(Fragment r1, ResumeFuncOrigin r10) {
        return h(r1, r10);
    }

    public final ResumeFilterReason h(final Fragment r10, final ResumeFuncOrigin r11) {
        final String r12 = r10.getClass().getName();
        ALogger r0 = ALogger.d;
        String r1 = m;
        ALogger.f(r0, r1, new FragmentFilter$isResumeFiltered$1(r12, r11));
        final ResumeFilterReason r13 = super.b(r10, r11);
        if (r13 == null) goto L6;
        ALogger.f(r0, r1, new FragmentFilter$isResumeFiltered$2(r12, r13));
        return r13;
    L6:
        String r14 = BtmPageRecorder.a;
        final PageInfoStack r15 = BtmPageRecorder.k(r10);
        if (r15 != null) goto L9;
        ALogger.f(r0, r1, new FragmentFilter$isResumeFiltered$$inlined$run$lambda$1(r12));
        return ResumeFilterReason.InfoStackNull;
    L9:
        if (r10.isAdded() == true) goto L11;
    L48:
        ALogger.f(r0, r1, new FragmentFilter$isResumeFiltered$$inlined$let$lambda$1(r10, r12, r11));
        return ResumeFilterReason.FragmentNotAttach;
    L11:
        if (r10.isRemoving() == true) goto L48;
        if (r10.isDetached() == true) goto L48;
        if (r11.isManual() == false) goto L20;
        ALogger.f(r0, r1, new FragmentFilter$isResumeFiltered$$inlined$let$lambda$2(r10, r12, r11));
        return null;
    L20:
        if (r15.getNativeState() == BtmPageLifecycle.State.RESUMED) goto L24;
        ALogger.f(r0, r1, new FragmentFilter$isResumeFiltered$$inlined$let$lambda$3(r10, r12, r11));
        return ResumeFilterReason.NativeStateError;
    L24:
        if (r11 != ResumeFuncOrigin.UserVisibleHint) goto L27;
        ALogger.f(r0, r1, new FragmentFilter$isResumeFiltered$$inlined$let$lambda$4(r10, r12, r11));
        return null;
    L27:
        final Ref.BooleanRef r16 = new Ref.BooleanRef();
        r16.element = r10.getUserVisibleHint();
        Fragment r17 = r10.getParentFragment();
    L28:
        if (r17 == null) goto L32;
        if (r16.element == false) goto L32;
        r16.element = r17.getUserVisibleHint();
        r17 = r17.getParentFragment();
    L32:
        boolean r18 = true;
        if (BtmSetting.d.c().b().c() != 1) goto L36;
        r18 = r16.element;
    L43:
        if (r18 == false) goto L46;
        ALogger.f(ALogger.d, m, new FragmentFilter$isResumeFiltered$$inlined$let$lambda$5(r10, r12, r11));
        return null;
    L46:
        ALogger.f(ALogger.d, m, new FragmentFilter$isResumeFiltered$$inlined$let$lambda$6(r16, r15, r10, r12, r11));
        return ResumeFilterReason.Invisible;
    L36:
        if (r15.getUserVisibleHint() != null) goto L40;
        if (r16.element == true) goto L43;
    L40:
        if (Intrinsics.areEqual(r15.getUserVisibleHint(), Boolean.TRUE) == true) goto L43;
        r18 = false;
        goto L43
    }

    public static void i(final Fragment r10, final Bundle r11, final PageProp r12) {
        final String r0 = r10.getClass().getName();
        String r1 = BtmPageRecorder.a;
        if (BtmPageRecorder.k(r10) == null) goto L7;
        if (r11 != null) goto L7;
        ALogger.f(ALogger.d, i, new FragmentFilter$onCreated$1(r0));
        return;
    L7:
        ALogger r13 = ALogger.d;
        String r14 = i;
        ALogger.f(r13, r14, new FragmentFilter$onCreated$2(r0, r11, r12));
        BufferBtm r15 = null;
        if (r11 == null) goto L10;
        Serializable r16 = r11.getSerializable("page_info_stack");
    L12:
        if ((r16 instanceof PageInfoStack) == true) goto L14;
        r16 = null;
    L14:
        PageInfoStack r17 = (PageInfoStack) r16;
        if (r17 == null) goto L19;
        PageProp r18 = r17.getPageProp();
        if (r18 == null) goto L19;
        r12 = r18;
    L19:
        if (r12 != null) goto L22;
        r12 = b.a(r10);
    L22:
        ALogger.f(r13, r14, new FragmentFilter$onCreated$3(r0, r12));
        if (r12 == null) goto L25;
        boolean r19 = true;
    L26:
        String r20 = HybridContainerFinder.a;
        boolean r21 = HybridContainerFinder.b(r10);
        if (r19 == false) goto L32;
        boolean r22 = BtmPageLifecycleCallbackV2.a;
        if (r12 != null) goto L31;
        Intrinsics.throwNpe();
    L31:
        r15 = BtmPageLifecycleCallbackV2.b(r10, r12, r21, r17, r11);
    L33:
        if (r21 == false) goto L35;
        BtmPageRecorder.l(r10);
    L35:
        if (r19 == true) goto L39;
        if (r21 == true) goto L39;
        ALogger.f(r13, r14, new FragmentFilter$onCreated$5(r0));
        return;
    L39:
        final String r23 = r10.getClass().getName();
        String r24 = j;
        ALogger.f(r13, r24, new FragmentFilter$observeView$1(r23));
        if (r10.getView() == null) goto L45;
        ALogger.f(r13, r24, new FragmentFilter$observeView$2(r23));
        View r25 = r10.getView();
        if (r25 != null) goto L44;
        Intrinsics.throwNpe();
    L44:
        l(r10, r25);
    L49:
        BaseFilter.a(r10, g(r10, r19, r21, r11), r15);     // Catch: Exception -> L48
        return;
    L52:
        return;
    L45:
        ALogger.f(r13, r24, new FragmentFilter$observeView$3(r23));
        r10.getViewLifecycleOwnerLiveData().observeForever(new FragmentFilter$observeView$4(r10));
        goto L49
    L32:
        ALogger.f(r13, r14, new FragmentFilter$onCreated$4(r0));
        goto L33
    L25:
        r19 = false;
        goto L26
    L10:
        r16 = null;
        goto L12
    }

    public static h g(final Fragment r10, final boolean r11, final boolean r12, Bundle r13) {
        d.d0.getClass();
        final d r14 = d.a.a(r10);
        r14.e(r11, r12);
        if (BtmSetting.d.c().b().n() != 1) goto L12;
        if (r13 == null) goto L8;
        String r0 = r13.getString("node_id");
        if (r0 == null) goto L8;
        r14.f(r0);
    L8:
        if (r13 == null) goto L12;
        String r15 = r13.getString("page_node");
        if (r15 == null) goto L12;
        d r16 = (d) r14.parse(r15);
    L12:
        FragmentActivity r17 = r10.getActivity();
        if (r17 == null) goto L43;
        final Ref.ObjectRef r1 = new Ref.ObjectRef();
        h r18 = PageWoods.a(r17);
        r1.element = r18;
        if (r18 != null) goto L18;
        h r19 = new h(r17);
        r19.c.e(false, false);
        r1.element = r19;
        PageWoods.b(r19);
    L18:
        if (r10.getParentFragment() != null) goto L20;
        h r110 = (h) r1.element;
        r110.k(r14, r110.c);
    L41:
        final String r20 = r10.getClass().getName();
        ALogger.f(ALogger.d, k, new FragmentFilter$buildPageTree$$inlined$let$lambda$1(r20, r1, r10, r14, r11, r12));
        return (h) r1.element;
    L20:
        Fragment r111 = r10.getParentFragment();
    L21:
        if (r111 == null) goto L31;
        if (b.a(r111) == null) goto L25;
        boolean r21 = true;
    L26:
        if (r21 == true) goto L31;
        String r22 = HybridContainerFinder.a;
        if (HybridContainerFinder.b(r111) == true) goto L31;
        r111 = r111.getParentFragment();
        goto L21
    L25:
        r21 = false;
    L31:
        if (r111 == null) goto L40;
        Iterator<T> r23 = ((h) r1.element).n().iterator();
    L34:
        if (r23.hasNext() == false) goto L41;
        d r24 = (d) r23.next();
        if (r24.a() != r111) goto L34;
        ((h) r1.element).k(r14, r24);
        if (BtmSetting.d.c().b().g() != 1) goto L34;
    L40:
        h r112 = (h) r1.element;
        r112.k(r14, r112.c);
        goto L41
    L43:
        return null;
    }
}
