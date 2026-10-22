package com.ss.android.lark.keyboard.edittext2.widget;

import android.text.Editable;
import android.text.Spannable;
import android.text.TextWatcher;
import com.ss.android.lark.log.Log;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class i implements TextWatcher {
    public final /* synthetic */ List<Object> a;
    public final /* synthetic */ Spannable b;

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable r1) {
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence r1, int r2, int r3, int r4) {
    }

    public i(List<Object> r1, Spannable r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence r1, int r2, int r3, int r4) {
        Log.i("SpannableBuilderCompat", "execute removeSpanOnReplace, result count is " + this.a.size());
        List<Object> r5 = this.a;
        Spannable r6 = this.b;
        Iterator<T> r7 = r5.iterator();
    L4:
        if (r7.hasNext() == false) goto L6;
        r6.removeSpan(r7.next());
        goto L4
    L6:
        this.b.removeSpan(this);
    }
}
