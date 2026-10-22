package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior;

import android.app.Activity;
import androidx.appcompat.app.AppCompatActivity;
import com.bytedance.android.live.core.utils.ContextUtil;
import com.bytedance.android.livehostapi.business.IHostLiveLocalLife;
import com.bytedance.android.livehostapi.business.depend.locallife.ILiveLocalLifeFragmentDelegate;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "p1", "", "invoke"}, k = 3, mv = {1, 4, 3})
public final /* synthetic */ class ToolbarGroupPurchaseAudienceBehavior$initAnchorView$2 extends FunctionReferenceImpl implements Function1<String, Unit> {
    public ToolbarGroupPurchaseAudienceBehavior$initAnchorView$2(ToolbarGroupPurchaseAudienceBehavior r8) {
        super(1, r8, ToolbarGroupPurchaseAudienceBehavior.class, "openGoodsDetail", "openGoodsDetail(Ljava/lang/String;)V", 0);
    }

    public final void invoke(String r9) {
        ToolbarGroupPurchaseAudienceBehavior r0 = (ToolbarGroupPurchaseAudienceBehavior) ((CallableReference) this).receiver;
        if (r9 != null) goto L5;
        int r10 = ToolbarGroupPurchaseAudienceBehavior.p;
        r0.getClass();
        return;
    L5:
        Activity r1 = ContextUtil.contextToActivity(r0.o);
        ILiveLocalLifeFragmentDelegate r3 = null;
        if ((r1 instanceof AppCompatActivity) == true) goto L8;
        r1 = null;
    L8:
        AppCompatActivity r2 = (AppCompatActivity) r1;
        if (r2 == null) goto L18;
        IHostLiveLocalLife r4 = r0.d();
        if (r4 == null) goto L18;
        Pair[] r5 = new Pair[2];
        r5[0] = TuplesKt.to("life_req_id", r0.e.optString("request_id"));
        Room r6 = r0.c;
        if (r6 == null) goto L16;
        long r7 = r6.id;
    L17:
        r5[1] = TuplesKt.to("life_room_id", String.valueOf(r7));
        String r8 = r4.createBtmSourceToken(r2, "c565869.d0", MapsKt.mutableMapOf(r5));
    L19:
        IHostLiveLocalLife r11 = r0.d();
        if (r11 == null) goto L27;
        String r12 = r0.c(r9, r8);
        DataCenter r13 = r0.a;
        if (r13 == null) goto L25;
        String r14 = com.bytedance.android.live.core.utils.z.d(r13, null);
        if (r14 == null) goto L25;
    L26:
        r3 = r11.getLiveGoodsDetailDialogFragment(r12, true, r14);
    L25:
        r14 = "";
    L27:
        r0.l = r3;
        if (r3 == null) goto L32;
        r3.show(r0.o, "live_goods_detail_dialog_fragment");
        return;
    L32:
        return;
    L16:
        r7 = 0;
    L18:
        r8 = null;
        goto L19
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((String) r1);
        return Unit.INSTANCE;
    }
}
