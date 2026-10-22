package com.bytedance.android.live.revlink.impl.multianchor;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/multianchor/AnchorLinkInitType;", "", "NONE", "PK_SWITCH_LINK", "LINK_SWITCH_CHANNEL", "REPLY_AGREE_API", "REPLY_AGREE_MSG", "PERMIT_AGREE_MSG", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum AnchorLinkInitType extends Enum<AnchorLinkInitType> {
    public static final AnchorLinkInitType LINK_SWITCH_CHANNEL = null;
    public static final AnchorLinkInitType NONE = null;
    public static final AnchorLinkInitType PERMIT_AGREE_MSG = null;
    public static final AnchorLinkInitType PK_SWITCH_LINK = null;
    public static final AnchorLinkInitType REPLY_AGREE_API = null;
    public static final AnchorLinkInitType REPLY_AGREE_MSG = null;
    public static final /* synthetic */ AnchorLinkInitType[] a = null;

    static {
        AnchorLinkInitType r1 = new AnchorLinkInitType("NONE", 0);
        NONE = r1;
        AnchorLinkInitType r2 = new AnchorLinkInitType("PK_SWITCH_LINK", 1);
        PK_SWITCH_LINK = r2;
        AnchorLinkInitType r3 = new AnchorLinkInitType("LINK_SWITCH_CHANNEL", 2);
        LINK_SWITCH_CHANNEL = r3;
        AnchorLinkInitType r4 = new AnchorLinkInitType("REPLY_AGREE_API", 3);
        REPLY_AGREE_API = r4;
        AnchorLinkInitType r5 = new AnchorLinkInitType("REPLY_AGREE_MSG", 4);
        REPLY_AGREE_MSG = r5;
        AnchorLinkInitType r6 = new AnchorLinkInitType("PERMIT_AGREE_MSG", 5);
        PERMIT_AGREE_MSG = r6;
        a = new AnchorLinkInitType[]{r1, r2, r3, r4, r5, r6};
    }

    public static AnchorLinkInitType valueOf(String r1) {
        return (AnchorLinkInitType) a.a(AnchorLinkInitType.class, r1);
    }

    public static AnchorLinkInitType[] values() {
        return (AnchorLinkInitType[]) a.clone();
    }

    public AnchorLinkInitType(String r1, int r2) {
        super(r1, r2);
    }
}
