package com.larus.xbridge.custom;

import android.app.Activity;
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
import com.larus.utils.logger.FLogger;
import com.lynx.jsbridge.LynxResourceModule;
import com.obric.aivoice.core.data.NameKeys;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@XBridgeMethod(name = "flow.fileSystemShare", owner = "river.li")
public final class p1 extends XCoreIDLBridgeMethod<b, c> {

    @XBridgeMethodName(name = "flow.fileSystemShare")
    public final String a;

    public static final class a {
    }

    @XBridgeParamModel
    public interface b extends XBaseParamModel {
        @XBridgeParamField(isGetter = true, keyPath = "fileName", required = true)
        String getFileName();

        @XBridgeParamField(isGetter = true, keyPath = "filePath", required = true)
        String getFilePath();
    }

    @XBridgeResultModel
    public interface c extends XBaseResultModel {
    }

    static {
    }

    public p1() {
        this.a = "flow.fileSystemShare";
    }

    public final String getName() {
        return this.a;
    }

    public final void handle(IBDXBridgeContext r12, XBaseParamModel r13, CompletionBlock r14) {
        b r15 = (b) r13;
        Intrinsics.checkNotNullParameter(r12, "bridgeContext");
        Intrinsics.checkNotNullParameter(r15, LynxResourceModule.PARAMS_KEY);
        Intrinsics.checkNotNullParameter(r14, "callback");
        String r3 = r15.getFilePath();
        String r4 = r15.getFileName();
        Activity r2 = r12.getOwnerActivity();
        FLogger r16 = FLogger.a;
        StringBuilder r17 = new StringBuilder("[handle] activity=");
        if (r2 == null) goto L5;
        String r0 = r2.getLocalClassName();
    L6:
        if (r0 != null) goto L8;
        r0 = NameKeys.UnloadStrategy_No_Strategy;
    L8:
        r17.append(r0);
        r17.append(" hasFilePath=");
        if (r3 != null) goto L11;
    L14:
        boolean r1 = true;
    L15:
        r17.append(true ^ r1);
        r16.i("FlowSystemShareMethod", r17.toString());
        if (r2 == null) goto L19;
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new FlowSystemShareMethod$handle$1$1(r2, r3, r4, r14, null), 3, null);
        return;
    L19:
        return;
    L11:
        if (StringsKt.isBlank(r3) == true) goto L14;
        r1 = false;
        goto L15
    L5:
        r0 = null;
        goto L6
    }
}
