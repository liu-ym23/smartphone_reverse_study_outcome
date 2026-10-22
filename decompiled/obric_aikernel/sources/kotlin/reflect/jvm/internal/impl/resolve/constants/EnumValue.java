package kotlin.reflect.jvm.internal.impl.resolve.constants;

import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FindClassInModuleKt;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorUtils;

/* JADX INFO: loaded from: classes3.dex */
public final class EnumValue extends ConstantValue<Pair<? extends ClassId, ? extends Name>> {
    private final ClassId enumClassId;
    private final Name enumEntryName;

    public EnumValue(ClassId r10, Name r11) {
        Intrinsics.checkNotNullParameter(r10, "enumClassId");
        Intrinsics.checkNotNullParameter(r11, "enumEntryName");
        super(TuplesKt.to(r10, r11));
        this.enumClassId = r10;
        this.enumEntryName = r11;
    }

    public final Name getEnumEntryName() {
        return this.enumEntryName;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue
    public KotlinType getType(ModuleDescriptor r10) {
        Intrinsics.checkNotNullParameter(r10, "module");
        ClassDescriptor r11 = FindClassInModuleKt.findClassAcrossModuleDependencies(r10, this.enumClassId);
        SimpleType r12 = null;
        if (r11 != null) goto L5;
    L10:
        if (r12 != null) goto L13;
        ErrorTypeKind r13 = ErrorTypeKind.ERROR_ENUM_TYPE;
        String r14 = this.enumClassId.toString();
        Intrinsics.checkNotNullExpressionValue(r14, "enumClassId.toString()");
        String r15 = this.enumEntryName.toString();
        Intrinsics.checkNotNullExpressionValue(r15, "enumEntryName.toString()");
        return ErrorUtils.createErrorType(r13, new String[]{r14, r15});
    L13:
        return r12;
    L5:
        if (DescriptorUtils.isEnumClass(r11) == true) goto L8;
        r11 = null;
    L8:
        if (r11 == null) goto L10;
        r12 = r11.getDefaultType();
        goto L10
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue
    public String toString() {
        StringBuilder r10 = new StringBuilder();
        r10.append(this.enumClassId.getShortClassName());
        r10.append('.');
        r10.append(this.enumEntryName);
        return r10.toString();
    }
}
