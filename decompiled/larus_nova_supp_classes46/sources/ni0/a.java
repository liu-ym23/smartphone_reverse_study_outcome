package ni0;

import android.view.View;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.utils.z;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.liveinteract.utils.n;
import com.bytedance.android.livesdk.app.dataholder.Observer;
import com.bytedance.android.livesdk.chatroom.utils.a1;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.y3;
import com.bytedance.android.livesdk.config.mz;
import com.bytedance.android.livesdk.schema.interfaces.IBaseLiveActionHandler;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.GroupLiveGameConfig;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.larus.apm.impl.protector.RunnableProtector;
import io.reactivex.disposables.Disposable;
import jc1.k;
import kotlin.jvm.internal.Intrinsics;
import zg1.h1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a {
    public boolean a;
    public final d b;
    public final long c;
    public final boolean d;
    public final b e;
    public final c0 f;
    public final c g;
    public Disposable h;
    public final DataCenter i;

    /* JADX INFO: renamed from: ni0.a$a, reason: collision with other inner class name */
    public static final class C0242a {
    }

    public static final class b implements Runnable {
        public final /* synthetic */ a a;

        public b(a r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            ALogger.i("GroupLiveGameController", "detectOnlineTask run");     // Catch: Throwable -> L6
            if (hd0.c.f().h() == true) goto L9;
            ALogger.e("GroupLiveGameController", "detectOnlineTask, guest offline -> kick out");     // Catch: Throwable -> L6
            this.a.getClass();     // Catch: Throwable -> L6
            a.a(true);     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }
    }

    public static final class c implements c0.b {
        public final /* synthetic */ a a;

        public final /* synthetic */ void Bh(ToolbarButton r1) {
        }

        public final /* synthetic */ void Mr(s r1) {
        }

        public final /* synthetic */ void R9(View r1, DataCenter r2) {
        }

        public final /* synthetic */ void SY(s r1) {
        }

        public final /* synthetic */ void Y6() {
        }

        public final /* synthetic */ void dv(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.e r1) {
        }

        public final /* synthetic */ com.bytedance.android.livesdk.reddot.a h7() {
            return null;
        }

        public final /* synthetic */ void onHide(boolean r1) {
        }

        public final /* synthetic */ void setAlpha(float r1) {
        }

        public final /* synthetic */ boolean showRedDot() {
            return false;
        }

        public c(a r1) {
            this.a = r1;
        }

        public final void onClick(View r4) {
            if (r4 == null) goto L5;
            this.a.getClass();
            StringBuilder r0 = new StringBuilder();
            r0.append(((GroupLiveGameConfig) mz.a.getValue()).getGameSelectPageScheme());
            r0.append("&enter_from=live&game_get_scene=3&conv_type=2&conversation_id=");
            String r1 = com.bytedance.android.live.liveinteract.revenue.game.c.a;
            String r2 = qi0.c.b;
            r0.append(qi0.c.h());
            String r3 = r0.toString();
            ALogger.i("ToolbarInteractPlayControlBehavior", "showGameSelectPage, schema: " + r3);
            k.n(IBaseLiveActionHandler.class).handle(r4.getContext(), r3);
            return;
        }

        public final void p4(View r2, DataCenter r3) {
            Intrinsics.checkNotNullParameter(r2, "view");
            Intrinsics.checkNotNullParameter(r3, "dataCenter");
            HSImageView r4 = r2.findViewById(2131374718);
            if (r4 == null) goto L6;
            a1.m(r4, 2131237688);
            return;
        }
    }

    public static final class d<T> implements Observer {
        public final /* synthetic */ a a;

        public d(a r1) {
            this.a = r1;
        }

        public final void onChanged(Object r4) {
            ALogger.i("GroupLiveGameController", "linkPlayerState onChanged: " + ((Integer) r4));
            boolean r5 = hd0.c.f().g();
            a r1 = this.a;
            if (r1.a == r5) goto L12;
            if (r5 == false) goto L12;
            DataCenter r2 = r1.i;
            if (r2 == null) goto L12;
            Room r3 = z.o(r2);
            if (r3 == null) goto L12;
            if (r3.isPrivatePlay() != true) goto L12;
            ALogger.e("GroupLiveGameController", "linkPlayerState onChanged, guest offline -> kick out");
            this.a.getClass();
            a.a(false);
        L12:
            this.a.a = r5;
        }
    }

    static {
    }

    public a(DataCenter r4) {
        this.i = r4;
        this.a = hd0.c.f().g();
        this.b = new d(this);
        mz r0 = mz.a;
        this.c = ((GroupLiveGameConfig) r0.getValue()).getOnlineDetectIntervalInMills();
        this.d = ((GroupLiveGameConfig) r0.getValue()).getOfflineDetectEnable();
        this.e = new b(this);
        this.f = y3.m(r4);
        this.g = new c(this);
    }

    public static void a(boolean r5) {
        n.a.a(qi0.d.a, false, "forceUserLeaveRoom", null, 12);
        xs2.b.a().post(new h1(6));
        if (r5 == false) goto L6;
        f2.c(s1.B(2131917201), 0);
        return;
    }
}
