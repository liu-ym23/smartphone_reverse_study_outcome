package com.bytedance.android.ec.core.monitor.listener;

import com.bytedance.android.ec.base.api.ai.AIStateLogRequest;
import com.bytedance.android.ec.core.monitor.ECProcessMonitor;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a extends ActionRateListener {
    public final Function0<Unit> j;

    /* JADX INFO: renamed from: com.bytedance.android.ec.core.monitor.listener.a$a, reason: collision with other inner class name */
    public static final class C0142a {
    }

    static {
    }

    public a(String r10, Function0<Unit> r11) {
        Intrinsics.checkNotNullParameter(r10, AIStateLogRequest.SOURCE_PAGE);
        Intrinsics.checkNotNullParameter(r11, "fullFill");
        super(r10, "add_2_cart", r11);
        this.j = r11;
    }

    public final void j(boolean r10, int r11) {
        JSONObject r0 = new JSONObject();
        r0.put("use_new_api", r10);
        r0.put("scene_type", r11);
        Unit r12 = Unit.INSTANCE;
        ActionRateListener.c(this, r0, null, false, 6);
    }

    public static void k(a r10, int r11, String r12, Integer r13, String r14, int r15) {
        String r1 = null;
        if ((r15 & 2) == 0) goto L6;
        r12 = null;
    L6:
        if ((r15 & 4) == 0) goto L9;
        r13 = null;
    L9:
        if ((r15 & 8) == 0) goto L11;
        r14 = null;
    L11:
        switch(r11) {
            case -7: goto L19;
            case -6: goto L18;
            case -5: goto L17;
            case -4: goto L16;
            case -3: goto L15;
            case -2: goto L14;
            case -1: goto L13;
            default: goto L12;
        };
    L12:
        String r16 = "";
    L20:
        Set<String> r0 = ECProcessMonitor.a;
        String r17 = r10.g;
        String r18 = r10.h;
        Integer r19 = Integer.valueOf(r11);
        if (r12 != null) goto L23;
    L31:
        String r20 = r16;
    L32:
        JSONObject r21 = r10.b;
        if (r13 == null) goto L35;
        r21.put("status_code_sku", r13.intValue());
    L35:
        if (r14 == null) goto L37;
        r21.put("status_message_sku", r14);
    L37:
        Unit r22 = Unit.INSTANCE;
        ECProcessMonitor.n(r10, r17, r18, r19, r20, r21);
        r10.j.invoke();
        return;
    L23:
        if (r12.length() <= 0) goto L25;
        boolean r23 = true;
    L26:
        if (r23 == false) goto L28;
        r1 = r12;
    L28:
        if (r1 == null) goto L31;
        r20 = r1;
        goto L32
    L25:
        r23 = false;
        goto L26
    L13:
        r16 = "单sku加购common_skus接口请求失败";
        goto L20
    L14:
        r16 = "缺少必要参数如comboId/promotionId/productId，端上拦截";
        goto L20
    L15:
        r16 = "法务检查失败";
        goto L20
    L16:
        r16 = "置灰后无法点击";
        goto L20
    L17:
        r16 = "加购接口请求失败";
        goto L20
    L18:
        r16 = "当前选择数量为0";
        goto L20
    L19:
        r16 = "SkuInfo为空";
        goto L20
    }
}
