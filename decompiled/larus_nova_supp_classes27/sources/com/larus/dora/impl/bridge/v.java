package com.larus.dora.impl.bridge;

import android.net.Uri;
import com.bytedance.dora.device.DoraDevice;
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
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.common.apphost.AppHost;
import com.larus.doc.sdk.impl.BuildConfig;
import com.larus.dora.impl.core.DoraAdapterExtKt;
import com.larus.dora.impl.util.DoraImageType;
import com.larus.dora.impl.util.DoraResourceUtil;
import com.larus.dora.impl.util.DoraSKU;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@XBridgeMethod(name = "dora.resource.getImageURL")
public final class v extends XCoreIDLBridgeMethod<b, c> {

    @XBridgeMethodName(name = "dora.resource.getImageURL")
    public final String a;

    public static final class a {
    }

    @XBridgeParamModel
    public interface b extends XBaseParamModel {
        @XBridgeParamField(isGetter = true, keyPath = "resourceKey", required = true)
        String getResourceKey();
    }

    @XBridgeResultModel
    public interface c extends XBaseResultModel {
        @XBridgeParamField(isGetter = true, keyPath = "resourceKey", required = BuildConfig.DEBUG)
        String getResourceKey();

        @XBridgeParamField(isGetter = true, keyPath = "url", required = BuildConfig.DEBUG)
        String getUrl();

        @XBridgeParamField(isGetter = BuildConfig.DEBUG, keyPath = "resourceKey", required = BuildConfig.DEBUG)
        void setResourceKey(String r1);

        @XBridgeParamField(isGetter = BuildConfig.DEBUG, keyPath = "url", required = BuildConfig.DEBUG)
        void setUrl(String r1);
    }

    static {
    }

    public v() {
        this.a = "dora.resource.getImageURL";
    }

    public final String getName() {
        return this.a;
    }

    public final void handle(IBDXBridgeContext r9, XBaseParamModel r10, CompletionBlock r11) {
        b r12 = (b) r10;
        Intrinsics.checkNotNullParameter(r9, "bridgeContext");
        Intrinsics.checkNotNullParameter(r12, "params");
        Intrinsics.checkNotNullParameter(r11, "callback");
        String r13 = r12.getResourceKey();
        boolean r14 = false;
        if (r13 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L12;
        CompletionBlock.DefaultImpls.onFailure$default(r11, -3, "resourceKey is required", null, 4, null);
        return;
    L12:
        if (Intrinsics.areEqual(r13, "dora_device_gesture_setting") == false) goto L23;
        DoraDevice r2 = DoraAdapterExtKt.h(kj4.a.g());
        DoraSKU.a r3 = DoraSKU.Companion;
        if (r2 == null) goto L16;
        Integer r4 = Integer.valueOf(r2.sku);
    L17:
        String r5 = DoraImageType.IMAGE_ONBOARDING_POPUP_HEADPHONE_GESTURE.fileName(DoraSKU.a.b(r3, r4));
        DoraResourceUtil r6 = DoraResourceUtil.a;
        String r7 = DoraResourceUtil.d(r5);
        if ((!StringsKt.isBlank(r7)) == true) goto L20;
    L22:
        String r8 = new Uri.Builder().scheme("android.resource").authority(AppHost.a.getApplication().getPackageName()).appendPath(String.valueOf(2131242897)).build().toString();
    L24:
        if (r8 != null) goto L26;
    L27:
        r14 = true;
    L28:
        if (r14 == false) goto L30;
        FLogger.a.w("DoraResourceGetImageURLMethod", "dora.resource.getImageURL image not found resourceKey=" + r13);
        CompletionBlock.DefaultImpls.onFailure$default(r11, 0, "image resource not found", null, 4, null);
        return;
    L30:
        c r15 = ne7.e.b(c.class);
        r15.setResourceKey(r13);
        r15.setUrl(r8);
        CompletionBlock.DefaultImpls.onSuccess$default(r11, r15, null, 2, null);
        return;
    L26:
        if (StringsKt.isBlank(r8) == false) goto L28;
    L20:
        if (new PolarisFileWrapper(r7).exists() == false) goto L22;
        r8 = Uri.fromFile(new PolarisFileWrapper(r7)).toString();
        goto L24
    L16:
        r4 = null;
        goto L17
    L23:
        r8 = null;
        goto L24
    L5:
        if (StringsKt.isBlank(r13) == true) goto L8;
        r1 = false;
        goto L9
    }
}
