package com.obric.assistant.component.task;

import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.MutableLiveData;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.data.ObricFloatChatPageData;
import com.obric.assistant.data.ObricFloatChatPageState;
import com.obric.assistant.util.m2;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.component.task.ObricTaskCenterComponent$handleBannerLogic$1", f = "ObricTaskCenterComponent.kt", i = {}, l = {144}, m = "invokeSuspend", n = {}, s = {})
final class ObricTaskCenterComponent$handleBannerLogic$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ ObricTaskCenterComponent this$0;

    public ObricTaskCenterComponent$handleBannerLogic$1(ObricTaskCenterComponent r1, Continuation<? super ObricTaskCenterComponent$handleBannerLogic$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new ObricTaskCenterComponent$handleBannerLogic$1(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Type inference failed for: r2v3, types: [com.obric.assistant.component.task.c] */
    public final Object invokeSuspend(Object r6) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        boolean r2 = true;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r6);
    L11:
        FLogger.a.i("ObricTaskCenterComponent", "handleBannerLogic, start");
        ObricTaskCenterComponent r7 = this.this$0;
        int r3 = ObricTaskCenterComponent.z;
        laa.d r8 = r7.p3();
        if (r8 != null) goto L14;
    L16:
        boolean r9 = false;
    L17:
        if (r9 == false) goto L36;
        laa.d r10 = this.this$0.p3();
        if (r10 == null) goto L25;
        ObricFloatChatPageState r11 = r10.getPageState();
        if (r11 == null) goto L25;
        ObricFloatChatPageData.Companion.getClass();
        if ((r11 instanceof vda.a) != true) goto L25;
        boolean r12 = true;
    L26:
        if (r12 == true) goto L36;
        laa.d r13 = this.this$0.p3();
        if (r13 == null) goto L32;
        ObricFloatChatPageState r14 = r13.getPageState();
        if (r14 == null) goto L32;
        int r15 = r14.getHeight();
    L34:
        if (r15 >= (m2.b + 10)) goto L36;
    L37:
        if (r2 == true) goto L41;
        return Unit.INSTANCE;
    L41:
        if (this.this$0.E3() == false) goto L45;
        this.this$0.h3();
        return Unit.INSTANCE;
    L45:
        if (com.obric.assistant.o.a == false) goto L47;
        MutableLiveData r16 = com.obric.assistant.h.a;
        FragmentActivity r4 = s1a.a.getActivity(this.this$0);
        final ObricTaskCenterComponent r5 = this.this$0;
        r16.observe(r4, new ObricTaskCenterComponent.b(new c(r5)));
    L49:
        return Unit.INSTANCE;
    L47:
        ObricTaskCenterComponent.Y2(this.this$0);
    L32:
        r15 = Integer.MAX_VALUE;
    L25:
        r12 = false;
    L36:
        r2 = false;
        goto L37
    L14:
        if (r8.Da() != true) goto L16;
        r9 = true;
        goto L17
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r6);
        this.label = 1;
        if (DelayKt.delay(500, this) != r0) goto L11;
        return r0;
    }
}
