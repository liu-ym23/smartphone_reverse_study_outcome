package com.bytedance.android.btm.impl.page.lifecycle.layer1_inner;

import android.app.Activity;
import com.bytedance.android.btm.api.inner.ALogger;
import com.bytedance.android.btm.api.inner.g$a;
import com.bytedance.android.btm.impl.monitor.BtmMonitor;
import com.bytedance.android.btm.impl.page.BtmPageRecorder;
import com.bytedance.android.btm.impl.page.lifecycle.ResumeFuncOrigin;
import com.bytedance.android.btm.impl.page.lifecycle.layer2.FilterDispatcher;
import com.bytedance.android.btm.impl.page.model.h;
import com.bytedance.android.btm.impl.setting.BtmSetting;
import com.bytedance.android.btm.impl.util.d;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class BackInternalResumer extends BaseBackResumer {
    public static final BackInternalResumer e = null;

    static {
        e = new BackInternalResumer();
    }

    public BackInternalResumer() {
        super(ResumeFuncOrigin.BackInternal, 1042, 1023);
    }

    public final void k(Object r10, final String r11) {
        Activity r0 = d.a.getActivity(r10);
        if (r0 == null) goto L5;
        final String r1 = r0.getClass().getName();
    L6:
        g$a.a(BtmMonitor.c, this.d, null, r10, new BackInternalResumer$monitorZero$1(r1, r11), 26);
        return;
    L5:
        r1 = "null";
        goto L6
    }

    public final void l(final Object r14, final com.bytedance.android.btm.impl.page.model.d r15) {
        ALogger.e(ALogger.d, "BackInternalResumer_tryResumePrePage", new BackInternalResumer$tryResumePrePage$1(r14, r15));
        if (r15 != null) goto L5;
        return;
    L5:
        h r0 = r15.b();
        int r10 = 0;
        if (r0 == null) goto L17;
        Collection<? extends com.bytedance.android.btm.impl.page.model.d> r1 = r0.n();
        if (r1 == null) goto L17;
        Iterator<T> r11 = r1.iterator();
        int r12 = 0;
    L11:
        if (r11.hasNext() == false) goto L18;
        com.bytedance.android.btm.impl.page.model.d r13 = (com.bytedance.android.btm.impl.page.model.d) r11.next();
        if (r13.i() == false) goto L11;
        if ((!Intrinsics.areEqual(r13, r15)) == false) goto L11;
        r12 = r12 + 1;
    L18:
        if (r12 != 0) goto L21;
        ALogger.e(ALogger.d, "BackInternalResumer_tryResumePrePage", BackInternalResumer$tryResumePrePage$3.INSTANCE);
        return;
    L21:
        com.bytedance.android.btm.impl.page.model.d r16 = r15;
        int r17 = 0;
    L22:
        Object r18 = null;
        if (r16 == null) goto L25;
        com.bytedance.android.btm.impl.page.model.d r19 = r16.j();
    L27:
        if (r19 == null) goto L39;
        if (r17 >= 3) goto L39;
        com.bytedance.android.btm.impl.page.model.d r20 = r16.j();
        if (r20 == null) goto L33;
        r18 = r20.a();
    L33:
        if (r18 == null) goto L37;
        String r21 = FilterDispatcher.a;
        if (FilterDispatcher.e(r18, this.b) != null) goto L37;
        return;
    L37:
        r16 = r16.j();
        r17 = r17 + 1;
    L39:
        if (BtmSetting.d.c().b().l() == 1) goto L61;
        com.bytedance.android.btm.impl.page.model.d r22 = r15;
    L41:
        if (r22 == null) goto L43;
        com.bytedance.android.btm.impl.page.model.d r23 = r22.getParentNode();
    L44:
        if (r23 == null) goto L61;
        com.bytedance.android.btm.impl.page.model.d r24 = r22.getParentNode();
        if (r24 == null) goto L59;
        if (r24.i() != true) goto L59;
        if (r10 >= 3) goto L61;
        com.bytedance.android.btm.impl.page.model.d r25 = r22.getParentNode();
        if (r25 == null) goto L54;
        Object r26 = r25.a();
    L55:
        if (r26 == null) goto L59;
        String r27 = FilterDispatcher.a;
        if (FilterDispatcher.e(r26, this.b) != null) goto L59;
        return;
    L54:
        r26 = null;
    L59:
        r22 = r22.getParentNode();
        r10 = r10 + 1;
        goto L41
    L43:
        r23 = null;
    L61:
        if (BtmSetting.d.c().b().m() != 0) goto L64;
        k(r14, "");
        return;
    L64:
        new LinkedHashSet();
        LinkedHashSet r28 = new LinkedHashSet();
        h r29 = r15.b();
        if (r29 == null) goto L77;
        Collection<? extends com.bytedance.android.btm.impl.page.model.d> r30 = r29.n();
        if (r30 == null) goto L77;
        Iterator<T> r31 = r30.iterator();
    L70:
        if (r31.hasNext() == false) goto L77;
        com.bytedance.android.btm.impl.page.model.d r32 = (com.bytedance.android.btm.impl.page.model.d) r31.next();
        Object r33 = r32.a();
        if ((!Intrinsics.areEqual(r32.h(), r15.h())) == false) goto L70;
        if (r33 == null) goto L70;
        String r34 = FilterDispatcher.a;
        if (FilterDispatcher.a(r33, e.b) != null) goto L70;
        r28.add(r33);
    L77:
        final int r35 = r28.size();
        ALogger r36 = ALogger.d;
        ALogger.e(r36, "BackInternalResumer_tryResumePrePage", new BackInternalResumer$tryResumePrePage$4$1(r35));
        if (r35 != 0) goto L81;
        e.k(r28, "filter");
        return;
    L81:
        if (r35 != 1) goto L84;
        String r110 = FilterDispatcher.a;
        FilterDispatcher.f(CollectionsKt.last(r28), e.b);
        return;
    L84:
        Set r111 = BaseBackResumer.f(r15.b(), r28);
        final int r37 = r111.size();
        ALogger.e(r36, "BackInternalResumer_tryResumePrePage", new BackInternalResumer$tryResumePrePage$5$1(r37));
        if (r37 != 0) goto L88;
        e.k(r111, "removeParent");
        return;
    L88:
        if (r37 != 1) goto L91;
        String r112 = FilterDispatcher.a;
        FilterDispatcher.f(CollectionsKt.last(r111), e.b);
        return;
    L91:
        Set r38 = BaseBackResumer.d(r111);
        final int r39 = r38.size();
        ALogger.e(r36, "BackInternalResumer_tryResumePrePage", new BackInternalResumer$tryResumePrePage$6$1(r39));
        if (r39 == 0) goto L97;
        if (r39 != 1) goto L96;
        String r113 = FilterDispatcher.a;
        FilterDispatcher.f(CollectionsKt.last(r38), e.b);
        return;
    L96:
        r111 = r38;
    L97:
        Set r114 = BaseBackResumer.a(r111);
        final int r40 = r114.size();
        ALogger.e(r36, "BackInternalResumer_tryResumePrePage", new BackInternalResumer$tryResumePrePage$7$1(r40));
        if (r40 != 0) goto L101;
        e.k(r114, "largeStep");
        return;
    L101:
        if (r40 != 1) goto L104;
        String r115 = FilterDispatcher.a;
        FilterDispatcher.f(CollectionsKt.last(r114), e.b);
        return;
    L104:
        ALogger.e(r36, "BackInternalResumer_tryResumePrePage", BackInternalResumer$tryResumePrePage$8.INSTANCE);
        String r41 = FilterDispatcher.a;
        FilterDispatcher.f(CollectionsKt.last(r114), this.b);
        final ArrayList r42 = new ArrayList();
        Iterator r116 = r114.iterator();
    L106:
        if (r116.hasNext() == false) goto L108;
        Object r43 = r116.next();
        String r44 = BtmPageRecorder.a;
        r42.add(BtmPageRecorder.j(r43));
        goto L106
    L108:
        Activity r117 = d.a.getActivity(r14);
        if (r117 == null) goto L111;
        final String r118 = r117.getClass().getName();
    L112:
        BtmMonitor.k(BtmMonitor.c, this.c, null, r14, null, false, false, null, false, new BackInternalResumer$monitorMulti$2(r42), new BackInternalResumer$monitorMulti$3(r118), 250);
        return;
    L111:
        r118 = "null";
        goto L112
    L25:
        r19 = null;
    L17:
        r12 = 0;
        goto L18
    }
}
