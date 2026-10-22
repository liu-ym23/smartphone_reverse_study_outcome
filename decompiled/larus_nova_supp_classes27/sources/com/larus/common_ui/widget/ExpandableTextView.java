package com.larus.common_ui.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.DynamicLayout;
import android.text.Layout;
import android.text.Selection;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import com.bytedance.mt.protector.impl.PatternProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public class ExpandableTextView extends AppCompatTextView {
    public static final /* synthetic */ int C = 0;
    public d A;
    public final Pattern B;
    public String a;
    public String b;
    public String c;
    public String d;
    public String e;
    public String f;
    public String g;
    public boolean h;
    public boolean i;
    public boolean j;
    public int k;
    public int l;
    public int m;
    public int n;
    public int o;
    public int p;
    public int q;
    public int r;
    public e s;
    public TextView.BufferType t;
    public TextPaint u;
    public Layout v;
    public int w;
    public int x;
    public int y;
    public CharSequence z;

    public class a implements ViewTreeObserver.OnGlobalLayoutListener {
        public final /* synthetic */ ExpandableTextView a;

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public final void onGlobalLayout() {
            this.a.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            ExpandableTextView r0 = this.a;
            ExpandableTextView.y(r0, ExpandableTextView.x(r0), this.a.t);
        }

        public a(ExpandableTextView r1) {
            this.a = r1;
        }
    }

    public class b implements View.OnClickListener {
        public final /* synthetic */ ExpandableTextView a;

        public b(ExpandableTextView r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r1) {
            ExpandableTextView.z(this.a);
        }
    }

    public class c extends LinkMovementMethod {
        public e a;
        public final /* synthetic */ ExpandableTextView b;

        public c(ExpandableTextView r1) {
            this.b = r1;
        }

        public static e a(TextView r2, Spannable r3, MotionEvent r4) {
            int r0 = (int) r4.getX();
            int r5 = (int) r4.getY();
            int r1 = r0 - r2.getTotalPaddingLeft();
            int r6 = r5 - r2.getTotalPaddingTop();
            int r7 = r1 + r2.getScrollX();
            int r8 = r6 + r2.getScrollY();
            Layout r9 = r2.getLayout();
            int r10 = r9.getOffsetForHorizontal(r9.getLineForVertical(r8), r7);
            e[] r11 = (e[]) r3.getSpans(r10, r10, e.class);
            if (r11.length > 0) goto L7;
            return null;
        L7:
            return r11[0];
        }

        @Override // android.text.method.LinkMovementMethod, android.text.method.ScrollingMovementMethod, android.text.method.BaseMovementMethod, android.text.method.MovementMethod
        public final boolean onTouchEvent(TextView r6, Spannable r7, MotionEvent r8) {
            ExpandableTextView r0 = this.b;
            int r1 = ExpandableTextView.C;
            r0.getClass();
            if (r8.getAction() != 0) goto L8;
            e r9 = a(r6, r7, r8);
            this.a = r9;
            if (r9 == null) goto L17;
            r9.a = true;
            Selection.setSelection(r7, r7.getSpanStart(r9), r7.getSpanEnd(this.a));
        L17:
            return true;
        L8:
            if (r8.getAction() != 2) goto L13;
            e r10 = a(r6, r7, r8);
            e r11 = this.a;
            if (r11 == null) goto L17;
            if (r10 == r11) goto L17;
            r11.a = false;
            this.a = null;
            Selection.removeSelection(r7);
            goto L17
        L13:
            e r2 = this.a;
            if (r2 == null) goto L16;
            r2.a = false;
            super.onTouchEvent(r6, r7, r8);
        L16:
            this.a = null;
            Selection.removeSelection(r7);
            goto L17
        }
    }

    public interface d {
        void a(ExpandableTextView r1);

        void b();

        void c(ExpandableTextView r1);
    }

    public class e extends ClickableSpan {
        public boolean a;
        public long b;
        public final /* synthetic */ ExpandableTextView c;

        public e(ExpandableTextView r3) {
            this.c = r3;
            this.b = 0;
        }

        @Override // android.text.style.ClickableSpan
        public final void onClick(View r7) {
            long r0 = System.currentTimeMillis();
            if ((r0 - this.b) <= 300) goto L6;
            ExpandableTextView.z(this.c);
            this.b = r0;
            return;
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public final void updateDrawState(TextPaint r5) {
            super.updateDrawState(r5);
            ExpandableTextView r0 = this.c;
            int r1 = r0.r;
            if (r1 != 0) goto L5;
            r5.setColor(r0.l);
            if (this.a == false) goto L15;
            int r2 = this.c.n;
        L16:
            r5.bgColor = r2;
        L17:
            r5.setUnderlineText(false);
            return;
        L15:
            r2 = 0;
            goto L16
        L5:
            if (r1 != 1) goto L17;
            r5.setColor(r0.m);
            if (this.a == false) goto L10;
            int r3 = this.c.o;
        L11:
            r5.bgColor = r3;
            goto L17
        L10:
            r3 = 0;
            goto L11
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private CharSequence getNewTextByConfig() {
        if (TextUtils.isEmpty(this.z) == false) goto L9;
        d r1 = this.A;
        if (r1 == null) goto L8;
        r1.b();
    L8:
        return this.z;
    L9:
        Layout r2 = getLayout();
        this.v = r2;
        if (r2 == null) goto L13;
        this.x = r2.getWidth();
    L13:
        if (this.x <= 0) goto L15;
    L25:
        this.u = getPaint();
        this.w = -1;
        int r3 = this.r;
        String r7 = "";
        if (r3 == 0) goto L65;
        if (r3 == 1) goto L34;
        d r4 = this.A;
        if (r4 == null) goto L32;
        r4.b();
    L32:
        return this.z;
    L34:
        if (this.j == false) goto L36;
    L42:
        DynamicLayout r5 = new DynamicLayout(this.z, this.u, this.x, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
        this.v = r5;
        int r6 = r5.getLineCount();
        this.w = r6;
        if (r6 > this.k) goto L49;
        d r8 = this.A;
        if (r8 == null) goto L48;
        r8.b();
    L48:
        return this.z;
    L49:
        SpannableStringBuilder r9 = new SpannableStringBuilder(this.z);
        if (this.j == false) goto L57;
        SpannableStringBuilder r10 = r9.append(this.e).append(this.c);
        String r11 = this.g;
        if (r11 == null) goto L55;
        r7 = r11;
    L55:
        r10.append(r7);
        int r12 = r9.length() - A(this.g);
        r9.setSpan(this.s, r12 - A(this.c), r12, 33);
    L57:
        if (this.q <= 0) goto L61;
        int r13 = this.w - 1;
        int r14 = getValidLayout().getLineEnd(r13);
        if ((getValidLayout().getWidth() - ((int) (((double) this.u.measureText(this.z.subSequence(getValidLayout().getLineStart(r13), r14).toString())) + 0.5d))) >= this.q) goto L61;
        r9.append("\r\n");
    L61:
        d r15 = this.A;
        if (r15 == null) goto L64;
        r15.b();
    L64:
        return r9;
    L36:
        if (this.q != 0) goto L42;
        d r16 = this.A;
        if (r16 == null) goto L41;
        r16.b();
    L41:
        return this.z;
    L65:
        DynamicLayout r17 = new DynamicLayout(this.z, this.u, this.x, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
        this.v = r17;
        int r18 = r17.getLineCount();
        this.w = r18;
        if (r18 > this.k) goto L72;
        d r20 = this.A;
        if (r20 == null) goto L71;
        r20.b();
    L71:
        return this.z;
    L72:
        int r21 = getValidLayout().getLineEnd(this.k - 1);
        int r22 = getValidLayout().getLineStart(this.k - 1);
        int r23 = r21 - A(this.a);
        int r110 = 0;
        if (this.i == false) goto L75;
        int r111 = (A(this.d) + A(this.b)) + A(this.f);
    L76:
        int r24 = r23 - r111;
        if (r24 <= r22) goto L80;
        r21 = r24;
    L80:
        int r25 = getValidLayout().getWidth() - ((int) (((double) this.u.measureText(this.z.subSequence(r22, r21).toString())) + 0.5d));
        int r112 = this.p;
        if (r112 <= 0) goto L83;
        int r113 = r112 + A(" ");
    L84:
        TextPaint r114 = this.u;
        StringBuilder r115 = new StringBuilder();
        String r116 = this.a;
        if (r116 != null) goto L87;
        r116 = "";
    L87:
        r115.append(r116);
        if (this.i == false) goto L99;
        StringBuilder r117 = new StringBuilder();
        String r26 = this.d;
        if (r26 != null) goto L92;
        r26 = "";
    L92:
        r117.append(r26);
        String r27 = this.b;
        if (r27 != null) goto L95;
        r27 = "";
    L95:
        r117.append(r27);
        String r28 = this.f;
        if (r28 != null) goto L98;
        r28 = "";
    L98:
        r117.append(r28);
        String r30 = r117.toString();
    L100:
        r115.append(r30);
        float r31 = r114.measureText(r115.toString()) + r113;
        float r118 = r25;
        if (r118 <= r31) goto L109;
        int r32 = 0;
        int r33 = 0;
    L104:
        if (r118 <= (r32 + r31)) goto L108;
        r33 = r33 + 1;
        int r34 = r21 + r33;
        if (r34 > this.z.length()) goto L108;
        r32 = (int) (((double) this.u.measureText(this.z.subSequence(r21, r34).toString())) + 0.5d);
    L108:
        int r35 = r21 + (r33 - 1);
    L116:
        CharSequence r36 = this.z;
        ArrayList r37 = new ArrayList();
        Matcher r38 = this.B.matcher(r36);
    L118:
        if (r38.find() == false) goto L120;
        r37.add(r38.group());
        goto L118
    L120:
        int r40 = 0;
        int r41 = 0;
    L121:
        if (r40 >= r35) goto L125;
        if (r41 >= r37.size()) goto L125;
        r40 = r40 + ((String) ListProtector.get(r37, r41)).length();
        r41 = r41 + 1;
    L125:
        CharSequence r42 = this.z.subSequence(0, r40);
    L127:
        if (r42.toString().endsWith("\n") == false) goto L129;
        r42 = r42.subSequence(0, r42.length() - 1);
        goto L127
    L129:
        SpannableStringBuilder r43 = new SpannableStringBuilder(r42).append(this.a);
        if (this.i == false) goto L143;
        StringBuilder r44 = new StringBuilder();
        String r45 = this.d;
        if (r45 != null) goto L134;
        r45 = "";
    L134:
        r44.append(r45);
        String r46 = this.b;
        if (r46 != null) goto L137;
        r46 = "";
    L137:
        r44.append(r46);
        String r47 = this.f;
        if (r47 == null) goto L141;
        r7 = r47;
    L141:
        r44.append(r7);
        r43.append(r44.toString());
        int r48 = r43.length() - A(this.f);
        r43.setSpan(this.s, r48 - A(this.b), r48, 33);
    L143:
        if (this.p <= 0) goto L147;
        int r50 = (this.p / A(" ")) + 1;
    L145:
        if (r110 >= r50) goto L147;
        r43.append(" ");
        r110 = r110 + 1;
    L147:
        d r51 = this.A;
        if (r51 == null) goto L150;
        r51.b();
    L150:
        return r43;
    L109:
        int r119 = 0;
        int r120 = 0;
    L111:
        if ((r119 + r25) >= r31) goto L115;
        r120 = r120 - 1;
        int r121 = r21 + r120;
        if (r121 <= r22) goto L115;
        r119 = (int) (((double) this.u.measureText(this.z.subSequence(r121, r21).toString())) + 0.5d);
    L115:
        r35 = r21 + r120;
        goto L116
    L99:
        r30 = "";
        goto L100
    L83:
        r113 = 0;
        goto L84
    L75:
        r111 = 0;
        goto L76
    L15:
        if (getWidth() != 0) goto L24;
        int r52 = this.y;
        if (r52 != 0) goto L23;
        d r53 = this.A;
        if (r53 == null) goto L22;
        r53.b();
    L22:
        return this.z;
    L23:
        this.x = (r52 - getPaddingLeft()) - getPaddingRight();
        goto L25
    L24:
        this.x = (getWidth() - getPaddingLeft()) - getPaddingRight();
        goto L25
    }

    /* JADX WARN: Multi-variable type inference failed */
    private Layout getValidLayout() {
        Layout r0 = this.v;
        if (r0 == null) goto L6;
        return r0;
    L6:
        return getLayout();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void init() {
        this.s = new e(this);
        setMovementMethod(new c(this));
        if (TextUtils.isEmpty(this.a) == false) goto L6;
        this.a = "..";
    L6:
        if (this.h == false) goto L8;
        setOnClickListener(new b(this));
    L8:
        getViewTreeObserver().addOnGlobalLayoutListener(new a(this));
    }

    public int getCurrentState() {
        return this.r;
    }

    public int getExpandState() {
        return this.r;
    }

    public ExpandableTextView(Context r2) {
        super(r2);
        this.d = " ";
        this.e = " ";
        this.f = "";
        this.g = "";
        this.h = true;
        this.i = true;
        this.j = true;
        this.k = 2;
        this.l = -13330213;
        this.m = -1618884;
        this.n = 1436129689;
        this.o = 1436129689;
        this.p = 0;
        this.q = 0;
        this.r = 0;
        this.t = TextView.BufferType.NORMAL;
        this.w = -1;
        this.x = 0;
        this.y = 0;
        this.B = PatternProtector.compile("\\P{M}\\p{M}*+");
        init();
    }

    public static int A(String r0) {
        if (r0 != null) goto L6;
        return 0;
    L6:
        return r0.length();
    }

    public static /* synthetic */ CharSequence x(ExpandableTextView r0) {
        return r0.getNewTextByConfig();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void z(ExpandableTextView r2) {
        int r0 = r2.r;
        if (r0 == 0) goto L9;
        if (r0 != 1) goto L12;
        r2.r = 0;
        d r1 = r2.A;
        if (r1 == null) goto L12;
        r1.a(r2);
    L12:
        super/*android.widget.TextView*/.setText(r2.getNewTextByConfig(), r2.t);
        return;
    L9:
        r2.r = 1;
        d r3 = r2.A;
        if (r3 == null) goto L12;
        r3.c(r2);
        goto L12
    }

    public void setCurrentState(int r1) {
        this.r = r1;
    }

    public void setExpandListener(d r1) {
        this.A = r1;
    }

    public void setExtendRemianSpace(int r1) {
        this.p = r1;
    }

    public ExpandableTextView(Context r3, AttributeSet r4) {
        super(r3, r4);
        this.d = " ";
        this.e = " ";
        this.f = "";
        this.g = "";
        this.h = true;
        this.i = true;
        this.j = true;
        this.k = 2;
        this.l = -13330213;
        this.m = -1618884;
        this.n = 1436129689;
        this.o = 1436129689;
        this.p = 0;
        this.q = 0;
        this.r = 0;
        this.t = TextView.BufferType.NORMAL;
        this.w = -1;
        this.x = 0;
        this.y = 0;
        this.B = PatternProtector.compile("\\P{M}\\p{M}*+");
        B(r3, r4);
        init();
    }

    public final void B(Context r7, AttributeSet r8) {
        if (r8 != null) goto L4;
        return;
    L4:
        TypedArray r9 = r7.obtainStyledAttributes(r8, new int[]{2130971585, 2130971586, 2130971587, 2130971588, 2130971589, 2130971590, 2130971591, 2130971592, 2130971593, 2130971594, 2130971595, 2130971596, 2130971597, 2130971598, 2130971599, 2130971600, 2130971601, 2130971602});
        if (r9 != null) goto L7;
        return;
    L7:
        int r10 = r9.getIndexCount();
        int r1 = 0;
    L8:
        if (r1 >= r10) goto L62;
        int r2 = r9.getIndex(r1);
        if (r2 != 7) goto L12;
        this.k = r9.getInteger(r2, 2);
    L61:
        r1 = r1 + 1;
        goto L8
    L12:
        if (r2 != 0) goto L15;
        this.a = r9.getString(r2);
        goto L61
    L15:
        if (r2 != 9) goto L18;
        this.b = r9.getString(r2);
        goto L61
    L18:
        if (r2 != 14) goto L21;
        this.c = r9.getString(r2);
        goto L61
    L21:
        if (r2 != 1) goto L24;
        this.h = r9.getBoolean(r2, true);
        goto L61
    L24:
        if (r2 != 12) goto L27;
        this.i = r9.getBoolean(r2, true);
        goto L61
    L27:
        if (r2 != 17) goto L30;
        this.j = r9.getBoolean(r2, true);
        goto L61
    L30:
        if (r2 != 10) goto L33;
        this.l = r9.getInteger(r2, -13330213);
        goto L61
    L33:
        if (r2 != 15) goto L36;
        this.m = r9.getInteger(r2, -1618884);
        goto L61
    L36:
        if (r2 != 11) goto L39;
        this.n = r9.getInteger(r2, 1436129689);
        goto L61
    L39:
        if (r2 != 16) goto L42;
        this.o = r9.getInteger(r2, 1436129689);
        goto L61
    L42:
        if (r2 != 6) goto L45;
        this.r = r9.getInteger(r2, 0);
        goto L61
    L45:
        if (r2 != 4) goto L48;
        this.d = r9.getString(r2);
        goto L61
    L48:
        if (r2 != 5) goto L50;
        this.e = r9.getString(r2);
        goto L61
    L50:
        if (r2 != 2) goto L53;
        this.f = r9.getString(r2);
        goto L61
    L53:
        if (r2 != 3) goto L56;
        this.g = r9.getString(r2);
        goto L61
    L56:
        if (r2 != 13) goto L59;
        this.p = (int) r9.getDimension(r2, 0.0f);
        goto L61
    L59:
        if (r2 != 8) goto L61;
        this.q = (int) r9.getDimension(r2, 0.0f);
        goto L61
    L62:
        r9.recycle();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setText(CharSequence r1, TextView.BufferType r2) {
        this.z = r1;
        this.t = r2;
        super/*android.widget.TextView*/.setText(getNewTextByConfig(), r2);
    }

    public ExpandableTextView(Context r2, AttributeSet r3, int r4) {
        super(r2, r3, r4);
        this.d = " ";
        this.e = " ";
        this.f = "";
        this.g = "";
        this.h = true;
        this.i = true;
        this.j = true;
        this.k = 2;
        this.l = -13330213;
        this.m = -1618884;
        this.n = 1436129689;
        this.o = 1436129689;
        this.p = 0;
        this.q = 0;
        this.r = 0;
        this.t = TextView.BufferType.NORMAL;
        this.w = -1;
        this.x = 0;
        this.y = 0;
        this.B = PatternProtector.compile("\\P{M}\\p{M}*+");
        B(r2, r3);
        init();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void y(ExpandableTextView r0, CharSequence r1, TextView.BufferType r2) {
        super/*android.widget.TextView*/.setText(r1, r2);
    }
}
