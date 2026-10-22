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
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaConstructor;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaValueParameter;

/* JADX INFO: loaded from: classes3.dex */
public final class ReflectJavaConstructor extends ReflectJavaMember implements JavaConstructor {
    private final Constructor<?> member;

    public ReflectJavaConstructor(Constructor<?> r10) {
        Intrinsics.checkNotNullParameter(r10, "member");
        this.member = r10;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaMember
    public Constructor<?> getMember() {
        return this.member;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaMember
    public /* bridge */ /* synthetic */ Member getMember() {
        return getMember();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaTypeParameterListOwner
    public List<ReflectJavaTypeParameter> getTypeParameters() {
        TypeVariable<Constructor<?>>[] r10 = getMember().getTypeParameters();
        Intrinsics.checkNotNullExpressionValue(r10, "member.typeParameters");
        ArrayList r11 = new ArrayList(r10.length);
        int r12 = r10.length;
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L5;
        r11.add(new ReflectJavaTypeParameter(r10[r13]));
        r13 = r13 + 1;
        goto L3
    L5:
        return r11;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaConstructor
    public List<JavaValueParameter> getValueParameters() {
        Type[] r10 = getMember().getGenericParameterTypes();
        Intrinsics.checkNotNullExpressionValue(r10, "types");
        if (r10.length != 0) goto L5;
        boolean r11 = true;
    L6:
        if (r11 == true) goto L8;
        Class<?> r12 = getMember().getDeclaringClass();
        if (r12.getDeclaringClass() != null) goto L12;
    L14:
        Annotation[][] r13 = getMember().getParameterAnnotations();
        if (r13.length < r10.length) goto L22;
        if (r13.length <= r10.length) goto L19;
        Intrinsics.checkNotNullExpressionValue(r13, "annotations");
        r13 = (Annotation[][]) ArraysKt.copyOfRange(r13, r13.length - r10.length, r13.length);
    L19:
        Intrinsics.checkNotNullExpressionValue(r10, "realTypes");
        Intrinsics.checkNotNullExpressionValue(r13, "realAnnotations");
        return getValueParameters(r10, r13, getMember().isVarArgs());
    L22:
        throw new IllegalStateException("Illegal generic signature: " + getMember());
    L12:
        if (Modifier.isStatic(r12.getModifiers()) == true) goto L14;
        r10 = (Type[]) ArraysKt.copyOfRange(r10, 1, r10.length);
        goto L14
    L8:
        return CollectionsKt.emptyList();
    L5:
        r11 = false;
        goto L6
    }
}
