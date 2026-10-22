package z1;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.collection.WeakHandler;
import com.bytedance.common.wschannel.WsConstants;

/* JADX INFO: loaded from: classes.dex */
public abstract class a extends Service implements WeakHandler.IHandler, c.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Handler f13743c;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final c f13744g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private Messenger f13745h;

    /* JADX INFO: renamed from: z1.a$a, reason: collision with other inner class name */
    class RunnableC0322a implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ Intent f13746c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ long f13747g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ a f13748h;

        RunnableC0322a(a r10, Intent r11, long r12) {
            this.f13748h = r10;
            this.f13746c = r11;
            this.f13747g = r12;
        }

        @Override // java.lang.Runnable
        public void run() {
            a.g(this.f13748h, this.f13746c, this.f13747g);
        }
    }

    class b implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ Intent f13749c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ long f13750g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ a f13751h;

        b(a r10, Intent r11, long r12) {
            this.f13751h = r10;
            this.f13749c = r11;
            this.f13750g = r12;
        }

        @Override // java.lang.Runnable
        public void run() {
            a.g(this.f13751h, this.f13749c, this.f13750g);
        }
    }

    public a() {
        this.f13743c = new WeakHandler(this);
        this.f13744g = new c(this);
    }

    static /* synthetic */ void g(a r10, Intent r11, long r12) {
        r10.h(r11, r12);
    }

    @WorkerThread
    private void h(Intent r10, long r11) {
        if (r10 != null) goto L4;
        return;
    L4:
        com.bytedance.common.wschannel.model.a r12 = new com.bytedance.common.wschannel.model.a(r11);
        this.f13744g.a(r10, r12);
    }

    public void f(String r10, boolean r11) {
    }

    @Override // com.bytedance.common.utility.collection.WeakHandler.IHandler
    public void handleMsg(Message r10) {
        long r11 = g2.b.a();     // Catch: Exception -> L14
        if (r10 != null) goto L5;
        return;
    L5:
        if (r10.what != 10123) goto L19;
        Intent r12 = (Intent) r10.getData().getParcelable(WsConstants.DATA_INTENT);     // Catch: Exception -> L14
        if (Logger.debug() == false) goto L10;
        Logger.d("AbsWsClientService", "handleMsg = " + r12);     // Catch: Exception -> L14
    L10:
        if (r12 == null) goto L12;
        com.bytedance.common.wschannel.g.b().c(new b(this, r12, r11));     // Catch: Exception -> L14
        return;
    L12:
        Logger.e("AbsWsClientService", "handleMsg but intent isnull");     // Catch: Exception -> L14
        return;
    L19:
        return;
    L14:
        e = move-exception;
        Logger.e(e.toString());
    }

    @Override // android.app.Service
    @Nullable
    public IBinder onBind(Intent r10) {
        return this.f13745h.getBinder();
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        this.f13745h = new Messenger(this.f13743c);
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        if (Logger.debug() == false) goto L6;
        Logger.d("AbsWsClientService", "onDestroy");
        return;
    }

    @Override // android.app.Service
    public int onStartCommand(Intent r10, int r11, int r12) {
        if (Logger.debug() == false) goto L9;
        StringBuilder r13 = new StringBuilder();
        r13.append("onStartCommand intent = ");
        if (r10 == null) goto L7;
        String r14 = r10.toString();
    L8:
        r13.append(r14);
        Logger.d("AbsWsClientService", r13.toString());
        goto L9
    L7:
        r14 = "null";
    L9:
        long r15 = g2.b.a();
        com.bytedance.common.wschannel.g.b().c(new RunnableC0322a(this, r10, r15));
        return 2;
    }
}
