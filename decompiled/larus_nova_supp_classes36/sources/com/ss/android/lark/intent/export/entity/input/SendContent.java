package com.ss.android.lark.intent.export.entity.input;

import android.text.TextUtils;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.notification.export.entity.INotificationHitPoint;
import java.io.Serializable;
import knb.a;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002B%\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\b\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0004H\u0016J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\bHÆ\u0003J-\u0010\u0017\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00122\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001R\u0013\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001d"}, d2 = {"Lcom/ss/android/lark/intent/export/entity/input/SendContent;", "Ljava/io/Serializable;", "Lcom/ss/android/lark/intent/export/entity/input/IContentValid;", "textContent", "", "cloudDocumentContent", "Lcom/ss/android/lark/intent/export/entity/input/CloudDocumentContent;", "photoContent", "Lcom/ss/android/lark/intent/export/entity/input/PhotoContent;", "<init>", "(Ljava/lang/String;Lcom/ss/android/lark/intent/export/entity/input/CloudDocumentContent;Lcom/ss/android/lark/intent/export/entity/input/PhotoContent;)V", "getTextContent", "()Ljava/lang/String;", "getCloudDocumentContent", "()Lcom/ss/android/lark/intent/export/entity/input/CloudDocumentContent;", "getPhotoContent", "()Lcom/ss/android/lark/intent/export/entity/input/PhotoContent;", "isValid", "", "toString", "component1", "component2", "component3", "copy", "equals", INotificationHitPoint.NoticeType.OTHER, "", "hashCode", "", "intent-export_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class SendContent implements Serializable, IContentValid {
    private final CloudDocumentContent cloudDocumentContent;
    private final PhotoContent photoContent;
    private final String textContent;

    public static /* synthetic */ SendContent copy$default(SendContent r0, String r1, CloudDocumentContent r2, PhotoContent r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.textContent;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.cloudDocumentContent;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.photoContent;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public final String component1() {
        return this.textContent;
    }

    public final CloudDocumentContent component2() {
        return this.cloudDocumentContent;
    }

    public final PhotoContent component3() {
        return this.photoContent;
    }

    public final SendContent copy(String r2, CloudDocumentContent r3, PhotoContent r4) {
        return new SendContent(r2, r3, r4);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof SendContent) == true) goto L8;
        return false;
    L8:
        SendContent r6 = (SendContent) r5;
        if (Intrinsics.areEqual(this.textContent, r6.textContent) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.cloudDocumentContent, r6.cloudDocumentContent) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.photoContent, r6.photoContent) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        String r0 = this.textContent;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        CloudDocumentContent r4 = this.cloudDocumentContent;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        PhotoContent r7 = this.photoContent;
        if (r7 == null) goto L15;
        r1 = r7.hashCode();
    L15:
        return r6 + r1;
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    @Override // com.ss.android.lark.intent.export.entity.input.IContentValid
    public boolean isValid() {
        if (TextUtils.isEmpty(this.textContent) == false) goto L21;
        CloudDocumentContent r0 = this.cloudDocumentContent;
        if (r0 != null) goto L7;
    L9:
        boolean r1 = false;
    L10:
        if (r1 == true) goto L22;
        PhotoContent r2 = this.photoContent;
        if (r2 != null) goto L14;
    L16:
        boolean r3 = false;
    L17:
        if (r3 == true) goto L23;
        return false;
    L23:
        return true;
    L14:
        if (r2.isValid() != true) goto L16;
        r3 = true;
        goto L17
    L22:
        return true;
    L7:
        if (r0.isValid() != true) goto L9;
        r1 = true;
        goto L10
    L21:
        return true;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder("SendContent(textContent=");
        String r1 = this.textContent;
        Object r2 = "null";
        if (r1 == null) goto L6;
        String r3 = a.a(r1);
        if (r3 == null) goto L6;
    L7:
        r0.append(r3);
        r0.append(", cloudDocumentContent=");
        Object r4 = this.cloudDocumentContent;
        if (r4 != null) goto L11;
        r4 = "null";
    L11:
        r0.append(r4);
        r0.append(", photoContent=");
        PhotoContent r5 = this.photoContent;
        if (r5 == null) goto L14;
        r2 = r5;
    L14:
        r0.append(r2);
        r0.append(')');
        return r0.toString();
    L6:
        r3 = "null";
        goto L7
    }

    public final CloudDocumentContent getCloudDocumentContent() {
        return this.cloudDocumentContent;
    }

    public final PhotoContent getPhotoContent() {
        return this.photoContent;
    }

    public final String getTextContent() {
        return this.textContent;
    }

    public SendContent(String r1, CloudDocumentContent r2, PhotoContent r3) {
        this.textContent = r1;
        this.cloudDocumentContent = r2;
        this.photoContent = r3;
    }
}
