package com.ss.android.lark.officesdk.minutes.service.recording.common.perf.appreciable;

import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class MmRecordingHistoryUploadAgeInfo {
    public static final /* synthetic */ int d = 0;
    public final long a;
    public final String b;
    public final boolean c;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/service/recording/common/perf/appreciable/MmRecordingHistoryUploadAgeInfo$AgeBucket;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "WITHIN_1H", "BETWEEN_1H_6H", "BETWEEN_6H_24H", "EXPIRED_24H", "UNKNOWN", "officesdk-minutes-service_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    public static final enum AgeBucket extends Enum<AgeBucket> {
        public static final AgeBucket BETWEEN_1H_6H = null;
        public static final AgeBucket BETWEEN_6H_24H = null;
        public static final AgeBucket EXPIRED_24H = null;
        public static final AgeBucket UNKNOWN = null;
        public static final AgeBucket WITHIN_1H = null;
        public static final /* synthetic */ AgeBucket[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final String value;

        public static EnumEntries<AgeBucket> getEntries() {
            return b;
        }

        static {
            AgeBucket r0 = new AgeBucket("WITHIN_1H", 0, "within_1h");
            WITHIN_1H = r0;
            AgeBucket r1 = new AgeBucket("BETWEEN_1H_6H", 1, "between_1h_6h");
            BETWEEN_1H_6H = r1;
            AgeBucket r2 = new AgeBucket("BETWEEN_6H_24H", 2, "between_6h_24h");
            BETWEEN_6H_24H = r2;
            AgeBucket r4 = new AgeBucket("EXPIRED_24H", 3, "expired_24h");
            EXPIRED_24H = r4;
            AgeBucket r6 = new AgeBucket("UNKNOWN", 4, "unknown");
            UNKNOWN = r6;
            AgeBucket[] r8 = {r0, r1, r2, r4, r6};
            a = r8;
            b = EnumEntriesKt.enumEntries(r8);
        }

        public static AgeBucket[] values() {
            return (AgeBucket[]) a.clone();
        }

        public final String getValue() {
            return this.value;
        }

        public static AgeBucket valueOf(String r1) {
            return (AgeBucket) r27.a.a(AgeBucket.class, r1);
        }

        public AgeBucket(String r1, int r2, String r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public static final class a {
    }

    static {
    }

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof MmRecordingHistoryUploadAgeInfo) == true) goto L8;
        return false;
    L8:
        MmRecordingHistoryUploadAgeInfo r9 = (MmRecordingHistoryUploadAgeInfo) r8;
        if (this.a == r9.a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r9.b) == true) goto L15;
        return false;
    L15:
        if (this.c == r9.c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        long r0 = this.a;
        int r1 = ((((int) (r0 ^ (r0 >>> 32))) * 31) + this.b.hashCode()) * 31;
        if (this.c == false) goto L5;
        int r2 = 1231;
    L7:
        return r1 + r2;
    L5:
        r2 = 1237;
        goto L7
    }

    public final String toString() {
        return "MmRecordingHistoryUploadAgeInfo(ageMs=" + this.a + ", ageBucket=" + this.b + ", isOver24h=" + this.c + ')';
    }

    public MmRecordingHistoryUploadAgeInfo(long r2, String r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r4, "ageBucket");
        this.a = r2;
        this.b = r4;
        this.c = r5;
    }
}
