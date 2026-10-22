package com.bytedance.ai.bridge.core.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.view.View;
import androidx.core.util.Consumer;
import bx7.b;
import com.bytedance.ai.applet.base.gson.c;
import com.bytedance.ai.bridge.core.AIBridgeMethod;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.JsonObject;
import d3.a0;
import e3.d;
import f2.k;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0016B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J6\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u0011H\u0016J\b\u0010\u0014\u001a\u00020\u0015H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\u0017"}, d2 = {"Lcom/bytedance/ai/bridge/core/adapter/XBridge3ToAIBridgeAdapter;", "Lcom/bytedance/ai/bridge/core/AIBridgeMethod;", "bridgeMethod", "Lcom/ivy/ivykit/api/bridge/core/IvyBridgeMethodInvoker;", "<init>", "(Lcom/ivy/ivykit/api/bridge/core/IvyBridgeMethodInvoker;)V", com.bytedance.android.ec.core.event.a.KEY_SHOPPING_GUIDE_NAME, "", "getName", "()Ljava/lang/String;", "realHandle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/google/gson/JsonObject;", "resolve", "Landroidx/core/util/Consumer;", "reject", "Lcom/bytedance/ai/bridge/core/AIBridgeMethod$Error;", "mustRunInMain", "", "AIBridgeCallContext", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class XBridge3ToAIBridgeAdapter implements AIBridgeMethod {
    public final b a;

    public static final class a implements bx7.a {
        public final d a;
        public final String b;

        public final View getEngineView() {
            return this.a.getEngineView();
        }

        public final Activity getOwnerActivity() {
            Activity r0 = this.a.getOwnerActivity();
            if (r0 != null) goto L12;
            View r1 = getEngineView();
            if (r1 == null) goto L7;
            Context r10 = r1.getContext();
        L8:
            Activity r11 = getActivity(r10);
            if (r11 == null) goto L11;
            return r11;
        L11:
            return k.b();
        L7:
            r10 = null;
            goto L8
        L12:
            return r0;
        }

        public a(d r10) {
            Intrinsics.checkNotNullParameter(r10, "bridgeContext");
            this.a = r10;
            a0 r11 = r10.getContainerContext();
            if (r11 == null) goto L6;
            String r12 = r11.getContainerId();
            if (r12 == null) goto L6;
        L7:
            this.b = r12;
            return;
        L6:
            r12 = "";
            goto L7
        }

        private final Activity getActivity(Context r10) {
        L3:
            if (r10 == null) goto L11;
            if ((r10 instanceof Activity) == true) goto L7;
            if ((r10 instanceof ContextWrapper) == false) goto L11;
            r10 = ((ContextWrapper) r10).getBaseContext();
            goto L3
        L7:
            return (Activity) r10;
        L11:
            return null;
        }

        public final <T> T getService(Class<T> r10) {
            Intrinsics.checkNotNullParameter(r10, "clazz");
            return (T) this.a.d(r10);
        }

        public final void sendEvent(String r10, Map<String, ? extends Object> r11) {
            Intrinsics.checkNotNullParameter(r10, "eventName");
            JsonObject r12 = GsonProtectorUtils.toJsonTree(c.a(), r11);
            if ((r12 instanceof JsonObject) == false) goto L5;
            JsonObject r13 = r12;
        L6:
            this.a.a(r10, r13);
            return;
        L5:
            r13 = null;
            goto L6
        }
    }

    @Override // com.bytedance.ai.bridge.core.AIBridgeMethod
    public final List<String> getAltNames() {
        return null;
    }

    @Override // com.bytedance.ai.bridge.core.AIBridgeMethod
    public final boolean getSupportSyncCall() {
        return false;
    }

    @Override // com.bytedance.ai.bridge.core.AIBridgeMethod
    public final String getName() {
        return this.a.getName();
    }

    @Override // com.bytedance.ai.bridge.core.AIBridgeMethod
    public final boolean mustRunInMain() {
        com.bytedance.ai.settings.a<Integer> r0 = com.bytedance.ai.settings.b.a;
        if (com.bytedance.ai.settings.b.i.a().contains(getName()) == false) goto L6;
        return true;
    L6:
        if (this.a.b() == false) goto L11;
        return false;
    L11:
        return true;
    }

    public XBridge3ToAIBridgeAdapter(b r10) {
        Intrinsics.checkNotNullParameter(r10, "bridgeMethod");
        this.a = r10;
    }

    /* JADX WARN: Type inference failed for: r3v1, types: [g3.a] */
    @Override // com.bytedance.ai.bridge.core.AIBridgeMethod
    public final void realHandle(d r10, JsonObject r11, final Consumer<JsonObject> r12, final Consumer<AIBridgeMethod.Error> r13) {
        Intrinsics.checkNotNullParameter(r10, "bridgeContext");
        Intrinsics.checkNotNullParameter(r12, "resolve");
        Intrinsics.checkNotNullParameter(r13, "reject");
        int r0 = gx7.a.a;
        if (r11 != null) goto L5;
        r11 = new JsonObject();
    L5:
        Map r14 = gx7.a.b(new JSONObject(r11.toString()));
        this.a.a(new a(r10), r14, new g3.a(this, r12, r13));
    }
}
