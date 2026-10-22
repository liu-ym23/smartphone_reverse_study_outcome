package kotlin.reflect.jvm.internal.impl.renderer;

import java.util.Set;
import kotlin.reflect.jvm.internal.impl.name.FqName;

/* JADX INFO: loaded from: classes3.dex */
public interface DescriptorRendererOptions {

    public static final class DefaultImpls {
        public static boolean getIncludeAnnotationArguments(DescriptorRendererOptions r10) {
            return r10.getAnnotationArgumentsRenderingPolicy().getIncludeAnnotationArguments();
        }

        public static boolean getIncludeEmptyAnnotationArguments(DescriptorRendererOptions r10) {
            return r10.getAnnotationArgumentsRenderingPolicy().getIncludeEmptyAnnotationArguments();
        }
    }

    AnnotationArgumentsRenderingPolicy getAnnotationArgumentsRenderingPolicy();

    boolean getDebugMode();

    boolean getEnhancedTypes();

    Set<FqName> getExcludedTypeAnnotationClasses();

    void setAnnotationArgumentsRenderingPolicy(AnnotationArgumentsRenderingPolicy r10);

    void setClassifierNamePolicy(ClassifierNamePolicy r10);

    void setDebugMode(boolean r10);

    void setExcludedTypeAnnotationClasses(Set<FqName> r10);

    void setModifiers(Set<? extends DescriptorRendererModifier> r10);

    void setParameterNameRenderingPolicy(ParameterNameRenderingPolicy r10);

    void setReceiverAfterName(boolean r10);

    void setRenderCompanionObjectName(boolean r10);

    void setStartFromName(boolean r10);

    void setTextFormat(RenderingFormat r10);

    void setVerbose(boolean r10);

    void setWithDefinedIn(boolean r10);

    void setWithoutSuperTypes(boolean r10);

    void setWithoutTypeParameters(boolean r10);
}
