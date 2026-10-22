package kotlin.reflect.jvm.internal.impl.renderer;

import java.util.ArrayList;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public interface ClassifierNamePolicy {

    public static final class FULLY_QUALIFIED implements ClassifierNamePolicy {
        public static final FULLY_QUALIFIED INSTANCE = null;

        static {
            INSTANCE = new FULLY_QUALIFIED();
        }

        private FULLY_QUALIFIED() {
        }

        @Override // kotlin.reflect.jvm.internal.impl.renderer.ClassifierNamePolicy
        public String renderClassifier(ClassifierDescriptor r2, DescriptorRenderer r3) {
            Intrinsics.checkNotNullParameter(r2, "classifier");
            Intrinsics.checkNotNullParameter(r3, "renderer");
            if ((r2 instanceof TypeParameterDescriptor) == false) goto L7;
            return r3.renderName(((TypeParameterDescriptor) r2).getName(), false);
        L7:
            return r3.renderFqName(DescriptorUtils.getFqName(r2));
        }
    }

    public static final class SHORT implements ClassifierNamePolicy {
        public static final SHORT INSTANCE = null;

        static {
            INSTANCE = new SHORT();
        }

        private SHORT() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r2v0, types: [java.lang.Object, kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor] */
        /* JADX WARN: Type inference failed for: r2v1, types: [kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.Named] */
        /* JADX WARN: Type inference failed for: r2v2, types: [kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor] */
        @Override // kotlin.reflect.jvm.internal.impl.renderer.ClassifierNamePolicy
        public String renderClassifier(ClassifierDescriptor r2, DescriptorRenderer r3) {
            Intrinsics.checkNotNullParameter(r2, "classifier");
            Intrinsics.checkNotNullParameter(r3, "renderer");
            if ((r2 instanceof TypeParameterDescriptor) == true) goto L5;
            ArrayList r4 = new ArrayList();
        L7:
            r4.add(r2.getName());
            r2 = r2.getContainingDeclaration();
            if ((r2 instanceof ClassDescriptor) == true) goto L7;
            return RenderingUtilsKt.renderFqName(CollectionsKt.asReversedMutable(r4));
        L5:
            return r3.renderName(((TypeParameterDescriptor) r2).getName(), false);
        }
    }

    public static final class SOURCE_CODE_QUALIFIED implements ClassifierNamePolicy {
        public static final SOURCE_CODE_QUALIFIED INSTANCE = null;

        static {
            INSTANCE = new SOURCE_CODE_QUALIFIED();
        }

        private SOURCE_CODE_QUALIFIED() {
        }

        private final String qualifiedNameForSourceCode(ClassifierDescriptor r3) {
            String r0 = RenderingUtilsKt.render(r3.getName());
            if ((r3 instanceof TypeParameterDescriptor) == false) goto L5;
            return r0;
        L5:
            String r4 = qualifierName(r3.getContainingDeclaration());
            if (r4 != null) goto L8;
            return r0;
        L8:
            if (Intrinsics.areEqual(r4, "") == false) goto L10;
            return r0;
        L10:
            return r4 + '.' + r0;
        }

        private final String qualifierName(DeclarationDescriptor r2) {
            if ((r2 instanceof ClassDescriptor) == false) goto L6;
            return qualifiedNameForSourceCode((ClassifierDescriptor) r2);
        L6:
            if ((r2 instanceof PackageFragmentDescriptor) == true) goto L11;
            return null;
        L11:
            return RenderingUtilsKt.render(((PackageFragmentDescriptor) r2).getFqName().toUnsafe());
        }

        @Override // kotlin.reflect.jvm.internal.impl.renderer.ClassifierNamePolicy
        public String renderClassifier(ClassifierDescriptor r2, DescriptorRenderer r3) {
            Intrinsics.checkNotNullParameter(r2, "classifier");
            Intrinsics.checkNotNullParameter(r3, "renderer");
            return qualifiedNameForSourceCode(r2);
        }
    }

    String renderClassifier(ClassifierDescriptor r1, DescriptorRenderer r2);
}
