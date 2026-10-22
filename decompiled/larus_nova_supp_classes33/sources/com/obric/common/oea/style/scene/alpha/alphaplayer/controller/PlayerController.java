package com.obric.common.oea.style.scene.alpha.alphaplayer.controller;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.view.Surface;
import android.view.ViewGroup;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.apm.impl.protector.RunnableProtector;
import com.obric.common.oea.style.scene.alpha.alphaplayer.model.AlphaVideoViewType;
import com.obric.common.oea.style.scene.alpha.alphaplayer.model.ScaleType;
import com.obric.common.oea.style.scene.alpha.alphaplayer.player.PlayerState;
import com.obric.common.oea.style.scene.alpha.alphaplayer.widget.AlphaVideoGLSurfaceView;
import com.obric.common.oea.style.scene.alpha.alphaplayer.widget.AlphaVideoGLTextureView;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import oja.e;
import oja.f;
import oja.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0001\tJ\b\u0010\u0005\u001a\u00020\u0004H\u0007J\b\u0010\u0006\u001a\u00020\u0004H\u0007J\b\u0010\u0007\u001a\u00020\u0004H\u0007J\b\u0010\b\u001a\u00020\u0004H\u0007¨\u0006\n"}, d2 = {"Lcom/obric/common/oea/style/scene/alpha/alphaplayer/controller/PlayerController;", "Loja/b;", "Landroidx/lifecycle/LifecycleObserver;", "Landroid/os/Handler$Callback;", "", "onPause", "onResume", "onStop", "onDestroy", "a", "style_standardRelease"}, k = 1, mv = {1, 4, 3})
public class PlayerController implements oja.b, LifecycleObserver, Handler.Callback {
    public static final /* synthetic */ int n = 0;
    public final Context a;
    public final LifecycleOwner b;
    public qja.c c;
    public tja.a d;
    public pja.b e;
    public boolean f;
    public PlayerState g;
    public nja.b h;
    public Handler i;
    public final Handler j;
    public PthreadHandlerThreadV2 k;
    public final g l;
    public final f m;

    public static final class a {
    }

    public static final class b implements Runnable {
        public final /* synthetic */ PlayerController a;

        public b(PlayerController r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            nja.b r0 = this.a.h;     // Catch: Throwable -> L6
            if (r0 == null) goto L9;
            r0.b();     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }
    }

    public static final class c implements Runnable {
        public final /* synthetic */ PlayerController a;
        public final /* synthetic */ pja.c b;
        public final /* synthetic */ ScaleType c;

        public c(PlayerController r1, pja.c r2, ScaleType r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        @Override // java.lang.Runnable
        public final void run() {
            nja.b r0 = this.a.h;     // Catch: Throwable -> L6
            if (r0 == null) goto L9;
            int r1 = this.b.a / 2;     // Catch: Throwable -> L6
            r0.c(this.c);     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }
    }

    public static final class d implements Runnable {
        public final /* synthetic */ PlayerController a;

        public d(PlayerController r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            nja.b r0 = this.a.h;     // Catch: Throwable -> L6
            if (r0 == null) goto L9;
            r0.a();     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }
    }

    static {
    }

