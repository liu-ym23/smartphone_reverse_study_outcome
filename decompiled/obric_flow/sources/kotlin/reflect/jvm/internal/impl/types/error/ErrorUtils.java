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
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;

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
        errorClass = new ErrorClassDescriptor(Name.special(String.format(ErrorEntity.ERROR_CLASS.getDebugText(), Arrays.copyOf(new Object[]{"unknown class"}, 1))));
        errorTypeForLoopInSupertypes = createErrorType(ErrorTypeKind.CYCLIC_SUPERTYPES, new String[0]);
        errorPropertyType = createErrorType(ErrorTypeKind.ERROR_PROPERTY_TYPE, new String[0]);
        ErrorPropertyDescriptor r5 = new ErrorPropertyDescriptor();
        errorProperty = r5;
        errorPropertyGroup = SetsKt.setOf(r5);
    }

    private ErrorUtils() {
    }

    @JvmStatic
    public static final ErrorScope createErrorScope(ErrorScopeKind r5, String... r10) {
        Intrinsics.checkNotNullParameter(r5, "kind");
        Intrinsics.checkNotNullParameter(r10, "formatParams");
        return createErrorScope(r5, false, (String[]) Arrays.copyOf(r10, r10.length));
    }

    @JvmStatic
    public static final ErrorType createErrorType(ErrorTypeKind r5, String... r10) {
        Intrinsics.checkNotNullParameter(r5, "kind");
        Intrinsics.checkNotNullParameter(r10, "formatParams");
        return INSTANCE.createErrorTypeWithArguments(r5, CollectionsKt.emptyList(), (String[]) Arrays.copyOf(r10, r10.length));
    }

    @JvmStatic
    public static final boolean isError(DeclarationDescriptor r5) {
        if (r5 == null) goto L10;
        ErrorUtils r10 = INSTANCE;
        if (r10.isErrorClass(r5) == false) goto L6;
    L9:
        return true;
    L6:
        if (r10.isErrorClass(r5.getContainingDeclaration()) == true) goto L9;
        if (r5 == errorModule) goto L9;
    L10:
        return false;
    }

    private final boolean isErrorClass(DeclarationDescriptor r5) {
        return r5 instanceof ErrorClassDescriptor;
    }

    @JvmStatic
    public static final boolean isUninferredTypeVariable(KotlinType r5) {
        if (r5 != null) goto L5;
        return false;
    L5:
        TypeConstructor r10 = r5.getConstructor();
        if ((r10 instanceof ErrorTypeConstructor) == true) goto L8;
        return false;
    L8:
        if (((ErrorTypeConstructor) r10).getKind() != ErrorTypeKind.UNINFERRED_TYPE_VARIABLE) goto L12;
        return true;
    L12:
        return false;
    }

    public final ErrorTypeConstructor createErrorTypeConstructor(ErrorTypeKind r5, String... r10) {
        Intrinsics.checkNotNullParameter(r5, "kind");
        Intrinsics.checkNotNullParameter(r10, "formatParams");
        return new ErrorTypeConstructor(r5, (String[]) Arrays.copyOf(r10, r10.length));
    }

    public final ErrorType createErrorTypeWithArguments(ErrorTypeKind r5, List<? extends TypeProjection> r10, String... r11) {
        Intrinsics.checkNotNullParameter(r5, "kind");
        Intrinsics.checkNotNullParameter(r10, "arguments");
        Intrinsics.checkNotNullParameter(r11, "formatParams");
        return createErrorTypeWithArguments(r5, r10, createErrorTypeConstructor(r5, (String[]) Arrays.copyOf(r11, r11.length)), (String[]) Arrays.copyOf(r11, r11.length));
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

    public final String unresolvedTypeAsItIs(KotlinType r5) {
        Intrinsics.checkNotNullParameter(r5, "type");
        TypeUtilsKt.isUnresolvedType(r5);
        TypeConstructor r10 = r5.getConstructor();
        Intrinsics.checkNotNull(r10, "null cannot be cast to non-null type org.jetbrains.kotlin.types.error.ErrorTypeConstructor");
        return ((ErrorTypeConstructor) r10).getParam(0);
    }

    @JvmStatic
    public static final ErrorScope createErrorScope(ErrorScopeKind r5, boolean r10, String... r11) {
        Intrinsics.checkNotNullParameter(r5, "kind");
        Intrinsics.checkNotNullParameter(r11, "formatParams");
        if (r10 == false) goto L6;
        return new ThrowingScope(r5, (String[]) Arrays.copyOf(r11, r11.length));
    L6:
        return new ErrorScope(r5, (String[]) Arrays.copyOf(r11, r11.length));
    }

    public final ErrorType createErrorType(ErrorTypeKind r5, TypeConstructor r10, String... r11) {
        Intrinsics.checkNotNullParameter(r5, "kind");
        Intrinsics.checkNotNullParameter(r10, "typeConstructor");
        Intrinsics.checkNotNullParameter(r11, "formatParams");
        return createErrorTypeWithArguments(r5, CollectionsKt.emptyList(), r10, (String[]) Arrays.copyOf(r11, r11.length));
    }

    public final ErrorType createErrorTypeWithArguments(ErrorTypeKind r10, List<? extends TypeProjection> r11, TypeConstructor r12, String... r13) {
        Intrinsics.checkNotNullParameter(r10, "kind");
        Intrinsics.checkNotNullParameter(r11, "arguments");
        Intrinsics.checkNotNullParameter(r12, "typeConstructor");
        Intrinsics.checkNotNullParameter(r13, "formatParams");
        return new ErrorType(r12, createErrorScope(ErrorScopeKind.ERROR_TYPE_SCOPE, new String[]{r12.toString()}), r10, r11, false, (String[]) Arrays.copyOf(r13, r13.length));
    }
}
