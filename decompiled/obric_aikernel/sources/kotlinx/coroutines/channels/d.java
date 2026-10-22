package kotlinx.coroutines.channels;

import kotlinx.coroutines.internal.j0;

/* JADX INFO: loaded from: classes3.dex */
public interface d<E> extends n<E>, ReceiveChannel<E> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final a f10314f = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ a f10315a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final int f10316b = 0;

        static {
            f10315a = new a();
            f10316b = j0.b("kotlinx.coroutines.channels.defaultBuffer", 64, 1, 2147483646);
        }

        private a() {
        }

        public final int a() {
            return f10316b;
        }
    }

    static {
        f10314f = a.f10315a;
    }
}
