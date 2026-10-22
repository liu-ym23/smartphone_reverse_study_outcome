package com.obric.capability.schedulekit;

import com.obric.capabilitykit.common.ICapabilityFeedbackReceiver;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class ExecuteResultManager {
    public static final ConcurrentHashMap<Long, Function1<JobResultWrapper, Unit>> a = null;
    public static boolean b;
    public static final ExecuteResultManager$resultReceiver$1 c = null;

    /* JADX INFO: renamed from: com.obric.capability.schedulekit.ExecuteResultManager$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public static final AnonymousClass1 INSTANCE = null;

        static {
            INSTANCE = new AnonymousClass1();
        }

        public AnonymousClass1() {
            super(0);
        }

        public /* bridge */ /* synthetic */ Object invoke() {
            m40invoke();
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
        public final void m40invoke() {
            ExecuteResultManager.b = true;
        }
    }

    static {
        a = new ConcurrentHashMap();
        ICapabilityFeedbackReceiver r0 = new ExecuteResultManager$resultReceiver$1();
        c = r0;
        CoroutineScope r1 = b.a;
        Intrinsics.checkNotNullParameter(r0, "receiver");
        new CapabilityScheduleSdk.registerActionsResultReceiver.1(r0);
        b.a();
        throw null;
    }
}
