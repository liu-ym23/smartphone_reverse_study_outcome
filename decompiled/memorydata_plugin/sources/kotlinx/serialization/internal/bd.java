package kotlinx.serialization.internal;

import com.bytedance.crash.entity.EventBody;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntProgression;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0010&\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u0002*\u0004\b\u0002\u0010\u0003*\u0014\b\u0003\u0010\u0004*\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u00052 \u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u0007\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u0002H\u00040\u0006B#\b\u0004\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\t\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00010\t¢\u0006\u0002\u0010\u000bJ-\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00028\u00032\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0019H\u0004¢\u0006\u0002\u0010\u001bJ-\u0010\u001c\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u001d\u001a\u00020\u00192\u0006\u0010\u0017\u001a\u00028\u00032\u0006\u0010\u001e\u001a\u00020\u001fH\u0004¢\u0006\u0002\u0010 J\u001d\u0010!\u001a\u00020\u00142\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00028\u0002H\u0016¢\u0006\u0002\u0010%J)\u0010&\u001a\u00020\u0014*\u00028\u00032\u0006\u0010\u001d\u001a\u00020\u00192\u0006\u0010'\u001a\u00028\u00002\u0006\u0010$\u001a\u00028\u0001H$¢\u0006\u0002\u0010(R\u0012\u0010\f\u001a\u00020\rX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\t¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011\u0082\u0001\u0002)*¨\u0006+"}, d2 = {"Lkotlinx/serialization/internal/MapLikeSerializer;", "Key", "Value", "Collection", "Builder", "", "Lkotlinx/serialization/internal/AbstractCollectionSerializer;", "", "keySerializer", "Lkotlinx/serialization/KSerializer;", "valueSerializer", "(Lkotlinx/serialization/KSerializer;Lkotlinx/serialization/KSerializer;)V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "getKeySerializer", "()Lkotlinx/serialization/KSerializer;", "getValueSerializer", "readAll", "", "decoder", "Lkotlinx/serialization/encoding/CompositeDecoder;", "builder", "startIndex", "", "size", "(Lkotlinx/serialization/encoding/CompositeDecoder;Ljava/util/Map;II)V", "readElement", "index", "checkIndex", "", "(Lkotlinx/serialization/encoding/CompositeDecoder;ILjava/util/Map;Z)V", "serialize", "encoder", "Lkotlinx/serialization/encoding/Encoder;", EventBody.KEY_VALUE, "(Lkotlinx/serialization/encoding/Encoder;Ljava/lang/Object;)V", "insertKeyValuePair", "key", "(Ljava/util/Map;ILjava/lang/Object;Ljava/lang/Object;)V", "Lkotlinx/serialization/internal/HashMapSerializer;", "Lkotlinx/serialization/internal/LinkedHashMapSerializer;", "kotlinx-serialization-core"}, k = 1, mv = {1, 7, 1}, xi = 48)
public abstract class bd<Key, Value, Collection, Builder extends Map<Key, Value>> extends a<Map.Entry<? extends Key, ? extends Value>, Collection, Builder> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final kotlinx.serialization.c<Key> f17739a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final kotlinx.serialization.c<Value> f17740b;

    private bd(kotlinx.serialization.c<Key> r3, kotlinx.serialization.c<Value> r4) {
        kotlinx.serialization.c<Key> r5 = (kotlinx.serialization.c) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.serialization.c.class, "com.obric.memorydata.plugin");
        kotlinx.serialization.c<Value> r6 = (kotlinx.serialization.c) ZeusTransformUtils.wrapperContextForParams(r4, kotlinx.serialization.c.class, "com.obric.memorydata.plugin");
        super(null);
        this.f17739a = r5;
        this.f17740b = r6;
    }

    public /* synthetic */ bd(kotlinx.serialization.c r2, kotlinx.serialization.c r3, DefaultConstructorMarker r4) {
        this((kotlinx.serialization.c) ZeusTransformUtils.wrapperContextForParams(r2, kotlinx.serialization.c.class, "com.obric.memorydata.plugin"), (kotlinx.serialization.c) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.serialization.c.class, "com.obric.memorydata.plugin"));
    }

    @Override // kotlinx.serialization.c, kotlinx.serialization.b
    public abstract kotlinx.serialization.descriptors.f a();

    @Override // kotlinx.serialization.internal.a
    public /* synthetic */ void a(kotlinx.serialization.b.b r3, int r4, Object r5, boolean r6) {
        a((kotlinx.serialization.b.b) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.serialization.b.b.class, "com.obric.memorydata.plugin"), r4, (Map) ZeusTransformUtils.preCheckCast(r5, Map.class, "com.obric.memorydata.plugin"), r6);
    }

    public final void a(kotlinx.serialization.b.b r10, int r11, Builder r12, boolean r13) {
        kotlinx.serialization.b.b r14 = (kotlinx.serialization.b.b) ZeusTransformUtils.wrapperContextForParams(r10, kotlinx.serialization.b.b.class, "com.obric.memorydata.plugin");
        Map r15 = (Map) ZeusTransformUtils.wrapperContextForParams(r12, Map.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r14, "decoder");
        Intrinsics.checkNotNullParameter(r15, "builder");
        Object r0 = kotlinx.serialization.b.b.C0886b.a(r14, a(), r11, (kotlinx.serialization.b) ZeusTransformUtils.preCheckCast(this.f17739a, kotlinx.serialization.b.class, "com.obric.memorydata.plugin"), null, 8, null);
        boolean r2 = true;
        if (r13 == false) goto L12;
        int r16 = r14.f(a());
        if (r16 == (r11 + 1)) goto L8;
        r2 = false;
    L8:
        if (r2 == false) goto L11;
        int r4 = r16;
    L14:
        if (r15.containsKey(r0) == true) goto L16;
    L18:
        Object r9 = kotlinx.serialization.b.b.C0886b.a(r14, a(), r4, (kotlinx.serialization.b) ZeusTransformUtils.preCheckCast(this.f17740b, kotlinx.serialization.b.class, "com.obric.memorydata.plugin"), null, 8, null);
    L19:
        r15.put(r0, r9);
        return;
    L16:
        if (ZeusTransformUtils.instanceOf(this.f17740b.a().e(), kotlinx.serialization.descriptors.e.class) == true) goto L18;
        r9 = r14.a(a(), r4, (kotlinx.serialization.b) ZeusTransformUtils.preCheckCast(this.f17740b, kotlinx.serialization.b.class, "com.obric.memorydata.plugin"), MapsKt.getValue(r15, r0));
        goto L19
    L11:
        throw new IllegalArgumentException(("Value must follow key in a map, index for key: " + r11 + ", returned index for value: " + r16).toString());
    L12:
        r4 = r11 + 1;
        goto L14
    }

    @Override // kotlinx.serialization.internal.a
    public /* synthetic */ void a(kotlinx.serialization.b.b r3, Object r4, int r5, int r6) {
        a((kotlinx.serialization.b.b) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.serialization.b.b.class, "com.obric.memorydata.plugin"), (Map) ZeusTransformUtils.preCheckCast(r4, Map.class, "com.obric.memorydata.plugin"), r5, r6);
    }

    public final void a(kotlinx.serialization.b.b r5, Builder r6, int r7, int r8) {
        kotlinx.serialization.b.b r9 = (kotlinx.serialization.b.b) ZeusTransformUtils.wrapperContextForParams(r5, kotlinx.serialization.b.b.class, "com.obric.memorydata.plugin");
        Map r10 = (Map) ZeusTransformUtils.wrapperContextForParams(r6, Map.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r9, "decoder");
        Intrinsics.checkNotNullParameter(r10, "builder");
        if (r8 < 0) goto L5;
        boolean r2 = true;
    L6:
        if (r2 == false) goto L17;
        IntProgression r11 = RangesKt.step((IntProgression) ZeusTransformUtils.preCheckCast(RangesKt.until(0, r8 * 2), IntProgression.class, "com.obric.memorydata.plugin"), 2);
        int r1 = r11.getFirst();
        int r3 = r11.getLast();
        int r12 = r11.getStep();
        if (r12 <= 0) goto L10;
        if (r1 > r3) goto L10;
    L12:
        a(r9, r7 + r1, r10, false);
        if (r1 == r3) goto L21;
        r1 = r1 + r12;
        goto L12
    L21:
        return;
    L10:
        if (r12 >= 0) goto L15;
        if (r3 <= r1) goto L12;
        return;
    L15:
        return;
    L17:
        throw new IllegalArgumentException("Size must be known in advance when using READ_ALL".toString());
    L5:
        r2 = false;
        goto L6
    }
}
