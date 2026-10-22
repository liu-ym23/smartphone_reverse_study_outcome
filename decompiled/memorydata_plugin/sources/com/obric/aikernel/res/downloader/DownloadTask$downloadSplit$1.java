package com.obric.aikernel.res.downloader;

import android.content.Context;
import com.bytedance.bdlocation.monitor.LBSLightLocationTraceLogger;
import com.ss.bduploader.BDVideoUploaderBase;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.al;
import kotlinx.coroutines.au;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.obric.aikernel.res.downloader.DownloadTask$downloadSplit$1", f = "DownloadTask.kt", i = {2, 3, 3, 3, 3, 4, 4, 4, 4, 4, 5, 5, 5, 6, 6, 6, 7, 7, 7, 8, 9}, l = {328, 330, 336, 347, 350, 368, 379, 381, 408, BDVideoUploaderBase.KeyIsMaxUploadSpeedThresh}, m = "invokeSuspend", n = {"finished", "finished", "progress", LBSLightLocationTraceLogger.TOTAL, "it", "finished", "progress", LBSLightLocationTraceLogger.TOTAL, "it", "status", "finished", "progress", LBSLightLocationTraceLogger.TOTAL, "finished", "progress", LBSLightLocationTraceLogger.TOTAL, "finished", "progress", LBSLightLocationTraceLogger.TOTAL, "finished", "finished"}, s = {"L$0", "L$0", "L$1", "L$2", "L$5", "L$0", "L$1", "L$2", "L$5", "I$0", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$0", "L$0"})
final class DownloadTask$downloadSplit$1 extends SuspendLambda implements Function2<al, Continuation<? super Boolean>, Object> {
    int I$0;
    int I$1;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    int label;
    final /* synthetic */ j this$0;

