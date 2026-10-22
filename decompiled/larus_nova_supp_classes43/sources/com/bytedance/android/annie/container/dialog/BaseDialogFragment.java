package com.bytedance.android.annie.container.dialog;

import android.app.Activity;
import android.app.Application;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.bytedance.android.annie.Annie;
import com.bytedance.android.annie.api.card.IHybridComponent;
import com.bytedance.android.annie.api.container.HybridDialog;
import com.bytedance.android.annie.api.container.HybridFragment;
import com.bytedance.android.annie.container.fragment.AnnieFragment;
import com.bytedance.android.annie.dialog.NoMarginSheetBaseDialog;
import com.bytedance.android.annie.log.LogLevel;
import com.bytedance.android.annie.param.p;
import com.bytedance.android.annie.scheme.vo.refactor.BaseHybridParamVoNew;
import com.bytedance.android.annie.scheme.vo.refactor.FragmentParamVoNew;
import com.bytedance.android.annie.scheme.vo.refactor.PopupHybridParamVoNew;
import com.bytedance.android.annie.service.setting.AnnieConfigSettingKeys;
import com.bytedance.android.annie.util.m;
import com.bytedance.android.annie.util.t;
import com.bytedance.android.livesdk.pannel.SheetBaseBehavior;
import com.bytedance.android.livesdk.pannel.SheetBaseDialog;
import com.bytedance.common.utility.UIUtils;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.childwindow.LandscapeChildDialogBoundsAdapter;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0005B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/annie/container/dialog/BaseDialogFragment;", "Lcom/bytedance/android/annie/api/container/HybridDialog;", "Landroid/content/DialogInterface$OnShowListener;", "<init>", "()V", "a", "annie_release"}, k = 1, mv = {1, 4, 3})
public abstract class BaseDialogFragment extends HybridDialog implements DialogInterface.OnShowListener {
    public static final /* synthetic */ int r = 0;
    public Map<Integer, View> d;
    public PopupHybridParamVoNew e;
    public HybridFragment f;
    public int g;
    public int h;
    public View i;
    public boolean j;
    public boolean k;
    public boolean l;
    public final List<HybridDialog.a> m;
    public p n;
    public final Lazy o;
    public Boolean p;
    public boolean q;

    public static final class a {
    }

    static {
    }

    public abstract void ba0();

    public abstract AnnieFragment ea0(PopupHybridParamVoNew r1);

    public abstract void ia0(String r1);

    public abstract void ja0(Bundle r1);

    public abstract void oa0();

    public final void ca0() {
        PopupHybridParamVoNew r0 = this.e;
        if (r0 == null) goto L14;
        if (r0 == null) goto L15;
        SheetBaseDialog r1 = getDialog();
        if ((r1 instanceof SheetBaseDialog) == false) goto L8;
        SheetBaseDialog r10 = r1;
    L9:
        if (r10 == null) goto L16;
        boolean r11 = r0.S2();
        int r12 = r0.getHeight();
        int r13 = r0.v3();
        r10.k = r11;
        if (r13 <= 0) goto L17;
        r10.l = (int) pn2.c.a(r10.getContext(), r12 - r13);
        return;
    L17:
        return;
    L16:
        return;
    L8:
        r10 = null;
        goto L9
    L15:
        return;
    }

    public final int fa0() {
        p r0 = this.n;
        if (r0 == null) goto L6;
        return r0.d;
    L6:
        return t.a.e(getActivity());
    }

    public final int ga0() {
        p r0 = this.n;
        if (r0 != null) goto L10;
        FragmentActivity r1 = getActivity();
        if (r1 == null) goto L9;
        return UIUtils.getScreenWidth(r1);
    L9:
        return com.bytedance.android.annie.util.p.a.e();
    L10:
        return r0.a.widthPixels;
    }

    public final boolean ha0() {
        p r0 = this.n;
        if (r0 == null) goto L14;
        int r1 = r0.b;
        if (r1 != 0) goto L7;
    L12:
        return true;
    L7:
        if (r1 == 8) goto L12;
        if (r1 == 6) goto L12;
        return false;
    L14:
        return m.a(getActivity());
    }

    public final boolean isFullScreen() {
        if (com.bytedance.android.annie.ng.g.g == true) goto L5;
    L9:
        PopupHybridParamVoNew r0 = this.e;
        if (r0 != null) goto L12;
    L14:
        boolean r1 = false;
    L15:
        if (r1 == false) goto L21;
        PopupHybridParamVoNew r10 = this.e;
        if (r10 != null) goto L19;
        return false;
    L19:
        if (r10.x3() != true) goto L29;
    L20:
        return true;
    L29:
        return false;
    L21:
        PopupHybridParamVoNew r11 = this.e;
        if (r11 == null) goto L24;
        int r12 = r11.U2();
    L26:
        if (RangesKt.coerceAtMost(r12 / 100.0f, 1.0f) >= 1.0f) goto L20;
        return false;
    L24:
        r12 = 0;
        goto L26
    L12:
        if (r0.S2() != true) goto L14;
        r1 = true;
        goto L15
    L5:
        if (com.bytedance.android.annie.ng.g.b().b.c == false) goto L7;
    L8:
        return false;
    L7:
        if (com.bytedance.android.annie.ng.g.b().b.d == false) goto L9;
        goto L8
    }

