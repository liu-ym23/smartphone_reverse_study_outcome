package androidx.room.compiler.processing.javac;

import androidx.room.compiler.codegen.XTypeName;
import androidx.room.compiler.processing.XEquality;
import androidx.room.compiler.processing.XNullability;
import androidx.room.compiler.processing.XRawType;
import androidx.room.compiler.processing.XType;
import androidx.room.compiler.processing.XTypeElement;
import androidx.room.compiler.processing.javac.kotlin.KmType;
import androidx.room.compiler.processing.ksp.KSTypeJavaPoetExtKt;
import com.google.auto.common.o0;
import com.squareup.javapoet.x;
import java.util.List;
import javax.lang.model.type.TypeKind;
import javax.lang.model.type.TypeMirror;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\b \u0018\u00002\u00020\u00012\u00020\u0002B!\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0013\u001a\u00020\u000b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0096\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0019\u001a\u00020\u0018H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\u0000H\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001d\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u001d\u0010\rJ\u000f\u0010\u001e\u001a\u00020\u0018H\u0016¢\u0006\u0004\b\u001e\u0010\u001aJ\u0011\u0010\u001f\u001a\u0004\u0018\u00010\u0001H\u0016¢\u0006\u0004\b\u001f\u0010 J\u0017\u0010!\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u0001H\u0016¢\u0006\u0004\b!\u0010\"J\u001b\u0010$\u001a\u00020\u000b2\n\u0010\u0012\u001a\u0006\u0012\u0002\b\u00030#H\u0016¢\u0006\u0004\b$\u0010%J\u0017\u0010&\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u0001H\u0016¢\u0006\u0004\b&\u0010\"J\u0017\u0010(\u001a\u00020\u00002\u0006\u0010'\u001a\u00020\u0007H$¢\u0006\u0004\b(\u0010)J\r\u0010*\u001a\u00020\u0000¢\u0006\u0004\b*\u0010\u001cJ\r\u0010+\u001a\u00020\u0000¢\u0006\u0004\b+\u0010\u001cR\u001a\u0010\u0004\u001a\u00020\u00038\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0004\u0010,\u001a\u0004\b-\u0010.R\u001a\u0010\u0006\u001a\u00020\u00058\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0006\u0010/\u001a\u0004\b0\u00101R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\b\u00102\u001a\u0004\b3\u00104R\u001b\u0010:\u001a\u0002058VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b6\u00107\u001a\u0004\b8\u00109R!\u0010?\u001a\b\u0012\u0004\u0012\u00020\u00000;8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b<\u00107\u001a\u0004\b=\u0010>R\u001d\u0010D\u001a\u0004\u0018\u00010@8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\bA\u00107\u001a\u0004\bB\u0010CR\u001f\u0010J\u001a\u00060Ej\u0002`F8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\bG\u00107\u001a\u0004\bH\u0010IR\u001b\u0010M\u001a\u00020\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bK\u00107\u001a\u0004\bL\u0010\u0010R\u0016\u0010Q\u001a\u0004\u0018\u00010N8&X¦\u0004¢\u0006\u0006\u001a\u0004\bO\u0010PR\u0014\u0010'\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bR\u00104¨\u0006S"}, d2 = {"Landroidx/room/compiler/processing/javac/JavacType;", "Landroidx/room/compiler/processing/XType;", "Landroidx/room/compiler/processing/XEquality;", "Landroidx/room/compiler/processing/javac/JavacProcessingEnv;", "env", "Ljavax/lang/model/type/TypeMirror;", "typeMirror", "Landroidx/room/compiler/processing/XNullability;", "maybeNullability", "<init>", "(Landroidx/room/compiler/processing/javac/JavacProcessingEnv;Ljavax/lang/model/type/TypeMirror;Landroidx/room/compiler/processing/XNullability;)V", "", "isError", "()Z", "Landroidx/room/compiler/codegen/XTypeName;", "asTypeName", "()Landroidx/room/compiler/codegen/XTypeName;", "", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "defaultValue", "()Ljava/lang/String;", "boxed", "()Landroidx/room/compiler/processing/javac/JavacType;", "isNone", "toString", "extendsBound", "()Landroidx/room/compiler/processing/XType;", "isAssignableFrom", "(Landroidx/room/compiler/processing/XType;)Z", "Lkotlin/reflect/KClass;", "isTypeOf", "(Lkotlin/reflect/KClass;)Z", "isSameType", "nullability", "copyWithNullability", "(Landroidx/room/compiler/processing/XNullability;)Landroidx/room/compiler/processing/javac/JavacType;", "makeNullable", "makeNonNullable", "Landroidx/room/compiler/processing/javac/JavacProcessingEnv;", "getEnv$room_compiler_processing", "()Landroidx/room/compiler/processing/javac/JavacProcessingEnv;", "Ljavax/lang/model/type/TypeMirror;", "getTypeMirror", "()Ljavax/lang/model/type/TypeMirror;", "Landroidx/room/compiler/processing/XNullability;", "getMaybeNullability$room_compiler_processing", "()Landroidx/room/compiler/processing/XNullability;", "Landroidx/room/compiler/processing/XRawType;", "rawType$delegate", "Lkotlin/Lazy;", "getRawType", "()Landroidx/room/compiler/processing/XRawType;", "rawType", "", "superTypes$delegate", "getSuperTypes", "()Ljava/util/List;", "superTypes", "Landroidx/room/compiler/processing/javac/JavacTypeElement;", "typeElement$delegate", "getTypeElement", "()Landroidx/room/compiler/processing/javac/JavacTypeElement;", "typeElement", "Lcom/squareup/javapoet/x;", "Lcom/squareup/kotlinpoet/javapoet/JTypeName;", "typeName$delegate", "getTypeName", "()Lcom/squareup/javapoet/x;", "typeName", "xTypeName$delegate", "getXTypeName", "xTypeName", "Landroidx/room/compiler/processing/javac/kotlin/KmType;", "getKotlinType", "()Landroidx/room/compiler/processing/javac/kotlin/KmType;", "kotlinType", "getNullability", "room-compiler-processing"}, k = 1, mv = {1, 7, 1}, xi = 48)
public abstract class JavacType implements XType, XEquality {
    private final JavacProcessingEnv env;
    private final XNullability maybeNullability;
    private final Lazy rawType$delegate;
    private final Lazy superTypes$delegate;
    private final Lazy typeElement$delegate;
    private final TypeMirror typeMirror;
    private final Lazy typeName$delegate;
    private final Lazy xTypeName$delegate;

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r5 = new int[TypeKind.values().length];
            r5[TypeKind.BOOLEAN.ordinal()] = 1;     // Catch: NoSuchFieldError -> L13
        L23:
            r5[TypeKind.BYTE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L14
        L35:
            r5[TypeKind.SHORT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L15
        L25:
            r5[TypeKind.INT.ordinal()] = 4;     // Catch: NoSuchFieldError -> L16
        L27:
            r5[TypeKind.CHAR.ordinal()] = 5;     // Catch: NoSuchFieldError -> L17
        L21:
            r5[TypeKind.LONG.ordinal()] = 6;     // Catch: NoSuchFieldError -> L18
        L29:
            r5[TypeKind.FLOAT.ordinal()] = 7;     // Catch: NoSuchFieldError -> L19
        L31:
            r5[TypeKind.DOUBLE.ordinal()] = 8;     // Catch: NoSuchFieldError -> L20
        L11:
            $EnumSwitchMapping$0 = r5;
        }
    }

