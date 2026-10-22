package sb;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes2.dex */
public class f extends Handler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final WeakReference<a> f12791a;

    public interface a {
        void handleMsg(Message r10);
    }

    public f(Looper r10, a r11) {
        super(r10);
        this.f12791a = new WeakReference(r11);
    }

    @Override // android.os.Handler
    public void handleMessage(Message r10) {
        a r11 = this.f12791a.get();
        if (r11 == null) goto L7;
        if (r10 == null) goto L8;
        r11.handleMsg(r10);
        return;
    L8:
        return;
    }
}
