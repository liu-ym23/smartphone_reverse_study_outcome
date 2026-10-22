package y11;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.revlink.impl.mergepk.pkbase.PkBaseDataContext;
import com.bytedance.android.live.revlink.impl.mergepk.pkbase.statemachine.PkBaseStateMachine;
import com.bytedance.android.live.revlink.impl.multianchor.dialog.MultiLinkTimeRecorder$pkStateObserver$1;
import com.bytedance.android.live.revlink.impl.pk.scope.service.PkScopeProviderService;
import com.bytedance.android.live.revlink.impl.pk.service.IPKLinkBizDataService;
import com.bytedance.android.live.revlink.impl.pk.utils.q;
import com.bytedance.android.livesdk.link.model.aa;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.scope.m;
import cy0.j;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class d implements c {
    public final com.bytedance.android.live.revlink.impl.global.c a;
    public final PkScopeProviderService b;

    @Override // y11.c
    public final String D() {
        cy0.e.a.getClass();
        j r1 = cy0.e.a.a;
        m.e.getClass();
        Object r0 = m.b(r1).b(com.bytedance.android.livesdk.revenue.service.user.a.class);
        Intrinsics.checkNotNull(r0);
        String r2 = iz.a.a(((com.bytedance.live.kmp.core.c) r0).b());
        IPKLinkBizDataService r3 = a();
        if (r3 == null) goto L22;
        w31.c r4 = d();
        String r5 = null;
        boolean r6 = true;
        if (r4 != null) goto L7;
    L12:
        w31.c r7 = d();
        if (r7 == null) goto L15;
        r5 = r7.c();
    L15:
        String r8 = r3.getTransformReason(r2, r5);
    L17:
        if (r8.length() > 0) goto L20;
        r6 = false;
    L20:
        if (r6 == false) goto L22;
        return r8;
    L7:
        if (r4.e() != true) goto L12;
        w31.c r9 = d();
        if (r9 == null) goto L11;
        r5 = r9.c();
    L11:
        r8 = r3.getTransformReason(r5, r2);
    L22:
        return "";
    }

    public final IPKLinkBizDataService a() {
        com.bytedance.android.live.revlink.impl.global.c r0 = this.a;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.mk();
    }

    public final IBaseUser c() {
        com.bytedance.android.live.revlink.impl.global.c r0 = this.a;
        if (r0 == null) goto L5;
        q r1 = r0.getPkUtils();
    L6:
        if (r1 == null) goto L13;
        com.bytedance.android.live.revlink.impl.mergepk.pkdouble.c r2 = r1.g();
        if (r2 == null) goto L14;
        LiveData<IBaseUser> r3 = r2.getGuestUser();
        if (r3 != null) goto L12;
        return null;
    L12:
        return (IBaseUser) r3.getValue();
    L14:
        return null;
    L13:
        return null;
    L5:
        r1 = null;
        goto L6
    }

    public final w31.c d() {
        com.bytedance.android.live.revlink.impl.global.c r0 = this.a;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getPkLinkUtils();
    }

    public final q11.b e() {
        com.bytedance.android.live.revlink.impl.global.c r0 = this.a;
        q11.b r1 = null;
        if (r0 == null) goto L5;
        q r2 = r0.getPkUtils();
    L6:
        if (r2 == null) goto L31;
        com.bytedance.android.live.revlink.impl.global.c r3 = r2.c;
        if (r3 == null) goto L10;
        com.bytedance.android.live.revlink.impl.mergepk.pkdouble.e r4 = r3.el();
    L11:
        if (r4 == null) goto L15;
        com.bytedance.android.live.revlink.impl.global.c r5 = r4.a;
        if (r5 == null) goto L15;
        com.bytedance.android.live.revlink.impl.mergepk.pkdouble.c r6 = r5.K8();
    L16:
        if (r6 == null) goto L34;
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.e r7 = r2.d();
        if (r7 == null) goto L33;
        PkBaseStateMachine.c r8 = r7.getCurPKBaseState();
        if (r8 == null) goto L33;
        com.bytedance.android.live.revlink.impl.global.c r9 = r2.c;
        if (r9 == null) goto L24;
        d21.d r10 = r9.getMergePkHelper();
    L25:
        if (r10 == null) goto L27;
        r1 = d21.d.f(r8);
    L27:
        if (r1 == null) goto L33;
        return r1;
    L24:
        r10 = null;
    L33:
        return q11.b.a.b;
    L34:
        return q11.b.a.b;
    L15:
        r6 = null;
        goto L16
    L10:
        r4 = null;
        goto L11
    L31:
        return q11.b.a.b;
    L5:
        r2 = null;
        goto L6
    }

    @Override // y11.c
    public final String getInviteMode() {
        com.bytedance.android.live.revlink.impl.global.c r0 = this.a;
        Integer r1 = null;
        if (r0 == null) goto L5;
        com.bytedance.android.live.revlink.impl.service.internal.a r2 = r0.Do();
    L6:
        boolean r3 = false;
        if (r2 == null) goto L9;
        int r4 = r2.getCurrentMode();
    L10:
        String r5 = "connection";
        if (com.bytedance.android.live.utils.c.a(r4, 64) == true) goto L80;
        com.bytedance.android.live.revlink.impl.global.c r6 = this.a;
        if (r6 == null) goto L16;
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.e r7 = r6.Ig();
    L17:
        com.bytedance.android.live.revlink.impl.global.c r8 = this.a;
        if (r8 == null) goto L20;
        com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt.f r9 = r8.getLinkPlayHelper();
    L21:
        if (r9 == null) goto L24;
        r9.f();
    L24:
        if (r7 != null) goto L26;
    L28:
        String r10 = "routine_pk";
    L29:
        if (r7 == null) goto L36;
        if (r7.isCustomizePkPlay() == false) goto L33;
    L34:
        r10 = "customize_pk";
        goto L36
    L33:
        if (r7.isCustomPKPlay(false) == true) goto L34;
    L36:
        if (r7 != null) goto L38;
    L42:
        IPKLinkBizDataService r12 = a();
        if (r12 == null) goto L45;
        r1 = Integer.valueOf(r12.getPeakSwitchPlayMode());
    L45:
        int r13 = com.bytedance.android.live.revlink.impl.mergepk.pkdouble.d.a;
        if (r1 != null) goto L49;
    L51:
        if (r1 != null) goto L54;
    L56:
        r5 = r10;
    L57:
        if (r7 != null) goto L59;
    L61:
        if (r7 != null) goto L63;
    L65:
        if (r7 != null) goto L67;
    L69:
        if (r7 != null) goto L71;
    L73:
        if (r7 != null) goto L75;
        return r5;
    L75:
        if (r7.isInCloudCollaborate() != true) goto L79;
        return "link_screen";
    L79:
        return r5;
    L71:
        if (r7.modType() != PkBaseDataContext.PKModType.SeasonRank) goto L73;
        r5 = "season_rank";
        goto L73
    L67:
        if (r7.isInSpecifyGiftPk() != true) goto L69;
        r5 = "focus_gift";
        goto L69
    L63:
        if (r7.modType() != PkBaseDataContext.PKModType.BreakThrough) goto L65;
        r5 = "cooperation";
        goto L65
    L59:
        if (r7.isInCompetition() != true) goto L61;
        r5 = "compete";
        goto L61
    L54:
        if (r1.intValue() != 1) goto L56;
    L49:
        if (r1.intValue() != 2) goto L51;
        r5 = "vote";
        goto L57
    L38:
        if (r7.getFlexActivityId().length() <= 0) goto L40;
        r3 = true;
    L40:
        if (r3 == false) goto L42;
        r10 = "activity_pk";
        goto L42
    L26:
        if (r7.modType() != PkBaseDataContext.PKModType.Vote) goto L28;
        r10 = "vote";
        goto L29
    L20:
        r9 = null;
        goto L21
    L16:
        r7 = null;
        goto L17
    L80:
        return "connection";
    L9:
        r4 = 0;
        goto L10
    L5:
        r2 = null;
        goto L6
    }

    @Override // y11.c
    public final String getInviteModeStatus() {
        com.bytedance.android.live.revlink.impl.global.c r0 = this.a;
        Integer r1 = null;
        if (r0 == null) goto L5;
        com.bytedance.android.live.revlink.impl.service.internal.a r2 = r0.Do();
    L6:
        boolean r3 = false;
        if (r2 == null) goto L9;
        int r4 = r2.getCurrentMode();
    L11:
        if (com.bytedance.android.live.utils.c.a(r4, 64) == false) goto L14;
        return "";
    L14:
        com.bytedance.android.live.revlink.impl.global.c r5 = this.a;
        if (r5 == null) goto L17;
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.e r6 = r5.Ig();
    L18:
        com.bytedance.android.live.revlink.impl.global.c r7 = this.a;
        if (r7 == null) goto L21;
        com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt.f r8 = r7.getLinkPlayHelper();
    L22:
        if (r8 == null) goto L24;
        r8.f();
    L24:
        String r9 = "vote";
        if (r6 != null) goto L27;
    L29:
        String r10 = "routine_pk";
    L30:
        String r12 = "customize_pk";
        if (r6 == null) goto L36;
        if (r6.isCustomizePkPlay() == false) goto L36;
        r10 = "customize_pk";
    L36:
        if (r6 != null) goto L38;
    L40:
        r12 = r10;
    L41:
        if (r6 != null) goto L43;
    L47:
        IPKLinkBizDataService r13 = a();
        if (r13 == null) goto L50;
        Integer r14 = Integer.valueOf(r13.getPeakSwitchPlayMode());
    L51:
        int r15 = com.bytedance.android.live.revlink.impl.mergepk.pkdouble.d.a;
        if (r14 != null) goto L55;
    L57:
        if (r14 != null) goto L60;
    L62:
        r9 = r12;
    L63:
        if (r6 != null) goto L65;
    L67:
        if (r6 != null) goto L69;
    L71:
        if (r6 != null) goto L73;
    L75:
        com.bytedance.android.live.revlink.impl.global.c r16 = this.a;
        if (r16 == null) goto L78;
        com.bytedance.android.live.revlink.impl.mergepk.pkdouble.e r17 = r16.el();
    L79:
        if (r17 == null) goto L86;
        com.bytedance.android.live.revlink.impl.global.c r18 = r17.a;
        if (r18 == null) goto L83;
        com.bytedance.android.live.revlink.impl.mergepk.pkdouble.c r19 = r18.K8();
    L84:
        if (r19 == null) goto L86;
        r1 = Integer.valueOf(r19.getCurrentMatchType());
        goto L86
    L83:
        r19 = null;
    L86:
        if (r1 != null) goto L89;
    L90:
        if (r1 != null) goto L93;
    L95:
        if (r6 != null) goto L97;
    L99:
        if (r6 != null) goto L101;
    L103:
        if (r6 != null) goto L105;
        return r9;
    L105:
        if (r6.isInInteractPk() != true) goto L109;
        return "interact_compete";
    L109:
        return r9;
    L101:
        if (r6.isInCloudCollaborate() != true) goto L103;
        r9 = "link_screen";
        goto L103
    L97:
        if (r6.modType() != PkBaseDataContext.PKModType.SeasonRank) goto L99;
        r9 = "season_rank";
        goto L99
    L93:
        if (r1.intValue() != 13) goto L95;
    L94:
        r9 = "pk_season";
        goto L95
    L89:
        if (r1.intValue() == 8) goto L94;
    L78:
        r17 = null;
        goto L79
    L73:
        if (r6.isInSpecifyGiftPk() != true) goto L75;
        r9 = "focus_gift";
        goto L75
    L69:
        if (r6.isInBreakThrough() != true) goto L71;
        r9 = "cooperation";
        goto L71
    L65:
        if (r6.isInCompetition() != true) goto L67;
        r9 = "compete";
        goto L67
    L60:
        if (r14.intValue() != 1) goto L62;
        r9 = "connection";
        goto L63
    L55:
        if (r14.intValue() != 2) goto L57;
    L50:
        r14 = null;
        goto L51
    L43:
        if (r6.getFlexActivityId().length() <= 0) goto L45;
        r3 = true;
    L45:
        if (r3 == false) goto L47;
        r12 = "activity_pk";
        goto L47
    L38:
        if (r6.isCustomPKPlay(false) != true) goto L40;
    L27:
        if (r6.modType() != PkBaseDataContext.PKModType.Vote) goto L29;
        r10 = "vote";
        goto L30
    L21:
        r8 = null;
        goto L22
    L17:
        r6 = null;
        goto L18
    L9:
        r4 = 0;
        goto L11
    L5:
        r2 = null;
        goto L6
    }

    @Override // y11.c
    public final String getTheme() {
        com.bytedance.android.live.revlink.impl.global.c r0 = this.a;
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.e r1 = null;
        if (r0 == null) goto L5;
        com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt.f r2 = r0.getLinkPlayHelper();
    L6:
        if (r2 != null) goto L8;
    L18:
        IPKLinkBizDataService r3 = a();
        if (r3 == null) goto L21;
        Integer r4 = Integer.valueOf(r3.getPeakSwitchPlayMode());
    L22:
        IPKLinkBizDataService r5 = a();
        if (r5 == null) goto L25;
        r1 = r5.getPeakVoteSetting();
    L25:
        int r6 = com.bytedance.android.live.revlink.impl.mergepk.pkdouble.d.a;
        if (r4 != null) goto L29;
    L33:
        return "";
    L29:
        if (r4.intValue() != 2) goto L33;
        if (r1 == null) goto L33;
        String r7 = r1.getVoteDes();
        if (r7 == null) goto L33;
        return r7;
    L21:
        r4 = null;
        goto L22
    L8:
        if (r2.i() != true) goto L18;
        com.bytedance.android.live.revlink.impl.global.c r8 = this.a;
        if (r8 == null) goto L12;
        r1 = r8.Ig();
    L12:
        if (r1 == null) goto L33;
        aa r9 = r1.getVoteSetting();
        if (r9 == null) goto L33;
        String r10 = r9.getVoteDes();
        if (r10 == null) goto L33;
        return r10;
    L5:
        r2 = null;
        goto L6
    }

    @Override // y11.c
    public final IRoom b() {
        w31.c r0 = d();
        boolean r1 = false;
        if (r0 == null) goto L26;
        IPKLinkBizDataService r2 = r0.g();
        if (r2 == null) goto L7;
        boolean r3 = r2.getIsStarter();
    L8:
        if (r3 != true) goto L26;
        w31.c r4 = d();
        if (r4 == null) goto L16;
        IPKLinkBizDataService r5 = r4.g();
        if (r5 == null) goto L16;
        IPKLinkBizDataService.c r6 = r5.getGuestInfo();
        if (r6 == null) goto L16;
        IRoom r7 = r6.d;
    L17:
        if (r7 == null) goto L26;
        w31.c r8 = d();
        if (r8 == null) goto L49;
        IPKLinkBizDataService r9 = r8.g();
        if (r9 == null) goto L50;
        IPKLinkBizDataService.c r10 = r9.getGuestInfo();
        if (r10 != null) goto L25;
        return null;
    L25:
        return r10.d;
    L50:
        return null;
    L49:
        return null;
    L16:
        r7 = null;
        goto L17
    L7:
        r3 = false;
    L26:
        w31.c r12 = d();
        if (r12 == null) goto L32;
        IPKLinkBizDataService r13 = r12.g();
        if (r13 == null) goto L31;
        r1 = r13.getIsStarter();
    L31:
        if (r1 != true) goto L32;
        return null;
    L32:
        w31.c r14 = d();
        if (r14 == null) goto L39;
        IPKLinkBizDataService r15 = r14.g();
        if (r15 == null) goto L39;
        IPKLinkBizDataService.c r16 = r15.getGuestInfo();
        if (r16 == null) goto L39;
        IRoom r17 = r16.d;
    L40:
        if (r17 == null) goto L53;
        w31.c r18 = d();
        if (r18 == null) goto L54;
        IPKLinkBizDataService r19 = r18.g();
        if (r19 == null) goto L55;
        IPKLinkBizDataService.c r20 = r19.getGuestInfo();
        if (r20 != null) goto L48;
        return null;
    L48:
        return r20.d;
    L55:
        return null;
    L54:
        return null;
    L53:
        return null;
    L39:
        r17 = null;
        goto L40
    }

    public final void f(MultiLinkTimeRecorder$pkStateObserver$1 r2) {
        Intrinsics.checkNotNullParameter(r2, "newObserver");
        PkScopeProviderService r0 = this.b;
        if (r0 == null) goto L8;
        MutableLiveData<q11.b> r1 = r0.a;
        if (r1 == null) goto L9;
        r1.observeForever(r2);
        return;
    L9:
        return;
    }

    public final void g(MultiLinkTimeRecorder$pkStateObserver$1 r2) {
        Intrinsics.checkNotNullParameter(r2, "newObserver");
        PkScopeProviderService r0 = this.b;
        if (r0 == null) goto L8;
        MutableLiveData<q11.b> r1 = r0.a;
        if (r1 == null) goto L9;
        r1.removeObserver(r2);
        return;
    L9:
        return;
    }

    public d(long r1, com.bytedance.android.live.revlink.impl.global.c r3, PkScopeProviderService r4) {
        this.a = r3;
        this.b = r4;
    }
}
