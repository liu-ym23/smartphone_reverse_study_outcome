package com.lynx.animax.drawable;

import android.graphics.SurfaceTexture;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v4.media.a;
import android.view.Surface;
import android.view.TextureView;
import androidx.fragment.app.d;
import com.lynx.animax.base.CalledByNative;
import com.lynx.animax.util.AnimaXLog;
import im.e;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import jm.c;

/* JADX INFO: loaded from: classes2.dex */
public class FirstFrameAwareSurfaceTexture extends SurfaceTexture implements SurfaceTexture.OnFrameAvailableListener {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ int f9607h = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public WeakReference f9608a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public a f9609b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f9610c;
    public WeakReference d;
    public boolean e;
    public boolean f;
    public WeakReference g;

    public FirstFrameAwareSurfaceTexture() {
        super(0);
        new Handler(Looper.getMainLooper());
        this.e = false;
        this.f = false;
        super.setOnFrameAvailableListener(this, c.a());
    }

    public final void a(SurfaceTexture.OnFrameAvailableListener r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        if (this.f9609b == null) goto L19;
        WeakReference r10 = this.d;
        if (r10 == null) goto L9;
        TextureView r11 = (TextureView) r10.get();
    L10:
        if (r11 == null) goto L20;
        d r12 = new d(r11, 7);
        if (c.i() == false) goto L16;
        r12.run();
        return;
    L16:
        c.a().post(r12);
        return;
    L20:
        return;
    L9:
        r11 = null;
        goto L10
    }

    public final synchronized Surface b() {
        monitor-enter(this);
        WeakReference r5 = this.g;     // Catch: Throwable -> L8
        if (r5 == null) goto L10;
        Surface r10 = (Surface) r5.get();     // Catch: Throwable -> L8
        monitor-exit(this);
        return r10;
    L10:
        monitor-exit(this);
        return null;
    L8:
        th = move-exception;
        throw th;
    }

    public final boolean c() {
        Field r5 = SurfaceTexture.class.getDeclaredField("mOnSetFrameRateHandler");     // Catch: Throwable -> L7
        r5.setAccessible(true);     // Catch: Throwable -> L7
        if (r5.get(this) != null) goto L6;
        return true;
    L6:
        return false;
    L7:
        th = move-exception;
        String r10 = androidx.room.jarjarred.org.antlr.runtime.a.x(th, new StringBuilder("isOnSetFrameRateHandlerNull fail: "));
        AnimaXLog.a(AnimaXLog.LogLevel.f9715c, "AnimaXFirstFrameAwareSurfaceTexture", r10);
        return false;
    }

