package com.bytedance.ai.bridge.service;

import android.app.Application;
import android.content.Context;
import androidx.annotation.Keep;
import k2.b;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Keep
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\bg\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001dJ\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH&¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0005H&¢\u0006\u0004\b\u000b\u0010\u0007J\u000f\u0010\f\u001a\u00020\u0005H&¢\u0006\u0004\b\f\u0010\u0007J\u000f\u0010\r\u001a\u00020\u0005H&¢\u0006\u0004\b\r\u0010\u0007J\u000f\u0010\u000e\u001a\u00020\u0005H&¢\u0006\u0004\b\u000e\u0010\u0007J\u000f\u0010\u000f\u001a\u00020\u0005H&¢\u0006\u0004\b\u000f\u0010\u0007J\u000f\u0010\u0010\u001a\u00020\u0005H&¢\u0006\u0004\b\u0010\u0010\u0007J\u000f\u0010\u0011\u001a\u00020\u0005H&¢\u0006\u0004\b\u0011\u0010\u0007J\u000f\u0010\u0012\u001a\u00020\u0005H&¢\u0006\u0004\b\u0012\u0010\u0007J\u0011\u0010\u0013\u001a\u0004\u0018\u00010\u0005H&¢\u0006\u0004\b\u0013\u0010\u0007J\u000f\u0010\u0015\u001a\u00020\u0014H&¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u0014H&¢\u0006\u0004\b\u0017\u0010\u0016J\u0011\u0010\u0018\u001a\u0004\u0018\u00010\u0005H&¢\u0006\u0004\b\u0018\u0010\u0007J\u000f\u0010\u001a\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\u001a\u0010\u001b¨\u0006\u001e"}, d2 = {"Lcom/bytedance/ai/bridge/service/IHostContextDepend;", "", "Landroid/app/Application;", "getApplication", "()Landroid/app/Application;", "", "getDeviceId", "()Ljava/lang/String;", "", "getAppId", "()I", "getAppName", "getChannel", "getVersionName", "getUpdateVersion", "getLanguage", "getSkinName", "getClientDid", "getPackageName", "getHttpEnv", "", "isTeenMode", "()Z", "isBaseMode", "getCurrentTelcomCarrier", "Landroid/content/Context;", "getApplicationContext", "()Landroid/content/Context;", "Companion", "k2/b", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface IHostContextDepend {
    public static final b Companion = null;
    public static final String SKIN_TYPE_BLACK = "black";
    public static final String SKIN_TYPE_WHITE = "white";

    static {
        Companion = b.f18583a;
    }

    int getAppId();

    String getAppName();

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
