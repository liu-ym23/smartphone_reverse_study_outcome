package kotlin.reflect.jvm.internal.impl.renderer;

import java.util.ArrayList;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;

/* JADX INFO: loaded from: classes3.dex */
public interface ClassifierNamePolicy {

    public static final class FULLY_QUALIFIED implements ClassifierNamePolicy {
        public static final FULLY_QUALIFIED INSTANCE = null;

        static {
            INSTANCE = new FULLY_QUALIFIED();
        }

        private FULLY_QUALIFIED() {
        }

        @Override // kotlin.reflect.jvm.internal.impl.renderer.ClassifierNamePolicy
        public String renderClassifier(ClassifierDescriptor r10, DescriptorRenderer r11) {
            Intrinsics.checkNotNullParameter(r10, "classifier");
            Intrinsics.checkNotNullParameter(r11, "renderer");
            if ((r10 instanceof TypeParameterDescriptor) == false) goto L6;
            Name r12 = ((TypeParameterDescriptor) r10).getName();
            Intrinsics.checkNotNullExpressionValue(r12, "classifier.name");
            return r11.renderName(r12, false);
        L6:
            FqNameUnsafe r13 = DescriptorUtils.getFqName(r10);
            Intrinsics.checkNotNullExpressionValue(r13, "getFqName(classifier)");
            return r11.renderFqName(r13);
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
        /* JADX WARN: Type inference failed for: r1v0, types: [java.lang.Object, kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor] */
        /* JADX WARN: Type inference failed for: r1v1, types: [kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.Named] */
        /* JADX WARN: Type inference failed for: r1v2, types: [kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor] */
        @Override // kotlin.reflect.jvm.internal.impl.renderer.ClassifierNamePolicy
        public String renderClassifier(ClassifierDescriptor r10, DescriptorRenderer r11) {
            Intrinsics.checkNotNullParameter(r10, "classifier");
            Intrinsics.checkNotNullParameter(r11, "renderer");
            if ((r10 instanceof TypeParameterDescriptor) == false) goto L6;
            Name r12 = ((TypeParameterDescriptor) r10).getName();
            Intrinsics.checkNotNullExpressionValue(r12, "classifier.name");
            return r11.renderName(r12, false);
        L6:
            ArrayList r13 = new ArrayList();
        L7:
            r13.add(r10.getName());
            r10 = r10.getContainingDeclaration();
            if ((r10 instanceof ClassDescriptor) == true) goto L7;
            return RenderingUtilsKt.renderFqName(CollectionsKt.asReversedMutable(r13));
        }
    }

    public static final class SOURCE_CODE_QUALIFIED implements ClassifierNamePolicy {
        public static final SOURCE_CODE_QUALIFIED INSTANCE = null;

        static {
            INSTANCE = new SOURCE_CODE_QUALIFIED();
        }

        private SOURCE_CODE_QUALIFIED() {
        }

        private final String qualifiedNameForSourceCode(ClassifierDescriptor r10) {
            Name r11 = r10.getName();
            Intrinsics.checkNotNullExpressionValue(r11, "descriptor.name");
            String r12 = RenderingUtilsKt.render(r11);
            if ((r10 instanceof TypeParameterDescriptor) == false) goto L5;
            return r12;
        L5:
            DeclarationDescriptor r13 = r10.getContainingDeclaration();
            Intrinsics.checkNotNullExpressionValue(r13, "descriptor.containingDeclaration");
            String r14 = qualifierName(r13);
            if (r14 != null) goto L8;
            return r12;
        L8:
            if (Intrinsics.areEqual(r14, "") == false) goto L10;
            return r12;
        L10:
            return r14 + '.' + r12;
        }

        private final String qualifierName(DeclarationDescriptor r10) {
            if ((r10 instanceof ClassDescriptor) == false) goto L6;
            return qualifiedNameForSourceCode((ClassifierDescriptor) r10);
        L6:
            if ((r10 instanceof PackageFragmentDescriptor) == false) goto L8;
            FqNameUnsafe r11 = ((PackageFragmentDescriptor) r10).getFqName().toUnsafe();
            Intrinsics.checkNotNullExpressionValue(r11, "descriptor.fqName.toUnsafe()");
            return RenderingUtilsKt.render(r11);
        L8:
            return null;
        }

        @Override // kotlin.reflect.jvm.internal.impl.renderer.ClassifierNamePolicy
        public String renderClassifier(ClassifierDescriptor r10, DescriptorRenderer r11) {
            Intrinsics.checkNotNullParameter(r10, "classifier");
            Intrinsics.checkNotNullParameter(r11, "renderer");
            return qualifiedNameForSourceCode(r10);
        }
    }

    String renderClassifier(ClassifierDescriptor r10, DescriptorRenderer r11);
}
