package com.larus.xbridge.custom;

import android.os.Bundle;
import com.bytedance.sdk.account.platform.api.IDouYin2Service;
import com.bytedance.sdk.account.platform.base.AuthorizeFramework;
import com.bytedance.sdk.account.platform.base.Request;
import com.bytedance.sdk.open.douyin.DouYinOpenConfig;
import com.ivy.ivykit.api.bridge.core.model.IvyBridgePlatformType;
import com.lynx.jsbridge.LynxResourceModule;
import com.obric.aivoice.core.data.NameKeys;
import java.util.HashSet;
import java.util.LinkedHashMap;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class a extends bx7.c {
    public static final /* synthetic */ int c = 0;
    public b b;

    /* JADX INFO: renamed from: com.larus.xbridge.custom.a$a, reason: collision with other inner class name */
    public static final class C0027a {
    }

    static {
    }

    public final String getName() {
        return "account.thirdPartyAuth";
    }

    public a() {
    }

    public final void a(dx7.b r8, ux7.d.d r9, IvyBridgePlatformType r10) {
        Intrinsics.checkNotNullParameter(r8, LynxResourceModule.PARAMS_KEY);
        Intrinsics.checkNotNullParameter(r9, "callback");
        Intrinsics.checkNotNullParameter(r10, "type");
        if (Intrinsics.areEqual(cx7.a.d(r8, "platform", NameKeys.UnloadStrategy_No_Strategy), "douyin") == false) goto L18;
        DouYinOpenConfig r11 = com.bytedance.sdk.open.douyin.a.getConfig();
        Boolean r2 = null;
        if (r11 == null) goto L7;
        String r12 = r11.clientKey;
    L9:
        if (Intrinsics.areEqual(r12, "aw730v27vx2bu2qw") == true) goto L11;
        com.bytedance.sdk.open.douyin.a.init(new DouYinOpenConfig("aw730v27vx2bu2qw"));
    L11:
        HashSet r13 = new HashSet();
        r13.add("user_info");
        HashSet r3 = new HashSet();
        r3.add("mobile");
        r3.add("flow_audio.luna.preference");
        Bundle r4 = new Bundle();
        r4.putString("comment_id", "@9VxThaOEDp4mJyWjdYosV87812DVAcS+B6lNlTaaE20indzEX5V+l7R1aGbk3MWd");
        Request r14 = new Request.Builder().setScopes(r13).setOptionalScopes1(r3).setState("dy_authorize").setCallerLocalEntry("com.larus.nova.douyinapi.DouYinEntryActivity").setExtra(r4).setAuthType(0).build();
        this.b = new b(r9);
        IDouYin2Service r5 = AuthorizeFramework.getService(IDouYin2Service.class);
        if (r5 == null) goto L15;
        r2 = Boolean.valueOf(r5.authorize(com.bytedance.sdk.account.utils.d.b(), r14, this.b));
    L15:
        if (Intrinsics.areEqual(r2, Boolean.TRUE) == true) goto L19;
        LinkedHashMap r15 = new LinkedHashMap();
        r15.put(LynxResourceModule.CODE_KEY, 0);
        LinkedHashMap r6 = new LinkedHashMap();
        r6.put(LynxResourceModule.CODE_KEY, NameKeys.UnloadStrategy_No_Strategy);
        r6.put("platform", "douyin");
        r6.put("platformAppId", "8943");
        r6.put("errorCode", -1);
        Unit r16 = Unit.INSTANCE;
        r15.put(LynxResourceModule.DATA_KEY, r6);
        r9.invoke(r15);
        return;
    L19:
        return;
    L7:
        r12 = null;
        goto L9
    }
}
