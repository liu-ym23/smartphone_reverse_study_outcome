package com.bytedance.android.live.revlink.impl.pk.utils;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final enum SearchSourceFlag extends Enum<SearchSourceFlag> {
    public static final SearchSourceFlag INVITE_LINKING = null;
    public static final SearchSourceFlag MAIN_LINK = null;
    public static final SearchSourceFlag UNDEFINE = null;
    public static final /* synthetic */ SearchSourceFlag[] a = null;

    static {
        SearchSourceFlag r0 = new SearchSourceFlag("UNDEFINE", 0);
        UNDEFINE = r0;
        SearchSourceFlag r1 = new SearchSourceFlag("MAIN_LINK", 1);
        MAIN_LINK = r1;
        SearchSourceFlag r3 = new SearchSourceFlag("INVITE_LINKING", 2);
        INVITE_LINKING = r3;
        a = new SearchSourceFlag[]{r0, r1, r3};
    }

    public static SearchSourceFlag[] values() {
        return (SearchSourceFlag[]) a.clone();
    }

    public static SearchSourceFlag valueOf(String r1) {
        return (SearchSourceFlag) r27.a.a(SearchSourceFlag.class, r1);
    }

    public SearchSourceFlag(String r1, int r2) {
        super(r1, r2);
    }
}
