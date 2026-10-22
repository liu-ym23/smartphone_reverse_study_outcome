package com.ss.android.lark.location.service;

import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/ss/android/lark/location/service/SearchResultErrorCode;", "", "<init>", "(Ljava/lang/String;I)V", "OK", "NETWORK_FAILURE", "UNSUPPORTED", "ILLEGAL_PARAMS", "OTHER", "location_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final enum SearchResultErrorCode extends Enum<SearchResultErrorCode> {
    public static final SearchResultErrorCode ILLEGAL_PARAMS = null;
    public static final SearchResultErrorCode NETWORK_FAILURE = null;
    public static final SearchResultErrorCode OK = null;
    public static final SearchResultErrorCode OTHER = null;
    public static final SearchResultErrorCode UNSUPPORTED = null;
    public static final /* synthetic */ SearchResultErrorCode[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<SearchResultErrorCode> getEntries() {
        return b;
    }

    static {
        SearchResultErrorCode r0 = new SearchResultErrorCode("OK", 0);
        OK = r0;
        SearchResultErrorCode r1 = new SearchResultErrorCode("NETWORK_FAILURE", 1);
        NETWORK_FAILURE = r1;
        SearchResultErrorCode r3 = new SearchResultErrorCode("UNSUPPORTED", 2);
        UNSUPPORTED = r3;
        SearchResultErrorCode r5 = new SearchResultErrorCode("ILLEGAL_PARAMS", 3);
        ILLEGAL_PARAMS = r5;
        SearchResultErrorCode r7 = new SearchResultErrorCode("OTHER", 4);
        OTHER = r7;
        SearchResultErrorCode[] r9 = {r0, r1, r3, r5, r7};
        a = r9;
        b = EnumEntriesKt.enumEntries(r9);
    }

    public static SearchResultErrorCode[] values() {
        return (SearchResultErrorCode[]) a.clone();
    }

    public static SearchResultErrorCode valueOf(String r1) {
        return (SearchResultErrorCode) r27.a.a(SearchResultErrorCode.class, r1);
    }

    public SearchResultErrorCode(String r1, int r2) {
        super(r1, r2);
    }
}
