package kotlin.reflect.jvm.internal.impl.descriptors.annotations;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public class AnnotatedImpl implements Annotated {
    private final Annotations annotations;

    private static /* synthetic */ void $$$reportNull$$$0(int r7) {
        if (r7 == 1) goto L5;
        String r1 = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
    L7:
        if (r7 == 1) goto L9;
        int r3 = 3;
    L10:
        Object[] r4 = new Object[r3];
        if (r7 == 1) goto L13;
        r4[0] = "annotations";
    L14:
        if (r7 == 1) goto L16;
        r4[1] = "kotlin/reflect/jvm/internal/impl/descriptors/annotations/AnnotatedImpl";
    L17:
        if (r7 == 1) goto L19;
        r4[2] = "<init>";
    L19:
        String r2 = String.format(r1, r4);
        if (r7 == 1) goto L23;
        throw new IllegalArgumentException(r2);
    L23:
        throw new IllegalStateException(r2);
    L16:
        r4[1] = "getAnnotations";
        goto L17
    L13:
        r4[0] = "kotlin/reflect/jvm/internal/impl/descriptors/annotations/AnnotatedImpl";
        goto L14
    L9:
        r3 = 2;
        goto L10
    L5:
        r1 = "@NotNull method %s.%s must not return null";
        goto L7
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotated
    public Annotations getAnnotations() {
        Annotations r0 = this.annotations;
        if (r0 != null) goto L5;
        $$$reportNull$$$0(1);
    L5:
        return r0;
    }

    public AnnotatedImpl(Annotations r2) {
        if (r2 != null) goto L4;
        $$$reportNull$$$0(0);
    L4:
        this.annotations = r2;
    }
}
