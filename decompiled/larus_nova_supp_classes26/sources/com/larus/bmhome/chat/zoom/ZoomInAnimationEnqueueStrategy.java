package com.larus.bmhome.chat.zoom;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/bmhome/chat/zoom/ZoomInAnimationEnqueueStrategy;", "", "<init>", "(Ljava/lang/String;I)V", "ENQUEUE", "SKIP_IF_BUSY", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ZoomInAnimationEnqueueStrategy extends Enum<ZoomInAnimationEnqueueStrategy> {
    public static final ZoomInAnimationEnqueueStrategy ENQUEUE = null;
    public static final ZoomInAnimationEnqueueStrategy SKIP_IF_BUSY = null;
    public static final /* synthetic */ ZoomInAnimationEnqueueStrategy[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<ZoomInAnimationEnqueueStrategy> getEntries() {
        return b;
    }

    static {
        ZoomInAnimationEnqueueStrategy r0 = new ZoomInAnimationEnqueueStrategy("ENQUEUE", 0);
        ENQUEUE = r0;
        ZoomInAnimationEnqueueStrategy r1 = new ZoomInAnimationEnqueueStrategy("SKIP_IF_BUSY", 1);
        SKIP_IF_BUSY = r1;
        ZoomInAnimationEnqueueStrategy[] r3 = {r0, r1};
        a = r3;
        b = EnumEntriesKt.enumEntries(r3);
    }

    public static ZoomInAnimationEnqueueStrategy[] values() {
        return (ZoomInAnimationEnqueueStrategy[]) a.clone();
    }

    public static ZoomInAnimationEnqueueStrategy valueOf(String r1) {
        return (ZoomInAnimationEnqueueStrategy) a.a(ZoomInAnimationEnqueueStrategy.class, r1);
    }

    public ZoomInAnimationEnqueueStrategy(String r1, int r2) {
        super(r1, r2);
    }
}
