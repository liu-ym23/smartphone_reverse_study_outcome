package com.ss.android.lark.export.entity.preview;

import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/ss/android/lark/export/entity/preview/UnifiedHeaderInfo;", "Ljava/io/Serializable;", "icon", "Lcom/ss/android/lark/export/entity/preview/ColorIcon;", "<init>", "(Lcom/ss/android/lark/export/entity/preview/ColorIcon;)V", "getIcon", "()Lcom/ss/android/lark/export/entity/preview/ColorIcon;", "component1", "copy", "equals", BuildConfig.FLAVOR, "other", BuildConfig.FLAVOR, "hashCode", BuildConfig.FLAVOR, "toString", BuildConfig.FLAVOR, "chat-preview-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class UnifiedHeaderInfo implements Serializable {
    private final ColorIcon icon;

    public static /* synthetic */ UnifiedHeaderInfo copy$default(UnifiedHeaderInfo r0, ColorIcon r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = r0.icon;
    L6:
        return r0.copy(r1);
    }

    public final ColorIcon component1() {
        return this.icon;
    }

    public final UnifiedHeaderInfo copy(ColorIcon r2) {
        return new UnifiedHeaderInfo(r2);
    }

    public boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if ((r4 instanceof UnifiedHeaderInfo) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.icon, ((UnifiedHeaderInfo) r4).icon) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        ColorIcon r0 = this.icon;
        if (r0 != null) goto L6;
        return 0;
    L6:
        return r0.hashCode();
    }

    public String toString() {
        return "UnifiedHeaderInfo(icon=" + this.icon + ')';
    }

    public final ColorIcon getIcon() {
        return this.icon;
    }

    public UnifiedHeaderInfo(ColorIcon r1) {
        this.icon = r1;
    }
}
