package kotlin.reflect.jvm.internal.impl.load.java.structure;

import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.name.FqName;

/* JADX INFO: loaded from: classes3.dex */
public final class JavaLoadingKt {
    private static final boolean isMethodWithOneObjectParameter(JavaMethod r10) {
        JavaValueParameter r11 = (JavaValueParameter) CollectionsKt.singleOrNull(r10.getValueParameters());
        JavaClassifierType r12 = null;
        if (r11 == null) goto L5;
        JavaType r13 = r11.getType();
    L7:
        if ((r13 instanceof JavaClassifierType) == false) goto L10;
        r12 = (JavaClassifierType) r13;
    L10:
        if (r12 != null) goto L12;
        return false;
    L12:
        JavaClassifier r14 = r12.getClassifier();
        if ((r14 instanceof JavaClass) == false) goto L20;
        FqName r15 = ((JavaClass) r14).getFqName();
        if (r15 != null) goto L17;
        return false;
    L17:
        if (Intrinsics.areEqual(r15.asString(), "java.lang.Object") == false) goto L22;
        return true;
    L22:
        return false;
    L20:
        return false;
    L5:
        r13 = null;
        goto L7
    }

    private static final boolean isObjectMethod(JavaMethod r10) {
        String r11 = r10.getName().asString();
        int r12 = r11.hashCode();
        if (r12 == (-1776922004)) goto L17;
        if (r12 == (-1295482945)) goto L13;
        if (r12 == 147696667) goto L10;
    L19:
        return false;
    L10:
        if (r11.equals("hashCode") == false) goto L19;
    L22:
        return r10.getValueParameters().isEmpty();
    L13:
        if (r11.equals("equals") == false) goto L19;
        return isMethodWithOneObjectParameter(r10);
    L17:
        if (r11.equals("toString") == false) goto L19;
        goto L19
    }

    public static final boolean isObjectMethodInInterface(JavaMember r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if (r10.getContainingClass().isInterface() == true) goto L5;
    L9:
        return false;
    L5:
        if ((r10 instanceof JavaMethod) == false) goto L9;
        if (isObjectMethod((JavaMethod) r10) == false) goto L9;
        return true;
    }
}
