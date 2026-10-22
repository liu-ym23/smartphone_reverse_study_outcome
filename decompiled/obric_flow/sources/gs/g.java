package gs;

import ai.j0;
import android.animation.TypeEvaluator;

/* JADX INFO: loaded from: classes3.dex */
public final class g implements TypeEvaluator {
    @Override // android.animation.TypeEvaluator
    public final Object evaluate(float r5, Object r10, Object r11) {
        c r12 = (c) r10;
        c r13 = (c) r11;
        float r14 = r12.f17177a;
        float r15 = j0.b(r13.f17177a, r14, r5, r14);
        float r16 = r12.f17178b;
        float r17 = j0.b(r13.f17178b, r16, r5, r16);
        c r18 = new c();
        r18.f17177a = r15;
        r18.f17178b = r17;
        return r18;
    }
}
