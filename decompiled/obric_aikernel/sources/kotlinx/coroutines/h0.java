package kotlinx.coroutines;

import kotlin.coroutines.CoroutineContext;

/* JADX INFO: loaded from: classes3.dex */
public interface h0 extends CoroutineContext.Element {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a f10523d = null;

    public static final class a implements CoroutineContext.Key<h0> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        static final /* synthetic */ a f10524c = null;

        static {
            f10524c = new a();
        }

        private a() {
        }
    }

    static {
        f10523d = a.f10524c;
    }

    void V(CoroutineContext r10, Throwable r11);
}
