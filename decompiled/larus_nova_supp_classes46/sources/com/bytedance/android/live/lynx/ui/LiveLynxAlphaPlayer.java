package com.bytedance.android.live.lynx.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.live.gift.IGiftServiceExternal;
import com.bytedance.android.live.liveinteract.api.MultiLinkOpenSource;
import com.bytedance.android.livesdk.utils.LifecycleOwnerCompat;
import com.bytedance.bmmt.BuildConfig;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.security.android.aopcheck.PolarisFileReaderWrapper;
import com.facebook.common.executors.CallerThreadExecutor;
import com.facebook.common.references.CloseableReference;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.datasource.BaseBitmapDataSubscriber;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.google.gson.JsonSyntaxException;
import com.lynx.react.bridge.Callback;
import com.lynx.react.bridge.JavaOnlyMap;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.EventEmitter;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.LynxProp;
import com.lynx.tasm.behavior.LynxUIMethod;
import com.lynx.tasm.behavior.ui.LynxUI;
import com.lynx.tasm.behavior.ui.view.UISimpleView;
import com.lynx.tasm.event.EventsListener;
import com.ss.android.socialbase.downloader.depend.AbsDownloadListener;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.ugc.aweme.live.alphaplayer.Configuration;
import com.ss.android.ugc.aweme.live.alphaplayer.controller.IPlayerController;
import com.ss.android.ugc.aweme.live.alphaplayer.model.DataSource;
import d76.y;
import java.io.BufferedReader;
import java.net.URLDecoder;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u001e\u001fJ\u0012\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0007J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0003H\u0007J\u0010\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0003H\u0007J\u0010\u0010\r\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u000bH\u0007J\u0010\u0010\u000e\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u000bH\u0007J\u0010\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u000bH\u0007J\u0018\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0013H\u0007J\u0018\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0013H\u0007J\u0018\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0013H\u0007J\u0018\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0013H\u0007J\u0018\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0013H\u0007J\u0018\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0013H\u0007J\u0018\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0013H\u0007J\u001a\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0007J\u001a\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0007¨\u0006 "}, d2 = {"Lcom/bytedance/android/live/lynx/ui/LiveLynxAlphaPlayer;", "Lcom/lynx/tasm/behavior/ui/view/UISimpleView;", "Lcom/bytedance/android/live/lynx/ui/LynxAlphaVideoViewCompat;", "", "src", "", "setSrc", "poster", "setPoster", "lastFrame", "setLastFrame", "", "enable", "setAutoPlay", "setKeepLastFrame", "loop", "setLoop", "Lcom/lynx/react/bridge/ReadableMap;", "params", "Lcom/lynx/react/bridge/Callback;", "callback", "play", "pause", "stop", "getDuration", "isPlaying", BuildConfig.BUILD_TYPE, "resume", "subscribeUpdateEvent", "unsubscribeUpdateEvent", "a", "b", "livehybrid-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveLynxAlphaPlayer extends UISimpleView<LynxAlphaVideoViewCompat> {
    public static final /* synthetic */ int h = 0;
    public IPlayerController a;
    public Set<String> b;
    public DataSource c;
    public boolean d;
    public boolean e;
    public Bitmap f;
    public String g;

    public interface a {
        void onFailed();

        void onSuccess(Bitmap r1);
    }

    public static final class b {
    }

    public static final class c extends AbsDownloadListener {
        public final /* synthetic */ LiveLynxAlphaPlayer a;
        public final /* synthetic */ String b;
        public final /* synthetic */ Uri c;

        public final void onSuccessed(DownloadInfo r3) {
            LLog.i("x-alpha-video", "download resource success, and directUrl is " + this.b);
            LiveLynxAlphaPlayer.N(this.a, this.a.getLynxContext().getApplicationContext().getCacheDir().getAbsolutePath() + '/' + this.c.getLastPathSegment(), this.b);
        }

        public final void onFailed(DownloadInfo r3, BaseException r4) {
            String r5 = "download resource failed and resource is " + this.b + ", error msg is " + r4;
            LiveLynxAlphaPlayer r6 = this.a;
            r6.Q(r5, r6.g, -12);
            throw null;
        }

        public c(LiveLynxAlphaPlayer r1, String r2, Uri r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    public static final class d extends BaseBitmapDataSubscriber {
        public final /* synthetic */ a a;
        public final /* synthetic */ CountDownLatch b;
        public final /* synthetic */ com.facebook.datasource.DataSource c;

        public final void onFailureImpl(com.facebook.datasource.DataSource<CloseableReference<CloseableImage>> r2) {
            this.a.onFailed();
            if (r2 == null) goto L5;
            r2.close();
        L5:
            this.b.countDown();
        }

        public final void onNewResultImpl(Bitmap r4) {
            if (this.c.isFinished() == false) goto L9;
            if (r4 == null) goto L9;
            Bitmap.Config r0 = r4.getConfig();
            if (r0 == null) goto L8;
            this.a.onSuccess(r4.copy(r0, true));
        L8:
            this.c.close();
        L9:
            this.b.countDown();
        }

        public d(a r1, CountDownLatch r2, com.facebook.datasource.DataSource r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    public static final class e extends com.lynx.tasm.event.a {
        public final /* synthetic */ Map b;

        public final Map<String, Object> b() {
            return this.b;
        }

        public e(Map r1, int r2, String r3) {
            this.b = r1;
            super(r2, r3);
        }
    }

    public static final class f<V> implements Callable {
        public final /* synthetic */ LiveLynxAlphaPlayer a;
        public final /* synthetic */ String b;

        public static final class a implements a {
            public final /* synthetic */ f a;
            public final /* synthetic */ Ref.ObjectRef b;

            @Override // com.bytedance.android.live.lynx.ui.LiveLynxAlphaPlayer.a
            public final void onFailed() {
                LiveLynxAlphaPlayer r0 = this.a.a;
                DataSource r1 = r0.c;
                if (r1 == null) goto L5;
                r1.g = true;
            L5:
                r0.Q("set video lastFrame failed, lastFrame is " + this.a.b, this.a.a.g, -16);
                throw null;
            }

            @Override // com.bytedance.android.live.lynx.ui.LiveLynxAlphaPlayer.a
            public final void onSuccess(Bitmap r2) {
                if (r2 == null) goto L5;
                this.b.element = r2;
                return;
            }

            public a(f r1, Ref.ObjectRef r2) {
                this.a = r1;
                this.b = r2;
            }
        }

        public f(LiveLynxAlphaPlayer r1, String r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // java.util.concurrent.Callable
        public final e76.c<Bitmap> call() {
            Ref.ObjectRef r0 = new Ref.ObjectRef();
            r0.element = null;
            this.a.S(this.b, new a(this, r0));
            return new e76.c((Bitmap) r0.element);
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Object call() {
            return call();
        }
    }

    public static final class g<T> implements e76.b {
        public final /* synthetic */ LiveLynxAlphaPlayer a;

        public g(LiveLynxAlphaPlayer r1) {
            this.a = r1;
        }

        public final void onResult(Object r4) {
            Bitmap r5 = (Bitmap) r4;
            LiveLynxAlphaPlayer r0 = this.a;
            if (r5 == null) goto L9;
            DataSource r1 = r0.c;
            if (r1 == null) goto L7;
            r1.g = true;
        L7:
            r0.f = r5;
            LiveLynxAlphaPlayer.M(r0).setMLastFrame(r0.f);
            LiveLynxAlphaPlayer.M(r0).setMIsShowLastFrame(true);
            return;
        }
    }

    public static final class h<T> implements e76.b {
        public final /* synthetic */ LiveLynxAlphaPlayer a;
        public final /* synthetic */ String b;

        public h(LiveLynxAlphaPlayer r1, String r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void onResult(Object r4) {
            Throwable r5 = (Throwable) r4;
            LiveLynxAlphaPlayer r0 = this.a;
            DataSource r1 = r0.c;
            if (r1 == null) goto L5;
            r1.g = true;
        L5:
            r0.Q("set video lastFrame failed, lastFrame is " + this.b + ", error msg is " + r5, this.a.g, -16);
            throw null;
        }
    }

    public static final class i<V> implements Callable {
        public final /* synthetic */ LiveLynxAlphaPlayer a;
        public final /* synthetic */ String b;

        public static final class a implements a {
            public final /* synthetic */ i a;
            public final /* synthetic */ Ref.ObjectRef b;

            @Override // com.bytedance.android.live.lynx.ui.LiveLynxAlphaPlayer.a
            public final void onFailed() {
                this.a.a.Q("set video poster failed, poster is " + this.a.b, this.a.a.g, -15);
                throw null;
            }

            @Override // com.bytedance.android.live.lynx.ui.LiveLynxAlphaPlayer.a
            public final void onSuccess(Bitmap r2) {
                if (r2 == null) goto L5;
                this.b.element = r2;
                return;
            }

            public a(i r1, Ref.ObjectRef r2) {
                this.a = r1;
                this.b = r2;
            }
        }

        public i(LiveLynxAlphaPlayer r1, String r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // java.util.concurrent.Callable
        public final e76.c<Bitmap> call() {
            Ref.ObjectRef r0 = new Ref.ObjectRef();
            r0.element = null;
            this.a.S(this.b, new a(this, r0));
            return new e76.c((Bitmap) r0.element);
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Object call() {
            return call();
        }
    }

    public static final class j<T> implements e76.b {
        public final /* synthetic */ LiveLynxAlphaPlayer a;

        public j(LiveLynxAlphaPlayer r1) {
            this.a = r1;
        }

        public final void onResult(Object r3) {
            Bitmap r4 = (Bitmap) r3;
            LiveLynxAlphaPlayer r0 = this.a;
            if (r4 == null) goto L6;
            LiveLynxAlphaPlayer.M(r0).setMPoster(r4);
            LiveLynxAlphaPlayer.M(r0).setMIsShowPoster(true);
            LiveLynxAlphaPlayer.M(r0).invalidate();
            return;
        }
    }

    public static final class k<T> implements e76.b {
        public final /* synthetic */ LiveLynxAlphaPlayer a;
        public final /* synthetic */ String b;

        public k(LiveLynxAlphaPlayer r1, String r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void onResult(Object r4) {
            this.a.Q("set video poster failed, poster is " + this.b + ", error msg is " + ((Throwable) r4), this.a.g, -15);
            throw null;
        }
    }

    static {
    }

    public final void destroy() {
        super/*com.lynx.tasm.behavior.ui.UIGroup*/.destroy();
        IPlayerController r0 = this.a;
        if (r0 == null) goto L5;
        r0.detachAlphaView((ViewGroup) ((LynxUI) this).mView);
    L5:
        IPlayerController r1 = this.a;
        if (r1 == null) goto L8;
        r1.g(null);
    L8:
        IPlayerController r2 = this.a;
        if (r2 == null) goto L11;
        r2.c(null);
    L11:
        this.a = null;
        ((LynxAlphaVideoViewCompat) ((LynxUI) this).mView).setMPoster(null);
        ((LynxAlphaVideoViewCompat) ((LynxUI) this).mView).setMLastFrame(null);
    }

    public final void onAttach() {
        super/*com.lynx.tasm.behavior.ui.UIGroup*/.onAttach();
        IPlayerController r0 = this.a;
        if (r0 != null) goto L5;
        return;
    L5:
        if (this.d == false) goto L10;
        if (r0 == null) goto L11;
        r0.attachAlphaView((ViewGroup) ((LynxUI) this).mView);
        return;
    L11:
        return;
    }

    public final void onDetach() {
        super/*com.lynx.tasm.behavior.ui.UIGroup*/.onDetach();
        IPlayerController r0 = this.a;
        if (r0 == null) goto L7;
        if (r0 == null) goto L8;
        r0.detachAlphaView((ViewGroup) ((LynxUI) this).mView);
        return;
    L8:
        return;
    }

    public final void onLayoutUpdated() {
        super/*com.lynx.tasm.behavior.ui.LynxUI*/.onLayoutUpdated();
        IPlayerController r0 = this.a;
        if (r0 == null) goto L8;
        View r1 = r0.getView();
        if (r1 == null) goto L9;
        r1.layout(0, 0, getWidth(), getHeight());
        return;
    L9:
        return;
    }

    public static final /* synthetic */ LynxAlphaVideoViewCompat M(LiveLynxAlphaPlayer r0) {
        return (LynxAlphaVideoViewCompat) ((LynxUI) r0).mView;
    }

    public final DataSource O(String r6) {
        StringBuilder r0 = new StringBuilder();
        BufferedReader r1 = new BufferedReader(new PolarisFileReaderWrapper(r6 + "config.json"));
    L35:
        String r2 = r1.readLine();     // Catch: Throwable -> L28
        if (r2 == null) goto L6;
        r0.append(r2);     // Catch: Throwable -> L28
        r0.append("\n");     // Catch: Throwable -> L28
        goto L35
    L6:
        Unit r3 = Unit.INSTANCE;     // Catch: Throwable -> L28
        CloseableKt.closeFinally(r1, null);
        y r4 = (y) GsonProtectorUtils.fromJson(e76.a.a, r0.toString(), y.class);     // Catch: JsonSyntaxException -> L25
        if (r4 == null) goto L23;
        DataSource r5 = new DataSource();
        if (r4.portrait == null) goto L14;
        DataSource.DataInfo r7 = new DataSource.DataInfo(r6 + r4.portrait.path);
        r7.d(r4.portrait.align);
        y.a r8 = r4.portrait;
        r7.j = r8.version;
        r7.c = r8.totalFrame;
        r7.f = r8.videoWidth;
        r7.g = r8.videoHeight;
        r7.h = r8.actualWidth;
        r7.i = r8.actualHeight;
        r7.b(r8.alphaFrame);
        r7.c(r4.portrait.rgbFrame);
        r7.k = r4.portrait.masks;
        r5.c(r7);
    L14:
        if (r4.landscape == null) goto L16;
        DataSource.DataInfo r9 = new DataSource.DataInfo(r6 + r4.landscape.path);
        r9.d(r4.landscape.align);
        y.a r10 = r4.landscape;
        r9.j = r10.version;
        r9.c = r10.totalFrame;
        r9.f = r10.videoWidth;
        r9.g = r10.videoHeight;
        r9.h = r10.actualWidth;
        r9.i = r10.actualHeight;
        r9.b(r10.alphaFrame);
        r9.c(r4.landscape.rgbFrame);
        r9.k = r4.landscape.masks;
        r5.b(r9);
    L16:
        Object r11 = getProps().get("keep-last-frame");
        Boolean r12 = Boolean.TRUE;
        if (Intrinsics.areEqual(r11, r12) == false) goto L20;
        r5.g = false;
    L20:
        if (Intrinsics.areEqual(getProps().get("loop"), r12) == false) goto L22;
        r5.d = true;
    L22:
        return r5;
    L23:
        Q("fileModel is null", this.g, -14);
        throw null;
    L25:
        e = move-exception;
        Q("parse config.json failed, error msg is " + e, this.g, -3);
        throw null;
    L28:
        th = move-exception;
        throw th;     // Catch: Throwable -> L30
    L30:
        th = move-exception;
        CloseableKt.closeFinally(r1, th);
        throw th;
    }

    public final void R(String r8) {
        LLog.i("x-alpha-video", "legacySetSrc, directUrl is " + r8);     // Catch: Exception -> L42
        if (r8 == null) goto L52;
        Uri r2 = UriProtector.parse(r8);     // Catch: Exception -> L42
        this.c = null;     // Catch: Exception -> L42
        String r4 = r2.getScheme();     // Catch: Exception -> L42
        if (r4 == null) goto L41;
        int r5 = r4.hashCode();     // Catch: Exception -> L42
        if (r5 == 3143036) goto L26;
        if (r5 == 3213448) goto L19;
        if (r5 == 99617003) goto L16;
        return;
    L16:
        if (r4.equals("https") == true) goto L21;
        return;
    L21:
        if (StringsKt.endsWith$default(r8, ".zip", false, 2, null) == false) goto L23;
        Downloader.with(getLynxContext()).url(r8).name(r2.getLastPathSegment()).savePath(getLynxContext().getApplicationContext().getCacheDir().getAbsolutePath()).monitorScene("live_gift_lynx_alpha_player").mainThreadListener(new c(this, r8, r2)).download();     // Catch: Exception -> L42
        return;
    L23:
        Q("resource type is not support", this.g, -13);     // Catch: Exception -> L42
        throw null;     // Catch: Exception -> L42
    L19:
        if (r4.equals("http") == true) goto L21;
        return;
    L26:
        if (r4.equals("file") == false) goto L51;
        this.c = O(r2.getPath() + '/');     // Catch: Exception -> L38
        sendEvent("ready", P(1, "load resource success", null));     // Catch: Exception -> L38
        if (this.c != null) goto L30;
        return;
    L30:
        if (this.d == false) goto L55;
        IPlayerController r3 = this.a;     // Catch: Exception -> L38
        if (r3 == null) goto L34;
        r3.attachAlphaView((ViewGroup) ((LynxUI) this).mView);     // Catch: Exception -> L38
    L34:
        IPlayerController r6 = this.a;     // Catch: Exception -> L38
        if (r6 == null) goto L56;
        r6.d(this.c);     // Catch: Exception -> L38
    L57:
        return;
    L56:
        return;
    L55:
        return;
    L38:
        e = move-exception;
        Q("parse config.json failed, resource is " + r8 + ", error msg is " + e, this.g, -3);     // Catch: Exception -> L42
        throw null;     // Catch: Exception -> L42
    L51:
        return;
    L41:
        return;
    L52:
        return;
    L42:
        e = move-exception;
        LLog.e("x-alpha-video", e.toString());
    }

    public final View createView(Context r5) {
        LifecycleOwnerCompat r0 = new LynxAlphaVideoViewCompat(r5);
        Configuration r1 = new Configuration();
        r1.a = r5;
        r1.b = r0;
        r1.c = 1;
        com.bytedance.android.live.lynx.ui.d r2 = new com.bytedance.android.live.lynx.ui.d(this);
        com.bytedance.android.live.lynx.ui.e r3 = new com.bytedance.android.live.lynx.ui.e(this);
        IPlayerController r6 = jc1.k.n(IGiftServiceExternal.class).getCommonPlayerControllerManager().a(r5);     // Catch: Exception -> L14
        this.a = r6;
        if (r6 == null) goto L7;
        r6.g(r2);
    L7:
        IPlayerController r7 = this.a;
        if (r7 == null) goto L10;
        r7.c(r3);
    L10:
        IPlayerController r8 = this.a;
        if (r8 == null) goto L13;
        r8.b(new com.bytedance.android.live.lynx.ui.c(this), 5);
    L13:
        return r0;
    L14:
        e = move-exception;
        Q("init CustomPlayerImpl failed and try to use DefaultSystemPlayer, the exception is " + e, this.g, -10);
        throw null;
    }

    @LynxProp(defaultBoolean = true, name = "autoplay")
    public final void setAutoPlay(boolean r2) {
        this.d = r2;
        Object r0 = ((LynxUI) this).mView;
        if (r0 == null) goto L7;
        ((LynxAlphaVideoViewCompat) r0).setMAutoPlay(r2);
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.lynx.ui.LynxAlphaVideoViewCompat");
    }

    public final void setEvents(Map<String, EventsListener> r1) {
        super/*com.lynx.tasm.behavior.ui.LynxBaseUI*/.setEvents(r1);
        if (r1 == null) goto L5;
        Set<String> r2 = r1.keySet();
    L6:
        this.b = r2;
        return;
    L5:
        r2 = null;
        goto L6
    }

    @LynxProp(defaultBoolean = BuildConfig.DEBUG, name = "keep-last-frame")
    public final void setKeepLastFrame(boolean r3) {
        if (this.e == r3) goto L9;
        DataSource r0 = this.c;
        if (r0 == null) goto L7;
        r0.g = !r3;
    L7:
        this.e = r3;
        return;
    }

    @LynxProp(name = "last-frame")
    public final void setLastFrame(String r3) {
        Intrinsics.checkNotNullParameter(r3, "lastFrame");
        e76.e r0 = new e76.e(new f(this, r3));
        r0.c(new g(this));
        r0.b(new h(this, r3));
    }

    @LynxProp(defaultBoolean = BuildConfig.DEBUG, name = "loop")
    public final void setLoop(boolean r2) {
        DataSource r0 = this.c;
        if (r0 == null) goto L6;
        r0.d = r2;
        return;
    }

    @LynxProp(name = "poster")
    public final void setPoster(String r3) {
        Intrinsics.checkNotNullParameter(r3, "poster");
        e76.e r0 = new e76.e(new i(this, r3));
        r0.c(new j(this));
        r0.b(new k(this, r3));
    }

    @LynxProp(name = "src")
    public final void setSrc(String r3) {
        if (TextUtils.isEmpty(r3) == false) goto L5;
        return;
    L5:
        IPlayerController r0 = this.a;
        if (r0 == null) goto L8;
        r0.detachAlphaView((ViewGroup) ((LynxUI) this).mView);
    L8:
        this.c = null;
        this.g = "";
        String r4 = URLDecoder.decode(d7a.a.b(getLynxContext(), r3, false), "UTF-8");
        this.g = r4;
        R(r4);
    }

    public final void S(String r5, a r6) {
        Intrinsics.checkNotNullParameter(r5, "url");
        Intrinsics.checkNotNullParameter(r6, "callback");
        ImageRequest r7 = ImageRequestBuilder.newBuilderWithSource(UriProtector.parse(d7a.a.b(getLynxContext(), r5, false))).build();
        com.facebook.datasource.DataSource r8 = Fresco.getImagePipeline().fetchDecodedImage(r7, "x-alpha-video");
        if (r8 != null) goto L6;
        r6.onFailed();
        return;
    L6:
        CountDownLatch r0 = new CountDownLatch(1);
        d r1 = new d(r6, r0, r8);
        r8.subscribe(r1, CallerThreadExecutor.getInstance());
    L11:
        r1.onFailure(r8);
        return;
    L8:
        if (r0.await(3, TimeUnit.SECONDS) == true) goto L15;
        r1.onFailure(r8);     // Catch: InterruptedException -> L11
        return;
    }

    @LynxUIMethod
    public final void getDuration(ReadableMap r8, Callback r9) {
        Intrinsics.checkNotNullParameter(r8, "params");
        Intrinsics.checkNotNullParameter(r9, "callback");
        JavaOnlyMap r10 = new JavaOnlyMap();
        if (((LynxUI) this).mView != null) goto L5;
    L14:
        r10.putString(MultiLinkOpenSource.MESSAGE, "view is not exist");
        r9.invoke(new Object[]{1, r10});
        return;
    L5:
        if (this.a == null) goto L14;
        r10.putBoolean("success", true);     // Catch: Exception -> L12
        IPlayerController r0 = this.a;     // Catch: Exception -> L12
        if (r0 == null) goto L9;
        int r1 = r0.getDuration();     // Catch: Exception -> L12
    L10:
        JavaOnlyMap r5 = new JavaOnlyMap();     // Catch: Exception -> L12
        r5.putInt("duration", r1);     // Catch: Exception -> L12
        r10.putMap("data", r5);     // Catch: Exception -> L12
        r9.invoke(new Object[]{0, r10});     // Catch: Exception -> L12
        return;
    L9:
        r1 = 0;
    L12:
        e = move-exception;
        r10.putString("message:", e.getMessage());
        r9.invoke(new Object[]{1, r10});
    }

    @LynxUIMethod
    public final void isPlaying(ReadableMap r8, Callback r9) {
        Intrinsics.checkNotNullParameter(r8, "params");
        Intrinsics.checkNotNullParameter(r9, "callback");
        JavaOnlyMap r10 = new JavaOnlyMap();
        if (((LynxUI) this).mView != null) goto L5;
    L16:
        r10.putString(MultiLinkOpenSource.MESSAGE, "view is not exist");
        r9.invoke(new Object[]{1, r10});
        return;
    L5:
        if (this.a == null) goto L16;
        r10.putBoolean("success", true);     // Catch: Exception -> L14
        IPlayerController r0 = this.a;     // Catch: Exception -> L14
        if (r0 != null) goto L9;
    L11:
        boolean r1 = false;
    L12:
        JavaOnlyMap r5 = new JavaOnlyMap();     // Catch: Exception -> L14
        r5.putBoolean("isPlaying", r1);     // Catch: Exception -> L14
        r10.putMap("data", r5);     // Catch: Exception -> L14
        r9.invoke(new Object[]{0, r10});     // Catch: Exception -> L14
        return;
    L9:
        if (r0.isPlaying() != true) goto L11;
        r1 = true;
    L14:
        e = move-exception;
        r10.putString("message:", e.getMessage());
        r9.invoke(new Object[]{1, r10});
    }

    @LynxUIMethod
    public final void pause(ReadableMap r7, Callback r8) {
        Intrinsics.checkNotNullParameter(r7, "params");
        Intrinsics.checkNotNullParameter(r8, "callback");
        JavaOnlyMap r9 = new JavaOnlyMap();
        if (((LynxUI) this).mView == null) goto L13;
        IPlayerController r0 = this.a;
        if (r0 == null) goto L13;
        if (r0 != null) goto L15;
    L10:
        r8.invoke(new Object[]{0, r9});     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        r9.putString("message:", e.getMessage());
        r8.invoke(new Object[]{1, r9});
        return;
    L15:
        r0.pause();     // Catch: Exception -> L8
    L13:
        r9.putString(MultiLinkOpenSource.MESSAGE, "view is not exist");
        r8.invoke(new Object[]{1, r9});
    }

    @LynxUIMethod
    public final void play(ReadableMap r7, Callback r8) {
        Intrinsics.checkNotNullParameter(r7, "params");
        Intrinsics.checkNotNullParameter(r8, "callback");
        JavaOnlyMap r9 = new JavaOnlyMap();
        if (((LynxUI) this).mView == null) goto L23;
        IPlayerController r0 = this.a;
        if (r0 == null) goto L23;
        if (r0 != null) goto L25;
    L20:
        r8.invoke(new Object[]{1, r9});     // Catch: Exception -> L18
        return;
    L25:
    L18:
        e = move-exception;
        r9.putString("message:", e.getMessage());
        r8.invoke(new Object[]{1, r9});
        return;
    L8:
        if (r0.isPlaying() == true) goto L20;
        if (this.c == null) goto L20;
        IPlayerController r1 = this.a;     // Catch: Exception -> L18
        if (r1 == null) goto L14;
        r1.attachAlphaView((ViewGroup) ((LynxUI) this).mView);     // Catch: Exception -> L18
    L14:
        IPlayerController r2 = this.a;     // Catch: Exception -> L18
        if (r2 == null) goto L17;
        r2.d(this.c);     // Catch: Exception -> L18
    L17:
        r8.invoke(new Object[]{0, r9});     // Catch: Exception -> L18
        return;
    L23:
        r9.putString(MultiLinkOpenSource.MESSAGE, "view is not exist");
        r8.invoke(new Object[]{1, r9});
    }

    @LynxUIMethod
    public final void release(ReadableMap r7, Callback r8) {
        Intrinsics.checkNotNullParameter(r7, "params");
        Intrinsics.checkNotNullParameter(r8, "callback");
        JavaOnlyMap r9 = new JavaOnlyMap();
        r9.putBoolean("success", true);
        r9.putMap("data", new JavaOnlyMap());
        if (((LynxUI) this).mView != null) goto L5;
    L10:
        r9.putString(MultiLinkOpenSource.MESSAGE, "view is not exist");
        r8.invoke(new Object[]{1, r9});
        return;
    L5:
        if (this.a == null) goto L10;
        r8.invoke(new Object[]{0, r9});     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        r9.putString("message:", e.getMessage());
        r8.invoke(new Object[]{1, r9});
    }

    @LynxUIMethod
    public final void resume(ReadableMap r7, Callback r8) {
        Intrinsics.checkNotNullParameter(r7, "params");
        Intrinsics.checkNotNullParameter(r8, "callback");
        JavaOnlyMap r9 = new JavaOnlyMap();
        r9.putBoolean("success", true);
        r9.putMap("data", new JavaOnlyMap());
        if (((LynxUI) this).mView == null) goto L18;
        IPlayerController r0 = this.a;
        if (r0 == null) goto L18;
        if (r0.isPlaying() == true) goto L18;
        IPlayerController r1 = this.a;     // Catch: Exception -> L16
        if (r1 == null) goto L11;
        r1.attachAlphaView((ViewGroup) ((LynxUI) this).mView);     // Catch: Exception -> L16
    L11:
        IPlayerController r2 = this.a;     // Catch: Exception -> L16
        if (r2 == null) goto L14;
        r2.resume();     // Catch: Exception -> L16
    L14:
        r8.invoke(new Object[]{0, r9});     // Catch: Exception -> L16
        return;
    L16:
        e = move-exception;
        r9.putString("message:", e.getMessage());
        r8.invoke(new Object[]{1, r9});
        return;
    L18:
        r9.putString(MultiLinkOpenSource.MESSAGE, "view is not exist");
        r8.invoke(new Object[]{1, r9});
    }

    public final void sendEvent(String r4, Map<String, Object> r5) {
        Set<String> r0 = this.b;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.contains(r4) != true) goto L16;
        LynxContext r1 = getLynxContext();
        if (r1 == null) goto L14;
        EventEmitter r2 = r1.getEventEmitter();
        if (r2 == null) goto L15;
        r2.sendCustomEvent(new e(r5, getSign(), r4));
        return;
    L15:
        return;
    L14:
        return;
    }

    @LynxUIMethod
    public final void stop(ReadableMap r7, Callback r8) {
        Intrinsics.checkNotNullParameter(r7, "params");
        Intrinsics.checkNotNullParameter(r8, "callback");
        JavaOnlyMap r9 = new JavaOnlyMap();
        if (((LynxUI) this).mView == null) goto L13;
        IPlayerController r0 = this.a;
        if (r0 == null) goto L13;
        if (r0 != null) goto L15;
    L10:
        r8.invoke(new Object[]{0, r9});     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        r9.putString("message:", e.getMessage());
        r8.invoke(new Object[]{1, r9});
        return;
    L15:
        r0.stop();     // Catch: Exception -> L8
    L13:
        r9.putString(MultiLinkOpenSource.MESSAGE, "view is not exist");
        r8.invoke(new Object[]{1, r9});
    }

    @LynxUIMethod
    public final void subscribeUpdateEvent(ReadableMap r2, Callback r3) {
        Intrinsics.checkNotNullParameter(r2, "params");
        LLog.i("x-alpha-video", "subscribeUpdateEvent: " + r2.getInt("ms"));
        throw null;
    }

    @LynxUIMethod
    public final void unsubscribeUpdateEvent(ReadableMap r1, Callback r2) {
        Intrinsics.checkNotNullParameter(r1, "params");
        r1.getInt("ms");
        throw null;
    }

    public static final void N(LiveLynxAlphaPlayer r2, String r3, String r4) {
        r2.getClass();
        e76.e r0 = new e76.e(new com.bytedance.android.live.lynx.ui.f(r2, r3, r4));
        r0.c(new com.bytedance.android.live.lynx.ui.g(r2));
        r0.b(new com.bytedance.android.live.lynx.ui.h(r2));
    }

    public final Map<String, Object> P(int r2, String r3, JavaOnlyMap r4) {
        LinkedHashMap r5 = new LinkedHashMap();
        r5.put("code", Integer.valueOf(r2));
        r5.put("msg", r3);
        return r5;
    }

    public final void Q(String r1, String r2, int r3) {
        sendEvent("error", P(r3, r1, null));
        throw null;
    }
}
