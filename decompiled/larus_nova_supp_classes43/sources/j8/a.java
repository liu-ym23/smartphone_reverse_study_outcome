package j8;

import android.view.View;
import com.bytedance.android.annie.api.card.IHybridComponent;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a extends b7.a {
    public final b a;
    public String b;

    public a(b r10) {
        Intrinsics.checkNotNullParameter(r10, "bcl");
        this.a = r10;
    }

    @Override // b7.a, b7.b
    public final void onLoadSuccess(View r10) {
        this.a.a(r10, this.b);
    }

    @Override // b7.a, b7.b
    public final void onAttachView(View r10, IHybridComponent.HybridType r11, String r12) {
        Intrinsics.checkNotNullParameter(r10, "view");
        Intrinsics.checkNotNullParameter(r11, "hybridType");
        super.onAttachView(r10, r11, r12);
        this.a.onAttachView(r10, this.b);
    }

    @Override // b7.a, b7.b
    public final void onLoadFail(View r1, String r10, String r11) {
        this.a.b(r1, r10);
    }

    @Override // b7.a, b7.b
    public final void onPrepareInitDataStart(String r10, String r11, boolean r12) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_SCHEME);
        Intrinsics.checkNotNullParameter(r11, "fallbackUrl");
        if (r12 == false) goto L5;
        r10 = r11;
    L5:
        this.b = r10;
    }
}
