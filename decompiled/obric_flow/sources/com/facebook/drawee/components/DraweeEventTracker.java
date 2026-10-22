package com.facebook.drawee.components;

import java.util.concurrent.ArrayBlockingQueue;

/* JADX INFO: loaded from: classes2.dex */
public class DraweeEventTracker {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final DraweeEventTracker f7754b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final boolean f7755c = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayBlockingQueue f7756a;

    public static final enum Event extends Enum<Event> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Event f7757a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final Event f7758b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final Event f7759c = null;
        public static final Event d = null;
        public static final Event e = null;
        public static final Event f = null;
        public static final Event g = null;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final Event f7760h = null;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final Event f7761i = null;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public static final Event f7762j = null;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public static final Event f7763k = null;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public static final Event f7764l = null;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public static final Event f7765m = null;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public static final Event f7766n = null;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public static final Event f7767o = null;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public static final Event f7768p = null;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public static final Event f7769q = null;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public static final Event f7770r = null;
        public static final Event s = null;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public static final /* synthetic */ Event[] f7771t = null;

        static {
            Event r5 = new Event("ON_SET_HIERARCHY", 0);
            f7757a = r5;
            Event r10 = new Event("ON_CLEAR_HIERARCHY", 1);
            f7758b = r10;
            Event r11 = new Event("ON_SET_CONTROLLER", 2);
            f7759c = r11;
            Event r12 = new Event("ON_CLEAR_OLD_CONTROLLER", 3);
            d = r12;
            Event r13 = new Event("ON_CLEAR_CONTROLLER", 4);
            e = r13;
            Event r14 = new Event("ON_INIT_CONTROLLER", 5);
            f = r14;
            Event r15 = new Event("ON_ATTACH_CONTROLLER", 6);
            g = r15;
            Event r16 = new Event("ON_DETACH_CONTROLLER", 7);
            f7760h = r16;
            Event r17 = new Event("ON_RELEASE_CONTROLLER", 8);
            f7761i = r17;
            Event r18 = new Event("ON_DATASOURCE_SUBMIT", 9);
            f7762j = r18;
            Event r19 = new Event("ON_DATASOURCE_RESULT", 10);
            f7763k = r19;
            Event r110 = new Event("ON_DATASOURCE_RESULT_INT", 11);
            f7764l = r110;
            Event r111 = new Event("ON_DATASOURCE_FAILURE", 12);
            f7765m = r111;
            Event r112 = new Event("ON_DATASOURCE_FAILURE_INT", 13);
            f7766n = r112;
            Event r20 = new Event("ON_HOLDER_ATTACH", 14);
            f7767o = r20;
            Event r21 = new Event("ON_HOLDER_DETACH", 15);
            f7768p = r21;
            Event r22 = new Event("ON_DRAWABLE_SHOW", 16);
            f7769q = r22;
            Event r23 = new Event("ON_DRAWABLE_HIDE", 17);
            f7770r = r23;
            Event r24 = new Event("ON_ACTIVITY_START", 18);
            Event r25 = new Event("ON_ACTIVITY_STOP", 19);
            Event r26 = new Event("ON_RUN_CLEAR_CONTROLLER", 20);
            Event r27 = new Event("ON_SCHEDULE_CLEAR_CONTROLLER", 21);
            Event r28 = new Event("ON_SAME_CONTROLLER_SKIPPED", 22);
            Event r29 = new Event("ON_SUBMIT_CACHE_HIT", 23);
            s = r29;
            f7771t = new Event[]{r5, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r110, r111, r112, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29};
        }

        public Event(String r5, int r10) {
            super(r5, r10);
        }

        public static Event valueOf(String r5) {
            return (Event) Enum.valueOf(Event.class, r5);
        }

        public static Event[] values() {
            return (Event[]) f7771t.clone();
        }
    }

    static {
        f7754b = new DraweeEventTracker();
        f7755c = true;
    }

    public DraweeEventTracker() {
        this.f7756a = new ArrayBlockingQueue(20);
    }

    public final void a(Event r5) {
        if (f7755c == true) goto L6;
        return;
    L6:
        if ((this.f7756a.size() + 1) <= 20) goto L8;
        this.f7756a.poll();
    L8:
        this.f7756a.add(r5);
    }

    public final String toString() {
        return this.f7756a.toString();
    }
}