    @Override // android.graphics.SurfaceTexture
    public final synchronized void finalize() {
        monitor-enter(this);
        this.e = true;     // Catch: Throwable -> L16
        Surface r5 = b();     // Catch: Throwable -> L16
        if (r5 != null) goto L7;
    L18:
        AnimaXLog.a(AnimaXLog.LogLevel.f9713a, "AnimaXFirstFrameAwareSurfaceTexture", "FirstFrameAwareSurfaceTexture finalize: " + this);     // Catch: Throwable -> L16
        super.finalize();     // Catch: Throwable -> L16
        monitor-exit(this);
        return;
    L7:
        if (r5.isValid() == false) goto L18;
        r5.release();     // Catch: Throwable -> L16
        AnimaXLog.a(AnimaXLog.LogLevel.f9713a, "AnimaXFirstFrameAwareSurfaceTexture", "release Surface in finalize: " + r5);     // Catch: Throwable -> L16
        monitor-enter(this);     // Catch: Throwable -> L16
        this.g = new WeakReference(null);     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L16
        goto L18
    L13:
        th = move-exception;
        throw th;     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        throw th;
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public final void onFrameAvailable(SurfaceTexture r5) {
        a r10 = this.f9609b;
        if (r10 == null) goto L6;
        Message r11 = r10.obtainMessage(0);
        r11.setAsynchronous(true);
        this.f9609b.sendMessage(r11);
    L6:
        if (this.f9610c == true) goto L15;
        this.f9610c = true;
        WeakReference r12 = this.f9608a;
        if (r12 == null) goto L10;
        cm.a r13 = (cm.a) r12.get();
    L11:
        AnimaXLog.a(AnimaXLog.LogLevel.f9713a, "AnimaXFirstFrameAwareSurfaceTexture", "trigger first frame callback with " + r13);
        if (r13 == null) goto L16;
        ((e) r13).d();
        return;
    L16:
        return;
    L10:
        r13 = null;
        goto L11
    }

    @Override // android.graphics.SurfaceTexture
    @CalledByNative
    public synchronized void release() {
        monitor-enter(this);
        AnimaXLog.LogLevel r5 = AnimaXLog.LogLevel.f9713a;     // Catch: Throwable -> L8
        AnimaXLog.a(r5, "AnimaXFirstFrameAwareSurfaceTexture", "release with " + this);     // Catch: Throwable -> L8
        if (this.e == false) goto L11;
        AnimaXLog.a(AnimaXLog.LogLevel.f9714b, "AnimaXFirstFrameAwareSurfaceTexture", "release() called after finalize(). Skip releasing SurfaceTexture. " + this);     // Catch: Throwable -> L8
        monitor-exit(this);
        return;
    L11:
        if (this.f == false) goto L16;
        AnimaXLog.a(AnimaXLog.LogLevel.f9714b, "AnimaXFirstFrameAwareSurfaceTexture", "release() called multiple times. " + this);     // Catch: Throwable -> L8
        monitor-exit(this);
        return;
    L16:
        this.f = true;     // Catch: Throwable -> L8
        Surface r10 = b();     // Catch: Throwable -> L8
        if (r10 == null) goto L29;
        if (r10.isValid() == false) goto L29;
        r10.release();     // Catch: Throwable -> L8
        AnimaXLog.a(r5, "AnimaXFirstFrameAwareSurfaceTexture", "release Surface: " + r10);     // Catch: Throwable -> L8
        monitor-enter(this);     // Catch: Throwable -> L8
        this.g = new WeakReference(null);     // Catch: Throwable -> L25
        monitor-exit(this);     // Catch: Throwable -> L8
        goto L29
    L25:
        th = move-exception;
        throw th;     // Catch: Throwable -> L8
    L29:
        if (isReleased() == false) goto L47;
        AnimaXLog.a(AnimaXLog.LogLevel.f9714b, "AnimaXFirstFrameAwareSurfaceTexture", "already released: " + this);     // Catch: Throwable -> L8
        monitor-exit(this);
        return;
    L47:
        Field r11 = SurfaceTexture.class.getDeclaredField("mSurfaceTexture");     // Catch: Throwable -> L35
        r11.setAccessible(true);     // Catch: Throwable -> L35
        long r12 = r11.getLong(this);     // Catch: Throwable -> L35
    L38:
        if (r12 != 0) goto L42;
        AnimaXLog.a(AnimaXLog.LogLevel.f9713a, "AnimaXFirstFrameAwareSurfaceTexture", "surfaceTextureField is 0, skip release");     // Catch: Throwable -> L8
        monitor-exit(this);
        return;
    L42:
        AnimaXLog.a(AnimaXLog.LogLevel.f9713a, "AnimaXFirstFrameAwareSurfaceTexture", "release SurfaceTexture: " + this);     // Catch: Throwable -> L8
        super.release();     // Catch: Throwable -> L8
        monitor-exit(this);
        return;
    L35:
        th = move-exception;
        AnimaXLog.a(AnimaXLog.LogLevel.f9715c, "AnimaXFirstFrameAwareSurfaceTexture", "fail to getSurfaceTextureField: " + th.getMessage());     // Catch: Throwable -> L8
        r12 = -1;
    L8:
        th = move-exception;
        throw th;
    }

    @Override // android.graphics.SurfaceTexture
    public final void setOnFrameAvailableListener(SurfaceTexture.OnFrameAvailableListener r5) {
        a(r5);
        if (r5 == null) goto L6;
        this.f9609b = new a(Looper.getMainLooper(), this, r5);
        return;
    L6:
        this.f9609b = null;
    }

    @Override // android.graphics.SurfaceTexture
    public final void setOnFrameAvailableListener(SurfaceTexture.OnFrameAvailableListener r5, Handler r10) {
        a(r5);
        if (r5 == null) goto L8;
        if (r10 == null) goto L6;
        Looper r11 = r10.getLooper();
    L7:
        this.f9609b = new a(r11, this, r5);
    L10:
        if (Build.VERSION.SDK_INT < 35) goto L14;
        WeakReference r12 = new WeakReference(this);
        AnimaXLog.a(AnimaXLog.LogLevel.f9713a, "AnimaXFirstFrameAwareSurfaceTexture", "clearInternalFrameRateListenerAsync: Posting cleanup action");
        d r13 = new d(r12, 8);
        c.a().post(r13);
        return;
    L14:
        return;
    L6:
        r11 = Looper.getMainLooper();
        goto L7
    L8:
        this.f9609b = null;
        goto L10
    }
}
