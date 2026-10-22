package com.larus.dora.impl.dynamic.dsl;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/larus/dora/impl/dynamic/dsl/DslEnableCondition;", "", "<init>", "(Ljava/lang/String;I)V", "DEVICE_CONNECTED", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DslEnableCondition extends Enum<DslEnableCondition> {

    @SerializedName("device_connected")
    public static final DslEnableCondition DEVICE_CONNECTED = null;
    public static final /* synthetic */ DslEnableCondition[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<DslEnableCondition> getEntries() {
        return b;
    }

    static {
        DslEnableCondition r0 = new DslEnableCondition();
        DEVICE_CONNECTED = r0;
        DslEnableCondition[] r1 = {r0};
        a = r1;
        b = EnumEntriesKt.enumEntries(r1);
    }

    public DslEnableCondition() {
        super("DEVICE_CONNECTED", 0);
    }

    public static DslEnableCondition[] values() {
        return (DslEnableCondition[]) a.clone();
    }

    public static DslEnableCondition valueOf(String r1) {
        return (DslEnableCondition) r27.a.a(DslEnableCondition.class, r1);
    }
}
