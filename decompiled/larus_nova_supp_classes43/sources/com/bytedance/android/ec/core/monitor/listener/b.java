package com.bytedance.android.ec.core.monitor.listener;

import com.bytedance.android.ec.base.api.ai.AIStateLogRequest;
import com.bytedance.android.ec.core.monitor.ECProcessMonitor;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class b extends ActionRateListener {
    public final Function0<Unit> j;

    public static final class a {
    }

    static {
    }

    public final void j(BuyNowNextPage r10) {
        Intrinsics.checkNotNullParameter(r10, "nextPage");
        JSONObject r0 = this.b;
        r0.put(com.bytedance.android.ec.core.event.a.KEY_NEXT_PAGE, r10.getValue());
        Unit r11 = Unit.INSTANCE;
        ActionRateListener.c(this, r0, null, false, 6);
    }

    public b(String r10, Function0<Unit> r11) {
        Intrinsics.checkNotNullParameter(r10, AIStateLogRequest.SOURCE_PAGE);
        Intrinsics.checkNotNullParameter(r11, "fullFill");
        super(r10, "buy_now", r11);
        this.j = r11;
    }

    public static void k(b r10, int r11, String r12, int r13) {
        if ((r13 & 2) == 0) goto L6;
        r12 = null;
    L6:
        if (r11 != (-4)) goto L8;
        String r14 = "懂车帝商品必须选择门店才能跳转提单";
    L18:
        Set<String> r1 = ECProcessMonitor.a;
        String r15 = r10.g;
        String r16 = r10.h;
        Integer r17 = Integer.valueOf(r11);
        if (r12 != null) goto L21;
    L30:
        String r18 = r14;
    L31:
        JSONObject r19 = r10.b;
        r19.put(com.bytedance.android.ec.core.event.a.KEY_LOG_ID, null);
        Unit r20 = Unit.INSTANCE;
        ECProcessMonitor.n(r10, r15, r16, r17, r18, r19);
        r10.j.invoke();
        return;
    L21:
        if (r12.length() <= 0) goto L23;
        boolean r21 = true;
    L24:
        if (r21 == true) goto L27;
        r12 = null;
    L27:
        if (r12 == null) goto L30;
        r18 = r12;
        goto L31
    L23:
        r21 = false;
        goto L24
    L8:
        if (r11 != (-3)) goto L10;
        r14 = "法务检查失败";
        goto L18
    L10:
        if (r11 != (-2)) goto L12;
        r14 = "joinMemberUrl为空";
        goto L18
    L12:
        if (r11 == (-1)) goto L14;
        r14 = "";
        goto L18
    L14:
        r14 = "请下载抖音正式版体验";
        goto L18
    }
}
