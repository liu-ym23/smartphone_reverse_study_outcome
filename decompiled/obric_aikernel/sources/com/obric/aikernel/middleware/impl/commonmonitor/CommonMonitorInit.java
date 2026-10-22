package com.obric.aikernel.middleware.impl.commonmonitor;

import androidx.work.WorkRequest;
import c0.c;
import com.bytedance.apm.b;
import com.bytedance.apm.core.IDynamicParams;
import com.bytedance.apm6.consumer.slardar.LogReporter;
import com.bytedance.framwork.core.sdklib.apm6.LogReportController;
import com.bytedance.framwork.core.sdkmonitor.SDKMonitor;
import com.bytedance.framwork.core.sdkmonitor.g;
import com.bytedance.memory.MemoryWidget;
import com.bytedance.memory.model.MemoryWidgetConfig;
import com.obric.aikernel.middleware.api.appcontext.AppContext;
import com.obric.aikernel.middleware.api.appcontext.receiver.e;
import com.obric.aikernel.middleware.api.commonmonitor.ICommonMonitorInit;
import com.obric.aikernel.middleware.api.log.AIKLog;
import com.obric.aikernel.middleware.api.network.NetworkAllowState;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.KotlinNothingValueException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.flow.d;
import kotlinx.coroutines.flow.p1;
import kotlinx.coroutines.h;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.m0;
import kotlinx.coroutines.z0;