    public JavacType(JavacProcessingEnv r5, TypeMirror r10, XNullability r11) {
        Intrinsics.checkNotNullParameter(r5, "env");
        Intrinsics.checkNotNullParameter(r10, "typeMirror");
        this.env = r5;
        this.typeMirror = r10;
        this.maybeNullability = r11;
        this.rawType$delegate = LazyKt.lazy(new JavacType$rawType$2(this));
        this.superTypes$delegate = LazyKt.lazy(new JavacType$superTypes$2(this));
        this.typeElement$delegate = LazyKt.lazy(new JavacType$typeElement$2(this));
        this.typeName$delegate = LazyKt.lazy(new JavacType$typeName$2(this));
        this.xTypeName$delegate = LazyKt.lazy(new JavacType$xTypeName$2(this));
    }

    public static final /* synthetic */ XTypeName access$getXTypeName(JavacType r5) {
        return r5.getXTypeName();
    }

    private final XTypeName getXTypeName() {
        return (XTypeName) this.xTypeName$delegate.getValue();
    }

    @Override // androidx.room.compiler.processing.XType
    public XTypeName asTypeName() {
        return getXTypeName();
    }

    @Override // androidx.room.compiler.processing.XType
    public /* bridge */ /* synthetic */ XType boxed() {
        return boxed();
    }

