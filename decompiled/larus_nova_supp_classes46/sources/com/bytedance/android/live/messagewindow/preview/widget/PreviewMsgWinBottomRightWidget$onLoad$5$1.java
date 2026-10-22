package com.bytedance.android.live.messagewindow.preview.widget;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import o70.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lo70/b;", "p1", "", "invoke", "(Lo70/b;)V", "<anonymous>"}, k = 3, mv = {1, 4, 3})
public final /* synthetic */ class PreviewMsgWinBottomRightWidget$onLoad$5$1 extends FunctionReferenceImpl implements Function1<b, Unit> {
    public PreviewMsgWinBottomRightWidget$onLoad$5$1(PreviewMsgWinBottomRightWidget r8) {
        super(1, r8, PreviewMsgWinBottomRightWidget.class, "onEvent", "onEvent(Lcom/bytedance/android/live/core/tetris/layer/core/event/LayerEvent;)V", 0);
    }

    public final void invoke(b r2) {
        Intrinsics.checkNotNullParameter(r2, "p1");
        ((PreviewMsgWinBottomRightWidget) ((CallableReference) this).receiver).onEvent(r2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((b) r1);
        return Unit.INSTANCE;
    }
}
