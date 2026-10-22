package im.quar.autolayout.config;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import im.quar.autolayout.ScaleAdapter;
import im.quar.autolayout.utils.ScreenUtils;

/* JADX INFO: loaded from: classes2.dex */
public class AutoLayoutConfig {
    private static final String KEY_DESIGN_HEIGHT = "design_height";
    private static final String KEY_DESIGN_WIDTH = "design_width";
    private static AutoLayoutConfig sInstance;
    private int mDesignHeight;
    private int mDesignWidth;
    private float mScale;
    private int mScreenHeight;
    private int mScreenWidth;

    private AutoLayoutConfig() {
    }

    private void checkParams() {
        if (this.mDesignHeight <= 0) goto L8;
        if (this.mDesignWidth <= 0) goto L8;
        return;
    L8:
        throw new RuntimeException("you must set design_width and design_height  in your manifest file.");
    }

    public static AutoLayoutConfig getInstance() {
        AutoLayoutConfig r8 = sInstance;
        if (r8 == null) goto L6;
        return r8;
    L6:
        throw new IllegalStateException("Must init before using.");
    }

    private void getMetaData(Context r8) {
        PackageManager r10 = r8.getPackageManager();
        ApplicationInfo r11 = r10.getApplicationInfo(r8.getPackageName(), 128);     // Catch: PackageManager.NameNotFoundException -> L9
        if (r11 == null) goto L14;
        Bundle r12 = r11.metaData;     // Catch: PackageManager.NameNotFoundException -> L9
        if (r12 == null) goto L15;
        this.mDesignWidth = ((Integer) r12.get(KEY_DESIGN_WIDTH)).intValue();     // Catch: PackageManager.NameNotFoundException -> L9
        this.mDesignHeight = ((Integer) r11.metaData.get(KEY_DESIGN_HEIGHT)).intValue();     // Catch: PackageManager.NameNotFoundException -> L9
        return;
    L15:
        return;
    L14:
        return;
    L9:
        e = move-exception;
        throw new RuntimeException("you must set design_width and design_height  in your manifest file.", e);
    }

    public static void init(Context r8) {
        init(r8, new DefaultScaleAdapter(r8));
    }

    private void initInternal(Context r8, ScaleAdapter r10) {
        getMetaData(r8);
        checkParams();
        int[] r11 = ScreenUtils.getRealScreenSize(r8);
        int r12 = r11[0];
        this.mScreenWidth = r12;
        int r13 = r11[1];
        this.mScreenHeight = r13;
        if (r12 <= r13) goto L5;
        int r14 = r12 + r13;
        int r15 = r14 - r13;
        this.mScreenHeight = r15;
        this.mScreenWidth = r14 - r15;
    L5:
        int r16 = this.mScreenHeight;
        int r17 = this.mScreenWidth;
        float r18 = r16 / r17;
        int r19 = this.mDesignHeight;
        int r20 = this.mDesignWidth;
        if (r18 > (r19 / r20)) goto L8;
        float r21 = r16;
        float r22 = r19;
    L9:
        this.mScale = r21 / r22;
        if (r10 == null) goto L13;
        this.mScale = r10.adapt(this.mScale, r17, r16);
        return;
    L13:
        return;
    L8:
        r21 = r17;
        r22 = r20;
        goto L9
    }

    public int getDesignHeight() {
        return this.mDesignHeight;
    }

    public int getDesignWidth() {
        return this.mDesignWidth;
    }

    public float getScale() {
        return this.mScale;
    }

    public int getScreenHeight() {
        return this.mScreenHeight;
    }

    public int getScreenWidth() {
        return this.mScreenWidth;
    }

    public static void init(Context r8, ScaleAdapter r10) {
        if (sInstance != null) goto L6;
        AutoLayoutConfig r11 = new AutoLayoutConfig();
        sInstance = r11;
        r11.initInternal(r8, r10);
        return;
    }
}
