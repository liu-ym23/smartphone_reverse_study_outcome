package com.larus.bmhome.chat.thinkmode;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/larus/bmhome/chat/thinkmode/BehaviorSource;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN", "ACTIONBAR", "CHAT", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum BehaviorSource extends Enum<BehaviorSource> {
    public static final BehaviorSource ACTIONBAR = null;
    public static final BehaviorSource CHAT = null;
    public static final BehaviorSource UNKNOWN = null;
    public static final /* synthetic */ BehaviorSource[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int value;

    public static EnumEntries<BehaviorSource> getEntries() {
        return b;
    }

    static {
        BehaviorSource r0 = new BehaviorSource("UNKNOWN", 0, 0);
        UNKNOWN = r0;
        BehaviorSource r1 = new BehaviorSource("ACTIONBAR", 1, 1);
        ACTIONBAR = r1;
        BehaviorSource r3 = new BehaviorSource("CHAT", 2, 2);
        CHAT = r3;
        BehaviorSource[] r5 = {r0, r1, r3};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
    }

    public static BehaviorSource[] values() {
        return (BehaviorSource[]) a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static BehaviorSource valueOf(String r1) {
        return (BehaviorSource) r27.a.a(BehaviorSource.class, r1);
    }

    public BehaviorSource(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
