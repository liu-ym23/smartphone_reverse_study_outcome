package kotlin.reflect.jvm.internal.impl.resolve.constants;

import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;

/* JADX INFO: loaded from: classes3.dex */
public final class CharValue extends IntegerValueConstant<Character> {
    public CharValue(char r5) {
        super(Character.valueOf(r5));
    }

    private final String getPrintablePart(char r5) {
        if (r5 != '\b') goto L6;
        return "\\b";
    L6:
        if (r5 != '\t') goto L9;
        return "\\t";
    L9:
        if (r5 != '\n') goto L12;
        return "\\n";
    L12:
        if (r5 != '\f') goto L15;
        return "\\f";
    L15:
        if (r5 != '\r') goto L18;
        return "\\r";
    L18:
        if (isPrintableUnicode(r5) == true) goto L27;
        return "?";
    L27:
        return String.valueOf(r5);
    }

    private final boolean isPrintableUnicode(char r5) {
        byte r10 = (byte) Character.getType(r5);
        if (r10 != 0) goto L5;
    L17:
        return false;
    L5:
        if (r10 == 13) goto L17;
        if (r10 == 14) goto L17;
        if (r10 == 15) goto L17;
        if (r10 == 16) goto L17;
        if (r10 == 18) goto L17;
        if (r10 == 19) goto L17;
        return true;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue
    public /* bridge */ /* synthetic */ KotlinType getType(ModuleDescriptor r5) {
        return getType(r5);
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue
    public String toString() {
        return String.format("\\u%04X ('%s')", Arrays.copyOf(new Object[]{Integer.valueOf(getValue().charValue()), getPrintablePart(getValue().charValue())}, 2));
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue
    public SimpleType getType(ModuleDescriptor r5) {
        Intrinsics.checkNotNullParameter(r5, "module");
        return r5.getBuiltIns().getCharType();
    }
}
