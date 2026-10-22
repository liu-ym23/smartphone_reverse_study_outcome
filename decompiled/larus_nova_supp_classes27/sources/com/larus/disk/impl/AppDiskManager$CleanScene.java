package com.larus.disk.impl;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B)\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\fR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0011"}, d2 = {"Lcom/larus/disk/impl/AppDiskManager$CleanScene;", "", "cleanType", "", "isManual", "", "isLowDisk", "customBizCacheClean", "<init>", "(Ljava/lang/String;IIZZZ)V", "getCleanType", "()I", "()Z", "getCustomBizCacheClean", "REGULAR", "LOW_DISK", "MANUAL", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum AppDiskManager$CleanScene extends Enum<AppDiskManager$CleanScene> {
    public static final AppDiskManager$CleanScene LOW_DISK = null;
    public static final AppDiskManager$CleanScene MANUAL = null;
    public static final AppDiskManager$CleanScene REGULAR = null;
    public static final /* synthetic */ AppDiskManager$CleanScene[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int cleanType;
    private final boolean customBizCacheClean;
    private final boolean isLowDisk;
    private final boolean isManual;

    public static EnumEntries<AppDiskManager$CleanScene> getEntries() {
        return b;
    }

    static {
        AppDiskManager$CleanScene r7 = new AppDiskManager$CleanScene("REGULAR", 0, 1, false, false, true);
        REGULAR = r7;
        AppDiskManager$CleanScene r0 = new AppDiskManager$CleanScene("LOW_DISK", 1, 2, false, true, false);
        LOW_DISK = r0;
        AppDiskManager$CleanScene r1 = new AppDiskManager$CleanScene("MANUAL", 2, 3, true, false, false);
        MANUAL = r1;
        AppDiskManager$CleanScene[] r2 = {r7, r0, r1};
        a = r2;
        b = EnumEntriesKt.enumEntries(r2);
    }

    public static AppDiskManager$CleanScene[] values() {
        return (AppDiskManager$CleanScene[]) a.clone();
    }

    public final int getCleanType() {
        return this.cleanType;
    }

    public final boolean getCustomBizCacheClean() {
        return this.customBizCacheClean;
    }

    public final boolean isLowDisk() {
        return this.isLowDisk;
    }

    public final boolean isManual() {
        return this.isManual;
    }

    public static AppDiskManager$CleanScene valueOf(String r1) {
        return (AppDiskManager$CleanScene) r27.a.a(AppDiskManager$CleanScene.class, r1);
    }

    public AppDiskManager$CleanScene(String r1, int r2, int r3, boolean r4, boolean r5, boolean r6) {
        super(r1, r2);
        this.cleanType = r3;
        this.isManual = r4;
        this.isLowDisk = r5;
        this.customBizCacheClean = r6;
    }
}
