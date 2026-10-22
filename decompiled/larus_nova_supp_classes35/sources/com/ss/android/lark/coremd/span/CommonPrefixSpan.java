package com.ss.android.lark.coremd.span;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.text.Layout;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.style.LeadingMarginSpan;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class CommonPrefixSpan implements LeadingMarginSpan {
    public static final a b = null;
    public final c a;

    public static final enum ListType extends Enum<ListType> {
        public static final ListType LOWERCASE_A = null;
        public static final ListType LOWERCASE_ROMAN = null;
        public static final ListType NONE = null;
        public static final ListType NUMBER = null;
        public static final ListType UPPERCASE_A = null;
        public static final ListType UPPERCASE_ROMAN = null;
        public static final /* synthetic */ ListType[] a = null;
        private final int value;

        static {
            ListType r0 = new ListType("NUMBER", 0, 0);
            NUMBER = r0;
            ListType r1 = new ListType("LOWERCASE_A", 1, 1);
            LOWERCASE_A = r1;
            ListType r3 = new ListType("UPPERCASE_A", 2, 2);
            UPPERCASE_A = r3;
            ListType r5 = new ListType("LOWERCASE_ROMAN", 3, 3);
            LOWERCASE_ROMAN = r5;
            ListType r7 = new ListType("UPPERCASE_ROMAN", 4, 4);
            UPPERCASE_ROMAN = r7;
            ListType r9 = new ListType("NONE", 5, 5);
            NONE = r9;
            a = new ListType[]{r0, r1, r3, r5, r7, r9};
        }

        public static ListType[] values() {
            return (ListType[]) a.clone();
        }

        public int getValue() {
            return this.value;
        }

        public static ListType from(int r2) {
            ListType[] r0 = values();
            if (r2 < 0) goto L10;
            if (r2 >= r0.length) goto L10;
            return r0[r2];
        L10:
            return NONE;
        }

        public static ListType valueOf(String r1) {
            return (ListType) r27.a.a(ListType.class, r1);
        }

        public ListType(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public static final enum Type extends Enum<Type> {
        public static final Type FILL_CIRCLE = null;
        public static final Type FILL_RECT = null;
        public static final Type HOLLOW_CIRCLE = null;
        public static final Type HOLLOW_RECT = null;
        public static final Type LEFT_MARGIN = null;
        public static final Type LIST_NUM = null;
        public static final Type NONE = null;
        public static final Type QUOTE = null;
        public static final /* synthetic */ Type[] a = null;

        static {
            Type r0 = new Type("FILL_CIRCLE", 0);
            FILL_CIRCLE = r0;
            Type r1 = new Type("HOLLOW_CIRCLE", 1);
            HOLLOW_CIRCLE = r1;
            Type r3 = new Type("FILL_RECT", 2);
            FILL_RECT = r3;
            Type r5 = new Type("HOLLOW_RECT", 3);
            HOLLOW_RECT = r5;
            Type r7 = new Type("LIST_NUM", 4);
            LIST_NUM = r7;
            Type r9 = new Type("QUOTE", 5);
            QUOTE = r9;
            Type r11 = new Type("NONE", 6);
            NONE = r11;
            Type r13 = new Type("LEFT_MARGIN", 7);
            LEFT_MARGIN = r13;
            a = new Type[]{r0, r1, r3, r5, r7, r9, r11, r13};
        }

        public static Type[] values() {
            return (Type[]) a.clone();
        }

        public static Type valueOf(String r1) {
            return (Type) r27.a.a(Type.class, r1);
        }

        public Type(String r1, int r2) {
            super(r1, r2);
        }
    }

    public class a extends ThreadLocal<Paint> {
        @Override // java.lang.ThreadLocal
        public final Paint initialValue() {
            return new Paint();
        }

        public a() {
        }
    }

    public static /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[Type.values().length];
            a = r0;
            r0[Type.FILL_CIRCLE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L16:
            a[Type.FILL_RECT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
        L20:
            a[Type.HOLLOW_CIRCLE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
        L26:
            a[Type.HOLLOW_RECT.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
        L18:
            a[Type.QUOTE.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
        L22:
            a[Type.LIST_NUM.ordinal()] = 6;     // Catch: NoSuchFieldError -> L15
            return;
        }
    }

    public static class c {
        public Type a;
        public boolean b;
        public float c;
        public float d;
        public float e;
        public String f;
        public int g;
        public int h;
        public int i;
        public float j;

        public c() {
            this.b = true;
            this.h = 0;
            this.i = 0;
            ListType r0 = ListType.NUMBER;
            this.j = 1.0f;
        }

        public Type getType() {
            return this.a;
        }
    }

    static {
        b = new a();
    }

    public Type getType() {
        return this.a.getType();
    }

    public CommonPrefixSpan(c r1) {
        this.a = r1;
    }

    @Override // android.text.style.LeadingMarginSpan
    public int getLeadingMargin(boolean r3) {
        if (getType() == Type.LEFT_MARGIN) goto L5;
        c r4 = this.a;
        return (int) (((r4.c + r4.d) + r4.e) + 0.5f);
    L5:
        return (int) this.a.c;
    }

    public final void a(Canvas r15, Paint r16, int r17, int r18, int r19, int r20, int r21) {
        switch(b.a[this.a.a.ordinal()]) {
            case 1: goto L23;
            case 2: goto L14;
            case 3: goto L23;
            case 4: goto L14;
            case 5: goto L13;
            case 6: goto L5;
            default: goto L40;
        };
    L5:
        String r5 = this.a.f;
        if (TextUtils.isEmpty(r5) == true) goto L41;
        float r1 = r17 + (r18 * this.a.c);
        float r2 = r16.getTextSize();
        r16.setTextSize(this.a.j);
        Paint.FontMetricsInt r6 = r16.getFontMetricsInt();
        if ((r20 - r19) <= ((r6.bottom - r6.top) * 2)) goto L11;
        this.a.getClass();
        Rect r4 = new Rect();
        r16.getTextBounds(r5, 0, r5.length(), r4);
        r15.drawText(r5, r1, (r19 + r4.height()) + ((r6.ascent - r6.top) * 2), r16);
    L12:
        r16.setTextSize(r2);
        return;
    L11:
        r15.drawText(r5, r1, r21, r16);
        goto L12
    L41:
        return;
    L13:
        float r7 = r17;
        r15.drawRect(r7, r19, (int) ((r18 * this.a.d) + r7), r20, r16);
        return;
    L14:
        Paint.FontMetricsInt r8 = r16.getFontMetricsInt();
        int r10 = r8.bottom - r8.top;
        float r9 = (r19 + r20) / 2.0f;
        if ((r20 - r19) <= r10) goto L17;
        this.a.getClass();
        r9 = (r10 / 2.0f) + r19;
    L17:
        float r3 = r18;
        c r11 = this.a;
        float r12 = r17 + (r11.c * r3);
        float r13 = r3 * r11.d;
        float r14 = r12 + r13;
        float r22 = r13 / 2.0f;
        float r110 = r9 - r22;
        float r111 = r9 + r22;
        Type r23 = r11.a;
        if (r23 != Type.FILL_RECT) goto L21;
        r15.drawRect(r12, r110, r14, r111, r16);
        return;
    L21:
        if (r23 != Type.HOLLOW_RECT) goto L36;
        r15.drawRect(r12, r110, r14, r111, r16);
        r16.setColor(-16776961);
        this.a.getClass();
        this.a.getClass();
        this.a.getClass();
        this.a.getClass();
        r15.drawRect(r12 + 0.0f, r110 + 0.0f, r14 - 0.0f, r111 - 0.0f, r16);
        return;
    L36:
        return;
    L23:
        Paint.FontMetricsInt r24 = r16.getFontMetricsInt();
        int r112 = r24.bottom - r24.top;
        float r25 = (r19 + r20) / 2.0f;
        if ((r20 - r19) <= r112) goto L26;
        this.a.getClass();
        r25 = r19 + (r112 / 2.0f);
    L26:
        c r26 = this.a;
        float r27 = r26.d / 2.0f;
        float r28 = r17 + (r18 * (r26.c + r27));
        Type r29 = r26.a;
        if (r29 != Type.FILL_CIRCLE) goto L30;
        r15.drawCircle(r28, r25, r27, r16);
        return;
    L30:
        if (r29 != Type.HOLLOW_CIRCLE) goto L39;
        r16.setStyle(Paint.Style.STROKE);
        this.a.getClass();
        r16.setStrokeWidth(0.0f);
        r15.drawCircle(r28, r25, r27, r16);
        return;
    L39:
        return;
    }

    @Override // android.text.style.LeadingMarginSpan
    public void drawLeadingMargin(Canvas r10, Paint r11, int r12, int r13, int r14, int r15, int r16, CharSequence r17, int r18, int r19, boolean r20, Layout r21) {
        if (this.a.b == true) goto L5;
        return;
    L5:
        Paint r2 = b.get();
        r2.reset();
        r2.set(r11);
        r2.setAntiAlias(true);
        r2.setColor(this.a.g);
        r2.setTypeface(Typeface.MONOSPACE);
        int r1 = b.a[this.a.a.ordinal()];
        if (r1 != 1) goto L8;
    L16:
        r2.setStyle(Paint.Style.FILL);
    L18:
        if (this.a.a != Type.QUOTE) goto L21;
        a(r10, r2, r12, r13, r14, r16, r15);
        return;
    L21:
        if (((Spanned) r17).getSpanStart(this) != r18) goto L25;
        a(r10, r2, r12, r13, r14, r16, r15);
        return;
    L25:
        return;
    L8:
        if (r1 == 2) goto L16;
        if (r1 == 3) goto L16;
        if (r1 == 4) goto L16;
        if (r1 == 5) goto L16;
        goto L16
    }
}
