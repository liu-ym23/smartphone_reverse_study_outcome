package kotlinx.serialization.internal;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.crash.entity.EventBody;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a$\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0006H\u0000¨\u0006\u0007"}, d2 = {"InlinePrimitiveDescriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", ExifInterface.GPS_DIRECTION_TRUE, ActivityLifecycle.NAME, "", "primitiveSerializer", "Lkotlinx/serialization/KSerializer;", "kotlinx-serialization-core"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class an {

    /* JADX INFO: Add missing generic type declarations: [T] */
    @Metadata(d1 = {"\u00005\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0017\u0010\u0006\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\b0\u0007H\u0016¢\u0006\u0002\u0010\tJ\u0015\u0010\n\u001a\u00028\u00002\u0006\u0010\u000b\u001a\u00020\fH\u0016¢\u0006\u0002\u0010\rJ\u001d\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0013R\u0014\u0010\u0002\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0014"}, d2 = {"kotlinx/serialization/internal/InlineClassDescriptorKt$InlinePrimitiveDescriptor$1", "Lkotlinx/serialization/internal/GeneratedSerializer;", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "(Lkotlinx/serialization/encoding/Decoder;)Ljava/lang/Object;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", EventBody.KEY_VALUE, "(Lkotlinx/serialization/encoding/Encoder;Ljava/lang/Object;)V", "kotlinx-serialization-core"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a<T> implements ah<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ kotlinx.serialization.c<T> f17717a;

        a(kotlinx.serialization.c<T> r3) {
            this.f17717a = (kotlinx.serialization.c) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.serialization.c.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlinx.serialization.b
        public T a(kotlinx.serialization.b.c r2) {
            Intrinsics.checkNotNullParameter((kotlinx.serialization.b.c) ZeusTransformUtils.wrapperContextForParams(r2, kotlinx.serialization.b.c.class, "com.obric.memorydata.plugin"), "decoder");
            throw new IllegalStateException("unsupported".toString());
        }

        @Override // kotlinx.serialization.c, kotlinx.serialization.b
        public kotlinx.serialization.descriptors.f a() {
            throw new IllegalStateException("unsupported".toString());
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlinx.serialization.internal.ah
        public kotlinx.serialization.c<?>[] b() {
            return new kotlinx.serialization.c[]{this.f17717a};
        }

        @Override // kotlinx.serialization.internal.ah
        public kotlinx.serialization.c<?>[] c() {
            return ah.a.a(this);
        }
    }

    public static final <T> kotlinx.serialization.descriptors.f a(String r3, kotlinx.serialization.c<T> r4) {
        kotlinx.serialization.c r5 = (kotlinx.serialization.c) ZeusTransformUtils.wrapperContextForParams(r4, kotlinx.serialization.c.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, ActivityLifecycle.NAME);
        Intrinsics.checkNotNullParameter(r5, "primitiveSerializer");
        return (kotlinx.serialization.descriptors.f) ZeusTransformUtils.preCheckCast(new am(r3, (ah) ZeusTransformUtils.preCheckCast(new a(r5), ah.class, "com.obric.memorydata.plugin")), kotlinx.serialization.descriptors.f.class, "com.obric.memorydata.plugin");
    }
}
