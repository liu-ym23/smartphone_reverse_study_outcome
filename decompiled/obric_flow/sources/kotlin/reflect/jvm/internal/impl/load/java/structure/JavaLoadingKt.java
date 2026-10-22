package kotlin.reflect.jvm.internal.impl.load.java.structure;

import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.name.FqName;

/* JADX INFO: loaded from: classes3.dex */
public final class JavaLoadingKt {
    private static final boolean isMethodWithOneObjectParameter(JavaMethod r5) {
        JavaValueParameter r10 = (JavaValueParameter) CollectionsKt.singleOrNull(r5.getValueParameters());
        JavaClassifierType r11 = null;
        if (r10 == null) goto L5;
        JavaType r12 = r10.getType();
    L7:
        if ((r12 instanceof JavaClassifierType) == false) goto L10;
        r11 = (JavaClassifierType) r12;
    L10:
        if (r11 != null) goto L12;
        return false;
    L12:
        JavaClassifier r13 = r11.getClassifier();
        if ((r13 instanceof JavaClass) == false) goto L20;
        FqName r14 = ((JavaClass) r13).getFqName();
        if (r14 != null) goto L17;
        return false;
    L17:
        if (Intrinsics.areEqual(r14.asString(), "java.lang.Object") == false) goto L22;
        return true;
    L22:
        return false;
    L20:
        return false;
    L5:
        r12 = null;
        goto L7
    }

    private static final boolean isObjectMethod(JavaMethod r5) {
        String r10 = r5.getName().asString();
        int r11 = r10.hashCode();
        if (r11 == (-1776922004)) goto L17;
        if (r11 == (-1295482945)) goto L13;
        if (r11 == 147696667) goto L10;
    L19:
        return false;
    L10:
        if (r10.equals("hashCode") == false) goto L19;
    L22:
        return r5.getValueParameters().isEmpty();
    L13:
        if (r10.equals("equals") == false) goto L19;
        return isMethodWithOneObjectParameter(r5);
    L17:
        if (r10.equals("toString") == false) goto L19;
        goto L19
    }

    public static final boolean isObjectMethodInInterface(JavaMember r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        if (r5.getContainingClass().isInterface() == true) goto L5;
    L9:
        return false;
    L5:
        if ((r5 instanceof JavaMethod) == false) goto L9;
        if (isObjectMethod((JavaMethod) r5) == false) goto L9;
        return true;
    }
}
