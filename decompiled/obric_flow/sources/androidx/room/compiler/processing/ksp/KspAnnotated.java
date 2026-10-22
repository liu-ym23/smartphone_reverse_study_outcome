package androidx.room.compiler.processing.ksp;

import ai.j0;
import androidx.exifinterface.media.ExifInterface;
import androidx.room.compiler.processing.InternalXAnnotated;
import androidx.room.compiler.processing.XAnnotation;
import androidx.room.compiler.processing.XAnnotationBox;
import com.google.devtools.ksp.symbol.AnnotationUseSiteTarget;
import il.b;
import java.lang.annotation.Annotation;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u001b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u0000 &2\u00020\u0001:\u0004&'()B\u0011\b\u0004\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J-\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n\"\b\b\u0000\u0010\u0007*\u00020\u00062\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\bH\u0002¢\u0006\u0004\b\f\u0010\rJ'\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\u000b2\u000e\u0010\u000f\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\bH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0015\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH&¢\u0006\u0004\b\u0013\u0010\u0014J\u0015\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015H\u0016¢\u0006\u0004\b\u0017\u0010\u0018JE\u0010\u001b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u001a0\u0015\"\b\b\u0000\u0010\u0007*\u00020\u00062\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\b2\u0010\u0010\u0019\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0006\u0018\u00010\bH\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u001f\u001a\u00020\u00102\u0006\u0010\u001e\u001a\u00020\u001dH\u0016¢\u0006\u0004\b\u001f\u0010 J1\u0010!\u001a\u00020\u00102\u000e\u0010\t\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\b2\u0010\u0010\u0019\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0006\u0018\u00010\bH\u0016¢\u0006\u0004\b!\u0010\"R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010#\u001a\u0004\b$\u0010%\u0082\u0001\u0002*+¨\u0006,"}, d2 = {"Landroidx/room/compiler/processing/ksp/KspAnnotated;", "Landroidx/room/compiler/processing/InternalXAnnotated;", "Landroidx/room/compiler/processing/ksp/KspProcessingEnv;", "env", "<init>", "(Landroidx/room/compiler/processing/ksp/KspProcessingEnv;)V", "", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/reflect/KClass;", "annotation", "Lkotlin/sequences/Sequence;", "Lil/b;", "findAnnotations", "(Lkotlin/reflect/KClass;)Lkotlin/sequences/Sequence;", "ksAnnotation", "annotationClass", "", "isSameAnnotationClass", "(Lil/b;Lkotlin/reflect/KClass;)Z", "annotations", "()Lkotlin/sequences/Sequence;", "", "Landroidx/room/compiler/processing/XAnnotation;", "getAllAnnotations", "()Ljava/util/List;", "containerAnnotation", "Landroidx/room/compiler/processing/XAnnotationBox;", "getAnnotations", "(Lkotlin/reflect/KClass;Lkotlin/reflect/KClass;)Ljava/util/List;", "", "pkg", "hasAnnotationWithPackage", "(Ljava/lang/String;)Z", "hasAnnotation", "(Lkotlin/reflect/KClass;Lkotlin/reflect/KClass;)Z", "Landroidx/room/compiler/processing/ksp/KspProcessingEnv;", "getEnv", "()Landroidx/room/compiler/processing/ksp/KspProcessingEnv;", "Companion", "KSAnnotatedDelegate", "NotAnnotated", "UseSiteFilter", "Landroidx/room/compiler/processing/ksp/KspAnnotated$KSAnnotatedDelegate;", "Landroidx/room/compiler/processing/ksp/KspAnnotated$NotAnnotated;", "room-compiler-processing"}, k = 1, mv = {1, 7, 1}, xi = 48)
public abstract class KspAnnotated implements InternalXAnnotated {
    public static final Companion Companion = null;
    private final KspProcessingEnv env;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J'\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Landroidx/room/compiler/processing/ksp/KspAnnotated$Companion;", "", "<init>", "()V", "Landroidx/room/compiler/processing/ksp/KspProcessingEnv;", "env", "Lil/a;", "delegate", "Landroidx/room/compiler/processing/ksp/KspAnnotated$UseSiteFilter;", "filter", "Landroidx/room/compiler/processing/ksp/KspAnnotated;", "create", "(Landroidx/room/compiler/processing/ksp/KspProcessingEnv;Lil/a;Landroidx/room/compiler/processing/ksp/KspAnnotated$UseSiteFilter;)Landroidx/room/compiler/processing/ksp/KspAnnotated;", "room-compiler-processing"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r5) {
            this();
        }

        public final KspAnnotated create(KspProcessingEnv r5, il.a r10, UseSiteFilter r11) {
            Intrinsics.checkNotNullParameter(r5, "env");
            Intrinsics.checkNotNullParameter(r11, "filter");
            if (r10 == null) goto L6;
            return new KSAnnotatedDelegate(r5, r10, r11);
        L6:
            return new NotAnnotated(r5);
        }

        private Companion() {
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0016¢\u0006\u0004\b\f\u0010\rR\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u000eR\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u000f¨\u0006\u0010"}, d2 = {"Landroidx/room/compiler/processing/ksp/KspAnnotated$KSAnnotatedDelegate;", "Landroidx/room/compiler/processing/ksp/KspAnnotated;", "Landroidx/room/compiler/processing/ksp/KspProcessingEnv;", "env", "Lil/a;", "delegate", "Landroidx/room/compiler/processing/ksp/KspAnnotated$UseSiteFilter;", "useSiteFilter", "<init>", "(Landroidx/room/compiler/processing/ksp/KspProcessingEnv;Lil/a;Landroidx/room/compiler/processing/ksp/KspAnnotated$UseSiteFilter;)V", "Lkotlin/sequences/Sequence;", "Lil/b;", "annotations", "()Lkotlin/sequences/Sequence;", "Lil/a;", "Landroidx/room/compiler/processing/ksp/KspAnnotated$UseSiteFilter;", "room-compiler-processing"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class KSAnnotatedDelegate extends KspAnnotated {
        private final il.a delegate;
        private final UseSiteFilter useSiteFilter;

        public KSAnnotatedDelegate(KspProcessingEnv r5, il.a r10, UseSiteFilter r11) {
            Intrinsics.checkNotNullParameter(r5, "env");
            Intrinsics.checkNotNullParameter(r10, "delegate");
            Intrinsics.checkNotNullParameter(r11, "useSiteFilter");
            super(r5, null);
            this.delegate = r10;
            this.useSiteFilter = r11;
        }

        public static final /* synthetic */ UseSiteFilter access$getUseSiteFilter$p(KSAnnotatedDelegate r5) {
            return r5.useSiteFilter;
        }

        @Override // androidx.room.compiler.processing.ksp.KspAnnotated
        public Sequence<b> annotations() {
            return SequencesKt.filter(this.delegate.getAnnotations(), new KspAnnotated$KSAnnotatedDelegate$annotations$1(this));
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0016¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Landroidx/room/compiler/processing/ksp/KspAnnotated$NotAnnotated;", "Landroidx/room/compiler/processing/ksp/KspAnnotated;", "Landroidx/room/compiler/processing/ksp/KspProcessingEnv;", "env", "<init>", "(Landroidx/room/compiler/processing/ksp/KspProcessingEnv;)V", "Lkotlin/sequences/Sequence;", "Lil/b;", "annotations", "()Lkotlin/sequences/Sequence;", "room-compiler-processing"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class NotAnnotated extends KspAnnotated {
        public NotAnnotated(KspProcessingEnv r5) {
            Intrinsics.checkNotNullParameter(r5, "env");
            super(r5, null);
        }

        @Override // androidx.room.compiler.processing.ksp.KspAnnotated
        public Sequence<b> annotations() {
            return SequencesKt.emptySequence();
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\bf\u0018\u0000 \u00072\u00020\u0001:\u0002\u0007\bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\tÀ\u0006\u0001"}, d2 = {"Landroidx/room/compiler/processing/ksp/KspAnnotated$UseSiteFilter;", "", "Lil/b;", "annotation", "", "accept", "(Lil/b;)Z", "Companion", "Impl", "room-compiler-processing"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public interface UseSiteFilter {
        public static final Companion Companion = null;

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0011\u0010\t\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\u0011\u0010\u000b\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0006R\u0011\u0010\r\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0006R\u0011\u0010\u000f\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0006R\u0011\u0010\u0011\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0006¨\u0006\u0013"}, d2 = {"Landroidx/room/compiler/processing/ksp/KspAnnotated$UseSiteFilter$Companion;", "", "()V", "FILE", "Landroidx/room/compiler/processing/ksp/KspAnnotated$UseSiteFilter;", "getFILE", "()Landroidx/room/compiler/processing/ksp/KspAnnotated$UseSiteFilter;", "NO_USE_SITE", "getNO_USE_SITE", "NO_USE_SITE_OR_FIELD", "getNO_USE_SITE_OR_FIELD", "NO_USE_SITE_OR_GETTER", "getNO_USE_SITE_OR_GETTER", "NO_USE_SITE_OR_METHOD_PARAMETER", "getNO_USE_SITE_OR_METHOD_PARAMETER", "NO_USE_SITE_OR_SETTER", "getNO_USE_SITE_OR_SETTER", "NO_USE_SITE_OR_SET_PARAM", "getNO_USE_SITE_OR_SET_PARAM", "room-compiler-processing"}, k = 1, mv = {1, 7, 1}, xi = 48)
        public static final class Companion {
            static final /* synthetic */ Companion $$INSTANCE = null;
            private static final UseSiteFilter FILE = null;
            private static final UseSiteFilter NO_USE_SITE = null;
            private static final UseSiteFilter NO_USE_SITE_OR_FIELD = null;
            private static final UseSiteFilter NO_USE_SITE_OR_GETTER = null;
            private static final UseSiteFilter NO_USE_SITE_OR_METHOD_PARAMETER = null;
            private static final UseSiteFilter NO_USE_SITE_OR_SETTER = null;
            private static final UseSiteFilter NO_USE_SITE_OR_SET_PARAM = null;

            static {
                $$INSTANCE = new Companion();
                NO_USE_SITE = new KspAnnotated$UseSiteFilter$Companion$NO_USE_SITE$1();
                boolean r5 = false;
                int r10 = 2;
                DefaultConstructorMarker r11 = null;
                NO_USE_SITE_OR_FIELD = new Impl(AnnotationUseSiteTarget.FIELD, r5, r10, r11);
                NO_USE_SITE_OR_METHOD_PARAMETER = new Impl(AnnotationUseSiteTarget.PARAM, r5, r10, r11);
                NO_USE_SITE_OR_GETTER = new Impl(AnnotationUseSiteTarget.GET, r5, r10, r11);
                NO_USE_SITE_OR_SETTER = new Impl(AnnotationUseSiteTarget.SET, r5, r10, r11);
                NO_USE_SITE_OR_SET_PARAM = new Impl(AnnotationUseSiteTarget.SETPARAM, r5, r10, r11);
                FILE = new Impl(AnnotationUseSiteTarget.FILE, false);
            }

            private Companion() {
            }

            public final UseSiteFilter getFILE() {
                return FILE;
            }

            public final UseSiteFilter getNO_USE_SITE() {
                return NO_USE_SITE;
            }

            public final UseSiteFilter getNO_USE_SITE_OR_FIELD() {
                return NO_USE_SITE_OR_FIELD;
            }

            public final UseSiteFilter getNO_USE_SITE_OR_GETTER() {
                return NO_USE_SITE_OR_GETTER;
            }

            public final UseSiteFilter getNO_USE_SITE_OR_METHOD_PARAMETER() {
                return NO_USE_SITE_OR_METHOD_PARAMETER;
            }

            public final UseSiteFilter getNO_USE_SITE_OR_SETTER() {
                return NO_USE_SITE_OR_SETTER;
            }

            public final UseSiteFilter getNO_USE_SITE_OR_SET_PARAM() {
                return NO_USE_SITE_OR_SET_PARAM;
            }
        }

        @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0002\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\n\u0010\u000bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u000f¨\u0006\u0010"}, d2 = {"Landroidx/room/compiler/processing/ksp/KspAnnotated$UseSiteFilter$Impl;", "Landroidx/room/compiler/processing/ksp/KspAnnotated$UseSiteFilter;", "Lcom/google/devtools/ksp/symbol/AnnotationUseSiteTarget;", "acceptedTarget", "", "acceptNoTarget", "<init>", "(Lcom/google/devtools/ksp/symbol/AnnotationUseSiteTarget;Z)V", "Lil/b;", "annotation", "accept", "(Lil/b;)Z", "Lcom/google/devtools/ksp/symbol/AnnotationUseSiteTarget;", "getAcceptedTarget", "()Lcom/google/devtools/ksp/symbol/AnnotationUseSiteTarget;", "Z", "room-compiler-processing"}, k = 1, mv = {1, 7, 1}, xi = 48)
        public static final class Impl implements UseSiteFilter {
            private final boolean acceptNoTarget;
            private final AnnotationUseSiteTarget acceptedTarget;

            public Impl(AnnotationUseSiteTarget r5, boolean r10) {
                Intrinsics.checkNotNullParameter(r5, "acceptedTarget");
                this.acceptedTarget = r5;
                this.acceptNoTarget = r10;
            }

            @Override // androidx.room.compiler.processing.ksp.KspAnnotated.UseSiteFilter
            public boolean accept(b r5) {
                Intrinsics.checkNotNullParameter(r5, "annotation");
                AnnotationUseSiteTarget r10 = r5.g();
                if (r10 != null) goto L6;
                return this.acceptNoTarget;
            L6:
                if (this.acceptedTarget != r10) goto L8;
                return true;
            L8:
                return false;
            }

            public final AnnotationUseSiteTarget getAcceptedTarget() {
                return this.acceptedTarget;
            }

            public /* synthetic */ Impl(AnnotationUseSiteTarget r5, boolean r10, int r11, DefaultConstructorMarker r12) {
                if ((r11 & 2) == 0) goto L5;
                r10 = true;
            L5:
                this(r5, r10);
            }
        }

        static {
            Companion = Companion.$$INSTANCE;
        }

        boolean accept(b r5);
    }

    static {
        Companion = new Companion(null);
    }

    public /* synthetic */ KspAnnotated(KspProcessingEnv r5, DefaultConstructorMarker r10) {
        this(r5);
    }

    public static final /* synthetic */ boolean access$isSameAnnotationClass(KspAnnotated r5, b r10, KClass r11) {
        return r5.isSameAnnotationClass(r10, r11);
    }

    private final <T extends Annotation> Sequence<b> findAnnotations(final KClass<T> r5) {
        return SequencesKt.filter(annotations(), new AnonymousClass1(this, r5));
    }

    private final boolean isSameAnnotationClass(b r5, KClass<? extends Annotation> r10) {
        r5.d().resolve();
        throw null;
    }

    public abstract Sequence<b> annotations();

    @Override // androidx.room.compiler.processing.XAnnotated
    public List<XAnnotation> getAllAnnotations() {
        return SequencesKt.toList(SequencesKt.flatMapIterable(SequencesKt.map(annotations(), new C01011(this)), AnonymousClass2.INSTANCE));
    }

    @Override // androidx.room.compiler.processing.InternalXAnnotated
    public <T extends Annotation> List<XAnnotationBox<T>> getAnnotations(final KClass<T> r5, KClass<? extends Annotation> r10) {
        Intrinsics.checkNotNullParameter(r5, "annotation");
        if (r10 == null) goto L6;
        j0.A(SequencesKt.firstOrNull(findAnnotations(r10)));
    L6:
        return SequencesKt.toList(SequencesKt.map(findAnnotations(r5), new C01022(this, r5)));
    }

    public final KspProcessingEnv getEnv() {
        return this.env;
    }

    @Override // androidx.room.compiler.processing.InternalXAnnotated
    public boolean hasAnnotation(KClass<? extends Annotation> r5, KClass<? extends Annotation> r10) {
        Intrinsics.checkNotNullParameter(r5, "annotation");
        Iterator<b> r11 = annotations().iterator();
    L4:
        if (r11.hasNext() == false) goto L11;
        j0.A(r11.next());
        if (isSameAnnotationClass(null, r5) == true) goto L10;
        if (r10 == null) goto L4;
        if (isSameAnnotationClass(null, r10) == false) goto L4;
    L10:
        return true;
    L11:
        return false;
    }

    @Override // androidx.room.compiler.processing.XAnnotated
    public boolean hasAnnotationWithPackage(String r5) {
        Intrinsics.checkNotNullParameter(r5, "pkg");
        Iterator<b> r10 = annotations().iterator();
        if (r10.hasNext() == true) goto L6;
        return false;
    L6:
        j0.A(r10.next());
        throw null;
    }

    private KspAnnotated(KspProcessingEnv r5) {
        this.env = r5;
    }
}
