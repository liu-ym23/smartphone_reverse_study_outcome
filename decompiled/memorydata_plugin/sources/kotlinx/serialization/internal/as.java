package kotlinx.serialization.internal;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.crash.entity.EventBody;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.SerializationException;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b1\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u0002*\u0004\b\u0002\u0010\u00032\b\u0012\u0004\u0012\u0002H\u00030\u0004B#\b\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004¢\u0006\u0002\u0010\u0007J\u0015\u0010\u0010\u001a\u00028\u00022\u0006\u0010\u0011\u001a\u00020\u0012H\u0016¢\u0006\u0002\u0010\u0013J\u001d\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u000e\u001a\u00028\u0002H\u0016¢\u0006\u0002\u0010\u0018J\u001d\u0010\u0019\u001a\u00028\u00022\u0006\u0010\u000b\u001a\u00028\u00002\u0006\u0010\u000e\u001a\u00028\u0001H$¢\u0006\u0002\u0010\u001aR\u001a\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001a\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0016\u0010\u000b\u001a\u00028\u0000*\u00028\u0002X¤\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0016\u0010\u000e\u001a\u00028\u0001*\u00028\u0002X¤\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\r\u0082\u0001\u0002\u001b\u001c¨\u0006\u001d"}, d2 = {"Lkotlinx/serialization/internal/KeyValueSerializer;", "K", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "R", "Lkotlinx/serialization/KSerializer;", "keySerializer", "valueSerializer", "(Lkotlinx/serialization/KSerializer;Lkotlinx/serialization/KSerializer;)V", "getKeySerializer", "()Lkotlinx/serialization/KSerializer;", "getValueSerializer", "key", "getKey", "(Ljava/lang/Object;)Ljava/lang/Object;", EventBody.KEY_VALUE, "getValue", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "(Lkotlinx/serialization/encoding/Decoder;)Ljava/lang/Object;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "(Lkotlinx/serialization/encoding/Encoder;Ljava/lang/Object;)V", "toResult", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "Lkotlinx/serialization/internal/MapEntrySerializer;", "Lkotlinx/serialization/internal/PairSerializer;", "kotlinx-serialization-core"}, k = 1, mv = {1, 7, 1}, xi = 48)
public abstract class as<K, V, R> implements kotlinx.serialization.c<R> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final kotlinx.serialization.c<K> f17723a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final kotlinx.serialization.c<V> f17724b;

    private as(kotlinx.serialization.c<K> r3, kotlinx.serialization.c<V> r4) {
        kotlinx.serialization.c<K> r5 = (kotlinx.serialization.c) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.serialization.c.class, "com.obric.memorydata.plugin");
        kotlinx.serialization.c<V> r6 = (kotlinx.serialization.c) ZeusTransformUtils.wrapperContextForParams(r4, kotlinx.serialization.c.class, "com.obric.memorydata.plugin");
        this.f17723a = r5;
        this.f17724b = r6;
    }

    public /* synthetic */ as(kotlinx.serialization.c r2, kotlinx.serialization.c r3, DefaultConstructorMarker r4) {
        this((kotlinx.serialization.c) ZeusTransformUtils.wrapperContextForParams(r2, kotlinx.serialization.c.class, "com.obric.memorydata.plugin"), (kotlinx.serialization.c) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.serialization.c.class, "com.obric.memorydata.plugin"));
    }

    public abstract R a(K r1, V r2);

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.serialization.b
    public R a(kotlinx.serialization.b.c r11) {
        kotlinx.serialization.b.c r12 = (kotlinx.serialization.b.c) ZeusTransformUtils.wrapperContextForParams(r11, kotlinx.serialization.b.c.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r12, "decoder");
        kotlinx.serialization.b.b r13 = r12.c(a());
        if (r13.m() == true) goto L5;
        Object r0 = cf.a();
        Object r9 = cf.a();
    L7:
        int r2 = r13.f(a());
        if (r2 == (-1)) goto L16;
        if (r2 != 0) goto L11;
        r0 = kotlinx.serialization.b.b.C0886b.a(r13, a(), 0, (kotlinx.serialization.b) ZeusTransformUtils.preCheckCast(this.f17723a, kotlinx.serialization.b.class, "com.obric.memorydata.plugin"), null, 8, null);
        goto L7
    L11:
        if (r2 != 1) goto L14;
        r9 = kotlinx.serialization.b.b.C0886b.a(r13, a(), 1, (kotlinx.serialization.b) ZeusTransformUtils.preCheckCast(this.f17724b, kotlinx.serialization.b.class, "com.obric.memorydata.plugin"), null, 8, null);
        goto L7
    L14:
        throw new SerializationException("Invalid index: " + r2);
    L16:
        r13.d(a());
        if (r0 == cf.a()) goto L25;
        if (r9 == cf.a()) goto L23;
        return (R) a(r0, r9);
    L23:
        throw new SerializationException("Element 'value' is missing");
    L25:
        throw new SerializationException("Element 'key' is missing");
    L5:
        return (R) a(kotlinx.serialization.b.b.C0886b.a(r13, a(), 0, (kotlinx.serialization.b) ZeusTransformUtils.preCheckCast(this.f17723a, kotlinx.serialization.b.class, "com.obric.memorydata.plugin"), null, 8, null), kotlinx.serialization.b.b.C0886b.a(r13, a(), 1, (kotlinx.serialization.b) ZeusTransformUtils.preCheckCast(this.f17724b, kotlinx.serialization.b.class, "com.obric.memorydata.plugin"), null, 8, null));
    }
}
