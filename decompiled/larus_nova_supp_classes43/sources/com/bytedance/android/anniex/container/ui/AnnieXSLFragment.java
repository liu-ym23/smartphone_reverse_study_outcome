package com.bytedance.android.anniex.container.ui;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.anniex.salamander.AbsPageAndPopup;
import com.bytedance.android.anniex.salamander.SLPage;
import com.bytedance.ies.bullet.base.BulletSdk;
import com.bytedance.ies.bullet.base.core.common.Components;
import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.salamander.anniex.AnnieXBaseViewModel;
import com.bytedance.salamander.anniex.AnnieXCommonUIViewModel;
import com.bytedance.salamander.anniex.AnnieXPageViewKt;
import com.bytedance.salamander.anniex.AnnieXPlatformviewKt;
import com.bytedance.salamander.anniex.c1;
import com.bytedance.salamander.anniex.g3;
import com.bytedance.salamander.anniex.q0;
import com.bytedance.salamander.anniex.r0;
import com.bytedance.salamander.anniex.r7;
import com.bytedance.salamander.anniex.s0;
import com.bytedance.salamander.anniex.t0;
import com.bytedance.salamander.anniex.w1;
import com.relax.RelaxView;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/anniex/container/ui/AnnieXSLFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "a", "anniex_release"}, k = 1, mv = {1, 4, 3})
public final class AnnieXSLFragment extends Fragment {
    public com.bytedance.android.anniex.base.builder.b d;
    public String e;
    public String f;
    public r0 g;
    public ka.b h;
    public FrameLayout i;
    public boolean j;
    public String k;
    public SLPage l;
    public final Lazy m;
    public final com.bytedance.android.anniex.salamander.a n;
    public final AnnieXSLFragment$backPressedCallBack$1 o;

    public static final class a {
    }

    static {
    }

    /* JADX WARN: Type inference failed for: r0v6, types: [com.bytedance.android.anniex.container.ui.AnnieXSLFragment$backPressedCallBack$1] */
    public AnnieXSLFragment() {
        this.e = "default_bid";
        this.k = "";
        this.m = LazyKt.lazy(new AnnieXSLFragment$pageDelegate$2(this));
        int r0 = AbsPageAndPopup.t;
        this.n = new com.bytedance.android.anniex.salamander.a();
        this.o = new AnnieXSLFragment$backPressedCallBack$1(this);
    }

