package com.obric.memorydata.memory.ui.settings;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.security.obric.guard.ObricSecurityGuardStub;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.TextView;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.memorydata.memory.databinding.ActivitySmartMemorySettingsBinding;
import com.obric.memorydata.memory.ui.BaseMemoryActivity;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.plugin.R;
import com.obric.memorydata.utils.ba;
import com.obric.oui.bouncelayout.ONestedScrollView;
import com.obric.oui.oswitch.OSwitch;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.obric.oui.window.permission.WebViewActivity;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.al;
import kotlinx.coroutines.flow.ar;
import net.zetetic.database.sqlcipher.SQLiteDatabase;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 22\u00020\u0001:\u00012B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0014J\b\u0010\u001c\u001a\u00020\u0019H\u0016J\b\u0010\u001d\u001a\u00020\u0019H\u0016J\b\u0010\u001e\u001a\u00020\u0019H\u0002J\b\u0010\u001f\u001a\u00020\u0019H\u0002J\b\u0010 \u001a\u00020\u0019H\u0002J\u0018\u0010!\u001a\u00020\u00192\u0006\u0010\"\u001a\u00020\u000e2\u0006\u0010#\u001a\u00020\u0010H\u0002J\b\u0010$\u001a\u00020\u0019H\u0002J\u0014\u0010%\u001a\u00020\u00192\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u000eH\u0002J\b\u0010&\u001a\u00020\u0019H\u0002J\u0012\u0010'\u001a\u00020\u00192\b\b\u0002\u0010(\u001a\u00020\u0010H\u0002J\b\u0010)\u001a\u00020\u0019H\u0002J\b\u0010*\u001a\u00020\u0019H\u0002J\b\u0010+\u001a\u00020\u0019H\u0002J\b\u0010,\u001a\u00020-H\u0002J\b\u0010.\u001a\u00020\u0019H\u0002J\b\u0010/\u001a\u00020\u0019H\u0014J\b\u00100\u001a\u00020\u0019H\u0014J\b\u00101\u001a\u00020\u0019H\u0014R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\fR\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00063"}, d2 = {"Lcom/obric/memorydata/memory/ui/settings/SmartMemorySettingsActivity;", "Lcom/obric/memorydata/memory/ui/BaseMemoryActivity;", "<init>", "()V", "binding", "Lcom/obric/memorydata/memory/databinding/ActivitySmartMemorySettingsBinding;", "adapter", "Lcom/obric/memorydata/memory/ui/settings/AppSettingsAdapter;", "viewModel", "Lcom/obric/memorydata/memory/ui/settings/SmartMemorySettingsViewModel;", "preEnabledAppCount", "", "Ljava/lang/Integer;", "pendingAccessibilityPackageName", "", "pendingMainSwitchAccessibility", "", "awaitingAccessibilityResult", "accessibilityPromptDialog", "Lcom/obric/oui/dialog/v2/alert/OAlertDialog;", "accessibilityPromptPackageName", "accessibilityPromptForMainSwitch", "smartMemoryCheckListener", "Landroid/widget/CompoundButton$OnCheckedChangeListener;", "onCreateChecked", "", "savedInstanceState", "Landroid/os/Bundle;", "finish", "onBackPressed", "initViews", "observeState", "observeAccessibilityState", "handleAppSettingChange", ObricMemoryConstants.KEY_PACKAGE_NAME, "enabled", "continueEnableSmartMemory", "showEnableAppConfirmDialog", "showAccessibilityPermissionDialog", "clearAccessibilityPrompt", "dismiss", "clearPendingAccessibilityRequest", "completeAccessibilityPromptIfEnabled", "reconcilePendingAccessibilityRequest", "buildA11yContentView", "Landroid/view/View;", "showDisableSmartMemoryDialog", "onResume", "onPause", "onDestroy", "Companion", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class SmartMemorySettingsActivity extends BaseMemoryActivity {
    public static final a Companion = null;
    private static final String PRIVACY_STATEMENT_URL = "https://os.obriccloud.com/agreement/memory_privacy";
    private static final int REQUEST_CODE_ACCESSIBILITY = 1001;
    private static final String TAG = "SmartMemorySettingsActivity";
    private com.obric.oui.dialog.v2.alert.a accessibilityPromptDialog;
    private boolean accessibilityPromptForMainSwitch;
    private String accessibilityPromptPackageName;
    private AppSettingsAdapter adapter;
    private boolean awaitingAccessibilityResult;
    private ActivitySmartMemorySettingsBinding binding;
    private String pendingAccessibilityPackageName;
    private boolean pendingMainSwitchAccessibility;
    private Integer preEnabledAppCount;
    private final CompoundButton.OnCheckedChangeListener smartMemoryCheckListener;
    private final SmartMemorySettingsViewModel viewModel;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/obric/memorydata/memory/ui/settings/SmartMemorySettingsActivity$Companion;", "", "<init>", "()V", "TAG", "", "PRIVACY_STATEMENT_URL", "REQUEST_CODE_ACCESSIBILITY", "", CommonConsts.APM_INNER_EVENT_COST_START, "", "context", "Landroid/content/Context;", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }

        public final void a(Context r4) {
            Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, "context");
            Intent r5 = new Intent(r3, SmartMemorySettingsActivity.class);
            if (((Activity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(ba.b(r3), "com.obric.memorydata.plugin"), Activity.class, "com.obric.memorydata.plugin")) != null) goto L5;
            r5.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
        L5:
            ZeusTransformUtils.startActivity(r3, r5, "com.obric.memorydata.plugin");
        }
    }

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"com/obric/memorydata/memory/ui/settings/SmartMemorySettingsActivity$showAccessibilityPermissionDialog$clickableSpan$1", "Landroid/text/style/ClickableSpan;", "onClick", "", "widget", "Landroid/view/View;", "updateDrawState", "ds", "Landroid/text/TextPaint;", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class b extends ClickableSpan {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ SmartMemorySettingsActivity f11421a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f11422b;

        b(SmartMemorySettingsActivity r3, String r4) {
            this.f11421a = (SmartMemorySettingsActivity) ZeusTransformUtils.wrapperContextForParams(r3, SmartMemorySettingsActivity.class, "com.obric.memorydata.plugin");
            this.f11422b = r4;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View r3) {
            Intrinsics.checkNotNullParameter(r3, "widget");
            WebViewActivity.open((Context) ZeusTransformUtils.preCheckCast(this.f11421a, Context.class, "com.obric.memorydata.plugin"), SmartMemorySettingsActivity.PRIVACY_STATEMENT_URL, this.f11422b, true);
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint r4) {
            Intrinsics.checkNotNullParameter(r4, "ds");
            super.updateDrawState(r4);
            r4.setColor(ContextCompat.getColor((Context) ZeusTransformUtils.preCheckCast(this.f11421a, Context.class, "com.obric.memorydata.plugin"), ZeusTransformUtils.mapRes(R.color.oui_fill_highlighted, TypedValues.Custom.S_COLOR, "oui_fill_highlighted")));
            r4.setUnderlineText(false);
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.settings.SmartMemorySettingsActivity$initViews$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function0<Unit> {
        AnonymousClass1(Object r8) {
            super(0, r8, SmartMemorySettingsActivity.class, "onBackPressed", "onBackPressed()V", 0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            ((SmartMemorySettingsActivity) ZeusTransformUtils.preCheckCast(this.receiver, SmartMemorySettingsActivity.class, "com.obric.memorydata.plugin")).onBackPressed();
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.settings.SmartMemorySettingsActivity$observeAccessibilityState$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.memory.ui.settings.SmartMemorySettingsActivity$observeAccessibilityState$1", f = "SmartMemorySettingsActivity.kt", i = {}, l = {168}, m = "invokeSuspend", n = {}, s = {})
    static final class C12101 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ SmartMemorySettingsActivity this$0;

        C12101(SmartMemorySettingsActivity r3, Continuation<? super C12101> r4) {
            SmartMemorySettingsActivity r5 = (SmartMemorySettingsActivity) ZeusTransformUtils.wrapperContextForParams(r3, SmartMemorySettingsActivity.class, "com.obric.memorydata.plugin");
            Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r5;
            super(2, r6);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            Continuation r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new C12101(this.this$0, r4), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
            return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(al r3, Continuation<? super Unit> r4) {
            return ((C12101) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), C12101.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r6) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L6;
            ResultKt.throwOnFailure(r6);
        L12:
            throw new KotlinNothingValueException();
        L6:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r6);
            ar<com.obric.memorydata.screencapture.accessibility.c.a> r7 = com.obric.memorydata.screencapture.accessibility.c.f12773a.a();
            final SmartMemorySettingsActivity r3 = this.this$0;
            kotlinx.coroutines.flow.j<? super com.obric.memorydata.screencapture.accessibility.c.a> r2 = (kotlinx.coroutines.flow.j) ZeusTransformUtils.preCheckCast(new C06171(r3), kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin");
            Continuation<?> r4 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 1;
            if (r7.collect(r2, r4) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.settings.SmartMemorySettingsActivity$observeState$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.memory.ui.settings.SmartMemorySettingsActivity$observeState$1", f = "SmartMemorySettingsActivity.kt", i = {}, l = {140}, m = "invokeSuspend", n = {}, s = {})
    static final class C12111 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ SmartMemorySettingsActivity this$0;

        /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.settings.SmartMemorySettingsActivity$observeState$1$1, reason: invalid class name and collision with other inner class name */
        @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
        static final class C06181<T> implements kotlinx.coroutines.flow.j {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ SmartMemorySettingsActivity f11424a;

            C06181(SmartMemorySettingsActivity r3) {
                this.f11424a = (SmartMemorySettingsActivity) ZeusTransformUtils.wrapperContextForParams(r3, SmartMemorySettingsActivity.class, "com.obric.memorydata.plugin");
            }

            private static final void a(SmartMemorySettingsActivity r7) {
                SmartMemorySettingsActivity r8 = (SmartMemorySettingsActivity) ZeusTransformUtils.wrapperContextForParams(r7, SmartMemorySettingsActivity.class, "com.obric.memorydata.plugin");
                IRunLog r1 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
                StringBuilder r0 = new StringBuilder().append("submitList completed, adapter item count: ");
                AppSettingsAdapter r9 = SmartMemorySettingsActivity.access$getAdapter$p(r8);
                if (r9 == null) goto L5;
                Integer r10 = Integer.valueOf(r9.getItemCount());
            L6:
                IRunLog.a.a(r1, SmartMemorySettingsActivity.TAG, r0.append(r10).toString(), false, 4, null);
                return;
            L5:
                r10 = null;
                goto L6
            }

            public static /* synthetic */ void lambda$aavy8gMw6W07RPS7yE0C_igHub4(SmartMemorySettingsActivity r0) {
                a(r0);
            }

            public final Object a(x r9, Continuation<? super Unit> r10) {
                Continuation r11 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r10, Continuation.class, "com.obric.memorydata.plugin");
                IRunLog r2 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
                StringBuilder r12 = new StringBuilder().append("State updated: ");
                Iterable r0 = (Iterable) ZeusTransformUtils.preCheckCast(r9.c(), Iterable.class, "com.obric.memorydata.plugin");
                Collection r3 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r0, 10)), Collection.class, "com.obric.memorydata.plugin");
                Iterator<T> r1 = r0.iterator();
            L4:
                if (r1.hasNext() == false) goto L6;
                c r4 = (c) ZeusTransformUtils.preCheckCast(r1.next(), c.class, "com.obric.memorydata.plugin");
                r3.add(r4.b() + ": " + r4.e());
                goto L4
            L6:
                IRunLog.a.a(r2, SmartMemorySettingsActivity.TAG, r12.append((List) ZeusTransformUtils.preCheckCast(r3, List.class, "com.obric.memorydata.plugin")).toString(), false, 4, null);
                AppSettingsAdapter r13 = SmartMemorySettingsActivity.access$getAdapter$p(this.f11424a);
                if (r13 == null) goto L9;
                List<c> r5 = r9.c();
                final SmartMemorySettingsActivity r6 = this.f11424a;
                r13.submitList(r5, new $$Lambda$SmartMemorySettingsActivity$observeState$1$1$aavy8gMw6W07RPS7yE0C_igHub4(r6));
            L9:
                ActivitySmartMemorySettingsBinding r14 = SmartMemorySettingsActivity.access$getBinding$p(this.f11424a);
                if (r14 != null) goto L12;
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                r14 = null;
            L12:
                OSwitch r15 = r14.smartMemorySwitch.getEndSwitch();
                if (r15 == null) goto L15;
                SmartMemorySettingsActivity r7 = this.f11424a;
                r15.setOnCheckedChangeListener(null);
                r15.setChecked(r9.f());
                r15.setOnCheckedChangeListener(SmartMemorySettingsActivity.access$getSmartMemoryCheckListener$p(r7));
            L15:
                Iterable r16 = (Iterable) ZeusTransformUtils.preCheckCast(r9.c(), Iterable.class, "com.obric.memorydata.plugin");
                int r8 = 0;
                if (ZeusTransformUtils.instanceOf(r16, Collection.class) == true) goto L18;
            L20:
                Iterator<T> r17 = r16.iterator();
                int r18 = 0;
            L22:
                if (r17.hasNext() == false) goto L35;
                c r19 = (c) ZeusTransformUtils.preCheckCast(r17.next(), c.class, "com.obric.memorydata.plugin");
                if (r19.e() == true) goto L26;
            L30:
                boolean r20 = false;
            L31:
                if (r20 == false) goto L22;
                r18 = r18 + 1;
                if (r18 >= 0) goto L22;
                CollectionsKt.throwCountOverflow();
                goto L22
            L26:
                if (com.obric.memorydata.utils.c.f13193a.a(r19.b()) == false) goto L28;
            L29:
                r20 = true;
                goto L31
            L28:
                if (Intrinsics.areEqual(r19.b(), "assistant.history") == false) goto L30;
            L35:
                r8 = r18;
            L36:
                if (r8 == 0) goto L38;
            L45:
                SmartMemorySettingsActivity.access$setPreEnabledAppCount$p(this.f11424a, Boxing.boxInt(r8));
                return Unit.INSTANCE;
            L38:
                if (SmartMemorySettingsActivity.access$getPreEnabledAppCount$p(this.f11424a) == null) goto L45;
                Integer r21 = SmartMemorySettingsActivity.access$getPreEnabledAppCount$p(this.f11424a);
                if (r21 != null) goto L43;
            L44:
                SmartMemorySettingsActivity.access$showDisableSmartMemoryDialog(this.f11424a);
                goto L45
            L43:
                if (r21.intValue() == 0) goto L45;
            L18:
                if (((Collection) ZeusTransformUtils.preCheckCast(r16, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L20;
                goto L20
            }

            @Override // kotlinx.coroutines.flow.j
            public /* synthetic */ Object emit(Object r3, Continuation r4) {
                Continuation<? super Unit> r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
                return a((x) ZeusTransformUtils.preCheckCast(r3, x.class, "com.obric.memorydata.plugin"), r5);
            }
        }

        C12111(SmartMemorySettingsActivity r3, Continuation<? super C12111> r4) {
            SmartMemorySettingsActivity r5 = (SmartMemorySettingsActivity) ZeusTransformUtils.wrapperContextForParams(r3, SmartMemorySettingsActivity.class, "com.obric.memorydata.plugin");
            Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r5;
            super(2, r6);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            Continuation r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new C12111(this.this$0, r4), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
            return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(al r3, Continuation<? super Unit> r4) {
            return ((C12111) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), C12111.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r6) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L6;
            ResultKt.throwOnFailure(r6);
        L12:
            throw new KotlinNothingValueException();
        L6:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r6);
            ar<x> r7 = SmartMemorySettingsActivity.access$getViewModel$p(this.this$0).getState();
            kotlinx.coroutines.flow.j<? super x> r2 = (kotlinx.coroutines.flow.j) ZeusTransformUtils.preCheckCast(new C06181(this.this$0), kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin");
            Continuation<?> r3 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 1;
            if (r7.collect(r2, r3) != r0) goto L12;
            return r0;
        }
    }

    static {
        Companion = new a(null);
    }

    public SmartMemorySettingsActivity() {
        this.viewModel = new SmartMemorySettingsViewModel();
        this.smartMemoryCheckListener = new $$Lambda$SmartMemorySettingsActivity$QvzJnBCb7LX_qoDTZceZUNkfqs(this);
    }

    public static final /* synthetic */ AppSettingsAdapter access$getAdapter$p(SmartMemorySettingsActivity r2) {
        return ((SmartMemorySettingsActivity) ZeusTransformUtils.wrapperContextForParams(r2, SmartMemorySettingsActivity.class, "com.obric.memorydata.plugin")).adapter;
    }

    public static final /* synthetic */ boolean access$getAwaitingAccessibilityResult$p(SmartMemorySettingsActivity r2) {
        return ((SmartMemorySettingsActivity) ZeusTransformUtils.wrapperContextForParams(r2, SmartMemorySettingsActivity.class, "com.obric.memorydata.plugin")).awaitingAccessibilityResult;
    }

    public static final /* synthetic */ ActivitySmartMemorySettingsBinding access$getBinding$p(SmartMemorySettingsActivity r2) {
        return ((SmartMemorySettingsActivity) ZeusTransformUtils.wrapperContextForParams(r2, SmartMemorySettingsActivity.class, "com.obric.memorydata.plugin")).binding;
    }

    public static final /* synthetic */ Integer access$getPreEnabledAppCount$p(SmartMemorySettingsActivity r2) {
        return ((SmartMemorySettingsActivity) ZeusTransformUtils.wrapperContextForParams(r2, SmartMemorySettingsActivity.class, "com.obric.memorydata.plugin")).preEnabledAppCount;
    }

    public static final /* synthetic */ CompoundButton.OnCheckedChangeListener access$getSmartMemoryCheckListener$p(SmartMemorySettingsActivity r2) {
        return ((SmartMemorySettingsActivity) ZeusTransformUtils.wrapperContextForParams(r2, SmartMemorySettingsActivity.class, "com.obric.memorydata.plugin")).smartMemoryCheckListener;
    }

    public static final /* synthetic */ SmartMemorySettingsViewModel access$getViewModel$p(SmartMemorySettingsActivity r2) {
        return ((SmartMemorySettingsActivity) ZeusTransformUtils.wrapperContextForParams(r2, SmartMemorySettingsActivity.class, "com.obric.memorydata.plugin")).viewModel;
    }

    public static final /* synthetic */ void access$setPreEnabledAppCount$p(SmartMemorySettingsActivity r2, Integer r3) {
        ((SmartMemorySettingsActivity) ZeusTransformUtils.wrapperContextForParams(r2, SmartMemorySettingsActivity.class, "com.obric.memorydata.plugin")).preEnabledAppCount = r3;
    }

    public static final /* synthetic */ void access$showDisableSmartMemoryDialog(SmartMemorySettingsActivity r2) {
        ((SmartMemorySettingsActivity) ZeusTransformUtils.wrapperContextForParams(r2, SmartMemorySettingsActivity.class, "com.obric.memorydata.plugin")).showDisableSmartMemoryDialog();
    }

    private final View buildA11yContentView() {
        View r4 = ZeusTransformUtils.inflate(LayoutInflater.from((Context) ZeusTransformUtils.preCheckCast(this, Context.class, "com.obric.memorydata.plugin")), ZeusTransformUtils.mapRes(R.layout.smart_memory_notice_a11y, "layout", "smart_memory_notice_a11y"), null, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r4, "inflate(...)");
        return r4;
    }

    private final void clearAccessibilityPrompt(boolean r3) {
        com.obric.oui.dialog.v2.alert.a r0 = this.accessibilityPromptDialog;
        this.accessibilityPromptDialog = null;
        this.accessibilityPromptPackageName = null;
        boolean r1 = false;
        this.accessibilityPromptForMainSwitch = false;
        if (r3 == true) goto L5;
        return;
    L5:
        if (r0 != null) goto L7;
    L9:
        if (r1 == false) goto L13;
        r0.dismiss();
        return;
    L13:
        return;
    L7:
        if (r0.isShowing() != true) goto L9;
        r1 = true;
        goto L9
    }

    static /* synthetic */ void clearAccessibilityPrompt$default(SmartMemorySettingsActivity r1, boolean r2, int r3, Object r4) {
        SmartMemorySettingsActivity r5 = (SmartMemorySettingsActivity) ZeusTransformUtils.wrapperContextForParams(r1, SmartMemorySettingsActivity.class, "com.obric.memorydata.plugin");
        if ((r3 & 1) == 0) goto L5;
        r2 = false;
    L5:
        r5.clearAccessibilityPrompt(r2);
    }

    private final void clearPendingAccessibilityRequest() {
        this.pendingAccessibilityPackageName = null;
        this.pendingMainSwitchAccessibility = false;
        this.awaitingAccessibilityResult = false;
    }

    private final void completeAccessibilityPromptIfEnabled() {
        if (com.obric.memorydata.screencapture.accessibility.c.f12773a.b() == true) goto L5;
        return;
    L5:
        if (this.accessibilityPromptDialog == null) goto L16;
        String r0 = this.accessibilityPromptPackageName;
        boolean r1 = this.accessibilityPromptForMainSwitch;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "Accessibility enabled outside prompt, complete request: package=" + r0 + ", mainSwitch=" + r1, false, 4, null);
        clearAccessibilityPrompt(true);
        if (r1 == false) goto L11;
        SmartMemorySettingsViewModel r11 = this.viewModel;
        Object r2 = ZeusTransformUtils.preCheckCast(new w.e(true), w.class, "com.obric.memorydata.plugin");
    L10:
        r11.processIntent((w) r2);
        return;
    L11:
        if (r0 == null) goto L15;
        r11 = this.viewModel;
        r2 = ZeusTransformUtils.preCheckCast(new w.c(r0, true), w.class, "com.obric.memorydata.plugin");
        goto L10
    L15:
        return;
    }

    private final void continueEnableSmartMemory() {
        if (com.obric.memorydata.memory.b.f10076a.c() == true) goto L6;
        this.viewModel.processIntent((w) ZeusTransformUtils.preCheckCast(new w.e(true), w.class, "com.obric.memorydata.plugin"));
        return;
    L6:
        com.obric.memorydata.screencapture.accessibility.c.f12773a.c();
        if (this.viewModel.hasInstalledAppsRequiringAccessibility() == true) goto L9;
    L11:
        this.viewModel.processIntent((w) ZeusTransformUtils.preCheckCast(new w.e(true), w.class, "com.obric.memorydata.plugin"));
        return;
    L9:
        if (com.obric.memorydata.screencapture.accessibility.c.f12773a.b() == true) goto L11;
        showEnableAppConfirmDialog$default(this, null, 1, null);
    }

    private final void handleAppSettingChange(String r5, boolean r6) {
        if (r6 == true) goto L5;
    L12:
        SmartMemorySettingsViewModel r4 = this.viewModel;
        Object r7 = ZeusTransformUtils.preCheckCast(new w.c(r5, r6), w.class, "com.obric.memorydata.plugin");
    L13:
        r4.processIntent((w) r7);
        return;
    L5:
        if (com.obric.memorydata.memory.b.f10076a.c() == false) goto L12;
        if (((x) ZeusTransformUtils.preCheckCast(this.viewModel.getState().c(), x.class, "com.obric.memorydata.plugin")).d().contains(r5) == true) goto L12;
        this.viewModel.processIntent((w) ZeusTransformUtils.preCheckCast(new w.a(r5, true), w.class, "com.obric.memorydata.plugin"));
        com.obric.memorydata.screencapture.accessibility.c.f12773a.c();
        if (((com.obric.memorydata.screencapture.accessibility.c.a) ZeusTransformUtils.preCheckCast(com.obric.memorydata.screencapture.accessibility.c.f12773a.a().c(), com.obric.memorydata.screencapture.accessibility.c.a.class, "com.obric.memorydata.plugin")).a() == true) goto L11;
        showEnableAppConfirmDialog(r5);
        return;
    L11:
        r4 = this.viewModel;
        r7 = ZeusTransformUtils.preCheckCast(new w.c(r5, true), w.class, "com.obric.memorydata.plugin");
        goto L13
    }

    private final void initViews() {
        ActivitySmartMemorySettingsBinding r0 = this.binding;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r0 = null;
    L5:
        OFloatingTitleBar r1 = r0.viewTitle;
        Intrinsics.checkNotNullExpressionValue(r1, "viewTitle");
        ActivitySmartMemorySettingsBinding r4 = this.binding;
        if (r4 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r4 = null;
    L8:
        View r5 = (View) ZeusTransformUtils.preCheckCast(r4.smartMemorySettingsContainer, View.class, "com.obric.memorydata.plugin");
        int r6 = MathKt.roundToInt(TypedValue.applyDimension(1, 16, Resources.getSystem().getDisplayMetrics()));
        ActivitySmartMemorySettingsBinding r7 = this.binding;
        if (r7 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r7 = null;
    L11:
        setupTitleBarBackAction(r1, r5, r6, r7.cutOff);
        ActivitySmartMemorySettingsBinding r2 = this.binding;
        if (r2 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r2 = null;
    L14:
        OFloatingTitleBar r3 = r2.viewTitle;
        Intrinsics.checkNotNullExpressionValue(r3, "viewTitle");
        com.obric.memorydata.ui.custom.a.a(r3, (Function0) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this), Function0.class, "com.obric.memorydata.plugin"));
        ActivitySmartMemorySettingsBinding r8 = this.binding;
        if (r8 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r8 = null;
    L17:
        OFloatingTitleBar r9 = r8.viewTitle;
        Intrinsics.checkNotNullExpressionValue(r9, "viewTitle");
        registerFloatingTitleBar(r9);
        ActivitySmartMemorySettingsBinding r10 = this.binding;
        if (r10 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r10 = null;
    L20:
        OSwitch r11 = r10.smartMemorySwitch.getEndSwitch();
        if (r11 == null) goto L23;
        r11.setOnCheckedChangeListener(this.smartMemoryCheckListener);
    L23:
        ActivitySmartMemorySettingsBinding r12 = this.binding;
        if (r12 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r12 = null;
    L26:
        r12.rvAppSettings.setLayoutManager((RecyclerView.LayoutManager) ZeusTransformUtils.preCheckCast(new LinearLayoutManager((Context) ZeusTransformUtils.preCheckCast(this, Context.class, "com.obric.memorydata.plugin")), RecyclerView.LayoutManager.class, "com.obric.memorydata.plugin"));
        this.adapter = new AppSettingsAdapter((Context) ZeusTransformUtils.preCheckCast(this, Context.class, "com.obric.memorydata.plugin"), new $$Lambda$SmartMemorySettingsActivity$kP0sW9hivLyDtCHse6JJYMcC_Y(this), new $$Lambda$SmartMemorySettingsActivity$LLatJYH98oxtt5F1HUEvE7i7czs(this));
        ActivitySmartMemorySettingsBinding r13 = this.binding;
        if (r13 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r13 = null;
    L29:
        r13.rvAppSettings.setAdapter((RecyclerView.Adapter) ZeusTransformUtils.preCheckCast(this.adapter, RecyclerView.Adapter.class, "com.obric.memorydata.plugin"));
        ActivitySmartMemorySettingsBinding r14 = this.binding;
        if (r14 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r14 = null;
    L32:
        r14.rvAppSettings.setItemAnimator(null);
    }

    private static final Unit initViews$lambda$1(SmartMemorySettingsActivity r7, String r8, boolean r9) {
        SmartMemorySettingsActivity r10 = (SmartMemorySettingsActivity) ZeusTransformUtils.wrapperContextForParams(r7, SmartMemorySettingsActivity.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r8, ObricMemoryConstants.KEY_PACKAGE_NAME);
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "app settings request changed " + r8 + ", enabled: " + r9, false, 4, null);
        r10.handleAppSettingChange(r8, r9);
        return Unit.INSTANCE;
    }

    private static final Unit initViews$lambda$2(SmartMemorySettingsActivity r5, c r6) {
        SmartMemorySettingsActivity r7 = (SmartMemorySettingsActivity) ZeusTransformUtils.wrapperContextForParams(r5, SmartMemorySettingsActivity.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "it");
        if (Intrinsics.areEqual("assistant.history", r6.b()) == true) goto L6;
        r7.viewModel.processIntent((w) ZeusTransformUtils.preCheckCast(new w.c(r6.b(), false), w.class, "com.obric.memorydata.plugin"));
        com.obric.memorydata.utils.d.f13204a.b((Context) ZeusTransformUtils.preCheckCast(r7, Context.class, "com.obric.memorydata.plugin"), r6.b());
    L6:
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Unit lambda$DgtdyPBwz9eZTbNSxfcyLjX3kJs(String r0, SmartMemorySettingsActivity r1, boolean r2, DialogInterface r3, int r4) {
        return showEnableAppConfirmDialog$lambda$4(r0, r1, r2, r3, r4);
    }

    public static /* synthetic */ Unit lambda$LLatJYH98oxtt5F1HUEvE7i7czs(SmartMemorySettingsActivity r0, c r1) {
        return initViews$lambda$2(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$QvzJnBCb7LX-_qoDTZceZUNkfqs, reason: not valid java name */
    public static /* synthetic */ void m981lambda$QvzJnBCb7LX_qoDTZceZUNkfqs(SmartMemorySettingsActivity r0, CompoundButton r1, boolean r2) {
        smartMemoryCheckListener$lambda$0(r0, r1, r2);
    }

    public static /* synthetic */ Unit lambda$S1wb93dJQ7KoyaO3FlvIwFoLZm0(String r0, SmartMemorySettingsActivity r1, boolean r2, DialogInterface r3, int r4) {
        return showEnableAppConfirmDialog$lambda$3(r0, r1, r2, r3, r4);
    }

    public static /* synthetic */ Unit lambda$c7pWp6ex7smtVMDM5VX0pxGc1Nw(SmartMemorySettingsActivity r0, DialogInterface r1, int r2) {
        return showAccessibilityPermissionDialog$lambda$5(r0, r1, r2);
    }

    public static /* synthetic */ Unit lambda$hgm18zZfB8TxMXPfekSY_pQSCZE(DialogInterface r0, int r1) {
        return showDisableSmartMemoryDialog$lambda$7(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$kP0-sW9hivLyDtCHse6JJYMcC_Y, reason: not valid java name */
    public static /* synthetic */ Unit m982lambda$kP0sW9hivLyDtCHse6JJYMcC_Y(SmartMemorySettingsActivity r0, String r1, boolean r2) {
        return initViews$lambda$1(r0, r1, r2);
    }

    /* JADX INFO: renamed from: lambda$m2rKI_kjruD_ompTi321--sNFNQ, reason: not valid java name */
    public static /* synthetic */ Unit m983lambda$m2rKI_kjruD_ompTi321sNFNQ(SmartMemorySettingsActivity r0, DialogInterface r1, int r2) {
        return showAccessibilityPermissionDialog$lambda$6(r0, r1, r2);
    }

    private final void observeAccessibilityState() {
        kotlinx.coroutines.i.a((al) ZeusTransformUtils.preCheckCast(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) ZeusTransformUtils.preCheckCast(this, LifecycleOwner.class, "com.obric.memorydata.plugin")), al.class, "com.obric.memorydata.plugin"), null, null, (Function2) ZeusTransformUtils.preCheckCast(new C12101(this, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
    }

    private final void observeState() {
        kotlinx.coroutines.i.a((al) ZeusTransformUtils.preCheckCast(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) ZeusTransformUtils.preCheckCast(this, LifecycleOwner.class, "com.obric.memorydata.plugin")), al.class, "com.obric.memorydata.plugin"), null, null, (Function2) ZeusTransformUtils.preCheckCast(new C12111(this, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
    }

    private final void reconcilePendingAccessibilityRequest() {
        if (this.awaitingAccessibilityResult == true) goto L5;
        return;
    L5:
        com.obric.memorydata.screencapture.accessibility.c.f12773a.c();
        boolean r0 = com.obric.memorydata.screencapture.accessibility.c.f12773a.b();
        String r1 = this.pendingAccessibilityPackageName;
        boolean r2 = this.pendingMainSwitchAccessibility;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "Reconcile accessibility request: master=" + r0 + ", package=" + r1 + ", mainSwitch=" + r2, false, 4, null);
        clearPendingAccessibilityRequest();
        if (r0 == false) goto L14;
        if (r2 == false) goto L11;
        SmartMemorySettingsViewModel r12 = this.viewModel;
        Object r3 = ZeusTransformUtils.preCheckCast(new w.e(true), w.class, "com.obric.memorydata.plugin");
    L10:
        r12.processIntent((w) r3);
        return;
    L11:
        if (r1 == null) goto L21;
        r12 = this.viewModel;
        r3 = ZeusTransformUtils.preCheckCast(new w.c(r1, true), w.class, "com.obric.memorydata.plugin");
        goto L10
    L21:
        return;
    L14:
        if (r2 == false) goto L16;
        this.viewModel.processIntent((w) ZeusTransformUtils.preCheckCast(new w.b(null), w.class, "com.obric.memorydata.plugin"));
    L16:
        if (r1 == null) goto L18;
        this.viewModel.processIntent((w) ZeusTransformUtils.preCheckCast(new w.a(r1, null), w.class, "com.obric.memorydata.plugin"));
    L18:
        this.viewModel.disableAppsRequiringAccessibility();
    }

    private final void showAccessibilityPermissionDialog() {
        String r2 = ZeusTransformUtils.getResources(this, "com.obric.memorydata.plugin").getString(ZeusTransformUtils.mapRes(R.string.memory_settings_smart_memory_notice_message, TypedValues.Custom.S_STRING, "memory_settings_smart_memory_notice_message"));
        Intrinsics.checkNotNullExpressionValue(r2, "getString(...)");
        SpannableStringBuilder r11 = new SpannableStringBuilder((CharSequence) ZeusTransformUtils.preCheckCast(StringsKt.replace$default(StringsKt.replace$default(r2, "{", "", false, 4, null), "}", "", false, 4, null), CharSequence.class, "com.obric.memorydata.plugin"));
        int r5 = StringsKt.indexOf$default((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.memorydata.plugin"), '{', 0, false, 6, null);
        int r6 = StringsKt.indexOf$default((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.memorydata.plugin"), '}', 0, false, 6, null);
        String r3 = r2.substring(r5 + 1, r6);
        Intrinsics.checkNotNullExpressionValue(r3, "substring(...)");
        if (r5 == (-1)) goto L7;
        if (r6 == (-1)) goto L7;
        if (r5 >= r6) goto L7;
        r11.setSpan(new b(this, r3), r5, r6, 33);
    L7:
        com.obric.oui.dialog.v2.alert.b r4 = com.obric.oui.dialog.v2.alert.b.a(new com.obric.oui.dialog.v2.alert.b((Context) ZeusTransformUtils.preCheckCast(this, Context.class, "com.obric.memorydata.plugin")).b(false).a((CharSequence) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.getResources(this, "com.obric.memorydata.plugin").getString(ZeusTransformUtils.mapRes(R.string.memory_settings_smart_memory_notice_title, TypedValues.Custom.S_STRING, "memory_settings_smart_memory_notice_title")), CharSequence.class, "com.obric.memorydata.plugin"), false).a((CharSequence) ZeusTransformUtils.preCheckCast(r11, CharSequence.class, "com.obric.memorydata.plugin")), false, 1, null).b(ZeusTransformUtils.mapRes(R.string.memory_settings_smart_memory_notice_cancel, TypedValues.Custom.S_STRING, "memory_settings_smart_memory_notice_cancel"), new $$Lambda$SmartMemorySettingsActivity$c7pWp6ex7smtVMDM5VX0pxGc1Nw(this));
        String r7 = ZeusTransformUtils.getResources(this, "com.obric.memorydata.plugin").getString(ZeusTransformUtils.mapRes(R.string.memory_settings_smart_memory_notice_confirm, TypedValues.Custom.S_STRING, "memory_settings_smart_memory_notice_confirm"));
        Intrinsics.checkNotNullExpressionValue(r7, "getString(...)");
        com.obric.oui.dialog.v2.alert.a r0 = (com.obric.oui.dialog.v2.alert.a) ZeusTransformUtils.preCheckCast(r4.a((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.memorydata.plugin"), new $$Lambda$SmartMemorySettingsActivity$m2rKI_kjruD_ompTi321sNFNQ(this)).g(), com.obric.oui.dialog.v2.alert.a.class, "com.obric.memorydata.plugin");
        TextView r1 = r0.f();
        if (r1 == null) goto L10;
        r1.setMovementMethod(LinkMovementMethod.getInstance());
    L10:
        r0.show();
    }

    private static final Unit showAccessibilityPermissionDialog$lambda$5(SmartMemorySettingsActivity r7, DialogInterface r8, int r9) {
        SmartMemorySettingsActivity r10 = (SmartMemorySettingsActivity) ZeusTransformUtils.wrapperContextForParams(r7, SmartMemorySettingsActivity.class, "com.obric.memorydata.plugin");
        DialogInterface r11 = (DialogInterface) ZeusTransformUtils.wrapperContextForParams(r8, DialogInterface.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r11, "dialog");
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, ObricSecurityGuardStub.SettingsEventConst.EVENT_RESULT_CANCEL, false, 4, null);
        r11.dismiss();
        r10.viewModel.processIntent((w) ZeusTransformUtils.preCheckCast(new w.b(null), w.class, "com.obric.memorydata.plugin"));
        return Unit.INSTANCE;
    }

    private static final Unit showAccessibilityPermissionDialog$lambda$6(SmartMemorySettingsActivity r7, DialogInterface r8, int r9) {
        SmartMemorySettingsActivity r10 = (SmartMemorySettingsActivity) ZeusTransformUtils.wrapperContextForParams(r7, SmartMemorySettingsActivity.class, "com.obric.memorydata.plugin");
        DialogInterface r11 = (DialogInterface) ZeusTransformUtils.wrapperContextForParams(r8, DialogInterface.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r11, "dialog");
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "ok", false, 4, null);
        r11.dismiss();
        r10.viewModel.processIntent((w) ZeusTransformUtils.preCheckCast(new w.d(true), w.class, "com.obric.memorydata.plugin"));
        r10.continueEnableSmartMemory();
        return Unit.INSTANCE;
    }

    private final void showDisableSmartMemoryDialog() {
        com.obric.oui.dialog.v2.alert.b.a(new com.obric.oui.dialog.v2.alert.b((Context) ZeusTransformUtils.preCheckCast(this, Context.class, "com.obric.memorydata.plugin")).b(false).c(ZeusTransformUtils.mapRes(R.drawable.smart_memory_icon, "drawable", "smart_memory_icon")).a((CharSequence) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.getResources(this, "com.obric.memorydata.plugin").getString(ZeusTransformUtils.mapRes(R.string.memory_settings_smart_memory_disable_notice_title, TypedValues.Custom.S_STRING, "memory_settings_smart_memory_disable_notice_title")), CharSequence.class, "com.obric.memorydata.plugin"), false).a((CharSequence) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.getResources(this, "com.obric.memorydata.plugin").getString(ZeusTransformUtils.mapRes(R.string.memory_settings_smart_memory_disable_notice_message, TypedValues.Custom.S_STRING, "memory_settings_smart_memory_disable_notice_message")), CharSequence.class, "com.obric.memorydata.plugin")), false, 1, null).b(ZeusTransformUtils.mapRes(R.string.memory_settings_smart_memory_disable_confirmed, TypedValues.Custom.S_STRING, "memory_settings_smart_memory_disable_confirmed"), $$Lambda$SmartMemorySettingsActivity$hgm18zZfB8TxMXPfekSY_pQSCZE.INSTANCE).h();
    }

    private static final Unit showDisableSmartMemoryDialog$lambda$7(DialogInterface r6, int r7) {
        DialogInterface r8 = (DialogInterface) ZeusTransformUtils.wrapperContextForParams(r6, DialogInterface.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r8, "dialog");
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "disable", false, 4, null);
        r8.dismiss();
        return Unit.INSTANCE;
    }

    private final void showEnableAppConfirmDialog(final String r10) {
        if (r10 == null) goto L5;
        final boolean r2 = true;
    L6:
        RunLog.INSTANCE.debug(TAG, "showEnableAppConfirmDialog: " + r10 + ", isApp: " + r2);
        com.obric.oui.dialog.v2.alert.a r3 = this.accessibilityPromptDialog;
        if (r3 == null) goto L9;
        r3.dismiss();
    L9:
        this.accessibilityPromptPackageName = r10;
        this.accessibilityPromptForMainSwitch = !r2;
        com.obric.oui.dialog.v2.alert.b r0 = com.obric.oui.dialog.v2.alert.b.a(new com.obric.oui.dialog.v2.alert.b((Context) ZeusTransformUtils.preCheckCast(this, Context.class, "com.obric.memorydata.plugin")).b(false).a((CharSequence) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.getResources(this, "com.obric.memorydata.plugin").getString(ZeusTransformUtils.mapRes(R.string.memory_settings_enable_app_title, TypedValues.Custom.S_STRING, "memory_settings_enable_app_title")), CharSequence.class, "com.obric.memorydata.plugin"), false).a((CharSequence) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.getResources(this, "com.obric.memorydata.plugin").getString(ZeusTransformUtils.mapRes(R.string.memory_settings_enable_app_message, TypedValues.Custom.S_STRING, "memory_settings_enable_app_message")), CharSequence.class, "com.obric.memorydata.plugin")), false, 1, null).b(ZeusTransformUtils.mapRes(R.string.memory_settings_smart_memory_notice_cancel, TypedValues.Custom.S_STRING, "memory_settings_smart_memory_notice_cancel"), new $$Lambda$SmartMemorySettingsActivity$S1wb93dJQ7KoyaO3FlvIwFoLZm0(r10, this, r2));
        String r1 = ZeusTransformUtils.getResources(this, "com.obric.memorydata.plugin").getString(ZeusTransformUtils.mapRes(R.string.memory_settings_enable_app_confirm, TypedValues.Custom.S_STRING, "memory_settings_enable_app_confirm"));
        Intrinsics.checkNotNullExpressionValue(r1, "getString(...)");
        com.obric.oui.dialog.v2.alert.a r11 = (com.obric.oui.dialog.v2.alert.a) ZeusTransformUtils.preCheckCast(r0.a((CharSequence) ZeusTransformUtils.preCheckCast(r1, CharSequence.class, "com.obric.memorydata.plugin"), new $$Lambda$SmartMemorySettingsActivity$DgtdyPBwz9eZTbNSxfcyLjX3kJs(r10, this, r2)).g(), com.obric.oui.dialog.v2.alert.a.class, "com.obric.memorydata.plugin");
        this.accessibilityPromptDialog = r11;
        if (r11 == null) goto L13;
        r11.show();
        return;
    L13:
        return;
    L5:
        r2 = false;
        goto L6
    }

    static /* synthetic */ void showEnableAppConfirmDialog$default(SmartMemorySettingsActivity r1, String r2, int r3, Object r4) {
        SmartMemorySettingsActivity r5 = (SmartMemorySettingsActivity) ZeusTransformUtils.wrapperContextForParams(r1, SmartMemorySettingsActivity.class, "com.obric.memorydata.plugin");
        if ((r3 & 1) == 0) goto L5;
        r2 = null;
    L5:
        r5.showEnableAppConfirmDialog(r2);
    }

    private static final Unit showEnableAppConfirmDialog$lambda$3(String r7, SmartMemorySettingsActivity r8, boolean r9, DialogInterface r10, int r11) {
        SmartMemorySettingsActivity r12 = (SmartMemorySettingsActivity) ZeusTransformUtils.wrapperContextForParams(r8, SmartMemorySettingsActivity.class, "com.obric.memorydata.plugin");
        DialogInterface r13 = (DialogInterface) ZeusTransformUtils.wrapperContextForParams(r10, DialogInterface.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r13, "dialog");
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "User cancelled enabling app: " + r7, false, 4, null);
        r13.dismiss();
        clearAccessibilityPrompt$default(r12, false, 1, null);
        if (r9 == false) goto L5;
        SmartMemorySettingsViewModel r14 = r12.viewModel;
        Intrinsics.checkNotNull(r7);
        r14.processIntent((w) ZeusTransformUtils.preCheckCast(new w.a(r7, null), w.class, "com.obric.memorydata.plugin"));
    L7:
        return Unit.INSTANCE;
    L5:
        r12.viewModel.processIntent((w) ZeusTransformUtils.preCheckCast(new w.b(null), w.class, "com.obric.memorydata.plugin"));
        goto L7
    }

    private static final Unit showEnableAppConfirmDialog$lambda$4(String r7, SmartMemorySettingsActivity r8, boolean r9, DialogInterface r10, int r11) {
        SmartMemorySettingsActivity r12 = (SmartMemorySettingsActivity) ZeusTransformUtils.wrapperContextForParams(r8, SmartMemorySettingsActivity.class, "com.obric.memorydata.plugin");
        DialogInterface r13 = (DialogInterface) ZeusTransformUtils.wrapperContextForParams(r10, DialogInterface.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r13, "dialog");
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "User confirmed, jumping to accessibility settings for: " + r7, false, 4, null);
        r13.dismiss();
        clearAccessibilityPrompt$default(r12, false, 1, null);
        if (r9 == false) goto L5;
        r12.pendingAccessibilityPackageName = r7;
    L6:
        r12.awaitingAccessibilityResult = true;
        com.obric.memorydata.screencapture.accessibility.c.f12773a.a((Activity) ZeusTransformUtils.preCheckCast(r12, Activity.class, "com.obric.memorydata.plugin"), 1001);
        return Unit.INSTANCE;
    L5:
        r12.pendingMainSwitchAccessibility = true;
        goto L6
    }

    private static final void smartMemoryCheckListener$lambda$0(SmartMemorySettingsActivity r2, CompoundButton r3, boolean r4) {
        SmartMemorySettingsActivity r5 = (SmartMemorySettingsActivity) ZeusTransformUtils.wrapperContextForParams(r2, SmartMemorySettingsActivity.class, "com.obric.memorydata.plugin");
        if (r4 == false) goto L8;
        r5.viewModel.processIntent((w) ZeusTransformUtils.preCheckCast(new w.b(true), w.class, "com.obric.memorydata.plugin"));
        if (((x) ZeusTransformUtils.preCheckCast(r5.viewModel.getState().c(), x.class, "com.obric.memorydata.plugin")).a() == true) goto L7;
        r5.showAccessibilityPermissionDialog();
        return;
    L7:
        r5.continueEnableSmartMemory();
        return;
    L8:
        r5.clearPendingAccessibilityRequest();
        r5.viewModel.processIntent((w) ZeusTransformUtils.preCheckCast(new w.b(null), w.class, "com.obric.memorydata.plugin"));
        r5.viewModel.processIntent((w) ZeusTransformUtils.preCheckCast(new w.e(false), w.class, "com.obric.memorydata.plugin"));
    }

    public void finish() {
        super.finish();
    }

    @Override // androidx.activity.ComponentActivity
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override // com.obric.memorydata.ui.BaseActivity
    public void onCreateChecked(Bundle r5) {
        prepareSystemBar();
        ActivitySmartMemorySettingsBinding r6 = ActivitySmartMemorySettingsBinding.inflate(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(r6, "inflate(...)");
        this.binding = r6;
        if (r6 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r6 = null;
    L5:
        setContentView((View) ZeusTransformUtils.preCheckCast(r6.getRoot(), View.class, "com.obric.memorydata.plugin"));
        ActivitySmartMemorySettingsBinding r7 = this.binding;
        if (r7 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r7 = null;
    L8:
        ONestedScrollView r8 = r7.smartMemorySettingsContainer;
        Intrinsics.checkNotNullExpressionValue(r8, "smartMemorySettingsContainer");
        com.obric.memorydata.ui.g.a((View) ZeusTransformUtils.preCheckCast(r8, View.class, "com.obric.memorydata.plugin"), 0, 1, null);
        initViews();
        observeState();
        observeAccessibilityState();
        getLifecycle().addObserver((LifecycleObserver) ZeusTransformUtils.preCheckCast(this.viewModel, LifecycleObserver.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.ui.BaseAuthActivity, com.obric.memorydata.ui.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity
    public void onDestroy() {
        clearAccessibilityPrompt(true);
        super.onDestroy();
        com.obric.memorydata.utils.icon.b.f13229a.b();
    }

    @Override // com.obric.memorydata.ui.BaseActivity, androidx.fragment.app.FragmentActivity
    public void onPause() {
        super.onPause();
        Iterator r4 = ((Iterable) ZeusTransformUtils.preCheckCast(((x) ZeusTransformUtils.preCheckCast(this.viewModel.getState().c(), x.class, "com.obric.memorydata.plugin")).c(), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r4.hasNext() == false) goto L8;
        Object r0 = r4.next();
        if (Intrinsics.areEqual(((c) ZeusTransformUtils.preCheckCast(r0, c.class, "com.obric.memorydata.plugin")).b(), "assistant.history") == false) goto L4;
    L9:
        c r5 = (c) ZeusTransformUtils.preCheckCast(r0, c.class, "com.obric.memorydata.plugin");
        if (r5 == null) goto L22;
        com.obric.memorydata.memory.x r1 = com.obric.memorydata.memory.x.f11587a;
        if (r5.e() == true) goto L14;
    L16:
        boolean r6 = false;
    L17:
        r1.a(r6);
        return;
    L14:
        if (r5.d() == false) goto L16;
        r6 = true;
        goto L17
    L22:
        return;
    L8:
        r0 = null;
        goto L9
    }

    @Override // com.obric.memorydata.ui.BaseAuthActivity, com.obric.memorydata.ui.BaseActivity, androidx.fragment.app.FragmentActivity
    public void onResume() {
        super.onResume();
        com.obric.memorydata.screencapture.accessibility.c.f12773a.c();
        completeAccessibilityPromptIfEnabled();
        reconcilePendingAccessibilityRequest();
    }
}
