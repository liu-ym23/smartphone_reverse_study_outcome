package androidx.recyclerview.base;

import androidx.constraintlayout.motion.widget.a;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00112\u00020\u0001:\u0002\u0011\u0012B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\b\u001a\u00020\u0003J\u0016\u0010\t\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0003J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u0003H\u0002J\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\r\u001a\u00020\u0003J\u0010\u0010\u0010\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u0003H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0003X\u0082D¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Landroidx/recyclerview/base/FluidScroller;", "", "decelerateRate", "", "(F)V", "initialVelocity", "startValue", "threshold", "finalOffset", "fling", "", "velocity", "offsetAt", "time", "value", "Landroidx/recyclerview/base/FluidScroller$ScrollValue;", "velocityAt", "Companion", "ScrollValue", "OUIRecyclerViewX_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FluidScroller {
    public static final Companion Companion = null;
    public static final float DECELERATION_RATE_FAST = 0.99f;
    public static final float DECELERATION_RATE_NORMAL = 0.998f;
    public static final float OFFSET_SCALE_FACTOR = 1.1111112f;
    private final float decelerateRate;
    private float initialVelocity;
    private float startValue;
    private final float threshold;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Landroidx/recyclerview/base/FluidScroller$Companion;", "", "()V", "DECELERATION_RATE_FAST", "", "DECELERATION_RATE_NORMAL", "OFFSET_SCALE_FACTOR", "OUIRecyclerViewX_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r5) {
            this();
        }

        private Companion() {
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0006HÆ\u0003J'\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00062\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\n¨\u0006\u0016"}, d2 = {"Landroidx/recyclerview/base/FluidScroller$ScrollValue;", "", "value", "", "velocity", "isFinished", "", "(FFZ)V", "()Z", "getValue", "()F", "getVelocity", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "", "OUIRecyclerViewX_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class ScrollValue {
        private final boolean isFinished;
        private final float value;
        private final float velocity;

        public ScrollValue(float r5, float r10, boolean r11) {
            this.value = r5;
            this.velocity = r10;
            this.isFinished = r11;
        }

        public static /* synthetic */ ScrollValue copy$default(ScrollValue r5, float r10, float r11, boolean r12, int r13, Object r14) {
            if ((r13 & 1) == 0) goto L6;
            r10 = r5.value;
        L6:
            if ((r13 & 2) == 0) goto L9;
            r11 = r5.velocity;
        L9:
            if ((r13 & 4) == 0) goto L12;
            r12 = r5.isFinished;
        L12:
            return r5.copy(r10, r11, r12);
        }

        public final float component1() {
            return this.value;
        }

        public final float component2() {
            return this.velocity;
        }

        public final boolean component3() {
            return this.isFinished;
        }

        public final ScrollValue copy(float r5, float r10, boolean r11) {
            return new ScrollValue(r5, r10, r11);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof ScrollValue) == true) goto L8;
            return false;
        L8:
            ScrollValue r10 = (ScrollValue) r5;
            if (Intrinsics.areEqual(Float.valueOf(this.value), Float.valueOf(r10.value)) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(Float.valueOf(this.velocity), Float.valueOf(r10.velocity)) == true) goto L15;
            return false;
        L15:
            if (this.isFinished == r10.isFinished) goto L17;
            return false;
        L17:
            return true;
        }

        public final float getValue() {
            return this.value;
        }

        public final float getVelocity() {
            return this.velocity;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v4, types: [int] */
        /* JADX WARN: Type inference failed for: r3v2, types: [int] */
        /* JADX WARN: Type inference failed for: r3v3 */
        /* JADX WARN: Type inference failed for: r3v4 */
        public int hashCode() {
            int r5 = Float.hashCode(this.value) * 31;
            int r10 = a.b(this.velocity, r5, 31);
            boolean r11 = this.isFinished;
            ?? r12 = r11;
            if (r11 == false) goto L6;
            r12 = 1;
        L6:
            return r10 + r12;
        }

        public final boolean isFinished() {
            return this.isFinished;
        }

        public String toString() {
            StringBuilder r5 = new StringBuilder("ScrollValue(value=");
            r5.append(this.value);
            r5.append(", velocity=");
            r5.append(this.velocity);
            r5.append(", isFinished=");
            return a.w(r5, this.isFinished, ')');
        }
    }

    static {
        Companion = new Companion(null);
    }

    public FluidScroller() {
        float r5 = 0.0f;
        this(r5, 1, null);
    }

    private final float offsetAt(float r10) {
        return (((((float) Math.pow(this.decelerateRate, r10)) - 1.0f) * ((1.0f / ((float) Math.log(this.decelerateRate))) * this.initialVelocity)) * 1.1111112f) + this.startValue;
    }

    private final float velocityAt(float r5) {
        return this.initialVelocity * ((float) Math.pow(this.decelerateRate, r5));
    }

    public final float finalOffset() {
        float r5 = Math.abs(this.initialVelocity);
        float r10 = this.threshold;
        if (r5 >= r10) goto L7;
        return 0.0f;
    L7:
        return offsetAt(((float) Math.log(r10 / Math.abs(this.initialVelocity))) / ((float) Math.log(this.decelerateRate)));
    }

    public final void fling(float r5, float r10) {
        this.startValue = r5;
        this.initialVelocity = r10;
    }

    public final ScrollValue value(float r5) {
        float r10 = velocityAt(r5);
        float r11 = offsetAt(r5);
        if (Math.abs(r10) >= this.threshold) goto L5;
        boolean r12 = true;
    L7:
        return new ScrollValue(r11, r10, r12);
    L5:
        r12 = false;
        goto L7
    }

    public FluidScroller(float r5) {
        this.decelerateRate = r5;
        this.threshold = 0.099999994f;
    }

    public /* synthetic */ FluidScroller(float r5, int r10, DefaultConstructorMarker r11) {
        if ((r10 & 1) == 0) goto L5;
        r5 = 0.998f;
    L5:
        this(r5);
    }
}
