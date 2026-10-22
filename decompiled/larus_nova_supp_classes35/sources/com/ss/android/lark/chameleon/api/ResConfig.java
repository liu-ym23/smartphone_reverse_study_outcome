package com.ss.android.lark.chameleon.api;

import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0007HÆ\u0003J9\u0010\u0019\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dHÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\b\u0010 \u001a\u00020\u0003H\u0016R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u000e\"\u0004\b\u0012\u0010\u0010R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000e\"\u0004\b\u0014\u0010\u0010¨\u0006!"}, d2 = {"Lcom/ss/android/lark/chameleon/api/ResConfig;", "Ljava/io/Serializable;", "resVersion", BuildConfig.FLAVOR, "offlineZipName", "rootPath", "geckoConfig", "Lcom/ss/android/lark/chameleon/api/ChameleonGeckoConfig;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/ss/android/lark/chameleon/api/ChameleonGeckoConfig;)V", "getGeckoConfig", "()Lcom/ss/android/lark/chameleon/api/ChameleonGeckoConfig;", "setGeckoConfig", "(Lcom/ss/android/lark/chameleon/api/ChameleonGeckoConfig;)V", "getOfflineZipName", "()Ljava/lang/String;", "setOfflineZipName", "(Ljava/lang/String;)V", "getResVersion", "setResVersion", "getRootPath", "setRootPath", "component1", "component2", "component3", "component4", "copy", "equals", BuildConfig.FLAVOR, "other", BuildConfig.FLAVOR, "hashCode", BuildConfig.FLAVOR, "toString", "chameleon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class ResConfig implements Serializable {
    private ChameleonGeckoConfig geckoConfig;
    private String offlineZipName;
    private String resVersion;
    private String rootPath;

    public ResConfig() {
        this(null, null, null, null, 15, null);
    }

    public static /* synthetic */ ResConfig copy$default(ResConfig r0, String r1, String r2, String r3, ChameleonGeckoConfig r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.resVersion;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = r0.offlineZipName;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = r0.rootPath;
    L12:
        if ((r5 & 8) == 0) goto L15;
        r4 = r0.geckoConfig;
    L15:
        return r0.copy(r1, r2, r3, r4);
    }

    public final String component1() {
        return this.resVersion;
    }

    public final String component2() {
        return this.offlineZipName;
    }

    public final String component3() {
        return this.rootPath;
    }

    public final ChameleonGeckoConfig component4() {
        return this.geckoConfig;
    }

    public final ResConfig copy(String r2, String r3, String r4, ChameleonGeckoConfig r5) {
        return new ResConfig(r2, r3, r4, r5);
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
        if (Intrinsics.areEqual(this.rootPath, r6.rootPath) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.geckoConfig, r6.geckoConfig) == true) goto L20;
        return false;
    L20:
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
        String r7 = this.rootPath;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        ChameleonGeckoConfig r10 = this.geckoConfig;
        if (r10 == null) goto L19;
        r1 = r10.hashCode();
    L19:
        return r9 + r1;
    L13:
        r8 = r7.hashCode();
        goto L14
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "ResConfig(resVersion=" + this.resVersion + ", offlineZipName=" + this.offlineZipName + ", rootPath=" + this.rootPath + ", geckoConfig=" + this.geckoConfig + ')';
    }

    public final ChameleonGeckoConfig getGeckoConfig() {
        return this.geckoConfig;
    }

    public final String getOfflineZipName() {
        return this.offlineZipName;
    }

    public final String getResVersion() {
        return this.resVersion;
    }

    public final String getRootPath() {
        return this.rootPath;
    }

    public final void setGeckoConfig(ChameleonGeckoConfig r1) {
        this.geckoConfig = r1;
    }

    public final void setOfflineZipName(String r1) {
        this.offlineZipName = r1;
    }

    public final void setResVersion(String r1) {
        this.resVersion = r1;
    }

    public final void setRootPath(String r1) {
        this.rootPath = r1;
    }

    public ResConfig(String r1, String r2, String r3, ChameleonGeckoConfig r4) {
        this.resVersion = r1;
        this.offlineZipName = r2;
        this.rootPath = r3;
        this.geckoConfig = r4;
    }

    public /* synthetic */ ResConfig(String r2, String r3, String r4, ChameleonGeckoConfig r5, int r6, DefaultConstructorMarker r7) {
        if ((r6 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r6 & 2) == 0) goto L9;
        r3 = null;
    L9:
        if ((r6 & 4) == 0) goto L12;
        r4 = null;
    L12:
        if ((r6 & 8) == 0) goto L14;
        r5 = null;
    L14:
        this(r2, r3, r4, r5);
    }
}
