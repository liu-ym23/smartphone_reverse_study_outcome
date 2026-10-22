package com.bytedance.android.live.broadcastgame.openplatform.feature_panel.business;

import android.text.TextUtils;
import com.bytedance.android.live.broadcastgame.api.interactgame.n;
import com.bytedance.android.live.broadcastgame.api.model.InteractEntranceCell;
import com.bytedance.android.live.broadcastgame.api.model.m0;
import com.bytedance.android.live.broadcastgame.openplatform.feature_panel.viewmodel.AbsOpenFeaturePanelViewModel;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ExtendedToolbarButton;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class i implements a20.l {
    public final AbsOpenFeaturePanelViewModel a;
    public final a20.k b;
    public final /* synthetic */ i20.a c;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ i a;
        public final /* synthetic */ List b;
        public final /* synthetic */ String c;

        public a(i r1, List r2, String r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void accept(Object r9) {
            List<InteractEntranceCell> r11 = ((m0) ((ExtraResponse) ((com.bytedance.android.live.network.response.e) r9)).data).cells;
            Iterator<T> r0 = r11.iterator();
        L4:
            if (r0.hasNext() == false) goto L6;
            ((InteractEntranceCell) r0.next()).d = true;
            goto L4
        L6:
            e10.a<InteractEntranceCell, ?> r1 = this.a.a.getOpenFeatureFilter();
            List<DATA> r12 = r1.filter(r11);
            ArrayList r2 = new ArrayList(r12.size());
            List r3 = this.b;
            if (r3 == null) goto L16;
            Iterator<T> r4 = r3.iterator();
        L10:
            if (r4.hasNext() == false) goto L16;
            f10.f r5 = (f10.f) r4.next();
            String r6 = ((ExtendedToolbarButton.c) r5).q;
            if (TextUtils.isEmpty(r6) == true) goto L10;
            if (StringsKt.contains$default(r6, this.c, false, 2, null) == false) goto L10;
            r2.add(r5);
        L16:
            this.a.a.getFeatureIconRunningStateManager().d();
            Iterator r13 = r12.iterator();
        L18:
            if (r13.hasNext() == false) goto L20;
            InteractEntranceCell r7 = (InteractEntranceCell) r13.next();
            a20.d r8 = this.a.a.getFeatureIconBehaviorController();
            i r14 = this.a;
            r14.getClass();
            r2.add(r8.c(r7, r14.f().isInLive(), 2, false));
            goto L18
        L20:
            this.a.a.showOpenFeatureSearchResult(r2);
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ i a;

        public b(i r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            ALogger.e("searchFeature", ((Throwable) r2).getMessage());
            this.a.a.showOpenFeatureSearchResult(null);
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ i a;

        public c(i r1) {
            this.a = r1;
        }

        public final void accept(Object r7) {
            List<InteractEntranceCell> r8 = ((m0) ((ExtraResponse) ((com.bytedance.android.live.network.response.e) r7)).data).cells;
            Iterator<T> r0 = r8.iterator();
        L4:
            if (r0.hasNext() == false) goto L6;
            ((InteractEntranceCell) r0.next()).d = true;
            goto L4
        L6:
            e10.a<InteractEntranceCell, ?> r1 = this.a.a.getOpenFeatureFilter();
            List<DATA> r9 = r1.filter(r8);
            ArrayList r2 = new ArrayList(r9.size());
            this.a.a.getFeatureIconRunningStateManager().d();
            Iterator r11 = r9.iterator();
        L8:
            if (r11.hasNext() == false) goto L10;
            InteractEntranceCell r3 = (InteractEntranceCell) r11.next();
            a20.d r4 = this.a.a.getFeatureIconBehaviorController();
            i r5 = this.a;
            r5.getClass();
            r2.add(r4.c(r3, r5.f().isInLive(), 2, false));
            goto L8
        L10:
            this.a.a.showOpenFeatureSearchResult(r2);
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ i a;

        public d(i r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            ALogger.e("searchFeature", ((Throwable) r2).getMessage());
            this.a.a.showOpenFeatureSearchResult(null);
        }
    }

    @Override // a20.l
    public final LinkedList<String> a() {
        return this.b.a();
    }

    @Override // a20.c
    public final void onDestroy() {
        this.b.b();
        this.c.b();
    }

    @Override // a20.c
    public final AbsOpenFeaturePanelViewModel f() {
        return this.a;
    }

    public i(AbsOpenFeaturePanelViewModel r2, a20.k r3) {
        Intrinsics.checkNotNullParameter(r2, "viewModel");
        Intrinsics.checkNotNullParameter(r3, "model");
        this.c = new i20.a();
        this.a = r2;
        this.b = r3;
    }

    @Override // a20.l
    public final void i(String r7, List<f10.f> r8) {
        Intrinsics.checkNotNullParameter(r7, "keyword");
        int r0 = n.a;
        Intrinsics.checkNotNullParameter(r7, "searchText");
        u.l().sendLog("livesdk_anchor_interactive_extension_search", MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("search_content", r7)}), new Object[]{Room.class});
        this.a.getFeatureIconRunningStateManager().d();
        ArrayList r1 = new ArrayList();
        if (r8 != null) goto L19;
    L14:
        this.a.showOpenFeatureSearchResult(r1);     // Catch: Exception -> L12
    L17:
        this.b.h(r7);
        return;
    L12:
        e = move-exception;
        ALogger.e("searchFeature", e.getMessage());
        this.a.showOpenFeatureSearchResult(null);
        goto L17
    L19:
        Iterator<T> r9 = r8.iterator();     // Catch: Exception -> L12
    L6:
        if (r9.hasNext() == false) goto L14;
        f10.f r2 = (f10.f) r9.next();     // Catch: Exception -> L12
        String r3 = ((ExtendedToolbarButton.c) r2).q;     // Catch: Exception -> L12
        if (TextUtils.isEmpty(r3) == true) goto L6;
        if (StringsKt.contains$default(r3, r7, false, 2, null) == false) goto L6;
        r1.add(r2);     // Catch: Exception -> L12
        goto L6
    }

    @Override // a20.l
    public final void j(long r8, Long r11, String r12) {
        Intrinsics.checkNotNullParameter(r12, "keyword");
        int r0 = n.a;
        n.j(f().isInLive());
        su0.a r1 = yt0.c.g();
        if (r1 == null) goto L5;
        int r5 = r1.pf();
    L6:
        Disposable r9 = this.b.j(r8, r11, r5, r12).subscribe(new c(this), new d(this));
        Intrinsics.checkNotNullParameter(r9, "$this$autoDispose");
        this.c.a(r9);
        this.b.h(r12);
        return;
    L5:
        r5 = 0;
        goto L6
    }

    @Override // a20.l
    public final void g(long r8, Long r11, String r12, List<f10.f> r13) {
        Intrinsics.checkNotNullParameter(r12, "keyword");
        int r0 = n.a;
        n.j(f().isInLive());
        su0.a r1 = yt0.c.g();
        if (r1 == null) goto L5;
        int r5 = r1.pf();
    L6:
        Disposable r9 = this.b.g(r8, r11, r5, r12).subscribe(new a(this, r13, r12), new b(this));
        Intrinsics.checkNotNullParameter(r9, "$this$autoDispose");
        this.c.a(r9);
        this.b.h(r12);
        return;
    L5:
        r5 = 0;
        goto L6
    }
}
