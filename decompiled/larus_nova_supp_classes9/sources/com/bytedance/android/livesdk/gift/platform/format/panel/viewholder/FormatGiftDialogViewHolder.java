package com.bytedance.android.livesdk.gift.platform.format.panel.viewholder;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Vibrator;
import android.text.TextUtils;
import android.util.Pair;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Interpolator;
import android.widget.TextView;
import androidx.core.view.animation.PathInterpolatorCompat;
import androidx.recyclerview.widget.RecyclerView;
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
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.view.combo.LiveGiftComboViewNew;
import com.bytedance.android.livesdk.gift.platform.business.normal.view.v2.GiftIconMaskView;
import com.bytedance.android.livesdk.gift.platform.core.GiftContext;
import com.bytedance.android.livesdk.gift.platform.core.l;
import com.bytedance.android.livesdk.gift.platform.core.model.n;
import com.bytedance.android.livesdk.gift.platform.core.utils.h;
import com.bytedance.android.livesdk.gift.platform.core.utils.u;
import com.bytedance.android.livesdk.gift.platform.format.panel.statemachine.FormatGiftPanelDialogViewModel;
import com.bytedance.android.livesdk.r3;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.episode.IEpisodeExtraInfo;
import com.bytedance.android.livesdkapi.depend.model.live.episode.IVSGiftPanel;
import com.bytedance.android.scope.q;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.common.utility.Lists;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.i;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.drawee.interfaces.DraweeController;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import py.k;
import qz1.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0016\u0018\u00002\u00020\u0001:\u0001\bR\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/format/panel/viewholder/FormatGiftDialogViewHolder;", "Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v2/view/SimpleSweepGiftViewHolder;", "Landroid/content/Context;", "E", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context", "b", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class FormatGiftDialogViewHolder extends SimpleSweepGiftViewHolder {
    public static final /* synthetic */ int F = 0;
    public final CompositeDisposable A;
    public boolean B;
    public boolean C;
    public final n D;
    public final Context E;
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
        public final /* synthetic */ FormatGiftDialogViewHolder a;

        public a(FormatGiftDialogViewHolder r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View r8, MotionEvent r9) {
            Intrinsics.checkNotNullParameter(r8, "v");
            Intrinsics.checkNotNullParameter(r9, "event");
            FormatGiftDialogViewHolder r1 = this.a;
            int r0 = FormatGiftDialogViewHolder.F;
            r1.getClass();
            if ((com.bytedance.android.livesdk.gift.platform.format.panel.statemachine.helper.b.e() instanceof GiftStateMachineConfig.a.e) == false) goto L5;
        L10:
            AbsPanel<?> r2 = com.bytedance.android.livesdk.gift.platform.format.panel.statemachine.helper.b.b();
            if (r2 != null) goto L13;
        L15:
            boolean r3 = false;
        L16:
            if (r3 == false) goto L19;
            return r1.h4(r8, r9, 2, 0, 1);
        L19:
            if ((com.bytedance.android.livesdk.gift.platform.format.panel.statemachine.helper.b.e() instanceof GiftStateMachineConfig.a.c) == false) goto L26;
            AbsPanel<?> r4 = com.bytedance.android.livesdk.gift.platform.format.panel.statemachine.helper.b.b();
            if (r4 == null) goto L26;
            if (r4.c() != r1.b.c()) goto L26;
            return r1.h4(r8, r9, 2, 3, 2);
        L26:
            return r1.h4(r8, r9, 1, 0, 0);
        L13:
            if (r2.c() != r1.b.c()) goto L15;
            r3 = true;
            goto L16
        L5:
            if ((com.bytedance.android.livesdk.gift.platform.format.panel.statemachine.helper.b.e() instanceof GiftStateMachineConfig.a.C0022a) == true) goto L10;
            if ((com.bytedance.android.livesdk.gift.platform.format.panel.statemachine.helper.b.e() instanceof GiftStateMachineConfig.a.g) == true) goto L10;
            if ((com.bytedance.android.livesdk.gift.platform.format.panel.statemachine.helper.b.e() instanceof GiftStateMachineConfig.a.b) == false) goto L15;
            goto L10
        }
    }

    public static final class b {
    }

    public static final class c extends AnimatorListenerAdapter {
        public final /* synthetic */ FormatGiftDialogViewHolder a;

        public c(FormatGiftDialogViewHolder r1) {
            this.a = r1;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
            FormatGiftDialogViewHolder r3 = this.a;
            int r0 = FormatGiftDialogViewHolder.F;
            HSImageView r4 = r3.d4().b();
            Animatable r1 = null;
            if (r4 == null) goto L5;
            DraweeController r5 = r4.getController();
        L6:
            if (r5 == null) goto L21;
            HSImageView r6 = this.a.d4().b();
            if (r6 == null) goto L12;
            DraweeController r7 = r6.getController();
            if (r7 == null) goto L12;
            r1 = r7.getAnimatable();
        L12:
            if (r1 == null) goto L22;
            HSImageView r8 = this.a.d4().b();
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

    public static final class d implements Observer<Long> {
        public final /* synthetic */ FormatGiftDialogViewHolder a;
        public final /* synthetic */ int b;
        public final /* synthetic */ View c;
        public final /* synthetic */ int d;

        public final void onComplete() {
            FormatGiftDialogViewHolder r0 = this.a;
            int r1 = FormatGiftDialogViewHolder.F;
            r0.a4();
        }

        public final void onError(Throwable r2) {
            Intrinsics.checkNotNullParameter(r2, "e");
            FormatGiftDialogViewHolder r3 = this.a;
            int r0 = FormatGiftDialogViewHolder.F;
            r3.a4();
        }

        public final void onNext(Object r4) {
            ((Number) r4).longValue();
            FormatGiftDialogViewHolder r5 = this.a;
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

        public d(FormatGiftDialogViewHolder r1, int r2, View r3, int r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }
    }

    static {
    }

    public final s d4() {
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

    public final boolean e4() {
        this.o.setVisibility(8);
        k r0 = b4();
        if (r0 != null) goto L5;
    L11:
        return false;
    L5:
        if (Lists.notEmpty(r0.getUrls()) == false) goto L11;
        String r1 = (String) ListProtector.get(r0.getUrls(), 0);
        AbstractDraweeController r2 = Fresco.newDraweeControllerBuilder().setUri(r1).setAutoPlayAnimations(false).build();
        HSImageView r3 = d4().b();
        if (r3 == null) goto L9;
        r3.setController(r2);
    L9:
        c r4 = new c(this);
        d4().k(r4);
        return true;
    }

    public final void f4() {
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

    @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.SimpleSweepGiftViewHolder
    public final rz1.b V3() {
        return this.z;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.SimpleSweepGiftViewHolder
    public final GiftIconMaskView W3() {
        return this.p;
    }

    public final Context getContext() {
        return this.E;
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
    public final void T3(AbsPanel<?> r19) {
        Intrinsics.checkNotNullParameter(r19, "absPanel");
        super.T3(r19);
        this.w = r19;
        T r0 = r19.h;
        if ((r0 instanceof h1) == true) goto L5;
    L46:
        this.n.setVisibility(8);
    L48:
        if (this.b != null) goto L50;
        return;
    L50:
        this.h.getDataCenter();
        if (u.p() == true) goto L62;
        AbsPanel r1 = this.b;
        if (r1 == null) goto L62;
        T r2 = r1.h;
        if ((r2 instanceof h1) == false) goto L62;
        if (r2 == 0) goto L60;
        h1 r3 = (h1) r2;
        this.q.setVisibility(8);
        goto L62
    L60:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.gift.model.IGift");
    L62:
        if (this.b.b() == null) goto L64;
        this.j.setVisibility(0);
        ImageLoader.bindImage(this.j, this.b.b(), this.j.getWidth(), this.j.getHeight(), new com.bytedance.android.livesdk.gift.platform.format.panel.viewholder.b(this));
    L65:
        AbsPanel r4 = this.b;
        if ((r4 instanceof pz1.a) == false) goto L71;
        if (r4 == null) goto L70;
        long r5 = ((pz1.a) r4).j();
    L79:
        if (r5 <= 0) goto L88;
        j r6 = com.bytedance.android.livesdk.gift.util.b.a();
        GiftConfigKey r7 = GiftConfigKey.KEY_GIFT_DIALOG_DIAMOND;
        DiamondConfig.d.getClass();
        DiamondConfig r8 = (DiamondConfig) r6.c(r7, DiamondConfig.a.a());
        if ((this.b.h instanceof h1) == false) goto L87;
        m r9 = (m) com.bytedance.android.livesdk.gift.util.b.a().d(m.class);
        T r10 = this.b.h;
        if (r10 == 0) goto L86;
        h1 r11 = (h1) r10;
        r9.g();
        goto L87
    L86:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.gift.model.IGift");
    L87:
        String r13 = String.valueOf(r5) + " " + r8.b;
        String r14 = String.valueOf(r5) + " " + r8.b;
    L89:
        this.l.setText(r13);
        this.l.setTextColor(s1.h(2131107498));
        this.l.requestLayout();
        k r15 = b4();
        if (r15 != null) goto L92;
    L93:
        AbsPanel<?> r16 = this.w;
        if (r16 == null) goto L97;
        r15 = r16.d();
    L96:
        k r17 = r15;
    L98:
        T r18 = this.b.h;
        if ((r18 instanceof h1) == false) goto L104;
        if (r18 == 0) goto L103;
        boolean r110 = j0.e((h1) r18);
    L105:
        d4().a(r17, r14, s1.h(2131107497), s1.B(2131922465), r110, 0, null);
        if (this.b.e() == null) goto L108;
        this.i.setVisibility(0);
        ImageLoader.bindImage(this.i, this.b.e(), s1.j(2131168730), s1.j(2131168729), new com.bytedance.android.livesdk.gift.platform.format.panel.viewholder.c(this));
    L109:
        T r20 = r19.h;
        if ((r20 instanceof h1) == false) goto L117;
        if (r20 == 0) goto L116;
        h1 r21 = (h1) r20;
        h2 r23 = rz1.a.b(Long.valueOf(r21.getId()));
        if (r23 == null) goto L117;
        ImageUtil.loadImage(this.c, r23.getImage(), 0);
        this.d.setText(r23.getName());
        jy0.b.d("CustomSpecialGiftEffects", "show gift id: " + r21.getId() + " relatedid: " + r23.getId());
        goto L117
    L116:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.gift.model.IGift");
    L117:
        k4(this.b.d);
        if ((r19 instanceof com.bytedance.android.livesdk.gift.platform.business.dialog.ui.panel.a) == false) goto L125;
        LiveGiftComboViewNew r24 = c4();
        if (r24 == null) goto L122;
        r24.setGiftId(r19.c());
    L122:
        LiveGiftComboViewNew r25 = c4();
        if (r25 == null) goto L138;
        r25.setPropId(-1);
    L138:
        LiveGiftComboViewNew r26 = c4();
        if (r26 == null) goto L141;
        r26.setPanel(r19);
    L141:
        LiveGiftComboViewNew r27 = c4();
        if (r27 == null) goto L144;
        r27.e();
    L144:
        IRoom r28 = vh6.c.b(com.bytedance.android.livesdk.revenue.service.room.b.class).getRoom();
        if (r28 == null) goto L149;
        IEpisodeExtraInfo r29 = r28.getEpisodeExtra();
        if (r29 == null) goto L149;
        IVSGiftPanel r30 = r29.getVSGiftPanel();
    L150:
        if (r30 == null) goto L152;
        k r31 = r30.getSelectedImage();
    L154:
        if (r31 != null) goto L156;
    L160:
        s r33 = d4();
        Drawable r34 = s1.m(2131249148);
        r33.getClass();
        Intrinsics.checkNotNullParameter(r34, "drawable");
        if (r33.a == false) goto L165;
        LiveSendGiftAnimationView r35 = r33.b;
        if (r35 == null) goto L166;
        r35.setPanelBackground(r34);
    L166:
        s r36 = d4();
        Drawable r37 = s1.m(2131250637);
        r36.getClass();
        Intrinsics.checkNotNullParameter(r37, "drawable");
        if (r36.a == false) goto L171;
        LiveSendGiftAnimationView r38 = r36.b;
        if (r38 == null) goto L172;
        r38.setPanelTopBackground(r37);
    L172:
        s r39 = d4();
        if (r39.a == true) goto L175;
    L179:
        r39.o = true;
    L180:
        this.D.b = r19.f();
        this.D.a = r19.d();
        r3.d(((RecyclerView.ViewHolder) this).itemView, r19.f() + ", " + this.l.getText(), r19.h(), true);
        return;
    L175:
        if (r39.o == false) goto L179;
        LiveSendGiftAnimationView r40 = r39.b;
        if (r40 == null) goto L180;
        r40.l.setVisibility(8);
        goto L180
    L171:
        r36.n = r37;
        goto L172
    L165:
        r33.m = r34;
        goto L166
    L156:
        if (r31.isValid() != true) goto L160;
        View r41 = ((RecyclerView.ViewHolder) this).itemView.findViewById(2131364437);
        if (r41 == null) goto L160;
        r41.setBackgroundResource(0);
        goto L160
    L152:
        r31 = null;
    L149:
        r30 = null;
        goto L150
    L125:
        T r43 = r19.h;
        if ((r43 instanceof l2) == false) goto L138;
        if (r43 == 0) goto L137;
        l2 r44 = (l2) r43;
        if (r44.getGift() == null) goto L138;
        LiveGiftComboViewNew r45 = c4();
        if (r45 == null) goto L133;
        r45.setGiftId(r44.getGift().getId());
    L133:
        LiveGiftComboViewNew r46 = c4();
        if (r46 == null) goto L138;
        r46.setPropId(r44.getId());
        goto L138
    L137:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.gift.model.IProp");
    L108:
        this.i.setVisibility(8);
        goto L109
    L103:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.gift.model.IGift");
    L104:
        r110 = false;
        goto L105
    L97:
        r17 = null;
        goto L98
    L92:
        if (r15.isValid() == true) goto L96;
    L88:
        r13 = s1.B(2131919120);
        r14 = r13;
        goto L89
    L70:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.gift.platform.business.dialog.ui.panel.AbsGiftPanel<*>");
    L71:
        T r47 = r4.h;
        if ((r47 instanceof h1) == false) goto L77;
        if (r47 == 0) goto L76;
        r5 = ((h1) r47).getDiamondCount();
        goto L79
    L76:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.gift.model.IGift");
    L77:
        r5 = 0;
        goto L79
    L64:
        this.j.setVisibility(8);
        goto L65
    L5:
        if (this.C == false) goto L46;
        if (r0 == 0) goto L45;
        h1 r48 = (h1) r0;
        long r111 = r48.getId();
        GiftContext r49 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r49 == null) goto L15;
        i<Map<Long, l>> r50 = r49.getGiftIdMapToInfo();
        if (r50 == null) goto L15;
        Map r51 = (Map) r50.getValue();
        if (r51 == null) goto L15;
        l r53 = (l) r51.get(Long.valueOf(r111));
        if (r53 == null) goto L15;
    L16:
        c2 r54 = r53.a;
        if (r54 != null) goto L19;
        this.n.setVisibility(8);
        this.k.setVisibility(8);
        goto L48
    L19:
        this.n.setPadding(s1.f(5.0f), 0, s1.f(5.0f), 0);
        if (r48.getGiftEndingTime() <= 0) goto L23;
        GiftLabelTextView r112 = this.n;
        long r113 = r48.getGiftEndingTime();
        u0 r114 = u0.g;
        this.r = r112.A(r113 * r114.a, r48.getNowTimeDiffSeconds() * r114.a, new FormatGiftDialogViewHolder$setCountDownTime$1(this));
        this.n.setVisibility(0);
    L34:
        if (TextUtils.isEmpty(r54.getBackgroundColor()) == true) goto L48;
        Drawable r55 = this.n.getBackground();
        if (r55 == null) goto L43;
        ((GradientDrawable) r55).setColor(Color.parseColor(r54.getBackgroundColor()));     // Catch: Exception -> L40
    L40:
        e = move-exception;
        e.printStackTrace();
        goto L48
    L43:
        throw new NullPointerException("null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
    L23:
        if (r54.getPrefixImage() == null) goto L30;
        if (r54.getPrefixImage() == null) goto L27;
        a1.v(this.k, r54.getPrefixImage(), 2131250965);
        this.n.setPadding(s1.f(19.0f), 0, s1.f(5.0f), 0);
        this.n.setVisibility(0);
        this.k.setVisibility(0);
    L28:
        i4(r54);
        goto L34
    L27:
        this.k.setVisibility(8);
        this.n.setVisibility(8);
        goto L28
    L30:
        if (r54.getDisplayText() == null) goto L32;
        i4(r54);
        goto L34
    L32:
        this.n.setVisibility(8);
    L15:
        r53 = new l(null);
        goto L16
    L45:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.gift.model.IGift");
    }

    public final void g4(View r6) {
        j4(false);
        if (com.bytedance.android.livesdk.gift.platform.format.panel.statemachine.helper.b.e() != null) goto L5;
    L13:
        f4();
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
        if ((com.bytedance.android.livesdk.gift.platform.format.panel.statemachine.helper.b.e() instanceof GiftStateMachineConfig.a.g) == false) goto L13;
        k4(AbsPanel.GiftPanelSelectType.IDLE);
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

    public final void i4(c2 r3) {
        CharSequence r4 = vh6.c.b(ur2.a.class).Lf(r3.getDisplayText(), BuildConfig.FLAVOR);
        if (TextUtils.isEmpty(r4) == false) goto L5;
        this.n.setVisibility(8);
        this.k.setVisibility(8);
        return;
    L5:
        this.n.setText(r4);
        this.n.setVisibility(0);
    }

    public final void j4(boolean r3) {
        T r0 = this.b.h;
        if ((r0 instanceof h1) == false) goto L8;
        if (r0 == 0) goto L7;
        boolean r1 = j0.e((h1) r0);
        d4().f(r3, r1);
    L9:
        this.b.e = r3;
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.gift.model.IGift");
    L8:
        d4().f(r3, false);
        goto L9
    }

    public final void k4(AbsPanel.GiftPanelSelectType r13) {
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
        int r14 = com.bytedance.android.livesdk.gift.platform.format.panel.viewholder.a.a[r13.ordinal()];
        if (r14 == 1) goto L64;
        if (r14 == 2) goto L49;
        if (r14 == 3) goto L33;
        if (r14 == 4) goto L28;
        d4().h(8);
        s r15 = d4();
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
        if (d4().c() == 0) goto L98;
        d4().h(0);
        this.o.setVisibility(8);
        LiveGiftComboViewNew r18 = c4();
        if (r18 == null) goto L99;
        r18.setVisibility(8);
        return;
    L99:
        return;
    L98:
        return;
    L33:
        if (d4().c() == 0) goto L42;
        d4().h(0);
        if (e4() == true) goto L42;
        if (this.h.isGiftUpdateOptimizeOpen() == false) goto L39;
        d4().i();
    L40:
        this.o.setVisibility(8);
        goto L42
    L39:
        d4().j();
    L42:
        if (this.y != 0) goto L101;
        w1 r19 = com.bytedance.android.livesdk.gift.platform.format.panel.statemachine.helper.b.d();
        if (r19 == null) goto L46;
        int r5 = r19.getPageType();
    L47:
        T r4 = this.b.h;
        int r6 = getLayoutPosition();
        DataCenter r7 = this.h.getDataCenter();
        IBaseUser r8 = com.bytedance.android.livesdk.gift.platform.format.panel.statemachine.helper.b.m();
        AbsPanel r110 = this.b;
        h.v(r4, r5, r6, r7, r8, r110.f, r110.c, U3());
        this.y++;
        return;
    L46:
        r5 = 1;
        goto L47
    L101:
        return;
    L49:
        if (d4().c() == 0) goto L54;
        d4().h(0);
        if (e4() == true) goto L54;
        d4().j();
        this.o.setVisibility(8);
    L54:
        if (this.b.h() == true) goto L56;
        return;
    L56:
        if (this.x == 0) goto L58;
        return;
    L58:
        if (this.y != 0) goto L105;
        w1 r111 = com.bytedance.android.livesdk.gift.platform.format.panel.statemachine.helper.b.d();
        if (r111 == null) goto L62;
        int r9 = r111.getPageType();
    L63:
        T r10 = this.b.h;
        int r11 = getLayoutPosition();
        DataCenter r20 = this.h.getDataCenter();
        IBaseUser r21 = com.bytedance.android.livesdk.gift.platform.format.panel.statemachine.helper.b.m();
        AbsPanel r112 = this.b;
        h.v(r10, r9, r11, r20, r21, r112.f, r112.c, U3());
        this.x++;
        return;
    L62:
        r9 = 1;
        goto L63
    L105:
        return;
    L64:
        AbsPanel r113 = this.b;
        r113.getClass();
        r113.d = AbsPanel.GiftPanelSelectType.JUST_SELECTED;
        if (d4().c() == 0) goto L92;
        d4().h(0);
        boolean r114 = e4();
        if (r114 == true) goto L88;
        s r3 = d4();
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
        j4(this.b.e);
        LiveGiftComboViewNew r28 = c4();
        if (r28 == null) goto L91;
        r28.setVisibility(8);
    L91:
        com.bytedance.android.livesdk.gift.util.b.f(new GiftStateMachineConfig.Event.g(this.b));
        boolean r29 = r114;
    L93:
        AbsPanel r115 = this.b;
        if (r115 == null) goto L107;
        int r30 = com.bytedance.android.live.revenue.core.util.i.a;
        q r31 = com.bytedance.android.scope.m.b;
        T r33 = r115.h;
        int r34 = getLayoutPosition();
        DataCenter r35 = this.h.getDataCenter();
        IBaseUser r36 = com.bytedance.android.livesdk.gift.platform.format.panel.statemachine.helper.b.m();
        AbsPanel r116 = this.b;
        h.E(null, r33, r34, r35, r36, r29, r116.f, r116.c, U3());
        return;
    L107:
        return;
    L92:
        r29 = false;
        goto L93
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

    public FormatGiftDialogViewHolder(final View r3, GiftViewModelManager r4, Context r5) {
        Intrinsics.checkNotNullParameter(r3, "itemView");
        Intrinsics.checkNotNullParameter(r4, "viewModel");
        super(r3);
        this.E = r5;
        this.f = 500;
        this.g = 20;
        this.h = r4;
        this.i = r3.findViewById(2131377795);
        this.j = r3.findViewById(2131369000);
        this.k = r3.findViewById(2131363715);
        this.l = (TextView) r3.findViewById(2131368992);
        this.m = LazyKt.lazy(new FormatGiftDialogViewHolder$mSendGiftView$2(r3));
        this.n = (GiftLabelTextView) r3.findViewById(2131373734);
        this.o = r3.findViewById(2131367792);
        GiftIconMaskView r6 = (GiftIconMaskView) r3.findViewById(2131373731);
        this.p = r6;
        this.q = r3.findViewById(2131373739);
        this.r = true;
        this.u = true;
        this.A = new CompositeDisposable();
        this.B = true;
        this.C = true;
        this.D = new n(null, null, 7);
        r3.setOnTouchListener(new a(this));
        this.s = UIUtils.dip2Px(r3.getContext(), 13.0f);
        this.z = new rz1.b(r6, this.c);
    }

    public final void Z3(int r19, View r20, int r21) {
        AbsPanel<?> r5 = null;
        if (r19 == 0) goto L62;
        if (r19 != 1) goto L6;
        g4(r20);
        return;
    L6:
        if (r19 == 2) goto L12;
        if (r19 == 3) goto L10;
        return;
    L10:
        if (com.bytedance.android.livesdk.gift.platform.business.dialog.v2.d.a(com.bytedance.android.livesdk.gift.platform.format.panel.statemachine.helper.b.m().getIdString(), null) == false) goto L83;
        ToastUtil.a(2131915261, 0);
        m02.a.a();
        return;
    L83:
        return;
    L12:
        j4(false);
        if (com.bytedance.android.livesdk.gift.platform.business.dialog.v2.d.a(com.bytedance.android.livesdk.gift.platform.format.panel.statemachine.helper.b.m().getIdString(), null) == false) goto L15;
        ToastUtil.a(2131915261, 0);
        m02.a.a();
        return;
    L15:
        Context r1 = this.E;
        if (r1 == null) goto L18;
        Object r2 = r1.getSystemService("vibrator");
    L19:
        if (r2 == null) goto L59;
        ((Vibrator) r2).vibrate(50);
        if (this.h.isPreCheckSendGift(com.bytedance.android.livesdk.gift.platform.format.panel.statemachine.helper.b.m()) == false) goto L86;
        AbsPanel<?> r11 = com.bytedance.android.livesdk.gift.platform.format.panel.statemachine.helper.b.b();
        if (r11 == null) goto L57;
        T r3 = r11.h;
        if ((r3 instanceof h1) == false) goto L49;
        if (r3 == 0) goto L48;
        h1 r4 = (h1) r3;
        h2 r6 = rz1.a.b(Long.valueOf(r4.getId()));
        if (r6 == null) goto L39;
        jy0.b.d("CustomSpecialGiftEffects", "send gift id: " + r4.getId() + " relatedid: " + r6.getId());
        FormatGiftPanelDialogViewModel r7 = com.bytedance.android.livesdk.gift.platform.format.panel.statemachine.helper.b.f();
        if (r7 == null) goto L32;
        r5 = ((GiftStateMachineConfig.a) r7.f.b()).b();
    L32:
        AbsPanel<?> r13 = r5;
        if (r13 == null) goto L57;
        IBaseUser r14 = com.bytedance.android.livesdk.gift.platform.format.panel.statemachine.helper.b.m();
        if (r21 != 1) goto L37;
        boolean r16 = true;
    L38:
        com.bytedance.android.livesdk.gift.util.b.f(new GiftStateMachineConfig.Event.q(r13, 1, 4, r14, 0, r16, this.D));
        goto L57
    L37:
        r16 = false;
        goto L38
    L39:
        IBaseUser r15 = com.bytedance.android.livesdk.gift.platform.format.panel.statemachine.helper.b.m();
        if ((com.bytedance.android.livesdk.gift.platform.format.panel.statemachine.helper.b.e() instanceof GiftStateMachineConfig.a.C0022a) == false) goto L43;
        GiftStateMachineConfig.a.C0022a r8 = (GiftStateMachineConfig.a.C0022a) com.bytedance.android.livesdk.gift.platform.format.panel.statemachine.helper.b.e();
    L43:
        if (r21 != 1) goto L45;
        boolean r17 = true;
    L46:
        com.bytedance.android.livesdk.gift.util.b.f(new GiftStateMachineConfig.Event.q(r11, 1, 4, r15, 0, r17, this.D));
        goto L57
    L45:
        r17 = false;
        goto L46
    L48:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.gift.model.IGift");
    L49:
        IBaseUser r18 = com.bytedance.android.livesdk.gift.platform.format.panel.statemachine.helper.b.m();
        if ((com.bytedance.android.livesdk.gift.platform.format.panel.statemachine.helper.b.e() instanceof GiftStateMachineConfig.a.C0022a) == false) goto L53;
        GiftStateMachineConfig.a.C0022a r9 = (GiftStateMachineConfig.a.C0022a) com.bytedance.android.livesdk.gift.platform.format.panel.statemachine.helper.b.e();
    L53:
        if (r21 != 1) goto L55;
        boolean r110 = true;
    L56:
        com.bytedance.android.livesdk.gift.util.b.f(new GiftStateMachineConfig.Event.q(r11, 1, 4, r18, 0, r110, this.D));
        goto L57
    L55:
        r110 = false;
    L57:
        com.bytedance.android.livesdk.gift.util.b.f(new GiftStateMachineConfig.Event.h(0, 7));
        h.l();
        return;
    L86:
        return;
    L59:
        throw new NullPointerException("null cannot be cast to non-null type android.os.Vibrator");
    L18:
        r2 = null;
        goto L19
    L62:
        if (this.B == false) goto L91;
        AbsPanel r10 = this.b;
        if ((r10 instanceof pz1.a) == false) goto L72;
        if (r10 == null) goto L71;
        if (((pz1.a) r10).m() == false) goto L72;
        boolean r23 = true;
    L73:
        if (r23 == false) goto L78;
        j4(true);
        ay1.b.z();
        ay1.b.d0.setValue(null, ay1.b.a[67], Boolean.TRUE);
        f4();
        com.bytedance.android.livesdk.gift.util.b.f(new GiftStateMachineConfig.Event.a0(this.b));
        h.W(this.b.c(), getLayoutPosition());
        String r24 = h.a;
        long r25 = this.b.c();
        FormatGiftPanelDialogViewModel r26 = com.bytedance.android.livesdk.gift.platform.format.panel.statemachine.helper.b.f();
        if (r26 == null) goto L77;
        r5 = r26.g;
    L77:
        h.B(r25, "bunching_panel", r5);
        return;
    L78:
        int r27 = ToastUtil.a;
        ToastUtil.b(nz1.a.t(), 0);
        j4(false);
        float r111 = 20;
        ObjectAnimator r28 = ObjectAnimator.ofPropertyValuesHolder(((RecyclerView.ViewHolder) this).itemView, new PropertyValuesHolder[]{PropertyValuesHolder.ofKeyframe(View.TRANSLATION_X, new Keyframe[]{Keyframe.ofFloat(0.0f, 0.0f), Keyframe.ofFloat(0.1f, -20.0f), Keyframe.ofFloat(0.26f, r111), Keyframe.ofFloat(0.42f, -20.0f), Keyframe.ofFloat(0.58f, r111), Keyframe.ofFloat(0.74f, -20.0f), Keyframe.ofFloat(0.9f, r111), Keyframe.ofFloat(1.0f, 0.0f)})}).setDuration(500);
        r28.addListener(new com.bytedance.android.livesdk.gift.platform.format.panel.viewholder.d(this, r20));
        r28.start();
        String r29 = h.a;
        long r30 = this.b.c();
        FormatGiftPanelDialogViewModel r31 = com.bytedance.android.livesdk.gift.platform.format.panel.statemachine.helper.b.f();
        if (r31 == null) goto L81;
        r5 = r31.g;
    L81:
        h.B(r30, "toast", r5);
        return;
    L71:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.gift.platform.business.dialog.ui.panel.AbsGiftPanel<*>");
    L72:
        r23 = false;
        goto L73
    }

    public final boolean h4(View r8, MotionEvent r9, int r10, int r11, int r13) {
        if (r9 != null) goto L6;
        return false;
    L6:
        if (r9.getAction() != 0) goto L13;
        if (this.h.isGiftUpdateOptimizeOpen() == false) goto L10;
        PropertyValuesHolder r14 = PropertyValuesHolder.ofFloat("scaleX", new float[]{1.0f, 0.92f});
        PropertyValuesHolder r15 = PropertyValuesHolder.ofFloat("scaleY", new float[]{1.0f, 0.92f});
        Interpolator r1 = PathInterpolatorCompat.create(0.42f, 0.0f, 0.58f, 1.0f);
        ObjectAnimator r16 = ObjectAnimator.ofPropertyValuesHolder(this.c, new PropertyValuesHolder[]{r14, r15});
        r16.setInterpolator(r1);
        r16.setDuration(100);
        r16.start();
    L10:
        this.u = false;
        this.t = 0;
        com.bytedance.android.live.core.utils.rxutils.j.a r17 = com.bytedance.android.live.core.utils.rxutils.j.a;
        long r18 = this.g;
        com.bytedance.android.live.core.utils.rxutils.j.a(r18, r18, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new d(this, r11, r8, r13));
        return true;
    L13:
        if (this.u == false) goto L16;
        return false;
    L16:
        if (r9.getAction() != 2) goto L30;
        if (this.t < this.f) goto L30;
        float r19 = r9.getX();
        float r2 = r9.getY();
        float r3 = 0;
        if (r19 >= r3) goto L22;
    L27:
        this.u = true;
        a4();
        return true;
    L22:
        if (r19 > r8.getWidth()) goto L27;
        if (r2 < r3) goto L27;
        if (r2 > r8.getHeight()) goto L27;
    L30:
        if (r9.getAction() == 1) goto L34;
        if (r9.getAction() == 3) goto L34;
    L39:
        return false;
    L34:
        if (this.t < this.f) goto L36;
        return true;
    L36:
        if (r9.getAction() == 3) goto L38;
        Z3(r10, r8, r13);
    L38:
        this.u = true;
        a4();
        goto L39
    }
}
