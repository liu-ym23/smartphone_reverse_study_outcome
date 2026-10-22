package com.larus.dora.impl.dynamic;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/larus/dora/impl/dynamic/RightIconIdentifierType;", "", "type", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getType", "()Ljava/lang/String;", "SELECTED", "SWITCH", "ARROW", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum RightIconIdentifierType extends Enum<RightIconIdentifierType> {
    public static final RightIconIdentifierType ARROW = null;
    public static final RightIconIdentifierType SELECTED = null;
    public static final RightIconIdentifierType SWITCH = null;
    public static final /* synthetic */ RightIconIdentifierType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final String type;

    public static EnumEntries<RightIconIdentifierType> getEntries() {
        return b;
    }

    static {
        RightIconIdentifierType r0 = new RightIconIdentifierType("SELECTED", 0, "selected");
        SELECTED = r0;
        RightIconIdentifierType r1 = new RightIconIdentifierType("SWITCH", 1, "switch");
        SWITCH = r1;
        RightIconIdentifierType r2 = new RightIconIdentifierType("ARROW", 2, "arrow");
        ARROW = r2;
        RightIconIdentifierType[] r4 = {r0, r1, r2};
        a = r4;
        b = EnumEntriesKt.enumEntries(r4);
    }

    public static RightIconIdentifierType[] values() {
        return (RightIconIdentifierType[]) a.clone();
    }

    public final String getType() {
        return this.type;
    }

    public static RightIconIdentifierType valueOf(String r1) {
        return (RightIconIdentifierType) r27.a.a(RightIconIdentifierType.class, r1);
    }

    public RightIconIdentifierType(String r1, int r2, String r3) {
        super(r1, r2);
        this.type = r3;
    }
}
