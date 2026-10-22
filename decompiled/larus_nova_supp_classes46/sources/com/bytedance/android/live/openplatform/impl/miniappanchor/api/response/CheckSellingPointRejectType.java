package com.bytedance.android.live.openplatform.impl.miniappanchor.api.response;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/miniappanchor/api/response/CheckSellingPointRejectType;", "", "UNKNOWN", "SENSITIVE_WORDS", "FREQUENCY_LIMIT", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum CheckSellingPointRejectType extends Enum<CheckSellingPointRejectType> {
    public static final CheckSellingPointRejectType FREQUENCY_LIMIT = null;
    public static final CheckSellingPointRejectType SENSITIVE_WORDS = null;
    public static final CheckSellingPointRejectType UNKNOWN = null;
    public static final /* synthetic */ CheckSellingPointRejectType[] a = null;

    static {
        CheckSellingPointRejectType r1 = new CheckSellingPointRejectType("UNKNOWN", 0);
        UNKNOWN = r1;
        CheckSellingPointRejectType r2 = new CheckSellingPointRejectType("SENSITIVE_WORDS", 1);
        SENSITIVE_WORDS = r2;
        CheckSellingPointRejectType r3 = new CheckSellingPointRejectType("FREQUENCY_LIMIT", 2);
        FREQUENCY_LIMIT = r3;
        a = new CheckSellingPointRejectType[]{r1, r2, r3};
    }

    public static CheckSellingPointRejectType valueOf(String r1) {
        return (CheckSellingPointRejectType) r27.a.a(CheckSellingPointRejectType.class, r1);
    }

    public static CheckSellingPointRejectType[] values() {
        return (CheckSellingPointRejectType[]) a.clone();
    }

    public CheckSellingPointRejectType(String r1, int r2) {
        super(r1, r2);
    }
}
