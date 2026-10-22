package kotlinx.serialization.json.internal;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.crash.entity.EventBody;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import kotlinx.serialization.internal.be;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000À\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\f\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\n\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b2\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\b\u0004\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0018\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u0017H\u0014J\u0010\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u0017H$J\b\u0010\u001c\u001a\u00020\u0006H\u0002J\b\u0010\u001d\u001a\u00020\u0006H\u0016J\b\u0010\u001e\u001a\u00020\u001fH\u0016J!\u0010 \u001a\u0002H!\"\u0004\b\u0000\u0010!2\f\u0010\"\u001a\b\u0012\u0004\u0012\u0002H!0#H\u0016¢\u0006\u0002\u0010$J\u0010\u0010%\u001a\u00020\u001f2\u0006\u0010\u001b\u001a\u00020\u0017H\u0014J\u0010\u0010&\u001a\u00020'2\u0006\u0010\u001b\u001a\u00020\u0017H\u0014J\u0010\u0010(\u001a\u00020)2\u0006\u0010\u001b\u001a\u00020\u0017H\u0014J\u0010\u0010*\u001a\u00020+2\u0006\u0010\u001b\u001a\u00020\u0017H\u0014J\u0018\u0010,\u001a\u00020-2\u0006\u0010\u001b\u001a\u00020\u00172\u0006\u0010.\u001a\u00020\u0015H\u0014J\u0010\u0010/\u001a\u0002002\u0006\u0010\u001b\u001a\u00020\u0017H\u0014J\u0018\u00101\u001a\u0002022\u0006\u0010\u001b\u001a\u00020\u00172\u0006\u00103\u001a\u00020\u0015H\u0014J\u0010\u00104\u001a\u00020-2\u0006\u0010\u001b\u001a\u00020\u0017H\u0014J\u0010\u00105\u001a\u0002062\u0006\u0010\u001b\u001a\u00020\u0017H\u0014J\u0010\u00107\u001a\u00020\u001f2\u0006\u0010\u001b\u001a\u00020\u0017H\u0014J\u0012\u00108\u001a\u0004\u0018\u0001092\u0006\u0010\u001b\u001a\u00020\u0017H\u0014J\u0010\u0010:\u001a\u00020;2\u0006\u0010\u001b\u001a\u00020\u0017H\u0014J\u0010\u0010<\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u0017H\u0014J\u0010\u0010=\u001a\u00020>2\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0010\u0010?\u001a\u00020@2\u0006\u0010\u001b\u001a\u00020\u0017H\u0004J\u0010\u0010A\u001a\u0002092\u0006\u0010B\u001a\u00020\u0017H\u0002J\u0014\u0010C\u001a\u00020D*\u00020@2\u0006\u0010E\u001a\u00020\u0017H\u0002J?\u0010B\u001a\u0002H!\"\b\b\u0000\u0010!*\u00020F*\u00020@2\u0006\u0010B\u001a\u00020\u00172\u0019\u0010G\u001a\u0015\u0012\u0004\u0012\u00020@\u0012\u0006\u0012\u0004\u0018\u0001H!0H¢\u0006\u0002\bIH\u0082\b¢\u0006\u0002\u0010JR\u0010\u0010\b\u001a\u00020\t8\u0004X\u0085\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011\u0082\u0001\u0003KLM¨\u0006N"}, d2 = {"Lkotlinx/serialization/json/internal/AbstractJsonTreeDecoder;", "Lkotlinx/serialization/internal/NamedValueDecoder;", "Lkotlinx/serialization/json/JsonDecoder;", "json", "Lkotlinx/serialization/json/Json;", EventBody.KEY_VALUE, "Lkotlinx/serialization/json/JsonElement;", "(Lkotlinx/serialization/json/Json;Lkotlinx/serialization/json/JsonElement;)V", "configuration", "Lkotlinx/serialization/json/JsonConfiguration;", "getJson", "()Lkotlinx/serialization/json/Json;", "serializersModule", "Lkotlinx/serialization/modules/SerializersModule;", "getSerializersModule", "()Lkotlinx/serialization/modules/SerializersModule;", "getValue", "()Lkotlinx/serialization/json/JsonElement;", "beginStructure", "Lkotlinx/serialization/encoding/CompositeDecoder;", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "composeName", "", "parentName", "childName", "currentElement", LocationMonitorConst.TAG, "currentObject", "decodeJsonElement", "decodeNotNullMark", "", "decodeSerializableValue", ExifInterface.GPS_DIRECTION_TRUE, "deserializer", "Lkotlinx/serialization/DeserializationStrategy;", "(Lkotlinx/serialization/DeserializationStrategy;)Ljava/lang/Object;", "decodeTaggedBoolean", "decodeTaggedByte", "", "decodeTaggedChar", "", "decodeTaggedDouble", "", "decodeTaggedEnum", "", "enumDescriptor", "decodeTaggedFloat", "", "decodeTaggedInline", "Lkotlinx/serialization/encoding/Decoder;", "inlineDescriptor", "decodeTaggedInt", "decodeTaggedLong", "", "decodeTaggedNotNullMark", "decodeTaggedNull", "", "decodeTaggedShort", "", "decodeTaggedString", "endStructure", "", "getPrimitiveValue", "Lkotlinx/serialization/json/JsonPrimitive;", "unparsedPrimitive", "primitive", "asLiteral", "Lkotlinx/serialization/json/JsonLiteral;", "type", "", "block", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "(Lkotlinx/serialization/json/JsonPrimitive;Ljava/lang/String;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "Lkotlinx/serialization/json/internal/JsonPrimitiveDecoder;", "Lkotlinx/serialization/json/internal/JsonTreeDecoder;", "Lkotlinx/serialization/json/internal/JsonTreeListDecoder;", "kotlinx-serialization-json"}, k = 1, mv = {1, 7, 1}, xi = 48)
abstract class c extends be implements kotlinx.serialization.json.f {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected final kotlinx.serialization.json.e f17839b;
    private final kotlinx.serialization.json.a c;
    private final kotlinx.serialization.json.g d;

    private c(kotlinx.serialization.json.a r1, kotlinx.serialization.json.g r2) {
        this.c = r1;
        this.d = r2;
        this.f17839b = a().a();
    }

    public /* synthetic */ c(kotlinx.serialization.json.a r1, kotlinx.serialization.json.g r2, DefaultConstructorMarker r3) {
        this(r1, r2);
    }

    private final kotlinx.serialization.json.k a(kotlinx.serialization.json.r r2, String r3) {
        if (ZeusTransformUtils.instanceOf(r2, kotlinx.serialization.json.k.class) == false) goto L5;
        kotlinx.serialization.json.k r1 = (kotlinx.serialization.json.k) ZeusTransformUtils.preCheckCast(r2, kotlinx.serialization.json.k.class, "com.obric.memorydata.plugin");
    L6:
        if (r1 == null) goto L9;
        return r1;
    L9:
        throw j.a(-1, "Unexpected 'null' when " + r3 + " was expected");
    L5:
        r1 = null;
        goto L6
    }

    private final Void n(String r3) {
        throw j.a(-1, "Failed to parse '" + r3 + '\'', (CharSequence) ZeusTransformUtils.preCheckCast(q().toString(), CharSequence.class, "com.obric.memorydata.plugin"));
    }

    private final kotlinx.serialization.json.g q() {
        String r0 = (String) ZeusTransformUtils.preCheckCast(v_(), String.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L7;
        kotlinx.serialization.json.g r1 = c2(r0);
        if (r1 == null) goto L7;
        return r1;
    L7:
        return p();
    }

    @Override // kotlinx.serialization.internal.cc
    public /* synthetic */ int a(String r3, kotlinx.serialization.descriptors.f r4) {
        kotlinx.serialization.descriptors.f r5 = (kotlinx.serialization.descriptors.f) ZeusTransformUtils.wrapperContextForParams(r4, kotlinx.serialization.descriptors.f.class, "com.obric.memorydata.plugin");
        return a2((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.memorydata.plugin"), r5);
    }

    /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
    public int a2(String r7, kotlinx.serialization.descriptors.f r8) {
        kotlinx.serialization.descriptors.f r0 = (kotlinx.serialization.descriptors.f) ZeusTransformUtils.wrapperContextForParams(r8, kotlinx.serialization.descriptors.f.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r7, LocationMonitorConst.TAG);
        Intrinsics.checkNotNullParameter(r0, "enumDescriptor");
        return k.a(r0, a(), b2(r7).b(), null, 4, null);
    }

    @Override // kotlinx.serialization.internal.cc, kotlinx.serialization.b.c
    public <T> T a(kotlinx.serialization.b<T> r3) {
        kotlinx.serialization.b r4 = (kotlinx.serialization.b) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.serialization.b.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "deserializer");
        return (T) q.a((kotlinx.serialization.json.f) ZeusTransformUtils.preCheckCast(this, kotlinx.serialization.json.f.class, "com.obric.memorydata.plugin"), r4);
    }

    @Override // kotlinx.serialization.internal.be
    public String a(String r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "parentName");
        Intrinsics.checkNotNullParameter(r2, "childName");
        return r2;
    }

    @Override // kotlinx.serialization.json.f
    public kotlinx.serialization.json.a a() {
        return this.c;
    }

    @Override // kotlinx.serialization.internal.cc
    public /* synthetic */ kotlinx.serialization.b.c b(String r3, kotlinx.serialization.descriptors.f r4) {
        kotlinx.serialization.descriptors.f r5 = (kotlinx.serialization.descriptors.f) ZeusTransformUtils.wrapperContextForParams(r4, kotlinx.serialization.descriptors.f.class, "com.obric.memorydata.plugin");
        return b2((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.memorydata.plugin"), r5);
    }

    /* JADX INFO: renamed from: b, reason: avoid collision after fix types in other method */
    public kotlinx.serialization.b.c b2(String r3, kotlinx.serialization.descriptors.f r4) {
        kotlinx.serialization.descriptors.f r5 = (kotlinx.serialization.descriptors.f) ZeusTransformUtils.wrapperContextForParams(r4, kotlinx.serialization.descriptors.f.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, LocationMonitorConst.TAG);
        Intrinsics.checkNotNullParameter(r5, "inlineDescriptor");
        if (r.a(r5) == false) goto L6;
        return (kotlinx.serialization.b.c) ZeusTransformUtils.preCheckCast(new h((a) ZeusTransformUtils.preCheckCast(new s(b2(r3).b()), a.class, "com.obric.memorydata.plugin"), a()), kotlinx.serialization.b.c.class, "com.obric.memorydata.plugin");
    L6:
        return super.b(r3, r5);
    }

    /* JADX INFO: renamed from: b, reason: avoid collision after fix types in other method */
    public final kotlinx.serialization.json.r b2(String r6) {
        Intrinsics.checkNotNullParameter(r6, LocationMonitorConst.TAG);
        kotlinx.serialization.json.g r0 = c2(r6);
        if (ZeusTransformUtils.instanceOf(r0, kotlinx.serialization.json.r.class) == false) goto L5;
        kotlinx.serialization.json.r r1 = (kotlinx.serialization.json.r) ZeusTransformUtils.preCheckCast(r0, kotlinx.serialization.json.r.class, "com.obric.memorydata.plugin");
    L6:
        if (r1 == null) goto L9;
        return r1;
    L9:
        throw j.a(-1, "Expected JsonPrimitive at " + r6 + ", found " + r0, (CharSequence) ZeusTransformUtils.preCheckCast(q().toString(), CharSequence.class, "com.obric.memorydata.plugin"));
    L5:
        r1 = null;
        goto L6
    }

    @Override // kotlinx.serialization.internal.cc, kotlinx.serialization.b.c
    public boolean b() {
        return !ZeusTransformUtils.instanceOf(q(), kotlinx.serialization.json.n.class);
    }

    @Override // kotlinx.serialization.internal.cc
    public /* synthetic */ boolean b(String r3) {
        return d2((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.memorydata.plugin"));
    }

    @Override // kotlinx.serialization.internal.cc, kotlinx.serialization.b.c
    public kotlinx.serialization.b.b c(kotlinx.serialization.descriptors.f r11) {
        kotlinx.serialization.descriptors.f r12 = (kotlinx.serialization.descriptors.f) ZeusTransformUtils.wrapperContextForParams(r11, kotlinx.serialization.descriptors.f.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r12, "descriptor");
        kotlinx.serialization.json.g r0 = q();
        kotlinx.serialization.descriptors.j r2 = r12.e();
        if (Intrinsics.areEqual(r2, kotlinx.serialization.descriptors.k.b.f17692a) == false) goto L5;
        boolean r3 = true;
    L7:
        if (r3 == false) goto L16;
        kotlinx.serialization.json.a r10 = a();
        if (ZeusTransformUtils.instanceOf(r0, kotlinx.serialization.json.b.class) == false) goto L14;
        Object r4 = new n(r10, (kotlinx.serialization.json.b) ZeusTransformUtils.preCheckCast(r0, kotlinx.serialization.json.b.class, "com.obric.memorydata.plugin"));
    L11:
        Object r13 = ZeusTransformUtils.preCheckCast(r4, kotlinx.serialization.b.b.class, "com.obric.memorydata.plugin");
    L39:
        return (kotlinx.serialization.b.b) r13;
    L14:
        throw j.a(-1, "Expected " + Reflection.getOrCreateKotlinClass(kotlinx.serialization.json.b.class) + " as the serialized body of " + r12.f() + ", but had " + Reflection.getOrCreateKotlinClass(r0.getClass()));
    L16:
        if (Intrinsics.areEqual(r2, kotlinx.serialization.descriptors.k.c.f17693a) == false) goto L36;
        kotlinx.serialization.json.a r5 = a();
        kotlinx.serialization.descriptors.f r6 = w.a(r12.b(0), r5.b());
        kotlinx.serialization.descriptors.j r8 = r6.e();
        if (ZeusTransformUtils.instanceOf(r8, kotlinx.serialization.descriptors.e.class) == false) goto L20;
    L31:
        kotlinx.serialization.json.a r14 = a();
        if (ZeusTransformUtils.instanceOf(r0, kotlinx.serialization.json.p.class) == false) goto L35;
        r4 = new o(r14, (kotlinx.serialization.json.p) ZeusTransformUtils.preCheckCast(r0, kotlinx.serialization.json.p.class, "com.obric.memorydata.plugin"));
        goto L11
    L35:
        throw j.a(-1, "Expected " + Reflection.getOrCreateKotlinClass(kotlinx.serialization.json.p.class) + " as the serialized body of " + r12.f() + ", but had " + Reflection.getOrCreateKotlinClass(r0.getClass()));
    L20:
        if (Intrinsics.areEqual(r8, kotlinx.serialization.descriptors.j.b.f17690a) == true) goto L31;
        if (r5.a().c() == false) goto L30;
        kotlinx.serialization.json.a r15 = a();
        if (ZeusTransformUtils.instanceOf(r0, kotlinx.serialization.json.b.class) == false) goto L28;
        r4 = new n(r15, (kotlinx.serialization.json.b) ZeusTransformUtils.preCheckCast(r0, kotlinx.serialization.json.b.class, "com.obric.memorydata.plugin"));
        goto L11
    L28:
        throw j.a(-1, "Expected " + Reflection.getOrCreateKotlinClass(kotlinx.serialization.json.b.class) + " as the serialized body of " + r12.f() + ", but had " + Reflection.getOrCreateKotlinClass(r0.getClass()));
    L30:
        throw j.a(r6);
    L36:
        kotlinx.serialization.json.a r7 = a();
        if (ZeusTransformUtils.instanceOf(r0, kotlinx.serialization.json.p.class) == false) goto L41;
        r13 = ZeusTransformUtils.preCheckCast(new m(r7, (kotlinx.serialization.json.p) ZeusTransformUtils.preCheckCast(r0, kotlinx.serialization.json.p.class, "com.obric.memorydata.plugin"), null, null, 12, null), kotlinx.serialization.b.b.class, "com.obric.memorydata.plugin");
        goto L39
    L41:
        throw j.a(-1, "Expected " + Reflection.getOrCreateKotlinClass(kotlinx.serialization.json.p.class) + " as the serialized body of " + r12.f() + ", but had " + Reflection.getOrCreateKotlinClass(r0.getClass()));
    L5:
        r3 = ZeusTransformUtils.instanceOf(r2, kotlinx.serialization.descriptors.d.class);
        goto L7
    }

    /* JADX INFO: renamed from: c, reason: avoid collision after fix types in other method */
    public abstract kotlinx.serialization.json.g c2(String r1);

    @Override // kotlinx.serialization.internal.cc
    public /* synthetic */ boolean c(String r3) {
        return e2((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.memorydata.plugin"));
    }

    @Override // kotlinx.serialization.internal.cc
    public /* synthetic */ byte d(String r3) {
        return f2((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.memorydata.plugin"));
    }

    @Override // kotlinx.serialization.internal.cc, kotlinx.serialization.b.b
    public void d(kotlinx.serialization.descriptors.f r2) {
        Intrinsics.checkNotNullParameter((kotlinx.serialization.descriptors.f) ZeusTransformUtils.wrapperContextForParams(r2, kotlinx.serialization.descriptors.f.class, "com.obric.memorydata.plugin"), "descriptor");
    }

    /* JADX INFO: renamed from: d, reason: avoid collision after fix types in other method */
    public boolean d2(String r2) {
        Intrinsics.checkNotNullParameter(r2, LocationMonitorConst.TAG);
        if (c2(r2) == kotlinx.serialization.json.n.f17858a) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // kotlinx.serialization.internal.cc
    public /* synthetic */ short e(String r3) {
        return g2((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: e, reason: avoid collision after fix types in other method */
    public boolean e2(String r4) {
        Intrinsics.checkNotNullParameter(r4, LocationMonitorConst.TAG);
        kotlinx.serialization.json.r r0 = b2(r4);
        if (a().a().b() == false) goto L5;
    L17:
        Boolean r5 = kotlinx.serialization.json.h.e(r0);     // Catch: IllegalArgumentException -> L15
        if (r5 == null) goto L14;
        return r5.booleanValue();
    L14:
        throw new IllegalArgumentException();     // Catch: IllegalArgumentException -> L15
    L15:
        n(TypedValues.Custom.S_BOOLEAN);
        throw new KotlinNothingValueException();
    L5:
        if (a(r0, TypedValues.Custom.S_BOOLEAN).a() == false) goto L17;
        throw j.a(-1, "Boolean literal for key '" + r4 + "' should be unquoted.\nUse 'isLenient = true' in 'Json {}` builder to accept non-compliant JSON.", (CharSequence) ZeusTransformUtils.preCheckCast(q().toString(), CharSequence.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: f, reason: avoid collision after fix types in other method */
    public byte f2(String r4) {
        Intrinsics.checkNotNullParameter(r4, LocationMonitorConst.TAG);
        int r5 = kotlinx.serialization.json.h.a(b2(r4));     // Catch: IllegalArgumentException -> L17
        boolean r2 = false;
        if ((-128) <= r5) goto L6;
    L8:
        if (r2 == false) goto L11;
        Byte r6 = Byte.valueOf((byte) r5);     // Catch: IllegalArgumentException -> L17
    L12:
        if (r6 != null) goto L14;
        n("byte");     // Catch: IllegalArgumentException -> L17
        throw new KotlinNothingValueException();     // Catch: IllegalArgumentException -> L17
    L14:
        return ((Number) ZeusTransformUtils.preCheckCast(r6, Number.class, "com.obric.memorydata.plugin")).byteValue();
    L11:
        r6 = null;
        goto L12
    L6:
        if (r5 > 127) goto L8;
        r2 = true;
    L17:
        n("byte");
        throw new KotlinNothingValueException();
    }

    @Override // kotlinx.serialization.internal.cc
    public /* synthetic */ int f(String r3) {
        return h2((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.memorydata.plugin"));
    }

    @Override // kotlinx.serialization.internal.cc
    public /* synthetic */ long g(String r3) {
        return i2((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: g, reason: avoid collision after fix types in other method */
    public short g2(String r4) {
        Intrinsics.checkNotNullParameter(r4, LocationMonitorConst.TAG);
        int r5 = kotlinx.serialization.json.h.a(b2(r4));     // Catch: IllegalArgumentException -> L17
        boolean r2 = false;
        if ((-32768) <= r5) goto L6;
    L8:
        if (r2 == false) goto L11;
        Short r6 = Short.valueOf((short) r5);     // Catch: IllegalArgumentException -> L17
    L12:
        if (r6 != null) goto L14;
        n("short");     // Catch: IllegalArgumentException -> L17
        throw new KotlinNothingValueException();     // Catch: IllegalArgumentException -> L17
    L14:
        return ((Number) ZeusTransformUtils.preCheckCast(r6, Number.class, "com.obric.memorydata.plugin")).shortValue();
    L11:
        r6 = null;
        goto L12
    L6:
        if (r5 > 32767) goto L8;
        r2 = true;
    L17:
        n("short");
        throw new KotlinNothingValueException();
    }

    @Override // kotlinx.serialization.internal.cc
    public /* synthetic */ float h(String r3) {
        return j2((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: h, reason: avoid collision after fix types in other method */
    public int h2(String r2) {
        Intrinsics.checkNotNullParameter(r2, LocationMonitorConst.TAG);
        return kotlinx.serialization.json.h.a(b2(r2));
    L5:
        n("int");
        throw new KotlinNothingValueException();
    }

    @Override // kotlinx.serialization.internal.cc
    public /* synthetic */ double i(String r3) {
        return k2((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: i, reason: avoid collision after fix types in other method */
    public long i2(String r2) {
        Intrinsics.checkNotNullParameter(r2, LocationMonitorConst.TAG);
        return kotlinx.serialization.json.h.b(b2(r2));
    L5:
        n("long");
        throw new KotlinNothingValueException();
    }

    @Override // kotlinx.serialization.internal.cc
    public /* synthetic */ char j(String r3) {
        return l((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: j, reason: avoid collision after fix types in other method */
    public float j2(String r4) {
        Intrinsics.checkNotNullParameter(r4, LocationMonitorConst.TAG);
        float r0 = kotlinx.serialization.json.h.d(b2(r4));     // Catch: IllegalArgumentException -> L17
        if (a().a().h() == false) goto L7;
    L16:
        return r0;
    L7:
        if (Float.isInfinite(r0) == false) goto L9;
    L11:
        boolean r1 = false;
    L12:
        if (r1 == true) goto L16;
        throw j.a((Number) ZeusTransformUtils.preCheckCast(Float.valueOf(r0), Number.class, "com.obric.memorydata.plugin"), r4, q().toString());
    L9:
        if (Float.isNaN(r0) == true) goto L11;
        r1 = true;
    L17:
        n(TypedValues.Custom.S_FLOAT);
        throw new KotlinNothingValueException();
    }

    /* JADX INFO: renamed from: k, reason: avoid collision after fix types in other method */
    public double k2(String r4) {
        Intrinsics.checkNotNullParameter(r4, LocationMonitorConst.TAG);
        double r0 = kotlinx.serialization.json.h.c(b2(r4));     // Catch: IllegalArgumentException -> L17
        if (a().a().h() == false) goto L7;
    L16:
        return r0;
    L7:
        if (Double.isInfinite(r0) == false) goto L9;
    L11:
        boolean r2 = false;
    L12:
        if (r2 == true) goto L16;
        throw j.a((Number) ZeusTransformUtils.preCheckCast(Double.valueOf(r0), Number.class, "com.obric.memorydata.plugin"), r4, q().toString());
    L9:
        if (Double.isNaN(r0) == true) goto L11;
        r2 = true;
    L17:
        n("double");
        throw new KotlinNothingValueException();
    }

    @Override // kotlinx.serialization.internal.cc
    public /* synthetic */ String k(String r3) {
        return m((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.memorydata.plugin"));
    }

    public char l(String r3) {
        Intrinsics.checkNotNullParameter(r3, LocationMonitorConst.TAG);
        return StringsKt.single((CharSequence) ZeusTransformUtils.preCheckCast(b2(r3).b(), CharSequence.class, "com.obric.memorydata.plugin"));
    L5:
        n("char");
        throw new KotlinNothingValueException();
    }

    public String m(String r5) {
        Intrinsics.checkNotNullParameter(r5, LocationMonitorConst.TAG);
        kotlinx.serialization.json.r r0 = b2(r5);
        if (a().a().b() == true) goto L10;
        if (a(r0, TypedValues.Custom.S_STRING).a() == true) goto L10;
        throw j.a(-1, "String literal for key '" + r5 + "' should be quoted.\nUse 'isLenient = true' in 'Json {}` builder to accept non-compliant JSON.", (CharSequence) ZeusTransformUtils.preCheckCast(q().toString(), CharSequence.class, "com.obric.memorydata.plugin"));
    L10:
        if (ZeusTransformUtils.instanceOf(r0, kotlinx.serialization.json.n.class) == true) goto L14;
        return r0.b();
    L14:
        throw j.a(-1, "Unexpected 'null' value instead of string literal", (CharSequence) ZeusTransformUtils.preCheckCast(q().toString(), CharSequence.class, "com.obric.memorydata.plugin"));
    }

    @Override // kotlinx.serialization.internal.cc, kotlinx.serialization.b.b, kotlinx.serialization.b.c
    public kotlinx.serialization.modules.d n() {
        return a().b();
    }

    @Override // kotlinx.serialization.json.f
    public kotlinx.serialization.json.g o() {
        return q();
    }

    public kotlinx.serialization.json.g p() {
        return this.d;
    }
}
