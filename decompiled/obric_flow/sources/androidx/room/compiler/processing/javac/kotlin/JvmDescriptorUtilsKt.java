package androidx.room.compiler.processing.javac.kotlin;

import androidx.exifinterface.media.ExifInterface;
import com.google.auto.common.o0;
import com.squareup.javapoet.c;
import com.squareup.javapoet.e;
import com.squareup.javapoet.x;
import java.util.Arrays;
import javax.lang.model.element.Element;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.NestingKind;
import javax.lang.model.element.QualifiedNameable;
import javax.lang.model.element.TypeElement;
import javax.lang.model.element.VariableElement;
import javax.lang.model.type.ArrayType;
import javax.lang.model.type.DeclaredType;
import javax.lang.model.type.ExecutableType;
import javax.lang.model.type.IntersectionType;
import javax.lang.model.type.NoType;
import javax.lang.model.type.PrimitiveType;
import javax.lang.model.type.TypeKind;
import javax.lang.model.type.TypeMirror;
import javax.lang.model.type.TypeVariable;
import javax.lang.model.type.WildcardType;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0013\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0013\u0010\u0002\u001a\u00020\u0001*\u00020\u0004H\u0000¢\u0006\u0004\b\u0002\u0010\u0005\u001a\u0013\u0010\u0007\u001a\u00020\u0006*\u00020\u0001H\u0000¢\u0006\u0004\b\u0007\u0010\b\u001a\u0013\u0010\u0002\u001a\u00020\u0001*\u00020\tH\u0000¢\u0006\u0004\b\u0002\u0010\n\u001a\u0013\u0010\u0002\u001a\u00020\u0001*\u00020\u000bH\u0000¢\u0006\u0004\b\u0002\u0010\f\u001a\u0013\u0010\u0002\u001a\u00020\u0001*\u00020\rH\u0000¢\u0006\u0004\b\u0002\u0010\u000e\u001a\u0013\u0010\u0002\u001a\u00020\u0001*\u00020\u000fH\u0000¢\u0006\u0004\b\u0002\u0010\u0010\u001a\u0013\u0010\u0002\u001a\u00020\u0001*\u00020\u0011H\u0000¢\u0006\u0004\b\u0002\u0010\u0012\u001a\u0013\u0010\u0002\u001a\u00020\u0001*\u00020\u0013H\u0000¢\u0006\u0004\b\u0002\u0010\u0014\"\u0018\u0010\u0018\u001a\u00020\u0001*\u00020\u00158@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017\"\u001e\u0010\u0002\u001a\u00020\u0001*\u00020\u00198@X\u0080\u0004¢\u0006\f\u0012\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001a\u0010\u001b\"\u0018\u0010\u0002\u001a\u00020\u0001*\u00020\u001e8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001f\"\u0018\u0010\u0002\u001a\u00020\u0001*\u00020 8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010!¨\u0006\""}, d2 = {"Ljavax/lang/model/element/VariableElement;", "", "descriptor", "(Ljavax/lang/model/element/VariableElement;)Ljava/lang/String;", "Ljavax/lang/model/element/ExecutableElement;", "(Ljavax/lang/model/element/ExecutableElement;)Ljava/lang/String;", "Lcom/squareup/javapoet/x;", "typeNameFromJvmSignature", "(Ljava/lang/String;)Lcom/squareup/javapoet/x;", "Ljavax/lang/model/type/TypeMirror;", "(Ljavax/lang/model/type/TypeMirror;)Ljava/lang/String;", "Ljavax/lang/model/type/WildcardType;", "(Ljavax/lang/model/type/WildcardType;)Ljava/lang/String;", "Ljavax/lang/model/type/TypeVariable;", "(Ljavax/lang/model/type/TypeVariable;)Ljava/lang/String;", "Ljavax/lang/model/type/IntersectionType;", "(Ljavax/lang/model/type/IntersectionType;)Ljava/lang/String;", "Ljavax/lang/model/type/ArrayType;", "(Ljavax/lang/model/type/ArrayType;)Ljava/lang/String;", "Ljavax/lang/model/type/ExecutableType;", "(Ljavax/lang/model/type/ExecutableType;)Ljava/lang/String;", "Ljavax/lang/model/element/Element;", "getInternalName", "(Ljavax/lang/model/element/Element;)Ljava/lang/String;", "internalName", "Ljavax/lang/model/type/NoType;", "getDescriptor", "(Ljavax/lang/model/type/NoType;)Ljava/lang/String;", "getDescriptor$annotations", "(Ljavax/lang/model/type/NoType;)V", "Ljavax/lang/model/type/DeclaredType;", "(Ljavax/lang/model/type/DeclaredType;)Ljava/lang/String;", "Ljavax/lang/model/type/PrimitiveType;", "(Ljavax/lang/model/type/PrimitiveType;)Ljava/lang/String;", "room-compiler-processing"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class JvmDescriptorUtilsKt {

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1 = null;

        static {
            int[] r5 = new int[NestingKind.values().length];
            r5[NestingKind.TOP_LEVEL.ordinal()] = 1;     // Catch: NoSuchFieldError -> L21
        L43:
            r5[NestingKind.MEMBER.ordinal()] = 2;     // Catch: NoSuchFieldError -> L22
        L55:
            r5[NestingKind.LOCAL.ordinal()] = 3;     // Catch: NoSuchFieldError -> L23
        L45:
            r5[NestingKind.ANONYMOUS.ordinal()] = 4;     // Catch: NoSuchFieldError -> L24
        L10:
            $EnumSwitchMapping$0 = r5;
            int[] r10 = new int[TypeKind.values().length];
            r10[TypeKind.BYTE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L25
        L49:
            r10[TypeKind.CHAR.ordinal()] = 2;     // Catch: NoSuchFieldError -> L26
        L33:
            r10[TypeKind.DOUBLE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L27
        L47:
            r10[TypeKind.FLOAT.ordinal()] = 4;     // Catch: NoSuchFieldError -> L28
        L37:
            r10[TypeKind.INT.ordinal()] = 5;     // Catch: NoSuchFieldError -> L29
        L51:
            r10[TypeKind.LONG.ordinal()] = 6;     // Catch: NoSuchFieldError -> L30
        L39:
            r10[TypeKind.SHORT.ordinal()] = 7;     // Catch: NoSuchFieldError -> L31
        L41:
            r10[TypeKind.BOOLEAN.ordinal()] = 8;     // Catch: NoSuchFieldError -> L32
        L19:
            $EnumSwitchMapping$1 = r10;
        }
    }

    public static final String descriptor(VariableElement r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return r5.getSimpleName() + ':' + descriptor(r5.asType());
    }

    public static final String getDescriptor(NoType r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return ExifInterface.GPS_MEASUREMENT_INTERRUPTED;
    }

    public static /* synthetic */ void getDescriptor$annotations(NoType r5) {
    }

    public static final String getInternalName(Element r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        if ((r5 instanceof TypeElement) == false) goto L23;
        TypeElement r10 = (TypeElement) r5;
        NestingKind r11 = r10.getNestingKind();
        if (r11 != null) goto L7;
        int r12 = -1;
    L9:
        if (r12 == 1) goto L31;
        if (r12 == 2) goto L30;
        if (r12 == 3) goto L30;
        if (r12 == 4) goto L19;
        throw new IllegalStateException("Unsupported, nestingKind == null");
    L19:
        throw new IllegalStateException(("Unsupported nesting " + r10.getNestingKind()).toString());
    L30:
        return getInternalName(r10.getEnclosingElement()) + Typography.dollar + r10.getSimpleName();
    L31:
        return StringsKt.E(r10.getQualifiedName().toString(), '.', '/');
    L7:
        r12 = WhenMappings.$EnumSwitchMapping$0[r11.ordinal()];
        goto L9
    L23:
        if ((r5 instanceof ExecutableElement) == false) goto L26;
        return getInternalName(((ExecutableElement) r5).getEnclosingElement());
    L26:
        if ((r5 instanceof QualifiedNameable) == false) goto L29;
        return StringsKt.E(((QualifiedNameable) r5).getQualifiedName().toString(), '.', '/');
    L29:
        return r5.getSimpleName().toString();
    }

    public static final x typeNameFromJvmSignature(String r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if (r10.length() <= 0) goto L53;
        char r5 = r10.charAt(0);
        if (r5 != 'B') goto L8;
        return x.f;
    L8:
        if (r5 != 'C') goto L11;
        return x.f15025j;
    L11:
        if (r5 != 'D') goto L14;
        return x.f15027l;
    L14:
        if (r5 != 'F') goto L17;
        return x.f15026k;
    L17:
        if (r5 != 'I') goto L20;
        return x.f15023h;
    L20:
        if (r5 != 'J') goto L23;
        return x.f15024i;
    L23:
        if (r5 != 'S') goto L26;
        return x.g;
    L26:
        if (r5 != 'Z') goto L29;
        return x.e;
    L29:
        if (r5 != 'L') goto L47;
        int r11 = StringsKt.u(r10, ";");
        if (r11 <= 0) goto L45;
        int r12 = StringsKt.t(r10, '/', 0, 6);
        if (r12 >= 0) goto L35;
        int r13 = 1;
    L36:
        if (r12 >= 0) goto L38;
        String r14 = "";
    L39:
        int r15 = StringsKt.q(r10, Typography.dollar, r13, 4);
        if (r15 < 0) goto L54;
        String r16 = r10.substring(r13, r15);
        Object[] r17 = StringsKt.J(r10.substring(r15 + 1, r11), new char[]{Typography.dollar}, 0, 6).toArray(new String[0]);
        Intrinsics.checkNotNull(r17, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        String[] r18 = (String[]) r17;
        return e.o(r14, r16, (String[]) Arrays.copyOf(r18, r18.length));
    L54:
        return e.o(r14, r10.substring(r13, r11), new String[0]);
    L38:
        r14 = StringsKt.E(r10.substring(1, r12), '/', '.');
        goto L39
    L35:
        r13 = r12 + 1;
        goto L36
    L45:
        throw new IllegalStateException("invalid input ".concat(r10).toString());
    L47:
        if (r5 != '[') goto L51;
        return new c(typeNameFromJvmSignature(r10.substring(1)));
    L51:
        throw new IllegalStateException("unexpected jvm signature ".concat(r10).toString());
    L53:
        throw new IllegalStateException("Check failed.");
    }

    public static final String descriptor(ExecutableElement r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return r5.getSimpleName() + descriptor(o0.d(r5.asType()));
    }

    public static final String getDescriptor(DeclaredType r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return "L" + getInternalName(r5.asElement()) + ';';
    }

    public static final String descriptor(TypeMirror r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return (String) r5.accept(JvmDescriptorTypeVisitor.INSTANCE, Unit.INSTANCE);
    }

    public static final String getDescriptor(PrimitiveType r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        TypeKind r10 = r5.getKind();
        if (r10 != null) goto L5;
        int r11 = -1;
    L6:
        switch(r11) {
            case 1: goto L16;
            case 2: goto L15;
            case 3: goto L14;
            case 4: goto L13;
            case 5: goto L12;
            case 6: goto L11;
            case 7: goto L10;
            case 8: goto L9;
            default: goto L8;
        };
    L9:
        return "Z";
    L10:
        return ExifInterface.LATITUDE_SOUTH;
    L11:
        return "J";
    L12:
        return "I";
    L13:
        return "F";
    L14:
        return "D";
    L15:
        return "C";
    L16:
        return "B";
    L8:
        throw new IllegalStateException(("Unknown primitive type " + r5).toString());
    L5:
        r11 = WhenMappings.$EnumSwitchMapping$1[r10.ordinal()];
        goto L6
    }

    public static final String descriptor(WildcardType r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return "";
    }

    public static final String descriptor(TypeVariable r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return descriptor(r5.getUpperBound());
    }

    public static final String descriptor(IntersectionType r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return descriptor((TypeMirror) r5.getBounds().get(0));
    }

    public static final String descriptor(ArrayType r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return "[" + descriptor(r5.getComponentType());
    }

    public static final String descriptor(ExecutableType r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return "(" + CollectionsKt.q(r10.getParameterTypes(), "", null, null, 0, null, JvmDescriptorUtilsKt$descriptor$parameterDescriptors$1.INSTANCE, 30) + ')' + descriptor(r10.getReturnType());
    }
}
