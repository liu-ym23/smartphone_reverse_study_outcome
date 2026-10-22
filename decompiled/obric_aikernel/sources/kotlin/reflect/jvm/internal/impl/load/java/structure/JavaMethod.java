package kotlin.reflect.jvm.internal.impl.load.java.structure;

import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public interface JavaMethod extends JavaMember, JavaTypeParameterListOwner {

    public static final class DefaultImpls {
        public static boolean getHasAnnotationParameterDefaultValue(JavaMethod r10) {
            if (r10.getAnnotationParameterDefaultValue() == null) goto L5;
            return true;
        L5:
            return false;
        }
    }

    JavaAnnotationArgument getAnnotationParameterDefaultValue();

    boolean getHasAnnotationParameterDefaultValue();

    JavaType getReturnType();

    List<JavaValueParameter> getValueParameters();
}
