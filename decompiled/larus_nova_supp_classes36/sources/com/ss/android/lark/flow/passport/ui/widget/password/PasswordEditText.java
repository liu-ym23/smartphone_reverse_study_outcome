package com.ss.android.lark.flow.passport.ui.widget.password;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.text.InputFilter;
import android.util.AttributeSet;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.larus.apm.impl.protector.RunnableProtector;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.flow.passport.ui.widget.common.h;
import com.ss.android.lark.utils.Contexts;
import com.suite.lark.emm.design.edittext.SCEditText;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public class PasswordEditText extends RelativeLayout {
    public static final /* synthetic */ int k = 0;
    public SCEditText a;
    public CheckBox b;
    public ImageView c;
    public f d;
    public final Context e;
    public View.OnFocusChangeListener f;
    public g g;
    public c h;
    public final List<ValueAnimator> i;
    public final h j;

    public class a implements Runnable {
        public final /* synthetic */ PasswordEditText a;

        @Override // java.lang.Runnable
        public final void run() {
        L7:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L14;
            throw th;
        L14:
            return;
        L3:
            if (uzb.f.c(Contexts.requireActivity(this.a.e)) == true) goto L10;
            ((InputMethodManager) this.a.a.getContext().getSystemService("input_method")).showSoftInput(this.a.a, 0);     // Catch: Throwable -> L7
            return;
        }

        public a(PasswordEditText r1) {
            this.a = r1;
        }
    }

    public class b extends InputFilter.LengthFilter {
        public b(int r1) {
            super(r1);
        }
    }

    public interface c {
        void a(String r1);
    }

    public interface d {
    }

    public interface e {
    }

    public static class f {
        public int a;
        public int b;
        public int c;
        public int d;
        public int e;
        public int f;
        public String g;
        public int h;

        public f() {
            this.h = 2131248226;
        }
    }

    public interface g {
        void h(String r1);
    }

    public void setKeyboardWillOpenListener(e r1) {
    }

    public void setOnKeyboardDetectorListener(d r1) {
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

    public String getString() {
        SCEditText r0 = this.a;
        if (r0 != null) goto L5;
        return "";
    L5:
        return r0.getText().toString();
    }

    public PasswordEditText(Context r2) {
        this(r2, null);
    }

    public final int a(float r3) {
        Resources r0 = this.e.getResources();
        return (int) ((r3 * WindowDisplayMetricsOverride.apply(r0, r0.getDisplayMetrics()).density) + 0.5f);
    }

    public void setMaxLength(int r4) {
        this.a.setFilters(new InputFilter[]{new b(r4)});
    }

    public void setOnInputCompleteListener(c r1) {
        this.h = r1;
    }

    public void setOnInputFocusChangeListener(View.OnFocusChangeListener r1) {
        this.f = r1;
    }

    public void setTextChangeListener(g r1) {
        this.g = r1;
    }

    public PasswordEditText(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    public PasswordEditText(Context r3, AttributeSet r4, int r5) {
        super(r3, r4, r5);
        this.i = new ArrayList();
        Context r6 = getContext();
        Intrinsics.checkNotNullParameter(r6, "context");
        this.j = new h(r6, 0.0f, 6);
        this.e = r3;
    }
}
