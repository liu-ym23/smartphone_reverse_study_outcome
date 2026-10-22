package com.larus.bmhome.music.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import com.bytedance.mira.core.opt.res.NewMiraResourcesManager;
import com.larus.common.apphost.AppHost;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class m2 {
    public static final Context a = null;

    static {
        AppHost.Companion r0 = AppHost.a;
        Resources r1 = r0.getApplication().getResources();
        Configuration r2 = new Configuration(r1.getConfiguration());
        Configuration r3 = new Configuration(r1.getConfiguration());
        r2.uiMode = 16;
        r3.uiMode = 32;
        Context r4 = r0.getApplication().createConfigurationContext(r2);
        NewMiraResourcesManager.getInstance().install(r4);
        Context r5 = r0.getApplication().createConfigurationContext(r3);
        NewMiraResourcesManager.getInstance().install(r5);
        a = r5;
    }
}
