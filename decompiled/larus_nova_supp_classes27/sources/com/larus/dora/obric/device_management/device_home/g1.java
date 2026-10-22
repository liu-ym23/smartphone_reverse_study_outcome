package com.larus.dora.obric.device_management.device_home;

import androidx.lifecycle.Lifecycle;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.dora.impl.databinding.LarusDoraPageObricDeviceHomeBinding;
import com.obric.oui.orecyclerview.widget.RecyclerView;
import com.obric.oui.titlebar.OFloatingTitleBar;
import java.util.Iterator;
import java.util.List;
import kotlin.Function;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.AdaptedFunctionReference;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final /* synthetic */ class g1 implements FlowCollector, FunctionAdapter {
    public final /* synthetic */ DoraObricDeviceHomeFragment a;

    public g1(DoraObricDeviceHomeFragment r1) {
        this.a = r1;
    }

    public final boolean equals(Object r3) {
        if ((r3 instanceof FlowCollector) == true) goto L5;
        return false;
    L5:
        if ((r3 instanceof FunctionAdapter) == true) goto L7;
        return false;
    L7:
        return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) r3).getFunctionDelegate());
    }

    public final Function<?> getFunctionDelegate() {
        return new AdaptedFunctionReference(2, this.a, DoraObricDeviceHomeFragment.class, "render", "render(Lcom/larus/dora/obric/device_management/device_home/DoraObricDeviceHomeViewModel$UiState;)V", 4);
    }

    public final int hashCode() {
        return getFunctionDelegate().hashCode();
    }

    public final Object emit(Object r18, Continuation r110) {
        DoraObricDeviceHomeViewModel.c r0 = (DoraObricDeviceHomeViewModel.c) r18;
        DoraObricDeviceHomeFragment r2 = this.a;
        int r3 = DoraObricDeviceHomeFragment.R;
        if (r2.getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.RESUMED) == false) goto L125;
        LarusDoraPageObricDeviceHomeBinding r4 = r2.f;
        if (r4 == null) goto L125;
        Integer r5 = null;
        int r6 = 0;
        if (r0.d == true) goto L11;
        r2.A = null;
        com.larus.utils.e1.o(r4.R);
        com.larus.utils.e1.o(r4.u);
        com.larus.utils.e1.o(r4.E);
        com.larus.utils.e1.o(r4.v);
        com.larus.utils.e1.o(r4.e);
        com.larus.utils.e1.o(r4.y);
        com.larus.utils.e1.o(r4.x);
        com.larus.utils.e1.o(r4.T);
        r2.za0(false);
        goto L125
    L11:
        if (r0.a != DoraObricDeviceHomeViewModel.PageState.Empty) goto L27;
        r2.A = null;
        com.larus.utils.e1.o(r4.R);
        com.larus.utils.e1.o(r4.u);
        com.larus.utils.e1.o(r4.E);
        com.larus.utils.e1.o(r4.v);
        com.larus.utils.e1.o(r4.e);
        com.larus.utils.e1.x(r4.y);
        com.larus.utils.e1.x(r4.x);
        if (r2.F == true) goto L21;
        LarusDoraPageObricDeviceHomeBinding r1 = r2.f;
        if (r1 == null) goto L20;
        OFloatingTitleBar r7 = r1.T;
        if (r7 == null) goto L20;
        r7.setStartTitle(null);
        r7.setCenterTitle(null);
        OFloatingTitleBar.V(r7, null, CollectionsKt.emptyList(), false, 7);
        r7.setMaskBlurRadius(0.0f);
    L20:
        r2.F = true;
    L21:
        com.larus.utils.e1.x(r4.T);
        r2.za0(false);
        if (r2.I == true) goto L125;
        if (r2.M == true) goto L125;
        r2.I = true;
        r2.ra0(DoraObricDeviceHomeViewModel.PREVIOUS_PAGE_DEVICE_HOME);
        goto L125
    L27:
        DoraObricGlassesModeSheet r8 = r2.getChildFragmentManager().findFragmentByTag("ObricGlassesModeSheet");
        if ((r8 instanceof DoraObricGlassesModeSheet) == false) goto L30;
        DoraObricGlassesModeSheet r9 = r8;
    L31:
        if (r9 == null) goto L53;
        Iterator<T> r10 = r0.f.iterator();
    L35:
        if (r10.hasNext() == false) goto L39;
        Object r11 = r10.next();
        if (Intrinsics.areEqual(((q) r11).a, r0.c) == false) goto L35;
    L40:
        q r12 = (q) r11;
        if (r12 == null) goto L53;
        h3 r13 = r12.d;
        if (r13 == null) goto L53;
        DoraObricGlassesMode r14 = r13.d;
        if (r14 == null) goto L53;
        Intrinsics.checkNotNullParameter(r14, "mode");
        if (r14 == DoraObricGlassesMode.UNKNOWN) goto L53;
        f3 r15 = r9.d;
        if (r15 != null) goto L52;
        r9.e = r14;
        goto L53
    L52:
        int r16 = c3.a;
        r9.d = c3.a(r15, new z2.a(r14)).a;
        r9.V90();
        goto L53
    L39:
        r11 = null;
    L53:
        DoraObricDeviceHomeFragment.f r17 = new DoraObricDeviceHomeFragment.f(r0.c, r0.j, r0.k, r0.l, r0.m, r0.e, r0.i);
        if (Intrinsics.areEqual(r2.A, r17) == true) goto L118;
        r2.A = r17;
        r2.na0(r0);
        List<m1> r20 = r0.l;
        LarusDoraPageObricDeviceHomeBinding r21 = r2.f;
        if (r21 == null) goto L67;
        RecyclerView r22 = r21.M;
        if (r22 == null) goto L67;
        if (r20.isEmpty() == false) goto L63;
        com.larus.utils.e1.o(r22);
    L64:
        n1 r23 = r2.r;
        if (r23 == null) goto L67;
        ((com.obric.oui.orecyclerview.widget.w) r23).c.b(r20, null);
        goto L67
    L63:
        com.larus.utils.e1.x(r22);
    L67:
        LarusDoraPageObricDeviceHomeBinding r24 = r2.f;
        if (r24 == null) goto L117;
        com.larus.utils.e1.o(r24.y);
        com.larus.utils.e1.o(r24.x);
        com.larus.utils.e1.x(r24.e);
        if (r2.F == false) goto L72;
        r2.wa0();
        r2.F = false;
    L72:
        r2.aa0(r0.m);
        Iterator<r1> r25 = r0.m.iterator();
        int r26 = 0;
    L73:
        int r111 = -1;
        if (r25.hasNext() == false) goto L82;
        if (r25.next().b != r2.ha0()) goto L78;
        boolean r27 = true;
    L79:
        if (r27 == true) goto L83;
        r26 = r26 + 1;
    L83:
        Integer r28 = Integer.valueOf(r26);
        if (r28.intValue() < 0) goto L86;
        boolean r30 = true;
    L87:
        if (r30 == true) goto L90;
        r28 = null;
    L90:
        if (r28 == null) goto L92;
        int r31 = r28.intValue();
    L94:
        if (((r1) ListProtector.get(r0.m, r31)).b == DoraObricDeviceHomeTabPage.DIARY) goto L96;
    L115:
        r6 = r31;
    L116:
        r2.j = Integer.valueOf(r6);
        r2.B.setValue(((r1) ListProtector.get(r0.m, r6)).b);
        r2.oa0(r6, r0);
        goto L117
    L96:
        if (r2.ia0().isDiaryEntryAvailable() == true) goto L115;
        Iterator<r1> r32 = r0.m.iterator();
        int r33 = 0;
    L99:
        if (r32.hasNext() == false) goto L107;
        if (r32.next().b != DoraObricDeviceHomeTabPage.DEVICE) goto L103;
        boolean r34 = true;
    L104:
        if (r34 == true) goto L105;
        r33 = r33 + 1;
        goto L99
    L105:
        r111 = r33;
        goto L107
    L103:
        r34 = false;
    L107:
        Integer r35 = Integer.valueOf(r111);
        if (r35.intValue() < 0) goto L110;
        boolean r36 = true;
    L111:
        if (r36 == false) goto L113;
        r5 = r35;
    L113:
        if (r5 == null) goto L116;
        r6 = r5.intValue();
        goto L116
    L110:
        r36 = false;
        goto L111
    L92:
        r31 = 0;
        goto L94
    L86:
        r30 = false;
        goto L87
    L78:
        r27 = false;
        goto L79
    L82:
        r26 = -1;
    L117:
        r4.T.setStartTitle(r0.e);
        r4.h.setTitleText(r0.i);
        r2.ma0(r0.m);
    L119:
        String r37 = DoraObricDeviceHomeFragment.ba0(r2.ha0());
        if (r2.I == true) goto L125;
        if (r2.M == true) goto L125;
        r2.I = true;
        r2.ra0(r37);
        goto L125
    L118:
        r2.na0(r0);
        goto L119
    L30:
        r9 = null;
    L125:
        Unit r38 = Unit.INSTANCE;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        return r38;
    }
}
