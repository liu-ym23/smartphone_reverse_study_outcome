package com.bytedance.android.live.profit.scoreboard;

import com.bytedance.android.live.revlink.api.ILinkService;
import com.bytedance.android.livesdk.message.model.k7;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import com.bytedance.badger.collect.impl.constants.Constants;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class ScoreboardEventTracker implements com.bytedance.android.scope.o {
    public final ILinkService a;
    public final yz0.k b;
    public final k c;
    public final com.bytedance.android.livesdk.revenue.service.broadcast.a d;
    public final l e;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/live/profit/scoreboard/ScoreboardEventTracker$ToastContent;", "", "", "value", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "InvitationSent", "RoundStarted", "InvitationDeclined", "liveprofit-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum ToastContent extends Enum<ToastContent> {
        public static final ToastContent InvitationDeclined = null;
        public static final ToastContent InvitationSent = null;
        public static final ToastContent RoundStarted = null;
        public static final /* synthetic */ ToastContent[] a = null;
        private final String value;

        static {
            ToastContent r1 = new ToastContent("InvitationSent", 0, "waiting");
            InvitationSent = r1;
            ToastContent r2 = new ToastContent("RoundStarted", 1, "start");
            RoundStarted = r2;
            ToastContent r3 = new ToastContent("InvitationDeclined", 2, "refuse");
            InvitationDeclined = r3;
            a = new ToastContent[]{r1, r2, r3};
        }

        public static ToastContent valueOf(String r1) {
            return (ToastContent) r27.a.a(ToastContent.class, r1);
        }

        public static ToastContent[] values() {
            return (ToastContent[]) a.clone();
        }

        public final String getValue() {
            return this.value;
        }

        public ToastContent(String r1, int r2, String r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public static final class a<T> implements Consumer {
        public final /* synthetic */ ScoreboardEventTracker a;

        public a(ScoreboardEventTracker r1) {
            this.a = r1;
        }

        public final void accept(Object r5) {
            if (((Boolean) r5).booleanValue() == false) goto L9;
            ScoreboardEventTracker r6 = this.a;
            r6.getClass();
            mz0.n r0 = new mz0.n();
            r6.a(r0);
            mz0.o r1 = new mz0.o(r0.a);
            r6.g(r1);
            r6.f(r1);
            ScoreboardMatchManager.c r2 = r6.c.a();
            if (r2 == null) goto L7;
            r6.c(r1, r2);
            r1.a("game_app_id", r2.getMiniAppId());
        L7:
            r1.a("game_name", r6.d.getCurrentGameName());
            cy0.e.a.getClass();
            cy0.j r7 = cy0.e.a.a;
            com.bytedance.android.scope.m.e.getClass();
            Object r8 = com.bytedance.android.scope.m.b(r7).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
            Intrinsics.checkNotNull(r8);
            ((mz0.i) ((f80.a) r8)).w3("livesdk_live_game_record_tool_container_entrance_show", r0.a, r0.b);
            return;
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ ScoreboardEventTracker a;

        public b(ScoreboardEventTracker r1) {
            this.a = r1;
        }

        public final void accept(Object r6) {
            Unit r7 = (Unit) r6;
            ScoreboardEventTracker r8 = this.a;
            Pair r0 = (Pair) r8.e.a().a;
            mz0.n r1 = new mz0.n();
            r8.a(r1);
            mz0.o r2 = new mz0.o(r1.a);
            r8.g(r2);
            r8.f(r2);
            ScoreboardMatchManager.c r3 = r8.c.a();
            if (r3 == null) goto L5;
            r8.c(r2, r3);
            r2.a("game_app_id", r3.getMiniAppId());
        L5:
            r2.a("game_name", r8.d.getCurrentGameName());
            r2.a("location", o1.a(r0));
            cy0.e.a.getClass();
            cy0.j r9 = cy0.e.a.a;
            com.bytedance.android.scope.m.e.getClass();
            Object r10 = com.bytedance.android.scope.m.b(r9).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
            Intrinsics.checkNotNull(r10);
            ((mz0.i) ((f80.a) r10)).w3("livesdk_live_game_record_tool_container_entrance_click", r1.a, r1.b);
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ ScoreboardEventTracker a;

        public c(ScoreboardEventTracker r1) {
            this.a = r1;
        }

        public final void accept(Object r7) {
            Pair r8 = (Pair) r7;
            Pair r0 = (Pair) r8.component1();
            Pair r9 = (Pair) r8.component2();
            ScoreboardEventTracker r1 = this.a;
            r1.getClass();
            mz0.n r2 = new mz0.n();
            r1.a(r2);
            mz0.o r3 = new mz0.o(r2.a);
            r1.g(r3);
            r1.f(r3);
            ScoreboardMatchManager.c r4 = r1.c.a();
            if (r4 == null) goto L5;
            r1.c(r3, r4);
            r3.a("game_app_id", r4.getMiniAppId());
        L5:
            r3.a("game_name", r1.d.getCurrentGameName());
            r3.a("location", o1.a(r0));
            r3.a("end_location", o1.a(r9));
            cy0.e.a.getClass();
            cy0.j r10 = cy0.e.a.a;
            com.bytedance.android.scope.m.e.getClass();
            Object r12 = com.bytedance.android.scope.m.b(r10).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
            Intrinsics.checkNotNull(r12);
            ((mz0.i) ((f80.a) r12)).w3("livesdk_live_game_record_tool_container_entrance_drag", r2.a, r2.b);
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ ScoreboardEventTracker a;

        public d(ScoreboardEventTracker r1) {
            this.a = r1;
        }

        public final void accept(Object r8) {
            Object r9 = sh6.c.b((sh6.b) r8);
            if (r9 == null) goto L12;
            dv0.f r10 = (dv0.f) r9;
            ScoreboardEventTracker r0 = this.a;
            String r1 = r10.getMiniAppId();
            k7 r12 = r10.getEntranceInfo();
            if (r12 == null) goto L7;
            String r13 = r12.getTitle();
        L8:
            if (r13 != null) goto L10;
            r13 = "";
        L10:
            r0.getClass();
            mz0.n r2 = new mz0.n();
            r0.a(r2);
            Map<String, String> r3 = r2.a;
            Intrinsics.checkNotNullParameter(r3, "map");
            Map<? extends String, ? extends String> r5 = r0.a.getRevLinkControlService().h();
            Intrinsics.checkNotNullParameter(r5, "map");
            r3.putAll(r5);
            Intrinsics.checkNotNullParameter("game_app_id", "key");
            Intrinsics.checkNotNullParameter(r1, "value");
            r3.put("game_app_id", r1);
            Intrinsics.checkNotNullParameter("game_name", "key");
            Intrinsics.checkNotNullParameter(r13, "value");
            r3.put("game_name", r13);
            String r14 = r0.d.getCurrentSonicGameAppId();
            Intrinsics.checkNotNullParameter("original_game_app_id", "key");
            Intrinsics.checkNotNullParameter(r14, "value");
            r3.put("original_game_app_id", r14);
            cy0.e.a.getClass();
            cy0.j r15 = cy0.e.a.a;
            com.bytedance.android.scope.m.e.getClass();
            Object r16 = com.bytedance.android.scope.m.b(r15).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
            Intrinsics.checkNotNull(r16);
            ((mz0.i) ((f80.a) r16)).w3("livesdk_live_game_record_tool_invited_popoup_show", r2.a, r2.b);
            return;
        L7:
            r13 = null;
            goto L8
        }
    }

    public static final class e<T> implements Consumer {
        public final /* synthetic */ ScoreboardEventTracker a;

        public e(ScoreboardEventTracker r1) {
            this.a = r1;
        }

        public final void accept(Object r7) {
            Pair r8 = (Pair) r7;
            dv0.f r0 = (dv0.f) r8.component1();
            boolean r9 = ((Boolean) r8.component2()).booleanValue();
            ScoreboardEventTracker r1 = this.a;
            String r2 = r0.getMiniAppId();
            k7 r3 = r0.getEntranceInfo();
            if (r3 == null) goto L5;
            String r4 = r3.getTitle();
        L6:
            if (r4 != null) goto L8;
            r4 = "";
        L8:
            r1.getClass();
            mz0.n r5 = new mz0.n();
            r1.a(r5);
            mz0.o r6 = new mz0.o(r5.a);
            r1.g(r6);
            r6.a("game_app_id", r2);
            r6.a("game_name", r4);
            r6.a("original_game_app_id", r1.d.getCurrentSonicGameAppId());
            if (r9 == false) goto L11;
            String r10 = "accept";
        L12:
            r6.a("click_position", r10);
            cy0.e.a.getClass();
            cy0.j r12 = cy0.e.a.a;
            com.bytedance.android.scope.m.e.getClass();
            Object r13 = com.bytedance.android.scope.m.b(r12).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
            Intrinsics.checkNotNull(r13);
            ((mz0.i) ((f80.a) r13)).w3("livesdk_live_game_record_tool_invited_popoup_click", r5.a, r5.b);
            return;
        L11:
            r10 = "refuse";
            goto L12
        L5:
            r4 = null;
            goto L6
        }
    }

    public static final class f<T> implements Consumer {
        public final /* synthetic */ ScoreboardEventTracker a;

        public f(ScoreboardEventTracker r1) {
            this.a = r1;
        }

        public final void accept(Object r6) {
            Object r7 = sh6.c.b((sh6.b) r6);
            if (r7 == null) goto L6;
            dv0.h r8 = (dv0.h) r7;
            ScoreboardEventTracker r0 = this.a;
            r0.getClass();
            mz0.n r1 = new mz0.n();
            r0.a(r1);
            mz0.o r2 = new mz0.o(r1.a);
            r0.g(r2);
            r0.c(r2, r8);
            r2.a("game_app_id", r8.getMiniAppId());
            r0.d(r2, r8.getMiniAppId());
            ScoreboardEventTracker.h(r2, r8);
            r2.a("tool_recording_id", String.valueOf(r8.getRoundId()));
            cy0.e.a.getClass();
            cy0.j r3 = cy0.e.a.a;
            com.bytedance.android.scope.m.e.getClass();
            Object r4 = com.bytedance.android.scope.m.b(r3).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
            Intrinsics.checkNotNull(r4);
            ((mz0.i) ((f80.a) r4)).w3("livesdk_live_game_record_tool_start", r1.a, r1.b);
            r8.c().subscribe(new d0(r8, this));
            return;
        }
    }

    public final void onStop() {
    }

    public final void onStart() {
        this.e.w().distinctUntilChanged().subscribe(new a(this));
        this.e.f().subscribe(new b(this));
        if (this.b.isAnchor() == false) goto L6;
        this.e.j().subscribe(new c(this));
        this.e.k().subscribe(new d(this));
        this.e.o().subscribe(new e(this));
        this.c.c().subscribe(new f(this));
        return;
    }

    public final void a(mz0.n r3) {
        mz0.m r0 = new mz0.m();
        r0.b(LogCommon.PAGE_SOURCE_LOG);
        r0.b(LogCommon.ROOM);
        List<Object> r4 = r3.b;
        ArrayList r5 = (ArrayList) r4;
        r5.addAll(r0.a);
    }

    public final void f(mz0.o r3) {
        if (this.b.isAnchor() == false) goto L5;
        String r0 = "anchor";
    L6:
        r3.a("game_user_type", r0);
        return;
    L5:
        r0 = "user";
        goto L6
    }

    public final void g(mz0.o r2) {
        r2.b(this.a.getRevLinkControlService().h());
    }

    public static void h(mz0.o r2, dv0.h r3) {
        int r0 = r3.getPlayers().size();
        int r1 = 1;
        if (r0 == 1) goto L7;
        r1 = 2;
        if (r0 == 2) goto L7;
        r1 = -r3.getPlayers().size();
    L7:
        r2.a("record_type", String.valueOf(r1));
    }

    public final void c(mz0.o r3, dv0.h r4) {
        ScoreboardMatchManager.b r5 = r4.getCreator();
        if (r5 == null) goto L5;
        Boolean r6 = Boolean.valueOf(Long.valueOf(r5.a).equals(Long.valueOf(this.b.getRoom().getId())));
    L7:
        if (Intrinsics.areEqual(r6, Boolean.TRUE) == false) goto L10;
        String r7 = "self_start";
    L14:
        r3.a("game_anchor_type", r7);
        return;
    L10:
        if (Intrinsics.areEqual(r6, Boolean.FALSE) == false) goto L12;
        r7 = "invited";
        goto L14
    L12:
        if (r6 != null) goto L17;
        r7 = "unknown";
        goto L14
    L17:
        throw new NoWhenBranchMatchedException();
    L5:
        r6 = null;
        goto L7
    }

    public final void d(mz0.o r3, String r4) {
        xp2.g r5 = this.d.za(r4, this.b.getDataCenter());
        if (r5 == null) goto L5;
        String r6 = r5.a.name;
    L6:
        if (r6 != null) goto L8;
        r6 = "";
    L8:
        r3.a("game_name", r6);
        return;
    L5:
        r6 = null;
        goto L6
    }

    public final void i(String r4, long r5, ToastContent r7) {
        Intrinsics.checkNotNullParameter(r4, Constants.OperatorKey.KEY_APP_ID);
        Intrinsics.checkNotNullParameter(r7, "toastContent");
        mz0.n r0 = new mz0.n();
        a(r0);
        mz0.o r1 = new mz0.o(r0.a);
        g(r1);
        r1.a("game_app_id", r4);
        d(r1, r4);
        r1.a("tool_recording_id", String.valueOf(r5));
        r1.a("toast_content", r7.getValue());
        cy0.e.a.getClass();
        cy0.j r6 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r8 = com.bytedance.android.scope.m.b(r6).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r8);
        ((mz0.i) ((f80.a) r8)).w3("livesdk_live_game_record_tool_inviting_toast_show", r0.a, r0.b);
    }

    public ScoreboardEventTracker(ILinkService r2, yz0.k r3, k r4, com.bytedance.android.livesdk.revenue.service.broadcast.a r5, l r6) {
        Intrinsics.checkNotNullParameter(r2, "linkService");
        Intrinsics.checkNotNullParameter(r3, "roomDataService");
        Intrinsics.checkNotNullParameter(r4, "matchManager");
        Intrinsics.checkNotNullParameter(r5, "gameService");
        Intrinsics.checkNotNullParameter(r6, "repository");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
    }
}
