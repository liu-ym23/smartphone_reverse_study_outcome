package com.bytedance.android.ec.core.widget.price;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.widget.TextViewCompat;
import com.bytedance.android.ec.core.utils.font.ECFontHelper;
import com.bytedance.android.ec.core.widget.i;
import com.bytedance.common.utility.UIUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002J\u000f\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016R\u001a\u0010\u000f\u001a\u00020\n8\u0004X\u0084\u0004¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/ec/core/widget/price/PriceView;", "Landroidx/appcompat/widget/AppCompatTextView;", "Lcom/bytedance/android/ec/core/widget/i;", "", "getPrice", "()Ljava/lang/Long;", "", "width", "", "setMaxWidth", "Lcom/bytedance/android/ec/core/widget/price/a;", "a", "Lcom/bytedance/android/ec/core/widget/price/a;", "getBuilder", "()Lcom/bytedance/android/ec/core/widget/price/a;", "builder", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public class PriceView extends AppCompatTextView implements i {
    public final a a;
    public final Paint b;

    public PriceView(Context r10) {
        this(r10, null, 0, 14);
    }

    public PriceView(Context r10, AttributeSet r11) {
        this(r10, r11, 0, 12);
    }

    public PriceView(Context r10, AttributeSet r11, int r12) {
        this(r10, r11, r12, 8);
    }

    public boolean x() {
        return true;
    }

    public final String A() {
        Long r0 = this.a.d;
        if (r0 == null) goto L76;
        long r1 = r0.longValue();
        StringBuilder r10 = new StringBuilder();     // Catch: Exception -> L78
        String r11 = this.a.p;     // Catch: Exception -> L78
        boolean r12 = false;
        if (r11 != null) goto L8;
    L13:
        long r13 = 100;
        Long r14 = Long.valueOf(r1 / r13);     // Catch: Exception -> L78
        if (r14.longValue() == 0) goto L16;
        boolean r15 = true;
    L17:
        String r16 = null;
        if (r15 == true) goto L21;
        r14 = null;
    L21:
        if (r14 == null) goto L23;
        String r17 = String.valueOf(r14.longValue());     // Catch: Exception -> L78
    L24:
        Long r18 = Long.valueOf(r1 % r13);     // Catch: Exception -> L78
        if (r18.longValue() == 0) goto L27;
        boolean r19 = true;
    L28:
        if (r19 == true) goto L31;
        r18 = null;
    L31:
        if (r18 == null) goto L33;
        String r20 = String.valueOf(r18.longValue());     // Catch: Exception -> L78
    L34:
        r10.append(y(r17, r20));     // Catch: Exception -> L78
        Long r21 = this.a.C;     // Catch: Exception -> L78
        if (r21 == null) goto L37;
        long r22 = r21.longValue();     // Catch: Exception -> L78
    L38:
        Long r23 = Long.valueOf(r22 / r13);     // Catch: Exception -> L78
        if (r23.longValue() == 0) goto L41;
        boolean r24 = true;
    L42:
        if (r24 == true) goto L45;
        r23 = null;
    L45:
        if (r23 == null) goto L47;
        String r25 = String.valueOf(r23.longValue());     // Catch: Exception -> L78
    L48:
        Long r26 = this.a.C;     // Catch: Exception -> L78
        if (r26 == null) goto L51;
        long r110 = r26.longValue();     // Catch: Exception -> L78
    L52:
        Long r27 = Long.valueOf(r110 % r13);     // Catch: Exception -> L78
        if (r27.longValue() == 0) goto L55;
        boolean r28 = true;
    L56:
        if (r28 == true) goto L59;
        r27 = null;
    L59:
        if (r27 == null) goto L61;
        r16 = String.valueOf(r27.longValue());     // Catch: Exception -> L78
    L61:
        String r29 = y(r25, r16);     // Catch: Exception -> L78
        if (r29.length() <= 0) goto L64;
        boolean r30 = true;
    L65:
        if (r30 == false) goto L67;
        r10.append(r29);     // Catch: Exception -> L78
    L67:
        String r31 = this.a.v;     // Catch: Exception -> L78
        if (r31 != null) goto L70;
    L74:
        return r10.toString();
    L70:
        if (r31.length() <= 0) goto L72;
        r12 = true;
    L72:
        if (r12 != true) goto L74;
        r10.append(this.a.v);     // Catch: Exception -> L78
        goto L74
    L64:
        r30 = false;
        goto L65
    L55:
        r28 = false;
        goto L56
    L51:
        r110 = 0;
        goto L52
    L47:
        r25 = null;
        goto L48
    L41:
        r24 = false;
        goto L42
    L37:
        r22 = 0;
        goto L38
    L33:
        r20 = null;
        goto L34
    L27:
        r19 = false;
        goto L28
    L23:
        r17 = null;
        goto L24
    L16:
        r15 = false;
        goto L17
    L8:
        if (r11.length() <= 0) goto L10;
        boolean r32 = true;
    L11:
        if (r32 != true) goto L13;
        r10.append(this.a.p);     // Catch: Exception -> L78
        goto L13
    L10:
        r32 = false;
    L81:
        return "";
    L76:
        return "";
    }

    public final Long getPrice() {
        return this.a.d;
    }

    public final a getBuilder() {
        return this.a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void B(float r10) {
        a r0 = this.a;
        r0.c = UIUtils.dip2Px(getContext(), r10);
    }

    public final void C(Function1<? super a, Unit> r10) {
        Intrinsics.checkNotNullParameter(r10, "modifier");
        if (x() == false) goto L9;
        r10.invoke(this.a);
        this.b.setStrokeWidth(this.a.o);
        this.b.setColor(this.a.n);
        a r11 = this.a;
        if (r11.E == true) goto L7;
        setTextSize(0, r11.c);
    L7:
        this.a.a();
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onDraw(Canvas r10) {
        Intrinsics.checkNotNullParameter(r10, "canvas");
        super/*android.widget.TextView*/.onDraw(r10);
        if (x() == true) goto L5;
        return;
    L5:
        if (this.a.m == false) goto L12;
        int r0 = getPaddingLeft();
        int r1 = getWidth() - getPaddingRight();
        a.c r11 = this.a.a;
        if (r11 == null) goto L9;
        getPaint().measureText(getText(), 0, r11.a);
        r0 = Math.max(r0, (int) getPaint().measureText(getText(), 0, r11.a));
        r1 = Math.min(r1, (int) getPaint().measureText(getText(), 0, r11.b));
    L9:
        float r12 = 3;
        r10.drawLine(r0, getPaddingTop() + ((((getHeight() - getPaddingTop()) - getPaddingBottom()) / 5.0f) * r12), r1, ((((getHeight() - getPaddingTop()) - getPaddingBottom()) / 5.0f) * r12) + getPaddingTop(), this.b);
        return;
    }

    public void setMaxWidth(final float r10) {
        C(new C02571(r10));
    }

    public static String y(String r10, String r11) {
        StringBuilder r0 = new StringBuilder();
        boolean r1 = false;
        if (r10 != null) goto L5;
    L10:
        if (r11 == null) goto L24;
        if (r11.length() <= 0) goto L14;
        boolean r12 = true;
    L15:
        if (r12 != true) goto L24;
        if (r0.length() != 0) goto L19;
        boolean r13 = true;
    L20:
        if (r13 == false) goto L22;
        r0.append("0");
    L22:
        r0.append(".");
        r0.append(r11);
        goto L24
    L19:
        r13 = false;
        goto L20
    L14:
        r12 = false;
    L24:
        if (r0.length() <= 0) goto L26;
        r1 = true;
    L26:
        if (r1 == false) goto L29;
        r0.append("元");
    L29:
        return r0.toString();
    L5:
        if (r10.length() <= 0) goto L7;
        boolean r14 = true;
    L8:
        if (r14 != true) goto L10;
        r0.append(r10);
        goto L10
    L7:
        r14 = false;
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onMeasure(int r10, int r11) {
        if (x() == true) goto L5;
    L24:
        super.onMeasure(r10, r11);
        return;
    L5:
        if (TextViewCompat.getAutoSizeTextType(this) == 1) goto L24;
        if (this.a.E == false) goto L24;
        int r0 = View.MeasureSpec.getMode(r10);
        int r1 = this.a.F;
        int r12 = Integer.MAX_VALUE;
        if (r0 != 0) goto L11;
        int r13 = Integer.MAX_VALUE;
    L12:
        int r14 = Math.min(r1, r13);
        if (View.MeasureSpec.getMode(r11) == 0) goto L16;
        r12 = View.MeasureSpec.getSize(r11);
    L16:
        float r15 = this.a.c;
        setTextSize(0, r15);
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(0, 0), r11);
    L18:
        if (getMeasuredHeight() > r12) goto L22;
        if (getMeasuredWidth() > r14) goto L22;
        return;
    L22:
        if (r15 <= 0) goto L29;
        r15 = r15 - UIUtils.sp2px(getContext(), 1.0f);
        setTextSize(0, r15);
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(0, 0), r11);
        goto L18
    L29:
        return;
    L11:
        r13 = View.MeasureSpec.getSize(r10);
        goto L12
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void z(PriceView r10, int r11, int r12) {
        if ((r12 & 2) == 0) goto L5;
        r11 = 400;
    L5:
        r10.getClass();
        Intrinsics.checkNotNullParameter("DouyinNumberABC", "fontFamily");
        Typeface r13 = ECFontHelper.e.b("DouyinNumberABC", r11, false);
        if (r13 == null) goto L9;
        r10.setTypeface(r13);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public PriceView(Context r10, AttributeSet r11, int r12, int r13) {
        if ((r13 & 2) == 0) goto L6;
        r11 = null;
    L6:
        if ((r13 & 4) == 0) goto L8;
        r12 = 0;
    L8:
        Intrinsics.checkNotNullParameter(r10, "context");
        super(r10, r11, r12);
        int r14 = a.K;
        Intrinsics.checkNotNullParameter(this, "view");
        a r15 = new a(this);
        this.a = r15;
        Paint r16 = new Paint();
        this.b = r16;
        new Rect();
        if (x() == false) goto L19;
        TypedArray r17 = getContext().obtainStyledAttributes(r11, new int[]{2130973641, 2130973642, 2130973643, 2130973644, 2130973645, 2130973646, 2130973647, 2130973648, 2130973649, 2130973650, 2130973651, 2130973652, 2130973653, 2130973654, 2130973655, 2130973656, 2130973657, 2130973658, 2130973659, 2130973660, 2130973661, 2130973662, 2130973663});
        r15.c = getTextSize();
        r15.d = Long.valueOf(r17.getInteger(9, 0));
        r15.C = Long.valueOf(r17.getInteger(10, 0));
        r15.f = r17.getColor(11, -119723);
        r15.g = r17.getFloat(8, 0.6666667f);
        r15.h = r17.getBoolean(7, false);
        r15.i = r17.getBoolean(1, false);
        r15.j = r17.getFloat(22, 0.6666667f);
        r15.k = r17.getBoolean(20, false);
        r15.l = r17.getDimensionPixelSize(21, vf4.a.a(getContext(), 2.0f));
        r15.m = r17.getBoolean(12, false);
        r15.n = r17.getColor(13, r15.f);
        r15.o = r17.getDimensionPixelSize(14, vf4.a.a(getContext(), 1.0f));
        String r18 = r17.getString(3);
        String r19 = "";
        if (r18 != null) goto L13;
        r18 = "";
    L13:
        r15.p = r18;
        r15.r = r17.getFloat(6, 1.0f);
        r15.s = r17.getColor(5, r15.f);
        r15.q = r17.getBoolean(4, r15.h);
        r15.t = r17.getDimensionPixelSize(2, vf4.a.a(getContext(), 4.0f));
        String r0 = r17.getString(15);
        if (r0 == null) goto L17;
        r19 = r0;
    L17:
        r15.v = r19;
        r15.x = r17.getFloat(18, 1.0f);
        r15.z = r17.getColor(16, r15.f);
        r15.y = r17.getDimensionPixelSize(17, vf4.a.a(getContext(), 2.0f));
        r15.E = r17.getBoolean(0, false);
        r15.H = r17.getBoolean(19, false);
        r17.recycle();
        r16.setStrokeWidth(r15.o);
        r16.setColor(r15.n);
        setMaxLines(1);
        setIncludeFontPadding(false);
        C(new AnonymousClass1(this));
        return;
    }
}
