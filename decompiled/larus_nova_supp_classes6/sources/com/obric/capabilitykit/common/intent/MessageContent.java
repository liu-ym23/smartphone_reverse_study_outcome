package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.capabilitykit.common.execution.urishare.IUriSharerEntity;
import com.obric.capabilitykit.common.execution.urishare.IUriSharerEntityCollection;
import com.obric.capabilitykit.entity.app.ContactEntity;
import com.obric.capabilitykit.entity.app.NoteEntity;
import com.obric.capabilitykit.entity.app.PhotoEntity;
import com.obric.eventkit.eventstaskmanager.ITaskManager;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B-\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bJ\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\nHÆ\u0003J9\u0010\u0018\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nHÆ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eHÖ\u0003J\u0010\u0010\u001f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010!0 H\u0016J\t\u0010\"\u001a\u00020\u001aHÖ\u0001J\t\u0010#\u001a\u00020\u0004HÖ\u0001J\u0019\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\u001aHÖ\u0001R\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006)"}, d2 = {"Lcom/obric/capabilitykit/common/intent/MessageContent;", "Landroid/os/Parcelable;", "Lcom/obric/capabilitykit/common/execution/urishare/IUriSharerEntityCollection;", "text", "", "photo", "Lcom/obric/capabilitykit/entity/app/PhotoEntity;", "note", "Lcom/obric/capabilitykit/entity/app/NoteEntity;", "contact", "Lcom/obric/capabilitykit/entity/app/ContactEntity;", "(Ljava/lang/String;Lcom/obric/capabilitykit/entity/app/PhotoEntity;Lcom/obric/capabilitykit/entity/app/NoteEntity;Lcom/obric/capabilitykit/entity/app/ContactEntity;)V", "getContact", "()Lcom/obric/capabilitykit/entity/app/ContactEntity;", "getNote", "()Lcom/obric/capabilitykit/entity/app/NoteEntity;", "getPhoto", "()Lcom/obric/capabilitykit/entity/app/PhotoEntity;", "getText", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "copy", "describeContents", "", "equals", "", "other", "", "getUriSharersEntities", "", "Lcom/obric/capabilitykit/common/execution/urishare/IUriSharerEntity;", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "intentcommon_release"}, k = 1, mv = {1, 7, 1}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
public final class MessageContent implements Parcelable, IUriSharerEntityCollection {
    public static final Parcelable.Creator<MessageContent> CREATOR = null;
    private final ContactEntity contact;
    private final NoteEntity note;
    private final PhotoEntity photo;
    private final String text;

    static {
        CREATOR = new a();
    }

    public static /* synthetic */ MessageContent copy$default(MessageContent r0, String r1, PhotoEntity r2, NoteEntity r3, ContactEntity r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.text;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = r0.photo;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = r0.note;
    L12:
        if ((r5 & 8) == 0) goto L15;
        r4 = r0.contact;
    L15:
        return r0.copy(r1, r2, r3, r4);
    }

    public final String component1() {
        return this.text;
    }

    public final PhotoEntity component2() {
        return this.photo;
    }

    public final NoteEntity component3() {
        return this.note;
    }

    public final ContactEntity component4() {
        return this.contact;
    }

    public final MessageContent copy(String r2, PhotoEntity r3, NoteEntity r4, ContactEntity r5) {
        return new MessageContent(r2, r3, r4, r5);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof MessageContent) == true) goto L8;
        return false;
    L8:
        MessageContent r6 = (MessageContent) r5;
        if (Intrinsics.areEqual(this.text, r6.text) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.photo, r6.photo) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.note, r6.note) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.contact, r6.contact) == true) goto L20;
        return false;
    L20:
        return true;
    }

    @Override // com.obric.capabilitykit.common.execution.urishare.IUriSharerEntityCollection
    public List<IUriSharerEntity> getUriSharersEntities() {
        return CollectionsKt.listOf(new IUriSharerEntity[]{this.photo, this.note, this.contact});
    }

    public int hashCode() {
        String r0 = this.text;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        PhotoEntity r4 = this.photo;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        NoteEntity r7 = this.note;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        ContactEntity r10 = this.contact;
        if (r10 == null) goto L19;
        r1 = r10.hashCode();
    L19:
        return r9 + r1;
    L13:
        r8 = r7.hashCode();
        goto L14
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "MessageContent(text=" + this.text + ", photo=" + this.photo + ", note=" + this.note + ", contact=" + this.contact + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r2, int r3) {
        r2.writeInt(0);
        Intrinsics.checkNotNullParameter(r2, "out");
        r2.writeString(this.text);
        r2.writeParcelable(this.photo, r3);
        r2.writeParcelable(this.note, r3);
        r2.writeParcelable(this.contact, r3);
    }

    public final ContactEntity getContact() {
        return this.contact;
    }

    public final NoteEntity getNote() {
        return this.note;
    }

    public final PhotoEntity getPhoto() {
        return this.photo;
    }

    public final String getText() {
        return this.text;
    }

    public MessageContent(String r1, PhotoEntity r2, NoteEntity r3, ContactEntity r4) {
        this.text = r1;
        this.photo = r2;
        this.note = r3;
        this.contact = r4;
    }
}
