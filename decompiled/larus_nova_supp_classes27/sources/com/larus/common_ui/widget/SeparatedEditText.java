package com.larus.common_ui.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Handler;
import android.text.Editable;
import android.text.InputFilter;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.core.content.ContextCompat;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.utils.i;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadTimer;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Timer;
import java.util.TimerTask;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.annotation.AnnotationRetention;
import kotlin.jvm.internal.Intrinsics;
import z19.u;
import z19.v;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u001c\n\u0002\u0018\u0002\n\u0002\b\u001b\u0018\u0000 s2\u00020\u0001:\u0002rsB'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0006\u00109\u001a\u00020:J\u000e\u0010;\u001a\u00020<2\u0006\u0010\u0016\u001a\u00020\u0007J\u000e\u0010=\u001a\u00020<2\u0006\u0010\u0017\u001a\u00020\u0007J\u000e\u0010>\u001a\u00020<2\u0006\u0010\u0018\u001a\u00020\u0007J\u000e\u0010?\u001a\u00020<2\u0006\u0010\u0019\u001a\u00020\u0007J\u000e\u0010@\u001a\u00020<2\u0006\u0010\u001a\u001a\u00020\u001bJ\u000e\u0010A\u001a\u00020<2\u0006\u0010\u001c\u001a\u00020\u001bJ\u000e\u0010B\u001a\u00020<2\u0006\u0010C\u001a\u00020\u001bJ\u000e\u0010D\u001a\u00020<2\u0006\u0010\u001d\u001a\u00020\u0007J\u000e\u0010E\u001a\u00020<2\u0006\u0010\u001e\u001a\u00020\u0007J\u000e\u0010F\u001a\u00020<2\u0006\u0010\u001f\u001a\u00020\u0007J\u000e\u0010G\u001a\u00020<2\u0006\u0010 \u001a\u00020\u0007J\u000e\u0010H\u001a\u00020<2\u0006\u0010%\u001a\u00020\u0007J\u000e\u0010I\u001a\u00020<2\u0006\u0010&\u001a\u00020\u0007J\u0010\u0010J\u001a\u00020<2\u0006\u0010)\u001a\u00020\u0007H\u0016J\u000e\u0010K\u001a\u00020<2\u0006\u0010L\u001a\u00020\u0007J\u000e\u0010M\u001a\u00020<2\u0006\u0010L\u001a\u00020\u0007J\u0006\u00108\u001a\u00020<J\u000e\u0010N\u001a\u00020<2\u0006\u0010O\u001a\u00020\u0007J\b\u0010P\u001a\u00020<H\u0002J(\u0010Q\u001a\u00020<2\u0006\u0010R\u001a\u00020\u00072\u0006\u0010S\u001a\u00020\u00072\u0006\u0010T\u001a\u00020\u00072\u0006\u0010U\u001a\u00020\u0007H\u0014J\b\u0010V\u001a\u00020<H\u0002J\u0010\u0010W\u001a\u00020<2\u0006\u0010X\u001a\u00020YH\u0014J\u0010\u0010Z\u001a\u00020<2\u0006\u0010X\u001a\u00020YH\u0002J\u0010\u0010[\u001a\u00020<2\u0006\u0010X\u001a\u00020YH\u0002J(\u0010\\\u001a\u00020<2\u0006\u0010]\u001a\u00020/2\u0006\u0010^\u001a\u00020\u00072\u0006\u0010_\u001a\u00020\u00072\u0006\u0010`\u001a\u00020\u0007H\u0014J\b\u0010a\u001a\u00020<H\u0014J\b\u0010b\u001a\u00020<H\u0014J\u0010\u0010c\u001a\u00020\u001b2\u0006\u0010d\u001a\u00020\u0007H\u0016J\u0018\u0010e\u001a\u00020<2\u0006\u0010f\u001a\u00020\u00072\u0006\u0010g\u001a\u00020\u0007H\u0014J\u0018\u0010h\u001a\u00020<2\u0006\u0010X\u001a\u00020Y2\u0006\u0010i\u001a\u00020/H\u0002J\u0010\u0010j\u001a\u00020<2\b\u0010k\u001a\u0004\u0018\u000101J\u0006\u0010l\u001a\u00020<J)\u0010m\u001a\u0002Hn\"\u0004\b\u0000\u0010n*\u0004\u0018\u00010\u001b2\u0006\u0010o\u001a\u0002Hn2\u0006\u0010p\u001a\u0002HnH\u0002¢\u0006\u0002\u0010qR\u000e\u0010\n\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0010X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020(X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020/X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00100\u001a\u0004\u0018\u000101X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u000203X\u0082.¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u000205X\u0082.¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006t"}, d2 = {"Lcom/larus/common_ui/widget/SeparatedEditText;", "Landroidx/appcompat/widget/AppCompatEditText;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "borderPaint", "Landroid/graphics/Paint;", "blockPaint", "textPaint", "cursorPaint", "borderRectF", "Landroid/graphics/RectF;", "boxRectF", "mWidth", "mHeight", "boxWidth", "boxHeight", "spacing", "corner", "maxLength", "borderWidth", "password", "", "showCursor", "cursorDuration", "cursorWidth", "cursorColor", "type", "separateEqual", "highLightEnable", "highLightStyle", "showKeyboard", "borderColor", "blockColor", "textSize", "", "textColor", "highLightColor", "errorColor", "highLightBefore", "isCursorShowing", "contentText", "", "textChangedListener", "Lcom/larus/common_ui/widget/SeparatedEditText$TextChangedListener;", "timer", "Ljava/util/Timer;", "timerTask", "Ljava/util/TimerTask;", "isCancel", "forceUseLtr", "showError", "getCurrentText", "", "setSpacing", "", "setCorner", "setMaxLength", "setBorderWidth", "setPassword", "setShowCursor", "setHighLightEnable", "enable", "setCursorDuration", "setCursorWidth", "setCursorColor", "setType", "setBorderColor", "setBlockColor", "setTextColor", "setHighLightColor", "color", "setErrorColor", "setHighlightStyle", "style", "init", "onSizeChanged", "w", "h", "oldw", "oldh", "initBox", "onDraw", "canvas", "Landroid/graphics/Canvas;", "drawCursor", "drawRect", "onTextChanged", "text", "start", "lengthBefore", "lengthAfter", "onAttachedToWindow", "onDetachedFromWindow", "onTextContextMenuItem", "id", "onSelectionChanged", "selStart", "selEnd", "drawText", "charSequence", "setTextChangedListener", "listener", "clearText", "matchValue", "T", "valueTrue", "valueFalse", "(Ljava/lang/Boolean;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "TextChangedListener", "Companion", "common-ui_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SeparatedEditText extends AppCompatEditText {
    public static final /* synthetic */ int K = 0;
    public int A;
    public int B;
    public final boolean C;
    public boolean D;
    public CharSequence E;
    public b F;
    public PthreadTimer G;
    public TimerTask H;
    public boolean I;
    public final boolean J;
    public Paint a;
    public Paint b;
    public Paint c;
    public Paint d;
    public RectF e;
    public RectF f;
    public int g;
    public int h;
    public int i;
    public int j;
    public int k;
    public int l;
    public int m;
    public int n;
    public boolean o;
    public boolean p;
    public int q;
    public int r;
    public int s;
    public int t;
    public final boolean u;
    public boolean v;
    public int w;
    public int x;
    public int y;
    public final float z;

    public static final class Companion {

        @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Lcom/larus/common_ui/widget/SeparatedEditText$Companion$StyleDef;", "", "common-ui_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
        @Retention(RetentionPolicy.SOURCE)
        @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
        public @interface StyleDef {
        }

        @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Lcom/larus/common_ui/widget/SeparatedEditText$Companion$TypeDef;", "", "common-ui_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
        @Retention(RetentionPolicy.SOURCE)
        @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
        public @interface TypeDef {
        }
    }

    public static final class a implements ActionMode.Callback {
        public a() {
        }

        @Override // android.view.ActionMode.Callback
        public final boolean onActionItemClicked(ActionMode r2, MenuItem r3) {
            Intrinsics.checkNotNullParameter(r2, "actionMode");
            Intrinsics.checkNotNullParameter(r3, "menuItem");
            return false;
        }

        @Override // android.view.ActionMode.Callback
        public final boolean onCreateActionMode(ActionMode r2, Menu r3) {
            Intrinsics.checkNotNullParameter(r2, "actionMode");
            Intrinsics.checkNotNullParameter(r3, "menu");
            return false;
        }

        @Override // android.view.ActionMode.Callback
        public final void onDestroyActionMode(ActionMode r2) {
            Intrinsics.checkNotNullParameter(r2, "actionMode");
        }

        @Override // android.view.ActionMode.Callback
        public final boolean onPrepareActionMode(ActionMode r2, Menu r3) {
            Intrinsics.checkNotNullParameter(r2, "actionMode");
            Intrinsics.checkNotNullParameter(r3, "menu");
            return false;
        }
    }

    public interface b {
        void a(CharSequence r1);

        void b(CharSequence r1);
    }

    public static final class c extends TimerTask {
        public final /* synthetic */ SeparatedEditText a;

        /* JADX WARN: Type inference failed for: r0v1, types: [android.widget.EditText, com.larus.common_ui.widget.SeparatedEditText] */
        @Override // java.util.TimerTask, java.lang.Runnable
        public final void run() {
            ?? r0 = this.a;     // Catch: Throwable -> L4
            r0.D = !r0.D;     // Catch: Throwable -> L4
            r0.postInvalidate();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public c(SeparatedEditText r1) {
            this.a = r1;
        }
    }

    static {
    }

    public SeparatedEditText(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public SeparatedEditText(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    public final boolean onTextContextMenuItem(int r1) {
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void c() {
        setText("");
    }

    public final void d() {
        int r0 = this.m;
        if (r0 == 6) goto L5;
    L7:
        int r1 = (this.g - (this.k * (r0 - 1))) / r0;
    L8:
        this.i = r1;
        this.j = this.h;
        RectF r2 = this.e;
        Paint r3 = null;
        if (r2 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("borderRectF");
        r2 = null;
    L11:
        r2.set(0.0f, 0.0f, this.g, this.h);
        Paint r4 = this.c;
        if (r4 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("textPaint");
    L15:
        float r5 = this.z;
        if (r5 != 0.0f) goto L18;
        boolean r6 = true;
    L19:
        if (r6 == false) goto L21;
        r5 = this.i * 0.4f;
    L21:
        r3.setTextSize(r5);
        return;
    L18:
        r6 = false;
        goto L19
    L14:
        r3 = r4;
        goto L15
    L5:
        if (this.u == true) goto L7;
        int r7 = this.g;
        int r8 = this.k;
        r1 = ((r7 - ((r0 - 1) * r8)) - (r8 * 3)) / r0;
        goto L8
    }

    public final String getCurrentText() {
        return this.E.toString();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onAttachedToWindow() {
        super/*android.widget.EditText*/.onAttachedToWindow();
        this.H = new c(this);
        PthreadTimer r1 = new PthreadTimer("SeparatedEditText");
        this.G = r1;
        TimerTask r0 = this.H;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("timerTask");
        r0 = null;
    L5:
        r1.scheduleAtFixedRate(r0, 0, this.q);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onDetachedFromWindow() {
        super/*android.widget.EditText*/.onDetachedFromWindow();
        if (this.I == true) goto L9;
        Timer r0 = this.G;
        if (r0 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("timer");
        r0 = null;
    L7:
        r0.cancel();
        this.I = true;
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onDraw(Canvas r17) {
        Intrinsics.checkNotNullParameter(r17, "canvas");
        int r8 = this.E.length();
        int r9 = this.m;
        int r11 = 0;
    L3:
        boolean r4 = true;
        if (r11 >= r9) goto L167;
        if (this.m != 6) goto L16;
        if (r11 < 3) goto L12;
        RectF r2 = this.f;
        if (r2 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("boxRectF");
        r2 = null;
    L11:
        int r5 = 5 - r11;
        float r12 = this.g - (this.k * r5);
        float r15 = this.i;
        r2.set(r12 - ((6 - r11) * r15), 0.0f, r12 - (r15 * r5), this.j);
    L20:
        Boolean r3 = Boolean.valueOf(this.C);
        if (r8 < r11) goto L23;
        boolean r6 = true;
    L24:
        Boolean r7 = Boolean.valueOf(r6);
        if (r8 != r11) goto L27;
        boolean r10 = true;
    L28:
        Boolean r13 = Boolean.valueOf(r10);
        Boolean r14 = Boolean.TRUE;
        if (Intrinsics.areEqual(r3, r14) == true) goto L32;
        r7 = r13;
    L32:
        boolean r16 = r7.booleanValue();
        int r18 = this.t;
        if (r18 == 1) goto L144;
        if (r18 == 2) goto L67;
        if (r18 != 3) goto L165;
        RectF r1 = this.f;
        if (r1 != null) goto L41;
        Intrinsics.throwUninitializedPropertyAccessException("boxRectF");
        r1 = null;
    L41:
        float r20 = r1.left;
        RectF r21 = this.f;
        if (r21 != null) goto L44;
        Intrinsics.throwUninitializedPropertyAccessException("boxRectF");
        r21 = null;
    L44:
        float r22 = r21.bottom;
        RectF r23 = this.f;
        if (r23 != null) goto L47;
        Intrinsics.throwUninitializedPropertyAccessException("boxRectF");
        r23 = null;
    L47:
        float r110 = r23.right;
        RectF r24 = this.f;
        if (r24 != null) goto L50;
        Intrinsics.throwUninitializedPropertyAccessException("boxRectF");
        r24 = null;
    L50:
        float r111 = r24.bottom;
        Paint r25 = this.a;
        if (r25 != null) goto L53;
        Intrinsics.throwUninitializedPropertyAccessException("borderPaint");
        Paint r26 = null;
    L55:
        if (this.v == true) goto L57;
    L60:
        r4 = false;
    L61:
        Boolean r27 = Boolean.valueOf(r4);
        Integer r28 = Integer.valueOf(this.B);
        Integer r30 = Integer.valueOf(this.x);
        if (Intrinsics.areEqual(r27, r14) == true) goto L65;
        r28 = r30;
    L65:
        r26.setColor(r28.intValue());
        Unit r31 = Unit.INSTANCE;
        r17.drawLine(r20, r22, r110, r111, r26);
        goto L165
    L57:
        if (hasFocus() == false) goto L60;
        if (r16 == false) goto L60;
    L53:
        r26 = r25;
    L165:
        r11 = r11 + 1;
        goto L3
    L67:
        if (this.v == true) goto L69;
    L119:
        RectF r32 = this.f;
        if (r32 != null) goto L122;
        Intrinsics.throwUninitializedPropertyAccessException("boxRectF");
        r32 = null;
    L122:
        float r33 = this.l;
        Paint r34 = this.b;
        if (r34 != null) goto L125;
        Intrinsics.throwUninitializedPropertyAccessException("blockPaint");
        r34 = null;
    L125:
        r34.setColor(this.y);
        Unit r35 = Unit.INSTANCE;
        r17.drawRoundRect(r32, r33, r33, r34);
        if (this.w != 2) goto L165;
        RectF r36 = this.f;
        if (r36 != null) goto L130;
        Intrinsics.throwUninitializedPropertyAccessException("boxRectF");
        r36 = null;
    L130:
        float r37 = r36.left + (this.n / 2);
        RectF r38 = this.f;
        if (r38 != null) goto L133;
        Intrinsics.throwUninitializedPropertyAccessException("boxRectF");
        r38 = null;
    L133:
        float r40 = r38.top + (this.n / 2);
        RectF r41 = this.f;
        if (r41 != null) goto L136;
        Intrinsics.throwUninitializedPropertyAccessException("boxRectF");
        r41 = null;
    L136:
        float r42 = r41.right - (this.n / 2);
        RectF r112 = this.f;
        if (r112 != null) goto L139;
        Intrinsics.throwUninitializedPropertyAccessException("boxRectF");
        r112 = null;
    L139:
        RectF r43 = new RectF(r37, r40, r42, r112.bottom - (this.n / 2));
        float r44 = this.l;
        Paint r45 = this.a;
        if (r45 != null) goto L142;
        Intrinsics.throwUninitializedPropertyAccessException("borderPaint");
        Paint r46 = null;
    L143:
        r46.setColor(this.x);
        r17.drawRoundRect(r43, r44, r44, r46);
        goto L165
    L142:
        r46 = r45;
        goto L143
    L69:
        if (hasFocus() == false) goto L119;
        if (r16 == false) goto L119;
        if (this.w != 1) goto L96;
        RectF r47 = this.f;
        if (r47 != null) goto L76;
        Intrinsics.throwUninitializedPropertyAccessException("boxRectF");
        r47 = null;
    L76:
        float r48 = this.l;
        Paint r50 = this.b;
        if (r50 != null) goto L79;
        Intrinsics.throwUninitializedPropertyAccessException("blockPaint");
        r50 = null;
    L79:
        r50.setColor(this.y);
        Unit r51 = Unit.INSTANCE;
        r17.drawRoundRect(r47, r48, r48, r50);
        RectF r52 = this.f;
        if (r52 != null) goto L82;
        Intrinsics.throwUninitializedPropertyAccessException("boxRectF");
        r52 = null;
    L82:
        float r53 = r52.left + (this.n / 2);
        RectF r54 = this.f;
        if (r54 != null) goto L85;
        Intrinsics.throwUninitializedPropertyAccessException("boxRectF");
        r54 = null;
    L85:
        float r55 = r54.top + (this.n / 2);
        RectF r56 = this.f;
        if (r56 != null) goto L88;
        Intrinsics.throwUninitializedPropertyAccessException("boxRectF");
        r56 = null;
    L88:
        float r57 = r56.right - (this.n / 2);
        RectF r113 = this.f;
        if (r113 != null) goto L91;
        Intrinsics.throwUninitializedPropertyAccessException("boxRectF");
        r113 = null;
    L91:
        RectF r58 = new RectF(r53, r55, r57, r113.bottom - (this.n / 2));
        float r60 = this.l;
        Paint r61 = this.a;
        if (r61 != null) goto L94;
        Intrinsics.throwUninitializedPropertyAccessException("borderPaint");
        Paint r62 = null;
    L95:
        r62.setColor(this.x);
        r17.drawRoundRect(r58, r60, r60, r62);
        goto L165
    L94:
        r62 = r61;
        goto L95
    L96:
        RectF r63 = this.f;
        if (r63 != null) goto L99;
        Intrinsics.throwUninitializedPropertyAccessException("boxRectF");
        r63 = null;
    L99:
        float r64 = this.l;
        Paint r65 = this.b;
        if (r65 != null) goto L102;
        Intrinsics.throwUninitializedPropertyAccessException("blockPaint");
        r65 = null;
    L102:
        r65.setColor(this.y);
        Unit r66 = Unit.INSTANCE;
        r17.drawRoundRect(r63, r64, r64, r65);
        RectF r67 = this.f;
        if (r67 != null) goto L105;
        Intrinsics.throwUninitializedPropertyAccessException("boxRectF");
        r67 = null;
    L105:
        float r68 = r67.left + (this.n / 2);
        RectF r70 = this.f;
        if (r70 != null) goto L108;
        Intrinsics.throwUninitializedPropertyAccessException("boxRectF");
        r70 = null;
    L108:
        float r71 = r70.top + (this.n / 2);
        RectF r72 = this.f;
        if (r72 != null) goto L111;
        Intrinsics.throwUninitializedPropertyAccessException("boxRectF");
        r72 = null;
    L111:
        float r73 = r72.right - (this.n / 2);
        RectF r114 = this.f;
        if (r114 != null) goto L114;
        Intrinsics.throwUninitializedPropertyAccessException("boxRectF");
        r114 = null;
    L114:
        RectF r74 = new RectF(r68, r71, r73, r114.bottom - (this.n / 2));
        float r75 = this.l;
        Paint r76 = this.a;
        if (r76 != null) goto L117;
        Intrinsics.throwUninitializedPropertyAccessException("borderPaint");
        Paint r77 = null;
    L118:
        r77.setColor(this.B);
        r17.drawRoundRect(r74, r75, r75, r77);
        goto L165
    L117:
        r77 = r76;
        goto L118
    L144:
        if (r11 == 0) goto L165;
        if (r11 == this.m) goto L165;
        RectF r78 = this.f;
        if (r78 != null) goto L151;
        Intrinsics.throwUninitializedPropertyAccessException("boxRectF");
        r78 = null;
    L151:
        float r80 = r78.left;
        RectF r81 = this.f;
        if (r81 != null) goto L154;
        Intrinsics.throwUninitializedPropertyAccessException("boxRectF");
        r81 = null;
    L154:
        float r82 = r81.top;
        RectF r83 = this.f;
        if (r83 != null) goto L157;
        Intrinsics.throwUninitializedPropertyAccessException("boxRectF");
        r83 = null;
    L157:
        float r84 = r83.left;
        RectF r85 = this.f;
        if (r85 != null) goto L160;
        Intrinsics.throwUninitializedPropertyAccessException("boxRectF");
        r85 = null;
    L160:
        float r86 = r85.bottom;
        Paint r87 = this.a;
        if (r87 != null) goto L163;
        Intrinsics.throwUninitializedPropertyAccessException("borderPaint");
        Paint r88 = null;
    L164:
        r88.setColor(this.x);
        Unit r90 = Unit.INSTANCE;
        r17.drawLine(r80, r82, r84, r86, r88);
        goto L165
    L163:
        r88 = r87;
        goto L164
    L27:
        r10 = false;
        goto L28
    L23:
        r6 = false;
        goto L24
    L12:
        RectF r91 = this.f;
        if (r91 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("boxRectF");
        r91 = null;
    L15:
        int r92 = this.k * r11;
        int r115 = this.i;
        float r116 = r115;
        r91.set(r92 + (r11 * r116), 0.0f, (r92 + (r115 * r11)) + r116, this.j);
        goto L20
    L16:
        RectF r93 = this.f;
        if (r93 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("boxRectF");
        r93 = null;
    L19:
        int r94 = this.k * r11;
        int r117 = this.i;
        float r118 = r117;
        r93.set(r94 + (r11 * r118), 0.0f, (r94 + (r117 * r11)) + r118, this.j);
        goto L20
    L167:
        if (this.t != 1) goto L175;
        RectF r95 = this.e;
        if (r95 != null) goto L171;
        Intrinsics.throwUninitializedPropertyAccessException("borderRectF");
        r95 = null;
    L171:
        float r96 = this.l;
        Paint r97 = this.a;
        if (r97 != null) goto L174;
        Intrinsics.throwUninitializedPropertyAccessException("borderPaint");
        r97 = null;
    L174:
        r17.drawRoundRect(r95, r96, r96, r97);
    L175:
        CharSequence r98 = this.E;
        int r100 = r98.length();
        int r101 = 0;
    L176:
        if (r101 >= r100) goto L211;
        if (i.h(getContext()) == false) goto L183;
        if (this.J == true) goto L183;
        int r102 = getWidth();
        int r103 = this.k * r101;
        int r119 = this.i;
        int r104 = (r102 - (r103 + (r119 * r101))) - r119;
    L190:
        float r105 = (this.i / 2) + r104;
        Paint r120 = this.c;
        if (r120 != null) goto L193;
        Intrinsics.throwUninitializedPropertyAccessException("textPaint");
        r120 = null;
    L193:
        float r121 = 2;
        int r106 = (int) (r105 - (r120.measureText(String.valueOf(r98.charAt(r101))) / r121));
        float r122 = (this.j / 2) + 0;
        Paint r123 = this.c;
        if (r123 != null) goto L196;
        Intrinsics.throwUninitializedPropertyAccessException("textPaint");
        r123 = null;
    L196:
        float r124 = r123.descent();
        Paint r125 = this.c;
        if (r125 != null) goto L199;
        Intrinsics.throwUninitializedPropertyAccessException("textPaint");
        r125 = null;
    L199:
        int r126 = (int) (r122 - ((r124 + r125.ascent()) / r121));
        int r127 = this.i;
        int r107 = r104 + (r127 / 2);
        int r128 = this.j;
        int r129 = (r128 / 2) + 0;
        int r130 = Math.min(r127, r128) / 6;
        if (this.o == false) goto L205;
        float r108 = r107;
        float r109 = r129;
        float r131 = r130;
        Paint r132 = this.c;
        if (r132 != null) goto L204;
        Intrinsics.throwUninitializedPropertyAccessException("textPaint");
        r132 = null;
    L204:
        r17.drawCircle(r108, r109, r131, r132);
    L209:
        r101 = r101 + 1;
        goto L176
    L205:
        String r133 = String.valueOf(r98.charAt(r101));
        float r134 = r106;
        float r135 = r126;
        Paint r136 = this.c;
        if (r136 != null) goto L208;
        Intrinsics.throwUninitializedPropertyAccessException("textPaint");
        r136 = null;
    L208:
        r17.drawText(r133, r134, r135, r136);
    L183:
        if (this.m == 6) goto L185;
        int r137 = this.k * r101;
        int r138 = this.i;
    L189:
        r104 = r137 + (r138 * r101);
        goto L190
    L185:
        if (r101 >= 3) goto L187;
        r137 = this.k * r101;
        r138 = this.i;
        goto L189
    L187:
        r104 = (this.g - (this.k * (5 - r101))) - (this.i * (6 - r101));
        goto L190
    L211:
        if (this.D == false) goto L213;
        return;
    L213:
        if (this.p == true) goto L215;
        return;
    L215:
        if (this.E.length() < this.m) goto L217;
        return;
    L217:
        if (hasFocus() == false) goto L253;
        int r139 = this.E.length() + 1;
        if (i.h(getContext()) == false) goto L224;
        if (this.J == true) goto L224;
        int r140 = getWidth();
        int r141 = r139 - 1;
        int r142 = this.k * r141;
        int r143 = this.i;
        int r144 = r140 - ((r142 + (r141 * r143)) + (r143 / 2));
    L231:
        int r145 = this.j;
        int r146 = r145 / 4;
        int r147 = r145 - r146;
        float r148 = r144;
        float r149 = r146;
        float r150 = r147;
        Paint r151 = this.d;
        if (r151 != null) goto L234;
        Intrinsics.throwUninitializedPropertyAccessException("cursorPaint");
        Paint r152 = null;
    L235:
        r17.drawLine(r148, r149, r148, r150, r152);
        return;
    L234:
        r152 = r151;
    L224:
        if (this.m == 6) goto L226;
        int r153 = r139 - 1;
        int r154 = this.k * r153;
        int r155 = this.i;
        int r156 = r154 + (r153 * r155);
        int r157 = r155 / 2;
    L230:
        r144 = r156 + r157;
        goto L231
    L226:
        if (r139 > 3) goto L228;
        int r158 = r139 - 1;
        int r159 = this.k * r158;
        int r160 = this.i;
        r156 = r159 + (r158 * r160);
        r157 = r160 / 2;
        goto L230
    L228:
        int r161 = 6 - r139;
        int r162 = this.g - (this.k * r161);
        int r163 = this.i;
        r144 = (r162 - (r161 * r163)) - (r163 / 2);
        goto L231
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setBlockColor(int r1) {
        this.y = r1;
        postInvalidate();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setBorderColor(int r1) {
        this.x = r1;
        postInvalidate();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setBorderWidth(int r1) {
        this.n = r1;
        postInvalidate();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setCorner(int r1) {
        this.l = r1;
        postInvalidate();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setCursorColor(int r1) {
        this.s = r1;
        postInvalidate();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setCursorDuration(int r1) {
        this.q = r1;
        postInvalidate();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setCursorWidth(int r1) {
        this.r = r1;
        postInvalidate();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setErrorColor(int r1) {
        postInvalidate();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setHighLightColor(int r1) {
        this.B = r1;
        postInvalidate();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setHighLightEnable(boolean r1) {
        this.v = r1;
        postInvalidate();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setHighlightStyle(int r1) {
        this.w = r1;
        postInvalidate();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setMaxLength(int r3) {
        this.m = r3;
        setFilters(new InputFilter[]{new InputFilter.LengthFilter(r3)});
        d();
        c();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setPassword(boolean r1) {
        this.o = r1;
        postInvalidate();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setShowCursor(boolean r1) {
        this.p = r1;
        postInvalidate();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setSpacing(int r1) {
        this.k = r1;
        postInvalidate();
    }

    public final void setTextChangedListener(b r1) {
        this.F = r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setTextColor(int r1) {
        this.A = r1;
        postInvalidate();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setType(int r1) {
        this.t = r1;
        postInvalidate();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onSelectionChanged(int r3, int r4) {
        Editable r0 = getText();
        if (r0 != null) goto L5;
    L10:
        super/*android.widget.EditText*/.onSelectionChanged(r3, r4);
        return;
    L5:
        if (r3 == r0.length()) goto L7;
    L8:
        setSelection(r0.length(), r0.length());
        return;
    L7:
        if (r4 == r0.length()) goto L10;
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SeparatedEditText(Context r7, AttributeSet r8, int r9) {
        Intrinsics.checkNotNullParameter(r7, "context");
        super(r7, r8, r9);
        this.E = "";
        setLayoutDirection(0);
        setTextIsSelectable(false);
        setCustomSelectionActionModeCallback(new a());
        TypedArray r10 = r7.obtainStyledAttributes(r8, new int[]{2130970904, 2130970905, 2130970906, 2130970907, 2130970963, 2130970991, 2130970992, 2130970993, 2130971584, 2130971617, 2130971625, 2130971626, 2130971627, 2130971628, 2130972047, 2130972102, 2130972232, 2130972233, 2130972248, 2130972250, 2130972326, 2130972327});
        this.o = r10.getBoolean(15, false);
        this.p = r10.getBoolean(18, true);
        this.v = r10.getBoolean(11, false);
        this.x = r10.getColor(2, ContextCompat.getColor(getContext(), v19.c.b(2130972079, getContext(), 2131103136)));
        this.y = r10.getColor(0, ContextCompat.getColor(getContext(), v19.c.b(2130970533, getContext(), 2131102542)));
        this.z = r10.getDimension(21, 0.0f);
        this.A = r10.getColor(20, ContextCompat.getColor(getContext(), v19.c.b(2130972079, getContext(), 2131103136)));
        this.B = r10.getColor(12, ContextCompat.getColor(getContext(), v19.c.b(2130972079, getContext(), 2131103136)));
        this.C = r10.getBoolean(10, false);
        this.s = r10.getColor(5, ContextCompat.getColor(getContext(), v19.c.b(2130972123, getContext(), 2131103203)));
        this.l = (int) r10.getDimension(4, 0.0f);
        this.k = (int) r10.getDimension(1, 0.0f);
        this.t = r10.getInt(17, 1);
        this.u = r10.getBoolean(16, true);
        this.w = r10.getInt(13, 1);
        this.m = r10.getInt(14, 6);
        this.q = r10.getInt(6, 500);
        this.r = (int) r10.getDimension(7, 2.0f);
        this.n = (int) r10.getDimension(3, 5.0f);
        boolean r11 = r10.getBoolean(19, true);
        this.J = r10.getBoolean(9, false);
        r10.getColor(8, ContextCompat.getColor(getContext(), 2131102650));
        r10.recycle();
        setFocusableInTouchMode(true);
        setFocusable(true);
        requestFocus();
        setCursorVisible(false);
        setFilters(new InputFilter[]{new InputFilter.LengthFilter(this.m)});
        if (r11 == false) goto L5;
        new Handler().postDelayed(new u(this), 500);
    L5:
        Paint r12 = new Paint();
        r12.setAntiAlias(true);
        r12.setColor(this.y);
        r12.setStyle(Paint.Style.FILL);
        r12.setStrokeWidth(1.0f);
        this.b = r12;
        Paint r13 = new Paint();
        r13.setAntiAlias(true);
        r13.setColor(this.A);
        r13.setStyle(Paint.Style.FILL_AND_STROKE);
        r13.setStrokeWidth(1.0f);
        this.c = r13;
        Paint r14 = new Paint();
        r14.setAntiAlias(true);
        r14.setColor(this.x);
        r14.setStyle(Paint.Style.STROKE);
        r14.setStrokeWidth(this.n);
        this.a = r14;
        Paint r15 = new Paint();
        r15.setAntiAlias(true);
        r15.setColor(this.s);
        r15.setStyle(Paint.Style.FILL_AND_STROKE);
        r15.setStrokeWidth(this.r);
        this.d = r15;
        this.e = new RectF();
        this.f = new RectF();
        if (this.t != 1) goto L8;
        this.k = 0;
    L8:
        this.H = new v(this);
        this.G = new PthreadTimer("SeparatedEditText");
    }

    public /* synthetic */ SeparatedEditText(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onSizeChanged(int r1, int r2, int r3, int r4) {
        super/*android.widget.EditText*/.onSizeChanged(r1, r2, r3, r4);
        this.g = r1;
        this.h = r2;
        d();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onTextChanged(CharSequence r2, int r3, int r4, int r5) {
        Intrinsics.checkNotNullParameter(r2, "text");
        super/*android.widget.EditText*/.onTextChanged(r2, r3, r4, r5);
        this.E = r2;
        invalidate();
        b r6 = this.F;
        if (r6 != null) goto L5;
        return;
    L5:
        if (r2.length() != this.m) goto L7;
        r6.b(r2);
        return;
    L7:
        r6.a(r2);
    }
}
