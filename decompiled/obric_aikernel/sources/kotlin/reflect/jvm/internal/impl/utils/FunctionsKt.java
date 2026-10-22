package kotlin.reflect.jvm.internal.impl.utils;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* JADX INFO: loaded from: classes3.dex */
public final class FunctionsKt {
    private static final Function1<Object, Object> ALWAYS_NULL = null;
    private static final Function1<Object, Boolean> ALWAYS_TRUE = null;
    private static final Function1<Object, Unit> DO_NOTHING = null;
    private static final Function2<Object, Object, Unit> DO_NOTHING_2 = null;
    private static final Function3<Object, Object, Object, Unit> DO_NOTHING_3 = null;
    private static final Function1<Object, Object> IDENTITY = null;

    static {
        IDENTITY = FunctionsKt$IDENTITY$1.INSTANCE;
        ALWAYS_TRUE = FunctionsKt$ALWAYS_TRUE$1.INSTANCE;
        ALWAYS_NULL = FunctionsKt$ALWAYS_NULL$1.INSTANCE;
        DO_NOTHING = FunctionsKt$DO_NOTHING$1.INSTANCE;
        DO_NOTHING_2 = FunctionsKt$DO_NOTHING_2$1.INSTANCE;
        DO_NOTHING_3 = FunctionsKt$DO_NOTHING_3$1.INSTANCE;
    }

    public static final <T> Function1<T, Boolean> alwaysTrue() {
        return (Function1<T, Boolean>) ALWAYS_TRUE;
    }

    public static final Function3<Object, Object, Object, Unit> getDO_NOTHING_3() {
        return DO_NOTHING_3;
    }
}
