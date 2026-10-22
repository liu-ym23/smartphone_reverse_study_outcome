package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.eventkit.eventstaskmanager.ITaskManager;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b%\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002BY\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0002\u0010\u000eJ\u000b\u0010'\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0010\u0010(\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0014J\u0010\u0010)\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0014J\u0010\u0010*\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u0018J\u000b\u0010+\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0010\u0010-\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010\u001dJb\u0010.\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\rHÆ\u0001¢\u0006\u0002\u0010/J\t\u00100\u001a\u00020\rHÖ\u0001J\u0013\u00101\u001a\u00020\t2\b\u00102\u001a\u0004\u0018\u000103HÖ\u0003J\t\u00104\u001a\u00020\rHÖ\u0001J\u0012\u00105\u001a\u00020\u00012\b\u00106\u001a\u0004\u0018\u000103H\u0016J\t\u00107\u001a\u00020\u0004HÖ\u0001J\u0019\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u00020\rHÖ\u0001R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0017\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001e\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001b\u001a\u0004\b\b\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001e\u0010\f\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u0010\n\u0002\u0010 \u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0010\"\u0004\b\"\u0010\u0012R\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0017\u001a\u0004\b#\u0010\u0014\"\u0004\b$\u0010\u0016R\u001c\u0010\n\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0010\"\u0004\b&\u0010\u0012¨\u0006="}, d2 = {"Lcom/obric/capabilitykit/common/intent/NotesSearchParams;", "Lcom/obric/capabilitykit/common/intent/IntentParams;", "Landroid/os/Parcelable;", "query", "", "startTimestamp", "", "endTimestamp", "isFavorite", "", "title", "content", "maxCount", "", "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V", "getContent", "()Ljava/lang/String;", "setContent", "(Ljava/lang/String;)V", "getEndTimestamp", "()Ljava/lang/Long;", "setEndTimestamp", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "()Ljava/lang/Boolean;", "setFavorite", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getMaxCount", "()Ljava/lang/Integer;", "setMaxCount", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getQuery", "setQuery", "getStartTimestamp", "setStartTimestamp", "getTitle", "setTitle", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)Lcom/obric/capabilitykit/common/intent/NotesSearchParams;", "describeContents", "equals", "other", "", "hashCode", "mergeParams", "params", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "intentcommon_release"}, k = 1, mv = {1, 7, 1}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
public final class NotesSearchParams implements IntentParams, Parcelable {
    public static final Parcelable.Creator<NotesSearchParams> CREATOR = null;
    private String content;
    private Long endTimestamp;
    private Boolean isFavorite;
    private Integer maxCount;
    private String query;
    private Long startTimestamp;
    private String title;

    static {
        CREATOR = new a();
    }

    public NotesSearchParams() {
        this(null, null, null, null, null, null, null, 127, null);
    }

    public static /* synthetic */ NotesSearchParams copy$default(NotesSearchParams r5, String r6, Long r7, Long r8, Boolean r9, String r10, String r11, Integer r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L6;
        r6 = r5.query;
    L6:
        if ((r13 & 2) == 0) goto L8;
        r7 = r5.startTimestamp;
    L8:
        Long r15 = r7;
        if ((r13 & 4) == 0) goto L11;
        r8 = r5.endTimestamp;
    L11:
        Long r0 = r8;
        if ((r13 & 8) == 0) goto L14;
        r9 = r5.isFavorite;
    L14:
        Boolean r1 = r9;
        if ((r13 & 16) == 0) goto L17;
        r10 = r5.title;
    L17:
        String r2 = r10;
        if ((r13 & 32) == 0) goto L20;
        r11 = r5.content;
    L20:
        String r3 = r11;
        if ((r13 & 64) == 0) goto L23;
        r12 = r5.maxCount;
    L23:
        String r16 = r6;
        return r5.copy(r16, r15, r0, r1, r2, r3, r12);
    }

    public final String component1() {
        return this.query;
    }

    public final Long component2() {
        return this.startTimestamp;
    }

    public final Long component3() {
        return this.endTimestamp;
    }

    public final Boolean component4() {
        return this.isFavorite;
    }

    public final String component5() {
        return this.title;
    }

    public final String component6() {
        return this.content;
    }

    public final Integer component7() {
        return this.maxCount;
    }

