package com.bytedance.awemeopen.infra.base.player;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.awemeopen.infra.base.log.AoLogger;
import com.bytedance.awemeopen.infra.base.player.surface.AbsSurfaceSource;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002:\u0001 B\u0019\u0012\u0006\u00102\u001a\u000201\u0012\b\u00104\u001a\u0004\u0018\u000103¢\u0006\u0004\b5\u00106J\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003J\u0012\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003H\u0016J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J\u0010\u0010\f\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u000bH\u0016J\u0010\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\rH\u0016J\u0010\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J\b\u0010\u0014\u001a\u00020\u0013H\u0016J\b\u0010\u0015\u001a\u00020\u0013H\u0016J\b\u0010\u0016\u001a\u00020\u0013H\u0016J\b\u0010\u0018\u001a\u00020\u0017H\u0016J\u0010\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u0019H\u0016J\u0010\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u001cH\u0016R$\u0010&\u001a\u0004\u0018\u00010\u001f8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R*\u0010.\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010'8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u0014\u00100\u001a\u00020\u001f8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b/\u0010#¨\u00067"}, d2 = {"Lcom/bytedance/awemeopen/infra/base/player/AoVideoView;", "Landroid/widget/FrameLayout;", "Lcom/bytedance/awemeopen/infra/base/player/h;", "Lcom/bytedance/awemeopen/infra/base/player/surface/AbsSurfaceSource;", "getSurfaceSource", "source", "", "setSurfaceSource", "Landroid/view/ViewGroup;", "container", "setScaleContainer", "Lc64/e;", "setScaleSizeSource", "Lc64/d;", "calculator", "setSizeCalculator", "Lcom/bytedance/awemeopen/infra/base/player/k;", "listener", "setPlayStatusListener", "", "getCurrentPosition", "getDuration", "getWatchDuration", "Lcom/bytedance/awemeopen/infra/base/player/PlayState;", "getPlayState", "", "isMute", "setIsMute", "", "speed", "setPlaySpeed", "Lcom/bytedance/awemeopen/infra/base/player/g;", "a", "Lcom/bytedance/awemeopen/infra/base/player/g;", "getCustomPlayer", "()Lcom/bytedance/awemeopen/infra/base/player/g;", "setCustomPlayer", "(Lcom/bytedance/awemeopen/infra/base/player/g;)V", "customPlayer", "Lkotlin/Function0;", "e", "Lkotlin/jvm/functions/Function0;", "getSurfaceAvailableResumeCallback", "()Lkotlin/jvm/functions/Function0;", "setSurfaceAvailableResumeCallback", "(Lkotlin/jvm/functions/Function0;)V", "surfaceAvailableResumeCallback", "getPlayer", "player", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "ao_base_core_release"}, k = 1, mv = {1, 7, 1})
public final class AoVideoView extends FrameLayout implements h {
    public g a;
    public AbsSurfaceSource b;
    public c64.e c;
    public c64.d d;
    public Function0<Unit> e;

    public static final class a {
    }

    public static final class b implements com.bytedance.awemeopen.infra.base.player.surface.d {
        public final /* synthetic */ AoVideoView a;
        public final /* synthetic */ Function0<Unit> b;

        @Override // com.bytedance.awemeopen.infra.base.player.surface.d
        public final void a(Surface r2) {
            Intrinsics.checkNotNullParameter(r2, "surface");
            AoVideoView.b(this.a).a(r2);
            Function0<Unit> r3 = this.b;
            if (r3 == null) goto L6;
            r3.invoke();
            return;
        }

