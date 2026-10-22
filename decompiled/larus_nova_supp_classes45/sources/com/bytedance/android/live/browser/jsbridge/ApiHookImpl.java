package com.bytedance.android.live.browser.jsbridge;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.monitor.SafetyGuard;
import com.bytedance.android.live.core.setting.SettingKey;
import com.bytedance.android.live.network.impl.interceptor.FuseRequestAdaptorInterceptor;
import com.bytedance.android.livehostapi.foundation.IMiddleWareHostContext;
import com.bytedance.android.livesdk.utils.r2;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class ApiHookImpl {
    public static final SettingKey<List<String>> a = null;

    @Retention(RetentionPolicy.RUNTIME)
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0080\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/browser/jsbridge/ApiHookImpl$HookScene;", "", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
    public @interface HookScene {
    }

    static {
        a = new SettingKey("live_jsb_fuse_replace_forbidden", "", CollectionsKt.emptyList(), CollectionsKt.emptyList());
    }

    @JvmStatic
    public static final String a(String r17, @HookScene int r18) {
        String r1 = r17;
        String r2 = "";
        if (r1 != null) goto L5;
        return "";
    L5:
        Integer r3 = null;
        boolean r4 = true;
        if (r18 == 1) goto L37;
    L16:
        if (r1 == null) goto L19;
        r3 = Integer.valueOf(StringsKt.indexOf$default(r1, "?", 0, false, 6, null));
    L19:
        if (r3.intValue() <= 0) goto L21;
        String r0 = "&";
    L22:
        IMiddleWareHostContext r5 = jc1.k.f(IMiddleWareHostContext.class);
        if (r5 == null) goto L29;
        String r6 = r5.getVersionCode();
        if (r6 == null) goto L29;
        r2 = r6;
    L29:
        if (r2.length() > 0) goto L32;
        r4 = false;
    L32:
        if (r4 == true) goto L34;
        return r1;
    L34:
        if (r2.a(r1) == true) goto L36;
        return r1;
    L36:
        return r1 + r0 + "live_sdk_version=" + r2;
    L21:
        r0 = "?";
        goto L22
    L37:
        URI r7 = new URI(r1);     // Catch: URISyntaxException -> L14
        String r8 = r7.getPath();     // Catch: URISyntaxException -> L14
        List r9 = FuseRequestAdaptorInterceptor.a;     // Catch: URISyntaxException -> L14
        String r11 = FuseRequestAdaptorInterceptor.a(r8);     // Catch: URISyntaxException -> L14
        if (mz.c.a(r11, r8) == false) goto L10;
    L12:
        r1 = FuseRequestAdaptorInterceptor.b(r1);     // Catch: URISyntaxException -> L14
        goto L16
    L10:
        if (a.getValue().contains(r8) == true) goto L12;
        r1 = new URI(r7.getScheme(), r7.getUserInfo(), r7.getHost(), r7.getPort(), r11, r7.getQuery(), r7.getFragment()).toString();     // Catch: URISyntaxException -> L14
        ALogger.d("aggressive_fuse", "replace jsb path " + r8 + " -> " + r11);     // Catch: URISyntaxException -> L14
    L14:
        e = move-exception;
        SafetyGuard.a(null, e, null);
        goto L16
    }
}
