package o92;

import androidx.viewpager.widget.PagerAdapter;
import com.bytedance.android.livesdk.interactivity.common.utils.LiveHighlightAppLogger;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a<T> implements Consumer {
    public final /* synthetic */ b a;
    public final /* synthetic */ int b;

    public a(b r1) {
        this.a = r1;
        this.b = 0;
    }

    public final void accept(Object r4) {
        Long r5 = (Long) r4;
        int r6 = this.a.b.getCurrentItem();
        int r0 = r6 + 1;
        PagerAdapter r1 = this.a.b.getAdapter();
        if (r1 != null) goto L5;
    L13:
        if (r6 != r0) goto L15;
    L17:
        this.a.b.setCurrentItem(r0);
        return;
    L15:
        if (this.a.d == false) goto L17;
        LiveHighlightAppLogger.c(this.b);
        goto L17
    L5:
        if (r0 != r1.getCount()) goto L13;
        b r2 = this.a;
        if (r2.e == true) goto L12;
        Disposable r3 = r2.a;
        if (r3 == null) goto L11;
        r3.dispose();
    L11:
        r2.a = null;
        goto L13
    L12:
        r0 = 0;
        goto L13
    }
}
