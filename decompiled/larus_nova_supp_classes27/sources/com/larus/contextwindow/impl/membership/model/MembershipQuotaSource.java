package com.larus.contextwindow.impl.membership.model;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/contextwindow/impl/membership/model/MembershipQuotaSource;", "", "<init>", "(Ljava/lang/String;I)V", "PERSONAL", "ENTERPRISE", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum MembershipQuotaSource extends Enum<MembershipQuotaSource> {
    public static final MembershipQuotaSource ENTERPRISE = null;
    public static final MembershipQuotaSource PERSONAL = null;
    public static final /* synthetic */ MembershipQuotaSource[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<MembershipQuotaSource> getEntries() {
        return b;
    }

    static {
        MembershipQuotaSource r0 = new MembershipQuotaSource("PERSONAL", 0);
        PERSONAL = r0;
        MembershipQuotaSource r1 = new MembershipQuotaSource("ENTERPRISE", 1);
        ENTERPRISE = r1;
        MembershipQuotaSource[] r3 = {r0, r1};
        a = r3;
        b = EnumEntriesKt.enumEntries(r3);
    }

    public static MembershipQuotaSource[] values() {
        return (MembershipQuotaSource[]) a.clone();
    }

    public static MembershipQuotaSource valueOf(String r1) {
        return (MembershipQuotaSource) a.a(MembershipQuotaSource.class, r1);
    }

    public MembershipQuotaSource(String r1, int r2) {
        super(r1, r2);
    }
}
