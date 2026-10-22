package com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt.vm;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.bytedance.android.live.base.model.Extra;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.live.revenue.core.util.f;
import com.bytedance.android.live.revlink.impl.multianchor.constants.PlayMode;
import com.bytedance.android.live.revlink.impl.multianchor.network.g;
import com.bytedance.android.live.revlink.impl.multianchor.network.i;
import com.bytedance.android.live.revlink.impl.multianchor.network.j;
import com.bytedance.android.live.revlink.impl.multianchor.network.l;
import com.bytedance.android.live.revlink.impl.utils.e;
import com.bytedance.android.livesdk.link.model.IBattleConfigSetting;
import com.bytedance.android.livesdk.link.model.e7;
import com.bytedance.android.livesdk.link.model.p;
import com.bytedance.android.livesdk.link.model.r3;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import h21.c;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.subjects.CompletableSubject;
import io.reactivex.subjects.PublishSubject;
import j21.d;
import j21.k;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import q21.h;
import r31.b;
import y31.u;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b[\u0010\\J$\u0010\t\u001a\u00020\b2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003H\u0002JB\u0010\u000f\u001a\u00020\b2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\r0\fH\u0002J\b\u0010\u0010\u001a\u00020\bH\u0002J\u0016\u0010\u0012\u001a\u00020\b2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0002J\u0010\u0010\u0015\u001a\u00020\b2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013J\b\u0010\u0016\u001a\u0004\u0018\u00010\u0013J\u0006\u0010\u0017\u001a\u00020\bJ\b\u0010\u0018\u001a\u00020\bH\u0014J\u0006\u0010\u0019\u001a\u00020\bJ\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003J\u000e\u0010\u001d\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\u001bJ<\u0010\u001f\u001a\u00020\b2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016JX\u0010\"\u001a\u00020\b2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010!\u001a\u00020 H\u0016J\b\u0010#\u001a\u00020\bH\u0016J \u0010$\u001a\u00020\b2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\u0006\u0010%\u001a\u00020\bJ\u0010\u0010(\u001a\u00020\b2\u0006\u0010'\u001a\u00020&H\u0016R\u001d\u0010*\u001a\b\u0012\u0004\u0012\u00020\u001b0)8\u0006¢\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-R\u001d\u0010/\u001a\b\u0012\u0004\u0012\u00020\n0.8\u0006¢\u0006\f\n\u0004\b/\u00100\u001a\u0004\b1\u00102R\u001d\u00103\u001a\b\u0012\u0004\u0012\u00020\n0.8\u0006¢\u0006\f\n\u0004\b3\u00100\u001a\u0004\b4\u00102R\u001d\u00107\u001a\b\u0012\u0004\u0012\u000206058\u0006¢\u0006\f\n\u0004\b7\u00108\u001a\u0004\b9\u0010:R\u001d\u0010<\u001a\b\u0012\u0004\u0012\u00020;058\u0006¢\u0006\f\n\u0004\b<\u00108\u001a\u0004\b=\u0010:R\u001d\u0010'\u001a\b\u0012\u0004\u0012\u00020&058\u0006¢\u0006\f\n\u0004\b'\u00108\u001a\u0004\b>\u0010:R\u0017\u0010@\u001a\u00020?8\u0006¢\u0006\f\n\u0004\b@\u0010A\u001a\u0004\bB\u0010CR\"\u0010D\u001a\u00020 8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bD\u0010E\u001a\u0004\bF\u0010G\"\u0004\bH\u0010IR\"\u0010J\u001a\u00020 8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bJ\u0010E\u001a\u0004\bK\u0010G\"\u0004\bL\u0010IR$\u0010M\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bM\u0010N\u001a\u0004\bO\u0010P\"\u0004\bQ\u0010RR\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010SR\u0014\u0010U\u001a\u00020T8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bU\u0010VR\u0014\u0010X\u001a\u00020W8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bX\u0010YR\u001e\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010Z¨\u0006]"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/multianchor/dialog/linkopt/vm/MultiAnchorPkLaunchViewModelNew;", "Landroidx/lifecycle/ViewModel;", "Lj21/d;", "", "Lcom/bytedance/android/livesdk/link/model/p;", "users", "Lcom/bytedance/android/live/base/model/user/IBaseUser;", "inviteeList", "", "updatePersonalModel", "", "beAppliedFrom", "", "", "userIdToTeamId", "updateTeamModel", "notifyPlayModeChanged", "waitingList", "updateApplyAndInviteStatus", "Lcom/bytedance/android/livesdk/link/model/IBattleConfigSetting;", "battleConfigSetting", "setBattleConfigSetting", "getBattleConfigSetting", "initPage", "onCleared", "dismiss", "getCurrentAnchorList", "Lcom/bytedance/android/live/revlink/impl/multianchor/constants/PlayMode;", "playMode", "requestSwitchPlayMode", "anchorList", "onPersonalPageUpdate", "", "sortAnchors", "onTeamPageUpdate", "onRequestChangeMultiTeamFailed", "onInviteeOrApplicantListChanged", "requestChangeMultiTeam", "", "errorCode", "onInitPageFailed", "Lcom/bytedance/ies/sdk/widgets/NextLiveData;", "playModeLiveData", "Lcom/bytedance/ies/sdk/widgets/NextLiveData;", "getPlayModeLiveData", "()Lcom/bytedance/ies/sdk/widgets/NextLiveData;", "Lio/reactivex/subjects/PublishSubject;", "onPersonalPanelSelected", "Lio/reactivex/subjects/PublishSubject;", "getOnPersonalPanelSelected", "()Lio/reactivex/subjects/PublishSubject;", "onTeamPanelSelected", "getOnTeamPanelSelected", "Landroidx/lifecycle/MutableLiveData;", "Ly31/u;", "personalPkSwitchMultiData", "Landroidx/lifecycle/MutableLiveData;", "getPersonalPkSwitchMultiData", "()Landroidx/lifecycle/MutableLiveData;", "Lq21/h;", "teamPkAnchorTeamMatchData", "getTeamPkAnchorTeamMatchData", "getErrorCode", "Lio/reactivex/subjects/CompletableSubject;", "onDismissEvent", "Lio/reactivex/subjects/CompletableSubject;", "getOnDismissEvent", "()Lio/reactivex/subjects/CompletableSubject;", "hasApplicant", "Z", "getHasApplicant", "()Z", "setHasApplicant", "(Z)V", "hasInvitee", "getHasInvitee", "setHasInvitee", "npkInvitePageSource", "Ljava/lang/String;", "getNpkInvitePageSource", "()Ljava/lang/String;", "setNpkInvitePageSource", "(Ljava/lang/String;)V", "Lcom/bytedance/android/livesdk/link/model/IBattleConfigSetting;", "Lj21/k;", "pkPanelNetFacade", "Lj21/k;", "Lio/reactivex/disposables/CompositeDisposable;", "cd", "Lio/reactivex/disposables/CompositeDisposable;", "Ljava/util/List;", "<init>", "()V", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class MultiAnchorPkLaunchViewModelNew extends ViewModel implements d {
    private List<? extends p> anchorList;
    private IBattleConfigSetting battleConfigSetting;
    private final CompositeDisposable cd;
    private final MutableLiveData<Integer> errorCode;
    private boolean hasApplicant;
    private boolean hasInvitee;
    private String npkInvitePageSource;
    private final CompletableSubject onDismissEvent;
    private final PublishSubject<String> onPersonalPanelSelected;
    private final PublishSubject<String> onTeamPanelSelected;
    private final MutableLiveData<u> personalPkSwitchMultiData;
    private final k pkPanelNetFacade;
    private final NextLiveData<PlayMode> playModeLiveData;
    private final MutableLiveData<h> teamPkAnchorTeamMatchData;

    private final void notifyPlayModeChanged() {
        PlayMode r0 = (PlayMode) this.playModeLiveData.getValue();
        if (r0 != PlayMode.PERSONAL_PK) goto L6;
        this.onPersonalPanelSelected.onNext("");
        return;
    L6:
        if (r0 != PlayMode.TEAM_PK) goto L10;
        this.onTeamPanelSelected.onNext("");
        return;
    }

    public final void dismiss() {
        this.onDismissEvent.onComplete();
    }

    public final List<p> getCurrentAnchorList() {
        List<? extends p> r0 = this.anchorList;
        if (r0 == null) goto L5;
        return r0;
    L5:
        return CollectionsKt.emptyList();
    }

    public final void initPage() {
        this.errorCode.setValue(0);
        k r0 = this.pkPanelNetFacade;
        com.bytedance.android.live.revlink.impl.multianchor.network.k r1 = r0.a;
        g r2 = r0.b;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r2, "pkPanelSwitcher");
        e7 r3 = com.bytedance.android.live.revlink.impl.multianchor.network.k.a();
        if (r3 != null) goto L5;
        PlayMode r4 = PlayMode.PERSONAL_PK;
    L6:
        r2.a(r4, new l(r1));
        return;
    L5:
        r4 = c.a(Integer.valueOf(r3.getModeTab()));
        goto L6
    }

    @Override // j21.d
    public void onRequestChangeMultiTeamFailed() {
        h r0 = (h) this.teamPkAnchorTeamMatchData.getValue();
        if (r0 == null) goto L6;
        this.teamPkAnchorTeamMatchData.setValue(r0);
        return;
    }

    public final void requestChangeMultiTeam() {
        j r0 = this.pkPanelNetFacade.c;
        Disposable r1 = r0.d;
        if (r1 == null) goto L5;
        r1.dispose();
    L5:
        Disposable r2 = null;
        r0.d = null;
        long r3 = System.currentTimeMillis();
        IBattleConfigSetting r4 = r0.a;
        if (r4 == null) goto L8;
        String r5 = e.b(r4);
    L9:
        String r10 = r5;
        r31.a r6 = b.a(r31.a.a);
        com.bytedance.android.live.revlink.impl.multianchor.vm.g r7 = com.bytedance.android.live.revlink.impl.global.b.u();
        long r8 = 0;
        if (r7 == null) goto L12;
        long r9 = r7.a();
    L13:
        IRoom r12 = r0.b;
        if (r12 == null) goto L16;
        r8 = r12.getRoomId();
    L16:
        Observable<ExtraResponse<r3, Extra>> r13 = r6.n(r9, r8, r10);
        if (r13 == null) goto L21;
        Observable r14 = r13.compose(RxUtil.rxSchedulerHelper());
        if (r14 == null) goto L21;
        r2 = r14.subscribe(new com.bytedance.android.live.revlink.impl.multianchor.network.h(r0, r3), new i(r0, r3));
    L21:
        r0.d = r2;
        return;
    L12:
        r9 = 0;
        goto L13
    L8:
        r5 = "";
        goto L9
    }

    public MultiAnchorPkLaunchViewModelNew() {
        NextLiveData<PlayMode> r0 = new NextLiveData();
        this.playModeLiveData = r0;
        this.onPersonalPanelSelected = PublishSubject.create();
        this.onTeamPanelSelected = PublishSubject.create();
        this.personalPkSwitchMultiData = new MutableLiveData();
        this.teamPkAnchorTeamMatchData = new MutableLiveData();
        this.errorCode = new MutableLiveData();
        this.onDismissEvent = new CompletableSubject();
        k r1 = new k();
        this.pkPanelNetFacade = r1;
        this.cd = new CompositeDisposable();
        IRoom r2 = null;
        r0.setValue(null);
        Intrinsics.checkNotNullParameter(this, "listener");
        r1.l = this;
        com.bytedance.android.live.revlink.impl.multianchor.network.k r3 = r1.a;
        r3.getClass();
        Intrinsics.checkNotNullParameter(r1, "listener");
        r3.f = r1;
        i11.b r4 = r3.b;
        if (r4 == null) goto L5;
        r4.i(r3.d);
    L5:
        g r5 = r1.b;
        r5.getClass();
        Intrinsics.checkNotNullParameter(r1, "listener");
        r5.b = r1;
        com.bytedance.android.live.revenue.core.util.j.a r6 = com.bytedance.android.live.revenue.core.util.j.C0;
        yz0.k r7 = (yz0.k) f.d(r6.a(), yz0.k.class);
        if (r7 == null) goto L8;
        IRoom r8 = r7.getRoom();
    L9:
        r5.d = r8;
        j r9 = r1.c;
        r9.getClass();
        Intrinsics.checkNotNullParameter(r1, "listener");
        r9.c = r1;
        yz0.k r10 = (yz0.k) f.d(r6.a(), yz0.k.class);
        if (r10 == null) goto L12;
        r2 = r10.getRoom();
    L12:
        r9.b = r2;
        r1.d.a(r1);
        return;
    L8:
        r8 = null;
        goto L9
    }

    public void onCleared() {
        super.onCleared();
        this.cd.dispose();
        k r0 = this.pkPanelNetFacade;
        com.bytedance.android.live.revlink.impl.multianchor.network.k r1 = r0.a;
        i11.b r2 = r1.b;
        if (r2 == null) goto L5;
        r2.l(r1.d);
    L5:
        i11.b r3 = r1.c;
        if (r3 == null) goto L8;
        r3.l(r1.e);
    L8:
        r1.f = null;
        g r4 = r0.b;
        Disposable r5 = r4.c;
        if (r5 == null) goto L11;
        r5.dispose();
    L11:
        r4.c = null;
        r4.b = null;
        j r6 = r0.c;
        Disposable r7 = r6.d;
        if (r7 == null) goto L14;
        r7.dispose();
    L14:
        r6.d = null;
        r6.c = null;
        com.bytedance.android.live.revlink.impl.multianchor.network.f r8 = r0.d;
        r8.c = null;
        r8.b.clear();
        r0.l = null;
    }

    public final IBattleConfigSetting getBattleConfigSetting() {
        return this.battleConfigSetting;
    }

    public final MutableLiveData<Integer> getErrorCode() {
        return this.errorCode;
    }

    public final boolean getHasApplicant() {
        return this.hasApplicant;
    }

    public final boolean getHasInvitee() {
        return this.hasInvitee;
    }

    public final String getNpkInvitePageSource() {
        return this.npkInvitePageSource;
    }

    public final CompletableSubject getOnDismissEvent() {
        return this.onDismissEvent;
    }

    public final PublishSubject<String> getOnPersonalPanelSelected() {
        return this.onPersonalPanelSelected;
    }

    public final PublishSubject<String> getOnTeamPanelSelected() {
        return this.onTeamPanelSelected;
    }

    public final MutableLiveData<u> getPersonalPkSwitchMultiData() {
        return this.personalPkSwitchMultiData;
    }

    public final NextLiveData<PlayMode> getPlayModeLiveData() {
        return this.playModeLiveData;
    }

    public final MutableLiveData<h> getTeamPkAnchorTeamMatchData() {
        return this.teamPkAnchorTeamMatchData;
    }

    private final void updateApplyAndInviteStatus(List<? extends p> r6) {
        Iterator<T> r7 = r6.iterator();
        boolean r0 = false;
        boolean r1 = false;
    L4:
        if (r7.hasNext() == false) goto L9;
        if (((p) r7.next()).getRoleType() == 4) goto L7;
        r1 = true;
        goto L4
    L7:
        r0 = true;
        goto L4
    L9:
        this.hasApplicant = r0;
        this.hasInvitee = r1;
    }

    @Override // j21.d
    public void onInitPageFailed(int r2) {
        this.errorCode.setValue(Integer.valueOf(r2));
    }

    public final void requestSwitchPlayMode(PlayMode r3) {
        Intrinsics.checkNotNullParameter(r3, "playMode");
        if (r3 != ((PlayMode) this.playModeLiveData.getValue())) goto L5;
        return;
    L5:
        k r0 = this.pkPanelNetFacade;
        r0.getClass();
        Intrinsics.checkNotNullParameter(r3, "targetPlayMode");
        PlayMode r1 = r0.k;
        if (r1 == null) goto L12;
        if (r3 == r1) goto L13;
        r0.b.a(r3, null);
        return;
    L13:
        return;
    }

    public final void setBattleConfigSetting(IBattleConfigSetting r3) {
        this.battleConfigSetting = r3;
        k r0 = this.pkPanelNetFacade;
        r0.a.a = r3;
        r0.c.a = r3;
        r0.b.a = r3;
        r0.d.a = r3;
    }

    public final void setHasApplicant(boolean r1) {
        this.hasApplicant = r1;
    }

    public final void setHasInvitee(boolean r1) {
        this.hasInvitee = r1;
    }

    public final void setNpkInvitePageSource(String r1) {
        this.npkInvitePageSource = r1;
    }

    private final void updatePersonalModel(List<? extends p> r2, List<? extends IBaseUser> r3) {
        this.personalPkSwitchMultiData.setValue(new u(r2));
    }

    @Override // j21.d
    public void onInviteeOrApplicantListChanged(List<? extends IBaseUser> r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "inviteeList");
        PlayMode r0 = (PlayMode) this.playModeLiveData.getValue();
        if (r0 != null) goto L6;
        return;
    L6:
        if (r0 != PlayMode.TEAM_PK) goto L12;
        h r1 = (h) this.teamPkAnchorTeamMatchData.getValue();
        if (r1 == null) goto L10;
        r1.g(r3, r4);
    L10:
        this.teamPkAnchorTeamMatchData.setValue(r1);
        return;
    }

    private final void updateTeamModel(List<? extends p> r3, List<? extends IBaseUser> r4, String r5, Map<String, Long> r6) {
        this.teamPkAnchorTeamMatchData.setValue(new h(r3, r6, r4, r5));
    }

    @Override // j21.d
    public void onPersonalPageUpdate(List<? extends p> r3, List<? extends p> r4, List<? extends IBaseUser> r5, String r6) {
        Intrinsics.checkNotNullParameter(r3, "anchorList");
        Intrinsics.checkNotNullParameter(r4, "waitingList");
        Intrinsics.checkNotNullParameter(r5, "inviteeList");
        PlayMode r7 = (PlayMode) this.playModeLiveData.getValue();
        PlayMode r0 = PlayMode.PERSONAL_PK;
        this.playModeLiveData.setValue(r0);
        this.anchorList = r3;
        updateApplyAndInviteStatus(r4);
        updatePersonalModel(r3, r5);
        if (r0 == r7) goto L6;
        notifyPlayModeChanged();
        return;
    }

    @Override // j21.d
    public void onTeamPageUpdate(List<? extends p> r4, List<? extends p> r5, List<? extends IBaseUser> r6, String r7, Map<String, Long> r8, boolean r9) {
        Intrinsics.checkNotNullParameter(r4, "anchorList");
        Intrinsics.checkNotNullParameter(r5, "waitingList");
        Intrinsics.checkNotNullParameter(r6, "inviteeList");
        Intrinsics.checkNotNullParameter(r8, "userIdToTeamId");
        PlayMode r0 = (PlayMode) this.playModeLiveData.getValue();
        PlayMode r1 = PlayMode.TEAM_PK;
        if (r1 == r0) goto L5;
        boolean r2 = true;
    L6:
        this.playModeLiveData.setValue(r1);
        this.anchorList = r4;
        updateApplyAndInviteStatus(r5);
        if (r2 == true) goto L14;
        if (r9 == true) goto L14;
        h r10 = (h) this.teamPkAnchorTeamMatchData.getValue();
        if (r10 != null) goto L13;
        return;
    L13:
        r10.update(r4, r8, r6, r7);
        this.teamPkAnchorTeamMatchData.setValue(r10);
    L15:
        if (r2 == false) goto L18;
        notifyPlayModeChanged();
        return;
    L18:
        return;
    L14:
        updateTeamModel(r4, r6, r7, r8);
        goto L15
    L5:
        r2 = false;
        goto L6
    }
}
