package com.larus.business.markdown.impl;

import android.text.SpannableStringBuilder;
import android.text.style.LeadingMarginSpan;
import com.larus.business.markdown.impl.markwon.MarkwonContent;
import java.util.Comparator;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class MarkdownServiceImpl$b<T> implements Comparator<T> {
    public final /* synthetic */ MarkwonContent a;

    public MarkdownServiceImpl$b(MarkwonContent r1) {
        this.a = r1;
    }

    @Override // java.util.Comparator
    public final int compare(T r2, T r3) {
        SpannableStringBuilder r0 = this.a.a;
        Integer r4 = Integer.valueOf(r0.getSpanStart((LeadingMarginSpan) r3));
        SpannableStringBuilder r1 = this.a.a;
        return ComparisonsKt.compareValues(r4, Integer.valueOf(r1.getSpanStart((LeadingMarginSpan) r2)));
    }
}
