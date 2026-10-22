package com.larus.audio.call.tracer;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larus.audio.call.RealtimeCallParam;
import com.larus.audio.call.play.h;
import java.util.Map;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import ouc.d0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public interface IRealtimeCallTracer extends c {

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0015\b\u0086\u0081\u0002\u0018\u0000 \u00172\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0017B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016¨\u0006\u0018"}, d2 = {"Lcom/larus/audio/call/tracer/IRealtimeCallTracer$EnterCallSessionStatus;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "INITIAL", "INIT_ENGINE", "CREATE_HANDLE", "CREATE_CONNECTION", "UPDATE_ASR_CONFIG", "UPDATE_TTS_CONFIG", "START_TASK", "START_SESSION", "SOCKET_CONNECTED", "SOCKET_CONNECT_FAILED", "SOCKET_CONNECT_CLOSED", "TASK_STARTED", "TASK_FAILED", "SESSION_STARTED", "SESSION_FAILED", "Companion", "avkit_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final enum EnterCallSessionStatus extends Enum<EnterCallSessionStatus> {
        public static final EnterCallSessionStatus CREATE_CONNECTION = null;
        public static final EnterCallSessionStatus CREATE_HANDLE = null;
        public static final a Companion = null;
        public static final EnterCallSessionStatus INITIAL = null;
        public static final EnterCallSessionStatus INIT_ENGINE = null;
        public static final EnterCallSessionStatus SESSION_FAILED = null;
        public static final EnterCallSessionStatus SESSION_STARTED = null;
        public static final EnterCallSessionStatus SOCKET_CONNECTED = null;
        public static final EnterCallSessionStatus SOCKET_CONNECT_CLOSED = null;
        public static final EnterCallSessionStatus SOCKET_CONNECT_FAILED = null;
        public static final EnterCallSessionStatus START_SESSION = null;
        public static final EnterCallSessionStatus START_TASK = null;
        public static final EnterCallSessionStatus TASK_FAILED = null;
        public static final EnterCallSessionStatus TASK_STARTED = null;
        public static final EnterCallSessionStatus UPDATE_ASR_CONFIG = null;
        public static final EnterCallSessionStatus UPDATE_TTS_CONFIG = null;
        public static final /* synthetic */ EnterCallSessionStatus[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final int value;

        public static final class a {
            public a() {
            }

            public static EnterCallSessionStatus a(int r1) {
                if (r1 == 20) goto L28;
                if (r1 == 21) goto L43;
                if (r1 == 30) goto L42;
                if (r1 == 31) goto L41;
                switch(r1) {
                    case 0: goto L37;
                    case 1: goto L36;
                    case 2: goto L35;
                    case 3: goto L34;
                    case 4: goto L33;
                    case 5: goto L32;
                    case 6: goto L31;
                    case 7: goto L30;
                    default: goto L11;
                };
            L11:
                switch(r1) {
                    case 10: goto L40;
                    case 11: goto L39;
                    case 12: goto L38;
                    default: goto L12;
                };
            L12:
                return null;
            L38:
                return EnterCallSessionStatus.SOCKET_CONNECT_CLOSED;
            L39:
                return EnterCallSessionStatus.SOCKET_CONNECT_FAILED;
            L40:
                return EnterCallSessionStatus.SOCKET_CONNECTED;
            L30:
                return EnterCallSessionStatus.START_SESSION;
            L31:
                return EnterCallSessionStatus.START_TASK;
            L32:
                return EnterCallSessionStatus.UPDATE_TTS_CONFIG;
            L33:
                return EnterCallSessionStatus.UPDATE_ASR_CONFIG;
            L34:
                return EnterCallSessionStatus.CREATE_CONNECTION;
            L35:
                return EnterCallSessionStatus.CREATE_HANDLE;
            L36:
                return EnterCallSessionStatus.INIT_ENGINE;
            L37:
                return EnterCallSessionStatus.INITIAL;
            L41:
                return EnterCallSessionStatus.SESSION_FAILED;
            L42:
                return EnterCallSessionStatus.SESSION_STARTED;
            L43:
                return EnterCallSessionStatus.TASK_FAILED;
            L28:
                return EnterCallSessionStatus.TASK_STARTED;
            }
        }

        public static EnumEntries<EnterCallSessionStatus> getEntries() {
            return b;
        }

        static {
            EnterCallSessionStatus r0 = new EnterCallSessionStatus("INITIAL", 0, 0);
            INITIAL = r0;
            EnterCallSessionStatus r1 = new EnterCallSessionStatus("INIT_ENGINE", 1, 1);
            INIT_ENGINE = r1;
            EnterCallSessionStatus r3 = new EnterCallSessionStatus("CREATE_HANDLE", 2, 2);
            CREATE_HANDLE = r3;
            EnterCallSessionStatus r5 = new EnterCallSessionStatus("CREATE_CONNECTION", 3, 3);
            CREATE_CONNECTION = r5;
            EnterCallSessionStatus r7 = new EnterCallSessionStatus("UPDATE_ASR_CONFIG", 4, 4);
            UPDATE_ASR_CONFIG = r7;
            EnterCallSessionStatus r9 = new EnterCallSessionStatus("UPDATE_TTS_CONFIG", 5, 5);
            UPDATE_TTS_CONFIG = r9;
            EnterCallSessionStatus r11 = new EnterCallSessionStatus("START_TASK", 6, 6);
            START_TASK = r11;
            EnterCallSessionStatus r13 = new EnterCallSessionStatus("START_SESSION", 7, 7);
            START_SESSION = r13;
            EnterCallSessionStatus r15 = new EnterCallSessionStatus("SOCKET_CONNECTED", 8, 10);
            SOCKET_CONNECTED = r15;
            EnterCallSessionStatus r14 = new EnterCallSessionStatus("SOCKET_CONNECT_FAILED", 9, 11);
            SOCKET_CONNECT_FAILED = r14;
            EnterCallSessionStatus r12 = new EnterCallSessionStatus("SOCKET_CONNECT_CLOSED", 10, 12);
            SOCKET_CONNECT_CLOSED = r12;
            EnterCallSessionStatus r8 = new EnterCallSessionStatus("TASK_STARTED", 11, 20);
            TASK_STARTED = r8;
            EnterCallSessionStatus r2 = new EnterCallSessionStatus("TASK_FAILED", 12, 21);
            TASK_FAILED = r2;
            EnterCallSessionStatus r6 = new EnterCallSessionStatus("SESSION_STARTED", 13, 30);
            SESSION_STARTED = r6;
            EnterCallSessionStatus r4 = new EnterCallSessionStatus("SESSION_FAILED", 14, 31);
            SESSION_FAILED = r4;
            EnterCallSessionStatus[] r10 = {r0, r1, r3, r5, r7, r9, r11, r13, r15, r14, r12, r8, r2, r6, r4};
            a = r10;
            b = EnumEntriesKt.enumEntries(r10);
            Companion = new a();
        }

        public static EnterCallSessionStatus[] values() {
            return (EnterCallSessionStatus[]) a.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public static EnterCallSessionStatus valueOf(String r1) {
            return (EnterCallSessionStatus) r27.a.a(EnterCallSessionStatus.class, r1);
        }

        public EnterCallSessionStatus(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/larus/audio/call/tracer/IRealtimeCallTracer$HelloStatus;", "", "<init>", "(Ljava/lang/String;I)V", "START_SESSION", "SESSION_SUCCESS", "TRIGGER_HELLO", "PLAY_HELLO", "INTERRUPT", "PLAY_END", "HELLO_RESET", "avkit_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final enum HelloStatus extends Enum<HelloStatus> {
        public static final HelloStatus HELLO_RESET = null;
        public static final HelloStatus INTERRUPT = null;
        public static final HelloStatus PLAY_END = null;
        public static final HelloStatus PLAY_HELLO = null;
        public static final HelloStatus SESSION_SUCCESS = null;
        public static final HelloStatus START_SESSION = null;
        public static final HelloStatus TRIGGER_HELLO = null;
        public static final /* synthetic */ HelloStatus[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<HelloStatus> getEntries() {
            return b;
        }

        static {
            HelloStatus r0 = new HelloStatus("START_SESSION", 0);
            START_SESSION = r0;
            HelloStatus r1 = new HelloStatus("SESSION_SUCCESS", 1);
            SESSION_SUCCESS = r1;
            HelloStatus r3 = new HelloStatus("TRIGGER_HELLO", 2);
            TRIGGER_HELLO = r3;
            HelloStatus r5 = new HelloStatus("PLAY_HELLO", 3);
            PLAY_HELLO = r5;
            HelloStatus r7 = new HelloStatus("INTERRUPT", 4);
            INTERRUPT = r7;
            HelloStatus r9 = new HelloStatus("PLAY_END", 5);
            PLAY_END = r9;
            HelloStatus r11 = new HelloStatus("HELLO_RESET", 6);
            HELLO_RESET = r11;
            HelloStatus[] r13 = {r0, r1, r3, r5, r7, r9, r11};
            a = r13;
            b = EnumEntriesKt.enumEntries(r13);
        }

        public static HelloStatus[] values() {
            return (HelloStatus[]) a.clone();
        }

        public static HelloStatus valueOf(String r1) {
            return (HelloStatus) r27.a.a(HelloStatus.class, r1);
        }

        public HelloStatus(String r1, int r2) {
            super(r1, r2);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/larus/audio/call/tracer/IRealtimeCallTracer$TotalTimeType;", "", "<init>", "(Ljava/lang/String;I)V", "SCREEN_SHARE_START_TIME", "SCREEN_SHARE_IN_APP", "VIDEO_SHARE_START_TIME", "SUBTITLE", "PAUSE", "USER_SPEAK", "MUTE", "avkit_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final enum TotalTimeType extends Enum<TotalTimeType> {
        public static final TotalTimeType MUTE = null;
        public static final TotalTimeType PAUSE = null;
        public static final TotalTimeType SCREEN_SHARE_IN_APP = null;
        public static final TotalTimeType SCREEN_SHARE_START_TIME = null;
        public static final TotalTimeType SUBTITLE = null;
        public static final TotalTimeType USER_SPEAK = null;
        public static final TotalTimeType VIDEO_SHARE_START_TIME = null;
        public static final /* synthetic */ TotalTimeType[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<TotalTimeType> getEntries() {
            return b;
        }

        static {
            TotalTimeType r0 = new TotalTimeType("SCREEN_SHARE_START_TIME", 0);
            SCREEN_SHARE_START_TIME = r0;
            TotalTimeType r1 = new TotalTimeType("SCREEN_SHARE_IN_APP", 1);
            SCREEN_SHARE_IN_APP = r1;
            TotalTimeType r3 = new TotalTimeType("VIDEO_SHARE_START_TIME", 2);
            VIDEO_SHARE_START_TIME = r3;
            TotalTimeType r5 = new TotalTimeType("SUBTITLE", 3);
            SUBTITLE = r5;
            TotalTimeType r7 = new TotalTimeType("PAUSE", 4);
            PAUSE = r7;
            TotalTimeType r9 = new TotalTimeType("USER_SPEAK", 5);
            USER_SPEAK = r9;
            TotalTimeType r11 = new TotalTimeType("MUTE", 6);
            MUTE = r11;
            TotalTimeType[] r13 = {r0, r1, r3, r5, r7, r9, r11};
            a = r13;
            b = EnumEntriesKt.enumEntries(r13);
        }

        public static TotalTimeType[] values() {
            return (TotalTimeType[]) a.clone();
        }

        public static TotalTimeType valueOf(String r1) {
            return (TotalTimeType) r27.a.a(TotalTimeType.class, r1);
        }

        public TotalTimeType(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final class a {
        public static /* synthetic */ void a(IRealtimeCallTracer r7, long r8, long r10) {
            r7.h0(r8, r10, null, null);
        }
    }

    void A(RealtimeCallParam r1, String r2, String r3, String r4);

    void B(TotalTimeType r1, boolean r2);

    void C(RealtimeCallParam r1);

    void D(boolean r1);

    void E();

    void F(boolean r1);

    void G(boolean r1);

    void H(String r1, String r2);

    void I();

    void J(int r1, String r2, int r3);

    void K(Map<String, ? extends Object> r1);

    void L(RealtimeCallParam r1, int r2, String r3, String r4, Long r5, Long r6, String r7);

    void M(String r1, String r2, String r3, Long r4, String r5);

    void O(String r1, RealtimeCallParam r2);

    void P(RealtimeCallParam r1, Long r2, String r3, String r4, String r5);

    void Q(HelloStatus r1, String r2);

    boolean R();

    void S();

    void T(String r1, String r2);

    void U(int r1, String r2, long r3, RealtimeCallParam r5, Boolean r6, int r7, String r8, String r9);

    void W();

    void Z(RealtimeCallParam r1, int r2);

    void a0(Flow<Integer> r1, CoroutineScope r2, RealtimeCallParam r3);

    void b0(RealtimeCallParam r1);

    void c();

    void c0(long r1);

    void d(h.a r1);

    void d0(RealtimeCallParam r1, int r2, long r3, long r5, boolean r7, String r8, String r9, String r10, Long r11, Long r12, String r13);

    void e(String r1, String r2, String r3, String r4);

    void e0(String r1, String r2, RealtimeCallParam r3, e3a.a r4);

    void f(RealtimeCallParam r1, String r2, boolean r3, EnterCallSessionStatus r4, Integer r5, long r6, boolean r8);

    void f0(boolean r1);

    void g();

    void g0(String r1, String r2, String r3, String r4);

    void h(jd9.c r1);

    void h0(long r1, long r3, String r5, String r6);

    void i(byte[] r1);

    void i0();

    void j(RealtimeCallParam r1, boolean r2, EnterCallSessionStatus r3, long r4, long r6, boolean r8);

    void j0(boolean r1);

    void k(long r1);

    void k0(String r1, RealtimeCallParam r2, boolean r3, e3a.a r4);

    void l(String r1, String r2, String r3, String r4, String r5);

    void l0(RealtimeCallParam r1, String r2);

    void m(RealtimeCallParam r1, boolean r2);

    void m0(String r1);

    void n(RealtimeCallParam r1, String r2);

    void n0();

    void o(String r1, long r2, boolean r4, boolean r5, boolean r6, long r7, long r9, String r11, String r12);

    void o0();

    void p(String r1);

    void p0(RealtimeCallParam r1, EnterCallSessionStatus r2, String r3, int r4, String r5, Boolean r6);

    void q(boolean r1, long r2);

    void r();

    void r0(int r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8);

    void reportEvent(String r1, Map<String, Object> r2);

    void s(String r1);

    void s0();

    void t();

    void t0();

    void u0();

    void v(boolean r1);

    void w(RealtimeCallParam r1, int r2, boolean r3, String r4, String r5, long r6, String r8);

    d0 x(d0 r1);

    void y(String r1, RealtimeCallParam r2, d0 r3);

    void z(String r1, String r2, String r3, String r4);
}
