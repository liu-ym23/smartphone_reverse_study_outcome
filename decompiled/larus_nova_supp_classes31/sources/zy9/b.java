package zy9;

import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.im.bean.message.CreationItem;
import com.larus.uaigc.chat.block.correction.CorrectionImageView;
import com.larus.uaigc.chat.block.correction.f;
import com.larus.uaigc.chat.block.correction.n;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class b implements n {
    public final /* synthetic */ c a;

    public b(c r1) {
        this.a = r1;
    }

    @Override // com.larus.uaigc.chat.block.correction.n
    public final void b(SimpleDraweeView r3) {
        Intrinsics.checkNotNullParameter(r3, "bindView");
        a r0 = this.a.c;
        if (r0 == null) goto L13;
        List<CreationItem> r1 = r0.b;
        if (r1 == null) goto L14;
        CreationItem r2 = (CreationItem) CollectionsKt.firstOrNull(r1);
        if (r2 == null) goto L16;
        f r4 = this.a.b;
        if (r4 == null) goto L15;
        r4.a(r3, r2);
        return;
    L15:
        return;
    L16:
        return;
    L14:
        return;
    }

    @Override // com.larus.uaigc.chat.block.correction.n
    public final void a(CorrectionImageView r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        f r0 = this.a.b;
        if (r0 == null) goto L6;
        r0.b(r2, r3);
        return;
    }
}
