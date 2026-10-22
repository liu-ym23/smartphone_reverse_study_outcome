package com.bytedance.android.live.room.api.messagewindow.schedule;

import j71.a;
import kotlin.Metadata;
import v61.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public class ScheduleParams<Window extends c> {
    public a a;
    public Enqueue b;
    public Window c;
    public b71.a d;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/room/api/messagewindow/schedule/ScheduleParams$Enqueue;", "", "Tail", "Head", "Immediately", "experience-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum Enqueue extends Enum<Enqueue> {
        public static final Enqueue Head = null;
        public static final Enqueue Immediately = null;
        public static final Enqueue Tail = null;
        public static final /* synthetic */ Enqueue[] a = null;

        static {
            Enqueue r1 = new Enqueue("Tail", 0);
            Tail = r1;
            Enqueue r2 = new Enqueue("Head", 1);
            Head = r2;
            Enqueue r3 = new Enqueue("Immediately", 2);
            Immediately = r3;
            a = new Enqueue[]{r1, r2, r3};
        }

        public static Enqueue valueOf(String r1) {
            return (Enqueue) r27.a.a(Enqueue.class, r1);
        }

        public static Enqueue[] values() {
            return (Enqueue[]) a.clone();
        }

        public Enqueue(String r1, int r2) {
            super(r1, r2);
        }
    }

    public ScheduleParams() {
        this.a = a.c.b;
        this.b = Enqueue.Tail;
        this.d = new b71.a.b();
    }
}
