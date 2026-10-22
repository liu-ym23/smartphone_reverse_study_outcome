package com.bytedance.android.livesdk.interactivity.comment.newinput.provider;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.JsonUtil;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.profit.privilege.model.danmu.DanmakuTabList;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.chatroom.IRoomContextService;
import com.bytedance.android.livesdk.interactivity.api.IInteractivityInjectService;
import com.bytedance.android.livesdk.interactivity.comment.input.DanmakuTabAdapter;
import com.bytedance.android.livesdk.interactivity.comment.newinput.framework.InputPanelSectionContainer;
import com.bytedance.android.livesdk.interactivity.comment.newinput.framework.InputSectionType;
import com.bytedance.android.livesdk.utils.q4;
import com.bytedance.android.livesdk.utils.u4;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.bdlocation.BuildConfig;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class DanmakuSectionProvider implements com.bytedance.android.livesdk.interactivity.comment.newinput.framework.k<b, z62.c> {
    public final InputSectionType a;
    public com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g b;
    public b c;
    public final CompositeDisposable d;
    public View e;
    public final com.bytedance.android.live.profit.privilege.a f;
    public final CopyOnWriteArrayList<z62.i> g;
    public final c h;
    public final float i;
    public float j;
    public q4.b k;
    public q4.b l;

    public static final class a {
    }

    public final class b extends com.bytedance.android.livesdk.interactivity.comment.newinput.framework.j {
        public RecyclerView c;
        public DanmakuTabAdapter d;
        public final boolean e;
        public final com.bytedance.android.livesdk.interactivity.comment.newinput.c f;
        public final com.bytedance.android.livesdk.interactivity.comment.newinput.a g;
        public final FrameLayout h;
        public final /* synthetic */ DanmakuSectionProvider i;

        public final void g() {
            com.bytedance.android.livesdk.interactivity.comment.newinput.c r0 = this.f;
            if (r0 == null) goto L7;
            com.bytedance.android.livesdk.interactivity.comment.newinput.a r1 = r0.g;
            if (r1 == null) goto L7;
            r1.d = null;
        L7:
            com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r2 = this.i.b;
            if (r2 == null) goto L14;
            com.bytedance.android.livesdk.interactivity.comment.newinput.c r3 = r2.V();
            if (r3 == null) goto L14;
            com.bytedance.android.livesdk.interactivity.comment.newinput.a r4 = r3.g;
            if (r4 == null) goto L14;
            r4.c = false;
        L14:
            com.bytedance.android.live.profit.privilege.a r5 = this.i.f;
            if (r5 == null) goto L19;
            com.bytedance.live.datacontext.m r6 = r5.isInDanmakuMode();
            if (r6 == null) goto L19;
            r6.setValue(Boolean.FALSE);
        L19:
            DanmakuSectionProvider.i(this.i, null);
            Iterator<z62.i> r7 = this.i.g.iterator();
        L21:
            if (r7.hasNext() == false) goto L23;
            r7.next().onUpdate();
            goto L21
        L23:
            com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r8 = this.i.b;
            if (r8 == null) goto L28;
            com.bytedance.android.live.profit.privilege.model.danmu.b r9 = (com.bytedance.android.live.profit.privilege.model.danmu.b) vh7.f.c(com.bytedance.android.live.profit.privilege.model.danmu.b.class);
            r9.setStatus(0);
            r9.setStyle(21);
            Unit r10 = Unit.INSTANCE;
            r8.A(r9);
            return;
        }

        public b(DanmakuSectionProvider r2, View r3, com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r4) {
            Intrinsics.checkNotNullParameter(r3, "view");
            Intrinsics.checkNotNullParameter(r4, "panelBridge");
            this.i = r2;
            super(r3, r4);
            this.e = r4.n0();
            this.f = r4.V();
            com.bytedance.android.livesdk.interactivity.comment.newinput.c r5 = r4.V();
            if (r5 == null) goto L5;
            com.bytedance.android.livesdk.interactivity.comment.newinput.a r6 = r5.g;
        L6:
            this.g = r6;
            this.h = (FrameLayout) r3.findViewById(2131385187);
            return;
        L5:
            r6 = null;
            goto L6
        }
    }

    public static final class c implements z62.c {
        public final /* synthetic */ DanmakuSectionProvider a;

        @Override // z62.c
        public final void h() {
            b r0 = this.a.c;
            if (r0 == null) goto L6;
            r0.g();
            return;
        }

        @Override // z62.c
        public final int y() {
            b r0 = this.a.c;
            if (r0 == null) goto L10;
            FrameLayout r2 = r0.h;
            if (r2 != null) goto L7;
            return 0;
        L7:
            if (r2.getVisibility() == 0) goto L9;
            return 0;
        L9:
            return (int) r0.i.j;
        L10:
            return 0;
        }

        public c(DanmakuSectionProvider r1) {
            this.a = r1;
        }

        @Override // z62.c
        public final void A(com.bytedance.android.live.profit.privilege.model.danmu.b r3) {
            Intrinsics.checkNotNullParameter(r3, "tabItem");
            com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r0 = this.a.b;
            if (r0 == null) goto L13;
            com.bytedance.android.livesdk.interactivity.comment.newinput.c r1 = r0.V();
            if (r1 == null) goto L9;
            com.bytedance.android.livesdk.interactivity.comment.newinput.a r2 = r1.g;
            if (r2 == null) goto L9;
            r2.d = r3;
        L9:
            DanmakuSectionProvider.i(this.a, r3);
            r0.A(r3);
            Iterator<z62.i> r4 = this.a.g.iterator();
        L11:
            if (r4.hasNext() == false) goto L15;
            r4.next().onUpdate();
            goto L11
        L15:
            return;
        }

        @Override // z62.c
        public final void k(z62.i r2) {
            Intrinsics.checkNotNullParameter(r2, "listener");
            this.a.g.add(r2);
        }
    }

    static {
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.k
    public final void a() {
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.k
    public final void f() {
    }

    public static Map k() {
        HashMap r0 = new HashMap();
        IMiddlewareUserService r1 = jc1.k.f(IMiddlewareUserService.class);
        py.d r2 = null;
        if (r1 == null) goto L7;
        com.bytedance.android.livesdk.user.e r3 = r1.user();
        if (r3 == null) goto L7;
        IBaseUser r4 = r3.b();
    L8:
        if (r4 == null) goto L10;
        r2 = r4.getUserHonor();
    L10:
        if (r2 == null) goto L15;
        py.d r5 = r4.getUserHonor();
        if (r5 == null) goto L14;
        int r6 = r5.getLevel();
    L16:
        if (r4 == null) goto L19;
        String r7 = r4.getIdString();
        if (r7 == null) goto L19;
    L20:
        r0.put("user_id", r7);
        r0.put("privilege_level", String.valueOf(r6));
        return r0;
    L19:
        r7 = "0";
        goto L20
    L14:
        r6 = 0;
        goto L16
    L15:
        r6 = -1;
    L7:
        r4 = null;
        goto L8
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.k
    public final void d() {
        this.d.clear();
        q4.b r0 = this.k;
        if (r0 == null) goto L5;
        r0.a();
    L5:
        q4.b r1 = this.l;
        if (r1 == null) goto L9;
        r1.a();
        return;
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.k
    public final void e() {
        com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r0 = this.b;
        if (r0 != null) goto L6;
        return;
    L6:
        if (r0.n0() == false) goto L10;
        View r1 = this.e;
        if (r1 == null) goto L16;
        com.bytedance.android.live.core.utils.a1.k(r1, (int) this.i);
    L16:
        l(r0);
        b r2 = this.c;
        if (r2 == null) goto L26;
        FrameLayout r3 = r2.h;
        if (r3 == null) goto L27;
        q4.b r4 = this.k;
        if (r4 == null) goto L24;
        r4.a();
    L24:
        q4.b r5 = u4.c(new DanmakuSectionProvider$showWithAnimate$1(this, r3));
        r5.c();
        this.k = r5;
        return;
    L27:
        return;
    L26:
        return;
    L10:
        int r6 = InputPanelSectionContainer.m;
        if (r0.W() == 0) goto L13;
        r6 = r0.W();
    L13:
        View r7 = this.e;
        if (r7 == null) goto L16;
        com.bytedance.android.live.core.utils.a1.k(r7, r6);
        goto L16
    }

    public DanmakuSectionProvider() {
        this.a = InputSectionType.DANMAKU;
        this.d = new CompositeDisposable();
        this.f = yt0.c.i();
        this.g = new CopyOnWriteArrayList();
        this.h = new c(this);
        this.i = UtilityKotlinExtentionsKt.h(49);
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.k
    public final InputSectionType b() {
        return this.a;
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.k
    public final com.bytedance.android.livesdk.interactivity.comment.newinput.framework.j c() {
        return this.c;
    }

    public static void l(com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r4) {
        Map<String, String> r0 = k();
        if (r4.n0() == false) goto L5;
        String r5 = "portrait";
    L6:
        ((HashMap) r0).put("screen_layout", r5);
        IInteractivityInjectService r6 = (IInteractivityInjectService) jc1.k.f(IInteractivityInjectService.class);
        if (r6 == null) goto L9;
        r6.buildVsRoomLog(null, r0);
    L9:
        com.bytedance.android.livesdk.log.j0.l().sendLog("livesdk_danmu_tab_show", r0, new Object[]{am2.x.class, IRoom.class});
        return;
    L5:
        r5 = "landscape";
        goto L6
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.k
    public final void g(boolean r3) {
        int r0 = 0;
        if (r3 == true) goto L12;
        com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r4 = this.b;
        if (r4 == null) goto L35;
        com.bytedance.android.livesdk.interactivity.comment.newinput.c r5 = r4.V();
        if (r5 == null) goto L36;
        com.bytedance.android.livesdk.interactivity.comment.newinput.a r6 = r5.g;
        if (r6 == null) goto L37;
        r6.c = false;
        return;
    L37:
        return;
    L36:
        return;
    L35:
        return;
    L12:
        com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r7 = this.b;
        if (r7 != null) goto L15;
    L19:
        View r8 = this.e;
        if (r8 == null) goto L30;
        com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r1 = this.b;
        if (r1 != null) goto L24;
    L26:
        com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r2 = this.b;
        if (r2 == null) goto L29;
        r0 = r2.W();
    L29:
        com.bytedance.android.live.core.utils.a1.k(r8, r0);
        goto L30
    L24:
        if (r1.W() != 0) goto L26;
        r0 = InputPanelSectionContainer.m;
    L30:
        com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r9 = this.b;
        if (r9 != null) goto L33;
        return;
    L33:
        l(r9);
        return;
    L15:
        if (r7.n0() != true) goto L19;
        View r10 = this.e;
        if (r10 == null) goto L30;
        com.bytedance.android.live.core.utils.a1.k(r10, (int) this.i);
        goto L30
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.k
    public final View h(com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r8) {
        Intrinsics.checkNotNullParameter(r8, "panelBridge");
        Activity r0 = r8.getActivity();
        final Activity r1 = null;
        if (r0 != null) goto L5;
        return null;
    L5:
        this.b = r8;
        LayoutInflater r2 = LayoutInflater.from(r0);
        if (r8.n0() == true) goto L8;
        int r3 = 2131567709;
    L9:
        View r4 = r2.inflate(r3, null);
        this.e = r4;
        final b r5 = new b(this, r4, r8);
        r5.c = r5.a.findViewById(2131385186);
        v r6 = new v(r5);
        boolean r7 = r5.e;
        com.bytedance.android.livesdk.interactivity.comment.newinput.a r9 = r5.g;
        if (r9 != null) goto L12;
    L14:
        boolean r10 = false;
    L15:
        r5.d = new DanmakuTabAdapter(r6, r7, r10);
        com.bytedance.android.live.profit.privilege.a r11 = r5.i.f;
        if (r11 == null) goto L32;
        com.bytedance.live.datacontext.m r13 = r11.getDanmakuTabList();
        if (r13 == null) goto L32;
        DanmakuTabList r14 = (DanmakuTabList) r13.getValue();
        if (r14 == null) goto L32;
        List r15 = r14.getList();
        if (r15 == null) goto L32;
        if ((!r15.isEmpty()) != true) goto L32;
        DanmakuTabAdapter r16 = r5.d;
        if (r16 == null) goto L32;
        r16.A2((DanmakuTabList) r5.i.f.getDanmakuTabList().getValue());
        com.bytedance.android.livesdk.interactivity.comment.newinput.a r17 = r5.g;
        if (r17 == null) goto L30;
        com.bytedance.android.live.profit.privilege.model.danmu.b r18 = r17.d;
    L31:
        r16.z2(r18);
        goto L32
    L30:
        r18 = null;
    L32:
        RecyclerView r19 = r5.c;
        if (r19 == null) goto L38;
        com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r20 = r5.i.b;
        if (r20 == null) goto L37;
        r1 = r20.getActivity();
    L37:
        r19.setLayoutManager(new DanmakuSectionProvider$DanmakuSectionController$init$$inlined$apply$lambda$1(r1));
        r19.setAdapter(r5.d);
        r19.addItemDecoration(new DanmakuSectionProvider$DanmakuSectionController$init$$inlined$apply$lambda$2(r5));
    L38:
        DanmakuSectionProvider r21 = r5.i;
        com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r23 = r21.b;
        com.bytedance.android.live.profit.privilege.a r24 = r21.f;
        if (r24 == null) goto L41;
        r21.d.add(r24.getDanmakuTabList().a().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new w(r5, r23)));
    L41:
        Unit r25 = Unit.INSTANCE;
        this.c = r5;
        return r4;
    L12:
        if (r9.b != true) goto L14;
        r10 = true;
        goto L15
    L8:
        r3 = 2131567708;
        goto L9
    }

    public final void j(Function0<Unit> r3) {
        Intrinsics.checkNotNullParameter(r3, "doOnEnd");
        b r0 = this.c;
        if (r0 == null) goto L12;
        FrameLayout r1 = r0.h;
        if (r1 == null) goto L13;
        q4.b r2 = this.l;
        if (r2 == null) goto L10;
        r2.a();
    L10:
        q4.b r4 = u4.c(new DanmakuSectionProvider$dismissWithAnimate$1(this, r1, r3));
        r4.c();
        this.l = r4;
        return;
    L13:
        return;
    }

    public static final void i(DanmakuSectionProvider r6, com.bytedance.android.live.profit.privilege.model.danmu.b r7) {
        r6.getClass();
        IMiddlewareUserService r8 = jc1.k.f(IMiddlewareUserService.class);
        if (r8 == null) goto L9;
        com.bytedance.android.livesdk.user.e r9 = r8.user();
        if (r9 == null) goto L9;
        IBaseUser r10 = r9.b();
        if (r10 == null) goto L9;
        String r11 = r10.getIdString();
    L10:
        IRoomContextService r1 = jc1.k.f(IRoomContextService.class);
        if (r1 == null) goto L19;
        com.bytedance.android.livesdk.chatroom.o r0 = IRoomContextService.a.a(r1, null, 0, 3);
        if (r0 == null) goto L19;
        com.bytedance.live.datacontext.m r2 = r0.getRoom();
        if (r2 == null) goto L19;
        IRoom r3 = (IRoom) r2.getValue();
        if (r3 == null) goto L19;
        long r4 = r3.getId();
    L20:
        String r13 = r11 + r4;
        com.bytedance.android.livesdk.sharedpref.e<Map<String, String>> r5 = l42.a.i;
        Map r14 = (Map) r5.getValue();
        if (r14 != null) goto L23;
        r14 = new HashMap();
    L23:
        String r15 = new SimpleDateFormat("yyyyMMdd").format(new Date(System.currentTimeMillis()));
        if (r7 == null) goto L26;
        String r16 = JsonUtil.toJSONString(new g92.c(r7, r15, 2));
    L27:
        r14.put(r13, r16);
        com.bytedance.android.livesdk.sharedpref.f.d(r5, r14);
        return;
    L26:
        r16 = BuildConfig.FLAVOR;
    L19:
        r4 = -1;
    L9:
        r11 = null;
        goto L10
    }
}
