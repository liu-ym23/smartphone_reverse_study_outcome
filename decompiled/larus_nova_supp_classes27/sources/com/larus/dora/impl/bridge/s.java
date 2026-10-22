package com.larus.dora.impl.bridge;

import android.content.Intent;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeMethodName;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeParamField;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeParamModel;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeResultModel;
import com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseParamModel;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseResultModel;
import com.larus.doc.sdk.impl.BuildConfig;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@XBridgeMethod(name = "dora.base.openApp")
public final class s extends XCoreIDLBridgeMethod<b, c> {

    @XBridgeMethodName(name = "dora.base.openApp")
    public final String a;

    public static final class a {
    }

    @XBridgeParamModel
    public interface b extends XBaseParamModel {
        @XBridgeParamField(isGetter = true, keyPath = "pkg", required = BuildConfig.DEBUG)
        String getPkg();

        @XBridgeParamField(isGetter = true, keyPath = "probeScheme", required = BuildConfig.DEBUG)
        String getProbeScheme();

        @XBridgeParamField(isGetter = true, keyPath = "url", required = true)
        String getUrl();
    }

    @XBridgeResultModel
    public interface c extends XBaseResultModel {
        @XBridgeParamField(isGetter = true, keyPath = "opened", required = BuildConfig.DEBUG)
        Boolean getOpened();

        @XBridgeParamField(isGetter = BuildConfig.DEBUG, keyPath = "opened", required = BuildConfig.DEBUG)
        void setOpened(Boolean r1);
    }

    static {
    }

    public s() {
        this.a = "dora.base.openApp";
    }

    public final String getName() {
        return this.a;
    }

    public final void handle(IBDXBridgeContext r5, XBaseParamModel r6, CompletionBlock r7) {
        b r8 = (b) r6;
        Intrinsics.checkNotNullParameter(r5, "bridgeContext");
        Intrinsics.checkNotNullParameter(r8, "params");
        Intrinsics.checkNotNullParameter(r7, "callback");
        String r9 = r8.getUrl();
        String r10 = r8.getPkg();
        boolean r0 = false;
        if (r9 != null) goto L5;
    L8:
        boolean r2 = true;
    L10:
        if (r2 == false) goto L12;
        r7.onFailure(-3, "url is required", ne7.e.b(c.class));
        return;
    L12:
        if (r10 != null) goto L14;
    L15:
        r0 = true;
    L16:
        if (r0 == false) goto L18;
        r7.onFailure(-3, "pkg is required on android", ne7.e.b(c.class));
        return;
    L18:
        int r1 = t.a;
        Intrinsics.checkNotNullParameter(r9, "url");
        boolean r11 = t.a(new Intent("android.intent.action.VIEW", UriProtector.parse(r9)).setPackage(r10), r9);
        FLogger.a.i("DoraOpenAppMethod", "dora.base.openApp pkg=" + r10 + " opened=" + r11);
        c r12 = ne7.e.b(c.class);
        r12.setOpened(Boolean.valueOf(r11));
        CompletionBlock.DefaultImpls.onSuccess$default(r7, r12, null, 2, null);
        return;
    L14:
        if (StringsKt.isBlank(r10) == false) goto L16;
    L5:
        if (StringsKt.isBlank(r9) == true) goto L8;
        r2 = false;
        goto L10
    }
}
