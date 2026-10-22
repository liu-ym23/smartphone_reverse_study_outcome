package com.bytedance.android.live.revlink.impl.service;

import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.base.model.m;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.link.data.RevPkState;
import com.bytedance.android.live.revenue.core.util.j;
import com.bytedance.android.live.revlink.api.ILinkService;
import com.bytedance.android.live.revlink.impl.LinkCrossRoomDataHolder;
import com.bytedance.android.live.revlink.impl.pk.dialog.PkFeedbackDialog;
import com.bytedance.android.live.revlink.impl.pk.scope.service.PkScopeProviderService;
import com.bytedance.android.live.revlink.impl.pk.service.IPKLinkBizDataService;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.GiftReceiverRepoService;
import com.bytedance.android.livesdk.gift.platform.business.tray.GiftTrayWidget;
import com.bytedance.android.livesdk.link.model.IBattleConfigSetting;
import com.bytedance.android.livesdk.link.model.bridge.v1;
import com.bytedance.android.livesdk.link.model.d7;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import gd0.v;
import io.reactivex.subjects.PublishSubject;
import java.util.HashMap;
import java.util.Map;
import kc0.q;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import yz0.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class f implements p11.h, q {
    public final int a;
    public final int b;
    public final Map<Observer<RevPkState>, Observer<q11.b>> c;

    public static final class a<T> implements Observer {
        public final /* synthetic */ Observer a;

        public a(Observer r1) {
            this.a = r1;
        }

        public final void onChanged(Object r2) {
            q11.b r3 = (q11.b) r2;
            Observer r0 = this.a;
            if (r3 == null) goto L5;
            RevPkState r4 = r3.a();
        L6:
            Intrinsics.checkNotNull(r4);
            r0.onChanged(r4);
            return;
        L5:
            r4 = null;
            goto L6
        }
    }

    public final String D() {
        y11.c r0 = ((x11.b) com.bytedance.android.live.revenue.core.util.f.a(x11.b.class)).V0();
        if (r0 == null) goto L6;
        String r1 = r0.D();
        if (r1 == null) goto L6;
        return r1;
    L6:
        return "";
    }

    public final com.bytedance.android.live.revlink.impl.pk.transfer.a L() {
        return new com.bytedance.android.live.revlink.impl.pk.transfer.a();
    }

    public final IRoom b() {
        y11.c r0 = ((x11.b) com.bytedance.android.live.revenue.core.util.f.a(x11.b.class)).V0();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.b();
    }

    public final pc0.e e() {
        com.bytedance.android.live.revlink.impl.rtc.a.G0.getClass();
        com.bytedance.android.live.revlink.impl.rtc.a r0 = com.bytedance.android.live.revlink.impl.rtc.a.C0196a.a();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.e();
    }

    public final String getInviteMode() {
        y11.c r0 = ((x11.b) com.bytedance.android.live.revenue.core.util.f.a(x11.b.class)).V0();
        if (r0 == null) goto L6;
        String r1 = r0.getInviteMode();
        if (r1 == null) goto L6;
        return r1;
    L6:
        return "";
    }

    @Override // p11.h
    public final String getTheme() {
        y11.c r0 = ((x11.b) com.bytedance.android.live.revenue.core.util.f.a(x11.b.class)).V0();
        if (r0 == null) goto L6;
        String r1 = r0.getTheme();
        if (r1 == null) goto L6;
        return r1;
    L6:
        return "";
    }

    public f() {
        PublishSubject.create();
        this.a = 1;
        this.b = 2;
        this.c = new HashMap();
    }

    public final long A() {
        w31.c r0 = com.bytedance.android.live.revlink.impl.global.b.T();
        if (r0 == null) goto L15;
        com.bytedance.android.live.revlink.impl.global.c r1 = r0.c;
        if (r1 == null) goto L7;
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.e r2 = r1.Ig();
    L8:
        if (r2 == null) goto L16;
        MutableLiveData<Long> r3 = r2.getAudioPunishRemainTime();
        if (r3 == null) goto L17;
        Long r4 = (Long) r3.getValue();
        if (r4 != null) goto L14;
        return 0;
    L14:
        return r4.longValue();
    L17:
        return 0;
    L16:
        return 0;
    L7:
        r2 = null;
        goto L8
    L15:
        return 0;
    }

    public final IBaseUser C() {
        com.bytedance.android.live.revlink.impl.pk.utils.q r0 = com.bytedance.android.live.revlink.impl.global.b.W();
        if (r0 == null) goto L10;
        com.bytedance.android.live.revlink.impl.mergepk.pkdouble.c r1 = r0.g();
        if (r1 == null) goto L10;
        LiveData<IBaseUser> r2 = r1.getGuestUser();
        if (r2 == null) goto L10;
        IBaseUser r3 = (IBaseUser) r2.getValue();
        if (r3 == null) goto L10;
        return r3;
    L10:
        return null;
    }

    public final boolean F() {
        com.bytedance.android.live.revenuelink.connect.g r0 = com.bytedance.android.live.revlink.impl.global.b.b();
        if (r0 != null) goto L5;
    L6:
        com.bytedance.android.live.revenuelink.connect.g r1 = com.bytedance.android.live.revlink.impl.global.b.b();
        if (r1 == null) goto L11;
        if (r1.s1() != 1) goto L11;
        return true;
    L11:
        if (isMatching() == true) goto L21;
        com.bytedance.android.live.revlink.impl.multianchor.match.a r2 = com.bytedance.android.live.revlink.impl.global.b.I();
        if (r2 != null) goto L15;
    L17:
        return false;
    L15:
        if (r2.isMatching() != true) goto L17;
        return true;
    L21:
        return true;
    L5:
        if (r0.s1() != 2) goto L6;
        return true;
    }

    public final void F0() {
        com.bytedance.android.live.revlink.impl.service.internal.a r0 = com.bytedance.android.live.revlink.impl.global.b.n();
        if (r0 == null) goto L6;
        r0.F0();
        return;
    }

    public final oq2.d G() {
        com.bytedance.android.live.revlink.impl.pk.service.h r0 = com.bytedance.android.live.revlink.impl.global.b.U();
        if (r0 == null) goto L7;
        oq2.d r1 = r0.getPkLayoutData(false);
        if (r1 == null) goto L7;
        return r1;
    L7:
        int r2 = Math.max(s1.w(), s1.y());
        int r3 = Math.min(s1.w(), s1.y());
        float r4 = r2;
        float r5 = j41.f.a;
        return new oq2.d((int) (j41.f.a * r4), r3 / 2, (int) (r4 * 0.40625f));
    }

    public final Long J() {
        com.bytedance.android.live.revlink.impl.global.c r0 = com.bytedance.android.live.revlink.impl.global.b.k();
        if (r0 == null) goto L9;
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.e r1 = r0.Ig();
        if (r1 == null) goto L9;
        LiveData<Long> r2 = r1.getBaseTimeLeft();
        if (r2 == null) goto L9;
        return (Long) r2.getValue();
    L9:
        return null;
    }

    public final RevPkState d() {
        com.bytedance.android.live.revlink.impl.pk.utils.q r0 = com.bytedance.android.live.revlink.impl.global.b.W();
        if (r0 == null) goto L7;
        RevPkState r1 = r0.a().a();
        if (r1 == null) goto L7;
        return r1;
    L7:
        return RevPkState.DISABLE;
    }

    @Override // p11.h
    public final q11.b g() {
        com.bytedance.android.live.revlink.impl.pk.utils.q r0 = com.bytedance.android.live.revlink.impl.global.b.W();
        if (r0 == null) goto L6;
        return r0.a();
    L6:
        return q11.b.a.b;
    }

    public final int getPkState() {
        if (com.bytedance.android.live.revlink.impl.global.b.n() == null) goto L7;
        com.bytedance.android.live.revlink.impl.service.internal.a r0 = com.bytedance.android.live.revlink.impl.global.b.n();
        if (r0 == null) goto L7;
        int r1 = r0.getCurrentMode();
    L9:
        if (v.a(r1, 4) == false) goto L13;
        return this.a;
    L13:
        if (v.a(r1, 64) == true) goto L15;
        return 0;
    L15:
        return this.b;
    L7:
        r1 = 0;
        goto L9
    }

    @Override // p11.h
    public final boolean h() {
        w31.c r0 = com.bytedance.android.live.revlink.impl.global.b.T();
        if (r0 != null) goto L5;
        return false;
    L5:
        if (r0.o() != true) goto L21;
        d51.c r1 = d51.c.A0;
        r1.getClass();
        if (((Boolean) d51.c.L.getValue(r1, d51.c.a[36])).booleanValue() == true) goto L11;
        return l51.a.r();
    L11:
        if (Intrinsics.areEqual(g(), q11.b.d.b) == true) goto L18;
        if (Intrinsics.areEqual(g(), q11.b.c.b) == true) goto L18;
        return l51.a.e();
    L18:
        return l51.a.r();
    L21:
        return false;
    }

    public final boolean isInBreakThrough() {
        return com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt.d.b();
    }

    @Override // p11.h
    public final boolean isInCloudCollaborate() {
        com.bytedance.android.live.revlink.impl.pk.utils.q r0 = com.bytedance.android.live.revlink.impl.global.b.W();
        if (r0 == null) goto L8;
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.e r1 = r0.d();
        if (r1 != null) goto L7;
        return false;
    L7:
        return r1.isInCloudCollaborate();
    L8:
        return false;
    }

    public final boolean isMatching() {
        i41.a r0 = com.bytedance.android.live.revlink.impl.global.b.g();
        if (r0 != null) goto L5;
    L6:
        LinkCrossRoomDataHolder r1 = com.bytedance.android.live.revlink.impl.global.b.j();
        if (r1 != null) goto L9;
        return true;
    L9:
        if (r1.c() != 0) goto L15;
        return false;
    L15:
        return true;
    L5:
        if (r0.f != true) goto L6;
        return true;
    }

    @Override // p11.h
    public final q11.d k() {
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.e r0 = com.bytedance.android.live.revlink.impl.global.b.R();
        if (r0 == null) goto L8;
        IBattleConfigSetting r1 = r0.getConfigSetting();
        if (r1 != null) goto L7;
        return null;
    L7:
        return new q11.d(r1.getPlayMode(), r1.getTeamMode(), r1.getActivityMode());
    L8:
        return null;
    }

    public final d7 multiLiveCoreInfo() {
        w31.c r0 = com.bytedance.android.live.revlink.impl.global.b.T();
        if (r0 == null) goto L8;
        com.bytedance.android.live.revlink.impl.pk.service.d r1 = r0.h();
        if (r1 != null) goto L7;
        return null;
    L7:
        return r1.multiLiveCoreInfo();
    L8:
        return null;
    }

    public final v1 multiRtcInfo() {
        w31.c r0 = com.bytedance.android.live.revlink.impl.global.b.T();
        if (r0 == null) goto L8;
        com.bytedance.android.live.revlink.impl.pk.service.d r1 = r0.h();
        if (r1 != null) goto L7;
        return null;
    L7:
        return r1.multiRtcInfo();
    L8:
        return null;
    }

    public final void B(boolean r2) {
        ld.a r0 = ld.d.a();
        if (r0 == null) goto L8;
        NextLiveData r1 = r0.io();
        if (r1 == null) goto L9;
        r1.setValue(Boolean.valueOf(r2));
        return;
    L9:
        return;
    }

    public final void E(Observer<Long> r2) {
        Intrinsics.checkNotNullParameter(r2, "newObserver");
        com.bytedance.android.live.revlink.impl.pk.utils.q r0 = com.bytedance.android.live.revlink.impl.global.b.W();
        if (r0 == null) goto L10;
        PkScopeProviderService r1 = r0.a;
        if (r1 == null) goto L11;
        MutableLiveData<Long> r3 = r1.c;
        if (r3 == null) goto L12;
        r3.observeForever(r2);
        return;
    L12:
        return;
    L11:
        return;
    }

    public final void H(boolean r2) {
        com.bytedance.android.live.revlink.impl.pk.service.h r0 = com.bytedance.android.live.revlink.impl.global.b.U();
        if (r0 == null) goto L6;
        r0.handlePkRoomClose(r2);
        return;
    }

    public final void I(String r3) {
        Intrinsics.checkNotNullParameter(r3, "tag");
        com.bytedance.android.live.revlink.impl.global.c r1 = com.bytedance.android.live.revlink.impl.global.b.k();
        if (r1 == null) goto L5;
        m51.f r2 = r1.A7();
    L6:
        if (r2 == null) goto L9;
        Intrinsics.checkNotNullParameter(r3, "tag");
        return;
    L9:
        return;
    L5:
        r2 = null;
        goto L6
    }

    public final void K(Object r6) {
        FragmentActivity r7 = (FragmentActivity) m.b(r6, FragmentActivity.class);
        if (r7 != null) goto L5;
        return;
    L5:
        com.bytedance.android.livesdk.revenue.service.user.a r0 = vh6.c.b(com.bytedance.android.livesdk.revenue.service.user.a.class);
        if (r0.isLogin() == true) goto L9;
        ds2.e r1 = r0.Je();
        r1.setMessage(s1.B(2131919278));
        Intrinsics.checkNotNullParameter("feedback", "<set-?>");
        r1.c = "feedback";
        r1.e = 0;
        Unit r2 = Unit.INSTANCE;
        r0.g2(r7, r1).compose(RxUtil.bindUntilDestroy(r7)).subscribe(new com.bytedance.android.livesdk.user.h());
        return;
    L9:
        w31.c r3 = com.bytedance.android.live.revlink.impl.global.b.T();
        if (r3 != null) goto L12;
    L14:
        int r4 = PkFeedbackDialog.p;
        String r5 = "pk";
    L16:
        if (v.a(((ILinkService) com.bytedance.android.live.revenue.core.util.f.a(ILinkService.class)).getRevLinkControlService().getCurrentMode(), 64) == false) goto L18;
        r5 = "multi_linker";
    L18:
        k r8 = (k) com.bytedance.android.live.revenue.core.util.f.d(j.C0.a(), k.class);
        if (r8 == null) goto L21;
        IRoom r9 = r8.getRoom();
    L22:
        if (r9 == null) goto L32;
        PkFeedbackDialog r10 = PkFeedbackDialog.a.a(false, r9, r5);
        FragmentManager r12 = r7.getSupportFragmentManager();
        LandscapeRestrictionOperation r13 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r10, "PkFeedbackDialog", r13);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r12, r10, r13) == true) goto L33;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L29
    L27:
        r10.show(r12, "PkFeedbackDialog");
        return;
    L33:
        return;
    L32:
        return;
    L21:
        r9 = null;
        goto L22
    L12:
        if (r3.a() != 0) goto L14;
        int r14 = PkFeedbackDialog.p;
        r5 = "audience_linkmic";
        goto L16
    }

    public final void a(Observer<RevPkState> r3) {
        Intrinsics.checkNotNullParameter(r3, "newObserver");
        a r0 = new a(r3);
        com.bytedance.android.live.revlink.impl.pk.utils.q r1 = com.bytedance.android.live.revlink.impl.global.b.W();
        if (r1 == null) goto L9;
        PkScopeProviderService r2 = r1.a;
        if (r2 == null) goto L9;
        MutableLiveData<q11.b> r4 = r2.a;
        if (r4 == null) goto L9;
        r4.observeForever(r0);
    L9:
        ((HashMap) this.c).put(r3, r0);
    }

    public final void c(Observer<RevPkState> r3) {
        Intrinsics.checkNotNullParameter(r3, "newObserver");
        Observer r0 = (Observer) ((HashMap) this.c).get(r3);
        if (r0 != null) goto L5;
        return;
    L5:
        com.bytedance.android.live.revlink.impl.pk.utils.q r1 = com.bytedance.android.live.revlink.impl.global.b.W();
        if (r1 == null) goto L12;
        PkScopeProviderService r2 = r1.a;
        if (r2 == null) goto L12;
        MutableLiveData<q11.b> r4 = r2.a;
        if (r4 == null) goto L12;
        r4.removeObserver(r0);
    L12:
        ((HashMap) this.c).remove(r3);
    }

    public final void f(Observer<Long> r2) {
        Intrinsics.checkNotNullParameter(r2, "newObserver");
        com.bytedance.android.live.revlink.impl.pk.utils.q r0 = com.bytedance.android.live.revlink.impl.global.b.W();
        if (r0 == null) goto L10;
        PkScopeProviderService r1 = r0.a;
        if (r1 == null) goto L11;
        MutableLiveData<Long> r3 = r1.c;
        if (r3 == null) goto L12;
        r3.removeObserver(r2);
        return;
    L12:
        return;
    L11:
        return;
    }

    public final HashMap<String, String> getFollowExtraParams(String r3) {
        Intrinsics.checkNotNullParameter(r3, "targetUid");
        HashMap<String, String> r0 = new HashMap();
        IPKLinkBizDataService r1 = com.bytedance.android.live.revlink.impl.global.b.P();
        if (r1 == null) goto L6;
        Map<String, String> r4 = r1.getFollowExtraParams(r3);
        if (r4 == null) goto L6;
    L7:
        r0.putAll(r4);
        return r0;
    L6:
        r4 = com.bytedance.revenue.platform.api.core.d.a(new Pair[0]);
        goto L7
    }

    @Override // p11.h
    public final void i(Observer<q11.b> r2) {
        Intrinsics.checkNotNullParameter(r2, "newObserver");
        com.bytedance.android.live.revlink.impl.pk.utils.q r0 = com.bytedance.android.live.revlink.impl.global.b.W();
        if (r0 == null) goto L10;
        PkScopeProviderService r1 = r0.a;
        if (r1 == null) goto L11;
        MutableLiveData<q11.b> r3 = r1.a;
        if (r3 == null) goto L12;
        r3.removeObserver(r2);
        return;
    L12:
        return;
    L11:
        return;
    }

    @Override // p11.h
    public final void j(GiftReceiverRepoService.h r2) {
        Intrinsics.checkNotNullParameter(r2, "newObserver");
        com.bytedance.android.live.revlink.impl.pk.utils.q r0 = com.bytedance.android.live.revlink.impl.global.b.W();
        if (r0 == null) goto L10;
        PkScopeProviderService r1 = r0.a;
        if (r1 == null) goto L11;
        MutableLiveData<IBaseUser> r3 = r1.b;
        if (r3 == null) goto L12;
        r3.removeObserver(r2);
        return;
    L12:
        return;
    L11:
        return;
    }

    @Override // p11.h
    public final void l(GiftReceiverRepoService.h r2) {
        Intrinsics.checkNotNullParameter(r2, "newObserver");
        com.bytedance.android.live.revlink.impl.pk.utils.q r0 = com.bytedance.android.live.revlink.impl.global.b.W();
        if (r0 == null) goto L10;
        PkScopeProviderService r1 = r0.a;
        if (r1 == null) goto L11;
        MutableLiveData<IBaseUser> r3 = r1.b;
        if (r3 == null) goto L12;
        r3.observeForever(r2);
        return;
    L12:
        return;
    L11:
        return;
    }

    @Override // p11.h
    public final void m(Observer<q11.b> r2) {
        Intrinsics.checkNotNullParameter(r2, "newObserver");
        com.bytedance.android.live.revlink.impl.pk.utils.q r0 = com.bytedance.android.live.revlink.impl.global.b.W();
        if (r0 == null) goto L10;
        PkScopeProviderService r1 = r0.a;
        if (r1 == null) goto L11;
        MutableLiveData<q11.b> r3 = r1.a;
        if (r3 == null) goto L12;
        r3.observeForever(r2);
        return;
    L12:
        return;
    L11:
        return;
    }

    @Override // p11.h
    public final void n(GiftTrayWidget.g r2) {
        Intrinsics.checkNotNullParameter(r2, "newObserver");
        ld.a r0 = ld.d.a();
        if (r0 == null) goto L8;
        NextLiveData r1 = r0.Oi();
        if (r1 == null) goto L9;
        r1.observeForever(r2);
        return;
    L9:
        return;
    }

    @Override // p11.h
    public final void o(GiftTrayWidget.g r2) {
        Intrinsics.checkNotNullParameter(r2, "newObserver");
        ld.a r0 = ld.d.a();
        if (r0 == null) goto L8;
        NextLiveData r1 = r0.Oi();
        if (r1 == null) goto L9;
        r1.removeObserver(r2);
        return;
    L9:
        return;
    }

    public final void sendGuestKickOut(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "uid");
        Intrinsics.checkNotNullParameter(r3, "openId");
        com.bytedance.android.live.revlink.impl.pk.service.h r0 = com.bytedance.android.live.revlink.impl.global.b.U();
        if (r0 == null) goto L6;
        r0.sendGuestKickOut(r2, r3);
        return;
    }
}
