package com.bytedance.android.livesdk.interactivity.service.textrender.core.renders;

import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import com.bytedance.android.live.base.model.message.PieceType;
import com.bytedance.android.live.base.model.message.b5;
import com.bytedance.android.livesdk.interactivity.service.textrender.core.n;
import com.bytedance.android.livesdk.interactivity.service.textrender.core.p;
import com.bytedance.android.livesdk.interactivity.service.textrender.core.w;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class d extends n {
    public static final d b = null;

    static {
        b = new d();
    }

    public d() {
        super(PieceType.PATTERN_REF);
    }

    @Override // com.bytedance.android.livesdk.interactivity.service.textrender.core.n
    public final com.bytedance.android.livesdk.interactivity.service.textrender.core.b a(String r1, SpannableString r2, b5 r3, yb2.a r4, tb2.c r5, int r6, p r7) {
        Intrinsics.checkNotNullParameter(r1, "currentPieceStr");
        Intrinsics.checkNotNullParameter(r2, "spannable");
        Intrinsics.checkNotNullParameter(r4, "parseConfig");
        Intrinsics.checkNotNullParameter(r5, "renderPiece");
        int r8 = w.b(r5.getType(), r5.getFormat(), r3, r4);
        int r9 = r1.length() + r6;
        r2.setSpan(new ForegroundColorSpan(r8), r6, r9, 17);
        return null;
    }
}
