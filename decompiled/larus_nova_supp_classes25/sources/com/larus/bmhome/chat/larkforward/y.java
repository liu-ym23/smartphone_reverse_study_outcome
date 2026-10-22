package com.larus.bmhome.chat.larkforward;

import com.larus.im.callback.IIMCallback;
import com.larus.im.callback.IIMError;
import com.larus.im.internal.delegate.y0;
import com.larus.utils.logger.FLogger;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class y implements IIMCallback<wc9.e> {
    public final /* synthetic */ AtomicBoolean a;
    public final /* synthetic */ Ref.ObjectRef<Runnable> b;
    public final /* synthetic */ FlowLarkToDoubaoServiceImpl c;
    public final /* synthetic */ FlowLarkToDoubaoServiceImpl.a d;
    public final /* synthetic */ Function1<FlowLarkToDoubaoServiceImpl.c, Unit> e;

    public final boolean mustInMain() {
        return !y0.a();
    }

    public final void onFailure(IIMError r10) {
        Intrinsics.checkNotNullParameter(r10, "error");
        FLogger.a.w("FlowLarkToDoubaoService", "get main conversation failed, code=" + r10.getCode() + ", tips=" + r10.getTips());
        FlowLarkToDoubaoServiceImpl.f(this.a, this.b, this.c, this.d, this.e, null, false);
    }

    public final void onSuccess(Object r8) {
        AtomicBoolean r0 = this.a;
        Ref.ObjectRef<Runnable> r1 = this.b;
        FlowLarkToDoubaoServiceImpl r2 = this.c;
        FlowLarkToDoubaoServiceImpl.a r3 = this.d;
        Function1<FlowLarkToDoubaoServiceImpl.c, Unit> r4 = this.e;
        FlowLarkToDoubaoServiceImpl.f(r0, r1, r2, r3, r4, (wc9.e) r8, true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public y(AtomicBoolean r1, Ref.ObjectRef<Runnable> r2, FlowLarkToDoubaoServiceImpl r3, FlowLarkToDoubaoServiceImpl.a r4, Function1<? super FlowLarkToDoubaoServiceImpl.c, Unit> r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }
}
