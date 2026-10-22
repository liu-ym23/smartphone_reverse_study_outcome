package kotlinx.serialization.internal;

import com.bytedance.crash.entity.EventBody;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010(\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u0002*\u0004\b\u0002\u0010\u00032\b\u0012\u0004\u0012\u0002H\u00020\u0004B\u0007\b\u0004¢\u0006\u0002\u0010\u0005J\r\u0010\u0006\u001a\u00028\u0002H$¢\u0006\u0002\u0010\u0007J\u0015\u0010\b\u001a\u00028\u00012\u0006\u0010\t\u001a\u00020\nH\u0016¢\u0006\u0002\u0010\u000bJ\u001f\u0010\f\u001a\u00028\u00012\u0006\u0010\t\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00018\u0001H\u0007¢\u0006\u0002\u0010\u000eJ-\u0010\u000f\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u00112\u0006\u0010\u0006\u001a\u00028\u00022\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0013H$¢\u0006\u0002\u0010\u0015J/\u0010\u0016\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0006\u001a\u00028\u00022\b\b\u0002\u0010\u0018\u001a\u00020\u0019H$¢\u0006\u0002\u0010\u001aJ\u001d\u0010\u001b\u001a\u00020\u00132\u0006\u0010\t\u001a\u00020\u00112\u0006\u0010\u0006\u001a\u00028\u0002H\u0002¢\u0006\u0002\u0010\u001cJ\u001d\u0010\u001d\u001a\u00020\u00102\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00028\u0001H&¢\u0006\u0002\u0010!J\u0011\u0010\"\u001a\u00020\u0013*\u00028\u0002H$¢\u0006\u0002\u0010#J\u0019\u0010$\u001a\u00020\u0010*\u00028\u00022\u0006\u0010\u0014\u001a\u00020\u0013H$¢\u0006\u0002\u0010%J\u0017\u0010&\u001a\b\u0012\u0004\u0012\u00028\u00000'*\u00028\u0001H$¢\u0006\u0002\u0010(J\u0011\u0010)\u001a\u00020\u0013*\u00028\u0001H$¢\u0006\u0002\u0010#J\u0011\u0010*\u001a\u00028\u0002*\u00028\u0001H$¢\u0006\u0002\u0010+J\u0011\u0010,\u001a\u00028\u0001*\u00028\u0002H$¢\u0006\u0002\u0010+\u0082\u0001\u0002-.¨\u0006/"}, d2 = {"Lkotlinx/serialization/internal/AbstractCollectionSerializer;", "Element", "Collection", "Builder", "Lkotlinx/serialization/KSerializer;", "()V", "builder", "()Ljava/lang/Object;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "(Lkotlinx/serialization/encoding/Decoder;)Ljava/lang/Object;", "merge", "previous", "(Lkotlinx/serialization/encoding/Decoder;Ljava/lang/Object;)Ljava/lang/Object;", "readAll", "", "Lkotlinx/serialization/encoding/CompositeDecoder;", "startIndex", "", "size", "(Lkotlinx/serialization/encoding/CompositeDecoder;Ljava/lang/Object;II)V", "readElement", "index", "checkIndex", "", "(Lkotlinx/serialization/encoding/CompositeDecoder;ILjava/lang/Object;Z)V", "readSize", "(Lkotlinx/serialization/encoding/CompositeDecoder;Ljava/lang/Object;)I", "serialize", "encoder", "Lkotlinx/serialization/encoding/Encoder;", EventBody.KEY_VALUE, "(Lkotlinx/serialization/encoding/Encoder;Ljava/lang/Object;)V", "builderSize", "(Ljava/lang/Object;)I", "checkCapacity", "(Ljava/lang/Object;I)V", "collectionIterator", "", "(Ljava/lang/Object;)Ljava/util/Iterator;", "collectionSize", "toBuilder", "(Ljava/lang/Object;)Ljava/lang/Object;", "toResult", "Lkotlinx/serialization/internal/CollectionLikeSerializer;", "Lkotlinx/serialization/internal/MapLikeSerializer;", "kotlinx-serialization-core"}, k = 1, mv = {1, 7, 1}, xi = 48)
public abstract class a<Element, Collection, Builder> implements kotlinx.serialization.c<Collection> {
    private a() {
    }

    public /* synthetic */ a(DefaultConstructorMarker r1) {
        this();
    }

    private final int a(kotlinx.serialization.b.b r3, Builder r4) {
        int r5 = ((kotlinx.serialization.b.b) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.serialization.b.b.class, "com.obric.memorydata.plugin")).e(a());
        a(r4, r5);
        return r5;
    }

    public static /* synthetic */ void a(a r2, kotlinx.serialization.b.b r3, int r4, Object r5, boolean r6, int r7, Object r8) {
        kotlinx.serialization.b.b r9 = (kotlinx.serialization.b.b) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.serialization.b.b.class, "com.obric.memorydata.plugin");
        if (r8 != null) goto L10;
        if ((r7 & 8) == 0) goto L7;
        r6 = true;
    L7:
        r2.a(r9, r4, r5, r6);
        return;
    L10:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: readElement");
    }

    public abstract int a(Builder r1);

    @Override // kotlinx.serialization.b
    public Collection a(kotlinx.serialization.b.c r3) {
        kotlinx.serialization.b.c r4 = (kotlinx.serialization.b.c) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.serialization.b.c.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "decoder");
        return a(r4, null);
    }

    public final Collection a(kotlinx.serialization.b.c r9, Collection r10) {
        kotlinx.serialization.b.c r11 = (kotlinx.serialization.b.c) ZeusTransformUtils.wrapperContextForParams(r9, kotlinx.serialization.b.c.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r11, "decoder");
        if (r10 == null) goto L6;
        Builder r12 = c(r10);
        if (r12 == null) goto L6;
    L7:
        int r7 = a(r12);
        kotlinx.serialization.b.b r13 = r11.c(a());
        if (r13.m() == false) goto L10;
        a(r13, r12, r7, a(r13, r12));
    L13:
        r13.d(a());
        return b(r12);
    L10:
        int r0 = r13.f(a());
        if (r0 == (-1)) goto L13;
        a(this, r13, r7 + r0, r12, false, 8, null);
    L6:
        r12 = b();
        goto L7
    }

    public abstract void a(Builder r1, int r2);

    public abstract void a(kotlinx.serialization.b.b r1, int r2, Builder r3, boolean r4);

    public abstract void a(kotlinx.serialization.b.b r1, Builder r2, int r3, int r4);

    public abstract Builder b();

    public abstract Collection b(Builder r1);

    public abstract Builder c(Collection r1);
}
