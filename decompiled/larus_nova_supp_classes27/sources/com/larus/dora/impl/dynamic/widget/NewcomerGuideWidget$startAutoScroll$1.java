package com.larus.dora.impl.dynamic.widget;

import androidx.recyclerview.widget.LinearLayoutManager;
import com.larus.platform.model.NewcomerGuideItem;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.dynamic.widget.NewcomerGuideWidget$startAutoScroll$1", f = "NewcomerGuideWidget.kt", i = {0, 1, 2}, l = {266, 271, 286}, m = "invokeSuspend", n = {"$this$launch", "$this$launch", "$this$launch"}, s = {"L$0", "L$0", "L$0"})
public final class NewcomerGuideWidget$startAutoScroll$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $delayMs;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ NewcomerGuideWidget this$0;

    public NewcomerGuideWidget$startAutoScroll$1(long r1, NewcomerGuideWidget r3, Continuation<? super NewcomerGuideWidget$startAutoScroll$1> r4) {
        this.$delayMs = r1;
        this.this$0 = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r5, Continuation<?> r6) {
        NewcomerGuideWidget$startAutoScroll$1 r0 = new NewcomerGuideWidget$startAutoScroll$1(this.$delayMs, this.this$0, r6);
        r0.L$0 = r5;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r11) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L11;
        if (r1 == 1) goto L10;
        if (r1 == 2) goto L10;
        if (r1 == 3) goto L10;
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        CoroutineScope r2 = (CoroutineScope) this.L$0;
        ResultKt.throwOnFailure(r11);
    L16:
        if (CoroutineScopeKt.isActive(r2) == false) goto L49;
        List<NewcomerGuideItem> r5 = this.this$0.e;
        if ((r5 instanceof Collection) == true) goto L20;
    L22:
        Iterator<T> r6 = r5.iterator();
    L24:
        if (r6.hasNext() == false) goto L28;
        if (((NewcomerGuideItem) r6.next()).isLoading() == false) goto L24;
        boolean r7 = true;
    L30:
        if (r7 == true) goto L31;
        LinearLayoutManager r8 = this.this$0.a.e.getLayoutManager();
        if ((r8 instanceof LinearLayoutManager) == false) goto L37;
        LinearLayoutManager r9 = r8;
    L39:
        if (r9 == null) goto L41;
        int r10 = r9.findFirstVisibleItemPosition();
    L42:
        if (r10 == (-1)) goto L44;
        int r12 = r10 + 1;
        g49.d.a("NewcomerGuideWidget", "autoScroll loop: currentPos=" + r10 + ", nextPos=" + r12);
        this.this$0.T5(r12);
    L45:
        long r13 = this.$delayMs;
        this.L$0 = r2;
        this.label = 3;
        if (DelayKt.delay(r13, this) != r0) goto L16;
        return r0;
    L44:
        g49.d.e("NewcomerGuideWidget", "autoScroll loop: currentPos is NO_POSITION");
        goto L45
    L41:
        r10 = -1;
        goto L42
    L37:
        r9 = null;
        goto L39
    L31:
        g49.d.a("NewcomerGuideWidget", "autoScroll loop: paused because item is loading");
        long r14 = this.$delayMs;
        this.L$0 = r2;
        this.label = 2;
        if (DelayKt.delay(r14, this) != r0) goto L16;
        return r0;
    L28:
        r7 = false;
        goto L30
    L20:
        if (r5.isEmpty() == false) goto L22;
    L49:
        return Unit.INSTANCE;
    L11:
        ResultKt.throwOnFailure(r11);
        r2 = (CoroutineScope) this.L$0;
        long r15 = this.$delayMs;
        this.L$0 = r2;
        this.label = 1;
        if (DelayKt.delay(r15, this) != r0) goto L16;
        return r0;
    }
}
