package com.larus.bmhome.chat.component.bottom.core.inputtext;

import android.text.Editable;
import android.view.View;
import android.widget.EditText;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class s implements nq8.a {
    public final EditText a;
    public final List<nq8.a.a> b;
    public View.OnKeyListener c;
    public boolean d;

    public final int c() {
        return this.a.getSelectionEnd();
    }

    public final int g() {
        return this.a.getSelectionStart();
    }

    public final Editable getText() {
        return this.a.getText();
    }

    public s(EditText r2) {
        Intrinsics.checkNotNullParameter(r2, "editText");
        this.a = r2;
        this.b = new ArrayList();
    }

    public final void a(qq8.a r2) {
        Intrinsics.checkNotNullParameter(r2, "interceptor");
        ((ArrayList) this.b).remove(r2);
    }

    public final void b(int r2) {
        this.a.setSelection(r2);
    }

    public final void d(uq8.a r2) {
        Intrinsics.checkNotNullParameter(r2, "watcher");
        this.a.addTextChangedListener(r2);
    }

    public final void e(qq8.a r4) {
        Intrinsics.checkNotNullParameter(r4, "interceptor");
        ((ArrayList) this.b).add(r4);
        if (this.d == true) goto L19;
        this.d = true;
        Field r0 = View.class.getDeclaredField("mListenerInfo");     // Catch: Exception -> L16
        r0.setAccessible(true);     // Catch: Exception -> L16
        Object r1 = r0.get(this.a);     // Catch: Exception -> L16
        if (r1 == null) goto L13;
        Field r2 = r1.getClass().getDeclaredField("mOnKeyListener");     // Catch: Exception -> L16
        r2.setAccessible(true);     // Catch: Exception -> L16
        Object r5 = r2.get(r1);     // Catch: Exception -> L16
        if ((r5 instanceof View.OnKeyListener) == false) goto L13;
        View.OnKeyListener r6 = (View.OnKeyListener) r5;     // Catch: Exception -> L16
    L14:
        this.c = r6;
        this.a.setOnKeyListener(new r(this));
        return;
    L13:
        r6 = null;
        goto L14
    }

    public final void f(uq8.a r2) {
        Intrinsics.checkNotNullParameter(r2, "watcher");
        this.a.removeTextChangedListener(r2);
    }
}
