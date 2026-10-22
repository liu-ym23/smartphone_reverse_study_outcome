package com.bytedance.android.live.revlink.impl.multianchor.transfer;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.revlink.impl.multianchor.utils.MultiFeedUtils;
import com.bytedance.android.livesdk.link.model.t6;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.roomplayer.AbsLivePlayerView;
import com.bytedance.android.scope.m;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.ugc.aweme.debug.LocalTestManager;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.List;
import k31.g;
import k31.k;
import k31.n;
import k31.p;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import org.json.JSONArray;
import org.json.JSONObject;
import rc0.j;
import rc0.q;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class c implements rc0.e {
    public final b a;
    public boolean b;
    public String c;
    public j d;
    public final Lazy e;
    public View f;
    public String g;
    public String h;
    public boolean i;
    public String j;
    public String k;
    public final CompositeDisposable l;
    public cy0.c m;
    public final DataCenter n;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ c a;

        public a(c r1) {
            this.a = r1;
        }

        public final void accept(Object r5) {
            sh6.b r6 = (sh6.b) r5;
            c r7 = this.a;
            if (r7.b == false) goto L39;
            View r0 = r7.f;
            if (r0 == null) goto L40;
            cy0.c r1 = r7.m;
            if (r1 == null) goto L11;
            ld.a r2 = (ld.a) m.e.d(r1, ld.a.class);
        L12:
            if (r2 == null) goto L18;
            NextLiveData r3 = r2.Ed();
            if (r3 == null) goto L18;
            oq2.a r4 = (oq2.a) r3.getValue();
            if (r4 == null) goto L18;
            boolean r8 = r4.c;
        L19:
            r7.i = r8;
            if (r2 == null) goto L27;
            NextLiveData r9 = r2.Ed();
            if (r9 == null) goto L27;
            oq2.a r10 = (oq2.a) r9.getValue();
            if (r10 == null) goto L27;
            String r12 = r10.a;
            if (r12 == null) goto L27;
        L28:
            r7.g = r12;
            if (r2 == null) goto L36;
            NextLiveData r13 = r2.Ed();
            if (r13 == null) goto L36;
            oq2.a r14 = (oq2.a) r13.getValue();
            if (r14 == null) goto L36;
            String r15 = r14.b;
            if (r15 == null) goto L36;
        L37:
            r7.h = r15;
            r7.i(r0, true, true);
            return;
        L36:
            r15 = d51.c.A0.j();
        L27:
            r12 = d51.c.A0.k();
        L18:
            r8 = false;
            goto L19
        L11:
            r2 = null;
            goto L12
        L40:
            return;
        }
    }

    public final void d() {
        this.l.clear();
    }

    public final void e() {
        if (this.n != null) goto L5;
        return;
    L5:
        cy0.c r0 = this.m;
        if (r0 == null) goto L8;
        ld.a r1 = (ld.a) m.e.d(r0, ld.a.class);
    L9:
        if (r1 == null) goto L18;
        NextLiveData r2 = r1.Ed();
        if (r2 == null) goto L19;
        Observable r3 = ld.c.a(r2);
        if (r3 == null) goto L20;
        Disposable r4 = r3.subscribe(new a(this));
        if (r4 == null) goto L21;
        this.l.add(r4);
        return;
    L21:
        return;
    L20:
        return;
    L19:
        return;
    L18:
        return;
    L8:
        r1 = null;
        goto L9
    }

    public final rc0.m f() {
        k31.c r0 = this.a.c;
        if (r0 != null) goto L7;
        return null;
    L7:
        return new rc0.m(r0.a, r0.b, r0.c, r0.d);
    }

    public final boolean c() {
        return this.b;
    }

    public final void E(cy0.a r3) {
        if (r3 == null) goto L6;
        xq2.a r4 = (xq2.a) m.e.d(r3, xq2.a.class);
        if (r4 == null) goto L6;
        cy0.c r5 = r4.c0();
    L7:
        if (r5 == null) goto L10;
        this.m = r5;
        return;
    L10:
        return;
    L6:
        r5 = null;
        goto L7
    }

    public final void a(AbsLivePlayerView r4) {
        Intrinsics.checkNotNullParameter(r4, "playerView");
        if ((r4 instanceof AbsLivePlayerView) == true) goto L6;
        return;
    L6:
        if (this.b == true) goto L8;
        return;
    L8:
        b r0 = this.a;
        Disposable r1 = r0.d;
        if (r1 == null) goto L11;
        r1.dispose();
    L11:
        r0.d = null;
        i(r4, false, false);
        wq2.e.a().b("");
        this.b = false;
        this.f = null;
        this.d = null;
        this.c = null;
        jy0.b.c("ttlive_anchor_link_player", "MultiPlayerProxy reset", null, 4);
    }

    public final void b(AbsLivePlayerView r4) {
        Intrinsics.checkNotNullParameter(r4, "playerView");
        if ((r4 instanceof AbsLivePlayerView) == true) goto L5;
        return;
    L5:
        int r0 = MultiFeedUtils.a;
        MultiFeedUtils.b(r4);
        this.d = null;
        this.c = null;
        jy0.b.c("ttlive_anchor_link_player", "MultiPlayerProxy detach", null, 4);
    }

    public final void h(j r23) {
        Intrinsics.checkNotNullParameter(r23, "param");
        Context r2 = r23.getContext();
        boolean r8 = r23.a;
        View r7 = r23.b;
        LiveMode r9 = r23.c;
        String r10 = r23.d;
        boolean r3 = r23.f;
        int r4 = r23.g;
        q r5 = r23.e;
        if (r5 == null) goto L5;
        String r6 = r5.a;
    L6:
        if (r5 == null) goto L8;
        boolean r12 = true;
    L9:
        boolean r13 = r23.h;
        int r14 = r23.i;
        if (r12 == false) goto L53;
        j r15 = this.d;
        if (r15 != null) goto L15;
    L28:
        boolean r16 = true;
    L31:
        if (r16 == false) goto L33;
        jy0.b.c("ttlive_anchor_link_player", "need adjust stream, old=" + this.d + " new=" + r23, null, 4);
        this.d = r23;
        this.c = r6;
        goto L53
    L33:
        r9 = r9;
        r10 = r10;
        if (r6 != null) goto L36;
    L39:
        boolean r17 = true;
    L40:
        if (r17 == true) goto L50;
        String r18 = new Regex("\"talk\":[012]").replace(r6, "");
        if (Intrinsics.areEqual(r18, this.c) == true) goto L44;
    L49:
        r7 = r7;
        jy0.b.c("ttlive_anchor_link_player", "trimmed app_data sei diff old: " + this.c + " param=" + this.d, null, 4);
        jy0.b.c("ttlive_anchor_link_player", "trimmed app_data sei diff new: " + r6 + " param=" + r23, null, 4);
        this.d = r23;
        this.c = r18;
        goto L53
    L44:
        if (r18.length() <= 0) goto L46;
        boolean r19 = true;
    L47:
        if (r19 == false) goto L49;
        return;
    L46:
        r19 = false;
        goto L47
    L50:
        r7 = r7;
        jy0.b.c("ttlive_anchor_link_player", "no app_data adjust stream, param=" + r23, null, 4);
        goto L53
    L36:
        if (r6.length() == 0) goto L39;
        r17 = false;
        goto L40
    L15:
        if (r15.g != r4) goto L28;
        if (r15.f != r3) goto L28;
        if (r15.a != r8) goto L28;
        if ((!Intrinsics.areEqual(r15.b, r7)) == true) goto L28;
        if (r15.j != r23.j) goto L28;
        r16 = false;
    L53:
        int r20 = s1.y();
        if (r12 == false) goto L57;
        if (r8 == false) goto L57;
        int r22 = ((Number) this.e.getValue()).intValue();
    L58:
        if (r22 <= r20) goto L60;
        boolean r24 = true;
    L61:
        if (r8 != r24) goto L64;
        r20 = r22;
        r22 = r20;
    L64:
        JSONObject r110 = null;
        k31.m r111 = new k31.m(r22, r20, true, r7, r8, r9, r10, r23.e, new k(p.c(r8, p.b(r2), true), s1.A()), new k31.a(new g(r3, Integer.valueOf(r4)), new n(r13, r14)), r23.j);
        Intrinsics.checkNotNullParameter(r111, "transferParam");
        String r1 = r111.g;
        if (r1 == null) goto L96;
        View r25 = r111.d;
        if ((r25 instanceof AbsLivePlayerView) == false) goto L97;
        q r26 = r111.i;
        if (r26 == null) goto L73;
        boolean r112 = true;
    L74:
        if (r26 == null) goto L77;
        r110 = r26.b;
    L77:
        if (r112 == false) goto L84;
        if (r110 == null) goto L84;
        JSONArray r27 = com.bytedance.android.live.revenue.common.player.utils.a.c(r110);
        if (r27 == null) goto L84;
        if (r27.length() >= 2) goto L84;
        return;
    L84:
        Intrinsics.checkNotNullParameter(r1, "sei");
        JSONArray r28 = com.bytedance.android.live.revenue.common.player.utils.a.b(r1);
        if (r28 == null) goto L87;
        int r113 = r28.length();
    L88:
        if (r113 < 2) goto L99;
        this.a.a(r111);
        if (this.a.c == null) goto L93;
        boolean r29 = false;
        LocalTestManager.a(new Class[]{wy.a.class});
    L94:
        i(r25, true, r29);
        wq2.e.a().h("");
        this.b = true;
        this.f = r25;
        return;
    L93:
        r29 = false;
        goto L94
    L99:
        return;
    L87:
        r113 = 0;
        goto L88
    L73:
        r112 = false;
        goto L74
    L97:
        return;
    L96:
        return;
    L60:
        r24 = false;
    L57:
        r22 = p.a(r2, r8, true);
        goto L58
    L8:
        r12 = false;
        goto L9
    L5:
        r6 = null;
        goto L6
    }

    public c(DataCenter r2, Boolean r3) {
        this.n = r2;
        this.a = new b(false, r3);
        this.e = LazyKt.lazy(MultiPlayerProxy$portraitContainerHeight$2.INSTANCE);
        d51.c r4 = d51.c.A0;
        this.g = r4.k();
        this.h = r4.j();
        this.j = r4.k();
        this.k = r4.j();
        this.l = new CompositeDisposable();
    }

    public final boolean g(LiveMode r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "liveMode");
        return this.a.b(r2, r3);
    }

    public final void i(View r18, boolean r19, boolean r20) {
        if ((r18 instanceof AbsLivePlayerView) == true) goto L5;
        return;
    L5:
        k31.c r2 = this.a.c;
        String r3 = this.g;
        String r4 = this.h;
        boolean r5 = this.i;
        if (y41.f.N.g() == false) goto L46;
        com.bytedance.android.live.revlink.impl.multianchor.service.d r6 = com.bytedance.android.live.revlink.impl.global.b.z();
        if (r6 == null) goto L12;
        i11.b r7 = r6.getLinkUserCenter();
        if (r7 == null) goto L12;
        t6 r8 = r7.j();
    L13:
        boolean r9 = false;
        if (r8 == null) goto L21;
        py.k r10 = r8.getRoomBgTopImage();
        if (r10 == null) goto L21;
        List r12 = r10.getUrls();
        if (r12 == null) goto L21;
        String r13 = (String) ListProtector.get(r12, 0);
        if (r13 == null) goto L21;
    L22:
        if (r8 == null) goto L29;
        py.k r14 = r8.getRoomBgBottomImage();
        if (r14 == null) goto L29;
        List r15 = r14.getUrls();
        if (r15 == null) goto L29;
        String r16 = (String) ListProtector.get(r15, 0);
        if (r16 == null) goto L29;
    L30:
        if (r8 == null) goto L34;
        py.k r17 = r8.getRoomBgTopImage();
        if (r17 == null) goto L34;
        boolean r22 = r17.isAnimated();
    L36:
        if (Intrinsics.areEqual(this.j, r13) == true) goto L38;
    L40:
        boolean r23 = false;
    L41:
        if (r8 == null) goto L44;
        if (r23 == true) goto L45;
        r9 = true;
    L45:
        this.j = r13;
        this.k = r16;
        boolean r110 = r9;
        String r111 = r13;
        String r112 = r16;
        boolean r113 = r22;
    L47:
        if (r19 == false) goto L52;
        if (r2 == null) goto L52;
        if (r2.e == true) goto L52;
        int r24 = MultiFeedUtils.a;
        AbsLivePlayerView r25 = (AbsLivePlayerView) r18;
        Intrinsics.checkNotNullParameter(r25, "playerView");
        Intrinsics.checkNotNullParameter(r2, "coreLayout");
        Intrinsics.checkNotNullParameter(r111, "topBgUrl");
        Intrinsics.checkNotNullParameter(r112, "bottomBgUrl");
        int r114 = r2.c;
        MultiFeedUtils.c(r25, r114, r114 + r2.b, MultiFeedUtils.ViewIndex.INDEX_FRONT, r111, r112, r110, r113);
        return;
    L52:
        int r26 = MultiFeedUtils.a;
        MultiFeedUtils.b((FrameLayout) r18);
        return;
    L44:
        r9 = r20;
        goto L45
    L38:
        if (Intrinsics.areEqual(this.k, r16) == false) goto L40;
        r23 = true;
    L34:
        r22 = this.i;
    L29:
        r16 = this.h;
    L21:
        r13 = this.g;
    L12:
        r8 = null;
        goto L13
    L46:
        r110 = r20;
        r111 = r3;
        r112 = r4;
        r113 = r5;
        goto L47
    }
}
