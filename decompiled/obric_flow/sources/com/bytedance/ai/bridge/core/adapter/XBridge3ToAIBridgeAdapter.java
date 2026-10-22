package com.bytedance.ai.bridge.core.adapter;

import androidx.core.util.Consumer;
import com.bytedance.ai.settings.AISDKSettingConfigManager;
import com.bytedance.sdk.xbridge.cn.platform.web.g;
import com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod;
import com.google.gson.JsonObject;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import n1.c;
import o1.a;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/ai/bridge/core/adapter/XBridge3ToAIBridgeAdapter;", "Lo1/a;", "i4/a", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class XBridge3ToAIBridgeAdapter implements a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final g f1808b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final IDLXBridgeMethod f1809a;

    static {
        f1808b = new g();
    }

    public XBridge3ToAIBridgeAdapter(IDLXBridgeMethod r5) {
        Intrinsics.checkNotNullParameter(r5, "bridgeMethod");
        this.f1809a = r5;
    }

    @Override // o1.a
    public final List getAltNames() {
        return null;
    }

    @Override // o1.a
    public final String getName() {
        return this.f1809a.getName();
    }

    @Override // o1.a
    public final boolean mustRunInMain() {
        if (AISDKSettingConfigManager.INSTANCE.getMUST_RUN_IN_MAIN_JSB_LIST().getValue().contains(this.f1809a.getName()) == false) goto L6;
        return true;
    L6:
        if (this.f1809a.canRunInBackground() == true) goto L8;
        return true;
    L8:
        return false;
    }

    @Override // o1.a
    public final void realHandle(c r5, JsonObject r10, Consumer r11, Consumer r12) {
        Intrinsics.checkNotNullParameter(r5, "bridgeContext");
        Intrinsics.checkNotNullParameter(r11, "resolve");
        Intrinsics.checkNotNullParameter(r12, "reject");
        if (r10 != null) goto L5;
        r10 = new JsonObject();
    L5:
        g r13 = f1808b;
        JSONObject r14 = new JSONObject(r10.toString());
        Map<String, ? extends Object> r15 = r13.f(this.f1809a.getClass(), r14);
        if (r15 != null) goto L8;
        r15 = MapsKt.emptyMap();
    L8:
        s6.c r16 = new s6.c(14, r11, r12);
        IDLXBridgeMethod r17 = this.f1809a;
        r17.realHandle(new i4.a(r5, new com.bytedance.sdk.xbridge.cn.platform.web.c(r17.getName(), "", new JSONObject())), r15, r16);
    }
}
