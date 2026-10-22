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
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lbh1/a;", "p1", "", "invoke", "(Lbh1/a;)V", "<anonymous>"}, k = 3, mv = {1, 4, 3})
final /* synthetic */ class RoomCountWidget$initEvent$1 extends FunctionReferenceImpl implements Function1<bh1.a, Unit> {
    public RoomCountWidget$initEvent$1(RoomCountWidget r8) {
        super(1, r8, RoomCountWidget.class, "onEvent", "onEvent(Lcom/bytedance/android/livesdk/chatroom/event/layerevent/HideTitleLayoutEvent;)V", 0);
    }

    public final void invoke(bh1.a r2) {
        Intrinsics.checkNotNullParameter(r2, "p1");
        RoomCountWidget r0 = (RoomCountWidget) ((CallableReference) this).receiver;
        r0.getClass();
        if (r2.a == false) goto L5;
        int r3 = 4;
    L6:
        View r1 = ((Widget) r0).contentView;
        if (r1 == null) goto L10;
        r1.setVisibility(r3);
        return;
    L10:
        return;
    L5:
        r3 = 0;
        goto L6
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((bh1.a) r1);
        return Unit.INSTANCE;
    }
}
