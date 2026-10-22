package com.obric.memorydata.realtimecontext;

import android.content.ComponentName;
import android.content.Context;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function2;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import kotlinx.coroutines.al;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.memorydata.realtimecontext.AssistStructureViewTreeDumper$writeViewTreeToCache$2", f = "AssistStructureViewTreeDumper.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class AssistStructureViewTreeDumper$writeViewTreeToCache$2 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
    final /* synthetic */ ComponentName $componentName;
    final /* synthetic */ String $viewTree;
    int label;

    AssistStructureViewTreeDumper$writeViewTreeToCache$2(ComponentName r3, String r4, Continuation<? super AssistStructureViewTreeDumper$writeViewTreeToCache$2> r5) {
        Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
        this.$componentName = r3;
        this.$viewTree = r4;
        super(2, r6);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        return (Continuation) ZeusTransformUtils.preCheckCast(new AssistStructureViewTreeDumper$writeViewTreeToCache$2(this.$componentName, this.$viewTree, r5), Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
        return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(al r3, Continuation<? super Unit> r4) {
        return ((AssistStructureViewTreeDumper$writeViewTreeToCache$2) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), AssistStructureViewTreeDumper$writeViewTreeToCache$2.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r8) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L37;
        ResultKt.throwOnFailure(r8);
        File r9 = new File(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getCacheDir(), "assist_structure_view_tree");     // Catch: Throwable -> L32
        if (r9.exists() == false) goto L12;
        if (r9.isDirectory() == true) goto L12;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), RealTimeContextService.TAG, "[assistStructureViewTree] write viewTree failed, cache path is not directory", null, 4, null);     // Catch: Throwable -> L32
        return Unit.INSTANCE;
    L12:
        if (r9.exists() == false) goto L14;
    L17:
        ComponentName r1 = this.$componentName;     // Catch: Throwable -> L32
        if (r1 == null) goto L29;
        String r2 = r1.flattenToShortString();     // Catch: Throwable -> L32
        if (r2 == null) goto L29;
        String r3 = j.a(j.f12471a, r2);     // Catch: Throwable -> L32
        if (r3 == null) goto L29;
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.memorydata.plugin"))) == true) goto L27;
        r3 = null;
    L27:
        if (r3 == null) goto L29;
    L30:
        File r4 = new File(r9, System.currentTimeMillis() + '_' + r3 + ".txt");     // Catch: Throwable -> L32
        FilesKt.writeText(r4, this.$viewTree, Charsets.UTF_8);     // Catch: Throwable -> L32
        RunLog.INSTANCE.debug(RealTimeContextService.TAG, "[assistStructureViewTree] write file=" + r4.getAbsolutePath() + ", length=" + this.$viewTree.length());     // Catch: Throwable -> L32
    L35:
        return Unit.INSTANCE;
    L29:
        r3 = "unknown_activity";
        goto L30
    L14:
        if (r9.mkdirs() == true) goto L17;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), RealTimeContextService.TAG, "[assistStructureViewTree] write viewTree failed, mkdirs failed", null, 4, null);     // Catch: Throwable -> L32
        return Unit.INSTANCE;
    L32:
        th = move-exception;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), RealTimeContextService.TAG, "[assistStructureViewTree] write viewTree failed: " + th.getClass().getSimpleName(), null, 4, null);
        goto L35
    L37:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
