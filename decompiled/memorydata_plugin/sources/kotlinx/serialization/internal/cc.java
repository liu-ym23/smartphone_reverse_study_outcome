package kotlinx.serialization.internal;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.serialization.SerializationException;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0096\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0005\n\u0002\b\u0002\n\u0002\u0010\f\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\n\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b&\n\u0002\u0018\u0002\n\u0002\b\u0004\b'\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u00022\u00020\u0003B\u0005¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0016\u0010\u0016\u001a\u00020\u00172\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00000\u0000H\u0004J\u0006\u0010\u0019\u001a\u00020\u000bJ\u0016\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u001cJ\u0006\u0010\u001d\u001a\u00020\u001eJ\u0016\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u001cJ\u0006\u0010 \u001a\u00020!J\u0016\u0010\"\u001a\u00020!2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u001cJ\u0006\u0010#\u001a\u00020$J\u0016\u0010%\u001a\u00020$2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u001cJ\u000e\u0010&\u001a\u00020\u001c2\u0006\u0010'\u001a\u00020\u0015J\u0006\u0010(\u001a\u00020)J\u0016\u0010*\u001a\u00020)2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u001cJ\u000e\u0010+\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0015J\u0016\u0010,\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u001cJ\u0006\u0010-\u001a\u00020\u001cJ\u0016\u0010.\u001a\u00020\u001c2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u001cJ\u0006\u0010/\u001a\u000200J\u0016\u00101\u001a\u0002002\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u001cJ\b\u00102\u001a\u00020\u000bH\u0016J\b\u00103\u001a\u0004\u0018\u000104JA\u00105\u001a\u0004\u0018\u0001H6\"\b\b\u0001\u00106*\u0002072\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u001c2\u000e\u00108\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001H6092\b\u0010:\u001a\u0004\u0018\u0001H6¢\u0006\u0002\u0010;J9\u0010<\u001a\u0002H6\"\u0004\b\u0001\u001062\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u001c2\f\u00108\u001a\b\u0012\u0004\u0012\u0002H6092\b\u0010:\u001a\u0004\u0018\u0001H6¢\u0006\u0002\u0010;J+\u0010=\u001a\u0002H6\"\u0004\b\u0001\u001062\f\u00108\u001a\b\u0012\u0004\u0012\u0002H6092\b\u0010:\u001a\u0004\u0018\u0001H6H\u0014¢\u0006\u0002\u0010>J\u0006\u0010?\u001a\u00020@J\u0016\u0010A\u001a\u00020@2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u001cJ\u0006\u0010B\u001a\u00020CJ\u0016\u0010D\u001a\u00020C2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u001cJ\u0015\u0010E\u001a\u00020\u000b2\u0006\u0010F\u001a\u00028\u0000H\u0014¢\u0006\u0002\u0010GJ\u0015\u0010H\u001a\u00020\u001e2\u0006\u0010F\u001a\u00028\u0000H\u0014¢\u0006\u0002\u0010IJ\u0015\u0010J\u001a\u00020!2\u0006\u0010F\u001a\u00028\u0000H\u0014¢\u0006\u0002\u0010KJ\u0015\u0010L\u001a\u00020$2\u0006\u0010F\u001a\u00028\u0000H\u0014¢\u0006\u0002\u0010MJ\u001d\u0010N\u001a\u00020\u001c2\u0006\u0010F\u001a\u00028\u00002\u0006\u0010'\u001a\u00020\u0015H\u0014¢\u0006\u0002\u0010OJ\u0015\u0010P\u001a\u00020)2\u0006\u0010F\u001a\u00028\u0000H\u0014¢\u0006\u0002\u0010QJ\u001d\u0010R\u001a\u00020\u00022\u0006\u0010F\u001a\u00028\u00002\u0006\u0010S\u001a\u00020\u0015H\u0014¢\u0006\u0002\u0010TJ\u0015\u0010U\u001a\u00020\u001c2\u0006\u0010F\u001a\u00028\u0000H\u0014¢\u0006\u0002\u0010VJ\u0015\u0010W\u001a\u0002002\u0006\u0010F\u001a\u00028\u0000H\u0014¢\u0006\u0002\u0010XJ\u0015\u0010Y\u001a\u00020\u000b2\u0006\u0010F\u001a\u00028\u0000H\u0014¢\u0006\u0002\u0010GJ\u0017\u0010Z\u001a\u0004\u0018\u0001042\u0006\u0010F\u001a\u00028\u0000H\u0014¢\u0006\u0002\u0010[J\u0015\u0010\\\u001a\u00020@2\u0006\u0010F\u001a\u00028\u0000H\u0014¢\u0006\u0002\u0010]J\u0015\u0010^\u001a\u00020C2\u0006\u0010F\u001a\u00028\u0000H\u0014¢\u0006\u0002\u0010_J\u0015\u0010`\u001a\u0002072\u0006\u0010F\u001a\u00028\u0000H\u0014¢\u0006\u0002\u0010aJ\u0010\u0010b\u001a\u00020\u00172\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\r\u0010c\u001a\u00028\u0000H\u0004¢\u0006\u0002\u0010\u0007J\u0015\u0010d\u001a\u00020\u00172\u0006\u0010e\u001a\u00028\u0000H\u0004¢\u0006\u0002\u0010fJ)\u0010g\u001a\u0002Hh\"\u0004\b\u0001\u0010h2\u0006\u0010F\u001a\u00028\u00002\f\u0010i\u001a\b\u0012\u0004\u0012\u0002Hh0jH\u0002¢\u0006\u0002\u0010kJ\u0019\u0010l\u001a\u00028\u0000*\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u001cH$¢\u0006\u0002\u0010mR\u0014\u0010\u0005\u001a\u00028\u00008DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0016\u0010\b\u001a\u0004\u0018\u00018\u00008DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u0007R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\u00020\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00028\u00000\u0011j\b\u0012\u0004\u0012\u00028\u0000`\u0012X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006n"}, d2 = {"Lkotlinx/serialization/internal/TaggedDecoder;", "Tag", "Lkotlinx/serialization/encoding/Decoder;", "Lkotlinx/serialization/encoding/CompositeDecoder;", "()V", "currentTag", "getCurrentTag", "()Ljava/lang/Object;", "currentTagOrNull", "getCurrentTagOrNull", "flag", "", "serializersModule", "Lkotlinx/serialization/modules/SerializersModule;", "getSerializersModule", "()Lkotlinx/serialization/modules/SerializersModule;", "tagStack", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "beginStructure", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "copyTagsTo", "", "other", "decodeBoolean", "decodeBooleanElement", "index", "", "decodeByte", "", "decodeByteElement", "decodeChar", "", "decodeCharElement", "decodeDouble", "", "decodeDoubleElement", "decodeEnum", "enumDescriptor", "decodeFloat", "", "decodeFloatElement", "decodeInline", "decodeInlineElement", "decodeInt", "decodeIntElement", "decodeLong", "", "decodeLongElement", "decodeNotNullMark", "decodeNull", "", "decodeNullableSerializableElement", ExifInterface.GPS_DIRECTION_TRUE, "", "deserializer", "Lkotlinx/serialization/DeserializationStrategy;", "previousValue", "(Lkotlinx/serialization/descriptors/SerialDescriptor;ILkotlinx/serialization/DeserializationStrategy;Ljava/lang/Object;)Ljava/lang/Object;", "decodeSerializableElement", "decodeSerializableValue", "(Lkotlinx/serialization/DeserializationStrategy;Ljava/lang/Object;)Ljava/lang/Object;", "decodeShort", "", "decodeShortElement", "decodeString", "", "decodeStringElement", "decodeTaggedBoolean", LocationMonitorConst.TAG, "(Ljava/lang/Object;)Z", "decodeTaggedByte", "(Ljava/lang/Object;)B", "decodeTaggedChar", "(Ljava/lang/Object;)C", "decodeTaggedDouble", "(Ljava/lang/Object;)D", "decodeTaggedEnum", "(Ljava/lang/Object;Lkotlinx/serialization/descriptors/SerialDescriptor;)I", "decodeTaggedFloat", "(Ljava/lang/Object;)F", "decodeTaggedInline", "inlineDescriptor", "(Ljava/lang/Object;Lkotlinx/serialization/descriptors/SerialDescriptor;)Lkotlinx/serialization/encoding/Decoder;", "decodeTaggedInt", "(Ljava/lang/Object;)I", "decodeTaggedLong", "(Ljava/lang/Object;)J", "decodeTaggedNotNullMark", "decodeTaggedNull", "(Ljava/lang/Object;)Ljava/lang/Void;", "decodeTaggedShort", "(Ljava/lang/Object;)S", "decodeTaggedString", "(Ljava/lang/Object;)Ljava/lang/String;", "decodeTaggedValue", "(Ljava/lang/Object;)Ljava/lang/Object;", "endStructure", "popTag", "pushTag", ActivityLifecycle.NAME, "(Ljava/lang/Object;)V", "tagBlock", ExifInterface.LONGITUDE_EAST, "block", "Lkotlin/Function0;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "getTag", "(Lkotlinx/serialization/descriptors/SerialDescriptor;I)Ljava/lang/Object;", "kotlinx-serialization-core"}, k = 1, mv = {1, 7, 1}, xi = 48)
public abstract class cc<Tag> implements kotlinx.serialization.b.b, kotlinx.serialization.b.c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ArrayList<Tag> f17767b;
    private boolean c;

    public cc() {
        this.f17767b = new ArrayList();
    }

    private final <E> E a(Tag r3, Function0<? extends E> r4) {
        Function0 r5 = (Function0) ZeusTransformUtils.wrapperContextForParams(r4, Function0.class, "com.obric.memorydata.plugin");
        l(r3);
        E r6 = (E) r5.invoke();
        if (this.c == true) goto L5;
        w_();
    L5:
        this.c = false;
        return r6;
    }

    public int a(Tag r3, kotlinx.serialization.descriptors.f r4) {
        Intrinsics.checkNotNullParameter((kotlinx.serialization.descriptors.f) ZeusTransformUtils.wrapperContextForParams(r4, kotlinx.serialization.descriptors.f.class, "com.obric.memorydata.plugin"), "enumDescriptor");
        Object r2 = a(r3);
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type kotlin.Int");
        return ((Integer) ZeusTransformUtils.preCheckCast(r2, Integer.class, "com.obric.memorydata.plugin")).intValue();
    }

    @Override // kotlinx.serialization.b.c
    public final int a(kotlinx.serialization.descriptors.f r3) {
        kotlinx.serialization.descriptors.f r4 = (kotlinx.serialization.descriptors.f) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.serialization.descriptors.f.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "enumDescriptor");
        return a(w_(), r4);
    }

    public Object a(Tag r2) {
        throw new SerializationException(Reflection.getOrCreateKotlinClass(getClass()) + " can't retrieve untyped values");
    }

    @Override // kotlinx.serialization.b.c
    public <T> T a(kotlinx.serialization.b<T> r3) {
        return (T) kotlinx.serialization.b.c.a.a(this, (kotlinx.serialization.b) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.serialization.b.class, "com.obric.memorydata.plugin"));
    }

    public <T> T a(kotlinx.serialization.b<T> r2, T r3) {
        kotlinx.serialization.b<T> r4 = (kotlinx.serialization.b) ZeusTransformUtils.wrapperContextForParams(r2, kotlinx.serialization.b.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "deserializer");
        return (T) a(r4);
    }

    @Override // kotlinx.serialization.b.b
    public final <T> T a(kotlinx.serialization.descriptors.f r3, int r4, kotlinx.serialization.b<T> r5, final T r6) {
        kotlinx.serialization.descriptors.f r7 = (kotlinx.serialization.descriptors.f) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.serialization.descriptors.f.class, "com.obric.memorydata.plugin");
        final kotlinx.serialization.b r8 = (kotlinx.serialization.b) ZeusTransformUtils.wrapperContextForParams(r5, kotlinx.serialization.b.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r7, "descriptor");
        Intrinsics.checkNotNullParameter(r8, "deserializer");
        return (T) a(m(r7, r4), (Function0) ZeusTransformUtils.preCheckCast(new TaggedDecoder$decodeSerializableElement$1(this, r8, r6), Function0.class, "com.obric.memorydata.plugin"));
    }

    @Override // kotlinx.serialization.b.b
    public final boolean a(kotlinx.serialization.descriptors.f r3, int r4) {
        kotlinx.serialization.descriptors.f r5 = (kotlinx.serialization.descriptors.f) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.serialization.descriptors.f.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "descriptor");
        return c(m(r5, r4));
    }

    @Override // kotlinx.serialization.b.b
    public final byte b(kotlinx.serialization.descriptors.f r3, int r4) {
        kotlinx.serialization.descriptors.f r5 = (kotlinx.serialization.descriptors.f) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.serialization.descriptors.f.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "descriptor");
        return d(m(r5, r4));
    }

    public kotlinx.serialization.b.c b(Tag r3, kotlinx.serialization.descriptors.f r4) {
        Intrinsics.checkNotNullParameter((kotlinx.serialization.descriptors.f) ZeusTransformUtils.wrapperContextForParams(r4, kotlinx.serialization.descriptors.f.class, "com.obric.memorydata.plugin"), "inlineDescriptor");
        ((cc) ZeusTransformUtils.preCheckCast(this, cc.class, "com.obric.memorydata.plugin")).l(r3);
        return (kotlinx.serialization.b.c) ZeusTransformUtils.preCheckCast(this, kotlinx.serialization.b.c.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlinx.serialization.b.c
    public final kotlinx.serialization.b.c b(kotlinx.serialization.descriptors.f r3) {
        kotlinx.serialization.descriptors.f r4 = (kotlinx.serialization.descriptors.f) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.serialization.descriptors.f.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "descriptor");
        return b(w_(), r4);
    }

    @Override // kotlinx.serialization.b.c
    public boolean b() {
        Tag r0 = v_();
        if (r0 != null) goto L7;
        return false;
    L7:
        return b(r0);
    }

    public boolean b(Tag r1) {
        return true;
    }

    @Override // kotlinx.serialization.b.c
    public final Void c() {
        return null;
    }

    @Override // kotlinx.serialization.b.c
    public kotlinx.serialization.b.b c(kotlinx.serialization.descriptors.f r3) {
        Intrinsics.checkNotNullParameter((kotlinx.serialization.descriptors.f) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.serialization.descriptors.f.class, "com.obric.memorydata.plugin"), "descriptor");
        return (kotlinx.serialization.b.b) ZeusTransformUtils.preCheckCast(this, kotlinx.serialization.b.b.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlinx.serialization.b.b
    public final short c(kotlinx.serialization.descriptors.f r3, int r4) {
        kotlinx.serialization.descriptors.f r5 = (kotlinx.serialization.descriptors.f) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.serialization.descriptors.f.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "descriptor");
        return e(m(r5, r4));
    }

    public boolean c(Tag r2) {
        Object r1 = a(r2);
        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type kotlin.Boolean");
        return ((Boolean) ZeusTransformUtils.preCheckCast(r1, Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
    }

    public byte d(Tag r2) {
        Object r1 = a(r2);
        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type kotlin.Byte");
        return ((Byte) ZeusTransformUtils.preCheckCast(r1, Byte.class, "com.obric.memorydata.plugin")).byteValue();
    }

    @Override // kotlinx.serialization.b.b
    public final int d(kotlinx.serialization.descriptors.f r3, int r4) {
        kotlinx.serialization.descriptors.f r5 = (kotlinx.serialization.descriptors.f) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.serialization.descriptors.f.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "descriptor");
        return f(m(r5, r4));
    }

    @Override // kotlinx.serialization.b.b
    public void d(kotlinx.serialization.descriptors.f r2) {
        Intrinsics.checkNotNullParameter((kotlinx.serialization.descriptors.f) ZeusTransformUtils.wrapperContextForParams(r2, kotlinx.serialization.descriptors.f.class, "com.obric.memorydata.plugin"), "descriptor");
    }

    @Override // kotlinx.serialization.b.c
    public final boolean d() {
        return c(w_());
    }

    @Override // kotlinx.serialization.b.c
    public final byte e() {
        return d(w_());
    }

    @Override // kotlinx.serialization.b.b
    public int e(kotlinx.serialization.descriptors.f r3) {
        return kotlinx.serialization.b.b.C0886b.a(this, (kotlinx.serialization.descriptors.f) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.serialization.descriptors.f.class, "com.obric.memorydata.plugin"));
    }

    @Override // kotlinx.serialization.b.b
    public final long e(kotlinx.serialization.descriptors.f r3, int r4) {
        kotlinx.serialization.descriptors.f r5 = (kotlinx.serialization.descriptors.f) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.serialization.descriptors.f.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "descriptor");
        return g(m(r5, r4));
    }

    public short e(Tag r2) {
        Object r1 = a(r2);
        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type kotlin.Short");
        return ((Short) ZeusTransformUtils.preCheckCast(r1, Short.class, "com.obric.memorydata.plugin")).shortValue();
    }

    @Override // kotlinx.serialization.b.b
    public final float f(kotlinx.serialization.descriptors.f r3, int r4) {
        kotlinx.serialization.descriptors.f r5 = (kotlinx.serialization.descriptors.f) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.serialization.descriptors.f.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "descriptor");
        return h(m(r5, r4));
    }

    public int f(Tag r2) {
        Object r1 = a(r2);
        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type kotlin.Int");
        return ((Integer) ZeusTransformUtils.preCheckCast(r1, Integer.class, "com.obric.memorydata.plugin")).intValue();
    }

    @Override // kotlinx.serialization.b.c
    public final short f() {
        return e(w_());
    }

    @Override // kotlinx.serialization.b.b
    public final double g(kotlinx.serialization.descriptors.f r3, int r4) {
        kotlinx.serialization.descriptors.f r5 = (kotlinx.serialization.descriptors.f) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.serialization.descriptors.f.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "descriptor");
        return i(m(r5, r4));
    }

    @Override // kotlinx.serialization.b.c
    public final int g() {
        return f(w_());
    }

    public long g(Tag r2) {
        Object r1 = a(r2);
        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type kotlin.Long");
        return ((Long) ZeusTransformUtils.preCheckCast(r1, Long.class, "com.obric.memorydata.plugin")).longValue();
    }

    @Override // kotlinx.serialization.b.b
    public final char h(kotlinx.serialization.descriptors.f r3, int r4) {
        kotlinx.serialization.descriptors.f r5 = (kotlinx.serialization.descriptors.f) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.serialization.descriptors.f.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "descriptor");
        return j(m(r5, r4));
    }

    public float h(Tag r2) {
        Object r1 = a(r2);
        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type kotlin.Float");
        return ((Float) ZeusTransformUtils.preCheckCast(r1, Float.class, "com.obric.memorydata.plugin")).floatValue();
    }

    @Override // kotlinx.serialization.b.c
    public final long h() {
        return g(w_());
    }

    public double i(Tag r2) {
        Object r1 = a(r2);
        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type kotlin.Double");
        return ((Double) ZeusTransformUtils.preCheckCast(r1, Double.class, "com.obric.memorydata.plugin")).doubleValue();
    }

    @Override // kotlinx.serialization.b.c
    public final float i() {
        return h(w_());
    }

    @Override // kotlinx.serialization.b.b
    public final String i(kotlinx.serialization.descriptors.f r3, int r4) {
        kotlinx.serialization.descriptors.f r5 = (kotlinx.serialization.descriptors.f) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.serialization.descriptors.f.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "descriptor");
        return k(m(r5, r4));
    }

    public char j(Tag r2) {
        Object r1 = a(r2);
        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type kotlin.Char");
        return ((Character) ZeusTransformUtils.preCheckCast(r1, Character.class, "com.obric.memorydata.plugin")).charValue();
    }

    @Override // kotlinx.serialization.b.c
    public final double j() {
        return i(w_());
    }

    @Override // kotlinx.serialization.b.b
    public final kotlinx.serialization.b.c j(kotlinx.serialization.descriptors.f r3, int r4) {
        kotlinx.serialization.descriptors.f r5 = (kotlinx.serialization.descriptors.f) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.serialization.descriptors.f.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "descriptor");
        return b(m(r5, r4), r5.b(r4));
    }

    @Override // kotlinx.serialization.b.c
    public final char k() {
        return j(w_());
    }

    public String k(Tag r2) {
        Object r1 = a(r2);
        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type kotlin.String");
        return (String) ZeusTransformUtils.preCheckCast(r1, String.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlinx.serialization.b.c
    public final String l() {
        return k(w_());
    }

    public final void l(Tag r1) {
        this.f17767b.add(r1);
    }

    public abstract Tag m(kotlinx.serialization.descriptors.f r1, int r2);

    @Override // kotlinx.serialization.b.b
    public boolean m() {
        return kotlinx.serialization.b.b.C0886b.a(this);
    }

    @Override // kotlinx.serialization.b.b, kotlinx.serialization.b.c
    public kotlinx.serialization.modules.d n() {
        return kotlinx.serialization.modules.e.a();
    }

    public final Tag v_() {
        return (Tag) CollectionsKt.lastOrNull((List) ZeusTransformUtils.preCheckCast(this.f17767b, List.class, "com.obric.memorydata.plugin"));
    }

    public final Tag w_() {
        ArrayList<Tag> r0 = this.f17767b;
        Tag r1 = r0.remove(CollectionsKt.getLastIndex((List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.memorydata.plugin")));
        this.c = true;
        return r1;
    }
}
