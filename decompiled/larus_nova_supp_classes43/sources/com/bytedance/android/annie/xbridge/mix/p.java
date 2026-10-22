package com.bytedance.android.annie.xbridge.mix;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.webkit.WebView;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.cn.PlatformType;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class p implements IBDXBridgeContext {
    public final o a;
    public String b;
    public final String c;
    public final String d;
    public final PlatformType e;
    public final a f;
    public final /* synthetic */ CallContext g;

    public static final class a implements ue7.d {
        public final /* synthetic */ CallContext a;

        public a(CallContext r1) {
            this.a = r1;
        }

        public final void a(String r10, Map<String, ? extends Object> r11) {
            Intrinsics.checkNotNullParameter(r10, "eventName");
            this.a.b(r10, r11);
        }
    }

    public final <T> T getService(Class<T> r10) {
        Intrinsics.checkNotNullParameter(r10, "clazz");
        return null;
    }

    public final View getEngineView() {
        return this.g.d;
    }

    public final Activity getOwnerActivity() {
        Context r0 = this.g.getContext();
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type android.app.Activity");
        return (Activity) r0;
    }

    public final le7.a<?> getBridgeCall() {
        return this.a;
    }

    public final String getCallId() {
        return this.b;
    }

    public final String getContainerID() {
        return this.c;
    }

    public final ue7.d getJsEventDelegate() {
        return this.f;
    }

    public final String getNamespace() {
        return this.d;
    }

    public final PlatformType getPlatformType() {
        return this.e;
    }

    public final void setCallId(String r10) {
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        this.b = r10;
    }

    public p(o r1, CallContext r10) {
        this.g = r10;
        this.a = r1;
        this.b = "bridgeCall.jsb2.id";
        this.c = String.valueOf(r10.getContext().hashCode());
        this.d = "webcast";
        List<String> r11 = s.a;
        if ((r10.d instanceof WebView) == false) goto L5;
        PlatformType r12 = PlatformType.WEB;
    L6:
        this.e = r12;
        this.f = new a(r10);
        return;
    L5:
        r12 = PlatformType.LYNX;
        goto L6
    }

    public final void sendEvent(String r10, Map<String, ? extends Object> r11) {
        Intrinsics.checkNotNullParameter(r10, "eventName");
        this.f.a(r10, r11);
    }
}
