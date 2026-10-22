package qc8;

import android.view.ViewGroup;
import com.larus.bmhome.chat.bubble.floating.component.BubbleBannerComponent;
import java.lang.ref.WeakReference;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class k implements Function0 {
    public final /* synthetic */ WeakReference a;
    public final /* synthetic */ WeakReference b;

    public /* synthetic */ k(WeakReference r1, WeakReference r2) {
        this.a = r1;
        this.b = r2;
    }

    public final Object invoke() {
        WeakReference r0 = this.a;
        WeakReference r1 = this.b;
        int r2 = BubbleBannerComponent.S;
        BubbleBannerComponent r3 = (BubbleBannerComponent) r0.get();
        ViewGroup r4 = (ViewGroup) r1.get();
        if (r3 == null) goto L8;
        if (r4 == null) goto L8;
        if (r3.B4(r4).a() == false) goto L8;
        boolean r5 = true;
    L10:
        return Boolean.valueOf(r5);
    L8:
        r5 = false;
        goto L10
    }
}
