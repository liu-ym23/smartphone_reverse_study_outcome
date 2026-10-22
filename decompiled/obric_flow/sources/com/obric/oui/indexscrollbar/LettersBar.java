package com.obric.oui.indexscrollbar;

import ai.j0;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewOutlineProvider;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import com.lynx.tasm.behavior.ui.utils.n;
import com.lynx.tasm.behavior.x0;
import com.obric.common.oui.R$color;
import com.obric.common.oui.R$dimen;
import com.obric.common.oui.R$drawable;
import com.obric.common.oui.R$id;
import com.obric.common.oui.R$layout;
import com.obric.oui.layout.OUILinearLayout;
import com.obric.oui.material.MaterialToken;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import ps.a;
import tr.b;
import tr.c;
import tr.d;
import tr.e;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u0007\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0002\u0015\u001fB'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u001d\u0010\u000e\u001a\u00020\r2\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n¢\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\u0013\u001a\u00020\r2\u0010\u0010\u0012\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0011\u0018\u00010\u0010¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0017\u001a\u00020\r2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015¢\u0006\u0004\b\u0017\u0010\u0018J\u0015\u0010\u001b\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\u0019¢\u0006\u0004\b\u001b\u0010\u001cJ\u0015\u0010\u001e\u001a\u00020\r2\u0006\u0010\u001d\u001a\u00020\u0019¢\u0006\u0004\b\u001e\u0010\u001cJ\u0017\u0010 \u001a\u00020\r2\b\u0010\u0016\u001a\u0004\u0018\u00010\u001f¢\u0006\u0004\b \u0010!J\u0017\u0010#\u001a\u00020\r2\u0006\u0010\"\u001a\u00020\u0006H\u0002¢\u0006\u0004\b#\u0010$J\u0017\u0010%\u001a\u00020\r2\u0006\u0010\"\u001a\u00020\u0006H\u0002¢\u0006\u0004\b%\u0010$R\"\u0010+\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010$R\"\u0010/\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b,\u0010'\u001a\u0004\b-\u0010)\"\u0004\b.\u0010$R\"\u00107\u001a\u0002008\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b1\u00102\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\"\u0010;\u001a\u0002008\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b8\u00102\u001a\u0004\b9\u00104\"\u0004\b:\u00106R\"\u0010?\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b<\u0010'\u001a\u0004\b=\u0010)\"\u0004\b>\u0010$R\"\u0010C\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b@\u0010'\u001a\u0004\bA\u0010)\"\u0004\bB\u0010$R\"\u0010G\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bD\u0010'\u001a\u0004\bE\u0010)\"\u0004\bF\u0010$R\u0017\u0010M\u001a\u00020H8\u0006¢\u0006\f\n\u0004\bI\u0010J\u001a\u0004\bK\u0010LR\u0017\u0010P\u001a\u00020H8\u0006¢\u0006\f\n\u0004\bN\u0010J\u001a\u0004\bO\u0010LR\"\u0010W\u001a\u00020Q8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b2\u0010R\u001a\u0004\bS\u0010T\"\u0004\bU\u0010V¨\u0006X"}, d2 = {"Lcom/obric/oui/indexscrollbar/LettersBar;", "Landroid/view/View;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "", "Ltr/b;", "letters", "", "setLetters", "(Ljava/util/List;)V", "", "Landroid/graphics/Bitmap;", "bitmaps", "setBitmapsSelected", "([Landroid/graphics/Bitmap;)V", "Ltr/d;", "listener", "setListener", "(Ltr/d;)V", "", "settled", "setSettled", "(Z)V", "showBg", "setShowBg", "Ltr/e;", "setOnBackgroundVisibleChangedListener", "(Ltr/e;)V", "index", "setLetterPaint", "(I)V", "setTouchedLetter", "n", "I", "getMHasChosenLetterFontColor", "()I", "setMHasChosenLetterFontColor", "mHasChosenLetterFontColor", "o", "getMNoChosenLetterFontColor", "setMNoChosenLetterFontColor", "mNoChosenLetterFontColor", "", "y", "F", "getDownX", "()F", "setDownX", "(F)V", "downX", "z", "getDownY", "setDownY", "downY", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "getTouchSlop", "setTouchSlop", "touchSlop", "B", "getOldChosen", "setOldChosen", "oldChosen", "C", "getNewChosen", "setNewChosen", "newChosen", "Ljava/lang/Runnable;", "D", "Ljava/lang/Runnable;", "getShowPopupTask", "()Ljava/lang/Runnable;", "showPopupTask", ExifInterface.LONGITUDE_EAST, "getDismissPopupTask", "dismissPopupTask", "", "J", "getShowPopupTaskStartTime", "()J", "setShowPopupTaskStartTime", "(J)V", "showPopupTaskStartTime", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class LettersBar extends View {
    public int A;
    public int B;
    public int C;
    public final c D;
    public final c E;
    public long F;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f13380a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public List f13381b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f13382c;
    public boolean d;
    public Bitmap[] e;
    public final int f;
    public final int g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f13383h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f13384i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f13385j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f13386k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Paint f13387l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Paint f13388m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f13389n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f13390o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Bitmap f13391p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final int f13392q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public d f13393r;
    public boolean s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public e f13394t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final ja.d f13395u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final int f13396v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public float f13397w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public String f13398x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public float f13399y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public float f13400z;

    @JvmOverloads
    public LettersBar(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        int r10 = 6;
        this(r5, null, r10, 0);
    }

    public static void a(LettersBar r5) {
        Intrinsics.checkNotNullParameter(r5, "this$0");
        int r10 = r5.B;
        int r11 = r5.C;
        if (r10 == r11) goto L16;
        if (r11 < 0) goto L16;
        List r12 = r5.f13381b;
        Intrinsics.checkNotNull(r12);
        if (r11 >= r12.size()) goto L16;
        r5.d(r5.C, "ACTION_DOWN");
        d r13 = r5.f13393r;
        if (r13 == null) goto L18;
        Intrinsics.checkNotNull(r13);
        List r14 = r5.f13381b;
        Intrinsics.checkNotNull(r14);
        String r15 = ((b) r14.get(r5.C)).f22165b;
        int r16 = OIndexScrollbar.D;
        ((OIndexScrollbar) ((x0) r13).f10812a).getClass();
    L18:
        r5.performHapticFeedback(26);     // Catch: Exception -> L13
    L15:
        r5.setTouchedLetter(r5.C);
    L13:
        e = move-exception;
        a.c("VibratorSmt", Intrinsics.stringPlus("performHapticFeedbackAOSP error: ", e));
    L16:
        r5.F = -1;
    }

    public static void b(LettersBar r5) {
        Intrinsics.checkNotNullParameter(r5, "this$0");
        if (r5.f13395u.j() == false) goto L6;
        r5.f13395u.i();
        r5.setTouchedLetter(-1);
        r5.setShowBg(false);
        return;
    }

    private final void setLetterPaint(int r5) {
        if (this.f13382c != r5) goto L5;
        boolean r10 = true;
    L6:
        Paint r11 = this.f13387l;
        if (r10 == false) goto L9;
        r11.setColor(this.f13389n);
    L10:
        r11.setFakeBoldText(false);
        r11.setTextSize(this.f13397w);
        List r12 = this.f13381b;
        Intrinsics.checkNotNull(r12);
        if (StringsKt.P(((b) r12.get(r5)).f22165b, ".") == true) goto L17;
        List r13 = this.f13381b;
        Intrinsics.checkNotNull(r13);
        if (((b) r13.get(r5)).f22164a != 1) goto L15;
        r11.setTextSize(this.f13384i);
        r11.setFakeBoldText(true);
        return;
    L15:
        r11.setTextSize(this.f13383h);
        return;
    L17:
        return;
    L9:
        r11.setColor(this.f13390o);
        goto L10
    L5:
        r10 = false;
        goto L6
    }

    private final void setTouchedLetter(int r5) {
        this.f13382c = r5;
        invalidate();
    }

    public final ArrayList c() {
        ArrayList r5 = new ArrayList();
        int r10 = this.f13386k;
        List r11 = this.f13381b;
        Intrinsics.checkNotNull(r11);
        if ((r10 / r11.size()) >= this.g) goto L5;
        List r12 = this.f13381b;
        Intrinsics.checkNotNull(r12);
        int r13 = (int) Math.max(2.0d, ((int) Math.ceil(r12.size() / ((this.f13386k / this.g) - 2))) * 2);
    L6:
        r5.add(0);
        List r14 = this.f13381b;
        Intrinsics.checkNotNull(r14);
        if (r13 >= (r14.size() / 2)) goto L12;
        int r15 = r13;
    L9:
        List r16 = this.f13381b;
        Intrinsics.checkNotNull(r16);
        if (r15 >= (r16.size() - 1)) goto L12;
        r15 = j0.d(r15, r5, r15, r13);
    L12:
        List r17 = this.f13381b;
        Intrinsics.checkNotNull(r17);
        if (r13 >= r17.size()) goto L15;
        List r18 = this.f13381b;
        Intrinsics.checkNotNull(r18);
        r5.add(Integer.valueOf(r18.size() - 1));
    L15:
        return r5;
    L5:
        r13 = 1;
        goto L6
    }

    public final void d(int r11, String r12) {
        float r5 = (float) Math.max(this.f13386k / c().size(), this.g);
        List r10 = this.f13381b;
        Intrinsics.checkNotNull(r10);
        String r13 = ((b) r10.get(r11)).f22165b;
        if (Intrinsics.areEqual(r13, this.f13398x) == false) goto L5;
        return;
    L5:
        a.a("LettersBar", "showPopupWindow, scene: " + r12 + ", c = " + r11 + ", letter = " + r13 + ", lastPopupLetter = " + this.f13398x);
        Bitmap[] r14 = this.e;
        Bitmap r15 = null;
        if (r14 != null) goto L8;
        Integer r16 = null;
    L9:
        List r17 = this.f13381b;
        Intrinsics.checkNotNull(r17);
        if (((b) r17.get(r11)).f22164a != 2) goto L15;
        if (r16 == null) goto L15;
        if (Integer.parseInt(r13) > r16.intValue()) goto L15;
        Bitmap[] r18 = this.e;
        Intrinsics.checkNotNull(r18);
        r15 = r18[Integer.parseInt(r13) - 1];
    L15:
        int r19 = getResources().getDimensionPixelSize(R$dimen.oui_h_title_bar_window);
        int r20 = (this.f13396v - getWidth()) - com.lynx.tasm.utils.a.B(68, this);
        int r21 = getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (r21 <= 0) goto L18;
        r19 = r19 + getResources().getDimensionPixelSize(r21);
    L18:
        int[] r22 = new int[2];
        getLocationInWindow(r22);
        float r110 = r11 * r5;
        int r111 = (int) ((r5 / 2) + (r110 + (getPaddingTop() + r22[1])));
        ja.d r23 = this.f13395u;
        r23.getClass();
        Intrinsics.checkNotNullParameter(this, "anchorView");
        Intrinsics.checkNotNullParameter(r13, "letter");
        ImageView r24 = (ImageView) r23.d;
        TextView r25 = (TextView) r23.f18303c;
        if (r15 != null) goto L29;
        if (r25 == null) goto L23;
        r25.setText(r13);
    L23:
        if (r24 == null) goto L26;
        r24.setVisibility(8);
    L26:
        if (r25 == null) goto L38;
        r25.setVisibility(0);
    L38:
        PopupWindow r26 = (PopupWindow) r23.f18301a;
        if (r26 != null) goto L41;
        a.g("OIndexPopupWindowLayout", "showPopup skipped: popupWindow is null.");
    L51:
        this.f13398x = r13;
        return;
    L41:
        View r27 = r26.getContentView();
        if (r27 != null) goto L45;
        a.g("OIndexPopupWindowLayout", "showPopup skipped: contentView is null.");
        goto L51
    L45:
        if (isAttachedToWindow() == true) goto L47;
        a.g("OIndexPopupWindowLayout", "showPopup skipped: anchorView is not attached to window.");
        goto L51
    L47:
        int r112 = RangesKt.coerceAtLeast(r111 - (r27.getMeasuredHeight() / 2), r19);
        if (r26.isShowing() == true) goto L50;
        r26.setElevation(com.lynx.tasm.utils.a.A(45.0f, this));
        r26.showAtLocation(this, 0, r20, r112);
        r27.setElevation(0.0f);
        goto L51
    L50:
        r26.update(r20, r112, -2, -2);
        goto L51
    L29:
        if (r25 == null) goto L32;
        r25.setVisibility(8);
    L32:
        if (r24 == null) goto L35;
        r24.setVisibility(0);
    L35:
        if (r24 == null) goto L38;
        r24.setImageBitmap(r15);
        goto L38
    L8:
        r16 = Integer.valueOf(r14.length);
        goto L9
    }

    @Override // android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r15) {
        Intrinsics.checkNotNullParameter(r15, "event");
        super.dispatchTouchEvent(r15);
        int r5 = r15.getAction();
        float r10 = r15.getY();
        this.B = this.f13382c;
        float r11 = (r10 - getPaddingTop()) / ((getHeight() - getPaddingTop()) - getPaddingBottom());
        List r12 = this.f13381b;
        Intrinsics.checkNotNull(r12);
        int r13 = (int) (r11 * r12.size());
        this.C = r13;
        c r14 = this.D;
        c r16 = this.E;
        ja.d r17 = this.f13395u;
        if (r5 != 0) goto L5;
        removeCallbacks(r16);
        this.f13399y = r15.getX();
        this.f13400z = r15.getY();
        this.A = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        if (r17.j() == true) goto L54;
        this.F = System.currentTimeMillis();
        postDelayed(r14, 200);
    L54:
        this.f13398x = null;
        setShowBg(false);
    L55:
        return true;
    L5:
        if (r5 != 1) goto L7;
        removeCallbacks(r14);
        if ((System.currentTimeMillis() - this.F) >= 100) goto L44;
        if (r17.j() == true) goto L44;
        this.F = -1;
        r14.run();
        postDelayed(r16, 200);
        return true;
    L44:
        if (r17.j() == false) goto L46;
        removeCallbacks(r16);
    L46:
        this.F = -1;
        if (this.d == false) goto L49;
        r17.i();
        setTouchedLetter(-1);
        setShowBg(false);
    L50:
        invalidate();
        goto L55
    L49:
        r17.i();
        goto L50
    L7:
        if (r5 == 2) goto L16;
        if (r5 != 3) goto L55;
        removeCallbacks(r14);
        if (r17.j() == false) goto L14;
        removeCallbacks(r16);
    L14:
        this.F = -1;
        r17.i();
        setTouchedLetter(-1);
        goto L55
    L16:
        if (Math.sqrt(Math.pow(r15.getY() - this.f13400z, 2.0d) + Math.pow(r15.getX() - this.f13399y, 2.0d)) >= this.A) goto L19;
        return true;
    L19:
        if (r17.j() == false) goto L36;
        if (r13 < 0) goto L36;
        List r18 = this.f13381b;
        Intrinsics.checkNotNull(r18);
        if (r13 >= r18.size()) goto L36;
        if (this.d == true) goto L26;
    L35:
        setTouchedLetter(r13);
        goto L36
    L26:
        if (this.B == r13) goto L35;
        if (this.f13393r == null) goto L35;
        removeCallbacks(r16);
        d(r13, "ACTION_MOVE");
        performHapticFeedback(26);     // Catch: Exception -> L32
    L34:
        d r19 = this.f13393r;
        Intrinsics.checkNotNull(r19);
        List r20 = this.f13381b;
        Intrinsics.checkNotNull(r20);
        String r21 = ((b) r20.get(r13)).f22165b;
        x0 r110 = (x0) r19;
        r110.getClass();
        int r22 = OIndexScrollbar.D;
        ((OIndexScrollbar) r110.f10812a).getClass();
    L32:
        e = move-exception;
        a.c("VibratorSmt", Intrinsics.stringPlus("performHapticFeedbackAOSP error: ", e));
    L36:
        setShowBg(false);
        goto L55
    }

    public final Runnable getDismissPopupTask() {
        return this.E;
    }

    public final float getDownX() {
        return this.f13399y;
    }

    public final float getDownY() {
        return this.f13400z;
    }

    public final int getMHasChosenLetterFontColor() {
        return this.f13389n;
    }

    public final int getMNoChosenLetterFontColor() {
        return this.f13390o;
    }

    public final int getNewChosen() {
        return this.C;
    }

    public final int getOldChosen() {
        return this.B;
    }

    public final Runnable getShowPopupTask() {
        return this.D;
    }

    public final long getShowPopupTaskStartTime() {
        return this.F;
    }

    public final int getTouchSlop() {
        return this.A;
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration r5) {
        super.onConfigurationChanged(r5);
        this.f13397w = com.lynx.tasm.utils.a.E(10, this);
        invalidate();
    }

    @Override // android.view.View
    public final void onDraw(Canvas r17) {
        Intrinsics.checkNotNullParameter(r17, "canvas");
        super.onDraw(r17);
        r17.save();
        r17.translate(0.0f, getPaddingTop());
        ArrayList r5 = c();
        float r10 = (float) Math.max(this.f13386k / r5.size(), this.g);
        Iterator r11 = r5.iterator();
        int r12 = 0;
    L4:
        if (r11.hasNext() == false) goto L24;
        Integer r13 = (Integer) r11.next();
        setLetterPaint(r13.intValue());
        float r14 = this.f13385j;
        Paint r15 = this.f13387l;
        List r16 = this.f13381b;
        Intrinsics.checkNotNull(r16);
        float r18 = 2;
        float r19 = r14 - (r15.measureText(((b) r16.get(r13.intValue())).f22165b) / r18);
        float r110 = (r10 / r18) + (r12 * r10);
        if (this.f13382c == r13.intValue()) goto L8;
    L10:
        List r20 = this.f13381b;
        Intrinsics.checkNotNull(r20);
        if (((b) r20.get(r13.intValue())).f22164a != 2) goto L16;
        int r21 = r13.intValue();
        List r22 = this.f13381b;
        if (r22 == null) goto L23;
        b r23 = (b) CollectionsKt.getOrNull(r22, r21);
    L23:
        r12 = r12 + 1;
        goto L4
    L16:
        int r24 = r13.intValue();
        List r25 = this.f13381b;
        Intrinsics.checkNotNull(r25);
        String r26 = ((b) r25.get(r24)).f22165b;
        if (StringsKt.P(r26, ".") == false) goto L22;
        Bitmap r27 = this.f13391p;
        if (r27 == null) goto L23;
        float r111 = r110 - (r27.getHeight() / 2);
        float r28 = this.f13392q;
        int r29 = r15.getColor();
        Paint r30 = this.f13388m;
        r30.setColorFilter(new PorterDuffColorFilter(r29, PorterDuff.Mode.SRC_IN));
        r17.drawBitmap(r27, r28, r111, r30);
        goto L23
    L22:
        Paint.FontMetricsInt r31 = r15.getFontMetricsInt();
        int r32 = r31.bottom;
        int r33 = r31.top;
        r17.drawText(r26, r19, (r110 - ((r32 - r33) / 2)) - r33, r15);
        goto L23
    L8:
        if (this.d == false) goto L10;
        Paint r34 = new Paint();
        r34.setColor(getContext().getResources().getColor(R$color.Transparent));
        int r112 = com.lynx.tasm.utils.a.B(14, this);
        com.lynx.tasm.utils.a.B(14, this);
        float r113 = r112 / 2.0f;
        float r114 = this.f13385j;
        r17.drawRoundRect(new RectF(r114 - r113, r110 - r113, r114 + r113, r110 + r113), r113, r113, r34);
        goto L10
    L24:
        r17.restore();
    }

    @Override // android.view.View
    public final void onMeasure(int r5, int r10) {
        super.onMeasure(r5, r10);
        int r11 = View.MeasureSpec.getMode(r10);
        int r12 = View.MeasureSpec.getSize(r10);
        if (r11 != Integer.MIN_VALUE) goto L5;
    L7:
        this.f13386k = (r12 - getPaddingTop()) - getPaddingBottom();
        return;
    L5:
        if (r11 == 1073741824) goto L7;
        r12 = 0;
        goto L7
    }

    public final void setBitmapsSelected(Bitmap[] r5) {
        this.e = r5;
    }

    public final void setDownX(float r5) {
        this.f13399y = r5;
    }

    public final void setDownY(float r5) {
        this.f13400z = r5;
    }

    public final void setLetters(List<b> r5) {
        this.f13381b = r5;
    }

    public final void setListener(d r5) {
        this.f13393r = r5;
    }

    public final void setMHasChosenLetterFontColor(int r5) {
        this.f13389n = r5;
    }

    public final void setMNoChosenLetterFontColor(int r5) {
        this.f13390o = r5;
    }

    public final void setNewChosen(int r5) {
        this.C = r5;
    }

    public final void setOldChosen(int r5) {
        this.B = r5;
    }

    public final void setOnBackgroundVisibleChangedListener(e r5) {
        this.f13394t = r5;
    }

    public final void setSettled(boolean r5) {
        this.d = r5;
        if (r5 == false) goto L5;
        setTouchedLetter(-1);
    L5:
        invalidate();
    }

    public final void setShowBg(boolean r5) {
        if (this.s == r5) goto L12;
        this.s = r5;
        if (r5 == false) goto L7;
        Drawable r10 = getResources().getDrawable(R$drawable.letters_bar_background);
    L8:
        setBackground(r10);
        e r11 = this.f13394t;
        if (r11 == null) goto L13;
        Intrinsics.checkNotNull(r11);
        boolean r12 = this.s;
        OIndexScrollbar.c((OIndexScrollbar) ((n) r11).f10761a, r12);
        return;
    L13:
        return;
    L7:
        r10 = null;
        goto L8
    }

    public final void setShowPopupTaskStartTime(long r5) {
        this.F = r5;
    }

    public final void setTouchSlop(int r5) {
        this.A = r5;
    }

    @JvmOverloads
    public LettersBar(Context r5, AttributeSet r10) {
        Intrinsics.checkNotNullParameter(r5, "context");
        this(r5, r10, 4, 0);
    }

    public /* synthetic */ LettersBar(Context r5, AttributeSet r10, int r11, int r12) {
        if ((r11 & 2) == 0) goto L5;
        r10 = null;
    L5:
        this(r5, r10, 0);
    }

    @JvmOverloads
    public LettersBar(Context r10, AttributeSet r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "context");
        super(r10, r11, r12);
        this.f13382c = -1;
        this.d = true;
        Paint r5 = new Paint();
        this.f13387l = r5;
        Paint r13 = new Paint(1);
        r13.setFilterBitmap(true);
        r13.setDither(true);
        this.f13388m = r13;
        Intrinsics.checkNotNullParameter(r10, "context");
        ja.d r14 = new ja.d();
        View r15 = LayoutInflater.from(r10).inflate(R$layout.o_index_scrollbar_popup_circle, null);
        View r16 = r15.findViewById(R$id.popup_container);
        r14.f18302b = r16;
        ImageView r17 = (ImageView) r15.findViewById(R$id.popup_img);
        r14.d = r17;
        TextView r18 = (TextView) r15.findViewById(R$id.popup_text);
        r14.f18303c = r18;
        if (r18 == null) goto L10;
        int r19 = r18.getCurrentTextColor();
        if (r17 == null) goto L10;
        r17.setColorFilter(r19, PorterDuff.Mode.SRC_IN);
    L10:
        if ((r16 instanceof OUILinearLayout) == false) goto L16;
        if (r16 == null) goto L16;
        OUILinearLayout r20 = (OUILinearLayout) r16;
        r20.setEnableShadowWidthRadius(true);
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if (com.obric.oui.material.n.i(r10) == false) goto L16;
        GradientDrawable r21 = new GradientDrawable();
        r21.setShape(1);
        r21.setSize(com.lynx.tasm.utils.a.B(48, r16), com.lynx.tasm.utils.a.B(48, r16));
        r21.setColor(0);
        r20.setBackground(r21);
        r20.setOutlineProvider(ViewOutlineProvider.BACKGROUND);
        a.a.A(r16, MaterialToken.OUI_Bg_Popup.invoke(Boolean.valueOf(!a.a.v(r16))));
    L16:
        r14.f18301a = new PopupWindow(r15, -2, -2, false);
        this.f13395u = r14;
        this.f13380a = r10;
        this.f13397w = com.lynx.tasm.utils.a.E(10, this);
        Context r22 = this.f13380a;
        Intrinsics.checkNotNull(r22);
        Resources r23 = r22.getResources();
        this.g = r23.getDimensionPixelSize(R$dimen.letters_bar_single_letter_min_height);
        this.f = com.lynx.tasm.utils.a.B(14, this);
        this.f13383h = r23.getDimensionPixelOffset(R$dimen.letters_bar_letter_font_size);
        this.f13384i = r23.getDimensionPixelOffset(R$dimen.letters_bar_letter_locale_font_size);
        this.f13385j = getPaddingLeft() + (this.f / 2);
        BitmapFactory.decodeResource(r23, R$drawable.letters_bar_highlight_icon);
        Drawable r24 = r23.getDrawable(R$drawable.letters_bar_highlight_icon);
        r24.getIntrinsicWidth();
        r24.getIntrinsicHeight();
        this.f13389n = r23.getColor(R$color.oui_functional_blue_6);
        this.f13390o = r23.getColor(R$color.oui_text_3b);
        Bitmap r25 = BitmapFactory.decodeResource(r23, R$drawable.letters_bar_dot);
        this.f13391p = r25;
        int r26 = this.f13385j;
        Intrinsics.checkNotNull(r25);
        this.f13392q = r26 - (r25.getWidth() / 2);
        r5.setTypeface(Typeface.create(Typeface.DEFAULT, 0));
        r5.setTextSize(this.f13383h);
        r5.setAntiAlias(true);
        this.f13396v = r10.getResources().getDisplayMetrics().widthPixels;
        this.B = -1;
        this.C = -1;
        this.D = new c(this, 0);
        this.E = new c(this, 1);
        this.F = -1;
    }
}
