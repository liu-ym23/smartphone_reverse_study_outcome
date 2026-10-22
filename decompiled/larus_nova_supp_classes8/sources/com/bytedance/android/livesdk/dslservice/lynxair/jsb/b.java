package com.bytedance.android.livesdk.dslservice.lynxair.jsb;

import android.view.View;
import com.bytedance.android.anniex.ui.AnnieXLynxView;
import com.bytedance.android.ecom.arch.slice.action.IAction;
import com.bytedance.android.live.core.setting.n0;
import com.bytedance.android.livesdk.dslservice.lynxair.h;
import com.bytedance.android.livesdk.dslservice.util.m;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.PlatformType;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseParamModel;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import ne7.e;
import yt1.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@XBridgeMethod(name = "liveDSLAction")
public final class b extends a {
    public b() {
    }

    public final void handle(IBDXBridgeContext r11, XBaseParamModel r12, CompletionBlock r13) {
        a.b r14 = (a.b) r12;
        Intrinsics.checkNotNullParameter(r11, "bridgeContext");
        Intrinsics.checkNotNullParameter(r14, "params");
        Intrinsics.checkNotNullParameter(r13, "callback");
        final String r0 = r14.getType();
        m r1 = m.h;
        r1.d(new LynxAirHandleDslAction$handle$1(r0));
        c r2 = (c) r11.getService(c.class);
        if (Intrinsics.areEqual(n0.a.getValue(), Boolean.TRUE) == false) goto L15;
        View r3 = r11.getEngineView();
        if ((r3 instanceof AnnieXLynxView) == true) goto L7;
        r3 = null;
    L7:
        View r4 = (AnnieXLynxView) r3;
        final Map r7 = MapsKt.toMap(r14.getFields());
        IAction r8 = new LynxAirHandleDslAction$createAction$1(r7, r0);
        if (r4 == null) goto L15;
        if (r2 == null) goto L15;
        i r9 = r2.a;
        if (r9 == null) goto L15;
        Intrinsics.checkNotNullParameter(r4, "$this$toDSLCardHolder");
        if (r9.a(r8, r4, new h(r4)) != true) goto L15;
        CompletionBlock.DefaultImpls.onSuccess$default(r13, e.c(Reflection.getOrCreateKotlinClass(a.c.class)), null, 2, null);
        return;
    L15:
        if (r2 == null) goto L17;
        List<yt1.h> r5 = r2.b;
    L18:
        if (r5 != null) goto L20;
        r1.d(LynxAirHandleDslAction$handle$2.INSTANCE);
        CompletionBlock.DefaultImpls.onFailure$default(r13, 0, null, null, 6, null);
        return;
    L20:
        Iterator<T> r6 = r5.iterator();
    L22:
        if (r6.hasNext() == false) goto L29;
        Object r10 = r6.next();
        yt1.h r15 = (yt1.h) r10;
        String r16 = r15.a();
        if (r16 != null) goto L27;
        r16 = r15.getName().getText();
    L27:
        if (Intrinsics.areEqual(r16, r0) == false) goto L22;
    L30:
        yt1.h r17 = (yt1.h) r10;
        if (r17 != null) goto L34;
        m.h.d(new LynxAirHandleDslAction$handle$3(r0));
        CompletionBlock.DefaultImpls.onFailure$default(r13, 0, null, null, 6, null);
        return;
    L34:
        if (r11.getPlatformType() != PlatformType.LYNX) goto L43;
        MapsKt.toMap(r14.getFields());
        Map r18 = MapsKt.toMap(r14.getFields());
        View r19 = r11.getEngineView();
        if ((r19 instanceof AnnieXLynxView) == true) goto L38;
        r19 = null;
    L38:
        AnnieXLynxView r110 = (AnnieXLynxView) r19;
        if (r110 == null) goto L41;
        Intrinsics.checkNotNullParameter(r110, "$this$toDSLCardHolder");
        h r20 = new h(r110);
    L42:
        r17.b(r18, r20);
        goto L43
    L41:
        r20 = null;
    L43:
        CompletionBlock.DefaultImpls.onSuccess$default(r13, e.c(Reflection.getOrCreateKotlinClass(a.c.class)), null, 2, null);
        return;
    L29:
        r10 = null;
        goto L30
    L17:
        r5 = null;
        goto L18
    }
}
