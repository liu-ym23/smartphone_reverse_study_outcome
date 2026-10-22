package com.ss.android.lark.desktopmode.base;

import android.content.Intent;
import java.io.Serializable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class StandAloneParam implements Serializable {
    public final transient Intent a;
    private final boolean clipChildren;
    private final int launchMode;
    private final int requestCode;
    private final int[] targetCoordination;
    private final int targetWindowHeight;
    private final int targetWindowWidth;

    @Retention(RetentionPolicy.SOURCE)
    public @interface LaunchMode {
        public static final int BOUNDARY_ADAPT = 2;
        public static final int PARENT_CENTER = 0;
        public static final int TARGET_COORDINATE = 1;
    }

    public Intent getIntent() {
        return this.a;
    }

    public int getLaunchMode() {
        return this.launchMode;
    }

    public int getRequestCode() {
        return this.requestCode;
    }

    public int[] getTargetCoordination() {
        return this.targetCoordination;
    }

    public int getTargetWindowHeight() {
        return this.targetWindowHeight;
    }

    public int getTargetWindowWidth() {
        return this.targetWindowWidth;
    }

    public boolean isClipChildren() {
        return this.clipChildren;
    }

    public StandAloneParam(Intent r1, int r2, int[] r3, int r4, int r5, int r6, boolean r7) {
        this.a = r1;
        this.launchMode = r2;
        this.targetCoordination = r3;
        this.targetWindowWidth = r4;
        this.targetWindowHeight = r5;
        this.requestCode = r6;
        this.clipChildren = r7;
    }
}
