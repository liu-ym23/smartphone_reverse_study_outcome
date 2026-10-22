package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.capabilitykit.common.execution.urishare.IUriSharerEntity;
import com.obric.capabilitykit.common.execution.urishare.IUriSharerEntityCollection;
import com.obric.capabilitykit.entity.app.CloudDocumentEntity;
import com.obric.capabilitykit.entity.app.PhotoEntity;
import com.obric.eventkit.eventstaskmanager.ITaskManager;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B)\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0016\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u000b\u0010\u0014\u001a\u0004\u0018\u00010\tHÆ\u0003J8\u0010\u0015\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001¢\u0006\u0002\u0010\u0016J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0003J\u0010\u0010\u001d\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001f0\u001eH\u0016J\t\u0010 \u001a\u00020\u0018HÖ\u0001J\t\u0010!\u001a\u00020\u0004HÖ\u0001J\u0019\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u0018HÖ\u0001R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001b\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006'"}, d2 = {"Lcom/obric/capabilitykit/common/intent/OfficeMessageContent;", "Landroid/os/Parcelable;", "Lcom/obric/capabilitykit/common/execution/urishare/IUriSharerEntityCollection;", "text", "", "photos", "", "Lcom/obric/capabilitykit/entity/app/PhotoEntity;", "doc", "Lcom/obric/capabilitykit/entity/app/CloudDocumentEntity;", "(Ljava/lang/String;[Lcom/obric/capabilitykit/entity/app/PhotoEntity;Lcom/obric/capabilitykit/entity/app/CloudDocumentEntity;)V", "getDoc", "()Lcom/obric/capabilitykit/entity/app/CloudDocumentEntity;", "getPhotos", "()[Lcom/obric/capabilitykit/entity/app/PhotoEntity;", "[Lcom/obric/capabilitykit/entity/app/PhotoEntity;", "getText", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "(Ljava/lang/String;[Lcom/obric/capabilitykit/entity/app/PhotoEntity;Lcom/obric/capabilitykit/entity/app/CloudDocumentEntity;)Lcom/obric/capabilitykit/common/intent/OfficeMessageContent;", "describeContents", "", "equals", "", "other", "", "getUriSharersEntities", "", "Lcom/obric/capabilitykit/common/execution/urishare/IUriSharerEntity;", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "intentcommon_release"}, k = 1, mv = {1, 7, 1}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
public final class OfficeMessageContent implements Parcelable, IUriSharerEntityCollection {
    public static final Parcelable.Creator<OfficeMessageContent> CREATOR = null;
    private final CloudDocumentEntity doc;
    private final PhotoEntity[] photos;
    private final String text;

    static {
        CREATOR = new a();
    }

    public static /* synthetic */ OfficeMessageContent copy$default(OfficeMessageContent r0, String r1, PhotoEntity[] r2, CloudDocumentEntity r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.text;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.photos;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.doc;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public final String component1() {
        return this.text;
    }

    public final PhotoEntity[] component2() {
        return this.photos;
    }

    public final CloudDocumentEntity component3() {
        return this.doc;
    }

    public final OfficeMessageContent copy(String r2, PhotoEntity[] r3, CloudDocumentEntity r4) {
        return new OfficeMessageContent(r2, r3, r4);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof OfficeMessageContent) == true) goto L8;
        return false;
    L8:
        OfficeMessageContent r6 = (OfficeMessageContent) r5;
        if (Intrinsics.areEqual(this.text, r6.text) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.photos, r6.photos) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.doc, r6.doc) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        String r0 = this.text;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        PhotoEntity[] r4 = this.photos;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        CloudDocumentEntity r7 = this.doc;
        if (r7 == null) goto L15;
        r1 = r7.hashCode();
    L15:
        return r6 + r1;
    L9:
        r5 = Arrays.hashCode(r4);
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "OfficeMessageContent(text=" + this.text + ", photos=" + Arrays.toString(this.photos) + ", doc=" + this.doc + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r5, int r6) {
        int r0 = 0;
        r5.writeInt(0);
        Intrinsics.checkNotNullParameter(r5, "out");
        r5.writeString(this.text);
        PhotoEntity[] r1 = this.photos;
        if (r1 != null) goto L5;
        r5.writeInt(0);
    L8:
        r5.writeParcelable(this.doc, r6);
        return;
    L5:
        r5.writeInt(1);
        int r2 = r1.length;
        r5.writeInt(r2);
    L6:
        if (r0 == r2) goto L8;
        r5.writeParcelable(r1[r0], r6);
        r0 = r0 + 1;
        goto L6
    }

    @Override // com.obric.capabilitykit.common.execution.urishare.IUriSharerEntityCollection
    public List<IUriSharerEntity> getUriSharersEntities() {
        PhotoEntity[] r0 = this.photos;
        if (r0 == null) goto L7;
        List<IUriSharerEntity> r1 = ArraysKt.toList(r0);
        if (r1 == null) goto L7;
        return r1;
    L7:
        return CollectionsKt.emptyList();
    }

    public final CloudDocumentEntity getDoc() {
        return this.doc;
    }

    public final PhotoEntity[] getPhotos() {
        return this.photos;
    }

    public final String getText() {
        return this.text;
    }

    public OfficeMessageContent(String r1, PhotoEntity[] r2, CloudDocumentEntity r3) {
        this.text = r1;
        this.photos = r2;
        this.doc = r3;
    }
}
