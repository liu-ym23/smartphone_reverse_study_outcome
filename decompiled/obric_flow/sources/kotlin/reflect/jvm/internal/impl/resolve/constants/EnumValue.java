package kotlin.reflect.jvm.internal.impl.resolve.constants;

import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
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
@SourceDebugExtension({"SMAP\nconstantValues.kt\nKotlin\n*S Kotlin\n*F\n+ 1 constantValues.kt\norg/jetbrains/kotlin/resolve/constants/EnumValue\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,320:1\n1#2:321\n*E\n"})
public final class EnumValue extends ConstantValue<Pair<? extends ClassId, ? extends Name>> {
    private final ClassId enumClassId;
    private final Name enumEntryName;

    public EnumValue(ClassId r5, Name r10) {
        Intrinsics.checkNotNullParameter(r5, "enumClassId");
        Intrinsics.checkNotNullParameter(r10, "enumEntryName");
        super(TuplesKt.to(r5, r10));
        this.enumClassId = r5;
        this.enumEntryName = r10;
    }

    public final Name getEnumEntryName() {
        return this.enumEntryName;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue
    public KotlinType getType(ModuleDescriptor r5) {
        Intrinsics.checkNotNullParameter(r5, "module");
        ClassDescriptor r10 = FindClassInModuleKt.findClassAcrossModuleDependencies(r5, this.enumClassId);
        SimpleType r11 = null;
        if (r10 != null) goto L5;
    L10:
        if (r11 == null) goto L12;
        return r11;
    L12:
        return ErrorUtils.createErrorType(ErrorTypeKind.ERROR_ENUM_TYPE, new String[]{this.enumClassId.toString(), this.enumEntryName.toString()});
    L5:
        if (DescriptorUtils.isEnumClass(r10) == true) goto L8;
        r10 = null;
    L8:
        if (r10 == null) goto L10;
        r11 = r10.getDefaultType();
        goto L10
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue
    public String toString() {
        StringBuilder r5 = new StringBuilder();
        r5.append(this.enumClassId.getShortClassName());
        r5.append('.');
        r5.append(this.enumEntryName);
        return r5.toString();
    }
}
