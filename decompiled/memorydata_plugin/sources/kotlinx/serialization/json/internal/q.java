package kotlinx.serialization.json.internal;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.crash.entity.EventBody;
import com.obric.memorydata.memory.ui.automemory.settings.MemoryInfoSectionEditActivity;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.annotation.Annotation;
import java.util.Iterator;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000Z\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0000\u001a\u001a\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\tH\u0001\u001a*\u0010\n\u001a\u00020\u00012\n\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\f2\u0006\u0010\u000f\u001a\u00020\u0007H\u0002\u001a\u0014\u0010\u000f\u001a\u00020\u0007*\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0000\u001a%\u0010\u0013\u001a\u0002H\u0014\"\u0004\b\u0000\u0010\u0014*\u00020\u00152\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u0002H\u00140\u0017H\u0000¢\u0006\u0002\u0010\u0018\u001aE\u0010\u0019\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0014*\u00020\u001a2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\u00140\f2\u0006\u0010\u001b\u001a\u0002H\u00142\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00010\u001dH\u0080\bø\u0001\u0000¢\u0006\u0002\u0010\u001e\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u001f"}, d2 = {"checkKind", "", MemoryInfoSectionEditActivity.EXTRA_KIND, "Lkotlinx/serialization/descriptors/SerialKind;", "throwSerializerNotFound", "", "type", "", "jsonTree", "Lkotlinx/serialization/json/JsonObject;", "validateIfSealed", "serializer", "Lkotlinx/serialization/SerializationStrategy;", "actualSerializer", "", "classDiscriminator", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "json", "Lkotlinx/serialization/json/Json;", "decodeSerializableValuePolymorphic", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/serialization/json/JsonDecoder;", "deserializer", "Lkotlinx/serialization/DeserializationStrategy;", "(Lkotlinx/serialization/json/JsonDecoder;Lkotlinx/serialization/DeserializationStrategy;)Ljava/lang/Object;", "encodePolymorphically", "Lkotlinx/serialization/json/JsonEncoder;", EventBody.KEY_VALUE, "ifPolymorphic", "Lkotlin/Function1;", "(Lkotlinx/serialization/json/JsonEncoder;Lkotlinx/serialization/SerializationStrategy;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)V", "kotlinx-serialization-json"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class q {
    public static final <T> T a(kotlinx.serialization.json.f r5, kotlinx.serialization.b<T> r6) {
        kotlinx.serialization.json.f r7 = (kotlinx.serialization.json.f) ZeusTransformUtils.wrapperContextForParams(r5, kotlinx.serialization.json.f.class, "com.obric.memorydata.plugin");
        kotlinx.serialization.b r8 = (kotlinx.serialization.b) ZeusTransformUtils.wrapperContextForParams(r6, kotlinx.serialization.b.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r7, "<this>");
        Intrinsics.checkNotNullParameter(r8, "deserializer");
        if (ZeusTransformUtils.instanceOf(r8, kotlinx.serialization.internal.b.class) == false) goto L24;
        if (r7.a().a().f() == true) goto L24;
        String r0 = a(r8.a(), r7.a());
        kotlinx.serialization.json.g r2 = r7.o();
        kotlinx.serialization.descriptors.f r3 = r8.a();
        if (ZeusTransformUtils.instanceOf(r2, kotlinx.serialization.json.p.class) == false) goto L22;
        kotlinx.serialization.json.p r4 = (kotlinx.serialization.json.p) ZeusTransformUtils.preCheckCast(r2, kotlinx.serialization.json.p.class, "com.obric.memorydata.plugin");
        kotlinx.serialization.json.g r9 = (kotlinx.serialization.json.g) ZeusTransformUtils.preCheckCast(r4.get(r0), kotlinx.serialization.json.g.class, "com.obric.memorydata.plugin");
        if (r9 == null) goto L14;
        kotlinx.serialization.json.r r10 = kotlinx.serialization.json.h.a(r9);
        if (r10 == null) goto L14;
        String r11 = r10.b();
    L15:
        kotlinx.serialization.b<? extends T> r12 = ((kotlinx.serialization.internal.b) ZeusTransformUtils.preCheckCast(r8, kotlinx.serialization.internal.b.class, "com.obric.memorydata.plugin")).a((kotlinx.serialization.b.b) ZeusTransformUtils.preCheckCast(r7, kotlinx.serialization.b.b.class, "com.obric.memorydata.plugin"), r11);
        if (r12 != null) goto L18;
        a(r11, r4);
        throw new KotlinNothingValueException();
    L18:
        return (T) u.a(r7.a(), r0, r4, r12);
    L14:
        r11 = null;
        goto L15
    L22:
        throw j.a(-1, "Expected " + Reflection.getOrCreateKotlinClass(kotlinx.serialization.json.p.class) + " as the serialized body of " + r3.f() + ", but had " + Reflection.getOrCreateKotlinClass(r2.getClass()));
    L24:
        return (T) r8.a((kotlinx.serialization.b.c) ZeusTransformUtils.preCheckCast(r7, kotlinx.serialization.b.c.class, "com.obric.memorydata.plugin"));
    }

    public static final String a(kotlinx.serialization.descriptors.f r3, kotlinx.serialization.json.a r4) {
        kotlinx.serialization.descriptors.f r5 = (kotlinx.serialization.descriptors.f) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.serialization.descriptors.f.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r4, "json");
        Iterator<Annotation> r6 = r5.a().iterator();
    L4:
        if (r6.hasNext() == false) goto L10;
        Annotation r0 = (Annotation) ZeusTransformUtils.preCheckCast(r6.next(), Annotation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r0, kotlinx.serialization.json.d.class) == false) goto L4;
        return ((kotlinx.serialization.json.d) ZeusTransformUtils.preCheckCast(r0, kotlinx.serialization.json.d.class, "com.obric.memorydata.plugin")).a();
    L10:
        return r4.a().g();
    }

    public static final Void a(String r3, kotlinx.serialization.json.p r4) {
        Intrinsics.checkNotNullParameter(r4, "jsonTree");
        if (r3 != null) goto L5;
        String r5 = "missing class discriminator ('null')";
    L7:
        throw j.a(-1, "Polymorphic serializer was not found for " + r5, (CharSequence) ZeusTransformUtils.preCheckCast(r4.toString(), CharSequence.class, "com.obric.memorydata.plugin"));
    L5:
        r5 = "class discriminator '" + r3 + '\'';
        goto L7
    }
}
