package com.bytedance.android.livesdk.chatroom.widget.landscape;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import zg1.x0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lzg1/x0;", "p1", "", "invoke", "(Lzg1/x0;)V", "<anonymous>"}, k = 3, mv = {1, 4, 3})
public final /* synthetic */ class LandscapeMaskWidget$onLoad$1$1 extends FunctionReferenceImpl implements Function1<x0, Unit> {
    public LandscapeMaskWidget$onLoad$1$1(LandscapeMaskWidget r8) {
        super(1, r8, LandscapeMaskWidget.class, "onEvent", "onEvent(Lcom/bytedance/android/livesdk/chatroom/event/LandscapeRootViewChangeEvent;)V", 0);
    }

    public final void invoke(x0 r2) {
        Intrinsics.checkNotNullParameter(r2, "p1");
        ((LandscapeMaskWidget) ((CallableReference) this).receiver).onEvent(r2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((x0) r1);
        return Unit.INSTANCE;
    }
}
