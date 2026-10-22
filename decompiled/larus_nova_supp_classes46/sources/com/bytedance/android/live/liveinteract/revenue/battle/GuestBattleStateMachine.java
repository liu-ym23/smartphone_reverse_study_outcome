package com.bytedance.android.live.liveinteract.revenue.battle;

import com.bytedance.android.live.core.utils.StateMachine;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class GuestBattleStateMachine {
    public final StateMachine<c, a, b> a;
    public final Function1<StateMachine.c<? extends c, ? extends a, ? extends b>, Unit> b;

    public static abstract class a {
        public final String a;

        /* JADX INFO: renamed from: com.bytedance.android.live.liveinteract.revenue.battle.GuestBattleStateMachine$a$a, reason: collision with other inner class name */
        public static final class C0066a extends a {
            public final com.bytedance.android.livesdk.chatroom.model.interact.a0 b;

            public C0066a(com.bytedance.android.livesdk.chatroom.model.interact.a0 r2) {
                Intrinsics.checkNotNullParameter(r2, "battleInfo");
                super("CreateMsg");
                this.b = r2;
            }
        }

        public static final class b extends a {
            public final com.bytedance.android.livesdk.chatroom.model.interact.a0 b;

            public b(com.bytedance.android.livesdk.chatroom.model.interact.a0 r2) {
                Intrinsics.checkNotNullParameter(r2, "battleInfo");
                super("FinishApi");
                this.b = r2;
            }
        }

        public static final class c extends a {
            public final com.bytedance.android.livesdk.chatroom.model.interact.a0 b;

            public c(com.bytedance.android.livesdk.chatroom.model.interact.a0 r2) {
                Intrinsics.checkNotNullParameter(r2, "battleInfo");
                super("FinishMsg");
                this.b = r2;
            }
        }

        public static final class d extends a {
            public final com.bytedance.android.livesdk.chatroom.model.interact.a0 b;

            public d(com.bytedance.android.livesdk.chatroom.model.interact.a0 r2) {
                Intrinsics.checkNotNullParameter(r2, "battleInfo");
                super("ForceClose");
                this.b = r2;
            }
        }

        public static final class e extends a {
            public final com.bytedance.android.livesdk.chatroom.model.interact.a0 b;

            public e(com.bytedance.android.livesdk.chatroom.model.interact.a0 r2) {
                Intrinsics.checkNotNullParameter(r2, "battleInfo");
                super("GetInfo");
                this.b = r2;
            }
        }

        public static final class f extends a {
            public final com.bytedance.android.livesdk.chatroom.model.interact.a0 b;

            public f(com.bytedance.android.livesdk.chatroom.model.interact.a0 r2) {
                Intrinsics.checkNotNullParameter(r2, "battleInfo");
                super("PauseMsg");
                this.b = r2;
            }
        }

        public static final class g extends a {
        }

        public static final class h extends a {
            public final com.bytedance.android.livesdk.chatroom.model.interact.a0 b;

            public h(com.bytedance.android.livesdk.chatroom.model.interact.a0 r2) {
                Intrinsics.checkNotNullParameter(r2, "battleInfo");
                super("ResumeMsg");
                this.b = r2;
            }
        }

        public static final class i extends a {
            public final com.bytedance.android.livesdk.chatroom.model.interact.a0 b;

            public i(com.bytedance.android.livesdk.chatroom.model.interact.a0 r2) {
                Intrinsics.checkNotNullParameter(r2, "battleInfo");
                super("ShowResultMsg");
                this.b = r2;
            }
        }

        public static final class j extends a {
            public static final j b = null;

            static {
                b = new j();
            }

            public j() {
                super("ShowResultTimeout");
            }
        }

        public static final class k extends a {
            public final com.bytedance.android.livesdk.chatroom.model.interact.a0 b;

            public k(com.bytedance.android.livesdk.chatroom.model.interact.a0 r2) {
                Intrinsics.checkNotNullParameter(r2, "battleInfo");
                super("StartApi");
                this.b = r2;
            }
        }

        public static final class l extends a {
            public final com.bytedance.android.livesdk.chatroom.model.interact.a0 b;

            public l(com.bytedance.android.livesdk.chatroom.model.interact.a0 r2) {
                Intrinsics.checkNotNullParameter(r2, "battleInfo");
                super("UpdateMsg");
                this.b = r2;
            }
        }

        public final String toString() {
            return this.a;
        }

        public a(String r1) {
            this.a = r1;
        }
    }

    public static abstract class b {
        public final String a;

        public static final class a extends b {
            public static final a b = null;

            static {
                b = new a();
            }

            public a() {
                super("None");
            }
        }

        /* JADX INFO: renamed from: com.bytedance.android.live.liveinteract.revenue.battle.GuestBattleStateMachine$b$b, reason: collision with other inner class name */
        public static final class C0067b extends b {
            public final boolean b;

            public C0067b() {
                this(false);
            }

            public C0067b(boolean r2) {
                super("PauseBattle");
                this.b = r2;
            }
        }

        public static final class c extends b {
            public static final c b = null;

            static {
                b = new c();
            }

            public c() {
                super("Reset");
            }
        }

        public static final class d extends b {
            public static final d b = null;

            static {
                b = new d();
            }

            public d() {
                super("RestartBattle");
            }
        }

        public static final class e extends b {
            public final boolean b;

            public e() {
                this(false);
            }

            public e(boolean r2) {
                super("ResumeBattle");
                this.b = r2;
            }
        }

        public static final class f extends b {
            public static final f b = null;

            static {
                b = new f();
            }

            public f() {
                super("ShowBattle");
            }
        }

        public static final class g extends b {
            public static final g b = null;

            static {
                b = new g();
            }

            public g() {
                super("ShowBattleFromPause");
            }
        }

        public static final class h extends b {
            public static final h b = null;

            static {
                b = new h();
            }

            public h() {
                super("ShowResult");
            }
        }

        public static final class i extends b {
            public static final i b = null;

            static {
                b = new i();
            }

            public i() {
                super("UpdateBattle");
            }
        }

        public final String toString() {
            return this.a;
        }

        public b(String r1) {
            this.a = r1;
        }
    }

    public static abstract class c {
        public final com.bytedance.android.livesdk.chatroom.model.interact.a0 a;
        public final String b;

        public static final class a extends c {
            public a(com.bytedance.android.livesdk.chatroom.model.interact.a0 r2) {
                Intrinsics.checkNotNullParameter(r2, "battleInfo");
                super(r2, "Finished");
            }
        }

        public static final class b extends c {
            public static final b c = null;

            static {
                c = new b();
            }

            public b() {
                super(vh7.f.c(com.bytedance.android.livesdk.chatroom.model.interact.a0.class), "None");
            }
        }

        /* JADX INFO: renamed from: com.bytedance.android.live.liveinteract.revenue.battle.GuestBattleStateMachine$c$c, reason: collision with other inner class name */
        public static final class C0068c extends c {
            public C0068c(com.bytedance.android.livesdk.chatroom.model.interact.a0 r2) {
                Intrinsics.checkNotNullParameter(r2, "battleInfo");
                super(r2, "OnGoing");
            }
        }

        public static final class d extends c {
            public d(com.bytedance.android.livesdk.chatroom.model.interact.a0 r2) {
                Intrinsics.checkNotNullParameter(r2, "battleInfo");
                super(r2, "OnPausing");
            }
        }

        public static final class e extends c {
            public e(com.bytedance.android.livesdk.chatroom.model.interact.a0 r2) {
                Intrinsics.checkNotNullParameter(r2, "battleInfo");
                super(r2, "ShowResult");
            }
        }

        public final boolean a() {
            if ((this instanceof C0068c) == false) goto L5;
        L10:
            return true;
        L5:
            if ((this instanceof e) == true) goto L10;
            if ((this instanceof d) == true) goto L10;
            return false;
        }

        public final boolean b() {
            if ((this instanceof b) == false) goto L5;
        L8:
            return true;
        L5:
            if ((this instanceof a) == true) goto L8;
            return false;
        }

        public final String toString() {
            return this.b;
        }

        public c(com.bytedance.android.livesdk.chatroom.model.interact.a0 r1, String r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public final c a() {
        return (c) this.a.b();
    }

    public GuestBattleStateMachine(Function1<? super StateMachine.c<? extends c, ? extends a, ? extends b>, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.b = r2;
        StateMachine.a r3 = StateMachine.c;
        GuestBattleStateMachine$stateMachine$1 r0 = new GuestBattleStateMachine$stateMachine$1(this);
        r3.getClass();
        this.a = StateMachine.a.a(r0);
    }

    public final void b(a r3) {
        Intrinsics.checkNotNullParameter(r3, "action");
        StateMachine<c, a, b> r0 = this.a;
        StateMachine.a r1 = StateMachine.c;
        r0.d(r3, null);
    }
}
