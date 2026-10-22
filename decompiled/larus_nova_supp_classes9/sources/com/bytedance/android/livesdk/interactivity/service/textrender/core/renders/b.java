package com.bytedance.android.livesdk.interactivity.service.textrender.core.renders;

import android.text.SpannableString;
import com.bytedance.android.live.base.model.message.PieceType;
import com.bytedance.android.live.base.model.message.b5;
import com.bytedance.android.livesdk.interactivity.service.textrender.core.n;
import com.bytedance.android.livesdk.interactivity.service.textrender.core.p;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class b extends n {
    public static final b b = null;

    @Override // com.bytedance.android.livesdk.interactivity.service.textrender.core.n
    public final com.bytedance.android.livesdk.interactivity.service.textrender.core.b a(String r1, SpannableString r2, b5 r3, yb2.a r4, tb2.c r5, int r6, p r7) {
        Intrinsics.checkNotNullParameter(r1, "currentPieceStr");
        Intrinsics.checkNotNullParameter(r2, "spannable");
        Intrinsics.checkNotNullParameter(r4, "parseConfig");
        Intrinsics.checkNotNullParameter(r5, "renderPiece");
        return null;
    }

    static {
        b = new b();
    }

    public b() {
        super(PieceType.HEART);
    }
}
