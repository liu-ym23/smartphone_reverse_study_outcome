package kotlinx.serialization.json.internal;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.DeepRecursiveFunction;
import kotlin.DeepRecursiveKt;
import kotlin.DeepRecursiveScope;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\u000b\u001a\u00020\fJ\b\u0010\r\u001a\u00020\fH\u0002J\b\u0010\u000e\u001a\u00020\fH\u0002J\b\u0010\u000f\u001a\u00020\fH\u0002J\u0017\u0010\u0010\u001a\u00020\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\f0\u0013H\u0082\bJ\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\bH\u0002J!\u0010\u000f\u001a\u00020\f*\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\f0\u0017H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u0019R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001a"}, d2 = {"Lkotlinx/serialization/json/internal/JsonTreeReader;", "", "configuration", "Lkotlinx/serialization/json/JsonConfiguration;", "lexer", "Lkotlinx/serialization/json/internal/AbstractJsonLexer;", "(Lkotlinx/serialization/json/JsonConfiguration;Lkotlinx/serialization/json/internal/AbstractJsonLexer;)V", "isLenient", "", "stackDepth", "", "read", "Lkotlinx/serialization/json/JsonElement;", "readArray", "readDeepRecursive", "readObject", "readObjectImpl", "Lkotlinx/serialization/json/JsonObject;", "reader", "Lkotlin/Function0;", "readValue", "Lkotlinx/serialization/json/JsonPrimitive;", "isString", "Lkotlin/DeepRecursiveScope;", "", "(Lkotlin/DeepRecursiveScope;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-serialization-json"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final a f17849a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f17850b;
    private int c;

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x00c8 -> B:27:0x00d3). Please report as a decompilation issue!!! */
    private final Object a(DeepRecursiveScope<Unit, kotlinx.serialization.json.g> r21, Continuation<? super kotlinx.serialization.json.g> r22) {
        p r0 = this;
        Continuation r1 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r22, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r1, JsonTreeReader$readObject$2.class) == false) goto L7;
        JsonTreeReader$readObject$2 r3 = (JsonTreeReader$readObject$2) ZeusTransformUtils.preCheckCast(r1, JsonTreeReader$readObject$2.class, "com.obric.memorydata.plugin");
        if ((r3.label & Integer.MIN_VALUE) == 0) goto L7;
        r3.label -= Integer.MIN_VALUE;
    L8:
        Object r2 = r3.result;
        Object r4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r5 = r3.label;
        if (r5 == 0) goto L14;
        if (r5 != 1) goto L13;
        String r6 = (String) ZeusTransformUtils.preCheckCast(r3.L$3, String.class, "com.obric.memorydata.plugin");
        LinkedHashMap r7 = (LinkedHashMap) ZeusTransformUtils.preCheckCast(r3.L$2, LinkedHashMap.class, "com.obric.memorydata.plugin");
        p r10 = (p) ZeusTransformUtils.preCheckCast(r3.L$1, p.class, "com.obric.memorydata.plugin");
        DeepRecursiveScope r11 = (DeepRecursiveScope) ZeusTransformUtils.preCheckCast(r3.L$0, DeepRecursiveScope.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r2);
        JsonTreeReader$readObject$2 r8 = r3;
        LinkedHashMap r9 = r7;
        Object r12 = r4;
    L27:
        ((Map) ZeusTransformUtils.preCheckCast(r9, Map.class, "com.obric.memorydata.plugin")).put(r6, (kotlinx.serialization.json.g) ZeusTransformUtils.preCheckCast(r2, kotlinx.serialization.json.g.class, "com.obric.memorydata.plugin"));
        byte r13 = r10.f17849a.d();
        if (r13 == 4) goto L33;
        if (r13 != 7) goto L31;
        LinkedHashMap r18 = r9;
        byte r14 = r13;
        r0 = r10;
        LinkedHashMap r15 = r18;
    L34:
        if (r14 != 6) goto L36;
        r0.f17849a.a((byte) 7);
    L38:
        return new kotlinx.serialization.json.p((Map) ZeusTransformUtils.preCheckCast(r15, Map.class, "com.obric.memorydata.plugin"));
    L36:
        if (r14 != 4) goto L38;
        a.a(r0.f17849a, "Unexpected trailing comma", 0, null, 6, null);
        throw new KotlinNothingValueException();
    L31:
        a.a(r10.f17849a, "Expected end of the object or comma", 0, null, 6, null);
        throw new KotlinNothingValueException();
    L33:
        DeepRecursiveScope r16 = r11;
        LinkedHashMap r19 = r9;
        r14 = r13;
        r0 = r10;
        r15 = r19;
    L18:
        if (r0.f17849a.c() == false) goto L34;
        if (r0.f17850b == false) goto L22;
        String r17 = r0.f17849a.i();
    L23:
        r0.f17849a.a((byte) 5);
        Unit r110 = Unit.INSTANCE;
        r8.L$0 = r16;
        r8.L$1 = r0;
        r8.L$2 = r15;
        r8.L$3 = r17;
        r8.label = 1;
        Object r111 = r16.callRecursive(r110, r8);
        if (r111 != r12) goto L26;
        return r12;
    L26:
        LinkedHashMap r112 = r15;
        r10 = r0;
        r6 = r17;
        r9 = r112;
        r11 = r16;
        r2 = r111;
        goto L27
    L22:
        r17 = r0.f17849a.h();
        goto L23
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r2);
        byte r20 = r0.f17849a.a((byte) 6);
        if (r0.f17849a.e() == 4) goto L41;
        r15 = new LinkedHashMap();
        r12 = r4;
        r8 = r3;
        r14 = r20;
        r16 = r21;
        goto L18
    L41:
        a.a(r0.f17849a, "Unexpected leading comma", 0, null, 6, null);
        throw new KotlinNothingValueException();
    L7:
        r3 = new JsonTreeReader$readObject$2(r0, r1);
        goto L8
    }

    public static final /* synthetic */ Object a(p r2, DeepRecursiveScope r3, Continuation r4) {
        return r2.a(r3, (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    public static final /* synthetic */ a a(p r0) {
        return r0.f17849a;
    }

    public static final /* synthetic */ kotlinx.serialization.json.r a(p r0, boolean r1) {
        return r0.a(r1);
    }

    private final kotlinx.serialization.json.r a(boolean r3) {
        if (this.f17850b == true) goto L7;
        if (r3 == false) goto L7;
        String r2 = this.f17849a.h();
    L9:
        if (r3 == false) goto L11;
    L15:
        Object r4 = ZeusTransformUtils.preCheckCast(new kotlinx.serialization.json.k(r2, r3), kotlinx.serialization.json.r.class, "com.obric.memorydata.plugin");
    L14:
        return (kotlinx.serialization.json.r) r4;
    L11:
        if (Intrinsics.areEqual(r2, "null") == false) goto L15;
        r4 = ZeusTransformUtils.preCheckCast(kotlinx.serialization.json.n.f17858a, kotlinx.serialization.json.r.class, "com.obric.memorydata.plugin");
    L7:
        r2 = this.f17849a.i();
        goto L9
    }

    private final kotlinx.serialization.json.g b() {
        byte r0 = this.f17849a.a((byte) 6);
        if (this.f17849a.e() == 4) goto L24;
        LinkedHashMap r2 = new LinkedHashMap();
    L6:
        if (this.f17849a.c() == false) goto L17;
        if (this.f17850b == false) goto L10;
        String r1 = this.f17849a.i();
    L11:
        this.f17849a.a((byte) 5);
        kotlinx.serialization.json.g r4 = a();
        ((Map) ZeusTransformUtils.preCheckCast(r2, Map.class, "com.obric.memorydata.plugin")).put(r1, r4);
        r0 = this.f17849a.d();
        if (r0 == 4) goto L6;
        if (r0 == 7) goto L17;
        a.a(this.f17849a, "Expected end of the object or comma", 0, null, 6, null);
        throw new KotlinNothingValueException();
    L10:
        r1 = this.f17849a.h();
    L17:
        if (r0 != 6) goto L19;
        this.f17849a.a((byte) 7);
    L21:
        return (kotlinx.serialization.json.g) ZeusTransformUtils.preCheckCast(new kotlinx.serialization.json.p((Map) ZeusTransformUtils.preCheckCast(r2, Map.class, "com.obric.memorydata.plugin")), kotlinx.serialization.json.g.class, "com.obric.memorydata.plugin");
    L19:
        if (r0 != 4) goto L21;
        a.a(this.f17849a, "Unexpected trailing comma", 0, null, 6, null);
        throw new KotlinNothingValueException();
    L24:
        a.a(this.f17849a, "Unexpected leading comma", 0, null, 6, null);
        throw new KotlinNothingValueException();
    }

    public static final /* synthetic */ kotlinx.serialization.json.g b(p r0) {
        return r0.c();
    }

    private final kotlinx.serialization.json.g c() {
        byte r0 = this.f17849a.d();
        if (this.f17849a.e() == 4) goto L26;
        ArrayList r1 = new ArrayList();
    L6:
        if (this.f17849a.c() == false) goto L19;
        r1.add(a());
        r0 = this.f17849a.d();
        if (r0 == 4) goto L6;
        a r5 = this.f17849a;
        if (r0 != 9) goto L12;
        boolean r3 = true;
    L13:
        int r7 = a.a(r5);
        if (r3 == true) goto L6;
        a.a(r5, "Expected end of the array or comma", r7, null, 4, null);
        throw new KotlinNothingValueException();
    L12:
        r3 = false;
        goto L13
    L19:
        if (r0 != 8) goto L21;
        this.f17849a.a((byte) 9);
    L23:
        return (kotlinx.serialization.json.g) ZeusTransformUtils.preCheckCast(new kotlinx.serialization.json.b((List) ZeusTransformUtils.preCheckCast(r1, List.class, "com.obric.memorydata.plugin")), kotlinx.serialization.json.g.class, "com.obric.memorydata.plugin");
    L21:
        if (r0 != 4) goto L23;
        a.a(this.f17849a, "Unexpected trailing comma", 0, null, 6, null);
        throw new KotlinNothingValueException();
    L26:
        a.a(this.f17849a, "Unexpected leading comma", 0, null, 6, null);
        throw new KotlinNothingValueException();
    }

    private final kotlinx.serialization.json.g d() {
        return (kotlinx.serialization.json.g) ZeusTransformUtils.preCheckCast(DeepRecursiveKt.invoke(new DeepRecursiveFunction((Function3) ZeusTransformUtils.preCheckCast(new JsonTreeReader$readDeepRecursive$1(this, null), Function3.class, "com.obric.memorydata.plugin")), Unit.INSTANCE), kotlinx.serialization.json.g.class, "com.obric.memorydata.plugin");
    }

    public final kotlinx.serialization.json.g a() {
        byte r0 = this.f17849a.e();
        if (r0 != 1) goto L6;
        kotlinx.serialization.json.r r6 = a(true);
    L21:
        return (kotlinx.serialization.json.g) ZeusTransformUtils.preCheckCast(r6, kotlinx.serialization.json.g.class, "com.obric.memorydata.plugin");
    L6:
        if (r0 != 0) goto L9;
        r6 = a(false);
        goto L21
    L9:
        if (r0 != 6) goto L16;
        int r1 = this.c + 1;
        this.c = r1;
        if (r1 != 200) goto L13;
        kotlinx.serialization.json.g r2 = d();
    L14:
        this.c--;
        return r2;
    L13:
        r2 = b();
        goto L14
    L16:
        if (r0 == 8) goto L18;
        a.a(this.f17849a, "Cannot begin reading element, unexpected token: " + r0, 0, null, 6, null);
        throw new KotlinNothingValueException();
    L18:
        return c();
    }
}
