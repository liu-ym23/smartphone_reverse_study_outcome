package com.bytedance.android.livesdk.interactivity.api.publicscreen.utils;

import android.text.Spanned;
import java.util.Comparator;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class w implements Comparator<Object> {
    public final /* synthetic */ Spanned a;

    public w(Spanned r1) {
        this.a = r1;
    }

    @Override // java.util.Comparator
    public final int compare(Object r2, Object r3) {
        if (r2 == null) goto L7;
        if (r3 != null) goto L6;
        return -1;
    L6:
        return this.a.getSpanStart(r2) - this.a.getSpanStart(r3);
    L7:
        return -1;
    }
}
