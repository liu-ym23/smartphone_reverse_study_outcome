package com.larus.contextwindow.impl.membership.model;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/larus/contextwindow/impl/membership/model/MembershipQuotaRowKind;", "", "<init>", "(Ljava/lang/String;I)V", "H5", "D7", "SUBSCRIPTION_TOTAL", "M1", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum MembershipQuotaRowKind extends Enum<MembershipQuotaRowKind> {
    public static final MembershipQuotaRowKind D7 = null;
    public static final MembershipQuotaRowKind H5 = null;
    public static final MembershipQuotaRowKind M1 = null;
    public static final MembershipQuotaRowKind SUBSCRIPTION_TOTAL = null;
    public static final /* synthetic */ MembershipQuotaRowKind[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<MembershipQuotaRowKind> getEntries() {
        return b;
    }

    static {
        MembershipQuotaRowKind r0 = new MembershipQuotaRowKind("H5", 0);
        H5 = r0;
        MembershipQuotaRowKind r1 = new MembershipQuotaRowKind("D7", 1);
        D7 = r1;
        MembershipQuotaRowKind r3 = new MembershipQuotaRowKind("SUBSCRIPTION_TOTAL", 2);
        SUBSCRIPTION_TOTAL = r3;
        MembershipQuotaRowKind r5 = new MembershipQuotaRowKind("M1", 3);
        M1 = r5;
        MembershipQuotaRowKind[] r7 = {r0, r1, r3, r5};
        a = r7;
        b = EnumEntriesKt.enumEntries(r7);
    }

    public static MembershipQuotaRowKind[] values() {
        return (MembershipQuotaRowKind[]) a.clone();
    }

    public static MembershipQuotaRowKind valueOf(String r1) {
        return (MembershipQuotaRowKind) a.a(MembershipQuotaRowKind.class, r1);
    }

    public MembershipQuotaRowKind(String r1, int r2) {
        super(r1, r2);
    }
}
