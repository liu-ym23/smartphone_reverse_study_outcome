package com.bytedance.android.livesdk.interactivity.service.textrender.core.renders;

import android.text.SpannableString;
import com.bytedance.android.live.base.model.message.PieceType;
import com.bytedance.android.live.base.model.message.b5;
import com.bytedance.android.livesdk.interactivity.service.textrender.core.n;
import com.bytedance.android.livesdk.interactivity.service.textrender.core.p;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class f extends n {
    public static final f b = null;

    static {
        b = new f();
    }

    public f() {
        super(PieceType.UNKNOWN);
    }

    @Override // com.bytedance.android.livesdk.interactivity.service.textrender.core.n
    public final com.bytedance.android.livesdk.interactivity.service.textrender.core.b a(String r1, SpannableString r2, b5 r3, yb2.a r4, tb2.c r5, int r6, p r7) {
        Intrinsics.checkNotNullParameter(r1, "currentPieceStr");
        Intrinsics.checkNotNullParameter(r2, "spannable");
        Intrinsics.checkNotNullParameter(r4, "parseConfig");
        Intrinsics.checkNotNullParameter(r5, "renderPiece");
        if (com.bytedance.android.livesdk.interactivity.service.textrender.utils.b.b == false) goto L9;
        pm0.a r8 = om0.c.c();
        if (r8 == null) goto L10;
        r8.i("ttlive_render_engine", "got unknown piece: " + r5);
        return null;
    L10:
        return null;
    L9:
        return null;
    }
}
