package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import java.lang.annotation.Annotation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationArgument;
import kotlin.reflect.jvm.internal.impl.name.Name;

/* JADX INFO: loaded from: classes3.dex */
public abstract class ReflectJavaAnnotationArgument implements JavaAnnotationArgument {
    public static final Factory Factory = null;
    private final Name name;

    public static final class Factory {
        public /* synthetic */ Factory(DefaultConstructorMarker r5) {
            this();
        }

        public final ReflectJavaAnnotationArgument create(Object r5, Name r10) {
            Intrinsics.checkNotNullParameter(r5, "value");
            if (ReflectClassUtilKt.isEnumClassOrSpecializedEnumEntryClass(r5.getClass()) == false) goto L6;
            return new ReflectJavaEnumValueAnnotationArgument(r10, (Enum) r5);
        L6:
            if ((r5 instanceof Annotation) == false) goto L9;
            return new ReflectJavaAnnotationAsAnnotationArgument(r10, (Annotation) r5);
        L9:
            if ((r5 instanceof Object[]) == false) goto L12;
            return new ReflectJavaArrayAnnotationArgument(r10, (Object[]) r5);
        L12:
            if ((r5 instanceof Class) == false) goto L15;
            return new ReflectJavaClassObjectAnnotationArgument(r10, (Class) r5);
        L15:
            return new ReflectJavaLiteralAnnotationArgument(r10, r5);
        }

        private Factory() {
        }
    }

    static {
        Factory = new Factory(null);
    }

    public /* synthetic */ ReflectJavaAnnotationArgument(Name r5, DefaultConstructorMarker r10) {
        this(r5);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationArgument
    public Name getName() {
        return this.name;
    }

    private ReflectJavaAnnotationArgument(Name r5) {
        this.name = r5;
    }
}
