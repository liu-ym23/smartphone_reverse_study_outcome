package com.larus.common.pollingconfig.impl;

import android.os.Build;
import com.larus.common.apphost.AppHost;
import com.larus.network.FlowHttpConnection;
import com.larus.network.bean.BizResponse;
import com.larus.platform.service.g;
import com.larus.platform.service.o;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.common.pollingconfig.impl.PollingConfigImpl$realReport$1", f = "PollingConfigImpl.kt", i = {}, l = {208}, m = "invokeSuspend", n = {}, s = {})
final class PollingConfigImpl$realReport$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $code;
    final /* synthetic */ String $previous;
    final /* synthetic */ int $scene;
    final /* synthetic */ String $version;
    int label;
    final /* synthetic */ PollingConfigImpl this$0;

    /* JADX INFO: renamed from: com.larus.common.pollingconfig.impl.PollingConfigImpl$realReport$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lcom/larus/network/bean/BizResponse;", "", "Lcom/larus/common/pollingconfig/impl/PollingConfigNetworkApi;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.common.pollingconfig.impl.PollingConfigImpl$realReport$1$1", f = "PollingConfigImpl.kt", i = {}, l = {209}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<PollingConfigNetworkApi, Continuation<? super BizResponse<Object>>, Object> {
        final /* synthetic */ int $code;
        final /* synthetic */ String $previous;
        final /* synthetic */ int $scene;
        final /* synthetic */ String $version;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ PollingConfigImpl this$0;

        public AnonymousClass1(PollingConfigImpl r1, int r2, String r3, int r4, String r5, Continuation<? super AnonymousClass1> r6) {
            this.this$0 = r1;
            this.$scene = r2;
            this.$version = r3;
            this.$code = r4;
            this.$previous = r5;
            super(2, r6);
        }

        public final Continuation<Unit> create(Object r9, Continuation<?> r10) {
            AnonymousClass1 r7 = new AnonymousClass1(this.this$0, this.$scene, this.$version, this.$code, this.$previous, r10);
            r7.L$0 = r9;
            return r7;
        }

        public final Object invoke(PollingConfigNetworkApi r1, Continuation<? super BizResponse<Object>> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((PollingConfigNetworkApi) r1, (Continuation) r2);
        }

        public final Object invokeSuspend(Object r20) {
            Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r2 = this.label;
            if (r2 == 0) goto L8;
            if (r2 != 1) goto L7;
            ResultKt.throwOnFailure(r20);
            return r20;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r20);
            PollingConfigNetworkApi r3 = (PollingConfigNetworkApi) this.L$0;
            Long r8 = this.this$0.f;
            String r9 = o.a.getDeviceId();
            int r4 = AppHost.a.getUpdateVersionCode();
            int r5 = Build.VERSION.SDK_INT;
            String r13 = Build.MODEL;
            String r14 = Build.BRAND;
            h r15 = new h(this.$scene, this.$version, r8, r9, Boxing.boxInt(r4), Boxing.boxInt(r5), "android", r13, r14, "obric_pacific", this.$code, this.$previous);
            this.label = 1;
            Object r6 = r3.uploadMetrics(r15, this);
            if (r6 != r1) goto L12;
            return r1;
        L12:
            return r6;
        }
    }

    public PollingConfigImpl$realReport$1(PollingConfigImpl r1, int r2, String r3, int r4, String r5, Continuation<? super PollingConfigImpl$realReport$1> r6) {
        this.this$0 = r1;
        this.$scene = r2;
        this.$version = r3;
        this.$code = r4;
        this.$previous = r5;
        super(2, r6);
    }

    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        return new PollingConfigImpl$realReport$1(this.this$0, this.$scene, this.$version, this.$code, this.$previous, r9);
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
    L11:
        g r14 = g.a;
        JSONObject r2 = new JSONObject();
        PollingConfigImpl r3 = this.this$0;
        int r4 = this.$scene;
        String r5 = this.$version;
        String r6 = this.$previous;
        int r7 = this.$code;
        r2.put("next_polling_interval", r3.f);
        r2.put("polling_scene", r4);
        r2.put("version", r5);
        r2.put("previous_version", r6);
        r2.put("polling_status_code", r7);
        Unit r8 = Unit.INSTANCE;
        r14.monitorEventForSlardar("polling_emit_event", r2, null, null);
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r13);
        PollingConfigNetworkApi.a r15 = PollingConfigNetworkApi.a;
        AnonymousClass1 r9 = new AnonymousClass1(this.this$0, this.$scene, this.$version, this.$code, this.$previous, null);
        this.label = 1;
        r15.getClass();
        FlowHttpConnection r16 = FlowHttpConnection.a;
        if (FlowHttpConnection.g("Basic", PollingConfigNetworkApi.class, r9, false, null, null, null, this, 248) != r0) goto L11;
        return r0;
    }
}
