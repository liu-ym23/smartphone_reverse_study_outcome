package com.obric.oui.indexscrollbar;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import com.lynx.tasm.behavior.ui.utils.n;
import com.lynx.tasm.behavior.x0;
import com.lynx.tasm.utils.a;
import com.obric.common.oui.R$dimen;
import com.obric.common.oui.R$drawable;
import com.obric.common.oui.R$id;
import com.obric.common.oui.R$integer;
import com.obric.common.oui.R$layout;
import java.util.ArrayList;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tr.b;
import tr.f;
import tr.g;
import tr.h;
import tr.i;
import tr.j;
import tr.k;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000e\n\u0002\b\u0016\u0018\u00002\u00020\u0001:\u0003=\b\rB\u001b\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000e\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u000e\u0010\u000fJ\u0015\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0012\u0010\u0013J\u0015\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0016\u0010\u0017J\u0015\u0010\u0019\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\u0010¢\u0006\u0004\b\u0019\u0010\u0013J\u000f\u0010\u001b\u001a\u0004\u0018\u00010\u001a¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u001e\u001a\u00020\n2\u0006\u0010\u001d\u001a\u00020\u0014H\u0002¢\u0006\u0004\b\u001e\u0010\u0017J\u0017\u0010 \u001a\u00020\n2\u0006\u0010\u001f\u001a\u00020\u0014H\u0002¢\u0006\u0004\b \u0010\u0017J\u0017\u0010\"\u001a\u00020\n2\u0006\u0010!\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\"\u0010\u0013J\u0017\u0010#\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b#\u0010\u0013J\u000f\u0010$\u001a\u00020\u0014H\u0002¢\u0006\u0004\b$\u0010%J\u000f\u0010&\u001a\u00020\nH\u0002¢\u0006\u0004\b&\u0010'R\u001a\u0010-\u001a\u00020(8\u0006X\u0086D¢\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,R\u0017\u00102\u001a\u00020\u00108\u0006¢\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b0\u00101R\u001a\u00106\u001a\u00020\u00148\u0006X\u0086D¢\u0006\f\n\u0004\b3\u00104\u001a\u0004\b5\u0010%R\u001a\u00109\u001a\u00020\u00148\u0006X\u0086D¢\u0006\f\n\u0004\b7\u00104\u001a\u0004\b8\u0010%R\u001a\u0010<\u001a\u00020\u00148\u0006X\u0086D¢\u0006\f\n\u0004\b:\u00104\u001a\u0004\b;\u0010%¨\u0006>"}, d2 = {"Lcom/obric/oui/indexscrollbar/OIndexScrollbar;", "Landroid/widget/LinearLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "Ltr/i;", "listener", "", "setQBListener", "(Ltr/i;)V", "Ltr/j;", "setSurnameListener", "(Ltr/j;)V", "", "visible", "setPoundVisibility", "(Z)V", "", "position", "setPoundPosition", "(I)V", "enabled", "setLongPressEnabled", "Lcom/obric/oui/indexscrollbar/LettersBar;", "getLetterBar", "()Lcom/obric/oui/indexscrollbar/LettersBar;", "hostWidth", "setHostWidth", "state", "setState", "showBg", "setLettersBarBg", "setShadowVisible", "getScreenWidth", "()I", "getParentxPos", "()V", "", "a", "Ljava/lang/String;", "getOIndexScrollbar_TAG", "()Ljava/lang/String;", "OIndexScrollbar_TAG", "b", "Z", "getOIndexScrollbar_DEBUG", "()Z", "OIndexScrollbar_DEBUG", "u", "I", "getPOUND_POSITION_TOP", "POUND_POSITION_TOP", "v", "getPOUND_POSITION_BOTTOM", "POUND_POSITION_BOTTOM", "B", "getVISIBILITY_LIMIT", "VISIBILITY_LIMIT", "tr/h", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OIndexScrollbar extends LinearLayout {
    public static final /* synthetic */ int D = 0;
    public final int A;
    public final int B;
    public boolean C;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f13401a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f13402b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Context f13403c;
    public final LettersBar d;
    public final GridView e;
    public final View f;
    public final h g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f13404h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f13405i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f13406j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f13407k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int f13408l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f13409m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final int f13410n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final int f13411o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final int f13412p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f13413q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public float f13414r;
    public float s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f13415t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final int f13416u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final int f13417v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f13418w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public PopupWindow f13419x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final int f13420y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f13421z;

    public OIndexScrollbar(Context r12, AttributeSet r13) {
        Intrinsics.checkNotNullParameter(r12, "context");
        super(r12, r13);
        this.f13401a = "OIndexScrollbar";
        int r5 = 3;
        this.f13402b = Log.isLoggable("OIndexScrollbar", 3);
        this.f13410n = 1;
        this.f13411o = 2;
        this.f13412p = 3;
        this.f13413q = 1;
        ArrayList r10 = new ArrayList();
        this.f13415t = true;
        this.f13416u = 1;
        this.f13417v = 2;
        this.f13418w = 2;
        this.f13420y = -99999;
        this.f13421z = -99999;
        Intrinsics.checkNotNullParameter(r12, "context");
        this.f13403c = r12;
        Intrinsics.checkNotNull(r12);
        Resources r14 = r12.getResources();
        LayoutInflater.from(this.f13403c).inflate(R$layout.o_index_scrollbar, this, true);
        this.f13407k = a.B(22, this);
        int r11 = r14.getDimensionPixelOffset(R$dimen.bytedance_quickbar_grid_item_space);
        int r15 = r14.getDimensionPixelOffset(R$dimen.quickbar_ex_grid_column_width);
        this.A = r14.getDimensionPixelOffset(R$dimen.bytedance_quickbar_min_distance);
        this.f13408l = r14.getDrawable(R$drawable.letters_bar_background_shadow).getIntrinsicWidth();
        int r16 = (r11 * 2) + this.f13407k;
        Context r17 = this.f13403c;
        Intrinsics.checkNotNull(r17);
        this.f13406j = ((r17.getResources().getInteger(R$integer.bytedance_letterbar_gridview_column_num) * r15) + r16) + this.f13408l;
        View r18 = findViewById(R$id.quickbar_left_letters_bar);
        if (r18 == null) goto L56;
        LettersBar r19 = (LettersBar) r18;
        this.d = r19;
        Intrinsics.checkNotNull(r19);
        r19.setLetters(r10);
        LettersBar r110 = this.d;
        Intrinsics.checkNotNull(r110);
        r110.setListener(new x0(this));
        LettersBar r111 = this.d;
        Intrinsics.checkNotNull(r111);
        r111.setOnBackgroundVisibleChangedListener(new n(this));
        r10.clear();
        String r112 = Locale.getDefault().getLanguage();
        Intrinsics.checkNotNullParameter(r112, "language");
        if (Intrinsics.areEqual(Locale.KOREA.getLanguage(), r112) == false) goto L8;
        String[] r113 = tr.a.f;
    L14:
        int r20 = r113.length - 1;
        int r21 = 0;
    L15:
        if (r21 >= r20) goto L34;
        int r22 = r21 + 1;
        String r23 = Locale.getDefault().getLanguage();
        Intrinsics.checkNotNullParameter(r23, "language");
        if (Intrinsics.areEqual(Locale.KOREA.getLanguage(), r23) == false) goto L22;
        if (r21 < 14) goto L30;
    L31:
        b r24 = b.f22163c;
        String r25 = r113[r21];
        Intrinsics.checkNotNullParameter(r25, "letter");
        r10.add(new b(0, r25));
    L32:
        r21 = r22;
    L30:
        b r26 = b.f22163c;
        String r27 = r113[r21];
        Intrinsics.checkNotNullParameter(r27, "letter");
        r10.add(new b(1, r27));
        goto L32
    L22:
        if (Intrinsics.areEqual(Locale.JAPAN.getLanguage(), r23) == false) goto L27;
        if (r21 >= 10) goto L31;
    L27:
        if (Intrinsics.areEqual("ru", r23) == false) goto L31;
        if (r21 >= 5) goto L31;
    L34:
        if (this.f13415t == true) goto L36;
    L39:
        invalidate();
        View r114 = findViewById(R$id.quickbar_right_grid_view);
        if (r114 == null) goto L54;
        this.e = (GridView) r114;
        h r115 = new h(this, this.f13403c);
        this.g = r115;
        Intrinsics.checkNotNull(r115);
        String r28 = Locale.getDefault().getLanguage();
        Intrinsics.checkNotNullParameter(r28, "language");
        if (Intrinsics.areEqual(Locale.KOREA.getLanguage(), r28) == false) goto L45;
        String[] r29 = tr.a.f22160b;
    L51:
        r115.f22171b = r29;
        GridView r116 = this.e;
        Intrinsics.checkNotNull(r116);
        r116.setAdapter(this.g);
        GridView r117 = this.e;
        Intrinsics.checkNotNull(r117);
        r117.setOnItemClickListener(new f(this));
        GridView r118 = this.e;
        Intrinsics.checkNotNull(r118);
        r118.setOnTouchListener(new com.bytedance.ai.widget.contianer.a(this, r5));
        GridView r119 = this.e;
        Intrinsics.checkNotNull(r119);
        r119.setOnItemLongClickListener(new g(this));
        this.f = findViewById(R$id.iv_letter_bar_shadow);
        setLettersBarBg(false);
        this.B = 30;
        this.C = true;
        return;
    L45:
        if (Intrinsics.areEqual(Locale.JAPAN.getLanguage(), r28) == false) goto L48;
        r29 = tr.a.f22161c;
        goto L51
    L48:
        if (Intrinsics.areEqual("ru", r28) == false) goto L50;
        r29 = tr.a.d;
        goto L51
    L50:
        r29 = tr.a.f22159a;
        goto L51
    L54:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.GridView");
    L36:
        if (this.f13418w != this.f13416u) goto L38;
        r10.add(0, b.f22163c);
        goto L39
    L38:
        r10.add(b.f22163c);
        goto L39
    L8:
        if (Intrinsics.areEqual(Locale.JAPAN.getLanguage(), r112) == false) goto L11;
        r113 = tr.a.g;
        goto L14
    L11:
        if (Intrinsics.areEqual("ru", r112) == false) goto L13;
        r113 = tr.a.f22162h;
        goto L14
    L13:
        r113 = tr.a.e;
        goto L14
    L56:
        throw new NullPointerException("null cannot be cast to non-null type com.obric.oui.indexscrollbar.LettersBar");
    }

    public static final void a(OIndexScrollbar r5) {
        r5.setX(r5.f13405i);
        r5.setState(r5.f13412p);
        r5.setLettersBarBg(true);
    }

    public static final /* synthetic */ void b(OIndexScrollbar r5) {
        r5.setLettersBarBg(true);
    }

    public static final /* synthetic */ void c(OIndexScrollbar r5, boolean r10) {
        r5.setShadowVisible(r10);
    }

    private final void getParentxPos() {
        if (this.f13421z == this.f13420y) goto L5;
        return;
    L5:
        Object r5 = getParent();
        if ((r5 instanceof View) == false) goto L9;
        int[] r10 = new int[2];
        ((View) r5).getLocationInWindow(r10);
        this.f13421z = r10[0];
        return;
    }

    private final int getScreenWidth() {
        Point r5 = new Point();
        Context r10 = this.f13403c;
        Intrinsics.checkNotNull(r10);
        Object r11 = r10.getSystemService("window");
        if (r11 == null) goto L7;
        ((WindowManager) r11).getDefaultDisplay().getSize(r5);
        return r5.x;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type android.view.WindowManager");
    }

    private final void setHostWidth(int r5) {
        int r10 = (r5 - this.f13407k) - this.f13408l;
        this.f13404h = r10;
        int r11 = r5 - this.f13406j;
        this.f13405i = r11;
        int r12 = this.f13413q;
        if (r12 != this.f13410n) goto L6;
        float r13 = r10;
    L9:
        setX(r13);
        if (this.f13402b == false) goto L12;
        Log.d(this.f13401a, Intrinsics.stringPlus("mStartX = ", Integer.valueOf(this.f13404h)));
    L12:
        invalidate();
        return;
    L6:
        if (r12 != this.f13412p) goto L8;
        r13 = r11;
        goto L9
    L8:
        r13 = getX();
        goto L9
    }

    private final void setLettersBarBg(boolean r5) {
        LettersBar r10 = this.d;
        Intrinsics.checkNotNull(r10);
        r10.setShowBg(r5);
        setShadowVisible(r5);
    }

    private final void setShadowVisible(boolean r5) {
        View r10 = this.f;
        Intrinsics.checkNotNull(r10);
        if (r5 == false) goto L5;
        int r11 = 0;
    L6:
        r10.setVisibility(r11);
        return;
    L5:
        r11 = 4;
        goto L6
    }

    private final void setState(int r5) {
        this.f13413q = r5;
        LettersBar r10 = this.d;
        Intrinsics.checkNotNull(r10);
        if (r5 != this.f13410n) goto L5;
        boolean r11 = true;
    L6:
        r10.setSettled(r11);
        return;
    L5:
        r11 = false;
        goto L6
    }

    public final void d() {
        int r5 = 0;
        PopupWindow r10 = this.f13419x;
        if (r10 == null) goto L5;
        Intrinsics.checkNotNull(r10);
        r10.dismiss();
        this.f13419x = null;
    L5:
        AnimatorSet r11 = new AnimatorSet();
        r11.play(ObjectAnimator.ofPropertyValuesHolder(this, new PropertyValuesHolder[]{PropertyValuesHolder.ofFloat("x", new float[]{getX(), this.f13404h})}));
        r11.setDuration(200);
        r11.addListener(new k(this, r5));
        r11.start();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r10) {
        int r5 = 1;
        Intrinsics.checkNotNullParameter(r10, "event");
        String r11 = Locale.getDefault().getLanguage();
        Intrinsics.checkNotNullParameter(r11, "language");
        if (Intrinsics.areEqual(Locale.CHINESE.getLanguage(), r11) == false) goto L6;
    L16:
        getParentxPos();
        int r12 = r10.getAction();
        r10.getX();
        r10.getY();
        float r13 = r10.getRawX() - this.f13421z;
        if (r12 == 0) goto L47;
        int r14 = this.f13411o;
        if (r12 == 1) goto L37;
        if (r12 != 2) goto L22;
        float r15 = this.s;
        this.f13414r = r15;
        this.s = r13;
        int r16 = this.f13413q;
        if (r16 != this.f13410n) goto L27;
        int r17 = (r13 > this.f13404h ? 1 : (r13 == this.f13404h ? 0 : -1));
    L49:
        if (super.dispatchTouchEvent(r10) == true) goto L51;
        return false;
    L51:
        return true;
    L27:
        if (r16 == r14) goto L49;
        if (r16 != this.f13412p) goto L49;
        if ((r13 - r15) <= this.A) goto L49;
        if (r15 <= this.f13405i) goto L49;
    L22:
        if (r12 != 3) goto L49;
    L37:
        if (getX() != this.f13404h) goto L40;
        setLettersBarBg(false);
        goto L49
    L40:
        if (this.f13413q != r14) goto L49;
        if ((this.s - this.f13414r) <= 0.0f) goto L44;
    L46:
        d();
        goto L51
    L44:
        if (getX() >= (getScreenWidth() - 150)) goto L46;
        AnimatorSet r18 = new AnimatorSet();
        r18.play(ObjectAnimator.ofPropertyValuesHolder(this, new PropertyValuesHolder[]{PropertyValuesHolder.ofFloat("x", new float[]{getX(), this.f13405i})}));
        r18.setDuration(200);
        r18.addListener(new k(this, r5));
        r18.start();
        goto L51
    L47:
        this.s = r13;
        this.f13414r = r13;
        goto L49
    L6:
        if (Intrinsics.areEqual(Locale.ENGLISH.getLanguage(), r11) == true) goto L16;
        if (Intrinsics.areEqual(Locale.KOREA.getLanguage(), r11) == true) goto L16;
        if (Intrinsics.areEqual(Locale.JAPAN.getLanguage(), r11) == true) goto L16;
        if (Intrinsics.areEqual("ru", r11) == true) goto L16;
        return super.dispatchTouchEvent(r10);
    }

    public final void e() {
        setState(this.f13410n);
        setX(this.f13404h);
        setLettersBarBg(false);
    }

    public final LettersBar getLetterBar() {
        return this.d;
    }

    public final boolean getOIndexScrollbar_DEBUG() {
        return this.f13402b;
    }

    public final String getOIndexScrollbar_TAG() {
        return this.f13401a;
    }

    public final int getPOUND_POSITION_BOTTOM() {
        return this.f13417v;
    }

    public final int getPOUND_POSITION_TOP() {
        return this.f13416u;
    }

    public final int getVISIBILITY_LIMIT() {
        return this.B;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r5, int r10, int r11, int r12, int r13) {
        super.onLayout(r5, r10, r11, r12, r13);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int r5, int r10) {
        super.onMeasure(r5, r10);
        this.f13409m = View.MeasureSpec.getSize(r10);
        int r11 = View.MeasureSpec.getSize(r5);
        Object r12 = getParent();
        if (r12 == null) goto L7;
        int r13 = ((View) r12).getMeasuredWidth();
        if (r13 <= 0) goto L9;
        setHostWidth(r13);
    L9:
        if (this.f13402b == false) goto L12;
        Log.d(this.f13401a, "measure width:" + r11 + "  parentWidth:" + r13);
        return;
    L12:
        return;
    L7:
        r13 = 0;
        goto L9
    }

    @Override // android.view.View
    public final void onVisibilityChanged(View r5, int r10) {
        Intrinsics.checkNotNullParameter(r5, "changedView");
        super.onVisibilityChanged(r5, r10);
    }

    public final void setLongPressEnabled(boolean r5) {
        this.C = r5;
    }

    public final void setPoundPosition(int r5) {
        this.f13418w = r5;
    }

    public final void setPoundVisibility(boolean r5) {
        this.f13415t = r5;
    }

    public final void setQBListener(i r5) {
    }

    public final void setSurnameListener(j r5) {
    }
}
