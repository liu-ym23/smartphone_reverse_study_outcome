package com.bytedance.android.ec.common.impl.order;

import com.bytedance.android.ec.core.utils.UrlBuilderV2;
import com.bytedance.android.ec.core.utils.a2;
import com.bytedance.android.ec.core.utils.z1;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import mf.b;
import nl.e;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class OpenOrderSchemaHelper implements mf.a {
    public static final Lazy b = null;
    public static final a c = null;
    public final b a;

    public static final class a {
        public a() {
        }
    }

    static {
        c = new a();
        b = LazyKt.lazy(OpenOrderSchemaHelper$Companion$orderSchemaHelperCache$2.INSTANCE);
    }

    public OpenOrderSchemaHelper(b r1) {
        this.a = r1;
    }

    @Override // mf.a
    public final String a(String r13, e r14) {
        Intrinsics.checkNotNullParameter(r13, com.bytedance.android.ec.core.event.a.KEY_SCHEMA);
        Intrinsics.checkNotNullParameter(r14, "orderSchemaVo");
        UrlBuilderV2 r0 = new UrlBuilderV2(r13);
        this.a.i(r0.getMMap(), r14);
        this.a.b(r0.getMMap(), r14);
        JSONObject r15 = this.a.h(r0.getMMap(), r14);
        if (r15 == null) goto L5;
        r0.addOrReplaceParam(com.bytedance.android.ec.core.event.a.KEY_CJ_INFO, r15);
    L5:
        JSONObject r16 = this.a.a(r0.getMMap(), r14);
        if (r16 == null) goto L8;
        r0.addOrReplaceParam(com.bytedance.android.ec.core.event.a.KEY_ENTRANCE_INFO, r16);
    L8:
        JSONObject r17 = this.a.d(r0.getMMap(), r14);
        if (r17 == null) goto L11;
        r0.addOrReplaceParam(com.bytedance.android.ec.core.event.a.KEY_LOG_DATA, r17);
    L11:
        String r18 = this.a.c(r0.getMMap(), r14);
        if (r18 == null) goto L14;
        r0.addOrReplaceParam(com.bytedance.android.ec.core.event.a.KEY_MARKET_CHANNEL, r18);
    L14:
        r0.addOrReplaceParam("page_init_timestamp", System.currentTimeMillis());
        this.a.g(r0.getMMap(), r14);
        String r19 = this.a.e(r0.getMMap(), r14);
        if (r19 == null) goto L17;
        r0.addOrReplaceParam("poi_id", r19);
    L17:
        String r110 = this.a.f(r0.getMMap(), r14);
        if (r110 == null) goto L20;
        r0.addOrReplaceParam("spell_group_id", r110);
    L20:
        Map<String, String> r111 = r0.getMMap();
        boolean r10 = Intrinsics.areEqual("1", r111.get("use_rifle"));
        String r11 = com.bytedance.android.ec.core.event.a.KEY_RIFLE_MEGA_OBJECT;
        if (r10 == false) goto L23;
        Object r12 = com.bytedance.android.ec.core.event.a.KEY_RIFLE_MEGA_OBJECT;
    L24:
        nl.a r20 = r14.h;
        JSONObject r21 = null;
        if (r20 != null) goto L27;
    L40:
        JSONObject r112 = null;
    L41:
        if (r112 == null) goto L43;
        r0.addOrReplaceParam("has_adinfojson", "1");
        r0.addOrReplaceParam("adinfojson", r112);
    L43:
        Map<String, String> r113 = r0.getMMap();
        nl.a r22 = r14.h;
        if (r22 == null) goto L71;
        String r23 = r22.d;
        if (r23 == null) goto L71;
        JSONObject r24 = z1.g(r22.c);
        if (r113.get(com.bytedance.android.ec.core.event.a.KEY_AD_EXTRA_DATA) != null) goto L51;
        if (r24 == null) goto L71;
    L51:
        if (r24 != null) goto L53;
        r24 = new JSONObject();
    L53:
        int r114 = r23.hashCode();
        if (r114 == (-1377687758)) goto L67;
        if (r114 == 3046160) goto L64;
        if (r114 == 93819220) goto L61;
    L69:
        String r115 = "";
    L70:
        r24.put(com.bytedance.android.ec.core.event.a.KEY_SOURCE_PAGE, r115);
    L72:
        if (r24 == null) goto L75;
        r0.addOrReplaceParam(com.bytedance.android.ec.core.event.a.KEY_AD_EXTRA_DATA, r24);
    L75:
        if (Intrinsics.areEqual("1", r0.getMMap().get("use_rifle")) == true) goto L78;
        r11 = "mega_object";
    L78:
        JSONObject r116 = z1.g(r0.getMMap().get(r11));
        r0.getMMap();
        nl.a r117 = r14.h;
        if (r117 != null) goto L81;
    L93:
        if (r21 == null) goto L96;
        r0.addOrReplaceParam("mega_object", r21);
    L96:
        return r0.build();
    L81:
        if (a2.b(r117.a) == true) goto L84;
        r117 = null;
    L84:
        if (r117 == null) goto L93;
        if (r116 == null) goto L93;
        r116.put(com.bytedance.android.ec.core.event.a.KEY_CID, r117.a);
        String r1 = r117.b;
        if (r1 == null) goto L89;
        r116.put(com.bytedance.android.ec.core.event.a.KEY_LOG_EXTRA, r1);
    L89:
        String r118 = r117.c;
        if (r118 == null) goto L92;
        r116.put(com.bytedance.android.ec.core.event.a.KEY_AD_EXTRA_DATA, r118);
    L92:
        r21 = r116;
        goto L93
    L61:
        if (r23.equals("blank") == false) goto L69;
        r115 = "live_product_button";
        goto L70
    L64:
        if (r23.equals("card") == false) goto L69;
        r115 = "live_card_button";
        goto L70
    L67:
        if (r23.equals(com.bytedance.android.ec.core.event.a.VALUE_CLICK_AREA_BUTTON) == false) goto L69;
        r115 = "live_confirm_button";
    L71:
        r24 = null;
        goto L72
    L27:
        if (a2.b(r20.a) == true) goto L30;
        r20 = null;
    L30:
        if (r20 == null) goto L40;
        if (r111.get(r12) != null) goto L40;
        r112 = new JSONObject();
        r112.put(com.bytedance.android.ec.core.event.a.KEY_CID, r20.a);
        String r25 = r20.b;
        if (r25 == null) goto L36;
        r112.put(com.bytedance.android.ec.core.event.a.KEY_LOG_EXTRA, r25);
    L36:
        String r26 = r20.c;
        if (r26 == null) goto L39;
        r112.put(com.bytedance.android.ec.core.event.a.KEY_AD_EXTRA_DATA, r26);
    L39:
        Unit r27 = Unit.INSTANCE;
        goto L41
    L23:
        r12 = "mega_object";
        goto L24
    }
}
