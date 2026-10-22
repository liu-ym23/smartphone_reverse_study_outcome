package kotlin.reflect.jvm.internal.impl.descriptors.annotations;

import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
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

        public final Annotations create(List<? extends AnnotationDescriptor> r5) {
            Intrinsics.checkNotNullParameter(r5, "annotations");
            if (r5.isEmpty() == false) goto L6;
            return EMPTY;
        L6:
            return new AnnotationsImpl(r5);
        }

        public final Annotations getEMPTY() {
            return EMPTY;
        }
    }

    @SourceDebugExtension({"SMAP\nAnnotations.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Annotations.kt\norg/jetbrains/kotlin/descriptors/annotations/Annotations$DefaultImpls\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,123:1\n288#2,2:124\n*S KotlinDebug\n*F\n+ 1 Annotations.kt\norg/jetbrains/kotlin/descriptors/annotations/Annotations$DefaultImpls\n*L\n29#1:124,2\n*E\n"})
    public static final class DefaultImpls {
        public static AnnotationDescriptor findAnnotation(Annotations r5, FqName r10) {
            Intrinsics.checkNotNullParameter(r10, "fqName");
            Iterator<AnnotationDescriptor> r11 = r5.iterator();
        L4:
            if (r11.hasNext() == false) goto L8;
            AnnotationDescriptor r12 = r11.next();
            if (Intrinsics.areEqual(r12.getFqName(), r10) == false) goto L4;
        L10:
            return r12;
        L8:
            r12 = null;
            goto L10
        }

        public static boolean hasAnnotation(Annotations r5, FqName r10) {
            Intrinsics.checkNotNullParameter(r10, "fqName");
            if (r5.mo1397findAnnotation(r10) == null) goto L5;
            return true;
        L5:
            return false;
        }
    }

    static {
        Companion = Companion.$$INSTANCE;
    }

    /* JADX INFO: renamed from: findAnnotation */
    AnnotationDescriptor mo1397findAnnotation(FqName r5);

    boolean hasAnnotation(FqName r5);

    boolean isEmpty();
}
