package obric.flow;

import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.i;
import kotlinx.coroutines.flow.i2;
import kotlinx.coroutines.h0;

/* JADX INFO: loaded from: classes3.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final i2 f20427a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static gu.d f20428b;

    static {
        f20427a = i.a(8, 1, BufferOverflow.DROP_OLDEST);
    }

    public static void a(boolean r10) {
        BuildersKt.launch$default(h0.b(), null, null, new CardEventService$onResumeOrPause$1(r10, null), 3, null);
    }

    public static void b(String r10) {
        Intrinsics.checkNotNullParameter(r10, "cardID");
        BuildersKt.launch$default(h0.b(), null, null, new CardEventService$removeCard$1(r10, null), 3, null);
    }

    public static void c(boolean r10) {
        BuildersKt.launch$default(h0.b(), null, null, new CardEventService$screenChange$1(r10, null), 3, null);
    }

    public static void d(int r10) {
        BuildersKt.launch$default(h0.b(), null, null, new CardEventService$updateWidget$1(r10, null), 3, null);
    }
}
