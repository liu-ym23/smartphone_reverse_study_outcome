package kotlinx.coroutines.internal;

import com.bytedance.crash.entity.EventBody;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.internal.ag;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0081@\u0018\u0000*\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u00022\u00020\u0003B\u0011\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u001a\u0010\u0010\u001a\u00020\b2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u0015HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\u0019HÖ\u0001¢\u0006\u0004\b\u001a\u0010\u001bR\u0011\u0010\u0007\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0017\u0010\u000b\u001a\u00028\u00008F¢\u0006\f\u0012\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0088\u0001\u0004\u0092\u0001\u0004\u0018\u00010\u0003¨\u0006\u001c"}, d2 = {"Lkotlinx/coroutines/internal/SegmentOrClosed;", "S", "Lkotlinx/coroutines/internal/Segment;", "", EventBody.KEY_VALUE, "constructor-impl", "(Ljava/lang/Object;)Ljava/lang/Object;", "isClosed", "", "isClosed-impl", "(Ljava/lang/Object;)Z", "segment", "getSegment$annotations", "()V", "getSegment-impl", "(Ljava/lang/Object;)Lkotlinx/coroutines/internal/Segment;", "equals", "other", "equals-impl", "(Ljava/lang/Object;Ljava/lang/Object;)Z", "hashCode", "", "hashCode-impl", "(Ljava/lang/Object;)I", "toString", "", "toString-impl", "(Ljava/lang/Object;)Ljava/lang/String;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 9, 0}, xi = 48)
@JvmInline
public final class ah<S extends ag<S>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Object f17559a;

    public static final boolean a(Object r1) {
        if (r1 != e.a()) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean a(Object r3, Object r4) {
        if (ZeusTransformUtils.instanceOf(r4, ah.class) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(r3, ((ah) ZeusTransformUtils.preCheckCast(r4, ah.class, "com.obric.memorydata.plugin")).a()) == true) goto L8;
        return false;
    L8:
        return true;
    }

    public static final S b(Object r2) {
        if (r2 == e.a()) goto L7;
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type S of kotlinx.coroutines.internal.SegmentOrClosed");
        return (S) ZeusTransformUtils.preCheckCast(r2, ag.class, "com.obric.memorydata.plugin");
    L7:
        throw new IllegalStateException("Does not contain segment".toString());
    }

    public static String c(Object r2) {
        return "SegmentOrClosed(value=" + r2 + ')';
    }

    public static int d(Object r0) {
        if (r0 != null) goto L5;
        return 0;
    L5:
        return r0.hashCode();
    }

    public static <S extends ag<S>> Object e(Object r0) {
        return r0;
    }

    public final /* synthetic */ Object a() {
        return this.f17559a;
    }

    public boolean equals(Object r1) {
        return a(this.f17559a, r1);
    }

    public int hashCode() {
        return d(this.f17559a);
    }

    public String toString() {
        return c(this.f17559a);
    }
}
