package com.ss.android.lark.inline.ai.ui;

import android.view.View;
import com.ss.android.lark.log.Log;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class p implements View.OnClickListener {
    public static final p a = null;

    static {
        a = new p();
    }

    public p() {
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        Log.i("InlineAIPanelController", "click panel view");
    }
}
