package m0a;

import androidx.recyclerview.widget.RecyclerView;
import com.larus.ugc.feed.api.model.CreationFeedInitParamsKmp;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class i {
    public final CreationFeedInitParamsKmp a;
    public final RecyclerView.ItemDecoration b;
    public final RecyclerView.ItemDecoration c;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof i) == true) goto L8;
        return false;
    L8:
        i r6 = (i) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r0 = this.a.hashCode() * 31;
        RecyclerView.ItemDecoration r1 = this.b;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        RecyclerView.ItemDecoration r5 = this.c;
        if (r5 == null) goto L11;
        r2 = r5.hashCode();
    L11:
        return r4 + r2;
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public final String toString() {
        return "CreationFeedInitParamsAndroid(common=" + this.a + ", customItemDecoration=" + this.b + ", loadingItemDecoration=" + this.c + ')';
    }

    public i(CreationFeedInitParamsKmp r2, RecyclerView.ItemDecoration r3, RecyclerView.ItemDecoration r4) {
        Intrinsics.checkNotNullParameter(r2, "common");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
