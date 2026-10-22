package kotlin.reflect.jvm.internal.impl.types.error;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;

/* JADX INFO: loaded from: classes3.dex */
public final class ErrorUtils {
    public static final ErrorUtils INSTANCE = null;
    private static final ErrorClassDescriptor errorClass = null;
    private static final ModuleDescriptor errorModule = null;
    private static final PropertyDescriptor errorProperty = null;
    private static final Set<PropertyDescriptor> errorPropertyGroup = null;
    private static final KotlinType errorPropertyType = null;
    private static final KotlinType errorTypeForLoopInSupertypes = null;

    static {
        INSTANCE = new ErrorUtils();
        errorModule = ErrorModuleDescriptor.INSTANCE;
        String r10 = String.format(ErrorEntity.ERROR_CLASS.getDebugText(), Arrays.copyOf(new Object[]{"unknown class"}, 1));
        Intrinsics.checkNotNullExpressionValue(r10, "format(this, *args)");
        Name r11 = Name.special(r10);
        Intrinsics.checkNotNullExpressionValue(r11, "special(ErrorEntity.ERRO….format(\"unknown class\"))");
        errorClass = new ErrorClassDescriptor(r11);
        errorTypeForLoopInSupertypes = createErrorType(ErrorTypeKind.CYCLIC_SUPERTYPES, new String[0]);
        errorPropertyType = createErrorType(ErrorTypeKind.ERROR_PROPERTY_TYPE, new String[0]);
        ErrorPropertyDescriptor r12 = new ErrorPropertyDescriptor();
        errorProperty = r12;
        errorPropertyGroup = SetsKt.setOf(r12);
    }

    private ErrorUtils() {
    }

    @JvmStatic
    public static final ErrorScope createErrorScope(ErrorScopeKind r10, boolean r11, String... r12) {
        Intrinsics.checkNotNullParameter(r10, "kind");
        Intrinsics.checkNotNullParameter(r12, "formatParams");
        if (r11 == false) goto L6;
        return new ThrowingScope(r10, (String[]) Arrays.copyOf(r12, r12.length));
    L6:
        return new ErrorScope(r10, (String[]) Arrays.copyOf(r12, r12.length));
    }

    @JvmStatic
    public static final ErrorScope createErrorScope(ErrorScopeKind r10, String... r11) {
        Intrinsics.checkNotNullParameter(r10, "kind");
        Intrinsics.checkNotNullParameter(r11, "formatParams");
        return createErrorScope(r10, false, (String[]) Arrays.copyOf(r11, r11.length));
    }

    @JvmStatic
    public static final ErrorType createErrorType(ErrorTypeKind r10, String... r11) {
        Intrinsics.checkNotNullParameter(r10, "kind");
        Intrinsics.checkNotNullParameter(r11, "formatParams");
        return INSTANCE.createErrorTypeWithArguments(r10, CollectionsKt.emptyList(), (String[]) Arrays.copyOf(r11, r11.length));
    }

    @JvmStatic
    public static final boolean isError(DeclarationDescriptor r10) {
        if (r10 == null) goto L10;
        ErrorUtils r11 = INSTANCE;
        if (r11.isErrorClass(r10) == false) goto L6;
    L9:
        return true;
    L6:
        if (r11.isErrorClass(r10.getContainingDeclaration()) == true) goto L9;
        if (r10 == errorModule) goto L9;
    L10:
        return false;
    }

    private final boolean isErrorClass(DeclarationDescriptor r10) {
        return r10 instanceof ErrorClassDescriptor;
    }

    @JvmStatic
    public static final boolean isUninferredTypeVariable(KotlinType r10) {
        if (r10 != null) goto L5;
        return false;
    L5:
        TypeConstructor r11 = r10.getConstructor();
        if ((r11 instanceof ErrorTypeConstructor) == true) goto L8;
        return false;
    L8:
        if (((ErrorTypeConstructor) r11).getKind() != ErrorTypeKind.UNINFERRED_TYPE_VARIABLE) goto L12;
        return true;
    L12:
        return false;
    }

    public final ErrorType createErrorType(ErrorTypeKind r10, TypeConstructor r11, String... r12) {
        Intrinsics.checkNotNullParameter(r10, "kind");
        Intrinsics.checkNotNullParameter(r11, "typeConstructor");
        Intrinsics.checkNotNullParameter(r12, "formatParams");
        return createErrorTypeWithArguments(r10, CollectionsKt.emptyList(), r11, (String[]) Arrays.copyOf(r12, r12.length));
    }

    public final ErrorTypeConstructor createErrorTypeConstructor(ErrorTypeKind r10, String... r11) {
        Intrinsics.checkNotNullParameter(r10, "kind");
        Intrinsics.checkNotNullParameter(r11, "formatParams");
        return new ErrorTypeConstructor(r10, (String[]) Arrays.copyOf(r11, r11.length));
    }

    public final ErrorType createErrorTypeWithArguments(ErrorTypeKind r10, List<? extends TypeProjection> r11, TypeConstructor r12, String... r13) {
        Intrinsics.checkNotNullParameter(r10, "kind");
        Intrinsics.checkNotNullParameter(r11, "arguments");
        Intrinsics.checkNotNullParameter(r12, "typeConstructor");
        Intrinsics.checkNotNullParameter(r13, "formatParams");
        return new ErrorType(r12, createErrorScope(ErrorScopeKind.ERROR_TYPE_SCOPE, new String[]{r12.toString()}), r10, r11, false, (String[]) Arrays.copyOf(r13, r13.length));
    }

    public final ErrorType createErrorTypeWithArguments(ErrorTypeKind r10, List<? extends TypeProjection> r11, String... r12) {
        Intrinsics.checkNotNullParameter(r10, "kind");
        Intrinsics.checkNotNullParameter(r11, "arguments");
        Intrinsics.checkNotNullParameter(r12, "formatParams");
        return createErrorTypeWithArguments(r10, r11, createErrorTypeConstructor(r10, (String[]) Arrays.copyOf(r12, r12.length)), (String[]) Arrays.copyOf(r12, r12.length));
    }

    public final ErrorClassDescriptor getErrorClass() {
        return errorClass;
    }

    public final ModuleDescriptor getErrorModule() {
        return errorModule;
    }

    public final Set<PropertyDescriptor> getErrorPropertyGroup() {
        return errorPropertyGroup;
    }

    public final KotlinType getErrorPropertyType() {
        return errorPropertyType;
    }

    public final KotlinType getErrorTypeForLoopInSupertypes() {
        return errorTypeForLoopInSupertypes;
    }
}
