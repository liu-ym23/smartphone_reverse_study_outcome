package com.obric.common.oea.foundation.animation.token;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0003\u001a\u00020\u0004*\u00020\u0002¨\u0006\u0005"}, d2 = {"toCubicBezierEasing", "Lcom/obric/common/oea/foundation/animation/token/CubicBezierEasing;", "Lcom/obric/common/oea/foundation/animation/token/Token$Easing;", "toLinearEasing", "Lcom/obric/common/oea/foundation/animation/token/Easing;", "foundation_standardRelease"}, k = 2, mv = {1, 4, 3})
public final class d {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "fraction", "transform"}, k = 3, mv = {1, 4, 3})
    static final class a implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f7727a = null;

        static {
            f7727a = new a();
        }

        a() {
        }

        @Override // com.obric.common.oea.foundation.animation.token.b
        public final float a(float r1) {
            return r1;
        }
    }

    public static final com.obric.common.oea.foundation.animation.token.a a(Token.Easing r5) {
        Intrinsics.checkNotNullParameter(r5, "$this$toCubicBezierEasing");
        if (r5.getValues().length != 4) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L10;
        return new com.obric.common.oea.foundation.animation.token.a(r5.getValues()[0], r5.getValues()[1], r5.getValues()[2], r5.getValues()[3]);
    L10:
        throw new IllegalArgumentException("Easing values must contain exactly 4 floats for cubic bezier.".toString());
    L5:
        r0 = false;
        goto L6
    }

    public static final b b(Token.Easing r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$toLinearEasing");
        return (b) ZeusTransformUtils.preCheckCast(a.f7727a, b.class, "com.obric.memorydata.plugin");
    }
}
