package kotlin.reflect.jvm.internal.impl.load.kotlin;

import androidx.constraintlayout.motion.widget.a;
import androidx.exifinterface.media.ExifInterface;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmClassName;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes3.dex */
@SourceDebugExtension({"SMAP\nmethodSignatureMapping.kt\nKotlin\n*S Kotlin\n*F\n+ 1 methodSignatureMapping.kt\norg/jetbrains/kotlin/load/kotlin/JvmTypeFactoryImpl\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,184:1\n1#2:185\n1282#3,2:186\n*S KotlinDebug\n*F\n+ 1 methodSignatureMapping.kt\norg/jetbrains/kotlin/load/kotlin/JvmTypeFactoryImpl\n*L\n128#1:186,2\n*E\n"})
final class JvmTypeFactoryImpl implements JvmTypeFactory<JvmType> {
    public static final JvmTypeFactoryImpl INSTANCE = null;

    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r5 = new int[PrimitiveType.values().length];
            r5[PrimitiveType.BOOLEAN.ordinal()] = 1;     // Catch: NoSuchFieldError -> L13
        L23:
            r5[PrimitiveType.CHAR.ordinal()] = 2;     // Catch: NoSuchFieldError -> L14
        L35:
            r5[PrimitiveType.BYTE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L15
        L25:
            r5[PrimitiveType.SHORT.ordinal()] = 4;     // Catch: NoSuchFieldError -> L16
        L27:
            r5[PrimitiveType.INT.ordinal()] = 5;     // Catch: NoSuchFieldError -> L17
        L21:
            r5[PrimitiveType.FLOAT.ordinal()] = 6;     // Catch: NoSuchFieldError -> L18
        L29:
            r5[PrimitiveType.LONG.ordinal()] = 7;     // Catch: NoSuchFieldError -> L19
        L31:
            r5[PrimitiveType.DOUBLE.ordinal()] = 8;     // Catch: NoSuchFieldError -> L20
        L11:
            $EnumSwitchMapping$0 = r5;
        }
    }

    static {
        INSTANCE = new JvmTypeFactoryImpl();
    }

    private JvmTypeFactoryImpl() {
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.JvmTypeFactory
    public /* bridge */ /* synthetic */ JvmType boxType(JvmType r5) {
        return boxType2(r5);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.JvmTypeFactory
    public /* bridge */ /* synthetic */ JvmType createFromString(String r5) {
        return createFromString2(r5);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.JvmTypeFactory
    public /* bridge */ /* synthetic */ JvmType createObjectType(String r5) {
        return createObjectType2(r5);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.JvmTypeFactory
    public /* bridge */ /* synthetic */ JvmType createPrimitiveType(PrimitiveType r5) {
        return createPrimitiveType2(r5);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.JvmTypeFactory
    public /* bridge */ /* synthetic */ JvmType getJavaLangClassType() {
        return getJavaLangClassType2();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.JvmTypeFactory
    public /* bridge */ /* synthetic */ String toString(JvmType r5) {
        return toString2(r5);
    }

    /* JADX INFO: renamed from: boxType, reason: avoid collision after fix types in other method */
    public JvmType boxType2(JvmType r5) {
        Intrinsics.checkNotNullParameter(r5, "possiblyPrimitiveType");
        if ((r5 instanceof JvmType.Primitive) == false) goto L8;
        JvmType.Primitive r10 = (JvmType.Primitive) r5;
        if (r10.getJvmPrimitiveType() != null) goto L7;
        return r5;
    L7:
        return createObjectType2(JvmClassName.byFqNameWithoutInnerClasses(r10.getJvmPrimitiveType().getWrapperFqName()).getInternalName());
    L8:
        return r5;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.JvmTypeFactory
    /* JADX INFO: renamed from: createFromString, reason: avoid collision after fix types in other method */
    public JvmType createFromString2(String r10) {
        Intrinsics.checkNotNullParameter(r10, "representation");
        r10.getClass();
        char r5 = r10.charAt(0);
        JvmPrimitiveType[] r11 = JvmPrimitiveType.values();
        int r12 = r11.length;
        int r13 = 0;
    L4:
        if (r13 >= r12) goto L9;
        JvmPrimitiveType r14 = r11[r13];
        if (r14.getDesc().charAt(0) == r5) goto L10;
        r13 = r13 + 1;
    L10:
        if (r14 == null) goto L14;
        return new JvmType.Primitive(r14);
    L14:
        if (r5 != 'V') goto L17;
        return new JvmType.Primitive(null);
    L17:
        if (r5 != '[') goto L20;
        return new JvmType.Array(createFromString2(r10.substring(1)));
    L20:
        if (r5 != 'L') goto L23;
        StringsKt.j(r10, ';');
    L23:
        return new JvmType.Object(a.n(r10, 1, 1));
    L9:
        r14 = null;
        goto L10
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.JvmTypeFactory
    /* JADX INFO: renamed from: createObjectType, reason: avoid collision after fix types in other method */
    public JvmType createObjectType2(String r5) {
        Intrinsics.checkNotNullParameter(r5, "internalName");
        return new JvmType.Object(r5);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.JvmTypeFactory
    /* JADX INFO: renamed from: createPrimitiveType, reason: avoid collision after fix types in other method */
    public JvmType createPrimitiveType2(PrimitiveType r5) {
        Intrinsics.checkNotNullParameter(r5, "primitiveType");
        switch(WhenMappings.$EnumSwitchMapping$0[r5.ordinal()]) {
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
    /* JADX INFO: renamed from: getJavaLangClassType, reason: avoid collision after fix types in other method */
    public JvmType getJavaLangClassType2() {
        return createObjectType2("java/lang/Class");
    }

    /* JADX INFO: renamed from: toString, reason: avoid collision after fix types in other method */
    public String toString2(JvmType r5) {
        Intrinsics.checkNotNullParameter(r5, "type");
        if ((r5 instanceof JvmType.Array) == false) goto L6;
        return "[" + toString2(((JvmType.Array) r5).getElementType());
    L6:
        if ((r5 instanceof JvmType.Primitive) == false) goto L13;
        JvmPrimitiveType r10 = ((JvmType.Primitive) r5).getJvmPrimitiveType();
        if (r10 == null) goto L11;
        String r11 = r10.getDesc();
        if (r11 == null) goto L11;
        return r11;
    L11:
        return ExifInterface.GPS_MEASUREMENT_INTERRUPTED;
    L13:
        if ((r5 instanceof JvmType.Object) == false) goto L17;
        return "L" + ((JvmType.Object) r5).getInternalName() + ';';
    L17:
        throw new NoWhenBranchMatchedException();
    }
}
