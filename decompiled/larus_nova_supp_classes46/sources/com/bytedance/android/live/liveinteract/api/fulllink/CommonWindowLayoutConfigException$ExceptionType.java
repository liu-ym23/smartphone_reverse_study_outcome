package com.bytedance.android.live.liveinteract.api.fulllink;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"com/bytedance/android/live/liveinteract/api/fulllink/CommonWindowLayoutConfigException$ExceptionType", "", "Lcom/bytedance/android/live/liveinteract/api/fulllink/CommonWindowLayoutConfigException$ExceptionType;", "REVIEW_LIST_EXCEPTION", "REVIEW_LIST_EMPTY", "REVIEW_LIST_LOAD_SUCCESS", "LAYOUT_CONFIG_NOT_FOUND", "LAYOUT_CONFIG_EXCEPTION", "LAYOUT_CONFIG_LOAD_SUCCESS", "liveinteract-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum CommonWindowLayoutConfigException$ExceptionType extends Enum<CommonWindowLayoutConfigException$ExceptionType> {
    public static final CommonWindowLayoutConfigException$ExceptionType LAYOUT_CONFIG_EXCEPTION = null;
    public static final CommonWindowLayoutConfigException$ExceptionType LAYOUT_CONFIG_LOAD_SUCCESS = null;
    public static final CommonWindowLayoutConfigException$ExceptionType LAYOUT_CONFIG_NOT_FOUND = null;
    public static final CommonWindowLayoutConfigException$ExceptionType REVIEW_LIST_EMPTY = null;
    public static final CommonWindowLayoutConfigException$ExceptionType REVIEW_LIST_EXCEPTION = null;
    public static final CommonWindowLayoutConfigException$ExceptionType REVIEW_LIST_LOAD_SUCCESS = null;
    public static final /* synthetic */ CommonWindowLayoutConfigException$ExceptionType[] a = null;

    static {
        CommonWindowLayoutConfigException$ExceptionType r1 = new CommonWindowLayoutConfigException$ExceptionType("REVIEW_LIST_EXCEPTION", 0);
        REVIEW_LIST_EXCEPTION = r1;
        CommonWindowLayoutConfigException$ExceptionType r2 = new CommonWindowLayoutConfigException$ExceptionType("REVIEW_LIST_EMPTY", 1);
        REVIEW_LIST_EMPTY = r2;
        CommonWindowLayoutConfigException$ExceptionType r3 = new CommonWindowLayoutConfigException$ExceptionType("REVIEW_LIST_LOAD_SUCCESS", 2);
        REVIEW_LIST_LOAD_SUCCESS = r3;
        CommonWindowLayoutConfigException$ExceptionType r4 = new CommonWindowLayoutConfigException$ExceptionType("LAYOUT_CONFIG_NOT_FOUND", 3);
        LAYOUT_CONFIG_NOT_FOUND = r4;
        CommonWindowLayoutConfigException$ExceptionType r5 = new CommonWindowLayoutConfigException$ExceptionType("LAYOUT_CONFIG_EXCEPTION", 4);
        LAYOUT_CONFIG_EXCEPTION = r5;
        CommonWindowLayoutConfigException$ExceptionType r6 = new CommonWindowLayoutConfigException$ExceptionType("LAYOUT_CONFIG_LOAD_SUCCESS", 5);
        LAYOUT_CONFIG_LOAD_SUCCESS = r6;
        a = new CommonWindowLayoutConfigException$ExceptionType[]{r1, r2, r3, r4, r5, r6};
    }

    public static CommonWindowLayoutConfigException$ExceptionType valueOf(String r1) {
        return (CommonWindowLayoutConfigException$ExceptionType) a.a(CommonWindowLayoutConfigException$ExceptionType.class, r1);
    }

    public static CommonWindowLayoutConfigException$ExceptionType[] values() {
        return (CommonWindowLayoutConfigException$ExceptionType[]) a.clone();
    }

    public CommonWindowLayoutConfigException$ExceptionType(String r1, int r2) {
        super(r1, r2);
    }
}
