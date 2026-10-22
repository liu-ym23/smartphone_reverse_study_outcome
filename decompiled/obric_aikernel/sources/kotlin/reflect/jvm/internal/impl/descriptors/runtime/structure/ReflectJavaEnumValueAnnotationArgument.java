package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import com.bytedance.crash.entity.EventBody;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaEnumValueAnnotationArgument;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.Name;

/* JADX INFO: loaded from: classes3.dex */
public final class ReflectJavaEnumValueAnnotationArgument extends ReflectJavaAnnotationArgument implements JavaEnumValueAnnotationArgument {
    private final Enum<?> value;

    public ReflectJavaEnumValueAnnotationArgument(Name r10, Enum<?> r11) {
        Intrinsics.checkNotNullParameter(r11, EventBody.KEY_VALUE);
        super(r10, null);
        this.value = r11;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaEnumValueAnnotationArgument
    public Name getEntryName() {
        return Name.identifier(this.value.name());
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaEnumValueAnnotationArgument
    public ClassId getEnumClassId() {
        Class<?> r10 = this.value.getClass();
        if (r10.isEnum() == true) goto L6;
        r10 = r10.getEnclosingClass();
    L6:
        Intrinsics.checkNotNullExpressionValue(r10, "enumClass");
        return ReflectClassUtilKt.getClassId(r10);
    }
}
