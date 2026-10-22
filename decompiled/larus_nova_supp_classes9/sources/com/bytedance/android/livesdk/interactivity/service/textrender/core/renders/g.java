package com.bytedance.android.livesdk.interactivity.service.textrender.core.renders;

import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import com.bytedance.android.live.base.model.message.PieceType;
import com.bytedance.android.live.base.model.message.b5;
import com.bytedance.android.live.base.model.message.i5;
import com.bytedance.android.live.base.model.message.m6;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.livesdk.interactivity.service.textrender.core.n;
import com.bytedance.android.livesdk.interactivity.service.textrender.core.p;
import com.bytedance.android.livesdk.interactivity.service.textrender.core.r;
import com.bytedance.android.livesdk.interactivity.service.textrender.core.w;
import com.bytedance.android.livesdk.interactivity.service.textrender.core.x;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class g extends n {
    public static final g b = null;

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

    public static final class b implements tb2.g {
        public final /* synthetic */ IBaseUser a;

        public b(IBaseUser r1) {
            this.a = r1;
        }

        @Override // tb2.g
        public final IBaseUser getUser() {
            return this.a;
        }
    }

    static {
        b = new g();
    }

    public g() {
        super(PieceType.USER);
    }

    @Override // com.bytedance.android.livesdk.interactivity.service.textrender.core.n
    public final com.bytedance.android.livesdk.interactivity.service.textrender.core.b a(String r2, SpannableString r3, b5 r4, yb2.a r5, tb2.c r6, int r7, p r8) {
        Intrinsics.checkNotNullParameter(r2, "currentPieceStr");
        Intrinsics.checkNotNullParameter(r3, "spannable");
        Intrinsics.checkNotNullParameter(r5, "parseConfig");
        Intrinsics.checkNotNullParameter(r6, "renderPiece");
        int r9 = w.b(r6.getType(), r6.getFormat(), r4, r5);
        int r10 = r2.length() + r7;
        r3.setSpan(new ForegroundColorSpan(r9), r7, r10, 17);
        if (r6.getClickAction() != null) goto L13;
        m6 r11 = r6.getConvertedSchema();
        if (r11 != null) goto L7;
    L8:
        i5 r13 = r6.getUserValue();
        if (r13 == null) goto L13;
        IBaseUser r14 = r13.getUser();
        if (r14 == null) goto L13;
        r6.setClickAction(new b(r14));
        goto L13
    L7:
        if (r6.setClickAction(new a(r11)) == null) goto L8;
    L13:
        x r15 = r.b;
        int r16 = r2.length() + r7;
        r15.getClass();
        x.a(r3, r6, null, r7, r16);
        return null;
    }
}
