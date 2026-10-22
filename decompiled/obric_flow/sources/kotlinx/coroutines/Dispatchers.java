package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0005\u0010\u0003R \u0010\u0007\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\u0007\u0010\b\u0012\u0004\b\u000b\u0010\u0003\u001a\u0004\b\t\u0010\nR \u0010\f\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\f\u0010\b\u0012\u0004\b\u000e\u0010\u0003\u001a\u0004\b\r\u0010\nR\u001a\u0010\u0013\u001a\u00020\u000f8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0012\u0010\u0003\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0016\u001a\u00020\u00068FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0015\u0010\u0003\u001a\u0004\b\u0014\u0010\n¨\u0006\u0017"}, d2 = {"Lkotlinx/coroutines/Dispatchers;", "", "<init>", "()V", "", "shutdown", "Lkotlinx/coroutines/z;", "Default", "Lkotlinx/coroutines/z;", "getDefault", "()Lkotlinx/coroutines/z;", "getDefault$annotations", "Unconfined", "getUnconfined", "getUnconfined$annotations", "Lkotlinx/coroutines/MainCoroutineDispatcher;", "getMain", "()Lkotlinx/coroutines/MainCoroutineDispatcher;", "getMain$annotations", "Main", "getIO", "getIO$annotations", "IO", "kotlinx-coroutines-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class Dispatchers {
    private static final z Default = null;
    public static final Dispatchers INSTANCE = null;
    private static final z Unconfined = null;

    static {
        INSTANCE = new Dispatchers();
        Default = yt.e.f23339b;
        Unconfined = f2.f18826a;
    }

    private Dispatchers() {
    }

    public static final z getDefault() {
        return Default;
    }

    @JvmStatic
    public static /* synthetic */ void getDefault$annotations() {
    }

    public static final z getIO() {
        return yt.d.f23337a;
    }

    @JvmStatic
    public static /* synthetic */ void getIO$annotations() {
    }

    public static final MainCoroutineDispatcher getMain() {
        return kotlinx.coroutines.internal.n.f18945a;
    }

    @JvmStatic
    public static /* synthetic */ void getMain$annotations() {
    }

    public static final z getUnconfined() {
        return Unconfined;
    }

    @JvmStatic
    public static /* synthetic */ void getUnconfined$annotations() {
    }

    public final void shutdown() {
        k0.f18973h.shutdown();
        yt.e.f23339b.g();
    }
}
