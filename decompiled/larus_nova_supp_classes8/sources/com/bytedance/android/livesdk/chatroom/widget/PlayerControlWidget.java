package com.bytedance.android.livesdk.chatroom.widget;

import android.view.View;
import androidx.lifecycle.LifecycleOwner;
import com.airbnb.lottie.LottieAnimationView;
import com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.livesdk.chatroom.IRoomContextService;
import com.bytedance.android.livesdk.chatroom.MiddlewareRoomContext;
import com.bytedance.android.livesdk.chatroom.progress.context.PlayerProgressServiceContext;
import com.bytedance.android.livesdk.chatroom.progress.service.IPlayerProgressService;
import com.bytedance.android.livesdk.chatroom.progressbar.IProgressCastService;
import com.bytedance.android.livesdk.chatroom.utils.o3;
import com.bytedance.android.livesdk.chatroom.view.PlayPauseView;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.BubbleId;
import com.bytedance.android.livesdk.r3;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.episode.EpisodeHighLight;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import com.bytedance.android.livesdkapi.roomplayer.IRoomEventHub;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import com.bytedance.ies.sdk.widgets.Widget;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.subjects.PublishSubject;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/widget/PlayerControlWidget;", "Lcom/bytedance/android/live/core/tetris/widgets/LiveRecyclableWidget;", "<init>", "()V", "a", "liveroom-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class PlayerControlWidget extends LiveRecyclableWidget {
    public static final /* synthetic */ int o = 0;
    public PlayPauseView a;
    public LottieAnimationView b;
    public IPlayerProgressService c;
    public PlayerProgressServiceContext d;
    public int e;
    public boolean f;
    public int g;
    public boolean h;
    public CompositeDisposable i;
    public j0 j;
    public com.bytedance.android.livesdk.chatroom.progressbar.b k;
    public IProgressCastService l;
    public com.bytedance.android.livesdk.chatroom.o m;
    public final d n;

    public static final class a {
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ PlayerControlWidget a;

        public b(PlayerControlWidget r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r6) {
            MiddlewareRoomContext r7 = o3.b();
            if (r7 == null) goto L10;
            com.bytedance.live.datacontext.m r8 = r7.getVsInChorusConcert();
            if (r8 == null) goto L10;
            if (((Boolean) r8.getValue()).booleanValue() != true) goto L10;
            com.bytedance.android.live.core.utils.f2.c("您已在合唱中，请保持最新进度", 0);
            return;
        L10:
            PlayerControlWidget r9 = this.a;
            j0 r2 = r9.j;
            if (r2 != null) goto L13;
        L15:
            PlayerControlWidget.Aq(this.a);
            PlayerControlWidget r10 = this.a;
            j0 r3 = r10.j;
            if (r3 == null) goto L18;
            r3.j(((Widget) r10).dataCenter);
        L18:
            PlayerControlWidget r11 = this.a;
            IProgressCastService r4 = r11.l;
            if (r4 == null) goto L37;
            com.bytedance.live.datacontext.m r12 = r4.castScreenMode(((Widget) r11).dataCenter);
            if (r12 == null) goto L37;
            if (((Boolean) r12.getValue()).booleanValue() != true) goto L37;
            if (PlayerControlWidget.yq(this.a) == false) goto L34;
            IProgressCastService r13 = this.a.l;
            if (r13 == null) goto L29;
            r13.pause();
        L29:
            com.bytedance.android.livesdk.chatroom.progressbar.b r14 = this.a.k;
            if (r14 == null) goto L40;
            com.bytedance.live.datacontext.m r15 = r14.c();
            if (r15 == null) goto L40;
            r15.setValue(new mf1.b(false, false));
        L40:
            com.bytedance.android.livesdk.log.j0.l().sendLog("livesdk_pause_play_icon_click", MapsKt.mapOf(TuplesKt.to("vs_pause_icon_status", "pause")), new Object[]{new am2.x(), IRoom.class});
            if (r3.l(((Widget) this.a).context) == false) goto L44;
            r3.q(((Widget) this.a).context, "已暂停");
            return;
        L44:
            return;
        L34:
            IProgressCastService r16 = this.a.l;
            if (r16 == null) goto L40;
            r16.pause();
        L37:
            ILivePlayerClient r17 = PlayerControlWidget.xq(this.a);
            if (r17 == null) goto L40;
            r17.pause();
            goto L40
        L13:
            if (r2.e(((Widget) r9).dataCenter) != true) goto L15;
        }
    }

    public static final class c implements View.OnClickListener {
        public final /* synthetic */ PlayerControlWidget a;

        public c(PlayerControlWidget r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r6) {
            MiddlewareRoomContext r7 = o3.b();
            if (r7 == null) goto L10;
            com.bytedance.live.datacontext.m r8 = r7.getVsInChorusConcert();
            if (r8 == null) goto L10;
            if (((Boolean) r8.getValue()).booleanValue() != true) goto L10;
            com.bytedance.android.live.core.utils.f2.c("您已在合唱中，请保持最新进度", 0);
            return;
        L10:
            PlayerControlWidget r9 = this.a;
            j0 r2 = r9.j;
            if (r2 != null) goto L13;
        L15:
            PlayerControlWidget.Bq(this.a);
            PlayerControlWidget r10 = this.a;
            j0 r3 = r10.j;
            if (r3 == null) goto L18;
            r3.j(((Widget) r10).dataCenter);
        L18:
            PlayerControlWidget r11 = this.a;
            IProgressCastService r4 = r11.l;
            if (r4 == null) goto L27;
            com.bytedance.live.datacontext.m r12 = r4.castScreenMode(((Widget) r11).dataCenter);
            if (r12 == null) goto L27;
            if (((Boolean) r12.getValue()).booleanValue() != true) goto L27;
            IProgressCastService r13 = this.a.l;
            if (r13 == null) goto L28;
            r13.resume();
        L28:
            com.bytedance.android.livesdk.log.j0.l().sendLog("livesdk_pause_play_icon_click", MapsKt.mapOf(TuplesKt.to("vs_pause_icon_status", "play")), new Object[]{new am2.x(), IRoom.class});
            if (r3.l(((Widget) this.a).context) == false) goto L32;
            r3.q(((Widget) this.a).context, "已继续播放");
            return;
        L32:
            return;
        L27:
            PlayerControlWidget.zq(this.a);
            goto L28
        L13:
            if (r2.e(((Widget) r9).dataCenter) != true) goto L15;
        }
    }

    public static final class d implements com.bytedance.android.livesdk.chatroom.vsplayer.api.d {
        public final /* synthetic */ PlayerControlWidget a;

        @Override // com.bytedance.android.livesdk.chatroom.vsplayer.api.d
        public final void C5() {
        }

        @Override // com.bytedance.android.livesdk.chatroom.vsplayer.api.d
        public final void D5() {
        }

        @Override // com.bytedance.android.livesdk.chatroom.vsplayer.api.d
        public final void E5() {
        }

        @Override // com.bytedance.android.livesdk.chatroom.vsplayer.api.d
        public final void G5(boolean r1) {
        }

        @Override // com.bytedance.android.livesdk.chatroom.vsplayer.api.d
        public final void H5() {
        }

        @Override // com.bytedance.android.livesdk.chatroom.vsplayer.api.d
        public final void g5() {
        }

        @Override // com.bytedance.android.livesdk.chatroom.vsplayer.api.d
        public final void onRenderStart() {
        }

        @Override // com.bytedance.android.livesdk.chatroom.vsplayer.api.d
        public final void z() {
        }

        @Override // com.bytedance.android.livesdk.chatroom.vsplayer.api.d
        public final void P1() {
            if (PlayerControlWidget.yq(this.a) == false) goto L5;
            return;
        L5:
            PlayerProgressServiceContext r0 = this.a.d;
            if (r0 == null) goto L8;
            Boolean r1 = r0.isPlaying();
        L10:
            if (Intrinsics.areEqual(r1, Boolean.FALSE) == false) goto L13;
            PlayerControlWidget.Bq(this.a);
            return;
        L13:
            return;
        L8:
            r1 = null;
            goto L10
        }

        @Override // com.bytedance.android.livesdk.chatroom.vsplayer.api.d
        public final void k2() {
            PlayerProgressServiceContext r0 = this.a.d;
            if (r0 == null) goto L6;
            r0.setPlaying(Boolean.TRUE);
        L6:
            if (PlayerControlWidget.yq(this.a) == false) goto L8;
            return;
        L8:
            PlayerControlWidget.wq(this.a, true);
        }

        @Override // com.bytedance.android.livesdk.chatroom.vsplayer.api.d
        public final void l3() {
            PlayerProgressServiceContext r0 = this.a.d;
            if (r0 == null) goto L6;
            r0.setPlaying(Boolean.FALSE);
        L6:
            if (PlayerControlWidget.yq(this.a) == false) goto L8;
            return;
        L8:
            PlayerControlWidget.wq(this.a, false);
        }

        public d(PlayerControlWidget r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.livesdk.chatroom.vsplayer.api.d
        public final void v2(EpisodeHighLight r2) {
            Intrinsics.checkNotNullParameter(r2, "episodeHighLight");
            Intrinsics.checkNotNullParameter(r2, "episodeHighLight");
        }

        @Override // com.bytedance.android.livesdk.chatroom.vsplayer.api.d
        public final void F5(EpisodeHighLight r2, Pair<Integer, Boolean> r3) {
            Intrinsics.checkNotNullParameter(r2, "episodeHighLight");
            Intrinsics.checkNotNullParameter(r3, "pair");
            com.bytedance.android.livesdk.chatroom.vsplayer.api.d.a.a(r2, r3);
        }

        @Override // com.bytedance.android.livesdk.chatroom.vsplayer.api.d
        public final void I5(EpisodeHighLight r2, Pair<Integer, Boolean> r3) {
            Intrinsics.checkNotNullParameter(r2, "episodeHighLight");
            Intrinsics.checkNotNullParameter(r3, "pair");
            com.bytedance.android.livesdk.chatroom.vsplayer.api.d.a.b(r2, r3);
        }
    }

    public static final class e<T> implements Consumer {
        public final /* synthetic */ PlayerControlWidget a;

        public e(PlayerControlWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            PlayerControlWidget r0 = this.a;
            boolean r4 = ((Boolean) r3).booleanValue();
            int r1 = PlayerControlWidget.o;
            r0.Jq(r4, false);
        }
    }

    public static final class f<T> implements Consumer {
        public final /* synthetic */ PlayerControlWidget a;

        public f(PlayerControlWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            Boolean r4 = (Boolean) r3;
            if (PlayerControlWidget.yq(this.a) == false) goto L15;
            PlayerControlWidget r0 = this.a;
            IProgressCastService r1 = r0.l;
            if (r1 == null) goto L16;
            com.bytedance.live.datacontext.m r2 = r1.castScreenMode(((Widget) r0).dataCenter);
            if (r2 != null) goto L9;
            return;
        L9:
            if (((Boolean) r2.getValue()).booleanValue() == true) goto L11;
            return;
        L11:
            if (r4.booleanValue() == false) goto L13;
            ((Widget) this.a).contentView.setVisibility(0);
            return;
        L13:
            ((Widget) this.a).contentView.setVisibility(8);
            return;
        L16:
            return;
        }
    }

    static {
    }

    public abstract j0 Fq();

    public final int getLayoutId() {
        return 2131568025;
    }

    public final void onInit(Object[] r1) {
    }

    private final ILivePlayerClient Eq() {
        j0 r0 = this.j;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getLivePlayerClient();
    }

    private final boolean Gq() {
        IProgressCastService r0 = this.l;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.isByteMatchCasting(((Widget) this).dataCenter) != true) goto L7;
        return true;
    }

    public void onUnload() {
        int r0 = this.g;
        com.bytedance.android.livesdk.chatroom.o r1 = this.m;
        if (r1 == null) goto L10;
        com.bytedance.live.datacontext.m r2 = r1.U1();
        if (r2 == null) goto L10;
        if (r0 != ((Number) r2.getValue()).intValue()) goto L10;
        boolean r3 = false;
    L11:
        this.h = r3;
        IPlayerProgressService r4 = this.c;
        if (r4 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("progressService");
    L14:
        r4.removeProgressChangeListener(this.n);
        this.i.dispose();
        return;
    L10:
        r3 = true;
        goto L11
    }

    public PlayerControlWidget() {
        this.e = 1;
        this.g = 1;
        this.i = new CompositeDisposable();
        this.n = new d(this);
    }

    public final void Iq() {
        ILivePlayerClient r0 = Eq();
        if (r0 == null) goto L20;
        IRoomEventHub r1 = r0.getEventHub();
        if (r1 == null) goto L22;
        ILivePlayerClient r2 = Eq();
        if (r2 == null) goto L21;
        LifecycleOwner r3 = r2.getLifecycleOwner();
        if (r3 != null) goto L13;
        return;
    L13:
        if (Intrinsics.areEqual((Boolean) r1.getPlaying().getValue(), Boolean.TRUE) == false) goto L18;
        IPlayerProgressService r4 = this.c;
        if (r4 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("progressService");
    L17:
        r4.handleProgressListener(PlayerControlWidget$registerPlayerEvent$1.INSTANCE);
    L18:
        r1.getPlaying().observe(r3, new n1(this));
        r1.getStopped().observe(r3, new o1(this));
        r1.getPlayResume().observe(r3, new p1(this));
        return;
    L21:
        return;
    L22:
        return;
    }

    public void onResume() {
        super/*com.bytedance.android.live.core.tetris.widgets.LiveWidget*/.onResume();
        if (this.f == true) goto L10;
        com.bytedance.android.livesdk.chatroom.o r0 = this.m;
        if (r0 == null) goto L11;
        com.bytedance.live.datacontext.j r1 = r0.a2();
        if (r1 == null) goto L12;
        r1.c(new PlayerControlWidget$logShow$1(this));
        return;
    L12:
        return;
    L11:
        return;
    }

    public static final void Aq(PlayerControlWidget r1) {
        PlayPauseView r2 = r1.a;
        if (r2 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("ivPlay");
    L5:
        r2.d();
    }

    public static final void Bq(PlayerControlWidget r1) {
        PlayPauseView r2 = r1.a;
        if (r2 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("ivPlay");
    L5:
        r2.e();
    }

    private final void Cq(boolean r4) {
        this.e--;
        if (r4 == false) goto L32;
        PlayPauseView r5 = this.a;
        if (r5 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("ivPlay");
    L7:
        r3.c(r5, "暂停", true);
        PlayPauseView r6 = this.a;
        if (r6 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("ivPlay");
    L10:
        r6.setOnClickListener(new b(this));
        if (Gq() == false) goto L21;
        PlayPauseView r7 = this.a;
        if (r7 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("ivPlay");
    L16:
        if (r7.getPlayStatus() == true) goto L61;
        PlayPauseView r8 = this.a;
        if (r8 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("ivPlay");
    L20:
        r8.e();
        return;
    L61:
        return;
    L21:
        PlayPauseView r9 = this.a;
        if (r9 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("ivPlay");
    L25:
        if (r9.getPlayStatus() == false) goto L27;
        return;
    L27:
        if (this.e >= 0) goto L64;
        PlayPauseView r10 = this.a;
        if (r10 != null) goto L31;
        Intrinsics.throwUninitializedPropertyAccessException("ivPlay");
    L31:
        r10.e();
        return;
    L64:
        return;
    L32:
        PlayPauseView r11 = this.a;
        if (r11 != null) goto L35;
        Intrinsics.throwUninitializedPropertyAccessException("ivPlay");
    L35:
        r3.c(r11, "播放", true);
        PlayPauseView r12 = this.a;
        if (r12 != null) goto L38;
        Intrinsics.throwUninitializedPropertyAccessException("ivPlay");
    L38:
        r12.setOnClickListener(new c(this));
        if (Gq() == false) goto L49;
        PlayPauseView r13 = this.a;
        if (r13 != null) goto L44;
        Intrinsics.throwUninitializedPropertyAccessException("ivPlay");
    L44:
        if (r13.getPlayStatus() != true) goto L66;
        PlayPauseView r14 = this.a;
        if (r14 != null) goto L48;
        Intrinsics.throwUninitializedPropertyAccessException("ivPlay");
    L48:
        r14.d();
        return;
    L66:
        return;
    L49:
        PlayPauseView r15 = this.a;
        if (r15 != null) goto L53;
        Intrinsics.throwUninitializedPropertyAccessException("ivPlay");
    L53:
        if (r15.getPlayStatus() == true) goto L55;
        return;
    L55:
        if (this.e >= 0) goto L69;
        PlayPauseView r16 = this.a;
        if (r16 != null) goto L59;
        Intrinsics.throwUninitializedPropertyAccessException("ivPlay");
    L59:
        r16.d();
        return;
    }

    public static final /* synthetic */ ILivePlayerClient xq(PlayerControlWidget r0) {
        return r0.Eq();
    }

    public static final /* synthetic */ boolean yq(PlayerControlWidget r0) {
        return r0.Gq();
    }

    public static final void zq(PlayerControlWidget r12) {
        PlayerProgressServiceContext r0 = r12.d;
        if (r0 == null) goto L5;
        long r1 = (((Number) r0.getTotalTime().getValue()).longValue() - ((Number) r0.getCurrentTime().getValue()).longValue()) / ((long) BubbleId.PadCast);
    L6:
        j0 r2 = r12.j;
        if (r2 != null) goto L9;
    L38:
        ILivePlayerClient r3 = r12.Eq();
        if (r3 != null) goto L41;
    L45:
        ILivePlayerClient r13 = r12.Eq();
        if (r13 == null) goto L55;
        r13.resume();
        return;
    L55:
        return;
    L41:
        if (r3.getBufferFull() != true) goto L45;
        ILivePlayerClient r14 = r12.Eq();
        if (r14 == null) goto L53;
        r14.seekBy((int) r1);
        return;
    L53:
        return;
    L9:
        if (r2.d(((Widget) r12).dataCenter) != true) goto L38;
        j0 r4 = r12.j;
        if (r4 == null) goto L31;
        String r7 = r4.c(((Widget) r12).dataCenter);
        if (r7 == null) goto L31;
        j0 r5 = r12.j;
        Long r6 = null;
        if (r5 == null) goto L17;
        NextLiveData<Boolean> r8 = r5.i(((Widget) r12).dataCenter);
    L18:
        j0 r9 = r12.j;
        if (r9 == null) goto L31;
        ILivePlayerClient r10 = r12.Eq();
        Pair[] r11 = new Pair[4];
        String r15 = "0";
        r11[0] = TuplesKt.to("is_preview", "0");
        r11[1] = TuplesKt.to("reason", "click_play_button");
        j0 r16 = r12.j;
        if (r16 != null) goto L23;
    L25:
        r11[2] = TuplesKt.to("view_right", r15);
        com.bytedance.android.livesdk.chatroom.o r17 = r12.m;
        if (r17 == null) goto L30;
        com.bytedance.live.datacontext.m r18 = r17.getCameraId();
        if (r18 == null) goto L30;
        r6 = (Long) r18.getValue();
    L30:
        r11[3] = TuplesKt.to("current_camera_id", String.valueOf(r6));
        r9.a(r10, r7, r8, MapsKt.mutableMapOf(r11), null);
        goto L31
    L23:
        if (r16.g(((Widget) r12).dataCenter) != true) goto L25;
        r15 = "1";
        goto L25
    L17:
        r8 = null;
    L31:
        ILivePlayerClient r19 = r12.Eq();
        if (r19 != null) goto L34;
        return;
    L34:
        if (r19.getBufferFull() != true) goto L50;
        ILivePlayerClient r110 = r12.Eq();
        if (r110 == null) goto L51;
        r110.seekBy((int) r1);
        return;
    L51:
        return;
    L50:
        return;
    L5:
        r1 = 0;
        goto L6
    }

    public void onLoad(Object[] r7) {
        this.i = new CompositeDisposable();
        j0 r8 = Fq();
        this.j = r8;
        Boolean r0 = null;
        if (r8 == null) goto L5;
        IProgressCastService r9 = r8.h();
    L6:
        this.l = r9;
        if (r9 == null) goto L9;
        com.bytedance.android.livesdk.chatroom.progressbar.b r10 = r9.getProgressCastStreamShiftService();
    L10:
        this.k = r10;
        IRoomContextService r11 = jc1.k.f(IRoomContextService.class);
        if (r11 == null) goto L13;
        com.bytedance.android.livesdk.chatroom.o r12 = IRoomContextService.a.a(r11, null, 0, 3);
    L14:
        this.m = r12;
        if (r12 == null) goto L21;
        com.bytedance.live.datacontext.m r13 = r12.U1();
        if (r13 == null) goto L21;
        Integer r14 = (Integer) r13.getValue();
        if (r14 == null) goto L21;
        int r15 = r14.intValue();
    L22:
        this.g = r15;
        this.e = 1;
        boolean r16 = false;
        this.f = false;
        this.a = (PlayPauseView) ((Widget) this).contentView.findViewById(2131378323);
        this.b = ((Widget) this).contentView.findViewById(2131376340);
        if (isScreenPortrait() == false) goto L31;
        PlayPauseView r2 = this.a;
        if (r2 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException("ivPlay");
    L27:
        com.bytedance.android.live.core.utils.a1.p(r2, UtilityKotlinExtentionsKt.i(36));
        PlayPauseView r3 = this.a;
        if (r3 != null) goto L30;
        Intrinsics.throwUninitializedPropertyAccessException("ivPlay");
    L30:
        com.bytedance.android.live.core.utils.a1.k(r3, UtilityKotlinExtentionsKt.i(36));
    L38:
        PlayPauseView r4 = this.a;
        if (r4 != null) goto L41;
        Intrinsics.throwUninitializedPropertyAccessException("ivPlay");
    L41:
        r4.a();
        rk1.a r5 = jc1.k.f(rk1.a.class);
        if (r5 == null) goto L87;
        IPlayerProgressService r6 = r5.M4(((Widget) this).dataCenter);
        if (r6 == null) goto L87;
        this.c = r6;
        PlayerProgressServiceContext r17 = r6.provideContext(((Widget) this).dataCenter);
        this.d = r17;
        if (r17 == null) goto L55;
        ILivePlayerClient r18 = Eq();
        if (r18 != null) goto L51;
    L53:
        boolean r19 = false;
    L54:
        r17.setPlaying(Boolean.valueOf(r19));
        goto L55
    L51:
        if (r18.isPlaying() != true) goto L53;
        r19 = true;
    L55:
        PlayerProgressServiceContext r20 = this.d;
        if (r20 == null) goto L59;
        r0 = r20.isPlaying();
    L59:
        if (Intrinsics.areEqual(r0, Boolean.FALSE) == false) goto L64;
        PlayPauseView r1 = this.a;
        if (r1 != null) goto L63;
        Intrinsics.throwUninitializedPropertyAccessException("ivPlay");
    L63:
        r1.b();
        Cq(false);
    L65:
        IPlayerProgressService r21 = this.c;
        if (r21 != null) goto L68;
        Intrinsics.throwUninitializedPropertyAccessException("progressService");
    L68:
        r21.addProgressChangeListener(this.n);
        j0 r22 = this.j;
        if (r22 == null) goto L73;
        NextLiveData<Boolean> r23 = r22.f(((Widget) this).dataCenter);
        if (r23 == null) goto L73;
        r23.observe(this, new k1(this), true);
    L73:
        j0 r24 = this.j;
        if (r24 == null) goto L78;
        NextLiveData<Boolean> r25 = r24.i(((Widget) this).dataCenter);
        if (r25 == null) goto L78;
        r25.observe(this, new l1(this), true);
    L78:
        PlayerProgressServiceContext r26 = this.d;
        if (r26 == null) goto L87;
        com.bytedance.live.datacontext.k r27 = r26.getPlayOrPauseEvent();
        if (r27 == null) goto L87;
        PublishSubject r28 = r27.onEvent();
        if (r28 == null) goto L87;
        Disposable r29 = r28.subscribe(new m1(this));
        if (r29 == null) goto L87;
        RxUtilKt.c(r29, this.i);
        goto L87
    L64:
        Cq(true);
    L87:
        IProgressCastService r30 = this.l;
        if (r30 == null) goto L117;
        com.bytedance.live.datacontext.m r31 = r30.castScreenMode(((Widget) this).dataCenter);
        if (r31 == null) goto L117;
        if (((Boolean) r31.getValue()).booleanValue() != true) goto L117;
        if (Gq() == false) goto L116;
        com.bytedance.android.livesdk.chatroom.progressbar.b r32 = this.k;
        if (r32 == null) goto L116;
        com.bytedance.live.datacontext.m r33 = r32.d();
        if (r33 == null) goto L116;
        if (((Boolean) r33.getValue()).booleanValue() != true) goto L116;
        com.bytedance.android.livesdk.chatroom.progressbar.b r34 = this.k;
        if (r34 == null) goto L111;
        com.bytedance.live.datacontext.m r35 = r34.b();
        if (r35 == null) goto L111;
        if (((Boolean) r35.getValue()).booleanValue() != true) goto L111;
        PlayPauseView r36 = this.a;
        if (r36 != null) goto L110;
        Intrinsics.throwUninitializedPropertyAccessException("ivPlay");
    L110:
        r36.a();
    L115:
        ((Widget) this).contentView.setVisibility(0);
    L118:
        IProgressCastService r37 = this.l;
        if (r37 == null) goto L125;
        com.bytedance.live.datacontext.m r38 = r37.castScreenMode(((Widget) this).dataCenter);
        if (r38 == null) goto L125;
        Boolean r39 = (Boolean) r38.getValue();
        if (r39 == null) goto L125;
        r16 = r39.booleanValue();
    L125:
        Jq(r16, true);
        IProgressCastService r40 = this.l;
        if (r40 == null) goto L134;
        com.bytedance.live.datacontext.m r41 = r40.castScreenMode(((Widget) this).dataCenter);
        if (r41 == null) goto L134;
        Observable r42 = r41.a();
        if (r42 == null) goto L134;
        Disposable r43 = r42.subscribe(new e(this));
        if (r43 == null) goto L134;
        RxUtilKt.c(r43, this.i);
    L134:
        com.bytedance.android.livesdk.chatroom.progressbar.b r44 = this.k;
        if (r44 == null) goto L143;
        com.bytedance.live.datacontext.m r45 = r44.d();
        if (r45 == null) goto L143;
        Observable r46 = r45.a();
        if (r46 == null) goto L143;
        Disposable r47 = r46.subscribe(new f(this));
        if (r47 == null) goto L143;
        RxUtilKt.c(r47, this.i);
    L143:
        com.bytedance.android.livesdk.chatroom.progressbar.b r48 = this.k;
        if (r48 == null) goto L151;
        com.bytedance.live.datacontext.m r49 = r48.b();
        if (r49 == null) goto L152;
        Disposable r50 = i80.a.a(r49, new AnonymousClass3(this));
        if (r50 == null) goto L153;
        RxUtilKt.c(r50, this.i);
        return;
    L153:
        return;
    L152:
        return;
    L151:
        return;
    L111:
        PlayPauseView r51 = this.a;
        if (r51 != null) goto L114;
        Intrinsics.throwUninitializedPropertyAccessException("ivPlay");
    L114:
        r51.b();
    L116:
        ((Widget) this).contentView.setVisibility(8);
    L117:
        ((Widget) this).contentView.setVisibility(0);
        goto L118
    L31:
        PlayPauseView r52 = this.a;
        if (r52 != null) goto L34;
        Intrinsics.throwUninitializedPropertyAccessException("ivPlay");
    L34:
        com.bytedance.android.live.core.utils.a1.p(r52, UtilityKotlinExtentionsKt.i(40));
        PlayPauseView r53 = this.a;
        if (r53 != null) goto L37;
        Intrinsics.throwUninitializedPropertyAccessException("ivPlay");
    L37:
        com.bytedance.android.live.core.utils.a1.k(r53, UtilityKotlinExtentionsKt.i(40));
    L21:
        r15 = 1;
        goto L22
    L13:
        r12 = null;
        goto L14
    L9:
        r10 = null;
        goto L10
    L5:
        r9 = null;
        goto L6
    }

    public static final /* synthetic */ void wq(PlayerControlWidget r0, boolean r1) {
        r0.Cq(r1);
    }

    public final void Jq(boolean r3, boolean r4) {
        if (r3 == true) goto L5;
        ((Widget) this).contentView.setVisibility(0);
        if (r4 == true) goto L23;
        PlayPauseView r5 = this.a;
        if (r5 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("ivPlay");
    L19:
        r5.a();
        Cq(true);
        return;
    L23:
        return;
    L5:
        if (Gq() == false) goto L13;
        com.bytedance.android.livesdk.chatroom.progressbar.b r6 = this.k;
        if (r6 == null) goto L13;
        com.bytedance.live.datacontext.m r7 = r6.d();
        if (r7 == null) goto L13;
        if (((Boolean) r7.getValue()).booleanValue() != true) goto L13;
        ((Widget) this).contentView.setVisibility(0);
        return;
    L13:
        ((Widget) this).contentView.setVisibility(8);
    }
}
