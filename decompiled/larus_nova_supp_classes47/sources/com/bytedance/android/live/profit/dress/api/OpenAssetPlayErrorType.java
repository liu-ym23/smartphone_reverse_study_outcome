package com.bytedance.android.live.profit.dress.api;

import com.bytedance.android.live.schema.api.WebcastRedirectException;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\r\b\u0087\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/live/profit/dress/api/OpenAssetPlayErrorType;", "", "", "value", "I", "getValue", "()I", "Success", "Unknown", "DressIdNotFound", "AssetNotFound", "PlayError", "Other", "SomeIsNull", "UserInfoRenderFailed", "revenue-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum OpenAssetPlayErrorType extends Enum<OpenAssetPlayErrorType> {
    public static final OpenAssetPlayErrorType AssetNotFound = null;
    public static final OpenAssetPlayErrorType DressIdNotFound = null;
    public static final OpenAssetPlayErrorType Other = null;
    public static final OpenAssetPlayErrorType PlayError = null;
    public static final OpenAssetPlayErrorType SomeIsNull = null;
    public static final OpenAssetPlayErrorType Success = null;
    public static final OpenAssetPlayErrorType Unknown = null;
    public static final OpenAssetPlayErrorType UserInfoRenderFailed = null;
    public static final /* synthetic */ OpenAssetPlayErrorType[] a = null;
    private final int value;

    public static OpenAssetPlayErrorType valueOf(String r1) {
        return (OpenAssetPlayErrorType) a.a(OpenAssetPlayErrorType.class, r1);
    }

    public static OpenAssetPlayErrorType[] values() {
        return (OpenAssetPlayErrorType[]) a.clone();
    }

    static {
        OpenAssetPlayErrorType r1 = new OpenAssetPlayErrorType("Success", 0, 0);
        Success = r1;
        OpenAssetPlayErrorType r2 = new OpenAssetPlayErrorType("Unknown", 1, 1);
        Unknown = r2;
        OpenAssetPlayErrorType r3 = new OpenAssetPlayErrorType("DressIdNotFound", 2, 2);
        DressIdNotFound = r3;
        OpenAssetPlayErrorType r4 = new OpenAssetPlayErrorType("AssetNotFound", 3, 3);
        AssetNotFound = r4;
        OpenAssetPlayErrorType r5 = new OpenAssetPlayErrorType("PlayError", 4, 4);
        PlayError = r5;
        OpenAssetPlayErrorType r6 = new OpenAssetPlayErrorType("Other", 5, WebcastRedirectException.UNKNOWN);
        Other = r6;
        OpenAssetPlayErrorType r7 = new OpenAssetPlayErrorType("SomeIsNull", 6, WebcastRedirectException.MISS_REDIRECT_RULE);
        SomeIsNull = r7;
        OpenAssetPlayErrorType r8 = new OpenAssetPlayErrorType("UserInfoRenderFailed", 7, WebcastRedirectException.ERROR_CONFIG_SOURCE);
        UserInfoRenderFailed = r8;
        a = new OpenAssetPlayErrorType[]{r1, r2, r3, r4, r5, r6, r7, r8};
    }

    public final int getValue() {
        return this.value;
    }

    public OpenAssetPlayErrorType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
