package kotlinx.serialization.internal;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.crash.entity.EventBody;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\n\u0012\u0006\u0012\u0004\u0018\u0001H\u00010\u0003B\u0013\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003¢\u0006\u0002\u0010\u0005J\u0017\u0010\n\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u000b\u001a\u00020\fH\u0016¢\u0006\u0002\u0010\rJ\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0002H\u0096\u0002J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\u001f\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00018\u0000H\u0016¢\u0006\u0002\u0010\u0018R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lkotlinx/serialization/internal/NullableSerializer;", ExifInterface.GPS_DIRECTION_TRUE, "", "Lkotlinx/serialization/KSerializer;", "serializer", "(Lkotlinx/serialization/KSerializer;)V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "(Lkotlinx/serialization/encoding/Decoder;)Ljava/lang/Object;", "equals", "", "other", "hashCode", "", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", EventBody.KEY_VALUE, "(Lkotlinx/serialization/encoding/Encoder;Ljava/lang/Object;)V", "kotlinx-serialization-core"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class bg<T> implements kotlinx.serialization.c<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final kotlinx.serialization.c<T> f17741a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final kotlinx.serialization.descriptors.f f17742b;

    public bg(kotlinx.serialization.c<T> r3) {
        kotlinx.serialization.c<T> r4 = (kotlinx.serialization.c) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.serialization.c.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "serializer");
        this.f17741a = r4;
        this.f17742b = (kotlinx.serialization.descriptors.f) ZeusTransformUtils.preCheckCast(new bw(r4.a()), kotlinx.serialization.descriptors.f.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlinx.serialization.b
    public T a(kotlinx.serialization.b.c r3) {
        kotlinx.serialization.b.c r4 = (kotlinx.serialization.b.c) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.serialization.b.c.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "decoder");
        if (r4.b() == false) goto L6;
        return (T) r4.a((kotlinx.serialization.b) ZeusTransformUtils.preCheckCast(this.f17741a, kotlinx.serialization.b.class, "com.obric.memorydata.plugin"));
    L6:
        return (T) r4.c();
    }

    @Override // kotlinx.serialization.c, kotlinx.serialization.b
    public kotlinx.serialization.descriptors.f a() {
        return this.f17742b;
    }

    public boolean equals(Object r6) {
        if (this != r6) goto L6;
        return true;
    L6:
        if (r6 != null) goto L8;
    L14:
        return false;
    L8:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(getClass()), Reflection.getOrCreateKotlinClass(r6.getClass())) == false) goto L14;
        bg r4 = (bg) ZeusTransformUtils.preCheckCast(r6, bg.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.f17741a, ((bg) ZeusTransformUtils.preCheckCast(r6, bg.class, "com.obric.memorydata.plugin")).f17741a) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public int hashCode() {
        return this.f17741a.hashCode();
    }
}
