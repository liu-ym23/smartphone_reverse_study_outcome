package com.larus.bmhome.chat.model.repo;

import android.os.SystemClock;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.larus.bmhome.chat.component.list.p7;
import com.larus.bmhome.chat.component.list.q7;
import com.larus.im.callback.IIMError;
import com.larus.utils.logger.FLogger;
import java.util.Map;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.flow.FlowCollector;
import wi8.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class ChatRepo$observeAckLimit$2<T> implements FlowCollector {
    public final /* synthetic */ Function1<a, Unit> a;
    public final /* synthetic */ ChatRepo b;
    public final /* synthetic */ Function0<a> c;

    public ChatRepo$observeAckLimit$2(q7 r1, ChatRepo r2, p7 r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final Object a(IIMError r18, Continuation<? super Unit> r19) {
        if ((r19 instanceof ChatRepo$observeAckLimit$2$emit$1) == false) goto L7;
        ChatRepo$observeAckLimit$2$emit$1 r2 = (ChatRepo$observeAckLimit$2$emit$1) r19;
        int r3 = r2.label;
        if ((r3 & Integer.MIN_VALUE) == 0) goto L7;
        r2.label = r3 - Integer.MIN_VALUE;
    L8:
        Object r1 = r2.result;
        Object r4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r5 = r2.label;
        if (r5 == 0) goto L16;
        if (r5 == 1) goto L15;
        if (r5 != 2) goto L14;
        ResultKt.throwOnFailure(r1);
    L43:
        return Unit.INSTANCE;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r1);
    L39:
        ChatRepo r6 = this.b;
        Function0<a> r7 = this.c;
        Function1<a, Unit> r8 = this.a;
        r2.label = 2;
        int r9 = ChatRepo.f;
        if (r6.a(r7, r8, r2) != r4) goto L43;
        return r4;
    L16:
        ResultKt.throwOnFailure(r1);
        if (r18 != null) goto L21;
        return Unit.INSTANCE;
    L21:
        if (r18.getCode() != 710022004) goto L45;
        Map r10 = r18.getExt();
        if (r10 == null) goto L27;
        String r11 = (String) r10.get("limit_time");
        if (r11 == null) goto L27;
        long r12 = CastLongProtector.parseLong(r11);
    L29:
        if (r12 <= 0) goto L45;
        FLogger.a.i("ChatRepo", "Limit after ACK for " + r12);
        Function1<a, Unit> r13 = this.a;
        Map r14 = r18.getExt();
        if (r14 == null) goto L33;
        String r15 = (String) r14.get("limit_tips");
    L34:
        if (r15 != null) goto L36;
        r15 = "";
    L36:
        r13.invoke(new a(r15, SystemClock.elapsedRealtime(), r12));
        r2.label = 1;
        if (DelayKt.delay(r12, r2) != r4) goto L39;
        return r4;
    L33:
        r15 = null;
    L27:
        r12 = 0;
    L45:
        return Unit.INSTANCE;
    L7:
        r2 = new ChatRepo$observeAckLimit$2$emit$1(this, r19);
        goto L8
    }

    public final /* bridge */ /* synthetic */ Object emit(Object r1, Continuation r2) {
        return a((IIMError) r1, r2);
    }
}
