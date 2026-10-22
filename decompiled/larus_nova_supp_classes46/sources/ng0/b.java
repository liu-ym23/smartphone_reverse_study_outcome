package ng0;

import android.content.Context;
import android.os.Bundle;
import android.view.ViewParent;
import android.widget.FrameLayout;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.layer.base.MicSeatScene;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.base.LayerBackgroundStatus;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.MultiLinkGuestViewBinder;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.pre.VerticalNitaInflate;
import com.bytedance.android.live.liveinteract.voicechat.IVoiceChatAdminService;
import com.bytedance.android.live.liveinteract.voicechat.view.VoiceChatRoomAnchorView;
import com.bytedance.android.livesdk.common.AnchorPauseTipsView;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.live.datacontext.m;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class b extends jg0.c<MultiLinkGuestViewBinder.a> {
    public MultiLinkGuestViewBinder.a d;
    public VoiceChatRoomAnchorView e;
    public AnchorPauseTipsView f;

    public static final class a {
    }

    static {
    }

    @Override // jg0.c
    public final int o() {
        return 2131566612;
    }

    @Override // jg0.c, jg0.f
    public final void onDetach() {
        this.d = null;
        r(true);
    }

    @Override // jg0.c
    public final String p() {
        return VerticalNitaInflate.Tag.MultiLinkRadioMainSeatLayer.name();
    }

    @Override // jg0.c, jg0.f
    public final void a(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super.a(r2);
        this.e = (VoiceChatRoomAnchorView) q().findViewById(2131363504);
        this.f = q().findViewById(2131363505);
        VoiceChatRoomAnchorView r3 = this.e;
        if (r3 == null) goto L6;
        r3.post(new d(this));
        return;
    }

    public final void r(boolean r8) {
        MultiLinkGuestViewBinder.a r0 = this.d;
        if (r0 == null) goto L82;
        ch0.e r1 = r0.k;
        if (r1 == null) goto L83;
        ILinkPlayerInfoBridge r2 = r1.a;
        if (r2 != null) goto L10;
        return;
    L10:
        if (r2.getSilenceStatus() == 0) goto L12;
        boolean r3 = true;
    L13:
        IBaseUser r4 = r2.getUser();
        ViewParent r5 = null;
        if (r4 == null) goto L16;
        String r6 = r4.getIdString();
    L17:
        m r7 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r7 == null) goto L22;
        IRoom r9 = (IRoom) r7.getValue();
        if (r9 == null) goto L22;
        String r10 = r9.getOwnerUserIdString();
    L23:
        boolean r11 = Intrinsics.areEqual(r6, r10);
        if (je0.d.D() == true) goto L48;
        IVoiceChatAdminService.Companion.getClass();
        IVoiceChatAdminService r12 = IVoiceChatAdminService.a.a();
        if (r12 != null) goto L28;
    L30:
        if (r8 == true) goto L32;
        LayerBackgroundStatus r13 = LayerBackgroundStatus.Audio;
    L55:
        int r14 = c.a[r13.ordinal()];
        if (r14 != 1) goto L58;
        VoiceChatRoomAnchorView r15 = this.e;
        if (r15 == null) goto L78;
        ViewParent r16 = r15.getParent();
        if ((r16 instanceof FrameLayout) == false) goto L75;
        r5 = r16;
    L75:
        FrameLayout r17 = (FrameLayout) r5;
        if (r17 == null) goto L78;
        r17.post(new ng0.a(r17, r15));
    L78:
        AnchorPauseTipsView r18 = this.f;
        if (r18 == null) goto L86;
        UtilityKotlinExtentionsKt.t(r18);
        return;
    L86:
        return;
    L58:
        if (r14 != 2) goto L88;
        VoiceChatRoomAnchorView r19 = this.e;
        if (r19 == null) goto L63;
        r19.d(0);
    L63:
        VoiceChatRoomAnchorView r20 = this.e;
        if (r20 == null) goto L66;
        UtilityKotlinExtentionsKt.t(r20);
    L66:
        AnchorPauseTipsView r21 = this.f;
        if (r21 == null) goto L84;
        UtilityKotlinExtentionsKt.w(r21);
        return;
    L84:
        return;
    L88:
        return;
    L32:
        if (r2.getSilenceStatus() == 0) goto L40;
        IBaseUser r22 = r2.getUser();
        if (r22 == null) goto L36;
        String r23 = r22.getIdString();
    L38:
        if ((!Intrinsics.areEqual(r23, je0.d.b0())) == false) goto L40;
        boolean r24 = true;
    L41:
        if (r24 == true) goto L45;
        if (r11 == true) goto L45;
        r13 = LayerBackgroundStatus.Audio;
    L45:
        r13 = LayerBackgroundStatus.Leave;
        goto L55
    L36:
        r23 = null;
    L40:
        r24 = false;
        goto L41
    L28:
        if (r12.isEngineOn() != true) goto L30;
    L48:
        if (r2.isSelfBackground() == true) goto L50;
        r13 = LayerBackgroundStatus.Audio;
        goto L55
    L50:
        if (r3 == true) goto L54;
        if (r11 == true) goto L54;
        r13 = LayerBackgroundStatus.Audio;
    L54:
        r13 = LayerBackgroundStatus.Leave;
    L22:
        r10 = null;
        goto L23
    L16:
        r6 = null;
        goto L17
    L12:
        r3 = false;
        goto L13
    L83:
        return;
    }

    public b(MicSeatScene r2, xg0.a r3) {
        Intrinsics.checkNotNullParameter(r2, "scene");
        Intrinsics.checkNotNullParameter(r3, "linkSeatAbilityProvider");
        super(r2, r3);
    }

    @Override // jg0.f
    public final void d(Object r3, int r4) {
        MultiLinkGuestViewBinder.a r5 = (MultiLinkGuestViewBinder.a) r3;
        Intrinsics.checkNotNullParameter(r5, "itemData");
        boolean r0 = true;
        if (this.d != null) goto L12;
        IRoom r6 = r5.h;
        if (r6 == null) goto L12;
        VoiceChatRoomAnchorView r1 = this.e;
        if (r1 == null) goto L9;
        r1.f(r6);
    L9:
        VoiceChatRoomAnchorView r7 = this.e;
        if (r7 == null) goto L12;
        r7.d(1);
    L12:
        this.d = r5;
        if (r5 == null) goto L21;
        ch0.e r8 = r5.k;
        if (r8 == null) goto L21;
        ILinkPlayerInfoBridge r9 = r8.a;
        if (r9 == null) goto L21;
        if (r9.isBackground() != true) goto L21;
    L22:
        r(r0);
        return;
    L21:
        r0 = false;
        goto L22
    }

    @Override // jg0.f
    public final void k(Object r2, int r3, Bundle r4) {
        MultiLinkGuestViewBinder.a r5 = (MultiLinkGuestViewBinder.a) r2;
        Intrinsics.checkNotNullParameter(r5, "itemData");
        Intrinsics.checkNotNullParameter(r4, "payload");
        this.d = r5;
        Iterator<String> r6 = r4.keySet().iterator();
    L4:
        if (r6.hasNext() == false) goto L24;
        String r7 = r6.next();
        if (r7 == null) goto L4;
        if (r7.hashCode() != (-1010189482)) goto L4;
        if (r7.equals("payload_key_background_status_update") == false) goto L4;
        MultiLinkGuestViewBinder.a r8 = this.d;
        if (r8 == null) goto L22;
        ch0.e r9 = r8.k;
        if (r9 == null) goto L22;
        ILinkPlayerInfoBridge r10 = r9.a;
        if (r10 == null) goto L22;
        boolean r11 = true;
        if (r10.isBackground() != true) goto L22;
    L23:
        r(r11);
    L22:
        r11 = false;
        goto L23
    }
}