    public abstract JavacType copyWithNullability(XNullability r5);

    @Override // androidx.room.compiler.processing.XType
    public String defaultValue() {
        TypeKind r5 = mo55getTypeMirror().getKind();
        if (r5 != null) goto L5;
        int r10 = -1;
    L6:
        switch(r10) {
            case 1: goto L12;
            case 2: goto L11;
            case 3: goto L11;
            case 4: goto L11;
            case 5: goto L11;
            case 6: goto L10;
            case 7: goto L9;
            case 8: goto L8;
            default: goto L7;
        };
    L7:
        return "null";
    L8:
        return "0.0";
    L9:
        return "0f";
    L10:
        return "0L";
    L11:
        return "0";
    L12:
        return "false";
    L5:
        r10 = WhenMappings.$EnumSwitchMapping$0[r5.ordinal()];
        goto L6
    }

    public boolean equals(Object r5) {
        return XEquality.Companion.equals(this, r5);
    }

    @Override // androidx.room.compiler.processing.XType
    public XType extendsBound() {
        TypeMirror r5 = TypeMirrorExtKt.extendsBound(mo55getTypeMirror());
        if (r5 == null) goto L33;
        JavacProcessingEnv r10 = this.env;
        KmType r11 = getKotlinType();
        if (r11 == null) goto L7;
        KmType r12 = r11.getExtendsBound();
    L8:
        XNullability r13 = this.maybeNullability;
        TypeKind r14 = r5.getKind();
        if (r14 != null) goto L11;
        int r15 = -1;
    L13:
        if (r15 != 1) goto L15;
        if (r12 == null) goto L30;
        XType r16 = new JavacArrayType(r10, o0.a(r5), r12);
    L34:
        return r16;
    L30:
        if (r13 == null) goto L32;
        r16 = new JavacArrayType(r10, o0.a(r5), r13, null);
        goto L34
    L32:
        r16 = new JavacArrayType(r10, o0.a(r5));
        goto L34
    L15:
        if (r15 == 2) goto L23;
        if (r12 == null) goto L18;
        r16 = new DefaultJavacType(r10, r5, r12);
        goto L34
    L18:
        if (r13 == null) goto L21;
        XType r17 = new DefaultJavacType(r10, r5, r13);
    L20:
        r16 = r17;
        goto L34
    L21:
        r16 = new DefaultJavacType(r10, r5);
        goto L34
    L23:
        if (r12 == null) goto L25;
        r16 = new JavacDeclaredType(r10, o0.b(r5), r12);
        goto L34
    L25:
        if (r13 == null) goto L27;
        r17 = new JavacDeclaredType(r10, o0.b(r5), r13);
        goto L20
    L27:
        r16 = new JavacDeclaredType(r10, o0.b(r5));
        goto L34
    L11:
        r15 = JavacProcessingEnv.WhenMappings.$EnumSwitchMapping$0[r14.ordinal()];
        goto L13
    L7:
        r12 = null;
        goto L8
    L33:
        return null;
    }

    public final JavacProcessingEnv getEnv$room_compiler_processing() {
        return this.env;
    }

    public abstract KmType getKotlinType();

    public final XNullability getMaybeNullability$room_compiler_processing() {
        return this.maybeNullability;
    }

