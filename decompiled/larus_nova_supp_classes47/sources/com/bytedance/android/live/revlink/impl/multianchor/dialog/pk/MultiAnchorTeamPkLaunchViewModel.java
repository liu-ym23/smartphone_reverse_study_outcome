package com.bytedance.android.live.revlink.impl.multianchor.dialog.pk;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.bytedance.android.live.base.model.Extra;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.live.revlink.impl.LinkCrossRoomDataHolder;
import com.bytedance.android.live.revlink.impl.monitor.LiveFullLinkPKMonitor;
import com.bytedance.android.live.revlink.impl.multianchor.pk.pklaunch.MultiAnchorPkLaunchContext;
import com.bytedance.android.live.revlink.impl.multianchor.utils.y;
import com.bytedance.android.live.revlink.impl.multianchor.utils.z;
import com.bytedance.android.live.revlink.impl.utils.t;
import com.bytedance.android.livesdk.link.model.IBattleConfigSetting;
import com.bytedance.android.livesdk.link.model.bridge.r0;
import com.bytedance.android.livesdk.link.model.e7;
import com.bytedance.android.livesdk.link.model.f7;
import com.bytedance.android.livesdk.link.model.r3;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.subjects.CompletableSubject;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u009d\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\b*\u00017\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\bT\u0010UJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\u0014\u0010\n\u001a\u00020\u00042\n\u0010\t\u001a\u00060\u0007j\u0002`\bH\u0002J\u0006\u0010\u000b\u001a\u00020\u0004J\u0006\u0010\f\u001a\u00020\u0004J\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rJ\b\u0010\u0010\u001a\u00020\u0004H\u0014J\u0006\u0010\u0011\u001a\u00020\u0004R\u001d\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u00128\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R$\u0010\u0019\u001a\u0004\u0018\u00010\u00188\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR$\u0010 \u001a\u0004\u0018\u00010\u001f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u0017\u0010'\u001a\u00020&8\u0006¢\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*R\u0014\u0010,\u001a\u00020+8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b,\u0010-R\u0016\u0010/\u001a\u0004\u0018\u00010.8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b/\u00100R\u0016\u00102\u001a\u0004\u0018\u0001018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b2\u00103R\u0016\u00105\u001a\u0004\u0018\u0001048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b5\u00106R\u0014\u00108\u001a\u0002078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b8\u00109R\u0016\u0010=\u001a\u0004\u0018\u00010:8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b;\u0010<R\u0016\u0010@\u001a\u0004\u0018\u00010\u00028BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b>\u0010?R\"\u0010E\u001a\u0010\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020B\u0018\u00010A8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bC\u0010DR\u001a\u0010H\u001a\b\u0012\u0004\u0012\u00020\u000e0\r8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bF\u0010GR\u001a\u0010K\u001a\b\u0012\u0004\u0012\u00020I0\r8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bJ\u0010GR\u0016\u0010M\u001a\u0004\u0018\u00010\u001f8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bL\u0010#R\u0011\u0010Q\u001a\u00020N8F¢\u0006\u0006\u001a\u0004\bO\u0010PR\u0011\u0010S\u001a\u00020N8F¢\u0006\u0006\u001a\u0004\bR\u0010P¨\u0006V"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/multianchor/dialog/pk/MultiAnchorTeamPkLaunchViewModel;", "Landroidx/lifecycle/ViewModel;", "Lcom/bytedance/android/livesdk/link/model/e7;", "modeInfo", "", "updateTeamPkModel", "onRequestChangeMultiTeamFailed", "Lyh6/c;", "Lcom/bytedance/android/livesdk/message/model/RevenueImMessage;", "_message", "onMessage", "attach", "requestChangeMultiTeam", "", "Lcom/bytedance/android/livesdk/link/model/p;", "getCurrentAnchorList", "onCleared", "dismiss", "Landroidx/lifecycle/MutableLiveData;", "Lq21/h;", "teamPkAnchorTeamMatchData", "Landroidx/lifecycle/MutableLiveData;", "getTeamPkAnchorTeamMatchData", "()Landroidx/lifecycle/MutableLiveData;", "Lcom/bytedance/android/livesdk/link/model/IBattleConfigSetting;", "battleConfigSetting", "Lcom/bytedance/android/livesdk/link/model/IBattleConfigSetting;", "getBattleConfigSetting", "()Lcom/bytedance/android/livesdk/link/model/IBattleConfigSetting;", "setBattleConfigSetting", "(Lcom/bytedance/android/livesdk/link/model/IBattleConfigSetting;)V", "", "npkInvitePageSource", "Ljava/lang/String;", "getNpkInvitePageSource", "()Ljava/lang/String;", "setNpkInvitePageSource", "(Ljava/lang/String;)V", "Lio/reactivex/subjects/CompletableSubject;", "onDismissEvent", "Lio/reactivex/subjects/CompletableSubject;", "getOnDismissEvent", "()Lio/reactivex/subjects/CompletableSubject;", "Lio/reactivex/disposables/CompositeDisposable;", "cd", "Lio/reactivex/disposables/CompositeDisposable;", "Lcom/bytedance/android/livesdkapi/depend/model/live/IRoom;", "room", "Lcom/bytedance/android/livesdkapi/depend/model/live/IRoom;", "Lyz0/l;", "messageManager", "Lyz0/l;", "Li11/b;", "linkUserCenter", "Li11/b;", "com/bytedance/android/live/revlink/impl/multianchor/dialog/pk/MultiAnchorTeamPkLaunchViewModel$b", "linkUserCallback", "Lcom/bytedance/android/live/revlink/impl/multianchor/dialog/pk/MultiAnchorTeamPkLaunchViewModel$b;", "Lcom/bytedance/android/live/revlink/impl/multianchor/pk/pklaunch/MultiAnchorPkLaunchContext;", "getPkLaunchContext", "()Lcom/bytedance/android/live/revlink/impl/multianchor/pk/pklaunch/MultiAnchorPkLaunchContext;", "pkLaunchContext", "getMultiPKModeInfo", "()Lcom/bytedance/android/livesdk/link/model/e7;", "multiPKModeInfo", "", "", "getUserIdToTeamId", "()Ljava/util/Map;", "userIdToTeamId", "getOnlineAndWaitingList", "()Ljava/util/List;", "onlineAndWaitingList", "Lcom/bytedance/android/live/base/model/user/IBaseUser;", "getInviteeList", "inviteeList", "getBeAppliedFrom", "beAppliedFrom", "", "getHasApplicant", "()Z", "hasApplicant", "getHasInvitee", "hasInvitee", "<init>", "()V", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class MultiAnchorTeamPkLaunchViewModel extends ViewModel {
    private IBattleConfigSetting battleConfigSetting;
    private final CompositeDisposable cd;
    private final b linkUserCallback;
    private final i11.b linkUserCenter;
    private final yz0.l messageManager;
    private String npkInvitePageSource;
    private final CompletableSubject onDismissEvent;
    private final IRoom room;
    private final MutableLiveData<q21.h> teamPkAnchorTeamMatchData;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ MultiAnchorTeamPkLaunchViewModel a;

        public a(MultiAnchorTeamPkLaunchViewModel r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            com.bytedance.android.live.revlink.impl.multianchor.pk.pklaunch.g r4 = (com.bytedance.android.live.revlink.impl.multianchor.pk.pklaunch.g) sh6.c.b((sh6.b) r3);
            if (r4 != null) goto L5;
            return;
        L5:
            if (com.bytedance.android.live.revlink.impl.multianchor.pk.pklaunch.f.a(this.a.getBattleConfigSetting(), f7.a(r4.a)) == true) goto L7;
        L9:
            this.a.dismiss();
            return;
        L7:
            if (r4.a.getModeTab() != 2) goto L9;
            MultiAnchorTeamPkLaunchViewModel.access$updateTeamPkModel(this.a, r4.a);
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.revlink.impl.multianchor.dialog.pk.MultiAnchorTeamPkLaunchViewModel$attach$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\n\u0010\u0002\u001a\u00060\u0000j\u0002`\u0001¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lyh6/c;", "Lcom/bytedance/android/livesdk/message/model/RevenueImMessage;", "p1", "", "invoke", "(Lyh6/c;)V", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<yh6.c, Unit> {
        public AnonymousClass1(MultiAnchorTeamPkLaunchViewModel r8) {
            super(1, r8, MultiAnchorTeamPkLaunchViewModel.class, "onMessage", "onMessage(Lcom/bytedance/live/kmp/message/KmpImMessage;)V", 0);
        }

        public final void invoke(yh6.c r2) {
            Intrinsics.checkNotNullParameter(r2, "p1");
            MultiAnchorTeamPkLaunchViewModel.access$onMessage((MultiAnchorTeamPkLaunchViewModel) ((CallableReference) this).receiver, r2);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            invoke((yh6.c) r1);
            return Unit.INSTANCE;
        }
    }

    public static final class b extends i11.c.a {
        public final /* synthetic */ MultiAnchorTeamPkLaunchViewModel a;

        public b(MultiAnchorTeamPkLaunchViewModel r1) {
            this.a = r1;
        }

        @Override // i11.c.a, i11.c.b
        public final void e(String r3) {
            q21.h r0 = (q21.h) this.a.getTeamPkAnchorTeamMatchData().getValue();
            if (r0 == null) goto L5;
            r0.g(MultiAnchorTeamPkLaunchViewModel.access$getInviteeList$p(this.a), r3);
        L5:
            this.a.getTeamPkAnchorTeamMatchData().setValue(r0);
        }

        @Override // i11.c.a, i11.c.b
        public final void c(int r2, List<? extends IBaseUser> r3) {
            q21.h r4 = (q21.h) this.a.getTeamPkAnchorTeamMatchData().getValue();
            if (r4 == null) goto L5;
            r4.g(MultiAnchorTeamPkLaunchViewModel.access$getInviteeList$p(this.a), MultiAnchorTeamPkLaunchViewModel.access$getBeAppliedFrom$p(this.a));
        L5:
            this.a.getTeamPkAnchorTeamMatchData().setValue(r4);
        }

        @Override // i11.c.a, i11.c.b
        public final void d(int r4, List<? extends com.bytedance.android.livesdk.link.model.p> r5) {
            Intrinsics.checkNotNullParameter(r5, "list");
            CopyOnWriteArrayList r6 = (CopyOnWriteArrayList) r5;
            if (r6.size() > 2) goto L5;
            this.a.dismiss();
        L5:
            Map<String, Long> r7 = MultiAnchorTeamPkLaunchViewModel.access$getUserIdToTeamId$p(this.a);
            if (r7 == null) goto L12;
            q21.h r0 = (q21.h) this.a.getTeamPkAnchorTeamMatchData().getValue();
            if (r0 == null) goto L10;
            r0.update(r6, r7, MultiAnchorTeamPkLaunchViewModel.access$getInviteeList$p(this.a), MultiAnchorTeamPkLaunchViewModel.access$getBeAppliedFrom$p(this.a));
        L10:
            this.a.getTeamPkAnchorTeamMatchData().setValue(r0);
            return;
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ MultiAnchorTeamPkLaunchViewModel a;
        public final /* synthetic */ long b;

        public c(MultiAnchorTeamPkLaunchViewModel r1, long r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r10) {
            ExtraResponse r12 = (ExtraResponse) r10;
            LiveFullLinkPKMonitor r0 = com.bytedance.android.live.revlink.impl.global.b.q();
            if (r0 == null) goto L5;
            LiveFullLinkPKMonitor.s(r0, "linkmic/change_multi_pk_team", t.a(this.b), 0, 0, null, 28);
        L5:
            z r1 = com.bytedance.android.live.revlink.impl.global.b.J();
            e7 r2 = null;
            if (r1 == null) goto L12;
            LinkCrossRoomDataHolder r3 = com.bytedance.android.live.revlink.impl.global.b.j();
            if (r3 == null) goto L10;
            long r4 = r3.c();
        L11:
            int r5 = z.f;
            r1.n(r4, null);
            goto L12
        L10:
            r4 = 0;
        L12:
            if (r12 == null) goto L16;
            r3 r13 = (r3) r12.data;
            if (r13 == null) goto L16;
            r2 = r13.getMultiPKModeInfo();
        L16:
            e7 r6 = r2;
            if (r6 == null) goto L21;
            MultiAnchorPkLaunchContext r7 = com.bytedance.android.live.revlink.impl.global.b.x();
            if (r7 == null) goto L23;
            MultiAnchorPkLaunchContext.updateMultiPkModeInfo$default(r7, r6, null, "changeTeam", null, 8, null);
            return;
        L23:
            return;
        L21:
            MultiAnchorTeamPkLaunchViewModel.access$onRequestChangeMultiTeamFailed(this.a);
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ MultiAnchorTeamPkLaunchViewModel a;
        public final /* synthetic */ long b;

        public d(MultiAnchorTeamPkLaunchViewModel r1, long r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r10) {
            Throwable r12 = (Throwable) r10;
            LiveFullLinkPKMonitor r0 = com.bytedance.android.live.revlink.impl.global.b.q();
            if (r0 == null) goto L5;
            LiveFullLinkPKMonitor.r(r0, "linkmic/change_multi_pk_team", r12, t.a(this.b), 0, 0, null, 56);
        L5:
            z r1 = com.bytedance.android.live.revlink.impl.global.b.J();
            if (r1 == null) goto L12;
            LinkCrossRoomDataHolder r2 = com.bytedance.android.live.revlink.impl.global.b.j();
            if (r2 == null) goto L10;
            long r3 = r2.c();
        L11:
            r1.n(r3, r12);
            goto L12
        L10:
            r3 = 0;
        L12:
            com.bytedance.android.live.revenue.common.k.a(s1.getContext(), r12);
            MultiAnchorTeamPkLaunchViewModel.access$onRequestChangeMultiTeamFailed(this.a);
        }
    }

    private final String getBeAppliedFrom() {
        i11.b r0 = this.linkUserCenter;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.w();
    }

    private final List<IBaseUser> getInviteeList() {
        i11.b r0 = this.linkUserCenter;
        if (r0 == null) goto L7;
        List<IBaseUser> r1 = r0.getInviteeList();
        if (r1 == null) goto L7;
        return r1;
    L7:
        return new ArrayList();
    }

    private final List<com.bytedance.android.livesdk.link.model.p> getOnlineAndWaitingList() {
        i11.b r0 = this.linkUserCenter;
        if (r0 == null) goto L9;
        List<com.bytedance.android.livesdk.link.model.p> r1 = r0.d();
        if (r1 == null) goto L9;
        List<com.bytedance.android.livesdk.link.model.p> r2 = CollectionsKt.toList(r1);
        if (r2 == null) goto L9;
        return r2;
    L9:
        return CollectionsKt.emptyList();
    }

    private final void onRequestChangeMultiTeamFailed() {
        q21.h r0 = (q21.h) this.teamPkAnchorTeamMatchData.getValue();
        if (r0 == null) goto L6;
        this.teamPkAnchorTeamMatchData.setValue(r0);
        return;
    }

    public final void attach() {
        i11.b r0 = this.linkUserCenter;
        if (r0 == null) goto L5;
        r0.i(this.linkUserCallback);
    L5:
        yz0.l r1 = this.messageManager;
        boolean r2 = false;
        if (r1 == null) goto L12;
        com.bytedance.android.live.revenue.common.message.b.T.getClass();
        Observable r3 = yz0.h.a.a(r1, com.bytedance.android.live.revenue.common.message.b.e, false, 6);
        if (r3 == null) goto L12;
        final AnonymousClass1 r4 = new AnonymousClass1(this);
        Disposable r5 = r3.subscribe(new e(r4));
        if (r5 == null) goto L12;
        RxUtilKt.c(r5, this.cd);
    L12:
        jy0.b.d("ttlive_anchor_link_panel", "TeamPkLaunchViewModel attach " + getMultiPKModeInfo() + ' ' + i11.a.c(getOnlineAndWaitingList()));
        List<com.bytedance.android.livesdk.link.model.p> r6 = getOnlineAndWaitingList();
        if (r6 != null) goto L15;
    L18:
        boolean r7 = true;
    L19:
        if (r7 == false) goto L23;
        i11.b r8 = this.linkUserCenter;
        if (r8 == null) goto L37;
        r8.b(4, "show_multi_pk_mode_panel");
    L37:
        MultiAnchorPkLaunchContext r9 = getPkLaunchContext();
        if (r9 == null) goto L47;
        com.bytedance.live.datacontext.n<com.bytedance.android.live.revlink.impl.multianchor.pk.pklaunch.g> r10 = r9.getMultiPkModeInfo();
        if (r10 == null) goto L48;
        Observable r12 = r10.a();
        if (r12 == null) goto L49;
        Disposable r13 = r12.subscribe(new a(this));
        if (r13 == null) goto L50;
        this.cd.add(r13);
        return;
    L50:
        return;
    L49:
        return;
    L48:
        return;
    L47:
        return;
    L23:
        e7 r14 = getMultiPKModeInfo();
        if (r14 == null) goto L37;
        if (r14.getModeTab() != 2) goto L37;
        Map<String, Long> r15 = getUserIdToTeamId();
        if (r15 != null) goto L30;
    L31:
        r2 = true;
    L32:
        if (r2 == true) goto L37;
        MutableLiveData<q21.h> r16 = this.teamPkAnchorTeamMatchData;
        List<com.bytedance.android.livesdk.link.model.p> r17 = getOnlineAndWaitingList();
        Map<String, Long> r18 = getUserIdToTeamId();
        if (r18 != null) goto L36;
        r18 = MapsKt.emptyMap();
    L36:
        r16.postValue(new q21.h(r17, r18, getInviteeList(), getBeAppliedFrom()));
        goto L37
    L30:
        if (r15.isEmpty() == false) goto L32;
    L15:
        if (r6.isEmpty() == true) goto L18;
        r7 = false;
        goto L19
    }

    public final void dismiss() {
        this.onDismissEvent.onComplete();
    }

    public final boolean getHasApplicant() {
        i11.b r0 = this.linkUserCenter;
        if (r0 == null) goto L13;
        List<com.bytedance.android.livesdk.link.model.p> r1 = r0.a();
        if (r1 == null) goto L18;
        Iterator<T> r2 = r1.iterator();
    L8:
        if (r2.hasNext() == false) goto L19;
        if (((com.bytedance.android.livesdk.link.model.p) r2.next()).getRoleType() != 4) goto L8;
        return true;
    L19:
        return false;
    L18:
        return false;
    L13:
        return false;
    }

    public final boolean getHasInvitee() {
        i11.b r0 = this.linkUserCenter;
        if (r0 == null) goto L13;
        List<com.bytedance.android.livesdk.link.model.p> r1 = r0.a();
        if (r1 == null) goto L18;
        Iterator<T> r2 = r1.iterator();
    L8:
        if (r2.hasNext() == false) goto L19;
        if (((com.bytedance.android.livesdk.link.model.p) r2.next()).getRoleType() == 4) goto L8;
        return true;
    L19:
        return false;
    L18:
        return false;
    L13:
        return false;
    }

    public MultiAnchorTeamPkLaunchViewModel() {
        this.teamPkAnchorTeamMatchData = new MutableLiveData();
        this.onDismissEvent = new CompletableSubject();
        this.cd = new CompositeDisposable();
        com.bytedance.android.live.revenue.core.util.j.a r0 = com.bytedance.android.live.revenue.core.util.j.C0;
        yz0.k r1 = (yz0.k) com.bytedance.android.live.revenue.core.util.f.d(r0.a(), yz0.k.class);
        if (r1 == null) goto L5;
        IRoom r2 = r1.getRoom();
    L6:
        this.room = r2;
        this.messageManager = (yz0.l) com.bytedance.android.live.revenue.core.util.f.d(r0.a(), yz0.l.class);
        this.linkUserCenter = y.a();
        this.linkUserCallback = new b(this);
        return;
    L5:
        r2 = null;
        goto L6
    }

    private final e7 getMultiPKModeInfo() {
        MultiAnchorPkLaunchContext r0 = getPkLaunchContext();
        if (r0 == null) goto L9;
        com.bytedance.live.datacontext.n<com.bytedance.android.live.revlink.impl.multianchor.pk.pklaunch.g> r1 = r0.getMultiPkModeInfo();
        if (r1 == null) goto L9;
        com.bytedance.android.live.revlink.impl.multianchor.pk.pklaunch.g r2 = (com.bytedance.android.live.revlink.impl.multianchor.pk.pklaunch.g) r1.getValue();
        if (r2 == null) goto L9;
        return r2.a;
    L9:
        return null;
    }

    private final MultiAnchorPkLaunchContext getPkLaunchContext() {
        return com.bytedance.android.live.revlink.impl.global.b.x();
    }

    private final Map<String, Long> getUserIdToTeamId() {
        e7 r0 = getMultiPKModeInfo();
        if (r0 == null) goto L5;
        Intrinsics.checkNotNullParameter(r0, "$this$userIdToTeamId");
        return r0.getRevUserIdToTeamId();
    L5:
        return null;
    }

    public final List<com.bytedance.android.livesdk.link.model.p> getCurrentAnchorList() {
        List<com.bytedance.android.livesdk.link.model.p> r1 = null;
        if (y.d() == false) goto L7;
        com.bytedance.android.live.revlink.impl.pk.service.b r0 = com.bytedance.android.live.revlink.impl.global.b.N();
        if (r0 == null) goto L12;
        r1 = r0.getCurrentAnchorList();
    L12:
        if (r1 == null) goto L14;
        return r1;
    L14:
        return CollectionsKt.emptyList();
    L7:
        i11.b r2 = this.linkUserCenter;
        if (r2 == null) goto L12;
        List<com.bytedance.android.livesdk.link.model.p> r3 = r2.getOnlineUserList();
        if (r3 == null) goto L12;
        r1 = CollectionsKt.toList(r3);
        goto L12
    }

    public void onCleared() {
        super.onCleared();
        this.cd.dispose();
        i11.b r0 = this.linkUserCenter;
        if (r0 == null) goto L6;
        r0.l(this.linkUserCallback);
        return;
    }

    public final void requestChangeMultiTeam() {
        long r0 = System.currentTimeMillis();
        IBattleConfigSetting r2 = this.battleConfigSetting;
        if (r2 == null) goto L5;
        String r3 = com.bytedance.android.live.revlink.impl.utils.e.b(r2);
    L6:
        String r8 = r3;
        r31.a r4 = r31.b.a(r31.a.a);
        LinkCrossRoomDataHolder r5 = com.bytedance.android.live.revlink.impl.global.b.j();
        long r6 = 0;
        if (r5 == null) goto L9;
        long r7 = r5.c();
    L10:
        IRoom r9 = this.room;
        if (r9 == null) goto L13;
        r6 = r9.getRoomId();
    L13:
        Observable<ExtraResponse<r3, Extra>> r10 = r4.n(r7, r6, r8);
        if (r10 == null) goto L21;
        Observable r12 = r10.compose(RxUtil.rxSchedulerHelper());
        if (r12 == null) goto L22;
        Disposable r1 = r12.subscribe(new c(this, r0), new d(this, r0));
        if (r1 == null) goto L23;
        this.cd.add(r1);
        return;
    L23:
        return;
    L22:
        return;
    L21:
        return;
    L9:
        r7 = 0;
        goto L10
    L5:
        r3 = "";
        goto L6
    }

    public final IBattleConfigSetting getBattleConfigSetting() {
        return this.battleConfigSetting;
    }

    public final String getNpkInvitePageSource() {
        return this.npkInvitePageSource;
    }

    public final CompletableSubject getOnDismissEvent() {
        return this.onDismissEvent;
    }

    public final MutableLiveData<q21.h> getTeamPkAnchorTeamMatchData() {
        return this.teamPkAnchorTeamMatchData;
    }

    public static final /* synthetic */ String access$getBeAppliedFrom$p(MultiAnchorTeamPkLaunchViewModel r0) {
        return r0.getBeAppliedFrom();
    }

    public static final /* synthetic */ List access$getInviteeList$p(MultiAnchorTeamPkLaunchViewModel r0) {
        return r0.getInviteeList();
    }

    public static final /* synthetic */ Map access$getUserIdToTeamId$p(MultiAnchorTeamPkLaunchViewModel r0) {
        return r0.getUserIdToTeamId();
    }

    public static final /* synthetic */ void access$onRequestChangeMultiTeamFailed(MultiAnchorTeamPkLaunchViewModel r0) {
        r0.onRequestChangeMultiTeamFailed();
    }

    private final void onMessage(yh6.c r1) {
        if ((r1 instanceof r0) == false) goto L6;
        dismiss();
        return;
    }

    private final void updateTeamPkModel(e7 r5) {
        Intrinsics.checkNotNullParameter(r5, "$this$userIdToTeamId");
        Map<String, Long> r6 = r5.getRevUserIdToTeamId();
        if (r6 != null) goto L5;
        return;
    L5:
        q21.h r0 = (q21.h) this.teamPkAnchorTeamMatchData.getValue();
        if (r0 == null) goto L8;
        r0.update(getOnlineAndWaitingList(), r6, getInviteeList(), getBeAppliedFrom());
    L9:
        this.teamPkAnchorTeamMatchData.setValue(r0);
        return;
    L8:
        r0 = new q21.h(getOnlineAndWaitingList(), r6, getInviteeList(), getBeAppliedFrom());
        goto L9
    }

    public final void setBattleConfigSetting(IBattleConfigSetting r1) {
        this.battleConfigSetting = r1;
    }

    public final void setNpkInvitePageSource(String r1) {
        this.npkInvitePageSource = r1;
    }

    public static final /* synthetic */ void access$onMessage(MultiAnchorTeamPkLaunchViewModel r0, yh6.c r1) {
        r0.onMessage(r1);
    }

    public static final /* synthetic */ void access$updateTeamPkModel(MultiAnchorTeamPkLaunchViewModel r0, e7 r1) {
        r0.updateTeamPkModel(r1);
    }
}
