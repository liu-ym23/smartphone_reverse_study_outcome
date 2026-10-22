package kotlin.reflect.jvm.internal;

/* JADX INFO: loaded from: classes3.dex */
class Util {
    public static Object getEnumConstantByName(Class<? extends Enum<?>> r10, String r11) {
        return Enum.valueOf(r10, r11);
    }
}
