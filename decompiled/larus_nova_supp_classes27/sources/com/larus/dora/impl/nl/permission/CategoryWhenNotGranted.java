package com.larus.dora.impl.nl.permission;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/dora/impl/nl/permission/CategoryWhenNotGranted;", "", "<init>", "(Ljava/lang/String;I)V", "NEXT", "LOOP", "INTERRUPT", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum CategoryWhenNotGranted extends Enum<CategoryWhenNotGranted> {
    public static final CategoryWhenNotGranted INTERRUPT = null;
    public static final CategoryWhenNotGranted LOOP = null;
    public static final CategoryWhenNotGranted NEXT = null;
    public static final /* synthetic */ CategoryWhenNotGranted[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<CategoryWhenNotGranted> getEntries() {
        return b;
    }

    static {
        CategoryWhenNotGranted r0 = new CategoryWhenNotGranted("NEXT", 0);
        NEXT = r0;
        CategoryWhenNotGranted r1 = new CategoryWhenNotGranted("LOOP", 1);
        LOOP = r1;
        CategoryWhenNotGranted r3 = new CategoryWhenNotGranted("INTERRUPT", 2);
        INTERRUPT = r3;
        CategoryWhenNotGranted[] r5 = {r0, r1, r3};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
    }

    public static CategoryWhenNotGranted[] values() {
        return (CategoryWhenNotGranted[]) a.clone();
    }

    public static CategoryWhenNotGranted valueOf(String r1) {
        return (CategoryWhenNotGranted) a.a(CategoryWhenNotGranted.class, r1);
    }

    public CategoryWhenNotGranted(String r1, int r2) {
        super(r1, r2);
    }
}
