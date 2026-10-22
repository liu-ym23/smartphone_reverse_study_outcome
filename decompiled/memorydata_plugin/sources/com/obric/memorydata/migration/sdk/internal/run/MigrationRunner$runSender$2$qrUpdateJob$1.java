package com.obric.memorydata.migration.sdk.internal.run;

import com.obric.memorydata.migration.sdk.QrPayload;
import com.obric.memorydata.migration.sdk.d;
import com.obric.memorydata.migration.sdk.m;
import com.obric.memorydata.migration.sdk.p;
import com.obric.memorydata.migration.sdk.t;
import com.obric.memorydata.migration.sdk.y;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
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
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.al;
import kotlinx.coroutines.am;
import kotlinx.coroutines.au;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.memorydata.migration.sdk.internal.run.MigrationRunner$runSender$2$qrUpdateJob$1", f = "MigrationRunner.kt", i = {0}, l = {120}, m = "invokeSuspend", n = {"$this$launch"}, s = {"L$0"})
final class MigrationRunner$runSender$2$qrUpdateJob$1 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
    final /* synthetic */ m $callback;
    final /* synthetic */ Ref.BooleanRef $lastAvailable;
    final /* synthetic */ d $request;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ a this$0;

    MigrationRunner$runSender$2$qrUpdateJob$1(a r3, Ref.BooleanRef r4, d r5, m r6, Continuation<? super MigrationRunner$runSender$2$qrUpdateJob$1> r7) {
        m r8 = (m) ZeusTransformUtils.wrapperContextForParams(r6, m.class, "com.obric.memorydata.plugin");
        Continuation r9 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r7, Continuation.class, "com.obric.memorydata.plugin");
        this.this$0 = r3;
        this.$lastAvailable = r4;
        this.$request = r5;
        this.$callback = r8;
        super(2, r9);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r9, Continuation<?> r10) {
        Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r10, Continuation.class, "com.obric.memorydata.plugin");
        MigrationRunner$runSender$2$qrUpdateJob$1 r11 = new MigrationRunner$runSender$2$qrUpdateJob$1(this.this$0, this.$lastAvailable, this.$request, this.$callback, r7);
        r11.L$0 = r9;
        return (Continuation) ZeusTransformUtils.preCheckCast(r11, Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
        return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(al r3, Continuation<? super Unit> r4) {
        return ((MigrationRunner$runSender$2$qrUpdateJob$1) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), MigrationRunner$runSender$2$qrUpdateJob$1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:14:0x0052 -> B:16:0x0055). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r22) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        if (r2 == 0) goto L8;
        if (r2 != 1) goto L7;
        al r3 = (al) ZeusTransformUtils.preCheckCast(this.L$0, al.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r22);
    L16:
        List r5 = CollectionsKt.sorted((Iterable) ZeusTransformUtils.preCheckCast(a.b(this.this$0).a(), Iterable.class, "com.obric.memorydata.plugin"));
        boolean r6 = !((Collection) ZeusTransformUtils.preCheckCast(r5, Collection.class, "com.obric.memorydata.plugin")).isEmpty();
        if (r6 == this.$lastAvailable.element) goto L10;
        this.$lastAvailable.element = r6;
        t.f11981a.a("sender: network availability changed, available=" + r6 + ", endpointCount=" + r5.size());
        QrPayload r8 = this.$request.a();
        if (r6 == true) goto L22;
        r5 = CollectionsKt.emptyList();
    L22:
        QrPayload r7 = QrPayload.copy$default(r8, null, null, null, 0, 0, null, null, null, r5, 255, null);
        a.a(this.$callback, (p) ZeusTransformUtils.preCheckCast(new p.d(y.f11988a.a(r7), r7), p.class, "com.obric.memorydata.plugin"));
    L10:
        if (am.a(r3) == false) goto L24;
        if (a.c(this.this$0) == true) goto L24;
        Continuation r9 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
        this.L$0 = r3;
        this.label = 1;
        if (au.a(2000, r9) != r1) goto L16;
        return r1;
    L24:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r22);
        r3 = (al) ZeusTransformUtils.preCheckCast(this.L$0, al.class, "com.obric.memorydata.plugin");
        goto L10
    }
}
