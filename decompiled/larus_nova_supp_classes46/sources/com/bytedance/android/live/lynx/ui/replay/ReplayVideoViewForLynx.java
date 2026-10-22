package com.bytedance.android.live.lynx.ui.replay;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.livehostapi.TTLiveSDK;
import com.bytedance.android.livesdk.chatroom.replay.player.ReplayVideoPlayerHelper;
import com.bytedance.android.livesdkapi.depend.live.vs.VSConstants;
import com.bytedance.android.livesdkapi.depend.model.live.episode.Episode;
import com.bytedance.android.livesdkapi.depend.model.live.episode.EpisodeVideo;
import com.bytedance.android.livesdkapi.depend.model.live.episode.IEpisodeVideoModelContainer;
import com.bytedance.android.livesdkapi.depend.model.live.episode.ReplayPaidInfo;
import com.bytedance.android.livesdkapi.depend.model.live.episode.main.IMainEpisode;
import com.bytedance.android.livesdkapi.replay.IReplayPlayerHelper;
import com.bytedance.android.livesdkapi.replay.ReplayPlayerConfiger;
import com.bytedance.android.livesdkapi.service.vs.IVSHistoryProgressService;
import com.bytedance.android.livesdkapi.vsplayer.ShareVideoData;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import com.lynx.react.bridge.JavaOnlyMap;
import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import jc1.k;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import nic.l;
import nic.p;
import oic.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B'\b\u0007\u0012\u0006\u0010(\u001a\u00020'\u0012\n\b\u0002\u0010*\u001a\u0004\u0018\u00010)\u0012\b\b\u0002\u0010,\u001a\u00020+¢\u0006\u0004\b-\u0010.J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0010\u0010\f\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0019\u0010\u000e\u001a\u00020\u00052\b\u0010\r\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0007H\u0016J0\u0010\u0015\u001a\u00020\u00052&\u0010\u0014\u001a\"\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0012j\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u0002`\u0013H\u0016J\u0010\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\nH\u0016J\u0010\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\nH\u0016J\u0010\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\nH\u0016J\u0010\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u001cH\u0016JN\u0010&\u001a\u00020\u00052D\u0010%\u001a@\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b \u0012\b\b!\u0012\u0004\b\b(\"\u0012\u001f\u0012\u001d\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00020#¢\u0006\f\b \u0012\b\b!\u0012\u0004\b\b($\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u001fH\u0016¨\u0006/"}, d2 = {"Lcom/bytedance/android/live/lynx/ui/replay/ReplayVideoViewForLynx;", "Landroid/widget/FrameLayout;", "", "Lcom/bytedance/android/livesdkapi/depend/model/live/episode/Episode;", "episode", "", "setEpisode", "", "coverUrl", "setPoster", "", "autoPlay", "setAutoPlay", "enable", "setEnableEnterRoom", "(Ljava/lang/Boolean;)V", "objectFit", "setObjectFit", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "logExtra", "setLogExtra", "muted", "setMuted", "autoShowCover", "setAutoShowCover", "repeat", "setRepeat", "", "startPosition", "setStartPosition", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "event", "", "data", "listener", "setEventChangeListener", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "livehybrid-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ReplayVideoViewForLynx extends FrameLayout {
    public IReplayPlayerHelper A;
    public boolean B;
    public Disposable C;
    public long D;
    public final b E;
    public final a F;
    public final String a;
    public final String b;
    public final String c;
    public FrameLayout d;
    public String e;
    public boolean f;
    public Long g;
    public long h;
    public boolean i;
    public boolean j;
    public boolean k;
    public boolean l;
    public boolean m;
    public Episode n;
    public long o;
    public String p;
    public boolean q;
    public boolean r;
    public boolean s;
    public boolean t;
    public boolean u;
    public boolean v;
    public boolean w;
    public HashMap<String, String> x;
    public final List<String> y;
    public Function2<? super String, ? super Map<String, ? extends Object>, Unit> z;

    public static final class a implements IReplayPlayerHelper.IReplayPlayerWrapperListener {
        public final /* synthetic */ ReplayVideoViewForLynx a;

        public final void onVideoPause() {
            IReplayPlayerHelper.IReplayPlayerWrapperListener.DefaultImpls.onVideoPause(this);
        }

        public a(ReplayVideoViewForLynx r1) {
            this.a = r1;
        }

        public final void onPlayStateChanged(int r3) {
            ReplayVideoViewForLynx r0 = this.a;
            String r1 = r0.a;
            if (r3 != 0) goto L5;
            r0.v = false;
            ReplayVideoViewForLynx.f(r0, "stop");
            return;
        L5:
            if (r3 != 1) goto L7;
            r0.v = true;
            return;
        L7:
            if (r3 != 2) goto L15;
            ReplayVideoViewForLynx.f(r0, "pause");
            return;
        }

        public final void onError(int r4, String r5) {
            Intrinsics.checkNotNullParameter(r5, "msg");
            ReplayVideoViewForLynx r6 = this.a;
            String r0 = r6.a;
            r6.getClass();
            r6.e("error", MapsKt.hashMapOf(new Pair[]{TuplesKt.to("error", r5)}));
        }
    }

    public static final class b extends l.a {
        public final /* synthetic */ ReplayVideoViewForLynx a;

        public b(ReplayVideoViewForLynx r1) {
            this.a = r1;
        }

        public final void B(p r1, tic.a r2) {
            ReplayVideoViewForLynx r3 = this.a;
            String r4 = r3.a;
            r3.B = true;
            ReplayVideoViewForLynx.f(r3, "play");
            if (r3.u == true) goto L6;
            r3.b();
        L6:
            if (r3.q == true) goto L8;
            r3.g();
        L8:
            Disposable r5 = r3.C;
            if (r5 == null) goto L12;
            r5.dispose();
            return;
        }

        public final void L(f r1, tic.a r2) {
            ReplayVideoViewForLynx r3 = this.a;
            String r4 = r3.a;
            if (r3.u == true) goto L6;
            r3.b();
        L6:
            if (r3.q == true) goto L9;
            r3.g();
            return;
        }

        public final void W(f r2, tic.a r3) {
            ReplayVideoViewForLynx r4 = this.a;
            String r5 = r4.a;
            if (r4.s == false) goto L7;
            r4.s = false;
            IReplayPlayerHelper r6 = r4.A;
            if (r6 == null) goto L7;
            r6.hideCover(true);
        L7:
            ReplayVideoViewForLynx.f(r4, "play");
            if (r4.u == true) goto L11;
            r4.b();
        L11:
            if (r4.q == true) goto L14;
            r4.g();
            return;
        }

        public final void b(f r3, tic.a r4) {
            ReplayVideoViewForLynx r5 = this.a;
            String r6 = r5.a;
            r5.h = 0;
            r5.i = false;
            r5.u = false;
            r5.j = false;
            ReplayVideoViewForLynx.f(r5, "ended");
        }

        public final void s(f r1, tic.a r2) {
            ReplayVideoViewForLynx r3 = this.a;
            String r4 = r3.a;
            r3.b();
        }

        public final void x(f r1, tic.a r2, boolean r3) {
            ReplayVideoViewForLynx r4 = this.a;
            if (r4.t == false) goto L5;
            r4.c();
            return;
        L5:
            r4.b();
        }

        public final void m(f r1, tic.a r2, int r3, int r4) {
            ReplayVideoViewForLynx r5 = this.a;
            String r6 = r5.a;
            r5.a();
        }

        public final void q(f r4, tic.a r5, int r6, int r7) {
            ReplayVideoViewForLynx r8 = this.a;
            String r9 = r8.a;
            r8.h = r6;
            if (r8.s == false) goto L7;
            r8.s = false;
            IReplayPlayerHelper r10 = r8.A;
            if (r10 == null) goto L7;
            r10.hideCover(true);
        L7:
            r8.e("timeupdate", MapsKt.hashMapOf(new Pair[]{TuplesKt.to("playTime", Integer.valueOf(r6)), TuplesKt.to("totalDuration", Integer.valueOf(r7))}));
        }
    }

    public static final class c implements Runnable {
        public final /* synthetic */ ReplayVideoViewForLynx a;

        public c(ReplayVideoViewForLynx r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            ReplayVideoViewForLynx r0 = this.a;     // Catch: Throwable -> L12
            if (r0.f == false) goto L15;
            r0.f = false;     // Catch: Throwable -> L12
            long r1 = -1;
            Long r3 = -1L;     // Catch: Throwable -> L12
            if (r3 == null) goto L8;
            r1 = r3.longValue();     // Catch: Throwable -> L12
        L8:
            if (r1 < 0) goto L10;
            r0.g = r3;     // Catch: Throwable -> L12
        L10:
            r0.c();     // Catch: Throwable -> L12
            return;
        L15:
            return;
        L12:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L19;
            throw th;
        }
    }

    public ReplayVideoViewForLynx(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public ReplayVideoViewForLynx(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public final void a() {
        if (this.l == true) goto L5;
        return;
    L5:
        if (this.r == false) goto L24;
        IReplayPlayerHelper r0 = this.A;
        if (r0 == null) goto L11;
        if (r0.isPlaying() != true) goto L11;
        return;
    L11:
        if (TextUtils.isEmpty(this.p) == true) goto L16;
        IReplayPlayerHelper r1 = this.A;
        if (r1 == null) goto L15;
        String r4 = this.p;
        Intrinsics.checkNotNull(r4);
        r1.bindCoverUrl(r4, 2131248874, ImageView.ScaleType.CENTER_CROP);
    L15:
        this.r = false;
        this.s = true;
        return;
    L16:
        Episode r2 = this.n;
        if (r2 == null) goto L27;
        IReplayPlayerHelper r3 = this.A;
        if (r3 == null) goto L21;
        Intrinsics.checkNotNull(r2);
        r3.bindCover(r2, 2131248874, ImageView.ScaleType.CENTER_CROP);
    L21:
        this.r = false;
        return;
    L27:
        return;
    }

    public final void b() {
        f(this, "pause");
        this.u = false;
        IReplayPlayerHelper r1 = this.A;
        if (r1 == null) goto L5;
        r1.pause();
    L5:
        setKeepScreenOn(false);
    }

    public final void c() {
        if (this.q == true) goto L6;
        return;
    L6:
        if (this.u == false) goto L8;
        return;
    L8:
        this.u = true;
        Episode r2 = this.n;
        if (r2 == null) goto L73;
        EpisodeVideo r3 = r2.video;
        if (r3 == null) goto L73;
        IEpisodeVideoModelContainer r4 = r3.getPlayInfo();
        if (r4 == null) goto L73;
        String r5 = r4.getJson();
        if (r5 == null) goto L73;
        IReplayPlayerHelper r6 = this.A;
        if (r6 == null) goto L73;
        if (this.i == true) goto L22;
        r6.resume();
    L22:
        if (r6.isPlaying() == true) goto L24;
    L25:
        r6.setTag(this.b, this.c);
        monitor-enter(this);
        Long r7 = this.g;     // Catch: Throwable -> L70
        if (r7 == null) goto L31;
        this.g = null;     // Catch: Throwable -> L70
        long r8 = r7.longValue();     // Catch: Throwable -> L70
    L34:
        monitor-exit(this);
        this.h = r8;
        Episode r9 = this.n;
        if (r9 == null) goto L38;
        long r10 = r9.roomId;
    L39:
        long r11 = this.o;
        this.D = r11;
        Unit r13 = Unit.INSTANCE;
        if (r9 == null) goto L45;
        IBaseUser r12 = r9.getOwner();
        if (r12 == null) goto L45;
        String r14 = r12.getIdString();
        if (r14 == null) goto L45;
    L46:
        String r15 = r14;
        Episode r16 = this.n;
        if (r16 == null) goto L51;
        IMainEpisode r17 = r16.castToOrNull(IMainEpisode.class);
        if (r17 == null) goto L51;
        ReplayPaidInfo r18 = r17.getReplayPaidInfo();
    L52:
        HashMap<String, String> r19 = this.x;
        if (r19 != null) goto L56;
        r19 = new HashMap();
    L56:
        IReplayPlayerHelper.DefaultImpls.play$default(r6, "lynx_view", r5, r8, r10, r11, r15, null, r18, r19, false, 512, null);
        r6.setMute(this.k);
        r6.setLoop(this.m);
        if (this.B == true) goto L65;
        Disposable r20 = this.C;
        if (r20 == null) goto L63;
        Intrinsics.checkNotNull(r20);
        if (r20.isDisposed() == false) goto L65;
    L63:
        this.C = Flowable.timer(3000, TimeUnit.MILLISECONDS).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new d(this));
    L65:
        if (this.i == false) goto L68;
        this.i = false;
    L68:
        if (this.j == false) goto L73;
        this.j = false;
    L51:
        r18 = null;
    L45:
        r14 = "0";
        goto L46
    L38:
        r10 = 0;
        goto L39
    L31:
        if (this.i == false) goto L33;
        r8 = k.n(IVSHistoryProgressService.class).getLocalPlayProgress(this.o);     // Catch: Throwable -> L70
        goto L34
    L33:
        r8 = this.h;     // Catch: Throwable -> L70
    L70:
        th = move-exception;
        throw th;
    L24:
        if (this.D == this.o) goto L65;
    L73:
        setKeepScreenOn(true);
    }

    public final void d() {
        if (this.A != null) goto L5;
        return;
    L5:
        Episode r0 = this.n;
        if (r0 != null) goto L8;
        return;
    L8:
        if (r0.idStr == null) goto L124;
        Bundle r1 = new Bundle();
        r1.putLong("live.intent.extra.ITEM_ID", this.o);
        r1.putInt("live.intent.extra.ITEM_TYPE", 23);
        String r2 = VSConstants.EXTRA_VIDEO_MODEL;
        Episode r3 = this.n;
        qic.d r4 = null;
        if (r3 == null) goto L17;
        EpisodeVideo r5 = r3.video;
        if (r5 == null) goto L17;
        IEpisodeVideoModelContainer r6 = r5.getPlayInfo();
        if (r6 == null) goto L17;
        String r7 = r6.getJson();
    L18:
        r1.putString(r2, r7);
        if (this.v == false) goto L26;
        r1.putBoolean(VSConstants.EXTRA_VS_SHARE_VIEW, true);
        this.j = true;
        this.v = false;
        ShareVideoData r8 = ShareVideoData.INSTANCE;
        IReplayPlayerHelper r9 = this.A;
        if (r9 == null) goto L23;
        r4 = r9.getVideoSnapshotInfo();
    L23:
        r8.setSnapshotInfo(r4);
        IReplayPlayerHelper r10 = this.A;
        if (r10 == null) goto L29;
        r10.setReleaseEnable(false);
    L29:
        r1.putLong("live.intent.extra.EXTRA_USER_ACTION_ENTER_ROOM_START_TIME", System.currentTimeMillis());
        r1.putString("live.intent.extra.EXTRA_USER_ACTION_ENTER_ROOM_TYPE", "type_inner");
        Bundle r11 = new Bundle();
        HashMap<String, String> r12 = this.x;
        if (r12 == null) goto L88;
        Iterator<Map.Entry<String, String>> r13 = r12.entrySet().iterator();
    L33:
        if (r13.hasNext() == false) goto L88;
        Map.Entry<String, String> r14 = r13.next();
        String r15 = r14.getValue();
        if ((r15 instanceof Map) == true) goto L36;
        if ((r15 instanceof Collection) == true) goto L39;
        if ((r15 instanceof Short) == true) goto L42;
        if ((r15 instanceof Integer) == true) goto L49;
        if ((r15 instanceof Long) == true) goto L56;
        if ((r15 instanceof Boolean) == true) goto L63;
        if ((r15 instanceof Float) == true) goto L70;
        if ((r15 instanceof Double) == true) goto L77;
        String r16 = r14.getKey();
        String r17 = r14.getValue();
        if (r17 == null) goto L86;
        String r18 = r17.toString();
        if (r18 == null) goto L86;
    L87:
        r11.putString(r16, r18);
    L86:
        r18 = "";
        goto L87
    L77:
        String r19 = r14.getKey();
        Object r20 = r14.getValue();
        if (r20 == null) goto L81;
        r11.putDouble(r19, ((Double) r20).doubleValue());
        goto L33
    L81:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Double");
    L70:
        String r21 = r14.getKey();
        Object r22 = r14.getValue();
        if (r22 == null) goto L74;
        r11.putFloat(r21, ((Float) r22).floatValue());
        goto L33
    L74:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
    L63:
        String r23 = r14.getKey();
        Object r24 = r14.getValue();
        if (r24 == null) goto L67;
        r11.putBoolean(r23, ((Boolean) r24).booleanValue());
        goto L33
    L67:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
    L56:
        String r25 = r14.getKey();
        Object r26 = r14.getValue();
        if (r26 == null) goto L60;
        r11.putLong(r25, ((Long) r26).longValue());
        goto L33
    L60:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Long");
    L49:
        String r27 = r14.getKey();
        Object r28 = r14.getValue();
        if (r28 == null) goto L53;
        r11.putInt(r27, ((Integer) r28).intValue());
        goto L33
    L53:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    L42:
        String r29 = r14.getKey();
        Object r30 = r14.getValue();
        if (r30 == null) goto L46;
        r11.putShort(r29, ((Short) r30).shortValue());
        goto L33
    L46:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Short");
    L39:
        r11.putString(r14.getKey(), GsonProtectorUtils.toJson(GsonHelper.get(), r14.getValue()));
        goto L33
    L36:
        r11.putString(r14.getKey(), GsonProtectorUtils.toJson(GsonHelper.get(), r14.getValue()));
    L88:
        r1.putBundle(VSConstants.EXTRA_ENTER_LIVE_EXTRA, r11);
        r1.putAll(r11);
        TTLiveSDK.hostService().action().startLive(getContext(), this.o, r1);
        this.i = true;
        return;
    L26:
        r1.putBoolean(VSConstants.EXTRA_VS_SHARE_VIEW, false);
        this.j = false;
        IReplayPlayerHelper r31 = this.A;
        if (r31 == null) goto L29;
        r31.setReleaseEnable(true);
    L17:
        r7 = null;
        goto L18
    }

    public final void g() {
        if (this.i == true) goto L5;
        b();
    L5:
        IReplayPlayerHelper r0 = this.A;
        if (r0 == null) goto L8;
        r0.release();
    L8:
        this.u = false;
        this.r = true;
        FrameLayout r1 = this.d;
        if (r1 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("mVSStreamContainer");
    L11:
        r1.removeAllViews();
        IReplayPlayerHelper r2 = this.A;
        if (r2 == null) goto L14;
        r2.unregisterVideoPlayListener(getContext(), this.E);
    L14:
        IReplayPlayerHelper r3 = this.A;
        if (r3 == null) goto L18;
        r3.removeReplayPlayWrapperListener(getContext(), this.F);
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.q = true;
        a();
        post(new c(this));
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.q = false;
        this.s = true;
    }

    public void setAutoPlay(boolean r6) {
        this.f = r6;
        if (r6 == false) goto L12;
        long r0 = -1;
        Long r7 = -1L;
        if (r7 == null) goto L8;
        r0 = r7.longValue();
    L8:
        if (r0 < 0) goto L10;
        this.g = r7;
    L10:
        c();
        return;
    }

    public void setAutoShowCover(boolean r1) {
        this.l = r1;
    }

    public void setEnableEnterRoom(Boolean r2) {
        this.w = Intrinsics.areEqual(r2, Boolean.TRUE);
    }

    public void setEpisode(Episode r3) {
        Intrinsics.checkNotNullParameter(r3, "episode");
        this.n = r3;
        long r0 = 0;
        if (r3 != null) goto L10;
    L7:
        this.o = r0;
        return;
    L10:
        String r4 = r3.idStr;     // Catch: Exception -> L9
        if (r4 == null) goto L7;
        r0 = CastLongProtector.parseLong(r4);     // Catch: Exception -> L9
        goto L7
    }

    public void setEventChangeListener(Function2<? super String, ? super Map<String, ? extends Object>, Unit> r1) {
        this.z = r1;
    }

    public void setLogExtra(HashMap<String, Object> r5) {
        Intrinsics.checkNotNullParameter(r5, "logExtra");
        HashMap<String, String> r0 = new HashMap();
        Iterator<Map.Entry<String, Object>> r6 = r5.entrySet().iterator();
    L4:
        if (r6.hasNext() == false) goto L12;
        Map.Entry<String, Object> r1 = r6.next();
        if (r1.getValue() == null) goto L4;
        if ((r1.getValue() instanceof JavaOnlyMap) == true) goto L10;
        r0.put(r1.getKey(), String.valueOf(r1.getValue()));
        goto L4
    L10:
        r0.put(r1.getKey(), GsonProtectorUtils.toJson(GsonHelper.get(), r1.getValue()));
        goto L4
    L12:
        this.x = r0;
    }

    public void setMuted(boolean r2) {
        this.k = r2;
        IReplayPlayerHelper r0 = this.A;
        if (r0 == null) goto L6;
        r0.setMute(r2);
        return;
    }

    public void setObjectFit(String r4) {
        Intrinsics.checkNotNullParameter(r4, "objectFit");
        int r2 = 0;
        if (r4.hashCode() == 3143043) goto L6;
    L8:
        boolean r5 = false;
    L9:
        IReplayPlayerHelper r0 = this.A;
        if (r0 == null) goto L17;
        ReplayPlayerConfiger r1 = new ReplayPlayerConfiger();
        if (r5 == false) goto L15;
        r2 = 2;
    L15:
        r1.textureLayout = r2;
        Unit r6 = Unit.INSTANCE;
        r0.setPlayerConfiger(r1);
        return;
    L17:
        return;
    L6:
        if (r4.equals("fill") == false) goto L8;
        r5 = true;
        goto L9
    }

    public void setPoster(String r2) {
        Intrinsics.checkNotNullParameter(r2, "coverUrl");
        this.p = r2;
    }

    public void setRepeat(boolean r2) {
        this.m = r2;
        IReplayPlayerHelper r0 = this.A;
        if (r0 == null) goto L6;
        r0.setLoop(r2);
        return;
    }

    public void setStartPosition(long r1) {
        this.g = Long.valueOf(r1);
    }

    public static /* synthetic */ void f(ReplayVideoViewForLynx r1, String r2) {
        r1.e(r2, new HashMap());
    }

    public final void e(String r2, Map<String, ? extends Object> r3) {
        if ((!TextUtils.equals(this.e, r2)) == false) goto L5;
    L6:
        Objects.toString(r3);
        this.e = r2;
        Function2<? super String, ? super Map<String, ? extends Object>, Unit> r0 = this.z;
        if (r0 == null) goto L11;
        Unit r4 = (Unit) r0.invoke(r2, r3);
        return;
    L11:
        return;
    L5:
        if (this.y.contains(r2) == true) goto L6;
    }

    public ReplayVideoViewForLynx(Context r3, AttributeSet r4, int r5) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3, r4, r5);
        this.a = "VPPlayListener";
        this.b = "vs_long_video";
        this.c = "vs_video_center";
        this.m = true;
        this.r = true;
        this.s = true;
        this.t = true;
        this.y = CollectionsKt.listOf("timeupdate");
        b r6 = new b(this);
        this.E = r6;
        a r7 = new a(this);
        this.F = r7;
        FrameLayout r8 = new FrameLayout(getContext());
        this.d = r8;
        r8.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        addView(r8);
        setOnClickListener(new com.bytedance.android.live.lynx.ui.replay.c(this));
        nm1.l r9 = pm1.f.j();
        if (r9 == null) goto L8;
        FrameLayout r0 = this.d;
        if (r0 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("mVSStreamContainer");
    L7:
        ReplayVideoPlayerHelper r10 = r9.d(r0);
    L9:
        this.A = r10;
        ReplayPlayerConfiger r11 = new ReplayPlayerConfiger();
        r11.textureLayout = 2;
        r11.useSurfaceView = 2;
        IReplayPlayerHelper r1 = this.A;
        if (r1 == null) goto L12;
        r1.setPlayerConfiger(r11);
    L12:
        this.u = false;
        IReplayPlayerHelper r12 = this.A;
        if (r12 == null) goto L15;
        r12.registerVideoPlayListener(getContext(), r6);
    L15:
        IReplayPlayerHelper r13 = this.A;
        if (r13 == null) goto L18;
        r13.setReplayPlayWrapperListener(getContext(), r7);
    L18:
        IReplayPlayerHelper r14 = this.A;
        if (r14 == null) goto L23;
        MutableLiveData r15 = r14.getReplayPaidStatus();
        if (r15 == null) goto L23;
        r15.observeForever(new com.bytedance.android.live.lynx.ui.replay.a(this));
    L23:
        IReplayPlayerHelper r16 = this.A;
        if (r16 == null) goto L29;
        MutableLiveData r17 = r16.getReplayPaidCountDown();
        if (r17 == null) goto L30;
        r17.observeForever(new com.bytedance.android.live.lynx.ui.replay.b(this));
        return;
    L30:
        return;
    L29:
        return;
    L8:
        r10 = null;
        goto L9
    }

    public /* synthetic */ ReplayVideoViewForLynx(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }

    @Override // android.view.View
    public final void onSizeChanged(int r1, int r2, int r3, int r4) {
        super.onSizeChanged(r1, r2, r3, r4);
        a();
    }
}
