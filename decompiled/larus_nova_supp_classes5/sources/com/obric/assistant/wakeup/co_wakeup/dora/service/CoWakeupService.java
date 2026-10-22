package com.obric.assistant.wakeup.co_wakeup.dora.service;

import android.app.Application;
import android.content.Context;
import com.bytedance.keva.Keva;
import com.larus.common.apphost.AppHost;
import com.larus.dora.api.IDoraService;
import com.larus.dora.api.config.IDoraPageConfig;
import com.larus.dora.impl.serviceimpl.DeviceService;
import com.larus.dora.impl.serviceimpl.r;
import com.larus.home.api.main.IPrivacyService;
import com.larus.platform.service.AccountService;
import com.larus.utils.j0;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.wakeup.co_wakeup.dora.CoWakeupApi;
import com.obric.assistant.wakeup.co_wakeup.dora.model.DoraConnectState;
import com.obric.assistant.wakeup.co_wakeup.dora.model.DoraSwitchState;
import com.obric.assistant.wakeup.co_wakeup.dora.model.DoraWearState;
import com.obric.memorydata.sdk.MemoryResponse;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import h49.l;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CancellationException;
import kotlin.KotlinNothingValueException;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.IntCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.j1;
import kotlinx.coroutines.sync.MutexImpl;
import kotlinx.coroutines.w1;
import org.json.JSONObject;
import t39.d;
import t39.n;
import t39.x;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(d1 = {"\u0000§\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001/\b\u0007\u0018\u0000 c2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0001cB\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u00101\u001a\u0002022\u0006\u00103\u001a\u000204H\u0016J\b\u00105\u001a\u000202H\u0016J\u000e\u00109\u001a\b\u0012\u0004\u0012\u0002080:H\u0016J\u000e\u0010;\u001a\u000202H\u0082@¢\u0006\u0002\u0010<J\u001e\u0010=\u001a\u0002022\u0006\u0010>\u001a\u00020\u00112\u0006\u0010?\u001a\u00020\u0015H\u0082@¢\u0006\u0002\u0010@J\b\u0010A\u001a\u000202H\u0002J\u0018\u0010B\u001a\u0002022\u0006\u0010C\u001a\u00020\u001d2\u0006\u0010D\u001a\u00020\u001dH\u0002J\u0018\u0010E\u001a\u0002022\u0006\u0010C\u001a\u00020\u001d2\u0006\u0010F\u001a\u00020\u001dH\u0002J\u0016\u0010G\u001a\u0002022\u0006\u0010H\u001a\u00020\u001dH\u0082@¢\u0006\u0002\u0010IJ\u0010\u0010J\u001a\u0002022\u0006\u0010H\u001a\u00020\u001dH\u0002J\u0018\u0010K\u001a\u00020\u001d2\u0006\u0010L\u001a\u00020\b2\u0006\u0010D\u001a\u00020\u001dH\u0002J$\u0010K\u001a\u00020\u001d2\u0006\u0010L\u001a\u00020\b2\u0006\u0010M\u001a\u00020\b2\n\b\u0002\u0010N\u001a\u0004\u0018\u00010\bH\u0002J\b\u0010O\u001a\u000202H\u0016J\b\u0010P\u001a\u00020\u001dH\u0016J\b\u0010Q\u001a\u00020\u001dH\u0016J\b\u0010R\u001a\u00020\u001dH\u0016J\b\u0010S\u001a\u000202H\u0016J\b\u0010T\u001a\u000202H\u0016J*\u0010U\u001a\u0002022\u0006\u0010V\u001a\u00020W2\u0006\u0010X\u001a\u00020W2\u0006\u0010Y\u001a\u00020\b2\b\u0010Z\u001a\u0004\u0018\u00010\bH\u0016J\u0010\u0010[\u001a\u0002022\u0006\u0010\\\u001a\u00020\u001dH\u0016J \u0010]\u001a\u0002022\u0006\u0010^\u001a\u00020\u001d2\u0006\u0010_\u001a\u00020\u001d2\u0006\u0010`\u001a\u00020aH\u0016J \u0010b\u001a\u0002022\u0006\u0010^\u001a\u00020\u001d2\u0006\u0010_\u001a\u00020\u001d2\u0006\u0010`\u001a\u00020aH\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u0082D¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\u0004\u0018\u00010\f8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u001eR\u0012\u0010\u001f\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u001eR\u0012\u0010 \u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u001eR\u0010\u0010!\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020$X\u0082\u0004¢\u0006\u0002\n\u0000R#\u0010%\u001a\n '*\u0004\u0018\u00010&0&8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b(\u0010)R\u000e\u0010,\u001a\u00020-X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010.\u001a\u00020/X\u0082\u0004¢\u0006\u0004\n\u0002\u00100R\u0014\u00106\u001a\b\u0012\u0004\u0012\u00020807X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006d"}, d2 = {"Lcom/obric/assistant/wakeup/co_wakeup/dora/service/CoWakeupService;", "Lcom/larus/dora/api/IDoraLinkCallback;", "Lcom/larus/dora/api/OnVoiceWakeupStateChangedListener;", "Lcom/larus/dora/api/wrapper/IWearStateListener;", "Lcom/obric/assistant/wakeup/co_wakeup/dora/CoWakeupApi;", "<init>", "()V", "TAG", "", "context", "Landroid/content/Context;", "doraApi", "Lcom/larus/dora/api/IDoraService;", "getDoraApi", "()Lcom/larus/dora/api/IDoraService;", "doraConnectStateFlow", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/obric/assistant/wakeup/co_wakeup/dora/model/DoraConnectState;", "doraSwitchStateFlow", "Lcom/obric/assistant/wakeup/co_wakeup/dora/model/DoraSwitchState;", "doraWearStateFlow", "Lcom/obric/assistant/wakeup/co_wakeup/dora/model/DoraWearState;", "eventScope", "Lkotlinx/coroutines/CoroutineScope;", "collectScope", "jobs", "", "Lkotlinx/coroutines/Job;", "lastDoraGConnectionState", "", "Ljava/lang/Boolean;", "lastDoraGReadyState", "lastEnvironmentMemoryEnabled", "lastEnvironmentTimerSettings", "hasLoggedGlassesProductIdReadFailure", "memoryNotifyMutex", "Lkotlinx/coroutines/sync/Mutex;", "doraSettingsStore", "Lcom/bytedance/keva/Keva;", "kotlin.jvm.PlatformType", "getDoraSettingsStore", "()Lcom/bytedance/keva/Keva;", "doraSettingsStore$delegate", "Lkotlin/Lazy;", "timerConfigChangeListener", "Lcom/bytedance/keva/Keva$OnChangeListener;", "envObserveChangeListener", "com/obric/assistant/wakeup/co_wakeup/dora/service/CoWakeupService$envObserveChangeListener$1", "Lcom/obric/assistant/wakeup/co_wakeup/dora/service/CoWakeupService$envObserveChangeListener$1;", "init", "", "ctx", "Landroid/app/Application;", "reload", "coWakeupSharedFlow", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lcom/obric/assistant/wakeup/co_wakeup/dora/event/CoWakeupEvent;", "sharedEventFlow", "Lkotlinx/coroutines/flow/SharedFlow;", "notifyChanged", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "notifyDoraGStatesForMemory", "connect", "wear", "(Lcom/obric/assistant/wakeup/co_wakeup/dora/model/DoraConnectState;Lcom/obric/assistant/wakeup/co_wakeup/dora/model/DoraWearState;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "notifyGlassesProductIdForMemory", "notifyDoraGConnectionStateForMemory", "isDoraG", "connected", "notifyDoraGReadyStateForMemory", "ready", "notifyEnvironmentMemoryStateForMemory", DBDefinition.FORCE, "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "notifyEnvironmentTimerSettingsForMemory", "notifyMemoryDataGlassesState", "key", "value", "expectedMessage", "release", "isDoraConnected", "isDoraConnectedIgnoreSwitch", "isDoraGWearOn", "start", "stop", "onDoraLinkChanged", "state", "", "productId", "productName", "fwVersion", "onVoiceWakeupStateChanged", "enabled", "onWearStateChanged", "leftOn", "rightOn", "deviceInfo", "Lcom/larus/dora/api/DoraDeviceInfo;", "onWearStateChangedAlwaysNotify", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CoWakeupService implements n, x, l, CoWakeupApi {
    public static final Set<String> r = null;
    public final String a;
    public final StateFlowImpl b;
    public final StateFlowImpl c;
    public final StateFlowImpl d;
    public final CoroutineScope e;
    public final CoroutineScope f;
    public final List<Job> g;
    public Boolean h;
    public Boolean i;
    public Boolean j;
    public String k;
    public boolean l;
    public final MutexImpl m;
    public final Lazy n;
    public final b o;
    public final CoWakeupService$envObserveChangeListener$1 p;
    public final MutableSharedFlow<vha.a> q;

    public static final class a {
    }

    /* JADX INFO: renamed from: com.obric.assistant.wakeup.co_wakeup.dora.service.CoWakeupService$init$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.assistant.wakeup.co_wakeup.dora.service.CoWakeupService$init$1", f = "CoWakeupService.kt", i = {}, l = {104}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ CoWakeupService this$0;

        /* JADX INFO: renamed from: com.obric.assistant.wakeup.co_wakeup.dora.service.CoWakeupService$init$1$a */
        public static final class a<T> implements FlowCollector {
            public final /* synthetic */ CoWakeupService a;

            public a(CoWakeupService r1) {
                this.a = r1;
            }

            public final Object emit(Object r5, Continuation r6) {
                FLogger.a.i(this.a.a, "doraSwitchStateFlow is " + ((DoraSwitchState) r5));
                Object r7 = CoWakeupService.h(this.a, r6);
                if (r7 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
                return r7;
            L6:
                return Unit.INSTANCE;
            }
        }

        public AnonymousClass1(CoWakeupService r1, Continuation<? super AnonymousClass1> r2) {
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

        public final Object invokeSuspend(Object r5) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L6;
            ResultKt.throwOnFailure(r5);
        L12:
            throw new KotlinNothingValueException();
        L6:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r5);
            CoWakeupService r6 = this.this$0;
            StateFlowImpl r2 = r6.c;
            a r3 = new a(r6);
            this.label = 1;
            if (r2.collect(r3, this) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.assistant.wakeup.co_wakeup.dora.service.CoWakeupService$init$3, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.assistant.wakeup.co_wakeup.dora.service.CoWakeupService$init$3", f = "CoWakeupService.kt", i = {}, l = {112}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ CoWakeupService this$0;

        /* JADX INFO: renamed from: com.obric.assistant.wakeup.co_wakeup.dora.service.CoWakeupService$init$3$a */
        public static final class a<T> implements FlowCollector {
            public final /* synthetic */ CoWakeupService a;

            public a(CoWakeupService r1) {
                this.a = r1;
            }

            public final Object emit(Object r5, Continuation r6) {
                FLogger.a.i(this.a.a, "doraConnectState is " + ((DoraConnectState) r5));
                Object r7 = CoWakeupService.h(this.a, r6);
                if (r7 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
                return r7;
            L6:
                return Unit.INSTANCE;
            }
        }

        public AnonymousClass3(CoWakeupService r1, Continuation<? super AnonymousClass3> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new AnonymousClass3(this.this$0, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r5) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L6;
            ResultKt.throwOnFailure(r5);
        L12:
            throw new KotlinNothingValueException();
        L6:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r5);
            CoWakeupService r6 = this.this$0;
            StateFlowImpl r2 = r6.b;
            a r3 = new a(r6);
            this.label = 1;
            if (r2.collect(r3, this) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.assistant.wakeup.co_wakeup.dora.service.CoWakeupService$init$5, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.assistant.wakeup.co_wakeup.dora.service.CoWakeupService$init$5", f = "CoWakeupService.kt", i = {}, l = {120}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass5 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ CoWakeupService this$0;

        /* JADX INFO: renamed from: com.obric.assistant.wakeup.co_wakeup.dora.service.CoWakeupService$init$5$a */
        public static final class a<T> implements FlowCollector {
            public final /* synthetic */ CoWakeupService a;

            public a(CoWakeupService r1) {
                this.a = r1;
            }

            public final Object emit(Object r5, Continuation r6) {
                FLogger.a.i(this.a.a, "doraWearStateFlow is " + ((DoraWearState) r5));
                Object r7 = CoWakeupService.h(this.a, r6);
                if (r7 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
                return r7;
            L6:
                return Unit.INSTANCE;
            }
        }

        public AnonymousClass5(CoWakeupService r1, Continuation<? super AnonymousClass5> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new AnonymousClass5(this.this$0, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r5) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L6;
            ResultKt.throwOnFailure(r5);
        L12:
            throw new KotlinNothingValueException();
        L6:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r5);
            CoWakeupService r6 = this.this$0;
            StateFlowImpl r2 = r6.d;
            a r3 = new a(r6);
            this.label = 1;
            if (r2.collect(r3, this) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.assistant.wakeup.co_wakeup.dora.service.CoWakeupService$reload$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.assistant.wakeup.co_wakeup.dora.service.CoWakeupService$reload$1", f = "CoWakeupService.kt", i = {}, l = {131, 132}, m = "invokeSuspend", n = {}, s = {})
    public static final class C00391 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ CoWakeupService this$0;

        public C00391(CoWakeupService r1, Continuation<? super C00391> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new C00391(this.this$0, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r5) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L10;
            if (r1 == 1) goto L9;
            if (r1 != 2) goto L8;
            ResultKt.throwOnFailure(r5);
        L17:
            return Unit.INSTANCE;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            ResultKt.throwOnFailure(r5);
        L13:
            CoWakeupService r6 = this.this$0;
            this.label = 2;
            if (CoWakeupService.i(r6, true, this) != r0) goto L17;
            return r0;
        L10:
            ResultKt.throwOnFailure(r5);
            CoWakeupService r7 = this.this$0;
            this.label = 1;
            if (CoWakeupService.h(r7, this) != r0) goto L13;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.assistant.wakeup.co_wakeup.dora.service.CoWakeupService$start$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.assistant.wakeup.co_wakeup.dora.service.CoWakeupService$start$1", f = "CoWakeupService.kt", i = {}, l = {387}, m = "invokeSuspend", n = {}, s = {})
    public static final class C00401 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ boolean $connected;
        int label;
        final /* synthetic */ CoWakeupService this$0;

        public C00401(CoWakeupService r1, boolean r2, Continuation<? super C00401> r3) {
            this.this$0 = r1;
            this.$connected = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new C00401(this.this$0, this.$connected, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r4) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r4);
        L16:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r4);
            StateFlowImpl r5 = this.this$0.b;
            if (this.$connected == false) goto L11;
            DoraConnectState r2 = DoraConnectState.CONNECTED;
        L12:
            this.label = 1;
            r5.setValue(r2);
            if (Unit.INSTANCE != r0) goto L16;
            return r0;
        L11:
            r2 = DoraConnectState.NOT_CONNECTED;
            goto L12
        }
    }

    /* JADX INFO: renamed from: com.obric.assistant.wakeup.co_wakeup.dora.service.CoWakeupService$start$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.assistant.wakeup.co_wakeup.dora.service.CoWakeupService$start$2", f = "CoWakeupService.kt", i = {}, l = {392}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ boolean $switchState;
        int label;
        final /* synthetic */ CoWakeupService this$0;

        public AnonymousClass2(CoWakeupService r1, boolean r2, Continuation<? super AnonymousClass2> r3) {
            this.this$0 = r1;
            this.$switchState = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new AnonymousClass2(this.this$0, this.$switchState, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r4) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r4);
        L16:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r4);
            StateFlowImpl r5 = this.this$0.c;
            if (this.$switchState == false) goto L11;
            DoraSwitchState r2 = DoraSwitchState.ON;
        L12:
            this.label = 1;
            r5.setValue(r2);
            if (Unit.INSTANCE != r0) goto L16;
            return r0;
        L11:
            r2 = DoraSwitchState.OFF;
            goto L12
        }
    }

    /* JADX INFO: renamed from: com.obric.assistant.wakeup.co_wakeup.dora.service.CoWakeupService$start$3, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.assistant.wakeup.co_wakeup.dora.service.CoWakeupService$start$3", f = "CoWakeupService.kt", i = {}, l = {397}, m = "invokeSuspend", n = {}, s = {})
    public static final class C00413 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ boolean $wearState;
        int label;
        final /* synthetic */ CoWakeupService this$0;

        public C00413(CoWakeupService r1, boolean r2, Continuation<? super C00413> r3) {
            this.this$0 = r1;
            this.$wearState = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new C00413(this.this$0, this.$wearState, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r4) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r4);
        L16:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r4);
            StateFlowImpl r5 = this.this$0.d;
            if (this.$wearState == false) goto L11;
            DoraWearState r2 = DoraWearState.ON;
        L12:
            this.label = 1;
            r5.setValue(r2);
            if (Unit.INSTANCE != r0) goto L16;
            return r0;
        L11:
            r2 = DoraWearState.OFF;
            goto L12
        }
    }

    /* JADX INFO: renamed from: com.obric.assistant.wakeup.co_wakeup.dora.service.CoWakeupService$start$4, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.assistant.wakeup.co_wakeup.dora.service.CoWakeupService$start$4", f = "CoWakeupService.kt", i = {}, l = {406}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass4 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ CoWakeupService this$0;

        public AnonymousClass4(CoWakeupService r1, Continuation<? super AnonymousClass4> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new AnonymousClass4(this.this$0, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r4) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r4);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r4);
            CoWakeupService r5 = this.this$0;
            this.label = 1;
            if (CoWakeupService.i(r5, true, this) != r0) goto L12;
            return r0;
        }
    }

    public final void g(boolean r1, boolean r2, d r3) {
        Intrinsics.checkNotNullParameter(r3, "deviceInfo");
    }

    static {
        r = SetsKt.setOf(new String[]{"dora_g_config_key_env_observe_timer_enable", "dora_g_config_key_env_observe_timer_start", "dora_g_config_key_env_observe_timer_end"});
    }

    public static IDoraService j() {
        return (IDoraService) ServiceManager.get().getService(IDoraService.class);
    }

    @Override // com.obric.assistant.wakeup.co_wakeup.dora.CoWakeupApi
    public final boolean b() {
        if (((DoraConnectState) this.b.getValue()) != DoraConnectState.CONNECTED) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.assistant.wakeup.co_wakeup.dora.CoWakeupApi
    public final boolean c() {
        IDoraService r0 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r0 == null) goto L5;
        DeviceService r1 = r0.device();
    L6:
        if (r1 == null) goto L10;
        boolean r2 = true;
        if (r1.S() != true) goto L10;
    L11:
        FLogger.a.i(this.a, "isDoraGWearOn? " + r2 + ", doraDeviceService = " + r1);
        return r2;
    L10:
        r2 = false;
        goto L11
    L5:
        r1 = null;
        goto L6
    }

    @Override // com.obric.assistant.wakeup.co_wakeup.dora.CoWakeupApi
    public final boolean isDoraConnected() {
        DoraSwitchState r0 = (DoraSwitchState) this.c.getValue();
        DoraConnectState r1 = (DoraConnectState) this.b.getValue();
        if (r0 == DoraSwitchState.ON) goto L5;
    L7:
        return false;
    L5:
        if (r1 != DoraConnectState.CONNECTED) goto L7;
        return true;
    }

    public final void o() {
        IDoraService r4 = j();     // Catch: RuntimeException -> L29 CancellationException -> L33
        if (r4 == null) goto L6;
        DeviceService r5 = r4.device();     // Catch: RuntimeException -> L29 CancellationException -> L33
    L7:
        boolean r6 = false;
        if (r5 != null) goto L10;
    L12:
        boolean r7 = false;
    L13:
        if (r7 == false) goto L15;
        int r8 = r5.y();     // Catch: RuntimeException -> L29 CancellationException -> L33
    L16:
        this.l = false;     // Catch: RuntimeException -> L29 CancellationException -> L33
        Integer r9 = Integer.valueOf(r8);     // Catch: RuntimeException -> L29 CancellationException -> L33
        if (r9.intValue() <= 0) goto L19;
        r6 = true;
    L19:
        if (r6 == true) goto L22;
        r9 = null;
    L22:
        if (r9 == null) goto L24;
        String r10 = r9.toString();     // Catch: RuntimeException -> L29 CancellationException -> L33
    L25:
        if (r10 != null) goto L27;
        r10 = "";
    L27:
        p("glasses_product_id", r10, null);     // Catch: RuntimeException -> L29 CancellationException -> L33
    L38:
        return;
    L24:
        r10 = null;
        goto L25
    L15:
        r8 = -1;
        goto L16
    L10:
        if (r5.J() != true) goto L12;
        r7 = true;
        goto L13
    L6:
        r5 = null;
    L33:
        e = move-exception;
        throw e;
    L29:
        p("glasses_product_id", "", null);
        if (this.l == true) goto L37;
        this.l = true;
        FLogger.a.w(this.a, "read glasses product id failed");
        return;
    }

    /* JADX WARN: Type inference failed for: r2v8, types: [com.obric.assistant.wakeup.co_wakeup.dora.service.b] */
    /* JADX WARN: Type inference failed for: r2v9, types: [com.obric.assistant.wakeup.co_wakeup.dora.service.CoWakeupService$envObserveChangeListener$1] */
    public CoWakeupService() {
        this.a = "CoWakeupService";
        this.b = j1.a(DoraConnectState.NA);
        this.c = j1.a(DoraSwitchState.NA);
        this.d = j1.a(DoraWearState.NA);
        this.e = CoroutineScopeKt.CoroutineScope(w1.a(1, "eventScope").plus(SupervisorKt.SupervisorJob$default(null, 1, null)));
        this.f = CoroutineScopeKt.CoroutineScope(w1.a(5, "collectScope").plus(SupervisorKt.SupervisorJob$default(null, 1, null)));
        this.g = new ArrayList();
        this.m = kotlinx.coroutines.sync.b.a();
        this.n = LazyKt.lazy(new com.obric.assistant.wakeup.co_wakeup.dora.service.a());
        this.o = new b(this);
        this.p = new CoWakeupService$envObserveChangeListener$1(this);
        this.q = SharedFlowKt.MutableSharedFlow(1, 5, BufferOverflow.SUSPEND);
    }

    @Override // com.obric.assistant.wakeup.co_wakeup.dora.CoWakeupApi
    public final void reload() {
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO().plus(SupervisorKt.SupervisorJob$default(null, 1, null))), null, null, new C00391(this, null), 3, null);
    }

    @Override // com.obric.assistant.wakeup.co_wakeup.dora.CoWakeupApi
    public final void start() {
        IDoraService r0 = j();
        boolean r1 = false;
        if (r0 == null) goto L7;
        DeviceService r2 = r0.device();
        if (r2 == null) goto L7;
        boolean r3 = r2.J();
    L8:
        FLogger r4 = FLogger.a;
        r4.i(this.a, "dora connect state connect?? " + r3);
        BuildersKt.launch$default(this.e, null, null, new C00401(this, r3, null), 3, null);
        IDoraService r5 = j();
        if (r5 == null) goto L11;
        boolean r6 = r5.b();
    L12:
        r4.i(this.a, "dora switch state is on ?? " + r6);
        BuildersKt.launch$default(this.e, null, null, new AnonymousClass2(this, r6, null), 3, null);
        IDoraService r7 = j();
        if (r7 == null) goto L19;
        DeviceService r8 = r7.device();
        if (r8 == null) goto L19;
        if (r8.S() != true) goto L19;
        boolean r9 = true;
    L20:
        if (r9 == true) goto L39;
        IDoraService r10 = j();
        if (r10 == null) goto L28;
        DeviceService r11 = r10.device();
        if (r11 == null) goto L28;
        if (r11.e(0) != true) goto L28;
        boolean r12 = true;
    L29:
        if (r12 == true) goto L39;
        IDoraService r13 = j();
        if (r13 == null) goto L37;
        DeviceService r14 = r13.device();
        if (r14 == null) goto L37;
        if (r14.e(1) != true) goto L37;
        boolean r15 = true;
    L38:
        if (r15 == true) goto L39;
    L40:
        r4.i(this.a, "dora switch state is on ?? " + r6);
        BuildersKt.launch$default(this.e, null, null, new C00413(this, r1, null), 3, null);
        IDoraService r16 = j();
        if (r16 == null) goto L43;
        r16.G(this);
    L43:
        IDoraService r17 = j();
        if (r17 == null) goto L46;
        r17.W(this);
    L46:
        IDoraService r18 = j();
        if (r18 == null) goto L51;
        DeviceService r19 = r18.device();
        if (r19 == null) goto L51;
        r19.v0(this);
    L51:
        IDoraService r20 = j();
        if (r20 == null) goto L56;
        r r21 = r20.g1();
        if (r21 == null) goto L56;
        r21.a(this.p);
    L56:
        ((Keva) this.n.getValue()).registerChangeListener(this.o);
        BuildersKt.launch$default(this.e, null, null, new AnonymousClass4(this, null), 3, null);
        return;
    L37:
        r15 = false;
    L28:
        r12 = false;
    L39:
        r1 = true;
    L19:
        r9 = false;
        goto L20
    L11:
        r6 = false;
    L7:
        r3 = false;
        goto L8
    }

    @Override // com.obric.assistant.wakeup.co_wakeup.dora.CoWakeupApi
    public final MutableSharedFlow d() {
        return this.q;
    }

    public final void a(boolean r7) {
        BuildersKt.launch$default(this.e, null, null, new onVoiceWakeupStateChanged.1(this, r7, null), 3, null);
    }

    @Override // com.obric.assistant.wakeup.co_wakeup.dora.CoWakeupApi
    public final void init(Application r9) {
        Intrinsics.checkNotNullParameter(r9, "ctx");
        FLogger.a.i(this.a, "init");
        Job r0 = BuildersKt.launch$default(this.f, null, null, new AnonymousClass1(this, null), 3, null);
        ((ArrayList) this.g).add(r0);
        Job r1 = BuildersKt.launch$default(this.f, null, null, new AnonymousClass3(this, null), 3, null);
        ((ArrayList) this.g).add(r1);
        Job r10 = BuildersKt.launch$default(this.f, null, null, new AnonymousClass5(this, null), 3, null);
        ((ArrayList) this.g).add(r10);
    }

    public final void n(boolean r11) {
        IDoraPageConfig r0 = (IDoraPageConfig) ServiceManager.get().getService(IDoraPageConfig.class);
        if (r0 != null) goto L5;
        return;
    L5:
        AccountService r1 = AccountService.a;
        String r2 = r1.getUserId();
        Long r3 = StringsKt.toLongOrNull(r2);
        if (r3 == null) goto L13;
        long r5 = r3.longValue();
        boolean r4 = true;
        if (r5 <= 0) goto L10;
        boolean r6 = true;
    L11:
        if (r6 != true) goto L13;
    L14:
        if (r4 == true) goto L16;
        return;
    L16:
        boolean r7 = r0.d("dora_g_config_key_env_observe_timer_enable", false);
        int r8 = j0.a;
        String r9 = r0.f("dora_g_config_key_env_observe_timer_start", j0.e("larus_dora_environmental_observation_time_range_default_start_time_cn"));
        String r10 = r0.f("dora_g_config_key_env_observe_timer_end", j0.e("larus_dora_environmental_observation_time_range_default_end_time_cn"));
        if (Intrinsics.areEqual(r1.getUserId(), r2) == true) goto L19;
        return;
    L19:
        JSONObject r12 = new JSONObject();
        r12.put("user_id", r2);
        r12.put("enabled", r7);
        r12.put("start", r9);
        r12.put("end", r10);
        String r13 = r12.toString();
        if (r11 == true) goto L25;
        if (Intrinsics.areEqual(this.k, r13) == false) goto L25;
        return;
    L25:
        if (p("glasses_environment_timer_settings", "query_support", "glasses_environment_timer_settings") == true) goto L28;
        return;
    L28:
        if (p("glasses_environment_timer_settings", r13, null) == false) goto L31;
        this.k = r13;
        return;
    L31:
        return;
    L10:
        r6 = false;
    L13:
        r4 = false;
        goto L14
    }

    public static final Object h(CoWakeupService r10, Continuation r11) {
        r10.getClass();
        if ((r11 instanceof CoWakeupService$notifyChanged$1) == false) goto L7;
        CoWakeupService$notifyChanged$1 r0 = (CoWakeupService$notifyChanged$1) r11;
        int r1 = r0.label;
        if ((r1 & IntCompanionObject.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - IntCompanionObject.MIN_VALUE;
    L8:
        Object r12 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L16;
        if (r3 == 1) goto L15;
        if (r3 != 2) goto L14;
        ResultKt.throwOnFailure(r12);
    L24:
        return Unit.INSTANCE;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        DoraWearState r4 = (DoraWearState) r0.L$2;
        DoraConnectState r5 = (DoraConnectState) r0.L$1;
        DoraSwitchState r6 = (DoraSwitchState) r0.L$0;
        ResultKt.throwOnFailure(r12);
    L20:
        MutableSharedFlow<vha.a> r13 = r10.q;
        vha.a.C0032a r14 = new vha.a.C0032a(r6, r5, r4);
        r0.L$0 = null;
        r0.L$1 = null;
        r0.L$2 = null;
        r0.label = 2;
        if (r13.emit(r14, r0) != r2) goto L24;
        return r2;
    L16:
        ResultKt.throwOnFailure(r12);
        r6 = (DoraSwitchState) r10.c.getValue();
        DoraConnectState r15 = (DoraConnectState) r10.b.getValue();
        r4 = (DoraWearState) r10.d.getValue();
        FLogger.a.i(r10.a, "notifyChanged with state switch? " + r6 + " , and connect? " + r15 + ", and wearOn? " + r4);
        r0.L$0 = r6;
        r0.L$1 = r15;
        r0.L$2 = r4;
        r0.label = 1;
        if (r10.m(r15, r4, r0) == r2) goto L25;
        r5 = r15;
        goto L20
    L25:
        return r2;
    L7:
        r0 = new CoWakeupService$notifyChanged$1(r10, r11);
        goto L8
    }

    public final void k(boolean r5, boolean r6) {
        FLogger.a.i(this.a, "notifyDoraGConnectionStateForMemory, isDoraG=" + r5 + ", connected=" + r6 + ", lastState=" + this.h);
        if (r5 == true) goto L8;
        if (this.h != null) goto L8;
        return;
    L8:
        if (Intrinsics.areEqual(this.h, Boolean.valueOf(r6)) == false) goto L10;
        return;
    L10:
        if (r6 == false) goto L12;
        String r7 = "connected";
    L14:
        if (p("glasses_physical_connection_state", r7, null) == false) goto L17;
        this.h = Boolean.valueOf(r6);
        return;
    L17:
        return;
    L12:
        r7 = "disconnected";
        goto L14
    }

    public final void l(boolean r5, boolean r6) {
        FLogger.a.i(this.a, "notifyDoraGReadyStateForMemory, isDoraG=" + r5 + ", ready=" + r6 + ", lastState=" + this.i);
        if (r5 == true) goto L8;
        if (this.i != null) goto L8;
        return;
    L8:
        if (Intrinsics.areEqual(this.i, Boolean.valueOf(r6)) == false) goto L10;
        return;
    L10:
        if (r6 == false) goto L12;
        String r7 = "connected";
    L14:
        if (p("glasses_connected_state", r7, null) == false) goto L17;
        this.i = Boolean.valueOf(r6);
        return;
    L17:
        return;
    L12:
        r7 = "disconnected";
        goto L14
    }

    public static final Object i(CoWakeupService r5, boolean r6, Continuation r7) {
        r5.getClass();
        if ((r7 instanceof CoWakeupService$notifyEnvironmentMemoryStateForMemory$1) == false) goto L7;
        CoWakeupService$notifyEnvironmentMemoryStateForMemory$1 r0 = (CoWakeupService$notifyEnvironmentMemoryStateForMemory$1) r7;
        int r1 = r0.label;
        if ((r1 & IntCompanionObject.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - IntCompanionObject.MIN_VALUE;
    L8:
        Object r8 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        boolean r4 = true;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        r6 = r0.Z$0;
        kotlinx.coroutines.sync.a r9 = (kotlinx.coroutines.sync.a) r0.L$0;
        ResultKt.throwOnFailure(r8);
    L66:
        IPrivacyService r10 = (IPrivacyService) ServiceManager.get().getService(IPrivacyService.class);     // Catch: Throwable -> L63
        if (r10 != null) goto L21;
    L23:
        boolean r11 = false;
    L24:
        if (r11 == false) goto L59;
        r5.o();     // Catch: Throwable -> L63
        r5.n(r6);     // Catch: RuntimeException -> L54 CancellationException -> L56 Throwable -> L63
        IDoraService r12 = j();     // Catch: RuntimeException -> L54 CancellationException -> L56 Throwable -> L63
        if (r12 == null) goto L59;
        r r13 = r12.g1();     // Catch: RuntimeException -> L54 CancellationException -> L56 Throwable -> L63
        if (r13 == null) goto L59;
        boolean r14 = r13.b();     // Catch: RuntimeException -> L54 CancellationException -> L56 Throwable -> L63
        if (r6 == true) goto L41;
        Boolean r15 = r5.j;     // Catch: RuntimeException -> L54 CancellationException -> L56 Throwable -> L63
        if (r14 == false) goto L36;
        boolean r16 = true;
    L38:
        if (Intrinsics.areEqual(r15, Boxing.boxBoolean(r16)) == false) goto L41;
    L36:
        r16 = false;
    L41:
        if (r14 == false) goto L43;
        boolean r17 = true;
    L44:
        if (r17 == false) goto L46;
        String r18 = "connected";
    L48:
        if (r5.p("glasses_environment_memory_enabled", r18, null) == false) goto L59;
        if (r14 == true) goto L52;
        r4 = false;
    L52:
        r5.j = Boxing.boxBoolean(r4);     // Catch: RuntimeException -> L54 CancellationException -> L56 Throwable -> L63
    L46:
        r18 = "disconnected";
        goto L48
    L43:
        r17 = false;
    L56:
        e = move-exception;
        throw e;     // Catch: Throwable -> L63
    L54:
        e = move-exception;
        FLogger.a.e(r5.a, "notify environment memory state failed", e);     // Catch: Throwable -> L63
    L59:
        Unit r19 = Unit.INSTANCE;     // Catch: Throwable -> L63
        r9.unlock(null);
        return Unit.INSTANCE;
    L21:
        if (r10.a() != true) goto L23;
        r11 = true;
    L63:
        th = move-exception;
        r9.unlock(null);
        throw th;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r8);
        kotlinx.coroutines.sync.a r20 = r5.m;
        r0.L$0 = r20;
        r0.Z$0 = r6;
        r0.label = 1;
        if (r20.a(null, r0) == r2) goto L69;
        r9 = r20;
        goto L66
    L69:
        return r2;
    L7:
        r0 = new CoWakeupService$notifyEnvironmentMemoryStateForMemory$1(r5, r7);
        goto L8
    }

    public final void f(boolean r8, boolean r9, d r10) {
        Intrinsics.checkNotNullParameter(r10, "deviceInfo");
        BuildersKt.launch$default(this.e, null, null, new onWearStateChanged.1(this, r8, r9, null), 3, null);
    }

    public final Object m(DoraConnectState r9, DoraWearState r10, Continuation<? super Unit> r11) {
        if ((r11 instanceof CoWakeupService$notifyDoraGStatesForMemory$1) == false) goto L7;
        CoWakeupService$notifyDoraGStatesForMemory$1 r1 = (CoWakeupService$notifyDoraGStatesForMemory$1) r11;
        int r2 = r1.label;
        if ((r2 & IntCompanionObject.MIN_VALUE) == 0) goto L7;
        r1.label = r2 - IntCompanionObject.MIN_VALUE;
    L8:
        Object r12 = r1.result;
        Object r3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r4 = r1.label;
        boolean r5 = true;
        if (r4 == 0) goto L14;
        if (r4 != 1) goto L13;
        kotlinx.coroutines.sync.a r13 = (kotlinx.coroutines.sync.a) r1.L$2;
        r10 = (DoraWearState) r1.L$1;
        DoraConnectState r6 = (DoraConnectState) r1.L$0;
        ResultKt.throwOnFailure(r12);
        kotlinx.coroutines.sync.a r14 = r13;
        r9 = r6;
    L71:
        IPrivacyService r7 = (IPrivacyService) ServiceManager.get().getService(IPrivacyService.class);     // Catch: Throwable -> L68
        if (r7 != null) goto L20;
    L22:
        boolean r8 = false;
    L23:
        if (r8 == true) goto L25;
        FLogger.a.i(this.a, "skip notifying DoraG state before privacy agreed");     // Catch: Throwable -> L68
    L63:
        Unit r15 = Unit.INSTANCE;     // Catch: Throwable -> L68
        r14.unlock(null);
        return Unit.INSTANCE;
    L25:
        o();     // Catch: Throwable -> L68
        IDoraService r16 = j();     // Catch: RuntimeException -> L61 CancellationException -> L66 Throwable -> L68
        if (r16 == null) goto L29;
        DeviceService r17 = r16.device();     // Catch: RuntimeException -> L61 CancellationException -> L66 Throwable -> L68
    L30:
        if (r17 != null) goto L32;
    L34:
        boolean r18 = false;
    L35:
        if (r18 == true) goto L37;
    L45:
        boolean r19 = false;
    L46:
        if (r18 == true) goto L48;
    L50:
        boolean r20 = false;
    L51:
        if (r20 == false) goto L53;
        boolean r21 = true;
    L54:
        k(r18, r21);     // Catch: RuntimeException -> L61 CancellationException -> L66 Throwable -> L68
        if (r20 == false) goto L58;
        if (r19 == false) goto L58;
    L59:
        l(r18, r5);     // Catch: RuntimeException -> L61 CancellationException -> L66 Throwable -> L68
    L58:
        r5 = false;
        goto L59
    L53:
        r21 = false;
        goto L54
    L48:
        if (r9 != DoraConnectState.CONNECTED) goto L50;
        r20 = true;
        goto L51
    L37:
        if (r10 == DoraWearState.ON) goto L44;
        if (r17 != null) goto L40;
    L42:
        boolean r22 = false;
    L43:
        if (r22 == false) goto L45;
    L40:
        if (r17.S() != true) goto L42;
        r22 = true;
    L44:
        r19 = true;
        goto L46
    L32:
        if (r17.M() != true) goto L34;
        r18 = true;
        goto L35
    L29:
        r17 = null;
    L66:
        e = move-exception;
        throw e;     // Catch: Throwable -> L68
    L61:
        e = move-exception;
        FLogger.a.e(this.a, "notifyDoraGStatesForMemory failed, connect=" + r9 + ", wear=" + r10, e);     // Catch: Throwable -> L68
        goto L63
    L20:
        if (r7.a() != true) goto L22;
        r8 = true;
    L68:
        th = move-exception;
        r14.unlock(null);
        throw th;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r12);
        r14 = this.m;
        r1.L$0 = r9;
        r1.L$1 = r10;
        r1.L$2 = r14;
        r1.label = 1;
        if (r14.a(null, r1) != r3) goto L71;
        return r3;
    L7:
        r1 = new CoWakeupService$notifyDoraGStatesForMemory$1(this, r11);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean p(String r10, String r11, String r12) {
        pka.a r1 = pka.a.a;     // Catch: RuntimeException -> L10 CancellationException -> L14
        Context r2 = AppHost.a.getApplication().getApplicationContext();     // Catch: RuntimeException -> L10 CancellationException -> L14
        r1.getClass();     // Catch: RuntimeException -> L10 CancellationException -> L14
        MemoryResponse r13 = pka.a.d(r2, r10, r11);     // Catch: RuntimeException -> L10 CancellationException -> L14
        if (r13.a() == true) goto L6;
        FLogger.a.w(this.a, "notifyMemoryDataGlassesState rejected, key=" + r10 + ", code=" + r13.a);     // Catch: RuntimeException -> L10 CancellationException -> L14
        r10 = r10;
    L16:
    L12:
        return false;
    L6:
        if (r12 == null) goto L9;
        boolean r14 = Intrinsics.areEqual(r13.b, r12);     // Catch: RuntimeException -> L10 CancellationException -> L14
        r10 = r14;
        if (r14 == false) goto L16;
    L9:
        return true;
    L14:
        e = move-exception;
        throw e;
    L10:
        e = move-exception;
        String r15 = ArraysKt.joinToString$default(e.getStackTrace(), "\n", null, null, 8, null, null, 54, null);
        FLogger.a.e(this.a, "notifyMemoryDataGlassesState failed, key=" + r10 + ", error=" + e.getClass().getSimpleName() + ", stack=" + r15);
        goto L12
    }

    public final void e(int r7, int r8, String r9, String r10) {
        Intrinsics.checkNotNullParameter(r9, "productName");
        BuildersKt.launch$default(this.e, null, null, new onDoraLinkChanged.1(r7, this, null), 3, null);
    }
}
