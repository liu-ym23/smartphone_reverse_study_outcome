package com.bytedance.android.livesdk.gift.vs.tray.view;

import android.animation.Animator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Typeface;
import android.os.Build;
import android.text.Html;
import android.text.Spanned;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.android.live.base.model.message.a5;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.revenue.common.ViewUtilsKt;
import com.bytedance.android.live.revenue.core.util.j;
import com.bytedance.android.livesdk.chatroom.utils.a1;
import com.bytedance.android.livesdk.gift.model.h2;
import com.bytedance.android.livesdk.gift.model.o0;
import com.bytedance.android.livesdk.gift.platform.business.normal.model.NormalGiftMessage;
import com.bytedance.android.livesdk.gift.platform.business.normal.view.v2.GiftIconMaskView;
import com.bytedance.android.livesdk.gift.platform.business.normal.view.v2.l;
import com.bytedance.android.livesdk.gift.platform.core.manager.GiftManagerKt;
import com.bytedance.android.livesdk.message.model.o7;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.bdlocation.BuildConfig;
import com.facebook.drawee.backends.pipeline.Fresco;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import n12.f;
import py.k;
import zt0.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001NB'\b\u0007\u0012\u0006\u0010G\u001a\u00020F\u0012\n\b\u0002\u0010I\u001a\u0004\u0018\u00010H\u0012\b\b\u0002\u0010K\u001a\u00020J¢\u0006\u0004\bL\u0010MJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0010\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006J\u0010\u0010\u000b\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\tJ\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002R#\u0010\u0013\u001a\n \u000e*\u0004\u0018\u00010\r0\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R#\u0010\u0018\u001a\n \u000e*\u0004\u0018\u00010\u00140\u00148BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0010\u001a\u0004\b\u0016\u0010\u0017R#\u0010\u001b\u001a\n \u000e*\u0004\u0018\u00010\r0\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u0010\u001a\u0004\b\u001a\u0010\u0012R#\u0010 \u001a\n \u000e*\u0004\u0018\u00010\u001c0\u001c8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u0010\u001a\u0004\b\u001e\u0010\u001fR#\u0010#\u001a\n \u000e*\u0004\u0018\u00010\u001c0\u001c8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b!\u0010\u0010\u001a\u0004\b\"\u0010\u001fR#\u0010(\u001a\n \u000e*\u0004\u0018\u00010$0$8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b%\u0010\u0010\u001a\u0004\b&\u0010'R#\u0010+\u001a\n \u000e*\u0004\u0018\u00010\r0\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b)\u0010\u0010\u001a\u0004\b*\u0010\u0012R#\u00100\u001a\n \u000e*\u0004\u0018\u00010,0,8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b-\u0010\u0010\u001a\u0004\b.\u0010/R#\u00103\u001a\n \u000e*\u0004\u0018\u00010,0,8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b1\u0010\u0010\u001a\u0004\b2\u0010/R#\u00106\u001a\n \u000e*\u0004\u0018\u00010\u001c0\u001c8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b4\u0010\u0010\u001a\u0004\b5\u0010\u001fR#\u00109\u001a\n \u000e*\u0004\u0018\u00010,0,8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b7\u0010\u0010\u001a\u0004\b8\u0010/R#\u0010<\u001a\n \u000e*\u0004\u0018\u00010\u001c0\u001c8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b:\u0010\u0010\u001a\u0004\b;\u0010\u001fR#\u0010?\u001a\n \u000e*\u0004\u0018\u00010\u001c0\u001c8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b=\u0010\u0010\u001a\u0004\b>\u0010\u001fR#\u0010B\u001a\n \u000e*\u0004\u0018\u00010,0,8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b@\u0010\u0010\u001a\u0004\bA\u0010/R\u0014\u0010E\u001a\u00020\u00028BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bC\u0010D¨\u0006O"}, d2 = {"Lcom/bytedance/android/livesdk/gift/vs/tray/view/VSGiftTrayAnimationView;", "Landroid/widget/FrameLayout;", BuildConfig.FLAVOR, "showCombo", BuildConfig.FLAVOR, "setShowCombo", "Lcom/bytedance/android/livesdk/gift/platform/business/normal/model/NormalGiftMessage;", "msg", "setGiftMessage", "Ls02/b;", "callback", "setGiftControllerCallback", "setGiftMessageAndDuration", "Lcom/bytedance/android/live/core/widget/HSImageView;", "kotlin.jvm.PlatformType", "k", "Lkotlin/Lazy;", "getNormalGiftBgView", "()Lcom/bytedance/android/live/core/widget/HSImageView;", "normalGiftBgView", "Landroid/widget/ImageView;", "l", "getUserAvatarIv", "()Landroid/widget/ImageView;", "userAvatarIv", "m", "getAvatarBorderIv", "avatarBorderIv", "Landroid/widget/TextView;", "n", "getUserNameTv", "()Landroid/widget/TextView;", "userNameTv", "o", "getGiftDescriptionTv", "giftDescriptionTv", "Lcom/bytedance/android/livesdk/gift/platform/business/normal/view/v2/GiftIconMaskView;", "p", "getGiftIconAnimationView", "()Lcom/bytedance/android/livesdk/gift/platform/business/normal/view/v2/GiftIconMaskView;", "giftIconAnimationView", "q", "getDynamicGiftIcon", "dynamicGiftIcon", "Landroid/view/View;", "r", "getDummyView", "()Landroid/view/View;", "dummyView", "s", "getGroupBody", "groupBody", "t", "getGroupCount", "groupCount", "u", "getComboBody", "comboBody", "v", "getComboCountX", "comboCountX", "w", "getComboCount", "comboCount", sz1.a.KEY_X, "getLinearLayout", "linearLayout", "getShowDynamicGiftIcon", "()Z", "showDynamicGiftIcon", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", BuildConfig.FLAVOR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "c", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class VSGiftTrayAnimationView extends FrameLayout {
    public long a;
    public Animator b;
    public boolean c;
    public NormalGiftMessage d;
    public Disposable e;
    public boolean f;
    public final f g;
    public final q02.a h;
    public s02.a i;
    public s02.b j;
    public final Lazy k;
    public final Lazy l;
    public final Lazy m;
    public final Lazy n;
    public final Lazy o;
    public final Lazy p;
    public final Lazy q;
    public final Lazy r;
    public final Lazy s;
    public final Lazy t;
    public final Lazy u;
    public final Lazy v;
    public final Lazy w;
    public final Lazy x;
    public final d y;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ VSGiftTrayAnimationView a;

        public a(VSGiftTrayAnimationView r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            NormalGiftMessage r3 = this.a.d;
            if (r3 == null) goto L8;
            IBaseUser r4 = r3.e;
            if (r4 == null) goto L9;
            vh6.c.b(com.bytedance.android.livesdk.revenue.service.user.a.class).xh(r4);
            return;
        L9:
            return;
        }
    }

    public static final class b implements View.OnClickListener {
        public static final b a = null;

        static {
            a = new b();
        }

        public b() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r1) {
        }
    }

    public static final class c {
    }

    public static final class d implements q02.d {
        public final /* synthetic */ VSGiftTrayAnimationView a;

        public static final class a<T> implements Consumer {
            public final /* synthetic */ d a;

            public a(d r1) {
                this.a = r1;
            }

            public final void accept(Object r3) {
                Long r4 = (Long) r3;
                d r5 = this.a;
                r5.a.post(new com.bytedance.android.livesdk.gift.vs.tray.view.c(r5));
            }
        }

        @Override // q02.d
        public final void a() {
            VSGiftTrayAnimationView r0 = this.a;
            if ((r0.d instanceof com.bytedance.android.livesdk.gift.platform.business.tray.a) == false) goto L5;
        L11:
            c();
            return;
        L5:
            if (r0.c == false) goto L11;
            if (VSGiftTrayAnimationView.a(r0) == null) goto L11;
            VSGiftTrayAnimationView.a(this.a).setVisibility(0);
            VSGiftTrayAnimationView r1 = this.a;
            r1.b = r1.h.d(VSGiftTrayAnimationView.a(r1), this);
            this.a.getClass();
            Animator r2 = this.a.b;
            if (r2 == null) goto L13;
            r2.start();
            return;
        }

        @Override // q02.d
        public final void b() {
            s02.a r0 = this.a.i;
            if (r0 == null) goto L6;
            r0.onExit();
            return;
        }

        @Override // q02.d
        public final void c() {
            Disposable r0 = this.a.e;
            if (r0 == null) goto L5;
            r0.dispose();
        L5:
            VSGiftTrayAnimationView r1 = this.a;
            if ((r1.d instanceof com.bytedance.android.livesdk.gift.platform.business.tray.a) == true) goto L8;
            r1.e = Observable.timer(r1.a, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new a(this));
        L8:
            VSGiftTrayAnimationView r2 = this.a;
            NormalGiftMessage r3 = r2.d;
            if (r3 == null) goto L11;
            int r4 = r3.g;
        L12:
            long r5 = r4;
            if (r3 == null) goto L15;
            long r6 = r3.k;
        L16:
            long r7 = r5 * r6;
            f r8 = r2.g;
            if ((r8 instanceof n12.c) == false) goto L21;
            ((n12.c) r8).getClass();
            if (n12.c.m(r7) < 2) goto L21;
            VSGiftTrayAnimationView.b(this.a).b();
        L21:
            this.a.getClass();
            s02.a r9 = this.a.i;
            if (r9 == null) goto L25;
            r9.onWaiting();
            return;
        L25:
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
            s02.b r0 = this.a.j;
            if (r0 == null) goto L6;
            r0.onPlay();
            return;
        }

        @Override // q02.d
        public final void e() {
            s02.b r0 = this.a.j;
            if (r0 == null) goto L6;
            r0.onPlay();
            return;
        }

        public d(VSGiftTrayAnimationView r1) {
            this.a = r1;
        }
    }

    static {
    }

    public VSGiftTrayAnimationView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public VSGiftTrayAnimationView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    private final HSImageView getAvatarBorderIv() {
        return (HSImageView) this.m.getValue();
    }

    private final View getComboBody() {
        return (View) this.u.getValue();
    }

    private final TextView getComboCount() {
        return (TextView) this.w.getValue();
    }

    private final TextView getComboCountX() {
        return (TextView) this.v.getValue();
    }

    private final View getDummyView() {
        return (View) this.r.getValue();
    }

    private final HSImageView getDynamicGiftIcon() {
        return (HSImageView) this.q.getValue();
    }

    private final TextView getGiftDescriptionTv() {
        return (TextView) this.o.getValue();
    }

    private final GiftIconMaskView getGiftIconAnimationView() {
        return (GiftIconMaskView) this.p.getValue();
    }

    private final View getGroupBody() {
        return (View) this.s.getValue();
    }

    private final TextView getGroupCount() {
        return (TextView) this.t.getValue();
    }

    private final View getLinearLayout() {
        return (View) this.x.getValue();
    }

    private final HSImageView getNormalGiftBgView() {
        return (HSImageView) this.k.getValue();
    }

    private final ImageView getUserAvatarIv() {
        return (ImageView) this.l.getValue();
    }

    private final TextView getUserNameTv() {
        return (TextView) this.n.getValue();
    }

    private final boolean getShowDynamicGiftIcon() {
        NormalGiftMessage r0 = this.d;
        if (r0 == null) goto L11;
        o7 r1 = r0.r();
        if (r1 == null) goto L11;
        o0 r2 = r1.getTrayInfo();
        if (r2 == null) goto L11;
        k r3 = r2.getTrayDynamicImg();
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

    public final void g() {
        if (this.f == false) goto L5;
        return;
    L5:
        Animator r0 = this.b;
        if (r0 != null) goto L8;
    L16:
        this.i = null;
        getGiftIconAnimationView().c();
        return;
    L8:
        if (r0.isRunning() != true) goto L16;
        Animator r1 = this.b;
        if (r1 == null) goto L12;
        r1.removeAllListeners();
    L12:
        Animator r2 = this.b;
        if (r2 == null) goto L15;
        r2.cancel();
    L15:
        this.b = null;
        goto L16
    }

    public final void e() {
        g();
        this.i = null;
        this.j = null;
        Disposable r1 = this.e;
        if (r1 == null) goto L5;
        r1.dispose();
    L5:
        this.e = null;
        this.f = true;
        getGiftIconAnimationView().c();
    }

    public final void f() {
        g();
        getComboCount().setText(String.valueOf(1));
        getComboBody().setVisibility(8);
        setAlpha(1.0f);
        getGiftIconAnimationView().c();
    }

    public static final /* synthetic */ View a(VSGiftTrayAnimationView r0) {
        return r0.getComboBody();
    }

    public static final /* synthetic */ GiftIconMaskView b(VSGiftTrayAnimationView r0) {
        return r0.getGiftIconAnimationView();
    }

    private final void setGiftMessageAndDuration(NormalGiftMessage r4) {
        if ((r4 instanceof com.bytedance.android.livesdk.gift.platform.business.tray.a) == true) goto L5;
        long r0 = this.g.k(r4.getTotalMoney(), l.i(r4));
    L6:
        this.a = r0;
        return;
    L5:
        r0 = this.g.i(((com.bytedance.android.livesdk.gift.platform.business.tray.a) r4).t(false), l.i(r4));
        goto L6
    }

    public final void d(long r2) {
        if (this.f == false) goto L5;
        return;
    L5:
        Disposable r0 = this.e;
        if (r0 == null) goto L8;
        r0.dispose();
    L8:
        getComboCount().setText(String.valueOf(r2));
        Animator r3 = this.h.d(getComboBody(), this.y);
        this.b = r3;
        if (r3 == null) goto L12;
        r3.start();
        return;
    }

    public final void setGiftControllerCallback(s02.b r1) {
        this.j = r1;
    }

    public final void setGiftMessage(NormalGiftMessage r13) {
        if (r13 != null) goto L4;
        return;
    L4:
        this.d = r13;
        setGiftMessageAndDuration(r13);
        NormalGiftMessage r0 = this.d;
        boolean r1 = false;
        if (r0 == null) goto L7;
        int r2 = r0.g;
    L8:
        long r3 = r2;
        if (r0 == null) goto L11;
        long r4 = r0.k;
    L12:
        getNormalGiftBgView().setBackgroundResource(this.g.b(r3 * r4));
        ImageView r5 = getUserAvatarIv();
        NormalGiftMessage r6 = this.d;
        k r7 = null;
        if (r6 == null) goto L17;
        IBaseUser r8 = r6.e;
        if (r8 == null) goto L17;
        k r9 = r8.getAvatarThumbKt();
    L18:
        a1.k(r9).compose(RxUtil.rxSchedulerHelper()).subscribe(new com.bytedance.android.livesdk.gift.vs.tray.view.b(this, r5));
        e r10 = yt0.c.a();
        IBaseUser r11 = r13.e;
        if (r11 == null) goto L23;
        py.f r14 = r11.getBorder();
        if (r14 == null) goto L23;
        String r15 = r14.getDressId();
    L24:
        com.bytedance.android.live.profit.dress.a r16 = r10.getDressData(r15, 1, "VSGiftTrayAnimationView: loadTrayHeadImage");
        if (r16 == null) goto L28;
        k r17 = r16.a;
        if (r17 == null) goto L28;
    L34:
        if (r17 == null) goto L39;
        HSImageView r18 = getAvatarBorderIv();
        if (r18 == null) goto L38;
        r18.setVisibility(0);
    L38:
        ImageLoader.bindImage(getAvatarBorderIv(), r17);
    L39:
        TextView r19 = getUserNameTv();
        IBaseUser r20 = r13.e;
        String r21 = BuildConfig.FLAVOR;
        if (r20 == null) goto L44;
        String r23 = r20.getNickName();
        if (r23 == null) goto L44;
    L45:
        r19.setText(r23);
        if (r13.getTrayDisplayText() == null) goto L52;
        TextView r24 = getGiftDescriptionTv();
        ur2.a r25 = vh6.c.b(ur2.a.class);
        a5 r26 = r13.getTrayDisplayText();
        String r27 = r13.c;
        if (r27 == null) goto L51;
        r21 = r27;
    L51:
        r24.setText(r25.Lf(r26, r21));
    L88:
        boolean r28 = r13 instanceof com.bytedance.android.livesdk.gift.platform.business.tray.a;
        if (r28 == false) goto L92;
        getComboBody().setVisibility(8);
        getGroupBody().setVisibility(8);
        getDummyView().setVisibility(0);
    L99:
        if (r28 == true) goto L101;
    L104:
        boolean r29 = true;
    L105:
        if (r29 == true) goto L107;
        getGiftIconAnimationView().setVisibility(8);
        getDynamicGiftIcon().setVisibility(8);
    L111:
        View r30 = getLinearLayout();
        ViewGroup.LayoutParams r31 = getLinearLayout().getLayoutParams();
        if (r29 == false) goto L114;
        int r33 = 2131168776;
    L115:
        r31.width = s1.j(r33);
        Unit r34 = Unit.INSTANCE;
        r30.setLayoutParams(r31);
        if (r29 == true) goto L118;
        return;
    L118:
        if (getShowDynamicGiftIcon() == true) goto L120;
        a1.k(r13.o).compose(RxUtil.rxSchedulerHelper()).subscribe(new com.bytedance.android.livesdk.gift.vs.tray.view.a(this));
        return;
    L120:
        o7 r110 = r13.r();
        if (r110 == null) goto L125;
        o0 r111 = r110.getTrayInfo();
        if (r111 == null) goto L125;
        r7 = r111.getTrayDynamicImg();
    L125:
        if (r7 == null) goto L137;
        List r112 = r7.getUrls();
        if (r112 != null) goto L129;
    L130:
        r1 = true;
    L131:
        if (r1 == true) goto L138;
        getDynamicGiftIcon().setController(Fresco.newDraweeControllerBuilder().setUri((String) CollectionsKt.first(r7.getUrls())).setAutoPlayAnimations(true).build());
        return;
    L138:
        return;
    L129:
        if (r112.isEmpty() == false) goto L131;
    L137:
        return;
    L114:
        r33 = 2131168778;
        goto L115
    L107:
        if (getShowDynamicGiftIcon() == false) goto L109;
        getGiftIconAnimationView().setVisibility(8);
        getDynamicGiftIcon().setVisibility(0);
        goto L111
    L109:
        getGiftIconAnimationView().setVisibility(0);
        goto L111
    L101:
        if (((com.bytedance.android.livesdk.gift.platform.business.tray.a) r13).R == true) goto L104;
        r29 = false;
        goto L105
    L92:
        if (this.c == false) goto L94;
        getComboBody().setVisibility(0);
        getComboCount().setText(String.valueOf(r13.m));
    L95:
        long r35 = r13.k;
        if (r35 <= 1) goto L98;
        getDummyView().setVisibility(8);
        getGroupBody().setVisibility(0);
        getGroupCount().setText(String.valueOf(r35));
        goto L99
    L98:
        getDummyView().setVisibility(0);
        getGroupBody().setVisibility(8);
        goto L99
    L94:
        getComboBody().setVisibility(8);
        goto L95
    L52:
        String r36 = r13.c;
        if (r36 != null) goto L55;
        r36 = BuildConfig.FLAVOR;
    L55:
        getGiftDescriptionTv().setText(r36);
        yz0.k r37 = com.bytedance.android.live.revenue.core.util.f.d(j.C0.a(), yz0.k.class);
        if (r37 == null) goto L58;
        IRoom r38 = r37.getRoom();
    L59:
        if (r38 == null) goto L63;
        IBaseUser r39 = r38.getOwner();
        if (r39 == null) goto L63;
        String r40 = r39.getIdString();
    L64:
        IBaseUser r41 = r13.f;
        if (r41 == null) goto L67;
        String r43 = r41.getIdString();
    L69:
        if (StringsKt.equals$default(r40, r43, false, 2, null) == true) goto L88;
        IBaseUser r44 = r13.f;
        if (r44 == null) goto L76;
        String r45 = r44.getNickName();
        if (r45 == null) goto L76;
        String r46 = r45;
    L77:
        int r47 = StringsKt.indexOf$default(r36, r46, 0, false, 6, null);
        if (r47 == (-1)) goto L88;
        String r48 = r36.substring(0, r47);
        String r49 = " <font color = '#FACE15'>" + r36.substring(r47) + "</font> ";
        StringBuilder r50 = new StringBuilder();
        r50.append(r48);
        r50.append(r49);
        h2 r51 = GiftManagerKt.l(r13.b);
        if (r51 == null) goto L82;
        String r53 = r51.getName();
    L83:
        r50.append(r53);
        String r54 = r50.toString();
        if (Build.VERSION.SDK_INT < 24) goto L86;
        Spanned r55 = Html.fromHtml(r54, 0);
    L87:
        getGiftDescriptionTv().setText(r55);
        goto L88
    L86:
        r55 = Html.fromHtml(r54);
        goto L87
    L82:
        r53 = null;
    L76:
        r46 = BuildConfig.FLAVOR;
        goto L77
    L67:
        r43 = null;
    L63:
        r40 = null;
        goto L64
    L58:
        r38 = null;
    L44:
        r23 = BuildConfig.FLAVOR;
    L28:
        IBaseUser r56 = r13.e;
        if (r56 == null) goto L33;
        py.f r57 = r56.getBorder();
        if (r57 == null) goto L33;
        r17 = r57.getIcon();
    L33:
        r17 = null;
    L23:
        r15 = null;
    L17:
        r9 = null;
        goto L18
    L11:
        r4 = 0;
        goto L12
    L7:
        r2 = 0;
        goto L8
    }

    public final void setShowCombo(boolean r1) {
        this.c = r1;
    }

    public VSGiftTrayAnimationView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.c = true;
        this.g = n12.e.a();
        if (com.bytedance.android.livesdk.gift.platform.business.b.a() == false) goto L6;
        q02.a r5 = new com.bytedance.android.livesdk.gift.platform.business.normal.anim.compat.b();
    L9:
        this.h = r5;
        this.k = LazyKt.lazy(new VSGiftTrayAnimationView$normalGiftBgView$2(this));
        this.l = LazyKt.lazy(new VSGiftTrayAnimationView$userAvatarIv$2(this));
        this.m = LazyKt.lazy(new VSGiftTrayAnimationView$avatarBorderIv$2(this));
        this.n = LazyKt.lazy(new VSGiftTrayAnimationView$userNameTv$2(this));
        this.o = LazyKt.lazy(new VSGiftTrayAnimationView$giftDescriptionTv$2(this));
        this.p = LazyKt.lazy(new VSGiftTrayAnimationView$giftIconAnimationView$2(this));
        this.q = LazyKt.lazy(new VSGiftTrayAnimationView$dynamicGiftIcon$2(this));
        this.r = LazyKt.lazy(new VSGiftTrayAnimationView$dummyView$2(this));
        this.s = LazyKt.lazy(new VSGiftTrayAnimationView$groupBody$2(this));
        this.t = LazyKt.lazy(new VSGiftTrayAnimationView$groupCount$2(this));
        this.u = LazyKt.lazy(new VSGiftTrayAnimationView$comboBody$2(this));
        this.v = LazyKt.lazy(new VSGiftTrayAnimationView$comboCountX$2(this));
        this.w = LazyKt.lazy(new VSGiftTrayAnimationView$comboCount$2(this));
        this.x = LazyKt.lazy(new VSGiftTrayAnimationView$linearLayout$2(this));
        this.y = new d(this);
        LayoutInflater.from(r2).inflate(2131567964, this);
        getUserAvatarIv().setOnClickListener(new a(this));
        setOnClickListener(b.a);
        Typeface r6 = Typeface.createFromAsset(r2.getAssets(), "font/ttlive_base_gift_combo_font.ttf");     // Catch: Exception -> L12
        getComboCountX().setTypeface(r6);     // Catch: Exception -> L12
        getComboCount().setTypeface(r6);     // Catch: Exception -> L12
        getGroupCount().setTypeface(r6);     // Catch: Exception -> L12
    L15:
        if (PadConfigUtils.c() == false) goto L17;
    L18:
        ViewUtilsKt.c(getNormalGiftBgView(), s1.f(20.0f));
        return;
    L17:
        if (com.bytedance.android.livesdk.gift.util.a.a() == true) goto L18;
        return;
    L12:
        e = move-exception;
        e.printStackTrace();
        jy0.b.c("NormalGiftCombViewV2", "load font asset exception: " + e.getMessage(), null, 4);
        goto L15
    L6:
        if (com.bytedance.android.livesdk.gift.platform.business.a.a() <= 0) goto L8;
        r5 = new q02.f();
        goto L9
    L8:
        r5 = new q02.e();
        goto L9
    }

    public static Bitmap c(Bitmap r8, int r9, int r10) {
        Intrinsics.checkNotNullParameter(r8, "bitmap");
        int r4 = r8.getWidth();     // Catch: Throwable -> L5
        int r5 = r8.getHeight();     // Catch: Throwable -> L5
        Matrix r6 = new Matrix();     // Catch: Throwable -> L5
        r6.postScale(r9 / r4, r10 / r5);     // Catch: Throwable -> L5
        return Bitmap.createBitmap(r8, 0, 0, r4, r5, r6, true);
    L5:
        return null;
    }

    public /* synthetic */ VSGiftTrayAnimationView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
