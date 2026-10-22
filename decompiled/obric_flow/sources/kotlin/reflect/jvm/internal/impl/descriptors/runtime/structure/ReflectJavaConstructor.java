package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Member;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaConstructor;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaValueParameter;

/* JADX INFO: loaded from: classes3.dex */
@SourceDebugExtension({"SMAP\nReflectJavaConstructor.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ReflectJavaConstructor.kt\norg/jetbrains/kotlin/descriptors/runtime/structure/ReflectJavaConstructor\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,51:1\n11335#2:52\n11670#2,3:53\n*S KotlinDebug\n*F\n+ 1 ReflectJavaConstructor.kt\norg/jetbrains/kotlin/descriptors/runtime/structure/ReflectJavaConstructor\n*L\n49#1:52\n49#1:53,3\n*E\n"})
public final class ReflectJavaConstructor extends ReflectJavaMember implements JavaConstructor {
    private final Constructor<?> member;

    public ReflectJavaConstructor(Constructor<?> r5) {
        Intrinsics.checkNotNullParameter(r5, "member");
        this.member = r5;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaMember
    public Constructor<?> getMember() {
        return this.member;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaTypeParameterListOwner
    public List<ReflectJavaTypeParameter> getTypeParameters() {
        TypeVariable<Constructor<?>>[] r5 = getMember().getTypeParameters();
        ArrayList r10 = new ArrayList(r5.length);
        int r11 = r5.length;
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L5;
        r10.add(new ReflectJavaTypeParameter(r5[r12]));
        r12 = r12 + 1;
        goto L3
    L5:
        return r10;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaConstructor
    public List<JavaValueParameter> getValueParameters() {
        Type[] r5 = getMember().getGenericParameterTypes();
        if (r5.length == 0) goto L5;
        Class<?> r10 = getMember().getDeclaringClass();
        if (r10.getDeclaringClass() != null) goto L9;
    L11:
        Annotation[][] r11 = getMember().getParameterAnnotations();
        if (r11.length < r5.length) goto L19;
        if (r11.length <= r5.length) goto L17;
        r11 = (Annotation[][]) ArraysKt.copyOfRange(r11, r11.length - r5.length, r11.length);
    L17:
        return getValueParameters(r5, r11, getMember().isVarArgs());
    L19:
        throw new IllegalStateException("Illegal generic signature: " + getMember());
    L9:
        if (Modifier.isStatic(r10.getModifiers()) == true) goto L11;
        r5 = (Type[]) ArraysKt.copyOfRange(r5, 1, r5.length);
        goto L11
    L5:
        return CollectionsKt.emptyList();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaMember
    public /* bridge */ /* synthetic */ Member getMember() {
        return getMember();
    }
}
