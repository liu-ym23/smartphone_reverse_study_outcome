package com.bytedance.android.live.liveinteract.plantform.linksecurity.rts;

import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.liveinteract.linkbase.api.BaseMultiLinkWidget;
import com.bytedance.android.live.liveinteract.plantform.base.i;
import com.bytedance.android.live.liveinteract.plantform.core.y;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.plantform.model.n;
import com.bytedance.android.livesdk.utils.r2;
import com.bytedance.live.datacontext.DataContext;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import hg6.g;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kg6.e;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import tf0.o;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/liveinteract/plantform/linksecurity/rts/RTSVideoWidget;", "Lcom/bytedance/android/live/liveinteract/linkbase/api/BaseMultiLinkWidget;", "multilink-business-platform_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class RTSVideoWidget extends BaseMultiLinkWidget {
    public final Lazy a;
    public final CompositeDisposable b;
    public o c;
    public final Set<String> d;
    public final g e;
    public final dn0.c f;
    public final i<ILinkPlayerInfoBridge> g;
    public final com.bytedance.android.live.liveinteract.plantform.linksecurity.rts.a.b h;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ RTSVideoWidget a;

        public a(RTSVideoWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r18) {
            sh6.b r1 = (sh6.b) r18;
            ph0.b r2 = (ph0.b) sh6.c.b(r1);
            String r3 = null;
            if (r2 == null) goto L5;
            String r4 = r2.b;
        L7:
            if (r4 != null) goto L9;
        L12:
            boolean r5 = true;
        L13:
            if (r5 == true) goto L140;
            g r6 = this.a.e;
            if (r6 != null) goto L17;
            return;
        L17:
            if (r6.A() != true) goto L142;
            ph0.b r7 = (ph0.b) sh6.c.b(r1);
            int r8 = 2;
            if (r7 != null) goto L21;
        L23:
            boolean r9 = false;
        L24:
            o r10 = this.a.c;
            if (r10 == null) goto L31;
            ph0.b r11 = (ph0.b) sh6.c.b(r1);
            if (r11 == null) goto L29;
            String r12 = r11.b;
        L30:
            Intrinsics.checkNotNull(r12);
            r10.c(r12, r9);
            goto L31
        L29:
            r12 = null;
        L31:
            int r13 = d.a;
            i<ILinkPlayerInfoBridge> r14 = this.a.g;
            ph0.b r15 = (ph0.b) sh6.c.b(r1);
            if (r15 == null) goto L34;
            String r16 = r15.a;
        L35:
            String r17 = String.valueOf(r16);
            ph0.b r19 = (ph0.b) sh6.c.b(r1);
            if (r19 == null) goto L38;
            String r20 = r19.b;
        L39:
            Intrinsics.checkNotNull(r20);
            ph0.b r110 = (ph0.b) sh6.c.b(r1);
            if (r110 == null) goto L42;
            r8 = r110.c;
        L42:
            Intrinsics.checkNotNullParameter(r17, "targetUserId");
            int r111 = -1;
            if (r14 == null) goto L56;
            Iterable r112 = r14.getOnlineUserList();
            if (r112 == null) goto L56;
            Iterator<T> r113 = r112.iterator();
            ILinkPlayerInfoBridge r114 = null;
            int r115 = 0;
        L48:
            if (r113.hasNext() == false) goto L57;
            T r116 = r113.next();
            int r117 = r115 + 1;
            if (r115 >= 0) goto L52;
            CollectionsKt.throwIndexOverflow();
        L52:
            ILinkPlayerInfoBridge r118 = (ILinkPlayerInfoBridge) r116;
            int r119 = d.a;
            if (d.a.a(r17, r20, r118) == false) goto L55;
            r114 = n.a(r118);
            r114.setLinkType(r8);
            r111 = r115;
        L55:
            r115 = r117;
        L57:
            if (r111 < 0) goto L63;
            if (r114 == null) goto L63;
            if (r14 == null) goto L63;
            List<T> r21 = r14.getOnlineUserList();
            if (r21 == 0) goto L63;
            ILinkPlayerInfoBridge r22 = (ILinkPlayerInfoBridge) ListProtector.set(r21, r111, r114);
        L63:
            if (r14 == null) goto L65;
            r14.W4();
        L65:
            ph0.b r23 = (ph0.b) sh6.c.b(r1);
            if (r23 == null) goto L143;
            String r24 = r23.b;
            if (r24 != null) goto L70;
            return;
        L70:
            if ((!StringsKt.isBlank(r24)) != true) goto L145;
            ph0.b r25 = (ph0.b) sh6.c.b(r1);
            if (r25 == null) goto L74;
            String r26 = r25.b;
        L76:
            if (Intrinsics.areEqual(r26, tc0.c.h().f) == false) goto L96;
            if (r9 == false) goto L146;
            ph0.b r27 = (ph0.b) sh6.c.b(r1);
            if (r27 != null) goto L81;
        L89:
            cg6.a r28 = this.a.wq();
            if (r28 == null) goto L151;
            jg6.a r29 = r28.e5();
            if (r29 == null) goto L152;
            lh6.b r30 = r29.a();
            if (r30 == null) goto L153;
            ng6.c.a.a(r30, true);
            return;
        L153:
            return;
        L152:
            return;
        L151:
            return;
        L81:
            if (r27.d != true) goto L89;
            cg6.a r31 = this.a.wq();
            if (r31 == null) goto L147;
            jg6.a r32 = r31.e5();
            if (r32 == null) goto L148;
            lh6.b r33 = r32.a();
            if (r33 == null) goto L149;
            ng6.c.a.a(r33, false);
            return;
        L149:
            return;
        L148:
            return;
        L147:
            return;
        L146:
            return;
        L96:
            ph0.b r34 = (ph0.b) sh6.c.b(r1);
            if (r34 != null) goto L99;
        L100:
            ph0.b r35 = (ph0.b) sh6.c.b(r1);
            if (r35 != null) goto L103;
        L104:
            ph0.b r36 = (ph0.b) sh6.c.b(r1);
            if (r36 != null) goto L107;
        L122:
            Set<String> r37 = this.a.d;
            ph0.b r38 = (ph0.b) sh6.c.b(r1);
            if (r38 == null) goto L125;
            String r39 = r38.b;
        L126:
            Intrinsics.checkNotNull(r39);
            r37.add(r39);
            cg6.a r40 = this.a.wq();
            if (r40 == null) goto L159;
            jg6.a r41 = r40.e5();
            if (r41 == null) goto L160;
            lh6.b r42 = r41.a();
            if (r42 == null) goto L161;
            ph0.b r43 = (ph0.b) sh6.c.b(r1);
            if (r43 == null) goto L135;
            r3 = r43.b;
        L135:
            Intrinsics.checkNotNull(r3);
            r42.f(r3, true, "rts video widget oncreate");
            return;
        L161:
            return;
        L160:
            return;
        L159:
            return;
        L125:
            r39 = null;
            goto L126
        L107:
            if (r36.d != true) goto L122;
        L108:
            Set<String> r44 = this.a.d;
            ph0.b r45 = (ph0.b) sh6.c.b(r1);
            if (r45 == null) goto L111;
            String r46 = r45.b;
        L112:
            Intrinsics.checkNotNull(r46);
            r44.remove(r46);
            cg6.a r47 = this.a.wq();
            if (r47 == null) goto L155;
            jg6.a r48 = r47.e5();
            if (r48 == null) goto L156;
            lh6.b r49 = r48.a();
            if (r49 == null) goto L157;
            ph0.b r50 = (ph0.b) sh6.c.b(r1);
            if (r50 == null) goto L121;
            r3 = r50.b;
        L121:
            Intrinsics.checkNotNull(r3);
            r49.f(r3, false, "rts video widget oncreate by video");
            return;
        L157:
            return;
        L156:
            return;
        L155:
            return;
        L111:
            r46 = null;
            goto L112
        L103:
            if (r35.c == 3) goto L108;
        L99:
            if (r34.c == 1) goto L108;
        L74:
            r26 = null;
            goto L76
        L145:
            return;
        L143:
            return;
        L56:
            r114 = null;
            goto L57
        L38:
            r20 = null;
            goto L39
        L34:
            r16 = null;
            goto L35
        L21:
            if (r7.c != 2) goto L23;
            r9 = true;
            goto L24
        L142:
            return;
        L140:
            return;
        L9:
            if (StringsKt.isBlank(r4) == true) goto L12;
            r5 = false;
            goto L13
        L5:
            r4 = null;
            goto L7
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ RTSVideoWidget a;

        public b(RTSVideoWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r6) {
            sh6.b r7 = (sh6.b) r6;
            ph0.c r0 = (ph0.c) sh6.c.b(r7);
            String r1 = null;
            if (r0 == null) goto L5;
            String r2 = r0.b;
        L7:
            if (r2 != null) goto L9;
        L12:
            boolean r3 = true;
        L13:
            if (r3 == true) goto L83;
            g r4 = this.a.e;
            if (r4 != null) goto L17;
            return;
        L17:
            if (r4.A() != true) goto L85;
            ph0.c r5 = (ph0.c) sh6.c.b(r7);
            if (r5 == null) goto L69;
            String r8 = r5.b;
            if (r8 == null) goto L69;
            if ((!StringsKt.isBlank(r8)) != true) goto L69;
            ph0.c r9 = (ph0.c) sh6.c.b(r7);
            if (r9 == null) goto L27;
            String r10 = r9.b;
        L29:
            if (Intrinsics.areEqual(r10, tc0.c.h().f) == false) goto L37;
            ph0.c r11 = (ph0.c) sh6.c.b(r7);
            if (r11 != null) goto L33;
        L34:
            pf6.a r12 = this.a.e.f0();
            if (r12 == null) goto L69;
            r12.c(true, "rts video mute");
            goto L69
        L33:
            if (r11.c == 0) goto L69;
        L37:
            ph0.c r13 = (ph0.c) sh6.c.b(r7);
            if (r13 == null) goto L40;
            Integer r14 = Integer.valueOf(r13.c);
        L41:
            Intrinsics.checkNotNull(r14);
            if (r14.intValue() <= 0) goto L58;
            ph0.c r15 = (ph0.c) sh6.c.b(r7);
            if (r15 == null) goto L58;
            if (r15.d == true) goto L58;
            cg6.a r16 = this.a.wq();
            if (r16 == null) goto L69;
            jg6.a r17 = r16.e5();
            if (r17 == null) goto L69;
            e r18 = r17.b();
            if (r18 == null) goto L69;
            ph0.c r19 = (ph0.c) sh6.c.b(r7);
            if (r19 == null) goto L56;
            String r20 = r19.b;
        L57:
            Intrinsics.checkNotNull(r20);
            r18.h(r20, true, "rts other user silence self");
            goto L69
        L56:
            r20 = null;
        L58:
            cg6.a r21 = this.a.wq();
            if (r21 == null) goto L69;
            jg6.a r22 = r21.e5();
            if (r22 == null) goto L69;
            e r23 = r22.b();
            if (r23 == null) goto L69;
            ph0.c r24 = (ph0.c) sh6.c.b(r7);
            if (r24 == null) goto L67;
            String r25 = r24.b;
        L68:
            Intrinsics.checkNotNull(r25);
            r23.h(r25, false, "rts other user silence self");
            goto L69
        L67:
            r25 = null;
            goto L68
        L40:
            r14 = null;
            goto L41
        L27:
            r10 = null;
        L69:
            int r26 = d.a;
            i<ILinkPlayerInfoBridge> r27 = this.a.g;
            ph0.c r28 = (ph0.c) sh6.c.b(r7);
            if (r28 == null) goto L73;
            String r29 = r28.a;
            if (r29 == null) goto L73;
        L74:
            ph0.c r30 = (ph0.c) sh6.c.b(r7);
            if (r30 == null) goto L77;
            r1 = r30.b;
        L77:
            Intrinsics.checkNotNull(r1);
            ph0.c r31 = (ph0.c) sh6.c.b(r7);
            if (r31 == null) goto L80;
            int r32 = r31.c;
        L81:
            d.a.b(r27, r29, r1, r32);
            return;
        L80:
            r32 = -1;
        L73:
            r29 = "";
            goto L74
        L85:
            return;
        L83:
            return;
        L9:
            if (StringsKt.isBlank(r2) == true) goto L12;
            r3 = false;
            goto L13
        L5:
            r2 = null;
            goto L7
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ RTSVideoWidget a;

        public c(RTSVideoWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r6) {
            sh6.b r7 = (sh6.b) r6;
            ph0.a r0 = (ph0.a) sh6.c.b(r7);
            if (r0 == null) goto L5;
            String r1 = r0.a;
        L7:
            if (Intrinsics.areEqual(r1, tc0.c.h().f) == false) goto L16;
            com.bytedance.android.live.liveinteract.plantform.linksecurity.rts.a.b r8 = this.a.h;
            if (r8 == null) goto L11;
            r8.c();
        L11:
            g r9 = this.a.e;
            if (r9 != null) goto L14;
            return;
        L14:
            if (r9.isEngineOn() != true) goto L43;
            this.a.e.n();
            return;
        L43:
            return;
        L16:
            cg6.a r2 = this.a.wq();
            String r3 = "";
            if (r2 == null) goto L28;
            jg6.a r4 = r2.e5();
            if (r4 == null) goto L28;
            e r5 = r4.b();
            if (r5 == null) goto L28;
            ph0.a r10 = (ph0.a) sh6.c.b(r7);
            if (r10 == null) goto L26;
            String r11 = r10.a;
            if (r11 == null) goto L26;
        L27:
            r5.h(r11, true, "rts kick outf");
        L26:
            r11 = "";
        L28:
            cg6.a r12 = this.a.wq();
            if (r12 == null) goto L45;
            jg6.a r13 = r12.e5();
            if (r13 == null) goto L46;
            lh6.b r14 = r13.a();
            if (r14 == null) goto L47;
            ph0.a r15 = (ph0.a) sh6.c.b(r7);
            if (r15 == null) goto L40;
            String r16 = r15.a;
            if (r16 == null) goto L40;
            r3 = r16;
        L40:
            r14.f(r3, true, "rtsvideo widget kickout event");
            return;
        L47:
            return;
        L46:
            return;
        L45:
            return;
        L5:
            r1 = null;
            goto L7
        }
    }

    public final cg6.a wq() {
        return getScopeServiceOrNullInMultiLinkRoom(cg6.a.class);
    }

    @Override // com.bytedance.android.live.liveinteract.linkbase.api.BaseMultiLinkWidget
    public final int getScene() {
        return com.bytedance.android.live.liveinteract.linkpanel.util.o.c();
    }

    @Override // com.bytedance.android.live.liveinteract.linkbase.api.BaseMultiLinkWidget
    public final void onCreate() {
        super.onCreate();
        g r0 = this.e;
        if (r0 == null) goto L5;
        r0.z((com.bytedance.android.live.liveinteract.plantform.linksecurity.rts.a) this.a.getValue());
    L5:
        Pair r1 = com.bytedance.live.datacontext.d.a(RTSVideoWidget$onCreate$pair$1.INSTANCE);
        com.bytedance.live.datacontext.b.a((DataContext) r1.getFirst(), RTSDataContext.class);
        this.b.add((Disposable) r1.getSecond());
        i<ILinkPlayerInfoBridge> r2 = this.g;
        if (r2 == null) goto L8;
        r2.Q4(new com.bytedance.android.live.liveinteract.plantform.linksecurity.rts.b(this));
    L8:
        com.bytedance.android.live.liveinteract.plantform.linksecurity.rts.a r3 = (com.bytedance.android.live.liveinteract.plantform.linksecurity.rts.a) this.a.getValue();
        com.bytedance.android.live.liveinteract.plantform.linksecurity.rts.a.c r4 = (com.bytedance.android.live.liveinteract.plantform.linksecurity.rts.a.c) r1.getFirst();
        r3.getClass();
        Intrinsics.checkNotNullParameter(r4, "listener");
        if (r3.a.contains(r4) == true) goto L11;
        r3.a.add(r4);
    L11:
        RTSDataContext.a r5 = RTSDataContext.Companion;
        RTSDataContext r6 = r5.getContext();
        if (r6 == null) goto L20;
        com.bytedance.live.datacontext.n<ph0.b> r7 = r6.getLinkTypeEvent();
        if (r7 == null) goto L20;
        Observable r8 = r7.a();
        if (r8 == null) goto L20;
        Disposable r9 = r8.subscribe(new a(this));
        if (r9 == null) goto L20;
        RxUtilKt.c(r9, this.b);
    L20:
        RTSDataContext r10 = r5.getContext();
        if (r10 == null) goto L29;
        com.bytedance.live.datacontext.n<ph0.c> r11 = r10.getSilenceEvent();
        if (r11 == null) goto L29;
        Observable r12 = r11.a();
        if (r12 == null) goto L29;
        Disposable r13 = r12.subscribe(new b(this));
        if (r13 == null) goto L29;
        RxUtilKt.c(r13, this.b);
    L29:
        RTSDataContext r14 = r5.getContext();
        if (r14 == null) goto L39;
        com.bytedance.live.datacontext.n<ph0.a> r15 = r14.getKickOutEvent();
        if (r15 == null) goto L40;
        Observable r16 = r15.a();
        if (r16 == null) goto L41;
        Disposable r17 = r16.subscribe(new c(this));
        if (r17 == null) goto L42;
        RxUtilKt.c(r17, this.b);
        return;
    L42:
        return;
    L41:
        return;
    L40:
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.linkbase.api.BaseMultiLinkWidget
    public final void onDestroy() {
        super.onDestroy();
        Iterator<T> r0 = this.d.iterator();
    L4:
        if (r0.hasNext() == false) goto L22;
        String r1 = (String) r0.next();
        String r2 = tc0.c.h().f;
        if (r2 != null) goto L8;
    L11:
        boolean r3 = true;
    L12:
        if (r3 == true) goto L15;
        if ((!Intrinsics.areEqual(r1, tc0.c.h().f)) == false) goto L4;
    L15:
        cg6.a r4 = wq();
        if (r4 == null) goto L4;
        jg6.a r5 = r4.e5();
        if (r5 == null) goto L4;
        lh6.b r6 = r5.a();
        if (r6 == null) goto L4;
        r6.f(r1, false, "rts video widget ondestroy");
        goto L4
    L8:
        if (StringsKt.isBlank(r2) == true) goto L11;
        r3 = false;
        goto L12
    L22:
        this.b.clear();
        ((com.bytedance.android.live.liveinteract.plantform.linksecurity.rts.a) this.a.getValue()).a.clear();
    }

    public final void onPause() {
        super/*com.bytedance.android.live.core.tetris.widgets.LiveWidget*/.onPause();
    }

    public final void onResume() {
        super/*com.bytedance.android.live.core.tetris.widgets.LiveWidget*/.onResume();
    }

    public final void xq(List<? extends ILinkPlayerInfoBridge> r7) {
        if (r7 == null) goto L37;
        Iterator<T> r8 = r7.iterator();
    L5:
        if (r8.hasNext() == false) goto L53;
        ILinkPlayerInfoBridge r0 = (ILinkPlayerInfoBridge) r8.next();
        if (r2.a(r0.getMInteractIdStr()) == false) goto L5;
        if ((!Intrinsics.areEqual(r0.getMInteractIdStr(), tc0.c.h().f)) == false) goto L5;
        String r3 = "";
        if (r0.getLinkType() != 1) goto L13;
    L14:
        cg6.a r1 = wq();
        if (r1 == null) goto L25;
        jg6.a r2 = r1.e5();
        if (r2 == null) goto L25;
        lh6.b r4 = r2.a();
        if (r4 == null) goto L25;
        String r5 = r0.getMInteractIdStr();
        if (r5 != null) goto L23;
        r5 = "";
    L23:
        r4.f(r5, false, "rts video widget onUserListChanged");
    L25:
        if (r0.getSilenceStatus() != 0) goto L5;
        cg6.a r6 = wq();
        if (r6 == null) goto L5;
        jg6.a r9 = r6.e5();
        if (r9 == null) goto L5;
        e r10 = r9.b();
        if (r10 == null) goto L5;
        String r11 = r0.getMInteractIdStr();
        if (r11 == null) goto L36;
        r3 = r11;
    L36:
        r10.h(r3, false, "rts online list changed video");
        goto L5
    L13:
        if (r0.getLinkType() != 3) goto L25;
    L53:
        return;
    }

    public RTSVideoWidget(g r1, dn0.c r2, y r3, com.bytedance.android.live.liveinteract.plantform.linksecurity.rts.a.b r4) {
        this.e = r1;
        this.f = r2;
        this.g = r3;
        this.h = r4;
        this.a = LazyKt.lazy(new RTSVideoWidget$mRTSHandler$2(this));
        this.b = new CompositeDisposable();
        this.d = new LinkedHashSet();
    }
}
