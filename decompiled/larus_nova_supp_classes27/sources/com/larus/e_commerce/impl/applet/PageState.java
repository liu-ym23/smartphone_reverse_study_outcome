package com.larus.e_commerce.impl.applet;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/e_commerce/impl/applet/PageState;", "", "<init>", "(Ljava/lang/String;I)V", "UNKNOWN", "GOING", "CREATED", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum PageState extends Enum<PageState> {
    public static final PageState CREATED = null;
    public static final PageState GOING = null;
    public static final PageState UNKNOWN = null;
    public static final /* synthetic */ PageState[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<PageState> getEntries() {
        return b;
    }

    static {
        PageState r0 = new PageState("UNKNOWN", 0);
        UNKNOWN = r0;
        PageState r1 = new PageState("GOING", 1);
        GOING = r1;
        PageState r3 = new PageState("CREATED", 2);
        CREATED = r3;
        PageState[] r5 = {r0, r1, r3};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
    }

    public static PageState[] values() {
        return (PageState[]) a.clone();
    }

    public static PageState valueOf(String r1) {
        return (PageState) a.a(PageState.class, r1);
    }

    public PageState(String r1, int r2) {
        super(r1, r2);
    }
}
