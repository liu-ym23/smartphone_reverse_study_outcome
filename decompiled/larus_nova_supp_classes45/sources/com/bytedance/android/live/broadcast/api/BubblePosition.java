package com.bytedance.android.live.broadcast.api;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/broadcast/api/BubblePosition;", "", "Bottom", "Top", "livebroadcast-shared-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum BubblePosition extends Enum<BubblePosition> {
    public static final BubblePosition Bottom = null;
    public static final BubblePosition Top = null;
    public static final /* synthetic */ BubblePosition[] a = null;

    static {
        BubblePosition r1 = new BubblePosition("Bottom", 0);
        Bottom = r1;
        BubblePosition r2 = new BubblePosition("Top", 1);
        Top = r2;
        a = new BubblePosition[]{r1, r2};
    }

    public static BubblePosition valueOf(String r1) {
        return (BubblePosition) a.a(BubblePosition.class, r1);
    }

    public static BubblePosition[] values() {
        return (BubblePosition[]) a.clone();
    }

    public BubblePosition(String r1, int r2) {
        super(r1, r2);
    }
}
