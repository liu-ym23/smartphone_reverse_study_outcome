package com.ss.android.lark.forseti.chain;

import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/ss/android/lark/forseti/chain/ForsetiStackChainStatus;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "NORMAL", "DELETING", "DELETED", "forseti_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final enum ForsetiStackChainStatus extends Enum<ForsetiStackChainStatus> {
    public static final ForsetiStackChainStatus DELETED = null;
    public static final ForsetiStackChainStatus DELETING = null;
    public static final ForsetiStackChainStatus NORMAL = null;
    public static final /* synthetic */ ForsetiStackChainStatus[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int value;

    public static EnumEntries<ForsetiStackChainStatus> getEntries() {
        return b;
    }

    static {
        ForsetiStackChainStatus r0 = new ForsetiStackChainStatus("NORMAL", 0, 1);
        NORMAL = r0;
        ForsetiStackChainStatus r1 = new ForsetiStackChainStatus("DELETING", 1, 2);
        DELETING = r1;
        ForsetiStackChainStatus r4 = new ForsetiStackChainStatus("DELETED", 2, 3);
        DELETED = r4;
        ForsetiStackChainStatus[] r6 = {r0, r1, r4};
        a = r6;
        b = EnumEntriesKt.enumEntries(r6);
    }

    public static ForsetiStackChainStatus[] values() {
        return (ForsetiStackChainStatus[]) a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static ForsetiStackChainStatus valueOf(String r1) {
        return (ForsetiStackChainStatus) r27.a.a(ForsetiStackChainStatus.class, r1);
    }

    public ForsetiStackChainStatus(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
