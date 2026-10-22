package com.ss.android.lark.chameleon;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0006\u0010\u0013\u001a\u00020\u0000J\b\u0010\u0014\u001a\u00020\u0003H\u0016J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0006HÆ\u0003J-\u0010\u0013\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bHÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\n\"\u0004\b\u000e\u0010\fR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u001e"}, d2 = {"Lcom/ss/android/lark/chameleon/ResConfig;", "Ljava/io/Serializable;", "resVersion", com.tencent.qqmusic.third.api.contract.BuildConfig.FLAVOR, "offlineZipName", "geckoConfig", "Lcom/ss/android/lark/chameleon/ResGeckoConfig;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/ss/android/lark/chameleon/ResGeckoConfig;)V", "getResVersion", "()Ljava/lang/String;", "setResVersion", "(Ljava/lang/String;)V", "getOfflineZipName", "setOfflineZipName", "getGeckoConfig", "()Lcom/ss/android/lark/chameleon/ResGeckoConfig;", "setGeckoConfig", "(Lcom/ss/android/lark/chameleon/ResGeckoConfig;)V", "copy", "toString", "component1", "component2", "component3", "equals", com.tencent.qqmusic.third.api.contract.BuildConfig.FLAVOR, "other", com.tencent.qqmusic.third.api.contract.BuildConfig.FLAVOR, "hashCode", com.tencent.qqmusic.third.api.contract.BuildConfig.FLAVOR, "chameleon-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ResConfig implements Serializable {
    private ResGeckoConfig geckoConfig;
    private String offlineZipName;
    private String resVersion;

    public ResConfig() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ ResConfig copy$default(ResConfig r0, String r1, String r2, ResGeckoConfig r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.resVersion;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.offlineZipName;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.geckoConfig;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public final String component1() {
        return this.resVersion;
    }

    public final String component2() {
        return this.offlineZipName;
    }

    public final ResGeckoConfig component3() {
        return this.geckoConfig;
    }

    public final ResConfig copy(String r2, String r3, ResGeckoConfig r4) {
        return new ResConfig(r2, r3, r4);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof ResConfig) == true) goto L8;
        return false;
    L8:
        ResConfig r6 = (ResConfig) r5;
        if (Intrinsics.areEqual(this.resVersion, r6.resVersion) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.offlineZipName, r6.offlineZipName) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.geckoConfig, r6.geckoConfig) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        String r0 = this.resVersion;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.offlineZipName;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        ResGeckoConfig r7 = this.geckoConfig;
        if (r7 == null) goto L15;
        r1 = r7.hashCode();
    L15:
        return r6 + r1;
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public final ResConfig copy() {
        String r1 = this.resVersion;
        String r2 = this.offlineZipName;
        ResGeckoConfig r3 = this.geckoConfig;
        if (r3 == null) goto L5;
        ResGeckoConfig r4 = r3.copy();
    L7:
        return new ResConfig(r1, r2, r4);
    L5:
        r4 = null;
        goto L7
    }

    public String toString() {
        return "ResConfig(resVersion=" + this.resVersion + ", offlineZipName=" + this.offlineZipName + ", geckoConfig=" + this.geckoConfig + ')';
    }

    public final ResGeckoConfig getGeckoConfig() {
        return this.geckoConfig;
    }

    public final String getOfflineZipName() {
        return this.offlineZipName;
    }

    public final String getResVersion() {
        return this.resVersion;
    }

    public final void setGeckoConfig(ResGeckoConfig r1) {
        this.geckoConfig = r1;
    }

    public final void setOfflineZipName(String r1) {
        this.offlineZipName = r1;
    }

    public final void setResVersion(String r1) {
        this.resVersion = r1;
    }

    public ResConfig(String r1, String r2, ResGeckoConfig r3) {
        this.resVersion = r1;
        this.offlineZipName = r2;
        this.geckoConfig = r3;
    }

    public /* synthetic */ ResConfig(String r2, String r3, ResGeckoConfig r4, int r5, DefaultConstructorMarker r6) {
        if ((r5 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r3 = null;
    L9:
        if ((r5 & 4) == 0) goto L11;
        r4 = null;
    L11:
        this(r2, r3, r4);
    }
}
