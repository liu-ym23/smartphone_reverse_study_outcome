package com.bytedance.android.live;

import com.bytedance.android.live.base.model.push.LivePushInfo;
import com.bytedance.android.live.room.api.base.alog.SimpleAlogArgsBuilder;
import com.bytedance.android.live.room.api.experience.log.ExpOptLog;
import com.bytedance.android.live.room.api.playopt.base.LivePlayOptUtils;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livehostapi.platform.IHostAction;
import com.bytedance.android.livesdk.utils.d5;
import com.bytedance.android.livesdk.utils.q6;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import jc1.k;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class LiveExpPushHelper {
    public static final Lazy a = null;
    public static final com.bytedance.android.livesdk.sharedpref.e<Map<String, String>> b = null;
    public static final String c = null;
    public static final HashMap<String, Boolean> d = null;

    static {
        a = LazyKt.lazy(LiveExpPushHelper$tag$2.INSTANCE);
        b = new com.bytedance.android.livesdk.sharedpref.e("key_exp_push", new LinkedHashMap());
        c = k.n(IMiddlewareUserService.class).user().n();
        d = new HashMap();
    }

    public static boolean a() {
        Lazy r0 = LivePlayOptUtils.a;
        if (((fv1.e) r0.getValue()).a() == false) goto L5;
        return false;
    L5:
        String r3 = (String) ((Map) b.getValue()).get(c);
        SimpleAlogArgsBuilder r1 = new SimpleAlogArgsBuilder();
        r1.d((String) a.getValue());
        r1.c("判断push是否处于频控");
        Pair r4 = TuplesKt.to("info", r3);
        if (r4 == null) goto L10;
        Object r5 = r4.getSecond();
        if (r5 == null) goto L10;
        r1.a((String) r4.getFirst(), r5);
    L10:
        ExpOptLog.d(r1.b());
        if (r3 != null) goto L13;
        return false;
    L13:
        if (r3.length() <= 0) goto L15;
        boolean r2 = true;
    L16:
        List r11 = null;
        if (r2 == false) goto L19;
        String r6 = r3;
    L20:
        if (r6 == null) goto L40;
        List r7 = StringsKt.split$default(r3, new String[]{","}, false, 0, 6, null);
        if (r7 != null) goto L24;
        return false;
    L24:
        if (r7.size() < 2) goto L26;
        boolean r8 = true;
    L27:
        if (r8 == false) goto L29;
        r11 = r7;
    L29:
        if (r11 == null) goto L42;
        long r9 = d5.c((String) ListProtector.get(r11, 1));
        long r12 = d5.c((String) ListProtector.get(r11, 0));
        boolean r13 = q6.a(r9);
        long r14 = ((fv1.e) r0.getValue()).c() * ((long) 1000);
        if (r13 == true) goto L33;
    L34:
        if (r13 == true) goto L36;
        return false;
    L36:
        if (Math.abs(System.currentTimeMillis() - r9) > r14) goto L44;
    L37:
        return true;
    L44:
        return false;
    L33:
        if (r12 >= ((fv1.e) r0.getValue()).d()) goto L37;
    L42:
        return false;
    L26:
        r8 = false;
        goto L27
    L40:
        return false;
    L19:
        r6 = null;
        goto L20
    L15:
        r2 = false;
        goto L16
    }

    public static void b() {
        com.bytedance.android.livesdk.sharedpref.e<Map<String, String>> r0 = b;
        Map r1 = (Map) r0.getValue();
        String r2 = c;
        String r3 = (String) r1.get(r2);
        long r9 = System.currentTimeMillis();
        long r11 = 1;
        if (r3 != null) goto L5;
    L25:
        StringBuilder r4 = new StringBuilder();
        r4.append(r11);
        r4.append(',');
        r4.append(r9);
        String r5 = r4.toString();
        SimpleAlogArgsBuilder r6 = new SimpleAlogArgsBuilder();
        r6.d((String) a.getValue());
        r6.c("保存push频控信息:" + r5);
        ExpOptLog.d(r6.b());
        ((Map) r0.getValue()).put(r2, r5);
        com.bytedance.android.livesdk.sharedpref.f.d(r0, r0.getValue());
        return;
    L5:
        if (r3.length() <= 0) goto L7;
        boolean r7 = true;
    L8:
        List r15 = null;
        if (r7 == false) goto L11;
        String r8 = r3;
    L12:
        if (r8 == null) goto L25;
        List r12 = StringsKt.split$default(r3, new String[]{","}, false, 0, 6, null);
        if (r12 == null) goto L25;
        if (r12.size() < 2) goto L18;
        boolean r13 = true;
    L19:
        if (r13 == false) goto L21;
        r15 = r12;
    L21:
        if (r15 == null) goto L25;
        SimpleDateFormat r14 = q6.a;
        if (q6.a(d5.c((String) ListProtector.get(r15, 1))) == false) goto L25;
        r11 = 1 + d5.c((String) ListProtector.get(r15, 0));
        goto L25
    L18:
        r13 = false;
        goto L19
    L11:
        r8 = null;
        goto L12
    L7:
        r7 = false;
        goto L8
    }

    public static void c(final String r4) {
        Intrinsics.checkNotNullParameter(r4, "roomId");
        boolean r0 = a();
        if (r0 == false) goto L5;
    L12:
        SimpleAlogArgsBuilder r5 = new SimpleAlogArgsBuilder();
        r5.d((String) a.getValue());
        r5.c("wifi切4G的Push被频控了, inInterval：" + r0);
        ExpOptLog.d(r5.b());
        return;
    L5:
        if (Intrinsics.areEqual(d.get(r4), Boolean.TRUE) == true) goto L12;
        IHostAction r1 = k.f(IHostAction.class);
        if (r1 == null) goto L10;
        int r2 = LivePushInfo.e;
        com.bytedance.android.live.base.model.push.b r3 = new com.bytedance.android.live.base.model.push.b();
        r3.setTitle("建议开启移动流量加速");
        r3.setContent("当前 WIFI 网络不佳，开启移动流量加速");
        r3.setButtonText("去开启");
        r3.setScene("wifi_switch_4g");
        r3.setDuration(LivePlayOptUtils.a());
        Unit r6 = Unit.INSTANCE;
        LivePushInfo.a r7 = LivePushInfo.c.a(r3);
        Function1<LivePushInfo.b, Unit> r8 = new LiveExpPushHelper$showWifiSwitch4GPush$3(r4);
        Intrinsics.checkNotNullParameter(r8, "callback");
        r7.a = r8;
        r1.showLiveCommonInnerPush(new LivePushInfo(r7));
    L10:
        b();
    }
}
