package com.larus.dora.impl.dynamic;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\u000b"}, d2 = {"Lcom/larus/dora/impl/dynamic/IdentifierType;", "", "type", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getType", "()Ljava/lang/String;", "StringType", "StartlingType", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum IdentifierType extends Enum<IdentifierType> {
    public static final a Companion = null;
    public static final IdentifierType StartlingType = null;
    public static final IdentifierType StringType = null;
    public static final /* synthetic */ IdentifierType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final String type;

    public static EnumEntries<IdentifierType> getEntries() {
        return b;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.larus.dora.impl.dynamic.IdentifierType$a] */
    static {
        IdentifierType r0 = new IdentifierType("StringType", 0, "string_type");
        StringType = r0;
        IdentifierType r1 = new IdentifierType("StartlingType", 1, "starling_type");
        StartlingType = r1;
        IdentifierType[] r3 = {r0, r1};
        a = r3;
        b = EnumEntriesKt.enumEntries(r3);
        Companion = new a();
    }

    public static IdentifierType[] values() {
        return (IdentifierType[]) a.clone();
    }

    public final String getType() {
        return this.type;
    }

    public static IdentifierType valueOf(String r1) {
        return (IdentifierType) r27.a.a(IdentifierType.class, r1);
    }

    public IdentifierType(String r1, int r2, String r3) {
        super(r1, r2);
        this.type = r3;
    }
}
