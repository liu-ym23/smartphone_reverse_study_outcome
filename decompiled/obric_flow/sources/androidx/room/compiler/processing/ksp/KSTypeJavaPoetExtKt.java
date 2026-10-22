package androidx.room.compiler.processing.ksp;

import androidx.room.compiler.processing.JavaPoetExtKt;
import com.google.devtools.ksp.symbol.Variance;
import com.squareup.javapoet.a0;
import com.squareup.javapoet.b0;
import com.squareup.javapoet.c;
import com.squareup.javapoet.e;
import com.squareup.javapoet.v;
import com.squareup.javapoet.x;
import hl.d;
import il.i;
import il.p;
import il.q;
import il.r;
import il.s;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a!\u0010\u0005\u001a\u00060\u0003j\u0002`\u0004*\u0004\u0018\u00010\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001a=\u0010\u0005\u001a\u00060\u0003j\u0002`\u0004*\u0004\u0018\u00010\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u001a\u0010\n\u001a\u0016\u0012\u0004\u0012\u00020\b\u0012\b\u0012\u00060\u0003j\u0002`\u00040\u0007j\u0002`\tH\u0002¢\u0006\u0004\b\u0005\u0010\u000b\u001a\u001f\u0010\u0005\u001a\u00060\u0003j\u0002`\u0004*\u00020\f2\u0006\u0010\u0002\u001a\u00020\u0001H\u0000¢\u0006\u0004\b\u0005\u0010\r\u001a;\u0010\u0005\u001a\u00060\u0003j\u0002`\u0004*\u00020\f2\u0006\u0010\u0002\u001a\u00020\u00012\u001a\u0010\n\u001a\u0016\u0012\u0004\u0012\u00020\b\u0012\b\u0012\u00060\u0003j\u0002`\u00040\u0007j\u0002`\tH\u0002¢\u0006\u0004\b\u0005\u0010\u000e\u001a\u001f\u0010\u0005\u001a\u00060\u0003j\u0002`\u0004*\u00020\u000f2\u0006\u0010\u0002\u001a\u00020\u0001H\u0000¢\u0006\u0004\b\u0005\u0010\u0010\u001a;\u0010\u0005\u001a\u00060\u0003j\u0002`\u0004*\u00020\u00112\u0006\u0010\u0002\u001a\u00020\u00012\u001a\u0010\n\u001a\u0016\u0012\u0004\u0012\u00020\b\u0012\b\u0012\u00060\u0003j\u0002`\u00040\u0007j\u0002`\tH\u0002¢\u0006\u0004\b\u0005\u0010\u0012\u001a;\u0010\u0005\u001a\u00060\u0003j\u0002`\u0004*\u00020\u000f2\u0006\u0010\u0002\u001a\u00020\u00012\u001a\u0010\n\u001a\u0016\u0012\u0004\u0012\u00020\b\u0012\b\u0012\u00060\u0003j\u0002`\u00040\u0007j\u0002`\tH\u0002¢\u0006\u0004\b\u0005\u0010\u0013\u001a\u001f\u0010\u0005\u001a\u00060\u0003j\u0002`\u0004*\u00020\u00142\u0006\u0010\u0002\u001a\u00020\u0001H\u0000¢\u0006\u0004\b\u0005\u0010\u0015\u001a;\u0010\u0005\u001a\u00060\u0003j\u0002`\u0004*\u00020\u00142\u0006\u0010\u0002\u001a\u00020\u00012\u001a\u0010\n\u001a\u0016\u0012\u0004\u0012\u00020\b\u0012\b\u0012\u00060\u0003j\u0002`\u00040\u0007j\u0002`\tH\u0002¢\u0006\u0004\b\u0005\u0010\u0016\u001a'\u0010\u0018\u001a\f\u0012\b\u0012\u00060\u0003j\u0002`\u00040\u0017*\f\u0012\b\u0012\u00060\u0003j\u0002`\u00040\u0017H\u0002¢\u0006\u0004\b\u0018\u0010\u0019\u001a-\u0010\u001f\u001a\u00060\u001dj\u0002`\u001e2\u0006\u0010\u001b\u001a\u00020\u001a2\u0010\u0010\u001c\u001a\f\u0012\b\u0012\u00060\u0003j\u0002`\u00040\u0017H\u0002¢\u0006\u0004\b\u001f\u0010 \"\"\u0010#\u001a\n \"*\u0004\u0018\u00010!0!8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\"S\u0010,\u001a:\u0012\u0016\u0012\u0014 \"*\n\u0018\u00010\u001dj\u0004\u0018\u0001`\u001e0\u001dj\u0002`\u001e \"*\u001c\u0012\u0016\u0012\u0014 \"*\n\u0018\u00010\u001dj\u0004\u0018\u0001`\u001e0\u001dj\u0002`\u001e\u0018\u00010'0'8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+*(\b\u0002\u0010.\"\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u0002`\u0004`-2\u0012\u0012\u0004\u0012\u00020\b\u0012\b\u0012\u00060\u0003j\u0002`\u00040\u0007¨\u0006/"}, d2 = {"Lil/s;", "Lhl/d;", "resolver", "Lcom/squareup/javapoet/x;", "Lcom/squareup/kotlinpoet/javapoet/JTypeName;", "asJTypeName", "(Lil/s;Lhl/d;)Lcom/squareup/javapoet/x;", "Ljava/util/LinkedHashMap;", "Lil/i;", "Landroidx/room/compiler/processing/ksp/JTypeArgumentTypeLookup;", "typeArgumentTypeLookup", "(Lil/s;Lhl/d;Ljava/util/LinkedHashMap;)Lcom/squareup/javapoet/x;", "Lil/d;", "(Lil/d;Lhl/d;)Lcom/squareup/javapoet/x;", "(Lil/d;Lhl/d;Ljava/util/LinkedHashMap;)Lcom/squareup/javapoet/x;", "Lil/q;", "(Lil/q;Lhl/d;)Lcom/squareup/javapoet/x;", "Lil/r;", "(Lil/r;Lhl/d;Ljava/util/LinkedHashMap;)Lcom/squareup/javapoet/x;", "(Lil/q;Lhl/d;Ljava/util/LinkedHashMap;)Lcom/squareup/javapoet/x;", "Lil/p;", "(Lil/p;Lhl/d;)Lcom/squareup/javapoet/x;", "(Lil/p;Lhl/d;Ljava/util/LinkedHashMap;)Lcom/squareup/javapoet/x;", "", "convertToSuspendSignature", "(Ljava/util/List;)Ljava/util/List;", "", "name", "bounds", "Lcom/squareup/javapoet/a0;", "Lcom/squareup/kotlinpoet/javapoet/JTypeVariableName;", "createModifiableTypeVariableName", "(Ljava/lang/String;Ljava/util/List;)Lcom/squareup/javapoet/a0;", "Lcom/squareup/javapoet/e;", "kotlin.jvm.PlatformType", "ERROR_JTYPE_NAME", "Lcom/squareup/javapoet/e;", "getERROR_JTYPE_NAME", "()Lcom/squareup/javapoet/e;", "Ljava/lang/reflect/Constructor;", "typeVarNameConstructor$delegate", "Lkotlin/Lazy;", "getTypeVarNameConstructor", "()Ljava/lang/reflect/Constructor;", "typeVarNameConstructor", "Lkotlin/collections/LinkedHashMap;", "JTypeArgumentTypeLookup", "room-compiler-processing"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class KSTypeJavaPoetExtKt {
    private static final e ERROR_JTYPE_NAME = null;
    private static final Lazy typeVarNameConstructor$delegate = null;

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r5 = new int[Variance.values().length];
            r5[Variance.CONTRAVARIANT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r5[Variance.COVARIANT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r5[Variance.STAR.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            $EnumSwitchMapping$0 = r5;
        }
    }

    static {
        ERROR_JTYPE_NAME = e.o("error", "NonExistentClass", new String[0]);
        typeVarNameConstructor$delegate = LazyKt.lazy(KSTypeJavaPoetExtKt$typeVarNameConstructor$2.INSTANCE);
    }

    public static final /* synthetic */ x access$asJTypeName(s r5, d r10, LinkedHashMap r11) {
        return asJTypeName(r5, r10, r11);
    }

    public static final x asJTypeName(s r5, d r10) {
        Intrinsics.checkNotNullParameter(r10, "resolver");
        return asJTypeName(r5, r10, new LinkedHashMap());
    }

    private static final x asJTypeName$resolveTypeName(q r5, d r10, LinkedHashMap<i, x> r11) {
        return JavaPoetExtKt.tryBox(asJTypeName(r5.getType(), r10, r11));
    }

    private static final List<x> convertToSuspendSignature(List<? extends x> r5) {
        List<? extends x> r10 = r5.subList(0, r5.size() - 1);
        b0 r11 = b0.p((x) CollectionsKt.last(r5));
        return CollectionsKt.plus(r10, CollectionsKt.listOf(new b0[]{b0.p(v.n(e.n(Continuation.class), new x[]{r11})), b0.o(x.f15028m)}));
    }

    private static final a0 createModifiableTypeVariableName(String r5, List<? extends x> r10) {
        a0 r11 = getTypeVarNameConstructor().newInstance(new Object[]{r5, r10});
        Intrinsics.checkNotNull(r11, "null cannot be cast to non-null type com.squareup.javapoet.TypeVariableName{ com.squareup.kotlinpoet.javapoet.TypeAliasesKt.JTypeVariableName }");
        return r11;
    }

    public static final e getERROR_JTYPE_NAME() {
        return ERROR_JTYPE_NAME;
    }

    private static final Constructor<a0> getTypeVarNameConstructor() {
        return (Constructor) typeVarNameConstructor$delegate.getValue();
    }

    private static final x asJTypeName(s r5, d r10, LinkedHashMap<i, x> r11) {
        if (r5 == null) goto L6;
        r5.resolve();
        return asJTypeName(null, r10, r11);
    L6:
        return ERROR_JTYPE_NAME;
    }

    public static final x asJTypeName(il.d r5, d r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "resolver");
        return asJTypeName(r5, r10, new LinkedHashMap());
    }

    private static final x asJTypeName(il.d r5, d r10, LinkedHashMap<i, x> r11) {
        r5.getQualifiedName();
        return ERROR_JTYPE_NAME;
    }

    public static final x asJTypeName(q r5, d r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "resolver");
        return asJTypeName(r5, r10, new LinkedHashMap());
    }

    private static final x asJTypeName(r r5, d r10, LinkedHashMap<i, x> r11) {
        r5.getName();
        x r12 = r11.get(null);
        if (r12 == null) goto L5;
        return r12;
    L5:
        new ArrayList();
        r5.getName();
        throw null;
    }

    private static final x asJTypeName(q r5, d r10, LinkedHashMap<i, x> r11) {
        Variance r12 = r5.getVariance();
        int r13 = WhenMappings.$EnumSwitchMapping$0[r12.ordinal()];
        if (r13 == 1) goto L15;
        if (r13 == 2) goto L19;
        if (r13 == 3) goto L18;
        if (KSTypeExtKt.hasJvmWildcardAnnotation(r5) == false) goto L17;
        return b0.o(asJTypeName$resolveTypeName(r5, r10, r11));
    L17:
        return asJTypeName$resolveTypeName(r5, r10, r11);
    L18:
        return b0.o(x.f15028m);
    L19:
        return b0.o(asJTypeName$resolveTypeName(r5, r10, r11));
    L15:
        return b0.p(asJTypeName$resolveTypeName(r5, r10, r11));
    }

    public static final x asJTypeName(p r5, d r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "resolver");
        return asJTypeName(r5, r10, new LinkedHashMap());
    }

    private static final x asJTypeName(p r5, d r10, LinkedHashMap<i, x> r11) {
        if (r5.getArguments().isEmpty() == false) goto L5;
    L25:
        r5.getDeclaration();
        return asJTypeName(null, r10, r11);
    L5:
        if (r10.a() == true) goto L25;
        List r12 = r5.getArguments();
        ArrayList r13 = new ArrayList(CollectionsKt.h(r12));
        Iterator r14 = r12.iterator();
    L8:
        if (r14.hasNext() == false) goto L10;
        r13.add(asJTypeName((q) r14.next(), r10, r11));
        goto L8
    L10:
        ArrayList r15 = new ArrayList(CollectionsKt.h(r13));
        Iterator r16 = r13.iterator();
    L12:
        if (r16.hasNext() == false) goto L14;
        r15.add(JavaPoetExtKt.tryBox((x) r16.next()));
        goto L12
    L14:
        List<x> r17 = r15;
        if (r5.b() == false) goto L17;
        r17 = convertToSuspendSignature(r15);
    L17:
        Object[] r18 = r17.toArray(new x[0]);
        Intrinsics.checkNotNull(r18, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        x[] r19 = (x[]) r18;
        r5.getDeclaration();
        x r20 = JavaPoetExtKt.tryBox(asJTypeName(null, r10, r11));
        if ((r20 instanceof c) == false) goto L21;
        return new c((x) ArraysKt.single(r19));
    L21:
        if ((r20 instanceof e) == false) goto L24;
        return v.n((e) r20, (x[]) Arrays.copyOf(r19, r19.length));
    L24:
        throw new IllegalStateException(("Unexpected type name for KSType: " + r20).toString());
    }
}
