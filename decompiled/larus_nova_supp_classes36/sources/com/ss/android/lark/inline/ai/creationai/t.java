package com.ss.android.lark.inline.ai.creationai;

import android.view.View;
import com.ss.android.lark.log.Log;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class t implements View.OnClickListener {
    public static final t a = null;

    static {
        a = new t();
    }

    public t() {
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        Log.i("CreationAIPanelController", "click panel view");
    }
}
