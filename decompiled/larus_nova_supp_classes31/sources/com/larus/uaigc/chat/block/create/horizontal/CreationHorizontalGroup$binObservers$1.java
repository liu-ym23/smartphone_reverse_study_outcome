package com.larus.uaigc.chat.block.create.horizontal;

import com.larus.canvas.service.ICanvasService;
import com.larus.im.bean.message.CreationItem;
import com.larus.im.bean.message.Message;
import com.larus.uaigc.chat.block.widget.container.CreationItemListAdapter;
import com.larus.utils.o0;
import com.tencent.open.log.TraceLevel;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.chat.block.create.horizontal.CreationHorizontalGroup$binObservers$1", f = "CreationHorizontalGroup.kt", i = {}, l = {265}, m = "invokeSuspend", n = {}, s = {})
final class CreationHorizontalGroup$binObservers$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ CreationHorizontalGroup this$0;

    public static final class a<T> implements FlowCollector {
        public final /* synthetic */ CreationHorizontalGroup a;

        public a(CreationHorizontalGroup r1) {
            this.a = r1;
        }

        public final Object emit(Object r7, Continuation r8) {
            ny8.a r9 = (ny8.a) r7;
            CreationHorizontalGroup r10 = this.a;
            int r0 = CreationHorizontalGroup.w;
            r10.getClass();
            Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L33
            String r2 = r9.b;     // Catch: Throwable -> L33
            if (r2 == null) goto L31;
            Message r3 = r10.e;     // Catch: Throwable -> L33
            if (r3 == null) goto L8;
            String r4 = r3.getMessageId();     // Catch: Throwable -> L33
        L10:
            if (Intrinsics.areEqual(r2, r4) == false) goto L31;
            if (o0.d(r9.a) == false) goto L23;
            List<CreationItem> r5 = r10.m;     // Catch: Throwable -> L33
            if (r5 == null) goto L23;
            Iterator<CreationItem> r6 = r5.iterator();     // Catch: Throwable -> L33
            int r11 = 0;
        L18:
            if (r6.hasNext() == false) goto L23;
            if (Intrinsics.areEqual(r6.next().id, r9.a) == true) goto L24;
            r11 = r11 + 1;     // Catch: Throwable -> L33
        L24:
            if (r11 >= 0) goto L30;
            CreationItemListAdapter r12 = r10.t;     // Catch: Throwable -> L33
            if (r12 == null) goto L28;
            int r13 = r12.getItemCount();     // Catch: Throwable -> L33
        L29:
            r11 = Math.max(0, r13 - 1);     // Catch: Throwable -> L33
            goto L30
        L28:
            r13 = 0;
        L30:
            r10.r.b.scrollToPosition(r11);     // Catch: Throwable -> L33
        L23:
            r11 = -1;
            goto L24
        L8:
            r4 = null;
        L31:
            Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L33
        L36:
            return Unit.INSTANCE;
        L33:
            th = move-exception;
            Result.Companion r14 = Result.Companion;
            Result.constructor-impl(ResultKt.createFailure(th));
            goto L36
        }
    }

    public CreationHorizontalGroup$binObservers$1(CreationHorizontalGroup r1, Continuation<? super CreationHorizontalGroup$binObservers$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new CreationHorizontalGroup$binObservers$1(this.this$0, r3);
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
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r5);
    L14:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r5);
        Flow r6 = ICanvasService.a.c();
        if (r6 == null) goto L14;
        a r2 = new a(this.this$0);
        this.label = 1;
        if (r6.collect(r2, this) != r0) goto L14;
        return r0;
    }
}
