package com.bytedance.android.live.profit.scoreboard;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/profit/scoreboard/LinkMode;", "", "UN_KNOW", "SINGlE", "TWIN", "revenue-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum LinkMode extends Enum<LinkMode> {
    public static final LinkMode SINGlE = null;
    public static final LinkMode TWIN = null;
    public static final LinkMode UN_KNOW = null;
    public static final /* synthetic */ LinkMode[] a = null;

    static {
        LinkMode r1 = new LinkMode("UN_KNOW", 0);
        UN_KNOW = r1;
        LinkMode r2 = new LinkMode("SINGlE", 1);
        SINGlE = r2;
        LinkMode r3 = new LinkMode("TWIN", 2);
        TWIN = r3;
        a = new LinkMode[]{r1, r2, r3};
    }

    public static LinkMode valueOf(String r1) {
        return (LinkMode) r27.a.a(LinkMode.class, r1);
    }

    public static LinkMode[] values() {
        return (LinkMode[]) a.clone();
    }

    public LinkMode(String r1, int r2) {
        super(r1, r2);
    }
}
