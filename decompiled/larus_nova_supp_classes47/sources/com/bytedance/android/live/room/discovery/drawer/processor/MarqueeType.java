package com.bytedance.android.live.room.discovery.drawer.processor;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/live/room/discovery/drawer/processor/MarqueeType;", "", "", "type", "Ljava/lang/String;", "getType", "()Ljava/lang/String;", "SHOW", "CLICK", "experience-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum MarqueeType extends Enum<MarqueeType> {
    public static final MarqueeType CLICK = null;
    public static final MarqueeType SHOW = null;
    public static final /* synthetic */ MarqueeType[] a = null;
    private final String type;

    static {
        MarqueeType r1 = new MarqueeType("SHOW", 0, "show");
        SHOW = r1;
        MarqueeType r2 = new MarqueeType("CLICK", 1, "click");
        CLICK = r2;
        a = new MarqueeType[]{r1, r2};
    }

    public static MarqueeType valueOf(String r1) {
        return (MarqueeType) r27.a.a(MarqueeType.class, r1);
    }

    public static MarqueeType[] values() {
        return (MarqueeType[]) a.clone();
    }

    public final String getType() {
        return this.type;
    }

    public MarqueeType(String r1, int r2, String r3) {
        super(r1, r2);
        this.type = r3;
    }
}
