package sb;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes2.dex */
public final class c implements Handler.Callback {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private volatile Handler f12782c;

    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final Looper f12783a = null;

        static {
            HandlerThread r10 = new HandlerThread("DownloadWatchDog");
            r10.start();
            f12783a = r10.getLooper();
        }

        static /* synthetic */ Looper a() {
            return f12783a;
        }
    }

    public interface b {
        long a();
    }

    public c() {
        this.f12782c = new Handler(a.a(), this);
    }

    public static Looper b() {
        return a.a();
    }

    public void a(b r10, long r11) {
        Handler r12 = this.f12782c;
        if (r12 != null) goto L5;
        return;
    L5:
        Message r13 = Message.obtain();
        r13.what = 0;
        r13.obj = r10;
        r12.sendMessageDelayed(r13, r11);
    }

    public void c() {
        Handler r10 = this.f12782c;
        if (r10 != null) goto L5;
        return;
    L5:
        this.f12782c = null;
        r10.removeCallbacksAndMessages(null);
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(@NonNull Message r10) {
        if (r10.what != 0) goto L16;
        b r11 = (b) r10.obj;     // Catch: Throwable -> L9
        long r12 = r11.a();     // Catch: Throwable -> L9
        if (r12 <= 0) goto L15;
        a(r11, r12);     // Catch: Throwable -> L9
        return true;
    L15:
        return true;
    L9:
        th = move-exception;
        th.printStackTrace();
        return true;
    L16:
        return true;
    }
}
