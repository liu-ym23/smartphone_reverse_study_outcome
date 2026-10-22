package qc8;

import com.larus.bmhome.chat.bubble.floating.component.BubbleBannerComponent;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class b implements Runnable {
    public final /* synthetic */ BubbleBannerComponent a;
    public final /* synthetic */ String b;

    public /* synthetic */ b(BubbleBannerComponent r1, String r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        BubbleBannerComponent r0 = this.a;
        String r1 = this.b;
        if (Intrinsics.areEqual(r0.x, r1) == false) goto L6;
        r0.x = null;
        r0.v4();
        return;
    }
}
