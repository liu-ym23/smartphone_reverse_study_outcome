package kotlin.reflect.jvm.internal.impl.descriptors.annotations;

import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.reflect.jvm.internal.impl.name.FqName;

/* JADX INFO: loaded from: classes3.dex */
public interface Annotations extends Iterable<AnnotationDescriptor>, KMappedMarker {
    public static final Companion Companion = null;

    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = null;
        private static final Annotations EMPTY = null;

        static {
            $$INSTANCE = new Companion();
            EMPTY = new Annotations$Companion$EMPTY$1();
        }

        private Companion() {
        }

        public final Annotations create(List<? extends AnnotationDescriptor> r10) {
            Intrinsics.checkNotNullParameter(r10, "annotations");
            if (r10.isEmpty() == false) goto L6;
            return EMPTY;
        L6:
            return new AnnotationsImpl(r10);
        }

        public final Annotations getEMPTY() {
            return EMPTY;
        }
    }

    public static final class DefaultImpls {
        public static AnnotationDescriptor findAnnotation(Annotations r10, FqName r11) {
            Intrinsics.checkNotNullParameter(r11, "fqName");
            Iterator<AnnotationDescriptor> r12 = r10.iterator();
        L4:
            if (r12.hasNext() == false) goto L8;
            AnnotationDescriptor r13 = r12.next();
            if (Intrinsics.areEqual(r13.getFqName(), r11) == false) goto L4;
        L10:
            return r13;
        L8:
            r13 = null;
            goto L10
        }

        public static boolean hasAnnotation(Annotations r10, FqName r11) {
            Intrinsics.checkNotNullParameter(r11, "fqName");
            if (r10.mo1318findAnnotation(r11) == null) goto L5;
            return true;
        L5:
            return false;
        }
    }

    static {
        Companion = Companion.$$INSTANCE;
    }

    /* JADX INFO: renamed from: findAnnotation */
    AnnotationDescriptor mo1318findAnnotation(FqName r10);

    boolean hasAnnotation(FqName r10);

    boolean isEmpty();
}
