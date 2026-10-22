package l92;

import com.bytedance.android.livesdk.interactivity.pin.business.im.PinImHighlightPageItemView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class f implements qb2.e {
    public final /* synthetic */ PinImHighlightPageItemView a;

    public f(PinImHighlightPageItemView r1) {
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
        this.a.h.setText(r2.a);
    }
}
