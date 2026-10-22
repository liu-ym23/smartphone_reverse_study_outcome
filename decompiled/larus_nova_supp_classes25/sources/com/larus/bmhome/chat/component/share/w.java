package com.larus.bmhome.chat.component.share;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwnerKt;
import com.larus.bmhome.chat.component.collection.o;
import com.larus.bmhome.chat.component.list.u7;
import com.larus.bmhome.chat.model.MessageShareViewModel;
import com.larus.bmhome.chat.trace.ChatControlTrace;
import com.larus.bmhome.share.api.IShareService;
import com.larus.bmhome.share.api.ShareServiceDelegate;
import com.larus.bmhome.share.network.LarkMetaIdentity;
import com.larus.bmhome.share.network.SaveMessageShareInfo;
import com.larus.bmhome.share.panel.b;
import com.larus.im.bean.bot.BotIconImage;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.bot.ShareInfo;
import com.larus.im.bean.message.Message;
import com.larus.network.bean.BizResponse;
import com.larus.utils.logger.FLogger;
import ic8.n;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import org.json.JSONObject;
import wc9.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class w implements Function1 {
    public final /* synthetic */ ChatShareBottomComponent a;

    public /* synthetic */ w(ChatShareBottomComponent r1) {
        this.a = r1;
    }

    public final Object invoke(Object r47) {
        final ChatShareBottomComponent r7 = this.a;
        Pair r1 = (Pair) r47;
        int r2 = ChatShareBottomComponent.R;
        final BizResponse r8 = (BizResponse) r1.getFirst();
        final jr9.a r9 = (jr9.a) r1.getSecond();
        final FragmentActivity r11 = s1a.a.c(r7).getContext();
        if (r9 == null) goto L5;
        String r3 = r9.b();
    L7:
        if (Intrinsics.areEqual(r3, "wechat") == true) goto L9;
    L25:
        if (r9 == null) goto L28;
        String r4 = r9.c();
    L27:
        String r13 = r4;
    L30:
        if (r8.isSuccess() == false) goto L138;
        if (r9 == null) goto L138;
        if (r11 == null) goto L138;
        SaveMessageShareInfo r5 = (SaveMessageShareInfo) r8.getData();
        if (r5 == null) goto L36;
        String r6 = r5.getShareUrl();
    L38:
        if (com.larus.utils.o0.d(r6) == false) goto L138;
        if (Intrinsics.areEqual(r9.b(), "save_image") == false) goto L42;
    L115:
        final String r10 = r13;
        u7 r12 = r7.Z3();
        if (r12 == null) goto L118;
        r12.showLoading();
    L118:
        MessageShareViewModel r14 = r7.e4();
        SaveMessageShareInfo r15 = (SaveMessageShareInfo) r8.getData();
        if (r15 == null) goto L121;
        String r16 = r15.getQrCodeUrl();
    L122:
        BotModel r17 = r7.E3();
        if (r17 == null) goto L127;
        ShareInfo r18 = r17.getShareInfo();
        if (r18 == null) goto L127;
        String r19 = r18.getQrCodeUrl();
    L128:
        String r21 = r10;
        Object r0 = "ccm_share";
        r14.shareMessageWithPic(r11, r16, r19, r7.h(), r7.W3(), (Function2) r7.I.getValue(), Intrinsics.areEqual(r10, "mini_app"), new x(r11, r9, r10, r8, r7));
    L129:
        boolean r110 = false;
    L131:
        if (Intrinsics.areEqual(r9.b(), r0) == true) goto L137;
        ShareServiceDelegate r20 = ShareServiceDelegate.b;
        String r22 = r9.b();
        SaveMessageShareInfo r23 = (SaveMessageShareInfo) r8.getData();
        if (r23 == null) goto L135;
        String r111 = r23.getShareId();
    L136:
        r20.d(r22, r21, r111, "1");
        goto L137
    L135:
        r111 = null;
    L137:
        boolean r24 = r110;
    L143:
        if (r24 == false) goto L151;
        DialogFragment r25 = r7.p;
        if (r25 == null) goto L147;
        ChatShareBottomComponent.Y2(r25);
    L147:
        r7.e4().exitSelectMode();
        u7 r26 = r7.Z3();
        if (r26 == null) goto L151;
        r26.dismissLoading();
    L151:
        return Unit.INSTANCE;
    L127:
        r19 = null;
        goto L128
    L121:
        r16 = null;
        goto L122
    L42:
        if (Intrinsics.areEqual(r13, "mini_app") == true) goto L115;
        if (Intrinsics.areEqual(r9.b(), "collect") == false) goto L57;
        Message r27 = r7.O;
        ChatControlTrace r28 = ChatControlTrace.b;
        JSONObject r29 = r28.Ua(r27, null);
        if (r29 != null) goto L49;
        r29 = new JSONObject();
    L49:
        r29.put("message_id_list", r7.d4());
        r29.put("is_general_agent", r7.c4());
        if (r27 == null) goto L52;
        r29.put("agent_id", r28.tb(r27));
        r29.put("trigger_message_id", r27.getMessageId());
    L52:
        o r112 = (o) r7.E.getValue();
        if (r112 == null) goto L114;
        r112.i50("share_panel", null, r7.e4().getSortMessages(), 2, r29, new y(r11, r7));
    L114:
        r21 = r13;
        r0 = "ccm_share";
        r110 = true;
        goto L131
    L57:
        if (Intrinsics.areEqual(r9.b(), "share_long_pic") == false) goto L60;
        r7.p4(r11, (SaveMessageShareInfo) r8.getData());
    L102:
        r0 = "ccm_share";
        r21 = r13;
        goto L129
    L60:
        if (Intrinsics.areEqual(r9.b(), "ccm_share") == false) goto L103;
        SaveMessageShareInfo r30 = (SaveMessageShareInfo) r8.getData();
        if ((r11 instanceof FragmentActivity) == false) goto L64;
        FragmentActivity r113 = r11;
    L65:
        if (r113 != null) goto L67;
        Intrinsics.checkNotNullParameter(r7, "<this>");
        r113 = com.larus.ui.arch.component.internal.attach.a.b(r7, r7).getActivity();
    L67:
        if (r30 == null) goto L69;
        LarkMetaIdentity r114 = r30.getLarkMetaIdentity();
    L70:
        if (r113 == null) goto L83;
        if (r30 != null) goto L73;
    L75:
        boolean r31 = false;
    L76:
        if (r31 == false) goto L83;
        if (r114 == null) goto L83;
        u7 r32 = r7.Z3();
        if (r32 == null) goto L82;
        r32.showLoading();
    L82:
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r7), null, null, new ChatShareBottomComponent$showCcmSharePanelForSelectedMessages$1(r114, r7, r30, r113, null), 3, null);
        goto L102
    L73:
        if (r30.isCcmSharePanelAvailable() != true) goto L75;
        r31 = true;
    L83:
        FLogger r33 = FLogger.a;
        StringBuilder r34 = new StringBuilder("ccm share panel unavailable, permissionType=");
        if (r30 == null) goto L86;
        Integer r115 = r30.getSharePermissionType();
    L87:
        r34.append(r115);
        r34.append(", hasIdentity=");
        if (r114 == null) goto L90;
        boolean r116 = true;
    L91:
        r34.append(r116);
        r34.append(", hasActivity=");
        if (r113 == null) goto L94;
        boolean r117 = true;
    L95:
        r34.append(r117);
        r33.w("ChatShareBottomComponent", r34.toString());
        t19.s r35 = t19.s.a;
        Intrinsics.checkNotNullParameter(r7, "<this>");
        r35.g(com.larus.ui.arch.component.internal.attach.a.b(r7, r7).getContext(), 2131900870, false);
        u7 r36 = r7.Z3();
        if (r36 == null) goto L98;
        r36.dismissLoading();
    L98:
        if (r30 == null) goto L100;
        String r37 = r30.getShareId();
    L101:
        ShareServiceDelegate.b.d("ccm_share", "url", r37, "0");
        goto L102
    L100:
        r37 = null;
        goto L101
    L94:
        r117 = false;
        goto L95
    L90:
        r116 = false;
        goto L91
    L86:
        r115 = null;
        goto L87
    L69:
        r114 = null;
        goto L70
    L64:
        r113 = null;
        goto L65
    L103:
        SaveMessageShareInfo r38 = (SaveMessageShareInfo) r8.getData();
        if (r38 == null) goto L106;
        String r210 = r38.getShareUrl();
    L107:
        ShareServiceDelegate r39 = ShareServiceDelegate.b;
        Intrinsics.checkNotNullParameter(r7, "<this>");
        String r211 = r39.p(com.larus.ui.arch.component.internal.attach.a.b(r7, r7).getContext(), r7.E3());
        Intrinsics.checkNotNullParameter(r7, "<this>");
        String r212 = com.larus.ui.arch.component.internal.attach.a.b(r7, r7).getString(2131909359);
        BotModel r40 = r7.E3();
        if (r40 == null) goto L112;
        BotIconImage r41 = r40.getIconImage();
        if (r41 == null) goto L112;
        String r213 = r41.getOriginUrl();
    L113:
        IShareService.a.d(r39, r11, r9.b(), r13, new b(null, null, r210, r213, null, null, null, r211, r212, null, null, null, null, null, null, null, false, false, null, null, false, false, null, false, null, null, 67108467), null, 48);
    L112:
        r213 = null;
        goto L113
    L106:
        r210 = null;
        goto L107
    L36:
        r6 = null;
    L138:
        String r42 = r13;
        t19.s r43 = t19.s.a;
        Intrinsics.checkNotNullParameter(r7, "<this>");
        r43.g(com.larus.ui.arch.component.internal.attach.a.b(r7, r7).getContext(), 2131900870, false);
        ShareServiceDelegate r44 = ShareServiceDelegate.b;
        if (r9 == null) goto L141;
        String r118 = r9.b();
        String r45 = null;
    L142:
        r44.d(r118, r42, r45, "0");
        r24 = true;
        goto L143
    L141:
        r45 = null;
        r118 = null;
        goto L142
    L28:
        r13 = null;
        goto L30
    L9:
        if (Intrinsics.areEqual(r9.c(), "mini_app") == false) goto L25;
        e r46 = r7.h();
        if (r46 != null) goto L13;
    L15:
        boolean r48 = false;
    L16:
        if (r48 == false) goto L25;
        e r49 = r7.h();
        if (r49 != null) goto L20;
    L22:
        boolean r50 = false;
    L23:
        if (r50 == false) goto L25;
        r4 = "url";
        goto L27
    L20:
        if (n.D(r49) == true) goto L22;
        r50 = true;
        goto L23
    L13:
        if (n.u(r46) == true) goto L15;
        r48 = true;
        goto L16
    L5:
        r3 = null;
        goto L7
    }
}
