package com.obric.oui.text;

import android.content.Context;
import android.graphics.Typeface;
import android.text.SpannableString;
import android.util.AttributeSet;
import android.widget.TextClock;
import android.widget.TextView;
import is.b;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes3.dex */
public class OTextClock extends TextClock {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap.KeySetView f14691a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile float f14692b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile CharSequence f14693c;
    public volatile TextView.BufferType d;

    public OTextClock(Context r5) {
        super(r5);
        this.f14691a = ConcurrentHashMap.newKeySet();
        this.f14692b = 1.0f;
        this.f14693c = "";
        this.d = TextView.BufferType.NORMAL;
    }

    public final void a() {
        if (this.f14693c != null) goto L5;
        return;
    L5:
        if (this.f14693c.length() > 0) goto L7;
        return;
    L7:
        if (this.f14691a.isEmpty() == true) goto L15;
        String r5 = this.f14693c.toString();
        SpannableString r10 = new SpannableString(r5);
        HashSet r11 = new HashSet(this.f14691a);
        float r12 = this.f14692b;
        Iterator r13 = r11.iterator();
    L10:
        if (r13.hasNext() == false) goto L14;
        char r14 = ((Character) r13.next()).charValue();
        int r15 = r5.indexOf(r14);
    L12:
        if (r15 < 0) goto L10;
        int r16 = r15 + 1;
        r10.setSpan(new b(r12), r15, r16, 33);
        r15 = r5.indexOf(r14, r16);
        goto L12
    L14:
        super.setText(r10, this.d);
    L16:
        invalidate();
        return;
    L15:
        super.setText(this.f14693c, this.d);
        goto L16
    }

    @Override // android.widget.TextView
    public final void setLineSpacing(float r5, float r10) {
        super.setLineSpacing(r5, r10);
        a();
    }

    public void setRatio(float r5) {
        this.f14692b = r5;
        a();
    }

    public void setTargetCharacters(char[] r5) {
        ConcurrentHashMap.KeySetView r10 = this.f14691a;
        r10.clear();
        if (r5 == null) goto L7;
        int r11 = r5.length;
        int r12 = 0;
    L5:
        if (r12 >= r11) goto L7;
        r10.add(Character.valueOf(r5[r12]));
        r12 = r12 + 1;
    L7:
        a();
    }

    @Override // android.widget.TextView
    public final void setText(CharSequence r5, TextView.BufferType r10) {
        this.f14693c = r5;
        this.d = r10;
        a();
    }

    @Override // android.widget.TextView
    public void setTextSize(float r5) {
        super.setTextSize(r5);
        a();
    }

    @Override // android.widget.TextView
    public void setTypeface(Typeface r5) {
        super.setTypeface(r5);
        a();
    }

    @Override // android.widget.TextView
    public final void setTextSize(int r5, float r10) {
        super.setTextSize(r5, r10);
        a();
    }

    @Override // android.widget.TextView
    public final void setTypeface(Typeface r5, int r10) {
        super.setTypeface(r5, r10);
        a();
    }

    public OTextClock(Context r5, AttributeSet r10) {
        super(r5, r10);
        this.f14691a = ConcurrentHashMap.newKeySet();
        this.f14692b = 1.0f;
        this.f14693c = "";
        this.d = TextView.BufferType.NORMAL;
    }

    public OTextClock(Context r5, AttributeSet r10, int r11) {
        super(r5, r10, r11);
        this.f14691a = ConcurrentHashMap.newKeySet();
        this.f14692b = 1.0f;
        this.f14693c = "";
        this.d = TextView.BufferType.NORMAL;
    }
}
