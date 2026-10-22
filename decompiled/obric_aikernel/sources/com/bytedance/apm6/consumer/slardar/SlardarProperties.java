package com.bytedance.apm6.consumer.slardar;

import android.app.Application;
import com.bytedance.apm6.util.ApmBaseContext;
import com.bytedance.apm6.util.IOUtils;
import java.io.InputStream;
import java.util.Properties;

/* JADX INFO: loaded from: classes.dex */
public class SlardarProperties {
    private static final String KEY_RELEASE_BUILD = "release_build";
    private static final String PROPERTIES_PATH = "slardar.properties";
    private static Properties mProperties;

    public SlardarProperties() {
    }

    public static String getReleaseBuild() {
        return String.valueOf(readKey("release_build"));
    }

    private static Object readKey(String r10) {
        tryLoadPropertiesFromApk();
        Properties r11 = mProperties;     // Catch: Exception -> L9
        if (r11 != null) goto L6;
        return null;
    L6:
        if (r11.containsKey(r10) == false) goto L13;
        return mProperties.get(r10);
    L13:
        return null;
    L14:
        return null;
    }

    private static void tryLoadPropertiesFromApk() {
        Application r10 = ApmBaseContext.getContext();
        if (mProperties != null) goto L15;
        mProperties = new Properties();
        InputStream r11 = r10.getApplicationContext().getAssets().open(PROPERTIES_PATH);     // Catch: Throwable -> L8
        mProperties.load(r11);     // Catch: Throwable -> L16
    L10:
        IOUtils.closeQuietly(r11);
        return;
    L21:
        mProperties = null;     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        IOUtils.closeQuietly(r11);
        throw th;
    L8:
        r11 = null;
        goto L21
    }
}
