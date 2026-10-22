package com.bytedance.android.livesdk.interactivity.pin.business.qa;

import com.bytedance.android.live.base.model.message.c5;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.base.model.user.IUser;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.base.model.user.n0;
import com.bytedance.android.live.network.response.BaseResponse;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.model.ChatResult;
import com.bytedance.android.livesdk.chatroom.model.v0;
import com.bytedance.android.livesdk.message.model.e2;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.message.CommonMessageData;
import com.bytedance.android.livesdkapi.message.MessageIdentity;
import com.bytedance.android.livesdkapi.message.PublicAreaCommon;
import com.bytedance.android.livesdkapi.message.Text;
import com.bytedance.common.utility.collection.CollectionUtils;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.m;
import io.reactivex.functions.Consumer;
import java.util.Iterator;
import jc1.k;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class h<T> implements Consumer {
    public final /* synthetic */ PinAnswerProcessor a;
    public final /* synthetic */ String b;
    public final /* synthetic */ long c;
    public final /* synthetic */ j42.b d;
    public final /* synthetic */ String e;
    public final /* synthetic */ Long f;

    public h(PinAnswerProcessor r1, String r2, long r3, j42.b r5, String r6, Long r7) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r5;
        this.e = r6;
        this.f = r7;
    }

    public final void accept(Object r18) {
        ChatResult r1 = (v0) ((BaseResponse) ((Response) r18)).data;
        if (r1 != null) goto L5;
    L67:
        o32.a.a("send answer comment failed before " + this.b);
        return;
    L5:
        if ((r1 instanceof ChatResult) == false) goto L67;
        o32.a.a("send answer comment success before " + this.b);
        int r2 = com.bytedance.android.livesdk.interactivity.common.utils.g.a;
        long r3 = this.c;
        ChatResult r4 = r1;
        g42.c r5 = this.a.b;
        if (r5 == null) goto L9;
        DataCenter r6 = r5.getDataCenter();
    L10:
        Intrinsics.checkNotNullParameter(r4, "result");
        if (r6 == null) goto L66;
        RoomContext r7 = RoomContext.a.c(RoomContext.Companion, r6, 0, 2);
        if (r7 == null) goto L66;
        m r8 = r7.getRoom();
        if (r8 == null) goto L66;
        Room r9 = (Room) r8.getValue();
        if (r9 == null) goto L66;
        com.bytedance.android.livesdk.user.f r10 = k.n(IUserService.class).user();
        long r11 = r9.id;
        User r13 = r4.getUser();
        IUser r14 = r10.b();
        e2 r15 = new e2();
        r15.setChatId(r4.getMsgId());
        CommonMessageData r16 = new CommonMessageData();
        r16.roomId = r11;
        r16.messageId = r4.getMsgId();
        r16.showMsg = true;
        Text r17 = r4.getDisplayText();
        if (r17 == null) goto L23;
        r16.setDisplayText(r17);
    L23:
        MessageType r19 = MessageType.CHAT;
        r16.method = r19.getWsMethod();
        r15.setBaseMessage(r16);
        r15.setMessageMethod(r19.getWsMethod());
        r15.publicAreaCommon = new PublicAreaCommon();
        if (r17 != null) goto L26;
    L44:
        IBaseUser r20 = null;
    L45:
        r15.setBackground(r4.getBackground());
        r15.setContent(r4.getContent());
        r15.setFullScreenTextColor(r4.getFullScreenTextColor());
        if (r20 == null) goto L48;
        r15.setUserInfo((User) r20);
    L51:
        MessageIdentity r21 = new MessageIdentity();
        r21.setShowIdentity(r4.getShowIdentity());
        r21.setIdentityLabel(r4.getIdentityLabel());
        r15.setMessageIdentity(r21);
        r15.setMsgId(String.valueOf(r4.getMsgId()));
        r15.isSelfSendFake = true;
        if (r4.getLandscapeAreaCommon() == null) goto L54;
        ChatResult.LandscapeAreaCommon r23 = r4.getLandscapeAreaCommon();
        Intrinsics.checkNotNull(r23);
        r15.landscapeAreaCommon = r23.toCommon();
    L54:
        r15.setHttpSendTime(r3);
        RoomContext.a r24 = RoomContext.Companion;
        RoomContext r25 = RoomContext.a.c(r24, r6, 0, 2);
        if (r25 == null) goto L66;
        boolean r26 = r25.isVSFirstShow();
        int r27 = com.bytedance.android.livesdk.interactivity.common.utils.g.a;
        if (r26 == false) goto L65;
        com.bytedance.android.livesdk.interactivity.common.utils.g.b(r15, r6);
        o32.a.a("insert seek time message manager");
        RoomContext r28 = RoomContext.a.c(r24, r6, 0, 2);
        if (r28 == null) goto L66;
        vlc.d r29 = (vlc.d) r28.getSeekMessageManager().getValue();
        if (r29 == null) goto L66;
        r29.j(r15, true);
        goto L66
    L65:
        com.bytedance.android.livesdk.interactivity.common.utils.g.b(r15, r6);
        goto L66
    L48:
        if (r13 == null) goto L50;
        r15.setUserInfo(r13);
        goto L51
    L50:
        User.Companion.getClass();
        r15.setUserInfo(User.a.a(r14));
        goto L51
    L26:
        if (CollectionUtils.isEmpty(r17.getPieces()) == true) goto L44;
        Iterator r30 = r17.getPieces().iterator();
    L29:
        if (r30.hasNext() == false) goto L44;
        c5 r110 = (c5) r30.next();
        if (r110.getUserValue() == null) goto L29;
        if (r110.getUserValue().getUser() == null) goto L29;
        IBaseUser r111 = r110.getUserValue().getUser();
        String r112 = r14.getIdString();
        if (r111 != null) goto L37;
    L41:
        boolean r113 = false;
    L42:
        if (r113 == false) goto L29;
        r20 = r110.getUserValue().getUser();
        goto L45
    L37:
        if (n0.b(r112) == false) goto L41;
        if (n0.a(r111.getIdString(), r112) == false) goto L41;
        r113 = true;
    L66:
        j42.b r31 = this.d;
        k42.b.a(new j42.d(new j42.c(r31.a, r31.d, r31.c, r31.b, r4.getMsgId(), this.e, this.f)));
        return;
    L9:
        r6 = null;
        goto L10
    }
}
