package com.bytedance.android.live.liveinteract.videotalk.quickinteract.interactView;

import com.bytedance.android.live.base.model.message.ITextPieceImage;
import com.bytedance.android.live.base.model.message.c5;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.interactivity.service.textrender.core.r;
import com.bytedance.android.livesdk.interactivity.service.textrender.core.y;
import com.bytedance.android.livesdkapi.message.Text;
import java.util.Iterator;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class d {
    public static final void a(Text r5, Function2 r6) {
        Intrinsics.checkNotNullParameter(r5, "it");
        Intrinsics.checkNotNullParameter(r6, "cb");
        Iterator r0 = r5.getPieces().iterator();
    L4:
        if (r0.hasNext() == false) goto L11;
        c5 r1 = (c5) r0.next();
        ITextPieceImage r2 = r1.getImageValue();
        if (r2 == null) goto L8;
        r2.setWidth(s1.f(10.0f));
    L8:
        ITextPieceImage r3 = r1.getImageValue();
        if (r3 == null) goto L4;
        r3.setHeight(s1.f(10.0f));
        goto L4
    L11:
        com.bytedance.android.livesdk.interactivity.service.textrender.core.f.a.getClass();
        r.g.d(r5, null, new y(0.0f), new c(r6));
    }
}
