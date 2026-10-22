package com.obric.flow.cardlistpage.data;

import com.obric.flow.cardlistpage.base.BaseCardModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.reflect.KClass;
import kotlin.text.StringsKt;
import kotlinx.serialization.json.b0;
import kotlinx.serialization.json.u;
import kotlinx.serialization.json.x;

/* JADX INFO: loaded from: classes3.dex */
public abstract class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final kotlinx.serialization.json.p f11498a = null;

    static {
        CardEntityMapperKt$cardEntityJson$1 r5 = CardEntityMapperKt$cardEntityJson$1.INSTANCE;
        kotlinx.serialization.json.a r10 = kotlinx.serialization.json.b.d;
        Intrinsics.checkNotNullParameter(r10, "from");
        Intrinsics.checkNotNullParameter(r5, "builderAction");
        Intrinsics.checkNotNullParameter(r10, "json");
        kotlinx.serialization.json.g r11 = new kotlinx.serialization.json.g();
        kotlinx.serialization.json.i r12 = r10.f19384a;
        r11.f19395a = r12.f19405a;
        r11.f19396b = r12.f;
        r11.f19397c = r12.f19406b;
        r11.d = r12.f19407c;
        r11.e = r12.d;
        boolean r13 = r12.e;
        r11.f = r13;
        String r14 = r12.g;
        r11.g = r14;
        r11.f19398h = r12.f19408h;
        boolean r15 = r12.f19409i;
        r11.f19399i = r15;
        String r16 = r12.f19410j;
        r11.f19400j = r16;
        r11.f19401k = r12.f19411k;
        r11.f19402l = r12.f19412l;
        r11.f19403m = r12.f19413m;
        r11.f19404n = r10.f19385b;
        r5.invoke(r11);
        if (r15 == false) goto L10;
        if (Intrinsics.areEqual(r16, "type") == true) goto L10;
        throw new IllegalArgumentException("Class discriminator should not be specified when array polymorphism is specified");
    L10:
        if (r13 == true) goto L17;
        if (Intrinsics.areEqual(r14, "    ") == false) goto L15;
    L33:
        boolean r17 = r11.f19397c;
        boolean r18 = r11.f19403m;
        boolean r19 = r11.f19395a;
        boolean r20 = r11.d;
        boolean r110 = r11.e;
        boolean r111 = r11.f;
        boolean r112 = r11.f19396b;
        String r113 = r11.g;
        boolean r114 = r11.f19398h;
        boolean r21 = r11.f19399i;
        String r22 = r11.f19400j;
        kotlinx.serialization.json.i r23 = new kotlinx.serialization.json.i(r19, r17, r20, r110, r111, r112, r113, r114, r21, r22, r11.f19401k, r11.f19402l, r18);
        jk.a r24 = r11.f19404n;
        Intrinsics.checkNotNullParameter(r23, "configuration");
        Intrinsics.checkNotNullParameter(r24, "module");
        kotlinx.serialization.json.p r25 = new kotlinx.serialization.json.p(r23, r24);
        if (Intrinsics.areEqual(r24, kotlinx.serialization.modules.b.f19457a) == true) goto L85;
        am.e r26 = new am.e(r21, r22);
        r24.getClass();
        Intrinsics.checkNotNullParameter(r26, "collector");
        Iterator r27 = ((Map) r24.f18349a).entrySet().iterator();
    L38:
        if (r27.hasNext() == false) goto L44;
        Map.Entry r28 = (Map.Entry) r27.next();
        KClass r29 = (KClass) r28.getKey();
        if (r28.getValue() == null) goto L38;
        throw new ClassCastException();
    L44:
        Iterator r30 = ((Map) r24.f18350b).entrySet().iterator();
    L46:
        if (r30.hasNext() == false) goto L77;
        Map.Entry r31 = (Map.Entry) r30.next();
        KClass r32 = (KClass) r31.getKey();
        Iterator r33 = ((Map) r31.getValue()).entrySet().iterator();
    L49:
        if (r33.hasNext() == false) goto L46;
        Map.Entry r34 = (Map.Entry) r33.next();
        KClass r115 = (KClass) r34.getKey();
        kotlinx.serialization.c r35 = (kotlinx.serialization.c) r34.getValue();
        Intrinsics.checkNotNull(r32, "null cannot be cast to non-null type kotlin.reflect.KClass<kotlin.Any>");
        Intrinsics.checkNotNull(r115, "null cannot be cast to non-null type kotlin.reflect.KClass<kotlin.Any>");
        Intrinsics.checkNotNull(r35, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
        Intrinsics.checkNotNullParameter(r32, "baseClass");
        Intrinsics.checkNotNullParameter(r115, "actualClass");
        Intrinsics.checkNotNullParameter(r35, "actualSerializer");
        kotlinx.serialization.descriptors.g r36 = r35.getDescriptor();
        kotlinx.serialization.descriptors.k r116 = r36.getKind();
        if ((r116 instanceof kotlinx.serialization.descriptors.d) == true) goto L76;
        if (Intrinsics.areEqual(r116, kotlinx.serialization.descriptors.l.f19241b) == true) goto L76;
        boolean r117 = r26.f324a;
        if (r117 == false) goto L58;
    L65:
        if (r117 == true) goto L49;
        int r118 = r36.d();
        int r119 = 0;
    L67:
        if (r119 >= r118) goto L49;
        String r120 = r36.e(r119);
        if (Intrinsics.areEqual(r120, r26.f325b) == true) goto L72;
        r119 = r119 + 1;
        goto L67
    L72:
        throw new IllegalArgumentException("Polymorphic serializer for " + r115 + " has property '" + r120 + "' that conflicts with JSON class discriminator. You can either change class discriminator in JsonConfiguration, rename property with @SerialName annotation or fall back to array polymorphism");
    L58:
        if (Intrinsics.areEqual(r116, kotlinx.serialization.descriptors.n.f19244c) == true) goto L74;
        if (Intrinsics.areEqual(r116, kotlinx.serialization.descriptors.n.d) == true) goto L74;
        if ((r116 instanceof kotlinx.serialization.descriptors.f) == true) goto L74;
        if ((r116 instanceof kotlinx.serialization.descriptors.m) == false) goto L65;
    L74:
        throw new IllegalArgumentException("Serializer for " + r115.getSimpleName() + " of kind " + r116 + " cannot be serialized polymorphically with class discriminator.");
    L76:
        throw new IllegalArgumentException("Serializer for " + r115.getSimpleName() + " can't be registered as a subclass for polymorphic serialization because its kind " + r116 + " is not concrete. To work with multiple hierarchies, register it as a base class.");
    L77:
        Iterator r37 = ((Map) r24.f18351c).entrySet().iterator();
    L79:
        if (r37.hasNext() == false) goto L81;
        Map.Entry r38 = (Map.Entry) r37.next();
        KClass r39 = (KClass) r38.getKey();
        Function1 r40 = (Function1) r38.getValue();
        Intrinsics.checkNotNull(r39, "null cannot be cast to non-null type kotlin.reflect.KClass<kotlin.Any>");
        Intrinsics.checkNotNull(r40, "null cannot be cast to non-null type kotlin.Function1<@[ParameterName(name = 'value')] kotlin.Any, kotlinx.serialization.SerializationStrategy<kotlin.Any>?>{ kotlinx.serialization.modules.SerializersModuleKt.PolymorphicSerializerProvider<kotlin.Any> }");
        Function1 r41 = (Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(r40, 1);
        Intrinsics.checkNotNullParameter(r39, "baseClass");
        Intrinsics.checkNotNullParameter(r41, "defaultSerializerProvider");
        goto L79
    L81:
        Iterator r42 = ((Map) r24.e).entrySet().iterator();
    L83:
        if (r42.hasNext() == false) goto L85;
        Map.Entry r43 = (Map.Entry) r42.next();
        KClass r44 = (KClass) r43.getKey();
        Function1 r45 = (Function1) r43.getValue();
        Intrinsics.checkNotNull(r44, "null cannot be cast to non-null type kotlin.reflect.KClass<kotlin.Any>");
        Intrinsics.checkNotNull(r45, "null cannot be cast to non-null type kotlin.Function1<@[ParameterName(name = 'className')] kotlin.String?, kotlinx.serialization.DeserializationStrategy<out kotlin.Any>?>{ kotlinx.serialization.modules.SerializersModuleKt.PolymorphicDeserializerProvider<out kotlin.Any> }");
        Function1 r46 = (Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(r45, 1);
        Intrinsics.checkNotNullParameter(r44, "baseClass");
        Intrinsics.checkNotNullParameter(r46, "defaultDeserializerProvider");
    L85:
        f11498a = r25;
        return;
    L15:
        throw new IllegalArgumentException("Indent should not be specified when default printing mode is used");
    L17:
        if (Intrinsics.areEqual(r14, "    ") == true) goto L33;
        int r47 = 0;
    L20:
        if (r47 >= r14.length()) goto L33;
        char r48 = r14.charAt(r47);
        if (r48 == ' ') goto L32;
        if (r48 == '\t') goto L32;
        if (r48 == '\r') goto L32;
        if (r48 == '\n') goto L32;
        throw new IllegalArgumentException("Only whitespace, tab, newline and carriage return are allowed as pretty print symbols. Had ".concat(r14).toString());
    L32:
        r47 = r47 + 1;
        goto L20
    }

    public static j a(BaseCardModel r22, Long r23, int r24) {
        if ((r24 & 1) == 0) goto L5;
        Long r12 = r22.getCreateTime();
    L6:
        Long r13 = r22.getModifyTime();
        Intrinsics.checkNotNullParameter(r22, "<this>");
        if ((r22 instanceof MiniAppWidgetCardModel) == false) goto L9;
        MiniAppWidgetCardModel r5 = (MiniAppWidgetCardModel) r22;
    L10:
        String r10 = r22.getId();
        String r11 = r22.getOriginalId();
        String r14 = r22.getType().name();
        String r15 = r22.getTitle();
        String r16 = r22.getDescription();
        int r17 = r22.getSpanX();
        int r18 = r22.getSpanY();
        boolean r19 = r22.isVisible();
        Integer r110 = r22.getSortIndex();
        if (r5 == null) goto L15;
        String r20 = r5.getInstanceId();
        if (r20 == null) goto L15;
        Integer r111 = StringsKt.toIntOrNull(r20);
    L16:
        if (r5 == null) goto L18;
        String r112 = r5.getAppletId();
    L19:
        if (r5 == null) goto L21;
        String r113 = r5.getWidgetId();
    L22:
        if (r5 == null) goto L24;
        String r114 = r5.getDefinitionId();
    L25:
        if (r5 == null) goto L29;
        Map<String, String> r21 = r5.getConfig();
        if (r21 == null) goto L29;
        String r115 = c(r21);
    L30:
        if (r5 == null) goto L34;
        Map<String, String> r25 = r5.getExtras();
        if (r25 == null) goto L34;
        String r116 = c(r25);
    L36:
        return new j(r10, r11, r14, r15, r16, r17, r18, r19, r110, r12, r13, r111, r112, r113, r114, r115, r116, null);
    L34:
        r116 = null;
    L29:
        r115 = null;
        goto L30
    L24:
        r114 = null;
        goto L25
    L21:
        r113 = null;
        goto L22
    L18:
        r112 = null;
    L15:
        r111 = null;
        goto L16
    L9:
        r5 = null;
        goto L10
    L5:
        r12 = r23;
        goto L6
    }

    public static final x b(String r5) {
        Object r10 = null;
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L9
        kotlinx.serialization.json.l r12 = f11498a.a(r5);     // Catch: Throwable -> L9
        int r13 = kotlinx.serialization.json.m.f19441a;     // Catch: Throwable -> L9
        Intrinsics.checkNotNullParameter(r12, "<this>");     // Catch: Throwable -> L9
        if ((r12 instanceof x) == false) goto L6;
        x r14 = (x) r12;     // Catch: Throwable -> L9
    L7:
        if (r14 == null) goto L11;
        Object r15 = Result.m124constructorimpl(r14);     // Catch: Throwable -> L9
    L15:
        if (Result.m130isFailureimpl(r15) == true) goto L19;
        r10 = r15;
    L19:
        return (x) r10;
    L11:
        kotlinx.serialization.json.m.a(r12, "JsonObject");     // Catch: Throwable -> L9
        throw null;     // Catch: Throwable -> L9
    L6:
        r14 = null;
    L9:
        th = move-exception;
        Result.Companion r16 = Result.Companion;
        r15 = Result.m124constructorimpl(ResultKt.createFailure(th));
        goto L15
    }

    public static final String c(Map r5) {
        LinkedHashMap r10 = new LinkedHashMap(MapsKt.mapCapacity(r5.size()));
        Iterator r11 = r5.entrySet().iterator();
    L4:
        if (r11.hasNext() == false) goto L11;
        Map.Entry r12 = (Map.Entry) r11.next();
        Object r13 = r12.getKey();
        String r14 = (String) r12.getValue();
        int r15 = kotlinx.serialization.json.m.f19441a;
        if (r14 != null) goto L8;
        b0 r16 = u.INSTANCE;
    L9:
        r10.put(r13, r16);
        goto L4
    L8:
        r16 = new kotlinx.serialization.json.q(r14, true);
        goto L9
    L11:
        return new x(r10).toString();
    }

    public static final Map d(x r5) {
        Map r10 = null;
        if (r5 == null) goto L19;
        ArrayList r11 = new ArrayList();
        Iterator r12 = r5.f19451a.entrySet().iterator();
    L6:
        if (r12.hasNext() == false) goto L18;
        Map.Entry r13 = (Map.Entry) r12.next();
        String r14 = (String) r13.getKey();
        kotlinx.serialization.json.l r15 = (kotlinx.serialization.json.l) r13.getValue();
        if ((r15 instanceof b0) == false) goto L10;
        b0 r16 = (b0) r15;
    L11:
        if (r16 == null) goto L15;
        String r17 = r16.b();
        if (r17 == null) goto L15;
        Pair r18 = TuplesKt.to(r14, r17);
    L16:
        if (r18 == null) goto L6;
        r11.add(r18);
    L15:
        r18 = null;
        goto L16
    L10:
        r16 = null;
        goto L11
    L18:
        r10 = MapsKt.toMap(r11);
    L19:
        if (r10 == null) goto L21;
        return r10;
    L21:
        return MapsKt.emptyMap();
    }
}
