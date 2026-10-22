package kotlin.reflect;

import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.Arrays;
import kotlin.ExperimentalStdlibApi;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: loaded from: classes3.dex */
@ExperimentalStdlibApi
@SourceDebugExtension({"SMAP\nTypesJVM.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TypesJVM.kt\nkotlin/reflect/WildcardTypeImpl\n+ 2 ArrayIntrinsics.kt\nkotlin/ArrayIntrinsicsKt\n*L\n1#1,230:1\n26#2:231\n*S KotlinDebug\n*F\n+ 1 TypesJVM.kt\nkotlin/reflect/WildcardTypeImpl\n*L\n163#1:231\n*E\n"})
final class WildcardTypeImpl implements WildcardType, TypeImpl {
    public static final Companion Companion = null;
    private static final WildcardTypeImpl STAR = null;
    private final Type lowerBound;
    private final Type upperBound;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r10) {
            this();
        }

        public final WildcardTypeImpl getSTAR() {
            return WildcardTypeImpl.access$getSTAR$cp();
        }
    }

    static {
        Companion = new Companion(null);
        STAR = new WildcardTypeImpl(null, null);
    }

    public WildcardTypeImpl(Type r10, Type r11) {
        this.upperBound = r10;
        this.lowerBound = r11;
    }

    public static final /* synthetic */ WildcardTypeImpl access$getSTAR$cp() {
        return STAR;
    }

    public boolean equals(Object r10) {
        if ((r10 instanceof WildcardType) == false) goto L9;
        WildcardType r11 = (WildcardType) r10;
        if (Arrays.equals(getUpperBounds(), r11.getUpperBounds()) == false) goto L9;
        if (Arrays.equals(getLowerBounds(), r11.getLowerBounds()) == false) goto L9;
        return true;
    L9:
        return false;
    }

    @Override // java.lang.reflect.WildcardType
    public Type[] getLowerBounds() {
        Type r10 = this.lowerBound;
        if (r10 != null) goto L6;
        return new Type[0];
    L6:
        return new Type[]{r10};
    }

    @Override // java.lang.reflect.Type, kotlin.reflect.TypeImpl
    public String getTypeName() {
        if (this.lowerBound == null) goto L6;
        StringBuilder r10 = new StringBuilder();
        r10.append("? super ");
        Type r11 = this.lowerBound;
    L5:
        r10.append(TypesJVMKt.access$typeToString(r11));
        return r10.toString();
    L6:
        Type r12 = this.upperBound;
        if (r12 != null) goto L9;
    L11:
        return "?";
    L9:
        if (Intrinsics.areEqual(r12, Object.class) == true) goto L11;
        r10 = new StringBuilder();
        r10.append("? extends ");
        r11 = this.upperBound;
        goto L5
    }

    @Override // java.lang.reflect.WildcardType
    public Type[] getUpperBounds() {
        Type[] r10 = new Type[1];
        Type r11 = this.upperBound;
        if (r11 != null) goto L5;
        r11 = Object.class;
    L5:
        r10[0] = r11;
        return r10;
    }

    public int hashCode() {
        int r10 = Arrays.hashCode(getUpperBounds());
        return Arrays.hashCode(getLowerBounds()) ^ r10;
    }

    public String toString() {
        return getTypeName();
    }
}
