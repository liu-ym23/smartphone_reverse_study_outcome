package com.larus.bot.impl.bean;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000bB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, d2 = {"Lcom/larus/bot/impl/bean/OperateType;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "UNKNOWN", "OVERRIDABLE", "NON_OVERRIDABLE", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum OperateType extends Enum<OperateType> {
    public static final a Companion = null;
    public static final OperateType NON_OVERRIDABLE = null;
    public static final OperateType OVERRIDABLE = null;
    public static final OperateType UNKNOWN = null;
    public static final /* synthetic */ OperateType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final String value;

    public static EnumEntries<OperateType> getEntries() {
        return b;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.larus.bot.impl.bean.OperateType$a] */
    static {
        OperateType r0 = new OperateType("UNKNOWN", 0, "");
        UNKNOWN = r0;
        OperateType r1 = new OperateType("OVERRIDABLE", 1, "Overridable");
        OVERRIDABLE = r1;
        OperateType r3 = new OperateType("NON_OVERRIDABLE", 2, "NonOverridable");
        NON_OVERRIDABLE = r3;
        OperateType[] r5 = {r0, r1, r3};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
        Companion = new a();
    }

    public static OperateType[] values() {
        return (OperateType[]) a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public static OperateType valueOf(String r1) {
        return (OperateType) r27.a.a(OperateType.class, r1);
    }

    public OperateType(String r1, int r2, String r3) {
        super(r1, r2);
        this.value = r3;
    }
}
