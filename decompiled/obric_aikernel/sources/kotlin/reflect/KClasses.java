package kotlin.reflect;

import kotlin.ExperimentalStdlibApi;
import kotlin.SinceKotlin;
import kotlin.WasExperimental;
import kotlin.internal.LowPriorityInOverloadResolution;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: loaded from: classes3.dex */
@JvmName(name = "KClasses")
@SourceDebugExtension({"SMAP\nKClasses.kt\nKotlin\n*S Kotlin\n*F\n+ 1 KClasses.kt\nkotlin/reflect/KClasses\n+ 2 KClassesImpl.kt\nkotlin/reflect/KClassesImplKt\n*L\n1#1,48:1\n9#2:49\n*S KotlinDebug\n*F\n+ 1 KClasses.kt\nkotlin/reflect/KClasses\n*L\n26#1:49\n*E\n"})
public final class KClasses {
    /* JADX WARN: Multi-variable type inference failed */
    @LowPriorityInOverloadResolution
    @SinceKotlin(version = "1.4")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    public static final <T> T cast(KClass<T> r10, Object r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if (r10.isInstance(r11) == false) goto L7;
        Intrinsics.checkNotNull(r11, "null cannot be cast to non-null type T of kotlin.reflect.KClasses.cast");
        return r11;
    L7:
        throw new ClassCastException("Value cannot be cast to " + r10.getQualifiedName());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @LowPriorityInOverloadResolution
    @SinceKotlin(version = "1.4")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    public static final <T> T safeCast(KClass<T> r10, Object r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if (r10.isInstance(r11) == false) goto L5;
        Intrinsics.checkNotNull(r11, "null cannot be cast to non-null type T of kotlin.reflect.KClasses.safeCast");
        return r11;
    L5:
        return null;
    }
}
