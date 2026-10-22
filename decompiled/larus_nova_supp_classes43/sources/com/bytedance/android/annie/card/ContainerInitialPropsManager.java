package com.bytedance.android.annie.card;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class ContainerInitialPropsManager {
    public static final Lazy a = null;

    static {
        a = LazyKt.lazy(LazyThreadSafetyMode.NONE, ContainerInitialPropsManager$mInitialProps$2.INSTANCE);
    }
}
