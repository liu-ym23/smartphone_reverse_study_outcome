package com.larksuite.component.ui.navigation;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.AppCompatEditText;
import com.larksuite.framework.utils.UIUtils;
import j08.b;
import java.util.ArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public class LKUIClearEditText extends AppCompatEditText implements TextWatcher, View.OnFocusChangeListener {
    public boolean a;
    public boolean b;
    public int c;
    public float d;
    public ArrayList<TextWatcher> e;

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable r1) {
    }

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence r1, int r2, int r3, int r4) {
    }

    public LKUIClearEditText(Context r1) {
        super(r1);
        this.b = true;
        this.c = 2131254121;
        this.e = null;
        c(null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void addTextChangedListener(TextWatcher r2) {
        if (this.e != null) goto L5;
        this.e = new ArrayList();
    L5:
        this.e.add(r2);
        super/*android.widget.EditText*/.addTextChangedListener(r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void c(AttributeSet r3) {
        if (r3 == null) goto L4;
        TypedArray r4 = getContext().obtainStyledAttributes(r3, new int[]{2130969500, 2130969501});
        this.c = r4.getResourceId(0, this.c);
        this.d = r4.getDimension(1, b.a(getContext(), 16.0f));
        r4.recycle();
    L4:
        setOnFocusChangeListener(this);
        addTextChangedListener(this);
        setCompoundDrawablePadding((int) b.a(getContext(), 8.0f));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean onTouchEvent(MotionEvent r5) {
        boolean r1 = true;
        if (r5.getAction() != 1) goto L17;
        if (getCompoundDrawables()[2] == null) goto L17;
        if (r5.getX() > (getWidth() - getTotalPaddingRight())) goto L9;
    L11:
        r1 = false;
    L12:
        if (r1 == false) goto L17;
        if (this.b == false) goto L17;
        setText("");
        goto L17
    L9:
        if (r5.getX() >= (getWidth() - getPaddingRight())) goto L11;
    L17:
        return super/*android.widget.EditText*/.onTouchEvent(r5);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void removeTextChangedListener(TextWatcher r2) {
        ArrayList<TextWatcher> r0 = this.e;
        if (r0 == null) goto L5;
        r0.remove(r2);
    L5:
        super/*android.widget.EditText*/.removeTextChangedListener(r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setClearDrawable(Drawable r5) {
        if (r5 == null) goto L5;
        float r0 = this.d;
        r5.setBounds(0, 0, (int) r0, (int) r0);
        setCompoundDrawables(getCompoundDrawables()[0], getCompoundDrawables()[1], r5, getCompoundDrawables()[3]);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setClearDrawableSize(float r1) {
        this.d = r1;
        invalidate();
    }

    public void setClearEnable(boolean r1) {
        this.b = r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setClearIconVisible(boolean r5) {
        Drawable r0 = getCompoundDrawables()[2];
        if (r0 == null) goto L5;
    L7:
        float r1 = this.d;
        r0.setBounds(0, 0, (int) r1, (int) r1);
        if (r5 == true) goto L11;
        r0 = null;
    L11:
        setCompoundDrawables(getCompoundDrawables()[0], getCompoundDrawables()[1], r0, getCompoundDrawables()[3]);
        return;
    L5:
        if (this.c == 0) goto L7;
        r0 = AppCompatResources.getDrawable(getContext(), this.c);
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setCursorColor(int r2) {
        UIUtils.setTextViewCursorColor(getContext(), this, r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setCursorDrawable(int r2) {
        UIUtils.setTextViewEditorDrawable(this, getResources().getDrawable(r2));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setClearDrawable(int r1) {
        this.c = r1;
        invalidate();
    }

    public LKUIClearEditText(Context r1, AttributeSet r2) {
        super(r1, r2);
        this.b = true;
        this.c = 2131254121;
        this.e = null;
        c(r2);
    }

    @Override // android.view.View.OnFocusChangeListener
    public final void onFocusChange(View r1, boolean r2) {
        this.a = r2;
        boolean r3 = false;
        if (r2 == true) goto L5;
        setClearIconVisible(false);
        return;
    L5:
        if (getText().length() <= 0) goto L7;
        r3 = true;
    L7:
        setClearIconVisible(r3);
    }

    public LKUIClearEditText(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        this.b = true;
        this.c = 2131254121;
        this.e = null;
        c(r2);
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence r1, int r2, int r3, int r4) {
        if (this.a == true) goto L5;
        return;
    L5:
        if (r1.length() > 0) goto L7;
    L9:
        boolean r5 = false;
    L10:
        setClearIconVisible(r5);
        return;
    L7:
        if (this.b == false) goto L9;
        r5 = true;
        goto L10
    }
}
