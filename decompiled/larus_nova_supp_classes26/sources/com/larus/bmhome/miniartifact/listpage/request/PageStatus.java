package com.larus.bmhome.miniartifact.listpage.request;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/larus/bmhome/miniartifact/listpage/request/PageStatus;", "", "<init>", "(Ljava/lang/String;I)V", "LOADING", "SUCCESS", "EMPTY", "FAIL", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum PageStatus extends Enum<PageStatus> {
    public static final PageStatus EMPTY = null;
    public static final PageStatus FAIL = null;
    public static final PageStatus LOADING = null;
    public static final PageStatus SUCCESS = null;
    public static final /* synthetic */ PageStatus[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<PageStatus> getEntries() {
        return b;
    }

    static {
        PageStatus r0 = new PageStatus("LOADING", 0);
        LOADING = r0;
        PageStatus r1 = new PageStatus("SUCCESS", 1);
        SUCCESS = r1;
        PageStatus r3 = new PageStatus("EMPTY", 2);
        EMPTY = r3;
        PageStatus r5 = new PageStatus("FAIL", 3);
        FAIL = r5;
        PageStatus[] r7 = {r0, r1, r3, r5};
        a = r7;
        b = EnumEntriesKt.enumEntries(r7);
    }

    public static PageStatus[] values() {
        return (PageStatus[]) a.clone();
    }

    public static PageStatus valueOf(String r1) {
        return (PageStatus) r27.a.a(PageStatus.class, r1);
    }

    public PageStatus(String r1, int r2) {
        super(r1, r2);
    }
}
