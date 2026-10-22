package com.obric.memorydata.memory.ui.automemory.settings;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.IBinder;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.activity.ComponentActivity;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.widget.NestedScrollView;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelLazy;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.google.android.material.card.MaterialCardView;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.aikernel.core.data.IdlErrors;
import com.obric.memorydata.memory.databinding.AutoMemoryProActivityMemoryInfoSectionEditBinding;
import com.obric.memorydata.memory.ui.BaseMemoryActivity;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.personalcontext.api.IPersonalContextAPI;
import com.obric.memorydata.plugin.R;
import com.obric.memorydata.task.condition.Condition;
import com.obric.memorydata.task.impl.TaskInfo;
import com.obric.memorydata.task.impl.TaskRequest;
import com.obric.memorydata.task.scheduler.impl.ExistingTaskPolicy;
import com.obric.memorydata.ui.NavigationBarScheme;
import com.obric.memorydata.utils.bb;
import com.obric.oui.forms.OEditText;
import com.obric.oui.forms.OInputLayout;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.lisitem.OUICardConstraintLayout;
import com.obric.oui.popover.menu.OPopoverEntranceMenuView;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.KotlinNothingValueException;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IndexedValue;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
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
import kotlinx.coroutines.am;
import kotlinx.coroutines.ar;
import kotlinx.coroutines.bx;
import kotlinx.coroutines.da;
import kotlinx.coroutines.n;
import kotlinx.coroutines.o;
import net.zetetic.database.sqlcipher.SQLiteDatabase;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 =2\u00020\u0001:\u0001=B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0014J\u0010\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\b\u0010\u0017\u001a\u00020\u0011H\u0002J\u0010\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\u0010\u0010\u001b\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\u0010\u0010\u001c\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\u001a\u0010\u001d\u001a\u00020\u00112\u0006\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!H\u0002J\u0017\u0010\"\u001a\u00020\u00112\b\u0010#\u001a\u0004\u0018\u00010$H\u0002¢\u0006\u0002\u0010%J\u0010\u0010&\u001a\u00020\u00112\u0006\u0010'\u001a\u00020$H\u0002J\"\u0010(\u001a\u00020\u00112\u0006\u0010)\u001a\u00020*2\u0006\u0010'\u001a\u00020$2\b\u0010+\u001a\u0004\u0018\u00010,H\u0002J>\u0010-\u001a\u00020.2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010/\u001a\u0002002\f\u00101\u001a\b\u0012\u0004\u0012\u00020\u0016022\b\u0010#\u001a\u0004\u0018\u00010$2\u0006\u00103\u001a\u00020\u0016H\u0082@¢\u0006\u0002\u00104J\u0010\u00105\u001a\u0002062\u0006\u00107\u001a\u000208H\u0002J\u001e\u00109\u001a\u0002082\u0006\u0010:\u001a\u00020\u00162\u0006\u0010 \u001a\u000208H\u0082@¢\u0006\u0002\u0010;J\u0010\u0010<\u001a\u00020$2\u0006\u0010\u0015\u001a\u00020\u0016H\u0002R\u0014\u0010\u0004\u001a\u00020\u00058TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0082.¢\u0006\u0002\n\u0000R\u001b\u0010\n\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\r¨\u0006>"}, d2 = {"Lcom/obric/memorydata/memory/ui/automemory/settings/MemoryInfoSectionEditActivity;", "Lcom/obric/memorydata/memory/ui/BaseMemoryActivity;", "<init>", "()V", "navigationBarScheme", "Lcom/obric/memorydata/ui/NavigationBarScheme;", "getNavigationBarScheme", "()Lcom/obric/memorydata/ui/NavigationBarScheme;", "binding", "Lcom/obric/memorydata/memory/databinding/AutoMemoryProActivityMemoryInfoSectionEditBinding;", "viewModel", "Lcom/obric/memorydata/memory/ui/automemory/settings/MemoryInfoSectionEditViewModel;", "getViewModel", "()Lcom/obric/memorydata/memory/ui/automemory/settings/MemoryInfoSectionEditViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "onCreateChecked", "", "savedInstanceState", "Landroid/os/Bundle;", "setupSceneMode", MemoryInfoSectionEditActivity.EXTRA_KIND, "", "setupInfoMode", "bindState", "state", "Lcom/obric/memorydata/memory/ui/automemory/settings/MemoryInfoSectionEditUiState;", "bindSceneState", "bindInfoState", "dismissWithKeyboardHidden", "dialog", "Landroid/content/DialogInterface;", "input", "Lcom/obric/oui/forms/OInputLayout;", "showRuleEditDialog", "editIndex", "", "(Ljava/lang/Integer;)V", "showDeleteConfirmDialog", "itemIndex", "showItemMenu", "anchor", "Landroid/view/View;", "rawPos", "", "auditRuleInput", "Lcom/obric/memorydata/memory/ui/automemory/settings/RuleAuditDecision;", "memoryInfo", "Lcom/obric/memorydata/memory/ui/automemory/settings/MemoryInfo;", "existingItems", "", "candidateText", "(Ljava/lang/String;Lcom/obric/memorydata/memory/ui/automemory/settings/MemoryInfo;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "parseAuditTaskResult", "Lcom/obric/memorydata/memory/ui/automemory/settings/AuditTaskResult;", "result", "Lorg/json/JSONObject;", "runAlgoTask", ActivityLifecycle.NAME, "(Ljava/lang/String;Lorg/json/JSONObject;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sectionTitleResId", "Companion", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class MemoryInfoSectionEditActivity extends BaseMemoryActivity {
    public static final a Companion = null;
    private static final long DIALOG_DISMISS_AFTER_IME_DELAY_MS = 220;
    public static final String EXTRA_KIND = "kind";
    public static final String EXTRA_SESSION_ID = "session_id";
    public static final String KIND_INFO = "info";
    public static final String KIND_SCENE = "scene";
    public static final String KIND_UPDATE_RULE = "update_rule";
    private static final int RULE_ADD_LIMIT = 100;
    private static final int RULE_EDIT_LIMIT = 100;
    private static final int SCENE_LIMIT = 2000;
    private static final String TAG = "MemoryInfoSectionEdit";
    private static final long TASK_TIMEOUT_EXTRA_MS = 2000;
    private static final long TASK_TIMEOUT_SEC = 10;
    private AutoMemoryProActivityMemoryInfoSectionEditBinding binding;
    private final Lazy viewModel$delegate;

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\rX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/obric/memorydata/memory/ui/automemory/settings/MemoryInfoSectionEditActivity$Companion;", "", "<init>", "()V", "DIALOG_DISMISS_AFTER_IME_DELAY_MS", "", "EXTRA_SESSION_ID", "", "EXTRA_KIND", "KIND_SCENE", "KIND_INFO", "KIND_UPDATE_RULE", "RULE_ADD_LIMIT", "", "RULE_EDIT_LIMIT", "SCENE_LIMIT", "TASK_TIMEOUT_SEC", "TASK_TIMEOUT_EXTRA_MS", "TAG", CommonConsts.APM_INNER_EVENT_COST_START, "", "context", "Landroid/content/Context;", ObricMemoryConstants.KEY_SESSION_ID, MemoryInfoSectionEditActivity.EXTRA_KIND, "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }

        public final void a(Context r4, String r5, String r6) {
            Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, "context");
            Intrinsics.checkNotNullParameter(r5, ObricMemoryConstants.KEY_SESSION_ID);
            Intrinsics.checkNotNullParameter(r6, MemoryInfoSectionEditActivity.EXTRA_KIND);
            Intent r1 = new Intent(r3, MemoryInfoSectionEditActivity.class);
            r1.putExtra("session_id", r5);
            r1.putExtra(MemoryInfoSectionEditActivity.EXTRA_KIND, r6);
            if (ZeusTransformUtils.instanceOf(r3, Activity.class) == true) goto L5;
            r1.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
        L5:
            ZeusTransformUtils.startActivity(r3, r1, "com.obric.memorydata.plugin");
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.automemory.settings.MemoryInfoSectionEditActivity$auditRuleInput$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/obric/memorydata/memory/ui/automemory/settings/RuleAuditDecision;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.memory.ui.automemory.settings.MemoryInfoSectionEditActivity$auditRuleInput$2", f = "MemoryInfoSectionEditActivity.kt", i = {0}, l = {632, 640}, m = "invokeSuspend", n = {"relevanceDeferred"}, s = {"L$0"})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<al, Continuation<? super j>, Object> {
        final /* synthetic */ String $candidateText;
        final /* synthetic */ Integer $editIndex;
        final /* synthetic */ List<String> $existingItems;
        final /* synthetic */ String $kind;
        final /* synthetic */ e $memoryInfo;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ MemoryInfoSectionEditActivity this$0;

        AnonymousClass2(List<String> r3, MemoryInfoSectionEditActivity r4, Integer r5, String r6, String r7, e r8, Continuation<? super AnonymousClass2> r9) {
            List<String> r10 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            MemoryInfoSectionEditActivity r11 = (MemoryInfoSectionEditActivity) ZeusTransformUtils.wrapperContextForParams(r4, MemoryInfoSectionEditActivity.class, "com.obric.memorydata.plugin");
            Continuation r12 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r9, Continuation.class, "com.obric.memorydata.plugin");
            this.$existingItems = r10;
            this.this$0 = r11;
            this.$editIndex = r5;
            this.$candidateText = r6;
            this.$kind = r7;
            this.$memoryInfo = r8;
            super(2, r12);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r11, Continuation<?> r12) {
            Continuation r9 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r12, Continuation.class, "com.obric.memorydata.plugin");
            AnonymousClass2 r13 = new AnonymousClass2(this.$existingItems, this.this$0, this.$editIndex, this.$candidateText, this.$kind, this.$memoryInfo, r9);
            r13.L$0 = r11;
            return (Continuation) ZeusTransformUtils.preCheckCast(r13, Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(al r3, Continuation<? super j> r4) {
            return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(al r3, Continuation<? super j> r4) {
            return ((AnonymousClass2) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), AnonymousClass2.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r21) {
            Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r2 = this.label;
            if (r2 == 0) goto L10;
            if (r2 == 1) goto L9;
            if (r2 != 2) goto L8;
            ResultKt.throwOnFailure(r21);
            Object r3 = r21;
        L26:
            if (((com.obric.memorydata.memory.ui.automemory.settings.a) ZeusTransformUtils.preCheckCast(r3, com.obric.memorydata.memory.ui.automemory.settings.a.class, "com.obric.memorydata.plugin")).a() == true) goto L30;
            return new j(false, this.this$0.getString(ZeusTransformUtils.mapRes(R.string.memory_info_section_audit_relevance_irrelevant, TypedValues.Custom.S_STRING, "memory_info_section_audit_relevance_irrelevant")));
        L30:
            return new j(true, null, 2, null);
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            ar r4 = (ar) ZeusTransformUtils.preCheckCast(this.L$0, ar.class, "com.obric.memorydata.plugin");
            ResultKt.throwOnFailure(r21);
            Object r5 = r21;
        L19:
            if (((com.obric.memorydata.memory.ui.automemory.settings.a) ZeusTransformUtils.preCheckCast(r5, com.obric.memorydata.memory.ui.automemory.settings.a.class, "com.obric.memorydata.plugin")).a() == true) goto L22;
            bx.a.a((bx) ZeusTransformUtils.preCheckCast(r4, bx.class, "com.obric.memorydata.plugin"), null, 1, null);
            return new j(false, this.this$0.getString(ZeusTransformUtils.mapRes(R.string.memory_info_section_audit_compliance_invalid, TypedValues.Custom.S_STRING, "memory_info_section_audit_compliance_invalid")));
        L22:
            Continuation r6 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.L$0 = null;
            this.label = 2;
            r3 = r4.a(r6);
            if (r3 != r1) goto L26;
            return r1;
        L10:
            ResultKt.throwOnFailure(r21);
            al r7 = (al) ZeusTransformUtils.preCheckCast(this.L$0, al.class, "com.obric.memorydata.plugin");
            List r15 = CollectionsKt.toMutableList((Collection) ZeusTransformUtils.preCheckCast(this.$existingItems, Collection.class, "com.obric.memorydata.plugin"));
            Integer r9 = this.$editIndex;
            if (r9 != null) goto L13;
        L15:
            ar r10 = kotlinx.coroutines.i.b(r7, null, null, (Function2) ZeusTransformUtils.preCheckCast(new MemoryInfoSectionEditActivity$auditRuleInput$2$complianceDeferred$1(this.this$0, this.$candidateText, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
            r4 = kotlinx.coroutines.i.b(r7, null, null, (Function2) ZeusTransformUtils.preCheckCast(new MemoryInfoSectionEditActivity$auditRuleInput$2$relevanceDeferred$1(this.this$0, this.$kind, this.$memoryInfo, r15, this.$candidateText, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
            Continuation r11 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.L$0 = r4;
            this.label = 1;
            r5 = r10.a(r11);
            if (r5 != r1) goto L19;
            return r1;
        L13:
            if (CollectionsKt.getIndices((Collection) ZeusTransformUtils.preCheckCast(r15, Collection.class, "com.obric.memorydata.plugin")).contains(r9.intValue()) == false) goto L15;
            r15.remove(r9.intValue());
            goto L15
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"com/obric/memorydata/memory/ui/automemory/settings/MemoryInfoSectionEditActivity$bindInfoState$2$1", "Lcom/obric/oui/popover/OnLongClickListenerEx;", "onLongClick", "", "view", "Landroid/view/View;", "rawPos", "", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class b extends com.obric.oui.popover.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ MemoryInfoSectionEditActivity f10722a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ OCardListItem f10723b;
        final /* synthetic */ int c;

        b(MemoryInfoSectionEditActivity r3, OCardListItem r4, int r5) {
            this.f10722a = (MemoryInfoSectionEditActivity) ZeusTransformUtils.wrapperContextForParams(r3, MemoryInfoSectionEditActivity.class, "com.obric.memorydata.plugin");
            this.f10723b = r4;
            this.c = r5;
        }

        @Override // com.obric.oui.popover.f
        public boolean a(View r4, int[] r5) {
            Intrinsics.checkNotNullParameter(r4, "view");
            Intrinsics.checkNotNullParameter(r5, "rawPos");
            MemoryInfoSectionEditActivity.access$showItemMenu(this.f10722a, (View) ZeusTransformUtils.preCheckCast(this.f10723b, View.class, "com.obric.memorydata.plugin"), this.c, r5);
            return true;
        }
    }

    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J*\u0010\u0006\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0016J*\u0010\r\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0016¨\u0006\u000f¸\u0006\u0000"}, d2 = {"androidx/core/widget/TextViewKt$addTextChangedListener$textWatcher$1", "Landroid/text/TextWatcher;", "afterTextChanged", "", "s", "Landroid/text/Editable;", "beforeTextChanged", IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT, "", CommonConsts.APM_INNER_EVENT_COST_START, "", CommonConsts.COUNT_TYPE, "after", "onTextChanged", "before", "core-ktx_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class c implements TextWatcher {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ MemoryInfoSectionEditActivity f10724a;

        public c(MemoryInfoSectionEditActivity r3) {
            this.f10724a = (MemoryInfoSectionEditActivity) ZeusTransformUtils.wrapperContextForParams(r3, MemoryInfoSectionEditActivity.class, "com.obric.memorydata.plugin");
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
            MemoryInfoSectionEditViewModel r0 = MemoryInfoSectionEditActivity.access$getViewModel(this.f10724a);
            if (r5 == null) goto L5;
            String r6 = r5.toString();
        L6:
            if (r6 != null) goto L8;
            r6 = "";
        L8:
            r0.onSceneTextChanged(r6);
            return;
        L5:
            r6 = null;
            goto L6
        }
    }

    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J*\u0010\u0006\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0016J*\u0010\r\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0016¨\u0006\u000f¸\u0006\u0000"}, d2 = {"androidx/core/widget/TextViewKt$addTextChangedListener$textWatcher$1", "Landroid/text/TextWatcher;", "afterTextChanged", "", "s", "Landroid/text/Editable;", "beforeTextChanged", IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT, "", CommonConsts.APM_INNER_EVENT_COST_START, "", CommonConsts.COUNT_TYPE, "after", "onTextChanged", "before", "core-ktx_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class d implements TextWatcher {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Ref.ObjectRef f10725a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f10726b;
        final /* synthetic */ boolean c;
        final /* synthetic */ String d;
        final /* synthetic */ com.obric.oui.dialog.v2.alert.a e;
        final /* synthetic */ MemoryInfoSectionEditActivity f;

        public d(Ref.ObjectRef r3, int r4, boolean r5, String r6, com.obric.oui.dialog.v2.alert.a r7, MemoryInfoSectionEditActivity r8) {
            MemoryInfoSectionEditActivity r9 = (MemoryInfoSectionEditActivity) ZeusTransformUtils.wrapperContextForParams(r8, MemoryInfoSectionEditActivity.class, "com.obric.memorydata.plugin");
            this.f10725a = r3;
            this.f10726b = r4;
            this.c = r5;
            this.d = r6;
            this.e = r7;
            this.f = r9;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable r6) {
            Editable r7 = (Editable) ZeusTransformUtils.wrapperContextForParams(r6, Editable.class, "com.obric.memorydata.plugin");
            if (r7 == null) goto L5;
            String r8 = r7.toString();
        L6:
            if (r8 != null) goto L8;
            r8 = "";
        L8:
            MemoryInfoSectionEditActivity.access$showRuleEditDialog$lambda$26$applyEnabledStyle(this.e, this.f, MemoryInfoSectionEditActivity.access$showRuleEditDialog$lambda$26$computeEnabled(this.c, this.d, r8));
            TextView r0 = (TextView) ZeusTransformUtils.preCheckCast(this.f10725a.element, TextView.class, "com.obric.memorydata.plugin");
            if (r0 == null) goto L12;
            r0.setText((CharSequence) ZeusTransformUtils.preCheckCast(new StringBuilder().append(r8.length()).append('/').append(this.f10726b).toString(), CharSequence.class, "com.obric.memorydata.plugin"));
            return;
        L12:
            return;
        L5:
            r8 = null;
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

    /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.automemory.settings.MemoryInfoSectionEditActivity$onCreateChecked$2, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.memory.ui.automemory.settings.MemoryInfoSectionEditActivity$onCreateChecked$2", f = "MemoryInfoSectionEditActivity.kt", i = {}, l = {IdlErrors.E_RejectInferDeviceOverheat}, m = "invokeSuspend", n = {}, s = {})
    static final class C11332 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ MemoryInfoSectionEditActivity this$0;

        C11332(MemoryInfoSectionEditActivity r3, Continuation<? super C11332> r4) {
            MemoryInfoSectionEditActivity r5 = (MemoryInfoSectionEditActivity) ZeusTransformUtils.wrapperContextForParams(r3, MemoryInfoSectionEditActivity.class, "com.obric.memorydata.plugin");
            Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r5;
            super(2, r6);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            Continuation r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new C11332(this.this$0, r4), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
            return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(al r3, Continuation<? super Unit> r4) {
            return ((C11332) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), C11332.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
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
            kotlinx.coroutines.flow.ar<f> r7 = MemoryInfoSectionEditActivity.access$getViewModel(this.this$0).getState();
            final MemoryInfoSectionEditActivity r3 = this.this$0;
            kotlinx.coroutines.flow.j<? super f> r2 = (kotlinx.coroutines.flow.j) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r3), kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin");
            Continuation<?> r4 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 1;
            if (r7.collect(r2, r4) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.automemory.settings.MemoryInfoSectionEditActivity$runAlgoTask$2, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lorg/json/JSONObject;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.memory.ui.automemory.settings.MemoryInfoSectionEditActivity$runAlgoTask$2", f = "MemoryInfoSectionEditActivity.kt", i = {}, l = {858}, m = "invokeSuspend", n = {}, s = {})
    static final class C11342 extends SuspendLambda implements Function2<al, Continuation<? super JSONObject>, Object> {
        final /* synthetic */ JSONObject $input;
        final /* synthetic */ String $name;
        Object L$0;
        Object L$1;
        int label;

        /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.automemory.settings.MemoryInfoSectionEditActivity$runAlgoTask$2$a */
        @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
        static final class a implements Function1<Throwable, Unit> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ TaskRequest f10728a;

            a(TaskRequest r1) {
                this.f10728a = r1;
            }

            public final void a(Throwable r1) {
                this.f10728a.cancel();
            }

            @Override // kotlin.jvm.functions.Function1
            public /* synthetic */ Unit invoke(Throwable r3) {
                a((Throwable) ZeusTransformUtils.preCheckCast(r3, Throwable.class, "com.obric.memorydata.plugin"));
                return Unit.INSTANCE;
            }
        }

        /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.automemory.settings.MemoryInfoSectionEditActivity$runAlgoTask$2$b */
        @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/obric/memorydata/memory/ui/automemory/settings/MemoryInfoSectionEditActivity$runAlgoTask$2$1$req$1", "Lcom/obric/memorydata/task/scheduler/OnTaskInfoCallBack;", "onChanged", "", "taskInfo", "Lcom/obric/memorydata/task/impl/TaskInfo;", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class b implements com.obric.memorydata.task.scheduler.c {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ AtomicBoolean f10729a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ n<JSONObject> f10730b;
            final /* synthetic */ String c;

            /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.automemory.settings.MemoryInfoSectionEditActivity$runAlgoTask$2$b$a */
            @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
            public /* synthetic */ class a {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public static final /* synthetic */ int[] f10731a = null;

                static {
                    int[] r0 = new int[TaskInfo.State.values().length];
                    r0[TaskInfo.State.SUCCEEDED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
                L13:
                    r0[TaskInfo.State.FAILED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
                L19:
                    r0[TaskInfo.State.TIMEOUT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
                L15:
                    r0[TaskInfo.State.CANCELLED.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
                L7:
                    f10731a = r0;
                }
            }

            b(AtomicBoolean r3, n<? super JSONObject> r4, String r5) {
                n<JSONObject> r6 = (n) ZeusTransformUtils.wrapperContextForParams(r4, n.class, "com.obric.memorydata.plugin");
                this.f10729a = r3;
                this.f10730b = r6;
                this.c = r5;
            }

            @Override // com.obric.memorydata.task.scheduler.c
            public void a(TaskInfo r6) {
                Intrinsics.checkNotNullParameter(r6, "taskInfo");
                int r0 = a.f10731a[r6.c().ordinal()];
                if (r0 == 1) goto L17;
                if (r0 == 2) goto L12;
                if (r0 == 3) goto L12;
                if (r0 == 4) goto L12;
                return;
            L12:
                if (this.f10729a.compareAndSet(false, true) == true) goto L14;
                return;
            L14:
                if (this.f10730b.a() == false) goto L23;
                Continuation r1 = (Continuation) ZeusTransformUtils.preCheckCast(this.f10730b, Continuation.class, "com.obric.memorydata.plugin");
                Result.Companion r2 = Result.Companion;
                r1.resumeWith(Result.m1421constructorimpl(ResultKt.createFailure((Throwable) ZeusTransformUtils.preCheckCast(new RuntimeException("task " + this.c + ' ' + r6.c()), Throwable.class, "com.obric.memorydata.plugin"))));
                return;
            L23:
                return;
            L17:
                if (this.f10729a.compareAndSet(false, true) == true) goto L19;
                return;
            L19:
                if (this.f10730b.a() == false) goto L26;
                Continuation r5 = (Continuation) ZeusTransformUtils.preCheckCast(this.f10730b, Continuation.class, "com.obric.memorydata.plugin");
                Result.Companion r3 = Result.Companion;
                r5.resumeWith(Result.m1421constructorimpl(r6.d()));
                return;
            }
        }

        C11342(String r3, JSONObject r4, Continuation<? super C11342> r5) {
            Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
            this.$name = r3;
            this.$input = r4;
            super(2, r6);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new C11342(this.$name, this.$input, r5), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(al r3, Continuation<? super JSONObject> r4) {
            return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(al r3, Continuation<? super JSONObject> r4) {
            return ((C11342) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), C11342.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r13) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            JSONObject r2 = (JSONObject) ZeusTransformUtils.preCheckCast(this.L$1, JSONObject.class, "com.obric.memorydata.plugin");
            String r12 = (String) ZeusTransformUtils.preCheckCast(this.L$0, String.class, "com.obric.memorydata.plugin");
            ResultKt.throwOnFailure(r13);
        L13:
            return r13;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r13);
            String r14 = this.$name;
            JSONObject r3 = this.$input;
            this.L$0 = r14;
            this.L$1 = r3;
            this.label = 1;
            o r5 = new o(IntrinsicsKt.intercepted((Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin")), 1);
            r5.e();
            n r4 = (n) ZeusTransformUtils.preCheckCast(r5, n.class, "com.obric.memorydata.plugin");
            AtomicBoolean r6 = new AtomicBoolean(false);
            TaskRequest r15 = (TaskRequest) ZeusTransformUtils.preCheckCast(((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(new TaskRequest.Builder(r14).setInputParam(r3), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).setExecuteImmediately(true), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).setTimeout(new com.obric.memorydata.task.impl.g(10, TimeUnit.SECONDS)), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).setConditions(new Condition[]{Condition.NETWORK_AVAILABLE, Condition.SCREEN_ON_OR_CHARGE}), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).setExistingTaskPolicy(ExistingTaskPolicy.KEEP_IN_QUEUE), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).setTaskInfoCallback((com.obric.memorydata.task.scheduler.c) ZeusTransformUtils.preCheckCast(new b(r6, r4, r14), com.obric.memorydata.task.scheduler.c.class, "com.obric.memorydata.plugin")), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).build(), TaskRequest.class, "com.obric.memorydata.plugin");
            r4.a((Function1) ZeusTransformUtils.preCheckCast(new a(r15), Function1.class, "com.obric.memorydata.plugin"));
            r15.enqueue();
            r13 = r5.h();
            if (r13 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L11;
            DebugProbesKt.probeCoroutineSuspended((Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin"));
        L11:
            if (r13 != r0) goto L13;
            return r0;
        }
    }

    static {
        Companion = new a(null);
    }

    public MemoryInfoSectionEditActivity() {
        final ComponentActivity r0 = (ComponentActivity) ZeusTransformUtils.preCheckCast(this, ComponentActivity.class, "com.obric.memorydata.plugin");
        Function0 r2 = (Function0) ZeusTransformUtils.preCheckCast(new MemoryInfoSectionEditActivity$special$$inlined$viewModels$default$1(r0), Function0.class, "com.obric.memorydata.plugin");
        final Function0 r7 = null;
        this.viewModel$delegate = (Lazy) ZeusTransformUtils.preCheckCast(new ViewModelLazy(Reflection.getOrCreateKotlinClass(MemoryInfoSectionEditViewModel.class), (Function0) ZeusTransformUtils.preCheckCast(new MemoryInfoSectionEditActivity$special$$inlined$viewModels$default$2(r0), Function0.class, "com.obric.memorydata.plugin"), r2, (Function0) ZeusTransformUtils.preCheckCast(new MemoryInfoSectionEditActivity$special$$inlined$viewModels$default$3(r7, r0), Function0.class, "com.obric.memorydata.plugin")), Lazy.class, "com.obric.memorydata.plugin");
    }

    public static final /* synthetic */ Object access$auditRuleInput(MemoryInfoSectionEditActivity r9, String r10, e r11, List r12, Integer r13, String r14, Continuation r15) {
        return ((MemoryInfoSectionEditActivity) ZeusTransformUtils.wrapperContextForParams(r9, MemoryInfoSectionEditActivity.class, "com.obric.memorydata.plugin")).auditRuleInput(r10, r11, (List) ZeusTransformUtils.wrapperContextForParams(r12, List.class, "com.obric.memorydata.plugin"), r13, r14, (Continuation) ZeusTransformUtils.wrapperContextForParams(r15, Continuation.class, "com.obric.memorydata.plugin"));
    }

    public static final /* synthetic */ void access$bindState(MemoryInfoSectionEditActivity r2, f r3) {
        ((MemoryInfoSectionEditActivity) ZeusTransformUtils.wrapperContextForParams(r2, MemoryInfoSectionEditActivity.class, "com.obric.memorydata.plugin")).bindState(r3);
    }

    public static final /* synthetic */ void access$dismissWithKeyboardHidden(MemoryInfoSectionEditActivity r2, DialogInterface r3, OInputLayout r4) {
        ((MemoryInfoSectionEditActivity) ZeusTransformUtils.wrapperContextForParams(r2, MemoryInfoSectionEditActivity.class, "com.obric.memorydata.plugin")).dismissWithKeyboardHidden((DialogInterface) ZeusTransformUtils.wrapperContextForParams(r3, DialogInterface.class, "com.obric.memorydata.plugin"), r4);
    }

    public static final /* synthetic */ MemoryInfoSectionEditViewModel access$getViewModel(MemoryInfoSectionEditActivity r2) {
        return ((MemoryInfoSectionEditActivity) ZeusTransformUtils.wrapperContextForParams(r2, MemoryInfoSectionEditActivity.class, "com.obric.memorydata.plugin")).getViewModel();
    }

    public static final /* synthetic */ com.obric.memorydata.memory.ui.automemory.settings.a access$parseAuditTaskResult(MemoryInfoSectionEditActivity r2, JSONObject r3) {
        return ((MemoryInfoSectionEditActivity) ZeusTransformUtils.wrapperContextForParams(r2, MemoryInfoSectionEditActivity.class, "com.obric.memorydata.plugin")).parseAuditTaskResult(r3);
    }

    public static final /* synthetic */ Object access$runAlgoTask(MemoryInfoSectionEditActivity r2, String r3, JSONObject r4, Continuation r5) {
        return ((MemoryInfoSectionEditActivity) ZeusTransformUtils.wrapperContextForParams(r2, MemoryInfoSectionEditActivity.class, "com.obric.memorydata.plugin")).runAlgoTask(r3, r4, (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin"));
    }

    public static final /* synthetic */ int access$sectionTitleResId(MemoryInfoSectionEditActivity r2, String r3) {
        return ((MemoryInfoSectionEditActivity) ZeusTransformUtils.wrapperContextForParams(r2, MemoryInfoSectionEditActivity.class, "com.obric.memorydata.plugin")).sectionTitleResId(r3);
    }

    public static final /* synthetic */ void access$showItemMenu(MemoryInfoSectionEditActivity r2, View r3, int r4, int[] r5) {
        ((MemoryInfoSectionEditActivity) ZeusTransformUtils.wrapperContextForParams(r2, MemoryInfoSectionEditActivity.class, "com.obric.memorydata.plugin")).showItemMenu(r3, r4, r5);
    }

    public static final /* synthetic */ void access$showRuleEditDialog$lambda$26$applyEnabledStyle(com.obric.oui.dialog.v2.alert.a r2, MemoryInfoSectionEditActivity r3, boolean r4) {
        showRuleEditDialog$lambda$26$applyEnabledStyle(r2, (MemoryInfoSectionEditActivity) ZeusTransformUtils.wrapperContextForParams(r3, MemoryInfoSectionEditActivity.class, "com.obric.memorydata.plugin"), r4);
    }

    public static final /* synthetic */ boolean access$showRuleEditDialog$lambda$26$computeEnabled(boolean r0, String r1, String r2) {
        return showRuleEditDialog$lambda$26$computeEnabled(r0, r1, r2);
    }

    private final Object auditRuleInput(String r12, e r13, List<String> r14, Integer r15, String r16, Continuation<? super j> r17) {
        List r3 = (List) ZeusTransformUtils.wrapperContextForParams(r14, List.class, "com.obric.memorydata.plugin");
        Continuation r0 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r17, Continuation.class, "com.obric.memorydata.plugin");
        return am.a((Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass2(r3, this, r15, r16, r12, r13, null), Function2.class, "com.obric.memorydata.plugin"), r0);
    }

    private final void bindInfoState(f r14) {
        AutoMemoryProActivityMemoryInfoSectionEditBinding r0 = this.binding;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r0 = null;
    L5:
        r0.viewTitle.setCenterTitle(getString(ZeusTransformUtils.mapRes(R.string.memory_task_settings_payment_info, TypedValues.Custom.S_STRING, "memory_task_settings_payment_info")));
        AutoMemoryProActivityMemoryInfoSectionEditBinding r1 = this.binding;
        if (r1 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r1 = null;
    L8:
        LinearLayout r2 = r1.itemContainer;
        Intrinsics.checkNotNullExpressionValue(r2, "itemContainer");
        List<String> r15 = r14.c().b();
        boolean r3 = !((Collection) ZeusTransformUtils.preCheckCast(r15, Collection.class, "com.obric.memorydata.plugin")).isEmpty();
        AutoMemoryProActivityMemoryInfoSectionEditBinding r7 = this.binding;
        if (r7 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r7 = null;
    L11:
        NestedScrollView r8 = r7.scrollContainer;
        int r9 = 8;
        if (r3 == false) goto L14;
        int r10 = 0;
    L15:
        r8.setVisibility(r10);
        AutoMemoryProActivityMemoryInfoSectionEditBinding r11 = this.binding;
        if (r11 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r11 = null;
    L18:
        TextView r12 = r11.emptyText;
        if (r3 == true) goto L22;
        r9 = 0;
    L22:
        r12.setVisibility(r9);
        AutoMemoryProActivityMemoryInfoSectionEditBinding r13 = this.binding;
        if (r13 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r13 = null;
    L25:
        r13.emptyText.setText((CharSequence) ZeusTransformUtils.preCheckCast(getString(ZeusTransformUtils.mapRes(R.string.memory_info_section_empty_info, TypedValues.Custom.S_STRING, "memory_info_section_empty_info")), CharSequence.class, "com.obric.memorydata.plugin"));
        if (r3 == true) goto L30;
        r2.removeAllViews();
        return;
    L30:
        if (r2.getChildCount() == r15.size()) goto L35;
        r2.removeAllViews();
        LayoutInflater r4 = LayoutInflater.from((Context) ZeusTransformUtils.preCheckCast(this, Context.class, "com.obric.memorydata.plugin"));
        Iterator r5 = ((Iterable) ZeusTransformUtils.preCheckCast(r15, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L33:
        if (r5.hasNext() == false) goto L35;
        String r16 = (String) ZeusTransformUtils.preCheckCast(r5.next(), String.class, "com.obric.memorydata.plugin");
        View r17 = ZeusTransformUtils.inflate(r4, ZeusTransformUtils.mapRes(R.layout.auto_memory_pro_item_memory_info_section_row, "layout", "auto_memory_pro_item_memory_info_section_row"), (ViewGroup) ZeusTransformUtils.preCheckCast(r2, ViewGroup.class, "com.obric.memorydata.plugin"), false, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNull(r17, "null cannot be cast to non-null type com.obric.oui.lisitem.OCardListItem");
        r2.addView((View) ZeusTransformUtils.preCheckCast((OCardListItem) ZeusTransformUtils.preCheckCast(r17, OCardListItem.class, "com.obric.memorydata.plugin"), View.class, "com.obric.memorydata.plugin"));
    L35:
        Iterator r6 = ((Iterable) ZeusTransformUtils.preCheckCast(r15, Iterable.class, "com.obric.memorydata.plugin")).iterator();
        int r18 = 0;
    L37:
        if (r6.hasNext() == false) goto L55;
        Object r19 = r6.next();
        int r20 = r18 + 1;
        if (r18 >= 0) goto L41;
        CollectionsKt.throwIndexOverflow();
    L41:
        String r21 = (String) ZeusTransformUtils.preCheckCast(r19, String.class, "com.obric.memorydata.plugin");
        View r110 = r2.getChildAt(r18);
        Intrinsics.checkNotNull(r110, "null cannot be cast to non-null type com.obric.oui.lisitem.OCardListItem");
        OCardListItem r111 = (OCardListItem) ZeusTransformUtils.preCheckCast(r110, OCardListItem.class, "com.obric.memorydata.plugin");
        if (r15.size() != 1) goto L44;
        int r112 = 0;
    L50:
        OCardListItem.a(r111, r112, false, 2, null);
        if (r18 == (r15.size() - 1)) goto L53;
        boolean r113 = true;
    L54:
        r111.g(r113);
        r111.setTitle((CharSequence) ZeusTransformUtils.preCheckCast(r21, CharSequence.class, "com.obric.memorydata.plugin"));
        com.obric.oui.popover.a.f14317a.a((View) ZeusTransformUtils.preCheckCast(r111.getContentContainer(), View.class, "com.obric.memorydata.plugin"), (com.obric.oui.popover.f) ZeusTransformUtils.preCheckCast(new b(this, r111, r18), com.obric.oui.popover.f.class, "com.obric.memorydata.plugin"));
        r18 = r20;
        goto L37
    L53:
        r113 = false;
        goto L54
    L44:
        if (r18 != 0) goto L47;
        r112 = 1;
        goto L50
    L47:
        if (r18 != (r15.size() - 1)) goto L49;
        r112 = 3;
        goto L50
    L49:
        r112 = 2;
        goto L50
    L55:
        return;
    L14:
        r10 = 8;
        goto L15
    }

    private final void bindSceneState(f r7) {
        AutoMemoryProActivityMemoryInfoSectionEditBinding r0 = this.binding;
        AutoMemoryProActivityMemoryInfoSectionEditBinding r2 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r0 = null;
    L5:
        r0.viewTitle.setCenterTitle(getString(sectionTitleResId(r7.a())));
        AutoMemoryProActivityMemoryInfoSectionEditBinding r1 = this.binding;
        if (r1 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r1 = null;
    L8:
        Editable r3 = r1.descInput.getVInput().getText();
        if (r3 == null) goto L11;
        String r4 = r3.toString();
    L12:
        if (r4 != null) goto L15;
        r4 = "";
    L15:
        if (Intrinsics.areEqual(r4, r7.d()) == true) goto L25;
        AutoMemoryProActivityMemoryInfoSectionEditBinding r5 = this.binding;
        if (r5 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r5 = null;
    L19:
        r5.descInput.setText((CharSequence) ZeusTransformUtils.preCheckCast(r7.d(), CharSequence.class, "com.obric.memorydata.plugin"));
        AutoMemoryProActivityMemoryInfoSectionEditBinding r6 = this.binding;
        if (r6 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L23:
        r2.descInput.getVInput().setSelection(r7.d().length());
        return;
    L22:
        r2 = r6;
        goto L23
    L25:
        return;
    L11:
        r4 = null;
        goto L12
    }

    private final void bindState(f r3) {
        if (Intrinsics.areEqual(r3.a(), KIND_SCENE) == false) goto L5;
    L8:
        bindSceneState(r3);
        return;
    L5:
        if (Intrinsics.areEqual(r3.a(), KIND_UPDATE_RULE) == true) goto L8;
        bindInfoState(r3);
    }

    private final void dismissWithKeyboardHidden(DialogInterface r5, OInputLayout r6) {
        final DialogInterface r7 = (DialogInterface) ZeusTransformUtils.wrapperContextForParams(r5, DialogInterface.class, "com.obric.memorydata.plugin");
        if (r6 != null) goto L6;
        r7.dismiss();
        return;
    L6:
        OEditText r0 = r6.getVInput();
        IBinder r2 = r0.getWindowToken();
        if (r2 != null) goto L9;
        r2 = r6.getWindowToken();
    L9:
        r0.clearFocus();
        Object r8 = getSystemService("input_method");
        if (ZeusTransformUtils.instanceOf(r8, InputMethodManager.class) == false) goto L12;
        InputMethodManager r9 = (InputMethodManager) ZeusTransformUtils.preCheckCast(r8, InputMethodManager.class, "com.obric.memorydata.plugin");
    L13:
        if (r9 == null) goto L15;
        r9.hideSoftInputFromWindow(r2, 0);
    L15:
        r0.postDelayed(new $$Lambda$MemoryInfoSectionEditActivity$P4ijkk9JtGJVF9r3AQwBeITlnqs(this, r7), DIALOG_DISMISS_AFTER_IME_DELAY_MS);
        return;
    L12:
        r9 = null;
        goto L13
    }

    private static final void dismissWithKeyboardHidden$lambda$12(MemoryInfoSectionEditActivity r2, DialogInterface r3) {
        MemoryInfoSectionEditActivity r4 = (MemoryInfoSectionEditActivity) ZeusTransformUtils.wrapperContextForParams(r2, MemoryInfoSectionEditActivity.class, "com.obric.memorydata.plugin");
        DialogInterface r5 = (DialogInterface) ZeusTransformUtils.wrapperContextForParams(r3, DialogInterface.class, "com.obric.memorydata.plugin");
        if (r4.isFinishing() == false) goto L5;
        return;
    L5:
        if (r4.isDestroyed() == true) goto L9;
        r5.dismiss();
        return;
    }

    private final MemoryInfoSectionEditViewModel getViewModel() {
        return (MemoryInfoSectionEditViewModel) ZeusTransformUtils.preCheckCast(this.viewModel$delegate.getValue(), MemoryInfoSectionEditViewModel.class, "com.obric.memorydata.plugin");
    }

    public static /* synthetic */ Unit lambda$12i51EpsOHNBN9CtlFrXJCzf0jY(Ref.ObjectRef r0, MemoryInfoSectionEditActivity r1, int r2, View r3, int r4) {
        return showItemMenu$lambda$30(r0, r1, r2, r3, r4);
    }

    public static /* synthetic */ Unit lambda$12q29Ch1L0s1Xj0vehZ7DJup5is(DialogInterface r0, int r1) {
        return showDeleteConfirmDialog$lambda$27(r0, r1);
    }

    public static /* synthetic */ WindowInsetsCompat lambda$2WhY8gOmmyJd47JA8fxksgbUjAU(MemoryInfoSectionEditActivity r0, View r1, WindowInsetsCompat r2) {
        return setupInfoMode$lambda$9(r0, r1, r2);
    }

    /* JADX INFO: renamed from: lambda$EbHv4A-z5gungQY-q0wVnBoii2M, reason: not valid java name */
    public static /* synthetic */ boolean m820lambda$EbHv4Az5gungQYq0wVnBoii2M(OEditText r0, View r1, MotionEvent r2) {
        return setupSceneMode$lambda$6$lambda$4(r0, r1, r2);
    }

    public static /* synthetic */ Unit lambda$IDto9GBveNFbU4S5l0E37QbEAaw(MemoryInfoSectionEditActivity r0, View r1) {
        return setupInfoMode$lambda$8(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$OLaHQuDCjYL0MRrT6KRsritik-I, reason: not valid java name */
    public static /* synthetic */ void m821lambda$OLaHQuDCjYL0MRrT6KRsritikI(MemoryInfoSectionEditActivity r0, OInputLayout r1) {
        showRuleEditDialog$lambda$21$lambda$20(r0, r1);
    }

    public static /* synthetic */ void lambda$P4ijkk9JtGJVF9r3AQwBeITlnqs(MemoryInfoSectionEditActivity r0, DialogInterface r1) {
        dismissWithKeyboardHidden$lambda$12(r0, r1);
    }

    public static /* synthetic */ Unit lambda$ReNJriHWILiN4uELvdX70kfMCkI(MemoryInfoSectionEditActivity r0, Ref.ObjectRef r1, Ref.ObjectRef r2, Ref.ObjectRef r3, int r4, String r5, boolean r6, f r7, com.obric.oui.dialog.v2.alert.style.d r8) {
        return showRuleEditDialog$lambda$21(r0, r1, r2, r3, r4, r5, r6, r7, r8);
    }

    /* JADX INFO: renamed from: lambda$Sz_dydBrw5lk-YMXcWfiT10Me0Q, reason: not valid java name */
    public static /* synthetic */ void m822lambda$Sz_dydBrw5lkYMXcWfiT10Me0Q(OUICardConstraintLayout r0, Drawable r1) {
        showItemMenu$lambda$33$lambda$32(r0, r1);
    }

    public static /* synthetic */ Unit lambda$UDU_roYHUjXHLU1N_J8TwU0OLbo(MemoryInfoSectionEditActivity r0, int r1, DialogInterface r2, int r3) {
        return showDeleteConfirmDialog$lambda$28(r0, r1, r2, r3);
    }

    /* JADX INFO: renamed from: lambda$UT66QwgSsC_FO-r-PQXMZQQOtbk, reason: not valid java name */
    public static /* synthetic */ Unit m823lambda$UT66QwgSsC_FOrPQXMZQQOtbk(MemoryInfoSectionEditActivity r0, int r1) {
        return setupInfoMode$lambda$7(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$Yr_V-gFfnXJnhiZZEyp8vVrp6TQ, reason: not valid java name */
    public static /* synthetic */ void m824lambda$Yr_VgFfnXJnhiZZEyp8vVrp6TQ(Ref.BooleanRef r0, Ref.ObjectRef r1, Ref.ObjectRef r2, boolean r3, String r4, MemoryInfoSectionEditActivity r5, List r6, Integer r7, f r8, DialogInterface r9, int r10) {
        showRuleEditDialog$lambda$24(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10);
    }

    public static /* synthetic */ void lambda$lE13KpJOFfWJdKHtWSq03NCi4a8(MemoryInfoSectionEditActivity r0, Ref.ObjectRef r1, DialogInterface r2, int r3) {
        showRuleEditDialog$lambda$22(r0, r1, r2, r3);
    }

    public static /* synthetic */ void lambda$sGqVwuMAE2EN1VPprcBMlOvnvj0(MemoryInfoSectionEditActivity r0, View r1) {
        onCreateChecked$lambda$1$lambda$0(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$tWFrzLi1uJ6Dt5LuH-vJxHqc7XY, reason: not valid java name */
    public static /* synthetic */ Unit m825lambda$tWFrzLi1uJ6Dt5LuHvJxHqc7XY(Ref.ObjectRef r0, MemoryInfoSectionEditActivity r1, int r2, View r3, int r4) {
        return showItemMenu$lambda$31(r0, r1, r2, r3, r4);
    }

    public static /* synthetic */ WindowInsetsCompat lambda$wsun2SjmN8G3rOjjnd6uwUWYbO0(MemoryInfoSectionEditActivity r0, View r1, WindowInsetsCompat r2) {
        return setupSceneMode$lambda$2(r0, r1, r2);
    }

    private static final void onCreateChecked$lambda$1$lambda$0(MemoryInfoSectionEditActivity r1, View r2) {
        ((MemoryInfoSectionEditActivity) ZeusTransformUtils.wrapperContextForParams(r1, MemoryInfoSectionEditActivity.class, "com.obric.memorydata.plugin")).finish();
    }

    private final com.obric.memorydata.memory.ui.automemory.settings.a parseAuditTaskResult(JSONObject r3) {
        boolean r0 = true;
        if (r3.optInt("code", 1) == 0) goto L5;
    L7:
        r0 = false;
    L9:
        return new com.obric.memorydata.memory.ui.automemory.settings.a(r0);
    L5:
        if (r3.optBoolean("result", false) == false) goto L7;
        goto L7
    }

    private final Object runAlgoTask(String r3, JSONObject r4, Continuation<? super JSONObject> r5) {
        Continuation r2 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
        return da.a(12000, (Function2) ZeusTransformUtils.preCheckCast(new C11342(r3, r4, null), Function2.class, "com.obric.memorydata.plugin"), r2);
    }

    private final int sectionTitleResId(String r2) {
        if (Intrinsics.areEqual(r2, "info") == false) goto L7;
        int r1 = R.string.memory_task_settings_payment_info;
        String r3 = "memory_task_settings_payment_info";
    L10:
        return ZeusTransformUtils.mapRes(r1, TypedValues.Custom.S_STRING, r3);
    L7:
        if (Intrinsics.areEqual(r2, KIND_UPDATE_RULE) == false) goto L9;
        r1 = R.string.memory_task_settings_update_rule;
        r3 = "memory_task_settings_update_rule";
        goto L10
    L9:
        r1 = R.string.memory_task_settings_payment_behavior;
        r3 = "memory_task_settings_payment_behavior";
        goto L10
    }

    private final void setupInfoMode() {
        AutoMemoryProActivityMemoryInfoSectionEditBinding r1 = this.binding;
        AutoMemoryProActivityMemoryInfoSectionEditBinding r2 = null;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r1 = null;
    L5:
        r1.sceneContainer.setVisibility(8);
        AutoMemoryProActivityMemoryInfoSectionEditBinding r3 = this.binding;
        if (r3 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r3 = null;
    L8:
        getTitleBarTotalHeightAsync((View) ZeusTransformUtils.preCheckCast(r3.viewTitle, View.class, "com.obric.memorydata.plugin"), new $$Lambda$MemoryInfoSectionEditActivity$UT66QwgSsC_FOrPQXMZQQOtbk(this));
        AutoMemoryProActivityMemoryInfoSectionEditBinding r4 = this.binding;
        if (r4 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r4 = null;
    L11:
        bb.a(OFloatingTitleBar.b(r4.viewTitle, ZeusTransformUtils.mapRes(R.drawable.ic_memory_section_add, "drawable", "ic_memory_section_add"), 0, null, 6, null), 0, new $$Lambda$MemoryInfoSectionEditActivity$IDto9GBveNFbU4S5l0E37QbEAaw(this), 1, null);
        AutoMemoryProActivityMemoryInfoSectionEditBinding r5 = this.binding;
        if (r5 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r5 = null;
    L14:
        ViewCompat.setOnApplyWindowInsetsListener((View) ZeusTransformUtils.preCheckCast(r5.getRoot(), View.class, "com.obric.memorydata.plugin"), new $$Lambda$MemoryInfoSectionEditActivity$2WhY8gOmmyJd47JA8fxksgbUjAU(this));
        AutoMemoryProActivityMemoryInfoSectionEditBinding r0 = this.binding;
        if (r0 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L18:
        ViewCompat.requestApplyInsets((View) ZeusTransformUtils.preCheckCast(r2.getRoot(), View.class, "com.obric.memorydata.plugin"));
        return;
    L17:
        r2 = r0;
        goto L18
    }

    private static final Unit setupInfoMode$lambda$7(MemoryInfoSectionEditActivity r2, int r3) {
        AutoMemoryProActivityMemoryInfoSectionEditBinding r4 = ((MemoryInfoSectionEditActivity) ZeusTransformUtils.wrapperContextForParams(r2, MemoryInfoSectionEditActivity.class, "com.obric.memorydata.plugin")).binding;
        if (r4 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r4 = null;
    L5:
        NestedScrollView r5 = r4.scrollContainer;
        Intrinsics.checkNotNullExpressionValue(r5, "scrollContainer");
        bb.a((View) ZeusTransformUtils.preCheckCast(r5, View.class, "com.obric.memorydata.plugin"), r3);
        return Unit.INSTANCE;
    }

    private static final Unit setupInfoMode$lambda$8(MemoryInfoSectionEditActivity r2, View r3) {
        MemoryInfoSectionEditActivity r4 = (MemoryInfoSectionEditActivity) ZeusTransformUtils.wrapperContextForParams(r2, MemoryInfoSectionEditActivity.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "it");
        r4.showRuleEditDialog(null);
        return Unit.INSTANCE;
    }

    private static final WindowInsetsCompat setupInfoMode$lambda$9(MemoryInfoSectionEditActivity r3, View r4, WindowInsetsCompat r5) {
        MemoryInfoSectionEditActivity r6 = (MemoryInfoSectionEditActivity) ZeusTransformUtils.wrapperContextForParams(r3, MemoryInfoSectionEditActivity.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "<unused var>");
        Intrinsics.checkNotNullParameter(r5, "insets");
        Insets r7 = r5.getInsets(WindowInsetsCompat.Type.systemBars());
        Intrinsics.checkNotNullExpressionValue(r7, "getInsets(...)");
        AutoMemoryProActivityMemoryInfoSectionEditBinding r8 = r6.binding;
        if (r8 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r8 = null;
    L5:
        NestedScrollView r9 = r8.scrollContainer;
        Intrinsics.checkNotNullExpressionValue(r9, "scrollContainer");
        bb.c((View) ZeusTransformUtils.preCheckCast(r9, View.class, "com.obric.memorydata.plugin"), r7.bottom + MathKt.roundToInt(TypedValue.applyDimension(1, 16, Resources.getSystem().getDisplayMetrics())));
        return r5;
    }

    private final void setupSceneMode(String r8) {
        AutoMemoryProActivityMemoryInfoSectionEditBinding r0 = this.binding;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r0 = null;
    L5:
        r0.sceneContainer.setVisibility(0);
        AutoMemoryProActivityMemoryInfoSectionEditBinding r1 = this.binding;
        if (r1 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r1 = null;
    L8:
        r1.scrollContainer.setVisibility(8);
        AutoMemoryProActivityMemoryInfoSectionEditBinding r2 = this.binding;
        if (r2 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r2 = null;
    L11:
        r2.emptyText.setVisibility(8);
        AutoMemoryProActivityMemoryInfoSectionEditBinding r3 = this.binding;
        if (r3 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r3 = null;
    L14:
        ViewCompat.setOnApplyWindowInsetsListener((View) ZeusTransformUtils.preCheckCast(r3.getRoot(), View.class, "com.obric.memorydata.plugin"), new $$Lambda$MemoryInfoSectionEditActivity$wsun2SjmN8G3rOjjnd6uwUWYbO0(this));
        AutoMemoryProActivityMemoryInfoSectionEditBinding r4 = this.binding;
        if (r4 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r4 = null;
    L17:
        ViewCompat.requestApplyInsets((View) ZeusTransformUtils.preCheckCast(r4.getRoot(), View.class, "com.obric.memorydata.plugin"));
        AutoMemoryProActivityMemoryInfoSectionEditBinding r5 = this.binding;
        if (r5 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r5 = null;
    L20:
        OInputLayout r6 = r5.descInput;
        r6.setType(1);
        r6.a(false);
        r6.c(false);
        r6.e(false);
        r6.g(true);
        r6.setLimitCount(2000);
        r6.setAutoChangeWithLimit(true);
        if (Intrinsics.areEqual(r8, KIND_UPDATE_RULE) == false) goto L23;
        int r9 = R.string.memory_info_section_dialog_add_hint_update_rule;
        String r7 = "memory_info_section_dialog_add_hint_update_rule";
    L24:
        r6.setHint((CharSequence) ZeusTransformUtils.preCheckCast(getString(ZeusTransformUtils.mapRes(r9, TypedValues.Custom.S_STRING, r7)), CharSequence.class, "com.obric.memorydata.plugin"));
        AutoMemoryProActivityMemoryInfoSectionEditBinding r10 = this.binding;
        if (r10 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r10 = null;
    L27:
        final OEditText r11 = r10.descInput.getVInput();
        r11.setGravity(MaterialCardView.CHECKED_ICON_GRAVITY_TOP_START);
        r11.setBackground(null);
        r11.setHorizontallyScrolling(false);
        r11.setTextAlignment(5);
        r11.setOnTouchListener(new $$Lambda$MemoryInfoSectionEditActivity$EbHv4Az5gungQYq0wVnBoii2M(r11));
        TextView r12 = (TextView) ZeusTransformUtils.preCheckCast(r11, TextView.class, "com.obric.memorydata.plugin");
        c r13 = new c(this);
        r12.addTextChangedListener((TextWatcher) ZeusTransformUtils.preCheckCast(r13, TextWatcher.class, "com.obric.memorydata.plugin"));
        TextWatcher r14 = (TextWatcher) ZeusTransformUtils.preCheckCast(r13, TextWatcher.class, "com.obric.memorydata.plugin");
        return;
    L23:
        r9 = R.string.memory_info_section_dialog_add_hint;
        r7 = "memory_info_section_dialog_add_hint";
        goto L24
    }

    private static final WindowInsetsCompat setupSceneMode$lambda$2(MemoryInfoSectionEditActivity r3, View r4, WindowInsetsCompat r5) {
        MemoryInfoSectionEditActivity r6 = (MemoryInfoSectionEditActivity) ZeusTransformUtils.wrapperContextForParams(r3, MemoryInfoSectionEditActivity.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "<unused var>");
        Intrinsics.checkNotNullParameter(r5, "insets");
        Insets r7 = r5.getInsets(WindowInsetsCompat.Type.systemBars());
        Intrinsics.checkNotNullExpressionValue(r7, "getInsets(...)");
        int r0 = r5.getInsets(WindowInsetsCompat.Type.ime()).bottom;
        AutoMemoryProActivityMemoryInfoSectionEditBinding r8 = r6.binding;
        if (r8 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r8 = null;
    L5:
        LinearLayout r9 = r8.sceneContainer;
        Intrinsics.checkNotNullExpressionValue(r9, "sceneContainer");
        bb.c((View) ZeusTransformUtils.preCheckCast(r9, View.class, "com.obric.memorydata.plugin"), Math.max(r7.bottom, r0) + MathKt.roundToInt(TypedValue.applyDimension(1, 16, Resources.getSystem().getDisplayMetrics())));
        return r5;
    }

    private static final boolean setupSceneMode$lambda$6$lambda$4(OEditText r3, View r4, MotionEvent r5) {
        if (r4.canScrollVertically(-1) == false) goto L5;
    L8:
        boolean r6 = true;
    L9:
        int r7 = r5.getActionMasked();
        if (r7 == 0) goto L20;
        if (r7 != 1) goto L13;
    L17:
        ViewParent r8 = r3.getParent();
        if (r8 == null) goto L23;
        r8.requestDisallowInterceptTouchEvent(false);
    L23:
        return false;
    L13:
        if (r7 == 2) goto L20;
        if (r7 == 3) goto L17;
    L20:
        ViewParent r9 = r3.getParent();
        if (r9 == null) goto L23;
        r9.requestDisallowInterceptTouchEvent(r6);
        goto L23
    L5:
        if (r4.canScrollVertically(1) == true) goto L8;
        r6 = false;
        goto L9
    }

    private final void showDeleteConfirmDialog(final int r8) {
        TextView r6 = null;
        com.obric.oui.dialog.v2.alert.b r0 = com.obric.oui.dialog.v2.alert.b.a(new com.obric.oui.dialog.v2.alert.b((Context) ZeusTransformUtils.preCheckCast(this, Context.class, "com.obric.memorydata.plugin")), (CharSequence) ZeusTransformUtils.preCheckCast(getString(ZeusTransformUtils.mapRes(R.string.memory_info_section_dialog_delete_title, TypedValues.Custom.S_STRING, "memory_info_section_dialog_delete_title")), CharSequence.class, "com.obric.memorydata.plugin"), false, 2, null).a(true);
        String r1 = getString(ZeusTransformUtils.mapRes(R.string.memory_info_section_dialog_cancel, TypedValues.Custom.S_STRING, "memory_info_section_dialog_cancel"));
        Intrinsics.checkNotNullExpressionValue(r1, "getString(...)");
        com.obric.oui.dialog.v2.alert.b r2 = r0.b((CharSequence) ZeusTransformUtils.preCheckCast(r1, CharSequence.class, "com.obric.memorydata.plugin"), $$Lambda$MemoryInfoSectionEditActivity$12q29Ch1L0s1Xj0vehZ7DJup5is.INSTANCE);
        String r3 = getString(ZeusTransformUtils.mapRes(R.string.memory_info_section_menu_delete, TypedValues.Custom.S_STRING, "memory_info_section_menu_delete"));
        Intrinsics.checkNotNullExpressionValue(r3, "getString(...)");
        com.obric.oui.dialog.v2.alert.a r7 = (com.obric.oui.dialog.v2.alert.a) ZeusTransformUtils.preCheckCast(r2.a((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.memorydata.plugin"), new $$Lambda$MemoryInfoSectionEditActivity$UDU_roYHUjXHLU1N_J8TwU0OLbo(this, r8)).g(), com.obric.oui.dialog.v2.alert.a.class, "com.obric.memorydata.plugin");
        View r9 = r7.g();
        if (ZeusTransformUtils.instanceOf(r9, TextView.class) == false) goto L5;
        r6 = (TextView) ZeusTransformUtils.preCheckCast(r9, TextView.class, "com.obric.memorydata.plugin");
    L5:
        if (r6 == null) goto L7;
        r6.setTextColor(-45745);
    L7:
        r7.show();
    }

    private static final Unit showDeleteConfirmDialog$lambda$27(DialogInterface r1, int r2) {
        DialogInterface r3 = (DialogInterface) ZeusTransformUtils.wrapperContextForParams(r1, DialogInterface.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "dialog");
        r3.dismiss();
        return Unit.INSTANCE;
    }

    private static final Unit showDeleteConfirmDialog$lambda$28(MemoryInfoSectionEditActivity r1, int r2, DialogInterface r3, int r4) {
        MemoryInfoSectionEditActivity r5 = (MemoryInfoSectionEditActivity) ZeusTransformUtils.wrapperContextForParams(r1, MemoryInfoSectionEditActivity.class, "com.obric.memorydata.plugin");
        DialogInterface r6 = (DialogInterface) ZeusTransformUtils.wrapperContextForParams(r3, DialogInterface.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "dialog");
        r6.dismiss();
        r5.getViewModel().deleteItem(r2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Type inference failed for: r4v16, types: [T, com.obric.oui.popover.v2.a] */
    private final void showItemMenu(View r29, final int r30, int[] r31) {
        List<String> r4 = ((f) ZeusTransformUtils.preCheckCast(getViewModel().getState().c(), f.class, "com.obric.memorydata.plugin")).c().b();
        if (r30 >= 0) goto L5;
    L7:
        boolean r5 = false;
    L8:
        if (r5 == true) goto L10;
        return;
    L10:
        OPopoverEntranceMenuView.Builder r6 = new OPopoverEntranceMenuView.Builder((Context) ZeusTransformUtils.preCheckCast(this, Context.class, "com.obric.memorydata.plugin"));
        final Ref.ObjectRef r15 = new Ref.ObjectRef();
        int r8 = ZeusTransformUtils.mapRes(R.drawable.ic_memory_edit, "drawable", "ic_memory_edit");
        String r9 = getString(ZeusTransformUtils.mapRes(R.string.memory_info_section_menu_edit, TypedValues.Custom.S_STRING, "memory_info_section_menu_edit"));
        OPopoverEntranceMenuView.Builder.a(r6, Integer.valueOf(r8), null, Integer.valueOf(getColor(ZeusTransformUtils.mapRes(R.color.oui_basic_text_1, TypedValues.Custom.S_COLOR, "oui_basic_text_1"))), (CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, "com.obric.memorydata.plugin"), null, null, false, null, new $$Lambda$MemoryInfoSectionEditActivity$12i51EpsOHNBN9CtlFrXJCzf0jY(r15, this, r30), 242, null);
        OPopoverEntranceMenuView.Builder.a(r6, Integer.valueOf(ZeusTransformUtils.mapRes(R.drawable.ic_memory_list_menu_delete, "drawable", "ic_memory_list_menu_delete")), null, null, (CharSequence) ZeusTransformUtils.preCheckCast(getString(ZeusTransformUtils.mapRes(R.string.memory_info_section_menu_delete, TypedValues.Custom.S_STRING, "memory_info_section_menu_delete")), CharSequence.class, "com.obric.memorydata.plugin"), null, null, true, null, new $$Lambda$MemoryInfoSectionEditActivity$tWFrzLi1uJ6Dt5LuHvJxHqc7XY(r15, this, r30), 182, null);
        OPopoverEntranceMenuView r7 = r6.c();
        final Drawable r10 = null;
        if (ZeusTransformUtils.instanceOf(r29, OCardListItem.class) == false) goto L13;
        OCardListItem r11 = (OCardListItem) ZeusTransformUtils.preCheckCast(r29, OCardListItem.class, "com.obric.memorydata.plugin");
    L14:
        if (r11 == null) goto L16;
        final OUICardConstraintLayout r12 = r11.getContentContainer();
    L17:
        if (r12 == null) goto L19;
        r10 = r12.getBackground();
    L19:
        if (r12 == null) goto L21;
        r12.setBackgroundColor(getColor(ZeusTransformUtils.mapRes(R.color.oui_basic_fill_element_2, TypedValues.Custom.S_COLOR, "oui_basic_fill_element_2")));
    L21:
        ?? r13 = ((com.obric.oui.popover.v2.a.C0765a) ZeusTransformUtils.preCheckCast(new com.obric.oui.popover.v2.a.C0765a((Context) ZeusTransformUtils.preCheckCast(this, Context.class, "com.obric.memorydata.plugin")).a((View) ZeusTransformUtils.preCheckCast(r7, View.class, "com.obric.memorydata.plugin")), com.obric.oui.popover.v2.a.C0765a.class, "com.obric.memorydata.plugin")).F();
        r13.setOnDismissListener(new $$Lambda$MemoryInfoSectionEditActivity$Sz_dydBrw5lkYMXcWfiT10Me0Q(r12, r10));
        if (r31 != null) goto L24;
    L26:
        int[] r3 = new int[2];
        r29.getLocationOnScreen(r3);
        int r14 = r3[0] + r29.getWidth();
        int r16 = (r3[1] + r29.getHeight()) - MathKt.roundToInt(TypedValue.applyDimension(1, 48, Resources.getSystem().getDisplayMetrics()));
        com.obric.oui.popover.v2.e r17 = com.obric.oui.popover.v2.e.f14366a;
        Activity r18 = (Activity) ZeusTransformUtils.preCheckCast(this, Activity.class, "com.obric.memorydata.plugin");
    L27:
        com.obric.oui.popover.v2.e.a(r17, r18, r13, r14, r16, false, 0, 48, null);
        r15.element = r13;
        return;
    L24:
        if (r31.length < 2) goto L26;
        r17 = com.obric.oui.popover.v2.e.f14366a;
        r18 = (Activity) ZeusTransformUtils.preCheckCast(this, Activity.class, "com.obric.memorydata.plugin");
        r14 = r31[0];
        r16 = r31[1];
        goto L27
    L16:
        r12 = null;
        goto L17
    L13:
        r11 = null;
        goto L14
    L5:
        if (r30 >= ((Collection) ZeusTransformUtils.preCheckCast(r4, Collection.class, "com.obric.memorydata.plugin")).size()) goto L7;
        r5 = true;
        goto L8
    }

    private static final Unit showItemMenu$lambda$30(Ref.ObjectRef r1, MemoryInfoSectionEditActivity r2, int r3, View r4, int r5) {
        MemoryInfoSectionEditActivity r6 = (MemoryInfoSectionEditActivity) ZeusTransformUtils.wrapperContextForParams(r2, MemoryInfoSectionEditActivity.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "<unused var>");
        com.obric.oui.popover.v2.a r7 = (com.obric.oui.popover.v2.a) ZeusTransformUtils.preCheckCast(r1.element, com.obric.oui.popover.v2.a.class, "com.obric.memorydata.plugin");
        if (r7 == null) goto L5;
        r7.dismiss();
    L5:
        r6.showRuleEditDialog(Integer.valueOf(r3));
        return Unit.INSTANCE;
    }

    private static final Unit showItemMenu$lambda$31(Ref.ObjectRef r1, MemoryInfoSectionEditActivity r2, int r3, View r4, int r5) {
        MemoryInfoSectionEditActivity r6 = (MemoryInfoSectionEditActivity) ZeusTransformUtils.wrapperContextForParams(r2, MemoryInfoSectionEditActivity.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "<unused var>");
        com.obric.oui.popover.v2.a r7 = (com.obric.oui.popover.v2.a) ZeusTransformUtils.preCheckCast(r1.element, com.obric.oui.popover.v2.a.class, "com.obric.memorydata.plugin");
        if (r7 == null) goto L5;
        r7.dismiss();
    L5:
        r6.showDeleteConfirmDialog(r3);
        return Unit.INSTANCE;
    }

    private static final void showItemMenu$lambda$33$lambda$32(OUICardConstraintLayout r0, Drawable r1) {
        if (r0 == null) goto L5;
        r0.setBackground(r1);
        return;
    }

    private final void showRuleEditDialog(final Integer r33) {
        final f r12 = (f) ZeusTransformUtils.preCheckCast(getViewModel().getState().c(), f.class, "com.obric.memorydata.plugin");
        final List<String> r13 = r12.c().b();
        if (r33 == null) goto L10;
        if (r33.intValue() >= 0) goto L7;
        return;
    L7:
        if (r33.intValue() < r13.size()) goto L10;
        return;
    L10:
        if (r33 == null) goto L12;
        boolean r8 = true;
    L14:
        if (r33 == null) goto L16;
        String r0 = (String) ZeusTransformUtils.preCheckCast(r13.get(((Number) ZeusTransformUtils.preCheckCast(r33, Number.class, "com.obric.memorydata.plugin")).intValue()), String.class, "com.obric.memorydata.plugin");
    L17:
        if (r0 != null) goto L19;
        r0 = "";
    L19:
        final String r6 = r0;
        if (r8 == false) goto L22;
        int r1 = R.string.memory_info_section_dialog_edit;
        String r2 = "memory_info_section_dialog_edit";
    L23:
        int r3 = ZeusTransformUtils.mapRes(r1, TypedValues.Custom.S_STRING, r2);
        if (r8 == false) goto L26;
        int r4 = R.string.memory_info_section_dialog_save;
        String r5 = "memory_info_section_dialog_save";
    L27:
        int r7 = ZeusTransformUtils.mapRes(r4, TypedValues.Custom.S_STRING, r5);
        final int r16 = 100;
        final Ref.ObjectRef r9 = new Ref.ObjectRef();
        final Ref.ObjectRef r17 = new Ref.ObjectRef();
        final Ref.ObjectRef r18 = new Ref.ObjectRef();
        final boolean r10 = r8;
        final boolean r25 = r8;
        com.obric.oui.dialog.v2.alert.style.f r11 = new com.obric.oui.dialog.v2.alert.style.f(new $$Lambda$MemoryInfoSectionEditActivity$ReNJriHWILiN4uELvdX70kfMCkI(this, r9, r17, r18, r16, r6, r10, r12));
        final Ref.BooleanRef r14 = new Ref.BooleanRef();
        com.obric.oui.dialog.v2.alert.b r15 = com.obric.oui.dialog.v2.alert.b.a(new com.obric.oui.dialog.v2.alert.b((Context) ZeusTransformUtils.preCheckCast(this, Context.class, "com.obric.memorydata.plugin")).b(false), (CharSequence) ZeusTransformUtils.preCheckCast(getString(r3), CharSequence.class, "com.obric.memorydata.plugin"), false, 2, null).a((com.obric.oui.dialog.v2.alert.style.g) ZeusTransformUtils.preCheckCast(r11, com.obric.oui.dialog.v2.alert.style.g.class, "com.obric.memorydata.plugin")).a(true);
        String r19 = getString(ZeusTransformUtils.mapRes(R.string.memory_info_section_dialog_cancel, TypedValues.Custom.S_STRING, "memory_info_section_dialog_cancel"));
        Intrinsics.checkNotNullExpressionValue(r19, "getString(...)");
        com.obric.oui.dialog.v2.alert.b r26 = com.obric.oui.dialog.v2.alert.b.b(r15, (CharSequence) ZeusTransformUtils.preCheckCast(r19, CharSequence.class, "com.obric.memorydata.plugin"), new $$Lambda$MemoryInfoSectionEditActivity$lE13KpJOFfWJdKHtWSq03NCi4a8(this, r9), null, 4, null);
        String r20 = getString(r7);
        Intrinsics.checkNotNullExpressionValue(r20, "getString(...)");
        com.obric.oui.dialog.v2.alert.a r21 = com.obric.oui.dialog.v2.alert.b.a(r26, (CharSequence) ZeusTransformUtils.preCheckCast(r20, CharSequence.class, "com.obric.memorydata.plugin"), new $$Lambda$MemoryInfoSectionEditActivity$Yr_VgFfnXJnhiZZEyp8vVrp6TQ(r14, r9, r18, r25, r6, this, r13, r33, r12), null, 4, null).g();
        com.obric.oui.dialog.v2.alert.a r22 = (com.obric.oui.dialog.v2.alert.a) ZeusTransformUtils.preCheckCast(r21, com.obric.oui.dialog.v2.alert.a.class, "com.obric.memorydata.plugin");
        r22.setCanceledOnTouchOutside(true);
        r22.setCancelable(true);
        showRuleEditDialog$lambda$26$applyEnabledStyle(r22, this, showRuleEditDialog$lambda$26$computeEnabled(r25, r6, r6));
        OInputLayout r23 = (OInputLayout) ZeusTransformUtils.preCheckCast(r9.element, OInputLayout.class, "com.obric.memorydata.plugin");
        if (r23 == null) goto L32;
        OEditText r24 = r23.getVInput();
        if (r24 == null) goto L32;
        TextView r27 = (TextView) ZeusTransformUtils.preCheckCast(r24, TextView.class, "com.obric.memorydata.plugin");
        d r28 = new d(r17, 100, r25, r6, r22, this);
        r27.addTextChangedListener((TextWatcher) ZeusTransformUtils.preCheckCast(r28, TextWatcher.class, "com.obric.memorydata.plugin"));
        TextWatcher r29 = (TextWatcher) ZeusTransformUtils.preCheckCast(r28, TextWatcher.class, "com.obric.memorydata.plugin");
    L32:
        ((com.obric.oui.dialog.v2.alert.a) ZeusTransformUtils.preCheckCast(r21, com.obric.oui.dialog.v2.alert.a.class, "com.obric.memorydata.plugin")).show();
        return;
    L26:
        r4 = R.string.memory_info_section_dialog_confirm;
        r5 = "memory_info_section_dialog_confirm";
        goto L27
    L22:
        r1 = R.string.memory_info_section_dialog_add;
        r2 = "memory_info_section_dialog_add";
        goto L23
    L16:
        r0 = null;
        goto L17
    L12:
        r8 = false;
        goto L14
    }

    /* JADX WARN: Type inference failed for: r0v9, types: [T, android.widget.TextView, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r8v3, types: [T, com.obric.oui.forms.OInputLayout, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r9v13, types: [T, android.widget.TextView, java.lang.Object] */
    private static final Unit showRuleEditDialog$lambda$21(MemoryInfoSectionEditActivity r16, Ref.ObjectRef r17, Ref.ObjectRef r18, Ref.ObjectRef r19, int r20, String r21, boolean r22, f r23, com.obric.oui.dialog.v2.alert.style.d r24) {
        final MemoryInfoSectionEditActivity r2 = (MemoryInfoSectionEditActivity) ZeusTransformUtils.wrapperContextForParams(r16, MemoryInfoSectionEditActivity.class, "com.obric.memorydata.plugin");
        com.obric.oui.dialog.v2.alert.style.d r4 = (com.obric.oui.dialog.v2.alert.style.d) ZeusTransformUtils.wrapperContextForParams(r24, com.obric.oui.dialog.v2.alert.style.d.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "container");
        FrameLayout r5 = r4.getBodySlot();
        LinearLayout r6 = new LinearLayout((Context) ZeusTransformUtils.preCheckCast(r2, Context.class, "com.obric.memorydata.plugin"));
        r6.setOrientation(1);
        FrameLayout r7 = new FrameLayout((Context) ZeusTransformUtils.preCheckCast(r2, Context.class, "com.obric.memorydata.plugin"));
        final ?? r8 = new OInputLayout((Context) ZeusTransformUtils.preCheckCast(r2, Context.class, "com.obric.memorydata.plugin"), null, 0, 6, null);
        r8.setType(1);
        r8.a(true);
        r8.c(false);
        r8.e(false);
        r8.g(false);
        r8.setLimitCount(r20);
        r8.setAutoChangeWithLimit(true);
        r8.getVInput().setTextSize(2, 16.0f);
        r8.getVInput().setInputType(131073);
        r8.getVInput().setGravity(MaterialCardView.CHECKED_ICON_GRAVITY_TOP_START);
        r8.getVInput().setMaxLines(6);
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r21, CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L5;
        boolean r10 = true;
    L6:
        if (r10 == false) goto L8;
        r8.setText((CharSequence) ZeusTransformUtils.preCheckCast(r21, CharSequence.class, "com.obric.memorydata.plugin"));
        r8.getVInput().setSelection(r21.length());
    L8:
        if (r22 == false) goto L10;
    L14:
        r8.getVInput().setFilters((InputFilter[]) ZeusTransformUtils.preCheckCast(new InputFilter.LengthFilter[]{new InputFilter.LengthFilter(r20)}, InputFilter[].class, "com.obric.memorydata.plugin"));
        int r9 = ZeusTransformUtils.getIdentifier(ZeusTransformUtils.getResources(r2, "com.obric.memorydata.plugin"), "helper_container", OaidModel.KEY_ID, r2.getPackageName(), "com.obric.memorydata.plugin");
        if (r9 == 0) goto L19;
        View r11 = r8.findViewById(r9);
        if (r11 == null) goto L19;
        r11.setVisibility(8);
    L19:
        r17.element = r8;
        r7.addView((View) ZeusTransformUtils.preCheckCast(r8, View.class, "com.obric.memorydata.plugin"), (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(new FrameLayout.LayoutParams(-1, -2), ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin"));
        ?? r12 = new TextView((Context) ZeusTransformUtils.preCheckCast(r2, Context.class, "com.obric.memorydata.plugin"));
        r12.setTextSize(2, 10.0f);
        r12.setTextColor(r2.getColor(ZeusTransformUtils.mapRes(R.color.oui_basic_text_3, TypedValues.Custom.S_COLOR, "oui_basic_text_3")));
        r12.setText((CharSequence) ZeusTransformUtils.preCheckCast(new StringBuilder().append(r21.length()).append('/').append(r20).toString(), CharSequence.class, "com.obric.memorydata.plugin"));
        r18.element = r12;
        View r0 = (View) ZeusTransformUtils.preCheckCast(r12, View.class, "com.obric.memorydata.plugin");
        FrameLayout.LayoutParams r1 = new FrameLayout.LayoutParams(-2, -2);
        r1.gravity = MaterialCardView.CHECKED_ICON_GRAVITY_BOTTOM_END;
        float r13 = 12;
        r1.setMarginEnd(MathKt.roundToInt(TypedValue.applyDimension(1, r13, Resources.getSystem().getDisplayMetrics())));
        float r14 = 8;
        r1.bottomMargin = MathKt.roundToInt(TypedValue.applyDimension(1, r14, Resources.getSystem().getDisplayMetrics()));
        Unit r15 = Unit.INSTANCE;
        r7.addView(r0, (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r1, ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin"));
        ?? r3 = new TextView((Context) ZeusTransformUtils.preCheckCast(r2, Context.class, "com.obric.memorydata.plugin"));
        r3.setVisibility(4);
        r3.setGravity(8388627);
        r3.setTextSize(2, 10.0f);
        r3.setTextColor(r2.getColor(ZeusTransformUtils.mapRes(R.color.oui_functional_red_6, TypedValues.Custom.S_COLOR, "oui_functional_red_6")));
        float r110 = 5;
        r3.setPadding(MathKt.roundToInt(TypedValue.applyDimension(1, r13, Resources.getSystem().getDisplayMetrics())), MathKt.roundToInt(TypedValue.applyDimension(1, r110, Resources.getSystem().getDisplayMetrics())), MathKt.roundToInt(TypedValue.applyDimension(1, r13, Resources.getSystem().getDisplayMetrics())), MathKt.roundToInt(TypedValue.applyDimension(1, r110, Resources.getSystem().getDisplayMetrics())));
        r3.setText((CharSequence) ZeusTransformUtils.preCheckCast(" ", CharSequence.class, "com.obric.memorydata.plugin"));
        r19.element = r3;
        FrameLayout.LayoutParams r25 = new FrameLayout.LayoutParams(-1, -2);
        float r26 = 20;
        r25.leftMargin = MathKt.roundToInt(TypedValue.applyDimension(1, r26, Resources.getSystem().getDisplayMetrics()));
        r25.rightMargin = MathKt.roundToInt(TypedValue.applyDimension(1, r26, Resources.getSystem().getDisplayMetrics()));
        r25.bottomMargin = MathKt.roundToInt(TypedValue.applyDimension(1, r14, Resources.getSystem().getDisplayMetrics()));
        r6.addView((View) ZeusTransformUtils.preCheckCast(r7, View.class, "com.obric.memorydata.plugin"), (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(new LinearLayout.LayoutParams(-1, -2), ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin"));
        r6.addView((View) ZeusTransformUtils.preCheckCast(r3, View.class, "com.obric.memorydata.plugin"), (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(new LinearLayout.LayoutParams(-1, -2), ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin"));
        r5.addView((View) ZeusTransformUtils.preCheckCast(r6, View.class, "com.obric.memorydata.plugin"), (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r25, ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin"));
        r8.postDelayed(new $$Lambda$MemoryInfoSectionEditActivity$OLaHQuDCjYL0MRrT6KRsritikI(r2, r8), 100);
        return Unit.INSTANCE;
    L10:
        if (Intrinsics.areEqual(r23.a(), "info") == false) goto L12;
        int r111 = R.string.memory_info_section_dialog_add_hint_info;
        String r112 = "memory_info_section_dialog_add_hint_info";
    L13:
        r8.setHint((CharSequence) ZeusTransformUtils.preCheckCast(r2.getString(ZeusTransformUtils.mapRes(r111, TypedValues.Custom.S_STRING, r112)), CharSequence.class, "com.obric.memorydata.plugin"));
        goto L14
    L12:
        r111 = R.string.memory_info_section_dialog_add_hint;
        r112 = "memory_info_section_dialog_add_hint";
        goto L13
    L5:
        r10 = false;
        goto L6
    }

    private static final void showRuleEditDialog$lambda$21$lambda$20(MemoryInfoSectionEditActivity r2, OInputLayout r3) {
        MemoryInfoSectionEditActivity r4 = (MemoryInfoSectionEditActivity) ZeusTransformUtils.wrapperContextForParams(r2, MemoryInfoSectionEditActivity.class, "com.obric.memorydata.plugin");
        Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L5
        Result.m1421constructorimpl(Boolean.valueOf(r3.getVInput().requestFocus()));     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        Result.Companion r6 = Result.Companion;
        Result.m1421constructorimpl(ResultKt.createFailure(th));
    }

    private static final void showRuleEditDialog$lambda$22(MemoryInfoSectionEditActivity r1, Ref.ObjectRef r2, DialogInterface r3, int r4) {
        MemoryInfoSectionEditActivity r5 = (MemoryInfoSectionEditActivity) ZeusTransformUtils.wrapperContextForParams(r1, MemoryInfoSectionEditActivity.class, "com.obric.memorydata.plugin");
        DialogInterface r6 = (DialogInterface) ZeusTransformUtils.wrapperContextForParams(r3, DialogInterface.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNull(r6);
        r5.dismissWithKeyboardHidden(r6, (OInputLayout) ZeusTransformUtils.preCheckCast(r2.element, OInputLayout.class, "com.obric.memorydata.plugin"));
    }

    private static final void showRuleEditDialog$lambda$24(Ref.BooleanRef r17, Ref.ObjectRef r18, Ref.ObjectRef r19, boolean r20, String r21, MemoryInfoSectionEditActivity r22, List r23, Integer r24, f r25, DialogInterface r26, int r27) {
        MemoryInfoSectionEditActivity r4 = (MemoryInfoSectionEditActivity) ZeusTransformUtils.wrapperContextForParams(r22, MemoryInfoSectionEditActivity.class, "com.obric.memorydata.plugin");
        List r10 = (List) ZeusTransformUtils.wrapperContextForParams(r23, List.class, "com.obric.memorydata.plugin");
        DialogInterface r7 = (DialogInterface) ZeusTransformUtils.wrapperContextForParams(r26, DialogInterface.class, "com.obric.memorydata.plugin");
        if (r17.element == false) goto L5;
        return;
    L5:
        OInputLayout r0 = (OInputLayout) ZeusTransformUtils.preCheckCast(r18.element, OInputLayout.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L14;
        OEditText r1 = r0.getVInput();
        if (r1 == null) goto L14;
        Editable r2 = r1.getText();
        if (r2 == null) goto L14;
        String r3 = r2.toString();
        if (r3 == null) goto L14;
        String r5 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.memorydata.plugin")).toString();
    L15:
        if (r5 != null) goto L17;
        r5 = "";
    L17:
        String r6 = r5;
        TextView r8 = (TextView) ZeusTransformUtils.preCheckCast(r19.element, TextView.class, "com.obric.memorydata.plugin");
        if (r8 == null) goto L20;
        r8.setVisibility(4);
    L20:
        TextView r9 = (TextView) ZeusTransformUtils.preCheckCast(r19.element, TextView.class, "com.obric.memorydata.plugin");
        if (r9 == null) goto L24;
        r9.setText((CharSequence) ZeusTransformUtils.preCheckCast(" ", CharSequence.class, "com.obric.memorydata.plugin"));
    L24:
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.memorydata.plugin")) == false) goto L26;
        return;
    L26:
        if (r20 == true) goto L28;
    L31:
        Iterable r11 = CollectionsKt.withIndex((Iterable) ZeusTransformUtils.preCheckCast(r10, Iterable.class, "com.obric.memorydata.plugin"));
        if (ZeusTransformUtils.instanceOf(r11, Collection.class) == true) goto L34;
    L36:
        Iterator r12 = r11.iterator();
    L38:
        if (r12.hasNext() == false) goto L35;
        IndexedValue r13 = (IndexedValue) ZeusTransformUtils.preCheckCast(r12.next(), IndexedValue.class, "com.obric.memorydata.plugin");
        int r14 = r13.component1();
        String r15 = (String) ZeusTransformUtils.preCheckCast(r13.component2(), String.class, "com.obric.memorydata.plugin");
        if (r24 == null) goto L45;
        if (r14 != r24.intValue()) goto L45;
    L47:
        boolean r16 = false;
    L48:
        if (r16 == false) goto L38;
        boolean r28 = true;
    L50:
        if (r28 == true) goto L52;
        r17.element = true;
        kotlinx.coroutines.i.a((al) ZeusTransformUtils.preCheckCast(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) ZeusTransformUtils.preCheckCast(r4, LifecycleOwner.class, "com.obric.memorydata.plugin")), al.class, "com.obric.memorydata.plugin"), null, null, (Function2) ZeusTransformUtils.preCheckCast(new MemoryInfoSectionEditActivity$showRuleEditDialog$2$1(r17, r19, r20, r4, r24, r6, r7, r18, r25, r10, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
        return;
    L52:
        if (r20 == false) goto L54;
        MemoryInfoSectionEditViewModel r29 = r4.getViewModel();
        Intrinsics.checkNotNull(r24);
        r29.deleteItem(r24.intValue());
        Context r30 = (Context) ZeusTransformUtils.preCheckCast(r4, Context.class, "com.obric.memorydata.plugin");
        int r31 = R.string.memory_info_section_edit_success;
        String r32 = "memory_info_section_edit_success";
    L55:
        Toast.makeText(r30, ZeusTransformUtils.mapRes(r31, TypedValues.Custom.S_STRING, r32), 0).show();
        Intrinsics.checkNotNull(r7);
        r4.dismissWithKeyboardHidden(r7, (OInputLayout) ZeusTransformUtils.preCheckCast(r18.element, OInputLayout.class, "com.obric.memorydata.plugin"));
        return;
    L54:
        r30 = (Context) ZeusTransformUtils.preCheckCast(r4, Context.class, "com.obric.memorydata.plugin");
        r31 = R.string.memory_info_section_item_duplicate;
        r32 = "memory_info_section_item_duplicate";
    L45:
        if (Intrinsics.areEqual(r15, r6) == false) goto L47;
        r16 = true;
    L35:
        r28 = false;
        goto L50
    L34:
        if (((Collection) ZeusTransformUtils.preCheckCast(r11, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L36;
    L28:
        if (Intrinsics.areEqual(r6, r21) == false) goto L31;
        Intrinsics.checkNotNull(r7);
        r4.dismissWithKeyboardHidden(r7, (OInputLayout) ZeusTransformUtils.preCheckCast(r18.element, OInputLayout.class, "com.obric.memorydata.plugin"));
        return;
    L14:
        r5 = null;
        goto L15
    }

    private static final void showRuleEditDialog$lambda$26$applyEnabledStyle(com.obric.oui.dialog.v2.alert.a r2, MemoryInfoSectionEditActivity r3, boolean r4) {
        MemoryInfoSectionEditActivity r5 = (MemoryInfoSectionEditActivity) ZeusTransformUtils.wrapperContextForParams(r3, MemoryInfoSectionEditActivity.class, "com.obric.memorydata.plugin");
        View r6 = r2.g();
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

    private static final boolean showRuleEditDialog$lambda$26$computeEnabled(boolean r3, String r4, String r5) {
        String r6 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.memorydata.plugin")).toString();
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.memorydata.plugin")).length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        return false;
    L8:
        if (r3 == true) goto L10;
        return true;
    L10:
        if (Intrinsics.areEqual(r6, r4) == true) goto L13;
        return true;
    L13:
        return false;
    L5:
        r0 = false;
        goto L6
    }

    @Override // com.obric.memorydata.ui.BaseActivity
    public NavigationBarScheme getNavigationBarScheme() {
        Intent r1 = getIntent();
        if (r1 == null) goto L5;
        String r2 = r1.getStringExtra(EXTRA_KIND);
    L7:
        if (Intrinsics.areEqual(r2, "info") == false) goto L10;
        return NavigationBarScheme.B1;
    L10:
        return NavigationBarScheme.B3;
    L5:
        r2 = null;
        goto L7
    }

    @Override // com.obric.memorydata.ui.BaseActivity
    public void onCreateChecked(Bundle r12) {
        setupInset();
        prepareSystemBar();
        AutoMemoryProActivityMemoryInfoSectionEditBinding r13 = AutoMemoryProActivityMemoryInfoSectionEditBinding.inflate(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(r13, "inflate(...)");
        this.binding = r13;
        AutoMemoryProActivityMemoryInfoSectionEditBinding r1 = null;
        if (r13 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r13 = null;
    L5:
        setContentView((View) ZeusTransformUtils.preCheckCast(r13.getRoot(), View.class, "com.obric.memorydata.plugin"));
        AutoMemoryProActivityMemoryInfoSectionEditBinding r14 = this.binding;
        if (r14 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r14 = null;
    L8:
        View r15 = (View) ZeusTransformUtils.preCheckCast(r14.viewTitle, View.class, "com.obric.memorydata.plugin");
        AutoMemoryProActivityMemoryInfoSectionEditBinding r2 = this.binding;
        if (r2 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r2 = null;
    L11:
        setupCutOffArea(r15, r2.cutOff);
        String r16 = getIntent().getStringExtra("session_id");
        String r3 = "";
        if (r16 != null) goto L14;
        r16 = "";
    L14:
        String r4 = getIntent().getStringExtra(EXTRA_KIND);
        if (r4 == null) goto L19;
        r3 = r4;
    L19:
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r16, CharSequence.class, "com.obric.memorydata.plugin")).length() != 0) goto L21;
        boolean r5 = true;
    L22:
        if (r5 == false) goto L24;
    L42:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "no sessionId or kind, finish", null, 4, null);
        finish();
        return;
    L24:
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.memorydata.plugin")) == true) goto L42;
        AutoMemoryProActivityMemoryInfoSectionEditBinding r6 = this.binding;
        if (r6 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r6 = null;
    L29:
        OFloatingTitleBar.a(r6.viewTitle, ZeusTransformUtils.mapRes(R.drawable.o_floating_title_bar_icon_back, "drawable", "o_floating_title_bar_icon_back"), 0, new $$Lambda$MemoryInfoSectionEditActivity$sGqVwuMAE2EN1VPprcBMlOvnvj0(this), 2, null);
        if (Intrinsics.areEqual(r3, KIND_SCENE) == false) goto L32;
    L35:
        setupSceneMode(r3);
    L36:
        getViewModel().bind(r16, r3);
        kotlinx.coroutines.i.a((al) ZeusTransformUtils.preCheckCast(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) ZeusTransformUtils.preCheckCast(this, LifecycleOwner.class, "com.obric.memorydata.plugin")), al.class, "com.obric.memorydata.plugin"), null, null, (Function2) ZeusTransformUtils.preCheckCast(new C11332(this, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
        AutoMemoryProActivityMemoryInfoSectionEditBinding r17 = this.binding;
        if (r17 != null) goto L39;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L40:
        OFloatingTitleBar r18 = r1.viewTitle;
        Intrinsics.checkNotNullExpressionValue(r18, "viewTitle");
        registerFloatingTitleBar(r18);
        return;
    L39:
        r1 = r17;
        goto L40
    L32:
        if (Intrinsics.areEqual(r3, KIND_UPDATE_RULE) == true) goto L35;
        setupInfoMode();
        goto L36
    L21:
        r5 = false;
        goto L22
    }
}
