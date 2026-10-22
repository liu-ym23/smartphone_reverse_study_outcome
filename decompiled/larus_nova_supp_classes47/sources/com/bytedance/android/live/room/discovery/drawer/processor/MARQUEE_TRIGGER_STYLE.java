package com.bytedance.android.live.room.discovery.drawer.processor;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/room/discovery/drawer/processor/MARQUEE_TRIGGER_STYLE;", "", "OLD_TRIGGER_STYLE", "CLIENT_AI_TRIGGER_STYLE", "experience-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum MARQUEE_TRIGGER_STYLE extends Enum<MARQUEE_TRIGGER_STYLE> {
    public static final MARQUEE_TRIGGER_STYLE CLIENT_AI_TRIGGER_STYLE = null;
    public static final MARQUEE_TRIGGER_STYLE OLD_TRIGGER_STYLE = null;
    public static final /* synthetic */ MARQUEE_TRIGGER_STYLE[] a = null;

    static {
        MARQUEE_TRIGGER_STYLE r1 = new MARQUEE_TRIGGER_STYLE("OLD_TRIGGER_STYLE", 0);
        OLD_TRIGGER_STYLE = r1;
        MARQUEE_TRIGGER_STYLE r2 = new MARQUEE_TRIGGER_STYLE("CLIENT_AI_TRIGGER_STYLE", 1);
        CLIENT_AI_TRIGGER_STYLE = r2;
        a = new MARQUEE_TRIGGER_STYLE[]{r1, r2};
    }

    public static MARQUEE_TRIGGER_STYLE valueOf(String r1) {
        return (MARQUEE_TRIGGER_STYLE) r27.a.a(MARQUEE_TRIGGER_STYLE.class, r1);
    }

    public static MARQUEE_TRIGGER_STYLE[] values() {
        return (MARQUEE_TRIGGER_STYLE[]) a.clone();
    }

    public MARQUEE_TRIGGER_STYLE(String r1, int r2) {
        super(r1, r2);
    }
}
