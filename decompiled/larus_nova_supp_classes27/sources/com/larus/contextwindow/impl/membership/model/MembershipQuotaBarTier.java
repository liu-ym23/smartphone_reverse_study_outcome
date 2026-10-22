package com.larus.contextwindow.impl.membership.model;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/larus/contextwindow/impl/membership/model/MembershipQuotaBarTier;", "", "<init>", "(Ljava/lang/String;I)V", "EMPTY", "PRIMARY", "WARNING", "DANGER", "NEUTRAL", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum MembershipQuotaBarTier extends Enum<MembershipQuotaBarTier> {
    public static final MembershipQuotaBarTier DANGER = null;
    public static final MembershipQuotaBarTier EMPTY = null;
    public static final MembershipQuotaBarTier NEUTRAL = null;
    public static final MembershipQuotaBarTier PRIMARY = null;
    public static final MembershipQuotaBarTier WARNING = null;
    public static final /* synthetic */ MembershipQuotaBarTier[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<MembershipQuotaBarTier> getEntries() {
        return b;
    }

    static {
        MembershipQuotaBarTier r0 = new MembershipQuotaBarTier("EMPTY", 0);
        EMPTY = r0;
        MembershipQuotaBarTier r1 = new MembershipQuotaBarTier("PRIMARY", 1);
        PRIMARY = r1;
        MembershipQuotaBarTier r3 = new MembershipQuotaBarTier("WARNING", 2);
        WARNING = r3;
        MembershipQuotaBarTier r5 = new MembershipQuotaBarTier("DANGER", 3);
        DANGER = r5;
        MembershipQuotaBarTier r7 = new MembershipQuotaBarTier("NEUTRAL", 4);
        NEUTRAL = r7;
        MembershipQuotaBarTier[] r9 = {r0, r1, r3, r5, r7};
        a = r9;
        b = EnumEntriesKt.enumEntries(r9);
    }

    public static MembershipQuotaBarTier[] values() {
        return (MembershipQuotaBarTier[]) a.clone();
    }

    public static MembershipQuotaBarTier valueOf(String r1) {
        return (MembershipQuotaBarTier) a.a(MembershipQuotaBarTier.class, r1);
    }

    public MembershipQuotaBarTier(String r1, int r2) {
        super(r1, r2);
    }
}
