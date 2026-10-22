package x4a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.larus.apm.impl.protector.RunnableProtector;
import com.lynx.animax.ui.AnimaXView;
import com.lynx.animax.util.AnimaXLog;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class c extends BroadcastReceiver {
    public final /* synthetic */ AnimaXView a;

    public class a implements Runnable {
        public final /* synthetic */ c a;

        public final void a() {
            AnimaXLog.b("AnimaXView", "detect screen unlock, force redraw " + this + " run");
            if (this.a.a.getVisibility() != 0) goto L6;
            this.a.a.setVisibility(4);
            this.a.a.setVisibility(0);
            return;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(c r1) {
            this.a = r1;
        }
    }

    public c(AnimaXView r1) {
        this.a = r1;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context r1, Intent r2) {
        AnimaXLog.b("AnimaXView", "detect screen unlock, force redraw " + this);
        y4a.d.a().post(new a(this));
    }
}
