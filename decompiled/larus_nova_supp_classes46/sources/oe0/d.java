package oe0;

import am2.x;
import android.content.Context;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.chatroom.chatroom.model.CPositionToEnlargePosition;
import com.bytedance.android.live.liveinteract.enlarge.dialog.MultiLinkEnlargeCancelOperateDialog;
import com.bytedance.android.live.liveinteract.enlarge.dialog.MultiLinkEnlargeOperateDialog;
import com.bytedance.android.live.liveinteract.enlarge.dialog.MultiLinkEnlargeSelectEnlargePositionDialog;
import com.bytedance.android.live.liveinteract.plantform.base.i;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.plantform.utils.TalkRoomLogUtils;
import com.bytedance.android.live.liveinteract.plantform.utils.h;
import com.bytedance.android.live.liveinteract.plantform.utils.i0;
import com.bytedance.android.live.liveinteract.videotalk.cposition.CPositionContext;
import com.bytedance.android.live.liveinteract.voicechat.IVoiceChatAdminService;
import com.bytedance.android.livesdk.chatroom.interact.model.d0;
import com.bytedance.android.livesdk.chatroom.interact.model.e0;
import com.bytedance.android.livesdk.chatroom.model.interact.EnlargeGuestInfo;
import com.bytedance.android.livesdk.chatroom.viewmodel.e;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdk.model.MultiLinkEnlargeTipsConfig;
import com.bytedance.android.livesdk.sharedpref.f;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.j;
import com.bytedance.live.datacontext.m;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import jc1.k;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class d {
    public static final long b() {
        i<ILinkPlayerInfoBridge> r0 = ((IInteractService) k.n(IInteractService.class)).getLinkUserInfoCenter();
        if (r0 == null) goto L12;
        Iterable r1 = r0.getOnlineUserList();
        if (r1 == null) goto L12;
        ArrayList r2 = new ArrayList();
        Iterator r3 = r1.iterator();
    L8:
        if (r3.hasNext() == false) goto L13;
        Object r4 = r3.next();
        if (((ILinkPlayerInfoBridge) r4).isEnlarged() == false) goto L8;
        r2.add(r4);
    L13:
        ILinkPlayerInfoBridge r5 = (ILinkPlayerInfoBridge) CollectionsKt.firstOrNull(r2);
        if (r5 == null) goto L17;
        return r5.getUserPosition();
    L17:
        return CPositionToEnlargePosition.Right.getValue();
    L12:
        r2 = new ArrayList();
        goto L13
    }

    public static void a(MultiLinkEnlargeOperateDialog r1) {
        if (DialogLancet.shouldBlockDialogShow(r1) == false) goto L10;
        DialogLancet.handleBlockedDialogShow(r1);
        return;
    L10:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L9
    L7:
        DialogLancet.beforeDialogShow(r1);
        r1.show();
        DialogLancet.afterDialogShow(r1);
    }

    public static final void c(boolean r16, String r17, long r18, Context r20, DataCenter r21) {
        Intrinsics.checkNotNullParameter(r17, "targetUserId");
        Intrinsics.checkNotNullParameter(r20, "context");
        d0.c(((IInteractService) k.n(IInteractService.class)).getCurrentPlayModes());
        IInteractService r6 = (IInteractService) k.f(IInteractService.class);
        Integer r9 = null;
        if (r6 == null) goto L33;
        i<ILinkPlayerInfoBridge> r7 = r6.getLinkUserInfoCenter();
        if (r7 == null) goto L33;
        Iterable r8 = r7.getOnlineUserList();
        if (r8 == null) goto L33;
        Iterable r10 = r8;
        if ((r10 instanceof Collection) == true) goto L11;
    L13:
        Iterator r11 = r10.iterator();
    L15:
        if (r11.hasNext() == false) goto L33;
        ILinkPlayerInfoBridge r12 = (ILinkPlayerInfoBridge) r11.next();
        if (r12.isEnlarged() == false) goto L31;
        IBaseUser r13 = r12.getUser();
        if (r13 == null) goto L21;
        String r14 = r13.getIdString();
    L22:
        m r15 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r15 == null) goto L27;
        IRoom r19 = (IRoom) r15.getValue();
        if (r19 == null) goto L27;
        String r110 = r19.getOwnerUserIdString();
    L29:
        if (Intrinsics.areEqual(r14, r110) == false) goto L31;
        boolean r111 = true;
    L32:
        if (r111 == false) goto L15;
    L27:
        r110 = null;
        goto L29
    L21:
        r14 = null;
    L31:
        r111 = false;
        goto L32
    L11:
        if (((Collection) r10).isEmpty() == false) goto L13;
    L33:
        i0 r22 = TalkRoomLogUtils.a;
        TalkRoomLogUtils.q = r17.toString();
        boolean r23 = je0.d.D();
        Intrinsics.checkNotNullParameter(r17, "targetUid");
        LinkedHashMap r112 = new LinkedHashMap();
        TalkRoomLogUtils.J0(r112);
        TalkRoomLogUtils.B0(r112, null, null, 6);
        TalkRoomLogUtils.V0(r112);
        if (r16 == false) goto L36;
        String r113 = "enlarge";
    L37:
        r112.put("action_type", r113);
        h r114 = TalkRoomLogUtils.b;
        r112.put("current_enlarge_user_type", TalkRoomLogUtils.o(Integer.valueOf(r114.a)));
        String r115 = "anchor";
        if (r23 == false) goto L40;
        String r24 = "anchor";
    L41:
        r112.put("user_type", r24);
        r112.put("enlarge_user_id", r17);
        m r25 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r25 == null) goto L46;
        IRoom r26 = (IRoom) r25.getValue();
        if (r26 == null) goto L46;
        String r27 = r26.getOwnerUserIdString();
    L48:
        if (Intrinsics.areEqual(r27, r17) == true) goto L51;
        r115 = "guest";
    L51:
        r112.put("enlarge_user_type", r115);
        r112.put("enlarge_open_from", String.valueOf(TalkRoomLogUtils.f()));
        if (r114.a != 26) goto L54;
        r112.put("is_empty_enlarge_seat", TalkRoomLogUtils.s(r21));
    L54:
        zi0.d.b(r112, false);
        Integer r28 = je0.d.h();
        if (r28 != null) goto L58;
    L60:
        String r29 = "classic";
    L61:
        r112.put("play_layout", r29);
        j0.l().sendLog("livesdk_live_anchor_enlarge_guest_setting_click", r112, new Object[]{IRoom.class, x.class});
        j r30 = com.bytedance.android.live.liveinteract.api.utils.m.i().getVideoTalkRoomSubScene();
        if (r30 == null) goto L68;
        e r31 = (e) r30.getValue();
        if (r31 == null) goto L68;
        com.bytedance.android.livesdk.chatroom.viewmodel.j r32 = r31.t();
        if (r32 == null) goto L68;
        Integer r33 = Integer.valueOf(r32.a);
    L69:
        if (r33 != null) goto L72;
    L74:
        boolean r34 = CPositionContext.a.b(CPositionContext.Companion);
    L75:
        if (r34 == true) goto L109;
        CPositionContext r0 = CPositionContext.Companion.getContext();
        if (r0 == null) goto L83;
        m<Boolean> r1 = r0.isCPositionOpen();
        if (r1 == null) goto L83;
        if (((Boolean) r1.getValue()).booleanValue() != true) goto L83;
        String r2 = "change";
    L84:
        String r5 = r2;
        boolean r3 = ((Boolean) vm2.d.Q6.getValue(null, vm2.d.a[404(0x194, float:5.66E-43)])).booleanValue();
        if (je0.d.D() == false) goto L97;
        rj0.k.m2.getClass();
        if (rj0.k.a.a() == null) goto L91;
        rj0.k r4 = rj0.k.a.a();
        if (r4 == null) goto L334;
        rj0.k.b.b(r4, r18, r17, r16, r5);
        return;
    L334:
        return;
    L91:
        com.bytedance.android.live.liveinteract.voicechat.d.s0.getClass();
        if (com.bytedance.android.live.liveinteract.voicechat.d.a.a() == null) goto L336;
        com.bytedance.android.live.liveinteract.voicechat.d r35 = com.bytedance.android.live.liveinteract.voicechat.d.a.a();
        if (r35 == null) goto L337;
        r35.setCPosition(r18, r17, r16, r5);
        return;
    L337:
        return;
    L336:
        return;
    L97:
        if (je0.d.Y() == true) goto L99;
        if (r3 == true) goto L99;
        return;
    L99:
        com.bytedance.android.live.liveinteract.plantform.base.k.n0.getClass();
        if (com.bytedance.android.live.liveinteract.plantform.base.k.a.a() == null) goto L104;
        com.bytedance.android.live.liveinteract.plantform.base.k r36 = com.bytedance.android.live.liveinteract.plantform.base.k.a.a();
        if (r36 == null) goto L340;
        r36.setCPosition(r18, r17, r16, r5);
        return;
    L340:
        return;
    L104:
        IVoiceChatAdminService.Companion.getClass();
        if (IVoiceChatAdminService.a.a() == null) goto L342;
        IVoiceChatAdminService r37 = IVoiceChatAdminService.a.a();
        if (r37 == null) goto L343;
        r37.setCPosition(r18, r17, r16, r5);
        return;
    L343:
        return;
    L342:
        return;
    L83:
        r2 = "add";
        goto L84
    L109:
        if (r16 == false) goto L241;
        CPositionContext r38 = CPositionContext.Companion.getContext();
        if (r38 == null) goto L117;
        m<EnlargeGuestInfo> r39 = r38.getEnlargeGuestInfo();
        if (r39 == null) goto L117;
        EnlargeGuestInfo r40 = (EnlargeGuestInfo) r39.getValue();
        if (r40 == null) goto L117;
        r9 = Integer.valueOf(r40.getEnlargeGuestType());
    L117:
        m r41 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r41 == null) goto L135;
        IRoom r42 = (IRoom) r41.getValue();
        if (r42 == null) goto L135;
        if (r42.isLiveTypeAudio() != true) goto L135;
        Integer r43 = je0.d.h();
        if (r43 == null) goto L126;
        int r44 = r43.intValue();
    L128:
        if (e0.b(r44) == false) goto L135;
        int r45 = EnlargeGuestInfo.EnlargeGuestType.EnlargeGuestType_Unkown.ordinal();
        if (r9 == null) goto L135;
        if (r9.intValue() != r45) goto L135;
        int r46 = MultiLinkEnlargeOperateDialog.D;
        a(MultiLinkEnlargeOperateDialog.a.a(r20, r18, r17));
        return;
    L126:
        r44 = 0;
    L135:
        int r47 = EnlargeGuestInfo.EnlargeGuestType.EnlargeGuestType_Unkown.ordinal();
        if (r9 != null) goto L139;
    L162:
        int r48 = EnlargeGuestInfo.EnlargeGuestType.EnlargeGuestType_Single.ordinal();
        if (r9 != null) goto L166;
    L168:
        int r49 = EnlargeGuestInfo.EnlargeGuestType.EnlargeGuestType_Double.ordinal();
        if (r9 != null) goto L172;
        return;
    L172:
        if (r9.intValue() != r49) goto L357;
        i<ILinkPlayerInfoBridge> r50 = ((IInteractService) k.n(IInteractService.class)).getLinkUserInfoCenter();
        if (r50 == null) goto L183;
        Iterable r51 = r50.getOnlineUserList();
        if (r51 == null) goto L183;
        ArrayList r52 = new ArrayList();
        Iterator r53 = r51.iterator();
    L179:
        if (r53.hasNext() == false) goto L185;
        Object r116 = r53.next();
        if (((ILinkPlayerInfoBridge) r116).isEnlarged() == false) goto L179;
        r52.add(r116);
    L185:
        if (r52.size() < 2) goto L192;
        int r54 = MultiLinkEnlargeSelectEnlargePositionDialog.E;
        Intrinsics.checkNotNullParameter(r20, "context");
        Intrinsics.checkNotNullParameter(r17, "targetUserId");
        MultiLinkEnlargeSelectEnlargePositionDialog r55 = new MultiLinkEnlargeSelectEnlargePositionDialog(r20);
        r55.B = r18;
        r55.C = r17;
        if (DialogLancet.shouldBlockDialogShow(r55) == false) goto L320;
        DialogLancet.handleBlockedDialogShow(r55);
    L232:
        if (CPositionContext.a.b(CPositionContext.Companion) == false) goto L359;
        m r56 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r56 == null) goto L240;
        IRoom r57 = (IRoom) r56.getValue();
        if (r57 == null) goto L240;
        if (r57.isLiveTypeAudio() != true) goto L240;
        com.bytedance.android.livesdk.sharedpref.e r58 = com.bytedance.android.livesdk.sharedpref.c.d;
        MultiLinkEnlargeTipsConfig r59 = (MultiLinkEnlargeTipsConfig) r58.getValue();
        r59.setHasClicked(true);
        f.d(r58, r59);
        return;
    L240:
        com.bytedance.android.livesdk.sharedpref.e r60 = com.bytedance.android.livesdk.sharedpref.c.c;
        MultiLinkEnlargeTipsConfig r61 = (MultiLinkEnlargeTipsConfig) r60.getValue();
        r61.setHasClicked(true);
        f.d(r60, r61);
        return;
    L359:
        return;
    L320:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L318
    L190:
        DialogLancet.beforeDialogShow(r55);
        r55.show();
        DialogLancet.afterDialogShow(r55);
        goto L232
    L192:
        if (r52.size() != 1) goto L232;
        Integer r62 = je0.d.h();
        if (r62 != null) goto L197;
    L198:
        Integer r63 = je0.d.h();
        if (r63 != null) goto L202;
    L204:
        int r65 = ((ILinkPlayerInfoBridge) ListProtector.get(r52, 0)).getUserPosition();
        CPositionToEnlargePosition r66 = CPositionToEnlargePosition.Left;
        if (r65 != ((int) r66.getValue())) goto L207;
        long r67 = CPositionToEnlargePosition.Right.getValue();
    L209:
        if (je0.d.D() == false) goto L220;
        rj0.k.m2.getClass();
        if (rj0.k.a.a() == null) goto L215;
        rj0.k r68 = rj0.k.a.a();
        if (r68 == null) goto L232;
        rj0.k.b.g(r68, r18, r17, r67, "add");
        goto L232
    L215:
        com.bytedance.android.live.liveinteract.voicechat.d.s0.getClass();
        if (com.bytedance.android.live.liveinteract.voicechat.d.a.a() == null) goto L232;
        com.bytedance.android.live.liveinteract.voicechat.d r69 = com.bytedance.android.live.liveinteract.voicechat.d.a.a();
        if (r69 == null) goto L232;
        r69.updateMultiEnlargePosition(r18, r17, r67, "add");
        goto L232
    L220:
        com.bytedance.android.live.liveinteract.plantform.base.k.n0.getClass();
        if (com.bytedance.android.live.liveinteract.plantform.base.k.a.a() == null) goto L225;
        com.bytedance.android.live.liveinteract.plantform.base.k r70 = com.bytedance.android.live.liveinteract.plantform.base.k.a.a();
        if (r70 == null) goto L232;
        r70.updateMultiEnlargePosition(r18, r17, r67, "add");
        goto L232
    L225:
        IVoiceChatAdminService.Companion.getClass();
        if (IVoiceChatAdminService.a.a() == null) goto L232;
        IVoiceChatAdminService r71 = IVoiceChatAdminService.a.a();
        if (r71 == null) goto L232;
        r71.updateMultiEnlargePosition(r18, r17, r67, "add");
        goto L232
    L207:
        r67 = r66.getValue();
        goto L209
    L202:
        if (r63.intValue() != 28) goto L204;
    L230:
        int r72 = MultiLinkEnlargeOperateDialog.D;
        a(MultiLinkEnlargeOperateDialog.a.a(r20, r18, r17));
        return;
    L197:
        if (r62.intValue() == 26) goto L230;
    L183:
        r52 = new ArrayList();
        goto L185
    L357:
        return;
    L166:
        if (r9.intValue() != r48) goto L168;
        int r73 = MultiLinkEnlargeOperateDialog.D;
        a(MultiLinkEnlargeOperateDialog.a.a(r20, r18, r17));
        return;
    L139:
        if (r9.intValue() != r47) goto L162;
        if (je0.d.D() == false) goto L152;
        rj0.k.m2.getClass();
        if (rj0.k.a.a() == null) goto L147;
        rj0.k r74 = rj0.k.a.a();
        if (r74 == null) goto L346;
        rj0.k.b.b(r74, r18, r17, true, "add");
        return;
    L346:
        return;
    L147:
        com.bytedance.android.live.liveinteract.voicechat.d.s0.getClass();
        if (com.bytedance.android.live.liveinteract.voicechat.d.a.a() == null) goto L348;
        com.bytedance.android.live.liveinteract.voicechat.d r75 = com.bytedance.android.live.liveinteract.voicechat.d.a.a();
        if (r75 == null) goto L349;
        r75.setCPosition(r18, r17, true, "add");
        return;
    L349:
        return;
    L348:
        return;
    L152:
        com.bytedance.android.live.liveinteract.plantform.base.k.n0.getClass();
        if (com.bytedance.android.live.liveinteract.plantform.base.k.a.a() == null) goto L157;
        com.bytedance.android.live.liveinteract.plantform.base.k r76 = com.bytedance.android.live.liveinteract.plantform.base.k.a.a();
        if (r76 == null) goto L351;
        r76.setCPosition(r18, r17, true, "add");
        return;
    L351:
        return;
    L157:
        IVoiceChatAdminService.Companion.getClass();
        if (IVoiceChatAdminService.a.a() == null) goto L353;
        IVoiceChatAdminService r77 = IVoiceChatAdminService.a.a();
        if (r77 == null) goto L354;
        r77.setCPosition(r18, r17, true, "add");
        return;
    L354:
        return;
    L353:
        return;
    L241:
        CPositionContext.a r78 = CPositionContext.Companion;
        CPositionContext r79 = r78.getContext();
        if (r79 == null) goto L248;
        m<EnlargeGuestInfo> r80 = r79.getEnlargeGuestInfo();
        if (r80 == null) goto L248;
        EnlargeGuestInfo r81 = (EnlargeGuestInfo) r80.getValue();
        if (r81 == null) goto L248;
        r9 = Integer.valueOf(r81.getEnlargeGuestType());
    L248:
        int r82 = EnlargeGuestInfo.EnlargeGuestType.EnlargeGuestType_Unkown.ordinal();
        if (r9 != null) goto L252;
    L254:
        int r83 = EnlargeGuestInfo.EnlargeGuestType.EnlargeGuestType_Single.ordinal();
        if (r9 != null) goto L258;
    L281:
        int r84 = EnlargeGuestInfo.EnlargeGuestType.EnlargeGuestType_Double.ordinal();
        if (r9 != null) goto L285;
        return;
    L285:
        if (r9.intValue() != r84) goto L372;
        int r85 = r78.e().size();
        if (r85 == 1) goto L296;
        if (r85 != 2) goto L387;
        int r86 = MultiLinkEnlargeCancelOperateDialog.F;
        Intrinsics.checkNotNullParameter(r20, "context");
        Intrinsics.checkNotNullParameter(r17, "targetUserId");
        MultiLinkEnlargeCancelOperateDialog r87 = new MultiLinkEnlargeCancelOperateDialog(r20);
        r87.B = r18;
        r87.C = r17;
        r87.E = r21;
        if (DialogLancet.shouldBlockDialogShow(r87) == false) goto L322;
        DialogLancet.handleBlockedDialogShow(r87);
        return;
    L322:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L319
    L294:
        DialogLancet.beforeDialogShow(r87);
        r87.show();
        DialogLancet.afterDialogShow(r87);
        return;
    L387:
        return;
    L296:
        if (je0.d.D() == false) goto L307;
        rj0.k.m2.getClass();
        if (rj0.k.a.a() == null) goto L302;
        rj0.k r88 = rj0.k.a.a();
        if (r88 == null) goto L375;
        rj0.k.b.b(r88, r18, r17, false, "cancel");
        return;
    L375:
        return;
    L302:
        com.bytedance.android.live.liveinteract.voicechat.d.s0.getClass();
        if (com.bytedance.android.live.liveinteract.voicechat.d.a.a() == null) goto L377;
        com.bytedance.android.live.liveinteract.voicechat.d r89 = com.bytedance.android.live.liveinteract.voicechat.d.a.a();
        if (r89 == null) goto L378;
        r89.setCPosition(r18, r17, false, "cancel");
        return;
    L378:
        return;
    L377:
        return;
    L307:
        com.bytedance.android.live.liveinteract.plantform.base.k.n0.getClass();
        if (com.bytedance.android.live.liveinteract.plantform.base.k.a.a() == null) goto L312;
        com.bytedance.android.live.liveinteract.plantform.base.k r90 = com.bytedance.android.live.liveinteract.plantform.base.k.a.a();
        if (r90 == null) goto L380;
        r90.setCPosition(r18, r17, false, "cancel");
        return;
    L380:
        return;
    L312:
        IVoiceChatAdminService.Companion.getClass();
        if (IVoiceChatAdminService.a.a() == null) goto L382;
        IVoiceChatAdminService r91 = IVoiceChatAdminService.a.a();
        if (r91 == null) goto L383;
        r91.setCPosition(r18, r17, false, "cancel");
        return;
    L383:
        return;
    L382:
        return;
    L372:
        return;
    L258:
        if (r9.intValue() != r83) goto L281;
        if (je0.d.D() == false) goto L271;
        rj0.k.m2.getClass();
        if (rj0.k.a.a() == null) goto L266;
        rj0.k r92 = rj0.k.a.a();
        if (r92 == null) goto L362;
        rj0.k.b.b(r92, r18, r17, false, "cancel");
        return;
    L362:
        return;
    L266:
        com.bytedance.android.live.liveinteract.voicechat.d.s0.getClass();
        if (com.bytedance.android.live.liveinteract.voicechat.d.a.a() == null) goto L364;
        com.bytedance.android.live.liveinteract.voicechat.d r93 = com.bytedance.android.live.liveinteract.voicechat.d.a.a();
        if (r93 == null) goto L365;
        r93.setCPosition(r18, r17, false, "cancel");
        return;
    L365:
        return;
    L364:
        return;
    L271:
        com.bytedance.android.live.liveinteract.plantform.base.k.n0.getClass();
        if (com.bytedance.android.live.liveinteract.plantform.base.k.a.a() == null) goto L276;
        com.bytedance.android.live.liveinteract.plantform.base.k r94 = com.bytedance.android.live.liveinteract.plantform.base.k.a.a();
        if (r94 == null) goto L367;
        r94.setCPosition(r18, r17, false, "cancel");
        return;
    L367:
        return;
    L276:
        IVoiceChatAdminService.Companion.getClass();
        if (IVoiceChatAdminService.a.a() == null) goto L369;
        IVoiceChatAdminService r95 = IVoiceChatAdminService.a.a();
        if (r95 == null) goto L370;
        r95.setCPosition(r18, r17, false, "cancel");
        return;
    L370:
        return;
    L369:
        return;
    L252:
        if (r9.intValue() != r82) goto L254;
        return;
    L72:
        if (r33.intValue() != 8) goto L74;
        r34 = CPositionContext.Companion.c();
    L68:
        r33 = null;
        goto L69
    L58:
        if (r28.intValue() != 28) goto L60;
        r29 = "avatar";
    L46:
        r27 = null;
        goto L48
    L40:
        r24 = "admin";
        goto L41
    L36:
        r113 = "cancel_enlarge";
        goto L37
    }
}
