package com.bytedance.android.live.multilink.impl.control.setting;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0087\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/multilink/impl/control/setting/PaidLinkConfigType;", "", "InteractAudience", "VideoTalk", "All", "multilink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum PaidLinkConfigType extends Enum<PaidLinkConfigType> {
    public static final PaidLinkConfigType All = null;
    public static final PaidLinkConfigType InteractAudience = null;
    public static final PaidLinkConfigType VideoTalk = null;
    public static final /* synthetic */ PaidLinkConfigType[] a = null;

    static {
        PaidLinkConfigType r1 = new PaidLinkConfigType("InteractAudience", 0);
        InteractAudience = r1;
        PaidLinkConfigType r2 = new PaidLinkConfigType("VideoTalk", 1);
        VideoTalk = r2;
        PaidLinkConfigType r3 = new PaidLinkConfigType("All", 2);
        All = r3;
        a = new PaidLinkConfigType[]{r1, r2, r3};
    }

    public static PaidLinkConfigType valueOf(String r1) {
        return (PaidLinkConfigType) a.a(PaidLinkConfigType.class, r1);
    }

    public static PaidLinkConfigType[] values() {
        return (PaidLinkConfigType[]) a.clone();
    }

    public PaidLinkConfigType(String r1, int r2) {
        super(r1, r2);
    }
}
