package com.larksuite.component.card.component.text;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/larksuite/component/card/component/text/ImageClickExtra;", "Ljava/io/Serializable;", "imageId", "", "<init>", "(Ljava/lang/String;)V", "getImageId", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "universalcard_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class ImageClickExtra implements Serializable {
    private final String imageId;

    public static /* synthetic */ ImageClickExtra copy$default(ImageClickExtra r0, String r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = r0.imageId;
    L6:
        return r0.copy(r1);
    }

    public final String component1() {
        return this.imageId;
    }

    public final ImageClickExtra copy(String r2) {
        Intrinsics.checkNotNullParameter(r2, "imageId");
        return new ImageClickExtra(r2);
    }

    public boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if ((r4 instanceof ImageClickExtra) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.imageId, ((ImageClickExtra) r4).imageId) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        return this.imageId.hashCode();
    }

    public String toString() {
        return "ImageClickExtra(imageId=" + this.imageId + ')';
    }

    public final String getImageId() {
        return this.imageId;
    }

    public ImageClickExtra(String r2) {
        Intrinsics.checkNotNullParameter(r2, "imageId");
        this.imageId = r2;
    }
}
