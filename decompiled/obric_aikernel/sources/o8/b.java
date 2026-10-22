package o8;

import com.obric.common.oea.foundation.animation.token.Token$Bounce;
import com.obric.common.oea.foundation.animation.token.Token$Duration;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class b {
    public static final com.obric.common.oea.foundation.animation.spec.spring.b a(Token$Bounce r10, Token$Duration r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "bounce");
        Intrinsics.checkNotNullParameter(r11, "duration");
        return new com.obric.common.oea.foundation.animation.spec.spring.b(r10.getDampingRatio(), r11.getStiffness(), r12, 0.0f, 8, null);
    }

    public static /* synthetic */ com.obric.common.oea.foundation.animation.spec.spring.b b(Token$Bounce r10, Token$Duration r11, int r12, int r13, Object r14) {
        if ((r13 & 4) == 0) goto L6;
        r12 = 0;
    L6:
        return a(r10, r11, r12);
    }
}
