package com.larus.common.account.bdauth.viewmodel;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/common/account/bdauth/viewmodel/BDAuthorizePageMode;", "", "<init>", "(Ljava/lang/String;I)V", "Loading", "Content", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum BDAuthorizePageMode extends Enum<BDAuthorizePageMode> {
    public static final BDAuthorizePageMode Content = null;
    public static final BDAuthorizePageMode Loading = null;
    public static final /* synthetic */ BDAuthorizePageMode[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<BDAuthorizePageMode> getEntries() {
        return b;
    }

    static {
        BDAuthorizePageMode r0 = new BDAuthorizePageMode("Loading", 0);
        Loading = r0;
        BDAuthorizePageMode r1 = new BDAuthorizePageMode("Content", 1);
        Content = r1;
        BDAuthorizePageMode[] r3 = {r0, r1};
        a = r3;
        b = EnumEntriesKt.enumEntries(r3);
    }

    public static BDAuthorizePageMode[] values() {
        return (BDAuthorizePageMode[]) a.clone();
    }

    public static BDAuthorizePageMode valueOf(String r1) {
        return (BDAuthorizePageMode) r27.a.a(BDAuthorizePageMode.class, r1);
    }

    public BDAuthorizePageMode(String r1, int r2) {
        super(r1, r2);
    }
}
