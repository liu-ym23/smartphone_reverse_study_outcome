package com.larus.bmhome.chat.zoom;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/bmhome/chat/zoom/ZoomInAnimationEndStrategy;", "", "<init>", "(Ljava/lang/String;I)V", "TIMER_CONTROL", "PASSIVE_WAIT", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ZoomInAnimationEndStrategy extends Enum<ZoomInAnimationEndStrategy> {
    public static final ZoomInAnimationEndStrategy PASSIVE_WAIT = null;
    public static final ZoomInAnimationEndStrategy TIMER_CONTROL = null;
    public static final /* synthetic */ ZoomInAnimationEndStrategy[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<ZoomInAnimationEndStrategy> getEntries() {
        return b;
    }

    static {
        ZoomInAnimationEndStrategy r0 = new ZoomInAnimationEndStrategy("TIMER_CONTROL", 0);
        TIMER_CONTROL = r0;
        ZoomInAnimationEndStrategy r1 = new ZoomInAnimationEndStrategy("PASSIVE_WAIT", 1);
        PASSIVE_WAIT = r1;
        ZoomInAnimationEndStrategy[] r3 = {r0, r1};
        a = r3;
        b = EnumEntriesKt.enumEntries(r3);
    }

    public static ZoomInAnimationEndStrategy[] values() {
        return (ZoomInAnimationEndStrategy[]) a.clone();
    }

    public static ZoomInAnimationEndStrategy valueOf(String r1) {
        return (ZoomInAnimationEndStrategy) a.a(ZoomInAnimationEndStrategy.class, r1);
    }

    public ZoomInAnimationEndStrategy(String r1, int r2) {
        super(r1, r2);
    }
}
