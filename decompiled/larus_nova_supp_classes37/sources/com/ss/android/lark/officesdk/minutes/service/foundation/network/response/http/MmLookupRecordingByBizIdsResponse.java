package com.ss.android.lark.officesdk.minutes.service.foundation.network.response.http;

import com.google.gson.annotations.SerializedName;
import com.ss.android.lark.picker.base.view.ItemViewType;
import java.io.Serializable;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u0014B!\u0012\u0018\b\u0002\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0019\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005HÆ\u0003J#\u0010\u000b\u001a\u00020\u00002\u0018\b\u0002\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R&\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0015"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/service/foundation/network/response/http/MmLookupRecordingByBizIdsResponse;", "Ljava/io/Serializable;", "entries", "Ljava/util/ArrayList;", "Lcom/ss/android/lark/officesdk/minutes/service/foundation/network/response/http/MmLookupRecordingByBizIdsResponse$Entry;", "Lkotlin/collections/ArrayList;", "<init>", "(Ljava/util/ArrayList;)V", "getEntries", "()Ljava/util/ArrayList;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "Entry", "officesdk-minutes-service_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class MmLookupRecordingByBizIdsResponse implements Serializable {

    @SerializedName("entries")
    private final ArrayList<Entry> entries;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J'\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0017"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/service/foundation/network/response/http/MmLookupRecordingByBizIdsResponse$Entry;", "Ljava/io/Serializable;", "bizType", "", "bizId", "recordingId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getBizType", "()Ljava/lang/String;", "getBizId", "getRecordingId", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "officesdk-minutes-service_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    public static final class Entry implements Serializable {

        @SerializedName("biz_id")
        private final String bizId;

        @SerializedName("biz_type")
        private final String bizType;

        @SerializedName("recording_id")
        private final String recordingId;

        public Entry() {
            this(null, null, null, 7, null);
        }

        public static /* synthetic */ Entry copy$default(Entry r0, String r1, String r2, String r3, int r4, Object r5) {
            if ((r4 & 1) == 0) goto L6;
            r1 = r0.bizType;
        L6:
            if ((r4 & 2) == 0) goto L9;
            r2 = r0.bizId;
        L9:
            if ((r4 & 4) == 0) goto L12;
            r3 = r0.recordingId;
        L12:
            return r0.copy(r1, r2, r3);
        }

        public final String component1() {
            return this.bizType;
        }

        public final String component2() {
            return this.bizId;
        }

        public final String component3() {
            return this.recordingId;
        }

        public final Entry copy(String r2, String r3, String r4) {
            Intrinsics.checkNotNullParameter(r2, "bizType");
            Intrinsics.checkNotNullParameter(r3, "bizId");
            Intrinsics.checkNotNullParameter(r4, "recordingId");
            return new Entry(r2, r3, r4);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof Entry) == true) goto L8;
            return false;
        L8:
            Entry r6 = (Entry) r5;
            if (Intrinsics.areEqual(this.bizType, r6.bizType) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.bizId, r6.bizId) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.recordingId, r6.recordingId) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            return (((this.bizType.hashCode() * 31) + this.bizId.hashCode()) * 31) + this.recordingId.hashCode();
        }

        public String toString() {
            return "Entry(bizType=" + this.bizType + ", bizId=" + this.bizId + ", recordingId=" + this.recordingId + ')';
        }

        public final String getBizId() {
            return this.bizId;
        }

        public final String getBizType() {
            return this.bizType;
        }

        public final String getRecordingId() {
            return this.recordingId;
        }

        public Entry(String r2, String r3, String r4) {
            Intrinsics.checkNotNullParameter(r2, "bizType");
            Intrinsics.checkNotNullParameter(r3, "bizId");
            Intrinsics.checkNotNullParameter(r4, "recordingId");
            this.bizType = r2;
            this.bizId = r3;
            this.recordingId = r4;
        }

        public /* synthetic */ Entry(String r2, String r3, String r4, int r5, DefaultConstructorMarker r6) {
            if ((r5 & 1) == 0) goto L6;
            r2 = "";
        L6:
            if ((r5 & 2) == 0) goto L9;
            r3 = "";
        L9:
            if ((r5 & 4) == 0) goto L11;
            r4 = "";
        L11:
            this(r2, r3, r4);
        }
    }

    public MmLookupRecordingByBizIdsResponse() {
        ArrayList r0 = null;
        this(r0, 1, r0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MmLookupRecordingByBizIdsResponse copy$default(MmLookupRecordingByBizIdsResponse r0, ArrayList r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = r0.entries;
    L6:
        return r0.copy(r1);
    }

    public final ArrayList<Entry> component1() {
        return this.entries;
    }

    public final MmLookupRecordingByBizIdsResponse copy(ArrayList<Entry> r2) {
        Intrinsics.checkNotNullParameter(r2, "entries");
        return new MmLookupRecordingByBizIdsResponse(r2);
    }

    public boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if ((r4 instanceof MmLookupRecordingByBizIdsResponse) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.entries, ((MmLookupRecordingByBizIdsResponse) r4).entries) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        return this.entries.hashCode();
    }

    public String toString() {
        return "MmLookupRecordingByBizIdsResponse(entries=" + this.entries + ')';
    }

    public final ArrayList<Entry> getEntries() {
        return this.entries;
    }

    public MmLookupRecordingByBizIdsResponse(ArrayList<Entry> r2) {
        Intrinsics.checkNotNullParameter(r2, "entries");
        this.entries = r2;
    }

    public /* synthetic */ MmLookupRecordingByBizIdsResponse(ArrayList r1, int r2, DefaultConstructorMarker r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = new ArrayList();
    L5:
        this(r1);
    }
}
