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
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes5.dex */
public class OTextClock extends TextClock {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Set<Character> f14556a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile float f14557b;
    private volatile CharSequence c;
    private volatile TextView.BufferType d;

    /* JADX INFO: renamed from: com.obric.oui.text.OTextClock$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f14558a = null;

        static {
            int[] r0 = new int[Layout.Alignment.values().length];
            f14558a = r0;
            r0[Layout.Alignment.ALIGN_CENTER.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L10:
            f14558a[Layout.Alignment.ALIGN_OPPOSITE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L12:
            f14558a[Layout.Alignment.ALIGN_NORMAL.ordinal()] = 3;     // Catch: NoSuchFieldError -> L9
            return;
        }
    }

    private static class a extends ReplacementSpan {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final float f14559a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private float f14560b;

        public a(float r2) {
            this.f14560b = -1.0f;
            this.f14559a = r2;
        }

        private float a(float r2, float r3, float r4) {
            Layout.Alignment r1 = a();
            int r5 = AnonymousClass1.f14558a[r1.ordinal()];
            if (r5 != 1) goto L5;
            float r6 = (r3 - r4) / 2.0f;
        L9:
            return r2 - r6;
        L5:
            if (r5 == 2) goto L7;
            return r2;
        L7:
            r6 = r3 - r4;
            goto L9
        }

        private Layout.Alignment a() {
            return Layout.Alignment.ALIGN_CENTER;
        }

        @Override // android.text.style.ReplacementSpan
        public void draw(Canvas r10, CharSequence r11, int r12, int r13, float r14, int r15, int r16, int r17, Paint r18) {
            CharSequence r3 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r11, CharSequence.class, "com.obric.memorydata.plugin");
            if (this.f14560b >= 0.0f) goto L6;
            this.f14560b = r18.measureText(r3, r12, r13);
        L6:
            float r2 = this.f14560b;
            r10.drawText(r3, r12, r13, a(r14, r2, this.f14559a * r2), r16, r18);
        }

        @Override // android.text.style.ReplacementSpan
        public int getSize(Paint r2, CharSequence r3, int r4, int r5, Paint.FontMetricsInt r6) {
            CharSequence r7 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
            if (this.f14560b >= 0.0f) goto L6;
            this.f14560b = r2.measureText(r7, r4, r5);
        L6:
            return (int) (this.f14560b * this.f14559a);
        }
    }

    public OTextClock(Context r3) {
        super((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"));
        this.f14556a = ConcurrentHashMap.newKeySet();
        this.f14557b = 1.0f;
        this.c = "";
        this.d = TextView.BufferType.NORMAL;
    }

    public OTextClock(Context r3, AttributeSet r4) {
        super((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.memorydata.plugin"));
        this.f14556a = ConcurrentHashMap.newKeySet();
        this.f14557b = 1.0f;
        this.c = "";
        this.d = TextView.BufferType.NORMAL;
    }

    public OTextClock(Context r3, AttributeSet r4, int r5) {
        super((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.memorydata.plugin"), r5);
        this.f14556a = ConcurrentHashMap.newKeySet();
        this.f14557b = 1.0f;
        this.c = "";
        this.d = TextView.BufferType.NORMAL;
    }

    private CharSequence a(CharSequence r9) {
        String r10 = ((CharSequence) ZeusTransformUtils.wrapperContextForParams(r9, CharSequence.class, "com.obric.memorydata.plugin")).toString();
        SpannableString r0 = new SpannableString(r10);
        HashSet r2 = new HashSet(this.f14556a);
        float r8 = this.f14557b;
        Iterator r3 = r2.iterator();
    L4:
        if (r3.hasNext() == false) goto L8;
        char r4 = ((Character) ZeusTransformUtils.preCheckCast(r3.next(), Character.class, "com.obric.memorydata.plugin")).charValue();
        int r5 = r10.indexOf(r4);
    L6:
        if (r5 < 0) goto L4;
        int r6 = r5 + 1;
        r0.setSpan(new a(r8), r5, r6, 33);
        r5 = r10.indexOf(r4, r6);
        goto L6
    L8:
        return r0;
    }

    private void a() {
        if (this.c != null) goto L5;
        return;
    L5:
        if (this.c.length() > 0) goto L7;
        return;
    L7:
        if (b() == false) goto L9;
        CharSequence r0 = a(this.c);
    L10:
        super.setText(r0, this.d);
        invalidate();
        return;
    L9:
        r0 = this.c;
        goto L10
    }

    private boolean b() {
        return !this.f14556a.isEmpty();
    }

    @Override // android.widget.TextView
    public void setLineSpacing(float r1, float r2) {
        super.setLineSpacing(r1, r2);
        a();
    }

    public void setRatio(float r1) {
        this.f14557b = r1;
        a();
    }

    public void setTargetCharacters(char[] r5) {
        this.f14556a.clear();
        if (r5 == null) goto L7;
        int r0 = r5.length;
        int r1 = 0;
    L5:
        if (r1 >= r0) goto L7;
        char r2 = r5[r1];
        this.f14556a.add(Character.valueOf(r2));
        r1 = r1 + 1;
    L7:
        a();
    }

    @Override // android.widget.TextView
    public void setText(CharSequence r3, TextView.BufferType r4) {
        this.c = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
        this.d = r4;
        a();
    }

    @Override // android.widget.TextView
    public void setTextSize(float r1) {
        super.setTextSize(r1);
        a();
    }

    @Override // android.widget.TextView
    public void setTextSize(int r1, float r2) {
        super.setTextSize(r1, r2);
        a();
    }

    @Override // android.widget.TextView
    public void setTypeface(Typeface r1) {
        super.setTypeface(r1);
        a();
    }

    @Override // android.widget.TextView
    public void setTypeface(Typeface r1, int r2) {
        super.setTypeface(r1, r2);
        a();
    }
}
