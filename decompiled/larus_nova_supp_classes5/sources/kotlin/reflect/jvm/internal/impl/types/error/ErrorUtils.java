package kotlin.reflect.jvm.internal.impl.types.error;

import com.ss.android.ugc.effectmanager.EffectConfiguration;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class ErrorUtils {
    public static final ErrorUtils INSTANCE = null;
    private static final ErrorClassDescriptor errorClass = null;
    private static final ModuleDescriptor errorModule = null;
    private static final PropertyDescriptor errorProperty = null;
    private static final Set<PropertyDescriptor> errorPropertyGroup = null;
    private static final KotlinType errorPropertyType = null;
    private static final KotlinType errorTypeForLoopInSupertypes = null;

    private ErrorUtils() {
    }

    static {
        INSTANCE = new ErrorUtils();
        errorModule = ErrorModuleDescriptor.INSTANCE;
        errorClass = new ErrorClassDescriptor(Name.special(String.format(ErrorEntity.ERROR_CLASS.getDebugText(), Arrays.copyOf(new Object[]{"unknown class"}, 1))));
        errorTypeForLoopInSupertypes = createErrorType(ErrorTypeKind.CYCLIC_SUPERTYPES, new String[0]);
        errorPropertyType = createErrorType(ErrorTypeKind.ERROR_PROPERTY_TYPE, new String[0]);
        ErrorPropertyDescriptor r0 = new ErrorPropertyDescriptor();
        errorProperty = r0;
        errorPropertyGroup = SetsKt.setOf(r0);
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

    @JvmStatic
    public static final boolean isError(DeclarationDescriptor r2) {
        if (r2 == null) goto L10;
        ErrorUtils r0 = INSTANCE;
        if (r0.isErrorClass(r2) == false) goto L6;
    L9:
        return true;
    L6:
        if (r0.isErrorClass(r2.getContainingDeclaration()) == true) goto L9;
        if (r2 == errorModule) goto L9;
    L10:
        return false;
    }

    private final boolean isErrorClass(DeclarationDescriptor r1) {
        return r1 instanceof ErrorClassDescriptor;
    }

    @JvmStatic
    public static final boolean isUninferredTypeVariable(KotlinType r2) {
        if (r2 != null) goto L5;
        return false;
    L5:
        TypeConstructor r3 = r2.getConstructor();
        if ((r3 instanceof ErrorTypeConstructor) == true) goto L8;
        return false;
    L8:
        if (((ErrorTypeConstructor) r3).getKind() != ErrorTypeKind.UNINFERRED_TYPE_VARIABLE) goto L12;
        return true;
    L12:
        return false;
    }

    public final String unresolvedTypeAsItIs(KotlinType r2) {
        Intrinsics.checkNotNullParameter(r2, EffectConfiguration.KEY_TYPE);
        TypeUtilsKt.isUnresolvedType(r2);
        TypeConstructor r3 = r2.getConstructor();
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type org.jetbrains.kotlin.types.error.ErrorTypeConstructor");
        return ((ErrorTypeConstructor) r3).getParam(0);
    }

    @JvmStatic
    public static final ErrorScope createErrorScope(ErrorScopeKind r1, String... r2) {
        Intrinsics.checkNotNullParameter(r1, "kind");
        Intrinsics.checkNotNullParameter(r2, "formatParams");
        return createErrorScope(r1, false, (String[]) Arrays.copyOf(r2, r2.length));
    }

    @JvmStatic
    public static final ErrorType createErrorType(ErrorTypeKind r3, String... r4) {
        Intrinsics.checkNotNullParameter(r3, "kind");
        Intrinsics.checkNotNullParameter(r4, "formatParams");
        return INSTANCE.createErrorTypeWithArguments(r3, CollectionsKt.emptyList(), (String[]) Arrays.copyOf(r4, r4.length));
    }

    public final ErrorTypeConstructor createErrorTypeConstructor(ErrorTypeKind r3, String... r4) {
        Intrinsics.checkNotNullParameter(r3, "kind");
        Intrinsics.checkNotNullParameter(r4, "formatParams");
        return new ErrorTypeConstructor(r3, (String[]) Arrays.copyOf(r4, r4.length));
    }

    @JvmStatic
    public static final ErrorScope createErrorScope(ErrorScopeKind r1, boolean r2, String... r3) {
        Intrinsics.checkNotNullParameter(r1, "kind");
        Intrinsics.checkNotNullParameter(r3, "formatParams");
        if (r2 == false) goto L6;
        return new ThrowingScope(r1, (String[]) Arrays.copyOf(r3, r3.length));
    L6:
        return new ErrorScope(r1, (String[]) Arrays.copyOf(r3, r3.length));
    }

    public final ErrorType createErrorType(ErrorTypeKind r3, TypeConstructor r4, String... r5) {
        Intrinsics.checkNotNullParameter(r3, "kind");
        Intrinsics.checkNotNullParameter(r4, "typeConstructor");
        Intrinsics.checkNotNullParameter(r5, "formatParams");
        return createErrorTypeWithArguments(r3, CollectionsKt.emptyList(), r4, (String[]) Arrays.copyOf(r5, r5.length));
    }

    public final ErrorType createErrorTypeWithArguments(ErrorTypeKind r3, List<? extends TypeProjection> r4, String... r5) {
        Intrinsics.checkNotNullParameter(r3, "kind");
        Intrinsics.checkNotNullParameter(r4, "arguments");
        Intrinsics.checkNotNullParameter(r5, "formatParams");
        return createErrorTypeWithArguments(r3, r4, createErrorTypeConstructor(r3, (String[]) Arrays.copyOf(r5, r5.length)), (String[]) Arrays.copyOf(r5, r5.length));
    }

    public final ErrorType createErrorTypeWithArguments(ErrorTypeKind r9, List<? extends TypeProjection> r10, TypeConstructor r11, String... r12) {
        Intrinsics.checkNotNullParameter(r9, "kind");
        Intrinsics.checkNotNullParameter(r10, "arguments");
        Intrinsics.checkNotNullParameter(r11, "typeConstructor");
        Intrinsics.checkNotNullParameter(r12, "formatParams");
        return new ErrorType(r11, createErrorScope(ErrorScopeKind.ERROR_TYPE_SCOPE, new String[]{r11.toString()}), r9, r10, false, (String[]) Arrays.copyOf(r12, r12.length));
    }
}
