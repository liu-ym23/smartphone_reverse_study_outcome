package androidx.room.compiler.processing;

import ai.j0;
import androidx.room.compiler.codegen.XTypeName;
import androidx.room.compiler.processing.javac.JavacProcessingEnv;
import androidx.room.compiler.processing.ksp.KspProcessingEnv;
import com.squareup.javapoet.x;
import hl.a;
import hl.c;
import hl.d;
import java.util.List;
import java.util.Map;
import javax.annotation.processing.ProcessingEnvironment;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes.dex */
@ExperimentalProcessingApi
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\bg\u0018\u0000 =2\u00020\u0001:\u0002>=J\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\n\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\n\u0010\tJ\u0011\u0010\u000b\u001a\u0004\u0018\u00010\u0004H&¢\u0006\u0004\b\u000b\u0010\fJ+\u0010\u0010\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u00042\u0012\u0010\u000f\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u000e\"\u00020\u0007H&¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0013\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u0007H&¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0015\u0010\u0006J\u0017\u0010\n\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\n\u0010\u0018J\u0017\u0010\n\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\n\u0010\u001aJ\u001b\u0010\n\u001a\u00020\u00072\n\u0010\u001c\u001a\u0006\u0012\u0002\b\u00030\u001bH\u0016¢\u0006\u0004\b\n\u0010\u001dJ\u0019\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0017\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\b\u0010\u0018J\u001d\u0010\b\u001a\u0004\u0018\u00010\u00072\n\u0010\u001c\u001a\u0006\u0012\u0002\b\u00030\u001bH\u0016¢\u0006\u0004\b\b\u0010\u001dJ\u0017\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0015\u0010\u001eJ\u001b\u0010\u0015\u001a\u00020\u00042\n\u0010\u001c\u001a\u0006\u0012\u0002\b\u00030\u001bH\u0016¢\u0006\u0004\b\u0015\u0010\u001fJ\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0017\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0005\u0010\u001eJ\u001d\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\u0010\u001c\u001a\u0006\u0012\u0002\b\u00030\u001bH\u0016¢\u0006\u0004\b\u0005\u0010\u001fJ\u0017\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0013\u0010 J\u001d\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00040\"2\u0006\u0010!\u001a\u00020\u0002H&¢\u0006\u0004\b#\u0010$R\u0014\u0010(\u001a\u00020%8&X¦\u0004¢\u0006\u0006\u001a\u0004\b&\u0010'R\u0014\u0010,\u001a\u00020)8&X¦\u0004¢\u0006\u0006\u001a\u0004\b*\u0010+R \u00100\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020-8&X¦\u0004¢\u0006\u0006\u001a\u0004\b.\u0010/R\u0014\u00104\u001a\u0002018&X¦\u0004¢\u0006\u0006\u001a\u0004\b2\u00103R\u0014\u00108\u001a\u0002058&X¦\u0004¢\u0006\u0006\u001a\u0004\b6\u00107R\u0014\u0010<\u001a\u0002098&X¦\u0004¢\u0006\u0006\u001a\u0004\b:\u0010;ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006?À\u0006\u0001"}, d2 = {"Landroidx/room/compiler/processing/XProcessingEnv;", "", "", "qName", "Landroidx/room/compiler/processing/XTypeElement;", "findTypeElement", "(Ljava/lang/String;)Landroidx/room/compiler/processing/XTypeElement;", "Landroidx/room/compiler/processing/XType;", "findType", "(Ljava/lang/String;)Landroidx/room/compiler/processing/XType;", "requireType", "findGeneratedAnnotation", "()Landroidx/room/compiler/processing/XTypeElement;", "type", "", "types", "getDeclaredType", "(Landroidx/room/compiler/processing/XTypeElement;[Landroidx/room/compiler/processing/XType;)Landroidx/room/compiler/processing/XType;", "Landroidx/room/compiler/processing/XArrayType;", "getArrayType", "(Landroidx/room/compiler/processing/XType;)Landroidx/room/compiler/processing/XArrayType;", "requireTypeElement", "Lcom/squareup/javapoet/x;", "typeName", "(Lcom/squareup/javapoet/x;)Landroidx/room/compiler/processing/XType;", "Landroidx/room/compiler/codegen/XTypeName;", "(Landroidx/room/compiler/codegen/XTypeName;)Landroidx/room/compiler/processing/XType;", "Lkotlin/reflect/KClass;", "klass", "(Lkotlin/reflect/KClass;)Landroidx/room/compiler/processing/XType;", "(Lcom/squareup/javapoet/x;)Landroidx/room/compiler/processing/XTypeElement;", "(Lkotlin/reflect/KClass;)Landroidx/room/compiler/processing/XTypeElement;", "(Lcom/squareup/javapoet/x;)Landroidx/room/compiler/processing/XArrayType;", "packageName", "", "getTypeElementsFromPackage", "(Ljava/lang/String;)Ljava/util/List;", "Landroidx/room/compiler/processing/XProcessingEnv$Backend;", "getBackend", "()Landroidx/room/compiler/processing/XProcessingEnv$Backend;", "backend", "Landroidx/room/compiler/processing/XMessager;", "getMessager", "()Landroidx/room/compiler/processing/XMessager;", "messager", "", "getOptions", "()Ljava/util/Map;", "options", "Landroidx/room/compiler/processing/XFiler;", "getFiler", "()Landroidx/room/compiler/processing/XFiler;", "filer", "Landroidx/room/compiler/processing/XProcessingEnvConfig;", "getConfig", "()Landroidx/room/compiler/processing/XProcessingEnvConfig;", "config", "", "getJvmVersion", "()I", "jvmVersion", "Companion", "Backend", "room-compiler-processing"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface XProcessingEnv {
    public static final Companion Companion = null;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Landroidx/room/compiler/processing/XProcessingEnv$Backend;", "", "(Ljava/lang/String;I)V", "JAVAC", "KSP", "room-compiler-processing"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final enum Backend extends Enum<Backend> {
        private static final /* synthetic */ Backend[] $VALUES = null;
        public static final Backend JAVAC = null;
        public static final Backend KSP = null;

        private static final /* synthetic */ Backend[] $values() {
            return new Backend[]{JAVAC, KSP};
        }

        static {
            JAVAC = new Backend("JAVAC", 0);
            KSP = new Backend("KSP", 1);
            $VALUES = $values();
        }

        private Backend(String r5, int r10) {
            super(r5, r10);
        }

        public static Backend valueOf(String r5) {
            return (Backend) Enum.valueOf(Backend.class, r5);
        }

        public static Backend[] values() {
            return (Backend[]) $VALUES.clone();
        }
    }

    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J!\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\t\u0010\nJE\u0010\t\u001a\u00020\b2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00122\b\b\u0002\u0010\u0007\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\t\u0010\u0014¨\u0006\u0015"}, d2 = {"Landroidx/room/compiler/processing/XProcessingEnv$Companion;", "", "<init>", "()V", "Ljavax/annotation/processing/ProcessingEnvironment;", "env", "Landroidx/room/compiler/processing/XProcessingEnvConfig;", "config", "Landroidx/room/compiler/processing/XProcessingEnv;", "create", "(Ljavax/annotation/processing/ProcessingEnvironment;Landroidx/room/compiler/processing/XProcessingEnvConfig;)Landroidx/room/compiler/processing/XProcessingEnv;", "", "", "options", "Lhl/d;", "resolver", "Lhl/a;", "codeGenerator", "Lhl/c;", "logger", "(Ljava/util/Map;Lhl/d;Lhl/a;Lhl/c;Landroidx/room/compiler/processing/XProcessingEnvConfig;)Landroidx/room/compiler/processing/XProcessingEnv;", "room-compiler-processing"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = null;

        static {
            $$INSTANCE = new Companion();
        }

        private Companion() {
        }

        public static /* synthetic */ XProcessingEnv create$default(Companion r5, ProcessingEnvironment r10, XProcessingEnvConfig r11, int r12, Object r13) {
            if ((r12 & 2) == 0) goto L6;
            r11 = XProcessingEnvConfig.Companion.getDEFAULT();
        L6:
            return r5.create(r10, r11);
        }

        @JvmStatic
        @JvmOverloads
        public final XProcessingEnv create(Map<String, String> r10, d r11, a r12, c r13) {
            Intrinsics.checkNotNullParameter(r10, "options");
            Intrinsics.checkNotNullParameter(r11, "resolver");
            Intrinsics.checkNotNullParameter(r12, "codeGenerator");
            Intrinsics.checkNotNullParameter(r13, "logger");
            return create$default(this, r10, r11, r12, r13, null, 16, null);
        }

        @JvmStatic
        @JvmOverloads
        public final XProcessingEnv create(ProcessingEnvironment r5) {
            Intrinsics.checkNotNullParameter(r5, "env");
            return create$default(this, r5, null, 2, null);
        }

        public static /* synthetic */ XProcessingEnv create$default(Companion r10, Map r11, d r12, a r13, c r14, XProcessingEnvConfig r15, int r16, Object r17) {
            if ((r16 & 16) == 0) goto L6;
            r15 = XProcessingEnvConfig.Companion.getDEFAULT();
        L6:
            return r10.create(r11, r12, r13, r14, r15);
        }

        @JvmStatic
        @JvmOverloads
        public final XProcessingEnv create(ProcessingEnvironment r5, XProcessingEnvConfig r10) {
            Intrinsics.checkNotNullParameter(r5, "env");
            Intrinsics.checkNotNullParameter(r10, "config");
            return new JavacProcessingEnv(r5, r10);
        }

        @JvmStatic
        @JvmOverloads
        public final XProcessingEnv create(Map<String, String> r5, d r10, a r11, c r12, XProcessingEnvConfig r13) {
            Intrinsics.checkNotNullParameter(r5, "options");
            Intrinsics.checkNotNullParameter(r10, "resolver");
            Intrinsics.checkNotNullParameter(r11, "codeGenerator");
            Intrinsics.checkNotNullParameter(r12, "logger");
            Intrinsics.checkNotNullParameter(r13, "config");
            KspProcessingEnv r14 = new KspProcessingEnv(r5, r11, r12, r13);
            r14.setResolver$room_compiler_processing(r10);
            return r14;
        }
    }

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r5 = new int[Backend.values().length];
            r5[Backend.JAVAC.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r5[Backend.KSP.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            $EnumSwitchMapping$0 = r5;
        }
    }

    static {
        Companion = Companion.$$INSTANCE;
    }

    @JvmStatic
    @JvmOverloads
    static XProcessingEnv create(Map<String, String> r5, d r10, a r11, c r12) {
        return Companion.create(r5, r10, r11, r12);
    }

    XTypeElement findGeneratedAnnotation();

    default XType findType(x r5) {
        Intrinsics.checkNotNullParameter(r5, "typeName");
        if ((r5 instanceof com.squareup.javapoet.c) == false) goto L10;
        XType r10 = findType(((com.squareup.javapoet.c) r5).f14958w);
        if (r10 != null) goto L11;
        return null;
    L11:
        return getArrayType(r10);
    L10:
        return findType(r5.toString());
    }

    XType findType(String r5);

    default XTypeElement findTypeElement(x r5) {
        Intrinsics.checkNotNullParameter(r5, "typeName");
        return findTypeElement(r5.toString());
    }

    XTypeElement findTypeElement(String r5);

    XArrayType getArrayType(XType r5);

    default XArrayType getArrayType(x r5) {
        Intrinsics.checkNotNullParameter(r5, "typeName");
        return getArrayType(requireType(r5));
    }

    Backend getBackend();

    XProcessingEnvConfig getConfig();

    XType getDeclaredType(XTypeElement r5, XType... r10);

    XFiler getFiler();

    int getJvmVersion();

    XMessager getMessager();

    Map<String, String> getOptions();

    List<XTypeElement> getTypeElementsFromPackage(String r5);

    default XType requireType(String r5) {
        Intrinsics.checkNotNullParameter(r5, "qName");
        XType r10 = findType(r5);
        if (r10 == null) goto L6;
        return r10;
    L6:
        throw new IllegalStateException(j0.C("cannot find required type ", r5).toString());
    }

    default XTypeElement requireTypeElement(String r5) {
        Intrinsics.checkNotNullParameter(r5, "qName");
        XTypeElement r10 = findTypeElement(r5);
        if (r10 == null) goto L6;
        return r10;
    L6:
        throw new IllegalStateException(j0.C("Cannot find required type element ", r5).toString());
    }

    @JvmStatic
    @JvmOverloads
    static XProcessingEnv create(Map<String, String> r10, d r11, a r12, c r13, XProcessingEnvConfig r14) {
        return Companion.create(r10, r11, r12, r13, r14);
    }

    default XTypeElement findTypeElement(KClass<?> r5) {
        Intrinsics.checkNotNullParameter(r5, "klass");
        String r10 = JvmClassMappingKt.getJavaClass(r5).getCanonicalName();
        Intrinsics.checkNotNull(r10);
        return findTypeElement(r10);
    }

    @JvmStatic
    @JvmOverloads
    static XProcessingEnv create(ProcessingEnvironment r5) {
        return Companion.create(r5);
    }

    @JvmStatic
    @JvmOverloads
    static XProcessingEnv create(ProcessingEnvironment r5, XProcessingEnvConfig r10) {
        return Companion.create(r5, r10);
    }

    default XType findType(KClass<?> r5) {
        Intrinsics.checkNotNullParameter(r5, "klass");
        String r10 = JvmClassMappingKt.getJavaClass(r5).getCanonicalName();
        Intrinsics.checkNotNull(r10);
        return findType(r10);
    }

    default XType requireType(x r5) {
        Intrinsics.checkNotNullParameter(r5, "typeName");
        XType r10 = findType(r5);
        if (r10 == null) goto L6;
        return r10;
    L6:
        throw new IllegalStateException(("cannot find required type " + r5).toString());
    }

    default XTypeElement requireTypeElement(x r5) {
        Intrinsics.checkNotNullParameter(r5, "typeName");
        return requireTypeElement(r5.toString());
    }

    default XTypeElement requireTypeElement(KClass<?> r5) {
        Intrinsics.checkNotNullParameter(r5, "klass");
        String r10 = JvmClassMappingKt.getJavaClass(r5).getCanonicalName();
        Intrinsics.checkNotNull(r10);
        return requireTypeElement(r10);
    }

    default XType requireType(XTypeName r5) {
        Intrinsics.checkNotNullParameter(r5, "typeName");
        if (r5.isPrimitive() == true) goto L5;
        Backend r10 = getBackend();
        int r11 = WhenMappings.$EnumSwitchMapping$0[r10.ordinal()];
        if (r11 == 1) goto L14;
        if (r11 != 2) goto L12;
        return requireType(r5.getKotlin$room_compiler_processing().toString());
    L12:
        throw new NoWhenBranchMatchedException();
    L14:
        return requireType(r5.getJava$room_compiler_processing());
    L5:
        return requireType(r5.getJava$room_compiler_processing());
    }

    default XType requireType(KClass<?> r5) {
        Intrinsics.checkNotNullParameter(r5, "klass");
        String r10 = JvmClassMappingKt.getJavaClass(r5).getCanonicalName();
        Intrinsics.checkNotNull(r10);
        return requireType(r10);
    }
}
