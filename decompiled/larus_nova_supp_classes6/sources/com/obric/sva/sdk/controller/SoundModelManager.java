package com.obric.sva.sdk.controller;

import android.content.Context;
import com.obric.eventkit.eventstaskmanager.ITaskManager;
import com.obric.sva.sdk.utils.LogUtils;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.w1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u0000  2\u00020\u0001:\u0001 B3\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u000e\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\b¢\u0006\u0004\b\n\u0010\u000bJ\u0006\u0010\u001a\u001a\u00020\u001bJ\u0006\u0010\u001c\u001a\u00020\u0004J\r\u0010\u001d\u001a\u0004\u0018\u00010\u001b¢\u0006\u0002\u0010\u001eJ\u0006\u0010\u001f\u001a\u00020\u001bR\u001d\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/obric/sva/sdk/controller/SoundModelManager;", "", "callback", "Lkotlin/Function1;", "", "context", "Landroid/content/Context;", "extendedSmMgrRetriever", "Lkotlin/Function0;", "Lcom/obric/sva/sdk/controller/ExtendedSmMgr;", "<init>", "(Lkotlin/jvm/functions/Function1;Landroid/content/Context;Lkotlin/jvm/functions/Function0;)V", "getCallback", "()Lkotlin/jvm/functions/Function1;", "getContext", "()Landroid/content/Context;", "getExtendedSmMgrRetriever", "()Lkotlin/jvm/functions/Function0;", "initSmContext", "Lkotlin/coroutines/CoroutineContext;", "initSmScope", "Lkotlinx/coroutines/CoroutineScope;", "deferred", "Lkotlinx/coroutines/Deferred;", "hasDone", "success", "initSoundModelAsync", "", "isCanceled", "cancel", "()Lkotlin/Unit;", "notifyLoad", "Companion", "libs_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
public final class SoundModelManager {
    public static final Companion Companion = null;
    public static final String TAG = "SoundModelManager";
    private final Function1<Boolean, Boolean> callback;
    private final Context context;
    private Deferred<Boolean> deferred;
    private final Function0<ExtendedSmMgr> extendedSmMgrRetriever;
    private boolean hasDone;
    private final CoroutineContext initSmContext;
    private final CoroutineScope initSmScope;
    private boolean success;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/obric/sva/sdk/controller/SoundModelManager$Companion;", "", "<init>", "()V", "TAG", "", "libs_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.obric.sva.sdk.controller.SoundModelManager$initSoundModelAsync$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
    @DebugMetadata(c = "com.obric.sva.sdk.controller.SoundModelManager$initSoundModelAsync$1", f = "SoundModelManager.kt", i = {}, l = {ITaskManager.Stub.TRANSACTION_addEventTask}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ SoundModelManager this$0;

        /* JADX INFO: renamed from: com.obric.sva.sdk.controller.SoundModelManager$initSoundModelAsync$1$1, reason: invalid class name and collision with other inner class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
        @DebugMetadata(c = "com.obric.sva.sdk.controller.SoundModelManager$initSoundModelAsync$1$1", f = "SoundModelManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class C00031 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
            int label;
            final /* synthetic */ SoundModelManager this$0;

            public C00031(SoundModelManager r1, Continuation<? super C00031> r2) {
                this.this$0 = r1;
                super(2, r2);
            }

            public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
                return new C00031(this.this$0, r3);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
                return invoke((CoroutineScope) r1, (Continuation) r2);
            }

