package com.bytedance.android.livesdk.gift.platform.business.effect.player;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.android.livesdk.widget.EdgeTransparentView;
import com.bytedance.android.livesdkapi.depend.live.gift.IPlayerActionListener;
import com.bytedance.android.livesdkapi.depend.live.gift.IPlayerLoopListener;
import com.bytedance.android.livesdkapi.depend.live.gift.IResultMonitor;
import com.bytedance.android.livesdkapi.depend.live.player.ITextureViewPlayerController;
import com.bytedance.android.livesdkapi.depend.live.player.MaskSrc;
import com.bytedance.android.livesdkapi.depend.live.player.PlayConfig;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.JsonSyntaxException;
import com.ss.android.ugc.aweme.live.alphaplayer.Configuration;
import com.ss.android.ugc.aweme.live.alphaplayer.controller.IPlayerController;
import com.ss.android.ugc.aweme.live.alphaplayer.controller.PlayerController;
import com.ss.android.ugc.aweme.live.alphaplayer.listener.AlphaPlayerAction;
import com.ss.android.ugc.aweme.live.alphaplayer.listener.ILoopListener;
import com.ss.android.ugc.aweme.live.alphaplayer.listener.IMonitor;
import com.ss.android.ugc.aweme.live.alphaplayer.model.DataSource;
import com.ss.android.ugc.aweme.live.alphaplayer.player.AbsPlayer;
import com.ss.android.ugc.aweme.live.alphaplayer.player.DefaultSystemPlayer;
import java.io.File;
import java.lang.reflect.Method;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class k implements ITextureViewPlayerController {
    public static Boolean m;
    public LifecycleOwner a;
    public IPlayerActionListener b;
    public PlayerController c;
    public IPlayerLoopListener d;
    public IResultMonitor e;
    public final Object f;
    public AbsPlayer g;
    public boolean h;
    public final b i;
    public final d j;
    public final c k;
    public Context l;

    public static final class a {
    }

    public static final class b implements AlphaPlayerAction {
        public final /* synthetic */ k a;

        public final void a() {
            IPlayerActionListener r0 = this.a.b;
            if (r0 == null) goto L6;
            r0.onStart();
            return;
        }

        public final void b() {
            IPlayerActionListener r0 = this.a.b;
            if (r0 == null) goto L6;
            r0.onEnd();
            return;
        }

        public b(k r1) {
            this.a = r1;
        }

        public final void c(int r13, int r14, DataSource.ScaleType r15) {
            IPlayerActionListener r0 = this.a.b;
            if (r0 == null) goto L5;
            r0.onFileLoaded(r13, r14);
        L5:
            k r1 = this.a;
            View r3 = null;
            if (r1.h == false) goto L60;
            PlayerController r2 = r1.c;
            if (r2 == null) goto L11;
            View r4 = r2.getView();
        L12:
            if (r4 == null) goto L60;
            if (r4.getParent() == null) goto L60;
            if ((r4.getParent() instanceof FrameLayout) == false) goto L60;
            EdgeTransparentView r5 = r4.getParent();
            if (r5 == null) goto L59;
            EdgeTransparentView r6 = (FrameLayout) r5;
            ViewGroup.LayoutParams r7 = r6.getLayoutParams();
            if (r7 == null) goto L57;
            FrameLayout.LayoutParams r8 = (FrameLayout.LayoutParams) r7;
            int r9 = s1.y();
            int r10 = s1.w();
            float r11 = r14 / r13;
            if (r15 == null) goto L34;
            int r16 = l.a[r15.ordinal()];
            if (r16 == 1) goto L39;
            if (r16 != 2) goto L29;
            r8.width = r9;
            r8.height = r10;
            r8.gravity = 48;
        L45:
            if (vh6.c.b(wh6.a.class).getCurrentActivity() != null) goto L47;
        L55:
            r6.setLayoutParams(r8);
            goto L60
        L47:
            if ((r6 instanceof EdgeTransparentView) == false) goto L55;
            if (PadConfigUtils.c() == false) goto L55;
            float r17 = r9;
            if (r9 <= r10) goto L53;
            float r18 = 0.3f;
        L54:
            int r19 = (int) (r17 * r18);
            float r20 = r19;
            r6.a(15, r20 * 0.12f);
            r8.width = r19;
            r8.height = (int) (r11 * r20);
            r8.gravity = 81;
            goto L55
        L53:
            r18 = 0.5f;
            goto L54
        L29:
            if (r16 != 3) goto L31;
            r8.width = r9;
            r8.height = (int) (r9 * r11);
            r8.gravity = 80;
            goto L45
        L31:
            if (r16 != 4) goto L33;
            r8.height = r10;
            r8.width = (int) (r10 / r11);
            r8.gravity = 8388611;
            goto L45
        L33:
            if (r16 != 5) goto L34;
            r8.height = r10;
            r8.width = (int) (r10 / r11);
            r8.gravity = 8388613;
            goto L45
        L39:
            float r21 = r10;
            float r23 = r9 * r11;
            if (r21 <= r23) goto L42;
            r8.width = r9;
            r8.height = (int) r23;
        L43:
            r8.gravity = 17;
            goto L45
        L42:
            r8.height = r10;
            r8.width = (int) (r21 / r11);
        L34:
            r8.width = -1;
            r8.height = -1;
            r8.gravity = 17;
            goto L45
        L57:
            throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        L59:
            throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout");
        L11:
            r4 = null;
        L60:
            PlayerController r24 = this.a.c;
            if (r24 == null) goto L63;
            r3 = r24.getView();
        L63:
            k r25 = this.a;
            float r26 = 0.0f;
            if (r3 == null) goto L66;
            float r27 = r3.getMeasuredWidth();
        L67:
            if (r3 == null) goto L69;
            float r28 = r3.getMeasuredHeight();
        L70:
            r25.getClass();
            float r29 = r27 / r28;
            float r110 = r13 / r14;
            if (r15 == DataSource.ScaleType.ScaleAspectFill) goto L85;
            if (r15 == DataSource.ScaleType.TopFill) goto L85;
            if (r15 == DataSource.ScaleType.BottomFill) goto L85;
            if (r15 == DataSource.ScaleType.RightFill) goto L85;
            if (r15 == DataSource.ScaleType.LeftFill) goto L85;
            if (r29 > r110) goto L87;
        L86:
            float r30 = r27 / r110;
            float r111 = r27;
        L88:
            if (r15 != null) goto L91;
        L122:
            float r31 = 0.0f;
        L123:
            float r112 = r111;
            r28 = r30;
        L124:
            r30 = r28;
            r26 = r31;
            float r33 = 0.0f;
            r27 = r112;
        L125:
            IPlayerActionListener r113 = r25.b;
            if (r113 == null) goto L129;
            r113.updateTextEffectPosition(r27, r30, r26, r33);
            return;
        L129:
            return;
        L91:
            switch(l.b[r15.ordinal()]) {
                case 1: goto L121;
                case 2: goto L115;
                case 3: goto L112;
                case 4: goto L109;
                case 5: goto L106;
                case 6: goto L102;
                case 7: goto L98;
                case 8: goto L96;
                case 9: goto L95;
                case 10: goto L94;
                case 11: goto L93;
                default: goto L122;
            };
        L93:
            r112 = r110 * r28;
            r31 = r27 - r112;
            goto L124
        L94:
            r27 = r28 * r110;
            goto L121
        L95:
            r30 = r27 / r110;
            r33 = r28 - r30;
            goto L125
        L96:
            r28 = r27 / r110;
        L121:
            r112 = r27;
            r31 = 0.0f;
            goto L124
        L98:
            if (r29 <= r110) goto L100;
            float r34 = r27 - r111;
        L120:
            r31 = r34 / 2;
            goto L123
        L100:
            r33 = (r28 - r30) / 2;
        L118:
            r27 = r111;
            goto L125
        L102:
            if (r29 > r110) goto L116;
            r31 = -(r111 - r27);
        L116:
            float r114 = (-(r30 - r28)) / 2;
        L117:
            r33 = r114;
            goto L118
        L106:
            if (r29 <= r110) goto L122;
        L109:
            if (r29 <= r110) goto L119;
            r114 = -(r30 - r28);
        L119:
            r34 = -(r111 - r27);
            goto L120
        L112:
            if (r29 <= r110) goto L119;
        L115:
            if (r29 <= r110) goto L119;
        L87:
            r111 = r28 * r110;
            r30 = r28;
        L85:
            if (r29 <= r110) goto L87;
        L69:
            r28 = 0.0f;
            goto L70
        L66:
            r27 = 0.0f;
            goto L67
        }
    }

    public static final class c implements ILoopListener {
        public final /* synthetic */ k a;

        public c(k r1) {
            this.a = r1;
        }

        public final boolean needContinueLoop() {
            IPlayerLoopListener r0 = this.a.d;
            if (r0 != null) goto L7;
            return true;
        L7:
            return r0.needContinueLoop();
        }
    }

    public static final class d implements IMonitor {
        public final /* synthetic */ k a;

        public d(k r1) {
            this.a = r1;
        }

        public final void a(String r2, Exception r3) {
            jy0.b.b("LiveTextureViewPlayerController", BuildConfig.FLAVOR, r3);
        }

        public final void monitor(boolean r9, String r10, int r11, int r13, String r14) {
            Object r0 = this.a.f;
            monitor-enter(r0);
            IResultMonitor r2 = this.a.e;     // Catch: Throwable -> L9
            if (r2 == null) goto L7;
            r2.monitor(r9, r10, r11, r13, r14);     // Catch: Throwable -> L9
            Unit r15 = Unit.INSTANCE;     // Catch: Throwable -> L9
        L7:
            monitor-exit(r0);
            return;
        L9:
            th = move-exception;
            throw th;
        }
    }

    public final class e implements IPlayerController.OnElementClickListener {
        public final /* synthetic */ Function1 a;

        public e(Function1 r1) {
            this.a = r1;
        }

        public final /* synthetic */ void a(List r2) {
            this.a.invoke(r2);
        }
    }

    static {
    }

    public final void removePlayerActionListener() {
        this.b = null;
    }

    public final void cancel() {
        PlayerController r0 = this.c;
        if (r0 == null) goto L6;
        r0.cancel();
        return;
    }

    public final View getAlphaView() {
        PlayerController r0 = this.c;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getView();
    }

    public final int getDuration() {
        PlayerController r0 = this.c;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.getDuration();
    }

    public final boolean isPlaying() {
        PlayerController r0 = this.c;
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.isPlaying();
    }

    public final void pause() {
        PlayerController r0 = this.c;
        if (r0 == null) goto L6;
        r0.pause();
        return;
    }

    public final void release() {
        PlayerController r0 = this.c;
        if (r0 == null) goto L5;
        r0.release();
    L5:
        this.g = null;
        this.a = null;
        this.l = null;
    }

    public final void removeMonitor() {
        Object r0 = this.f;
        monitor-enter(r0);
        this.e = null;     // Catch: Throwable -> L8
        Unit r1 = Unit.INSTANCE;     // Catch: Throwable -> L8
        monitor-exit(r0);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public final void resume() {
        PlayerController r0 = this.c;
        if (r0 == null) goto L6;
        r0.resume();
        return;
    }

    public final void stop() {
        PlayerController r0 = this.c;
        if (r0 == null) goto L5;
        r0.stop();
    L5:
        IPlayerActionListener r1 = this.b;
        if (r1 == null) goto L9;
        r1.onStop();
        return;
    }

    public final void stopWhenSlideSwitch() {
        PlayerController r0 = this.c;
        if (r0 == null) goto L6;
        r0.reset();
        return;
    }

    public final boolean getEnableCropView() {
        return this.h;
    }

    public k(Context r1) {
        this.l = r1;
        this.f = new Object();
        this.h = true;
        this.i = new b(this);
        this.j = new d(this);
        this.k = new c(this);
    }

    public final void attachAlphaView(ViewGroup r2) {
        Intrinsics.checkNotNullParameter(r2, "container");
        PlayerController r0 = this.c;
        if (r0 == null) goto L6;
        r0.attachAlphaView(r2);
        return;
    }

    public final void detachAlphaView(ViewGroup r2) {
        Intrinsics.checkNotNullParameter(r2, "container");
        PlayerController r0 = this.c;
        if (r0 == null) goto L6;
        r0.detachAlphaView(r2);
        return;
    }

    public final void initialize(LifecycleOwner r10) {
        Intrinsics.checkNotNullParameter(r10, "owner");
        this.a = r10;
        LiveTextureViewPlayerController$createPlayerController$isNull$1 r0 = LiveTextureViewPlayerController$createPlayerController$isNull$1.INSTANCE;
        Context r1 = this.l;
        if (r1 != null) goto L5;
        r0.invoke();
        return;
    L5:
        if (r10 != null) goto L7;
        r0.invoke();
        return;
    L7:
        PlayerController r2 = this.c;
        if (r2 == null) goto L10;
        r2.release();
    L10:
        PlayerController r3 = null;
        this.g = null;
        Configuration r4 = new Configuration();
        r4.a = this.l;
        r4.b = r10;
        r4.c = 1;
        Intrinsics.checkNotNullParameter(r4, "configuration");
        Boolean r5 = m;
        if (r5 == null) goto L13;
        boolean r6 = r5.booleanValue();
    L24:
        if (r6 == false) goto L26;
        r4.f = ((Boolean) com.bytedance.android.livesdk.gift.platform.business.effect.a.D.getValue(null, com.bytedance.android.livesdk.gift.platform.business.effect.a.a[28])).booleanValue();
    L26:
        int r7 = com.bytedance.android.livesdk.gift.platform.business.effect.a.g();
        if (r7 != 1) goto L32;
        if (ay1.b.o() == true) goto L32;
        DefaultSystemPlayer r11 = new DefaultSystemPlayer();
    L35:
        this.g = r11;
        Intrinsics.checkNotNull(r11);
        PlayerController r8 = new PlayerController(r4, r11);
        this.c = r8;
        r8.h = this.i;
        r8.g = this.j;
        r8.w = this.k;
        if ((r8 instanceof PlayerController) == false) goto L39;
        r3 = r8;
    L39:
        if (r3 == null) goto L46;
        m r13 = new m(this);
        r3.getClass();
        r3.m.setFirstGLFrameListener(r13);
        return;
    L46:
        return;
    L32:
        if (r7 != 4) goto L34;
        r11 = new t(r1);
        goto L35
    L34:
        r11 = new u(r1);
        goto L35
    L13:
        Method[] r9 = Configuration.class.getDeclaredMethods();
        int r14 = r9.length;
        int r15 = 0;
    L14:
        if (r15 >= r14) goto L19;
        Method r16 = r9[r15];
        if (Intrinsics.areEqual(r16.getName(), "setEnableElementEvent") == true) goto L20;
        r15 = r15 + 1;
    L20:
        if (r16 == null) goto L22;
        r6 = true;
    L23:
        m = Boolean.valueOf(r6);
        goto L24
    L22:
        r6 = false;
        goto L23
    L19:
        r16 = null;
        goto L20
    }

    public final void setEnableCropView(boolean r1) {
        this.h = r1;
    }

    public final void setMaskSrc(MaskSrc r4) {
        Intrinsics.checkNotNullParameter(r4, "maskSrc");
        PlayerController r0 = this.c;
        if (r0 == null) goto L6;
        com.ss.android.ugc.aweme.live.alphaplayer.model.MaskSrc r1 = new com.ss.android.ugc.aweme.live.alphaplayer.model.MaskSrc();
        r1.a = r4.getName();
        r1.b = r4.getType();
        r4.getWidth();
        r4.getHeight();
        r1.c = r4.getText();
        r1.d = r4.getTextColor();
        r1.e = r4.getTextSize();
        r1.f = r4.isBold();
        r1.g = r4.getBitmap();
        r1.h = r4.isUseBitmapSize();
        Unit r5 = Unit.INSTANCE;
        r0.h(r1);
        return;
    }

    public final void setMonitor(IResultMonitor r2) {
        Intrinsics.checkNotNullParameter(r2, "monitor");
        this.e = r2;
    }

    public final void setOnElementClickListener(Function1<? super List<String>, Unit> r3) {
        Intrinsics.checkNotNullParameter(r3, "onclick");
        PlayerController r0 = this.c;
        if (r0 == null) goto L6;
        r0.o(new e(r3));
        return;
    }

    public final void setPlayerActionListener(IPlayerActionListener r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.b = r2;
    }

    public final void setPlayerLooperListener(IPlayerLoopListener r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.d = r2;
    }

    public final void start(String r15, boolean r16, boolean r17, boolean r18, PlayConfig r19) {
        Intrinsics.checkNotNullParameter(r15, "filePath");
        PlayerController r3 = this.c;
        if (r3 == null) goto L55;
        jy0.b.a("LiveTextureViewPlayerController", "start() called with: playerController = [" + r3 + ']');
        String r5 = m02.b.b(m02.b.a(r15));
        if (r5 != null) goto L7;
    L48:
        IResultMonitor r6 = this.e;
        if (r6 == null) goto L57;
        r6.monitor(false, BuildConfig.FLAVOR, 0, 0, "configJson is null");
        return;
    L57:
        return;
    L7:
        if (r5.length() != 0) goto L9;
        boolean r0 = true;
    L10:
        if (r0 == true) goto L48;
        DataSource.DataInfo r7 = null;
        i02.g r1 = (i02.g) GsonProtectorUtils.fromJson(GsonHelper.getDefault(), r5, i02.g.class);     // Catch: JsonSyntaxException -> L15
    L17:
        if (r1 != null) goto L22;
        IResultMonitor r8 = this.e;
        if (r8 == null) goto L54;
        r8.monitor(false, BuildConfig.FLAVOR, 0, 0, "Gson convert failed: ".concat(r5));
        return;
    L54:
        return;
    L22:
        DataSource r4 = new DataSource();
        r4.d = r16;
        i02.g.b r9 = r1.portrait;
        if (r9 == null) goto L28;
        DataSource.DataInfo r10 = new DataSource.DataInfo(r15 + File.separator + r9.path);
        r10.d(r9.align);
        r10.j = r9.version;
        r10.c = r9.totalFrame;
        r10.f = r9.videoWidth;
        r10.g = r9.videoHeight;
        r10.h = r9.actualWidth;
        r10.i = r9.actualHeight;
        r10.b(r9.alphaFrame);
        r10.c(r9.rgbFrame);
        r10.k = r9.masks;
        r10.l = r9.a();
        if (PadConfigUtils.c() == false) goto L27;
        r4.b(r10);
    L27:
        Unit r11 = Unit.INSTANCE;
        r4.c(r10);
    L28:
        if (r19 != null) goto L30;
    L38:
        i02.g.b r2 = r1.landscape;
        if (r2 == null) goto L41;
        DataSource.DataInfo r13 = new DataSource.DataInfo(r15 + File.separator + r2.path);
        r13.d(r2.align);
        r13.j = r2.version;
        r13.c = r2.totalFrame;
        r13.f = r2.videoWidth;
        r13.g = r2.videoHeight;
        r13.h = r2.actualWidth;
        r13.i = r2.actualHeight;
        r13.b(r2.alphaFrame);
        r13.c(r2.rgbFrame);
        r13.k = r2.masks;
        r13.l = r2.a();
        r4.b(r13);
    L41:
        AbsPlayer r14 = this.g;
        if ((r14 instanceof t) == false) goto L47;
        if (r14 == null) goto L46;
        ((t) r14).m = r17;
        goto L47
    L46:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.gift.platform.business.effect.player.TTEnginePlayerImpl");
    L47:
        r3.f(r4, r18);
        return;
    L30:
        if (r19.getForceUsePortrait() != true) goto L38;
        DataSource.DataInfo r20 = DataSource.DataInfo.a(r4.b);
        if (r20 == null) goto L37;
        Integer r21 = r19.getScaleType();
        if (r21 == null) goto L36;
        r20.d(r21.intValue());
    L36:
        r7 = r20;
    L37:
        r4.b(r7);
    L15:
        e = move-exception;
        jy0.b.b("LiveTextureViewPlayerController", "videoFileModel parse error", e);
        r1 = null;
        goto L17
    L9:
        r0 = false;
        goto L10
    }
}
