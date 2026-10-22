package com.ss.android.lark.inline.ai.api.ui;

import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.notification.export.entity.INotificationHitPoint;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0013\u0010\u0013\u001a\u00020\u00062\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0096\u0002J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0003H\u0016J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0006HÆ\u0003J'\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\n\"\u0004\b\u000e\u0010\fR\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u001d"}, d2 = {"Lcom/ss/android/lark/inline/ai/api/ui/ImageData;", "Ljava/io/Serializable;", "url", "", "id", "checkable", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Z)V", "getUrl", "()Ljava/lang/String;", "setUrl", "(Ljava/lang/String;)V", "getId", "setId", "getCheckable", "()Z", "setCheckable", "(Z)V", "equals", INotificationHitPoint.NoticeType.OTHER, "", "hashCode", "", "toString", "component1", "component2", "component3", "copy", "inline-ai-api_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class ImageData implements Serializable {
    private boolean checkable;
    private String id;
    private String url;

    public static /* synthetic */ ImageData copy$default(ImageData r0, String r1, String r2, boolean r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.url;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.id;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.checkable;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public final String component1() {
        return this.url;
    }

    public final String component2() {
        return this.id;
    }

    public final boolean component3() {
        return this.checkable;
    }

    public final ImageData copy(String r2, String r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r2, "url");
        Intrinsics.checkNotNullParameter(r3, "id");
        return new ImageData(r2, r3, r4);
    }

    public int hashCode() {
        return (this.url.hashCode() * 31) + this.id.hashCode();
    }

    public String toString() {
        return "ImageData(url='" + this.url.hashCode() + "', id='" + this.id.hashCode() + "', checkable=" + this.checkable + ')';
    }

    public final boolean getCheckable() {
        return this.checkable;
    }

    public final String getId() {
        return this.id;
    }

    public final String getUrl() {
        return this.url;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof ImageData) == true) goto L8;
        return false;
    L8:
        ImageData r6 = (ImageData) r5;
        if (Intrinsics.areEqual(this.url, r6.url) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.id, r6.id) == true) goto L15;
        return false;
    L15:
        if (this.checkable == r6.checkable) goto L17;
        return false;
    L17:
        return true;
    }

    public final void setCheckable(boolean r1) {
        this.checkable = r1;
    }

    public final void setId(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.id = r2;
    }

    public final void setUrl(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.url = r2;
    }

    public ImageData(String r2, String r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r2, "url");
        Intrinsics.checkNotNullParameter(r3, "id");
        this.url = r2;
        this.id = r3;
        this.checkable = r4;
        this.url = StringsKt.trim(r2).toString();
    }

    public /* synthetic */ ImageData(String r1, String r2, boolean r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 4) == 0) goto L5;
        r3 = true;
    L5:
        this(r1, r2, r3);
    }
}
