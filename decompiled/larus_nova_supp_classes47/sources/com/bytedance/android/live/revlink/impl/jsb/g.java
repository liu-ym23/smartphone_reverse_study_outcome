package com.bytedance.android.live.revlink.impl.jsb;

import com.bytedance.android.live.browser.jsbridge.base.GetAnchorPkInfoResultModel;
import com.bytedance.android.livesdk.link.model.api.IBaseBattleSetting;
import com.bytedance.ies.web.jsbridge2.CallContext;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.TypesJVMKt;
import org.json.JSONArray;
import org.json.JSONObject;
import w20.c1;
import w20.j9;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class g extends wy0.b<j9, GetAnchorPkInfoResultModel> {
    public final Type a;
    public final com.bytedance.android.live.revlink.impl.global.c b;
    public final com.bytedance.android.live.revlink.impl.lynxcontainer.a c;

    @Override // wy0.b
    public final Type k() {
        return this.a;
    }

    public g(com.bytedance.android.live.revlink.impl.global.c r1, com.bytedance.android.live.revlink.impl.lynxcontainer.a r2) {
        this.b = r1;
        this.c = r2;
        this.a = TypesJVMKt.getJavaType(Reflection.typeOf(j9.class));
    }

    @Override // wy0.b
    public final void l(vh7.j r10, CallContext r12) {
        j9 r13 = (j9) r10;
        Intrinsics.checkNotNullParameter(r13, "param");
        Intrinsics.checkNotNullParameter(r12, "callContext");
        GetAnchorPkInfoResultModel r14 = new GetAnchorPkInfoResultModel();
        r14.b(GetAnchorPkInfoResultModel.Code.Success);
        com.bytedance.android.live.revlink.impl.lynxcontainer.a r0 = this.c;
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.e r1 = null;
        if (r0 != null) goto L8;
        com.bytedance.android.live.revlink.impl.global.c r2 = this.b;
        if (r2 == null) goto L7;
        r0 = r2.w2();
        goto L8
    L7:
        r0 = null;
    L8:
        List r3 = c1.a(r13);
        if (r3 != null) goto L11;
    L30:
        String r4 = "";
        if (r0 == null) goto L39;
        JSONObject r5 = r0.f(c1.a(r13));
        if (r5 == null) goto L38;
        String r6 = r5.toString();
        if (r6 == null) goto L38;
        r4 = r6;
    L38:
        r14.c(r4);
    L54:
        jy0.b.d("GetAnchorPkInfoMethod", "param：" + c1.a(r13) + " res.data：" + r14.a());
        finishWithResult(r14);
        return;
    L39:
        List r7 = c1.a(r13);
        if (r7 == null) goto L54;
        if (r7.contains("lynx_data") != true) goto L54;
        JSONObject r8 = new JSONObject();
        com.bytedance.android.live.revlink.impl.global.c r9 = this.b;
        if (r9 == null) goto L46;
        r1 = r9.Ig();
    L46:
        if (r1 == null) goto L53;
        IBaseBattleSetting r15 = r1.getBattleSettings();
        if (r15 == null) goto L53;
        String r16 = r15.getLynxData();
        if (r16 == null) goto L53;
        r4 = r16;
    L53:
        r8.put("lynx_data", r4);
        r14.c(r8.toString());
        goto L54
    L11:
        if (r3.contains("link_anchor_list_v2") != true) goto L30;
        JSONObject r17 = new JSONObject();
        com.bytedance.android.live.revlink.impl.global.c r18 = this.b;
        if (r18 == null) goto L17;
        i11.b r19 = r18.c8();
        if (r19 == null) goto L17;
        List<com.bytedance.android.livesdk.link.model.p> r20 = r19.d();
    L18:
        if (r20 == null) goto L28;
        ArrayList r22 = new ArrayList();
        Iterator<T> r23 = r20.iterator();
    L21:
        if (r23.hasNext() == false) goto L23;
        r22.add(new JSONObject(com.bytedance.android.live.revlink.impl.multianchor.dynamic.e.e((com.bytedance.android.livesdk.link.model.p) r23.next())));
        goto L21
    L23:
        int r24 = com.bytedance.revenue.platform.api.core.b.a;
        Object r25 = JSONObject.wrap(r22);
        if (r25 == null) goto L27;
        JSONArray r26 = (JSONArray) r25;
    L29:
        r17.put("link_anchor_list_v2", r26);
        r14.c(r17.toString());
        goto L30
    L27:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.revenue.platform.api.core.JSONArray /* = org.json.JSONArray */");
    L28:
        r26 = new JSONArray();
    L17:
        r20 = null;
        goto L18
    }
}
