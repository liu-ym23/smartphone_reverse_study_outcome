package com.bytedance.ies.xbridge.base.runtime.depend;

import android.app.Application;
import android.content.Context;
import androidx.annotation.Keep;
import fe.c;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Keep
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\bg\u0018\u0000 '2\u00020\u0001:\u0001(J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH&¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0005H&¢\u0006\u0004\b\u000b\u0010\u0007J\u000f\u0010\f\u001a\u00020\u0005H&¢\u0006\u0004\b\f\u0010\u0007J\u000f\u0010\u000e\u001a\u00020\rH&¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0005H&¢\u0006\u0004\b\u0010\u0010\u0007J\u000f\u0010\u0011\u001a\u00020\u0005H&¢\u0006\u0004\b\u0011\u0010\u0007J\u000f\u0010\u0012\u001a\u00020\u0005H&¢\u0006\u0004\b\u0012\u0010\u0007J\u000f\u0010\u0013\u001a\u00020\u0005H&¢\u0006\u0004\b\u0013\u0010\u0007J\u000f\u0010\u0014\u001a\u00020\u0005H&¢\u0006\u0004\b\u0014\u0010\u0007J\u000f\u0010\u0015\u001a\u00020\u0005H&¢\u0006\u0004\b\u0015\u0010\u0007J\u000f\u0010\u0017\u001a\u00020\u0016H&¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\u0016H&¢\u0006\u0004\b\u0019\u0010\u0018J\u000f\u0010\u001a\u001a\u00020\u0005H&¢\u0006\u0004\b\u001a\u0010\u0007J\u000f\u0010\u001b\u001a\u00020\u0016H&¢\u0006\u0004\b\u001b\u0010\u0018J\u000f\u0010\u001c\u001a\u00020\u0005H&¢\u0006\u0004\b\u001c\u0010\u0007J\u000f\u0010\u001d\u001a\u00020\u0016H&¢\u0006\u0004\b\u001d\u0010\u0018J\u000f\u0010\u001e\u001a\u00020\u0016H&¢\u0006\u0004\b\u001e\u0010\u0018J\u0011\u0010\u001f\u001a\u0004\u0018\u00010\u0005H&¢\u0006\u0004\b\u001f\u0010\u0007J#\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00010 2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00010 H&¢\u0006\u0004\b\"\u0010#J\u000f\u0010%\u001a\u00020$H\u0016¢\u0006\u0004\b%\u0010&¨\u0006)"}, d2 = {"Lcom/bytedance/ies/xbridge/base/runtime/depend/IHostContextDepend;", "", "Landroid/app/Application;", "getApplication", "()Landroid/app/Application;", "", "getDeviceId", "()Ljava/lang/String;", "", "getAppId", "()I", "getAppName", "getChannel", "", "getVersionCode", "()J", "getVersionName", "getUpdateVersion", "getLanguage", "getSkinType", "getSkinName", "getPackageName", "", "isDebuggable", "()Z", "isBoeEnable", "getBoeChannel", "isPPEEnable", "getPPEChannel", "isTeenMode", "isBaseMode", "getCurrentTelcomCarrier", "", "settingKeys", "getSettings", "(Ljava/util/List;)Ljava/util/List;", "Landroid/content/Context;", "getApplicationContext", "()Landroid/content/Context;", "Companion", "fe/c", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public interface IHostContextDepend {
    public static final c Companion = null;
    public static final String SKIN_TYPE_BLACK = "black";
    public static final String SKIN_TYPE_WHITE = "white";

    static {
        Companion = c.f16891a;
    }

    int getAppId();

    String getAppName();

    Application getApplication();

    Context getApplicationContext();

    String getBoeChannel();

    String getChannel();

    String getCurrentTelcomCarrier();

    String getDeviceId();

    String getLanguage();

    String getPPEChannel();

    String getPackageName();

    List<Object> getSettings(List<Object> r5);

    String getSkinName();

    String getSkinType();

    String getUpdateVersion();

    long getVersionCode();

    String getVersionName();

    boolean isBaseMode();

    boolean isBoeEnable();

    boolean isDebuggable();

    boolean isPPEEnable();

    boolean isTeenMode();
}
