package rq0;

import com.bytedance.android.live.openplatform.api.model.shelf.ProductInfo;
import com.bytedance.android.live.openplatform.api.model.shelf.ShelfCardInfo;
import com.bytedance.android.live.openplatform.api.model.shelf.e;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a implements com.bytedance.android.live.openplatform.api.model.shelf.a {
    public final ShelfCardInfo a;
    public final e b;

    @Override // com.bytedance.android.live.openplatform.api.model.shelf.a
    public final Pair<Integer, String> a(String r2) {
        return this.a.a(r2);
    }

    @Override // com.bytedance.android.live.openplatform.api.model.shelf.a
    public final String b() {
        return this.a.b();
    }

    public final String c(String r2) {
        return this.a.k(r2);
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof a) == false) goto L10;
        a r4 = (a) r3;
        if (Intrinsics.areEqual(this.a, r4.a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.b, r4.b) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    @Override // com.bytedance.android.live.openplatform.api.model.shelf.a
    public final long getCardId() {
        return this.a.getCardId();
    }

    @Override // com.bytedance.android.live.openplatform.api.model.shelf.a
    public final ProductInfo getProductInfo() {
        return this.a.getProductInfo();
    }

    @Override // com.bytedance.android.live.openplatform.api.model.shelf.a
    public final long getStatus() {
        return this.a.getStatus();
    }

    public final int hashCode() {
        ShelfCardInfo r0 = this.a;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        e r4 = this.b;
        if (r4 == null) goto L10;
        r1 = r4.hashCode();
    L10:
        return r3 + r1;
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "AudienceShelfDisplayCardInfo(shelfCardInfo=" + this.a + ", shelfCardSupplementInfo=" + this.b + ")";
    }

    public a(ShelfCardInfo r2, e r3) {
        Intrinsics.checkNotNullParameter(r2, "shelfCardInfo");
        this.a = r2;
        this.b = r3;
    }
}
