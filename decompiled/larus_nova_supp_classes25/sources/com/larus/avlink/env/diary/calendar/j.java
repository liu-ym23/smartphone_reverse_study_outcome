package com.larus.avlink.env.diary.calendar;

import com.google.gson.annotations.SerializedName;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B7\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\fJ\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\bHÆ\u0003J>\u0010\u0017\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u0010\u0018J\u0013\u0010\u0019\u001a\u00020\u00032\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0005HÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001e"}, d2 = {"Lcom/larus/avlink/env/diary/calendar/DiaryEmotionItem;", "", "hasDiary", "", "diaryId", "", "date", "emotionInfo", "Lcom/larus/avlink/env/diary/model/EmotionInfo;", "<init>", "(Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Lcom/larus/avlink/env/diary/model/EmotionInfo;)V", "getHasDiary", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getDiaryId", "()Ljava/lang/String;", "getDate", "getEmotionInfo", "()Lcom/larus/avlink/env/diary/model/EmotionInfo;", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Lcom/larus/avlink/env/diary/model/EmotionInfo;)Lcom/larus/avlink/env/diary/calendar/DiaryEmotionItem;", "equals", "other", "hashCode", "", "toString", "dora_avlink_impl_release"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class j {

    @SerializedName("date")
    private final String date;

    @SerializedName("diary_id")
    private final String diaryId;

    @SerializedName("emotion_info")
    private final l98.b emotionInfo;

    @SerializedName("has_diary")
    private final Boolean hasDiary;

    public j() {
        this(null, null, null, null);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof j) == true) goto L8;
        return false;
    L8:
        j r6 = (j) r5;
        if (Intrinsics.areEqual(this.hasDiary, r6.hasDiary) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.diaryId, r6.diaryId) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.date, r6.date) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.emotionInfo, r6.emotionInfo) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        Boolean r0 = this.hasDiary;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.diaryId;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.date;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        l98.b r10 = this.emotionInfo;
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

    public final String toString() {
        return "DiaryEmotionItem(hasDiary=" + this.hasDiary + ", diaryId=" + this.diaryId + ", date=" + this.date + ", emotionInfo=" + this.emotionInfo + ')';
    }

    public final String b() {
        return this.date;
    }

    public final String c() {
        return this.diaryId;
    }

    public final l98.b d() {
        return this.emotionInfo;
    }

    public final Boolean e() {
        return this.hasDiary;
    }

    public static j a(j r2, Boolean r3) {
        return new j(r3, null, r2.date, null);
    }

    public j(Boolean r1, String r2, String r3, l98.b r4) {
        this.hasDiary = r1;
        this.diaryId = r2;
        this.date = r3;
        this.emotionInfo = r4;
    }
}
