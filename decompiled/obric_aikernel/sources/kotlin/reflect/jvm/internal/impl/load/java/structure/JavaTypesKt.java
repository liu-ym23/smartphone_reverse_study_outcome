package kotlin.reflect.jvm.internal.impl.load.java.structure;

/* JADX INFO: loaded from: classes3.dex */
public final class JavaTypesKt {
    public static final boolean isSuperWildcard(JavaType r10) {
        if ((r10 instanceof JavaWildcardType) == false) goto L5;
        JavaWildcardType r11 = (JavaWildcardType) r10;
    L7:
        if (r11 != null) goto L9;
        return false;
    L9:
        if (r11.getBound() != null) goto L11;
        return false;
    L11:
        if (r11.isExtends() == false) goto L13;
        return false;
    L13:
        return true;
    L5:
        r11 = null;
        goto L7
    }
}
