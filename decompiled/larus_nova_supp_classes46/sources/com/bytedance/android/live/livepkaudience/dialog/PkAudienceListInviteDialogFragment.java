package com.bytedance.android.live.livepkaudience.dialog;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.plantform.model.LinkPlayerInfo;
import com.bytedance.android.live.liveinteract.plantform.utils.TalkRoomOperate;
import com.bytedance.android.live.livepkaudience.emoji.LinkPKGameInteractPanel;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livesdk.chatroom.interact.model.LinkInviteResult;
import com.bytedance.android.livesdk.utils.t6;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import java.util.HashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import me.drakeet.multitype.MultiTypeAdapter;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/livepkaudience/dialog/PkAudienceListInviteDialogFragment;", "Lcom/bytedance/android/live/livepkaudience/dialog/BasePkAudienceInviteListFragment;", "<init>", "()V", "a", "livepkaudience-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PkAudienceListInviteDialogFragment extends BasePkAudienceInviteListFragment {
    public static final /* synthetic */ int H = 0;
    public DataCenter B;
    public m C;
    public final b D;
    public final Lazy E;
    public boolean F;
    public final c G;

    public static final class a {
    }

    public static final class b implements xk0.c {
        public final /* synthetic */ PkAudienceListInviteDialogFragment a;

        @Override // xk0.c
        public final void c(LinkPlayerInfo r2) {
            Intrinsics.checkNotNullParameter(r2, "linkPlayerInfo");
        }

        @Override // xk0.c
        public final void isGame() {
        }

        public b(PkAudienceListInviteDialogFragment r1) {
            this.a = r1;
        }

        @Override // xk0.c
        public final void a(LinkPlayerInfo r4) {
            Intrinsics.checkNotNullParameter(r4, "linkPlayerInfo");
            PkAudienceListInviteDialogFragment r0 = this.a;
            DataCenter r1 = r0.B;
            if (r1 != null) goto L5;
            return;
        L5:
            Context r2 = r0.getContext();
            if (r2 != null) goto L8;
            return;
        L8:
            int r3 = LinkPKGameInteractPanel.z;
            LinkPKGameInteractPanel r5 = LinkPKGameInteractPanel.a.a(r2, r1, r4);
            if (DialogLancet.shouldBlockDialogShow(r5) == false) goto L18;
            DialogLancet.handleBlockedDialogShow(r5);
        L13:
            com.bytedance.android.live.livepkaudience.service.e.y0.getClass();
            com.bytedance.android.live.livepkaudience.service.e r6 = com.bytedance.android.live.livepkaudience.service.e.a.a();
            if (r6 == null) goto L20;
            r6.hideInteractDialog();
            return;
        L20:
            return;
        L18:
            DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L17
        L12:
            DialogLancet.beforeDialogShow(r5);
            r5.show();
            DialogLancet.afterDialogShow(r5);
            goto L13
        }

        @Override // xk0.c
        public final void b(LinkPlayerInfo r18) {
            Intrinsics.checkNotNullParameter(r18, "linkPlayerInfo");
            PkAudienceListInviteDialogFragment r2 = this.a;
            int r3 = PkAudienceListInviteDialogFragment.H;
            r2.getClass();
            IBaseUser r4 = r18.getUser();
            r2.C = new m(r2, r18);
            Room r0 = r2.l;
            String r5 = "0";
            if (r0 == null) goto L57;
            if (r2.m == false) goto L30;
            com.bytedance.android.live.livepkaudience.service.b.v0.getClass();
            com.bytedance.android.live.livepkaudience.service.b r6 = com.bytedance.android.live.livepkaudience.service.b.a.a();
            if (r6 == null) goto L15;
            com.bytedance.android.live.livepkaudience.base.p r7 = r6.X4();
            if (r7 == null) goto L15;
            m r9 = r2.C;
            if (r9 == null) goto L14;
            r7.a(r9);
            goto L15
        L14:
            throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.livepkaudience.base.SimplePkAnchorLinkListener");
        L15:
            com.bytedance.android.live.livepkaudience.service.b r10 = com.bytedance.android.live.livepkaudience.service.b.a.a();
            if (r10 == null) goto L57;
            long r11 = r0.getRoomId();
            if (r4 == null) goto L23;
            String r1 = r4.getIdString();
            if (r1 == null) goto L23;
            String r12 = r1;
        L24:
            if (r4 == null) goto L27;
            Intrinsics.checkNotNullParameter(r4, "$this$secUidExt");
            String r8 = r4.getCastSecUid();
            if (r8 == null) goto L27;
        L28:
            r10.invite(r11, r12, r8, 1, 0);
        L27:
            r8 = "";
        L23:
            r12 = "0";
            goto L24
        L30:
            if (jc1.k.n(IUserService.class).user().c() == false) goto L52;
            com.bytedance.android.live.livepkaudience.service.a.u0.getClass();
            com.bytedance.android.live.livepkaudience.service.a r13 = com.bytedance.android.live.livepkaudience.service.a.C0119a.a();
            if (r13 == null) goto L40;
            com.bytedance.android.live.livepkaudience.base.o r14 = r13.A0();
            if (r14 == null) goto L40;
            m r15 = r2.C;
            if (r15 == null) goto L39;
            r14.a(r15);
            goto L40
        L39:
            throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.livepkaudience.base.SimplePkAnchorLinkListener");
        L40:
            com.bytedance.android.live.livepkaudience.service.a r16 = com.bytedance.android.live.livepkaudience.service.a.C0119a.a();
            if (r16 == null) goto L57;
            long r17 = r0.getRoomId();
            if (r4 == null) goto L46;
            String r19 = r4.getIdString();
            if (r19 == null) goto L46;
        L47:
            if (r4 == null) goto L49;
            Intrinsics.checkNotNullParameter(r4, "$this$secUidExt");
            String r20 = r4.getCastSecUid();
        L50:
            r16.t2(r17, r19, r20);
            goto L57
        L49:
            r20 = null;
        L46:
            r19 = "0";
            goto L47
        L52:
            if (jc1.k.n(IUserService.class).user().isAdmin() == false) goto L54;
            f2.b(2131914522, 0);
        L55:
            com.bytedance.android.live.liveinteract.plantform.utils.x.C0(TalkRoomOperate.INVITE);
            goto L57
        L54:
            f2.b(2131917298, 0);
        L57:
            if (r2.m == false) goto L59;
            String r21 = "anchor";
        L60:
            if (r4 == null) goto L63;
            String r22 = r4.getIdString();
            if (r22 == null) goto L63;
        L64:
            int r23 = el0.j.b;
            Intrinsics.checkNotNullParameter(r21, "inviteType");
            Intrinsics.checkNotNullParameter(r22, "inviteeId");
            Intrinsics.checkNotNullParameter("list", "requestPage");
            HashMap r24 = new HashMap();
            r24.put("invite_type", r21);
            r24.put("invitee_id", r22);
            r24.put("request_page", "list");
            if (((Boolean) com.bytedance.android.livesdk.sharedpref.c.s1.getValue()).booleanValue() == false) goto L67;
            r5 = "1";
        L67:
            r24.put("is_invite_only", r5);
            int r25 = ((IInteractService) jc1.k.n(IInteractService.class)).getCurrentScene();
            el0.j.j(r24, Integer.valueOf(r25));
            if (((IInteractService) jc1.k.n(IInteractService.class)).dynamicFromAudience() == false) goto L70;
            r24.put("function_type2", "new_audience");
        L70:
            el0.j.l(r24, r25);
            el0.j.o(r24);
            el0.j.p(r24);
            r24.put("play_mode", com.bytedance.android.live.liveinteract.utils.w.a());
            el0.j.n(r24, Integer.valueOf(r25));
            com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_anchor_audience_connection_invite", r24, new Object[]{am2.x.class, Room.class});
            return;
        L63:
            r22 = "0";
            goto L64
        L59:
            r21 = "administrator";
            goto L60
        }
    }

    public static final class c extends com.bytedance.android.live.livepkaudience.base.x {
        public final /* synthetic */ PkAudienceListInviteDialogFragment a;

        public c(PkAudienceListInviteDialogFragment r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.live.livepkaudience.base.x, com.bytedance.android.live.livepkaudience.base.g
        public final void V6(String r2, LinkInviteResult r3) {
            Intrinsics.checkNotNullParameter(r2, "uid");
            Intrinsics.checkNotNullParameter(r3, "result");
            super.V6(r2, r3);
            PkAudienceListInviteDialogFragment r4 = this.a;
            int r5 = BasePkAudienceInviteListFragment.A;
            r4.ea0(false);
        }
    }

    static {
    }

    @Override // com.bytedance.android.live.livepkaudience.dialog.BasePkAudienceInviteListFragment, com.bytedance.android.live.livepkaudience.dialog.RevInteractDialogFragmentBaseContract$View
    public final String T90() {
        return "";
    }

    @Override // com.bytedance.android.live.livepkaudience.dialog.BasePkAudienceInviteListFragment
    public final com.bytedance.android.live.livepkaudience.base.i ca0() {
        return (com.bytedance.android.live.livepkaudience.base.i) this.E.getValue();
    }

    @Override // com.bytedance.android.live.livepkaudience.dialog.BasePkAudienceInviteListFragment
    public final boolean da0() {
        return false;
    }

    public PkAudienceListInviteDialogFragment() {
        this.D = new b(this);
        this.E = LazyKt.lazy(new PkAudienceListInviteDialogFragment$userCenter$2(this));
        this.G = new c(this);
    }

    @Override // com.bytedance.android.live.livepkaudience.dialog.BasePkAudienceInviteListFragment, com.bytedance.android.live.livepkaudience.dialog.RevInteractDialogFragmentBaseContract$View
    public final float S90() {
        return UtilityKotlinExtentionsKt.j(t6.c(s1.getContext()) * 1.2f) - 48;
    }

    public final void onDestroy() {
        super.onDestroy();
        com.bytedance.android.live.livepkaudience.dialog.b r0 = (com.bytedance.android.live.livepkaudience.dialog.b) this.f;
        if (r0 == null) goto L6;
        ((com.bytedance.android.livesdk.common.c) r0).a = null;
    L6:
        if (this.m == false) goto L19;
        com.bytedance.android.live.livepkaudience.service.b.v0.getClass();
        com.bytedance.android.live.livepkaudience.service.b r1 = com.bytedance.android.live.livepkaudience.service.b.a.a();
        if (r1 == null) goto L12;
        com.bytedance.android.live.livepkaudience.base.p r2 = r1.X4();
        if (r2 == null) goto L12;
        r2.f(this.G);
    L12:
        m r3 = this.C;
        if (r3 == null) goto L32;
        com.bytedance.android.live.livepkaudience.service.b r4 = com.bytedance.android.live.livepkaudience.service.b.a.a();
        if (r4 == null) goto L33;
        com.bytedance.android.live.livepkaudience.base.p r5 = r4.X4();
        if (r5 == null) goto L34;
        r5.f(r3);
        return;
    L34:
        return;
    L33:
        return;
    L32:
        return;
    L19:
        com.bytedance.android.live.livepkaudience.service.a.u0.getClass();
        com.bytedance.android.live.livepkaudience.service.a r6 = com.bytedance.android.live.livepkaudience.service.a.C0119a.a();
        if (r6 == null) goto L24;
        com.bytedance.android.live.livepkaudience.base.o r7 = r6.A0();
        if (r7 == null) goto L24;
        r7.f(this.G);
    L24:
        m r8 = this.C;
        if (r8 == null) goto L36;
        com.bytedance.android.live.livepkaudience.service.a r9 = com.bytedance.android.live.livepkaudience.service.a.C0119a.a();
        if (r9 == null) goto L37;
        com.bytedance.android.live.livepkaudience.base.o r10 = r9.A0();
        if (r10 == null) goto L38;
        r10.f(r8);
        return;
    L38:
        return;
    L37:
        return;
    }

    public final void onResume() {
        super.onResume();
        ea0(this.F);
    }

    @Override // com.bytedance.android.live.livepkaudience.dialog.BasePkAudienceInviteListFragment
    public final DataCenter fa0() {
        return this.B;
    }

    @Override // com.bytedance.android.live.livepkaudience.dialog.BasePkAudienceInviteListFragment
    public final void onCreate(Bundle r2) {
        super.onCreate(r2);
        com.bytedance.android.live.livepkaudience.presenter.g r3 = new com.bytedance.android.live.livepkaudience.presenter.g(this.l, this);
        this.f = r3;
        ((com.bytedance.android.livesdk.common.c) r3).a = this;
    }

    @Override // com.bytedance.android.live.livepkaudience.dialog.BasePkAudienceInviteListFragment
    public final void onViewCreated(View r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r4, "view");
        super.onViewCreated(r4, r5);
        MultiTypeAdapter r6 = this.h;
        if (r6 == null) goto L5;
        r6.z2(com.bytedance.android.live.livepkaudience.list.e.class, new com.bytedance.android.live.livepkaudience.list.f(this.D));
    L5:
        MultiTypeAdapter r7 = this.h;
        if (r7 == null) goto L9;
        r7.z2(LinkPlayerInfo.class, new com.bytedance.android.live.livepkaudience.list.i(this.D, 1));
    L9:
        if (this.m == false) goto L24;
        com.bytedance.android.live.livepkaudience.service.b.v0.getClass();
        com.bytedance.android.live.livepkaudience.service.b r8 = com.bytedance.android.live.livepkaudience.service.b.a.a();
        if (r8 == null) goto L15;
        com.bytedance.android.live.livepkaudience.base.p r9 = r8.X4();
        if (r9 == null) goto L15;
        r9.a(this.G);
    L15:
        com.bytedance.android.live.livepkaudience.service.e.y0.getClass();
        com.bytedance.android.live.livepkaudience.service.e r10 = com.bytedance.android.live.livepkaudience.service.e.a.a();
        if (r10 == null) goto L18;
        String r11 = r10.Wc();
    L20:
        if (TextUtils.isEmpty(r11) == false) goto L22;
        return;
    L22:
        if (this.F == false) goto L31;
        f2.b(2131914852, 0);
        return;
    L31:
        return;
    L18:
        r11 = null;
        goto L20
    L24:
        com.bytedance.android.live.livepkaudience.service.a.u0.getClass();
        com.bytedance.android.live.livepkaudience.service.a r12 = com.bytedance.android.live.livepkaudience.service.a.C0119a.a();
        if (r12 == null) goto L33;
        com.bytedance.android.live.livepkaudience.base.o r13 = r12.A0();
        if (r13 == null) goto L34;
        r13.a(this.G);
        return;
    L34:
        return;
    }
}
