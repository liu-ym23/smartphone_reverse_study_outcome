package atb;

import android.app.Application;
import android.app.PendingIntent;
import android.content.Intent;
import android.net.Uri;
import atb.a;
import com.larksuite.framework.utils.z;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.notification.export.transfer.NotificationTransferActivity;
import com.ss.android.lark.utils.LarkContext;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public abstract class b<T, R extends a> {
    public final T a;

    public abstract String b();

    public abstract String c();

    public abstract void e();

    public abstract void f();

    public abstract int g();

    public abstract String h();

    public abstract int i();

    public abstract PendingIntent j(Intent r1);

    public abstract void k();

    public abstract Uri l();

    public c m() {
        return null;
    }

    public abstract String n();

    public abstract String o();

    public abstract void p();

    public abstract boolean q();

    public void d() {
        e();
    }

    public b(T r1) {
        this.a = r1;
        p();
    }

    public final void a(a r5) {
        g();
        e();
        int r0 = NotificationTransferActivity.a;
        Intent r1 = new Intent();
        r1.putExtra("extra_is_from_notification", true);
        Application r2 = LarkContext.getApplication();
        Log.i("NotificationTransferActivity", "getTransferActivityWrapperIntentOnDemand: process -> " + z.b(r2));
        Intent r3 = new Intent(r2, NotificationTransferActivity.class);
        r3.putExtra("extra_original_intent", r1);
        r3.setFlags(r1.getFlags());
        j(r3);
        r5.a = o();
        r5.b = c();
        k();
        q();
        n();
        f();
        h();
        i();
        b();
        if (m() != null) goto L6;
        l();
    L6:
        if ((r5 instanceof d) == false) goto L9;
        d r6 = (d) r5;
        d();
        return;
    }
}
