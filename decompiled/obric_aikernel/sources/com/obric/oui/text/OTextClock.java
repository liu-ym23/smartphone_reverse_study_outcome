package com.obric.oui.text;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.text.Layout;
import android.text.SpannableString;
import android.text.style.ReplacementSpan;
import android.util.AttributeSet;
import android.widget.TextClock;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes2.dex */
public class OTextClock extends TextClock {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Set<Character> f7618c;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private volatile float f7619g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private volatile CharSequence f7620h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private volatile TextView.BufferType f7621i;

    static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f7622a = null;

        static {
            int[] r10 = new int[Layout.Alignment.values().length];
            f7622a = r10;
            r10[Layout.Alignment.ALIGN_CENTER.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L10:
            f7622a[Layout.Alignment.ALIGN_OPPOSITE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L12:
            f7622a[Layout.Alignment.ALIGN_NORMAL.ordinal()] = 3;     // Catch: NoSuchFieldError -> L9
            return;
        }
    }

    private static class b extends ReplacementSpan {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final float f7623c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private float f7624g;

        public b(float r10) {
            this.f7624g = -1.0f;
            this.f7623c = r10;
        }

        private float a(float r10, float r11, float r12) {
            Layout.Alignment r13 = b();
            int r14 = a.f7622a[r13.ordinal()];
            if (r14 != 1) goto L5;
            float r15 = (r11 - r12) / 2.0f;
        L9:
            return r10 - r15;
        L5:
            if (r14 == 2) goto L7;
            return r10;
        L7:
            r15 = r11 - r12;
            goto L9
        }

        private Layout.Alignment b() {
            return Layout.Alignment.ALIGN_CENTER;
        }

        @Override // android.text.style.ReplacementSpan
        public void draw(@NonNull Canvas r10, CharSequence r11, int r12, int r13, float r14, int r15, int r16, int r17, @NonNull Paint r18) {
            if (this.f7624g >= 0.0f) goto L6;
            this.f7624g = r18.measureText(r11, r12, r13);
        L6:
            float r19 = this.f7624g;
            r10.drawText(r11, r12, r13, a(r14, r19, this.f7623c * r19), r16, r18);
        }

        @Override // android.text.style.ReplacementSpan
        public int getSize(@NonNull Paint r10, CharSequence r11, int r12, int r13, @Nullable Paint.FontMetricsInt r14) {
            if (this.f7624g >= 0.0f) goto L6;
            this.f7624g = r10.measureText(r11, r12, r13);
        L6:
            return (int) (this.f7624g * this.f7623c);
        }
    }

    public OTextClock(Context r10) {
        super(r10);
        this.f7618c = ConcurrentHashMap.newKeySet();
        this.f7619g = 1.0f;
        this.f7620h = "";
        this.f7621i = TextView.BufferType.NORMAL;
    }

    public OTextClock(Context r10, AttributeSet r11) {
        super(r10, r11);
        this.f7618c = ConcurrentHashMap.newKeySet();
        this.f7619g = 1.0f;
        this.f7620h = "";
        this.f7621i = TextView.BufferType.NORMAL;
    }

    public OTextClock(Context r10, AttributeSet r11, int r12) {
        super(r10, r11, r12);
        this.f7618c = ConcurrentHashMap.newKeySet();
        this.f7619g = 1.0f;
        this.f7620h = "";
        this.f7621i = TextView.BufferType.NORMAL;
    }

    private CharSequence a(CharSequence r10) {
        String r11 = r10.toString();
        SpannableString r12 = new SpannableString(r11);
        HashSet r13 = new HashSet(this.f7618c);
        float r14 = this.f7619g;
        Iterator r15 = r13.iterator();
    L4:
        if (r15.hasNext() == false) goto L8;
        char r16 = ((Character) r15.next()).charValue();
        int r17 = r11.indexOf(r16);
    L6:
        if (r17 < 0) goto L4;
        int r18 = r17 + 1;
        r12.setSpan(new b(r14), r17, r18, 33);
        r17 = r11.indexOf(r16, r18);
        goto L6
    L8:
        return r12;
    }

    private void b() {
        if (this.f7620h != null) goto L5;
        return;
    L5:
        if (this.f7620h.length() > 0) goto L7;
        return;
    L7:
        if (c() == false) goto L9;
        CharSequence r10 = a(this.f7620h);
    L10:
        super.setText(r10, this.f7621i);
        invalidate();
        return;
    L9:
        r10 = this.f7620h;
        goto L10
    }

    private boolean c() {
        return !this.f7618c.isEmpty();
    }

    @Override // android.widget.TextView
    public void setLineSpacing(float r10, float r11) {
        super.setLineSpacing(r10, r11);
        b();
    }

    public void setRatio(float r10) {
        this.f7619g = r10;
        b();
    }

    public void setTargetCharacters(char[] r10) {
        this.f7618c.clear();
        if (r10 == null) goto L7;
        int r11 = r10.length;
        int r12 = 0;
    L5:
        if (r12 >= r11) goto L7;
        char r13 = r10[r12];
        this.f7618c.add(Character.valueOf(r13));
        r12 = r12 + 1;
    L7:
        b();
    }

    @Override // android.widget.TextView
    public void setText(CharSequence r10, TextView.BufferType r11) {
        this.f7620h = r10;
        this.f7621i = r11;
        b();
    }

    @Override // android.widget.TextView
    public void setTextSize(float r10) {
        super.setTextSize(r10);
        b();
    }

    @Override // android.widget.TextView
    public void setTextSize(int r10, float r11) {
        super.setTextSize(r10, r11);
        b();
    }

    @Override // android.widget.TextView
    public void setTypeface(Typeface r10) {
        super.setTypeface(r10);
        b();
    }

    @Override // android.widget.TextView
    public void setTypeface(Typeface r10, int r11) {
        super.setTypeface(r10, r11);
        b();
    }
}
