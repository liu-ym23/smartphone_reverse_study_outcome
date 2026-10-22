package com.bytedance.android.live.liveinteract.plantform.core;

import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import android.view.SurfaceView;
import android.view.TextureView;
import android.view.View;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.feature.api.FeatureType;
import com.bytedance.android.live.feature.api.IFeatureService;
import com.bytedance.android.live.liveinteract.api.MultiLinkOpenSource;
import com.bytedance.android.live.liveinteract.api.fulllink.InteractLinkFullLinkMonitor;
import com.bytedance.android.live.liveinteract.api.fulllink.LinkMonitorData;
import com.bytedance.android.live.liveinteract.api.fulllink.TalkRoomBusinessFullLinkMonitor;
import com.bytedance.android.live.liveinteract.floatwindow.onlinewindow.LinkmicOnlineFloatWindowManager;
import com.bytedance.android.live.liveinteract.revenue.linkroomfight.core.LinkRoomFightContext;
import com.bytedance.android.live.liveinteract.utils.RtcAudioScene;
import com.bytedance.android.live.liveinteract.utils.j1;
import com.bytedance.android.live.liveinteract.utils.l1;
import com.bytedance.android.live.network.annotation.PbRequest;
import com.bytedance.android.live.pushstream.IEffectPerfToolsHelper;
import com.bytedance.android.livehostapi.TTMiddlewareLiveSDK;
import com.bytedance.android.livehostapi.foundation.IMiddleWareHostContext;
import com.bytedance.android.livesdk.b5;
import com.bytedance.android.livesdk.config.dm;
import com.bytedance.android.livesdk.config.hr;
import com.bytedance.android.livesdk.config.is;
import com.bytedance.android.livesdk.config.v60;
import com.bytedance.android.livesdk.live.extension.plugin.api.livepusher.ILiveWrappedLivePusher;
import com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.data.LiveWrappedAudioRoute;
import com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.data.LiveWrappedStreamIndex;
import com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.data.LiveWrappedVideoPixelFormat;
import com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.type.LiveWrappedRoomStateChangeReason;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.util.WeakReferenceWrapper;
import com.bytedance.live.livelink.kmp.api.base.config.InteractMode;
import com.bytedance.live.livelink.kmp.api.base.rtc.Env;
import com.bytedance.live.livelink.kmp.api.core.mixer.MixStreamType;
import com.bytedance.live.livelink.kmp.api.core.rtc.PublicStreamType;
import com.bytedance.live.livelink.kmp.impl.extend.spatialaudio.SpatialAudioManager;
import com.larus.apm.impl.protector.RunnableProtector;
import hh1.v0;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.subjects.PublishSubject;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;
import uf2.b1;
import uf2.m1;
import zf2.s0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Deprecated(message = "使用MultiLinkRtcManager")
public final class RtcManager implements hg6.g, xi0.b, eg6.b, ii6.a {
    public static final /* synthetic */ int M = 0;
    public final Map<String, yb6.j> A;
    public final HashSet<String> B;
    public final HashSet<String> C;
    public Integer D;
    public final PublishSubject<Unit> E;
    public final Lazy F;
    public uf2.x G;
    public Boolean H;
    public final IRoom I;
    public tf0.i J;
    public final u K;
    public final boolean L;
    public ei6.a a;
    public final le0.b b;
    public v c;
    public fg6.a d;
    public final CopyOnWriteArrayList<eg6.c> e;
    public g0 f;
    public final CompositeDisposable g;
    public Disposable h;
    public Disposable i;
    public final Handler j;
    public boolean k;
    public boolean l;
    public boolean m;
    public MixStreamType n;
    public final com.bytedance.android.live.liveinteract.api.utils.f o;
    public boolean p;
    public long q;
    public long r;
    public final Map<String, Long> s;
    public final Map<String, Long> t;
    public long u;
    public gd0.x v;
    public final ii6.a w;
    public v0 x;
    public fi6.a y;
    public Map<String, yb6.j> z;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ RtcManager a;

