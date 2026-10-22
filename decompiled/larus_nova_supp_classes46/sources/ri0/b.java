package ri0;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.liveinteract.revenue.game.wm.MultiLinkGameWindowManager;
import com.bytedance.android.livesdk.app.dataholder.Observer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class b<T> implements Observer {
    public final /* synthetic */ MultiLinkGameWindowManager a;

    public b(MultiLinkGameWindowManager r1) {
        this.a = r1;
    }

    public final void onChanged(Object r4) {
        Integer r5 = (Integer) r4;
        if (hd0.c.f().h() == false) goto L13;
        if ((this.a.k0 instanceof oi0.d) == true) goto L13;
        ALogger.i("MultiLinkGameWindowManager", "mLinkPlayStateObserver, isOnline: true");
        oi0.a r6 = this.a.k0;
        if (r6 == null) goto L9;
        r6.onDestroy();
    L9:
        MultiLinkGameWindowManager r7 = this.a;
        r7.k0 = new oi0.d(this.a.C);
        oi0.a r8 = this.a.k0;
        if (r8 == null) goto L13;
        r8.onCreate();
    L13:
        if (hd0.c.f().h() == false) goto L15;
        return;
    L15:
        if ((this.a.k0 instanceof oi0.c) == true) goto L24;
        ALogger.i("MultiLinkGameWindowManager", "mLinkPlayStateObserver, isOnline: false");
        oi0.a r9 = this.a.k0;
        if (r9 == null) goto L19;
        r9.onDestroy();
    L19:
        MultiLinkGameWindowManager r10 = this.a;
        MultiLinkGameWindowManager r1 = this.a;
        r10.k0 = new oi0.c(r1.C);
        oi0.a r11 = r1.k0;
        if (r11 == null) goto L25;
        r11.onCreate();
        return;
    L25:
        return;
    }
}
