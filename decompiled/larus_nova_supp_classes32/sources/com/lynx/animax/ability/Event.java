package com.lynx.animax.ability;

import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final enum Event extends Enum<Event> {
    public static final Event CANCEL = null;
    public static final Event COMPLETION = null;
    public static final Event COMPOSITION_READY = null;
    public static final Event ERROR = null;
    public static final Event FIRST_FRAME = null;
    public static final Event FPS = null;
    public static final Event READY = null;
    public static final Event REPEAT = null;
    public static final Event START = null;
    public static final Event TAP_LAYERS = null;
    public static final Event UPDATE = null;
    public static final Event WARNING = null;
    public static final /* synthetic */ Event[] a = null;

    static {
        Event r0 = new Event("COMPLETION", 0);
        COMPLETION = r0;
        Event r1 = new Event("START", 1);
        START = r1;
        Event r3 = new Event("REPEAT", 2);
        REPEAT = r3;
        Event r5 = new Event("CANCEL", 3);
        CANCEL = r5;
        Event r7 = new Event("READY", 4);
        READY = r7;
        Event r9 = new Event("UPDATE", 5);
        UPDATE = r9;
        Event r11 = new Event("ERROR", 6);
        ERROR = r11;
        Event r13 = new Event("FPS", 7);
        FPS = r13;
        Event r15 = new Event("COMPOSITION_READY", 8);
        COMPOSITION_READY = r15;
        Event r14 = new Event("TAP_LAYERS", 9);
        TAP_LAYERS = r14;
        Event r12 = new Event("FIRST_FRAME", 10);
        FIRST_FRAME = r12;
        Event r10 = new Event("WARNING", 11);
        WARNING = r10;
        a = new Event[]{r0, r1, r3, r5, r7, r9, r11, r13, r15, r14, r12, r10};
    }

    public static Event[] values() {
        return (Event[]) a.clone();
    }

    public static Event valueOf(String r1) {
        return (Event) a.a(Event.class, r1);
    }

    public Event(String r1, int r2) {
        super(r1, r2);
    }
}
