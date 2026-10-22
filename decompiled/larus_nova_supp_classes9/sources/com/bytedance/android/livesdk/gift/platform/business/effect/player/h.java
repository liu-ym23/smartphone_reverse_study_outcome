package com.bytedance.android.livesdk.gift.platform.business.effect.player;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.gift.model.CardLockInfo;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.android.livesdk.widget.EdgeTransparentView;
import com.bytedance.android.livesdkapi.depend.live.gift.ILiveGiftPlayController;
import com.bytedance.android.livesdkapi.depend.live.gift.IPlayerActionListener;
import com.bytedance.android.livesdkapi.depend.live.gift.IPlayerProgressListener;
import com.bytedance.android.livesdkapi.depend.live.gift.IResultMonitor;
import com.bytedance.android.livesdkapi.depend.live.gift.SuperResolutionModel;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.common.utility.Logger;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.google.gson.JsonSyntaxException;
import com.ss.android.ugc.aweme.live.alphaplayer.Configuration;
import com.ss.android.ugc.aweme.live.alphaplayer.controller.IPlayerController;
import com.ss.android.ugc.aweme.live.alphaplayer.controller.PlayerController;
import com.ss.android.ugc.aweme.live.alphaplayer.listener.AlphaPlayerAction;
import com.ss.android.ugc.aweme.live.alphaplayer.listener.IMonitor;
import com.ss.android.ugc.aweme.live.alphaplayer.model.DataSource;
import com.ss.android.ugc.aweme.live.alphaplayer.model.MaskSrc;
import com.ss.android.ugc.aweme.live.alphaplayer.player.AbsPlayer;
import com.ss.android.ugc.aweme.live.alphaplayer.player.DefaultSystemPlayer;
import java.io.File;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class h implements ILiveGiftPlayController {
    public Context a;
    public LifecycleOwner b;
    public IPlayerActionListener c;
    public IResultMonitor d;
    public final Object e;
    public IPlayerController f;
    public AbsPlayer g;
    public SuperResolutionModel h;
    public final a i;
    public final b j;

    public class a implements AlphaPlayerAction {
        public final /* synthetic */ h a;

        public final void a() {
            IPlayerActionListener r0 = this.a.c;
            if (r0 == null) goto L6;
            r0.onStart();
            return;
        }

        public final void b() {
            IPlayerActionListener r0 = this.a.c;
            if (r0 == null) goto L8;
            r0.onEnd();
            HashSet r1 = da0.a.a;
            Iterator r2 = da0.a.a.iterator();
        L6:
            if (r2.hasNext() == false) goto L10;
            ((ca0.p) r2.next()).k();
            goto L6
        L10:
            return;
        }

        public a(h r1) {
            this.a = r1;
        }

        public final void c(int r11, int r13, DataSource.ScaleType r14) {
            float r15 = r11;
            float r16 = r13;
            View r0 = this.a.f.getView();
            if (r0 != null) goto L5;
        L35:
            h r1 = this.a;
            if (r1.c == null) goto L94;
            View r2 = r1.f.getView();
            int r3 = r2.getMeasuredWidth();
            int r4 = r2.getMeasuredHeight();
            h r5 = this.a;
            float r6 = r3;
            float r7 = r4;
            r5.getClass();
            float r8 = r6 / r7;
            float r17 = r15 / r16;
            if (r14 == DataSource.ScaleType.ScaleAspectFill) goto L52;
            if (r14 == DataSource.ScaleType.TopFill) goto L52;
            if (r14 == DataSource.ScaleType.BottomFill) goto L52;
            if (r14 == DataSource.ScaleType.RightFill) goto L52;
            if (r14 == DataSource.ScaleType.LeftFill) goto L52;
            if (r8 > r17) goto L54;
        L53:
            float r9 = r6 / r17;
            float r18 = r6;
        L55:
            float r10 = 0.0f;
            switch(c.a[r14.ordinal()]) {
                case 1: goto L86;
                case 2: goto L80;
                case 3: goto L77;
                case 4: goto L74;
                case 5: goto L71;
                case 6: goto L67;
                case 7: goto L63;
                case 8: goto L61;
                case 9: goto L60;
                case 10: goto L59;
                case 11: goto L58;
                default: goto L87;
            };
        L58:
            float r19 = r17 * r7;
            float r20 = r6 - r19;
        L89:
            r9 = r7;
            r10 = r20;
            float r21 = 0.0f;
            r6 = r19;
        L90:
            IPlayerActionListener r110 = r5.c;
            if (r110 == null) goto L95;
            r110.updateTextEffectPosition(r6, r9, r10, r21);
            return;
        L95:
            return;
        L59:
            r6 = r7 * r17;
            goto L86
        L60:
            r9 = r6 / r17;
            r21 = r7 - r9;
            goto L90
        L61:
            r7 = r6 / r17;
        L86:
            r19 = r6;
            r20 = 0.0f;
        L87:
            r20 = 0.0f;
        L88:
            r19 = r18;
            r7 = r9;
            goto L89
        L63:
            if (r8 <= r17) goto L65;
            float r23 = r6 - r18;
        L85:
            r20 = r23 / 2.0f;
            goto L88
        L65:
            r21 = (r7 - r9) / 2.0f;
        L83:
            r6 = r18;
            goto L90
        L67:
            if (r8 > r17) goto L81;
            r20 = -(r18 - r6);
        L81:
            float r111 = (-(r9 - r7)) / 2.0f;
        L82:
            r21 = r111;
            goto L83
        L71:
            if (r8 <= r17) goto L87;
        L74:
            if (r8 <= r17) goto L84;
            r111 = -(r9 - r7);
        L84:
            r23 = -(r18 - r6);
            goto L85
        L77:
            if (r8 <= r17) goto L84;
        L80:
            if (r8 <= r17) goto L84;
        L54:
            r18 = r7 * r17;
            r9 = r7;
        L52:
            if (r8 <= r17) goto L54;
        L94:
            return;
        L5:
            if (r0.getParent() == null) goto L35;
            if ((r0.getParent() instanceof FrameLayout) == false) goto L35;
            EdgeTransparentView r24 = (FrameLayout) r0.getParent();
            FrameLayout.LayoutParams r25 = (FrameLayout.LayoutParams) r24.getLayoutParams();
            int r26 = s1.y();
            int r27 = s1.w();
            float r28 = r16 / r15;
            switch(c.a[r14.ordinal()]) {
                case 7: goto L16;
                case 8: goto L15;
                case 9: goto L14;
                case 10: goto L13;
                case 11: goto L12;
                default: goto L11;
            };
        L11:
            r25.width = -1;
            r25.height = -1;
            r25.gravity = 17;
        L22:
            if (vh6.c.b(wh6.a.class).getCurrentActivity() != null) goto L24;
        L34:
            r24.setLayoutParams(r25);
            goto L35
        L24:
            if ((r24 instanceof EdgeTransparentView) == false) goto L34;
            if (PadConfigUtils.c() == false) goto L28;
        L29:
            float r29 = r26;
            if (r26 <= r27) goto L32;
            float r30 = 0.3f;
        L33:
            float r31 = (int) (r29 * r30);
            float r33 = r31 * 0.12f;
            int r34 = (int) ((r33 * 2.0f) + r31);
            float r35 = r31 * r28;
            r24.a(15, r33);
            r25.width = r34;
            r25.height = (int) (r35 + (0.12f * r35));
            r25.gravity = 81;
            goto L34
        L32:
            r30 = 0.5f;
            goto L33
        L28:
            if (com.bytedance.android.livesdk.gift.util.a.a() == false) goto L34;
        L12:
            r25.height = r27;
            r25.width = (int) (r27 / r28);
            r25.gravity = 8388613;
            goto L22
        L13:
            r25.height = r27;
            r25.width = (int) (r27 / r28);
            r25.gravity = 8388611;
            goto L22
        L14:
            r25.width = r26;
            r25.height = (int) (r26 * r28);
            r25.gravity = 80;
            goto L22
        L15:
            r25.width = r26;
            r25.height = (int) (r26 * r28);
            r25.gravity = 48;
            goto L22
        L16:
            float r36 = r27;
            float r37 = r26 * r28;
            if (r36 <= r37) goto L19;
            r25.width = r26;
            r25.height = (int) r37;
        L20:
            r25.gravity = 17;
            goto L22
        L19:
            r25.height = r27;
            r25.width = (int) (r36 / r28);
            goto L20
        }
    }

    public class b implements IMonitor {
        public final /* synthetic */ h a;

        public b(h r1) {
            this.a = r1;
        }

        public final void a(String r3, Exception r4) {
            jy0.b.b("LiveGiftPlay", "create " + r3 + " failure, errorMsg: ", r4);
        }

        public final void monitor(boolean r9, String r10, int r11, int r13, String r14) {
            Object r0 = this.a.e;
            monitor-enter(r0);
            IResultMonitor r2 = this.a.d;     // Catch: Throwable -> L9
            if (r2 == null) goto L7;
            r2.monitor(r9, r10, r11, r13, r14);     // Catch: Throwable -> L9
        L7:
            monitor-exit(r0);     // Catch: Throwable -> L9
            return;
        L9:
            th = move-exception;
            throw th;
        }
    }

    public static /* synthetic */ class c {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[DataSource.ScaleType.values().length];
            a = r0;
            r0[DataSource.ScaleType.ScaleToFill.ordinal()] = 1;     // Catch: NoSuchFieldError -> L15
        L28:
            a[DataSource.ScaleType.ScaleAspectFill.ordinal()] = 2;     // Catch: NoSuchFieldError -> L16
        L34:
            a[DataSource.ScaleType.TopFill.ordinal()] = 3;     // Catch: NoSuchFieldError -> L17
        L46:
            a[DataSource.ScaleType.BottomFill.ordinal()] = 4;     // Catch: NoSuchFieldError -> L18
        L30:
            a[DataSource.ScaleType.LeftFill.ordinal()] = 5;     // Catch: NoSuchFieldError -> L19
        L36:
            a[DataSource.ScaleType.RightFill.ordinal()] = 6;     // Catch: NoSuchFieldError -> L20
        L40:
            a[DataSource.ScaleType.ScaleAspectFitCenter.ordinal()] = 7;     // Catch: NoSuchFieldError -> L21
        L42:
            a[DataSource.ScaleType.TopFit.ordinal()] = 8;     // Catch: NoSuchFieldError -> L22
        L26:
            a[DataSource.ScaleType.BottomFit.ordinal()] = 9;     // Catch: NoSuchFieldError -> L23
        L32:
            a[DataSource.ScaleType.LeftFit.ordinal()] = 10;     // Catch: NoSuchFieldError -> L24
        L38:
            a[DataSource.ScaleType.RightFit.ordinal()] = 11;     // Catch: NoSuchFieldError -> L25
            return;
        }
    }

    public final void removePlayerActionListener() {
        this.c = null;
    }

    public final void cancel() {
        IPlayerController r0 = this.f;
        if (r0 == null) goto L6;
        r0.cancel();
        return;
    }

    public final View getAlphaView() {
        IPlayerController r0 = this.f;
        if (r0 != null) goto L5;
        return null;
    L5:
        return r0.getView();
    }

    public final int getDuration() {
        return this.g.getVideoInfo().c;
    L4:
        return 0;
    }

    public final String getPlayerType() {
        IPlayerController r0 = this.f;
        if (r0 != null) goto L7;
        return CardLockInfo.sUNKNOWN;
    L7:
        return r0.getPlayerType();
    }

    public final boolean isPlaying() {
        IPlayerController r0 = this.f;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.isPlaying() == false) goto L7;
        return true;
    }

    public final void release() {
        if (this.f == null) goto L5;
        jy0.b.a("LiveGiftPlay", "release() called with: playerController = [" + this.f + "]");
        this.f.g(null);
        this.f.c(null);
        this.f.release();
        this.f = null;
    L5:
        this.b = null;
        this.a = null;
        this.c = null;
        Object r0 = this.e;
        monitor-enter(r0);
        this.d = null;     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public final void removeMonitor() {
        Object r0 = this.e;
        monitor-enter(r0);
        this.d = null;     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public final void stop() {
        IPlayerController r0 = this.f;
        if (r0 == null) goto L8;
        r0.stop();
        IPlayerActionListener r1 = this.c;
        if (r1 == null) goto L9;
        r1.onStop();
        return;
    L9:
        return;
    }

    public final void stopWhenSlideSwitch() {
        if (this.f == null) goto L6;
        jy0.b.a("LiveGiftPlay", "stopWhenSlideSwitch() called with: playerController = [" + this.f + "]");
        this.f.reset();
        return;
    }

    public h(Context r2) {
        this.e = new Object();
        this.i = new a(this);
        this.j = new b(this);
        this.a = r2;
        com.bytedance.android.livesdk.gift.platform.business.effect.a.e();
    }

    public final void attachAlphaView(ViewGroup r3) {
        if (this.f == null) goto L6;
        jy0.b.a("LiveGiftPlay", "attachAlphaView() called with: playerController = [" + this.f + "]");
        this.f.attachAlphaView(r3);
        return;
    }

    public final void detachAlphaView(ViewGroup r3) {
        if (this.f == null) goto L6;
        jy0.b.a("LiveGiftPlay", "detachAlphaView() called with: playerController = [" + this.f + "]");
        this.f.detachAlphaView(r3);
        return;
    }

    public final void initialize(LifecycleOwner r6) {
        this.b = r6;
        if (this.a == null) goto L27;
        if (r6 == null) goto L27;
        IPlayerController r7 = this.f;
        if (r7 == null) goto L9;
        r7.release();
    L9:
        Configuration r8 = new Configuration();
        r8.a = this.a;
        r8.b = this.b;
        if (PadConfigUtils.c() == false) goto L12;
    L13:
        r8.c = 1;
    L14:
        int r0 = com.bytedance.android.livesdk.gift.platform.business.effect.a.g();
        if (r0 != 1) goto L20;
        if (ay1.b.o() == true) goto L20;
        DefaultSystemPlayer r1 = new DefaultSystemPlayer();
    L23:
        this.g = r1;
        if (((Boolean) com.bytedance.android.livesdk.gift.platform.business.effect.a.x.getValue(null, com.bytedance.android.livesdk.gift.platform.business.effect.a.a[22])).booleanValue() == false) goto L26;
        r8.c = 1;
    L26:
        PlayerController r2 = new PlayerController(r8, r1);
        this.f = r2;
        r2.h = this.i;
        r2.c(this.j);
        return;
    L20:
        if (r0 != 4) goto L22;
        r1 = new t(this.a);
        goto L23
    L22:
        r1 = new u(this.a);
        goto L23
    L12:
        if (com.bytedance.android.livesdk.gift.util.a.a() == false) goto L14;
    L27:
        Logger.e("LiveGiftPlay", "context or lifecycleOwner is null!");
    }

    public final void setMonitor(IResultMonitor r2) {
        Object r0 = this.e;
        monitor-enter(r0);
        this.d = r2;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public final void setPlayerActionListener(IPlayerActionListener r1) {
        this.c = r1;
    }

    public final void setSuperResolutionModel(SuperResolutionModel r1) {
        this.h = r1;
    }

    public final void setImageMask(String r3, Bitmap r4) {
        IPlayerController r0 = this.f;
        if (r0 == null) goto L6;
        MaskSrc r1 = new MaskSrc();
        r1.a = r3;
        r1.b = 1;
        r1.g = r4;
        r0.h(r1);
        return;
    }

    public final void setPlayerProgressListener(final IPlayerProgressListener r3, long r4) {
        IPlayerController r0 = this.f;
        if (r0 == null) goto L6;
        Objects.requireNonNull(r3);
        r0.b(new g(r3), r4);
        return;
    }

    public final int start(String r11, long r13) {
        if (this.f == null) goto L62;
        jy0.b.a("LiveGiftPlay", "start() called with: playerController = [" + this.f + "]");
        String r2 = m02.b.a(r11);
        String r3 = m02.b.b(r2);
        if (r3 != null) goto L7;
    L51:
        boolean r14 = new PolarisFileWrapper(r2).exists();
        Object r15 = this.e;
        monitor-enter(r15);
        IResultMonitor r4 = this.d;     // Catch: Throwable -> L59
        if (r4 == null) goto L56;
        r4.monitor(false, BuildConfig.FLAVOR, 9, 0, "configJson is null; exist:" + r14);     // Catch: Throwable -> L59
    L56:
        monitor-exit(r15);     // Catch: Throwable -> L59
        com.bytedance.android.livesdk.gift.platform.core.b.c(r11);
        return 9;
    L59:
        th = move-exception;
        throw th;
    L7:
        if (r3.isEmpty() == true) goto L51;
        i02.g r1 = (i02.g) GsonProtectorUtils.fromJson(GsonHelper.getDefault(), r3, i02.g.class);     // Catch: JsonSyntaxException -> L11
    L20:
        if (r1 != null) goto L32;
        Object r5 = this.e;
        monitor-enter(r5);
        IResultMonitor r6 = this.d;     // Catch: Throwable -> L29
        if (r6 == null) goto L26;
        r6.monitor(false, BuildConfig.FLAVOR, 10, 0, "Gson convert failed: " + r3.replaceAll("\\s", BuildConfig.FLAVOR));     // Catch: Throwable -> L29
    L26:
        monitor-exit(r5);     // Catch: Throwable -> L29
        com.bytedance.android.livesdk.gift.platform.core.b.c(r11);
        return 10;
    L29:
        th = move-exception;
        throw th;
    L32:
        DataSource r0 = new DataSource();
        r0.f = r13;
        if (r1.landscape == null) goto L36;
        DataSource.DataInfo r16 = new DataSource.DataInfo(r11 + File.separator + r1.landscape.path);
        r16.d(r1.landscape.align);
        i02.g.b r17 = r1.landscape;
        r16.j = r17.version;
        r16.c = r17.totalFrame;
        r16.f = r17.videoWidth;
        r16.g = r17.videoHeight;
        r16.h = r17.actualWidth;
        r16.i = r17.actualHeight;
        r16.b(r17.alphaFrame);
        r16.c(r1.landscape.rgbFrame);
        r16.k = r1.landscape.masks;
        r0.b(r16);
    L36:
        if (r1.portrait == null) goto L42;
        DataSource.DataInfo r18 = new DataSource.DataInfo(r11 + File.separator + r1.portrait.path);
        r18.d(r1.portrait.align);
        i02.g.b r19 = r1.portrait;
        r18.j = r19.version;
        r18.c = r19.totalFrame;
        r18.f = r19.videoWidth;
        r18.g = r19.videoHeight;
        r18.h = r19.actualWidth;
        r18.i = r19.actualHeight;
        r18.b(r19.alphaFrame);
        r18.c(r1.portrait.rgbFrame);
        r18.k = r1.portrait.masks;
        r0.c(r18);
        if (PadConfigUtils.c() == false) goto L40;
    L41:
        r0.b(r18);
        goto L42
    L40:
        if (com.bytedance.android.livesdk.gift.util.a.a() == true) goto L41;
    L42:
        AbsPlayer r110 = this.g;
        if ((r110 instanceof t) == false) goto L45;
        ((t) r110).l = this.h;
    L45:
        this.f.d(r0);
        Iterator r111 = da0.a.a.iterator();
    L47:
        if (r111.hasNext() == false) goto L49;
        ((ca0.p) r111.next()).m();
        goto L47
    L49:
        return 12;
    L11:
        e = move-exception;
        jy0.b.b("LiveGiftPlay", "videoFileModel parse fail", e);
        String r7 = v12.f.a;
        Intrinsics.checkNotNullParameter(r3, "errorMessage");
        if (com.bytedance.android.livesdk.gift.platform.core.f.b() == false) goto L19;
        String r8 = v12.f.i(String.valueOf(r13));
        if (r8 != null) goto L18;
        r8 = "0";
    L18:
        v12.f.C(r3, r8);
    L19:
        r1 = null;
        goto L20
    L62:
        Object r112 = this.e;
        monitor-enter(r112);
        IResultMonitor r9 = this.d;     // Catch: Throwable -> L70
        if (r9 == null) goto L67;
        r9.monitor(false, BuildConfig.FLAVOR, 11, 0, "player controller is null");     // Catch: Throwable -> L70
    L67:
        monitor-exit(r112);     // Catch: Throwable -> L70
        return 11;
    L70:
        th = move-exception;
        throw th;
    }

    public final void setTextMask(String r3, String r4, String r5, int r6, boolean r7) {
        IPlayerController r0 = this.f;
        if (r0 == null) goto L6;
        MaskSrc r1 = new MaskSrc();
        r1.a = r3;
        r1.b = 0;
        r1.d = r5;
        r1.e = r6;
        r1.f = r7;
        r1.c = r4;
        r0.h(r1.setFixSpecialSymbolHeight(((Boolean) com.bytedance.android.livesdk.gift.platform.business.effect.a.P.getValue(null, com.bytedance.android.livesdk.gift.platform.business.effect.a.a[40])).booleanValue()));
        return;
    }
}
