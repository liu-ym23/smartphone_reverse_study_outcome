package com.bytedance.android.live.broadcastgame.xplay;

import android.view.View;
import io.reactivex.subjects.PublishSubject;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public interface IXplayCoreService {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/xplay/IXplayCoreService$State;", "", "Stopped", "Loading", "Loaded", "Running", "SwitchToGuide", "SwitchToHost", "livebroadcastgame-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum State extends Enum<State> {
        public static final State Loaded = null;
        public static final State Loading = null;
        public static final State Running = null;
        public static final State Stopped = null;
        public static final State SwitchToGuide = null;
        public static final State SwitchToHost = null;
        public static final /* synthetic */ State[] a = null;

        static {
            State r1 = new State("Stopped", 0);
            Stopped = r1;
            State r2 = new State("Loading", 1);
            Loading = r2;
            State r3 = new State("Loaded", 2);
            Loaded = r3;
            State r4 = new State("Running", 3);
            Running = r4;
            State r5 = new State("SwitchToGuide", 4);
            SwitchToGuide = r5;
            State r6 = new State("SwitchToHost", 5);
            SwitchToHost = r6;
            a = new State[]{r1, r2, r3, r4, r5, r6};
        }

        public static State valueOf(String r1) {
            return (State) r27.a.a(State.class, r1);
        }

        public static State[] values() {
            return (State[]) a.clone();
        }

        public State(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final class a {
        public final String a;
        public final String b;
        public final int c;
        public final int d;
        public final int e;
        public final int f;
        public final String g;
        public final String h;
        public final int i;
        public final boolean j;
        public final Map<String, String> k;
        public final int l;
        public final XplayApi.i m;
        public final Long n;
        public final boolean o;

        public final boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof a) == false) goto L36;
            a r4 = (a) r3;
            if (Intrinsics.areEqual(this.a, r4.a) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.b, r4.b) == true) goto L10;
            return false;
        L10:
            if (this.c == r4.c) goto L12;
            return false;
        L12:
            if (this.d == r4.d) goto L14;
            return false;
        L14:
            if (this.e == r4.e) goto L16;
            return false;
        L16:
            if (this.f == r4.f) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.g, r4.g) == true) goto L20;
            return false;
        L20:
            if (Intrinsics.areEqual(this.h, r4.h) == true) goto L22;
            return false;
        L22:
            if (this.i == r4.i) goto L24;
            return false;
        L24:
            if (this.j == r4.j) goto L26;
            return false;
        L26:
            if (Intrinsics.areEqual(this.k, r4.k) == true) goto L28;
            return false;
        L28:
            if (this.l == r4.l) goto L30;
            return false;
        L30:
            if (Intrinsics.areEqual(this.m, r4.m) == true) goto L32;
            return false;
        L32:
            if (Intrinsics.areEqual(this.n, r4.n) == true) goto L34;
            return false;
        L34:
            if (this.o == r4.o) goto L55;
            return false;
        L55:
            return true;
        L36:
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v20, types: [int] */
        /* JADX WARN: Type inference failed for: r0v30, types: [int] */
        /* JADX WARN: Type inference failed for: r2v15, types: [int] */
        /* JADX WARN: Type inference failed for: r2v26 */
        /* JADX WARN: Type inference failed for: r2v30 */
        /* JADX WARN: Type inference failed for: r3v0 */
        /* JADX WARN: Type inference failed for: r3v1, types: [int] */
        /* JADX WARN: Type inference failed for: r3v2 */
        public final int hashCode() {
            String r0 = this.a;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = r0.hashCode();
        L6:
            int r3 = r2 * 31;
            String r4 = this.b;
            if (r4 == null) goto L9;
            int r5 = r4.hashCode();
        L10:
            int r6 = (((((((((r3 + r5) * 31) + this.c) * 31) + this.d) * 31) + this.e) * 31) + this.f) * 31;
            String r7 = this.g;
            if (r7 == null) goto L13;
            int r8 = r7.hashCode();
        L14:
            int r9 = (r6 + r8) * 31;
            String r11 = this.h;
            if (r11 == null) goto L17;
            int r12 = r11.hashCode();
        L18:
            int r13 = (((r9 + r12) * 31) + this.i) * 31;
            boolean r14 = this.j;
            ?? r15 = 1;
            ?? r16 = r14;
            if (r14 == false) goto L21;
            r16 = 1;
        L21:
            int r17 = (r13 + r16) * 31;
            Map<String, String> r18 = this.k;
            if (r18 == null) goto L24;
            int r19 = r18.hashCode();
        L25:
            int r21 = (((r17 + r19) * 31) + this.l) * 31;
            XplayApi.i r22 = this.m;
            if (r22 == null) goto L28;
            int r23 = r22.hashCode();
        L29:
            int r24 = (r21 + r23) * 31;
            Long r25 = this.n;
            if (r25 == null) goto L32;
            r1 = r25.hashCode();
        L32:
            int r26 = (r24 + r1) * 31;
            boolean r27 = this.o;
            if (r27 == true) goto L37;
            r15 = r27;
        L37:
            return r26 + r15;
        L28:
            r23 = 0;
            goto L29
        L24:
            r19 = 0;
            goto L25
        L17:
            r12 = 0;
            goto L18
        L13:
            r8 = 0;
            goto L14
        L9:
            r5 = 0;
            goto L10
        L5:
            r2 = 0;
            goto L6
        }

        public final String toString() {
            return "StartParams(gameId=" + this.a + ", channel=" + this.b + ", displayWidth=" + this.c + ", displayHeight=" + this.d + ", widthRatio=" + this.e + ", heightRatio=" + this.f + ", token=" + this.g + ", openId=" + this.h + ", pushStreamType=" + this.i + ", useTextureView=" + this.j + ", extraToServer=" + this.k + ", pushStreamMode=" + this.l + ", podRtcInfo=" + this.m + ", audioMixType=" + this.n + ", useFullScreen=" + this.o + ")";
        }

        public a(String r2, String r3, int r4, int r5, int r6, int r7, String r8, String r9, int r11, boolean r12, Map r13, XplayApi.i r14, Long r15, boolean r16) {
            Intrinsics.checkNotNullParameter(r2, "gameId");
            Intrinsics.checkNotNullParameter(r3, "channel");
            Intrinsics.checkNotNullParameter(r8, "token");
            Intrinsics.checkNotNullParameter(r9, "openId");
            Intrinsics.checkNotNullParameter(r13, "extraToServer");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
            this.e = r6;
            this.f = r7;
            this.g = r8;
            this.h = r9;
            this.i = r11;
            this.j = r12;
            this.k = r13;
            this.l = 2;
            this.m = r14;
            this.n = r15;
            this.o = r16;
        }
    }

    void I();

    void J();

    View K();

    PublishSubject L();

    PublishSubject N();

    void R();

    void S(a r1);

    a U();

    PublishSubject X();

    View Y();

    Boolean g();

    PublishSubject getOnError();

    String getRtcExtInfo();

    State getState();

    void pauseGame();

    void resumeGame();

    void setRtcExtInfo(String r1);

    void updateEnableAudioFrame(boolean r1);

    void updateEnableVideoFrame(boolean r1);
}
