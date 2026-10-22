package kotlin.reflect.jvm.internal.impl.descriptors.annotations;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class AnnotationsKt {
    public static final Annotations composeAnnotations(Annotations r10, Annotations r11) {
        Intrinsics.checkNotNullParameter(r10, "first");
        Intrinsics.checkNotNullParameter(r11, "second");
        if (r10.isEmpty() == false) goto L6;
        return r11;
    L6:
        if (r11.isEmpty() == false) goto L9;
        return r10;
    L9:
        return new CompositeAnnotations(new Annotations[]{r10, r11});
    }
}
