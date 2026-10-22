package b72;

import android.text.Editable;
import java.util.Comparator;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class d<T> implements Comparator {
    public final /* synthetic */ Editable a;

    public d(Editable r1) {
        this.a = r1;
    }

    @Override // java.util.Comparator
    public final int compare(Object r3, Object r4) {
        e90.a r5 = (e90.a) r3;
        e90.a r6 = (e90.a) r4;
        if (this.a.getSpanStart(r5) == this.a.getSpanStart(r6)) goto L6;
        return this.a.getSpanStart(r5) - this.a.getSpanStart(r6);
    L6:
        return this.a.getSpanEnd(r6) - this.a.getSpanEnd(r5);
    }
}
