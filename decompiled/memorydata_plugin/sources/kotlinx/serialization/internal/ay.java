package kotlinx.serialization.internal;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0016\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0002\u0010\u0004J\u0015\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0000¢\u0006\u0002\b\u000fJ\r\u0010\u0010\u001a\u00020\u0002H\u0010¢\u0006\u0002\b\u0011J\u0015\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u0007H\u0010¢\u0006\u0002\b\u0014R\u000e\u0010\u0005\u001a\u00020\u0002X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0007@RX\u0090\u000e¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lkotlinx/serialization/internal/LongArrayBuilder;", "Lkotlinx/serialization/internal/PrimitiveArrayBuilder;", "", "bufferWithData", "([J)V", "buffer", "<set-?>", "", "position", "getPosition$kotlinx_serialization_core", "()I", "append", "", "c", "", "append$kotlinx_serialization_core", "build", "build$kotlinx_serialization_core", "ensureCapacity", "requiredCapacity", "ensureCapacity$kotlinx_serialization_core", "kotlinx-serialization-core"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class ay extends bq<long[]> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long[] f17729a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f17730b;

    public ay(long[] r2) {
        Intrinsics.checkNotNullParameter(r2, "bufferWithData");
        this.f17729a = r2;
        this.f17730b = r2.length;
        a(10);
    }

    @Override // kotlinx.serialization.internal.bq
    public int a() {
        return this.f17730b;
    }

    @Override // kotlinx.serialization.internal.bq
    public void a(int r3) {
        long[] r0 = this.f17729a;
        if (r0.length >= r3) goto L6;
        long[] r4 = Arrays.copyOf(r0, RangesKt.coerceAtLeast(r3, r0.length * 2));
        Intrinsics.checkNotNullExpressionValue(r4, "copyOf(this, newSize)");
        this.f17729a = r4;
        return;
    }

    public final void a(long r5) {
        bq.a((bq) ZeusTransformUtils.preCheckCast(this, bq.class, "com.obric.memorydata.plugin"), 0, 1, null);
        long[] r0 = this.f17729a;
        int r1 = a();
        this.f17730b = r1 + 1;
        r0[r1] = r5;
    }

    public long[] b() {
        long[] r1 = Arrays.copyOf(this.f17729a, a());
        Intrinsics.checkNotNullExpressionValue(r1, "copyOf(this, newSize)");
        return r1;
    }

    @Override // kotlinx.serialization.internal.bq
    public /* synthetic */ long[] c() {
        return b();
    }
}
