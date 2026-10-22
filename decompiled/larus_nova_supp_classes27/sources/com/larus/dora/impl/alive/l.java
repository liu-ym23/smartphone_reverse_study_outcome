package com.larus.dora.impl.alive;

import android.os.Build;
import com.larus.dora.api.model.FlowDoraWifiScene;
import com.larus.utils.j0;
import java.util.List;
import java.util.Locale;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class l {
    public static final Lazy a = null;

    static {
        a = LazyKt.lazy(new k());
    }

    public static final i a() {
        String r0 = Build.MANUFACTURER;
        if (r0 != null) goto L5;
        r0 = "";
    L5:
        g49.d.d("DoraKeepAlive", "getKeepAliveEntry: manufacturer=".concat(r0));
        Locale r2 = Locale.ROOT;
        String r3 = r0.toUpperCase(r2);
        switch(r3.hashCode()) {
            case -1712043046: goto L29;
            case -1706170181: goto L25;
            case 2432928: goto L21;
            case 2634924: goto L17;
            case 68924490: goto L13;
            case 2141820391: goto L9;
            default: goto L32;
        };
    L32:
        List r4 = CollectionsKt.listOf(new j("res:///2131240392", ""));
        String r1 = r0.toUpperCase(r2);
        if (Intrinsics.areEqual(r1, "REALME") == false) goto L36;
        int r5 = j0.a;
        j r6 = new j(b("realme.png"), j0.d(2131903278));
    L40:
        return new i(FlowDoraWifiScene.OTHER, r4, CollectionsKt.listOf(r6));
    L36:
        if (Intrinsics.areEqual(r1, "ONEPLUS") == false) goto L38;
        int r7 = j0.a;
        r6 = new j(b("oneplus.png"), j0.d(2131903274));
        goto L40
    L38:
        r6 = new j("", "");
        goto L40
    L9:
        if (r3.equals("HUAWEI") == false) goto L32;
        String r8 = b("dora_keep_alive_multi_task_locked_huawei_1_cn");
        int r9 = j0.a;
        return new i("HUAWEI", CollectionsKt.listOf(new j[]{new j(r8, j0.d(2131903303)), new j(b("dora_keep_alive_multi_task_locked_huawei_2_cn"), j0.d(2131903304))}), CollectionsKt.listOf(new j[]{new j(b("dora_keep_alive_auto_start_huawei_1_cn"), j0.d(2131903270)), new j(b("dora_keep_alive_auto_start_huawei_2_cn"), j0.d(2131903271)), new j(b("dora_keep_alive_auto_start_huawei_3_cn"), j0.d(2131903272))}));
    L13:
        if (r3.equals("HONOR") == false) goto L32;
        String r10 = b("dora_keep_alive_multi_task_locked_honor_1_cn");
        int r11 = j0.a;
        return new i("HONOR", CollectionsKt.listOf(new j[]{new j(r10, j0.d(2131903301)), new j(b("dora_keep_alive_multi_task_locked_honor_2_cn"), j0.d(2131903302))}), CollectionsKt.listOf(new j[]{new j(b("dora_keep_alive_auto_start_honor_1_cn"), j0.d(2131903267)), new j(b("dora_keep_alive_auto_start_honor_2_cn"), j0.d(2131903268)), new j(b("dora_keep_alive_auto_start_honor_3_cn"), j0.d(2131903269))}));
    L17:
        if (r3.equals("VIVO") == false) goto L32;
        String r12 = b("dora_keep_alive_multi_task_locked_vivo_1_cn");
        int r13 = j0.a;
        return new i("VIVO", CollectionsKt.listOf(new j(r12, j0.d(2131903310))), CollectionsKt.listOf(new j[]{new j(b("dora_keep_alive_auto_start_vivo_1_cn"), j0.d(2131903284)), new j(b("dora_keep_alive_auto_start_vivo_2_cn"), j0.d(2131903285)), new j(b("dora_keep_alive_auto_start_vivo_3_cn"), j0.d(2131903286))}));
    L21:
        if (r3.equals("OPPO") == false) goto L32;
        String r14 = b("dora_keep_alive_multi_task_locked_oppo_1_cn");
        int r15 = j0.a;
        return new i("OPPO", CollectionsKt.listOf(new j[]{new j(r14, j0.d(2131903305)), new j(b("dora_keep_alive_multi_task_locked_oppo_2_cn"), j0.d(2131903306))}), CollectionsKt.listOf(new j[]{new j(b("dora_keep_alive_auto_start_oppo_1_cn"), j0.d(2131903275)), new j(b("dora_keep_alive_auto_start_oppo_2_cn"), j0.d(2131903276))}));
    L25:
        if (r3.equals("XIAOMI") == false) goto L32;
        String r16 = b("dora_keep_alive_multi_task_locked_xiaomi_1_cn");
        int r17 = j0.a;
        return new i("XIAOMI", CollectionsKt.listOf(new j(r16, j0.d(2131903311))), CollectionsKt.listOf(new j[]{new j(b("dora_keep_alive_auto_start_xiaomi_1_cn"), j0.d(2131903288)), new j(b("dora_keep_alive_auto_start_xiaomi_2_cn"), j0.d(2131903289))}));
    L29:
        if (r3.equals("SAMSUNG") == false) goto L32;
        String r18 = b("dora_keep_alive_multi_task_locked_samsung_1_cn");
        int r20 = j0.a;
        return new i("SAMSUNG", CollectionsKt.listOf(new j[]{new j(r18, j0.d(2131903307)), new j(b("dora_keep_alive_multi_task_locked_samsung_2_cn"), j0.d(2131903308))}), CollectionsKt.listOf(new j[]{new j(b("dora_keep_alive_auto_start_samsung_1_cn"), j0.d(2131903279)), new j(b("dora_keep_alive_auto_start_samsung_2_cn"), j0.d(2131903280))}));
    }

    public static final String b(String r5) {
        String r0 = (String) a.getValue();
        if (r0.length() != 0) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == false) goto L9;
        r0 = "https://lf-dora-heartbeat.olafriend.com/obj/dora-heartbeat/";
    L9:
        if (StringsKt.endsWith$default(r0, "/", false, 2, null) == false) goto L12;
        return r0 + r5 + ".png";
    L12:
        return r0 + '/' + r5 + ".png";
    L5:
        r1 = false;
        goto L6
    }
}
