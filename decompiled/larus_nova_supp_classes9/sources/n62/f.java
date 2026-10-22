package n62;

import am2.x;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.livehostapi.business.IHostBusiness;
import com.bytedance.android.livehostapi.business.depend.IGenCodeShareCallback;
import com.bytedance.android.livehostapi.business.depend.IShareMsgCallback;
import com.bytedance.android.livehostapi.business.depend.ISharePanelStateListener;
import com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.j;
import com.bytedance.android.livesdk.interactivity.api.monitor.InteractivityMonitor;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import jc1.k;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class f implements ISharePanelStateListener {
    public final /* synthetic */ e a;
    public final /* synthetic */ long b;
    public final /* synthetic */ Context c;
    public final /* synthetic */ s22.a d;

    public static final class a implements IGenCodeShareCallback {
        public final /* synthetic */ Map a;

        public a(Map r1) {
            this.a = r1;
        }

        public final void onShareFail(Throwable r1) {
            boolean r2 = n62.a.d;
            n62.a.e = false;
        }

        public final void onShareSuccess(String r1, String r2, Map<String, String> r3) {
            n62.a.e = false;
            if (TextUtils.equals(r1, "weixin") == true) goto L5;
            return;
        L5:
            if (TextUtils.equals(r2, "command") == false) goto L9;
            int r4 = j.a;
            Map r5 = this.a;
            Intrinsics.checkNotNullParameter(r5, "logMap");
            j.l("livesdk_match_chat_wechat_invite_paste", r5);
            return;
        }
    }

    public static final class b implements IShareMsgCallback {
        public b() {
        }

        public final void onFail() {
            boolean r0 = n62.a.d;
            n62.a.e = false;
        }

        public final void onSuccess() {
            boolean r0 = n62.a.d;
            n62.a.e = false;
            f2.b(2131915712, 0);
        }
    }

    public final void onClose(View r3) {
        Intrinsics.checkNotNullParameter(r3, "view");
        ISharePanelStateListener.-CC.$default$onClose(this, r3);
        e r4 = this.a;
        r4.j.recordChatChannelDialog(r4.g, null);
        boolean r5 = n62.a.d;
        n62.a.e = false;
    }

    public final void onDismiss(Map<String, String> r3) {
        ISharePanelStateListener.-CC.$default$onDismiss(this, r3);
        e r4 = this.a;
        r4.j.recordChatChannelDialog(r4.g, null);
        boolean r5 = n62.a.d;
        n62.a.e = false;
    }

    public final void onGenCodeShare(Map<String, String> r5) {
        ISharePanelStateListener.-CC.$default$onGenCodeShare(this, r5);
        LinkedHashMap r0 = new LinkedHashMap();
        if (r5 == null) goto L6;
        r0.putAll(r5);
    L6:
        if (this.a.f == null) goto L12;
        IHostBusiness r6 = k.f(IHostBusiness.class);
        if (r6 == null) goto L10;
        r6.shareGenCode(this.c, this.a.f, new a(r0));
        Unit r7 = Unit.INSTANCE;
    L11:
        if (r7 == null) goto L12;
    L13:
        int r8 = j.a;
        Intrinsics.checkNotNullParameter(r0, "logMap");
        j.l("livesdk_match_chat_wechat_invite_click", r0);
        return;
    L10:
        r7 = null;
    L12:
        f2.b(2131915711, 0);
        Unit r9 = Unit.INSTANCE;
        goto L13
    }

    public final void onShow(Map<String, String> r10) {
        ISharePanelStateListener.-CC.$default$onShow(this, r10);
        int r11 = com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.g.a;
        long r7 = com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.g.c(Long.valueOf(this.b));
        new com.bytedance.android.livesdk.interactivity.api.monitor.c(0, null, r7, null, 11).a(InteractivityMonitor.Event.ChatChannelInviteShowCost);
        Map r0 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("duration", String.valueOf(r7))});
        u.l().sendLog("ttlive_chat_channel_invite_show", r0, new Object[]{x.class, Room.class});
    }

    public final void onInvite(List<? extends com.bytedance.android.live.base.model.user.f> r7, Map<String, String> r8) {
        ISharePanelStateListener.-CC.$default$onInvite(this, r7, r8);
        LinkedHashMap r0 = new LinkedHashMap();
        if (r8 == null) goto L6;
        r0.putAll(r8);
    L6:
        if (this.a.f == null) goto L12;
        IHostBusiness r9 = k.f(IHostBusiness.class);
        if (r9 == null) goto L10;
        r9.shareInviteMsg(this.c, this.a.f, r7, new b());
        Unit r10 = Unit.INSTANCE;
    L11:
        if (r10 == null) goto L12;
    L13:
        n62.a.b(this.a.j, this.d, r7);
        j.f("invite_panel", false, r0, null);
        return;
    L10:
        r10 = null;
    L12:
        f2.b(2131915711, 0);
        Unit r11 = Unit.INSTANCE;
        goto L13
    }

    public f(e r1, long r2, Context r4, s22.a r5) {
        this.a = r1;
        this.b = r2;
        this.c = r4;
        this.d = r5;
    }
}
