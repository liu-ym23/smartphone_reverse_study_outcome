package com.ss.android.lark.flow.passport.ui.widget.verifycode;

import android.app.Activity;
import android.content.Context;
import android.text.Editable;
import android.util.AttributeSet;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.RelativeLayout;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.flow.passport.ui.widget.common.CodeView;
import com.ss.android.lark.flow.passport.ui.widget.layout.MaxWidthLinerLayout;
import com.suite.lark.emm.design.edittext.SCEditText;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public class VerifyCodeEditText extends RelativeLayout {
    public static final /* synthetic */ int h = 0;
    public SCEditText a;
    public final Context b;
    public MaxWidthLinerLayout c;
    public CodeView[] d;
    public int e;
    public f f;
    public e g;

    public class a implements Runnable {
        public final /* synthetic */ VerifyCodeEditText a;

        @Override // java.lang.Runnable
        public final void run() {
            Activity r0 = qyb.d.a(this.a);     // Catch: Throwable -> L16
            if (r0 != null) goto L5;
            return;
        L5:
            if (uzb.f.c(r0) == false) goto L8;
            return;
        L8:
            if (this.a.a.isFocused() == false) goto L24;
            View r1 = this.a.a;     // Catch: Throwable -> L16
            if (r1 == null) goto L25;
            InputMethodManager r2 = (InputMethodManager) r1.getContext().getSystemService("input_method");     // Catch: Throwable -> L16
            if (r2 == null) goto L26;
            r1.requestFocus();     // Catch: Throwable -> L16
            r2.showSoftInput(r1, 0);     // Catch: Throwable -> L16
            return;
        L26:
            return;
        L25:
            return;
        L24:
            return;
        L16:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L27;
            throw th;
        }

        public a(VerifyCodeEditText r1) {
            this.a = r1;
        }
    }

    public interface b {
    }

    public interface c {
    }

    public interface d {
    }

    public interface e {
        void a(String r1);
    }

    public interface f {
        void onFinish();
    }

    public void setOnInputCompleteListener(b r1) {
    }

    public void setOnInputProcessListener(c r1) {
    }

    public void setOnKeyboardWillShowListener(d r1) {
    }

    public final void b() {
        SCEditText r0 = this.a;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.setFocusable(true);
        this.a.setFocusableInTouchMode(true);
        this.a.requestFocus();
        postDelayed(new a(this), 500);
    }

    public String getVerifyCodeText() {
        SCEditText r0 = this.a;
        if (r0 != null) goto L5;
        return "";
    L5:
        return r0.getText().toString().trim();
    }

    public VerifyCodeEditText(Context r2) {
        this(r2, null);
    }

    public final void a(Editable r5) {
        int r1 = 0;
        if (r5.length() <= 0) goto L14;
        int r0 = r5.length();
    L6:
        if (r1 >= this.e) goto L19;
        if (r1 >= r0) goto L9;
        char r2 = r5.charAt(r1);
        this.d[r1].setText(String.valueOf(r2));
    L12:
        r1 = r1 + 1;
        goto L6
    L9:
        if (r1 != r0) goto L11;
        this.d[r1].e();
        goto L12
    L11:
        this.d[r1].c();
        goto L12
    L19:
        return;
    L14:
        if (r1 >= this.e) goto L27;
        this.d[r1].c();
        if (r1 != 0) goto L18;
        this.d[r1].e();
    L18:
        r1 = r1 + 1;
        goto L14
    }

    @Override // android.view.View
    public void setOnCreateContextMenuListener(View.OnCreateContextMenuListener r1) {
        super.setOnCreateContextMenuListener(r1);
    }

    public void setOnTextChangeListener(e r1) {
        this.g = r1;
    }

    public void setOnTextFinishListener(f r1) {
        this.f = r1;
    }

    public VerifyCodeEditText(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    @Override // android.widget.RelativeLayout, android.view.View
    public final void onMeasure(int r4, int r5) {
        CodeView[] r0 = this.d;
        int r1 = 0;
        if (r0 != null) goto L5;
    L7:
        if (r1 <= 0) goto L9;
        r5 = View.MeasureSpec.makeMeasureSpec(r1, 1073741824);
    L9:
        super.onMeasure(r4, r5);
        return;
    L5:
        if (r0.length <= 0) goto L7;
        r1 = r0[0].getMeasuredHeight();
        goto L7
    }

    public VerifyCodeEditText(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        this.e = 4;
        this.b = r1;
    }
}
