package com.bytedance.android.live.room.share.jsbridge;

import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@XBridgeMethod(biz = "webcast", name = "shareScreen")
public final class q extends com.bytedance.ies.web.jsbridge2.g<JSONObject, JSONObject> {
    public q() {
    }

    public final Object invoke(Object r12, CallContext r13) {
        JSONObject r14 = (JSONObject) r12;
        Intrinsics.checkNotNullParameter(r14, "params");
        Intrinsics.checkNotNullParameter(r13, "context");
        int r0 = JSONObjectProtectorUtils.getInt(r14, "x");
        int r1 = JSONObjectProtectorUtils.getInt(r14, "y");
        int r2 = JSONObjectProtectorUtils.getInt(r14, "width");
        int r15 = JSONObjectProtectorUtils.getInt(r14, "height");
        float r3 = fm3.e.a(r13.getContext(), r2);
        float r16 = fm3.e.a(r13.getContext(), r15);
        fa1.a r10 = new fa1.a(r13, (int) fm3.e.a(r13.getContext(), r0), (int) fm3.e.a(r13.getContext(), r1), (int) r3, (int) r16, new n(this, r13));
        if (DialogLancet.shouldBlockDialogShow(r10) == false) goto L10;
        DialogLancet.handleBlockedDialogShow(r10);
    L8:
        return new JSONObject();
    L10:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L9
    L6:
        DialogLancet.beforeDialogShow(r10);
        r10.show();
        DialogLancet.afterDialogShow(r10);
        goto L8
    }

    public static final void j(q r1, CallContext r2, boolean r3, String r4) {
        r1.getClass();
        if (Intrinsics.areEqual("qzone", r4) == false) goto L6;
        r4 = "q_zone";
    L10:
        r2.b("H5_shareCompleted", MapsKt.mapOf(new Pair[]{TuplesKt.to("isCancel", Boolean.valueOf(r3)), TuplesKt.to("platform", r4)}));
        return;
    L6:
        if (Intrinsics.areEqual("weixin_moment", r4) == false) goto L8;
    L9:
        r4 = "moments";
        goto L10
    L8:
        if (Intrinsics.areEqual("weixin_moments", r4) == false) goto L10;
        goto L9
    }
}
