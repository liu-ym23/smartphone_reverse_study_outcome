package com.bytedance.ai.view.popup;

import a3.f;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.appcompat.app.AppCompatDialogFragment;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.os.BundleKt;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.fragment.app.FragmentViewModelLazyKt;
import c.e0;
import cn.nubia.neopush.commons.Constant;
import com.bytedance.ai.api.model.view.AIFragmentBase;
import com.bytedance.ai.bridge.method.router.OpenPageMethod;
import com.bytedance.ai.model.objects.PageInfo;
import com.bytedance.ai.model.p;
import com.bytedance.ai.utils.c;
import com.bytedance.ai.view.popup.anim.AnimController$AnimProcessType;
import com.bytedance.ai.view.popup.anim.AnimationStyle;
import com.bytedance.ai.view.popup.anim.BottomSheetBehavior;
import com.bytedance.ai.view.popup.params.AppletPopupSchemaParam;
import com.bytedance.ai.view.popup.viewmodel.AppletPopupViewModel;
import com.ivy.ivykit.api.plugin.IIvyAIPackageResourceService;
import com.lynx.jsbridge.LynxResourceModule;
import com.obric.launcher.widget.R$id;
import com.obric.launcher.widget.R$layout;
import com.obric.oui.sheet.v2.j;
import com.obric.oui.titlebar.b;
import h3.a;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import ko.r;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import t0.d;
import td.e;
import w0.k;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0001\u0007B\u0007¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/bytedance/ai/view/popup/AppletPopup;", "Landroidx/appcompat/app/AppCompatDialogFragment;", "", "Landroid/view/View$OnAttachStateChangeListener;", "Landroid/view/ViewTreeObserver$OnWindowFocusChangeListener;", "<init>", "()V", "td/e", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nAppletPopup.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AppletPopup.kt\ncom/bytedance/ai/view/popup/AppletPopup\n+ 2 FragmentViewModelLazy.kt\nandroidx/fragment/app/FragmentViewModelLazyKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,1316:1\n57#2,3:1317\n1863#3,2:1320\n1#4:1322\n*S KotlinDebug\n*F\n+ 1 AppletPopup.kt\ncom/bytedance/ai/view/popup/AppletPopup\n*L\n110#1:1317,3\n501#1:1320,2\n*E\n"})
public final class AppletPopup extends AppCompatDialogFragment implements View.OnAttachStateChangeListener, ViewTreeObserver.OnWindowFocusChangeListener {
    public static final int L = 0;
    public final boolean A;
    public View B;
    public boolean C;
    public Integer[] D;
    public final RenderType E;
    public final Lazy F;
    public final Lazy G;
    public boolean H;
    public final a I;
    public final b J;
    public nh.b K;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f2852a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public FrameLayout f2853b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public LinearLayout f2854c;
    public RadiusLayout d;
    public FrameLayout e;
    public View f;
    public CoordinatorLayout g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ArrayList f2855h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public k3.b f2856i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public AppletPopupSchemaParam f2857j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public AIFragmentBase f2858k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public BottomSheetBehavior f2859l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final r f2860m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f2861n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f2862o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f2863p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f2864q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public a f2865r;
    public int s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f2866t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f2867u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public WindowInsetsCompat f2868v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f2869w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f2870x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f2871y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final boolean f2872z;

    static {
        L = (int) ((20.0f * Resources.getSystem().getDisplayMetrics().density) + 0.5f);
    }

