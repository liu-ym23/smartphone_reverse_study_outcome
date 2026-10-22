package com.obric.memorydata.memory.ui.list;

import android.database.sqlite.SQLiteException;
import com.obric.memorydata.union.build.storage.SemanticConfirmationResult;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/obric/memorydata/union/build/storage/SemanticConfirmationResult;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.memorydata.memory.ui.list.DatabasePendingPersonalInfoRepository$review$2", f = "DatabasePendingPersonalInfoRepository.kt", i = {0}, l = {183}, m = "invokeSuspend", n = {"$this$withLock_u24default$iv"}, s = {"L$0"})
final class DatabasePendingPersonalInfoRepository$review$2 extends SuspendLambda implements Function2<kotlinx.coroutines.al, Continuation<? super SemanticConfirmationResult>, Object> {
    final /* synthetic */ boolean $confirm;
    final /* synthetic */ ar $item;
    Object L$0;
    Object L$1;
    Object L$2;
    boolean Z$0;
    int label;
    final /* synthetic */ f this$0;

    DatabasePendingPersonalInfoRepository$review$2(f r3, ar r4, boolean r5, Continuation<? super DatabasePendingPersonalInfoRepository$review$2> r6) {
        Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r6, Continuation.class, "com.obric.memorydata.plugin");
        this.this$0 = r3;
        this.$item = r4;
        this.$confirm = r5;
        super(2, r7);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
        return (Continuation) ZeusTransformUtils.preCheckCast(new DatabasePendingPersonalInfoRepository$review$2(this.this$0, this.$item, this.$confirm, r6), Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(kotlinx.coroutines.al r3, Continuation<? super SemanticConfirmationResult> r4) {
        return invoke2((kotlinx.coroutines.al) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(kotlinx.coroutines.al r3, Continuation<? super SemanticConfirmationResult> r4) {
        return ((DatabasePendingPersonalInfoRepository$review$2) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.al) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), DatabasePendingPersonalInfoRepository$review$2.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r14) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        boolean r3 = true;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        boolean r2 = this.Z$0;
        ar r4 = (ar) ZeusTransformUtils.preCheckCast(this.L$2, ar.class, "com.obric.memorydata.plugin");
        f r5 = (f) ZeusTransformUtils.preCheckCast(this.L$1, f.class, "com.obric.memorydata.plugin");
        kotlinx.coroutines.sync.a r13 = (kotlinx.coroutines.sync.a) ZeusTransformUtils.preCheckCast(this.L$0, kotlinx.coroutines.sync.a.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r14);
    L43:
    L38:
        th = move-exception;
        r13.b(null);
        throw th;
    L13:
        if (f.c(r5) == true) goto L15;
        SemanticConfirmationResult r15 = new SemanticConfirmationResult(false, "ACCOUNT_CHANGED", null, null, 12, null);     // Catch: Throwable -> L38
    L36:
        r13.b(null);
        return r15;
    L15:
        Iterable r16 = (Iterable) ZeusTransformUtils.preCheckCast(((ay) ZeusTransformUtils.preCheckCast(f.d(r5).c(), ay.class, "com.obric.memorydata.plugin")).a(), Iterable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L38
        Collection r6 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r16, 10)), Collection.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L38
        Iterator r17 = r16.iterator();     // Catch: Throwable -> L38
    L17:
        if (r17.hasNext() == false) goto L19;
        r6.add(((ar) ZeusTransformUtils.preCheckCast(r17.next(), ar.class, "com.obric.memorydata.plugin")).a());     // Catch: Throwable -> L38
        goto L17
    L19:
        Set r18 = CollectionsKt.toSet((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r6, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L38
        com.obric.memorydata.union.build.storage.d r7 = com.obric.memorydata.union.build.storage.d.f13117a;     // Catch: SQLiteException -> L26 Throwable -> L38
        String r8 = r4.a();     // Catch: SQLiteException -> L26 Throwable -> L38
        long r9 = r4.f();     // Catch: SQLiteException -> L26 Throwable -> L38
        Map<String, Long> r10 = r4.g();     // Catch: SQLiteException -> L26 Throwable -> L38
        if (r2 == true) goto L24;
        r3 = false;
    L24:
        SemanticConfirmationResult r11 = r7.a(new com.obric.memorydata.union.build.storage.f(r8, r9, r10, r3));     // Catch: SQLiteException -> L26 Throwable -> L38
    L28:
        if (r11.getSuccess() == false) goto L34;
        Set r12 = f.e(r5);     // Catch: Throwable -> L38
        if (r12 == null) goto L33;
        r18 = r12;
    L33:
        f.a(r5, SetsKt.minus(r18, r4.a()));     // Catch: Throwable -> L38
    L34:
        f.b(r5);     // Catch: Throwable -> L38
        r15 = r11;
    L26:
        r11 = new SemanticConfirmationResult(false, "STORAGE_FAILED", null, null, 12, null);     // Catch: Throwable -> L38
        goto L28
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r14);
        kotlinx.coroutines.sync.a r19 = f.a(this.this$0);
        r5 = this.this$0;
        r4 = this.$item;
        boolean r20 = this.$confirm;
        Continuation<? super Unit> r21 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
        this.L$0 = r19;
        this.L$1 = r5;
        this.L$2 = r4;
        this.Z$0 = r20;
        this.label = 1;
        if (r19.a(null, r21) != r0) goto L11;
        return r0;
    L11:
        r13 = r19;
        r2 = r20;
        goto L43
    }
}
