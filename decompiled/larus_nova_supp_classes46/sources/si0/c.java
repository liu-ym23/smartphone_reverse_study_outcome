package si0;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.SurfaceView;
import android.view.TextureView;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.android.live.broadcastgame.api.interactgame.IMiddlewareInteractGameService;
import com.bytedance.android.live.broadcastgame.api.xplay.LiveCoreUtilsKt;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.MainThreadPostUtils;
import com.bytedance.android.live.core.utils.TimeUtils;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.live.liveinteract.api.fulllink.LinkMonitorData;
import com.bytedance.android.live.liveinteract.api.utils.m;
import com.bytedance.android.live.liveinteract.revenue.game.LinkMicGameContext;
import com.bytedance.android.live.liveinteract.revenue.game.servermixer.XplayRTCManager;
import com.bytedance.android.live.liveinteract.utils.l;
import com.bytedance.android.live.liveinteract.utils.n;
import com.bytedance.android.livehostapi.business.depend.xplay.IByteRtcVideoFrame;
import com.bytedance.android.livesdk.chatroom.widget.j1;
import com.bytedance.android.livesdk.live.extension.plugin.api.livepusher.ILiveWrappedLivePusher;
import com.bytedance.android.livesdk.live.extension.plugin.api.livepusher.ILiveWrappedVideoFrame;
import com.bytedance.bmmt.BuildConfig;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.j;
import com.bytedance.live.livelink.kmp.api.core.mixer.MixStreamType;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.apm.impl.protector.RunnableProtector;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import jc1.k;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import uf2.b1;
import uf2.c1;
import uf2.d0;
import uf2.m1;
import uf2.z;
import zf2.k0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class c implements si0.b {
    public ei6.a a;
    public d0 b;
    public final AtomicBoolean c;
    public final si0.a d;
    public int e;
    public boolean f;
    public si0.b.a g;
    public ViewGroup h;
    public ViewGroup i;
    public ViewGroup j;
    public com.bytedance.android.live.broadcastgame.api.xplay.d k;
    public TextureView l;
    public m1.b m;
    public final d0.b n;
    public xi6.a o;
    public SurfaceView p;
    public final C0270c q;
    public final CompositeDisposable r;
    public final Object s;
    public final XplayRTCManager t;
    public final d u;
    public MixStreamType v;
    public final Context w;
    public final ne0.c x;
    public final j1 y;

    public static final class a {
    }

    public static final class b implements d0.b.a {
        public b() {
        }
    }

    /* JADX INFO: renamed from: si0.c$c, reason: collision with other inner class name */
    public static final class C0270c {
        public C0270c() {
        }
    }

    public static final class d implements g10.e {
        public final /* synthetic */ c a;

        public final void onInitReqSuccess() {
        }

        public final void onInitSuccess() {
        }

        public d(c r1) {
            this.a = r1;
        }

        public final void c(int r4, JSONObject r5) {
            Intrinsics.checkNotNullParameter(r5, "data");
            if (LinkMicGameContext.Companion.d() == true) goto L5;
            return;
        L5:
            if (r4 != 8) goto L12;
            ALogger.i("XplayController", "onPlayerEvent EVENT_FIRST_FRAME");
            this.a.e();
            c r6 = this.a;
            XplayRTCManager r7 = r6.t;
            com.bytedance.android.live.broadcastgame.api.xplay.d r8 = r6.k;
            if (r8 == null) goto L9;
            String r9 = r8.getRtcExtInfo();
        L10:
            r7.e(r9);
            return;
        L9:
            r9 = null;
            goto L10
        L12:
            if (r4 != 41) goto L25;
            int r10 = r5.optInt("stream_state", 0);
            int r11 = r5.optInt("error_code", 0);
            if (r10 == 0) goto L19;
            ALogger.e("XplayController", "onPlayerEvent EVENT_MERGE_STREAM_RESULT, failed");
            if (v.a() == false) goto L21;
            f2.c("全链路服务端合流：云游戏Pod转推异常", 0);
        L21:
            ALogger.i("XplayController", "onPlayerEvent EVENT_MERGE_STREAM_RESULT, stream_state: " + r10 + ", error_code: " + r11);
            return;
        L19:
            if (v.a() == false) goto L21;
            f2.c("全链路服务端合流：云游戏Pod转推成功", 0);
            goto L21
        }
    }

    public static final class e implements si0.a.b {
        public final /* synthetic */ c a;

        @Override // si0.a.b
        public final void a() {
            boolean r0 = ((Boolean) vm2.d.s3.getValue(null, vm2.d.a[224(0xe0, float:3.14E-43)])).booleanValue();
            String r1 = "onDetectFirstMixFrameFailed, mIsMixing: " + this.a.c + ", enableVideoMixerReInit: " + r0 + "mRetryCustomVideoMixerCount: " + this.a.e;
            ALogger.i("XplayController", r1);
            n.a.a(qi0.d.a, true, "onDetectFirstMixFrameFailed", r1, 4);
            c r2 = this.a;
            if (r2.e > 0) goto L5;
            return;
        L5:
            if (r2.c.get() == false) goto L10;
            if (r0 == false) goto L11;
            ALogger.i("XplayController", "onDetectFirstMixFrameFailed -> onReInitVideoMixer");
            c r3 = this.a;
            r3.e--;
            r3.h();
            this.a.i();
            return;
        L11:
            return;
        }

        public e(c r1) {
            this.a = r1;
        }
    }

    public static final class f implements com.bytedance.android.live.liveinteract.revenue.game.servermixer.a {
        public final /* synthetic */ c a;

        @Override // com.bytedance.android.live.liveinteract.revenue.game.servermixer.a
        public final String a() {
            k0 r0 = this.a.t.e;
            if (r0 != null) goto L7;
            return null;
        L7:
            return r0.a;
        }

        @Override // com.bytedance.android.live.liveinteract.revenue.game.servermixer.a
        public final boolean b() {
            XplayRTCManager r0 = this.a.t;
            if (r0.b == true) goto L5;
        L7:
            boolean r1 = false;
        L8:
            if (r1 != true) goto L11;
            return true;
        L11:
            return false;
        L5:
            if (r0.e == null) goto L7;
            r1 = true;
            goto L8
        }

        @Override // com.bytedance.android.live.liveinteract.revenue.game.servermixer.a
        public final m1.b c() {
            c r0 = this.a;
            m1.b r1 = r0.m;
            if (r1 == null) goto L5;
            return r1;
        L5:
            return r0.e();
        }

        @Override // com.bytedance.android.live.liveinteract.revenue.game.servermixer.a
        public final String d() {
            k0 r0 = this.a.t.e;
            if (r0 != null) goto L7;
            return null;
        L7:
            return r0.b;
        }

        public f(c r1) {
            this.a = r1;
        }
    }

    public static final class g<T> implements Consumer {
        public g(c r1) {
        }

        public final void accept(Object r20) {
            com.bytedance.android.live.broadcastgame.api.xplay.g r0 = (com.bytedance.android.live.broadcastgame.api.xplay.g) r20;
            if (r0 == null) goto L59;
            Intrinsics.checkNotNullParameter(r0, "$this$toLiveCoreVideoFame");
            c1 r5 = null;
            if (com.bytedance.android.live.broadcastgame.api.xplay.a.b(r0.b()) == false) goto L19;
            IByteRtcVideoFrame r1 = r0.b();
            ILiveWrappedLivePusher.Companion.getClass();
            ILiveWrappedLivePusher r2 = ILiveWrappedLivePusher.a.b();
            if (r2 == null) goto L9;
            r2.getRendererCommon();
        L9:
            ILiveWrappedLivePusher r6 = ILiveWrappedLivePusher.a.b();
            if (r6 == null) goto L16;
            int r7 = r1.getWidth();
            int r8 = r1.getHeight();
            Intrinsics.checkNotNullParameter(r1, "$this$isTextureOes");
            if (Intrinsics.areEqual(r1.getPixelFormat(), IByteRtcVideoFrame.PixelFormat.TEXTURE_OES.getStringValue()) == false) goto L14;
            ILiveWrappedVideoFrame.ILiveWrappedTextureBuffer.ILiveWrappedType r3 = ILiveWrappedVideoFrame.ILiveWrappedTextureBuffer.ILiveWrappedType.OES;
        L15:
            r5 = r6.newTextureBufferImpl(r7, r8, r3, r1.getTextureId(), null, pi0.b.a, new pi0.c(r1));
            goto L16
        L14:
            r3 = ILiveWrappedVideoFrame.ILiveWrappedTextureBuffer.ILiveWrappedType.RGB;
        L16:
            r1.retain();
            ALogger.d("textureToLiveCoreVideoFame", "retain");
            ILiveWrappedLivePusher r4 = ILiveWrappedLivePusher.a.b();
            if (r4 == null) goto L60;
            r4.newVideoFrame(r5, 0, 0);
            return;
        L60:
            return;
        L19:
            ByteBuffer r9 = r0.a();
            int r11 = r0.b().getWidth();
            int r10 = r0.b().getHeight();
            int r15 = (r11 + 1) / 2;
            int r12 = (r11 * r10) + 0;
            int r13 = ((r10 + 1) / 2) * r15;
            int r14 = r12 + r13;
            if (r9 == null) goto L22;
            r9.position(0);
        L22:
            if (r9 == null) goto L24;
            r9.limit(r12);
        L24:
            if (r9 == null) goto L26;
            ByteBuffer r16 = r9.slice();
        L27:
            if (r9 == null) goto L29;
            r9.position(r12);
        L29:
            if (r9 == null) goto L31;
            r9.limit(r14);
        L31:
            if (r9 == null) goto L33;
            ByteBuffer r17 = r9.slice();
        L34:
            if (r9 == null) goto L36;
            r9.position(r14);
        L36:
            if (r9 == null) goto L38;
            r9.limit(r14 + r13);
        L38:
            if (r9 == null) goto L40;
            ByteBuffer r18 = r9.slice();
        L41:
            ILiveWrappedLivePusher.Companion.getClass();
            ILiveWrappedLivePusher r19 = ILiveWrappedLivePusher.a.b();
            if (r19 == null) goto L45;
            r19.newJavaI420Buffer(r11, r10, r16, r11, r17, r15, r18, r15, 0, null);
        L45:
            if (vm2.d.J0().a() == true) goto L47;
        L53:
            ILiveWrappedLivePusher.Companion.getClass();
            ILiveWrappedLivePusher r21 = ILiveWrappedLivePusher.a.b();
            if (r21 == null) goto L62;
            r21.newVideoFrame(null, 0, 0);
            return;
        L62:
            return;
        L47:
            if ((System.currentTimeMillis() - pi0.d.a) <= 5000) goto L53;
            pi0.d.a = System.currentTimeMillis();
            PolarisFileWrapper r22 = new PolarisFileWrapper("data/data/com.ss.android.ugc.aweme/files/YuvConverter" + TimeUtils.currentTimeMillis() + ".yuv");
            ALogger.d("dumpYuv", r22.getAbsolutePath());
            FileChannel r23 = new PolarisFileOutputStreamWrapper(r22, false).getChannel();     // Catch: IOException -> L51
            r23.write(null);     // Catch: IOException -> L51
            r23.write(null);     // Catch: IOException -> L51
            r23.write(null);     // Catch: IOException -> L51
            r23.close();     // Catch: IOException -> L51
        L51:
            e = move-exception;
            ALogger.e("dumpYuv", e);
            goto L53
        L40:
            r18 = null;
            goto L41
        L33:
            r17 = null;
            goto L34
        L26:
            r16 = null;
            goto L27
        }
    }

    public static final class h<T> implements Consumer {
        public final /* synthetic */ c a;

        public h(c r1) {
            this.a = r1;
        }

        public final void accept(Object r5) {
            Unit r6 = (Unit) r5;
            m1.b r7 = this.a.e();
            ALogger.i("XplayController", "onLittleWindowSpecChanged, videoMixerDescription: " + r7);
            n.a.a(qi0.d.a, true, "onLittleWindowSpecChanged", "onLittleWindowSpecChanged, videoMixerDescription: " + r7, 4);
            this.a.l();
            xi6.a r8 = this.a.o;
            if (r8 == null) goto L5;
            r8.b();
        L5:
            this.a.t.d();
        }
    }

    public static final class i implements Runnable {
        public final /* synthetic */ c a;

        public i(c r1) {
            this.a = r1;
        }

        public final void a() {
            if (v.a() == false) goto L6;
            f2.c("前置客户端合流：开始", 0);
        L6:
            if (vm2.d.J0().g() == false) goto L8;
        L9:
            c r0 = this.a;
            r0.p = new SurfaceView(this.a.w);
            FrameLayout.LayoutParams r1 = new FrameLayout.LayoutParams(720, 1280);
            r1.gravity = 17;
            SurfaceView r2 = this.a.p;
            if (r2 == null) goto L12;
            r2.setLayoutParams(r1);
        L12:
            c r3 = this.a;
            si0.b.a r4 = r3.g;
            if (r4 == null) goto L17;
            ViewGroup r5 = r4.b;
            if (r5 == null) goto L17;
            r5.addView(r3.p);
        L17:
            c r6 = this.a;
            ILiveWrappedLivePusher.Companion.getClass();
            ILiveWrappedLivePusher r7 = ILiveWrappedLivePusher.a.b();
            if (r7 == null) goto L20;
            r7.newRenderView(this.a.p);
        L20:
            r6.getClass();
            return;
        L8:
            if (vm2.d.J0().h() == true) goto L9;
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

    static {
    }

    public final m1.b e() {
        com.bytedance.android.live.broadcastgame.api.xplay.d r0 = this.k;
        m1.b r7 = null;
        if (r0 != null) goto L27;
        Rect r8 = null;
    L6:
        if (r0 == null) goto L8;
        Rect r9 = r0.h();     // Catch: Exception -> L21
    L9:
        if (r0 == null) goto L11;
        Rect r1 = r0.i();     // Catch: Exception -> L21
    L12:
        if (r8 == null) goto L16;
        if (r9 == null) goto L16;
        if (r1 == null) goto L16;
        RectF r10 = new RectF();     // Catch: Exception -> L21
        float r11 = r8.left;     // Catch: Exception -> L21
        float r12 = r1.right;     // Catch: Exception -> L21
        r10.left = r11 / r12;     // Catch: Exception -> L21
        int r13 = r8.top;     // Catch: Exception -> L21
        float r14 = r13 / r1.bottom;     // Catch: Exception -> L21
        r10.top = r14;     // Catch: Exception -> L21
        r10.right = r8.right / r12;     // Catch: Exception -> L21
        r10.bottom = ((r8.bottom - r13) / (r9.bottom - r9.top)) + r14;     // Catch: Exception -> L21
    L17:
        ALogger.i("XplayController", "currentAnchorPreviewVideoMixerDescription, rectLittleWindow: " + r8 + ", rectGameContent: " + r9 + ", rectContainer: " + r1 + ", rectNormalized: " + r10);     // Catch: Exception -> L21
        ILiveWrappedLivePusher.Companion.getClass();     // Catch: Exception -> L21
        ILiveWrappedLivePusher r15 = ILiveWrappedLivePusher.a.b();     // Catch: Exception -> L21
        if (r15 == null) goto L25;
        r7 = r15.newVideoMixerDescription(r10.left, r10.top, r10.right, r10.bottom, 1, 32);     // Catch: Exception -> L21
    L21:
        e = move-exception;
        ALogger.e("XplayController", "currentAnchorPreviewVideoMixerDescription", e);
        ILiveWrappedLivePusher.Companion.getClass();
        ILiveWrappedLivePusher r16 = ILiveWrappedLivePusher.a.b();
        if (r16 == null) goto L25;
        r7 = r16.newVideoMixerDescription(0.0f, 0.0f, 0.0f, 0.0f, 1, 32);
    L25:
        this.m = r7;
        return r7;
    L16:
        r10 = new RectF();     // Catch: Exception -> L21
        goto L17
    L11:
        r1 = null;
        goto L12
    L8:
        r9 = null;
        goto L9
    L27:
        r8 = r0.d();     // Catch: Exception -> L21
        goto L6
    }

    public final void g() {
        ALogger.i("XplayController", "releaseAnchorPreview");
        ei6.a r0 = this.a;
        if (r0 == null) goto L9;
        xi6.c r1 = r0.t();
        if (r1 == null) goto L9;
        com.bytedance.live.livelink.kmp.impl.core.video.b r2 = r1.f();
        if (r2 == null) goto L9;
        r2.f(this.n);
    L9:
        this.l = null;
    }

    public final void h() {
        if (this.c.get() == false) goto L58;
        ALogger.i("XplayController", "releaseMixStream");
        qi0.d r0 = qi0.d.a;
        n.a.a(r0, true, "releaseMixStream", null, 12);
        if (this.a != null) goto L9;
        ALogger.e("XplayController", "releaseMixStream failed, cause: client == null");
        n.a.a(r0, true, "releaseMixStreamFailed", "releaseMixStream failed, cause: client == null", 4);
        return;
    L9:
        if (v.a() == false) goto L11;
        f2.c("前置客户端合流：结束", 0);
    L11:
        Object r1 = this.s;
        monitor-enter(r1);
        k(false);     // Catch: Throwable -> L55
        ei6.a r6 = this.a;     // Catch: Throwable -> L55
        if (r6 == null) goto L20;
        xi6.c r7 = r6.t();     // Catch: Throwable -> L55
        if (r7 == null) goto L20;
        com.bytedance.live.livelink.kmp.impl.core.video.b r8 = r7.f();     // Catch: Throwable -> L55
        if (r8 == null) goto L20;
        r8.g(false);     // Catch: Throwable -> L55
    L20:
        xi6.a r9 = this.o;     // Catch: Throwable -> L55
        if (r9 == null) goto L23;
        r9.d();     // Catch: Throwable -> L55
    L23:
        xi6.a r10 = this.o;     // Catch: Throwable -> L55
        if (r10 == null) goto L26;
        r10.d();     // Catch: Throwable -> L55
    L26:
        xi6.a r11 = this.o;     // Catch: Throwable -> L55
        if (r11 == null) goto L29;
        r11.a(this.q);     // Catch: Throwable -> L55
    L29:
        xi6.a r12 = this.o;     // Catch: Throwable -> L55
        if (r12 == null) goto L32;
        r12.f(false);     // Catch: Throwable -> L55
    L32:
        xi6.a r5 = this.o;     // Catch: Throwable -> L55
        if (r5 == null) goto L35;
        r5.release();     // Catch: Throwable -> L55
        Unit r13 = Unit.INSTANCE;     // Catch: Throwable -> L55
    L35:
        monitor-exit(r1);
        this.p = null;
        ei6.a r2 = this.a;
        if (r2 == null) goto L41;
        vi6.a r3 = r2.v();
        if (r3 == null) goto L41;
        r3.f();
    L41:
        j(true);
        if (vm2.d.J0().b() == false) goto L54;
        com.bytedance.android.live.broadcastgame.api.xplay.i r4 = f();
        if (r4 != null) goto L47;
        ALogger.i("XplayController", "restoreLiveCoreParams failed, cause: originalLiveCoreParams is null");
        goto L54
    L47:
        ALogger.i("XplayController", "restoreLiveCoreParams, " + r4);
        n.a.a(r0, true, "restoreLiveCoreParams", "restoreLiveCoreParams, " + r4, 4);
        j r14 = m.i().getLiveStream();
        if (r14 == null) goto L54;
        com.bytedance.android.live.pushstream.d r15 = (com.bytedance.android.live.pushstream.d) r14.getValue();
        if (r15 == null) goto L54;
        d0 r16 = r15.A();
        if (r16 == null) goto L54;
        LiveCoreUtilsKt.b(r16, r4);
    L54:
        si0.a r17 = this.d;
        r17.getClass();
        ALogger.i("CustomVideoMixerDetector", "onReleaseMixStream");
        r17.c.removeCallbacks(r17.d);
        return;
    L55:
        th = move-exception;
        throw th;
    }

    public final void i() {
        this.c.get();
        if (this.c.get() == false) goto L6;
        n.a.a(qi0.d.a, true, "startMixStreamFailed", "mix_frame_failed_cause_is_mixing", 4);
        return;
    L6:
        qi0.a r7 = qi0.a.j;
        LinkMonitorData r8 = LinkMonitorData.StartMixStream;
        HashMap r4 = new HashMap();
        r4.put("xplay_mix_stream_type", 0);
        Unit r5 = Unit.INSTANCE;
        l.a.a(r7, r8, null, null, 0, null, null, null, null, r4, 254);
        si0.a r6 = this.d;
        r6.getClass();
        ALogger.i("CustomVideoMixerDetector", "onStartMixStream");
        r6.c.removeCallbacks(r6.d);
        r6.c.postDelayed(r6.d, r6.a);
        com.bytedance.android.live.broadcastgame.api.xplay.i r9 = new com.bytedance.android.live.broadcastgame.api.xplay.i();
        j r10 = m.i().getLiveStream();
        if (r10 == null) goto L13;
        com.bytedance.android.live.pushstream.d r11 = (com.bytedance.android.live.pushstream.d) r10.getValue();
        if (r11 == null) goto L13;
        d0 r12 = r11.A();
        if (r12 == null) goto L13;
        LiveCoreUtilsKt.a(r12, r9);
        ALogger.i("XplayController", "startMixStream, currentLiveCoreParams: " + r9);
    L13:
        Object r13 = this.s;
        monitor-enter(r13);
        b1 r14 = null;
        if (vm2.d.J0().d() == false) goto L39;
        ei6.a r15 = this.a;     // Catch: Throwable -> L85
        if (r15 == null) goto L24;
        xi6.c r16 = r15.t();     // Catch: Throwable -> L85
        if (r16 == null) goto L24;
        com.bytedance.live.livelink.kmp.impl.core.video.b r17 = r16.f();     // Catch: Throwable -> L85
        if (r17 == null) goto L24;
        com.bytedance.live.livelink.kmp.impl.core.video.i r18 = r17.b();     // Catch: Throwable -> L85
    L25:
        this.o = r18;     // Catch: Throwable -> L85
        ei6.a r19 = this.a;     // Catch: Throwable -> L85
        if (r19 == null) goto L32;
        xi6.c r20 = r19.t();     // Catch: Throwable -> L85
        if (r20 == null) goto L32;
        com.bytedance.live.livelink.kmp.impl.core.video.b r21 = r20.f();     // Catch: Throwable -> L85
        if (r21 == null) goto L32;
        r21.g(true);     // Catch: Throwable -> L85
    L32:
        xi6.a r22 = this.o;     // Catch: Throwable -> L85
        if (r22 == null) goto L35;
        r22.init();     // Catch: Throwable -> L85
    L35:
        xi6.a r23 = this.o;     // Catch: Throwable -> L85
        if (r23 == null) goto L38;
        r23.f(true);     // Catch: Throwable -> L85
    L38:
        n.a.a(qi0.d.a, true, "onCustomVideoFrameMixerInit", "mClient: " + this.a + ", mCustomVideoFrameMixer: " + this.o + ')', 4);     // Catch: Throwable -> L85
    L24:
        r18 = null;
    L39:
        ILiveWrappedLivePusher.Companion.getClass();     // Catch: Throwable -> L85
        ILiveWrappedLivePusher r3 = ILiveWrappedLivePusher.a.b();     // Catch: Throwable -> L85
        if (r3 == null) goto L59;
        b1 r24 = r3.newTEBundle();     // Catch: Throwable -> L85
        if (r24 == null) goto L59;
        com.bytedance.android.live.broadcastgame.api.xplay.i r25 = f();     // Catch: Throwable -> L85
        if (r25 == null) goto L48;
        Integer r26 = r25.c();     // Catch: Throwable -> L85
        if (r26 == null) goto L48;
        int r27 = r26.intValue();     // Catch: Throwable -> L85
    L49:
        if (r25 == null) goto L53;
        Integer r28 = r25.a();     // Catch: Throwable -> L85
        if (r28 == null) goto L53;
        int r29 = r28.intValue();     // Catch: Throwable -> L85
    L54:
        r24.b();     // Catch: Throwable -> L85
        r24.b();     // Catch: Throwable -> L85
        if (((Boolean) vm2.d.A4.getValue(null, vm2.d.a[284(0x11c, float:3.98E-43)])).booleanValue() == false) goto L57;
        r24.a();     // Catch: Throwable -> L85
        r24.a();     // Catch: Throwable -> L85
    L58:
        String r0 = "startMixStream, mixerWidth: " + r27 + ", mixerHeight: " + r29 + ", originalLiveCoreParams: " + r25;     // Catch: Throwable -> L85
        ALogger.i("XplayController", r0);     // Catch: Throwable -> L85
        n.a.a(qi0.d.a, true, "startMixStream", r0, 4);     // Catch: Throwable -> L85
        r14 = r24;
        goto L59
    L57:
        r24.a();     // Catch: Throwable -> L85
    L53:
        r29 = 1280;
    L48:
        r27 = 720;
    L59:
        xi6.a r1 = this.o;     // Catch: Throwable -> L85
        if (r1 == null) goto L62;
        r1.e();     // Catch: Throwable -> L85
    L62:
        if (r14 == null) goto L64;
        r14.release();     // Catch: Throwable -> L85
    L64:
        xi6.a r2 = this.o;     // Catch: Throwable -> L85
        if (r2 == null) goto L67;
        e();     // Catch: Throwable -> L85
        r2.g();     // Catch: Throwable -> L85
    L67:
        xi6.a r30 = this.o;     // Catch: Throwable -> L85
        if (r30 == null) goto L73;
        ILiveWrappedLivePusher r31 = ILiveWrappedLivePusher.a.b();     // Catch: Throwable -> L85
        if (r31 == null) goto L72;
        r31.newVideoMixerDescription(0.0f, 0.0f, 1.0f, 1.0f, 0, 32);     // Catch: Throwable -> L85
    L72:
        r30.g();     // Catch: Throwable -> L85
    L73:
        k(true);     // Catch: Throwable -> L85
        monitor-exit(r13);
        xi6.a r32 = this.o;
        if (r32 == null) goto L78;
        r32.c(this.q);
    L78:
        ei6.a r33 = this.a;
        if (r33 == null) goto L83;
        vi6.a r34 = r33.v();
        if (r34 == null) goto L83;
        r34.f();
    L83:
        j(false);
        l();
        MainThreadPostUtils.b(new i(this));
        return;
    L85:
        th = move-exception;
        throw th;
    }

    @Override // si0.b
    public final void onCreate() {
        si0.a r0 = this.d;
        e r1 = new e(this);
        r0.getClass();
        ALogger.i("CustomVideoMixerDetector", "setFirstFrameDetectListener");
        r0.b = r1;
        com.bytedance.android.live.broadcastgame.api.xplay.n r2 = com.bytedance.android.live.broadcastgame.api.xplay.n.b;
        r2.h(this.u);
        com.bytedance.android.live.liveinteract.revenue.game.servermixer.a r3 = com.bytedance.android.live.liveinteract.revenue.game.servermixer.b.a;
        com.bytedance.android.live.liveinteract.revenue.game.servermixer.b.a = new f(this);
        XplayRTCManager r4 = this.t;
        r4.getClass();
        ALogger.i("XplayRTCManager", "onCreate");
        r2.h(r4.f);
    }

    @Override // si0.b
    public final void onDestroy() {
        ALogger.i("XplayController", "onDestroy");
        if (this.f == false) goto L5;
        n.a.a(qi0.d.a, true, "onXplayControllerDestroy", null, 12);
    L5:
        g();
        h();
        ViewGroup r0 = this.h;
        if (r0 == null) goto L8;
        r0.removeAllViews();
    L8:
        ViewGroup r1 = this.h;
        if (r1 == null) goto L11;
        r1.setVisibility(8);
    L11:
        ViewGroup r2 = this.i;
        if (r2 == null) goto L14;
        r2.removeAllViews();
    L14:
        ViewGroup r3 = this.i;
        if (r3 == null) goto L17;
        r3.setVisibility(8);
    L17:
        this.r.clear();
        si0.a r4 = this.d;
        r4.getClass();
        ALogger.i("CustomVideoMixerDetector", BuildConfig.BUILD_TYPE);
        r4.c.removeCallbacks(r4.d);
        com.bytedance.android.live.broadcastgame.api.xplay.n r5 = com.bytedance.android.live.broadcastgame.api.xplay.n.b;
        r5.f(this.u);
        this.t.f();
        XplayRTCManager r6 = this.t;
        r6.getClass();
        ALogger.i("XplayRTCManager", "onDestroy");
        r5.f(r6.f);
        com.bytedance.android.live.liveinteract.revenue.game.servermixer.b.a = null;
    }

    public static com.bytedance.android.live.broadcastgame.api.xplay.i f() {
        String r0 = tc0.c.h().m;
        if (r0 == null) goto L9;
        Lazy r1 = LiveCoreUtilsKt.a;
        Intrinsics.checkNotNullParameter(r0, "liveCoreExtInfo");
        JSONObject r2 = new JSONObject(r0).optJSONObject("PushBase");     // Catch: Exception -> L11
        if (r2 == null) goto L9;
        com.bytedance.android.live.broadcastgame.api.xplay.i r3 = new com.bytedance.android.live.broadcastgame.api.xplay.i();     // Catch: Exception -> L11
        r3.j(Integer.valueOf(r2.optInt("videoCaptureWidth")));     // Catch: Exception -> L11
        r3.i(Integer.valueOf(r2.optInt("videoCaptureHeight")));     // Catch: Exception -> L11
        r3.f(Integer.valueOf(r2.optInt("cap_adapted_quirks")));     // Catch: Exception -> L11
        r3.g(Integer.valueOf(r2.optInt("cap_adapted_width")));     // Catch: Exception -> L11
        r3.e(Integer.valueOf(r2.optInt("cap_adapted_height")));     // Catch: Exception -> L11
        return r3;
    L9:
        return null;
    }

    public final void l() {
        if (vm2.d.J0().b() == true) goto L5;
        return;
    L5:
        this.c.get();
        if (this.c.get() == true) goto L9;
        ALogger.i("XplayController", "updateLiveCoreParams failed");
        return;
    L9:
        TextureView r0 = this.l;
        if (r0 == null) goto L12;
        r0.getWidth();
    L12:
        TextureView r1 = this.l;
        if (r1 == null) goto L15;
        r1.getHeight();
    L15:
        TextureView r2 = this.l;
        int r3 = 0;
        if (r2 == null) goto L18;
        int r4 = r2.getWidth();
    L19:
        if (r4 <= 0) goto L40;
        TextureView r5 = this.l;
        if (r5 == null) goto L23;
        int r6 = r5.getHeight();
    L24:
        if (r6 <= 0) goto L41;
        j r7 = m.i().getLiveStream();
        if (r7 == null) goto L42;
        com.bytedance.android.live.pushstream.d r8 = (com.bytedance.android.live.pushstream.d) r7.getValue();
        if (r8 == null) goto L43;
        d0 r9 = r8.A();
        if (r9 == null) goto L44;
        com.bytedance.android.live.broadcastgame.api.xplay.i r10 = new com.bytedance.android.live.broadcastgame.api.xplay.i();
        r10.f(1);
        TextureView r11 = this.l;
        if (r11 == null) goto L34;
        int r12 = r11.getWidth();
    L35:
        r10.g(Integer.valueOf(r12));
        TextureView r13 = this.l;
        if (r13 == null) goto L38;
        r3 = r13.getHeight();
    L38:
        r10.e(Integer.valueOf(r3));
        ALogger.i("XplayController", "updateLiveCoreParams, " + r10);
        n.a.a(qi0.d.a, true, "updateLiveCoreParams", "updateLiveCoreParams, " + r10, 4);
        Unit r14 = Unit.INSTANCE;
        LiveCoreUtilsKt.b(r9, r10);
        return;
    L34:
        r12 = 0;
        goto L35
    L44:
        return;
    L43:
        return;
    L42:
        return;
    L41:
        return;
    L23:
        r6 = 0;
        goto L24
    L40:
        return;
    L18:
        r4 = 0;
        goto L19
    }

    @Override // si0.b
    public final void d() {
        g();
    }

    @Override // si0.b
    public final void a(ViewGroup r4) {
        Intrinsics.checkNotNullParameter(r4, "parentView");
        Intrinsics.checkNotNullParameter(r4, "parentView");
        ALogger.i("XplayController", "showAnchorPreview");
        TextureView r0 = new TextureView(this.w);
        this.l = r0;
        r0.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        r4.addView(this.l);
        ILiveWrappedLivePusher.Companion.getClass();
        ILiveWrappedLivePusher r5 = ILiveWrappedLivePusher.a.b();
        if (r5 == null) goto L6;
        r5.newRenderView(this.l);
        return;
    }

    @Override // si0.b
    public final void b(boolean r5) {
        ALogger.i("XplayController", "updateGameState, isGameStart: " + r5);
        if (r5 == false) goto L5;
        return;
    L5:
        if (this.f == false) goto L23;
        f2.c(s1.B(2131920852), 0);
        ALogger.i("XplayController", "updateGameState -> stopPlugin");
        qi0.d r6 = qi0.d.a;
        n.a.a(r6, true, "onGameEndStopPlugin", null, 12);
        n.a.a(r6, true, "stopPlugin", "source: multilink game stop", 4);
        ViewGroup r7 = this.h;
        if (r7 == null) goto L9;
        r7.removeAllViews();
    L9:
        ViewGroup r8 = this.h;
        if (r8 == null) goto L12;
        r8.setVisibility(8);
    L12:
        ViewGroup r9 = this.i;
        if (r9 == null) goto L15;
        r9.removeAllViews();
    L15:
        ViewGroup r10 = this.i;
        if (r10 == null) goto L18;
        r10.setVisibility(8);
    L18:
        IMiddlewareInteractGameService r11 = k.f(IMiddlewareInteractGameService.class);
        if (r11 == null) goto L24;
        r11.stopRunningPlugin("multilink game stop");
        return;
    L24:
        return;
    }

    public final void j(boolean r3) {
        if (vm2.d.J0().e() == false) goto L12;
        ALogger.i("XplayController", "updateAnchorLayerVisibility, isVisible: " + r3);
        d0 r4 = this.b;
        if (r4 == null) goto L13;
        z r5 = r4.C();
        if (r5 == null) goto L14;
        z.a r6 = r5.K0();
        if (r6 == null) goto L15;
        r6.a();
        return;
    L15:
        return;
    L14:
        return;
    L13:
        return;
    }

    public final void k(boolean r6) {
        n.a.a(qi0.d.a, true, "updateIsMixing", "isMixing: " + r6, 4);
        this.c.set(r6);
        ne0.c r0 = this.x;
        int r1 = ti0.e.a;
        r0.b("is_xplay_mixing", Boolean.valueOf(r6));
    }

    @Override // si0.b
    public final void c(si0.b.a r27, com.bytedance.android.live.broadcastgame.api.xplay.f r28) {
        Intrinsics.checkNotNullParameter(r27, "info");
        ALogger.i("XplayController", "onXplayVisibilityChange, isVisible: " + r27.a);
        qi0.d r3 = qi0.d.a;
        n.a.a(r3, true, "onXplayVisibilityChange", "isVisible: " + r27.a, 4);
        int r5 = 0;
        this.f = false;
        this.g = r27;
        hg6.g r7 = r27.e;
        String r9 = null;
        if (r7 == null) goto L5;
        ei6.a r8 = r7.V0();
    L6:
        this.a = r8;
        hg6.g r10 = r27.e;
        if (r10 == null) goto L13;
        ec6.b r11 = r10.R();
        if (r11 == null) goto L13;
        com.bytedance.android.live.pushstream.d r12 = gc6.b.a(r11);
        if (r12 == null) goto L13;
        d0 r13 = r12.getLiveCore();
    L14:
        this.b = r13;
        this.h = r27.b;
        this.i = r27.c;
        this.j = r27.d;
        if (r28 == null) goto L17;
        com.bytedance.android.live.broadcastgame.api.xplay.d r14 = (com.bytedance.android.live.broadcastgame.api.xplay.d) r28.getService(com.bytedance.android.live.broadcastgame.api.xplay.d.class);
    L18:
        this.k = r14;
        boolean r15 = r27.a;
        if (r14 == null) goto L21;
        ViewGroup r16 = r14.j();
    L22:
        com.bytedance.android.live.broadcastgame.api.xplay.d r17 = this.k;
        if (r17 == null) goto L25;
        ViewGroup r18 = r17.a();
    L26:
        ViewGroup r19 = this.h;
        if (r19 != null) goto L29;
    L154:
        ALogger.e("XplayController", "onXplayVisibilityChange failed, cause: xplayContainer is null");
        n.a.a(r3, true, "onXplayVisibilityChangeFailed", "xplayContainer is null", 4);
        if (r15 == false) goto L161;
        String r1 = qi0.c.b;
        com.bytedance.android.live.liveinteract.utils.m.a.a(false, "show_xplay_failed_cause_xplay_container_null", 12);
        l.a.a(qi0.a.j, LinkMonitorData.XplayShow, null, null, 1, null, "show_xplay_failed_cause_xplay_container_null", null, null, null, 470);
        return;
    L161:
        return;
    L29:
        if (this.i == null) goto L154;
        if (r16 != null) goto L37;
        ALogger.e("XplayController", "onXplayVisibilityChange failed, cause: xplayView is null, xplayInstance: " + r28 + ", mXplayExtContainerService: " + this.k);
        n.a.a(r3, true, "onXplayVisibilityChangeFailed", "xplayView is null, xplayInstance: " + r28 + ", mXplayExtContainerService: " + this.k, 4);
        if (r15 == false) goto L158;
        String r2 = qi0.c.b;
        com.bytedance.android.live.liveinteract.utils.m.a.a(false, "show_xplay_failed_cause_xplay_view_null", 12);
        l.a.a(qi0.a.j, LinkMonitorData.XplayShow, null, null, 2, null, "show_xplay_failed_cause_xplay_view_null", null, null, null, 470);
        return;
    L158:
        return;
    L37:
        if (r15 == false) goto L39;
        int r110 = 0;
    L40:
        r19.setVisibility(r110);
        ViewGroup r111 = this.i;
        if (r111 == null) goto L47;
        if (r15 == true) goto L45;
        r5 = 8;
    L45:
        r111.setVisibility(r5);
    L47:
        if (r15 == false) goto L127;
        l.a.a(qi0.a.j, LinkMonitorData.XplayShow, null, null, 0, null, null, null, null, null, 510);
        this.e = ((Number) vm2.d.t3.getValue(null, vm2.d.a[225(0xe1, float:3.15E-43)])).intValue();
        this.f = true;
        n.a.a(r3, true, "showXplayView", null, 12);
        ALogger.d("XplayController", "onXplayVisibilityChange, xplayView.parentView(): " + UtilityKotlinExtentionsKt.p(r16));
        Integer r6 = je0.d.h();
        if (r6 != null) goto L52;
    L54:
        ViewGroup r20 = this.h;
    L56:
        if (UtilityKotlinExtentionsKt.p(r16) != null) goto L58;
    L59:
        ViewGroup r112 = UtilityKotlinExtentionsKt.p(r16);
        if (r112 == null) goto L62;
        r112.removeView(r16);
    L62:
        r16.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        if (r20 == null) goto L65;
        r20.addView(r16);
    L65:
        if (r18 == null) goto L67;
        ViewGroup r21 = UtilityKotlinExtentionsKt.p(r18);
    L69:
        if (Intrinsics.areEqual(r21, this.i) == true) goto L78;
        if (r18 == null) goto L78;
        ViewGroup r22 = UtilityKotlinExtentionsKt.p(r18);
        if (r22 == null) goto L74;
        r22.removeView(r18);
    L74:
        ViewGroup r23 = this.i;
        if (r23 == null) goto L78;
        r23.addView(r18);
    L78:
        if (this.a != null) goto L82;
        ALogger.e("XplayController", "onXplayVisibilityChange failed, cause: client is null, rtcManager: " + r27.e);
        n.a.a(r3, true, "onXplayVisibilityChangeFailed", "client is null, rtcManager: " + r27.e, 4);
        return;
    L82:
        if (vm2.d.J0().f() == false) goto L96;
        ei6.a r4 = this.a;
        if (r4 == null) goto L88;
        fi6.a r24 = r4.g();
        if (r24 == null) goto L88;
        MixStreamType r25 = r24.U;
    L89:
        this.v = r25;
        ALogger.i("XplayController", "switchToRtcServerMixType, mMixTypeBefore: " + this.v);
        n.a.a(r3, true, "switchToRtcServerMixType", "mMixTypeBefore: " + this.v, 4);
        MixStreamType r26 = this.v;
        MixStreamType r29 = MixStreamType.SERVER_MIX;
        if (r26 == r29) goto L96;
        ALogger.i("XplayController", "switchToRtcServerMixType start");
        ei6.a r30 = this.a;
        if (r30 == null) goto L96;
        ti6.d r31 = r30.p();
        if (r31 == null) goto L96;
        r31.m(r29);
    L88:
        r25 = null;
    L96:
        com.bytedance.android.live.broadcastgame.api.xplay.d r32 = this.k;
        if (r32 == null) goto L103;
        Observable r33 = r32.c();
        if (r33 == null) goto L103;
        Disposable r34 = r33.subscribe(new g(this));
        if (r34 == null) goto L103;
        RxUtilKt.c(r34, this.r);
    L103:
        com.bytedance.android.live.broadcastgame.api.xplay.d r35 = this.k;
        if (r35 == null) goto L110;
        Observable r36 = r35.f();
        if (r36 == null) goto L110;
        Disposable r37 = r36.subscribe(new h(this));
        if (r37 == null) goto L110;
        RxUtilKt.c(r37, this.r);
    L110:
        ei6.a r38 = this.a;
        if (r38 == null) goto L117;
        xi6.c r39 = r38.t();
        if (r39 == null) goto L117;
        com.bytedance.live.livelink.kmp.impl.core.video.b r40 = r39.f();
        if (r40 == null) goto L117;
        r40.a(this.n);
    L117:
        com.bytedance.android.live.broadcastgame.api.xplay.d r41 = this.k;
        if (r41 == null) goto L120;
        Boolean r42 = r41.g();
    L122:
        if (Intrinsics.areEqual(r42, Boolean.TRUE) == false) goto L159;
        e();
        XplayRTCManager r43 = this.t;
        com.bytedance.android.live.broadcastgame.api.xplay.d r44 = this.k;
        if (r44 == null) goto L126;
        r9 = r44.getRtcExtInfo();
    L126:
        r43.e(r9);
        return;
    L159:
        return;
    L120:
        r42 = null;
        goto L122
    L67:
        r21 = null;
        goto L69
    L58:
        if (Intrinsics.areEqual(UtilityKotlinExtentionsKt.p(r16), r20) == true) goto L65;
    L52:
        if (r6.intValue() != 15) goto L54;
        r20 = this.j;
        goto L56
    L127:
        n.a.a(r3, true, "removeXplayView", null, 12);
        h();
        ViewGroup r45 = this.h;
        if (r45 == null) goto L130;
        r45.removeAllViews();
    L130:
        ViewGroup r46 = this.i;
        if (r46 == null) goto L134;
        r46.removeAllViews();
    L134:
        if (vm2.d.J0().f() == false) goto L152;
        MixStreamType r47 = this.v;
        if (r47 == null) goto L152;
        ei6.a r48 = this.a;
        if (r48 == null) goto L142;
        fi6.a r49 = r48.g();
        if (r49 == null) goto L142;
        MixStreamType r50 = r49.U;
    L143:
        if (r47 == r50) goto L152;
        ALogger.i("XplayController", "recoverMixType, mMixTypeBefore: " + this.v);
        n.a.a(r3, true, "recoverMixType", "mMixTypeBefore: " + this.v, 4);
        MixStreamType r51 = this.v;
        if (r51 == null) goto L152;
        ei6.a r52 = this.a;
        if (r52 == null) goto L151;
        ti6.d r53 = r52.p();
        if (r53 == null) goto L151;
        r53.m(r51);
    L151:
        this.v = null;
    L142:
        r50 = null;
    L152:
        this.k = null;
        this.r.clear();
        this.t.f();
        return;
    L39:
        r110 = 8;
        goto L40
    L25:
        r18 = null;
        goto L26
    L21:
        r16 = null;
        goto L22
    L17:
        r14 = null;
    L13:
        r13 = null;
        goto L14
    L5:
        r8 = null;
        goto L6
    }

    public c(Context r2, ne0.c r3, DataCenter r4, j1 r5) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "mStore");
        Intrinsics.checkNotNullParameter(r4, "dataCenter");
        Intrinsics.checkNotNullParameter(r5, "scopeProvider");
        this.w = r2;
        this.x = r3;
        this.y = r5;
        this.c = new AtomicBoolean(false);
        this.d = new si0.a();
        d0.b r6 = null;
        this.e = ((Number) vm2.d.t3.getValue(null, vm2.d.a[225(0xe1, float:3.15E-43)])).intValue();
        ILiveWrappedLivePusher.Companion.getClass();
        ILiveWrappedLivePusher r7 = ILiveWrappedLivePusher.a.b();
        if (r7 == null) goto L5;
        r6 = r7.newLiveCoreVideoFrameAvailableListener(new b());
    L5:
        this.n = r6;
        this.q = new C0270c();
        this.r = new CompositeDisposable();
        this.s = new Object();
        this.t = new XplayRTCManager(r5);
        this.u = new d(this);
    }
}
