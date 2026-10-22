package com.bytedance.android.livesdk.interactivity.comment.newinput.provider;

import android.text.Editable;
import android.text.TextWatcher;
import com.bytedance.android.live.gift.BaseCommentGiftGuideView;
import com.bytedance.bdlocation.BuildConfig;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class n1 implements TextWatcher {
    public final /* synthetic */ o1.a a;

    public static final class a implements Runnable {
        public final /* synthetic */ n1 a;

        public a(n1 r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.a.b.J();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence r1, int r2, int r3, int r4) {
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence r1, int r2, int r3, int r4) {
    }

    public n1(o1.a r1) {
        this.a = r1;
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable r2) {
        if (r2 == null) goto L5;
        String r3 = r2.toString();
        if (r3 == null) goto L5;
    L6:
        BaseCommentGiftGuideView r0 = this.a.e.c;
        if (r0 == null) goto L10;
        r0.a(r3);
        r0.b(new a(this));
        return;
    L10:
        return;
    L5:
        r3 = BuildConfig.FLAVOR;
        goto L6
    }
}
