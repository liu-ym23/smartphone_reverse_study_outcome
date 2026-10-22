package com.larus.e_commerce.impl.bridge;

import android.content.Context;
import com.bytedance.android.ec.base.api.ai.framework.model.PanelItem;
import com.bytedance.android.ec.host.api.hybrid.ECBaseBridgeMethod;
import com.larus.common.apphost.AppHost;
import com.larus.e_commerce.api.IECommerceService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import o89.i;
import org.json.JSONArray;
import org.json.JSONObject;
import s89.d;
import u89.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f*\u0004\u0018\u00010\u0011H\u0002J\f\u0010\u0012\u001a\u00020\u0010*\u00020\u000bH\u0002R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0013"}, d2 = {"Lcom/larus/e_commerce/impl/bridge/ECShowAppletPanelMethod;", "Lcom/bytedance/android/ec/host/api/hybrid/ECBaseBridgeMethod;", "<init>", "()V", "name", "", "getName", "()Ljava/lang/String;", "handle", "", "params", "Lorg/json/JSONObject;", "iReturn", "Lcom/bytedance/android/ec/host/api/hybrid/ECBaseBridgeMethod$IReturn;", "toPanelItems", "", "Lcom/bytedance/android/ec/base/api/ai/framework/model/PanelItem;", "Lorg/json/JSONArray;", "toPanelItem", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ECShowAppletPanelMethod extends ECBaseBridgeMethod {
    public final String e;

    public ECShowAppletPanelMethod() {
        this.e = "flow.ecShowAppletPanel";
    }

    public final String getName() {
        return this.e;
    }

    public final void c(JSONObject r23, ECBaseBridgeMethod.a r24) {
        Intrinsics.checkNotNullParameter(r23, "params");
        Intrinsics.checkNotNullParameter(r24, "iReturn");
        Context r2 = getContext();
        if (r2 != null) goto L5;
        r2 = AppHost.a.a().getCurrentActivity();
    L5:
        IECommerceService r3 = (IECommerceService) ServiceManager.get().getService(IECommerceService.class);
        if (r2 == null) goto L41;
        if (r3 == null) goto L41;
        int r4 = i.a;
        String r5 = r23.optString("scene", "");
        JSONArray r6 = r23.optJSONArray("items");
        if (r6 != null) goto L12;
        List r7 = CollectionsKt.emptyList();
    L36:
        JSONObject r0 = r23.optJSONObject("extra");
        if (r0 == null) goto L39;
        a.c(r0);
    L39:
        i.a(r2, r5, r7);
        r24.onSuccess(null);
        return;
    L12:
        int r8 = r6.length();
        ArrayList r9 = new ArrayList(r8);
        int r10 = 0;
    L13:
        if (r10 >= r8) goto L35;
        JSONObject r11 = r6.optJSONObject(r10);
        if (r11 == null) goto L33;
        String r14 = r11.optString("key", "");
        String r15 = r11.optString("title", "");
        String r12 = r11.optString("iconUrl");
        Intrinsics.checkNotNull(r12);
        if ((!StringsKt.isBlank(r12)) == false) goto L19;
        String r18 = r12;
    L20:
        PanelItem r13 = new PanelItem(r14, r15, r11.optInt("order", Integer.MAX_VALUE), null, r18, r11.optInt("line", 1), 8, null);
        JSONObject r16 = r11.optJSONObject("extra");
        if (r16 == null) goto L23;
        Map<String, Object> r17 = a.c(r16);
    L24:
        r13.setExtra(r17);
        String r110 = r11.optString("jumpUrl");
        Intrinsics.checkNotNull(r110);
        if ((!StringsKt.isBlank(r110)) == true) goto L28;
        r110 = null;
    L28:
        String r111 = r11.optString("clickEventName");
        Intrinsics.checkNotNull(r111);
        if ((true ^ StringsKt.isBlank(r111)) == true) goto L32;
        r111 = null;
    L32:
        r13.setOnClickListener(new d(r110, r111));
    L34:
        r9.add(r13);
        r10 = r10 + 1;
        goto L13
    L23:
        r17 = null;
        goto L24
    L19:
        r18 = null;
        goto L20
    L33:
        r13 = null;
        goto L34
    L35:
        r7 = CollectionsKt.filterNotNull(r9);
    L41:
        r24.onFailed(-1, "context or service is null");
    }
}
