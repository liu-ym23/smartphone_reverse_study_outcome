package com.ss.android.lark.gadget.lifecycle.launch.entrance;

import android.content.Context;
import android.content.Intent;
import com.bytedance.ee.lark.infra.sandbox.context.IAppContext;
import java.util.Locale;
import njb.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public interface IAppbrandSupport {
    String getTmaJssdkVersion(Context r1, IAppContext r2);

    String getTmaJssdkVersion(IAppContext r1);

    boolean isSDKSupport();

    boolean isSDKSupport(Context r1);

    void openAppbrand(Context r1, a r2);

    void openAppbrand(a r1);

    boolean openShortcut(Intent r1);

    void preloadEmptyProcess();

    void switchLang(Locale r1);
}
