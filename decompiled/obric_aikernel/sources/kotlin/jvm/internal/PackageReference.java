package kotlin.jvm.internal;

import java.util.Collection;
import kotlin.SinceKotlin;
import kotlin.jvm.KotlinReflectionNotSupportedError;
import kotlin.reflect.KCallable;

/* JADX INFO: loaded from: classes2.dex */
@SinceKotlin(version = "1.1")
public final class PackageReference implements ClassBasedDeclarationContainer {
    private final Class<?> jClass;
    private final String moduleName;

    public PackageReference(Class<?> r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "jClass");
        Intrinsics.checkNotNullParameter(r11, "moduleName");
        this.jClass = r10;
        this.moduleName = r11;
    }

    public boolean equals(Object r10) {
        if ((r10 instanceof PackageReference) == true) goto L5;
    L7:
        return false;
    L5:
        if (Intrinsics.areEqual(getJClass(), ((PackageReference) r10).getJClass()) == false) goto L7;
        return true;
    }

    @Override // kotlin.jvm.internal.ClassBasedDeclarationContainer
    public Class<?> getJClass() {
        return this.jClass;
    }

    @Override // kotlin.reflect.KDeclarationContainer
    public Collection<KCallable<?>> getMembers() {
        throw new KotlinReflectionNotSupportedError();
    }

    public int hashCode() {
        return getJClass().hashCode();
    }

    public String toString() {
        return getJClass().toString() + " (Kotlin reflection is not available)";
    }
}
