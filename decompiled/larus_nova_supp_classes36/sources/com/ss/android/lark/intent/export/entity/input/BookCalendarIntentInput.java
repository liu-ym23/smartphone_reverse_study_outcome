package com.ss.android.lark.intent.export.entity.input;

import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.notification.export.entity.INotificationHitPoint;
import java.io.Serializable;
import java.util.ArrayList;
import knb.a;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002Bo\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u001a\u0010\b\u001a\u0016\u0012\u0004\u0012\u00020\u0007\u0018\u00010\tj\n\u0012\u0004\u0012\u00020\u0007\u0018\u0001`\n\u0012\u001a\u0010\u000b\u001a\u0016\u0012\u0004\u0012\u00020\u0007\u0018\u00010\tj\n\u0012\u0004\u0012\u00020\u0007\u0018\u0001`\n\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\r\u001a\u00020\u000e¢\u0006\u0004\b\u000f\u0010\u0010J\b\u0010\u001d\u001a\u00020\u0007H\u0016J\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0002\u0010\u0012J\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0002\u0010\u0012J\u000b\u0010 \u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u001d\u0010!\u001a\u0016\u0012\u0004\u0012\u00020\u0007\u0018\u00010\tj\n\u0012\u0004\u0012\u00020\u0007\u0018\u0001`\nHÆ\u0003J\u001d\u0010\"\u001a\u0016\u0012\u0004\u0012\u00020\u0007\u0018\u00010\tj\n\u0012\u0004\u0012\u00020\u0007\u0018\u0001`\nHÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\t\u0010$\u001a\u00020\u000eHÆ\u0003J\u0084\u0001\u0010%\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u001c\b\u0002\u0010\b\u001a\u0016\u0012\u0004\u0012\u00020\u0007\u0018\u00010\tj\n\u0012\u0004\u0012\u00020\u0007\u0018\u0001`\n2\u001c\b\u0002\u0010\u000b\u001a\u0016\u0012\u0004\u0012\u00020\u0007\u0018\u00010\tj\n\u0012\u0004\u0012\u00020\u0007\u0018\u0001`\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\r\u001a\u00020\u000eHÆ\u0001¢\u0006\u0002\u0010&J\u0013\u0010'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010*HÖ\u0003J\t\u0010+\u001a\u00020,HÖ\u0001R\u0015\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0011\u0010\u0012R\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0014\u0010\u0012R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R%\u0010\b\u001a\u0016\u0012\u0004\u0012\u00020\u0007\u0018\u00010\tj\n\u0012\u0004\u0012\u00020\u0007\u0018\u0001`\n¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R%\u0010\u000b\u001a\u0016\u0012\u0004\u0012\u00020\u0007\u0018\u00010\tj\n\u0012\u0004\u0012\u00020\u0007\u0018\u0001`\n¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0018R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0016R\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001c¨\u0006-"}, d2 = {"Lcom/ss/android/lark/intent/export/entity/input/BookCalendarIntentInput;", "Lcom/ss/android/lark/intent/export/entity/input/IntentInput;", "Ljava/io/Serializable;", "startTime", "", "endTime", "roomDesc", "", "participants", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "participantIds", "agenda", "version", "Lcom/ss/android/lark/intent/export/entity/input/IntentInputVersion;", "<init>", "(Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/util/ArrayList;Ljava/util/ArrayList;Ljava/lang/String;Lcom/ss/android/lark/intent/export/entity/input/IntentInputVersion;)V", "getStartTime", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getEndTime", "getRoomDesc", "()Ljava/lang/String;", "getParticipants", "()Ljava/util/ArrayList;", "getParticipantIds", "getAgenda", "getVersion", "()Lcom/ss/android/lark/intent/export/entity/input/IntentInputVersion;", "toString", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/util/ArrayList;Ljava/util/ArrayList;Ljava/lang/String;Lcom/ss/android/lark/intent/export/entity/input/IntentInputVersion;)Lcom/ss/android/lark/intent/export/entity/input/BookCalendarIntentInput;", "equals", "", INotificationHitPoint.NoticeType.OTHER, "", "hashCode", "", "intent-export_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class BookCalendarIntentInput extends IntentInput implements Serializable {
    private final String agenda;
    private final Long endTime;
    private final ArrayList<String> participantIds;
    private final ArrayList<String> participants;
    private final String roomDesc;
    private final Long startTime;
    private final IntentInputVersion version;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ BookCalendarIntentInput copy$default(BookCalendarIntentInput r5, Long r6, Long r7, String r8, ArrayList r9, ArrayList r10, String r11, IntentInputVersion r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L6;
        r6 = r5.startTime;
    L6:
        if ((r13 & 2) == 0) goto L8;
        r7 = r5.endTime;
    L8:
        Long r15 = r7;
        if ((r13 & 4) == 0) goto L11;
        r8 = r5.roomDesc;
    L11:
        String r0 = r8;
        if ((r13 & 8) == 0) goto L14;
        r9 = r5.participants;
    L14:
        ArrayList r1 = r9;
        if ((r13 & 16) == 0) goto L17;
        r10 = r5.participantIds;
    L17:
        ArrayList r2 = r10;
        if ((r13 & 32) == 0) goto L20;
        r11 = r5.agenda;
    L20:
        String r3 = r11;
        if ((r13 & 64) == 0) goto L23;
        r12 = r5.version;
    L23:
        Long r16 = r6;
        return r5.copy(r16, r15, r0, r1, r2, r3, r12);
    }

    public final Long component1() {
        return this.startTime;
    }

    public final Long component2() {
        return this.endTime;
    }

    public final String component3() {
        return this.roomDesc;
    }

    public final ArrayList<String> component4() {
        return this.participants;
    }

    public final ArrayList<String> component5() {
        return this.participantIds;
    }

    public final String component6() {
        return this.agenda;
    }

    public final IntentInputVersion component7() {
        return this.version;
    }

    public final BookCalendarIntentInput copy(Long r10, Long r11, String r12, ArrayList<String> r13, ArrayList<String> r14, String r15, IntentInputVersion r16) {
        Intrinsics.checkNotNullParameter(r16, "version");
        return new BookCalendarIntentInput(r10, r11, r12, r13, r14, r15, r16);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof BookCalendarIntentInput) == true) goto L8;
        return false;
    L8:
        BookCalendarIntentInput r6 = (BookCalendarIntentInput) r5;
        if (Intrinsics.areEqual(this.startTime, r6.startTime) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.endTime, r6.endTime) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.roomDesc, r6.roomDesc) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.participants, r6.participants) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.participantIds, r6.participantIds) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.agenda, r6.agenda) == true) goto L27;
        return false;
    L27:
        if (this.version == r6.version) goto L29;
        return false;
    L29:
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
        String r7 = this.roomDesc;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        ArrayList<String> r10 = this.participants;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        ArrayList<String> r13 = this.participantIds;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        String r16 = this.agenda;
        if (r16 == null) goto L27;
        r1 = r16.hashCode();
    L27:
        return ((r15 + r1) * 31) + this.version.hashCode();
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

    public String toString() {
        StringBuilder r0 = new StringBuilder("BookCalendarIntentInput(startTime=");
        Object r1 = this.startTime;
        String r2 = "null";
        if (r1 != null) goto L5;
        r1 = "null";
    L5:
        r0.append(r1);
        r0.append(", endTime=");
        Object r3 = this.endTime;
        if (r3 != null) goto L8;
        r3 = "null";
    L8:
        r0.append(r3);
        r0.append(", roomDesc=");
        String r4 = this.roomDesc;
        if (r4 == null) goto L12;
        String r5 = a.a(r4);
        if (r5 == null) goto L12;
    L13:
        r0.append(r5);
        r0.append(", participants=");
        Object r6 = this.participants;
        if (r6 != null) goto L17;
        r6 = "null";
    L17:
        r0.append(r6);
        r0.append(", participantIds=");
        Object r7 = this.participantIds;
        if (r7 != null) goto L21;
        r7 = "null";
    L21:
        r0.append(r7);
        r0.append(", agenda=");
        String r8 = this.agenda;
        if (r8 == null) goto L27;
        String r9 = a.a(r8);
        if (r9 == null) goto L27;
        r2 = r9;
    L27:
        r0.append(r2);
        r0.append(", version=");
        r0.append(this.version);
        r0.append(')');
        return r0.toString();
    L12:
        r5 = "null";
        goto L13
    }

    public final String getAgenda() {
        return this.agenda;
    }

    public final Long getEndTime() {
        return this.endTime;
    }

    public final ArrayList<String> getParticipantIds() {
        return this.participantIds;
    }

    public final ArrayList<String> getParticipants() {
        return this.participants;
    }

    public final String getRoomDesc() {
        return this.roomDesc;
    }

    public final Long getStartTime() {
        return this.startTime;
    }

    public final IntentInputVersion getVersion() {
        return this.version;
    }

    public BookCalendarIntentInput(Long r2, Long r3, String r4, ArrayList<String> r5, ArrayList<String> r6, String r7, IntentInputVersion r8) {
        Intrinsics.checkNotNullParameter(r8, "version");
        super(IntentInput.IntentType.BOOKING_CALENDAR);
        this.startTime = r2;
        this.endTime = r3;
        this.roomDesc = r4;
        this.participants = r5;
        this.participantIds = r6;
        this.agenda = r7;
        this.version = r8;
    }
}
