package com.larus.dora.impl.view;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.TypedArray;
import android.graphics.SurfaceTexture;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.TextureView;
import android.widget.FrameLayout;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.platform.api.z3;
import com.larus.platform.service.q3;
import com.ss.ttvideoengine.TTVideoEngine;
import kotlin.Lazy;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public class DoraMovieView extends FrameLayout {
    public static final /* synthetic */ int r = 0;
    public TTVideoEngine a;
    public int b;
    public String c;
    public int d;
    public int e;
    public final TextureView f;
    public int g;
    public SurfaceTexture h;
    public e i;
    public d j;
    public Boolean k;
    public Boolean l;
    public Boolean m;
    public final int n;
    public final int o;
    public c p;
    public final Handler q;

    public class a implements TextureView.SurfaceTextureListener {
        public final /* synthetic */ DoraMovieView a;

        public a(DoraMovieView r1) {
            this.a = r1;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public final boolean onSurfaceTextureDestroyed(SurfaceTexture r3) {
            g49.d.a("DoraMovieView", "MovieView ---onSurfaceTextureDestroyed");
            this.a.h = r3;
            return true;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public final void onSurfaceTextureUpdated(SurfaceTexture r2) {
            this.a.h = r2;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public final void onSurfaceTextureAvailable(SurfaceTexture r1, int r2, int r3) {
            g49.d.a("DoraMovieView", "MovieView ---onSurfaceTextureAvailable");
            DoraMovieView r4 = this.a;
            r4.h = r1;
            if (r4.a != null) goto L5;
            r4.c(new Surface(r1));
            return;
        L5:
            r4.e();
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public final void onSurfaceTextureSizeChanged(SurfaceTexture r1, int r2, int r3) {
            this.a.h = r1;
        }
    }

    public class b implements Handler.Callback {
        public final /* synthetic */ DoraMovieView a;

        public b(DoraMovieView r1) {
            this.a = r1;
        }

        @Override // android.os.Handler.Callback
        public final boolean handleMessage(Message r2) {
            if (r2.what != 1000) goto L8;
            DoraMovieView r3 = this.a;
            int r0 = DoraMovieView.r;
            r3.getClass();
            return false;
        L8:
            return false;
        }
    }

    public interface c {
        void a();
    }

    public interface d {
        void onFirstFrameRendered();
    }

    public interface e {
        void onStart();
    }

    public interface f {
    }

    public void setOnProgressListener(f r1) {
    }

    public final boolean a() {
        TTVideoEngine r0 = this.a;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.getPlaybackState() != 1) goto L7;
        return true;
    }

    public final void b() {
        g49.d.a("DoraMovieView", "MovieView loopplay: " + this.a + " - " + a());
        TTVideoEngine r0 = this.a;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.setLooping(true);
        this.a.play();
        this.q.sendEmptyMessage(1000);
        setKeepScreenOn(true);
    }

    public final void d() {
        g49.d.a("DoraMovieView", "MovieView pause: " + this.a + " - " + a());
        TTVideoEngine r0 = this.a;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.pause();
        if (this.q.hasMessages(1000) == false) goto L8;
        this.q.removeMessages(1000);
    L8:
        setKeepScreenOn(false);
    }

    public final void e() {
        g49.d.a("DoraMovieView", "MovieView play: " + this.a + " - " + a());
        TTVideoEngine r0 = this.a;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.play();
        this.q.sendEmptyMessage(1000);
        setKeepScreenOn(true);
    }

    public final void f() {
        TTVideoEngine r0 = this.a;
        if (r0 == null) goto L6;
        r0.release();
        this.a = null;
    L6:
        if (this.q.hasMessages(1000) == false) goto L9;
        this.q.removeMessages(1000);
        return;
    }

    public final void g() {
        g49.d.a("DoraMovieView", "MovieView stop: " + this.a + " - " + a());
        TTVideoEngine r0 = this.a;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.stop();
        if (this.q.hasMessages(1000) == false) goto L8;
        this.q.removeMessages(1000);
    L8:
        setKeepScreenOn(false);
    }

    public int getCurrentPosition() {
        TTVideoEngine r0 = this.a;
        if (r0 != null) goto L5;
        return 0;
    L5:
        return r0.getCurrentPlaybackTime();
    }

    public int getDuration() {
        TTVideoEngine r0 = this.a;
        if (r0 != null) goto L5;
        return 0;
    L5:
        return r0.getDuration();
    }

    public DoraMovieView(Context r2) {
        this(r2, null);
    }

    public final void c(Surface r7) {
        if (this.b == 0) goto L5;
    L7:
        Lazy r0 = q3.a;
        z3 r1 = q3.a();
        if (r1 == null) goto L10;
        r1.j();
    L10:
        TTVideoEngine r2 = new TTVideoEngine(getContext(), 0);
        this.a = r2;
        r2.setIntOption(4, 1);
        this.a.setSurface(r7);
        this.a.setLooping(this.k.booleanValue());
        if (this.b == 0) goto L13;
        AssetFileDescriptor r8 = getResources().openRawResourceFd(this.b);
        this.a.setDataSource(r8.getFileDescriptor(), r8.getStartOffset(), r8.getLength());
    L14:
        this.a.setVideoEngineCallback(new com.larus.dora.impl.view.a(this));
        this.a.prepare();
        return;
    L13:
        PolarisFileWrapper r9 = new PolarisFileWrapper(this.c);
        this.a.setLocalURL(r9.getAbsolutePath());
        goto L14
    L5:
        if (TextUtils.isEmpty(this.c) == false) goto L7;
    }

    public void setDataSource(int r7) {
    L10:
        e = move-exception;
        throw new RuntimeException(e);
    L3:
        if (this.a != null) goto L5;
        return;
    L5:
        g49.d.a("DoraMovieView", "setDataSource videoResourceId start");     // Catch: Exception -> L10
        if (r7 == this.b) goto L15;
        if (r7 == 0) goto L16;
        this.b = r7;     // Catch: Exception -> L10
        this.a.stop();     // Catch: Exception -> L10
        AssetFileDescriptor r8 = getResources().openRawResourceFd(this.b);     // Catch: Exception -> L10
        this.a.setDataSource(r8.getFileDescriptor(), r8.getStartOffset(), r8.getLength());     // Catch: Exception -> L10
        return;
    L16:
        return;
    }

    public void setDoraMovieCallback(c r1) {
        this.p = r1;
    }

    public void setEngineLooping(boolean r2) {
        TTVideoEngine r0 = this.a;
        if (r0 == null) goto L6;
        r0.setLooping(r2);
        return;
    }

    public void setFirstFrameRenderedListener(d r1) {
        this.j = r1;
    }

    public void setLooping(Boolean r1) {
        this.k = r1;
    }

    public void setMediaPlayerStartListener(e r1) {
        this.i = r1;
    }

    public void setPauseInFirst(boolean r1) {
        this.l = Boolean.valueOf(r1);
    }

    public void setVideoResourceId(int r4) {
        if (r4 > 0) goto L15;
        String r0 = "invalid res id : " + r4;
    L7:
        g49.d.a("DoraMovieView", "MovieView setVideoResourceId: " + r0);
        this.b = r4;
        this.c = "";
        if (this.h != null) goto L11;
        return;
    L11:
        if (this.a != null) goto L13;
        c(new Surface(this.h));
        return;
    L13:
        e();
        return;
    L15:
        r0 = getResources().getResourceName(r4);     // Catch: Exception -> L5
    L5:
        r0 = "Unable to find resource ID" + r4;
        goto L7
    }

    public void setVideoResourceIdOnly(int r4) {
        if (r4 > 0) goto L14;
        String r0 = "invalid res id : " + r4;
    L7:
        g49.d.a("DoraMovieView", "MovieView setVideoResourceId: " + r0);
        this.b = r4;
        this.c = "";
        if (this.h != null) goto L11;
        return;
    L11:
        if (this.a != null) goto L16;
        c(new Surface(this.h));
        return;
    L16:
        return;
    L14:
        r0 = getResources().getResourceName(r4);     // Catch: Exception -> L5
    L5:
        r0 = "Unable to find resource ID" + r4;
        goto L7
    }

    public void setVideoResourcePath(String r3) {
        g49.d.a("DoraMovieView", "MovieView setVideoResourcePath: " + r3);
        this.c = r3;
        this.b = 0;
        if (this.h != null) goto L6;
        return;
    L6:
        if (this.a != null) goto L8;
        c(new Surface(this.h));
        return;
    L8:
        e();
    }

    public void setVideoResourcePathOnly(String r3) {
        g49.d.a("DoraMovieView", "MovieView setVideoResourcePath: " + r3);
        this.c = r3;
        this.b = 0;
        if (this.h != null) goto L6;
        return;
    L6:
        if (this.a != null) goto L9;
        c(new Surface(this.h));
        return;
    }

    public void setDataSource(String r3) {
    L11:
        e = move-exception;
        throw new RuntimeException(e);
    L3:
        if (this.a != null) goto L5;
        return;
    L5:
        g49.d.a("DoraMovieView", "setDataSource videoResourcePath start");     // Catch: Exception -> L11
        if (r3.equals(this.c) == false) goto L8;
        return;
    L8:
        if (TextUtils.isEmpty(r3) == true) goto L17;
        this.c = r3;     // Catch: Exception -> L11
        this.a.stop();     // Catch: Exception -> L11
        PolarisFileWrapper r4 = new PolarisFileWrapper(this.c);     // Catch: Exception -> L11
        this.a.setLocalURL(r4.getAbsolutePath());     // Catch: Exception -> L11
        return;
    }

    public DoraMovieView(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    public DoraMovieView(Context r2, AttributeSet r3, int r4) {
        super(r2, r3, r4);
        this.a = null;
        Boolean r5 = Boolean.FALSE;
        this.k = r5;
        this.l = r5;
        this.m = Boolean.TRUE;
        this.n = 0;
        this.o = 0;
        this.p = null;
        this.q = new Handler(new b(this));
        if (r3 == null) goto L10;
        TypedArray r6 = getContext().getTheme().obtainStyledAttributes(r3, new int[]{2130970910, 2130972344}, 0, 0);
        this.n = r6.getDimensionPixelSize(1, 0);     // Catch: Throwable -> L7
        this.o = r6.getDimensionPixelSize(0, 0);     // Catch: Throwable -> L7
        r6.recycle();
    L7:
        th = move-exception;
        r6.recycle();
        throw th;
    L10:
        TextureView r7 = new TextureView(getContext());
        this.f = r7;
        addView(r7, -1, -1);
        r7.setSurfaceTextureListener(new a(this));
    }
}
