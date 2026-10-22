package com.obric.aikernel.runtime;

import androidx.core.app.NotificationCompat;
import com.bytedance.apm6.util.constant.NetConst;
import com.bytedance.crash.event.EnsureReportData;
import com.obric.aikernel.middleware.api.traker.ITrackerApi;
import com.obric.aikernel.sdk.config.RequestParams;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.h;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.v1;
import kotlinx.coroutines.y1;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@DebugMetadata(c = "com.obric.aikernel.runtime.VmEngine$vmExecuteRaw$inrWatchDog$1$1", f = "VmEngine.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class VmEngine$vmExecuteRaw$inrWatchDog$1$1 extends SuspendLambda implements Function1<Continuation<? super v1>, Object> {
    final /* synthetic */ String $event;
    final /* synthetic */ long $inrTimeMills;
    final /* synthetic */ RequestParams $params;
    final /* synthetic */ y6.b $pkg;
    int label;
    final /* synthetic */ VmEngine this$0;

    /* JADX INFO: renamed from: com.obric.aikernel.runtime.VmEngine$vmExecuteRaw$inrWatchDog$1$1$1, reason: invalid class name */
    @DebugMetadata(c = "com.obric.aikernel.runtime.VmEngine$vmExecuteRaw$inrWatchDog$1$1$1", f = "VmEngine.kt", i = {}, l = {91}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<l0, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $event;
        final /* synthetic */ long $inrTimeMills;
        final /* synthetic */ RequestParams $params;
        final /* synthetic */ y6.b $pkg;
        int label;
        final /* synthetic */ VmEngine this$0;

        AnonymousClass1(long r10, VmEngine r11, RequestParams r12, y6.b r13, String r14, Continuation<? super AnonymousClass1> r15) {
            this.$inrTimeMills = r10;
            this.this$0 = r11;
            this.$params = r12;
            this.$pkg = r13;
            this.$event = r14;
            super(2, r15);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
            return new AnonymousClass1(this.$inrTimeMills, this.this$0, this.$params, this.$pkg, this.$event, r11);
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
            if (r12 != 1) goto L7;
            ResultKt.throwOnFailure(r10);
        L11:
            AIInferRuntime.c r13 = VmEngine.a(this.this$0).a();
            if (r13 == null) goto L14;
            r13.a(this.$params);
        L14:
            JSONObject r14 = new JSONObject();
            RequestParams r15 = this.$params;
            y6.b r16 = this.$pkg;
            long r17 = this.$inrTimeMills;
            String r18 = this.$event;
            r14.put(ITrackerApi.CALLER_PKG, e8.a.j(r15.getBackend()));
            r14.put("biz", e8.a.e(r15.getBackend()));
            r14.put("version", r16.h());
            r14.put(EnsureReportData.METHOD, e8.a.h(r15.getBackend()));
            r14.put("sdk_ver", e8.a.k(r15.getBackend()));
            r14.put("inr_interval", r17);
            r14.put("trace_id", e8.a.d(r15.getBackend()));
            r14.put(NotificationCompat.CATEGORY_EVENT, r18);
            r14.put("source", "vmExecuteRaw");
            r14.put("trace", e8.a.j(r15.getBackend()));
            r14.put("checktime", String.valueOf(r17 / ((long) 1000)));
            r14.put("slardar", NetConst.ENCRYPT_VERISON_CODE);
            com.obric.aikernel.runtime.utils.d r19 = com.obric.aikernel.runtime.utils.d.f5417a;
            r19.l("VmEngine", "[STUCK_TRACING] inr_events: " + r14);
            r19.b("may_stuck", r14);
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r10);
            long r20 = this.$inrTimeMills;
            this.label = 1;
            if (DelayKt.b(r20, this) != r11) goto L11;
            return r11;
        }
    }

    VmEngine$vmExecuteRaw$inrWatchDog$1$1(VmEngine r10, long r11, RequestParams r12, y6.b r13, String r14, Continuation<? super VmEngine$vmExecuteRaw$inrWatchDog$1$1> r15) {
        this.this$0 = r10;
        this.$inrTimeMills = r11;
        this.$params = r12;
        this.$pkg = r13;
        this.$event = r14;
        super(1, r15);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> r10) {
        return new VmEngine$vmExecuteRaw$inrWatchDog$1$1(this.this$0, this.$inrTimeMills, this.$params, this.$pkg, this.$event, r10);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Object invoke(Continuation<? super v1> r10) {
        return invoke2(r10);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(Continuation<? super v1> r10) {
        return ((VmEngine$vmExecuteRaw$inrWatchDog$1$1) create(r10)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r12) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r12);
        final v1 r13 = h.d(VmEngine.b(this.this$0), null, null, new AnonymousClass1(this.$inrTimeMills, this.this$0, this.$params, this.$pkg, this.$event, null), 3, null);
        y1.i(getContext()).A(new VmEngine$vmExecuteRaw$inrWatchDog$1$1$2$1(r13));
        return r13;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
