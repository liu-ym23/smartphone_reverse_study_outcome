package com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u0018B\u0017\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\u0006\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0016\u0010\u0017R\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR)\u0010\u0011\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u000b0\n8\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v2/view/newcombo/GiftComboProgressBar;", "Landroid/view/View;", BuildConfig.FLAVOR, "j", "J", "getCountDownTime", "()J", "setCountDownTime", "(J)V", "countDownTime", "Lcom/bytedance/ies/sdk/widgets/NextLiveData;", "Lkotlin/Pair;", BuildConfig.FLAVOR, sz1.a.KEY_Y, "Lcom/bytedance/ies/sdk/widgets/NextLiveData;", "getShowCountDown", "()Lcom/bytedance/ies/sdk/widgets/NextLiveData;", "showCountDown", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "a", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class GiftComboProgressBar extends View {
    public Paint a;
    public float b;
    public int c;
    public float d;
    public float e;
    public final RectF f;
    public float g;
    public AnimatorSet h;
    public boolean i;
    public long j;
    public Paint k;
    public int l;
    public float m;
    public final Point n;
    public float o;
    public float p;
    public int q;
    public Animator r;
    public float s;
    public Animator t;
    public Paint u;
    public int v;
    public float w;
    public final NextLiveData<Boolean> x;
    public final NextLiveData<Pair<Boolean, Boolean>> y;

    public static final class a {
    }

    static {
    }

    public final long getCountDownTime() {
        return this.j;
    }

    public final NextLiveData<Pair<Boolean, Boolean>> getShowCountDown() {
        return this.y;
    }

    @Override // android.view.View
    public final void onDraw(Canvas r13) {
        Intrinsics.checkNotNullParameter(r13, "canvas");
        super.onDraw(r13);
        int r6 = r13.saveLayer(0.0f, 0.0f, getWidth(), getHeight(), null, 31);
        float r7 = this.e * this.g;
        Point r0 = this.n;
        if (r0 == null) goto L5;
        r13.rotate(this.d, r0.x, r0.y);
    L5:
        RectF r1 = this.f;
        Paint r5 = this.k;
        if (r1 == null) goto L12;
        if (r5 == null) goto L12;
        r5.setStrokeWidth(this.m);
        Paint r2 = this.k;
        if (r2 == null) goto L11;
        r2.setStrokeCap(Paint.Cap.ROUND);
    L11:
        r13.drawArc(r1, 0.0f, this.e, false, r5);
    L12:
        RectF r3 = this.f;
        Paint r8 = this.a;
        if (r3 == null) goto L16;
        if (r8 == null) goto L16;
        r13.drawArc(r3, r7, this.e - r7, false, r8);
    L16:
        RectF r9 = this.f;
        Paint r10 = this.u;
        if (r9 == null) goto L20;
        if (r10 == null) goto L20;
        r10.setAlpha((int) (this.s * 255));
        float r4 = this.w * 155.0f;
        r13.drawArc(r9, r4 + 155.0f, -r4, false, r10);
        r13.drawArc(r9, 155.0f - r4, this.w * 155.0f, false, r10);
    L20:
        int r11 = (int) (this.e / this.q);
        Point r14 = this.n;
        Paint r15 = this.k;
        if (r14 == null) goto L37;
        if (r15 == null) goto L37;
        r15.setStrokeWidth(this.p);
        Paint r16 = this.k;
        if (r16 == null) goto L26;
        r16.setStrokeCap(Paint.Cap.BUTT);
    L26:
        Paint r17 = this.k;
        if (r17 == null) goto L29;
        r17.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
    L29:
        if (r11 < 0) goto L34;
        int r18 = 0;
    L31:
        float r19 = this.o + r14.x;
        float r20 = r14.y;
        r13.drawLine(r19, r20, r19 + this.m, r20, r15);
        r13.rotate(this.q, r14.x, r14.y);
        if (r18 == r11) goto L34;
        r18 = r18 + 1;
    L34:
        Paint r21 = this.k;
        if (r21 == null) goto L37;
        r21.setXfermode(null);
    L37:
        r13.restoreToCount(r6);
    }

    public final void setCountDownTime(long r1) {
        this.j = r1;
    }

    public GiftComboProgressBar(Context r7, AttributeSet r8) {
        Intrinsics.checkNotNullParameter(r7, "context");
        Intrinsics.checkNotNullParameter(r8, "attrs");
        super(r7, r8);
        this.j = 8000;
        this.x = new NextLiveData();
        final NextLiveData<Pair<Boolean, Boolean>> r9 = new NextLiveData();
        UtilityKotlinExtentionsKt.s(0, false, false, new GiftComboProgressBar$showCountDown$1$1(r9), 7);
        Unit r10 = Unit.INSTANCE;
        this.y = r9;
        this.f = new RectF();
        this.n = new Point();
        this.b = s1.j(2131168701);
        this.c = s1.h(2131106924);
        this.m = s1.j(2131168700);
        this.l = s1.h(2131106925);
        this.d = -65.0f;
        this.e = 310.0f;
        this.p = 4.0f;
        s1.h(2131106925);
        this.q = 10;
        this.v = s1.h(2131106923);
        Paint r11 = new Paint();
        this.a = r11;
        r11.setColor(this.c);
        Paint r13 = this.a;
        if (r13 == null) goto L5;
        r13.setAntiAlias(true);
    L5:
        Paint r14 = this.a;
        if (r14 == null) goto L8;
        r14.setStyle(Paint.Style.STROKE);
    L8:
        Paint r15 = this.a;
        if (r15 == null) goto L11;
        r15.setStrokeWidth(this.b);
    L11:
        Paint r16 = this.a;
        if (r16 == null) goto L14;
        r16.setStrokeCap(Paint.Cap.ROUND);
    L14:
        Paint r17 = new Paint();
        this.k = r17;
        r17.setAntiAlias(true);
        Paint r18 = this.k;
        if (r18 == null) goto L17;
        r18.setColor(this.l);
    L17:
        Paint r19 = this.k;
        if (r19 == null) goto L20;
        r19.setStyle(Paint.Style.STROKE);
    L20:
        Paint r20 = this.k;
        if (r20 == null) goto L23;
        r20.setStrokeWidth(this.m);
    L23:
        Paint r21 = this.k;
        if (r21 == null) goto L26;
        r21.setStrokeCap(Paint.Cap.ROUND);
    L26:
        Paint r23 = new Paint();
        this.u = r23;
        r23.setColor(this.v);
        Paint r24 = this.u;
        if (r24 == null) goto L29;
        r24.setAntiAlias(true);
    L29:
        Paint r25 = this.u;
        if (r25 == null) goto L32;
        r25.setStyle(Paint.Style.STROKE);
    L32:
        Paint r26 = this.u;
        if (r26 == null) goto L35;
        r26.setStrokeWidth(this.b);
    L35:
        Paint r27 = this.u;
        if (r27 == null) goto L39;
        r27.setStrokeCap(Paint.Cap.ROUND);
        return;
    }

    @Override // android.view.View
    public final void onMeasure(int r6, int r7) {
        super.onMeasure(r6, r7);
        int r1 = com.bytedance.android.live.revenue.common.i.b(150);
        int r2 = View.MeasureSpec.getMode(r6);
        int r8 = View.MeasureSpec.getSize(r6);
        if (r2 == Integer.MIN_VALUE) goto L7;
        if (r2 != 1073741824) goto L8;
        r1 = r8;
    L8:
        int r9 = com.bytedance.android.live.revenue.common.i.b(150);
        int r0 = View.MeasureSpec.getMode(r7);
        int r10 = View.MeasureSpec.getSize(r7);
        if (r0 == Integer.MIN_VALUE) goto L13;
        if (r0 != 1073741824) goto L14;
        r9 = r10;
    L14:
        setMeasuredDimension(r1, r9);
        return;
    L13:
        r9 = RangesKt.coerceAtMost(r9, r10);
        goto L14
    L7:
        r1 = RangesKt.coerceAtMost(r1, r8);
        goto L8
    }

    @Override // android.view.View
    public final void onSizeChanged(int r5, int r6, int r7, int r8) {
        super.onSizeChanged(r5, r6, r7, r8);
        float r9 = Math.max(this.b, this.m);
        int r0 = ((int) r9) * 2;
        float r10 = Math.min(((r5 - getPaddingLeft()) - getPaddingRight()) - r0, ((r6 - getPaddingTop()) - getPaddingBottom()) - r0) / 2;
        this.o = r10;
        Point r1 = this.n;
        if (r1 == null) goto L5;
        r1.x = r5 / 2;
    L5:
        if (r1 == null) goto L7;
        r1.y = r6 / 2;
    L7:
        if (r1 == null) goto L18;
        RectF r11 = this.f;
        if (r11 == null) goto L11;
        r11.left = (r1.x - r10) - (r9 / 2);
    L11:
        if (r11 == null) goto L13;
        r11.top = (r1.y - r10) - (r9 / 2);
    L13:
        if (r11 == null) goto L15;
        r11.right = (r1.x + r10) + (r9 / 2);
    L15:
        if (r11 == null) goto L19;
        r11.bottom = (r1.y + r10) + (r9 / 2);
        return;
    L19:
        return;
    }
}
