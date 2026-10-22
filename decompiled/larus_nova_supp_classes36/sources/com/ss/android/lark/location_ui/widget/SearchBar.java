package com.ss.android.lark.location_ui.widget;

import android.content.Context;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public class SearchBar extends FrameLayout implements View.OnClickListener {
    public ImageView a;
    public EditText b;
    public ImageView c;

    public class a implements TextWatcher {
        public final /* synthetic */ SearchBar a;

        @Override // android.text.TextWatcher
        public final void beforeTextChanged(CharSequence r1, int r2, int r3, int r4) {
        }

        @Override // android.text.TextWatcher
        public final void onTextChanged(CharSequence r1, int r2, int r3, int r4) {
        }

        public a(SearchBar r1) {
            this.a = r1;
        }

        @Override // android.text.TextWatcher
        public final void afterTextChanged(Editable r2) {
            if (TextUtils.isEmpty(r2.toString()) == false) goto L5;
            this.a.c.setVisibility(4);
            return;
        L5:
            this.a.c.setVisibility(0);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void clearFocus() {
        this.b.clearFocus();
    }

    public String getText() {
        return this.b.getText().toString();
    }

    public SearchBar(Context r1) {
        super(r1);
        a(r1);
    }

    public final void a(Context r3) {
        LayoutInflater.from(r3).inflate(2131563586, this, true);
        this.a = (ImageView) findViewById(2131374718);
        this.b = (EditText) findViewById(2131371787);
        ImageView r4 = (ImageView) findViewById(2131366928);
        this.c = r4;
        r4.setOnClickListener(this);
        this.b.addTextChangedListener(new a(this));
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        if (r2 != this.c) goto L6;
        this.b.setText(null);
        return;
    }

    public void setEditTextEnabled(boolean r2) {
        this.b.setEnabled(r2);
        this.b.setFocusable(r2);
        this.b.setFocusableInTouchMode(r2);
    }

    public void setEditTextImeOptions(int r2) {
        this.b.setImeOptions(r2);
    }

    public void setFilters(InputFilter[] r2) {
        this.b.setFilters(r2);
    }

    public void setHint(int r2) {
        this.b.setHint(r2);
    }

    public void setIcon(int r2) {
        this.a.setImageResource(r2);
    }

    @Override // android.view.View
    public void setOnFocusChangeListener(View.OnFocusChangeListener r2) {
        this.b.setOnFocusChangeListener(r2);
    }

    public void setSearchIconVisibility(int r2) {
        this.a.setVisibility(r2);
    }

    public void setSelection(int r2) {
        this.b.setSelection(r2);
    }

    public void setStyle(int r3) {
        this.b.setTextAppearance(getContext(), r3);
    }

    public void setText(String r2) {
        this.b.setText(r2);
    }

    public void setTextColor(int r2) {
        this.b.setTextColor(r2);
    }

    public SearchBar(Context r1, AttributeSet r2) {
        super(r1, r2);
        a(r1);
    }

    public SearchBar(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        a(r1);
    }
}
