package com.bytedance.als.monitor;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/als/monitor/ComponentLifecycle;", "", "ON_INIT", "ON_CREATE", "ON_START", "ON_RESUME", "ON_PAUSE", "ON_STOP", "ON_DESTROY", "als_release"}, k = 1, mv = {1, 4, 1})
public final enum ComponentLifecycle extends Enum<ComponentLifecycle> {
    public static final ComponentLifecycle ON_CREATE = null;
    public static final ComponentLifecycle ON_DESTROY = null;
    public static final ComponentLifecycle ON_INIT = null;
    public static final ComponentLifecycle ON_PAUSE = null;
    public static final ComponentLifecycle ON_RESUME = null;
    public static final ComponentLifecycle ON_START = null;
    public static final ComponentLifecycle ON_STOP = null;
    public static final /* synthetic */ ComponentLifecycle[] a = null;

    static {
        ComponentLifecycle r1 = new ComponentLifecycle("ON_INIT", 0);
        ON_INIT = r1;
        ComponentLifecycle r10 = new ComponentLifecycle("ON_CREATE", 1);
        ON_CREATE = r10;
        ComponentLifecycle r11 = new ComponentLifecycle("ON_START", 2);
        ON_START = r11;
        ComponentLifecycle r12 = new ComponentLifecycle("ON_RESUME", 3);
        ON_RESUME = r12;
        ComponentLifecycle r13 = new ComponentLifecycle("ON_PAUSE", 4);
        ON_PAUSE = r13;
        ComponentLifecycle r14 = new ComponentLifecycle("ON_STOP", 5);
        ON_STOP = r14;
        ComponentLifecycle r15 = new ComponentLifecycle("ON_DESTROY", 6);
        ON_DESTROY = r15;
        a = new ComponentLifecycle[]{r1, r10, r11, r12, r13, r14, r15};
    }

    public static ComponentLifecycle valueOf(String r1) {
        return (ComponentLifecycle) a.a(ComponentLifecycle.class, r1);
    }

    public static ComponentLifecycle[] values() {
        return (ComponentLifecycle[]) a.clone();
    }

    public ComponentLifecycle(String r1, int r10) {
        super(r1, r10);
    }
}
