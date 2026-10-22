package com.larus.bmhome.chat.component.bottom.core.inputtext;

import android.text.Editable;
import android.text.InputFilter;
import android.view.MotionEvent;
import android.widget.EditText;
import com.larus.bmhome.chat.component.bottom.core.m6;
import com.larus.bmhome.chat.component.bottom.core.o4;
import com.larus.bmhome.utils.x1;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public interface p0 {
    void M5(CharSequence r1);

    InputFilter[] S0();

    void S9(long r1, Function0<Unit> r3);

    void T0(m6 r1);

    void U0();

    int V0();

    void W0();

    void X0(int r1);

    EditText Y0();

    s Z0();

    void a(boolean r1);

    void a1(boolean r1);

    void append(CharSequence r1);

    void b(int r1);

    Object b1();

    boolean c1();

    boolean d1();

    int e1();

    void f1(boolean r1);

    boolean g1(boolean r1, boolean r2);

    void h1(boolean r1, Function0<Boolean> r2, Function0<Unit> r3);

    void i1(boolean r1);

    boolean isFocusable();

    void j1();

    CharSequence k1();

    Editable l1();

    void m1(Function1<? super Boolean, Unit> r1);

    void n1(com.larus.bmhome.chat.component.receive.r r1, o4 r2);

    void o1();

    boolean p1(MotionEvent r1);

    void q1(int r1);

    void r1(x1 r1);

    void requestFocus();

    void requestLayout();

    void setAlpha(float r1);

    void setEnabled(boolean r1);

    void setFilters(InputFilter[] r1);

    void setSelection(int r1, int r2);

    void setText(CharSequence r1);

    void setTextColor(int r1);

    void setVisible(boolean r1);

    String text();
}
