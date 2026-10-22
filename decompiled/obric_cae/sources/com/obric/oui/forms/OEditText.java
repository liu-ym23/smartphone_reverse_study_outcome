package com.obric.oui.forms;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.CompletionInfo;
import androidx.appcompat.widget.AppCompatEditText;
import com.obric.cae.R;
import ge.l;
import ge.r;
import he.i;
import xd.j;

/* JADX INFO: loaded from: classes2.dex */
public final class OEditText extends AppCompatEditText {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final b f6277o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final c f6278p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final d f6279q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f6280r;

    public interface a {
    }

    public static final class b implements View.OnFocusChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public l<? super Boolean, j> f6281a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public View.OnFocusChangeListener f6282b;

        public b() {
        }

        @Override // android.view.View.OnFocusChangeListener
        public final void onFocusChange(View r8, boolean r10) {
            l<? super Boolean, j> r11 = this.f6281a;
            if (r11 == null) goto L5;
            j r12 = r11.invoke(Boolean.valueOf(r10));
        L5:
            View.OnFocusChangeListener r13 = this.f6282b;
            if (r13 == null) goto L9;
            r13.onFocusChange(r8, r10);
            return;
        }
    }

    public static final class c implements View.OnTouchListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public l<? super MotionEvent, j> f6283a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public View.OnTouchListener f6284b;

        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View r8, MotionEvent r10) {
            l<? super MotionEvent, j> r11 = this.f6283a;
            if (r11 == null) goto L5;
            j r12 = r11.invoke(r10);
        L5:
            View.OnTouchListener r13 = this.f6284b;
            if (r13 != null) goto L10;
            return false;
        L10:
            return r13.onTouch(r8, r10);
        }
    }

    public static final class d implements TextWatcher {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public r<? super CharSequence, ? super Integer, ? super Integer, ? super Integer, j> f6285a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public l<? super Editable, j> f6286b;

        @Override // android.text.TextWatcher
        public final void afterTextChanged(Editable r8) {
            l<? super Editable, j> r10 = this.f6286b;
            if (r10 == null) goto L6;
            j r11 = r10.invoke(r8);
            return;
        }

        @Override // android.text.TextWatcher
        public final void beforeTextChanged(CharSequence r8, int r10, int r11, int r12) {
        }

        @Override // android.text.TextWatcher
        public final void onTextChanged(CharSequence r8, int r10, int r11, int r12) {
            r<? super CharSequence, ? super Integer, ? super Integer, ? super Integer, j> r13 = this.f6285a;
            if (r13 == null) goto L6;
            j r14 = r13.d(r8, Integer.valueOf(r10), Integer.valueOf(r11), Integer.valueOf(r12));
            return;
        }
    }

    public OEditText(Context r8, AttributeSet r10) {
        i.f(r8, "context");
        super(r8, r10, 0);
        b r11 = new b();
        this.f6277o = r11;
        c r12 = new c();
        this.f6278p = r12;
        d r13 = new d();
        this.f6279q = r13;
        setOnFocusChangeListener(r11);
        super.setOnTouchListener(r12);
        addTextChangedListener(r13);
        setHighlightColor(r8.getColor(R.color.oui_text_highlight_color));
    }

    @Override // android.view.View
    public float getBottomFadingEdgeStrength() {
        return 0.0f;
    }

    public final a getCommitCompletionListener() {
        return null;
    }

    @Override // android.widget.TextView, android.view.View
    public float getLeftFadingEdgeStrength() {
        return 0.0f;
    }

    @Override // android.view.View
    public View.OnFocusChangeListener getOnFocusChangeListener() {
        View.OnFocusChangeListener r8 = super.getOnFocusChangeListener();
        if ((r8 instanceof b) == true) goto L5;
        return r8;
    L5:
        return ((b) r8).f6282b;
    }

    @Override // android.widget.TextView, android.view.View
    public float getRightFadingEdgeStrength() {
        return 0.0f;
    }

    @Override // android.view.View
    public float getTopFadingEdgeStrength() {
        return 0.0f;
    }

    @Override // android.widget.TextView
    public final void onCommitCompletion(CompletionInfo r8) {
        super.onCommitCompletion(r8);
    }

    @Override // android.widget.TextView, android.view.View
    public final void onLayout(boolean r8, int r10, int r11, int r12, int r13) {
        super.onLayout(r8, r10, r11, r12, r13);
    }

    @Override // android.widget.TextView, android.view.View
    public final void onMeasure(int r8, int r10) {
        super.onMeasure(r8, r10);
    }

    @Override // android.widget.TextView
    public final void onSelectionChanged(int r8, int r10) {
        super.onSelectionChanged(r8, r10);
        if (r8 == r10) goto L5;
        boolean r11 = true;
    L7:
        if (this.f6280r == true) goto L11;
        if (r11 == false) goto L12;
        defpackage.c.o0(getContext(), 3);
        return;
    L12:
        return;
    L11:
        return;
    L5:
        r11 = false;
        goto L7
    }

    @Override // android.widget.TextView, android.view.View
    public final boolean performLongClick() {
        this.f6280r = true;
        boolean r8 = super.performLongClick();
        this.f6280r = false;
        return r8;
    }

    public final void setCommitCompletionListener(a r8) {
    }

    @Override // android.view.View
    public void setOnFocusChangeListener(View.OnFocusChangeListener r8) {
        if ((r8 instanceof b) == false) goto L5;
        super.setOnFocusChangeListener(r8);
        return;
    L5:
        this.f6277o.f6282b = r8;
    }

    @Override // android.view.View
    public void setOnTouchListener(View.OnTouchListener r8) {
        this.f6278p.f6284b = r8;
    }
}
