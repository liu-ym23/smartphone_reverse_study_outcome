package com.obric.memorydata.middleware.impl.abtest;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/obric/memorydata/middleware/impl/abtest/AbVersionSource;", "", "<init>", "(Ljava/lang/String;I)V", "AB_TEST_SDK", "ABMOCK", "middleware_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum AbVersionSource extends Enum<AbVersionSource> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ AbVersionSource[] $VALUES = null;
    public static final AbVersionSource ABMOCK = null;
    public static final AbVersionSource AB_TEST_SDK = null;

    private static final /* synthetic */ AbVersionSource[] $values() {
        return new AbVersionSource[]{AB_TEST_SDK, ABMOCK};
    }

    static {
        AB_TEST_SDK = new AbVersionSource("AB_TEST_SDK", 0);
        ABMOCK = new AbVersionSource("ABMOCK", 1);
        AbVersionSource[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.memorydata.plugin"));
    }

    private AbVersionSource(String r1, int r2) {
        super(r1, r2);
    }

    public static EnumEntries<AbVersionSource> getEntries() {
        return $ENTRIES;
    }

    public static AbVersionSource valueOf(String r2) {
        return (AbVersionSource) ZeusTransformUtils.preCheckCast(Enum.valueOf(AbVersionSource.class, r2), AbVersionSource.class, "com.obric.memorydata.plugin");
    }

    public static AbVersionSource[] values() {
        return (AbVersionSource[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), AbVersionSource[].class, "com.obric.memorydata.plugin");
    }
}
