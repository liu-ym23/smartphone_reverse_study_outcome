package com.bytedance.android.live.revlink.impl.multianchor.pk.pklaunch;

import android.content.DialogInterface;
import android.text.TextUtils;
import androidx.fragment.app.DialogFragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.base.model.Extra;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.tetris.widgets.LiveWidget;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.android.live.revenue.common.ToastUtil;
import com.bytedance.android.live.revenue.common.b0;
import com.bytedance.android.live.revenue.common.k;
import com.bytedance.android.live.revenue.common.x0;
import com.bytedance.android.live.revenue.platform.hybrid.impl.ui.HybridDialogImpl;
import com.bytedance.android.live.revlink.impl.LinkCrossRoomDataHolder;
import com.bytedance.android.live.revlink.impl.lynxcontainer.PkLynxDataContext_androidKt$convertPkBaseStateToInt$$inlined$also$lambda$1;
import com.bytedance.android.live.revlink.impl.mergepk.pkbase.PkBaseDataContext;
import com.bytedance.android.live.revlink.impl.mergepk.pkbase.statemachine.PkBaseStateMachine;
import com.bytedance.android.live.revlink.impl.monitor.LiveFullLinkPKMonitor;
import com.bytedance.android.live.revlink.impl.multianchor.dialog.AnchorLinkTopViewConfirmationDialog;
import com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt.MultiAnchorLinkUserInviteDialog;
import com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt.MultiAnchorPkLaunchDialogNew;
import com.bytedance.android.live.revlink.impl.multianchor.dialog.pk.MultiAnchorPersonalPkLaunchDialogV2;
import com.bytedance.android.live.revlink.impl.multianchor.dialog.pk.MultiAnchorTeamPkLaunchDialogV2;
import com.bytedance.android.live.revlink.impl.multianchor.dialog.pk.MultiAnchorTeamPkMatchingDialog;
import com.bytedance.android.live.revlink.impl.multianchor.dialog.pk.MultiAnchorTeamPkUserInviteDialog;
import com.bytedance.android.live.revlink.impl.multianchor.pk.pklaunch.presenter.MultiPkLaunchPresenter;
import com.bytedance.android.live.revlink.impl.multianchor.utils.y;
import com.bytedance.android.live.revlink.impl.multianchor.utils.z;
import com.bytedance.android.live.revlink.impl.multianchor.vm.LinkingInvitePreloadUtils;
import com.bytedance.android.live.revlink.impl.multianchor.vm.MultiLinkAnchorControlContext;
import com.bytedance.android.live.revlink.impl.pk.utils.q;
import com.bytedance.android.live.revlink.impl.pk.vm.linkout.PkCustomizePlayDataContext;
import com.bytedance.android.live.revlink.impl.utils.t;
import com.bytedance.android.live.revlink.impl.utils.u;
import com.bytedance.android.live.revlink.link.biz.component.MultiPKLauncher;
import com.bytedance.android.livesdk.LiveDialogFragment;
import com.bytedance.android.livesdk.link.model.IBattleConfigSetting;
import com.bytedance.android.livesdk.link.model.ILinkMicBattleInviteMessage;
import com.bytedance.android.livesdk.link.model.IRivalRankRecommendResponse;
import com.bytedance.android.livesdk.link.model.aa;
import com.bytedance.android.livesdk.link.model.api.IBaseBattleSetting;
import com.bytedance.android.livesdk.link.model.d4;
import com.bytedance.android.livesdk.link.model.e7;
import com.bytedance.android.livesdk.link.model.f7;
import com.bytedance.android.livesdk.link.model.h9;
import com.bytedance.android.livesdk.link.model.q3;
import com.bytedance.android.livesdk.link.model.u2;
import com.bytedance.android.livesdk.link.model.v3;
import com.bytedance.android.livesdk.link.model.w2;
import com.bytedance.android.livesdk.p8;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.badger.collect.impl.constants.Constants;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.live.datacontext.DataContext;
import com.bytedance.live.datacontext.j;
import com.bytedance.live.datacontext.m;
import com.bytedance.live.datacontext.n;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.revenue.platform.api.core.rx.l;
import com.bytedance.revenue.platform.api.core.rx.p;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import gd0.v;
import h31.h;
import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006B\u0007¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/multianchor/pk/pklaunch/MultiAnchorPkLaunchControlWidget;", "Lcom/bytedance/android/live/core/tetris/widgets/LiveWidget;", "Lcom/bytedance/android/live/revlink/impl/multianchor/service/c;", "Lcom/bytedance/android/live/revlink/impl/multianchor/pk/pklaunch/presenter/MultiPkLaunchPresenter$a;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "Lcom/bytedance/revenue/platform/api/core/android/lifecycle/Observer;", "<init>", "()V", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class MultiAnchorPkLaunchControlWidget extends LiveWidget implements com.bytedance.android.live.revlink.impl.multianchor.service.c, MultiPkLaunchPresenter.a, Observer<KVData> {
    public IRoom a;
    public final CompositeDisposable b;
    public MultiAnchorPkLaunchContext c;
    public MultiPkLaunchPresenter d;
    public LiveDialogFragment e;
    public LiveDialogFragment f;
    public MultiAnchorTeamPkMatchingDialog g;
    public zy0.d h;
    public zy0.d i;
    public i11.b j;
    public final CompositeDisposable k;
    public final d l;
    public final a m;

    public static final class a extends i11.c.a {
        public final /* synthetic */ MultiAnchorPkLaunchControlWidget a;

        @Override // i11.c.a, i11.c.b
        public final void f() {
            zy0.d r0 = this.a.h;
            if (r0 == null) goto L16;
            JSONObject r1 = new JSONObject();
            r1.put("type", "is_organizer");
            com.bytedance.android.live.revlink.impl.multianchor.service.d r2 = com.bytedance.android.live.revlink.impl.global.b.z();
            if (r2 == null) goto L11;
            i11.b r3 = r2.getLinkUserCenter();
            if (r3 == null) goto L11;
            if (r3.N(u.e()) != true) goto L11;
            String r4 = DataType.TRUE;
        L12:
            r1.put(Constants.Keys.DATA, r4);
            xy0.a<?> r5 = r0.g();
            if (r5 == null) goto L17;
            r5.sendJsEvent("H5_webcastNotification", r1);
            return;
        L17:
            return;
        L11:
            r4 = DataType.FALSE;
            goto L12
        }

        public a(MultiAnchorPkLaunchControlWidget r1) {
            this.a = r1;
        }

        @Override // i11.c.a, i11.c.b
        public final void i(int r1) {
            MultiAnchorPkLaunchControlWidget.xq(this.a);
        }

        @Override // i11.c.a, i11.c.b
        public final void a(int r1, List r2) {
            MultiAnchorPkLaunchControlWidget.xq(this.a);
        }
    }

    public static final class b implements DialogInterface.OnDismissListener {
        public final /* synthetic */ MultiAnchorPkLaunchControlWidget a;
        public final /* synthetic */ MultiAnchorTeamPkLaunchDialogV2 b;

        public b(MultiAnchorPkLaunchControlWidget r1, MultiAnchorTeamPkLaunchDialogV2 r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public final void onDismiss(DialogInterface r2) {
            if (Intrinsics.areEqual(this.a.e, this.b) == false) goto L6;
            this.a.e = null;
            return;
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ MultiAnchorPkLaunchControlWidget a;

        public c(MultiAnchorPkLaunchControlWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r12) {
            g r13 = (g) sh6.c.b((sh6.b) r12);
            if (r13 == null) goto L97;
            MultiAnchorPkLaunchControlWidget r0 = this.a;
            r0.getClass();
            Intrinsics.checkNotNullParameter(r13, "detail");
            e7 r1 = r13.a;
            if (y.c() == false) goto L103;
            LiveDialogFragment r2 = r0.e;
            boolean r4 = true;
            if ((r2 instanceof MultiAnchorPkLaunchDialogNew) == false) goto L21;
            IBattleConfigSetting r3 = f7.a(r1);
            LiveDialogFragment r5 = r0.e;
            if (r5 != null) goto L12;
        L16:
            boolean r6 = false;
        L17:
            if (r6 == true) goto L104;
            r0.Bp();
        L39:
            MultiAnchorPkLaunchContext r7 = r0.c;
            if (r7 == null) goto L44;
            n<g> r8 = r7.getLastMultiPkModeInfo();
            if (r8 == null) goto L44;
            g r9 = (g) r8.getValue();
        L45:
            if (r9 == null) goto L55;
            e7 r10 = r9.a;
            if (r10 == null) goto L55;
            if (r10.getModeTab() != r1.getModeTab()) goto L55;
            if (com.bytedance.android.live.revlink.impl.multianchor.pk.pklaunch.f.a(f7.a(r9.a), f7.a(r1)) == false) goto L55;
            if (r9.a.getVersion() != r1.getVersion()) goto L55;
            boolean r14 = true;
        L56:
            if (r14 == true) goto L106;
            IBattleConfigSetting r15 = f7.a(r1);
            if (r15 == null) goto L76;
            if (r15.getModType() != PkBaseDataContext.PKModType.SeasonRank.getType()) goto L76;
            if (Intrinsics.areEqual(r13.c, Boolean.TRUE) == false) goto L76;
            if ((r0.e instanceof MultiAnchorPkLaunchDialogNew) == true) goto L98;
            String r16 = r13.b;
            if (r16 != null) goto L69;
        L72:
            if (r4 == true) goto L107;
            r0.U5(f7.a(r1), null);
            return;
        L107:
            return;
        L69:
            if (r16.length() == 0) goto L72;
            r4 = false;
            goto L72
        L98:
            return;
        L76:
            if (r1.getModeTab() != 2) goto L100;
            int r17 = r1.getSwitchSource();
            e7.Companion.getClass();
            if (r17 != 1) goto L81;
            r0.Ob();
        L81:
            if ((r0.e instanceof MultiAnchorTeamPkLaunchDialogV2) == true) goto L101;
            String r18 = r13.b;
            if (r18 != null) goto L85;
        L88:
            boolean r19 = true;
        L89:
            if (r19 == true) goto L108;
            LiveDialogFragment r110 = r0.f;
            if (r110 != null) goto L94;
        L95:
            com.bytedance.android.live.revlink.impl.multianchor.service.c.a.b(r0, false, f7.a(r1), 4);
            return;
        L94:
            if (r110.isShowing() != true) goto L95;
            return;
        L108:
            return;
        L85:
            if (r18.length() == 0) goto L88;
            r19 = false;
            goto L89
        L101:
            return;
        L100:
            return;
        L106:
            return;
        L55:
            r14 = false;
        L44:
            r9 = null;
            goto L45
        L104:
            return;
        L12:
            if ((r5 instanceof MultiAnchorPkLaunchDialogNew) == false) goto L16;
            if (com.bytedance.android.live.revlink.impl.multianchor.pk.pklaunch.f.a(((MultiAnchorPkLaunchDialogNew) r5).g, r3) == false) goto L16;
            r6 = true;
            goto L17
        L21:
            if ((r2 instanceof MultiAnchorPersonalPkLaunchDialogV2) == false) goto L23;
        L24:
            int r20 = r1.getModeTab();
            IBattleConfigSetting r22 = f7.a(r1);
            LiveDialogFragment r23 = r0.e;
            if (r23 == null) goto L35;
            if (r20 == 1) goto L29;
        L31:
            if (r20 != 2) goto L35;
            if ((r23 instanceof MultiAnchorTeamPkLaunchDialogV2) == false) goto L35;
            boolean r24 = com.bytedance.android.live.revlink.impl.multianchor.pk.pklaunch.f.a(((MultiAnchorTeamPkLaunchDialogV2) r23).g, r22);
        L36:
            if (r24 == true) goto L105;
            r0.Bp();
            goto L39
        L105:
            return;
        L29:
            if ((r23 instanceof MultiAnchorPersonalPkLaunchDialogV2) == false) goto L31;
            r24 = com.bytedance.android.live.revlink.impl.multianchor.pk.pklaunch.f.a(null, r22);
        L35:
            r24 = false;
            goto L36
        L23:
            if ((r2 instanceof MultiAnchorTeamPkLaunchDialogV2) == false) goto L39;
        L103:
            return;
        }
    }

    public static final class d<T> implements Observer {
        public final /* synthetic */ MultiAnchorPkLaunchControlWidget a;

        public d(MultiAnchorPkLaunchControlWidget r1) {
            this.a = r1;
        }

        public final void onChanged(Object r5) {
            String r6 = (String) r5;
            zy0.d r0 = this.a.h;
            if (r0 == null) goto L8;
            JSONObject r1 = new JSONObject();
            r1.put("type", "pk_status");
            r1.put(Constants.Keys.DATA, r6);
            xy0.a<?> r7 = r0.g();
            if (r7 == null) goto L9;
            r7.sendJsEvent("H5_webcastNotification", r1);
            return;
        L9:
            return;
        }
    }

    public static final class e<T> implements Consumer {
        public final /* synthetic */ MultiAnchorPkLaunchControlWidget a;
        public final /* synthetic */ long b;
        public final /* synthetic */ int c;

        public e(MultiAnchorPkLaunchControlWidget r1, long r2, int r4) {
            this.a = r1;
            this.b = r2;
            this.c = r4;
        }

        public final void accept(Object r9) {
            ExtraResponse r10 = (ExtraResponse) r9;
            LiveFullLinkPKMonitor r0 = com.bytedance.android.live.revlink.impl.global.b.q();
            if (r0 == null) goto L5;
            LiveFullLinkPKMonitor.s(r0, "linkmic/change_multi_pk_mode_tab", System.currentTimeMillis() - this.b, 0, 0, null, 28);
        L5:
            z r1 = com.bytedance.android.live.revlink.impl.global.b.J();
            if (r1 == null) goto L12;
            LinkCrossRoomDataHolder r2 = com.bytedance.android.live.revlink.impl.global.b.j();
            if (r2 == null) goto L10;
            long r3 = r2.c();
        L11:
            String r4 = String.valueOf(this.c);
            int r5 = z.f;
            r1.m(r3, r4, null);
            goto L12
        L10:
            r3 = 0;
        L12:
            if (r10 == null) goto L21;
            q3 r12 = (q3) r10.data;
            if (r12 == null) goto L22;
            e7 r6 = r12.getMultiPKModeInfo();
            if (r6 == null) goto L23;
            MultiAnchorPkLaunchContext r7 = this.a.c;
            if (r7 == null) goto L24;
            MultiAnchorPkLaunchContext.updateMultiPkModeInfo$default(r7, r6, null, "switchPkMode", null, 8, null);
            return;
        L24:
            return;
        L23:
            return;
        L22:
            return;
        }
    }

    public static final class f<T> implements Consumer {
        public final /* synthetic */ int a;
        public final /* synthetic */ long b;

        public f(int r1, long r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r10) {
            Throwable r12 = (Throwable) r10;
            z r0 = com.bytedance.android.live.revlink.impl.global.b.J();
            if (r0 == null) goto L9;
            LinkCrossRoomDataHolder r1 = com.bytedance.android.live.revlink.impl.global.b.j();
            if (r1 == null) goto L7;
            long r2 = r1.c();
        L8:
            r0.m(r2, String.valueOf(this.a), r12);
            goto L9
        L7:
            r2 = 0;
        L9:
            LiveFullLinkPKMonitor r3 = com.bytedance.android.live.revlink.impl.global.b.q();
            if (r3 == null) goto L12;
            LiveFullLinkPKMonitor.r(r3, "linkmic/change_multi_pk_mode_tab", r12, System.currentTimeMillis() - this.b, 0, 0, null, 56);
        L12:
            k.a(s1.getContext(), r12);
        }
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.service.c
    public final void Bp() {
        LiveDialogFragment r0 = this.e;
        if (r0 == null) goto L5;
        wq(r0);
    L5:
        this.e = null;
    }

    public final LinkingInvitePreloadUtils Bq() {
        MultiAnchorPkLaunchContext r0 = this.c;
        if (r0 == null) goto L7;
        j<LinkingInvitePreloadUtils> r1 = r0.getLinkingInvitePreloadUtils();
        if (r1 == null) goto L7;
        return (LinkingInvitePreloadUtils) r1.getValue();
    L7:
        return null;
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.service.c
    public final void Da() {
        LiveDialogFragment r1 = this.f;
        if (r1 == null) goto L8;
        if (r1.isShowing() != true) goto L8;
        return;
    L8:
        if (com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt.d.a() == false) goto L10;
        int r2 = 3;
    L11:
        com.bytedance.android.live.revlink.impl.multianchor.vm.f r3 = com.bytedance.android.live.revlink.impl.global.b.p();
        if (r3 != null) goto L14;
    L62:
        b51.b r4 = b51.b.c0;
        r4.getClass();
        ReadOnlyProperty r5 = b51.b.G;
        KProperty[] r6 = b51.b.a;
        if (((Boolean) r5.getValue(r4, r6[31])).booleanValue() == false) goto L74;
        String r7 = (String) b51.b.H.getValue(r4, r6[32]);
        if (TextUtils.isEmpty(r7) == true) goto L74;
        x0 r8 = new x0(r7);
        x0 r9 = r8.d("url");
        IRoom r10 = this.a;
        if (r10 == null) goto L69;
        Long r12 = Long.valueOf(r10.getRoomId());
    L70:
        r9.b("room_id", String.valueOf(r12));
        r9.b("business_type", r41.b.a());
        r9.b("group", r41.b.a());
        HybridDialogImpl r13 = ((vy0.b) com.bytedance.android.live.revenue.core.util.f.a(vy0.c.class)).U0(((Widget) this).context, r8.c(), null);
        this.i = r13;
        if (r13 == null) goto L78;
        r13.j0(new MultiAnchorPkLaunchControlWidget$launchInvitePanel$1(this));
        return;
    L78:
        return;
    L69:
        r12 = null;
    L74:
        int r14 = MultiAnchorLinkUserInviteDialog.w;
        DataCenter r15 = ((Widget) this).dataCenter;
        MultiAnchorLinkUserInviteDialog r16 = new MultiAnchorLinkUserInviteDialog();
        r16.f = r15;
        r16.m = 1;
        this.f = r16;
        p8.a(r16, ((Widget) this).context);
        LinkingInvitePreloadUtils r17 = Bq();
        if (r17 == null) goto L79;
        r17.a++;
        l51.a.U.setValue(null, l51.a.a[49], Boolean.TRUE);
        return;
    L79:
        return;
    L14:
        if (r3.a() == true) goto L16;
    L18:
        boolean r18 = false;
    L19:
        if (r18 != true) goto L62;
        LinkingInvitePreloadUtils r19 = Bq();
        if (r19 != null) goto L23;
    L31:
        LinkingInvitePreloadUtils r20 = Bq();
        if (r20 == null) goto L34;
        Pair<String, IRivalRankRecommendResponse> r22 = r20.a(r2);
    L35:
        if (r22 == null) goto L62;
    L36:
        LinkingInvitePreloadUtils r23 = Bq();
        if (r23 == null) goto L62;
        com.bytedance.android.live.revlink.impl.multianchor.vm.f r24 = r23.c();
        if (r24 != null) goto L41;
    L61:
        r23.h();
        goto L62
    L41:
        if (r24.a() == true) goto L43;
    L45:
        boolean r25 = false;
    L46:
        if (r25 != true) goto L61;
        if (r23.f().length() <= 0) goto L50;
        boolean r26 = true;
    L51:
        if (r26 == true) goto L62;
        b51.b r27 = b51.b.c0;
        long r110 = r27.d().getInterval();
        int r28 = r27.d().getCount();
        Disposable r29 = r23.h;
        if (r29 == null) goto L56;
        r29.dispose();
    L56:
        r23.i = false;
        if (r28 >= 0) goto L59;
        l r30 = l.a;
        int r32 = p.a;
        Observable r33 = Observable.interval(0, r110, TimeUnit.MILLISECONDS, Schedulers.computation());
    L60:
        r23.h = r33.observeOn(AndroidSchedulers.mainThread()).subscribe(new com.bytedance.android.live.revlink.impl.multianchor.vm.e(r23));
        goto L62
    L59:
        l r34 = l.a;
        long r111 = 0;
        long r35 = r28;
        int r36 = p.a;
        Scheduler r37 = Schedulers.computation();
        Intrinsics.checkNotNullParameter(r37, "scheduler");
        r33 = Observable.intervalRange(r111, r35, r111, r110, TimeUnit.MILLISECONDS, r37);
        goto L60
    L50:
        r26 = false;
        goto L51
    L43:
        if (b51.b.c0.d().getInterval() <= 0) goto L45;
        r25 = true;
        goto L46
    L34:
        r22 = null;
        goto L35
    L23:
        if (t.a(r19.c) < 3000) goto L25;
    L29:
        boolean r38 = false;
    L30:
        if (r38 == false) goto L36;
    L25:
        if (r19.d == false) goto L29;
        if (r2 != r19.e) goto L29;
        r38 = true;
        goto L30
    L16:
        if (b51.b.c0.d().n6() == false) goto L18;
        r18 = true;
        goto L19
    L10:
        r2 = 6;
        goto L11
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.service.c
    public final void Hb() {
        MultiAnchorTeamPkMatchingDialog r0 = this.g;
        if (r0 != null) goto L5;
    L7:
        MultiAnchorTeamPkMatchingDialog r1 = new MultiAnchorTeamPkMatchingDialog();
        this.g = r1;
        p8.a(r1, ((Widget) this).context);
        return;
    L5:
        if (r0.isShowing() != true) goto L7;
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.service.c
    public final void Ob() {
        zy0.d r0 = this.h;
        if (r0 == null) goto L12;
        DialogFragment r1 = r0.p1();
        if (r1 == null) goto L12;
        r1.dismiss();     // Catch: Exception -> L8
    L8:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r2 = DialogFragmentLancet.sLastShowStack;
        if (r2 == null) goto L12;
        com.bytedance.crash.d.d(r2, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
    L12:
        this.h = null;
        LiveDialogFragment r3 = this.f;
        if (r3 != null) goto L15;
    L20:
        zy0.d r4 = this.i;
        if (r4 == null) goto L30;
        DialogFragment r5 = r4.p1();
        if (r5 == null) goto L30;
        r5.dismiss();     // Catch: Exception -> L26
    L26:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r6 = DialogFragmentLancet.sLastShowStack;
        if (r6 == null) goto L30;
        com.bytedance.crash.d.d(r6, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
    L30:
        this.i = null;
        return;
    L15:
        if (r3.isShowing() != true) goto L20;
        LiveDialogFragment r7 = this.f;
        if (r7 == null) goto L19;
        wq(r7);
    L19:
        this.f = null;
        goto L20
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.service.c
    public final void r6() {
        LiveDialogFragment r0 = this.f;
        if (r0 != null) goto L5;
    L7:
        int r1 = MultiAnchorTeamPkUserInviteDialog.u;
        DataCenter r2 = ((Widget) this).dataCenter;
        MultiAnchorTeamPkUserInviteDialog r3 = new MultiAnchorTeamPkUserInviteDialog();
        r3.e = r2;
        r3.l = 1;
        this.f = r3;
        p8.a(r3, ((Widget) this).context);
        LinkingInvitePreloadUtils r4 = Bq();
        if (r4 == null) goto L11;
        r4.b++;
        l51.a.V.setValue(null, l51.a.a[50], Boolean.TRUE);
        return;
    L11:
        return;
    L5:
        if (r0.isShowing() != true) goto L7;
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.service.c
    public final void t8() {
        if (getCurrentScene() != 1) goto L5;
        int r1 = 4;
    L6:
        AnchorLinkTopViewConfirmationDialog r0 = new AnchorLinkTopViewConfirmationDialog(r1, ((Widget) this).dataCenter, ((Widget) this).context);
        if (DialogLancet.shouldBlockDialogShow(r0) == false) goto L13;
        DialogLancet.handleBlockedDialogShow(r0);
        return;
    L13:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L12
    L10:
        DialogLancet.beforeDialogShow(r0);
        r0.show();
        DialogLancet.afterDialogShow(r0);
        return;
    L5:
        r1 = 3;
        goto L6
    }

    public MultiAnchorPkLaunchControlWidget() {
        this.b = new CompositeDisposable();
        this.k = new CompositeDisposable();
        this.l = new d(this);
        this.m = new a(this);
    }

    public static String Aq() {
        MultiLinkAnchorControlContext r0 = com.bytedance.android.live.revlink.impl.global.b.B();
        if (r0 == null) goto L10;
        m<Boolean> r1 = r0.getForbidInvite();
        if (r1 != null) goto L7;
        return DataType.FALSE;
    L7:
        if (((Boolean) r1.getValue()).booleanValue() != true) goto L13;
        return "2";
    L13:
        return DataType.FALSE;
    L10:
        return DataType.FALSE;
    }

    public final int getCurrentScene() {
        com.bytedance.android.live.revlink.impl.service.internal.a r0 = com.bytedance.android.live.revlink.impl.global.b.n();
        if (r0 == null) goto L5;
        int r1 = r0.getCurrentMode();
    L7:
        if (v.a(r1, 4) == false) goto L11;
        return 1;
    L11:
        if (v.a(r1, 64) == false) goto L14;
        return 7;
    L14:
        return 0;
    L5:
        r1 = 0;
        goto L7
    }

    public final void onCreate() {
        super.onCreate();
        com.bytedance.android.live.revenue.core.util.j.a r0 = com.bytedance.android.live.revenue.core.util.j.C0;
        com.bytedance.android.livesdk.revenue.service.room.c r1 = (dy0.b) com.bytedance.android.live.revenue.core.util.e.c(r0.a(), com.bytedance.android.livesdk.revenue.service.room.c.class);
        if (r1 == null) goto L7;
        final com.bytedance.android.livesdk.revenue.room.a r2 = r1.getRoomContext();
        if (r2 == null) goto L7;
        Pair r3 = com.bytedance.live.datacontext.d.a(new MultiAnchorPkLaunchControlWidget$onCreate$1$dataPair$1(r2));
        this.c = (MultiAnchorPkLaunchContext) r3.getFirst();
        com.bytedance.live.datacontext.b.a((DataContext) r3.getFirst(), Reflection.getOrCreateKotlinClass(com.bytedance.android.live.revlink.impl.multianchor.pk.pklaunch.a.class));
        ((MultiAnchorPkLaunchContext) r3.getFirst()).getService().d(this);
        ((MultiAnchorPkLaunchContext) r3.getFirst()).getLinkingInvitePreloadUtils().d(new LinkingInvitePreloadUtils(ld.d.a(), com.bytedance.android.live.revlink.impl.global.b.k()));
        this.b.add((Disposable) r3.getSecond());
    L7:
        this.b.add(xs2.b.a().b(b30.p.class).subscribe(new com.bytedance.android.live.revlink.impl.multianchor.pk.pklaunch.e(this)));
        MultiPkLaunchPresenter r4 = new MultiPkLaunchPresenter();
        this.d = r4;
        r4.c0(this);
        yz0.k r5 = (yz0.k) com.bytedance.android.live.revenue.core.util.f.d(r0.a(), yz0.k.class);
        if (r5 == null) goto L10;
        IRoom r6 = r5.getRoom();
    L11:
        this.a = r6;
        MultiAnchorPkLaunchContext r7 = this.c;
        if (r7 == null) goto L20;
        n<g> r8 = r7.getMultiPkModeInfo();
        if (r8 == null) goto L20;
        Observable r9 = r8.a();
        if (r9 == null) goto L20;
        Disposable r10 = r9.subscribe(new c(this));
        if (r10 == null) goto L20;
        this.b.add(r10);
    L20:
        DataCenter r12 = ((Widget) this).dataCenter;
        if (r12 == null) goto L23;
        r12.observeForever("cmd_what_audience_join_self_link", this);
    L23:
        DataCenter r13 = ((Widget) this).dataCenter;
        if (r13 == null) goto L27;
        r13.observeForever("cmd_what_audience_join_guest_link", this);
        return;
    L27:
        return;
    L10:
        r6 = null;
        goto L11
    }

    public final void onDestroy() {
        super.onDestroy();
        Ob();
        DataCenter r0 = ((Widget) this).dataCenter;
        if (r0 == null) goto L5;
        r0.removeObserver(this);
    L5:
        LinkingInvitePreloadUtils r1 = Bq();
        if (r1 == null) goto L8;
        r1.b("destroy");
    L8:
        this.b.dispose();
        this.k.dispose();
        MultiPkLaunchPresenter r2 = this.d;
        if (r2 == null) goto L11;
        r2.detachView();
    L11:
        this.d = null;
    }

    public final boolean yq() {
        if (getCurrentScene() != 1) goto L5;
        return false;
    L5:
        com.bytedance.android.live.revlink.impl.global.c r0 = com.bytedance.android.live.revlink.impl.global.b.k();
        if (r0 == null) goto L8;
        com.bytedance.android.live.revlink.impl.mergepk.pkmulti.b r1 = r0.Q1();
    L9:
        if (r1 == null) goto L26;
        HashMap<String, Integer> r2 = r1.getUserRoleMap();
        if (r2 == null) goto L27;
        int r3 = h21.a.a;
        IRoom r4 = u.a();
        if (r4 == null) goto L16;
        String r5 = r4.getOwnerUserIdString();
        if (r5 == null) goto L16;
    L17:
        Integer r6 = r2.get(r5);
        if (r6 != null) goto L20;
        r6 = 1;
    L20:
        int r7 = r6.intValue();
        if (r7 != 3) goto L23;
    L24:
        return true;
    L23:
        if (r7 == 4) goto L24;
        return false;
    L16:
        r5 = "";
        goto L17
    L27:
        return false;
    L26:
        return false;
    L8:
        r1 = null;
        goto L9
    }

    public final String zq() {
        com.bytedance.android.live.revlink.impl.multianchor.match.a r0 = com.bytedance.android.live.revlink.impl.global.b.I();
        if (r0 != null) goto L5;
    L8:
        i11.b r1 = this.j;
        if (r1 == null) goto L16;
        List<com.bytedance.android.livesdk.link.model.p> r2 = r1.a();
        if (r2 != null) goto L13;
        return DataType.FALSE;
    L13:
        if ((!r2.isEmpty()) != true) goto L19;
        return DataType.TRUE;
    L19:
        return DataType.FALSE;
    L16:
        return DataType.FALSE;
    L5:
        if (r0.isMatching() != true) goto L8;
        return "2";
    }

    public static void wq(LiveDialogFragment r1) {
        r1.dismiss();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r2 = DialogFragmentLancet.sLastShowStack;
        if (r2 == null) goto L11;
        com.bytedance.crash.d.d(r2, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    }

    public static final void xq(MultiAnchorPkLaunchControlWidget r4) {
        zy0.d r0 = r4.h;
        if (r0 == null) goto L8;
        JSONObject r1 = new JSONObject();
        r1.put("type", "invite_battle_button_status");
        r1.put(Constants.Keys.DATA, r4.zq());
        xy0.a<?> r5 = r0.g();
        if (r5 == null) goto L9;
        r5.sendJsEvent("H5_webcastNotification", r1);
        return;
    L9:
        return;
    }

    public final void Cq(IBattleConfigSetting r4) {
        Intrinsics.checkNotNullParameter("npk_connect", "npkInvitePageSource");
        Bp();
        MultiAnchorPersonalPkLaunchDialogV2 r2 = new MultiAnchorPersonalPkLaunchDialogV2();
        Intrinsics.checkNotNullParameter("npk_connect", "npkInvitePageSource");
        r2.g = "npk_connect";
        p8.a(r2, ((Widget) this).context);
        r2.setOnDismissListener(new com.bytedance.android.live.revlink.impl.multianchor.pk.pklaunch.c(this, r2));
        Unit r0 = Unit.INSTANCE;
        this.e = r2;
        Eq(1, r4);
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.service.c
    public final void Md(JsonObject r4) {
        if (r4 == null) goto L6;
        JsonElement r0 = r4.get("type");
        if (r0 == null) goto L6;
        int r1 = r0.getAsInt();
    L8:
        if (r4 != null) goto L30;
    L14:
        String r5 = null;
    L15:
        IBattleConfigSetting r6 = (IBattleConfigSetting) com.bytedance.android.live.revlink.impl.utils.e.a(r5, IBattleConfigSetting.class);     // Catch: Exception -> L12
        if (r1 != MultiPkModeType.BOTH.ordinal()) goto L19;
        U5(r6, null);     // Catch: Exception -> L12
        return;
    L19:
        if (r1 != MultiPkModeType.PERSONAL.ordinal()) goto L22;
        Cq(r6);     // Catch: Exception -> L12
        return;
    L22:
        if (r1 == MultiPkModeType.TEAM.ordinal()) goto L24;
        return;
    L24:
        if (d51.c.A0.q() == false) goto L26;
        com.bytedance.android.live.revlink.impl.multianchor.service.c.a.b(this, true, r6, 4);     // Catch: Exception -> L12
        return;
    L26:
        com.bytedance.android.live.revlink.impl.multianchor.service.c.a.b(this, true, null, 6);     // Catch: Exception -> L12
        return;
    L30:
        JsonElement r7 = r4.get("battle_config_setting_str");     // Catch: Exception -> L12
        if (r7 == null) goto L14;
        r5 = r7.getAsString();     // Catch: Exception -> L12
    L12:
        e = move-exception;
        jy0.b.e("ttlive_anchor_link_multi_pk", "launchMultiPkTeamOrPersonPanel parse error", e);
        return;
    L6:
        r1 = -1;
        goto L8
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.service.c
    public final void Ul(int r5) {
        zy0.d r0 = this.h;
        if (r0 == null) goto L8;
        JSONObject r1 = new JSONObject();
        r1.put("type", "chorus_msg");
        r1.put(Constants.Keys.DATA, r5);
        xy0.a<?> r6 = r0.g();
        if (r6 == null) goto L9;
        r6.sendJsEvent("H5_webcastNotification", r1);
        return;
    L9:
        return;
    }

    public final void onChanged(Object r14) {
        KVData r15 = (KVData) r14;
        Boolean r0 = null;
        if (r15 == null) goto L5;
        String r1 = r15.getKey();
    L6:
        if (r1 == null) goto L62;
        int r2 = r1.hashCode();
        String r12 = DataType.TRUE;
        if (r2 == 1080946897) goto L36;
        if (r2 == 2140954685) goto L14;
        return;
    L14:
        if (r1.equals("cmd_what_audience_join_self_link") == false) goto L56;
        zy0.d r3 = this.h;
        if (r3 == null) goto L57;
        JSONObject r4 = new JSONObject();
        if (r15 == null) goto L20;
        Boolean r16 = (Boolean) r15.getData(Boolean.FALSE);
    L21:
        Boolean r5 = Boolean.TRUE;
        if (Intrinsics.areEqual(r16, r5) == false) goto L24;
        Object r17 = DataType.TRUE;
    L25:
        r4.put("left", r17);
        DataCenter r18 = ((Widget) this).dataCenter;
        if (r18 == null) goto L29;
        r0 = (Boolean) r18.get("cmd_what_audience_join_guest_link", Boolean.FALSE);
    L29:
        if (Intrinsics.areEqual(r0, r5) == true) goto L32;
        r12 = DataType.FALSE;
    L32:
        r4.put("right", r12);
        JSONObject r19 = new JSONObject();
        r19.put("type", "pk_audience_count");
        r19.put(Constants.Keys.DATA, r4.toString());
        xy0.a<?> r6 = r3.g();
        if (r6 == null) goto L58;
        r6.sendJsEvent("H5_webcastNotification", r19);
        return;
    L58:
        return;
    L24:
        r17 = DataType.FALSE;
        goto L25
    L20:
        r16 = null;
        goto L21
    L57:
        return;
    L56:
        return;
    L36:
        if (r1.equals("cmd_what_audience_join_guest_link") == true) goto L38;
        return;
    L38:
        if (this.h == null) goto L61;
        JSONObject r7 = new JSONObject();
        DataCenter r8 = ((Widget) this).dataCenter;
        if (r8 == null) goto L42;
        Boolean r9 = (Boolean) r8.get("cmd_what_audience_join_self_link", Boolean.FALSE);
    L43:
        Boolean r10 = Boolean.TRUE;
        if (Intrinsics.areEqual(r9, r10) == false) goto L46;
        Object r13 = DataType.TRUE;
    L47:
        r7.put("left", r13);
        if (r15 == null) goto L51;
        r0 = (Boolean) r15.getData(Boolean.FALSE);
    L51:
        if (Intrinsics.areEqual(r0, r10) == true) goto L54;
        r12 = DataType.FALSE;
    L54:
        r7.put("right", r12);
        JSONObject r110 = new JSONObject();
        r110.put("type", "pk_audience_count");
        r110.put(Constants.Keys.DATA, r7.toString());
        return;
    L46:
        r13 = DataType.FALSE;
        goto L47
    L42:
        r9 = null;
        goto L43
    L61:
        return;
    L62:
        return;
    L5:
        r1 = null;
        goto L6
    }

    public final void Eq(int r13, IBattleConfigSetting r14) {
        if (r14 == null) goto L4;
        String r0 = com.bytedance.android.live.revlink.impl.utils.e.b(r14);
    L5:
        String r7 = r0;
        MultiAnchorPkLaunchContext r1 = this.c;
        if (r1 == null) goto L14;
        n<g> r2 = r1.getMultiPkModeInfo();
        if (r2 == null) goto L14;
        g r3 = (g) r2.getValue();
        if (r3 == null) goto L14;
        e7 r4 = r3.a;
        if (r4 == null) goto L14;
        int r5 = r4.getModeTab();
    L15:
        MultiAnchorPkLaunchContext r6 = this.c;
        if (r6 == null) goto L24;
        n<g> r8 = r6.getMultiPkModeInfo();
        if (r8 == null) goto L24;
        g r9 = (g) r8.getValue();
        if (r9 == null) goto L24;
        e7 r10 = r9.a;
        if (r10 == null) goto L24;
        IBattleConfigSetting r12 = f7.a(r10);
    L25:
        StringBuilder r15 = new StringBuilder("trySwitchMultiPkMode current=(");
        r15.append(r5);
        r15.append(", ");
        if (r12 == null) goto L30;
        w2 r16 = r12.getShellConfig();
        if (r16 == null) goto L30;
        Long r17 = Long.valueOf(r16.getType());
    L31:
        r15.append(r17);
        r15.append(") target=(");
        r15.append(r13);
        r15.append(", ");
        if (r14 == null) goto L36;
        w2 r18 = r14.getShellConfig();
        if (r18 == null) goto L36;
        Long r19 = Long.valueOf(r18.getType());
    L37:
        r15.append(r19);
        r15.append(')');
        jy0.b.f("ttlive_anchor_link_multi_pk", r15.toString(), null, 4);
        long r20 = System.currentTimeMillis();
        r31.a r22 = r31.b.a(r31.a.a);
        LinkCrossRoomDataHolder r110 = com.bytedance.android.live.revlink.impl.global.b.j();
        long r23 = 0;
        if (r110 == null) goto L40;
        long r24 = r110.c();
    L41:
        IRoom r111 = this.a;
        if (r111 == null) goto L44;
        r23 = r111.getRoomId();
    L44:
        Observable<ExtraResponse<q3, Extra>> r112 = r22.h(r24, r23, r13, r7);
        if (r112 == null) goto L52;
        Observable r113 = r112.compose(RxUtil.rxSchedulerHelper());
        if (r113 == null) goto L53;
        Disposable r114 = r113.subscribe(new e(this, r20, r13), new f(r13, r20));
        if (r114 == null) goto L54;
        this.b.add(r114);
        return;
    L54:
        return;
    L53:
        return;
    L52:
        return;
    L40:
        r24 = 0;
    L36:
        r19 = null;
    L30:
        r17 = null;
    L24:
        r12 = null;
    L14:
        r5 = 1;
        goto L15
    L4:
        r0 = "";
        goto L5
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.service.c
    public final void U5(IBattleConfigSetting r5, p21.e r6) {
        Intrinsics.checkNotNullParameter("npk_connect", "npkInvitePageSource");
        Bp();
        MultiAnchorPkLaunchDialogNew r2 = new MultiAnchorPkLaunchDialogNew(((Widget) this).dataCenter, r6);
        if (r5 != null) goto L11;
        r5 = (IBattleConfigSetting) vh7.f.c(IBattleConfigSetting.class);
        r5.setModType(PkBaseDataContext.PKModType.Default.getType());
        q r7 = com.bytedance.android.live.revlink.impl.global.b.W();
        if (r7 == null) goto L9;
        PkCustomizePlayDataContext r8 = r7.f();
        if (r8 == null) goto L9;
        u2 r9 = r8.getBattleSelfData();
    L10:
        r5.setSelfData(r9);
        Unit r10 = Unit.INSTANCE;
    L9:
        r9 = null;
    L11:
        r2.g = r5;
        Intrinsics.checkNotNullParameter("npk_connect", "npkInvitePageSource");
        r2.h = "npk_connect";
        p8.a(r2, ((Widget) this).context);
        r2.setOnDismissListener(new com.bytedance.android.live.revlink.impl.multianchor.pk.pklaunch.b(this, r2));
        Unit r12 = Unit.INSTANCE;
        this.e = r2;
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.service.c
    public final void Wm(int r12, int r13) {
        if (((Widget) this).dataCenter != null) goto L5;
        return;
    L5:
        b51.b r0 = b51.b.c0;
        r0.getClass();
        String r1 = (String) b51.b.A.getValue(r0, b51.b.a[25]);
        if (TextUtils.isEmpty(r1) == true) goto L127;
        com.bytedance.android.live.revlink.impl.multianchor.service.d r2 = com.bytedance.android.live.revlink.impl.global.b.z();
        if (r2 == null) goto L10;
        i11.b r3 = r2.getLinkUserCenter();
    L11:
        this.j = r3;
        if (r3 == null) goto L14;
        r3.i(this.m);
    L14:
        i11.b r4 = this.j;
        if (r4 == null) goto L17;
        r4.h(getCurrentScene(), 4, "show_link_list_dialog");
    L17:
        x0 r5 = new x0(r1);
        x0 r6 = r5.d("url");
        yq();
        boolean r7 = yq();
        String r8 = DataType.TRUE;
        if (r7 == false) goto L20;
        String r9 = DataType.TRUE;
    L21:
        r6.b("role", r9);
        LinkCrossRoomDataHolder r10 = com.bytedance.android.live.revlink.impl.global.b.j();
        if (r10 == null) goto L24;
        Long r14 = Long.valueOf(r10.c());
    L25:
        r6.b("channel_id", String.valueOf(r14));
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.e r15 = com.bytedance.android.live.revlink.impl.global.b.R();
        if (r15 == null) goto L32;
        PkBaseStateMachine.c r16 = r15.getCurPKBaseState();
        if (r16 == null) goto L32;
        if ((r16 instanceof PkBaseStateMachine.c.C0130c) != true) goto L32;
        String r17 = DataType.TRUE;
    L33:
        r6.b("from_type", r17);
        r6.b("select_top_panel", String.valueOf(r13));
        y41.c r18 = y41.c.e;
        r18.getClass();
        ReadOnlyProperty r19 = y41.c.c;
        KProperty[] r20 = y41.c.a;
        if (((Boolean) r19.getValue(r18, r20[1])).booleanValue() == false) goto L36;
        String r22 = DataType.TRUE;
    L37:
        r6.b("enable_chorus", r22);
        if (com.bytedance.android.live.revlink.impl.settings.dynamic.a.H.c() == false) goto L40;
        String r23 = DataType.TRUE;
    L41:
        r6.b("panel_list_opt", r23);
        iq2.b r24 = vh6.c.b(er2.b.class).getChorusService();
        if (r24 != null) goto L44;
    L46:
        String r25 = DataType.FALSE;
    L47:
        r6.b("chorus_opened", r25);
        int r26 = com.bytedance.android.live.revlink.impl.utils.c.a;
        float r27 = ((Number) b0.d.getValue(null, b0.a[2])).floatValue();
        if (r27 > 0) goto L50;
    L53:
        boolean r110 = true;
    L54:
        if (r110 == false) goto L56;
        String r111 = DataType.TRUE;
    L57:
        r6.b("device_support_chorus", r111);
        com.bytedance.android.live.revlink.impl.multianchor.service.d r112 = com.bytedance.android.live.revlink.impl.global.b.z();
        if (r112 == null) goto L64;
        i11.b r113 = r112.getLinkUserCenter();
        if (r113 == null) goto L64;
        if (r113.N(u.e()) != true) goto L64;
        String r114 = DataType.TRUE;
    L65:
        r6.b("is_organizer", r114);
        r6.b("invite_user_button_status", Aq());
        r6.b("invite_battle_button_status", zq());
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.e r115 = com.bytedance.android.live.revlink.impl.global.b.R();
        if (r115 == null) goto L70;
        IBaseBattleSetting r116 = r115.getBattleSettings();
        if (r116 == null) goto L70;
        long r28 = r116.getDuration();
    L71:
        r6.b("current_duration", String.valueOf(r28));
        r6.b("setting_duration", String.valueOf(l51.a.j()));
        if (getCurrentScene() != 1) goto L84;
        q r117 = com.bytedance.android.live.revlink.impl.global.b.W();
        if (r117 == null) goto L101;
        com.bytedance.android.live.revlink.impl.mergepk.pkdouble.c r118 = r117.g();
        if (r118 == null) goto L101;
        LiveData<IBaseUser> r119 = r118.getGuestUser();
        if (r119 == null) goto L101;
        IBaseUser r120 = (IBaseUser) r119.getValue();
        if (r120 == null) goto L101;
        String r121 = r120.getNickName();
        if (r121 == null) goto L101;
    L102:
        r6.b("opposite_user_name", r121);
        i11.b r122 = this.j;
        if (r122 == null) goto L106;
        String r123 = String.valueOf(r122.c());
        if (r123 == null) goto L106;
    L107:
        r6.b("anchor_connect_status", r123);
        r6.b("scene", String.valueOf(getCurrentScene()));
        aa r124 = vh7.f.c(aa.class);
        r124.setVoteType(l51.a.g());
        r124.setVoteDes((String) l51.a.D0.getValue(null, l51.a.a[91]));
        r124.setDurationTime(l51.a.f());
        r6.b("vote_setting", com.bytedance.android.live.revlink.impl.utils.e.b(r124));
        r6.b("tab_index", String.valueOf(r12));
        if (r41.f.a == true) goto L111;
        r8 = DataType.FALSE;
    L111:
        r6.b("support_nine_linker", r8);
        this.h = ((vy0.b) com.bytedance.android.live.revenue.core.util.f.a(vy0.c.class)).U0(((Widget) this).context, r5.c(), null);
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.e r125 = com.bytedance.android.live.revlink.impl.global.b.R();
        if (r125 == null) goto L114;
        LiveData<PkBaseStateMachine.c> r126 = r125.getPkBaseState();
        Intrinsics.checkNotNullParameter(r126, "$this$convertPkBaseStateToInt");
        Intrinsics.checkNotNullParameter(r125, "pkService");
        MediatorLiveData r29 = new MediatorLiveData();
        r29.addSource(r126, new PkLynxDataContext_androidKt$convertPkBaseStateToInt$$inlined$also$lambda$1(r29, r125));
        r29.observeForever(this.l);
    L114:
        MultiLinkAnchorControlContext r127 = com.bytedance.android.live.revlink.impl.global.b.B();
        if (r127 == null) goto L123;
        m<Boolean> r128 = r127.getForbidInvite();
        if (r128 == null) goto L123;
        Observable r129 = r128.a();
        if (r129 == null) goto L123;
        Disposable r130 = r129.subscribe(new com.bytedance.android.live.revlink.impl.multianchor.pk.pklaunch.d(this));
        if (r130 == null) goto L123;
        this.k.add(r130);
    L123:
        zy0.d r131 = this.h;
        if (r131 == null) goto L128;
        r131.j0(new MultiAnchorPkLaunchControlWidget$launchStartPanel$4(this));
        return;
    L128:
        return;
    L106:
        r123 = "2";
    L101:
        r121 = "对方主播";
        goto L102
    L84:
        i11.b r132 = this.j;
        if (r132 == null) goto L89;
        List<com.bytedance.android.livesdk.link.model.p> r133 = r132.getOnlineUserList();
        if (r133 == null) goto L89;
        int r134 = r133.size();
    L90:
        if (r134 <= 0) goto L101;
        i11.b r135 = this.j;
        if (r135 == null) goto L101;
        List<com.bytedance.android.livesdk.link.model.p> r136 = r135.getOnlineUserList();
        if (r136 == null) goto L101;
        com.bytedance.android.livesdk.link.model.p r137 = (com.bytedance.android.livesdk.link.model.p) ListProtector.get(r136, 0);
        if (r137 == null) goto L101;
        IBaseUser r138 = r137.getUser();
        if (r138 == null) goto L101;
        r121 = r138.getNickName();
        if (r121 != null) goto L102;
    L89:
        r134 = 0;
    L70:
        r28 = 300;
    L64:
        r114 = DataType.FALSE;
        goto L65
    L56:
        r111 = DataType.FALSE;
        goto L57
    L50:
        if (r27 >= ((Number) y41.c.b.getValue(r18, r20[0])).floatValue()) goto L53;
        r110 = false;
        goto L54
    L44:
        if (r24.e() != true) goto L46;
        r25 = DataType.TRUE;
        goto L47
    L40:
        r23 = DataType.FALSE;
        goto L41
    L36:
        r22 = DataType.FALSE;
    L32:
        r17 = DataType.FALSE;
        goto L33
    L24:
        r14 = null;
        goto L25
    L20:
        r9 = DataType.FALSE;
        goto L21
    L10:
        r3 = null;
        goto L11
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.service.c
    public final void eb(IBattleConfigSetting r27, com.bytedance.android.live.revlink.impl.pk.utils.l r28) {
        Intrinsics.checkNotNullParameter("focus_gift", "playType");
        Intrinsics.checkNotNullParameter(r28, "pageSource");
        h9 r1 = r27.getSpecifyGiftConfig();
        if (r1 == null) goto L164;
        v3 r8 = null;
        if (com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt.d.c() == false) goto L30;
        q r2 = com.bytedance.android.live.revlink.impl.global.b.W();
        if (r2 == null) goto L154;
        com.bytedance.android.live.revlink.impl.global.c r3 = r2.c;
        if (r3 == null) goto L12;
        com.bytedance.android.live.revlink.impl.mergepk.pkdouble.b r4 = r3.L1();
    L13:
        if (r4 == null) goto L155;
        e21.b r7 = com.bytedance.android.live.revlink.impl.global.b.h();
        if (r7 == null) goto L28;
        d31.d r5 = com.bytedance.android.live.revlink.impl.global.b.c0();
        if (r5 == null) goto L22;
        String r6 = r5.a();
        if (r6 == null) goto L22;
        String r13 = r6;
    L23:
        d31.d r9 = com.bytedance.android.live.revlink.impl.global.b.c0();
        if (r9 == null) goto L26;
        String r12 = r9.s();
    L27:
        r8 = e21.b.b(r7, r28, "focus_gift", null, null, r12, r13, 28);
        goto L28
    L26:
        r12 = "";
    L22:
        r13 = "";
    L28:
        r4.startBattleInvite(new com.bytedance.android.live.revlink.impl.pk.vm.pk.a(r27, r8));
        return;
    L155:
        return;
    L12:
        r4 = null;
        goto L13
    L154:
        return;
    L30:
        if (getCurrentScene() != 7) goto L157;
        com.bytedance.android.live.revlink.impl.multianchor.service.d r10 = com.bytedance.android.live.revlink.impl.global.b.z();
        if (r10 == null) goto L38;
        i11.b r14 = r10.getLinkUserCenter();
        if (r14 == null) goto L38;
        List<com.bytedance.android.livesdk.link.model.p> r15 = r14.getOnlineUserList();
        if (r15 == null) goto L38;
        int r16 = r15.size();
    L39:
        if (r16 != 2) goto L49;
        com.bytedance.android.live.revlink.impl.multianchor.service.a r17 = com.bytedance.android.live.revlink.impl.global.b.t();
        if (r17 == null) goto L43;
        r17.na(new com.bytedance.android.live.revlink.impl.mergepk.pkdouble.g(null, 0, null, false, r27, 122879));
    L43:
        com.bytedance.android.live.revlink.impl.global.c r18 = com.bytedance.android.live.revlink.impl.global.b.k();
        if (r18 == null) goto L46;
        com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt.g r19 = r18.Yg();
    L47:
        if (r19 == null) goto L158;
        com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt.g.a(r19, this.a, true, "focus_gift", false, false, 56);
        return;
    L158:
        return;
    L46:
        r19 = null;
        goto L47
    L49:
        com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt.f r20 = com.bytedance.android.live.revlink.impl.global.b.m();
        boolean r22 = false;
        if (r20 != null) goto L52;
    L54:
        boolean r23 = false;
    L56:
        if (r23 == false) goto L91;
        int r110 = ILinkMicBattleInviteMessage.BattleInviteType.BattleInviteType_Multiple_Again.ordinal();
        long r24 = l51.a.j();
        Pair r25 = TuplesKt.to(new h.f(r1), "focus_gift");
        h r26 = (h) r25.component1();
        String r29 = (String) r25.component2();
        MultiPKLauncher r111 = com.bytedance.android.live.revlink.impl.global.b.F();
        if (r111 == null) goto L85;
        jy0.b.c("ttlive_anchor_link_multi_pk", "inviteMultiPk inviteType=" + r110 + " multiPkMode=0 duration=" + r24, null, 4);
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.e r30 = com.bytedance.android.live.revlink.impl.global.b.R();
        if (r30 == null) goto L85;
        IBaseBattleSetting r32 = r30.getBattleSettings();
        if (r32 == null) goto L85;
        long r112 = r32.getBattleId();
        if ((r26 instanceof h.c) == true) goto L67;
        h r33 = null;
    L68:
        h.c r34 = (h.c) r33;
        if (r34 == null) goto L71;
        d4 r113 = r34.b;
    L72:
        boolean r35 = r30.getCurPKBaseState().b();
        PkBaseDataContext.PKModType r114 = PkBaseDataContext.PKModType.Default;
        d4 r36 = r113;
        h31.e r115 = new h31.e(r112, r110, r35, false, 0);
        if (r36 == null) goto L75;
        h31.c r37 = new h31.c(r36);
    L77:
        if ((r26 instanceof h.e) == false) goto L79;
        w2 r116 = ((h.e) r26).b;
    L81:
        if ((r26 instanceof h.f) == false) goto L83;
        h9 r210 = ((h.f) r26).b;
    L84:
        r111.invitePk(new h31.f(r114, r24, null, r115, null, r37, r116, r210, r26, 0, r28, null, 4352), null);
        goto L85
    L83:
        r210 = null;
        goto L84
    L79:
        r116 = null;
        goto L81
    L75:
        r37 = null;
        goto L77
    L71:
        r113 = null;
        goto L72
    L67:
        r33 = r26;
    L85:
        com.bytedance.android.live.revlink.impl.global.c r38 = com.bytedance.android.live.revlink.impl.global.b.k();
        if (r38 == null) goto L88;
        r8 = r38.Yg();
    L88:
        v3 r117 = r8;
        if (r117 == null) goto L160;
        com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt.g.a(r117, this.a, true, r29, true, false, 16);
        return;
    L160:
        return;
    L91:
        q r39 = com.bytedance.android.live.revlink.impl.global.b.W();
        if (r39 == null) goto L100;
        com.bytedance.android.live.revlink.impl.mergepk.pkdouble.c r40 = r39.g();
        if (r40 == null) goto L100;
        if (r40.canSwitchMulti() == true) goto L100;
        ToastUtil.a(2131917959, 0);
        h41.f r42 = com.bytedance.android.live.revlink.impl.global.b.V();
        if (r42 == null) goto L139;
        r42.c(0);
    L139:
        if (r22 == true) goto L141;
        jy0.b.c("ttlive_anchor_link_panel", "intercept openMultiPkStartPanel", null, 4);
        return;
    L141:
        h41.f r43 = com.bytedance.android.live.revlink.impl.global.b.V();
        if (r43 == null) goto L144;
        r43.c(1);
    L144:
        com.bytedance.android.live.revlink.impl.multianchor.service.c r44 = com.bytedance.android.live.revlink.impl.global.b.y();
        if (r44 == null) goto L147;
        r44.U5(r27, null);
    L147:
        com.bytedance.android.live.revlink.impl.global.c r45 = com.bytedance.android.live.revlink.impl.global.b.k();
        if (r45 == null) goto L150;
        r8 = r45.Yg();
    L150:
        v3 r46 = r8;
        if (r46 == null) goto L163;
        com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt.g.a(r46, this.a, false, "focus_gift", false, false, 56);
        return;
    L163:
        return;
    L100:
        com.bytedance.android.live.revlink.impl.global.c r47 = com.bytedance.android.live.revlink.impl.global.b.k();
        if (r47 == null) goto L103;
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.f r48 = r47.getPKBaseUtils();
    L104:
        if (r48 == null) goto L120;
        com.bytedance.android.live.revlink.impl.global.c r49 = r48.a;
        if (r49 == null) goto L108;
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.e r50 = r49.Ig();
    L109:
        if (r50 == null) goto L111;
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.launcher.a r52 = r50.getPkAnchorLauncher();
    L112:
        if (r52 == null) goto L120;
        MutableLiveData r53 = r52.g();
        if (r53 == null) goto L120;
        c21.c r54 = (c21.c) r53.getValue();
        if (r54 == null) goto L120;
        if ((r54 instanceof c21.c.d) != true) goto L120;
        ToastUtil.a(2131921452, 0);
        goto L139
    L111:
        r52 = null;
        goto L112
    L108:
        r50 = null;
    L120:
        ld.a r55 = ld.d.a();
        if (r55 == null) goto L125;
        NextLiveData r56 = r55.Fc();
        if (r56 == null) goto L125;
        Boolean r57 = (Boolean) r56.getValue();
    L126:
        Boolean r58 = Boolean.TRUE;
        if (Intrinsics.areEqual(r57, r58) == true) goto L138;
        ld.a r59 = ld.d.a();
        if (r59 == null) goto L133;
        NextLiveData r60 = r59.z9();
        if (r60 == null) goto L133;
        Boolean r62 = (Boolean) r60.getValue();
    L135:
        if (Intrinsics.areEqual(r62, r58) == true) goto L138;
        r22 = true;
    L133:
        r62 = null;
    L138:
        ToastUtil.a(2131917960, 0);
    L125:
        r57 = null;
        goto L126
    L103:
        r48 = null;
        goto L104
    L52:
        if (r20.g() != true) goto L54;
        r23 = true;
    L38:
        r16 = 2;
        goto L39
    L157:
        return;
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.service.c
    public final void S6(boolean r3, IBattleConfigSetting r4, p21.e r5) {
        Bp();
        if (r5 != null) goto L5;
        r5 = new p21.e(com.bytedance.android.live.revlink.impl.global.b.k());
    L5:
        MultiAnchorTeamPkLaunchDialogV2 r0 = new MultiAnchorTeamPkLaunchDialogV2(r5);
        r0.g = r4;
        r0.setOnDismissListener(new b(this, r0));
        Unit r6 = Unit.INSTANCE;
        this.e = r0;
        p8.a(r0, ((Widget) this).context);
        if (r3 == false) goto L9;
        Eq(2, r4);
        return;
    }
}
