package com.bytedance.android.anniex.lite.flow.model;

import com.bytedance.android.anniex.lite.flow.base.d;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.b1;
import kotlinx.coroutines.flow.e;
import kotlinx.coroutines.flow.j1;
import y36.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class PreTaskSchemaModel extends d<pa.a> {
    public final StateFlowImpl b;
    public final StateFlowImpl c;
    public final b1 d;
    public final StateFlowImpl e;
    public final b1 f;

    public PreTaskSchemaModel() {
        Boolean r0 = Boolean.FALSE;
        StateFlowImpl r1 = j1.a(r0);
        this.b = r1;
        e.b(r1);
        StateFlowImpl r10 = j1.a(r0);
        this.c = r10;
        this.d = e.b(r10);
        StateFlowImpl r11 = j1.a(r0);
        this.e = r11;
        this.f = e.b(r11);
    }

    public final Object b(pa.a r10, Continuation<? super Unit> r11) {
        if ((r11 instanceof PreTaskSchemaModel$initWithData$1) == false) goto L7;
        PreTaskSchemaModel$initWithData$1 r0 = (PreTaskSchemaModel$initWithData$1) r11;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r12 = r0.result;
        Object r13 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r14 = r0.label;
        if (r14 == 0) goto L18;
        if (r14 == 1) goto L17;
        if (r14 == 2) goto L16;
        if (r14 != 3) goto L15;
        ResultKt.throwOnFailure(r12);
    L47:
        return Unit.INSTANCE;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        r10 = (pa.a) r0.L$1;
        PreTaskSchemaModel r15 = (PreTaskSchemaModel) r0.L$0;
        ResultKt.throwOnFailure(r12);
    L37:
        i r16 = r10.c;
        if (r16 != null) goto L41;
        Intrinsics.throwUninitializedPropertyAccessException("enableEnginePreload");
        r16 = null;
    L41:
        Boolean r17 = (Boolean) r16.b;
        if (r17 == null) goto L47;
        boolean r18 = r17.booleanValue();
        StateFlowImpl r19 = r15.e;
        Boolean r20 = Boxing.boxBoolean(r18);
        r0.L$0 = null;
        r0.L$1 = null;
        r0.label = 3;
        r19.setValue(r20);
        if (Unit.INSTANCE != r13) goto L47;
        return r13;
    L17:
        r10 = (pa.a) r0.L$1;
        r15 = (PreTaskSchemaModel) r0.L$0;
        ResultKt.throwOnFailure(r12);
    L28:
        i r21 = r10.b;
        if (r21 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("enableModelPreCreate");
        r21 = null;
    L32:
        Boolean r22 = (Boolean) r21.b;
        if (r22 == null) goto L37;
        boolean r23 = r22.booleanValue();
        StateFlowImpl r24 = r15.c;
        Boolean r25 = Boxing.boxBoolean(r23);
        r0.L$0 = r15;
        r0.L$1 = r10;
        r0.label = 2;
        r24.setValue(r25);
        if (Unit.INSTANCE != r13) goto L37;
        return r13;
    L18:
        ResultKt.throwOnFailure(r12);
        i r26 = r10.a;
        if (r26 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("enablePrefetch");
        r26 = null;
    L22:
        Boolean r27 = (Boolean) r26.b;
        if (r27 == null) goto L27;
        boolean r28 = r27.booleanValue();
        StateFlowImpl r29 = this.b;
        Boolean r30 = Boxing.boxBoolean(r28);
        r0.L$0 = this;
        r0.L$1 = r10;
        r0.label = 1;
        r29.setValue(r30);
        if (Unit.INSTANCE != r13) goto L27;
        return r13;
    L27:
        r15 = this;
    L7:
        r0 = new PreTaskSchemaModel$initWithData$1(this, r11);
        goto L8
    }
}
