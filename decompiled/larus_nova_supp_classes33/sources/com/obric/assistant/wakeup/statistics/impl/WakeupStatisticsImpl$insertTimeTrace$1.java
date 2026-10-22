package com.obric.assistant.wakeup.statistics.impl;

import android.os.Bundle;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.wakeup.statistics.impl.WakeupStatisticsImpl$insertTimeTrace$1", f = "WakeupStatisticsImpl.kt", i = {}, l = {114}, m = "invokeSuspend", n = {}, s = {})
final class WakeupStatisticsImpl$insertTimeTrace$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ WakeupStatisticsImpl this$0;

    public WakeupStatisticsImpl$insertTimeTrace$1(WakeupStatisticsImpl r1, Continuation<? super WakeupStatisticsImpl$insertTimeTrace$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new WakeupStatisticsImpl$insertTimeTrace$1(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r12) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r12);
    L11:
        WakeupStatisticsImpl r13 = this.this$0;
        int r2 = WakeupStatisticsImpl.g;
        r13.getClass();
        FLogger.a.i("WakeupDuration/S3", "start to set TotalTrakcer with data bundle :" + r13.d);
        if (r13.d == null) goto L27;
        JSONObject r3 = new JSONObject();
        ArrayList r4 = new ArrayList();
        Bundle r5 = r13.d;
        if (r5 == null) goto L19;
        Collection r6 = r5.keySet();
        if (r6 == null) goto L19;
    L20:
        r4.addAll(r6);
        CollectionsKt.sort(r4);
        Iterator r7 = r4.iterator();
    L22:
        if (r7.hasNext() == false) goto L24;
        String r8 = (String) r7.next();
        Bundle r9 = r13.d;
        Intrinsics.checkNotNull(r9);
        r3.put(r8, r9.get(r8));
        goto L22
    L24:
        FLogger.a.i("WakeupDuration/S3", "BigPlateTracker -> " + r3 + " with uploader " + r13.f);
        Function2<? super String, ? super JSONObject, Unit> r14 = r13.f;
        if (r14 == null) goto L27;
        r14.invoke("wakeup_stage_all_duration", r3);
    L19:
        r6 = CollectionsKt.emptyList();
    L27:
        Bundle r15 = this.this$0.d;
        long r10 = 0;
        if (r15 == null) goto L30;
        long r11 = r15.getLong("wakeup_stage1_duration");
    L31:
        Bundle r16 = this.this$0.d;
        if (r16 == null) goto L34;
        long r17 = r16.getLong("wakeup_stage2_duration");
    L35:
        Bundle r18 = this.this$0.d;
        if (r18 == null) goto L38;
        r10 = r18.getLong("wakeup_stage3_duration");
    L38:
        Bundle r19 = this.this$0.d;
        if (r19 == null) goto L42;
        String r110 = r19.getString("wakeup_stage2_screen_state");
        if (r110 == null) goto L42;
    L43:
        Objects.toString(this.this$0.d);
        FLogger r20 = FLogger.a;
        r20.i("WakeupDuration/S3", "---> duration Stage1 is " + r11 + ' ');
        r20.i("WakeupDuration/S3", "---> duration Stage2 is " + r17 + ' ');
        r20.i("WakeupDuration/S3", "---> duration Stage3 is " + r10 + ' ');
        r20.i("WakeupDuration/S3", "---> duration 1+2+3 is " + ((r10 + r17) + r11) + ' ');
        StringBuilder r21 = new StringBuilder("---> duration total is ");
        Bundle r22 = this.this$0.d;
        if (r22 == null) goto L46;
        Long r23 = Boxing.boxLong(r22.getLong("wakeup_total_duration"));
    L47:
        r21.append(r23);
        r21.append(' ');
        r20.i("WakeupDuration/S3", r21.toString());
        r20.i("WakeupDuration/S3", "---> duration screenState is ".concat(r110));
        if (AppHost.a.isDebug() == true) goto L54;
        Bundle r111 = this.this$0.d;
        if (r111 == null) goto L54;
        Boxing.boxLong(r111.getLong("wakeup_total_duration"));
    L54:
        return Unit.INSTANCE;
    L46:
        r23 = null;
    L42:
        r110 = "1";
        goto L43
    L34:
        r17 = 0;
        goto L35
    L30:
        r11 = 0;
        goto L31
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r12);
        this.label = 1;
        if (DelayKt.delay(1000, this) != r0) goto L11;
        return r0;
    }
}
