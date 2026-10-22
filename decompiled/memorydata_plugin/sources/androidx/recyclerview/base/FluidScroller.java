package androidx.recyclerview.base;

import com.bytedance.bdinstall.oaid.OaidModel;
import com.bytedance.crash.entity.EventBody;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00112\u00020\u0001:\u0002\u0011\u0012B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\b\u001a\u00020\u0003J\u0016\u0010\t\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0003J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u0003H\u0002J\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\r\u001a\u00020\u0003J\u0010\u0010\u0010\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u0003H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0003X\u0082D¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Landroidx/recyclerview/base/FluidScroller;", "", "decelerateRate", "", "(F)V", "initialVelocity", "startValue", "threshold", "finalOffset", "fling", "", "velocity", "offsetAt", OaidModel.KEY_TIME, EventBody.KEY_VALUE, "Landroidx/recyclerview/base/FluidScroller$ScrollValue;", "velocityAt", "Companion", "ScrollValue", "OUIRecyclerViewX_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
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
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0006HÆ\u0003J'\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00062\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\n¨\u0006\u0016"}, d2 = {"Landroidx/recyclerview/base/FluidScroller$ScrollValue;", "", EventBody.KEY_VALUE, "", "velocity", "isFinished", "", "(FFZ)V", "()Z", "getValue", "()F", "getVelocity", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "", "OUIRecyclerViewX_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class ScrollValue {
        private final boolean isFinished;
        private final float value;
        private final float velocity;

        public ScrollValue(float r1, float r2, boolean r3) {
            this.value = r1;
            this.velocity = r2;
            this.isFinished = r3;
        }

        public static /* synthetic */ ScrollValue copy$default(ScrollValue r0, float r1, float r2, boolean r3, int r4, Object r5) {
            if ((r4 & 1) == 0) goto L6;
            r1 = r0.value;
        L6:
            if ((r4 & 2) == 0) goto L9;
            r2 = r0.velocity;
        L9:
            if ((r4 & 4) == 0) goto L12;
            r3 = r0.isFinished;
        L12:
            return r0.copy(r1, r2, r3);
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

        public final ScrollValue copy(float r1, float r2, boolean r3) {
            return new ScrollValue(r1, r2, r3);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, ScrollValue.class) == true) goto L8;
            return false;
        L8:
            ScrollValue r6 = (ScrollValue) ZeusTransformUtils.preCheckCast(r5, ScrollValue.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(Float.valueOf(this.value), Float.valueOf(r6.value)) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(Float.valueOf(this.velocity), Float.valueOf(r6.velocity)) == true) goto L15;
            return false;
        L15:
            if (this.isFinished == r6.isFinished) goto L17;
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
        /* JADX WARN: Type inference failed for: r0v5, types: [int] */
        /* JADX WARN: Type inference failed for: r2v2, types: [int] */
        /* JADX WARN: Type inference failed for: r2v3 */
        /* JADX WARN: Type inference failed for: r2v4 */
        public int hashCode() {
            int r0 = ((Float.hashCode(this.value) * 31) + Float.hashCode(this.velocity)) * 31;
            boolean r2 = this.isFinished;
            ?? r3 = r2;
            if (r2 == false) goto L6;
            r3 = 1;
        L6:
            return r0 + r3;
        }

        public final boolean isFinished() {
            return this.isFinished;
        }

        public String toString() {
            return "ScrollValue(value=" + this.value + ", velocity=" + this.velocity + ", isFinished=" + this.isFinished + ')';
        }
    }

    static {
        Companion = new Companion(null);
    }

    public FluidScroller() {
        this(0.0f, 1, null);
    }

    public FluidScroller(float r1) {
        this.decelerateRate = r1;
        this.threshold = 0.099999994f;
    }

    public /* synthetic */ FluidScroller(float r1, int r2, DefaultConstructorMarker r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = 0.998f;
    L5:
        this(r1);
    }

    private final float offsetAt(float r7) {
        return this.startValue + (((this.initialVelocity * (1.0f / ((float) Math.log(this.decelerateRate)))) * (((float) Math.pow(this.decelerateRate, r7)) - 1.0f)) * 1.1111112f);
    }

    private final float velocityAt(float r4) {
        return this.initialVelocity * ((float) Math.pow(this.decelerateRate, r4));
    }

    public final float finalOffset() {
        float r0 = Math.abs(this.initialVelocity);
        float r1 = this.threshold;
        if (r0 >= r1) goto L7;
        return 0.0f;
    L7:
        return offsetAt(((float) Math.log(r1 / Math.abs(this.initialVelocity))) / ((float) Math.log(this.decelerateRate)));
    }

    public final void fling(float r1, float r2) {
        this.startValue = r1;
        this.initialVelocity = r2;
    }

    public final ScrollValue value(float r4) {
        float r0 = velocityAt(r4);
        float r5 = offsetAt(r4);
        if (Math.abs(r0) >= this.threshold) goto L5;
        boolean r3 = true;
    L7:
        return new ScrollValue(r5, r0, r3);
    L5:
        r3 = false;
        goto L7
    }
}
