package com.bytedance.android.live.profit.dress.config;

import com.bytedance.badger.collect.impl.constants.Constants;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/live/profit/dress/config/ResourceGetErrorType;", "", "", Constants.OperatorKey.CODE, "I", "getCode", "()I", "Succeed", "DressIdNotFound", "DressTypeMisMatch", "StillLoading", "revenue-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum ResourceGetErrorType extends Enum<ResourceGetErrorType> {
    public static final ResourceGetErrorType DressIdNotFound = null;
    public static final ResourceGetErrorType DressTypeMisMatch = null;
    public static final ResourceGetErrorType StillLoading = null;
    public static final ResourceGetErrorType Succeed = null;
    public static final /* synthetic */ ResourceGetErrorType[] a = null;
    private final int code;

    static {
        ResourceGetErrorType r1 = new ResourceGetErrorType("Succeed", 0, 0);
        Succeed = r1;
        ResourceGetErrorType r2 = new ResourceGetErrorType("DressIdNotFound", 1, 1);
        DressIdNotFound = r2;
        ResourceGetErrorType r3 = new ResourceGetErrorType("DressTypeMisMatch", 2, 2);
        DressTypeMisMatch = r3;
        ResourceGetErrorType r4 = new ResourceGetErrorType("StillLoading", 3, 3);
        StillLoading = r4;
        a = new ResourceGetErrorType[]{r1, r2, r3, r4};
    }

    public static ResourceGetErrorType valueOf(String r1) {
        return (ResourceGetErrorType) r27.a.a(ResourceGetErrorType.class, r1);
    }

    public static ResourceGetErrorType[] values() {
        return (ResourceGetErrorType[]) a.clone();
    }

    public final int getCode() {
        return this.code;
    }

    public ResourceGetErrorType(String r1, int r2, int r3) {
        super(r1, r2);
        this.code = r3;
    }
}
