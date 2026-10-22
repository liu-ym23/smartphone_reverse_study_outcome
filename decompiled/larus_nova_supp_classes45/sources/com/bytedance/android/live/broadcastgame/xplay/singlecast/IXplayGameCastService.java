package com.bytedance.android.live.broadcastgame.xplay.singlecast;

import kotlin.Metadata;
import kotlin.Pair;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public interface IXplayGameCastService {

    public interface IGameCastSession {

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/xplay/singlecast/IXplayGameCastService$IGameCastSession$Event;", "", "CastStarted", "CastStopped", "CastMinimized", "CastResumed", "ResumeCastClicked", "livebroadcastgame-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
        public static final enum Event extends Enum<Event> {
            public static final Event CastMinimized = null;
            public static final Event CastResumed = null;
            public static final Event CastStarted = null;
            public static final Event CastStopped = null;
            public static final Event ResumeCastClicked = null;
            public static final /* synthetic */ Event[] a = null;

            static {
                Event r1 = new Event("CastStarted", 0);
                CastStarted = r1;
                Event r2 = new Event("CastStopped", 1);
                CastStopped = r2;
                Event r3 = new Event("CastMinimized", 2);
                CastMinimized = r3;
                Event r4 = new Event("CastResumed", 3);
                CastResumed = r4;
                Event r5 = new Event("ResumeCastClicked", 4);
                ResumeCastClicked = r5;
                a = new Event[]{r1, r2, r3, r4, r5};
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

        void stop();
    }

    XplayGameCastService.GameCastSessionImpl a(Pair r1);
}
