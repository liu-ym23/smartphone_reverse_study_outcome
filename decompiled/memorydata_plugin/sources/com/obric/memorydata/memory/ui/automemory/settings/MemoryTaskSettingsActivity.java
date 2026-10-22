package com.obric.memorydata.memory.ui.automemory.settings;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.activity.ComponentActivity;
import androidx.activity.OnBackPressedCallback;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelLazy;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.google.android.material.card.MaterialCardView;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.memorydata.memory.databinding.AutoMemoryProActivityMemoryTaskSettingsBinding;
import com.obric.memorydata.memory.ui.BaseMemoryActivity;
import com.obric.memorydata.memory.ui.settings.l;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.personalcontext.api.IPersonalContextAPI;
import com.obric.memorydata.plugin.R;
import com.obric.memorydata.ui.NavigationBarScheme;
import com.obric.memorydata.utils.bb;
import com.obric.oui.button.OButton;
import com.obric.oui.forms.OEditText;
import com.obric.oui.forms.OInputLayout;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.oswitch.OSwitch;
import com.obric.oui.progress.ODownloadProgressView;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.math.MathKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.al;
import kotlinx.coroutines.flow.ar;
import net.zetetic.database.sqlcipher.SQLiteDatabase;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 (2\u00020\u0001:\u0001(B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0014J\u0010\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u0017H\u0014J\b\u0010\u001a\u001a\u00020\u0015H\u0002J\b\u0010\u001b\u001a\u00020\u0015H\u0014J\u0010\u0010\u001c\u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\b\u0010\u001f\u001a\u00020\u0011H\u0002J\u0010\u0010 \u001a\u00020\u00152\u0006\u0010!\u001a\u00020\"H\u0002J\u0018\u0010#\u001a\u00020\u00152\u0006\u0010!\u001a\u00020\"2\u0006\u0010$\u001a\u00020\u0011H\u0002J\u0010\u0010%\u001a\u00020\"2\u0006\u0010&\u001a\u00020'H\u0002R\u0014\u0010\u0004\u001a\u00020\u0005X\u0094\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0082.¢\u0006\u0002\n\u0000R\u001b\u0010\n\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\rR\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006)"}, d2 = {"Lcom/obric/memorydata/memory/ui/automemory/settings/MemoryTaskSettingsActivity;", "Lcom/obric/memorydata/memory/ui/BaseMemoryActivity;", "<init>", "()V", "navigationBarScheme", "Lcom/obric/memorydata/ui/NavigationBarScheme;", "getNavigationBarScheme", "()Lcom/obric/memorydata/ui/NavigationBarScheme;", "binding", "Lcom/obric/memorydata/memory/databinding/AutoMemoryProActivityMemoryTaskSettingsBinding;", "viewModel", "Lcom/obric/memorydata/memory/ui/automemory/settings/MemoryTaskSettingsViewModel;", "getViewModel", "()Lcom/obric/memorydata/memory/ui/automemory/settings/MemoryTaskSettingsViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", ObricMemoryConstants.KEY_SESSION_ID, "", "isEditMode", "", "onCreateChecked", "", "savedInstanceState", "Landroid/os/Bundle;", "onSaveInstanceState", "outState", "handleExitRequest", "onDestroy", "bindState", "state", "Lcom/obric/memorydata/memory/ui/automemory/settings/MemoryTaskSettingsUiState;", "readCurrentTitle", "showFormatEditDialog", MemoryInfoSectionEditActivity.EXTRA_KIND, "", "applyDialogResult", IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT, "formatAuditMessageRes", "result", "Lcom/obric/memorydata/memory/ui/automemory/settings/FormatAuditResult;", "Companion", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class MemoryTaskSettingsActivity extends BaseMemoryActivity {
    public static final a Companion = null;
    public static final String EXTRA_EDIT_RULE_ID = "edit_rule_id";
    public static final String EXTRA_SESSION_ID = "session_id";
    private static final int FORMAT_MAX_LENGTH = 50;
    public static final int KIND_NAME = 2;
    public static final int KIND_SUBTITLE = 1;
    public static final int KIND_TITLE = 0;
    private static final String STATE_SESSION_ID = "state_session_id";
    private static final String TAG = "MemoryTaskSettings";
    private static final int TITLE_MAX_LENGTH = 8;
    private AutoMemoryProActivityMemoryTaskSettingsBinding binding;
    private boolean isEditMode;
    private final NavigationBarScheme navigationBarScheme;
    private String sessionId;
    private final Lazy viewModel$delegate;

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0005J\u0016\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\nX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/obric/memorydata/memory/ui/automemory/settings/MemoryTaskSettingsActivity$Companion;", "", "<init>", "()V", "TAG", "", "EXTRA_SESSION_ID", "EXTRA_EDIT_RULE_ID", "STATE_SESSION_ID", "KIND_TITLE", "", "KIND_SUBTITLE", "KIND_NAME", "TITLE_MAX_LENGTH", "FORMAT_MAX_LENGTH", "startForCreate", "", "context", "Landroid/content/Context;", ObricMemoryConstants.KEY_SESSION_ID, "startForEdit", "ruleId", "", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }

        public final void a(Context r3, long r4) {
            Context r2 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r2, "context");
            Intent r5 = new Intent(r2, MemoryTaskSettingsActivity.class);
            r5.putExtra(MemoryTaskSettingsActivity.EXTRA_EDIT_RULE_ID, r4);
            if (ZeusTransformUtils.instanceOf(r2, Activity.class) == true) goto L5;
            r5.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
        L5:
            ZeusTransformUtils.startActivity(r2, r5, "com.obric.memorydata.plugin");
        }

        public final void a(Context r3, String r4) {
            Context r2 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r2, "context");
            Intrinsics.checkNotNullParameter(r4, ObricMemoryConstants.KEY_SESSION_ID);
            Intent r5 = new Intent(r2, MemoryTaskSettingsActivity.class);
            r5.putExtra("session_id", r4);
            if (ZeusTransformUtils.instanceOf(r2, Activity.class) == true) goto L5;
            r5.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
        L5:
            ZeusTransformUtils.startActivity(r2, r5, "com.obric.memorydata.plugin");
        }
    }

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f10734a = null;

        static {
            int[] r0 = new int[FormatAuditResult.values().length];
            r0[FormatAuditResult.COMPLIANCE_FAILED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[FormatAuditResult.RELEVANCE_FAILED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f10734a = r0;
        }
    }

    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J*\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0016J*\u0010\n\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0012\u0010\f\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\rH\u0016¨\u0006\u000e"}, d2 = {"com/obric/memorydata/memory/ui/automemory/settings/MemoryTaskSettingsActivity$showFormatEditDialog$3$1", "Landroid/text/TextWatcher;", "beforeTextChanged", "", "s", "", CommonConsts.APM_INNER_EVENT_COST_START, "", CommonConsts.COUNT_TYPE, "after", "onTextChanged", "before", "afterTextChanged", "Landroid/text/Editable;", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class c implements TextWatcher {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Ref.BooleanRef f10735a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Ref.ObjectRef<TextView> f10736b;
        final /* synthetic */ Ref.ObjectRef<Function1<Boolean, Unit>> c;
        final /* synthetic */ Ref.ObjectRef<TextView> d;
        final /* synthetic */ int e;
        final /* synthetic */ com.obric.oui.dialog.alert.b f;
        final /* synthetic */ MemoryTaskSettingsActivity g;

        c(Ref.BooleanRef r3, Ref.ObjectRef<TextView> r4, Ref.ObjectRef<Function1<Boolean, Unit>> r5, Ref.ObjectRef<TextView> r6, int r7, com.obric.oui.dialog.alert.b r8, MemoryTaskSettingsActivity r9) {
            MemoryTaskSettingsActivity r10 = (MemoryTaskSettingsActivity) ZeusTransformUtils.wrapperContextForParams(r9, MemoryTaskSettingsActivity.class, "com.obric.memorydata.plugin");
            this.f10735a = r3;
            this.f10736b = r4;
            this.c = r5;
            this.d = r6;
            this.e = r7;
            this.f = r8;
            this.g = r10;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable r7) {
            Editable r8 = (Editable) ZeusTransformUtils.wrapperContextForParams(r7, Editable.class, "com.obric.memorydata.plugin");
            if (r8 == null) goto L5;
            String r9 = r8.toString();
        L6:
            if (r9 != null) goto L8;
            r9 = "";
        L8:
            boolean r3 = false;
            if (this.f10735a.element == false) goto L19;
            TextView r2 = (TextView) ZeusTransformUtils.preCheckCast(this.f10736b.element, TextView.class, "com.obric.memorydata.plugin");
            if (r2 == null) goto L13;
            r2.setVisibility(8);
        L13:
            TextView r4 = (TextView) ZeusTransformUtils.preCheckCast(this.f10736b.element, TextView.class, "com.obric.memorydata.plugin");
            if (r4 == null) goto L16;
            r4.setText(null);
        L16:
            Function1 r0 = (Function1) ZeusTransformUtils.preCheckCast(this.c.element, Function1.class, "com.obric.memorydata.plugin");
            if (r0 == null) goto L19;
            r0.invoke(false);
        L19:
            com.obric.oui.dialog.alert.b r1 = this.f;
            MemoryTaskSettingsActivity r5 = this.g;
            if (((CharSequence) ZeusTransformUtils.preCheckCast(StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, "com.obric.memorydata.plugin")).toString(), CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L22;
            r3 = true;
        L22:
            MemoryTaskSettingsActivity.access$showFormatEditDialog$lambda$40$applyEnabledStyle(r1, r5, r3);
            TextView r6 = (TextView) ZeusTransformUtils.preCheckCast(this.d.element, TextView.class, "com.obric.memorydata.plugin");
            if (r6 == null) goto L26;
            r6.setText((CharSequence) ZeusTransformUtils.preCheckCast(new StringBuilder().append(r9.length()).append('/').append(this.e).toString(), CharSequence.class, "com.obric.memorydata.plugin"));
            return;
        L26:
            return;
        L5:
            r9 = null;
            goto L6
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

    /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.automemory.settings.MemoryTaskSettingsActivity$onCreateChecked$15, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.memory.ui.automemory.settings.MemoryTaskSettingsActivity$onCreateChecked$15", f = "MemoryTaskSettingsActivity.kt", i = {}, l = {235}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass15 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ MemoryTaskSettingsActivity this$0;

        AnonymousClass15(MemoryTaskSettingsActivity r3, Continuation<? super AnonymousClass15> r4) {
            MemoryTaskSettingsActivity r5 = (MemoryTaskSettingsActivity) ZeusTransformUtils.wrapperContextForParams(r3, MemoryTaskSettingsActivity.class, "com.obric.memorydata.plugin");
            Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r5;
            super(2, r6);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            Continuation r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new AnonymousClass15(this.this$0, r4), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
            return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(al r3, Continuation<? super Unit> r4) {
            return ((AnonymousClass15) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), AnonymousClass15.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
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
            ar<i> r7 = MemoryTaskSettingsActivity.access$getViewModel(this.this$0).getState();
            final MemoryTaskSettingsActivity r3 = this.this$0;
            kotlinx.coroutines.flow.j<? super i> r2 = (kotlinx.coroutines.flow.j) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r3), kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin");
            Continuation<?> r4 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 1;
            if (r7.collect(r2, r4) != r0) goto L12;
            return r0;
        }
    }

    static {
        Companion = new a(null);
    }

    public MemoryTaskSettingsActivity() {
        this.navigationBarScheme = NavigationBarScheme.A;
        final ComponentActivity r0 = (ComponentActivity) ZeusTransformUtils.preCheckCast(this, ComponentActivity.class, "com.obric.memorydata.plugin");
        Function0 r2 = (Function0) ZeusTransformUtils.preCheckCast(new MemoryTaskSettingsActivity$special$$inlined$viewModels$default$1(r0), Function0.class, "com.obric.memorydata.plugin");
        final Function0 r7 = null;
        this.viewModel$delegate = (Lazy) ZeusTransformUtils.preCheckCast(new ViewModelLazy(Reflection.getOrCreateKotlinClass(MemoryTaskSettingsViewModel.class), (Function0) ZeusTransformUtils.preCheckCast(new MemoryTaskSettingsActivity$special$$inlined$viewModels$default$2(r0), Function0.class, "com.obric.memorydata.plugin"), r2, (Function0) ZeusTransformUtils.preCheckCast(new MemoryTaskSettingsActivity$special$$inlined$viewModels$default$3(r7, r0), Function0.class, "com.obric.memorydata.plugin")), Lazy.class, "com.obric.memorydata.plugin");
        this.sessionId = "";
    }

    public static final /* synthetic */ void access$applyDialogResult(MemoryTaskSettingsActivity r2, int r3, String r4) {
        ((MemoryTaskSettingsActivity) ZeusTransformUtils.wrapperContextForParams(r2, MemoryTaskSettingsActivity.class, "com.obric.memorydata.plugin")).applyDialogResult(r3, r4);
    }

    public static final /* synthetic */ void access$bindState(MemoryTaskSettingsActivity r2, i r3) {
        ((MemoryTaskSettingsActivity) ZeusTransformUtils.wrapperContextForParams(r2, MemoryTaskSettingsActivity.class, "com.obric.memorydata.plugin")).bindState(r3);
    }

    public static final /* synthetic */ int access$formatAuditMessageRes(MemoryTaskSettingsActivity r2, FormatAuditResult r3) {
        return ((MemoryTaskSettingsActivity) ZeusTransformUtils.wrapperContextForParams(r2, MemoryTaskSettingsActivity.class, "com.obric.memorydata.plugin")).formatAuditMessageRes(r3);
    }

    public static final /* synthetic */ MemoryTaskSettingsViewModel access$getViewModel(MemoryTaskSettingsActivity r2) {
        return ((MemoryTaskSettingsActivity) ZeusTransformUtils.wrapperContextForParams(r2, MemoryTaskSettingsActivity.class, "com.obric.memorydata.plugin")).getViewModel();
    }

    public static final /* synthetic */ void access$handleExitRequest(MemoryTaskSettingsActivity r2) {
        ((MemoryTaskSettingsActivity) ZeusTransformUtils.wrapperContextForParams(r2, MemoryTaskSettingsActivity.class, "com.obric.memorydata.plugin")).handleExitRequest();
    }

    public static final /* synthetic */ void access$showFormatEditDialog$lambda$40$applyEnabledStyle(com.obric.oui.dialog.alert.b r2, MemoryTaskSettingsActivity r3, boolean r4) {
        showFormatEditDialog$lambda$40$applyEnabledStyle(r2, (MemoryTaskSettingsActivity) ZeusTransformUtils.wrapperContextForParams(r3, MemoryTaskSettingsActivity.class, "com.obric.memorydata.plugin"), r4);
    }

    private final void applyDialogResult(int r2, String r3) {
        if (r2 == 0) goto L7;
        MemoryTaskSettingsViewModel r1 = getViewModel();
        if (r2 == 2) goto L6;
        r1.updateSubtitleFormat(r3);
        return;
    L6:
        r1.updateTitle(r3);
        return;
    L7:
        getViewModel().updateTitleFormat(r3);
    }

    private final void bindState(i r17) {
        AutoMemoryProActivityMemoryTaskSettingsBinding r1 = this.binding;
        AutoMemoryProActivityMemoryTaskSettingsBinding r3 = null;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r1 = null;
    L5:
        OFloatingTitleBar r2 = r1.viewTitle;
        if (r17.a().a() == null) goto L8;
        int r4 = R.string.memory_task_settings_title_edit;
        String r6 = "memory_task_settings_title_edit";
    L9:
        r2.setCenterTitle(getString(ZeusTransformUtils.mapRes(r4, TypedValues.Custom.S_STRING, r6)));
        AutoMemoryProActivityMemoryTaskSettingsBinding r5 = this.binding;
        if (r5 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r5 = null;
    L12:
        Editable r7 = r5.nameInput.getVInput().getText();
        if (r7 == null) goto L15;
        String r8 = r7.toString();
    L17:
        if (Intrinsics.areEqual(r8, r17.a().b()) == true) goto L22;
        AutoMemoryProActivityMemoryTaskSettingsBinding r9 = this.binding;
        if (r9 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r9 = null;
    L21:
        r9.nameInput.setText((CharSequence) ZeusTransformUtils.preCheckCast(r17.a().b(), CharSequence.class, "com.obric.memorydata.plugin"));
    L22:
        AutoMemoryProActivityMemoryTaskSettingsBinding r10 = this.binding;
        if (r10 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r10 = null;
    L25:
        OButton r11 = r10.btnCreate;
        if (r17.b() == false) goto L30;
        int r12 = R.string.memory_recommend_app_loading;
        String r13 = "memory_recommend_app_loading";
    L33:
        r11.setText((CharSequence) ZeusTransformUtils.preCheckCast(getString(ZeusTransformUtils.mapRes(r12, TypedValues.Custom.S_STRING, r13)), CharSequence.class, "com.obric.memorydata.plugin"));
        AutoMemoryProActivityMemoryTaskSettingsBinding r14 = this.binding;
        if (r14 != null) goto L36;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r14 = null;
    L36:
        ODownloadProgressView r15 = r14.createProgress;
        if (r17.b() == false) goto L39;
        int r16 = 0;
    L40:
        r15.setVisibility(r16);
        e r18 = r17.a().r();
        AutoMemoryProActivityMemoryTaskSettingsBinding r19 = this.binding;
        if (r19 != null) goto L43;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r19 = null;
    L43:
        OCardListItem r20 = r19.itemPaymentBehavior;
        Intrinsics.checkNotNullExpressionValue(r20, "itemPaymentBehavior");
        h.a(r20, (CharSequence) ZeusTransformUtils.preCheckCast(r18.b(), CharSequence.class, "com.obric.memorydata.plugin"));
        AutoMemoryProActivityMemoryTaskSettingsBinding r21 = this.binding;
        if (r21 != null) goto L46;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r21 = null;
    L46:
        OCardListItem r22 = r21.itemPaymentInfo;
        Intrinsics.checkNotNullExpressionValue(r22, "itemPaymentInfo");
        Iterable r23 = (Iterable) ZeusTransformUtils.preCheckCast(r18.c().b(), Iterable.class, "com.obric.memorydata.plugin");
        Collection r24 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r25 = r23.iterator();
    L48:
        if (r25.hasNext() == false) goto L52;
        Object r26 = r25.next();
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast((String) ZeusTransformUtils.preCheckCast(r26, String.class, "com.obric.memorydata.plugin"), CharSequence.class, "com.obric.memorydata.plugin"))) == false) goto L48;
        r24.add(r26);
        goto L48
    L52:
        h.a(r22, (CharSequence) ZeusTransformUtils.preCheckCast(CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r24, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("、", CharSequence.class, "com.obric.memorydata.plugin"), null, null, 0, null, null, 62, null), CharSequence.class, "com.obric.memorydata.plugin"));
        AutoMemoryProActivityMemoryTaskSettingsBinding r27 = this.binding;
        if (r27 != null) goto L55;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r27 = null;
    L55:
        OCardListItem r28 = r27.itemUpdateRule;
        Intrinsics.checkNotNullExpressionValue(r28, "itemUpdateRule");
        h.a(r28, (CharSequence) ZeusTransformUtils.preCheckCast(r18.e(), CharSequence.class, "com.obric.memorydata.plugin"));
        AutoMemoryProActivityMemoryTaskSettingsBinding r29 = this.binding;
        if (r29 != null) goto L58;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r29 = null;
    L58:
        OCardListItem r30 = r29.itemTitleFormat;
        Intrinsics.checkNotNullExpressionValue(r30, "itemTitleFormat");
        h.a(r30, (CharSequence) ZeusTransformUtils.preCheckCast(r18.f(), CharSequence.class, "com.obric.memorydata.plugin"));
        AutoMemoryProActivityMemoryTaskSettingsBinding r31 = this.binding;
        if (r31 != null) goto L61;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r31 = null;
    L61:
        r31.itemTitleFormat.getSubTitleView().setTextColor(getColor(ZeusTransformUtils.mapRes(R.color.oui_basic_text_2, TypedValues.Custom.S_COLOR, "oui_basic_text_2")));
        AutoMemoryProActivityMemoryTaskSettingsBinding r32 = this.binding;
        if (r32 != null) goto L64;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r32 = null;
    L64:
        OCardListItem r33 = r32.itemSubtitleFormat;
        Intrinsics.checkNotNullExpressionValue(r33, "itemSubtitleFormat");
        h.a(r33, (CharSequence) ZeusTransformUtils.preCheckCast(r18.g(), CharSequence.class, "com.obric.memorydata.plugin"));
        AutoMemoryProActivityMemoryTaskSettingsBinding r34 = this.binding;
        if (r34 != null) goto L67;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r34 = null;
    L67:
        r34.itemSubtitleFormat.getSubTitleView().setTextColor(getColor(ZeusTransformUtils.mapRes(R.color.oui_basic_text_2, TypedValues.Custom.S_COLOR, "oui_basic_text_2")));
        AutoMemoryProActivityMemoryTaskSettingsBinding r35 = this.binding;
        if (r35 != null) goto L70;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r35 = null;
    L70:
        OSwitch r36 = r35.itemUseClientModel.getEndSwitch();
        if (r36 != null) goto L73;
    L75:
        AutoMemoryProActivityMemoryTaskSettingsBinding r0 = this.binding;
        if (r0 != null) goto L78;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L79:
        r3.btnCreate.setEnabled(!r17.b());
        return;
    L78:
        r3 = r0;
        goto L79
    L73:
        if (r36.isChecked() == r17.a().g()) goto L75;
        r36.setChecked(r17.a().g());
        goto L75
    L39:
        r16 = 8;
        goto L40
    L30:
        if (r17.a().a() == null) goto L32;
        r12 = R.string.memory_edit_done;
        r13 = "memory_edit_done";
        goto L33
    L32:
        r12 = R.string.memory_create;
        r13 = "memory_create";
        goto L33
    L15:
        r8 = null;
        goto L17
    L8:
        r4 = R.string.memory_task_settings_title;
        r6 = "memory_task_settings_title";
        goto L9
    }

    private final int formatAuditMessageRes(FormatAuditResult r2) {
        int r1 = b.f10734a[r2.ordinal()];
        if (r1 != 1) goto L5;
        int r3 = R.string.memory_info_section_audit_compliance_invalid;
        String r4 = "memory_info_section_audit_compliance_invalid";
    L10:
        return ZeusTransformUtils.mapRes(r3, TypedValues.Custom.S_STRING, r4);
    L5:
        if (r1 == 2) goto L7;
        r3 = R.string.memory_info_section_audit_service_failed;
        r4 = "memory_info_section_audit_service_failed";
        goto L10
    L7:
        r3 = R.string.memory_info_section_audit_relevance_irrelevant;
        r4 = "memory_info_section_audit_relevance_irrelevant";
        goto L10
    }

    private final MemoryTaskSettingsViewModel getViewModel() {
        return (MemoryTaskSettingsViewModel) ZeusTransformUtils.preCheckCast(this.viewModel$delegate.getValue(), MemoryTaskSettingsViewModel.class, "com.obric.memorydata.plugin");
    }

    private final void handleExitRequest() {
        if (this.isEditMode == false) goto L5;
    L8:
        int r1 = R.string.memory_edit_memory_task_exit_title;
        String r4 = "memory_edit_memory_task_exit_title";
    L9:
        Drawable r7 = null;
        com.obric.oui.dialog.alert.c r8 = com.obric.oui.dialog.alert.c.a(new com.obric.oui.dialog.alert.c((Context) ZeusTransformUtils.preCheckCast(this, Context.class, "com.obric.memorydata.plugin")).b(false), (CharSequence) ZeusTransformUtils.preCheckCast(getString(ZeusTransformUtils.mapRes(r1, TypedValues.Custom.S_STRING, r4)), CharSequence.class, "com.obric.memorydata.plugin"), false, 2, null).a((CharSequence) ZeusTransformUtils.preCheckCast(getString(ZeusTransformUtils.mapRes(R.string.memory_create_memory_task_exit_message, TypedValues.Custom.S_STRING, "memory_create_memory_task_exit_message")), CharSequence.class, "com.obric.memorydata.plugin")).a(true);
        String r2 = getString(ZeusTransformUtils.mapRes(R.string.memory_create_memory_task_exit_cancel, TypedValues.Custom.S_STRING, "memory_create_memory_task_exit_cancel"));
        Intrinsics.checkNotNullExpressionValue(r2, "getString(...)");
        com.obric.oui.dialog.alert.c r14 = com.obric.oui.dialog.alert.c.b(r8, (CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.memorydata.plugin"), $$Lambda$MemoryTaskSettingsActivity$uAabdaKr_CvnanJKYpgLhAx6nj8.INSTANCE, null, 4, null);
        String r3 = getString(ZeusTransformUtils.mapRes(R.string.memory_create_memory_task_exit_confirm, TypedValues.Custom.S_STRING, "memory_create_memory_task_exit_confirm"));
        Intrinsics.checkNotNullExpressionValue(r3, "getString(...)");
        com.obric.oui.dialog.alert.b r5 = com.obric.oui.dialog.alert.c.a(r14, (CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.memorydata.plugin"), new $$Lambda$MemoryTaskSettingsActivity$NErI5qQAkfVW3qdDYt_3m4viVoY(this), null, 4, null).g();
        com.obric.oui.dialog.alert.b r6 = (com.obric.oui.dialog.alert.b) ZeusTransformUtils.preCheckCast(r5, com.obric.oui.dialog.alert.b.class, "com.obric.memorydata.plugin");
        r6.setCanceledOnTouchOutside(true);
        r6.setCancelable(true);
        OButton r9 = r6.g();
        OButton r10 = r6.f();
        if (ZeusTransformUtils.instanceOf(r10, TextView.class) == false) goto L12;
        TextView r11 = (TextView) ZeusTransformUtils.preCheckCast(r10, TextView.class, "com.obric.memorydata.plugin");
    L13:
        if (r11 == null) goto L24;
        r11.setTextColor(getColor(ZeusTransformUtils.mapRes(R.color.oui_functional_red_6, TypedValues.Custom.S_COLOR, "oui_functional_red_6")));
        if (r9 == null) goto L24;
        Drawable r0 = r9.getBackground();
        if (r0 == null) goto L23;
        Drawable.ConstantState r12 = r0.getConstantState();
        if (r12 == null) goto L23;
        Drawable r13 = r12.newDrawable();
        if (r13 == null) goto L23;
        r7 = r13.mutate();
    L23:
        r11.setBackground(r7);
        r11.setBackgroundTintList(r9.getBackgroundTintList());
    L24:
        ((com.obric.oui.dialog.alert.b) ZeusTransformUtils.preCheckCast(r5, com.obric.oui.dialog.alert.b.class, "com.obric.memorydata.plugin")).show();
        return;
    L12:
        r11 = null;
        goto L13
    L5:
        if (((i) ZeusTransformUtils.preCheckCast(getViewModel().getState().c(), i.class, "com.obric.memorydata.plugin")).a().a() != null) goto L8;
        r1 = R.string.memory_create_memory_task_exit_title;
        r4 = "memory_create_memory_task_exit_title";
        goto L9
    }

    private static final void handleExitRequest$lambda$22(DialogInterface r1, int r2) {
        ((DialogInterface) ZeusTransformUtils.wrapperContextForParams(r1, DialogInterface.class, "com.obric.memorydata.plugin")).dismiss();
    }

    private static final void handleExitRequest$lambda$23(MemoryTaskSettingsActivity r1, DialogInterface r2, int r3) {
        MemoryTaskSettingsActivity r4 = (MemoryTaskSettingsActivity) ZeusTransformUtils.wrapperContextForParams(r1, MemoryTaskSettingsActivity.class, "com.obric.memorydata.plugin");
        ((DialogInterface) ZeusTransformUtils.wrapperContextForParams(r2, DialogInterface.class, "com.obric.memorydata.plugin")).dismiss();
        r4.finish();
    }

    /* JADX INFO: renamed from: lambda$0-wy3hJ5efeaeI4kpHHZom4dHVw, reason: not valid java name */
    public static /* synthetic */ Unit m828lambda$0wy3hJ5efeaeI4kpHHZom4dHVw(MemoryTaskSettingsActivity r0) {
        return onCreateChecked$lambda$20$lambda$17(r0);
    }

    public static /* synthetic */ void lambda$7JCMPngkqvWLg2SZoAbreoJNjIs(MemoryTaskSettingsActivity r0, View r1) {
        onCreateChecked$lambda$14(r0, r1);
    }

    public static /* synthetic */ void lambda$CjtYaOtjKMsQXKUv3J_n40e8oP0(MemoryTaskSettingsActivity r0, View r1) {
        onCreateChecked$lambda$11(r0, r1);
    }

    public static /* synthetic */ Unit lambda$G9hP5gePI4UtmkNN9ncY9MYdG_U(Ref.BooleanRef r0, OInputLayout r1, MemoryTaskSettingsActivity r2, int r3, boolean r4) {
        return showFormatEditDialog$lambda$37$lambda$30(r0, r1, r2, r3, r4);
    }

    public static /* synthetic */ void lambda$G_JzXywvvb3ll2C7AHS6T21klvA(MemoryTaskSettingsActivity r0, View r1) {
        onCreateChecked$lambda$5$lambda$4(r0, r1);
    }

    public static /* synthetic */ void lambda$Io4kylLUwTdSlsFOHXaA2i5w0Oo(MemoryTaskSettingsActivity r0, View r1) {
        onCreateChecked$lambda$6(r0, r1);
    }

    public static /* synthetic */ void lambda$KCfEUMFO7tn5VQqpa5wxZhzD9Vk(MemoryTaskSettingsActivity r0, View r1) {
        onCreateChecked$lambda$1$lambda$0(r0, r1);
    }

    public static /* synthetic */ Unit lambda$KxI3mOTplYFhTB23pEBhIOS3CD4(MemoryTaskSettingsActivity r0, Ref.ObjectRef r1, Ref.ObjectRef r2, Ref.ObjectRef r3, Ref.ObjectRef r4, int r5, String r6, Ref.BooleanRef r7, FrameLayout r8) {
        return showFormatEditDialog$lambda$37(r0, r1, r2, r3, r4, r5, r6, r7, r8);
    }

    public static /* synthetic */ void lambda$NErI5qQAkfVW3qdDYt_3m4viVoY(MemoryTaskSettingsActivity r0, DialogInterface r1, int r2) {
        handleExitRequest$lambda$23(r0, r1, r2);
    }

    public static /* synthetic */ Unit lambda$NtPucg3NV2Og1ZOa87FQ05EFGYk(MemoryTaskSettingsActivity r0) {
        return onCreateChecked$lambda$20$lambda$15(r0);
    }

    public static /* synthetic */ void lambda$Rc0Mz9soSz7IAMUrtc49AnW4CKk(Ref.BooleanRef r0, Ref.ObjectRef r1, Ref.ObjectRef r2, Ref.ObjectRef r3, String r4, boolean r5, MemoryTaskSettingsActivity r6, int r7, boolean r8, DialogInterface r9, int r10) {
        showFormatEditDialog$lambda$39(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10);
    }

    public static /* synthetic */ void lambda$SRxT6xQtA7dGw4fKVb6XChQKMWQ(MemoryTaskSettingsActivity r0, View r1) {
        onCreateChecked$lambda$9(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$SfFCxswWDE7-V_GgxBFX--cpzGs, reason: not valid java name */
    public static /* synthetic */ void m829lambda$SfFCxswWDE7V_GgxBFXcpzGs(DialogInterface r0, int r1) {
        showFormatEditDialog$lambda$38(r0, r1);
    }

    public static /* synthetic */ void lambda$W8e6oJz_7O5sr2DVCT10UZyu9V8(MemoryTaskSettingsActivity r0, View r1) {
        onCreateChecked$lambda$20(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$dUPgqcz-vVklFMzikX6K6nc13LY, reason: not valid java name */
    public static /* synthetic */ void m830lambda$dUPgqczvVklFMzikX6K6nc13LY(MemoryTaskSettingsActivity r0, View r1) {
        onCreateChecked$lambda$12(r0, r1);
    }

    public static /* synthetic */ Unit lambda$eygEABFNpNd8jzoOrKpnmvDv85c(MemoryTaskSettingsActivity r0) {
        return onCreateChecked$lambda$20$lambda$19(r0);
    }

    public static /* synthetic */ Unit lambda$f1q7NjgWgG7k0HPIPbonSwnJniM(MemoryTaskSettingsActivity r0) {
        return onCreateChecked$lambda$20$lambda$16(r0);
    }

    public static /* synthetic */ void lambda$jzyKVL9WdBuoejvkhX__XviqvEg(MemoryTaskSettingsActivity r0, OInputLayout r1) {
        showFormatEditDialog$lambda$37$lambda$36(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$ps2tw1j_dC-HQk1kELPvqcrKIt0, reason: not valid java name */
    public static /* synthetic */ Unit m831lambda$ps2tw1j_dCHQk1kELPvqcrKIt0(MemoryTaskSettingsActivity r0) {
        return onCreateChecked$lambda$20$lambda$18(r0);
    }

    public static /* synthetic */ Unit lambda$pui4hEMvhX0VMQXaI3gVbzUMrLU(MemoryTaskSettingsActivity r0, String r1) {
        return onCreateChecked$lambda$21(r0, r1);
    }

    public static /* synthetic */ WindowInsetsCompat lambda$sXTYzT6966YwLGq9g54vYh560A0(MemoryTaskSettingsActivity r0, View r1, WindowInsetsCompat r2) {
        return onCreateChecked$lambda$3(r0, r1, r2);
    }

    public static /* synthetic */ void lambda$uAabdaKr_CvnanJKYpgLhAx6nj8(DialogInterface r0, int r1) {
        handleExitRequest$lambda$22(r0, r1);
    }

    public static /* synthetic */ void lambda$yIKlnlrTCwTTd8vpMwt_W3tkGbA(MemoryTaskSettingsActivity r0, View r1) {
        onCreateChecked$lambda$10(r0, r1);
    }

    public static /* synthetic */ void lambda$ya3vRUQKoL__UoZZo_7Ffk3cbZE(MemoryTaskSettingsActivity r0, View r1) {
        onCreateChecked$lambda$13(r0, r1);
    }

    public static /* synthetic */ void lambda$zb78PA79eZ468HPHdlrxHA7xyc8(MemoryTaskSettingsActivity r0, CompoundButton r1, boolean r2) {
        onCreateChecked$lambda$8$lambda$7(r0, r1, r2);
    }

    private static final void onCreateChecked$lambda$1$lambda$0(MemoryTaskSettingsActivity r1, View r2) {
        ((MemoryTaskSettingsActivity) ZeusTransformUtils.wrapperContextForParams(r1, MemoryTaskSettingsActivity.class, "com.obric.memorydata.plugin")).handleExitRequest();
    }

    private static final void onCreateChecked$lambda$10(MemoryTaskSettingsActivity r2, View r3) {
        MemoryTaskSettingsActivity r4 = (MemoryTaskSettingsActivity) ZeusTransformUtils.wrapperContextForParams(r2, MemoryTaskSettingsActivity.class, "com.obric.memorydata.plugin");
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r4.sessionId, CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L5;
        boolean r5 = true;
    L6:
        if (r5 == false) goto L9;
        MemoryInfoSectionEditActivity.Companion.a((Context) ZeusTransformUtils.preCheckCast(r4, Context.class, "com.obric.memorydata.plugin"), r4.sessionId, MemoryInfoSectionEditActivity.KIND_SCENE);
        return;
    L9:
        return;
    L5:
        r5 = false;
        goto L6
    }

    private static final void onCreateChecked$lambda$11(MemoryTaskSettingsActivity r2, View r3) {
        MemoryTaskSettingsActivity r4 = (MemoryTaskSettingsActivity) ZeusTransformUtils.wrapperContextForParams(r2, MemoryTaskSettingsActivity.class, "com.obric.memorydata.plugin");
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r4.sessionId, CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L5;
        boolean r5 = true;
    L6:
        if (r5 == false) goto L9;
        MemoryInfoSectionEditActivity.Companion.a((Context) ZeusTransformUtils.preCheckCast(r4, Context.class, "com.obric.memorydata.plugin"), r4.sessionId, "info");
        return;
    L9:
        return;
    L5:
        r5 = false;
        goto L6
    }

    private static final void onCreateChecked$lambda$12(MemoryTaskSettingsActivity r2, View r3) {
        MemoryTaskSettingsActivity r4 = (MemoryTaskSettingsActivity) ZeusTransformUtils.wrapperContextForParams(r2, MemoryTaskSettingsActivity.class, "com.obric.memorydata.plugin");
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r4.sessionId, CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L5;
        boolean r5 = true;
    L6:
        if (r5 == false) goto L9;
        MemoryInfoSectionEditActivity.Companion.a((Context) ZeusTransformUtils.preCheckCast(r4, Context.class, "com.obric.memorydata.plugin"), r4.sessionId, MemoryInfoSectionEditActivity.KIND_UPDATE_RULE);
        return;
    L9:
        return;
    L5:
        r5 = false;
        goto L6
    }

    private static final void onCreateChecked$lambda$13(MemoryTaskSettingsActivity r1, View r2) {
        ((MemoryTaskSettingsActivity) ZeusTransformUtils.wrapperContextForParams(r1, MemoryTaskSettingsActivity.class, "com.obric.memorydata.plugin")).showFormatEditDialog(0);
    }

    private static final void onCreateChecked$lambda$14(MemoryTaskSettingsActivity r1, View r2) {
        ((MemoryTaskSettingsActivity) ZeusTransformUtils.wrapperContextForParams(r1, MemoryTaskSettingsActivity.class, "com.obric.memorydata.plugin")).showFormatEditDialog(1);
    }

    private static final void onCreateChecked$lambda$20(MemoryTaskSettingsActivity r7, View r8) {
        final MemoryTaskSettingsActivity r9 = (MemoryTaskSettingsActivity) ZeusTransformUtils.wrapperContextForParams(r7, MemoryTaskSettingsActivity.class, "com.obric.memorydata.plugin");
        r9.getViewModel().updateTitle(r9.readCurrentTitle());
        r9.getViewModel().confirmCreate(new $$Lambda$MemoryTaskSettingsActivity$NtPucg3NV2Og1ZOa87FQ05EFGYk(r9), new $$Lambda$MemoryTaskSettingsActivity$f1q7NjgWgG7k0HPIPbonSwnJniM(r9), new $$Lambda$MemoryTaskSettingsActivity$0wy3hJ5efeaeI4kpHHZom4dHVw(r9), new $$Lambda$MemoryTaskSettingsActivity$ps2tw1j_dCHQk1kELPvqcrKIt0(r9), new $$Lambda$MemoryTaskSettingsActivity$eygEABFNpNd8jzoOrKpnmvDv85c(r9));
    }

    private static final Unit onCreateChecked$lambda$20$lambda$15(MemoryTaskSettingsActivity r8) {
        MemoryTaskSettingsActivity r9 = (MemoryTaskSettingsActivity) ZeusTransformUtils.wrapperContextForParams(r8, MemoryTaskSettingsActivity.class, "com.obric.memorydata.plugin");
        if (r9.isEditMode == false) goto L5;
    L8:
        boolean r0 = true;
    L9:
        com.obric.oui.toast.a.C0786a r2 = com.obric.oui.toast.a.f14807a;
        Context r3 = (Context) ZeusTransformUtils.preCheckCast(r9, Context.class, "com.obric.memorydata.plugin");
        if (r0 == false) goto L12;
        int r1 = R.string.memory_edit_memory_task_success_toast;
        String r4 = "memory_edit_memory_task_success_toast";
    L13:
        String r5 = r9.getString(ZeusTransformUtils.mapRes(r1, TypedValues.Custom.S_STRING, r4));
        Intrinsics.checkNotNullExpressionValue(r5, "getString(...)");
        com.obric.oui.toast.a.C0786a.a(r2, r3, r5, 0, 4, null);
        r9.finish();
        return Unit.INSTANCE;
    L12:
        r1 = R.string.memory_create_memory_task_success_toast;
        r4 = "memory_create_memory_task_success_toast";
        goto L13
    L5:
        if (((i) ZeusTransformUtils.preCheckCast(r9.getViewModel().getState().c(), i.class, "com.obric.memorydata.plugin")).a().a() != null) goto L8;
        r0 = false;
        goto L9
    }

    private static final Unit onCreateChecked$lambda$20$lambda$16(MemoryTaskSettingsActivity r8) {
        MemoryTaskSettingsActivity r9 = (MemoryTaskSettingsActivity) ZeusTransformUtils.wrapperContextForParams(r8, MemoryTaskSettingsActivity.class, "com.obric.memorydata.plugin");
        com.obric.oui.toast.a.C0786a.a(com.obric.oui.toast.a.f14807a, (Context) ZeusTransformUtils.preCheckCast(r9, Context.class, "com.obric.memorydata.plugin"), "标题不符合规范，请修改后重试", 0, 4, null);
        return Unit.INSTANCE;
    }

    private static final Unit onCreateChecked$lambda$20$lambda$17(MemoryTaskSettingsActivity r8) {
        MemoryTaskSettingsActivity r9 = (MemoryTaskSettingsActivity) ZeusTransformUtils.wrapperContextForParams(r8, MemoryTaskSettingsActivity.class, "com.obric.memorydata.plugin");
        com.obric.oui.toast.a.C0786a.a(com.obric.oui.toast.a.f14807a, (Context) ZeusTransformUtils.preCheckCast(r9, Context.class, "com.obric.memorydata.plugin"), "生成失败，请稍后重试", 0, 4, null);
        return Unit.INSTANCE;
    }

    private static final Unit onCreateChecked$lambda$20$lambda$18(MemoryTaskSettingsActivity r8) {
        MemoryTaskSettingsActivity r9 = (MemoryTaskSettingsActivity) ZeusTransformUtils.wrapperContextForParams(r8, MemoryTaskSettingsActivity.class, "com.obric.memorydata.plugin");
        com.obric.oui.toast.a.C0786a r2 = com.obric.oui.toast.a.f14807a;
        Context r3 = (Context) ZeusTransformUtils.preCheckCast(r9, Context.class, "com.obric.memorydata.plugin");
        String r4 = r9.getString(ZeusTransformUtils.mapRes(R.string.memory_auto_memory_use_llm_max_limit, TypedValues.Custom.S_STRING, "memory_auto_memory_use_llm_max_limit"));
        Intrinsics.checkNotNullExpressionValue(r4, "getString(...)");
        com.obric.oui.toast.a.C0786a.a(r2, r3, r4, 0, 4, null);
        return Unit.INSTANCE;
    }

    private static final Unit onCreateChecked$lambda$20$lambda$19(MemoryTaskSettingsActivity r8) {
        MemoryTaskSettingsActivity r9 = (MemoryTaskSettingsActivity) ZeusTransformUtils.wrapperContextForParams(r8, MemoryTaskSettingsActivity.class, "com.obric.memorydata.plugin");
        com.obric.oui.toast.a.C0786a.a(com.obric.oui.toast.a.f14807a, (Context) ZeusTransformUtils.preCheckCast(r9, Context.class, "com.obric.memorydata.plugin"), "创建失败，请稍后重试", 0, 4, null);
        return Unit.INSTANCE;
    }

    private static final Unit onCreateChecked$lambda$21(MemoryTaskSettingsActivity r2, String r3) {
        MemoryTaskSettingsActivity r4 = (MemoryTaskSettingsActivity) ZeusTransformUtils.wrapperContextForParams(r2, MemoryTaskSettingsActivity.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "newId");
        r4.sessionId = r3;
        r4.getIntent().putExtra("session_id", r3);
        return Unit.INSTANCE;
    }

    private static final WindowInsetsCompat onCreateChecked$lambda$3(MemoryTaskSettingsActivity r4, View r5, WindowInsetsCompat r6) {
        MemoryTaskSettingsActivity r7 = (MemoryTaskSettingsActivity) ZeusTransformUtils.wrapperContextForParams(r4, MemoryTaskSettingsActivity.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "<unused var>");
        Intrinsics.checkNotNullParameter(r6, "insets");
        int r8 = r6.getInsets(WindowInsetsCompat.Type.navigationBars()).bottom;
        AutoMemoryProActivityMemoryTaskSettingsBinding r9 = r7.binding;
        Integer r0 = null;
        if (r9 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r9 = null;
    L5:
        FrameLayout r10 = r9.bottomBar;
        Intrinsics.checkNotNullExpressionValue(r10, "bottomBar");
        View r11 = (View) ZeusTransformUtils.preCheckCast(r10, View.class, "com.obric.memorydata.plugin");
        Integer r12 = Integer.valueOf(r8);
        if (((Number) ZeusTransformUtils.preCheckCast(r12, Number.class, "com.obric.memorydata.plugin")).intValue() <= 0) goto L8;
        boolean r2 = true;
    L9:
        if (r2 == false) goto L11;
        r0 = r12;
    L11:
        if (r0 == null) goto L13;
        int r13 = r0.intValue();
    L14:
        bb.c(r11, r13);
        return r6;
    L13:
        r13 = MathKt.roundToInt(TypedValue.applyDimension(1, ((Number) ZeusTransformUtils.preCheckCast(8, Number.class, "com.obric.memorydata.plugin")).floatValue(), Resources.getSystem().getDisplayMetrics()));
        goto L14
    L8:
        r2 = false;
        goto L9
    }

    private static final void onCreateChecked$lambda$5$lambda$4(MemoryTaskSettingsActivity r1, View r2) {
        ((MemoryTaskSettingsActivity) ZeusTransformUtils.wrapperContextForParams(r1, MemoryTaskSettingsActivity.class, "com.obric.memorydata.plugin")).showFormatEditDialog(2);
    }

    private static final void onCreateChecked$lambda$6(MemoryTaskSettingsActivity r1, View r2) {
        ((MemoryTaskSettingsActivity) ZeusTransformUtils.wrapperContextForParams(r1, MemoryTaskSettingsActivity.class, "com.obric.memorydata.plugin")).showFormatEditDialog(2);
    }

    private static final void onCreateChecked$lambda$8$lambda$7(MemoryTaskSettingsActivity r1, CompoundButton r2, boolean r3) {
        ((MemoryTaskSettingsActivity) ZeusTransformUtils.wrapperContextForParams(r1, MemoryTaskSettingsActivity.class, "com.obric.memorydata.plugin")).getViewModel().updateUseClientModel(r3);
    }

    private static final void onCreateChecked$lambda$9(MemoryTaskSettingsActivity r1, View r2) {
        AutoMemoryProActivityMemoryTaskSettingsBinding r3 = ((MemoryTaskSettingsActivity) ZeusTransformUtils.wrapperContextForParams(r1, MemoryTaskSettingsActivity.class, "com.obric.memorydata.plugin")).binding;
        if (r3 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r3 = null;
    L5:
        OSwitch r4 = r3.itemUseClientModel.getEndSwitch();
        if (r4 == null) goto L9;
        r4.performClick();
        return;
    }

    private final String readCurrentTitle() {
        AutoMemoryProActivityMemoryTaskSettingsBinding r2 = this.binding;
        String r0 = null;
        if (r2 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r2 = null;
    L5:
        Editable r3 = r2.nameInput.getVInput().getText();
        if (r3 == null) goto L8;
        r0 = r3.toString();
    L8:
        if (r0 != null) goto L11;
        r0 = "";
    L11:
        return StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r0, CharSequence.class, "com.obric.memorydata.plugin")).toString();
    }

    private final void showFormatEditDialog(final int r33) {
        i r0 = (i) ZeusTransformUtils.preCheckCast(getViewModel().getState().c(), i.class, "com.obric.memorydata.plugin");
        if (((CharSequence) ZeusTransformUtils.preCheckCast(this.sessionId, CharSequence.class, "com.obric.memorydata.plugin")).length() != 0) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == false) goto L9;
        return;
    L9:
        if (r33 == 0) goto L13;
        if (r33 == 2) goto L12;
        int r2 = ZeusTransformUtils.mapRes(R.string.memory_task_settings_subtitle_format, TypedValues.Custom.S_STRING, "memory_task_settings_subtitle_format");
        String r3 = r0.a().r().g();
    L14:
        String r8 = r3;
        int r16 = 50;
        int r7 = r2;
        boolean r17 = true;
    L15:
        if (r33 != 0) goto L17;
        boolean r18 = true;
    L18:
        final Ref.ObjectRef r6 = new Ref.ObjectRef();
        final Ref.ObjectRef r19 = new Ref.ObjectRef();
        final Ref.ObjectRef r20 = new Ref.ObjectRef();
        final Ref.BooleanRef r21 = new Ref.BooleanRef();
        final Ref.ObjectRef r22 = new Ref.ObjectRef();
        final int r9 = r16;
        int r24 = r7;
        final String r10 = r8;
        final String r25 = r8;
        com.obric.oui.dialog.alert.d r5 = new com.obric.oui.dialog.alert.d(new $$Lambda$MemoryTaskSettingsActivity$KxI3mOTplYFhTB23pEBhIOS3CD4(this, r22, r6, r19, r20, r9, r10, r21));
        final Ref.BooleanRef r4 = new Ref.BooleanRef();
        com.obric.oui.dialog.alert.c r26 = com.obric.oui.dialog.alert.c.a(com.obric.oui.dialog.alert.c.a(new com.obric.oui.dialog.alert.c((Context) ZeusTransformUtils.preCheckCast(this, Context.class, "com.obric.memorydata.plugin")).b(false), (CharSequence) ZeusTransformUtils.preCheckCast(getString(r24), CharSequence.class, "com.obric.memorydata.plugin"), false, 2, null).a((com.obric.oui.dialog.alert.e) ZeusTransformUtils.preCheckCast(r5, com.obric.oui.dialog.alert.e.class, "com.obric.memorydata.plugin")), false, 1, null);
        String r11 = getString(ZeusTransformUtils.mapRes(R.string.memory_task_settings_format_dialog_cancel, TypedValues.Custom.S_STRING, "memory_task_settings_format_dialog_cancel"));
        Intrinsics.checkNotNullExpressionValue(r11, "getString(...)");
        com.obric.oui.dialog.alert.c r12 = com.obric.oui.dialog.alert.c.b(r26, (CharSequence) ZeusTransformUtils.preCheckCast(r11, CharSequence.class, "com.obric.memorydata.plugin"), $$Lambda$MemoryTaskSettingsActivity$SfFCxswWDE7V_GgxBFXcpzGs.INSTANCE, null, 4, null);
        String r13 = getString(ZeusTransformUtils.mapRes(R.string.memory_task_settings_format_dialog_confirm, TypedValues.Custom.S_STRING, "memory_task_settings_format_dialog_confirm"));
        Intrinsics.checkNotNullExpressionValue(r13, "getString(...)");
        final boolean r14 = r17;
        final boolean r15 = r18;
        com.obric.oui.dialog.alert.b r23 = com.obric.oui.dialog.alert.c.a(r12, (CharSequence) ZeusTransformUtils.preCheckCast(r13, CharSequence.class, "com.obric.memorydata.plugin"), new $$Lambda$MemoryTaskSettingsActivity$Rc0Mz9soSz7IAMUrtc49AnW4CKk(r4, r6, r20, r22, r25, r14, this, r33, r15), null, 4, null).g();
        com.obric.oui.dialog.alert.b r27 = (com.obric.oui.dialog.alert.b) ZeusTransformUtils.preCheckCast(r23, com.obric.oui.dialog.alert.b.class, "com.obric.memorydata.plugin");
        r27.setCanceledOnTouchOutside(true);
        r27.setCancelable(true);
        showFormatEditDialog$lambda$40$applyEnabledStyle(r27, this, true ^ StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r25, CharSequence.class, "com.obric.memorydata.plugin")));
        OInputLayout r28 = (OInputLayout) ZeusTransformUtils.preCheckCast(r6.element, OInputLayout.class, "com.obric.memorydata.plugin");
        if (r28 == null) goto L23;
        OEditText r29 = r28.getVInput();
        if (r29 == null) goto L23;
        r29.addTextChangedListener((TextWatcher) ZeusTransformUtils.preCheckCast(new c(r21, r20, r22, r19, r16, r27, this), TextWatcher.class, "com.obric.memorydata.plugin"));
    L23:
        ((com.obric.oui.dialog.alert.b) ZeusTransformUtils.preCheckCast(r23, com.obric.oui.dialog.alert.b.class, "com.obric.memorydata.plugin")).show();
        return;
    L17:
        r18 = false;
        goto L18
    L12:
        int r30 = ZeusTransformUtils.mapRes(R.string.memory_task_settings_name_dialog_title, TypedValues.Custom.S_STRING, "memory_task_settings_name_dialog_title");
        r8 = r0.a().b();
        r16 = 8;
        r7 = r30;
        r17 = false;
        goto L15
    L13:
        r2 = ZeusTransformUtils.mapRes(R.string.memory_task_settings_title_format, TypedValues.Custom.S_STRING, "memory_task_settings_title_format");
        r3 = r0.a().r().f();
        goto L14
    L5:
        r1 = false;
        goto L6
    }

    /* JADX WARN: Type inference failed for: r0v16, types: [T, android.widget.TextView, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r11v13, types: [T, com.obric.memorydata.memory.ui.automemory.settings.-$$Lambda$MemoryTaskSettingsActivity$G9hP5gePI4UtmkNN9ncY9MYdG_U] */
    /* JADX WARN: Type inference failed for: r2v9, types: [T, android.widget.TextView, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r9v3, types: [T, com.obric.oui.forms.OInputLayout, java.lang.Object] */
    private static final Unit showFormatEditDialog$lambda$37(MemoryTaskSettingsActivity r16, Ref.ObjectRef r17, Ref.ObjectRef r18, Ref.ObjectRef r19, Ref.ObjectRef r20, int r21, String r22, final Ref.BooleanRef r23, FrameLayout r24) {
        final MemoryTaskSettingsActivity r4 = (MemoryTaskSettingsActivity) ZeusTransformUtils.wrapperContextForParams(r16, MemoryTaskSettingsActivity.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r24, "container");
        LinearLayout r6 = new LinearLayout((Context) ZeusTransformUtils.preCheckCast(r4, Context.class, "com.obric.memorydata.plugin"));
        r6.setOrientation(1);
        FrameLayout r8 = new FrameLayout((Context) ZeusTransformUtils.preCheckCast(r4, Context.class, "com.obric.memorydata.plugin"));
        final ?? r9 = new OInputLayout((Context) ZeusTransformUtils.preCheckCast(r4, Context.class, "com.obric.memorydata.plugin"), null, 0, 6, null);
        r9.setType(1);
        r9.a(true);
        r9.c(false);
        r9.e(false);
        r9.g(false);
        r9.setLimitCount(r21);
        r9.setAutoChangeWithLimit(true);
        r9.getVInput().setTextSize(2, 16.0f);
        r9.getVInput().setInputType(131073);
        r9.getVInput().setGravity(MaterialCardView.CHECKED_ICON_GRAVITY_TOP_START);
        r9.getVInput().setMaxLines(6);
        r9.getVInput().setFilters((InputFilter[]) ZeusTransformUtils.preCheckCast(new InputFilter.LengthFilter[]{new InputFilter.LengthFilter(r21)}, InputFilter[].class, "com.obric.memorydata.plugin"));
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r22, CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L5;
        boolean r11 = true;
    L6:
        if (r11 == false) goto L12;
        r9.setText((CharSequence) ZeusTransformUtils.preCheckCast(r22, CharSequence.class, "com.obric.memorydata.plugin"));
        OEditText r2 = r9.getVInput();
        Editable r12 = r9.getVInput().getText();
        if (r12 == null) goto L10;
        int r13 = r12.length();
    L11:
        r2.setSelection(r13);
        goto L12
    L10:
        r13 = 0;
    L12:
        final int r3 = r9.getVInput().getHighlightColor();
        r17.element = new $$Lambda$MemoryTaskSettingsActivity$G9hP5gePI4UtmkNN9ncY9MYdG_U(r23, r9, r4, r3);
        int r5 = ZeusTransformUtils.getIdentifier(ZeusTransformUtils.getResources(r4, "com.obric.memorydata.plugin"), "helper_container", OaidModel.KEY_ID, r4.getPackageName(), "com.obric.memorydata.plugin");
        if (r5 == 0) goto L17;
        View r7 = r9.findViewById(r5);
        if (r7 == null) goto L17;
        r7.setVisibility(8);
    L17:
        r18.element = r9;
        r8.addView((View) ZeusTransformUtils.preCheckCast(r9, View.class, "com.obric.memorydata.plugin"), (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(new FrameLayout.LayoutParams(-1, -2), ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin"));
        ?? r10 = new TextView((Context) ZeusTransformUtils.preCheckCast(r4, Context.class, "com.obric.memorydata.plugin"));
        r10.setTextSize(2, 10.0f);
        r10.setTextColor(r4.getColor(ZeusTransformUtils.mapRes(R.color.oui_basic_text_3, TypedValues.Custom.S_COLOR, "oui_basic_text_3")));
        StringBuilder r14 = new StringBuilder();
        OInputLayout r0 = (OInputLayout) ZeusTransformUtils.preCheckCast(r18.element, OInputLayout.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L24;
        OEditText r1 = r0.getVInput();
        if (r1 == null) goto L24;
        Editable r15 = r1.getText();
        if (r15 == null) goto L24;
        int r25 = r15.length();
    L25:
        r10.setText((CharSequence) ZeusTransformUtils.preCheckCast(r14.append(r25).append('/').append(r21).toString(), CharSequence.class, "com.obric.memorydata.plugin"));
        r19.element = r10;
        View r26 = (View) ZeusTransformUtils.preCheckCast(r10, View.class, "com.obric.memorydata.plugin");
        FrameLayout.LayoutParams r27 = new FrameLayout.LayoutParams(-2, -2);
        r27.gravity = MaterialCardView.CHECKED_ICON_GRAVITY_BOTTOM_END;
        float r28 = 12;
        r27.setMarginEnd(MathKt.roundToInt(TypedValue.applyDimension(1, r28, Resources.getSystem().getDisplayMetrics())));
        r27.bottomMargin = MathKt.roundToInt(TypedValue.applyDimension(1, 8, Resources.getSystem().getDisplayMetrics()));
        Unit r110 = Unit.INSTANCE;
        r8.addView(r26, (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r27, ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin"));
        ?? r29 = new TextView((Context) ZeusTransformUtils.preCheckCast(r4, Context.class, "com.obric.memorydata.plugin"));
        r29.setVisibility(8);
        r29.setGravity(8388627);
        r29.setTextSize(2, 10.0f);
        r29.setTextColor(r4.getColor(ZeusTransformUtils.mapRes(R.color.oui_functional_red_6, TypedValues.Custom.S_COLOR, "oui_functional_red_6")));
        float r111 = 5;
        r29.setPadding(MathKt.roundToInt(TypedValue.applyDimension(1, r28, Resources.getSystem().getDisplayMetrics())), MathKt.roundToInt(TypedValue.applyDimension(1, r111, Resources.getSystem().getDisplayMetrics())), MathKt.roundToInt(TypedValue.applyDimension(1, r28, Resources.getSystem().getDisplayMetrics())), MathKt.roundToInt(TypedValue.applyDimension(1, r111, Resources.getSystem().getDisplayMetrics())));
        r20.element = r29;
        r6.addView((View) ZeusTransformUtils.preCheckCast(r8, View.class, "com.obric.memorydata.plugin"), (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(new LinearLayout.LayoutParams(-1, -2), ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin"));
        r6.addView((View) ZeusTransformUtils.preCheckCast(r29, View.class, "com.obric.memorydata.plugin"), (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(new LinearLayout.LayoutParams(-1, -2), ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin"));
        FrameLayout.LayoutParams r30 = new FrameLayout.LayoutParams(-1, -2);
        float r31 = 20;
        r30.leftMargin = MathKt.roundToInt(TypedValue.applyDimension(1, r31, Resources.getSystem().getDisplayMetrics()));
        r30.rightMargin = MathKt.roundToInt(TypedValue.applyDimension(1, r31, Resources.getSystem().getDisplayMetrics()));
        r30.bottomMargin = ZeusTransformUtils.getResources(r4, "com.obric.memorydata.plugin").getDimensionPixelSize(ZeusTransformUtils.mapRes(R.dimen.oui_p_container_1, "dimen", "oui_p_container_1"));
        r24.addView((View) ZeusTransformUtils.preCheckCast(r6, View.class, "com.obric.memorydata.plugin"), (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r30, ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin"));
        r9.postDelayed(new $$Lambda$MemoryTaskSettingsActivity$jzyKVL9WdBuoejvkhX__XviqvEg(r4, r9), 100);
        return Unit.INSTANCE;
    L24:
        r25 = 0;
        goto L25
    L5:
        r11 = false;
        goto L6
    }

    private static final Unit showFormatEditDialog$lambda$37$lambda$30(Ref.BooleanRef r2, OInputLayout r3, MemoryTaskSettingsActivity r4, int r5, boolean r6) {
        MemoryTaskSettingsActivity r7 = (MemoryTaskSettingsActivity) ZeusTransformUtils.wrapperContextForParams(r4, MemoryTaskSettingsActivity.class, "com.obric.memorydata.plugin");
        r2.element = r6;
        OEditText r8 = r3.getVInput();
        if (r6 == false) goto L5;
        r5 = r7.getColor(ZeusTransformUtils.mapRes(R.color.oui_functional_red_2, TypedValues.Custom.S_COLOR, "oui_functional_red_2"));
    L5:
        r8.setHighlightColor(r5);
        if (Build.VERSION.SDK_INT < 29) goto L12;
        OEditText r9 = r3.getVInput();
        if (r6 == false) goto L10;
        int r10 = R.drawable.o_input_cursor_red;
        String r0 = "o_input_cursor_red";
    L11:
        r9.setTextCursorDrawable(ZeusTransformUtils.mapRes(r10, "drawable", r0));
        goto L12
    L10:
        r10 = R.drawable.o_input_cursor_blue;
        r0 = "o_input_cursor_blue";
    L12:
        if (r6 == false) goto L15;
        r3.getVInput().requestFocus();
        r3.getVInput().selectAll();
    L15:
        return Unit.INSTANCE;
    }

    private static final void showFormatEditDialog$lambda$37$lambda$36(MemoryTaskSettingsActivity r2, OInputLayout r3) {
        MemoryTaskSettingsActivity r4 = (MemoryTaskSettingsActivity) ZeusTransformUtils.wrapperContextForParams(r2, MemoryTaskSettingsActivity.class, "com.obric.memorydata.plugin");
        Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L5
        Result.m1421constructorimpl(Boolean.valueOf(r3.getVInput().requestFocus()));     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        Result.Companion r6 = Result.Companion;
        Result.m1421constructorimpl(ResultKt.createFailure(th));
    }

    private static final void showFormatEditDialog$lambda$38(DialogInterface r1, int r2) {
        ((DialogInterface) ZeusTransformUtils.wrapperContextForParams(r1, DialogInterface.class, "com.obric.memorydata.plugin")).dismiss();
    }

    private static final void showFormatEditDialog$lambda$39(Ref.BooleanRef r16, Ref.ObjectRef r17, Ref.ObjectRef r18, Ref.ObjectRef r19, String r20, boolean r21, MemoryTaskSettingsActivity r22, int r23, boolean r24, DialogInterface r25, int r26) {
        MemoryTaskSettingsActivity r3 = (MemoryTaskSettingsActivity) ZeusTransformUtils.wrapperContextForParams(r22, MemoryTaskSettingsActivity.class, "com.obric.memorydata.plugin");
        DialogInterface r7 = (DialogInterface) ZeusTransformUtils.wrapperContextForParams(r25, DialogInterface.class, "com.obric.memorydata.plugin");
        if (r16.element == false) goto L5;
        return;
    L5:
        OInputLayout r0 = (OInputLayout) ZeusTransformUtils.preCheckCast(r17.element, OInputLayout.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L14;
        OEditText r1 = r0.getVInput();
        if (r1 == null) goto L14;
        Editable r2 = r1.getText();
        if (r2 == null) goto L14;
        String r4 = r2.toString();
        if (r4 == null) goto L14;
        String r5 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.memorydata.plugin")).toString();
    L15:
        if (r5 != null) goto L17;
        r5 = "";
    L17:
        String r6 = r5;
        TextView r8 = (TextView) ZeusTransformUtils.preCheckCast(r18.element, TextView.class, "com.obric.memorydata.plugin");
        if (r8 == null) goto L20;
        r8.setVisibility(8);
    L20:
        TextView r9 = (TextView) ZeusTransformUtils.preCheckCast(r18.element, TextView.class, "com.obric.memorydata.plugin");
        if (r9 == null) goto L23;
        r9.setText(null);
    L23:
        Function1 r10 = (Function1) ZeusTransformUtils.preCheckCast(r19.element, Function1.class, "com.obric.memorydata.plugin");
        if (r10 == null) goto L27;
        r10.invoke(false);
    L27:
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.memorydata.plugin")) == false) goto L30;
        return;
    L30:
        if (Intrinsics.areEqual(r6, StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r20, CharSequence.class, "com.obric.memorydata.plugin")).toString()) == false) goto L34;
        r7.dismiss();
        return;
    L34:
        if (r21 == true) goto L37;
        r3.applyDialogResult(r23, r6);
        r7.dismiss();
        return;
    L37:
        r16.element = true;
        if (r24 == false) goto L40;
        int r11 = R.string.memory_task_settings_title_format;
        String r12 = "memory_task_settings_title_format";
    L41:
        String r13 = r3.getString(ZeusTransformUtils.mapRes(r11, TypedValues.Custom.S_STRING, r12));
        Intrinsics.checkNotNullExpressionValue(r13, "getString(...)");
        kotlinx.coroutines.i.a((al) ZeusTransformUtils.preCheckCast(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) ZeusTransformUtils.preCheckCast(r3, LifecycleOwner.class, "com.obric.memorydata.plugin")), al.class, "com.obric.memorydata.plugin"), null, null, (Function2) ZeusTransformUtils.preCheckCast(new MemoryTaskSettingsActivity$showFormatEditDialog$2$1(r16, r18, r3, r19, r23, r6, r7, r24, r13, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
        return;
    L40:
        r11 = R.string.memory_task_settings_subtitle_format;
        r12 = "memory_task_settings_subtitle_format";
    L14:
        r5 = null;
        goto L15
    }

    private static final void showFormatEditDialog$lambda$40$applyEnabledStyle(com.obric.oui.dialog.alert.b r2, MemoryTaskSettingsActivity r3, boolean r4) {
        MemoryTaskSettingsActivity r5 = (MemoryTaskSettingsActivity) ZeusTransformUtils.wrapperContextForParams(r3, MemoryTaskSettingsActivity.class, "com.obric.memorydata.plugin");
        OButton r6 = r2.f();
        if (ZeusTransformUtils.instanceOf(r6, TextView.class) == false) goto L5;
        TextView r7 = (TextView) ZeusTransformUtils.preCheckCast(r6, TextView.class, "com.obric.memorydata.plugin");
    L6:
        if (r7 == null) goto L8;
        r7.setEnabled(r4);
    L8:
        if (r7 != null) goto L10;
        return;
    L10:
        if (r4 == false) goto L12;
        int r8 = R.color.oui_functional_blue_6;
        String r1 = "oui_functional_blue_6";
    L13:
        r7.setTextColor(r5.getColor(ZeusTransformUtils.mapRes(r8, TypedValues.Custom.S_COLOR, r1)));
        return;
    L12:
        r8 = R.color.oui_functional_blue_4;
        r1 = "oui_functional_blue_4";
        goto L13
    L5:
        r7 = null;
        goto L6
    }

    @Override // com.obric.memorydata.ui.BaseActivity
    public NavigationBarScheme getNavigationBarScheme() {
        return this.navigationBarScheme;
    }

    @Override // com.obric.memorydata.ui.BaseActivity
    public void onCreateChecked(Bundle r12) {
        setupInset();
        prepareSystemBar();
        AutoMemoryProActivityMemoryTaskSettingsBinding r0 = AutoMemoryProActivityMemoryTaskSettingsBinding.inflate(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(r0, "inflate(...)");
        this.binding = r0;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r0 = null;
    L5:
        setContentView((View) ZeusTransformUtils.preCheckCast(r0.getRoot(), View.class, "com.obric.memorydata.plugin"));
        AutoMemoryProActivityMemoryTaskSettingsBinding r1 = this.binding;
        if (r1 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r1 = null;
    L8:
        View r2 = (View) ZeusTransformUtils.preCheckCast(r1.viewTitle, View.class, "com.obric.memorydata.plugin");
        AutoMemoryProActivityMemoryTaskSettingsBinding r3 = this.binding;
        if (r3 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r3 = null;
    L11:
        setupCutOffArea(r2, r3.cutOff);
        AutoMemoryProActivityMemoryTaskSettingsBinding r4 = this.binding;
        if (r4 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r4 = null;
    L14:
        OFloatingTitleBar.a(r4.viewTitle, ZeusTransformUtils.mapRes(R.drawable.o_floating_title_bar_icon_back, "drawable", "o_floating_title_bar_icon_back"), 0, new $$Lambda$MemoryTaskSettingsActivity$KCfEUMFO7tn5VQqpa5wxZhzD9Vk(this), 2, null);
        AutoMemoryProActivityMemoryTaskSettingsBinding r5 = this.binding;
        if (r5 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r5 = null;
    L17:
        OFloatingTitleBar r6 = r5.viewTitle;
        Intrinsics.checkNotNullExpressionValue(r6, "viewTitle");
        registerFloatingTitleBar(r6);
        getOnBackPressedDispatcher().addCallback((LifecycleOwner) ZeusTransformUtils.preCheckCast(this, LifecycleOwner.class, "com.obric.memorydata.plugin"), (OnBackPressedCallback) ZeusTransformUtils.preCheckCast(new AnonymousClass2(this), OnBackPressedCallback.class, "com.obric.memorydata.plugin"));
        AutoMemoryProActivityMemoryTaskSettingsBinding r7 = this.binding;
        if (r7 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r7 = null;
    L20:
        ViewCompat.setOnApplyWindowInsetsListener((View) ZeusTransformUtils.preCheckCast(r7.getRoot(), View.class, "com.obric.memorydata.plugin"), new $$Lambda$MemoryTaskSettingsActivity$sXTYzT6966YwLGq9g54vYh560A0(this));
        AutoMemoryProActivityMemoryTaskSettingsBinding r8 = this.binding;
        if (r8 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r8 = null;
    L23:
        ViewCompat.requestApplyInsets((View) ZeusTransformUtils.preCheckCast(r8.getRoot(), View.class, "com.obric.memorydata.plugin"));
        AutoMemoryProActivityMemoryTaskSettingsBinding r9 = this.binding;
        if (r9 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r9 = null;
    L26:
        OEditText r10 = r9.nameInput.getVInput();
        boolean r11 = false;
        r10.setFocusable(false);
        r10.setFocusableInTouchMode(false);
        r10.setLongClickable(false);
        r10.setCursorVisible(false);
        r10.setKeyListener(null);
        r10.setOnClickListener(new $$Lambda$MemoryTaskSettingsActivity$G_JzXywvvb3ll2C7AHS6T21klvA(this));
        AutoMemoryProActivityMemoryTaskSettingsBinding r13 = this.binding;
        if (r13 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r13 = null;
    L29:
        r13.nameInput.setOnClickListener(new $$Lambda$MemoryTaskSettingsActivity$Io4kylLUwTdSlsFOHXaA2i5w0Oo(this));
        if (AppContext.INSTANCE.isDebug() == false) goto L32;
    L35:
        boolean r14 = true;
    L36:
        AutoMemoryProActivityMemoryTaskSettingsBinding r15 = this.binding;
        if (r15 != null) goto L39;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r15 = null;
    L39:
        OCardListItem r16 = r15.itemUseClientModel;
        int r17 = 8;
        if (r14 == false) goto L42;
        int r18 = 0;
    L43:
        r16.setVisibility(r18);
        AutoMemoryProActivityMemoryTaskSettingsBinding r19 = this.binding;
        if (r19 != null) goto L46;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r19 = null;
    L46:
        TextView r20 = r19.tvClientModelSection;
        if (r14 == false) goto L49;
        r17 = 0;
    L49:
        r20.setVisibility(r17);
        AutoMemoryProActivityMemoryTaskSettingsBinding r21 = this.binding;
        if (r21 != null) goto L52;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r21 = null;
    L52:
        OSwitch r22 = r21.itemUseClientModel.getEndSwitch();
        if (r22 == null) goto L55;
        r22.setOnCheckedChangeListener(new $$Lambda$MemoryTaskSettingsActivity$zb78PA79eZ468HPHdlrxHA7xyc8(this));
    L55:
        AutoMemoryProActivityMemoryTaskSettingsBinding r23 = this.binding;
        if (r23 != null) goto L58;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r23 = null;
    L58:
        r23.itemUseClientModel.setOnContentClickListener(new $$Lambda$MemoryTaskSettingsActivity$SRxT6xQtA7dGw4fKVb6XChQKMWQ(this));
        AutoMemoryProActivityMemoryTaskSettingsBinding r24 = this.binding;
        if (r24 != null) goto L61;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r24 = null;
    L61:
        r24.itemPaymentBehavior.setOnContentClickListener(new $$Lambda$MemoryTaskSettingsActivity$yIKlnlrTCwTTd8vpMwt_W3tkGbA(this));
        AutoMemoryProActivityMemoryTaskSettingsBinding r25 = this.binding;
        if (r25 != null) goto L64;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r25 = null;
    L64:
        r25.itemPaymentInfo.setOnContentClickListener(new $$Lambda$MemoryTaskSettingsActivity$CjtYaOtjKMsQXKUv3J_n40e8oP0(this));
        AutoMemoryProActivityMemoryTaskSettingsBinding r26 = this.binding;
        if (r26 != null) goto L67;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r26 = null;
    L67:
        r26.itemUpdateRule.setOnContentClickListener(new $$Lambda$MemoryTaskSettingsActivity$dUPgqczvVklFMzikX6K6nc13LY(this));
        AutoMemoryProActivityMemoryTaskSettingsBinding r27 = this.binding;
        if (r27 != null) goto L70;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r27 = null;
    L70:
        r27.itemTitleFormat.setOnContentClickListener(new $$Lambda$MemoryTaskSettingsActivity$ya3vRUQKoL__UoZZo_7Ffk3cbZE(this));
        AutoMemoryProActivityMemoryTaskSettingsBinding r28 = this.binding;
        if (r28 != null) goto L73;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r28 = null;
    L73:
        r28.itemSubtitleFormat.setOnContentClickListener(new $$Lambda$MemoryTaskSettingsActivity$7JCMPngkqvWLg2SZoAbreoJNjIs(this));
        AutoMemoryProActivityMemoryTaskSettingsBinding r29 = this.binding;
        if (r29 != null) goto L76;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r29 = null;
    L76:
        r29.btnCreate.setOnClickListener(new $$Lambda$MemoryTaskSettingsActivity$W8e6oJz_7O5sr2DVCT10UZyu9V8(this));
        if (r12 == null) goto L79;
        String r110 = r12.getString(STATE_SESSION_ID);
    L80:
        String r30 = "";
        if (r110 != null) goto L83;
        r110 = "";
    L83:
        this.sessionId = r110;
        long r31 = getIntent().getLongExtra(EXTRA_EDIT_RULE_ID, -1);
        if (r31 <= 0) goto L86;
        boolean r32 = true;
    L87:
        this.isEditMode = r32;
        if (((CharSequence) ZeusTransformUtils.preCheckCast(this.sessionId, CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L90;
        boolean r33 = true;
    L91:
        if (r33 == false) goto L96;
        if (g.f10759a.b(this.sessionId) != null) goto L96;
        this.sessionId = "";
    L96:
        if (((CharSequence) ZeusTransformUtils.preCheckCast(this.sessionId, CharSequence.class, "com.obric.memorydata.plugin")).length() != 0) goto L98;
        boolean r34 = true;
    L99:
        if (r34 == false) goto L106;
        String r35 = getIntent().getStringExtra("session_id");
        if (r35 == null) goto L104;
        r30 = r35;
    L104:
        this.sessionId = r30;
    L106:
        if (((CharSequence) ZeusTransformUtils.preCheckCast(this.sessionId, CharSequence.class, "com.obric.memorydata.plugin")).length() != 0) goto L108;
        boolean r36 = true;
    L109:
        if (r36 == false) goto L113;
        if (r31 <= 0) goto L113;
        getViewModel().bootstrapForEdit(r31, new $$Lambda$MemoryTaskSettingsActivity$pui4hEMvhX0VMQXaI3gVbzUMrLU(this));
    L117:
        kotlinx.coroutines.i.a((al) ZeusTransformUtils.preCheckCast(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) ZeusTransformUtils.preCheckCast(this, LifecycleOwner.class, "com.obric.memorydata.plugin")), al.class, "com.obric.memorydata.plugin"), null, null, (Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass15(this, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
        return;
    L113:
        if (((CharSequence) ZeusTransformUtils.preCheckCast(this.sessionId, CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L115;
        r11 = true;
    L115:
        if (r11 == false) goto L119;
        getViewModel().bind(this.sessionId);
        goto L117
    L119:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "no sessionId nor editRuleId, finish", null, 4, null);
        finish();
        return;
    L108:
        r36 = false;
        goto L109
    L98:
        r34 = false;
        goto L99
    L90:
        r33 = false;
        goto L91
    L86:
        r32 = false;
        goto L87
    L79:
        r110 = null;
        goto L80
    L42:
        r18 = 8;
        goto L43
    L32:
        if (l.f11479a.a().u() == true) goto L35;
        r14 = false;
        goto L36
    }

    @Override // com.obric.memorydata.ui.BaseAuthActivity, com.obric.memorydata.ui.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity
    public void onDestroy() {
        super.onDestroy();
        if (isFinishing() == true) goto L5;
        return;
    L5:
        if (((CharSequence) ZeusTransformUtils.preCheckCast(this.sessionId, CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L7;
        boolean r0 = true;
    L8:
        if (r0 == true) goto L10;
        return;
    L10:
        if (getViewModel().isCommitted() == true) goto L15;
        g.f10759a.c(this.sessionId);
        return;
    L15:
        return;
    L7:
        r0 = false;
        goto L8
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity
    public void onSaveInstanceState(Bundle r4) {
        Intrinsics.checkNotNullParameter(r4, "outState");
        super.onSaveInstanceState(r4);
        if (((CharSequence) ZeusTransformUtils.preCheckCast(this.sessionId, CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L9;
        r4.putString(STATE_SESSION_ID, this.sessionId);
        return;
    L9:
        return;
    L5:
        r0 = false;
        goto L6
    }
}
