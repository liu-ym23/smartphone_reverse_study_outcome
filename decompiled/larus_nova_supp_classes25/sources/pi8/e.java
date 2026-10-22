package pi8;

import android.view.View;
import com.larus.im.bean.message.SearchImageInfo;
import java.util.List;
import kotlin.Pair;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class e extends k {
    public final SearchImageInfo a;
    public final int b;
    public final View c;
    public final Function0<List<SearchImageInfo>> d;
    public final Function0<List<Pair<Integer, View>>> e;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof e) == true) goto L8;
        return false;
    L8:
        e r6 = (e) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (this.b == r6.b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r6.e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        return (((((((this.a.hashCode() * 31) + this.b) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode();
    }

    public final String toString() {
        return "ImageHolderCallbackData(itemData=" + this.a + ", position=" + this.b + ", itemView=" + this.c + ", imageInfoListGetter=" + this.d + ", imageItemViewGetter=" + this.e + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    public e(SearchImageInfo r2, int r3, View r4, Function0<? extends List<SearchImageInfo>> r5, Function0<? extends List<? extends Pair<Integer, ? extends View>>> r6) {
        Intrinsics.checkNotNullParameter(r2, "itemData");
        Intrinsics.checkNotNullParameter(r4, "itemView");
        Intrinsics.checkNotNullParameter(r5, "imageInfoListGetter");
        Intrinsics.checkNotNullParameter(r6, "imageItemViewGetter");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
    }
}
