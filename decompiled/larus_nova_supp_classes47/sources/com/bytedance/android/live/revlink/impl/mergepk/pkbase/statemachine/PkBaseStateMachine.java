package com.bytedance.android.live.revlink.impl.mergepk.pkbase.statemachine;

import com.bytedance.android.live.link.data.RevPkState;
import com.bytedance.live.kmp.statemachine.StateMachine;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class PkBaseStateMachine {
    public final StateMachine<c, a, b> a;
    public final Function1<StateMachine.c<? extends c, ? extends a, ? extends b>, Unit> b;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0018\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/mergepk/pkbase/statemachine/PkBaseStateMachine$Source;", "", "", "reqSrc", "Ljava/lang/String;", "getReqSrc", "()Ljava/lang/String;", "Init", "BattleMsg", "MetaUpdate", "PKTimeUp", "BattleFinishInstantKill", "BattleFinishTimeUp", "PunishTimeUp", "LinkerLeave", "RtcLinkerLeave", "CutShort", "MultipleInvite", "BattleFinishResponse", "DoublePkLinkInPeak", "RoomClose", "NormalToMultiple", "ScoreControl", "ChangeMode", "RelinkSuccess", "StartOpenGame", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final enum Source extends Enum<Source> {
        public static final Source BattleFinishInstantKill = null;
        public static final Source BattleFinishResponse = null;
        public static final Source BattleFinishTimeUp = null;
        public static final Source BattleMsg = null;
        public static final Source ChangeMode = null;
        public static final Source CutShort = null;
        public static final Source DoublePkLinkInPeak = null;
        public static final Source Init = null;
        public static final Source LinkerLeave = null;
        public static final Source MetaUpdate = null;
        public static final Source MultipleInvite = null;
        public static final Source NormalToMultiple = null;
        public static final Source PKTimeUp = null;
        public static final Source PunishTimeUp = null;
        public static final Source RelinkSuccess = null;
        public static final Source RoomClose = null;
        public static final Source RtcLinkerLeave = null;
        public static final Source ScoreControl = null;
        public static final Source StartOpenGame = null;
        public static final /* synthetic */ Source[] a = null;
        private final String reqSrc;

        public static Source valueOf(String r1) {
            return (Source) r27.a.a(Source.class, r1);
        }

        public static Source[] values() {
            return (Source[]) a.clone();
        }

        static {
            DefaultConstructorMarker r6 = null;
            Source r7 = new Source("Init", 0, null, 1, r6);
            Init = r7;
            Source r1 = new Source("BattleMsg", 1, null, 1, null);
            BattleMsg = r1;
            Source r2 = new Source("MetaUpdate", 2, r6, 1, null);
            MetaUpdate = r2;
            Source r3 = new Source("PKTimeUp", 3, "PKTimeUp");
            PKTimeUp = r3;
            DefaultConstructorMarker r9 = null;
            Source r4 = new Source("BattleFinishInstantKill", 4, null, 1, r9);
            BattleFinishInstantKill = r4;
            Source r5 = new Source("BattleFinishTimeUp", 5, null, 1, null);
            BattleFinishTimeUp = r5;
            Source r8 = new Source("PunishTimeUp", 6, "PunishTimeUp");
            PunishTimeUp = r8;
            String r10 = null;
            int r12 = 1;
            Source r13 = new Source("LinkerLeave", 7, r10, r12, r9);
            LinkerLeave = r13;
            Source r14 = new Source("RtcLinkerLeave", 8, "RtcLinkerLeave");
            RtcLinkerLeave = r14;
            Source r15 = new Source("CutShort", 9, "CutShort");
            CutShort = r15;
            Source r16 = new Source("MultipleInvite", 10, r10, r12, r9);
            MultipleInvite = r16;
            String r17 = null;
            int r18 = 1;
            DefaultConstructorMarker r19 = null;
            Source r20 = new Source("BattleFinishResponse", 11, r17, r18, r19);
            BattleFinishResponse = r20;
            Source r22 = new Source("DoublePkLinkInPeak", 12, r17, r18, r19);
            DoublePkLinkInPeak = r22;
            Source r23 = new Source("RoomClose", 13, "RoomClose");
            RoomClose = r23;
            Source r24 = new Source("NormalToMultiple", 14, null, 1, r9);
            NormalToMultiple = r24;
            String r25 = null;
            int r26 = 1;
            DefaultConstructorMarker r27 = null;
            Source r28 = new Source("ScoreControl", 15, r25, r26, r27);
            ScoreControl = r28;
            Source r29 = new Source("ChangeMode", 16, r25, r26, r27);
            ChangeMode = r29;
            Source r30 = new Source("RelinkSuccess", 17, r25, r26, r27);
            RelinkSuccess = r30;
            Source r32 = new Source("StartOpenGame", 18, r25, r26, r27);
            StartOpenGame = r32;
            a = new Source[]{r7, r1, r2, r3, r4, r5, r8, r13, r14, r15, r16, r20, r22, r23, r24, r28, r29, r30, r32};
        }

        public final String getReqSrc() {
            return this.reqSrc;
        }

        public Source(String r1, int r2, String r3) {
            super(r1, r2);
            this.reqSrc = r3;
        }

        public /* synthetic */ Source(String r1, int r2, String r3, int r4, DefaultConstructorMarker r5) {
            if ((r4 & 1) == 0) goto L5;
            r3 = "";
        L5:
            this(r1, r2, r3);
        }
    }

    public static abstract class a {
        public final Source a;
        public final String b;

        /* JADX INFO: renamed from: com.bytedance.android.live.revlink.impl.mergepk.pkbase.statemachine.PkBaseStateMachine$a$a, reason: collision with other inner class name */
        public static final class C0128a extends a {
            public final com.bytedance.android.live.revlink.impl.mergepk.pkbase.statemachine.a c;

            public C0128a(com.bytedance.android.live.revlink.impl.mergepk.pkbase.statemachine.a r2, Source r3) {
                Intrinsics.checkNotNullParameter(r2, "pkInfo");
                Intrinsics.checkNotNullParameter(r3, "source");
                super(r3, "BattleFinishEvent");
                this.c = r2;
            }
        }

        public static final class b extends a {
            public static final b c = null;

            static {
                c = new b();
            }

            public b() {
                super(Source.Init, "BattleForceReset");
            }
        }

        public static final class c extends a {
            public final com.bytedance.android.live.revlink.impl.mergepk.pkbase.statemachine.a c;

            public c(com.bytedance.android.live.revlink.impl.mergepk.pkbase.statemachine.a r2, Source r3) {
                Intrinsics.checkNotNullParameter(r2, "pkInfo");
                Intrinsics.checkNotNullParameter(r3, "source");
                super(r3, "BattleInterrupt");
                this.c = r2;
            }
        }

        public static final class d extends a {
            public final com.bytedance.android.live.revlink.impl.mergepk.pkbase.statemachine.a c;

            public d(com.bytedance.android.live.revlink.impl.mergepk.pkbase.statemachine.a r2, Source r3) {
                Intrinsics.checkNotNullParameter(r2, "pkInfo");
                Intrinsics.checkNotNullParameter(r3, "source");
                super(r3, "BattleLinkerLeave");
                this.c = r2;
            }
        }

        public static final class e extends a {
            public final com.bytedance.android.live.revlink.impl.mergepk.pkbase.statemachine.a c;

            public e(com.bytedance.android.live.revlink.impl.mergepk.pkbase.statemachine.a r3) {
                Intrinsics.checkNotNullParameter(r3, "pkInfo");
                super(Source.MetaUpdate, "BattleMetaUpdate");
                this.c = r3;
            }
        }

        public static final class f extends a {
            public final com.bytedance.android.live.revlink.impl.mergepk.pkbase.statemachine.a c;

            public f(com.bytedance.android.live.revlink.impl.mergepk.pkbase.statemachine.a r3) {
                Intrinsics.checkNotNullParameter(r3, "pkInfo");
                super(Source.BattleMsg, "BattleMsg");
                this.c = r3;
            }
        }

        public static final class g extends a {
            public static final g c = null;

            static {
                c = new g();
            }

            public g() {
                super(Source.PunishTimeUp, "BattlePunishTimeUp");
            }
        }

        public static final class h extends a {
            public static final h c = null;

            static {
                c = new h();
            }

            public h() {
                super(Source.DoublePkLinkInPeak, "BattleToLinkInPeak");
            }
        }

        public static final class i extends a {
            public final com.bytedance.android.live.revlink.impl.mergepk.pkbase.statemachine.a c;
            public final boolean d;

            public i(com.bytedance.android.live.revlink.impl.mergepk.pkbase.statemachine.a r2, Source r3, boolean r4) {
                Intrinsics.checkNotNullParameter(r2, "pkInfo");
                Intrinsics.checkNotNullParameter(r3, "source");
                super(r3, "GetBattleState");
                this.c = r2;
                this.d = r4;
            }
        }

        public static final class j extends a {
            public static final j c = null;

            static {
                c = new j();
            }

            public j() {
                super(Source.Init, "OpenGameForceToLink");
            }
        }

        public final String toString() {
            return this.b + '(' + this.a + ')';
        }

        public a(Source r1, String r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public static abstract class b {
        public final c a;
        public final c b;
        public final String c;

        public static final class a extends b {
            public final boolean d;

            public a(c r2, c.b r3, boolean r4) {
                Intrinsics.checkNotNullParameter(r2, "from");
                Intrinsics.checkNotNullParameter(r3, "to");
                super(r2, r3, "Finish");
                this.d = r4;
            }
        }

        /* JADX INFO: renamed from: com.bytedance.android.live.revlink.impl.mergepk.pkbase.statemachine.PkBaseStateMachine$b$b, reason: collision with other inner class name */
        public static final class C0129b extends b {
            public C0129b(c r2, c.a r3) {
                Intrinsics.checkNotNullParameter(r2, "from");
                Intrinsics.checkNotNullParameter(r3, "to");
                super(r2, r3, "ForceReset");
            }
        }

        public static final class c extends b {
            public c(c r2, c.C0130c r3) {
                Intrinsics.checkNotNullParameter(r2, "from");
                Intrinsics.checkNotNullParameter(r3, "to");
                super(r2, r3, "ShowPK");
            }
        }

        public static final class d extends b {
            public d(c r2, c.d r3) {
                Intrinsics.checkNotNullParameter(r2, "from");
                Intrinsics.checkNotNullParameter(r3, "to");
                super(r2, r3, "ShowPenal");
            }
        }

        public final String toString() {
            return this.c;
        }

        public b(c r1, c r2, String r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    public static abstract class c {
        public final com.bytedance.android.live.revlink.impl.mergepk.pkbase.statemachine.a a;
        public final Source b;
        public final String c;

        public static final class a extends c {
            public static final a d = null;

            static {
                d = new a();
            }

            public a() {
                super(new com.bytedance.android.live.revlink.impl.mergepk.pkbase.statemachine.a(null, null, null, null, 0, null, null, null, null, null, null, null, null, null, null, 32767), Source.Init, "Disable");
            }
        }

        public static final class b extends c {
            public b(com.bytedance.android.live.revlink.impl.mergepk.pkbase.statemachine.a r2, Source r3) {
                Intrinsics.checkNotNullParameter(r2, "pkInfo");
                Intrinsics.checkNotNullParameter(r3, "source");
                super(r2, r3, "Finished");
            }
        }

        /* JADX INFO: renamed from: com.bytedance.android.live.revlink.impl.mergepk.pkbase.statemachine.PkBaseStateMachine$c$c, reason: collision with other inner class name */
        public static final class C0130c extends c {
            public C0130c(com.bytedance.android.live.revlink.impl.mergepk.pkbase.statemachine.a r2, Source r3) {
                Intrinsics.checkNotNullParameter(r2, "pkInfo");
                Intrinsics.checkNotNullParameter(r3, "source");
                super(r2, r3, "PK");
            }
        }

        public static final class d extends c {
            public d(com.bytedance.android.live.revlink.impl.mergepk.pkbase.statemachine.a r2, Source r3) {
                Intrinsics.checkNotNullParameter(r2, "pkInfo");
                Intrinsics.checkNotNullParameter(r3, "source");
                super(r2, r3, "Penal");
            }
        }

        public final boolean a() {
            if ((this instanceof C0130c) == false) goto L5;
        L8:
            return true;
        L5:
            if ((this instanceof d) == true) goto L8;
            return false;
        }

        public final boolean b() {
            if ((this instanceof a) == false) goto L5;
        L8:
            return true;
        L5:
            if ((this instanceof b) == true) goto L8;
            return false;
        }

        public final RevPkState c() {
            if ((this instanceof a) == false) goto L6;
            return RevPkState.DISABLE;
        L6:
            if ((this instanceof C0130c) == false) goto L9;
            return RevPkState.PK;
        L9:
            if ((this instanceof d) == false) goto L12;
            return RevPkState.PENAL;
        L12:
            if ((this instanceof b) == false) goto L16;
            return RevPkState.FINISHED;
        L16:
            throw new NoWhenBranchMatchedException();
        }

        public final String toString() {
            return this.c;
        }

        public c(com.bytedance.android.live.revlink.impl.mergepk.pkbase.statemachine.a r1, Source r2, String r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    public PkBaseStateMachine(Function1<? super StateMachine.c<? extends c, ? extends a, ? extends b>, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.b = r2;
        StateMachine.a r3 = StateMachine.c;
        Function1<StateMachine.GraphBuilder<c, a, b>, Unit> r0 = new PkBaseStateMachine$stateMachine$1(this);
        r3.getClass();
        this.a = StateMachine.a.a(r0);
    }

    public final void a(a r2) {
        Intrinsics.checkNotNullParameter(r2, "event");
        StateMachine.c(this.a, r2);
    }
}
