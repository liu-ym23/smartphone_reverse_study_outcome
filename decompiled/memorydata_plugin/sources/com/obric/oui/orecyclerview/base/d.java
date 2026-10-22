package com.obric.oui.orecyclerview.base;

import com.bytedance.bdinstall.oaid.OaidModel;
import com.bytedance.crash.entity.EventBody;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0011B\u0005¢\u0006\u0002\u0010\u0002J\u0016\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0004J\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0004J\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0004H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/obric/oui/orecyclerview/base/FluidSpringBack;", "", "()V", "c1", "", "c2", "lambda", "valueThreshold", "velocityThreshold", "absorb", "", "velocity", "initialValue", EventBody.KEY_VALUE, "Lcom/obric/oui/orecyclerview/base/FluidSpringBack$SpringBackValue;", OaidModel.KEY_TIME, "velocityAt", "SpringBackValue", "OUIRecyclerView_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private float f14039a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private float f14040b;
    private float c;
    private final float d;
    private final float e;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\r\u001a\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0013"}, d2 = {"Lcom/obric/oui/orecyclerview/base/FluidSpringBack$SpringBackValue;", "", EventBody.KEY_VALUE, "", "isFinished", "", "(FZ)V", "()Z", "getValue", "()F", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "", "OUIRecyclerView_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final float f14041a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean f14042b;

        public a(float r1, boolean r2) {
            this.f14041a = r1;
            this.f14042b = r2;
        }

        public final float a() {
            return this.f14041a;
        }

        public final boolean b() {
            return this.f14042b;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
            return false;
        L8:
            a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(Float.valueOf(this.f14041a), Float.valueOf(r6.f14041a)) == true) goto L12;
            return false;
        L12:
            if (this.f14042b == r6.f14042b) goto L14;
            return false;
        L14:
            return true;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v3, types: [int] */
        /* JADX WARN: Type inference failed for: r1v2, types: [int] */
        /* JADX WARN: Type inference failed for: r1v3 */
        /* JADX WARN: Type inference failed for: r1v4 */
        public int hashCode() {
            int r0 = Float.hashCode(this.f14041a) * 31;
            boolean r1 = this.f14042b;
            ?? r2 = r1;
            if (r1 == false) goto L6;
            r2 = 1;
        L6:
            return r0 + r2;
        }

        public String toString() {
            return "SpringBackValue(value=" + this.f14041a + ", isFinished=" + this.f14042b + ')';
        }
    }

    public d() {
        this.d = 0.1f;
        this.e = 0.01f;
    }

    private final float b(float r4) {
        float r0 = this.f14040b;
        float r1 = this.c;
        return (r0 - ((this.f14039a + (r0 * r4)) * r1)) * ((float) Math.exp((-r1) * r4));
    }

    public final a a(float r5) {
        float r6 = r5 / 1000.0f;
        float r1 = (this.f14039a + (this.f14040b * r6)) * ((float) Math.exp((-this.c) * r6));
        float r7 = b(r6);
        if (Math.abs(r1) >= this.d) goto L8;
        if ((Math.abs(r7) / 1000.0f) >= this.e) goto L8;
        return new a(0.0f, true);
    L8:
        return new a(r1, false);
    }

    public final void a(float r3, float r4) {
        this.c = 10.927279f;
        this.f14039a = r4;
        this.f14040b = (r3 * 1000.0f) + (10.927279f * r4);
    }
}
