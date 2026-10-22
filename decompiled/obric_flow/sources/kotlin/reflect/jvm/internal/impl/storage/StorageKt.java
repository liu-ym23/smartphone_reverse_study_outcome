package kotlin.reflect.jvm.internal.impl.storage;

import androidx.room.jarjarred.org.antlr.v4.analysis.LeftRecursiveRuleTransformer;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes3.dex */
public final class StorageKt {
    public static final <T> T getValue(NotNullLazyValue<? extends T> r5, Object r10, KProperty<?> r11) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r11, LeftRecursiveRuleTransformer.PRECEDENCE_OPTION_NAME);
        return r5.invoke();
    }

    public static final <T> T getValue(NullableLazyValue<? extends T> r5, Object r10, KProperty<?> r11) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r11, LeftRecursiveRuleTransformer.PRECEDENCE_OPTION_NAME);
        return r5.invoke();
    }
}
