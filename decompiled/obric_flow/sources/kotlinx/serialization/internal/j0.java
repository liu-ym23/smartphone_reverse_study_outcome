package kotlinx.serialization.internal;

import java.util.List;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlin.reflect.KClassifier;
import kotlin.reflect.KType;

/* JADX INFO: loaded from: classes3.dex */
public final class j0 implements KType {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final KType f19299a;

    public j0(KType r5) {
        Intrinsics.checkNotNullParameter(r5, "origin");
        this.f19299a = r5;
    }

    public final boolean equals(Object r5) {
        if (r5 != null) goto L5;
        return false;
    L5:
        KClassifier r10 = null;
        if ((r5 instanceof j0) == false) goto L8;
        j0 r11 = (j0) r5;
    L9:
        if (r11 == null) goto L11;
        KType r12 = r11.f19299a;
    L12:
        KType r13 = this.f19299a;
        if (Intrinsics.areEqual(r13, r12) == true) goto L15;
        return false;
    L15:
        KClassifier r14 = r13.getClassifier();
        if ((r14 instanceof KClass) == true) goto L18;
    L29:
        return false;
    L18:
        if ((r5 instanceof KType) == false) goto L20;
        KType r15 = (KType) r5;
    L21:
        if (r15 == null) goto L23;
        r10 = r15.getClassifier();
    L23:
        if (r10 == null) goto L29;
        if ((r10 instanceof KClass) == false) goto L29;
        return Intrinsics.areEqual(JvmClassMappingKt.getJavaClass((KClass) r14), JvmClassMappingKt.getJavaClass((KClass) r10));
    L20:
        r15 = null;
        goto L21
    L11:
        r12 = null;
        goto L12
    L8:
        r11 = null;
        goto L9
    }

    @Override // kotlin.reflect.KAnnotatedElement
    public final List getAnnotations() {
        return this.f19299a.getAnnotations();
    }

    @Override // kotlin.reflect.KType
    public final List getArguments() {
        return this.f19299a.getArguments();
    }

    @Override // kotlin.reflect.KType
    public final KClassifier getClassifier() {
        return this.f19299a.getClassifier();
    }

    public final int hashCode() {
        return this.f19299a.hashCode();
    }

    @Override // kotlin.reflect.KType
    public final boolean isMarkedNullable() {
        return this.f19299a.isMarkedNullable();
    }

    public final String toString() {
        return "KTypeWrapper: " + this.f19299a;
    }
}
