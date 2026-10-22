package y81;

import android.view.ViewGroup;
import android.widget.TextSwitcher;
import com.bytedance.android.live.core.utils.s1;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class m<T> implements Consumer {
    public final /* synthetic */ l a;

    public m(l r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        l r3 = (l) r2;
        Integer r4 = this.a.P;
        if (r4 != null) goto L6;
        return;
    L6:
        if (r4.intValue() != 2) goto L25;
        ViewGroup r5 = this.a.n;
        if (r5 != null) goto L10;
    L14:
        TextSwitcher r6 = this.a.H;
        if (r6 != null) goto L17;
    L21:
        TextSwitcher r7 = this.a.H;
        if (r7 == null) goto L26;
        r7.setCurrentText(s1.B(2131916256));
        return;
    L26:
        return;
    L17:
        if (r6.getVisibility() != 8) goto L21;
        TextSwitcher r8 = this.a.H;
        if (r8 == null) goto L21;
        r8.setVisibility(0);
        goto L21
    L10:
        if (r5.getVisibility() != 0) goto L14;
        ViewGroup r9 = this.a.n;
        if (r9 == null) goto L14;
        r9.setVisibility(8);
        goto L14
    }
}
