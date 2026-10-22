package a2a;

import android.os.Message;
import com.ss.android.update.OnUpdateStatusChangedListener;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class r implements OnUpdateStatusChangedListener {
    public final /* synthetic */ q a;

    public final void b(boolean r1) {
    }

    public final void c(int r1) {
    }

    public final void e(int r1, boolean r2) {
    }

    public r(q r1) {
        this.a = r1;
    }

    public final void a(boolean r2, boolean r3) {
        if (r3 == false) goto L4;
        return;
    L4:
        yhc.a r4 = new yhc.a();
        if (r2 == false) goto L7;
        int r5 = 3;
    L8:
        r4.c = r5;
        Message r6 = Message.obtain();
        r6.what = 2;
        r6.obj = r4;
        this.a.c.sendMessage(r6);
        return;
    L7:
        r5 = 2;
        goto L8
    }

    public final void d(int r4, int r5, boolean r6) {
        if (r6 == false) goto L4;
        return;
    L4:
        this.a.getClass();
        if (r4 < 0) goto L12;
        if (r5 <= 0) goto L12;
        int r1 = 100;
        int r0 = (int) ((r4 / r5) * 100);
        if (r0 > 100) goto L14;
        r1 = r0;
    L14:
        if ((r1 + 0) > 1) goto L16;
        return;
    L16:
        yhc.a r2 = new yhc.a();
        r2.c = 1;
        r2.a = r4;
        r2.b = r5;
        Message r7 = Message.obtain();
        r7.what = 1;
        r7.obj = r2;
        this.a.c.sendMessage(r7);
        return;
    L12:
        r1 = 0;
        goto L14
    }
}
