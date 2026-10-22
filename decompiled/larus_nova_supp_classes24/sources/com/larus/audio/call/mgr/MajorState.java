package com.larus.audio.call.mgr;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public abstract class MajorState {
    public final int a;
    public final String b;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/larus/audio/call/mgr/MajorState$CheckResult;", "", "move", "", "dispatch", "<init>", "(Ljava/lang/String;IZZ)V", "getMove", "()Z", "getDispatch", "NORMAL", "INTERCEPT", "UNDISPATCH", "avkit_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final enum CheckResult extends Enum<CheckResult> {
        public static final CheckResult INTERCEPT = null;
        public static final CheckResult NORMAL = null;
        public static final CheckResult UNDISPATCH = null;
        public static final /* synthetic */ CheckResult[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final boolean dispatch;
        private final boolean move;

        public static EnumEntries<CheckResult> getEntries() {
            return b;
        }

        static {
            CheckResult r0 = new CheckResult("NORMAL", 0, true, true);
            NORMAL = r0;
            CheckResult r1 = new CheckResult("INTERCEPT", 1, false, false);
            INTERCEPT = r1;
            CheckResult r4 = new CheckResult("UNDISPATCH", 2, true, false);
            UNDISPATCH = r4;
            CheckResult[] r5 = {r0, r1, r4};
            a = r5;
            b = EnumEntriesKt.enumEntries(r5);
        }

        public static CheckResult[] values() {
            return (CheckResult[]) a.clone();
        }

        public final boolean getDispatch() {
            return this.dispatch;
        }

        public final boolean getMove() {
            return this.move;
        }

        public static CheckResult valueOf(String r1) {
            return (CheckResult) r27.a.a(CheckResult.class, r1);
        }

        public CheckResult(String r1, int r2, boolean r3, boolean r4) {
            super(r1, r2);
            this.move = r3;
            this.dispatch = r4;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/larus/audio/call/mgr/MajorState$From;", "", "<init>", "(Ljava/lang/String;I)V", "ASR", "TTS_ENDED", "PLAY_COMPLETE", "RESUME", "avkit_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final enum From extends Enum<From> {
        public static final From ASR = null;
        public static final From PLAY_COMPLETE = null;
        public static final From RESUME = null;
        public static final From TTS_ENDED = null;
        public static final /* synthetic */ From[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<From> getEntries() {
            return b;
        }

        static {
            From r0 = new From("ASR", 0);
            ASR = r0;
            From r1 = new From("TTS_ENDED", 1);
            TTS_ENDED = r1;
            From r3 = new From("PLAY_COMPLETE", 2);
            PLAY_COMPLETE = r3;
            From r5 = new From("RESUME", 3);
            RESUME = r5;
            From[] r7 = {r0, r1, r3, r5};
            a = r7;
            b = EnumEntriesKt.enumEntries(r7);
        }

        public static From[] values() {
            return (From[]) a.clone();
        }

        public static From valueOf(String r1) {
            return (From) r27.a.a(From.class, r1);
        }

        public From(String r1, int r2) {
            super(r1, r2);
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/larus/audio/call/mgr/MajorState$InterruptType;", "", "interrupt", "", "<init>", "(Ljava/lang/String;IZ)V", "getInterrupt", "()Z", "NOTHING", "USER", "AUTO", "avkit_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final enum InterruptType extends Enum<InterruptType> {
        public static final InterruptType AUTO = null;
        public static final InterruptType NOTHING = null;
        public static final InterruptType USER = null;
        public static final /* synthetic */ InterruptType[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final boolean interrupt;

        public static EnumEntries<InterruptType> getEntries() {
            return b;
        }

        static {
            InterruptType r0 = new InterruptType("NOTHING", 0, false);
            NOTHING = r0;
            InterruptType r1 = new InterruptType("USER", 1, true);
            USER = r1;
            InterruptType r3 = new InterruptType("AUTO", 2, true);
            AUTO = r3;
            InterruptType[] r5 = {r0, r1, r3};
            a = r5;
            b = EnumEntriesKt.enumEntries(r5);
        }

        public static InterruptType[] values() {
            return (InterruptType[]) a.clone();
        }

        public final boolean getInterrupt() {
            return this.interrupt;
        }

        public static InterruptType valueOf(String r1) {
            return (InterruptType) r27.a.a(InterruptType.class, r1);
        }

        public InterruptType(String r1, int r2, boolean r3) {
            super(r1, r2);
            this.interrupt = r3;
        }
    }

    public static final class a extends MajorState {
        public static final a c = null;

        static {
            c = new a();
        }

        @Override // com.larus.audio.call.mgr.MajorState
        public final String toString() {
            return "Connecting";
        }

        public a() {
            super(1, "connection");
        }
    }

    public static final class b extends MajorState {
        public static final b c = null;

        static {
            c = new b();
        }

        @Override // com.larus.audio.call.mgr.MajorState
        public final String toString() {
            return "Ending";
        }

        public b() {
            super(18, "Ending");
        }

        @Override // com.larus.audio.call.mgr.MajorState
        public final CheckResult a(MajorState r2) {
            Intrinsics.checkNotNullParameter(r2, "next");
            if ((r2 instanceof h) == false) goto L7;
            return CheckResult.INTERCEPT;
        L7:
            return super.a(r2);
        }
    }

    public static final class c extends MajorState {
        public static final c c = null;

        static {
            c = new c();
        }

        @Override // com.larus.audio.call.mgr.MajorState
        public final String toString() {
            return "Invalid";
        }

        public c() {
            super(-1, "invalid");
        }
    }

    public static final class d extends MajorState {
        public final From c;
        public final InterruptType d;

        @Override // com.larus.audio.call.mgr.MajorState
        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof d) == true) goto L8;
            return false;
        L8:
            d r6 = (d) r5;
            if (this.c == r6.c) goto L12;
            return false;
        L12:
            if (this.d == r6.d) goto L14;
            return false;
        L14:
            return true;
        }

        @Override // com.larus.audio.call.mgr.MajorState
        public final int hashCode() {
            return (this.c.hashCode() * 31) + this.d.hashCode();
        }

        @Override // com.larus.audio.call.mgr.MajorState
        public final String toString() {
            return "Listening(from=" + this.c + ", interruptType=" + this.d + ')';
        }

        public d(From r3, InterruptType r4) {
            Intrinsics.checkNotNullParameter(r3, "from");
            Intrinsics.checkNotNullParameter(r4, "interruptType");
            super(3, "listening");
            this.c = r3;
            this.d = r4;
        }
    }

    public static final class e extends MajorState {
        public static final e c = null;

        static {
            c = new e();
        }

        @Override // com.larus.audio.call.mgr.MajorState
        public final String toString() {
            return "ListeningAndSpeaking";
        }

        public e() {
            super(17, "listening_and_speaking");
        }
    }

    public static final class f extends MajorState {
        public final int c;
        public final int d;
        public final String e;
        public final Integer f;

        public f() {
            int r2 = 0;
            this(r2, r2, null, 15);
        }

        public /* synthetic */ f(int r3, int r4, String r5, int r6) {
            if ((r6 & 1) == 0) goto L6;
            r3 = -1;
        L6:
            if ((r6 & 2) == 0) goto L9;
            r4 = -1;
        L9:
            if ((r6 & 4) == 0) goto L11;
            r5 = "";
        L11:
            this(r3, r4, r5, null);
        }

        public f(int r3, int r4, String r5, Integer r6) {
            Intrinsics.checkNotNullParameter(r5, "errorMsgDetail");
            super(6, "network_error");
            this.c = r3;
            this.d = r4;
            this.e = r5;
            this.f = r6;
        }
    }

    public static final class g extends MajorState {
        public final MajorState c;

        @Override // com.larus.audio.call.mgr.MajorState
        public final int hashCode() {
            return this.c.hashCode();
        }

        @Override // com.larus.audio.call.mgr.MajorState
        public final String toString() {
            return "Paused(prev=" + this.c + ')';
        }

        public g(MajorState r3) {
            Intrinsics.checkNotNullParameter(r3, "state");
            super(7, "paused");
            if ((r3 instanceof g) == false) goto L5;
            r3 = ((g) r3).c;
        L5:
            this.c = r3;
        }

        @Override // com.larus.audio.call.mgr.MajorState
        public final CheckResult a(MajorState r2) {
            Intrinsics.checkNotNullParameter(r2, "next");
            if ((r2 instanceof g) == false) goto L7;
            return CheckResult.UNDISPATCH;
        L7:
            return super.a(r2);
        }

        @Override // com.larus.audio.call.mgr.MajorState
        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if (r4 != null) goto L9;
            return false;
        L9:
            if (g.class == r4.getClass()) goto L12;
            return false;
        L12:
            return Intrinsics.areEqual(this.c, ((g) r4).c);
        }
    }

    public static final class h extends MajorState {
        public static final h c = null;

        static {
            c = new h();
        }

        @Override // com.larus.audio.call.mgr.MajorState
        public final String toString() {
            return "Speaking";
        }

        public h() {
            super(5, "speaking");
        }
    }

    public static class i extends MajorState {

        public static final class a extends i {
            @Override // com.larus.audio.call.mgr.MajorState.i, com.larus.audio.call.mgr.MajorState
            public final String toString() {
                return "DeepThinking";
            }

            public a() {
                super("deep_thinking");
            }
        }

        @Override // com.larus.audio.call.mgr.MajorState
        public String toString() {
            return "Thinking";
        }

        public /* synthetic */ i() {
            this("thinking");
        }

        public i(String r2) {
            Intrinsics.checkNotNullParameter(r2, "desc");
            super(4, r2);
        }

        @Override // com.larus.audio.call.mgr.MajorState
        public final CheckResult a(MajorState r4) {
            Intrinsics.checkNotNullParameter(r4, "next");
            if ((r4 instanceof d) == false) goto L11;
            d r0 = (d) r4;
            if (r0.c != From.PLAY_COMPLETE) goto L11;
            if (r0.d.getInterrupt() == true) goto L11;
            return CheckResult.INTERCEPT;
        L11:
            return super.a(r4);
        }
    }

    public static final class j extends MajorState {
        public static final j c = null;

        static {
            c = new j();
        }

        @Override // com.larus.audio.call.mgr.MajorState
        public final String toString() {
            return "Waiting";
        }

        public j() {
            super(2, "waiting");
        }
    }

    public int hashCode() {
        return (this.a * 31) + this.b.hashCode();
    }

    public String toString() {
        String r0 = Reflection.getOrCreateKotlinClass(getClass()).getSimpleName();
        if (r0 != null) goto L6;
        return "";
    L6:
        return r0;
    }

    public CheckResult a(MajorState r2) {
        Intrinsics.checkNotNullParameter(r2, "next");
        if (Intrinsics.areEqual(this, r2) == false) goto L7;
        return CheckResult.INTERCEPT;
    L7:
        if ((this instanceof f) == true) goto L13;
        if ((r2 instanceof c) == false) goto L13;
        return CheckResult.INTERCEPT;
    L13:
        return CheckResult.NORMAL;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof MajorState) == true) goto L8;
        return false;
    L8:
        MajorState r6 = (MajorState) r5;
        if (this.a == r6.a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public MajorState(int r1, String r2) {
        this.a = r1;
        this.b = r2;
    }
}
