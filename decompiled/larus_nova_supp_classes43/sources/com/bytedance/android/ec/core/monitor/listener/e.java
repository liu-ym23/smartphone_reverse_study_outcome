package com.bytedance.android.ec.core.monitor.listener;

import com.bytedance.android.ec.core.monitor.ECProcessMonitor;
import com.bytedance.android.ec.core.utils.x0;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class e extends ActionRateListener {
    public static final /* synthetic */ int k = 0;
    public final Function0<Unit> j;

    public static final class a {
    }

    static {
    }

    public final void k() {
        Set<String> r0 = ECProcessMonitor.a;
        String r1 = this.g;
        String r10 = this.h;
        JSONObject r11 = this.b;
        JSONObject r12 = this.c;
        Intrinsics.checkNotNullParameter(this, "listener");
        Intrinsics.checkNotNullParameter("inner_start", "rateType");
        Intrinsics.checkNotNullParameter(r1, "pageName");
        Intrinsics.checkNotNullParameter(r10, "actionName");
        boolean r13 = this.a;
        if (r11 == null) goto L5;
        JSONObject r14 = x0.a(r11);
    L6:
        r14.put("event_type", "rate");
        r14.put(com.bytedance.android.ec.core.event.a.KEY_PAGE_NAME, r1);
        r14.put("action_name", r10);
        r14.put("rate_type", "inner_start");
        Unit r15 = Unit.INSTANCE;
        JSONObject r16 = r14;
        ECProcessMonitor.i(r13, 0, "ec_full_trade_process_monitor", r16, null, r12, ECProcessMonitor.r(r1, ""));
        this.d = System.currentTimeMillis();
        return;
    L5:
        r14 = new JSONObject();
        goto L6
    }

    public e(Function0<Unit> r10) {
        Intrinsics.checkNotNullParameter(r10, "fullFill");
        super("ec_sku", "enter_page", r10);
        this.j = r10;
        this.e = false;
    }

    public final void j(Integer r10, String r11) {
        if (r10 != null) goto L5;
    L7:
        if (r10 != null) goto L10;
    L12:
        if (r10 != null) goto L15;
    L17:
        if (r10 != null) goto L20;
    L22:
        if (r10 != null) goto L25;
    L27:
        String r0 = "";
    L28:
        Set<String> r1 = ECProcessMonitor.a;
        String r12 = this.g;
        String r13 = this.h;
        if (r11 != null) goto L31;
    L40:
        String r14 = r0;
    L41:
        ECProcessMonitor.m(this, r12, r13, r10, r14, this.b, this.c);
        this.j.invoke();
        return;
    L31:
        if (r11.length() <= 0) goto L33;
        boolean r15 = true;
    L34:
        if (r15 == true) goto L37;
        r11 = null;
    L37:
        if (r11 == null) goto L40;
        r14 = r11;
        goto L41
    L33:
        r15 = false;
        goto L34
    L25:
        if (r10.intValue() != (-1)) goto L27;
        r0 = "sku主接口请求出错";
        goto L28
    L20:
        if (r10.intValue() != (-5)) goto L22;
        r0 = "entrance_info解析出错";
        goto L28
    L15:
        if (r10.intValue() != (-4)) goto L17;
        r0 = "不支持加入购物车";
        goto L28
    L10:
        if (r10.intValue() != (-2)) goto L12;
        r0 = "入参合法性检查失败";
        goto L28
    L5:
        if (r10.intValue() != (-3)) goto L7;
        r0 = "法务检查失败";
        goto L28
    }
}
