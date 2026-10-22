package kotlin.reflect.jvm.internal.impl.renderer;

import androidx.constraintlayout.motion.widget.a;
import java.util.ArrayList;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
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
        public String renderClassifier(ClassifierDescriptor r5, DescriptorRenderer r10) {
            Intrinsics.checkNotNullParameter(r5, "classifier");
            Intrinsics.checkNotNullParameter(r10, "renderer");
            if ((r5 instanceof TypeParameterDescriptor) == false) goto L7;
            return r10.renderName(((TypeParameterDescriptor) r5).getName(), false);
        L7:
            return r10.renderFqName(DescriptorUtils.getFqName(r5));
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
        public String renderClassifier(ClassifierDescriptor r5, DescriptorRenderer r10) {
            Intrinsics.checkNotNullParameter(r5, "classifier");
            Intrinsics.checkNotNullParameter(r10, "renderer");
            if ((r5 instanceof TypeParameterDescriptor) == true) goto L5;
            ArrayList r11 = new ArrayList();
        L7:
            r11.add(r5.getName());
            r5 = r5.getContainingDeclaration();
            if ((r5 instanceof ClassDescriptor) == true) goto L7;
            return RenderingUtilsKt.renderFqName(CollectionsKt.e(r11));
        L5:
            return r10.renderName(((TypeParameterDescriptor) r5).getName(), false);
        }
    }

    public static final class SOURCE_CODE_QUALIFIED implements ClassifierNamePolicy {
        public static final SOURCE_CODE_QUALIFIED INSTANCE = null;

        static {
            INSTANCE = new SOURCE_CODE_QUALIFIED();
        }

        private SOURCE_CODE_QUALIFIED() {
        }

        private final String qualifiedNameForSourceCode(ClassifierDescriptor r5) {
            String r10 = RenderingUtilsKt.render(r5.getName());
            if ((r5 instanceof TypeParameterDescriptor) == false) goto L5;
            return r10;
        L5:
            String r11 = qualifierName(r5.getContainingDeclaration());
            if (r11 != null) goto L8;
            return r10;
        L8:
            if (Intrinsics.areEqual(r11, "") == false) goto L10;
            return r10;
        L10:
            return a.m(r11, '.', r10);
        }

        private final String qualifierName(DeclarationDescriptor r5) {
            if ((r5 instanceof ClassDescriptor) == false) goto L6;
            return qualifiedNameForSourceCode((ClassifierDescriptor) r5);
        L6:
            if ((r5 instanceof PackageFragmentDescriptor) == true) goto L11;
            return null;
        L11:
            return RenderingUtilsKt.render(((PackageFragmentDescriptor) r5).getFqName().toUnsafe());
        }

        @Override // kotlin.reflect.jvm.internal.impl.renderer.ClassifierNamePolicy
        public String renderClassifier(ClassifierDescriptor r5, DescriptorRenderer r10) {
            Intrinsics.checkNotNullParameter(r5, "classifier");
            Intrinsics.checkNotNullParameter(r10, "renderer");
            return qualifiedNameForSourceCode(r5);
        }
    }

    String renderClassifier(ClassifierDescriptor r5, DescriptorRenderer r10);
}
