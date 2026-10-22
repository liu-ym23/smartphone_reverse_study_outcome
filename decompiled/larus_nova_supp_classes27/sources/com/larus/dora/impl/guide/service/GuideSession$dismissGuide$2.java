package com.larus.dora.impl.guide.service;

import com.larus.dora.impl.guide.common.DoraGuideMeta;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import t39.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.guide.service.GuideSession$dismissGuide$2", f = "DoraGuideServiceImpl.kt", i = {}, l = {568}, m = "invokeSuspend", n = {}, s = {})
public final class GuideSession$dismissGuide$2 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    final /* synthetic */ DoraGuideMeta $guideMeta;
    int label;
    final /* synthetic */ GuideSession this$0;

    public GuideSession$dismissGuide$2(GuideSession r1, DoraGuideMeta r2, Continuation<? super GuideSession$dismissGuide$2> r3) {
        this.this$0 = r1;
        this.$guideMeta = r2;
        super(1, r3);
    }

    public final Continuation<Unit> create(Continuation<?> r4) {
        return new GuideSession$dismissGuide$2(this.this$0, this.$guideMeta, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((Continuation) r1);
    }

    public final Object invoke(Continuation<? super Unit> r2) {
        return create(r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r7) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r7);
    L30:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r7);
        GuideSession r8 = this.this$0;
        if (r8.c != GuideSession.GuideSessionState.FINISHED) goto L12;
        g49.d.e(r8.c(), "dismissGuide ignored: session already finished");
        return Unit.INSTANCE;
    L12:
        CopyOnWriteArrayList<l> r9 = r8.j;
        DoraGuideMeta r2 = this.$guideMeta;
        Iterator<T> r10 = r9.iterator();
    L14:
        if (r10.hasNext() == false) goto L21;
        Object r3 = r10.next();
        if (((l) r3).f() != r2.getGuideId()) goto L18;
        boolean r4 = true;
    L19:
        if (r4 == false) goto L14;
    L22:
        l r5 = (l) r3;
        if (r5 != null) goto L26;
        g49.d.d(this.this$0.c(), "dismissGuide failed: guide not found id=" + this.$guideMeta.getGuideId());
        return Unit.INSTANCE;
    L26:
        this.this$0.j.remove(r5);
        GuideSession r11 = this.this$0;
        this.label = 1;
        if (GuideSession.a(r11, r5, this) != r0) goto L30;
        return r0;
    L18:
        r4 = false;
        goto L19
    L21:
        r3 = null;
        goto L22
    }
}
