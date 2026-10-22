package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior;

import com.bytedance.android.livehostapi.business.IHostLiveLocalLife;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "p1", "", "p2", "p3", "p4", "invoke"}, k = 3, mv = {1, 4, 3})
public final /* synthetic */ class ToolbarGroupPurchaseAudienceBehavior$initAnchorView$5 extends FunctionReferenceImpl implements Function4<String, String, String, String, Unit> {
    public ToolbarGroupPurchaseAudienceBehavior$initAnchorView$5(ToolbarGroupPurchaseAudienceBehavior r8) {
        super(4, r8, ToolbarGroupPurchaseAudienceBehavior.class, "openGoodsMp", "openGoodsMp(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", 0);
    }

    public final void invoke(String r10, String r11, String r12, String r13) {
        ToolbarGroupPurchaseAudienceBehavior r0 = (ToolbarGroupPurchaseAudienceBehavior) ((CallableReference) this).receiver;
        if (r0.d == null) goto L15;
        IHostLiveLocalLife r2 = r0.d();
        if (r2 == null) goto L14;
        DataCenter r1 = r0.a;
        if (r1 == null) goto L11;
        String r3 = com.bytedance.android.live.core.utils.z.d(r1, null);
        if (r3 == null) goto L11;
    L12:
        r2.openMiniApp(r3, r0.o, r10, r11, r12, r13);
        return;
    L11:
        r3 = "";
        goto L12
    L14:
        return;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2, Object r3, Object r4) {
        invoke((String) r1, (String) r2, (String) r3, (String) r4);
        return Unit.INSTANCE;
    }
}
