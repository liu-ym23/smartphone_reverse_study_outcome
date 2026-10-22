package com.bytedance.android.livesdk.gift.vs.panel.statemachine.helper;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.livesdk.gift.model.w0;
import com.bytedance.android.livesdk.gift.model.w1;
import com.bytedance.android.livesdk.gift.platform.business.dialog.ui.panel.AbsPanel;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v2.viewmodel.GiftStateMachineConfig;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.GiftReceiverRepoService;
import com.bytedance.android.livesdk.gift.platform.core.GiftContext;
import com.bytedance.android.livesdk.gift.platform.core.model.ReceiverType;
import com.bytedance.android.livesdk.gift.platform.core.utils.u;
import com.bytedance.android.livesdk.gift.platform.core.utils.x;
import com.bytedance.android.livesdk.gift.vs.panel.statemachine.GiftDialogViewModelNew;
import com.bytedance.android.livesdk.gift.vs.panel.statemachine.GiftListViewModelNew;
import com.bytedance.android.livesdk.gift.vs.panel.statemachine.GiftReceiverViewModel;
import com.bytedance.android.livesdk.gift.vs.panel.statemachine.GiftTabViewModelNew;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.scope.m;
import com.bytedance.live.datacontext.i;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import i12.o;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import pz1.d;
import pz1.e;
import vh7.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class b {
    public static final boolean s() {
        if (a(2) == true) goto L5;
    L8:
        boolean r0 = false;
    L9:
        if (r0 == true) goto L11;
        return false;
    L11:
        GiftReceiverViewModel r1 = m();
        if (r1 == null) goto L14;
        a r2 = r1.f();
    L16:
        if ((r2 instanceof a.c) == true) goto L18;
        return false;
    L18:
        return ((a.c) r2).e;
    L14:
        r2 = null;
        goto L16
    L5:
        if (a(4) == true) goto L8;
        r0 = true;
        goto L9
    }

    public static final List<List<AbsPanel<?>>> b() {
        ArrayList r0 = new ArrayList();
        GiftListViewModelNew r1 = l();
        boolean r3 = true;
        int r4 = 0;
        if (r1 == null) goto L40;
        GiftStateMachineConfig.e r2 = (GiftStateMachineConfig.e) r1.j.b();
        if (r2 == null) goto L40;
        if ((r2 instanceof GiftStateMachineConfig.e.c) == false) goto L14;
        GiftStateMachineConfig.c r5 = ((GiftStateMachineConfig.e.c) r2).a;
        if (r5 == null) goto L20;
        List<List<AbsPanel<?>>> r6 = r5.d;
        if (r6 == null) goto L20;
        List r7 = CollectionsKt.toList(r6);
    L21:
        if (r7 != null) goto L23;
        r7 = CollectionsKt.emptyList();
    L23:
        List r8 = CollectionsKt.toMutableList(r7);
        if (r8.size() <= 0) goto L26;
        ListProtector.set(r8, 0, q(1));
    L26:
        Iterator r9 = r8.iterator();
    L28:
        if (r9.hasNext() == false) goto L40;
        List r10 = (List) r9.next();
        ArrayList r11 = new ArrayList();
        Iterator r13 = r10.iterator();
    L31:
        if (r13.hasNext() == false) goto L34;
        r11.add((AbsPanel) r13.next());
        goto L31
    L34:
        if (r10.isEmpty() == false) goto L37;
        r11.add(new d());
    L37:
        if ((r11.size() % 8) == 0) goto L39;
        r11.add(new d());
        goto L37
    L39:
        r0.add(r11);
    L20:
        r7 = null;
        goto L21
    L14:
        if ((r2 instanceof GiftStateMachineConfig.e.b) == false) goto L20;
        GiftStateMachineConfig.c r14 = ((GiftStateMachineConfig.e.b) r2).a;
        if (r14 == null) goto L20;
        List<List<AbsPanel<?>>> r15 = r14.d;
        if (r15 == null) goto L20;
        r7 = CollectionsKt.toList(r15);
    L40:
        GiftListViewModelNew r16 = l();
        if (r16 == null) goto L72;
        GiftStateMachineConfig.e r17 = (GiftStateMachineConfig.e) r16.j.b();
        if (r17 == null) goto L72;
        List<e> r18 = r17.c();
        if (r18 == null) goto L72;
        ArrayList r19 = new ArrayList();
        Iterator<T> r20 = r18.iterator();
    L48:
        if (r20.hasNext() == false) goto L51;
        r19.add((e) r20.next());
        goto L48
    L51:
        if (nz1.a.d().length() > 0) goto L54;
        r3 = false;
    L54:
        if (r3 == false) goto L66;
        if (r18.isEmpty() == false) goto L59;
        r19.add(new pz1.b());
    L59:
        if ((r19.size() % 8) != 0) goto L63;
    L60:
        if (r4 >= 8) goto L63;
        r19.add(new pz1.b());
        r4 = r4 + 1;
    L63:
        if ((r19.size() % 8) == 0) goto L71;
        r19.add(new pz1.b());
    L71:
        r0.add(r19);
        goto L72
    L66:
        if (r18.isEmpty() == false) goto L69;
        r19.add(new d());
    L69:
        if ((r19.size() % 8) == 0) goto L71;
        r19.add(new d());
    L72:
        return r0;
    }

    public static final List<AbsPanel<?>> c() {
        GiftListViewModelNew r0 = l();
        if (r0 == null) goto L7;
        return r0.f(f());
    L7:
        return new ArrayList();
    }

    public static final AbsPanel<?> d() {
        GiftDialogViewModelNew r0 = j();
        if (r0 != null) goto L7;
        return null;
    L7:
        return ((GiftStateMachineConfig.a) r0.f.b()).a();
    }

    public static final List<IBaseUser> e() {
        Object r1 = null;
        if (u.r() == true) goto L13;
        i12.e r0 = o.b();
        if (r0 == null) goto L7;
        r1 = m.e.d(r0, GiftReceiverRepoService.class);
    L7:
        GiftReceiverRepoService r2 = (GiftReceiverRepoService) r1;
        if (r2 == null) goto L12;
        List<IBaseUser> r3 = r2.k().a;
        if (r3 == null) goto L12;
        return r3;
    L12:
        return new ArrayList();
    L13:
        GiftReceiverViewModel r4 = m();
        if (r4 == null) goto L43;
        a r5 = r4.f();
        if (r5 == null) goto L43;
        Collection r6 = new ArrayList();
        if ((r5 instanceof a.c) == false) goto L35;
        Iterator<Map.Entry<Integer, GiftStateMachineConfig.d>> r7 = ((a.c) r5).c.entrySet().iterator();
    L21:
        if (r7.hasNext() == false) goto L35;
        Map.Entry<Integer, GiftStateMachineConfig.d> r8 = r7.next();
        int r9 = r8.getKey().intValue();
        i12.e r10 = o.b();
        if (r10 == null) goto L25;
        Object r11 = m.e.d(r10, GiftReceiverRepoService.class);
    L26:
        GiftReceiverRepoService r13 = (GiftReceiverRepoService) r11;
        if (r13 == null) goto L29;
        boolean r14 = r13.q(r9);
    L30:
        if (r14 == false) goto L33;
        r6 = CollectionsKt.plus(r6, r8.getValue().a);
    L33:
        if (r8.getKey().intValue() != 4) goto L21;
        w0 r15 = r8.getValue().b;
        goto L21
    L29:
        r14 = false;
        goto L30
    L25:
        r11 = null;
    L35:
        HashSet r16 = new HashSet();
        ArrayList r17 = new ArrayList();
        Iterator r18 = r6.iterator();
    L37:
        if (r18.hasNext() == false) goto L41;
        Object r19 = r18.next();
        if (r16.add(((IBaseUser) r19).getIdString()) == false) goto L37;
        r17.add(r19);
        goto L37
    L41:
        Intrinsics.checkNotNullParameter(r17, "userList");
        return r17;
    L43:
        return new ArrayList();
    }

    @Deprecated(message = "no")
    public static final int f() {
        GiftTabViewModelNew r0 = n();
        if (r0 != null) goto L5;
        return 0;
    L5:
        if ((r0.e.b() instanceof GiftStateMachineConfig.h.a) == false) goto L12;
        Object r1 = r0.e.b();
        if (r1 == null) goto L10;
        return ((GiftStateMachineConfig.h.a) r1).a;
    L10:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.gift.platform.business.dialog.v2.viewmodel.GiftStateMachineConfig.TabState.Tab");
    L12:
        return 0;
    }

    public static final w1 g() {
        GiftListViewModelNew r0 = l();
        if (r0 == null) goto L5;
        List<w1> r1 = r0.g();
    L6:
        Iterator<w1> r2 = r1.iterator();
    L8:
        if (r2.hasNext() == false) goto L12;
        w1 r3 = r2.next();
        if (r3.getPageType() != f()) goto L8;
        return r3;
    L12:
        return null;
    L5:
        r1 = new ArrayList();
        goto L6
    }

    public static final int h() {
        List<w1> r0 = k();
        int r1 = r0.size();
        int r3 = 0;
    L3:
        if (r3 >= r1) goto L8;
        if (((w1) ListProtector.get(r0, r3)).getPageType() == f()) goto L6;
        r3 = r3 + 1;
        goto L3
    L6:
        return r3;
    L8:
        return 0;
    }

    @Deprecated(message = "no")
    public static final GiftStateMachineConfig.a i() {
        GiftDialogViewModelNew r0 = j();
        if (r0 != null) goto L7;
        return null;
    L7:
        return (GiftStateMachineConfig.a) r0.f.b();
    }

    public static final GiftDialogViewModelNew j() {
        GiftContext r0 = com.bytedance.android.livesdk.gift.util.b.b();
        com.bytedance.android.livesdk.gift.platform.business.dialog.v2.viewmodel.a r1 = null;
        if (r0 == null) goto L9;
        i<Map<String, com.bytedance.android.livesdk.gift.platform.business.dialog.v2.viewmodel.a>> r2 = r0.getGiftViewModelMap();
        if (r2 == null) goto L9;
        Map r3 = (Map) r2.getValue();
        if (r3 == null) goto L9;
        com.bytedance.android.livesdk.gift.platform.business.dialog.v2.viewmodel.a r4 = (com.bytedance.android.livesdk.gift.platform.business.dialog.v2.viewmodel.a) r3.get("GiftDialogViewModel");
    L11:
        if ((r4 instanceof GiftDialogViewModelNew) == false) goto L15;
        r1 = r4;
    L15:
        return (GiftDialogViewModelNew) r1;
    L9:
        r4 = null;
        goto L11
    }

    public static final List<w1> k() {
        GiftListViewModelNew r0 = l();
        if (r0 == null) goto L12;
        List<w1> r1 = r0.g();
        ArrayList r2 = new ArrayList();
        Iterator<T> r3 = r1.iterator();
    L6:
        if (r3.hasNext() == false) goto L10;
        Object r4 = r3.next();
        if (((w1) r4).getDisplay() == false) goto L6;
        r2.add(r4);
        goto L6
    L10:
        return r2;
    L12:
        return new ArrayList();
    }

    public static final GiftListViewModelNew l() {
        GiftContext r0 = com.bytedance.android.livesdk.gift.util.b.b();
        com.bytedance.android.livesdk.gift.platform.business.dialog.v2.viewmodel.a r1 = null;
        if (r0 == null) goto L9;
        i<Map<String, com.bytedance.android.livesdk.gift.platform.business.dialog.v2.viewmodel.a>> r2 = r0.getGiftViewModelMap();
        if (r2 == null) goto L9;
        Map r3 = (Map) r2.getValue();
        if (r3 == null) goto L9;
        com.bytedance.android.livesdk.gift.platform.business.dialog.v2.viewmodel.a r4 = (com.bytedance.android.livesdk.gift.platform.business.dialog.v2.viewmodel.a) r3.get("GiftListViewModel");
    L11:
        if ((r4 instanceof GiftListViewModelNew) == false) goto L15;
        r1 = r4;
    L15:
        return (GiftListViewModelNew) r1;
    L9:
        r4 = null;
        goto L11
    }

    public static final GiftReceiverViewModel m() {
        GiftContext r0 = com.bytedance.android.livesdk.gift.util.b.b();
        com.bytedance.android.livesdk.gift.platform.business.dialog.v2.viewmodel.a r1 = null;
        if (r0 == null) goto L9;
        i<Map<String, com.bytedance.android.livesdk.gift.platform.business.dialog.v2.viewmodel.a>> r2 = r0.getGiftViewModelMap();
        if (r2 == null) goto L9;
        Map r3 = (Map) r2.getValue();
        if (r3 == null) goto L9;
        com.bytedance.android.livesdk.gift.platform.business.dialog.v2.viewmodel.a r4 = (com.bytedance.android.livesdk.gift.platform.business.dialog.v2.viewmodel.a) r3.get("GiftReceiverViewModel");
    L11:
        if ((r4 instanceof GiftReceiverViewModel) == false) goto L15;
        r1 = r4;
    L15:
        return (GiftReceiverViewModel) r1;
    L9:
        r4 = null;
        goto L11
    }

    public static final GiftTabViewModelNew n() {
        GiftContext r0 = com.bytedance.android.livesdk.gift.util.b.b();
        com.bytedance.android.livesdk.gift.platform.business.dialog.v2.viewmodel.a r1 = null;
        if (r0 == null) goto L9;
        i<Map<String, com.bytedance.android.livesdk.gift.platform.business.dialog.v2.viewmodel.a>> r2 = r0.getGiftViewModelMap();
        if (r2 == null) goto L9;
        Map r3 = (Map) r2.getValue();
        if (r3 == null) goto L9;
        com.bytedance.android.livesdk.gift.platform.business.dialog.v2.viewmodel.a r4 = (com.bytedance.android.livesdk.gift.platform.business.dialog.v2.viewmodel.a) r3.get("GiftTabViewModel");
    L11:
        if ((r4 instanceof GiftTabViewModelNew) == false) goto L15;
        r1 = r4;
    L15:
        return (GiftTabViewModelNew) r1;
    L9:
        r4 = null;
        goto L11
    }

    public static final List<IBaseUser> o() {
        GiftReceiverViewModel r0 = m();
        if (r0 == null) goto L5;
        a r1 = r0.f();
    L7:
        if ((r1 instanceof a.c) == true) goto L9;
    L13:
        return null;
    L9:
        if (s() == false) goto L13;
        return ((a.c) r1).d;
    L5:
        r1 = null;
        goto L7
    }

    public static final IBaseUser r() {
        GiftReceiverViewModel r0 = m();
        if (r0 == null) goto L5;
        a r1 = r0.f();
    L7:
        if ((r1 instanceof a.c) == true) goto L15;
        IRoom r2 = x.a();
        if (r2 == null) goto L14;
        IBaseUser r3 = r2.getOwner();
        if (r3 == null) goto L14;
        return r3;
    L14:
        return f.c(IBaseUser.class);
    L15:
        return ((a.c) r1).a;
    L5:
        r1 = null;
        goto L7
    }

    public static final boolean t() {
        GiftReceiverViewModel r0 = m();
        if (r0 == null) goto L5;
        a r1 = r0.f();
    L7:
        if ((r1 instanceof a.c) == true) goto L9;
        return false;
    L9:
        if (((a.c) r1).f != ReceiverType.Audience) goto L13;
        return true;
    L13:
        return false;
    L5:
        r1 = null;
        goto L7
    }

    public static final boolean a(int r3) {
        GiftReceiverViewModel r0 = m();
        if (r0 == null) goto L10;
        a r1 = r0.f();
        if (r1 != null) goto L7;
        return false;
    L7:
        if ((r1 instanceof a.c) == true) goto L9;
        return false;
    L9:
        return !r1.b(r3).a.isEmpty();
    L10:
        return false;
    }

    public static final int p(int r3) {
        GiftTabViewModelNew r0 = n();
        if (r0 != null) goto L5;
        return 0;
    L5:
        if ((r0.e.b() instanceof GiftStateMachineConfig.h.a) == false) goto L12;
        Object r1 = r0.e.b();
        if (r1 == null) goto L10;
        return ((GiftStateMachineConfig.h.a) r1).a(r3);
    L10:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.gift.platform.business.dialog.v2.viewmodel.GiftStateMachineConfig.TabState.Tab");
    L12:
        return 0;
    }

    public static final List<AbsPanel<?>> q(int r1) {
        GiftListViewModelNew r0 = l();
        if (r0 == null) goto L7;
        return r0.f(r1);
    L7:
        return new ArrayList();
    }
}
