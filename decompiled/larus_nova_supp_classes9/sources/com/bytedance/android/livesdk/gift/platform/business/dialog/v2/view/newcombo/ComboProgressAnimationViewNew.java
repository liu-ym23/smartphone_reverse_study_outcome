package com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Vibrator;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.PathInterpolator;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.utils.p0;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdk.gift.model.ComboHintInfo;
import com.bytedance.android.livesdk.gift.model.ComboHintScene;
import com.bytedance.android.livesdk.gift.model.ComboHintType;
import com.bytedance.android.livesdk.gift.model.g0;
import com.bytedance.android.livesdk.gift.model.h2;
import com.bytedance.android.livesdk.gift.model.l1;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.GiftExtraRepo;
import com.bytedance.android.livesdk.gift.platform.core.GiftContext;
import com.bytedance.android.livesdk.gift.platform.core.manager.GiftManagerKt;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.facebook.imagepipeline.image.ImageInfo;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001=B'\b\u0007\u0012\u0006\u00107\u001a\u000206\u0012\n\b\u0002\u00109\u001a\u0004\u0018\u000108\u0012\b\b\u0002\u0010:\u001a\u00020.¢\u0006\u0004\b;\u0010<J\u0010\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H\u0002J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0002R.\u0010\u000f\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u0017\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R$\u0010\u001f\u001a\u0004\u0018\u00010\u00188\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR$\u0010'\u001a\u0004\u0018\u00010 8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\"\u0010)\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b(\u0010\u0012\u001a\u0004\b)\u0010\u0014\"\u0004\b*\u0010\u0016R\"\u0010,\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b+\u0010\u0012\u001a\u0004\b,\u0010\u0014\"\u0004\b-\u0010\u0016R*\u00105\u001a\u00020.2\u0006\u0010\b\u001a\u00020.8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b/\u00100\u001a\u0004\b1\u00102\"\u0004\b3\u00104¨\u0006>"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v2/view/newcombo/ComboProgressAnimationViewNew;", "Landroid/widget/FrameLayout;", BuildConfig.FLAVOR, "Lcom/bytedance/android/livesdk/gift/model/u;", "getComboHintList", "Lcom/bytedance/android/livesdk/gift/model/l;", "getTargetGiftComboHint", "Lcom/bytedance/android/livesdk/gift/model/h2;", "value", "k", "Lcom/bytedance/android/livesdk/gift/model/h2;", "getGift", "()Lcom/bytedance/android/livesdk/gift/model/h2;", "setGift", "(Lcom/bytedance/android/livesdk/gift/model/h2;)V", "gift", BuildConfig.FLAVOR, "l", "Z", "getBanHint", "()Z", "setBanHint", "(Z)V", "banHint", "Lcom/bytedance/android/livesdk/gift/model/l1;", "m", "Lcom/bytedance/android/livesdk/gift/model/l1;", "getBuffInfo", "()Lcom/bytedance/android/livesdk/gift/model/l1;", "setBuffInfo", "(Lcom/bytedance/android/livesdk/gift/model/l1;)V", "buffInfo", "Lcom/bytedance/android/livesdk/gift/model/n;", "n", "Lcom/bytedance/android/livesdk/gift/model/n;", "getDiyInfo", "()Lcom/bytedance/android/livesdk/gift/model/n;", "setDiyInfo", "(Lcom/bytedance/android/livesdk/gift/model/n;)V", "diyInfo", "o", "isGroupSend", "setGroupSend", "p", "isSeriesSend", "setSeriesSend", BuildConfig.FLAVOR, "q", "I", "getComboButtonStyle", "()I", "setComboButtonStyle", "(I)V", "comboButtonStyle", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ComboProgressAnimationViewNew extends FrameLayout {
    public static final /* synthetic */ int A = 0;
    public int a;
    public AnimatorSet b;
    public AnimatorSet c;
    public AnimatorSet d;
    public AnimatorSet e;
    public boolean f;
    public boolean g;
    public final int h;
    public boolean i;
    public final ArrayList<com.bytedance.android.livesdk.gift.platform.core.model.e> j;
    public h2 k;
    public boolean l;
    public l1 m;
    public com.bytedance.android.livesdk.gift.model.n n;
    public boolean o;
    public boolean p;
    public int q;
    public boolean r;
    public boolean s;
    public final Map<Integer, Boolean> t;
    public Disposable u;
    public com.bytedance.android.livesdk.gift.model.v v;
    public com.bytedance.android.livesdk.gift.model.u w;
    public final HSImageView x;
    public final View y;
    public final TextView z;

    public static final class a {
    }

    public static final class b implements p0 {
        public final /* synthetic */ ComboProgressAnimationViewNew a;
        public final /* synthetic */ int b;
        public final /* synthetic */ String c;
        public final /* synthetic */ int d;
        public final /* synthetic */ com.bytedance.android.livesdk.gift.model.v e;

        public final /* synthetic */ void a(ImageInfo r1, Animatable r2) {
        }

        public final void b(py.k r1, Exception r2) {
        }

        public final /* synthetic */ void d(ImageInfo r1) {
        }

        public final void e(py.k r1) {
        }

        public final void c(py.k r2, int r3, int r4, boolean r5) {
            HSImageView r6 = this.a.x;
            Long r7 = null;
            if (r6 == null) goto L5;
            ViewGroup.LayoutParams r8 = r6.getLayoutParams();
        L7:
            if ((r8 instanceof ViewGroup.LayoutParams) == false) goto L20;
            float r9 = r3 / r4;
            HSImageView r10 = this.a.x;
            if (r10 == null) goto L11;
            ViewGroup.LayoutParams r11 = r10.getLayoutParams();
        L12:
            if (r11 == null) goto L14;
            r11.height = (int) this.a.getContext().getResources().getDimension(2131168699);
        L14:
            if (r11 == null) goto L16;
            r11.width = (int) (r11.height * r9);
        L16:
            HSImageView r13 = this.a.x;
            if (r13 == null) goto L20;
            r13.setLayoutParams(r11);
            goto L20
        L11:
            r11 = null;
        L20:
            if (b02.a.e() == false) goto L22;
        L28:
            ComboProgressAnimationViewNew.a(this.a, true, true);
            h2 r14 = this.a.getGift();
            if (r14 == null) goto L31;
            r7 = Long.valueOf(r14.getId());
        L31:
            com.bytedance.android.livesdk.gift.platform.core.utils.h.q(r7, this.b, this.c, Integer.valueOf(this.d), this.e.getName());
            return;
        L22:
            if ((new SecureRandom().nextInt(10) % 2) != 0) goto L24;
            float r15 = -5.0f;
        L25:
            HSImageView r16 = this.a.x;
            if (r16 == null) goto L28;
            r16.setRotation(r15);
            goto L28
        L24:
            r15 = 5.0f;
            goto L25
        L5:
            r8 = null;
            goto L7
        }

        public b(ComboProgressAnimationViewNew r1, int r2, String r3, int r4, com.bytedance.android.livesdk.gift.model.v r5) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
        }
    }

    public static final class c implements p0 {
        public final /* synthetic */ com.bytedance.android.livesdk.gift.model.l a;
        public final /* synthetic */ com.bytedance.android.livesdk.gift.model.m b;
        public final /* synthetic */ ComboProgressAnimationViewNew c;

        public final /* synthetic */ void a(ImageInfo r1, Animatable r2) {
        }

        public final void b(py.k r1, Exception r2) {
        }

        public final /* synthetic */ void d(ImageInfo r1) {
        }

        public final /* synthetic */ void e(py.k r1) {
        }

        public c(com.bytedance.android.livesdk.gift.model.l r1, com.bytedance.android.livesdk.gift.model.m r2, ComboProgressAnimationViewNew r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void c(py.k r3, int r4, int r5, boolean r6) {
            HSImageView r7 = this.c.x;
            Integer r8 = null;
            if (r7 == null) goto L5;
            ViewGroup.LayoutParams r9 = r7.getLayoutParams();
        L7:
            if ((r9 instanceof ViewGroup.LayoutParams) == false) goto L20;
            float r10 = r4 / r5;
            HSImageView r11 = this.c.x;
            if (r11 == null) goto L11;
            ViewGroup.LayoutParams r13 = r11.getLayoutParams();
        L12:
            if (r13 == null) goto L14;
            r13.height = (int) this.c.getContext().getResources().getDimension(2131168699);
        L14:
            if (r13 == null) goto L16;
            r13.width = (int) (r13.height * r10);
        L16:
            HSImageView r14 = this.c.x;
            if (r14 == null) goto L20;
            r14.setLayoutParams(r13);
            goto L20
        L11:
            r13 = null;
        L20:
            if (b02.a.e() == false) goto L22;
        L28:
            ComboProgressAnimationViewNew.a(this.c, true, false);
            h2 r15 = this.c.getGift();
            if (r15 == null) goto L31;
            Long r16 = Long.valueOf(r15.getId());
        L32:
            com.bytedance.android.livesdk.gift.model.m r17 = this.b;
            int r0 = r17.leftGiftCount;
            if (this.a.dataList.indexOf(r17) != (this.a.dataList.size() - 1)) goto L35;
            String r18 = "2";
        L36:
            h2 r19 = this.c.getGift();
            if (r19 == null) goto L41;
            com.bytedance.android.livesdk.gift.model.l r20 = l0.a(r19);
            if (r20 == null) goto L41;
            r8 = Integer.valueOf(r20.bizType);
        L41:
            com.bytedance.android.livesdk.gift.platform.core.utils.h.q(r16, r0, r18, r8, BuildConfig.FLAVOR);
            return;
        L35:
            r18 = "1";
            goto L36
        L31:
            r16 = null;
            goto L32
        L22:
            if ((new SecureRandom().nextInt(10) % 2) != 0) goto L24;
            float r21 = -5.0f;
        L25:
            HSImageView r23 = this.c.x;
            if (r23 == null) goto L28;
            r23.setRotation(r21);
            goto L28
        L24:
            r21 = 5.0f;
            goto L25
        L5:
            r9 = null;
            goto L7
        }
    }

    public static final class d implements p0 {
        public final /* synthetic */ ComboProgressAnimationViewNew a;

        public final /* synthetic */ void a(ImageInfo r1, Animatable r2) {
        }

        public final void b(py.k r1, Exception r2) {
        }

        public final /* synthetic */ void d(ImageInfo r1) {
        }

        public final /* synthetic */ void e(py.k r1) {
        }

        public d(ComboProgressAnimationViewNew r1) {
            this.a = r1;
        }

        public final void c(py.k r2, int r3, int r4, boolean r5) {
            if (GiftManagerKt.s().size() > 0) goto L5;
        L7:
            HSImageView r6 = this.a.x;
            ViewGroup.LayoutParams r0 = null;
            if (r6 == null) goto L10;
            ViewGroup.LayoutParams r7 = r6.getLayoutParams();
        L12:
            if ((r7 instanceof ViewGroup.LayoutParams) == false) goto L24;
            float r8 = r3 / r4;
            HSImageView r9 = this.a.x;
            if (r9 == null) goto L16;
            r0 = r9.getLayoutParams();
        L16:
            if (r0 == null) goto L18;
            r0.height = (int) this.a.getContext().getResources().getDimension(2131168699);
        L18:
            if (r0 == null) goto L20;
            r0.width = (int) (r0.height * r8);
        L20:
            HSImageView r10 = this.a.x;
            if (r10 == null) goto L24;
            r10.setLayoutParams(r0);
        L24:
            if (b02.a.e() == false) goto L26;
        L32:
            ComboProgressAnimationViewNew.a(this.a, false, false);
            return;
        L26:
            if ((new SecureRandom().nextInt(10) % 2) != 0) goto L28;
            float r11 = -5.0f;
        L29:
            HSImageView r13 = this.a.x;
            if (r13 == null) goto L32;
            r13.setRotation(r11);
            goto L32
        L28:
            r11 = 5.0f;
            goto L29
        L10:
            r7 = null;
            goto L12
        L5:
            if (this.a.a >= ((com.bytedance.android.livesdk.gift.platform.core.model.e) ListProtector.get(GiftManagerKt.s(), 0)).comboCount) goto L7;
        }
    }

    public static final class e<T> implements Consumer {
        public final /* synthetic */ ComboProgressAnimationViewNew a;

        public e(ComboProgressAnimationViewNew r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            Long r3 = (Long) r2;
            Disposable r4 = this.a.u;
            if (r4 == null) goto L5;
            r4.dispose();
        L5:
            ComboProgressAnimationViewNew r5 = this.a;
            r5.u = null;
            r5.v = null;
            r5.w = null;
        }
    }

    public static final class f<T> implements Consumer {
        public static final f a = null;

        static {
            a = new f();
        }

        public f() {
        }

        public final /* bridge */ /* synthetic */ void accept(Object r1) {
            Throwable r2 = (Throwable) r1;
        }
    }

    static {
    }

    public ComboProgressAnimationViewNew(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public ComboProgressAnimationViewNew(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public final void g() {
        this.a = 0;
        this.g = false;
        HSImageView r0 = this.x;
        if (r0 == null) goto L5;
        r0.setScaleX(0.0f);
    L5:
        HSImageView r1 = this.x;
        if (r1 == null) goto L8;
        r1.setScaleY(0.0f);
    L8:
        b();
        ((LinkedHashMap) this.t).clear();
        h2 r2 = this.k;
        if (r2 == null) goto L11;
        Long r3 = Long.valueOf(r2.getId());
    L12:
        j(r3);
        View r4 = this.y;
        if (r4 == null) goto L15;
        r4.setVisibility(8);
    L15:
        AnimatorSet r5 = this.c;
        if (r5 == null) goto L18;
        com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo.c.a(r5);
    L18:
        AnimatorSet r6 = this.e;
        if (r6 == null) goto L21;
        com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo.c.a(r6);
    L21:
        AnimatorSet r7 = this.d;
        if (r7 == null) goto L24;
        com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo.c.a(r7);
    L24:
        AnimatorSet r8 = this.b;
        if (r8 == null) goto L28;
        com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo.c.a(r8);
        return;
    L28:
        return;
    L11:
        r3 = null;
        goto L12
    }

    private final com.bytedance.android.livesdk.gift.model.l getTargetGiftComboHint() {
        l1 r0 = this.m;
        if (r0 == null) goto L8;
        h2 r1 = GiftManagerKt.l(r0.getBuffGiftId());
        if (r1 != null) goto L7;
        return null;
    L7:
        return l0.a(r1);
    L8:
        h2 r2 = this.k;
        if (r2 != null) goto L11;
        return null;
    L11:
        return l0.a(r2);
    }

    public final void b() {
        AnimatorSet r0 = this.b;
        if (r0 != null) goto L5;
    L12:
        this.b = null;
        return;
    L5:
        if (r0.isRunning() != true) goto L12;
        AnimatorSet r1 = this.b;
        if (r1 == null) goto L9;
        r1.removeAllListeners();
    L9:
        AnimatorSet r2 = this.b;
        if (r2 == null) goto L12;
        r2.cancel();
        goto L12
    }

    public final void f() {
        if (this.a > this.h) goto L5;
    L12:
        Object r0 = getContext().getSystemService("vibrator");
        if (r0 == null) goto L17;
        ((Vibrator) r0).vibrate(50);
        return;
    L17:
        throw new NullPointerException("null cannot be cast to non-null type android.os.Vibrator");
    L5:
        if (this.i == true) goto L12;
        HSImageView r1 = this.x;
        if (r1 == null) goto L9;
        r1.setScaleX(0.0f);
    L9:
        HSImageView r2 = this.x;
        if (r2 == null) goto L12;
        r2.setScaleY(0.0f);
        goto L12
    }

    public final void h() {
        Disposable r0 = this.u;
        if (r0 == null) goto L5;
        r0.dispose();
    L5:
        this.u = Observable.timer(3000, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(this), f.a);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        h2 r0 = this.k;
        if (r0 == null) goto L5;
        Long r1 = Long.valueOf(r0.getId());
    L6:
        j(r1);
        super.onDetachedFromWindow();
        Disposable r2 = this.u;
        if (r2 == null) goto L10;
        r2.dispose();
        return;
    L10:
        return;
    L5:
        r1 = null;
        goto L6
    }

    private final List<com.bytedance.android.livesdk.gift.model.u> getComboHintList() {
        i12.e r0 = i12.o.b();
        if (r0 == null) goto L5;
        Object r1 = com.bytedance.android.scope.m.e.d(r0, GiftExtraRepo.class);
    L6:
        GiftExtraRepo r2 = (GiftExtraRepo) r1;
        if (r2 != null) goto L9;
        return null;
    L9:
        l1 r3 = this.m;
        if (r3 == null) goto L18;
        g0 r4 = r2.q(r3.getBuffGiftId());
        if (r4 == null) goto L18;
        ComboHintInfo r5 = r4.getComboHintInfo();
        if (r5 == null) goto L18;
        List<com.bytedance.android.livesdk.gift.model.u> r6 = r5.getComboHintList();
        if (r6 == null) goto L18;
        return r6;
    L18:
        com.bytedance.android.livesdk.gift.model.n r7 = this.n;
        if (r7 == null) goto L24;
        ComboHintInfo r8 = r7.getComboHintInfo();
        if (r8 != null) goto L23;
        return null;
    L23:
        return r8.getComboHintList();
    L24:
        h2 r9 = this.k;
        if (r9 == null) goto L33;
        g0 r10 = r2.q(r9.getId());
        if (r10 == null) goto L34;
        ComboHintInfo r11 = r10.getComboHintInfo();
        if (r11 != null) goto L31;
        return null;
    L31:
        return r11.getComboHintList();
    L34:
        return null;
    L33:
        return null;
    L5:
        r1 = null;
        goto L6
    }

    public final boolean getBanHint() {
        return this.l;
    }

    public final l1 getBuffInfo() {
        return this.m;
    }

    public final int getComboButtonStyle() {
        return this.q;
    }

    public final com.bytedance.android.livesdk.gift.model.n getDiyInfo() {
        return this.n;
    }

    public final h2 getGift() {
        return this.k;
    }

    public final void j(Long r4) {
        if (r4 == null) goto L5;
        long r0 = r4.longValue();
        String r5 = com.bytedance.android.live.revenue.core.util.f.a(l01.d.class).getCurrentUserId() + String.valueOf(r0);
        HashMap<String, Boolean> r1 = ay1.b.i();
        r1.put(r5, Boolean.valueOf(this.r));
        Intrinsics.checkNotNullParameter(r1, "<set-?>");
        ay1.b.i0.setValue(null, ay1.b.a[72], r1);
        return;
    }

    public final void setBanHint(boolean r1) {
        this.l = r1;
    }

    public final void setBuffInfo(l1 r1) {
        this.m = r1;
    }

    public final void setComboButtonStyle(int r3) {
        this.q = r3;
        View r0 = this.y;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r3 != 1) goto L7;
        Drawable r4 = s1.m(2131250730);
    L8:
        r0.setBackground(r4);
        return;
    L7:
        r4 = s1.m(2131250698);
        goto L8
    }

    public final void setDiyInfo(com.bytedance.android.livesdk.gift.model.n r1) {
        this.n = r1;
    }

    public final void setGift(h2 r9) {
        Long r0 = null;
        if (r9 == null) goto L5;
        com.bytedance.android.livesdk.gift.model.l r1 = l0.a(r9);
    L6:
        this.j.clear();
        boolean r2 = false;
        if (r1 == null) goto L11;
        List<com.bytedance.android.livesdk.gift.model.m> r3 = r1.dataList;
        if (r3 == null) goto L11;
        int r4 = r3.size();
    L12:
        if (r4 <= 0) goto L84;
        int r5 = 0;
        int r6 = 0;
    L15:
        if (r5 >= GiftManagerKt.s().size()) goto L51;
        if (r1 == null) goto L20;
        List<com.bytedance.android.livesdk.gift.model.m> r7 = r1.dataList;
        if (r7 == null) goto L20;
        int r8 = r7.size();
    L21:
        if (r6 >= r8) goto L51;
        com.bytedance.android.livesdk.gift.platform.core.model.e r10 = (com.bytedance.android.livesdk.gift.platform.core.model.e) ListProtector.get(GiftManagerKt.s(), r5);
        if (r1 == null) goto L25;
        int r11 = r1.curLeftGiftCount;
    L26:
        if (r1 == null) goto L32;
        List<com.bytedance.android.livesdk.gift.model.m> r13 = r1.dataList;
        if (r13 == null) goto L32;
        com.bytedance.android.livesdk.gift.model.m r14 = (com.bytedance.android.livesdk.gift.model.m) ListProtector.get(r13, r6);
        if (r14 == null) goto L32;
        int r15 = r14.leftGiftCount;
    L33:
        int r16 = (r11 - r15) + 1;
        int r17 = r10.comboCount;
        if (r17 < r16) goto L35;
        com.bytedance.android.livesdk.gift.platform.core.model.e r18 = new com.bytedance.android.livesdk.gift.platform.core.model.e();
        r18.comboCount = r16;
        if (r1 == null) goto L45;
        List<com.bytedance.android.livesdk.gift.model.m> r19 = r1.dataList;
        if (r19 == null) goto L45;
        com.bytedance.android.livesdk.gift.model.m r20 = (com.bytedance.android.livesdk.gift.model.m) ListProtector.get(r19, r6);
        if (r20 == null) goto L45;
        py.k r21 = r20.hintImg;
    L46:
        r18.comboEffectImg = r21;
        if (r18.comboCount <= 0) goto L49;
        this.j.add(r18);
    L49:
        r6 = r6 + 1;
    L45:
        r21 = null;
        goto L46
    L35:
        if (r17 <= 0) goto L37;
        this.j.add(r10);
    L37:
        r5 = r5 + 1;
    L32:
        r15 = 0;
        goto L33
    L25:
        r11 = 0;
    L20:
        r8 = 0;
    L51:
        if (r5 >= GiftManagerKt.s().size()) goto L56;
        com.bytedance.android.livesdk.gift.platform.core.model.e r23 = (com.bytedance.android.livesdk.gift.platform.core.model.e) ListProtector.get(GiftManagerKt.s(), r5);
        if (r23.comboCount <= 0) goto L55;
        this.j.add(r23);
    L55:
        r5 = r5 + 1;
    L56:
        if (r1 == null) goto L60;
        List<com.bytedance.android.livesdk.gift.model.m> r24 = r1.dataList;
        if (r24 == null) goto L60;
        int r25 = r24.size();
    L61:
        if (r6 >= r25) goto L85;
        if (r1 == null) goto L64;
        int r26 = r1.curLeftGiftCount;
    L65:
        if (r1 == null) goto L71;
        List<com.bytedance.android.livesdk.gift.model.m> r27 = r1.dataList;
        if (r27 == null) goto L71;
        com.bytedance.android.livesdk.gift.model.m r28 = (com.bytedance.android.livesdk.gift.model.m) ListProtector.get(r27, r6);
        if (r28 == null) goto L71;
        int r29 = r28.leftGiftCount;
    L72:
        int r30 = (r26 - r29) + 1;
        com.bytedance.android.livesdk.gift.platform.core.model.e r31 = new com.bytedance.android.livesdk.gift.platform.core.model.e();
        r31.comboCount = r30;
        if (r1 == null) goto L79;
        List<com.bytedance.android.livesdk.gift.model.m> r33 = r1.dataList;
        if (r33 == null) goto L79;
        com.bytedance.android.livesdk.gift.model.m r34 = (com.bytedance.android.livesdk.gift.model.m) ListProtector.get(r33, r6);
        if (r34 == null) goto L79;
        py.k r35 = r34.hintImg;
    L80:
        r31.comboEffectImg = r35;
        if (r31.comboCount <= 0) goto L83;
        this.j.add(r31);
    L83:
        r6 = r6 + 1;
    L79:
        r35 = null;
    L71:
        r29 = 0;
        goto L72
    L64:
        r26 = 0;
    L85:
        if (r9 == null) goto L87;
        r0 = Long.valueOf(r9.getId());
    L87:
        if (r0 == null) goto L92;
        long r36 = r0.longValue();
        Boolean r37 = ay1.b.i().get(com.bytedance.android.live.revenue.core.util.f.a(l01.d.class).getCurrentUserId() + String.valueOf(r36));
        if (r37 == null) goto L91;
        r2 = r37.booleanValue();
    L91:
        this.r = r2;
    L92:
        this.k = r9;
        return;
    L60:
        r25 = 0;
        goto L61
    L84:
        this.j.addAll(GiftManagerKt.s());
    L11:
        r4 = 0;
        goto L12
    L5:
        r1 = null;
        goto L6
    }

    public final void setGroupSend(boolean r1) {
        this.o = r1;
    }

    public final void setSeriesSend(boolean r1) {
        this.p = r1;
    }

    public static int c(int r8, List r9) {
        if (r9 == null) goto L10;
        Iterator r10 = r9.iterator();
        int r1 = 99999;
    L6:
        if (r10.hasNext() == false) goto L11;
        com.bytedance.android.livesdk.gift.model.v r2 = (com.bytedance.android.livesdk.gift.model.v) r10.next();
        if (r2.getCount() <= r8) goto L6;
        r1 = Math.min(r1, ((int) r2.getCount()) - r8);
    L11:
        if (r1 != 99999) goto L19;
        return 0;
    L19:
        return r1;
    L10:
        r1 = 99999;
        goto L11
    }

    /* JADX WARN: Type inference failed for: r11v0 */
    /* JADX WARN: Type inference failed for: r11v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r11v3 */
    public final void e(int r23, int r24) {
        int r2 = this.a;
        if (r2 != r23) goto L6;
        return;
    L6:
        if (r2 <= r23) goto L13;
        this.g = false;
        HSImageView r3 = this.x;
        if (r3 == null) goto L10;
        r3.setScaleX(0.0f);
    L10:
        HSImageView r4 = this.x;
        if (r4 == null) goto L13;
        r4.setScaleY(0.0f);
    L13:
        this.a = r23;
        if (r23 != 0) goto L16;
        return;
    L16:
        Disposable r5 = this.u;
        if (r5 != null) goto L19;
    L41:
        List<com.bytedance.android.livesdk.gift.model.u> r6 = getComboHintList();
        h2 r8 = this.k;
        if (r8 == null) goto L44;
        long r9 = r8.getPrimaryEffectId();
    L45:
        ?? r11 = 1;
        if (this.p == true) goto L203;
        if (this.l == true) goto L203;
        if (r6 == null) goto L203;
        Iterator r7 = r6.iterator();
    L52:
        if (r7.hasNext() == false) goto L203;
        com.bytedance.android.livesdk.gift.model.u r10 = (com.bytedance.android.livesdk.gift.model.u) r7.next();
        int r13 = r10.getComboHintScene();
        int r14 = ComboHintScene.SEND_TOGETHER.getScene();
        String r15 = BuildConfig.FLAVOR;
        if (r13 != r14) goto L133;
        ArrayList r16 = new ArrayList();
        GiftContext r17 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r17 == null) goto L62;
        com.bytedance.live.datacontext.m<Boolean> r18 = r17.isIntercept();
        if (r18 == null) goto L62;
        Boolean r19 = (Boolean) r18.getValue();
        if (r19 == null) goto L62;
        boolean r110 = r19.booleanValue();
    L63:
        GiftContext r111 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r111 == null) goto L72;
        com.bytedance.live.datacontext.n<i02.a> r112 = r111.getCurrentSendTogetherInfo();
        if (r112 == null) goto L72;
        i02.a r113 = (i02.a) r112.getValue();
        if (r113 == null) goto L72;
        Integer r114 = r113.c;
        if (r114 == null) goto L72;
        int r115 = r114.intValue();
    L73:
        GiftContext r116 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r116 == null) goto L80;
        com.bytedance.live.datacontext.n<i02.a> r117 = r116.getCurrentSendTogetherInfo();
        if (r117 == null) goto L80;
        i02.a r20 = (i02.a) r117.getValue();
        if (r20 == null) goto L80;
        List<i02.e> r21 = r20.b;
    L81:
        if (r21 == null) goto L86;
        Iterator<T> r25 = r21.iterator();
    L84:
        if (r25.hasNext() == false) goto L86;
        r16.addAll(((i02.e) r25.next()).a);
    L86:
        boolean r26 = r16.contains(Integer.valueOf((int) r9));
        if (r110 == true) goto L99;
        if (r26 == false) goto L99;
        GiftContext r27 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r27 == null) goto L97;
        com.bytedance.live.datacontext.m<Integer> r28 = r27.getMsgCount();
        if (r28 == null) goto L97;
        Integer r29 = (Integer) r28.getValue();
        if (r29 == null) goto L97;
        int r30 = r29.intValue();
    L98:
        int r118 = r115 + r30;
    L100:
        List<com.bytedance.android.livesdk.gift.model.v> r31 = r10.getComboHintData();
        if (r31 == null) goto L133;
        int r33 = r31.size();
        int r119 = 0;
    L103:
        if (r119 >= r33) goto L133;
        com.bytedance.android.livesdk.gift.model.v r120 = (com.bytedance.android.livesdk.gift.model.v) ListProtector.get(r31, r119);
        if (r120.getComboHintType() == ComboHintType.COMMON.getType()) goto L107;
        int r121 = r33;
        if (r120.getComboHintType() != ComboHintType.FIRST_TIME.getType()) goto L131;
        if (this.r == true) goto L131;
        this.r = r11;
        h2 r34 = this.k;
        if (r34 == null) goto L125;
        Long r35 = Long.valueOf(r34.getId());
    L126:
        j(r35);
        if (this.o == true) goto L131;
        this.v = r120;
        this.w = r10;
        d(r120, 0, 3, BuildConfig.FLAVOR);
        h();
        return;
    L125:
        r35 = null;
    L131:
        r119 = r119 + 1;
        r33 = r121;
        goto L103
    L107:
        if (((r118 + r23) - r24) != (r120.getCount() - 1)) goto L116;
        r121 = r33;
        Boolean r36 = (Boolean) ((LinkedHashMap) this.t).get(Integer.valueOf((int) r120.getCount()));
        if (r36 == null) goto L111;
        boolean r37 = r36.booleanValue();
    L112:
        if (r37 == true) goto L131;
        this.r = r11;
        this.t.put(Integer.valueOf((int) r120.getCount()), Boolean.TRUE);
        d(r120, 0, 3, BuildConfig.FLAVOR);
        this.v = r120;
        this.w = r10;
        h();
        return;
    L111:
        r37 = false;
        goto L112
    L116:
        r121 = r33;
    L97:
        r30 = 0;
    L99:
        r118 = 0;
    L80:
        r21 = null;
    L72:
        r115 = 0;
    L62:
        r110 = false;
    L133:
        if (r10.getComboHintScene() != ComboHintScene.SEND_GOLD.getScene()) goto L200;
        List<com.bytedance.android.livesdk.gift.model.v> r38 = r10.getComboHintData();
        if (r38 == null) goto L200;
        int r39 = r38.size() - r11;
        if (r39 < 0) goto L200;
        int r40 = 0;
    L139:
        com.bytedance.android.livesdk.gift.model.v r41 = (com.bytedance.android.livesdk.gift.model.v) ListProtector.get(r38, r40);
        if (r41.getComboHintType() != ComboHintType.COMMON.getType()) goto L150;
        if (r23 == ((int) r41.getCount())) goto L143;
    L197:
        Iterator r122 = r7;
    L198:
        if (r40 == r39) goto L201;
        r40 = r40 + 1;
        r7 = r122;
    L201:
        r7 = r122;
        r11 = 1;
        goto L52
    L143:
        int r1 = c(r23, r10.getComboHintData());
        String r43 = r41.getName();
        if (r43 == null) goto L147;
        r15 = r43;
    L147:
        d(r41, r1, 4, r15);
        this.v = r41;
        this.w = r10;
        h();
        return;
    L150:
        if (r41.getComboHintType() != ComboHintType.FIRST_TIME.getType()) goto L197;
        h2 r123 = this.k;
        if (r123 == null) goto L154;
        Long r124 = Long.valueOf(r123.getId());
    L156:
        if (r124 == null) goto L172;
        r124.longValue();
        int r125 = Calendar.getInstance().get(6);
        HashMap<Long, Pair<Integer, Integer>> r44 = ay1.b.r();
        if (r44 != null) goto L160;
    L159:
        r122 = r7;
    L171:
        boolean r45 = true;
    L174:
        if (r45 == false) goto L198;
        if (this.s == true) goto L198;
        this.s = true;
        String r46 = r41.getName();
        if (r46 == null) goto L182;
        r15 = r46;
    L182:
        d(r41, 0, 4, r15);
        this.v = r41;
        this.w = r10;
        h();
        h2 r47 = this.k;
        if (r47 == null) goto L185;
        Long r48 = Long.valueOf(r47.getId());
    L186:
        if (r48 == null) goto L297;
        r48.longValue();
        int r49 = Calendar.getInstance().get(6);
        HashMap<Long, Pair<Integer, Integer>> r50 = ay1.b.r();
        Pair<Integer, Integer> r51 = r50.get(r48);
        if (r51 != null) goto L191;
        r51 = new Pair(Integer.valueOf(r49), 0);
    L191:
        if (((Number) r51.getFirst()).intValue() == r49) goto L193;
        Pair<Integer, Integer> r53 = new Pair(Integer.valueOf(r49), 1);
    L194:
        r50.put(r48, r53);
        Intrinsics.checkNotNullParameter(r50, "<set-?>");
        ay1.b.o0.setValue(null, ay1.b.a[79], r50);
        return;
    L193:
        r53 = new Pair(Integer.valueOf(r49), Integer.valueOf(((Number) r51.getSecond()).intValue() + 1));
        goto L194
    L297:
        return;
    L185:
        r48 = null;
        goto L186
    L160:
        Pair<Integer, Integer> r54 = r44.get(r124);
        if (r54 == null) goto L159;
        r122 = r7;
        Integer r55 = (Integer) ((HashMap) nz1.a.M.getValue(null, nz1.a.a[37])).get(r124);
        if (r55 != null) goto L166;
        r55 = 3;
    L166:
        int r56 = r55.intValue();
        if (((Number) r54.getFirst()).intValue() != r125) goto L171;
        if (((Number) r54.getSecond()).intValue() <= r56) goto L171;
    L173:
        r45 = false;
        goto L174
    L172:
        r122 = r7;
        goto L173
    L154:
        r124 = null;
    L200:
        r122 = r7;
    L203:
        if (this.f == true) goto L216;
        if (this.l == true) goto L216;
        com.bytedance.android.livesdk.gift.model.l r57 = getTargetGiftComboHint();
        if (r57 == null) goto L216;
        Iterator<com.bytedance.android.livesdk.gift.model.m> r58 = r57.dataList.iterator();
    L210:
        if (r58.hasNext() == false) goto L216;
        com.bytedance.android.livesdk.gift.model.m r59 = r58.next();
        if (r59.leftGiftCount != ((r57.curLeftGiftCount - r23) + 1)) goto L210;
        ImageLoader.bindImage(this.x, r59.hintImg, new c(r57, r59, this));
        return;
    L216:
        if (this.q == 0) goto L218;
    L231:
        TextView r60 = this.z;
        if (r60 == null) goto L234;
        r60.setText(String.valueOf(r23));
    L234:
        View r61 = this.y;
        if (r61 != null) goto L237;
    L238:
        AnimatorSet r63 = this.c;
        if (r63 == null) goto L243;
        boolean r64 = true;
        if (r63.isRunning() != true) goto L244;
    L275:
        i(0, false);
        return;
    L244:
        AnimatorSet r65 = this.b;
        if (r65 != null) goto L247;
    L249:
        AnimatorSet r66 = this.e;
        if (r66 == null) goto L252;
        com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo.c.a(r66);
    L252:
        AnimatorSet r67 = this.d;
        if (r67 == null) goto L255;
        com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo.c.a(r67);
    L255:
        TextView r68 = this.z;
        if (r68 == null) goto L258;
        r68.setVisibility(0);
    L258:
        View r69 = this.y;
        if (r69 == null) goto L261;
        r69.setAlpha(1.0f);
    L261:
        TextView r70 = this.z;
        if (r70 == null) goto L275;
        AnimatorSet r71 = com.bytedance.android.live.revenue.common.e.c(r70, new float[]{r70.getScaleX(), 1.2f});
        r71.setDuration(50);
        AnimatorSet r73 = com.bytedance.android.live.revenue.common.e.c(r70, new float[]{1.2f, 1.0f});
        r73.setDuration(200);
        r73.setStartDelay(50);
        r73.setInterpolator(new PathInterpolator(0.42f, 0.0f, 0.58f, 1.0f));
        ObjectAnimator r74 = ObjectAnimator.ofFloat(this.y, "alpha", new float[]{1.0f, 0.0f});
        r74.setDuration(250);
        r74.setStartDelay(1000);
        this.e = new AnimatorSet();
        AnimatorSet r75 = new AnimatorSet();
        com.bytedance.android.live.revenue.common.e.a(r75, new ComboProgressAnimationViewNew$startComboCountContinueAnimation$$inlined$let$lambda$1(this));
        Unit r76 = Unit.INSTANCE;
        this.d = r75;
        AnimatorSet r77 = this.e;
        if (r77 == null) goto L266;
        r77.playTogether(new Animator[]{r71, r73});
    L266:
        AnimatorSet r78 = this.d;
        if (r78 == null) goto L269;
        r78.play(r74);
    L269:
        AnimatorSet r79 = this.e;
        if (r79 == null) goto L272;
        r79.start();
    L272:
        AnimatorSet r80 = this.d;
        if (r80 == null) goto L275;
        r80.start();
        goto L275
    L247:
        if (r65.isRunning() != r64) goto L249;
    L243:
        r64 = true;
        goto L244
    L237:
        if (r61.getVisibility() == 8) goto L275;
    L218:
        if (this.l == true) goto L231;
        int r81 = GiftManagerKt.s().size();
        int r83 = 0;
    L220:
        if (r83 >= r81) goto L231;
        if (this.f == true) goto L231;
        com.bytedance.android.livesdk.gift.platform.core.model.e r84 = (com.bytedance.android.livesdk.gift.platform.core.model.e) ListProtector.get(GiftManagerKt.s(), r83);
        if (r23 == r84.comboCount) goto L226;
        r83 = r83 + 1;
        goto L220
    L226:
        if (r83 != (GiftManagerKt.s().size() - 1)) goto L228;
        boolean r85 = true;
    L229:
        this.g = r85;
        ImageLoader.bindImage(this.x, r84.comboEffectImg, new d(this));
        goto L231
    L228:
        r85 = false;
        goto L229
    L44:
        r9 = -1;
        goto L45
    L19:
        if (r5.isDisposed() == true) goto L41;
        com.bytedance.android.livesdk.gift.model.v r86 = this.v;
        if (r86 == null) goto L41;
        h2 r87 = this.k;
        if (r87 == null) goto L25;
        Long r88 = Long.valueOf(r87.getId());
    L26:
        com.bytedance.android.livesdk.gift.model.u r89 = this.w;
        if (r89 == null) goto L29;
        List<com.bytedance.android.livesdk.gift.model.v> r90 = r89.getComboHintData();
    L30:
        int r91 = c(r23, r90);
        com.bytedance.android.livesdk.gift.model.u r126 = this.w;
        if (r126 != null) goto L33;
    L35:
        if (r126 != null) goto L37;
    L39:
        int r127 = 0;
    L40:
        com.bytedance.android.livesdk.gift.platform.core.utils.h.n(r88, r91, Integer.valueOf(r127), r86.getName(), r86.getName());
        goto L41
    L37:
        if (r126.getComboHintScene() != ComboHintScene.SEND_GOLD.getScene()) goto L39;
        r127 = 4;
        goto L40
    L33:
        if (r126.getComboHintScene() != ComboHintScene.SEND_TOGETHER.getScene()) goto L35;
        r127 = 3;
        goto L40
    L29:
        r90 = null;
        goto L30
    L25:
        r88 = null;
        goto L26
    }

    public final void i(final long r11, boolean r13) {
        View r0 = this.y;
        if (r0 == null) goto L7;
        if (r0.getVisibility() != 0) goto L7;
        return;
    L7:
        if (r13 == true) goto L13;
        AnimatorSet r14 = this.b;
        if (r14 == null) goto L13;
        if (r14.isRunning() != true) goto L13;
        return;
    L13:
        AnimatorSet r15 = this.d;
        if (r15 == null) goto L16;
        com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo.c.a(r15);
    L16:
        View r16 = this.y;
        if (r16 == null) goto L32;
        AnimatorSet r2 = com.bytedance.android.live.revenue.common.e.c(r16, new float[]{0.0f, 1.05f});
        r2.setDuration(250);
        r2.setStartDelay(r11);
        r2.setInterpolator(new PathInterpolator(0.32f, 0.94f, 0.6f, 1.0f));
        AnimatorSet r5 = com.bytedance.android.live.revenue.common.e.c(r16, new float[]{1.05f, 1.0f});
        r5.setDuration(200);
        ObjectAnimator r6 = ObjectAnimator.ofFloat(r16, "alpha", new float[]{0.0f, 1.0f});
        r6.setDuration(250);
        r6.setStartDelay(r11);
        ObjectAnimator r17 = ObjectAnimator.ofFloat(r16, "alpha", new float[]{1.0f, 0.0f});
        r17.setDuration(250);
        r17.setStartDelay(1000 + r11);
        AnimatorSet r3 = new AnimatorSet();
        r3.playSequentially(new Animator[]{r2, r5});
        AnimatorSet r4 = new AnimatorSet();
        Function1<Animator, Unit> r7 = new ComboProgressAnimationViewNew$startComboContainerShowAnimator$$inlined$let$lambda$1(this, r11);
        Intrinsics.checkNotNullParameter(r4, "$this$doOnStart");
        Intrinsics.checkNotNullParameter(r7, "callback");
        r4.addListener(new com.bytedance.android.live.revenue.common.d(r7));
        Unit r8 = Unit.INSTANCE;
        this.c = r4;
        AnimatorSet r9 = new AnimatorSet();
        com.bytedance.android.live.revenue.common.e.a(r9, new ComboProgressAnimationViewNew$startComboContainerShowAnimator$$inlined$let$lambda$2(this, r11));
        this.d = r9;
        AnimatorSet r18 = this.c;
        if (r18 == null) goto L21;
        r18.playTogether(new Animator[]{r3, r6});
    L21:
        AnimatorSet r19 = this.d;
        if (r19 == null) goto L24;
        r19.play(r17);
    L24:
        AnimatorSet r110 = this.c;
        if (r110 == null) goto L27;
        r110.start();
    L27:
        AnimatorSet r111 = this.d;
        if (r111 == null) goto L33;
        r111.start();
        return;
    L33:
        return;
    }

    public ComboProgressAnimationViewNew(Context r3, AttributeSet r4, int r5) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3, r4, r5);
        ArrayList<com.bytedance.android.livesdk.gift.platform.core.model.e> r6 = new ArrayList();
        this.j = r6;
        this.t = new LinkedHashMap();
        LayoutInflater.from(r3).inflate(2131565229, this);
        this.x = findViewById(2131387073);
        this.y = findViewById(2131367239);
        TextView r7 = (TextView) findViewById(2131367236);
        this.z = r7;
        int r0 = GiftManagerKt.s().size();
        if (r0 <= 0) goto L6;
        this.h = ((com.bytedance.android.livesdk.gift.platform.core.model.e) ListProtector.get(GiftManagerKt.s(), r0 - 1)).comboCount;
    L6:
        if (r6.isEmpty() == false) goto L15;
        r6.addAll(GiftManagerKt.s());
    L15:
        Typeface r8 = Typeface.createFromAsset(r3.getAssets(), "font/ttlive_gift_combo_opt.ttf");     // Catch: Exception -> L12
        if (r7 == null) goto L17;
        r7.setTypeface(r8);     // Catch: Exception -> L12
        return;
    L17:
        return;
    L12:
        e = move-exception;
        e.printStackTrace();
        jy0.b.c("ComboProgressAnimationViewNew", "load font asset exception: " + e.getMessage(), null, 4);
    }

    public static final void a(final ComboProgressAnimationViewNew r16, final boolean r17, final boolean r18) {
        r16.i = r17;
        r16.b();
        AnimatorSet r3 = r16.e;
        if (r3 == null) goto L5;
        com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo.c.a(r3);
    L5:
        AnimatorSet r4 = r16.c;
        if (r4 == null) goto L8;
        com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo.c.a(r4);
    L8:
        AnimatorSet r5 = r16.d;
        if (r5 == null) goto L11;
        com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo.c.a(r5);
    L11:
        HSImageView r6 = r16.x;
        View r7 = r16.y;
        if (r6 == null) goto L28;
        if (r7 == null) goto L29;
        TextView r8 = r16.z;
        if (r8 == null) goto L17;
        r8.setScaleX(1.0f);
    L17:
        TextView r9 = r16.z;
        if (r9 == null) goto L20;
        r9.setScaleY(1.0f);
    L20:
        HSImageView r10 = r16.x;
        if (r10 == null) goto L23;
        r10.setScaleX(0.0f);
    L23:
        HSImageView r11 = r16.x;
        if (r11 == null) goto L26;
        r11.setScaleY(1.0f);
    L26:
        AnimatorSet r13 = com.bytedance.android.live.revenue.common.e.c(r7, new float[]{1.0f, 0.0f});
        r13.setDuration(150);
        r13.setInterpolator(new PathInterpolator(0.26f, 0.0f, 0.6f, 0.2f));
        com.bytedance.android.live.revenue.common.e.a(r13, new ComboProgressAnimationViewNew$startSpecialComboAnimation$$inlined$lets$lambda$1(r16, r18, r17));
        AnimatorSet r14 = com.bytedance.android.live.revenue.common.e.c(r6, new float[]{0.0f, 1.05f});
        r14.setStartDelay(100);
        r14.setDuration(250);
        r14.setInterpolator(new PathInterpolator(0.32f, 0.94f, 0.6f, 1.0f));
        AnimatorSet r15 = com.bytedance.android.live.revenue.common.e.c(r6, new float[]{1.05f, 1.0f});
        r15.setDuration(200);
        r15.setStartDelay(350);
        ObjectAnimator r19 = ObjectAnimator.ofFloat(r6, "alpha", new float[]{0.0f, 1.0f});
        r19.setStartDelay(100);
        r19.setDuration(250);
        AnimatorSet r20 = com.bytedance.android.live.revenue.common.e.c(r6, new float[]{1.0f, 0.0f});
        r20.setDuration(150);
        r20.setStartDelay(1100);
        r20.setInterpolator(new PathInterpolator(0.26f, 0.0f, 0.6f, 0.2f));
        AnimatorSet r21 = new AnimatorSet();
        r21.playTogether(new Animator[]{r13, r14, r15, r19, r20});
        r21.addListener(new j(r16, r18, r17));
        Unit r1 = Unit.INSTANCE;
        r16.b = r21;
        r21.start();
        return;
    L29:
        return;
    }

    public /* synthetic */ ComboProgressAnimationViewNew(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }

    public final void d(com.bytedance.android.livesdk.gift.model.v r10, int r11, int r13, String r14) {
        Intrinsics.checkNotNullParameter(r10, "each");
        Intrinsics.checkNotNullParameter(r14, "showTime");
        ImageLoader.bindImage(this.x, r10.getHintImg(), new b(this, r11, r14, r13, r10));
    }
}
