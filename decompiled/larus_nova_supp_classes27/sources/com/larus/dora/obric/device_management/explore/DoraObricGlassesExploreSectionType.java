package com.larus.dora.obric.device_management.explore;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/larus/dora/obric/device_management/explore/DoraObricGlassesExploreSectionType;", "", "<init>", "(Ljava/lang/String;I)V", "WAKEUP", "MEMORY", "MORE", "BASIC", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DoraObricGlassesExploreSectionType extends Enum<DoraObricGlassesExploreSectionType> {
    public static final DoraObricGlassesExploreSectionType BASIC = null;
    public static final DoraObricGlassesExploreSectionType MEMORY = null;
    public static final DoraObricGlassesExploreSectionType MORE = null;
    public static final DoraObricGlassesExploreSectionType WAKEUP = null;
    public static final /* synthetic */ DoraObricGlassesExploreSectionType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<DoraObricGlassesExploreSectionType> getEntries() {
        return b;
    }

    static {
        DoraObricGlassesExploreSectionType r0 = new DoraObricGlassesExploreSectionType("WAKEUP", 0);
        WAKEUP = r0;
        DoraObricGlassesExploreSectionType r1 = new DoraObricGlassesExploreSectionType("MEMORY", 1);
        MEMORY = r1;
        DoraObricGlassesExploreSectionType r3 = new DoraObricGlassesExploreSectionType("MORE", 2);
        MORE = r3;
        DoraObricGlassesExploreSectionType r5 = new DoraObricGlassesExploreSectionType("BASIC", 3);
        BASIC = r5;
        DoraObricGlassesExploreSectionType[] r7 = {r0, r1, r3, r5};
        a = r7;
        b = EnumEntriesKt.enumEntries(r7);
    }

    public static DoraObricGlassesExploreSectionType[] values() {
        return (DoraObricGlassesExploreSectionType[]) a.clone();
    }

    public static DoraObricGlassesExploreSectionType valueOf(String r1) {
        return (DoraObricGlassesExploreSectionType) r27.a.a(DoraObricGlassesExploreSectionType.class, r1);
    }

    public DoraObricGlassesExploreSectionType(String r1, int r2) {
        super(r1, r2);
    }
}
