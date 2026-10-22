package com.ss.android.lark.chameleonv2.lkapi.ui;

import com.bytedance.ee.util.io.NonProguard;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/ss/android/lark/chameleonv2/lkapi/ui/IUI$ZoomLevelInfo;", "Lcom/bytedance/ee/util/io/NonProguard;", "zoomLevel", "Lcom/ss/android/lark/chameleonv2/lkapi/ui/IUI$ZoomLevel;", "fontScale", BuildConfig.FLAVOR, "<init>", "(Lcom/ss/android/lark/chameleonv2/lkapi/ui/IUI$ZoomLevel;Ljava/lang/String;)V", "getZoomLevel", "()Lcom/ss/android/lark/chameleonv2/lkapi/ui/IUI$ZoomLevel;", "getFontScale", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", BuildConfig.FLAVOR, "other", BuildConfig.FLAVOR, "hashCode", BuildConfig.FLAVOR, "toString", "larkapi_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class IUI$ZoomLevelInfo implements NonProguard {
    private final String fontScale;
    private final IUI$ZoomLevel zoomLevel;

    public static /* synthetic */ IUI$ZoomLevelInfo copy$default(IUI$ZoomLevelInfo r0, IUI$ZoomLevel r1, String r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.zoomLevel;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.fontScale;
    L9:
        return r0.copy(r1, r2);
    }

    public final IUI$ZoomLevel component1() {
        return this.zoomLevel;
    }

    public final String component2() {
        return this.fontScale;
    }

    public final IUI$ZoomLevelInfo copy(IUI$ZoomLevel r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "zoomLevel");
        Intrinsics.checkNotNullParameter(r3, "fontScale");
        return new IUI$ZoomLevelInfo(r2, r3);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof IUI$ZoomLevelInfo) == true) goto L8;
        return false;
    L8:
        IUI$ZoomLevelInfo r6 = (IUI$ZoomLevelInfo) r5;
        if (this.zoomLevel == r6.zoomLevel) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.fontScale, r6.fontScale) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (this.zoomLevel.hashCode() * 31) + this.fontScale.hashCode();
    }

    public String toString() {
        return "ZoomLevelInfo(zoomLevel=" + this.zoomLevel + ", fontScale=" + this.fontScale + ')';
    }

    public final String getFontScale() {
        return this.fontScale;
    }

    public final IUI$ZoomLevel getZoomLevel() {
        return this.zoomLevel;
    }

    public IUI$ZoomLevelInfo(IUI$ZoomLevel r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "zoomLevel");
        Intrinsics.checkNotNullParameter(r3, "fontScale");
        this.zoomLevel = r2;
        this.fontScale = r3;
    }
}
