package com.larus.dora.impl.nl;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\u000b"}, d2 = {"Lcom/larus/dora/impl/nl/ProactivePriorityState;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "DISABLED", "ENABLED", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ProactivePriorityState extends Enum<ProactivePriorityState> {
    public static final a Companion = null;
    public static final ProactivePriorityState DISABLED = null;
    public static final ProactivePriorityState ENABLED = null;
    public static final /* synthetic */ ProactivePriorityState[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final String value;

    public static EnumEntries<ProactivePriorityState> getEntries() {
        return b;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.larus.dora.impl.nl.ProactivePriorityState$a] */
    static {
        ProactivePriorityState r0 = new ProactivePriorityState("DISABLED", 0, "0");
        DISABLED = r0;
        ProactivePriorityState r1 = new ProactivePriorityState("ENABLED", 1, "1");
        ENABLED = r1;
        ProactivePriorityState[] r3 = {r0, r1};
        a = r3;
        b = EnumEntriesKt.enumEntries(r3);
        Companion = new a();
    }

    public static ProactivePriorityState[] values() {
        return (ProactivePriorityState[]) a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public static ProactivePriorityState valueOf(String r1) {
        return (ProactivePriorityState) r27.a.a(ProactivePriorityState.class, r1);
    }

    public ProactivePriorityState(String r1, int r2, String r3) {
        super(r1, r2);
        this.value = r3;
    }
}
