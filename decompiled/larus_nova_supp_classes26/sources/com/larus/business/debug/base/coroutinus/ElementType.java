package com.larus.business.debug.base.coroutinus;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/business/debug/base/coroutinus/ElementType;", "", "<init>", "(Ljava/lang/String;I)V", "launch", "withContext", "async", "base_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ElementType extends Enum<ElementType> {
    public static final /* synthetic */ ElementType[] a = null;
    public static final ElementType async = null;
    public static final /* synthetic */ EnumEntries b = null;
    public static final ElementType launch = null;
    public static final ElementType withContext = null;

    public static EnumEntries<ElementType> getEntries() {
        return b;
    }

    static {
        ElementType r0 = new ElementType("launch", 0);
        launch = r0;
        ElementType r1 = new ElementType("withContext", 1);
        withContext = r1;
        ElementType r3 = new ElementType("async", 2);
        async = r3;
        ElementType[] r5 = {r0, r1, r3};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
    }

    public static ElementType[] values() {
        return (ElementType[]) a.clone();
    }

    public static ElementType valueOf(String r1) {
        return (ElementType) a.a(ElementType.class, r1);
    }

    public ElementType(String r1, int r2) {
        super(r1, r2);
    }
}
