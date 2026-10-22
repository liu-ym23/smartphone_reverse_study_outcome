package com.obric.oui.push;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes2.dex */
public final class PushQueue {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Lazy f7217a = null;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }
    }

    static {
        new a(null);
        f7217a = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, PushQueue$Companion$instance$2.INSTANCE);
    }

    private PushQueue() {
    }

    public /* synthetic */ PushQueue(DefaultConstructorMarker r10) {
        this();
    }
}
