package com.obric.memorydata.memory.ui.automemory.settings;

import androidx.core.app.NotificationCompat;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.bytedance.ies.common.cpp_shared.BuildConfig;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.aikernel.sdk.ext.Params;
import com.obric.memorydata.database.dao.MemoryRuleDao;
import com.obric.memorydata.database.entity.ChatMessage;
import com.obric.memorydata.database.entity.MemoryRuleEntity;
import com.obric.memorydata.database.manager.MemoryDbEngine;
import com.obric.memorydata.memory.tracker.MemoryEventTracker;
import com.obric.memorydata.memory.ui.automemory.v;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.task.condition.Condition;
import com.obric.memorydata.task.impl.TaskInfo;
import com.obric.memorydata.task.impl.TaskRequest;
import com.obric.memorydata.task.scheduler.impl.ExistingTaskPolicy;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.al;
import kotlinx.coroutines.am;
import kotlinx.coroutines.ar;
import kotlinx.coroutines.ba;
import kotlinx.coroutines.bx;
import kotlinx.coroutines.da;
import kotlinx.coroutines.flow.ae;
import kotlinx.coroutines.flow.at;
import kotlinx.coroutines.flow.k;
import kotlinx.coroutines.n;
import kotlinx.coroutines.o;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 H2\u00020\u0001:\u0001HB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\fJ\"\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00172\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00130\u0019J\u000e\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u001b\u001a\u00020\fJ\u000e\u0010\u001c\u001a\u00020\u00132\u0006\u0010\u001d\u001a\u00020\u000eJ\u000e\u0010\u001e\u001a\u00020\u00132\u0006\u0010\u001f\u001a\u00020\fJ\u000e\u0010 \u001a\u00020\u00132\u0006\u0010\u001f\u001a\u00020\fJ\u0006\u0010!\u001a\u00020\u000eJL\u0010\"\u001a\u00020\u00132\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00130$2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00130$2\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00130$2\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00130$2\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00130$J\u0010\u0010)\u001a\u00020\u000e2\u0006\u0010*\u001a\u00020+H\u0002J\u0016\u0010,\u001a\u00020\u000e2\u0006\u0010*\u001a\u00020+H\u0082@¢\u0006\u0002\u0010-J\u0010\u0010.\u001a\u00020\u00132\u0006\u0010*\u001a\u00020+H\u0002J\u0010\u0010/\u001a\u00020\u00132\u0006\u0010*\u001a\u00020+H\u0002J\u0010\u00100\u001a\u00020\u00132\u0006\u0010*\u001a\u00020+H\u0002J\u0018\u00101\u001a\u0004\u0018\u00010+2\u0006\u00102\u001a\u00020+H\u0082@¢\u0006\u0002\u0010-J\u0010\u00103\u001a\u00020+2\u0006\u0010*\u001a\u00020+H\u0002J\u0018\u00104\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u00102\u0006\u0010*\u001a\u00020+H\u0002J\u0010\u00105\u001a\u00020\u000e2\u0006\u0010*\u001a\u00020+H\u0002J\u0018\u00106\u001a\u0004\u0018\u00010\u00112\u0006\u00107\u001a\u00020\fH\u0082@¢\u0006\u0002\u00108J\u0016\u00109\u001a\u00020\u00132\u0006\u00107\u001a\u00020\fH\u0082@¢\u0006\u0002\u00108J\u0016\u0010:\u001a\u00020\u000e2\u0006\u00107\u001a\u00020\fH\u0082@¢\u0006\u0002\u00108J&\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020\u000e2\u0006\u0010>\u001a\u00020\f2\u0006\u0010?\u001a\u00020\fH\u0086@¢\u0006\u0002\u0010@J\u0010\u0010A\u001a\u00020\u000e2\u0006\u0010B\u001a\u00020CH\u0002J\u001e\u0010D\u001a\u00020C2\u0006\u0010E\u001a\u00020\f2\u0006\u0010F\u001a\u00020CH\u0082@¢\u0006\u0002\u0010GR\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\u000f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0011\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006I"}, d2 = {"Lcom/obric/memorydata/memory/ui/automemory/settings/MemoryTaskSettingsViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "_state", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/obric/memorydata/memory/ui/automemory/settings/MemoryTaskSettingsUiState;", "state", "Lkotlinx/coroutines/flow/StateFlow;", "getState", "()Lkotlinx/coroutines/flow/StateFlow;", ObricMemoryConstants.KEY_SESSION_ID, "", "committed", "", "iconGenerateDeferred", "Lkotlinx/coroutines/Deferred;", "Lcom/obric/memorydata/memory/ui/automemory/settings/IconInfo;", "bind", "", "sid", "bootstrapForEdit", "ruleId", "", "onReady", "Lkotlin/Function1;", "updateTitle", "newTitle", "updateUseClientModel", "enabled", "updateTitleFormat", "newValue", "updateSubtitleFormat", "isCommitted", "confirmCreate", "onDone", "Lkotlin/Function0;", "onTitleAuditFailed", "onIconGenerateFailed", "onClientModelLimitReached", "onCreateFailed", "isClientModelLimitReached", "draft", "Lcom/obric/memorydata/memory/ui/automemory/settings/DraftRule;", "auditTitleIfChanged", "(Lcom/obric/memorydata/memory/ui/automemory/settings/DraftRule;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "commitDraft", "trackRuleEdit", "startIconGenerationIfNeeded", "ensureIconReadyBeforeCommit", "initialDraft", "normalizePreparedIconVersion", "startIconGeneration", "shouldGenerateIcon", "runIconGenerator", Params.CONTENT, "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "generateMemoryInfo", "runRuleCheck", "auditFormatInput", "Lcom/obric/memorydata/memory/ui/automemory/settings/FormatAuditResult;", "isTitle", "sectionTitle", "candidateText", "(ZLjava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "parseAuditPassed", "result", "Lorg/json/JSONObject;", "runAlgoTask", ActivityLifecycle.NAME, "input", "(Ljava/lang/String;Lorg/json/JSONObject;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class MemoryTaskSettingsViewModel extends ViewModel {
    public static final a Companion = null;
    private static final long NO_RULE_ID = 0;
    private static final String TAG = "MemoryTaskSettingsVM";
    private static final long TASK_TIMEOUT_EXTRA_MS = 2000;
    private static final long TASK_TIMEOUT_SEC = 15;
    private final ae<i> _state;
    private boolean committed;
    private ar<c> iconGenerateDeferred;
    private String sessionId;
    private final kotlinx.coroutines.flow.ar<i> state;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/obric/memorydata/memory/ui/automemory/settings/MemoryTaskSettingsViewModel$Companion;", "", "<init>", "()V", "TAG", "", "TASK_TIMEOUT_SEC", "", "TASK_TIMEOUT_EXTRA_MS", "NO_RULE_ID", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.automemory.settings.MemoryTaskSettingsViewModel$auditFormatInput$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/obric/memorydata/memory/ui/automemory/settings/FormatAuditResult;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.memory.ui.automemory.settings.MemoryTaskSettingsViewModel$auditFormatInput$2", f = "MemoryTaskSettingsActivity.kt", i = {0}, l = {1268, 1273}, m = "invokeSuspend", n = {"relevanceDeferred"}, s = {"L$0"})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<al, Continuation<? super FormatAuditResult>, Object> {
        final /* synthetic */ String $candidateText;
        final /* synthetic */ boolean $isTitle;
        final /* synthetic */ String $sectionTitle;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ MemoryTaskSettingsViewModel this$0;

        AnonymousClass2(MemoryTaskSettingsViewModel r3, boolean r4, String r5, String r6, Continuation<? super AnonymousClass2> r7) {
            Continuation r8 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r7, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            this.$isTitle = r4;
            this.$candidateText = r5;
            this.$sectionTitle = r6;
            super(2, r8);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r9, Continuation<?> r10) {
            Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r10, Continuation.class, "com.obric.memorydata.plugin");
            AnonymousClass2 r11 = new AnonymousClass2(this.this$0, this.$isTitle, this.$candidateText, this.$sectionTitle, r7);
            r11.L$0 = r9;
            return (Continuation) ZeusTransformUtils.preCheckCast(r11, Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(al r3, Continuation<? super FormatAuditResult> r4) {
            return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(al r3, Continuation<? super FormatAuditResult> r4) {
            return ((AnonymousClass2) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), AnonymousClass2.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r20) {
            Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r2 = this.label;
            if (r2 == 0) goto L10;
            if (r2 == 1) goto L9;
            if (r2 != 2) goto L8;
            ResultKt.throwOnFailure(r20);
            Object r0 = r20;
        L31:
            if (((Boolean) ZeusTransformUtils.preCheckCast(r0, Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == true) goto L35;
            return FormatAuditResult.RELEVANCE_FAILED;
        L35:
            return FormatAuditResult.PASSED;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            ar r3 = (ar) ZeusTransformUtils.preCheckCast(this.L$0, ar.class, "com.obric.memorydata.plugin");
            ResultKt.throwOnFailure(r20);
            ar r7 = r3;
            Object r4 = r20;
        L24:
            if (((Boolean) ZeusTransformUtils.preCheckCast(r4, Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == true) goto L27;
            bx.a.a((bx) ZeusTransformUtils.preCheckCast(r7, bx.class, "com.obric.memorydata.plugin"), null, 1, null);
            return FormatAuditResult.COMPLIANCE_FAILED;
        L27:
            Continuation r5 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.L$0 = null;
            this.label = 2;
            r0 = r7.a(r5);
            if (r0 != r1) goto L31;
            return r1;
        L10:
            ResultKt.throwOnFailure(r20);
            al r6 = (al) ZeusTransformUtils.preCheckCast(this.L$0, al.class, "com.obric.memorydata.plugin");
            b r8 = g.f10759a.b(MemoryTaskSettingsViewModel.access$getSessionId$p(this.this$0));
            if (this.$isTitle == false) goto L13;
            String r9 = "title_format";
        L14:
            String r13 = r9;
            if (r8 == null) goto L17;
            String r10 = r8.b();
        L18:
            if (r10 != null) goto L20;
            r10 = "";
        L20:
            ar r11 = kotlinx.coroutines.i.b(r6, null, null, (Function2) ZeusTransformUtils.preCheckCast(new MemoryTaskSettingsViewModel$auditFormatInput$2$complianceDeferred$1(this.this$0, this.$candidateText, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
            r7 = kotlinx.coroutines.i.b(r6, null, null, (Function2) ZeusTransformUtils.preCheckCast(new MemoryTaskSettingsViewModel$auditFormatInput$2$relevanceDeferred$1(this.this$0, r13, this.$sectionTitle, r10, this.$candidateText, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
            Continuation r12 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.L$0 = r7;
            this.label = 1;
            r4 = r11.a(r12);
            if (r4 != r1) goto L24;
            return r1;
        L17:
            r10 = null;
            goto L18
        L13:
            r9 = "subtitle_format";
            goto L14
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.automemory.settings.MemoryTaskSettingsViewModel$auditTitleIfChanged$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.memory.ui.automemory.settings.MemoryTaskSettingsViewModel", f = "MemoryTaskSettingsActivity.kt", i = {}, l = {930}, m = "auditTitleIfChanged", n = {}, s = {})
    static final class AnonymousClass1 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ MemoryTaskSettingsViewModel this$0;

        AnonymousClass1(MemoryTaskSettingsViewModel r3, Continuation<? super AnonymousClass1> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            super(r5);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r3) {
            this.result = r3;
            this.label |= Integer.MIN_VALUE;
            return MemoryTaskSettingsViewModel.access$auditTitleIfChanged(this.this$0, null, (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin"));
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.automemory.settings.MemoryTaskSettingsViewModel$bind$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.memory.ui.automemory.settings.MemoryTaskSettingsViewModel$bind$1", f = "MemoryTaskSettingsActivity.kt", i = {}, l = {808}, m = "invokeSuspend", n = {}, s = {})
    static final class C11351 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $sid;
        int label;
        final /* synthetic */ MemoryTaskSettingsViewModel this$0;

        C11351(String r3, MemoryTaskSettingsViewModel r4, Continuation<? super C11351> r5) {
            Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
            this.$sid = r3;
            this.this$0 = r4;
            super(2, r6);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new C11351(this.$sid, this.this$0, r5), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
            return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(al r3, Continuation<? super Unit> r4) {
            return ((C11351) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), C11351.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r6) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L6;
            ResultKt.throwOnFailure(r6);
        L14:
            throw new KotlinNothingValueException();
        L6:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r6);
            kotlinx.coroutines.flow.ar<b> r7 = g.f10759a.a(this.$sid);
            if (r7 == null) goto L16;
            final MemoryTaskSettingsViewModel r3 = this.this$0;
            kotlinx.coroutines.flow.j<? super b> r2 = (kotlinx.coroutines.flow.j) ZeusTransformUtils.preCheckCast(new C05381(r3), kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin");
            Continuation<?> r4 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 1;
            if (r7.collect(r2, r4) != r0) goto L14;
            return r0;
        L16:
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.automemory.settings.MemoryTaskSettingsViewModel$bootstrapForEdit$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.memory.ui.automemory.settings.MemoryTaskSettingsViewModel$bootstrapForEdit$1", f = "MemoryTaskSettingsActivity.kt", i = {}, l = {831}, m = "invokeSuspend", n = {}, s = {})
    static final class C11361 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1<String, Unit> $onReady;
        final /* synthetic */ long $ruleId;
        int label;
        final /* synthetic */ MemoryTaskSettingsViewModel this$0;

        C11361(long r3, MemoryTaskSettingsViewModel r5, Function1<? super String, Unit> r6, Continuation<? super C11361> r7) {
            Function1<String, Unit> r8 = (Function1) ZeusTransformUtils.wrapperContextForParams(r6, Function1.class, "com.obric.memorydata.plugin");
            Continuation r9 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r7, Continuation.class, "com.obric.memorydata.plugin");
            this.$ruleId = r3;
            this.this$0 = r5;
            this.$onReady = r8;
            super(2, r9);
        }

        private static final Unit invokeSuspend$lambda$0(Function1 r2, String r3, MemoryTaskSettingsViewModel r4) {
            ((Function1) ZeusTransformUtils.wrapperContextForParams(r2, Function1.class, "com.obric.memorydata.plugin")).invoke(r3);
            r4.bind(r3);
            return Unit.INSTANCE;
        }

        public static /* synthetic */ Unit lambda$FajUdiPbQefWXAujhjSXBdC3CDs(Function1 r0, String r1, MemoryTaskSettingsViewModel r2) {
            return invokeSuspend$lambda$0(r0, r1, r2);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
            Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r9, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new C11361(this.$ruleId, this.this$0, this.$onReady, r6), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
            return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(al r3, Continuation<? super Unit> r4) {
            return ((C11361) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), C11361.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r8) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r8);
        L18:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r8);
            MemoryRuleEntity r9 = (MemoryRuleEntity) ZeusTransformUtils.preCheckCast(MemoryDbEngine.INSTANCE.getPersonalDbEngine().getMemoryRuleDao().queryById(this.$ruleId), MemoryRuleEntity.class, "com.obric.memorydata.plugin");
            if (r9 != null) goto L12;
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), MemoryTaskSettingsViewModel.TAG, "rule not found, id=" + this.$ruleId, null, 4, null);
            return Unit.INSTANCE;
        L12:
            final String r2 = g.f10759a.a(b.f10748a.a(r9));
            final Function1<String, Unit> r4 = this.$onReady;
            final MemoryTaskSettingsViewModel r5 = this.this$0;
            com.obric.memorydata.utils.j.a(new $$Lambda$MemoryTaskSettingsViewModel$bootstrapForEdit$1$FajUdiPbQefWXAujhjSXBdC3CDs(r4, r2, r5));
            if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r9.getMemoryInfoJson(), CharSequence.class, "com.obric.memorydata.plugin")) == false) goto L18;
            MemoryTaskSettingsViewModel r3 = this.this$0;
            String r10 = r9.getContent();
            Continuation r6 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 1;
            if (MemoryTaskSettingsViewModel.access$generateMemoryInfo(r3, r10, r6) != r0) goto L18;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.automemory.settings.MemoryTaskSettingsViewModel$confirmCreate$3, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.memory.ui.automemory.settings.MemoryTaskSettingsViewModel$confirmCreate$3", f = "MemoryTaskSettingsActivity.kt", i = {}, l = {892, 897}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass3 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
        final /* synthetic */ b $draft;
        final /* synthetic */ Function0<Unit> $onClientModelLimitReached;
        final /* synthetic */ Function0<Unit> $onCreateFailed;
        final /* synthetic */ Function0<Unit> $onDone;
        final /* synthetic */ Function0<Unit> $onIconGenerateFailed;
        final /* synthetic */ Function0<Unit> $onTitleAuditFailed;
        final /* synthetic */ String $sid;
        int label;
        final /* synthetic */ MemoryTaskSettingsViewModel this$0;

        AnonymousClass3(MemoryTaskSettingsViewModel r3, b r4, String r5, Function0<Unit> r6, Function0<Unit> r7, Function0<Unit> r8, Function0<Unit> r9, Function0<Unit> r10, Continuation<? super AnonymousClass3> r11) {
            Function0<Unit> r12 = (Function0) ZeusTransformUtils.wrapperContextForParams(r6, Function0.class, "com.obric.memorydata.plugin");
            Function0<Unit> r13 = (Function0) ZeusTransformUtils.wrapperContextForParams(r7, Function0.class, "com.obric.memorydata.plugin");
            Function0<Unit> r14 = (Function0) ZeusTransformUtils.wrapperContextForParams(r8, Function0.class, "com.obric.memorydata.plugin");
            Function0<Unit> r15 = (Function0) ZeusTransformUtils.wrapperContextForParams(r9, Function0.class, "com.obric.memorydata.plugin");
            Function0<Unit> r16 = (Function0) ZeusTransformUtils.wrapperContextForParams(r10, Function0.class, "com.obric.memorydata.plugin");
            Continuation r17 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r11, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            this.$draft = r4;
            this.$sid = r5;
            this.$onClientModelLimitReached = r12;
            this.$onTitleAuditFailed = r13;
            this.$onIconGenerateFailed = r14;
            this.$onDone = r15;
            this.$onCreateFailed = r16;
            super(2, r17);
        }

        private static final Unit invokeSuspend$lambda$1(Function0 r2) {
            ((Function0) ZeusTransformUtils.wrapperContextForParams(r2, Function0.class, "com.obric.memorydata.plugin")).invoke();
            return Unit.INSTANCE;
        }

        private static final Unit invokeSuspend$lambda$3(Function0 r2) {
            ((Function0) ZeusTransformUtils.wrapperContextForParams(r2, Function0.class, "com.obric.memorydata.plugin")).invoke();
            return Unit.INSTANCE;
        }

        private static final Unit invokeSuspend$lambda$5(Function0 r2) {
            ((Function0) ZeusTransformUtils.wrapperContextForParams(r2, Function0.class, "com.obric.memorydata.plugin")).invoke();
            return Unit.INSTANCE;
        }

        private static final Unit invokeSuspend$lambda$6(Function0 r2) {
            ((Function0) ZeusTransformUtils.wrapperContextForParams(r2, Function0.class, "com.obric.memorydata.plugin")).invoke();
            return Unit.INSTANCE;
        }

        private static final Unit invokeSuspend$lambda$8(Function0 r2) {
            ((Function0) ZeusTransformUtils.wrapperContextForParams(r2, Function0.class, "com.obric.memorydata.plugin")).invoke();
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: lambda$6ZOspBoXdRq-SVlWo2mLBbYbsoo, reason: not valid java name */
        public static /* synthetic */ Unit m835lambda$6ZOspBoXdRqSVlWo2mLBbYbsoo(Function0 r0) {
            return invokeSuspend$lambda$8(r0);
        }

        public static /* synthetic */ Unit lambda$KWmTDTEmCOuJIFDCDkkEryjSLTg(Function0 r0) {
            return invokeSuspend$lambda$3(r0);
        }

        public static /* synthetic */ Unit lambda$TGwLxSiBYk3f86Oz6ucdAb11lrk(Function0 r0) {
            return invokeSuspend$lambda$6(r0);
        }

        public static /* synthetic */ Unit lambda$YPMr4hZobB2CjQznicrnFpkHJlM(Function0 r0) {
            return invokeSuspend$lambda$1(r0);
        }

        public static /* synthetic */ Unit lambda$fIwTMPCluZyqfCmvTDHQOxbbmMY(Function0 r0) {
            return invokeSuspend$lambda$5(r0);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r12, Continuation<?> r13) {
            Continuation r10 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r13, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new AnonymousClass3(this.this$0, this.$draft, this.$sid, this.$onClientModelLimitReached, this.$onTitleAuditFailed, this.$onIconGenerateFailed, this.$onDone, this.$onCreateFailed, r10), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
            return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(al r3, Continuation<? super Unit> r4) {
            return ((AnonymousClass3) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), AnonymousClass3.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r9) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L14;
            if (r1 == 1) goto L10;
            if (r1 != 2) goto L9;
            ResultKt.throwOnFailure(r9);     // Catch: Exception -> L12
        L35:
            b r10 = (b) ZeusTransformUtils.preCheckCast(r9, b.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L12
            if (r10 != null) goto L42;
            ae r11 = MemoryTaskSettingsViewModel.access$get_state$p(this.this$0);     // Catch: Exception -> L12
        L38:
            Object r2 = r11.c();     // Catch: Exception -> L12
            if (r11.a(r2, i.a((i) ZeusTransformUtils.preCheckCast(r2, i.class, "com.obric.memorydata.plugin"), null, false, 1, null)) == false) goto L38;
            final Function0<Unit> r12 = this.$onIconGenerateFailed;     // Catch: Exception -> L12
            com.obric.memorydata.utils.j.a(new $$Lambda$MemoryTaskSettingsViewModel$confirmCreate$3$fIwTMPCluZyqfCmvTDHQOxbbmMY(r12));     // Catch: Exception -> L12
            return Unit.INSTANCE;
        L42:
            MemoryTaskSettingsViewModel.access$commitDraft(this.this$0, r10);     // Catch: Exception -> L12
            MemoryTaskSettingsViewModel.access$setCommitted$p(this.this$0, true);     // Catch: Exception -> L12
            MemoryTaskSettingsViewModel.access$trackRuleEdit(this.this$0, r10);     // Catch: Exception -> L12
            g.f10759a.c(this.$sid);     // Catch: Exception -> L12
            final Function0<Unit> r13 = this.$onDone;     // Catch: Exception -> L12
            com.obric.memorydata.utils.j.a(new $$Lambda$MemoryTaskSettingsViewModel$confirmCreate$3$TGwLxSiBYk3f86Oz6ucdAb11lrk(r13));     // Catch: Exception -> L12
        L49:
            return Unit.INSTANCE;
        L9:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L10:
            ResultKt.throwOnFailure(r9);     // Catch: Exception -> L12
        L26:
            if (((Boolean) ZeusTransformUtils.preCheckCast(r9, Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == true) goto L32;
            ae r14 = MemoryTaskSettingsViewModel.access$get_state$p(this.this$0);     // Catch: Exception -> L12
        L28:
            Object r3 = r14.c();     // Catch: Exception -> L12
            if (r14.a(r3, i.a((i) ZeusTransformUtils.preCheckCast(r3, i.class, "com.obric.memorydata.plugin"), null, false, 1, null)) == false) goto L28;
            final Function0<Unit> r15 = this.$onTitleAuditFailed;     // Catch: Exception -> L12
            com.obric.memorydata.utils.j.a(new $$Lambda$MemoryTaskSettingsViewModel$confirmCreate$3$KWmTDTEmCOuJIFDCDkkEryjSLTg(r15));     // Catch: Exception -> L12
            return Unit.INSTANCE;
        L32:
            MemoryTaskSettingsViewModel r16 = this.this$0;     // Catch: Exception -> L12
            b r4 = this.$draft;     // Catch: Exception -> L12
            Continuation r7 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L12
            this.label = 2;     // Catch: Exception -> L12
            r9 = MemoryTaskSettingsViewModel.access$ensureIconReadyBeforeCommit(r16, r4, r7);     // Catch: Exception -> L12
            if (r9 != r0) goto L35;
            return r0;
        L14:
            ResultKt.throwOnFailure(r9);
            if (MemoryTaskSettingsViewModel.access$isClientModelLimitReached(this.this$0, this.$draft) == false) goto L22;
            ae r17 = MemoryTaskSettingsViewModel.access$get_state$p(this.this$0);     // Catch: Exception -> L12
        L18:
            Object r5 = r17.c();     // Catch: Exception -> L12
            if (r17.a(r5, i.a((i) ZeusTransformUtils.preCheckCast(r5, i.class, "com.obric.memorydata.plugin"), null, false, 1, null)) == false) goto L18;
            final Function0<Unit> r18 = this.$onClientModelLimitReached;     // Catch: Exception -> L12
            com.obric.memorydata.utils.j.a(new $$Lambda$MemoryTaskSettingsViewModel$confirmCreate$3$YPMr4hZobB2CjQznicrnFpkHJlM(r18));     // Catch: Exception -> L12
            return Unit.INSTANCE;
        L22:
            MemoryTaskSettingsViewModel r19 = this.this$0;     // Catch: Exception -> L12
            b r6 = this.$draft;     // Catch: Exception -> L12
            Continuation r8 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L12
            this.label = 1;     // Catch: Exception -> L12
            r9 = MemoryTaskSettingsViewModel.access$auditTitleIfChanged(r19, r6, r8);     // Catch: Exception -> L12
            if (r9 != r0) goto L26;
            return r0;
        L12:
            e = move-exception;
            RunLog.INSTANCE.warn(MemoryTaskSettingsViewModel.TAG, "confirmCreate failed", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
            ae r20 = MemoryTaskSettingsViewModel.access$get_state$p(this.this$0);
        L45:
            Object r21 = r20.c();
            if (r20.a(r21, i.a((i) ZeusTransformUtils.preCheckCast(r21, i.class, "com.obric.memorydata.plugin"), null, false, 1, null)) == false) goto L45;
            final Function0<Unit> r22 = this.$onCreateFailed;
            com.obric.memorydata.utils.j.a(new $$Lambda$MemoryTaskSettingsViewModel$confirmCreate$3$6ZOspBoXdRqSVlWo2mLBbYbsoo(r22));
            goto L49
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.automemory.settings.MemoryTaskSettingsViewModel$ensureIconReadyBeforeCommit$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.memory.ui.automemory.settings.MemoryTaskSettingsViewModel", f = "MemoryTaskSettingsActivity.kt", i = {0, 0}, l = {1057}, m = "ensureIconReadyBeforeCommit", n = {"this", "draft"}, s = {"L$0", "L$1"})
    static final class C11371 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ MemoryTaskSettingsViewModel this$0;

        C11371(MemoryTaskSettingsViewModel r3, Continuation<? super C11371> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            super(r5);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r3) {
            this.result = r3;
            this.label |= Integer.MIN_VALUE;
            return MemoryTaskSettingsViewModel.access$ensureIconReadyBeforeCommit(this.this$0, null, (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin"));
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.automemory.settings.MemoryTaskSettingsViewModel$generateMemoryInfo$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.memory.ui.automemory.settings.MemoryTaskSettingsViewModel", f = "MemoryTaskSettingsActivity.kt", i = {0}, l = {1165}, m = "generateMemoryInfo", n = {"this"}, s = {"L$0"})
    static final class C11381 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ MemoryTaskSettingsViewModel this$0;

        C11381(MemoryTaskSettingsViewModel r3, Continuation<? super C11381> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            super(r5);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r3) {
            this.result = r3;
            this.label |= Integer.MIN_VALUE;
            return MemoryTaskSettingsViewModel.access$generateMemoryInfo(this.this$0, null, (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin"));
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.automemory.settings.MemoryTaskSettingsViewModel$runAlgoTask$2, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lorg/json/JSONObject;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.memory.ui.automemory.settings.MemoryTaskSettingsViewModel$runAlgoTask$2", f = "MemoryTaskSettingsActivity.kt", i = {}, l = {1336}, m = "invokeSuspend", n = {}, s = {})
    static final class C11392 extends SuspendLambda implements Function2<al, Continuation<? super JSONObject>, Object> {
        final /* synthetic */ JSONObject $input;
        final /* synthetic */ String $name;
        Object L$0;
        Object L$1;
        int label;

        /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.automemory.settings.MemoryTaskSettingsViewModel$runAlgoTask$2$a */
        @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
        static final class a implements Function1<Throwable, Unit> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ TaskRequest f10739a;

            a(TaskRequest r1) {
                this.f10739a = r1;
            }

            public final void a(Throwable r1) {
                this.f10739a.cancel();
            }

            @Override // kotlin.jvm.functions.Function1
            public /* synthetic */ Unit invoke(Throwable r3) {
                a((Throwable) ZeusTransformUtils.preCheckCast(r3, Throwable.class, "com.obric.memorydata.plugin"));
                return Unit.INSTANCE;
            }
        }

        /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.automemory.settings.MemoryTaskSettingsViewModel$runAlgoTask$2$b */
        @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/obric/memorydata/memory/ui/automemory/settings/MemoryTaskSettingsViewModel$runAlgoTask$2$1$req$1", "Lcom/obric/memorydata/task/scheduler/OnTaskInfoCallBack;", "onChanged", "", "taskInfo", "Lcom/obric/memorydata/task/impl/TaskInfo;", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class b implements com.obric.memorydata.task.scheduler.c {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ AtomicBoolean f10740a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ n<JSONObject> f10741b;
            final /* synthetic */ String c;

            /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.automemory.settings.MemoryTaskSettingsViewModel$runAlgoTask$2$b$a */
            @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
            public /* synthetic */ class a {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public static final /* synthetic */ int[] f10742a = null;

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
                    f10742a = r0;
                }
            }

            b(AtomicBoolean r3, n<? super JSONObject> r4, String r5) {
                n<JSONObject> r6 = (n) ZeusTransformUtils.wrapperContextForParams(r4, n.class, "com.obric.memorydata.plugin");
                this.f10740a = r3;
                this.f10741b = r6;
                this.c = r5;
            }

            @Override // com.obric.memorydata.task.scheduler.c
            public void a(TaskInfo r6) {
                Intrinsics.checkNotNullParameter(r6, "taskInfo");
                int r0 = a.f10742a[r6.c().ordinal()];
                if (r0 == 1) goto L17;
                if (r0 == 2) goto L12;
                if (r0 == 3) goto L12;
                if (r0 == 4) goto L12;
                return;
            L12:
                if (this.f10740a.compareAndSet(false, true) == true) goto L14;
                return;
            L14:
                if (this.f10741b.a() == false) goto L29;
                Continuation r1 = (Continuation) ZeusTransformUtils.preCheckCast(this.f10741b, Continuation.class, "com.obric.memorydata.plugin");
                Result.Companion r2 = Result.Companion;
                r1.resumeWith(Result.m1421constructorimpl(ResultKt.createFailure((Throwable) ZeusTransformUtils.preCheckCast(new RuntimeException("task " + this.c + ' ' + r6.c()), Throwable.class, "com.obric.memorydata.plugin"))));
                return;
            L29:
                return;
            L17:
                if (this.f10740a.compareAndSet(false, true) == true) goto L19;
                return;
            L19:
                if (this.f10741b.a() == false) goto L32;
                JSONObject r3 = new JSONObject(r6.d().toString());
                if (r3.has("code") == true) goto L24;
                r3.put("code", r6.e().getCode());
            L24:
                if (r3.has(NotificationCompat.CATEGORY_MESSAGE) == true) goto L26;
                r3.put(NotificationCompat.CATEGORY_MESSAGE, r6.e().getMsg());
            L26:
                Continuation r5 = (Continuation) ZeusTransformUtils.preCheckCast(this.f10741b, Continuation.class, "com.obric.memorydata.plugin");
                Result.Companion r7 = Result.Companion;
                r5.resumeWith(Result.m1421constructorimpl(r3));
                return;
            }
        }

        C11392(String r3, JSONObject r4, Continuation<? super C11392> r5) {
            Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
            this.$name = r3;
            this.$input = r4;
            super(2, r6);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new C11392(this.$name, this.$input, r5), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(al r3, Continuation<? super JSONObject> r4) {
            return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(al r3, Continuation<? super JSONObject> r4) {
            return ((C11392) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), C11392.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
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
            TaskRequest r15 = (TaskRequest) ZeusTransformUtils.preCheckCast(((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(new TaskRequest.Builder(r14).setInputParam(r3), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).setTimeout(new com.obric.memorydata.task.impl.g(MemoryTaskSettingsViewModel.TASK_TIMEOUT_SEC, TimeUnit.SECONDS)), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).setConditions(new Condition[]{Condition.NETWORK_AVAILABLE, Condition.SCREEN_ON_OR_CHARGE}), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).setExistingTaskPolicy(ExistingTaskPolicy.KEEP_IN_QUEUE), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).setTaskInfoCallback((com.obric.memorydata.task.scheduler.c) ZeusTransformUtils.preCheckCast(new b(r6, r4, r14), com.obric.memorydata.task.scheduler.c.class, "com.obric.memorydata.plugin")), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).build(), TaskRequest.class, "com.obric.memorydata.plugin");
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

    /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.automemory.settings.MemoryTaskSettingsViewModel$runIconGenerator$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.memory.ui.automemory.settings.MemoryTaskSettingsViewModel", f = "MemoryTaskSettingsActivity.kt", i = {}, l = {1128}, m = "runIconGenerator", n = {}, s = {})
    static final class C11401 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ MemoryTaskSettingsViewModel this$0;

        C11401(MemoryTaskSettingsViewModel r3, Continuation<? super C11401> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            super(r5);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r3) {
            this.result = r3;
            this.label |= Integer.MIN_VALUE;
            return MemoryTaskSettingsViewModel.access$runIconGenerator(this.this$0, null, (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin"));
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.automemory.settings.MemoryTaskSettingsViewModel$runRuleCheck$2, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.memory.ui.automemory.settings.MemoryTaskSettingsViewModel$runRuleCheck$2", f = "MemoryTaskSettingsActivity.kt", i = {}, l = {1336}, m = "invokeSuspend", n = {}, s = {})
    static final class C11412 extends SuspendLambda implements Function2<al, Continuation<? super Boolean>, Object> {
        final /* synthetic */ String $content;
        Object L$0;
        int label;

        /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.automemory.settings.MemoryTaskSettingsViewModel$runRuleCheck$2$a */
        @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
        static final class a implements Function1<Throwable, Unit> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ TaskRequest f10743a;

            a(TaskRequest r1) {
                this.f10743a = r1;
            }

            public final void a(Throwable r1) {
                this.f10743a.cancel();
            }

            @Override // kotlin.jvm.functions.Function1
            public /* synthetic */ Unit invoke(Throwable r3) {
                a((Throwable) ZeusTransformUtils.preCheckCast(r3, Throwable.class, "com.obric.memorydata.plugin"));
                return Unit.INSTANCE;
            }
        }

        /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.automemory.settings.MemoryTaskSettingsViewModel$runRuleCheck$2$b */
        @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/obric/memorydata/memory/ui/automemory/settings/MemoryTaskSettingsViewModel$runRuleCheck$2$1$req$2", "Lcom/obric/memorydata/task/scheduler/OnTaskInfoCallBack;", "onChanged", "", "taskInfo", "Lcom/obric/memorydata/task/impl/TaskInfo;", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class b implements com.obric.memorydata.task.scheduler.c {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ AtomicBoolean f10744a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ n<Boolean> f10745b;

            /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.automemory.settings.MemoryTaskSettingsViewModel$runRuleCheck$2$b$a */
            @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
            public /* synthetic */ class a {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public static final /* synthetic */ int[] f10746a = null;

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
                    f10746a = r0;
                }
            }

            b(AtomicBoolean r3, n<? super Boolean> r4) {
                n<Boolean> r5 = (n) ZeusTransformUtils.wrapperContextForParams(r4, n.class, "com.obric.memorydata.plugin");
                this.f10744a = r3;
                this.f10745b = r5;
            }

            @Override // com.obric.memorydata.task.scheduler.c
            public void a(TaskInfo r11) {
                Intrinsics.checkNotNullParameter(r11, "taskInfo");
                int r0 = a.f10746a[r11.c().ordinal()];
                boolean r2 = true;
                if (r0 == 1) goto L18;
                if (r0 == 2) goto L12;
                if (r0 == 3) goto L12;
                if (r0 == 4) goto L12;
                return;
            L12:
                if (this.f10744a.compareAndSet(false, true) == true) goto L14;
                return;
            L14:
                if (this.f10745b.a() == false) goto L28;
                IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), MemoryTaskSettingsViewModel.TAG, "title rule_check " + r11.c(), null, 4, null);
                Continuation r10 = (Continuation) ZeusTransformUtils.preCheckCast(this.f10745b, Continuation.class, "com.obric.memorydata.plugin");
                Result.Companion r12 = Result.Companion;
                boolean r13 = false;
            L16:
                r10.resumeWith(Result.m1421constructorimpl(r13));
                return;
            L28:
                return;
            L18:
                if (this.f10744a.compareAndSet(false, true) == true) goto L20;
                return;
            L20:
                if (this.f10745b.a() == false) goto L31;
                JSONObject r14 = r11.e().getOutput();
                int r1 = r14.optInt("code", -1);
                boolean r4 = r14.optBoolean("result", false);
                RunLog.INSTANCE.debug(MemoryTaskSettingsViewModel.TAG, "title rule_check output: " + r14);
                r10 = (Continuation) ZeusTransformUtils.preCheckCast(this.f10745b, Continuation.class, "com.obric.memorydata.plugin");
                Result.Companion r15 = Result.Companion;
                if (r1 != 0) goto L25;
                if (r4 == false) goto L25;
            L26:
                r13 = Boolean.valueOf(r2);
            L25:
                r2 = false;
                goto L26
            }
        }

        C11412(String r3, Continuation<? super C11412> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.$content = r3;
            super(2, r5);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            Continuation r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new C11412(this.$content, r4), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(al r3, Continuation<? super Boolean> r4) {
            return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(al r3, Continuation<? super Boolean> r4) {
            return ((C11412) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), C11412.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r10) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            String r9 = (String) ZeusTransformUtils.preCheckCast(this.L$0, String.class, "com.obric.memorydata.plugin");
            ResultKt.throwOnFailure(r10);
        L13:
            return r10;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r10);
            String r11 = this.$content;
            this.L$0 = r11;
            this.label = 1;
            o r4 = new o(IntrinsicsKt.intercepted((Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin")), 1);
            r4.e();
            n r2 = (n) ZeusTransformUtils.preCheckCast(r4, n.class, "com.obric.memorydata.plugin");
            AtomicBoolean r5 = new AtomicBoolean(false);
            TaskRequest.Builder r6 = new TaskRequest.Builder("auto_memory_pro_rule_check");
            JSONObject r7 = new JSONObject();
            r7.put(Params.CONTENT, r11);
            TaskRequest r12 = (TaskRequest) ZeusTransformUtils.preCheckCast(((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(r6.setInputParam(r7), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).setExecuteImmediately(true), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).setTimeout(new com.obric.memorydata.task.impl.g(MemoryTaskSettingsViewModel.TASK_TIMEOUT_SEC, TimeUnit.SECONDS)), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).setTaskInfoCallback((com.obric.memorydata.task.scheduler.c) ZeusTransformUtils.preCheckCast(new b(r5, r2), com.obric.memorydata.task.scheduler.c.class, "com.obric.memorydata.plugin")), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).build(), TaskRequest.class, "com.obric.memorydata.plugin");
            r2.a((Function1) ZeusTransformUtils.preCheckCast(new a(r12), Function1.class, "com.obric.memorydata.plugin"));
            r12.enqueue();
            r10 = r4.h();
            if (r10 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L11;
            DebugProbesKt.probeCoroutineSuspended((Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin"));
        L11:
            if (r10 != r0) goto L13;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.automemory.settings.MemoryTaskSettingsViewModel$startIconGeneration$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/obric/memorydata/memory/ui/automemory/settings/IconInfo;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.memory.ui.automemory.settings.MemoryTaskSettingsViewModel$startIconGeneration$1", f = "MemoryTaskSettingsActivity.kt", i = {}, l = {1097}, m = "invokeSuspend", n = {}, s = {})
    static final class C11421 extends SuspendLambda implements Function2<al, Continuation<? super c>, Object> {
        final /* synthetic */ b $draft;
        int label;
        final /* synthetic */ MemoryTaskSettingsViewModel this$0;

        C11421(b r3, MemoryTaskSettingsViewModel r4, Continuation<? super C11421> r5) {
            Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
            this.$draft = r3;
            this.this$0 = r4;
            super(2, r6);
        }

        private static final b invokeSuspend$lambda$0(b r23, c r24, b r25) {
            if (r25.a() == null) goto L5;
        L8:
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), MemoryTaskSettingsViewModel.TAG, "icon generation task discard stale result", false, 4, null);
            return r25;
        L5:
            if (Intrinsics.areEqual(r25.d(), r23.d()) == false) goto L8;
            return b.a(r25, null, null, null, null, null, null, false, null, null, null, false, false, r24.a(), r24.b(), r24.c(), 0, 0, null, false, 495615, null);
        }

        public static /* synthetic */ b lambda$Xey5zI8TFLUTaBws71pT7zucuZ8(b r0, c r1, b r2) {
            return invokeSuspend$lambda$0(r0, r1, r2);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new C11421(this.$draft, this.this$0, r5), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(al r3, Continuation<? super c> r4) {
            return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(al r3, Continuation<? super c> r4) {
            return ((C11421) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), C11421.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r12) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            boolean r2 = false;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r12);
        L15:
            final c r13 = (c) ZeusTransformUtils.preCheckCast(r12, c.class, "com.obric.memorydata.plugin");
            if (r13 != null) goto L18;
        L22:
            if (r13 != null) goto L24;
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), MemoryTaskSettingsViewModel.TAG, "icon generation task finish failed", false, 4, null);
        L24:
            return r13;
        L18:
            if (((CharSequence) ZeusTransformUtils.preCheckCast(MemoryTaskSettingsViewModel.access$getSessionId$p(this.this$0), CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L20;
            r2 = true;
        L20:
            if (r2 == false) goto L22;
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), MemoryTaskSettingsViewModel.TAG, "icon generation task update draft", false, 4, null);
            g r3 = g.f10759a;
            String r4 = MemoryTaskSettingsViewModel.access$getSessionId$p(this.this$0);
            final b r11 = this.$draft;
            r3.update(r4, new $$Lambda$MemoryTaskSettingsViewModel$startIconGeneration$1$Xey5zI8TFLUTaBws71pT7zucuZ8(r11, r13));
            goto L22
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r12);
            IRunLog r5 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
            StringBuilder r14 = new StringBuilder().append("icon generation task launch hasContent=").append(!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(this.$draft.d(), CharSequence.class, "com.obric.memorydata.plugin"))).append(" isEdit=");
            if (this.$draft.a() == null) goto L11;
            boolean r6 = true;
        L12:
            IRunLog.a.a(r5, MemoryTaskSettingsViewModel.TAG, r14.append(r6).toString(), false, 4, null);
            MemoryTaskSettingsViewModel r15 = this.this$0;
            String r7 = this.$draft.d();
            Continuation r8 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 1;
            r12 = MemoryTaskSettingsViewModel.access$runIconGenerator(r15, r7, r8);
            if (r12 != r0) goto L15;
            return r0;
        L11:
            r6 = false;
            goto L12
        }
    }

    static {
        Companion = new a(null);
    }

    public MemoryTaskSettingsViewModel() {
        ae<i> r0 = at.a(new i(null, false, 3, null));
        this._state = r0;
        this.state = k.a(r0);
        this.sessionId = "";
    }

    public static final /* synthetic */ Object access$auditTitleIfChanged(MemoryTaskSettingsViewModel r2, b r3, Continuation r4) {
        return r2.auditTitleIfChanged(r3, (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    public static final /* synthetic */ void access$commitDraft(MemoryTaskSettingsViewModel r0, b r1) {
        r0.commitDraft(r1);
    }

    public static final /* synthetic */ Object access$ensureIconReadyBeforeCommit(MemoryTaskSettingsViewModel r2, b r3, Continuation r4) {
        return r2.ensureIconReadyBeforeCommit(r3, (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    public static final /* synthetic */ Object access$generateMemoryInfo(MemoryTaskSettingsViewModel r2, String r3, Continuation r4) {
        return r2.generateMemoryInfo(r3, (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    public static final /* synthetic */ String access$getSessionId$p(MemoryTaskSettingsViewModel r0) {
        return r0.sessionId;
    }

    public static final /* synthetic */ ae access$get_state$p(MemoryTaskSettingsViewModel r0) {
        return r0._state;
    }

    public static final /* synthetic */ boolean access$isClientModelLimitReached(MemoryTaskSettingsViewModel r0, b r1) {
        return r0.isClientModelLimitReached(r1);
    }

    public static final /* synthetic */ boolean access$parseAuditPassed(MemoryTaskSettingsViewModel r0, JSONObject r1) {
        return r0.parseAuditPassed(r1);
    }

    public static final /* synthetic */ Object access$runAlgoTask(MemoryTaskSettingsViewModel r2, String r3, JSONObject r4, Continuation r5) {
        return r2.runAlgoTask(r3, r4, (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin"));
    }

    public static final /* synthetic */ Object access$runIconGenerator(MemoryTaskSettingsViewModel r2, String r3, Continuation r4) {
        return r2.runIconGenerator(r3, (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    public static final /* synthetic */ Object access$runRuleCheck(MemoryTaskSettingsViewModel r2, String r3, Continuation r4) {
        return r2.runRuleCheck(r3, (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    public static final /* synthetic */ void access$setCommitted$p(MemoryTaskSettingsViewModel r0, boolean r1) {
        r0.committed = r1;
    }

    public static final /* synthetic */ void access$startIconGenerationIfNeeded(MemoryTaskSettingsViewModel r0, b r1) {
        r0.startIconGenerationIfNeeded(r1);
    }

    public static final /* synthetic */ void access$trackRuleEdit(MemoryTaskSettingsViewModel r0, b r1) {
        r0.trackRuleEdit(r1);
    }

    private final Object auditTitleIfChanged(b r6, Continuation<? super Boolean> r7) {
        Continuation r8 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r7, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r8, AnonymousClass1.class) == false) goto L7;
        AnonymousClass1 r0 = (AnonymousClass1) ZeusTransformUtils.preCheckCast(r8, AnonymousClass1.class, "com.obric.memorydata.plugin");
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r9 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L17;
        if (r3 != 1) goto L16;
        ResultKt.throwOnFailure(r9);     // Catch: Throwable -> L13
    L25:
        Object r5 = Result.m1421constructorimpl(Boxing.boxBoolean(((Boolean) ZeusTransformUtils.preCheckCast(r9, Boolean.class, "com.obric.memorydata.plugin")).booleanValue()));     // Catch: Throwable -> L13
    L28:
        Throwable r10 = Result.m1424exceptionOrNullimpl(r5);
        if (r10 == null) goto L37;
        RunLog.INSTANCE.warn(TAG, "title rule check failed", r10);
        return Boxing.boxBoolean(false);
    L37:
        return r5;
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        ResultKt.throwOnFailure(r9);
        String r11 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r6.b(), CharSequence.class, "com.obric.memorydata.plugin")).toString();
        String r12 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r6.c(), CharSequence.class, "com.obric.memorydata.plugin")).toString();
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r11, CharSequence.class, "com.obric.memorydata.plugin")) == true) goto L34;
        if (Intrinsics.areEqual(r11, r12) == true) goto L34;
        Result.Companion r13 = Result.Companion;     // Catch: Throwable -> L13
        MemoryTaskSettingsViewModel r14 = (MemoryTaskSettingsViewModel) ZeusTransformUtils.preCheckCast(this, MemoryTaskSettingsViewModel.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L13
        r0.label = 1;     // Catch: Throwable -> L13
        r9 = r14.runRuleCheck(r11, r0);     // Catch: Throwable -> L13
        if (r9 != r2) goto L25;
        return r2;
    L34:
        return Boxing.boxBoolean(true);
    L13:
        th = move-exception;
        Result.Companion r15 = Result.Companion;
        r5 = Result.m1421constructorimpl(ResultKt.createFailure(th));
    L7:
        r0 = new AnonymousClass1(this, r8);
        goto L8
    }

    private final void commitDraft(b r48) {
        MemoryRuleDao r0 = MemoryDbEngine.INSTANCE.getPersonalDbEngine().getMemoryRuleDao();
        String r13 = r48.r().h().toString();
        Intrinsics.checkNotNullExpressionValue(r13, "toString(...)");
        if (r48.a() != null) goto L7;
        MemoryRuleEntity r1 = (MemoryRuleEntity) ZeusTransformUtils.preCheckCast(r0.queryById(r0.insertMyCollection(r48.b(), r48.d(), r48.f(), r48.h(), r48.g(), r48.m(), r48.n(), r48.o(), r48.s(), true, 1)), MemoryRuleEntity.class, "com.obric.memorydata.plugin");
        if (r1 == null) goto L15;
        r1.setMemoryInfoJson(r13);
        r1.setTriggerMode(r48.i());
        r1.setCronExpression(r48.j());
        r1.setPaused(r48.k());
        r1.setAutoCaptureEnabled(r48.l());
        r1.setActiveStartMinute(r48.p());
        r1.setActiveEndMinute(r48.q());
        r1.setCanDisplay(true);
        r1.setRuleSettingsVersion(1);
        r0.update(r1);
        com.obric.memorydata.memory.ui.automemory.requirement.b.f10717a.a(r1);
    L15:
        ((TaskRequest) ZeusTransformUtils.preCheckCast(((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(new TaskRequest.Builder("auto_memory_pro_rule_generator").setConditions(new Condition[]{Condition.NETWORK_AVAILABLE, Condition.SCREEN_ON_OR_CHARGE}), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).setExistingTaskPolicy(ExistingTaskPolicy.KEEP_IN_QUEUE), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).build(), TaskRequest.class, "com.obric.memorydata.plugin")).enqueue();
        return;
    L7:
        MemoryRuleEntity r2 = (MemoryRuleEntity) ZeusTransformUtils.preCheckCast(r0.queryById(r48.a().longValue()), MemoryRuleEntity.class, "com.obric.memorydata.plugin");
        if (r2 == null) goto L15;
        MemoryRuleEntity r3 = MemoryRuleEntity.copy$default(r2, 0, r48.b(), r48.d(), r48.f(), null, null, null, null, r48.g(), 0, null, null, null, null, false, false, false, false, 0, 0, 0, null, null, null, 0, 33554161, null);
        if (Intrinsics.areEqual(r2.getMemoryInfoJson(), r13) == true) goto L12;
    L13:
        r3.setClientModelQuery("");
        r3.setClientModelVersion("");
    L14:
        r3.setMemoryInfoJson(r13);
        r3.setTriggerMode(r48.i());
        r3.setCronExpression(r48.j());
        r3.setPaused(r48.k());
        r3.setAutoCaptureEnabled(r48.l());
        r3.setActiveStartMinute(r48.p());
        r3.setActiveEndMinute(r48.q());
        r3.setFromPreset(r48.s());
        r3.setCanDisplay(true);
        r3.setRuleSettingsVersion(1);
        r0.update(r3);
        com.obric.memorydata.memory.ui.automemory.requirement.b.f10717a.a(r3);
        goto L15
    L12:
        if (Intrinsics.areEqual(r2.getContent(), r48.d()) == true) goto L14;
        goto L13
    }

    private static final Unit confirmCreate$lambda$4(Function0 r2) {
        ((Function0) ZeusTransformUtils.wrapperContextForParams(r2, Function0.class, "com.obric.memorydata.plugin")).invoke();
        return Unit.INSTANCE;
    }

    private final Object ensureIconReadyBeforeCommit(b r18, Continuation<? super b> r19) {
        MemoryTaskSettingsViewModel r0 = this;
        Continuation r1 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r19, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r1, C11371.class) == false) goto L7;
        C11371 r3 = (C11371) ZeusTransformUtils.preCheckCast(r1, C11371.class, "com.obric.memorydata.plugin");
        if ((r3.label & Integer.MIN_VALUE) == 0) goto L7;
        r3.label -= Integer.MIN_VALUE;
    L8:
        Object r2 = r3.result;
        Object r4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r5 = r3.label;
        if (r5 == 0) goto L14;
        if (r5 != 1) goto L13;
        b r6 = (b) ZeusTransformUtils.preCheckCast(r3.L$1, b.class, "com.obric.memorydata.plugin");
        MemoryTaskSettingsViewModel r7 = (MemoryTaskSettingsViewModel) ZeusTransformUtils.preCheckCast(r3.L$0, MemoryTaskSettingsViewModel.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r2);
        b r8 = r6;
        r0 = r7;
        Object r9 = r2;
    L35:
        final c r10 = (c) ZeusTransformUtils.preCheckCast(r9, c.class, "com.obric.memorydata.plugin");
        if (r10 != null) goto L39;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "icon generation commit result failed", false, 4, null);
        return null;
    L39:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "icon generation commit result success", false, 4, null);
        g.f10759a.update(r0.sessionId, new $$Lambda$MemoryTaskSettingsViewModel$uEzq1UNrUJMvyaNIjoOX9aDzKE(r10));
        b r11 = g.f10759a.b(r0.sessionId);
        if (r11 == null) goto L44;
        r8 = r11;
    L44:
        return r0.normalizePreparedIconVersion(r8);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r2);
        r8 = g.f10759a.b(r0.sessionId);
        if (r8 != null) goto L18;
        r8 = r18;
    L18:
        if (r0.shouldGenerateIcon(r8) == true) goto L21;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "icon generation commit skip needGenerate=false", false, 4, null);
        return r0.normalizePreparedIconVersion(r8);
    L21:
        ar<c> r12 = r0.iconGenerateDeferred;
        if (r12 != null) goto L24;
    L26:
        r12 = null;
    L27:
        if (r12 != null) goto L29;
        ar<c> r13 = r0.startIconGeneration(r8);
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "icon generation commit start new task", false, 4, null);
        r0.iconGenerateDeferred = r13;
    L30:
        if (r12 == null) goto L32;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "icon generation commit wait running task", false, 4, null);
    L32:
        r3.L$0 = r0;
        r3.L$1 = r8;
        r3.label = 1;
        r9 = r13.a(r3);
        if (r9 != r4) goto L35;
        return r4;
    L29:
        r13 = r12;
        goto L30
    L24:
        if (r12.a() == false) goto L26;
    L7:
        r3 = new C11371(r0, r1);
        goto L8
    }

    private static final b ensureIconReadyBeforeCommit$lambda$14(c r23, b r24) {
        Intrinsics.checkNotNullParameter(r24, "current");
        if (r24.a() == null) goto L6;
        return r24;
    L6:
        return b.a(r24, null, null, null, null, null, null, false, null, null, null, false, false, r23.a(), r23.b(), r23.c(), 0, 0, null, false, 495615, null);
    }

    private final Object generateMemoryInfo(String r18, Continuation<? super Unit> r19) {
        MemoryTaskSettingsViewModel r1 = this;
        Continuation r2 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r19, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r2, C11381.class) == false) goto L7;
        C11381 r4 = (C11381) ZeusTransformUtils.preCheckCast(r2, C11381.class, "com.obric.memorydata.plugin");
        if ((r4.label & Integer.MIN_VALUE) == 0) goto L7;
        r4.label -= Integer.MIN_VALUE;
    L8:
        Object r3 = r4.result;
        Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r6 = r4.label;
        boolean r7 = true;
        if (r6 == 0) goto L16;
        if (r6 != 1) goto L15;
        r1 = (MemoryTaskSettingsViewModel) ZeusTransformUtils.preCheckCast(r4.L$0, MemoryTaskSettingsViewModel.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r3);     // Catch: Throwable -> L22
    L20:
        Object r0 = Result.m1421constructorimpl((JSONObject) ZeusTransformUtils.preCheckCast(r3, JSONObject.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L22
    L24:
        Throwable r8 = Result.m1424exceptionOrNullimpl(r0);
        if (r8 != null) goto L39;
        JSONObject r9 = (JSONObject) ZeusTransformUtils.preCheckCast(r0, JSONObject.class, "com.obric.memorydata.plugin");
        int r10 = r9.optInt("code", -1);
        if (r10 == 0) goto L31;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "memory info generator non-zero code=" + r10 + ", msg=" + r9.optString(NotificationCompat.CATEGORY_MESSAGE), null, 4, null);
    L30:
        return Unit.INSTANCE;
    L31:
        String r11 = r9.optString("title");
        Intrinsics.checkNotNullExpressionValue(r11, "optString(...)");
        String r12 = e.f10753a.a(r9, MemoryInfoSectionEditActivity.KIND_SCENE);
        e.b r13 = e.b.f10755a.a(r9.optJSONObject("info"));
        String r14 = r9.optString("custom_rule");
        Intrinsics.checkNotNullExpressionValue(r14, "optString(...)");
        String r15 = r9.optString(MemoryInfoSectionEditActivity.KIND_UPDATE_RULE);
        Intrinsics.checkNotNullExpressionValue(r15, "optString(...)");
        String r16 = r9.optString("title_format");
        Intrinsics.checkNotNullExpressionValue(r16, "optString(...)");
        String r17 = r9.optString("subtitle_format");
        Intrinsics.checkNotNullExpressionValue(r17, "optString(...)");
        String r20 = r9.optString("content_format");
        Intrinsics.checkNotNullExpressionValue(r20, "optString(...)");
        final e r21 = new e(r11, r12, r13, r14, r15, r16, r17, r20);
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r1.sessionId, CharSequence.class, "com.obric.memorydata.plugin")).length() == 0) goto L35;
        r7 = false;
    L35:
        if (r7 == true) goto L37;
        g.f10759a.update(r1.sessionId, new $$Lambda$MemoryTaskSettingsViewModel$52dW4TFqMvQLlrpK5KvHmBh5brs(r21));
        goto L30
    L37:
        return Unit.INSTANCE;
    L39:
        RunLog.INSTANCE.warn(TAG, "memory info generator failed", r8);
        goto L30
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        ResultKt.throwOnFailure(r3);
        JSONObject r22 = new JSONObject();
        r22.put(ChatMessage.TYPE_QUERY, r18);
        Result.Companion r23 = Result.Companion;     // Catch: Throwable -> L22
        MemoryTaskSettingsViewModel r24 = (MemoryTaskSettingsViewModel) ZeusTransformUtils.preCheckCast(r1, MemoryTaskSettingsViewModel.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L22
        r4.L$0 = r1;     // Catch: Throwable -> L22
        r4.label = 1;     // Catch: Throwable -> L22
        r3 = r24.runAlgoTask("auto_memory_pro_memory_info_generator", r22, r4);     // Catch: Throwable -> L22
        if (r3 != r5) goto L20;
        return r5;
    L22:
        th = move-exception;
        Result.Companion r25 = Result.Companion;
        r0 = Result.m1421constructorimpl(ResultKt.createFailure(th));
    L7:
        r4 = new C11381(r1, r2);
        goto L8
    }

    private static final b generateMemoryInfo$lambda$22(e r23, b r24) {
        Intrinsics.checkNotNullParameter(r24, "it");
        String r6 = r23.h().toString();
        Intrinsics.checkNotNullExpressionValue(r6, "toString(...)");
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r24.b(), CharSequence.class, "com.obric.memorydata.plugin")) == true) goto L5;
    L7:
        String r0 = r24.b();
    L9:
        return b.a(r24, null, r0, null, null, r6, null, false, null, null, null, false, false, null, null, null, 0, 0, r23, false, 393197, null);
    L5:
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r23.a(), CharSequence.class, "com.obric.memorydata.plugin"))) == false) goto L7;
        r0 = r23.a();
        goto L9
    }

    private final boolean isClientModelLimitReached(b r3) {
        Long r2 = r3.a();
        if (r2 == null) goto L5;
        long r0 = r2.longValue();
    L6:
        int r4 = MemoryDbEngine.INSTANCE.getPersonalDbEngine().getMemoryRuleDao().countClientModelRules(r0);
        return v.f10768a.a(r3.g(), r4);
    L5:
        r0 = 0;
        goto L6
    }

    public static /* synthetic */ b lambda$52dW4TFqMvQLlrpK5KvHmBh5brs(e r0, b r1) {
        return generateMemoryInfo$lambda$22(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$7GezupRqGdJ27Y06PK0-tIsiuzY, reason: not valid java name */
    public static /* synthetic */ b m832lambda$7GezupRqGdJ27Y06PK0tIsiuzY(b r0) {
        return normalizePreparedIconVersion$lambda$15(r0);
    }

    /* JADX INFO: renamed from: lambda$8OJs7q-BSLFpDwNg7VfAVXOu4SY, reason: not valid java name */
    public static /* synthetic */ b m833lambda$8OJs7qBSLFpDwNg7VfAVXOu4SY(boolean r0, b r1) {
        return updateUseClientModel$lambda$1(r0, r1);
    }

    public static /* synthetic */ b lambda$I_TPizEM4e4qVZjxYFprfY4shis(String r0, b r1) {
        return updateSubtitleFormat$lambda$3(r0, r1);
    }

    public static /* synthetic */ Unit lambda$PL32L8QoNbHQR98vcI3OyDPhIlw(Function0 r0) {
        return confirmCreate$lambda$4(r0);
    }

    public static /* synthetic */ b lambda$peKqEI1ZwcNXRkYdF5eIU3YAJ2Q(String r0, b r1) {
        return updateTitleFormat$lambda$2(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$uEzq1U-NrUJMvyaNIjoOX9aDzKE, reason: not valid java name */
    public static /* synthetic */ b m834lambda$uEzq1UNrUJMvyaNIjoOX9aDzKE(c r0, b r1) {
        return ensureIconReadyBeforeCommit$lambda$14(r0, r1);
    }

    public static /* synthetic */ b lambda$xtjHhOwWg1zLJSzrANmoAzYQP4w(String r0, b r1) {
        return updateTitle$lambda$0(r0, r1);
    }

    private final b normalizePreparedIconVersion(b r24) {
        if (r24.a() == null) goto L5;
    L17:
        return r24;
    L5:
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r24.m(), CharSequence.class, "com.obric.memorydata.plugin")) == true) goto L17;
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r24.n(), CharSequence.class, "com.obric.memorydata.plugin")) == true) goto L17;
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r24.o(), CharSequence.class, "com.obric.memorydata.plugin"))) == false) goto L12;
        return r24;
    L12:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "icon generation fill preset version", false, 4, null);
        b r1 = b.a(r24, null, null, null, null, null, null, false, null, null, null, false, false, null, null, BuildConfig.VERSION_NAME, 0, 0, null, false, 507903, null);
        g.f10759a.update(this.sessionId, $$Lambda$MemoryTaskSettingsViewModel$7GezupRqGdJ27Y06PK0tIsiuzY.INSTANCE);
        b r0 = g.f10759a.b(this.sessionId);
        if (r0 != null) goto L16;
        return r1;
    L16:
        return r0;
    }

    private static final b normalizePreparedIconVersion$lambda$15(b r22) {
        Intrinsics.checkNotNullParameter(r22, "current");
        return b.a(r22, null, null, null, null, null, null, false, null, null, null, false, false, null, null, BuildConfig.VERSION_NAME, 0, 0, null, false, 507903, null);
    }

    private final boolean parseAuditPassed(JSONObject r3) {
        if (r3.optInt("code", 1) != 0) goto L8;
        if (r3.optBoolean("result", false) == false) goto L8;
        return true;
    L8:
        return false;
    }

    private final Object runAlgoTask(String r3, JSONObject r4, Continuation<? super JSONObject> r5) {
        Continuation r2 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
        return da.a(17000, (Function2) ZeusTransformUtils.preCheckCast(new C11392(r3, r4, null), Function2.class, "com.obric.memorydata.plugin"), r2);
    }

    private final Object runIconGenerator(String r12, Continuation<? super c> r13) {
        Continuation r14 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r13, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r14, C11401.class) == false) goto L7;
        C11401 r0 = (C11401) ZeusTransformUtils.preCheckCast(r14, C11401.class, "com.obric.memorydata.plugin");
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r15 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L17;
        if (r3 != 1) goto L16;
        ResultKt.throwOnFailure(r15);     // Catch: Throwable -> L13
    L21:
        Object r11 = Result.m1421constructorimpl((JSONObject) ZeusTransformUtils.preCheckCast(r15, JSONObject.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L13
    L24:
        Throwable r16 = Result.m1424exceptionOrNullimpl(r11);
        if (r16 != null) goto L41;
        JSONObject r17 = (JSONObject) ZeusTransformUtils.preCheckCast(r11, JSONObject.class, "com.obric.memorydata.plugin");
        int r18 = r17.optInt("code", -1);
        if (r18 == 0) goto L30;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "memory rule icon generator non-zero code=" + r18 + ", msg=" + r17.optString(NotificationCompat.CATEGORY_MESSAGE), null, 4, null);
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "memory rule icon generator request failed reason=non_zero code=" + r18, false, 4, null);
        return null;
    L30:
        String r19 = r17.optString("iconKey");
        String r1 = r17.optString("iconColorKey");
        String r110 = r17.optString("iconGenerateVersion");
        Intrinsics.checkNotNull(r19);
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r19, CharSequence.class, "com.obric.memorydata.plugin")) == true) goto L39;
        Intrinsics.checkNotNull(r1);
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r1, CharSequence.class, "com.obric.memorydata.plugin")) == true) goto L39;
        Intrinsics.checkNotNull(r110);
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r110, CharSequence.class, "com.obric.memorydata.plugin")) == true) goto L39;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "memory rule icon generator request success version=" + r110 + " hasIcon=true hasColor=true", false, 4, null);
        return new c(r19, r1, r110);
    L39:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "memory rule icon generator invalid payload", null, 4, null);
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "memory rule icon generator request failed reason=invalid_payload", false, 4, null);
        return null;
    L41:
        RunLog.INSTANCE.warn(TAG, "memory rule icon generator failed", r16);
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "memory rule icon generator request failed reason=exception", false, 4, null);
        return null;
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        ResultKt.throwOnFailure(r15);
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "memory rule icon generator request start hasContent=" + (!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r12, CharSequence.class, "com.obric.memorydata.plugin"))), false, 4, null);
        JSONObject r111 = new JSONObject();
        r111.put(Params.CONTENT, r12);
        Result.Companion r112 = Result.Companion;     // Catch: Throwable -> L13
        MemoryTaskSettingsViewModel r113 = (MemoryTaskSettingsViewModel) ZeusTransformUtils.preCheckCast(this, MemoryTaskSettingsViewModel.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L13
        r0.label = 1;     // Catch: Throwable -> L13
        r15 = r113.runAlgoTask("memory_rule_icon_generator", r111, r0);     // Catch: Throwable -> L13
        if (r15 != r2) goto L21;
        return r2;
    L13:
        th = move-exception;
        Result.Companion r114 = Result.Companion;
        r11 = Result.m1421constructorimpl(ResultKt.createFailure(th));
    L7:
        r0 = new C11401(this, r14);
        goto L8
    }

    private final Object runRuleCheck(String r3, Continuation<? super Boolean> r4) {
        Continuation r2 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        return da.a(17000, (Function2) ZeusTransformUtils.preCheckCast(new C11412(r3, null), Function2.class, "com.obric.memorydata.plugin"), r2);
    }

    private final boolean shouldGenerateIcon(b r3) {
        if (r3.a() == null) goto L5;
    L9:
        return false;
    L5:
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r3.m(), CharSequence.class, "com.obric.memorydata.plugin")) == false) goto L7;
    L8:
        return true;
    L7:
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r3.n(), CharSequence.class, "com.obric.memorydata.plugin")) == false) goto L9;
        goto L8
    }

    private final ar<c> startIconGeneration(b r9) {
        return kotlinx.coroutines.i.b(ViewModelKt.getViewModelScope((ViewModel) ZeusTransformUtils.preCheckCast(this, ViewModel.class, "com.obric.memorydata.plugin")), (CoroutineContext) ZeusTransformUtils.preCheckCast(ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin"), null, (Function2) ZeusTransformUtils.preCheckCast(new C11421(r9, this, null), Function2.class, "com.obric.memorydata.plugin"), 2, null);
    }

    private final void startIconGenerationIfNeeded(b r8) {
        if (shouldGenerateIcon(r8) == true) goto L5;
        return;
    L5:
        ar<c> r0 = this.iconGenerateDeferred;
        if (r0 != null) goto L8;
    L13:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "icon generation preload start", false, 4, null);
        this.iconGenerateDeferred = startIconGeneration(r8);
        return;
    L8:
        if (r0.a() == false) goto L10;
    L11:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "icon generation preload skip existingTask active=" + r0.a() + " completed=" + r0.q_(), false, 4, null);
        return;
    L10:
        if (r0.q_() == false) goto L13;
        goto L11
    }

    private final void trackRuleEdit(b r13) {
        boolean r0 = false;
        if (r13.a() == null) goto L5;
        boolean r3 = true;
    L6:
        if (r3 == false) goto L8;
    L10:
        MemoryEventTracker r2 = MemoryEventTracker.f10515a;
        if (r0 == false) goto L13;
        String r4 = r13.d();
    L14:
        String r1 = r13.e();
        if ((true ^ StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r1, CharSequence.class, "com.obric.memorydata.plugin"))) == false) goto L17;
        String r5 = r1;
    L18:
        String r6 = r13.r().h().toString();
        Intrinsics.checkNotNullExpressionValue(r6, "toString(...)");
        r2.a(r3, r4, r5, r6, r13.p(), r13.q(), r13.l(), r13.s(), r13.f());
        return;
    L17:
        r5 = null;
        goto L18
    L13:
        r4 = null;
        goto L14
    L8:
        if (r13.s() == true) goto L10;
        r0 = true;
        goto L10
    L5:
        r3 = false;
        goto L6
    }

    private static final b updateSubtitleFormat$lambda$3(String r30, b r31) {
        Intrinsics.checkNotNullParameter(r31, "it");
        if (Intrinsics.areEqual(r31.r().g(), r30) == false) goto L6;
        return r31;
    L6:
        return b.a(r31, null, null, null, null, null, null, false, null, null, null, false, false, null, null, null, 0, 0, e.a(r31.r(), null, null, null, null, null, null, r30, null, 191, null), false, 393215, null);
    }

    private static final b updateTitle$lambda$0(String r33, b r34) {
        Intrinsics.checkNotNullParameter(r34, "it");
        if (Intrinsics.areEqual(r34.b(), r33) == false) goto L8;
        if (Intrinsics.areEqual(r34.r().a(), r33) == false) goto L8;
        return r34;
    L8:
        return b.a(r34, null, r33, null, null, null, null, false, null, null, null, false, false, null, null, null, 0, 0, e.a(r34.r(), r33, null, null, null, null, null, null, null, 254, null), false, 393213, null);
    }

    private static final b updateTitleFormat$lambda$2(String r30, b r31) {
        Intrinsics.checkNotNullParameter(r31, "it");
        if (Intrinsics.areEqual(r31.r().f(), r30) == false) goto L6;
        return r31;
    L6:
        return b.a(r31, null, null, null, null, null, null, false, null, null, null, false, false, null, null, null, 0, 0, e.a(r31.r(), null, null, null, null, null, r30, null, null, 223, null), false, 393215, null);
    }

    private static final b updateUseClientModel$lambda$1(boolean r23, b r24) {
        Intrinsics.checkNotNullParameter(r24, "it");
        if (r24.g() != r23) goto L6;
        return r24;
    L6:
        return b.a(r24, null, null, null, null, null, null, r23, null, null, null, false, false, null, null, null, 0, 0, null, false, 524223, null);
    }

    public final Object auditFormatInput(boolean r9, String r10, String r11, Continuation<? super FormatAuditResult> r12) {
        Continuation r13 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r12, Continuation.class, "com.obric.memorydata.plugin");
        return am.a((Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass2(this, r9, r11, r10, null), Function2.class, "com.obric.memorydata.plugin"), r13);
    }

    public final void bind(String r9) {
        Intrinsics.checkNotNullParameter(r9, "sid");
        if (Intrinsics.areEqual(this.sessionId, r9) == false) goto L5;
        return;
    L5:
        this.sessionId = r9;
        kotlinx.coroutines.i.a(ViewModelKt.getViewModelScope((ViewModel) ZeusTransformUtils.preCheckCast(this, ViewModel.class, "com.obric.memorydata.plugin")), null, null, (Function2) ZeusTransformUtils.preCheckCast(new C11351(r9, this, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
    }

    public final void bootstrapForEdit(long r14, Function1<? super String, Unit> r16) {
        Function1 r6 = (Function1) ZeusTransformUtils.wrapperContextForParams(r16, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "onReady");
        kotlinx.coroutines.i.a(ViewModelKt.getViewModelScope((ViewModel) ZeusTransformUtils.preCheckCast(this, ViewModel.class, "com.obric.memorydata.plugin")), (CoroutineContext) ZeusTransformUtils.preCheckCast(ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin"), null, (Function2) ZeusTransformUtils.preCheckCast(new C11361(r14, this, r6, null), Function2.class, "com.obric.memorydata.plugin"), 2, null);
    }

    public final void confirmCreate(Function0<Unit> r16, Function0<Unit> r17, Function0<Unit> r18, Function0<Unit> r19, Function0<Unit> r20) {
        final Function0 r7 = (Function0) ZeusTransformUtils.wrapperContextForParams(r16, Function0.class, "com.obric.memorydata.plugin");
        Function0 r5 = (Function0) ZeusTransformUtils.wrapperContextForParams(r17, Function0.class, "com.obric.memorydata.plugin");
        Function0 r6 = (Function0) ZeusTransformUtils.wrapperContextForParams(r18, Function0.class, "com.obric.memorydata.plugin");
        Function0 r4 = (Function0) ZeusTransformUtils.wrapperContextForParams(r19, Function0.class, "com.obric.memorydata.plugin");
        Function0 r8 = (Function0) ZeusTransformUtils.wrapperContextForParams(r20, Function0.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r7, "onDone");
        Intrinsics.checkNotNullParameter(r5, "onTitleAuditFailed");
        Intrinsics.checkNotNullParameter(r6, "onIconGenerateFailed");
        Intrinsics.checkNotNullParameter(r4, "onClientModelLimitReached");
        Intrinsics.checkNotNullParameter(r8, "onCreateFailed");
        if (((i) ZeusTransformUtils.preCheckCast(this._state.c(), i.class, "com.obric.memorydata.plugin")).b() == false) goto L5;
        return;
    L5:
        String r3 = this.sessionId;
        b r2 = g.f10759a.b(r3);
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.memorydata.plugin")).length() != 0) goto L8;
        boolean r0 = true;
    L9:
        if (r0 == true) goto L17;
        if (r2 == null) goto L17;
        ae<i> r1 = this._state;
    L13:
        i r11 = r1.c();
        if (r1.a(r11, i.a((i) ZeusTransformUtils.preCheckCast(r11, i.class, "com.obric.memorydata.plugin"), null, true, 1, null)) == false) goto L13;
        kotlinx.coroutines.i.a(ViewModelKt.getViewModelScope((ViewModel) ZeusTransformUtils.preCheckCast(this, ViewModel.class, "com.obric.memorydata.plugin")), (CoroutineContext) ZeusTransformUtils.preCheckCast(ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin"), null, (Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass3(this, r2, r3, r4, r5, r6, r7, r8, null), Function2.class, "com.obric.memorydata.plugin"), 2, null);
        return;
    L17:
        com.obric.memorydata.utils.j.a(new $$Lambda$MemoryTaskSettingsViewModel$PL32L8QoNbHQR98vcI3OyDPhIlw(r7));
        return;
    L8:
        r0 = false;
        goto L9
    }

    public final kotlinx.coroutines.flow.ar<i> getState() {
        return this.state;
    }

    public final boolean isCommitted() {
        return this.committed;
    }

    public final void updateSubtitleFormat(final String r4) {
        Intrinsics.checkNotNullParameter(r4, "newValue");
        if (((CharSequence) ZeusTransformUtils.preCheckCast(this.sessionId, CharSequence.class, "com.obric.memorydata.plugin")).length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        return;
    L8:
        g.f10759a.update(this.sessionId, new $$Lambda$MemoryTaskSettingsViewModel$I_TPizEM4e4qVZjxYFprfY4shis(r4));
        return;
    L5:
        r0 = false;
        goto L6
    }

    public final void updateTitle(final String r4) {
        Intrinsics.checkNotNullParameter(r4, "newTitle");
        if (((CharSequence) ZeusTransformUtils.preCheckCast(this.sessionId, CharSequence.class, "com.obric.memorydata.plugin")).length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        return;
    L8:
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.memorydata.plugin")) == true) goto L13;
        g.f10759a.update(this.sessionId, new $$Lambda$MemoryTaskSettingsViewModel$xtjHhOwWg1zLJSzrANmoAzYQP4w(r4));
        return;
    L13:
        return;
    L5:
        r0 = false;
        goto L6
    }

    public final void updateTitleFormat(final String r4) {
        Intrinsics.checkNotNullParameter(r4, "newValue");
        if (((CharSequence) ZeusTransformUtils.preCheckCast(this.sessionId, CharSequence.class, "com.obric.memorydata.plugin")).length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        return;
    L8:
        g.f10759a.update(this.sessionId, new $$Lambda$MemoryTaskSettingsViewModel$peKqEI1ZwcNXRkYdF5eIU3YAJ2Q(r4));
        return;
    L5:
        r0 = false;
        goto L6
    }

    public final void updateUseClientModel(final boolean r4) {
        if (((CharSequence) ZeusTransformUtils.preCheckCast(this.sessionId, CharSequence.class, "com.obric.memorydata.plugin")).length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        return;
    L8:
        g.f10759a.update(this.sessionId, new $$Lambda$MemoryTaskSettingsViewModel$8OJs7qBSLFpDwNg7VfAVXOu4SY(r4));
        return;
    L5:
        r0 = false;
        goto L6
    }
}
