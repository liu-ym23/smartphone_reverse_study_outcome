package com.bytedance.android.live.ktv.common.model.bean;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/live/ktv/common/model/bean/DownloadResourceType;", "", "", "value", "I", "getValue", "()I", "MAIN_RESOURCE", "OTHER_RESOURCE", "livektv-common_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum DownloadResourceType extends Enum<DownloadResourceType> {
    public static final DownloadResourceType MAIN_RESOURCE = null;
    public static final DownloadResourceType OTHER_RESOURCE = null;
    public static final /* synthetic */ DownloadResourceType[] a = null;
    private final int value;

    static {
        DownloadResourceType r2 = new DownloadResourceType("MAIN_RESOURCE", 0, 1);
        MAIN_RESOURCE = r2;
        DownloadResourceType r3 = new DownloadResourceType("OTHER_RESOURCE", 1, 2);
        OTHER_RESOURCE = r3;
        a = new DownloadResourceType[]{r2, r3};
    }

    public static DownloadResourceType valueOf(String r1) {
        return (DownloadResourceType) r27.a.a(DownloadResourceType.class, r1);
    }

    public static DownloadResourceType[] values() {
        return (DownloadResourceType[]) a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public DownloadResourceType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
