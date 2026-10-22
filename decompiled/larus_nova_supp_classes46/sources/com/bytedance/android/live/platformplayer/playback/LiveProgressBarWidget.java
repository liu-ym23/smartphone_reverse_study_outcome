package com.bytedance.android.live.platformplayer.playback;

import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.live.browser.IBaseBrowserService;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.setting.d4;
import com.bytedance.android.live.core.utils.a0;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.room.api.IVisibilityControlBrickService;
import com.bytedance.android.live.room.api.IVisibilityControlService;
import com.bytedance.android.live.room.api.visibilitycontrol.LiveVisibilityControl;
import com.bytedance.android.live.room.api.visibilitycontrol.LiveVisibilityControlContext;
import com.bytedance.android.livesdk.chatroom.IRoomContextService;
import com.bytedance.android.livesdk.chatroom.o;
import com.bytedance.android.livesdk.chatroom.progress.context.PlayerProgressServiceContext;
import com.bytedance.android.livesdk.chatroom.progress.service.IPlayerProgressService;
import com.bytedance.android.livesdk.chatroom.progressbar.IProgressCastService;
import com.bytedance.android.livesdk.chatroom.progressbar.c;
import com.bytedance.android.livesdk.chatroom.progressbar.ui.PlayerSeekBar;
import com.bytedance.android.livesdk.chatroom.progressbar.widget.PlayerProgressBarWidget;
import com.bytedance.android.livesdk.chatroom.vsplayer.model.e;
import com.bytedance.android.livesdk.config.RealTimePlaybackConfig;
import com.bytedance.android.livesdk.config.em0;
import com.bytedance.android.livesdkapi.depend.model.live.IQuality;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.RoomExtra;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.live.datacontext.m;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.List;
import java.util.concurrent.TimeUnit;
import jc1.k;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import nm1.s;
import pm1.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@LiveVisibilityControl(key = LiveVisibilityControl.KEY.LiveProgressBar, needDynamicControl = true, type = LiveVisibilityControl.Type.BOTTOM)
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/platformplayer/playback/LiveProgressBarWidget;", "Lcom/bytedance/android/livesdk/chatroom/progressbar/widget/PlayerProgressBarWidget;", "Lcom/bytedance/android/live/room/api/visibilitycontrol/a;", "<init>", "()V", "platform-player-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveProgressBarWidget extends PlayerProgressBarWidget implements com.bytedance.android.live.room.api.visibilitycontrol.a {
    public final long C;
    public final Lazy D;
    public final LiveProgressBarWidget$seekMethodFactory$1 E;

    public static final class a implements com.bytedance.android.livesdk.chatroom.progressbar.a.a {
        public final /* synthetic */ PlayerProgressServiceContext a;
        public final /* synthetic */ DataCenter b;

        public final boolean a() {
            if (((RealTimePlaybackConfig) d4.a.getValue()).getEnableForceSeekResolution() == false) goto L11;
            PlayerProgressServiceContext r0 = this.a;
            if (r0 == null) goto L11;
            m r1 = r0.getAtLatest();
            if (r1 == null) goto L11;
            if (((Boolean) r1.getValue()).booleanValue() == true) goto L11;
            return true;
        L11:
            return false;
        }

        public final IQuality b() {
            RoomExtra r0 = a0.n(this.b).getExtra();
            if (r0 == null) goto L7;
            List r1 = r0.getRealTimePlaybackQualities();
            if (r1 == null) goto L7;
            return (IQuality) CollectionsKt.getOrNull(r1, 0);
        L7:
            return null;
        }

        public final long c() {
            RoomExtra r0 = a0.n(this.b).getExtra();
            if (r0 == null) goto L6;
            return r0.getRealTimePlaybackShift();
        L6:
            return ((Long) em0.a.getValue()).longValue();
        }

        public a(PlayerProgressServiceContext r1, DataCenter r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ LiveProgressBarWidget a;

        public b(LiveProgressBarWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            Long r3 = (Long) r2;
            IPlayerProgressService r4 = k.n(rk1.a.class).M4(((Widget) this.a).dataCenter);
            if (r4 == null) goto L10;
            PlayerProgressServiceContext r5 = r4.provideContext(((Widget) this.a).dataCenter);
            if (r5 == null) goto L11;
            m r6 = r5.getShowSeekToNow();
            if (r6 == null) goto L12;
            r6.setValue(Boolean.FALSE);
            return;
        L12:
            return;
        L11:
            return;
        }
    }

    public final c Aq(ConstraintLayout r1, View r2, PlayerSeekBar r3, DataCenter r4) {
        Intrinsics.checkNotNullParameter(r2, "vsSeekToNow");
        Intrinsics.checkNotNullParameter(r3, "vsProgressSeekBar");
        Intrinsics.checkNotNullParameter(r4, "dataCenter");
        Intrinsics.checkNotNullParameter("VSProgressBarWidget", "TAG");
        return null;
    }

    public final void Pq() {
        Lq(null);
    }

    public final void Rq() {
    }

    public final void Sq() {
    }

    public final void Wq() {
    }

    public final boolean ar() {
        return false;
    }

    public final boolean er() {
        return false;
    }

    public final int getLayoutId() {
        return 2131566888;
    }

    public final void onResume() {
        ((PlayerProgressBarWidget) this).z = true;
        super.onResume();
    }

    public final boolean yq() {
        return true;
    }

    public final long Bq() {
        IRoomContextService r0 = k.f(IRoomContextService.class);
        if (r0 == null) goto L14;
        o r1 = IRoomContextService.a.a(r0, null, 0, 3);
        if (r1 == null) goto L14;
        m r2 = r1.getRoom();
        if (r2 == null) goto L14;
        IRoom r3 = (IRoom) r2.getValue();
        if (r3 == null) goto L14;
        RoomExtra r4 = r3.getExtra();
        if (r4 == null) goto L14;
        return r4.getRealTimePlaybackShiftStart() * ((long) 1000);
    L14:
        return ((Number) this.D.getValue()).longValue();
    }

    public final void cr() {
        LiveProgressBarWidget$seekMethodFactory$1 r0 = this.E;
        if (r0 == null) goto L6;
        bind(k.n(IBaseBrowserService.class).registerExternalMethodFactory(r0).subscribe());
        ALogger.i("VSProgressBarWidget", "seekMethodFactory register");
        return;
    }

    public final void fr() {
        IVisibilityControlBrickService r0 = k.f(IVisibilityControlBrickService.class);
        if (r0 == null) goto L14;
        IVisibilityControlService r1 = r0.provideVisibilityControlService(((Widget) this).dataCenter);
        if (r1 == null) goto L15;
        LiveVisibilityControlContext r2 = r1.provideContext();
        if (r2 == null) goto L16;
        m r3 = r2.getPlayBackAbilityInMsgMutable();
        if (r3 != null) goto L11;
        return;
    L11:
        if (((Boolean) r3.getValue()).booleanValue() != true) goto L18;
        String r4 = rm3.c.a;
        rm3.c.g(((Widget) this).context, Eq(), 0, true, 20);
        return;
    L18:
        return;
    L16:
        return;
    L15:
        return;
    }

    public final void gr() {
        Disposable r0 = ((PlayerProgressBarWidget) this).a;
        Disposable r1 = null;
        if (r0 != null) goto L5;
    L10:
        Observable r2 = Observable.timer(this.C, TimeUnit.SECONDS);
        if (r2 == null) goto L15;
        Observable r3 = r2.observeOn(AndroidSchedulers.mainThread());
        if (r3 == null) goto L15;
        r1 = r3.subscribe(new b(this));
    L15:
        ((PlayerProgressBarWidget) this).a = r1;
        return;
    L5:
        if ((!r0.isDisposed()) == true) goto L8;
        r0 = null;
    L8:
        if (r0 == null) goto L10;
        r0.dispose();
        goto L10
    }

    public final IProgressCastService zq() {
        return k.f(IProgressCastService.class);
    }

    public LiveProgressBarWidget() {
        this.C = 5;
        this.D = LazyKt.lazy(LiveProgressBarWidget$mMaxProgressDuration$2.INSTANCE);
        this.E = new LiveProgressBarWidget$seekMethodFactory$1(this);
    }

    public final String Eq() {
        return s1.B(2131920228);
    }

    public final boolean Uh(LiveVisibilityControl.KEY r2) {
        Intrinsics.checkNotNullParameter(r2, "key");
        IVisibilityControlBrickService r3 = k.f(IVisibilityControlBrickService.class);
        if (r3 == null) goto L9;
        IVisibilityControlService r4 = r3.provideVisibilityControlService(((Widget) this).dataCenter);
        if (r4 == null) goto L9;
        LiveVisibilityControlContext r5 = r4.provideContext();
        if (r5 == null) goto L9;
        return r5.enablePlayBackAbility();
    L9:
        return false;
    }

    public final void Zq(e r2) {
        super.Zq(r2);
        Iq().setAlpha(1.0f);
    }

    public final void onLoad(Object[] r3) {
        ALogger.d("LiveProgressBarTetris", "LiveProgressBarWidget load !!!!!!");
        super.onLoad(r3);
        ((PlayerProgressBarWidget) this).z = true;
    }

    public final com.bytedance.android.livesdk.chatroom.progressbar.a Cq(PlayerProgressServiceContext r9, DataCenter r10, long r11, LifecycleOwner r13) {
        Intrinsics.checkNotNullParameter(r10, "dataCenter");
        Intrinsics.checkNotNullParameter(r13, "owner");
        a r7 = new a(r9, r10);
        s r1 = f.p();
        if (r1 != null) goto L7;
        return null;
    L7:
        return r1.c(r9, r11, r10, r13, r7);
    }
}
