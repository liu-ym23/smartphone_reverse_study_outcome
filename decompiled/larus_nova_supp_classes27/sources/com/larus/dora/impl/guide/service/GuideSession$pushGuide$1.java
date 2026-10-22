package com.larus.dora.impl.guide.service;

import com.larus.dora.impl.guide.common.DoraGuideMeta;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import t39.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.guide.service.GuideSession$pushGuide$1", f = "DoraGuideServiceImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class GuideSession$pushGuide$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    final /* synthetic */ DoraGuideMeta $guideMeta;
    int label;
    final /* synthetic */ GuideSession this$0;

    public GuideSession$pushGuide$1(GuideSession r1, DoraGuideMeta r2, Continuation<? super GuideSession$pushGuide$1> r3) {
        this.this$0 = r1;
        this.$guideMeta = r2;
        super(1, r3);
    }

    public final Continuation<Unit> create(Continuation<?> r4) {
        return new GuideSession$pushGuide$1(this.this$0, this.$guideMeta, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((Continuation) r1);
    }

    public final Object invoke(Continuation<? super Unit> r2) {
        return create(r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r7) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L57;
        ResultKt.throwOnFailure(r7);
        GuideSession r8 = this.this$0;
        if (r8.c != GuideSession.GuideSessionState.FINISHED) goto L58;
        g49.d.e(r8.c(), "pushGuide ignored: session already finished");
        return Unit.INSTANCE;
    L58:
        l r9 = r8.i;     // Catch: Exception -> L49
        boolean r0 = false;
        if (r9 != null) goto L11;
    L13:
        boolean r10 = false;
    L14:
        CopyOnWriteArrayList<l> r2 = this.this$0.j;     // Catch: Exception -> L49
        DoraGuideMeta r3 = this.$guideMeta;     // Catch: Exception -> L49
        if ((r2 instanceof Collection) == true) goto L17;
    L19:
        Iterator<T> r4 = r2.iterator();     // Catch: Exception -> L49
    L21:
        if (r4.hasNext() == false) goto L28;
        if (((l) r4.next()).f() != r3.getGuideId()) goto L25;
        boolean r5 = true;
    L26:
        if (r5 == false) goto L21;
        boolean r6 = true;
    L29:
        if (r10 == true) goto L40;
        if (r6 == true) goto L40;
        if (this.this$0.f.contains(Boxing.boxInt(this.$guideMeta.getGuideId())) == true) goto L35;
        g49.d.d(this.this$0.c(), "pushGuide failed: guide not in filter list id=" + this.$guideMeta.getGuideId());     // Catch: Exception -> L49
    L51:
        GuideSession r11 = this.this$0;
        if (r11.c != GuideSession.GuideSessionState.PAUSED) goto L55;
        r11.e(new GuideSession$launchNextGuide$1(r11, null));
    L55:
        return Unit.INSTANCE;
    L35:
        l r12 = new i59.d(this.this$0).a(this.$guideMeta.getGuideId());     // Catch: Exception -> L49
        if (r12 != null) goto L39;
        g49.d.d(this.this$0.c(), "pushGuide failed: guide not found id=" + this.$guideMeta.getGuideId());     // Catch: Exception -> L49
        return Unit.INSTANCE;
    L39:
        Boxing.boxBoolean(this.this$0.j.add(r12));     // Catch: Exception -> L49
    L40:
        String r13 = this.this$0.c();     // Catch: Exception -> L49
        StringBuilder r14 = new StringBuilder();     // Catch: Exception -> L49
        r14.append("pushGuide ignored: guide id already exists or showing id=");     // Catch: Exception -> L49
        r14.append(this.$guideMeta.getGuideId());     // Catch: Exception -> L49
        r14.append(", isShowing=");     // Catch: Exception -> L49
        if (r10 == false) goto L43;
        boolean r15 = true;
    L44:
        r14.append(r15);     // Catch: Exception -> L49
        r14.append(", inQueue=");     // Catch: Exception -> L49
        if (r6 == false) goto L47;
        r0 = true;
    L47:
        r14.append(r0);     // Catch: Exception -> L49
        g49.d.d(r13, r14.toString());     // Catch: Exception -> L49
        goto L51
    L43:
        r15 = false;
        goto L44
    L25:
        r5 = false;
    L28:
        r6 = false;
        goto L29
    L17:
        if (r2.isEmpty() == false) goto L19;
    L11:
        if (r9.f() != this.$guideMeta.getGuideId()) goto L13;
        r10 = true;
    L49:
        e = move-exception;
        g49.d.c(this.this$0.c(), "pushGuide() exception: " + e.getMessage(), e);
        this.this$0.h(GuideSession.GuideSessionState.FINISHED);
        goto L51
    L57:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
