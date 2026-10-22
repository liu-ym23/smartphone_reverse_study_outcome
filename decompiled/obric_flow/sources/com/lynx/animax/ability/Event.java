package com.lynx.animax.ability;

/* JADX INFO: loaded from: classes2.dex */
public final enum Event extends Enum<Event> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ Event[] f9578a = null;

    static {
        f9578a = new Event[]{new Event("COMPLETION", 0), new Event("START", 1), new Event("REPEAT", 2), new Event("CANCEL", 3), new Event("READY", 4), new Event("UPDATE", 5), new Event("ERROR", 6), new Event("FPS", 7), new Event("COMPOSITION_READY", 8), new Event("TAP_LAYERS", 9), new Event("FIRST_FRAME", 10), new Event("WARNING", 11)};
    }

    public Event(String r5, int r10) {
        super(r5, r10);
    }

    public static Event valueOf(String r5) {
        return (Event) Enum.valueOf(Event.class, r5);
    }

    public static Event[] values() {
        return (Event[]) f9578a.clone();
    }
}