    @Override // androidx.room.compiler.processing.XType
    public XNullability getNullability() {
        XNullability r5 = this.maybeNullability;
        if (r5 == null) goto L6;
        return r5;
    L6:
        throw new IllegalStateException("XType#nullibility cannot be called from this type because it is missing nullability information. Was this type derived from a type created with TypeMirror#toXProcessing(XProcessingEnv)?");
    }

    @Override // androidx.room.compiler.processing.XType
    public XRawType getRawType() {
        return (XRawType) this.rawType$delegate.getValue();
    }

    @Override // androidx.room.compiler.processing.XType
    public List<JavacType> getSuperTypes() {
        return (List) this.superTypes$delegate.getValue();
    }

    @Override // androidx.room.compiler.processing.XType
    public /* bridge */ /* synthetic */ XTypeElement getTypeElement() {
        return getTypeElement();
    }

    /* JADX INFO: renamed from: getTypeMirror */
    public TypeMirror mo55getTypeMirror() {
        return this.typeMirror;
    }

    @Override // androidx.room.compiler.processing.XType
    public x getTypeName() {
        return (x) this.typeName$delegate.getValue();
    }

    public int hashCode() {
        return XEquality.Companion.hashCode(getEqualityItems());
    }

    @Override // androidx.room.compiler.processing.XType
    public boolean isAssignableFrom(XType r5) {
        Intrinsics.checkNotNullParameter(r5, "other");
        if ((r5 instanceof JavacType) == true) goto L5;
    L7:
        return false;
    L5:
        if (this.env.getTypeUtils().isAssignable(((JavacType) r5).mo55getTypeMirror(), mo55getTypeMirror()) == false) goto L7;
        return true;
    }

    @Override // androidx.room.compiler.processing.XType
    public boolean isError() {
        if (mo55getTypeMirror().getKind() != TypeKind.ERROR) goto L5;
    L10:
        return true;
    L5:
        if (getKotlinType() != null) goto L7;
    L9:
        return false;
    L7:
        if (Intrinsics.areEqual(asTypeName().getJava$room_compiler_processing(), KSTypeJavaPoetExtKt.getERROR_JTYPE_NAME()) == false) goto L9;
        goto L9
    }

