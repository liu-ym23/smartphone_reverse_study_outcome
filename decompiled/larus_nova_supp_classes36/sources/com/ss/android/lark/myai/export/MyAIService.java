package com.ss.android.lark.myai.export;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public interface MyAIService {
    public static final Companion a = null;

    public static final class Companion {
        public static final /* synthetic */ Companion a = null;
        public static final Lazy<MyAIService> b = null;

        public Companion() {
        }

        static {
            a = new Companion();
            b = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, MyAIService$Companion$instance$2.INSTANCE);
        }
    }

    static {
        a = Companion.a;
    }

    Object a();
}
