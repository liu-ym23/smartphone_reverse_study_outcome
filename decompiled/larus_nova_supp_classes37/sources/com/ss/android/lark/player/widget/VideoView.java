package com.ss.android.lark.player.widget;

import android.content.Context;
import android.media.AudioManager;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.player.entity.DataSource;
import com.ss.android.lark.player.player.IMPlayerSettings;
import com.ss.android.lark.player.player.h;
import com.ss.android.lark.player.player.m;
import com.ss.android.lark.player.player.n;
import com.ss.android.lark.player.player.s;
import com.ss.android.lark.player.player.v;
import com.ss.android.lark.utils.LarkContext;
import com.ss.ttvideoengine.TTVideoEngine;
import com.ss.ttvideoengine.VideoEngineInfoListener;
import e0c.k;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import v0c.j;
import v0c.p;
import v0c.q;
import v0c.r;
import v0c.t;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public class VideoView extends FrameLayout implements com.ss.android.lark.player.player.b.a {
    public v a;
    public SuperContainer b;
    public RenderSurfaceView c;
    public float d;
    public float e;
    public float f;
    public float g;
    public boolean h;
    public boolean i;
    public boolean j;
    public RenderSurfaceView.b k;
    public DataSource l;
    public final a m;
    public n n;
    public m o;
    public final b p;
    public final f q;

    public class a implements RenderSurfaceView.a {
        public final /* synthetic */ VideoView a;

        public a(VideoView r1) {
            this.a = r1;
        }
    }

    public class b implements r {
        public final /* synthetic */ VideoView a;

        @Override // v0c.r
        public final boolean a() {
            return this.a.h;
        }

        @Override // v0c.r
        public final int getState() {
            return this.a.a.c();
        }

        public b(VideoView r1) {
            this.a = r1;
        }
    }

    public class c implements t {
        public final /* synthetic */ VideoView a;

        @Override // v0c.t
        public final r i() {
            return this.a.p;
        }

        public c(VideoView r1) {
            this.a = r1;
        }
    }

    public class d implements n {
        public final /* synthetic */ VideoView a;

        public d(VideoView r1) {
            this.a = r1;
        }

        @Override // com.ss.android.lark.player.player.n
        public final void a(int r5, Bundle r6) {
            switch(r5) {
                case -99018: goto L9;
                case -99017: goto L7;
                case -99011: goto L6;
                case -99010: goto L5;
                default: goto L14;
            };
        L5:
            this.a.h = true;
            goto L14
        L6:
            this.a.h = false;
            goto L14
        L7:
            if (r6 == null) goto L14;
            this.a.f = r6.getInt("int_arg1");
            this.a.g = r6.getInt("int_arg2");
            Log.i("VideoView", "onVideoSizeChange : videoWidth = " + this.a.f + ", videoHeight = " + this.a.g);
            goto L14
        L9:
            if (r6 == null) goto L13;
            VideoView r2 = this.a;
            if (r2.c == null) goto L13;
            r2.f = r6.getInt("int_arg1");
            this.a.g = r6.getInt("int_arg2");
        L13:
            VideoView r0 = this.a;
            VideoView.b(r0, r0.k);
        L14:
            n r1 = this.a.n;
            if (r1 == null) goto L17;
            r1.a(r5, r6);
        L17:
            this.a.b.b(r5, r6);
        }
    }

    public class e implements m {
        public final /* synthetic */ VideoView a;

        public e(VideoView r1) {
            this.a = r1;
        }

        @Override // com.ss.android.lark.player.player.m
        public final void h(int r3, Bundle r4) {
            Log.e("VideoView", "onError : code = " + r3 + ", Message = " + r4.toString());
            m r0 = this.a.o;
            if (r0 == null) goto L5;
            r0.h(r3, r4);
        L5:
            v0c.g r1 = this.a.b.f;
            if (r1 == null) goto L9;
            r1.a.d(new j(r3, r4));
            r4.clear();
            return;
        }
    }

    public class f implements AudioManager.OnAudioFocusChangeListener {
        public final /* synthetic */ VideoView a;

        public f(VideoView r1) {
            this.a = r1;
        }

        @Override // android.media.AudioManager.OnAudioFocusChangeListener
        public final void onAudioFocusChange(int r2) {
            if (r2 != (-3)) goto L5;
            this.a.f();
            return;
        L5:
            if (r2 != (-2)) goto L7;
            this.a.f();
            return;
        L7:
            if (r2 != (-1)) goto L15;
            this.a.f();
            return;
        }
    }

    public class g implements q {
        public final /* synthetic */ VideoView a;

        public g(VideoView r1) {
            this.a = r1;
        }

        @Override // v0c.q
        public final void a(int r3, Bundle r4) {
            int r1 = 0;
            switch(r3) {
                case -660011: goto L36;
                case -66016: goto L35;
                case -66015: goto L34;
                case -66013: goto L31;
                case -66009: goto L27;
                case -66007: goto L23;
                case -66005: goto L20;
                case -66003: goto L13;
                case -66001: goto L6;
                default: goto L56;
            };
        L20:
            if (r4 == null) goto L22;
            r1 = r4.getInt("int_data");
        L22:
            this.a.a.i(r1);
            return;
        L23:
            VideoView r5 = this.a;
            v r6 = r5.a;
            if (r6.f() == false) goto L26;
            r6.a.l();
        L26:
            r5.g();
            return;
        L27:
            VideoView r7 = this.a;
            v r8 = r7.a;
            if (r8.f() == false) goto L30;
            r8.a.l();
        L30:
            r7.g();
            return;
        L31:
            VideoView r9 = this.a;
            r9.h();
            v r10 = r9.a;
            DataSource r11 = r10.b;
            if (r11 == null) goto L51;
            r10.d(r11);
            r10.e(0);
            return;
        L51:
            return;
        L34:
            this.a.a.m(true);
            return;
        L35:
            this.a.a.m(false);
            return;
        L36:
            if (r4 == null) goto L38;
            r1 = r4.getInt("int_data");
        L38:
            VideoView r12 = this.a;
            r12.h();
            v r13 = r12.a;
            DataSource r14 = r13.b;
            if (r14 == null) goto L55;
            r13.d(r14);
            r13.e(r1);
            return;
        L55:
            return;
        L56:
            return;
        L6:
            if (this.a.e() == false) goto L8;
            this.a.f();
            return;
        L8:
            VideoView r15 = this.a;
            v r16 = r15.a;
            if (r16.f() == false) goto L11;
            r16.a.l();
        L11:
            r15.g();
            return;
        L13:
            if (this.a.e() == false) goto L17;
            VideoView r17 = this.a;
            r17.h();
            v r18 = r17.a;
            if (r18.f() == false) goto L44;
            r18.a.h();
            return;
        L44:
            return;
        L17:
            VideoView r19 = this.a;
            r19.h();
            v r20 = r19.a;
            DataSource r21 = r20.b;
            if (r21 == null) goto L46;
            r20.d(r21);
            r20.e(0);
            return;
        }
    }

    public final void c() {
        Log.i("VideoView", "adjustSurfaceSizeIfNeed start, mViewWidth=" + this.d + ",mViewHeight=" + this.e + ",mVideoWidth=" + this.f + ",mVideoHeight=" + this.g);
        if (this.c == null) goto L29;
        v r0 = this.a;
        if (r0 != null) goto L7;
        return;
    L7:
        if (r0.f() == false) goto L11;
        s r1 = r0.a;
        if (r1.b() == false) goto L11;
        boolean r2 = r1.g.isSystemPlayer();
    L12:
        if (r2 == false) goto L14;
    L18:
        float r3 = this.d;
        if (r3 <= 0.0f) goto L31;
        float r4 = this.e;
        if (r4 <= 0.0f) goto L32;
        float r5 = this.f;
        if (r5 <= 0.0f) goto L33;
        float r6 = this.g;
        if (r6 <= 0.0f) goto L35;
        float r7 = Math.min(r3 / r5, r4 / r6);
        FrameLayout.LayoutParams r8 = (FrameLayout.LayoutParams) this.c.getLayoutParams();
        r8.width = (int) (this.f * r7);
        r8.height = (int) (this.g * r7);
        this.c.setLayoutParams(r8);
        this.b.c();
        Log.i("VideoView", "adjustSurfaceSizeIfNeed end, longSideRatio=" + r7 + ", surfaceWidth=" + r8.width + ",surfaceHeight=" + r8.height);
        return;
    L35:
        return;
    L33:
        return;
    L32:
        return;
    L31:
        return;
    L14:
        if (this.a.g() == true) goto L18;
        if (this.j == true) goto L18;
        return;
    L11:
        r2 = true;
        goto L12
    }

    public final void f() {
        this.a.h();
        g();
    }

    public final void g() {
        Log.i("VideoView", "<<releaseAudioFocus>>");
        AudioManager r0 = (AudioManager) getContext().getSystemService("audio");
        if (r0 == null) goto L6;
        r0.abandonAudioFocus(this.q);
        return;
    }

    public int getBufferPercentage() {
        v r0 = this.a;
        if (r0.f() == true) goto L7;
        return 0;
    L7:
        return r0.a.e;
    }

    public int getCurrentPosition() {
        return this.a.a();
    }

    public int getDuration() {
        return this.a.b();
    }

    public int getState() {
        return this.a.c();
    }

    public final void h() {
        Log.i("VideoView", ">>requestAudioFocus<<");
        AudioManager r0 = (AudioManager) getContext().getSystemService("audio");
        if (r0 == null) goto L6;
        r0.requestAudioFocus(this.q, 3, 2);
        return;
    }

    public final void i() {
        Log.i("VideoView", "stopPlayback release.");
        g();
        v r0 = this.a;
        if (r0.f() == false) goto L14;
        s r1 = r0.a;
        r1.getClass();
        Log.i("TTEnginePlayer", "destroy: " + r1.p);
        com.ss.android.lark.player.player.a r3 = r1.h;
        if (r3 == null) goto L8;
        r3.a.dispose();
        r1.h = null;
    L8:
        if (r1.b() == false) goto L14;
        r1.n(-2);
        if (r1.b() == false) goto L13;
        r1.g.setListener(null);
    L13:
        TTVideoEngine r4 = r1.g;
        r1.g = null;
        r4.release();
        r1.a(-99009, null);
    L14:
        r0.c.e = null;
        s r2 = r0.a;
        if (r2 == null) goto L20;
        r2.b = null;
        r2.c = null;
        r2.d = null;
        if (r2.b() == false) goto L20;
        r2.g.setVideoEngineInfoListener(null);
    L20:
        this.k = null;
        SuperContainer r5 = this.b;
        p r6 = r5.g;
        if (r6 == null) goto L23;
        r6.c(r5.k);
    L23:
        x0c.c r7 = r5.c;
        Iterator r8 = ((CopyOnWriteArrayList) r7.a).iterator();
    L25:
        if (r8.hasNext() == false) goto L27;
        x0c.a r9 = (x0c.a) r8.next();
        r9.a();
        r9.destroy();
        goto L25
    L27:
        ((CopyOnWriteArrayList) r7.a).clear();
        FrameLayout r10 = r5.a;
        if (r10 == null) goto L30;
        r10.removeAllViews();
    L30:
        v0c.c r11 = r5.b;
        ((ArrayList) r11.b).clear();
        r11.a.removeAllViews();
    }

    public final boolean e() {
        int r0 = getState();
        if (r0 != (-2)) goto L5;
    L12:
        return false;
    L5:
        if (r0 == (-1)) goto L12;
        if (r0 == 0) goto L12;
        if (r0 == 1) goto L12;
        if (r0 == 5) goto L12;
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        setKeepScreenOn(true);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        setKeepScreenOn(false);
    }

    public m getOnErrorEventListener() {
        return this.o;
    }

    public n getOnPlayerEventListener() {
        return this.n;
    }

    public final SuperContainer getSuperContainer() {
        return this.b;
    }

    public VideoView(Context r2) {
        this(r2, null);
    }

    public final void d(String r9) {
        s r0 = this.a.a;
        if ((r0 instanceof s) == false) goto L23;
        com.ss.android.lark.player.player.a r1 = r0.h;
        if (r1 == null) goto L8;
        r1.a.dispose();
        r0.h = null;
    L8:
        if (r0.b() == false) goto L24;
        TTVideoEngine r2 = r0.g;
        h r3 = h.a;
        Intrinsics.checkNotNullParameter(r2, "engine");
        Intrinsics.checkNotNullParameter(r9, "userId");
        com.ss.android.lark.player.player.d r4 = com.ss.android.lark.player.player.d.a;
        Intrinsics.checkNotNullParameter(r2, "engine");
        Intrinsics.checkNotNullParameter(r9, "userId");
        Intrinsics.checkNotNullParameter(r4, "builder");
        com.ss.android.lark.player.player.e r5 = new com.ss.android.lark.player.player.e(new WeakReference(r2));
        Intrinsics.checkNotNullParameter(r9, "userId");
        Intrinsics.checkNotNullParameter(r4, "builder");
        Intrinsics.checkNotNullParameter(r5, "writer");
        h r6 = h.a;
        com.ss.android.lark.player.player.f r7 = new com.ss.android.lark.player.player.f(r5);
        r6.getClass();
        com.ss.android.lark.player.player.g r8 = new com.ss.android.lark.player.player.g();
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L13
        Object r11 = Result.constructor-impl(((com.ss.android.lark.passport.auth.e) k.a(LarkContext.getApplication(), com.ss.android.lark.passport.auth.e.class)).a(r9, r8, r7));     // Catch: Throwable -> L13
    L15:
        Throwable r12 = Result.exceptionOrNull-impl(r11);
        if (r12 == null) goto L19;
        Log.e("PlayerAuthHeaders", "bind Passport auth headers failed", r12);
        Intrinsics.checkNotNullParameter(r9, "userId");
        Intrinsics.checkNotNullParameter(r8, "build");
        Intrinsics.checkNotNullParameter(r7, "onHeadersChanged");
        r11 = new com.ss.android.lark.passport.auth.a(r8, r7);
    L19:
        r0.h = new com.ss.android.lark.player.player.a((com.ss.android.lark.passport.auth.h) r11);
        r0.m();
        return;
    L13:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        r11 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L15
    L24:
        return;
    }

    public void setDataSource(DataSource r5) {
        DataSource r0 = this.l;
        if (r0 != null) goto L5;
    L11:
        boolean r2 = false;
    L12:
        if (r2 == true) goto L29;
        v r1 = this.a;
        if (r1.f() == false) goto L22;
        s r3 = r1.a;
        r3.getClass();
    L20:
        e = move-exception;
        r3.e(e);
        goto L22
    L17:
        if (r3.b() == false) goto L22;
        r3.g.setSurface(null);     // Catch: Exception -> L20
        r3.a(-99002, null);     // Catch: Exception -> L20
    L22:
        this.k = null;
        RenderSurfaceView r4 = new RenderSurfaceView(getContext());
        this.c = r4;
        r4.setRenderCallback(this.m);
        this.b.setRenderView(this.c);
        RenderSurfaceView r6 = this.c;
        if (r6 == null) goto L29;
        if (this.i == false) goto L28;
        r6.setVisibility(0);
        goto L29
    L28:
        r6.setVisibility(4);
    L29:
        this.a.j(r5);
        this.l = r5;
        return;
    L5:
        if (Objects.equals(r0.getData(), r5.getData()) == false) goto L7;
    L8:
        r2 = true;
        if (IMPlayerSettings.a().getReuseSurfaceView() != 1) goto L11;
    L7:
        if (this.l.getUri() != r5.getUri()) goto L11;
        goto L8
    }

    public void setMute(boolean r2) {
        this.a.k(r2);
    }

    public void setOnErrorEventListener(m r1) {
        this.o = r1;
    }

    public void setOnPlayerEventListener(n r1) {
        this.n = r1;
    }

    public void setReceiverGroup(p r2) {
        this.b.setReceiverGroup(r2);
    }

    public void setSpeed(float r2) {
        this.a.l(r2);
    }

    public void setSurfaceViewVisible(boolean r2) {
        this.i = r2;
        RenderSurfaceView r0 = this.c;
        if (r0 == null) goto L10;
        if (r2 == false) goto L7;
        r0.setVisibility(0);
        return;
    L7:
        r0.setVisibility(4);
        return;
    }

    public void setVideoEngineInfoListener(VideoEngineInfoListener r2) {
        v r0 = this.a;
        if (r0 == null) goto L6;
        r0.f = r2;
        return;
    }

    public void setVideoID(String r3) {
        v r0 = this.a;
        if (r0.f() == false) goto L8;
        s r1 = r0.a;
        if (r1.b() == false) goto L9;
        r1.g.setVideoID(r3);
        return;
    L9:
        return;
    }

    public void setDataSource(com.ss.ttvideoengine.DataSource r3) {
        v r0 = this.a;
        if (r0.f() == false) goto L8;
        s r1 = r0.a;
        if (r1.b() == false) goto L9;
        r1.g.setDataSource(r3);
        return;
    L9:
        return;
    }

    public VideoView(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    public static void b(VideoView r1, RenderSurfaceView.b r2) {
        if (r2 == null) goto L16;
        v r3 = r1.a;
        RenderSurfaceView.c r4 = (RenderSurfaceView.c) r2;
        if (r3 != null) goto L6;
        return;
    L6:
        if (r4.a.get() == null) goto L21;
        SurfaceHolder r5 = r4.a.get();
        if (r3.f() == false) goto L22;
        s r6 = r3.a;
        r6.getClass();
    L14:
        e = move-exception;
        r6.e(e);
        return;
    L11:
        if (r6.b() == false) goto L23;
        r6.g.setSurfaceHolder(r5);     // Catch: Exception -> L14
        r6.a(-99002, null);     // Catch: Exception -> L14
        return;
    L23:
        return;
    L22:
        return;
    L21:
        return;
    L16:
        r1.getClass();
    }

    @Override // com.ss.android.lark.player.player.b.a
    public final void a(float r1, float r2) {
        this.f = r1;
        this.g = r2;
        c();
    }

    public VideoView(Context r4, AttributeSet r5, int r6) {
        super(r4, r5, r6);
        this.i = true;
        this.j = false;
        this.m = new a(this);
        this.p = new b(this);
        c r7 = new c(this);
        d r8 = new d(this);
        e r0 = new e(this);
        this.q = new f(this);
        g r1 = new g(this);
        v r2 = new v();
        this.a = r2;
        r2.d = r8;
        r2.e = r0;
        r2.g = this;
        SuperContainer r9 = new SuperContainer(r4);
        this.b = r9;
        r9.setStateGetter(r7);
        this.b.setOnReceiverEventListener(r1);
        ViewGroup.LayoutParams r10 = new ViewGroup.LayoutParams(-1, -1);
        addView(this.b, r10);
    }

    @Override // android.view.View
    public final void onSizeChanged(int r1, int r2, int r3, int r4) {
        this.d = r1;
        this.e = r2;
        c();
    }
}
