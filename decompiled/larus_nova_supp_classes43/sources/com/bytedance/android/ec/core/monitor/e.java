package com.bytedance.android.ec.core.monitor;

import android.net.Uri;
import com.bytedance.android.ec.core.utils.a2;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class e {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void a(Uri r13) {
        Intrinsics.checkNotNullParameter(r13, "uri");
        Intrinsics.checkNotNullParameter(com.bytedance.android.ec.core.event.a.KEY_ENTER_PRODUCT_DETAL, "scene");
        String r10 = UriProtector.getQueryParameter(r13, com.bytedance.android.ec.core.event.a.KEY_SOURCE_PAGE);
        String r11 = "";
        if (r10 != null) goto L5;
        r10 = "";
    L5:
        String r12 = UriProtector.getQueryParameter(r13, com.bytedance.android.ec.core.event.a.KEY_PROMOTION_ID);
        if (r12 != null) goto L8;
        r12 = "";
    L8:
        String r14 = UriProtector.getQueryParameter(r13, com.bytedance.android.ec.core.event.a.KEY_ECOM_ENTRANCE_FORM);
        if (r14 != null) goto L11;
        r14 = "";
    L11:
        String r15 = UriProtector.getQueryParameter(r13, com.bytedance.android.ec.core.event.a.KEY_ECOM_GROUP_TYPE);
        if (r15 == null) goto L15;
        r11 = r15;
    L15:
        List r16 = CollectionsKt.mutableListOf(new l.a[]{new l.a(com.bytedance.android.ec.core.event.a.KEY_PROMOTION_ID, "presence"), new l.a(com.bytedance.android.ec.core.event.a.KEY_SOURCE_PAGE, "presence")});
        JSONObject r17 = new JSONObject();
        r17.put(com.bytedance.android.ec.core.event.a.KEY_PROMOTION_ID, r12);
        r17.put(com.bytedance.android.ec.core.event.a.KEY_SOURCE_PAGE, r10);
        r17.put(com.bytedance.android.ec.core.event.a.KEY_ECOM_ENTRANCE_FORM, r14);
        r17.put(com.bytedance.android.ec.core.event.a.KEY_ECOM_GROUP_TYPE, r11);
        int r0 = l.a;
        l.b(r13.toString(), com.bytedance.android.ec.core.event.a.KEY_ENTER_PRODUCT_DETAL, r17, r16);
    }

    public static void b(String r10, String r11, String r12) {
        Intrinsics.checkNotNullParameter("enter_rank_list", "scene");
        Intrinsics.checkNotNullParameter(r11, "packLogId");
        if (a2.b(r10) == false) goto L5;
        return;
    L5:
        String r0 = UriProtector.getQueryParameter(UriProtector.parse(r10), com.bytedance.android.ec.core.event.a.KEY_RANK_ID);
        if (r0 != null) goto L9;
        r0 = "";
    L9:
        if (r0.length() != 0) goto L11;
        boolean r1 = true;
    L12:
        if (r1 == false) goto L18;
        int r13 = d.a;
        JSONObject r14 = new JSONObject();
        r14.put("rank_schema", r10);
        r14.put("pack_log_id", r11);
        if (r12 != null) goto L16;
        r12 = "";
    L16:
        r14.put("feed_log_id", r12);
        Unit r15 = Unit.INSTANCE;
        d.d(com.bytedance.android.ec.core.event.a.KEY_RANK_ID, "presence", null, "enter_rank_list", r14);
        return;
    L18:
        return;
    L11:
        r1 = false;
        goto L12
    }
}
