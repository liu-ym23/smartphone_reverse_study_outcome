package com.larus.common.account.bdauth.viewmodel;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\t\u001a\u00020\nj\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\u000b"}, d2 = {"Lcom/larus/common/account/bdauth/viewmodel/BDAuthorizeAddAccountStage;", "", "<init>", "(Ljava/lang/String;I)V", "Idle", "OpeningLoginPanel", "WaitingAddAccountResult", "Completed", "Failed", "isInProgress", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum BDAuthorizeAddAccountStage extends Enum<BDAuthorizeAddAccountStage> {
    public static final BDAuthorizeAddAccountStage Completed = null;
    public static final BDAuthorizeAddAccountStage Failed = null;
    public static final BDAuthorizeAddAccountStage Idle = null;
    public static final BDAuthorizeAddAccountStage OpeningLoginPanel = null;
    public static final BDAuthorizeAddAccountStage WaitingAddAccountResult = null;
    public static final /* synthetic */ BDAuthorizeAddAccountStage[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<BDAuthorizeAddAccountStage> getEntries() {
        return b;
    }

    static {
        BDAuthorizeAddAccountStage r0 = new BDAuthorizeAddAccountStage("Idle", 0);
        Idle = r0;
        BDAuthorizeAddAccountStage r1 = new BDAuthorizeAddAccountStage("OpeningLoginPanel", 1);
        OpeningLoginPanel = r1;
        BDAuthorizeAddAccountStage r3 = new BDAuthorizeAddAccountStage("WaitingAddAccountResult", 2);
        WaitingAddAccountResult = r3;
        BDAuthorizeAddAccountStage r5 = new BDAuthorizeAddAccountStage("Completed", 3);
        Completed = r5;
        BDAuthorizeAddAccountStage r7 = new BDAuthorizeAddAccountStage("Failed", 4);
        Failed = r7;
        BDAuthorizeAddAccountStage[] r9 = {r0, r1, r3, r5, r7};
        a = r9;
        b = EnumEntriesKt.enumEntries(r9);
    }

    public static BDAuthorizeAddAccountStage[] values() {
        return (BDAuthorizeAddAccountStage[]) a.clone();
    }

    public final boolean isInProgress() {
        if (this != OpeningLoginPanel) goto L5;
    L8:
        return true;
    L5:
        if (this == WaitingAddAccountResult) goto L8;
        return false;
    }

    public static BDAuthorizeAddAccountStage valueOf(String r1) {
        return (BDAuthorizeAddAccountStage) r27.a.a(BDAuthorizeAddAccountStage.class, r1);
    }

    public BDAuthorizeAddAccountStage(String r1, int r2) {
        super(r1, r2);
    }
}
