package com.larus.suggest.impl.wcb.render;

import com.larus.bmhome.chat.bean.NexPulseResponseData;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class WcbInitialRenderDecorator$begin$1 implements q {
    public final /* synthetic */ q a;
    public final /* synthetic */ q b;
    public final /* synthetic */ WcbInitialRenderDecorator c;

    @Override // com.larus.suggest.impl.wcb.render.q
    public final Object b(Continuation<? super Unit> r2) {
        return this.a.b(r2);
    }

    @Override // com.larus.suggest.impl.wcb.render.q
    public final void c() {
        this.a.c();
    }

    @Override // com.larus.suggest.impl.wcb.render.q
    public final boolean isActive() {
        return this.a.isActive();
    }

    @Override // com.larus.suggest.impl.wcb.render.q
    public final void cancel() {
        this.c.b.b = null;
        this.b.cancel();
    }

    public WcbInitialRenderDecorator$begin$1(q r1, WcbInitialRenderDecorator r2) {
        this.b = r1;
        this.c = r2;
        this.a = r1;
    }

    @Override // com.larus.suggest.impl.wcb.render.q
    public final Object a(l r9, Continuation<? super n> r10) {
        if ((r10 instanceof WcbInitialRenderDecorator$begin$1$render$1) == false) goto L7;
        WcbInitialRenderDecorator$begin$1$render$1 r0 = (WcbInitialRenderDecorator$begin$1$render$1) r10;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r11 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        boolean r4 = true;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        ResultKt.throwOnFailure(r11);
    L25:
        n r12 = (n) r11;
        if (this.b.isActive() == true) goto L28;
    L37:
        return r12;
    L28:
        if ((r12 instanceof n.b) == false) goto L37;
        n.b r13 = (n.b) r12;
        if (Intrinsics.areEqual(r13.b.get("wcb_render_status"), "DEPRECATED") == true) goto L37;
        g r5 = this.c.b;
        r5.getClass();
        Intrinsics.checkNotNullParameter(r13, "submission");
        if (r5.a == false) goto L34;
        r4 = false;
    L35:
        if (r4 == false) goto L37;
        this.c.c.x4();
        goto L37
    L34:
        r5.b = r13;
        goto L35
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r11);
        q r14 = this.b;
        if (this.c.b.a == false) goto L17;
    L22:
        r0.label = 1;
        r11 = r14.a(r9, r0);
        if (r11 != r2) goto L25;
        return r2;
    L17:
        if ((r9 instanceof l.c) == false) goto L22;
        l.c r6 = (l.c) r9;
        if (Intrinsics.areEqual(r6.b.c, "UPDATED") == false) goto L22;
        i r15 = r6.b;
        int r7 = r15.a;
        NexPulseResponseData r8 = r15.b;
        boolean r16 = r15.d;
        Intrinsics.checkNotNullParameter(r8, "response");
        i r17 = new i(r7, r8, "DEFAULT", r16);
        p r18 = r6.a;
        Intrinsics.checkNotNullParameter(r18, "target");
        Intrinsics.checkNotNullParameter(r17, "presentation");
        r9 = new l.c(r18, r17);
    L7:
        r0 = new WcbInitialRenderDecorator$begin$1$render$1(this, r10);
        goto L8
    }
}
