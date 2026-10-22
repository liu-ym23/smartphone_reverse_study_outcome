package com.obric.aikernel.utils.handler;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes2.dex */
public final class GlobalHandlerUtil extends com.obric.aikernel.utils.handler.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Lazy<GlobalHandlerUtil> f5596c = null;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }
    }

    static {
        new a(null);
        f5596c = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, GlobalHandlerUtil$Companion$instance$2.INSTANCE);
    }

    private GlobalHandlerUtil() {
    }

    public /* synthetic */ GlobalHandlerUtil(DefaultConstructorMarker r10) {
        this();
    }

    @Override // com.obric.aikernel.utils.handler.a
    protected String b() {
        return "GlobalHandlerUtil";
    }
}
