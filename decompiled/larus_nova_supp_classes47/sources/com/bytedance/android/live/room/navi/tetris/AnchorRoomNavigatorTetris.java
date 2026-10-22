package com.bytedance.android.live.room.navi.tetris;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.bytedance.android.live.core.tetris.layer.core.element.Element;
import com.bytedance.android.live.core.tetris.layer.core.tetris.LiveTetris;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.room.api.INavigationService;
import com.bytedance.android.livesdk.config.yo0;
import com.bytedance.android.livesdk.popup.manager.LivePopupWindow;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.utility.SharedPrefHelper;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import zg1.m0;
import zg1.q3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\b"}, d2 = {"Lcom/bytedance/android/live/room/navi/tetris/AnchorRoomNavigatorTetris;", "Lcom/bytedance/android/live/room/navi/tetris/RoomNavigatorTetris;", "Lo70/b;", "event", "", "onEvent", "<init>", "()V", "experience-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnchorRoomNavigatorTetris extends RoomNavigatorTetris {
    public final long A;
    public final long B;
    public boolean C;
    public Activity D;
    public final CompositeDisposable E;
    public ViewGroup v;
    public LivePopupWindow w;
    public View x;
    public Disposable y;
    public Disposable z;

    public final boolean W() {
        Activity r0 = this.D;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.isFinishing() == true) goto L7;
        return true;
    }

    public AnchorRoomNavigatorTetris() {
        this.A = 30;
        this.B = 7;
        this.E = new CompositeDisposable();
    }

    public final void O() {
        DataCenter r0 = K().h;
        if (r0 != null) goto L5;
    L6:
        LiveMode r1 = LiveMode.VIDEO;
    L7:
        this.s = K().h;
        ViewGroup r3 = this.o;
        if (r3 == null) goto L10;
        LiveTetris.Q(this, ((INavigationService) jc1.k.n(INavigationService.class)).getUserInfoWidget(K().h), r3, true, null, 24);
    L10:
        int r2 = (int) UIUtils.dip2Px(s1.getContext(), 12.0f);
        UIUtils.updateLayoutMargin(this.o, -3, -3, r2, -3);
        if (((Boolean) g81.a.a.getValue()).booleanValue() == false) goto L18;
        ImageView r4 = this.r;
        if (r4 == null) goto L15;
        r4.setVisibility(0);
    L15:
        ImageView r5 = this.r;
        if (r5 == null) goto L21;
        r5.setOnClickListener(new a(this));
    L21:
        V(K());
        Disposable r6 = xs2.b.a().b(q3.class).subscribe(new b(this));
        this.E.add(r6);
        return;
    L18:
        ImageView r7 = this.r;
        if (r7 == null) goto L21;
        r7.setVisibility(8);
        goto L21
    L5:
        if (((LiveMode) r0.get("data_live_mode", LiveMode.VIDEO)) != null) goto L7;
        goto L6
    }

    public final void onDestroy() {
        super/*com.bytedance.android.live.core.tetris.layer.core.tetris.Tetris*/.onDestroy();
        this.E.clear();
    }

    public final void onStart() {
        super/*com.bytedance.android.live.core.tetris.layer.core.tetris.Tetris*/.onStart();
        if (((Boolean) g81.a.a.getValue()).booleanValue() == true) goto L5;
        return;
    L5:
        if (this.C == true) goto L14;
        this.C = true;
        if (((Boolean) yo0.a.getValue()).booleanValue() == false) goto L10;
        return;
    L10:
        if (SharedPrefHelper.b(K().getContext()).f("live.pref.PREF_CLOSE_LIVE_POPUP", false) == true) goto L15;
        this.y = Observable.timer(this.A, TimeUnit.SECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new c(this), d.a);
        return;
    L15:
        return;
    }

    public final View G(t70.k r3) {
        Intrinsics.checkNotNullParameter(r3, "inflater");
        View r4 = r3.b(2131567157);
        this.x = r4;
        ViewGroup r0 = null;
        if (r4 == null) goto L5;
        Context r5 = r4.getContext();
    L7:
        if ((r5 instanceof Activity) == false) goto L16;
        View r6 = this.x;
        if (r6 == null) goto L11;
        Context r7 = r6.getContext();
    L12:
        if (r7 == null) goto L15;
        this.D = (Activity) r7;
        goto L16
    L15:
        throw new NullPointerException("null cannot be cast to non-null type android.app.Activity");
    L11:
        r7 = null;
    L16:
        View r8 = this.x;
        if (r8 == null) goto L19;
        ViewGroup r9 = (ViewGroup) r8.findViewById(2131392032);
    L20:
        this.o = r9;
        View r10 = this.x;
        if (r10 == null) goto L23;
        ViewGroup r12 = (ViewGroup) r10.findViewById(2131389219);
    L24:
        this.p = r12;
        View r13 = this.x;
        if (r13 == null) goto L27;
        ViewGroup r14 = (ViewGroup) r13.findViewById(2131389218);
    L28:
        this.q = r14;
        View r15 = this.x;
        if (r15 == null) goto L31;
        ImageView r16 = (ImageView) r15.findViewById(2131366999);
    L32:
        this.r = r16;
        View r17 = this.x;
        if (r17 == null) goto L35;
        r0 = (ViewGroup) r17.findViewById(2131389217);
    L35:
        this.v = r0;
        View r18 = this.x;
        Intrinsics.checkNotNull(r18);
        return r18;
    L31:
        r16 = null;
        goto L32
    L27:
        r14 = null;
        goto L28
    L23:
        r12 = null;
        goto L24
    L19:
        r9 = null;
        goto L20
    L5:
        r5 = null;
        goto L7
    }

    public final void H(Element<?> r2) {
        Intrinsics.checkNotNullParameter(r2, "element");
        super/*com.bytedance.android.live.core.tetris.layer.core.tetris.Tetris*/.H(r2);
        Disposable r3 = this.y;
        if (r3 == null) goto L5;
        r3.dispose();
    L5:
        Disposable r4 = this.z;
        if (r4 == null) goto L9;
        r4.dispose();
        return;
    }

    @Override // com.bytedance.android.live.room.navi.tetris.RoomNavigatorTetris
    public void onEvent(o70.b r2) {
        Intrinsics.checkNotNullParameter(r2, "event");
        super.onEvent(r2);
        if ((r2 instanceof m0) == false) goto L10;
        boolean r3 = ((m0) r2).a;
        View r0 = L();
        if (r3 == false) goto L7;
        float r4 = 0.0f;
    L8:
        r0.setAlpha(r4);
        return;
    L7:
        r4 = 1.0f;
        goto L8
    }
}
