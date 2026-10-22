package kotlinx.serialization.internal;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.crash.entity.EventBody;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.Enum;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Typography;
import kotlinx.serialization.SerializationException;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0001\u0018\u0000*\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B%\b\u0010\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nB\u001b\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007¢\u0006\u0002\u0010\u000bJ\u0010\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u0005H\u0002J\u0015\u0010\u0013\u001a\u00028\u00002\u0006\u0010\u0014\u001a\u00020\u0015H\u0016¢\u0006\u0002\u0010\u0016J\u001d\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u001cJ\b\u0010\u001d\u001a\u00020\u0005H\u0016R\u001b\u0010\b\u001a\u00020\t8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\rR\u0010\u0010\u0010\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0011¨\u0006\u001e"}, d2 = {"Lkotlinx/serialization/internal/EnumSerializer;", ExifInterface.GPS_DIRECTION_TRUE, "", "Lkotlinx/serialization/KSerializer;", "serialName", "", "values", "", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "(Ljava/lang/String;[Ljava/lang/Enum;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "(Ljava/lang/String;[Ljava/lang/Enum;)V", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "descriptor$delegate", "Lkotlin/Lazy;", "overriddenDescriptor", "[Ljava/lang/Enum;", "createUnmarkedDescriptor", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "(Lkotlinx/serialization/encoding/Decoder;)Ljava/lang/Enum;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", EventBody.KEY_VALUE, "(Lkotlinx/serialization/encoding/Encoder;Ljava/lang/Enum;)V", "toString", "kotlinx-serialization-core"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class ad<T extends Enum<T>> implements kotlinx.serialization.c<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final T[] f17707a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private kotlinx.serialization.descriptors.f f17708b;
    private final Lazy c;

    public ad(final String r2, T[] r3) {
        Intrinsics.checkNotNullParameter(r2, "serialName");
        Intrinsics.checkNotNullParameter(r3, "values");
        this.f17707a = r3;
        this.c = LazyKt.lazy((Function0) ZeusTransformUtils.preCheckCast(new EnumSerializer$descriptor$2(this, r2), Function0.class, "com.obric.memorydata.plugin"));
    }

    private final kotlinx.serialization.descriptors.f a(String r8) {
        ac r0 = new ac(r8, this.f17707a.length);
        T[] r7 = this.f17707a;
        int r9 = r7.length;
        int r2 = 0;
    L4:
        if (r2 >= r9) goto L7;
        bn.a((bn) ZeusTransformUtils.preCheckCast(r0, bn.class, "com.obric.memorydata.plugin"), r7[r2].name(), false, 2, null);
        r2 = r2 + 1;
        goto L4
    L7:
        return (kotlinx.serialization.descriptors.f) ZeusTransformUtils.preCheckCast(r0, kotlinx.serialization.descriptors.f.class, "com.obric.memorydata.plugin");
    }

    public static final /* synthetic */ kotlinx.serialization.descriptors.f a(ad r0) {
        return r0.f17708b;
    }

    public static final /* synthetic */ kotlinx.serialization.descriptors.f a(ad r0, String r1) {
        return r0.a(r1);
    }

    @Override // kotlinx.serialization.b
    public /* synthetic */ Object a(kotlinx.serialization.b.c r3) {
        return b((kotlinx.serialization.b.c) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.serialization.b.c.class, "com.obric.memorydata.plugin"));
    }

    @Override // kotlinx.serialization.c, kotlinx.serialization.b
    public kotlinx.serialization.descriptors.f a() {
        return (kotlinx.serialization.descriptors.f) ZeusTransformUtils.preCheckCast(this.c.getValue(), kotlinx.serialization.descriptors.f.class, "com.obric.memorydata.plugin");
    }

    public T b(kotlinx.serialization.b.c r3) {
        kotlinx.serialization.b.c r4 = (kotlinx.serialization.b.c) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.serialization.b.c.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "decoder");
        int r5 = r4.a(a());
        boolean r0 = false;
        if (r5 >= 0) goto L5;
    L7:
        if (r0 == false) goto L11;
        return this.f17707a[r5];
    L11:
        throw new SerializationException(r5 + " is not among valid " + a().f() + " enum values, values size is " + this.f17707a.length);
    L5:
        if (r5 >= this.f17707a.length) goto L7;
        r0 = true;
        goto L7
    }

    public String toString() {
        return "kotlinx.serialization.internal.EnumSerializer<" + a().f() + Typography.greater;
    }
}
