package com.ss.android.lark.intent.export.entity.output;

import android.os.Parcel;
import android.os.Parcelable;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.intent.export.entity.output.common.CommonSuccessIntentOutput;
import com.ss.android.lark.notification.export.entity.INotificationHitPoint;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0017\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BI\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0010J\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0010J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u000bHÆ\u0003JZ\u0010 \u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000bHÆ\u0001¢\u0006\u0002\u0010!J\u0006\u0010\"\u001a\u00020#J\u0013\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010'HÖ\u0003J\t\u0010(\u001a\u00020#HÖ\u0001J\t\u0010)\u001a\u00020\u000bHÖ\u0001J\u0016\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020#R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u0012\u0010\u0010R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0013\u0010\f\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0018¨\u0006/"}, d2 = {"Lcom/ss/android/lark/intent/export/entity/output/BookCalendarIntentOutput;", "Lcom/ss/android/lark/intent/export/entity/output/common/CommonSuccessIntentOutput;", "startTime", "", "endTime", "roomDetail", "Lcom/ss/android/lark/intent/export/entity/output/CalendarRoomDetail;", "participants", "", "Lcom/ss/android/lark/intent/export/entity/output/CalendarParticipant;", "agoda", "", "display", "<init>", "(Ljava/lang/Long;Ljava/lang/Long;Lcom/ss/android/lark/intent/export/entity/output/CalendarRoomDetail;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;)V", "getStartTime", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getEndTime", "getRoomDetail", "()Lcom/ss/android/lark/intent/export/entity/output/CalendarRoomDetail;", "getParticipants", "()Ljava/util/List;", "getAgoda", "()Ljava/lang/String;", "getDisplay", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/Long;Ljava/lang/Long;Lcom/ss/android/lark/intent/export/entity/output/CalendarRoomDetail;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;)Lcom/ss/android/lark/intent/export/entity/output/BookCalendarIntentOutput;", "describeContents", "", "equals", "", INotificationHitPoint.NoticeType.OTHER, "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "intent-export_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class BookCalendarIntentOutput extends CommonSuccessIntentOutput {
    public static final Parcelable.Creator<BookCalendarIntentOutput> CREATOR = null;
    private final String agoda;
    private final String display;
    private final Long endTime;
    private final List<CalendarParticipant> participants;
    private final CalendarRoomDetail roomDetail;
    private final Long startTime;

    @Metadata(k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
    public static final class Creator implements Parcelable.Creator<BookCalendarIntentOutput> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final BookCalendarIntentOutput createFromParcel(Parcel r10) {
            Intrinsics.checkNotNullParameter(r10, "parcel");
            CalendarRoomDetail r1 = null;
            if (r10.readInt() != 0) goto L5;
            Long r3 = null;
        L7:
            if (r10.readInt() != 0) goto L9;
            Long r4 = null;
        L11:
            if (r10.readInt() == 0) goto L14;
            r1 = CalendarRoomDetail.CREATOR.createFromParcel(r10);
        L14:
            CalendarRoomDetail r5 = r1;
            int r0 = r10.readInt();
            ArrayList r6 = new ArrayList(r0);
            int r2 = 0;
        L15:
            if (r2 == r0) goto L18;
            r6.add(CalendarParticipant.CREATOR.createFromParcel(r10));
            r2 = r2 + 1;
            goto L15
        L18:
            return new BookCalendarIntentOutput(r3, r4, r5, r6, r10.readString(), r10.readString());
        L9:
            r4 = Long.valueOf(r10.readLong());
            goto L11
        L5:
            r3 = Long.valueOf(r10.readLong());
            goto L7
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ BookCalendarIntentOutput createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final BookCalendarIntentOutput[] newArray(int r1) {
            return new BookCalendarIntentOutput[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ BookCalendarIntentOutput[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = new Creator();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ BookCalendarIntentOutput copy$default(BookCalendarIntentOutput r4, Long r5, Long r6, CalendarRoomDetail r7, List r8, String r9, String r10, int r11, Object r12) {
        if ((r11 & 1) == 0) goto L6;
        r5 = r4.startTime;
    L6:
        if ((r11 & 2) == 0) goto L8;
        r6 = r4.endTime;
    L8:
        Long r13 = r6;
        if ((r11 & 4) == 0) goto L11;
        r7 = r4.roomDetail;
    L11:
        CalendarRoomDetail r0 = r7;
        if ((r11 & 8) == 0) goto L14;
        r8 = r4.participants;
    L14:
        List r1 = r8;
        if ((r11 & 16) == 0) goto L17;
        r9 = r4.agoda;
    L17:
        String r2 = r9;
        if ((r11 & 32) == 0) goto L20;
        r10 = r4.display;
    L20:
        Long r14 = r5;
        return r4.copy(r14, r13, r0, r1, r2, r10);
    }

    public final Long component1() {
        return this.startTime;
    }

    public final Long component2() {
        return this.endTime;
    }

    public final CalendarRoomDetail component3() {
        return this.roomDetail;
    }

    public final List<CalendarParticipant> component4() {
        return this.participants;
    }

    public final String component5() {
        return this.agoda;
    }

    public final String component6() {
        return this.display;
    }

    public final BookCalendarIntentOutput copy(Long r9, Long r10, CalendarRoomDetail r11, List<CalendarParticipant> r12, String r13, String r14) {
        Intrinsics.checkNotNullParameter(r12, "participants");
        return new BookCalendarIntentOutput(r9, r10, r11, r12, r13, r14);
    }

    @Override // com.ss.android.lark.intent.export.entity.output.common.CommonSuccessIntentOutput, com.ss.android.lark.intent.export.entity.output.IntentOutput, android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof BookCalendarIntentOutput) == true) goto L8;
        return false;
    L8:
        BookCalendarIntentOutput r6 = (BookCalendarIntentOutput) r5;
        if (Intrinsics.areEqual(this.startTime, r6.startTime) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.endTime, r6.endTime) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.roomDetail, r6.roomDetail) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.participants, r6.participants) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.agoda, r6.agoda) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.display, r6.display) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public int hashCode() {
        Long r0 = this.startTime;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        Long r4 = this.endTime;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        CalendarRoomDetail r7 = this.roomDetail;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (((r6 + r8) * 31) + this.participants.hashCode()) * 31;
        String r10 = this.agoda;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        String r13 = this.display;
        if (r13 == null) goto L23;
        r1 = r13.hashCode();
    L23:
        return r12 + r1;
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

    public String toString() {
        return "BookCalendarIntentOutput(startTime=" + this.startTime + ", endTime=" + this.endTime + ", roomDetail=" + this.roomDetail + ", participants=" + this.participants + ", agoda=" + this.agoda + ", display=" + this.display + ')';
    }

    @Override // com.ss.android.lark.intent.export.entity.output.common.CommonSuccessIntentOutput, com.ss.android.lark.intent.export.entity.output.IntentOutput, android.os.Parcelable
    public final void writeToParcel(Parcel r6, int r7) {
        Intrinsics.checkNotNullParameter(r6, "dest");
        Long r0 = this.startTime;
        if (r0 != null) goto L5;
        r6.writeInt(0);
    L6:
        Long r1 = this.endTime;
        if (r1 != null) goto L9;
        r6.writeInt(0);
    L10:
        CalendarRoomDetail r2 = this.roomDetail;
        if (r2 != null) goto L13;
        r6.writeInt(0);
    L14:
        List<CalendarParticipant> r3 = this.participants;
        r6.writeInt(r3.size());
        Iterator<CalendarParticipant> r4 = r3.iterator();
    L16:
        if (r4.hasNext() == false) goto L18;
        r4.next().writeToParcel(r6, r7);
        goto L16
    L18:
        r6.writeString(this.agoda);
        r6.writeString(this.display);
        return;
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

    public final String getAgoda() {
        return this.agoda;
    }

    public final String getDisplay() {
        return this.display;
    }

    public final Long getEndTime() {
        return this.endTime;
    }

    public final List<CalendarParticipant> getParticipants() {
        return this.participants;
    }

    public final CalendarRoomDetail getRoomDetail() {
        return this.roomDetail;
    }

    public final Long getStartTime() {
        return this.startTime;
    }

    public BookCalendarIntentOutput(Long r2, Long r3, CalendarRoomDetail r4, List<CalendarParticipant> r5, String r6, String r7) {
        Intrinsics.checkNotNullParameter(r5, "participants");
        super(Direction.CALENDER_EDIT, r7);
        this.startTime = r2;
        this.endTime = r3;
        this.roomDetail = r4;
        this.participants = r5;
        this.agoda = r6;
        this.display = r7;
    }

    public /* synthetic */ BookCalendarIntentOutput(Long r8, Long r9, CalendarRoomDetail r10, List r11, String r12, String r13, int r14, DefaultConstructorMarker r15) {
        if ((r14 & 32) == 0) goto L5;
        r13 = null;
    L5:
        this(r8, r9, r10, r11, r12, r13);
    }
}