    public final boolean na0() {
        PopupHybridParamVoNew r0 = this.e;
        if (r0 != null) goto L5;
        return true;
    L5:
        if (r0 != null) goto L7;
        return true;
    L7:
        if ((r0.T2() & 80) != 80) goto L9;
        boolean r10 = true;
    L11:
        if (r0.r3() == false) goto L19;
        if (r10 == true) goto L14;
    L16:
        return false;
    L14:
        if (r0.s3() == true) goto L16;
        return true;
    L19:
        return true;
    L9:
        r10 = false;
        goto L11
    }

    public BaseDialogFragment() {
        this.d = new LinkedHashMap();
        this.g = -16777216;
        this.j = true;
        this.k = true;
        this.l = true;
        this.m = new ArrayList();
        this.o = LazyKt.lazy(BaseDialogFragment$changeConfigDialogTime$2.INSTANCE);
        this.q = true;
    }

    public final void dismiss() {
        if (getFragmentManager() == null) goto L13;
        super.dismiss();     // Catch: Exception -> L6
        return;
    L6:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r0 = DialogFragmentLancet.sLastShowStack;
        if (r0 == null) goto L14;
        com.bytedance.crash.d.d(r0, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    L14:
        return;
    }

    public final void dismissAllowingStateLoss() {
        if (getFragmentManager() == null) goto L13;
        super.dismissAllowingStateLoss();     // Catch: Exception -> L6
        return;
    L6:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r0 = DialogFragmentLancet.sLastShowStack;
        if (r0 == null) goto L14;
        com.bytedance.crash.d.d(r0, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    L14:
        return;
    }

    public final void ma0() {
        Dialog r0 = getDialog();
        if (r0 == null) goto L7;
        Window r1 = r0.getWindow();
        if (r1 == null) goto L7;
        r1.addFlags(Integer.MIN_VALUE);
    L7:
        Dialog r10 = getDialog();
        if (r10 == null) goto L12;
        Window r11 = r10.getWindow();
        if (r11 == null) goto L12;
        r11.clearFlags(67108864);
    L12:
        Dialog r12 = getDialog();
        Window r13 = null;
        if (r12 == null) goto L15;
        Window r14 = r12.getWindow();
    L17:
        if (r14 == null) goto L21;
        r14.setStatusBarColor(0);
    L21:
        if (AnnieConfigSettingKeys.ENABLE_ANNIE_DIALOG_NAVIGATION_BAR_COLOR_SET.a().booleanValue() == false) goto L34;
        Dialog r15 = getDialog();
        if (r15 == null) goto L27;
        Window r16 = r15.getWindow();
        if (r16 == null) goto L27;
        r16.clearFlags(134217728);
    L27:
        Dialog r17 = getDialog();
        if (r17 == null) goto L30;
        r13 = r17.getWindow();
    L30:
        if (r13 == null) goto L35;
        r13.setNavigationBarColor(0);
        return;
    L35:
        return;
    L34:
        return;
    L15:
        r14 = null;
        goto L17
    }

    public void onDestroy() {
        super/*androidx.fragment.app.Fragment*/.onDestroy();
        k.c(this);
    }

    public final void onDestroyView() {
        super.onDestroyView();
        this.d.clear();
    }

    public final void onResume() {
        super/*androidx.fragment.app.Fragment*/.onResume();
        Application r0 = com.bytedance.android.annie.ng.g.a;
    }

    public final void onStart() {
        PopupOrDialogVisibilityTracker.bindDialogFragment(this);
        LandscapeRestrictionGuard.bindDialogForAllowedDialogFragment(this);
        super.onStart();
        if (com.bytedance.android.annie.ng.g.g == true) goto L6;
        return;
    L6:
        if (AnnieConfigSettingKeys.ENABLE_FIX_TRANSITION_ANIM.a().booleanValue() == false) goto L39;
        Dialog r0 = getDialog();
        if (r0 == null) goto L10;
        Window r1 = r0.getWindow();
    L12:
        if (Intrinsics.areEqual(this.p, Boolean.TRUE) == false) goto L34;
        if (r1 == null) goto L34;
        this.p = Boolean.FALSE;
        PopupHybridParamVoNew r10 = this.e;
        if (r10 == null) goto L34;
        WindowManager.LayoutParams r11 = r1.getAttributes();
        if (r10.g3() == true) goto L19;
    L37:
        Result.Companion r12 = Result.Companion;     // Catch: Throwable -> L27
        r1.setAttributes(r11);     // Catch: Throwable -> L27
        Object r13 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L27
    L29:
        Throwable r14 = Result.exceptionOrNull-impl(r13);
        if (r14 == null) goto L32;
        b8.a r15 = b8.a.a;
        b8.a.a(new b8.b("BaseDialogFragment", LogLevel.ERROR, r14, null, 8), true);
    L32:
        Result.box-impl(r13);
    L27:
        th = move-exception;
        Result.Companion r16 = Result.Companion;
        r13 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L29
    L19:
        if (com.bytedance.android.annie.util.p.a.getResources().getConfiguration().orientation != 2) goto L21;
        r11.windowAnimations = 2131954082;
        goto L37
    L21:
        PopupHybridParamVoNew r17 = this.e;
        Intrinsics.checkNotNull(r17);
        if (TextUtils.equals(r17.j3(), "right") == false) goto L24;
        r11.windowAnimations = 2131954082;
        goto L37
    L24:
        r11.windowAnimations = 2131954083;
    L34:
        if (this.p != null) goto L40;
        this.p = Boolean.TRUE;
        return;
    L40:
        return;
    L10:
        r1 = null;
        goto L12
    }

    @Override // com.bytedance.android.annie.api.container.HybridDialog
    public final IHybridComponent getHybridComponent() {
        return this.f;
    }

    @Override // com.bytedance.android.annie.api.container.HybridDialog
    public final void T90(HybridDialog.a r10) {
        Intrinsics.checkNotNullParameter(r10, "listener");
        ((ArrayList) this.m).add(r10);
    }

    @Override // com.bytedance.android.annie.api.container.HybridDialog
    public final void U90(boolean r10) {
        setCancelable(r10);
        Dialog r0 = getDialog();
        if (r0 == null) goto L6;
        r0.setCanceledOnTouchOutside(r10);
        return;
    }

    @Override // com.bytedance.android.annie.api.container.HybridDialog
    public final void V90(boolean r1) {
        this.k = r1;
    }

    @Override // com.bytedance.android.annie.api.container.HybridDialog
    public final void W90(boolean r1) {
        this.j = r1;
    }

    @Override // com.bytedance.android.annie.api.container.HybridDialog
    public final void Y90(boolean r10) {
        com.bytedance.android.annie.scheme.helper.a.d(this.e, "pull_down_close", Boolean.valueOf(r10));
    }

    @Override // com.bytedance.android.annie.api.container.HybridDialog
    public final void Z90(boolean r10) {
        PopupHybridParamVoNew r0 = this.e;
        boolean r1 = true;
        int r11 = 0;
        if (r0 != null) goto L5;
    L7:
        boolean r12 = false;
    L8:
        if (r12 == false) goto L44;
        HybridFragment r13 = this.f;
        if ((r13 instanceof AnnieFragment) == false) goto L12;
        AnnieFragment r14 = (AnnieFragment) r13;
    L13:
        if (r14 == null) goto L45;
        IHybridComponent r15 = r14.getMAnnieCard();
        if (r15 != null) goto L17;
    L19:
        boolean r16 = false;
    L21:
        if (r16 == false) goto L36;
        FragmentParamVoNew r17 = r14.e;
        if (r17 != null) goto L25;
    L27:
        r1 = false;
    L28:
        if (r1 == false) goto L36;
        View r18 = r14.i;
        if (r18 == null) goto L47;
        if (r10 == true) goto L35;
        r11 = 8;
    L35:
        r18.setVisibility(r11);
        return;
    L47:
        return;
    L25:
        if (r17.W1() != true) goto L27;
    L36:
        View r19 = r14.j;
        if (r19 == null) goto L48;
        if (r10 == true) goto L42;
        r11 = 8;
    L42:
        r19.setVisibility(r11);
        return;
    L48:
        return;
    L17:
        if (r15.canGoBack() != true) goto L19;
        r16 = true;
        goto L21
    L45:
        return;
    L12:
        r14 = null;
        goto L13
    L44:
        return;
    L5:
        if (r0.S2() != true) goto L7;
        r12 = true;
        goto L8
    }

    public final View aa0(int r10) {
        if (this.d != null) goto L5;
        this.d = new LinkedHashMap();
    L5:
        View r0 = this.d.get(Integer.valueOf(r10));
        if (r0 != null) goto L14;
        View r1 = getView();
        if (r1 == null) goto L12;
        View r11 = r1.findViewById(r10);
        if (r11 == null) goto L12;
        Integer r12 = Integer.valueOf(r10);
        this.d.put(r12, r11);
        return r11;
    L12:
        return null;
    L14:
        return r0;
    }

    public final int da0(float r10) {
        p r0 = this.n;
        if (r0 == null) goto L6;
        return (int) ((r10 * r0.a.density) + 0.5f);
    L6:
        return com.bytedance.android.annie.util.p.a.a(r10);
    }

    public final <T extends com.bytedance.android.annie.service.a> T getService(Class<? extends T> r10) {
        Intrinsics.checkNotNullParameter(r10, "clazz");
        return (T) Annie.getService(r10, ((AnnieDialog) this).getBizKey());
    }

    public final void ka0(int r10) {
        JSONObject r0 = new JSONObject();
        r0.put(com.bytedance.android.ec.core.event.a.KEY_STATUS, r10);     // Catch: JSONException -> L5
        sendJsEvent("H5_halfFullStatusChange", r0);     // Catch: JSONException -> L5
        return;
    }

    public void onActivityCreated(Bundle r18) {
        super.onActivityCreated(r18);
        if (com.bytedance.android.annie.ng.g.g == true) goto L6;
        return;
    L6:
        if (((Boolean) this.o.getValue()).booleanValue() == true) goto L8;
        ma0();
    L8:
        Dialog r0 = getDialog();
        if (r0 == null) goto L11;
        Window r10 = r0.getWindow();
    L12:
        PopupHybridParamVoNew r11 = this.e;
        if (r11 == null) goto L94;
        qa0(getDialog(), r11.getWidth(), r11.getHeight(), r11.T2());
        FrameLayout r1 = (FrameLayout) aa0(2131383767);
        if (r1 == null) goto L17;
        r1.post(new g(r11, this));
    L17:
        if (r10 == null) goto L94;
        PopupHybridParamVoNew r12 = this.e;
        if (r12 == null) goto L86;
        if (r12.C3() == true) goto L23;
        r10.setSoftInputMode(48);
    L23:
        WindowManager.LayoutParams r13 = r10.getAttributes();
        if (r12.g3() == false) goto L36;
        p r14 = this.n;
        if (r14 == null) goto L28;
        int r15 = r14.e;
    L30:
        if (r15 != 2) goto L33;
        r13.windowAnimations = 2131954079;
    L105:
        Result.Companion r16 = Result.Companion;     // Catch: Throwable -> L39
        r10.setAttributes(r13);     // Catch: Throwable -> L39
        Object r17 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L39
    L41:
        Throwable r19 = Result.exceptionOrNull-impl(r17);
        boolean r20 = true;
        if (r19 == null) goto L45;
        b8.a r21 = b8.a.a;
        b8.a.a(new b8.b("BaseDialogFragment", LogLevel.ERROR, r19, null, 8), true);
    L45:
        if (r12.e3() <= 0) goto L48;
        r10.addFlags(2);
        r10.setDimAmount(r12.e3());
    L50:
        String r22 = r12.f3();
        if (r22 != null) goto L53;
    L55:
        boolean r23 = false;
    L56:
        if (r23 == false) goto L62;
        r10.setBackgroundDrawable(new ColorDrawable(Color.parseColor(r12.f3())));     // Catch: Exception -> L59
    L59:
        e = move-exception;
        b8.a r24 = b8.a.a;
        b8.a.a(new b8.b("BaseDialogFragment", LogLevel.ERROR, e, null, 8), true);
    L62:
        if (com.bytedance.android.annie.ng.g.b().b.c == false) goto L66;
        com.bytedance.android.annie.ng.g.b().getClass();
        if (com.bytedance.android.annie.ng.e.a.j == true) goto L66;
    L74:
        PopupHybridParamVoNew r25 = this.e;
        if (r25 != null) goto L78;
    L83:
        if (r20 == false) goto L86;
        r10.addFlags(32);
        r10.getAttributes().dimAmount = 0.0f;
        goto L86
    L78:
        if (r25.getWidth() == 0) goto L80;
    L82:
        r20 = false;
        goto L83
    L80:
        if (r25.getHeight() != 0) goto L82;
    L66:
        if (com.bytedance.android.annie.ng.g.b().b.d == true) goto L74;
        if (r12.getWidth() <= 0) goto L70;
        int r26 = da0(r12.getWidth() + r12.getMarginRight());
    L71:
        r10.setLayout(r26, -1);
        if (isFullScreen() == true) goto L74;
        r10.setFlags(1024, 1024);
        goto L74
    L70:
        r26 = r12.getWidth();
        goto L71
    L53:
        if ((!StringsKt.isBlank(r22)) != true) goto L55;
        r23 = true;
        goto L56
    L48:
        if (na0() == false) goto L50;
        r10.clearFlags(6);
        r10.setDimAmount(0.0f);
    L39:
        th = move-exception;
        Result.Companion r27 = Result.Companion;
        r17 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L41
    L33:
        if (TextUtils.equals(r12.j3(), "right") == false) goto L35;
        r13.windowAnimations = 2131954079;
        goto L105
    L35:
        r13.windowAnimations = 2131954080;
        goto L105
    L28:
        r15 = com.bytedance.android.annie.util.p.a.getResources().getConfiguration().orientation;
        goto L30
    L36:
        r13.windowAnimations = 2131954081;
    L86:
        if (r11.S2() == false) goto L94;
        SheetBaseDialog r28 = getDialog();
        i r29 = new i(this);
        if ((r28 instanceof SheetBaseDialog) == false) goto L90;
        SheetBaseDialog r30 = r28;
    L91:
        if (r30 == null) goto L94;
        r30.f = r29;
        goto L94
    L90:
        r30 = null;
    L94:
        if (getShowsDialog() == true) goto L96;
    L103:
        this.n = null;
        return;
    L96:
        if (AnnieConfigSettingKeys.ENABLE_WEAK_DIALOG_LISTENER.a().booleanValue() == false) goto L100;
        Dialog r31 = getDialog();
        if (r31 == null) goto L103;
        int r32 = t7.a.a;
        r31.setOnShowListener(new t7.b(this));
        goto L103
    L100:
        Dialog r33 = getDialog();
        if (r33 == null) goto L103;
        r33.setOnShowListener(this);
        goto L103
    L11:
        r10 = null;
        goto L12
    }

    public void onCreate(Bundle r10) {
        if (r10 == null) goto L5;
        r10.remove("android:support:fragments");
    L5:
        if (r10 == null) goto L7;
        r10.remove("android:fragments");
    L7:
        if (r10 == null) goto L11;
        Bundle r1 = r10.getBundle("androidx.lifecycle.BundlableSavedStateRegistry.key");
        if (r1 == null) goto L11;
        r1.remove("android:support:fragments");
    L11:
        super.onCreate(r10);
        if (AnnieConfigSettingKeys.ENABLE_REUSE_SCREEN_SIZE_PARAMS.a().booleanValue() == false) goto L15;
        this.n = new p(getActivity());
    L15:
        if (com.bytedance.android.annie.ng.g.g == false) goto L52;
        Bundle r11 = getArguments();
        Unit r12 = null;
        if (r11 == null) goto L30;
        Parcelable r13 = r11.getParcelable("hybrid_pop_vo_new");
        if ((r13 instanceof PopupHybridParamVoNew) == false) goto L28;
        PopupHybridParamVoNew r14 = (PopupHybridParamVoNew) r13;
    L29:
        this.e = r14;
        ja0(r11);
        goto L30
    L28:
        r14 = null;
    L30:
        PopupHybridParamVoNew r15 = this.e;
        if (r15 == null) goto L35;
        String r16 = r15.o();
        if (r16 != null) goto L36;
        r16 = r15.b;
    L36:
        if (r16 == null) goto L38;
        k.b(r16, this);
        r12 = Unit.INSTANCE;
    L38:
        if (r12 != null) goto L46;
        dismissAllowingStateLoss();     // Catch: Exception -> L41
    L41:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r17 = DialogFragmentLancet.sLastShowStack;
        if (r17 == null) goto L46;
        com.bytedance.crash.d.d(r17, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
    L46:
        if ((!ha0()) == false) goto L48;
        setStyle(1, 2131954074);
        return;
    L48:
        setStyle(1, 2131954073);
        return;
    L35:
        r16 = null;
        goto L36
    L52:
        dismissAllowingStateLoss();     // Catch: Exception -> L18
        return;
    L18:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r18 = DialogFragmentLancet.sLastShowStack;
        if (r18 == null) goto L54;
        com.bytedance.crash.d.d(r18, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v3, types: [android.app.Dialog] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    public final Dialog onCreateDialog(Bundle r10) {
        if (com.bytedance.android.annie.ng.g.g == false) goto L5;
        Context r0 = getContext();
        boolean r1 = true;
        if (r0 == null) goto L35;
        PopupHybridParamVoNew r11 = this.e;
        boolean r12 = false;
        if (r11 != null) goto L11;
    L13:
        boolean r13 = false;
    L14:
        if (r13 == true) goto L16;
    L22:
        boolean r14 = m.a((Activity) r0);
        boolean r15 = com.bytedance.android.annie.ng.g.b().b.c;
        if (getContext() == null) goto L34;
        boolean r16 = ha0();
        if (isFullScreen() == false) goto L31;
        if (r16 == true) goto L31;
        if (com.bytedance.android.annie.ng.g.b().b.c == true) goto L31;
    L33:
        r12 = true;
    L31:
        if (AnnieConfigSettingKeys.HYBRID_LANDSCAPE_IS_FULLSCREEN.a().booleanValue() == false) goto L34;
        if (r16 == true) goto L33;
    L34:
        ?? r17 = new NoMarginSheetBaseDialog(r0, r14, r15, r12);
    L36:
        if (r17 == 0) goto L43;
        PopupHybridParamVoNew r18 = this.e;
        if (r18 == null) goto L40;
        r1 = r18.P2();
    L40:
        setCancelable(r1);
        r17.setCanceledOnTouchOutside(r1);
        return r17;
    L43:
        return super.onCreateDialog(r10);
    L16:
        if (com.bytedance.android.annie.ng.g.b().b.c == true) goto L22;
        if (com.bytedance.android.annie.ng.g.b().b.d == true) goto L22;
        Dialog r19 = super.onCreateDialog(r10);
        Window r20 = r19.getWindow();
        r17 = r19;
        if (r20 == null) goto L36;
        r20.setBackgroundDrawable(new ColorDrawable(0));
        r20.addFlags(65792);
        r17 = r19;
        goto L36
    L11:
        if (r11.N2() != true) goto L13;
        r13 = true;
        goto L14
    L35:
        r17 = 0;
        goto L36
    L5:
        return super.onCreateDialog(r10);
    }

    public void onDismiss(DialogInterface r10) {
        Intrinsics.checkNotNullParameter(r10, "dialog");     // Catch: Throwable -> L9
        super.onDismiss(r10);     // Catch: Throwable -> L9
        Iterator r11 = ((ArrayList) this.m).iterator();     // Catch: Throwable -> L9
    L4:
        if (r11.hasNext() == false) goto L7;
        ((HybridDialog.a) r11.next()).onDismiss();     // Catch: Throwable -> L9
        goto L4
    L7:
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
        return;
    L9:
        th = move-exception;
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
        throw th;
    }

    public void onShow(DialogInterface r10) {
        Iterator<T> r11 = this.m.iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        ((HybridDialog.a) r11.next()).onShow();
        goto L4
    }

    public void onViewCreated(View r10, Bundle r11) {
        Intrinsics.checkNotNullParameter(r10, "view");
        if (com.bytedance.android.annie.ng.g.g == true) goto L6;
        return;
    L6:
        if (((Boolean) this.o.getValue()).booleanValue() == true) goto L8;
        oa0();
        ca0();
    L8:
        SheetBaseDialog r12 = getDialog();
        if ((r12 instanceof SheetBaseDialog) == false) goto L11;
        SheetBaseDialog r13 = r12;
    L12:
        if (r13 == null) goto L14;
        r13.i = new c(this);
    L14:
        ConstraintLayout r14 = aa0(2131374644);
        if (r14 == null) goto L17;
        r14.setOnClickListener(new d(this));
    L17:
        SheetBaseDialog r15 = getDialog();
        if ((r15 instanceof SheetBaseDialog) == false) goto L20;
        SheetBaseDialog r16 = r15;
    L21:
        if (r16 == null) goto L25;
        com.bytedance.android.livesdk.pannel.b r1 = new com.bytedance.android.livesdk.pannel.b(r16, new e(this));
        r16.h = r1;
        SheetBaseBehavior r17 = r16.a;
        if (r17 == null) goto L25;
        r17.e = r1;
    L25:
        PopupHybridParamVoNew r18 = this.e;
        if (r18 != null) goto L28;
    L30:
        boolean r19 = false;
    L31:
        if (r19 == false) goto L33;
        ka0(1);
    L33:
        SheetBaseDialog r20 = getDialog();
        if ((r20 instanceof SheetBaseDialog) == false) goto L36;
        SheetBaseDialog r21 = r20;
    L37:
        if (r21 == null) goto L41;
        com.bytedance.android.livesdk.pannel.c r22 = new com.bytedance.android.livesdk.pannel.c(r21, new f(this, r21));
        r21.g = r22;
        SheetBaseBehavior r23 = r21.a;
        if (r23 == null) goto L41;
        r23.d = r22;
    L41:
        PopupHybridParamVoNew r24 = this.e;
        if (r24 != null) goto L44;
    L52:
        PopupHybridParamVoNew r25 = this.e;
        Intrinsics.checkNotNull(r25);
        AnnieFragment r26 = ea0(r25);
        ia0("create annie fragment succeed and add it");
        this.f = r26;
        b r27 = new b(this);
        r26.getClass();
        Intrinsics.checkNotNullParameter(r27, "l");
        r26.N = r27;
        FragmentTransaction r28 = getChildFragmentManager().beginTransaction();
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r28, r26, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_REPLACE, null, 2131383767) == true) goto L56;
        r28 = r28.replace(2131383767, r26);
    L56:
        r28.commitAllowingStateLoss();
        return;
    L44:
        if (r24.y3() == false) goto L52;
        ImageView r29 = (ImageView) aa0(2131375901);
        if (r29 == null) goto L49;
        r29.setVisibility(0);
    L49:
        ImageView r30 = (ImageView) aa0(2131375901);
        if (r30 == null) goto L52;
        r30.setOnClickListener(new h(this));
        goto L52
    L36:
        r21 = null;
        goto L37
    L28:
        if (r18.S2() != true) goto L30;
        r19 = true;
        goto L31
    L20:
        r16 = null;
        goto L21
    L11:
        r13 = null;
        goto L12
    }

    public final void show(FragmentManager r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "manager");
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L14
        if (r10.isDestroyed() == false) goto L7;
        this.q = false;     // Catch: Throwable -> L14
        return;
    L7:
        r10.beginTransaction().remove(this).commit();     // Catch: Throwable -> L14
        LandscapeRestrictionOperation r12 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;     // Catch: Throwable -> L14
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(this, r11, r12);     // Catch: Throwable -> L14
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r10, this, r12) == false) goto L21;
    L12:
        this.q = true;     // Catch: Throwable -> L14
        Object r13 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L14
    L16:
        Throwable r14 = Result.exceptionOrNull-impl(r13);
        if (r14 == null) goto L24;
        this.q = false;
        int r15 = x8.a.a;
        x8.a.b("BaseDialogFragment", "===show():" + r14.getMessage() + "===", false);
        return;
    L24:
        return;
    L21:
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L20 Throwable -> L14
    L11:
        super.show(r10, r11);     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        Result.Companion r16 = Result.Companion;
        r13 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L16
    }

