package w42;

import com.bytedance.android.live.base.model.message.ITextPieceImage;
import com.bytedance.android.live.base.model.message.PieceType;
import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.livesdk.interactivity.api.entity.f;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.rendprocessor.PublicScreenAutoTestUtil;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import py.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class d implements com.bytedance.android.livesdk.interactivity.api.publicscreen.rendprocessor.a {
    public d() {
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.rendprocessor.a
    public final void a(tb2.d r3, f<?> r4) {
        Intrinsics.checkNotNullParameter(r3, "text");
        Intrinsics.checkNotNullParameter(r4, "absTextMessage");
        if (PublicScreenAutoTestUtil.a == true) goto L5;
        return;
    L5:
        ((List) PublicScreenAutoTestUtil.b.getValue()).clear();
        Iterator<T> r5 = r3.a.iterator();
    L7:
        if (r5.hasNext() == false) goto L25;
        tb2.c r6 = (tb2.c) r5.next();
        if (r6.getType() != PieceType.IMAGE.getPieceType()) goto L7;
        if (r6.getConvertedSchema() == null) goto L7;
        boolean r0 = PublicScreenAutoTestUtil.a;
        ITextPieceImage r7 = r6.getImageValue();
        if (r7 == null) goto L19;
        k r8 = r7.getImageModel();
        if (r8 == null) goto L19;
        List r9 = r8.getUrls();
        if (r9 == null) goto L19;
        String r10 = (String) CollectionsKt.first(r9);
    L21:
        if (v.a() == false) goto L7;
        if (r10 == null) goto L7;
        ((List) PublicScreenAutoTestUtil.b.getValue()).add(r10);
    L19:
        r10 = null;
        goto L21
    }
}
