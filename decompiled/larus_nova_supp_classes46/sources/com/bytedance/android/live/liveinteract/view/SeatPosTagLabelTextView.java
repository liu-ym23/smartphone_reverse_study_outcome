package com.bytedance.android.live.liveinteract.view;

import ai0.e;
import android.content.Context;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.layer.base.MicSeatScene;
import com.bytedance.android.live.liveinteract.interactivesong.impl.InteractiveSongContext;
import com.bytedance.android.live.liveinteract.plantform.base.i;
import com.bytedance.android.live.liveinteract.plantform.dynamicframe.MultiLinkFeedDynamicWidgetNew;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.plantform.model.LinkPlayerInfo;
import com.bytedance.android.live.liveinteract.plantform.model.g0;
import com.bytedance.android.live.liveinteract.revenue.adventure.AdventureContext;
import com.bytedance.android.live.liveinteract.revenue.adventure.AdventureState;
import com.bytedance.android.live.liveinteract.revenue.fight.TeamFightContext;
import com.bytedance.android.live.liveinteract.utils.j0;
import com.bytedance.android.live.liveinteract.videotalk.cposition.CPositionContext;
import com.bytedance.android.livesdk.chatroom.model.interact.h;
import com.bytedance.android.livesdk.utils.MultiLinkSettingHelper;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.linker.CPositionModeUtil;
import com.bytedance.live.datacontext.m;
import java.util.Iterator;
import java.util.List;
import jc1.k;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import vm2.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001\rB'\b\u0007\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\n\u001a\u00020\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/live/liveinteract/view/SeatPosTagLabelTextView;", "Landroidx/appcompat/widget/AppCompatTextView;", "", "visibility", "", "setVisibility", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class SeatPosTagLabelTextView extends AppCompatTextView {

    public static final class a {
    }

    static {
    }

    public SeatPosTagLabelTextView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public SeatPosTagLabelTextView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setVisibility(int r3) {
        super/*android.widget.TextView*/.setVisibility(r3);
        if (v.a() == false) goto L6;
        ALogger.d("SeatPosTagLabelTextView", "setVisibility ;;  visibility == " + r3 + " ;; visible == 0 ;; gone == 8 ");
        return;
    }

    public SeatPosTagLabelTextView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
    }

    public static boolean A(SeatPosTagLabelTextView r6, ILinkPlayerInfoBridge r7, MicSeatScene r8) {
        r6.getClass();
        if (r7 == null) goto L9;
        g0 r1 = r7.getMicPosTagInfo();
        if (r1 == null) goto L9;
        if (r1.getTagType() != 3) goto L9;
        boolean r2 = true;
    L10:
        m r3 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        String r4 = null;
        if (r3 == null) goto L15;
        IRoom r5 = (IRoom) r3.getValue();
        if (r5 == null) goto L15;
        String r9 = r5.getOwnerUserIdString();
    L16:
        if (r7 == null) goto L21;
        IBaseUser r10 = r7.getUser();
        if (r10 == null) goto L21;
        r4 = r10.getIdString();
    L21:
        if (Intrinsics.areEqual(r9, r4) == false) goto L43;
        if (r7 == null) goto L43;
        if (r7.isEnlarged() == true) goto L43;
        IInteractService r11 = (IInteractService) k.f(IInteractService.class);
        if (r11 == null) goto L34;
        i<ILinkPlayerInfoBridge> r12 = r11.getLinkUserInfoCenter();
        if (r12 == null) goto L34;
        List<T> r13 = r12.getOnlineUserList();
        if (r13 == 0) goto L34;
        boolean r14 = CPositionModeUtil.hasCPositionUser(r13);
    L35:
        if (r14 == true) goto L42;
        CPositionContext r15 = CPositionContext.Companion.getContext();
        if (r15 == null) goto L43;
        m<Boolean> r16 = r15.isCPositionOpen();
        if (r16 == null) goto L43;
        if (((Boolean) r16.getValue()).booleanValue() != true) goto L43;
    L42:
        boolean r17 = true;
    L45:
        if (r8 != MicSeatScene.AUDIO_LINK) goto L47;
    L56:
        boolean r18 = true;
    L57:
        if (r18 == false) goto L62;
        if (r2 == false) goto L62;
        if (d.O() == false) goto L62;
    L64:
        return false;
    L62:
        if (r2 == true) goto L66;
        if (r17 == false) goto L64;
        return true;
    L66:
        return true;
    L47:
        if (r8 == MicSeatScene.AUDIO_LINK_ANCHOR) goto L56;
        if (r8 == MicSeatScene.AUDIO_LINK_LARGE) goto L56;
        if (r8 == MicSeatScene.AUDIO_LINK_C_POSITION) goto L56;
        if (r8 == MicSeatScene.AUDIO_LINK_C_POSITION_V2) goto L56;
        r18 = false;
    L34:
        r14 = false;
    L43:
        r17 = false;
    L15:
        r9 = null;
    L9:
        r2 = false;
        goto L10
    }

    public static void x(SeatPosTagLabelTextView r1, int r2, LinkPlayerInfo r3) {
        if (A(r1, r3, null) == false) goto L5;
        r1.setVisibility(8);
        return;
    L5:
        r1.setVisibility(r2);
    }

    public /* synthetic */ SeatPosTagLabelTextView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }

    public final void y(int r11, ILinkPlayerInfoBridge r12, MicSeatScene r13, Boolean r14) {
        boolean r1 = true;
        if (MultiLinkSettingHelper.a() == true) goto L5;
    L10:
        Object r15 = null;
        if (r12 == null) goto L13;
        g0 r0 = r12.getMicPosTagInfo();
    L14:
        if (r0 != null) goto L17;
    L131:
        if (r1 == false) goto L133;
        setVisibility(8);
        return;
    L133:
        setVisibility(r11);
        return;
    L17:
        if (TeamFightContext.Companion.h() == false) goto L19;
        r1 = true ^ li0.d.g(null);
        goto L131
    L19:
        if (r12 == null) goto L25;
        g0 r2 = r12.getMicPosTagInfo();
        if (r2 == null) goto L25;
        if (r2.getTagType() != 3) goto L25;
    L28:
        if (A(this, r12, r13) == true) goto L131;
        if (r12 == null) goto L130;
        g0 r3 = r12.getMicPosTagInfo();
        if (r3 == null) goto L130;
        int r4 = j0.a;
        Intrinsics.checkNotNullParameter(r3, "tagInfo");
        IInteractService r5 = (IInteractService) k.f(IInteractService.class);
        if (r5 == null) goto L37;
        ih0.b r6 = r5.dynamicService(null);
    L38:
        if (r6 != null) goto L40;
    L43:
        boolean r7 = true;
    L44:
        IInteractService r8 = (IInteractService) k.f(IInteractService.class);
        if (r8 == null) goto L127;
        e r9 = r8.getAdventureService();
        if (r9 == null) goto L127;
        IBaseUser r16 = r12.getUser();
        if (r16 == null) goto L52;
        String r17 = r16.getIdString();
        if (r17 == null) goto L52;
    L53:
        ai0.c r10 = (ai0.c) r9;
        Intrinsics.checkNotNullParameter(r3, "tagInfo");
        Intrinsics.checkNotNullParameter(r17, "micSeatUid");
        if (r7 == true) goto L124;
        AdventureContext.Companion.getClass();
        boolean r18 = AdventureContext.a.a();
        AdventureState r19 = r10.a(null);
        if (r18 == false) goto L118;
        if (r19 == null) goto L118;
        String r20 = je0.d.b0();
        h r21 = r19.adventureInfo;
        if (r21 == null) goto L72;
        List r22 = r21.getLinkedUserList();
        if (r22 == null) goto L72;
        Iterator r23 = r22.iterator();
    L66:
        if (r23.hasNext() == false) goto L70;
        Object r24 = r23.next();
        if (Intrinsics.areEqual(((com.bytedance.android.livesdk.chatroom.model.interact.k) r24).getUserIdString(), r20) == false) goto L66;
    L71:
        com.bytedance.android.livesdk.chatroom.model.interact.k r25 = (com.bytedance.android.livesdk.chatroom.model.interact.k) r24;
    L73:
        long r26 = r3.getTagTypeId();
        if (r26 != 9) goto L84;
        if (Intrinsics.areEqual(r20, r17) == false) goto L124;
        if (r25 == null) goto L123;
        List r110 = r25.getInviteUsersString();
        if (r110 == null) goto L124;
        if (r110.isEmpty() != true) goto L124;
    L123:
        boolean r111 = true;
    L125:
        if (r111 != true) goto L127;
        boolean r112 = true;
    L128:
        if (r112 == false) goto L130;
    L84:
        if (r26 != 10) goto L124;
        if (Intrinsics.areEqual(r20, r17) == true) goto L124;
        h r27 = r19.adventureInfo;
        if (r27 == null) goto L99;
        List r28 = r27.getLinkedUserList();
        if (r28 == null) goto L99;
        Iterator r29 = r28.iterator();
    L93:
        if (r29.hasNext() == false) goto L97;
        Object r30 = r29.next();
        if (Intrinsics.areEqual(((com.bytedance.android.livesdk.chatroom.model.interact.k) r30).getUserIdString(), r17) == false) goto L93;
    L98:
        com.bytedance.android.livesdk.chatroom.model.interact.k r31 = (com.bytedance.android.livesdk.chatroom.model.interact.k) r30;
    L100:
        if (r31 == null) goto L124;
        List r113 = r31.getInviteUsersString();
        if (r113 == null) goto L104;
        int r114 = r113.size();
    L105:
        List r32 = r31.getInviteUsersString();
        if (r32 == null) goto L115;
        Iterator r33 = r32.iterator();
    L109:
        if (r33.hasNext() == false) goto L113;
        Object r34 = r33.next();
        if (Intrinsics.areEqual((String) r34, r20) == false) goto L109;
        r15 = r34;
    L113:
        r15 = (String) r15;
    L115:
        if (r114 < 50) goto L124;
        if (r15 != null) goto L124;
    L104:
        r114 = 0;
        goto L105
    L97:
        r30 = null;
    L99:
        r31 = null;
        goto L100
    L70:
        r24 = null;
    L72:
        r25 = null;
    L118:
        long r35 = r3.getTagTypeId();
        if (9 > r35) goto L124;
        if (11 >= r35) goto L123;
    L124:
        r111 = false;
    L52:
        r17 = "";
    L127:
        r112 = false;
        goto L128
    L40:
        if ((r6 instanceof MultiLinkFeedDynamicWidgetNew) == true) goto L43;
        r7 = false;
        goto L44
    L37:
        r6 = null;
    L130:
        r1 = false;
    L25:
        if (InteractiveSongContext.Companion.f() == false) goto L28;
    L13:
        r0 = null;
        goto L14
    L5:
        if ((!Intrinsics.areEqual(r14, Boolean.FALSE)) == false) goto L10;
        if (r12 == null) goto L131;
        if (r12.getExpectLeaveTime() == 0) goto L10;
        goto L10
    }

    public static /* synthetic */ void z(SeatPosTagLabelTextView r2, int r3, ILinkPlayerInfoBridge r4, MicSeatScene r5, Boolean r6, int r7) {
        if ((r7 & 4) == 0) goto L6;
        r5 = null;
    L6:
        if ((r7 & 8) == 0) goto L8;
        r6 = null;
    L8:
        r2.y(r3, r4, r5, r6);
    }
}