    public AppletPopup() {
        this.f2852a = (int) ((100.0f * Resources.getSystem().getDisplayMetrics().density) + 0.5f);
        this.f2855h = new ArrayList();
        r r5 = new r(9, false);
        AnimController$AnimProcessType r10 = AnimController$AnimProcessType.f2879a;
        r5.f18728b = r10;
        r5.f18729c = r10;
        this.f2860m = r5;
        this.f2862o = -1;
        this.f2871y = -1;
        this.f2872z = true;
        this.A = true;
        this.D = new Integer[0];
        this.E = RenderType.f2876a;
        final AppletPopup$special$$inlined$viewModels$default$1 r11 = new AppletPopup$special$$inlined$viewModels$default$1(this);
        this.F = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(AppletPopupViewModel.class), new AppletPopup$special$$inlined$viewModels$default$2(r11), null);
        this.G = LazyKt.lazy(new f(24));
        this.I = new a(this, 0);
        this.J = new b(this, 1);
    }

    public static void d(AppletPopup r10, boolean r11, boolean r12, int r13) {
        if ((r13 & 1) == 0) goto L6;
        r11 = true;
    L6:
        if ((r13 & 2) == 0) goto L8;
        r12 = false;
    L8:
        r10.g();
        FragmentActivity r14 = r10.getActivity();
        AppletPopupSchemaParam r5 = r10.f2857j;
        AppletPopupSchemaParam r15 = null;
        if (r5 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("schemaParam");
        r5 = null;
    L11:
        int r16 = e.b(r14, r5, r10);
        if (r12 == false) goto L29;
        BottomSheetBehavior r17 = r10.f2859l;
        if (r17 == null) goto L29;
        if (r17.f2885c == false) goto L18;
        int r18 = -1;
    L19:
        if (r18 == r16) goto L29;
        if (r17.g == 3) goto L23;
        r17.a(r16);
    L24:
        if (r11 == true) goto L29;
        LinearLayout r19 = r10.f2854c;
        if (r19 != null) goto L28;
        Intrinsics.throwUninitializedPropertyAccessException("popupContainer");
        r19 = null;
    L28:
        r19.requestLayout();
        goto L29
    L23:
        r17.f = r16;
        goto L24
    L18:
        r18 = r17.f2884b;
    L29:
        String r20 = "refreshPopupHeight. ShowHeight: " + r16;
        Intrinsics.checkNotNullParameter("AppletPopup", "tag");
        d r21 = c.f2846a;
        if (r21 == null) goto L32;
        r21.d("AppletPopup", r20);
    L32:
        if (r11 == false) goto L51;
        AppletPopupSchemaParam r22 = r10.f2857j;
        if (r22 != null) goto L36;
        Intrinsics.throwUninitializedPropertyAccessException("schemaParam");
        r22 = null;
    L36:
        RadiusLayout r23 = r10.d;
        if (r23 != null) goto L39;
        Intrinsics.throwUninitializedPropertyAccessException("popupInnerContainer");
        r23 = null;
    L39:
        r10.g();
        r10.getActivity();
        Intrinsics.checkNotNullParameter(r22, LynxResourceModule.PARAMS_KEY);
        Intrinsics.checkNotNullParameter(r23, "view");
        Intrinsics.checkNotNullParameter(r10, "appletPopup");
        r23.getLayoutParams().height = r16;
        r23.requestLayout();
        AppletPopupSchemaParam r24 = r10.f2857j;
        if (r24 != null) goto L42;
        Intrinsics.throwUninitializedPropertyAccessException("schemaParam");
        r24 = null;
    L42:
        LinearLayout r25 = r10.f2854c;
        if (r25 != null) goto L45;
        Intrinsics.throwUninitializedPropertyAccessException("popupContainer");
        r25 = null;
    L45:
        r10.g();
        r10.getActivity();
        Intrinsics.checkNotNullParameter(r24, LynxResourceModule.PARAMS_KEY);
        Intrinsics.checkNotNullParameter(r25, "view");
        Intrinsics.checkNotNullParameter(r10, "appletPopup");
        r25.getLayoutParams().height = r16;
        r25.requestLayout();
        AppletPopupSchemaParam r26 = r10.f2857j;
        if (r26 != null) goto L48;
        Intrinsics.throwUninitializedPropertyAccessException("schemaParam");
    L49:
        r15.getClass();
        return;
    L48:
        r15 = r26;
        goto L49
    }

    public final WindowInsetsCompat b(View r14, WindowInsetsCompat r15) {
        if (r14 == null) goto L4;
        if (r15 == null) goto L7;
        WindowInsetsCompat r5 = ViewCompat.onApplyWindowInsets(r14, r15);
        WindowInsetsCompat r10 = this.f2868v;
        if (r10 == null) goto L11;
        boolean r11 = r10.isVisible(WindowInsetsCompat.Type.ime());
    L12:
        boolean r16 = e.g(r14, g(), getView());
        if (r15.isVisible(WindowInsetsCompat.Type.navigationBars()) == false) goto L16;
        if (r16 == true) goto L16;
        int r17 = r15.getInsets(WindowInsetsCompat.Type.navigationBars()).bottom;
    L17:
        if (r11 == false) goto L19;
        r17 = r15.getInsets(WindowInsetsCompat.Type.ime()).bottom;
    L19:
        int r18 = this.f2871y;
        int r12 = -1;
        if (r18 != (-1)) goto L23;
        this.f2871y = r17;
        return r5;
    L23:
        if (r18 == r17) goto L190;
        AppletPopupSchemaParam r19 = this.f2857j;
        AppletPopupSchemaParam r13 = null;
        if (r19 != null) goto L28;
        Intrinsics.throwUninitializedPropertyAccessException("schemaParam");
        r19 = null;
    L28:
        r19.getClass();
        if (this.f2869w == false) goto L190;
        int r110 = this.f2871y;
        int r20 = r17 - r110;
        int r111 = this.f2852a;
        if (r20 <= r111) goto L124;
        int r112 = Math.abs(r20);
        if (r112 > 0) goto L37;
        r112 = 0;
    L37:
        Context r113 = getContext();
        if (r113 == null) goto L40;
        c.a(r112, r113);
    L40:
        this.f2866t = Math.abs(r20);
        if (getActivity() == null) goto L121;
        View r114 = getView();
        if (r114 == null) goto L121;
        AppletPopupSchemaParam r21 = this.f2857j;
        if (r21 != null) goto L47;
        Intrinsics.throwUninitializedPropertyAccessException("schemaParam");
        r21 = null;
    L47:
        r21.getClass();
        int r115 = e.a(g(), r114, this);
        if (this.f2861n != 0) goto L56;
        AppletPopupSchemaParam r22 = this.f2857j;
        if (r22 != null) goto L52;
        Intrinsics.throwUninitializedPropertyAccessException("schemaParam");
        r22 = null;
    L52:
        r22.getClass();
        LinearLayout r23 = this.f2854c;
        if (r23 != null) goto L55;
        Intrinsics.throwUninitializedPropertyAccessException("popupContainer");
        r23 = null;
    L55:
        this.f2861n = r23.getMeasuredHeight();
    L56:
        int r24 = this.f2861n;
        e(null);
        int r116 = RangesKt.coerceAtMost(r24, r115);
        LinearLayout r25 = this.f2854c;
        if (r25 != null) goto L59;
        Intrinsics.throwUninitializedPropertyAccessException("popupContainer");
        r25 = null;
    L59:
        ViewGroup.LayoutParams r26 = r25.getLayoutParams();
        if (r26 == null) goto L62;
        r26.height = r116;
    L62:
        RadiusLayout r27 = this.d;
        if (r27 != null) goto L65;
        Intrinsics.throwUninitializedPropertyAccessException("popupInnerContainer");
        r27 = null;
    L65:
        ViewGroup.LayoutParams r28 = r27.getLayoutParams();
        if (r28 == null) goto L68;
        r28.height = r116;
    L68:
        LinearLayout r29 = this.f2854c;
        if (r29 != null) goto L71;
        Intrinsics.throwUninitializedPropertyAccessException("popupContainer");
        r29 = null;
    L71:
        Intrinsics.checkNotNullParameter(r29, "view");
        ViewGroup.LayoutParams r30 = r29.getLayoutParams();
        if ((r30 instanceof FrameLayout.LayoutParams) == false) goto L75;
        ViewGroup.LayoutParams r31 = r29.getLayoutParams();
        Intrinsics.checkNotNull(r31, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        int r32 = ((FrameLayout.LayoutParams) r31).gravity;
    L81:
        int r33 = r32 & 7;
        LinearLayout r34 = this.f2854c;
        if (r34 != null) goto L84;
        Intrinsics.throwUninitializedPropertyAccessException("popupContainer");
        r34 = null;
    L84:
        kk.a.g(r34, r33 | 80);
        BottomSheetBehavior r35 = this.f2859l;
        if (r35 != null) goto L87;
    L101:
        BottomSheetBehavior r117 = this.f2859l;
        if (r117 == null) goto L116;
        boolean r36 = r117.e;
        if (r36 == false) goto L116;
        this.f2867u = r36;
        if (r117 == null) goto L112;
        r117.e = false;
        AppletPopupSchemaParam r118 = this.f2857j;
        if (r118 != null) goto L111;
        Intrinsics.throwUninitializedPropertyAccessException("schemaParam");
        r118 = null;
    L111:
        r118.f2896n = false;
    L112:
        BottomSheetBehavior r119 = this.f2859l;
        if (r119 != null) goto L115;
        Intrinsics.throwUninitializedPropertyAccessException("behavior");
        r119 = null;
    L115:
        r119.b(false);
    L116:
        AppletPopupSchemaParam r120 = this.f2857j;
        if (r120 != null) goto L119;
        Intrinsics.throwUninitializedPropertyAccessException("schemaParam");
    L120:
        r13.getClass();
        goto L121
    L119:
        r13 = r120;
        goto L120
    L87:
        if (this.s != 0) goto L94;
        if (r35.f2885c == true) goto L92;
        r12 = r35.f2884b;
    L92:
        this.s = r12;
    L94:
        if (r35.g == 3) goto L98;
        if (r35 != null) goto L97;
        Intrinsics.throwUninitializedPropertyAccessException("behavior");
        r35 = null;
    L97:
        r35.a(r116);
        goto L101
    L98:
        if (r35 != null) goto L100;
        Intrinsics.throwUninitializedPropertyAccessException("behavior");
        r35 = null;
    L100:
        r35.f = r116;
        goto L101
    L75:
        if ((r30 instanceof CoordinatorLayout.LayoutParams) == false) goto L78;
        ViewGroup.LayoutParams r37 = r29.getLayoutParams();
        Intrinsics.checkNotNull(r37, "null cannot be cast to non-null type androidx.coordinatorlayout.widget.CoordinatorLayout.LayoutParams");
        r32 = ((CoordinatorLayout.LayoutParams) r37).gravity;
        goto L81
    L78:
        if ((r30 instanceof LinearLayout.LayoutParams) == false) goto L80;
        ViewGroup.LayoutParams r38 = r29.getLayoutParams();
        Intrinsics.checkNotNull(r38, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        r32 = ((LinearLayout.LayoutParams) r38).gravity;
        goto L81
    L80:
        r32 = 0;
    L121:
        c(r17);
        this.f2871y = r17;
        return r5;
    L124:
        if ((r110 - r17) <= r111) goto L190;
        int r121 = -Math.abs(r20);
        if (r121 > 0) goto L129;
        r121 = 0;
    L129:
        Context r39 = getContext();
        if (r39 == null) goto L132;
        c.a(r121, r39);
    L132:
        this.f2866t = 0;
        if (getActivity() == null) goto L189;
        View r122 = getView();
        if (r122 == null) goto L170;
        AppletPopupSchemaParam r40 = this.f2857j;
        if (r40 != null) goto L139;
        Intrinsics.throwUninitializedPropertyAccessException("schemaParam");
        r40 = null;
    L139:
        r40.getClass();
        LinearLayout r41 = this.f2854c;
        if (r41 != null) goto L142;
        Intrinsics.throwUninitializedPropertyAccessException("popupContainer");
        r41 = null;
    L142:
        ViewGroup.LayoutParams r42 = r41.getLayoutParams();
        g();
        FragmentActivity r43 = getActivity();
        AppletPopupSchemaParam r44 = this.f2857j;
        if (r44 != null) goto L145;
        Intrinsics.throwUninitializedPropertyAccessException("schemaParam");
        r44 = null;
    L145:
        r42.height = e.b(r43, r44, this);
        RadiusLayout r45 = this.d;
        if (r45 != null) goto L148;
        Intrinsics.throwUninitializedPropertyAccessException("popupInnerContainer");
        r45 = null;
    L148:
        ViewGroup.LayoutParams r46 = r45.getLayoutParams();
        LinearLayout r47 = this.f2854c;
        if (r47 != null) goto L151;
        Intrinsics.throwUninitializedPropertyAccessException("popupContainer");
        r47 = null;
    L151:
        r46.height = r47.getLayoutParams().height;
        BottomSheetBehavior r48 = this.f2859l;
        if (r48 != null) goto L154;
    L163:
        AppletPopupSchemaParam r49 = this.f2857j;
        if (r49 != null) goto L166;
        Intrinsics.throwUninitializedPropertyAccessException("schemaParam");
        r49 = null;
    L166:
        int r123 = kk.a.a(r49, r122, this.D);
        LinearLayout r50 = this.f2854c;
        if (r50 != null) goto L169;
        Intrinsics.throwUninitializedPropertyAccessException("popupContainer");
        r50 = null;
    L169:
        kk.a.g(r50, r123);
        goto L170
    L154:
        if (r48.g == 3) goto L159;
        LinearLayout r51 = this.f2854c;
        if (r51 != null) goto L158;
        Intrinsics.throwUninitializedPropertyAccessException("popupContainer");
        r51 = null;
    L158:
        r48.a(r51.getLayoutParams().height);
        goto L163
    L159:
        LinearLayout r52 = this.f2854c;
        if (r52 != null) goto L162;
        Intrinsics.throwUninitializedPropertyAccessException("popupContainer");
        r52 = null;
    L162:
        r48.f = r52.getLayoutParams().height;
    L170:
        BottomSheetBehavior r124 = this.f2859l;
        if (r124 != null) goto L173;
    L186:
        CoordinatorLayout r125 = this.g;
        if (r125 == null) goto L189;
        r125.requestLayout();
        goto L189
    L173:
        if (this.f2867u == false) goto L178;
        r124.e = true;
        AppletPopupSchemaParam r126 = this.f2857j;
        if (r126 != null) goto L177;
        Intrinsics.throwUninitializedPropertyAccessException("schemaParam");
        r126 = null;
    L177:
        r126.f2896n = true;
    L178:
        BottomSheetBehavior r127 = this.f2859l;
        if (r127 != null) goto L181;
        Intrinsics.throwUninitializedPropertyAccessException("behavior");
        r127 = null;
    L181:
        AppletPopupSchemaParam r53 = this.f2857j;
        if (r53 != null) goto L184;
        Intrinsics.throwUninitializedPropertyAccessException("schemaParam");
    L185:
        r127.b(r13.f2891i);
        goto L186
    L184:
        r13 = r53;
    L189:
        c(r17);
        this.f2871y = r17;
    L190:
        return r5;
    L16:
        r17 = 0;
        goto L17
    L11:
        r11 = false;
        goto L12
    L7:
        return WindowInsetsCompat.CONSUMED;
    L4:
        return WindowInsetsCompat.CONSUMED;
    }

    public final void c(int r11) {
        String r5 = "contentViewBottom: " + r11;
        Intrinsics.checkNotNullParameter("AppletPopup", "tag");
        d r10 = c.f2846a;
        if (r10 == null) goto L5;
        r10.d("AppletPopup", r5);
    L5:
        Window r12 = g();
        AppletPopupSchemaParam r13 = null;
        if (r12 == null) goto L8;
        View r14 = r12.getDecorView();
    L9:
        View r15 = getView();
        if (r15 == null) goto L12;
        Object r16 = r15.getParent();
    L14:
        if ((r16 instanceof View) == false) goto L16;
        View r17 = (View) r16;
    L17:
        boolean r18 = false;
        if (r17 == null) goto L20;
        int r19 = r17.getPaddingBottom();
    L22:
        if ((r14 instanceof ViewGroup) == false) goto L24;
        ViewGroup r20 = (ViewGroup) r14;
    L25:
        if (r20 == null) goto L29;
        View r21 = r20.getChildAt(0);
        if (r21 == null) goto L29;
        ViewGroup.LayoutParams r22 = r21.getLayoutParams();
    L31:
        if ((r22 instanceof FrameLayout.LayoutParams) == false) goto L33;
        FrameLayout.LayoutParams r23 = (FrameLayout.LayoutParams) r22;
    L34:
        if (r23 == null) goto L36;
        int r24 = r23.bottomMargin;
    L37:
        int r110 = (r11 - r19) - r24;
        if (r14 != null) goto L40;
    L66:
        AppletPopupSchemaParam r111 = this.f2857j;
        if (r111 != null) goto L69;
        Intrinsics.throwUninitializedPropertyAccessException("schemaParam");
        r111 = null;
    L69:
        r111.getClass();
        AppletPopupSchemaParam r112 = this.f2857j;
        if (r112 != null) goto L72;
        Intrinsics.throwUninitializedPropertyAccessException("schemaParam");
    L73:
        d(this, !r13.f2906y, true, 4);
        return;
    L72:
        r13 = r112;
        goto L73
    L40:
        if ((r14.getWindowSystemUiVisibility() & 1024) == 0) goto L42;
        boolean r25 = true;
    L43:
        RenderType r26 = this.E;
        if (r25 == true) goto L46;
    L48:
        if (r25 == true) goto L50;
    L60:
        if (r18 == false) goto L66;
        r14.setPadding(r14.getPaddingLeft(), r14.getPaddingTop(), r14.getPaddingRight(), r110);
        String r113 = "updatePadding: " + r110;
        Intrinsics.checkNotNullParameter("AppletPopup", "tag");
        d r27 = c.f2846a;
        if (r27 == null) goto L65;
        r27.d("AppletPopup", r113);
    L65:
        r14.requestLayout();
        goto L66
    L50:
        if (r26 != RenderType.f2877b) goto L60;
        AppletPopupSchemaParam r28 = this.f2857j;
        if (r28 != null) goto L55;
        Intrinsics.throwUninitializedPropertyAccessException("schemaParam");
        r28 = null;
    L55:
        if (r28.f2901t != 2) goto L60;
        AppletPopupSchemaParam r29 = this.f2857j;
        if (r29 != null) goto L59;
        Intrinsics.throwUninitializedPropertyAccessException("schemaParam");
        r29 = null;
    L59:
        r29.getClass();
        goto L60
    L46:
        if (r26 != RenderType.f2876a) goto L48;
        r18 = true;
        goto L48
    L42:
        r25 = false;
        goto L43
    L36:
        r24 = 0;
        goto L37
    L33:
        r23 = null;
    L29:
        r22 = null;
        goto L31
    L24:
        r20 = null;
        goto L25
    L20:
        r19 = 0;
        goto L22
    L16:
        r17 = null;
        goto L17
    L12:
        r16 = null;
        goto L14
    L8:
        r14 = null;
        goto L9
    }

    public final void e(Integer r5) {
        if (r5 == null) goto L4;
        int r10 = r5.intValue();
    L8:
        AppletPopupSchemaParam r11 = null;
        if (r10 != 3) goto L14;
        AppletPopupSchemaParam r12 = this.f2857j;
        if (r12 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("schemaParam");
        r12 = null;
    L13:
        r12.getClass();
    L14:
        AppletPopupSchemaParam r13 = this.f2857j;
        if (r13 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("schemaParam");
    L18:
        r11.getClass();
        return;
    L17:
        r11 = r13;
        goto L18
    L4:
        BottomSheetBehavior r14 = this.f2859l;
        if (r14 == null) goto L7;
        r10 = r14.g;
        goto L8
    L7:
        r10 = -1;
        goto L8
    }

    public final void f(boolean r10) {
        if (r10 == this.f2869w) goto L52;
        boolean r5 = true;
        a r11 = this.I;
        if (r10 == false) goto L8;
    L16:
        if (r10 == true) goto L18;
    L28:
        boolean r12 = this.f2870x;
        boolean r13 = isVisible();
        boolean r14 = getUserVisibleHint();
        View r15 = getView();
        if (r15 == null) goto L31;
        boolean r16 = r15.hasWindowFocus();
    L32:
        if (r12 == false) goto L37;
        if (r13 == false) goto L37;
        if (r14 == false) goto L37;
        if (r16 == false) goto L37;
    L39:
        if (r5 == this.f2869w) goto L48;
        this.f2869w = r5;
        Window r17 = g();
        if (r17 == null) goto L49;
        View r18 = r17.getDecorView();
        if (r18 == null) goto L50;
        WindowInsetsCompat r19 = this.f2868v;
        if (r19 == null) goto L51;
        b(r18, r19);
        return;
    L51:
        return;
    L50:
        return;
    L49:
        return;
    L48:
        return;
    L37:
        r5 = false;
        goto L39
    L31:
        r16 = false;
        goto L32
    L18:
        if (this.H == true) goto L28;
        if (this.f2865r == null) goto L28;
        this.H = true;
        Window r20 = g();
        if (r20 == null) goto L28;
        View r21 = r20.getDecorView();
        if (r21 == null) goto L28;
        ViewTreeObserver r22 = r21.getViewTreeObserver();
        if (r22 == null) goto L28;
        r22.addOnGlobalLayoutListener(r11);
        goto L28
    L8:
        if (this.H == false) goto L16;
        this.H = false;
        Window r23 = g();
        if (r23 == null) goto L28;
        View r24 = r23.getDecorView();
        if (r24 == null) goto L28;
        ViewTreeObserver r25 = r24.getViewTreeObserver();
        if (r25 == null) goto L28;
        r25.removeOnGlobalLayoutListener(r11);
        goto L28
    }

    public final Window g() {
        Dialog r5 = getDialog();
        if (r5 == null) goto L6;
        Window r10 = r5.getWindow();
        if (r10 == null) goto L6;
    L15:
        if (r10 != null) goto L23;
        t0.b r11 = p.f2294c;
        if (r11 == null) goto L22;
        Activity r12 = r11.currentActivity();
        if (r12 == null) goto L22;
        return r12.getWindow();
    L22:
        return null;
    L23:
        return r10;
    L6:
        Fragment r13 = getParentFragment();
        if ((r13 instanceof DialogFragment) == false) goto L9;
        DialogFragment r14 = (DialogFragment) r13;
    L10:
        if (r14 == null) goto L14;
        Dialog r15 = r14.getDialog();
        if (r15 == null) goto L14;
        r10 = r15.getWindow();
    L14:
        r10 = null;
        goto L15
    L9:
        r14 = null;
        goto L10
    }

    public final void h(int r10) {
        String r5 = OpenPageMethod.APP_POPUP;
        Fragment r11 = getChildFragmentManager().findFragmentById(r10);
        AIFragmentBase r12 = null;
        if ((r11 instanceof AIFragmentBase) == false) goto L5;
        AIFragmentBase r13 = (AIFragmentBase) r11;
    L6:
        if (r13 == null) goto L32;
        this.f2858k = r13;
        return;
    L32:
        Result.Companion r14 = Result.Companion;     // Catch: Throwable -> L14
        Bundle r15 = getArguments();     // Catch: Throwable -> L14
        if (r15 == null) goto L16;
        String r16 = r15.getString(Constant.APPID);     // Catch: Throwable -> L14
        if (r16 == null) goto L16;
    L17:
        FragmentTransaction r17 = getChildFragmentManager().beginTransaction();     // Catch: Throwable -> L14
        AIFragmentBase r18 = this.f2858k;     // Catch: Throwable -> L14
        if (r18 != null) goto L23;
        t0.b r19 = p.f2294c;     // Catch: Throwable -> L14
        if (r19 == null) goto L22;
        r12 = r19.createAppletFragment(r16);     // Catch: Throwable -> L14
    L22:
        Intrinsics.checkNotNull(r12);     // Catch: Throwable -> L14
        r18 = r12;
    L23:
        this.f2858k = r18;     // Catch: Throwable -> L14
        r18.setArguments(getArguments());     // Catch: Throwable -> L14
        Unit r20 = Unit.INSTANCE;     // Catch: Throwable -> L14
        FragmentTransaction r21 = r17.add(r10, r18, OpenPageMethod.APP_POPUP);     // Catch: Throwable -> L14
        Intrinsics.checkNotNull(r21);     // Catch: Throwable -> L14
        c1.b.b(new a2.b(24, r5, r21));     // Catch: Throwable -> L14
        Object r22 = Result.m124constructorimpl(r21);     // Catch: Throwable -> L14
    L26:
        Throwable r23 = Result.m127exceptionOrNullimpl(r22);
        if (r23 == null) goto L34;
        Intrinsics.checkNotNullParameter("AppletPopup", "tag");
        d r24 = c.f2846a;
        if (r24 == null) goto L35;
        r24.e("AppletPopup", "showAppletPage", r23);
        return;
    L35:
        return;
    L34:
        return;
    L16:
        r16 = "";
    L14:
        th = move-exception;
        Result.Companion r25 = Result.Companion;
        r22 = Result.m124constructorimpl(ResultKt.createFailure(th));
        goto L26
    L5:
        r13 = null;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v1, types: [T, java.lang.Object, java.lang.String] */
    public final void i(boolean r12) {
        int r5 = 0;
        if (this.C == false) goto L6;
        return;
    L6:
        if (getFragmentManager() == null) goto L71;
        if (r12 == false) goto L73;
        k3.b r13 = this.f2856i;
        String r10 = null;
        if (r13 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("animatorParamHandler");
        r13 = null;
    L11:
        h3.c r11 = (h3.c) this.G.getValue();
        h3.b r14 = new h3.b(this, r5);
        r r15 = (r) r13.d;
        if (((AnimController$AnimProcessType) r15.f18729c) != AnimController$AnimProcessType.f2879a) goto L71;
        Ref.ObjectRef r16 = new Ref.ObjectRef();
        ?? r17 = r13.a(false);
        r16.element = r17;
        AnimationStyle[] r18 = AnimationStyle.f2882a;
        boolean r19 = Intrinsics.areEqual(r17, "zoom");
        AppletPopupSchemaParam r20 = r13.f18589b;
        LinearLayout r21 = (LinearLayout) r13.f18590c;
        if (r19 == false) goto L27;
        int r22 = i3.a.f17500a;
        String r23 = r20.f2894l;
        Intrinsics.checkNotNullParameter(r21, "transitionView");
        Intrinsics.checkNotNullParameter(r23, "floatingPageName");
        Intrinsics.checkNotNullParameter(r15, "animController");
        Lazy r110 = v0.e.f;
        com.bytedance.android.anniex.base.service.f.g().getClass();
        k r111 = v0.e.n();
        if (r111 == null) goto L21;
        PageInfo r112 = ((com.bytedance.ai.model.widgets.a) r111).f2330b;
        if (r112 == null) goto L21;
        r10 = r112.getPageName();
    L21:
        com.bytedance.android.anniex.base.service.f.g().getClass();
        Lazy r113 = v0.d.f22502n;
        if (cl.a.h().s() == true) goto L24;
    L25:
        com.bytedance.android.anniex.base.service.f.g().getClass();
    L26:
        r16.element = "slide";
        goto L27
    L24:
        if (Intrinsics.areEqual(r10, r23) == false) goto L26;
    L27:
        k3.a r24 = new k3.a(r13, r16, r14, r5);
        String r114 = (String) r16.element;
        if (Intrinsics.areEqual(r114, "slide") == false) goto L31;
        Intrinsics.checkNotNull(r21.animate().translationY(r21.getHeight()).setDuration(r20.f2907z).setListener(r24));
    L59:
        if (r11 == null) goto L61;
        ViewPropertyAnimator r115 = r21.animate();
        Intrinsics.checkNotNullParameter(r115, "animator");
        r115.setInterpolator(new LinearInterpolator());
        r115.setDuration(300);
    L61:
        r21.animate().start();
        goto L71
    L31:
        if (Intrinsics.areEqual(r114, OpenPageMethod.ALIGN_LEFT) == false) goto L42;
        DisplayMetrics r116 = new DisplayMetrics();
        if ((r21.getContext() instanceof Activity) == false) goto L35;
        Context r25 = r21.getContext();
        Intrinsics.checkNotNull(r25, "null cannot be cast to non-null type android.app.Activity");
        WindowManager r26 = ((Activity) r25).getWindowManager();
    L36:
        if (r26 == null) goto L40;
        Display r27 = r26.getDefaultDisplay();
        if (r27 == null) goto L40;
        r27.getMetrics(r116);
    L40:
        Intrinsics.checkNotNull(r21.animate().translationX(-r116.widthPixels).setDuration(r20.f2907z).setListener(r24));
        goto L59
    L35:
        Object r28 = r21.getContext().getSystemService("window");
        Intrinsics.checkNotNull(r28, "null cannot be cast to non-null type android.view.WindowManager");
        r26 = (WindowManager) r28;
        goto L36
    L42:
        if (Intrinsics.areEqual(r114, "right") == false) goto L53;
        DisplayMetrics r117 = new DisplayMetrics();
        if ((r21.getContext() instanceof Activity) == false) goto L46;
        Context r29 = r21.getContext();
        Intrinsics.checkNotNull(r29, "null cannot be cast to non-null type android.app.Activity");
        WindowManager r30 = ((Activity) r29).getWindowManager();
    L47:
        if (r30 == null) goto L51;
        Display r31 = r30.getDefaultDisplay();
        if (r31 == null) goto L51;
        r31.getMetrics(r117);
    L51:
        Intrinsics.checkNotNull(r21.animate().translationX(r117.widthPixels).setDuration(r20.f2907z).setListener(r24));
        goto L59
    L46:
        Object r32 = r21.getContext().getSystemService("window");
        Intrinsics.checkNotNull(r32, "null cannot be cast to non-null type android.view.WindowManager");
        r30 = (WindowManager) r32;
        goto L47
    L53:
        if (Intrinsics.areEqual(r114, "auto") == false) goto L56;
        r21.setAlpha(1.0f);
        Intrinsics.checkNotNull(r21.animate().alpha(0.0f).setDuration(r20.f2907z).setListener(r24));
        goto L59
    L56:
        if (Intrinsics.areEqual(r114, "none") == false) goto L58;
        r14.invoke();
        r15.m(false);
        goto L59
    L58:
        r14.invoke();
        r15.m(false);
        goto L59
    L73:
        Result.Companion r118 = Result.Companion;     // Catch: Throwable -> L65
        if (j() == true) goto L67;
        dismissAllowingStateLoss();     // Catch: Throwable -> L65
    L67:
        Object r119 = Result.m124constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L65
    L70:
        Result.m123boximpl(r119);
    L65:
        th = move-exception;
        Result.Companion r33 = Result.Companion;
        r119 = Result.m124constructorimpl(ResultKt.createFailure(th));
    L71:
        this.C = true;
    }

    public final boolean j() {
        FragmentManager r5 = getFragmentManager();
        boolean r10 = false;
        if (r5 != null) goto L5;
        return false;
    L5:
        String r11 = getTag();
        if (r11 != null) goto L24;
        return false;
    L24:
        Result.Companion r12 = Result.Companion;     // Catch: Throwable -> L17
        int r13 = r5.getBackStackEntryCount();     // Catch: Throwable -> L17
        if (r13 > 0) goto L12;
    L15:
        Object r14 = Result.m124constructorimpl(Boolean.valueOf(r10));     // Catch: Throwable -> L17
    L19:
        Boolean r15 = Boolean.FALSE;
        if (Result.m130isFailureimpl(r14) == false) goto L23;
        r14 = r15;
    L23:
        return ((Boolean) r14).booleanValue();
    L12:
        if (Intrinsics.areEqual(r5.getBackStackEntryAt(r13 - 1).getName(), r11) == false) goto L15;
        r10 = r5.popBackStackImmediate(r11, 1);     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        Result.Companion r16 = Result.Companion;
        r14 = Result.m124constructorimpl(ResultKt.createFailure(th));
        goto L19
    }

    public final boolean k() {
        AppletPopupSchemaParam r5 = this.f2857j;
        AppletPopupSchemaParam r10 = null;
        if (r5 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("schemaParam");
        r5 = null;
    L6:
        if (r5.f2891i == true) goto L21;
        AppletPopupSchemaParam r11 = this.f2857j;
        if (r11 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("schemaParam");
        r11 = null;
    L11:
        if (r11.f2896n == true) goto L23;
        AppletPopupSchemaParam r12 = this.f2857j;
        if (r12 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("schemaParam");
    L17:
        if (Intrinsics.areEqual(r10.a(getContext()), "bottom") == true) goto L24;
        return false;
    L24:
        return true;
    L15:
        r10 = r12;
        goto L17
    L23:
        return true;
    L21:
        return true;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onAttach(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        super.onAttach(r5);
        f(true);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle r26) {
        super.onCreate(r26);
        if (r26 == null) goto L7;
        Bundle r5 = new Bundle();
        r5.putAll(r26);
        setArguments(r5);
        Serializable r10 = r26.getSerializable("popupSchema");
        if (r10 == null) goto L7;
        this.f2857j = (AppletPopupSchemaParam) r10;
    L7:
        nh.b r11 = this.K;
        Lazy r12 = this.F;
        if (r11 != null) goto L10;
        this.K = ((AppletPopupViewModel) r12.getValue()).f2908b;
    L11:
        nh.b r13 = this.K;
        if (r13 == null) goto L136;
        Intrinsics.checkNotNullParameter(this, "fragment");
        Intrinsics.checkNotNullParameter("WebViewPopupPageV2", "tag");
        d r14 = c.f2846a;
        if (r14 == null) goto L16;
        r14.d("WebViewPopupPageV2", "onFragmentCreated");
    L16:
        ((w0.c) r13.d).getClass();
        Uri r15 = (Uri) r13.f20234b;
        if (r15 == null) goto L23;
        String r16 = r15.getQueryParameter("heightPercent");
        if (r16 == null) goto L23;
        Integer r17 = StringsKt.toIntOrNull(r16);
        if (r17 == null) goto L23;
        int r18 = r17.intValue();
    L25:
        if (r15 == null) goto L27;
        boolean r19 = r15.getBooleanQueryParameter("showMask", true);
    L28:
        if (r15 == null) goto L30;
        boolean r20 = r15.getBooleanQueryParameter("closeByMask", true);
    L32:
        if (r15 == null) goto L34;
        boolean r110 = r15.getBooleanQueryParameter("dragByGesture", false);
    L35:
        if (r15 == null) goto L37;
        boolean r111 = r15.getBooleanQueryParameter("dragBack", false);
    L39:
        if (r15 == null) goto L42;
        String r112 = r15.getQueryParameter("gravity");
        if (r112 == null) goto L42;
    L43:
        if (r15 == null) goto L45;
        boolean r113 = r15.getBooleanQueryParameter("disableBackPress", false);
    L46:
        if (r15 == null) goto L48;
        boolean r114 = r15.getBooleanQueryParameter("transNavigationBar", false);
    L50:
        if (r15 == null) goto L53;
        String r21 = r15.getQueryParameter("navigationBarColor");
        if (r21 == null) goto L53;
    L54:
        if (r15 == null) goto L56;
        boolean r115 = r15.getBooleanQueryParameter("closeByGesture", true);
    L57:
        if (r15 == null) goto L64;
        String r22 = r15.getQueryParameter("radius");
        if (r22 == null) goto L64;
        Integer r23 = StringsKt.toIntOrNull(r22);
        if (r23 == null) goto L64;
        int r24 = r23.intValue();
    L63:
        String r116 = r112;
        boolean r117 = r113;
        double r118 = r24;
        FragmentActivity r25 = (FragmentActivity) r13.e;
        int r119 = c.c(r25, r118);
        if (r15 == null) goto L68;
        String r120 = r15.getQueryParameter("animationInStyle");
    L69:
        if (r15 == null) goto L71;
        String r27 = r15.getQueryParameter("animationOutStyle");
    L72:
        String r28 = r21;
        if (r15 == null) goto L78;
        String r29 = r15.getQueryParameter("floatingPageId");
        if (r29 == null) goto L78;
    L80:
        if (r15 == null) goto L82;
        String r30 = r15.getQueryParameter("bounceWithKeyboard");
    L83:
        boolean r31 = Intrinsics.areEqual(r30, IIvyAIPackageResourceService.SHOULD_INTERCEPT_REQUEST);
        t0.b r121 = p.f2294c;
        if (r121 == null) goto L86;
        int r122 = r121.getStatusBarHeight(r25);
    L87:
        int r210 = c.b(r25);
        int r211 = c.k(r25.getWindow());
        if (r18 == 100) goto L90;
        r211 = r211 - r122;
    L90:
        if (r114 == true) goto L92;
        r211 = r211 - r210;
    L92:
        boolean r212 = r20;
        int r123 = r211;
        if (1 > r18) goto L96;
        if (r18 >= 100) goto L96;
        int r32 = (r18 * r123) / 100;
    L99:
        if (r110 == true) goto L102;
        r123 = -1;
    L102:
        String r33 = "popupHeight: " + r32;
        Intrinsics.checkNotNullParameter("WebViewPopupPageV2", "tag");
        d r34 = c.f2846a;
        if (r34 == null) goto L105;
        r34.d("WebViewPopupPageV2", r33);
    L105:
        boolean r35 = r13.f20235c;
        if (r35 == false) goto L108;
        String r36 = "bottom";
    L109:
        t0.b r37 = p.f2294c;
        if (r37 == null) goto L112;
        int r38 = r37.navigationBarBgColor(r25);
    L113:
        AppletPopupSchemaParam r39 = new AppletPopupSchemaParam();
        r39.f2896n = r110;
        r39.f2899q = r111;
        r39.d = r32;
        r39.f2897o = r123;
        r39.f2891i = r115;
        r39.s = true;
        r39.f2902u = r114;
        r39.g = r19;
        if (r120 != null) goto L116;
    L117:
        AnimationStyle[] r40 = AnimationStyle.f2882a;
        r120 = "slide";
    L118:
        Intrinsics.checkNotNullParameter(r120, "<set-?>");
        r39.f2892j = r120;
        if (r27 != null) goto L121;
    L122:
        AnimationStyle[] r41 = AnimationStyle.f2882a;
        r27 = "slide";
    L123:
        Intrinsics.checkNotNullParameter(r27, "<set-?>");
        r39.f2893k = r27;
        Intrinsics.checkNotNullParameter(r29, "<set-?>");
        r39.f2894l = r29;
        r39.f2890h = !r212;
        r39.f = r119;
        Intrinsics.checkNotNullParameter(r36, "<set-?>");
        r39.f2887a = r36;
        r39.f2903v = r117;
        r39.f2900r = false;
        if (r114 == false) goto L126;
        int r42 = 0;
    L131:
        r39.f2904w = r42;
        r39.f2906y = r31;
        String r43 = r13.f20233a;
        Pair r44 = TuplesKt.to("page_id", r43);
        PageInfo r45 = (PageInfo) r13.f;
        setArguments(BundleKt.bundleOf(new Pair[]{r44, TuplesKt.to("appName", r45.getPageName()), TuplesKt.to("url", (String) r13.g), TuplesKt.to("pageId", r43), TuplesKt.to("showFloatingSpeaker", Boolean.valueOf(r35)), TuplesKt.to("fullScreen", Boolean.FALSE), TuplesKt.to("bounceWithKeyboard", Boolean.valueOf(r39.f2906y)), TuplesKt.to(Constant.APPID, r45.getPackageName())}));
        Intrinsics.checkNotNullParameter(r39, "schemaParam");
        this.f2857j = r39;
        return;
    L126:
        if (c.l(r28) == true) goto L134;
    L129:
        r42 = r38;
        goto L131
    L134:
        r42 = Color.parseColor(r28);     // Catch: IllegalArgumentException -> L133
    L121:
        if (r27.length() != 0) goto L123;
    L116:
        if (r120.length() != 0) goto L118;
    L112:
        r38 = 0;
        goto L113
    L108:
        r36 = r116;
    L96:
        if (r18 != 100) goto L98;
        r32 = r123;
        goto L99
    L98:
        r32 = (int) (r123 * 0.9f);
        goto L99
    L86:
        r122 = 0;
        goto L87
    L82:
        r30 = null;
    L78:
        r29 = "";
        goto L80
    L71:
        r27 = null;
        goto L72
    L68:
        r120 = null;
    L64:
        r24 = 20;
        goto L63
    L56:
        r115 = true;
    L53:
        r21 = "";
        goto L54
    L48:
        r114 = false;
        goto L50
    L45:
        r113 = false;
    L42:
        r112 = "bottom";
        goto L43
    L37:
        r111 = false;
        goto L39
    L34:
        r110 = false;
        goto L35
    L30:
        r20 = true;
        goto L32
    L27:
        r19 = true;
    L23:
        r18 = 90;
        goto L25
    L136:
        return;
    L10:
        AppletPopupViewModel r46 = (AppletPopupViewModel) r12.getValue();
        nh.b r47 = this.K;
        Intrinsics.checkNotNull(r47);
        r46.getClass();
        Intrinsics.checkNotNullParameter(r47, "listener");
        r46.f2908b = r47;
        goto L11
    }

    @Override // androidx.appcompat.app.AppCompatDialogFragment, androidx.fragment.app.DialogFragment
    public final Dialog onCreateDialog(Bundle r5) {
        final Context r10 = requireContext();
        AppletPopUpDialog r11 = new AnonymousClass1(this, r10);
        FragmentActivity r12 = getActivity();
        if (r12 == null) goto L5;
        r11.setOwnerActivity(r12);
    L5:
        AppletPopupSchemaParam r13 = this.f2857j;
        if (r13 != null) goto L9;
        r13 = null;
    L9:
        r11.f2851a = r13;
        return r11;
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r13, ViewGroup r14, Bundle r15) {
        Intrinsics.checkNotNullParameter(r13, "inflater");
        AppletPopupSchemaParam r5 = this.f2857j;
        AppletPopupSchemaParam r10 = null;
        BottomSheetBehavior r11 = null;
        if (r5 != null) goto L7;
        r5 = null;
    L7:
        if (r5 != null) goto L13;
        Intrinsics.checkNotNullParameter("AppletPopup", "tag");
        d r16 = c.f2846a;
        if (r16 == null) goto L11;
        r16.w("AppletPopup", "schemaParam is null, close fragment directly");
    L11:
        i(false);
        return null;
    L13:
        StringBuilder r12 = new StringBuilder("[");
        r12.append(this);
        r12.append("] onCreateView, savedInstanceState is ");
        if (r15 != null) goto L16;
        String r17 = "null";
    L17:
        String r18 = androidx.room.jarjarred.org.antlr.runtime.a.v(r12, r17, "AppletPopup", "tag");
        d r19 = c.f2846a;
        if (r19 == null) goto L20;
        r19.d("AppletPopup", r18);
    L20:
        Window r110 = g();
        if (r110 == null) goto L23;
        View r111 = r110.getDecorView();
    L24:
        this.B = r111;
        if (r111 == null) goto L35;
        LinkedHashMap r20 = h3.e.f17278a;
        Intrinsics.checkNotNullParameter(r111, "view");
        b r21 = this.J;
        Intrinsics.checkNotNullParameter(r21, "listener");
        int r22 = r111.hashCode();
        LinkedHashMap r23 = h3.e.f17278a;
        Collection r24 = (Collection) r23.get(Integer.valueOf(r22));
        if (r24 != null) goto L29;
    L30:
        r23.put(Integer.valueOf(r22), new ArrayList());
        ViewCompat.setOnApplyWindowInsetsListener(r111, new e0(r22, 1));
    L31:
        List r25 = (List) r23.get(Integer.valueOf(r22));
        if (r25 == null) goto L34;
        r25.add(r21);
    L34:
        r111.requestApplyInsets();
        goto L35
    L29:
        if (r24.isEmpty() == false) goto L31;
    L35:
        AppletPopupSchemaParam r112 = this.f2857j;
        if (r112 != null) goto L38;
        Intrinsics.throwUninitializedPropertyAccessException("schemaParam");
        r112 = null;
    L38:
        Context r26 = r13.getContext();
        Intrinsics.checkNotNullParameter(r112, LynxResourceModule.PARAMS_KEY);
        Intrinsics.checkNotNullParameter(r26, "context");
        r112.getClass();
        ym.k.c(r26);
        this.D = new Integer[]{0, 0, 0, 0, 0, 0};
        boolean r113 = k();
        r r27 = this.f2860m;
        if (r113 == false) goto L98;
        View r114 = r13.inflate(R$layout.applet_fragment_popup_enable_pull_down_close, r14, false);
        this.f2853b = (FrameLayout) r114.findViewById(R$id.popup_root);
        LinearLayout r115 = (LinearLayout) r114.findViewById(R$id.popup_container);
        r115.setOnClickListener(new j(1));
        this.f2854c = r115;
        this.d = (RadiusLayout) r114.findViewById(R$id.popup_inner_container);
        this.e = (FrameLayout) r114.findViewById(R$id.popup_top_container);
        this.f = r114.findViewById(R$id.popup_bg);
        this.g = (CoordinatorLayout) r114.findViewById(R$id.popup_coordinator);
        AppletPopupSchemaParam r116 = this.f2857j;
        if (r116 != null) goto L43;
        Intrinsics.throwUninitializedPropertyAccessException("schemaParam");
        r116 = null;
    L43:
        LinearLayout r28 = this.f2854c;
        if (r28 != null) goto L46;
        Intrinsics.throwUninitializedPropertyAccessException("popupContainer");
        r28 = null;
    L46:
        this.f2856i = new k3.b(r116, r28, r27);
        AppletPopupSchemaParam r117 = this.f2857j;
        if (r117 != null) goto L49;
        Intrinsics.throwUninitializedPropertyAccessException("schemaParam");
        r117 = null;
    L49:
        r117.getClass();
        LinearLayout r118 = this.f2854c;
        if (r118 != null) goto L52;
        Intrinsics.throwUninitializedPropertyAccessException("popupContainer");
        r118 = null;
    L52:
        ViewGroup.LayoutParams r119 = r118.getLayoutParams();
        if ((r119 instanceof CoordinatorLayout.LayoutParams) == true) goto L55;
        Log.e("BottomSheetBehavior", "The view is not a child of CoordinatorLayout");
    L55:
        CoordinatorLayout.Behavior r120 = ((CoordinatorLayout.LayoutParams) r119).getBehavior();
        if ((r120 instanceof BottomSheetBehavior) == true) goto L58;
        Log.e("BottomSheetBehavior", "The view is not associated with BottomSheetBehavior");
    L58:
        BottomSheetBehavior r121 = (BottomSheetBehavior) r120;
        r121.b(true);
        RadiusLayout r122 = this.d;
        if (r122 != null) goto L61;
        Intrinsics.throwUninitializedPropertyAccessException("popupInnerContainer");
        r122 = null;
    L61:
        new WeakReference(r122);
        new WeakReference(null);
        com.bytedance.ai.applet.login.b r123 = new com.bytedance.ai.applet.login.b();
        ArrayList r29 = r121.f2886h;
        if (r29.contains(r123) == true) goto L65;
        r29.add(r123);
    L65:
        if (this.f2872z == false) goto L67;
        r121.f2885c = false;
    L67:
        this.f2859l = r121;
        r27.getClass();
        AnimController$AnimProcessType r124 = AnimController$AnimProcessType.f2879a;
        r27.f18728b = r124;
        r27.f18729c = r124;
        BottomSheetBehavior r125 = this.f2859l;
        if (r125 != null) goto L70;
        Intrinsics.throwUninitializedPropertyAccessException("behavior");
        r125 = null;
    L70:
        r125.getClass();
        BottomSheetBehavior r126 = this.f2859l;
        if (r126 != null) goto L74;
        Intrinsics.throwUninitializedPropertyAccessException("behavior");
        r126 = null;
    L74:
        if (r126.f2883a == false) goto L77;
        r126.f2883a = false;
    L77:
        BottomSheetBehavior r127 = this.f2859l;
        if (r127 != null) goto L80;
        Intrinsics.throwUninitializedPropertyAccessException("behavior");
        r127 = null;
    L80:
        AppletPopupSchemaParam r30 = this.f2857j;
        if (r30 != null) goto L83;
        Intrinsics.throwUninitializedPropertyAccessException("schemaParam");
        r30 = null;
    L83:
        r127.b(r30.f2891i);
        BottomSheetBehavior r128 = this.f2859l;
        if (r128 != null) goto L86;
        Intrinsics.throwUninitializedPropertyAccessException("behavior");
        r128 = null;
    L86:
        AppletPopupSchemaParam r31 = this.f2857j;
        if (r31 != null) goto L89;
        Intrinsics.throwUninitializedPropertyAccessException("schemaParam");
        r31 = null;
    L89:
        r128.e = r31.f2896n;
        BottomSheetBehavior r129 = this.f2859l;
        if (r129 != null) goto L92;
        Intrinsics.throwUninitializedPropertyAccessException("behavior");
        r129 = null;
    L92:
        e(4);
        r129.getClass();
        BottomSheetBehavior r130 = this.f2859l;
        if (r130 != null) goto L95;
        Intrinsics.throwUninitializedPropertyAccessException("behavior");
    L96:
        e(3);
        r11.getClass();
        h(R$id.engine_container);
        return r114;
    L95:
        r11 = r130;
        goto L96
    L98:
        View r131 = r13.inflate(R$layout.applet_fragment_popup, r14, false);
        this.f2853b = (FrameLayout) r131.findViewById(R$id.popup_root);
        LinearLayout r132 = (LinearLayout) r131.findViewById(R$id.popup_container);
        h(R$id.popup_inner_container);
        r132.setOnClickListener(new j(1));
        this.f2854c = r132;
        this.d = (RadiusLayout) r131.findViewById(R$id.popup_inner_container);
        this.e = (FrameLayout) r131.findViewById(R$id.popup_top_container);
        this.f = r131.findViewById(R$id.popup_bg);
        ArrayList r133 = this.f2855h;
        AppletPopupSchemaParam r32 = this.f2857j;
        if (r32 != null) goto L101;
        Intrinsics.throwUninitializedPropertyAccessException("schemaParam");
        r32 = null;
    L101:
        LinearLayout r33 = this.f2854c;
        if (r33 != null) goto L104;
        Intrinsics.throwUninitializedPropertyAccessException("popupContainer");
        r33 = null;
    L104:
        r133.add(new k3.b(r32, r33, this.D));
        AppletPopupSchemaParam r134 = this.f2857j;
        if (r134 != null) goto L107;
        Intrinsics.throwUninitializedPropertyAccessException("schemaParam");
        r134 = null;
    L107:
        LinearLayout r34 = this.f2854c;
        if (r34 != null) goto L110;
        Intrinsics.throwUninitializedPropertyAccessException("popupContainer");
        r34 = null;
    L110:
        k3.b r135 = new k3.b(r134, r34, r27);
        this.f2856i = r135;
        h3.c r136 = (h3.c) this.G.getValue();
        AppletPopupSchemaParam r35 = this.f2857j;
        if (r35 != null) goto L113;
        Intrinsics.throwUninitializedPropertyAccessException("schemaParam");
    L114:
        r135.b(r136, r10.d, new f(25));
        d(this, false, false, 7);
        return r131;
    L113:
        r10 = r35;
        goto L114
    L23:
        r111 = null;
        goto L24
    L16:
        r17 = "not null";
        goto L17
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        View r5 = getView();
        if (r5 == null) goto L13;
        ViewTreeObserver r10 = r5.getViewTreeObserver();
        if (r10 == null) goto L13;
        if (r10.isAlive() != true) goto L13;
        View r11 = getView();
        if (r11 == null) goto L13;
        ViewTreeObserver r12 = r11.getViewTreeObserver();
        if (r12 == null) goto L13;
        r12.removeOnWindowFocusChangeListener(this);
    L13:
        View r13 = this.B;
        if (r13 == null) goto L23;
        LinkedHashMap r14 = h3.e.f17278a;
        Intrinsics.checkNotNullParameter(r13, "view");
        b r15 = this.J;
        Intrinsics.checkNotNullParameter(r15, "listener");
        int r16 = r13.hashCode();
        LinkedHashMap r17 = h3.e.f17278a;
        List r18 = (List) r17.get(Integer.valueOf(r16));
        if (r18 == null) goto L18;
        r18.remove(r15);
    L18:
        List r19 = (List) r17.get(Integer.valueOf(r16));
        if (r19 == null) goto L23;
        if (r19.isEmpty() != true) goto L23;
        r17.remove(Integer.valueOf(r16));
    L23:
        this.B = null;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onDetach() {
        super.onDetach();
        f(false);
    }

    @Override // androidx.fragment.app.Fragment
    public final void onHiddenChanged(boolean r5) {
        super.onHiddenChanged(r5);
        f(!r5);
    }

    @Override // androidx.fragment.app.Fragment
    public final void onResume() {
        super.onResume();
        this.f2870x = true;
        f(true);
        if (this.f2862o != (-1)) goto L10;
        BottomSheetBehavior r5 = this.f2859l;
        if (r5 == null) goto L7;
        int r10 = r5.g;
    L8:
        this.f2862o = r10;
        return;
    L7:
        r10 = 3;
        goto L8
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onSaveInstanceState(Bundle r5) {
        Intrinsics.checkNotNullParameter(r5, "outState");
        super.onSaveInstanceState(r5);
        r5.putAll(getArguments());
        AppletPopupSchemaParam r10 = this.f2857j;
        if (r10 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("schemaParam");
        r10 = null;
    L5:
        r5.putSerializable("popupSchema", r10);
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View r5) {
        Intrinsics.checkNotNullParameter(r5, "v");
        f(true);
    }

    @Override // androidx.fragment.app.Fragment
    public final void onViewCreated(View r11, Bundle r12) {
        Intrinsics.checkNotNullParameter(r11, "view");
        super.onViewCreated(r11, r12);
        r11.getViewTreeObserver().addOnWindowFocusChangeListener(this);
        r11.addOnAttachStateChangeListener(this);
        if (this.f2859l == null) goto L17;
        a r13 = new a(this, 1);
        this.f2863p = false;
        this.f2865r = r13;
        Window r14 = g();
        if (r14 == null) goto L7;
        View r15 = r14.getDecorView();
    L9:
        if (this.H == true) goto L17;
        this.H = true;
        String r5 = this + " ######registerRootViewGlobalLayoutChangeListerOnce#####";
        Intrinsics.checkNotNullParameter("AppletPopup", "tag");
        d r10 = c.f2846a;
        if (r10 == null) goto L13;
        r10.d("AppletPopup", r5);
    L13:
        if (r15 == null) goto L17;
        ViewTreeObserver r16 = r15.getViewTreeObserver();
        if (r16 == null) goto L17;
        r16.addOnGlobalLayoutListener(this.I);
        goto L17
    L7:
        r15 = null;
    L17:
        ArrayList r17 = this.f2855h;
        AppletPopupSchemaParam r18 = this.f2857j;
        if (r18 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("schemaParam");
        r18 = null;
    L20:
        LinearLayout r19 = this.f2854c;
        if (r19 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("popupContainer");
        r19 = null;
    L23:
        r17.add(new k3.c(r18, r19));
        AppletPopupSchemaParam r20 = this.f2857j;
        if (r20 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("schemaParam");
        r20 = null;
    L26:
        LinearLayout r21 = this.f2854c;
        if (r21 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("popupContainer");
        r21 = null;
    L29:
        RadiusLayout r22 = this.d;
        if (r22 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("popupInnerContainer");
        r22 = null;
    L32:
        k();
        AppletPopupSchemaParam r23 = this.f2857j;
        if (r23 != null) goto L35;
        Intrinsics.throwUninitializedPropertyAccessException("schemaParam");
        r23 = null;
    L35:
        r17.add(new k3.c(r20, r21, r22, r23.a(getContext())));
        AppletPopupSchemaParam r24 = this.f2857j;
        if (r24 != null) goto L38;
        Intrinsics.throwUninitializedPropertyAccessException("schemaParam");
        r24 = null;
    L38:
        View r25 = this.f;
        if (r25 != null) goto L41;
        Intrinsics.throwUninitializedPropertyAccessException("popupBg");
        r25 = null;
    L41:
        r17.add(new k3.c(r24, r25));
        AppletPopupSchemaParam r26 = this.f2857j;
        if (r26 != null) goto L44;
        Intrinsics.throwUninitializedPropertyAccessException("schemaParam");
        r26 = null;
    L44:
        View r27 = this.f;
        if (r27 != null) goto L47;
        Intrinsics.throwUninitializedPropertyAccessException("popupBg");
        r27 = null;
    L47:
        r17.add(new k3.d(r26, r27));
        AppletPopupSchemaParam r28 = this.f2857j;
        if (r28 != null) goto L50;
        Intrinsics.throwUninitializedPropertyAccessException("schemaParam");
        r28 = null;
    L50:
        View r29 = this.f;
        if (r29 != null) goto L53;
        Intrinsics.throwUninitializedPropertyAccessException("popupBg");
        r29 = null;
    L53:
        r17.add(new k3.b(r28, r29, new h3.b(this, 1)));
        AppletPopupSchemaParam r30 = this.f2857j;
        if (r30 != null) goto L56;
        Intrinsics.throwUninitializedPropertyAccessException("schemaParam");
        r30 = null;
    L56:
        LinearLayout r31 = this.f2854c;
        if (r31 != null) goto L59;
        Intrinsics.throwUninitializedPropertyAccessException("popupContainer");
        r31 = null;
    L59:
        r17.add(new k3.c(r30, r31, this.D));
        Iterator r110 = r17.iterator();
    L61:
        if (r110.hasNext() == false) goto L63;
        ((j3.a) r110.next()).invoke();
        goto L61
    L63:
        Dialog r111 = getDialog();
        if (r111 == null) goto L66;
        Window r112 = r111.getWindow();
    L67:
        AppletPopupSchemaParam r32 = this.f2857j;
        if (r32 != null) goto L71;
        Intrinsics.throwUninitializedPropertyAccessException("schemaParam");
        r32 = null;
    L71:
        if (this.f2854c != null) goto L73;
        Intrinsics.throwUninitializedPropertyAccessException("popupContainer");
    L73:
        Intrinsics.checkNotNullParameter(r32, "schemaParams");
        int r33 = r32.f2901t;
        if (r33 != 0) goto L76;
        if (r112 == null) goto L88;
        r112.setSoftInputMode(48);
    L88:
        if (getActivity() != null) goto L90;
        return;
    L90:
        if (k() == true) goto L125;
        int r113 = e.a(g(), getView(), this);
        AppletPopupSchemaParam r34 = this.f2857j;
        if (r34 != null) goto L95;
        Intrinsics.throwUninitializedPropertyAccessException("schemaParam");
        r34 = null;
    L95:
        if (Intrinsics.areEqual(r34.a(getContext()), "center") == true) goto L106;
        AppletPopupSchemaParam r35 = this.f2857j;
        if (r35 != null) goto L99;
        Intrinsics.throwUninitializedPropertyAccessException("schemaParam");
        r35 = null;
    L99:
        FragmentActivity r36 = getActivity();
        int r37 = r35.d;
        if (AppletPopupSchemaParam.b(r36) == false) goto L104;
        int r38 = r35.e;
        if (r38 <= 0) goto L104;
        r37 = r38;
    L104:
        e(null);
        if (r37 <= r113) goto L106;
    L121:
        int r114 = r11.getPaddingLeft();
        int r39 = r11.getPaddingTop();
        e(null);
        r11.setPadding(r114, r39, r11.getPaddingRight(), r11.getPaddingBottom());
        return;
    L106:
        AppletPopupSchemaParam r40 = this.f2857j;
        if (r40 != null) goto L110;
        Intrinsics.throwUninitializedPropertyAccessException("schemaParam");
        r40 = null;
    L110:
        if (Intrinsics.areEqual(r40.a(getContext()), "center") == false) goto L126;
        AppletPopupSchemaParam r41 = this.f2857j;
        if (r41 != null) goto L114;
        Intrinsics.throwUninitializedPropertyAccessException("schemaParam");
        r41 = null;
    L114:
        FragmentActivity r42 = getActivity();
        int r43 = r41.d;
        if (AppletPopupSchemaParam.b(r42) == false) goto L119;
        int r44 = r41.e;
        if (r44 <= 0) goto L119;
        r43 = r44;
    L119:
        e(null);
        if (r43 > r113) goto L121;
        return;
    L126:
        return;
    L125:
        return;
    L76:
        if (r33 != 1) goto L78;
        if (r112 == null) goto L88;
        r112.setSoftInputMode(32);
        goto L88
    L78:
        if (r33 == 2) goto L81;
        if (r112 == null) goto L88;
        r112.setSoftInputMode(32);
        goto L88
    L81:
        if (r112 == null) goto L88;
        r112.setSoftInputMode(16);
        goto L88
    L66:
        r112 = null;
        goto L67
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View r5) {
        Intrinsics.checkNotNullParameter(r5, "v");
        r5.removeOnAttachStateChangeListener(this);
        f(false);
    }

    @Override // android.view.ViewTreeObserver.OnWindowFocusChangeListener
    public final void onWindowFocusChanged(boolean r5) {
        f(r5);
    }

    @Override // androidx.fragment.app.Fragment
    public final void setUserVisibleHint(boolean r5) {
        super.setUserVisibleHint(r5);
        f(r5);
    }

    @Override // androidx.fragment.app.DialogFragment
    public final void show(FragmentManager r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "manager");
        Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L5
        Field r12 = DialogFragment.class.getDeclaredField("mDismissed");     // Catch: Throwable -> L5
        r12.setAccessible(true);     // Catch: Throwable -> L5
        r12.set(this, Boolean.FALSE);     // Catch: Throwable -> L5
        Field r13 = DialogFragment.class.getDeclaredField("mShownByMe");     // Catch: Throwable -> L5
        r13.setAccessible(true);     // Catch: Throwable -> L5
        r13.set(this, Boolean.TRUE);     // Catch: Throwable -> L5
        Result.m124constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L5
    L29:
        FragmentTransaction r14 = r10.beginTransaction();     // Catch: Throwable -> L12
        Fragment r15 = r10.findFragmentByTag(r11);     // Catch: Throwable -> L12
        if (r15 == null) goto L15;
        String r16 = "showAllowingStateLoss remove fragment[" + getId() + ']';     // Catch: Throwable -> L12
        Intrinsics.checkNotNullParameter("AppletPopup", "tag");     // Catch: Throwable -> L12
        d r17 = c.f2846a;     // Catch: Throwable -> L12
        if (r17 == null) goto L14;
        r17.d("AppletPopup", r16);     // Catch: Throwable -> L12
    L14:
        r14.remove(r15);     // Catch: Throwable -> L12
    L15:
        String r18 = "showAllowingStateLoss add fragment[" + this + ']';     // Catch: Throwable -> L12
        Intrinsics.checkNotNullParameter("AppletPopup", "tag");     // Catch: Throwable -> L12
        d r19 = c.f2846a;     // Catch: Throwable -> L12
        if (r19 == null) goto L18;
        r19.d("AppletPopup", r18);     // Catch: Throwable -> L12
    L18:
        r14.add(this, r11);     // Catch: Throwable -> L12
        c1.b.b(new a2.b(24, r11, r14));     // Catch: Throwable -> L12
        Object r20 = Result.m124constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L12
    L21:
        Throwable r21 = Result.m127exceptionOrNullimpl(r20);
        if (r21 == null) goto L31;
        Intrinsics.checkNotNullParameter("AppletPopup", "tag");
        d r22 = c.f2846a;
        if (r22 == null) goto L32;
        r22.e("AppletPopup", "showAllowingStateLoss", r21);
        return;
    L32:
        return;
    L31:
        return;
    L12:
        th = move-exception;
        Result.Companion r23 = Result.Companion;
        r20 = Result.m124constructorimpl(ResultKt.createFailure(th));
    L5:
        th = move-exception;
        Result.Companion r24 = Result.Companion;
        Result.m124constructorimpl(ResultKt.createFailure(th));
        goto L29
    }
}
