package com.ss.android.lark.chameleon.pluginsystem.plugin;

import java.util.Objects;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class DeviceInfo {
    public int statusBarHeight;
    public int titleBarHeight;
    public float titleBarLayoutVisiblePercent;
    public boolean titleBarVisible;
    public float titleBarVisiblePercent;

    public DeviceInfo() {
    }

    public int hashCode() {
        return Objects.hash(new Object[]{Integer.valueOf(this.statusBarHeight), Integer.valueOf(this.titleBarHeight), Float.valueOf(this.titleBarVisiblePercent)});
    }

    public String toString() {
        return "DeviceInfo{statusBarHeight=" + this.statusBarHeight + ", titleBarHeight=" + this.titleBarHeight + ", titleBarVisiblePercent=" + this.titleBarVisiblePercent + ", titleBarLayoutVisiblePercent=" + this.titleBarLayoutVisiblePercent + '}';
    }

    public DeviceInfo(DeviceInfo r2) {
        this.statusBarHeight = r2.statusBarHeight;
        this.titleBarHeight = r2.titleBarHeight;
        this.titleBarVisiblePercent = r2.titleBarVisiblePercent;
        this.titleBarLayoutVisiblePercent = r2.titleBarLayoutVisiblePercent;
        this.titleBarVisible = r2.titleBarVisible;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (r5 != null) goto L8;
    L21:
        return false;
    L8:
        if (DeviceInfo.class != r5.getClass()) goto L21;
        DeviceInfo r6 = (DeviceInfo) r5;
        if (this.statusBarHeight == r6.statusBarHeight) goto L13;
    L19:
        return false;
    L13:
        if (this.titleBarHeight != r6.titleBarHeight) goto L19;
        if (this.titleBarVisible != r6.titleBarVisible) goto L19;
        if (Float.compare(r6.titleBarVisiblePercent, this.titleBarVisiblePercent) != 0) goto L19;
        return true;
    }
}
