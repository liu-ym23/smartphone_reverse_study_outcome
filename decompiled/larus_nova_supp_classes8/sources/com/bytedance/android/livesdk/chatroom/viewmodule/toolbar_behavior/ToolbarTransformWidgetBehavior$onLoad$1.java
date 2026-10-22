package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior;

import com.bytedance.android.live.user.IUserService;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/event/h0;", "p1", "", "invoke", "(Lcom/bytedance/android/livesdk/event/h0;)V", "<anonymous>"}, k = 3, mv = {1, 4, 3})
public final /* synthetic */ class ToolbarTransformWidgetBehavior$onLoad$1 extends FunctionReferenceImpl implements Function1<com.bytedance.android.livesdk.event.h0, Unit> {
    public ToolbarTransformWidgetBehavior$onLoad$1(ToolbarTransformWidgetBehavior r8) {
        super(1, r8, ToolbarTransformWidgetBehavior.class, "onEvent", "onEvent(Lcom/bytedance/android/livesdk/event/TransformWidgetOperationEvent;)V", 0);
    }

    public final void invoke(com.bytedance.android.livesdk.event.h0 r5) {
        Intrinsics.checkNotNullParameter(r5, "p1");
        ToolbarTransformWidgetBehavior r0 = (ToolbarTransformWidgetBehavior) ((CallableReference) this).receiver;
        DataCenter r1 = r0.j;
        if (r1 == null) goto L5;
        Boolean r2 = (Boolean) r1.get("data_is_anchor", Boolean.FALSE);
    L6:
        Boolean r3 = Boolean.TRUE;
        if (Intrinsics.areEqual(r2, r3) == false) goto L12;
        r0.f.a = r5.getType();
        if (r5.getType() != 3) goto L13;
        String r6 = com.bytedance.android.live.base.model.user.o.a(jc1.k.n(IUserService.class).user().b());
        int r4 = com.bytedance.android.livesdk.chatroom.utils.k0.a;
        Intrinsics.checkNotNullParameter(r6, "key");
        com.bytedance.android.livesdk.sharedpref.f.d(new com.bytedance.android.livesdk.sharedpref.e("is_card_shown_" + r6, Boolean.FALSE), r3);
        return;
    L13:
        return;
    L12:
        return;
    L5:
        r2 = null;
        goto L6
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((com.bytedance.android.livesdk.event.h0) r1);
        return Unit.INSTANCE;
    }
}
