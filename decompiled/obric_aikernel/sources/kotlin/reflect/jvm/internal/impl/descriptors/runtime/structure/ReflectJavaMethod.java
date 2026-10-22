package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import java.lang.annotation.Annotation;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationArgument;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMethod;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaType;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaValueParameter;

/* JADX INFO: loaded from: classes3.dex */
public final class ReflectJavaMethod extends ReflectJavaMember implements JavaMethod {
    private final Method member;

    public ReflectJavaMethod(Method r10) {
        Intrinsics.checkNotNullParameter(r10, "member");
        this.member = r10;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMethod
    public JavaAnnotationArgument getAnnotationParameterDefaultValue() {
        Object r10 = getMember().getDefaultValue();
        if (r10 != null) goto L5;
        return null;
    L5:
        return ReflectJavaAnnotationArgument.Factory.create(r10, null);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMethod
    public boolean getHasAnnotationParameterDefaultValue() {
        return JavaMethod.DefaultImpls.getHasAnnotationParameterDefaultValue(this);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaMember
    public /* bridge */ /* synthetic */ Member getMember() {
        return getMember();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaMember
    public Method getMember() {
        return this.member;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMethod
    public ReflectJavaType getReturnType() {
        ReflectJavaType.Factory r10 = ReflectJavaType.Factory;
        Type r11 = getMember().getGenericReturnType();
        Intrinsics.checkNotNullExpressionValue(r11, "member.genericReturnType");
        return r10.create(r11);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMethod
    public /* bridge */ /* synthetic */ JavaType getReturnType() {
        return getReturnType();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaTypeParameterListOwner
    public List<ReflectJavaTypeParameter> getTypeParameters() {
        TypeVariable<Method>[] r10 = getMember().getTypeParameters();
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

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMethod
    public List<JavaValueParameter> getValueParameters() {
        Type[] r10 = getMember().getGenericParameterTypes();
        Intrinsics.checkNotNullExpressionValue(r10, "member.genericParameterTypes");
        Annotation[][] r11 = getMember().getParameterAnnotations();
        Intrinsics.checkNotNullExpressionValue(r11, "member.parameterAnnotations");
        return getValueParameters(r10, r11, getMember().isVarArgs());
    }
}
