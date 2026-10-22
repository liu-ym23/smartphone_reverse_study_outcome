package androidx.recyclerview.base;

import androidx.constraintlayout.motion.widget.a;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0011B\u0005¢\u0006\u0002\u0010\u0002J\u0016\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0004J\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0004J\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0004H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Landroidx/recyclerview/base/FluidSpringBack;", "", "()V", "c1", "", "c2", "lambda", "valueThreshold", "velocityThreshold", "absorb", "", "velocity", "initialValue", "value", "Landroidx/recyclerview/base/FluidSpringBack$SpringBackValue;", "time", "velocityAt", "SpringBackValue", "OUIRecyclerViewX_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FluidSpringBack {

    /* JADX INFO: renamed from: c1, reason: collision with root package name */
    private float f565c1;

    /* JADX INFO: renamed from: c2, reason: collision with root package name */
    private float f566c2;
    private float lambda;
    private final float valueThreshold;
    private final float velocityThreshold;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\r\u001a\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0013"}, d2 = {"Landroidx/recyclerview/base/FluidSpringBack$SpringBackValue;", "", "value", "", "isFinished", "", "(FZ)V", "()Z", "getValue", "()F", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "", "OUIRecyclerViewX_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class SpringBackValue {
        private final boolean isFinished;
        private final float value;

        public SpringBackValue(float r5, boolean r10) {
            this.value = r5;
            this.isFinished = r10;
        }

        public static /* synthetic */ SpringBackValue copy$default(SpringBackValue r5, float r10, boolean r11, int r12, Object r13) {
            if ((r12 & 1) == 0) goto L6;
            r10 = r5.value;
        L6:
            if ((r12 & 2) == 0) goto L9;
            r11 = r5.isFinished;
        L9:
            return r5.copy(r10, r11);
        }

        public final float component1() {
            return this.value;
        }

        public final boolean component2() {
            return this.isFinished;
        }

        public final SpringBackValue copy(float r5, boolean r10) {
            return new SpringBackValue(r5, r10);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof SpringBackValue) == true) goto L8;
            return false;
        L8:
            SpringBackValue r10 = (SpringBackValue) r5;
            if (Intrinsics.areEqual(Float.valueOf(this.value), Float.valueOf(r10.value)) == true) goto L12;
            return false;
        L12:
            if (this.isFinished == r10.isFinished) goto L14;
            return false;
        L14:
            return true;
        }

        public final float getValue() {
            return this.value;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v3, types: [int] */
        /* JADX WARN: Type inference failed for: r1v2, types: [int] */
        /* JADX WARN: Type inference failed for: r1v3 */
        /* JADX WARN: Type inference failed for: r1v4 */
        public int hashCode() {
            int r5 = Float.hashCode(this.value) * 31;
            boolean r10 = this.isFinished;
            ?? r11 = r10;
            if (r10 == false) goto L6;
            r11 = 1;
        L6:
            return r5 + r11;
        }

        public final boolean isFinished() {
            return this.isFinished;
        }

        public String toString() {
            StringBuilder r5 = new StringBuilder("SpringBackValue(value=");
            r5.append(this.value);
            r5.append(", isFinished=");
            return a.w(r5, this.isFinished, ')');
        }
    }

    public FluidSpringBack() {
        this.valueThreshold = 0.1f;
        this.velocityThreshold = 0.01f;
    }

    private final float velocityAt(float r5) {
        float r10 = this.f566c2;
        float r11 = this.lambda;
        return (r10 - (((r10 * r5) + this.f565c1) * r11)) * ((float) Math.exp((-r11) * r5));
    }

    public final void absorb(float r5, float r10) {
        this.lambda = 10.927279f;
        this.f565c1 = r10;
        float r11 = 10.927279f * r10;
        this.f566c2 = r11 + (r5 * 1000.0f);
    }

    public final SpringBackValue value(float r10) {
        float r11 = r10 / 1000.0f;
        float r5 = ((this.f566c2 * r11) + this.f565c1) * ((float) Math.exp((-this.lambda) * r11));
        float r12 = velocityAt(r11);
        if (Math.abs(r5) >= this.valueThreshold) goto L8;
        if ((Math.abs(r12) / 1000.0f) >= this.velocityThreshold) goto L8;
        return new SpringBackValue(0.0f, true);
    L8:
        return new SpringBackValue(r5, false);
    }
}
