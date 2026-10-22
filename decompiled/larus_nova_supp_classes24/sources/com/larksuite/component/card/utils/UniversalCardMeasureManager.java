package com.larksuite.component.card.utils;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class UniversalCardMeasureManager {
    public static final Lazy<UniversalCardMeasureManager> a = null;

    public static final class a {
    }

    public UniversalCardMeasureManager() {
    }

    static {
        a = LazyKt.lazy(LazyThreadSafetyMode.NONE, UniversalCardMeasureManager$Companion$instance$2.INSTANCE);
    }
}
