package kotlinx.serialization.internal;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.UIntArray;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0012\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002ø\u0001\u0000¢\u0006\u0002\u0010\u0004J\u001d\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0000ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011J\u0018\u0010\u0012\u001a\u00020\u0002H\u0010ø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0014J\u0015\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\bH\u0010¢\u0006\u0002\b\u0017R\u0019\u0010\u0005\u001a\u00020\u0002X\u0082\u000eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0006R\u001e\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b@RX\u0090\u000e¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bø\u0001\u0000\u0082\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0018"}, d2 = {"Lkotlinx/serialization/internal/UIntArrayBuilder;", "Lkotlinx/serialization/internal/PrimitiveArrayBuilder;", "Lkotlin/UIntArray;", "bufferWithData", "([ILkotlin/jvm/internal/DefaultConstructorMarker;)V", "buffer", "[I", "<set-?>", "", "position", "getPosition$kotlinx_serialization_core", "()I", "append", "", "c", "Lkotlin/UInt;", "append-WZ4Q5Ns$kotlinx_serialization_core", "(I)V", "build", "build--hP7Qyg$kotlinx_serialization_core", "()[I", "ensureCapacity", "requiredCapacity", "ensureCapacity$kotlinx_serialization_core", "kotlinx-serialization-core"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class cj extends bq<UIntArray> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int[] f17777a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f17778b;

    private cj(int[] r1) {
        this.f17777a = r1;
        this.f17778b = UIntArray.m1577getSizeimpl(r1);
        a(10);
    }

    public /* synthetic */ cj(int[] r1, DefaultConstructorMarker r2) {
        this(r1);
    }

    @Override // kotlinx.serialization.internal.bq
    public int a() {
        return this.f17778b;
    }

    @Override // kotlinx.serialization.internal.bq
    public void a(int r3) {
        if (UIntArray.m1577getSizeimpl(this.f17777a) >= r3) goto L6;
        int[] r0 = this.f17777a;
        int[] r4 = Arrays.copyOf(r0, RangesKt.coerceAtLeast(r3, UIntArray.m1577getSizeimpl(r0) * 2));
        Intrinsics.checkNotNullExpressionValue(r4, "copyOf(this, newSize)");
        this.f17777a = UIntArray.m1571constructorimpl(r4);
        return;
    }

    public final void b(int r5) {
        bq.a((bq) ZeusTransformUtils.preCheckCast(this, bq.class, "com.obric.memorydata.plugin"), 0, 1, null);
        int[] r0 = this.f17777a;
        int r1 = a();
        this.f17778b = r1 + 1;
        UIntArray.m1581setVXSXFK8(r0, r1, r5);
    }

    public int[] b() {
        int[] r1 = Arrays.copyOf(this.f17777a, a());
        Intrinsics.checkNotNullExpressionValue(r1, "copyOf(this, newSize)");
        return UIntArray.m1571constructorimpl(r1);
    }

    @Override // kotlinx.serialization.internal.bq
    public /* synthetic */ UIntArray c() {
        return UIntArray.m1569boximpl(b());
    }
}
