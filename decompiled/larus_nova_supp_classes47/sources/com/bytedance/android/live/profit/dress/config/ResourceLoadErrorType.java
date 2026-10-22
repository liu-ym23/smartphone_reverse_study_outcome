package com.bytedance.android.live.profit.dress.config;

import com.bytedance.android.live.schema.api.WebcastRedirectException;
import com.bytedance.badger.collect.impl.constants.Constants;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\r\b\u0087\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/live/profit/dress/config/ResourceLoadErrorType;", "", "", Constants.OperatorKey.CODE, "I", "getCode", "()I", "Succeed", "Unknown", "DressNotFound", "DressConfigNotFound", "DownloadFailed", "DownloadPartFailed", "NoResourceToLoad", "ExistedTypeMismatch", "revenue-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum ResourceLoadErrorType extends Enum<ResourceLoadErrorType> {
    public static final ResourceLoadErrorType DownloadFailed = null;
    public static final ResourceLoadErrorType DownloadPartFailed = null;
    public static final ResourceLoadErrorType DressConfigNotFound = null;
    public static final ResourceLoadErrorType DressNotFound = null;
    public static final ResourceLoadErrorType ExistedTypeMismatch = null;
    public static final ResourceLoadErrorType NoResourceToLoad = null;
    public static final ResourceLoadErrorType Succeed = null;
    public static final ResourceLoadErrorType Unknown = null;
    public static final /* synthetic */ ResourceLoadErrorType[] a = null;
    private final int code;

    public static ResourceLoadErrorType valueOf(String r1) {
        return (ResourceLoadErrorType) r27.a.a(ResourceLoadErrorType.class, r1);
    }

    public static ResourceLoadErrorType[] values() {
        return (ResourceLoadErrorType[]) a.clone();
    }

    static {
        ResourceLoadErrorType r1 = new ResourceLoadErrorType("Succeed", 0, 0);
        Succeed = r1;
        ResourceLoadErrorType r2 = new ResourceLoadErrorType("Unknown", 1, 1);
        Unknown = r2;
        ResourceLoadErrorType r3 = new ResourceLoadErrorType("DressNotFound", 2, 2);
        DressNotFound = r3;
        ResourceLoadErrorType r4 = new ResourceLoadErrorType("DressConfigNotFound", 3, 3);
        DressConfigNotFound = r4;
        ResourceLoadErrorType r5 = new ResourceLoadErrorType("DownloadFailed", 4, 4);
        DownloadFailed = r5;
        ResourceLoadErrorType r6 = new ResourceLoadErrorType("DownloadPartFailed", 5, 5);
        DownloadPartFailed = r6;
        ResourceLoadErrorType r7 = new ResourceLoadErrorType("NoResourceToLoad", 6, WebcastRedirectException.UNKNOWN);
        NoResourceToLoad = r7;
        ResourceLoadErrorType r8 = new ResourceLoadErrorType("ExistedTypeMismatch", 7, WebcastRedirectException.MISS_REDIRECT_RULE);
        ExistedTypeMismatch = r8;
        a = new ResourceLoadErrorType[]{r1, r2, r3, r4, r5, r6, r7, r8};
    }

    public final int getCode() {
        return this.code;
    }

    public ResourceLoadErrorType(String r1, int r2, int r3) {
        super(r1, r2);
        this.code = r3;
    }
}
