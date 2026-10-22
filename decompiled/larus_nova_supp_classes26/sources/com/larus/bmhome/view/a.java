package com.larus.bmhome.view;

import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final /* synthetic */ class a implements e6a.d {
    public final /* synthetic */ int a;

    public /* synthetic */ a(int r1) {
        this.a = r1;
    }

    public final Object getValue() {
        int r0 = this.a;
        int r1 = BaseTextAnswerActionButton.a;
        return new PorterDuffColorFilter(r0, PorterDuff.Mode.SRC_ATOP);
    }
}