    DownloadTask$downloadSplit$1(j r3, Continuation<? super DownloadTask$downloadSplit$1> r4) {
        Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        this.this$0 = r3;
        super(2, r5);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        Continuation r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
        return (Continuation) ZeusTransformUtils.preCheckCast(new DownloadTask$downloadSplit$1(this.this$0, r4), Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(al r3, Continuation<? super Boolean> r4) {
        return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(al r3, Continuation<? super Boolean> r4) {
        return ((DownloadTask$downloadSplit$1) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), DownloadTask$downloadSplit$1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:38:0x0206 -> B:39:0x022a). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:75:0x0409 -> B:76:0x040e). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:79:0x047b -> B:80:0x047d). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r19) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        boolean r7 = true;
        switch(this.label) {
            case 0: goto L13;
            case 1: goto L12;
            case 2: goto L12;
            case 3: goto L11;
            case 4: goto L10;
            case 5: goto L9;
            case 6: goto L8;
            case 7: goto L8;
            case 8: goto L8;
            case 9: goto L7;
            case 10: goto L6;
            default: goto L5;
        };
    L6:
        Iterator r2 = (Iterator) ZeusTransformUtils.preCheckCast(this.L$1, Iterator.class, "com.obric.memorydata.plugin");
        Ref.BooleanRef r3 = (Ref.BooleanRef) ZeusTransformUtils.preCheckCast(this.L$0, Ref.BooleanRef.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r19);
    L113:
        if (r2.hasNext() == false) goto L117;
        n r4 = (n) ZeusTransformUtils.preCheckCast(((Pair) ZeusTransformUtils.preCheckCast(r2.next(), Pair.class, "com.obric.memorydata.plugin")).getFirst(), n.class, "com.obric.memorydata.plugin");
        this.L$0 = r3;
        this.L$1 = r2;
        this.L$2 = null;
        this.L$3 = null;
        this.L$4 = null;
        this.L$5 = null;
        this.L$6 = null;
        this.label = 10;
        if (r4.e(this) != r1) goto L113;
        return r1;
    L117:
        j.a(this.this$0, k.a(true));
    L118:
        Boolean r5 = Boxing.boxBoolean(r3.element);
        j r0 = this.this$0;
        r5.booleanValue();
        com.obric.aikernel.runtime.utils.d.f6216a.a("DownloadTask", r0.a() + " downloadSplit end finish:" + r3.element);
        return r5;
    L7:
        Iterator r6 = (Iterator) ZeusTransformUtils.preCheckCast(this.L$1, Iterator.class, "com.obric.memorydata.plugin");
        r3 = (Ref.BooleanRef) ZeusTransformUtils.preCheckCast(this.L$0, Ref.BooleanRef.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r19);
    L105:
        if (r6.hasNext() == false) goto L110;
        n r8 = (n) ZeusTransformUtils.preCheckCast(((Pair) ZeusTransformUtils.preCheckCast(r6.next(), Pair.class, "com.obric.memorydata.plugin")).getFirst(), n.class, "com.obric.memorydata.plugin");
        this.L$0 = r3;
        this.L$1 = r6;
        this.L$2 = null;
        this.L$3 = null;
        this.L$4 = null;
        this.L$5 = null;
        this.L$6 = null;
        this.label = 9;
        if (r8.c(this) != r1) goto L105;
        return r1;
    L110:
        if (r3.element == false) goto L118;
        r2 = ((Iterable) ZeusTransformUtils.preCheckCast(j.a(this.this$0), Iterable.class, "com.obric.memorydata.plugin")).iterator();
        goto L113
    L8:
        Iterator r9 = (Iterator) ZeusTransformUtils.preCheckCast(this.L$4, Iterator.class, "com.obric.memorydata.plugin");
        j r10 = (j) ZeusTransformUtils.preCheckCast(this.L$3, j.class, "com.obric.memorydata.plugin");
        Ref.IntRef r11 = (Ref.IntRef) ZeusTransformUtils.preCheckCast(this.L$2, Ref.IntRef.class, "com.obric.memorydata.plugin");
        Ref.IntRef r12 = (Ref.IntRef) ZeusTransformUtils.preCheckCast(this.L$1, Ref.IntRef.class, "com.obric.memorydata.plugin");
        Ref.BooleanRef r13 = (Ref.BooleanRef) ZeusTransformUtils.preCheckCast(this.L$0, Ref.BooleanRef.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r19);
    L76:
        Iterator r14 = r9;
        Ref.IntRef r15 = r11;
        Ref.IntRef r16 = r12;
        Ref.BooleanRef r17 = r13;
    L40:
        if (r14.hasNext() == false) goto L81;
        Pair r18 = (Pair) ZeusTransformUtils.preCheckCast(r14.next(), Pair.class, "com.obric.memorydata.plugin");
        n r110 = (n) ZeusTransformUtils.preCheckCast(r18.getFirst(), n.class, "com.obric.memorydata.plugin");
        this.L$0 = r17;
        this.L$1 = r16;
        this.L$2 = r15;
        this.L$3 = r10;
        this.L$4 = r14;
        this.L$5 = r18;
        this.L$6 = null;
        this.label = 4;
        Object r111 = r110.f(this);
        if (r111 != r1) goto L44;
        return r1;
    L44:
        Ref.IntRef r112 = r16;
        j r20 = r10;
        Pair r113 = r18;
    L45:
        int r114 = ((Number) ZeusTransformUtils.preCheckCast(r111, Number.class, "com.obric.memorydata.plugin")).intValue();
        com.obric.aikernel.runtime.utils.d.f6216a.b("DownloadTask", r20.a() + ' ' + ((j.b) ZeusTransformUtils.preCheckCast(r113.getSecond(), j.b.class, "com.obric.memorydata.plugin")).a() + " status: " + r114);
        int r21 = r112.element;
        n r115 = (n) ZeusTransformUtils.preCheckCast(r113.getFirst(), n.class, "com.obric.memorydata.plugin");
        this.L$0 = r17;
        this.L$1 = r112;
        this.L$2 = r15;
        this.L$3 = r20;
        this.L$4 = r14;
        this.L$5 = r113;
        this.L$6 = r112;
        this.I$0 = r114;
        this.I$1 = r21;
        this.label = 5;
        Object r116 = r115.g(this);
        if (r116 != r1) goto L48;
        return r1;
    L48:
        j r117 = r20;
        r16 = r112;
        Ref.BooleanRef r22 = r17;
        int r23 = r21;
        Pair r118 = r113;
        int r119 = r114;
    L49:
        r112.element = r23 + ((Number) ZeusTransformUtils.preCheckCast(r116, Number.class, "com.obric.memorydata.plugin")).intValue();
        r15.element += 100;
        if (r119 != (-4)) goto L52;
    L78:
        r117.b(k.a(((j.b) ZeusTransformUtils.preCheckCast(r118.getSecond(), j.b.class, "com.obric.memorydata.plugin")).g(), com.obric.aikernel.runtime.utils.h.f6225a.b((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(j.d(r117).getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")), k.b(j.d(r117))));
        ((j.b) ZeusTransformUtils.preCheckCast(r118.getSecond(), j.b.class, "com.obric.memorydata.plugin")).a(false);
    L79:
        r17 = r22;
        r10 = r117;
        goto L40
    L52:
        if (r119 != (-3)) goto L54;
        ((j.b) ZeusTransformUtils.preCheckCast(r118.getSecond(), j.b.class, "com.obric.memorydata.plugin")).a(((n) ZeusTransformUtils.preCheckCast(r118.getFirst(), n.class, "com.obric.memorydata.plugin")).b());
        goto L79
    L54:
        if (r119 != (-2)) goto L56;
        r22.element = false;
        n r24 = (n) ZeusTransformUtils.preCheckCast(r118.getFirst(), n.class, "com.obric.memorydata.plugin");
        this.L$0 = r22;
        this.L$1 = r16;
        this.L$2 = r15;
        this.L$3 = r117;
        this.L$4 = r14;
        this.L$5 = null;
        this.L$6 = null;
        this.label = 6;
        if (r24.b(this) != r1) goto L75;
        return r1;
    L75:
        r9 = r14;
        r12 = r16;
        r13 = r22;
        r11 = r15;
        r10 = r117;
        goto L76
    L56:
        if (r119 == (-1)) goto L78;
        if (r119 == 0) goto L59;
        r22.element = false;
        goto L79
    L59:
        ((j.b) ZeusTransformUtils.preCheckCast(r118.getSecond(), j.b.class, "com.obric.memorydata.plugin")).a(((n) ZeusTransformUtils.preCheckCast(r118.getFirst(), n.class, "com.obric.memorydata.plugin")).b());
        if (((j.b) ZeusTransformUtils.preCheckCast(r118.getSecond(), j.b.class, "com.obric.memorydata.plugin")).k() == true) goto L71;
        com.obric.aikernel.runtime.utils.d.f6216a.f("DownloadTask", r117.a() + ' ' + ((j.b) ZeusTransformUtils.preCheckCast(r118.getSecond(), j.b.class, "com.obric.memorydata.plugin")).a() + " is idle but do not success download");
        if (j.d(r117).getUseObricDownloader() == true) goto L71;
        r22.element = false;
        r117.b(0);
        if (((n) ZeusTransformUtils.preCheckCast(r118.getFirst(), n.class, "com.obric.memorydata.plugin")).a() > 0) goto L68;
        n r25 = (n) ZeusTransformUtils.preCheckCast(r118.getFirst(), n.class, "com.obric.memorydata.plugin");
        this.L$0 = r22;
        this.L$1 = r16;
        this.L$2 = r15;
        this.L$3 = r117;
        this.L$4 = r14;
        this.L$5 = null;
        this.L$6 = null;
        this.label = 7;
        if (r25.a(this) != r1) goto L75;
        return r1;
    L68:
        n r26 = (n) ZeusTransformUtils.preCheckCast(r118.getFirst(), n.class, "com.obric.memorydata.plugin");
        this.L$0 = r22;
        this.L$1 = r16;
        this.L$2 = r15;
        this.L$3 = r117;
        this.L$4 = r14;
        this.L$5 = null;
        this.L$6 = null;
        this.label = 8;
        if (r26.b(this) != r1) goto L75;
        return r1;
    L71:
        r117.b(6);
        goto L79
    L81:
        this.this$0.a(r16.element / r15.element);
        if (this.this$0.f() == false) goto L91;
        if (r17.element == true) goto L91;
        if ((r16.element % 5) == 0) goto L91;
        if (j.d(this.this$0).getAppConfig().isDebug() == true) goto L91;
    L93:
        if (this.this$0.f() == false) goto L99;
        if (r17.element == true) goto L99;
        r7 = true;
    L32:
        long r27 = j.c(this.this$0);
        Continuation r28 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
        this.L$0 = r17;
        this.L$1 = null;
        this.L$2 = null;
        this.L$3 = null;
        this.L$4 = null;
        this.L$5 = null;
        this.L$6 = null;
        this.label = 3;
        if (au.a(r27, r28) != r1) goto L35;
        return r1;
    L35:
        boolean r29 = j.b(this.this$0);
        r17.element = r7;
        if (r29 == true) goto L99;
        Ref.IntRef r30 = new Ref.IntRef();
        Ref.IntRef r31 = new Ref.IntRef();
        Iterable r32 = (Iterable) ZeusTransformUtils.preCheckCast(j.a(this.this$0), Iterable.class, "com.obric.memorydata.plugin");
        r10 = this.this$0;
        r16 = r30;
        r14 = r32.iterator();
        r15 = r31;
    L99:
        if (r17.element == false) goto L101;
    L103:
        r3 = r17;
        r6 = ((Iterable) ZeusTransformUtils.preCheckCast(j.a(this.this$0), Iterable.class, "com.obric.memorydata.plugin")).iterator();
        goto L105
    L101:
        if (j.e(this.this$0) == false) goto L103;
        r17.element = true;
    L91:
        com.obric.aikernel.runtime.utils.d.f6216a.b("DownloadTask", this.this$0.a() + " downloading continueRun:" + this.this$0.f() + " finish:" + r17.element + " progress:" + r16.element + '/' + r15.element + " prior:" + this.this$0.b() + " background:" + this.this$0.c() + " size:" + this.this$0.h());
        goto L93
    L9:
        r23 = this.I$1;
        r119 = this.I$0;
        r112 = (Ref.IntRef) ZeusTransformUtils.preCheckCast(this.L$6, Ref.IntRef.class, "com.obric.memorydata.plugin");
        r118 = (Pair) ZeusTransformUtils.preCheckCast(this.L$5, Pair.class, "com.obric.memorydata.plugin");
        Iterator r120 = (Iterator) ZeusTransformUtils.preCheckCast(this.L$4, Iterator.class, "com.obric.memorydata.plugin");
        r117 = (j) ZeusTransformUtils.preCheckCast(this.L$3, j.class, "com.obric.memorydata.plugin");
        Ref.IntRef r33 = (Ref.IntRef) ZeusTransformUtils.preCheckCast(this.L$2, Ref.IntRef.class, "com.obric.memorydata.plugin");
        r16 = (Ref.IntRef) ZeusTransformUtils.preCheckCast(this.L$1, Ref.IntRef.class, "com.obric.memorydata.plugin");
        Ref.BooleanRef r34 = (Ref.BooleanRef) ZeusTransformUtils.preCheckCast(this.L$0, Ref.BooleanRef.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r19);
        r22 = r34;
        r15 = r33;
        r14 = r120;
        r116 = r19;
        goto L49
    L10:
        Pair r35 = (Pair) ZeusTransformUtils.preCheckCast(this.L$5, Pair.class, "com.obric.memorydata.plugin");
        r14 = (Iterator) ZeusTransformUtils.preCheckCast(this.L$4, Iterator.class, "com.obric.memorydata.plugin");
        r20 = (j) ZeusTransformUtils.preCheckCast(this.L$3, j.class, "com.obric.memorydata.plugin");
        r15 = (Ref.IntRef) ZeusTransformUtils.preCheckCast(this.L$2, Ref.IntRef.class, "com.obric.memorydata.plugin");
        Ref.IntRef r121 = (Ref.IntRef) ZeusTransformUtils.preCheckCast(this.L$1, Ref.IntRef.class, "com.obric.memorydata.plugin");
        Ref.BooleanRef r122 = (Ref.BooleanRef) ZeusTransformUtils.preCheckCast(this.L$0, Ref.BooleanRef.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r19);
        r111 = r19;
        r113 = r35;
        r17 = r122;
        r112 = r121;
        goto L45
    L11:
        r17 = (Ref.BooleanRef) ZeusTransformUtils.preCheckCast(this.L$0, Ref.BooleanRef.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r19);
        goto L35
    L12:
        Iterator r36 = (Iterator) ZeusTransformUtils.preCheckCast(this.L$0, Iterator.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r19);
    L22:
        if (r36.hasNext() == false) goto L31;
        Pair r37 = (Pair) ZeusTransformUtils.preCheckCast(r36.next(), Pair.class, "com.obric.memorydata.plugin");
        int r38 = ((n) ZeusTransformUtils.preCheckCast(r37.getFirst(), n.class, "com.obric.memorydata.plugin")).a();
        Object r39 = r37.getFirst();
        if (r38 <= 0) goto L25;
        n r40 = (n) ZeusTransformUtils.preCheckCast(r39, n.class, "com.obric.memorydata.plugin");
        this.L$0 = r36;
        this.label = 2;
        if (r40.b(this) != r1) goto L22;
        return r1;
    L25:
        n r41 = (n) ZeusTransformUtils.preCheckCast(r39, n.class, "com.obric.memorydata.plugin");
        this.L$0 = r36;
        this.label = 1;
        if (r41.a(this) != r1) goto L22;
        return r1;
    L31:
        r17 = new Ref.BooleanRef();
        goto L32
    L13:
        ResultKt.throwOnFailure(r19);
        j.a(this.this$0, false);
        this.this$0.b(0);
        if (j.a(this.this$0).isEmpty() == false) goto L18;
    L15:
        j.a(this.this$0, k.a(true));
        return Boxing.boxBoolean(true);
    L18:
        if (j.b(this.this$0) == true) goto L15;
        r36 = ((Iterable) ZeusTransformUtils.preCheckCast(j.a(this.this$0), Iterable.class, "com.obric.memorydata.plugin")).iterator();
        goto L22
    L5:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
