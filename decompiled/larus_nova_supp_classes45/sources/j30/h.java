package j30;

import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.core.setting.SettingUtil;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.Iterator;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class h extends com.bytedance.android.live.browser.jsbridge.state.b<JsonObject> {
    @Override // com.bytedance.android.live.browser.jsbridge.state.a
    public final /* bridge */ /* synthetic */ Object b() {
        return null;
    }

    @Override // com.bytedance.android.live.browser.jsbridge.state.a
    public final char c() {
        return ':';
    }

    @Override // com.bytedance.android.live.browser.jsbridge.state.a
    public final com.bytedance.android.live.browser.jsbridge.state.a<JsonObject> g() {
        return this;
    }

    public h() {
    }

    @Override // com.bytedance.android.live.browser.jsbridge.state.a
    public final com.bytedance.android.live.browser.jsbridge.i.f d() {
        return com.bytedance.android.live.browser.jsbridge.i.g.C0113i.b;
    }

    @Override // com.bytedance.android.live.browser.jsbridge.state.a
    public final JsonElement e(String r9) {
        Intrinsics.checkNotNullParameter(r9, "key");
        JsonObject r0 = new JsonObject();
        Iterator r11 = SequencesKt.drop(CollectionsKt.asSequence(StringsKt.split$default(r9, new String[]{":"}, false, 0, 6, null)), 1).iterator();
    L4:
        if (r11.hasNext() == false) goto L22;
        String r2 = (String) r11.next();
        Gson r3 = GsonHelper.get();
        Object r4 = SettingUtil.getRawValue("key_ttlive_sdk_setting", r2);
        if (r4 != null) goto L8;
        JsonElement r5 = null;
    L21:
        r0.add(r2, r5);
        goto L4
    L8:
        if ((r4 instanceof JSONObject) == false) goto L11;
        r5 = GsonProtectorUtils.toJsonTree(r3, GsonProtectorUtils.fromJson(r3, r4.toString(), Object.class));
        goto L21
    L11:
        if ((r4 instanceof JSONArray) == false) goto L14;
        r5 = GsonProtectorUtils.toJsonTree(r3, GsonProtectorUtils.fromJson(r3, r4.toString(), new g().getType()));
        goto L21
    L14:
        if ((r4 instanceof Boolean) == true) goto L16;
        r5 = GsonProtectorUtils.toJsonTree(r3, r4);
        goto L21
    L16:
        if (((Boolean) r4).booleanValue() == false) goto L18;
        r5 = GsonProtectorUtils.toJsonTree(r3, 1);
        goto L21
    L18:
        r5 = GsonProtectorUtils.toJsonTree(r3, 0);
        goto L21
    L22:
        return r0;
    }
}