/* JADX INFO: loaded from: classes2.dex */
public final class CommonMonitorInit implements ICommonMonitorInit {
    public static final a Companion = null;
    private static final String TAG = "CommonMonitorInit";

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.obric.aikernel.middleware.impl.commonmonitor.CommonMonitorInit$initApm$1, reason: invalid class name */
    @DebugMetadata(c = "com.obric.aikernel.middleware.impl.commonmonitor.CommonMonitorInit$initApm$1", f = "CommonMonitorInit.kt", i = {}, l = {96}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<l0, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ CommonMonitorInit this$0;

        /* JADX INFO: renamed from: com.obric.aikernel.middleware.impl.commonmonitor.CommonMonitorInit$initApm$1$a */
        public static final class a implements IDynamicParams {
            a() {
            }

            @Override // com.bytedance.apm.core.IDynamicParams
            public Map<String, String> getCommonParams() {
                return new LinkedHashMap();
            }

            @Override // com.bytedance.apm.core.IDynamicParams
            public String getSessionId() {
                return com.bytedance.applog.a.g();
            }

            @Override // com.bytedance.apm.core.IDynamicParams
            public long getUid() {
                return 0;
            }
        }

        /* JADX INFO: renamed from: com.obric.aikernel.middleware.impl.commonmonitor.CommonMonitorInit$initApm$1$b */
        public static final class b implements e.a {
            b() {
            }

            @Override // com.obric.aikernel.middleware.api.appcontext.receiver.e.a
            public void a() {
                LogReporter.getInstance().resume();
            }

            @Override // com.obric.aikernel.middleware.api.appcontext.receiver.e.a
            public void b() {
                LogReporter.getInstance().pause();
            }
        }

        /* JADX INFO: renamed from: com.obric.aikernel.middleware.impl.commonmonitor.CommonMonitorInit$initApm$1$c */
        static final class c<T> implements d {

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ CommonMonitorInit f4556c;

            c(CommonMonitorInit r10) {
                this.f4556c = r10;
            }

            public final Object a(boolean r10, Continuation<? super Unit> r11) {
                CommonMonitorInit.access$switchNetworkWindowForSlardar(this.f4556c, r10);
                return Unit.INSTANCE;
            }

            @Override // kotlinx.coroutines.flow.d
            public /* bridge */ /* synthetic */ Object emit(Object r10, Continuation r11) {
                return a(((Boolean) r10).booleanValue(), r11);
            }
        }

        AnonymousClass1(CommonMonitorInit r10, Continuation<? super AnonymousClass1> r11) {
            this.this$0 = r10;
            super(2, r11);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
            return new AnonymousClass1(this.this$0, r11);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(l0 r10, Continuation<? super Unit> r11) {
            return invoke2(r10, r11);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(l0 r10, Continuation<? super Unit> r11) {
            return ((AnonymousClass1) create(r10, r11)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r10) {
            Object r11 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r12 = this.label;
            if (r12 == 0) goto L8;
            if (r12 != 1) goto L6;
            ResultKt.throwOnFailure(r10);
        L12:
            throw new KotlinNothingValueException();
        L6:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r10);
            u.c.b r13 = u.c.a();
            MemoryWidgetConfig.Builder r14 = MemoryWidgetConfig.newBuilder();
            AppContext r15 = AppContext.INSTANCE;
            MemoryWidgetConfig r16 = r14.buildDebug(r15.isDebug()).build();
            r13.a(r15.getAid()).b(r15.getVersionName()).f(r15.getChannel()).n(String.valueOf(r15.getUpdateVersionCode())).g(com.bytedance.applog.a.d()).o(true).c(true).d(true).j(false).k(false).p(new MemoryWidget(r16, null)).h(new a()).p(new com.obric.aikernel.middleware.impl.commonmonitor.a()).i(true);
            com.bytedance.apm.b.a().c(r13.e());
            e.f4540a.a(new b());
            p1<Boolean> r17 = NetworkAllowState.INSTANCE.getAllowState();
            c r18 = new c(this.this$0);
            this.label = 1;
            if (r17.a(r18, this) != r11) goto L12;
            return r11;
        }
    }

    static {
        Companion = new a(null);
    }

    public CommonMonitorInit() {
    }

    public static final /* synthetic */ void access$switchNetworkWindowForSlardar(CommonMonitorInit r10, boolean r11) {
        r10.switchNetworkWindowForSlardar(r11);
    }

    private final void switchNetworkWindowForSlardar(boolean r10) {
        AIKLog.INSTANCE.d(TAG, "switchNetworkWindowForSlardar: " + r10);
        if (r10 == false) goto L5;
        int r11 = 1;
    L6:
        LogReportController r12 = LogReportController.getInstance();
        Class<?> r13 = r12.getClass();
        Class<?> r14 = Long.TYPE;
        Method r15 = r13.getDeclaredMethod("delayReport", new Class[]{r14});
        r15.setAccessible(true);
        r15.invoke(r12, new Object[]{Integer.valueOf(r11)});
        com.bytedance.apm6.consumer.slardar.send.LogReportController r16 = com.bytedance.apm6.consumer.slardar.send.LogReportController.getInstance();
        Method r17 = r16.getClass().getDeclaredMethod("delayReport", new Class[]{r14});
        r17.setAccessible(true);
        r17.invoke(r16, new Object[]{Integer.valueOf(r11)});
        SDKMonitor r18 = g.b(String.valueOf(AppContext.INSTANCE.getAid()));
        Field r19 = r18.getClass().getDeclaredField("mLastFetchSettingTime");
        r19.setAccessible(true);
        if (r10 == false) goto L9;
        long r20 = System.currentTimeMillis() - 600000;
    L10:
        r19.set(r18, Long.valueOf(r20));
        return;
    L9:
        r20 = System.currentTimeMillis() + 86400000;
        goto L10
    L5:
        r11 = 86400;
        goto L6
    }

    @Override // com.obric.aikernel.middleware.api.commonmonitor.ICommonMonitorInit
    public void initApm() {
        c r10 = new c.a().c().b().d(WorkRequest.MIN_BACKOFF_MILLIS).a();
        b r11 = b.a();
        AppContext r12 = AppContext.INSTANCE;
        r11.b(r12.getContext(), u.b.a().L(false).G(1100).K(true).I(1000).H(r12.isDebug()).J(r10).F());
        h.d(m0.a(z0.b()), null, null, new AnonymousClass1(this, null), 3, null);
    }
}
