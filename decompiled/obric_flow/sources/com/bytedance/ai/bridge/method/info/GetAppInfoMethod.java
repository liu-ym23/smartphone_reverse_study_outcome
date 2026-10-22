package com.bytedance.ai.bridge.method.info;

import a2.a;
import a2.b;
import a2.e;
import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.Rect;
import android.os.Build;
import android.view.View;
import android.view.WindowInsets;
import com.bytedance.ai.bridge.core.model.idl.BaseModel;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.bytedance.ai.bridge.service.IHostContextDepend;
import com.bytedance.ai.bridge.service.IHostLogDepend;
import com.bytedance.ai.model.p;
import com.bytedance.common.utility.NetworkUtils$NetworkType;
import com.bytedance.common.wschannel.WsConstants;
import com.google.gson.JsonObject;
import com.lynx.jsbridge.LynxResourceModule;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import k5.d;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import l2.c;
import o1.f;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0011\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0011\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u000f\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000f\u0010\u000eJ\u001f\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0012\u0010\u0013J7\u0010\u001b\u001a\u00020\u00192\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0016\u001a\u00020\n2\u0014\u0010\u001a\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0018\u0012\u0004\u0012\u00020\u00190\u0017H\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u001b\u0010\u001d\u001a\u0004\u0018\u00010\u00142\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010\u001f\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u001f\u0010\u000eJ\u0017\u0010!\u001a\u00020 2\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b!\u0010\"J\u0017\u0010#\u001a\u00020 2\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b#\u0010\"J\u000f\u0010%\u001a\u00020$H\u0002¢\u0006\u0004\b%\u0010&J5\u0010*\u001a\u00020\u00192\u0006\u0010\u0015\u001a\u00020\u00142\b\b\u0002\u0010(\u001a\u00020'2\u0012\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020\u00190\u0017H\u0002¢\u0006\u0004\b*\u0010+J-\u00102\u001a\u00020\u00192\u0006\u0010-\u001a\u00020,2\u0006\u0010/\u001a\u00020.2\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020100H\u0016¢\u0006\u0004\b2\u00103J\u0015\u00104\u001a\u00020$2\u0006\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b4\u00105¨\u00066"}, d2 = {"Lcom/bytedance/ai/bridge/method/info/GetAppInfoMethod;", "Lcom/bytedance/ai/bridge/method/info/AbsGetAppInfoMethodIDL;", "<init>", "()V", "Lcom/bytedance/ai/bridge/service/IHostContextDepend;", "getContextDependInstance", "()Lcom/bytedance/ai/bridge/service/IHostContextDepend;", "Lcom/bytedance/ai/bridge/service/IHostLogDepend;", "getLogDependInstance", "()Lcom/bytedance/ai/bridge/service/IHostLogDepend;", "Landroid/content/Context;", "context", "", "getScreenHeight", "(Landroid/content/Context;)I", "getScreenWidth", "", "px", "px2dp", "(DLandroid/content/Context;)I", "Landroid/app/Activity;", "activity", "applicationContext", "Lkotlin/Function1;", "Lcom/google/gson/JsonObject;", "", "callback", "getSafeArea", "(Landroid/app/Activity;Landroid/content/Context;Lkotlin/jvm/functions/Function1;)V", "getActivity", "(Landroid/content/Context;)Landroid/app/Activity;", "getStatusBarHeight", "", "getNetworkType", "(Landroid/content/Context;)Ljava/lang/String;", "getScreenOrientation", "", "is32Bit", "()Z", "", "delayMs", "Landroid/graphics/Rect;", "getStableDisplayFrame", "(Landroid/app/Activity;JLkotlin/jvm/functions/Function1;)V", "Ln1/c;", "bridgeContext", "Lcom/bytedance/ai/bridge/method/info/AbsGetAppInfoMethodIDL$GetAppInfoParamModel;", LynxResourceModule.PARAMS_KEY, "Lo1/f;", "Lcom/bytedance/ai/bridge/method/info/AbsGetAppInfoMethodIDL$GetAppInfoResultModel;", "handle", "(Ln1/c;Lcom/bytedance/ai/bridge/method/info/AbsGetAppInfoMethodIDL$GetAppInfoParamModel;Lo1/f;)V", "isKeyboardVisible", "(Landroid/app/Activity;)Z", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class GetAppInfoMethod extends AbsGetAppInfoMethodIDL {
    public GetAppInfoMethod() {
    }

    public static /* synthetic */ Unit b(GetAppInfoMethod r5, Activity r10, Context r11, int r12, boolean r13, Function1 r14, Rect r15) {
        return getSafeArea$lambda$5$lambda$4(r5, r10, r11, r12, r13, r14, r15);
    }

    public static /* synthetic */ Unit c(f r5, IHostContextDepend r10, Context r11, GetAppInfoMethod r12, JsonObject r13) {
        return handle$lambda$3$lambda$2(r5, r10, r11, r12, r13);
    }

    public static /* synthetic */ void d(AtomicBoolean r5, a r10) {
        getStableDisplayFrame$lambda$8(r5, r10);
    }

    public static /* synthetic */ Unit e(View r5, Function1 r10) {
        return getStableDisplayFrame$lambda$7(r5, r10);
    }

    private final Activity getActivity(Context r5) {
    L3:
        if (r5 == null) goto L11;
        if ((r5 instanceof Activity) == true) goto L7;
        if ((r5 instanceof ContextWrapper) == false) goto L11;
        r5 = ((ContextWrapper) r5).getBaseContext();
        goto L3
    L7:
        return (Activity) r5;
    L11:
        return null;
    }

    private final IHostContextDepend getContextDependInstance() {
        return d.f18600a;
    }

    private final IHostLogDepend getLogDependInstance() {
        return d.f18601b;
    }

    private final String getNetworkType(Context r5) {
        NetworkUtils$NetworkType r10 = com.bytedance.common.utility.f.a(r5);
        if (r10 != null) goto L5;
        int r11 = -1;
    L7:
        switch(r11) {
            case 1: goto L20;
            case 2: goto L18;
            case 3: goto L16;
            case 4: goto L15;
            case 5: goto L15;
            case 6: goto L15;
            case 7: goto L13;
            case 8: goto L11;
            case 9: goto L10;
            case 10: goto L10;
            case 11: goto L10;
            default: goto L8;
        };
    L8:
        return "unknown";
    L10:
        return "wifi";
    L11:
        return "5g";
    L13:
        return "4g";
    L15:
        return "3g";
    L16:
        return "2g";
    L18:
        return "mobile";
    L20:
        return "none";
    L5:
        r11 = e.f59a[r10.ordinal()];
        goto L7
    }

    private final void getSafeArea(final Activity r10, final Context r11, final Function1<? super JsonObject, Unit> r12) {
        if (r10 != null) goto L4;
        r12.invoke(null);
        return;
    L4:
        if (r10.getResources().getConfiguration().orientation != 2) goto L7;
        boolean r5 = true;
    L6:
        final boolean r13 = r5;
        final int r14 = px2dp(getStatusBarHeight(r11), r11);
        getStableDisplayFrame(r10, 300, new a2.d(this, r10, r11, r14, r13, r12));
        return;
    L7:
        r5 = false;
        goto L6
    }

    private static final Unit getSafeArea$lambda$5$lambda$4(GetAppInfoMethod r5, Activity r10, Context r11, int r12, boolean r13, Function1 r14, Rect r15) {
        Intrinsics.checkNotNullParameter(r15, "contentRect");
        int r16 = r5.px2dp(r10.getWindow().getDecorView().getHeight(), r10);
        int r17 = r5.px2dp(r15.top, r11);
        int r18 = r5.px2dp(r15.bottom, r11);
        if (r16 != 0) goto L6;
        if (r17 != 0) goto L6;
        r18 = r18 + r12;
    L6:
        int r19 = Math.max(r5.getScreenHeight(r11) - r18, 0);
        if (r13 == false) goto L9;
        AbsGetAppInfoMethodIDL.a r20 = new AbsGetAppInfoMethodIDL.a(0, 0, Integer.valueOf(r12), Integer.valueOf(r19));
        Intrinsics.checkNotNullParameter(r20, "value");
        JsonObject r21 = z0.a.a().toJsonTree(r20).getAsJsonObject();
    L10:
        r14.invoke(r21);
        return Unit.INSTANCE;
    L9:
        AbsGetAppInfoMethodIDL.a r22 = new AbsGetAppInfoMethodIDL.a(Integer.valueOf(r12), Integer.valueOf(r19), 0, 0);
        Intrinsics.checkNotNullParameter(r22, "value");
        r21 = z0.a.a().toJsonTree(r22).getAsJsonObject();
        goto L10
    }

    private final int getScreenHeight(Context r10) {
        int r5 = 0;
        if (r10.getResources().getConfiguration().orientation != 2) goto L5;
        boolean r11 = true;
    L6:
        int r12 = c.f19517c;
        if (r12 > 0) goto L13;
        c.a(r10);
        r12 = c.f19517c;
        if (r12 > 0) goto L13;
        r12 = 0;
    L13:
        int r13 = px2dp(r12, r10);
        int r14 = c.f19516b;
        if (r14 <= 0) goto L16;
    L15:
        r5 = r14;
    L19:
        int r15 = px2dp(r5, r10);
        if (r11 == false) goto L24;
        return Math.min(r13, r15);
    L24:
        return Math.max(r13, r15);
    L16:
        c.a(r10);
        r14 = c.f19516b;
        if (r14 <= 0) goto L19;
    L5:
        r11 = false;
        goto L6
    }

    private final String getScreenOrientation(Context r5) {
        if (r5.getResources().getConfiguration().orientation != 1) goto L6;
        return "portrait";
    L6:
        return "landscape";
    }

    private final int getScreenWidth(Context r10) {
        int r5 = 0;
        if (r10.getResources().getConfiguration().orientation != 2) goto L5;
        boolean r11 = true;
    L6:
        int r12 = c.f19517c;
        if (r12 > 0) goto L13;
        c.a(r10);
        r12 = c.f19517c;
        if (r12 > 0) goto L13;
        r12 = 0;
    L13:
        int r13 = px2dp(r12, r10);
        int r14 = c.f19516b;
        if (r14 <= 0) goto L16;
    L15:
        r5 = r14;
    L19:
        int r15 = px2dp(r5, r10);
        if (r11 == false) goto L24;
        return Math.max(r13, r15);
    L24:
        return Math.min(r13, r15);
    L16:
        c.a(r10);
        r14 = c.f19516b;
        if (r14 <= 0) goto L19;
    L5:
        r11 = false;
        goto L6
    }

    private final void getStableDisplayFrame(Activity r5, long r10, Function1<? super Rect, Unit> r11) {
        View r12 = r5.getWindow().getDecorView();
        boolean r13 = isKeyboardVisible(r5);
        AtomicBoolean r14 = new AtomicBoolean(false);
        a r15 = new a(0, r12, r11);
        if (r13 == true) goto L6;
        r15.invoke();
        return;
    L6:
        b r16 = new b(0, r14, r15);
        r12.setWindowInsetsAnimationCallback(new a2.f(r14, r12, r16, r15));
        r12.postDelayed(r16, r10 + ((long) 50));
    }

    public static /* synthetic */ void getStableDisplayFrame$default(GetAppInfoMethod r5, Activity r10, long r11, Function1 r12, int r13, Object r14) {
        if ((r13 & 2) == 0) goto L5;
        r11 = 300;
    L5:
        r5.getStableDisplayFrame(r10, r11, r12);
    }

    private static final Unit getStableDisplayFrame$lambda$7(View r5, Function1 r10) {
        r5.setWindowInsetsAnimationCallback(null);
        Rect r11 = new Rect();
        r5.getWindowVisibleDisplayFrame(r11);
        r10.invoke(r11);
        return Unit.INSTANCE;
    }

    private static final void getStableDisplayFrame$lambda$8(AtomicBoolean r5, Function0 r10) {
        if (r5.compareAndSet(false, true) == false) goto L6;
        r10.invoke();
        return;
    }

    private static final void getStableDisplayFrame$lambda$9(View r5, Function1 r10) {
        Rect r11 = new Rect();
        r5.getWindowVisibleDisplayFrame(r11);
        r10.invoke(r11);
    }

    private final int getStatusBarHeight(Context r5) {
        int r10 = r5.getResources().getIdentifier("status_bar_height", "dimen", "android");
        return r5.getResources().getDimensionPixelSize(r10);
    }

    private static final Unit handle$lambda$3$lambda$2(f r5, IHostContextDepend r10, Context r11, GetAppInfoMethod r12, JsonObject r13) {
        Intrinsics.checkNotNullParameter(AbsGetAppInfoMethodIDL.GetAppInfoResultModel.class, "<this>");
        BaseModel r14 = com.lynx.tasm.behavior.ui.utils.e.c(AbsGetAppInfoMethodIDL.GetAppInfoResultModel.class);
        AbsGetAppInfoMethodIDL.GetAppInfoResultModel r15 = (AbsGetAppInfoMethodIDL.GetAppInfoResultModel) r14;
        r15.setAppID(String.valueOf(r10.getAppId()));
        r15.setAppName(r10.getAppName());
        r15.setAppVersion(r10.getVersionName());
        r15.setChannel(r10.getChannel());
        r15.setLanguage(r10.getLanguage());
        r15.setTeenMode(Boolean.valueOf(r10.isTeenMode()));
        r15.setBaseMode(Boolean.valueOf(r10.isBaseMode()));
        r15.setAppTheme(r10.getSkinName());
        r15.setOsVersion(Build.VERSION.RELEASE);
        r15.setDevicePlatform("android");
        r15.setDeviceID(r10.getDeviceId());
        r15.setDeviceModel(Build.MODEL);
        r15.setDeviceBrand(Build.BRAND);
        r15.setNetType(com.bytedance.common.utility.f.a(r11).name());
        r15.setNetworkType(r12.getNetworkType(r11));
        r15.setScreenOrientation(r12.getScreenOrientation(r11));
        r15.setUpdateVersionCode(r10.getUpdateVersion());
        r15.setStatusBarHeight(Integer.valueOf(r12.px2dp(r12.getStatusBarHeight(r11), r11)));
        String r16 = r10.getCurrentTelcomCarrier();
        if (r16 != null) goto L5;
        r16 = "";
    L5:
        r15.setCarrier(r16);
        r15.setScreenWidth(Integer.valueOf(r12.getScreenWidth(r11)));
        r15.setScreenHeight(Integer.valueOf(r12.getScreenHeight(r11)));
        r15.setSafeArea(r13);
        r15.set32Bit(Boolean.valueOf(r12.is32Bit()));
        r15.setInstallID("");
        r15.setPackageName(r10.getPackageName());
        r15.setClientDid(r10.getClientDid());
        t0.b r17 = p.f2294c;
        if (r17 == null) goto L8;
        String r18 = r17.appThemeBackgroundColor();
    L9:
        r15.setAppBackgroundColor(r18);
        IHostLogDepend r19 = r12.getLogDependInstance();
        if (r19 == null) goto L14;
        HashMap r20 = new HashMap();
        r19.putCommonParams(r20, true);
        if (r20.containsKey(WsConstants.KEY_INSTALL_ID) == false) goto L14;
        r15.setInstallID((String) r20.get(WsConstants.KEY_INSTALL_ID));
    L14:
        r5.b((ResultModel) r14, "");
        return Unit.INSTANCE;
    L8:
        r18 = null;
        goto L9
    }

    private final boolean is32Bit() {
        if (Build.SUPPORTED_64_BIT_ABIS.length != 0) goto L6;
        return true;
    L6:
        return false;
    }

    private final int px2dp(double r5, Context r10) {
        return (int) ((r5 / ((double) r10.getResources().getDisplayMetrics().density)) + ((double) 0.5f));
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public /* bridge */ /* synthetic */ void handle(n1.c r5, ParamModel r10, f r11) {
        handle(r5, (AbsGetAppInfoMethodIDL.GetAppInfoParamModel) r10, r11);
    }

    public final boolean isKeyboardVisible(Activity r5) {
        Intrinsics.checkNotNullParameter(r5, "activity");
        WindowInsets r10 = r5.getWindow().getDecorView().getRootWindowInsets();
        if (r10 != null) goto L5;
    L7:
        return false;
    L5:
        if (r10.isVisible(WindowInsets.Type.ime()) != true) goto L7;
        return true;
    }

    public void handle(n1.c r10, AbsGetAppInfoMethodIDL.GetAppInfoParamModel r11, f r12) {
        Intrinsics.checkNotNullParameter(r10, "bridgeContext");
        Intrinsics.checkNotNullParameter(r11, LynxResourceModule.PARAMS_KEY);
        Intrinsics.checkNotNullParameter(r12, "callback");
        IHostContextDepend r5 = getContextDependInstance();
        if (r5 == null) goto L13;
        Context r13 = r5.getApplicationContext();
        View r14 = ((n1.a) r10).a();
        if (r14 == null) goto L7;
        Context r15 = r14.getContext();
    L8:
        Activity r16 = getActivity(r15);
        if (r16 != null) goto L11;
        r16 = s0.c.b();
    L11:
        getSafeArea(r16, r13, new a2.c(0, r12, r5, r13, this));
        return;
    L7:
        r15 = null;
        goto L8
    L13:
        r12.a("context dependency is not binded");
    }
}
