package qc8;

import android.view.View;
import com.larus.bmhome.chat.bubble.floating.component.BubbleBannerComponent;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class d implements View.OnClickListener {
    public final /* synthetic */ BubbleBannerComponent a;
    public final /* synthetic */ pc8.e b;

    public /* synthetic */ d(BubbleBannerComponent r1, pc8.e r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r4) {
        BubbleBannerComponent r0 = this.a;
        pc8.e r1 = this.b;
        int r2 = BubbleBannerComponent.S;
        Intrinsics.checkNotNull(r4);
        r0.d4(r4, r1.a);
    }
}
