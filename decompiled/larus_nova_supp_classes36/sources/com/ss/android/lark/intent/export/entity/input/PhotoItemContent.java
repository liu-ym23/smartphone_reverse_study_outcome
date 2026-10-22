package com.ss.android.lark.intent.export.entity.input;

import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.notification.export.entity.INotificationHitPoint;
import java.io.Serializable;
import knb.a;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002B)\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\b\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0004H\u0016J\t\u0010\u0014\u001a\u00020\u0004HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0007HÆ\u0003J3\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u00122\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bHÖ\u0003J\t\u0010\u001c\u001a\u00020\u0007HÖ\u0001R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000f¨\u0006\u001d"}, d2 = {"Lcom/ss/android/lark/intent/export/entity/input/PhotoItemContent;", "Ljava/io/Serializable;", "Lcom/ss/android/lark/intent/export/entity/input/IContentValid;", "id", "", "url", "width", "", "height", "<init>", "(Ljava/lang/String;Ljava/lang/String;II)V", "getId", "()Ljava/lang/String;", "getUrl", "getWidth", "()I", "getHeight", "isValid", "", "toString", "component1", "component2", "component3", "component4", "copy", "equals", INotificationHitPoint.NoticeType.OTHER, "", "hashCode", "intent-export_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class PhotoItemContent implements Serializable, IContentValid {
    private final int height;
    private final String id;
    private final String url;
    private final int width;

    public static /* synthetic */ PhotoItemContent copy$default(PhotoItemContent r0, String r1, String r2, int r3, int r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.id;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = r0.url;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = r0.width;
    L12:
        if ((r5 & 8) == 0) goto L15;
        r4 = r0.height;
    L15:
        return r0.copy(r1, r2, r3, r4);
    }

    public final String component1() {
        return this.id;
    }

    public final String component2() {
        return this.url;
    }

    public final int component3() {
        return this.width;
    }

    public final int component4() {
        return this.height;
    }

    public final PhotoItemContent copy(String r2, String r3, int r4, int r5) {
        Intrinsics.checkNotNullParameter(r2, "id");
        return new PhotoItemContent(r2, r3, r4, r5);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof PhotoItemContent) == true) goto L8;
        return false;
    L8:
        PhotoItemContent r6 = (PhotoItemContent) r5;
        if (Intrinsics.areEqual(this.id, r6.id) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.url, r6.url) == true) goto L15;
        return false;
    L15:
        if (this.width == r6.width) goto L18;
        return false;
    L18:
        if (this.height == r6.height) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        int r0 = this.id.hashCode() * 31;
        String r1 = this.url;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return ((((r0 + r2) * 31) + this.width) * 31) + this.height;
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    @Override // com.ss.android.lark.intent.export.entity.input.IContentValid
    public boolean isValid() {
        if (this.url == null) goto L5;
        return true;
    L5:
        return false;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder("PhotoItemContent(id='");
        r0.append(this.id);
        r0.append("', url=");
        String r1 = this.url;
        if (r1 == null) goto L6;
        String r2 = a.a(r1);
        if (r2 == null) goto L6;
    L7:
        r0.append(r2);
        r0.append(", width=");
        r0.append(this.width);
        r0.append(", height=");
        r0.append(this.height);
        r0.append(')');
        return r0.toString();
    L6:
        r2 = "null";
        goto L7
    }

    public final int getHeight() {
        return this.height;
    }

    public final String getId() {
        return this.id;
    }

    public final String getUrl() {
        return this.url;
    }

    public final int getWidth() {
        return this.width;
    }

    public PhotoItemContent(String r2, String r3, int r4, int r5) {
        Intrinsics.checkNotNullParameter(r2, "id");
        this.id = r2;
        this.url = r3;
        this.width = r4;
        this.height = r5;
    }
}
