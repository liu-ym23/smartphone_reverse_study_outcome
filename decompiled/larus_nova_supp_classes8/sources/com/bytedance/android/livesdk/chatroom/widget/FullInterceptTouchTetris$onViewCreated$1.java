package com.bytedance.android.livesdk.chatroom.widget;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lzg1/i1;", "p1", "", "invoke", "(Lzg1/i1;)V", "<anonymous>"}, k = 3, mv = {1, 4, 3})
public final /* synthetic */ class FullInterceptTouchTetris$onViewCreated$1 extends FunctionReferenceImpl implements Function1<zg1.i1, Unit> {
    public FullInterceptTouchTetris$onViewCreated$1(FullInterceptTouchTetris r8) {
        super(1, r8, FullInterceptTouchTetris.class, "onEvent", "onEvent(Lcom/bytedance/android/livesdk/chatroom/event/LiveInputEvent;)V", 0);
    }

    public final void invoke(zg1.i1 r2) {
        Intrinsics.checkNotNullParameter(r2, "p1");
        FullInterceptTouchTetris r0 = (FullInterceptTouchTetris) ((CallableReference) this).receiver;
        r0.getClass();
        if (r2.b == false) goto L5;
        r0.L().setVisibility(0);
        return;
    L5:
        r0.L().setVisibility(8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((zg1.i1) r1);
        return Unit.INSTANCE;
    }
}
