package com.obric.aiproactive.ui.preference;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.IBinder;
import android.provider.Settings;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.WindowInsetsControllerCompat;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.google.android.material.card.MaterialCardView;
import com.obric.aiproactive.api.AiRuleItemDto;
import com.obric.aiproactive.api.IProactiveService;
import com.obric.aiproactive.ui.entry.BaseProactiveActivity;
import com.obric.aiproactive.ui.util.AiProactiveUiModeController;
import com.obric.capabilitykit.entity.memory.MemorySourceLinkType;
import com.obric.memorydata.plugin.R;
import com.obric.oui.button.OButton;
import com.obric.oui.forms.OEditText;
import com.obric.oui.forms.OInputLayout;
import com.obric.oui.orecyclerview.widget.LinearLayoutManager;
import com.obric.oui.orecyclerview.widget.RecyclerView;
import com.obric.oui.popover.menu.OPopoverEntranceMenuView;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.al;
import kotlinx.coroutines.ba;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000®\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\u0018\u0000 X2\u00020\u0001:\u0001XB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u001e\u001a\u00020\u001fH\u0014J\b\u0010 \u001a\u00020\u001fH\u0014J\u0012\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010$H\u0014J\u0010\u0010%\u001a\u00020\"2\u0006\u0010&\u001a\u00020'H\u0014J\b\u0010(\u001a\u00020\"H\u0014J\b\u0010)\u001a\u00020\"H\u0016J\b\u0010*\u001a\u00020\"H\u0002J\b\u0010+\u001a\u00020\"H\u0002J\b\u0010,\u001a\u00020\"H\u0002J\u0012\u0010-\u001a\u00020\"2\b\u0010.\u001a\u0004\u0018\u00010'H\u0002J\u0018\u0010/\u001a\u00020\"2\u0006\u00100\u001a\u00020\u00072\u0006\u00101\u001a\u00020\u001dH\u0002J\b\u00102\u001a\u00020\"H\u0002J\u0010\u00103\u001a\u00020\"2\u0006\u00101\u001a\u00020\u001dH\u0002J\u0018\u00104\u001a\u00020\"2\u0006\u00105\u001a\u0002062\u0006\u00107\u001a\u000208H\u0002J\u0018\u00109\u001a\u00020\"2\u0006\u00105\u001a\u0002062\u0006\u00107\u001a\u000208H\u0002J\u0018\u0010:\u001a\u00020\"2\u0006\u00105\u001a\u0002062\u0006\u00107\u001a\u000208H\u0002J8\u0010;\u001a\u00020\"2\u0006\u00105\u001a\u0002062\u0006\u00107\u001a\u0002082\f\u0010<\u001a\b\u0012\u0004\u0012\u00020>0=2\u0010\b\u0002\u0010?\u001a\n\u0012\u0004\u0012\u00020\"\u0018\u00010@H\u0002J:\u0010A\u001a\u00020\"2\u0006\u00107\u001a\u0002082\b\u0010B\u001a\u0004\u0018\u00010C2\b\u0010D\u001a\u0004\u0018\u00010E2\n\b\u0002\u0010F\u001a\u0004\u0018\u00010\u00102\b\b\u0002\u0010G\u001a\u00020\u001fH\u0002J\u0012\u0010H\u001a\u00020\"2\b\u0010I\u001a\u0004\u0018\u00010JH\u0002J\u001a\u0010K\u001a\u00020\"2\b\u0010I\u001a\u0004\u0018\u00010J2\u0006\u00107\u001a\u000208H\u0002J\u001a\u0010L\u001a\u00020\"2\b\u0010I\u001a\u0004\u0018\u00010J2\u0006\u00107\u001a\u000208H\u0002J*\u0010M\u001a\u00020\"2\u0006\u00105\u001a\u0002062\u0006\u00107\u001a\u0002082\u0010\b\u0002\u0010N\u001a\n\u0012\u0004\u0012\u00020\"\u0018\u00010@H\u0002J\u0010\u0010O\u001a\u00020\"2\u0006\u00107\u001a\u000208H\u0002J\u0010\u0010P\u001a\u00020\"2\u0006\u00107\u001a\u000208H\u0002J\u0010\u0010Q\u001a\u00020\"2\u0006\u00101\u001a\u00020\u001dH\u0002J\u0012\u0010R\u001a\u00020\"2\b\u0010S\u001a\u0004\u0018\u00010\u0007H\u0002J\b\u0010T\u001a\u00020UH\u0002J\u000e\u0010V\u001a\u0004\u0018\u00010\u0010*\u00020WH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R#\u0010\u0014\u001a\n \u0016*\u0004\u0018\u00010\u00150\u00158BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006Y"}, d2 = {"Lcom/obric/aiproactive/ui/preference/AiRuleActivity;", "Lcom/obric/aiproactive/ui/entry/BaseProactiveActivity;", "<init>", "()V", "rvRules", "Lcom/obric/oui/orecyclerview/widget/RecyclerView;", "emptyLayout", "Landroid/view/View;", "emptyGuidedEntryCard", "guidedPreferenceInterviewStore", "Lcom/obric/aiproactive/ui/preference/GuidedPreferenceInterviewStore;", "adapter", "Lcom/obric/aiproactive/ui/preference/AiRuleAdapter;", "actionPopover", "Lcom/obric/oui/popover/v2/OPopover;", "latestAssistantUpdatedText", "", "pendingRuleEditorKeyboardRetry", "Ljava/lang/Runnable;", "pendingRuleEditorDismiss", "proactiveService", "Lcom/obric/aiproactive/api/IProactiveService;", "kotlin.jvm.PlatformType", "getProactiveService", "()Lcom/obric/aiproactive/api/IProactiveService;", "proactiveService$delegate", "Lkotlin/Lazy;", "allRules", "", "Lcom/obric/aiproactive/api/AiRuleItemDto;", "needLoginCheckOnCreate", "", "needLoginCheckOnResume", "onCreateChecked", "", "savedInstanceState", "Landroid/os/Bundle;", "onNewIntent", MemorySourceLinkType.INTENT, "Landroid/content/Intent;", "onResumeChecked", "finish", "loadData", "renderContent", "openGuidedPreferenceInterview", "reportPreferenceEnterPage", "sourceIntent", "showRuleActionPopup", "anchorView", "rule", "showAddDialog", "showEditDialog", "bindRuleEditorOutsideCloseBehavior", "dialog", "Lcom/obric/oui/dialog/v2/alert/OAlertDialog;", "inputLayout", "Lcom/obric/oui/forms/OInputLayout;", "handleRuleEditorOutsideClose", "handleRuleEditorCancelClick", "performRuleEditorCloseActions", "actions", "", "Lcom/obric/aiproactive/ui/preference/RuleEditorOutsideAction;", "onReloadAfterDismiss", "Lkotlin/Function0;", "bindRuleInputBehavior", "overLimitWarning", "Landroid/widget/TextView;", "btnConfirm", "Lcom/obric/oui/button/OButton;", "initialContent", "requireContentChanged", "prepareRuleEditorIme", "window", "Landroid/view/Window;", "showKeyboard", "hideRuleEditorKeyboardByBack", "delayRuleEditorDismiss", "onDismissed", "cancelPendingRuleEditorKeyboardRetry", "cancelPendingRuleEditorDismiss", "deleteRule", "disableClipFromButtonAncestors", "button", "resolveThreeButtonNavigationBarHeight", "", "toHeaderText", "", "Companion", "ai_proactive_ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class AiRuleActivity extends BaseProactiveActivity {
    public static final a Companion = null;
    private static final long RULE_EDITOR_DISMISS_DELAY_MS = 220;
    private static final long RULE_EDITOR_KEYBOARD_RETRY_DELAY_MS = 50;
    private static final int RULE_INPUT_HARD_LIMIT = 200;
    private static final int RULE_MAX_LENGTH = 100;
    private static final int THREE_BUTTON_NAVIGATION_MODE = 0;
    private com.obric.oui.popover.v2.a actionPopover;
    private com.obric.aiproactive.ui.preference.b adapter;
    private List<AiRuleItemDto> allRules;
    private View emptyGuidedEntryCard;
    private View emptyLayout;
    private k guidedPreferenceInterviewStore;
    private String latestAssistantUpdatedText;
    private Runnable pendingRuleEditorDismiss;
    private Runnable pendingRuleEditorKeyboardRetry;
    private final Lazy proactiveService$delegate;
    private RecyclerView rvRules;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/obric/aiproactive/ui/preference/AiRuleActivity$Companion;", "", "<init>", "()V", "RULE_MAX_LENGTH", "", "RULE_INPUT_HARD_LIMIT", "RULE_EDITOR_KEYBOARD_RETRY_DELAY_MS", "", "RULE_EDITOR_DISMISS_DELAY_MS", "THREE_BUTTON_NAVIGATION_MODE", "ai_proactive_ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f6752a = null;

        static {
            int[] r0 = new int[RuleEditorOutsideAction.values().length];
            r0[RuleEditorOutsideAction.HideIme.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[RuleEditorOutsideAction.DelayDismiss.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[RuleEditorOutsideAction.ReloadDataAfterDismiss.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f6752a = r0;
        }
    }

    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J*\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0016J*\u0010\n\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0012\u0010\f\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\rH\u0016¨\u0006\u000e"}, d2 = {"com/obric/aiproactive/ui/preference/AiRuleActivity$bindRuleInputBehavior$2", "Landroid/text/TextWatcher;", "beforeTextChanged", "", "s", "", CommonConsts.APM_INNER_EVENT_COST_START, "", CommonConsts.COUNT_TYPE, "after", "onTextChanged", "before", "afterTextChanged", "Landroid/text/Editable;", "ai_proactive_ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class c implements TextWatcher {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function0<Unit> f6753a;

        c(Function0<Unit> r3) {
            this.f6753a = (Function0) ZeusTransformUtils.wrapperContextForParams(r3, Function0.class, "com.obric.memorydata.plugin");
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable r2) {
            Editable r1 = (Editable) ZeusTransformUtils.wrapperContextForParams(r2, Editable.class, "com.obric.memorydata.plugin");
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence r1, int r2, int r3, int r4) {
            CharSequence r0 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r1, CharSequence.class, "com.obric.memorydata.plugin");
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence r1, int r2, int r3, int r4) {
            CharSequence r5 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r1, CharSequence.class, "com.obric.memorydata.plugin");
            this.f6753a.invoke();
        }
    }

    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0003H\u0016¨\u0006\f"}, d2 = {"com/obric/aiproactive/ui/preference/AiRuleActivity$onCreateChecked$8", "Lcom/obric/oui/orecyclerview/widget/RecyclerView$OnItemTouchListener;", "onInterceptTouchEvent", "", "rv", "Lcom/obric/oui/orecyclerview/widget/RecyclerView;", "event", "Landroid/view/MotionEvent;", "onTouchEvent", "", "onRequestDisallowInterceptTouchEvent", "disallowIntercept", "ai_proactive_ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class d implements RecyclerView.l {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.obric.aiproactive.ui.util.q f6754a;

        d(com.obric.aiproactive.ui.util.q r1) {
            this.f6754a = r1;
        }

        @Override // com.obric.oui.orecyclerview.widget.RecyclerView.l
        public void a(boolean r1) {
        }

        @Override // com.obric.oui.orecyclerview.widget.RecyclerView.l
        public boolean a(RecyclerView r2, MotionEvent r3) {
            Intrinsics.checkNotNullParameter(r2, "rv");
            Intrinsics.checkNotNullParameter(r3, "event");
            int r4 = r3.getActionMasked();
            if (r4 != 0) goto L5;
            this.f6754a.a();
            return false;
        L5:
            if (r4 != 1) goto L7;
        L9:
            this.f6754a.c();
            return false;
        L7:
            if (r4 == 3) goto L9;
            return false;
        }

        @Override // com.obric.oui.orecyclerview.widget.RecyclerView.l
        public void b(RecyclerView r1, MotionEvent r2) {
            Intrinsics.checkNotNullParameter(r1, "rv");
            Intrinsics.checkNotNullParameter(r2, "event");
        }
    }

    /* JADX INFO: renamed from: com.obric.aiproactive.ui.preference.AiRuleActivity$deleteRule$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.aiproactive.ui.preference.AiRuleActivity$deleteRule$1", f = "AiRuleActivity.kt", i = {}, l = {581}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
        final /* synthetic */ AiRuleItemDto $rule;
        int label;
        final /* synthetic */ AiRuleActivity this$0;

        /* JADX INFO: renamed from: com.obric.aiproactive.ui.preference.AiRuleActivity$deleteRule$1$1, reason: invalid class name and collision with other inner class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
        @DebugMetadata(c = "com.obric.aiproactive.ui.preference.AiRuleActivity$deleteRule$1$1", f = "AiRuleActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class C03061 extends SuspendLambda implements Function2<al, Continuation<? super Boolean>, Object> {
            final /* synthetic */ AiRuleItemDto $rule;
            int label;
            final /* synthetic */ AiRuleActivity this$0;

            C03061(AiRuleActivity r3, AiRuleItemDto r4, Continuation<? super C03061> r5) {
                AiRuleActivity r6 = (AiRuleActivity) ZeusTransformUtils.wrapperContextForParams(r3, AiRuleActivity.class, "com.obric.memorydata.plugin");
                Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
                this.this$0 = r6;
                this.$rule = r4;
                super(2, r7);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
                Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
                return (Continuation) ZeusTransformUtils.preCheckCast(new C03061(this.this$0, this.$rule, r5), Continuation.class, "com.obric.memorydata.plugin");
            }

            @Override // kotlin.jvm.functions.Function2
            public /* synthetic */ Object invoke(al r3, Continuation<? super Boolean> r4) {
                return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Object invoke2(al r3, Continuation<? super Boolean> r4) {
                return ((C03061) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), C03061.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object r2) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) goto L10;
                ResultKt.throwOnFailure(r2);
                IProactiveService r3 = AiRuleActivity.access$getProactiveService(this.this$0);
                if (r3 != null) goto L11;
                return null;
            L11:
                return Boxing.boxBoolean(r3.deleteAiRule(this.$rule.getId()));
            L10:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        AnonymousClass1(AiRuleActivity r3, AiRuleItemDto r4, Continuation<? super AnonymousClass1> r5) {
            AiRuleActivity r6 = (AiRuleActivity) ZeusTransformUtils.wrapperContextForParams(r3, AiRuleActivity.class, "com.obric.memorydata.plugin");
            Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r6;
            this.$rule = r4;
            super(2, r7);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.this$0, this.$rule, r5), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
            return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(al r3, Continuation<? super Unit> r4) {
            return ((AnonymousClass1) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), AnonymousClass1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r8) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r8);
        L11:
            AiRuleActivity.access$loadData(this.this$0);
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r8);
            CoroutineContext r9 = (CoroutineContext) ZeusTransformUtils.preCheckCast(ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin");
            Function2 r2 = (Function2) ZeusTransformUtils.preCheckCast(new C03061(this.this$0, this.$rule, null), Function2.class, "com.obric.memorydata.plugin");
            Continuation r3 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 1;
            if (kotlinx.coroutines.i.a(r9, r2, r3) != r0) goto L11;
            return r0;
        }
    }

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J \u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0007H\u0016¨\u0006\u000b"}, d2 = {"com/obric/aiproactive/ui/preference/AiRuleActivity$onCreateChecked$9", "Lcom/obric/oui/orecyclerview/widget/RecyclerView$OnScrollListener;", "onScrollStateChanged", "", "recyclerView", "Lcom/obric/oui/orecyclerview/widget/RecyclerView;", "newState", "", "onScrolled", "dx", "dy", "ai_proactive_ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class e extends RecyclerView.m {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.obric.aiproactive.ui.util.q f6755a;

        e(com.obric.aiproactive.ui.util.q r1) {
            this.f6755a = r1;
        }

        @Override // com.obric.oui.orecyclerview.widget.RecyclerView.m
        public void a(RecyclerView r2, int r3) {
            Intrinsics.checkNotNullParameter(r2, "recyclerView");
            if (r3 == 0) goto L6;
            return;
        L6:
            if (this.f6755a.d() == true) goto L8;
            return;
        L8:
            com.obric.aiproactive.ui.util.h.f6884a.b("preference");
        }

        @Override // com.obric.oui.orecyclerview.widget.RecyclerView.m
        public void a(RecyclerView r2, int r3, int r4) {
            Intrinsics.checkNotNullParameter(r2, "recyclerView");
            if (r3 != 0) goto L5;
            if (r4 != 0) goto L5;
            return;
        L5:
            this.f6755a.b();
        }
    }

    /* JADX INFO: renamed from: com.obric.aiproactive.ui.preference.AiRuleActivity$loadData$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.aiproactive.ui.preference.AiRuleActivity$loadData$1", f = "AiRuleActivity.kt", i = {}, l = {203}, m = "invokeSuspend", n = {}, s = {})
    static final class C10671 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ AiRuleActivity this$0;

        /* JADX INFO: renamed from: com.obric.aiproactive.ui.preference.AiRuleActivity$loadData$1$1, reason: invalid class name and collision with other inner class name */
        @Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\u0010\u0000\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0004\u0012\u00020\u00040\u0001*\u00020\u0005H\n"}, d2 = {"<anonymous>", "Lkotlin/Pair;", "", "Lcom/obric/aiproactive/api/AiRuleItemDto;", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
        @DebugMetadata(c = "com.obric.aiproactive.ui.preference.AiRuleActivity$loadData$1$1", f = "AiRuleActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class C03071 extends SuspendLambda implements Function2<al, Continuation<? super Pair<? extends List<? extends AiRuleItemDto>, ? extends Long>>, Object> {
            int label;
            final /* synthetic */ AiRuleActivity this$0;

            C03071(AiRuleActivity r3, Continuation<? super C03071> r4) {
                AiRuleActivity r5 = (AiRuleActivity) ZeusTransformUtils.wrapperContextForParams(r3, AiRuleActivity.class, "com.obric.memorydata.plugin");
                Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
                this.this$0 = r5;
                super(2, r6);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
                Continuation r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
                return (Continuation) ZeusTransformUtils.preCheckCast(new C03071(this.this$0, r4), Continuation.class, "com.obric.memorydata.plugin");
            }

            @Override // kotlin.jvm.functions.Function2
            public /* synthetic */ Object invoke(al r3, Continuation<? super Pair<? extends List<? extends AiRuleItemDto>, ? extends Long>> r4) {
                return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Object invoke2(al r3, Continuation<? super Pair<? extends List<AiRuleItemDto>, Long>> r4) {
                return ((C03071) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), C03071.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object r3) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) goto L20;
                ResultKt.throwOnFailure(r3);
                IProactiveService r4 = AiRuleActivity.access$getProactiveService(this.this$0);
                if (r4 == null) goto L7;
                Boxing.boxBoolean(r4.awaitAiProactiveDbReady(5000));
            L7:
                IProactiveService r5 = AiRuleActivity.access$getProactiveService(this.this$0);
                if (r5 == null) goto L10;
                List<AiRuleItemDto> r6 = r5.getAiRules();
            L11:
                if (r6 != null) goto L13;
                r6 = CollectionsKt.emptyList();
            L13:
                IProactiveService r2 = AiRuleActivity.access$getProactiveService(this.this$0);
                if (r2 == null) goto L16;
                long r0 = r2.getLatestAiRuleUpdateTimestamp();
            L18:
                return TuplesKt.to(r6, Boxing.boxLong(r0));
            L16:
                r0 = 0;
                goto L18
            L10:
                r6 = null;
                goto L11
            L20:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        C10671(AiRuleActivity r3, Continuation<? super C10671> r4) {
            AiRuleActivity r5 = (AiRuleActivity) ZeusTransformUtils.wrapperContextForParams(r3, AiRuleActivity.class, "com.obric.memorydata.plugin");
            Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r5;
            super(2, r6);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            Continuation r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new C10671(this.this$0, r4), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
            return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(al r3, Continuation<? super Unit> r4) {
            return ((C10671) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), C10671.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r7) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r7);
        L11:
            Pair r8 = (Pair) ZeusTransformUtils.preCheckCast(r7, Pair.class, "com.obric.memorydata.plugin");
            List r2 = (List) ZeusTransformUtils.preCheckCast(r8.component1(), List.class, "com.obric.memorydata.plugin");
            long r3 = ((Number) ZeusTransformUtils.preCheckCast(r8.component2(), Number.class, "com.obric.memorydata.plugin")).longValue();
            AiRuleActivity.access$getAllRules$p(this.this$0).clear();
            AiRuleActivity.access$getAllRules$p(this.this$0).addAll((Collection) ZeusTransformUtils.preCheckCast(r2, Collection.class, "com.obric.memorydata.plugin"));
            AiRuleActivity r9 = this.this$0;
            AiRuleActivity.access$setLatestAssistantUpdatedText$p(r9, AiRuleActivity.access$toHeaderText(r9, r3));
            AiRuleActivity.access$renderContent(this.this$0);
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r7);
            CoroutineContext r10 = (CoroutineContext) ZeusTransformUtils.preCheckCast(ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin");
            Function2 r4 = (Function2) ZeusTransformUtils.preCheckCast(new C03071(this.this$0, null), Function2.class, "com.obric.memorydata.plugin");
            Continuation r5 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 1;
            r7 = kotlinx.coroutines.i.a(r10, r4, r5);
            if (r7 != r0) goto L11;
            return r0;
        }
    }

    static {
        Companion = new a(null);
    }

    public AiRuleActivity() {
        this.proactiveService$delegate = LazyKt.lazy($$Lambda$AiRuleActivity$eKu4h4bHQ8RikBvf8YLfModJc8.INSTANCE);
        this.allRules = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
    }

    public static final /* synthetic */ List access$getAllRules$p(AiRuleActivity r2) {
        return ((AiRuleActivity) ZeusTransformUtils.wrapperContextForParams(r2, AiRuleActivity.class, "com.obric.memorydata.plugin")).allRules;
    }

    public static final /* synthetic */ IProactiveService access$getProactiveService(AiRuleActivity r2) {
        return ((AiRuleActivity) ZeusTransformUtils.wrapperContextForParams(r2, AiRuleActivity.class, "com.obric.memorydata.plugin")).getProactiveService();
    }

    public static final /* synthetic */ void access$loadData(AiRuleActivity r2) {
        ((AiRuleActivity) ZeusTransformUtils.wrapperContextForParams(r2, AiRuleActivity.class, "com.obric.memorydata.plugin")).loadData();
    }

    public static final /* synthetic */ void access$performRuleEditorCloseActions(AiRuleActivity r2, com.obric.oui.dialog.v2.alert.a r3, OInputLayout r4, List r5, Function0 r6) {
        ((AiRuleActivity) ZeusTransformUtils.wrapperContextForParams(r2, AiRuleActivity.class, "com.obric.memorydata.plugin")).performRuleEditorCloseActions(r3, r4, (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin"), (Function0) ZeusTransformUtils.wrapperContextForParams(r6, Function0.class, "com.obric.memorydata.plugin"));
    }

    public static final /* synthetic */ void access$renderContent(AiRuleActivity r2) {
        ((AiRuleActivity) ZeusTransformUtils.wrapperContextForParams(r2, AiRuleActivity.class, "com.obric.memorydata.plugin")).renderContent();
    }

    public static final /* synthetic */ void access$setLatestAssistantUpdatedText$p(AiRuleActivity r2, String r3) {
        ((AiRuleActivity) ZeusTransformUtils.wrapperContextForParams(r2, AiRuleActivity.class, "com.obric.memorydata.plugin")).latestAssistantUpdatedText = r3;
    }

    public static final /* synthetic */ String access$toHeaderText(AiRuleActivity r2, long r3) {
        return ((AiRuleActivity) ZeusTransformUtils.wrapperContextForParams(r2, AiRuleActivity.class, "com.obric.memorydata.plugin")).toHeaderText(r3);
    }

    private final void bindRuleEditorOutsideCloseBehavior(final com.obric.oui.dialog.v2.alert.a r3, final OInputLayout r4) {
        r3.setCanceledOnTouchOutside(false);
        if (ZeusTransformUtils.instanceOf(r3, r.class) == false) goto L5;
        r r0 = (r) ZeusTransformUtils.preCheckCast(r3, r.class, "com.obric.memorydata.plugin");
    L6:
        if (r0 == null) goto L8;
        r0.a(new $$Lambda$AiRuleActivity$yYRYh823Z0kEEiyaMS8ZGLjH0(this, r3, r4));
    L8:
        r3.setOnKeyListener(new $$Lambda$AiRuleActivity$hjJJTd5iHxh6xwZ1Zs_kidOS1CA(this, r3, r4));
        return;
    L5:
        r0 = null;
        goto L6
    }

    private static final Unit bindRuleEditorOutsideCloseBehavior$lambda$23(AiRuleActivity r2, com.obric.oui.dialog.v2.alert.a r3, OInputLayout r4) {
        ((AiRuleActivity) ZeusTransformUtils.wrapperContextForParams(r2, AiRuleActivity.class, "com.obric.memorydata.plugin")).handleRuleEditorOutsideClose(r3, r4);
        return Unit.INSTANCE;
    }

    private static final boolean bindRuleEditorOutsideCloseBehavior$lambda$24(AiRuleActivity r2, com.obric.oui.dialog.v2.alert.a r3, OInputLayout r4, DialogInterface r5, int r6, KeyEvent r7) {
        AiRuleActivity r8 = (AiRuleActivity) ZeusTransformUtils.wrapperContextForParams(r2, AiRuleActivity.class, "com.obric.memorydata.plugin");
        DialogInterface r9 = (DialogInterface) ZeusTransformUtils.wrapperContextForParams(r5, DialogInterface.class, "com.obric.memorydata.plugin");
        if (r6 == 4) goto L5;
    L7:
        return false;
    L5:
        if (r7.getAction() != 1) goto L7;
        r8.handleRuleEditorOutsideClose(r3, r4);
        return true;
    }

    private final void bindRuleInputBehavior(final OInputLayout r10, final TextView r11, final OButton r12, final String r13, final boolean r14) {
        r10.g(false);
        r10.setLimitCount(200);
        r10.setAutoChangeWithLimit(false);
        r10.setInputType(131073);
        r10.setMaxLines(Integer.MAX_VALUE);
        OEditText r3 = r10.getVInput();
        r3.setSingleLine(false);
        r3.setTextColor(ContextCompat.getColor((Context) ZeusTransformUtils.preCheckCast(this, Context.class, "com.obric.memorydata.plugin"), ZeusTransformUtils.mapRes(R.color.ai_proactive_demo_text_primary, TypedValues.Custom.S_COLOR, "ai_proactive_demo_text_primary")));
        r3.setHintTextColor(ContextCompat.getColor((Context) ZeusTransformUtils.preCheckCast(this, Context.class, "com.obric.memorydata.plugin"), ZeusTransformUtils.mapRes(R.color.ai_proactive_demo_text_tertiary, TypedValues.Custom.S_COLOR, "ai_proactive_demo_text_tertiary")));
        r3.setGravity(MaterialCardView.CHECKED_ICON_GRAVITY_TOP_START);
        r3.setTextAlignment(5);
        r3.setHorizontallyScrolling(false);
        r3.setFilters((InputFilter[]) ZeusTransformUtils.preCheckCast(new InputFilter.LengthFilter[]{new InputFilter.LengthFilter(200)}, InputFilter[].class, "com.obric.memorydata.plugin"));
        Function0 r7 = new $$Lambda$AiRuleActivity$ZxWyh7jjc8E1CvgJkRWHRolf9Oo(r10, r13, r14, r11, r12);
        r10.getVInput().addTextChangedListener((TextWatcher) ZeusTransformUtils.preCheckCast(new c(r7), TextWatcher.class, "com.obric.memorydata.plugin"));
        r7.invoke();
    }

    static /* synthetic */ void bindRuleInputBehavior$default(AiRuleActivity r6, OInputLayout r7, TextView r8, OButton r9, String r10, boolean r11, int r12, Object r13) {
        AiRuleActivity r0 = (AiRuleActivity) ZeusTransformUtils.wrapperContextForParams(r6, AiRuleActivity.class, "com.obric.memorydata.plugin");
        if ((r12 & 8) == 0) goto L5;
        r10 = null;
    L5:
        String r4 = r10;
        if ((r12 & 16) == 0) goto L8;
        r11 = false;
    L8:
        r0.bindRuleInputBehavior(r7, r8, r9, r4, r11);
    }

    private static final Unit bindRuleInputBehavior$lambda$27(OInputLayout r6, String r7, boolean r8, TextView r9, OButton r10) {
        String r11 = String.valueOf(r6.getText());
        String r0 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r11, CharSequence.class, "com.obric.memorydata.plugin")).toString();
        boolean r3 = true;
        if (r11.length() <= 100) goto L5;
        boolean r12 = true;
    L6:
        if (r7 == null) goto L8;
        String r13 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.memorydata.plugin")).toString();
    L9:
        boolean r14 = com.obric.aiproactive.ui.preference.a.a(r0, r13, r8, 100);
        if (r9 == null) goto L15;
        if (r12 == false) goto L13;
        int r15 = 0;
    L14:
        r9.setVisibility(r15);
        goto L15
    L13:
        r15 = 8;
    L15:
        if (r10 == null) goto L17;
        r10.setEnabled(r14);
    L17:
        if (r10 == null) goto L27;
        if (r10.isEnabled() == true) goto L22;
        r3 = false;
    L22:
        if (r3 == false) goto L24;
        float r16 = 1.0f;
    L25:
        r10.setAlpha(r16);
        goto L27
    L24:
        r16 = 0.4f;
    L27:
        return Unit.INSTANCE;
    L8:
        r13 = null;
        goto L9
    L5:
        r12 = false;
        goto L6
    }

    private final void cancelPendingRuleEditorDismiss(OInputLayout r2) {
        Runnable r0 = this.pendingRuleEditorDismiss;
        if (r0 == null) goto L5;
        r2.removeCallbacks(r0);
    L5:
        this.pendingRuleEditorDismiss = null;
    }

    private final void cancelPendingRuleEditorKeyboardRetry(OInputLayout r2) {
        Runnable r0 = this.pendingRuleEditorKeyboardRetry;
        if (r0 == null) goto L5;
        r2.getVInput().removeCallbacks(r0);
    L5:
        this.pendingRuleEditorKeyboardRetry = null;
    }

    private final void delayRuleEditorDismiss(final com.obric.oui.dialog.v2.alert.a r3, OInputLayout r4, Function0<Unit> r5) {
        final Function0 r6 = (Function0) ZeusTransformUtils.wrapperContextForParams(r5, Function0.class, "com.obric.memorydata.plugin");
        cancelPendingRuleEditorDismiss(r4);
        Runnable r0 = new $$Lambda$AiRuleActivity$D6M03izbOp4ZF8jZ0vj9L1ZDxI(this, r3, r6);
        this.pendingRuleEditorDismiss = r0;
        r4.postDelayed(r0, RULE_EDITOR_DISMISS_DELAY_MS);
    }

    static /* synthetic */ void delayRuleEditorDismiss$default(AiRuleActivity r1, com.obric.oui.dialog.v2.alert.a r2, OInputLayout r3, Function0 r4, int r5, Object r6) {
        AiRuleActivity r7 = (AiRuleActivity) ZeusTransformUtils.wrapperContextForParams(r1, AiRuleActivity.class, "com.obric.memorydata.plugin");
        Function0<Unit> r8 = (Function0) ZeusTransformUtils.wrapperContextForParams(r4, Function0.class, "com.obric.memorydata.plugin");
        if ((r5 & 4) == 0) goto L5;
        r8 = null;
    L5:
        r7.delayRuleEditorDismiss(r2, r3, r8);
    }

    private static final void delayRuleEditorDismiss$lambda$32(AiRuleActivity r2, com.obric.oui.dialog.v2.alert.a r3, Function0 r4) {
        AiRuleActivity r5 = (AiRuleActivity) ZeusTransformUtils.wrapperContextForParams(r2, AiRuleActivity.class, "com.obric.memorydata.plugin");
        Function0 r6 = (Function0) ZeusTransformUtils.wrapperContextForParams(r4, Function0.class, "com.obric.memorydata.plugin");
        r5.pendingRuleEditorDismiss = null;
        r3.dismiss();
        if (r6 == null) goto L6;
        r6.invoke();
        return;
    }

    private final void deleteRule(AiRuleItemDto r9) {
        kotlinx.coroutines.i.a((al) ZeusTransformUtils.preCheckCast(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) ZeusTransformUtils.preCheckCast(this, LifecycleOwner.class, "com.obric.memorydata.plugin")), al.class, "com.obric.memorydata.plugin"), null, null, (Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this, r9, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
    }

    private final void disableClipFromButtonAncestors(View r3) {
        if (r3 == null) goto L4;
        ViewParent r2 = r3.getParent();
    L6:
        if (ZeusTransformUtils.instanceOf(r2, ViewGroup.class) == false) goto L8;
        ((ViewGroup) ZeusTransformUtils.preCheckCast(r2, ViewGroup.class, "com.obric.memorydata.plugin")).setClipChildren(false);
        ((ViewGroup) ZeusTransformUtils.preCheckCast(r2, ViewGroup.class, "com.obric.memorydata.plugin")).setClipToPadding(false);
        r2 = ((ViewGroup) ZeusTransformUtils.preCheckCast(r2, ViewGroup.class, "com.obric.memorydata.plugin")).getParent();
        goto L6
    L8:
        return;
    L4:
        r2 = null;
        goto L6
    }

    private final IProactiveService getProactiveService() {
        return (IProactiveService) ZeusTransformUtils.preCheckCast(this.proactiveService$delegate.getValue(), IProactiveService.class, "com.obric.memorydata.plugin");
    }

    private final void handleRuleEditorCancelClick(com.obric.oui.dialog.v2.alert.a r8, OInputLayout r9) {
        performRuleEditorCloseActions$default(this, r8, r9, com.obric.aiproactive.ui.preference.a.a(), null, 8, null);
    }

    private final void handleRuleEditorOutsideClose(com.obric.oui.dialog.v2.alert.a r9, OInputLayout r10) {
        performRuleEditorCloseActions$default(this, r9, r10, com.obric.aiproactive.ui.preference.a.a(String.valueOf(r10.getText())), null, 8, null);
    }

    private final void hideRuleEditorKeyboardByBack(Window r6, OInputLayout r7) {
        cancelPendingRuleEditorKeyboardRetry(r7);
        r7.getVInput().dispatchKeyEvent(new KeyEvent(0, 4));
        r7.getVInput().dispatchKeyEvent(new KeyEvent(1, 4));
        Object r5 = getSystemService("input_method");
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        InputMethodManager r8 = (InputMethodManager) ZeusTransformUtils.preCheckCast(r5, InputMethodManager.class, "com.obric.memorydata.plugin");
        IBinder r0 = r7.getVInput().getWindowToken();
        if (r0 != null) goto L5;
        r0 = r7.getWindowToken();
    L5:
        r8.hideSoftInputFromWindow(r0, 0);
        if (r6 == null) goto L11;
        WindowInsetsControllerCompat r9 = WindowCompat.getInsetsController(r6, (View) ZeusTransformUtils.preCheckCast(r7.getVInput(), View.class, "com.obric.memorydata.plugin"));
        if (r9 == null) goto L12;
        r9.hide(WindowInsetsCompat.Type.ime());
        return;
    L12:
        return;
    }

    public static /* synthetic */ void lambda$3jdUYZYUNmMSfJRLO899xFlA1IQ(AiRuleActivity r0, View r1) {
        onCreateChecked$lambda$3(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$8KIcAN57NZ81hXL-P9sIPRMMi_M, reason: not valid java name */
    public static /* synthetic */ Unit m313lambda$8KIcAN57NZ81hXLP9sIPRMMi_M(AiRuleActivity r0, AiRuleItemDto r1, View r2, int r3) {
        return showRuleActionPopup$lambda$14(r0, r1, r2, r3);
    }

    /* JADX INFO: renamed from: lambda$CUz9b4sdjciK-wcoNHZx7MMcowg, reason: not valid java name */
    public static /* synthetic */ void m314lambda$CUz9b4sdjciKwcoNHZx7MMcowg(OInputLayout r0, AiRuleActivity r1, com.obric.oui.dialog.v2.alert.a r2, View r3) {
        showAddDialog$lambda$18(r0, r1, r2, r3);
    }

    /* JADX INFO: renamed from: lambda$D6M-03izbOp4ZF8jZ0vj9L1ZDxI, reason: not valid java name */
    public static /* synthetic */ void m315lambda$D6M03izbOp4ZF8jZ0vj9L1ZDxI(AiRuleActivity r0, com.obric.oui.dialog.v2.alert.a r1, Function0 r2) {
        delayRuleEditorDismiss$lambda$32(r0, r1, r2);
    }

    public static /* synthetic */ Unit lambda$DbT38gIHAlVTWTweaJk7SWe3IW8(AiRuleActivity r0, View r1, AiRuleItemDto r2) {
        return onCreateChecked$lambda$11(r0, r1, r2);
    }

    public static /* synthetic */ void lambda$FgxAHm6YMngfhQQEmgsc84ZS8nM(AiRuleActivity r0, View r1) {
        onCreateChecked$lambda$4(r0, r1);
    }

    public static /* synthetic */ void lambda$JPAFcJpEErzJHvBBkC8ys04CpNY(AiRuleActivity r0, InputMethodManager r1, OInputLayout r2) {
        showKeyboard$lambda$30$lambda$29(r0, r1, r2);
    }

    /* JADX INFO: renamed from: lambda$PGNHKCXoFm-JXkBTlOM8x_OalDk, reason: not valid java name */
    public static /* synthetic */ Unit m316lambda$PGNHKCXoFmJXkBTlOM8x_OalDk(AiRuleActivity r0, com.obric.oui.dialog.v2.alert.style.d r1) {
        return showEditDialog$lambda$19(r0, r1);
    }

    public static /* synthetic */ Unit lambda$PlQsXeN1D8Fqv9moAycqKcjPf9w(AiRuleActivity r0, AiRuleItemDto r1, View r2, int r3) {
        return showRuleActionPopup$lambda$13(r0, r1, r2, r3);
    }

    /* JADX INFO: renamed from: lambda$UN9HSLH-Cl1f2Dk9T5OSicnJm8U, reason: not valid java name */
    public static /* synthetic */ WindowInsetsCompat m317lambda$UN9HSLHCl1f2Dk9T5OSicnJm8U(AiRuleActivity r0, View r1, View r2, View r3, View r4, View r5, int r6, View r7, WindowInsetsCompat r8) {
        return onCreateChecked$lambda$10(r0, r1, r2, r3, r4, r5, r6, r7, r8);
    }

    public static /* synthetic */ Unit lambda$WQUxU60fcpwOlaegqcnA3YbUiuE(AiRuleActivity r0, com.obric.oui.dialog.v2.alert.style.d r1) {
        return showAddDialog$lambda$16(r0, r1);
    }

    public static /* synthetic */ void lambda$Y8IZKx1MUyQE5vKukOxuq2xClTk(AiRuleActivity r0, View r1) {
        onCreateChecked$lambda$2(r0, r1);
    }

    public static /* synthetic */ Unit lambda$ZxWyh7jjc8E1CvgJkRWHRolf9Oo(OInputLayout r0, String r1, boolean r2, TextView r3, OButton r4) {
        return bindRuleInputBehavior$lambda$27(r0, r1, r2, r3, r4);
    }

    /* JADX INFO: renamed from: lambda$btF3Ko-FjYh1WJNi50fcz-fE-Ow, reason: not valid java name */
    public static /* synthetic */ void m318lambda$btF3KoFjYh1WJNi50fczfEOw(OInputLayout r0, AiRuleActivity r1, Window r2) {
        showKeyboard$lambda$30(r0, r1, r2);
    }

    /* JADX INFO: renamed from: lambda$eKu4h4bHQ8RikBvf8YLfModJc-8, reason: not valid java name */
    public static /* synthetic */ IProactiveService m319lambda$eKu4h4bHQ8RikBvf8YLfModJc8() {
        return proactiveService_delegate$lambda$0();
    }

    public static /* synthetic */ boolean lambda$hjJJTd5iHxh6xwZ1Zs_kidOS1CA(AiRuleActivity r0, com.obric.oui.dialog.v2.alert.a r1, OInputLayout r2, DialogInterface r3, int r4, KeyEvent r5) {
        return bindRuleEditorOutsideCloseBehavior$lambda$24(r0, r1, r2, r3, r4, r5);
    }

    public static /* synthetic */ Unit lambda$kOJ3wv3jlPv1iGaF2h9WXNh2P8M(AiRuleActivity r0) {
        return onCreateChecked$lambda$12(r0);
    }

    public static /* synthetic */ void lambda$tvWC9Wute_z73qnLyGbZ106h_Uo(OInputLayout r0, AiRuleActivity r1, com.obric.oui.dialog.v2.alert.a r2, AiRuleItemDto r3, boolean r4, View r5) {
        showEditDialog$lambda$22(r0, r1, r2, r3, r4, r5);
    }

    /* JADX INFO: renamed from: lambda$yYRYh8-23-Z0kEEiyaMS8ZGLjH0, reason: not valid java name */
    public static /* synthetic */ Unit m320lambda$yYRYh823Z0kEEiyaMS8ZGLjH0(AiRuleActivity r0, com.obric.oui.dialog.v2.alert.a r1, OInputLayout r2) {
        return bindRuleEditorOutsideCloseBehavior$lambda$23(r0, r1, r2);
    }

    /* JADX INFO: renamed from: lambda$ygFtu7hjiFkdL2M1vj9PnCf2-Ls, reason: not valid java name */
    public static /* synthetic */ void m321lambda$ygFtu7hjiFkdL2M1vj9PnCf2Ls(AiRuleActivity r0, com.obric.oui.dialog.v2.alert.a r1, OInputLayout r2, View r3) {
        showEditDialog$lambda$21(r0, r1, r2, r3);
    }

    public static /* synthetic */ void lambda$zFWnPdOoF6yBzBy7CqmmB1qREyw(AiRuleActivity r0, com.obric.oui.dialog.v2.alert.a r1, OInputLayout r2, View r3) {
        showAddDialog$lambda$17(r0, r1, r2, r3);
    }

    private final void loadData() {
        kotlinx.coroutines.i.a((al) ZeusTransformUtils.preCheckCast(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) ZeusTransformUtils.preCheckCast(this, LifecycleOwner.class, "com.obric.memorydata.plugin")), al.class, "com.obric.memorydata.plugin"), null, null, (Function2) ZeusTransformUtils.preCheckCast(new C10671(this, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
    }

    private static final WindowInsetsCompat onCreateChecked$lambda$10(AiRuleActivity r5, View r6, View r7, View r8, View r9, View r10, int r11, View r12, WindowInsetsCompat r13) {
        AiRuleActivity r14 = (AiRuleActivity) ZeusTransformUtils.wrapperContextForParams(r5, AiRuleActivity.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r12, "<unused var>");
        Intrinsics.checkNotNullParameter(r13, "insets");
        int r15 = r13.getInsets(WindowInsetsCompat.Type.statusBars()).top;
        int r0 = com.obric.aiproactive.ui.preference.a.a(r13.getInsets(WindowInsetsCompat.Type.navigationBars()).bottom, r13.getInsets(WindowInsetsCompat.Type.tappableElement()).bottom, r13.getInsets(WindowInsetsCompat.Type.systemBars()).bottom, r14.resolveThreeButtonNavigationBarHeight());
        int r2 = ((int) com.obric.oui.common.util.h.a(64.0f)) + r15;
        ViewGroup.LayoutParams r3 = r6.getLayoutParams();
        r3.height = r2;
        r6.setLayoutParams(r3);
        ViewGroup.LayoutParams r16 = r7.getLayoutParams();
        r16.height = r2;
        r7.setLayoutParams(r16);
        ViewGroup.LayoutParams r17 = r8.getLayoutParams();
        Intrinsics.checkNotNull(r17, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams r18 = (ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r17, ViewGroup.MarginLayoutParams.class, "com.obric.memorydata.plugin");
        r18.topMargin = ((int) com.obric.oui.common.util.h.a(12.0f)) + r15;
        r8.setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r18, ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin"));
        ViewGroup.LayoutParams r19 = r9.getLayoutParams();
        Intrinsics.checkNotNull(r19, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams r20 = (ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r19, ViewGroup.MarginLayoutParams.class, "com.obric.memorydata.plugin");
        r20.topMargin = r15 + ((int) com.obric.oui.common.util.h.a(12.0f));
        r9.setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r20, ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin"));
        int r21 = com.obric.aiproactive.ui.preference.a.a(r0);
        if (r10.getLayoutParams().height == r21) goto L5;
        ViewGroup.LayoutParams r22 = r10.getLayoutParams();
        r22.height = r21;
        r10.setLayoutParams(r22);
    L5:
        RecyclerView r23 = r14.rvRules;
        RecyclerView r24 = null;
        if (r23 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("rvRules");
        r23 = null;
    L8:
        RecyclerView r25 = r14.rvRules;
        if (r25 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("rvRules");
        r25 = null;
    L11:
        int r26 = r25.getPaddingLeft();
        RecyclerView r27 = r14.rvRules;
        if (r27 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("rvRules");
    L15:
        r23.setPadding(r26, r2, r24.getPaddingRight(), r11);
        return r13;
    L14:
        r24 = r27;
        goto L15
    }

    private static final Unit onCreateChecked$lambda$11(AiRuleActivity r2, View r3, AiRuleItemDto r4) {
        AiRuleActivity r5 = (AiRuleActivity) ZeusTransformUtils.wrapperContextForParams(r2, AiRuleActivity.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "view");
        Intrinsics.checkNotNullParameter(r4, "rule");
        r5.showRuleActionPopup(r3, r4);
        return Unit.INSTANCE;
    }

    private static final Unit onCreateChecked$lambda$12(AiRuleActivity r2) {
        ((AiRuleActivity) ZeusTransformUtils.wrapperContextForParams(r2, AiRuleActivity.class, "com.obric.memorydata.plugin")).openGuidedPreferenceInterview();
        return Unit.INSTANCE;
    }

    private static final void onCreateChecked$lambda$2(AiRuleActivity r1, View r2) {
        ((AiRuleActivity) ZeusTransformUtils.wrapperContextForParams(r1, AiRuleActivity.class, "com.obric.memorydata.plugin")).finish();
    }

    private static final void onCreateChecked$lambda$3(AiRuleActivity r1, View r2) {
        ((AiRuleActivity) ZeusTransformUtils.wrapperContextForParams(r1, AiRuleActivity.class, "com.obric.memorydata.plugin")).showAddDialog();
    }

    private static final void onCreateChecked$lambda$4(AiRuleActivity r1, View r2) {
        ((AiRuleActivity) ZeusTransformUtils.wrapperContextForParams(r1, AiRuleActivity.class, "com.obric.memorydata.plugin")).openGuidedPreferenceInterview();
    }

    private final void openGuidedPreferenceInterview() {
        com.obric.aiproactive.ui.util.h.f6884a.b("preference", "unlock_screen", "enter_interview");
        h r0 = h.f6772a;
        Context r1 = (Context) ZeusTransformUtils.preCheckCast(this, Context.class, "com.obric.memorydata.plugin");
        Intent r2 = getIntent();
        if (r2 == null) goto L5;
        String r3 = r2.getStringExtra("enter_from");
    L7:
        if (r0.a(r1, "preference_page", com.obric.aiproactive.ui.util.n.a(r3)) == false) goto L10;
        renderContent();
        return;
    L10:
        return;
    L5:
        r3 = null;
        goto L7
    }

    private final void performRuleEditorCloseActions(com.obric.oui.dialog.v2.alert.a r4, OInputLayout r5, List<? extends RuleEditorOutsideAction> r6, Function0<Unit> r7) {
        List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
        Function0<Unit> r9 = (Function0) ZeusTransformUtils.wrapperContextForParams(r7, Function0.class, "com.obric.memorydata.plugin");
        if (r8.contains(RuleEditorOutsideAction.ReloadDataAfterDismiss) == true) goto L6;
        r9 = null;
    L6:
        Iterator r10 = ((Iterable) ZeusTransformUtils.preCheckCast(r8, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L8:
        if (r10.hasNext() == false) goto L20;
        RuleEditorOutsideAction r0 = (RuleEditorOutsideAction) ZeusTransformUtils.preCheckCast(r10.next(), RuleEditorOutsideAction.class, "com.obric.memorydata.plugin");
        int r1 = b.f6752a[r0.ordinal()];
        if (r1 != 1) goto L12;
        hideRuleEditorKeyboardByBack(r4.getWindow(), r5);
        goto L8
    L12:
        if (r1 != 2) goto L14;
        delayRuleEditorDismiss(r4, r5, r9);
        goto L8
    L14:
        if (r1 == 3) goto L8;
        throw new NoWhenBranchMatchedException();
    }

    static /* synthetic */ void performRuleEditorCloseActions$default(AiRuleActivity r1, com.obric.oui.dialog.v2.alert.a r2, OInputLayout r3, List r4, Function0 r5, int r6, Object r7) {
        AiRuleActivity r8 = (AiRuleActivity) ZeusTransformUtils.wrapperContextForParams(r1, AiRuleActivity.class, "com.obric.memorydata.plugin");
        List<? extends RuleEditorOutsideAction> r9 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        Function0<Unit> r10 = (Function0) ZeusTransformUtils.wrapperContextForParams(r5, Function0.class, "com.obric.memorydata.plugin");
        if ((r6 & 8) == 0) goto L5;
        r10 = null;
    L5:
        r8.performRuleEditorCloseActions(r2, r3, r9, r10);
    }

    private final void prepareRuleEditorIme(Window r1) {
        if (r1 == null) goto L5;
        r1.setSoftInputMode(com.obric.aiproactive.ui.preference.a.c());
        return;
    }

    private static final IProactiveService proactiveService_delegate$lambda$0() {
        return (IProactiveService) ZeusTransformUtils.preCheckCast(com.bytedance.news.common.service.manager.d.a(IProactiveService.class), IProactiveService.class, "com.obric.memorydata.plugin");
    }

    private final void renderContent() {
        boolean r0 = this.allRules.isEmpty();
        k r1 = this.guidedPreferenceInterviewStore;
        com.obric.aiproactive.ui.preference.b r2 = null;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("guidedPreferenceInterviewStore");
        r1 = null;
    L5:
        boolean r3 = !k.a(r1, null, 1, null);
        RecyclerView r4 = this.rvRules;
        if (r4 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("rvRules");
        r4 = null;
    L8:
        int r5 = 8;
        if (r0 == false) goto L11;
        int r6 = 8;
    L12:
        r4.setVisibility(r6);
        View r7 = this.emptyLayout;
        if (r7 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("emptyLayout");
        r7 = null;
    L15:
        if (r0 == false) goto L17;
        int r8 = 0;
    L18:
        r7.setVisibility(r8);
        View r9 = this.emptyGuidedEntryCard;
        if (r9 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("emptyGuidedEntryCard");
        r9 = null;
    L21:
        if (r0 == false) goto L24;
        if (r3 == false) goto L24;
        r5 = 0;
    L24:
        r9.setVisibility(r5);
        if (r0 == true) goto L32;
        com.obric.aiproactive.ui.preference.b r10 = this.adapter;
        if (r10 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
    L30:
        r2.a(this.allRules, this.latestAssistantUpdatedText, r3);
        return;
    L29:
        r2 = r10;
        goto L30
    L32:
        return;
    L17:
        r8 = 8;
        goto L18
    L11:
        r6 = 0;
        goto L12
    }

    private final void reportPreferenceEnterPage(Intent r4) {
        com.obric.aiproactive.ui.util.h r3 = com.obric.aiproactive.ui.util.h.f6884a;
        String r0 = null;
        if (r4 == null) goto L5;
        String r1 = r4.getStringExtra("previous_page");
    L6:
        String r2 = com.obric.aiproactive.ui.util.n.b(r1);
        if (r4 == null) goto L9;
        r0 = r4.getStringExtra("enter_from");
    L9:
        r3.b("preference", r2, com.obric.aiproactive.ui.util.n.a(r0), "click");
        return;
    L5:
        r1 = null;
        goto L6
    }

    private final int resolveThreeButtonNavigationBarHeight() {
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L5
        Object r2 = Result.m1421constructorimpl(Integer.valueOf(Settings.Secure.getInt(((AiRuleActivity) ZeusTransformUtils.preCheckCast(this, AiRuleActivity.class, "com.obric.memorydata.plugin")).getContentResolver(), "navigation_mode")));     // Catch: Throwable -> L5
    L8:
        if (Result.m1427isFailureimpl(r2) == false) goto L11;
        r2 = -1;
    L11:
        if (((Number) ZeusTransformUtils.preCheckCast(r2, Number.class, "com.obric.memorydata.plugin")).intValue() == 0) goto L13;
        return 0;
    L13:
        int r3 = ZeusTransformUtils.getIdentifier(ZeusTransformUtils.getResources(this, "com.obric.memorydata.plugin"), "navigation_bar_height", "dimen", "android", "com.obric.memorydata.plugin");
        if (r3 > 0) goto L16;
        return 0;
    L16:
        return ZeusTransformUtils.getResources(this, "com.obric.memorydata.plugin").getDimensionPixelSize(r3);
    L5:
        th = move-exception;
        Result.Companion r4 = Result.Companion;
        r2 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L8
    }

    private final void showAddDialog() {
        com.obric.oui.dialog.v2.alert.style.f r0 = new com.obric.oui.dialog.v2.alert.style.f(new $$Lambda$AiRuleActivity$WQUxU60fcpwOlaegqcnA3YbUiuE(this));
        final com.obric.oui.dialog.v2.alert.a r1 = (com.obric.oui.dialog.v2.alert.a) ZeusTransformUtils.preCheckCast(com.obric.oui.dialog.v2.alert.b.a((com.obric.oui.dialog.v2.alert.b) ZeusTransformUtils.preCheckCast(new s((Context) ZeusTransformUtils.preCheckCast(this, Context.class, "com.obric.memorydata.plugin")), com.obric.oui.dialog.v2.alert.b.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("添加偏好", CharSequence.class, "com.obric.memorydata.plugin"), false, 2, null).b(ZeusTransformUtils.mapRes(R.string.ai_proactive_rule_add_subtitle, TypedValues.Custom.S_STRING, "ai_proactive_rule_add_subtitle")).a((com.obric.oui.dialog.v2.alert.style.g) ZeusTransformUtils.preCheckCast(r0, com.obric.oui.dialog.v2.alert.style.g.class, "com.obric.memorydata.plugin")).c(true).g(), com.obric.oui.dialog.v2.alert.a.class, "com.obric.memorydata.plugin");
        r1.show();
        prepareRuleEditorIme(r1.getWindow());
        TextView r2 = r1.f();
        if (r2 == null) goto L5;
        r2.setGravity(17);
    L5:
        final OInputLayout r3 = (OInputLayout) ZeusTransformUtils.preCheckCast(r1.findViewById(ZeusTransformUtils.mapRes(R.id.edit_rule_input, OaidModel.KEY_ID, "edit_rule_input")), OInputLayout.class, "com.obric.memorydata.plugin");
        TextView r6 = (TextView) ZeusTransformUtils.preCheckCast(r1.findViewById(ZeusTransformUtils.mapRes(R.id.tv_over_limit_warning, OaidModel.KEY_ID, "tv_over_limit_warning")), TextView.class, "com.obric.memorydata.plugin");
        OButton r12 = (OButton) ZeusTransformUtils.preCheckCast(r1.findViewById(ZeusTransformUtils.mapRes(R.id.btn_cancel, OaidModel.KEY_ID, "btn_cancel")), OButton.class, "com.obric.memorydata.plugin");
        OButton r4 = (OButton) ZeusTransformUtils.preCheckCast(r1.findViewById(ZeusTransformUtils.mapRes(R.id.btn_confirm, OaidModel.KEY_ID, "btn_confirm")), OButton.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNull(r3);
        bindRuleInputBehavior$default(this, r3, r6, r4, null, false, 24, null);
        showKeyboard(r1.getWindow(), r3);
        bindRuleEditorOutsideCloseBehavior(r1, r3);
        r12.setOnClickListener(new $$Lambda$AiRuleActivity$zFWnPdOoF6yBzBy7CqmmB1qREyw(this, r1, r3));
        r4.setOnClickListener(new $$Lambda$AiRuleActivity$CUz9b4sdjciKwcoNHZx7MMcowg(r3, this, r1));
    }

    private static final Unit showAddDialog$lambda$16(AiRuleActivity r4, com.obric.oui.dialog.v2.alert.style.d r5) {
        AiRuleActivity r6 = (AiRuleActivity) ZeusTransformUtils.wrapperContextForParams(r4, AiRuleActivity.class, "com.obric.memorydata.plugin");
        com.obric.oui.dialog.v2.alert.style.d r7 = (com.obric.oui.dialog.v2.alert.style.d) ZeusTransformUtils.wrapperContextForParams(r5, com.obric.oui.dialog.v2.alert.style.d.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r7, "container");
        ZeusTransformUtils.inflate(LayoutInflater.from((Context) ZeusTransformUtils.preCheckCast(r6, Context.class, "com.obric.memorydata.plugin")), ZeusTransformUtils.mapRes(R.layout.dialog_edit_ai_rule, "layout", "dialog_edit_ai_rule"), (ViewGroup) ZeusTransformUtils.preCheckCast(r7.getBodySlot(), ViewGroup.class, "com.obric.memorydata.plugin"), true, "com.obric.memorydata.plugin");
        return Unit.INSTANCE;
    }

    private static final void showAddDialog$lambda$17(AiRuleActivity r1, com.obric.oui.dialog.v2.alert.a r2, OInputLayout r3, View r4) {
        AiRuleActivity r5 = (AiRuleActivity) ZeusTransformUtils.wrapperContextForParams(r1, AiRuleActivity.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNull(r3);
        r5.handleRuleEditorCancelClick(r2, r3);
    }

    private static final void showAddDialog$lambda$18(OInputLayout r12, AiRuleActivity r13, com.obric.oui.dialog.v2.alert.a r14, View r15) {
        AiRuleActivity r2 = (AiRuleActivity) ZeusTransformUtils.wrapperContextForParams(r13, AiRuleActivity.class, "com.obric.memorydata.plugin");
        String r5 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(String.valueOf(r12.getText()), CharSequence.class, "com.obric.memorydata.plugin")).toString();
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L5;
        boolean r16 = true;
    L6:
        if (r16 == true) goto L8;
        return;
    L8:
        if (r5.length() > 100) goto L12;
        kotlinx.coroutines.i.a((al) ZeusTransformUtils.preCheckCast(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) ZeusTransformUtils.preCheckCast(r2, LifecycleOwner.class, "com.obric.memorydata.plugin")), al.class, "com.obric.memorydata.plugin"), null, null, (Function2) ZeusTransformUtils.preCheckCast(new AiRuleActivity$showAddDialog$2$1(r2, r14, r12, r5, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
        return;
    L12:
        return;
    L5:
        r16 = false;
        goto L6
    }

    private final void showEditDialog(final AiRuleItemDto r12) {
        com.obric.oui.dialog.v2.alert.style.f r0 = new com.obric.oui.dialog.v2.alert.style.f(new $$Lambda$AiRuleActivity$PGNHKCXoFmJXkBTlOM8x_OalDk(this));
        if (r12.getType() != AiRuleItemDto.RuleType.AI_GENERATED) goto L5;
        boolean r6 = true;
    L6:
        com.obric.oui.dialog.v2.alert.b r1 = com.obric.oui.dialog.v2.alert.b.a((com.obric.oui.dialog.v2.alert.b) ZeusTransformUtils.preCheckCast(new s((Context) ZeusTransformUtils.preCheckCast(this, Context.class, "com.obric.memorydata.plugin")), com.obric.oui.dialog.v2.alert.b.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("编辑偏好", CharSequence.class, "com.obric.memorydata.plugin"), false, 2, null);
        if (r6 == false) goto L9;
        r1.b(ZeusTransformUtils.mapRes(R.string.ai_proactive_rule_edit_subtitle, TypedValues.Custom.S_STRING, "ai_proactive_rule_edit_subtitle"));
    L9:
        final com.obric.oui.dialog.v2.alert.a r7 = (com.obric.oui.dialog.v2.alert.a) ZeusTransformUtils.preCheckCast(r1.a((com.obric.oui.dialog.v2.alert.style.g) ZeusTransformUtils.preCheckCast(r0, com.obric.oui.dialog.v2.alert.style.g.class, "com.obric.memorydata.plugin")).c(true).g(), com.obric.oui.dialog.v2.alert.a.class, "com.obric.memorydata.plugin");
        r7.show();
        prepareRuleEditorIme(r7.getWindow());
        TextView r2 = r7.f();
        if (r2 == null) goto L12;
        r2.setGravity(17);
    L12:
        final OInputLayout r8 = (OInputLayout) ZeusTransformUtils.preCheckCast(r7.findViewById(ZeusTransformUtils.mapRes(R.id.edit_rule_input, OaidModel.KEY_ID, "edit_rule_input")), OInputLayout.class, "com.obric.memorydata.plugin");
        TextView r3 = (TextView) ZeusTransformUtils.preCheckCast(r7.findViewById(ZeusTransformUtils.mapRes(R.id.tv_over_limit_warning, OaidModel.KEY_ID, "tv_over_limit_warning")), TextView.class, "com.obric.memorydata.plugin");
        OButton r9 = (OButton) ZeusTransformUtils.preCheckCast(r7.findViewById(ZeusTransformUtils.mapRes(R.id.btn_cancel, OaidModel.KEY_ID, "btn_cancel")), OButton.class, "com.obric.memorydata.plugin");
        OButton r10 = (OButton) ZeusTransformUtils.preCheckCast(r7.findViewById(ZeusTransformUtils.mapRes(R.id.btn_confirm, OaidModel.KEY_ID, "btn_confirm")), OButton.class, "com.obric.memorydata.plugin");
        r8.setText((CharSequence) ZeusTransformUtils.preCheckCast(r12.getContent(), CharSequence.class, "com.obric.memorydata.plugin"));
        Intrinsics.checkNotNull(r8);
        bindRuleInputBehavior(r8, r3, r10, r12.getContent(), true);
        showKeyboard(r7.getWindow(), r8);
        bindRuleEditorOutsideCloseBehavior(r7, r8);
        r9.setOnClickListener(new $$Lambda$AiRuleActivity$ygFtu7hjiFkdL2M1vj9PnCf2Ls(this, r7, r8));
        final boolean r5 = r6;
        r10.setOnClickListener(new $$Lambda$AiRuleActivity$tvWC9Wute_z73qnLyGbZ106h_Uo(r8, this, r7, r12, r5));
        return;
    L5:
        r6 = false;
        goto L6
    }

    private static final Unit showEditDialog$lambda$19(AiRuleActivity r4, com.obric.oui.dialog.v2.alert.style.d r5) {
        AiRuleActivity r6 = (AiRuleActivity) ZeusTransformUtils.wrapperContextForParams(r4, AiRuleActivity.class, "com.obric.memorydata.plugin");
        com.obric.oui.dialog.v2.alert.style.d r7 = (com.obric.oui.dialog.v2.alert.style.d) ZeusTransformUtils.wrapperContextForParams(r5, com.obric.oui.dialog.v2.alert.style.d.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r7, "container");
        ZeusTransformUtils.inflate(LayoutInflater.from((Context) ZeusTransformUtils.preCheckCast(r6, Context.class, "com.obric.memorydata.plugin")), ZeusTransformUtils.mapRes(R.layout.dialog_edit_ai_rule, "layout", "dialog_edit_ai_rule"), (ViewGroup) ZeusTransformUtils.preCheckCast(r7.getBodySlot(), ViewGroup.class, "com.obric.memorydata.plugin"), true, "com.obric.memorydata.plugin");
        return Unit.INSTANCE;
    }

    private static final void showEditDialog$lambda$21(AiRuleActivity r1, com.obric.oui.dialog.v2.alert.a r2, OInputLayout r3, View r4) {
        AiRuleActivity r5 = (AiRuleActivity) ZeusTransformUtils.wrapperContextForParams(r1, AiRuleActivity.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNull(r3);
        r5.handleRuleEditorCancelClick(r2, r3);
    }

    private static final void showEditDialog$lambda$22(OInputLayout r13, AiRuleActivity r14, com.obric.oui.dialog.v2.alert.a r15, AiRuleItemDto r16, boolean r17, View r18) {
        AiRuleActivity r3 = (AiRuleActivity) ZeusTransformUtils.wrapperContextForParams(r14, AiRuleActivity.class, "com.obric.memorydata.plugin");
        String r7 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(String.valueOf(r13.getText()), CharSequence.class, "com.obric.memorydata.plugin")).toString();
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L8;
        return;
    L8:
        if (r7.length() > 100) goto L12;
        kotlinx.coroutines.i.a((al) ZeusTransformUtils.preCheckCast(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) ZeusTransformUtils.preCheckCast(r3, LifecycleOwner.class, "com.obric.memorydata.plugin")), al.class, "com.obric.memorydata.plugin"), null, null, (Function2) ZeusTransformUtils.preCheckCast(new AiRuleActivity$showEditDialog$2$1(r3, r15, r13, r16, r7, r17, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
        return;
    L12:
        return;
    L5:
        r0 = false;
        goto L6
    }

    private final void showKeyboard(final Window r2, final OInputLayout r3) {
        r3.post(new $$Lambda$AiRuleActivity$btF3KoFjYh1WJNi50fczfEOw(r3, this, r2));
    }

    private static final void showKeyboard$lambda$30(final OInputLayout r5, AiRuleActivity r6, Window r7) {
        final AiRuleActivity r8 = (AiRuleActivity) ZeusTransformUtils.wrapperContextForParams(r6, AiRuleActivity.class, "com.obric.memorydata.plugin");
        r5.getVInput().setFocusableInTouchMode(true);
        r5.getVInput().requestFocusFromTouch();
        r5.getVInput().requestFocus();
        OEditText r0 = r5.getVInput();
        Editable r3 = r5.getVInput().getText();
        if (r3 == null) goto L5;
        int r4 = r3.length();
    L6:
        r0.setSelection(r4);
        Object r1 = r8.getSystemService("input_method");
        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        final InputMethodManager r2 = (InputMethodManager) ZeusTransformUtils.preCheckCast(r1, InputMethodManager.class, "com.obric.memorydata.plugin");
        if (r7 == null) goto L11;
        WindowInsetsControllerCompat r9 = WindowCompat.getInsetsController(r7, (View) ZeusTransformUtils.preCheckCast(r5.getVInput(), View.class, "com.obric.memorydata.plugin"));
        if (r9 == null) goto L11;
        r9.show(WindowInsetsCompat.Type.ime());
    L11:
        r2.showSoftInput((View) ZeusTransformUtils.preCheckCast(r5.getVInput(), View.class, "com.obric.memorydata.plugin"), 1);
        r8.cancelPendingRuleEditorKeyboardRetry(r5);
        Runnable r10 = new $$Lambda$AiRuleActivity$JPAFcJpEErzJHvBBkC8ys04CpNY(r8, r2, r5);
        r8.pendingRuleEditorKeyboardRetry = r10;
        r5.getVInput().postDelayed(r10, RULE_EDITOR_KEYBOARD_RETRY_DELAY_MS);
        return;
    L5:
        r4 = 0;
        goto L6
    }

    private static final void showKeyboard$lambda$30$lambda$29(AiRuleActivity r2, InputMethodManager r3, OInputLayout r4) {
        ((AiRuleActivity) ZeusTransformUtils.wrapperContextForParams(r2, AiRuleActivity.class, "com.obric.memorydata.plugin")).pendingRuleEditorKeyboardRetry = null;
        r3.showSoftInput((View) ZeusTransformUtils.preCheckCast(r4.getVInput(), View.class, "com.obric.memorydata.plugin"), 1);
    }

    private final void showRuleActionPopup(View r19, final AiRuleItemDto r20) {
        com.obric.oui.popover.v2.a r2 = this.actionPopover;
        if (r2 == null) goto L5;
        r2.dismiss();
    L5:
        int r3 = getColor(ZeusTransformUtils.mapRes(R.color.oui_basic_text_1, TypedValues.Custom.S_COLOR, "oui_basic_text_1"));
        OPopoverEntranceMenuView.Builder r15 = new OPopoverEntranceMenuView.Builder((Context) ZeusTransformUtils.preCheckCast(this, Context.class, "com.obric.memorydata.plugin"));
        OPopoverEntranceMenuView.Builder.a(r15, Integer.valueOf(ZeusTransformUtils.mapRes(R.drawable.ic_edit, "drawable", "ic_edit")), null, Integer.valueOf(r3), (CharSequence) ZeusTransformUtils.preCheckCast("编辑", CharSequence.class, "com.obric.memorydata.plugin"), null, null, false, null, new $$Lambda$AiRuleActivity$PlQsXeN1D8Fqv9moAycqKcjPf9w(this, r20), 242, null);
        OPopoverEntranceMenuView.Builder.a(r15, Integer.valueOf(ZeusTransformUtils.mapRes(R.drawable.ic_delete, "drawable", "ic_delete")), null, null, (CharSequence) ZeusTransformUtils.preCheckCast("删除", CharSequence.class, "com.obric.memorydata.plugin"), null, null, true, null, new $$Lambda$AiRuleActivity$8KIcAN57NZ81hXLP9sIPRMMi_M(this, r20), 182, null);
        OPopoverEntranceMenuView r1 = r15.c();
        com.obric.oui.popover.v2.a r4 = ((com.obric.oui.popover.v2.a.C0765a) ZeusTransformUtils.preCheckCast(new com.obric.oui.popover.v2.a.C0765a((Context) ZeusTransformUtils.preCheckCast(this, Context.class, "com.obric.memorydata.plugin")).a((View) ZeusTransformUtils.preCheckCast(r1, View.class, "com.obric.memorydata.plugin")), com.obric.oui.popover.v2.a.C0765a.class, "com.obric.memorydata.plugin")).F();
        com.obric.oui.popover.v2.e.a(com.obric.oui.popover.v2.e.f14366a, r4, r19, 80, false, 0, false, 0, 0, 248, null);
        this.actionPopover = r4;
    }

    private static final Unit showRuleActionPopup$lambda$13(AiRuleActivity r1, AiRuleItemDto r2, View r3, int r4) {
        AiRuleActivity r5 = (AiRuleActivity) ZeusTransformUtils.wrapperContextForParams(r1, AiRuleActivity.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "<unused var>");
        com.obric.oui.popover.v2.a r6 = r5.actionPopover;
        if (r6 == null) goto L5;
        r6.dismiss();
    L5:
        r5.showEditDialog(r2);
        return Unit.INSTANCE;
    }

    private static final Unit showRuleActionPopup$lambda$14(AiRuleActivity r1, AiRuleItemDto r2, View r3, int r4) {
        AiRuleActivity r5 = (AiRuleActivity) ZeusTransformUtils.wrapperContextForParams(r1, AiRuleActivity.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "<unused var>");
        com.obric.oui.popover.v2.a r6 = r5.actionPopover;
        if (r6 == null) goto L5;
        r6.dismiss();
    L5:
        r5.deleteRule(r2);
        return Unit.INSTANCE;
    }

    private final String toHeaderText(long r4) {
        if (r4 > 0) goto L7;
        return null;
    L7:
        return "更新于 " + new SimpleDateFormat("MM-dd HH:mm", Locale.getDefault()).format(new Date(r4));
    }

    public void finish() {
        super.finish();
        com.obric.memorydata.ui.h.f13009a.c((Activity) ZeusTransformUtils.preCheckCast(this, Activity.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.aiproactive.ui.entry.BaseProactiveActivity
    public boolean needLoginCheckOnCreate() {
        return true;
    }

    @Override // com.obric.aiproactive.ui.entry.BaseProactiveActivity
    public boolean needLoginCheckOnResume() {
        return true;
    }

    @Override // com.obric.aiproactive.ui.entry.BaseProactiveActivity
    public void onCreateChecked(Bundle r14) {
        setContentView(ZeusTransformUtils.mapRes(R.layout.activity_ai_rule, "layout", "activity_ai_rule"));
        WindowCompat.setDecorFitsSystemWindows(getWindow(), false);
        getWindow().setStatusBarColor(0);
        AiProactiveUiModeController r15 = AiProactiveUiModeController.f6869a;
        Configuration r1 = ZeusTransformUtils.getResources(this, "com.obric.memorydata.plugin").getConfiguration();
        Intrinsics.checkNotNullExpressionValue(r1, "getConfiguration(...)");
        boolean r16 = !r15.b(r1);
        WindowInsetsControllerCompat r2 = new WindowInsetsControllerCompat(getWindow(), getWindow().getDecorView());
        r2.setAppearanceLightStatusBars(r16);
        r2.setAppearanceLightNavigationBars(r16);
        View r17 = findViewById(ZeusTransformUtils.mapRes(R.id.rv_rules, OaidModel.KEY_ID, "rv_rules"));
        Intrinsics.checkNotNullExpressionValue(r17, "findViewById(...)");
        RecyclerView r18 = (RecyclerView) ZeusTransformUtils.preCheckCast(r17, RecyclerView.class, "com.obric.memorydata.plugin");
        this.rvRules = r18;
        RecyclerView r4 = null;
        if (r18 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("rvRules");
        r18 = null;
    L5:
        final int r12 = r18.getPaddingBottom();
        final View r11 = findViewById(ZeusTransformUtils.mapRes(R.id.bottom_nav_inset_spacer, OaidModel.KEY_ID, "bottom_nav_inset_spacer"));
        View r19 = findViewById(ZeusTransformUtils.mapRes(R.id.layout_empty, OaidModel.KEY_ID, "layout_empty"));
        Intrinsics.checkNotNullExpressionValue(r19, "findViewById(...)");
        this.emptyLayout = r19;
        View r110 = findViewById(ZeusTransformUtils.mapRes(R.id.guided_preference_entry_card, OaidModel.KEY_ID, "guided_preference_entry_card"));
        Intrinsics.checkNotNullExpressionValue(r110, "findViewById(...)");
        this.emptyGuidedEntryCard = r110;
        this.guidedPreferenceInterviewStore = new k((Context) ZeusTransformUtils.preCheckCast(this, Context.class, "com.obric.memorydata.plugin"));
        View r111 = findViewById(ZeusTransformUtils.mapRes(R.id.ai_rule_root, OaidModel.KEY_ID, "ai_rule_root"));
        final View r9 = findViewById(ZeusTransformUtils.mapRes(R.id.btn_back_container, OaidModel.KEY_ID, "btn_back_container"));
        final View r10 = findViewById(ZeusTransformUtils.mapRes(R.id.btn_add_container, OaidModel.KEY_ID, "btn_add_container"));
        final View r7 = findViewById(ZeusTransformUtils.mapRes(R.id.top_blur_view, OaidModel.KEY_ID, "top_blur_view"));
        final View r8 = findViewById(ZeusTransformUtils.mapRes(R.id.top_cut_off, OaidModel.KEY_ID, "top_cut_off"));
        r9.setOnClickListener(new $$Lambda$AiRuleActivity$Y8IZKx1MUyQE5vKukOxuq2xClTk(this));
        r10.setOnClickListener(new $$Lambda$AiRuleActivity$3jdUYZYUNmMSfJRLO899xFlA1IQ(this));
        View r3 = this.emptyGuidedEntryCard;
        if (r3 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("emptyGuidedEntryCard");
        r3 = null;
    L8:
        r3.setOnClickListener(new $$Lambda$AiRuleActivity$FgxAHm6YMngfhQQEmgsc84ZS8nM(this));
        disableClipFromButtonAncestors(r9);
        disableClipFromButtonAncestors(r10);
        ViewCompat.setOnApplyWindowInsetsListener(r111, new $$Lambda$AiRuleActivity$UN9HSLHCl1f2Dk9T5OSicnJm8U(this, r7, r8, r9, r10, r11, r12));
        ViewCompat.requestApplyInsets(r111);
        this.adapter = new com.obric.aiproactive.ui.preference.b(new $$Lambda$AiRuleActivity$DbT38gIHAlVTWTweaJk7SWe3IW8(this), new $$Lambda$AiRuleActivity$kOJ3wv3jlPv1iGaF2h9WXNh2P8M(this));
        RecyclerView r112 = this.rvRules;
        if (r112 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("rvRules");
        r112 = null;
    L11:
        r112.setLayoutManager((RecyclerView.h) ZeusTransformUtils.preCheckCast(new LinearLayoutManager((Context) ZeusTransformUtils.preCheckCast(this, Context.class, "com.obric.memorydata.plugin")), RecyclerView.h.class, "com.obric.memorydata.plugin"));
        RecyclerView r113 = this.rvRules;
        if (r113 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("rvRules");
        r113 = null;
    L14:
        com.obric.aiproactive.ui.preference.b r5 = this.adapter;
        if (r5 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
        r5 = null;
    L17:
        r113.setAdapter((RecyclerView.Adapter) ZeusTransformUtils.preCheckCast(r5, RecyclerView.Adapter.class, "com.obric.memorydata.plugin"));
        com.obric.aiproactive.ui.util.q r114 = new com.obric.aiproactive.ui.util.q();
        RecyclerView r6 = this.rvRules;
        if (r6 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("rvRules");
        r6 = null;
    L20:
        r6.addOnItemTouchListener((RecyclerView.l) ZeusTransformUtils.preCheckCast(new d(r114), RecyclerView.l.class, "com.obric.memorydata.plugin"));
        RecyclerView r13 = this.rvRules;
        if (r13 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("rvRules");
    L24:
        r4.addOnScrollListener((RecyclerView.m) ZeusTransformUtils.preCheckCast(new e(r114), RecyclerView.m.class, "com.obric.memorydata.plugin"));
        reportPreferenceEnterPage(getIntent());
        return;
    L23:
        r4 = r13;
        goto L24
    }

    @Override // com.obric.aiproactive.ui.entry.BaseProactiveActivity, androidx.activity.ComponentActivity
    public void onNewIntent(Intent r2) {
        Intrinsics.checkNotNullParameter(r2, MemorySourceLinkType.INTENT);
        super.onNewIntent(r2);
        reportPreferenceEnterPage(r2);
    }

    @Override // com.obric.aiproactive.ui.entry.BaseProactiveActivity
    public void onResumeChecked() {
        loadData();
    }
}
