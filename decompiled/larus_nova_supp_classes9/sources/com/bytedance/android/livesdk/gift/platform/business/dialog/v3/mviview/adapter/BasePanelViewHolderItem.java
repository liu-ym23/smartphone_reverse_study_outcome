package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.mviview.adapter;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.Spannable;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.bytedance.android.anya.BaseMVIListItem;
import com.bytedance.android.anya.MVIState;
import com.bytedance.android.anya.r0;
import com.bytedance.android.live.base.model.message.a5;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.revenue.common.ToastUtil;
import com.bytedance.android.live.revenue.common.u0;
import com.bytedance.android.livesdk.chatroom.utils.a1;
import com.bytedance.android.livesdk.gift.model.c2;
import com.bytedance.android.livesdk.gift.model.e2;
import com.bytedance.android.livesdk.gift.model.h1;
import com.bytedance.android.livesdk.gift.model.j2;
import com.bytedance.android.livesdk.gift.platform.business.config.DiamondConfig;
import com.bytedance.android.livesdk.gift.platform.business.config.GiftConfigKey;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.GiftLabelTextView;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.LiveSendGiftAnimationView;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.m0;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.model.ImageType;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.preload.p000new.GiftPreloadManager;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.preload.p000new.GiftPreloadResType;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.BanSendGiftSelfTipsEffect;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.CardStatus;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftAction;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.ItemListData;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.ItemStatus;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.OnGiftAnimShakeFinish;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.OnGiftExposureAnimShow;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.SelectedStatus;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.ShakeGiftIcon;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.ShowAISceneLabel;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.ShowGiftExposureAnim;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.ShowSweepAnim;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.VisualStatus;
import com.bytedance.android.livesdk.gift.platform.business.normal.view.v2.GiftIconMaskView;
import com.bytedance.android.livesdk.gift.platform.core.GiftContext;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.GiftPanelMonitorService;
import com.bytedance.android.livesdk.gift.util.GiftImageLoader;
import com.bytedance.android.livesdk.r3;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.fresco.animation.drawable.AnimatedDrawable2;
import com.facebook.imagepipeline.image.ImageInfo;
import com.larus.apm.impl.protector.RunnableProtector;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public abstract class BasePanelViewHolderItem extends BaseMVIListItem<ItemListData, GiftAction> {
    public static final Handler d0 = null;
    public final View A;
    public final GiftIconMaskView B;
    public final View C;
    public final HSImageView D;
    public int E;
    public String F;
    public Long G;
    public String H;
    public ItemStatus I;
    public vz1.a J;
    public rz1.b K;
    public m0 L;
    public int M;
    public int N;
    public Boolean O;
    public final Lazy P;
    public final com.bytedance.android.livesdk.gift.platform.business.dialog.v3.c Q;
    public boolean R;
    public boolean S;
    public final com.bytedance.android.livesdk.gift.platform.core.model.n T;
    public py.k U;
    public String V;
    public py.k W;
    public final GiftContext X;
    public AnimatorSet Y;
    public final d Z;
    public final int a0;
    public final int b0;
    public final boolean c0;
    public final float l;
    public final float m;
    public final int n;
    public final int o;
    public final Lazy p;
    public final float q;
    public final HSImageView r;
    public final HSImageView s;
    public final HSImageView t;
    public final TextView u;
    public final HSImageView v;
    public final HSImageView w;
    public final TextView x;
    public final Lazy y;
    public final GiftLabelTextView z;

    public static final class a {
    }

    public static final class b extends o12.b {
        public final /* synthetic */ BasePanelViewHolderItem a;
        public final /* synthetic */ com.bytedance.android.anya.a0 b;

        @Override // o12.b, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r8) {
            Intrinsics.checkNotNullParameter(r8, "animation");
            this.a.o(new OnGiftAnimShakeFinish(((ShakeGiftIcon) this.b).getPagerPosition(), ((ShakeGiftIcon) this.b).getPosition(), ((ShakeGiftIcon) this.b).getCounterPosition(), ((ShakeGiftIcon) this.b).getTopicPagerPosition(), this.a.c0));
        }

        public b(BasePanelViewHolderItem r1, com.bytedance.android.anya.a0 r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public static final class c extends BaseControllerListener<ImageInfo> {
        public final /* synthetic */ BasePanelViewHolderItem a;
        public final /* synthetic */ ShowGiftExposureAnim b;

        public c(BasePanelViewHolderItem r1, ShowGiftExposureAnim r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void onFailure(String r1, Throwable r2) {
            super.onFailure(r1, r2);
            HSImageView r3 = this.a.w;
            if (r3 == null) goto L5;
            r3.setController(null);
        L5:
            HSImageView r4 = this.a.w;
            if (r4 == null) goto L9;
            r4.setVisibility(8);
            return;
        }

        public final void onFinalImageSet(String r1, Object r2, Animatable r3) {
            ImageInfo r4 = (ImageInfo) r2;
            if ((r3 instanceof AnimatedDrawable2) == true) goto L5;
            r3 = null;
        L5:
            AnimatedDrawable2 r5 = (AnimatedDrawable2) r3;
            if (r5 == null) goto L9;
            r5.setAnimationListener(new com.bytedance.android.livesdk.gift.platform.business.dialog.v3.mviview.adapter.c(this));
            com.bytedance.android.live.core.utils.fresco.c.c(r5);
            r5.start();
            return;
        }
    }

    public static final class d extends AnimatorListenerAdapter {
        public final /* synthetic */ BasePanelViewHolderItem a;

        public d(BasePanelViewHolderItem r1) {
            this.a = r1;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
            HSImageView r3 = this.a.s().b();
            if (r3 == null) goto L10;
            DraweeController r4 = r3.getController();
            if (r4 == null) goto L11;
            Animatable r5 = r4.getAnimatable();
            if (r5 == null) goto L12;
            r5.start();
            return;
        L12:
            return;
        L11:
            return;
        }
    }

    public static final class e implements View.OnTouchListener {
        public final /* synthetic */ BasePanelViewHolderItem a;

        public e(BasePanelViewHolderItem r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View r2, MotionEvent r3) {
            Intrinsics.checkNotNullParameter(r2, "v");
            Intrinsics.checkNotNullParameter(r3, "event");
            return this.a.y(r2, r3);
        }
    }

    public static final class f implements Runnable {
        public final /* synthetic */ BasePanelViewHolderItem a;

        public f(BasePanelViewHolderItem r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.X.getGiftPanelFirstRenderTs().setValue(Long.valueOf(System.currentTimeMillis()));     // Catch: Throwable -> L4
            jy0.b.f("ttlive_gift_panel_metrics", "panel content first render done", null, 4);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public final qz1.s s() {
        return (qz1.s) this.y.getValue();
    }

    public abstract void v(com.bytedance.android.anya.k<ItemListData> r1, ItemListData r2);

    static {
        d0 = new Handler(Looper.getMainLooper());
    }

    public final void g() {
        this.K = new rz1.b(this.B, this.v);
        rz1.b r1 = this.K;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mGiftImageMaskHelper");
    L5:
        this.L = new m0(r1, this.B);
        z();
        ((BaseMVIListItem) this).j.setOnTouchListener(new e(this));
        if (((Number) ((BaseMVIListItem) this).h.invoke()).intValue() != 0) goto L13;
        GiftContext r0 = this.X;
        if (r0 != null) goto L10;
        return;
    L10:
        if (((Boolean) r0.getFirstViewHolderAttached().getValue()).booleanValue() == true) goto L15;
        this.X.getFirstViewHolderAttached().setValue(Boolean.TRUE);
        d0.postAtFrontOfQueue(new f(this));
        return;
    L15:
        return;
    }

    public final void z() {
        HSImageView r0 = this.w;
        if (r0 == null) goto L7;
        DraweeController r1 = r0.getController();
        if (r1 == null) goto L7;
        Animatable r2 = r1.getAnimatable();
    L9:
        if ((r2 instanceof AnimatedDrawable2) == true) goto L11;
        r2 = null;
    L11:
        AnimatedDrawable2 r3 = (AnimatedDrawable2) r2;
        if (r3 == null) goto L14;
        r3.setAnimationListener(null);
    L14:
        HSImageView r4 = this.w;
        if (r4 == null) goto L21;
        DraweeController r5 = r4.getController();
        if (r5 == null) goto L21;
        Animatable r6 = r5.getAnimatable();
        if (r6 == null) goto L21;
        r6.stop();
    L21:
        HSImageView r7 = this.w;
        if (r7 == null) goto L24;
        r7.setController(null);
    L24:
        HSImageView r8 = this.w;
        if (r8 == null) goto L27;
        r8.setVisibility(8);
    L27:
        HSImageView r9 = this.v;
        if (r9 == null) goto L31;
        r9.setVisibility(0);
        return;
    L31:
        return;
    L7:
        r2 = null;
        goto L9
    }

    public final void i() {
        z();
        GiftIconMaskView r0 = this.B;
        if (r0 == null) goto L5;
        r0.setVisibility(8);
    L5:
        AnimatorSet r1 = this.Y;
        if (r1 == null) goto L8;
        r1.cancel();
    L8:
        this.D.setController(null);
        this.D.setVisibility(8);
    }

    public static final void q(BasePanelViewHolderItem r11) {
        AnimatorSet r0 = r11.Y;
        if (r0 != null) goto L5;
    L7:
        AnimatorSet r1 = new AnimatorSet();
        ObjectAnimator r2 = ObjectAnimator.ofFloat(r11.D, "scaleX", new float[]{0.0f, 1.0f});
        ObjectAnimator r4 = ObjectAnimator.ofFloat(r11.D, "scaleY", new float[]{0.0f, 1.0f});
        r1.setDuration(500);
        r1.playTogether(new Animator[]{r2, r4});
        AnimatorSet r3 = new AnimatorSet();
        r3.playTogether(new Animator[]{ObjectAnimator.ofFloat(r11.D, "scaleX", new float[]{1.0f, 0.0f}), ObjectAnimator.ofFloat(r11.D, "scaleY", new float[]{1.0f, 0.0f})});
        r3.setDuration(500);
        r3.setStartDelay(1200);
        AnimatorSet r5 = new AnimatorSet();
        r11.Y = r5;
        r5.playSequentially(new Animator[]{r1, r3});
        AnimatorSet r13 = r11.Y;
        if (r13 == null) goto L11;
        r13.start();
        return;
    L11:
        return;
    L5:
        if (r0.isRunning() != true) goto L7;
    }

    public final void A(c2 r3) {
        CharSequence r4 = vh6.c.b(ur2.a.class).Lf(r3.getDisplayText(), BuildConfig.FLAVOR);
        if (TextUtils.isEmpty(r4) == false) goto L5;
        this.z.setVisibility(8);
        this.t.setVisibility(8);
        return;
    L5:
        this.z.setText(r4);
        this.z.setVisibility(0);
    }

    public final void C(boolean r4) {
        StringBuilder r0 = new StringBuilder();
        r0.append(this.x.getText().toString());
        r0.append(" ");
        r0.append(this.u.getText().toString());
        if (r4 == false) goto L5;
        r0.append(" 双击赠送");
    L5:
        r3.d(((BaseMVIListItem) this).j, r0.toString(), r4, true);
        if (r4 == false) goto L9;
        r3.p(((BaseMVIListItem) this).j);
        return;
    }

    public final void D(String r3) {
        if (r3 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L11;
        this.u.setVisibility(8);
        return;
    L11:
        this.u.setVisibility(0);
        this.u.setText(r3);
        this.u.setTextColor(com.bytedance.android.livesdk.gift.platform.business.dialog.v3.preload.e.a());
        this.u.requestLayout();
        return;
    L5:
        if (r3.length() == 0) goto L8;
        r1 = false;
        goto L9
    }

    public boolean d(com.bytedance.android.anya.a0 r15) {
        Intrinsics.checkNotNullParameter(r15, "e");
        int r2 = 0;
        if ((r15 instanceof ShakeGiftIcon) == false) goto L17;
        ShakeGiftIcon r0 = (ShakeGiftIcon) r15;
        if (r0.getPosition() != p()) goto L11;
        if (r0.getPagerPosition() != this.a0) goto L11;
        if (r0.getCounterPosition() != (-1)) goto L11;
    L14:
        B(r0.getToastText(), new b(this, r15));
        return true;
    L11:
        if (this.c0 == true) goto L13;
    L67:
        return false;
    L13:
        if (r0.getPosition() != p()) goto L67;
    L17:
        if ((r15 instanceof BanSendGiftSelfTipsEffect) == false) goto L21;
        ToastUtil.a(2131915261, 0);
        m02.a.a();
        return true;
    L21:
        if ((r15 instanceof ShowSweepAnim) == false) goto L41;
        ShowSweepAnim r16 = (ShowSweepAnim) r15;
        if (r16.getPosition() != p()) goto L67;
        if (r16.getPagerPosition() != this.a0) goto L67;
        m0 r17 = this.L;
        if (r17 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("mSweepHelper");
    L29:
        vz1.e r1 = r17.a;
        if (r1 == null) goto L39;
        String r3 = ay1.b.l().get(String.valueOf(r1.a.getId()));
        if (r3 == null) goto L34;
        r2 = CastIntegerProtector.parseInt(r3);
    L34:
        HashMap<String, String> r4 = ay1.b.l();
        vz1.e r5 = r17.a;
        if (r5 == null) goto L37;
        Long r6 = Long.valueOf(r5.b);
    L38:
        r4.put(String.valueOf(r6), String.valueOf(r2 + 1));
        Intrinsics.checkNotNullParameter(r4, "<set-?>");
        ay1.b.q.setValue(null, ay1.b.a[19], r4);
        r1.a.setHasSweepLight(true);
        r17.a(null);
        goto L39
    L37:
        r6 = null;
    L39:
        return true;
    L41:
        if ((r15 instanceof ShowGiftExposureAnim) == false) goto L53;
        ShowGiftExposureAnim r18 = (ShowGiftExposureAnim) r15;
        if (r18.getPosition() != p()) goto L67;
        if (r18.getPagerPosition() != this.a0) goto L67;
        if (r18.getCounterPosition() != (-1)) goto L67;
        if (this.b0 != r18.getTopicPagerPosition()) goto L67;
        u(r18);
        return true;
    L53:
        if ((r15 instanceof ShowAISceneLabel) == false) goto L67;
        ShowAISceneLabel r19 = (ShowAISceneLabel) r15;
        if (r19.getPosition() != p()) goto L67;
        if (r19.getPagerPosition() != this.a0) goto L67;
        py.k r7 = r19.getShowImage();
        if (r7 != null) goto L61;
    L66:
        this.D.setVisibility(8);
        goto L67
    L61:
        if (this.t.getVisibility() == 0) goto L66;
        if (this.z.getVisibility() == 0) goto L66;
        GiftImageLoader.b(GiftImageLoader.k, this.D, r7, 0, com.bytedance.android.livesdk.gift.platform.business.dialog.v3.preload.e.b(2131168758), com.bytedance.android.livesdk.gift.platform.business.dialog.v3.preload.e.b(2131168757), null, new BasePanelViewHolderItem$showAiSceneLabel$1(this), null, null, 8012);
        goto L67
    }

    public String t(vz1.e r3) {
        Intrinsics.checkNotNullParameter(r3, "dialogIconModel");
        String r0 = r3.l;
        if (r0 == null) goto L13;
        if (r0.length() <= 0) goto L7;
        boolean r1 = true;
    L8:
        if (r1 == true) goto L11;
        r0 = null;
    L11:
        if (r0 == null) goto L13;
        return r0;
    L7:
        r1 = false;
    L13:
        return r3.p;
    }

    public final void u(ShowGiftExposureAnim r6) {
        Intrinsics.checkNotNullParameter(r6, "model");
        if (r6.getAnim() != null) goto L5;
        return;
    L5:
        HSImageView r0 = this.w;
        String r1 = null;
        if (r0 == null) goto L8;
        Integer r2 = Integer.valueOf(r0.getVisibility());
    L10:
        if (r2.intValue() != 0) goto L12;
        return;
    L12:
        List r3 = r6.getAnim().getUrls();
        if (r3 != null) goto L15;
    L23:
        c r4 = new c(this, r6);
        HSImageView r7 = this.w;
        if (r7 == null) goto L26;
        r7.setVisibility(0);
    L26:
        HSImageView r8 = this.w;
        if (r8 == null) goto L35;
        Context r9 = r8.getContext();
        if (r9 == null) goto L35;
        Resources r10 = r9.getResources();
        if (r10 == null) goto L35;
        HSImageView r5 = this.w;
        if (r5 == null) goto L35;
        r5.setHierarchy(new GenericDraweeHierarchyBuilder(r10).setFadeDuration(0).build());
    L35:
        HSImageView r11 = this.w;
        if (r11 == null) goto L39;
        r11.setController(Fresco.newDraweeControllerBuilder().setUri(r1).setControllerListener(r4).setAutoPlayAnimations(false).build());
        return;
    L39:
        return;
    L15:
        if (r3.size() <= 0) goto L17;
        boolean r13 = true;
    L18:
        if (r13 == true) goto L21;
        r3 = null;
    L21:
        if (r3 == null) goto L23;
        r1 = (String) CollectionsKt.first(r3);
        goto L23
    L17:
        r13 = false;
        goto L18
    L8:
        r2 = null;
        goto L10
    }

    public void w(py.k r2) {
        this.s.setVisibility(8);
    }

    public final void B(String r7, o12.b r8) {
        Intrinsics.checkNotNullParameter(r7, "toast");
        Intrinsics.checkNotNullParameter(r8, "animationListener");
        ToastUtil.b(r7, 0);
        ObjectAnimator r9 = ObjectAnimator.ofPropertyValuesHolder(((BaseMVIListItem) this).j, new PropertyValuesHolder[]{PropertyValuesHolder.ofKeyframe(View.TRANSLATION_X, new Keyframe[]{Keyframe.ofFloat(0.0f, 0.0f), Keyframe.ofFloat(0.1f, -this.n), Keyframe.ofFloat(0.26f, this.n), Keyframe.ofFloat(0.42f, -this.n), Keyframe.ofFloat(0.58f, this.n), Keyframe.ofFloat(0.74f, -this.n), Keyframe.ofFloat(0.9f, this.n), Keyframe.ofFloat(1.0f, 0.0f)})}).setDuration(500);
        r9.addListener(r8);
        r9.start();
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
    public final void b(com.bytedance.android.anya.k r37, MVIState r38) {
        ItemListData r2 = (ItemListData) r38;
        Intrinsics.checkNotNullParameter(r37, "$this$handleDiff");
        Intrinsics.checkNotNullParameter(r2, "state");
        r0<ItemListData, vz1.e> r3 = r2.getItemData();
        Object r4 = r37.c.a(r3);
        if (r4 == null) goto L292;
        r37.b.a.invoke(r3);
        vz1.e r5 = (vz1.e) r4;
        m0 r6 = this.L;
        if (r6 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("mSweepHelper");
    L7:
        r6.a = r5;
        this.A.setAlpha(this.m);
        vz1.a r7 = r5.u;
        this.J = r7;
        int r15 = r7.a;
        CardStatus r16 = CardStatus.INSTANCE;
        if ((r15 & r16.getLOCK()) != r16.getLOCK()) goto L16;
        qz1.s r8 = s();
        String r9 = r7.b;
        if (r8.a == false) goto L14;
        LiveSendGiftAnimationView r17 = r8.b;
        if (r17 == null) goto L14;
        r17.setLockText(r9);
    L14:
        r8.d = r9;
    L31:
        h1 r10 = r5.a;
        boolean r11 = r5.e;
        vz1.f r18 = r5.s;
        if (r11 == true) goto L53;
        if (r18 == null) goto L41;
        py.k r13 = r18.a;
        if (r13 == null) goto L41;
        if (r13.isValid() == false) goto L40;
        GiftImageLoader.b(GiftImageLoader.k, this.D, r13, 0, com.bytedance.android.livesdk.gift.platform.business.dialog.v3.preload.e.b(2131168758), com.bytedance.android.livesdk.gift.platform.business.dialog.v3.preload.e.b(2131168757), null, new com.bytedance.android.livesdk.gift.platform.business.dialog.v3.mviview.adapter.d(this), null, null, 8012);
        this.z.setVisibility(8);
        this.t.setVisibility(8);
        goto L53
    L40:
        this.D.setVisibility(8);
    L41:
        long r19 = r10.getId();
        GiftContext r14 = this.X;
        if (r14 == null) goto L49;
        com.bytedance.live.datacontext.i<Map<Long, com.bytedance.android.livesdk.gift.platform.core.l>> r20 = r14.getGiftIdMapToInfo();
        if (r20 == null) goto L49;
        Map r21 = (Map) r20.getValue();
        if (r21 == null) goto L49;
        com.bytedance.android.livesdk.gift.platform.core.l r23 = (com.bytedance.android.livesdk.gift.platform.core.l) r21.get(Long.valueOf(r19));
        if (r23 == null) goto L49;
    L50:
        c2 r24 = r23.a;
        if (r24 != null) goto L54;
        this.z.setVisibility(8);
        this.t.setVisibility(8);
        goto L53
    L54:
        this.z.setPadding(s1.f(5.0f), 0, s1.f(5.0f), 0);
        if (r10.getGiftEndingTime() > 0) goto L57;
        Intrinsics.checkNotNullParameter(r24, "$this$mainGiftTip");
        j2 r25 = (j2) r24.castToOrNull(j2.class);
        if (r25 == null) goto L63;
        long r26 = r25.getDeadLineTime();
        long r27 = 0;
    L65:
        if (r26 > r27) goto L67;
        String r28 = "controller";
        if (r24.getPrefixImage() == null) goto L123;
        com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.f r29 = com.bytedance.android.livesdk.gift.platform.core.utils.s.c();
        if (r29 == null) goto L102;
        IBaseUser r30 = r29.a;
    L104:
        if (com.bytedance.android.livesdk.gift.platform.business.dialog.v2.d.l(r30) == false) goto L121;
        i12.e r31 = i12.o.b();
        if (r31 == null) goto L108;
        Object r33 = com.bytedance.android.scope.m.e.d(r31, com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.a.class);
    L109:
        com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.a r34 = (com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.a) r33;
        if (r34 == null) goto L114;
        if (r34.j() == true) goto L121;
    L114:
        if (r10.getBizType() == 2) goto L120;
        if (r24.getPrefixImage() == null) goto L118;
        a1.v(this.t, r24.getPrefixImage(), 2131250965);
        this.z.setPadding(s1.f(19.0f), 0, s1.f(5.0f), 0);
        this.z.setVisibility(0);
        this.t.setVisibility(0);
        goto L120
    L118:
        this.t.setVisibility(8);
        this.z.setVisibility(8);
    L120:
        A(r24);
    L127:
        if (TextUtils.isEmpty(r24.getBackgroundColor()) == true) goto L133;
        Drawable r35 = this.z.getBackground();
        if (r35 == null) goto L132;
        ((GradientDrawable) r35).setColor(ColorProtector.parseColor(r24.getBackgroundColor()));
        goto L133
    L132:
        throw new NullPointerException("null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
    L133:
        w(r5.g.a);
        D(r(r5.m, r5.k, r5.r));
        py.k r36 = r5.a.getDynamicImgForSelected();
        if (r36 != null) goto L136;
        r36 = (py.k) vh7.f.c(py.k.class);
    L136:
        Pair<Integer, vz1.i> r39 = r5.c;
        if (r36.isValid() == true) goto L139;
    L147:
        String r210 = r28;
        this.R = false;
    L148:
        String r40 = t(r5);
        this.x.setText(r40);
        this.x.requestLayout();
        this.T.b = r40;
        py.k r41 = r5.o;
        Long r43 = Long.valueOf(r5.b);
        h1 r44 = r5.a;
        GiftImageLoader r211 = GiftImageLoader.k;
        r211.getClass();
        int r45 = GiftImageLoader.j;
        if (r45 > (-1)) goto L153;
        r45 = ((Number) com.bytedance.android.livesdk.gift.platform.core.h.U.getValue(null, com.bytedance.android.livesdk.gift.platform.core.h.a[45])).intValue();
        GiftImageLoader.j = r45;
    L153:
        if (r45 == 3) goto L160;
        int r46 = GiftImageLoader.j;
        if (r46 > (-1)) goto L159;
        r46 = ((Number) com.bytedance.android.livesdk.gift.platform.core.h.U.getValue(null, com.bytedance.android.livesdk.gift.platform.core.h.a[45])).intValue();
        GiftImageLoader.j = r46;
    L159:
        if (r46 == 1) goto L160;
    L167:
        if (r41 == null) goto L169;
        String r47 = r41.getUri();
    L170:
        this.V = r47;
        this.U = r41;
        GenericDraweeHierarchy r48 = this.v.getHierarchy();
        int r49 = ((Number) com.bytedance.android.livesdk.gift.util.b.a().c(GiftConfigKey.KEY_GIFT_DEFAULT_ICON, 2131250964)).intValue();
        r48.setPlaceholderImage(r49);
        r48.setFailureImage(r49);
        if (((Boolean) nz1.a.m0.getValue(null, nz1.a.a[63])).booleanValue() == false) goto L173;
        com.bytedance.android.live.core.utils.fresco.b r310 = new com.bytedance.android.live.core.utils.fresco.b();
    L174:
        HSImageView r50 = this.v;
        int r212 = com.bytedance.android.livesdk.gift.platform.business.dialog.v3.preload.e.b(2131168749);
        int r311 = com.bytedance.android.livesdk.gift.platform.business.dialog.v3.preload.e.b(2131168749);
        GiftImageLoader.b(r211, r50, r41, ((Number) GiftImageLoader.g.getValue()).intValue(), r212, r311, r310, new com.bytedance.android.livesdk.gift.platform.business.dialog.v3.mviview.adapter.f(this, r43, r44, this.X), "live_gift_panel_icon", "id=" + r43 + "_pos=" + this.a0 + '-' + p(), 1796);
    L175:
        py.k r51 = r5.a.getLeftLogo();
        e2 r53 = r5.a.getGiftTouchLabel();
        boolean r54 = r5.w;
        if (((Boolean) this.P.getValue()).booleanValue() == false) goto L178;
        this.r.setVisibility(8);
    L192:
        Spannable r55 = vh6.c.b(ur2.a.class).Lf(r5.a.getBottomText(), com.bytedance.android.livesdk.gift.platform.business.dialog.v3.preload.e.c());
        qz1.s r56 = s();
        if (r56.a == false) goto L197;
        LiveSendGiftAnimationView r57 = r56.b;
        if (r57 == null) goto L197;
        r57.setSendText(r55);
    L197:
        r56.e = r55;
        py.k r58 = r5.a.getRightTopSelectedLabel();
        qz1.s r59 = s();
        if (r59.a == false) goto L202;
        LiveSendGiftAnimationView r60 = r59.b;
        if (r60 == null) goto L202;
        r60.setRightTopSelectedLabelView(r58);
    L202:
        r59.w = r58;
        x(this.E, r5.n);
        Pair<Integer, vz1.i> r61 = r5.c;
        py.k r63 = r5.a.getImage();
        String r64 = r5.k;
        long r65 = r5.i;
        Long r66 = r5.h;
        if (r66 == null) goto L205;
        long r110 = r66.longValue();
    L207:
        if (nz1.a.g() == false) goto L209;
        int r67 = r5.u.c;
    L210:
        Long r68 = Long.valueOf(r65 * (r110 + ((long) r67)));
        if (r64 != null) goto L227;
        if (r68 == null) goto L214;
        long r69 = r68.longValue();
    L215:
        Long r70 = Long.valueOf(r69);
        int r71 = this.E;
        VisualStatus r73 = VisualStatus.INSTANCE;
        if ((r71 & r73.getBAN()) != r73.getBAN()) goto L218;
    L225:
        boolean r74 = true;
    L226:
        r64 = vz1.g.a(r70, r74);
        goto L227
    L218:
        if ((this.E & r73.getLOCK()) == r73.getLOCK()) goto L225;
        if ((this.E & r73.getLOCK_NORMAL()) == r73.getLOCK_NORMAL()) goto L225;
        if ((this.J.a & r16.getLOCK()) == r16.getLOCK()) goto L225;
        r74 = false;
        goto L226
    L214:
        r69 = 0;
    L227:
        if (r64 != null) goto L229;
        StringBuilder r75 = new StringBuilder();
        r75.append(String.valueOf(r68));
        r75.append(" ");
        com.bytedance.android.livesdk.gift.platform.business.config.j r76 = com.bytedance.android.livesdk.gift.util.b.a();
        GiftConfigKey r77 = GiftConfigKey.KEY_GIFT_DIALOG_DIAMOND;
        DiamondConfig.d.getClass();
        r75.append(((DiamondConfig) r76.c(r77, DiamondConfig.a.a())).b);
        r64 = r75.toString();
    L229:
        int r78 = this.E;
        VisualStatus r79 = VisualStatus.INSTANCE;
        if ((r78 & r79.getLOCK()) != r79.getLOCK()) goto L232;
    L237:
        boolean r312 = true;
    L238:
        int r80 = r5.j;
        vz1.a r81 = r5.u;
        int r111 = r81.h;
        boolean r83 = r81.e;
        if (((Number) r61.getFirst()).intValue() != this.M) goto L241;
        String r112 = "diamondString";
    L268:
        if (r80 == this.N) goto L279;
        qz1.s r84 = s();
        if (r80 >= this.N) goto L272;
        boolean r85 = true;
    L273:
        r84.getClass();
        Intrinsics.checkNotNullParameter(r64, r112);
        if (r84.a == false) goto L278;
        LiveSendGiftAnimationView r86 = r84.b;
        if (r86 == null) goto L278;
        r86.i(r85, r64);
    L278:
        this.N = r80;
        goto L279
    L272:
        r85 = false;
    L279:
        this.T.a = ((vz1.i) r61.getSecond()).b;
        s().a(((vz1.i) r61.getSecond()).b, r64, com.bytedance.android.livesdk.gift.platform.business.dialog.v3.preload.e.a(), com.bytedance.android.livesdk.gift.platform.business.dialog.v3.preload.e.c(), r312, r111, ((vz1.i) r61.getSecond()).c);
        qz1.s r87 = s();
        int r88 = p();
        int r89 = this.a0;
        r87.z = r88;
        r87.A = r89;
        LiveSendGiftAnimationView r90 = r87.b;
        if (r90 == null) goto L282;
        r90.N = r88;
        r90.O = r89;
    L282:
        qz1.s r91 = s();
        if (r91.a == false) goto L288;
        LiveSendGiftAnimationView r93 = r91.b;
        if (r93 == null) goto L287;
        r93.setUseCustomTextStyleWhenLocked(r83);
    L287:
        r91.x = r83;
    L290:
        if (this.I != ItemStatus.IDLE) goto L293;
        C(false);
    L293:
        r0<ItemListData, Integer> r94 = r2.getVisualStatus();
        Object r95 = r37.c.a(r94);
        if (r95 == null) goto L315;
        r37.b.a.invoke(r94);
        int r96 = ((Number) r95).intValue();
        this.E = r96;
        x(r96, this.O);
        Long r97 = this.G;
        if (r97 == null) goto L315;
        long r98 = r97.longValue();
        if (TextUtils.isEmpty(this.F) == false) goto L315;
        if (r98 <= 0) goto L315;
        D(r(this.H, this.F, this.G));
        Long r99 = this.G;
        int r100 = this.E;
        VisualStatus r101 = VisualStatus.INSTANCE;
        if ((r100 & r101.getBAN()) != r101.getBAN()) goto L304;
    L311:
        boolean r113 = true;
    L312:
        String r102 = vz1.g.a(r99, r113);
        if (r102 == null) goto L315;
        s().e(r102);
        goto L315
    L304:
        if ((this.E & r101.getLOCK()) == r101.getLOCK()) goto L311;
        if ((this.E & r101.getLOCK_NORMAL()) == r101.getLOCK_NORMAL()) goto L311;
        int r103 = this.J.a;
        CardStatus r104 = CardStatus.INSTANCE;
        if ((r103 & r104.getLOCK()) == r104.getLOCK()) goto L311;
        r113 = false;
    L315:
        r0<ItemListData, ItemStatus> r105 = r2.getItemStatus();
        Object r106 = r37.c.a(r105);
        if (r106 == null) goto L409;
        r37.b.a.invoke(r105);
        ItemStatus r107 = (ItemStatus) r106;
        this.I = r107;
        int r108 = com.bytedance.android.livesdk.gift.platform.business.dialog.v3.mviview.adapter.b.b[r107.ordinal()];
        if (r108 != 1) goto L320;
        s().h(0);
        this.A.setVisibility(8);
        m0 r109 = this.L;
        if (r109 != null) goto L329;
        Intrinsics.throwUninitializedPropertyAccessException("mSweepHelper");
    L329:
        vz1.e r114 = r109.a;
        if (r114 == null) goto L334;
        h1 r115 = r114.a;
        if (r115 == null) goto L334;
        Long r116 = Long.valueOf(r115.getSelectedDynamicEffect());
    L335:
        if (r116 == null) goto L354;
        m0 r117 = this.L;
        if (r117 != null) goto L339;
        Intrinsics.throwUninitializedPropertyAccessException("mSweepHelper");
    L339:
        vz1.e r118 = r117.a;
        if (r118 == null) goto L346;
        h1 r119 = r118.a;
        if (r119 == null) goto L346;
        if (r119.getSelectedDynamicEffect() == 0) goto L354;
    L346:
        HashMap<GiftPreloadResType, com.bytedance.android.livesdk.gift.platform.business.dialog.v3.preload.p000new.k<?>> r120 = GiftPreloadManager.a;
        Uri r121 = (Uri) GiftPreloadManager.a(com.bytedance.android.livesdk.gift.platform.business.dialog.v3.preload.new.f.c.c);
        if (r121 != null) goto L349;
        r121 = com.bytedance.android.live.revenue.core.util.f.a(vy0.c.class).Q("/gift/ttlive_gift_icon_rare_effect.webp");
    L349:
        AbstractDraweeController r122 = Fresco.newDraweeControllerBuilder().setUri(r121).setControllerListener(new h()).setAutoPlayAnimations(false).build();
        qz1.s r123 = s();
        r123.getClass();
        Intrinsics.checkNotNullParameter(r122, r210);
        LiveSendGiftAnimationView r124 = r123.b;
        if (r124 == null) goto L354;
        HSImageView r125 = r124.getIconAnimationContainer();
        if (r125 == null) goto L354;
        r125.setController(r122);
    L354:
        this.D.setVisibility(8);
        HSImageView r126 = this.w;
        if (r126 == null) goto L357;
        Integer r127 = Integer.valueOf(r126.getVisibility());
    L359:
        if (r127.intValue() != 0) goto L361;
        z();
        o(new OnGiftExposureAnimShow(this.a0, p()));
    L361:
        C(true);
        i12.d r128 = i12.m.e2.a();
        if (r128 == null) goto L364;
        Object r129 = com.bytedance.android.scope.m.e.d(r128, GiftPanelMonitorService.class);
    L365:
        GiftPanelMonitorService r130 = (GiftPanelMonitorService) r129;
        if (r130 == null) goto L409;
        if (r130.l != 0) goto L409;
        r130.l = System.currentTimeMillis() - r130.b;
        if (e12.a.a <= 0) goto L373;
        r130.m = System.currentTimeMillis() - e12.a.a;
    L373:
        com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.e0 r131 = r130.D;
        if (r131 == null) goto L377;
        r131.e = false;
    L377:
        if (com.bytedance.android.live.core.utils.v.a() == false) goto L409;
        Pair<GiftContext, ? extends Disposable> r132 = r130.I.b;
        if (r132 == null) goto L381;
        GiftContext r133 = (GiftContext) r132.getFirst();
    L382:
        if (r133 == null) goto L409;
        long r134 = r130.b;
        long r135 = r134 - r130.a;
        long r136 = r130.c - r134;
        long r137 = ((Number) r133.getGiftPanelFirstRenderTs().getValue()).longValue() - Math.max(r130.e, r130.c);
        long r0 = ((Number) r133.getGiftPanelFirstRenderTs().getValue()).longValue() - r130.b;
        long r138 = ((Number) r133.getDefaultGiftLocatedAt().getValue()).longValue() - r130.b;
        long r139 = r136 + r137;
        if (r130.e >= r130.c) goto L386;
        long r1 = 0;
    L387:
        long r140 = r139 + r1;
        StringBuilder r141 = new StringBuilder("GiftPanelShow, hitViewCache = ");
        r141.append(r130.n);
        r141.append("  giftExtraCache = ");
        r141.append(r130.q);
        r141.append(" \n               triggerTimeGap:     ");
        r141.append(r135);
        r141.append(" \n               panelCreate:        ");
        r141.append(r136);
        r141.append(" \n               widgetLoad:         ");
        r141.append(r130.d);
        r141.append(" \n               firstFrameRender:   ");
        r141.append(r137);
        r141.append(" \n               panelFirstScreen:   ");
        r141.append(r0);
        r141.append("   mainCost=");
        r141.append(r140);
        r141.append("   gapTime=");
        r141.append(r0 - r140);
        r141.append(" \n               defaultGiftSelect:  ");
        r141.append(r138);
        r141.append(" \n               uiDefaultSelect:    ");
        r141.append(r130.l);
        r141.append(" \n               enterRoomToOpenPanelDuration: ");
        r141.append(r130.m);
        r141.append(" \n               defaultSelectGiftUiTaskCnt: ");
        com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.e0 r142 = r130.D;
        if (r142 == null) goto L390;
        Integer r143 = Integer.valueOf(r142.h);
    L391:
        r141.append(r143);
        r141.append(" \n               defaultSelectGiftUiTaskCost: ");
        com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.e0 r144 = r130.D;
        if (r144 == null) goto L394;
        Long r145 = Long.valueOf(r144.i);
    L395:
        r141.append(r145);
        r141.append(" \n               defaultSelectGiftWorkerTaskCnt: ");
        com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.e0 r146 = r130.D;
        if (r146 == null) goto L398;
        Integer r147 = Integer.valueOf(r146.f);
    L399:
        r141.append(r147);
        r141.append(" \n               defaultSelectGiftWorkerTaskCost: ");
        com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.e0 r148 = r130.D;
        if (r148 == null) goto L402;
        Long r149 = Long.valueOf(r148.g);
    L403:
        r141.append(r149);
        r141.append(" \n               uiActionGapMills:    ");
        com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.e0 r150 = r130.D;
        if (r150 == null) goto L406;
        Long r151 = Long.valueOf(r150.k);
    L407:
        r141.append(r151);
        r141.append(" \n");
        jy0.b.c("ttlive_gift_panel_metrics", r141.toString(), null, 4);
        goto L409
    L406:
        r151 = null;
        goto L407
    L402:
        r149 = null;
        goto L403
    L398:
        r147 = null;
        goto L399
    L394:
        r145 = null;
        goto L395
    L390:
        r143 = null;
        goto L391
    L386:
        r1 = r130.d;
        goto L387
    L381:
        r133 = null;
        goto L382
    L364:
        r129 = null;
        goto L365
    L357:
        r127 = null;
    L334:
        r116 = null;
        goto L335
    L320:
        if (r108 != 2) goto L322;
        s().h(8);
        this.A.setVisibility(0);
        this.D.setVisibility(0);
        C(false);
        goto L409
    L322:
        if (r108 != 3) goto L409;
        this.A.setVisibility(8);
        s().h(8);
        this.D.setVisibility(0);
    L409:
        r0<ItemListData, SelectedStatus> r152 = r2.getSelectedStatus();
        Object r153 = r37.c.a(r152);
        if (r153 == null) goto L480;
        r37.b.a.invoke(r152);
        SelectedStatus r154 = (SelectedStatus) r153;
        BasePanelViewHolderItem r155 = this;
        int r156 = r155.E;
        VisualStatus r157 = VisualStatus.INSTANCE;
        if ((r156 & r157.getBAN()) != r157.getBAN()) goto L414;
    L419:
        boolean r158 = true;
    L420:
        int r159 = com.bytedance.android.livesdk.gift.platform.business.dialog.v3.mviview.adapter.b.a[r154.ordinal()];
        if (r159 == 1) goto L458;
        if (r159 != 2) goto L425;
        Iterator r160 = da0.a.a.iterator();
    L433:
        if (r160.hasNext() == false) goto L435;
        ((ca0.p) r160.next()).i();
        goto L433
    L435:
        s().f(false, r158);
        if (r155.R == false) goto L438;
        s().k(r155.Z);
    L481:
        r155.v(r37, r2);
        return;
    L438:
        qz1.s r161 = s();
        if (r161.a == false) goto L481;
        LiveSendGiftAnimationView r162 = r161.b;
        if (r162 == null) goto L481;
        com.bytedance.android.livesdk.gift.configmodel.f0 r163 = r162.J;
        if (r163 != null) goto L445;
    L447:
        android.util.Pair<Float, Animator> r164 = r162.b;
        if (r164 != null) goto L450;
    L455:
        android.util.Pair<Float, Animator> r165 = new android.util.Pair(Float.valueOf(1.06f), ObjectAnimator.ofPropertyValuesHolder(r162, new PropertyValuesHolder[]{PropertyValuesHolder.ofFloat("scaleX", new float[]{1.0f, 1.06f, 1.0f}), PropertyValuesHolder.ofFloat("scaleY", new float[]{1.0f, 1.06f, 1.0f})}));
        r162.b = r165;
        ((Animator) r165.second).setDuration(200);
        ((Animator) r162.b.second).setInterpolator(PathInterpolatorCompat.create(0.42f, 0.0f, 0.58f, 1.0f));
    L456:
        ((Animator) r162.b.second).start();
        goto L481
    L450:
        if (r164.second == null) goto L455;
        Object r166 = r164.first;
        if (r166 == null) goto L455;
        if (((Float) r166).floatValue() == 1.06f) goto L456;
    L445:
        if (r163.b() == false) goto L447;
        r162.o();
        goto L481
    L425:
        if (r159 != 3) goto L481;
        s().f(false, r158);
        if (r155.R == false) goto L430;
        s().k(r155.Z);
        goto L481
    L430:
        s().i();
        goto L481
    L458:
        if (com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.v.e() == true) goto L460;
    L461:
        s().f(true, r158);
        qz1.s r167 = s();
        if (r167.a == false) goto L481;
        LiveSendGiftAnimationView r168 = r167.b;
        if (r168 == null) goto L481;
        com.bytedance.android.livesdk.gift.configmodel.f0 r169 = r168.J;
        if (r169 != null) goto L468;
    L470:
        android.util.Pair<Float, Animator> r170 = r168.b;
        if (r170 != null) goto L473;
    L478:
        android.util.Pair<Float, Animator> r171 = new android.util.Pair(Float.valueOf(1.06f), ObjectAnimator.ofPropertyValuesHolder(r168, new PropertyValuesHolder[]{PropertyValuesHolder.ofFloat("scaleX", new float[]{1.0f, 1.06f, 1.0f}), PropertyValuesHolder.ofFloat("scaleY", new float[]{1.0f, 1.06f, 1.0f})}));
        r168.b = r171;
        ((Animator) r171.second).setDuration(200);
        ((Animator) r168.b.second).setInterpolator(PathInterpolatorCompat.create(0.42f, 0.0f, 0.58f, 1.0f));
    L479:
        ((Animator) r168.b.second).start();
        goto L481
    L473:
        if (r170.second == null) goto L478;
        Object r172 = r170.first;
        if (r172 == null) goto L478;
        if (((Float) r172).floatValue() == 1.06f) goto L479;
    L468:
        if (r169.b() == false) goto L470;
        r168.o();
        goto L481
    L460:
        if (com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.v.e() == false) goto L481;
    L414:
        if ((r155.E & r157.getLOCK()) == r157.getLOCK()) goto L419;
        int r173 = r155.J.a;
        CardStatus r174 = CardStatus.INSTANCE;
        if ((r173 & r174.getLOCK()) == r174.getLOCK()) goto L419;
        r158 = false;
        goto L420
    L480:
        r155 = this;
        goto L481
    L288:
        r91.x = r83;
        goto L290
    L241:
        if (((vz1.i) r61.getSecond()).getType() != ImageType.ImageModel) goto L243;
    L256:
        r112 = "diamondString";
        qz1.s r175 = s();
        py.k r176 = ((vz1.i) r61.getSecond()).b;
        py.k r177 = ((vz1.i) r61.getSecond()).c;
        if (((Number) r61.getFirst()).intValue() >= this.M) goto L259;
        boolean r178 = true;
    L260:
        r175.getClass();
        Intrinsics.checkNotNullParameter(r64, r112);
        if (r175.a == false) goto L265;
        LiveSendGiftAnimationView r179 = r175.b;
        if (r179 == null) goto L265;
        r179.j(r176, r177, r178, r64);
    L265:
        this.M = ((Number) r61.getFirst()).intValue();
        goto L268
    L259:
        r178 = false;
        goto L260
    L243:
        if (((vz1.i) r61.getSecond()).getType() == ImageType.DynamicImage) goto L256;
        qz1.s r180 = s();
        Bitmap r181 = ((vz1.i) r61.getSecond()).d;
        if (((Number) r61.getFirst()).intValue() >= this.M) goto L248;
        boolean r182 = true;
    L249:
        r180.getClass();
        Intrinsics.checkNotNullParameter(r64, "diamondString");
        if (r180.a == false) goto L255;
        r180.p = false;
        LiveSendGiftAnimationView r183 = r180.b;
        if (r183 == null) goto L254;
        r112 = "diamondString";
        r183.h(r63, r181, r182, true, r64);
        goto L265
    L254:
        r112 = "diamondString";
        goto L265
    L255:
        r112 = "diamondString";
        r180.p = true;
        r180.q = r63;
        r180.r = r181;
        r180.s = r182;
        r180.t = true;
        goto L265
    L248:
        r182 = false;
        goto L249
    L232:
        if ((this.E & r79.getBAN()) == r79.getBAN()) goto L237;
        if ((this.J.a & r16.getLOCK()) == r16.getLOCK()) goto L237;
        r312 = false;
        goto L238
    L209:
        r67 = 0;
        goto L210
    L205:
        r110 = 0;
        goto L207
    L178:
        if (r53 == null) goto L180;
        py.k r184 = r53.getIcon();
    L181:
        if (r54 == false) goto L184;
        if (r184 == null) goto L184;
        r51 = r184;
    L184:
        if (r51 != null) goto L186;
        this.r.setVisibility(8);
        goto L192
    L186:
        if (r51.equals(this.W) == false) goto L190;
        com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.c0 r185 = com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.c0.d;
        r185.getClass();
        if (((com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.f0) com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.c0.b.getValue(r185, com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.c0.a[0])).b() == true) goto L192;
    L190:
        this.W = r51;
        this.r.setVisibility(0);
        ImageLoader.bindImage(this.r, r51, s1.j(2131168730), s1.j(2131168729), new com.bytedance.android.livesdk.gift.platform.business.dialog.v3.mviview.adapter.e(this));
        goto L192
    L180:
        r184 = null;
        goto L181
    L173:
        r310 = null;
        goto L174
    L169:
        r47 = null;
    L160:
        String r186 = this.V;
        if (r41 == null) goto L163;
        String r187 = r41.getUri();
    L165:
        if (Intrinsics.areEqual(r186, r187) == false) goto L167;
    L163:
        r187 = null;
        goto L165
    L139:
        if (this.M != ((Number) r39.getFirst()).intValue()) goto L147;
        if (this.M != this.o) goto L147;
        AbstractDraweeController r188 = Fresco.newDraweeControllerBuilder().setUri((String) ListProtector.get(r36.getUrls(), 0)).setControllerListener(new g()).setAutoPlayAnimations(false).build();
        qz1.s r189 = s();
        r189.getClass();
        r210 = r28;
        Intrinsics.checkNotNullParameter(r188, r210);
        r189.u = r188;
        if (r189.a == false) goto L145;
        r189.d();
        boolean r190 = true;
    L146:
        this.R = r190;
        goto L148
    L145:
        r190 = true;
        r189.v = true;
        goto L146
    L108:
        r33 = null;
    L121:
        this.z.setVisibility(8);
        this.t.setVisibility(8);
        goto L127
    L102:
        r30 = null;
        goto L104
    L123:
        if (r24.getDisplayText() == null) goto L125;
        A(r24);
        goto L127
    L125:
        this.z.setVisibility(8);
        goto L127
    L67:
        if (this.S == false) goto L69;
    L68:
        r28 = "controller";
        goto L127
    L69:
        GiftLabelTextView r191 = this.z;
        c2 r192 = r10.getGiftTip();
        if (r192 == null) goto L74;
        Intrinsics.checkNotNullParameter(r192, "$this$mainGiftTip");
        j2 r193 = (j2) r192.castToOrNull(j2.class);
        if (r193 == null) goto L74;
        long r194 = r193.getDeadLineTime() * u0.g.a;
    L75:
        r28 = "controller";
        long r195 = r10.getNowTimeDiffSeconds() * u0.g.a;
        ur2.a r196 = vh6.c.b(ur2.a.class);
        c2 r197 = r10.getGiftTip();
        if (r197 == null) goto L78;
        a5 r198 = r197.getDisplayText();
    L79:
        String r199 = r196.Lf(r198, BuildConfig.FLAVOR).toString();
        ur2.a r1100 = vh6.c.b(ur2.a.class);
        c2 r200 = r10.getGiftTip();
        if (r200 == null) goto L84;
        Intrinsics.checkNotNullParameter(r200, "$this$mainGiftTip");
        j2 r201 = (j2) r200.castToOrNull(j2.class);
        if (r201 == null) goto L84;
        a5 r202 = r201.getTimeSuffixText();
    L85:
        String r203 = r1100.Lf(r202, BuildConfig.FLAVOR).toString();
        r191.getClass();
        Intrinsics.checkNotNullParameter(r199, "displayText");
        Intrinsics.checkNotNullParameter(r203, "suffixText");
        long r204 = r194 - (System.currentTimeMillis() - r195);
        r191.y(r204, r199, r203);
        if (r204 <= 0) goto L93;
        Ref.LongRef r1101 = new Ref.LongRef();
        r1101.element = r204;
        if (r204 <= 0) goto L93;
        Disposable r205 = r191.a;
        if (r205 == null) goto L92;
        r205.dispose();
    L92:
        r191.a = RxUtilKt.h(du2.a.d(1, TimeUnit.SECONDS).subscribeOn(Schedulers.io())).subscribe(new qz1.b(r191, r1101, r199, r203));
    L93:
        if (r204 <= 0) goto L95;
        boolean r1102 = true;
    L96:
        this.S = r1102;
        this.z.setVisibility(0);
        goto L127
    L95:
        r1102 = false;
    L84:
        r202 = null;
        goto L85
    L78:
        r198 = null;
    L74:
        r194 = 0;
        goto L75
    L63:
        r27 = 0;
        r26 = 0;
        goto L65
    L57:
        if ((r10.getGiftEndingTime() - ((System.currentTimeMillis() / 1000) - r10.getNowTimeDiffSeconds())) > 0) goto L59;
        this.A.setAlpha(this.l);
    L59:
        GiftLabelTextView r206 = this.z;
        long r213 = r10.getGiftEndingTime();
        u0 r1103 = u0.g;
        r206.z(r1103.a * r213, r1103.a * r10.getNowTimeDiffSeconds());
        this.z.setVisibility(0);
    L49:
        r23 = new com.bytedance.android.livesdk.gift.platform.core.l(null);
    L53:
        r28 = "controller";
        goto L133
    L16:
        if (((Boolean) nz1.a.l0.getValue(null, nz1.a.a[62])).booleanValue() == true) goto L18;
    L25:
        qz1.s r207 = s();
        if (r207.a == false) goto L30;
        LiveSendGiftAnimationView r208 = r207.b;
        if (r208 == null) goto L30;
        r208.setLockText(null);
    L30:
        r207.d = null;
        goto L31
    L18:
        if (TextUtils.isEmpty(this.J.d) == true) goto L25;
        qz1.s r209 = s();
        String r214 = this.J.d;
        if (r209.a == false) goto L24;
        LiveSendGiftAnimationView r1104 = r209.b;
        if (r1104 == null) goto L24;
        r1104.setLockText(r214);
    L24:
        r209.d = r214;
        goto L31
    L292:
        r210 = "controller";
        goto L293
    }

    public final void x(int r3, Boolean r4) {
        this.O = r4;
        if (Intrinsics.areEqual(r4, Boolean.TRUE) == true) goto L10;
        VisualStatus r5 = VisualStatus.INSTANCE;
        if ((r5.getLOCK() & r3) == r5.getLOCK()) goto L10;
        if ((r3 & r5.getLOCK_NORMAL()) == r5.getLOCK_NORMAL()) goto L10;
        this.C.setVisibility(8);
        return;
    L10:
        this.C.setVisibility(0);
    }

    public boolean y(View r2, MotionEvent r3) {
        Intrinsics.checkNotNullParameter(r2, "v");
        Intrinsics.checkNotNullParameter(r3, "event");
        return this.Q.b(r2, r3);
    }

    public final void E(View r2, int r3, int r4) {
        if (((Boolean) this.p.getValue()).booleanValue() == false) goto L6;
        ViewGroup.LayoutParams r0 = r2.getLayoutParams();
        r0.width = r3;
        r0.height = r4;
        r2.setLayoutParams(r0);
        return;
    }

    public final String r(String r2, String r3, Long r4) {
        this.H = r2;
        this.F = r3;
        this.G = r4;
        if (TextUtils.isEmpty(r2) == true) goto L6;
        return r2;
    L6:
        if (TextUtils.isEmpty(r3) == false) goto L13;
        if (this.C.getVisibility() != 0) goto L10;
        boolean r5 = true;
    L14:
        return vz1.g.a(r4, r5);
    L10:
        r5 = false;
        goto L14
    L13:
        return r3;
    }

    public BasePanelViewHolderItem(ViewGroup r11, View r13, int r14, int r15, boolean r16) {
        Intrinsics.checkNotNullParameter(r11, "parent");
        Intrinsics.checkNotNullParameter(r13, "inflateView");
        super(r13, new ItemListData());
        this.a0 = r14;
        this.b0 = r15;
        this.c0 = r16;
        this.l = 0.32f;
        this.m = 1.0f;
        this.n = 20;
        this.o = -1;
        this.p = LazyKt.lazy(BasePanelViewHolderItem$paramsOpt$2.INSTANCE);
        this.q = s1.e(13.0f);
        this.r = ((BaseMVIListItem) this).j.findViewById(2131377795);
        this.s = ((BaseMVIListItem) this).j.findViewById(2131369000);
        this.t = ((BaseMVIListItem) this).j.findViewById(2131363715);
        this.u = (TextView) ((BaseMVIListItem) this).j.findViewById(2131368992);
        View r17 = (HSImageView) ((BaseMVIListItem) this).j.findViewById(2131373729);
        E(r17, UtilityKotlinExtentionsKt.i(56), UtilityKotlinExtentionsKt.i(56));
        Unit r18 = Unit.INSTANCE;
        this.v = r17;
        View r19 = (HSImageView) ((BaseMVIListItem) this).j.findViewById(2131373710);
        E(r19, UtilityKotlinExtentionsKt.i(56), UtilityKotlinExtentionsKt.i(56));
        this.w = r19;
        this.x = (TextView) ((BaseMVIListItem) this).j.findViewById(2131373743);
        this.y = LazyKt.lazy(new BasePanelViewHolderItem$mSendGiftView$2(this));
        this.z = (GiftLabelTextView) ((BaseMVIListItem) this).j.findViewById(2131373734);
        this.A = ((BaseMVIListItem) this).j.findViewById(2131367792);
        GiftIconMaskView r110 = (GiftIconMaskView) ((BaseMVIListItem) this).j.findViewById(2131373731);
        E(r110, UtilityKotlinExtentionsKt.i(56), UtilityKotlinExtentionsKt.i(56));
        this.B = r110;
        this.C = ((BaseMVIListItem) this).j.findViewById(2131373739);
        this.D = ((BaseMVIListItem) this).j.findViewById(2131373730);
        this.E = VisualStatus.INSTANCE.getIDLE();
        this.I = ItemStatus.IDLE;
        this.J = new vz1.a(0, null, 0, null, false, null, null, 0, 255);
        this.M = -1;
        this.N = -1;
        this.P = LazyKt.lazy(new BasePanelViewHolderItem$isAccessibleEnabled$2(this));
        p();
        this.Q = new com.bytedance.android.livesdk.gift.platform.business.dialog.v3.c(new BasePanelViewHolderItem$touchController$1(this), new BasePanelViewHolderItem$touchController$2(this), new BasePanelViewHolderItem$touchController$3(this), new BasePanelViewHolderItem$touchController$4(this));
        this.T = new com.bytedance.android.livesdk.gift.platform.core.model.n(null, null, 7);
        this.X = com.bytedance.android.livesdk.gift.util.b.b();
        this.Z = new d(this);
    }

    public /* synthetic */ BasePanelViewHolderItem(ViewGroup r7, View r8, int r9, int r10, int r11) {
        if ((r11 & 8) == 0) goto L5;
        int r4 = -1;
    L6:
        this(r7, r8, r9, r4, false);
        return;
    L5:
        r4 = r10;
        goto L6
    }
}