    public final void b() {
        this.f = false;
        this.j.post(new b(this));
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public final void onDestroy() {
        e(c(7, null));
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public final void onPause() {
        e(c(4, null));
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public final void onStop() {
        e(c(6, null));
    }

    @Override // oja.a
    public final void resume() {
        e(c(5, null));
    }

    public final void d() {
        pja.c r0 = this.c.getVideoInfo();
        tja.a r1 = this.d;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("alphaVideoView");
    L5:
        r1.c(r0.a / 2, r0.b);
        tja.a r2 = this.d;
        if (r2 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("alphaVideoView");
    L8:
        this.j.post(new c(this, r0, r2.getScaleType()));
    }

    public final void g() {
        PlayerState r0 = this.g;
        int r1 = oja.c.b[r0.ordinal()];
        if (r1 != 1) goto L5;
        this.c.start();
        this.f = true;
        this.g = PlayerState.STARTED;
        this.j.post(new d(this));
        return;
    L5:
        if (r1 != 2) goto L7;
        this.c.start();
        this.g = PlayerState.STARTED;
        return;
    L7:
        if (r1 != 3) goto L9;
    L24:
        qja.c r2 = this.c;     // Catch: Exception -> L16
        PlayerState r3 = this.g;     // Catch: Exception -> L16
        if (r3 != PlayerState.NOT_PREPARED) goto L14;
    L18:
        r2.f(this.l);     // Catch: Exception -> L16
        r2.h(this.m);     // Catch: Exception -> L16
        r2.prepareAsync();     // Catch: Exception -> L16
        return;
    L14:
        if (r3 == PlayerState.STOPPED) goto L18;
        return;
    L16:
        e = move-exception;
        e.printStackTrace();
        b();
        return;
    L9:
        if (r1 == 4) goto L24;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public final void onResume() {
        resume();
    }

    public PlayerController(pja.a r5) {
        Intrinsics.checkNotNullParameter(r5, "configuration");
        this.g = PlayerState.NOT_PREPARED;
        this.j = new Handler(Looper.getMainLooper());
        this.l = new g(this);
        this.m = new f(this);
        Context r0 = r5.getContext();
        this.a = r0;
        LifecycleOwner r1 = r5.c;
        this.b = r1;
        AlphaVideoViewType r6 = r5.a;
        this.c = new qja.b();
        r1.getLifecycle().addObserver(this);
        PthreadHandlerThreadV2 r2 = new PthreadHandlerThreadV2("alpha-play-thread", 10);
        this.k = r2;
        Intrinsics.checkNotNull(r2);
        ThreadMethodProxy.start(r2);
        PthreadHandlerThreadV2 r3 = this.k;
        Intrinsics.checkNotNull(r3);
        this.i = new Handler(r3.getLooper(), this);
        int r7 = oja.c.a[r6.ordinal()];
        if (r7 != 1) goto L5;
        tja.a r8 = new AlphaVideoGLSurfaceView(r0, null);
    L10:
        this.d = r8;
        r8.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        r8.setPlayerController(this);
        r8.setVideoRenderer(new rja.b(r8));
        e(c(1, null));
        return;
    L5:
        if (r7 != 2) goto L8;
        r8 = new AlphaVideoGLTextureView(this.a, null);
        goto L10
    L8:
        throw new NoWhenBranchMatchedException();
    }

    @Override // oja.b
    public final void a(Surface r2) {
        Intrinsics.checkNotNullParameter(r2, "surface");
        e(c(8, r2));
    }

    public final void e(Message r4) {
        PthreadHandlerThreadV2 r0 = this.k;
        if (r0 != null) goto L5;
        return;
    L5:
        if (ThreadMethodProxy.isAlive(r0) == true) goto L7;
        return;
    L7:
        if (r0.isInterrupted() == false) goto L9;
        return;
    L9:
        if (this.i != null) goto L11;
        this.i = new Handler(r0.getLooper(), this);
    L11:
        Handler r1 = this.i;
        Intrinsics.checkNotNull(r1);
        r1.sendMessageDelayed(r4, 0);
    }

    public final void f(pja.b r4) {
        this.c.reset();
        PlayerState r0 = PlayerState.NOT_PREPARED;
        this.g = r0;
        int r1 = this.a.getResources().getConfiguration().orientation;
        Intrinsics.throwUninitializedPropertyAccessException("baseDir");
        if (1 != r1) goto L5;
        String r2 = "portPath";
    L6:
        Intrinsics.throwUninitializedPropertyAccessException(r2);
        if (TextUtils.isEmpty("nullnull") == false) goto L9;
    L23:
        b();
        return;
    L9:
        if (new PolarisFileWrapper("nullnull").exists() == false) goto L23;
        this.c.c();
        this.c.d();
        tja.a r3 = this.d;
        if (r3 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("alphaVideoView");
    L15:
        if (r3.a() == false) goto L21;
        qja.c r5 = this.c;
        PlayerState r6 = this.g;
        if (r6 != r0) goto L19;
    L20:
        r5.f(this.l);
        r5.h(this.m);
        r5.prepareAsync();
        return;
    L19:
        if (r6 == PlayerState.STOPPED) goto L20;
        return;
    L21:
        this.e = r4;
        return;
    L5:
        r2 = "landPath";
        goto L6
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message r4) {
        Intrinsics.checkNotNullParameter(r4, "msg");
        switch(r4.what) {
            case 1: goto L61;
            case 2: goto L46;
            case 3: goto L63;
            case 4: goto L38;
            case 5: goto L36;
            case 6: goto L29;
            case 7: goto L14;
            case 8: goto L6;
            case 9: goto L5;
            default: goto L60;
        };
    L5:
        this.c.reset();
        this.g = PlayerState.NOT_PREPARED;
        this.f = false;
        goto L60
    L6:
        Object r5 = r4.obj;
        if (r5 == null) goto L13;
        qja.c r0 = this.c;
        r0.setSurface((Surface) r5);
        pja.b r6 = this.e;
        if (r6 == null) goto L11;
        f(r6);
    L11:
        this.e = null;
        goto L60
    L13:
        throw new NullPointerException("null cannot be cast to non-null type android.view.Surface");
    L14:
        tja.a r7 = this.d;
        if (r7 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("alphaVideoView");
    L17:
        r7.onPause();
        if (this.g != PlayerState.STARTED) goto L21;
        this.c.pause();
        this.g = PlayerState.PAUSED;
    L21:
        if (this.g != PlayerState.PAUSED) goto L23;
        this.c.stop();
        this.g = PlayerState.STOPPED;
    L23:
        this.c.release();
        tja.a r8 = this.d;
        if (r8 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("alphaVideoView");
    L26:
        r8.release();
        this.g = PlayerState.RELEASE;
        PthreadHandlerThreadV2 r9 = this.k;
        if (r9 == null) goto L60;
        r9.quit();
        r9.interrupt();
        goto L60
    L29:
        PlayerState r10 = this.g;
        int r11 = oja.c.d[r10.ordinal()];
        if (r11 != 1) goto L32;
    L34:
        this.c.pause();
        this.g = PlayerState.PAUSED;
        goto L60
    L32:
        if (r11 == 2) goto L34;
    L38:
        PlayerState r12 = this.g;
        if (oja.c.c[r12.ordinal()] != 1) goto L60;
        this.c.pause();
        this.g = PlayerState.PAUSED;
        goto L60
    L46:
        Object r13 = r4.obj;
        if (r13 == null) goto L54;
        f((pja.b) r13);     // Catch: Exception -> L51
    L51:
        e = move-exception;
        e.printStackTrace();
        Log.getStackTraceString(e);
        b();
        goto L60
    L54:
        throw new NullPointerException("null cannot be cast to non-null type com.obric.common.oea.style.scene.alpha.alphaplayer.model.DataSource");
    L60:
        return true;
    L61:
        this.c.b();     // Catch: Exception -> L57
    L59:
        this.c.a();
        this.c.c();
        this.c.g(new oja.d(this));
        this.c.e(new e(this));
    L57:
        e = move-exception;
        qja.b r1 = new qja.b();
        this.c = r1;
        r1.b();
        e.getMessage();
        goto L59
    L63:
        d();     // Catch: Exception -> L44
        this.g = PlayerState.PREPARED;     // Catch: Exception -> L44
        g();     // Catch: Exception -> L44
        Unit r14 = Unit.INSTANCE;     // Catch: Exception -> L44
    L44:
        e = move-exception;
        Log.getStackTraceString(e);
        b();
        Unit r15 = Unit.INSTANCE;
        goto L60
    L36:
        if (this.f == false) goto L60;
        g();
        goto L60
    }

    public static Message c(int r1, Object r2) {
        Message r0 = Message.obtain();
        r0.what = r1;
        r0.obj = r2;
        return r0;
    }
}
