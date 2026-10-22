package on8;

import android.view.View;
import com.larus.bmhome.video.ItemType;
import com.larus.im.bean.message.block.UgcItem;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class i implements pr8.f {
    public final /* synthetic */ j a;

    public i(j r1) {
        this.a = r1;
    }

    @Override // pr8.f
    public final void a(View r2) {
        Intrinsics.checkNotNullParameter(r2, "view");
        b r0 = this.a.b;
        if (r0 == null) goto L6;
        r0.a(r2);
        return;
    }

    @Override // pr8.f
    public final void b(View r2, int r3, int r4, String r5) {
        Intrinsics.checkNotNullParameter(r2, "itemView");
        UgcItem r6 = (UgcItem) CollectionsKt.getOrNull(this.a.a.b, r3);
        if (r6 == null) goto L8;
        b r0 = this.a.b;
        if (r0 == null) goto L9;
        r0.b(r2, r3, r4, r6);
        return;
    L9:
        return;
    }

    @Override // pr8.f
    public final void c(View r3, int r4, int r5, pr8.c r6) {
        Intrinsics.checkNotNullParameter(r3, "anchor");
        Intrinsics.checkNotNullParameter(r6, "item");
        Integer r0 = r6.e;
        int r1 = ItemType.VIDEO.getValue();
        if (r0 != null) goto L6;
    L10:
        b r2 = this.a.b;
        if (r2 == null) goto L16;
        r2.c(r3, r4, r5, r6);
        return;
    L16:
        return;
    L6:
        if (r0.intValue() != r1) goto L10;
        b r7 = this.a.b;
        if (r7 == null) goto L14;
        r7.d(r3, r4, r5, r6);
        return;
    }
}
