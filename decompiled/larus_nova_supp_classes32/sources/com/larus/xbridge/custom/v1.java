package com.larus.xbridge.custom;

import android.app.Activity;
import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.ies.xbridge.XBridgeMethod;
import com.bytedance.ies.xbridge.XBridgePlatformType;
import com.bytedance.ies.xbridge.XReadableMap;
import com.bytedance.ies.xbridge.bridgeInterfaces.XCoreBridgeMethod;
import com.larus.bmhome.share.ShareScene;
import com.larus.bmhome.share.api.IShareService;
import com.larus.common.apphost.AppHost;
import com.larus.platform.IFlowSdkDepend;
import com.larus.utils.logger.FLogger;
import com.lynx.jsbridge.LynxResourceModule;
import com.obric.aivoice.core.data.NameKeys;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.LinkedHashMap;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class v1 extends XCoreBridgeMethod {

    public static final class a {
    }

    static {
    }

    public final String getName() {
        return "app.openSharePanel";
    }

    public v1() {
    }

    public final void e(XReadableMap r106, XBridgeMethod.Callback r107) {
        g66.c r1 = getContextProviderFactory();
        if (r1 == null) goto L9;
        Context r2 = (Context) r1.c(Context.class);
        if (r2 == null) goto L9;
        Activity r3 = com.bytedance.ies.xbridge.utils.f.a.getActivity(r2);
        if (r3 == null) goto L9;
    L10:
        String r4 = null;
        if ((r3 instanceof FragmentActivity) == false) goto L13;
        Activity r5 = (FragmentActivity) r3;
    L14:
        if (r5 != null) goto L16;
    L53:
        XCoreBridgeMethod.onFailure$default(this, r107, 0, "activity is null or finishing", null, 8, null);
        return;
    L16:
        if (r5.isFinishing() == true) goto L53;
        if (r5.isDestroyed() == true) goto L53;
        String r6 = com.bytedance.ies.xbridge.s.f(r106, "scene", NameKeys.UnloadStrategy_No_Strategy);
        if (StringsKt.isBlank(r6) == false) goto L24;
        XCoreBridgeMethod.onFailure$default(this, r107, 0, "scene is null or blank", null, 8, null);
        return;
    L24:
        ShareScene.Companion.getClass();
        ShareScene r14 = ShareScene.a.a(r6);
        if (r14 != null) goto L28;
        XCoreBridgeMethod.onFailure$default(this, r107, 0, "shareScene not found", null, 8, null);
        return;
    L28:
        XReadableMap r7 = com.bytedance.ies.xbridge.s.e(r106, "trackInfo");
        if (r7 == null) goto L31;
        JSONObject r8 = com.bytedance.ies.xbridge.utils.j.d(r7);
    L33:
        if (r14 != ShareScene.SINGLE_IMAGE) goto L35;
        boolean r9 = true;
    L37:
        if (r9 == false) goto L45;
        IFlowSdkDepend r10 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r10 == null) goto L51;
        r10.r0();
        com.larus.home.impl.sdk.e2 r13 = com.larus.home.impl.sdk.e2.a;
        FragmentManager r11 = r5.getSupportFragmentManager();
        String r12 = com.bytedance.ies.xbridge.s.f(r106, "shareCoverUrl", NameKeys.UnloadStrategy_No_Strategy);
        String r15 = com.bytedance.ies.xbridge.s.f(r106, "shareImgUrl", NameKeys.UnloadStrategy_No_Strategy);
        String r101 = com.bytedance.ies.xbridge.s.f(r106, "shareCoverUrl", NameKeys.UnloadStrategy_No_Strategy);
        XReadableMap r0 = com.bytedance.ies.xbridge.s.e(r106, "trackInfo");
        if (r0 == null) goto L43;
        String r30 = com.bytedance.ies.xbridge.s.f(r0, "current_page", NameKeys.UnloadStrategy_No_Strategy);
    L44:
        r13.Z0(r11, new sq9.j(null, r12, r15, r101, null, null, new com.larus.bmhome.share.panel.h(null, null, null, r30, null, null, null, r8, null, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, null, null, -273, -1, 1023), r14, 0, 0, new sq9.i("share", null, null, 6), null, 0, null, null, null, null, 127777));
        goto L51
    L43:
        r30 = null;
    L51:
        XCoreBridgeMethod.onSuccess$default(this, r107, new LinkedHashMap(), null, 4, null);
        return;
    L45:
        IShareService r16 = (IShareService) ServiceManager.get().getService(IShareService.class);
        if (r16 == null) goto L51;
        com.larus.bmhome.share.panel.b r17 = new com.larus.bmhome.share.panel.b(com.bytedance.ies.xbridge.s.f(r106, "shareImgUrl", NameKeys.UnloadStrategy_No_Strategy), null, com.bytedance.ies.xbridge.s.f(r106, "shareLinkUrl", NameKeys.UnloadStrategy_No_Strategy), com.bytedance.ies.xbridge.s.f(r106, "linkImgUrl", NameKeys.UnloadStrategy_No_Strategy), null, null, null, com.bytedance.ies.xbridge.s.f(r106, "shareTitle", NameKeys.UnloadStrategy_No_Strategy), com.bytedance.ies.xbridge.s.f(r106, "shareContent", NameKeys.UnloadStrategy_No_Strategy), null, null, null, null, null, null, null, false, false, null, null, false, false, null, false, null, null, 67108466);
        XReadableMap r18 = com.bytedance.ies.xbridge.s.e(r106, "trackInfo");
        if (r18 == null) goto L50;
        r4 = com.bytedance.ies.xbridge.s.f(r18, "current_page", NameKeys.UnloadStrategy_No_Strategy);
    L50:
        IShareService.a.g(r16, r5, r14, r17, new com.larus.bmhome.share.panel.h(null, null, null, r4, null, null, null, r8, null, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, r8.optString("canvas_type"), null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, null, null, -273, -16777217, 1023), null, null, false, 192);
        goto L51
    L35:
        r9 = false;
        goto L37
    L31:
        r8 = new JSONObject();
        goto L33
    L13:
        r5 = null;
    L9:
        r3 = AppHost.a.a().getCurrentActivity();
        goto L10
    }

    public final void handle(XReadableMap r10, XBridgeMethod.Callback r11, XBridgePlatformType r12) {
        Intrinsics.checkNotNullParameter(r10, LynxResourceModule.PARAMS_KEY);
        Intrinsics.checkNotNullParameter(r11, "callback");
        Intrinsics.checkNotNullParameter(r12, "type");
        Result.Companion r13 = Result.Companion;     // Catch: Throwable -> L5
        e(r10, r11);     // Catch: Throwable -> L5
        Object r14 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L5
    L7:
        Throwable r15 = Result.exceptionOrNull-impl(r14);
        if (r15 == null) goto L16;
        FLogger.a.e("OpenSharePanelMethod", "innerHandle error", r15);
        String r16 = r15.getMessage();
        if (r16 != null) goto L12;
        r16 = NameKeys.UnloadStrategy_No_Strategy;
    L12:
        XCoreBridgeMethod.onFailure$default(this, r11, 0, r16, null, 8, null);
        return;
    L16:
        return;
    L5:
        th = move-exception;
        Result.Companion r17 = Result.Companion;
        r14 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L7
    }
}
