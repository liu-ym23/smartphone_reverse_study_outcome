package com.ss.android.lark.intent.export.entity.input;

import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.notification.export.entity.INotificationHitPoint;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002B\u001f\u0012\u0016\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\u000eH\u0016J\u0019\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006HÆ\u0003J#\u0010\u0010\u001a\u00020\u00002\u0018\b\u0002\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R!\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0016"}, d2 = {"Lcom/ss/android/lark/intent/export/entity/input/PhotoContent;", "Ljava/io/Serializable;", "Lcom/ss/android/lark/intent/export/entity/input/IContentValid;", "photoItems", "Ljava/util/ArrayList;", "Lcom/ss/android/lark/intent/export/entity/input/PhotoItemContent;", "Lkotlin/collections/ArrayList;", "<init>", "(Ljava/util/ArrayList;)V", "getPhotoItems", "()Ljava/util/ArrayList;", "isValid", "", "toString", "", "component1", "copy", "equals", INotificationHitPoint.NoticeType.OTHER, "", "hashCode", "", "intent-export_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class PhotoContent implements Serializable, IContentValid {
    private final ArrayList<PhotoItemContent> photoItems;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PhotoContent copy$default(PhotoContent r0, ArrayList r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = r0.photoItems;
    L6:
        return r0.copy(r1);
    }

    public final ArrayList<PhotoItemContent> component1() {
        return this.photoItems;
    }

    public final PhotoContent copy(ArrayList<PhotoItemContent> r2) {
        Intrinsics.checkNotNullParameter(r2, "photoItems");
        return new PhotoContent(r2);
    }

    public boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if ((r4 instanceof PhotoContent) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.photoItems, ((PhotoContent) r4).photoItems) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        return this.photoItems.hashCode();
    }

    @Override // com.ss.android.lark.intent.export.entity.input.IContentValid
    public boolean isValid() {
        ArrayList<PhotoItemContent> r0 = this.photoItems;
        if ((r0 instanceof Collection) == true) goto L5;
    L7:
        Iterator<T> r1 = r0.iterator();
    L9:
        if (r1.hasNext() == false) goto L18;
        if (((PhotoItemContent) r1.next()).isValid() == false) goto L9;
        return true;
    L18:
        return false;
    L5:
        if (r0.isEmpty() == false) goto L7;
        return false;
    }

    public String toString() {
        return "PhotoContent(photoItems=" + this.photoItems + ')';
    }

    public final ArrayList<PhotoItemContent> getPhotoItems() {
        return this.photoItems;
    }

    public PhotoContent(ArrayList<PhotoItemContent> r2) {
        Intrinsics.checkNotNullParameter(r2, "photoItems");
        this.photoItems = r2;
    }
}
