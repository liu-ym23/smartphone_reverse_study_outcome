package com.obric.memorydata.recommend.ui.rule;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.WindowInsetsControllerCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.aikernel.sdk.ext.Params;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.plugin.R;
import com.obric.memorydata.utils.at;
import com.obric.oui.button.OButton;
import com.obric.oui.checkbox.OCheckBox;
import com.obric.oui.dialog.v2.alert.style.ButtonStyleController;
import com.obric.oui.forms.OEditText;
import com.obric.oui.forms.OInputLayout;
import com.obric.oui.progress.ODownloadProgressView;
import com.ttnet.org.chromium.base.BaseSwitches;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.al;
import kotlinx.coroutines.am;
import kotlinx.coroutines.ba;
import kotlinx.coroutines.bx;
import kotlinx.coroutines.flow.k;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0096\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 P2\u00020\u0001:\u0001PBY\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t\u0012\u0016\b\u0002\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\n\u0018\u00010\f\u0012\b\b\u0002\u0010\r\u001a\u00020\u0005¢\u0006\u0004\b\u000e\u0010\u000fJ\b\u0010-\u001a\u00020\nH\u0002J\b\u0010.\u001a\u00020\nH\u0002J\u0010\u0010/\u001a\u00020\n2\u0006\u00100\u001a\u000201H\u0002J\u0010\u00102\u001a\u00020\n2\u0006\u00100\u001a\u000201H\u0002J\u0006\u00103\u001a\u00020\nJ\b\u00104\u001a\u00020\nH\u0002J\u0012\u00104\u001a\u00020\n2\b\u00105\u001a\u0004\u0018\u000106H\u0002J\u0006\u00107\u001a\u00020\nJ\b\u00108\u001a\u00020\nH\u0002J\u0010\u00109\u001a\u00020\n2\u0006\u0010:\u001a\u00020\u0005H\u0002J\b\u0010;\u001a\u00020\nH\u0002J\b\u0010<\u001a\u00020\nH\u0002J\b\u0010=\u001a\u00020\nH\u0002J\b\u0010>\u001a\u00020&H\u0002J\b\u0010?\u001a\u00020\nH\u0002J\u0010\u0010@\u001a\u00020\u00052\u0006\u0010A\u001a\u00020BH\u0002J\u0010\u0010C\u001a\u00020\n2\u0006\u0010D\u001a\u00020EH\u0002J\b\u0010F\u001a\u00020\nH\u0002J\u0010\u0010G\u001a\u00020\n2\u0006\u00100\u001a\u000201H\u0002J\u0010\u0010H\u001a\u00020\n2\u0006\u00100\u001a\u000201H\u0002J\u0010\u0010I\u001a\u00020\n2\u0006\u00100\u001a\u000201H\u0002J\u0010\u0010J\u001a\u00020\n2\u0006\u00100\u001a\u000201H\u0002J\u0010\u0010K\u001a\u00020\n2\u0006\u0010L\u001a\u00020\u0005H\u0002J\u0018\u0010M\u001a\u00020\n2\u0006\u0010N\u001a\u00020\u00052\u0006\u0010O\u001a\u00020\u0007H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\n\u0018\u00010\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0014\u001a\u00020\u00158BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0016\u0010\u0017R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u001fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020$X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u0004\u0018\u00010&X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010'\u001a\u0004\u0018\u00010(X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010)\u001a\u0004\u0018\u00010*X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010+\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006Q"}, d2 = {"Lcom/obric/memorydata/recommend/ui/rule/BlockMemoryDialog;", "", "activity", "Landroidx/fragment/app/FragmentActivity;", "needExtraRule", "", Params.CONTENT, "", "onDeleteCallback", "Lkotlin/Function0;", "", "onValidateContentCallback", "Lkotlin/Function1;", "isFromEdit", "<init>", "(Landroidx/fragment/app/FragmentActivity;ZLjava/lang/String;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Z)V", "dialogScope", "Lkotlinx/coroutines/CoroutineScope;", "delayedLoadingStateMachine", "Lcom/obric/memorydata/recommend/ui/rule/DelayedLoadingStateMachine;", "viewModel", "Lcom/obric/memorydata/recommend/ui/rule/BlockMemoryDialogViewModel;", "getViewModel", "()Lcom/obric/memorydata/recommend/ui/rule/BlockMemoryDialogViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "dialog", "Lcom/obric/oui/dialog/v2/alert/OAlertDialog;", "inputView", "Lcom/obric/oui/forms/OInputLayout;", "cancelButton", "Lcom/obric/oui/button/OButton;", "confirmButton", "deleteCheckBox", "Lcom/obric/oui/checkbox/OCheckBox;", "llDeleteMemory", "Landroid/widget/LinearLayout;", "creatingRuleLoadingDialog", "Landroid/app/Dialog;", "creatingRuleLoadingJob", "Lkotlinx/coroutines/Job;", "pendingKeyboardRetry", "Ljava/lang/Runnable;", "lastInputText", "hasErrorTip", "bindViews", "observerState", "handleExclusionRulesResult", "state", "Lcom/obric/memorydata/recommend/ui/rule/BlockMemoryDialogViewModel$BlockMemoryState;", "handleValidateContentResult", "show", "syncStatusBarAppearance", "window", "Landroid/view/Window;", "dismiss", "startCreatingRuleLoadingTimer", "finishCreatingRuleLoading", "shouldRestoreEditor", "showEditorKeyboard", "cancelPendingKeyboardRetry", "showCreatingRuleLoading", "createCreatingRuleLoadingDialog", "clearCreatingRuleLoading", "isLandscape", "context", "Landroid/content/Context;", "setOnApplyWindowInsetsListener", "rootView", "Landroid/view/View;", "initView", "updateUI", "updateInputFieldState", "updateConfirmButtonState", "updateInputHint", "setTextStateCompat", "isError", "showErrorTip", "error", NotificationCompat.CATEGORY_MESSAGE, "Companion", "recommend_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f12742a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final FragmentActivity f12743b;
    private final boolean c;
    private final String d;
    private final Function0<Unit> e;
    private final Function1<String, Unit> f;
    private final boolean g;
    private final al h;
    private final DelayedLoadingStateMachine i;
    private final Lazy j;
    private com.obric.oui.dialog.v2.alert.a k;
    private OInputLayout l;
    private OButton m;
    private OButton n;
    private OCheckBox o;
    private LinearLayout p;
    private Dialog q;
    private bx r;
    private Runnable s;
    private String t;
    private boolean u;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/obric/memorydata/recommend/ui/rule/BlockMemoryDialog$Companion;", "", "<init>", "()V", "TAG", "", "MAX_INPUT_LENGTH", "", "CREATE_RULE_LOADING_DELAY_MS", "", "KEYBOARD_RETRY_DELAY_MS", "recommend_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J*\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0016J*\u0010\n\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0012\u0010\f\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\rH\u0016¨\u0006\u000e"}, d2 = {"com/obric/memorydata/recommend/ui/rule/BlockMemoryDialog$initView$4", "Landroid/text/TextWatcher;", "beforeTextChanged", "", "s", "", CommonConsts.APM_INNER_EVENT_COST_START, "", CommonConsts.COUNT_TYPE, "after", "onTextChanged", "before", "afterTextChanged", "Landroid/text/Editable;", "recommend_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class b implements TextWatcher {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ d f12744a;

        b(d r1) {
            this.f12744a = r1;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable r6) {
            Editable r7 = (Editable) ZeusTransformUtils.wrapperContextForParams(r6, Editable.class, "com.obric.memorydata.plugin");
            if (r7 == null) goto L8;
            String r8 = r7.toString();
            if (r8 == null) goto L8;
            String r9 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.memorydata.plugin")).toString();
            if (r9 == null) goto L8;
        L10:
            if (TextUtils.equals((CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(d.c(this.f12744a), CharSequence.class, "com.obric.memorydata.plugin")) == true) goto L20;
            OButton r2 = d.d(this.f12744a);
            if (r2 != null) goto L15;
            Intrinsics.throwUninitializedPropertyAccessException("confirmButton");
            r2 = null;
        L15:
            if (((CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L17;
            boolean r1 = true;
        L18:
            r2.setEnabled(r1);
            d.a(this.f12744a, r9);
            goto L20
        L17:
            r1 = false;
        L20:
            if (d.e(this.f12744a) == false) goto L23;
            d.a(this.f12744a, false, "");
            return;
        L23:
            return;
        L8:
            r9 = "";
            goto L10
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence r1, int r2, int r3, int r4) {
            CharSequence r0 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r1, CharSequence.class, "com.obric.memorydata.plugin");
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence r1, int r2, int r3, int r4) {
            CharSequence r0 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r1, CharSequence.class, "com.obric.memorydata.plugin");
        }
    }

    static {
        f12742a = new a(null);
    }

    public d(FragmentActivity r3, boolean r4, String r5, Function0<Unit> r6, Function1<? super String, Unit> r7, boolean r8) {
        FragmentActivity r9 = (FragmentActivity) ZeusTransformUtils.wrapperContextForParams(r3, FragmentActivity.class, "com.obric.memorydata.plugin");
        Function0<Unit> r10 = (Function0) ZeusTransformUtils.wrapperContextForParams(r6, Function0.class, "com.obric.memorydata.plugin");
        Function1<String, Unit> r11 = (Function1) ZeusTransformUtils.wrapperContextForParams(r7, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r9, "activity");
        this.f12743b = r9;
        this.c = r4;
        this.d = r5;
        this.e = r10;
        this.f = r11;
        this.g = r8;
        this.h = am.a((CoroutineContext) ZeusTransformUtils.preCheckCast(ba.b(), CoroutineContext.class, "com.obric.memorydata.plugin"));
        this.i = new DelayedLoadingStateMachine();
        this.j = LazyKt.lazy(new $$Lambda$d$2g_pNzrfYiEit1WfhgLXdER1X6s(this));
        com.obric.oui.dialog.v2.alert.style.f r12 = new com.obric.oui.dialog.v2.alert.style.f(new $$Lambda$d$29Oxusrw3JuOW8LF4dyE8rDRHE(this));
        com.obric.oui.dialog.v2.alert.b r13 = new com.obric.oui.dialog.v2.alert.b((Context) ZeusTransformUtils.preCheckCast(r9, Context.class, "com.obric.memorydata.plugin"));
        if (r8 == false) goto L5;
        int r14 = R.string.screen_memory_block_dialog_edit_title;
        String r15 = "screen_memory_block_dialog_edit_title";
    L6:
        com.obric.oui.dialog.v2.alert.b r16 = r13.a(ZeusTransformUtils.mapRes(r14, TypedValues.Custom.S_STRING, r15));
        if (r8 == true) goto L9;
        r16.b(ZeusTransformUtils.mapRes(R.string.screen_memory_block_dialog_sub_title, TypedValues.Custom.S_STRING, "screen_memory_block_dialog_sub_title"));
    L9:
        com.obric.oui.dialog.v2.alert.a r17 = (com.obric.oui.dialog.v2.alert.a) ZeusTransformUtils.preCheckCast(r16.a($$Lambda$d$ebaxDFrMXDwPGglgwKNIFKQWyGI.INSTANCE).a((com.obric.oui.dialog.v2.alert.style.g) ZeusTransformUtils.preCheckCast(r12, com.obric.oui.dialog.v2.alert.style.g.class, "com.obric.memorydata.plugin")).c(false).a(new $$Lambda$d$tQqH_hu6TAYJ1MM9m_WxHAKlVkY(this)).g(), com.obric.oui.dialog.v2.alert.a.class, "com.obric.memorydata.plugin");
        this.k = r17;
        if (r17 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("dialog");
        r17 = null;
    L12:
        r17.setCanceledOnTouchOutside(false);
        d();
        m();
        e();
        return;
    L5:
        r14 = R.string.screen_memory_block_dialog_title;
        r15 = "screen_memory_block_dialog_title";
        goto L6
    }

    public /* synthetic */ d(FragmentActivity r5, boolean r6, String r7, Function0 r8, Function1 r9, boolean r10, int r11, DefaultConstructorMarker r12) {
        FragmentActivity r13 = (FragmentActivity) ZeusTransformUtils.wrapperContextForParams(r5, FragmentActivity.class, "com.obric.memorydata.plugin");
        Function0 r14 = (Function0) ZeusTransformUtils.wrapperContextForParams(r8, Function0.class, "com.obric.memorydata.plugin");
        Function1 r15 = (Function1) ZeusTransformUtils.wrapperContextForParams(r9, Function1.class, "com.obric.memorydata.plugin");
        boolean r0 = false;
        if ((r11 & 2) == 0) goto L5;
        boolean r16 = false;
    L6:
        Function1 r1 = null;
        if ((r11 & 4) == 0) goto L9;
        String r2 = null;
    L11:
        if ((r11 & 8) == 0) goto L13;
        Function0 r3 = null;
    L15:
        if ((r11 & 16) != 0) goto L19;
        r1 = r15;
    L19:
        if ((r11 & 32) != 0) goto L22;
        r0 = r10;
    L22:
        this(r13, r16, r2, r3, r1, r0);
        return;
    L13:
        r3 = r14;
        goto L15
    L9:
        r2 = r7;
        goto L11
    L5:
        r16 = r6;
        goto L6
    }

    private static final WindowInsets a(d r8, final View r9, View r10, WindowInsets r11) {
        Intrinsics.checkNotNullParameter(r10, BaseSwitches.V);
        Intrinsics.checkNotNullParameter(r11, "insets");
        final Context r3 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r10.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        Context r12 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r10.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r12, "getContext(...)");
        final boolean r7 = com.obric.oui.window.a.f(r12);
        com.obric.oui.window.a r13 = com.obric.oui.window.a.f14878a;
        Intrinsics.checkNotNull(r3);
        if (r13.c(r3) == false) goto L5;
    L8:
        boolean r14 = true;
    L9:
        if (r14 == false) goto L11;
        final int r6 = 0;
    L12:
        final int r4 = com.obric.oui.window.a.f14878a.a(r9);
        RunLog.INSTANCE.debug("BlockMemoryDialog", "onApplyWindowInsets, systemBarHeight: " + r6 + ", imeInsets: " + r4);
        if (r4 >= com.obric.oui.common.util.h.b(r3)) goto L16;
        r9.postDelayed(new $$Lambda$d$cWe8BwnDaQlxp4uqZeFvxLdrhU(r3, r4, r9, r6, r7), 10);
    L16:
        return r11.consumeSystemWindowInsets();
    L11:
        r6 = com.obric.oui.window.a.f14878a.b(r3);
        goto L12
    L5:
        if (r8.a(r3) == true) goto L8;
        r14 = false;
        goto L9
    }

    public static final /* synthetic */ DelayedLoadingStateMachine a(d r0) {
        return r0.i;
    }

    private static final ButtonStyleController a(Context r2, int r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "ctx");
        return (ButtonStyleController) ZeusTransformUtils.preCheckCast(new com.obric.oui.dialog.v2.alert.style.a(r4, r3), ButtonStyleController.class, "com.obric.memorydata.plugin");
    }

    private static final Unit a(d r4, com.obric.oui.dialog.v2.alert.style.d r5) {
        com.obric.oui.dialog.v2.alert.style.d r6 = (com.obric.oui.dialog.v2.alert.style.d) ZeusTransformUtils.wrapperContextForParams(r5, com.obric.oui.dialog.v2.alert.style.d.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "container");
        ZeusTransformUtils.inflate(LayoutInflater.from((Context) ZeusTransformUtils.preCheckCast(r4.f12743b, Context.class, "com.obric.memorydata.plugin")), ZeusTransformUtils.mapRes(R.layout.dialog_block_memory, "layout", "dialog_block_memory"), (ViewGroup) ZeusTransformUtils.preCheckCast(r6.getBodySlot(), ViewGroup.class, "com.obric.memorydata.plugin"), true, "com.obric.memorydata.plugin");
        return Unit.INSTANCE;
    }

    private static final void a(Context r5, int r6, View r7, int r8, boolean r9) {
        int r10 = ZeusTransformUtils.getResources((Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin").getDimensionPixelSize(ZeusTransformUtils.mapRes(R.dimen.oui_dialog_layout_margin, "dimen", "oui_dialog_layout_margin"));
        ViewGroup.MarginLayoutParams r3 = null;
        if (r6 <= 0) goto L11;
        ViewGroup.LayoutParams r11 = r7.getLayoutParams();
        if (ZeusTransformUtils.instanceOf(r11, ViewGroup.MarginLayoutParams.class) == false) goto L7;
        r3 = (ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r11, ViewGroup.MarginLayoutParams.class, "com.obric.memorydata.plugin");
    L7:
        if (r3 == null) goto L9;
        r3.bottomMargin = Math.max(r6, r8) + r10;
    L9:
        r7.setLayoutParams(r11);
        RunLog r12 = RunLog.INSTANCE;
        StringBuilder r13 = new StringBuilder().append("onApplyWindowInsets, update rootView.layoutParams, bottomMargin: ").append(r6 + MathKt.roundToInt(TypedValue.applyDimension(1, 16, Resources.getSystem().getDisplayMetrics())));
    L10:
        r12.debug("BlockMemoryDialog", r13.toString());
        return;
    L11:
        ViewGroup.LayoutParams r14 = r7.getLayoutParams();
        if (r9 == false) goto L19;
        if (ZeusTransformUtils.instanceOf(r14, ViewGroup.MarginLayoutParams.class) == false) goto L16;
        r3 = (ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r14, ViewGroup.MarginLayoutParams.class, "com.obric.memorydata.plugin");
    L16:
        if (r3 != null) goto L23;
    L24:
        r7.setLayoutParams(r14);
        r12 = RunLog.INSTANCE;
        r13 = new StringBuilder().append("onApplyWindowInsets, update rootView.layoutParams, bottomMargin: ").append(r8);
    L23:
        r3.bottomMargin = r10;
        goto L24
    L19:
        if (ZeusTransformUtils.instanceOf(r14, ViewGroup.MarginLayoutParams.class) == false) goto L21;
        r3 = (ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r14, ViewGroup.MarginLayoutParams.class, "com.obric.memorydata.plugin");
    L21:
        if (r3 == null) goto L24;
        r10 = r10 + r8;
        goto L23
    }

    private final void a(final View r2) {
        r2.setOnApplyWindowInsetsListener(new $$Lambda$d$ristSd6rqoGrsVgVhuZg_k_IwyA(this, r2));
    }

    private final void a(Window r5) {
        if (r5 != null) goto L5;
        return;
    L5:
        if ((ZeusTransformUtils.getResources(this.f12743b, "com.obric.memorydata.plugin").getConfiguration().uiMode & 48) != 32) goto L7;
        boolean r4 = true;
    L8:
        WindowInsetsControllerCompat r0 = WindowCompat.getInsetsController(r5, r5.getDecorView());
        Intrinsics.checkNotNullExpressionValue(r0, "getInsetsController(...)");
        r0.setAppearanceLightStatusBars(!r4);
        com.obric.memorydata.ui.g.a(r5, false);
        return;
    L7:
        r4 = false;
        goto L8
    }

    private final void a(BlockMemoryDialogViewModel.a r9) {
        RunLog r0 = RunLog.INSTANCE;
        StringBuilder r1 = new StringBuilder().append("exclusion rule state loading=").append(r9.a().a()).append(" code=");
        BlockMemoryDialogViewModel.d r2 = r9.a().d();
        OInputLayout r3 = null;
        if (r2 == null) goto L5;
        Integer r4 = Integer.valueOf(r2.a());
    L6:
        r0.debug("BlockMemoryDialog", r1.append(r4).toString());
        c(r9);
        if (r9.a().a() == true) goto L39;
        BlockMemoryDialogViewModel.c r10 = r9.a();
        OInputLayout r5 = this.l;
        if (r5 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("inputView");
        r5 = null;
    L11:
        r5.setHint((CharSequence) ZeusTransformUtils.preCheckCast("", CharSequence.class, "com.obric.memorydata.plugin"));
        BlockMemoryDialogViewModel.d r6 = r10.d();
        boolean r7 = true;
        if (r6 != null) goto L14;
    L16:
        boolean r8 = false;
    L18:
        if (r8 == true) goto L20;
    L30:
        String r11 = StringsKt.take(r10.b(), 100);
        OInputLayout r12 = this.l;
        if (r12 != null) goto L33;
        Intrinsics.throwUninitializedPropertyAccessException("inputView");
        r12 = null;
    L33:
        r12.setText((CharSequence) ZeusTransformUtils.preCheckCast(r11, CharSequence.class, "com.obric.memorydata.plugin"));
        OInputLayout r13 = this.l;
        if (r13 != null) goto L36;
    L35:
        Intrinsics.throwUninitializedPropertyAccessException("inputView");
    L37:
        r3.getVInput().setSelection(r11.length());
        return;
    L36:
        r3 = r13;
        goto L37
    L20:
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r10.c(), CharSequence.class, "com.obric.memorydata.plugin")).length() > 0) goto L23;
        r7 = false;
    L23:
        if (r7 == false) goto L30;
        r11 = StringsKt.take(r10.c(), 100);
        OInputLayout r14 = this.l;
        if (r14 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException("inputView");
        r14 = null;
    L27:
        r14.setText((CharSequence) ZeusTransformUtils.preCheckCast(r11, CharSequence.class, "com.obric.memorydata.plugin"));
        r13 = this.l;
        if (r13 != null) goto L36;
    L14:
        if (r6.a() != 0) goto L16;
        r8 = true;
        goto L18
    L39:
        return;
    L5:
        r4 = null;
        goto L6
    }

    private static final void a(d r2, DialogInterface r3) {
        DialogInterface r4 = (DialogInterface) ZeusTransformUtils.wrapperContextForParams(r3, DialogInterface.class, "com.obric.memorydata.plugin");
        r2.l();
        am.a(r2.h, null, 1, null);
        r2.c().clean();
    }

    private static final void a(d r0, View r1) {
        r0.b();
    }

    public static final /* synthetic */ void a(d r0, BlockMemoryDialogViewModel.a r1) {
        r0.a(r1);
    }

    private static final void a(d r1, OEditText r2, InputMethodManager r3) {
        r1.s = null;
        if (r2.isAttachedToWindow() == true) goto L5;
        return;
    L5:
        if (r2.isShown() == false) goto L9;
        r3.showSoftInput((View) ZeusTransformUtils.preCheckCast(r2, View.class, "com.obric.memorydata.plugin"), 1);
        return;
    }

    public static final /* synthetic */ void a(d r0, String r1) {
        r0.t = r1;
    }

    public static final /* synthetic */ void a(d r0, boolean r1, String r2) {
        r0.a(r1, r2);
    }

    private static final void a(final OEditText r5, final d r6) {
        if (r5.isAttachedToWindow() == true) goto L5;
        return;
    L5:
        if (r5.isShown() == false) goto L16;
        r5.setFocusableInTouchMode(true);
        r5.requestFocus();
        Object r1 = r6.f12743b.getSystemService("input_method");
        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        final InputMethodManager r2 = (InputMethodManager) ZeusTransformUtils.preCheckCast(r1, InputMethodManager.class, "com.obric.memorydata.plugin");
        com.obric.oui.dialog.v2.alert.a r3 = r6.k;
        if (r3 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("dialog");
        r3 = null;
    L10:
        Window r4 = r3.getWindow();
        if (r4 == null) goto L13;
        WindowCompat.getInsetsController(r4, (View) ZeusTransformUtils.preCheckCast(r5, View.class, "com.obric.memorydata.plugin")).show(WindowInsetsCompat.Type.ime());
    L13:
        r2.showSoftInput((View) ZeusTransformUtils.preCheckCast(r5, View.class, "com.obric.memorydata.plugin"), 1);
        r6.i();
        Runnable r0 = new $$Lambda$d$ZaTlf3J17RL13dYhWK18gtW1Djk(r6, r5, r2);
        r6.s = r0;
        r5.postDelayed(r0, 50);
        return;
    }

    private final void a(boolean r4) {
        bx r0 = this.r;
        com.obric.oui.dialog.v2.alert.a r1 = null;
        if (r0 == null) goto L5;
        bx.a.a(r0, null, 1, null);
    L5:
        this.r = null;
        DelayedLoadingStateMachine.Transition r5 = this.i.a(r4);
        if (r5 != DelayedLoadingStateMachine.Transition.NONE) goto L8;
        return;
    L8:
        Dialog r2 = this.q;
        if (r2 == null) goto L12;
        r2.dismiss();
    L12:
        if (r5 == DelayedLoadingStateMachine.Transition.RESTORE_EDITOR) goto L14;
        return;
    L14:
        if (this.f12743b.isFinishing() == false) goto L16;
        return;
    L16:
        if (this.f12743b.isDestroyed() == true) goto L31;
        com.obric.oui.dialog.v2.alert.a r6 = this.k;
        if (r6 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("dialog");
        r6 = null;
    L20:
        Window r7 = r6.getWindow();
        if (r7 == null) goto L23;
        r7.setSoftInputMode(20);
    L23:
        com.obric.oui.dialog.v2.alert.a r8 = this.k;
        if (r8 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("dialog");
    L27:
        r1.show();
        f();
        h();
        return;
    L26:
        r1 = r8;
        goto L27
    }

    private final void a(boolean r5, String r6) {
        b(r5);
        this.u = r5;
        OInputLayout r1 = null;
        if (r5 == false) goto L12;
        OInputLayout r7 = this.l;
        if (r7 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("inputView");
        r7 = null;
    L7:
        r7.setTip((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.memorydata.plugin"));
        OInputLayout r4 = this.l;
        if (r4 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("inputView");
    L11:
        boolean r8 = true;
    L20:
        r1.f(r8);
        return;
    L10:
        r1 = r4;
        goto L11
    L12:
        OInputLayout r9 = this.l;
        if (r9 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("inputView");
        r9 = null;
    L15:
        r9.setTip((CharSequence) ZeusTransformUtils.preCheckCast("", CharSequence.class, "com.obric.memorydata.plugin"));
        OInputLayout r10 = this.l;
        if (r10 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("inputView");
    L19:
        r8 = false;
        goto L20
    L18:
        r1 = r10;
        goto L19
    }

    private final boolean a(Context r4) {
        if (ZeusTransformUtils.getResources((Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin").getConfiguration().orientation == 2) goto L13;
        return false;
    L13:
        return true;
    L7:
        e = move-exception;
        RunLog.INSTANCE.error("BlockMemoryDialog", "isLandscape error", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
        return false;
    }

    private final void b(BlockMemoryDialogViewModel.a r14) {
        BlockMemoryDialogViewModel.e r0 = r14.b();
        if (r0.a() == false) goto L5;
        g();
    L18:
        c(r14);
        RunLog r1 = RunLog.INSTANCE;
        StringBuilder r4 = new StringBuilder().append("validation state loading=").append(r0.a()).append(" code=");
        BlockMemoryDialogViewModel.d r5 = r0.b();
        OButton r6 = null;
        if (r5 == null) goto L21;
        Integer r7 = Integer.valueOf(r5.a());
    L22:
        r1.debug("BlockMemoryDialog", r4.append(r7).append(" safe=").append(r0.d()).toString());
        if (r0.a() == false) goto L25;
        return;
    L25:
        if (r0.b() != null) goto L28;
        return;
    L28:
        if (r0.b().a() == 0) goto L34;
        if (r0.b().a() == 2) goto L34;
        com.obric.memorydata.utils.ba.a((Context) ZeusTransformUtils.preCheckCast(this.f12743b, Context.class, "com.obric.memorydata.plugin"), r0.b().b(), 0, 4, null);
        return;
    L34:
        if (r0.d() == false) goto L48;
        OCheckBox r2 = this.o;
        if (r2 != null) goto L39;
        Intrinsics.throwUninitializedPropertyAccessException("deleteCheckBox");
        r2 = null;
    L39:
        if (r2.isChecked() == false) goto L43;
        Function0<Unit> r3 = this.e;
        if (r3 == null) goto L43;
        r3.invoke();
    L43:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "BlockMemoryDialog", "save block memory content & finish", false, 4, null);
        Function1<String, Unit> r8 = this.f;
        if (r8 == null) goto L46;
        r8.invoke(r14.b().c());
    L47:
        b();
        return;
    L46:
        kotlinx.coroutines.i.a(this.h, (CoroutineContext) ZeusTransformUtils.preCheckCast(ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin"), null, (Function2) ZeusTransformUtils.preCheckCast(new BlockMemoryDialog$handleValidateContentResult$1$1(this, r14, null), Function2.class, "com.obric.memorydata.plugin"), 2, null);
        goto L47
    L48:
        OButton r15 = this.n;
        if (r15 != null) goto L51;
        Intrinsics.throwUninitializedPropertyAccessException("confirmButton");
    L52:
        r6.setEnabled(false);
        a(true, r0.b().b());
        return;
    L51:
        r6 = r15;
        goto L52
    L21:
        r7 = null;
        goto L22
    L5:
        BlockMemoryDialogViewModel.d r9 = r0.b();
        if (r9 != null) goto L8;
    L16:
        boolean r10 = false;
    L17:
        a(r10);
        goto L18
    L8:
        if (r9.a() == 0) goto L10;
    L13:
        boolean r11 = true;
    L14:
        if (r11 != true) goto L16;
        r10 = true;
        goto L17
    L10:
        if (r0.d() == false) goto L13;
        r11 = false;
        goto L14
    }

    public static final /* synthetic */ void b(d r0) {
        r0.j();
    }

    private static final void b(d r6, View r7) {
        if (((BlockMemoryDialogViewModel.a) ZeusTransformUtils.preCheckCast(r6.c().getState().c(), BlockMemoryDialogViewModel.a.class, "com.obric.memorydata.plugin")).b().a() == false) goto L5;
        return;
    L5:
        OInputLayout r8 = r6.l;
        if (r8 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("inputView");
        r8 = null;
    L8:
        String r9 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(String.valueOf(r8.getVInput().getText()), CharSequence.class, "com.obric.memorydata.plugin")).toString();
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, "com.obric.memorydata.plugin")).length() != 0) goto L11;
        boolean r0 = true;
    L12:
        if (r0 == false) goto L15;
        return;
    L15:
        if (r6.c == false) goto L17;
    L20:
        BlockMemoryDialogViewModel r1 = r6.c();
        if (r6.g == false) goto L23;
        String r10 = r6.d;
    L24:
        r1.validateContent(r9, r10);
        return;
    L23:
        r10 = "";
        goto L24
    L17:
        if (Intrinsics.areEqual(r9, r6.d) == false) goto L20;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "BlockMemoryDialog", "inputText is same as content, no need to validate", false, 4, null);
        r6.b();
        return;
    L11:
        r0 = false;
        goto L12
    }

    public static final /* synthetic */ void b(d r0, BlockMemoryDialogViewModel.a r1) {
        r0.b(r1);
    }

    private final void b(boolean r10) {
        OInputLayout r0 = this.l;
        OInputLayout r1 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("inputView");
        r0 = null;
    L5:
        OEditText r2 = r0.getVInput();
        OInputLayout r3 = this.l;
        if (r3 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("inputView");
        r3 = null;
    L8:
        Context r4 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r3.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        OInputLayout r5 = this.l;
        if (r5 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("inputView");
        r5 = null;
    L11:
        Resources r6 = ZeusTransformUtils.getResources(r5, "com.obric.memorydata.plugin");
        if (r10 == false) goto L14;
        r2.setHighlightColor(ContextCompat.getColor(r4, ZeusTransformUtils.mapRes(R.color.oui_functional_red_2, TypedValues.Custom.S_COLOR, "oui_functional_red_2")));
        r2.requestFocus();
        r2.selectAll();
    L16:
        if (Build.VERSION.SDK_INT >= 29) goto L18;
    L22:
        if (r10 == false) goto L24;
        int r11 = R.color.oui_functional_red_6;
        String r7 = "oui_functional_red_6";
    L25:
        int r12 = r6.getColor(ZeusTransformUtils.mapRes(r11, TypedValues.Custom.S_COLOR, r7));
        OInputLayout r8 = this.l;
        if (r8 != null) goto L28;
        Intrinsics.throwUninitializedPropertyAccessException("inputView");
        r8 = null;
    L28:
        r8.getTip();
        OInputLayout r9 = this.l;
        if (r9 != null) goto L31;
        Intrinsics.throwUninitializedPropertyAccessException("inputView");
        r9 = null;
    L31:
        TextView r13 = (TextView) ZeusTransformUtils.preCheckCast(r9.findViewById(ZeusTransformUtils.mapRes(R.id.tip, OaidModel.KEY_ID, "tip")), TextView.class, "com.obric.memorydata.plugin");
        if (r13 == null) goto L34;
        r13.setTextColor(r12);
    L34:
        OInputLayout r14 = this.l;
        if (r14 != null) goto L37;
        Intrinsics.throwUninitializedPropertyAccessException("inputView");
        r14 = null;
    L37:
        TextView r15 = (TextView) ZeusTransformUtils.preCheckCast(r14.findViewById(ZeusTransformUtils.mapRes(R.id.limit_single, OaidModel.KEY_ID, "limit_single")), TextView.class, "com.obric.memorydata.plugin");
        if (r15 == null) goto L40;
        r15.setTextColor(r12);
    L40:
        OInputLayout r16 = this.l;
        if (r16 != null) goto L43;
        Intrinsics.throwUninitializedPropertyAccessException("inputView");
    L44:
        TextView r17 = (TextView) ZeusTransformUtils.preCheckCast(r1.findViewById(ZeusTransformUtils.mapRes(R.id.limit_multi, OaidModel.KEY_ID, "limit_multi")), TextView.class, "com.obric.memorydata.plugin");
        if (r17 == null) goto L48;
        r17.setTextColor(r12);
        return;
    L48:
        return;
    L43:
        r1 = r16;
        goto L44
    L24:
        r11 = R.color.oui_basic_text_3b;
        r7 = "oui_basic_text_3b";
        goto L25
    L18:
        if (r10 == false) goto L20;
        int r18 = R.drawable.o_input_cursor_red;
        String r19 = "o_input_cursor_red";
    L21:
        r2.setTextCursorDrawable(ZeusTransformUtils.mapRes(r18, "drawable", r19));
        goto L22
    L20:
        r18 = R.drawable.o_input_cursor_blue;
        r19 = "o_input_cursor_blue";
        goto L21
    L14:
        r2.setHighlightColor(Color.parseColor("#333051F2"));
        goto L16
    }

    private final BlockMemoryDialogViewModel c() {
        return (BlockMemoryDialogViewModel) ZeusTransformUtils.preCheckCast(this.j.getValue(), BlockMemoryDialogViewModel.class, "com.obric.memorydata.plugin");
    }

    public static final /* synthetic */ String c(d r0) {
        return r0.t;
    }

    private final void c(BlockMemoryDialogViewModel.a r4) {
        RunLog.INSTANCE.debug("BlockMemoryDialog", "updateUI exclusionLoading=" + r4.a().a() + " validationLoading=" + r4.b().a());
        d(r4);
        e(r4);
        f(r4);
    }

    public static final /* synthetic */ OButton d(d r0) {
        return r0.n;
    }

    private final void d() {
        com.obric.oui.dialog.v2.alert.a r0 = this.k;
        com.obric.oui.dialog.v2.alert.a r2 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("dialog");
        r0 = null;
    L5:
        View r1 = r0.findViewById(ZeusTransformUtils.mapRes(R.id.block_content_input, OaidModel.KEY_ID, "block_content_input"));
        Intrinsics.checkNotNullExpressionValue(r1, "findViewById(...)");
        this.l = (OInputLayout) ZeusTransformUtils.preCheckCast(r1, OInputLayout.class, "com.obric.memorydata.plugin");
        com.obric.oui.dialog.v2.alert.a r3 = this.k;
        if (r3 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("dialog");
        r3 = null;
    L8:
        a(r3.j());
        OInputLayout r4 = this.l;
        if (r4 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("inputView");
        r4 = null;
    L11:
        r4.c(false);
        OInputLayout r5 = this.l;
        if (r5 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("inputView");
        r5 = null;
    L14:
        r5.setInputType(1);
        OInputLayout r6 = this.l;
        if (r6 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("inputView");
        r6 = null;
    L17:
        r6.setMaxLines(1);
        OInputLayout r7 = this.l;
        if (r7 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("inputView");
        r7 = null;
    L20:
        r7.a(true);
        com.obric.oui.dialog.v2.alert.a r8 = this.k;
        if (r8 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("dialog");
        r8 = null;
    L23:
        View r9 = r8.findViewById(ZeusTransformUtils.mapRes(R.id.block_memory_cancel, OaidModel.KEY_ID, "block_memory_cancel"));
        Intrinsics.checkNotNullExpressionValue(r9, "findViewById(...)");
        this.m = (OButton) ZeusTransformUtils.preCheckCast(r9, OButton.class, "com.obric.memorydata.plugin");
        com.obric.oui.dialog.v2.alert.a r10 = this.k;
        if (r10 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("dialog");
        r10 = null;
    L26:
        View r11 = r10.findViewById(ZeusTransformUtils.mapRes(R.id.block_memory_confirm, OaidModel.KEY_ID, "block_memory_confirm"));
        Intrinsics.checkNotNullExpressionValue(r11, "findViewById(...)");
        this.n = (OButton) ZeusTransformUtils.preCheckCast(r11, OButton.class, "com.obric.memorydata.plugin");
        com.obric.oui.dialog.v2.alert.a r12 = this.k;
        if (r12 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("dialog");
        r12 = null;
    L29:
        View r13 = r12.findViewById(ZeusTransformUtils.mapRes(R.id.cb_delete_memory, OaidModel.KEY_ID, "cb_delete_memory"));
        Intrinsics.checkNotNullExpressionValue(r13, "findViewById(...)");
        this.o = (OCheckBox) ZeusTransformUtils.preCheckCast(r13, OCheckBox.class, "com.obric.memorydata.plugin");
        com.obric.oui.dialog.v2.alert.a r14 = this.k;
        if (r14 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("dialog");
        r14 = null;
    L32:
        View r15 = r14.findViewById(ZeusTransformUtils.mapRes(R.id.ll_delete_memory, OaidModel.KEY_ID, "ll_delete_memory"));
        Intrinsics.checkNotNullExpressionValue(r15, "findViewById(...)");
        this.p = (LinearLayout) ZeusTransformUtils.preCheckCast(r15, LinearLayout.class, "com.obric.memorydata.plugin");
        if (this.g == false) goto L42;
        OButton r16 = this.n;
        if (r16 != null) goto L37;
        Intrinsics.throwUninitializedPropertyAccessException("confirmButton");
        r16 = null;
    L37:
        com.obric.oui.dialog.v2.alert.a r17 = this.k;
        if (r17 != null) goto L40;
        Intrinsics.throwUninitializedPropertyAccessException("dialog");
    L41:
        Context r18 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r2.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        int r19 = R.string.screen_memory_block_dialog_confirm;
        String r20 = "screen_memory_block_dialog_confirm";
    L50:
        r16.setText((CharSequence) ZeusTransformUtils.preCheckCast(r18.getString(ZeusTransformUtils.mapRes(r19, TypedValues.Custom.S_STRING, r20)), CharSequence.class, "com.obric.memorydata.plugin"));
        return;
    L40:
        r2 = r17;
        goto L41
    L42:
        r16 = this.n;
        if (r16 != null) goto L45;
        Intrinsics.throwUninitializedPropertyAccessException("confirmButton");
        r16 = null;
    L45:
        com.obric.oui.dialog.v2.alert.a r21 = this.k;
        if (r21 != null) goto L48;
        Intrinsics.throwUninitializedPropertyAccessException("dialog");
    L49:
        r18 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r2.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        r19 = R.string.screen_memory_block_dialog_confirm_create;
        r20 = "screen_memory_block_dialog_confirm_create";
        goto L50
    L48:
        r2 = r21;
        goto L49
    }

    private final void d(BlockMemoryDialogViewModel.a r7) {
        if (r7.a().a() == false) goto L5;
    L8:
        boolean r8 = true;
    L9:
        boolean r9 = !r8;
        OInputLayout r0 = this.l;
        OInputLayout r3 = null;
        if (r0 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("inputView");
        r0 = null;
    L13:
        if (r0.getVInput().isEnabled() == r9) goto L34;
        OInputLayout r1 = this.l;
        if (r1 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("inputView");
        r1 = null;
    L17:
        int r2 = r1.getVInput().getSelectionStart();
        OInputLayout r5 = this.l;
        if (r5 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("inputView");
        r5 = null;
    L20:
        r5.getVInput().setEnabled(r9);
        if (r9 == false) goto L27;
        if (r2 < 0) goto L27;
        OInputLayout r6 = this.l;
        if (r6 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("inputView");
        r6 = null;
    L26:
        r6.getVInput().setSelection(r2);
    L27:
        if (r9 == false) goto L35;
        OInputLayout r10 = this.l;
        if (r10 != null) goto L31;
        Intrinsics.throwUninitializedPropertyAccessException("inputView");
    L32:
        r3.getVInput().setFilters((InputFilter[]) ZeusTransformUtils.preCheckCast(new InputFilter.LengthFilter[]{new InputFilter.LengthFilter(100)}, InputFilter[].class, "com.obric.memorydata.plugin"));
        return;
    L31:
        r3 = r10;
        goto L32
    L35:
        return;
    L34:
        return;
    L5:
        if (r7.b().a() == true) goto L8;
        r8 = false;
        goto L9
    }

    private final void e() {
        if (this.c == false) goto L5;
        k.b(k.f(k.a((kotlinx.coroutines.flow.i) ZeusTransformUtils.preCheckCast(c().getState(), kotlinx.coroutines.flow.i.class, "com.obric.memorydata.plugin"), $$Lambda$d$Bz2eWbmz5pX7MHztEXW6ZzZ6Hyc.INSTANCE), (Function2) ZeusTransformUtils.preCheckCast(new BlockMemoryDialog$observerState$2(this, null), Function2.class, "com.obric.memorydata.plugin")), this.h);
    L5:
        k.b(k.f(k.a((kotlinx.coroutines.flow.i) ZeusTransformUtils.preCheckCast(c().getState(), kotlinx.coroutines.flow.i.class, "com.obric.memorydata.plugin"), $$Lambda$d$Ow3ooRQ3wDPmkR9PT82ySYTUKxA.INSTANCE), (Function2) ZeusTransformUtils.preCheckCast(new BlockMemoryDialog$observerState$4(this, null), Function2.class, "com.obric.memorydata.plugin")), this.h);
    }

    private final void e(BlockMemoryDialogViewModel.a r5) {
        boolean r1 = false;
        if (r5.a().a() == false) goto L5;
    L8:
        boolean r6 = true;
    L9:
        OButton r0 = this.n;
        OInputLayout r3 = null;
        if (r0 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("confirmButton");
        r0 = null;
    L12:
        if (r6 == true) goto L26;
        OInputLayout r4 = this.l;
        if (r4 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("inputView");
    L17:
        CharSequence r7 = r3.getText();
        if (r7 != null) goto L20;
    L23:
        boolean r8 = true;
    L24:
        if (r8 == true) goto L26;
        r1 = true;
        goto L26
    L20:
        if (r7.length() == 0) goto L23;
        r8 = false;
        goto L24
    L16:
        r3 = r4;
    L26:
        r0.setEnabled(r1);
        return;
    L5:
        if (r5.b().a() == true) goto L8;
        r6 = false;
        goto L9
    }

    public static final /* synthetic */ boolean e(d r0) {
        return r0.u;
    }

    public static final /* synthetic */ BlockMemoryDialogViewModel f(d r0) {
        return r0.c();
    }

    private final void f() {
        com.obric.oui.dialog.v2.alert.a r0 = this.k;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("dialog");
        r0 = null;
    L5:
        a(r0.getWindow());
    }

    private final void f(BlockMemoryDialogViewModel.a r4) {
        boolean r5 = r4.a().a();
        OInputLayout r0 = null;
        OInputLayout r3 = this.l;
        if (r5 == false) goto L8;
        if (r3 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("inputView");
    L7:
        Object r6 = ZeusTransformUtils.preCheckCast(at.a(ZeusTransformUtils.mapRes(R.string.screen_memory_block_dialog_extra_rule_hint, TypedValues.Custom.S_STRING, "screen_memory_block_dialog_extra_rule_hint")), CharSequence.class, "com.obric.memorydata.plugin");
    L12:
        r0.setHint((CharSequence) r6);
        return;
    L6:
        r0 = r3;
        goto L7
    L8:
        if (r3 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("inputView");
    L11:
        r6 = ZeusTransformUtils.preCheckCast("", CharSequence.class, "com.obric.memorydata.plugin");
        goto L12
    L10:
        r0 = r3;
        goto L11
    }

    private static final BlockMemoryDialogViewModel.c g(BlockMemoryDialogViewModel.a r1) {
        Intrinsics.checkNotNullParameter(r1, "it");
        return r1.a();
    }

    private static final BlockMemoryDialogViewModel g(d r3) {
        return (BlockMemoryDialogViewModel) ZeusTransformUtils.preCheckCast(new ViewModelProvider((ViewModelStoreOwner) ZeusTransformUtils.preCheckCast(r3.f12743b, ViewModelStoreOwner.class, "com.obric.memorydata.plugin")).get(BlockMemoryDialogViewModel.class), BlockMemoryDialogViewModel.class, "com.obric.memorydata.plugin");
    }

    private final void g() {
        bx r0 = this.r;
        if (r0 == null) goto L5;
        bx.a.a(r0, null, 1, null);
    L5:
        this.i.a();
        this.r = kotlinx.coroutines.i.a(this.h, null, null, (Function2) ZeusTransformUtils.preCheckCast(new BlockMemoryDialog$startCreatingRuleLoadingTimer$1(this, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
    }

    private static final BlockMemoryDialogViewModel.e h(BlockMemoryDialogViewModel.a r1) {
        Intrinsics.checkNotNullParameter(r1, "it");
        return r1.b();
    }

    private final void h() {
        OInputLayout r0 = this.l;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("inputView");
        r0 = null;
    L5:
        final OEditText r1 = r0.getVInput();
        r1.post(new $$Lambda$d$r7fzw2Uw3n_7UTjuk4NR1hPeih0(r1, this));
    }

    private static final void h(d r3) {
        OInputLayout r4 = r3.l;     // Catch: Exception -> L7
        if (r4 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("inputView");     // Catch: Exception -> L7
        r4 = null;
    L5:
        r4.getVInput().requestFocus();     // Catch: Exception -> L7
        return;
    L7:
        e = move-exception;
        RunLog.INSTANCE.error("BlockMemoryDialog", "onStart, requestFocus failed", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
    }

    private final void i() {
        Runnable r0 = this.s;
        if (r0 == null) goto L8;
        OInputLayout r2 = this.l;
        if (r2 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("inputView");
        r2 = null;
    L7:
        r2.getVInput().removeCallbacks(r0);
    L8:
        this.s = null;
    }

    private final void j() {
        if (this.f12743b.isFinishing() == false) goto L5;
        return;
    L5:
        if (this.f12743b.isDestroyed() == true) goto L19;
        com.obric.oui.dialog.v2.alert.a r0 = this.k;
        if (r0 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("dialog");
        r0 = null;
    L10:
        r0.hide();
        Dialog r1 = this.q;
        if (r1 != null) goto L13;
        r1 = k();
        this.q = r1;
    L13:
        r1.show();
        Window r2 = r1.getWindow();
        if (r2 == null) goto L16;
        r2.setLayout(-1, -2);
    L16:
        a(r1.getWindow());
        return;
    }

    private final Dialog k() {
        Dialog r0 = new Dialog((Context) ZeusTransformUtils.preCheckCast(this.f12743b, Context.class, "com.obric.memorydata.plugin"));
        r0.setContentView(ZeusTransformUtils.mapRes(R.layout.dialog_block_memory_loading, "layout", "dialog_block_memory_loading"));
        r0.setCancelable(false);
        r0.setCanceledOnTouchOutside(false);
        ODownloadProgressView r1 = (ODownloadProgressView) ZeusTransformUtils.preCheckCast(r0.findViewById(ZeusTransformUtils.mapRes(R.id.block_memory_loading_progress, OaidModel.KEY_ID, "block_memory_loading_progress")), ODownloadProgressView.class, "com.obric.memorydata.plugin");
        int r3 = ContextCompat.getColor((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r1.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), ZeusTransformUtils.mapRes(R.color.oui_basic_text_1, TypedValues.Custom.S_COLOR, "oui_basic_text_1"));
        int r4 = ContextCompat.getColor((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r1.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), ZeusTransformUtils.mapRes(R.color.oui_basic_line_2, TypedValues.Custom.S_COLOR, "oui_basic_line_2"));
        r1.setProgressColor(r3);
        r1.setProgressBackgroundColor(r4);
        r1.setProcessingColor(r3);
        r1.setActionColor(r3);
        r1.setCurrentState(0);
        Window r2 = r0.getWindow();
        if (r2 == null) goto L5;
        r2.setBackgroundDrawable((Drawable) ZeusTransformUtils.preCheckCast(new ColorDrawable(0), Drawable.class, "com.obric.memorydata.plugin"));
        r2.addFlags(2);
        WindowManager.LayoutParams r5 = r2.getAttributes();
        r5.dimAmount = 0.32f;
        r5.gravity = 80;
        r2.setAttributes(r5);
        r2.getDecorView().setPadding(0, 0, 0, 0);
    L5:
        return r0;
    }

    private final void l() {
        i();
        bx r0 = this.r;
        if (r0 == null) goto L5;
        bx.a.a(r0, null, 1, null);
    L5:
        this.r = null;
        this.i.c();
        Dialog r1 = this.q;
        if (r1 == null) goto L8;
        r1.dismiss();
    L8:
        this.q = null;
    }

    /* JADX INFO: renamed from: lambda$-wBGc_mun5cPIKAdRXAHhJHVZCk, reason: not valid java name */
    public static /* synthetic */ void m1163lambda$wBGc_mun5cPIKAdRXAHhJHVZCk(d r0, View r1) {
        a(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$29Oxusrw3J-uOW8LF4dyE8rDRHE, reason: not valid java name */
    public static /* synthetic */ Unit m1164lambda$29Oxusrw3JuOW8LF4dyE8rDRHE(d r0, com.obric.oui.dialog.v2.alert.style.d r1) {
        return a(r0, r1);
    }

    public static /* synthetic */ BlockMemoryDialogViewModel lambda$2g_pNzrfYiEit1WfhgLXdER1X6s(d r0) {
        return g(r0);
    }

    public static /* synthetic */ BlockMemoryDialogViewModel.c lambda$Bz2eWbmz5pX7MHztEXW6ZzZ6Hyc(BlockMemoryDialogViewModel.a r0) {
        return g(r0);
    }

    public static /* synthetic */ BlockMemoryDialogViewModel.e lambda$Ow3ooRQ3wDPmkR9PT82ySYTUKxA(BlockMemoryDialogViewModel.a r0) {
        return h(r0);
    }

    public static /* synthetic */ void lambda$ZaTlf3J17RL13dYhWK18gtW1Djk(d r0, OEditText r1, InputMethodManager r2) {
        a(r0, r1, r2);
    }

    /* JADX INFO: renamed from: lambda$cWe8BwnDaQlxp4uqZeF-vxLdrhU, reason: not valid java name */
    public static /* synthetic */ void m1165lambda$cWe8BwnDaQlxp4uqZeFvxLdrhU(Context r0, int r1, View r2, int r3, boolean r4) {
        a(r0, r1, r2, r3, r4);
    }

    public static /* synthetic */ ButtonStyleController lambda$ebaxDFrMXDwPGglgwKNIFKQWyGI(Context r0, int r1) {
        return a(r0, r1);
    }

    public static /* synthetic */ void lambda$hzHLrJ1TJr1_OQMvIzo9j5bdMck(d r0, View r1) {
        b(r0, r1);
    }

    public static /* synthetic */ void lambda$lo_XaDLPYSscYGMRefKJEYYRwW8(d r0) {
        h(r0);
    }

    public static /* synthetic */ void lambda$r7fzw2Uw3n_7UTjuk4NR1hPeih0(OEditText r0, d r1) {
        a(r0, r1);
    }

    public static /* synthetic */ WindowInsets lambda$ristSd6rqoGrsVgVhuZg_k_IwyA(d r0, View r1, View r2, WindowInsets r3) {
        return a(r0, r1, r2, r3);
    }

    public static /* synthetic */ void lambda$tQqH_hu6TAYJ1MM9m_WxHAKlVkY(d r0, DialogInterface r1) {
        a(r0, r1);
    }

    private final void m() {
        RunLog r0 = RunLog.INSTANCE;
        StringBuilder r1 = new StringBuilder().append("initView needExtraRule=").append(this.c).append(" hasInitialContent=");
        CharSequence r2 = (CharSequence) ZeusTransformUtils.preCheckCast(this.d, CharSequence.class, "com.obric.memorydata.plugin");
        boolean r3 = false;
        if (r2 != null) goto L5;
    L8:
        boolean r4 = true;
    L9:
        r0.debug("BlockMemoryDialog", r1.append(!r4).toString());
        OButton r5 = null;
        if (this.c == false) goto L21;
        CharSequence r6 = (CharSequence) ZeusTransformUtils.preCheckCast(this.d, CharSequence.class, "com.obric.memorydata.plugin");
        if (r6 != null) goto L14;
    L17:
        boolean r7 = true;
    L18:
        if (r7 == false) goto L20;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "BlockMemoryDialog", "needExtraRule is true, but content is empty", null, 4, null);
    L31:
        if (this.c == false) goto L39;
        OCheckBox r8 = this.o;
        if (r8 != null) goto L35;
        Intrinsics.throwUninitializedPropertyAccessException("deleteCheckBox");
        r8 = null;
    L35:
        r8.setChecked(true);
        LinearLayout r9 = this.p;
        if (r9 != null) goto L38;
        Intrinsics.throwUninitializedPropertyAccessException("llDeleteMemory");
        r9 = null;
    L38:
        r9.setVisibility(0);
    L43:
        OButton r10 = this.n;
        if (r10 != null) goto L46;
        Intrinsics.throwUninitializedPropertyAccessException("confirmButton");
        r10 = null;
    L46:
        CharSequence r11 = (CharSequence) ZeusTransformUtils.preCheckCast(this.d, CharSequence.class, "com.obric.memorydata.plugin");
        if (r11 != null) goto L49;
    L50:
        r3 = true;
    L51:
        r10.setEnabled(!r3);
        OInputLayout r12 = this.l;
        if (r12 != null) goto L54;
        Intrinsics.throwUninitializedPropertyAccessException("inputView");
        r12 = null;
    L54:
        r12.postDelayed(new $$Lambda$d$lo_XaDLPYSscYGMRefKJEYYRwW8(this), 200);
        OButton r13 = this.m;
        if (r13 != null) goto L57;
        Intrinsics.throwUninitializedPropertyAccessException("cancelButton");
        r13 = null;
    L57:
        r13.setOnClickListener(new $$Lambda$d$wBGc_mun5cPIKAdRXAHhJHVZCk(this));
        OInputLayout r14 = this.l;
        if (r14 != null) goto L60;
        Intrinsics.throwUninitializedPropertyAccessException("inputView");
        r14 = null;
    L60:
        r14.getVInput().addTextChangedListener((TextWatcher) ZeusTransformUtils.preCheckCast(new b(this), TextWatcher.class, "com.obric.memorydata.plugin"));
        OButton r15 = this.n;
        if (r15 != null) goto L63;
        Intrinsics.throwUninitializedPropertyAccessException("confirmButton");
    L64:
        r5.setOnClickListener(new $$Lambda$d$hzHLrJ1TJr1_OQMvIzo9j5bdMck(this));
        return;
    L63:
        r5 = r15;
        goto L64
    L49:
        if (r11.length() != 0) goto L51;
    L39:
        LinearLayout r16 = this.p;
        if (r16 != null) goto L42;
        Intrinsics.throwUninitializedPropertyAccessException("llDeleteMemory");
        r16 = null;
    L42:
        r16.setVisibility(8);
        goto L43
    L20:
        c().extractExclusionRules(this.d);
        goto L31
    L14:
        if (r6.length() == 0) goto L17;
        r7 = false;
        goto L18
    L21:
        String r17 = this.d;
        if (r17 == null) goto L31;
        String r18 = StringsKt.take(r17, 100);
        OInputLayout r19 = this.l;
        if (r19 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("inputView");
        r19 = null;
    L26:
        r19.setText((CharSequence) ZeusTransformUtils.preCheckCast(r18, CharSequence.class, "com.obric.memorydata.plugin"));
        OInputLayout r20 = this.l;
        if (r20 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("inputView");
        r20 = null;
    L29:
        r20.getVInput().setSelection(r18.length());
        goto L31
    L5:
        if (r2.length() == 0) goto L8;
        r4 = false;
        goto L9
    }

    public final void a() {
        com.obric.oui.dialog.v2.alert.a r0 = this.k;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("dialog");
        r0 = null;
    L5:
        r0.show();
        f();
    }

    public final void b() {
        l();
        com.obric.oui.dialog.v2.alert.a r0 = this.k;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("dialog");
        r0 = null;
    L5:
        r0.dismiss();
    }
}
