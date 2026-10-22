package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaArrayAnnotationArgument;
import kotlin.reflect.jvm.internal.impl.name.Name;

/* JADX INFO: loaded from: classes3.dex */
public final class ReflectJavaArrayAnnotationArgument extends ReflectJavaAnnotationArgument implements JavaArrayAnnotationArgument {
    private final Object[] values;

    public ReflectJavaArrayAnnotationArgument(Name r10, Object[] r11) {
        Intrinsics.checkNotNullParameter(r11, "values");
        super(r10, null);
        this.values = r11;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaArrayAnnotationArgument
    public List<ReflectJavaAnnotationArgument> getElements() {
        Object[] r10 = this.values;
        ArrayList r11 = new ArrayList(r10.length);
        int r12 = r10.length;
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L5;
        Object r14 = r10[r13];
        ReflectJavaAnnotationArgument.Factory r15 = ReflectJavaAnnotationArgument.Factory;
        Intrinsics.checkNotNull(r14);
        r11.add(r15.create(r14, null));
        r13 = r13 + 1;
        goto L3
    L5:
        return r11;
    }
}