    public final void onDestroy() {
        super.onDestroy();
        SLPage r0 = this.l;
        SLPage r1 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("slPage");
        r0 = null;
    L5:
        r0.l();
        List r10 = com.bytedance.ies.bullet.core.a.b;
        com.bytedance.android.anniex.salamander.a r11 = this.n;
        Intrinsics.checkNotNullParameter(r11, "appStateListener");
        List r12 = com.bytedance.ies.bullet.core.a.b;
        if (r12.contains(r11) == false) goto L8;
        r12.remove(r11);
    L8:
        ka.b r13 = this.h;
        if (r13 == null) goto L16;
        SLPage r14 = this.l;
        if (r14 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("slPage");
    L14:
        r1.c();
        r13.a();
        return;
    L13:
        r1 = r14;
        goto L14
    }

    public final void onDetach() {
        super.onDetach();
        SLPage r0 = this.l;
        SLPage r1 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("slPage");
        r0 = null;
    L5:
        r0.getClass();
        if (this.h == null) goto L13;
        SLPage r10 = this.l;
        if (r10 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("slPage");
    L11:
        r1.c();
        return;
    L10:
        r1 = r10;
        goto L11
    }

    public final void onPause() {
        super.onPause();
        SLPage r0 = this.l;
        SLPage r10 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("slPage");
        r0 = null;
    L5:
        r0.getClass();
        AnnieXBaseViewModel r1 = this.g;
        if (r1 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("slPageViewModel");
        r1 = null;
    L8:
        r1.a().a().e();
        if (this.h == null) goto L16;
        SLPage r11 = this.l;
        if (r11 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("slPage");
    L14:
        r10.c();
        return;
    L13:
        r10 = r11;
        goto L14
    }

    public final void onResume() {
        super.onResume();
        SLPage r0 = this.l;
        SLPage r10 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("slPage");
        r0 = null;
    L5:
        r0.getClass();
        AnnieXBaseViewModel r1 = this.g;
        if (r1 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("slPageViewModel");
        r1 = null;
    L8:
        r1.a().a().d();
        if (this.h == null) goto L16;
        SLPage r11 = this.l;
        if (r11 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("slPage");
    L14:
        r10.c();
        return;
    L13:
        r10 = r11;
        goto L14
    }

    public final void onStart() {
        super.onStart();
        SLPage r0 = this.l;
        SLPage r1 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("slPage");
        r0 = null;
    L5:
        r0.getClass();
        if (this.h == null) goto L13;
        SLPage r10 = this.l;
        if (r10 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("slPage");
    L11:
        r1.c();
        return;
    L10:
        r1 = r10;
        goto L11
    }

    public final void onStop() {
        super.onStop();
        SLPage r0 = this.l;
        SLPage r1 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("slPage");
        r0 = null;
    L5:
        r0.getClass();
        if (this.h == null) goto L13;
        SLPage r10 = this.l;
        if (r10 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("slPage");
    L11:
        r1.c();
        return;
    L10:
        r1 = r10;
        goto L11
    }

    public final void S90(com.bytedance.android.anniex.base.builder.b r10) {
        Intrinsics.checkNotNullParameter(r10, "builder");
        this.d = r10;
        this.e = r10.b;
        String r0 = r10.c.getString("__x_inner_schema");
        this.f = r0;
        if (r0 == null) goto L5;
        UriProtector.parse(r0);
    L5:
        this.j = r10.c.getBoolean("bundle_annie_x_flow");
        String r1 = this.f;
        if (r1 == null) goto L8;
        this.k = q26.i.b(UriProtector.parse(r1), r10.c);
    L8:
        na.b r11 = (na.b) this.m.getValue();
        if (r11 == null) goto L12;
        r11.d();
        return;
    }

    public final void onConfigurationChanged(Configuration r10) {
        Intrinsics.checkNotNullParameter(r10, "newConfig");
        super.onConfigurationChanged(r10);
        SLPage r1 = this.l;
        SLPage r11 = null;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("slPage");
        r1 = null;
    L5:
        r1.j(r10);
        if (this.h == null) goto L13;
        SLPage r12 = this.l;
        if (r12 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("slPage");
    L11:
        r11.c();
        Intrinsics.checkNotNullParameter(r10, "newConfig");
        return;
    L10:
        r11 = r12;
        goto L11
    }

    public final void onCreate(Bundle r11) {
        super.onCreate(r11);
        FragmentActivity r1 = getActivity();
        SLPage r10 = null;
        if (r1 != null) goto L53;
    L9:
        if (r11 == null) goto L18;
        String r0 = r11.getString("bid");
        if (r0 != null) goto L13;
        r0 = "default_bid";
    L13:
        this.e = r0;
        String r12 = r11.getString("__x_inner_schema");
        this.f = r12;
        if (r12 == null) goto L16;
        UriProtector.parse(r12);
    L16:
        this.j = r11.getBoolean("bundle_annie_x_flow");
        com.bytedance.android.anniex.base.builder.b r13 = new com.bytedance.android.anniex.base.builder.b();
        String r14 = this.e;
        Intrinsics.checkNotNullParameter(r14, "<set-?>");
        r13.b = r14;
        r13.d(requireActivity());
        r13.b(r11);
        S90(r13);
    L18:
        if (this.l != null) goto L29;
        FragmentActivity r15 = requireActivity();
        String r16 = this.e;
        String r17 = this.k;
        String r18 = this.f;
        Intrinsics.checkNotNull(r18);
        com.bytedance.android.anniex.base.builder.b r19 = this.d;
        if (r19 == null) goto L23;
        Components r20 = r19.l;
        if (r20 == null) goto L23;
    L24:
        Components r21 = r20;
        if (r19 == null) goto L27;
        com.bytedance.android.anniex.base.lifecycle.a r22 = r19.f;
    L28:
        SLPage r23 = new SLPage(r15, r16, r17, r18, r21, r22);
        this.l = r23;
        this.g = r23.n();
        goto L29
    L27:
        r22 = null;
    L23:
        r20 = Components.Fragment;
    L29:
        SLPage r24 = this.l;
        if (r24 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("slPage");
        r24 = null;
    L32:
        Function1<Boolean, Unit> r25 = new AnonymousClass3(this);
        r24.getClass();
        Intrinsics.checkNotNullParameter(r25, "blockBackPress");
        r24.o = r25;
        SLPage r26 = this.l;
        if (r26 != null) goto L35;
        Intrinsics.throwUninitializedPropertyAccessException("slPage");
        r26 = null;
    L35:
        r26.k(r11);
        AnnieXCommonUIViewModel r110 = this.g;
        if (r110 != null) goto L38;
        Intrinsics.throwUninitializedPropertyAccessException("slPageViewModel");
        r110 = null;
    L38:
        w1 r111 = r110.m;
        if (r111 != null) goto L41;
        Intrinsics.throwUninitializedPropertyAccessException("_statusBarViewModel");
        r111 = null;
    L41:
        r111.update();
        if (this.h == null) goto L48;
        SLPage r112 = this.l;
        if (r112 != null) goto L46;
        Intrinsics.throwUninitializedPropertyAccessException("slPage");
    L47:
        r10.c();
        goto L48
    L46:
        r10 = r112;
    L48:
        List r113 = com.bytedance.ies.bullet.core.a.b;
        com.bytedance.android.anniex.salamander.a r114 = this.n;
        Intrinsics.checkNotNullParameter(r114, "appStateListener");
        List r27 = com.bytedance.ies.bullet.core.a.b;
        if (r27.contains(r114) == true) goto L55;
        r27.add(r114);
        return;
    L55:
        return;
    L53:
        boolean r28 = BulletSdk.a;     // Catch: Throwable -> L7
        BulletSdk.c(r1);     // Catch: Throwable -> L7
        HybridLogger.m("AnnieXSLFragment", "AnnieXSLFragment call BulletSdk.ensureDefaultBidReady success", null, null, 12);     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        HybridLogger r29 = HybridLogger.a;
        HybridLogger.i("AnnieXSLFragment", "AnnieXSLFragment call BulletSdk.ensureDefaultBidReady failed, message = " + th.getMessage(), null, 12);
        goto L9
    }

    public final void onSaveInstanceState(Bundle r10) {
        Intrinsics.checkNotNullParameter(r10, "outState");
        super.onSaveInstanceState(r10);
        r10.putString("bid", this.e);
        r10.putString("__x_inner_schema", this.f);
        r10.putBoolean("bundle_on_reload", true);
        r10.putBoolean("bundle_annie_x_flow", this.j);
    }

    public final void setArguments(Bundle r1) {
        super.setArguments(r1);
    }

    public final void setUserVisibleHint(boolean r10) {
        SLPage r0 = this.l;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("slPage");
        r0 = null;
    L5:
        r0.getClass();
        super.setUserVisibleHint(r10);
    }

    public final void onViewCreated(View r11, Bundle r12) {
        Intrinsics.checkNotNullParameter(r11, "view");
        super.onViewCreated(r11, r12);
        AnnieXCommonUIViewModel r10 = null;
        if (this.h == null) goto L8;
        SLPage r1 = this.l;
        if (r1 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("slPage");
        r1 = null;
    L7:
        r1.c();
        Intrinsics.checkNotNullParameter(r11, "view");
    L8:
        if (r12 == null) goto L12;
        boolean r13 = true;
        if (r12.getBoolean("bundle_on_reload") != true) goto L12;
    L14:
        if (r13 == false) goto L22;
        AnnieXBaseViewModel r14 = this.g;
        if (r14 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("slPageViewModel");
        r14 = null;
    L18:
        r14.getClass();
        com.bytedance.salamander.anniex.l r15 = new com.bytedance.salamander.anniex.l(r14);
        g3 r16 = r14.a().a;
        if (r16 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("_engine");
        r16 = null;
    L21:
        r16.b(r15);
    L22:
        int r17 = q0.a;
        AnnieXCommonUIViewModel r18 = this.g;
        if (r18 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("slPageViewModel");
        r18 = null;
    L25:
        FrameLayout r19 = this.i;
        if (r19 != null) goto L28;
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
        r19 = null;
    L28:
        AnonymousClass1 r20 = AnonymousClass1.INSTANCE;
        Intrinsics.checkNotNullParameter(r18, "viewModel");
        t0 r21 = r18.f().a();
        int r22 = c1.a;
        RelaxView r23 = c1.a.a(new r7(AnnieXPageViewKt.a, new s0(r18), r21, r20));
        if (r19 == null) goto L32;
        if (r23 == null) goto L32;
        AnnieXPlatformviewKt.a.invoke(r19, r23);
    L32:
        Intrinsics.checkNotNull(r23, "null cannot be cast to non-null type android.view.ViewGroup{ com.bytedance.salamander.anniex.AnnieXPlatformviewKt.AnnieXPlatformRootView }");
        SLPage r24 = this.l;
        if (r24 != null) goto L35;
        Intrinsics.throwUninitializedPropertyAccessException("slPage");
        r24 = null;
    L35:
        r24.m(r11, r12);
        requireActivity().getOnBackPressedDispatcher().addCallback(getViewLifecycleOwner(), this.o);
        AnnieXSLFragment$backPressedCallBack$1 r110 = this.o;
        AnnieXCommonUIViewModel r111 = this.g;
        if (r111 != null) goto L38;
        Intrinsics.throwUninitializedPropertyAccessException("slPageViewModel");
    L39:
        r110.setEnabled(r10.e());
        return;
    L38:
        r10 = r111;
    L12:
        r13 = false;
        goto L14
    }

    public final void onActivityResult(int r10, int r11, Intent r12) {
        super.onActivityResult(r10, r11, r12);
        SLPage r0 = this.l;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("slPage");
        r0 = null;
    L5:
        r0.getClass();
        na.b r1 = (na.b) this.m.getValue();
        if (r1 == null) goto L9;
        r1.onActivityResult(r10, r11, r12);
        return;
    }

    public final View onCreateView(LayoutInflater r10, ViewGroup r11, Bundle r12) {
        Intrinsics.checkNotNullParameter(r10, "inflater");
        if (this.h == null) goto L8;
        SLPage r0 = this.l;
        if (r0 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("slPage");
        r0 = null;
    L7:
        r0.c();
        Intrinsics.checkNotNullParameter(r10, "inflater");
    L8:
        View r13 = r10.inflate(2131558569, r11, false);
        Intrinsics.checkNotNull(r13, "null cannot be cast to non-null type android.widget.FrameLayout");
        this.i = (FrameLayout) r13;
        SLPage r14 = this.l;
        if (r14 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("slPage");
        r14 = null;
    L11:
        FrameLayout r15 = this.i;
        if (r15 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
        r15 = null;
    L14:
        r14.getClass();
        Intrinsics.checkNotNullParameter(r15, "viewGroup");
        Intrinsics.checkNotNullParameter(r15, "<set-?>");
        r14.j = r15;
        FrameLayout r16 = this.i;
        if (r16 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
        return null;
    L18:
        return r16;
    }
}
