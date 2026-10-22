package com.bytedance.android.livesdk.interactivity.api.highlight.indicator;

import android.content.Context;
import android.database.DataSetObserver;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.aweme.debug.LocalTestManager;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b&\u0018\u00002\u00020\u0001:\u0001>B'\b\u0007\u0012\u0006\u00108\u001a\u000207\u0012\n\b\u0002\u0010:\u001a\u0004\u0018\u000109\u0012\b\b\u0002\u0010;\u001a\u00020\u0013¢\u0006\u0004\b<\u0010=J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R*\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00068\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR*\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00068\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\t\u001a\u0004\b\u0010\u0010\u000b\"\u0004\b\u0011\u0010\rR*\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u0007\u001a\u00020\u00138\u0006@FX\u0087\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R*\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00068\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\t\u001a\u0004\b\u001c\u0010\u000b\"\u0004\b\u001d\u0010\rR\"\u0010&\u001a\u00020\u001f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R*\u0010*\u001a\u00020\u00132\u0006\u0010\u0007\u001a\u00020\u00138\u0006@FX\u0087\u000e¢\u0006\u0012\n\u0004\b'\u0010\u0015\u001a\u0004\b(\u0010\u0017\"\u0004\b)\u0010\u0019R*\u0010.\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00068\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b+\u0010\t\u001a\u0004\b,\u0010\u000b\"\u0004\b-\u0010\rR$\u00106\u001a\u0004\u0018\u00010/8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b0\u00101\u001a\u0004\b2\u00103\"\u0004\b4\u00105¨\u0006?"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/highlight/indicator/DuxBaseIndicator;", "Landroid/widget/FrameLayout;", "Landroidx/viewpager/widget/ViewPager;", "viewPager", BuildConfig.FLAVOR, "setViewPager", BuildConfig.FLAVOR, "value", "b", "F", "getDotsSize", "()F", "setDotsSize", "(F)V", "dotsSize", "c", "getDotsSpacing", "setDotsSpacing", "dotsSpacing", BuildConfig.FLAVOR, "d", "I", "getDotsColor", "()I", "setDotsColor", "(I)V", "dotsColor", "e", "getDotsCornerRadius", "setDotsCornerRadius", "dotsCornerRadius", BuildConfig.FLAVOR, "f", "Z", "getDotsClickable", "()Z", "setDotsClickable", "(Z)V", "dotsClickable", "g", "getDotsStrokeColor", "setDotsStrokeColor", "dotsStrokeColor", "h", "getDotsStrokeWidth", "setDotsStrokeWidth", "dotsStrokeWidth", "Lcom/bytedance/android/livesdk/interactivity/api/highlight/indicator/DuxBaseIndicator$a;", "i", "Lcom/bytedance/android/livesdk/interactivity/api/highlight/indicator/DuxBaseIndicator$a;", "getPager", "()Lcom/bytedance/android/livesdk/interactivity/api/highlight/indicator/DuxBaseIndicator$a;", "setPager", "(Lcom/bytedance/android/livesdk/interactivity/api/highlight/indicator/DuxBaseIndicator$a;)V", "pager", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "interactivity-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class DuxBaseIndicator extends FrameLayout {
    public final ArrayList<View> a;
    public float b;
    public float c;
    public int d;
    public float e;
    public boolean f;
    public int g;
    public float h;
    public a i;

    public interface a {
        void a(int r1);

        boolean b();

        void c();

        void d(q32.c r1);

        int getCount();

        int getCurrentItem();
    }

    public static final class b implements Runnable {
        public final /* synthetic */ DuxBaseIndicator a;

        public b(DuxBaseIndicator r1) {
            this.a = r1;
        }

        public final void a() {
            DuxBaseIndicator r0 = this.a;
            a r1 = r0.i;
            if (r1 == null) goto L15;
            int r4 = 0;
            if (r0.a.size() >= r1.getCount()) goto L11;
            int r2 = r1.getCount() - r0.a.size();
        L8:
            if (r4 >= r2) goto L15;
            r0.a(r4);
            r4 = r4 + 1;
            goto L8
        L11:
            if (r0.a.size() <= r1.getCount()) goto L15;
            int r3 = r0.a.size() - r1.getCount();
        L13:
            if (r4 >= r3) goto L15;
            r0.g();
            r4 = r4 + 1;
        L15:
            this.a.e();
            this.a.f();
            DuxBaseIndicator r5 = this.a;
            a r6 = r5.i;
            if (r6 != null) goto L19;
            return;
        L19:
            if (r6.b() == false) goto L24;
            r6.c();
            q32.b r7 = r5.b();
            r6.d(r7);
            r7.b(r6.getCurrentItem(), 0.0f);
            return;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class c extends DataSetObserver {
        public final /* synthetic */ DuxBaseIndicator a;

        @Override // android.database.DataSetObserver
        public final void onChanged() {
            super.onChanged();
            this.a.d();
        }

        public c(DuxBaseIndicator r1) {
            this.a = r1;
        }
    }

    public DuxBaseIndicator(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public DuxBaseIndicator(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public abstract void a(int r1);

    public abstract q32.b b();

    public abstract void c(int r1);

    public abstract void g();

    public final void d() {
        if (this.i != null) goto L5;
        return;
    L5:
        post(new b(this));
    }

    public final void e() {
        int r0 = this.a.size();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        c(r1);
        r1 = r1 + 1;
        goto L3
    }

    public final void f() {
        a r0 = this.i;
        if (r0 != null) goto L5;
        return;
    L5:
        int r1 = r0.getCurrentItem();
        int r2 = 0;
    L6:
        if (r2 >= r1) goto L8;
        q32.a.a((View) ListProtector.get(this.a, r2), (int) this.b);
        r2 = r2 + 1;
        goto L6
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        d();
    }

    public final boolean getDotsClickable() {
        return this.f;
    }

    public final int getDotsColor() {
        return this.d;
    }

    public final float getDotsCornerRadius() {
        return this.e;
    }

    public final float getDotsSize() {
        return this.b;
    }

    public final float getDotsSpacing() {
        return this.c;
    }

    public final int getDotsStrokeColor() {
        return this.g;
    }

    public final float getDotsStrokeWidth() {
        return this.h;
    }

    public final a getPager() {
        return this.i;
    }

    public final void setDotsClickable(boolean r1) {
        this.f = r1;
    }

    public final void setDotsColor(int r2) {
        if (this.d == r2) goto L6;
        this.d = r2;
        e();
        return;
    }

    public final void setDotsCornerRadius(float r2) {
        if (this.e == r2) goto L6;
        this.e = r2;
        e();
        return;
    }

    public final void setDotsSize(float r2) {
        if (this.b == r2) goto L6;
        this.b = r2;
        f();
        return;
    }

    public final void setDotsSpacing(float r6) {
        if (this.c == r6) goto L16;
        this.c = r6;
        a r7 = this.i;
        if (r7 == null) goto L20;
        int r8 = r7.getCurrentItem();
        int r0 = 0;
    L8:
        if (r0 >= r8) goto L21;
        View r1 = (View) ListProtector.get(this.a, r0);
        int r2 = (int) this.c;
        Intrinsics.checkNotNullParameter(r1, "$this$setHorizontalMargin");
        ViewGroup.LayoutParams r3 = r1.getLayoutParams();
        if ((r3 instanceof FrameLayout.LayoutParams) == true) goto L12;
        r3 = null;
    L12:
        FrameLayout.LayoutParams r4 = (FrameLayout.LayoutParams) r3;
        if (r4 == null) goto L15;
        r4.leftMargin = r2;
        r4.rightMargin = r2;
        r1.requestLayout();
    L15:
        r0 = r0 + 1;
        goto L8
    L21:
        return;
    L20:
        return;
    }

    public final void setDotsStrokeColor(int r2) {
        if (this.g == r2) goto L6;
        this.g = r2;
        e();
        return;
    }

    public final void setDotsStrokeWidth(float r2) {
        if (this.h == r2) goto L6;
        this.h = r2;
        e();
        return;
    }

    public final void setPager(a r1) {
        this.i = r1;
    }

    public final void setViewPager(final ViewPager r3) {
        Intrinsics.checkNotNullParameter(r3, "viewPager");
        PagerAdapter r0 = r3.getAdapter();
        if (r0 != null) goto L6;
        LocalTestManager.a(new Class[]{wy.a.class});
        return;
    L6:
        r0.registerDataSetObserver(new c(this));
        this.i = new AnonymousClass2(r3);
        d();
    }

    public DuxBaseIndicator(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.a = new ArrayList();
        this.b = UtilityKotlinExtentionsKt.h(4);
        float r5 = 2;
        this.c = UtilityKotlinExtentionsKt.h(r5);
        this.d = ColorProtector.parseColor("#80FFFFFF");
        this.e = this.b / r5;
        this.f = true;
        this.g = ColorProtector.parseColor("#0F161823");
        this.h = UtilityKotlinExtentionsKt.h(0.5f);
    }

    public /* synthetic */ DuxBaseIndicator(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
