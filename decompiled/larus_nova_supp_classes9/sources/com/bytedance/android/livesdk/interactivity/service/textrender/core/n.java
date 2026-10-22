package com.bytedance.android.livesdk.interactivity.service.textrender.core;

import android.text.SpannableString;
import com.bytedance.android.live.base.model.message.PieceType;
import com.bytedance.android.live.base.model.message.b5;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public abstract class n {
    public final PieceType a;

    public abstract b a(String r1, SpannableString r2, b5 r3, yb2.a r4, tb2.c r5, int r6, p r7);

    public n(PieceType r2) {
        Intrinsics.checkNotNullParameter(r2, "pieceType");
        this.a = r2;
    }
}
