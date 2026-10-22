package com.larus.xbridge.custom;

import android.content.Context;
import android.net.Uri;
import com.bytedance.ies.bullet.base.BulletSdk;
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
import com.lynx.jsbridge.LynxResourceModule;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@XBridgeMethod(name = "open")
public final class u1 extends XCoreIDLBridgeMethod<a, b> {

    @XBridgeMethodName(name = "open", params = {"schema"})
    public final String a;

    @XBridgeParamModel
    public interface a extends XBaseParamModel {
        @XBridgeParamField(isGetter = true, keyPath = "schema", required = true)
        String getSchema();
    }

    @XBridgeResultModel
    public interface b extends XBaseResultModel {
    }

    public u1() {
        this.a = "open";
    }

    public final String getName() {
        return this.a;
    }

    public final void handle(IBDXBridgeContext r11, XBaseParamModel r12, CompletionBlock r13) {
        a r2 = (a) r12;
        Intrinsics.checkNotNullParameter(r11, "bridgeContext");
        Intrinsics.checkNotNullParameter(r2, LynxResourceModule.PARAMS_KEY);
        Intrinsics.checkNotNullParameter(r13, "callback");
        Context r3 = e4a.c.getContext(r11);
        if (r3 == null) goto L23;
        Ref.ObjectRef r6 = new Ref.ObjectRef();
        r6.element = Boolean.FALSE;
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L11
        Map r1 = com.ivy.ivykit.api.bridge.b.a;     // Catch: Throwable -> L11
        hx7.f r4 = (hx7.f) com.ivy.ivykit.api.bridge.b.a(hx7.f.class);     // Catch: Throwable -> L11
        if (r4 == null) goto L8;
        Boolean r5 = Boolean.valueOf(r4.openSchema(r2.getSchema(), MapsKt.emptyMap(), r3));     // Catch: Throwable -> L11
    L9:
        r6.element = r5;     // Catch: Throwable -> L11
        Object r7 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L11
    L14:
        if (Result.exceptionOrNull-impl(r7) == null) goto L16;
        CompletionBlock.DefaultImpls.onFailure$default(r13, 0, "Failed to open schema: " + r2 + ".schema", null, 4, null);
        return;
    L16:
        Uri r8 = UriProtector.parse(r2.getSchema()).buildUpon().appendQueryParameter("use_xbridge3", "true").build();
        Object r9 = r6.element;
        Boolean r10 = Boolean.TRUE;
        if (Intrinsics.areEqual(r9, r10) == true) goto L20;
        boolean r14 = BulletSdk.a;
        Intrinsics.checkNotNull(r8);
        r6.element = Boolean.valueOf(BulletSdk.h(r3, r8, null, 12));
    L20:
        if (Intrinsics.areEqual(r6.element, r10) == false) goto L22;
        CompletionBlock.DefaultImpls.onSuccess$default(r13, ne7.e.b(b.class), null, 2, null);
        return;
    L22:
        CompletionBlock.DefaultImpls.onFailure$default(r13, 0, "Failed to open schema: " + r2 + ".schema", null, 4, null);
        return;
    L8:
        r5 = null;
    L11:
        th = move-exception;
        Result.Companion r15 = Result.Companion;
        r7 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L14
    L23:
        CompletionBlock.DefaultImpls.onFailure$default(r13, 0, "Failed to open schema: " + r2 + ".schema", null, 4, null);
    }
}
