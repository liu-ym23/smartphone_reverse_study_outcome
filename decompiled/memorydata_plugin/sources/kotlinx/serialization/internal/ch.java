package kotlinx.serialization.internal;

import com.obric.aikernel.sdk.ext.Params;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.UByte;
import kotlin.UByteArray;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\bÁ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u0014\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\u0003B\u0007\b\u0002¢\u0006\u0002\u0010\u0006J\u0018\u0010\u0007\u001a\u00020\u0002H\u0014ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b\b\u0010\tJ(\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0012H\u0014J-\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u000fH\u0014ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u0019\u0010\u001a\u001a\u00020\u000f*\u00020\u0002H\u0014ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u0019\u0010\u001d\u001a\u00020\u0005*\u00020\u0002H\u0014ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b\u001e\u0010\u001fø\u0001\u0002\u0082\u0002\u000f\n\u0002\b!\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006 "}, d2 = {"Lkotlinx/serialization/internal/UByteArraySerializer;", "Lkotlinx/serialization/KSerializer;", "Lkotlin/UByteArray;", "Lkotlinx/serialization/internal/PrimitiveArraySerializer;", "Lkotlin/UByte;", "Lkotlinx/serialization/internal/UByteArrayBuilder;", "()V", "empty", "empty-TcUX1vc", "()[B", "readElement", "", "decoder", "Lkotlinx/serialization/encoding/CompositeDecoder;", "index", "", "builder", "checkIndex", "", "writeContent", "encoder", "Lkotlinx/serialization/encoding/CompositeEncoder;", Params.CONTENT, "size", "writeContent-Coi6ktg", "(Lkotlinx/serialization/encoding/CompositeEncoder;[BI)V", "collectionSize", "collectionSize-GBYM_sE", "([B)I", "toBuilder", "toBuilder-GBYM_sE", "([B)Lkotlinx/serialization/internal/UByteArrayBuilder;", "kotlinx-serialization-core"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class ch extends bs<UByte, UByteArray, cg> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ch f17774a = null;

    static {
        f17774a = new ch();
    }

    private ch() {
        super(kotlinx.serialization.a.a.a(UByte.Companion));
    }

    public cg a(byte[] r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$toBuilder");
        return new cg(r2, null);
    }

    @Override // kotlinx.serialization.internal.u, kotlinx.serialization.internal.a
    public /* synthetic */ void a(kotlinx.serialization.b.b r3, int r4, Object r5, boolean r6) {
        a((kotlinx.serialization.b.b) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.serialization.b.b.class, "com.obric.memorydata.plugin"), r4, (cg) ZeusTransformUtils.preCheckCast(r5, cg.class, "com.obric.memorydata.plugin"), r6);
    }

    public void a(kotlinx.serialization.b.b r2, int r3, cg r4, boolean r5) {
        kotlinx.serialization.b.b r6 = (kotlinx.serialization.b.b) ZeusTransformUtils.wrapperContextForParams(r2, kotlinx.serialization.b.b.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "decoder");
        Intrinsics.checkNotNullParameter(r4, "builder");
        r4.a(UByte.m1439constructorimpl(r6.j(a(), r3).e()));
    }

    @Override // kotlinx.serialization.internal.a
    public /* synthetic */ Object c(Object r3) {
        return a(((UByteArray) ZeusTransformUtils.preCheckCast(r3, UByteArray.class, "com.obric.memorydata.plugin")).m1506unboximpl());
    }

    public byte[] c() {
        return UByteArray.m1491constructorimpl(0);
    }

    @Override // kotlinx.serialization.internal.bs
    public /* synthetic */ UByteArray d() {
        return UByteArray.m1490boximpl(c());
    }
}
