package com.larus.dora.o.impl.diary;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\bHÆ\u0003J7\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00032\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0005HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001c"}, d2 = {"Lcom/larus/dora/o/impl/diary/ODiaryBriefItem;", "", "hasDiary", "", "diaryId", "", "date", "emotionInfo", "Lcom/larus/dora/o/impl/diary/ODiaryEmotionInfo;", "<init>", "(ZLjava/lang/String;Ljava/lang/String;Lcom/larus/dora/o/impl/diary/ODiaryEmotionInfo;)V", "getHasDiary", "()Z", "getDiaryId", "()Ljava/lang/String;", "getDate", "getEmotionInfo", "()Lcom/larus/dora/o/impl/diary/ODiaryEmotionInfo;", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "dora_o_impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class i {

    @SerializedName("date")
    private final String date;

    @SerializedName("diary_id")
    private final String diaryId;

    @SerializedName("emotion_info")
    private final c0 emotionInfo;

    @SerializedName("has_diary")
    private final boolean hasDiary;

    public i() {
        this(false, null, null, null);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof i) == true) goto L8;
        return false;
    L8:
        i r6 = (i) r5;
        if (this.hasDiary == r6.hasDiary) goto L12;
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
        if (this.hasDiary == false) goto L5;
        int r0 = 1231;
    L6:
        int r1 = r0 * 31;
        String r2 = this.diaryId;
        int r3 = 0;
        if (r2 != null) goto L9;
        int r4 = 0;
    L10:
        int r5 = (r1 + r4) * 31;
        String r6 = this.date;
        if (r6 != null) goto L13;
        int r7 = 0;
    L14:
        int r8 = (r5 + r7) * 31;
        c0 r9 = this.emotionInfo;
        if (r9 == null) goto L19;
        r3 = r9.hashCode();
    L19:
        return r8 + r3;
    L13:
        r7 = r6.hashCode();
        goto L14
    L9:
        r4 = r2.hashCode();
        goto L10
    L5:
        r0 = 1237;
        goto L6
    }

    public final String toString() {
        return "ODiaryBriefItem(hasDiary=" + this.hasDiary + ", diaryId=" + this.diaryId + ", date=" + this.date + ", emotionInfo=" + this.emotionInfo + ')';
    }

    public final String b() {
        return this.date;
    }

    public final String c() {
        return this.diaryId;
    }

    public final c0 d() {
        return this.emotionInfo;
    }

    public final boolean e() {
        return this.hasDiary;
    }

    public static i a(i r3) {
        return new i(false, null, r3.date, null);
    }

    public i(boolean r1, String r2, String r3, c0 r4) {
        this.hasDiary = r1;
        this.diaryId = r2;
        this.date = r3;
        this.emotionInfo = r4;
    }
}
