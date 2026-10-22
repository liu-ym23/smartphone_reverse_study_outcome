package com.bytedance.android.live.revlink.impl.multianchor.dialog.mic;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/multianchor/dialog/mic/MultiLinkMicStrategy;", "", "BASE", "ENLARGE", "FULL", "FULL_RECORD", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum MultiLinkMicStrategy extends Enum<MultiLinkMicStrategy> {
    public static final MultiLinkMicStrategy BASE = null;
    public static final MultiLinkMicStrategy ENLARGE = null;
    public static final MultiLinkMicStrategy FULL = null;
    public static final MultiLinkMicStrategy FULL_RECORD = null;
    public static final /* synthetic */ MultiLinkMicStrategy[] a = null;

    static {
        MultiLinkMicStrategy r1 = new MultiLinkMicStrategy("BASE", 0);
        BASE = r1;
        MultiLinkMicStrategy r2 = new MultiLinkMicStrategy("ENLARGE", 1);
        ENLARGE = r2;
        MultiLinkMicStrategy r3 = new MultiLinkMicStrategy("FULL", 2);
        FULL = r3;
        MultiLinkMicStrategy r4 = new MultiLinkMicStrategy("FULL_RECORD", 3);
        FULL_RECORD = r4;
        a = new MultiLinkMicStrategy[]{r1, r2, r3, r4};
    }

    public static MultiLinkMicStrategy valueOf(String r1) {
        return (MultiLinkMicStrategy) a.a(MultiLinkMicStrategy.class, r1);
    }

    public static MultiLinkMicStrategy[] values() {
        return (MultiLinkMicStrategy[]) a.clone();
    }

    public MultiLinkMicStrategy(String r1, int r2) {
        super(r1, r2);
    }
}
