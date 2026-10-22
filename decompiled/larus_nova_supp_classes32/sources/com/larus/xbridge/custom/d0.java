package com.larus.xbridge.custom;

import android.app.Activity;
import android.content.Context;
import com.bytedance.ies.xbridge.XBridgeMethod;
import com.bytedance.ies.xbridge.XBridgePlatformType;
import com.bytedance.ies.xbridge.XReadableMap;
import com.bytedance.ies.xbridge.bridgeInterfaces.XCoreBridgeMethod;
import com.larus.bmhome.share.api.IShareRuntimeService;
import com.larus.bmhome.share.api.IShareService;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import com.lynx.jsbridge.LynxResourceModule;
import com.lynx.tasm.eventreport.LynxEventReporter;
import com.obric.aivoice.core.data.NameKeys;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Set;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class d0 extends XCoreBridgeMethod {
    public static final Set<String> a = null;

    public static final class a {
    }

    public final String getName() {
        return "app.share";
    }

    static {
        a = SetsKt.setOf(new String[]{"aweme", "wechat", "moments", "qq", "more"});
    }

    public d0() {
    }

    public final void e(XReadableMap r40, final XBridgeMethod.Callback r41) {
        g66.c r1 = getContextProviderFactory();
        if (r1 == null) goto L5;
        Context r2 = (Context) r1.c(Context.class);
    L6:
        if (r2 == null) goto L9;
        Activity r3 = com.bytedance.ies.xbridge.utils.f.a.getActivity(r2);
        if (r3 == null) goto L9;
    L11:
        if ((r3 instanceof Activity) == true) goto L14;
        r3 = null;
    L14:
        if (r3 == null) goto L69;
        boolean r4 = false;
        if (r3.isFinishing() == false) goto L18;
    L20:
        boolean r5 = false;
    L21:
        if (r5 == false) goto L69;
        final String r9 = com.bytedance.ies.xbridge.s.f(r40, "channelType", NameKeys.UnloadStrategy_No_Strategy);
        if (a.contains(r9) == true) goto L27;
        XCoreBridgeMethod.onFailure$default(this, r41, -1, "unsupported channelType", null, 8, null);
        return;
    L27:
        final String r10 = com.bytedance.ies.xbridge.s.f(r40, "shareType", NameKeys.UnloadStrategy_No_Strategy);
        if (Intrinsics.areEqual(r10, LynxEventReporter.PROP_NAME_URL) == true) goto L31;
        XCoreBridgeMethod.onFailure$default(this, r41, -1, "unsupported shareType", null, 8, null);
        return;
    L31:
        String r14 = StringsKt.trim(com.bytedance.ies.xbridge.s.f(r40, "shareLinkUrl", NameKeys.UnloadStrategy_No_Strategy)).toString();
        if (r14.length() != 0) goto L34;
        boolean r6 = true;
    L35:
        if (r6 == false) goto L38;
        XCoreBridgeMethod.onFailure$default(this, r41, -1, "shareLinkUrl is empty", null, 8, null);
        return;
    L38:
        IShareService r7 = (IShareService) ServiceManager.get().getService(IShareService.class);
        if (r7 != null) goto L41;
        XCoreBridgeMethod.onFailure$default(this, r41, -1, "share service is unavailable", null, 8, null);
    L51:
        final IShareService r8 = null;
    L53:
        if (r8 != null) goto L55;
        return;
    L55:
        String r11 = com.bytedance.ies.xbridge.s.f(r40, "linkImgUrl", NameKeys.UnloadStrategy_No_Strategy);
        if ((!StringsKt.isBlank(r11)) == false) goto L58;
        String r15 = r11;
    L59:
        String r12 = com.bytedance.ies.xbridge.s.f(r40, "shareTitle", NameKeys.UnloadStrategy_No_Strategy);
        if ((!StringsKt.isBlank(r12)) == false) goto L62;
        String r19 = r12;
    L63:
        String r0 = com.bytedance.ies.xbridge.s.f(r40, "shareContent", NameKeys.UnloadStrategy_No_Strategy);
        if ((!StringsKt.isBlank(r0)) == false) goto L66;
        String r20 = r0;
    L67:
        final com.larus.bmhome.share.panel.b r13 = new com.larus.bmhome.share.panel.b(null, null, r14, r15, null, null, null, r19, r20, null, null, null, null, null, null, null, false, false, null, null, false, false, null, false, null, null, 67108467);
        final Activity r16 = r3;
        r3.runOnUiThread(new c0(this, r16, r41, r8, r9, r10, r13));
        return;
    L66:
        r20 = null;
        goto L67
    L62:
        r19 = null;
        goto L63
    L58:
        r15 = null;
        goto L59
    L41:
        IShareRuntimeService r17 = (IShareRuntimeService) ServiceManager.get().getService(IShareRuntimeService.class);
        if (r17 != null) goto L44;
    L46:
        if (r4 == true) goto L49;
        XCoreBridgeMethod.onFailure$default(this, r41, -1, "unsupported channelType", null, 8, null);
        goto L51
    L49:
        if (r7.a(r9) == true) goto L52;
        XCoreBridgeMethod.onFailure$default(this, r41, -1, "share channel is not installed", null, 8, null);
        goto L51
    L52:
        r8 = r7;
        goto L53
    L44:
        if (r17.e(r9, r10) != true) goto L46;
        r4 = true;
        goto L46
    L34:
        r6 = false;
        goto L35
    L18:
        if (r3.isDestroyed() == true) goto L20;
        r5 = true;
    L69:
        XCoreBridgeMethod.onFailure$default(this, r41, -1, "activity is null or finishing", null, 8, null);
        return;
    L9:
        r3 = AppHost.a.a().getCurrentActivity();
        goto L11
    L5:
        r2 = null;
        goto L6
    }

    public final void handle(XReadableMap r9, XBridgeMethod.Callback r10, XBridgePlatformType r11) {
        Intrinsics.checkNotNullParameter(r9, LynxResourceModule.PARAMS_KEY);
        Intrinsics.checkNotNullParameter(r10, "callback");
        Intrinsics.checkNotNullParameter(r11, "type");
        Result.Companion r12 = Result.Companion;     // Catch: Throwable -> L5
        e(r9, r10);     // Catch: Throwable -> L5
        Object r13 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L5
    L8:
        if (Result.exceptionOrNull-impl(r13) == null) goto L13;
        FLogger.a.e("AppShareMethod", "share request failed");
        XCoreBridgeMethod.onFailure$default(this, r10, -1, "share request failed", null, 8, null);
        return;
    L13:
        return;
    L5:
        th = move-exception;
        Result.Companion r14 = Result.Companion;
        r13 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L8
    }
}
