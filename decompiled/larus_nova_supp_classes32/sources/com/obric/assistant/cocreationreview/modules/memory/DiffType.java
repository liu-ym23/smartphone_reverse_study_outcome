package com.obric.assistant.cocreationreview.modules.memory;

import com.obric.aivoice.core.data.NameKeys;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/obric/assistant/cocreationreview/modules/memory/DiffType;", NameKeys.UnloadStrategy_No_Strategy, "<init>", "(Ljava/lang/String;I)V", "EQUAL", "INSERT", "DELETE", "cocreationreview_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DiffType extends Enum<DiffType> {
    public static final DiffType DELETE = null;
    public static final DiffType EQUAL = null;
    public static final DiffType INSERT = null;
    public static final /* synthetic */ DiffType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<DiffType> getEntries() {
        return b;
    }

    static {
        DiffType r0 = new DiffType("EQUAL", 0);
        EQUAL = r0;
        DiffType r1 = new DiffType("INSERT", 1);
        INSERT = r1;
        DiffType r3 = new DiffType("DELETE", 2);
        DELETE = r3;
        DiffType[] r5 = {r0, r1, r3};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
    }

    public static DiffType[] values() {
        return (DiffType[]) a.clone();
    }

    public static DiffType valueOf(String r1) {
        return (DiffType) r27.a.a(DiffType.class, r1);
    }

    public DiffType(String r1, int r2) {
        super(r1, r2);
    }
}
