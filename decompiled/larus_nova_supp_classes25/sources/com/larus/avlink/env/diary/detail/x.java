package com.larus.avlink.env.diary.detail;

import android.graphics.Rect;
import android.view.View;
import com.larus.bmhome.chat.api.SelectionRangeType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class x implements com.larus.bmhome.chat.api.d0 {
    public final /* synthetic */ w a;

    @Override // com.larus.bmhome.chat.api.d0
    public final void b(SelectionRangeType r1, int r2, int r3, boolean r4, boolean r5, Rect r6, String r7) {
        Intrinsics.checkNotNullParameter(r1, "rangeType");
        Intrinsics.checkNotNullParameter(r7, "selectedText");
    }

    public x(w r1) {
        this.a = r1;
    }

    @Override // com.larus.bmhome.chat.api.d0
    public final void a(View r2, int r3, int r4) {
        if (r4 != 1) goto L9;
        w r5 = this.a;
        if (r5.g == false) goto L7;
        r5.f = true;
        r5.b(false, true);
        return;
    L7:
        r5.f = false;
        r5.onShow();
        return;
    }
}
