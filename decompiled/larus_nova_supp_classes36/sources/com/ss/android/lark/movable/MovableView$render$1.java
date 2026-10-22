package com.ss.android.lark.movable;

import com.bytedance.lark.lark_markdown_render_android.MovableDocumentInfo;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.movable.island.MovableIslandsOpsApplier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
@DebugMetadata(c = "com.ss.android.lark.movable.MovableView$render$1", f = "MovableView.kt", i = {0, 0, 0, 1, 1, 1, 2, 2, 2, 3, 3, 3}, l = {581, 582, 583, 627}, m = "invokeSuspend", n = {"$this$launch", "attachmentDeferred", "islandsDeferred", "$this$launch", "islandsDeferred", "renderData", "$this$launch", "renderData", "attachmentData", "$this$launch", "islandOpList", "needUpdateScrollIsland"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$0", "L$1", "I$0"})
final class MovableView$render$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $myToken;
    final /* synthetic */ MovableView.c $renderContext;
    int I$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ MovableView this$0;

    public MovableView$render$1(long r1, MovableView r3, MovableView.c r4, Continuation<? super MovableView$render$1> r5) {
        this.$myToken = r1;
        this.this$0 = r3;
        this.$renderContext = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        MovableView$render$1 r6 = new MovableView$render$1(this.$myToken, this.this$0, this.$renderContext, r9);
        r6.L$0 = r8;
        return r6;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v10, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r5v11 */
    /* JADX WARN: Type inference failed for: r5v18, types: [java.util.ArrayList] */
    public final Object invokeSuspend(Object r20) {
        Object r3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r4 = this.label;
        if (r4 == 0) goto L22;
        if (r4 == 1) goto L19;
        if (r4 == 2) goto L16;
        if (r4 == 3) goto L13;
        if (r4 != 4) goto L12;
        int r0 = this.I$0;
        List<? extends Pair<? extends MovableIslandsOpsApplier.Op, jsb.a>> r2 = (List) this.L$1;
        CoroutineScope r5 = (CoroutineScope) this.L$0;
        ResultKt.throwOnFailure(r20);     // Catch: Exception -> L73
        Object r6 = r20;
    L59:
        List<Pair<Integer, byte[]>> r7 = (List) r6;     // Catch: Exception -> L73
        if (CoroutineScopeKt.isActive(r5) == true) goto L62;
    L69:
        StringBuilder r1 = new StringBuilder();     // Catch: Exception -> L73
        r1.append("render aborted (pre-apply islands): token=");     // Catch: Exception -> L73
        r1.append(this.$myToken);     // Catch: Exception -> L73
        r1.append(", doc=");     // Catch: Exception -> L73
        MovableView r8 = this.this$0;     // Catch: Exception -> L73
        MovableDocumentInfo r9 = this.$renderContext.b;     // Catch: Exception -> L73
        int r10 = MovableView.A;     // Catch: Exception -> L73
        r8.getClass();     // Catch: Exception -> L73
        r1.append(r9.toString());     // Catch: Exception -> L73
        Log.i("MovableView", r1.toString());     // Catch: Exception -> L73
        return Unit.INSTANCE;
    L62:
        if (this.$myToken != this.this$0.h) goto L69;
        MovableView r11 = this.this$0;     // Catch: Exception -> L73
        MovableView.c r12 = this.$renderContext;     // Catch: Exception -> L73
        if (r0 == 0) goto L67;
        boolean r13 = true;
    L68:
        r11.c(r12, r7, r13, r2);     // Catch: Exception -> L73
    L76:
        return Unit.INSTANCE;
    L67:
        r13 = false;
        goto L68
    L12:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L13:
        byte[] r14 = (byte[]) this.L$2;
        byte[] r15 = (byte[]) this.L$1;
        CoroutineScope r16 = (CoroutineScope) this.L$0;
        ResultKt.throwOnFailure(r20);     // Catch: Exception -> L73
        Object r17 = r20;
    L35:
        byte[] r18 = (byte[]) r17;     // Catch: Exception -> L73
        if (CoroutineScopeKt.isActive(r16) == true) goto L38;
    L71:
        StringBuilder r19 = new StringBuilder("render aborted (pre-apply): token=");     // Catch: Exception -> L73
        r19.append(this.$myToken);     // Catch: Exception -> L73
        r19.append(", doc=");     // Catch: Exception -> L73
        MovableView r21 = this.this$0;     // Catch: Exception -> L73
        MovableDocumentInfo r22 = this.$renderContext.b;     // Catch: Exception -> L73
        int r23 = MovableView.A;     // Catch: Exception -> L73
        r21.getClass();     // Catch: Exception -> L73
        r19.append(r22.toString());     // Catch: Exception -> L73
        Log.i("MovableView", r19.toString());     // Catch: Exception -> L73
        return Unit.INSTANCE;
    L38:
        if (this.$myToken != this.this$0.h) goto L71;
        StringBuilder r24 = new StringBuilder("render main fetched: doc=");     // Catch: Exception -> L73
        MovableView r25 = this.this$0;     // Catch: Exception -> L73
        MovableDocumentInfo r26 = this.$renderContext.b;     // Catch: Exception -> L73
        r25.getClass();     // Catch: Exception -> L73
        r24.append(r26.toString());     // Catch: Exception -> L73
        r24.append(", sizes(common=");     // Catch: Exception -> L73
        r24.append(r15.length);     // Catch: Exception -> L73
        r24.append(", attach=");     // Catch: Exception -> L73
        r24.append(r14.length);     // Catch: Exception -> L73
        r24.append(", islands=");     // Catch: Exception -> L73
        r24.append(r18.length);     // Catch: Exception -> L73
        r24.append(')');     // Catch: Exception -> L73
        Log.i("MovableView", r24.toString());     // Catch: Exception -> L73
        this.this$0.i(r15, this.$renderContext.a);     // Catch: Exception -> L73
        this.this$0.g(r14);     // Catch: Exception -> L73
        this.this$0.h(this.$renderContext.e);     // Catch: Exception -> L73
        if (Arrays.equals(this.this$0.f, r18) == false) goto L43;
        r0 = 0;
        r2 = null;
    L45:
        if (r2 == null) goto L50;
        ?? r27 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r2, 10));     // Catch: Exception -> L73
        Iterator r28 = r2.iterator();     // Catch: Exception -> L73
    L48:
        if (r28.hasNext() == false) goto L51;
        r27.add(Boxing.boxInt(((jsb.a) ((Pair) r28.next()).getSecond()).a));     // Catch: Exception -> L73
    L51:
        Iterable r29 = (Iterable) r27;     // Catch: Exception -> L73
        MovableView r30 = this.this$0;     // Catch: Exception -> L73
        MovableView.c r31 = this.$renderContext;     // Catch: Exception -> L73
        ArrayList r110 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r29, 10));     // Catch: Exception -> L73
        Iterator r32 = r29.iterator();     // Catch: Exception -> L73
    L53:
        if (r32.hasNext() == false) goto L55;
        CoroutineScope r111 = r16;
        r110.add(BuildersKt.async$default(r111, Dispatchers.getIO(), null, new MovableView$render$1$islandTasks$1$1(r30, r31, ((Number) r32.next()).intValue(), null), 2, null));     // Catch: Exception -> L73
        goto L53
    L55:
        this.L$0 = r16;     // Catch: Exception -> L73
        this.L$1 = r2;     // Catch: Exception -> L73
        this.L$2 = null;     // Catch: Exception -> L73
        this.I$0 = r0;     // Catch: Exception -> L73
        this.label = 4;     // Catch: Exception -> L73
        r6 = AwaitKt.a(r110, this);     // Catch: Exception -> L73
        if (r6 != r3) goto L58;
        return r3;
    L58:
        r5 = r16;
        goto L59
    L50:
        r27 = CollectionsKt.emptyList();     // Catch: Exception -> L73
        goto L51
    L43:
        MovableView r33 = this.this$0;     // Catch: Exception -> L73
        r33.f = r18;     // Catch: Exception -> L73
        int r34 = MovableIslandsOpsApplier.c;     // Catch: Exception -> L73
        r2 = MovableIslandsOpsApplier.a.a(r18, r33.getContext());     // Catch: Exception -> L73
        r0 = 1;
        goto L45
    L16:
        byte[] r35 = (byte[]) this.L$2;
        Deferred r36 = (Deferred) this.L$1;
        CoroutineScope r112 = (CoroutineScope) this.L$0;
        ResultKt.throwOnFailure(r20);     // Catch: Exception -> L73
        Object r37 = r20;
        r15 = r35;
    L31:
        r14 = (byte[]) r37;     // Catch: Exception -> L73
        this.L$0 = r112;     // Catch: Exception -> L73
        this.L$1 = r15;     // Catch: Exception -> L73
        this.L$2 = r14;     // Catch: Exception -> L73
        this.label = 3;     // Catch: Exception -> L73
        r17 = r36.await(this);     // Catch: Exception -> L73
        if (r17 != r3) goto L34;
        return r3;
    L34:
        r16 = r112;
        goto L35
    L19:
        Deferred r38 = (Deferred) this.L$2;
        Deferred r113 = (Deferred) this.L$1;
        CoroutineScope r114 = (CoroutineScope) this.L$0;
        ResultKt.throwOnFailure(r20);     // Catch: Exception -> L73
        Object r39 = r20;
        Deferred r40 = r113;
        r112 = r114;
    L27:
        byte[] r41 = (byte[]) r39;     // Catch: Exception -> L73
        this.L$0 = r112;     // Catch: Exception -> L73
        this.L$1 = r38;     // Catch: Exception -> L73
        this.L$2 = r41;     // Catch: Exception -> L73
        this.label = 2;     // Catch: Exception -> L73
        r37 = r40.await(this);     // Catch: Exception -> L73
        if (r37 != r3) goto L30;
        return r3;
    L30:
        r36 = r38;
        r15 = r41;
        goto L31
    L22:
        ResultKt.throwOnFailure(r20);
        CoroutineScope r42 = (CoroutineScope) this.L$0;
        Deferred r43 = BuildersKt.async$default(r42, Dispatchers.getIO(), null, new MovableView$render$1$commonDeferred$1(this.this$0, this.$renderContext, null), 2, null);     // Catch: Exception -> L73
        r40 = BuildersKt.async$default(r42, Dispatchers.getIO(), null, new MovableView$render$1$attachmentDeferred$1(this.$renderContext, null), 2, null);     // Catch: Exception -> L73
        Deferred r44 = BuildersKt.async$default(r42, Dispatchers.getIO(), null, new MovableView$render$1$islandsDeferred$1(this.$renderContext, null), 2, null);     // Catch: Exception -> L73
        this.L$0 = r42;     // Catch: Exception -> L73
        this.L$1 = r40;     // Catch: Exception -> L73
        this.L$2 = r44;     // Catch: Exception -> L73
        this.label = 1;     // Catch: Exception -> L73
        r39 = r43.await(this);     // Catch: Exception -> L73
        if (r39 != r3) goto L26;
        return r3;
    L26:
        r112 = r42;
        r38 = r44;
    L73:
        e = move-exception;
        Log.e("MovableView", "render job failed: " + e.getMessage(), e);
        goto L76
    }
}
