package androidx.room.compiler.codegen;

import androidx.room.compiler.processing.XNullability;
import com.squareup.javapoet.e;
import com.squareup.javapoet.x;
import com.squareup.kotlinpoet.b0;
import kotlin.Metadata;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a\u0015\u0010\u0002\u001a\u00020\u0001*\u0006\u0012\u0002\b\u00030\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u001f\u0010\b\u001a\u00060\u0006j\u0002`\u00072\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0004H\u0002¢\u0006\u0004\b\b\u0010\t\u001a\u0017\u0010\u000b\u001a\u00020\n*\u0006\u0012\u0002\b\u00030\u0000H\u0000¢\u0006\u0004\b\u000b\u0010\f\u001a\u001f\u0010\u000f\u001a\u00060\rj\u0002`\u000e2\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0004H\u0002¢\u0006\u0004\b\u000f\u0010\u0010\u001a\u0015\u0010\u0011\u001a\u00060\rj\u0002`\u000e*\u00020\n¢\u0006\u0004\b\u0011\u0010\u0012\u001a\u0015\u0010\u0011\u001a\u00060\u0006j\u0002`\u0007*\u00020\u0001¢\u0006\u0004\b\u0011\u0010\u0013¨\u0006\u0014"}, d2 = {"Lkotlin/reflect/KClass;", "Landroidx/room/compiler/codegen/XClassName;", "asClassName", "(Lkotlin/reflect/KClass;)Landroidx/room/compiler/codegen/XClassName;", "Ljava/lang/Class;", "klass", "Lcom/squareup/javapoet/e;", "Lcom/squareup/kotlinpoet/javapoet/JClassName;", "getBoxedJClassName", "(Ljava/lang/Class;)Lcom/squareup/javapoet/e;", "Landroidx/room/compiler/codegen/XTypeName;", "asPrimitiveTypeName", "(Lkotlin/reflect/KClass;)Landroidx/room/compiler/codegen/XTypeName;", "Lcom/squareup/javapoet/x;", "Lcom/squareup/kotlinpoet/javapoet/JTypeName;", "getPrimitiveJTypeName", "(Ljava/lang/Class;)Lcom/squareup/javapoet/x;", "toJavaPoet", "(Landroidx/room/compiler/codegen/XTypeName;)Lcom/squareup/javapoet/x;", "(Landroidx/room/compiler/codegen/XClassName;)Lcom/squareup/javapoet/e;", "room-compiler-processing"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class XTypeNameKt {
    public static final XClassName asClassName(KClass<?> r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        if (JvmClassMappingKt.getJavaClass(r5).isPrimitive() == false) goto L5;
        e r10 = getBoxedJClassName(JvmClassMappingKt.getJavaClass(r5));
    L7:
        return new XClassName(r10, mh.e.s(r5), XNullability.NONNULL);
    L5:
        r10 = e.n(JvmClassMappingKt.getJavaClass(r5));
        goto L7
    }

    public static final XTypeName asPrimitiveTypeName(KClass<?> r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if (JvmClassMappingKt.getJavaClass(r10).isPrimitive() == false) goto L7;
        return XTypeName.Companion.invoke$default(XTypeName.Companion, getPrimitiveJTypeName(JvmClassMappingKt.getJavaClass(r10)), b0.a(r10), null, 4, null);
    L7:
        throw new IllegalArgumentException((r10 + " does not represent a primitive.").toString());
    }

    private static final e getBoxedJClassName(Class<?> r5) {
        if (Intrinsics.areEqual(r5, Void.TYPE) == false) goto L6;
        x r10 = x.d.b();
    L29:
        Intrinsics.checkNotNull(r10, "null cannot be cast to non-null type com.squareup.javapoet.ClassName{ com.squareup.kotlinpoet.javapoet.TypeAliasesKt.JClassName }");
        return (e) r10;
    L6:
        if (Intrinsics.areEqual(r5, Boolean.TYPE) == false) goto L9;
        r10 = x.e.b();
        goto L29
    L9:
        if (Intrinsics.areEqual(r5, Byte.TYPE) == false) goto L12;
        r10 = x.f.b();
        goto L29
    L12:
        if (Intrinsics.areEqual(r5, Short.TYPE) == false) goto L15;
        r10 = x.g.b();
        goto L29
    L15:
        if (Intrinsics.areEqual(r5, Integer.TYPE) == false) goto L18;
        r10 = x.f15023h.b();
        goto L29
    L18:
        if (Intrinsics.areEqual(r5, Long.TYPE) == false) goto L21;
        r10 = x.f15024i.b();
        goto L29
    L21:
        if (Intrinsics.areEqual(r5, Character.TYPE) == false) goto L24;
        r10 = x.f15025j.b();
        goto L29
    L24:
        if (Intrinsics.areEqual(r5, Float.TYPE) == false) goto L27;
        r10 = x.f15026k.b();
        goto L29
    L27:
        if (Intrinsics.areEqual(r5, Double.TYPE) == false) goto L32;
        r10 = x.f15027l.b();
        goto L29
    L32:
        throw new IllegalStateException(("Can't get JTypeName from java.lang.Class: " + r5).toString());
    }

    private static final x getPrimitiveJTypeName(Class<?> r5) {
        if (Intrinsics.areEqual(r5, Void.TYPE) == false) goto L6;
        return x.d;
    L6:
        if (Intrinsics.areEqual(r5, Boolean.TYPE) == false) goto L9;
        return x.e;
    L9:
        if (Intrinsics.areEqual(r5, Byte.TYPE) == false) goto L12;
        return x.f;
    L12:
        if (Intrinsics.areEqual(r5, Short.TYPE) == false) goto L15;
        return x.g;
    L15:
        if (Intrinsics.areEqual(r5, Integer.TYPE) == false) goto L18;
        return x.f15023h;
    L18:
        if (Intrinsics.areEqual(r5, Long.TYPE) == false) goto L21;
        return x.f15024i;
    L21:
        if (Intrinsics.areEqual(r5, Character.TYPE) == false) goto L24;
        return x.f15025j;
    L24:
        if (Intrinsics.areEqual(r5, Float.TYPE) == false) goto L27;
        return x.f15026k;
    L27:
        if (Intrinsics.areEqual(r5, Double.TYPE) == false) goto L31;
        return x.f15027l;
    L31:
        throw new IllegalStateException(("Can't get JTypeName from java.lang.Class: " + r5).toString());
    }

    public static final x toJavaPoet(XTypeName r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return r5.getJava$room_compiler_processing();
    }

    public static final e toJavaPoet(XClassName r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return r5.getJava$room_compiler_processing();
    }
}
