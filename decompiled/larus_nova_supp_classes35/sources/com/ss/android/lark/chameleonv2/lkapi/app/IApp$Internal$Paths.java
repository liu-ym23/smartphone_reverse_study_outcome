package com.ss.android.lark.chameleonv2.lkapi.app;

import com.bytedance.ee.util.io.NonProguard;
import com.ss.android.lark.chameleon.container.webcontainer.res.resupdate.ChameleonAssertResManager;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003JE\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\f¨\u0006 "}, d2 = {"Lcom/ss/android/lark/chameleonv2/lkapi/app/IApp$Internal$Paths;", "Lcom/bytedance/ee/util/io/NonProguard;", ChameleonAssertResManager.ASSET_FOLDER, BuildConfig.FLAVOR, "iron", "library", "log", "userData", "webContent", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAssets", "()Ljava/lang/String;", "getIron", "getLibrary", "getLog", "getUserData", "getWebContent", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", BuildConfig.FLAVOR, "other", BuildConfig.FLAVOR, "hashCode", BuildConfig.FLAVOR, "toString", "larkapi_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class IApp$Internal$Paths implements NonProguard {
    private final String assets;
    private final String iron;
    private final String library;
    private final String log;
    private final String userData;
    private final String webContent;

    public static /* synthetic */ IApp$Internal$Paths copy$default(IApp$Internal$Paths r4, String r5, String r6, String r7, String r8, String r9, String r10, int r11, Object r12) {
        if ((r11 & 1) == 0) goto L6;
        r5 = r4.assets;
    L6:
        if ((r11 & 2) == 0) goto L8;
        r6 = r4.iron;
    L8:
        String r13 = r6;
        if ((r11 & 4) == 0) goto L11;
        r7 = r4.library;
    L11:
        String r0 = r7;
        if ((r11 & 8) == 0) goto L14;
        r8 = r4.log;
    L14:
        String r1 = r8;
        if ((r11 & 16) == 0) goto L17;
        r9 = r4.userData;
    L17:
        String r2 = r9;
        if ((r11 & 32) == 0) goto L20;
        r10 = r4.webContent;
    L20:
        String r14 = r5;
        return r4.copy(r14, r13, r0, r1, r2, r10);
    }

    public final String component1() {
        return this.assets;
    }

    public final String component2() {
        return this.iron;
    }

    public final String component3() {
        return this.library;
    }

    public final String component4() {
        return this.log;
    }

    public final String component5() {
        return this.userData;
    }

    public final String component6() {
        return this.webContent;
    }

    public final IApp$Internal$Paths copy(String r9, String r10, String r11, String r12, String r13, String r14) {
        Intrinsics.checkNotNullParameter(r9, ChameleonAssertResManager.ASSET_FOLDER);
        Intrinsics.checkNotNullParameter(r10, "iron");
        Intrinsics.checkNotNullParameter(r11, "library");
        Intrinsics.checkNotNullParameter(r12, "log");
        Intrinsics.checkNotNullParameter(r13, "userData");
        Intrinsics.checkNotNullParameter(r14, "webContent");
        return new IApp$Internal$Paths(r9, r10, r11, r12, r13, r14);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof IApp$Internal$Paths) == true) goto L8;
        return false;
    L8:
        IApp$Internal$Paths r6 = (IApp$Internal$Paths) r5;
        if (Intrinsics.areEqual(this.assets, r6.assets) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.iron, r6.iron) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.library, r6.library) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.log, r6.log) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.userData, r6.userData) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.webContent, r6.webContent) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public int hashCode() {
        return (((((((((this.assets.hashCode() * 31) + this.iron.hashCode()) * 31) + this.library.hashCode()) * 31) + this.log.hashCode()) * 31) + this.userData.hashCode()) * 31) + this.webContent.hashCode();
    }

    public String toString() {
        return "Paths(assets=" + this.assets + ", iron=" + this.iron + ", library=" + this.library + ", log=" + this.log + ", userData=" + this.userData + ", webContent=" + this.webContent + ')';
    }

    public final String getAssets() {
        return this.assets;
    }

    public final String getIron() {
        return this.iron;
    }

    public final String getLibrary() {
        return this.library;
    }

    public final String getLog() {
        return this.log;
    }

    public final String getUserData() {
        return this.userData;
    }

    public final String getWebContent() {
        return this.webContent;
    }

    public IApp$Internal$Paths(String r2, String r3, String r4, String r5, String r6, String r7) {
        Intrinsics.checkNotNullParameter(r2, ChameleonAssertResManager.ASSET_FOLDER);
        Intrinsics.checkNotNullParameter(r3, "iron");
        Intrinsics.checkNotNullParameter(r4, "library");
        Intrinsics.checkNotNullParameter(r5, "log");
        Intrinsics.checkNotNullParameter(r6, "userData");
        Intrinsics.checkNotNullParameter(r7, "webContent");
        this.assets = r2;
        this.iron = r3;
        this.library = r4;
        this.log = r5;
        this.userData = r6;
        this.webContent = r7;
    }
}
