package kotlin.reflect.jvm.internal.impl.resolve.constants;

import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;

/* JADX INFO: loaded from: classes3.dex */
public final class CharValue extends IntegerValueConstant<Character> {
    public CharValue(char r10) {
        super(Character.valueOf(r10));
    }

    private final String getPrintablePart(char r10) {
        if (r10 != '\b') goto L6;
        return "\\b";
    L6:
        if (r10 != '\t') goto L9;
        return "\\t";
    L9:
        if (r10 != '\n') goto L12;
        return "\\n";
    L12:
        if (r10 != '\f') goto L15;
        return "\\f";
    L15:
        if (r10 != '\r') goto L18;
        return "\\r";
    L18:
        if (isPrintableUnicode(r10) == true) goto L27;
        return "?";
    L27:
        return String.valueOf(r10);
    }

    private final boolean isPrintableUnicode(char r10) {
        byte r11 = (byte) Character.getType(r10);
        if (r11 != 0) goto L5;
    L17:
        return false;
    L5:
        if (r11 == 13) goto L17;
        if (r11 == 14) goto L17;
        if (r11 == 15) goto L17;
        if (r11 == 16) goto L17;
        if (r11 == 18) goto L17;
        if (r11 == 19) goto L17;
        return true;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue
    public /* bridge */ /* synthetic */ KotlinType getType(ModuleDescriptor r10) {
        return getType(r10);
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue
    public SimpleType getType(ModuleDescriptor r10) {
        Intrinsics.checkNotNullParameter(r10, "module");
        SimpleType r11 = r10.getBuiltIns().getCharType();
        Intrinsics.checkNotNullExpressionValue(r11, "module.builtIns.charType");
        return r11;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue
    public String toString() {
        String r10 = String.format("\\u%04X ('%s')", Arrays.copyOf(new Object[]{Integer.valueOf(getValue().charValue()), getPrintablePart(getValue().charValue())}, 2));
        Intrinsics.checkNotNullExpressionValue(r10, "format(this, *args)");
        return r10;
    }
}
