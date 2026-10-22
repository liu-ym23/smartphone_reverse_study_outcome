package kotlinx.serialization.internal;

import com.obric.aikernel.sdk.ext.Params;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.ShortCompanionObject;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0017\n\u0002\u0018\u0002\n\u0002\u0010\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÁ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u0014\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\u0003B\u0007\b\u0002¢\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\u0002H\u0014J(\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0010H\u0014J \u0010\u0011\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\rH\u0014J\f\u0010\u0016\u001a\u00020\r*\u00020\u0002H\u0014J\f\u0010\u0017\u001a\u00020\u0005*\u00020\u0002H\u0014¨\u0006\u0018"}, d2 = {"Lkotlinx/serialization/internal/ShortArraySerializer;", "Lkotlinx/serialization/KSerializer;", "", "Lkotlinx/serialization/internal/PrimitiveArraySerializer;", "", "Lkotlinx/serialization/internal/ShortArrayBuilder;", "()V", "empty", "readElement", "", "decoder", "Lkotlinx/serialization/encoding/CompositeDecoder;", "index", "", "builder", "checkIndex", "", "writeContent", "encoder", "Lkotlinx/serialization/encoding/CompositeEncoder;", Params.CONTENT, "size", "collectionSize", "toBuilder", "kotlinx-serialization-core"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class bz extends bs<Short, short[], by> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final bz f17762a = null;

    static {
        f17762a = new bz();
    }

    private bz() {
        super(kotlinx.serialization.a.a.a(ShortCompanionObject.INSTANCE));
    }

    public by a(short[] r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return new by(r1);
    }

    @Override // kotlinx.serialization.internal.u, kotlinx.serialization.internal.a
    public /* synthetic */ void a(kotlinx.serialization.b.b r3, int r4, Object r5, boolean r6) {
        a((kotlinx.serialization.b.b) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.serialization.b.b.class, "com.obric.memorydata.plugin"), r4, (by) ZeusTransformUtils.preCheckCast(r5, by.class, "com.obric.memorydata.plugin"), r6);
    }

    public void a(kotlinx.serialization.b.b r2, int r3, by r4, boolean r5) {
        kotlinx.serialization.b.b r6 = (kotlinx.serialization.b.b) ZeusTransformUtils.wrapperContextForParams(r2, kotlinx.serialization.b.b.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "decoder");
        Intrinsics.checkNotNullParameter(r4, "builder");
        r4.a(r6.c(a(), r3));
    }

    @Override // kotlinx.serialization.internal.a
    public /* synthetic */ Object c(Object r3) {
        return a((short[]) ZeusTransformUtils.preCheckCast(r3, short[].class, "com.obric.memorydata.plugin"));
    }

    public short[] c() {
        return new short[0];
    }

    @Override // kotlinx.serialization.internal.bs
    public /* synthetic */ short[] d() {
        return c();
    }
}
