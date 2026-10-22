package yi0;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.ExceptionUtils;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.plantform.api.LinkApi;
import com.bytedance.android.live.liveinteract.plantform.core.y;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.plantform.monitor.MultiLinkEventModule;
import com.bytedance.android.live.liveinteract.revenue.linkroomfight.core.LinkRoomFightContext;
import com.bytedance.android.live.network.c;
import com.bytedance.android.live.network.response.e;
import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.bytedance.android.livesdk.chatroom.model.interact.r1;
import com.bytedance.android.livesdk.link.model.bridge.g2;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.crash.d;
import com.bytedance.live.datacontext.m;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import io.reactivex.Single;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import java.util.Map;
import jc1.k;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a extends com.bytedance.android.livesdk.common.b implements View.OnClickListener {
    public final CompositeDisposable b;
    public final ILinkPlayerInfoBridge c;
    public final boolean d;

    /* JADX INFO: renamed from: yi0.a$a, reason: collision with other inner class name */
    public static final class C0293a<T> implements Consumer {
        public final /* synthetic */ a a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ long c;

        public C0293a(a r1, boolean r2, long r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void accept(Object r5) {
            e r6 = (e) r5;
            com.bytedance.android.livesdk.common.b r0 = this.a;
            Handler r1 = DialogLancet.resolveDialogHandler(r0);
            if (r1 != null) goto L5;
        L7:
            DialogLancet.beforeDialogDismiss(r0);
            r0.dismiss();     // Catch: Throwable -> L10 Exception -> L12
        L16:
            DialogLancet.afterDialogDismiss(r0);
        L18:
            if (this.a.d == false) goto L24;
            if (this.b == true) goto L22;
            MultiLinkEventModule r2 = zi0.b.a;
            zi0.b.e(true, r6.logId, this.c);
            goto L24
        L22:
            MultiLinkEventModule r3 = zi0.b.a;
            zi0.b.e(false, r6.logId, this.c);
        L24:
            if (this.b == true) goto L26;
            String r7 = "静音";
        L27:
            ALogger.i(LinkRoomFightContext.TAG, r7.concat("对方成功"));
            return;
        L26:
            r7 = "解除";
            goto L27
        L10:
            th = move-exception;
            DialogLancet.afterDialogDismiss(r0);
            throw th;
        L12:
            e = move-exception;
            d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L10
            Throwable r4 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L10
            if (r4 == null) goto L16;
            d.d(r4, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L10
            goto L16
        L5:
            if (Looper.myLooper() == r1.getLooper()) goto L7;
            r1.post(DialogLancet.createDismissRunnable(r0));
            goto L18
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ a a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ long c;

        public b(a r1, boolean r2, long r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void accept(Object r4) {
            Throwable r5 = (Throwable) r4;
            ExceptionUtils.handleException(this.a.getContext(), r5);
            if (this.a.d == false) goto L9;
            if (this.b == true) goto L7;
            MultiLinkEventModule r0 = zi0.b.a;
            zi0.b.d(true, r5, this.c);
            goto L9
        L7:
            MultiLinkEventModule r1 = zi0.b.a;
            zi0.b.d(false, r5, this.c);
        L9:
            if (this.b == true) goto L11;
            String r2 = "静音";
        L12:
            ALogger.e(LinkRoomFightContext.TAG, r2.concat("对方失败"), r5);
            return;
        L11:
            r2 = "解除";
            goto L12
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onDetachedFromWindow() {
        super/*android.app.Dialog*/.onDetachedFromWindow();
        CompositeDisposable r0 = this.b;
        if (r0 == null) goto L6;
        r0.dispose();
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void a(a r3) {
        Handler r0 = DialogLancet.resolveDialogHandler(r3);
        if (r0 != null) goto L5;
    L8:
        DialogLancet.beforeDialogDismiss(r3);
        r3.dismiss();     // Catch: Throwable -> L11 Exception -> L13
    L10:
        DialogLancet.afterDialogDismiss(r3);
        return;
    L11:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r3);
        throw th;
    L13:
        e = move-exception;
        d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L11
        Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L11
        if (r1 == null) goto L10;
        d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L11
        goto L10
    L5:
        if (Looper.myLooper() == r0.getLooper()) goto L8;
        r0.post(DialogLancet.createDismissRunnable(r3));
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r8) {
        Intrinsics.checkNotNullParameter(r8, "v");
        int r9 = r8.getId();
        if (r9 != 2131393012) goto L9;
        xs2.b.a().post(new UserProfileEvent(this.c.getUser()).setClickUserPosition("linked_audience_multiaudience").setReportSource("audience_audio").setReportType("data_card_linked_audience_mutiaudience"));
        if (this.d == false) goto L7;
        g2 r10 = zi0.d.b;
        zi0.d.d(this.c, "profile");
    L7:
        a(this);
        return;
    L9:
        if (r9 != 2131385966) goto L33;
        m r11 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r11 == null) goto L15;
        IRoom r12 = (IRoom) r11.getValue();
        if (r12 == null) goto L15;
        Long r13 = Long.valueOf(r12.getRoomId());
    L16:
        long r4 = this.c.getLinkRoomId();
        if (this.c.getRoomLinkSilenceStatus() != 1) goto L19;
        boolean r0 = true;
    L20:
        if (r13 == null) goto L25;
        if (r0 == true) goto L23;
        Single<e<r1>> r14 = ((LinkApi) c.b().e(LinkApi.class)).silenceLinkRoom(r13.longValue(), r4, 2);
    L24:
        long r1 = System.currentTimeMillis();
        r14.compose(RxUtil.rxSchedulerHelper()).subscribe(new C0293a(this, r0, r1), new b(this, r0, r1));
        goto L25
    L23:
        r14 = ((LinkApi) c.b().e(LinkApi.class)).unSilenceLinkRoom(r13.longValue(), r4, 1);
    L25:
        a(this);
        if (this.d == false) goto L37;
        g2 r15 = zi0.d.b;
        ILinkPlayerInfoBridge r16 = this.c;
        if (r0 == false) goto L30;
        String r2 = "unmute";
    L31:
        zi0.d.d(r16, r2);
        return;
    L30:
        r2 = "mute";
        goto L31
    L37:
        return;
    L19:
        r0 = false;
    L15:
        r13 = null;
        goto L16
    L33:
        if (r9 != 2131365114) goto L39;
        a(this);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onCreate(Bundle r6) {
        super/*android.app.Dialog*/.onCreate(r6);
        setContentView(LayoutInflater.from(getContext()).inflate(2131565590, null));
        Window r7 = getWindow();
        if (r7 == null) goto L5;
        r7.setGravity(80);
        r7.setLayout(-1, -2);
    L5:
        TextView r0 = (TextView) findViewById(2131374360);
        boolean r1 = true;
        Object[] r2 = new Object[1];
        IBaseUser r3 = this.c.getUser();
        if (r3 == null) goto L9;
        String r4 = r3.getNickName();
        if (r4 == null) goto L9;
    L10:
        r2[0] = r4;
        r0.setText(s1.C(2131917730, r2));
        ((TextView) findViewById(2131374360)).setOnClickListener(this);
        ((TextView) findViewById(2131393012)).setOnClickListener(this);
        ((TextView) findViewById(2131385966)).setOnClickListener(this);
        Map.Entry r5 = tc0.c.h().p;
        if (r5 == null) goto L17;
        g2 r8 = (g2) r5.getValue();
        if (r8 == null) goto L17;
        if (r8.getRoomLinkSilenceStatus() != 1) goto L17;
    L18:
        TextView r9 = (TextView) findViewById(2131385966);
        if (r1 == true) goto L21;
        String r10 = s1.B(2131917728);
    L22:
        r9.setText(r10);
        return;
    L21:
        r10 = s1.B(2131917731);
    L17:
        r1 = false;
    L9:
        r4 = "";
        goto L10
    }

    public a(Context r2, ILinkPlayerInfoBridge r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r2, "mContext");
        Intrinsics.checkNotNullParameter(r3, "userInfo");
        super(r2, true);
        this.c = r3;
        this.d = r4;
        this.b = new CompositeDisposable();
        y r5 = (y) ((IInteractService) k.n(IInteractService.class)).getLinkUserInfoCenter();
    }
}
