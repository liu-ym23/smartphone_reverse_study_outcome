package com.bytedance.android.live.liveinteract.revenue.battle;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.setting.b6;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class j {
    public final GuestBattleWidget a;

    public static final class a implements ne0.a {
        public final /* synthetic */ j a;

        public a(j r1) {
            this.a = r1;
        }

        @Override // ne0.a
        public final void a(ne0.e r1, Object r2) {
            Intrinsics.checkNotNullParameter(r1, "store");
            this.a.a.getClass();
            if (ii0.a.b == false) goto L6;
            ii0.a.h();
            return;
        }
    }

    public static final class b implements ne0.a {
        public final /* synthetic */ j a;

        public b(j r1) {
            this.a = r1;
        }

        @Override // ne0.a
        public final void a(ne0.e r1, Object r2) {
            Intrinsics.checkNotNullParameter(r1, "store");
            this.a.a.getClass();
            ii0.a.g();
        }
    }

    public static final class c implements ne0.a {
        public final /* synthetic */ j a;

        public c(j r1) {
            this.a = r1;
        }

        @Override // ne0.a
        public final void a(ne0.e r1, Object r2) {
            Intrinsics.checkNotNullParameter(r1, "store");
            this.a.a.getClass();
            if (ii0.a.b == false) goto L6;
            ii0.a.h();
            return;
        }
    }

    public static final class d implements ne0.a {
        public final /* synthetic */ j a;

        public d(j r1) {
            this.a = r1;
        }

        @Override // ne0.a
        public final void a(ne0.e r1, Object r2) {
            Intrinsics.checkNotNullParameter(r1, "store");
            this.a.a.getClass();
            ii0.a.g();
        }
    }

    public static final class e implements ne0.a {
        public final /* synthetic */ j a;

        public e(j r1) {
            this.a = r1;
        }

        @Override // ne0.a
        public final void a(ne0.e r2, Object r3) {
            Intrinsics.checkNotNullParameter(r2, "store");
            GuestBattleWidget r4 = this.a.a;
            if ((r3 instanceof String) == true) goto L5;
            r3 = null;
        L5:
            String r5 = (String) r3;
            if (r5 != null) goto L8;
            r5 = "";
        L8:
            r4.B8(r5);
        }
    }

    public static final class f implements ne0.a {
        public final /* synthetic */ j a;

        public f(j r1) {
            this.a = r1;
        }

        @Override // ne0.a
        public final void a(ne0.e r2, Object r3) {
            Intrinsics.checkNotNullParameter(r2, "store");
            if (r3 == null) goto L6;
            this.a.a.getClass();
            Intrinsics.checkNotNullParameter((List) r3, "userList");
            return;
        }
    }

    public static final class g implements ne0.a {
        public final /* synthetic */ j a;

        public g(j r1) {
            this.a = r1;
        }

        @Override // ne0.a
        public final void a(ne0.e r7, Object r8) {
            Intrinsics.checkNotNullParameter(r7, "store");
            if (r8 != null) goto L5;
            return;
        L5:
            ji0.b r9 = (ji0.b) r8;
            com.bytedance.android.livesdk.chatroom.interact.model.u r10 = r9.a;
            if (r10 != null) goto L8;
            return;
        L8:
            if (r10.is_anchor_involved() == 2) goto L10;
            boolean r0 = true;
        L11:
            int r2 = (int) r10.getLast_battle_duration_by_anchor();
            if (this.a.a.getRoom() != null) goto L14;
        L22:
            com.bytedance.android.livesdk.sharedpref.e r1 = b6.K;
            Boolean r3 = Boolean.valueOf(r0);
            r1.getClass();
            com.bytedance.android.livesdk.sharedpref.f.d(r1, r3);
        L23:
            if (r2 <= 0) goto L25;
            com.bytedance.android.livesdk.sharedpref.e r4 = b6.M;
            Integer r5 = Integer.valueOf(r2);
            r4.getClass();
            com.bytedance.android.livesdk.sharedpref.f.d(r4, r5);
        L25:
            int r6 = (int) r10.getLoserNum();
            ALogger.d("[GuestBattle]GuestBattleWidget", "#GuestBattleDebug# [handleGuestBattleSetting] from: " + r9.b + ", loserNum: " + r6 + ", anchorIn: " + r0 + ", battleDuration: " + r2);
            if (r6 <= 0) goto L31;
            com.bytedance.android.livesdk.sharedpref.e r11 = b6.i0;
            Integer r12 = Integer.valueOf(r6);
            r11.getClass();
            com.bytedance.android.livesdk.sharedpref.f.d(r11, r12);
            GuestBattleContext r13 = GuestBattleContext.Companion.getContext();
            if (r13 != null) goto L30;
            return;
        L30:
            r13.getConfigLoserNum().setValue(Integer.valueOf(r6));
            r13.getOnlineLoserNum().setValue(Integer.valueOf(r6));
        L31:
            com.bytedance.android.livesdk.sharedpref.e r14 = b6.L;
            Integer r15 = Integer.valueOf(r10.getScoreType());
            r14.getClass();
            com.bytedance.android.livesdk.sharedpref.f.d(r14, r15);
            return;
        L14:
            if (this.a.a.getRoom().getAnchorABMap() == null) goto L22;
            Map r16 = this.a.a.getRoom().getAnchorABMap();
            if (r16 == null) goto L18;
            String r17 = (String) r16.get("live_linkmic_battle_optimize");
        L20:
            if ((!Intrinsics.areEqual("1", r17)) == false) goto L22;
            com.bytedance.android.livesdk.sharedpref.e r18 = b6.K;
            Boolean r19 = Boolean.FALSE;
            r18.getClass();
            com.bytedance.android.livesdk.sharedpref.f.d(r18, r19);
            goto L23
        L18:
            r17 = null;
            goto L20
        L10:
            r0 = false;
            goto L11
        }
    }

    public static final class h implements ne0.a {
        public final /* synthetic */ j a;

        public h(j r1) {
            this.a = r1;
        }

        @Override // ne0.a
        public final void a(ne0.e r1, Object r2) {
            Intrinsics.checkNotNullParameter(r1, "store");
            ne0.c r3 = this.a.a.getStore();
            if (r3 == null) goto L6;
            r3.onDestory();
            return;
        }
    }

    public j(GuestBattleWidget r4) {
        Intrinsics.checkNotNullParameter(r4, "widget");
        this.a = r4;
        ne0.e r0 = r4.getStore().d(sh0.a0.b, new a(this));
        r0.d(sh0.z.b, new b(this));
        r0.d(sh0.f.b, new c(this));
        r0.d(sh0.e.b, new d(this));
        r0.d(sh0.g.b, new e(this));
        r0.d(sh0.y.b, new f(this));
        r0.d(ji0.c.b, new g(this));
        r0.d(sh0.d0.b, new h(this));
        ne0.e r5 = r4.getStore().d(ji0.g.b, new k(this));
        r5.d(ji0.a.b, new l(this));
        r5.d(ji0.e.b, new m(this));
        r5.d(ji0.d.b, new n(this));
        r5.d(ji0.f.b, new o(this));
    }
}
