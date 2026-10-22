package com.bytedance.android.livesdk.interactivity.service.textrender.core.renders;

import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import com.bytedance.android.live.base.model.message.PieceType;
import com.bytedance.android.live.base.model.message.b5;
import com.bytedance.android.live.base.model.message.m6;
import com.bytedance.android.livesdk.interactivity.service.textrender.core.n;
import com.bytedance.android.livesdk.interactivity.service.textrender.core.p;
import com.bytedance.android.livesdk.interactivity.service.textrender.core.r;
import com.bytedance.android.livesdk.interactivity.service.textrender.core.w;
import com.bytedance.android.livesdk.interactivity.service.textrender.core.x;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class e extends n {
    public static final e b = null;

    public static final class a implements tb2.e {
        public final /* synthetic */ m6 a;

        public a(m6 r1) {
            this.a = r1;
        }

        @Override // tb2.e
        public final m6 a() {
            return this.a;
        }
    }

    static {
        b = new e();
    }

    public e() {
        super(PieceType.STRING);
    }

    @Override // com.bytedance.android.livesdk.interactivity.service.textrender.core.n
    public final com.bytedance.android.livesdk.interactivity.service.textrender.core.b a(String r2, SpannableString r3, b5 r4, yb2.a r5, tb2.c r6, int r7, p r8) {
        Intrinsics.checkNotNullParameter(r2, "currentPieceStr");
        Intrinsics.checkNotNullParameter(r3, "spannable");
        Intrinsics.checkNotNullParameter(r5, "parseConfig");
        Intrinsics.checkNotNullParameter(r6, "renderPiece");
        int r9 = w.b(r6.getType(), r6.getFormat(), r4, r5);
        r3.setSpan(new ForegroundColorSpan(r9), r7, r2.length() + r7, 17);
        m6 r10 = r6.getConvertedSchema();
        m6 r11 = r6.getConvertedSchema();
        if (r11 == null) goto L5;
        String r13 = r11.a();
    L6:
        if (r10 == null) goto L9;
        if (r13 == null) goto L9;
        r6.setClickAction(new a(r10));
    L9:
        x r14 = r.b;
        int r15 = r2.length() + r7;
        r14.getClass();
        x.a(r3, r6, null, r7, r15);
        return null;
    L5:
        r13 = null;
        goto L6
    }
}
