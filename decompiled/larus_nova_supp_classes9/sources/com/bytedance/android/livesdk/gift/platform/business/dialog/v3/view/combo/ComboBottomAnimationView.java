package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.view.combo;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import com.airbnb.lottie.LottieAnimationView;
import com.bytedance.android.live.core.utils.rxutils.j;
import com.bytedance.bdlocation.BuildConfig;
import com.larus.apm.impl.protector.RunnableProtector;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\nB'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/view/combo/ComboBottomAnimationView;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", BuildConfig.FLAVOR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ComboBottomAnimationView extends FrameLayout {
    public Map<Integer, View> a;
    public Disposable b;
    public boolean c;
    public boolean d;
    public boolean e;
    public float f;

    public static final class a {
    }

    public static final class b implements Runnable {
        public final /* synthetic */ View a;
        public final /* synthetic */ ComboBottomAnimationView b;

        public b(View r1, ComboBottomAnimationView r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            ComboBottomAnimationView r0 = this.b;     // Catch: Throwable -> L4
            r0.e = true;     // Catch: Throwable -> L4
            r0.f = this.a.getHeight();     // Catch: Throwable -> L4
            this.a.setTranslationY(this.b.f);     // Catch: Throwable -> L4
            this.a.setVisibility(0);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ ComboBottomAnimationView a;

        public c(ComboBottomAnimationView r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            Long r4 = (Long) r3;
            View r5 = new LottieAnimationView(this.a.getContext());
            FrameLayout r0 = (FrameLayout) this.a.a(2131367234);
            if (r0 == null) goto L5;
            r0.addView(r5);
        L5:
            this.a.post(new com.bytedance.android.livesdk.gift.platform.business.dialog.v3.view.combo.a(this, r5));
            r5.playAnimation();
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

    public static final class e implements Action {
        public static final e a = null;

        static {
            a = new e();
        }

        public e() {
        }

        public final void run() {
        }
    }

    static {
    }

    public ComboBottomAnimationView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public ComboBottomAnimationView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public final View a(int r3) {
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

    public final void b(int r6) {
        if (r6 >= 188) goto L18;
        Disposable r7 = this.b;
        if (r7 == null) goto L7;
        r7.dispose();
    L7:
        this.c = false;
        this.d = false;
        this.e = false;
        FrameLayout r8 = (FrameLayout) a(2131367234);
        if (r8 == null) goto L10;
        r8.removeAllViews();
    L10:
        View r9 = a(2131367233);
        if (r9 == null) goto L13;
        r9.setVisibility(4);
    L13:
        View r10 = a(2131367233);
        if (r10 == null) goto L40;
        r10.setTranslationY(0.0f);
        return;
    L40:
        return;
    L18:
        if (188 > r6) goto L29;
        if (520 < r6) goto L29;
        if (this.e == true) goto L26;
        View r1 = a(2131367233);
        if (r1 == null) goto L26;
        r1.post(new b(r1, this));
    L26:
        float r3 = this.f;
        float r4 = r3 - (((r6 - 188) / 332) * r3);
        View r0 = a(2131367233);
        if (r0 == null) goto L29;
        r0.setTranslationY(r4);
    L29:
        boolean r2 = this.c;
        if (r2 == true) goto L33;
        if (r6 < 520) goto L33;
        this.c = true;
        c(3000);
        return;
    L33:
        if (r2 == true) goto L35;
        return;
    L35:
        if (this.d == false) goto L37;
        return;
    L37:
        if (r6 < 1314) goto L44;
        this.d = true;
        c(2000);
        return;
    }

    public final void c(long r4) {
        Disposable r0 = this.b;
        if (r0 == null) goto L5;
        r0.dispose();
    L5:
        j.a r1 = j.a;
        this.b = j.a(0, r4, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new c(this), d.a, e.a);
    }

    public ComboBottomAnimationView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.a = new LinkedHashMap();
        LayoutInflater.from(r2).inflate(2131565227, this);
    }

    public /* synthetic */ ComboBottomAnimationView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
