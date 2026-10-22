package androidx.room.compiler.processing;

import androidx.room.compiler.processing.javac.JavacProcessingEnv;
import androidx.room.compiler.processing.javac.JavacRoundEnv;
import androidx.room.compiler.processing.ksp.KspProcessingEnv;
import androidx.room.compiler.processing.ksp.KspRoundEnv;
import java.lang.annotation.Annotation;
import java.util.Set;
import javax.annotation.processing.RoundEnvironment;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\bf\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010J\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u000b\u001a\u00020\fH&J\u001e\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u000e\u0010\r\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000f0\u000eH&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0004R\u0018\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0011À\u0006\u0001"}, d2 = {"Landroidx/room/compiler/processing/XRoundEnv;", "", "isProcessingOver", "", "()Z", "rootElements", "", "Landroidx/room/compiler/processing/XElement;", "getRootElements", "()Ljava/util/Set;", "getElementsAnnotatedWith", "annotationQualifiedName", "", "klass", "Lkotlin/reflect/KClass;", "", "Companion", "room-compiler-processing"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface XRoundEnv {
    public static final Companion Companion = null;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J&\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\t\u001a\u00020\nH\u0007¨\u0006\u000b"}, d2 = {"Landroidx/room/compiler/processing/XRoundEnv$Companion;", "", "()V", "create", "Landroidx/room/compiler/processing/XRoundEnv;", "processingEnv", "Landroidx/room/compiler/processing/XProcessingEnv;", "roundEnvironment", "Ljavax/annotation/processing/RoundEnvironment;", "isProcessingOver", "", "room-compiler-processing"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = null;

        static {
            $$INSTANCE = new Companion();
        }

        private Companion() {
        }

        public static /* synthetic */ XRoundEnv create$default(Companion r5, XProcessingEnv r10, RoundEnvironment r11, boolean r12, int r13, Object r14) {
            if ((r13 & 2) == 0) goto L6;
            r11 = null;
        L6:
            if ((r13 & 4) == 0) goto L11;
            if (r11 == null) goto L9;
            r12 = r11.processingOver();
            goto L11
        L9:
            r12 = false;
        L11:
            return r5.create(r10, r11, r12);
        }

        @JvmStatic
        public final XRoundEnv create(XProcessingEnv r5, RoundEnvironment r10, boolean r11) {
            Intrinsics.checkNotNullParameter(r5, "processingEnv");
            if ((r5 instanceof JavacProcessingEnv) == false) goto L9;
            if (r10 == null) goto L7;
            return new JavacRoundEnv((JavacProcessingEnv) r5, r10);
        L7:
            throw new IllegalStateException("Required value was null.");
        L9:
            if ((r5 instanceof KspProcessingEnv) == false) goto L13;
            return new KspRoundEnv((KspProcessingEnv) r5, r11);
        L13:
            throw new IllegalStateException(("invalid processing environment type: " + r5).toString());
        }
    }

    static {
        Companion = Companion.$$INSTANCE;
    }

    @JvmStatic
    static XRoundEnv create(XProcessingEnv r5, RoundEnvironment r10, boolean r11) {
        return Companion.create(r5, r10, r11);
    }

    Set<XElement> getElementsAnnotatedWith(String r5);

    Set<XElement> getElementsAnnotatedWith(KClass<? extends Annotation> r5);

    Set<XElement> getRootElements();

    boolean isProcessingOver();
}
