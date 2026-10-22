package kotlin.reflect.jvm.internal.impl.load.kotlin;

import com.bytedance.common.wschannel.WsConstants;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmClassName;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes3.dex */
final class JvmTypeFactoryImpl implements JvmTypeFactory<JvmType> {
    public static final JvmTypeFactoryImpl INSTANCE = null;

    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r10 = new int[PrimitiveType.values().length];
            r10[PrimitiveType.BOOLEAN.ordinal()] = 1;     // Catch: NoSuchFieldError -> L13
        L23:
            r10[PrimitiveType.CHAR.ordinal()] = 2;     // Catch: NoSuchFieldError -> L14
        L35:
            r10[PrimitiveType.BYTE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L15
        L25:
            r10[PrimitiveType.SHORT.ordinal()] = 4;     // Catch: NoSuchFieldError -> L16
        L27:
            r10[PrimitiveType.INT.ordinal()] = 5;     // Catch: NoSuchFieldError -> L17
        L21:
            r10[PrimitiveType.FLOAT.ordinal()] = 6;     // Catch: NoSuchFieldError -> L18
        L29:
            r10[PrimitiveType.LONG.ordinal()] = 7;     // Catch: NoSuchFieldError -> L19
        L31:
            r10[PrimitiveType.DOUBLE.ordinal()] = 8;     // Catch: NoSuchFieldError -> L20
        L11:
            $EnumSwitchMapping$0 = r10;
        }
    }

    static {
        INSTANCE = new JvmTypeFactoryImpl();
    }

    private JvmTypeFactoryImpl() {
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.JvmTypeFactory
    public /* bridge */ /* synthetic */ JvmType boxType(JvmType r10) {
        return boxType2(r10);
    }

    /* JADX INFO: renamed from: boxType, reason: avoid collision after fix types in other method */
    public JvmType boxType2(JvmType r10) {
        Intrinsics.checkNotNullParameter(r10, "possiblyPrimitiveType");
        if ((r10 instanceof JvmType.Primitive) == false) goto L8;
        JvmType.Primitive r11 = (JvmType.Primitive) r10;
        if (r11.getJvmPrimitiveType() == null) goto L9;
        String r12 = JvmClassName.byFqNameWithoutInnerClasses(r11.getJvmPrimitiveType().getWrapperFqName()).getInternalName();
        Intrinsics.checkNotNullExpressionValue(r12, "byFqNameWithoutInnerClas…apperFqName).internalName");
        return createObjectType2(r12);
    L9:
        return r10;
    L8:
        return r10;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.JvmTypeFactory
    public /* bridge */ /* synthetic */ JvmType createFromString(String r10) {
        return createFromString2(r10);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.JvmTypeFactory
    /* JADX INFO: renamed from: createFromString, reason: avoid collision after fix types in other method */
    public JvmType createFromString2(String r10) {
        Intrinsics.checkNotNullParameter(r10, "representation");
        r10.length();
        char r11 = r10.charAt(0);
        JvmPrimitiveType[] r12 = JvmPrimitiveType.values();
        int r13 = r12.length;
        int r14 = 0;
    L4:
        if (r14 >= r13) goto L12;
        JvmPrimitiveType r15 = r12[r14];
        if (r15.getDesc().charAt(0) != r11) goto L8;
        boolean r16 = true;
    L9:
        if (r16 == true) goto L13;
        r14 = r14 + 1;
    L13:
        if (r15 == null) goto L17;
        return new JvmType.Primitive(r15);
    L17:
        if (r11 != 'V') goto L20;
        return new JvmType.Primitive(null);
    L20:
        if (r11 != '[') goto L23;
        String r17 = r10.substring(1);
        Intrinsics.checkNotNullExpressionValue(r17, "this as java.lang.String).substring(startIndex)");
        return new JvmType.Array(createFromString2(r17));
    L23:
        if (r11 != 'L') goto L25;
        StringsKt.endsWith$default(r10, ';', false, 2, null);
    L25:
        String r18 = r10.substring(1, r10.length() - 1);
        Intrinsics.checkNotNullExpressionValue(r18, "this as java.lang.String…ing(startIndex, endIndex)");
        return new JvmType.Object(r18);
    L8:
        r16 = false;
        goto L9
    L12:
        r15 = null;
        goto L13
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.JvmTypeFactory
    public /* bridge */ /* synthetic */ JvmType createObjectType(String r10) {
        return createObjectType2(r10);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.JvmTypeFactory
    /* JADX INFO: renamed from: createObjectType, reason: avoid collision after fix types in other method */
    public JvmType createObjectType2(String r10) {
        Intrinsics.checkNotNullParameter(r10, "internalName");
        return new JvmType.Object(r10);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.JvmTypeFactory
    public /* bridge */ /* synthetic */ JvmType createPrimitiveType(PrimitiveType r10) {
        return createPrimitiveType2(r10);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.JvmTypeFactory
    /* JADX INFO: renamed from: createPrimitiveType, reason: avoid collision after fix types in other method */
    public JvmType createPrimitiveType2(PrimitiveType r10) {
        Intrinsics.checkNotNullParameter(r10, "primitiveType");
        switch(WhenMappings.$EnumSwitchMapping$0[r10.ordinal()]) {
            case 1: goto L14;
            case 2: goto L21;
            case 3: goto L20;
            case 4: goto L19;
            case 5: goto L18;
            case 6: goto L17;
            case 7: goto L16;
            case 8: goto L15;
            default: goto L5;
        };
    L5:
        throw new NoWhenBranchMatchedException();
    L15:
        return JvmType.Companion.getDOUBLE$descriptors_jvm();
    L16:
        return JvmType.Companion.getLONG$descriptors_jvm();
    L17:
        return JvmType.Companion.getFLOAT$descriptors_jvm();
    L18:
        return JvmType.Companion.getINT$descriptors_jvm();
    L19:
        return JvmType.Companion.getSHORT$descriptors_jvm();
    L20:
        return JvmType.Companion.getBYTE$descriptors_jvm();
    L21:
        return JvmType.Companion.getCHAR$descriptors_jvm();
    L14:
        return JvmType.Companion.getBOOLEAN$descriptors_jvm();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.JvmTypeFactory
    public /* bridge */ /* synthetic */ JvmType getJavaLangClassType() {
        return getJavaLangClassType2();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.JvmTypeFactory
    /* JADX INFO: renamed from: getJavaLangClassType, reason: avoid collision after fix types in other method */
    public JvmType getJavaLangClassType2() {
        return createObjectType2("java/lang/Class");
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.JvmTypeFactory
    public /* bridge */ /* synthetic */ String toString(JvmType r10) {
        return toString2(r10);
    }

    /* JADX INFO: renamed from: toString, reason: avoid collision after fix types in other method */
    public String toString2(JvmType r10) {
        Intrinsics.checkNotNullParameter(r10, WsConstants.KEY_CONNECTION_TYPE);
        if ((r10 instanceof JvmType.Array) == false) goto L6;
        return '[' + toString2(((JvmType.Array) r10).getElementType());
    L6:
        if ((r10 instanceof JvmType.Primitive) == false) goto L13;
        JvmPrimitiveType r11 = ((JvmType.Primitive) r10).getJvmPrimitiveType();
        if (r11 == null) goto L11;
        String r12 = r11.getDesc();
        if (r12 == null) goto L11;
        return r12;
    L11:
        return "V";
    L13:
        if ((r10 instanceof JvmType.Object) == false) goto L17;
        return 'L' + ((JvmType.Object) r10).getInternalName() + ';';
    L17:
        throw new NoWhenBranchMatchedException();
    }
}
