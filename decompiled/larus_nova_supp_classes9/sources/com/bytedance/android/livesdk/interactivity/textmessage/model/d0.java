package com.bytedance.android.livesdk.interactivity.textmessage.model;

import android.text.Spannable;
import android.text.TextUtils;
import android.view.View;
import com.bytedance.android.live.base.model.message.PieceType;
import com.bytedance.android.live.base.model.message.a5;
import com.bytedance.android.live.base.model.message.c4;
import com.bytedance.android.live.base.model.message.c5;
import com.bytedance.android.live.base.model.message.q3;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.room.api.report.ReportObject;
import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.bytedance.android.livesdk.config.bl0;
import com.bytedance.android.livesdk.interactivity.api.entity.DisplayTimeRecorder;
import com.bytedance.android.livesdk.interactivity.api.entity.SpannableType;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.PublicScreenABHelper;
import com.bytedance.android.livesdk.interactivity.textmessage.utils.MessageDisplayAppLogger;
import com.bytedance.android.livesdk.interactivity.textmessage.utils.PSInteractionMsgClickUtil;
import com.bytedance.android.livesdk.interactivity.textmessage.viewholder.TextMessageRenderViewHolder;
import com.bytedance.android.livesdk.user.LiveFollowScene;
import com.bytedance.android.livesdkapi.depend.live.MessageSceneType;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.message.IRoomMessageExtra;
import com.bytedance.android.livesdkapi.message.IRoomMessageGiftExtra;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import zg1.h1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class d0 extends com.bytedance.android.livesdk.interactivity.api.entity.f<c4> implements o {
    public final String G;

    public class a implements DisplayTimeRecorder.a {
        public final /* synthetic */ d0 a;

        public a(d0 r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.livesdk.interactivity.api.entity.DisplayTimeRecorder.a
        public final void a(int r7) {
            if (r7 == 1) goto L5;
            return;
        L5:
            long r0 = this.a.o();
            d0 r8 = this.a;
            MessageDisplayAppLogger.e(r0, "hit_paid_relationship_gointo_overtime", BuildConfig.FLAVOR, r8.e, r8.b.getBuriedPoint());
        }

        @Override // com.bytedance.android.livesdk.interactivity.api.entity.DisplayTimeRecorder.a
        public final void b(DisplayTimeRecorder.b r7) {
            MessageDisplayAppLogger.d(this.a.o(), r7.b - r7.a);
        }
    }

    public class b implements DisplayTimeRecorder.a {
        public final /* synthetic */ d0 a;

        @Override // com.bytedance.android.livesdk.interactivity.api.entity.DisplayTimeRecorder.a
        public final void b(DisplayTimeRecorder.b r1) {
        }

        public b(d0 r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.livesdk.interactivity.api.entity.DisplayTimeRecorder.a
        public final void a(int r7) {
            if (r7 == 1) goto L5;
            return;
        L5:
            long r0 = this.a.o();
            d0 r8 = this.a;
            MessageDisplayAppLogger.e(r0, "ticket_purchase", BuildConfig.FLAVOR, r8.e, r8.b.getBuriedPoint());
        }
    }

    public class c implements DisplayTimeRecorder.a {
        public final /* synthetic */ d0 a;

        @Override // com.bytedance.android.livesdk.interactivity.api.entity.DisplayTimeRecorder.a
        public final void b(DisplayTimeRecorder.b r1) {
        }

        public c(d0 r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.livesdk.interactivity.api.entity.DisplayTimeRecorder.a
        public final void a(int r7) {
            if (r7 == 1) goto L6;
            return;
        L6:
            if (TextUtils.isEmpty(this.a.f) == false) goto L8;
        L10:
            String r8 = BuildConfig.FLAVOR;
        L11:
            String r3 = r8;
            String r2 = this.a.b.getBizScene();
            if (r2 != null) goto L14;
        L16:
            c4 r9 = this.a.b;
            int r0 = com.bytedance.android.livesdk.interactivity.textmessage.utils.j.a;
            if (r9 != null) goto L19;
            boolean r10 = false;
        L20:
            if (r10 == false) goto L23;
            MessageDisplayAppLogger.a(this.a.b);
        L23:
            if (TextUtils.equals(this.a.b.getBizScene(), "mirco_game_open") == false) goto L26;
            xs2.b.a().post(new com.bytedance.android.livesdk.event.s("show"));
            return;
        L26:
            return;
        L19:
            r10 = TextUtils.equals(r9.getBizScene(), "aggregate_msg");
            goto L20
        L14:
            if (TextUtils.isEmpty(r2) == true) goto L16;
            long r1 = this.a.o();
            d0 r11 = this.a;
            MessageDisplayAppLogger.e(r1, r2, r3, r11.e, r11.b.getBuriedPoint());
            goto L16
        L8:
            if ("0".equals(this.a.f) == true) goto L10;
            r8 = this.a.f;
            goto L11
        }
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.entity.f
    public final Boolean B() {
        return Boolean.valueOf(this.b.getSystemTopMsg());
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.entity.f
    public final DisplayTimeRecorder I() {
        if (this.b.getRoomMessageType() != 2) goto L7;
        return new DisplayTimeRecorder(this.b, new a(this));
    L7:
        if (this.b.getRoomMessageType() != 6) goto L11;
        return new DisplayTimeRecorder(this.b, new b(this));
    L11:
        if (TextUtils.isEmpty(this.b.getBizScene()) == false) goto L13;
        return null;
    L13:
        return new DisplayTimeRecorder(this.b, new c(this));
    }

    public final int K() {
        if (TextUtils.equals(this.b.getBizScene(), "mirco_game_open") == false) goto L7;
        return i0.a(2131107887);
    L7:
        if ("VS".equals(this.G) == true) goto L9;
        int r0 = com.bytedance.android.livesdk.interactivity.textmessage.utils.k.a;
        return i0.a(2131107646);
    L9:
        return i0.a(2131108544);
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.entity.f
    public final Spannable f() {
        c4 r0 = this.b;
        IBaseUser r1 = null;
        if (r0 != null) goto L5;
    L31:
        c4 r2 = this.b;
        if (r2 != null) goto L34;
    L41:
        String r3 = this.b.getContent();
        SpannableType r4 = SpannableType.NORMAL;
        return i0.b(r3, K());
    L34:
        if (TextUtils.equals(r2.getBizScene(), "mirco_game_open") == false) goto L41;
        if (this.b.getBaseMessage() == null) goto L38;
        IBaseUser r5 = this.b.getBaseMessage().getUser();
    L40:
        return i0.d(r5, this.b.getContent(), com.bytedance.android.livesdk.interactivity.textmessage.utils.h.b(SpannableType.GAME, true, this.i), K(), null);
    L38:
        r5 = null;
        goto L40
    L5:
        if (r0.isGiftTypeMessage() == false) goto L31;
        if (((Boolean) PublicScreenABHelper.B.getValue()).booleanValue() == false) goto L31;
        c4 r6 = this.b;
        int r7 = com.bytedance.android.livesdk.interactivity.textmessage.utils.h.a;
        if (r6 == null) goto L17;
        IRoomMessageExtra r8 = r6.getRoomMessageExtra();
        if (r8 == null) goto L17;
        IRoomMessageGiftExtra r9 = r8.getGiftExtra();
        if (r9 == null) goto L17;
        String r10 = r9.getDescribe();
        if (r10 == null) goto L17;
    L19:
        if (r10.isEmpty() == true) goto L24;
        String[] r11 = r10.split(":");
        if (r11.length <= 1) goto L24;
        r10 = r11[1];
    L24:
        if (TextUtils.isEmpty(r10) == true) goto L26;
        r10 = r10 + " ";
    L26:
        String r13 = r10;
        if (this.b.getBaseMessage() == null) goto L29;
        r1 = this.b.getBaseMessage().getUser();
    L29:
        SpannableType r14 = SpannableType.GAME;
        return i0.c(r1, " ", r13, com.bytedance.android.livesdk.interactivity.textmessage.utils.h.b(r14, this.e, this.i), com.bytedance.android.livesdk.interactivity.textmessage.utils.h.a(r14, this.e), null);
    L17:
        r10 = BuildConfig.FLAVOR;
        goto L19
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.entity.f
    public final int k() {
        SpannableType r0 = SpannableType.NORMAL;
        return K();
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.entity.f
    public final tb2.d w() {
        tb2.d r0 = new tb2.d();
        r0.c(com.bytedance.android.livesdk.interactivity.service.textrender.utils.c.f(this.b.getContent()));
        return r0;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.entity.f
    public final IBaseUser x() {
        c4 r0 = this.b;
        IBaseUser r1 = null;
        if (r0 != null) goto L5;
        return null;
    L5:
        if (r0.getBaseMessage() != null) goto L7;
        return null;
    L7:
        if (this.b.supportDisplayText() == false) goto L38;
        a5 r2 = this.b.getBaseMessage().getDisplayText();
        if (r2 != null) goto L12;
        return null;
    L12:
        List r3 = r2.getPieces();
        if (r3.isEmpty() == false) goto L15;
        return null;
    L15:
        Iterator r4 = r3.iterator();
    L17:
        if (r4.hasNext() == false) goto L23;
        c5 r5 = (c5) r4.next();
        if (r5.getType() != PieceType.USER.getPieceType()) goto L17;
        if (r5.getUserValue() == null) goto L17;
        r1 = r5.getUserValue().getUser();
    L23:
        if (r1 == null) goto L25;
        return r1;
    L25:
        if (this.b.getBaseMessage() != null) goto L27;
        return r1;
    L27:
        return this.b.getBaseMessage().getUser();
    L38:
        return null;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.entity.f
    public final boolean z() {
        return this.b.getForcedGuarantee();
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.entity.f
    public final boolean E(g52.c r7) {
        Lazy r0 = PSInteractionMsgClickUtil.a;
        boolean r1 = this.e;
        c4 r2 = this.b;
        if (r2 != null) goto L5;
        boolean r3 = false;
    L7:
        if (r3 == false) goto L20;
        if (r1 == false) goto L10;
        boolean r4 = false;
    L11:
        if (r4 == false) goto L20;
        IRoom r5 = null;
        if (r7 == null) goto L15;
        DataCenter r8 = r7.getDataCenter();
    L16:
        xs2.b r6 = xs2.b.a();
        if (r8 == null) goto L19;
        r5 = gb2.a.e(r8);
    L19:
        h1 r9 = new h1(26, r5);
        r9.f = "screen_msg_area";
        Unit r10 = Unit.INSTANCE;
        r6.post(r9);
        boolean r11 = true;
    L37:
        if (r11 == false) goto L40;
        return true;
    L40:
        if (x() != null) goto L42;
        return false;
    L42:
        b(x(), ReportObject.User, false);
        return true;
    L15:
        r8 = null;
        goto L16
    L10:
        r4 = ((Boolean) bl0.a.getValue()).booleanValue();
    L20:
        if (r2 != null) goto L22;
        boolean r13 = false;
    L23:
        if (r13 == true) goto L26;
    L36:
        r11 = false;
        goto L37
    L26:
        if (((fc2.h) PSInteractionMsgClickUtil.d.getValue()).c() == false) goto L36;
        if (r1 == true) goto L36;
        if (r2 == null) goto L36;
        if (((Boolean) PSInteractionMsgClickUtil.a.getValue()).booleanValue() == false) goto L36;
        if (PSInteractionMsgClickUtil.c(r7) == false) goto L36;
        r11 = PSInteractionMsgClickUtil.e(r2.getOrInitPublicAreaCommon().getDefaultClickSchemaUrl());
        goto L37
    L22:
        r13 = Intrinsics.areEqual(r2.getBizScene(), "send_gift");
        goto L23
    L5:
        r3 = Intrinsics.areEqual(r2.getBizScene(), "live_recommend");
        goto L7
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.entity.f
    public final void F(tb2.b r9) {
        if (this.b.isFromFirstRequest() == false) goto L13;
        if (this.b.getBuriedPoint() == null) goto L13;
        String r0 = (String) this.b.getBuriedPoint().get("history_chat_aggre_pattern");
        if ("general_similar".equals(r0) == false) goto L10;
        r42.q.a("low_quality_group");
        goto L13
    L10:
        if ("interested_ecom_goods".equals(r0) == false) goto L13;
        r42.q.a("ecom_group");
    L13:
        if (TextUtils.isEmpty(this.f) == false) goto L15;
    L17:
        String r1 = BuildConfig.FLAVOR;
    L18:
        String r4 = r1;
        String r3 = this.b.getBizScene();
        if (r3 != null) goto L21;
        return;
    L21:
        if (TextUtils.isEmpty(r3) == false) goto L23;
        return;
    L23:
        if ((r9 instanceof tb2.g) == false) goto L25;
        String r10 = "audience_name";
    L26:
        String r7 = r10;
        MessageDisplayAppLogger.c(o(), r3, r4, this.e, this.b.getBuriedPoint(), r7);
        if (TextUtils.equals(this.b.getBizScene(), "mirco_game_open") == false) goto L32;
        xs2.b.a().post(new com.bytedance.android.livesdk.event.s("click"));
        return;
    L32:
        return;
    L25:
        r10 = "others";
        goto L26
    L15:
        if ("0".equals(this.f) == true) goto L17;
        r1 = this.f;
        goto L18
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.entity.f
    public final void i(HashMap<String, String> r3) {
        r3.put("biz_scene", this.b.getBizScene());
        if (this.b.isGiftTypeMessage() == true) goto L5;
        return;
    L5:
        if (this.b.getRoomMessageExtra() != null) goto L7;
        return;
    L7:
        if (this.b.getRoomMessageExtra().getGiftExtra() == null) goto L12;
        r3.put("gift_id", this.b.getRoomMessageExtra().getGiftExtra().getGiftId().toString());
        return;
    }

    public d0(c4 r1, MessageSceneType r2) {
        super(r1, r2);
        this.G = null;
    }

    @Override // com.bytedance.android.livesdk.interactivity.textmessage.model.o
    public final boolean b(IBaseUser r1, ReportObject r2, boolean r3) {
        q3 r4 = this.b;
        if (r4 != null) goto L5;
    L7:
        c4 r5 = this.b;
        if (r5 != null) goto L10;
    L13:
        boolean r6 = true;
    L14:
        if (r6 == false) goto L16;
        J("none");
    L17:
        return true;
    L16:
        UserProfileEvent r7 = new UserProfileEvent(r1);
        r7.setExtraFollowParams(com.bytedance.android.livesdk.user.j.b(LiveFollowScene.PROFILE_PUBLIC_SCREEN));
        xs2.b.a().post(r7);
        J("default_user");
        goto L17
    L10:
        if (r5.getOrInitPublicAreaCommon().getForbidProfile() == true) goto L13;
        r6 = false;
        goto L14
    L5:
        if (r4.canPin() == false) goto L7;
        J("default");
        goto L17
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.entity.f
    public final void H(View r2, g52.c r3, TextMessageRenderViewHolder r4, WeakReference r5) {
        c4 r0 = this.b;
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L12;
        J("none");
        return;
    L12:
        super.H(r2, r3, r4, r5);
        return;
    L5:
        if (r0.getOrInitPublicAreaCommon().getForbidProfile() == true) goto L8;
        r1 = false;
        goto L9
    }
}
