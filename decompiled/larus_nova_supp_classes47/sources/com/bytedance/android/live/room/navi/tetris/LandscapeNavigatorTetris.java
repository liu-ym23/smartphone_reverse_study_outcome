package com.bytedance.android.live.room.navi.tetris;

import android.view.View;
import android.widget.ImageView;
import com.bytedance.android.live.core.tetris.layer.core.tetris.LiveTetris;
import com.bytedance.android.live.core.utils.rxutils.autodispose.AutoDispose;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.live.room.api.userinfo.INavigationProxyService;
import com.bytedance.android.livesdk.app.dataholder.Observer;
import com.bytedance.android.livesdk.chatroom.r;
import com.bytedance.android.livesdk.chatroom.vsplayer.api.IVSPlayerService;
import com.bytedance.android.livesdk.chatroom.vsplayer.model.PlayerViewControl;
import com.bytedance.android.livesdk.config.w71;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.rxbus.RxBusAbility;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import l81.v;
import zg1.n3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001\nB\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/live/room/navi/tetris/LandscapeNavigatorTetris;", "Lcom/bytedance/android/live/core/tetris/layer/core/tetris/LiveTetris;", "Ld90/d;", "Lo70/a;", "Lo70/b;", "event", "", "onEvent", "<init>", "()V", "a", "experience-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LandscapeNavigatorTetris extends LiveTetris<d90.d> implements o70.a {
    public c o;
    public boolean p;
    public ImageView q;

    public static final class a {
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ LandscapeNavigatorTetris a;

        public b(LandscapeNavigatorTetris r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            n3 r4 = (n3) r3;
            r r0 = z51.a.e(this.a.K().h);
            if (r0 != null) goto L5;
        L7:
            ImageView r1 = this.a.q;
            if (r1 == null) goto L17;
            if (r4 != null) goto L11;
        L14:
            int r5 = 0;
        L15:
            r1.setVisibility(r5);
            return;
        L11:
            if (r4.a != true) goto L14;
            r5 = 8;
            goto L15
        L17:
            return;
        L5:
            if (r0.isInVrLandscape(this.a.K().h) == true) goto L7;
        }
    }

    public static final class c<T> implements Observer {
        public final /* synthetic */ LandscapeNavigatorTetris a;

        public c(LandscapeNavigatorTetris r1) {
            this.a = r1;
        }

        public final void onChanged(Object r2) {
            Integer r3 = (Integer) r2;
            if (r3 != null) goto L6;
            return;
        L6:
            if (r3.intValue() != 0) goto L11;
            ImageView r4 = this.a.q;
            if (r4 == null) goto L10;
            r4.setBackgroundResource(2131252179);
        L10:
            this.a.p = false;
            return;
        L11:
            ImageView r5 = this.a.q;
            if (r5 == null) goto L14;
            r5.setBackgroundResource(2131252180);
        L14:
            this.a.p = true;
        }
    }

    static {
    }

    public final List<Class<? extends o70.b>> Mg() {
        return CollectionsKt.listOf(bh1.a.class);
    }

    public final void O() {
        View r0 = L();
        if (r0 == null) goto L36;
        this.q = (ImageView) r0;
        r r1 = z51.a.e(K().h);
        if (r1 != null) goto L7;
    L17:
        ImageView r2 = this.q;
        if (r2 == null) goto L20;
        r2.setOnClickListener(new l(this));
    L20:
        this.o = new c(this);
        INavigationProxyService r3 = (INavigationProxyService) jc1.k.f(INavigationProxyService.class);
        if (r3 == null) goto L25;
        v r4 = r3.getVSMediaUIConfigHelper();
        if (r4 == null) goto L25;
        boolean r5 = r4.a((d90.d) K());
    L27:
        if (d90.e.i(K()) == true) goto L29;
        if (r5 == true) goto L29;
        return;
    L29:
        ImageView r6 = this.q;
        if (r6 == null) goto L39;
        com.bytedance.android.livesdk.chatroom.vsplayer.api.c r7 = jc1.k.n(IVSPlayerService.class).provideVSPlayerViewControlService(K().h);
        if (r7 == null) goto L40;
        com.bytedance.android.livesdk.chatroom.vsplayer.api.c.a.a(r7, PlayerViewControl.KEY.MatchRoomBack, PlayerViewControl.Type.TOP, PlayerViewControl.Style.HIDE, r6, 0.0f, false, false, null, 496);
        return;
    L40:
        return;
    L39:
        return;
    L25:
        r5 = false;
        goto L27
    L7:
        if (r1.isInVrLandscape(K().h) != true) goto L17;
        r r8 = z51.a.e(K().h);
        if (r8 != null) goto L11;
    L16:
        b r9 = new b(this);
        ((ObservableSubscribeProxy) RxBusAbility.INSTANCE.getRxBus(K().h).b(n3.class).observeOn(AndroidSchedulers.mainThread()).as(AutoDispose.bind(this))).subscribe(r9);
        goto L17
    L11:
        if (r8.E(K().h) != true) goto L16;
        ImageView r10 = this.q;
        if (r10 == null) goto L37;
        r10.setVisibility(4);
        return;
    L37:
        return;
    L36:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.ImageView");
    }

    public final void onCreate() {
        super/*com.bytedance.android.live.core.tetris.layer.core.tetris.Tetris*/.onCreate();
        INavigationProxyService r0 = (INavigationProxyService) jc1.k.f(INavigationProxyService.class);
        if (r0 == null) goto L10;
        l81.g r1 = r0.getLinkPlayerState();
        if (r1 == null) goto L11;
        hd0.c r2 = r1.a();
        if (r2 == null) goto L12;
        r2.c(this.o);
        return;
    L12:
        return;
    L11:
        return;
    }

    public final void onDestroy() {
        super/*com.bytedance.android.live.core.tetris.layer.core.tetris.Tetris*/.onDestroy();
        if (this.o == null) goto L12;
        INavigationProxyService r0 = (INavigationProxyService) jc1.k.f(INavigationProxyService.class);
        if (r0 == null) goto L13;
        l81.g r1 = r0.getLinkPlayerState();
        if (r1 == null) goto L14;
        hd0.c r2 = r1.a();
        if (r2 == null) goto L15;
        r2.e(this.o);
        return;
    L15:
        return;
    L14:
        return;
    L13:
        return;
    }

    public LandscapeNavigatorTetris() {
    }

    public final View G(t70.k r3) {
        Intrinsics.checkNotNullParameter(r3, "inflater");
        View r4 = r3.b(2131566558);
        d90.d r0 = K();
        Intrinsics.checkNotNullParameter(r0, "layerContext");
        if (d90.e.i(r0) == false) goto L5;
    L7:
        boolean r1 = false;
    L8:
        if (r1 == false) goto L10;
        r4.setAlpha(0.0f);
    L10:
        return r4;
    L5:
        if (w71.a() == true) goto L7;
        r1 = true;
        goto L8
    }

    public void onEvent(o70.b r3) {
        Intrinsics.checkNotNullParameter(r3, "event");
        if ((r3 instanceof bh1.a) == false) goto L20;
        boolean r4 = ((bh1.a) r3).a;
        r r0 = z51.a.e(K().h);
        if (r0 != null) goto L7;
    L10:
        if (r4 == false) goto L12;
    L11:
        int r5 = 0;
    L13:
        ImageView r1 = this.q;
        if (r1 == null) goto L16;
        r1.setVisibility(r5);
    L16:
        ImageView r6 = this.q;
        if (r6 == null) goto L21;
        r6.setOnClickListener(new l(this));
        return;
    L21:
        return;
    L12:
        r5 = 4;
        goto L13
    L7:
        if (r0.isInVrLandscape(K().h) != true) goto L10;
        if (r4 == false) goto L11;
    }
}
