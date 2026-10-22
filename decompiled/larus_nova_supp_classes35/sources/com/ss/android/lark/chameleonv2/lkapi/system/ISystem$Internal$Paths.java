package com.ss.android.lark.chameleonv2.lkapi.system;

import com.bytedance.ee.util.io.NonProguard;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J1\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u001a"}, d2 = {"Lcom/ss/android/lark/chameleonv2/lkapi/system/ISystem$Internal$Paths;", "Lcom/bytedance/ee/util/io/NonProguard;", "desktop", BuildConfig.FLAVOR, "downloads", "home", "temp", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getDesktop", "()Ljava/lang/String;", "getDownloads", "getHome", "getTemp", "component1", "component2", "component3", "component4", "copy", "equals", BuildConfig.FLAVOR, "other", BuildConfig.FLAVOR, "hashCode", BuildConfig.FLAVOR, "toString", "larkapi_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ISystem$Internal$Paths implements NonProguard {
    private final String desktop;
    private final String downloads;
    private final String home;
    private final String temp;

    public static /* synthetic */ ISystem$Internal$Paths copy$default(ISystem$Internal$Paths r0, String r1, String r2, String r3, String r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.desktop;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = r0.downloads;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = r0.home;
    L12:
        if ((r5 & 8) == 0) goto L15;
        r4 = r0.temp;
    L15:
        return r0.copy(r1, r2, r3, r4);
    }

    public final String component1() {
        return this.desktop;
    }

    public final String component2() {
        return this.downloads;
    }

    public final String component3() {
        return this.home;
    }

    public final String component4() {
        return this.temp;
    }

    public final ISystem$Internal$Paths copy(String r2, String r3, String r4, String r5) {
        Intrinsics.checkNotNullParameter(r2, "desktop");
        Intrinsics.checkNotNullParameter(r3, "downloads");
        Intrinsics.checkNotNullParameter(r4, "home");
        Intrinsics.checkNotNullParameter(r5, "temp");
        return new ISystem$Internal$Paths(r2, r3, r4, r5);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof ISystem$Internal$Paths) == true) goto L8;
        return false;
    L8:
        ISystem$Internal$Paths r6 = (ISystem$Internal$Paths) r5;
        if (Intrinsics.areEqual(this.desktop, r6.desktop) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.downloads, r6.downloads) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.home, r6.home) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.temp, r6.temp) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        return (((((this.desktop.hashCode() * 31) + this.downloads.hashCode()) * 31) + this.home.hashCode()) * 31) + this.temp.hashCode();
    }

    public String toString() {
        return "Paths(desktop=" + this.desktop + ", downloads=" + this.downloads + ", home=" + this.home + ", temp=" + this.temp + ')';
    }

    public final String getDesktop() {
        return this.desktop;
    }

    public final String getDownloads() {
        return this.downloads;
    }

    public final String getHome() {
        return this.home;
    }

    public final String getTemp() {
        return this.temp;
    }

    public ISystem$Internal$Paths(String r2, String r3, String r4, String r5) {
        Intrinsics.checkNotNullParameter(r2, "desktop");
        Intrinsics.checkNotNullParameter(r3, "downloads");
        Intrinsics.checkNotNullParameter(r4, "home");
        Intrinsics.checkNotNullParameter(r5, "temp");
        this.desktop = r2;
        this.downloads = r3;
        this.home = r4;
        this.temp = r5;
    }
}
