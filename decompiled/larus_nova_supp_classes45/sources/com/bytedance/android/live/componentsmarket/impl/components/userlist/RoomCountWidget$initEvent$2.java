package com.bytedance.android.live.componentsmarket.impl.components.userlist;

import android.view.View;
import com.bytedance.ies.sdk.widgets.Widget;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lbh1/b;", "p1", "", "invoke", "(Lbh1/b;)V", "<anonymous>"}, k = 3, mv = {1, 4, 3})
final /* synthetic */ class RoomCountWidget$initEvent$2 extends FunctionReferenceImpl implements Function1<bh1.b, Unit> {
    public RoomCountWidget$initEvent$2(RoomCountWidget r8) {
        super(1, r8, RoomCountWidget.class, "onEvent", "onEvent(Lcom/bytedance/android/livesdk/chatroom/event/layerevent/LiveInputEventForTetris;)V", 0);
    }

    public final void invoke(bh1.b r2) {
        Intrinsics.checkNotNullParameter(r2, "p1");
        View r0 = ((Widget) ((RoomCountWidget) ((CallableReference) this).receiver)).contentView;
        if (r0 == null) goto L6;
        r0.setTranslationY(r2.a);
        return;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((bh1.b) r1);
        return Unit.INSTANCE;
    }
}
