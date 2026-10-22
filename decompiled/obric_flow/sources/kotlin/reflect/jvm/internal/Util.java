package kotlin.reflect.jvm.internal;

/* JADX INFO: loaded from: classes3.dex */
class Util {
    public static Object getEnumConstantByName(Class<? extends Enum<?>> r5, String r10) {
        return Enum.valueOf(r5, r10);
    }
}
