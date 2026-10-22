package com.bytedance.android.live.liveinteract.interactivesong.panel;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.interactivesong.impl.InteractiveSongContext;
import com.bytedance.android.live.liveinteract.utils.MultiSceneEnterRoomStatisticsUtils;
import com.bytedance.android.live.pushstream.model.LiveRequestSourceRole;
import com.bytedance.android.livesdk.chatroom.model.interact.IMVBaseInfo;
import com.bytedance.android.livesdk.chatroom.model.interact.IMVUrlStruct;
import com.bytedance.android.livesdk.chatroom.model.interact.IOrderSingMVInfo;
import com.bytedance.android.livesdk.ktvapi.IKtvService;
import com.bytedance.android.livesdk.ktvimpl.mv.opus.OpusServiceImpl;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.util.IMultiSceneCommonStatistics;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.j;
import com.bytedance.live.datacontext.m;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.ugc.aweme.live.alphaplayer.player.AbsPlayer;
import com.ss.android.ugc.aweme.live.alphaplayer.player.IMediaPlayer;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;
import jc1.k;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class InteractiveSongMvManager {
    public final long a;
    public final boolean b;
    public FrameLayout c;
    public TextureView d;
    public View e;
    public IOrderSingMVInfo f;
    public IOrderSingMVInfo g;
    public boolean h;
    public com.bytedance.android.livesdk.ktvapi.model.mv.c i;
    public long j;
    public Disposable k;
    public Disposable l;
    public boolean m;
    public int n;
    public String o;
    public long p;
    public long q;
    public final zd0.e r;
    public long s;
    public long t;
    public Function1<? super Integer, Unit> u;
    public String v;
    public Boolean w;
    public final Context x;
    public DataCenter y;

    public static final class a {
    }

    public static final class b implements TextureView.SurfaceTextureListener {
        public final /* synthetic */ InteractiveSongMvManager a;

        @Override // android.view.TextureView.SurfaceTextureListener
        public final boolean onSurfaceTextureDestroyed(SurfaceTexture r2) {
            Intrinsics.checkNotNullParameter(r2, "surface");
            return true;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public final void onSurfaceTextureSizeChanged(SurfaceTexture r1, int r2, int r3) {
            Intrinsics.checkNotNullParameter(r1, "surface");
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public final void onSurfaceTextureUpdated(SurfaceTexture r2) {
            Intrinsics.checkNotNullParameter(r2, "surface");
        }

        public b(InteractiveSongMvManager r1) {
            this.a = r1;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public final void onSurfaceTextureAvailable(SurfaceTexture r1, int r2, int r3) {
            Intrinsics.checkNotNullParameter(r1, "surface");
            com.bytedance.android.livesdk.ktvapi.model.mv.c r4 = this.a.i;
            if (r4 == null) goto L6;
            r4.c(new Surface(r1));
            return;
        }
    }

    public static final class c<T> implements IMediaPlayer.OnErrorListener {
        public final /* synthetic */ Function1 a;
        public final /* synthetic */ Function0 b;

        public c(Function1 r1, Function0 r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void a(AbsPlayer r1, int r2, int r3, String r4) {
            Function0 r5 = this.b;
            if (r5 == null) goto L6;
            Unit r6 = (Unit) r5.invoke();
            return;
        }
    }

    static {
    }

    public final void f() {
        this.f = null;
        this.g = null;
        m r1 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r1 == null) goto L16;
        IRoom r2 = (IRoom) r1.getValue();
        if (r2 == null) goto L16;
        if (r2.isLiveTypeAudio() != true) goto L16;
        j r3 = com.bytedance.android.live.liveinteract.api.utils.m.i().getLiveStream();
        if (r3 == null) goto L16;
        com.bytedance.android.live.pushstream.d r4 = (com.bytedance.android.live.pushstream.d) r3.getValue();
        if (r4 == null) goto L16;
        r4.Z0(5, new uv0.a(LiveRequestSourceRole.Business, "InteractiveSongMvManager.resetData", null));
        com.bytedance.android.livesdk.ktvapi.model.mv.c r5 = this.i;
        if (r5 == null) goto L16;
        r5.f(false, r4, false);
    L16:
        if (vm2.d.n0() == true) goto L23;
        FrameLayout r6 = this.c;
        if (r6 == null) goto L20;
        r6.setVisibility(8);
    L20:
        View r7 = this.e;
        if (r7 == null) goto L23;
        r7.setVisibility(8);
    L23:
        zd0.e r8 = this.r;
        if (r8 == null) goto L26;
        r8.a = false;
        int r9 = vd0.a.g;
        vd0.a.C0284a.a(r8.b).c();
    L26:
        Disposable r10 = this.k;
        if (r10 == null) goto L29;
        r10.dispose();
    L29:
        Disposable r11 = this.l;
        if (r11 == null) goto L32;
        r11.dispose();
    L32:
        TextureView r12 = this.d;
        if (r12 == null) goto L36;
        r12.setSurfaceTextureListener(null);
        return;
    }

    public final void b() {
        if (this.s != 0) goto L5;
        return;
    L5:
        long r0 = System.currentTimeMillis() - this.s;
        this.t += r0;
        InteractiveSongContext r4 = InteractiveSongContext.Companion.getContext();
        if (r4 == null) goto L8;
        r4.setMvWatchDuration(r4.getMvWatchDuration() + r0);
    L8:
        this.s = 0;
    }

    public final void c() {
        this.o = "";
        com.bytedance.android.livesdk.ktvapi.model.mv.c r0 = this.i;
        if (r0 == null) goto L7;
        com.bytedance.android.livesdk.ktvapi.model.mv.h r1 = r0.a();
        if (r1 == null) goto L7;
        r1.stop();
    L7:
        b();
        InteractiveSongContext r2 = InteractiveSongContext.Companion.getContext();
        if (r2 == null) goto L10;
        r2.setCurHasMvIsPlaying(false);
    L10:
        FrameLayout r3 = this.c;
        if (r3 == null) goto L13;
        r3.setVisibility(8);
    L13:
        zd0.e r4 = this.r;
        if (r4 == null) goto L16;
        r4.a = false;
        int r5 = vd0.a.g;
        vd0.a.C0284a.a(r4.b).c();
    L16:
        DataCenter r6 = this.y;
        if (r6 == null) goto L19;
        r6.put("data_audio_background_load", Boolean.TRUE);
    L19:
        this.m = false;
        Disposable r7 = this.k;
        if (r7 == null) goto L22;
        r7.dispose();
    L22:
        Disposable r8 = this.l;
        if (r8 == null) goto L26;
        r8.dispose();
        return;
    }

    public final void e() {
        f();
        this.c = null;
        String r1 = this.v;
        if (r1 == null) goto L9;
        IInteractService r2 = (IInteractService) k.f(IInteractService.class);
        if (r2 == null) goto L9;
        com.bytedance.android.live.liveinteract.plantform.performance.a r3 = r2.getMultiLinkPerfAbilityManager(false);
        if (r3 == null) goto L9;
        r3.c("multilink_dynamic_bg", r1);
    L9:
        this.v = null;
        com.bytedance.android.livesdk.ktvapi.model.mv.c r4 = this.i;
        if (r4 == null) goto L12;
        r4.release();
    L12:
        this.i = null;
        this.y = null;
    }

    public final Context getContext() {
        return this.x;
    }

    public static final Boolean a(InteractiveSongMvManager r2) {
        if (r2.w != null) goto L11;
        IInteractService r0 = (IInteractService) k.f(IInteractService.class);
        boolean r1 = true;
        if (r0 == null) goto L9;
        com.bytedance.android.live.liveinteract.plantform.performance.a r3 = r0.getMultiLinkPerfAbilityManager(true);
        if (r3 == null) goto L9;
        r1 = r3.a("multilink_dynamic_bg");
    L9:
        r2.w = Boolean.valueOf(r1);
    L11:
        return r2.w;
    }

    public final void h(FrameLayout r5) {
        Intrinsics.checkNotNullParameter(r5, "frameLayout");
        this.c = r5;
        View r6 = new View(this.x);
        r6.setBackgroundColor(s1.h(2131107691));
        r6.setAlpha(0.3f);
        int r1 = 8;
        if (vm2.d.n0() == false) goto L5;
        int r0 = 0;
    L6:
        r6.setVisibility(r0);
        Unit r2 = Unit.INSTANCE;
        this.e = r6;
        this.d = new TextureView(this.x);
        FrameLayout.LayoutParams r7 = new FrameLayout.LayoutParams(-1, -1);
        FrameLayout r3 = this.c;
        if (r3 == null) goto L12;
        r3.removeAllViews();
        r3.addView(this.d, r7);
        r3.addView(this.e, r7);
        if (vm2.d.n0() == false) goto L11;
        r1 = 0;
    L11:
        r3.setVisibility(r1);
    L12:
        TextureView r8 = this.d;
        if (r8 == null) goto L16;
        r8.setSurfaceTextureListener(new b(this));
        return;
    L16:
        return;
    L5:
        r0 = 8;
        goto L6
    }

    public InteractiveSongMvManager(Context r5, DataCenter r6) {
        Intrinsics.checkNotNullParameter(r5, "context");
        this.x = r5;
        this.y = r6;
        this.a = vm2.d.m0().e();
        OpusServiceImpl r1 = null;
        this.b = ((Boolean) vm2.d.H2.getValue(null, vm2.d.a[187(0xbb, float:2.62E-43)])).booleanValue();
        this.o = "";
        com.bytedance.android.livesdk.ktvapi.model.mv.d r7 = k.n(IKtvService.class).createOpusMvService();
        if (r7 == null) goto L7;
        HashMap r0 = new HashMap();
        r0.put(199, 1);
        Unit r2 = Unit.INSTANCE;
        com.bytedance.android.livesdk.ktvimpl.mv.opus.d r8 = r7.a(r0);
        if (r8 == null) goto L7;
        r1 = r8.build(r5);
    L7:
        this.i = r1;
        DataCenter r9 = this.y;
        zd0.e r10 = new zd0.e(r9);
        int r3 = vd0.a.g;
        vd0.a r11 = vd0.a.C0284a.a(r9);
        Intrinsics.checkNotNullParameter(r10, "bgView");
        ((ArrayList) r11.b.a).add(r10);
        Unit r12 = Unit.INSTANCE;
        this.r = r10;
    }

    public final void d(boolean r8, boolean r9) {
        if (r8 == true) goto L4;
    L10:
        int r10 = MultiSceneEnterRoomStatisticsUtils.u;
        MultiSceneEnterRoomStatisticsUtils r1 = MultiSceneEnterRoomStatisticsUtils.a.a(this.y, 0L);
        if (r1 == null) goto L13;
        IMultiSceneCommonStatistics.DefaultImpls.recordSubElementShow$default(r1, "background_Load", 0, 2, null);
    L13:
        FrameLayout r11 = this.c;
        if (r11 == null) goto L16;
        r11.setVisibility(0);
    L16:
        zd0.e r12 = this.r;
        if (r12 == null) goto L19;
        r12.a = true;
        int r2 = vd0.a.g;
        vd0.a.C0284a.a(r12.b).c();
    L19:
        View r13 = this.e;
        if (r13 == null) goto L22;
        r13.setVisibility(0);
    L22:
        com.bytedance.android.livesdk.ktvapi.model.mv.c r14 = this.i;
        if (r14 == null) goto L27;
        com.bytedance.android.livesdk.ktvapi.model.mv.h r15 = r14.a();
        if (r15 == null) goto L27;
        r15.start();
    L27:
        this.s = System.currentTimeMillis();
        InteractiveSongContext r16 = InteractiveSongContext.Companion.getContext();
        if (r16 == null) goto L30;
        r16.setCurHasMvIsPlaying(true);
    L30:
        this.m = true;
        if (r9 == true) goto L40;
        IOrderSingMVInfo r17 = this.f;
        if (r17 != null) goto L35;
    L36:
        Disposable r18 = this.l;
        if (r18 == null) goto L39;
        r18.dispose();
    L39:
        this.l = Observable.interval(this.a, TimeUnit.MILLISECONDS).compose(RxUtil.rxSchedulerHelper()).subscribe(new com.bytedance.android.live.liveinteract.interactivesong.panel.b(this));
        goto L40
    L35:
        if (r17.getMvType() != 1) goto L36;
    L40:
        DataCenter r19 = this.y;
        if (r19 == null) goto L44;
        r19.put("data_audio_background_load", Boolean.FALSE);
        return;
    L44:
        return;
    L4:
        if (this.m == false) goto L10;
        if (this.c == null) goto L10;
        if (this.f == null) goto L10;
    }

    public final boolean g(JSONObject r19, Function1<? super IOrderSingMVInfo, Unit> r20) {
        Intrinsics.checkNotNullParameter(r19, "jsonObj");
        String r4 = "";
        if (Intrinsics.areEqual(this.o, "") == false) goto L5;
        return false;
    L5:
        Object r3 = r19.get("ts");
        String r7 = null;
        if ((r3 instanceof Long) == true) goto L8;
        r3 = null;
    L8:
        Long r5 = (Long) r3;
        if (r5 == null) goto L11;
        long r10 = r5.longValue();
    L12:
        this.p = System.currentTimeMillis();
        Object r6 = r19.get("mv_id");
        if ((r6 instanceof String) == true) goto L15;
        r6 = null;
    L15:
        String r8 = (String) r6;
        if (r8 == null) goto L19;
        r4 = r8;
    L19:
        Object r9 = r19.get("push");
        if ((r9 instanceof Boolean) == true) goto L22;
        r9 = null;
    L22:
        Boolean r11 = (Boolean) r9;
        if (r11 == null) goto L25;
        boolean r12 = r11.booleanValue();
    L26:
        Object r1 = r19.get("offset");
        if ((r1 instanceof Integer) == true) goto L29;
        r1 = null;
    L29:
        Integer r2 = (Integer) r1;
        if (r2 == null) goto L32;
        int r13 = r2.intValue();
    L33:
        int r14 = Math.abs(this.n - r13);
        long r15 = System.currentTimeMillis() - this.q;
        if (this.b == false) goto L52;
        long r16 = r14;
        if (r16 <= vm2.d.m0().a()) goto L40;
        if (r15 <= vm2.d.m0().d()) goto L40;
    L44:
        if (this.j == 0) goto L51;
        long r17 = ((long) ((int) ((System.currentTimeMillis() - r10) + ((long) r13)))) % this.j;
        com.bytedance.android.livesdk.ktvapi.model.mv.c r18 = this.i;
        if (r18 == null) goto L51;
        com.bytedance.android.livesdk.ktvapi.model.mv.h r21 = r18.a();
        if (r21 == null) goto L51;
        r21.seekTo((int) r17);
    L51:
        this.q = System.currentTimeMillis();
    L40:
        if (r16 <= vm2.d.m0().c()) goto L52;
        if (r15 > vm2.d.m0().b()) goto L44;
    L52:
        IOrderSingMVInfo r22 = this.g;
        if (r22 == null) goto L57;
        IMVBaseInfo r23 = r22.getMvBaseInfo();
        if (r23 == null) goto L57;
        String r24 = r23.getVid();
    L59:
        if (Intrinsics.areEqual(r4, r24) == false) goto L69;
        IOrderSingMVInfo r25 = this.g;
        if (r25 == null) goto L69;
        if (r25.getMvType() != 2) goto L69;
        if (this.h == false) goto L69;
        if (r20 == null) goto L68;
        Unit r26 = (Unit) r20.invoke(this.g);
    L68:
        this.h = false;
    L69:
        IOrderSingMVInfo r27 = this.f;
        if (r27 != null) goto L72;
    L93:
        IOrderSingMVInfo r28 = this.f;
        if (r28 != null) goto L96;
    L97:
        if (r12 == false) goto L100;
    L98:
        return true;
    L100:
        return false;
    L96:
        if (r28.getMvType() == 1) goto L98;
    L72:
        if (r27.getMvType() != 2) goto L93;
        if (r4.length() <= 0) goto L76;
        boolean r29 = true;
    L77:
        if (r29 == false) goto L85;
        IOrderSingMVInfo r30 = this.f;
        if (r30 == null) goto L84;
        IMVBaseInfo r31 = r30.getMvBaseInfo();
        if (r31 == null) goto L84;
        r7 = r31.getVid();
    L84:
        if ((!Intrinsics.areEqual(r7, r4)) == false) goto L85;
    L86:
        com.bytedance.android.livesdk.ktvapi.model.mv.c r32 = this.i;
        if (r32 == null) goto L91;
        com.bytedance.android.livesdk.ktvapi.model.mv.h r33 = r32.a();
        if (r33 == null) goto L91;
        r33.pause();
    L91:
        b();
        this.m = false;
        return false;
    L85:
        if (r12 == true) goto L93;
    L76:
        r29 = false;
    L57:
        r24 = null;
        goto L59
    L32:
        r13 = 0;
        goto L33
    L25:
        r12 = false;
        goto L26
    L11:
        r10 = 0;
        goto L12
    }

    public static /* synthetic */ void j(InteractiveSongMvManager r6, IOrderSingMVInfo r7, boolean r8) {
        r6.i(r7, false, r8, null, null);
    }

    public final void i(IOrderSingMVInfo r8, boolean r9, boolean r10, final Function1<? super Long, Unit> r11, final Function0<Unit> r12) {
        b();
        this.g = r8;
        String r0 = "";
        if (r8 == null) goto L8;
        IMVBaseInfo r1 = r8.getMvBaseInfo();
        if (r1 == null) goto L8;
        String r2 = r1.getVid();
        if (r2 == null) goto L8;
    L9:
        this.o = r2;
        boolean r3 = true;
        if (r8 != null) goto L12;
    L13:
        if (r10 == true) goto L22;
        if (r9 == true) goto L22;
        if (r8 != null) goto L18;
    L19:
        if (r10 == true) goto L30;
        this.h = true;
        return;
    L30:
        InteractiveSongContext r13 = InteractiveSongContext.Companion.getContext();
        if (r13 == null) goto L37;
        com.bytedance.live.datacontext.i<Boolean> r14 = r13.isFeed();
        if (r14 == null) goto L37;
        if (((Boolean) r14.getValue()).booleanValue() == true) goto L37;
        final boolean r15 = true;
    L39:
        if (r15 == false) goto L49;
        String r4 = this.v;
        if (r4 != null) goto L48;
        IInteractService r5 = (IInteractService) k.f(IInteractService.class);
        if (r5 == null) goto L47;
        com.bytedance.android.live.liveinteract.plantform.performance.a r6 = r5.getMultiLinkPerfAbilityManager(true);
        if (r6 == null) goto L47;
        r4 = r6.b("multilink_dynamic_bg", new InteractiveSongMvManager$setMvInfo$1(this));
    L47:
        r4 = null;
    L48:
        this.v = r4;
    L49:
        if (r8 == null) goto L57;
        IMVBaseInfo r7 = r8.getMvBaseInfo();
        if (r7 == null) goto L57;
        IMVUrlStruct r16 = r7.getDownloadAddr();
        if (r16 == null) goto L57;
        List r17 = r16.getUrlList();
        if (r17 == null) goto L57;
        int r18 = r17.size();
    L58:
        if (r18 <= 0) goto L73;
        com.bytedance.android.livesdk.ktvapi.model.mv.c r19 = this.i;
        if (r19 == null) goto L73;
        if (r8 == null) goto L72;
        IMVBaseInfo r20 = r8.getMvBaseInfo();
        if (r20 == null) goto L72;
        IMVUrlStruct r21 = r20.getDownloadAddr();
        if (r21 == null) goto L72;
        List r22 = r21.getUrlList();
        if (r22 == null) goto L72;
        String r23 = (String) ListProtector.get(r22, 0);
        if (r23 == null) goto L72;
        r0 = r23;
    L72:
        r19.h(r0);
    L73:
        com.bytedance.android.livesdk.ktvapi.model.mv.c r24 = this.i;
        if (r24 == null) goto L81;
        com.bytedance.android.livesdk.ktvapi.model.mv.h r25 = r24.a();
        if (r25 == null) goto L81;
        this.n = 0;
        r25.l(new InteractiveSongMvManager$setMvInfo$$inlined$apply$lambda$1(this, r15, r11, r12));
        Function1<? super Integer, Unit> r26 = this.u;
        if (r26 == null) goto L80;
        r25.i(r26);
    L80:
        Function1<Integer, Unit> r27 = new InteractiveSongMvManager$setMvInfo$$inlined$apply$lambda$2(this, r15, r11, r12);
        this.u = r27;
        r25.k(r27);
        ((AbsPlayer) r25).e = new c(r11, r12);
        r25.pause();
        this.m = false;
    L81:
        if (r9 == false) goto L83;
        if (r8 == null) goto L83;
    L86:
        d(false, r9);
        if (r9 == false) goto L111;
        m r28 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r28 == null) goto L112;
        IRoom r29 = (IRoom) r28.getValue();
        if (r29 != null) goto L93;
        return;
    L93:
        if (r29.isLiveTypeAudio() != true) goto L114;
        j r30 = com.bytedance.android.live.liveinteract.api.utils.m.i().getLiveStream();
        if (r30 == null) goto L115;
        com.bytedance.android.live.pushstream.d r31 = (com.bytedance.android.live.pushstream.d) r30.getValue();
        if (r31 != null) goto L99;
        return;
    L99:
        if (r8.getMvType() == 2) goto L102;
        r3 = false;
    L102:
        if (r3 == false) goto L104;
        r31.Z0(4, new uv0.a(LiveRequestSourceRole.Business, "InteractiveSongMvManager.openMvBackgroundExtern", null));
    L105:
        com.bytedance.android.livesdk.ktvapi.model.mv.c r32 = this.i;
        if (r32 == null) goto L117;
        r32.f(r3, r31, false);
        return;
    L117:
        return;
    L104:
        r31.Z0(5, new uv0.a(LiveRequestSourceRole.Business, "InteractiveSongMvManager.openMvBackgroundRadio", null));
        goto L105
    L115:
        return;
    L114:
        return;
    L112:
        return;
    L111:
        return;
    L83:
        if (r8 != null) goto L85;
        return;
    L85:
        if (r8.getMvType() == 1) goto L86;
        return;
    L57:
        r18 = 0;
    L37:
        r15 = false;
        goto L39
    L18:
        if (r8.getMvType() == 1) goto L30;
    L22:
        if (r10 == true) goto L29;
        Disposable r110 = this.k;
        if (r110 == null) goto L26;
        r110.dispose();
    L26:
        Disposable r111 = this.l;
        if (r111 == null) goto L29;
        r111.dispose();
    L29:
        this.f = r8;
        goto L30
    L12:
        if (r8.getMvType() == 1) goto L22;
    L8:
        r2 = "";
        goto L9
    }
}
