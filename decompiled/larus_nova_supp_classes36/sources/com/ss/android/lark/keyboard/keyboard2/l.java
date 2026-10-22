package com.ss.android.lark.keyboard.keyboard2;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import com.ss.android.lark.keyboard.plugin.input.base.InputSupportType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class l implements mob.a {
    public final View a;
    public final EditText b;
    public com.ss.android.lark.keyboard.b c;

    public static final class a implements TextWatcher {
        public final /* synthetic */ View a;

        @Override // android.text.TextWatcher
        public final void beforeTextChanged(CharSequence r1, int r2, int r3, int r4) {
        }

        @Override // android.text.TextWatcher
        public final void onTextChanged(CharSequence r1, int r2, int r3, int r4) {
        }

        public a(View r1) {
            this.a = r1;
        }

        @Override // android.text.TextWatcher
        public final void afterTextChanged(Editable r3) {
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

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ l a;

        public b(l r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r1) {
            this.a.getClass();
        }
    }

    @Override // mob.a
    public final void A() {
    }

    @Override // com.ss.android.lark.keyboard.keyboard2.c
    public final void d() {
    }

    @Override // com.ss.android.lark.keyboard.keyboard2.c
    public final void j() {
    }

    @Override // mob.a
    public final View onViewCreated(View r2) {
        Intrinsics.checkNotNullParameter(r2, "rootView");
        return r2;
    }

    @Override // mob.a
    public final void s(lob.a r2) {
        Intrinsics.checkNotNullParameter(r2, "watcher");
    }

    @Override // com.ss.android.lark.keyboard.keyboard2.b
    public final void setEnable(boolean r1) {
    }

    @Override // com.ss.android.lark.keyboard.keyboard2.b
    public final EditText c() {
        return this.b;
    }

    @Override // com.ss.android.lark.keyboard.keyboard2.b
    public final InputSupportType getInputType() {
        return InputSupportType.Text;
    }

    public l(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        View r5 = LayoutInflater.from(r4).inflate(2131561723, null);
        r5.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.a = r5;
        this.b = (EditText) r5.findViewById(2131367818);
    }

    @Override // mob.a
    public final View b(ViewGroup r2) {
        Intrinsics.checkNotNullParameter(r2, "container");
        return this.a;
    }

    @Override // com.ss.android.lark.keyboard.keyboard2.c
    public final void setKeyboard(com.ss.android.lark.keyboard.b r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.c = r2;
    }

    @Override // mob.a
    public final View t(ViewGroup r3) {
        Intrinsics.checkNotNullParameter(r3, "container");
        View r4 = com.ss.android.lark.keyboard.utils.h.b(r3.getContext());
        r4.setOnClickListener(new b(this));
        this.b.addTextChangedListener(new a(r4));
        Intrinsics.checkNotNull(r4);
        return r4;
    }
}
