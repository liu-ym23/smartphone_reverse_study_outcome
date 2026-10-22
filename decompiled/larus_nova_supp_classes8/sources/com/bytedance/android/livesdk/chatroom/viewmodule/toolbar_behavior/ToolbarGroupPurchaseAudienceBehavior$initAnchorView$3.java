package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "p1", "", "p2", "", "p3", "invoke"}, k = 3, mv = {1, 4, 3})
public final /* synthetic */ class ToolbarGroupPurchaseAudienceBehavior$initAnchorView$3 extends FunctionReferenceImpl implements Function3<Boolean, String, String, Unit> {
    public ToolbarGroupPurchaseAudienceBehavior$initAnchorView$3(ToolbarGroupPurchaseAudienceBehavior r8) {
        super(3, r8, ToolbarGroupPurchaseAudienceBehavior.class, "openUrl", "openUrl(ZLjava/lang/String;Ljava/lang/String;)V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2, Object r3) {
        invoke(((Boolean) r1).booleanValue(), (String) r2, (String) r3);
        return Unit.INSTANCE;
    }

    public final void invoke(boolean r3, String r4, String r5) {
        ToolbarGroupPurchaseAudienceBehavior r0 = (ToolbarGroupPurchaseAudienceBehavior) ((CallableReference) this).receiver;
        int r1 = ToolbarGroupPurchaseAudienceBehavior.p;
        r0.i(r3, r4, r5);
    }
}
