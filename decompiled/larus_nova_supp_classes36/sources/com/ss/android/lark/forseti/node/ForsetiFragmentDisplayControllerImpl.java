package com.ss.android.lark.forseti.node;

import android.view.ViewTreeObserver;
import androidx.fragment.app.Fragment;
import com.ss.android.lark.api.bean.ForsetiWidth;
import com.ss.android.lark.featuregating.FeatureGatingModule;
import com.ss.android.lark.forseti.chain.ForsetiChainFragment;
import com.ss.android.lark.forseti.chain.ForsetiChainHelper;
import com.ss.android.lark.forseti.global.j;
import com.ss.android.lark.forseti.util.dragging.ForsetiColumnsDraggingHelper;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.ApiUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class ForsetiFragmentDisplayControllerImpl implements tua.c {
    public final Fragment a;
    public final ForsetiChainHelper b;
    public final Lazy c;
    public final Lazy d;
    public final ForsetiNode e;
    public final tua.b f;
    public final zua.a g;
    public boolean h;

    public static final class a implements ViewTreeObserver.OnGlobalLayoutListener {
        public final /* synthetic */ ForsetiFragmentDisplayControllerImpl a;

        public a(ForsetiFragmentDisplayControllerImpl r1) {
            this.a = r1;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public final void onGlobalLayout() {
            ForsetiFragmentDisplayControllerImpl.e(this.a);
        }
    }

    public static final class b implements ViewTreeObserver.OnGlobalLayoutListener {
        public final /* synthetic */ ForsetiFragmentDisplayControllerImpl a;

        public b(ForsetiFragmentDisplayControllerImpl r1) {
            this.a = r1;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public final void onGlobalLayout() {
            ForsetiFragmentDisplayControllerImpl.e(this.a);
        }
    }

    public final boolean f() {
        return ((Boolean) this.c.getValue()).booleanValue();
    }

    public static final void e(ForsetiFragmentDisplayControllerImpl r3) {
        boolean r1 = false;
        if (r3.e == null) goto L13;
        tua.b r0 = r3.f;
        if (r0 == null) goto L8;
        ForsetiWidth r2 = r0.F(r3.a);
    L10:
        if (r2 != ForsetiWidth.FULL) goto L13;
        r1 = true;
        goto L13
    L8:
        r2 = null;
    L13:
        if (r1 == r3.h) goto L18;
        r3.h = r1;
        Iterator r4 = r3.g.a.iterator();
    L16:
        if (r4.hasNext() == false) goto L20;
        ((tua.c.a) r4.next()).a(r1);
        goto L16
    L20:
        return;
    }

    public final void a(tua.c.a r3) {
        Intrinsics.checkNotNullParameter(r3, "listener");
        if (f() == true) goto L6;
        zua.a r1 = this.g;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r3, "listener");
        r1.a.remove(r3);
        return;
    L6:
        List<tua.c.a> r2 = j.a;
        Intrinsics.checkNotNullParameter(r3, "listener");
        ((ArrayList) j.a).remove(r3);
    }

    public final void b(tua.c.a r3) {
        Intrinsics.checkNotNullParameter(r3, "listener");
        if (f() == true) goto L8;
        zua.a r1 = this.g;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r3, "listener");
        if (r1.a.contains(r3) == true) goto L12;
        r1.a.add(r3);
        return;
    L12:
        return;
    L8:
        List<tua.c.a> r2 = j.a;
        Intrinsics.checkNotNullParameter(r3, "listener");
        ArrayList r0 = (ArrayList) j.a;
        if (r0.contains(r3) == true) goto L13;
        r0.add(r3);
        return;
    }

    public final void c(boolean r7) {
        ForsetiNode r0 = this.e;
        if (r0 != null) goto L5;
        return;
    L5:
        ForsetiChainHelper r1 = this.b;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r0, "srcNode");
        com.ss.android.lark.forseti.util.dragging.d r2 = com.ss.android.lark.forseti.util.dragging.d.a;
        r2.getClass();
        ForsetiWidth r3 = com.ss.android.lark.forseti.util.dragging.d.c;
        ForsetiNode r4 = r1.j;
        if (r4 == null) goto L12;
        if (Intrinsics.areEqual(r4, r0) == false) goto L12;
        r0 = r1.j;
    L12:
        if (r1.m == true) goto L18;
        ForsetiWidth r5 = r1.k;
        if (r5 == null) goto L18;
        r3 = r5;
    L18:
        int r6 = fib.a.a;
        if (FeatureGatingModule.getFeatureGatingService().isEnable("lark.forseti.full_screen_switch_disabled") == false) goto L28;
        if (r3 != null) goto L22;
        ForsetiWidth r8 = ForsetiWidth.AVERAGE_LEVEL;
    L23:
        com.ss.android.lark.forseti.util.dragging.d.c = r8;
        ForsetiColumnsDraggingHelper r9 = r1.f;
        if (r9 == null) goto L26;
        ForsetiWidth r10 = r9.a(r3);
    L27:
        com.ss.android.lark.forseti.util.dragging.d.b = r10;
        goto L28
    L26:
        r10 = null;
        goto L27
    L22:
        r8 = r3;
    L28:
        if (r7 == false) goto L39;
        if (r0 == null) goto L39;
        ForsetiWidth r11 = ForsetiChainHelper.d(r0);
        r2.getClass();
        ForsetiWidth r12 = com.ss.android.lark.forseti.util.dragging.d.c;
        if (r11 == null) goto L37;
        if (r12 == null) goto L37;
        ForsetiChainFragment.b r13 = r0.a.c;
        if (r13 == null) goto L39;
        r13.a(r11, r12);
    L37:
        Log.e("FST_Node", "startAdsorptionAnimation failed, from or to is null.");
    L39:
        if (f() == true) goto L41;
        return;
    L41:
        j.a(false);
    }

    public final void d(boolean r6) {
        ForsetiNode r0 = this.e;
        if (r0 != null) goto L5;
        return;
    L5:
        ForsetiChainHelper r1 = this.b;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r0, "srcNode");
        ForsetiWidth r2 = ForsetiChainHelper.d(r0);
        r1.j = r0;
        r1.k = r2;
        int r3 = fib.a.a;
        if (FeatureGatingModule.getFeatureGatingService().isEnable("lark.forseti.full_screen_switch_disabled") == true) goto L23;
        ForsetiNode r4 = r1.j;
        if (r4 != null) goto L10;
    L13:
        if (r6 == false) goto L28;
        if (r0 == null) goto L28;
        ForsetiWidth r7 = ForsetiChainHelper.d(r0);
        ForsetiWidth r5 = ForsetiWidth.FULL;
        if (r7 == null) goto L22;
        if (r5 == null) goto L22;
        ForsetiChainFragment.b r8 = r0.a.c;
        if (r8 == null) goto L28;
        r8.a(r7, r5);
    L22:
        Log.e("FST_Node", "startAdsorptionAnimation failed, from or to is null.");
    L28:
        if (f() == true) goto L30;
        return;
    L30:
        j.a(true);
        return;
    L10:
        if (Intrinsics.areEqual(r4, r0) == false) goto L13;
        r0 = r1.j;
        goto L13
    L23:
        com.ss.android.lark.forseti.util.dragging.d r9 = com.ss.android.lark.forseti.util.dragging.d.a;
        ForsetiWidth r10 = ForsetiWidth.FULL;
        r9.getClass();
        if (r10 != null) goto L26;
        r10 = ForsetiWidth.AVERAGE_LEVEL;
    L26:
        com.ss.android.lark.forseti.util.dragging.d.c = r10;
        com.ss.android.lark.forseti.util.dragging.d.b = r2;
        goto L28
    }

    public ForsetiFragmentDisplayControllerImpl(Fragment r4, ForsetiChainHelper r5) {
        Intrinsics.checkNotNullParameter(r4, "fragment");
        Intrinsics.checkNotNullParameter(r5, "chainHelper");
        this.a = r4;
        this.b = r5;
        this.c = LazyKt.lazy(ForsetiFragmentDisplayControllerImpl$forsetiNotificationNotUseObjectDisabled$2.INSTANCE);
        Lazy r0 = LazyKt.lazy(ForsetiFragmentDisplayControllerImpl$forsetiMemoryLeakFixDisabled$2.INSTANCE);
        this.d = r0;
        ForsetiNode r6 = r5.c(r4);
        ForsetiWidth r1 = null;
        if (r6 != null) goto L5;
        r6 = null;
    L12:
        this.e = r6;
        tua.b r2 = ((sua.a) ApiUtils.getApi(sua.a.class)).tryGetChainManager(r4.getActivity());
        this.f = r2;
        this.g = new zua.a();
        boolean r3 = false;
        if (r6 == null) goto L20;
        if (r2 == null) goto L18;
        r1 = r2.F(r4);
    L18:
        if (r1 != ForsetiWidth.FULL) goto L20;
        r3 = true;
    L20:
        this.h = r3;
        return;
    L5:
        if (f() == true) goto L12;
        if (((Boolean) r0.getValue()).booleanValue() == true) goto L10;
        com.ss.android.lark.api.util.c.b(r6.h, new a(this));
        goto L12
    L10:
        com.ss.android.lark.api.util.c.a(r6.h, new b(this));
        goto L12
    }
}
