package com.bytedance.android.livesdk.interactivity.publicscreen.repository;

import com.bytedance.android.live.base.model.message.t;
import com.bytedance.bdlocation.BuildConfig;
import java.util.List;
import kotlin.Metadata;
import tlc.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public interface IPSMessageRepoManager {

    public interface Listener {

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/publicscreen/repository/IPSMessageRepoManager$Listener$Event;", BuildConfig.FLAVOR, "PAUSE", "RESUME", "UPDATE", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
        public static final enum Event extends Enum<Event> {
            public static final Event PAUSE = null;
            public static final Event RESUME = null;
            public static final Event UPDATE = null;
            public static final /* synthetic */ Event[] a = null;

            static {
                Event r1 = new Event("PAUSE", 0);
                PAUSE = r1;
                Event r2 = new Event("RESUME", 1);
                RESUME = r2;
                Event r3 = new Event("UPDATE", 2);
                UPDATE = r3;
                a = new Event[]{r1, r2, r3};
            }

            public static Event valueOf(String r1) {
                return (Event) r27.a.a(Event.class, r1);
            }

            public static Event[] values() {
                return (Event[]) a.clone();
            }

            public Event(String r1, int r2) {
                super(r1, r2);
            }
        }

        void a(List<? extends d> r1, boolean r2);

        void b(List<? extends d> r1, boolean r2);

        void c(List<? extends d> r1);

        void d(Event r1);

        void e(List r1);

        void f(List<? extends d> r1, boolean r2);

        void onFirstMessage(List<? extends d> r1, boolean r2);

        void onMessage(d r1);
    }

    void bind(Listener r1);

    void dynamicAddMessageType(String r1);

    boolean insertBackendTopMessage(List<? extends d> r1);

    void insertLocalMessage(t r1);

    void unbind(Listener r1);
}
