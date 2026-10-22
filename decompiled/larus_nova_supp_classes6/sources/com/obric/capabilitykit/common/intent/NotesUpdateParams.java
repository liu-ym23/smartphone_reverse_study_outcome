package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.capabilitykit.common.execution.urishare.IUriSharableParams;
import com.obric.capabilitykit.entity.app.NoteEntity;
import com.obric.eventkit.eventstaskmanager.ITaskManager;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B)\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\tHÆ\u0003J-\u0010\u001a\u001a\u00020\u00002\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 HÖ\u0003J\u0010\u0010!\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010 0\"H\u0016J\t\u0010#\u001a\u00020\u001cHÖ\u0001J\b\u0010$\u001a\u00020\u001eH\u0016J\u0012\u0010%\u001a\u00020\u00012\b\u0010&\u001a\u0004\u0018\u00010 H\u0016J\t\u0010'\u001a\u00020\u0007HÖ\u0001J\u0019\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020\u001cHÖ\u0001R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006-"}, d2 = {"Lcom/obric/capabilitykit/common/intent/NotesUpdateParams;", "Lcom/obric/capabilitykit/common/intent/IntentParams;", "Landroid/os/Parcelable;", "Lcom/obric/capabilitykit/common/execution/urishare/IUriSharableParams;", "target", "Lcom/obric/capabilitykit/entity/app/NoteEntity;", "title", "", "content", "Lcom/obric/capabilitykit/common/intent/NoteContent;", "(Lcom/obric/capabilitykit/entity/app/NoteEntity;Ljava/lang/String;Lcom/obric/capabilitykit/common/intent/NoteContent;)V", "getContent", "()Lcom/obric/capabilitykit/common/intent/NoteContent;", "setContent", "(Lcom/obric/capabilitykit/common/intent/NoteContent;)V", "getTarget", "()Lcom/obric/capabilitykit/entity/app/NoteEntity;", "setTarget", "(Lcom/obric/capabilitykit/entity/app/NoteEntity;)V", "getTitle", "()Ljava/lang/String;", "setTitle", "(Ljava/lang/String;)V", "component1", "component2", "component3", "copy", "describeContents", "", "equals", "", "other", "", "getUriSharableParams", "", "hashCode", "isParamsCompleted", "mergeParams", "params", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "intentcommon_release"}, k = 1, mv = {1, 7, 1}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
public final class NotesUpdateParams implements IntentParams, Parcelable, IUriSharableParams {
    public static final Parcelable.Creator<NotesUpdateParams> CREATOR = null;
    private NoteContent content;
    private NoteEntity target;
    private String title;

    static {
        CREATOR = new a();
    }

    public NotesUpdateParams() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ NotesUpdateParams copy$default(NotesUpdateParams r0, NoteEntity r1, String r2, NoteContent r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.target;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.title;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.content;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public final NoteEntity component1() {
        return this.target;
    }

    public final String component2() {
        return this.title;
    }

    public final NoteContent component3() {
        return this.content;
    }

    public final NotesUpdateParams copy(NoteEntity r2, String r3, NoteContent r4) {
        return new NotesUpdateParams(r2, r3, r4);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof NotesUpdateParams) == true) goto L8;
        return false;
    L8:
        NotesUpdateParams r6 = (NotesUpdateParams) r5;
        if (Intrinsics.areEqual(this.target, r6.target) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.title, r6.title) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.content, r6.content) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public String getSubActionValue() {
        return null;
    }

    @Override // com.obric.capabilitykit.common.execution.urishare.IUriSharableParams
    public List<Object> getUriSharableParams() {
        return CollectionsKt.listOf(new Object[]{this.target, this.content});
    }

    public int hashCode() {
        NoteEntity r0 = this.target;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.title;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        NoteContent r7 = this.content;
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

    public String toString() {
        return "NotesUpdateParams(target=" + this.target + ", title=" + this.title + ", content=" + this.content + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r3, int r4) {
        r3.writeInt(0);
        Intrinsics.checkNotNullParameter(r3, "out");
        r3.writeParcelable(this.target, r4);
        r3.writeString(this.title);
        NoteContent r1 = this.content;
        if (r1 != null) goto L5;
        r3.writeInt(0);
        return;
    L5:
        r3.writeInt(1);
        r1.writeToParcel(r3, r4);
    }

    public boolean isParamsCompleted() {
        if (this.target == null) goto L5;
        return true;
    L5:
        return false;
    }

    public final NoteContent getContent() {
        return this.content;
    }

    public final NoteEntity getTarget() {
        return this.target;
    }

    public final String getTitle() {
        return this.title;
    }

    public IntentParams mergeParams(Object r4) {
        if ((r4 instanceof NotesUpdateParams) == true) goto L5;
        return this;
    L5:
        NoteEntity r0 = this.target;
        if (r0 != null) goto L8;
        r0 = ((NotesUpdateParams) r4).target;
    L8:
        String r1 = this.title;
        if (r1 != null) goto L11;
        r1 = ((NotesUpdateParams) r4).title;
    L11:
        NoteContent r2 = this.content;
        if (r2 != null) goto L15;
        r2 = ((NotesUpdateParams) r4).content;
    L15:
        return new NotesUpdateParams(r0, r1, r2);
    }

    public final void setContent(NoteContent r1) {
        this.content = r1;
    }

    public final void setTarget(NoteEntity r1) {
        this.target = r1;
    }

    public final void setTitle(String r1) {
        this.title = r1;
    }

    public NotesUpdateParams(NoteEntity r1, String r2, NoteContent r3) {
        this.target = r1;
        this.title = r2;
        this.content = r3;
    }

    public /* synthetic */ NotesUpdateParams(NoteEntity r2, String r3, NoteContent r4, int r5, DefaultConstructorMarker r6) {
        if ((r5 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r3 = null;
    L9:
        if ((r5 & 4) == 0) goto L11;
        r4 = null;
    L11:
        this(r2, r3, r4);
    }
}