        public b(AoVideoView r1, Function0<Unit> r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public static final class c implements com.bytedance.awemeopen.infra.base.player.surface.b {
        public final /* synthetic */ AoVideoView a;

        public c(AoVideoView r1) {
            this.a = r1;
        }

        @Override // com.bytedance.awemeopen.infra.base.player.surface.b
        public final void a(Surface r2) {
            Intrinsics.checkNotNullParameter(r2, "surface");
            AoVideoView.b(this.a).a(r2);
            AoVideoView.b(this.a).resume();
            Function0<Unit> r3 = this.a.getSurfaceAvailableResumeCallback();
            if (r3 == null) goto L6;
            r3.invoke();
            return;
        }
    }

    static {
    }

    public final void f() {
        AbsSurfaceSource r0 = this.b;
        Boolean r2 = null;
        if ((r0 instanceof com.bytedance.awemeopen.infra.base.player.surface.j) == false) goto L5;
        com.bytedance.awemeopen.infra.base.player.surface.j r1 = (com.bytedance.awemeopen.infra.base.player.surface.j) r0;
    L6:
        if (r1 == null) goto L8;
        SurfaceTexture r3 = r1.e;
    L9:
        if (r0 == null) goto L11;
        Surface r4 = r0.b();
    L12:
        boolean r5 = true;
        Object[] r6 = new Object[1];
        StringBuilder r7 = new StringBuilder("resume, hash(");
        r7.append(Integer.toString(hashCode(), CharsKt.checkRadix(16)));
        r7.append("), source: ");
        r7.append(this.b);
        r7.append(", pre texture: ");
        r7.append(r3);
        r7.append(", valid?: ");
        if (r4 == null) goto L15;
        r2 = Boolean.valueOf(r4.isValid());
    L15:
        r7.append(r2);
        r6[0] = r7.toString();
        AoLogger.b("AoVideoView", r6);
        if (r0 == null) goto L27;
        if (r3 == null) goto L19;
        getPlayer().a(new Surface(r3));
        getPlayer().resume();
        return;
    L19:
        if (r4 != null) goto L21;
    L23:
        r5 = false;
    L24:
        if (r5 == false) goto L26;
        getPlayer().a(r4);
        getPlayer().resume();
        return;
    L26:
        c r8 = new c(this);
        Intrinsics.checkNotNullParameter(r8, "resumeCallback");
        com.bytedance.awemeopen.infra.base.player.surface.e r9 = r0.b;
        r9.getClass();
        Intrinsics.checkNotNullParameter(r8, "callback");
        r9.c = r8;
        return;
    L21:
        if (r4.isValid() != true) goto L23;
    L27:
        getPlayer().resume();
        return;
    L11:
        r4 = null;
        goto L12
    L8:
        r3 = null;
        goto L9
    L5:
        r1 = null;
        goto L6
    }

    private final g getPlayer() {
        g r0 = getCustomPlayer();
        if (r0 == null) goto L6;
        return r0;
    L6:
        throw new IllegalStateException("you should set custom player first");
    }

    public final void d() {
        getPlayer().pause();
    }

    public long getCurrentPosition() {
        return getPlayer().getCurrentPosition();
    }

    public long getDuration() {
        return getPlayer().getDuration();
    }

    public PlayState getPlayState() {
        return getPlayer().getPlayState();
    }

    public long getWatchDuration() {
        return getPlayer().getWatchDuration();
    }

    @Override // com.bytedance.awemeopen.infra.base.player.h
    public g getCustomPlayer() {
        return this.a;
    }

    public final Function0<Unit> getSurfaceAvailableResumeCallback() {
        return this.e;
    }

    public final AbsSurfaceSource getSurfaceSource() {
        return this.b;
    }

    public static final /* synthetic */ g b(AoVideoView r0) {
        return r0.getPlayer();
    }

    @Override // com.bytedance.awemeopen.infra.base.player.h
    public final void a(Function0<Unit> r10) {
        AbsSurfaceSource r0 = this.b;
        if ((r0 instanceof com.bytedance.awemeopen.infra.base.player.surface.j) == false) goto L5;
        com.bytedance.awemeopen.infra.base.player.surface.j r1 = (com.bytedance.awemeopen.infra.base.player.surface.j) r0;
    L6:
        if (r1 == null) goto L8;
        SurfaceTexture r2 = r1.e;
    L9:
        if (r0 == null) goto L11;
        Surface r3 = r0.b();
    L12:
        boolean r4 = true;
        Object[] r5 = new Object[1];
        StringBuilder r6 = new StringBuilder("bind, hash(");
        r6.append(Integer.toString(hashCode(), CharsKt.checkRadix(16)));
        r6.append("), source: ");
        r6.append(this.b);
        r6.append(", pre texture: ");
        r6.append(r2);
        r6.append(", valid?: ");
        if (r3 == null) goto L15;
        Boolean r7 = Boolean.valueOf(r3.isValid());
    L16:
        r6.append(r7);
        r5[0] = r6.toString();
        AoLogger.b("AoVideoView", r5);
        if (r0 == null) goto L30;
        getPlayer().i(null);
        if (r2 == null) goto L21;
        getPlayer().a(new Surface(r2));
        r10.invoke();
        return;
    L21:
        Surface r8 = r0.b();
        if (r8 != null) goto L24;
    L26:
        r4 = false;
    L27:
        if (r4 == false) goto L29;
        getPlayer().a(r0.b());
        r10.invoke();
        return;
    L29:
        b r9 = new b(this, r10);
        Intrinsics.checkNotNullParameter(r9, "prepareCallback");
        com.bytedance.awemeopen.infra.base.player.surface.e r11 = r0.b;
        r11.getClass();
        Intrinsics.checkNotNullParameter(r9, "callback");
        r11.b = r9;
        return;
    L24:
        if (r8.isValid() != true) goto L26;
    L30:
        getPlayer().a(null);
        getPlayer().i(this);
        r10.invoke();
        return;
    L15:
        r7 = null;
        goto L16
    L11:
        r3 = null;
        goto L12
    L8:
        r2 = null;
        goto L9
    L5:
        r1 = null;
        goto L6
    }

    public final void c(Function1 r4) {
        Intrinsics.checkNotNullParameter(r4, "callback");
        AbsSurfaceSource r1 = this.b;
        if (r1 == null) goto L5;
        Surface r2 = r1.b();
    L6:
        if (r2 != null) goto L10;
        AbsSurfaceSource r3 = this.b;
        if (r3 == null) goto L10;
        f r5 = new f(r4);
        Intrinsics.checkNotNullParameter(r5, "preRenderCallback");
        com.bytedance.awemeopen.infra.base.player.surface.e r6 = r3.b;
        r6.getClass();
        Intrinsics.checkNotNullParameter(r5, "callback");
        r6.a = r5;
    L10:
        AbsSurfaceSource r7 = this.b;
        if (r7 == null) goto L14;
        r7.b();
        return;
    L14:
        return;
    L5:
        r2 = null;
        goto L6
    }

    public final void e(final j r4) {
        Intrinsics.checkNotNullParameter(r4, "request");
        AoLogger.g("AoVideoView", new Object[]{"prepare:", r4.toString()});
        a(new AoVideoView$prepare$1(this, r4));
    }

    public final void g(long r4) {
        if (r4 >= 0) goto L5;
        return;
    L5:
        if (r4 > getDuration()) goto L9;
        getPlayer().seekTo(r4);
        return;
    }

    public void setCustomPlayer(g r1) {
        this.a = r1;
    }

    public void setIsMute(boolean r2) {
        getPlayer().setIsMute(r2);
    }

    public void setPlaySpeed(float r2) {
        getPlayer().d(r2);
    }

    public void setPlayStatusListener(k r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        getPlayer().k(r2);
    }

    public void setScaleContainer(ViewGroup r2) {
        Intrinsics.checkNotNullParameter(r2, "container");
        this.c = new c64.g(r2);
    }

    public void setScaleSizeSource(c64.e r2) {
        Intrinsics.checkNotNullParameter(r2, "source");
        this.c = r2;
    }

    public void setSizeCalculator(c64.d r2) {
        Intrinsics.checkNotNullParameter(r2, "calculator");
        this.d = r2;
    }

    public final void setSurfaceAvailableResumeCallback(Function0<Unit> r1) {
        this.e = r1;
    }

    public void setSurfaceSource(AbsSurfaceSource r5) {
        AoLogger.b("AoVideoView", new Object[]{"hash(" + Integer.toString(hashCode(), CharsKt.checkRadix(16)) + ") ,set surface source: " + this.b + " -> " + r5});
        removeAllViews();
        this.b = r5;
        if (r5 == null) goto L9;
        FrameLayout.LayoutParams r0 = new FrameLayout.LayoutParams(-1, -1);
        r0.gravity = 17;
        Context r1 = getContext();
        Intrinsics.checkNotNullParameter(r1, "c");
        com.bytedance.awemeopen.infra.base.player.surface.a r2 = r5.c;
        if (r2 == null) goto L7;
        r2.release();
    L7:
        com.bytedance.awemeopen.infra.base.player.surface.i r3 = r5.a(r1);
        r5.c = r3;
        r3.f = r5;
        addView(r3.a, r0);
        return;
    }

    public AoVideoView(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        new LinkedHashMap();
        super(r2, r3);
        this.c = new c64.g(this);
        this.d = new c64.c();
    }
}
