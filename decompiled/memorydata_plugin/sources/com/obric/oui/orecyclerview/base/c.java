package com.obric.oui.orecyclerview.base;

import com.bytedance.bdinstall.oaid.OaidModel;
import com.bytedance.crash.entity.EventBody;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00112\u00020\u0001:\u0002\u0011\u0012B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\b\u001a\u00020\u0003J\u0016\u0010\t\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0003J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u0003H\u0002J\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\r\u001a\u00020\u0003J\u0010\u0010\u0010\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u0003H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0003X\u0082D¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/obric/oui/orecyclerview/base/FluidScroller;", "", "decelerateRate", "", "(F)V", "initialVelocity", "startValue", "threshold", "finalOffset", "fling", "", "velocity", "offsetAt", OaidModel.KEY_TIME, EventBody.KEY_VALUE, "Lcom/obric/oui/orecyclerview/base/FluidScroller$ScrollValue;", "velocityAt", "Companion", "ScrollValue", "OUIRecyclerView_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f14035a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final float f14036b;
    private float c;
    private float d;
    private final float e;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/obric/oui/orecyclerview/base/FluidScroller$Companion;", "", "()V", "DECELERATION_RATE_FAST", "", "DECELERATION_RATE_NORMAL", "OFFSET_SCALE_FACTOR", "OUIRecyclerView_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0006HÆ\u0003J'\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00062\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\n¨\u0006\u0016"}, d2 = {"Lcom/obric/oui/orecyclerview/base/FluidScroller$ScrollValue;", "", EventBody.KEY_VALUE, "", "velocity", "isFinished", "", "(FFZ)V", "()Z", "getValue", "()F", "getVelocity", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "", "OUIRecyclerView_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final float f14037a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final float f14038b;
        private final boolean c;

        public b(float r1, float r2, boolean r3) {
            this.f14037a = r1;
            this.f14038b = r2;
            this.c = r3;
        }

        public final float a() {
            return this.f14037a;
        }

        public final float b() {
            return this.f14038b;
        }

        public final boolean c() {
            return this.c;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
            return false;
        L8:
            b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(Float.valueOf(this.f14037a), Float.valueOf(r6.f14037a)) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(Float.valueOf(this.f14038b), Float.valueOf(r6.f14038b)) == true) goto L15;
            return false;
        L15:
            if (this.c == r6.c) goto L17;
            return false;
        L17:
            return true;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v5, types: [int] */
        /* JADX WARN: Type inference failed for: r2v2, types: [int] */
        /* JADX WARN: Type inference failed for: r2v3 */
        /* JADX WARN: Type inference failed for: r2v4 */
        public int hashCode() {
            int r0 = ((Float.hashCode(this.f14037a) * 31) + Float.hashCode(this.f14038b)) * 31;
            boolean r2 = this.c;
            ?? r3 = r2;
            if (r2 == false) goto L6;
            r3 = 1;
        L6:
            return r0 + r3;
        }

        public String toString() {
            return "ScrollValue(value=" + this.f14037a + ", velocity=" + this.f14038b + ", isFinished=" + this.c + ')';
        }
    }

    static {
        f14035a = new a(null);
    }

    public c() {
        this(0.0f, 1, null);
    }

    public c(float r1) {
        this.f14036b = r1;
        this.e = 0.099999994f;
    }

    public /* synthetic */ c(float r1, int r2, DefaultConstructorMarker r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = 0.998f;
    L5:
        this(r1);
    }

    private final float b(float r4) {
        return this.d * ((float) Math.pow(this.f14036b, r4));
    }

    private final float c(float r7) {
        return this.c + (((this.d * (1.0f / ((float) Math.log(this.f14036b)))) * (((float) Math.pow(this.f14036b, r7)) - 1.0f)) * 1.1111112f);
    }

    public final float a() {
        float r0 = Math.abs(this.d);
        float r1 = this.e;
        if (r0 >= r1) goto L7;
        return 0.0f;
    L7:
        return c(((float) Math.log(r1 / Math.abs(this.d))) / ((float) Math.log(this.f14036b)));
    }

    public final b a(float r4) {
        float r0 = b(r4);
        float r5 = c(r4);
        if (Math.abs(r0) >= this.e) goto L5;
        boolean r3 = true;
    L7:
        return new b(r5, r0, r3);
    L5:
        r3 = false;
        goto L7
    }

    public final void a(float r1, float r2) {
        this.c = r1;
        this.d = r2;
    }
}
