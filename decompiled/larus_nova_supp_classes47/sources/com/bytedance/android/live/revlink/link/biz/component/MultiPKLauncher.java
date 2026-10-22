package com.bytedance.android.live.revlink.link.biz.component;

import com.bytedance.android.live.revenue.common.r0;
import com.bytedance.android.live.revlink.impl.mergepk.params.BattleInviteType;
import com.bytedance.android.live.revlink.impl.multianchor.constants.PlayMode;
import com.bytedance.android.livesdk.link.model.h9;
import com.bytedance.android.livesdk.link.model.v3;
import com.bytedance.android.livesdk.link.model.w2;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import com.bytedance.badger.collect.impl.constants.Constants;
import com.bytedance.live.datacontext.DataContext;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 %2\u00020\u00012\u00020\u0002:\u0001&BM\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d\u0012\b\u0010!\u001a\u0004\u0018\u00010 ¢\u0006\u0004\b#\u0010$J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0007\u001a\u00020\u0005H\u0002J\u001a\u0010\f\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\u001a\u0010\r\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016R\u0016\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0015\u001a\u0004\u0018\u00010\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0018\u001a\u0004\u0018\u00010\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001b\u001a\u0004\u0018\u00010\u001a8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010\u001e\u001a\u0004\u0018\u00010\u001d8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010!\u001a\u0004\u0018\u00010 8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010\"¨\u0006'"}, d2 = {"Lcom/bytedance/android/live/revlink/link/biz/component/MultiPKLauncher;", "Lh31/a;", "Lcom/bytedance/live/datacontext/DataContext;", "", "flag", "", "setIsPkLauncher", "logVoteIntercept", "Lh31/f;", Constants.Keys.DATA, "Lh31/g;", "callback", "openPk", "invitePk", "Lcom/bytedance/android/live/revlink/impl/multianchor/dialog/linkopt/e;", "linkOptLogContext", "Lcom/bytedance/android/live/revlink/impl/multianchor/dialog/linkopt/e;", "Ld21/d;", "mergePkHelper", "Ld21/d;", "Le21/b;", "clientAttachedInfoObj", "Le21/b;", "Ld31/d;", "revLinkLogHelper", "Ld31/d;", "Lcom/bytedance/android/live/revlink/impl/mergepk/pkbase/e;", "basePKContext", "Lcom/bytedance/android/live/revlink/impl/mergepk/pkbase/e;", "Lcom/bytedance/android/live/revlink/impl/mergepk/pkmulti/b;", "multiPkService", "Lcom/bytedance/android/live/revlink/impl/mergepk/pkmulti/b;", "Lh41/f;", "pkSwitchLogger", "Lh41/f;", "<init>", "(Lcom/bytedance/android/live/revlink/impl/multianchor/dialog/linkopt/e;Ld21/d;Le21/b;Ld31/d;Lcom/bytedance/android/live/revlink/impl/mergepk/pkbase/e;Lcom/bytedance/android/live/revlink/impl/mergepk/pkmulti/b;Lh41/f;)V", "Companion", "a", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class MultiPKLauncher extends DataContext implements h31.a {
    public static final a Companion = null;
    public static final String TAG = "MultiPKLauncher";
    private final com.bytedance.android.live.revlink.impl.mergepk.pkbase.e basePKContext;
    private final e21.b clientAttachedInfoObj;
    private final com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt.e linkOptLogContext;
    private final d21.d mergePkHelper;
    private final com.bytedance.android.live.revlink.impl.mergepk.pkmulti.b multiPkService;
    private final h41.f pkSwitchLogger;
    private final d31.d revLinkLogHelper;

    public static final class a {
        public a() {
        }
    }

    public static final class b implements c21.a {
        public final /* synthetic */ MultiPKLauncher a;
        public final /* synthetic */ h31.g b;

        @Override // c21.a
        public final void a(c21.b r2) {
            Intrinsics.checkNotNullParameter(r2, "battleInviteParams");
            MultiPKLauncher.access$setIsPkLauncher(this.a, true);
            h31.g r3 = this.b;
            if (r3 == null) goto L6;
            r3.onSuccess();
            return;
        }

        @Override // c21.a
        public final void b(c21.b r2) {
            Intrinsics.checkNotNullParameter(r2, "battleInviteParams");
            h31.g r3 = this.b;
            if (r3 == null) goto L6;
            r3.onFailed();
            return;
        }

        public b(MultiPKLauncher r1, h31.g r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public static final class c implements c21.d {
        public final /* synthetic */ MultiPKLauncher a;
        public final /* synthetic */ h31.g b;

        @Override // c21.d
        public final void a(c21.e r5) {
            Intrinsics.checkNotNullParameter(r5, "battleOpenParams");
            MultiPKLauncher.access$setIsPkLauncher(this.a, true);
            c21.e.a r6 = r5.a;
            h41.f r0 = MultiPKLauncher.access$getPkSwitchLogger$p(this.a);
            if (r0 == null) goto L9;
            int r2 = r6.h;
            List<String> r3 = r6.g;
            if (r3 == null) goto L7;
            int r4 = r3.size();
        L8:
            r0.h(true, r2, r4, r6.c);
            goto L9
        L7:
            r4 = 0;
        L9:
            h31.g r7 = this.b;
            if (r7 == null) goto L13;
            r7.onSuccess();
            return;
        }

        public c(MultiPKLauncher r1, h31.g r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // c21.d
        public final void b(c21.e r6, Throwable r7) {
            Intrinsics.checkNotNullParameter(r6, "battleOpenParams");
            c21.e.a r0 = r6.a;
            h41.f r1 = MultiPKLauncher.access$getPkSwitchLogger$p(this.a);
            if (r1 == null) goto L10;
            int r2 = r0.h;
            List<String> r3 = r0.g;
            if (r3 == null) goto L7;
            int r4 = r3.size();
        L8:
            r1.h(false, r2, r4, r0.c);
            goto L10
        L7:
            r4 = 0;
        L10:
            if ((r6.b instanceof c21.f.m) == false) goto L15;
            if (r7 == null) goto L15;
            if (r0.a(r7) != 4017173) goto L15;
            MultiPKLauncher.access$logVoteIntercept(this.a);
        L15:
            h31.g r8 = this.b;
            if (r8 == null) goto L19;
            r8.onFailed();
            return;
        }
    }

    static {
        Companion = new a();
    }

    private final void logVoteIntercept() {
        LinkedHashMap r0 = new LinkedHashMap();
        com.bytedance.android.live.revlink.impl.mergepk.pkmulti.b r1 = this.multiPkService;
        if (r1 == null) goto L5;
        r0.putAll(r1.getCurrentSceneLogParam());
    L5:
        mz0.n r2 = new mz0.n();
        Map<String, String> r3 = r2.a;
        Intrinsics.checkNotNullParameter(r3, "map");
        Intrinsics.checkNotNullParameter(r0, "map");
        r3.putAll(r0);
        mz0.m r4 = new mz0.m();
        r4.b(LogCommon.ROOM);
        List<Object> r5 = r2.b;
        ArrayList r6 = (ArrayList) r5;
        r6.addAll(r4.a);
        cy0.e.a.getClass();
        cy0.j r7 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r8 = com.bytedance.android.scope.m.b(r7).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r8);
        ((mz0.i) ((f80.a) r8)).w3("livesdk_vote_reject_toast_show", r2.a, r2.b);
    }

    public static final /* synthetic */ h41.f access$getPkSwitchLogger$p(MultiPKLauncher r0) {
        return r0.pkSwitchLogger;
    }

    public static final /* synthetic */ void access$logVoteIntercept(MultiPKLauncher r0) {
        r0.logVoteIntercept();
    }

    private final void setIsPkLauncher(boolean r2) {
        com.bytedance.android.live.revlink.impl.mergepk.pkmulti.b r0 = this.multiPkService;
        if (r0 == null) goto L6;
        r0.setPkLauncher(r2);
        return;
    }

    public static final /* synthetic */ void access$setIsPkLauncher(MultiPKLauncher r0, boolean r1) {
        r0.setIsPkLauncher(r1);
    }

    @Override // h31.a
    public void invitePk(h31.f r22, h31.g r23) {
        Intrinsics.checkNotNullParameter(r22, Constants.Keys.DATA);
        com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt.e r2 = this.linkOptLogContext;
        v3 r3 = null;
        if (r2 == null) goto L6;
        r2.b(null);
    L6:
        if (this.mergePkHelper == null) goto L13;
        h31.e r4 = r22.d;
        if (r4 == null) goto L10;
        int r5 = r4.b;
    L11:
        BattleInviteType r6 = d21.d.d(r5);
        if (r6 == null) goto L13;
    L14:
        BattleInviteType r7 = r6;
        long r8 = r22.b;
        h31.e r9 = r22.d;
        if (r9 == null) goto L17;
        int r10 = r9.e;
    L18:
        long r12 = r22.k;
        e21.b r13 = this.clientAttachedInfoObj;
        if (r13 == null) goto L32;
        com.bytedance.android.live.revlink.impl.pk.utils.l r14 = r22.l;
        String r15 = r22.j.a.a;
        d31.d r16 = this.revLinkLogHelper;
        if (r16 == null) goto L26;
        String r17 = r16.a();
        if (r17 == null) goto L26;
        String r18 = r17;
    L27:
        d31.d r19 = this.revLinkLogHelper;
        if (r19 == null) goto L30;
        String r110 = r19.s();
    L31:
        r3 = e21.b.b(r13, r14, r15, null, null, r110, r18, 28);
        goto L32
    L30:
        r110 = "";
    L26:
        r18 = "";
    L32:
        v3 r111 = r3;
        h31.e r20 = r22.d;
        if (r20 == null) goto L35;
        boolean r24 = r20.d;
    L36:
        c21.l r25 = new c21.l(r7, r8, r10, r24, r12, r111, 64);
        h31.i r26 = r22.e;
        if (r26 == null) goto L40;
        c21.b r1 = new c21.b(r25, new c21.f.m(7, r26.a), "Vote");
    L50:
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.e r27 = this.basePKContext;
        if (r27 == null) goto L56;
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.launcher.a r28 = r27.getPkAnchorLauncher();
        if (r28 == null) goto L57;
        r28.b(r1, new b(this, r23));
        return;
    L57:
        return;
    L56:
        return;
    L40:
        if (r22.f == null) goto L44;
        c21.b r29 = new c21.b(r25, new c21.f.g(7, h21.c.a(Integer.valueOf(r25.c)), r22.f.a), "CustomPlay");
    L42:
        r1 = r29;
        goto L50
    L44:
        if (r22.g == null) goto L47;
        r29 = new c21.b(r25, new c21.f.k(7, h21.c.a(Integer.valueOf(r25.c)), r22.g), "ShellPk");
        goto L42
    L47:
        if (r22.h == null) goto L49;
        r29 = new c21.b(r25, new c21.f.l(7, h21.c.a(Integer.valueOf(r25.c)), r22.h), "SpecifyGiftPk");
        goto L42
    L49:
        r1 = new c21.b(r25, new c21.f.h(7, h21.c.a(Integer.valueOf(r25.c))), "NormalPk");
        goto L50
    L35:
        r24 = false;
        goto L36
    L17:
        r10 = 0;
        goto L18
    L10:
        r5 = 0;
    L13:
        r6 = BattleInviteType.UNKNOWN;
        goto L14
    }

    @Override // h31.a
    public void openPk(h31.f r14, h31.g r15) {
        Intrinsics.checkNotNullParameter(r14, Constants.Keys.DATA);
        com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt.e r0 = this.linkOptLogContext;
        if (r0 == null) goto L5;
        r0.b(null);
    L5:
        long r3 = r14.b;
        h31.d r2 = r14.c;
        if (r2 == null) goto L9;
        PlayMode r5 = r2.a;
        if (r5 == null) goto L9;
    L10:
        PlayMode r6 = r5;
        if (r2 == null) goto L13;
        List<String> r10 = r2.c;
    L15:
        if (this.mergePkHelper == null) goto L22;
        h31.e r4 = r14.d;
        if (r4 == null) goto L19;
        int r7 = r4.b;
    L20:
        BattleInviteType r8 = d21.d.d(r7);
        if (r8 == null) goto L22;
    L23:
        c21.e.a r1 = new c21.e.a(r3, 7, r6, r8, null, null, r10, r14.m, 176);
        h31.c r9 = r14.f;
        if (r9 == null) goto L29;
        PlayMode r12 = r1.c;
        if (r12 != null) goto L28;
        r12 = PlayMode.PERSONAL_PK;
    L28:
        c21.e r16 = new c21.e(r1, new c21.f.g(7, r12, r9.a), "CustomPlay");
    L57:
        c21.e r13 = r16;
    L58:
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.e r17 = this.basePKContext;
        if (r17 == null) goto L64;
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.launcher.a r18 = r17.getPkAnchorLauncher();
        if (r18 == null) goto L65;
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.launcher.a.g.a(r18, r13, new c(this, r15), null, 4);
        return;
    L65:
        return;
    L64:
        return;
    L29:
        w2 r19 = r14.g;
        if (r19 == null) goto L35;
        PlayMode r20 = r1.c;
        if (r20 != null) goto L34;
        r20 = PlayMode.PERSONAL_PK;
    L34:
        r16 = new c21.e(r1, new c21.f.k(7, r20, r19), "ShellPk");
        goto L57
    L35:
        h31.i r22 = r14.e;
        if (r22 == null) goto L38;
        r16 = new c21.e(r1, new c21.f.m(7, r22.a), "Vote");
        goto L57
    L38:
        h9 r23 = r14.h;
        if (r23 == null) goto L44;
        PlayMode r24 = r1.c;
        if (r24 != null) goto L43;
        r24 = PlayMode.PERSONAL_PK;
    L43:
        r16 = new c21.e(r1, new c21.f.l(7, r24, r23), "SpecifyGiftPk");
        goto L57
    L44:
        h31.h r110 = r14.j;
        if ((r110 instanceof h31.h.b) == false) goto L51;
        PlayMode r25 = r1.c;
        if (r25 != null) goto L49;
        r25 = PlayMode.PERSONAL_PK;
    L49:
        r13 = new c21.e(r1, new c21.f.C0009f(7, r25, ((h31.h.b) r110).b), "InteractPk");
        goto L58
    L51:
        if ((r110 instanceof h31.h.i) == false) goto L53;
        r16 = new c21.e(r1, c21.f.j.b, "SeasonRank");
        goto L57
    L53:
        PlayMode r26 = r1.c;
        if (r26 != null) goto L56;
        r26 = PlayMode.PERSONAL_PK;
    L56:
        r16 = new c21.e(r1, new c21.f.h(7, r26), "NormalPk");
        goto L57
    L19:
        r7 = 0;
    L22:
        r8 = BattleInviteType.UNKNOWN;
        goto L23
    L13:
        r10 = null;
    L9:
        r5 = PlayMode.PERSONAL_PK;
        goto L10
    }

    public MultiPKLauncher(com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt.e r1, d21.d r2, e21.b r3, d31.d r4, com.bytedance.android.live.revlink.impl.mergepk.pkbase.e r5, com.bytedance.android.live.revlink.impl.mergepk.pkmulti.b r6, h41.f r7) {
        this.linkOptLogContext = r1;
        this.mergePkHelper = r2;
        this.clientAttachedInfoObj = r3;
        this.revLinkLogHelper = r4;
        this.basePKContext = r5;
        this.multiPkService = r6;
        this.pkSwitchLogger = r7;
    }
}
