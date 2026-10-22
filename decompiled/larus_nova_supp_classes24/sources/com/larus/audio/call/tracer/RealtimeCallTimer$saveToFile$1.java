package com.larus.audio.call.tracer;

import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larus.audio.call.f;
import java.io.File;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
@DebugMetadata(c = "com.larus.audio.call.tracer.RealtimeCallTimer$saveToFile$1", f = "RealtimeCallTimer.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class RealtimeCallTimer$saveToFile$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ RealtimeCallTimer this$0;

    public RealtimeCallTimer$saveToFile$1(RealtimeCallTimer r1, Continuation<? super RealtimeCallTimer$saveToFile$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new RealtimeCallTimer$saveToFile$1(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r12) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L24;
        ResultKt.throwOnFailure(r12);
        PolarisFileWrapper r13 = new PolarisFileWrapper(f.d().c.f, "mic_dump.log");
        File r0 = r13.getParentFile();
        if (r0 == null) goto L7;
        Boxing.boxBoolean(r0.mkdirs());
    L7:
        SimpleDateFormat r1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.getDefault());
        PrintWriter r2 = new PrintWriter(r13);
        RealtimeCallTimer r14 = this.this$0;
        Iterator<Long> r3 = r14.a.iterator();     // Catch: Throwable -> L18
        int r4 = 0;
    L10:
        if (r3.hasNext() == false) goto L15;
        Long r5 = r3.next();     // Catch: Throwable -> L18
        int r6 = r4 + 1;     // Catch: Throwable -> L18
        if (r4 >= 0) goto L14;
        CollectionsKt.throwIndexOverflow();     // Catch: Throwable -> L18
    L14:
        long r7 = r5.longValue();     // Catch: Throwable -> L18
        int r8 = r14.b.get(r4).intValue();     // Catch: Throwable -> L18
        int r9 = r14.c.get(r4).intValue();     // Catch: Throwable -> L18
        r2.println(r1.format(new Date(r14.d.get(r4).longValue())) + ": buffer size " + r8 + ", read size " + r9 + ",  elapsed time " + r7 + " ms");     // Catch: Throwable -> L18
        r4 = r6;
        goto L10
    L15:
        Unit r15 = Unit.INSTANCE;     // Catch: Throwable -> L18
        CloseableKt.closeFinally(r2, null);
        return Unit.INSTANCE;
    L18:
        th = move-exception;
        throw th;     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        CloseableKt.closeFinally(r2, th);
        throw th;
    L24:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
