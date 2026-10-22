package com.ss.android.lark.chameleonv2.lkapi.ui;

import com.bytedance.ee.util.io.NonProguard;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/ss/android/lark/chameleonv2/lkapi/ui/IUI$Ipc$ThemeEventDetail;", "Lcom/bytedance/ee/util/io/NonProguard;", "ipcType", BuildConfig.FLAVOR, "style", "Lcom/ss/android/lark/chameleonv2/lkapi/ui/IUI$ThemeStyle;", "<init>", "(Ljava/lang/String;Lcom/ss/android/lark/chameleonv2/lkapi/ui/IUI$ThemeStyle;)V", "getIpcType", "()Ljava/lang/String;", "getStyle", "()Lcom/ss/android/lark/chameleonv2/lkapi/ui/IUI$ThemeStyle;", "component1", "component2", "copy", "equals", BuildConfig.FLAVOR, "other", BuildConfig.FLAVOR, "hashCode", BuildConfig.FLAVOR, "toString", "larkapi_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class IUI$Ipc$ThemeEventDetail implements NonProguard {
    private final String ipcType;
    private final IUI$ThemeStyle style;

    public static /* synthetic */ IUI$Ipc$ThemeEventDetail copy$default(IUI$Ipc$ThemeEventDetail r0, String r1, IUI$ThemeStyle r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.ipcType;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.style;
    L9:
        return r0.copy(r1, r2);
    }

    public final String component1() {
        return this.ipcType;
    }

    public final IUI$ThemeStyle component2() {
        return this.style;
    }

    public final IUI$Ipc$ThemeEventDetail copy(String r2, IUI$ThemeStyle r3) {
        Intrinsics.checkNotNullParameter(r2, "ipcType");
        Intrinsics.checkNotNullParameter(r3, "style");
        return new IUI$Ipc$ThemeEventDetail(r2, r3);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof IUI$Ipc$ThemeEventDetail) == true) goto L8;
        return false;
    L8:
        IUI$Ipc$ThemeEventDetail r6 = (IUI$Ipc$ThemeEventDetail) r5;
        if (Intrinsics.areEqual(this.ipcType, r6.ipcType) == true) goto L12;
        return false;
    L12:
        if (this.style == r6.style) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (this.ipcType.hashCode() * 31) + this.style.hashCode();
    }

    public String toString() {
        return "ThemeEventDetail(ipcType=" + this.ipcType + ", style=" + this.style + ')';
    }

    public final String getIpcType() {
        return this.ipcType;
    }

    public final IUI$ThemeStyle getStyle() {
        return this.style;
    }

    public IUI$Ipc$ThemeEventDetail(String r2, IUI$ThemeStyle r3) {
        Intrinsics.checkNotNullParameter(r2, "ipcType");
        Intrinsics.checkNotNullParameter(r3, "style");
        this.ipcType = r2;
        this.style = r3;
    }
}
