package com.bytedance.ai.bridge.service;

import android.app.Application;
import android.content.Context;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\b\u001a\u00020\u0005H&J\b\u0010\t\u001a\u00020\u0005H&J\b\u0010\n\u001a\u00020\u0005H&J\b\u0010\u000b\u001a\u00020\u0005H&J\b\u0010\f\u001a\u00020\u0005H&J\b\u0010\r\u001a\u00020\u0005H&J\b\u0010\u000e\u001a\u00020\u0005H&J\b\u0010\u000f\u001a\u00020\u0005H&J\n\u0010\u0010\u001a\u0004\u0018\u00010\u0005H&J\b\u0010\u0011\u001a\u00020\u0012H&J\b\u0010\u0013\u001a\u00020\u0012H&J\n\u0010\u0014\u001a\u0004\u0018\u00010\u0005H&J\b\u0010\u0015\u001a\u00020\u0005H\u0016J\b\u0010\u0016\u001a\u00020\u0017H\u0016¨\u0006\u0019"}, d2 = {"Lcom/bytedance/ai/bridge/service/IHostContextDepend;", "", "getApplication", "Landroid/app/Application;", "getDeviceId", "", "getAppId", "", "getAppName", "getChannel", "getVersionName", "getUpdateVersion", "getLanguage", "getSkinName", "getClientDid", "getPackageName", "getHttpEnv", "isTeenMode", "", "isBaseMode", "getCurrentTelcomCarrier", "getAppUaName", "getApplicationContext", "Landroid/content/Context;", "Companion", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IHostContextDepend {
    public static final a Companion = null;
    public static final String SKIN_TYPE_BLACK = "black";
    public static final String SKIN_TYPE_WHITE = "white";

    public static final class a {
        public static final /* synthetic */ a a = null;

        static {
            a = new a();
        }

        public a() {
        }
    }

    static {
        Companion = a.a;
    }

    int getAppId();

    String getAppName();

    String getAppUaName();

    Application getApplication();

    Context getApplicationContext();

    String getChannel();

    String getClientDid();

    String getCurrentTelcomCarrier();

    String getDeviceId();

    String getHttpEnv();

    String getLanguage();

    String getPackageName();

    String getSkinName();

    String getUpdateVersion();

    String getVersionName();

    boolean isBaseMode();

    boolean isTeenMode();
}