        public a(RtcManager r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            Unit r3 = (Unit) r2;
            int r4 = RtcManager.M;
            ALogger.w("RtcManager", "invoke client invalidateSei.");
            ei6.a r5 = this.a.a;
            if (r5 == null) goto L8;
            vi6.a r6 = r5.v();
            if (r6 == null) goto L9;
            r6.f();
            return;
        L9:
            return;
        }
    }

    public static final class b<T> implements Consumer {
        public static final b a = null;

        static {
            a = new b();
        }

        public b() {
        }

        public final void accept(Object r2) {
            Throwable r3 = (Throwable) r2;
            int r4 = RtcManager.M;
            ALogger.e("RtcManager", "invoke client invalidateSei error!!");
        }
    }

    public static final class c {
    }

    public static final class d implements Runnable {
        public final /* synthetic */ RtcManager a;
        public final /* synthetic */ int b;
        public final /* synthetic */ long c;
        public final /* synthetic */ Exception d;

        public d(RtcManager r1, int r2, long r3, Exception r5) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r5;
        }

        public final void a() {
            int r0 = this.b;
            String r2 = null;
            if (r0 != (-1)) goto L22;
            Disposable r1 = this.a.h;
            if (r1 == null) goto L7;
            r1.dispose();
        L7:
            int r3 = (int) this.c;
            Exception r4 = this.d;
            if (r4 == null) goto L10;
            String r5 = r4.getMessage();
        L11:
            InteractLinkFullLinkMonitor.d0(r3, r5);
            long r6 = this.c;
            Exception r7 = this.d;
            if (r7 == null) goto L14;
            String r8 = r7.getMessage();
        L15:
            com.bytedance.android.live.liveinteract.plantform.utils.x.n0(r6, r8, this.a.J);
            long r9 = this.c;
            Exception r10 = this.d;
            if (r10 == null) goto L18;
            r2 = r10.getMessage();
        L18:
            com.bytedance.android.live.liveinteract.api.utils.n.J(r9, r2);
            v r11 = this.a.c;
            if (r11 == null) goto L69;
            r11.R(this.c, this.d);
            return;
        L69:
            return;
        L14:
            r8 = null;
            goto L15
        L10:
            r5 = null;
            goto L11
        L22:
            if (r0 != (-2)) goto L38;
            Disposable r12 = this.a.i;
            if (r12 == null) goto L26;
            r12.dispose();
        L26:
            long r13 = this.c;
            Exception r14 = this.d;
            if (r14 == null) goto L29;
            String r15 = r14.getMessage();
        L30:
            InteractLinkFullLinkMonitor.i0(r13, r15);
            long r16 = this.c;
            Exception r17 = this.d;
            if (r17 == null) goto L33;
            r2 = r17.getMessage();
        L33:
            com.bytedance.android.live.liveinteract.plantform.utils.x.d0(r16, r2, this.a.J);
            v r18 = this.a.c;
            if (r18 == null) goto L36;
            r18.G9(this.c, this.d);
        L36:
            this.a.p = false;
            return;
        L29:
            r15 = null;
            goto L30
        L38:
            if (r0 != (-3)) goto L72;
            int r19 = (int) this.c;
            Exception r20 = this.d;
            if (r20 == null) goto L42;
            String r21 = r20.getMessage();
        L43:
            InteractLinkFullLinkMonitor.P(r19, r21);
            long r22 = this.c;
            Exception r23 = this.d;
            if (r23 == null) goto L46;
            String r24 = r23.getMessage();
        L47:
            com.bytedance.android.live.liveinteract.plantform.utils.x.f0(r22, r24, this.a.J);
            long r25 = this.c;
            Exception r26 = this.d;
            if (r26 == null) goto L50;
            r2 = r26.getMessage();
        L50:
            com.bytedance.android.live.liveinteract.api.utils.n.G(r25, r2);
            if (this.c != LiveWrappedRoomStateChangeReason.KICKED_OUT.value()) goto L65;
            TalkRoomBusinessFullLinkMonitor r27 = TalkRoomBusinessFullLinkMonitor.a;
            int r28 = (int) this.c;
            boolean r29 = vm2.j.a();
            Exception r30 = this.d;
            r27.getClass();
            TalkRoomBusinessFullLinkMonitor.S(r28, "kick_out_by_open_api", r29, r30);
            ALogger.e("ttlive_link", "link_online_float_window, handleRTCOpenApiKickOutEvent, code = " + this.c + ", exception = " + this.d);
            if (vm2.j.a() == false) goto L65;
            le0.b r31 = this.a.b;
            if (r31 != null) goto L57;
        L64:
            this.a.M0();
            this.a.onDestroy();
            goto L65
        L57:
            if (le0.b.d() == false) goto L61;
            com.bytedance.android.live.pushstream.d r32 = r31.a;
            if (r32 == null) goto L64;
            r32.G0();
            goto L64
        L61:
            uf2.d0 r33 = r31.b;
            if (r33 == null) goto L64;
            r33.release();
        L65:
            v r34 = this.a.c;
            if (r34 == null) goto L73;
            r34.f0(this.c, this.d);
            return;
        L73:
            return;
        L46:
            r24 = null;
            goto L47
        L42:
            r21 = null;
            goto L43
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class e implements Runnable {
        public final /* synthetic */ RtcManager a;
        public final /* synthetic */ int b;
        public final /* synthetic */ Object[] c;
        public final /* synthetic */ long d;

        public e(RtcManager r1, int r2, Object[] r3, long r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }

        public final void a() {
            int r0 = this.b;
            if (r0 != 1) goto L5;
            v r1 = this.a.c;
            if (r1 == null) goto L649;
            r1.o0(this.d);
            Unit r2 = Unit.INSTANCE;
            return;
        L649:
            return;
        L5:
            if (r0 == 2) goto L566;
            Object r6 = null;
            Object r7 = null;
            Object r8 = null;
            Object r9 = null;
            Object r10 = null;
            Object r11 = null;
            Object r12 = null;
            Object r13 = null;
            Object r14 = null;
            Object r15 = null;
            Object r16 = null;
            Object r17 = null;
            String r18 = null;
            Object r19 = null;
            Object r20 = null;
            Object r21 = null;
            if (r0 != 19) goto L9;
            Object[] r3 = this.c;
            Object r4 = r3[0];
            if ((r4 instanceof String) == false) goto L553;
            r6 = r4;
        L553:
            String r22 = (String) r6;
            if (r22 == null) goto L644;
            Object r5 = r3[1];
            if (r5 == null) goto L565;
            int r23 = ((Integer) r5).intValue();
            Object r24 = this.c[2];
            if (r24 == null) goto L563;
            int r25 = ((Integer) r24).intValue();
            v r26 = this.a.c;
            if (r26 == null) goto L645;
            r26.S(r22, r23, r25);
            Unit r27 = Unit.INSTANCE;
            return;
        L645:
            return;
        L563:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
        L565:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
        L644:
            return;
        L9:
            if (r0 != 105) goto L11;
            Iterator<eg6.c> r28 = this.a.e.iterator();
        L547:
            if (r28.hasNext() == false) goto L653;
            r28.next().j(1);
            goto L547
        L653:
            return;
        L11:
            if (r0 != 202) goto L13;
            fg6.a r29 = this.a.d;
            if (r29 == null) goto L642;
            Object[] r30 = this.c;
            Object r31 = r30[0];
            if (r31 == null) goto L544;
            String r32 = (String) r31;
            Object r33 = r30[1];
            if (r33 == null) goto L542;
            r29.a(r32, (String) r33);
            Unit r34 = Unit.INSTANCE;
            return;
        L542:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        L544:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        L642:
            return;
        L13:
            if (r0 == 204) goto L523;
            long r35 = Long.MAX_VALUE;
            switch(r0) {
                case 4: goto L320;
                case 5: goto L305;
                case 6: goto L298;
                case 7: goto L272;
                case 8: goto L232;
                case 9: goto L205;
                case 10: goto L198;
                case 11: goto L21;
                default: goto L16;
            };
        L16:
            switch(r0) {
                case 14: goto L411;
                case 15: goto L382;
                case 16: goto L353;
                default: goto L18;
            };
        L353:
            Object r36 = this.c[0];
            if ((r36 instanceof String) == true) goto L356;
            r36 = null;
        L356:
            String r37 = (String) r36;
            if (r37 == null) goto L367;
            tf0.i r38 = this.a.D0();
            Object r39 = this.c[1];
            if ((r39 instanceof Boolean) == true) goto L361;
            r39 = null;
        L361:
            com.bytedance.android.live.liveinteract.plantform.utils.x.k0(r37, r38, (Boolean) r39);
            v r40 = RtcManager.n0(this.a);
            if (r40 == null) goto L367;
            Object r41 = this.c[1];
            if ((r41 instanceof Boolean) == true) goto L366;
            r41 = null;
        L366:
            r40.g(r37, (Boolean) r41);
            Unit r42 = Unit.INSTANCE;
        L367:
            Object[] r43 = this.c;
            Object r44 = r43[0];
            if ((r44 instanceof String) == true) goto L370;
            r44 = null;
        L370:
            String r45 = (String) r44;
            Object r46 = r43[1];
            if ((r46 instanceof Boolean) == false) goto L374;
            r10 = r46;
        L374:
            Boolean r47 = (Boolean) r10;
            if (r45 == null) goto L618;
            if (r47 == null) goto L619;
            boolean r48 = r47.booleanValue();
            Iterator r49 = RtcManager.m0(this.a).iterator();
        L379:
            if (r49.hasNext() == false) goto L381;
            ((eg6.c) r49.next()).k(r45, r48);
            goto L379
        L381:
            Unit r50 = Unit.INSTANCE;
            return;
        L619:
            return;
        L618:
            return;
        L382:
            Object r51 = this.c[0];
            if ((r51 instanceof String) == true) goto L385;
            r51 = null;
        L385:
            String r52 = (String) r51;
            if (r52 == null) goto L396;
            tf0.i r53 = this.a.D0();
            Object r54 = this.c[1];
            if ((r54 instanceof Boolean) == true) goto L390;
            r54 = null;
        L390:
            com.bytedance.android.live.liveinteract.plantform.utils.x.l0(r52, r53, (Boolean) r54);
            v r55 = RtcManager.n0(this.a);
            if (r55 == null) goto L396;
            Object r56 = this.c[1];
            if ((r56 instanceof Boolean) == true) goto L395;
            r56 = null;
        L395:
            r55.A(r52, (Boolean) r56);
            Unit r57 = Unit.INSTANCE;
        L396:
            Object[] r58 = this.c;
            Object r59 = r58[0];
            if ((r59 instanceof String) == true) goto L399;
            r59 = null;
        L399:
            String r60 = (String) r59;
            Object r61 = r58[1];
            if ((r61 instanceof Boolean) == false) goto L403;
            r11 = r61;
        L403:
            Boolean r62 = (Boolean) r11;
            if (r60 == null) goto L621;
            if (r62 == null) goto L622;
            boolean r63 = r62.booleanValue();
            Iterator r65 = RtcManager.m0(this.a).iterator();
        L408:
            if (r65.hasNext() == false) goto L410;
            ((eg6.c) r65.next()).c(r60, r63);
            goto L408
        L410:
            Unit r66 = Unit.INSTANCE;
            return;
        L622:
            return;
        L621:
            return;
        L411:
            Object r67 = this.c[0];
            if (r67 == null) goto L417;
            RtcManager.B0(this.a);
            String r68 = r67.toString();
            Long r69 = (Long) ((LinkedHashMap) RtcManager.r0(this.a)).get(r67.toString());
            if (r69 == null) goto L416;
            r35 = r69.longValue();
        L416:
            InteractLinkFullLinkMonitor.N(r68, je0.d.b(r35));
            Unit r70 = Unit.INSTANCE;
        L417:
            Object[] r71 = this.c;
            if (r71.length <= 5) goto L428;
            Object r72 = r71[4];
            if (r72 == null) goto L427;
            int r73 = ((Integer) r72).intValue();
            Object r74 = this.c[5];
            if (r74 == null) goto L425;
            int r75 = ((Integer) r74).intValue();
        L429:
            Object r76 = this.c[1];
            if ((r76 instanceof SurfaceView) == false) goto L442;
            v r77 = RtcManager.n0(this.a);
            if (r77 == null) goto L624;
            Object[] r78 = this.c;
            Object r79 = r78[0];
            if ((r79 instanceof String) == true) goto L436;
            r79 = null;
        L436:
            String r80 = (String) r79;
            Object r81 = r78[1];
            if ((r81 instanceof SurfaceView) == false) goto L440;
            r12 = r81;
        L440:
            r77.y0(r80, (SurfaceView) r12, r73, r75);
            Unit r82 = Unit.INSTANCE;
            return;
        L624:
            return;
        L442:
            if ((r76 instanceof TextureView) == false) goto L453;
            v r83 = RtcManager.n0(this.a);
            if (r83 == null) goto L626;
            Object[] r84 = this.c;
            Object r85 = r84[0];
            if ((r85 instanceof String) == true) goto L448;
            r85 = null;
        L448:
            String r86 = (String) r85;
            Object r87 = r84[1];
            if ((r87 instanceof TextureView) == false) goto L452;
            r13 = r87;
        L452:
            r83.j0(r86, (TextureView) r13, r73, r75);
            Unit r88 = Unit.INSTANCE;
            return;
        L626:
            return;
        L453:
            ILiveWrappedLivePusher.Companion.getClass();
            ILiveWrappedLivePusher r89 = ILiveWrappedLivePusher.a.b();
            if (r89 == null) goto L456;
            uf2.z.a r90 = r89.buildLayerControlLayer(this.c[1]);
        L457:
            v r91 = RtcManager.n0(this.a);
            if (r91 == null) goto L628;
            Object r92 = this.c[0];
            if ((r92 instanceof String) == false) goto L463;
            r14 = r92;
        L463:
            r91.V4((String) r14, r90);
            Unit r93 = Unit.INSTANCE;
            return;
        L628:
            return;
        L456:
            r90 = null;
            goto L457
        L425:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
        L427:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
        L428:
            r73 = 0;
            r75 = 0;
            goto L429
        L18:
            switch(r0) {
                case 301: goto L466;
                case 302: goto L465;
                case 303: goto L464;
                default: goto L19;
            };
        L19:
            switch(r0) {
                case 501: goto L522;
                case 502: goto L511;
                case 503: goto L484;
                case 504: goto L474;
                case 505: goto L467;
                default: goto L650;
            };
        L467:
            int r94 = RtcManager.M;
            ALogger.d(LinkRoomFightContext.TAG, "on push public stream first audio frame " + this.c[0]);
            v r95 = RtcManager.n0(this.a);
            if (r95 == null) goto L633;
            Object r96 = this.c[0];
            if ((r96 instanceof String) == false) goto L473;
            r7 = r96;
        L473:
            r95.wf((String) r7);
            Unit r97 = Unit.INSTANCE;
            return;
        L633:
            return;
        L474:
            int r98 = RtcManager.M;
            ALogger.d(LinkRoomFightContext.TAG, "on push public stream first video frame decode " + this.c[0] + ' ' + this.c[1]);
            v r99 = RtcManager.n0(this.a);
            if (r99 == null) goto L635;
            Object[] r100 = this.c;
            Object r101 = r100[0];
            if ((r101 instanceof String) == true) goto L479;
            r101 = null;
        L479:
            String r102 = (String) r101;
            Object r103 = r100[1];
            if ((r103 instanceof s0) == false) goto L483;
            r8 = r103;
        L483:
            r99.T6(r102, (s0) r8);
            Unit r104 = Unit.INSTANCE;
            return;
        L635:
            return;
        L484:
            v r105 = RtcManager.n0(this.a);
            if (r105 == null) goto L497;
            Object[] r106 = this.c;
            Object r107 = r106[0];
            if ((r107 instanceof String) == true) goto L489;
            r107 = null;
        L489:
            String r108 = (String) r107;
            Object r109 = r106[1];
            if ((r109 instanceof ByteBuffer) == true) goto L492;
            r109 = null;
        L492:
            ByteBuffer r110 = (ByteBuffer) r109;
            Object r111 = r106[2];
            if (r111 == null) goto L496;
            r105.D1(r108, r110, ((Integer) r111).intValue());
            Unit r112 = Unit.INSTANCE;
            goto L497
        L496:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
        L497:
            Iterator r113 = RtcManager.m0(this.a).iterator();
        L499:
            if (r113.hasNext() == false) goto L651;
            eg6.c r114 = (eg6.c) r113.next();
            Object[] r115 = this.c;
            Object r116 = r115[0];
            if ((r116 instanceof String) == true) goto L503;
            r116 = null;
        L503:
            String r117 = (String) r116;
            Object r118 = r115[1];
            if ((r118 instanceof ByteBuffer) == true) goto L506;
            r118 = null;
        L506:
            ByteBuffer r119 = (ByteBuffer) r118;
            Object r120 = r115[2];
            if (r120 == null) goto L510;
            r114.g(r119, ((Integer) r120).intValue());
            goto L499
        L510:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
        L651:
            return;
        L511:
            int r121 = RtcManager.M;
            ALogger.d(LinkRoomFightContext.TAG, "on play public stream result " + this.c[0] + ' ' + this.c[1]);
            v r122 = RtcManager.n0(this.a);
            if (r122 == null) goto L637;
            Object[] r123 = this.c;
            Object r124 = r123[0];
            if ((r124 instanceof String) == false) goto L517;
            r9 = r124;
        L517:
            String r125 = (String) r9;
            Object r126 = r123[1];
            if (r126 == null) goto L521;
            r122.al(r125, ((Integer) r126).intValue());
            Unit r127 = Unit.INSTANCE;
            return;
        L521:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
        L637:
            return;
        L522:
            int r128 = RtcManager.M;
            ALogger.d(LinkRoomFightContext.TAG, "on push public stream result " + this.c[0] + ' ' + this.c[1]);
            return;
        L650:
            return;
        L464:
            RtcManager.z0(this.a, false);
            RtcManager.A0(this.a);
            InteractLinkFullLinkMonitor.a0(String.valueOf(this.c[0]), String.valueOf(this.c[1]));
            zi0.a r129 = zi0.a.a;
            Object[] r130 = this.c;
            zi0.a.b(r130[0], r130[1]);
            ALogger.d(LinkRoomFightContext.TAG, "on cross room rtc info " + this.c[0] + ' ' + this.c[1]);
            String.valueOf(this.c[0]);
            String.valueOf(this.c[1]);
            return;
        L465:
            RtcManager.z0(this.a, true);
            Object[] r131 = this.c;
            InteractLinkFullLinkMonitor.b0(r131[0], r131[1], je0.d.b(RtcManager.t0(this.a)));
            zi0.a r132 = zi0.a.a;
            Object[] r133 = this.c;
            zi0.a.b(r133[0], r133[1]);
            ALogger.d(LinkRoomFightContext.TAG, "on cross room rtc info " + this.c[0] + ' ' + this.c[1]);
            String.valueOf(this.c[0]);
            String.valueOf(this.c[1]);
            return;
        L466:
            RtcManager.z0(this.a, false);
            zi0.a r134 = zi0.a.a;
            Object[] r135 = this.c;
            zi0.a.b(r135[0], r135[1]);
            ALogger.d(LinkRoomFightContext.TAG, "on cross room rtc info " + this.c[0] + ' ' + this.c[1]);
            String.valueOf(this.c[0]);
            String.valueOf(this.c[1]);
            return;
        L21:
            ILiveWrappedLivePusher.Companion.getClass();
            ILiveWrappedLivePusher r136 = ILiveWrappedLivePusher.a.b();
            if (r136 == null) goto L24;
            uf2.z.a r137 = r136.buildLayerControlLayer(this.c[1]);
        L25:
            Object[] r138 = this.c;
            Object r139 = r138[0];
            if (r139 == null) goto L37;
            Object r140 = r138[1];
            if ((r140 instanceof SurfaceView) == false) goto L31;
            String r141 = "SurfaceView";
        L36:
            RtcManager.r0(this.a).put(r139.toString(), Long.valueOf(System.currentTimeMillis()));
            InteractLinkFullLinkMonitor.M(r139.toString());
            com.bytedance.android.live.liveinteract.plantform.utils.x.h0(r139.toString(), this.a.D0(), RtcManager.u0(this.a), r141);
            RtcManager.B0(this.a);
            Unit r142 = Unit.INSTANCE;
            goto L37
        L31:
            if ((r140 instanceof TextureView) == false) goto L33;
            r141 = "TextureView";
            goto L36
        L33:
            if (r137 == null) goto L35;
            r141 = "layer";
            goto L36
        L35:
            r141 = "null";
        L37:
            Object[] r143 = this.c;
            if (r143.length <= 4) goto L48;
            Object r144 = r143[3];
            if (r144 == null) goto L47;
            int r145 = ((Integer) r144).intValue();
            Object r146 = this.c[4];
            if (r146 == null) goto L45;
            int r147 = ((Integer) r146).intValue();
        L49:
            Object r148 = this.c[1];
            if ((r148 instanceof SurfaceView) == false) goto L111;
            Map r149 = RtcManager.l0(this.a);
            Object[] r150 = this.c;
            Object r151 = r150[0];
            if (r151 == null) goto L109;
            String r152 = (String) r151;
            Object r153 = r150[1];
            if (r153 == null) goto L107;
            r149.put(r152, new yb6.j((SurfaceView) r153, r145, r147));
            Map r154 = RtcManager.i0(this.a);
            Object[] r155 = this.c;
            Object r156 = r155[0];
            if (r156 == null) goto L105;
            String r157 = (String) r156;
            Object r158 = r155[1];
            if (r158 == null) goto L103;
            r154.put(r157, new yb6.j((SurfaceView) r158, r145, r147));
            if (((Boolean) is.a.getValue()).booleanValue() == true) goto L62;
            v r159 = RtcManager.n0(this.a);
            if (r159 == null) goto L84;
            Object[] r160 = this.c;
            Object r161 = r160[0];
            if ((r161 instanceof String) == true) goto L80;
            r161 = null;
        L80:
            String r162 = (String) r161;
            Object r163 = r160[1];
            if ((r163 instanceof SurfaceView) == true) goto L83;
            r163 = null;
        L83:
            r159.h1(r162, (SurfaceView) r163, r145, r147);
            Unit r164 = Unit.INSTANCE;
        L84:
            g0 r165 = RtcManager.k0(this.a);
            if (r165 == null) goto L87;
            r165.onFirstRemoteVideoSend();
            Unit r166 = Unit.INSTANCE;
        L87:
            Object[] r167 = this.c;
            Object r168 = r167[0];
            if ((r168 instanceof String) == true) goto L90;
            r168 = null;
        L90:
            String r169 = (String) r168;
            Object r170 = r167[1];
            if ((r170 instanceof SurfaceView) == false) goto L94;
            r15 = r170;
        L94:
            SurfaceView r171 = (SurfaceView) r15;
            if (r169 == null) goto L594;
            if (r171 == null) goto L595;
            Iterator r172 = RtcManager.m0(this.a).iterator();
        L99:
            if (r172.hasNext() == false) goto L101;
            ((eg6.c) r172.next()).f(r169, r171);
            goto L99
        L101:
            Unit r173 = Unit.INSTANCE;
            return;
        L595:
            return;
        L594:
            return;
        L62:
            if (RtcManager.x0(this.a) == true) goto L87;
            v r174 = RtcManager.n0(this.a);
            if (r174 == null) goto L72;
            Object[] r175 = this.c;
            Object r176 = r175[0];
            if ((r176 instanceof String) == true) goto L68;
            r176 = null;
        L68:
            String r177 = (String) r176;
            Object r178 = r175[1];
            if ((r178 instanceof SurfaceView) == true) goto L71;
            r178 = null;
        L71:
            r174.h1(r177, (SurfaceView) r178, r145, r147);
            Unit r179 = Unit.INSTANCE;
        L72:
            g0 r180 = RtcManager.k0(this.a);
            if (r180 == null) goto L87;
            r180.onFirstRemoteVideoSend();
            Unit r181 = Unit.INSTANCE;
            goto L87
        L103:
            throw new NullPointerException("null cannot be cast to non-null type android.view.SurfaceView");
        L105:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        L107:
            throw new NullPointerException("null cannot be cast to non-null type android.view.SurfaceView");
        L109:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        L111:
            if ((r148 instanceof TextureView) == false) goto L158;
            Map r182 = RtcManager.l0(this.a);
            Object[] r183 = this.c;
            Object r184 = r183[0];
            if (r184 == null) goto L157;
            String r185 = (String) r184;
            Object r186 = r183[1];
            if (r186 == null) goto L155;
            r182.put(r185, new yb6.j((TextureView) r186, r145, r147));
            Map r187 = RtcManager.i0(this.a);
            Object[] r188 = this.c;
            Object r189 = r188[0];
            if (r189 == null) goto L153;
            String r190 = (String) r189;
            Object r191 = r188[1];
            if (r191 == null) goto L151;
            r187.put(r190, new yb6.j((TextureView) r191, r145, r147));
            if (((Boolean) is.a.getValue()).booleanValue() == true) goto L123;
            v r192 = RtcManager.n0(this.a);
            if (r192 == null) goto L147;
            Object[] r193 = this.c;
            Object r194 = r193[0];
            if ((r194 instanceof String) == true) goto L142;
            r194 = null;
        L142:
            String r195 = (String) r194;
            Object r196 = r193[1];
            if ((r196 instanceof TextureView) == false) goto L146;
            r17 = r196;
        L146:
            r192.L0(r195, (TextureView) r17, r145, r147);
            Unit r197 = Unit.INSTANCE;
        L147:
            g0 r198 = RtcManager.k0(this.a);
            if (r198 == null) goto L600;
            r198.onFirstRemoteVideoSend();
            Unit r199 = Unit.INSTANCE;
            return;
        L600:
            return;
        L123:
            if (RtcManager.x0(this.a) == true) goto L597;
            v r200 = RtcManager.n0(this.a);
            if (r200 == null) goto L134;
            Object[] r201 = this.c;
            Object r202 = r201[0];
            if ((r202 instanceof String) == true) goto L129;
            r202 = null;
        L129:
            String r203 = (String) r202;
            Object r204 = r201[1];
            if ((r204 instanceof TextureView) == false) goto L133;
            r16 = r204;
        L133:
            r200.L0(r203, (TextureView) r16, r145, r147);
            Unit r205 = Unit.INSTANCE;
        L134:
            g0 r206 = RtcManager.k0(this.a);
            if (r206 == null) goto L598;
            r206.onFirstRemoteVideoSend();
            Unit r207 = Unit.INSTANCE;
            return;
        L598:
            return;
        L597:
            return;
        L151:
            throw new NullPointerException("null cannot be cast to non-null type android.view.TextureView");
        L153:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        L155:
            throw new NullPointerException("null cannot be cast to non-null type android.view.TextureView");
        L157:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        L158:
            if (r137 == null) goto L602;
            Map r208 = RtcManager.l0(this.a);
            Object r209 = this.c[0];
            if (r209 == null) goto L197;
            r208.put((String) r209, new yb6.j(r137, r145, r147));
            Map r210 = RtcManager.i0(this.a);
            Object r211 = this.c[0];
            if (r211 == null) goto L195;
            r210.put((String) r211, new yb6.j(r137, r145, r147));
            if (((Boolean) is.a.getValue()).booleanValue() == true) goto L166;
            v r212 = RtcManager.n0(this.a);
            if (r212 == null) goto L182;
            Object r213 = this.c[0];
            if ((r213 instanceof String) == true) goto L181;
            r213 = null;
        L181:
            r212.b4((String) r213, r137, r145, r147);
            Unit r214 = Unit.INSTANCE;
        L182:
            g0 r215 = RtcManager.k0(this.a);
            if (r215 == null) goto L185;
            r215.onFirstRemoteVideoSend();
            Unit r216 = Unit.INSTANCE;
        L185:
            Iterator r217 = RtcManager.m0(this.a).iterator();
        L187:
            if (r217.hasNext() == false) goto L652;
            eg6.c r218 = (eg6.c) r217.next();
            Object r219 = this.c[0];
            if ((r219 instanceof String) == true) goto L191;
            r219 = null;
        L191:
            String r220 = (String) r219;
            if (r220 == null) goto L187;
            r218.b(r220);
            Unit r221 = Unit.INSTANCE;
            goto L187
        L652:
            return;
        L166:
            if (RtcManager.x0(this.a) == true) goto L185;
            v r222 = RtcManager.n0(this.a);
            if (r222 == null) goto L173;
            Object r223 = this.c[0];
            if ((r223 instanceof String) == true) goto L172;
            r223 = null;
        L172:
            r222.b4((String) r223, r137, r145, r147);
            Unit r224 = Unit.INSTANCE;
        L173:
            g0 r225 = RtcManager.k0(this.a);
            if (r225 == null) goto L185;
            r225.onFirstRemoteVideoSend();
            Unit r226 = Unit.INSTANCE;
            goto L185
        L195:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        L197:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        L602:
            return;
        L45:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
        L47:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
        L48:
            r145 = 0;
            r147 = 0;
            goto L49
        L24:
            r137 = null;
            goto L25
        L198:
            Object r227 = this.c[0];
            if (r227 == null) goto L201;
            r18 = r227.toString();
        L201:
            if (r18 == null) goto L603;
            InteractLinkFullLinkMonitor.L(r18);
            com.bytedance.android.live.liveinteract.plantform.utils.x.g0(r18, this.a.D0(), RtcManager.u0(this.a));
            com.bytedance.android.live.liveinteract.api.utils.n.H(r18, RtcManager.u0(this.a));
            RtcManager.B0(this.a);
            v r228 = RtcManager.n0(this.a);
            if (r228 == null) goto L604;
            r228.L(r18);
            Unit r229 = Unit.INSTANCE;
            return;
        L604:
            return;
        L603:
            return;
        L205:
            v r230 = this.a.c;
            if (r230 == null) goto L217;
            Object[] r231 = this.c;
            Object r232 = r231[0];
            if ((r232 instanceof String[]) == true) goto L210;
            r232 = null;
        L210:
            String[] r233 = (String[]) r232;
            Object r234 = r231[1];
            if ((r234 instanceof boolean[]) == true) goto L213;
            r234 = null;
        L213:
            boolean[] r235 = (boolean[]) r234;
            Object r236 = r231[2];
            if ((r236 instanceof int[]) == true) goto L216;
            r236 = null;
        L216:
            r230.J(r233, r235, (int[]) r236);
            Unit r237 = Unit.INSTANCE;
        L217:
            Object[] r238 = this.c;
            Object r239 = r238[0];
            if ((r239 instanceof String[]) == true) goto L220;
            r239 = null;
        L220:
            String[] r240 = (String[]) r239;
            Object r241 = r238[1];
            if ((r241 instanceof boolean[]) == false) goto L224;
            r19 = r241;
        L224:
            boolean[] r242 = (boolean[]) r19;
            if (r240 == null) goto L606;
            if (r242 == null) goto L607;
            Iterator r243 = RtcManager.m0(this.a).iterator();
        L229:
            if (r243.hasNext() == false) goto L231;
            ((eg6.c) r243.next()).onTalkStateUpdated(r240, r242);
            goto L229
        L231:
            Unit r244 = Unit.INSTANCE;
            return;
        L607:
            return;
        L606:
            return;
        L232:
            Object r245 = this.c[0];
            if (r245 == null) goto L238;
            com.bytedance.android.live.liveinteract.plantform.utils.x.q0(r245.toString(), this.a.D0());
            String r246 = r245.toString();
            Long r247 = (Long) ((LinkedHashMap) RtcManager.s0(this.a)).get(r245.toString());
            if (r247 == null) goto L237;
            r35 = r247.longValue();
        L237:
            InteractLinkFullLinkMonitor.R(r246, je0.d.b(r35));
            Unit r248 = Unit.INSTANCE;
        L238:
            Map r249 = RtcManager.l0(this.a);
            Object r250 = this.c[0];
            if (r250 == null) goto L271;
            r249.remove((String) r250);
            Map r251 = RtcManager.i0(this.a);
            Object r252 = this.c[0];
            if (r252 == null) goto L269;
            r251.remove((String) r252);
            v r253 = RtcManager.n0(this.a);
            if (r253 == null) goto L249;
            Object r254 = this.c[0];
            if (r254 == null) goto L248;
            r253.e1((String) r254, this.d);
            Unit r255 = Unit.INSTANCE;
            goto L249
        L248:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        L249:
            HashSet r256 = RtcManager.p0(this.a);
            Object r257 = this.c[0];
            if (r257 == null) goto L267;
            r256.remove((String) r257);
            HashSet r258 = RtcManager.q0(this.a);
            Object r259 = this.c[0];
            if (r259 == null) goto L265;
            r258.remove((String) r259);
            Object r260 = this.c[0];
            if ((r260 instanceof String) == false) goto L257;
            r20 = r260;
        L257:
            String r261 = (String) r20;
            if (r261 == null) goto L609;
            Iterator r262 = RtcManager.m0(this.a).iterator();
        L261:
            if (r262.hasNext() == false) goto L263;
            ((eg6.c) r262.next()).l(r261);
            goto L261
        L263:
            Unit r263 = Unit.INSTANCE;
            return;
        L609:
            return;
        L265:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        L267:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        L269:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        L271:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        L272:
            Object r264 = this.c[0];
            if (r264 == null) goto L275;
            RtcManager.s0(this.a).put(r264.toString(), Long.valueOf(System.currentTimeMillis()));
            com.bytedance.android.live.liveinteract.plantform.utils.x.p0(r264.toString(), this.a.D0());
            InteractLinkFullLinkMonitor.Q(r264.toString());
            Unit r265 = Unit.INSTANCE;
        L275:
            v r266 = RtcManager.n0(this.a);
            if (r266 == null) goto L282;
            Object r267 = this.c[0];
            if (r267 == null) goto L281;
            r266.onUserJoined((String) r267);
            Unit r268 = Unit.INSTANCE;
            goto L282
        L281:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        L282:
            Object r269 = this.c[0];
            if ((r269 instanceof String) == false) goto L286;
            r21 = r269;
        L286:
            String r270 = (String) r21;
            if (r270 != null) goto L289;
            return;
        L289:
            if (vm2.d.N() == true) goto L291;
        L293:
            Iterator r271 = RtcManager.m0(this.a).iterator();
        L295:
            if (r271.hasNext() == false) goto L297;
            ((eg6.c) r271.next()).p(r270);
            goto L295
        L297:
            Unit r272 = Unit.INSTANCE;
            return;
        L291:
            if ((!Intrinsics.areEqual(r270, tc0.c.h().f)) == false) goto L293;
            hg6.g.a.a(this.a, r270);
            this.a.G0(r270, false);
            goto L293
        L298:
            v r273 = this.a.c;
            if (r273 == null) goto L613;
            Object r274 = this.c[0];
            if (r274 == null) goto L304;
            r273.wk((String) r274);
            Unit r275 = Unit.INSTANCE;
            return;
        L304:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        L613:
            return;
        L305:
            ei6.a r276 = this.a.a;
            if (r276 == null) goto L310;
            gi6.e r277 = r276.getEventManager();
            if (r277 == null) goto L310;
            r277.b(null);
            Unit r278 = Unit.INSTANCE;
        L310:
            RtcManager r279 = this.a;
            r279.a = null;
            r279.l = false;
            r279.p = false;
            InteractLinkFullLinkMonitor.j0(je0.d.b(RtcManager.v0(r279)));
            com.bytedance.android.live.liveinteract.plantform.utils.x.e0(this.a.D0(), RtcManager.v0(this.a));
            RtcManager.C0(this.a);
            RtcManager.y0(this.a);
            RtcManager.z0(this.a, false);
            Disposable r280 = RtcManager.o0(this.a);
            if (r280 == null) goto L313;
            r280.dispose();
            Unit r281 = Unit.INSTANCE;
        L313:
            Iterator r282 = RtcManager.m0(this.a).iterator();
        L315:
            if (r282.hasNext() == false) goto L317;
            ((eg6.c) r282.next()).o();
            goto L315
        L317:
            v r283 = RtcManager.n0(this.a);
            if (r283 == null) goto L615;
            r283.M1();
            Unit r284 = Unit.INSTANCE;
            return;
        L615:
            return;
        L320:
            InteractLinkFullLinkMonitor.e0(System.currentTimeMillis() - this.a.q);
            RtcManager r285 = this.a;
            com.bytedance.android.live.liveinteract.plantform.utils.x.o0(r285.J, r285.q, false);
            Disposable r286 = this.a.h;
            if (r286 == null) goto L323;
            r286.dispose();
            Unit r287 = Unit.INSTANCE;
        L323:
            RtcManager r288 = this.a;
            if (r288.p == false) goto L326;
        L351:
            ALogger.w("ttlive_multi_advance_link", "rtc start succeed when engine is stopping or stopped,ignore");
            return;
        L326:
            if (RtcManager.j0(r288) == null) goto L351;
            this.a.d0(true);
            if (((Boolean) is.a.getValue()).booleanValue() == false) goto L343;
            ALogger.i("ttlive_multi_advance_link", "rtc join channel success isAdvanceStart " + RtcManager.x0(this.a));
            if (RtcManager.x0(this.a) == true) goto L339;
            InteractLinkFullLinkMonitor.E(null, 15);
            v r289 = RtcManager.n0(this.a);
            if (r289 == null) goto L335;
            r289.o();
            Unit r290 = Unit.INSTANCE;
        L335:
            Iterator r291 = RtcManager.m0(this.a).iterator();
        L337:
            if (r291.hasNext() == false) goto L350;
            ((eg6.c) r291.next()).i(this.a.D0().getInteractId());
        L350:
            RtcManager.w0(this.a);
            return;
        L339:
            InteractLinkFullLinkMonitor.z();
            if (hd0.c.f().h() == false) goto L342;
            this.a.H0();
            goto L350
        L342:
            ALogger.w("ttlive_multi_advance_link", "wait server finish join");
            goto L350
        L343:
            InteractLinkFullLinkMonitor.E(null, 15);
            v r292 = RtcManager.n0(this.a);
            if (r292 == null) goto L346;
            r292.o();
            Unit r293 = Unit.INSTANCE;
        L346:
            Iterator r294 = RtcManager.m0(this.a).iterator();
        L348:
            if (r294.hasNext() == false) goto L350;
            ((eg6.c) r294.next()).i(this.a.D0().getInteractId());
            goto L348
        L523:
            fg6.a r295 = this.a.d;
            if (r295 == null) goto L640;
            Object[] r296 = this.c;
            Object r297 = r296[0];
            if (r297 == null) goto L533;
            String r298 = (String) r297;
            Object r299 = r296[1];
            if (r299 == null) goto L531;
            r295.J3(r298, (String) r299);
            Unit r300 = Unit.INSTANCE;
            return;
        L531:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        L533:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        L640:
            return;
        L566:
            v r301 = this.a.c;
            if (r301 == null) goto L647;
            long r302 = this.d;
            Object r303 = this.c[0];
            if (r303 == null) goto L572;
            r301.f1(r302, ((Integer) r303).intValue());
            Unit r304 = Unit.INSTANCE;
            return;
        L572:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class f implements uf2.h0.b {
        public f(RtcManager r1) {
        }
    }

    public static final class g implements uf2.h0.c {
        public g(RtcManager r1) {
        }
    }

    public static final class h<T> implements Consumer {
        public final /* synthetic */ RtcManager a;

        public h(RtcManager r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            Long r5 = (Long) r4;
            tc0.c r6 = tc0.c.h();
            int r0 = com.bytedance.android.live.liveinteract.plantform.utils.x.a;
            Intrinsics.checkNotNullParameter(r6, "dataHolder");
            HashMap r1 = new HashMap();
            com.bytedance.android.live.liveinteract.plantform.utils.x.a(r1);
            com.bytedance.android.live.liveinteract.api.utils.g.n("rtc_stop_time_out", r1, r6, true);
            InteractLinkFullLinkMonitor.i0(-12302, "rtc_stop_time_out");
            this.a.p = false;
        }
    }

    static {
    }

    public final boolean A() {
        return false;
    }

    public final void D1(String r1, ByteBuffer r2, int r3) {
    }

    public final fg6.b F() {
        return null;
    }

    public final void I(int r1) {
    }

    public final int L() {
        return 0;
    }

    public final void M0() {
        this.l = false;
        this.k = false;
        InteractLinkFullLinkMonitor.h0();
        tf0.i r1 = this.J;
        int r2 = com.bytedance.android.live.liveinteract.plantform.utils.x.a;
        Intrinsics.checkNotNullParameter(r1, "dataHolder");
        com.bytedance.android.live.liveinteract.plantform.utils.x.u0("rtc_turn_off", new HashMap(), r1);
        u r3 = this.K;
        if (r3 == null) goto L6;
        r3.l8();
    L6:
        if (this.a != null) goto L8;
        InteractLinkFullLinkMonitor.m0("stopEngine");
    L8:
        StringBuilder r4 = new StringBuilder("engine is stoping, fall back to stop play public stream ");
        com.bytedance.android.live.liveinteract.plantform.model.e0 r5 = tc0.c.h().s;
        if (r5 == null) goto L11;
        String r6 = r5.getRivalsStreamId();
    L12:
        r4.append(r6);
        ALogger.i(LinkRoomFightContext.TAG, r4.toString());
        com.bytedance.android.live.liveinteract.plantform.model.e0 r7 = tc0.c.h().s;
        if (r7 == null) goto L17;
        String r8 = r7.getRivalsStreamId();
        if (r8 == null) goto L17;
        k(r8);
    L17:
        n1(false);
        ei6.a r9 = this.a;
        if (r9 == null) goto L22;
        si6.b r10 = r9.b();
        if (r10 == null) goto L22;
        si6.a.b(r10, false, "rtcmanger stop engine", 3);
    L22:
        I0();
        this.p = true;
        this.u = System.currentTimeMillis();
        Disposable r0 = this.i;
        if (r0 == null) goto L25;
        r0.dispose();
    L25:
        this.i = Observable.timer(10, TimeUnit.SECONDS).subscribe(new h(this));
        com.bytedance.android.live.liveinteract.api.utils.f r11 = this.o;
        ei6.a r12 = r11.a;
        if (r12 != null) goto L28;
    L30:
        Disposable r13 = this.h;
        if (r13 == null) goto L33;
        r13.dispose();
    L33:
        ((LinkedHashMap) this.z).clear();
        ((LinkedHashMap) this.A).clear();
        HashSet<String> r14 = this.B;
        if (r14 == null) goto L36;
        r14.clear();
    L36:
        this.C.clear();
        return;
    L28:
        if (r12.r() == null) goto L30;
        r11.a.r().s1();
        goto L30
    L11:
        r6 = null;
        goto L12
    }

    public final xi0.b O() {
        return this;
    }

    public final ec6.b R() {
        return null;
    }

    public final void T() {
    }

    public final void c0(String r1) {
    }

    public final void f4() {
    }

    public final void g0(long r1) {
    }

    @Override // xi0.b
    public final void h() {
    }

    public final yb6.e j() {
        return null;
    }

    public final void n() {
    }

    public final ji6.c o() {
        return null;
    }

    public final String t() {
        return "";
    }

    public final String u() {
        return "";
    }

    public final void w(boolean r1) {
    }

    public final ig6.a x() {
        return null;
    }

    public final int y() {
        return 0;
    }

    public final void H0() {
        ALogger.i("ttlive_multi_advance_link", "advance link success");
        K0(false);
        String r1 = tc0.c.h().m;
        String r2 = null;
        if (r1 != null) goto L5;
    L10:
        String r3 = tc0.c.h().k;
        if (r3 != null) goto L13;
    L17:
        ei6.a r4 = this.a;
        if (r4 == null) goto L22;
        si6.b r5 = r4.b();
        if (r5 == null) goto L22;
        r5.j();
    L22:
        ALogger.i("ttlive_multi_advance_link", "start push data");
        InteractLinkFullLinkMonitor.E("link_opt_v1", 13);
        ALogger.i("ttlive_multi_advance_link", "notify link success");
        this.j.post(new h0(this));
        return;
    L13:
        if ((!StringsKt.isBlank(r3)) == false) goto L15;
        r2 = r3;
    L15:
        if (r2 == null) goto L17;
        c(r2);
        goto L17
    L5:
        if ((!StringsKt.isBlank(r1)) == true) goto L8;
        r1 = null;
    L8:
        if (r1 == null) goto L10;
        J(r1);
        goto L10
    }

    public final void I0() {
        if (this.L == false) goto L16;
        v0 r0 = this.x;
        if (r0 == null) goto L7;
        com.bytedance.android.live.pushstream.d r1 = r0.getLiveStream();
    L9:
        if (vm2.f.a() == false) goto L12;
        if (r1 == null) goto L12;
        r1.I();
        return;
    L12:
        le0.b r2 = this.b;
        if (r2 == null) goto L18;
        r2.M();
        return;
    L18:
        return;
    L7:
        r1 = null;
        goto L9
    }

    public final void K() {
        Integer r0 = this.D;
        if (r0 == null) goto L25;
        r0.intValue();
        ILiveWrappedLivePusher.Companion.getClass();
        ILiveWrappedLivePusher r1 = ILiveWrappedLivePusher.a.b();
        if (r1 == null) goto L7;
        b1 r2 = r1.newTEBundle();
    L8:
        if (r2 == null) goto L10;
        r2.b();
    L10:
        le0.b r3 = this.b;
        if (r3 != null) goto L13;
    L22:
        if (r2 == null) goto L26;
        r2.release();
        return;
    L26:
        return;
    L13:
        if (le0.b.d() == false) goto L19;
        com.bytedance.android.live.pushstream.d r4 = r3.a;
        if (r4 == null) goto L22;
        uf2.d0 r5 = r4.A();
        if (r5 == null) goto L22;
        r5.S();
        goto L22
    L19:
        uf2.d0 r6 = r3.b;
        if (r6 == null) goto L22;
        r6.S();
        goto L22
    L7:
        r2 = null;
        goto L8
    }

    @Override // xi0.b
    public final void N() {
        ei6.a r0 = this.a;
        if (r0 == null) goto L7;
        fi6.a r1 = r0.g();
        if (r1 == null) goto L7;
        MixStreamType r2 = r1.U;
    L8:
        zi0.a r3 = zi0.a.a;
        MixStreamType r4 = MixStreamType.SERVER_MIX;
        JSONObject r5 = new JSONObject();
        r5.put("from_type", r2);
        r5.put("to_type", r4);
        zi0.a.a(r5);
        zi0.a.e(r3, "switch_mix_type", r5);
        if (r2 == r4) goto L16;
        ALogger.d(LinkRoomFightContext.TAG, "now is " + r2 + ", try switch to server mix，one way switch!!");
        ei6.a r6 = this.a;
        if (r6 == null) goto L17;
        ti6.d r7 = r6.p();
        if (r7 == null) goto L18;
        r7.m(r4);
        return;
    L18:
        return;
    L17:
        return;
    L16:
        return;
    L7:
        r2 = null;
        goto L8
    }

    public final void S() {
        ei6.a r0 = this.a;
        if (r0 == null) goto L9;
        xi6.c r1 = r0.t();
        if (r1 == null) goto L9;
        com.bytedance.live.livelink.kmp.impl.core.video.b r2 = r1.f();
        if (r2 == null) goto L9;
        r2.e(true);
    L9:
        Iterator<eg6.c> r3 = this.e.iterator();
    L11:
        if (r3.hasNext() == false) goto L13;
        r3.next().j(2);
        goto L11
    L13:
        int r4 = com.bytedance.android.live.liveinteract.plantform.utils.x.a;
        com.bytedance.android.live.liveinteract.plantform.utils.x.i0(this.J, null);
    }

    public final void U() {
        if (((Boolean) v60.a.getValue()).booleanValue() == true) goto L5;
        return;
    L5:
        ei6.a r0 = this.a;
        if (r0 == null) goto L10;
        fi6.a r1 = r0.g();
        if (r1 == null) goto L10;
        MixStreamType r2 = r1.U;
    L11:
        InteractLinkFullLinkMonitor.l0(r2, this.n);
        ALogger.d(LinkRoomFightContext.TAG, "#PublicStreamMix# tryRecoverMixType current mix type is " + r2 + ", before link room fight is " + this.n);
        MixStreamType r3 = this.n;
        if (r2 == r3) goto L23;
        if (r3 == null) goto L24;
        ALogger.d(LinkRoomFightContext.TAG, "current mix type is " + r2 + ", before link room fight is " + this.n + ", recover to it");
        MixStreamType r4 = this.n;
        if (r4 == null) goto L21;
        ei6.a r5 = this.a;
        if (r5 == null) goto L21;
        ti6.d r6 = r5.p();
        if (r6 == null) goto L21;
        r6.m(r4);
    L21:
        this.n = null;
        return;
    L24:
        return;
    L23:
        return;
    L10:
        r2 = null;
        goto L11
    }

    public final int b() {
        ei6.a r0 = this.a;
        if (r0 == null) goto L9;
        ri6.b r1 = r0.r();
        if (r1 == null) goto L9;
        LiveWrappedAudioRoute r2 = r1.b();
        if (r2 == null) goto L9;
        return r2.value();
    L9:
        return -1;
    }

    public final dg6.a e() {
        gd0.x r0 = this.v;
        if (r0 != null) goto L7;
        return null;
    L7:
        return pg6.a.a(r0);
    }

    public final void f() {
        if (((Boolean) vm2.d.Z3.getValue(null, vm2.d.a[257(0x101, float:3.6E-43)])).booleanValue() == false) goto L5;
        this.E.onNext(Unit.INSTANCE);
        return;
    L5:
        ei6.a r0 = this.a;
        if (r0 == null) goto L12;
        vi6.a r1 = r0.v();
        if (r1 == null) goto L13;
        r1.f();
        return;
    L13:
        return;
    }

    public final fi6.a getInteractConfig() {
        fi6.a r0 = new fi6.a();
        r0.h(TTMiddlewareLiveSDK.getContext());
        r0.m(this.J.getRtcInfo());
        r0.S = 5;
        String r1 = s1.B(2131922659);
        Intrinsics.checkNotNullParameter(r1, "key");
        r0.w = r1;
        String r2 = jc1.k.n(IMiddleWareHostContext.class).getChannel();
        Intrinsics.checkNotNullParameter(r2, "channel");
        r0.y = r2;
        r0.c(String.valueOf(jc1.k.n(IMiddleWareHostContext.class).appId()));
        r0.e(jc1.k.n(IMiddleWareHostContext.class).getVersionCode());
        r0.d(String.valueOf(jc1.k.n(IMiddleWareHostContext.class).getUpdateVersionCode()));
        if (jc1.k.n(IMiddleWareHostContext.class).isBoe() == false) goto L6;
        r0.l(Env.ENV_BOE);
    L6:
        if (((Boolean) b5.a.getValue()).booleanValue() == false) goto L9;
        r0.l(Env.ENV_TEST);
    L9:
        if (this.L == false) goto L17;
        MixStreamType r3 = MixStreamType.SERVER_MIX;
        r0.j(r3);
        if (((Boolean) hr.a.getValue()).booleanValue() == false) goto L17;
        Boolean r4 = (Boolean) dm.a.getValue();
        r0.W = false;
        if (r4.booleanValue() == false) goto L15;
        r3 = MixStreamType.RTC_CLIENT_MIX;
    L15:
        r0.j(r3);
    L17:
        if (vm2.e.n() == false) goto L19;
        r0.j = 1;
    L19:
        ((Number) vm2.d.Y3.getValue(null, vm2.d.a[256(0x100, float:3.59E-43)])).intValue();
        r0.k(j1.a());
        if (je0.d.U() == false) goto L22;
        r0.Z = true;
        com.bytedance.android.live.liveinteract.plantform.utils.x.O(true);
    L23:
        return r0;
    L22:
        com.bytedance.android.live.liveinteract.plantform.utils.x.O(false);
        goto L23
    }

    public final MixStreamType getMixStreamType() {
        fi6.a r0 = this.y;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.U;
    }

    public final void onDestroy() {
        HashSet<String> r0 = this.B;
        if (r0 == null) goto L5;
        r0.clear();
    L5:
        this.C.clear();
        this.l = false;
        this.k = false;
        this.m = false;
        ei6.a r1 = this.a;
        if (r1 == null) goto L10;
        si6.b r2 = r1.b();
        if (r2 == null) goto L10;
        si6.a.b(r2, false, "rtc manager destroy", 3);
    L10:
        I0();
        this.g.dispose();
        Disposable r3 = this.h;
        if (r3 == null) goto L13;
        r3.dispose();
    L13:
        Disposable r4 = this.i;
        if (r4 == null) goto L16;
        r4.dispose();
    L16:
        ((LinkedHashMap) this.z).clear();
        ((LinkedHashMap) this.A).clear();
        wv0.a r5 = (wv0.a) this.F.getValue();
        if (r5 == null) goto L19;
        r5.release();
    L19:
        this.j.removeCallbacksAndMessages(null);
    }

    public final void onPause() {
        if (this.l == false) goto L6;
        N0(false, "rtc manager pause");
        return;
    }

    public final void onResume() {
        if (this.l == false) goto L6;
        N0(true, "rtc manager resume");
        return;
    }

    @Override // xi0.b
    public final void q() {
        zi0.a.a.d(null);
        InteractLinkFullLinkMonitor.g0("");
        if (this.a != null) goto L5;
        InteractLinkFullLinkMonitor.m0("stopForwardStreamToRooms");
    L5:
        ei6.a r0 = this.a;
        if (r0 == null) goto L10;
        ui6.b r1 = r0.h();
        if (r1 == null) goto L10;
        r1.a(bj6.a.b(this.a));
    L10:
        U();
    }

    public final dg6.a r() {
        ALogger.e("RtcManager", "GuestLink notifyRtcData " + this.z);
        LinkedHashMap r5 = new LinkedHashMap();
        Iterator r0 = ((LinkedHashMap) this.z).entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L9;
        Map.Entry r1 = (Map.Entry) r0.next();
        String r2 = (String) r1.getKey();
        Object r3 = ((yb6.j) r1.getValue()).a;
        if (r3 != null) goto L8;
        r3 = new Object();
    L8:
        r5.put(r2, r3);
        goto L4
    L9:
        gd0.x r4 = new gd0.x(this.a, this.l, r5, this.b.b, false, null, 48);
        this.v = r4;
        return pg6.a.a(r4);
    }

    public final void v() {
        if (((Boolean) v60.a.getValue()).booleanValue() == true) goto L5;
        return;
    L5:
        ei6.a r0 = this.a;
        if (r0 == null) goto L10;
        fi6.a r1 = r0.g();
        if (r1 == null) goto L10;
        MixStreamType r2 = r1.U;
    L11:
        this.n = r2;
        MixStreamType r3 = MixStreamType.SERVER_MIX;
        InteractLinkFullLinkMonitor.l0(r2, r3);
        if (this.n == r3) goto L19;
        ALogger.d(LinkRoomFightContext.TAG, "now is " + this.n + ", try switch to server mix");
        ei6.a r4 = this.a;
        if (r4 == null) goto L20;
        ti6.d r5 = r4.p();
        if (r5 == null) goto L21;
        r5.m(r3);
        return;
    L21:
        return;
    L20:
        return;
    L19:
        return;
    L10:
        r2 = null;
        goto L11
    }

    public final tf0.i D0() {
        return this.J;
    }

    public final ei6.a V0() {
        return this.a;
    }

    @Override // xi0.b
    public final boolean Y() {
        return this.m;
    }

    public final pf6.a f0() {
        return this.b;
    }

    public final boolean isEngineOn() {
        return this.l;
    }

    public final Map<String, yb6.j> m() {
        return this.z;
    }

    public static final /* synthetic */ void A0(RtcManager r2) {
        r2.r = 0;
    }

    public static final /* synthetic */ void B0(RtcManager r2) {
        r2.q = 0;
    }

    public static final /* synthetic */ void C0(RtcManager r2) {
        r2.u = 0;
    }

    public static final /* synthetic */ Map i0(RtcManager r0) {
        return r0.A;
    }

    public static final /* synthetic */ ei6.a j0(RtcManager r0) {
        return r0.a;
    }

    public static final /* synthetic */ g0 k0(RtcManager r0) {
        return r0.f;
    }

    public static final /* synthetic */ Map l0(RtcManager r0) {
        return r0.z;
    }

    public static final /* synthetic */ CopyOnWriteArrayList m0(RtcManager r0) {
        return r0.e;
    }

    public static final /* synthetic */ v n0(RtcManager r0) {
        return r0.c;
    }

    public static final /* synthetic */ Disposable o0(RtcManager r0) {
        return r0.i;
    }

    public static final /* synthetic */ HashSet p0(RtcManager r0) {
        return r0.B;
    }

    public static final /* synthetic */ HashSet q0(RtcManager r0) {
        return r0.C;
    }

    public static final /* synthetic */ Map r0(RtcManager r0) {
        return r0.s;
    }

    public static final /* synthetic */ Map s0(RtcManager r0) {
        return r0.t;
    }

    public static final /* synthetic */ long t0(RtcManager r2) {
        return r2.r;
    }

    public static final /* synthetic */ long u0(RtcManager r2) {
        return r2.q;
    }

    public static final /* synthetic */ long v0(RtcManager r2) {
        return r2.u;
    }

    public static final void w0(RtcManager r6) {
        le0.b r0 = r6.b;
        r0.getClass();
        if (le0.b.d() == false) goto L7;
        com.bytedance.android.live.pushstream.d r1 = r0.a;
        if (r1 == null) goto L10;
        Boolean r2 = Boolean.valueOf(r1.u1());
    L11:
        boolean r3 = false;
        if (r2 == null) goto L14;
        boolean r4 = r2.booleanValue();
    L15:
        boolean r5 = !r4;
        Iterator<eg6.c> r7 = r6.e.iterator();
    L16:
        int r8 = 2;
        if (r7.hasNext() == false) goto L23;
        eg6.c r9 = r7.next();
        if (r5 == true) goto L22;
        r8 = 3;
    L22:
        r9.m(r8);
        goto L16
    L23:
        le0.b r10 = r6.b;
        if (r10 == null) goto L26;
        int r11 = r10.y0().d;
    L27:
        if (r11 == 1) goto L33;
        le0.b r12 = r6.b;
        if (r12 == null) goto L31;
        int r13 = r12.y0().d;
    L32:
        if (r13 == 2) goto L33;
    L34:
        Iterator<eg6.c> r14 = r6.e.iterator();
    L36:
        if (r14.hasNext() == false) goto L42;
        eg6.c r15 = r14.next();
        if (r3 == false) goto L40;
        int r16 = 2;
    L41:
        r15.d(r16);
        goto L36
    L40:
        r16 = 4;
        goto L41
    L42:
        return;
    L31:
        r13 = 0;
    L33:
        r3 = true;
        goto L34
    L26:
        r11 = 0;
        goto L27
    L14:
        r4 = false;
    L10:
        r2 = null;
        goto L11
    L7:
        uf2.d0 r17 = r0.b;
        if (r17 == null) goto L10;
        r2 = Boolean.valueOf(r17.t0());
        goto L11
    }

    public static final /* synthetic */ boolean x0(RtcManager r0) {
        return r0.k;
    }

    public static final /* synthetic */ void y0(RtcManager r1) {
        r1.k = false;
    }

    public final void B(com.bytedance.android.live.liveinteract.revenue.linkroomfight.rtc.b r2) {
        Intrinsics.checkNotNullParameter(r2, "linkInterceptor");
        Intrinsics.checkNotNullParameter(r2, "linkInterceptor");
    }

    @Override // xi0.b
    public final void C(String r3) {
        zi0.a.a.d(r3);
        InteractLinkFullLinkMonitor.g0(r3);
        if (r3 != null) goto L6;
        ALogger.e(LinkRoomFightContext.TAG, "stopForward error, localRtcInfo " + r3);
        return;
    L6:
        ei6.a r0 = this.a;
        if (r0 == null) goto L11;
        si6.b r1 = r0.b();
        if (r1 == null) goto L11;
        r1.c(r3);
    L11:
        ei6.a r4 = this.a;
        if (r4 == null) goto L16;
        ui6.b r5 = r4.h();
        if (r5 == null) goto L16;
        r5.a(bj6.a.b(this.a));
    L16:
        U();
    }

    public final ei6.a E0(v0 r4) {
        ALogger.d("RtcManager", "post PreMultiLinkInitRtcEngineEvent");
        xs2.b.a().post(new qe0.a());
        this.x = r4;
        fi6.a r1 = getInteractConfig();
        v r2 = this.c;
        if (r2 == null) goto L5;
        r2.p2(r1);
    L5:
        this.y = r1;
        String r3 = this.J.getRtcInfo();
        if (r3 != null) goto L8;
    L11:
        boolean r5 = true;
    L12:
        if (r5 == false) goto L14;
        ALogger.e("RtcManager", "dataHolder.rtcInfo is empty");
    L14:
        if (r4 != null) goto L18;
        return null;
    L18:
        return r4.create();
    L8:
        if (r3.length() == 0) goto L11;
        r5 = false;
        goto L12
    }

    public final void G(vb6.f r2) {
        Intrinsics.checkNotNullParameter(r2, "linkListener");
        Intrinsics.checkNotNullParameter(r2, "linkListener");
    }

    public final void J(String r9) {
        Set<Long> r0 = InteractLinkFullLinkMonitor.a;
        JSONObject r3 = new JSONObject();
        r3.put("live_core_ext_info", r9);
        nd0.c.o(nd0.c.a, LinkMonitorData.UpdateLiveCoreExtInfo, r3, 0, null, false, 28);
        if (r9 != null) goto L5;
        return;
    L5:
        if (r9.length() <= 0) goto L7;
        boolean r1 = true;
    L8:
        Integer r2 = null;
        if (r1 == false) goto L11;
        String r4 = r9;
    L12:
        if (r4 == null) goto L48;
        ALogger.w("RtcManager", "updateLiveCoreExtInfo ".concat(r9));
        int r5 = com.bytedance.android.live.liveinteract.plantform.utils.x.a;
        Intrinsics.checkNotNullParameter(r9, "liveCoreExtInfo");
        HashMap r6 = new HashMap();
        r6.put("ext_info", r9);
        com.bytedance.android.live.liveinteract.plantform.utils.x.t0("livecore_update_ext_info", r6);
        if (jc1.k.n(IEffectPerfToolsHelper.class).checkDebug() == false) goto L16;
        jc1.k.n(IEffectPerfToolsHelper.class).setPerfToolsNormalData("data_chatroom_livecore_extra", r9);
    L16:
        le0.b r7 = this.b;
        if (r7 == null) goto L19;
        r2 = r7.y0().a;
    L19:
        ei6.a r8 = this.a;
        if (r8 == null) goto L24;
        si6.b r10 = r8.b();
        if (r10 == null) goto L24;
        r10.f(r9);
    L24:
        le0.b r11 = this.b;
        if (r11 != null) goto L27;
    L34:
        IFeatureService r12 = jc1.k.f(IFeatureService.class);
        if (r12 == null) goto L39;
        z90.a r13 = r12.getFeatureManager();
        if (r13 == null) goto L39;
        r13.i("is_strategy_support_scene", Boolean.FALSE, FeatureType.MONITOR);
    L39:
        if (r2 == null) goto L51;
        le0.b r14 = this.b;
        if (r14 != null) goto L44;
        return;
    L44:
        if ((!Intrinsics.areEqual(r2, r14.y0().a)) == false) goto L50;
        this.D = r2;
        return;
    L50:
        return;
    L51:
        return;
    L27:
        if (le0.b.d() == false) goto L31;
        com.bytedance.android.live.pushstream.d r15 = r11.a;
        if (r15 == null) goto L34;
        r15.b1(r9);
        goto L34
    L31:
        uf2.d0 r16 = r11.b;
        if (r16 == null) goto L34;
        r16.A();
        goto L34
    L48:
        return;
    L11:
        r4 = null;
        goto L12
    L7:
        r1 = false;
        goto L8
    }

    public final void J0(v0 r6) {
        g r0 = new g(this);
        f r1 = new f(this);
        if (((Boolean) vm2.d.b6.getValue(null, vm2.d.a[363(0x16b, float:5.09E-43)])).booleanValue() == false) goto L12;
        if (r6 == null) goto L8;
        com.bytedance.android.live.pushstream.d r2 = r6.getLiveStream();
        if (r2 == null) goto L8;
        r2.I0(r0);
    L8:
        if (r6 == null) goto L21;
        com.bytedance.android.live.pushstream.d r7 = r6.getLiveStream();
        if (r7 == null) goto L22;
        r7.D0(r1);
        return;
    L22:
        return;
    L21:
        return;
    L12:
        if (r6 == null) goto L16;
        com.bytedance.android.live.pushstream.d r3 = r6.getLiveStream();
        if (r3 == null) goto L16;
        r3.v1(r0);
    L16:
        if (r6 == null) goto L24;
        com.bytedance.android.live.pushstream.d r8 = r6.getLiveStream();
        if (r8 == null) goto L25;
        r8.L0(r1);
        return;
    L25:
        return;
    }

    public final void K0(boolean r2) {
        if (((Boolean) is.a.getValue()).booleanValue() == false) goto L5;
        this.k = r2;
        return;
    L5:
        this.k = false;
    }

    public final void P(int r4) {
        ei6.a r0 = this.a;
        if (r0 == null) goto L8;
        ALogger.i("RtcManager", "updateAudioPlaybackVolumeOnly, volume: " + r4);
        JSONObject r5 = new JSONObject();
        r5.put("rtc.audio_playback_volume_only", 0);
        si6.b r1 = r0.b();
        if (r1 == null) goto L9;
        r1.d(r5);
        return;
    L9:
        return;
    }

    public final void Q(String r2) {
        Intrinsics.checkNotNullParameter(r2, MultiLinkOpenSource.MESSAGE);
        ei6.a r0 = this.a;
        if (r0 == null) goto L8;
        ti6.d r1 = r0.p();
        if (r1 == null) goto L9;
        r1.e(r2);
        return;
    L9:
        return;
    }

    public final void W(LinkmicOnlineFloatWindowManager r3) {
        Intrinsics.checkNotNullParameter(r3, "listener");
        ei6.a r0 = this.a;
        if (r0 == null) goto L8;
        gi6.e r1 = r0.getEventManager();
        if (r1 == null) goto L9;
        r1.b(new i0(this, r3));
        return;
    L9:
        return;
    }

    public final void Z(k r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        Intrinsics.checkNotNullParameter(r2, "listener");
    }

    public final void a(InteractMode r2) {
        Intrinsics.checkNotNullParameter(r2, "interactMode");
        ei6.a r0 = this.a;
        if (r0 == null) goto L8;
        si6.b r1 = r0.b();
        if (r1 == null) goto L9;
        r1.a(r2);
        return;
    L9:
        return;
    }

    public final void c(String r3) {
        InteractLinkFullLinkMonitor.u0(r3);
        if (r3 != null) goto L5;
        return;
    L5:
        if (r3.length() <= 0) goto L7;
        boolean r0 = true;
    L8:
        if (r0 == false) goto L10;
        String r1 = r3;
    L11:
        if (r1 == null) goto L19;
        ALogger.w("RtcManager", "updateRtcExtInfo ".concat(r3));
        int r2 = com.bytedance.android.live.liveinteract.plantform.utils.x.a;
        Intrinsics.checkNotNullParameter(r3, "rtcExtInfo");
        HashMap r4 = new HashMap();
        r4.put("ext_info", r3);
        com.bytedance.android.live.liveinteract.plantform.utils.x.t0("rtc_update_ext_info", r4);
        ei6.a r5 = this.a;
        if (r5 == null) goto L20;
        si6.b r6 = r5.b();
        if (r6 == null) goto L21;
        r6.c(r3);
        return;
    L21:
        return;
    L20:
        return;
    L19:
        return;
    L10:
        r1 = null;
        goto L11
    L7:
        r0 = false;
        goto L8
    }

    public final void d(int r2) {
        ei6.a r0 = this.a;
        if (r0 == null) goto L8;
        ri6.b r1 = r0.r();
        if (r1 == null) goto L9;
        r1.d(r2);
        return;
    L9:
        return;
    }

    public final void d0(boolean r1) {
        this.l = r1;
        r();
    }

    public final void e0(String r2) {
        Intrinsics.checkNotNullParameter(r2, "reason");
        Intrinsics.checkNotNullParameter(r2, "reason");
    }

    public final void g(vb6.f r2) {
        Intrinsics.checkNotNullParameter(r2, "linkListener");
        Intrinsics.checkNotNullParameter(r2, "linkListener");
    }

    public final void h0(eg6.a r2) {
        Intrinsics.checkNotNullParameter(r2, "callback");
        if (this.e.contains(r2) == true) goto L6;
        this.e.add(r2);
        return;
    }

    public final void i(boolean r3) {
        com.bytedance.android.live.liveinteract.spatial.b.a("RtcManager", "enableSpatialAudioRender " + r3);
        ei6.a r0 = this.a;
        if (r0 == null) goto L7;
        SpatialAudioManager r1 = r0.m();
        if (r1 == null) goto L7;
        r1.b(bj6.a.b(this.a), r3);
    L7:
        ei6.a r4 = this.a;
        if (r4 == null) goto L13;
        SpatialAudioManager r5 = r4.m();
        if (r5 == null) goto L14;
        r5.a(bj6.a.b(this.a));
        return;
    L14:
        return;
    }

    @Override // xi0.b
    public final int k(String r4) {
        Intrinsics.checkNotNullParameter(r4, "publicStreamId");
        n1(false);
        ei6.a r1 = this.a;
        if (r1 == null) goto L7;
        ui6.c r2 = r1.o();
        if (r2 == null) goto L7;
        r2.d(r4, PublicStreamType.VIDEO_AUDIO);
        return 0;
    L7:
        return -1;
    }

    @Override // xi0.b
    public final int l(String r3) {
        Intrinsics.checkNotNullParameter(r3, "publicStreamId");
        ei6.a r0 = this.a;
        if (r0 == null) goto L7;
        ui6.c r1 = r0.o();
        if (r1 == null) goto L7;
        r1.a(r3, PublicStreamType.VIDEO_AUDIO);
        return 0;
    L7:
        return -1;
    }

    @Override // xi0.b
    public final void n1(boolean r3) {
        if (this.G == null) goto L13;
        ALogger.w(LinkRoomFightContext.TAG, "#PublicStreamMix# recoverMixer lastLiveCoreMixStatus = " + this.H + ", invalidSei = " + r3 + ", stackTrace = " + Log.getStackTraceString(new Throwable()));
        uf2.x r0 = this.G;
        if (r0 == null) goto L7;
        r0.release();
    L7:
        this.G = null;
        if (Intrinsics.areEqual(this.H, Boolean.FALSE) == false) goto L10;
        this.b.t(false);
    L10:
        if (r3 == false) goto L14;
        N();
        f();
        return;
    L14:
        return;
    }

    @Override // xi0.b
    public final void p(k r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.c = r2;
    }

    public final void s(eg6.a r2) {
        Intrinsics.checkNotNullParameter(r2, "callback");
        if (this.e.contains(r2) == false) goto L6;
        this.e.remove(r2);
        return;
    }

    public final void z(com.bytedance.android.live.liveinteract.plantform.linksecurity.rts.a r2) {
        Intrinsics.checkNotNullParameter(r2, "handler");
        this.d = r2;
    }

    public static final /* synthetic */ void z0(RtcManager r0, boolean r1) {
        r0.m = r1;
    }

    public final void D(int r4, String r5) {
        Intrinsics.checkNotNullParameter(r5, "source");
        int r0 = l1.a;
        Integer r1 = je0.d.h();
        if (r1 == null) goto L5;
        int r2 = r1.intValue();
    L6:
        RtcAudioScene r3 = l1.a(r4, r2, je0.d.d());
        ei6.a r6 = this.a;
        if (r6 == null) goto L11;
        ri6.b r7 = r6.r();
        if (r7 == null) goto L11;
        r7.w(r3.getValue());
    L11:
        ALogger.i("RtcManager", "updateAudioScene, scene = " + r4 + ", audioScene = " + r3.getValue() + ", sourceFrom = " + r5);
        return;
    L5:
        r2 = 0;
        goto L6
    }

    public final void E(boolean r4, int r5) {
        ei6.a r0 = this.a;
        if (r0 == null) goto L8;
        ALogger.i("RtcManager", "updateAudiodPostDagcParams, enable:" + r4 + " targetLoudness:" + r5);
        JSONObject r6 = new JSONObject();
        r6.put("rtc.audio_post_dagc", r6);
        si6.b r7 = r0.b();
        if (r7 == null) goto L9;
        r7.d(r6);
        return;
    L9:
        return;
    }

    public final void F0(String r7, boolean r8) {
        Intrinsics.checkNotNullParameter(r7, "interactId");
        Intrinsics.checkNotNullParameter("rts unmute when user join", "reason");
        ei6.a r0 = this.a;
        if (r0 == null) goto L7;
        ri6.b r1 = r0.r();
        if (r1 == null) goto L7;
        r1.l(bj6.a.b(this.a), LiveWrappedStreamIndex.STREAM_INDEX_MAIN, r7, false, "rts unmute when user join");
    L7:
        if (r8 == false) goto L9;
        f();
    L9:
        this.B.remove(r7);
    }

    public final void G0(String r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r3, "interactId");
        ei6.a r5 = this.a;
        if (r5 == null) goto L9;
        xi6.c r6 = r5.t();
        if (r6 == null) goto L9;
        com.bytedance.live.livelink.kmp.impl.core.video.c r7 = r6.d();
        if (r7 == null) goto L9;
        r7.l(r3, false, "");
    L9:
        this.C.remove(r3);
    }

    public final void N0(boolean r5, String r6) {
        Intrinsics.checkNotNullParameter(r6, "reason");
        ei6.a r1 = this.a;
        if (r1 == null) goto L7;
        ri6.b r2 = r1.r();
        if (r2 == null) goto L7;
        r2.s(bj6.a.b(this.a), !r5);
    L7:
        if (r5 == false) goto L9;
        int r3 = 1;
    L10:
        Iterator<eg6.c> r4 = this.e.iterator();
    L12:
        if (r4.hasNext() == false) goto L14;
        r4.next().n(r3);
        goto L12
    L14:
        boolean r7 = this.L;
        if (r7 == false) goto L21;
        if (r7 == true) goto L18;
    L24:
        InteractLinkFullLinkMonitor.k0(r5, r6);
        tf0.i r8 = this.J;
        int r9 = com.bytedance.android.live.liveinteract.plantform.utils.x.a;
        Intrinsics.checkNotNullParameter(r8, "dataHolder");
        Intrinsics.checkNotNullParameter(r6, "reason");
        HashMap r10 = new HashMap();
        r10.put("reason", r6);
        if (r5 == false) goto L27;
        com.bytedance.android.live.liveinteract.plantform.utils.x.a(r10);
        com.bytedance.android.live.liveinteract.api.utils.g.n("rtc_switch_audio_unmute", r10, r8, false);
        return;
    L27:
        com.bytedance.android.live.liveinteract.plantform.utils.x.a(r10);
        com.bytedance.android.live.liveinteract.api.utils.g.n("rtc_switch_audio_mute", r10, r8, false);
        return;
    L18:
        if (je0.d.O() == false) goto L24;
        if (vm2.d.A() == false) goto L24;
    L21:
        le0.b r11 = this.b;
        if (r11 == null) goto L24;
        r11.c(!r5, r6);
        goto L24
    L9:
        r3 = 2;
        goto L10
    }

    public final void X(int r2, String r3) {
        Intrinsics.checkNotNullParameter(r3, "source");
        ei6.a r0 = this.a;
        if (r0 == null) goto L8;
        ri6.b r1 = r0.r();
        if (r1 == null) goto L8;
        r1.f(r2);
    L8:
        if (Intrinsics.areEqual(r3, "currentUserSingerChanged") == true) goto L10;
        return;
    L10:
        if (r2 != 4) goto L16;
        ei6.a r4 = this.a;
        if (r4 == null) goto L23;
        ri6.b r5 = r4.r();
        if (r5 == null) goto L24;
        r5.w(RtcAudioScene.REAL_TIME_CHORUS.getValue());
        return;
    L24:
        return;
    L23:
        return;
    L16:
        ei6.a r6 = this.a;
        if (r6 == null) goto L26;
        ri6.b r7 = r6.r();
        if (r7 == null) goto L27;
        r7.w(RtcAudioScene.NORMAL.getValue());
        return;
    L27:
        return;
    }

    public final void a0(dg6.a r7, ti6.j r8) {
        Intrinsics.checkNotNullParameter(r7, "rtcManagerData");
        this.a = r7.a;
        le0.b r0 = this.b;
        ec6.b r1 = r7.d;
        com.bytedance.android.live.pushstream.d r2 = null;
        if (r1 == null) goto L7;
        com.bytedance.android.live.pushstream.d r3 = gc6.b.a(r1);
        if (r3 == null) goto L7;
        uf2.d0 r4 = r3.getLiveCore();
    L8:
        r0.b = r4;
        Object r5 = r7.f;
        boolean r6 = r5 instanceof v0;
        if (r6 == true) goto L11;
        Object r9 = null;
    L13:
        if (((v0) r9) == null) goto L21;
        le0.b r10 = this.b;
        if (r6 == true) goto L17;
        r5 = null;
    L17:
        v0 r11 = (v0) r5;
        if (r11 == null) goto L20;
        r2 = r11.getLiveStream();
    L20:
        r10.a = r2;
    L25:
        this.z = new LinkedHashMap();
        Iterator r12 = r7.c.entrySet().iterator();
    L27:
        if (r12.hasNext() == false) goto L29;
        Map.Entry r13 = (Map.Entry) r12.next();
        this.z.put((String) r13.getKey(), new yb6.j(r13.getValue(), 0, 0));
        goto L27
    L29:
        this.l = r7.b;
        ei6.a r14 = this.a;
        if (r14 == null) goto L35;
        gi6.e r15 = r14.getEventManager();
        if (r15 == null) goto L35;
        r15.b(this.w);
    L35:
        if (this.L == false) goto L41;
        ei6.a r16 = this.a;
        if (r16 == null) goto L41;
        fi6.a r17 = r16.g();
        if (r17 == null) goto L41;
        r17.f = r8;
    L41:
        ALogger.e("RtcManager", "GuestLink setClient " + this.z);
        r();
        return;
    L21:
        le0.b r18 = this.b;
        v0 r19 = this.x;
        if (r19 == null) goto L24;
        r2 = r19.getLiveStream();
    L24:
        r18.a = r2;
        goto L25
    L11:
        r9 = r5;
    L7:
        r4 = null;
        goto L8
    }

    @Override // xi0.b
    public final int b0(String r2, Object r3) {
        Intrinsics.checkNotNullParameter(r2, "publicStreamId");
        Intrinsics.checkNotNullParameter(r3, "view");
        yf2.f r0 = new yf2.f();
        r0.a = (View) r3;
        r0.c = 2;
        ei6.a r4 = this.a;
        if (r4 == null) goto L7;
        ui6.c r5 = r4.o();
        if (r5 == null) goto L7;
        r5.b(r2, r0);
        return 0;
    L7:
        return -1;
    }

    @Override // xi0.b
    public final void v4(String r5, boolean r6) {
        Intrinsics.checkNotNullParameter(r5, "publicStreamId");
        this.b.B(r5);
        m1.b r0 = null;
        if (r6 == false) goto L18;
        this.G = this.b.b();
        ILiveWrappedLivePusher.Companion.getClass();
        ILiveWrappedLivePusher r1 = ILiveWrappedLivePusher.a.b();
        if (r1 == null) goto L9;
        m1.b r2 = r1.newVideoMixerDescription(null);
        if (r2 == null) goto L9;
        r2.e();
        r2.b();
        r2.c();
        r2.f();
        r2.h();
        r2.j();
        r2.g();
        r2.i();
        r2.a();
    L9:
        uf2.x r3 = this.G;
        if (r3 == null) goto L12;
        r3.o();
    L12:
        uf2.x r4 = this.G;
        if (r4 == null) goto L15;
        r4.start();
    L15:
        this.H = Boolean.valueOf(this.b.a());
        ALogger.w(LinkRoomFightContext.TAG, "#PublicStreamMix# try enableMixer lastLiveCoreMixStatus = " + this.H + ", liveStream = " + this.b);
        if (Intrinsics.areEqual(this.H, Boolean.FALSE) == false) goto L18;
        this.b.t(true);
    L18:
        j0 r7 = new j0(this, r6);
        ei6.a r8 = this.a;
        if (r8 == null) goto L23;
        ui6.c r9 = r8.o();
        if (r9 == null) goto L23;
        fg2.b r10 = new fg2.b();
        r10.a(LiveWrappedVideoPixelFormat.I420);
        Unit r11 = Unit.INSTANCE;
        r9.c(r5, r7, r10);
    L23:
        ILiveWrappedLivePusher.Companion.getClass();
        ILiveWrappedLivePusher r12 = ILiveWrappedLivePusher.a.b();
        if (r12 == null) goto L26;
        r0 = r12.newVideoMixerDescription("RIGHT_HALF");
    L26:
        if (r0 == null) goto L29;
        r0.h();
        return;
    }

    public RtcManager(IRoom r2, tf0.i r3, u r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r2, PbRequest.SwitchType.ROOM);
        Intrinsics.checkNotNullParameter(r3, "dataHolder");
        this.I = r2;
        this.J = r3;
        this.K = r4;
        this.L = r5;
        this.b = new le0.b();
        this.e = new CopyOnWriteArrayList();
        CompositeDisposable r6 = new CompositeDisposable();
        this.g = r6;
        this.j = new Handler();
        this.o = new com.bytedance.android.live.liveinteract.api.utils.f();
        this.s = new LinkedHashMap();
        this.t = new LinkedHashMap();
        this.w = (ii6.a) WeakReferenceWrapper.wrap(this);
        this.z = new LinkedHashMap();
        this.A = new LinkedHashMap();
        this.B = new HashSet();
        this.C = new HashSet();
        PublishSubject<Unit> r7 = PublishSubject.create();
        this.E = r7;
        this.F = LazyKt.lazy(new RtcManager$streamSignHelper$2(this));
        RxUtilKt.c(RxUtilKt.h(r7.debounce(((Number) vm2.e.c.getValue(null, vm2.e.a[1])).longValue(), TimeUnit.MILLISECONDS)).subscribe(new a(this), b.a), r6);
    }

    public static void L0(RtcManager r6, v0 r7, v r8, int r9) {
        boolean r1 = false;
        if ((r9 & 4) == 0) goto L5;
        boolean r0 = true;
    L7:
        if ((r9 & 8) == 0) goto L9;
        boolean r10 = true;
    L10:
        r6.getClass();
        Intrinsics.checkNotNullParameter(r8, "rtcListener");
        if (r6.l == false) goto L13;
        ALogger.e("ttlive_interact", "rtc already start.");
        return;
    L13:
        r6.J0(r7);
        InteractLinkFullLinkMonitor.c0();
        if (TextUtils.isEmpty(r6.J.getRtcInfo()) == false) goto L18;
        com.bytedance.android.live.liveinteract.plantform.utils.x.n0(-20, "rtc_ext_info is empty", r6.J);
        com.bytedance.android.live.liveinteract.api.utils.n.J(-20, "rtc_ext_info is empty");
        InteractLinkFullLinkMonitor.d0(-12303, "rtc_ext_info is empty");
        v r11 = r6.c;
        if (r11 == null) goto L129;
        r11.R(-12303, new IllegalStateException("rtc_ext_info is empty"));
        return;
    L129:
        return;
    L18:
        ((LinkedHashMap) r6.z).clear();
        ((LinkedHashMap) r6.A).clear();
        com.bytedance.android.live.liveinteract.plantform.utils.x.m0(r6.J);
        com.bytedance.android.live.liveinteract.api.utils.n.I();
        Disposable r3 = r6.h;
        if (r3 == null) goto L22;
        r3.dispose();
    L22:
        if (vm2.i.j() == false) goto L24;
        r6.h = Observable.timer(vm2.i.l(), TimeUnit.SECONDS).compose(RxUtil.rxSchedulerHelper()).subscribe(new k0(r6));
    L24:
        r6.q = System.currentTimeMillis();
    L114:
        e = move-exception;
        Disposable r12 = r6.h;
        if (r12 == null) goto L118;
        r12.dispose();
    L118:
        com.bytedance.android.live.liveinteract.api.utils.g.r("start_crash", e);
        v r13 = r6.c;
        if (r13 == null) goto L121;
        r13.R(-12304, e);
    L121:
        InteractLinkFullLinkMonitor.d0(-12304, Log.getStackTraceString(e));
        return;
    L26:
        if (r6.L == true) goto L30;
        ILiveWrappedLivePusher.Companion.getClass();     // Catch: Exception -> L114
        ILiveWrappedLivePusher r4 = ILiveWrappedLivePusher.a.b();     // Catch: Exception -> L114
        if (r4 == null) goto L30;
        r4.getAVLog();     // Catch: Exception -> L114
    L30:
        r6.c = r8;     // Catch: Exception -> L114
        r6.a = r6.E0(r7);     // Catch: Exception -> L114
        tf0.o r14 = com.bytedance.android.live.liveinteract.videotalk.utils.b0.c();     // Catch: Exception -> L114
        uf2.d0 r5 = null;
        if (r14 == null) goto L33;
        Integer r15 = Integer.valueOf(r14.C0());     // Catch: Exception -> L114
    L34:
        if (r15 == null) goto L51;
        tf0.o r16 = com.bytedance.android.live.liveinteract.videotalk.utils.b0.c();     // Catch: Exception -> L114
        if (r16 == null) goto L38;
        Integer r17 = Integer.valueOf(r16.C0());     // Catch: Exception -> L114
    L39:
        Intrinsics.checkNotNull(r17);     // Catch: Exception -> L114
        if (com.bytedance.android.live.liveinteract.spatial.a.e(r17.intValue()) == false) goto L51;
        com.bytedance.android.live.liveinteract.spatial.b.a("RtcManager", "init enableSpatialAudioRender true");     // Catch: Exception -> L114
        ei6.a r18 = r6.a;     // Catch: Exception -> L114
        if (r18 == null) goto L46;
        SpatialAudioManager r19 = r18.m();     // Catch: Exception -> L114
        if (r19 == null) goto L46;
        r19.b(bj6.a.b(r6.a), true);     // Catch: Exception -> L114
    L46:
        ei6.a r20 = r6.a;     // Catch: Exception -> L114
        if (r20 == null) goto L51;
        SpatialAudioManager r21 = r20.m();     // Catch: Exception -> L114
        if (r21 == null) goto L51;
        r21.a(bj6.a.b(r6.a));     // Catch: Exception -> L114
        goto L51
    L38:
        r17 = null;
    L51:
        le0.b r22 = r6.b;     // Catch: Exception -> L114
        if (r7 == null) goto L54;
        uf2.d0 r23 = r7.A();     // Catch: Exception -> L114
    L55:
        r22.b = r23;     // Catch: Exception -> L114
        le0.b r24 = r6.b;     // Catch: Exception -> L114
        if (r7 == null) goto L58;
        com.bytedance.android.live.pushstream.d r25 = r7.getLiveStream();     // Catch: Exception -> L114
    L59:
        r24.a = r25;     // Catch: Exception -> L114
        if (r6.L == false) goto L65;
        if (je0.d.V() == false) goto L65;
        r6.b.s();     // Catch: Exception -> L114
    L65:
        if (je0.d.U() == false) goto L67;
        r6.b.O(true);     // Catch: Exception -> L114
    L67:
        ei6.a r26 = r6.a;     // Catch: Exception -> L114
        if (r26 == null) goto L72;
        gi6.e r27 = r26.getEventManager();     // Catch: Exception -> L114
        if (r27 == null) goto L72;
        r27.b(r6.w);     // Catch: Exception -> L114
    L72:
        wv0.a r28 = (wv0.a) r6.F.getValue();     // Catch: Exception -> L114
        if (r28 == null) goto L77;
        if (r7 == null) goto L76;
        r5 = r7.A();     // Catch: Exception -> L114
    L76:
        r28.a(r5);     // Catch: Exception -> L114
    L77:
        u r29 = r6.K;     // Catch: Exception -> L114
        if (r29 == null) goto L80;
        r29.Qc();     // Catch: Exception -> L114
    L80:
        com.bytedance.live.datacontext.j r30 = com.bytedance.android.live.liveinteract.api.utils.m.d().getVideoTalkRoomSubScene();     // Catch: Exception -> L114
        if (r30 == null) goto L87;
        com.bytedance.android.livesdk.chatroom.viewmodel.e r31 = (com.bytedance.android.livesdk.chatroom.viewmodel.e) r30.getValue();     // Catch: Exception -> L114
        if (r31 == null) goto L87;
        com.bytedance.android.livesdk.chatroom.viewmodel.j r32 = r31.t();     // Catch: Exception -> L114
        if (r32 == null) goto L87;
        r6.D(r32.a, "startRtcEngine");     // Catch: Exception -> L114
    L87:
        if (r10 == true) goto L103;
        ei6.a r33 = r6.a;     // Catch: Exception -> L114
        if (r33 == null) goto L95;
        xi6.c r34 = r33.t();     // Catch: Exception -> L114
        if (r34 == null) goto L95;
        com.bytedance.live.livelink.kmp.impl.core.video.c r35 = r34.d();     // Catch: Exception -> L114
        if (r35 == null) goto L95;
        r35.e(r10);     // Catch: Exception -> L114
    L95:
        ei6.a r36 = r6.a;     // Catch: Exception -> L114
        if (r36 == null) goto L103;
        ri6.b r37 = r36.r();     // Catch: Exception -> L114
        if (r37 == null) goto L103;
        String r38 = bj6.a.b(r6.a);     // Catch: Exception -> L114
        if (r10 == true) goto L102;
        r1 = true;
    L102:
        r37.p(r38, r1, "enableAllRemoteRender");     // Catch: Exception -> L114
    L103:
        ei6.a r39 = r6.a;     // Catch: Exception -> L114
        if (r39 == null) goto L108;
        si6.b r40 = r39.b();     // Catch: Exception -> L114
        if (r40 == null) goto L108;
        si6.a.a(r40, bj6.a.b(r6.a), r0, 12);     // Catch: Exception -> L114
    L108:
        com.bytedance.android.live.liveinteract.api.utils.f r41 = r6.o;     // Catch: Exception -> L114
        ei6.a r42 = r6.a;     // Catch: Exception -> L114
        r41.a = r42;     // Catch: Exception -> L114
        if (r42 == null) goto L131;
        if (r42.r() == null) goto L132;
        r41.a.r().t1();     // Catch: Exception -> L123
        return;
    L132:
        return;
    L134:
        return;
    L131:
        return;
    L58:
        r25 = null;
        goto L59
    L54:
        r23 = null;
        goto L55
    L33:
        r15 = null;
        goto L34
    L9:
        r10 = false;
        goto L10
    L5:
        r0 = false;
        goto L7
    }

    public final void H(ei6.a r8, int r9, long r10, Exception r12) {
        this.j.post(new d(this, r9, r10, r12));
    }

    public final void M(ei6.a r8, int r9, long r10, Object... r12) {
        Intrinsics.checkNotNullParameter(r12, "params");
        this.j.post(new e(this, r9, r12, r10));
    }

    @Override // xi0.b
    public final int V(String r6, String r7, String r8, boolean r9) {
        zi0.a.a.c(r6, r7, r8);
        InteractLinkFullLinkMonitor.Z(r6, r7, r8);
        this.r = System.currentTimeMillis();
        if (r6 == null) goto L30;
        StringBuilder r2 = new StringBuilder("#PublicStreamMix# trySwitchMixType, now mixType is ");
        ei6.a r3 = this.a;
        MixStreamType r4 = null;
        if (r3 == null) goto L9;
        fi6.a r5 = r3.g();
        if (r5 == null) goto L9;
        MixStreamType r10 = r5.U;
    L10:
        r2.append(r10);
        r2.append(", purposeMcuClientMix = ");
        r2.append(r9);
        ALogger.w(LinkRoomFightContext.TAG, r2.toString());
        if (r9 == false) goto L18;
        ei6.a r11 = this.a;
        if (r11 == null) goto L17;
        fi6.a r12 = r11.g();
        if (r12 == null) goto L17;
        r4 = r12.U;
    L17:
        this.n = r4;
        ALogger.w(LinkRoomFightContext.TAG, "#PublicStreamMix# purpose to use mcu client mix, no need to switch to server mix.");
    L19:
        List r13 = CollectionsKt.listOf(new ui6.a(r6, r8));
        ei6.a r14 = this.a;
        if (r14 == null) goto L24;
        si6.b r15 = r14.b();
        if (r15 == null) goto L24;
        r15.c(r7);
    L24:
        ei6.a r16 = this.a;
        if (r16 == null) goto L32;
        ui6.b r17 = r16.h();
        if (r17 == null) goto L33;
        r17.d(bj6.a.b(this.a), r13, "");
        return 0;
    L33:
        return -1;
    L32:
        return -1;
    L18:
        v();
    L9:
        r10 = null;
        goto L10
    L30:
        ALogger.e(LinkRoomFightContext.TAG, "startForward error, roomId " + r6 + " localRtcInfo " + r7 + " remoteRtcInfo " + r8);
        return -1;
    }
}
