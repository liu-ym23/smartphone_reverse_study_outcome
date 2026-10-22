package com.bytedance.android.live.messagewindow.framework.process.card;

import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.room.api.messagewindow.lifecycle.ICardLifecycle;
import com.bytedance.android.live.room.api.messagewindow.monitor.CardAlogParamsBuilder;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class PkPs extends com.bytedance.android.live.messagewindow.framework.process.card.a {
    public final CardPsId e;
    public Disposable f;
    public Runnable g;
    public boolean h;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ PkPs a;

        public a(PkPs r1) {
            this.a = r1;
        }

        public final void accept(Object r1) {
            Long r2 = (Long) r1;
            Runnable r3 = this.a.g;
            if (r3 == null) goto L6;
            r3.run();
            return;
        }
    }

    public PkPs() {
        this.e = CardPsId.Pk;
    }

    @Override // com.bytedance.android.live.messagewindow.framework.process.card.a
    public final CardPsId b() {
        return this.e;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.android.live.messagewindow.framework.process.card.a
    public final void d(h71.f.a<com.bytedance.android.live.messagewindow.framework.process.a> r17) {
        Intrinsics.checkNotNullParameter(r17, "chain");
        hm0.a r1 = (hm0.a) r17;
        final com.bytedance.android.live.messagewindow.framework.process.a r2 = (com.bytedance.android.live.messagewindow.framework.process.a) r1.a;
        d71.d r3 = r2.b.recordManager(r2.c.getPosition());
        i71.a r4 = r2.b.scheduler();
        if (r3 == null) goto L5;
        Collection r6 = r3.a();
    L6:
        final Ref.ObjectRef r7 = new Ref.ObjectRef();
        r7.element = "";
        if (r6 == null) goto L9;
        Iterator r8 = r6.iterator();
    L10:
        int r11 = 0;
        if (r8 == null) goto L113;
        if (r8.hasNext() != true) goto L113;
        final d71.b r13 = (d71.b) r8.next();
        s71.g r14 = r2.c.j();
        if ((r14 instanceof s71.g) == true) goto L17;
        r14 = null;
    L17:
        if (r14 != null) goto L19;
        r14 = km0.a.b;
    L19:
        final s71.d r5 = r14.a(r2.c, ((d71.e) r13).b);
        com.bytedance.android.live.room.api.messagewindow.monitor.i r15 = r2.b.monitor();
        if ((r5 instanceof s71.d.c) == true) goto L21;
        if ((r5 instanceof s71.d.d) == true) goto L10;
        if ((r5 instanceof s71.d.a) == false) goto L78;
        String r9 = this.e.name() + "：give up showing";
        if (r15 == null) goto L73;
        CardAlogParamsBuilder r10 = new CardAlogParamsBuilder();
        r10.c(r9);
        Pair[] r12 = {TuplesKt.to("winning card", ((d71.e) r13).b.j), TuplesKt.to("defeated card", r2.c.j)};
        int r16 = 0;
    L65:
        if (r16 >= 2) goto L72;
        Pair r18 = r12[r16];
        if (r18 == null) goto L71;
        Object r19 = r18.getSecond();
        if (r19 == null) goto L71;
        r10.a((String) r18.getFirst(), r19);
    L71:
        r16 = r16 + 1;
        goto L65
    L72:
        Unit r20 = Unit.INSTANCE;
        r15.d(r10.b());
    L73:
        com.bytedance.android.live.room.api.messagewindow.monitor.f r21 = com.bytedance.android.live.room.api.messagewindow.monitor.d.b("pk_ps_give_up_showing");
        r21.c("winner_card", ((d71.e) r13).b.j);
        r21.c("losing_card", r2.c.j);
        r21.d();
        com.bytedance.android.live.room.api.messagewindow.monitor.i r22 = com.bytedance.android.live.room.api.messagewindow.monitor.d.a();
        if (r22 == null) goto L76;
        r22.e(new com.bytedance.android.live.room.api.messagewindow.monitor.e(r21));
    L76:
        r7.element = ((d71.e) r13).b.j.toString();
    L112:
        boolean r110 = false;
    L114:
        if (r110 == false) goto L136;
        com.bytedance.android.live.messagewindow.framework.process.a r23 = (com.bytedance.android.live.messagewindow.framework.process.a) r1.a;
        if (r23 == null) goto L131;
        y61.b r24 = r23.b;
        if (r24 == null) goto L131;
        com.bytedance.android.live.room.api.messagewindow.monitor.i r25 = r24.monitor();
        if (r25 == null) goto L131;
        CardAlogParamsBuilder r26 = new CardAlogParamsBuilder();
        r26.c("PkPs continueProcess in opt");
        Pair[] r27 = {TuplesKt.to("task", String.valueOf(this.g)), TuplesKt.to("skipProcessNext", Boolean.valueOf(this.h))};
        int r111 = 0;
    L122:
        if (r111 >= 2) goto L129;
        Pair r28 = r27[r111];
        if (r28 == null) goto L128;
        Object r29 = r28.getSecond();
        if (r29 == null) goto L128;
        r26.a((String) r28.getFirst(), r29);
    L128:
        r111 = r111 + 1;
        goto L122
    L129:
        Unit r30 = Unit.INSTANCE;
        r25.d(r26.b());
    L131:
        if (this.g == null) goto L134;
        this.f = Observable.timer(1000, TimeUnit.MILLISECONDS).compose(RxUtil.rxSchedulerHelper()).subscribe(new a(this));
        return;
    L134:
        if (this.h == true) goto L180;
        e();
        return;
    L180:
        return;
    L136:
        if (r3 == null) goto L138;
        r3.d(r2.c);
    L138:
        f(new PkPs$onProcess$10(r7, r2));
        return;
    L78:
        if ((r5 instanceof s71.d.b) == false) goto L97;
        String r31 = this.e.name() + "：fight failed and wait to show";
        if (r15 == null) goto L91;
        CardAlogParamsBuilder r112 = new CardAlogParamsBuilder();
        r112.c(r31);
        Pair[] r32 = {TuplesKt.to("winning card", ((d71.e) r13).b.j), TuplesKt.to("defeated card", r2.c.j)};
        int r33 = 0;
    L83:
        if (r33 >= 2) goto L90;
        Pair r113 = r32[r33];
        if (r113 == null) goto L89;
        Object r114 = r113.getSecond();
        if (r114 == null) goto L89;
        r112.a((String) r113.getFirst(), r114);
    L89:
        r33 = r33 + 1;
        goto L83
    L90:
        Unit r34 = Unit.INSTANCE;
        r15.d(r112.b());
    L91:
        com.bytedance.android.live.room.api.messagewindow.monitor.f r35 = com.bytedance.android.live.room.api.messagewindow.monitor.d.b("pk_ps_wait_with_time_out");
        r35.c("winner_card", ((d71.e) r13).b.j);
        r35.c("losing_card", r2.c.j);
        r35.d();
        com.bytedance.android.live.room.api.messagewindow.monitor.i r36 = com.bytedance.android.live.room.api.messagewindow.monitor.d.a();
        if (r36 == null) goto L94;
        r36.e(new com.bytedance.android.live.room.api.messagewindow.monitor.e(r35));
    L94:
        if (r4 == null) goto L96;
        r4.execute(new PkPs$onProcess$6(r2, r5));
        Unit r37 = Unit.INSTANCE;
    L96:
        r7.element = ((d71.e) r13).b.j.toString();
        goto L112
    L97:
        String r38 = this.e.name() + "：fight result is unknown";
        if (r15 == null) goto L108;
        CardAlogParamsBuilder r39 = new CardAlogParamsBuilder();
        r39.c(r38);
        Pair[] r40 = {TuplesKt.to("ours card", r2.c.j), TuplesKt.to("others card", ((d71.e) r13).b.j)};
        int r41 = 2;
        int r115 = 0;
    L100:
        if (r115 >= r41) goto L107;
        Pair r42 = r40[r115];
        if (r42 == null) goto L106;
        Object r43 = r42.getSecond();
        if (r43 == null) goto L106;
        r39.a((String) r42.getFirst(), r43);
    L106:
        r115 = r115 + 1;
        r41 = 2;
        goto L100
    L107:
        Unit r44 = Unit.INSTANCE;
        r15.d(r39.b());
    L108:
        com.bytedance.android.live.room.api.messagewindow.monitor.f r45 = com.bytedance.android.live.room.api.messagewindow.monitor.d.b("pk_ps_result_unknown");
        r45.c("fight_card", r2.c.j);
        r45.c("to_fight_card", ((d71.e) r13).b.j);
        r45.b = 1000;
        com.bytedance.android.live.room.api.messagewindow.monitor.i r46 = com.bytedance.android.live.room.api.messagewindow.monitor.d.a();
        if (r46 == null) goto L111;
        r46.e(new com.bytedance.android.live.room.api.messagewindow.monitor.e(r45));
    L111:
        r7.element = ((d71.e) r13).b.j.toString();
        goto L112
    L21:
        v61.a r47 = ((d71.e) r13).b;
        if (r47 == null) goto L24;
        s71.g r48 = r47.j();
    L26:
        if ((r48 instanceof s71.g) == true) goto L28;
        r48 = null;
    L28:
        if (r48 != null) goto L30;
        r48 = km0.a.b;
    L30:
        final s71.e r49 = r48.b(((d71.e) r13).b, r2.c);
        if ((r49 instanceof s71.a) == true) goto L32;
        if ((r49 instanceof s71.b) == true) goto L10;
        if ((r49 instanceof s71.c) == true) goto L40;
        String r50 = this.e.name() + "：onDefeated result is unknown";
        if (r15 == null) goto L54;
        CardAlogParamsBuilder r116 = new CardAlogParamsBuilder();
        r116.c(r50);
        Pair[] r51 = {TuplesKt.to("winning card", r2.c.j), TuplesKt.to("losing card", ((d71.e) r13).b.j)};
    L46:
        if (r11 >= 2) goto L53;
        Pair r52 = r51[r11];
        if (r52 == null) goto L52;
        Object r117 = r52.getSecond();
        if (r117 == null) goto L52;
        r116.a((String) r52.getFirst(), r117);
    L52:
        r11 = r11 + 1;
        goto L46
    L53:
        Unit r53 = Unit.INSTANCE;
        r15.d(r116.b());
    L54:
        com.bytedance.android.live.room.api.messagewindow.monitor.f r54 = com.bytedance.android.live.room.api.messagewindow.monitor.d.b("pk_ps_loser_ondefeat_result_unknown");
        r54.b = 1000;
        r54.c("losing_card", ((d71.e) r13).b.j);
        r54.c("winning_card", r2.c.j);
        com.bytedance.android.live.room.api.messagewindow.monitor.i r55 = com.bytedance.android.live.room.api.messagewindow.monitor.d.a();
        if (r55 == null) goto L10;
        r55.e(new com.bytedance.android.live.room.api.messagewindow.monitor.e(r54));
        goto L10
    L40:
        if (r4 == null) goto L42;
        r4.execute(new PkPs$onProcess$2(r13, r49, r2));
        Unit r56 = Unit.INSTANCE;
    L42:
        this.g = g(r13);
        goto L10
    L32:
        if (r4 == null) goto L34;
        r4.execute(new PkPs$onProcess$1(r13, r2));
        Unit r57 = Unit.INSTANCE;
    L34:
        this.g = g(r13);
        goto L10
    L24:
        r48 = null;
    L113:
        r110 = true;
        goto L114
    L9:
        r8 = null;
        goto L10
    L5:
        r6 = null;
        goto L6
    }

    public final g g(d71.b r4) {
        g r0 = new g(this);
        if (((d71.e) r4).b.A() != ICardLifecycle.State.Hidden) goto L5;
    L14:
        r0.run();
    L15:
        return r0;
    L5:
        if (((d71.e) r4).b.A() == ICardLifecycle.State.Destroyed) goto L14;
        v61.a r5 = ((d71.e) r4).b;
        if (r5 == null) goto L12;
        Observable r6 = r5.v();
        if (r6 == null) goto L12;
        Disposable r7 = r6.subscribe(new h(r0), new f(this));
    L13:
        this.d = r7;
    L12:
        r7 = null;
        goto L13
    }
}
