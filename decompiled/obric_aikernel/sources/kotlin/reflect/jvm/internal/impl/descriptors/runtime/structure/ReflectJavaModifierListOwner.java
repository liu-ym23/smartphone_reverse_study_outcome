package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import java.lang.reflect.Modifier;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibilities;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibility;
import kotlin.reflect.jvm.internal.impl.descriptors.java.JavaVisibilities;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaModifierListOwner;

/* JADX INFO: loaded from: classes3.dex */
public interface ReflectJavaModifierListOwner extends JavaModifierListOwner {

    public static final class DefaultImpls {
        public static Visibility getVisibility(ReflectJavaModifierListOwner r10) {
            int r11 = r10.getModifiers();
            if (Modifier.isPublic(r11) == false) goto L6;
            return Visibilities.Public.INSTANCE;
        L6:
            if (Modifier.isPrivate(r11) == false) goto L9;
            return Visibilities.Private.INSTANCE;
        L9:
            if (Modifier.isProtected(r11) == false) goto L15;
            if (Modifier.isStatic(r11) == false) goto L19;
            return JavaVisibilities.ProtectedStaticVisibility.INSTANCE;
        L19:
            return JavaVisibilities.ProtectedAndPackage.INSTANCE;
        L15:
            return JavaVisibilities.PackageVisibility.INSTANCE;
        }

        public static boolean isAbstract(ReflectJavaModifierListOwner r10) {
            return Modifier.isAbstract(r10.getModifiers());
        }

        public static boolean isFinal(ReflectJavaModifierListOwner r10) {
            return Modifier.isFinal(r10.getModifiers());
        }

        public static boolean isStatic(ReflectJavaModifierListOwner r10) {
            return Modifier.isStatic(r10.getModifiers());
        }
    }

    int getModifiers();
}
