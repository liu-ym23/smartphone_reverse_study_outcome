package com.larus.uaigc.helper;

import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/larus/uaigc/helper/CreationReviewState;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "PASS", "INSTANT_SKIP", "DEGRADE", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
final enum CreationReviewState extends Enum<CreationReviewState> {
    public static final CreationReviewState DEGRADE = null;
    public static final CreationReviewState INSTANT_SKIP = null;
    public static final CreationReviewState PASS = null;
    public static final /* synthetic */ CreationReviewState[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final String value;

    public static EnumEntries<CreationReviewState> getEntries() {
        return b;
    }

    static {
        CreationReviewState r0 = new CreationReviewState("PASS", 0, "pass");
        PASS = r0;
        CreationReviewState r1 = new CreationReviewState("INSTANT_SKIP", 1, "instant_skip");
        INSTANT_SKIP = r1;
        CreationReviewState r2 = new CreationReviewState("DEGRADE", 2, "degrade");
        DEGRADE = r2;
        CreationReviewState[] r4 = {r0, r1, r2};
        a = r4;
        b = EnumEntriesKt.enumEntries(r4);
    }

    public static CreationReviewState[] values() {
        return (CreationReviewState[]) a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public static CreationReviewState valueOf(String r1) {
        return (CreationReviewState) r27.a.a(CreationReviewState.class, r1);
    }

    public CreationReviewState(String r1, int r2, String r3) {
        super(r1, r2);
        this.value = r3;
    }
}