    @Override // androidx.room.compiler.processing.XType
    public boolean isNone() {
        if (mo55getTypeMirror().getKind() != TypeKind.NONE) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // androidx.room.compiler.processing.XType
    public boolean isSameType(XType r5) {
        Intrinsics.checkNotNullParameter(r5, "other");
        if ((r5 instanceof JavacType) == true) goto L5;
    L7:
        return false;
    L5:
        if (this.env.getTypeUtils().isSameType(mo55getTypeMirror(), ((JavacType) r5).mo55getTypeMirror()) == false) goto L7;
        return true;
    }

    @Override // androidx.room.compiler.processing.XType
    public boolean isTypeOf(KClass<?> r5) {
        Intrinsics.checkNotNullParameter(r5, "other");
        return o0.k(JvmClassMappingKt.getJavaClass(r5), mo55getTypeMirror());
    L5:
        return false;
    }

    @Override // androidx.room.compiler.processing.XType
    public /* bridge */ /* synthetic */ XType makeNonNullable() {
        return makeNonNullable();
    }

    @Override // androidx.room.compiler.processing.XType
    public /* bridge */ /* synthetic */ XType makeNullable() {
        return makeNullable();
    }

    public String toString() {
        return mo55getTypeMirror().toString();
    }

    @Override // androidx.room.compiler.processing.XType
    public JavacType boxed() {
        int r5 = -1;
        if (mo55getTypeMirror().getKind().isPrimitive() == false) goto L28;
        JavacProcessingEnv r10 = this.env;
        TypeMirror r11 = r10.getTypeUtils().boxedClass(o0.f(mo55getTypeMirror())).asType();
        KmType r12 = getKotlinType();
        XNullability r13 = XNullability.NULLABLE;
        TypeKind r14 = r11.getKind();
        if (r14 == null) goto L8;
        r5 = JavacProcessingEnv.WhenMappings.$EnumSwitchMapping$0[r14.ordinal()];
    L8:
        if (r5 == 1) goto L21;
        if (r5 == 2) goto L16;
        if (r12 == null) goto L12;
        JavacType r15 = new DefaultJavacType(r10, r11, r12);
    L50:
        return r15;
    L12:
        if (r13 == null) goto L14;
        r15 = new DefaultJavacType(r10, r11, r13);
        goto L50
    L14:
        r15 = new DefaultJavacType(r10, r11);
        goto L50
    L16:
        if (r12 == null) goto L18;
        r15 = new JavacDeclaredType(r10, o0.b(r11), r12);
        goto L50
    L18:
        if (r13 == null) goto L20;
        r15 = new JavacDeclaredType(r10, o0.b(r11), r13);
        goto L50
    L20:
        r15 = new JavacDeclaredType(r10, o0.b(r11));
        goto L50
    L21:
        if (r12 == null) goto L23;
        r15 = new JavacArrayType(r10, o0.a(r11), r12);
        goto L50
    L23:
        if (r13 == null) goto L26;
        JavacArrayType r16 = new JavacArrayType(r10, o0.a(r11), r13, null);
    L25:
        r15 = r16;
        goto L50
    L26:
        r15 = new JavacArrayType(r10, o0.a(r11));
        goto L50
    L28:
        if (mo55getTypeMirror().getKind() != TypeKind.VOID) goto L51;
        JavacProcessingEnv r17 = this.env;
        TypeMirror r18 = r17.getElementUtils().getTypeElement("java.lang.Void").asType();
        KmType r19 = getKotlinType();
        XNullability r20 = XNullability.NULLABLE;
        TypeKind r21 = r18.getKind();
        if (r21 == null) goto L33;
        r5 = JavacProcessingEnv.WhenMappings.$EnumSwitchMapping$0[r21.ordinal()];
    L33:
        if (r5 == 1) goto L45;
        if (r5 == 2) goto L40;
        if (r19 == null) goto L37;
        r15 = new DefaultJavacType(r17, r18, r19);
        goto L50
    L37:
        if (r20 == null) goto L39;
        r15 = new DefaultJavacType(r17, r18, r20);
        goto L50
    L39:
        r15 = new DefaultJavacType(r17, r18);
        goto L50
    L40:
        if (r19 == null) goto L42;
        r15 = new JavacDeclaredType(r17, o0.b(r18), r19);
        goto L50
    L42:
        if (r20 == null) goto L44;
        r15 = new JavacDeclaredType(r17, o0.b(r18), r20);
        goto L50
    L44:
        r15 = new JavacDeclaredType(r17, o0.b(r18));
        goto L50
    L45:
        if (r19 == null) goto L47;
        r15 = new JavacArrayType(r17, o0.a(r18), r19);
        goto L50
    L47:
        if (r20 == null) goto L49;
        r16 = new JavacArrayType(r17, o0.a(r18), r20, null);
        goto L25
    L49:
        r15 = new JavacArrayType(r17, o0.a(r18));
        goto L50
    L51:
        return this;
    }

    @Override // androidx.room.compiler.processing.XType
    public JavacTypeElement getTypeElement() {
        return (JavacTypeElement) this.typeElement$delegate.getValue();
    }

    @Override // androidx.room.compiler.processing.XType
    public final JavacType makeNonNullable() {
        XNullability r5 = getNullability();
        XNullability r10 = XNullability.NONNULL;
        if (r5 != r10) goto L6;
        return this;
    L6:
        return copyWithNullability(r10);
    }

    @Override // androidx.room.compiler.processing.XType
    public final JavacType makeNullable() {
        XNullability r5 = getNullability();
        XNullability r10 = XNullability.NULLABLE;
        if (r5 != r10) goto L6;
        return this;
    L6:
        if (mo55getTypeMirror().getKind().isPrimitive() == true) goto L13;
        if (mo55getTypeMirror().getKind() == TypeKind.VOID) goto L13;
        return copyWithNullability(r10);
    L13:
        return boxed().makeNullable();
    }
}
