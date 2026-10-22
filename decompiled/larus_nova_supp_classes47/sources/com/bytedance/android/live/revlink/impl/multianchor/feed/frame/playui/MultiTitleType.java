package com.bytedance.android.live.revlink.impl.multianchor.feed.frame.playui;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/multianchor/feed/frame/playui/MultiTitleType;", "", "VOTE", "PK", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum MultiTitleType extends Enum<MultiTitleType> {
    public static final MultiTitleType PK = null;
    public static final MultiTitleType VOTE = null;
    public static final /* synthetic */ MultiTitleType[] a = null;

    static {
        MultiTitleType r1 = new MultiTitleType("VOTE", 0);
        VOTE = r1;
        MultiTitleType r2 = new MultiTitleType("PK", 1);
        PK = r2;
        a = new MultiTitleType[]{r1, r2};
    }

    public static MultiTitleType valueOf(String r1) {
        return (MultiTitleType) r27.a.a(MultiTitleType.class, r1);
    }

    public static MultiTitleType[] values() {
        return (MultiTitleType[]) a.clone();
    }

    public MultiTitleType(String r1, int r2) {
        super(r1, r2);
    }
}
