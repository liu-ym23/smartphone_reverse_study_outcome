package qc8;

import android.view.ViewGroup;
import com.larus.bmhome.chat.bubble.floating.component.BubbleBannerComponent;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class p implements Runnable {
    public final /* synthetic */ BubbleBannerComponent a;
    public final /* synthetic */ ViewGroup b;

    public /* synthetic */ p(BubbleBannerComponent r1, ViewGroup r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        BubbleBannerComponent r0 = this.a;
        ViewGroup r1 = this.b;
        if (Intrinsics.areEqual(r0.z, r1) == false) goto L6;
        r0.j4(r1);
        return;
    }
}
