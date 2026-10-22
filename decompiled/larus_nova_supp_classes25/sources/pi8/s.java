package pi8;

import android.view.View;
import com.larus.bmhome.chat.search.VideoInfo;
import com.larus.bmhome.chat.search.factory.SearchHolderAttachBizType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class s extends k {
    public final VideoInfo a;
    public final int b;
    public final View c;
    public final boolean d;
    public final SearchHolderAttachBizType e;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof s) == true) goto L8;
        return false;
    L8:
        s r6 = (s) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (this.b == r6.b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (this.d == r6.d) goto L21;
        return false;
    L21:
        if (this.e == r6.e) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r0 = ((((this.a.hashCode() * 31) + this.b) * 31) + this.c.hashCode()) * 31;
        if (this.d == false) goto L5;
        int r1 = 1231;
    L7:
        return ((r0 + r1) * 31) + this.e.hashCode();
    L5:
        r1 = 1237;
        goto L7
    }

    public final String toString() {
        return "VideoHolderCallbackData(itemData=" + this.a + ", position=" + this.b + ", itemView=" + this.c + ", isSimpleSearch=" + this.d + ", attachBizType=" + this.e + ')';
    }

    public s(VideoInfo r2, int r3, View r4, boolean r5, SearchHolderAttachBizType r6) {
        Intrinsics.checkNotNullParameter(r2, "itemData");
        Intrinsics.checkNotNullParameter(r4, "itemView");
        Intrinsics.checkNotNullParameter(r6, "attachBizType");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
    }

    public /* synthetic */ s(VideoInfo r7, int r8, View r9, boolean r10, int r11) {
        if ((r11 & 8) == 0) goto L5;
        boolean r4 = false;
    L7:
        if ((r11 & 16) == 0) goto L9;
        SearchHolderAttachBizType r12 = SearchHolderAttachBizType.Other;
    L10:
        this(r7, r8, r9, r4, r12);
        return;
    L9:
        r12 = null;
        goto L10
    L5:
        r4 = r10;
        goto L7
    }
}
