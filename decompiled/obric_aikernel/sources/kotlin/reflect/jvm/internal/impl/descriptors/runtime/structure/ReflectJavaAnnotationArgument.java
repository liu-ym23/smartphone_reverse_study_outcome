package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import com.bytedance.crash.entity.EventBody;
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
        private Factory() {
        }

        public /* synthetic */ Factory(DefaultConstructorMarker r10) {
            this();
        }

        public final ReflectJavaAnnotationArgument create(Object r10, Name r11) {
            Intrinsics.checkNotNullParameter(r10, EventBody.KEY_VALUE);
            if (ReflectClassUtilKt.isEnumClassOrSpecializedEnumEntryClass(r10.getClass()) == false) goto L6;
            return new ReflectJavaEnumValueAnnotationArgument(r11, (Enum) r10);
        L6:
            if ((r10 instanceof Annotation) == false) goto L9;
            return new ReflectJavaAnnotationAsAnnotationArgument(r11, (Annotation) r10);
        L9:
            if ((r10 instanceof Object[]) == false) goto L12;
            return new ReflectJavaArrayAnnotationArgument(r11, (Object[]) r10);
        L12:
            if ((r10 instanceof Class) == false) goto L15;
            return new ReflectJavaClassObjectAnnotationArgument(r11, (Class) r10);
        L15:
            return new ReflectJavaLiteralAnnotationArgument(r11, r10);
        }
    }

    static {
        Factory = new Factory(null);
    }

    private ReflectJavaAnnotationArgument(Name r10) {
        this.name = r10;
    }

    public /* synthetic */ ReflectJavaAnnotationArgument(Name r10, DefaultConstructorMarker r11) {
        this(r10);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationArgument
    public Name getName() {
        return this.name;
    }
}
