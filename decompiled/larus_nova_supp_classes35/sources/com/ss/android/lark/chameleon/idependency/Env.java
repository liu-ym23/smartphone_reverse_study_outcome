package com.ss.android.lark.chameleon.idependency;

import android.app.Application;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\n\u001a\u00020\u000bH\u0007J\b\u0010\f\u001a\u00020\rH\u0007J\b\u0010\u000e\u001a\u00020\u000fH\u0007J\b\u0010\u0010\u001a\u00020\u0011H\u0007J\b\u0010\u0012\u001a\u00020\u000bH\u0007J\b\u0010\u0013\u001a\u00020\u0011H\u0007J\b\u0010\u0014\u001a\u00020\u0011H\u0007J\b\u0010\u0015\u001a\u00020\u0011H\u0007J\b\u0010\u0016\u001a\u00020\u0017H\u0007J\b\u0010\u0018\u001a\u00020\u0017H\u0007R(\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u0019"}, d2 = {"Lcom/ss/android/lark/chameleon/idependency/Env;", BuildConfig.FLAVOR, "()V", "value", "Lcom/ss/android/lark/chameleon/idependency/IEnv;", "iEnv", "getIEnv", "()Lcom/ss/android/lark/chameleon/idependency/IEnv;", "setIEnv", "(Lcom/ss/android/lark/chameleon/idependency/IEnv;)V", "getAppId", BuildConfig.FLAVOR, "getApplication", "Landroid/app/Application;", "getCacheLanguageSetting", "Ljava/util/Locale;", "getDeviceId", BuildConfig.FLAVOR, "getFontSize", "getGeckoDomain", "getUserAgent", "getUserId", "isDarkMode", BuildConfig.FLAVOR, "isDebug", "chameleon-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class Env {
    public static final Env INSTANCE = null;
    private static IEnv iEnv;

    static {
        INSTANCE = new Env();
    }

    private Env() {
    }

    @JvmStatic
    public static final int getAppId() {
        IEnv r0 = iEnv;
        if (r0 != null) goto L7;
        return -1;
    L7:
        return r0.getAppId();
    }

    @JvmStatic
    public static final Application getApplication() {
        IEnv r0 = iEnv;
        if (r0 == null) goto L7;
        Application r1 = r0.getApplication();
        if (r1 == null) goto L7;
        return r1;
    L7:
        return new Application();
    }

    @JvmStatic
    public static final Locale getCacheLanguageSetting() {
        IEnv r0 = iEnv;
        if (r0 == null) goto L7;
        Locale r1 = r0.getCacheLanguageSetting();
        if (r1 == null) goto L7;
        return r1;
    L7:
        return Locale.getDefault();
    }

    @JvmStatic
    public static final String getDeviceId() {
        IEnv r0 = iEnv;
        if (r0 == null) goto L6;
        String r1 = r0.getDeviceId();
        if (r1 == null) goto L6;
        return r1;
    L6:
        return BuildConfig.FLAVOR;
    }

    @JvmStatic
    public static final int getFontSize() {
        IEnv r0 = iEnv;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.getFontSize();
    }

    @JvmStatic
    public static final String getGeckoDomain() {
        IEnv r0 = iEnv;
        if (r0 == null) goto L6;
        String r1 = r0.getGeckoDomain();
        if (r1 == null) goto L6;
        return r1;
    L6:
        return BuildConfig.FLAVOR;
    }

    @JvmStatic
    public static final String getUserAgent() {
        IEnv r0 = iEnv;
        if (r0 == null) goto L6;
        String r1 = r0.getUserAgent();
        if (r1 == null) goto L6;
        return r1;
    L6:
        return BuildConfig.FLAVOR;
    }

    @JvmStatic
    public static final String getUserId() {
        IEnv r0 = iEnv;
        if (r0 == null) goto L6;
        String r1 = r0.getUserId();
        if (r1 == null) goto L6;
        return r1;
    L6:
        return BuildConfig.FLAVOR;
    }

    @JvmStatic
    public static final boolean isDarkMode() {
        IEnv r0 = iEnv;
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.isDarkMode();
    }

    @JvmStatic
    public static final boolean isDebug() {
        IEnv r0 = iEnv;
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.isDebug();
    }

    public final IEnv getIEnv() {
        return iEnv;
    }

    public final void setIEnv(IEnv r1) {
        iEnv = r1;
    }
}
