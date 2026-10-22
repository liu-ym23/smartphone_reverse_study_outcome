package com.larus.dora.impl.log;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/larus/dora/impl/log/DoraLogManager$DoraHeadPhoneLogType;", "", "typeName", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getTypeName", "()Ljava/lang/String;", "KEY", "POINT", "ASSERT", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DoraLogManager$DoraHeadPhoneLogType extends Enum<DoraLogManager$DoraHeadPhoneLogType> {
    public static final DoraLogManager$DoraHeadPhoneLogType ASSERT = null;
    public static final DoraLogManager$DoraHeadPhoneLogType KEY = null;
    public static final DoraLogManager$DoraHeadPhoneLogType POINT = null;
    public static final /* synthetic */ DoraLogManager$DoraHeadPhoneLogType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final String typeName;

    public static EnumEntries<DoraLogManager$DoraHeadPhoneLogType> getEntries() {
        return b;
    }

    static {
        DoraLogManager$DoraHeadPhoneLogType r0 = new DoraLogManager$DoraHeadPhoneLogType("KEY", 0, "doralite-key");
        KEY = r0;
        DoraLogManager$DoraHeadPhoneLogType r1 = new DoraLogManager$DoraHeadPhoneLogType("POINT", 1, "doralite-point");
        POINT = r1;
        DoraLogManager$DoraHeadPhoneLogType r2 = new DoraLogManager$DoraHeadPhoneLogType("ASSERT", 2, "doralite-assert");
        ASSERT = r2;
        DoraLogManager$DoraHeadPhoneLogType[] r4 = {r0, r1, r2};
        a = r4;
        b = EnumEntriesKt.enumEntries(r4);
    }

    public static DoraLogManager$DoraHeadPhoneLogType[] values() {
        return (DoraLogManager$DoraHeadPhoneLogType[]) a.clone();
    }

    public final String getTypeName() {
        return this.typeName;
    }

    public static DoraLogManager$DoraHeadPhoneLogType valueOf(String r1) {
        return (DoraLogManager$DoraHeadPhoneLogType) a.a(DoraLogManager$DoraHeadPhoneLogType.class, r1);
    }

    public DoraLogManager$DoraHeadPhoneLogType(String r1, int r2, String r3) {
        super(r1, r2);
        this.typeName = r3;
    }
}