    public final View onCreateView(LayoutInflater r10, ViewGroup r11, Bundle r12) {
        Intrinsics.checkNotNullParameter(r10, "inflater");
        if (com.bytedance.android.annie.ng.g.g == true) goto L6;
        return null;
    L6:
        ba0();
        if (((Boolean) this.o.getValue()).booleanValue() == false) goto L9;
        oa0();
        ca0();
        ma0();
    L9:
        View r13 = r10.inflate(2131558546, r11, false);
        this.i = r13;
        return r13;
    }

    public final void pa0(int r11, int r12, int r13) {
        FrameLayout r1 = (FrameLayout) aa0(2131383767);
        DisplayMetrics r10 = null;
        if (r1 == null) goto L5;
        ViewGroup.LayoutParams r14 = r1.getLayoutParams();
    L6:
        Intrinsics.checkNotNull(r14, "null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
        int r15 = r13 & 80;
        if (r15 == 80) goto L9;
    L11:
        boolean r16 = false;
    L12:
        if (r16 == true) goto L14;
    L17:
        boolean r17 = true;
    L18:
        if (r17 == false) goto L20;
    L25:
        if (r11 <= 0) goto L27;
        r11 = da0(r11);
    L27:
        r14.width = r11;
    L28:
        if (r12 <= 0) goto L30;
        r12 = com.bytedance.android.annie.util.p.a.a(r12);
    L30:
        r14.height = r12;
        PopupHybridParamVoNew r18 = this.e;
        if (r18 == null) goto L81;
        if (getContext() == null) goto L65;
        com.bytedance.android.annie.util.p r19 = com.bytedance.android.annie.util.p.a;
        if (r19.getResources().getConfiguration().orientation == 2) goto L65;
        if (isFullScreen() == false) goto L48;
        p r110 = this.n;
        if (r110 == null) goto L45;
        DisplayMetrics r111 = r110.c;
        if (r111 == null) goto L43;
        r10 = r111;
    L44:
        if (r10 == null) goto L45;
    L46:
        r14.height = r10.heightPixels - fa0();
        goto L65
    L43:
        Intrinsics.throwUninitializedPropertyAccessException("realDisplayMetrics");
    L45:
        r10 = com.bytedance.android.annie.util.p.c(getActivity());
        goto L46
    L48:
        if (r18.A3() == true) goto L62;
        if (r18.U2() <= 0) goto L65;
        if (r18.z3() == 1) goto L65;
        float r20 = RangesKt.coerceAtMost(r18.U2() / 100.0f, 1.0f);
        p r21 = this.n;
        if (r21 == null) goto L56;
        int r112 = r21.a.heightPixels;
    L60:
        r14.height = (int) (r112 * r20);
        goto L65
    L56:
        FragmentActivity r22 = getActivity();
        if (r22 == null) goto L59;
        r112 = UIUtils.getScreenHeight(r22);
        goto L60
    L59:
        r112 = r19.d();
        goto L60
    L62:
        if (r18.U2() <= 0) goto L65;
        r14.height = (int) (com.bytedance.android.annie.util.p.c(getContext()).heightPixels * RangesKt.coerceAtMost(r18.U2() / 100.0f, 1.0f));
    L65:
        if ((r14 instanceof ConstraintLayout.LayoutParams) == false) goto L81;
        if (r18.getMarginBottom() <= 0) goto L70;
        ((ViewGroup.MarginLayoutParams) ((ConstraintLayout.LayoutParams) r14)).bottomMargin = com.bytedance.android.annie.util.p.a.a(r18.getMarginBottom() * 1.0f);
    L70:
        if (r18.getMarginRight() <= 0) goto L73;
        ((ViewGroup.MarginLayoutParams) ((ConstraintLayout.LayoutParams) r14)).rightMargin = com.bytedance.android.annie.util.p.a.a(r18.getMarginRight() * 1.0f);
    L73:
        if (com.bytedance.android.annie.ng.g.b().b.d == false) goto L81;
        if (r18.getMarginBottom() != 0) goto L78;
        ((ViewGroup.MarginLayoutParams) ((ConstraintLayout.LayoutParams) r14)).bottomMargin = 0;
    L78:
        if (r18.getMarginRight() != 0) goto L81;
        ConstraintLayout.LayoutParams r113 = (ConstraintLayout.LayoutParams) r14;
        ((ViewGroup.MarginLayoutParams) r113).rightMargin = 0;
        r113.setMarginEnd(0);
    L81:
        if (r13 != 0) goto L83;
    L87:
        ConstraintSet r114 = new ConstraintSet();
        r114.clone(aa0(2131374644));
        r114.connect(2131383767, 3, 0, 3);
        r114.applyTo(aa0(2131374644));
    L88:
        FrameLayout r115 = (FrameLayout) aa0(2131383767);
        if (r115 == null) goto L92;
        r115.setLayoutParams(r14);
    L92:
        FrameLayout r116 = (FrameLayout) aa0(2131383767);
        if (r116 == null) goto L96;
        r116.requestLayout();
        return;
    L96:
        return;
    L83:
        if ((r13 & 17) == 17) goto L87;
        if (r15 != 80) goto L88;
        ConstraintSet r117 = new ConstraintSet();
        r117.clone(aa0(2131374644));
        r117.clear(2131383767, 3);
        r117.applyTo(aa0(2131374644));
        goto L88
    L20:
        if (com.bytedance.android.annie.ng.g.b().b.c == false) goto L24;
        com.bytedance.android.annie.ng.g.b().getClass();
        if (com.bytedance.android.annie.ng.e.a.j == false) goto L25;
    L24:
        if (AnnieConfigSettingKeys.ENABLE_FIX_SCREEN_WIDTH.a().booleanValue() == false) goto L28;
    L14:
        if (AnnieConfigSettingKeys.ANNIE_DELETE_DIALOG_VERTIAL_BOTTOM_USE.a().booleanValue() == true) goto L17;
        r17 = false;
        goto L18
    L9:
        if (ha0() == true) goto L11;
        r16 = true;
        goto L12
    L5:
        r14 = null;
        goto L6
    }

    public final void qa0(Dialog r11, int r12, int r13, int r14) {
        if (r11 == null) goto L49;
        Window r15 = r11.getWindow();
        if (r15 == null) goto L49;
        if (com.bytedance.android.annie.ng.g.b().b.c == false) goto L11;
        com.bytedance.android.annie.ng.g.b().getClass();
        if (com.bytedance.android.annie.ng.e.a.j == false) goto L49;
    L11:
        if (com.bytedance.android.annie.ng.g.b().b.d == true) goto L49;
        if (this.e == null) goto L49;
        WindowManager.LayoutParams r0 = r15.getAttributes();
        r0.gravity = r14;
        boolean r10 = false;
        if ((r14 & 80) == 80) goto L17;
    L19:
        boolean r1 = false;
    L20:
        if (r1 == true) goto L22;
    L23:
        r10 = true;
    L24:
        if (r12 <= 0) goto L27;
        if (r10 == false) goto L27;
        r0.width = com.bytedance.android.annie.util.p.a.a(r12);
    L27:
        PopupHybridParamVoNew r16 = this.e;
        if (r16 != null) goto L30;
    L51:
        Result.Companion r17 = Result.Companion;     // Catch: Throwable -> L44
        r15.setAttributes(r0);     // Catch: Throwable -> L44
        Object r18 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L44
    L46:
        Throwable r19 = Result.exceptionOrNull-impl(r18);
        if (r19 == null) goto L49;
        b8.a r110 = b8.a.a;
        b8.a.a(new b8.b("BaseDialogFragment", LogLevel.ERROR, r19, null, 8), true);
    L44:
        th = move-exception;
        Result.Companion r20 = Result.Companion;
        r18 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L46
    L30:
        if (r16.D3() <= 0) goto L33;
        r0.x = r16.D3();
    L33:
        if (r16.E3() <= 0) goto L36;
        r0.y = r16.E3();
    L36:
        if (r16.B3() <= 0) goto L51;
        if (getContext() == null) goto L51;
        if (com.bytedance.android.annie.util.p.a.getResources().getConfiguration().orientation == 2) goto L51;
        r0.width = (int) (ga0() * (r16.B3() / 100.0f));
        goto L51
    L22:
        if (AnnieConfigSettingKeys.ANNIE_DELETE_DIALOG_VERTIAL_BOTTOM_USE.a().booleanValue() == false) goto L24;
    L17:
        if (ha0() == true) goto L19;
        r1 = true;
    L49:
        pa0(r12, r13, r14);
        com.bytedance.android.annie.scheme.helper.a.d(this.e, "preset_width_px", Integer.valueOf(com.bytedance.android.annie.util.p.a.a(r12)));
    }

    public final void la0(String r10, int r11, int r12, int r13, int r14, BaseHybridParamVoNew.HybridType r15) {
        Intrinsics.checkNotNullParameter(r15, "type");
        ia0("update dialog prop, url:" + r10 + ", width: " + r11 + ", height: " + r12 + ", radius: " + r13);
        if (getDialog() == null) goto L72;
        Dialog r0 = getDialog();
        String r1 = null;
        if (r0 == null) goto L7;
        Window r16 = r0.getWindow();
    L8:
        if (r16 == null) goto L76;
        Dialog r17 = getDialog();
        if (r17 != null) goto L13;
    L17:
        Dialog r18 = getDialog();
        if (r18 == null) goto L20;
        Window r19 = r18.getWindow();
    L21:
        if (r19 == null) goto L27;
        r19.clearFlags(32);
        if (na0() == false) goto L25;
        r19.clearFlags(6);
        r19.setDimAmount(0.0f);
        goto L27
    L25:
        r19.getAttributes().dimAmount = 0.6f;
    L27:
        if (getActivity() != null) goto L29;
        return;
    L29:
        PopupHybridParamVoNew r20 = this.e;
        if (r20 == null) goto L73;
        boolean r21 = false;
        if (r15 == BaseHybridParamVoNew.HybridType.LYNX) goto L53;
        if (r10 != null) goto L35;
    L38:
        boolean r110 = true;
    L39:
        if (r110 == true) goto L74;
        HybridFragment r111 = this.f;
        if (r111 == null) goto L43;
        View r112 = r111.getHybridView();
    L45:
        if ((r112 instanceof WebView) == false) goto L47;
        WebView r113 = (WebView) r112;
    L48:
        if (r113 == null) goto L51;
        r1 = r113.getUrl();
    L51:
        if (Intrinsics.areEqual(r10, r1) == true) goto L53;
        return;
    L47:
        r113 = null;
        goto L48
    L43:
        r112 = null;
        goto L45
    L74:
        return;
    L35:
        if (StringsKt.isBlank(r10) == true) goto L38;
        r110 = false;
    L53:
        if (r20.y3() == false) goto L55;
        r12 = r12 + 48;
    L55:
        HybridFragment r22 = this.f;
        if (r22 == null) goto L59;
        r22.setRadius(da0(r13));
    L59:
        if (m.a(getActivity()) == true) goto L61;
        pa0(r11, r12, r20.T2());
    L61:
        if (r14 != 1) goto L63;
    L66:
        r21 = true;
    L67:
        U90(r21);
        return;
    L63:
        if (com.bytedance.android.annie.ng.g.b().b.c == false) goto L67;
        com.bytedance.android.annie.ng.g.b().getClass();
        if (com.bytedance.android.annie.ng.e.a.j == true) goto L67;
    L73:
        return;
    L20:
        r19 = null;
        goto L21
    L13:
        if (DialogLancet.shouldBlockDialogShow(r17) == false) goto L70;
        DialogLancet.handleBlockedDialogShow(r17);
        goto L17
    L70:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L69
    L16:
        DialogLancet.beforeDialogShow(r17);
        r17.show();
        DialogLancet.afterDialogShow(r17);
        goto L17
    L76:
        return;
    L7:
        r16 = null;
        goto L8
    }
}
