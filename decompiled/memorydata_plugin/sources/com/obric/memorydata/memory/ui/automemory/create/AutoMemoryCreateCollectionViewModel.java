package com.obric.memorydata.memory.ui.automemory.create;

import android.content.Context;
import android.widget.Toast;
import androidx.core.app.NotificationCompat;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.bytedance.ies.common.cpp_shared.BuildConfig;
import com.obric.memorydata.database.entity.ChatMessage;
import com.obric.memorydata.memory.ui.automemory.settings.MemoryInfoSectionEditActivity;
import com.obric.memorydata.memory.ui.automemory.v;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.task.impl.TaskInfo;
import com.obric.memorydata.task.impl.TaskRequest;
import com.obric.memorydata.utils.h;
import com.obric.memorydata.utils.j;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.CancellationException;
import java.util.concurrent.TimeUnit;
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
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.al;
import kotlinx.coroutines.ba;
import kotlinx.coroutines.bx;
import kotlinx.coroutines.dg;
import kotlinx.coroutines.flow.ad;
import kotlinx.coroutines.flow.ae;
import kotlinx.coroutines.flow.ai;
import kotlinx.coroutines.flow.ak;
import kotlinx.coroutines.flow.ar;
import kotlinx.coroutines.flow.at;
import kotlinx.coroutines.flow.k;
import kotlinx.coroutines.i;
import kotlinx.coroutines.n;
import kotlinx.coroutines.o;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u0000 :2\u00020\u0001:\u0001:B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J:\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u00052\b\b\u0002\u0010\u001f\u001a\u00020\u0005J\u0016\u0010 \u001a\u00020\u000f2\u0006\u0010!\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u0005J\u000e\u0010\"\u001a\u00020\u000f2\u0006\u0010!\u001a\u00020\u0005J\u000e\u0010#\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\u0005J\u000e\u0010$\u001a\u00020\u000f2\u0006\u0010%\u001a\u00020\u001dJ\u000e\u0010&\u001a\u00020\u001dH\u0086@¢\u0006\u0002\u0010'J\u0006\u0010(\u001a\u00020\u000fJ\u0006\u0010)\u001a\u00020\u000fJ\b\u0010*\u001a\u00020\bH\u0002J\u0006\u0010+\u001a\u00020\u000fJ\u0006\u0010,\u001a\u00020\u000fJ\u0006\u0010-\u001a\u00020\u001dJ\u001a\u0010.\u001a\u00020\u000f2\u0012\u0010/\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000f00J\u0016\u00101\u001a\u00020\u001d2\u0006\u0010\u001b\u001a\u00020\u0005H\u0082@¢\u0006\u0002\u00102J\u0018\u00103\u001a\u0004\u0018\u0001042\u0006\u00105\u001a\u00020\u0005H\u0082@¢\u0006\u0002\u00102J\u0006\u00106\u001a\u00020\u000fJ\u000e\u00107\u001a\u00020\u000f2\u0006\u00108\u001a\u000209R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006;"}, d2 = {"Lcom/obric/memorydata/memory/ui/automemory/create/AutoMemoryCreateCollectionViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "TAG", "", "_state", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/obric/memorydata/memory/ui/automemory/create/AutoMemoryCreateCollectionUiState;", "state", "Lkotlinx/coroutines/flow/StateFlow;", "getState", "()Lkotlinx/coroutines/flow/StateFlow;", "_exitRequest", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "", "exitRequest", "Lkotlinx/coroutines/flow/SharedFlow;", "getExitRequest", "()Lkotlinx/coroutines/flow/SharedFlow;", "aiOptimizeJob", "Lkotlinx/coroutines/Job;", "generateAppsJob", "initState", "ruleId", "", "title", "content", "useClientModel", "", "iconKey", "iconColorKey", "updateContent", ActivityLifecycle.NAME, "onNameChanged", "onContentChanged", "onUseClientModelChanged", "enabled", "canEnableClientModel", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "startAiOptimize", "cancelAiOptimize", "buildInitialState", "closePage", "requestExit", "hasUnsavedContent", "nextToTaskSettings", "onReady", "Lkotlin/Function1;", "runRuleCheck", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "runMemoryInfoGenerator", "Lcom/obric/memorydata/memory/ui/automemory/settings/MemoryInfo;", ChatMessage.TYPE_QUERY, "resetState", "updateImeBottom", "imeBottom", "", "Companion", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class AutoMemoryCreateCollectionViewModel extends ViewModel {
    private static final String CODE = "code";
    private static final String CONTENT = "content";
    public static final a Companion = null;
    private static final int ERROR_CODE = 1000;
    private static final String RESULT = "result";
    public static final int SUCCESS_CODE = 0;
    private final String TAG;
    private final ad<Unit> _exitRequest;
    private final ae<com.obric.memorydata.memory.ui.automemory.create.b> _state;
    private bx aiOptimizeJob;
    private final ai<Unit> exitRequest;
    private bx generateAppsJob;
    private final ar<com.obric.memorydata.memory.ui.automemory.create.b> state;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/obric/memorydata/memory/ui/automemory/create/AutoMemoryCreateCollectionViewModel$Companion;", "", "<init>", "()V", "CODE", "", "CONTENT", "RESULT", "ERROR_CODE", "", "SUCCESS_CODE", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/obric/memorydata/memory/ui/automemory/create/AutoMemoryCreateCollectionViewModel$runMemoryInfoGenerator$2$req$2", "Lcom/obric/memorydata/task/scheduler/OnTaskInfoCallBack;", "onChanged", "", "taskInfo", "Lcom/obric/memorydata/task/impl/TaskInfo;", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class b implements com.obric.memorydata.task.scheduler.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ AutoMemoryCreateCollectionViewModel f10647a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ n<com.obric.memorydata.memory.ui.automemory.settings.e> f10648b;

        @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
        public /* synthetic */ class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f10649a = null;

            static {
                int[] r0 = new int[TaskInfo.State.values().length];
                r0[TaskInfo.State.SUCCEEDED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
            L11:
                r0[TaskInfo.State.FAILED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
            L15:
                r0[TaskInfo.State.TIMEOUT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
            L6:
                f10649a = r0;
            }
        }

        b(AutoMemoryCreateCollectionViewModel r3, n<? super com.obric.memorydata.memory.ui.automemory.settings.e> r4) {
            n<com.obric.memorydata.memory.ui.automemory.settings.e> r5 = (n) ZeusTransformUtils.wrapperContextForParams(r4, n.class, "com.obric.memorydata.plugin");
            this.f10647a = r3;
            this.f10648b = r5;
        }

        @Override // com.obric.memorydata.task.scheduler.c
        public void a(TaskInfo r14) {
            Intrinsics.checkNotNullParameter(r14, "taskInfo");
            int r0 = a.f10649a[r14.c().ordinal()];
            if (r0 != 1) goto L5;
            JSONObject r15 = r14.d();
            int r1 = r15.optInt(AutoMemoryCreateCollectionViewModel.CODE, -1);
            if (r1 == 0) goto L19;
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), AutoMemoryCreateCollectionViewModel.access$getTAG$p(this.f10647a), "memory_info_generator non-zero code=" + r1 + " msg=" + r15.optString(NotificationCompat.CATEGORY_MESSAGE), null, 4, null);
            if (this.f10648b.a() == false) goto L23;
            Continuation r13 = (Continuation) ZeusTransformUtils.preCheckCast(this.f10648b, Continuation.class, "com.obric.memorydata.plugin");
            Result.Companion r16 = Result.Companion;
            r13.resumeWith(Result.m1421constructorimpl(null));
            return;
        L23:
            return;
        L19:
            String r5 = r15.optString("title");
            Intrinsics.checkNotNullExpressionValue(r5, "optString(...)");
            String r6 = com.obric.memorydata.memory.ui.automemory.settings.e.f10753a.a(r15, MemoryInfoSectionEditActivity.KIND_SCENE);
            com.obric.memorydata.memory.ui.automemory.settings.e.b r7 = com.obric.memorydata.memory.ui.automemory.settings.e.b.f10755a.a(r15.optJSONObject("info"));
            String r8 = r15.optString("custom_rule");
            Intrinsics.checkNotNullExpressionValue(r8, "optString(...)");
            String r9 = r15.optString(MemoryInfoSectionEditActivity.KIND_UPDATE_RULE);
            Intrinsics.checkNotNullExpressionValue(r9, "optString(...)");
            String r10 = r15.optString("title_format");
            Intrinsics.checkNotNullExpressionValue(r10, "optString(...)");
            String r11 = r15.optString("subtitle_format");
            Intrinsics.checkNotNullExpressionValue(r11, "optString(...)");
            String r12 = r15.optString("content_format");
            Intrinsics.checkNotNullExpressionValue(r12, "optString(...)");
            com.obric.memorydata.memory.ui.automemory.settings.e r2 = new com.obric.memorydata.memory.ui.automemory.settings.e(r5, r6, r7, r8, r9, r10, r11, r12);
            if (this.f10648b.a() == false) goto L25;
            Continuation r17 = (Continuation) ZeusTransformUtils.preCheckCast(this.f10648b, Continuation.class, "com.obric.memorydata.plugin");
            Result.Companion r18 = Result.Companion;
            Object r19 = Result.m1421constructorimpl(r2);
        L12:
            r17.resumeWith(r19);
            return;
        L25:
            return;
        L5:
            if (r0 != 2) goto L7;
        L9:
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), AutoMemoryCreateCollectionViewModel.access$getTAG$p(this.f10647a), "memory_info_generator " + r14.c(), null, 4, null);
            if (this.f10648b.a() == false) goto L22;
            r17 = (Continuation) ZeusTransformUtils.preCheckCast(this.f10648b, Continuation.class, "com.obric.memorydata.plugin");
            Result.Companion r110 = Result.Companion;
            r19 = Result.m1421constructorimpl(null);
            goto L12
        L22:
            return;
        L7:
            if (r0 == 3) goto L9;
        }
    }

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    static final class c implements Function1<Throwable, Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ TaskRequest f10650a;

        c(TaskRequest r1) {
            this.f10650a = r1;
        }

        public final void a(Throwable r1) {
            this.f10650a.cancel();
        }

        @Override // kotlin.jvm.functions.Function1
        public /* synthetic */ Unit invoke(Throwable r3) {
            a((Throwable) ZeusTransformUtils.preCheckCast(r3, Throwable.class, "com.obric.memorydata.plugin"));
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.automemory.create.AutoMemoryCreateCollectionViewModel$canEnableClientModel$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.memory.ui.automemory.create.AutoMemoryCreateCollectionViewModel", f = "AutoMemoryCreateCollectionViewModel.kt", i = {}, l = {113}, m = "canEnableClientModel", n = {}, s = {})
    static final class AnonymousClass1 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ AutoMemoryCreateCollectionViewModel this$0;

        AnonymousClass1(AutoMemoryCreateCollectionViewModel r3, Continuation<? super AnonymousClass1> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            super(r5);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r3) {
            this.result = r3;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.canEnableClientModel((Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin"));
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/obric/memorydata/memory/ui/automemory/create/AutoMemoryCreateCollectionViewModel$runRuleCheck$2$req$2", "Lcom/obric/memorydata/task/scheduler/OnTaskInfoCallBack;", "onChanged", "", "taskInfo", "Lcom/obric/memorydata/task/impl/TaskInfo;", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class d implements com.obric.memorydata.task.scheduler.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ AutoMemoryCreateCollectionViewModel f10651a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ n<Boolean> f10652b;

        @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
        public /* synthetic */ class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f10653a = null;

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
                f10653a = r0;
            }
        }

        d(AutoMemoryCreateCollectionViewModel r3, n<? super Boolean> r4) {
            n<Boolean> r5 = (n) ZeusTransformUtils.wrapperContextForParams(r4, n.class, "com.obric.memorydata.plugin");
            this.f10651a = r3;
            this.f10652b = r5;
        }

        @Override // com.obric.memorydata.task.scheduler.c
        public void a(TaskInfo r11) {
            Intrinsics.checkNotNullParameter(r11, "taskInfo");
            int r0 = a.f10653a[r11.c().ordinal()];
            boolean r1 = true;
            if (r0 != 1) goto L5;
            JSONObject r12 = r11.e().getOutput();
            int r2 = r12.optInt(AutoMemoryCreateCollectionViewModel.CODE, 1000);
            boolean r4 = r12.optBoolean(AutoMemoryCreateCollectionViewModel.RESULT, false);
            RunLog.INSTANCE.debug(AutoMemoryCreateCollectionViewModel.access$getTAG$p(this.f10651a), "rule_check output: " + r12);
            if (this.f10652b.a() == false) goto L25;
            Continuation r10 = (Continuation) ZeusTransformUtils.preCheckCast(this.f10652b, Continuation.class, "com.obric.memorydata.plugin");
            Result.Companion r13 = Result.Companion;
            if (r2 != 0) goto L21;
            if (r4 == false) goto L21;
        L22:
            boolean r14 = Boolean.valueOf(r1);
        L14:
            r10.resumeWith(Result.m1421constructorimpl(r14));
            return;
        L21:
            r1 = false;
            goto L22
        L25:
            return;
        L5:
            if (r0 != 2) goto L7;
        L11:
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), AutoMemoryCreateCollectionViewModel.access$getTAG$p(this.f10651a), "rule_check " + r11.c(), null, 4, null);
            if (this.f10652b.a() == false) goto L23;
            r10 = (Continuation) ZeusTransformUtils.preCheckCast(this.f10652b, Continuation.class, "com.obric.memorydata.plugin");
            Result.Companion r15 = Result.Companion;
            r14 = false;
            goto L14
        L23:
            return;
        L7:
            if (r0 == 3) goto L11;
            if (r0 == 4) goto L11;
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.automemory.create.AutoMemoryCreateCollectionViewModel$nextToTaskSettings$3, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.memory.ui.automemory.create.AutoMemoryCreateCollectionViewModel$nextToTaskSettings$3", f = "AutoMemoryCreateCollectionViewModel.kt", i = {1, 1, 1, 2, 2, 2}, l = {257, 262, 289}, m = "invokeSuspend", n = {"myJob", "title", "content", "myJob", "title", "content"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2"})
    static final class AnonymousClass3 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1<String, Unit> $onReady;
        final /* synthetic */ com.obric.memorydata.memory.ui.automemory.create.b $s;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        final /* synthetic */ AutoMemoryCreateCollectionViewModel this$0;

        AnonymousClass3(com.obric.memorydata.memory.ui.automemory.create.b r3, AutoMemoryCreateCollectionViewModel r4, Function1<? super String, Unit> r5, Continuation<? super AnonymousClass3> r6) {
            Function1<String, Unit> r7 = (Function1) ZeusTransformUtils.wrapperContextForParams(r5, Function1.class, "com.obric.memorydata.plugin");
            Continuation r8 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r6, Continuation.class, "com.obric.memorydata.plugin");
            this.$s = r3;
            this.this$0 = r4;
            this.$onReady = r7;
            super(2, r8);
        }

        private static final Unit invokeSuspend$lambda$1() {
            Toast.makeText((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("包含不符合规范的记忆内容，请修改后重试", CharSequence.class, "com.obric.memorydata.plugin"), 1).show();
            return Unit.INSTANCE;
        }

        private static final Unit invokeSuspend$lambda$3() {
            Toast.makeText((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("生成失败，请稍后重试", CharSequence.class, "com.obric.memorydata.plugin"), 0).show();
            return Unit.INSTANCE;
        }

        private static final Unit invokeSuspend$lambda$4(Function1 r2, String r3) {
            ((Function1) ZeusTransformUtils.wrapperContextForParams(r2, Function1.class, "com.obric.memorydata.plugin")).invoke(r3);
            return Unit.INSTANCE;
        }

        public static /* synthetic */ Unit lambda$4nF7qjxQpcTqF3qPIBbWU9XvLtQ(Function1 r0, String r1) {
            return invokeSuspend$lambda$4(r0, r1);
        }

        public static /* synthetic */ Unit lambda$9dtv4YcP_2qbvIy6jpVOhmzpiIg() {
            return invokeSuspend$lambda$1();
        }

        public static /* synthetic */ Unit lambda$nzBTMAXn2FrMKt6xmgA8o7sNPaM() {
            return invokeSuspend$lambda$3();
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new AnonymousClass3(this.$s, this.this$0, this.$onReady, r6), Continuation.class, "com.obric.memorydata.plugin");
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
        public final Object invokeSuspend(Object r35) {
            Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r0 = this.label;
            boolean r3 = false;
            if (r0 == 0) goto L24;
            if (r0 == 1) goto L23;
            if (r0 == 2) goto L16;
            if (r0 != 3) goto L15;
            String r4 = (String) ZeusTransformUtils.preCheckCast(this.L$2, String.class, "com.obric.memorydata.plugin");
            String r5 = (String) ZeusTransformUtils.preCheckCast(this.L$1, String.class, "com.obric.memorydata.plugin");
            bx r6 = (bx) ZeusTransformUtils.preCheckCast(this.L$0, bx.class, "com.obric.memorydata.plugin");
            ResultKt.throwOnFailure(r35);     // Catch: Exception -> L10 CancellationException -> L12
            Object r1 = r35;
        L57:
            com.obric.memorydata.memory.ui.automemory.settings.e r30 = (com.obric.memorydata.memory.ui.automemory.settings.e) ZeusTransformUtils.preCheckCast(r1, com.obric.memorydata.memory.ui.automemory.settings.e.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L10 CancellationException -> L12
            String r16 = r4;
        L63:
            if (AutoMemoryCreateCollectionViewModel.access$getGenerateAppsJob$p(this.this$0) != r6) goto L65;
            if (r30 != null) goto L79;
            ae r7 = AutoMemoryCreateCollectionViewModel.access$get_state$p(this.this$0);
        L68:
            Object r8 = r7.c();
            com.obric.memorydata.memory.ui.automemory.create.b r9 = (com.obric.memorydata.memory.ui.automemory.create.b) ZeusTransformUtils.preCheckCast(r8, com.obric.memorydata.memory.ui.automemory.create.b.class, "com.obric.memorydata.plugin");
            if (r9.g() != AutoMemoryCreateCollectionStep.GENERATE_RECOMMEND_APP) goto L72;
            r9 = com.obric.memorydata.memory.ui.automemory.create.b.a(r9, 0, null, null, false, null, null, AutoMemoryCreateCollectionStep.EDIT_INFO, 0, 191, null);
        L72:
            if (r7.a(r8, r9) == false) goto L68;
            j.a($$Lambda$AutoMemoryCreateCollectionViewModel$nextToTaskSettings$3$nzBTMAXn2FrMKt6xmgA8o7sNPaM.INSTANCE);
            if (AutoMemoryCreateCollectionViewModel.access$getGenerateAppsJob$p(this.this$0) != r6) goto L77;
            AutoMemoryCreateCollectionViewModel.access$setGenerateAppsJob$p(this.this$0, null);
        L77:
            return Unit.INSTANCE;
        L79:
            if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r30.a(), CharSequence.class, "com.obric.memorydata.plugin"))) == false) goto L81;
            String r14 = r30.a();
        L83:
            if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(this.$s.e(), CharSequence.class, "com.obric.memorydata.plugin"))) == true) goto L85;
        L87:
            String r10 = r30.h().toString();
            Intrinsics.checkNotNullExpressionValue(r10, "toString(...)");
            boolean r19 = this.$s.d();
            String r25 = this.$s.e();
            String r26 = this.$s.f();
            if (r3 == false) goto L90;
            String r11 = BuildConfig.VERSION_NAME;
        L91:
            final String r12 = com.obric.memorydata.memory.ui.automemory.settings.g.f10759a.a(new com.obric.memorydata.memory.ui.automemory.settings.b(null, r14, null, r16, r10, "", r19, null, null, null, false, false, r25, r26, r11, 0, 0, r30, false, 364420, null));
            final Function1<String, Unit> r13 = this.$onReady;
            j.a(new $$Lambda$AutoMemoryCreateCollectionViewModel$nextToTaskSettings$3$4nF7qjxQpcTqF3qPIBbWU9XvLtQ(r13, r12));
            if (AutoMemoryCreateCollectionViewModel.access$getGenerateAppsJob$p(this.this$0) != r6) goto L95;
            AutoMemoryCreateCollectionViewModel.access$setGenerateAppsJob$p(this.this$0, null);
        L95:
            return Unit.INSTANCE;
        L90:
            r11 = "";
            goto L91
        L85:
            if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(this.$s.f(), CharSequence.class, "com.obric.memorydata.plugin"))) == false) goto L87;
            r3 = true;
            goto L87
        L81:
            r14 = r5;
            goto L83
        L65:
            return Unit.INSTANCE;
        L10:
            e = e;
        L61:
            RunLog.INSTANCE.error(AutoMemoryCreateCollectionViewModel.access$getTAG$p(this.this$0), "memory info generator failed", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
            r16 = r4;
            r30 = null;
            goto L63
        L15:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L16:
            String r15 = (String) ZeusTransformUtils.preCheckCast(this.L$2, String.class, "com.obric.memorydata.plugin");
            String r17 = (String) ZeusTransformUtils.preCheckCast(this.L$1, String.class, "com.obric.memorydata.plugin");
            bx r18 = (bx) ZeusTransformUtils.preCheckCast(this.L$0, bx.class, "com.obric.memorydata.plugin");
            ResultKt.throwOnFailure(r35);     // Catch: Exception -> L19 CancellationException -> L21
            Object r20 = r35;
        L32:
            boolean r21 = ((Boolean) ZeusTransformUtils.preCheckCast(r20, Boolean.class, "com.obric.memorydata.plugin")).booleanValue();     // Catch: Exception -> L19 CancellationException -> L21
        L38:
            if (AutoMemoryCreateCollectionViewModel.access$getGenerateAppsJob$p(this.this$0) != r18) goto L40;
            if (r21 == true) goto L101;
            ae r22 = AutoMemoryCreateCollectionViewModel.access$get_state$p(this.this$0);
        L43:
            Object r23 = r22.c();
            com.obric.memorydata.memory.ui.automemory.create.b r110 = (com.obric.memorydata.memory.ui.automemory.create.b) ZeusTransformUtils.preCheckCast(r23, com.obric.memorydata.memory.ui.automemory.create.b.class, "com.obric.memorydata.plugin");
            if (r110.g() != AutoMemoryCreateCollectionStep.GENERATE_RECOMMEND_APP) goto L47;
            r110 = com.obric.memorydata.memory.ui.automemory.create.b.a(r110, 0, null, null, false, null, null, AutoMemoryCreateCollectionStep.EDIT_INFO, 0, 191, null);
        L47:
            if (r22.a(r23, r110) == false) goto L43;
            j.a($$Lambda$AutoMemoryCreateCollectionViewModel$nextToTaskSettings$3$9dtv4YcP_2qbvIy6jpVOhmzpiIg.INSTANCE);
            if (AutoMemoryCreateCollectionViewModel.access$getGenerateAppsJob$p(this.this$0) != r18) goto L52;
            AutoMemoryCreateCollectionViewModel.access$setGenerateAppsJob$p(this.this$0, null);
        L52:
            return Unit.INSTANCE;
        L101:
            AutoMemoryCreateCollectionViewModel r24 = this.this$0;     // Catch: CancellationException -> L12 Exception -> L59
            Continuation r111 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");     // Catch: CancellationException -> L12 Exception -> L59
            this.L$0 = r18;     // Catch: CancellationException -> L12 Exception -> L59
            this.L$1 = r17;     // Catch: CancellationException -> L12 Exception -> L59
            this.L$2 = r15;     // Catch: CancellationException -> L12 Exception -> L59
            this.label = 3;     // Catch: CancellationException -> L12 Exception -> L59
            r1 = AutoMemoryCreateCollectionViewModel.access$runMemoryInfoGenerator(r24, r15, r111);     // Catch: CancellationException -> L12 Exception -> L59
            if (r1 != r2) goto L56;
            return r2;
        L56:
            r4 = r15;
            r5 = r17;
            r6 = r18;
        L59:
            e = e;
            r4 = r15;
            r5 = r17;
            r6 = r18;
            goto L61
        L40:
            return Unit.INSTANCE;
        L19:
            e = e;
        L36:
            RunLog.INSTANCE.error(AutoMemoryCreateCollectionViewModel.access$getTAG$p(this.this$0), "rule check failed", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
            r21 = false;
            goto L38
        L23:
            ResultKt.throwOnFailure(r35);
        L27:
            r18 = (bx) ZeusTransformUtils.preCheckCast(getContext().get((CoroutineContext.Key) ZeusTransformUtils.preCheckCast(bx.f17252a, CoroutineContext.Key.class, "com.obric.memorydata.plugin")), bx.class, "com.obric.memorydata.plugin");
            r17 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(this.$s.b(), CharSequence.class, "com.obric.memorydata.plugin")).toString();
            String r112 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(this.$s.c(), CharSequence.class, "com.obric.memorydata.plugin")).toString();
            Continuation r113 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");     // Catch: CancellationException -> L21 Exception -> L34
            this.L$0 = r18;     // Catch: CancellationException -> L21 Exception -> L34
            this.L$1 = r17;     // Catch: CancellationException -> L21 Exception -> L34
            this.L$2 = r112;     // Catch: CancellationException -> L21 Exception -> L34
            this.label = 2;     // Catch: CancellationException -> L21 Exception -> L34
            r20 = AutoMemoryCreateCollectionViewModel.access$runRuleCheck(this.this$0, r17 + r112, r113);     // Catch: CancellationException -> L21 Exception -> L34
            if (r20 != r2) goto L31;
            return r2;
        L31:
            r15 = r112;
        L34:
            e = e;
            r15 = r112;
            goto L36
        L24:
            ResultKt.throwOnFailure(r35);
            Continuation r27 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 1;
            if (dg.a(r27) != r2) goto L27;
            return r2;
        L12:
            e = move-exception;
            throw e;
        L21:
            e = move-exception;
            throw e;
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.automemory.create.AutoMemoryCreateCollectionViewModel$startAiOptimize$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.memory.ui.automemory.create.AutoMemoryCreateCollectionViewModel$startAiOptimize$2", f = "AutoMemoryCreateCollectionViewModel.kt", i = {}, l = {131}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ AutoMemoryCreateCollectionViewModel this$0;

        /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.automemory.create.AutoMemoryCreateCollectionViewModel$startAiOptimize$2$1, reason: invalid class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
        @DebugMetadata(c = "com.obric.memorydata.memory.ui.automemory.create.AutoMemoryCreateCollectionViewModel$startAiOptimize$2$1", f = "AutoMemoryCreateCollectionViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class AnonymousClass1 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
            final /* synthetic */ String $input;
            final /* synthetic */ bx $myJob;
            int label;
            final /* synthetic */ AutoMemoryCreateCollectionViewModel this$0;

            AnonymousClass1(AutoMemoryCreateCollectionViewModel r3, bx r4, String r5, Continuation<? super AnonymousClass1> r6) {
                bx r7 = (bx) ZeusTransformUtils.wrapperContextForParams(r4, bx.class, "com.obric.memorydata.plugin");
                Continuation r8 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r6, Continuation.class, "com.obric.memorydata.plugin");
                this.this$0 = r3;
                this.$myJob = r7;
                this.$input = r5;
                super(2, r8);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
                Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
                return (Continuation) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.this$0, this.$myJob, this.$input, r6), Continuation.class, "com.obric.memorydata.plugin");
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
            public final Object invokeSuspend(Object r20) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) goto L23;
                ResultKt.throwOnFailure(r20);
                IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), AutoMemoryCreateCollectionViewModel.access$getTAG$p(this.this$0), "start rewrite ", false, 4, null);     // Catch: Exception -> L7
                TaskRequest.Builder r0 = new TaskRequest.Builder("auto_memory_pro_rule_rewrite");     // Catch: Exception -> L7
                JSONObject r3 = new JSONObject();     // Catch: Exception -> L7
                r3.put(ChatMessage.TYPE_QUERY, this.$input);     // Catch: Exception -> L7
                TaskRequest.Builder r1 = (TaskRequest.Builder) ZeusTransformUtils.preCheckCast(((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(r0.setInputParam(r3), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).setTimeout(new com.obric.memorydata.task.impl.g(10, TimeUnit.SECONDS)), TaskRequest.Builder.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L7
                final AutoMemoryCreateCollectionViewModel r4 = this.this$0;     // Catch: Exception -> L7
                final bx r5 = this.$myJob;     // Catch: Exception -> L7
                ((TaskRequest) ZeusTransformUtils.preCheckCast(((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(r1.setTaskInfoCallback((com.obric.memorydata.task.scheduler.c) ZeusTransformUtils.preCheckCast(new C05331(r4, r5), com.obric.memorydata.task.scheduler.c.class, "com.obric.memorydata.plugin")), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).build(), TaskRequest.class, "com.obric.memorydata.plugin")).enqueue();     // Catch: Exception -> L7
            L21:
                return Unit.INSTANCE;
            L7:
                e = move-exception;
                RunLog.INSTANCE.error(AutoMemoryCreateCollectionViewModel.access$getTAG$p(this.this$0), "rewrite enqueue failed", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
                ae r2 = AutoMemoryCreateCollectionViewModel.access$get_state$p(this.this$0);
                AutoMemoryCreateCollectionViewModel r6 = this.this$0;
                bx r7 = this.$myJob;
            L9:
                Object r8 = r2.c();
                com.obric.memorydata.memory.ui.automemory.create.b r9 = (com.obric.memorydata.memory.ui.automemory.create.b) ZeusTransformUtils.preCheckCast(r8, com.obric.memorydata.memory.ui.automemory.create.b.class, "com.obric.memorydata.plugin");
                if (r9.g() != AutoMemoryCreateCollectionStep.AI_OPTIMIZING) goto L16;
                if (AutoMemoryCreateCollectionViewModel.access$getAiOptimizeJob$p(r6) != r7) goto L16;
                r9 = com.obric.memorydata.memory.ui.automemory.create.b.a(r9, 0, null, null, false, null, null, AutoMemoryCreateCollectionStep.EDIT_INFO, 0, 191, null);
            L16:
                if (r2.a(r8, r9) == false) goto L9;
                if (AutoMemoryCreateCollectionViewModel.access$getAiOptimizeJob$p(this.this$0) != this.$myJob) goto L21;
                AutoMemoryCreateCollectionViewModel.access$setAiOptimizeJob$p(this.this$0, null);
                goto L21
            L23:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        AnonymousClass2(AutoMemoryCreateCollectionViewModel r3, Continuation<? super AnonymousClass2> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            super(2, r5);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            Continuation r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new AnonymousClass2(this.this$0, r4), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
            return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(al r3, Continuation<? super Unit> r4) {
            return ((AnonymousClass2) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), AnonymousClass2.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r9) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r9);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r9);
            bx r10 = (bx) ZeusTransformUtils.preCheckCast(getContext().get((CoroutineContext.Key) ZeusTransformUtils.preCheckCast(bx.f17252a, CoroutineContext.Key.class, "com.obric.memorydata.plugin")), bx.class, "com.obric.memorydata.plugin");
            String r2 = ((com.obric.memorydata.memory.ui.automemory.create.b) ZeusTransformUtils.preCheckCast(AutoMemoryCreateCollectionViewModel.access$get_state$p(this.this$0).c(), com.obric.memorydata.memory.ui.automemory.create.b.class, "com.obric.memorydata.plugin")).c();
            CoroutineContext r3 = (CoroutineContext) ZeusTransformUtils.preCheckCast(ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin");
            Function2 r11 = (Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.this$0, r10, r2, null), Function2.class, "com.obric.memorydata.plugin");
            Continuation r4 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 1;
            if (i.a(r3, r11, r4) != r0) goto L12;
            return r0;
        }
    }

    static {
        Companion = new a(null);
    }

    public AutoMemoryCreateCollectionViewModel() {
        this.TAG = "AutoMemoryCreateCollectionViewModel";
        ae<com.obric.memorydata.memory.ui.automemory.create.b> r0 = at.a(buildInitialState());
        this._state = r0;
        this.state = k.a(r0);
        ad<Unit> r1 = ak.a(0, 1, null, 5, null);
        this._exitRequest = r1;
        this.exitRequest = k.a(r1);
    }

    public static final /* synthetic */ bx access$getAiOptimizeJob$p(AutoMemoryCreateCollectionViewModel r0) {
        return r0.aiOptimizeJob;
    }

    public static final /* synthetic */ bx access$getGenerateAppsJob$p(AutoMemoryCreateCollectionViewModel r0) {
        return r0.generateAppsJob;
    }

    public static final /* synthetic */ String access$getTAG$p(AutoMemoryCreateCollectionViewModel r0) {
        return r0.TAG;
    }

    public static final /* synthetic */ ae access$get_state$p(AutoMemoryCreateCollectionViewModel r0) {
        return r0._state;
    }

    public static final /* synthetic */ Object access$runMemoryInfoGenerator(AutoMemoryCreateCollectionViewModel r2, String r3, Continuation r4) {
        return r2.runMemoryInfoGenerator(r3, (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    public static final /* synthetic */ Object access$runRuleCheck(AutoMemoryCreateCollectionViewModel r2, String r3, Continuation r4) {
        return r2.runRuleCheck(r3, (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    public static final /* synthetic */ void access$setAiOptimizeJob$p(AutoMemoryCreateCollectionViewModel r2, bx r3) {
        r2.aiOptimizeJob = (bx) ZeusTransformUtils.wrapperContextForParams(r3, bx.class, "com.obric.memorydata.plugin");
    }

    public static final /* synthetic */ void access$setGenerateAppsJob$p(AutoMemoryCreateCollectionViewModel r2, bx r3) {
        r2.generateAppsJob = (bx) ZeusTransformUtils.wrapperContextForParams(r3, bx.class, "com.obric.memorydata.plugin");
    }

    private final com.obric.memorydata.memory.ui.automemory.create.b buildInitialState() {
        return new com.obric.memorydata.memory.ui.automemory.create.b(0, "", "", false, null, null, AutoMemoryCreateCollectionStep.EDIT_INFO, 0, 176, null);
    }

    public static /* synthetic */ void initState$default(AutoMemoryCreateCollectionViewModel r10, long r11, String r13, String r14, boolean r15, String r16, String r17, int r18, Object r19) {
        if ((r18 & 16) == 0) goto L5;
        String r8 = "";
    L7:
        if ((r18 & 32) == 0) goto L9;
        String r9 = "";
    L10:
        r10.initState(r11, r13, r14, r15, r8, r9);
        return;
    L9:
        r9 = r17;
        goto L10
    L5:
        r8 = r16;
        goto L7
    }

    public static /* synthetic */ Unit lambda$952Q_MOKN77fsmZf1wncfIu1kX0() {
        return nextToTaskSettings$lambda$8();
    }

    private static final Unit nextToTaskSettings$lambda$8() {
        Toast.makeText((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("网络异常，请稍后重试", CharSequence.class, "com.obric.memorydata.plugin"), 0).show();
        return Unit.INSTANCE;
    }

    private final Object runMemoryInfoGenerator(String r8, Continuation<? super com.obric.memorydata.memory.ui.automemory.settings.e> r9) {
        Continuation r10 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r9, Continuation.class, "com.obric.memorydata.plugin");
        o r0 = new o(IntrinsicsKt.intercepted(r10), 1);
        r0.e();
        n r2 = (n) ZeusTransformUtils.preCheckCast(r0, n.class, "com.obric.memorydata.plugin");
        TaskRequest.Builder r3 = new TaskRequest.Builder("auto_memory_pro_memory_info_generator");
        JSONObject r4 = new JSONObject();
        r4.put(ChatMessage.TYPE_QUERY, r8);
        ((TaskRequest) ZeusTransformUtils.preCheckCast(((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(r3.setInputParam(r4), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).setTimeout(new com.obric.memorydata.task.impl.g(15, TimeUnit.SECONDS)), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).setTaskInfoCallback((com.obric.memorydata.task.scheduler.c) ZeusTransformUtils.preCheckCast(new b(this, r2), com.obric.memorydata.task.scheduler.c.class, "com.obric.memorydata.plugin")), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).build(), TaskRequest.class, "com.obric.memorydata.plugin")).enqueue();     // Catch: Exception -> L5
    L9:
        Object r7 = r0.h();
        if (r7 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L12;
        DebugProbesKt.probeCoroutineSuspended(r10);
    L12:
        return r7;
    L5:
        e = move-exception;
        if (r2.a() == false) goto L9;
        Continuation r11 = (Continuation) ZeusTransformUtils.preCheckCast(r2, Continuation.class, "com.obric.memorydata.plugin");
        Result.Companion r5 = Result.Companion;
        r11.resumeWith(Result.m1421constructorimpl(ResultKt.createFailure((Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"))));
        goto L9
    }

    private final Object runRuleCheck(String r8, Continuation<? super Boolean> r9) {
        Continuation r10 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r9, Continuation.class, "com.obric.memorydata.plugin");
        o r0 = new o(IntrinsicsKt.intercepted(r10), 1);
        r0.e();
        n r2 = (n) ZeusTransformUtils.preCheckCast(r0, n.class, "com.obric.memorydata.plugin");
        TaskRequest.Builder r4 = new TaskRequest.Builder("auto_memory_pro_rule_check");
        JSONObject r5 = new JSONObject();
        r5.put("content", r8);
        TaskRequest r7 = (TaskRequest) ZeusTransformUtils.preCheckCast(((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(r4.setInputParam(r5), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).setExecuteImmediately(true), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).setTaskInfoCallback((com.obric.memorydata.task.scheduler.c) ZeusTransformUtils.preCheckCast(new d(this, r2), com.obric.memorydata.task.scheduler.c.class, "com.obric.memorydata.plugin")), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).build(), TaskRequest.class, "com.obric.memorydata.plugin");
        r2.a((Function1) ZeusTransformUtils.preCheckCast(new c(r7), Function1.class, "com.obric.memorydata.plugin"));
        r7.enqueue();     // Catch: Exception -> L5
    L9:
        Object r11 = r0.h();
        if (r11 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L12;
        DebugProbesKt.probeCoroutineSuspended(r10);
    L12:
        return r11;
    L5:
        e = move-exception;
        if (r2.a() == false) goto L9;
        Continuation r12 = (Continuation) ZeusTransformUtils.preCheckCast(r2, Continuation.class, "com.obric.memorydata.plugin");
        Result.Companion r3 = Result.Companion;
        r12.resumeWith(Result.m1421constructorimpl(ResultKt.createFailure((Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"))));
        goto L9
    }

    public final Object canEnableClientModel(Continuation<? super Boolean> r8) {
        Continuation r9 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r8, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r9, AnonymousClass1.class) == false) goto L7;
        AnonymousClass1 r0 = (AnonymousClass1) ZeusTransformUtils.preCheckCast(r9, AnonymousClass1.class, "com.obric.memorydata.plugin");
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r10 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        ResultKt.throwOnFailure(r10);
    L18:
        return Boxing.boxBoolean(!v.f10768a.a(true, ((Number) ZeusTransformUtils.preCheckCast(r10, Number.class, "com.obric.memorydata.plugin")).intValue()));
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r10);
        long r7 = ((com.obric.memorydata.memory.ui.automemory.create.b) ZeusTransformUtils.preCheckCast(this._state.c(), com.obric.memorydata.memory.ui.automemory.create.b.class, "com.obric.memorydata.plugin")).a();
        CoroutineContext r4 = (CoroutineContext) ZeusTransformUtils.preCheckCast(ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin");
        Function2 r11 = (Function2) ZeusTransformUtils.preCheckCast(new AutoMemoryCreateCollectionViewModel$canEnableClientModel$usedCount$1(r7, null), Function2.class, "com.obric.memorydata.plugin");
        r0.label = 1;
        r10 = i.a(r4, r11, r0);
        if (r10 != r2) goto L18;
        return r2;
    L7:
        r0 = new AnonymousClass1(this, r9);
        goto L8
    }

    public final void cancelAiOptimize() {
        bx r0 = this.aiOptimizeJob;
        if (r0 == null) goto L5;
        bx.a.a(r0, null, 1, null);
    L5:
        this.aiOptimizeJob = null;
        ae<com.obric.memorydata.memory.ui.automemory.create.b> r14 = this._state;
    L6:
        com.obric.memorydata.memory.ui.automemory.create.b r1 = r14.c();
        com.obric.memorydata.memory.ui.automemory.create.b r2 = (com.obric.memorydata.memory.ui.automemory.create.b) ZeusTransformUtils.preCheckCast(r1, com.obric.memorydata.memory.ui.automemory.create.b.class, "com.obric.memorydata.plugin");
        if (r2.g() != AutoMemoryCreateCollectionStep.AI_OPTIMIZING) goto L10;
        r2 = com.obric.memorydata.memory.ui.automemory.create.b.a(r2, 0, null, null, false, null, null, AutoMemoryCreateCollectionStep.EDIT_INFO, 0, 191, null);
    L10:
        if (r14.a(r1, r2) == false) goto L6;
    }

    public final void closePage() {
        ae<com.obric.memorydata.memory.ui.automemory.create.b> r14 = this._state;
    L3:
        com.obric.memorydata.memory.ui.automemory.create.b r0 = r14.c();
        if (r14.a(r0, com.obric.memorydata.memory.ui.automemory.create.b.a((com.obric.memorydata.memory.ui.automemory.create.b) ZeusTransformUtils.preCheckCast(r0, com.obric.memorydata.memory.ui.automemory.create.b.class, "com.obric.memorydata.plugin"), 0, null, null, false, null, null, AutoMemoryCreateCollectionStep.CLOSE, 0, 191, null)) == false) goto L3;
    }

    public final ai<Unit> getExitRequest() {
        return this.exitRequest;
    }

    public final ar<com.obric.memorydata.memory.ui.automemory.create.b> getState() {
        return this.state;
    }

    public final boolean hasUnsavedContent() {
        return !StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(((com.obric.memorydata.memory.ui.automemory.create.b) ZeusTransformUtils.preCheckCast(this._state.c(), com.obric.memorydata.memory.ui.automemory.create.b.class, "com.obric.memorydata.plugin")).c(), CharSequence.class, "com.obric.memorydata.plugin"));
    }

    public final void initState(long r20, String r22, String r23, boolean r24, String r25, String r26) {
        Intrinsics.checkNotNullParameter(r22, "title");
        Intrinsics.checkNotNullParameter(r23, "content");
        Intrinsics.checkNotNullParameter(r25, "iconKey");
        Intrinsics.checkNotNullParameter(r26, "iconColorKey");
        ae<com.obric.memorydata.memory.ui.automemory.create.b> r1 = this._state;
    L3:
        com.obric.memorydata.memory.ui.automemory.create.b r12 = r1.c();
        if (r1.a(r12, com.obric.memorydata.memory.ui.automemory.create.b.a((com.obric.memorydata.memory.ui.automemory.create.b) ZeusTransformUtils.preCheckCast(r12, com.obric.memorydata.memory.ui.automemory.create.b.class, "com.obric.memorydata.plugin"), r20, StringsKt.take(r22, 8), r23, r24, r25, r26, null, 0, 192, null)) == false) goto L3;
    }

    public final void nextToTaskSettings(Function1<? super String, Unit> r21) {
        Function1 r1 = (Function1) ZeusTransformUtils.wrapperContextForParams(r21, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "onReady");
        if (h.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")) == true) goto L6;
        j.a($$Lambda$AutoMemoryCreateCollectionViewModel$952Q_MOKN77fsmZf1wncfIu1kX0.INSTANCE);
        return;
    L6:
        com.obric.memorydata.memory.ui.automemory.create.b r3 = (com.obric.memorydata.memory.ui.automemory.create.b) ZeusTransformUtils.preCheckCast(this._state.c(), com.obric.memorydata.memory.ui.automemory.create.b.class, "com.obric.memorydata.plugin");
        if (r3.g() == AutoMemoryCreateCollectionStep.EDIT_INFO) goto L9;
        return;
    L9:
        if (r3.i() == false) goto L29;
        bx r4 = this.generateAppsJob;
        boolean r5 = false;
        if (r4 != null) goto L14;
    L16:
        if (r5 == false) goto L18;
        return;
    L18:
        ae<com.obric.memorydata.memory.ui.automemory.create.b> r6 = this._state;
    L19:
        com.obric.memorydata.memory.ui.automemory.create.b r7 = r6.c();
        if (r6.a(r7, com.obric.memorydata.memory.ui.automemory.create.b.a((com.obric.memorydata.memory.ui.automemory.create.b) ZeusTransformUtils.preCheckCast(r7, com.obric.memorydata.memory.ui.automemory.create.b.class, "com.obric.memorydata.plugin"), 0, null, null, false, null, null, AutoMemoryCreateCollectionStep.GENERATE_RECOMMEND_APP, 0, 191, null)) == false) goto L19;
        bx r8 = this.generateAppsJob;
        if (r8 == null) goto L24;
        bx.a.a(r8, null, 1, null);
    L24:
        this.generateAppsJob = i.a(ViewModelKt.getViewModelScope((ViewModel) ZeusTransformUtils.preCheckCast(this, ViewModel.class, "com.obric.memorydata.plugin")), null, null, (Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass3(r3, this, r1, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
        return;
    L14:
        if (r4.a() != true) goto L16;
        r5 = true;
        goto L16
    }

    public final void onContentChanged(String r15) {
        Intrinsics.checkNotNullParameter(r15, "content");
        ae<com.obric.memorydata.memory.ui.automemory.create.b> r14 = this._state;
    L3:
        com.obric.memorydata.memory.ui.automemory.create.b r0 = r14.c();
        if (r14.a(r0, com.obric.memorydata.memory.ui.automemory.create.b.a((com.obric.memorydata.memory.ui.automemory.create.b) ZeusTransformUtils.preCheckCast(r0, com.obric.memorydata.memory.ui.automemory.create.b.class, "com.obric.memorydata.plugin"), 0, null, r15, false, null, null, null, 0, 251, null)) == false) goto L3;
    }

    public final void onNameChanged(String r15) {
        Intrinsics.checkNotNullParameter(r15, ActivityLifecycle.NAME);
        ae<com.obric.memorydata.memory.ui.automemory.create.b> r14 = this._state;
    L3:
        com.obric.memorydata.memory.ui.automemory.create.b r0 = r14.c();
        if (r14.a(r0, com.obric.memorydata.memory.ui.automemory.create.b.a((com.obric.memorydata.memory.ui.automemory.create.b) ZeusTransformUtils.preCheckCast(r0, com.obric.memorydata.memory.ui.automemory.create.b.class, "com.obric.memorydata.plugin"), 0, StringsKt.take(r15, 8), null, false, null, null, null, 0, 253, null)) == false) goto L3;
    }

    public final void onUseClientModelChanged(boolean r15) {
        ae<com.obric.memorydata.memory.ui.automemory.create.b> r14 = this._state;
    L3:
        com.obric.memorydata.memory.ui.automemory.create.b r0 = r14.c();
        if (r14.a(r0, com.obric.memorydata.memory.ui.automemory.create.b.a((com.obric.memorydata.memory.ui.automemory.create.b) ZeusTransformUtils.preCheckCast(r0, com.obric.memorydata.memory.ui.automemory.create.b.class, "com.obric.memorydata.plugin"), 0, null, null, r15, null, null, null, 0, 247, null)) == false) goto L3;
    }

    public final void requestExit() {
        this._exitRequest.a(Unit.INSTANCE);
    }

    public final void resetState() {
        bx r0 = this.aiOptimizeJob;
        if (r0 == null) goto L5;
        bx.a.a(r0, null, 1, null);
    L5:
        bx r1 = this.generateAppsJob;
        if (r1 == null) goto L8;
        bx.a.a(r1, null, 1, null);
    L8:
        this.aiOptimizeJob = null;
        this.generateAppsJob = null;
        this._state.b(buildInitialState());
    }

    public final void startAiOptimize() {
        if (((com.obric.memorydata.memory.ui.automemory.create.b) ZeusTransformUtils.preCheckCast(this._state.c(), com.obric.memorydata.memory.ui.automemory.create.b.class, "com.obric.memorydata.plugin")).g() == AutoMemoryCreateCollectionStep.EDIT_INFO) goto L5;
        return;
    L5:
        bx r1 = this.aiOptimizeJob;
        if (r1 == null) goto L8;
        bx.a.a(r1, null, 1, null);
    L8:
        ae<com.obric.memorydata.memory.ui.automemory.create.b> r2 = this._state;
    L9:
        com.obric.memorydata.memory.ui.automemory.create.b r4 = r2.c();
        if (r2.a(r4, com.obric.memorydata.memory.ui.automemory.create.b.a((com.obric.memorydata.memory.ui.automemory.create.b) ZeusTransformUtils.preCheckCast(r4, com.obric.memorydata.memory.ui.automemory.create.b.class, "com.obric.memorydata.plugin"), 0, null, null, false, null, null, AutoMemoryCreateCollectionStep.AI_OPTIMIZING, 0, 191, null)) == false) goto L9;
        this.aiOptimizeJob = i.a(ViewModelKt.getViewModelScope((ViewModel) ZeusTransformUtils.preCheckCast(this, ViewModel.class, "com.obric.memorydata.plugin")), null, null, (Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass2(this, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
    }

    public final void updateContent(String r17, String r18) {
        Intrinsics.checkNotNullParameter(r17, ActivityLifecycle.NAME);
        Intrinsics.checkNotNullParameter(r18, "content");
        ae<com.obric.memorydata.memory.ui.automemory.create.b> r1 = this._state;
    L3:
        com.obric.memorydata.memory.ui.automemory.create.b r15 = r1.c();
        if (r1.a(r15, com.obric.memorydata.memory.ui.automemory.create.b.a((com.obric.memorydata.memory.ui.automemory.create.b) ZeusTransformUtils.preCheckCast(r15, com.obric.memorydata.memory.ui.automemory.create.b.class, "com.obric.memorydata.plugin"), 0, StringsKt.take(r17, 8), r18, false, null, null, AutoMemoryCreateCollectionStep.EDIT_INFO, 0, 185, null)) == false) goto L3;
    }

    public final void updateImeBottom(int r15) {
        ae<com.obric.memorydata.memory.ui.automemory.create.b> r14 = this._state;
    L3:
        com.obric.memorydata.memory.ui.automemory.create.b r0 = r14.c();
        if (r14.a(r0, com.obric.memorydata.memory.ui.automemory.create.b.a((com.obric.memorydata.memory.ui.automemory.create.b) ZeusTransformUtils.preCheckCast(r0, com.obric.memorydata.memory.ui.automemory.create.b.class, "com.obric.memorydata.plugin"), 0, null, null, false, null, null, null, r15, 127, null)) == false) goto L3;
    }
}
