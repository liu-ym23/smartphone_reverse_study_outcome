package com.obric.common.oea.foundation.animation.token;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004J\u000e\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\fJ\u000e\u0010\r\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\fJ\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011J\u000e\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u0014J\u000e\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018J\u000e\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u0014J\u000e\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u0004¨\u0006\u001c"}, d2 = {"Lcom/obric/common/oea/foundation/animation/token/TokenUtil;", "", "()V", "bounceToDampingRatio", "", "bounce", "dampingRatioToBounce", "dampingRatio", "durationToStiffness", "duration", "getBounceByToken", "bounceEnum", "Lcom/obric/common/oea/foundation/animation/token/Token$Bounce;", "getDampingRatioByToken", "getDelayByToken", "", "delay", "Lcom/obric/common/oea/foundation/animation/token/Token$Delay;", "getDurationByToken", "durationEnum", "Lcom/obric/common/oea/foundation/animation/token/Token$Duration;", "getInterpolator", "Landroid/animation/TimeInterpolator;", "easing", "Lcom/obric/common/oea/foundation/animation/token/Token$Easing;", "getStiffnessByToken", "stiffnessToDuration", "stiffness", "foundation_standardRelease"}, k = 1, mv = {1, 4, 3})
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f7728a = null;

    static {
        f7728a = new e();
    }

    private e() {
    }

    public final float a(float r3) {
        if (r3 == 0.0f) goto L7;
        return (float) Math.pow(6.2831855f / r3, 2.0f);
    L7:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new IllegalArgumentException("Duration cannot be zero."), Throwable.class, "com.obric.memorydata.plugin"));
    }
}
