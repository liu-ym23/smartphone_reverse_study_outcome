package com.ss.android.lark.contact.base.contact_search;

import android.view.MotionEvent;
import android.view.View;
import com.larksuite.framework.utils.KeyboardUtils;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class h implements View.OnTouchListener {
    public final /* synthetic */ s a;

    public h(s r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View r2, MotionEvent r3) {
        this.a.v.setVisibility(0);
        this.a.w.setVisibility(8);
        KeyboardUtils.showKeyboard(this.a.v);
        return this.a.v.dispatchTouchEvent(r3);
    }
}
