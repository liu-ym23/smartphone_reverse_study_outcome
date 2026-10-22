package ms.bd.c;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.bytedance.mobsec.metasec.ml.MSManager;
import com.bytedance.mobsec.metasec.ml.MSManagerUtils;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final class n1 extends Handler {
    public MSManager a;
    public final /* synthetic */ p1 b;

    public final void a() {
        if (this.a != null) goto L5;
        this.a = MSManagerUtils.get(this.b.c);
    L5:
        String r0 = (String) p2.a(16777217, 0, 0, "0c1bd7", new byte[]{5, 110, 87, 47, 82, 46, 31, 75, 118, 55});
        String r1 = (String) p2.a(16777217, 0, 0, "ee22b2", new byte[]{80, 104, 1, 117, 121, 14, 38, 86, 102, 114, 123, 117, 85, 79, 83, 34, 40, 10, 45});
        this.a.report((String) p2.a(16777217, 0, 0, "90910e", new byte[]{36, 59, 92, 64, 48, 102, 63, 2}));
    }

    @Override // android.os.Handler
    public final void handleMessage(Message r5) {
        super.handleMessage(r5);
        int r6 = r5.what;
        if (r6 != 0) goto L5;
        this.b.f.post(new l1(this));
        this.b.a.c();
        long r1 = this.b.b.d;
        Message r7 = new Message();
        r7.what = 1;
        sendMessageDelayed(r7, r1);
        return;
    L5:
        if (r6 == 1) goto L15;
        if (r6 != 2) goto L8;
        this.b.a.c();
        long r2 = this.b.b.b;
        Message r8 = new Message();
        r8.what = 2;
        sendMessageDelayed(r8, r2);
        return;
    L8:
        if (r6 != 3) goto L10;
        a();
        long r3 = this.b.b.c;
        Message r9 = new Message();
        r9.what = 3;
        sendMessageDelayed(r9, r3);
        return;
    L10:
        if (r6 != 4) goto L28;
        a();
        this.b.a.a(true);
        this.b.e.removeCallbacks(null);
        this.b.h.countDown();
        return;
    L28:
        return;
    L15:
        this.b.f.post(new m1(this));
        v1 r10 = this.b.b;
        if (r10.f == false) goto L20;
        int r0 = r10.b;
        if (r0 != r10.a) goto L20;
        Message r11 = new Message();
        r11.what = 2;
        sendMessageDelayed(r11, r0);
        return;
    L20:
        long r4 = r10.b;
        Message r12 = new Message();
        r12.what = 0;
        sendMessageDelayed(r12, r4);
    }

    public n1(p1 r1, Looper r2) {
        this.b = r1;
        super(r2);
    }
}
