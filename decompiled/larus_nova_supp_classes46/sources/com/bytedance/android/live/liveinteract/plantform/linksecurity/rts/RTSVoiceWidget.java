package com.bytedance.android.live.liveinteract.plantform.linksecurity.rts;

import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.liveinteract.linkbase.api.BaseMultiLinkWidget;
import com.bytedance.android.live.liveinteract.linkpanel.util.o;
import com.bytedance.android.live.liveinteract.plantform.base.i;
import com.bytedance.android.live.liveinteract.plantform.core.y;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.livesdk.utils.r2;
import com.bytedance.live.datacontext.DataContext;
import com.bytedance.live.datacontext.n;
import hg6.g;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.Iterator;
import java.util.List;
import kg6.e;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/liveinteract/plantform/linksecurity/rts/RTSVoiceWidget;", "Lcom/bytedance/android/live/liveinteract/linkbase/api/BaseMultiLinkWidget;", "multilink-business-platform_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class RTSVoiceWidget extends BaseMultiLinkWidget {
    public final Lazy a;
    public final CompositeDisposable b;
    public final g c;
    public final i<ILinkPlayerInfoBridge> d;
    public final com.bytedance.android.live.liveinteract.plantform.linksecurity.rts.a.b e;
    public final dn0.c f;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ RTSVoiceWidget a;

        public a(RTSVoiceWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r7) {
            sh6.b r8 = (sh6.b) r7;
            ph0.c r0 = (ph0.c) sh6.c.b(r8);
            String r1 = null;
            if (r0 == null) goto L5;
            String r2 = r0.b;
        L7:
            if (r2 != null) goto L9;
        L12:
            boolean r3 = true;
        L13:
            if (r3 == true) goto L81;
            g r4 = this.a.c;
            if (r4 != null) goto L17;
            return;
        L17:
            if (r4.A() != true) goto L83;
            ph0.c r5 = (ph0.c) sh6.c.b(r8);
            if (r5 == null) goto L67;
            String r6 = r5.b;
            if (r6 == null) goto L67;
            if ((!StringsKt.isBlank(r6)) != true) goto L67;
            ph0.c r9 = (ph0.c) sh6.c.b(r8);
            if (r9 == null) goto L27;
            String r10 = r9.b;
        L29:
            if (Intrinsics.areEqual(r10, tc0.c.h().f) == false) goto L39;
            ph0.c r11 = (ph0.c) sh6.c.b(r8);
            if (r11 != null) goto L33;
        L34:
            jg6.a r12 = this.a.wq();
            if (r12 == null) goto L67;
            e r13 = r12.b();
            if (r13 == null) goto L67;
            r13.t(new kg6.b(false, false, "rts audio mute", 8));
            goto L67
        L33:
            if (r11.c == 0) goto L67;
        L39:
            ph0.c r14 = (ph0.c) sh6.c.b(r8);
            if (r14 == null) goto L42;
            Integer r15 = Integer.valueOf(r14.c);
        L43:
            Intrinsics.checkNotNull(r15);
            if (r15.intValue() <= 0) goto L58;
            ph0.c r16 = (ph0.c) sh6.c.b(r8);
            if (r16 == null) goto L58;
            if (r16.d == true) goto L58;
            jg6.a r17 = this.a.wq();
            if (r17 == null) goto L67;
            e r18 = r17.b();
            if (r18 == null) goto L67;
            ph0.c r19 = (ph0.c) sh6.c.b(r8);
            if (r19 == null) goto L56;
            String r20 = r19.b;
        L57:
            Intrinsics.checkNotNull(r20);
            r18.h(r20, true, "rts audio mute");
            goto L67
        L56:
            r20 = null;
        L58:
            jg6.a r21 = this.a.wq();
            if (r21 == null) goto L67;
            e r22 = r21.b();
            if (r22 == null) goto L67;
            ph0.c r23 = (ph0.c) sh6.c.b(r8);
            if (r23 == null) goto L65;
            String r24 = r23.b;
        L66:
            Intrinsics.checkNotNull(r24);
            r22.h(r24, false, "rts audio mute");
            goto L67
        L65:
            r24 = null;
            goto L66
        L42:
            r15 = null;
            goto L43
        L27:
            r10 = null;
        L67:
            int r25 = d.a;
            i<ILinkPlayerInfoBridge> r26 = this.a.d;
            ph0.c r27 = (ph0.c) sh6.c.b(r8);
            if (r27 == null) goto L71;
            String r28 = r27.a;
            if (r28 == null) goto L71;
        L72:
            ph0.c r29 = (ph0.c) sh6.c.b(r8);
            if (r29 == null) goto L75;
            r1 = r29.b;
        L75:
            Intrinsics.checkNotNull(r1);
            ph0.c r30 = (ph0.c) sh6.c.b(r8);
            if (r30 == null) goto L78;
            int r31 = r30.c;
        L79:
            d.a.b(r26, r28, r1, r31);
            return;
        L78:
            r31 = -1;
        L71:
            r28 = "";
            goto L72
        L83:
            return;
        L81:
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

    public static final class b<T> implements Consumer {
        public final /* synthetic */ RTSVoiceWidget a;

        public b(RTSVoiceWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            sh6.b r5 = (sh6.b) r4;
            ph0.a r0 = (ph0.a) sh6.c.b(r5);
            if (r0 == null) goto L5;
            String r1 = r0.a;
        L7:
            if (Intrinsics.areEqual(r1, tc0.c.h().f) == false) goto L16;
            com.bytedance.android.live.liveinteract.plantform.linksecurity.rts.a.b r6 = this.a.e;
            if (r6 == null) goto L11;
            r6.c();
        L11:
            g r7 = this.a.c;
            if (r7 != null) goto L14;
            return;
        L14:
            if (r7.isEngineOn() != true) goto L28;
            this.a.c.n();
            return;
        L28:
            return;
        L16:
            jg6.a r2 = this.a.wq();
            if (r2 == null) goto L30;
            e r3 = r2.b();
            if (r3 == null) goto L31;
            ph0.a r8 = (ph0.a) sh6.c.b(r5);
            if (r8 == null) goto L24;
            String r9 = r8.a;
            if (r9 == null) goto L24;
        L25:
            r3.h(r9, true, "rts kick outf");
            return;
        L24:
            r9 = "";
            goto L25
        L31:
            return;
        L30:
            return;
        L5:
            r1 = null;
            goto L7
        }
    }

    public final jg6.a wq() {
        cg6.a r0 = getScopeServiceOrNullInMultiLinkRoom(cg6.a.class);
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.e5();
    }

    @Override // com.bytedance.android.live.liveinteract.linkbase.api.BaseMultiLinkWidget
    public final int getScene() {
        return o.c();
    }

    @Override // com.bytedance.android.live.liveinteract.linkbase.api.BaseMultiLinkWidget
    public final void onCreate() {
        super.onCreate();
        g r0 = this.c;
        if (r0 == null) goto L5;
        r0.z((com.bytedance.android.live.liveinteract.plantform.linksecurity.rts.a) this.a.getValue());
    L5:
        Pair r1 = com.bytedance.live.datacontext.d.a(RTSVoiceWidget$onCreate$pair$1.INSTANCE);
        com.bytedance.live.datacontext.b.a((DataContext) r1.getFirst(), RTSDataContext.class);
        this.b.add((Disposable) r1.getSecond());
        i<ILinkPlayerInfoBridge> r2 = this.d;
        if (r2 == null) goto L8;
        r2.Q4(new c(this));
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
        n<ph0.c> r7 = r6.getSilenceEvent();
        if (r7 == null) goto L20;
        Observable r8 = r7.a();
        if (r8 == null) goto L20;
        Disposable r9 = r8.subscribe(new a(this));
        if (r9 == null) goto L20;
        RxUtilKt.c(r9, this.b);
    L20:
        RTSDataContext r10 = r5.getContext();
        if (r10 == null) goto L30;
        n<ph0.a> r11 = r10.getKickOutEvent();
        if (r11 == null) goto L31;
        Observable r12 = r11.a();
        if (r12 == null) goto L32;
        Disposable r13 = r12.subscribe(new b(this));
        if (r13 == null) goto L33;
        RxUtilKt.c(r13, this.b);
        return;
    L33:
        return;
    L32:
        return;
    L31:
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.linkbase.api.BaseMultiLinkWidget
    public final void onDestroy() {
        super.onDestroy();
        this.b.clear();
        ((com.bytedance.android.live.liveinteract.plantform.linksecurity.rts.a) this.a.getValue()).a.clear();
    }

    public final void xq(List<? extends ILinkPlayerInfoBridge> r5) {
        if (r5 == null) goto L20;
        Iterator<T> r6 = r5.iterator();
    L5:
        if (r6.hasNext() == false) goto L34;
        ILinkPlayerInfoBridge r0 = (ILinkPlayerInfoBridge) r6.next();
        if (r2.a(r0.getMInteractIdStr()) == false) goto L5;
        if ((!Intrinsics.areEqual(r0.getMInteractIdStr(), tc0.c.h().f)) == false) goto L5;
        if (r0.getSilenceStatus() != 0) goto L5;
        jg6.a r1 = wq();
        if (r1 == null) goto L5;
        e r2 = r1.b();
        if (r2 == null) goto L5;
        String r3 = r0.getMInteractIdStr();
        if (r3 != null) goto L19;
        r3 = "";
    L19:
        r2.h(r3, false, "rts user list changed voice");
        goto L5
    L34:
        return;
    }

    public RTSVoiceWidget(g r1, y r2, com.bytedance.android.live.liveinteract.plantform.linksecurity.rts.a.b r3, dn0.c r4) {
        this.c = r1;
        this.d = r2;
        this.e = r3;
        this.f = r4;
        this.a = LazyKt.lazy(new RTSVoiceWidget$mRTSHandler$2(this));
        this.b = new CompositeDisposable();
    }

    public /* synthetic */ RTSVoiceWidget(g r2, y r3, com.bytedance.android.live.liveinteract.plantform.linksecurity.rts.a.b r4, int r5) {
        if ((r5 & 4) == 0) goto L5;
        r4 = null;
    L5:
        this(r2, r3, r4, null);
    }
}
