package com.ss.android.lark.inline.ai.api.creationai;

import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.notification.export.entity.INotificationHitPoint;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0013\u001a\u00020\u000e2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0096\u0002J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0005H\u0016R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u0019"}, d2 = {"Lcom/ss/android/lark/inline/ai/api/creationai/ImageData;", "Ljava/io/Serializable;", "<init>", "()V", "url", "", "getUrl", "()Ljava/lang/String;", "setUrl", "(Ljava/lang/String;)V", "id", "getId", "setId", "checkable", "", "getCheckable", "()Z", "setCheckable", "(Z)V", "equals", INotificationHitPoint.NoticeType.OTHER, "", "hashCode", "", "toString", "inline-ai-api_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class ImageData implements Serializable {
    private boolean checkable;
    private String id;
    private String url;

    public int hashCode() {
        String r0 = this.url;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        String r4 = this.id;
        if (r4 == null) goto L10;
        r1 = r4.hashCode();
    L10:
        return r3 + r1;
    L5:
        r2 = 0;
        goto L6
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder("ImageData(url='");
        String r1 = this.url;
        int r2 = 0;
        if (r1 == null) goto L5;
        int r3 = r1.hashCode();
    L6:
        r0.append(r3);
        r0.append("', id='");
        String r4 = this.id;
        if (r4 == null) goto L9;
        r2 = r4.hashCode();
    L9:
        r0.append(r2);
        r0.append("', checkable=");
        r0.append(this.checkable);
        r0.append(')');
        return r0.toString();
    L5:
        r3 = 0;
        goto L6
    }

    public ImageData() {
        this.checkable = true;
        String r0 = this.url;
        if (r0 == null) goto L5;
        String r1 = StringsKt.trim(r0).toString();
    L6:
        this.url = r1;
        return;
    L5:
        r1 = null;
        goto L6
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

    public final void setId(String r1) {
        this.id = r1;
    }

    public final void setUrl(String r1) {
        this.url = r1;
    }
}
