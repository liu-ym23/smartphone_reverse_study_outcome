package kotlin.reflect.jvm.internal.impl.descriptors.annotations;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.reflect.jvm.internal.impl.name.FqName;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public interface Annotations extends Iterable<AnnotationDescriptor>, KMappedMarker {
    public static final Companion Companion = null;

    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = null;
        private static final Annotations EMPTY = null;

        private Companion() {
        }

        static {
            $$INSTANCE = new Companion();
            EMPTY = new Annotations$Companion$EMPTY$1();
        }

        public final Annotations getEMPTY() {
            return EMPTY;
        }

        public final Annotations create(List<? extends AnnotationDescriptor> r2) {
            Intrinsics.checkNotNullParameter(r2, "annotations");
            if (r2.isEmpty() == false) goto L6;
            return EMPTY;
        L6:
            return new AnnotationsImpl(r2);
        }
    }

    static {
        Companion = Companion.$$INSTANCE;
    }

    /* JADX INFO: renamed from: findAnnotation */
    AnnotationDescriptor mo373findAnnotation(FqName r1);

    boolean hasAnnotation(FqName r1);

    boolean isEmpty();
}
