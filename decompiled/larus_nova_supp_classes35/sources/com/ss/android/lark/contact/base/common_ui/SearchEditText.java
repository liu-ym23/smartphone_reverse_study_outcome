package com.ss.android.lark.contact.base.common_ui;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.EditText;
import com.larus.apm.impl.protector.RunnableProtector;
import com.tencent.qqmusic.third.api.contract.BuildConfig;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class SearchEditText extends EditText {
    public b a;
    public String b;
    public final a c;

    public class a implements Runnable {
        public final /* synthetic */ SearchEditText a;

        @Override // java.lang.Runnable
        public final void run() {
            SearchEditText r0 = this.a;     // Catch: Throwable -> L8
            if (r0.a == null) goto L11;
            String r1 = r0.getText().toString().replace(" ", BuildConfig.FLAVOR);     // Catch: Throwable -> L8
            if (TextUtils.equals(this.a.b, r1) == true) goto L15;
            SearchEditText r2 = this.a;     // Catch: Throwable -> L8
            r2.b = r1;     // Catch: Throwable -> L8
            r2.a.h(r1);     // Catch: Throwable -> L8
            return;
        L15:
            return;
        L11:
            return;
        L8:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L16;
            throw th;
        }

        public a(SearchEditText r1) {
            this.a = r1;
        }
    }

    public interface b {
        void h(String r1);
    }

    @Override // android.view.View
    public final void onDetachedFromWindow() {
        removeCallbacks(this.c);
        super.onDetachedFromWindow();
    }

    public SearchEditText(Context r2) {
        this(r2, null);
    }

    public void setTextWithoutSpaceChangedListener(b r1) {
        this.a = r1;
    }

    public SearchEditText(Context r1, AttributeSet r2) {
        super(r1, r2);
        this.b = BuildConfig.FLAVOR;
        this.c = new a(this);
    }

    @Override // android.widget.TextView
    public final void onTextChanged(CharSequence r1, int r2, int r3, int r4) {
        super.onTextChanged(r1, r2, r3, r4);
        removeCallbacks(this.c);
        postDelayed(this.c, 300);
    }
}
