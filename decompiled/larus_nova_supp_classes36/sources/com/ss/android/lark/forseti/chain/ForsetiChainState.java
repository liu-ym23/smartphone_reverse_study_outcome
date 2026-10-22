package com.ss.android.lark.forseti.chain;

import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/ss/android/lark/forseti/chain/ForsetiChainState;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "STOPPED", "STARTED", "RESUMED", "forseti_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final enum ForsetiChainState extends Enum<ForsetiChainState> {
    public static final ForsetiChainState RESUMED = null;
    public static final ForsetiChainState STARTED = null;
    public static final ForsetiChainState STOPPED = null;
    public static final /* synthetic */ ForsetiChainState[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int value;

    public static EnumEntries<ForsetiChainState> getEntries() {
        return b;
    }

    static {
        ForsetiChainState r0 = new ForsetiChainState("STOPPED", 0, 1);
        STOPPED = r0;
        ForsetiChainState r1 = new ForsetiChainState("STARTED", 1, 2);
        STARTED = r1;
        ForsetiChainState r4 = new ForsetiChainState("RESUMED", 2, 3);
        RESUMED = r4;
        ForsetiChainState[] r6 = {r0, r1, r4};
        a = r6;
        b = EnumEntriesKt.enumEntries(r6);
    }

    public static ForsetiChainState[] values() {
        return (ForsetiChainState[]) a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static ForsetiChainState valueOf(String r1) {
        return (ForsetiChainState) r27.a.a(ForsetiChainState.class, r1);
    }

    public ForsetiChainState(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
