package com.obric.aiproactive.ui.preference;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.content.ContextCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.WindowInsetsControllerCompat;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.aiproactive.api.IProactiveService;
import com.obric.aiproactive.ui.entry.BaseProactiveActivity;
import com.obric.memorydata.memory.lab.AILabCheckPermissionTask;
import com.obric.memorydata.plugin.R;
import com.obric.memorydata.ui.NavigationBarScheme;
import com.obric.oui.bouncelayout.ONestedScrollView;
import com.obric.oui.button.OButton;
import com.obric.oui.orecyclerview.widget.LinearLayoutManager;
import com.obric.oui.orecyclerview.widget.RecyclerView;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.al;
import kotlinx.coroutines.ba;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001b\u0018\u0000 M2\u00020\u0001:\u0001MB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010.\u001a\u00020$H\u0014J\b\u0010/\u001a\u00020$H\u0014J\u0012\u00100\u001a\u0002012\b\u00102\u001a\u0004\u0018\u000103H\u0014J\b\u00104\u001a\u000201H\u0016J\b\u00105\u001a\u000201H\u0016J\b\u00106\u001a\u000201H\u0002J\b\u00107\u001a\u000201H\u0002J\u0010\u00108\u001a\u0002012\u0006\u00109\u001a\u00020\"H\u0002J\b\u0010:\u001a\u000201H\u0002J\u0010\u0010;\u001a\u0002012\u0006\u0010<\u001a\u00020\u000fH\u0002J \u0010=\u001a\u00020\"2\u0006\u0010>\u001a\u00020\"2\u0006\u0010?\u001a\u00020\"2\u0006\u0010@\u001a\u00020\"H\u0002J\b\u0010A\u001a\u000201H\u0002J\u0014\u0010B\u001a\u0002012\n\b\u0002\u0010C\u001a\u0004\u0018\u00010&H\u0002J\b\u0010D\u001a\u000201H\u0002J\b\u0010E\u001a\u000201H\u0002J\b\u0010F\u001a\u000201H\u0002J\b\u0010G\u001a\u000201H\u0002J\b\u0010H\u001a\u000201H\u0002J\u0010\u0010I\u001a\u0002012\u0006\u0010J\u001a\u00020$H\u0002J\b\u0010K\u001a\u000201H\u0002J\b\u0010L\u001a\u000201H\u0002R\u0014\u0010\u0004\u001a\u00020\u0005X\u0094\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u000fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u000fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u000fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020$X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u0004\u0018\u00010&X\u0082\u000e¢\u0006\u0002\n\u0000R#\u0010'\u001a\n )*\u0004\u0018\u00010(0(8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b*\u0010+¨\u0006N"}, d2 = {"Lcom/obric/aiproactive/ui/preference/GuidedPreferenceInterviewActivity;", "Lcom/obric/aiproactive/ui/entry/BaseProactiveActivity;", "<init>", "()V", "navigationBarScheme", "Lcom/obric/memorydata/ui/NavigationBarScheme;", "getNavigationBarScheme", "()Lcom/obric/memorydata/ui/NavigationBarScheme;", "tvProgress", "Landroid/widget/TextView;", "tvTitle", "tvSubtitle", "scrollContent", "Lcom/obric/oui/bouncelayout/ONestedScrollView;", "layoutTopbar", "Landroid/view/View;", "layoutOptionGroup", "Landroid/widget/FrameLayout;", "keyboardBlurView", "rvOptions", "Lcom/obric/oui/orecyclerview/widget/RecyclerView;", "btnPrimary", "Lcom/obric/oui/button/OButton;", "btnBack", "btnClose", "optionAdapter", "Lcom/obric/aiproactive/ui/preference/GuidedPreferenceOptionAdapter;", "focusedInputView", "pages", "", "Lcom/obric/aiproactive/ui/preference/GuidedPreferencePage;", "state", "Lcom/obric/aiproactive/ui/preference/GuidedPreferenceInterviewState;", "pageIndex", "", "isCompleting", "", AILabCheckPermissionTask.KEY_SOURCE, "", "proactiveService", "Lcom/obric/aiproactive/api/IProactiveService;", "kotlin.jvm.PlatformType", "getProactiveService", "()Lcom/obric/aiproactive/api/IProactiveService;", "proactiveService$delegate", "Lkotlin/Lazy;", "needLoginCheckOnCreate", "needLoginCheckOnResume", "onCreateChecked", "", "savedInstanceState", "Landroid/os/Bundle;", "finish", "onBackPressed", "setupWindow", "bindViews", "applyScrollableContentBottomPadding", "primaryBottomMargin", "setupOptions", "handleInputFocusRequested", "inputView", "resolveKeyboardContentLift", "keyboardOffset", "statusTop", "imeBottom", "hideGuidedInputKeyboard", "renderPage", "focusOptionId", "updatePrimaryButtonState", "handlePrimaryAction", "handleBackOrClose", "handleCloseAction", "completeInterview", "setCompletingUiLocked", "locked", "navigateToRulePage", "showCloseConfirmation", "Companion", "ai_proactive_ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class GuidedPreferenceInterviewActivity extends BaseProactiveActivity {
    private static final a Companion = null;

    @Deprecated
    public static final int KEYBOARD_LIFTED_CONTAINER_BACKGROUND_ALPHA = 0;

    @Deprecated
    public static final long KEYBOARD_RETRY_DELAY_MS = 120;

    @Deprecated
    public static final int OPAQUE_ALPHA = 255;

    @Deprecated
    public static final String TAG = "GuidedPreferenceInterview";
    private View btnBack;
    private View btnClose;
    private OButton btnPrimary;
    private View focusedInputView;
    private boolean isCompleting;
    private View keyboardBlurView;
    private FrameLayout layoutOptionGroup;
    private View layoutTopbar;
    private final NavigationBarScheme navigationBarScheme;
    private n optionAdapter;
    private int pageIndex;
    private final List<o> pages;
    private final Lazy proactiveService$delegate;
    private RecyclerView rvOptions;
    private ONestedScrollView scrollContent;
    private String source;
    private j state;
    private TextView tvProgress;
    private TextView tvSubtitle;
    private TextView tvTitle;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\t\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u0011\u0010\t\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u000e\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u000bR\u000e\u0010\u0010\u001a\u00020\u0011X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/obric/aiproactive/ui/preference/GuidedPreferenceInterviewActivity$Companion;", "", "<init>", "()V", "TAG", "", "OPAQUE_ALPHA", "", "KEYBOARD_LIFTED_CONTAINER_BACKGROUND_ALPHA", "KEYBOARD_INPUT_BOTTOM_MARGIN", "getKEYBOARD_INPUT_BOTTOM_MARGIN", "()I", "KEYBOARD_GROUP_MIN_VISIBLE_HEIGHT", "getKEYBOARD_GROUP_MIN_VISIBLE_HEIGHT", "CONTENT_BUTTON_SAFETY_MARGIN", "getCONTENT_BUTTON_SAFETY_MARGIN", "KEYBOARD_RETRY_DELAY_MS", "", "ai_proactive_ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }

        public final int a() {
            return (int) com.obric.oui.common.util.h.a(24.0f);
        }

        public final int b() {
            return (int) com.obric.oui.common.util.h.a(220.0f);
        }

        public final int c() {
            return (int) com.obric.oui.common.util.h.a(24.0f);
        }
    }

    /* JADX INFO: renamed from: com.obric.aiproactive.ui.preference.GuidedPreferenceInterviewActivity$completeInterview$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.aiproactive.ui.preference.GuidedPreferenceInterviewActivity$completeInterview$1", f = "GuidedPreferenceInterviewActivity.kt", i = {}, l = {329}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
        final /* synthetic */ List<String> $generatedRules;
        int label;
        final /* synthetic */ GuidedPreferenceInterviewActivity this$0;

        AnonymousClass1(GuidedPreferenceInterviewActivity r3, List<String> r4, Continuation<? super AnonymousClass1> r5) {
            GuidedPreferenceInterviewActivity r6 = (GuidedPreferenceInterviewActivity) ZeusTransformUtils.wrapperContextForParams(r3, GuidedPreferenceInterviewActivity.class, "com.obric.memorydata.plugin");
            List<String> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
            Continuation r8 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r6;
            this.$generatedRules = r7;
            super(2, r8);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.this$0, this.$generatedRules, r5), Continuation.class, "com.obric.memorydata.plugin");
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
        L12:
            if (((Boolean) ZeusTransformUtils.preCheckCast(r8, Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == true) goto L16;
            GuidedPreferenceInterviewActivity.access$setCompleting$p(this.this$0, false);
            GuidedPreferenceInterviewActivity.access$setCompletingUiLocked(this.this$0, false);
            GuidedPreferenceInterviewActivity.access$updatePrimaryButtonState(this.this$0);
            Toast.makeText((Context) ZeusTransformUtils.preCheckCast(this.this$0, Context.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("保存失败，请稍后重试", CharSequence.class, "com.obric.memorydata.plugin"), 0).show();
        L15:
            return Unit.INSTANCE;
        L16:
            k.b(new k((Context) ZeusTransformUtils.preCheckCast(this.this$0, Context.class, "com.obric.memorydata.plugin")), null, 1, null);
            com.obric.aiproactive.ui.util.h.f6884a.b(f.a(GuidedPreferenceInterviewActivity.access$getSource$p(this.this$0)), GuidedPreferenceInterviewActivity.access$getState$p(this.this$0).b());
            GuidedPreferenceInterviewActivity.access$navigateToRulePage(this.this$0);
            goto L15
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r8);
            CoroutineContext r9 = (CoroutineContext) ZeusTransformUtils.preCheckCast(ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin");
            Function2 r2 = (Function2) ZeusTransformUtils.preCheckCast(new GuidedPreferenceInterviewActivity$completeInterview$1$writeSucceeded$1(this.$generatedRules, this.this$0, null), Function2.class, "com.obric.memorydata.plugin");
            Continuation r5 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 1;
            r8 = kotlinx.coroutines.i.a(r9, r2, r5);
            if (r8 != r0) goto L12;
            return r0;
        }
    }

    static {
        Companion = new a(null);
    }

    public GuidedPreferenceInterviewActivity() {
        this.navigationBarScheme = NavigationBarScheme.A;
        List<o> r2 = g.f6771a.a();
        this.pages = r2;
        this.state = new j(r2, null, null, 6, null);
        this.proactiveService$delegate = LazyKt.lazy($$Lambda$GuidedPreferenceInterviewActivity$VnbqM7fF4xpHMDuSPxcK1w4H8o.INSTANCE);
    }

    public static final /* synthetic */ IProactiveService access$getProactiveService(GuidedPreferenceInterviewActivity r2) {
        return ((GuidedPreferenceInterviewActivity) ZeusTransformUtils.wrapperContextForParams(r2, GuidedPreferenceInterviewActivity.class, "com.obric.memorydata.plugin")).getProactiveService();
    }

    public static final /* synthetic */ String access$getSource$p(GuidedPreferenceInterviewActivity r2) {
        return ((GuidedPreferenceInterviewActivity) ZeusTransformUtils.wrapperContextForParams(r2, GuidedPreferenceInterviewActivity.class, "com.obric.memorydata.plugin")).source;
    }

    public static final /* synthetic */ j access$getState$p(GuidedPreferenceInterviewActivity r2) {
        return ((GuidedPreferenceInterviewActivity) ZeusTransformUtils.wrapperContextForParams(r2, GuidedPreferenceInterviewActivity.class, "com.obric.memorydata.plugin")).state;
    }

    public static final /* synthetic */ void access$navigateToRulePage(GuidedPreferenceInterviewActivity r2) {
        ((GuidedPreferenceInterviewActivity) ZeusTransformUtils.wrapperContextForParams(r2, GuidedPreferenceInterviewActivity.class, "com.obric.memorydata.plugin")).navigateToRulePage();
    }

    public static final /* synthetic */ void access$setCompleting$p(GuidedPreferenceInterviewActivity r2, boolean r3) {
        ((GuidedPreferenceInterviewActivity) ZeusTransformUtils.wrapperContextForParams(r2, GuidedPreferenceInterviewActivity.class, "com.obric.memorydata.plugin")).isCompleting = r3;
    }

    public static final /* synthetic */ void access$setCompletingUiLocked(GuidedPreferenceInterviewActivity r2, boolean r3) {
        ((GuidedPreferenceInterviewActivity) ZeusTransformUtils.wrapperContextForParams(r2, GuidedPreferenceInterviewActivity.class, "com.obric.memorydata.plugin")).setCompletingUiLocked(r3);
    }

    public static final /* synthetic */ void access$updatePrimaryButtonState(GuidedPreferenceInterviewActivity r2) {
        ((GuidedPreferenceInterviewActivity) ZeusTransformUtils.wrapperContextForParams(r2, GuidedPreferenceInterviewActivity.class, "com.obric.memorydata.plugin")).updatePrimaryButtonState();
    }

    private final void applyScrollableContentBottomPadding(int r6) {
        OButton r0 = this.btnPrimary;
        ONestedScrollView r2 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("btnPrimary");
        r0 = null;
    L5:
        Integer r1 = Integer.valueOf(r0.getHeight());
        int r4 = 0;
        if (((Number) ZeusTransformUtils.preCheckCast(r1, Number.class, "com.obric.memorydata.plugin")).intValue() <= 0) goto L8;
        boolean r3 = true;
    L9:
        if (r3 == true) goto L12;
        r1 = null;
    L12:
        if (r1 == null) goto L14;
        r4 = r1.intValue();
    L20:
        int r7 = i.f6773a.b(r4, r6, Companion.c());
        ONestedScrollView r5 = this.scrollContent;
        if (r5 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("scrollContent");
        r5 = null;
    L24:
        if (r5.getPaddingBottom() == r7) goto L40;
        ONestedScrollView r8 = this.scrollContent;
        if (r8 != null) goto L28;
        Intrinsics.throwUninitializedPropertyAccessException("scrollContent");
        r8 = null;
    L28:
        ONestedScrollView r9 = this.scrollContent;
        if (r9 != null) goto L31;
        Intrinsics.throwUninitializedPropertyAccessException("scrollContent");
        r9 = null;
    L31:
        int r10 = r9.getPaddingLeft();
        ONestedScrollView r11 = this.scrollContent;
        if (r11 != null) goto L34;
        Intrinsics.throwUninitializedPropertyAccessException("scrollContent");
        r11 = null;
    L34:
        int r12 = r11.getPaddingTop();
        ONestedScrollView r13 = this.scrollContent;
        if (r13 != null) goto L37;
        Intrinsics.throwUninitializedPropertyAccessException("scrollContent");
    L38:
        r8.setPadding(r10, r12, r2.getPaddingRight(), r7);
        return;
    L37:
        r2 = r13;
        goto L38
    L40:
        return;
    L14:
        OButton r14 = this.btnPrimary;
        if (r14 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("btnPrimary");
        r14 = null;
    L17:
        ViewGroup.LayoutParams r15 = r14.getLayoutParams();
        if (r15 == null) goto L20;
        r4 = r15.height;
        goto L20
    L8:
        r3 = false;
        goto L9
    }

    private final void bindViews() {
        View r0 = findViewById(ZeusTransformUtils.mapRes(R.id.tv_guided_progress, OaidModel.KEY_ID, "tv_guided_progress"));
        Intrinsics.checkNotNullExpressionValue(r0, "findViewById(...)");
        this.tvProgress = (TextView) ZeusTransformUtils.preCheckCast(r0, TextView.class, "com.obric.memorydata.plugin");
        View r1 = findViewById(ZeusTransformUtils.mapRes(R.id.tv_guided_title, OaidModel.KEY_ID, "tv_guided_title"));
        Intrinsics.checkNotNullExpressionValue(r1, "findViewById(...)");
        this.tvTitle = (TextView) ZeusTransformUtils.preCheckCast(r1, TextView.class, "com.obric.memorydata.plugin");
        View r2 = findViewById(ZeusTransformUtils.mapRes(R.id.tv_guided_subtitle, OaidModel.KEY_ID, "tv_guided_subtitle"));
        Intrinsics.checkNotNullExpressionValue(r2, "findViewById(...)");
        this.tvSubtitle = (TextView) ZeusTransformUtils.preCheckCast(r2, TextView.class, "com.obric.memorydata.plugin");
        View r3 = findViewById(ZeusTransformUtils.mapRes(R.id.scroll_guided_content, OaidModel.KEY_ID, "scroll_guided_content"));
        Intrinsics.checkNotNullExpressionValue(r3, "findViewById(...)");
        this.scrollContent = (ONestedScrollView) ZeusTransformUtils.preCheckCast(r3, ONestedScrollView.class, "com.obric.memorydata.plugin");
        View r4 = findViewById(ZeusTransformUtils.mapRes(R.id.layout_guided_topbar, OaidModel.KEY_ID, "layout_guided_topbar"));
        Intrinsics.checkNotNullExpressionValue(r4, "findViewById(...)");
        this.layoutTopbar = r4;
        View r5 = findViewById(ZeusTransformUtils.mapRes(R.id.layout_guided_option_group, OaidModel.KEY_ID, "layout_guided_option_group"));
        Intrinsics.checkNotNullExpressionValue(r5, "findViewById(...)");
        this.layoutOptionGroup = (FrameLayout) ZeusTransformUtils.preCheckCast(r5, FrameLayout.class, "com.obric.memorydata.plugin");
        View r6 = findViewById(ZeusTransformUtils.mapRes(R.id.view_guided_keyboard_blur, OaidModel.KEY_ID, "view_guided_keyboard_blur"));
        Intrinsics.checkNotNullExpressionValue(r6, "findViewById(...)");
        this.keyboardBlurView = r6;
        View r7 = findViewById(ZeusTransformUtils.mapRes(R.id.rv_guided_options, OaidModel.KEY_ID, "rv_guided_options"));
        Intrinsics.checkNotNullExpressionValue(r7, "findViewById(...)");
        this.rvOptions = (RecyclerView) ZeusTransformUtils.preCheckCast(r7, RecyclerView.class, "com.obric.memorydata.plugin");
        View r8 = findViewById(ZeusTransformUtils.mapRes(R.id.btn_guided_primary, OaidModel.KEY_ID, "btn_guided_primary"));
        Intrinsics.checkNotNullExpressionValue(r8, "findViewById(...)");
        this.btnPrimary = (OButton) ZeusTransformUtils.preCheckCast(r8, OButton.class, "com.obric.memorydata.plugin");
        View r9 = findViewById(ZeusTransformUtils.mapRes(R.id.btn_guided_back, OaidModel.KEY_ID, "btn_guided_back"));
        Intrinsics.checkNotNullExpressionValue(r9, "findViewById(...)");
        this.btnBack = r9;
        View r10 = findViewById(ZeusTransformUtils.mapRes(R.id.btn_guided_close, OaidModel.KEY_ID, "btn_guided_close"));
        Intrinsics.checkNotNullExpressionValue(r10, "findViewById(...)");
        this.btnClose = r10;
        View r11 = this.btnBack;
        Drawable r12 = null;
        if (r11 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("btnBack");
        r11 = null;
    L5:
        r11.setOnClickListener(new $$Lambda$GuidedPreferenceInterviewActivity$UasUkFhEpHqv4h6iA8O4dDIdcU(this));
        View r13 = this.btnClose;
        if (r13 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("btnClose");
        r13 = null;
    L8:
        r13.setOnClickListener(new $$Lambda$GuidedPreferenceInterviewActivity$fa4Tci8I4DMrxGF15gTpTyUuxc(this));
        OButton r14 = this.btnPrimary;
        if (r14 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("btnPrimary");
        r14 = null;
    L11:
        r14.setOnClickListener(new $$Lambda$GuidedPreferenceInterviewActivity$VxeaW_o_KYOvNIXp2jgnAi8gXKY(this));
        OButton r15 = this.btnPrimary;
        if (r15 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("btnPrimary");
        r15 = null;
    L14:
        r15.bringToFront();
        OButton r16 = this.btnPrimary;
        if (r16 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("btnPrimary");
        r16 = null;
    L17:
        r16.setTranslationZ(com.obric.oui.common.util.h.a(24.0f));
        View r17 = this.layoutTopbar;
        if (r17 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("layoutTopbar");
        r17 = null;
    L20:
        View r18 = this.layoutTopbar;
        if (r18 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("layoutTopbar");
        r18 = null;
    L23:
        Drawable r19 = r18.getBackground();
        if (r19 == null) goto L26;
        Drawable r20 = r19.mutate();
    L27:
        r17.setBackground(r20);
        FrameLayout r21 = this.layoutOptionGroup;
        if (r21 != null) goto L30;
        Intrinsics.throwUninitializedPropertyAccessException("layoutOptionGroup");
        r21 = null;
    L30:
        FrameLayout r22 = this.layoutOptionGroup;
        if (r22 != null) goto L33;
        Intrinsics.throwUninitializedPropertyAccessException("layoutOptionGroup");
        r22 = null;
    L33:
        Drawable r23 = r22.getBackground();
        if (r23 == null) goto L36;
        r12 = r23.mutate();
    L36:
        r21.setBackground(r12);
        getWindow().getDecorView().setOnApplyWindowInsetsListener(new $$Lambda$GuidedPreferenceInterviewActivity$8Ixoldq1IDZQHu6ofroeCzXh5c(this));
        return;
    L26:
        r20 = null;
        goto L27
    }

    private static final void bindViews$lambda$2(GuidedPreferenceInterviewActivity r1, View r2) {
        ((GuidedPreferenceInterviewActivity) ZeusTransformUtils.wrapperContextForParams(r1, GuidedPreferenceInterviewActivity.class, "com.obric.memorydata.plugin")).handleBackOrClose();
    }

    private static final void bindViews$lambda$3(GuidedPreferenceInterviewActivity r1, View r2) {
        ((GuidedPreferenceInterviewActivity) ZeusTransformUtils.wrapperContextForParams(r1, GuidedPreferenceInterviewActivity.class, "com.obric.memorydata.plugin")).handleCloseAction();
    }

    private static final void bindViews$lambda$4(GuidedPreferenceInterviewActivity r1, View r2) {
        ((GuidedPreferenceInterviewActivity) ZeusTransformUtils.wrapperContextForParams(r1, GuidedPreferenceInterviewActivity.class, "com.obric.memorydata.plugin")).handlePrimaryAction();
    }

    private static final WindowInsets bindViews$lambda$8(GuidedPreferenceInterviewActivity r11, View r12, WindowInsets r13) {
        GuidedPreferenceInterviewActivity r14 = (GuidedPreferenceInterviewActivity) ZeusTransformUtils.wrapperContextForParams(r11, GuidedPreferenceInterviewActivity.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r12, "<unused var>");
        Intrinsics.checkNotNullParameter(r13, "insets");
        WindowInsetsCompat r15 = WindowInsetsCompat.toWindowInsetsCompat(r13);
        Intrinsics.checkNotNullExpressionValue(r15, "toWindowInsetsCompat(...)");
        int r0 = r15.getInsets(WindowInsetsCompat.Type.statusBars()).top;
        int r2 = r15.getInsets(WindowInsetsCompat.Type.navigationBars()).bottom;
        int r16 = r15.getInsets(WindowInsetsCompat.Type.ime()).bottom;
        int r4 = 0;
        int r3 = RangesKt.coerceAtLeast(r16 - r2, 0);
        if (r3 <= 0) goto L5;
        float r5 = 1.0f;
    L6:
        int r6 = ((int) com.obric.oui.common.util.h.a(12.0f)) + r0;
        int r1 = r14.resolveKeyboardContentLift(r3, r0, r16);
        int r17 = i.f6773a.a(r2, r16, (int) com.obric.oui.common.util.h.a(31.0f));
        View r7 = r14.btnBack;
        ONestedScrollView r8 = null;
        if (r7 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("btnBack");
        r7 = null;
    L9:
        View r9 = r14.btnBack;
        if (r9 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("btnBack");
        r9 = null;
    L12:
        ViewGroup.LayoutParams r10 = r9.getLayoutParams();
        Intrinsics.checkNotNull(r10, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams r18 = (ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r10, ViewGroup.MarginLayoutParams.class, "com.obric.memorydata.plugin");
        r18.topMargin = r6;
        r7.setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r18, ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin"));
        View r19 = r14.btnClose;
        if (r19 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("btnClose");
        r19 = null;
    L15:
        View r110 = r14.btnClose;
        if (r110 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("btnClose");
        r110 = null;
    L18:
        ViewGroup.LayoutParams r20 = r110.getLayoutParams();
        Intrinsics.checkNotNull(r20, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams r21 = (ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r20, ViewGroup.MarginLayoutParams.class, "com.obric.memorydata.plugin");
        r21.topMargin = r6;
        r19.setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r21, ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin"));
        OButton r22 = r14.btnPrimary;
        if (r22 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("btnPrimary");
        r22 = null;
    L21:
        OButton r23 = r14.btnPrimary;
        if (r23 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("btnPrimary");
        r23 = null;
    L24:
        ViewGroup.LayoutParams r24 = r23.getLayoutParams();
        Intrinsics.checkNotNull(r24, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams r25 = (ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r24, ViewGroup.MarginLayoutParams.class, "com.obric.memorydata.plugin");
        r25.bottomMargin = r17;
        r22.setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r25, ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin"));
        r14.applyScrollableContentBottomPadding(r17);
        View r111 = r14.keyboardBlurView;
        if (r111 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException("keyboardBlurView");
        r111 = null;
    L27:
        r111.setAlpha(r5);
        if (r3 > 0) goto L31;
        r4 = 255;
    L31:
        View r26 = r14.layoutTopbar;
        if (r26 != null) goto L34;
        Intrinsics.throwUninitializedPropertyAccessException("layoutTopbar");
        r26 = null;
    L34:
        Drawable r27 = r26.getBackground();
        if (r27 == null) goto L37;
        r27.setAlpha(r4);
    L37:
        FrameLayout r28 = r14.layoutOptionGroup;
        if (r28 != null) goto L40;
        Intrinsics.throwUninitializedPropertyAccessException("layoutOptionGroup");
        r28 = null;
    L40:
        Drawable r29 = r28.getBackground();
        if (r29 == null) goto L43;
        r29.setAlpha(255);
    L43:
        ONestedScrollView r112 = r14.scrollContent;
        if (r112 != null) goto L46;
        Intrinsics.throwUninitializedPropertyAccessException("scrollContent");
    L47:
        r8.setTranslationY(-r1);
        return r13;
    L46:
        r8 = r112;
        goto L47
    L5:
        r5 = 0.0f;
        goto L6
    }

    private final void completeInterview() {
        List<String> r0 = p.f6788a.a(this.state);
        this.isCompleting = true;
        setCompletingUiLocked(true);
        kotlinx.coroutines.i.a((al) ZeusTransformUtils.preCheckCast(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) ZeusTransformUtils.preCheckCast(this, LifecycleOwner.class, "com.obric.memorydata.plugin")), al.class, "com.obric.memorydata.plugin"), null, null, (Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this, r0, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
    }

    private final IProactiveService getProactiveService() {
        return (IProactiveService) ZeusTransformUtils.preCheckCast(this.proactiveService$delegate.getValue(), IProactiveService.class, "com.obric.memorydata.plugin");
    }

    private final void handleBackOrClose() {
        if (i.f6773a.a(this.isCompleting) == true) goto L5;
        return;
    L5:
        int r0 = this.pageIndex;
        if (r0 <= 0) goto L12;
        this.pageIndex = r0 - 1;
        ONestedScrollView r1 = null;
        renderPage$default(this, null, 1, null);
        ONestedScrollView r2 = this.scrollContent;
        if (r2 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("scrollContent");
    L11:
        r1.scrollTo(0, 0);
        return;
    L10:
        r1 = r2;
        goto L11
    L12:
        showCloseConfirmation();
    }

    private final void handleCloseAction() {
        if (i.f6773a.a(this.isCompleting) == true) goto L5;
        return;
    L5:
        showCloseConfirmation();
    }

    private final void handleInputFocusRequested(View r4) {
        this.focusedInputView = r4;
        getWindow().getDecorView().requestApplyInsets();
        r4.post(new $$Lambda$GuidedPreferenceInterviewActivity$yytH4PBnCrndruBK4pn8meB30(this));
        r4.postDelayed(new $$Lambda$GuidedPreferenceInterviewActivity$VIRhX8lflwGBOPzQrF45DEfKgxw(this), 120);
    }

    private static final void handleInputFocusRequested$lambda$13(GuidedPreferenceInterviewActivity r2) {
        ((GuidedPreferenceInterviewActivity) ZeusTransformUtils.wrapperContextForParams(r2, GuidedPreferenceInterviewActivity.class, "com.obric.memorydata.plugin")).getWindow().getDecorView().requestApplyInsets();
    }

    private static final void handleInputFocusRequested$lambda$14(GuidedPreferenceInterviewActivity r2) {
        ((GuidedPreferenceInterviewActivity) ZeusTransformUtils.wrapperContextForParams(r2, GuidedPreferenceInterviewActivity.class, "com.obric.memorydata.plugin")).getWindow().getDecorView().requestApplyInsets();
    }

    private final void handlePrimaryAction() {
        if (i.f6773a.a(this.isCompleting) == true) goto L6;
        return;
    L6:
        if (i.f6773a.a(this.state, this.pageIndex) == true) goto L10;
        Toast.makeText((Context) ZeusTransformUtils.preCheckCast(this, Context.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("请填写 100 字以内的有效内容", CharSequence.class, "com.obric.memorydata.plugin"), 0).show();
        return;
    L10:
        if (this.pageIndex >= CollectionsKt.getLastIndex(this.pages)) goto L17;
        this.pageIndex++;
        ONestedScrollView r0 = null;
        renderPage$default(this, null, 1, null);
        ONestedScrollView r4 = this.scrollContent;
        if (r4 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("scrollContent");
    L15:
        r0.scrollTo(0, 0);
        return;
    L14:
        r0 = r4;
        goto L15
    L17:
        completeInterview();
    }

    private final void hideGuidedInputKeyboard() {
        View r0 = getCurrentFocus();
        if (r0 != null) goto L10;
        RecyclerView r1 = this.rvOptions;
        if (r1 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("rvOptions");
        r1 = null;
    L7:
        r0 = r1.findFocus();
        if (r0 != null) goto L10;
        r0 = getWindow().getDecorView().findFocus();
    L10:
        if (r0 == null) goto L12;
        r0.clearFocus();
    L12:
        if (r0 == null) goto L15;
        IBinder r2 = r0.getWindowToken();
        if (r2 == null) goto L15;
    L16:
        InputMethodManager r3 = (InputMethodManager) ZeusTransformUtils.preCheckCast(ContextCompat.getSystemService((Context) ZeusTransformUtils.preCheckCast(this, Context.class, "com.obric.memorydata.plugin"), InputMethodManager.class), InputMethodManager.class, "com.obric.memorydata.plugin");
        if (r3 == null) goto L20;
        r3.hideSoftInputFromWindow(r2, 0);
        return;
    L20:
        return;
    L15:
        r2 = getWindow().getDecorView().getWindowToken();
        goto L16
    }

    /* JADX INFO: renamed from: lambda$-ObqYU5esceVRCj2t9k9G7sskwk, reason: not valid java name */
    public static /* synthetic */ Unit m322lambda$ObqYU5esceVRCj2t9k9G7sskwk(DialogInterface r0, int r1) {
        return showCloseConfirmation$lambda$17(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$8Ixol-dq1IDZQHu6ofroeCzXh5c, reason: not valid java name */
    public static /* synthetic */ WindowInsets m323lambda$8Ixoldq1IDZQHu6ofroeCzXh5c(GuidedPreferenceInterviewActivity r0, View r1, WindowInsets r2) {
        return bindViews$lambda$8(r0, r1, r2);
    }

    /* JADX INFO: renamed from: lambda$UasUkFh-EpHqv4h6iA8O4dDIdcU, reason: not valid java name */
    public static /* synthetic */ void m324lambda$UasUkFhEpHqv4h6iA8O4dDIdcU(GuidedPreferenceInterviewActivity r0, View r1) {
        bindViews$lambda$2(r0, r1);
    }

    public static /* synthetic */ void lambda$VIRhX8lflwGBOPzQrF45DEfKgxw(GuidedPreferenceInterviewActivity r0) {
        handleInputFocusRequested$lambda$14(r0);
    }

    /* JADX INFO: renamed from: lambda$VnbqM7fF4xp-HMDuSPxcK1w4H8o, reason: not valid java name */
    public static /* synthetic */ IProactiveService m325lambda$VnbqM7fF4xpHMDuSPxcK1w4H8o() {
        return proactiveService_delegate$lambda$0();
    }

    public static /* synthetic */ void lambda$VxeaW_o_KYOvNIXp2jgnAi8gXKY(GuidedPreferenceInterviewActivity r0, View r1) {
        bindViews$lambda$4(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$XNluxX7zjOUyfQQVLF8hDNJ-dE0, reason: not valid java name */
    public static /* synthetic */ Unit m326lambda$XNluxX7zjOUyfQQVLF8hDNJdE0(GuidedPreferenceInterviewActivity r0, m r1) {
        return setupOptions$lambda$10(r0, r1);
    }

    public static /* synthetic */ Unit lambda$dXexvbmnWlM7ldKrfqyXAoyrbe4(GuidedPreferenceInterviewActivity r0, View r1) {
        return setupOptions$lambda$12(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$fa4Tci8I4DMrxGF15gTp-TyUuxc, reason: not valid java name */
    public static /* synthetic */ void m327lambda$fa4Tci8I4DMrxGF15gTpTyUuxc(GuidedPreferenceInterviewActivity r0, View r1) {
        bindViews$lambda$3(r0, r1);
    }

    public static /* synthetic */ Unit lambda$un2Om83bsZm8A33om0EC18e8Gb4(GuidedPreferenceInterviewActivity r0, DialogInterface r1, int r2) {
        return showCloseConfirmation$lambda$18(r0, r1, r2);
    }

    public static /* synthetic */ Unit lambda$uuVVyCsbDlX033e8bjSQCVXcyJs(GuidedPreferenceInterviewActivity r0, m r1, String r2) {
        return setupOptions$lambda$11(r0, r1, r2);
    }

    /* JADX INFO: renamed from: lambda$y-yt-H4PBnCrndruBK4pn8meB30, reason: not valid java name */
    public static /* synthetic */ void m328lambda$yytH4PBnCrndruBK4pn8meB30(GuidedPreferenceInterviewActivity r0) {
        handleInputFocusRequested$lambda$13(r0);
    }

    private final void navigateToRulePage() {
        Intent r0 = getIntent();
        if (r0 == null) goto L5;
        String r1 = r0.getStringExtra("enter_from");
    L6:
        String r2 = com.obric.aiproactive.ui.util.n.a(r1);
        Intent r3 = new Intent((Context) ZeusTransformUtils.preCheckCast(this, Context.class, "com.obric.memorydata.plugin"), AiRuleActivity.class);
        r3.addFlags(603979776);
        r3.putExtra("enter_from", r2);
        r3.putExtra("previous_page", "interview");
        ZeusTransformUtils.startActivity(this, r3, "com.obric.memorydata.plugin");
        finish();
        return;
    L5:
        r1 = null;
        goto L6
    }

    private static final IProactiveService proactiveService_delegate$lambda$0() {
        return (IProactiveService) ZeusTransformUtils.preCheckCast(com.bytedance.news.common.service.manager.d.a(IProactiveService.class), IProactiveService.class, "com.obric.memorydata.plugin");
    }

    private final void renderPage(String r8) {
        o r0 = (o) ZeusTransformUtils.preCheckCast(this.pages.get(this.pageIndex), o.class, "com.obric.memorydata.plugin");
        TextView r1 = this.tvProgress;
        n r3 = null;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("tvProgress");
        r1 = null;
    L5:
        r1.setText((CharSequence) ZeusTransformUtils.preCheckCast(new StringBuilder().append(this.pageIndex + 1).append('/').append(this.pages.size()).toString(), CharSequence.class, "com.obric.memorydata.plugin"));
        TextView r2 = this.tvTitle;
        if (r2 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("tvTitle");
        r2 = null;
    L8:
        r2.setText((CharSequence) ZeusTransformUtils.preCheckCast(r0.a(), CharSequence.class, "com.obric.memorydata.plugin"));
        TextView r4 = this.tvSubtitle;
        if (r4 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("tvSubtitle");
        r4 = null;
    L11:
        r4.setText((CharSequence) ZeusTransformUtils.preCheckCast(r0.b(), CharSequence.class, "com.obric.memorydata.plugin"));
        OButton r5 = this.btnPrimary;
        if (r5 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("btnPrimary");
        r5 = null;
    L14:
        r5.setText((CharSequence) ZeusTransformUtils.preCheckCast(i.f6773a.a(this.pageIndex, this.pages.size()), CharSequence.class, "com.obric.memorydata.plugin"));
        View r6 = this.btnBack;
        if (r6 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("btnBack");
        r6 = null;
    L18:
        if (this.pageIndex != 0) goto L20;
        int r7 = 8;
    L21:
        r6.setVisibility(r7);
        updatePrimaryButtonState();
        n r9 = this.optionAdapter;
        if (r9 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("optionAdapter");
    L25:
        r3.a(r0, this.state, r8);
        return;
    L24:
        r3 = r9;
        goto L25
    L20:
        r7 = 0;
        goto L21
    }

    static /* synthetic */ void renderPage$default(GuidedPreferenceInterviewActivity r1, String r2, int r3, Object r4) {
        GuidedPreferenceInterviewActivity r5 = (GuidedPreferenceInterviewActivity) ZeusTransformUtils.wrapperContextForParams(r1, GuidedPreferenceInterviewActivity.class, "com.obric.memorydata.plugin");
        if ((r3 & 1) == 0) goto L5;
        r2 = null;
    L5:
        r5.renderPage(r2);
    }

    private final int resolveKeyboardContentLift(int r7, int r8, int r9) {
        View r0 = this.focusedInputView;
        if (r0 != null) goto L5;
    L34:
        return 0;
    L5:
        if (r0.isAttachedToWindow() == true) goto L7;
    L9:
        boolean r2 = false;
    L10:
        ONestedScrollView r4 = null;
        if (r2 == true) goto L14;
        r0 = null;
    L14:
        if (r0 == null) goto L34;
        if (r7 <= 0) goto L34;
        if (r9 <= 0) goto L34;
        int[] r10 = new int[2];
        r0.getLocationOnScreen(r10);
        ONestedScrollView r3 = this.scrollContent;
        if (r3 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("scrollContent");
        r3 = null;
    L22:
        int r11 = (r10[1] + r0.getHeight()) + RangesKt.coerceAtLeast(MathKt.roundToInt(-r3.getTranslationY()), 0);
        int r1 = getWindow().getDecorView().getHeight() - r9;
        FrameLayout r12 = this.layoutOptionGroup;
        if (r12 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("layoutOptionGroup");
        r12 = null;
    L25:
        int r13 = r12.getTop();
        FrameLayout r5 = this.layoutOptionGroup;
        if (r5 != null) goto L28;
        Intrinsics.throwUninitializedPropertyAccessException("layoutOptionGroup");
        r5 = null;
    L28:
        int r14 = r13 + r5.getHeight();
        ONestedScrollView r6 = this.scrollContent;
        if (r6 != null) goto L31;
        Intrinsics.throwUninitializedPropertyAccessException("scrollContent");
    L32:
        int r15 = (r14 - r4.getScrollY()) - r8;
        a r16 = Companion;
        return i.f6773a.a(r11, r1, r16.a(), RangesKt.coerceAtLeast(r15 - r16.b(), 0));
    L31:
        r4 = r6;
        goto L32
    L7:
        if (r0.isShown() == false) goto L9;
        r2 = true;
        goto L10
    }

    private final void setCompletingUiLocked(boolean r4) {
        OButton r0 = this.btnPrimary;
        View r1 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("btnPrimary");
        r0 = null;
    L5:
        r0.setEnabled(!r4);
        View r2 = this.btnBack;
        if (r2 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("btnBack");
        r2 = null;
    L8:
        r2.setEnabled(!r4);
        View r3 = this.btnClose;
        if (r3 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("btnClose");
    L12:
        r1.setEnabled(!r4);
        return;
    L11:
        r1 = r3;
        goto L12
    }

    private final void setupOptions() {
        getWindow().setSoftInputMode(48);
        this.optionAdapter = new n(new $$Lambda$GuidedPreferenceInterviewActivity$XNluxX7zjOUyfQQVLF8hDNJdE0(this), new $$Lambda$GuidedPreferenceInterviewActivity$uuVVyCsbDlX033e8bjSQCVXcyJs(this), new $$Lambda$GuidedPreferenceInterviewActivity$dXexvbmnWlM7ldKrfqyXAoyrbe4(this));
        RecyclerView r0 = this.rvOptions;
        RecyclerView r2 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("rvOptions");
        r0 = null;
    L5:
        r0.setLayoutManager((RecyclerView.h) ZeusTransformUtils.preCheckCast(new LinearLayoutManager((Context) ZeusTransformUtils.preCheckCast(this, Context.class, "com.obric.memorydata.plugin")), RecyclerView.h.class, "com.obric.memorydata.plugin"));
        RecyclerView r1 = this.rvOptions;
        if (r1 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("rvOptions");
        r1 = null;
    L8:
        n r3 = this.optionAdapter;
        if (r3 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("optionAdapter");
        r3 = null;
    L11:
        r1.setAdapter((RecyclerView.Adapter) ZeusTransformUtils.preCheckCast(r3, RecyclerView.Adapter.class, "com.obric.memorydata.plugin"));
        RecyclerView r6 = this.rvOptions;
        if (r6 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("rvOptions");
    L15:
        r2.setNestedScrollingEnabled(false);
        return;
    L14:
        r2 = r6;
        goto L15
    }

    private static final Unit setupOptions$lambda$10(GuidedPreferenceInterviewActivity r3, m r4) {
        GuidedPreferenceInterviewActivity r5 = (GuidedPreferenceInterviewActivity) ZeusTransformUtils.wrapperContextForParams(r3, GuidedPreferenceInterviewActivity.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "option");
        boolean r0 = r5.state.c(r4.a());
        j r1 = r5.state.b(r4.a());
        r5.state = r1;
        if (r0 == false) goto L5;
    L9:
        boolean r2 = false;
    L10:
        String r6 = null;
        if (r0 == false) goto L16;
        if (r4.f() == false) goto L16;
    L17:
        r5.focusedInputView = null;
        r5.hideGuidedInputKeyboard();
    L18:
        if (r2 == false) goto L20;
        r6 = r4.a();
    L20:
        r5.renderPage(r6);
        return Unit.INSTANCE;
    L16:
        if (r4.f() == true) goto L18;
    L5:
        if (r1.c(r4.a()) == false) goto L9;
        if (r4.f() == false) goto L9;
        r2 = true;
        goto L10
    }

    private static final Unit setupOptions$lambda$11(GuidedPreferenceInterviewActivity r2, m r3, String r4) {
        GuidedPreferenceInterviewActivity r5 = (GuidedPreferenceInterviewActivity) ZeusTransformUtils.wrapperContextForParams(r2, GuidedPreferenceInterviewActivity.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "option");
        Intrinsics.checkNotNullParameter(r4, "input");
        r5.state = r5.state.a(r3.a(), r4);
        r5.updatePrimaryButtonState();
        return Unit.INSTANCE;
    }

    private static final Unit setupOptions$lambda$12(GuidedPreferenceInterviewActivity r2, View r3) {
        GuidedPreferenceInterviewActivity r4 = (GuidedPreferenceInterviewActivity) ZeusTransformUtils.wrapperContextForParams(r2, GuidedPreferenceInterviewActivity.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "inputView");
        r4.handleInputFocusRequested(r3);
        return Unit.INSTANCE;
    }

    private final void setupWindow() {
        WindowCompat.setDecorFitsSystemWindows(getWindow(), false);
        getWindow().setStatusBarColor(0);
        WindowInsetsControllerCompat r0 = new WindowInsetsControllerCompat(getWindow(), getWindow().getDecorView());
        r0.setAppearanceLightStatusBars(false);
        r0.setAppearanceLightNavigationBars(false);
    }

    private final void showCloseConfirmation() {
        TextView r5 = null;
        com.obric.oui.dialog.v2.alert.a r6 = (com.obric.oui.dialog.v2.alert.a) ZeusTransformUtils.preCheckCast(com.obric.oui.dialog.v2.alert.b.a(new com.obric.oui.dialog.v2.alert.b((Context) ZeusTransformUtils.preCheckCast(this, Context.class, "com.obric.memorydata.plugin")), (CharSequence) ZeusTransformUtils.preCheckCast("离开本次访谈", CharSequence.class, "com.obric.memorydata.plugin"), false, 2, null).a((CharSequence) ZeusTransformUtils.preCheckCast("现在离开，豆包将不会记得你提供过的信息，也无法很快地熟悉你的需求并达到最佳状态。", CharSequence.class, "com.obric.memorydata.plugin")).b((CharSequence) ZeusTransformUtils.preCheckCast("取消", CharSequence.class, "com.obric.memorydata.plugin"), $$Lambda$GuidedPreferenceInterviewActivity$ObqYU5esceVRCj2t9k9G7sskwk.INSTANCE).a((CharSequence) ZeusTransformUtils.preCheckCast("离开", CharSequence.class, "com.obric.memorydata.plugin"), new $$Lambda$GuidedPreferenceInterviewActivity$un2Om83bsZm8A33om0EC18e8Gb4(this)).c(true).g(), com.obric.oui.dialog.v2.alert.a.class, "com.obric.memorydata.plugin");
        r6.show();
        TextView r0 = r6.f();
        if (r0 == null) goto L5;
        r0.setGravity(17);
    L5:
        View r7 = r6.g();
        if (ZeusTransformUtils.instanceOf(r7, TextView.class) == false) goto L8;
        r5 = (TextView) ZeusTransformUtils.preCheckCast(r7, TextView.class, "com.obric.memorydata.plugin");
    L8:
        if (r5 == null) goto L11;
        r5.setTextColor(Color.rgb(255, 59, 48));
        return;
    }

    private static final Unit showCloseConfirmation$lambda$17(DialogInterface r1, int r2) {
        DialogInterface r3 = (DialogInterface) ZeusTransformUtils.wrapperContextForParams(r1, DialogInterface.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "dialog");
        r3.dismiss();
        return Unit.INSTANCE;
    }

    private static final Unit showCloseConfirmation$lambda$18(GuidedPreferenceInterviewActivity r1, DialogInterface r2, int r3) {
        GuidedPreferenceInterviewActivity r4 = (GuidedPreferenceInterviewActivity) ZeusTransformUtils.wrapperContextForParams(r1, GuidedPreferenceInterviewActivity.class, "com.obric.memorydata.plugin");
        DialogInterface r5 = (DialogInterface) ZeusTransformUtils.wrapperContextForParams(r2, DialogInterface.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "dialog");
        r5.dismiss();
        r4.finish();
        return Unit.INSTANCE;
    }

    private final void updatePrimaryButtonState() {
        OButton r0 = this.btnPrimary;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("btnPrimary");
        r0 = null;
    L5:
        int r1 = ((Collection) ZeusTransformUtils.preCheckCast(this.pages, Collection.class, "com.obric.memorydata.plugin")).size();
        int r2 = this.pageIndex;
        boolean r3 = true;
        if (r2 < 0) goto L9;
        if (r2 >= r1) goto L9;
        boolean r4 = true;
    L10:
        if (r4 == true) goto L12;
    L14:
        r3 = false;
    L15:
        r0.setEnabled(r3);
        return;
    L12:
        if (this.isCompleting == true) goto L14;
    L9:
        r4 = false;
        goto L10
    }

    public void finish() {
        super.finish();
        com.obric.memorydata.ui.h.f13009a.d((Activity) ZeusTransformUtils.preCheckCast(this, Activity.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.aiproactive.ui.entry.BaseProactiveActivity
    public NavigationBarScheme getNavigationBarScheme() {
        return this.navigationBarScheme;
    }

    @Override // com.obric.aiproactive.ui.entry.BaseProactiveActivity
    public boolean needLoginCheckOnCreate() {
        return true;
    }

    @Override // com.obric.aiproactive.ui.entry.BaseProactiveActivity
    public boolean needLoginCheckOnResume() {
        return true;
    }

    @Override // androidx.activity.ComponentActivity
    public void onBackPressed() {
        handleBackOrClose();
    }

    @Override // com.obric.aiproactive.ui.entry.BaseProactiveActivity
    public void onCreateChecked(Bundle r4) {
        com.obric.memorydata.ui.h.f13009a.b((Activity) ZeusTransformUtils.preCheckCast(this, Activity.class, "com.obric.memorydata.plugin"));
        Intent r5 = getIntent();
        String r0 = null;
        if (r5 == null) goto L5;
        String r6 = r5.getStringExtra(AILabCheckPermissionTask.KEY_SOURCE);
    L6:
        this.source = r6;
        setContentView(ZeusTransformUtils.mapRes(R.layout.activity_guided_preference_interview, "layout", "activity_guided_preference_interview"));
        setupWindow();
        bindViews();
        setupOptions();
        renderPage$default(this, null, 1, null);
        String r7 = f.a(this.source);
        com.obric.aiproactive.ui.util.h r1 = com.obric.aiproactive.ui.util.h.f6884a;
        Intent r3 = getIntent();
        if (r3 == null) goto L9;
        r0 = r3.getStringExtra("enter_from");
    L9:
        r1.b("interview", r7, com.obric.aiproactive.ui.util.n.a(r0), "click");
        return;
    L5:
        r6 = null;
        goto L6
    }
}
