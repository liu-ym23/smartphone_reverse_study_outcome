package kotlin.reflect.jvm;

import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlin.reflect.jvm.internal.KClassImpl;

/* JADX INFO: loaded from: classes3.dex */
@JvmName(name = "KClassesJvm")
public final class KClassesJvm {
    public static final String getJvmName(KClass<?> r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        String r11 = ((KClassImpl) r10).getJClass().getName();
        Intrinsics.checkNotNullExpressionValue(r11, "this as KClassImpl).jClass.name");
        return r11;
    }
}
