package com.obric.oui.sheet.v2;

import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0007\n\u0002\b\u0005\u0010\u0005\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "initialValue", "initialVelocity", "invoke", "(FF)F", "getTargetValue"}, k = 3, mv = {1, 4, 3})
final class SheetAnimStyle$calculateAndroidDecayTarget$1 extends Lambda implements Function2<Float, Float, Float> {
    final /* synthetic */ Ref.DoubleRef $effectAbsVelocityThreshold;
    final /* synthetic */ double $friction;

    SheetAnimStyle$calculateAndroidDecayTarget$1(Ref.DoubleRef r10, double r11) {
        this.$effectAbsVelocityThreshold = r10;
        this.$friction = r11;
        super(2);
    }

    public final float invoke(float r11, float r12) {
        double r10 = Math.abs(r12);
        double r13 = this.$effectAbsVelocityThreshold.element;
        if (r10 > r13) goto L5;
        return r11;
    L5:
        double r14 = r12;
        double r15 = Math.log(Math.abs(r13 / r14));
        double r16 = this.$friction;
        double r17 = 1000;
        return (float) ((((double) r11) - (r14 / r16)) + ((r14 / r16) * Math.exp((r16 * ((r15 / r16) * r17)) / r17)));
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Float invoke(Float r10, Float r11) {
        return Float.valueOf(invoke(r10.floatValue(), r11.floatValue()));
    }
}
