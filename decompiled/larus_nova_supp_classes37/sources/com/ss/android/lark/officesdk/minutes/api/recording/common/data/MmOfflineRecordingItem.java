package com.ss.android.lark.officesdk.minutes.api.recording.common.data;

import com.ss.android.lark.picker.base.view.ItemViewType;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0007HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\tHÆ\u0003J3\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00072\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0010R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001e"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/api/recording/common/data/MmOfflineRecordingItem;", "Ljava/io/Serializable;", "recordingId", "", "startTimeMs", "", "isRecording", "", "source", "Lcom/ss/android/lark/officesdk/minutes/api/recording/common/data/MmRecordingSource;", "<init>", "(Ljava/lang/String;JZLcom/ss/android/lark/officesdk/minutes/api/recording/common/data/MmRecordingSource;)V", "getRecordingId", "()Ljava/lang/String;", "getStartTimeMs", "()J", "()Z", "getSource", "()Lcom/ss/android/lark/officesdk/minutes/api/recording/common/data/MmRecordingSource;", "component1", "component2", "component3", "component4", "copy", "equals", "other", "", "hashCode", "", "toString", "officesdk-minutes-api_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class MmOfflineRecordingItem implements Serializable {
    private final boolean isRecording;
    private final String recordingId;
    private final MmRecordingSource source;
    private final long startTimeMs;

    public static /* synthetic */ MmOfflineRecordingItem copy$default(MmOfflineRecordingItem r3, String r4, long r5, boolean r7, MmRecordingSource r8, int r9, Object r10) {
        if ((r9 & 1) == 0) goto L6;
        r4 = r3.recordingId;
    L6:
        if ((r9 & 2) == 0) goto L8;
        r5 = r3.startTimeMs;
    L8:
        long r0 = r5;
        if ((r9 & 4) == 0) goto L11;
        r7 = r3.isRecording;
    L11:
        boolean r11 = r7;
        if ((r9 & 8) == 0) goto L14;
        r8 = r3.source;
    L14:
        String r6 = r4;
        return r3.copy(r6, r0, r11, r8);
    }

    public final String component1() {
        return this.recordingId;
    }

    public final long component2() {
        return this.startTimeMs;
    }

    public final boolean component3() {
        return this.isRecording;
    }

    public final MmRecordingSource component4() {
        return this.source;
    }

    public final MmOfflineRecordingItem copy(String r8, long r9, boolean r11, MmRecordingSource r12) {
        Intrinsics.checkNotNullParameter(r8, "recordingId");
        return new MmOfflineRecordingItem(r8, r9, r11, r12);
    }

    public boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof MmOfflineRecordingItem) == true) goto L8;
        return false;
    L8:
        MmOfflineRecordingItem r9 = (MmOfflineRecordingItem) r8;
        if (Intrinsics.areEqual(this.recordingId, r9.recordingId) == true) goto L12;
        return false;
    L12:
        if (this.startTimeMs == r9.startTimeMs) goto L15;
        return false;
    L15:
        if (this.isRecording == r9.isRecording) goto L18;
        return false;
    L18:
        if (this.source == r9.source) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        int r0 = this.recordingId.hashCode() * 31;
        long r1 = this.startTimeMs;
        int r2 = (r0 + ((int) (r1 ^ (r1 >>> 32)))) * 31;
        if (this.isRecording == false) goto L5;
        int r3 = 1231;
    L6:
        int r4 = (r2 + r3) * 31;
        MmRecordingSource r5 = this.source;
        if (r5 != null) goto L9;
        int r6 = 0;
    L11:
        return r4 + r6;
    L9:
        r6 = r5.hashCode();
        goto L11
    L5:
        r3 = 1237;
        goto L6
    }

    public String toString() {
        return "MmOfflineRecordingItem(recordingId=" + this.recordingId + ", startTimeMs=" + this.startTimeMs + ", isRecording=" + this.isRecording + ", source=" + this.source + ')';
    }

    public final String getRecordingId() {
        return this.recordingId;
    }

    public final MmRecordingSource getSource() {
        return this.source;
    }

    public final long getStartTimeMs() {
        return this.startTimeMs;
    }

    public final boolean isRecording() {
        return this.isRecording;
    }

    public MmOfflineRecordingItem(String r2, long r3, boolean r5, MmRecordingSource r6) {
        Intrinsics.checkNotNullParameter(r2, "recordingId");
        this.recordingId = r2;
        this.startTimeMs = r3;
        this.isRecording = r5;
        this.source = r6;
    }

    public /* synthetic */ MmOfflineRecordingItem(String r7, long r8, boolean r10, MmRecordingSource r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 8) == 0) goto L5;
        r11 = null;
    L5:
        this(r7, r8, r10, r11);
    }
}
