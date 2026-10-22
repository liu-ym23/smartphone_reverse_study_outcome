package com.obric.oui.indexscrollbar;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import androidx.core.app.NotificationCompat;
import com.obric.oui.common.util.f;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.text.StringsKt;
import u8.d;
import u8.e;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001:\u0003,-.B'\b\u0007\u0012\u0006\u0010&\u001a\u00020%\u0012\n\b\u0002\u0010(\u001a\u0004\u0018\u00010'\u0012\b\b\u0002\u0010)\u001a\u00020\u0002¢\u0006\u0004\b*\u0010+J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0016\u0010\n\u001a\u00020\u00042\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007J\u001f\u0010\u000e\u001a\u00020\u00042\u0010\u0010\r\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u00010\u000b¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0012\u001a\u00020\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010J\u000e\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0013J\u000e\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0013J\u0010\u0010\u0019\u001a\u00020\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u0018R\"\u0010 \u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\"\u0010$\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b!\u0010\u001b\u001a\u0004\b\"\u0010\u001d\"\u0004\b#\u0010\u001f¨\u0006/"}, d2 = {"Lcom/obric/oui/indexscrollbar/LettersBar;", "Landroid/view/View;", "", "index", "", "setLetterPaint", "setTouchedLetter", "", "Ls9/b;", "letters", "setLetters", "", "Landroid/graphics/Bitmap;", "bitmaps", "setBitmapsSelected", "([Landroid/graphics/Bitmap;)V", "Lcom/obric/oui/indexscrollbar/LettersBar$b;", "listener", "setListener", "", "settled", "setSettled", "showBg", "setShowBg", "Lcom/obric/oui/indexscrollbar/LettersBar$c;", "setOnBackgroundVisibleChangedListener", "r", "I", "getMHasChosenLetterFontColor", "()I", "setMHasChosenLetterFontColor", "(I)V", "mHasChosenLetterFontColor", "s", "getMNoChosenLetterFontColor", "setMNoChosenLetterFontColor", "mNoChosenLetterFontColor", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "b", "c", "OUI_standardRelease"}, k = 1, mv = {1, 4, 3})
public final class LettersBar extends View {
    private String A;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Context f6686c;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private List<s9.b> f6687g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f6688h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f6689i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private Bitmap[] f6690j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f6691k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f6692l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f6693m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private int f6694n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private int f6695o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private int f6696p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final Paint f6697q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private int f6698r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private int f6699s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private Bitmap f6700t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private int f6701u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private b f6702v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private boolean f6703w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private c f6704x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private final OIndexPopupWindowLayout f6705y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private int f6706z;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }
    }

    public interface b {
        boolean a(String r10);
    }

    public interface c {
        void a(boolean r10);
    }

    static {
        new a(null);
    }

    @JvmOverloads
    public LettersBar(Context r10) {
        this(r10, null, 0, 6, null);
    }

    @JvmOverloads
    public LettersBar(Context r10, AttributeSet r11) {
        this(r10, r11, 0, 4, null);
    }

    @JvmOverloads
    public LettersBar(Context r10, AttributeSet r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "context");
        super(r10, r11, r12);
        this.f6688h = -1;
        this.f6689i = true;
        this.f6697q = new Paint();
        this.f6705y = new OIndexPopupWindowLayout(r10, null, 2, null);
        g(r10);
    }

    public /* synthetic */ LettersBar(Context r10, AttributeSet r11, int r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 2) == 0) goto L6;
        r11 = null;
    L6:
        if ((r13 & 4) == 0) goto L8;
        r12 = 0;
    L8:
        this(r10, r11, r12);
    }

    private final ArrayList<Integer> a() {
        ArrayList<Integer> r10 = new ArrayList();
        int r11 = this.f6696p;
        List<s9.b> r12 = this.f6687g;
        Intrinsics.checkNotNull(r12);
        if ((r11 / r12.size()) >= this.f6692l) goto L5;
        List<s9.b> r13 = this.f6687g;
        Intrinsics.checkNotNull(r13);
        int r14 = (int) Math.max(2.0d, ((int) Math.ceil(r13.size() / ((this.f6696p / this.f6692l) - 2))) * 2);
    L6:
        r10.add(0);
        List<s9.b> r15 = this.f6687g;
        Intrinsics.checkNotNull(r15);
        if (r14 >= (r15.size() / 2)) goto L12;
        int r16 = r14;
    L9:
        List<s9.b> r17 = this.f6687g;
        Intrinsics.checkNotNull(r17);
        if (r16 >= (r17.size() - 1)) goto L12;
        r10.add(Integer.valueOf(r16));
        r16 = r16 + r14;
    L12:
        List<s9.b> r18 = this.f6687g;
        Intrinsics.checkNotNull(r18);
        if (r14 >= r18.size()) goto L15;
        List<s9.b> r19 = this.f6687g;
        Intrinsics.checkNotNull(r19);
        r10.add(Integer.valueOf(r19.size() - 1));
    L15:
        return r10;
    L5:
        r14 = 1;
        goto L6
    }

    private final void b(int r10, Canvas r11, float r12, float r13) {
        Bitmap r14 = this.f6700t;
        Intrinsics.checkNotNull(r14);
        float r15 = r13 - (r14.getHeight() / 2);
        Bitmap r16 = this.f6700t;
        Intrinsics.checkNotNull(r16);
        r11.drawBitmap(r16, this.f6701u, r15, null);
    }

    private final void c(int r10, Canvas r11, float r12, float r13) {
        if (i(r10) == true) goto L5;
        return;
    L5:
        if (this.f6689i == false) goto L9;
        Paint r14 = new Paint();
        Context r15 = getContext();
        Intrinsics.checkNotNullExpressionValue(r15, "context");
        r14.setColor(r15.getResources().getColor(u8.c.Transparent));
        int r16 = f.b(14);
        f.b(14);
        float r17 = r16 / 2.0f;
        int r18 = this.f6695o;
        r11.drawRoundRect(new RectF(r18 - r17, r13 - r17, r18 + r17, r13 + r17), r17, r17, r14);
        return;
    }

    private final void d(int r10, Canvas r11, float r12, float r13) {
        List<s9.b> r14 = this.f6687g;
        Intrinsics.checkNotNull(r14);
        String r15 = r14.get(r10).b();
        if (StringsKt.startsWith$default(r15, ".", false, 2, null) == false) goto L5;
        b(r10, r11, r12, r13);
        return;
    L5:
        Paint.FontMetricsInt r16 = this.f6697q.getFontMetricsInt();
        int r17 = r16.bottom;
        int r18 = r16.top;
        r11.drawText(r15, r12, (r13 - ((r17 - r18) / 2)) - r18, this.f6697q);
    }

    private final void e(int r10, Canvas r11, float r12, float r13) {
        List<s9.b> r14 = this.f6687g;
        Intrinsics.checkNotNull(r14);
        Bitmap[] r15 = r14.get(r10).c();
        Intrinsics.checkNotNull(r15);
        if (i(r10) == true) goto L5;
    L7:
        boolean r16 = false;
    L9:
        if (h() == false) goto L11;
    L14:
        boolean r17 = true;
    L16:
        if (r16 == false) goto L19;
        Bitmap r18 = r15[2];
        Intrinsics.checkNotNull(r18);
        int r19 = r18.getHeight();
        Bitmap r20 = r15[2];
        Intrinsics.checkNotNull(r20);
        float r21 = this.f6695o - (r20.getWidth() / 2);
        Bitmap r22 = r15[2];
    L18:
        Intrinsics.checkNotNull(r22);
        r11.drawBitmap(r22, r21, r13 - (r19 / 2), null);
        return;
    L19:
        if (r17 == false) goto L21;
        Bitmap r23 = r15[1];
        Intrinsics.checkNotNull(r23);
        r19 = r23.getHeight();
        Bitmap r24 = r15[1];
        Intrinsics.checkNotNull(r24);
        r21 = this.f6695o - (r24.getWidth() / 2);
        r22 = r15[1];
        goto L18
    L21:
        Bitmap r25 = r15[0];
        Intrinsics.checkNotNull(r25);
        r19 = r25.getHeight();
        Bitmap r26 = r15[0];
        Intrinsics.checkNotNull(r26);
        r21 = this.f6695o - (r26.getWidth() / 2);
        r22 = r15[0];
        goto L18
    L11:
        if (this.f6689i == false) goto L14;
        r17 = false;
        goto L16
    L5:
        if (this.f6689i == false) goto L7;
        r16 = true;
        goto L9
    }

    private final float f(int r10, ArrayList<Integer> r11) {
        return (float) Math.max(r10 / r11.size(), this.f6692l);
    }

    private final void g(Context r10) {
        this.f6686c = r10;
        Intrinsics.checkNotNull(r10);
        Resources r11 = r10.getResources();
        this.f6692l = r11.getDimensionPixelSize(d.letters_bar_single_letter_min_height);
        this.f6691k = f.b(14);
        this.f6693m = r11.getDimensionPixelOffset(d.letters_bar_letter_font_size);
        this.f6694n = r11.getDimensionPixelOffset(d.letters_bar_letter_locale_font_size);
        this.f6695o = (this.f6691k / 2) + getPaddingLeft();
        int r12 = e.letters_bar_highlight_icon;
        BitmapFactory.decodeResource(r11, r12);
        Drawable r13 = r11.getDrawable(r12);
        Intrinsics.checkNotNullExpressionValue(r13, "iconDrawable");
        int r14 = r13.getIntrinsicWidth() / 2;
        r13.getIntrinsicHeight();
        this.f6698r = r11.getColor(u8.c.oui_functional_blue_6);
        this.f6699s = r11.getColor(u8.c.oui_text_3b);
        Bitmap r15 = BitmapFactory.decodeResource(r11, e.letters_bar_dot);
        this.f6700t = r15;
        int r16 = this.f6695o;
        Intrinsics.checkNotNull(r15);
        this.f6701u = r16 - (r15.getWidth() / 2);
        this.f6697q.setTypeface(Typeface.create(Typeface.DEFAULT, 0));
        this.f6697q.setTextSize(this.f6693m);
        this.f6697q.setAntiAlias(true);
        Resources r17 = r10.getResources();
        Intrinsics.checkNotNullExpressionValue(r17, "context.resources");
        this.f6706z = r17.getDisplayMetrics().widthPixels;
    }

    private final boolean h() {
        if (this.f6688h == (-1)) goto L5;
        return true;
    L5:
        return false;
    }

    private final boolean i(int r10) {
        if (this.f6688h != r10) goto L5;
        return true;
    L5:
        return false;
    }

    private final int j(int r10) {
        int r11 = View.MeasureSpec.getMode(r10);
        int r12 = View.MeasureSpec.getSize(r10);
        if (r11 != Integer.MIN_VALUE) goto L6;
        return r12;
    L6:
        if (r11 == 1073741824) goto L11;
        return 0;
    L11:
        return r12;
    }

    private final void k(String r11, int r12) {
        float r10 = f(this.f6696p, a());
        List<s9.b> r13 = this.f6687g;
        Intrinsics.checkNotNull(r13);
        String r14 = r13.get(r12).b();
        if (Intrinsics.areEqual(r14, this.A) == false) goto L5;
        return;
    L5:
        ea.b.a("LettersBar", "showPopupWindow, scene: " + r11 + ", c = " + r12 + ", letter = " + r14 + ", lastPopupLetter = " + this.A);
        Bitmap[] r15 = this.f6690j;
        Bitmap r16 = null;
        if (r15 == null) goto L8;
        Integer r17 = Integer.valueOf(r15.length);
    L9:
        List<s9.b> r18 = this.f6687g;
        Intrinsics.checkNotNull(r18);
        if (r18.get(r12).d() != 2) goto L15;
        if (r17 == null) goto L15;
        if (Integer.parseInt(r14) > r17.intValue()) goto L15;
        Bitmap[] r19 = this.f6690j;
        Intrinsics.checkNotNull(r19);
        r16 = r19[Integer.parseInt(r14) - 1];
    L15:
        int r110 = getResources().getDimensionPixelSize(d.oui_h_title_bar_window);
        int r20 = this.f6706z - getWidth();
        Resources r21 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r21, "Resources.getSystem()");
        int r22 = r20 - MathKt.roundToInt(TypedValue.applyDimension(1, 20, r21.getDisplayMetrics()));
        Resources r23 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r23, "Resources.getSystem()");
        int r24 = r22 - MathKt.roundToInt(TypedValue.applyDimension(1, 18, r23.getDisplayMetrics()));
        Resources r25 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r25, "Resources.getSystem()");
        int r26 = r24 - MathKt.roundToInt(TypedValue.applyDimension(1, 6, r25.getDisplayMetrics()));
        Resources r27 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r27, "Resources.getSystem()");
        int r28 = r26 - MathKt.roundToInt(TypedValue.applyDimension(1, 10, r27.getDisplayMetrics()));
        int r29 = getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (r29 <= 0) goto L18;
        r110 = r110 + getResources().getDimensionPixelSize(r29);
    L18:
        int[] r30 = new int[2];
        getLocationInWindow(r30);
        this.f6705y.b(r14, r16, r28, Math.max((int) ((r10 * (r12 - 1)) + r30[1]), r110));
        this.A = r14;
        return;
    L8:
        r17 = null;
        goto L9
    }

    private final void setLetterPaint(int r10) {
        if (i(r10) == false) goto L5;
        Paint r11 = this.f6697q;
        int r12 = this.f6698r;
    L6:
        r11.setColor(r12);
        this.f6697q.setFakeBoldText(false);
        Paint r13 = this.f6697q;
        Resources r14 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r14, "Resources.getSystem()");
        r13.setTextSize(TypedValue.applyDimension(1, 10, r14.getDisplayMetrics()));
        List<s9.b> r15 = this.f6687g;
        Intrinsics.checkNotNull(r15);
        if (StringsKt.startsWith$default(r15.get(r10).b(), ".", false, 2, null) == true) goto L13;
        List<s9.b> r16 = this.f6687g;
        Intrinsics.checkNotNull(r16);
        if (r16.get(r10).d() != 1) goto L11;
        this.f6697q.setTextSize(this.f6694n);
        this.f6697q.setFakeBoldText(true);
        return;
    L11:
        this.f6697q.setTextSize(this.f6693m);
        return;
    L13:
        return;
    L5:
        r11 = this.f6697q;
        r12 = this.f6699s;
        goto L6
    }

    private final void setTouchedLetter(int r10) {
        this.f6688h = r10;
        invalidate();
    }

    @Override // android.view.View
    public boolean dispatchTouchEvent(MotionEvent r10) {
        Intrinsics.checkNotNullParameter(r10, NotificationCompat.CATEGORY_EVENT);
        super.dispatchTouchEvent(r10);
        int r11 = r10.getAction();
        float r12 = r10.getY();
        int r13 = this.f6688h;
        float r14 = (r12 - getPaddingTop()) / ((getHeight() - getPaddingTop()) - getPaddingBottom());
        List<s9.b> r15 = this.f6687g;
        Intrinsics.checkNotNull(r15);
        int r16 = (int) (r14 * r15.size());
        if (r11 != 0) goto L5;
        this.A = null;
        if (r13 == r16) goto L39;
        if (r16 < 0) goto L39;
        List<s9.b> r17 = this.f6687g;
        Intrinsics.checkNotNull(r17);
        if (r16 >= r17.size()) goto L39;
        k("ACTION_DOWN", r16);
    L38:
        setTouchedLetter(r16);
    L39:
        setShowBg(false);
    L40:
        return true;
    L5:
        if (r11 == 1) goto L22;
        if (r11 != 2) goto L9;
        if (r16 < 0) goto L39;
        List<s9.b> r18 = this.f6687g;
        Intrinsics.checkNotNull(r18);
        if (r16 >= r18.size()) goto L39;
        if (this.f6689i == false) goto L38;
        if (r13 == r16) goto L38;
        if (this.f6702v == null) goto L38;
        k("ACTION_MOVE", r16);
        b r19 = this.f6702v;
        Intrinsics.checkNotNull(r19);
        List<s9.b> r20 = this.f6687g;
        Intrinsics.checkNotNull(r20);
        r19.a(r20.get(r16).b());
        goto L38
    L9:
        if (r11 != 3) goto L40;
        this.f6705y.a();
        setTouchedLetter(-1);
        goto L40
    L22:
        if (this.f6689i == false) goto L31;
        if (r16 < 0) goto L30;
        List<s9.b> r21 = this.f6687g;
        Intrinsics.checkNotNull(r21);
        if (r16 >= r21.size()) goto L30;
        b r22 = this.f6702v;
        if (r22 == null) goto L29;
        Intrinsics.checkNotNull(r22);
        List<s9.b> r23 = this.f6687g;
        Intrinsics.checkNotNull(r23);
        r22.a(r23.get(r16).b());
    L29:
        setTouchedLetter(r16);
    L30:
        this.f6705y.a();
        setTouchedLetter(-1);
        setShowBg(false);
    L31:
        this.f6705y.a();
        invalidate();
        goto L40
    }

    public final int getMHasChosenLetterFontColor() {
        return this.f6698r;
    }

    public final int getMNoChosenLetterFontColor() {
        return this.f6699s;
    }

    @Override // android.view.View
    protected void onDraw(Canvas r10) {
        Intrinsics.checkNotNullParameter(r10, "canvas");
        super.onDraw(r10);
        r10.save();
        r10.translate(0.0f, getPaddingTop());
        ArrayList<Integer> r11 = a();
        float r12 = f(this.f6696p, r11);
        Iterator<Integer> r13 = r11.iterator();
        int r14 = 0;
    L4:
        if (r13.hasNext() == false) goto L10;
        Integer r15 = r13.next();
        Intrinsics.checkNotNullExpressionValue(r15, "index");
        setLetterPaint(r15.intValue());
        float r16 = this.f6695o;
        Paint r17 = this.f6697q;
        List<s9.b> r18 = this.f6687g;
        Intrinsics.checkNotNull(r18);
        float r19 = 2;
        float r20 = r16 - (r17.measureText(r18.get(r15.intValue()).b()) / r19);
        float r21 = (r14 * r12) + (r12 / r19);
        c(r15.intValue(), r10, r20, r21);
        List<s9.b> r22 = this.f6687g;
        Intrinsics.checkNotNull(r22);
        int r23 = r22.get(r15.intValue()).d();
        int r24 = r15.intValue();
        if (r23 != 2) goto L8;
        e(r24, r10, r20, r21);
    L9:
        r14 = r14 + 1;
        goto L4
    L8:
        d(r24, r10, r20, r21);
        goto L9
    L10:
        r10.restore();
    }

    @Override // android.view.View
    protected void onMeasure(int r10, int r11) {
        super.onMeasure(r10, r11);
        this.f6696p = (j(r11) - getPaddingTop()) - getPaddingBottom();
    }

    public final void setBitmapsSelected(Bitmap[] r10) {
        this.f6690j = r10;
    }

    public final void setLetters(List<s9.b> r10) {
        this.f6687g = r10;
    }

    public final void setListener(b r10) {
        this.f6702v = r10;
    }

    public final void setMHasChosenLetterFontColor(int r10) {
        this.f6698r = r10;
    }

    public final void setMNoChosenLetterFontColor(int r10) {
        this.f6699s = r10;
    }

    public final void setOnBackgroundVisibleChangedListener(c r10) {
        this.f6704x = r10;
    }

    public final void setSettled(boolean r10) {
        this.f6689i = r10;
        if (r10 == false) goto L5;
        setTouchedLetter(-1);
    L5:
        invalidate();
    }

    public final void setShowBg(boolean r10) {
        if (this.f6703w == r10) goto L12;
        this.f6703w = r10;
        if (r10 == false) goto L7;
        Drawable r11 = getResources().getDrawable(e.letters_bar_background);
    L8:
        setBackground(r11);
        c r12 = this.f6704x;
        if (r12 == null) goto L13;
        Intrinsics.checkNotNull(r12);
        r12.a(this.f6703w);
        return;
    L13:
        return;
    L7:
        r11 = null;
        goto L8
    }
}
