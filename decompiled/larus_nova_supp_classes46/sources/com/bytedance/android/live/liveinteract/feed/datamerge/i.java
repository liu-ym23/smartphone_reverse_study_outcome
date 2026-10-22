package com.bytedance.android.live.liveinteract.feed.datamerge;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.liveinteract.multianchor.model.LinkmicPositionItem;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.MultiLinkGuestViewBinder;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.MultiLinkLastEmptyViewBinder;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.MultiLinkNormalEmptyViewBinder;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.MultiLinkSpecialViewBinder;
import com.bytedance.android.livesdk.link.model.z5;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.audio.IVoiceLiveTheme;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import io.reactivex.Observable;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public class i extends com.bytedance.android.live.liveinteract.plantform.datamerge.a {
    public final k j;

    public static final class a<T1, T2, R> implements BiFunction {
        public final /* synthetic */ i a;

        public a(i r1) {
            this.a = r1;
        }

        public final Object apply(Object r3, Object r4) {
            List r5 = (List) r3;
            List r6 = (List) r4;
            Intrinsics.checkNotNullParameter(r5, "list");
            Intrinsics.checkNotNullParameter(r6, "remoteList");
            if (this.a.a == false) goto L6;
            ALogger.i("WindowListHelper", "linkedUserMergeDataListObservable and remoteLinkedUserMergeDataListObservable change, size: self " + r5.size() + " remote " + r6.size());
            this.a.u();
        L6:
            return Unit.INSTANCE;
        }
    }

    public static final class b<T> implements Consumer {
        public static final b a = null;

        static {
            a = new b();
        }

        public b() {
        }

        public final /* bridge */ /* synthetic */ void accept(Object r1) {
            Unit r2 = (Unit) r1;
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ i a;

        public c(i r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            List r4 = (List) r3;
            if (this.a.a == false) goto L6;
            ALogger.i("WindowListHelper", "linkedUserMergeDataListObservable change, size: " + r4.size());
            this.a.u();
            return;
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ i a;

        public d(i r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            List r3 = (List) r2;
            i r4 = this.a;
            if (r4.a == false) goto L6;
            r4.u();
            return;
        }
    }

    public static final class e<T> implements Consumer {
        public final /* synthetic */ i a;

        public e(i r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            ConcurrentHashMap r3 = (ConcurrentHashMap) r2;
            i r4 = this.a;
            if (r4.a == false) goto L6;
            r4.u();
            return;
        }
    }

    public static final class f<T> implements Consumer {
        public final /* synthetic */ i a;

        public f(i r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            wg0.a r3 = (wg0.a) r2;
            i r4 = this.a;
            if (r4.a == false) goto L6;
            r4.u();
            return;
        }
    }

    public static final class g<T> implements Consumer {
        public final /* synthetic */ i a;

        public g(i r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            ch0.a r3 = (ch0.a) r2;
            i r4 = this.a;
            if (r4.a == false) goto L6;
            r4.u();
            return;
        }
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.datamerge.a
    public final void u() {
        IVoiceLiveTheme r1 = null;
        String r2 = "";
        if (aj0.a.c(this.g.j()) == false) goto L46;
        int r0 = this.h.a;
        ArrayList r4 = new ArrayList(r0);
        int r5 = 0;
    L5:
        if (r5 >= r0) goto L7;
        r4.add(g(r5));
        r5 = r5 + 1;
        goto L5
    L7:
        IRoom r6 = this.d;
        if (r6 == null) goto L13;
        String r7 = r6.getOwnerUserIdString();
        if (r7 == null) goto L13;
        r2 = r7;
    L13:
        i(r2, r4, this.j.o(), r0);
        i(r2, r4, this.j.d(), r0);
        switch(this.g.getUiLayout()) {
            case 56: goto L34;
            case 57: goto L26;
            case 58: goto L16;
            default: goto L42;
        };
    L16:
        Iterator r3 = r4.iterator();
    L18:
        if (r3.hasNext() == false) goto L42;
        tf0.e r8 = (tf0.e) r3.next();
        int r9 = r8.a;
        if (1 > r9) goto L22;
        if (5 < r9) goto L22;
    L25:
        r8.j = false;
    L22:
        if (7 > r9) goto L18;
        if (11 < r9) goto L18;
    L26:
        Iterator r10 = r4.iterator();
    L28:
        if (r10.hasNext() == false) goto L42;
        tf0.e r11 = (tf0.e) r10.next();
        int r12 = r11.a;
        if (7 > r12) goto L28;
        if (11 < r12) goto L28;
        r11.j = false;
        goto L28
    L34:
        Iterator r13 = r4.iterator();
    L36:
        if (r13.hasNext() == false) goto L42;
        tf0.e r14 = (tf0.e) r13.next();
        int r15 = r14.a;
        if (1 > r15) goto L36;
        if (5 < r15) goto L36;
        r14.j = false;
    L42:
        y(r4);
        IRoom r16 = this.d;
        if (r16 == null) goto L45;
        r1 = r16.getVoiceLiveTheme();
    L45:
        v(r1, r4);
        z(r4);
        this.b.onNext(r4);
        return;
    L46:
        int r17 = this.h.a;
        ArrayList r18 = new ArrayList(r17);
        int r19 = 0;
    L47:
        if (r19 >= r17) goto L49;
        r18.add(g(r19));
        r19 = r19 + 1;
        goto L47
    L49:
        IRoom r20 = this.d;
        if (r20 == null) goto L55;
        String r21 = r20.getOwnerUserIdString();
        if (r21 == null) goto L55;
        r2 = r21;
    L55:
        List<ch0.e> r22 = this.j.o();
        i(r2, r18, r22, r17);
        y(r18);
        o(r2, r18);
        n(r2, r18);
        p(r18);
        m(r2, r18, new ch0.l(0, null));
        l(r18, r22, r17, r2);
        IRoom r23 = this.d;
        if (r23 == null) goto L58;
        r1 = r23.getVoiceLiveTheme();
    L58:
        v(r1, r18);
        z(r18);
        this.b.onNext(r18);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.datamerge.a
    public final MultiLinkNormalEmptyViewBinder.a g(int r14) {
        IRoom r0 = this.d;
        if (r0 == null) goto L7;
        z5 r1 = r0.getLinkerDetail();
        if (r1 == null) goto L7;
        List r2 = r1.getPlayModes();
    L8:
        if (r2 != null) goto L10;
    L12:
        boolean r7 = false;
    L14:
        return new MultiLinkNormalEmptyViewBinder.a(r14, null, null, false, r7, false, false, true, false, 768);
    L10:
        if (r2.contains(Long.valueOf(5)) != true) goto L12;
        r7 = true;
    L7:
        r2 = null;
        goto L8
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.datamerge.a
    public final MultiLinkLastEmptyViewBinder.a h(int r11) {
        IRoom r0 = this.d;
        if (r0 == null) goto L7;
        z5 r1 = r0.getLinkerDetail();
        if (r1 == null) goto L7;
        List r2 = r1.getPlayModes();
    L8:
        if (r2 != null) goto L10;
    L12:
        boolean r5 = false;
    L14:
        return new MultiLinkLastEmptyViewBinder.a(r11, false, r5, false, true, false, 256);
    L10:
        if (r2.contains(Long.valueOf(5)) != true) goto L12;
        r5 = true;
    L7:
        r2 = null;
        goto L8
    }

    public final void x(IRoom r3) {
        this.d = r3;
        if (aj0.a.c(this.g.getUiLayout()) == false) goto L5;
        RxUtilKt.c(Observable.combineLatest(this.j.f(), this.j.h(), new a(this)).subscribe(b.a), this.c);
    L6:
        RxUtilKt.c(this.j.g().subscribe(new d(this)), this.c);
        RxUtilKt.c(this.j.i().subscribe(new e(this)), this.c);
        RxUtilKt.c(this.j.b().subscribe(new f(this)), this.c);
        RxUtilKt.c(this.j.s().subscribe(new g(this)), this.c);
        u();
        this.a = true;
        return;
    L5:
        RxUtilKt.c(this.j.f().subscribe(new c(this)), this.c);
        goto L6
    }

    public final void y(List<tf0.e> r10) {
        Iterator<T> r0 = this.j.k().iterator();
    L4:
        if (r0.hasNext() == false) goto L21;
        LinkmicPositionItem r1 = (LinkmicPositionItem) r0.next();
        Iterator<T> r2 = r10.iterator();
    L7:
        if (r2.hasNext() == false) goto L4;
        tf0.e r3 = (tf0.e) r2.next();
        if ((r3 instanceof MultiLinkNormalEmptyViewBinder.a) == true) goto L10;
        if ((r3 instanceof MultiLinkGuestViewBinder.a) == false) goto L7;
        MultiLinkGuestViewBinder.a r4 = (MultiLinkGuestViewBinder.a) r3;
        if (r4.k.a.getUserPosition() != ((int) r1.getPosition())) goto L7;
        r4.k.a.setActiveName(r1.getActiveName());
        r4.k.a.setPositionType(r1.getPositionType());
        r4.l = com.bytedance.android.live.liveinteract.multianchor.model.h.a(r1);
        goto L7
    L10:
        MultiLinkNormalEmptyViewBinder.a r5 = (MultiLinkNormalEmptyViewBinder.a) r3;
        if (r5.b() != ((int) r1.getPosition())) goto L7;
        int r6 = r1.getStatus();
        LinkmicPositionItem.LinkmicPositionStatus r7 = LinkmicPositionItem.LinkmicPositionStatus.LOCKED;
        if (r6 == r7.ordinal()) goto L14;
        r5.l(com.bytedance.android.live.liveinteract.multianchor.model.h.a(r1));
        goto L7
    L14:
        ListProtector.set(r10, r5.b(), new MultiLinkSpecialViewBinder.a(r5.b(), r7.ordinal(), null, false));
        goto L7
    }

    public final void z(List<tf0.e> r5) {
        Map<String, pf0.a> r0 = this.j.r();
        wg0.a r1 = this.j.j();
        Iterator<T> r6 = r5.iterator();
    L4:
        if (r6.hasNext() == false) goto L13;
        tf0.e r2 = (tf0.e) r6.next();
        if ((r2 instanceof MultiLinkGuestViewBinder.a) == false) goto L4;
        MultiLinkGuestViewBinder.a r3 = (MultiLinkGuestViewBinder.a) r2;
        IBaseUser r4 = r3.k.a.getUser();
        if (r4 == null) goto L11;
        String r7 = r4.getIdString();
        if (r7 == null) goto L11;
    L12:
        r3.m = r0.get(r7);
        r3.n = r1;
    L11:
        r7 = "";
        goto L12
    }

    public final void A(com.bytedance.android.live.liveinteract.plantform.datamerge.k r2, com.bytedance.android.live.liveinteract.plantform.commonwindow.m r3) {
        Intrinsics.checkNotNullParameter(r2, "windowConfig");
        Intrinsics.checkNotNullParameter(r3, "layoutConfig");
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.h = r2;
        Intrinsics.checkNotNullParameter(r3, "<set-?>");
        this.g = r3;
        u();
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.datamerge.a
    public final void v(IVoiceLiveTheme r3, List<tf0.e> r4) {
        Intrinsics.checkNotNullParameter(r4, "windowList");
        super.v(r3, r4);
        Iterator<T> r5 = r4.iterator();
    L4:
        if (r5.hasNext() == false) goto L6;
        tf0.e r6 = (tf0.e) r5.next();
        r6.h = this.d;
        r6.d = this.j.getShowFrom();
        r6.e = this.j.e().b;
        r6.f = this.j.e().a;
        List<Integer> r0 = this.j.e().c;
        Intrinsics.checkNotNullParameter(r0, "<set-?>");
        r6.g = r0;
        goto L4
    }

    public i(IRoom r9, DataCenter r10, com.bytedance.android.live.liveinteract.plantform.commonwindow.m r11, com.bytedance.android.live.liveinteract.plantform.datamerge.k r12, k r13, int r14) {
        Intrinsics.checkNotNullParameter(r11, "layoutConfig");
        Intrinsics.checkNotNullParameter(r12, "windowConfig");
        Intrinsics.checkNotNullParameter(r13, "dataMergeCenterProxy");
        super(r9, r10, false, r11, r12, r14);
        this.j = r13;
    }
}
