package com.larus.bmhome.chat.resp;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Deprecated(message = "old link data")
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b)\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u0000 @2\u00020\u00012\u00020\u0002:\u0001@BY\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e¢\u0006\u0004\b\u000f\u0010\u0010J\b\u0010*\u001a\u00020\u0007H\u0016J\b\u0010+\u001a\u00020\u0007H\u0016J\u0010\u0010,\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0002\u0010\u0012J\u0010\u0010-\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0002\u0010\u0012J\u000b\u0010.\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0010\u00101\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010\"J\t\u00102\u001a\u00020\u000eHÆ\u0003J`\u00103\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\r\u001a\u00020\u000eHÆ\u0001¢\u0006\u0002\u00104J\u0006\u00105\u001a\u00020\u000eJ\u0013\u00106\u001a\u00020\f2\b\u00107\u001a\u0004\u0018\u000108HÖ\u0003J\t\u00109\u001a\u00020\u000eHÖ\u0001J\t\u0010:\u001a\u00020\u0007HÖ\u0001J\u0016\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020\u000eR\"\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0015\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\"\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0015\u001a\u0004\b\u0016\u0010\u0012\"\u0004\b\u0017\u0010\u0014R \u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR \u0010\b\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR \u0010\n\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0019\"\u0004\b!\u0010\u001bR\"\u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010%\u001a\u0004\b\u000b\u0010\"\"\u0004\b#\u0010$R\u001e\u0010\r\u001a\u00020\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)¨\u0006A"}, d2 = {"Lcom/larus/bmhome/chat/resp/Templates;", "Landroid/os/Parcelable;", "Lcom/larus/im/bean/conversation/ActionbarBaseData;", "id", "", "botId", "templateName", "", "botStats", "Lcom/larus/bmhome/chat/resp/BotStatus;", "requestId", "isForcedSort", "", "forcedSortIndex", "", "<init>", "(Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Lcom/larus/bmhome/chat/resp/BotStatus;Ljava/lang/String;Ljava/lang/Boolean;I)V", "getId", "()Ljava/lang/Long;", "setId", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getBotId", "setBotId", "getTemplateName", "()Ljava/lang/String;", "setTemplateName", "(Ljava/lang/String;)V", "getBotStats", "()Lcom/larus/bmhome/chat/resp/BotStatus;", "setBotStats", "(Lcom/larus/bmhome/chat/resp/BotStatus;)V", "getRequestId", "setRequestId", "()Ljava/lang/Boolean;", "setForcedSort", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getForcedSortIndex", "()I", "setForcedSortIndex", "(I)V", "uniqueIdInType", "getContentFlag", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Lcom/larus/bmhome/chat/resp/BotStatus;Ljava/lang/String;Ljava/lang/Boolean;I)Lcom/larus/bmhome/chat/resp/Templates;", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "Companion", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class Templates implements Parcelable {
    public static final Parcelable.Creator<Templates> CREATOR = null;

    @SerializedName("bot_id")
    private Long botId;

    @SerializedName("bot_stats")
    private BotStatus botStats;

    @SerializedName("forced_sort_index")
    private int forcedSortIndex;

    @SerializedName("id")
    private Long id;

    @SerializedName("forced_sort")
    private Boolean isForcedSort;

    @SerializedName("request_id")
    private String requestId;

    @SerializedName("msg_template_name")
    private String templateName;

    public static final class a {
    }

    public static final class b implements Parcelable.Creator<Templates> {
        public b() {
        }

        @Override // android.os.Parcelable.Creator
        public final Templates createFromParcel(Parcel r10) {
            Intrinsics.checkNotNullParameter(r10, "parcel");
            if (r10.readInt() != 0) goto L5;
            Long r3 = null;
        L7:
            if (r10.readInt() != 0) goto L9;
            Long r4 = null;
        L10:
            String r5 = r10.readString();
            if (r10.readInt() != 0) goto L13;
            BotStatus r1 = null;
        L14:
            BotStatus r6 = r1;
            String r7 = r10.readString();
            if (r10.readInt() != 0) goto L18;
            Boolean r8 = null;
        L23:
            return new Templates(r3, r4, r5, r6, r7, r8, r10.readInt());
        L18:
            if (r10.readInt() == 0) goto L20;
            boolean r2 = true;
        L21:
            r8 = Boolean.valueOf(r2);
            goto L23
        L20:
            r2 = false;
            goto L21
        L13:
            r1 = BotStatus.CREATOR.createFromParcel(r10);
            goto L14
        L9:
            r4 = Long.valueOf(r10.readLong());
            goto L10
        L5:
            r3 = Long.valueOf(r10.readLong());
            goto L7
        }

        @Override // android.os.Parcelable.Creator
        public final Templates[] newArray(int r1) {
            return new Templates[r1];
        }
    }

    static {
        CREATOR = new b();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof Templates) == true) goto L8;
        return false;
    L8:
        Templates r6 = (Templates) r5;
        if (Intrinsics.areEqual(this.id, r6.id) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.botId, r6.botId) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.templateName, r6.templateName) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.botStats, r6.botStats) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.requestId, r6.requestId) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.isForcedSort, r6.isForcedSort) == true) goto L27;
        return false;
    L27:
        if (this.forcedSortIndex == r6.forcedSortIndex) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        Long r0 = this.id;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        Long r4 = this.botId;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.templateName;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        BotStatus r10 = this.botStats;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        String r13 = this.requestId;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        Boolean r16 = this.isForcedSort;
        if (r16 == null) goto L27;
        r1 = r16.hashCode();
    L27:
        return ((r15 + r1) * 31) + this.forcedSortIndex;
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

    public final String toString() {
        return "Templates(id=" + this.id + ", botId=" + this.botId + ", templateName=" + this.templateName + ", botStats=" + this.botStats + ", requestId=" + this.requestId + ", isForcedSort=" + this.isForcedSort + ", forcedSortIndex=" + this.forcedSortIndex + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r6, int r7) {
        Intrinsics.checkNotNullParameter(r6, "dest");
        Long r0 = this.id;
        if (r0 != null) goto L5;
        r6.writeInt(0);
    L6:
        Long r1 = this.botId;
        if (r1 != null) goto L9;
        r6.writeInt(0);
    L10:
        r6.writeString(this.templateName);
        BotStatus r2 = this.botStats;
        if (r2 != null) goto L13;
        r6.writeInt(0);
    L14:
        r6.writeString(this.requestId);
        Boolean r8 = this.isForcedSort;
        if (r8 != null) goto L17;
        r6.writeInt(0);
    L18:
        r6.writeInt(this.forcedSortIndex);
        return;
    L17:
        r6.writeInt(1);
        r6.writeInt(r8.booleanValue() ? 1 : 0);
        goto L18
    L13:
        r6.writeInt(1);
        r2.writeToParcel(r6, r7);
        goto L14
    L9:
        r6.writeInt(1);
        r6.writeLong(r1.longValue());
        goto L10
    L5:
        r6.writeInt(1);
        r6.writeLong(r0.longValue());
        goto L6
    }

    public Templates() {
        this(0L, 0L, "", null, null, Boolean.FALSE, 0);
    }

    public Templates(Long r1, Long r2, String r3, BotStatus r4, String r5, Boolean r6, int r7) {
        this.id = r1;
        this.botId = r2;
        this.templateName = r3;
        this.botStats = r4;
        this.requestId = r5;
        this.isForcedSort = r6;
        this.forcedSortIndex = r7;
    }
}
