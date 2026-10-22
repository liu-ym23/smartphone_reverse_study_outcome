package com.obric.assistant.util;

import android.text.NoCopySpan;
import android.text.Selection;
import android.text.SpanWatcher;
import android.text.Spannable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class t1 implements SpanWatcher, NoCopySpan {
    public final /* synthetic */ ObricMentionHighlightHelper.a a;

    @Override // android.text.SpanWatcher
    public final void onSpanAdded(Spannable r1, Object r2, int r3, int r4) {
    }

    @Override // android.text.SpanWatcher
    public final void onSpanRemoved(Spannable r1, Object r2, int r3, int r4) {
    }

    public t1(ObricMentionHighlightHelper.a r1) {
        this.a = r1;
    }

    @Override // android.text.SpanWatcher
    public final void onSpanChanged(Spannable r1, Object r2, int r3, int r4, int r5, int r6) {
        if (r2 != Selection.SELECTION_START) goto L5;
    L6:
        this.a.a(r1);
        return;
    L5:
        if (r2 == Selection.SELECTION_END) goto L6;
    }
}
