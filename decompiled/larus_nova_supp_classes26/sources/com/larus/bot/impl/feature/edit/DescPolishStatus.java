package com.larus.bot.impl.feature.edit;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/larus/bot/impl/feature/edit/DescPolishStatus;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "BEFORE_POLISH", "IN_POLISH", "AFTER_POLISH", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DescPolishStatus extends Enum<DescPolishStatus> {
    public static final DescPolishStatus AFTER_POLISH = null;
    public static final DescPolishStatus BEFORE_POLISH = null;
    public static final DescPolishStatus IN_POLISH = null;
    public static final /* synthetic */ DescPolishStatus[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int value;

    public static EnumEntries<DescPolishStatus> getEntries() {
        return b;
    }

    static {
        DescPolishStatus r0 = new DescPolishStatus("BEFORE_POLISH", 0, 1);
        BEFORE_POLISH = r0;
        DescPolishStatus r1 = new DescPolishStatus("IN_POLISH", 1, 2);
        IN_POLISH = r1;
        DescPolishStatus r4 = new DescPolishStatus("AFTER_POLISH", 2, 3);
        AFTER_POLISH = r4;
        DescPolishStatus[] r6 = {r0, r1, r4};
        a = r6;
        b = EnumEntriesKt.enumEntries(r6);
    }

    public static DescPolishStatus[] values() {
        return (DescPolishStatus[]) a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static DescPolishStatus valueOf(String r1) {
        return (DescPolishStatus) r27.a.a(DescPolishStatus.class, r1);
    }

    public DescPolishStatus(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
