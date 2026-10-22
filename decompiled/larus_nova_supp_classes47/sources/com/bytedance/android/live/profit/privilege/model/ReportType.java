package com.bytedance.android.live.profit.privilege.model;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\t\n\u0002\b\n\b\u0086\u0001\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/live/profit/privilege/model/ReportType;", "", "", "value", "J", "getValue", "()J", "Companion", "a", "Unknown", "SINGLE_SHOT", "MULTI_SHOT", "revenue-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum ReportType extends Enum<ReportType> {
    public static final a Companion = null;
    public static final ReportType MULTI_SHOT = null;
    public static final ReportType SINGLE_SHOT = null;
    public static final ReportType Unknown = null;
    public static final /* synthetic */ ReportType[] a = null;
    private final long value;

    public static final class a {
        public a() {
        }

        public static ReportType a(long r8) {
            ReportType[] r0 = ReportType.values();
            int r1 = r0.length;
            int r3 = 0;
        L3:
            if (r3 >= r1) goto L11;
            ReportType r4 = r0[r3];
            if (r4.getValue() != r8) goto L7;
            boolean r5 = true;
        L8:
            if (r5 == true) goto L12;
            r3 = r3 + 1;
        L12:
            if (r4 == null) goto L14;
            return r4;
        L14:
            return ReportType.Unknown;
        L7:
            r5 = false;
            goto L8
        L11:
            r4 = null;
            goto L12
        }
    }

    static {
        ReportType r1 = new ReportType("Unknown", 0, -1);
        Unknown = r1;
        ReportType r2 = new ReportType("SINGLE_SHOT", 1, 0);
        SINGLE_SHOT = r2;
        ReportType r3 = new ReportType("MULTI_SHOT", 2, 1);
        MULTI_SHOT = r3;
        a = new ReportType[]{r1, r2, r3};
        Companion = new a();
    }

    public static ReportType valueOf(String r1) {
        return (ReportType) r27.a.a(ReportType.class, r1);
    }

    public static ReportType[] values() {
        return (ReportType[]) a.clone();
    }

    public final long getValue() {
        return this.value;
    }

    public ReportType(String r1, int r2, long r3) {
        super(r1, r2);
        this.value = r3;
    }
}
