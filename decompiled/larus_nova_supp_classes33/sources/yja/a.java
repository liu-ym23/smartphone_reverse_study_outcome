package yja;

import com.obric.eventkit.EventServiceConnection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final /* synthetic */ class a implements Runnable {
    public final /* synthetic */ EventServiceConnection a;

    public /* synthetic */ a(EventServiceConnection r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        EventServiceConnection.a(this.a);
    }
}
