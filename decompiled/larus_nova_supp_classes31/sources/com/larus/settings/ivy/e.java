package com.larus.settings.ivy;

import com.bytedance.news.common.settings.SettingsManager;
import com.larus.common.apphost.AppHost;
import com.larus.network.HttpConst;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class e {
    public static final ArrayList<String> a = null;
    public static final ArrayList<String> b = null;
    public static final List<String> c = null;

    static {
        HttpConst.a.getClass();
        String r12 = HttpConst.z;
        String r14 = HttpConst.A;
        ArrayList<String> r1 = CollectionsKt.arrayListOf(new String[]{"alice-boe", "gracebot.cn", "oceancloudapi.com", "boe-lingo.byteintl.net", "chatwiz.online", "cashier-my4a.pipopay.com", "cashier-my.pipopay.com", "f-p.sgsnssdk.com", r12, r14});
        String r0 = HttpConst.B;
        if (r0 != null) goto L5;
    L8:
        boolean r16 = true;
    L9:
        if (r16 == true) goto L11;
        r1.add(r0);
    L11:
        r1.add("doubao.com");
        if ("".length() != 0) goto L14;
        boolean r17 = true;
    L15:
        if (r17 == true) goto L17;
        r1.add("");
    L17:
        a = r1;
        AppHost.Companion r13 = AppHost.a;
        if (r13.isOversea() == true) goto L28;
        r1 = CollectionsKt.arrayListOf(new String[]{"alice-boe.bytedance.net", "oceancloudapi.com", "gracebot.cn", "doubao.com", "toutiao.com", "app.aisdk.gecko.local", "ots-boe.bytedance.net", "bots.bytedance.net", "bots.byteintl.net", "www.coze.cn", "www.coze.com", "lf-doubao-cdn-tos.bytegecko.com", "activity.doubao.com", "miaoda.feishu.cn", r12, r14});
        if (r0 != null) goto L22;
    L25:
        boolean r4 = true;
    L26:
        if (r4 == true) goto L28;
        r1.add(r0);
        goto L28
    L22:
        if (r0.length() == 0) goto L25;
        r4 = false;
    L28:
        b = r1;
        if (r13.isOversea() == true) goto L31;
        List<String> r2 = CollectionsKt.listOf(new String[]{HttpConst.c, HttpConst.d, "bytedance.com", "toutiao.com"});
    L32:
        c = r2;
        return;
    L31:
        r2 = CollectionsKt.listOf(new String[]{HttpConst.c, HttpConst.d});
        goto L32
    L14:
        r17 = false;
        goto L15
    L5:
        if (r0.length() == 0) goto L8;
        r16 = false;
        goto L9
    }

    public static a a() {
        return ((IHybridSettings) SettingsManager.obtain(IHybridSettings.class)).hybridCommonConfig();
    }
}
