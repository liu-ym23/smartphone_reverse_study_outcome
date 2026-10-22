package com.bytedance.android.livesdk.chatroom.ui.framework.widget;

import androidx.fragment.app.Fragment;
import com.bytedance.android.livesdk.chatroom.widget.MiddlewareRoomWidget;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPageFragment;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragment;
import com.bytedance.android.livesdkapi.depend.live.IRoomEventListener;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.ies.sdk.widgets.Widget;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/ui/framework/widget/AudienceOuterServiceWidget;", "Lcom/bytedance/android/livesdk/chatroom/widget/MiddlewareRoomWidget;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "<init>", "()V", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AudienceOuterServiceWidget extends MiddlewareRoomWidget implements Observer<KVData> {
    public com.bytedance.android.livesdk.chatroom.ui.framework.c a;

    @Override // com.bytedance.android.livesdk.chatroom.widget.MiddlewareRoomWidget
    public final void onCreate() {
        super.onCreate();
        com.bytedance.android.livesdk.chatroom.ui.framework.utils.f.c(this);
        this.a = ho1.a.d(getComponentContext());
        Fragment r0 = wq();
        boolean r1 = r0 instanceof ILiveRoomPlayFragment;
        if (r1 == false) goto L12;
        ILiveRoomPageFragment r2 = null;
        if (r1 == true) goto L7;
        r0 = null;
    L7:
        ILiveRoomPlayFragment r3 = (ILiveRoomPlayFragment) r0;
        if (r3 == null) goto L10;
        r2 = r3.parentPage();
    L10:
        if (r2 == null) goto L12;
        ((Widget) this).dataCenter.put("data_room_action", r2.getRealAction().roomAction());
    L12:
        DataCenter r4 = ((Widget) this).dataCenter;
        if (r4 == null) goto L15;
        r4.observeForever("cmd_p0_widget_loaded", this);
    L15:
        DataCenter r5 = ((Widget) this).dataCenter;
        if (r5 == null) goto L18;
        r5.observeForever("cmd_p1_widget_loaded", this);
    L18:
        DataCenter r6 = ((Widget) this).dataCenter;
        if (r6 == null) goto L21;
        r6.observeForever("cmd_p2_widget_loaded", this);
    L21:
        DataCenter r7 = ((Widget) this).dataCenter;
        if (r7 == null) goto L25;
        r7.observeForever("cmd_widget_loaded", this);
        return;
    }

    public final void onDestroy() {
        super.onDestroy();
        com.bytedance.android.livesdk.chatroom.ui.framework.utils.f.d(this);
        DataCenter r0 = ((Widget) this).dataCenter;
        if (r0 == null) goto L5;
        r0.removeObserver(this);
    L5:
        this.a = null;
    }

    public final Fragment wq() {
        h70.b r0 = getComponentContext();
        if (r0 == null) goto L9;
        com.bytedance.android.livesdk.chatroom.ui.framework.c r1 = ho1.a.d(r0);
        if (r1 == null) goto L9;
        Fragment r2 = r1.getFragment();
        if (r2 == null) goto L9;
        return r2.getParentFragment();
    L9:
        return null;
    }

    public final void xq() {
        Fragment r0 = wq();
        boolean r1 = r0 instanceof ILiveRoomPlayFragment;
        if (r1 == false) goto L15;
        ILiveRoomPageFragment r2 = null;
        if (r1 == true) goto L7;
        r0 = null;
    L7:
        ILiveRoomPlayFragment r3 = (ILiveRoomPlayFragment) r0;
        if (r3 == null) goto L10;
        r2 = r3.parentPage();
    L10:
        if (r2 != null) goto L12;
        return;
    L12:
        if (r2.getRealAction().getCurrentPosition() != 0) goto L17;
        r2.getRealAction().notifyDataSetChange();
        return;
    L17:
        return;
    }

    public AudienceOuterServiceWidget() {
    }

    public final void onChanged(Object r5) {
        KVData r6 = (KVData) r5;
        com.bytedance.android.livesdk.chatroom.ui.framework.c r0 = this.a;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.hq() != true) goto L83;
        if (r6 == null) goto L9;
        String r1 = r6.getKey();
    L10:
        if (r1 == null) goto L84;
        String r3 = "";
        switch(r1.hashCode()) {
            case -1836833765: goto L58;
            case -1575056762: goto L44;
            case -67504953: goto L30;
            case 1440046856: goto L16;
            default: goto L85;
        };
    L85:
        return;
    L16:
        if (r1.equals("cmd_p2_widget_loaded") == true) goto L18;
        return;
    L18:
        if (com.bytedance.android.livesdk.model.a0.d() == false) goto L20;
        com.bytedance.android.livesdk.model.a0.e("CMD_P2_WIDGET_LOADED");
        xq();
    L20:
        DataCenter r7 = ((Widget) this).dataCenter;
        if (r7 == null) goto L28;
        Room r8 = com.bytedance.android.live.core.utils.z.o(r7);
        if (r8 == null) goto L28;
        String r9 = r8.getIdStr();
        if (r9 == null) goto L28;
        r3 = r9;
    L28:
        yq(r3, "p2");
        return;
    L30:
        if (r1.equals("cmd_p1_widget_loaded") == true) goto L32;
        return;
    L32:
        if (com.bytedance.android.livesdk.model.a0.c() == false) goto L34;
        com.bytedance.android.livesdk.model.a0.e("CMD_P1_WIDGET_LOADED");
        xq();
    L34:
        DataCenter r10 = ((Widget) this).dataCenter;
        if (r10 == null) goto L42;
        Room r11 = com.bytedance.android.live.core.utils.z.o(r10);
        if (r11 == null) goto L42;
        String r12 = r11.getIdStr();
        if (r12 == null) goto L42;
        r3 = r12;
    L42:
        yq(r3, "p1");
        return;
    L44:
        if (r1.equals("cmd_p0_widget_loaded") == true) goto L46;
        return;
    L46:
        if (com.bytedance.android.livesdk.model.a0.c() == false) goto L48;
        com.bytedance.android.livesdk.model.a0.e("CMD_P1_WIDGET_LOADED");
        xq();
    L48:
        DataCenter r13 = ((Widget) this).dataCenter;
        if (r13 == null) goto L56;
        Room r14 = com.bytedance.android.live.core.utils.z.o(r13);
        if (r14 == null) goto L56;
        String r15 = r14.getIdStr();
        if (r15 == null) goto L56;
        r3 = r15;
    L56:
        yq(r3, "p0");
        return;
    L58:
        if (r1.equals("cmd_widget_loaded") == true) goto L60;
        return;
    L60:
        if (com.bytedance.android.livesdk.chatroom.ui.framework.utils.d.a(r6) == true) goto L62;
        return;
    L62:
        if (com.bytedance.android.livesdk.model.a0.a() == false) goto L64;
        com.bytedance.android.livesdk.model.a0.e("CMD_WIDGET_LOADED");
        xq();
    L64:
        DataCenter r16 = ((Widget) this).dataCenter;
        if (r16 == null) goto L72;
        Room r17 = com.bytedance.android.live.core.utils.z.o(r16);
        if (r17 == null) goto L72;
        String r18 = r17.getIdStr();
        if (r18 == null) goto L72;
        r3 = r18;
    L72:
        yq(r3, "all");
        return;
    L84:
        return;
    L9:
        r1 = null;
        goto L10
    }

    public final void yq(String r4, String r5) {
        Fragment r0 = wq();
        boolean r1 = r0 instanceof ILiveRoomPlayFragment;
        if (r1 == false) goto L15;
        ILiveRoomPageFragment r2 = null;
        if (r1 == true) goto L7;
        r0 = null;
    L7:
        ILiveRoomPlayFragment r3 = (ILiveRoomPlayFragment) r0;
        if (r3 == null) goto L10;
        r2 = r3.parentPage();
    L10:
        if (r2 == null) goto L16;
        IRoomEventListener r6 = r2.getRealAction().roomEventListener();
        if (r6 == null) goto L17;
        r6.onWidgetLoaded(r4, r5);
        return;
    L17:
        return;
    L16:
        return;
    }
}
