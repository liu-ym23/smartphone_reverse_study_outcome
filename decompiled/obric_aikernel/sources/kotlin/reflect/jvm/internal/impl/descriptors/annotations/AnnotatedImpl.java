package kotlin.reflect.jvm.internal.impl.descriptors.annotations;

/* JADX INFO: loaded from: classes3.dex */
public class AnnotatedImpl implements Annotated {
    private final Annotations annotations;

    private static /* synthetic */ void $$$reportNull$$$0(int r10) {
        if (r10 == 1) goto L5;
        String r11 = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
    L7:
        if (r10 == 1) goto L9;
        int r12 = 3;
    L10:
        Object[] r13 = new Object[r12];
        if (r10 == 1) goto L13;
        r13[0] = "annotations";
    L14:
        if (r10 == 1) goto L16;
        r13[1] = "kotlin/reflect/jvm/internal/impl/descriptors/annotations/AnnotatedImpl";
    L17:
        if (r10 == 1) goto L19;
        r13[2] = "<init>";
    L19:
        String r14 = String.format(r11, r13);
        if (r10 == 1) goto L23;
        throw new IllegalArgumentException(r14);
    L23:
        throw new IllegalStateException(r14);
    L16:
        r13[1] = "getAnnotations";
        goto L17
    L13:
        r13[0] = "kotlin/reflect/jvm/internal/impl/descriptors/annotations/AnnotatedImpl";
        goto L14
    L9:
        r12 = 2;
        goto L10
    L5:
        r11 = "@NotNull method %s.%s must not return null";
        goto L7
    }

    public AnnotatedImpl(Annotations r10) {
        if (r10 != null) goto L4;
        $$$reportNull$$$0(0);
    L4:
        this.annotations = r10;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotated
    public Annotations getAnnotations() {
        Annotations r10 = this.annotations;
        if (r10 != null) goto L5;
        $$$reportNull$$$0(1);
    L5:
        return r10;
    }
}
