package kotlin.reflect.jvm.internal.impl.descriptors.annotations;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class AnnotationsKt {
    public static final Annotations composeAnnotations(Annotations r5, Annotations r10) {
        Intrinsics.checkNotNullParameter(r5, "first");
        Intrinsics.checkNotNullParameter(r10, "second");
        if (r5.isEmpty() == false) goto L6;
        return r10;
    L6:
        if (r10.isEmpty() == false) goto L9;
        return r5;
    L9:
        return new CompositeAnnotations(new Annotations[]{r5, r10});
    }
}
