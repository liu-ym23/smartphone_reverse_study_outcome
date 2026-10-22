package com.bytedance.android.live.browser.jsbridge.newmethods;

import android.os.Bundle;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.browser.jsbridge.base.OpenPaidRightsFullViewResultModel;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.vscore_api.paidlive.IPaidOuterService;
import com.bytedance.android.livesdkapi.paid.PaidPrivilegeItem;
import com.bytedance.android.livesdkapi.paid.SimpleVideoItem;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.google.gson.JsonObject;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@XBridgeMethod(biz = "webcast", name = "openPaidRightsFullView")
public final class x8 extends w20.q4<w20.pc, OpenPaidRightsFullViewResultModel> {
    public x8() {
    }

    public final void invoke(Object r7, CallContext r8) {
        w20.pc r9 = (w20.pc) r7;
        Intrinsics.checkNotNullParameter(r9, "params");
        Intrinsics.checkNotNullParameter(r8, "context");
        Serializable r0 = new PaidPrivilegeItem();
        r0.setType(r9.getType());
        w20.pc.a r1 = r9.e();
        String r2 = "";
        if (r1 == null) goto L6;
        String r3 = r1.b();
        if (r3 == null) goto L6;
    L7:
        r0.setTitle(r3);
        w20.pc.a r4 = r9.e();
        if (r4 == null) goto L11;
        String r5 = r4.a();
        if (r5 == null) goto L11;
    L12:
        r0.setDescription(r5);
        String r6 = r9.a();
        if (r6 == null) goto L16;
        r2 = r6;
    L16:
        r0.setHybridSchema(r2);
        Integer r11 = r9.f();
        int r12 = 0;
        if (r11 == null) goto L19;
        int r13 = r11.intValue();
    L20:
        r0.setClickVideoIndex(r13);
        r0.setVideoList(new ArrayList());
        Boolean r14 = r9.c();
        if (r14 == null) goto L23;
        boolean r15 = r14.booleanValue();
    L24:
        r0.setNeedBanRecord4Paid(r15);
        Boolean r16 = r9.d();
        if (r16 == null) goto L27;
        boolean r17 = r16.booleanValue();
    L28:
        r0.setNeedHistoryStart(r17);
        JsonObject r18 = r9.b();
        if (r18 != null) goto L48;
    L33:
        w20.pc.a r19 = r9.e();
        if (r19 == null) goto L43;
        List<String> r21 = r19.c();
        if (r21 == null) goto L43;
        int r22 = r21.size();
    L38:
        if (r12 >= r22) goto L43;
        List r23 = r0.getVideoList();
        if (r23 == null) goto L42;
        SimpleVideoItem r24 = new SimpleVideoItem();
        r24.setVideoModelStr((String) ListProtector.get(r21, r12));
        Unit r25 = Unit.INSTANCE;
        r23.add(r24);
    L42:
        r12 = r12 + 1;
    L43:
        Bundle r26 = new Bundle();
        r26.putSerializable("paid_privilege_item", r0);
        IPaidOuterService r27 = jc1.k.f(IPaidOuterService.class);
        if (r27 == null) goto L46;
        r27.startPaidPrivilegeFullPage(r8.getContext(), r26);
    L46:
        finishWithResult(null);
        return;
    L48:
        r0.setExtraLogMap((Map) GsonHelper.get().fromJson(r18.toString(), Map.class));     // Catch: Exception -> L32
        ALogger.i("OpenPaidRightsFullViewMethod", String.valueOf(r0.getExtraLogMap()));     // Catch: Exception -> L32
        goto L33
    L27:
        r17 = false;
        goto L28
    L23:
        r15 = false;
        goto L24
    L19:
        r13 = 0;
    L11:
        r5 = "";
    L6:
        r3 = "";
        goto L7
    }
}
