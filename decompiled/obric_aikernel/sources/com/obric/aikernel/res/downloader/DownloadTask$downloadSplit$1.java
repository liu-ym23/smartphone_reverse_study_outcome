package com.obric.aikernel.res.downloader;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.obric.aikernel.runtime.utils.NetworkUtil;
import java.util.Iterator;
import java.util.List;
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
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.l0;

/* JADX INFO: loaded from: classes2.dex */
@DebugMetadata(c = "com.obric.aikernel.res.downloader.DownloadTask$downloadSplit$1", f = "DownloadTask.kt", i = {2, 3, 3, 3, 3, 4, 4, 4, 4, 4, 5, 5, 5, 6, 6, 6, 7, 7, 7, 8, 9}, l = {TypedValues.AttributesType.TYPE_PIVOT_TARGET, 320, 326, 337, 340, 358, 369, 371, 398, 403}, m = "invokeSuspend", n = {"finished", "finished", "progress", "total", "it", "finished", "progress", "total", "it", "status", "finished", "progress", "total", "finished", "progress", "total", "finished", "progress", "total", "finished", "finished"}, s = {"L$0", "L$0", "L$1", "L$2", "L$5", "L$0", "L$1", "L$2", "L$5", "I$0", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$0", "L$0"})
final class DownloadTask$downloadSplit$1 extends SuspendLambda implements Function2<l0, Continuation<? super Boolean>, Object> {
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
    final /* synthetic */ DownloadTask this$0;

    DownloadTask$downloadSplit$1(DownloadTask r10, Continuation<? super DownloadTask$downloadSplit$1> r11) {
        this.this$0 = r10;
        super(2, r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        return new DownloadTask$downloadSplit$1(this.this$0, r11);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(l0 r10, Continuation<? super Boolean> r11) {
        return invoke2(r10, r11);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(l0 r10, Continuation<? super Boolean> r11) {
        return ((DownloadTask$downloadSplit$1) create(r10, r11)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:38:0x014c -> B:39:0x0168). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:75:0x02e3 -> B:76:0x02e7). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:79:0x0333 -> B:80:0x0337). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r19) {
        Object r10 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        boolean r11 = true;
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
        Iterator r12 = (Iterator) this.L$1;
        Ref.BooleanRef r13 = (Ref.BooleanRef) this.L$0;
        ResultKt.throwOnFailure(r19);
    L113:
        if (r12.hasNext() == false) goto L117;
        j r14 = (j) ((Pair) r12.next()).getFirst();
        this.L$0 = r13;
        this.L$1 = r12;
        this.L$2 = null;
        this.L$3 = null;
        this.L$4 = null;
        this.L$5 = null;
        this.L$6 = null;
        this.label = 10;
        if (r14.f(this) != r10) goto L113;
        return r10;
    L117:
        DownloadTask.f(this.this$0, h.d(true));
    L118:
        Boolean r15 = Boxing.boxBoolean(r13.element);
        DownloadTask r16 = this.this$0;
        r15.booleanValue();
        com.obric.aikernel.runtime.utils.d.f5417a.d("DownloadTask", r16.v() + " downloadSplit end finish:" + r13.element);
        return r15;
    L7:
        Iterator r17 = (Iterator) this.L$1;
        r13 = (Ref.BooleanRef) this.L$0;
        ResultKt.throwOnFailure(r19);
    L105:
        if (r17.hasNext() == false) goto L110;
        j r18 = (j) ((Pair) r17.next()).getFirst();
        this.L$0 = r13;
        this.L$1 = r17;
        this.L$2 = null;
        this.L$3 = null;
        this.L$4 = null;
        this.L$5 = null;
        this.L$6 = null;
        this.label = 9;
        if (r18.g(this) != r10) goto L105;
        return r10;
    L110:
        if (r13.element == false) goto L118;
        r12 = DownloadTask.d(this.this$0).iterator();
        goto L113
    L8:
        Iterator r20 = (Iterator) this.L$4;
        DownloadTask r21 = (DownloadTask) this.L$3;
        Ref.IntRef r110 = (Ref.IntRef) this.L$2;
        Ref.IntRef r111 = (Ref.IntRef) this.L$1;
        Ref.BooleanRef r112 = (Ref.BooleanRef) this.L$0;
        ResultKt.throwOnFailure(r19);
    L76:
        Iterator r22 = r20;
        Ref.BooleanRef r23 = r112;
        Ref.IntRef r113 = r111;
        DownloadTask r114 = r21;
        Ref.IntRef r24 = r113;
    L40:
        if (r22.hasNext() == false) goto L81;
        Pair r115 = (Pair) r22.next();
        j r116 = (j) r115.getFirst();
        this.L$0 = r23;
        this.L$1 = r24;
        this.L$2 = r110;
        this.L$3 = r114;
        this.L$4 = r22;
        this.L$5 = r115;
        this.L$6 = null;
        this.label = 4;
        Object r117 = r116.d(this);
        if (r117 != r10) goto L44;
        return r10;
    L44:
        r112 = r23;
        Ref.IntRef r25 = r110;
        Ref.IntRef r118 = r24;
        DownloadTask r26 = r114;
        Pair r119 = r115;
    L45:
        int r120 = ((Number) r117).intValue();
        com.obric.aikernel.runtime.utils.d.f5417a.i("DownloadTask", r26.v() + ' ' + ((DownloadTask.b) r119.getSecond()).c() + " status: " + r120);
        int r27 = r118.element;
        j r121 = (j) r119.getFirst();
        this.L$0 = r112;
        this.L$1 = r118;
        this.L$2 = r25;
        this.L$3 = r26;
        this.L$4 = r22;
        this.L$5 = r119;
        this.L$6 = r118;
        this.I$0 = r120;
        this.I$1 = r27;
        this.label = 5;
        Object r122 = r121.h(this);
        if (r122 != r10) goto L48;
        return r10;
    L48:
        Ref.IntRef r123 = r118;
        Ref.IntRef r28 = r25;
        int r29 = r27;
        DownloadTask r124 = r26;
        int r30 = r120;
    L49:
        r118.element = r29 + ((Number) r122).intValue();
        r28.element += 100;
        if (r30 != (-4)) goto L52;
    L78:
        r124.P(h.a(((DownloadTask.b) r119.getSecond()).d(), NetworkUtil.f5399a.e(DownloadTask.c(r124).getContext()), h.b(DownloadTask.c(r124))));
        ((DownloadTask.b) r119.getSecond()).l(false);
    L79:
        r110 = r28;
        r23 = r112;
        r114 = r124;
        r24 = r123;
        goto L40
    L52:
        if (r30 != (-3)) goto L54;
        ((DownloadTask.b) r119.getSecond()).l(((j) r119.getFirst()).b());
        goto L79
    L54:
        if (r30 != (-2)) goto L56;
        r112.element = false;
        j r31 = (j) r119.getFirst();
        this.L$0 = r112;
        this.L$1 = r123;
        this.L$2 = r28;
        this.L$3 = r124;
        this.L$4 = r22;
        this.L$5 = null;
        this.L$6 = null;
        this.label = 6;
        if (r31.i(this) != r10) goto L75;
        return r10;
    L75:
        r20 = r22;
        r110 = r28;
        r21 = r124;
        r111 = r123;
        goto L76
    L56:
        if (r30 == (-1)) goto L78;
        if (r30 == 0) goto L59;
        r112.element = false;
        goto L79
    L59:
        ((DownloadTask.b) r119.getSecond()).l(((j) r119.getFirst()).b());
        if (((DownloadTask.b) r119.getSecond()).h() == true) goto L71;
        com.obric.aikernel.runtime.utils.d.f5417a.l("DownloadTask", r124.v() + ' ' + ((DownloadTask.b) r119.getSecond()).c() + " is idle but do not success download");
        if (DownloadTask.c(r124).getUseObricDownloader() == true) goto L71;
        r112.element = false;
        r124.P(0);
        if (((j) r119.getFirst()).getId() > 0) goto L68;
        j r32 = (j) r119.getFirst();
        this.L$0 = r112;
        this.L$1 = r123;
        this.L$2 = r28;
        this.L$3 = r124;
        this.L$4 = r22;
        this.L$5 = null;
        this.L$6 = null;
        this.label = 7;
        if (r32.c(this) != r10) goto L75;
        return r10;
    L68:
        j r33 = (j) r119.getFirst();
        this.L$0 = r112;
        this.L$1 = r123;
        this.L$2 = r28;
        this.L$3 = r124;
        this.L$4 = r22;
        this.L$5 = null;
        this.L$6 = null;
        this.label = 8;
        if (r33.i(this) != r10) goto L75;
        return r10;
    L71:
        r124.P(6);
        goto L79
    L81:
        this.this$0.M(r24.element / r110.element);
        if (this.this$0.r() == false) goto L91;
        if (r23.element == true) goto L91;
        if ((r24.element % 5) == 0) goto L91;
        if (DownloadTask.c(this.this$0).getAppConfig().isDebug() == true) goto L91;
    L93:
        if (this.this$0.r() == false) goto L99;
        if (r23.element == true) goto L99;
        r11 = true;
    L32:
        long r34 = DownloadTask.e(this.this$0);
        this.L$0 = r23;
        this.L$1 = null;
        this.L$2 = null;
        this.L$3 = null;
        this.L$4 = null;
        this.L$5 = null;
        this.L$6 = null;
        this.label = 3;
        if (DelayKt.b(r34, this) != r10) goto L35;
        return r10;
    L35:
        boolean r35 = DownloadTask.g(this.this$0);
        r23.element = r11;
        if (r35 == true) goto L99;
        Ref.IntRef r36 = new Ref.IntRef();
        Ref.IntRef r37 = new Ref.IntRef();
        List r125 = DownloadTask.d(this.this$0);
        r114 = this.this$0;
        r24 = r36;
        r22 = r125.iterator();
        r110 = r37;
    L99:
        if (r23.element == false) goto L101;
    L103:
        r13 = r23;
        r17 = DownloadTask.d(this.this$0).iterator();
        goto L105
    L101:
        if (DownloadTask.b(this.this$0) == false) goto L103;
        r23.element = true;
    L91:
        com.obric.aikernel.runtime.utils.d.f5417a.i("DownloadTask", this.this$0.v() + " downloading continueRun:" + this.this$0.r() + " finish:" + r23.element + " progress:" + r24.element + '/' + r110.element + " prior:" + this.this$0.w() + " background:" + this.this$0.q() + " size:" + this.this$0.u());
        goto L93
    L9:
        r29 = this.I$1;
        r30 = this.I$0;
        r118 = (Ref.IntRef) this.L$6;
        r119 = (Pair) this.L$5;
        Iterator r126 = (Iterator) this.L$4;
        r124 = (DownloadTask) this.L$3;
        Ref.IntRef r127 = (Ref.IntRef) this.L$2;
        r123 = (Ref.IntRef) this.L$1;
        Ref.BooleanRef r38 = (Ref.BooleanRef) this.L$0;
        ResultKt.throwOnFailure(r19);
        r28 = r127;
        r122 = r19;
        r112 = r38;
        r22 = r126;
        goto L49
    L10:
        Pair r39 = (Pair) this.L$5;
        r22 = (Iterator) this.L$4;
        r26 = (DownloadTask) this.L$3;
        Ref.IntRef r128 = (Ref.IntRef) this.L$2;
        Ref.IntRef r129 = (Ref.IntRef) this.L$1;
        r112 = (Ref.BooleanRef) this.L$0;
        ResultKt.throwOnFailure(r19);
        r117 = r19;
        r119 = r39;
        r25 = r128;
        r118 = r129;
        goto L45
    L11:
        r23 = (Ref.BooleanRef) this.L$0;
        ResultKt.throwOnFailure(r19);
        goto L35
    L12:
        Iterator r40 = (Iterator) this.L$0;
        ResultKt.throwOnFailure(r19);
    L22:
        if (r40.hasNext() == false) goto L31;
        Pair r41 = (Pair) r40.next();
        int r42 = ((j) r41.getFirst()).getId();
        j r43 = (j) r41.getFirst();
        this.L$0 = r40;
        if (r42 <= 0) goto L25;
        this.label = 2;
        if (r43.i(this) != r10) goto L22;
        return r10;
    L25:
        this.label = 1;
        if (r43.c(this) != r10) goto L22;
        return r10;
    L31:
        r23 = new Ref.BooleanRef();
        goto L32
    L13:
        ResultKt.throwOnFailure(r19);
        DownloadTask.f(this.this$0, false);
        this.this$0.P(0);
        if (DownloadTask.d(this.this$0).isEmpty() == false) goto L18;
    L15:
        DownloadTask.f(this.this$0, h.d(true));
        return Boxing.boxBoolean(true);
    L18:
        if (DownloadTask.g(this.this$0) == true) goto L15;
        r40 = DownloadTask.d(this.this$0).iterator();
        goto L22
    L5:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