            public final Object invoke(CoroutineScope r1, Continuation<? super Boolean> r2) {
                return create(r1, r2).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object r2) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) goto L11;
                ResultKt.throwOnFailure(r2);
                ExtendedSmMgr r3 = (ExtendedSmMgr) this.this$0.getExtendedSmMgrRetriever().invoke();
                if (r3 == null) goto L7;
                Boolean r4 = Boxing.boxBoolean(r3.initSoundModels(this.this$0.getContext().getApplicationContext()));
            L8:
                Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type kotlin.Boolean");
                return r4;
            L7:
                r4 = null;
                goto L8
            L11:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        public AnonymousClass1(SoundModelManager r1, Continuation<? super AnonymousClass1> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new AnonymousClass1(this.this$0, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r13) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r13);
        L18:
            boolean r14 = ((Boolean) r13).booleanValue();
            StringBuilder r2 = new StringBuilder("SoundModelManager completed ");
            Deferred r3 = SoundModelManager.access$getDeferred$p(this.this$0);
            Intrinsics.checkNotNull(r3);
            r2.append(r3.isCompleted());
            r2.append(" , returned is ");
            r2.append(r14);
            r2.append(" and list is ");
            r2.append(Global.getInstance().getExtendedSmMgr().getAllSoundModelList());
            LogUtils.d(SoundModelManager.TAG, r2.toString(), new Object[0]);
            this.this$0.getCallback().invoke(Boxing.boxBoolean(r14));
            Deferred r4 = SoundModelManager.access$getDeferred$p(this.this$0);
            if (r4 == null) goto L21;
            JobKt.cancel$default(r4, "done", null, 2, null);
        L21:
            SoundModelManager.access$setSuccess$p(this.this$0, r14);
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r13);
            LogUtils.d(SoundModelManager.TAG, "SoundModelManager initing ...", new Object[0]);
            Deferred r15 = SoundModelManager.access$getDeferred$p(this.this$0);
            if (r15 == null) goto L11;
            Job.DefaultImpls.cancel$default(r15, null, 1, null);
        L11:
            SoundModelManager r16 = this.this$0;
            SoundModelManager.access$setDeferred$p(r16, BuildersKt.async$default(SoundModelManager.access$getInitSmScope$p(r16), null, null, new C00031(this.this$0, null), 3, null));
            if (SoundModelManager.access$getDeferred$p(this.this$0) == null) goto L14;
            Deferred r17 = SoundModelManager.access$getDeferred$p(this.this$0);
            Intrinsics.checkNotNull(r17);
            this.label = 1;
            r13 = r17.await(this);
            if (r13 != r0) goto L18;
            return r0;
        L14:
            return Unit.INSTANCE;
        }
    }

    static {
        Companion = new Companion(null);
    }

    public final void initSoundModelAsync() {
        this.hasDone = false;
        BuildersKt.runBlocking$default(null, new AnonymousClass1(this, null), 1, null);     // Catch: CancellationException -> L5
        this.hasDone = true;     // Catch: CancellationException -> L5
        return;
    L5:
        e = move-exception;
        LogUtils.d(TAG, "SoundModelManager init canceled: " + e.getMessage(), new Object[0]);
    }

    public final Unit cancel() {
        Deferred<Boolean> r0 = this.deferred;
        if (r0 == null) goto L6;
        JobKt.cancel$default(r0, "manual", null, 2, null);
        return Unit.INSTANCE;
    L6:
        return null;
    }

    public final boolean isCanceled() {
        Deferred<Boolean> r0 = this.deferred;
        if (r0 != null) goto L7;
        return true;
    L7:
        return r0.isCancelled();
    }

    public final void notifyLoad() {
        if (this.hasDone == false) goto L6;
        this.callback.invoke(Boolean.valueOf(this.success));
        return;
    }

    public final Function1<Boolean, Boolean> getCallback() {
        return this.callback;
    }

    public final Context getContext() {
        return this.context;
    }

    public final Function0<ExtendedSmMgr> getExtendedSmMgrRetriever() {
        return this.extendedSmMgrRetriever;
    }

    public static final /* synthetic */ Deferred access$getDeferred$p(SoundModelManager r0) {
        return r0.deferred;
    }

    public static final /* synthetic */ CoroutineScope access$getInitSmScope$p(SoundModelManager r0) {
        return r0.initSmScope;
    }

    public static final /* synthetic */ void access$setDeferred$p(SoundModelManager r0, Deferred r1) {
        r0.deferred = r1;
    }

    public static final /* synthetic */ void access$setSuccess$p(SoundModelManager r0, boolean r1) {
        r0.success = r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SoundModelManager(Function1<? super Boolean, Boolean> r2, Context r3, Function0<? extends ExtendedSmMgr> r4) {
        Intrinsics.checkNotNullParameter(r2, "callback");
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "extendedSmMgrRetriever");
        this.callback = r2;
        this.context = r3;
        this.extendedSmMgrRetriever = r4;
        ExecutorCoroutineDispatcher r5 = w1.a(1, "initSmContext");
        this.initSmContext = r5;
        this.initSmScope = CoroutineScopeKt.CoroutineScope(r5.plus(SupervisorKt.SupervisorJob$default(null, 1, null)));
    }
}
