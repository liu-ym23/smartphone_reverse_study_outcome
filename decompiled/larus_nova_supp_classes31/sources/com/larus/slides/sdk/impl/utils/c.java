package com.larus.slides.sdk.impl.utils;

import com.larus.common.apphost.AppHost;
import com.larus.slides.sdk.impl.plugins.event.SlidesLoadEventPluginV2;
import com.ss.android.lark.chameleon.container.webcontainer.view.ChameleonWebViewConfig;
import com.ss.android.lark.chameleon.util.AppInfoUtils;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class c {
    static {
    }

    @JvmStatic
    public static final String a() {
        AppHost.Companion r0 = AppHost.a;
        String r1 = AppInfoUtils.getVersionName(r0.getApplication());
        return ChameleonWebViewConfig.INSTANCE.getUserAgent(r0.getApplication()) + ' ' + ("DocsSDK/" + r1 + " Docs/" + r1 + " doubao_app Lark/7.43.0-alpha");
    }

    public static void b(String r7, SlidesLoadEventPluginV2.AnonymousClass1 r8) {
        Intrinsics.checkNotNullParameter(r7, "url");
        Intrinsics.checkNotNullParameter(r8, "callback");
        BuildersKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), null, new NetUtils$httpGet$1(null, r7, r8, null), 2, null);
    }
}
