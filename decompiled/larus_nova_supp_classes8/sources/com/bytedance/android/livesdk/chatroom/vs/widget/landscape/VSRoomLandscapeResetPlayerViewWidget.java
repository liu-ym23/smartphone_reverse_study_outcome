package com.bytedance.android.livesdk.chatroom.vs.widget.landscape;

import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.live.core.tetris.widgets.LiveWidget;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.matchroom.MatchRoomLandScapeAnimUtil;
import com.bytedance.android.livesdk.chatroom.replay.castscreen.bytecast.ReplayByteCastHelper;
import com.bytedance.android.livesdk.chatroom.vs.gesture.VSGestureViewManagerHelper;
import com.bytedance.android.livesdk.chatroom.vs_base.base.util.r;
import com.bytedance.android.livesdk.chatroom.vs_base.base.util.s;
import com.bytedance.android.livesdk.chatroom.vs_base.util.h;
import com.bytedance.android.livesdk.chatroom.vsplayer.api.IVSPlayerService;
import com.bytedance.android.livesdk.chatroom.vsplayer.model.PlayerViewControl;
import com.bytedance.android.livesdk.chatroom.vsplayer.model.VSPlayerViewControlContext;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.live.datacontext.m;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import jc1.k;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mq1.v;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@PlayerViewControl(key = PlayerViewControl.KEY.LandscapeResetPlayerView, type = PlayerViewControl.Type.BOTTOM)
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/vs/widget/landscape/VSRoomLandscapeResetPlayerViewWidget;", "Lcom/bytedance/android/live/core/tetris/widgets/LiveWidget;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "<init>", "()V", "vs-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class VSRoomLandscapeResetPlayerViewWidget extends LiveWidget implements Observer<KVData> {
    public Disposable a;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ VSRoomLandscapeResetPlayerViewWidget a;

        public a(VSRoomLandscapeResetPlayerViewWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            View r0 = ((Widget) this.a).contentView;
            if (((Boolean) r3).booleanValue() == false) goto L7;
            Lazy r4 = ReplayByteCastHelper.a;
            DataCenter r5 = ((Widget) this.a).dataCenter;
            if (Intrinsics.areEqual(r.b().d(r5), Boolean.TRUE) == true) goto L7;
            int r6 = 0;
        L8:
            r0.setVisibility(r6);
            return;
        L7:
            r6 = 8;
            goto L8
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ VSRoomLandscapeResetPlayerViewWidget a;
        public final /* synthetic */ VSPlayerViewControlContext b;

        public b(VSRoomLandscapeResetPlayerViewWidget r1, VSPlayerViewControlContext r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r3) {
            View r0 = ((Widget) this.a).contentView;
            if (((Boolean) r3).booleanValue() == true) goto L11;
            VSPlayerViewControlContext r4 = this.b;
            if (r4 == null) goto L11;
            m<Boolean> r5 = r4.getPlayerViewIsInZoom();
            if (r5 == null) goto L11;
            if (((Boolean) r5.getValue()).booleanValue() != true) goto L11;
            int r6 = 0;
        L12:
            r0.setVisibility(r6);
            return;
        L11:
            r6 = 8;
            goto L12
        }
    }

    public static final class c implements View.OnClickListener {
        public static final c a = null;

        static {
            a = new c();
        }

        public c() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            ko1.c r3 = VSGestureViewManagerHelper.a;
            if (r3 == null) goto L5;
            Boolean r4 = Boolean.valueOf(r3.b("restore_button"));
        L7:
            if (Intrinsics.areEqual(r4, Boolean.TRUE) == false) goto L10;
            f2.b(2131923378, 0);
            return;
        L10:
            return;
        L5:
            r4 = null;
            goto L7
        }
    }

    public final int getLayoutId() {
        return 2131568043;
    }

    public final void onCreate() {
        super.onCreate();
        ((Widget) this).contentView.setVisibility(8);
        Disposable r1 = null;
        if (h.a(((Widget) this).dataCenter).isReplay() == false) goto L7;
        ((Widget) this).contentView.getLayoutParams().height = s1.f(28.0f);
        v r0 = s.e().provideVSPlayerViewControlService(((Widget) this).dataCenter);
        if (r0 == null) goto L12;
        VSPlayerViewControlContext r2 = r0.provideContext();
    L13:
        ViewGroup r3 = ((Widget) this).containerView;
        if (r3 == null) goto L16;
        ViewGroup.LayoutParams r4 = r3.getLayoutParams();
    L18:
        if ((r4 instanceof ConstraintLayout.LayoutParams) == true) goto L20;
        r4 = null;
    L20:
        ConstraintLayout.LayoutParams r5 = (ConstraintLayout.LayoutParams) r4;
        if (r5 == null) goto L23;
        r5.horizontalBias = 0.0f;
    L23:
        if (r2 == null) goto L29;
        m<Boolean> r6 = r2.getPlayerViewIsInZoom();
        if (r6 == null) goto L29;
        Observable r7 = r6.a();
        if (r7 == null) goto L29;
        r1 = r7.subscribe(new a(this));
    L29:
        this.a = r1;
        m<Boolean> r8 = r.b().castScreenMode(((Widget) this).dataCenter);
        if (r8 == null) goto L34;
        Observable r9 = r8.a();
        if (r9 == null) goto L34;
        r9.subscribe(new b(this, r2));
    L34:
        ((Widget) this).contentView.setOnClickListener(c.a);
        ko1.c r10 = VSGestureViewManagerHelper.a;
        VSGestureViewManagerHelper.c(new AnonymousClass4(this));
        ((Widget) this).dataCenter.observe("data_has_change_screen_orientation", this);
        return;
    L16:
        r4 = null;
    L12:
        r2 = null;
        goto L13
    L7:
        IVSPlayerService r11 = (IVSPlayerService) k.f(IVSPlayerService.class);
        if (r11 == null) goto L12;
        com.bytedance.android.livesdk.chatroom.vsplayer.api.c r12 = r11.provideVSPlayerViewControlService(((Widget) this).dataCenter);
        if (r12 == null) goto L12;
        r2 = r12.provideContext();
        goto L13
    }

    public final void onDestroy() {
        super.onDestroy();
        VSGestureViewManagerHelper.c(null);
        ((Widget) this).dataCenter.removeObserver(this);
        Disposable r0 = this.a;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.isDisposed() == true) goto L11;
        Disposable r1 = this.a;
        if (r1 == null) goto L12;
        r1.dispose();
        return;
    L12:
        return;
    }

    public VSRoomLandscapeResetPlayerViewWidget() {
    }

    public final void onChanged(Object r2) {
        KVData r3 = (KVData) r2;
        if (r3 != null) goto L6;
        return;
    L6:
        if (Intrinsics.areEqual(r3.getKey(), "data_has_change_screen_orientation") == false) goto L11;
        boolean r4 = MatchRoomLandScapeAnimUtil.a;
        MatchRoomLandScapeAnimUtil.e.cancel();
        MatchRoomLandScapeAnimUtil.u(0);
        MatchRoomLandScapeAnimUtil.A = 1.0f;
        MatchRoomLandScapeAnimUtil.B = 0.0f;
        MatchRoomLandScapeAnimUtil.C = 0.0f;
        MatchRoomLandScapeAnimUtil.r();
        ko1.c r5 = VSGestureViewManagerHelper.a;
        if (r5 == null) goto L12;
        r5.b("rotate_to_portrait");
        return;
    L12:
        return;
    }
}
