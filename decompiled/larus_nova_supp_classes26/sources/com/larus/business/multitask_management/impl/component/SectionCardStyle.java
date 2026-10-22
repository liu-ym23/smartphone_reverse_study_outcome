package com.larus.business.multitask_management.impl.component;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/business/multitask_management/impl/component/SectionCardStyle;", "", "<init>", "(Ljava/lang/String;I)V", "SMALL", "LARGE", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum SectionCardStyle extends Enum<SectionCardStyle> {
    public static final SectionCardStyle LARGE = null;
    public static final SectionCardStyle SMALL = null;
    public static final /* synthetic */ SectionCardStyle[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<SectionCardStyle> getEntries() {
        return b;
    }

    static {
        SectionCardStyle r0 = new SectionCardStyle("SMALL", 0);
        SMALL = r0;
        SectionCardStyle r1 = new SectionCardStyle("LARGE", 1);
        LARGE = r1;
        SectionCardStyle[] r3 = {r0, r1};
        a = r3;
        b = EnumEntriesKt.enumEntries(r3);
    }

    public static SectionCardStyle[] values() {
        return (SectionCardStyle[]) a.clone();
    }

    public static SectionCardStyle valueOf(String r1) {
        return (SectionCardStyle) r27.a.a(SectionCardStyle.class, r1);
    }

    public SectionCardStyle(String r1, int r2) {
        super(r1, r2);
    }
}
