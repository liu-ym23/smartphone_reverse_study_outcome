package com.bytedance.android.live.messagewindow.framework.process.card;

import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.room.api.messagewindow.monitor.CardAlogParamsBuilder;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class InterceptShowPs extends com.bytedance.android.live.messagewindow.framework.process.card.a {
    public final CardPsId e;
    public Disposable f;
    public int g;
    public int h;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ t71.a a;
        public final /* synthetic */ com.bytedance.android.live.room.api.messagewindow.monitor.i b;
        public final /* synthetic */ InterceptShowPs c;
        public final /* synthetic */ com.bytedance.android.live.messagewindow.framework.process.a d;
        public final /* synthetic */ h71.f.a e;
        public final /* synthetic */ d71.d f;

        public a(t71.a r1, com.bytedance.android.live.room.api.messagewindow.monitor.i r2, InterceptShowPs r3, com.bytedance.android.live.messagewindow.framework.process.a r4, h71.f.a r5, d71.d r6) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
            this.f = r6;
        }

        public final void accept(Object r9) {
            if (((Boolean) r9).booleanValue() == false) goto L11;
            InterceptShowPs r10 = this.c;
            int r1 = r10.h + 1;
            r10.h = r1;
            if (r1 <= r10.g) goto L10;
            final String r11 = "prevent stack overflow, the max intercept count is " + this.c.g;
            com.bytedance.android.live.room.api.messagewindow.monitor.f r0 = com.bytedance.android.live.room.api.messagewindow.monitor.d.b("intercept_show_ps_count_limit");
            r0.b(r11);
            r0.d();
            com.bytedance.android.live.room.api.messagewindow.monitor.i r2 = com.bytedance.android.live.room.api.messagewindow.monitor.d.a();
            if (r2 == null) goto L9;
            r2.e(new com.bytedance.android.live.room.api.messagewindow.monitor.e(r0));
        L9:
            this.c.f(new InterceptShowPs$onProcess$$inlined$also$lambda$1$1(this, r11));
            return;
        L10:
            r10.d(this.e);
            return;
        L11:
            final String r12 = this.c.e.name() + " try to show but condition isn't satisfied";
            com.bytedance.android.live.room.api.messagewindow.monitor.i r3 = this.b;
            if (r3 == null) goto L23;
            CardAlogParamsBuilder r4 = new CardAlogParamsBuilder();
            r4.c(r12);
            int r6 = 0;
            Pair[] r5 = {TuplesKt.to("showStrategy", this.a), TuplesKt.to("cardId", this.d.c.j)};
        L15:
            if (r6 >= 2) goto L22;
            Pair r7 = r5[r6];
            if (r7 == null) goto L21;
            Object r8 = r7.getSecond();
            if (r8 == null) goto L21;
            r4.a((String) r7.getFirst(), r8);
        L21:
            r6 = r6 + 1;
            goto L15
        L22:
            Unit r13 = Unit.INSTANCE;
            r3.d(r4.b());
        L23:
            com.bytedance.android.live.room.api.messagewindow.monitor.f r14 = com.bytedance.android.live.room.api.messagewindow.monitor.d.b("intercept_show_ps_condition_unsatisfied");
            r14.d();
            com.bytedance.android.live.room.api.messagewindow.monitor.i r15 = com.bytedance.android.live.room.api.messagewindow.monitor.d.a();
            if (r15 == null) goto L26;
            r15.e(new com.bytedance.android.live.room.api.messagewindow.monitor.e(r14));
        L26:
            Disposable r16 = this.c.f;
            if (r16 == null) goto L29;
            r16.dispose();
        L29:
            d71.d r17 = this.f;
            if (r17 == null) goto L32;
            r17.d(this.d.c);
        L32:
            this.c.f(new InterceptShowPs$onProcess$$inlined$also$lambda$1$2(this, r12));
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ com.bytedance.android.live.room.api.messagewindow.monitor.i a;
        public final /* synthetic */ t71.a b;
        public final /* synthetic */ InterceptShowPs c;
        public final /* synthetic */ com.bytedance.android.live.messagewindow.framework.process.a d;
        public final /* synthetic */ d71.d e;

        public b(com.bytedance.android.live.room.api.messagewindow.monitor.i r1, t71.a r2, InterceptShowPs r3, com.bytedance.android.live.messagewindow.framework.process.a r4, h71.f.a r5, d71.d r6) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r6;
        }

        public final void accept(Object r9) {
            Throwable r10 = (Throwable) r9;
            final String r0 = this.c.e.name() + " process error";
            com.bytedance.android.live.room.api.messagewindow.monitor.i r1 = this.a;
            if (r1 == null) goto L14;
            CardAlogParamsBuilder r2 = new CardAlogParamsBuilder();
            r2.c(r0);
            int r6 = 0;
            Pair[] r4 = {TuplesKt.to("showStrategy", this.b), TuplesKt.to("cardId", this.d.c.j)};
        L6:
            if (r6 >= 2) goto L13;
            Pair r5 = r4[r6];
            if (r5 == null) goto L12;
            Object r7 = r5.getSecond();
            if (r7 == null) goto L12;
            r2.a((String) r5.getFirst(), r7);
        L12:
            r6 = r6 + 1;
            goto L6
        L13:
            Intrinsics.checkNotNullParameter(r10, "tr");
            r2.a = r10;
            Unit r11 = Unit.INSTANCE;
            r1.d(r2.b());
        L14:
            com.bytedance.android.live.room.api.messagewindow.monitor.f r12 = com.bytedance.android.live.room.api.messagewindow.monitor.d.b("intercept_show_ps_error");
            r12.b = 1000;
            com.bytedance.android.live.room.api.messagewindow.monitor.i r3 = com.bytedance.android.live.room.api.messagewindow.monitor.d.a();
            if (r3 == null) goto L17;
            r3.e(new com.bytedance.android.live.room.api.messagewindow.monitor.e(r12));
        L17:
            Disposable r13 = this.c.f;
            if (r13 == null) goto L20;
            r13.dispose();
        L20:
            d71.d r14 = this.e;
            if (r14 == null) goto L23;
            r14.d(this.d.c);
        L23:
            this.c.f(new InterceptShowPs$onProcess$$inlined$also$lambda$2$1(this, r0));
        }
    }

    public InterceptShowPs() {
        this.e = CardPsId.InterceptShow;
        this.g = ILinkPlayerInfoBridge.DEFAULT_ClIENT_UI_POSITION;
    }

    @Override // com.bytedance.android.live.messagewindow.framework.process.card.a
    public final CardPsId b() {
        return this.e;
    }

    @Override // com.bytedance.android.live.messagewindow.framework.process.card.a
    public final void d(final h71.f.a<com.bytedance.android.live.messagewindow.framework.process.a> r17) {
        Intrinsics.checkNotNullParameter(r17, "chain");
        Disposable r0 = this.f;
        if (r0 == null) goto L5;
        r0.dispose();
    L5:
        final com.bytedance.android.live.messagewindow.framework.process.a r9 = (com.bytedance.android.live.messagewindow.framework.process.a) r17.d();
        final d71.d r10 = r9.b.recordManager(r9.c.getPosition());
        v61.a r1 = r9.c;
        if (r1 == null) goto L51;
        Collection r2 = r1.u();
        if (r2 == null) goto L51;
        if (this.g != Integer.MIN_VALUE) goto L12;
        this.g = r2.size() + 3;
    L12:
        Iterator r3 = r2.iterator();
    L14:
        if (r3.hasNext() == false) goto L18;
        Object r4 = r3.next();
        if (((t71.a) r4).b(r9.c) == false) goto L14;
    L19:
        final t71.a r12 = (t71.a) r4;
        if (r12 == null) goto L51;
        r12.onIntercept();
        final com.bytedance.android.live.room.api.messagewindow.monitor.i r13 = r9.b.monitor();
        Single r5 = r12.a();
        if (r5 == null) goto L29;
        Single r14 = r5.observeOn(AndroidSchedulers.mainThread());
        if (r14 == null) goto L29;
        Disposable r6 = r14.subscribe(new a(r12, r13, this, r9, r17, r10), new b(r13, r12, this, r9, r17, r10));
        if (r6 == null) goto L29;
        Disposable r11 = r6;
    L50:
        this.f = r11;
        return;
    L29:
        final String r7 = this.e.name() + " intercept show";
        if (r13 == null) goto L41;
        CardAlogParamsBuilder r8 = new CardAlogParamsBuilder();
        r8.c(r7);
        int r15 = 0;
        Pair[] r16 = {TuplesKt.to("showStrategy", this), TuplesKt.to("cardId", r9.c.j)};
    L33:
        if (r15 >= 2) goto L40;
        Pair r18 = r16[r15];
        if (r18 == null) goto L39;
        Object r19 = r18.getSecond();
        if (r19 == null) goto L39;
        r8.a((String) r18.getFirst(), r19);
    L39:
        r15 = r15 + 1;
        goto L33
    L40:
        Unit r20 = Unit.INSTANCE;
        r13.d(r8.b());
    L41:
        com.bytedance.android.live.room.api.messagewindow.monitor.f r21 = com.bytedance.android.live.room.api.messagewindow.monitor.d.b("intercept_show_ps_intercept");
        r21.d();
        com.bytedance.android.live.room.api.messagewindow.monitor.i r22 = com.bytedance.android.live.room.api.messagewindow.monitor.d.a();
        if (r22 == null) goto L44;
        r22.e(new com.bytedance.android.live.room.api.messagewindow.monitor.e(r21));
    L44:
        Disposable r23 = this.f;
        if (r23 == null) goto L47;
        r23.dispose();
    L47:
        if (r10 == null) goto L49;
        r10.d(r9.c);
    L49:
        f(new InterceptShowPs$onProcess$$inlined$also$lambda$3(r7, r13, r12, this, r9, r17, r10));
        r11 = null;
        goto L50
    L18:
        r4 = null;
    L51:
        e();
        Unit r24 = Unit.INSTANCE;
    }

    public static final p71.a.c g(InterceptShowPs r0, t71.a r1, String r2) {
        r0.getClass();
        Object r3 = r1.getIdentity();
        if (r3 == null) goto L6;
        String r4 = r3.toString();
        if (r4 == null) goto L6;
    L7:
        p71.a.c r5 = new p71.a.c(r4);
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        ((p71.a) r5).b = r2;
        return r5;
    L6:
        r4 = "";
        goto L7
    }
}
