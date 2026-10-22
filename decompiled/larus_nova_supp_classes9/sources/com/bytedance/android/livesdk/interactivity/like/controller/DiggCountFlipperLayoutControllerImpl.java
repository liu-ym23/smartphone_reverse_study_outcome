package com.bytedance.android.livesdk.interactivity.like.controller;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.utils.x;
import com.bytedance.android.live.room.IRoomService;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.config.xm;
import com.bytedance.android.livesdk.interactivity.api.like.datacontext.DiggContext;
import com.bytedance.android.livesdk.interactivity.api.like.utils.UserInfoDiggBridge;
import com.bytedance.android.livesdk.interactivity.like.view.DiggCountFlipperLayout;
import com.bytedance.android.livesdk.message.model.ii;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.m;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.List;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import u32.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class DiggCountFlipperLayoutControllerImpl extends u32.d {
    public View b;
    public DiggCountFlipperLayout c;
    public View d;
    public DiggCountFlipperLayout e;
    public View f;
    public DiggCountFlipperLayout g;
    public boolean h;
    public final boolean i;
    public String j;
    public Disposable k;
    public DataCenter l;

    public static final class a {
    }

    public static final class b implements DiggCountFlipperLayout.b {
        public final /* synthetic */ DiggCountFlipperLayoutControllerImpl a;

        public b(DiggCountFlipperLayoutControllerImpl r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.livesdk.interactivity.like.view.DiggCountFlipperLayout.b
        public final void a(int r5) {
            DiggCountFlipperLayoutControllerImpl r0 = this.a;
            List<Pair<String, String>> r1 = r0.i();
            if (r1 == null) goto L13;
            int r2 = r1.size();
            if (r2 <= 0) goto L14;
            Pair r6 = (Pair) ListProtector.get(r1, r5 % r2);
            String r3 = (String) r6.getFirst();
            String r7 = (String) r6.getSecond();
            ALogger.d("Flip", "  descText  :   " + r3 + "  countStr :   " + r7);
            DiggCountFlipperLayout r4 = r0.e;
            if (r4 == null) goto L9;
            r4.p(r7, r3);
        L9:
            DiggCountFlipperLayout r8 = r0.g;
            if (r8 == null) goto L15;
            r8.p(r7, r3);
            return;
        L15:
            return;
        L14:
            return;
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ DiggCountFlipperLayoutControllerImpl a;

        public c(DiggCountFlipperLayoutControllerImpl r1) {
            this.a = r1;
        }

        public final void accept(Object r1) {
            Boolean r2 = (Boolean) r1;
            this.a.e();
        }
    }

    static {
    }

    @Override // u32.b
    public final void b() {
        DiggContext.a r0 = DiggContext.Companion;
        DataCenter r1 = this.l;
        r0.getClass();
        DiggContext r2 = DiggContext.a.a(r1);
        if (r2 == null) goto L17;
        r2.getDiggCountFlipperLayoutController().setValue(this);
        if (((Boolean) xm.a.getValue()).booleanValue() == false) goto L13;
        RoomContext r3 = RoomContext.a.c(RoomContext.Companion, this.l, 0, 2);
        if (r3 == null) goto L16;
        m r4 = r3.getRoom();
        if (r4 == null) goto L16;
        Room r5 = (Room) r4.getValue();
        if (r5 == null) goto L16;
        g(r5.getDiggCount());
    L16:
        this.k = r2.getInDoubleLike().a().subscribe(new c(this));
        goto L17
    L13:
        k r6 = (k) r2.getDiggWidget().getValue();
        if (r6 == null) goto L16;
        g(r6.getDiggCount());
    L17:
        h();
    }

    @Override // u32.b
    public final void c() {
        DiggContext.a r0 = DiggContext.Companion;
        DataCenter r1 = this.l;
        r0.getClass();
        DiggContext r2 = DiggContext.a.a(r1);
        if (r2 == null) goto L5;
        r2.getDiggCountFlipperLayoutController().setValue(null);
    L5:
        this.h = false;
        j(this.c, this.b);
        j(this.e, this.d);
        j(this.g, this.f);
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
        Disposable r3 = this.k;
        if (r3 == null) goto L8;
        r3.dispose();
    L8:
        this.k = null;
    }

    @Override // u32.d
    public final View d() {
        boolean r0 = this.h;
        if (r0 == true) goto L5;
    L8:
        if (r0 == false) goto L10;
    L17:
        if (this.h == false) goto L21;
        View r1 = this.g;
        if (r1 != null) goto L24;
        r1 = this.c;
    L24:
        if (r1 != null) goto L36;
        View r2 = this.a.f();
        if (r2 == null) goto L29;
        Context r3 = r2.getContext();
        if (r3 == null) goto L29;
    L33:
        if (r3 != null) goto L35;
        r3 = jc1.a.b();
    L35:
        r1 = new View(r3);
    L29:
        View r4 = this.a.b();
        if (r4 == null) goto L32;
        r3 = r4.getContext();
        goto L33
    L32:
        r3 = null;
    L36:
        return r1;
    L21:
        r1 = this.f;
        if (r1 != null) goto L24;
        r1 = this.b;
        goto L24
    L10:
        if (this.f != null) goto L17;
        if (this.b != null) goto L17;
    L37:
        h();     // Catch: Exception -> L15
        goto L17
    L5:
        if (this.g != null) goto L8;
        if (this.c == null) goto L37;
        goto L8
    }

    @Override // u32.d
    public final void e() {
        DiggContext.a r0 = DiggContext.Companion;
        DataCenter r1 = this.l;
        r0.getClass();
        DiggContext r2 = DiggContext.a.a(r1);
        if (r2 == null) goto L9;
        m<Boolean> r3 = r2.getInDoubleLike();
        if (r3 == null) goto L9;
        if (((Boolean) r3.getValue()).booleanValue() != true) goto L9;
        int r4 = UserInfoDiggBridge.e;
    L10:
        u32.d.a r5 = this.a;
        if (r5 == null) goto L13;
        List<Pair<String, String>> r6 = r5.d();
    L14:
        if (r6 != null) goto L25;
        DiggCountFlipperLayout r7 = this.c;
        if (r7 == null) goto L18;
        r7.n(r4);
    L18:
        DiggCountFlipperLayout r8 = this.e;
        if (r8 == null) goto L21;
        r8.n(r4);
    L21:
        DiggCountFlipperLayout r9 = this.g;
        if (r9 == null) goto L26;
        r9.n(r4);
        return;
    L26:
        return;
    L25:
        return;
    L13:
        r6 = null;
    L9:
        r4 = UserInfoDiggBridge.f;
        goto L10
    }

    public final void h() {
        Room r0 = jc1.k.n(IRoomService.class).getCurrentRoom();
        View r1 = null;
        if (r0 == null) goto L5;
        Integer r2 = Integer.valueOf(r0.getAnchorTabType());
    L6:
        if (r2 == null) goto L22;
        if (r2.intValue() != 4) goto L22;
        if (this.i == true) goto L22;
        DiggCountFlipperLayout r3 = this.c;
        if (r3 == null) goto L15;
        r3.setVisibility(8);
    L15:
        DiggCountFlipperLayout r4 = this.e;
        if (r4 == null) goto L18;
        r4.setVisibility(8);
    L18:
        DiggCountFlipperLayout r5 = this.g;
        if (r5 == null) goto L22;
        r5.setVisibility(8);
    L22:
        if (this.h == false) goto L24;
        return;
    L24:
        if (this.a.b() != null) goto L26;
    L39:
        View r6 = this.a.f();
        if (r6 == null) goto L42;
        DiggCountFlipperLayout r7 = new DiggCountFlipperLayout(this.l, r6.getContext(), r6, null, null, this.a.c(), this.a.a(), this.a.e(), 24);
        r7.setContentDescriptionAction(new DiggCountFlipperLayoutControllerImpl$ensureStarted$4$1$1(this.a));
        Unit r8 = Unit.INSTANCE;
        this.c = r7;
        j(r6, r7);
        r1 = r6;
    L42:
        this.b = r1;
    L43:
        this.h = true;
        return;
    L26:
        if (this.a.g() == null) goto L39;
        View r9 = this.a.b();
        if (r9 == null) goto L30;
        DiggCountFlipperLayout r13 = new DiggCountFlipperLayout(this.l, r9.getContext(), null, r9, null, this.a.c(), null, null, 212);
        this.e = r13;
        j(r9, r13);
        Unit r10 = Unit.INSTANCE;
    L31:
        this.d = r9;
        View r11 = this.a.g();
        if (r11 == null) goto L34;
        DiggCountFlipperLayout r14 = new DiggCountFlipperLayout(this.l, r11.getContext(), null, null, r11, this.a.c(), null, null, 204);
        this.g = r14;
        j(r11, r14);
        Unit r15 = Unit.INSTANCE;
        r1 = r11;
    L34:
        this.f = r1;
        if (i() == null) goto L43;
        DiggCountFlipperLayout r16 = this.g;
        if (r16 == null) goto L43;
        r16.setFlipCount(new b(this));
        goto L43
    L30:
        r9 = null;
        goto L31
    L5:
        r2 = null;
        goto L6
    }

    public final List<Pair<String, String>> i() {
        List<Pair<String, String>> r0 = this.a.d();
        if (r0 == null) goto L7;
        String r1 = this.j;
        if (r1 == null) goto L7;
        Boolean.valueOf(r0.add(new Pair(s1.C(2131916203, new Object[]{BuildConfig.FLAVOR}), r1))).booleanValue();
    L7:
        return r0;
    }

    public DiggCountFlipperLayoutControllerImpl(u32.d.a r2) {
        Intrinsics.checkNotNullParameter(r2, "initializer");
        super(r2);
        Room r3 = jc1.k.n(IRoomService.class).getCurrentRoom();
        if (r3 == null) goto L7;
        User r4 = r3.getOwner();
        if (r4 == null) goto L7;
        String r5 = r4.getIdStr();
    L8:
        this.i = Intrinsics.areEqual(r5, jc1.k.n(IUserService.class).user().n());
        this.j = BuildConfig.FLAVOR;
        return;
    L7:
        r5 = null;
        goto L8
    }

    @Override // u32.b
    public final void a(DataCenter r2) {
        Intrinsics.checkNotNullParameter(r2, "dataCenter");
        this.l = r2;
    }

    @Override // u32.d
    public final void f(ii r2) {
        Intrinsics.checkNotNullParameter(r2, "message");
        DiggCountFlipperLayout r0 = this.c;
        if (r0 == null) goto L6;
        r0.m(r2);
        return;
    }

    @Override // u32.d
    public final void g(long r1) {
        h();
        this.j = x.a(r1);
        u32.d.a r2 = this.a;
        if (r2 == null) goto L5;
        List<Pair<String, String>> r3 = r2.d();
    L6:
        if (r3 != null) goto L14;
        DiggCountFlipperLayout r4 = this.c;
        if (r4 == null) goto L10;
        r4.o(this.j);
    L10:
        DiggCountFlipperLayout r5 = this.e;
        if (r5 == null) goto L15;
        r5.o(this.j);
        return;
    L15:
        return;
    L14:
        return;
    L5:
        r3 = null;
        goto L6
    }

    public static void j(View r4, View r5) {
        if (r4 == null) goto L17;
        if (r5 == null) goto L18;
        ViewParent r0 = r4.getParent();
        if (r0 == null) goto L16;
        ViewGroup r1 = (ViewGroup) r0;
        int r2 = r1.indexOfChild(r4);
        ViewGroup.LayoutParams r3 = r4.getLayoutParams();
        r1.removeView(r4);
        ViewParent r6 = r5.getParent();
        if ((r6 instanceof ViewGroup) == true) goto L10;
        r6 = null;
    L10:
        ViewGroup r7 = (ViewGroup) r6;
        if (r7 == null) goto L13;
        r7.removeView(r5);
    L13:
        r1.addView(r5, r2, r3);
        return;
    L16:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    L18:
        return;
    }
}
