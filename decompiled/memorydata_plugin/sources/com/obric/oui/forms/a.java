package com.obric.oui.forms;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.GetChars;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.method.PasswordTransformationMethod;
import android.text.style.ReplacementSpan;
import android.view.View;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public class a extends PasswordTransformationMethod {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final float f13880a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final float f13881b;
    private final int c;
    private boolean d;
    private b e;

    /* JADX INFO: renamed from: com.obric.oui.forms.a$a, reason: collision with other inner class name */
    private static class C0752a extends ReplacementSpan {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f13882a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final float f13883b;
        private final float c;
        private final int d;
        private boolean e;

        C0752a(int r2, float r3, float r4, int r5) {
            this.e = false;
            this.f13882a = r2;
            this.f13883b = r3;
            this.c = r4;
            this.d = r5;
        }

        static /* synthetic */ int a(C0752a r0) {
            return r0.f13882a;
        }

        private void a(Paint r1, Paint.FontMetricsInt r2) {
            if (r2 != null) goto L4;
            return;
        L4:
            Paint.FontMetricsInt r0 = r1.getFontMetricsInt();
            r2.ascent = r0.ascent;
            r2.descent = r0.descent;
            r2.top = r0.top;
            r2.bottom = r0.bottom;
        }

        private boolean a(CharSequence r2, int r3) {
            CharSequence r1 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r2, CharSequence.class, "com.obric.memorydata.plugin");
            if (r3 >= 0) goto L5;
        L9:
            return false;
        L5:
            if (r3 >= r1.length()) goto L9;
            if (r1.charAt(r3) != 8226) goto L9;
            return true;
        }

        public void a(boolean r1) {
            this.e = r1;
        }

        @Override // android.text.style.ReplacementSpan
        public void draw(Canvas r12, CharSequence r13, int r14, int r15, float r16, int r17, int r18, int r19, Paint r20) {
            CharSequence r3 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r13, CharSequence.class, "com.obric.memorydata.plugin");
            if (a(r3, r14) == true) goto L6;
            r12.drawText(r3, r14, r15, r16, r18, r20);
            return;
        L6:
            float r4 = r20.getTextSize();
            float r5 = this.f13883b * r4;
            float r6 = (r4 * this.c) + r5;
            float r7 = r5 / 2.0f;
            float r8 = r16 + r7;
            float r9 = (r17 + r19) / 2.0f;
            Paint.Style r10 = r20.getStyle();
            r20.setStyle(Paint.Style.FILL);
            if (this.e == false) goto L9;
            int r11 = r20.getColor();
            r20.setColor(this.d);
            r12.drawRect(Math.round(r16), r17, Math.round((r16 + r6) + 0.5f), r19, r20);
            r20.setColor(r11);
        L9:
            r12.drawCircle(r8, r9, r7, r20);
            r20.setStyle(r10);
        }

        @Override // android.text.style.ReplacementSpan
        public int getSize(Paint r3, CharSequence r4, int r5, int r6, Paint.FontMetricsInt r7) {
            CharSequence r8 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r4, CharSequence.class, "com.obric.memorydata.plugin");
            a(r3, r7);
            if (a(r8, r5) == false) goto L5;
            float r9 = r3.getTextSize();
            float r10 = (this.f13883b * r9) + (r9 * this.c);
        L7:
            return (int) Math.ceil(r10);
        L5:
            r10 = r3.measureText(r8, r5, r6);
            goto L7
        }
    }

    private static class b implements GetChars, Spanned {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private CharSequence f13884a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final float f13885b;
        private final float c;
        private final int d;
        private boolean e;
        private final ArrayList<C0752a> f;

        b(CharSequence r3, float r4, float r5, int r6) {
            CharSequence r7 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
            this.e = false;
            this.f = new ArrayList();
            this.f13884a = r7;
            this.f13885b = r4;
            this.c = r5;
            this.d = r6;
        }

        private CharSequence a() {
            CharSequence r0 = this.f13884a;
            if (r0 != null) goto L7;
            return "";
        L7:
            return r0;
        }

        private void a(int r6) {
        L3:
            if (this.f.size() >= r6) goto L5;
            C0752a r1 = new C0752a(this.f.size(), this.f13885b, this.c, this.d);
            r1.a(this.e);
            this.f.add(r1);
            goto L3
        L5:
            b(r6);
        }

        /* JADX WARN: Multi-variable type inference failed */
        private static <T> T[] a(List<T> r2, Class<T> r3) {
            List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin");
            T[] r5 = (T[]) ((Object[]) ZeusTransformUtils.preCheckCast(Array.newInstance(r3, r4.size()), Object[].class, "com.obric.memorydata.plugin"));
            int r0 = 0;
        L4:
            if (r0 >= r4.size()) goto L6;
            r5[r0] = r4.get(r0);
            r0 = r0 + 1;
            goto L4
        L6:
            return r5;
        }

        private void b(int r3) {
            int r4 = r3 + 16;
            if (this.f.size() > (r4 + 32)) goto L5;
            return;
        L5:
            ArrayList<C0752a> r2 = this.f;
            r2.subList(r4, r2.size()).clear();
        }

        void a(CharSequence r3) {
            CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
            if (this.f13884a != r4) goto L5;
            return;
        L5:
            this.f13884a = r4;
        }

        public void a(boolean r5) {
            this.e = r5;
            int r0 = 0;
        L4:
            if (r0 >= this.f.size()) goto L6;
            ((C0752a) ZeusTransformUtils.preCheckCast(this.f.get(r0), C0752a.class, "com.obric.memorydata.plugin")).a(r5);
            r0 = r0 + 1;
            goto L4
        }

        @Override // java.lang.CharSequence
        public char charAt(int r1) {
            return a().charAt(r1);
        }

        @Override // android.text.GetChars
        public void getChars(int r3, int r4, char[] r5, int r6) {
            CharSequence r2 = a();
            if (ZeusTransformUtils.instanceOf(r2, GetChars.class) == false) goto L5;
            ((GetChars) ZeusTransformUtils.preCheckCast(r2, GetChars.class, "com.obric.memorydata.plugin")).getChars(r3, r4, r5, r6);
            return;
        L5:
            TextUtils.getChars(r2, r3, r4, r5, r6);
        }

        @Override // android.text.Spanned
        public int getSpanEnd(Object r3) {
            if (ZeusTransformUtils.instanceOf(r3, C0752a.class) == true) goto L5;
            CharSequence r2 = a();
            if (ZeusTransformUtils.instanceOf(r2, Spanned.class) == true) goto L9;
            return -1;
        L9:
            return ((Spanned) ZeusTransformUtils.preCheckCast(r2, Spanned.class, "com.obric.memorydata.plugin")).getSpanEnd(r3);
        L5:
            return C0752a.a((C0752a) ZeusTransformUtils.preCheckCast(r3, C0752a.class, "com.obric.memorydata.plugin")) + 1;
        }

        @Override // android.text.Spanned
        public int getSpanFlags(Object r3) {
            if (ZeusTransformUtils.instanceOf(r3, C0752a.class) == false) goto L6;
            return 33;
        L6:
            CharSequence r2 = a();
            if (ZeusTransformUtils.instanceOf(r2, Spanned.class) == true) goto L9;
            return 0;
        L9:
            return ((Spanned) ZeusTransformUtils.preCheckCast(r2, Spanned.class, "com.obric.memorydata.plugin")).getSpanFlags(r3);
        }

        @Override // android.text.Spanned
        public int getSpanStart(Object r3) {
            if (ZeusTransformUtils.instanceOf(r3, C0752a.class) == true) goto L5;
            CharSequence r2 = a();
            if (ZeusTransformUtils.instanceOf(r2, Spanned.class) == true) goto L9;
            return -1;
        L9:
            return ((Spanned) ZeusTransformUtils.preCheckCast(r2, Spanned.class, "com.obric.memorydata.plugin")).getSpanStart(r3);
        L5:
            return C0752a.a((C0752a) ZeusTransformUtils.preCheckCast(r3, C0752a.class, "com.obric.memorydata.plugin"));
        }

        @Override // android.text.Spanned
        public <T> T[] getSpans(int r9, int r10, Class<T> r11) {
            CharSequence r0 = a();
            ArrayList r1 = new ArrayList();
            if (ZeusTransformUtils.instanceOf(r0, Spanned.class) == false) goto L8;
            Object[] r2 = ((Spanned) ZeusTransformUtils.preCheckCast(r0, Spanned.class, "com.obric.memorydata.plugin")).getSpans(r9, r10, r11);
            int r5 = r2.length;
            int r6 = 0;
        L5:
            if (r6 >= r5) goto L8;
            r1.add(r2[r6]);
            r6 = r6 + 1;
        L8:
            if (r11.isAssignableFrom(C0752a.class) == false) goto L10;
        L13:
            a(length());
            int r12 = Math.max(r9, 0);
            int r13 = Math.min(r10, length());
        L14:
            if (r12 >= r13) goto L20;
            if (r0.charAt(r12) != 8226) goto L18;
            r1.add(r11.cast((C0752a) ZeusTransformUtils.preCheckCast(this.f.get(r12), C0752a.class, "com.obric.memorydata.plugin")));
        L18:
            r12 = r12 + 1;
        L20:
            return (T[]) a(r1, r11);
        L10:
            if (r11.isAssignableFrom(ReplacementSpan.class) == true) goto L13;
            if (r11.isAssignableFrom(Object.class) == false) goto L20;
            goto L13
        }

        @Override // java.lang.CharSequence
        public int length() {
            return a().length();
        }

        @Override // android.text.Spanned
        public int nextSpanTransition(int r4, int r5, Class r6) {
            CharSequence r0 = a();
            if (ZeusTransformUtils.instanceOf(r0, Spanned.class) == false) goto L5;
            int r1 = ((Spanned) ZeusTransformUtils.preCheckCast(r0, Spanned.class, "com.obric.memorydata.plugin")).nextSpanTransition(r4, r5, r6);
        L6:
            if (r6 != null) goto L8;
        L13:
            a(length());
            int r7 = Math.max(r4, 0);
            int r3 = Math.min(r5, length());
        L14:
            if (r7 >= r3) goto L21;
            if (r0.charAt(r7) != 8226) goto L20;
            if (r7 <= r4) goto L19;
            r1 = Math.min(r1, r7);
        L19:
            r1 = Math.min(r1, r7 + 1);
        L20:
            r7 = r7 + 1;
        L21:
            return r1;
        L8:
            if (r6.isAssignableFrom(C0752a.class) == true) goto L13;
            if (r6.isAssignableFrom(ReplacementSpan.class) == true) goto L13;
            if (r6.isAssignableFrom(Object.class) == false) goto L21;
        L5:
            r1 = r5;
            goto L6
        }

        @Override // java.lang.CharSequence
        public CharSequence subSequence(int r1, int r2) {
            return a().subSequence(r1, r2);
        }

        @Override // java.lang.CharSequence
        public String toString() {
            return a().toString();
        }
    }

    public a(float r2, float r3, int r4) {
        this.d = false;
        this.f13880a = r2;
        this.f13881b = r3;
        this.c = r4;
    }

    public float a() {
        return this.f13880a;
    }

    public void a(boolean r2) {
        if (this.d == r2) goto L8;
        this.d = r2;
        b r1 = this.e;
        if (r1 == null) goto L9;
        r1.a(r2);
        return;
    L9:
        return;
    }

    public float b() {
        return this.f13881b;
    }

    @Override // android.text.method.PasswordTransformationMethod, android.text.method.TransformationMethod
    public CharSequence getTransformation(CharSequence r4, View r5) {
        CharSequence r6 = super.getTransformation((CharSequence) ZeusTransformUtils.wrapperContextForParams(r4, CharSequence.class, "com.obric.memorydata.plugin"), r5);
        b r7 = this.e;
        if (r7 != null) goto L5;
        this.e = new b(r6, this.f13880a, this.f13881b, this.c);
    L6:
        this.e.a(this.d);
        return this.e;
    L5:
        r7.a(r6);
        goto L6
    }
}
