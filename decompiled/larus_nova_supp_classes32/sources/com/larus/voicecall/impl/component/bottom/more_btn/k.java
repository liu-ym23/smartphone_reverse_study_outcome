package com.larus.voicecall.impl.component.bottom.more_btn;

import android.content.Context;
import android.view.View;
import androidx.fragment.app.Fragment;
import com.larus.av_call.util.RealtimeBottomMoreBtn;
import com.larus.bmhome.view.screenmenu.CommonMenu;
import com.larus.bmhome.view.screenmenu.i0;
import com.larus.bmhome.view.screenmenu.j0;
import com.larus.bmhome.view.screenmenu.l0;
import com.larus.bmhome.view.screenmenu.m1;
import com.larus.bmhome.view.screenmenu.n1;
import com.larus.im.bean.bot.SceneModel;
import com.larus.im.bean.bot.SceneModelList;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.larus.voicecall.impl.scene.m;
import com.larus.voicecall.impl.util.RealtimeCallUtil;
import com.larus.voicecall.impl.video.VideoPreviewState;
import com.obric.aivoice.core.data.NameKeys;
import com.skydoves.balloon.Balloon;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class k extends com.larus.voicecall.impl.component.bottom.more_btn.c {
    public final String c;
    public Pair<CommonMenu, Balloon> d;
    public Pair<CommonMenu, Balloon> e;
    public i f;
    public h g;
    public final c h;

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[VideoPreviewState.values().length];
            r0[VideoPreviewState.full.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[VideoPreviewState.pip.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[VideoPreviewState.close.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            a = r0;
        }
    }

    public static final class c implements l3a.c {
        public final /* synthetic */ k a;
        public final /* synthetic */ d b;

        @Override // l3a.c
        public final void a(m r5) {
            if (r5 == null) goto L5;
            FLogger.a.i(this.a.c, "onSceneSelected: selected=" + r5.a.getName());
            this.a.i(new MoreBtnSceneState(this.b));
            return;
        }

        public c(k r1, d r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    static {
    }

    @Override // com.larus.voicecall.impl.component.bottom.more_btn.c
    public final void d() {
        FLogger.a.i(this.c, "onDestroy");
        this.d = null;
        this.e = null;
    }

    public final e3a.b j() {
        t1a.b r0 = this.a.b();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.g(Reflection.getOrCreateKotlinClass(e3a.b.class));
    }

    public final com.larus.voicecall.impl.component.scene.a k() {
        t1a.b r0 = this.a.b();
        if (r0 != null) goto L7;
        return null;
    L7:
        return (com.larus.voicecall.impl.component.scene.a) r0.o(Reflection.getOrCreateKotlinClass(com.larus.voicecall.impl.component.scene.a.class));
    }

    public final com.larus.voicecall.impl.component.vlm.a l() {
        t1a.b r0 = this.a.b();
        if (r0 != null) goto L7;
        return null;
    L7:
        return (com.larus.voicecall.impl.component.vlm.a) r0.o(Reflection.getOrCreateKotlinClass(com.larus.voicecall.impl.component.vlm.a.class));
    }

    public final com.larus.voicecall.impl.component.subtitle.b m() {
        t1a.b r0 = this.a.b();
        if (r0 != null) goto L7;
        return null;
    L7:
        return (com.larus.voicecall.impl.component.subtitle.b) r0.o(Reflection.getOrCreateKotlinClass(com.larus.voicecall.impl.component.subtitle.b.class));
    }

    @Override // com.larus.voicecall.impl.component.bottom.more_btn.c
    public final void e() {
        super.e();
        FLogger.a.i(this.c, "onEnterState");
        RealtimeBottomMoreBtn r0 = this.a.getHostView();
        if (r0 == null) goto L5;
        r0.setImageResource(2131239989);
    L5:
        Fragment r1 = this.a.getFragment();
        if (r1 == null) goto L12;
        Context r2 = r1.getContext();
        if (r2 == null) goto L12;
        int r3 = i88.e.a(r2, 2130972086, 2131103159);
        RealtimeBottomMoreBtn r4 = this.a.getHostView();
        if (r4 == null) goto L12;
        r4.setBackground(i88.e.n(r3));
    L12:
        com.larus.voicecall.impl.component.scene.a r5 = k();
        if (r5 == null) goto L16;
        r5.yM(this.h);
        return;
    }

    @Override // com.larus.voicecall.impl.component.bottom.more_btn.c
    public final void f() {
        super.f();
        FLogger.a.i(this.c, "onExitState");
        this.d = null;
        this.e = null;
        com.larus.voicecall.impl.component.scene.a r0 = k();
        if (r0 == null) goto L6;
        r0.Fk(this.h);
        return;
    }

    @Override // com.larus.voicecall.impl.component.bottom.more_btn.c
    public final String b() {
        return this.c;
    }

    public k(d r2) {
        Intrinsics.checkNotNullParameter(r2, "ctx");
        super(r2);
        this.c = "MoreBtnNormalState";
        this.h = new c(this, r2);
    }

    @Override // com.larus.voicecall.impl.component.bottom.more_btn.c
    public final void c(final View r70) {
        Intrinsics.checkNotNullParameter(r70, "v");
        ArrayList r2 = new ArrayList();
        z2 r3 = z2.a;
        if (r3.realtimeCallUseTwoLineStyle() == true) goto L28;
        RealtimeCallUtil.a.getClass();
        if (RealtimeCallUtil.k() == false) goto L28;
        if (m() == null) goto L28;
        com.larus.voicecall.impl.component.subtitle.b r4 = m();
        if (r4 != null) goto L11;
    L13:
        boolean r5 = false;
    L14:
        if (r5 == false) goto L20;
        Fragment r6 = this.a.getFragment();
        if (r6 == null) goto L26;
        String r7 = r6.getString(2131900491);
        if (r7 == null) goto L26;
    L25:
        String r11 = r7;
    L27:
        r2.add(new l0(6, 0, r11, null, null, null, null, null, null, false, false, null, 2131240977, null, false, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, -4102, 127));
    L26:
        r11 = NameKeys.UnloadStrategy_No_Strategy;
        goto L27
    L20:
        Fragment r8 = this.a.getFragment();
        if (r8 == null) goto L26;
        r7 = r8.getString(2131900495);
        if (r7 != null) goto L25;
    L11:
        if (r4.xU() != true) goto L13;
        r5 = true;
    L28:
        t1a.b r9 = this.a.b();
        if (r9 == null) goto L31;
        com.larus.voicecall.impl.component.denoise.g r10 = (com.larus.voicecall.impl.component.denoise.g) r9.o(Reflection.getOrCreateKotlinClass(com.larus.voicecall.impl.component.denoise.g.class));
    L32:
        if (r10 == null) goto L37;
        n1 r12 = r10.rC(new g(r70));
        if (r12 == null) goto L37;
        int r13 = r12.a;
        boolean r14 = r12.b;
        String r15 = r12.c;
        String r16 = r12.d;
        Integer r17 = r12.f;
        boolean r18 = r12.g;
        boolean r19 = r12.h;
        boolean r20 = r12.i;
        boolean r21 = r12.j;
        Function1 r22 = r12.k;
        Function1 r1 = r12.l;
        boolean r23 = r12.m;
        Intrinsics.checkNotNullParameter(r22, "onSwitchCheckStateChange");
        r2.add(new n1(r13, r14, r15, r16, 2131241800, r17, r18, r19, r20, r21, r22, r1, r23));
    L37:
        Fragment r24 = this.a.getFragment();
        if (r24 == null) goto L41;
        String r25 = r24.getString(2131900535);
        if (r25 == null) goto L41;
    L42:
        t1a.b r26 = this.a.b();
        if (r26 == null) goto L45;
        com.larus.voicecall.impl.component.picture.b r27 = (com.larus.voicecall.impl.component.picture.b) r26.o(Reflection.getOrCreateKotlinClass(com.larus.voicecall.impl.component.picture.b.class));
    L46:
        if (r27 == null) goto L51;
        l0 r28 = r27.KP(2, r25);
        if (r28 == null) goto L51;
        r2.add(r28);
    L51:
        if (r3.realtimeCallUseTwoLineStyle() == false) goto L65;
        Fragment r29 = this.a.getFragment();
        if (r29 == null) goto L56;
        String r30 = r29.getString(2131900500);
        if (r30 == null) goto L56;
    L57:
        t1a.b r31 = this.a.b();
        if (r31 == null) goto L60;
        com.larus.voicecall.impl.component.picture.a r32 = (com.larus.voicecall.impl.component.picture.a) r31.o(Reflection.getOrCreateKotlinClass(com.larus.voicecall.impl.component.picture.a.class));
    L61:
        if (r32 == null) goto L65;
        l0 r33 = r32.ij(r30);
        if (r33 == null) goto L65;
        r2.add(r33);
        goto L65
    L60:
        r32 = null;
    L56:
        r30 = NameKeys.UnloadStrategy_No_Strategy;
    L65:
        com.larus.voicecall.impl.component.vlm.a r34 = l();
        if (r34 == null) goto L80;
        l0 r35 = r34.EY(3);
        if (r35 == null) goto L80;
        if (r3.realtimeCallUseTwoLineStyle() == false) goto L74;
        RealtimeCallUtil.a.getClass();
        if (RealtimeCallUtil.C() == false) goto L74;
        boolean r36 = true;
    L75:
        if (r36 == false) goto L78;
        r35 = null;
    L78:
        if (r35 == null) goto L80;
        boolean r37 = false;
        r2.add(l0.b(r35, 0, 2131241806, false, -4097));
    L81:
        com.larus.voicecall.impl.component.scene.a r38 = k();
        if (r38 == null) goto L100;
        List<m> r39 = r38.getSceneList();
        if (r39 == null) goto L100;
        Iterator<T> r40 = r39.iterator();
    L87:
        if (r40.hasNext() == false) goto L96;
        Object r41 = r40.next();
        com.larus.voicecall.impl.component.scene.a.C0016a r42 = com.larus.voicecall.impl.component.scene.a.C1;
        SceneModel r43 = ((m) r41).a;
        r42.getClass();
        if (r43 != null) goto L91;
    L93:
        boolean r44 = false;
    L94:
        if (r44 == false) goto L87;
    L97:
        m r45 = (m) r41;
        if (r45 == null) goto L100;
        l0 r46 = new l0(5, 0, r45.a.getName(), null, null, null, null, null, null, false, false, r45, 2131241808, null, false, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, -6150, 127);
    L101:
        if (r46 == null) goto L103;
        r2.add(r46);
    L103:
        e3a.a r47 = a();
        if (r47 == null) goto L112;
        SceneModelList r48 = r47.L0;
        if (r48 == null) goto L112;
        List r49 = r48.getList();
        if (r49 == null) goto L112;
        if ((!r49.isEmpty()) != true) goto L112;
        r37 = true;
    L112:
        if (r37 == false) goto L121;
        int r50 = v19.c.b(2130971996, null, 2131242789);
        Fragment r51 = this.a.getFragment();
        if (r51 == null) goto L119;
        String r52 = r51.getString(2131900501);
        if (r52 == null) goto L119;
        String r310 = r52;
    L120:
        r2.add(new l0(0, 0, r310, null, null, null, null, Integer.valueOf(r50), null, false, false, null, 2131241805, null, false, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, -4230, 127));
    L119:
        r310 = r7;
    L121:
        this.d = n(r70, r2);
        return;
    L91:
        if (r43.getId() != 21) goto L93;
        r44 = true;
        goto L94
    L96:
        r41 = null;
    L100:
        r46 = null;
    L74:
        r36 = false;
    L80:
        r37 = false;
        goto L81
    L45:
        r27 = null;
    L41:
        r25 = r7;
        goto L42
    L31:
        r10 = null;
        goto L32
    }

    @Override // com.larus.voicecall.impl.component.bottom.more_btn.c
    public final void g(boolean r5) {
        FLogger.a.i(this.c, "onScreenShareChange: isScreenShare=" + r5);
        if (r5 == false) goto L7;
        Function1<com.larus.voicecall.impl.component.bottom.more_btn.c, Unit> r6 = this.a.a();
        if (r6 == null) goto L14;
        r6.invoke(new l(this.a));
        return;
    L14:
        return;
    L7:
        i r7 = this.f;
        if (r7 == null) goto L10;
        r7.invoke();
    L10:
        h r8 = this.g;
        if (r8 == null) goto L16;
        r8.invoke();
        return;
    }

    @Override // com.larus.voicecall.impl.component.bottom.more_btn.c
    public final void h(VideoPreviewState r5) {
        Intrinsics.checkNotNullParameter(r5, "newState");
        FLogger.a.i(this.c, "onViewCallStateChange: newState=" + r5);
        int r6 = b.a[r5.ordinal()];
        if (r6 != 1) goto L5;
        RealtimeBottomMoreBtn r7 = this.a.getHostView();
        if (r7 == null) goto L46;
        r7.setImageResource(2131239991);
        return;
    L46:
        return;
    L5:
        if (r6 != 2) goto L7;
        RealtimeBottomMoreBtn r8 = this.a.getHostView();
        if (r8 == null) goto L29;
        r8.setImageResource(2131239989);
    L29:
        Fragment r9 = this.a.getFragment();
        if (r9 == null) goto L42;
        Context r10 = r9.getContext();
        if (r10 == null) goto L43;
        int r11 = i88.e.a(r10, 2130972086, 2131103159);
        RealtimeBottomMoreBtn r0 = this.a.getHostView();
        if (r0 == null) goto L44;
        r0.setBackground(i88.e.n(r11));
        return;
    L44:
        return;
    L43:
        return;
    L42:
        return;
    L7:
        if (r6 != 3) goto L25;
        RealtimeBottomMoreBtn r12 = this.a.getHostView();
        if (r12 == null) goto L11;
        r12.setImageResource(2131239989);
    L11:
        Fragment r13 = this.a.getFragment();
        if (r13 == null) goto L18;
        Context r14 = r13.getContext();
        if (r14 == null) goto L18;
        int r15 = i88.e.a(r14, 2130972086, 2131103159);
        RealtimeBottomMoreBtn r1 = this.a.getHostView();
        if (r1 == null) goto L18;
        r1.setBackground(i88.e.n(r15));
    L18:
        i r16 = this.f;
        if (r16 == null) goto L21;
        r16.invoke();
    L21:
        h r17 = this.g;
        if (r17 == null) goto L40;
        r17.invoke();
        return;
    L40:
        return;
    L25:
        throw new NoWhenBranchMatchedException();
    }

    public final Pair<CommonMenu, Balloon> n(final View r13, List<? extends ot8.a> r14) {
        if (r13 == null) goto L5;
        Fragment r1 = this.a.getFragment();
        if (r1 == null) goto L17;
        Context r2 = r1.getContext();
        if (r2 == null) goto L17;
        CommonMenu r3 = new CommonMenu(r2);
        r3.h(Reflection.getOrCreateKotlinClass(i0.class), new j0());
        r3.h(Reflection.getOrCreateKotlinClass(n1.class), new m1());
        r3.d(i5.B());
        r3.g(r14, new e(this, r13));
        Balloon r15 = com.larus.bmhome.view.screenmenu.d.a(com.larus.bmhome.view.screenmenu.d.a, r13, CommonMenu.j(r3, null, null, null, 15), false, null, null, null, new f(), 60);
        int r0 = j19.c.c(-70);
        if (z2.a.realtimeCallUseTwoLineStyle() == false) goto L13;
        int r4 = 0;
    L14:
        r15.s(r13, r0, j19.c.c(Integer.valueOf(r4)));
        return TuplesKt.to(r3, r15);
    L13:
        r4 = 20;
    L17:
        return TuplesKt.to(null, null);
    L5:
        return TuplesKt.to(null, null);
    }
}
