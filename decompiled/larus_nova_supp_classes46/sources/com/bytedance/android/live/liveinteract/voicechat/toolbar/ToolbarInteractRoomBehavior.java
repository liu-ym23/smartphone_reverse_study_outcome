package com.bytedance.android.live.liveinteract.voicechat.toolbar;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.lifecycle.Observer;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.liveinteract.plantform.utils.TalkRoomLogUtils;
import com.bytedance.android.live.liveinteract.voicechat.IVoiceChatAdminService;
import com.bytedance.android.livesdk.chatroom.ui.RedDotView;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdk.r3;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import java.util.HashMap;
import vlc.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public class ToolbarInteractRoomBehavior implements c0.b, Observer<KVData>, l {
    public View a;
    public View b;
    public View c;
    public TextView d;
    public DataCenter e;
    public boolean f;
    public vlc.d g;
    public RedDotView h;

    public ToolbarInteractRoomBehavior() {
    }

    public final /* synthetic */ void Bh(ToolbarButton r1) {
    }

    public final /* synthetic */ void Mr(s r1) {
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

    public void onMessage(tlc.d r1) {
    }

    public final /* synthetic */ void setAlpha(float r1) {
    }

    public final /* synthetic */ boolean showRedDot() {
        return false;
    }

    public final void a() {
        Integer r0 = je0.d.h();
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.intValue() != 29) goto L16;
        Boolean r1 = (Boolean) com.bytedance.android.livesdk.sharedpref.b.V3.getValue();
        if (r1 == null) goto L9;
        boolean r2 = r1.booleanValue();
    L10:
        if (r2 == true) goto L17;
        RedDotView r3 = this.h;
        if (r3 == null) goto L18;
        r3.setVisibility(0);
        return;
    L18:
        return;
    L17:
        return;
    L9:
        r2 = false;
        goto L10
    }

    public final void b(int r2) {
        if (this.f == true) goto L5;
        return;
    L5:
        UIUtils.setViewVisibility(this.a, r2);
    }

    public final void c(int r3) {
        if (this.f == true) goto L5;
        return;
    L5:
        if (this.a != null) goto L8;
        return;
    L8:
        if (r3 <= 0) goto L10;
        UIUtils.setViewVisibility(this.b, 8);
        UIUtils.setViewVisibility(this.c, 0);
        return;
    L10:
        UIUtils.setViewVisibility(this.b, 0);
        UIUtils.setViewVisibility(this.c, 8);
    }

    public final void onChanged(Object r7) {
        KVData r8 = (KVData) r7;
        if (r8 != null) goto L5;
        return;
    L5:
        if (r8.getKey().isEmpty() == false) goto L7;
        return;
    L7:
        if (r8.getData() != null) goto L10;
        return;
    L10:
        if (r8.getKey().equals("data_audio_talk_dot_with_number_show") == false) goto L36;
        String r9 = (String) r8.getData();
        String r0 = s1.B(2131917979);
        if (TextUtils.isEmpty(r9) == false) goto L14;
        this.d.setVisibility(8);
        a();
        r3.c(this.a, r0, true);
    L32:
        c(CastIntegerProtector.parseInt(r9));     // Catch: Exception -> L30
        return;
    L30:
        c(0);
        return;
    L14:
        this.d.setText(r9);
        this.d.setVisibility(0);
        RedDotView r1 = this.h;
        if (r1 == null) goto L18;
        r1.setVisibility(8);
    L18:
        if (this.f == true) goto L20;
    L27:
        r3.c(this.a, r0 + "，" + r9, true);
        goto L32
    L20:
        if (vm2.d.s() == false) goto L27;
        this.d.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        ViewGroup.LayoutParams r2 = this.d.getLayoutParams();
        if (r2 == null) goto L27;
        r2.width = this.d.getMeasuredWidth();
        if ((r2 instanceof FrameLayout.LayoutParams) == false) goto L26;
        ((FrameLayout.LayoutParams) r2).gravity = 48;
    L26:
        this.d.setLayoutParams(r2);
        goto L27
    }

    public void onClick(View r5) {
        IVoiceChatAdminService.Companion.getClass();
        IVoiceChatAdminService r6 = IVoiceChatAdminService.a.a();
        if (r6 == null) goto L5;
        r6.showInviteAndPermitDialog(false, "bottom", -1);
    L5:
        RedDotView r7 = this.h;
        if (r7 != null) goto L8;
    L14:
        HashMap r8 = new HashMap();
        r8.put("action_type", "click");
        TalkRoomLogUtils.z0(r8, Integer.valueOf(je0.d.f()));
        j0.l().sendLog("livesdk_guest_connection_anchor", r8, new Object[]{IRoom.class});
        return;
    L8:
        if (r7.b == false) goto L14;
        if (je0.d.h().intValue() != 29) goto L14;
        com.bytedance.android.livesdk.sharedpref.e r9 = com.bytedance.android.livesdk.sharedpref.b.V3;
        Boolean r1 = Boolean.TRUE;
        r9.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r9, r1);
        RedDotView r10 = this.h;
        if (r10 == null) goto L14;
        r10.setVisibility(8);
        goto L14
    }

    public final void R9(View r1, DataCenter r2) {
        this.e.removeObserver(this);
        vlc.d r3 = this.g;
        if (r3 == null) goto L6;
        r3.removeMessageListener(this);
        return;
    }

    public final void p4(View r4, DataCenter r5) {
        this.e = r5;
        r5.observe("data_audio_talk_dot_with_number_show", this);
        this.f = ((Boolean) this.e.get("data_is_anchor", Boolean.TRUE)).booleanValue();
        DataCenter r6 = this.e;
        if (r6 == null) goto L5;
        this.g = (vlc.d) r6.get("data_message_manager");
    L5:
        vlc.d r7 = this.g;
        if (r7 == null) goto L8;
        r7.addMessageListener(MessageType.LINK_MIC_GUIDE_MESSAGE.getIntType(), this);
    L8:
        this.a = r4;
        r4.getContext();
        this.b = this.a.findViewById(2131381538);
        this.c = this.a.findViewById(2131392987);
        this.d = (TextView) this.a.findViewById(2131381099);
        this.h = this.a.findViewById(2131392581);
        if (this.f == true) goto L11;
    L15:
        UIUtils.setViewVisibility(this.b, 0);
        UIUtils.setViewVisibility(this.a, 0);
        UIUtils.setViewVisibility(this.c, 8);
        UIUtils.setViewVisibility(this.d, 8);
        if (this.f == false) goto L18;
        HashMap r8 = new HashMap();
        r8.put("action_type", "show");
        j0.l().sendLog("livesdk_guest_connection_anchor", r8, new Object[]{IRoom.class});
    L18:
        a();
        return;
    L11:
        if (vm2.d.s() == false) goto L15;
        UIUtils.setViewVisibility(this.a.findViewById(2131389484), 0);
        View r9 = this.a;
        if ((r9 instanceof ViewGroup) == false) goto L15;
        ((ViewGroup) r9).setClipChildren(false);
        ((ViewGroup) this.a).setClipToPadding(false);
        goto L15
    }
}
