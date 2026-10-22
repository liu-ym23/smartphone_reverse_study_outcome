package com.bytedance.android.livesdk.interactivity.medialink.contract;

import com.bytedance.bdlocation.BuildConfig;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/medialink/contract/AnchorLinkInitType;", BuildConfig.FLAVOR, "NONE", "REPLY_AGREE_API", "REPLY_AGREE_MSG", "LINK_SWITCH_CHANNEL", "interactivity-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum AnchorLinkInitType extends Enum<AnchorLinkInitType> {
    public static final AnchorLinkInitType LINK_SWITCH_CHANNEL = null;
    public static final AnchorLinkInitType NONE = null;
    public static final AnchorLinkInitType REPLY_AGREE_API = null;
    public static final AnchorLinkInitType REPLY_AGREE_MSG = null;
    public static final /* synthetic */ AnchorLinkInitType[] a = null;

    static {
        AnchorLinkInitType r1 = new AnchorLinkInitType("NONE", 0);
        NONE = r1;
        AnchorLinkInitType r2 = new AnchorLinkInitType("REPLY_AGREE_API", 1);
        REPLY_AGREE_API = r2;
        AnchorLinkInitType r3 = new AnchorLinkInitType("REPLY_AGREE_MSG", 2);
        REPLY_AGREE_MSG = r3;
        AnchorLinkInitType r4 = new AnchorLinkInitType("LINK_SWITCH_CHANNEL", 3);
        LINK_SWITCH_CHANNEL = r4;
        a = new AnchorLinkInitType[]{r1, r2, r3, r4};
    }

    public static AnchorLinkInitType valueOf(String r1) {
        return (AnchorLinkInitType) r27.a.a(AnchorLinkInitType.class, r1);
    }

    public static AnchorLinkInitType[] values() {
        return (AnchorLinkInitType[]) a.clone();
    }

    public AnchorLinkInitType(String r1, int r2) {
        super(r1, r2);
    }
}
