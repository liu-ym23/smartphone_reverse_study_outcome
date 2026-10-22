package qc8;

import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import com.larus.bmhome.chat.bubble.floating.component.BubbleBannerComponent;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class o implements ViewTreeObserver.OnGlobalLayoutListener {
    public final /* synthetic */ BubbleBannerComponent a;
    public final /* synthetic */ ViewGroup b;

    public /* synthetic */ o(BubbleBannerComponent r1, ViewGroup r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        BubbleBannerComponent r0 = this.a;
        ViewGroup r1 = this.b;
        int r2 = BubbleBannerComponent.S;
        r0.j4(r1);
    }
}
