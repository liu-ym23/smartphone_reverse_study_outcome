package com.ss.android.lark.featuregatingv2impl.handler;

import com.google.gson.Gson;
import com.larksuite.framework.callback.IGetDataCallback;
import com.larksuite.framework.thread.CoreThreadPool;
import com.ss.android.lark.larkconfig.export.handler.AbstractBaseSettingHandler;
import com.ss.android.lark.larkconfig.export.plugin.AppSettingPlugin;
import com.ss.android.lark.log.Log;
import java.util.Collection;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class SettingsMetricsHandler extends AbstractBaseSettingHandler {
    public static final SettingsMetricsHandler i = null;
    public static IGetDataCallback<mdb.a> j;
    public static mdb.a k;

    @AppSettingPlugin
    public static final class a implements npb.a {
        public a() {
        }

        public final void a() {
        }

        public final Collection<AbstractBaseSettingHandler> b() {
            return SetsKt.mutableSetOf(new SettingsMetricsHandler[]{SettingsMetricsHandler.i});
        }

        public final String getTag() {
            return "SettingsMetricsHandler";
        }
    }

    public final String a() {
        return "settings_performance_metrics_config_v2";
    }

    public final String f() {
        return "SettingsMetricsHandler";
    }

    static {
        SettingsMetricsHandler r0 = new SettingsMetricsHandler();
        i = r0;
        CoreThreadPool.getDefault().getFixedThreadPool().execute(com.ss.android.lark.featuregatingv2impl.handler.a.a);
        AbstractBaseSettingHandler.a r1 = ((AbstractBaseSettingHandler) r0).d;
        r1.c(AnonymousClass1.INSTANCE);
        Intrinsics.checkNotNullParameter(r1, "<set-?>");
        ((AbstractBaseSettingHandler) r0).f = r1;
    }

    public final mdb.a j() {
        if (k == null) goto L10;
    L8:
        Log.d("SettingsMetricsHandler", "getMetricsConfig: " + k);
        return k;
    L10:
        k = (mdb.a) new Gson().fromJson(g(), mdb.a.class);     // Catch: Exception -> L6
    L6:
        e = move-exception;
        Log.e("SettingsMetricsHandler", "getMetricsConfig fromJson failed, e: " + e);
        goto L8
    }

    public SettingsMetricsHandler() {
    }
}
