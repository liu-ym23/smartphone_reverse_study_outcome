package com.bytedance.android.livesdk.gift.platform.business.normal.view.v2;

import android.animation.Animator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Typeface;
import android.graphics.drawable.Animatable;
import android.os.Build;
import android.text.Html;
import android.text.Spanned;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import com.bytedance.android.live.base.model.message.a5;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.revenue.common.ViewUtilsKt;
import com.bytedance.android.live.revenue.common.f0;
import com.bytedance.android.livesdk.chatroom.utils.a1;
import com.bytedance.android.livesdk.gift.model.h2;
import com.bytedance.android.livesdk.gift.model.o0;
import com.bytedance.android.livesdk.gift.platform.business.normal.model.NormalGiftMessage;
import com.bytedance.android.livesdk.gift.platform.business.normal.utils.GiftImageFormat;
import com.bytedance.android.livesdk.gift.platform.business.normal.view.BaseNormalGiftCombView;
import com.bytedance.android.livesdk.gift.platform.business.tray2.GiftTrayMessageManager;
import com.bytedance.android.livesdk.gift.platform.core.manager.GiftManagerKt;
import com.bytedance.android.livesdk.gift.util.GiftImageLoader;
import com.bytedance.android.livesdk.message.model.o7;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.android.livesdk.r3;
import com.bytedance.android.livesdk.widget.roundcorner.RoundCornerImageView;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.imagepipeline.image.ImageInfo;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001&B'\b\u0007\u0012\u0006\u0010 \u001a\u00020\u001f\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010!\u0012\b\b\u0002\u0010#\u001a\u00020\t¢\u0006\u0004\b$\u0010%J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0016J\u0012\u0010\u000e\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J\u0012\u0010\u0011\u001a\u00020\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016R$\u0010\u0019\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001c\u001a\u00020\u00068BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001e\u001a\u00020\u00068BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001b¨\u0006'"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/normal/view/v2/GamePlatformGiftCombView;", "Lcom/bytedance/android/livesdk/gift/platform/business/normal/view/BaseNormalGiftCombView;", "Lcom/bytedance/android/livesdk/gift/platform/business/normal/model/NormalGiftMessage;", "msg", BuildConfig.FLAVOR, "setGiftMessageAndDuration", BuildConfig.FLAVOR, "showCombo", "setShowCombo", BuildConfig.FLAVOR, "orientation", "setRoomOrientation", "Ls02/c;", "listener", "setClickListener", "Ls02/b;", "callback", "setGiftControllerCallback", "Lio/reactivex/disposables/Disposable;", "q", "Lio/reactivex/disposables/Disposable;", "getDispose", "()Lio/reactivex/disposables/Disposable;", "setDispose", "(Lio/reactivex/disposables/Disposable;)V", "dispose", "getShowDynamicGiftIcon", "()Z", "showDynamicGiftIcon", "getAutoExit", "autoExit", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class GamePlatformGiftCombView extends BaseNormalGiftCombView {
    public static final /* synthetic */ int r = 0;
    public Map<Integer, View> a;
    public long b;
    public Animator c;
    public boolean d;
    public NormalGiftMessage e;
    public Disposable f;
    public boolean g;
    public boolean h;
    public boolean i;
    public final n12.f j;
    public final q02.a k;
    public s02.a l;
    public s02.b m;
    public int n;
    public final boolean o;
    public final b p;
    public Disposable q;

    public static final class a {
    }

    public static final class b implements q02.d {
        public final /* synthetic */ GamePlatformGiftCombView a;

        public static final class a<T> implements Consumer {
            public final /* synthetic */ b a;

            public a(b r1) {
                this.a = r1;
            }

            public final void accept(Object r1) {
                Long r2 = (Long) r1;
                this.a.f();
            }
        }

        @Override // q02.d
        public final void a() {
            if (b02.a.b(this.a.e) == false) goto L5;
        L6:
            GamePlatformGiftCombView r0 = this.a;
            if (r0.d == true) goto L9;
        L13:
            c();
            return;
        L9:
            if (r0.o(2131367231) == null) goto L13;
            ((LinearLayout) this.a.o(2131367231)).setVisibility(0);
            GamePlatformGiftCombView r1 = this.a;
            r1.c = r1.k.d(r1.o(2131367231), this);
            GamePlatformGiftCombView r2 = this.a;
            r2.h = true;
            Animator r3 = r2.c;
            if (r3 == null) goto L15;
            r3.start();
            return;
        L15:
            return;
        L5:
            if ((this.a.e instanceof com.bytedance.android.livesdk.gift.platform.business.tray.a) == true) goto L13;
            goto L6
        }

        @Override // q02.d
        public final void b() {
            s02.a r0 = this.a.l;
            if (r0 == null) goto L6;
            r0.onExit();
            return;
        }

        @Override // q02.d
        public final void c() {
            Disposable r0 = this.a.f;
            if (r0 == null) goto L6;
            r0.dispose();
        L6:
            if (GamePlatformGiftCombView.p(this.a) == false) goto L8;
            GamePlatformGiftCombView r1 = this.a;
            r1.f = Observable.timer(r1.b, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new a(this));
        L8:
            GamePlatformGiftCombView r2 = this.a;
            NormalGiftMessage r3 = r2.e;
            if (r3 == null) goto L11;
            int r4 = r3.g;
        L12:
            long r5 = r4;
            if (r3 == null) goto L15;
            long r6 = r3.k;
        L16:
            long r7 = r5 * r6;
            n12.f r8 = r2.j;
            if ((r8 instanceof n12.c) == false) goto L23;
            ((n12.c) r8).getClass();
            if (n12.c.m(r7) < 2) goto L23;
            GiftIconMaskView r9 = (GiftIconMaskView) this.a.o(2131373725);
            if (r9 == null) goto L23;
            r9.b();
        L23:
            GamePlatformGiftCombView r10 = this.a;
            r10.h = false;
            s02.a r11 = r10.l;
            if (r11 == null) goto L27;
            r11.onWaiting();
            return;
        L27:
            return;
        L15:
            r6 = 0;
            goto L16
        L11:
            r4 = 0;
            goto L12
        }

        @Override // q02.d
        public final void d() {
            s02.b r0 = this.a.m;
            if (r0 == null) goto L6;
            r0.onPlay();
            return;
        }

        @Override // q02.d
        public final void e() {
            s02.b r0 = this.a.m;
            if (r0 == null) goto L6;
            r0.onPlay();
            return;
        }

        public final void f() {
            GiftTrayMessageManager r0 = GiftTrayMessageManager.r;
            if (GiftTrayMessageManager.a.a().l == false) goto L6;
            this.a.i = true;
            ALogger.d("PauseAnim", "GamePlatformGiftCombView isExitAnimationDelay=true");
            return;
        L6:
            GamePlatformGiftCombView r1 = this.a;
            int r2 = GamePlatformGiftCombView.r;
            r1.getClass();
            r1.post(new com.bytedance.android.livesdk.gift.platform.business.normal.view.v2.c(r1));
        }

        public b(GamePlatformGiftCombView r1) {
            this.a = r1;
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ HSImageView a;
        public final /* synthetic */ HSImageView b;

        public c(HSImageView r1, HSImageView r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r3) {
            this.a.setVisibility(4);
            HSImageView r0 = this.b;
            r0.setImageBitmap((Bitmap) r3);
        }
    }

    public static final class d<T> implements Consumer {
        public static final d a = null;

        static {
            a = new d();
        }

        public d() {
        }

        public final /* bridge */ /* synthetic */ void accept(Object r1) {
            Throwable r2 = (Throwable) r1;
        }
    }

    public static final class e extends BaseControllerListener<ImageInfo> {
        public final /* synthetic */ HSImageView a;

        public e(HSImageView r1) {
            this.a = r1;
        }

        public final void onFinalImageSet(String r1, Object r2, Animatable r3) {
            ImageInfo r4 = (ImageInfo) r2;
            this.a.setVisibility(4);
        }
    }

    static {
    }

    public GamePlatformGiftCombView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public GamePlatformGiftCombView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.normal.view.BaseNormalGiftCombView
    public final void d(ViewGroup r1) {
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.normal.view.BaseNormalGiftCombView
    public void setClickListener(s02.c r1) {
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.normal.view.BaseNormalGiftCombView
    public void setRoomOrientation(int r1) {
    }

    private final boolean getAutoExit() {
        if (this.o == false) goto L5;
    L8:
        return true;
    L5:
        if ((this.e instanceof com.bytedance.android.livesdk.gift.platform.business.tray.a) == false) goto L8;
        return false;
    }

    private final boolean getShowDynamicGiftIcon() {
        NormalGiftMessage r0 = this.e;
        if (r0 == null) goto L11;
        o7 r1 = r0.r();
        if (r1 == null) goto L11;
        o0 r2 = r1.getTrayInfo();
        if (r2 == null) goto L11;
        py.k r3 = r2.getTrayDynamicImg();
        if (r3 == null) goto L11;
        List r4 = r3.getUrls();
    L12:
        List r5 = r4;
        if (r5 != null) goto L15;
    L18:
        boolean r6 = true;
    L20:
        return !r6;
    L15:
        if (r5.isEmpty() == true) goto L18;
        r6 = false;
    L11:
        r4 = null;
        goto L12
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.normal.view.BaseNormalGiftCombView
    public final void e() {
        if (this.h == false) goto L12;
        Animator r0 = this.c;
        if (r0 != null) goto L7;
        return;
    L7:
        if (r0.isRunning() != true) goto L14;
        Animator r1 = this.c;
        if (r1 == null) goto L15;
        r1.cancel();
        return;
    L15:
        return;
    L14:
        return;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.normal.view.BaseNormalGiftCombView
    public final void f() {
        this.p.f();
        s02.a r0 = this.l;
        if (r0 == null) goto L6;
        r0.onExit();
        return;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.normal.view.BaseNormalGiftCombView
    public final void g() {
        Animator r0 = this.c;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.isRunning() != true) goto L12;
        Animator r1 = this.c;
        if (r1 == null) goto L9;
        r1.pause();
    L9:
        ALogger.d("PauseAnim", "GamePlatformGiftCombView pauseAnimation success");
        return;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.normal.view.BaseNormalGiftCombView
    public final void i() {
        if (this.g == false) goto L5;
        return;
    L5:
        Disposable r0 = this.f;
        if (r0 == null) goto L8;
        r0.dispose();
    L8:
        TextView r1 = (TextView) o(2131367236);
        NormalGiftMessage r2 = this.e;
        if (r2 == null) goto L11;
        Number r3 = Long.valueOf(r2.m);
    L12:
        r1.setText(r3.toString());
        NormalGiftMessage r4 = this.e;
        if (r4 == null) goto L20;
        o7 r5 = r4.r();
        if (r5 == null) goto L20;
        o0 r6 = r5.getTrayInfo();
        if (r6 == null) goto L20;
        if (((int) r6.getTrayLevel()) != this.n) goto L20;
    L49:
        Animator r7 = this.k.d(o(2131367231), this.p);
        this.c = r7;
        this.h = true;
        if (r7 == null) goto L53;
        r7.start();
        return;
    L53:
        return;
    L20:
        NormalGiftMessage r8 = this.e;
        if (r8 == null) goto L27;
        o7 r9 = r8.r();
        if (r9 == null) goto L27;
        o0 r10 = r9.getTrayInfo();
        if (r10 == null) goto L27;
        int r11 = (int) r10.getTrayLevel();
    L29:
        if (this.o == false) goto L49;
        Lazy r13 = GiftImageFormat.a;
        if (r8 == null) goto L35;
        o7 r14 = r8.r();
        if (r14 == null) goto L35;
        o0 r15 = r14.getTrayInfo();
    L36:
        py.k r16 = GiftImageFormat.a(r15);
        if (r16 == null) goto L49;
        if (r8 == null) goto L44;
        o7 r17 = r8.r();
        if (r17 == null) goto L44;
        o0 r18 = r17.getTrayInfo();
        if (r18 == null) goto L44;
        int r19 = (int) r18.getTrayLevel();
    L45:
        this.n = r19;
        ImageLoader.bindImage(o(2131380985), r16);
        if (o(2131380985).getVisibility() != 0) goto L48;
        s((HSImageView) o(2131380985), (HSImageView) o(2131380986), r16, r11);
        goto L49
    L48:
        s((HSImageView) o(2131380986), (HSImageView) o(2131380985), r16, r11);
    L44:
        r19 = 0;
    L35:
        r15 = null;
    L27:
        r11 = 1;
        goto L29
    L11:
        r3 = 1;
        goto L12
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.normal.view.BaseNormalGiftCombView
    public final void l() {
        Animator r0 = this.c;
        if (r0 == null) goto L11;
        if (r0.isPaused() != true) goto L11;
        Animator r1 = this.c;
        if (r1 == null) goto L9;
        r1.resume();
    L9:
        ALogger.d("PauseAnim", "GamePlatformGiftCombView resumeAnimation success");
    L11:
        if (this.i == false) goto L14;
        ALogger.d("PauseAnim", "GamePlatformGiftCombView getGiftExitAnim when scroll idle");
        post(new com.bytedance.android.livesdk.gift.platform.business.normal.view.v2.c(this));
        this.i = false;
        return;
    }

    public final void r() {
        if (this.g == false) goto L5;
        return;
    L5:
        Animator r0 = this.c;
        if (r0 != null) goto L8;
    L16:
        this.l = null;
        GiftIconMaskView r1 = (GiftIconMaskView) o(2131373725);
        if (r1 == null) goto L20;
        r1.c();
        return;
    L20:
        return;
    L8:
        if (r0.isRunning() != true) goto L16;
        Animator r2 = this.c;
        if (r2 == null) goto L12;
        r2.removeAllListeners();
    L12:
        Animator r3 = this.c;
        if (r3 == null) goto L15;
        r3.cancel();
    L15:
        this.c = null;
        goto L16
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.normal.view.BaseNormalGiftCombView
    public final void j() {
        r();
        this.l = null;
        this.m = null;
        Disposable r1 = this.f;
        if (r1 == null) goto L5;
        r1.dispose();
    L5:
        this.f = null;
        this.g = true;
        GiftIconMaskView r0 = (GiftIconMaskView) o(2131373725);
        if (r0 == null) goto L9;
        r0.c();
        return;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.normal.view.BaseNormalGiftCombView
    public final void k() {
        r();
        ((TextView) o(2131367236)).setText(String.valueOf(1));
        ((LinearLayout) o(2131367231)).setVisibility(8);
        setAlpha(1.0f);
        GiftIconMaskView r0 = (GiftIconMaskView) o(2131373725);
        if (r0 == null) goto L6;
        r0.c();
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Disposable r0 = this.q;
        if (r0 == null) goto L6;
        r0.dispose();
        return;
    }

    public final Disposable getDispose() {
        return this.q;
    }

    public static final /* synthetic */ boolean p(GamePlatformGiftCombView r0) {
        return r0.getAutoExit();
    }

    private final void setGiftMessageAndDuration(NormalGiftMessage r4) {
        int r0 = com.bytedance.android.livesdk.gift.platform.business.tray2.k.c;
        boolean r2 = true;
        if (((Number) com.bytedance.android.livesdk.gift.platform.business.e.f.getValue(null, com.bytedance.android.livesdk.gift.platform.business.e.a[4])).intValue() == 1) goto L6;
        r2 = false;
    L6:
        if (r2 == false) goto L9;
        long r1 = (long) (2000 / l.i(r4));
    L12:
        this.b = r1;
        return;
    L9:
        if ((r4 instanceof com.bytedance.android.livesdk.gift.platform.business.tray.a) == true) goto L11;
        r1 = this.j.k(r4.getTotalMoney(), l.i(r4));
        goto L12
    L11:
        r1 = this.j.i(((com.bytedance.android.livesdk.gift.platform.business.tray.a) r4).t(false), l.i(r4));
        goto L12
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.normal.view.BaseNormalGiftCombView
    public final void m(NormalGiftMessage r15) {
        if (r15 != null) goto L4;
        return;
    L4:
        this.e = r15;
        setGiftMessageAndDuration(r15);
        int r0 = this.j.b(r15.getTotalMoney());
        o7 r1 = r15.r();
        py.k r2 = null;
        if (r1 == null) goto L7;
        o0 r3 = r1.getTrayInfo();
    L8:
        py.k r4 = GiftImageFormat.a(r3);
        if (this.o == false) goto L23;
        if (r4 == null) goto L23;
        List r5 = r4.getUrls();
        if (r5 == null) goto L14;
        Integer r6 = Integer.valueOf(r5.size());
    L16:
        if (r6.intValue() <= 0) goto L23;
        if (r3 == null) goto L20;
        this.n = (int) r3.getTrayLevel();
    L20:
        if (o(2131380985).getVisibility() != 0) goto L22;
        s((HSImageView) o(2131380985), (HSImageView) o(2131380986), r4, this.n);
    L26:
        TextView r7 = (TextView) o(2131392055);
        if (r7 == null) goto L29;
        r7.setText(BuildConfig.FLAVOR);
    L29:
        IBaseUser r8 = r15.e;
        if (r8 == null) goto L34;
        TextView r9 = (TextView) o(2131392055);
        if (r9 == null) goto L34;
        int r10 = f0.a;
        r9.setText(f0.a(r8, r15.M));
    L34:
        boolean r11 = false;
        if (r15.getTrayDisplayText() == null) goto L42;
        TextView r13 = (TextView) o(2131373680);
        if (r13 == null) goto L81;
        ur2.a r14 = vh6.c.b(ur2.a.class);
        a5 r16 = r15.getTrayDisplayText();
        String r17 = r15.c;
        if (r17 != null) goto L41;
        r17 = BuildConfig.FLAVOR;
    L41:
        r13.setText(r14.Lf(r16, r17));
    L81:
        View r18 = o(2131380985);
        Function0<String> r19 = new GamePlatformGiftCombView$loadTrayDisplayText$2(this);
        int r20 = r3.a;
        Intrinsics.checkNotNullParameter(r19, "getDescription");
        if (r18 == null) goto L85;
        r3.a r21 = new r3.a(r18);
        r21.b = r19;
        r21.c = BuildConfig.FLAVOR;
        ViewCompat.setAccessibilityDelegate(r18, r21);
    L85:
        View r23 = o(2131380986);
        Function0<String> r24 = new GamePlatformGiftCombView$loadTrayDisplayText$3(this);
        Intrinsics.checkNotNullParameter(r24, "getDescription");
        if (r23 == null) goto L89;
        r3.a r25 = new r3.a(r23);
        r25.b = r24;
        r25.c = BuildConfig.FLAVOR;
        ViewCompat.setAccessibilityDelegate(r23, r25);
    L89:
        boolean r26 = r15 instanceof com.bytedance.android.livesdk.gift.platform.business.tray.a;
        if (r26 == false) goto L98;
        LinearLayout r27 = (LinearLayout) o(2131367231);
        if (r27 == null) goto L94;
        r27.setVisibility(8);
    L94:
        TextView r28 = (TextView) o(2131373941);
        if (r28 == null) goto L116;
        r28.setVisibility(8);
    L116:
        if (r26 == true) goto L118;
    L121:
        boolean r29 = true;
    L123:
        if (r29 == true) goto L125;
        GiftIconMaskView r30 = (GiftIconMaskView) o(2131373725);
        if (r30 == null) goto L138;
        r30.setVisibility(8);
    L138:
        HSImageView r31 = o(2131370475);
        if (r31 == null) goto L141;
        r31.setVisibility(8);
    L141:
        if (r29 == true) goto L143;
        return;
    L143:
        if (getShowDynamicGiftIcon() == true) goto L145;
        py.k r110 = r15.o;
        GiftImageLoader.k.getClass();
        Intrinsics.checkNotNullParameter("live_gift_tray_gift", "callerContext");
        Single.create(new com.bytedance.android.livesdk.gift.util.e(r110, null, "live_gift_tray_gift")).compose(RxUtil.rxSchedulerHelper()).subscribe(new com.bytedance.android.livesdk.gift.platform.business.normal.view.v2.a(this), com.bytedance.android.livesdk.gift.platform.business.normal.view.v2.b.a);
        return;
    L145:
        o7 r111 = r15.r();
        if (r111 == null) goto L150;
        o0 r112 = r111.getTrayInfo();
        if (r112 == null) goto L150;
        r2 = r112.getTrayDynamicImg();
    L150:
        if (r2 == null) goto L164;
        List r113 = r2.getUrls();
        if (r113 != null) goto L154;
    L155:
        r11 = true;
    L156:
        if (r11 == true) goto L166;
        HSImageView r114 = o(2131370475);
        if (r114 == null) goto L165;
        r114.setController(Fresco.newDraweeControllerBuilder().setUri((String) CollectionsKt.first(r2.getUrls())).setAutoPlayAnimations(true).build());
        return;
    L165:
        return;
    L166:
        return;
    L154:
        if (r113.isEmpty() == false) goto L156;
    L164:
        return;
    L125:
        if (getShowDynamicGiftIcon() == false) goto L132;
        GiftIconMaskView r33 = (GiftIconMaskView) o(2131373725);
        if (r33 == null) goto L129;
        r33.setVisibility(8);
    L129:
        HSImageView r34 = o(2131370475);
        if (r34 == null) goto L141;
        r34.setVisibility(0);
        goto L141
    L132:
        GiftIconMaskView r35 = (GiftIconMaskView) o(2131373725);
        if (r35 == null) goto L141;
        r35.setVisibility(0);
        goto L141
    L118:
        if (((com.bytedance.android.livesdk.gift.platform.business.tray.a) r15).R == true) goto L121;
        r29 = false;
        goto L123
    L98:
        if (this.d == false) goto L105;
        LinearLayout r36 = (LinearLayout) o(2131367231);
        if (r36 == null) goto L102;
        r36.setVisibility(0);
    L102:
        TextView r37 = (TextView) o(2131367236);
        if (r37 == null) goto L105;
        r37.setText(r15.q());
    L105:
        long r38 = r15.k;
        if (r38 <= 1) goto L113;
        TextView r39 = (TextView) o(2131373941);
        if (r39 == null) goto L110;
        r39.setVisibility(0);
    L110:
        TextView r40 = (TextView) o(2131373941);
        if (r40 == null) goto L116;
        r40.setText(sz1.a.KEY_X + r38);
        goto L116
    L113:
        TextView r41 = (TextView) o(2131373941);
        if (r41 == null) goto L116;
        r41.setVisibility(8);
        goto L116
    L42:
        String r43 = r15.c;
        if (r43 != null) goto L45;
        r43 = BuildConfig.FLAVOR;
    L45:
        TextView r44 = (TextView) o(2131373680);
        if (r44 == null) goto L48;
        r44.setText(r43);
    L48:
        yz0.k r45 = com.bytedance.android.live.revenue.core.util.f.d(com.bytedance.android.live.revenue.core.util.j.C0.a(), yz0.k.class);
        if (r45 == null) goto L51;
        IRoom r46 = r45.getRoom();
    L52:
        if (r46 == null) goto L56;
        IBaseUser r47 = r46.getOwner();
        if (r47 == null) goto L56;
        String r48 = r47.getIdString();
    L57:
        IBaseUser r49 = r15.f;
        if (r49 == null) goto L60;
        String r50 = r49.getIdString();
    L62:
        if ((!Intrinsics.areEqual(r48, r50)) == false) goto L81;
        IBaseUser r51 = r15.f;
        if (r51 == null) goto L69;
        String r53 = r51.getNickName();
        if (r53 == null) goto L69;
        String r54 = r53;
    L70:
        int r55 = StringsKt.indexOf$default(r43, r54, 0, false, 6, null);
        if (r55 == (-1)) goto L81;
        String r56 = r43.substring(0, r55);
        String r57 = " <font color = '#FACE15'>" + r43.substring(r55) + "</font> ";
        StringBuilder r58 = new StringBuilder();
        r58.append(r56);
        r58.append(r57);
        h2 r59 = GiftManagerKt.l(r15.b);
        if (r59 == null) goto L75;
        String r60 = r59.getName();
    L76:
        r58.append(r60);
        String r61 = r58.toString();
        if (Build.VERSION.SDK_INT < 24) goto L79;
        Spanned r63 = Html.fromHtml(r61, 0);
    L80:
        ((TextView) o(2131373680)).setText(r63);
        goto L81
    L79:
        r63 = Html.fromHtml(r61);
        goto L80
    L75:
        r60 = null;
    L69:
        r54 = BuildConfig.FLAVOR;
        goto L70
    L60:
        r50 = null;
    L56:
        r48 = null;
        goto L57
    L51:
        r46 = null;
        goto L52
    L22:
        s((HSImageView) o(2131380986), (HSImageView) o(2131380985), r4, this.n);
        goto L26
    L14:
        r6 = null;
    L23:
        RoundCornerImageView r64 = o(2131380985);
        if (r64 == null) goto L26;
        r64.setBackgroundResource(r0);
        goto L26
    L7:
        r3 = null;
        goto L8
    }

    public final View o(int r3) {
        if (this.a != null) goto L5;
        this.a = new LinkedHashMap();
    L5:
        View r0 = this.a.get(Integer.valueOf(r3));
        if (r0 != null) goto L12;
        View r1 = findViewById(r3);
        if (r1 == null) goto L10;
        this.a.put(Integer.valueOf(r3), r1);
        return r1;
    L10:
        return null;
    L12:
        return r0;
    }

    public final void setDispose(Disposable r1) {
        this.q = r1;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.normal.view.BaseNormalGiftCombView
    public void setGiftControllerCallback(s02.b r1) {
        this.m = r1;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.normal.view.BaseNormalGiftCombView
    public void setShowCombo(boolean r1) {
        this.d = r1;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.normal.view.BaseNormalGiftCombView
    public final void h(r02.b.C0268b r1, boolean r2) {
        this.l = r1;
        Animator r3 = this.k.b(this, this.p);
        this.c = r3;
        if (r3 == null) goto L6;
        r3.start();
        return;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.normal.view.BaseNormalGiftCombView
    public final void n(int r2, int r3) {
        this.k.a(this, r2, r3);
    }

    public GamePlatformGiftCombView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.a = new LinkedHashMap();
        this.d = true;
        this.j = n12.e.a();
        if (com.bytedance.android.livesdk.gift.platform.business.b.a() == false) goto L6;
        q02.a r5 = new com.bytedance.android.livesdk.gift.platform.business.normal.anim.compat.b();
    L9:
        this.k = r5;
        this.o = true;
        this.p = new b(this);
        LayoutInflater.from(r2).inflate(2131567674, this);
        Typeface r6 = Typeface.createFromAsset(r2.getAssets(), "font/ttlive_base_gift_combo_font.ttf");     // Catch: Exception -> L17
        TextView r7 = (TextView) o(2131367247);     // Catch: Exception -> L17
        if (r7 == null) goto L13;
        r7.setTypeface(r6);     // Catch: Exception -> L17
    L13:
        TextView r8 = (TextView) o(2131367236);     // Catch: Exception -> L17
        if (r8 == null) goto L20;
        r8.setTypeface(r6);     // Catch: Exception -> L17
    L20:
        if (PadConfigUtils.c() == false) goto L27;
        ViewUtilsKt.c(o(2131380985), s1.f(20.0f));
        HSImageView r9 = findViewById(2131380986);
        if (r9 == null) goto L28;
        ViewUtilsKt.c(r9, s1.f(20.0f));
        return;
    L28:
        return;
    L27:
        return;
    L17:
        e = move-exception;
        jy0.b.c("GamePlatformGiftCombView", "load font asset exception: " + e.getMessage(), null, 4);
        goto L20
    L6:
        if (com.bytedance.android.livesdk.gift.platform.business.a.a() <= 0) goto L8;
        r5 = new q02.f();
        goto L9
    L8:
        r5 = new q02.e();
        goto L9
    }

    public final Bitmap q(Bitmap r9, int r10, int r11) {
        if (r9 == null) goto L9;
        int r4 = r9.getWidth();     // Catch: Throwable -> L6
        int r5 = r9.getHeight();     // Catch: Throwable -> L6
        Matrix r6 = new Matrix();     // Catch: Throwable -> L6
        r6.postScale(r10 / r4, r11 / r5);     // Catch: Throwable -> L6
        return Bitmap.createBitmap(r9, 0, 0, r4, r5, r6, true);
    L10:
        return null;
    L9:
        return null;
    }

    public /* synthetic */ GamePlatformGiftCombView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }

    public final void s(HSImageView r5, HSImageView r6, py.k r7, int r8) {
        Integer r0 = null;
        r6.setController(null);
        r6.setVisibility(0);
        e r2 = new e(r5);
        if (r8 > 4) goto L5;
        this.q = a1.k(r7).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new c(r5, r6), d.a);
        return;
    L5:
        List r9 = r7.getUrls();
        if (r9 == null) goto L9;
        r0 = Integer.valueOf(r9.size());
    L9:
        if (r0.intValue() < 1) goto L13;
        r6.setController(Fresco.newDraweeControllerBuilder().setControllerListener(r2).setUri((String) ListProtector.get(r7.getUrls(), 0)).setAutoPlayAnimations(true).build());
        return;
    }
}
