package com.bytedance.android.livesdk.gift.platform.business.jsbridge.methods;

import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.browser.jsbridge.base.UpdateGiftDynamicOperationInfoResultModel;
import com.bytedance.android.livesdk.gift.platform.business.effect.assets.IAssetsManager;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import w20.kf;
import w20.z6;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a0 extends z6<kf, UpdateGiftDynamicOperationInfoResultModel> {
    public final com.bytedance.android.scope.j a;

    public a0(com.bytedance.android.scope.j r1) {
        this.a = r1;
    }

    public static void j(List r13) {
        Iterator r0 = r13.iterator();
    L3:
        long r3 = 0;
        if (r0.hasNext() == false) goto L15;
        com.bytedance.android.live.profit.privilege.model.touch.d r1 = (com.bytedance.android.live.profit.privilege.model.touch.d) r0.next();
        Long r5 = r1.getCur();
        if (r5 == null) goto L8;
        long r6 = r5.longValue();
    L9:
        Long r2 = r1.getLimit();
        if (r2 == null) goto L13;
        r3 = r2.longValue();
    L13:
        if (r6 < r3) goto L3;
        ay1.b.N.setValue(null, ay1.b.a[48], null);
        goto L3
    L8:
        r6 = 0;
        goto L9
    L15:
        HashMap r4 = (HashMap) ay1.b.O.getValue(null, ay1.b.a[49]);
        Iterator r14 = r13.iterator();     // Catch: Throwable -> L35
    L18:
        if (r14.hasNext() == false) goto L33;
        com.bytedance.android.live.profit.privilege.model.touch.d r7 = (com.bytedance.android.live.profit.privilege.model.touch.d) r14.next();     // Catch: Throwable -> L35
        String r8 = r7.getKey();     // Catch: Throwable -> L35
        Long r9 = r7.getDuration();     // Catch: Throwable -> L35
        if (r9 == null) goto L30;
        long r10 = r9.longValue();     // Catch: Throwable -> L35
        Long r11 = com.bytedance.android.live.profit.privilege.model.touch.e.a(r7);     // Catch: Throwable -> L35
        if (r11 == null) goto L24;
        long r15 = r11.longValue();     // Catch: Throwable -> L35
    L26:
        if (r10 <= 0) goto L30;
        if (r15 != 0) goto L30;
        com.bytedance.android.live.profit.privilege.model.touch.e.b(r7, Long.valueOf((System.currentTimeMillis() / ((long) IAssetsManager.DownloadAssetsSource.SOURCE_LOCAL_SEND_GIFT_NOW)) + r10));     // Catch: Throwable -> L35
        goto L30
    L24:
        r15 = 0;
    L30:
        String r16 = GsonProtectorUtils.toJson(GsonHelper.get(), r7);     // Catch: Throwable -> L35
        if (r8 == null) goto L18;
        r4.put(r8, r16);     // Catch: Throwable -> L35
        goto L18
    L33:
        Intrinsics.checkNotNullParameter(r4, "<set-?>");     // Catch: Throwable -> L35
        ay1.b.O.setValue(null, ay1.b.a[49], r4);     // Catch: Throwable -> L35
        return;
    }

    public final void invoke(Object r2, CallContext r3) {
        kf r4 = (kf) r2;
        Intrinsics.checkNotNullParameter(r4, "params");
        Intrinsics.checkNotNullParameter(r3, "context");
        String r5 = r4.a();
        if (r5 != null) goto L5;
    L8:
        boolean r0 = true;
    L9:
        if (r0 == false) goto L18;
        ay1.b.N.setValue(null, ay1.b.a[48], null);
        return;
    L18:
        com.bytedance.android.live.profit.privilege.model.touch.r r6 = ((com.bytedance.android.live.profit.privilege.model.touch.p) ListProtector.get(GsonHelper.fromJsonArray(r5, com.bytedance.android.live.profit.privilege.model.touch.p.class), 0)).getMeta();     // Catch: JSONException -> L17
        if (r6 == null) goto L21;
        List r7 = r6.getFreqCtrlParamsList();     // Catch: JSONException -> L17
        if (r7 == null) goto L22;
        j(r7);     // Catch: JSONException -> L17
        return;
    L22:
        return;
    L21:
        return;
    L23:
        return;
    L5:
        if (r5.length() == 0) goto L8;
        r0 = false;
        goto L9
    }
}
