package com.bytedance.android.livesdk.gift.vs.panel.viewholder;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.graphics.Bitmap;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.Pair;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.view.animation.PathInterpolator;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.core.view.animation.PathInterpolatorCompat;
import androidx.recyclerview.widget.RecyclerView;
import b02.r;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.recharge.IRechargeService;
import com.bytedance.android.live.revenue.common.ToastUtil;
import com.bytedance.android.live.revenue.common.u0;
import com.bytedance.android.livesdk.chatroom.utils.a1;
import com.bytedance.android.livesdk.gift.configmodel.f0;
import com.bytedance.android.livesdk.gift.model.c2;
import com.bytedance.android.livesdk.gift.model.h1;
import com.bytedance.android.livesdk.gift.model.h2;
import com.bytedance.android.livesdk.gift.model.k0;
import com.bytedance.android.livesdk.gift.model.l2;
import com.bytedance.android.livesdk.gift.model.w1;
import com.bytedance.android.livesdk.gift.platform.business.config.DiamondConfig;
import com.bytedance.android.livesdk.gift.platform.business.config.GiftConfigKey;
import com.bytedance.android.livesdk.gift.platform.business.config.j;
import com.bytedance.android.livesdk.gift.platform.business.config.m;
import com.bytedance.android.livesdk.gift.platform.business.dialog.ui.panel.AbsPanel;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.GiftLabelTextView;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.LiveGiftComboWidget;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.LiveSendGiftAnimationView;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.SimpleSweepGiftViewHolder;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v2.viewmodel.GiftStateMachineConfig;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v2.viewmodel.GiftViewModelManager;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.j0;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.view.combo.ComboEffectAnimationView;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.view.combo.ComboIconAnimationView;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.view.combo.ComboProgressAnimationView;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.view.combo.LiveGiftComboViewNew;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.view.combo.RoundWaveAnimationView;
import com.bytedance.android.livesdk.gift.platform.business.normal.view.v2.GiftIconMaskView;
import com.bytedance.android.livesdk.gift.platform.core.GiftContext;
import com.bytedance.android.livesdk.gift.platform.core.l;
import com.bytedance.android.livesdk.gift.platform.core.model.n;
import com.bytedance.android.livesdk.gift.platform.core.utils.u;
import com.bytedance.android.livesdk.gift.vs.panel.statemachine.GiftDialogViewModelNew;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.android.livesdk.r3;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.episode.IEpisodeExtraInfo;
import com.bytedance.android.livesdkapi.depend.model.live.episode.IVSGiftPanel;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.common.utility.Lists;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.live.datacontext.i;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.drawee.interfaces.DraweeController;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import py.k;
import qz1.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/gift/vs/panel/viewholder/VSGiftDialogViewHolder;", "Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v2/view/SimpleSweepGiftViewHolder;", "b", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class VSGiftDialogViewHolder extends SimpleSweepGiftViewHolder {
    public static final /* synthetic */ int E = 0;
    public final CompositeDisposable A;
    public boolean B;
    public boolean C;
    public final n D;
    public final int f;
    public final int g;
    public final GiftViewModelManager h;
    public final HSImageView i;
    public final HSImageView j;
    public final HSImageView k;
    public final TextView l;
    public final Lazy m;
    public final GiftLabelTextView n;
    public final View o;
    public final GiftIconMaskView p;
    public final View q;
    public boolean r;
    public final float s;
    public int t;
    public boolean u;
    public Disposable v;
    public AbsPanel<?> w;
    public int x;
    public int y;
    public final rz1.b z;

    public static final class a implements View.OnTouchListener {
        public final /* synthetic */ VSGiftDialogViewHolder a;

        public a(VSGiftDialogViewHolder r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View r8, MotionEvent r9) {
            Intrinsics.checkNotNullParameter(r8, "v");
            Intrinsics.checkNotNullParameter(r9, "event");
            VSGiftDialogViewHolder r1 = this.a;
            int r0 = VSGiftDialogViewHolder.E;
            r1.getClass();
            if ((com.bytedance.android.livesdk.gift.vs.panel.statemachine.helper.b.i() instanceof GiftStateMachineConfig.a.e) == false) goto L5;
        L10:
            AbsPanel<?> r2 = com.bytedance.android.livesdk.gift.vs.panel.statemachine.helper.b.d();
            if (r2 != null) goto L13;
        L15:
            boolean r3 = false;
        L16:
            if (r3 == false) goto L19;
            return r1.k4(r8, r9, 2, 0, 1);
        L19:
            if ((com.bytedance.android.livesdk.gift.vs.panel.statemachine.helper.b.i() instanceof GiftStateMachineConfig.a.c) == false) goto L26;
            AbsPanel<?> r4 = com.bytedance.android.livesdk.gift.vs.panel.statemachine.helper.b.d();
            if (r4 == null) goto L26;
            if (r4.c() != r1.b.c()) goto L26;
            return r1.k4(r8, r9, 2, 3, 2);
        L26:
            return r1.k4(r8, r9, 1, 0, 0);
        L13:
            if (r2.c() != r1.b.c()) goto L15;
            r3 = true;
            goto L16
        L5:
            if ((com.bytedance.android.livesdk.gift.vs.panel.statemachine.helper.b.i() instanceof GiftStateMachineConfig.a.C0022a) == true) goto L10;
            if ((com.bytedance.android.livesdk.gift.vs.panel.statemachine.helper.b.i() instanceof GiftStateMachineConfig.a.g) == true) goto L10;
            if ((com.bytedance.android.livesdk.gift.vs.panel.statemachine.helper.b.i() instanceof GiftStateMachineConfig.a.b) == false) goto L15;
            goto L10
        }
    }

    public static final class b {
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ VSGiftDialogViewHolder a;

        public c(VSGiftDialogViewHolder r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            Bitmap r5 = (Bitmap) r4;
            if (r5 != null) goto L5;
            return;
        L5:
            if (r5.isRecycled() == true) goto L14;
            VSGiftDialogViewHolder r0 = this.a;
            int r1 = VSGiftDialogViewHolder.E;
            s r2 = r0.e4();
            BitmapDrawable r3 = new BitmapDrawable(s1.getResources(), r5);
            r2.getClass();
            Intrinsics.checkNotNullParameter(r3, "drawable");
            if (r2.a == false) goto L11;
            LiveSendGiftAnimationView r6 = r2.b;
            if (r6 == null) goto L15;
            r6.setPanelBackground(r3);
            return;
        L15:
            return;
        L11:
            r2.m = r3;
            return;
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

    public static final class e extends AnimatorListenerAdapter {
        public final /* synthetic */ VSGiftDialogViewHolder a;

        public e(VSGiftDialogViewHolder r1) {
            this.a = r1;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
            VSGiftDialogViewHolder r3 = this.a;
            int r0 = VSGiftDialogViewHolder.E;
            HSImageView r4 = r3.e4().b();
            Animatable r1 = null;
            if (r4 == null) goto L5;
            DraweeController r5 = r4.getController();
        L6:
            if (r5 == null) goto L21;
            HSImageView r6 = this.a.e4().b();
            if (r6 == null) goto L12;
            DraweeController r7 = r6.getController();
            if (r7 == null) goto L12;
            r1 = r7.getAnimatable();
        L12:
            if (r1 == null) goto L22;
            HSImageView r8 = this.a.e4().b();
            if (r8 == null) goto L23;
            DraweeController r9 = r8.getController();
            if (r9 == null) goto L24;
            Animatable r10 = r9.getAnimatable();
            if (r10 == null) goto L25;
            r10.start();
            return;
        L25:
            return;
        L24:
            return;
        L23:
            return;
        L22:
            return;
        L21:
            return;
        L5:
            r5 = null;
            goto L6
        }
    }

    public static final class f implements Observer<Long> {
        public final /* synthetic */ VSGiftDialogViewHolder a;
        public final /* synthetic */ int b;
        public final /* synthetic */ View c;
        public final /* synthetic */ int d;

        public final void onComplete() {
            VSGiftDialogViewHolder r0 = this.a;
            int r1 = VSGiftDialogViewHolder.E;
            r0.a4();
        }

        public final void onError(Throwable r2) {
            Intrinsics.checkNotNullParameter(r2, "e");
            VSGiftDialogViewHolder r3 = this.a;
            int r0 = VSGiftDialogViewHolder.E;
            r3.a4();
        }

        public final void onNext(Object r4) {
            ((Number) r4).longValue();
            VSGiftDialogViewHolder r5 = this.a;
            int r0 = r5.t + r5.g;
            r5.t = r0;
            if (r0 < r5.f) goto L6;
            r5.Z3(this.b, this.c, this.d);
            this.a.a4();
            return;
        }

        public final void onSubscribe(Disposable r2) {
            Intrinsics.checkNotNullParameter(r2, "d");
            this.a.v = r2;
        }

        public f(VSGiftDialogViewHolder r1, int r2, View r3, int r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }
    }

    static {
    }

    public final s e4() {
        return (s) this.m.getValue();
    }

    public final void a4() {
        Disposable r0 = this.v;
        if (r0 == null) goto L6;
        r0.dispose();
    L6:
        if (this.h.isGiftUpdateOptimizeOpen() == false) goto L9;
        PropertyValuesHolder r1 = PropertyValuesHolder.ofFloat("scaleX", new float[]{0.92f, 1.0f});
        PropertyValuesHolder r2 = PropertyValuesHolder.ofFloat("scaleY", new float[]{0.92f, 1.0f});
        Interpolator r3 = PathInterpolatorCompat.create(0.42f, 0.0f, 0.58f, 1.0f);
        ObjectAnimator r4 = ObjectAnimator.ofPropertyValuesHolder(this.c, new PropertyValuesHolder[]{r1, r2});
        r4.setInterpolator(r3);
        r4.setDuration(100);
        r4.start();
        return;
    }

    public final k b4() {
        T r0 = this.b.h;
        if ((r0 instanceof h1) == false) goto L10;
        if (r0 == 0) goto L8;
        return ((h1) r0).getDynamicImgForSelected();
    L8:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.gift.model.IGift");
    L10:
        if ((r0 instanceof l2) == false) goto L15;
        if (r0 == 0) goto L14;
        h1 r1 = ((l2) r0).getGift();
    L16:
        if (r1 != null) goto L18;
        return null;
    L18:
        return r1.getDynamicImgForSelected();
    L14:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.gift.model.IProp");
    L15:
        r1 = null;
        goto L16
    }

    public final k d4() {
        IRoom r0 = vh6.c.b(com.bytedance.android.livesdk.revenue.service.room.b.class).getRoom();
        if (r0 == null) goto L7;
        IEpisodeExtraInfo r1 = r0.getEpisodeExtra();
        if (r1 == null) goto L7;
        IVSGiftPanel r2 = r1.getVSGiftPanel();
    L8:
        if (r2 != null) goto L10;
        return null;
    L10:
        return r2.getSelectedImage();
    L7:
        r2 = null;
        goto L8
    }

    public final boolean f4() {
        this.o.setVisibility(8);
        k r0 = b4();
        if (r0 != null) goto L5;
    L11:
        return false;
    L5:
        if (Lists.notEmpty(r0.getUrls()) == false) goto L11;
        String r1 = (String) ListProtector.get(r0.getUrls(), 0);
        AbstractDraweeController r2 = Fresco.newDraweeControllerBuilder().setUri(r1).setAutoPlayAnimations(false).build();
        HSImageView r3 = e4().b();
        if (r3 == null) goto L9;
        r3.setController(r2);
    L9:
        e r4 = new e(this);
        e4().k(r4);
        return true;
    }

    public final boolean g4() {
        AbsPanel r0 = this.b;
        if ((r0 instanceof pz1.a) == false) goto L10;
        if (r0 == null) goto L9;
        if (((pz1.a) r0).n() == false) goto L10;
        return true;
    L9:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.gift.platform.business.dialog.ui.panel.AbsGiftPanel<*>");
    L10:
        return false;
    }

    public final void h4() {
        AbsPanel r0 = this.b;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.h() == false) goto L7;
        return;
    L7:
        if (this.r == false) goto L25;
        LiveGiftComboViewNew r1 = c4();
        if (r1 == null) goto L12;
        r1.d();
    L12:
        LiveGiftComboViewNew r2 = c4();
        if (r2 == null) goto L15;
        r2.setVisibility(8);
    L15:
        com.bytedance.android.livesdk.gift.util.b.f(new GiftStateMachineConfig.Event.p(this.b, AbsPanel.GiftPanelSelectType.NORMAL_SELECTED, false, false));
        T r3 = this.b.h;
        if ((r3 instanceof h1) == false) goto L23;
        if (r3 == 0) goto L20;
        SimpleSweepGiftViewHolder.X3(((h1) r3).getId());
        return;
    L20:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.gift.model.IGift");
    L23:
        return;
    }

    public final LiveGiftComboViewNew c4() {
        GiftContext r0 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r0 == null) goto L9;
        i<LiveGiftComboWidget> r1 = r0.getLiveGiftComboWidget();
        if (r1 == null) goto L9;
        LiveGiftComboWidget r2 = (LiveGiftComboWidget) r1.getValue();
        if (r2 == null) goto L9;
        return r2.wq();
    L9:
        return null;
    }

    public final void j4() {
        LiveGiftComboViewNew r0 = c4();
        if (r0 == null) goto L5;
        r0.setVisibility(8);
    L5:
        com.bytedance.android.livesdk.gift.util.b.f(new GiftStateMachineConfig.Event.g(this.b));
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.SimpleSweepGiftViewHolder
    public final rz1.b V3() {
        return this.z;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.SimpleSweepGiftViewHolder
    public final GiftIconMaskView W3() {
        return this.p;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.SimpleGiftViewHolder, com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.BaseLiveGiftViewHolder
    public final void T3(AbsPanel<?> r20) {
        Intrinsics.checkNotNullParameter(r20, "absPanel");
        super.T3(r20);
        this.w = r20;
        k r3 = null;
        if ((com.bytedance.android.livesdk.gift.vs.panel.statemachine.helper.b.i() instanceof GiftStateMachineConfig.a.C0022a) == false) goto L17;
        GiftStateMachineConfig.a.C0022a r2 = (GiftStateMachineConfig.a.C0022a) com.bytedance.android.livesdk.gift.vs.panel.statemachine.helper.b.i();
        if (r2 == null) goto L7;
        AbsPanel<?> r4 = r2.a;
    L9:
        if (r4 != this.b) goto L17;
        GiftStateMachineConfig.a.C0022a r5 = (GiftStateMachineConfig.a.C0022a) com.bytedance.android.livesdk.gift.vs.panel.statemachine.helper.b.i();
        if (r5 == null) goto L13;
        AbsPanel<?> r6 = r5.b;
    L14:
        this.w = r6;
        if (r6 != null) goto L17;
        this.w = r20;
        goto L17
    L13:
        r6 = null;
        goto L14
    L7:
        r4 = null;
    L17:
        T r7 = r20.h;
        if ((r7 instanceof h1) == true) goto L20;
    L60:
        this.n.setVisibility(8);
    L62:
        if (this.b != null) goto L64;
        return;
    L64:
        this.h.getDataCenter();
        if (u.p() == true) goto L88;
        AbsPanel r8 = this.b;
        if (r8 == null) goto L88;
        T r9 = r8.h;
        if ((r9 instanceof h1) == false) goto L88;
        if (r9 == 0) goto L86;
        k0 r10 = ((h1) r9).getGiftPreviewInfo();
        if (r10 != null) goto L75;
    L76:
        this.h.getDataCenter();
        if (u.p() == true) goto L79;
        boolean r11 = true;
    L80:
        View r13 = this.q;
        if (r11 == false) goto L83;
        int r14 = 0;
    L84:
        r13.setVisibility(r14);
        goto L88
    L83:
        r14 = 8;
    L79:
        r11 = false;
        goto L80
    L75:
        if (r10.getLockStatus() == k0.UNLOCKED) goto L79;
    L86:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.gift.model.IGift");
    L88:
        if (this.b.b() == null) goto L90;
        this.j.setVisibility(0);
        ImageLoader.bindImage(this.j, this.b.b(), this.j.getWidth(), this.j.getHeight(), new com.bytedance.android.livesdk.gift.vs.panel.viewholder.c(this));
    L91:
        AbsPanel r15 = this.b;
        if ((r15 instanceof pz1.a) == false) goto L97;
        if (r15 == null) goto L96;
        long r16 = ((pz1.a) r15).j();
    L105:
        if (r16 <= 0) goto L114;
        j r17 = com.bytedance.android.livesdk.gift.util.b.a();
        GiftConfigKey r18 = GiftConfigKey.KEY_GIFT_DIALOG_DIAMOND;
        DiamondConfig.d.getClass();
        DiamondConfig r19 = (DiamondConfig) r17.c(r18, DiamondConfig.a.a());
        if ((this.b.h instanceof h1) == false) goto L113;
        m r110 = (m) com.bytedance.android.livesdk.gift.util.b.a().d(m.class);
        T r111 = this.b.h;
        if (r111 == 0) goto L112;
        h1 r112 = (h1) r111;
        r110.g();
        goto L113
    L112:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.gift.model.IGift");
    L113:
        String r113 = String.valueOf(r16) + " " + r19.b;
        String r114 = String.valueOf(r16) + " " + r19.b;
    L115:
        this.l.setText(r113);
        this.l.setTextColor(s1.h(2131106882));
        this.l.requestLayout();
        k r21 = b4();
        if (r21 != null) goto L118;
    L121:
        AbsPanel<?> r23 = this.w;
        if (r23 == null) goto L124;
        r3 = r23.d();
    L124:
        k r115 = r3;
    L125:
        T r24 = this.b.h;
        if ((r24 instanceof h1) == false) goto L131;
        if (r24 == 0) goto L130;
        boolean r116 = j0.e((h1) r24);
    L132:
        e4().a(r115, r114, s1.h(2131106882), s1.B(2131922465), r116, 0, null);
        if (this.b.e() == null) goto L135;
        this.i.setVisibility(0);
        ImageLoader.bindImage(this.i, this.b.e(), s1.j(2131168730), s1.j(2131168729), new com.bytedance.android.livesdk.gift.vs.panel.viewholder.d(this));
    L136:
        T r25 = r20.h;
        if ((r25 instanceof h1) == false) goto L144;
        if (r25 == 0) goto L143;
        h1 r26 = (h1) r25;
        h2 r27 = rz1.a.b(Long.valueOf(r26.getId()));
        if (r27 == null) goto L144;
        ImageUtil.loadImage(this.c, r27.getImage(), 0);
        this.d.setText(r27.getName());
        jy0.b.d("CustomSpecialGiftEffects", "show gift id: " + r26.getId() + " relatedid: " + r27.getId());
        goto L144
    L143:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.gift.model.IGift");
    L144:
        n4(this.b.d);
        if ((r20 instanceof com.bytedance.android.livesdk.gift.platform.business.dialog.ui.panel.a) == false) goto L152;
        LiveGiftComboViewNew r28 = c4();
        if (r28 == null) goto L149;
        r28.setGiftId(r20.c());
    L149:
        LiveGiftComboViewNew r29 = c4();
        if (r29 == null) goto L165;
        r29.setPropId(-1);
    L165:
        LiveGiftComboViewNew r30 = c4();
        if (r30 == null) goto L169;
        r30.setPanel(r20);
    L169:
        if (g4() == true) goto L173;
        LiveGiftComboViewNew r31 = c4();
        if (r31 == null) goto L173;
        r31.e();
    L173:
        k r33 = d4();
        if (r33 != null) goto L176;
    L180:
        k r34 = d4();
        if (r34 == null) goto L183;
        a1.k(r34).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new c(this), d.a);
    L183:
        this.D.b = r20.f();
        this.D.a = r20.d();
        r3.d(((RecyclerView.ViewHolder) this).itemView, r20.f() + ", " + this.l.getText(), r20.h(), true);
        return;
    L176:
        if (r33.isValid() != true) goto L180;
        View r35 = ((RecyclerView.ViewHolder) this).itemView.findViewById(2131364437);
        if (r35 == null) goto L180;
        r35.setBackgroundResource(0);
        goto L180
    L152:
        T r36 = r20.h;
        if ((r36 instanceof l2) == false) goto L165;
        if (r36 == 0) goto L164;
        l2 r37 = (l2) r36;
        if (r37.getGift() == null) goto L165;
        LiveGiftComboViewNew r38 = c4();
        if (r38 == null) goto L160;
        r38.setGiftId(r37.getGift().getId());
    L160:
        LiveGiftComboViewNew r39 = c4();
        if (r39 == null) goto L165;
        r39.setPropId(r37.getId());
        goto L165
    L164:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.gift.model.IProp");
    L135:
        this.i.setVisibility(8);
        goto L136
    L130:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.gift.model.IGift");
    L131:
        r116 = false;
        goto L132
    L118:
        if (r21.isValid() == false) goto L121;
        r115 = r21;
        goto L125
    L114:
        r113 = s1.B(2131919120);
        r114 = r113;
        goto L115
    L96:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.gift.platform.business.dialog.ui.panel.AbsGiftPanel<*>");
    L97:
        T r40 = r15.h;
        if ((r40 instanceof h1) == false) goto L103;
        if (r40 == 0) goto L102;
        r16 = ((h1) r40).getDiamondCount();
        goto L105
    L102:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.gift.model.IGift");
    L103:
        r16 = 0;
        goto L105
    L90:
        this.j.setVisibility(8);
        goto L91
    L20:
        if (this.C == false) goto L60;
        if (r7 == 0) goto L59;
        h1 r41 = (h1) r7;
        long r117 = r41.getId();
        GiftContext r43 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r43 == null) goto L30;
        i<Map<Long, l>> r44 = r43.getGiftIdMapToInfo();
        if (r44 == null) goto L30;
        Map r45 = (Map) r44.getValue();
        if (r45 == null) goto L30;
        l r46 = (l) r45.get(Long.valueOf(r117));
        if (r46 == null) goto L30;
    L31:
        c2 r47 = r46.a;
        if (r47 != null) goto L34;
        this.n.setVisibility(8);
        this.k.setVisibility(8);
        goto L62
    L34:
        this.n.setPadding(s1.f(5.0f), 0, s1.f(5.0f), 0);
        if (r41.getGiftEndingTime() <= 0) goto L38;
        GiftLabelTextView r118 = this.n;
        long r119 = r41.getGiftEndingTime();
        u0 r120 = u0.g;
        this.r = r118.A(r119 * r120.a, r41.getNowTimeDiffSeconds() * r120.a, new VSGiftDialogViewHolder$setCountDownTime$1(this));
        this.n.setVisibility(0);
    L52:
        if (TextUtils.isEmpty(r47.getBackgroundColor()) == true) goto L62;
        Drawable r48 = this.n.getBackground();
        if (r48 == null) goto L57;
        ((GradientDrawable) r48).setColor(ColorProtector.parseColor(r47.getBackgroundColor()));
        goto L62
    L57:
        throw new NullPointerException("null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
    L38:
        if (r47.getPrefixImage() == null) goto L48;
        if (com.bytedance.android.livesdk.gift.vs.panel.statemachine.helper.b.s() == false) goto L42;
        this.n.setVisibility(8);
        this.k.setVisibility(8);
        goto L52
    L42:
        if (r47.getPrefixImage() == null) goto L44;
        a1.v(this.k, r47.getPrefixImage(), 2131250965);
        this.n.setPadding(s1.f(19.0f), 0, s1.f(5.0f), 0);
        this.n.setVisibility(0);
        this.k.setVisibility(0);
    L45:
        l4(r47);
        goto L52
    L44:
        this.k.setVisibility(8);
        this.n.setVisibility(8);
        goto L45
    L48:
        if (r47.getDisplayText() == null) goto L50;
        l4(r47);
        goto L52
    L50:
        this.n.setVisibility(8);
    L30:
        r46 = new l(null);
        goto L31
    L59:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.gift.model.IGift");
    }

    public final void i4(View r6) {
        m4(false);
        if (com.bytedance.android.livesdk.gift.vs.panel.statemachine.helper.b.i() != null) goto L5;
    L13:
        h4();
        AbsPanel r0 = this.b;
        if ((r0 instanceof pz1.a) == false) goto L21;
        if (r0 == null) goto L20;
        if (((pz1.a) r0).m() == false) goto L21;
        boolean r1 = true;
    L22:
        if (r1 == true) goto L24;
    L30:
        boolean r2 = false;
    L31:
        if (r2 == false) goto L40;
        ay1.b.z();
        int[] r3 = new int[2];
        this.o.getLocationOnScreen(r3);
        GiftContext r4 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r4 == null) goto L41;
        i<LiveGiftComboWidget> r5 = r4.getLiveGiftComboWidget();
        if (r5 == null) goto L42;
        LiveGiftComboWidget r7 = (LiveGiftComboWidget) r5.getValue();
        if (r7 == null) goto L43;
        r7.yq(r3[0], r3[1]);
        return;
    L43:
        return;
    L42:
        return;
    L41:
        return;
    L40:
        return;
    L24:
        if (jc1.k.n(IRechargeService.class).rechargeCenter().isDiamondAvailable(1) == false) goto L30;
        if (((Boolean) ay1.b.c0.getValue(null, ay1.b.a[66])).booleanValue() == true) goto L30;
        if (this.B == false) goto L30;
        r2 = true;
        goto L31
    L20:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.gift.platform.business.dialog.ui.panel.AbsGiftPanel<*>");
    L21:
        r1 = false;
        goto L22
    L5:
        if ((com.bytedance.android.livesdk.gift.vs.panel.statemachine.helper.b.i() instanceof GiftStateMachineConfig.a.g) == false) goto L13;
        n4(AbsPanel.GiftPanelSelectType.IDLE);
        LiveGiftComboViewNew r8 = c4();
        if (r8 == null) goto L9;
        r8.d();
    L9:
        LiveGiftComboViewNew r9 = c4();
        if (r9 == null) goto L12;
        r9.setVisibility(8);
    L12:
        com.bytedance.android.livesdk.gift.util.b.f(GiftStateMachineConfig.Event.o.b);
        goto L13
    }

    public final void l4(c2 r3) {
        CharSequence r4 = vh6.c.b(ur2.a.class).Lf(r3.getDisplayText(), BuildConfig.FLAVOR);
        if (TextUtils.isEmpty(r4) == false) goto L5;
        this.n.setVisibility(8);
        this.k.setVisibility(8);
        return;
    L5:
        this.n.setText(r4);
        this.n.setVisibility(0);
    }

    public final void m4(boolean r3) {
        T r0 = this.b.h;
        if ((r0 instanceof h1) == false) goto L8;
        if (r0 == 0) goto L7;
        boolean r1 = j0.e((h1) r0);
        e4().f(r3, r1);
    L9:
        this.b.e = r3;
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.gift.model.IGift");
    L8:
        e4().f(r3, false);
        goto L9
    }

    public final void n4(AbsPanel.GiftPanelSelectType r13) {
        Intrinsics.checkNotNullParameter(r13, "type");
        LiveGiftComboViewNew r0 = c4();
        if (r0 == null) goto L5;
        r0.d();
    L5:
        LiveGiftComboViewNew r1 = c4();
        if (r1 == null) goto L9;
        r1.setVisibility(8);
    L9:
        if (r13 == AbsPanel.GiftPanelSelectType.IDLE) goto L13;
        GiftContext r2 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r2 == null) goto L13;
        r2.getCurrentSelectedGiftPosition().setValue(Integer.valueOf(getLayoutPosition()));
    L13:
        r3.d(((RecyclerView.ViewHolder) this).itemView, BuildConfig.FLAVOR, true, true);
        int r14 = com.bytedance.android.livesdk.gift.vs.panel.viewholder.a.a[r13.ordinal()];
        if (r14 == 1) goto L64;
        if (r14 == 2) goto L49;
        if (r14 == 3) goto L33;
        if (r14 == 4) goto L28;
        e4().h(8);
        s r15 = e4();
        if (r15.a == false) goto L26;
        LiveSendGiftAnimationView r16 = r15.b;
        if (r16 == null) goto L26;
        AnimatorSet r17 = r16.o;
        if (r17 == null) goto L26;
        r17.cancel();
    L26:
        this.o.setVisibility(0);
        r3.d(((RecyclerView.ViewHolder) this).itemView, BuildConfig.FLAVOR, false, true);
        return;
    L28:
        if (e4().c() == 0) goto L99;
        e4().h(0);
        this.o.setVisibility(8);
        LiveGiftComboViewNew r18 = c4();
        if (r18 == null) goto L100;
        r18.setVisibility(8);
        return;
    L100:
        return;
    L99:
        return;
    L33:
        if (e4().c() == 0) goto L42;
        e4().h(0);
        if (f4() == true) goto L42;
        if (this.h.isGiftUpdateOptimizeOpen() == false) goto L39;
        e4().i();
    L40:
        this.o.setVisibility(8);
        goto L42
    L39:
        e4().j();
    L42:
        if (this.y != 0) goto L102;
        w1 r19 = com.bytedance.android.livesdk.gift.vs.panel.statemachine.helper.b.g();
        if (r19 == null) goto L46;
        int r5 = r19.getPageType();
    L47:
        T r4 = this.b.h;
        int r6 = getLayoutPosition();
        DataCenter r7 = this.h.getDataCenter();
        IBaseUser r8 = com.bytedance.android.livesdk.gift.vs.panel.statemachine.helper.b.r();
        AbsPanel r110 = this.b;
        com.bytedance.android.livesdk.gift.platform.core.utils.h.v(r4, r5, r6, r7, r8, r110.f, r110.c, U3());
        this.y++;
        return;
    L46:
        r5 = 1;
        goto L47
    L102:
        return;
    L49:
        if (e4().c() == 0) goto L54;
        e4().h(0);
        if (f4() == true) goto L54;
        e4().j();
        this.o.setVisibility(8);
    L54:
        if (this.b.h() == true) goto L56;
        return;
    L56:
        if (this.x == 0) goto L58;
        return;
    L58:
        if (this.y != 0) goto L106;
        w1 r111 = com.bytedance.android.livesdk.gift.vs.panel.statemachine.helper.b.g();
        if (r111 == null) goto L62;
        int r9 = r111.getPageType();
    L63:
        T r10 = this.b.h;
        int r11 = getLayoutPosition();
        DataCenter r20 = this.h.getDataCenter();
        IBaseUser r21 = com.bytedance.android.livesdk.gift.vs.panel.statemachine.helper.b.r();
        AbsPanel r112 = this.b;
        com.bytedance.android.livesdk.gift.platform.core.utils.h.v(r10, r9, r11, r20, r21, r112.f, r112.c, U3());
        this.x++;
        return;
    L62:
        r9 = 1;
        goto L63
    L106:
        return;
    L64:
        AbsPanel r113 = this.b;
        r113.getClass();
        r113.d = AbsPanel.GiftPanelSelectType.JUST_SELECTED;
        if (e4().c() == 0) goto L89;
        e4().h(0);
        boolean r114 = f4();
        if (r114 == true) goto L88;
        s r3 = e4();
        if (r3.a == false) goto L87;
        LiveSendGiftAnimationView r23 = r3.b;
        if (r23 == null) goto L87;
        f0 r24 = r23.J;
        if (r24 != null) goto L75;
    L77:
        Pair<Float, Animator> r25 = r23.b;
        if (r25 != null) goto L80;
    L85:
        Pair<Float, Animator> r26 = new Pair(Float.valueOf(1.06f), ObjectAnimator.ofPropertyValuesHolder(r23, new PropertyValuesHolder[]{PropertyValuesHolder.ofFloat("scaleX", new float[]{1.0f, 1.06f, 1.0f}), PropertyValuesHolder.ofFloat("scaleY", new float[]{1.0f, 1.06f, 1.0f})}));
        r23.b = r26;
        ((Animator) r26.second).setDuration(200);
        ((Animator) r23.b.second).setInterpolator(PathInterpolatorCompat.create(0.42f, 0.0f, 0.58f, 1.0f));
    L86:
        ((Animator) r23.b.second).start();
        goto L87
    L80:
        if (r25.second == null) goto L85;
        Object r27 = r25.first;
        if (r27 == null) goto L85;
        if (((Float) r27).floatValue() == 1.06f) goto L86;
    L75:
        if (r24.b() == false) goto L77;
        r23.o();
    L87:
        this.o.setVisibility(8);
    L88:
        m4(this.b.e);
        j4();
        boolean r28 = r114;
    L91:
        if (this.b == null) goto L108;
        yz0.k r115 = com.bytedance.android.live.revenue.core.util.f.d(com.bytedance.android.live.revenue.core.util.j.C0.a(), yz0.k.class);
        if (r115 == null) goto L95;
        IRoom r116 = r115.getRoom();
    L96:
        IRoom r29 = r116;
        T r30 = this.b.h;
        int r31 = getLayoutPosition();
        DataCenter r33 = this.h.getDataCenter();
        IBaseUser r34 = com.bytedance.android.livesdk.gift.vs.panel.statemachine.helper.b.r();
        AbsPanel r117 = this.b;
        com.bytedance.android.livesdk.gift.platform.core.utils.h.E(r29, r30, r31, r33, r34, r28, r117.f, r117.c, U3());
        return;
    L95:
        r116 = null;
        goto L96
    L108:
        return;
    L89:
        r28 = false;
        goto L91
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.SimpleGiftViewHolder, com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.BaseLiveGiftViewHolder, android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View r2) {
        Intrinsics.checkNotNullParameter(r2, "v");
        super.onViewAttachedToWindow(r2);
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.BaseLiveGiftViewHolder, android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View r2) {
        Intrinsics.checkNotNullParameter(r2, "v");
        this.z.b();
        this.A.clear();
    }

    public VSGiftDialogViewHolder(final View r4, GiftViewModelManager r5) {
        Intrinsics.checkNotNullParameter(r4, "itemView");
        Intrinsics.checkNotNullParameter(r5, "viewModel");
        super(r4);
        this.f = 500;
        this.g = 20;
        this.h = r5;
        this.i = r4.findViewById(2131377795);
        this.j = r4.findViewById(2131369000);
        this.k = r4.findViewById(2131363715);
        this.l = (TextView) r4.findViewById(2131368992);
        this.m = LazyKt.lazy(new VSGiftDialogViewHolder$mSendGiftView$2(r4));
        this.n = (GiftLabelTextView) r4.findViewById(2131373734);
        this.o = r4.findViewById(2131367792);
        GiftIconMaskView r6 = (GiftIconMaskView) r4.findViewById(2131373731);
        this.p = r6;
        this.q = r4.findViewById(2131373739);
        this.r = true;
        this.u = true;
        this.A = new CompositeDisposable();
        this.B = true;
        this.C = true;
        this.D = new n(null, null, 7);
        r4.setOnTouchListener(new a(this));
        this.s = UIUtils.dip2Px(r4.getContext(), 13.0f);
        this.z = new rz1.b(r6, this.c);
    }

    public final void Z3(int r28, View r29, int r30) {
        boolean r15 = false;
        if (r28 == 0) goto L166;
        if (r28 != 1) goto L6;
        i4(r29);
        return;
    L6:
        if (r28 == 2) goto L24;
        if (r28 == 3) goto L10;
        return;
    L10:
        if (com.bytedance.android.livesdk.gift.platform.business.dialog.v2.d.a(com.bytedance.android.livesdk.gift.vs.panel.statemachine.helper.b.r().getIdString(), null) == false) goto L13;
        ToastUtil.a(2131915261, 0);
        m02.a.a();
        return;
    L13:
        if (g4() == true) goto L15;
        return;
    L15:
        if (this.h.isPreCheckSendGift(com.bytedance.android.livesdk.gift.vs.panel.statemachine.helper.b.r()) == false) goto L196;
        LiveGiftComboViewNew r1 = c4();
        if (r1 == null) goto L19;
        r1.c(new com.bytedance.android.livesdk.gift.vs.panel.viewholder.f(this), true, false);
    L19:
        AbsPanel<?> r2 = com.bytedance.android.livesdk.gift.vs.panel.statemachine.helper.b.d();
        if (r2 == null) goto L197;
        LiveGiftComboViewNew r3 = c4();
        if (r3 == null) goto L198;
        r3.c(new com.bytedance.android.livesdk.gift.vs.panel.viewholder.e(r2, this), true, true);
        return;
    L198:
        return;
    L197:
        return;
    L196:
        return;
    L24:
        m4(false);
        if (com.bytedance.android.livesdk.gift.platform.business.dialog.v2.d.a(com.bytedance.android.livesdk.gift.vs.panel.statemachine.helper.b.r().getIdString(), null) == false) goto L28;
        ToastUtil.a(2131915261, 0);
        m02.a.a();
        return;
    L28:
        if (this.h.isPreCheckSendGift(com.bytedance.android.livesdk.gift.vs.panel.statemachine.helper.b.r()) == false) goto L201;
        AbsPanel r4 = this.b;
        if ((r4 instanceof pz1.a) == true) goto L32;
    L58:
        boolean r5 = false;
    L59:
        if (r5 == true) goto L114;
        e4().h(8);
        int[] r6 = new int[2];
        this.o.getLocationInWindow(r6);
        GiftContext r7 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r7 == null) goto L90;
        i<LiveGiftComboWidget> r8 = r7.getLiveGiftComboWidget();
        if (r8 == null) goto L90;
        LiveGiftComboWidget r9 = (LiveGiftComboWidget) r8.getValue();
        if (r9 == null) goto L90;
        int r11 = r6[0];
        int r10 = r6[1];
        LiveGiftComboViewNew r16 = r9.wq();
        if (r16 == null) goto L70;
        ViewGroup.LayoutParams r13 = r16.getLayoutParams();
    L72:
        if ((r13 instanceof FrameLayout.LayoutParams) == false) goto L84;
        FrameLayout.LayoutParams r14 = (FrameLayout.LayoutParams) r13;
        r14.topMargin = r10 - com.bytedance.android.live.revenue.common.i.b(75);
        r14.leftMargin = r11 - com.bytedance.android.live.revenue.common.i.b(35);
        r14.rightMargin = com.bytedance.android.live.revenue.common.i.b(-35);
        r14.bottomMargin = com.bytedance.android.live.revenue.common.i.b(-75);
        if (PadConfigUtils.c() == false) goto L76;
    L77:
        int r17 = r14.leftMargin;
        int[] r18 = new int[2];
        ViewGroup r19 = ((Widget) r9).containerView;
        if (r19 == null) goto L80;
        r19.getLocationInWindow(r18);
    L80:
        r14.leftMargin = r17 - r18[0];
        int r20 = r14.topMargin;
        int[] r21 = new int[2];
        ViewGroup r110 = ((Widget) r9).containerView;
        if (r110 == null) goto L83;
        r110.getLocationInWindow(r21);
    L83:
        r14.topMargin = r20 - r21[1];
        goto L84
    L76:
        if (com.bytedance.android.livesdk.gift.util.a.a() == true) goto L77;
    L84:
        ViewGroup r23 = ((Widget) r9).containerView;
        if (r23 == null) goto L87;
        r23.requestLayout();
    L87:
        LiveGiftComboViewNew r24 = r9.wq();
        if (r24 == null) goto L90;
        r24.setVisibility(0);
        goto L90
    L70:
        r13 = null;
    L90:
        final LiveGiftComboViewNew r25 = c4();
        if (r25 == null) goto L114;
        final com.bytedance.android.livesdk.gift.vs.panel.viewholder.b r26 = new com.bytedance.android.livesdk.gift.vs.panel.viewholder.b(this);
        if (r25.a() == true) goto L95;
        r25.j = 0;
        ToastUtil.a(2131919787, 0);
        goto L114
    L95:
        r25.h++;
        if (r25.e != 0) goto L98;
        r25.b();
        r25.d = new AnimatorSet();
        r25.d.playTogether(new Animator[]{ObjectAnimator.ofFloat(r25.a, "scaleX", new float[]{1.0f, 1.1f, 1.0f}), ObjectAnimator.ofFloat(r25.a, "scaleY", new float[]{1.0f, 1.1f, 1.0f}), ObjectAnimator.ofFloat(r25.b, "scaleX", new float[]{1.0f, 1.1f, 1.0f}), ObjectAnimator.ofFloat(r25.b, "scaleY", new float[]{1.0f, 1.1f, 1.0f}), ObjectAnimator.ofFloat(r25.c, "scaleX", new float[]{1.0f, 1.1f, 1.0f}), ObjectAnimator.ofFloat(r25.c, "scaleY", new float[]{1.0f, 1.1f, 1.0f})});
        r25.d.setDuration(300);
        r25.d.setInterpolator(new PathInterpolator(0.42f, 0.0f, 0.58f, 1.0f));
        r25.d.addListener(new r(r25, r26));
        r25.d.start();
    L99:
        RoundWaveAnimationView r27 = r25.k;
        if (r27 == null) goto L102;
        r27.a();
    L102:
        ComboIconAnimationView r31 = r25.n;
        if (r31 == null) goto L105;
        r31.c(r25.h);
    L105:
        ComboEffectAnimationView r33 = r25.l;
        if (r33 == null) goto L108;
        r33.a(r25.h);
    L108:
        ComboProgressAnimationView r34 = r25.m;
        if (r34 == null) goto L114;
        r34.i(r25.h, 0);
        if (r25.h <= 1) goto L114;
        r25.m.j();
        goto L114
    L98:
        r25.e = 1;
        r25.f(new b02.k(r25, r26));
    L114:
        if (com.bytedance.android.livesdk.gift.util.b.c(false) != null) goto L117;
    L129:
        AbsPanel<?> r35 = com.bytedance.android.livesdk.gift.vs.panel.statemachine.helper.b.d();
        if (r35 == null) goto L163;
        T r36 = r35.h;
        if ((r36 instanceof h1) == false) goto L155;
        if (r36 == 0) goto L154;
        h1 r37 = (h1) r36;
        h2 r38 = rz1.a.b(Long.valueOf(r37.getId()));
        if (r38 == null) goto L145;
        jy0.b.d("CustomSpecialGiftEffects", "send gift id: " + r37.getId() + " relatedid: " + r38.getId());
        GiftDialogViewModelNew r39 = com.bytedance.android.livesdk.gift.vs.panel.statemachine.helper.b.j();
        if (r39 == null) goto L139;
        AbsPanel<?> r40 = ((GiftStateMachineConfig.a) r39.f.b()).b();
    L140:
        if (r40 == null) goto L163;
        IBaseUser r41 = com.bytedance.android.livesdk.gift.vs.panel.statemachine.helper.b.r();
        if (r30 != 1) goto L144;
        r15 = true;
    L144:
        com.bytedance.android.livesdk.gift.util.b.f(new GiftStateMachineConfig.Event.q(r40, 1, 4, r41, 0, r15, this.D));
        goto L163
    L139:
        r40 = null;
        goto L140
    L145:
        IBaseUser r210 = com.bytedance.android.livesdk.gift.vs.panel.statemachine.helper.b.r();
        if ((com.bytedance.android.livesdk.gift.vs.panel.statemachine.helper.b.i() instanceof GiftStateMachineConfig.a.C0022a) == false) goto L149;
        GiftStateMachineConfig.a.C0022a r43 = (GiftStateMachineConfig.a.C0022a) com.bytedance.android.livesdk.gift.vs.panel.statemachine.helper.b.i();
    L149:
        if (r30 != 1) goto L151;
        boolean r211 = true;
    L152:
        com.bytedance.android.livesdk.gift.util.b.f(new GiftStateMachineConfig.Event.q(r35, 1, 4, r210, 0, r211, this.D));
        goto L163
    L151:
        r211 = false;
        goto L152
    L154:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.gift.model.IGift");
    L155:
        IBaseUser r212 = com.bytedance.android.livesdk.gift.vs.panel.statemachine.helper.b.r();
        if ((com.bytedance.android.livesdk.gift.vs.panel.statemachine.helper.b.i() instanceof GiftStateMachineConfig.a.C0022a) == false) goto L159;
        GiftStateMachineConfig.a.C0022a r44 = (GiftStateMachineConfig.a.C0022a) com.bytedance.android.livesdk.gift.vs.panel.statemachine.helper.b.i();
    L159:
        if (r30 != 1) goto L161;
        boolean r213 = true;
    L162:
        com.bytedance.android.livesdk.gift.util.b.f(new GiftStateMachineConfig.Event.q(r35, 1, 4, r212, 0, r213, this.D));
        goto L163
    L161:
        r213 = false;
    L163:
        com.bytedance.android.livesdk.gift.platform.core.utils.h.l();
        return;
    L117:
        if (com.bytedance.android.livesdk.gift.vs.panel.statemachine.helper.b.d() == null) goto L129;
        com.bytedance.android.livesdk.gift.platform.business.g r45 = com.bytedance.android.livesdk.gift.util.b.c(false);
        if (r45 == null) goto L129;
        List<com.bytedance.android.livesdk.gift.platform.business.f> r46 = r45.c();
        if (r46 == null) goto L129;
        Iterator<com.bytedance.android.livesdk.gift.platform.business.f> r47 = r46.iterator();
    L125:
        if (r47.hasNext() == false) goto L129;
        com.bytedance.android.livesdk.gift.platform.business.f r48 = r47.next();
        if (r48 == null) goto L125;
        r48.s();
        goto L125
    L32:
        if (r4.i() == true) goto L55;
        T r49 = this.b.h;
        if ((r49 instanceof h1) == false) goto L58;
        if (r49 == 0) goto L57;
        if (((h1) r49).getType() == 4) goto L55;
        T r50 = this.b.h;
        if (r50 == 0) goto L54;
        if (((h1) r50).getType() == 2) goto L55;
        T r51 = this.b.h;
        if (r51 == 0) goto L52;
        k0 r53 = ((h1) r51).getGiftPreviewInfo();
        if (r53 == null) goto L55;
        if (r53.getLockStatus() == k0.UNLOCKED) goto L58;
    L52:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.gift.model.IGift");
    L54:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.gift.model.IGift");
    L57:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.gift.model.IGift");
    L55:
        r5 = true;
        goto L59
    L201:
        return;
    L166:
        if (this.B == false) goto L206;
        AbsPanel r54 = this.b;
        if ((r54 instanceof pz1.a) == false) goto L176;
        if (r54 == null) goto L175;
        if (((pz1.a) r54).m() == false) goto L176;
        boolean r55 = true;
    L177:
        if (r55 == false) goto L183;
        m4(true);
        ay1.b.z();
        ay1.b.d0.setValue(null, ay1.b.a[67], Boolean.TRUE);
        h4();
        com.bytedance.android.livesdk.gift.util.b.f(new GiftStateMachineConfig.Event.a0(this.b));
        com.bytedance.android.livesdk.gift.platform.core.utils.h.W(this.b.c(), getLayoutPosition());
        String r56 = com.bytedance.android.livesdk.gift.platform.core.utils.h.a;
        long r57 = this.b.c();
        GiftDialogViewModelNew r58 = com.bytedance.android.livesdk.gift.vs.panel.statemachine.helper.b.j();
        if (r58 == null) goto L181;
        DataCenter r59 = r58.g;
    L182:
        com.bytedance.android.livesdk.gift.platform.core.utils.h.B(r57, "bunching_panel", r59);
        return;
    L181:
        r59 = null;
        goto L182
    L183:
        int r60 = ToastUtil.a;
        ToastUtil.b(nz1.a.t(), 0);
        m4(false);
        float r61 = 20;
        ObjectAnimator r63 = ObjectAnimator.ofPropertyValuesHolder(((RecyclerView.ViewHolder) this).itemView, new PropertyValuesHolder[]{PropertyValuesHolder.ofKeyframe(View.TRANSLATION_X, new Keyframe[]{Keyframe.ofFloat(0.0f, 0.0f), Keyframe.ofFloat(0.1f, -20.0f), Keyframe.ofFloat(0.26f, r61), Keyframe.ofFloat(0.42f, -20.0f), Keyframe.ofFloat(0.58f, r61), Keyframe.ofFloat(0.74f, -20.0f), Keyframe.ofFloat(0.9f, r61), Keyframe.ofFloat(1.0f, 0.0f)})}).setDuration(500);
        r63.addListener(new h(this, r29));
        r63.start();
        String r64 = com.bytedance.android.livesdk.gift.platform.core.utils.h.a;
        long r65 = this.b.c();
        GiftDialogViewModelNew r66 = com.bytedance.android.livesdk.gift.vs.panel.statemachine.helper.b.j();
        if (r66 == null) goto L186;
        DataCenter r67 = r66.g;
    L187:
        com.bytedance.android.livesdk.gift.platform.core.utils.h.B(r65, "toast", r67);
        return;
    L186:
        r67 = null;
        goto L187
    L175:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.gift.platform.business.dialog.ui.panel.AbsGiftPanel<*>");
    L176:
        r55 = false;
        goto L177
    }

    public final boolean k4(View r9, MotionEvent r10, int r11, int r13, int r14) {
        if (r10 != null) goto L6;
        return false;
    L6:
        if (r10.getAction() != 0) goto L13;
        if (this.h.isGiftUpdateOptimizeOpen() == false) goto L10;
        PropertyValuesHolder r15 = PropertyValuesHolder.ofFloat("scaleX", new float[]{1.0f, 0.92f});
        PropertyValuesHolder r16 = PropertyValuesHolder.ofFloat("scaleY", new float[]{1.0f, 0.92f});
        Interpolator r1 = PathInterpolatorCompat.create(0.42f, 0.0f, 0.58f, 1.0f);
        ObjectAnimator r17 = ObjectAnimator.ofPropertyValuesHolder(this.c, new PropertyValuesHolder[]{r15, r16});
        r17.setInterpolator(r1);
        r17.setDuration(100);
        r17.start();
    L10:
        this.u = false;
        this.t = 0;
        com.bytedance.android.live.core.utils.rxutils.j.a r18 = com.bytedance.android.live.core.utils.rxutils.j.a;
        long r19 = this.g;
        com.bytedance.android.live.core.utils.rxutils.j.a(r19, r19, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new f(this, r13, r9, r14));
        return true;
    L13:
        if (this.u == false) goto L16;
        return false;
    L16:
        if (r10.getAction() != 2) goto L59;
        if (this.t < this.f) goto L59;
        float r110 = r10.getX();
        float r2 = r10.getY();
        float r6 = 0;
        if (r110 < r6) goto L28;
        if (r110 > r9.getWidth()) goto L28;
        if (r2 < r6) goto L28;
        if (r2 <= r9.getHeight()) goto L59;
    L28:
        if (g4() == false) goto L56;
        LiveGiftComboViewNew r20 = c4();
        if (r20 == null) goto L56;
        g r111 = new g(this);
        if (r20.e == 0) goto L56;
        r20.e = 2;
        r20.g(r111);
        RoundWaveAnimationView r112 = r20.k;
        if (r112 == null) goto L39;
        Disposable r113 = r112.a;
        if (r113 == null) goto L39;
        r113.dispose();
    L39:
        ComboProgressAnimationView r114 = r20.m;
        if (r114 == null) goto L46;
        r114.n();
        r114.m(1800);
        if (r114.f == false) goto L44;
    L45:
        r114.o();
        goto L46
    L44:
        if (r114.j == true) goto L45;
    L46:
        Disposable r115 = r20.p;
        if (r115 != null) goto L49;
    L51:
        Disposable r116 = r20.o;
        if (r116 == null) goto L56;
        if (r116.isDisposed() == true) goto L56;
        r20.o.dispose();
        goto L56
    L49:
        if (r115.isDisposed() == true) goto L51;
        r20.p.dispose();
    L56:
        this.u = true;
        a4();
        return true;
    L59:
        if (r10.getAction() == 1) goto L63;
        if (r10.getAction() == 3) goto L63;
    L68:
        return false;
    L63:
        if (this.t >= this.f) goto L70;
        if (r10.getAction() == 3) goto L67;
        Z3(r11, r9, r14);
    L67:
        this.u = true;
        a4();
        goto L68
    L70:
        if (g4() == false) goto L98;
        LiveGiftComboViewNew r21 = c4();
        if (r21 == null) goto L98;
        g r117 = new g(this);
        if (r21.e == 0) goto L98;
        r21.e = 2;
        r21.g(r117);
        RoundWaveAnimationView r118 = r21.k;
        if (r118 == null) goto L81;
        Disposable r119 = r118.a;
        if (r119 == null) goto L81;
        r119.dispose();
    L81:
        ComboProgressAnimationView r120 = r21.m;
        if (r120 == null) goto L88;
        r120.n();
        r120.m(1800);
        if (r120.f == false) goto L86;
    L87:
        r120.o();
        goto L88
    L86:
        if (r120.j == true) goto L87;
    L88:
        Disposable r121 = r21.p;
        if (r121 != null) goto L91;
    L93:
        Disposable r122 = r21.o;
        if (r122 == null) goto L98;
        if (r122.isDisposed() == true) goto L98;
        r21.o.dispose();
        goto L98
    L91:
        if (r121.isDisposed() == true) goto L93;
        r21.p.dispose();
    L98:
        return true;
    }
}
