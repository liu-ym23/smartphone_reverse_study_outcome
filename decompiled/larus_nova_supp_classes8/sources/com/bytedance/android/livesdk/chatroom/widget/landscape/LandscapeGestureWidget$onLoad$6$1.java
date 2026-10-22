package com.bytedance.android.livesdk.chatroom.widget.landscape;

import com.bytedance.common.utility.UIUtils;
import com.bytedance.ies.sdk.widgets.Widget;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import zg1.x0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lzg1/x0;", "p1", "", "invoke", "(Lzg1/x0;)V", "<anonymous>"}, k = 3, mv = {1, 4, 3})
public final /* synthetic */ class LandscapeGestureWidget$onLoad$6$1 extends FunctionReferenceImpl implements Function1<x0, Unit> {
    public LandscapeGestureWidget$onLoad$6$1(LandscapeGestureWidget r8) {
        super(1, r8, LandscapeGestureWidget.class, "handleViewChange", "handleViewChange(Lcom/bytedance/android/livesdk/chatroom/event/LandscapeRootViewChangeEvent;)V", 0);
    }

    public final void invoke(x0 r4) {
        Intrinsics.checkNotNullParameter(r4, "p1");
        LandscapeGestureWidget r0 = (LandscapeGestureWidget) ((CallableReference) this).receiver;
        int r1 = LandscapeGestureWidget.M;
        UIUtils.updateLayoutMargin(((Widget) r0).contentView, -r4.c, -3, -r4.d, -3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((x0) r1);
        return Unit.INSTANCE;
    }
}