    public final NotesSearchParams copy(String r10, Long r11, Long r12, Boolean r13, String r14, String r15, Integer r16) {
        return new NotesSearchParams(r10, r11, r12, r13, r14, r15, r16);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof NotesSearchParams) == true) goto L8;
        return false;
    L8:
        NotesSearchParams r6 = (NotesSearchParams) r5;
        if (Intrinsics.areEqual(this.query, r6.query) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.startTimestamp, r6.startTimestamp) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.endTimestamp, r6.endTimestamp) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.isFavorite, r6.isFavorite) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.title, r6.title) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.content, r6.content) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.maxCount, r6.maxCount) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public String getSubActionValue() {
        return null;
    }

    public int hashCode() {
        String r0 = this.query;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        Long r4 = this.startTimestamp;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        Long r7 = this.endTimestamp;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        Boolean r10 = this.isFavorite;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        String r13 = this.title;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        String r16 = this.content;
        if (r16 != null) goto L25;
        int r17 = 0;
    L26:
        int r18 = (r15 + r17) * 31;
        Integer r19 = this.maxCount;
        if (r19 == null) goto L31;
        r1 = r19.hashCode();
    L31:
        return r18 + r1;
    L25:
        r17 = r16.hashCode();
        goto L26
    L21:
        r14 = r13.hashCode();
        goto L22
    L17:
        r11 = r10.hashCode();
        goto L18
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

    public boolean isParamsCompleted() {
        return true;
    }

    public String toString() {
        return "NotesSearchParams(query=" + this.query + ", startTimestamp=" + this.startTimestamp + ", endTimestamp=" + this.endTimestamp + ", isFavorite=" + this.isFavorite + ", title=" + this.title + ", content=" + this.content + ", maxCount=" + this.maxCount + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r5, int r6) {
        int r7 = 0;
        r5.writeInt(0);
        Intrinsics.checkNotNullParameter(r5, "out");
        r5.writeString(this.query);
        Long r0 = this.startTimestamp;
        if (r0 != null) goto L5;
        r5.writeInt(0);
    L6:
        Long r1 = this.endTimestamp;
        if (r1 != null) goto L9;
        r5.writeInt(0);
    L10:
        Boolean r2 = this.isFavorite;
        if (r2 != null) goto L13;
        r5.writeInt(0);
    L14:
        r5.writeString(this.title);
        r5.writeString(this.content);
        Integer r3 = this.maxCount;
        if (r3 == null) goto L18;
        r5.writeInt(1);
        r7 = r3.intValue();
    L18:
        r5.writeInt(r7);
        return;
    L13:
        r5.writeInt(1);
        r5.writeInt(r2.booleanValue() ? 1 : 0);
        goto L14
    L9:
        r5.writeInt(1);
        r5.writeLong(r1.longValue());
        goto L10
    L5:
        r5.writeInt(1);
        r5.writeLong(r0.longValue());
        goto L6
    }

    public final String getContent() {
        return this.content;
    }

    public final Long getEndTimestamp() {
        return this.endTimestamp;
    }

    public final Integer getMaxCount() {
        return this.maxCount;
    }

    public final String getQuery() {
        return this.query;
    }

    public final Long getStartTimestamp() {
        return this.startTimestamp;
    }

    public final String getTitle() {
        return this.title;
    }

    public final Boolean isFavorite() {
        return this.isFavorite;
    }

    public IntentParams mergeParams(Object r10) {
        if ((r10 instanceof NotesSearchParams) == true) goto L5;
        return this;
    L5:
        String r0 = this.query;
        if (r0 != null) goto L8;
        r0 = ((NotesSearchParams) r10).query;
    L8:
        String r2 = r0;
        Long r1 = this.startTimestamp;
        if (r1 != null) goto L11;
        r1 = ((NotesSearchParams) r10).startTimestamp;
    L11:
        Long r3 = r1;
        Long r4 = this.endTimestamp;
        if (r4 != null) goto L14;
        r4 = ((NotesSearchParams) r10).endTimestamp;
    L14:
        Long r5 = r4;
        Boolean r6 = this.isFavorite;
        if (r6 != null) goto L17;
        r6 = ((NotesSearchParams) r10).isFavorite;
    L17:
        Boolean r7 = r6;
        String r8 = this.title;
        if (r8 != null) goto L20;
        r8 = ((NotesSearchParams) r10).title;
    L20:
        String r9 = r8;
        String r11 = this.content;
        if (r11 != null) goto L23;
        r11 = ((NotesSearchParams) r10).content;
    L23:
        String r12 = r11;
        Integer r13 = this.maxCount;
        if (r13 != null) goto L26;
        Integer r14 = ((NotesSearchParams) r10).maxCount;
    L28:
        return new NotesSearchParams(r2, r3, r5, r7, r9, r12, r14);
    L26:
        r14 = r13;
        goto L28
    }

    public final void setContent(String r1) {
        this.content = r1;
    }

    public final void setEndTimestamp(Long r1) {
        this.endTimestamp = r1;
    }

    public final void setFavorite(Boolean r1) {
        this.isFavorite = r1;
    }

    public final void setMaxCount(Integer r1) {
        this.maxCount = r1;
    }

    public final void setQuery(String r1) {
        this.query = r1;
    }

    public final void setStartTimestamp(Long r1) {
        this.startTimestamp = r1;
    }

    public final void setTitle(String r1) {
        this.title = r1;
    }

    public NotesSearchParams(String r1, Long r2, Long r3, Boolean r4, String r5, String r6, Integer r7) {
        this.query = r1;
        this.startTimestamp = r2;
        this.endTimestamp = r3;
        this.isFavorite = r4;
        this.title = r5;
        this.content = r6;
        this.maxCount = r7;
    }

    public /* synthetic */ NotesSearchParams(String r7, Long r8, Long r9, Boolean r10, String r11, String r12, Integer r13, int r14, DefaultConstructorMarker r15) {
        if ((r14 & 1) == 0) goto L5;
        String r16 = null;
    L7:
        if ((r14 & 2) == 0) goto L9;
        Long r1 = null;
    L11:
        if ((r14 & 4) == 0) goto L13;
        Long r2 = null;
    L15:
        if ((r14 & 8) == 0) goto L17;
        Boolean r3 = null;
    L19:
        if ((r14 & 16) == 0) goto L21;
        String r4 = null;
    L23:
        if ((r14 & 32) == 0) goto L25;
        String r5 = null;
    L27:
        if ((r14 & 64) == 0) goto L29;
        Integer r17 = null;
    L30:
        this(r16, r1, r2, r3, r4, r5, r17);
        return;
    L29:
        r17 = r13;
        goto L30
    L25:
        r5 = r12;
        goto L27
    L21:
        r4 = r11;
        goto L23
    L17:
        r3 = r10;
        goto L19
    L13:
        r2 = r9;
        goto L15
    L9:
        r1 = r8;
        goto L11
    L5:
        r16 = r7;
        goto L7
    }
}
