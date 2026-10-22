package com.bytedance.android.livesdk.gift.guide.view;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.PathInterpolator;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.ViewModelProviders;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.gift.BaseCommentGiftGuideView;
import com.bytedance.android.livesdk.gift.guide.viewmodel.CommentGiftGuideViewModel;
import com.bytedance.android.livesdk.gift.platform.business.config.DiamondConfig;
import com.bytedance.android.livesdk.interactivity.comment.newinput.provider.n1;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import com.bytedance.android.livesdk.utils.LifecycleOwnerCompat;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.mt.protector.impl.UriProtector;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import cy0.e;
import cy0.j;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import mz0.i;
import mz0.m;
import mz0.n;
import py.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0011B'\b\u0007\u0012\u0006\u0010\n\u001a\u00020\t\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\b\b\u0002\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/livesdk/gift/guide/view/CommentGiftGuideView;", "Lcom/bytedance/android/live/gift/BaseCommentGiftGuideView;", "Lcom/bytedance/android/livesdk/utils/LifecycleOwnerCompat;", BuildConfig.FLAVOR, "enable", BuildConfig.FLAVOR, "setGuideEnable", "Landroidx/lifecycle/Lifecycle;", "getLifecycleCompat", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", BuildConfig.FLAVOR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "b", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CommentGiftGuideView extends BaseCommentGiftGuideView implements LifecycleOwnerCompat {
    public static final /* synthetic */ int i = 0;
    public Map<Integer, View> a;
    public final LifecycleRegistry b;
    public final CommentGiftGuideViewModel c;
    public Animator d;
    public Disposable e;
    public boolean f;
    public long g;
    public boolean h;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ CommentGiftGuideView a;

        public a(CommentGiftGuideView r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            CommentGiftGuideView r3 = this.a;
            int r0 = CommentGiftGuideView.i;
            r3.e("click");
            this.a.c.sendCommentGift();
        }
    }

    public static final class b {
    }

    public static final class c<T> implements Observer {
        public final /* synthetic */ CommentGiftGuideView a;

        public c(CommentGiftGuideView r1) {
            this.a = r1;
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [android.widget.FrameLayout, com.bytedance.android.livesdk.gift.guide.view.CommentGiftGuideView, java.lang.Object] */
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
        public final void onChanged(Object r7) {
            zy1.a r8 = (zy1.a) r7;
            ?? r0 = this.a;
            int r1 = CommentGiftGuideView.i;
            r0.getClass();
            if (r8 != null) goto L5;
            return;
        L5:
            if (r8.a == false) goto L32;
            Animator r2 = r0.d;
            k r3 = null;
            if (r2 != null) goto L9;
        L14:
            ImageLoader.bindImage(r0.c(2131373728), r8.d);
            ((TextView) r0.c(2131373685)).setText(String.valueOf(r8.f));
            ImageView r4 = (ImageView) r0.c(2131367088);
            DiamondConfig r5 = r8.e;
            if (r5 == null) goto L17;
            r3 = r5.a;
        L17:
            ImageUtil.loadImage(r4, r3, 0);
            r0.setTranslationX(r0.getWidth());
            ConstraintLayout r6 = r0.c(2131367345);
            if (r6 == null) goto L21;
            r6.setVisibility(0);
        L21:
            if (TextUtils.isEmpty(r8.c) == false) goto L25;
            HSImageView r9 = r0.c(2131367343);
            if (r9 == null) goto L31;
            r9.setVisibility(8);
        L31:
            ImageLoader.bindImage(r0.c(2131367344), r8.b);
            r0.postDelayed(new az1.a(r0), 100);
            HashMap r10 = new HashMap();
            r10.put("gift_id", String.valueOf(r8.g));
            r10.put("gift_price", String.valueOf(r8.f));
            n r11 = new n();
            Map r13 = r11.a;
            Intrinsics.checkNotNullParameter(r13, "map");
            Intrinsics.checkNotNullParameter(r10, "map");
            r13.putAll(r10);
            m r14 = new m();
            r14.b(LogCommon.ROOM);
            r14.b(LogCommon.PAGE_SOURCE_LOG);
            ((ArrayList) r11.b).addAll(r14.a);
            e.a.getClass();
            j r15 = e.a.a;
            com.bytedance.android.scope.m.e.getClass();
            Object r16 = com.bytedance.android.scope.m.b(r15).a(Reflection.getOrCreateKotlinClass(i.class));
            Intrinsics.checkNotNull(r16);
            ((f80.a) r16).w3("gift_guide_show", r11.a, r11.b);
            return;
        L25:
            HSImageView r17 = r0.c(2131367343);
            if (r17 == null) goto L28;
            r17.setController(Fresco.newDraweeControllerBuilder().setUri(UriProtector.parse(r8.c)).setAutoPlayAnimations(true).build());
        L28:
            HSImageView r18 = r0.c(2131367343);
            if (r18 == null) goto L31;
            r18.setVisibility(0);
            goto L31
        L9:
            if (r2.isRunning() == true) goto L12;
            r2 = null;
        L12:
            if (r2 == null) goto L14;
            r2.removeAllListeners();
            r2.cancel();
            goto L14
        L32:
            r0.e("unmatched");
        }
    }

    public static final class d extends o12.b {
        public final /* synthetic */ CommentGiftGuideView a;

        public d(CommentGiftGuideView r1) {
            this.a = r1;
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r2, boolean r3) {
            Intrinsics.checkNotNullParameter(r2, "animation");
            super.onAnimationStart(r2, r3);
            ConstraintLayout r4 = this.a.c(2131367345);
            if (r4 == null) goto L6;
            r4.setVisibility(4);
            return;
        }
    }

    static {
    }

    public CommentGiftGuideView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public CommentGiftGuideView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public /* bridge */ /* synthetic */ Lifecycle getLifecycle() {
        return LifecycleOwnerCompat.-CC.$default$getLifecycle(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onAttachedToWindow() {
        super/*android.widget.FrameLayout*/.onAttachedToWindow();
        this.b.markState(Lifecycle.State.STARTED);
        this.c.getCommentGiftGuideModel().observe(this, new c(this));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onDetachedFromWindow() {
        super/*android.widget.FrameLayout*/.onDetachedFromWindow();
        this.b.markState(Lifecycle.State.DESTROYED);
        Disposable r0 = this.e;
        if (r0 == null) goto L5;
        r0.dispose();
    L5:
        zy1.a r1 = (zy1.a) this.c.getCommentGiftGuideModel().getValue();
        if (r1 != null) goto L8;
    L10:
        this.c.getCommentGiftGuideModel().removeObservers(this);
        return;
    L8:
        if (r1.a != true) goto L10;
        e("user_pack_up");
        goto L10
    }

    public Lifecycle getLifecycleCompat() {
        return this.b;
    }

    public final void a(String r2) {
        if (this.f == true) goto L5;
        return;
    L5:
        this.c.onCommentChanged(r2);
    }

    public final void b(n1.a r2) {
        this.c.setSendGiftListener(r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final View c(int r3) {
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

    /* JADX WARN: Multi-variable type inference failed */
    public final void e(String r8) {
        if (this.h == true) goto L5;
        return;
    L5:
        Disposable r0 = this.e;
        if (r0 == null) goto L8;
        r0.dispose();
    L8:
        this.h = false;
        Animator r1 = this.d;
        if (r1 != null) goto L11;
    L16:
        ObjectAnimator r2 = ObjectAnimator.ofFloat(this, "translationX", new float[]{0.0f, getWidth()});
        this.d = r2;
        if (r2 == null) goto L19;
        r2.setDuration(200);
        r2.setInterpolator(new PathInterpolator(0.4f, 0.8f, 0.74f, 1.0f));
        r2.addListener(new d(this));
        r2.start();
    L19:
        zy1.a r3 = (zy1.a) this.c.getCommentGiftGuideModel().getValue();
        if (r3 == null) goto L22;
        r3.a = false;
    L22:
        HashMap r4 = new HashMap();
        zy1.a r5 = (zy1.a) this.c.getCommentGiftGuideModel().getValue();
        if (r5 == null) goto L25;
        long r6 = r5.g;
    L26:
        r4.put("gift_id", String.valueOf(r6));
        zy1.a r7 = (zy1.a) this.c.getCommentGiftGuideModel().getValue();
        if (r7 == null) goto L29;
        Number r9 = Integer.valueOf(r7.f);
    L30:
        r4.put("gift_price", r9.toString());
        r4.put("duration", String.valueOf((System.currentTimeMillis() - this.g) / 1000.0f));
        r4.put("end_type", r8);
        n r10 = new n();
        Map r11 = r10.a;
        Intrinsics.checkNotNullParameter(r11, "map");
        Intrinsics.checkNotNullParameter(r4, "map");
        r11.putAll(r4);
        m r13 = new m();
        r13.b(LogCommon.ROOM);
        r13.b(LogCommon.PAGE_SOURCE_LOG);
        ((ArrayList) r10.b).addAll(r13.a);
        e.a.getClass();
        j r14 = e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r15 = com.bytedance.android.scope.m.b(r14).a(Reflection.getOrCreateKotlinClass(i.class));
        Intrinsics.checkNotNull(r15);
        ((f80.a) r15).w3("gift_guide_end", r10.a, r10.b);
        return;
    L29:
        r9 = 0L;
        goto L30
    L25:
        r6 = 0;
        goto L26
    L11:
        if (r1.isRunning() == true) goto L14;
        r1 = null;
    L14:
        if (r1 == null) goto L16;
        r1.removeAllListeners();
        r1.cancel();
        goto L16
    }

    public void setGuideEnable(boolean r1) {
        this.f = r1;
        if (r1 == true) goto L9;
        Disposable r2 = this.e;
        if (r2 == null) goto L7;
        r2.dispose();
    L7:
        e("unmatched");
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CommentGiftGuideView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.a = new LinkedHashMap();
        this.c = (CommentGiftGuideViewModel) ViewModelProviders.of((FragmentActivity) r2).get(CommentGiftGuideViewModel.class);
        this.f = true;
        LayoutInflater.from(r2).inflate(2131565317, this);
        LifecycleRegistry r5 = new LifecycleRegistry(this);
        this.b = r5;
        r5.markState(Lifecycle.State.CREATED);
        View r6 = c(2131373732);
        if (r6 == null) goto L6;
        r6.setOnClickListener(new a(this));
        return;
    }

    public /* synthetic */ CommentGiftGuideView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
