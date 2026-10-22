package n92;

import com.bytedance.android.livesdk.interactivity.pin.business.video.PinVideoHighlightPageItemView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class b implements qb2.e {
    public final /* synthetic */ PinVideoHighlightPageItemView a;

    public b(PinVideoHighlightPageItemView r1) {
        this.a = r1;
    }

    @Override // qb2.e
    public final void a(ak6.g r2) {
        Intrinsics.checkNotNullParameter(r2, "rendResult");
        Intrinsics.checkNotNullParameter(r2, "rendResult");
    }

    @Override // qb2.e
    public final void b(ak6.g r2) {
        Intrinsics.checkNotNullParameter(r2, "rendResult");
        this.a.k.setText(r2.a);
    }
}
