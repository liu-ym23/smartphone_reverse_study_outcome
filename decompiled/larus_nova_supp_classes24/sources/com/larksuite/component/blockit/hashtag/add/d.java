package com.larksuite.component.blockit.hashtag.add;

import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import com.larksuite.framework.utils.KeyboardUtils;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class d implements View.OnFocusChangeListener {
    public final /* synthetic */ EditText a;
    public final /* synthetic */ b b;

    public d(EditText r1, b r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnFocusChangeListener
    public final void onFocusChange(View r1, boolean r2) {
        if (r2 == false) goto L5;
        KeyboardUtils.showKeyboard(this.a);
        return;
    L5:
        if (TextUtils.isEmpty(this.a.getText()) == false) goto L9;
        KeyboardUtils.hideKeyboard(this.b.g);
        return;
    }
}
