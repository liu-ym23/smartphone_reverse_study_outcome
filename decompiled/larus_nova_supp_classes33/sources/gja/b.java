package gja;

import com.obric.common.oea.foundation.animation.token.Token$Bounce;
import com.obric.common.oea.foundation.animation.token.Token$Delay;
import com.obric.common.oea.foundation.animation.token.Token$Duration;
import com.obric.common.oea.foundation.animation.token.Token$Easing;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class b {
    public static com.obric.common.oea.foundation.animation.spec.spring.b b(float r3, float r4) {
        return new com.obric.common.oea.foundation.animation.spec.spring.b(r3, r4, 0, 8);
    }

    public static com.obric.common.oea.foundation.animation.spec.spring.b c(Token$Bounce r3, Token$Duration r4) {
        Intrinsics.checkNotNullParameter(r3, "bounce");
        Intrinsics.checkNotNullParameter(r4, "duration");
        return new com.obric.common.oea.foundation.animation.spec.spring.b(r3.getDampingRatio(), r4.getStiffness(), 0, 8);
    }

    public static final com.obric.common.oea.foundation.animation.spec.spring.b a(Token$Bounce r2, Token$Duration r3, Token$Delay r4) {
        Intrinsics.checkNotNullParameter(r2, "bounce");
        Intrinsics.checkNotNullParameter(r3, "duration");
        Intrinsics.checkNotNullParameter(r4, "delay");
        return new com.obric.common.oea.foundation.animation.spec.spring.b(r2.getDampingRatio(), r3.getStiffness(), r4.getValue(), 8);
    }

    public static final hja.a d(Token$Duration r1, Token$Delay r2, Token$Easing r3) {
        Intrinsics.checkNotNullParameter(r1, "duration");
        Intrinsics.checkNotNullParameter(r2, "delay");
        Intrinsics.checkNotNullParameter(r3, "easing");
        return new hja.a(r1.getDuration(), r2.getValue(), r3);
    }
}
