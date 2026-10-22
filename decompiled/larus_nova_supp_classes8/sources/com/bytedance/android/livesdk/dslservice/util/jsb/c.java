package com.bytedance.android.livesdk.dslservice.util.jsb;

import android.app.Activity;
import android.view.View;
import com.bytedance.sdk.xbridge.cn.PlatformType;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class c implements IBDXBridgeContext {
    public final le7.a<?> a;
    public String b;
    public final String c;
    public final ue7.d d;
    public final String e;
    public final PlatformType f;

    public final View getEngineView() {
        return null;
    }

    public final Activity getOwnerActivity() {
        return null;
    }

    public final <T> T getService(Class<T> r2) {
        Intrinsics.checkNotNullParameter(r2, "clazz");
        return null;
    }

    public final void sendEvent(String r1, Map<String, ? extends Object> r2) {
        Intrinsics.checkNotNullParameter(r1, "eventName");
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
        return this.d;
    }

    public final String getNamespace() {
        return this.e;
    }

    public final PlatformType getPlatformType() {
        return this.f;
    }

    public c(e r6) {
        d r0 = new d();
        PlatformType r1 = PlatformType.LYNX;
        Intrinsics.checkNotNullParameter(r6, "bridgeCall");
        Intrinsics.checkNotNullParameter("", "callId");
        Intrinsics.checkNotNullParameter("", "containerID");
        Intrinsics.checkNotNullParameter(r0, "jsEventDelegate");
        Intrinsics.checkNotNullParameter("webcast", "namespace");
        Intrinsics.checkNotNullParameter(r1, "platformType");
        this.a = r6;
        this.b = "";
        this.c = "";
        this.d = r0;
        this.e = "webcast";
        this.f = r1;
    }

    public final void setCallId(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.b = r2;
    }
}
