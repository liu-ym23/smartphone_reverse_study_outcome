package com.larus.dora.impl.dynamic.dsl;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/dora/impl/dynamic/dsl/DslIdentifierType;", "", "<init>", "(Ljava/lang/String;I)V", "STRING", "STARLING", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DslIdentifierType extends Enum<DslIdentifierType> {

    @SerializedName("starling_type")
    public static final DslIdentifierType STARLING = null;

    @SerializedName("string_type")
    public static final DslIdentifierType STRING = null;
    public static final /* synthetic */ DslIdentifierType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<DslIdentifierType> getEntries() {
        return b;
    }

    static {
        DslIdentifierType r0 = new DslIdentifierType("STRING", 0);
        STRING = r0;
        DslIdentifierType r1 = new DslIdentifierType("STARLING", 1);
        STARLING = r1;
        DslIdentifierType[] r3 = {r0, r1};
        a = r3;
        b = EnumEntriesKt.enumEntries(r3);
    }

    public static DslIdentifierType[] values() {
        return (DslIdentifierType[]) a.clone();
    }

    public static DslIdentifierType valueOf(String r1) {
        return (DslIdentifierType) r27.a.a(DslIdentifierType.class, r1);
    }

    public DslIdentifierType(String r1, int r2) {
        super(r1, r2);
    }
}
