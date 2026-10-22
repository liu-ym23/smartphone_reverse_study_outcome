package kotlin.reflect.jvm.internal.impl.descriptors.annotations;

/* JADX INFO: loaded from: classes3.dex */
public class AnnotatedImpl implements Annotated {
    private final Annotations annotations;

    private static /* synthetic */ void $$$reportNull$$$0(int r10) {
        if (r10 == 1) goto L5;
        String r5 = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
    L7:
        if (r10 == 1) goto L9;
        int r11 = 3;
    L10:
        Object[] r12 = new Object[r11];
        if (r10 == 1) goto L13;
        r12[0] = "annotations";
    L14:
        if (r10 == 1) goto L16;
        r12[1] = "kotlin/reflect/jvm/internal/impl/descriptors/annotations/AnnotatedImpl";
    L17:
        if (r10 == 1) goto L19;
        r12[2] = "<init>";
    L19:
        String r13 = String.format(r5, r12);
        if (r10 == 1) goto L23;
        throw new IllegalArgumentException(r13);
    L23:
        throw new IllegalStateException(r13);
    L16:
        r12[1] = "getAnnotations";
        goto L17
    L13:
        r12[0] = "kotlin/reflect/jvm/internal/impl/descriptors/annotations/AnnotatedImpl";
        goto L14
    L9:
        r11 = 2;
        goto L10
    L5:
        r5 = "@NotNull method %s.%s must not return null";
        goto L7
    }

    public AnnotatedImpl(Annotations r5) {
        if (r5 != null) goto L4;
        $$$reportNull$$$0(0);
    L4:
        this.annotations = r5;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotated
    public Annotations getAnnotations() {
        Annotations r5 = this.annotations;
        if (r5 != null) goto L5;
        $$$reportNull$$$0(1);
    L5:
        return r5;
    }
}
