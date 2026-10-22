package com.ss.android.lark.floating.widget.appfloat;

import android.view.WindowManager;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class h {
    public final WindowManagerLayoutParamsInternal a;

    public final int getType() {
        return ((WindowManager.LayoutParams) this.a).type;
    }

    public h() {
        this.a = new WindowManagerLayoutParamsInternal();
    }
}
