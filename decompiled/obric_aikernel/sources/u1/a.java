package u1;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.collection.WeakHandler;
import com.bytedance.common.wschannel.j;

/* JADX INFO: loaded from: classes.dex */
public abstract class a extends Service implements WeakHandler.IHandler {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Messenger f13118c;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    protected WeakHandler f13119g;

    /* JADX INFO: renamed from: u1.a$a, reason: collision with other inner class name */
    class RunnableC0300a implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ a f13120c;

        RunnableC0300a(a r10) {
            this.f13120c = r10;
        }

        @Override // java.lang.Runnable
        public void run() {
            a.a(this.f13120c);
        }
    }

    public a() {
    }

    static /* synthetic */ void a(a r10) {
        r10.b();
    }

    private void b() {
        j.i(getApplication(), null);
    }

    public void handleMsg(Message r10) {
    }

    @Override // android.app.Service
    public IBinder onBind(Intent r10) {
        Logger.d("AbsMessengerService", "onBind " + this);
        return this.f13118c.getBinder();
    }

    @Override // android.app.Service
    public void onCreate() {
        r1.c.b(new RunnableC0300a(this));
        Logger.d("AbsMessengerService", "onCreate " + this);
        this.f13119g = new WeakHandler(this);
        this.f13118c = new Messenger(this.f13119g);
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // android.app.Service
    public boolean onUnbind(Intent r10) {
        Logger.d("AbsMessengerService", "onUnBind " + this);
        return super.onUnbind(r10);
    }
}
