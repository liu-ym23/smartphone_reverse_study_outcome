package kotlin.reflect.jvm.internal;

import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.pcollections.HashPMap;

/* JADX INFO: loaded from: classes3.dex */
public final class KClassCacheKt {
    private static HashPMap<String, Object> K_CLASS_CACHE;

    static {
        HashPMap<String, Object> r10 = HashPMap.empty();
        Intrinsics.checkNotNullExpressionValue(r10, "empty<String, Any>()");
        K_CLASS_CACHE = r10;
    }

    public static final void clearKClassCache() {
        HashPMap<String, Object> r10 = HashPMap.empty();
        Intrinsics.checkNotNullExpressionValue(r10, "empty()");
        K_CLASS_CACHE = r10;
    }

    public static final <T> KClassImpl<T> getOrCreateKotlinClass(Class<T> r10) {
        Intrinsics.checkNotNullParameter(r10, "jClass");
        String r11 = r10.getName();
        Object r12 = K_CLASS_CACHE.get(r11);
        Class<T> r13 = null;
        if ((r12 instanceof WeakReference) == false) goto L10;
        KClassImpl<T> r14 = (KClassImpl) ((WeakReference) r12).get();
        if (r14 == null) goto L8;
        r13 = r14.getJClass();
    L8:
        if (Intrinsics.areEqual(r13, r10) == false) goto L24;
        return r14;
    L24:
        KClassImpl<T> r15 = new KClassImpl(r10);
        HashPMap<String, Object> r16 = K_CLASS_CACHE.plus(r11, new WeakReference(r15));
        String r17 = "K_CLASS_CACHE.plus(name, WeakReference(newKClass))";
    L22:
        Intrinsics.checkNotNullExpressionValue(r16, r17);
        K_CLASS_CACHE = r16;
        return r15;
    L10:
        if (r12 == null) goto L24;
        WeakReference[] r18 = (WeakReference[]) r12;
        int r19 = r18.length;
        int r20 = 0;
    L12:
        if (r20 >= r19) goto L21;
        KClassImpl<T> r21 = (KClassImpl) r18[r20].get();
        if (r21 == null) goto L16;
        Class<T> r22 = r21.getJClass();
    L18:
        if (Intrinsics.areEqual(r22, r10) == true) goto L19;
        r20 = r20 + 1;
        goto L12
    L19:
        return r21;
    L16:
        r22 = null;
        goto L18
    L21:
        int r23 = ((Object[]) r12).length;
        WeakReference[] r24 = new WeakReference[r23 + 1];
        System.arraycopy(r12, 0, r24, 0, r23);
        r15 = new KClassImpl(r10);
        r24[r23] = new WeakReference(r15);
        r16 = K_CLASS_CACHE.plus(r11, r24);
        r17 = "K_CLASS_CACHE.plus(name, newArray)";
        goto L22
    }
}
