package com.obric.flow.cardlistpage.data;

import androidx.room.CoroutinesRoom;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.DBUtil;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;

/* JADX INFO: loaded from: classes3.dex */
public abstract class a {
    public static Object a(a r10, Continuation r11) {
        if ((r11 instanceof CardDao$allocateInstanceId$1) == false) goto L7;
        CardDao$allocateInstanceId$1 r5 = (CardDao$allocateInstanceId$1) r11;
        int r12 = r5.label;
        if ((r12 & Integer.MIN_VALUE) == 0) goto L7;
        r5.label = r12 - Integer.MIN_VALUE;
    L8:
        Object r13 = r5.result;
        Object r14 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r15 = r5.label;
        if (r15 == 0) goto L18;
        if (r15 == 1) goto L17;
        if (r15 == 2) goto L16;
        if (r15 != 3) goto L15;
        int r16 = r5.I$0;
        ResultKt.throwOnFailure(r13);
    L33:
        return Boxing.boxInt(r16);
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        r10 = (a) r5.L$0;
        ResultKt.throwOnFailure(r13);
    L24:
        Integer r17 = (Integer) r13;
        if (r17 == null) goto L27;
        int r18 = r17.intValue();
    L28:
        r5.L$0 = null;
        r5.I$0 = r18;
        r5.label = 3;
        h r19 = (h) r10;
        r19.getClass();
        if (CoroutinesRoom.execute(r19.f11479a, true, new b(r19, r18 + 1), r5) != r14) goto L31;
        return r14;
    L31:
        r16 = r18;
        goto L33
    L27:
        r18 = 1;
        goto L28
    L17:
        r10 = (a) r5.L$0;
        ResultKt.throwOnFailure(r13);
    L21:
        r5.L$0 = r10;
        r5.label = 2;
        h r20 = (h) r10;
        r20.getClass();
        RoomSQLiteQuery r21 = RoomSQLiteQuery.acquire("SELECT nextValue FROM id_sequence WHERE name = ?", 1);
        r21.bindString(1, "card_instance_id");
        r13 = CoroutinesRoom.execute(r20.f11479a, false, DBUtil.createCancellationSignal(), new c(r20, r21, 2), r5);
        if (r13 != r14) goto L24;
        return r14;
    L18:
        ResultKt.throwOnFailure(r13);
        r5.L$0 = r10;
        r5.label = 1;
        h r22 = (h) r10;
        r22.getClass();
        if (CoroutinesRoom.execute(r22.f11479a, true, new com.airbnb.lottie.m(r22, 9), r5) != r14) goto L21;
        return r14;
    L7:
        r5 = new CardDao$allocateInstanceId$1(r10, r11);
        goto L8
    }

    public abstract kotlinx.coroutines.flow.g b(String r5);
}
