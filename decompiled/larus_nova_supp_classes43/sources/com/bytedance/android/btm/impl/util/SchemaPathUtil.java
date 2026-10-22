package com.bytedance.android.btm.impl.util;

import android.os.MessageQueue;
import com.bytedance.android.btm.api.BtmHostDependManager;
import com.bytedance.android.btm.api.inner.ALogger;
import com.bytedance.android.btm.api.model.BufferBtm;
import com.bytedance.android.btm.api.tool.BtmDebugTool;
import com.bytedance.android.btm.impl.page.BtmPageRecorder;
import com.bytedance.android.btm.impl.page.BufferQueue;
import com.bytedance.android.btm.impl.page.model.PageInfo;
import com.bytedance.android.btm.impl.page.model.PageInfoStack;
import com.bytedance.android.btm.impl.setting.BtmSetting;
import com.bytedance.android.ec.base.api.ai.AIStateLogRequest;
import java.util.Map;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class SchemaPathUtil {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void a(PageInfo r11, String r12) {
        if (r11 == null) goto L5;
        r11.setBtmPreSetFromSourceBtmToken(true);
    L5:
        if (r11 == null) goto L7;
        r11.setUpdateBySourceBtmTokenInThisDisplay(true);
    L7:
        String r13 = BtmPageRecorder.a;
        if (r12 != null) goto L10;
    L13:
        boolean r14 = true;
    L14:
        if (r14 == false) goto L16;
        return;
    L16:
        if (BtmSetting.d.c().c().b() != 1) goto L24;
        Map<String, com.bytedance.android.btm.api.model.e> r15 = BtmPageRecorder.k;
        com.bytedance.android.btm.api.model.e r0 = r15.get(r12);
        if (r0 == null) goto L23;
        r15.put(r12, new com.bytedance.android.btm.api.model.e(r0.a, r0.b, r0.c, r0.d, r0.e, true, r0.g, r0.h, r0.i));
        return;
    L23:
        return;
    L24:
        return;
    L10:
        if (r12.length() == 0) goto L13;
        r14 = false;
        goto L14
    }

    public static void b(final PageInfo r10, final BufferBtm r11) {
        if (r10.getBtmPreSetFromSourceBtmToken() == true) goto L5;
        return;
    L5:
        if (r11 != null) goto L8;
        return;
    L8:
        if ((!Intrinsics.areEqual(r10.getBtmPre(), r11.getBtm())) == false) goto L11;
        MessageQueue r0 = b.a;
        b.a(new SchemaPathUtil$monitorBtmPreDiff$1(r10, r11));
        return;
    }

    public static void c(final Object r22, final String r23) {
        if (BtmSetting.d.c().c().F().d() == 1) goto L5;
        return;
    L5:
        String r10 = BtmPageRecorder.a;
        PageInfoStack r11 = BtmPageRecorder.k(r22);
        if (r11 == null) goto L8;
        final PageInfo r12 = r11.current();
    L9:
        ALogger r13 = ALogger.d;
        ALogger.g(r13, "SourceBtmToken:updateBtmPage", new SchemaPathUtil$updateBtmPage$1(r22, r23, r12));
        final Ref.ObjectRef r14 = new Ref.ObjectRef();
        String r15 = "";
        r14.element = "";
        String r16 = BufferQueue.a;
        final BufferBtm r17 = BufferQueue.g(r23, "update_btm_page", new SchemaPathUtil$updateBtmPage$bufferBtm$1(r14));
        boolean r18 = false;
        if (r17 != null) goto L24;
        if (r23 != null) goto L13;
    L16:
        boolean r19 = true;
    L17:
        if (r19 == true) goto L24;
        JSONObject r110 = new JSONObject();
        r110.putOpt("page_info", r12);
        r110.putOpt("type", "updateBtmPage");
        r110.putOpt("source_btm_token", r23);
        com.bytedance.android.btm.impl.setting.f r20 = com.bytedance.android.btm.impl.quality.b.a;
        if (r12 == null) goto L23;
        String r21 = r12.getPageBtm();
        if (r21 == null) goto L23;
        r15 = r21;
    L23:
        com.bytedance.android.btm.impl.quality.b.b(2314, r15, r110);
        goto L24
    L13:
        if (r23.length() == 0) goto L16;
        r19 = false;
    L24:
        ALogger.g(r13, "SourceBtmToken:updateBtmPage", new SchemaPathUtil$updateBtmPage$2(r22, r23, r17, r12));
        if (BtmHostDependManager.F.c() == false) goto L70;
        Lazy r24 = BtmDebugTool.a;
        JSONObject r25 = new JSONObject();
        r25.put("pageType", "CreateOrConsumption");     // Catch: Throwable -> L33
        r25.put("type", "update");     // Catch: Throwable -> L33
        if (r23 != null) goto L30;
    L34:
        boolean r26 = true;
    L35:
        if (r26 == true) goto L37;
        r25.put("source_btm_token", r23);     // Catch: Throwable -> L33
    L37:
        r25.put(AIStateLogRequest.SOURCE_PAGE, r22.getClass().getCanonicalName());     // Catch: Throwable -> L33
        if (r17 == null) goto L41;
        r25.put("success", 1);     // Catch: Throwable -> L33
        goto L42
    L41:
        r25.put("success", 0);     // Catch: Throwable -> L33
        r25.put("reason", StringsKt.replace$default((String) r14.element, "consume", "replace", false, 4, null));     // Catch: Throwable -> L33
        goto L42
    L30:
        if (r23.length() == 0) goto L34;
        r26 = false;
    L42:
        BtmDebugTool.c(r25);
        if (BtmHostDependManager.F.c() == false) goto L70;
        Lazy r27 = BtmDebugTool.a;
        JSONObject r28 = new JSONObject();
        r28.put("pageType", "Register");     // Catch: Throwable -> L73
        if (r12 == null) goto L48;
        String r29 = r12.getPageBtm();     // Catch: Throwable -> L73
    L49:
        r28.put("btm", r29);     // Catch: Throwable -> L73
        if (r12 == null) goto L52;
        String r30 = r12.getPageBtm();     // Catch: Throwable -> L73
    L53:
        r28.put("page_btm", r30);     // Catch: Throwable -> L73
        r28.put("type", "consume");     // Catch: Throwable -> L73
        if (r23 != null) goto L56;
    L57:
        r18 = true;
    L58:
        if (r18 == true) goto L60;
        r28.put("source_btm_token", r23);     // Catch: Throwable -> L73
    L60:
        r28.put(AIStateLogRequest.SOURCE_PAGE, r22.getClass().getCanonicalName());     // Catch: Throwable -> L73
        r28.put("isHybridContainer", "0");     // Catch: Throwable -> L73
        r28.put("btmOriginPage", r22.toString());     // Catch: Throwable -> L73
        if (r12 == null) goto L63;
        String r31 = r12.getPageId();     // Catch: Throwable -> L73
    L64:
        r28.put("btmFinalPage", r31);     // Catch: Throwable -> L73
        if (r12 == null) goto L67;
        String r32 = r12.getPageBtm();     // Catch: Throwable -> L73
    L68:
        r28.put("finalPageOriginBtm", r32);     // Catch: Throwable -> L73
        goto L69
    L67:
        r32 = null;
        goto L68
    L63:
        r31 = null;
        goto L64
    L56:
        if (r23.length() != 0) goto L58;
    L52:
        r30 = null;
        goto L53
    L48:
        r29 = null;
    L69:
        BtmDebugTool.c(r28);
    L70:
        if (r17 == null) goto L77;
        a(r12, r23);
        String r1 = BtmPageRecorder.a;
        BtmPageRecorder.n(r22, r17.getBtm(), r17.getStep() + 1, r17.getPageId(), false, true);
        return;
    L77:
        return;
    L8:
        r12 = null;
        goto L9
    }
}
