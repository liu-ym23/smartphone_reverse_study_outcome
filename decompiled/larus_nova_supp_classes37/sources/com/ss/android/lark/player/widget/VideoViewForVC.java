package com.ss.android.lark.player.widget;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.player.entity.DataSource;
import com.ss.android.lark.player.player.IMPlayerSettings;
import com.ss.android.lark.player.player.m;
import com.ss.android.lark.player.player.n;
import com.ss.android.lark.player.player.s;
import com.ss.android.lark.player.player.v;
import com.ss.ttvideoengine.TTVideoEngine;
import com.ss.ttvideoengine.VideoEngineInfoListener;
import java.util.Objects;
import v0c.g;
import v0c.j;
import v0c.p;
import v0c.q;
import v0c.r;
import v0c.t;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public class VideoViewForVC extends FrameLayout implements com.ss.android.lark.player.player.b.a {
    public v a;
    public SuperContainer b;
    public RenderTextureView c;
    public float d;
    public float e;
    public float f;
    public float g;
    public boolean h;
    public boolean i;
    public RenderTextureView.b j;
    public DataSource k;
    public final a l;
    public n m;
    public m n;
    public final b o;

    public class a implements RenderTextureView.a {
        public final /* synthetic */ VideoViewForVC a;

        public a(VideoViewForVC r1) {
            this.a = r1;
        }
    }

    public class b implements r {
        public final /* synthetic */ VideoViewForVC a;

        @Override // v0c.r
        public final boolean a() {
            return this.a.h;
        }

        @Override // v0c.r
        public final int getState() {
            return this.a.a.c();
        }

        public b(VideoViewForVC r1) {
            this.a = r1;
        }
    }

    public class c implements t {
        public final /* synthetic */ VideoViewForVC a;

        @Override // v0c.t
        public final r i() {
            return this.a.o;
        }

        public c(VideoViewForVC r1) {
            this.a = r1;
        }
    }

    public class d implements n {
        public final /* synthetic */ VideoViewForVC a;

        public d(VideoViewForVC r1) {
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
            VideoViewForVC r2 = this.a;
            if (r2.c == null) goto L13;
            r2.f = r6.getInt("int_arg1");
            this.a.g = r6.getInt("int_arg2");
        L13:
            VideoViewForVC r0 = this.a;
            VideoViewForVC.b(r0, r0.j);
        L14:
            n r1 = this.a.m;
            if (r1 == null) goto L17;
            r1.a(r5, r6);
        L17:
            this.a.b.b(r5, r6);
        }
    }

    public class e implements m {
        public final /* synthetic */ VideoViewForVC a;

        public e(VideoViewForVC r1) {
            this.a = r1;
        }

        @Override // com.ss.android.lark.player.player.m
        public final void h(int r3, Bundle r4) {
            Log.e("VideoView", "onError : code = " + r3 + ", Message = " + r4.toString());
            m r0 = this.a.n;
            if (r0 == null) goto L5;
            r0.h(r3, r4);
        L5:
            g r1 = this.a.b.f;
            if (r1 == null) goto L9;
            r1.a.d(new j(r3, r4));
            r4.clear();
            return;
        }
    }

    public class f implements q {
        public final /* synthetic */ VideoViewForVC a;

        public f(VideoViewForVC r1) {
            this.a = r1;
        }

        @Override // v0c.q
        public final void a(int r7, Bundle r8) {
            boolean r3 = true;
            int r5 = 0;
            switch(r7) {
                case -660011: goto L47;
                case -66016: goto L46;
                case -66015: goto L45;
                case -66013: goto L42;
                case -66009: goto L39;
                case -66007: goto L36;
                case -66005: goto L33;
                case -66003: goto L18;
                case -66001: goto L5;
                default: goto L70;
            };
        L5:
            int r9 = this.a.getState();
            if (r9 == (-2)) goto L12;
            if (r9 == (-1)) goto L12;
            if (r9 == 0) goto L12;
            if (r9 == 1) goto L12;
            if (r9 == 5) goto L12;
        L13:
            if (r3 == false) goto L15;
            this.a.a.h();
            return;
        L15:
            v r10 = this.a.a;
            if (r10.f() == false) goto L54;
            r10.a.l();
            return;
        L54:
            return;
        L12:
            r3 = false;
            goto L13
        L18:
            int r11 = this.a.getState();
            if (r11 == (-2)) goto L25;
            if (r11 == (-1)) goto L25;
            if (r11 == 0) goto L25;
            if (r11 == 1) goto L25;
            if (r11 == 5) goto L25;
        L26:
            if (r3 == false) goto L30;
            v r12 = this.a.a;
            if (r12.f() == false) goto L56;
            r12.a.h();
            return;
        L56:
            return;
        L30:
            v r13 = this.a.a;
            DataSource r14 = r13.b;
            if (r14 == null) goto L58;
            r13.d(r14);
            r13.e(0);
            return;
        L58:
            return;
        L25:
            r3 = false;
            goto L26
        L33:
            if (r8 == null) goto L35;
            r5 = r8.getInt("int_data");
        L35:
            this.a.a.i(r5);
            return;
        L36:
            v r15 = this.a.a;
            if (r15.f() == false) goto L61;
            r15.a.l();
            return;
        L61:
            return;
        L39:
            v r16 = this.a.a;
            if (r16.f() == false) goto L63;
            r16.a.l();
            return;
        L63:
            return;
        L42:
            v r17 = this.a.a;
            DataSource r18 = r17.b;
            if (r18 == null) goto L65;
            r17.d(r18);
            r17.e(0);
            return;
        L65:
            return;
        L45:
            this.a.a.m(true);
            return;
        L46:
            this.a.a.m(false);
            return;
        L47:
            if (r8 == null) goto L49;
            r5 = r8.getInt("int_data");
        L49:
            v r19 = this.a.a;
            DataSource r20 = r19.b;
            if (r20 == null) goto L69;
            r19.d(r20);
            r19.e(r5);
            return;
        L69:
            return;
        }
    }

    public final void c() {
        Log.i("VideoView", "adjustSurfaceSizeIfNeed start, mViewWidth=" + this.d + ",mViewHeight=" + this.e + ",mVideoWidth=" + this.f + ",mVideoHeight=" + this.g);
        if (this.c == null) goto L27;
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
    L16:
        float r3 = this.d;
        if (r3 <= 0.0f) goto L29;
        float r4 = this.e;
        if (r4 <= 0.0f) goto L30;
        float r5 = this.f;
        if (r5 <= 0.0f) goto L31;
        float r6 = this.g;
        if (r6 <= 0.0f) goto L33;
        float r7 = Math.min(r3 / r5, r4 / r6);
        FrameLayout.LayoutParams r8 = (FrameLayout.LayoutParams) this.c.getLayoutParams();
        r8.width = (int) (this.f * r7);
        r8.height = (int) (this.g * r7);
        this.c.setLayoutParams(r8);
        this.b.c();
        Log.i("VideoView", "adjustSurfaceSizeIfNeed end, longSideRatio=" + r7 + ", surfaceWidth=" + r8.width + ",surfaceHeight=" + r8.height);
        return;
    L33:
        return;
    L31:
        return;
    L30:
        return;
    L29:
        return;
    L14:
        if (this.a.g() == true) goto L16;
        return;
    L11:
        r2 = true;
        goto L12
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
        return this.n;
    }

    public n getOnPlayerEventListener() {
        return this.m;
    }

    public final SuperContainer getSuperContainer() {
        return this.b;
    }

    public VideoViewForVC(Context r2) {
        this(r2, null);
    }

    public void setDataSource(DataSource r5) {
        DataSource r0 = this.k;
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
        this.j = null;
        RenderTextureView r4 = new RenderTextureView(getContext());
        this.c = r4;
        r4.setRenderCallback(this.l);
        this.b.setRenderView(this.c);
        RenderTextureView r6 = this.c;
        if (r6 == null) goto L29;
        if (this.i == false) goto L28;
        r6.setVisibility(0);
        goto L29
    L28:
        r6.setVisibility(4);
    L29:
        this.a.j(r5);
        this.k = r5;
        return;
    L5:
        if (Objects.equals(r0.getData(), r5.getData()) == false) goto L7;
    L8:
        r2 = true;
        if (IMPlayerSettings.a().getReuseSurfaceView() != 1) goto L11;
    L7:
        if (this.k.getUri() != r5.getUri()) goto L11;
        goto L8
    }

    public void setHardwareDecode(boolean r3) {
        v r0 = this.a;
        if (r0 == null) goto L10;
        s r1 = r0.a;
        if (r1 == null) goto L11;
        TTVideoEngine r2 = r1.g;
        if (r2 == null) goto L12;
        r2.setIntOption(7, r3 ? 1 : 0);
        return;
    L12:
        return;
    L11:
        return;
    }

    public void setMute(boolean r2) {
        this.a.k(r2);
    }

    public void setOnErrorEventListener(m r1) {
        this.n = r1;
    }

    public void setOnPlayerEventListener(n r1) {
        this.m = r1;
    }

    public void setReceiverGroup(p r2) {
        this.b.setReceiverGroup(r2);
    }

    public void setSpeed(float r2) {
        this.a.l(r2);
    }

    public void setSurfaceViewVisible(boolean r2) {
        this.i = r2;
        RenderTextureView r0 = this.c;
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

    public VideoViewForVC(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    public static void b(VideoViewForVC r1, RenderTextureView.b r2) {
        if (r2 == null) goto L16;
        v r3 = r1.a;
        RenderTextureView.c r4 = (RenderTextureView.c) r2;
        if (r3 != null) goto L6;
        return;
    L6:
        if (r4.a.get() == null) goto L21;
        Surface r0 = new Surface(r4.a.get());
        if (r3.f() == false) goto L22;
        s r5 = r3.a;
        r5.getClass();
    L14:
        e = move-exception;
        r5.e(e);
        return;
    L11:
        if (r5.b() == false) goto L23;
        r5.g.setSurface(r0);     // Catch: Exception -> L14
        r5.a(-99002, null);     // Catch: Exception -> L14
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

    public VideoViewForVC(Context r5, AttributeSet r6, int r7) {
        super(r5, r6, r7);
        this.i = true;
        this.l = new a(this);
        this.o = new b(this);
        c r8 = new c(this);
        d r0 = new d(this);
        e r1 = new e(this);
        f r2 = new f(this);
        v r3 = new v();
        this.a = r3;
        r3.k(true);
        v r9 = this.a;
        r9.d = r0;
        r9.e = r1;
        r9.g = this;
        SuperContainer r10 = new SuperContainer(r5);
        this.b = r10;
        r10.setStateGetter(r8);
        this.b.setOnReceiverEventListener(r2);
        ViewGroup.LayoutParams r11 = new ViewGroup.LayoutParams(-1, -1);
        addView(this.b, r11);
    }

    @Override // android.view.View
    public final void onSizeChanged(int r1, int r2, int r3, int r4) {
        this.d = r1;
        this.e = r2;
        c();
    }
}
