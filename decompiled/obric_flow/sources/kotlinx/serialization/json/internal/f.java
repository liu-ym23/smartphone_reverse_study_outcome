package kotlinx.serialization.json.internal;

import ai.j0;
import androidx.room.jarjarred.org.stringtemplate.v4.STGroup;
import java.lang.annotation.Annotation;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.RangesKt;
import kotlin.reflect.KClass;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.json.b0;
import kotlinx.serialization.json.x;

/* JADX INFO: loaded from: classes3.dex */
public abstract class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g f19423a = null;

    static {
        f19423a = new g();
    }

    public static final JsonDecodingException a(Number r5, String r10, String r11) {
        Intrinsics.checkNotNullParameter(r5, "value");
        StringBuilder r12 = androidx.constraintlayout.motion.widget.a.D(r10, STGroup.DICT_KEY, r11, "output", "Unexpected special floating-point value ");
        r12.append(r5);
        r12.append(" with key ");
        r12.append(r10);
        r12.append(". By default, non-finite floating point values are prohibited because they do not conform JSON specification. It is possible to deserialize them using 'JsonBuilder.allowSpecialFloatingPointValues = true'\nCurrent output: ");
        r12.append(m(r11, -1));
        return d(-1, r12.toString());
    }

    public static final JsonEncodingException b(kotlinx.serialization.descriptors.g r5) {
        Intrinsics.checkNotNullParameter(r5, "keyDescriptor");
        return new JsonEncodingException("Value of type '" + r5.h() + "' can't be used in JSON as a key in the map. It should have either primitive or enum kind, but its kind is '" + r5.getKind() + "'.\nUse 'allowStructuredMapKeys = true' in 'Json {}' builder to convert such maps to [key1, value1, key2, value2,...] arrays.");
    }

    public static final JsonDecodingException c(int r5, CharSequence r10, String r11) {
        Intrinsics.checkNotNullParameter(r11, "message");
        Intrinsics.checkNotNullParameter(r10, "input");
        return d(r5, r11 + "\nJSON input: " + m(r10, r5));
    }

    public static final JsonDecodingException d(int r5, String r10) {
        Intrinsics.checkNotNullParameter(r10, "message");
        if (r5 < 0) goto L6;
        r10 = "Unexpected JSON token at offset " + r5 + ": " + r10;
    L6:
        return new JsonDecodingException(r10);
    }

    public static final void e(LinkedHashMap r5, kotlinx.serialization.descriptors.g r10, String r11, int r12) {
        if (Intrinsics.areEqual(r10.getKind(), kotlinx.serialization.descriptors.m.f19242b) == false) goto L5;
        String r13 = "enum value";
    L7:
        if (r5.containsKey(r11) == true) goto L11;
        r5.put(r11, Integer.valueOf(r12));
        return;
    L11:
        throw new JsonException("The suggested name '" + r11 + "' for " + r13 + ' ' + r10.e(r12) + " is already one of the names for " + r13 + ' ' + r10.e(((Number) MapsKt.getValue(r5, r11)).intValue()) + " in " + r10);
    L5:
        r13 = "property";
        goto L7
    }

    public static final kotlinx.serialization.descriptors.g f(kotlinx.serialization.descriptors.g r5, jk.a r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "module");
        if (Intrinsics.areEqual(r5.getKind(), kotlinx.serialization.descriptors.l.f19241b) == false) goto L12;
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r5, "descriptor");
        KClass r11 = kotlinx.serialization.descriptors.k.d(r5);
        if (r11 == null) goto L15;
        List r12 = CollectionsKt.emptyList();
        r10.getClass();
        Intrinsics.checkNotNullParameter(r11, "kClass");
        Intrinsics.checkNotNullParameter(r12, "typeArgumentsSerializers");
        if (((Map) r10.f18349a).get(r11) != null) goto L10;
        return r5;
    L10:
        throw new ClassCastException();
    L15:
        return r5;
    L12:
        if (r5.isInline() == true) goto L14;
        return r5;
    L14:
        return f(r5.g(0), r10);
    }

    public static final byte g(char r5) {
        if (r5 < '~') goto L7;
        return 0;
    L7:
        return c.f19418b[r5];
    }

    public static final String h(kotlinx.serialization.descriptors.g r5, kotlinx.serialization.json.b r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "json");
        Iterator r11 = r5.getAnnotations().iterator();
    L4:
        if (r11.hasNext() == false) goto L10;
        Annotation r12 = (Annotation) r11.next();
        if ((r12 instanceof kotlinx.serialization.json.h) == false) goto L4;
        return ((kotlinx.serialization.json.h) r12).discriminator();
    L10:
        return r10.f19384a.f19410j;
    }

    public static final Object i(kotlinx.serialization.json.j r10, kotlinx.serialization.b r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "deserializer");
        if ((r11 instanceof kotlinx.serialization.internal.b) == false) goto L32;
        if (r10.C().f19384a.f19409i == true) goto L32;
        kotlinx.serialization.e r5 = (kotlinx.serialization.e) r11;
        String r12 = h(r5.getDescriptor(), r10.C());
        kotlinx.serialization.json.l r13 = r10.f();
        kotlinx.serialization.descriptors.g r14 = r5.getDescriptor();
        if ((r13 instanceof x) == false) goto L30;
        x r15 = (x) r13;
        kotlinx.serialization.json.l r16 = (kotlinx.serialization.json.l) r15.get(r12);
        String r17 = null;
        if (r16 == null) goto L19;
        int r18 = kotlinx.serialization.json.m.f19441a;
        Intrinsics.checkNotNullParameter(r16, "<this>");
        if ((r16 instanceof b0) == false) goto L14;
        b0 r19 = (b0) r16;
    L15:
        if (r19 == null) goto L17;
        r17 = r19.b();
        goto L19
    L17:
        kotlinx.serialization.json.m.a(r16, "JsonPrimitive");
        throw null;
    L14:
        r19 = null;
    L19:
        kotlinx.serialization.b r20 = ((kotlinx.serialization.internal.b) r11).b(r10, r17);
        if (r20 != null) goto L27;
        Intrinsics.checkNotNullParameter(r15, "jsonTree");
        if (r17 != null) goto L24;
        String r21 = "missing class discriminator ('null')";
    L26:
        throw c(-1, r15.toString(), j0.C("Polymorphic serializer was not found for ", r21));
    L24:
        r21 = androidx.room.jarjarred.org.antlr.runtime.a.p("class discriminator '", '\'', r17);
        goto L26
    L27:
        kotlinx.serialization.json.b r22 = r10.C();
        Intrinsics.checkNotNullParameter(r22, "<this>");
        Intrinsics.checkNotNullParameter(r12, "discriminator");
        Intrinsics.checkNotNullParameter(r15, "element");
        Intrinsics.checkNotNullParameter(r20, "deserializer");
        return new i(r22, r15, r12, r20.getDescriptor()).w(r20);
    L30:
        throw d(-1, "Expected " + Reflection.getOrCreateKotlinClass(x.class) + " as the serialized body of " + r14.h() + ", but had " + Reflection.getOrCreateKotlinClass(r13.getClass()));
    L32:
        return r11.a(r10);
    }

    public static final Map j(final kotlinx.serialization.descriptors.g r5, final kotlinx.serialization.json.b r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r5, "descriptor");
        Intrinsics.checkNotNullParameter(r10, "<this>");
        k6.a r11 = r10.f19386c;
        g r12 = f19423a;
        Function0<Map<String, ? extends Integer>> r13 = new JsonNamesMapKt$deserializationNamesMap$1(r5, r10);
        r11.getClass();
        Intrinsics.checkNotNullParameter(r5, "descriptor");
        Intrinsics.checkNotNullParameter(r12, STGroup.DICT_KEY);
        Intrinsics.checkNotNullParameter(r13, "defaultValue");
        Object r14 = r11.i(r5);
        if (r14 != null) goto L10;
        r14 = r13.invoke();
        Intrinsics.checkNotNullParameter(r5, "descriptor");
        Intrinsics.checkNotNullParameter(r12, STGroup.DICT_KEY);
        Intrinsics.checkNotNullParameter(r14, "value");
        ConcurrentHashMap r15 = (ConcurrentHashMap) r11.f18623a;
        Object r16 = r15.get(r5);
        if (r16 != null) goto L8;
        r16 = new ConcurrentHashMap(2);
        r15.put(r5, r16);
    L8:
        ((Map) r16).put(r12, r14);
    L10:
        return (Map) r14;
    }

    public static final int k(kotlinx.serialization.descriptors.g r5, kotlinx.serialization.json.b r10, String r11) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "json");
        Intrinsics.checkNotNullParameter(r11, "name");
        if (r10.f19384a.f19413m == true) goto L5;
    L10:
        n(r5, r10);
        int r12 = r5.c(r11);
        if (r12 == (-3)) goto L14;
        return r12;
    L14:
        if (r10.f19384a.f19412l == true) goto L16;
        return r12;
    L16:
        Integer r13 = (Integer) j(r5, r10).get(r11);
        if (r13 != null) goto L19;
        return -3;
    L19:
        return r13.intValue();
    L5:
        if (Intrinsics.areEqual(r5.getKind(), kotlinx.serialization.descriptors.m.f19242b) == false) goto L10;
        String r14 = r11.toLowerCase(Locale.ROOT);
        Integer r15 = (Integer) j(r5, r10).get(r14);
        if (r15 != null) goto L9;
        return -3;
    L9:
        return r15.intValue();
    }

    public static final int l(kotlinx.serialization.descriptors.g r5, kotlinx.serialization.json.b r10, String r11, String r12) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "json");
        Intrinsics.checkNotNullParameter(r11, "name");
        Intrinsics.checkNotNullParameter(r12, "suffix");
        int r13 = k(r5, r10, r11);
        if (r13 == (-3)) goto L6;
        return r13;
    L6:
        throw new SerializationException(r5.h() + " does not contain element with name '" + r11 + '\'' + r12);
    }

    public static final CharSequence m(CharSequence r5, int r10) {
        if (r5.length() >= 200) goto L5;
        return r5;
    L5:
        String r11 = ".....";
        if (r10 != (-1)) goto L12;
        int r12 = r5.length() - 60;
        if (r12 > 0) goto L11;
        return r5;
    L11:
        return "....." + r5.subSequence(r12, r5.length()).toString();
    L12:
        int r13 = r10 - 30;
        int r14 = r10 + 30;
        if (r13 > 0) goto L15;
        String r15 = "";
    L17:
        if (r14 < r5.length()) goto L19;
        r11 = "";
    L19:
        StringBuilder r16 = j0.u(r15);
        r16.append(r5.subSequence(RangesKt.coerceAtLeast(r13, 0), RangesKt.coerceAtMost(r14, r5.length())).toString());
        r16.append(r11);
        return r16.toString();
    L15:
        r15 = ".....";
        goto L17
    }

    public static final void n(kotlinx.serialization.descriptors.g r5, kotlinx.serialization.json.b r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "json");
        if (Intrinsics.areEqual(r5.getKind(), kotlinx.serialization.descriptors.n.f19243b) == false) goto L6;
        kotlinx.serialization.json.i r11 = r10.f19384a;
        return;
    }

    public static final void o(bi.e r5, Number r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "result");
        bi.e.q(r5, "Unexpected special floating-point value " + r10 + ". By default, non-finite floating point values are prohibited because they do not conform JSON specification", 0, "It is possible to deserialize them using 'JsonBuilder.allowSpecialFloatingPointValues = true'", 2);
        throw null;
    }

    public static final String p(byte r5) {
        if (r5 != 1) goto L6;
        return "quotation mark '\"'";
    L6:
        if (r5 != 2) goto L9;
        return "string escape sequence '\\'";
    L9:
        if (r5 != 4) goto L12;
        return "comma ','";
    L12:
        if (r5 != 5) goto L15;
        return "colon ':'";
    L15:
        if (r5 != 6) goto L18;
        return "start of the object '{'";
    L18:
        if (r5 != 7) goto L21;
        return "end of the object '}'";
    L21:
        if (r5 != 8) goto L24;
        return "start of the array '['";
    L24:
        if (r5 != 9) goto L27;
        return "end of the array ']'";
    L27:
        if (r5 != 10) goto L30;
        return "end of the input";
    L30:
        if (r5 != 127) goto L32;
        return "invalid token";
    L32:
        return "valid token";
    }
}
