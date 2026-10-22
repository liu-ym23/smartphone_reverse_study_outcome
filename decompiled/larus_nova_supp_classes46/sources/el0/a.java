package el0;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.link.ILinkServiceExternal;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.plantform.model.LinkPlayerInfo;
import com.bytedance.android.live.liveinteract.plantform.model.n;
import com.bytedance.android.live.livepkaudience.emoji.LinkPKAudienceInteractDynamicEmojiDialog;
import com.bytedance.android.live.livepkaudience.emoji.LinkPKAudienceInteractEmojiPanel;
import com.bytedance.android.live.livepkaudience.seat.PkDynamicEmojiTask;
import com.bytedance.android.live.livepkaudience.seat.PkSeatAnimationView;
import com.bytedance.android.live.pkaudience.api.IPkAudienceLinkOutService;
import com.bytedance.android.live.room.IRoomService;
import com.bytedance.android.live.ui.LinkGuestSendGiftNoAnimationView;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.bytedance.android.livesdk.chatroom.ui.DynamicEmojiView;
import com.bytedance.android.livesdk.config.ia1;
import com.bytedance.android.livesdk.config.n60;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.m;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import java.util.HashMap;
import jc1.k;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a extends FrameLayout implements h {
    public View a;
    public View b;
    public TextView c;
    public TextView d;
    public View e;
    public PkSeatAnimationView f;
    public LinkGuestSendGiftNoAnimationView g;
    public View h;
    public final DataCenter i;
    public boolean j;
    public boolean k;
    public boolean l;
    public boolean m;
    public boolean n;
    public final g o;
    public final com.bytedance.android.live.livepkaudience.seat.f p;

    /* JADX INFO: renamed from: el0.a$a, reason: collision with other inner class name */
    public interface InterfaceC0204a {
    }

    public static final class b {
    }

    public static final class c implements View.OnClickListener {
        public final /* synthetic */ a a;

        public c(a r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r7) {
            g r8 = this.a.getPresenter();
            if (r8 == null) goto L64;
            LinkPlayerInfo r9 = r8.d();
            if (r9 == null) goto L65;
            a r0 = this.a;
            r0.getClass();
            if (k.n(IRoomService.class).isRecording() == true) goto L9;
        L11:
            long r2 = 0;
            String r4 = null;
            if (wt2.a.f(Boolean.valueOf(r0.j)) == false) goto L21;
            RoomContext r1 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
            if (r1 == null) goto L21;
            m r3 = r1.getCleanMode();
            if (r3 == null) goto L21;
            if (((Number) r3.getValue()).intValue() != 2) goto L21;
            ALogger.w("LinkPKAudienceInteractWindow", "rejected guest stub click for pure clean mode");
            return;
        L21:
            if (r0.i == null) goto L73;
            g r5 = r0.o;
            if (r5 == null) goto L29;
            LinkPlayerInfo r6 = r5.d();
            if (r6 == null) goto L29;
            r2 = n.b(r6);
        L29:
            if (r0.j == true) goto L47;
            if (k.n(IUserService.class).user().c() == false) goto L36;
            if (r0.b(r9) == false) goto L47;
        L36:
            if (r0.b(r9) == false) goto L45;
            int r10 = al0.c.b;
            g r11 = r0.o;
            if (r11 == null) goto L40;
            r4 = r11.f();
        L40:
            al0.c.d("oneself", r4, r2);
            tc0.c.h().G = "seat";
            int r12 = LinkPKAudienceInteractDynamicEmojiDialog.D;
            LinkPKAudienceInteractDynamicEmojiDialog r13 = LinkPKAudienceInteractDynamicEmojiDialog.a.a(r0.getContext(), r0.i);
            if (DialogLancet.shouldBlockDialogShow(r13) == false) goto L60;
            DialogLancet.handleBlockedDialogShow(r13);
            return;
        L60:
            DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L58
        L44:
            DialogLancet.beforeDialogShow(r13);
            r13.show();
            DialogLancet.afterDialogShow(r13);
            return;
        L45:
            r0.c(r9);
            return;
        L47:
            if (r0.k == false) goto L56;
            int r14 = al0.c.b;
            g r15 = r0.o;
            if (r15 == null) goto L51;
            r4 = r15.f();
        L51:
            al0.c.d("audience", r4, r2);
            int r16 = LinkPKAudienceInteractEmojiPanel.v;
            Context r17 = r0.getContext();
            DataCenter r18 = r0.i;
            boolean r19 = r0.j;
            Intrinsics.checkNotNullParameter(r17, "context");
            Intrinsics.checkNotNullParameter(r18, "dataCenter");
            Intrinsics.checkNotNullParameter(r9, "userInfo");
            Intrinsics.checkNotNullParameter("seat", "requestPage");
            LinkPKAudienceInteractEmojiPanel r20 = new LinkPKAudienceInteractEmojiPanel(r17, r18, r9, r19);
            Intrinsics.checkNotNullParameter("seat", "<set-?>");
            r20.k = "seat";
            if (DialogLancet.shouldBlockDialogShow(r20) == false) goto L62;
            DialogLancet.handleBlockedDialogShow(r20);
            return;
        L62:
            DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L59
        L55:
            DialogLancet.beforeDialogShow(r20);
            r20.show();
            DialogLancet.afterDialogShow(r20);
            return;
        L56:
            r0.c(r9);
            return;
        L73:
            return;
        L9:
            if (k.n(IRoomService.class).isClearRecord() == false) goto L11;
            return;
        L65:
            return;
        }
    }

    public static final class d implements View.OnClickListener {
        public final /* synthetic */ a a;

        public d(a r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r8) {
            this.a.getClass();
            DataCenter r9 = this.a.i;
            Long r0 = null;
            if (r9 == null) goto L5;
            IRoom r5 = (Room) r9.get("data_room", null);
        L6:
            g r10 = this.a.getPresenter();
            if (r10 == null) goto L9;
            IBaseUser r4 = r10.e();
        L11:
            if (((Boolean) n60.a.getValue()).booleanValue() == false) goto L28;
            RoomContext r11 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
            if (r11 == null) goto L28;
            m r12 = r11.getCleanMode();
            if (r12 == null) goto L28;
            Integer r13 = (Integer) r12.getValue();
            if (r13 == null) goto L28;
            int r14 = r13.intValue();
            if (r14 == 2) goto L25;
            if (r14 == 3) goto L25;
            if (r14 == 13) goto L25;
            boolean r15 = false;
        L26:
            if (r15 != true) goto L28;
            return;
        L25:
            r15 = true;
        L28:
            HashMap r6 = new HashMap();
            IPkAudienceLinkOutService r16 = (IPkAudienceLinkOutService) k.n(IPkAudienceLinkOutService.class);
            g r1 = this.a.getPresenter();
            if (r1 == null) goto L31;
            String r2 = r1.c();
        L33:
            if (r16.isNotSelfGuestByIId(r2) == false) goto L38;
            User r17 = k.n(ILinkServiceExternal.class).getPkService().C();
            if (r17 == null) goto L37;
            r0 = Long.valueOf(r17.getLiveRoomId());
        L37:
            r6.put("opposite_room_id", String.valueOf(r0));
            r6.put("in_opposite_room", "1");
        L38:
            if (r5 == null) goto L42;
            if (r4 == null) goto L43;
            ((IInteractService) k.n(IInteractService.class)).showLynxGuestContributionRankList(this.a.getContext(), this.a.i, r4, r5, r6);
            return;
        L43:
            return;
        L42:
            return;
        L31:
            r2 = null;
            goto L33
        L9:
            r4 = null;
            goto L11
        L5:
            r5 = null;
            goto L6
        }
    }

    static {
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        g r0 = this.o;
        if (r0 == null) goto L5;
        r0.b();
    L5:
        super.onDetachedFromWindow();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        View.inflate(getContext(), 2131567144, this);
        setOnClickListener(new c(this));
        DataCenter r0 = this.i;
        int r1 = 0;
        if (r0 == null) goto L7;
        Boolean r2 = (Boolean) r0.get("data_is_anchor", Boolean.FALSE);
        if (r2 == null) goto L7;
        boolean r3 = r2.booleanValue();
    L8:
        this.j = r3;
        this.b = findViewById(2131381411);
        this.c = (TextView) findViewById(2131381483);
        this.h = findViewById(2131376422);
        this.e = findViewById(2131364125);
        this.f = (PkSeatAnimationView) findViewById(2131385655);
        this.d = (TextView) findViewById(2131374061);
        this.g = findViewById(2131381478);
        PkSeatAnimationView r4 = this.f;
        if (r4 == null) goto L24;
        View r5 = FrameLayout.inflate(r4.getContext(), 2131567610, r4);
        r4.b = r5;
        HSImageView r6 = null;
        if (r5 == null) goto L13;
        DynamicEmojiView r7 = (DynamicEmojiView) r5.findViewById(2131370473);
    L14:
        r4.c = r7;
        View r8 = r4.b;
        if (r8 == null) goto L17;
        r6 = (HSImageView) r8.findViewById(2131371535);
    L17:
        r4.d = r6;
        com.bytedance.android.live.livepkaudience.seat.g r9 = new com.bytedance.android.live.livepkaudience.seat.g();
        r4.a = r9;
        PkDynamicEmojiTask r10 = new PkDynamicEmojiTask(r9, r4.c, r4.d);
        com.bytedance.android.live.livepkaudience.seat.d r11 = r9.b;
        r11.getClass();
        Intrinsics.checkNotNullParameter(r10, "task");
        if (r11.b != null) goto L20;
        r11.b = r10;
        r11.c = r10;
        goto L24
    L20:
        com.bytedance.android.live.livepkaudience.seat.a r12 = r11.c;
        if (r12 == null) goto L23;
        r12.b(r10);
    L23:
        r11.c = r10;
        goto L24
    L13:
        r7 = null;
    L24:
        g r13 = this.o;
        if (r13 == null) goto L27;
        r13.a(this);
    L27:
        B3(true);
        PkSeatAnimationView r14 = this.f;
        if (r14 == null) goto L41;
        com.bytedance.android.live.livepkaudience.seat.f r15 = this.p;
        if (r15 == null) goto L41;
        g r16 = this.o;
        if (r16 == null) goto L39;
        LinkPlayerInfo r17 = r16.d();
        if (r17 == null) goto L39;
        IBaseUser r18 = r17.getUser();
        if (r18 == null) goto L39;
        String r19 = r18.getIdString();
        if (r19 == null) goto L39;
    L40:
        Intrinsics.checkNotNullParameter(r19, "userId");
        Intrinsics.checkNotNullParameter(r14, "view");
        r15.a.put(r19, r14);
    L39:
        r19 = "0";
    L41:
        LinkGuestSendGiftNoAnimationView r20 = this.g;
        if (r20 != null) goto L44;
    L48:
        LinkGuestSendGiftNoAnimationView r21 = this.g;
        if (r21 == null) goto L52;
        r21.setOnClickListener(new d(this));
        return;
    L52:
        return;
    L44:
        if (this.m == true) goto L47;
        r1 = 8;
    L47:
        r20.setVisibility(r1);
    L7:
        r3 = false;
        goto L8
    }

    public final boolean getMIsBackGround() {
        return this.n;
    }

    public final g getPresenter() {
        return this.o;
    }

    @Override // el0.h
    public final void B3(boolean r3) {
        g r0 = this.o;
        if (r0 == null) goto L5;
        LinkPlayerInfo r1 = r0.d();
    L6:
        boolean r2 = b(r1);
        View r4 = this.b;
        if (r4 == null) goto L15;
        if (r3 == true) goto L12;
        if (r2 == true) goto L12;
        int r5 = 0;
    L13:
        r4.setVisibility(r5);
        return;
    L12:
        r5 = 4;
        goto L13
    L15:
        return;
    L5:
        r1 = null;
        goto L6
    }

    @Override // el0.h
    public final void Qb(LinkPlayerInfo r7) {
        if (r7 == null) goto L51;
        DataCenter r0 = this.i;
        CharSequence r1 = null;
        if (r0 == null) goto L6;
        Boolean r2 = (Boolean) r0.get("data_pk_anchor_silence_status_change", Boolean.FALSE);
    L7:
        IBaseUser r3 = r7.getUser();
        if (r3 == null) goto L10;
        String r4 = r3.getRealNickName();
    L12:
        if (r4 == null) goto L14;
        int r5 = r4.length();
    L16:
        if (r5 < 10) goto L21;
        if (r4 == null) goto L19;
        r1 = r4.subSequence(0, 10);
    L19:
        r4 = Intrinsics.stringPlus((String) r1, "...");
    L21:
        if (TextUtils.isEmpty(r4) == false) goto L25;
        TextView r6 = this.c;
        if (r6 == null) goto L31;
        UtilityKotlinExtentionsKt.z(r6, false);
    L31:
        i4(r7.getFanTicketDisplayStr());
        if (Intrinsics.areEqual(r2, Boolean.TRUE) == true) goto L34;
    L38:
        int r8 = r7.silenceStatus;
        if (r8 != 3) goto L41;
    L47:
        View r9 = this.h;
        if (r9 == null) goto L56;
        UtilityKotlinExtentionsKt.z(r9, true);
        return;
    L56:
        return;
    L41:
        if (r8 == 2) goto L47;
        if (r8 == 1) goto L47;
        View r10 = this.h;
        if (r10 == null) goto L54;
        UtilityKotlinExtentionsKt.z(r10, false);
        return;
    L54:
        return;
    L34:
        if (this.k == true) goto L38;
        View r11 = this.h;
        if (r11 == null) goto L52;
        UtilityKotlinExtentionsKt.z(r11, true);
        return;
    L52:
        return;
    L25:
        TextView r12 = this.c;
        if (r12 == null) goto L28;
        UtilityKotlinExtentionsKt.z(r12, true);
    L28:
        TextView r13 = this.c;
        if (r13 == null) goto L31;
        r13.setText(r4);
        goto L31
    L14:
        r5 = 0;
        goto L16
    L10:
        r4 = null;
        goto L12
    L6:
        r2 = null;
        goto L7
    }

    public final void a(View r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        removeView(this.a);
        this.a = r3;
        ViewParent r0 = r3.getParent();
        if (r0 != null) goto L7;
    L9:
        r3.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        Unit r1 = Unit.INSTANCE;
        this.a = r3;
        addView(r3, 0);
        return;
    L7:
        if ((r0 instanceof ViewGroup) == false) goto L9;
        ((ViewGroup) r0).removeView(this.a);
        goto L9
    }

    public final boolean b(LinkPlayerInfo r2) {
        if (r2 == null) goto L6;
        IBaseUser r3 = r2.getUser();
        if (r3 == null) goto L6;
        String r4 = r3.getIdString();
    L8:
        if (Intrinsics.areEqual(r4, k.n(IUserService.class).user().b().getIdString()) == false) goto L11;
        return true;
    L11:
        return false;
    L6:
        r4 = null;
        goto L8
    }

    public final void c(LinkPlayerInfo r3) {
        Intrinsics.checkNotNullParameter(r3, "userInfo");
        IBaseUser r0 = r3.getUser();
        if (r0 == null) goto L10;
        String r1 = r0.getIdString();
        if (r1 == null) goto L11;
        UserProfileEvent r2 = new UserProfileEvent(r1);
        r2.setClickUserPosition("pk_linked_audience");
        r2.interactLogLabel = "right_anchor";
        r2.setReportSource("anchor_linkmic");
        r2.setReportType("data_card_linked_audience");
        r2.user = r3.getUser();
        DataCenter r4 = this.i;
        if (r4 == null) goto L12;
        r4.put("cmd_show_user_profile", r2);
        return;
    L12:
        return;
    L11:
        return;
    }

    public final void e(boolean r4) {
        boolean r0 = true;
        if (r4 == false) goto L7;
        View r5 = this.h;
        if (r5 == null) goto L22;
        UtilityKotlinExtentionsKt.z(r5, true);
        return;
    L22:
        return;
    L7:
        g r6 = this.o;
        if (r6 == null) goto L24;
        LinkPlayerInfo r7 = r6.d();
        if (r7 == null) goto L25;
        View r1 = this.h;
        if (r1 == null) goto L26;
        int r8 = r7.silenceStatus;
        if (r8 != 3) goto L16;
    L20:
        UtilityKotlinExtentionsKt.z(r1, r0);
        return;
    L16:
        if (r8 == 2) goto L20;
        if (r8 == 1) goto L20;
        r0 = false;
        goto L20
    L26:
        return;
    L25:
        return;
    }

    @Override // el0.h
    public final void i4(String r2) {
        LinkGuestSendGiftNoAnimationView r0 = this.g;
        if (r0 == null) goto L6;
        r0.b(r2);
        return;
    }

    public final void setDebugText(String r3) {
        Intrinsics.checkNotNullParameter(r3, "text");
        if (((Boolean) ia1.a.getValue()).booleanValue() == false) goto L11;
        TextView r0 = this.d;
        if (r0 == null) goto L7;
        r0.setVisibility(0);
    L7:
        TextView r1 = this.d;
        if (r1 == null) goto L12;
        r1.setText(r3);
        return;
    L12:
        return;
    }

    public final void setIsBackGround(boolean r1) {
        this.n = r1;
    }

    public final void setIsOpenSendGift(boolean r2) {
        this.m = r2;
        LinkGuestSendGiftNoAnimationView r0 = this.g;
        if (r0 == null) goto L9;
        if (r2 == false) goto L6;
        int r3 = 0;
    L7:
        r0.setVisibility(r3);
        return;
    L6:
        r3 = 8;
        goto L7
    }

    public final void setIsSelfRoomWindow(boolean r1) {
        this.k = r1;
    }

    public final void setMIsBackGround(boolean r1) {
        this.n = r1;
    }

    @Override // el0.h
    public void setVisibility(boolean r1) {
        if (r1 == false) goto L4;
        int r2 = 0;
    L5:
        setVisibility(r2);
        return;
    L4:
        r2 = 4;
        goto L5
    }

    public final void d(boolean r3, boolean r4) {
        this.k = r4;
        View r0 = this.e;
        if (r0 == null) goto L5;
        UtilityKotlinExtentionsKt.z(r0, true);
    L5:
        int r1 = 2131252590;
        if (r3 == false) goto L12;
        View r5 = this.e;
        if (r5 == null) goto L22;
        if (r4 == false) goto L11;
        r1 = 2131252609;
    L11:
        r5.setBackgroundResource(r1);
        return;
    L22:
        return;
    L12:
        View r6 = this.e;
        if (r6 == null) goto L24;
        if (r4 == true) goto L16;
    L20:
        r6.setBackgroundResource(r1);
        return;
    L16:
        if (this.j == false) goto L18;
    L19:
        r1 = 2131252610;
        goto L20
    L18:
        if (k.n(IUserService.class).user().c() == false) goto L20;
    }

    public a(FragmentActivity r1, g r2, InterfaceC0204a r3, DataCenter r4, com.bytedance.android.live.livepkaudience.seat.f r5) {
        Intrinsics.checkNotNullParameter(r1, "context");
        super(r1);
        this.o = r2;
        this.p = r5;
        this.i = r4;
    }
}
