package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.view.combo;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.airbnb.lottie.LottieAnimationView;
import com.bytedance.android.live.core.utils.rxutils.j;
import com.bytedance.bdlocation.BuildConfig;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u0003B'\b\u0007\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0014\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0002¢\u0006\u0004\b\u0017\u0010\u0018R\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\u0011\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/view/combo/ComboEffectAnimationView;", "Landroid/widget/FrameLayout;", BuildConfig.FLAVOR, "a", "I", "getCombo", "()I", "setCombo", "(I)V", "combo", "Lio/reactivex/disposables/Disposable;", "b", "Lio/reactivex/disposables/Disposable;", "getDisposable", "()Lio/reactivex/disposables/Disposable;", "setDisposable", "(Lio/reactivex/disposables/Disposable;)V", "disposable", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ComboEffectAnimationView extends FrameLayout {
    public static final /* synthetic */ int c = 0;
    public int a;
    public Disposable b;

    public static final class a {
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ ComboEffectAnimationView a;

        public b(ComboEffectAnimationView r1) {
            this.a = r1;
        }

        public final void accept(Object r5) {
            Long r6 = (Long) r5;
            ComboEffectAnimationView r7 = this.a;
            int r0 = ComboEffectAnimationView.c;
            r7.getClass();
            Ref.ObjectRef r1 = new Ref.ObjectRef();
            r1.element = "combo/ttlive_gift_combo_effect_level4.json";
            int r2 = r7.a;
            if (1 > r2) goto L9;
            if (66 < r2) goto L9;
            r1.element = "combo/ttlive_gift_combo_effect_level1.json";
        L26:
            LottieAnimationView r3 = new LottieAnimationView(r7.getContext());
            r7.addView(r3);
            r7.post(new b02.b(r7, r3, r1));
            return;
        L9:
            if (67 > r2) goto L15;
            if (188 < r2) goto L15;
            r1.element = "combo/ttlive_gift_combo_effect_level2.json";
        L15:
            if (189 > r2) goto L21;
            if (520 < r2) goto L21;
            r1.element = "combo/ttlive_gift_combo_effect_level3.json";
        L21:
            if (521 > r2) goto L26;
            if (1314 < r2) goto L26;
            r1.element = "combo/ttlive_gift_combo_effect_level4.json";
            goto L26
        }
    }

    public static final class c<T> implements Consumer {
        public static final c a = null;

        static {
            a = new c();
        }

        public c() {
        }

        public final /* bridge */ /* synthetic */ void accept(Object r1) {
            Throwable r2 = (Throwable) r1;
        }
    }

    public static final class d implements Action {
        public static final d a = null;

        static {
            a = new d();
        }

        public d() {
        }

        public final void run() {
        }
    }

    static {
    }

    public ComboEffectAnimationView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public ComboEffectAnimationView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public final int getCombo() {
        return this.a;
    }

    public final Disposable getDisposable() {
        return this.b;
    }

    public final void a(int r3) {
        this.a = r3;
        if (r3 != 0) goto L5;
        Disposable r4 = this.b;
        if (r4 == null) goto L17;
        r4.dispose();
        return;
    L17:
        return;
    L5:
        if (r3 != 1) goto L7;
        b(2000);
        return;
    L7:
        if (r3 != 1315) goto L18;
        b(1000);
        return;
    }

    public final void b(long r4) {
        Disposable r0 = this.b;
        if (r0 == null) goto L5;
        r0.dispose();
    L5:
        j.a r1 = j.a;
        this.b = j.a(0, r4, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new b(this), c.a, d.a);
    }

    public final void setCombo(int r1) {
        this.a = r1;
    }

    public final void setDisposable(Disposable r1) {
        this.b = r1;
    }

    public ComboEffectAnimationView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
    }

    public /* synthetic */ ComboEffectAnimationView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
