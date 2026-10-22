package com.larus.bmhome.chat.component.bottom.core.inputtext;

import android.text.Editable;
import java.util.Comparator;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class z<T> implements Comparator {
    public final /* synthetic */ Editable a;

    public z(Editable r1) {
        this.a = r1;
    }

    @Override // java.util.Comparator
    public final int compare(T r2, T r3) {
        return ComparisonsKt.compareValues(Integer.valueOf(this.a.getSpanStart(r3)), Integer.valueOf(this.a.getSpanStart(r2)));
    }
}
