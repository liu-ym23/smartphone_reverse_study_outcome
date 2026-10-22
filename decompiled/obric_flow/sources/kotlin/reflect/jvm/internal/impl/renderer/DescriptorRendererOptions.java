package kotlin.reflect.jvm.internal.impl.renderer;

import java.util.Set;
import kotlin.reflect.jvm.internal.impl.name.FqName;

/* JADX INFO: loaded from: classes3.dex */
public interface DescriptorRendererOptions {

    public static final class DefaultImpls {
        public static boolean getIncludeAnnotationArguments(DescriptorRendererOptions r5) {
            return r5.getAnnotationArgumentsRenderingPolicy().getIncludeAnnotationArguments();
        }

        public static boolean getIncludeEmptyAnnotationArguments(DescriptorRendererOptions r5) {
            return r5.getAnnotationArgumentsRenderingPolicy().getIncludeEmptyAnnotationArguments();
        }
    }

    AnnotationArgumentsRenderingPolicy getAnnotationArgumentsRenderingPolicy();

    boolean getDebugMode();

    boolean getEnhancedTypes();

    Set<FqName> getExcludedTypeAnnotationClasses();

    void setAnnotationArgumentsRenderingPolicy(AnnotationArgumentsRenderingPolicy r5);

    void setClassifierNamePolicy(ClassifierNamePolicy r5);

    void setDebugMode(boolean r5);

    void setExcludedTypeAnnotationClasses(Set<FqName> r5);

    void setModifiers(Set<? extends DescriptorRendererModifier> r5);

    void setParameterNameRenderingPolicy(ParameterNameRenderingPolicy r5);

    void setReceiverAfterName(boolean r5);

    void setRenderCompanionObjectName(boolean r5);

    void setStartFromName(boolean r5);

    void setTextFormat(RenderingFormat r5);

    void setVerbose(boolean r5);

    void setWithDefinedIn(boolean r5);

    void setWithoutSuperTypes(boolean r5);

    void setWithoutTypeParameters(boolean r5);
}
