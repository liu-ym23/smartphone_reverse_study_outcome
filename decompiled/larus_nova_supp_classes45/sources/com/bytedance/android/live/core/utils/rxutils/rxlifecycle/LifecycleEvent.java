package com.bytedance.android.live.core.utils.rxutils.rxlifecycle;

import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final enum LifecycleEvent extends Enum<LifecycleEvent> {
    public static final LifecycleEvent ATTACH = null;
    public static final LifecycleEvent CREATE = null;
    public static final LifecycleEvent CREATE_VIEW = null;
    public static final LifecycleEvent DESTROY = null;
    public static final LifecycleEvent DESTROY_VIEW = null;
    public static final LifecycleEvent DETACH = null;
    public static final LifecycleEvent PAUSE = null;
    public static final LifecycleEvent RESUME = null;
    public static final LifecycleEvent START = null;
    public static final LifecycleEvent STOP = null;
    public static final /* synthetic */ LifecycleEvent[] a = null;

    static {
        LifecycleEvent r0 = new LifecycleEvent("ATTACH", 0);
        ATTACH = r0;
        LifecycleEvent r1 = new LifecycleEvent("CREATE", 1);
        CREATE = r1;
        LifecycleEvent r3 = new LifecycleEvent("CREATE_VIEW", 2);
        CREATE_VIEW = r3;
        LifecycleEvent r5 = new LifecycleEvent("START", 3);
        START = r5;
        LifecycleEvent r7 = new LifecycleEvent("RESUME", 4);
        RESUME = r7;
        LifecycleEvent r9 = new LifecycleEvent("PAUSE", 5);
        PAUSE = r9;
        LifecycleEvent r11 = new LifecycleEvent("STOP", 6);
        STOP = r11;
        LifecycleEvent r13 = new LifecycleEvent("DESTROY_VIEW", 7);
        DESTROY_VIEW = r13;
        LifecycleEvent r15 = new LifecycleEvent("DESTROY", 8);
        DESTROY = r15;
        LifecycleEvent r14 = new LifecycleEvent("DETACH", 9);
        DETACH = r14;
        a = new LifecycleEvent[]{r0, r1, r3, r5, r7, r9, r11, r13, r15, r14};
    }

    public static LifecycleEvent[] values() {
        return (LifecycleEvent[]) a.clone();
    }

    public static LifecycleEvent valueOf(String r1) {
        return (LifecycleEvent) a.a(LifecycleEvent.class, r1);
    }

    public LifecycleEvent(String r1, int r2) {
        super(r1, r2);
    }
}
