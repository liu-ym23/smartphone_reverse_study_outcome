package kh;

import cl.d;
import com.bytedance.android.ec.core.apt.APTNodeType;
import com.bytedance.android.ec.core.monitor.ECProcessMonitor;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.ec.sdk.helper.k;
import com.bytedance.android.ec.sdk.helper.r;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a implements com.bytedance.android.ec.core.monitor.param.b {
    public final String a;
    public final String b;

    @Override // com.bytedance.android.ec.core.monitor.param.b
    public final boolean a(String r10) {
        Intrinsics.checkNotNullParameter(r10, "curKey");
        return true;
    }

    public a(String r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "pageName");
        Intrinsics.checkNotNullParameter(r11, "sessionId");
        this.a = r10;
        this.b = r11;
    }

    @Override // com.bytedance.android.ec.core.monitor.param.b
    public final void b(String r10, JSONObject r11, Map<String, ? extends JSONObject> r12) {
        Intrinsics.checkNotNullParameter(r10, "curKey");
        Intrinsics.checkNotNullParameter(r12, "pageParams");
        d r13 = k.a();
        if (r13 == null) goto L18;
        JSONObject r14 = new JSONObject();
        r14.put(com.bytedance.android.ec.core.event.a.KEY_USER_ID, r.a.getCurrentUserId());
        ECAppInfoService r15 = ECAppInfoService.e;
        r14.put(com.bytedance.android.ec.core.event.a.KEY_DID, r15.getServerDeviceId());
        r14.put(com.bytedance.android.ec.core.event.a.KEY_APP_ID, r15.getAppId());
        JSONObject r16 = new JSONObject();
        r16.put("info", r11);
        if (Intrinsics.areEqual(r10, "enter_page") == false) goto L8;
        int r17 = APTNodeType.ENTER_PAGE.getValue();
    L17:
        r16.put("type", r17);
        r16.put(com.bytedance.android.ec.core.event.a.KEY_PAGE_NAME, this.a);
        Unit r18 = Unit.INSTANCE;
        r14.put("node", r16);
        r14.put("path_id", this.b);
        r14.put("timestamp", System.currentTimeMillis());
        r13.d(r14);
        goto L18
    L8:
        if (StringsKt.startsWith$default(r10, "request", false, 2, null) == false) goto L11;
        r17 = APTNodeType.NETWORK.getValue();
        goto L17
    L11:
        if (StringsKt.startsWith$default(r10, "outer", false, 2, null) == false) goto L14;
        r17 = APTNodeType.OUTER_SCHEMA.getValue();
        goto L17
    L14:
        if (Intrinsics.areEqual(r10, "quit_page") == false) goto L16;
        r17 = APTNodeType.QUIT_PAGE.getValue();
        goto L17
    L16:
        r17 = 0;
    L18:
        Set<String> r19 = ECProcessMonitor.a;
        if (ECProcessMonitor.a() == false) goto L22;
        Map r20 = MapsKt.mapOf(new Pair[]{TuplesKt.to("type", r10), TuplesKt.to("info", r11)});
        dm.a.b r110 = dm.a.a;
        dm.a.a(this.a + ".APT").i(r20.toString());
        return;
    }
}
