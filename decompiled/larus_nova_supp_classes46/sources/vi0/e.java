package vi0;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.MainThreadPostUtils;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.voicechat.IVoiceChatGuestService;
import com.bytedance.android.livesdk.app.dataholder.Observer;
import com.larus.apm.impl.protector.RunnableProtector;
import gd0.v;
import jc1.k;
import rj0.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class e implements Runnable {
    public final /* synthetic */ c.a a;

    public static final class a<T> implements Observer {
        public final /* synthetic */ e a;

        public a(e r1) {
            this.a = r1;
        }

        public final void onChanged(Object r3) {
            ALogger.i("MultiLinkRoomUtils", "leaveMultiLinkRoom, linkPlayerState onChanged: " + ((Integer) r3));
            if (hd0.c.f().h() == true) goto L6;
            ALogger.i("MultiLinkRoomUtils", "leaveMultiLinkRoom success");
            MainThreadPostUtils.c(new d(this), 1000);
            hd0.c.f().e(c.a);
            c.a = null;
            return;
        }
    }

    public e(com.bytedance.android.live.liveinteract.revenue.guestlink.f r1) {
        this.a = r1;
    }

    public final void a() {
        boolean r0 = hd0.c.f().h();
        ALogger.i("MultiLinkRoomUtils", "leaveMultiLinkRoom, isGuest: " + r0);
        if (r0 == false) goto L14;
        c.a = new a(this);
        hd0.c.f().c(c.a);
        int r1 = ((IInteractService) k.n(IInteractService.class)).getLinkMode();
        if (v.a(r1, 32) == false) goto L10;
        l.n2.getClass();
        l r2 = l.a.a();
        if (r2 == null) goto L18;
        l.b.d(r2, 205, false, false, 8);
        return;
    L18:
        return;
    L10:
        if (v.a(r1, 8) == false) goto L20;
        IVoiceChatGuestService.Companion.getClass();
        IVoiceChatGuestService r3 = IVoiceChatGuestService.a.a();
        if (r3 == null) goto L21;
        IVoiceChatGuestService.b.b(r3, 205, false, false, false, 16);
        return;
    L21:
        return;
    L20:
        return;
    L14:
        c.a r4 = this.a;
        if (r4 == null) goto L23;
        r4.a();
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
}
