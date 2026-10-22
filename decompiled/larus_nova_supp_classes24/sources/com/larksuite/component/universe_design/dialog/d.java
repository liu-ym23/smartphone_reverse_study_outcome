package com.larksuite.component.universe_design.dialog;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import com.larksuite.component.universe_design.color.UDColorUtils;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class d extends UDDialogController {
    public int a;
    public int b;
    public int c;
    public int d;
    public int e;
    public int f;
    public int g;
    public int h;
    public int i;
    public CharSequence j;
    public CharSequence k;
    public boolean l;
    public boolean m;
    public com.larksuite.component.universe_design.dialog.c.a n;
    public c o;
    public final a p;

    public static final class a implements TextWatcher {
        public final /* synthetic */ d a;

        @Override // android.text.TextWatcher
        public final void beforeTextChanged(CharSequence r1, int r2, int r3, int r4) {
            Intrinsics.checkNotNullParameter(r1, "s");
        }

        @Override // android.text.TextWatcher
        public final void onTextChanged(CharSequence r1, int r2, int r3, int r4) {
            Intrinsics.checkNotNullParameter(r1, "s");
        }

        public a(d r1) {
            this.a = r1;
        }

        @Override // android.text.TextWatcher
        public final void afterTextChanged(Editable r2) {
            Intrinsics.checkNotNullParameter(r2, "s");
            com.larksuite.component.universe_design.dialog.c.a r0 = this.a.n;
            if (r0 == null) goto L5;
            r0.onTextChanged(r2);
        L5:
            c r1 = this.a.o;
            if (r1 == null) goto L9;
            r1.onTextChanged(r2);
            return;
        }
    }

    public static final class b implements View.OnFocusChangeListener {
        public final /* synthetic */ d a;
        public final /* synthetic */ EditText b;

        public b(d r1, EditText r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.view.View.OnFocusChangeListener
        public final void onFocusChange(View r2, boolean r3) {
            if (r3 == false) goto L10;
            Object r4 = this.a.getContext().getSystemService("input_method");
            if ((r4 instanceof InputMethodManager) == false) goto L6;
            InputMethodManager r5 = (InputMethodManager) r4;
        L7:
            if (r5 == null) goto L11;
            r5.showSoftInput(this.b, 2);
            return;
        L11:
            return;
        L6:
            r5 = null;
            goto L7
        }
    }

    public static final class c implements com.larksuite.component.universe_design.dialog.c.a {
        public final /* synthetic */ View a;

        public c(View r1) {
            this.a = r1;
        }

        @Override // com.larksuite.component.universe_design.dialog.c.a
        public final void onTextChanged(CharSequence r3) {
            View r0 = this.a;
            if (r3 != null) goto L5;
        L8:
            boolean r4 = true;
        L9:
            r0.setEnabled(!r4);
            return;
        L5:
            if (r3.length() == 0) goto L8;
            r4 = false;
            goto L9
        }
    }

    @Override // com.larksuite.component.universe_design.dialog.UDDialogController
    public final int getDefaultContentRes() {
        return 2131568089;
    }

    @Override // com.larksuite.component.universe_design.dialog.UDDialogController
    public final View onCreateContent() {
        View r0 = super.onCreateContent();
        if (r0 != null) goto L6;
        return null;
    L6:
        EditText r3 = (EditText) r0.findViewById(2131391787);
        r3.setText(this.k);
        r3.addTextChangedListener(this.p);
        int r1 = this.a;
        if (r1 == (-1)) goto L9;
        r3.setInputType(r1);
    L9:
        CharSequence r2 = this.j;
        if (r2 == null) goto L12;
        r3.setHint(r2);
    L12:
        boolean r8 = false;
        if (this.f == (-1)) goto L16;
        r3.setSingleLine(false);
        r3.setMaxLines(this.f);
    L16:
        if (this.g == (-1)) goto L19;
        r3.setHintTextColor(UDColorUtils.getColor(getContext(), this.g));
    L19:
        if (this.h == (-1)) goto L21;
        r3.setTextColor(UDColorUtils.getColor(getContext(), this.h));
    L21:
        int r4 = this.i;
        if (r4 == (-1)) goto L25;
        r3.setBackgroundResource(r4);
    L25:
        if (this.m == false) goto L27;
        r3.setOnFocusChangeListener(new b(this, r3));
        r3.requestFocus();
    L27:
        r3.setSelection(this.k.length());
        setupViewPadding(r3, this.b, this.c, this.d, this.e);
        CharSequence r5 = getMMessage();
        if (r5 != null) goto L30;
    L31:
        r8 = true;
    L32:
        if (r8 == false) goto L36;
        TextView r6 = (TextView) r0.findViewById(2131391794);
        if (r6 == null) goto L36;
        r6.setVisibility(8);
    L36:
        return r0;
    L30:
        if (r5.length() != 0) goto L32;
        goto L31
    }

    @Override // com.larksuite.component.universe_design.dialog.UDDialogController
    public final View onCreateFooter() {
        View r0 = super.onCreateFooter();
        if (r0 != null) goto L7;
        return null;
    L7:
        if (this.l == false) goto L15;
        View r1 = r0.findViewById(2131391777);
        if (r1 == null) goto L15;
        if (this.k.length() <= 0) goto L13;
        boolean r2 = true;
    L14:
        r1.setEnabled(r2);
        this.o = new c(r1);
        goto L15
    L13:
        r2 = false;
    L15:
        return r0;
    }

    public d(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        this.a = -1;
        this.b = -1;
        this.c = -1;
        this.d = -1;
        this.e = -1;
        this.f = -1;
        this.g = -1;
        this.h = -1;
        this.i = -1;
        this.k = "";
        this.p = new a(this);
    }

    @Override // com.larksuite.component.universe_design.dialog.UDDialogController
    public final <T extends UDBaseDialogBuilder<? extends T>> void apply(UDBaseDialogBuilder<? extends T> r2, UDDialog r3) {
        Intrinsics.checkNotNullParameter(r2, "builder");
        Intrinsics.checkNotNullParameter(r3, "dialog");
        if ((r2 instanceof com.larksuite.component.universe_design.dialog.c) == false) goto L7;
        super.apply(r2, r3);
        com.larksuite.component.universe_design.dialog.c r4 = (com.larksuite.component.universe_design.dialog.c) r2;
        this.a = r4.a;
        this.b = r4.b;
        this.c = r4.c;
        this.d = r4.d;
        this.e = r4.e;
        this.f = r4.f;
        this.g = r4.g;
        this.h = r4.h;
        this.i = r4.i;
        this.j = r4.j;
        this.k = r4.k;
        this.n = r4.n;
        this.l = r4.l;
        this.m = r4.m;
        return;
    L7:
        throw new IllegalArgumentException("builder should be UDInputDialogBuilder, but actually ".concat(r2.getClass().getSimpleName()).toString());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.larksuite.component.universe_design.dialog.UDDialogController, com.larksuite.component.universe_design.dialog.UDDialog.DialogCallback
    public final void onCreate(UDDialog r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r2, "dialog");
        super.onCreate(r2, r3);
        if (this.m == false) goto L8;
        Window r4 = r2.getWindow();
        if (r4 == null) goto L9;
        r4.setSoftInputMode(21);
        return;
    L9:
        return;
    }
}
