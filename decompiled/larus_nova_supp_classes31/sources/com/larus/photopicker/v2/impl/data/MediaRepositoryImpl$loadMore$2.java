package com.larus.photopicker.v2.impl.data;

import com.larus.photopicker.v2.impl.e0;
import com.larus.photopicker.v2.impl.model.MediaTab;
import com.tencent.open.log.TraceLevel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.photopicker.v2.impl.data.MediaRepositoryImpl$loadMore$2", f = "MediaRepositoryImpl.kt", i = {0, 1}, l = {276, 129}, m = "invokeSuspend", n = {"$this$withLock_u24default$iv", "$this$withLock_u24default$iv"}, s = {"L$0", "L$0"})
public final class MediaRepositoryImpl$loadMore$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ mp9.a $filter;
    final /* synthetic */ int $page;
    final /* synthetic */ int $pageSize;
    int I$0;
    int I$1;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ MediaRepositoryImpl this$0;

    public MediaRepositoryImpl$loadMore$2(MediaRepositoryImpl r1, int r2, int r3, mp9.a r4, Continuation<? super MediaRepositoryImpl$loadMore$2> r5) {
        this.this$0 = r1;
        this.$page = r2;
        this.$pageSize = r3;
        this.$filter = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new MediaRepositoryImpl$loadMore$2(this.this$0, this.$page, this.$pageSize, this.$filter, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r18) {
        Object r3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r4 = this.label;
        if (r4 == 0) goto L14;
        if (r4 == 1) goto L13;
        if (r4 != 2) goto L12;
        mp9.a r0 = (mp9.a) this.L$2;
        MediaRepositoryImpl r2 = (MediaRepositoryImpl) this.L$1;
        kotlinx.coroutines.sync.a r5 = (kotlinx.coroutines.sync.a) this.L$0;
        ResultKt.throwOnFailure(r18);     // Catch: Throwable -> L9
        mp9.a r9 = r0;
        Object r1 = r18;
    L22:
        List<mp9.c> r6 = (List) r1;     // Catch: Throwable -> L9
        if (r6.isEmpty() == false) goto L65;
        int r7 = e0.a;     // Catch: Throwable -> L9
        e0.d(r2.c, "loadMore resultMediaItems.isEmpty");     // Catch: Throwable -> L9
    L57:
        Unit r8 = Unit.INSTANCE;     // Catch: Throwable -> L60
        r5.unlock(null);
        return Unit.INSTANCE;
    L60:
        th = th;
    L61:
        kotlinx.coroutines.sync.a r10 = r5;
    L63:
        r10.unlock(null);
        throw th;
    L65:
        Long r11 = r9.a;     // Catch: Throwable -> L60
        if (r11 == null) goto L57;
        long r12 = r11.longValue();     // Catch: Throwable -> L9
        MediaTab r13 = r9.b;     // Catch: Throwable -> L60
        if (r13 == null) goto L57;
        List r14 = (List) r2.g.getValue();     // Catch: Throwable -> L9
        if (r14 == null) goto L57;
        List r15 = CollectionsKt.toMutableList(r14);     // Catch: Throwable -> L9
        if (r15 == null) goto L57;
        Iterator r16 = r15.iterator();     // Catch: Throwable -> L9
        int r17 = 0;
    L40:
        if (r16.hasNext() == false) goto L49;
        if (((mp9.b) r16.next()).a != r12) goto L45;
        boolean r19 = true;
    L46:
        if (r19 == true) goto L50;
        r17 = r17 + 1;     // Catch: Throwable -> L60
    L50:
        if (r17 == (-1)) goto L57;
        mp9.b r20 = (mp9.b) r15.get(r17);     // Catch: Throwable -> L60
        Map r21 = MapsKt.toMutableMap(r20.f);     // Catch: Throwable -> L60
        List r110 = (List) r21.get(r13);     // Catch: Throwable -> L60
        if (r110 == null) goto L55;
        List r111 = CollectionsKt.toMutableList(r110);     // Catch: Throwable -> L60
        if (r111 == null) goto L55;
    L56:
        r111.addAll(r6);     // Catch: Throwable -> L60
        r21.put(r13, r111);     // Catch: Throwable -> L60
        r2.f.a(r12, r13, r6);     // Catch: Throwable -> L60
        r15.set(r17, mp9.b.a(r20, 0, null, r21, 31));     // Catch: Throwable -> L60
        r2.g.postValue(r15);     // Catch: Throwable -> L60
    L55:
        r111 = new ArrayList();     // Catch: Throwable -> L60
        goto L56
    L45:
        r19 = false;
        goto L46
    L49:
        r17 = -1;
    L9:
        th = th;
        goto L61
    L12:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L13:
        int r22 = this.I$1;
        int r23 = this.I$0;
        r9 = (mp9.a) this.L$2;
        MediaRepositoryImpl r112 = (MediaRepositoryImpl) this.L$1;
        kotlinx.coroutines.sync.a r113 = (kotlinx.coroutines.sync.a) this.L$0;
        ResultKt.throwOnFailure(r18);
        int r114 = r22;
        MediaRepositoryImpl r24 = r112;
        int r115 = r23;
        r10 = r113;
    L68:
        int r116 = e0.a;     // Catch: Throwable -> L62
        e0.d(r24.c, "loadMore: " + r115 + ", " + r114 + ", " + r9);     // Catch: Throwable -> L62
        e r25 = r24.a;     // Catch: Throwable -> L62
        this.L$0 = r10;     // Catch: Throwable -> L62
        this.L$1 = r24;     // Catch: Throwable -> L62
        this.L$2 = r9;     // Catch: Throwable -> L62
        this.label = 2;     // Catch: Throwable -> L62
        r1 = r25.c(r115, r114, r9, this);     // Catch: Throwable -> L62
        if (r1 != r3) goto L21;
        return r3;
    L21:
        r2 = r24;
        r5 = r10;
    L62:
        th = th;
        goto L63
    L14:
        ResultKt.throwOnFailure(r18);
        r24 = this.this$0;
        r10 = r24.d;
        int r26 = this.$page;
        r114 = this.$pageSize;
        mp9.a r117 = this.$filter;
        this.L$0 = r10;
        this.L$1 = r24;
        this.L$2 = r117;
        this.I$0 = r26;
        this.I$1 = r114;
        this.label = 1;
        if (r10.a(null, this) != r3) goto L17;
        return r3;
    L17:
        r115 = r26;
        r9 = r117;
        goto L68
    }
}
