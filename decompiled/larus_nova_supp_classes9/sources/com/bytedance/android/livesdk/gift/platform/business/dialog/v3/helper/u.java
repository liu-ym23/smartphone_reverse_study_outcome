package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper;

import com.bytedance.android.annie.param.GsonMap;
import com.bytedance.android.annie.param.UtilsKt;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.livesdk.gift.model.IGiftMarketingInfo;
import com.bytedance.android.livesdk.gift.model.h1;
import com.bytedance.android.livesdk.gift.platform.core.model.ReceiverType;
import com.bytedance.common.utility.Lists;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class u {
    public static final /* synthetic */ int a = 0;

    public u() {
    }

    public static boolean c() {
        if (nz1.a.l().a() == false) goto L13;
        i12.e r0 = i12.o.b();
        if (r0 == null) goto L7;
        Object r1 = com.bytedance.android.scope.m.e.d(r0, com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.a.class);
    L8:
        com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.a r2 = (com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.a) r1;
        if (r2 != null) goto L11;
        return true;
    L11:
        if (r2.j() == true) goto L13;
        return true;
    L7:
        r1 = null;
    L13:
        return false;
    }

    static {
    }

    public static boolean d(IGiftMarketingInfo r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$isValid");
        return Lists.notEmpty(r1.getMainTitle());
    }

    public static /* synthetic */ Map b(h1 r6, IGiftMarketingInfo r7) {
        return a(r6, r7, null, null, null, null);
    }

    public static Map a(h1 r4, IGiftMarketingInfo r5, Integer r6, ReceiverType r7, Map r8, IGiftMarketingInfo r9) {
        Intrinsics.checkNotNullParameter(r4, "gift");
        Intrinsics.checkNotNullParameter(r5, "giftMarketingInfo");
        LinkedHashMap r1 = new LinkedHashMap();
        if (r8 != null) goto L36;
    L5:
        JsonElement r10 = GsonHelper.getDefault().toJsonTree(r4);     // Catch: Exception -> L35
        GsonMap r2 = null;
        if ((r10 instanceof JsonObject) == true) goto L8;
        r10 = null;
    L8:
        JsonObject r11 = (JsonObject) r10;     // Catch: Exception -> L35
        if (r11 == null) goto L11;
        GsonMap r13 = UtilsKt.i(r11);     // Catch: Exception -> L35
    L12:
        r1.put("gift", r13);     // Catch: Exception -> L35
        JsonElement r14 = GsonHelper.getDefault().toJsonTree(r5);     // Catch: Exception -> L35
        if ((r14 instanceof JsonObject) == true) goto L15;
        r14 = null;
    L15:
        JsonObject r15 = (JsonObject) r14;     // Catch: Exception -> L35
        if (r15 == null) goto L18;
        GsonMap r16 = UtilsKt.i(r15);     // Catch: Exception -> L35
    L19:
        r1.put("gift_marketing_info", r16);     // Catch: Exception -> L35
        if (v.e() == false) goto L22;
        int r17 = 1;
    L23:
        r1.put("panel_new_architecture", Integer.valueOf(r17));     // Catch: Exception -> L35
        JsonElement r18 = GsonHelper.getDefault().toJsonTree(r9);     // Catch: Exception -> L35
        if ((r18 instanceof JsonObject) == true) goto L26;
        r18 = null;
    L26:
        JsonObject r19 = (JsonObject) r18;     // Catch: Exception -> L35
        if (r19 == null) goto L29;
        r2 = UtilsKt.i(r19);     // Catch: Exception -> L35
    L29:
        r1.put("scene_marketing_info", r2);     // Catch: Exception -> L35
        if (r6 == null) goto L32;
        r1.put("page_type", Integer.valueOf(r6.intValue()));     // Catch: Exception -> L35
    L32:
        if (r7 == null) goto L34;
        r1.put("receiver_type", Integer.valueOf(r7.getValue()));     // Catch: Exception -> L35
    L34:
        return r1;
    L22:
        r17 = 0;
        goto L23
    L18:
        r16 = null;
        goto L19
    L11:
        r13 = null;
        goto L12
    L36:
        r1.put("related_gift_map", GsonHelper.get().toJson(r8));     // Catch: Exception -> L35
        goto L5
    }
}
