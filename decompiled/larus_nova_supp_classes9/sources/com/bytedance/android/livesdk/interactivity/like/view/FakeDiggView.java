package com.bytedance.android.livesdk.interactivity.like.view;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Path;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.config.PerformanceTestSettings;
import com.bytedance.android.livesdk.interactivity.like.barrage.DiggController;
import com.bytedance.android.livesdkapi.view.IFakeDiggView;
import com.bytedance.bdlocation.BuildConfig;
import com.ss.ugc.live.barrage.controller.AbsBarrageController;
import com.ss.ugc.live.barrage.view.BarrageLayout;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002:\u0002\u0012\u0013B%\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011R#\u0010\t\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00038BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/like/view/FakeDiggView;", "Landroid/widget/FrameLayout;", "Lcom/bytedance/android/livesdkapi/view/IFakeDiggView;", "Lcom/ss/ugc/live/barrage/view/BarrageLayout;", "kotlin.jvm.PlatformType", "d", "Lkotlin/Lazy;", "getMBarrageLayout", "()Lcom/ss/ugc/live/barrage/view/BarrageLayout;", "mBarrageLayout", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", BuildConfig.FLAVOR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "b", "interactivity-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class FakeDiggView extends FrameLayout implements IFakeDiggView {
    public static final /* synthetic */ int f = 0;
    public final SparseArray<Bitmap> a;
    public final ArrayList<Integer> b;
    public final b c;
    public final Lazy d;
    public Disposable e;

    public static abstract class a {
        public a() {
        }
    }

    public final class b extends a {
        public DiggController a;
        public final /* synthetic */ FakeDiggView b;

        public b(FakeDiggView r1) {
            this.b = r1;
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ FakeDiggView a;

        public c(FakeDiggView r1) {
            this.a = r1;
        }

        public final void accept(Object r7) {
            Long r8 = (Long) r7;
            b r9 = this.a.c;
            r9.getClass();
            if (((Boolean) PerformanceTestSettings.TEST_DISABLE_DIGG.getValue()).booleanValue() == true) goto L31;
            DiggController r0 = r9.a;
            if (r0 != null) goto L8;
            Intrinsics.throwUninitializedPropertyAccessException("diggController");
        L8:
            String.valueOf(r0.r());
            DiggController r1 = r9.a;
            if (r1 != null) goto L12;
            Intrinsics.throwUninitializedPropertyAccessException("diggController");
        L12:
            if (r1.r() >= 10) goto L32;
            FakeDiggView r2 = r9.b;
            int r3 = FakeDiggView.f;
            Bitmap r4 = null;
            Resources r5 = null;
            if (r2.getContext() == null) goto L24;
            int r6 = ((Number) CollectionsKt.random(r2.b, Random.Default)).intValue();
            Bitmap r10 = r2.a.get(r6);
            if (r10 != null) goto L23;
            Context r11 = r2.getContext();
            if (r11 == null) goto L22;
            r5 = r11.getResources();
        L22:
            BitmapFactory.Options r13 = new BitmapFactory.Options();
            r13.inPreferredConfig = Bitmap.Config.ARGB_4444;
            Unit r14 = Unit.INSTANCE;
            r4 = BitmapFactory.decodeResource(r5, r6, r13);
            r2.a.put(r6, r4);
            goto L24
        L23:
            r4 = r10;
        L24:
            if (r4 == null) goto L30;
            Random.Default r15 = Random.Default;
            int r16 = r15.nextInt(s1.f(30.0f), s1.f(37.0f));
            Bitmap r17 = Bitmap.createScaledBitmap(r4, r16, r16, false);
            DiggController r18 = r9.a;
            if (r18 != null) goto L28;
            Intrinsics.throwUninitializedPropertyAccessException("diggController");
        L28:
            r15.nextDouble();
            r18.a(new com.bytedance.android.livesdk.interactivity.like.barrage.a(r17), false);
            return;
        L30:
            return;
        L32:
            return;
        }
    }

    private final BarrageLayout getMBarrageLayout() {
        return (BarrageLayout) this.d.getValue();
    }

    public final void start() {
        DiggController r0 = this.c.a;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("diggController");
    L5:
        r0.n();
        Disposable r1 = this.e;
        if (r1 == null) goto L8;
        r1.dispose();
    L8:
        this.e = du2.a.b(0, 250, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new c(this));
    }

    public final void stop() {
        DiggController r0 = this.c.a;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("diggController");
    L5:
        r0.l();
        Disposable r1 = this.e;
        if (r1 == null) goto L9;
        r1.dispose();
        return;
    }

    public FakeDiggView(Context r7, AttributeSet r8, int r9) {
        Intrinsics.checkNotNullParameter(r7, "context");
        super(r7, r8, r9);
        this.a = new SparseArray();
        this.b = new ArrayList();
        this.c = new b(this);
        this.d = LazyKt.lazy(new FakeDiggView$mBarrageLayout$2(this));
        View.inflate(r7, 2131566646, this);
        TypedArray r10 = r7.getResources().obtainTypedArray(2130903116);
        int r11 = r10.length();
        int r0 = 0;
    L3:
        if (r0 >= r11) goto L5;
        this.b.add(Integer.valueOf(r10.getResourceId(r0, 0)));
        r0 = r0 + 1;
        goto L3
    L5:
        r10.recycle();
        b r13 = this.c;
        r13.getClass();
        r13.a = new DiggController(r13.b.getMBarrageLayout(), 3000);
        BarrageLayout r14 = r13.b.getMBarrageLayout();
        DiggController r1 = r13.a;
        if (r1 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("diggController");
    L8:
        r14.a(r1);
        int r15 = 0;
    L10:
        if (r15 >= 10) goto L15;
        Random.Default.nextInt(-20, 20);
        s1.f(37.0f);
        float r2 = s1.f(20.0f);
        Path r3 = new Path();
        r3.moveTo(r2, s1.f(180.0f));
        r3.quadTo(r2, s1.f(10.0f), r2, s1.f(30.0f));
        DiggController r4 = r13.a;
        if (r4 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("diggController");
    L14:
        r4.getClass();
        Intrinsics.checkNotNullParameter(r3, "path");
        com.bytedance.android.livesdk.interactivity.like.barrage.d r5 = new com.bytedance.android.livesdk.interactivity.like.barrage.d(r4.t, r3, r4.n);
        ((AbsBarrageController) r5).h = false;
        ((AbsBarrageController) r4).h = false;
        ((AbsBarrageController) r5).g = false;
        r4.o.add(r5);
        r4.t.a(r5);
        r15 = r15 + 1;
        goto L10
    L15:
        setClipChildren(false);
    }
}
