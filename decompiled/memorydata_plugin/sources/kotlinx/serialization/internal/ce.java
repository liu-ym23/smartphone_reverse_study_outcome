package kotlinx.serialization.internal;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.crash.entity.EventBody;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Triple;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.SerializationException;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0001\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u0002*\u0004\b\u0002\u0010\u00032\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00050\u0004B/\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00020\u0004¢\u0006\u0002\u0010\tJ\"\u0010\u000e\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\"\u0010\u0011\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\"\u0010\u0012\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J*\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0018\u0010\u0019\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u0005H\u0016R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\u00020\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u001a"}, d2 = {"Lkotlinx/serialization/internal/TripleSerializer;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "B", "C", "Lkotlinx/serialization/KSerializer;", "Lkotlin/Triple;", "aSerializer", "bSerializer", "cSerializer", "(Lkotlinx/serialization/KSerializer;Lkotlinx/serialization/KSerializer;Lkotlinx/serialization/KSerializer;)V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "decodeSequentially", "composite", "Lkotlinx/serialization/encoding/CompositeDecoder;", "decodeStructure", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", EventBody.KEY_VALUE, "kotlinx-serialization-core"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class ce<A, B, C> implements kotlinx.serialization.c<Triple<? extends A, ? extends B, ? extends C>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final kotlinx.serialization.c<A> f17769a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final kotlinx.serialization.c<B> f17770b;
    private final kotlinx.serialization.c<C> c;
    private final kotlinx.serialization.descriptors.f d;

    public ce(kotlinx.serialization.c<A> r3, kotlinx.serialization.c<B> r4, kotlinx.serialization.c<C> r5) {
        kotlinx.serialization.c<A> r6 = (kotlinx.serialization.c) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.serialization.c.class, "com.obric.memorydata.plugin");
        kotlinx.serialization.c<B> r7 = (kotlinx.serialization.c) ZeusTransformUtils.wrapperContextForParams(r4, kotlinx.serialization.c.class, "com.obric.memorydata.plugin");
        kotlinx.serialization.c<C> r8 = (kotlinx.serialization.c) ZeusTransformUtils.wrapperContextForParams(r5, kotlinx.serialization.c.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "aSerializer");
        Intrinsics.checkNotNullParameter(r7, "bSerializer");
        Intrinsics.checkNotNullParameter(r8, "cSerializer");
        this.f17769a = r6;
        this.f17770b = r7;
        this.c = r8;
        this.d = kotlinx.serialization.descriptors.i.a("kotlin.Triple", new kotlinx.serialization.descriptors.f[0], (Function1) ZeusTransformUtils.preCheckCast(new TripleSerializer$descriptor$1(this), Function1.class, "com.obric.memorydata.plugin"));
    }

    private final Triple<A, B, C> a(kotlinx.serialization.b.b r11) {
        kotlinx.serialization.b.b r12 = (kotlinx.serialization.b.b) ZeusTransformUtils.wrapperContextForParams(r11, kotlinx.serialization.b.b.class, "com.obric.memorydata.plugin");
        Object r0 = kotlinx.serialization.b.b.C0886b.a(r12, a(), 0, (kotlinx.serialization.b) ZeusTransformUtils.preCheckCast(this.f17769a, kotlinx.serialization.b.class, "com.obric.memorydata.plugin"), null, 8, null);
        Object r9 = kotlinx.serialization.b.b.C0886b.a(r12, a(), 1, (kotlinx.serialization.b) ZeusTransformUtils.preCheckCast(this.f17770b, kotlinx.serialization.b.class, "com.obric.memorydata.plugin"), null, 8, null);
        Object r1 = kotlinx.serialization.b.b.C0886b.a(r12, a(), 2, (kotlinx.serialization.b) ZeusTransformUtils.preCheckCast(this.c, kotlinx.serialization.b.class, "com.obric.memorydata.plugin"), null, 8, null);
        r12.d(a());
        return new Triple(r0, r9, r1);
    }

    public static final /* synthetic */ kotlinx.serialization.c a(ce r0) {
        return r0.f17769a;
    }

    private final Triple<A, B, C> b(kotlinx.serialization.b.b r12) {
        kotlinx.serialization.b.b r13 = (kotlinx.serialization.b.b) ZeusTransformUtils.wrapperContextForParams(r12, kotlinx.serialization.b.b.class, "com.obric.memorydata.plugin");
        Object r0 = cf.a();
        Object r9 = cf.a();
        Object r10 = cf.a();
    L3:
        int r2 = r13.f(a());
        if (r2 == (-1)) goto L15;
        if (r2 != 0) goto L7;
        r0 = kotlinx.serialization.b.b.C0886b.a(r13, a(), 0, (kotlinx.serialization.b) ZeusTransformUtils.preCheckCast(this.f17769a, kotlinx.serialization.b.class, "com.obric.memorydata.plugin"), null, 8, null);
        goto L3
    L7:
        if (r2 != 1) goto L9;
        r9 = kotlinx.serialization.b.b.C0886b.a(r13, a(), 1, (kotlinx.serialization.b) ZeusTransformUtils.preCheckCast(this.f17770b, kotlinx.serialization.b.class, "com.obric.memorydata.plugin"), null, 8, null);
        goto L3
    L9:
        if (r2 != 2) goto L12;
        r10 = kotlinx.serialization.b.b.C0886b.a(r13, a(), 2, (kotlinx.serialization.b) ZeusTransformUtils.preCheckCast(this.c, kotlinx.serialization.b.class, "com.obric.memorydata.plugin"), null, 8, null);
        goto L3
    L12:
        throw new SerializationException("Unexpected index " + r2);
    L15:
        r13.d(a());
        if (r0 == cf.a()) goto L28;
        if (r9 == cf.a()) goto L26;
        if (r10 == cf.a()) goto L24;
        return new Triple(r0, r9, r10);
    L24:
        throw new SerializationException("Element 'third' is missing");
    L26:
        throw new SerializationException("Element 'second' is missing");
    L28:
        throw new SerializationException("Element 'first' is missing");
    }

    public static final /* synthetic */ kotlinx.serialization.c b(ce r0) {
        return r0.f17770b;
    }

    public static final /* synthetic */ kotlinx.serialization.c c(ce r0) {
        return r0.c;
    }

    @Override // kotlinx.serialization.b
    public /* synthetic */ Object a(kotlinx.serialization.b.c r3) {
        return b((kotlinx.serialization.b.c) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.serialization.b.c.class, "com.obric.memorydata.plugin"));
    }

    @Override // kotlinx.serialization.c, kotlinx.serialization.b
    public kotlinx.serialization.descriptors.f a() {
        return this.d;
    }

    public Triple<A, B, C> b(kotlinx.serialization.b.c r3) {
        kotlinx.serialization.b.c r4 = (kotlinx.serialization.b.c) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.serialization.b.c.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "decoder");
        kotlinx.serialization.b.b r5 = r4.c(a());
        if (r5.m() == false) goto L7;
        return a(r5);
    L7:
        return b(r5);
    }
}
