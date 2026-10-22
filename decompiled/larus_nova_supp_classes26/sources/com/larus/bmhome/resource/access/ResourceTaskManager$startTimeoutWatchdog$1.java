package com.larus.bmhome.resource.access;

import com.larus.bmhome.upload.ResourceUploader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.resource.access.ResourceTaskManager$startTimeoutWatchdog$1", f = "ResourceTaskManager.kt", i = {}, l = {199}, m = "invokeSuspend", n = {}, s = {})
final class ResourceTaskManager$startTimeoutWatchdog$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ f $task;
    final /* synthetic */ d0 $timeoutConfig;
    int label;

    public ResourceTaskManager$startTimeoutWatchdog$1(f r1, d0 r2, Continuation<? super ResourceTaskManager$startTimeoutWatchdog$1> r3) {
        this.$task = r1;
        this.$timeoutConfig = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new ResourceTaskManager$startTimeoutWatchdog$1(this.$task, this.$timeoutConfig, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:85:0x0190 -> B:87:0x0193). Please report as a decompilation issue!!! */
    public final Object invokeSuspend(Object r19) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        if (r2 == 0) goto L8;
        if (r2 != 1) goto L7;
        ResultKt.throwOnFailure(r19);
        ResourceTaskManager$startTimeoutWatchdog$1 r3 = this;
    L10:
        if (r3.$task.c() == true) goto L89;
        x0 r4 = x0.a;
        f r5 = r3.$task;
        long r6 = System.currentTimeMillis();
        d0 r7 = r3.$timeoutConfig;
        Long r8 = r7.a;
        Long r9 = null;
        if (r8 == null) goto L24;
        long r15 = r8.longValue();
        if (r15 > 0) goto L16;
    L18:
        boolean r10 = false;
    L19:
        if (r10 == true) goto L22;
        r8 = null;
    L22:
        if (r8 == null) goto L24;
        r r11 = new r("pipeline", "task_total_timeout", "resource access task total timeout: " + r8.longValue() + "ms", null);
    L38:
        if (r11 == null) goto L48;
        f r1 = r3.$task;
        if (r1.e(new a0.c(r11)) == false) goto L47;
        Job r12 = r1.h.getAndSet(null);
        if (r12 == null) goto L45;
        Job.DefaultImpls.cancel$default(r12, null, 1, null);
    L45:
        x0.d(r1, ResourceTraceResult.FAILED, r11.b);
        ResourceUploader r13 = ResourceUploader.a;
        ResourceUploader.c(r1.c.d.a);
        x0.a();
    L47:
        return Unit.INSTANCE;
    L48:
        f r14 = r3.$task;
        long r16 = System.currentTimeMillis();
        d0 r17 = r3.$timeoutConfig;
        Long[] r18 = new Long[2];
        Long r110 = r17.a;
        if (r110 != null) goto L51;
    L59:
        Long r111 = null;
    L60:
        r18[0] = r111;
        Long r20 = r17.b;
        if (r20 != null) goto L63;
    L71:
        r18[1] = r9;
        List r21 = CollectionsKt.listOfNotNull(r18);
        ArrayList r22 = new ArrayList();
        Iterator r23 = r21.iterator();
    L73:
        if (r23.hasNext() == false) goto L80;
        Object r24 = r23.next();
        if (((Number) r24).longValue() <= 0) goto L77;
        boolean r25 = true;
    L78:
        if (r25 == false) goto L73;
        r22.add(r24);
        goto L73
    L77:
        r25 = false;
        goto L78
    L80:
        Long r26 = (Long) CollectionsKt.minOrNull(r22);
        if (r26 == null) goto L83;
        long r27 = r26.longValue();
    L84:
        long r28 = RangesKt.coerceIn(r27, 200, 1000);
        r3.label = 1;
        if (DelayKt.delay(r28, r3) != r0) goto L10;
        return r0;
    L83:
        r27 = 1000;
        goto L84
    L63:
        if (r20.longValue() <= 0) goto L65;
        boolean r112 = true;
    L66:
        if (r112 == true) goto L69;
        r20 = null;
    L69:
        if (r20 == null) goto L71;
        r9 = Long.valueOf(r20.longValue() - (r16 - r14.g));
        goto L71
    L65:
        r112 = false;
        goto L66
    L51:
        if (r110.longValue() <= 0) goto L53;
        boolean r113 = true;
    L54:
        if (r113 == true) goto L57;
        r110 = null;
    L57:
        if (r110 == null) goto L59;
        r111 = Long.valueOf(r110.longValue() - (r16 - r14.f));
        goto L60
    L53:
        r113 = false;
        goto L54
    L16:
        if ((r6 - r5.f) < r15) goto L18;
        r10 = true;
    L24:
        Long r29 = r7.b;
        if (r29 == null) goto L37;
        long r114 = r29.longValue();
        if (r114 > 0) goto L29;
    L31:
        boolean r30 = false;
    L32:
        if (r30 == true) goto L35;
        r29 = null;
    L35:
        if (r29 == null) goto L37;
        r11 = new r("pipeline", "task_idle_timeout", "resource access task idle timeout: " + r29.longValue() + "ms", null);
        goto L38
    L29:
        if ((r6 - r5.g) < r114) goto L31;
        r30 = true;
    L37:
        r11 = null;
        goto L38
    L89:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r19);
        r3 = this;
        goto L10
    }
}
