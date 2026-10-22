package com.bytedance.android.ec.core.monitor.listener;

import com.bytedance.android.ec.core.monitor.ECProcessMonitor;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class d extends ActionRateListener {
    public static final /* synthetic */ int k = 0;
    public final Function0<Unit> j;

    public static final class a {
    }

    static {
    }

    public d(Function0<Unit> r10) {
        Intrinsics.checkNotNullParameter(r10, "fullFill");
        super("ec_product_detail", "enter_page", r10);
        this.j = r10;
    }

    public final void j(int r10, String r11) {
        switch(r10) {
            case -6: goto L9;
            case -5: goto L8;
            case -4: goto L7;
            case -3: goto L6;
            case -2: goto L5;
            case -1: goto L4;
            default: goto L3;
        };
    L3:
        String r0 = "";
    L10:
        Set<String> r1 = ECProcessMonitor.a;
        String r12 = this.g;
        String r13 = this.f;
        if (r13 != null) goto L13;
        r13 = this.h;
    L13:
        String r14 = r13;
        Integer r15 = Integer.valueOf(r10);
        if (r11 != null) goto L16;
    L25:
        String r16 = r0;
    L26:
        ECProcessMonitor.n(this, r12, r14, r15, r16, this.b);
        this.j.invoke();
        return;
    L16:
        if (r11.length() <= 0) goto L18;
        boolean r17 = true;
    L19:
        if (r17 == true) goto L22;
        r11 = null;
    L22:
        if (r11 == null) goto L25;
        r16 = r11;
        goto L26
    L18:
        r17 = false;
        goto L19
    L4:
        r0 = "反爬验证码弹窗";
        goto L10
    L5:
        r0 = "入参合法性检查失败";
        goto L10
    L6:
        r0 = "商详实例生成/打开失败";
        goto L10
    L7:
        r0 = "用户未登录";
        goto L10
    L8:
        r0 = "法务弹窗";
        goto L10
    L9:
        r0 = "页面曝光前用户主动退出商详";
        goto L10
    }
}
