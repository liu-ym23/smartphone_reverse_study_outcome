package com.obric.common.oea.foundation.animation.spec;

import com.obric.common.oea.foundation.animation.token.Token;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u001e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007\u001a \u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\b\u001a$\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\u0006\u001a\u00020\b\u001a\u001e\u0010\f\u001a\u00020\r2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007\u001a \u0010\f\u001a\u00020\r2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\b\u001a \u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\u0006\u001a\u00020\b\u001a \u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\u0010\u001a\u00020\u0011\u001a \u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0004\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\b2\b\b\u0002\u0010\u0010\u001a\u00020\u0011\u001a \u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\u0010\u001a\u00020\u0011\u001a \u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0004\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\b2\b\b\u0002\u0010\u0010\u001a\u00020\u0011¨\u0006\u0014"}, d2 = {"spring", "Lcom/obric/common/oea/foundation/animation/spec/spring/FloatSpringSpec;", "bounce", "Lcom/obric/common/oea/foundation/animation/token/Token$Bounce;", "duration", "Lcom/obric/common/oea/foundation/animation/token/Token$Duration;", "delay", "Lcom/obric/common/oea/foundation/animation/token/Token$Delay;", "", "dampingRatio", "", "stiffness", "springInt", "Lcom/obric/common/oea/foundation/animation/spec/spring/IntSpringSpec;", "tween", "Lcom/obric/common/oea/foundation/animation/spec/tween/FloatTweenSpec;", "easing", "Lcom/obric/common/oea/foundation/animation/token/Token$Easing;", "tweenInt", "Lcom/obric/common/oea/foundation/animation/spec/tween/IntTweenSpec;", "foundation_standardRelease"}, k = 2, mv = {1, 4, 3})
public final class b {
    public static final com.obric.common.oea.foundation.animation.spec.a.a a(int r1, int r2, Token.Easing r3) {
        Intrinsics.checkNotNullParameter(r3, "easing");
        return new com.obric.common.oea.foundation.animation.spec.a.a(r1, r2, r3);
    }

    public static final com.obric.common.oea.foundation.animation.spec.a.a a(Token.Duration r1, Token.Delay r2, Token.Easing r3) {
        Intrinsics.checkNotNullParameter(r1, "duration");
        Intrinsics.checkNotNullParameter(r2, "delay");
        Intrinsics.checkNotNullParameter(r3, "easing");
        return new com.obric.common.oea.foundation.animation.spec.a.a(r1.getDuration(), r2.getValue(), r3);
    }

    public static final com.obric.common.oea.foundation.animation.spec.spring.b a(float r8, float r9, int r10) {
        return new com.obric.common.oea.foundation.animation.spec.spring.b(r8, r9, r10, 0.0f, 8, null);
    }

    public static /* synthetic */ com.obric.common.oea.foundation.animation.spec.spring.b a(float r0, float r1, int r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r0 = 1.0f;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r1 = 1500.0f;
    L9:
        if ((r3 & 4) == 0) goto L12;
        r2 = 0;
    L12:
        return a(r0, r1, r2);
    }

    public static final com.obric.common.oea.foundation.animation.spec.spring.b a(Token.Bounce r8, Token.Duration r9, int r10) {
        Intrinsics.checkNotNullParameter(r8, "bounce");
        Intrinsics.checkNotNullParameter(r9, "duration");
        return new com.obric.common.oea.foundation.animation.spec.spring.b(r8.getDampingRatio(), r9.getStiffness(), r10, 0.0f, 8, null);
    }

    public static /* synthetic */ com.obric.common.oea.foundation.animation.spec.spring.b a(Token.Bounce r0, Token.Duration r1, int r2, int r3, Object r4) {
        if ((r3 & 4) == 0) goto L6;
        r2 = 0;
    L6:
        return a(r0, r1, r2);
    }

    public static final com.obric.common.oea.foundation.animation.spec.spring.b a(Token.Bounce r8, Token.Duration r9, Token.Delay r10) {
        Intrinsics.checkNotNullParameter(r8, "bounce");
        Intrinsics.checkNotNullParameter(r9, "duration");
        Intrinsics.checkNotNullParameter(r10, "delay");
        return new com.obric.common.oea.foundation.animation.spec.spring.b(r8.getDampingRatio(), r9.getStiffness(), r10.getValue(), 0.0f, 8, null);
    }
}
