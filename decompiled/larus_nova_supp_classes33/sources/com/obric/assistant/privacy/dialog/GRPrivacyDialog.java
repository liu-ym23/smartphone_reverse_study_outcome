package com.obric.assistant.privacy.dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.WindowInsetsControllerCompat;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.DialogFragment;
import androidx.viewbinding.ViewBindings;
import com.larus.common.mssdk.api.ISecPrivacyService;
import com.larus.common.mssdk.api.SecurityService;
import com.larus.common_ui.dialog.p0;
import com.larus.common_ui.widget.UrlSpanTextView;
import com.larus.home.api.main.HomeService;
import com.larus.init.IImageInitiator;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.guide.IObricUserGuide;
import com.obric.assistant.interaction.base.util.DeviceUtil;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.privacy.impl.databinding.ObricActivityPrivacyAgreementExternalBinding;
import com.obric.oui.button.OButton;
import com.obric.oui.checkbox.OCheckBoxLayout;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.update.api.v2.ObricUpdateSettingDelegate;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 =2\u00020\u0001:\u0003=>?B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\u0010\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u000fH\u0016J$\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\u001a\u0010\u001c\u001a\u00020\u000f2\u0006\u0010\u001d\u001a\u00020\u00172\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\b\u0010\u001e\u001a\u00020\u000fH\u0002J\b\u0010\u001f\u001a\u00020\u000fH\u0016J\b\u0010 \u001a\u00020\u000fH\u0016J\b\u0010!\u001a\u00020\u000fH\u0016J\b\u0010\"\u001a\u00020\u000fH\u0002J\b\u0010#\u001a\u00020\u000fH\u0002J \u0010$\u001a\u00020\u000f2\u0006\u0010\u001d\u001a\u00020\u00172\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u0007H\u0002J\b\u0010(\u001a\u00020\u000fH\u0002J\b\u0010)\u001a\u00020\u000fH\u0002J\b\u0010*\u001a\u00020\u000fH\u0002J\b\u0010+\u001a\u00020\u000fH\u0002J\u000e\u0010,\u001a\b\u0012\u0004\u0012\u00020.0-H\u0002J \u0010/\u001a\u00020\u00172\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u00100\u001a\u00020.2\u0006\u00101\u001a\u000202H\u0002J\u0018\u00103\u001a\u00020\u00172\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u00101\u001a\u000202H\u0002J \u00104\u001a\u0002052\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u00100\u001a\u00020.2\u0006\u00101\u001a\u000202H\u0002J\b\u00106\u001a\u00020\u000fH\u0016J\b\u00107\u001a\u00020\u000fH\u0016J\b\u00108\u001a\u00020\u000fH\u0016J\b\u00109\u001a\u00020\u000fH\u0002J\b\u0010:\u001a\u00020\u000fH\u0002J\u0010\u0010;\u001a\u00020\u000f2\u0006\u0010<\u001a\u00020.H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006@"}, d2 = {"Lcom/obric/assistant/privacy/dialog/GRPrivacyDialog;", "Landroidx/fragment/app/DialogFragment;", "<init>", "()V", "binding", "Lcom/obric/assistant/privacy/impl/databinding/ObricActivityPrivacyAgreementExternalBinding;", "originalOrientation", "", "mConfirmClickListener", "Lcom/larus/common_ui/dialog/ConfirmClickListener;", "mCancelClickListener", "Lcom/larus/common_ui/dialog/CancelClickListener;", "workScope", "Lkotlinx/coroutines/CoroutineScope;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onAttach", "context", "Landroid/content/Context;", "onStart", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "adaptNavigationBarPadding", "onStop", "onDestroyView", "onDestroy", "setupView", "setupExternalScrollFadeMask", "setupFadeMaskView", "orientation", "Landroid/graphics/drawable/GradientDrawable$Orientation;", "fadeColor", "setupPrivacyPolicyView", "setupActionButtons", "setupWifiToggle", "setupExternalPermissionList", "getPermissionLines", "", "", "createPermissionItemView", "line", "style", "Lcom/obric/assistant/privacy/dialog/GRPrivacyDialog$PermissionListStyle;", "createPermissionBulletView", "createPermissionTextView", "Landroid/widget/TextView;", "onResume", "dismiss", "dismissAllowingStateLoss", "adaptScreenOrientationOnStart", "restoreScreenOrientationOnStop", "clickPrivacyLink", "linkUrl", "Companion", "PermissionListStyle", "Builder", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class GRPrivacyDialog extends DialogFragment {
    public static final /* synthetic */ int i = 0;
    public ObricActivityPrivacyAgreementExternalBinding d;
    public int e;
    public p0 f;
    public com.larus.common_ui.dialog.u g;
    public final CoroutineScope h;

    public static final class a {
    }

    public static final class b implements DialogInterface.OnKeyListener {
        public b() {
        }

        @Override // android.content.DialogInterface.OnKeyListener
        public final boolean onKey(DialogInterface r1, int r2, KeyEvent r3) {
            if (r2 != 4) goto L6;
            return true;
        L6:
            return false;
        }
    }

    static {
    }

    public final void dismiss() {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L11
        super.dismissAllowingStateLoss();     // Catch: Exception -> L5 Throwable -> L11
    L9:
        Object r1 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L11
    L13:
        Throwable r2 = Result.exceptionOrNull-impl(r1);
        if (r2 == null) goto L21;
        FLogger.a.w("ObricPrivacyDialog", "dismissAllowingStateLoss failed. " + r2.getMessage() + ", it: " + r2);
        return;
    L21:
        return;
    L5:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");     // Catch: Throwable -> L11
        Throwable r3 = DialogFragmentLancet.sLastShowStack;     // Catch: Throwable -> L11
        if (r3 == null) goto L9;
        com.bytedance.crash.d.d(r3, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        Result.Companion r4 = Result.Companion;
        r1 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L13
    }

    public final void dismissAllowingStateLoss() {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L11
        super.dismissAllowingStateLoss();     // Catch: Exception -> L5 Throwable -> L11
    L9:
        Object r1 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L11
    L13:
        Throwable r2 = Result.exceptionOrNull-impl(r1);
        if (r2 == null) goto L21;
        FLogger.a.w("ObricPrivacyDialog", "dismissAllowingStateLoss failed. " + r2.getMessage() + ", it: " + r2);
        return;
    L21:
        return;
    L5:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");     // Catch: Throwable -> L11
        Throwable r3 = DialogFragmentLancet.sLastShowStack;     // Catch: Throwable -> L11
        if (r3 == null) goto L9;
        com.bytedance.crash.d.d(r3, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        Result.Companion r4 = Result.Companion;
        r1 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L13
    }

    public final void onDestroy() {
        CoroutineScopeKt.cancel$default(this.h, null, 1, null);
        super/*androidx.fragment.app.Fragment*/.onDestroy();
        FLogger.a.i("ObricPrivacyDialog", "onDestroy");
    }

    public GRPrivacyDialog() {
        this.e = -1;
        this.h = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getIO()));
    }

    public final void onDestroyView() {
        super.onDestroyView();
        FLogger.a.i("ObricPrivacyDialog", "onDestroyView");
        this.d = null;
    }

    public final void onResume() {
        super/*androidx.fragment.app.Fragment*/.onResume();
        ISecPrivacyService.a.getClass();
        ISecPrivacyService r0 = ISecPrivacyService.a.a();
        if (r0 == null) goto L7;
        boolean r1 = true;
        if (r0.h() != true) goto L7;
    L8:
        if (r1 == false) goto L14;
        ObricActivityPrivacyAgreementExternalBinding r2 = this.d;
        if (r2 == null) goto L14;
        OButton r3 = r2.b;
        if (r3 == null) goto L14;
        r3.performClick();
    L14:
        final ObricActivityPrivacyAgreementExternalBinding r4 = this.d;
        if (r4 != null) goto L18;
        return;
    L18:
        if (getActivity() == null) goto L21;
        r4.a.post(new d(r4));
        return;
    L21:
        return;
    L7:
        r1 = false;
        goto L8
    }

    public final void onStart() {
        PopupOrDialogVisibilityTracker.bindDialogFragment(this);
        LandscapeRestrictionGuard.bindDialogForAllowedDialogFragment(this);
        super.onStart();
        FLogger r0 = FLogger.a;
        r0.i("ObricPrivacyDialog", "onStart");
        this.e = requireActivity().getRequestedOrientation();
        boolean r4 = true;
        if (DeviceUtil.INSTANCE.isHorizontalFoldable() == true) goto L5;
    L7:
        boolean r1 = false;
    L9:
        if (HomeService.a.isPad() == true) goto L13;
        if (r1 == true) goto L13;
        int r5 = 1;
    L14:
        r0.i("ObricPrivacyDialog", "adaptScreenOrientationOnStart orientation: " + r5 + ", isUnfolded: " + r1);
        requireActivity().setRequestedOrientation(r5);
        Dialog r2 = getDialog();
        if (r2 == null) goto L39;
        Window r3 = r2.getWindow();
        if (r3 == null) goto L39;
        WindowCompat.setDecorFitsSystemWindows(r3, false);
        r3.setStatusBarColor(0);
        r3.setNavigationBarColor(0);
        View r6 = r3.getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L23;
        r0.i("DecorViewLancet", "getDecorView");
        Thread r7 = ThreadMethodProxy.currentThread();
        if (r7 == com.larus.home.impl.utils.c.a) goto L23;
        com.larus.home.impl.utils.c.a(r7, "getDecorView");
    L23:
        WindowInsetsControllerCompat r8 = WindowCompat.getInsetsController(r3, r6);
        if (r8 == null) goto L27;
        r8.show(WindowInsetsCompat.Type.systemBars());
        r8.setAppearanceLightStatusBars(true);
        r8.setAppearanceLightNavigationBars(true);
    L27:
        if (Build.VERSION.SDK_INT < 28) goto L29;
        WindowManager.LayoutParams r9 = r3.getAttributes();
        r9.layoutInDisplayCutoutMode = 1;
        r3.setAttributes(r9);
    L29:
        IObricUserGuide r10 = (IObricUserGuide) ServiceManager.get().getService(IObricUserGuide.class);
        if (r10 != null) goto L32;
    L34:
        r4 = false;
    L35:
        if (r4 == false) goto L39;
        r3.setWindowAnimations(0);
        r3.clearFlags(2);
        WindowManager.LayoutParams r11 = r3.getAttributes();
        if (r11 == null) goto L39;
        r11.dimAmount = 0.0f;
        r3.setAttributes(r11);
        goto L39
    L32:
        if (r10.d(requireContext()) != true) goto L34;
    L39:
        Dialog r12 = getDialog();
        if (r12 == null) goto L43;
        r12.setOnKeyListener(new b());
        return;
    L43:
        return;
    L13:
        r5 = 13;
        goto L14
    L5:
        if (getResources().getConfiguration().smallestScreenWidthDp < 600) goto L7;
        r1 = true;
        goto L9
    }

    public final void onStop() {
        super.onStop();
        FLogger r0 = FLogger.a;
        r0.i("ObricPrivacyDialog", "onStop");
        r0.i("ObricPrivacyDialog", "restoreScreenOrientationOnStop originalOrientation: " + this.e);
        requireActivity().setRequestedOrientation(this.e);
    }

    public final void onAttach(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super.onAttach(r3);
        FLogger.a.i("ObricPrivacyDialog", "onAttach");
    }

    public final void onCreate(Bundle r3) {
        super.onCreate(r3);
        FLogger.a.i("ObricPrivacyDialog", "onCreate");
        setStyle(0, 2131953330);
        IImageInitiator r4 = (IImageInitiator) ServiceManager.get().getService(IImageInitiator.class);
        if (r4 == null) goto L6;
        r4.a();
        return;
    }

    public static final void S90(final GRPrivacyDialog r3, final String r4) {
        r3.getClass();
        SecurityService r0 = (SecurityService) ServiceManager.get().getService(SecurityService.class);
        if (r0 == null) goto L6;
        r0.x(r3.requireActivity().getSupportFragmentManager(), new g(r4, r3));
        return;
    }

    public final void onViewCreated(View r13, Bundle r14) {
        Intrinsics.checkNotNullParameter(r13, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r13, r14);
        FLogger.a.i("ObricPrivacyDialog", "onViewCreated");
        ObricActivityPrivacyAgreementExternalBinding r15 = this.d;
        if (r15 == null) goto L6;
        r15.i.setUrlSpannedText(getString(2131912377));
        r15.i.setOnClickListener(new n(this));
    L6:
        ObricActivityPrivacyAgreementExternalBinding r16 = this.d;
        if (r16 == null) goto L10;
        r16.b.setOnClickListener(new i(this));
        r16.c.setOnClickListener(new j(this));
    L10:
        ObricActivityPrivacyAgreementExternalBinding r17 = this.d;
        if (r17 == null) goto L19;
        OCardListItem.h(r17.j, 0);
        int r0 = rda.a.a;
        rda.a.a(r17.j, 0);
        OCheckBoxLayout r1 = r17.j.getEndCheckBox();
        if (r1 == null) goto L16;
        r1.setChecked(ObricUpdateSettingDelegate.a.a());
    L16:
        OCheckBoxLayout r18 = r17.j.getEndCheckBox();
        if (r18 == null) goto L19;
        r18.setOnCheckedChangeListener(new h());
    L19:
        ObricActivityPrivacyAgreementExternalBinding r19 = this.d;
        if (r19 == null) goto L29;
        LinearLayout r110 = r19.e;
        r110.setBaselineAligned(false);
        r110.removeAllViews();
        List r2 = SequencesKt.toList(SequencesKt.filter(SequencesKt.map(StringsKt.lineSequence(getString(2131912352)), new e()), new f()));
        if (r2.isEmpty() == true) goto L29;
        Context r3 = r110.getContext();
        int r4 = ContextCompat.getColor(r3, 2131103865);
        Resources r5 = r110.getResources();
        float r6 = WindowDisplayMetricsOverride.apply(r5, r5.getDisplayMetrics()).density;
        Typeface r7 = Typeface.create("sans-serif", 0);
        int r8 = (int) (4 * r6);
        int r9 = (int) (8 * r6);
        Intrinsics.checkNotNullParameter(r7, "typeface");
        Iterator r10 = r2.iterator();
    L27:
        if (r10.hasNext() == false) goto L29;
        String r11 = (String) r10.next();
        Intrinsics.checkNotNull(r3);
        LinearLayout r12 = new LinearLayout(r3);
        r12.setOrientation(0);
        r12.setGravity(48);
        r12.setBaselineAligned(false);
        r12.setPadding(0, r8, 0, r8);
        r12.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        View r20 = new View(r3);
        GradientDrawable r21 = new GradientDrawable();
        r21.setShape(1);
        r21.setColor(r4);
        r20.setBackground(r21);
        LinearLayout.LayoutParams r22 = new LinearLayout.LayoutParams(r8, r8);
        r22.topMargin = r9;
        r22.setMarginEnd(r9);
        r20.setLayoutParams(r22);
        r12.addView(r20);
        TextView r23 = new TextView(r3);
        r23.setText(r11);
        r23.setTypeface(r7);
        r23.setTextColor(r4);
        r23.setTextSize(12.0f);
        r23.setIncludeFontPadding(true);
        r23.setLayoutParams(new LinearLayout.LayoutParams(0, -2, 1.0f));
        r12.addView(r23);
        r110.addView(r12);
    L29:
        final ObricActivityPrivacyAgreementExternalBinding r111 = this.d;
        if (r111 == null) goto L33;
        int r24 = ContextCompat.getColor(requireContext(), v19.c.b(2130970531, requireContext(), 2131102535));
        V90(r111.h, GradientDrawable.Orientation.TOP_BOTTOM, r24);
        V90(r111.f, GradientDrawable.Orientation.BOTTOM_TOP, r24);
        final Ref.BooleanRef r25 = new Ref.BooleanRef();
        final Ref.BooleanRef r26 = new Ref.BooleanRef();
        r111.d.setOnScrollChangeListener(new k(r111, r25, r26));
        r111.d.addOnLayoutChangeListener(new l(r111, r25, r26));
    L33:
        Context r112 = getContext();
        if (r112 == null) goto L36;
        HomeService.a.Q(r112);
    L36:
        HomeService.a.x(new JSONObject());
        Dialog r113 = getDialog();
        if (r113 == null) goto L41;
        r113.setCanceledOnTouchOutside(false);
        return;
    }

    public static void V90(View r4, GradientDrawable.Orientation r5, int r6) {
        r4.setBackground(new GradientDrawable(r5, new int[]{r6, 0}));
        r4.setEnabled(false);
        r4.setClickable(false);
        r4.setFocusable(false);
        r4.setImportantForAccessibility(2);
    }

    public final View onCreateView(LayoutInflater r12, ViewGroup r13, Bundle r14) {
        Intrinsics.checkNotNullParameter(r12, "inflater");
        FLogger.a.i("ObricPrivacyDialog", "onCreateView");
        ConstraintLayout r15 = r12.inflate(2131563922, r13, false);
        int r16 = 2131364991;
        OButton r2 = (OButton) ViewBindings.findChildViewById(r15, 2131364991);
        if (r2 == null) goto L33;
        r16 = 2131365011;
        OButton r3 = (OButton) ViewBindings.findChildViewById(r15, 2131365011);
        if (r3 == null) goto L33;
        r16 = 2131383030;
        NestedScrollView r4 = ViewBindings.findChildViewById(r15, 2131383030);
        if (r4 == null) goto L33;
        r16 = 2131383034;
        if (((ImageView) ViewBindings.findChildViewById(r15, 2131383034)) == null) goto L33;
        r16 = 2131383035;
        if (((LinearLayout) ViewBindings.findChildViewById(r15, 2131383035)) == null) goto L33;
        r16 = 2131383037;
        if (ViewBindings.findChildViewById(r15, 2131383037) == null) goto L33;
        r16 = 2131383038;
        LinearLayout r5 = (LinearLayout) ViewBindings.findChildViewById(r15, 2131383038);
        if (r5 == null) goto L33;
        r16 = 2131383039;
        if (((TextView) ViewBindings.findChildViewById(r15, 2131383039)) == null) goto L33;
        r16 = 2131383043;
        View r6 = ViewBindings.findChildViewById(r15, 2131383043);
        if (r6 == null) goto L33;
        r16 = 2131383044;
        FrameLayout r7 = (FrameLayout) ViewBindings.findChildViewById(r15, 2131383044);
        if (r7 == null) goto L33;
        r16 = 2131383045;
        View r8 = ViewBindings.findChildViewById(r15, 2131383045);
        if (r8 == null) goto L33;
        r16 = 2131383047;
        if (((TextView) ViewBindings.findChildViewById(r15, 2131383047)) == null) goto L33;
        r16 = 2131391163;
        UrlSpanTextView r9 = ViewBindings.findChildViewById(r15, 2131391163);
        if (r9 == null) goto L33;
        r16 = 2131393206;
        OCardListItem r10 = ViewBindings.findChildViewById(r15, 2131393206);
        if (r10 == null) goto L33;
        ConstraintLayout r17 = r15;
        this.d = new ObricActivityPrivacyAgreementExternalBinding(r17, r2, r3, r4, r5, r6, r7, r8, r9, r10);
        return r17;
    L33:
        throw new NullPointerException("Missing required view with ID: ".concat(r15.getResources().getResourceName(r16)));
    }

    public static final void T90(ObricActivityPrivacyAgreementExternalBinding r11, Ref.BooleanRef r12, Ref.BooleanRef r13, boolean r14) {
        U90(r12, r13, r11.h, r11.d.canScrollVertically(-1), true, r14);
        U90(r12, r13, r11.f, r11.d.canScrollVertically(1), false, r14);
    }

    public static final void U90(Ref.BooleanRef r1, Ref.BooleanRef r2, View r3, boolean r4, boolean r5, boolean r6) {
        if (r5 == false) goto L4;
        boolean r0 = r1.element;
    L5:
        if (r0 != r4) goto L7;
        return;
    L7:
        if (r5 == false) goto L9;
        r1.element = r4;
    L10:
        r3.animate().cancel();
        float r7 = 1.0f;
        if (r6 == false) goto L17;
        ViewPropertyAnimator r8 = r3.animate();
        if (r4 == true) goto L16;
        r7 = 0.0f;
    L16:
        r8.alpha(r7).setDuration(120).withLayer().start();
        return;
    L17:
        if (r4 == true) goto L20;
        r7 = 0.0f;
    L20:
        r3.setAlpha(r7);
        return;
    L9:
        r2.element = r4;
        goto L10
    L4:
        r0 = r2.element;
        goto L5
    }
}
