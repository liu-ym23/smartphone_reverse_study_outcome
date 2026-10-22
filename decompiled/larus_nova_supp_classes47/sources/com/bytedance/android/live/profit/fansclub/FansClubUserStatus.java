package com.bytedance.android.live.profit.fansclub;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0001\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/live/profit/fansclub/FansClubUserStatus;", "", "", "value", "I", "getValue", "()I", "Companion", "a", "Unknown", "Active", "Inactive", "revenue-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum FansClubUserStatus extends Enum<FansClubUserStatus> {
    public static final FansClubUserStatus Active = null;
    public static final a Companion = null;
    public static final FansClubUserStatus Inactive = null;
    public static final FansClubUserStatus Unknown = null;
    public static final /* synthetic */ FansClubUserStatus[] a = null;
    private final int value;

    public static final class a {
        public a() {
        }
    }

    static {
        FansClubUserStatus r1 = new FansClubUserStatus("Unknown", 0, 0);
        Unknown = r1;
        FansClubUserStatus r2 = new FansClubUserStatus("Active", 1, 1);
        Active = r2;
        FansClubUserStatus r3 = new FansClubUserStatus("Inactive", 2, 2);
        Inactive = r3;
        a = new FansClubUserStatus[]{r1, r2, r3};
        Companion = new a();
    }

    public static FansClubUserStatus valueOf(String r1) {
        return (FansClubUserStatus) r27.a.a(FansClubUserStatus.class, r1);
    }

    public static FansClubUserStatus[] values() {
        return (FansClubUserStatus[]) a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public FansClubUserStatus(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
