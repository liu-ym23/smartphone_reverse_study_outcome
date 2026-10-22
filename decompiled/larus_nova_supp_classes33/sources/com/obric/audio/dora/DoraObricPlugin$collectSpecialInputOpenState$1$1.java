package com.obric.audio.dora;

import com.larus.im.service.audio.cmd.TriggerMode;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.audio.service.ObricAssistantForAudioDelegate;
import com.obric.assistant.spi.actionbar.IObricActionBarSendService;
import com.obric.capabilitykit.common.ErrorCode;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import id9.d;
import java.util.LinkedHashMap;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.i1;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.audio.dora.DoraObricPlugin$collectSpecialInputOpenState$1$1", f = "DoraObricPlugin.kt", i = {}, l = {ErrorCode.NO_LOGIN}, m = "invokeSuspend", n = {}, s = {})
final class DoraObricPlugin$collectSpecialInputOpenState$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ i1<Boolean> $stateFlow;
    int label;
    final /* synthetic */ DoraObricPlugin this$0;

    public static final class a<T> implements FlowCollector {
        public final /* synthetic */ DoraObricPlugin a;

        public a(DoraObricPlugin r1) {
            this.a = r1;
        }

        public final Object emit(Object r7, Continuation r8) {
            boolean r9 = ((Boolean) r7).booleanValue();
            FLogger r10 = FLogger.a;
            r10.i(this.a.f, "collectSpecialInputOpenState isOpen: " + r9);
            if (r9 == false) goto L23;
            DoraObricPlugin r11 = this.a;
            r11.getClass();
            if (ObricAssistantForAudioDelegate.b.O4() == true) goto L8;
            r10.i(r11.f, "skip updateComplexTaskContext, special input is not open");
        L25:
            return Unit.INSTANCE;
        L8:
            if (r11.i == true) goto L11;
            r10.i(r11.f, "skip updateComplexTaskContext, query has not started");
            goto L25
        L11:
            if (r11.j == false) goto L13;
            r10.i(r11.f, "skip updateComplexTaskContext, current special input open context already sent");
            goto L25
        L13:
            LinkedHashMap r0 = new LinkedHashMap();
            IObricActionBarSendService r1 = (IObricActionBarSendService) ServiceManager.get().getService(IObricActionBarSendService.class);
            if (r1 == null) goto L17;
            r1.i(r0, null);
        L17:
            if (r0.isEmpty() == false) goto L19;
            r10.w(r11.f, "skip updateComplexTaskContext, ext map is empty");
            goto L25
        L19:
            JSONObject r2 = new JSONObject();
            r2.put("round_id", r11.h);
            JSONObject r3 = new JSONObject();
            r3.put("o_complex_task_ctx", new JSONObject(r0).toString());
            Unit r4 = Unit.INSTANCE;
            r2.put("params", r3);
            d r5 = r11.getContext().j();
            if (r5 == null) goto L22;
            r5.p(TriggerMode.UPDATE_ROUND_CONTEXT, r2.toString());
        L22:
            r11.j = true;
            r10.i(r11.f, "trigger updateComplexTaskContext, roundId=" + r11.h + ", extSize=" + r0.size() + ", complexTaskContext=" + r2);
            goto L25
        L23:
            this.a.j = false;
            goto L25
        }
    }

    public DoraObricPlugin$collectSpecialInputOpenState$1$1(i1<Boolean> r1, DoraObricPlugin r2, Continuation<? super DoraObricPlugin$collectSpecialInputOpenState$1$1> r3) {
        this.$stateFlow = r1;
        this.this$0 = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new DoraObricPlugin$collectSpecialInputOpenState$1$1(this.$stateFlow, this.this$0, r4);
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
        i1<Boolean> r6 = this.$stateFlow;
        a r2 = new a(this.this$0);
        this.label = 1;
        if (r6.collect(r2, this) != r0) goto L12;
        return r0;
    }
}
