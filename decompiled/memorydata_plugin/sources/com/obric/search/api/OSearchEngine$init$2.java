package com.obric.search.api;

import android.content.Context;
import android.net.Uri;
import com.obric.search.api.d.a.b;
import com.obric.search.common.log.RuntimeLogger;
import com.obric.search.storage.sqlite.fts5.SQLiteFts5Extension;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.al;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.obric.search.api.OSearchEngine$init$2", f = "OSearchEngine.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class OSearchEngine$init$2 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $appContext;
    final /* synthetic */ HashMap<com.obric.search.api.d.a.a, List<com.obric.search.api.schema.a.a>> $plugin2SchemaListMap;
    final /* synthetic */ long $startTime;
    final /* synthetic */ Uri $synonymUri;
    int label;
    final /* synthetic */ a this$0;

    OSearchEngine$init$2(Uri r3, long r4, a r6, HashMap<com.obric.search.api.d.a.a, List<com.obric.search.api.schema.a.a>> r7, Context r8, Continuation<? super OSearchEngine$init$2> r9) {
        Context r10 = (Context) ZeusTransformUtils.wrapperContextForParams(r8, Context.class, "com.obric.memorydata.plugin");
        Continuation r11 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r9, Continuation.class, "com.obric.memorydata.plugin");
        this.$synonymUri = r3;
        this.$startTime = r4;
        this.this$0 = r6;
        this.$plugin2SchemaListMap = r7;
        this.$appContext = ZeusTransformUtils.wrapperContext(r10, "com.obric.memorydata.plugin");
        super(2, r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        Continuation r8 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r11, Continuation.class, "com.obric.memorydata.plugin");
        return (Continuation) ZeusTransformUtils.preCheckCast(new OSearchEngine$init$2(this.$synonymUri, this.$startTime, this.this$0, this.$plugin2SchemaListMap, this.$appContext, r8), Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
        return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(al r3, Continuation<? super Unit> r4) {
        return ((OSearchEngine$init$2) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), OSearchEngine$init$2.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r10) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L26;
        ResultKt.throwOnFailure(r10);
        Uri r11 = this.$synonymUri;
        if (r11 == null) goto L7;
        Context r0 = this.$appContext;
        long r1 = System.currentTimeMillis();
        SQLiteFts5Extension.f14967a.a(r0, r11);
        RuntimeLogger.f14958a.b("OSearchEngine", "init setSynonymAsset time " + (System.currentTimeMillis() - r1));
    L7:
        RuntimeLogger.f14958a.b("OSearchEngine", "init main part done. time is " + (System.currentTimeMillis() - this.$startTime) + "ms.");
        Iterator r12 = a.a(this.this$0).iterator();
    L9:
        if (r12.hasNext() == false) goto L13;
        Pair r2 = (Pair) ZeusTransformUtils.preCheckCast(r12.next(), Pair.class, "com.obric.memorydata.plugin");
        List<? extends com.obric.search.api.schema.a.a> r3 = (List) ZeusTransformUtils.preCheckCast(this.$plugin2SchemaListMap.get(r2.getFirst()), List.class, "com.obric.memorydata.plugin");
        if (r3 == null) goto L9;
        Context r4 = this.$appContext;
        a r5 = this.this$0;
        String r6 = ((com.obric.search.api.d.a.a) ZeusTransformUtils.preCheckCast(r2.getFirst(), com.obric.search.api.d.a.a.class, "com.obric.memorydata.plugin")).a();
        RuntimeLogger.f14958a.b("OSearchEngine", "init plugin " + r6 + " start.");
        a.a(r5, r4, r3, ((com.obric.search.api.d.a.a) ZeusTransformUtils.preCheckCast(r2.getFirst(), com.obric.search.api.d.a.a.class, "com.obric.memorydata.plugin")).a(r4, (b) ZeusTransformUtils.preCheckCast(r2.getSecond(), b.class, "com.obric.memorydata.plugin"), r3));
        RuntimeLogger.f14958a.b("OSearchEngine", "init plugin " + r6 + " done.");
        goto L9
    L13:
        RuntimeLogger.f14958a.b("OSearchEngine", "init all done. time is " + (System.currentTimeMillis() - this.$startTime) + "ms.");
        a.a(this.this$0, true);
        a r9 = this.this$0;
        monitor-enter(r9);
        a.InterfaceC0797a r13 = a.b(r9);     // Catch: Throwable -> L22
        if (r13 == null) goto L18;
        r13.a();     // Catch: Throwable -> L22
    L18:
        Unit r14 = Unit.INSTANCE;     // Catch: Throwable -> L22
        monitor-exit(r9);
        return Unit.INSTANCE;
    L22:
        th = move-exception;
        throw th;
    L26:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
