package com.ss.android.lark.contact.base.contact_search;

import android.view.MotionEvent;
import android.view.View;
import com.larksuite.framework.utils.KeyboardUtils;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class o implements View.OnTouchListener {
    public final /* synthetic */ s a;

    public o(s r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View r2, MotionEvent r3) {
        this.a.r.setVisibility(0);
        this.a.s.setVisibility(8);
        KeyboardUtils.showKeyboard(this.a.r);
        return this.a.r.dispatchTouchEvent(r3);
    }
}
