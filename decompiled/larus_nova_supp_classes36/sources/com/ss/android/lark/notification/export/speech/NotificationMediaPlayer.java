package com.ss.android.lark.notification.export.speech;

import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class NotificationMediaPlayer {
    public static final /* synthetic */ int a = 0;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/ss/android/lark/notification/export/speech/NotificationMediaPlayer$State;", "", "<init>", "(Ljava/lang/String;I)V", "IDLE", "INITIALIZED", "PREPARING", "PREPARED", "STARTED", "STOPPED", "END", "notification-export_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
    public static final enum State extends Enum<State> {
        public static final State END = null;
        public static final State IDLE = null;
        public static final State INITIALIZED = null;
        public static final State PREPARED = null;
        public static final State PREPARING = null;
        public static final State STARTED = null;
        public static final State STOPPED = null;
        public static final /* synthetic */ State[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<State> getEntries() {
            return b;
        }

        static {
            State r0 = new State("IDLE", 0);
            IDLE = r0;
            State r1 = new State("INITIALIZED", 1);
            INITIALIZED = r1;
            State r3 = new State("PREPARING", 2);
            PREPARING = r3;
            State r5 = new State("PREPARED", 3);
            PREPARED = r5;
            State r7 = new State("STARTED", 4);
            STARTED = r7;
            State r9 = new State("STOPPED", 5);
            STOPPED = r9;
            State r11 = new State("END", 6);
            END = r11;
            State[] r13 = {r0, r1, r3, r5, r7, r9, r11};
            a = r13;
            b = EnumEntriesKt.enumEntries(r13);
        }

        public static State[] values() {
            return (State[]) a.clone();
        }

        public static State valueOf(String r1) {
            return (State) r27.a.a(State.class, r1);
        }

        public State(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final class a {
    }

    static {
    }
}
