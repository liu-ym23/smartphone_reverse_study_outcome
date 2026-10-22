package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.method.KeyListener;
import android.text.method.NumberKeyListener;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.DragEvent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.textclassifier.TextClassifier;
import android.widget.EditText;
import com.obric.cae.R;

/* JADX INFO: loaded from: classes.dex */
public class AppCompatEditText extends EditText {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f964a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final w f965b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final k f966m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public a f967n;

    public class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AppCompatEditText f968a;

        public a(AppCompatEditText r8) {
            this.f968a = r8;
        }
    }

    public AppCompatEditText(Context r8, AttributeSet r10) {
        this(r8, r10, R.attr.editTextStyle);
    }

    public static /* synthetic */ TextClassifier a(AppCompatEditText r8) {
        return super.getTextClassifier();
    }

    public static /* synthetic */ void b(AppCompatEditText r8, TextClassifier r10) {
        super.setTextClassifier(r10);
    }

    private a getSuperCaller() {
        if (this.f967n != null) goto L6;
        this.f967n = new a(this);
    L6:
        return this.f967n;
    }

    @Override // android.widget.TextView, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        d r8 = this.f964a;
        if (r8 == null) goto L5;
        r8.a();
    L5:
        w r10 = this.f965b;
        if (r10 == null) goto L9;
        r10.b();
        return;
    }

    @Override // android.widget.TextView
    public ActionMode.Callback getCustomSelectionActionModeCallback() {
        ActionMode.Callback r8 = super.getCustomSelectionActionModeCallback();
        if ((r8 instanceof androidx.core.widget.o) == false) goto L6;
        ((androidx.core.widget.o) r8).getClass();
        return null;
    L6:
        return r8;
    }

    public ColorStateList getSupportBackgroundTintList() {
        d r8 = this.f964a;
        if (r8 != null) goto L7;
        return null;
    L7:
        return r8.b();
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        d r8 = this.f964a;
        if (r8 != null) goto L7;
        return null;
    L7:
        return r8.c();
    }

    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.f965b.d();
    }

    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.f965b.e();
    }

    @Override // android.widget.EditText, android.widget.TextView
    public Editable getText() {
        return super.getText();
    }

    @Override // android.widget.TextView
    public TextClassifier getTextClassifier() {
        return a(getSuperCaller().f968a);
    }

    @Override // android.widget.TextView, android.view.View
    public InputConnection onCreateInputConnection(EditorInfo r8) {
        InputConnection r10 = super.onCreateInputConnection(r8);
        this.f965b.getClass();
        defpackage.c.V(this, r8, r10);
        return this.f966m.c(r10, r8);
    }

    @Override // android.widget.TextView, android.view.View
    public final boolean onDragEvent(DragEvent r8) {
        return super.onDragEvent(r8);
    }

    @Override // android.widget.EditText, android.widget.TextView
    public final boolean onTextContextMenuItem(int r8) {
        return super.onTextContextMenuItem(r8);
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable r8) {
        super.setBackgroundDrawable(r8);
        d r10 = this.f964a;
        if (r10 == null) goto L6;
        r10.e();
        return;
    }

    @Override // android.view.View
    public void setBackgroundResource(int r8) {
        super.setBackgroundResource(r8);
        d r10 = this.f964a;
        if (r10 == null) goto L6;
        r10.f(r8);
        return;
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawables(Drawable r8, Drawable r10, Drawable r11, Drawable r12) {
        super.setCompoundDrawables(r8, r10, r11, r12);
        w r13 = this.f965b;
        if (r13 == null) goto L6;
        r13.b();
        return;
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesRelative(Drawable r8, Drawable r10, Drawable r11, Drawable r12) {
        super.setCompoundDrawablesRelative(r8, r10, r11, r12);
        w r13 = this.f965b;
        if (r13 == null) goto L6;
        r13.b();
        return;
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback r8) {
        super.setCustomSelectionActionModeCallback(r8);
    }

    public void setEmojiCompatEnabled(boolean r8) {
        this.f966m.d(r8);
    }

    @Override // android.widget.TextView
    public void setKeyListener(KeyListener r8) {
        super.setKeyListener(this.f966m.a(r8));
    }

    public void setSupportBackgroundTintList(ColorStateList r8) {
        d r10 = this.f964a;
        if (r10 == null) goto L6;
        r10.h(r8);
        return;
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode r8) {
        d r10 = this.f964a;
        if (r10 == null) goto L6;
        r10.i(r8);
        return;
    }

    public void setSupportCompoundDrawablesTintList(ColorStateList r8) {
        w r10 = this.f965b;
        r10.h(r8);
        r10.b();
    }

    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode r8) {
        w r10 = this.f965b;
        r10.i(r8);
        r10.b();
    }

    @Override // android.widget.TextView
    public final void setTextAppearance(Context r8, int r10) {
        super.setTextAppearance(r8, r10);
        w r11 = this.f965b;
        if (r11 == null) goto L6;
        r11.g(r8, r10);
        return;
    }

    @Override // android.widget.TextView
    public void setTextClassifier(TextClassifier r8) {
        b(getSuperCaller().f968a, r8);
    }

    public AppCompatEditText(Context r8, AttributeSet r10, int r11) {
        s0.a(r8);
        super(r8, r10, r11);
        q0.a(this, getContext());
        d r12 = new d(this);
        this.f964a = r12;
        r12.d(r10, r11);
        w r13 = new w(this);
        this.f965b = r13;
        r13.f(r10, r11);
        r13.b();
        new t2.b(this);
        k r14 = new k(this);
        this.f966m = r14;
        r14.b(r10, r11);
        KeyListener r15 = getKeyListener();
        if ((!(r15 instanceof NumberKeyListener)) == false) goto L9;
        boolean r16 = super.isFocusable();
        boolean r17 = super.isClickable();
        boolean r18 = super.isLongClickable();
        int r19 = super.getInputType();
        KeyListener r20 = r14.a(r15);
        if (r20 == r15) goto L10;
        super.setKeyListener(r20);
        super.setRawInputType(r19);
        super.setFocusable(r16);
        super.setClickable(r17);
        super.setLongClickable(r18);
        return;
    L10:
        return;
    }

    @Override // android.widget.EditText, android.widget.TextView
    public /* bridge */ /* synthetic */ CharSequence getText() {
        return getText();
    }
}
