package com.larus.avlink.gallery.inject;

import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.avlink.gallery.coordinator.MediaSyncCoordinator;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.avlink.gallery.inject.DatasetInjectionRunner$inject$1", f = "DatasetInjectionRunner.kt", i = {0, 0, 1, 1}, l = {88, 90, 100}, m = "invokeSuspend", n = {"injected", "enqueuedIds", "injected", "enqueuedIds"}, s = {"L$0", "L$1", "L$0", "L$1"})
final class DatasetInjectionRunner$inject$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ List<w88.b> $items;
    final /* synthetic */ Function1<Long, Unit> $onAllProcessed;
    final /* synthetic */ Function1<Integer, Unit> $onEnqueued;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;

    /* JADX WARN: Multi-variable type inference failed */
    public DatasetInjectionRunner$inject$1(List<w88.b> r1, Function1<? super Integer, Unit> r2, Function1<? super Long, Unit> r3, Continuation<? super DatasetInjectionRunner$inject$1> r4) {
        this.$items = r1;
        this.$onEnqueued = r2;
        this.$onAllProcessed = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new DatasetInjectionRunner$inject$1(this.$items, this.$onEnqueued, this.$onAllProcessed, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:38:0x00e0 -> B:39:0x00e7). Please report as a decompilation issue!!! */
    public final Object invokeSuspend(Object r15) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L12;
        if (r1 == 1) goto L11;
        if (r1 == 2) goto L10;
        if (r1 != 3) goto L9;
        ResultKt.throwOnFailure(r15);
    L48:
        return Unit.INSTANCE;
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        Iterator r2 = (Iterator) this.L$2;
        List r5 = (List) this.L$1;
        Ref.IntRef r6 = (Ref.IntRef) this.L$0;
        ResultKt.throwOnFailure(r15);
        Ref.IntRef r7 = r6;
        List r8 = r5;
        Iterator r9 = r2;
        Object r3 = r0;
        DatasetInjectionRunner$inject$1 r4 = this;
    L39:
        String r16 = (String) r15;
    L40:
        if (r16 == null) goto L42;
        r7.element++;
        r8.add(r16);
    L42:
        DatasetInjectionRunner$inject$1 r17 = r4;
        r0 = r3;
        Iterator r10 = r9;
        List r11 = r8;
        Ref.IntRef r12 = r7;
    L14:
        if (r10.hasNext() == false) goto L44;
        ((w88.b) r10.next()).getClass();
        PolarisFileWrapper r13 = new PolarisFileWrapper(null);
        if (r13.exists() == false) goto L43;
        DatasetInjectionRunner r14 = DatasetInjectionRunner.a;
        String r18 = r13.getName();
        r14.getClass();
        if (StringsKt.endsWith(r18, ".pack", true) == false) goto L20;
    L25:
        boolean r19 = true;
    L26:
        if (r19 == false) goto L43;
        if (StringsKt.endsWith(r13.getName(), ".mp4", true) == false) goto L35;
        r17.L$0 = r12;
        r17.L$1 = r11;
        r17.L$2 = r10;
        r17.label = 1;
        Object r20 = DatasetInjectionRunner.c(r14, r13, r17);
        if (r20 != r0) goto L33;
        return r0;
    L33:
        Object r110 = r0;
        r4 = r17;
        r7 = r12;
        r8 = r11;
        r9 = r10;
        r3 = r110;
        r16 = (String) r20;
        goto L40
    L35:
        r17.L$0 = r12;
        r17.L$1 = r11;
        r17.L$2 = r10;
        r17.label = 2;
        Object r21 = DatasetInjectionRunner.b(r14, r13, r17);
        if (r21 != r0) goto L38;
        return r0;
    L38:
        Object r111 = r0;
        r4 = r17;
        r15 = r21;
        r7 = r12;
        r8 = r11;
        r9 = r10;
        r3 = r111;
        goto L39
    L20:
        if (StringsKt.endsWith(r18, ".zip", true) == true) goto L25;
        if (StringsKt.endsWith(r18, ".mp4", true) == true) goto L25;
        r19 = false;
    L43:
        FLogger.a.w("DatasetInjectionRunner", "skip unsupported file: null");
        goto L14
    L44:
        FLogger.a.i("DatasetInjectionRunner", "inject finish, requested=" + r17.$items.size() + ", injected=" + r12.element);
        r17.$onEnqueued.invoke(Boxing.boxInt(r12.element));
        DatasetInjectionRunner r22 = DatasetInjectionRunner.a;
        Function1<Long, Unit> r23 = r17.$onAllProcessed;
        r17.L$0 = null;
        r17.L$1 = null;
        r17.L$2 = null;
        r17.label = 3;
        if (DatasetInjectionRunner.a(r22, r11, r23, r17) != r0) goto L48;
        return r0;
    L11:
        Iterator r24 = (Iterator) this.L$2;
        List r25 = (List) this.L$1;
        Ref.IntRef r26 = (Ref.IntRef) this.L$0;
        ResultKt.throwOnFailure(r15);
        r7 = r26;
        r8 = r25;
        r9 = r24;
        r3 = r0;
        r4 = this;
        r16 = (String) r15;
        goto L40
    L12:
        ResultKt.throwOnFailure(r15);
        MediaSyncCoordinator r112 = MediaSyncCoordinator.a;
        MediaSyncCoordinator.d();
        Ref.IntRef r113 = new Ref.IntRef();
        ArrayList r27 = new ArrayList();
        r12 = r113;
        r17 = this;
        r11 = r27;
        r10 = this.$items.iterator();
        goto L14
    }
}
