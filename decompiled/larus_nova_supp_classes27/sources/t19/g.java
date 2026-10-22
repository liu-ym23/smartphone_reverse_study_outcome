package t19;

import android.app.Activity;
import android.content.Context;
import com.larus.bmhome.chat.helper.a0;
import com.larus.common.apphost.AppHost;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final /* synthetic */ class g implements Runnable {
    public final /* synthetic */ Context a;
    public final /* synthetic */ String b;
    public final /* synthetic */ String c;
    public final /* synthetic */ Function0 d;
    public final /* synthetic */ int e;

    public /* synthetic */ g(Context r1, String r2, String r3, a0 r4, int r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context r0 = this.a;
        String r1 = this.b;
        String r2 = this.c;
        Function0 r3 = this.d;
        int r4 = this.e;
        Activity r6 = null;
        if ((r0 instanceof Activity) == false) goto L5;
        Activity r5 = (Activity) r0;
    L7:
        if (r5 != null) goto L22;
        Activity r7 = AppHost.a.a().getCurrentActivity();
        if (r7 != null) goto L11;
    L19:
        if (r6 == null) goto L24;
        r5 = r6;
        goto L22
    L24:
        return;
    L11:
        if (r7.isFinishing() == false) goto L13;
    L16:
        boolean r8 = true;
    L17:
        if (r8 == true) goto L19;
        r6 = r7;
        goto L19
    L13:
        if (r7.isDestroyed() == true) goto L16;
        r8 = false;
    L22:
        s r9 = s.a;
        r9.a();
        u19.c r10 = new u19.c(v19.c.b(2130972335, r0, 2131243494), r1, r2, r3);
        r10.setDuration(r4);
        r9.r(r10);
        r10.show(r5, false);
        return;
    L5:
        r5 = null;
        goto L7
    }
}
