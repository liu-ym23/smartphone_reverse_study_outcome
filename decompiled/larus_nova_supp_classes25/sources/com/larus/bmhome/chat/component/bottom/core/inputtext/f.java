package com.larus.bmhome.chat.component.bottom.core.inputtext;

import android.os.Looper;
import android.text.Editable;
import android.text.InputFilter;
import android.view.MotionEvent;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import androidx.core.view.ViewCompat;
import com.larus.bmhome.chat.component.bottom.core.o4;
import com.larus.bmhome.chat.font.FontLevel;
import com.larus.bmhome.chat.model.ChatDraftItem;
import com.larus.bmhome.utils.x1;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public abstract class f implements p0 {
    public final EditText a;
    public Function1<? super Boolean, Unit> b;
    public boolean c;
    public final c d;

    @Override // com.larus.bmhome.chat.component.bottom.core.inputtext.p0
    public final void W0() {
        this.a.setFocusableInTouchMode(true);
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.inputtext.p0
    public boolean c1() {
        return false;
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.inputtext.p0
    public final void j1() {
        this.a.setMaxLines(1);
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.inputtext.p0
    public final InputFilter[] S0() {
        return this.a.getFilters();
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.inputtext.p0
    public final int V0() {
        return this.a.getSelectionStart();
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.inputtext.p0
    public final s Z0() {
        return new s(this.a);
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.inputtext.p0
    public final boolean d1() {
        return this.a.hasFocus();
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.inputtext.p0
    public final int e1() {
        return this.a.getSelectionEnd();
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.inputtext.p0
    public final boolean isFocusable() {
        return this.a.isFocusable();
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.inputtext.p0
    public final CharSequence k1() {
        CharSequence r0 = this.a.getHint();
        if (r0 != null) goto L6;
        return "";
    L6:
        return r0;
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.inputtext.p0
    public final Editable l1() {
        return this.a.getEditableText();
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.inputtext.p0
    public final void o1() {
        Editable r0 = this.a.getEditableText();
        if (r0 == null) goto L6;
        r0.clear();
        return;
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.inputtext.p0
    public final void requestFocus() {
        this.a.requestFocus();
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.inputtext.p0
    public final void requestLayout() {
        this.a.requestLayout();
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.inputtext.p0
    public final String text() {
        Editable r0 = this.a.getText();
        if (r0 == null) goto L5;
        String r1 = r0.toString();
    L6:
        if (r1 != null) goto L9;
        return "";
    L9:
        return r1;
    L5:
        r1 = null;
        goto L6
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.inputtext.p0
    public final void U0() {
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == true) goto L6;
        this.a.post(new b(this));
        return;
    L6:
        this.a.clearFocus();
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.inputtext.p0
    public final EditText Y0() {
        return this.a;
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [com.larus.bmhome.chat.component.bottom.core.inputtext.c] */
    public f(EditText r2) {
        Intrinsics.checkNotNullParameter(r2, "baseInputText");
        this.a = r2;
        this.c = r2.isShown();
        this.d = new c(this);
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.inputtext.p0
    public final void M5(CharSequence r2) {
        Intrinsics.checkNotNullParameter(r2, "hint");
        this.a.setHint(r2);
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.inputtext.p0
    public final void X0(int r2) {
        this.a.setMaxHeight(r2);
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.inputtext.p0
    public final void a1(boolean r9) {
        Lazy r0 = we8.e.a;
        if (we8.e.d != FontLevel.SUPER_EXTRA_LARGE.getValue()) goto L6;
        we8.a.b(this.a, i5.t(), r9, null, null, 12);
        return;
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.inputtext.p0
    public final void append(CharSequence r2) {
        Intrinsics.checkNotNullParameter(r2, ChatDraftItem.TYPE_TEXT);
        this.a.append(r2);
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.inputtext.p0
    public final void b(int r2) {
        this.a.setSelection(r2);
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.inputtext.p0
    public final void f1(boolean r2) {
        this.a.setCursorVisible(r2);
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.inputtext.p0
    public final void i1(boolean r2) {
        this.a.setFocusable(r2);
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.inputtext.p0
    public void m1(Function1<? super Boolean, Unit> r3) {
        this.a.removeOnLayoutChangeListener(this.d);
        this.b = r3;
        this.c = this.a.isShown();
        if (r3 == null) goto L6;
        this.a.addOnLayoutChangeListener(this.d);
        return;
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.inputtext.p0
    public final boolean p1(MotionEvent r7) {
        Intrinsics.checkNotNullParameter(r7, "event");
        int r1 = com.larus.utils.w0.a;
        EditText r2 = this.a;
        Intrinsics.checkNotNullParameter(r7, "event");
        if (r2 == null) goto L19;
        int[] r3 = new int[2];
        r2.getLocationOnScreen(r3);
        float r4 = r7.getRawX();
        float r8 = r7.getRawY();
        int r5 = r3[0];
        if (r4 >= r5) goto L8;
        return false;
    L8:
        if (r4 > (r5 + r2.getWidth())) goto L16;
        int r6 = r3[1];
        if (r8 >= r6) goto L12;
        return false;
    L12:
        if (r8 > (r6 + r2.getHeight())) goto L18;
        return true;
    L18:
        return false;
    L16:
        return false;
    L19:
        return false;
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.inputtext.p0
    public final void q1(int r2) {
        this.a.setHintTextColor(r2);
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.inputtext.p0
    public void r1(x1 r3) {
        requestFocus();
        EditText r4 = this.a;
        Object r0 = r4.getContext().getSystemService("input_method");
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        ((InputMethodManager) r0).showSoftInput(r4, 1);
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.inputtext.p0
    public final void setAlpha(float r2) {
        this.a.setAlpha(r2);
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.inputtext.p0
    public final void setEnabled(boolean r2) {
        this.a.setEnabled(r2);
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.inputtext.p0
    public final void setFilters(InputFilter[] r2) {
        Intrinsics.checkNotNullParameter(r2, "filters");
        this.a.setFilters(r2);
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.inputtext.p0
    public final void setTextColor(int r2) {
        this.a.setTextColor(r2);
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.inputtext.p0
    public final void setVisible(boolean r2) {
        EditText r0 = this.a;
        if (r2 == false) goto L5;
        int r3 = 0;
    L6:
        r0.setVisibility(r3);
        boolean r4 = this.a.isShown();
        if (r4 == this.c) goto L14;
        this.c = r4;
        Function1<? super Boolean, Unit> r1 = this.b;
        if (r1 == null) goto L13;
        r1.invoke(Boolean.valueOf(r4));
        return;
    L13:
        return;
    L14:
        return;
    L5:
        r3 = 8;
        goto L6
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.inputtext.p0
    public final void S9(long r4, final Function0<Unit> r6) {
        Intrinsics.checkNotNullParameter(r6, "action");
        if (r4 != 0) goto L5;
        this.a.post(new d(r6));
        return;
    L5:
        this.a.postDelayed(new e(r6), r4);
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.inputtext.p0
    public boolean g1(boolean r1, boolean r2) {
        if (isFocusable() != r1) goto L5;
        return true;
    L5:
        return false;
    }

    /* JADX WARN: Type inference failed for: r4v0, types: [com.larus.bmhome.chat.component.receive.d, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r6v0, types: [com.larus.bmhome.chat.component.receive.e, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r7v0, types: [com.larus.bmhome.chat.component.receive.g, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r8v0, types: [com.larus.bmhome.chat.component.receive.f] */
    @Override // com.larus.bmhome.chat.component.bottom.core.inputtext.p0
    public final void n1(final com.larus.bmhome.chat.component.receive.r r11, final o4 r12) {
        Intrinsics.checkNotNullParameter(r11, "callback");
        String[] r0 = com.larus.bmhome.chat.component.receive.i.a;
        EditText r1 = this.a;
        Intrinsics.checkNotNullParameter(r1, "view");
        Intrinsics.checkNotNullParameter(r11, "onSuccess");
        final String[] r9 = com.larus.bmhome.chat.component.receive.i.a;
        final ?? r4 = new com.larus.bmhome.chat.component.receive.d();
        final ?? r6 = new com.larus.bmhome.chat.component.receive.e();
        final ?? r8 = new com.larus.bmhome.chat.component.receive.f(r12);
        final ?? r7 = new com.larus.bmhome.chat.component.receive.g(r11);
        Intrinsics.checkNotNullParameter(r1, "view");
        Intrinsics.checkNotNullParameter(r9, "mimeTypes");
        Intrinsics.checkNotNullParameter(r4, "predicateSource");
        Intrinsics.checkNotNullParameter(r6, "predicateItem");
        Intrinsics.checkNotNullParameter(r7, "onSuccess");
        ViewCompat.setOnReceiveContentListener(r1, r9, new com.larus.bmhome.chat.component.receive.h(r4, r9, r6, r7, r8));
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.inputtext.p0
    public final void setSelection(int r2, int r3) {
        this.a.setSelection(r2, r3);
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.inputtext.p0
    public void h1(boolean r8, Function0<Boolean> r9, Function0<Unit> r10) {
        Intrinsics.checkNotNullParameter(r9, "needPasteAndSend");
        n0.a(this.a, r8, r9, r10, null, null);
    }
}
