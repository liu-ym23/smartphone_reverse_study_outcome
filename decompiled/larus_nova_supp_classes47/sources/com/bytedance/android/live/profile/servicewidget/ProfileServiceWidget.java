package com.bytedance.android.live.profile.servicewidget;

import am2.n;
import am2.z;
import android.content.Context;
import android.text.TextUtils;
import androidx.fragment.app.FragmentActivity;
import ca0.o;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.base.model.user.o0;
import com.bytedance.android.live.base.model.user.r0;
import com.bytedance.android.live.base.model.user.x;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.monitor.LiveSlardarMonitor;
import com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget;
import com.bytedance.android.live.core.utils.ContextUtil;
import com.bytedance.android.live.core.utils.a0;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.h1;
import com.bytedance.android.live.core.utils.i1;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.gift.IGiftServiceExternal;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.live.profile.NewProfileDialogLauncher;
import com.bytedance.android.live.profile.NewProfileInfoViewModel;
import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.android.live.profile.monitor.EndType;
import com.bytedance.android.live.profile.monitor.ProfileMonitor;
import com.bytedance.android.live.profile.monitor.TimeType;
import com.bytedance.android.live.profile.reportdialog.LiveRepoDialog;
import com.bytedance.android.live.profile.repository.NewProfileApi;
import com.bytedance.android.live.profile.seeselftransition.NewProfileSeeSelfTransitionDialogLauncher;
import com.bytedance.android.live.profile.seeselftransition.NewProfileTransitionDialogManager;
import com.bytedance.android.live.revlink.api.ILinkService;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livehostapi.foundation.IMiddlewareHostApp;
import com.bytedance.android.livesdk.ability.IAbilityCenter;
import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.bytedance.android.livesdk.config.gs;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdk.o4;
import com.bytedance.android.livesdk.schema.interfaces.IBaseLiveActionHandler;
import com.bytedance.android.livesdk.user.h;
import com.bytedance.android.livesdk.user.l;
import com.bytedance.android.livesdk.utils.c1;
import com.bytedance.android.livesdkapi.business.ILiveDouPlusService;
import com.bytedance.android.livesdkapi.depend.live.IRoomRecordService;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.utils.UnLoginFeatureUtils;
import com.bytedance.android.livesdkapi.service.ILiveNetworkPredict;
import com.bytedance.common.utility.Lists;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.live.datacontext.m;
import com.bytedance.mt.protector.impl.UriProtector;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import gd0.v;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.subjects.PublishSubject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import jc1.k;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SpreadBuilder;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;
import mv0.c0;
import org.json.JSONObject;
import p11.j;
import py.t;
import qs0.i;
import qs0.s;
import r52.m1;
import rs0.y0;
import zg1.u;
import zg1.v2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001\u0006B\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/live/profile/servicewidget/ProfileServiceWidget;", "Lcom/bytedance/android/live/core/tetris/widgets/LiveRecyclableWidget;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "<init>", "()V", "a", "live-profile-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ProfileServiceWidget extends LiveRecyclableWidget implements Observer<KVData> {
    public static final /* synthetic */ int h = 0;
    public final CompositeDisposable a;
    public Disposable b;
    public NewProfileDialogLauncher c;
    public List<NewProfileDialogLauncher> d;
    public NewProfileSeeSelfTransitionDialogLauncher e;
    public boolean f;
    public List<? extends ILinkPlayerInfoBridge> g;

    public static final class a {
    }

    public final class b implements Consumer {
        public final /* synthetic */ Function1 a;

        public b(Function1 r1) {
            this.a = r1;
        }

        public final /* synthetic */ void accept(Object r2) {
            this.a.invoke(r2);
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.profile.servicewidget.ProfileServiceWidget$onLoad$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lzg1/v2;", "p1", "", "invoke", "(Lzg1/v2;)V", "<anonymous>"}, k = 3, mv = {1, 4, 3})
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<v2, Unit> {
        public AnonymousClass1(ProfileServiceWidget r8) {
            super(1, r8, ProfileServiceWidget.class, "onEvent", "onEvent(Lcom/bytedance/android/livesdk/chatroom/event/SetProfileModeEvent;)V", 0);
        }

        public final void invoke(v2 r22) {
            ProfileServiceWidget r2 = (ProfileServiceWidget) ((CallableReference) this).receiver;
            int r3 = ProfileServiceWidget.h;
            if (a0.d(((Widget) r2).dataCenter, false) == false) goto L35;
            Disposable r4 = r2.b;
            if (r4 == null) goto L8;
            r4.dispose();
        L8:
            Disposable r5 = null;
            if (r22 == null) goto L11;
            String r6 = r22.a;
        L12:
            String r7 = String.valueOf(r6);
            long r8 = 0;
            if (r22 == null) goto L15;
            long r14 = r22.b;
        L16:
            if (r22 == null) goto L18;
            long r16 = r22.c;
        L19:
            if (r22 == null) goto L21;
            long r18 = r22.d;
        L22:
            Intrinsics.checkNotNullParameter(r7, "userId");
            NewProfileApi r9 = (NewProfileApi) com.bytedance.android.live.network.c.b().e(NewProfileApi.class);
            if (r9 == null) goto L28;
            Long r10 = StringsKt.toLongOrNull(r7);
            if (r10 == null) goto L27;
            r8 = r10.longValue();
        L27:
            Single<Response<r0>> r12 = r9.postOpenSetting(r8, 1, r14, r16, r18);
        L29:
            if (r12 == null) goto L33;
            Single r13 = r12.observeOn(AndroidSchedulers.mainThread());
            if (r13 == null) goto L33;
            r5 = r13.subscribe(new com.bytedance.android.live.profile.servicewidget.a(r2, r22), com.bytedance.android.live.profile.servicewidget.b.a);
        L33:
            r2.b = r5;
            return;
        L28:
            r12 = null;
            goto L29
        L21:
            r18 = 0;
            goto L22
        L18:
            r16 = 0;
            goto L19
        L15:
            r14 = 0;
            goto L16
        L11:
            r6 = null;
            goto L12
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            invoke((v2) r1);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.profile.servicewidget.ProfileServiceWidget$onLoad$2, reason: invalid class name */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "p1", "Lcom/bytedance/android/livesdk/chatroom/event/UserProfileEvent;", "invoke"}, k = 3, mv = {1, 4, 3})
    public static final /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function1<UserProfileEvent, Unit> {
        public AnonymousClass2(ProfileServiceWidget r8) {
            super(1, r8, ProfileServiceWidget.class, "onEvent", "onEvent(Lcom/bytedance/android/livesdk/chatroom/event/UserProfileEvent;)V", 0);
        }

        public final void invoke(UserProfileEvent r3) {
            ProfileServiceWidget r0 = (ProfileServiceWidget) ((CallableReference) this).receiver;
            int r1 = ProfileServiceWidget.h;
            r0.Aq(r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            invoke((UserProfileEvent) r1);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.profile.servicewidget.ProfileServiceWidget$onLoad$3, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lps0/a;", "p1", "", "invoke", "(Lps0/a;)V", "<anonymous>"}, k = 3, mv = {1, 4, 3})
    public static final /* synthetic */ class AnonymousClass3 extends FunctionReferenceImpl implements Function1<ps0.a, Unit> {
        public AnonymousClass3(ProfileServiceWidget r8) {
            super(1, r8, ProfileServiceWidget.class, "onEvent", "onEvent(Lcom/bytedance/android/live/profile/api/model/CloseProfileEvent;)V", 0);
        }

        public final void invoke(ps0.a r8) {
            Intrinsics.checkNotNullParameter(r8, "p1");
            ProfileServiceWidget r0 = (ProfileServiceWidget) ((CallableReference) this).receiver;
            int r1 = ProfileServiceWidget.h;
            r0.getClass();
            if (r8.a == false) goto L13;
            NewProfileDialogLauncher r9 = r0.c;
            if (r9 == null) goto L7;
            r9.b();
        L7:
            List<NewProfileDialogLauncher> r10 = r0.d;
            if (r10 == null) goto L42;
            Iterator r12 = ((ArrayList) r10).iterator();
        L11:
            if (r12.hasNext() == false) goto L44;
            ((NewProfileDialogLauncher) r12.next()).b();
            goto L11
        L44:
            return;
        L42:
            return;
        L13:
            SpreadBuilder r13 = new SpreadBuilder(2);
            r13.add(r0.c);
            List<NewProfileDialogLauncher> r2 = r0.d;
            Object r3 = null;
            if (r2 == null) goto L20;
            Object[] r4 = ((ArrayList) r2).toArray(new NewProfileDialogLauncher[0]);
            if (r4 == null) goto L19;
            NewProfileDialogLauncher[] r5 = (NewProfileDialogLauncher[]) r4;
        L21:
            if (r5 != null) goto L23;
            r5 = new NewProfileDialogLauncher[0];
        L23:
            r13.addSpread(r5);
            Iterator r14 = SequencesKt.filter(SequencesKt.filterNotNull(SequencesKt.sequenceOf((NewProfileDialogLauncher[]) r13.toArray(new NewProfileDialogLauncher[r13.size()]))), ProfileServiceWidget$onEvent$2.INSTANCE).iterator();
            if (r14.hasNext() == false) goto L35;
            r3 = r14.next();
            if (r14.hasNext() == false) goto L35;
            long r6 = ((NewProfileDialogLauncher) r3).d;
        L30:
            Object r7 = r14.next();
            long r15 = ((NewProfileDialogLauncher) r7).d;
            if (r6 >= r15) goto L34;
            r3 = r7;
            r6 = r15;
        L34:
            if (r14.hasNext() == true) goto L30;
        L35:
            NewProfileDialogLauncher r16 = (NewProfileDialogLauncher) r3;
            if (r16 == null) goto L43;
            r16.b();
            return;
        L43:
            return;
        L19:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
        L20:
            r5 = null;
            goto L21
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            invoke((ps0.a) r1);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.profile.servicewidget.ProfileServiceWidget$onLoad$4, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lps0/d;", "p1", "", "invoke", "(Lps0/d;)V", "<anonymous>"}, k = 3, mv = {1, 4, 3})
    public static final /* synthetic */ class AnonymousClass4 extends FunctionReferenceImpl implements Function1<ps0.d, Unit> {
        public AnonymousClass4(ProfileServiceWidget r8) {
            super(1, r8, ProfileServiceWidget.class, "onEvent", "onEvent(Lcom/bytedance/android/live/profile/api/model/TransitionDialogOpenEvent;)V", 0);
        }

        public final void invoke(ps0.d r3) {
            NewProfileSeeSelfTransitionDialogLauncher r4 = ((ProfileServiceWidget) ((CallableReference) this).receiver).e;
            if (r4 == null) goto L8;
            ALogger.i("TransitionDialogLauncher", "openTransitionDialog");
            NewProfileTransitionDialogManager r5 = r4.c;
            if (r5 == null) goto L9;
            r5.g();
            return;
        L9:
            return;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            invoke((ps0.d) r1);
            return Unit.INSTANCE;
        }
    }

    static {
    }

    public final void onInit(Object[] r1) {
    }

    public final void onUnload() {
        Disposable r0 = this.b;
        if (r0 == null) goto L5;
        r0.dispose();
    L5:
        this.a.clear();
        NewProfileDialogLauncher r1 = this.c;
        if (r1 == null) goto L8;
        r1.b();
    L8:
        this.c = null;
        List<NewProfileDialogLauncher> r2 = this.d;
        if (r2 == null) goto L14;
        Iterator r3 = ((ArrayList) r2).iterator();
    L12:
        if (r3.hasNext() == false) goto L14;
        ((NewProfileDialogLauncher) r3.next()).b();
    L14:
        List<NewProfileDialogLauncher> r4 = this.d;
        if (r4 == null) goto L17;
        ((ArrayList) r4).clear();
    L17:
        NewProfileSeeSelfTransitionDialogLauncher r5 = this.e;
        if (r5 == null) goto L29;
        ALogger.i("TransitionDialogLauncher", "dismiss");
        NewProfileDialogLauncher r6 = r5.a;
        if (r6 == null) goto L22;
        r6.b();
    L22:
        NewProfileDialogLauncher r7 = r5.b;
        if (r7 == null) goto L25;
        r7.b();
    L25:
        NewProfileTransitionDialogManager r8 = r5.c;
        if (r8 == null) goto L28;
        r8.f();
    L28:
        r5.a = null;
        r5.b = null;
        r5.c = null;
    L29:
        this.e = null;
    }

    public ProfileServiceWidget() {
        this.a = new CompositeDisposable();
        this.g = new ArrayList();
    }

    public final void onPause() {
        super/*com.bytedance.android.live.core.tetris.widgets.LiveWidget*/.onPause();
        this.f = true;
    }

    public final void onResume() {
        super/*com.bytedance.android.live.core.tetris.widgets.LiveWidget*/.onResume();
        this.f = false;
    }

    public static boolean zq(IRoom r5) {
        if (r5 != null) goto L4;
    L8:
        return false;
    L4:
        if (r5.getId() <= 0) goto L8;
        if (r5.getOwner() == null) goto L8;
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v110, types: [com.bytedance.android.live.profile.servicewidget.ProfileServiceWidget$onEvent$5] */
    /* JADX WARN: Type inference failed for: r3v25 */
    /* JADX WARN: Type inference failed for: r3v26 */
    /* JADX WARN: Type inference failed for: r3v27, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r3v30 */
    /* JADX WARN: Type inference failed for: r3v31 */
    public final void Aq(final UserProfileEvent r32) {
        DataCenter r0 = ((Widget) this).dataCenter;
        if (r0 == null) goto L5;
        IRoom r1 = (IRoom) r0.get("data_room", null);
    L6:
        ProfileMonitor.g.getClass();
        ProfileMonitor r6 = new ProfileMonitor(r1);
        r6.d(DataType.MonitorVersion, 2);
        if (r32 == null) goto L20;
        String r2 = r32.getTargetUid();
        IBaseUser r3 = r32.user;
        if (r3 == null) goto L13;
        Intrinsics.checkNotNullParameter(r3, "$this$secUidExt");
        String r4 = r3.getCastSecUid();
        if (r4 == null) goto L13;
    L14:
        IBaseUser r9 = r32.user;
        if (r9 == null) goto L18;
        String r10 = r9.getWebcastUid();
        if (r10 == null) goto L18;
    L19:
        r6.d(DataType.TargetUid, r2);
        r6.d(DataType.SecTargetUid, r4);
        r6.d(DataType.WebcastUid, r10);
        r6.d(DataType.ClickUserPosition, r32.getClickUserPosition());
        r6.d(DataType.ReportSource, r32.mReportSource);
    L18:
        r10 = "";
    L13:
        r4 = "";
    L20:
        r6.i(TimeType.ReceiveOpenProfileEvent);
        DataType r5 = DataType.TTNetQuality;
        IMiddlewareHostApp r7 = k.f(IMiddlewareHostApp.class);
        if (r7 == null) goto L25;
        Map r8 = r7.getNQEParams();
        if (r8 == null) goto L25;
        String r12 = (String) r8.get("net_effective_connection_type");
    L26:
        r6.d(r5, r12);
        DataType r13 = DataType.LiveNetQuality;
        ILiveNetworkPredict r14 = k.f(ILiveNetworkPredict.class);
        if (r14 == null) goto L29;
        Integer r15 = Integer.valueOf(r14.obtainSynthesizePredict());
    L30:
        r6.d(r13, r15);
        DataType r16 = DataType.TimeAfterEnterRoom;
        ua1.a r17 = com.bytedance.android.live.service.b.a();
        if (r17 == null) goto L33;
        Long r18 = Long.valueOf(r17.getTimeAfterEnterRoom());
    L34:
        r6.d(r16, r18);
        r6.d(DataType.IsMyLiveEnable, m1.a.getValue());
        if (UnLoginFeatureUtils.INSTANCE.disableUserCardWhenUnLogin(r1) == false) goto L54;
        IMiddlewareUserService r19 = k.f(IMiddlewareUserService.class);
        if (r19 == null) goto L42;
        com.bytedance.android.livesdk.user.e r20 = r19.user();
        if (r20 == null) goto L42;
        if (r20.isLogin() == true) goto L54;
    L42:
        IMiddlewareUserService r22 = k.f(IMiddlewareUserService.class);
        if (r22 == null) goto L51;
        com.bytedance.android.livesdk.user.e r23 = r22.user();
        if (r23 == null) goto L51;
        Context r24 = ((Widget) this).context;
        l.a r25 = new l.a();
        r25.e = "live_detail";
        r25.f = "click_profile_card";
        Observable r26 = r23.login(r24, new l(r25));
        if (r26 == null) goto L51;
        Observable r27 = r26.compose(getAutoUnbindTransformer());
        if (r27 == null) goto L51;
        r27.subscribe(new h());
        Unit r28 = Unit.INSTANCE;
    L51:
        r6.a(EndType.Unlogin, "");
        return;
    L54:
        if (((Widget) this).isViewValid == true) goto L57;
        r6.a(EndType.ViewInvalid, "");
        return;
    L57:
        NewProfileDialogLauncher r29 = this.c;
        if (r29 != null) goto L60;
    L62:
        List<NewProfileDialogLauncher> r30 = this.d;
        if (r30 == null) goto L70;
        Iterator r33 = ((ArrayList) r30).iterator();
    L66:
        if (r33.hasNext() == false) goto L70;
        if (((NewProfileDialogLauncher) r33.next()).c() == false) goto L66;
    L69:
        boolean r34 = true;
    L71:
        if (r32 != null) goto L73;
    L75:
        boolean r35 = false;
    L76:
        r6.d(DataType.IsExistDialogShowing, Boolean.valueOf(r34));
        r6.d(DataType.IsSkipExistPanelCheck, Boolean.valueOf(r35));
        if (r34 == false) goto L81;
        if (r35 == true) goto L81;
        r6.a(EndType.ProfileLauncherShowing, "");
        return;
    L81:
        NewProfileSeeSelfTransitionDialogLauncher r36 = this.e;
        if (r36 == null) goto L101;
        NewProfileDialogLauncher r37 = r36.a;
        if (r37 != null) goto L86;
    L87:
        NewProfileDialogLauncher r38 = r36.b;
        if (r38 != null) goto L90;
    L91:
        NewProfileTransitionDialogManager r39 = r36.c;
        if (r39 != null) goto L94;
    L96:
        boolean r40 = false;
    L97:
        if (r40 != true) goto L101;
        r6.a(EndType.TransitionProfileLauncherShowing, "");
        return;
    L94:
        if (r39.isShowing() != true) goto L96;
    L95:
        r40 = true;
        goto L97
    L90:
        if (r38.c() == true) goto L95;
    L86:
        if (r37.c() == true) goto L95;
    L101:
        if (((Widget) this).context != null) goto L103;
    L534:
        r6.a(EndType.ActivityNullOrPause, "");
        return;
    L103:
        if (this.f == true) goto L534;
        DataCenter r42 = ((Widget) this).dataCenter;
        if (r42 == null) goto L110;
        Integer r43 = (Integer) r42.get("data_link_state", 0);
        if (r43 == null) goto L110;
        int r44 = r43.intValue();
    L112:
        if (v.a(r44, 2) == false) goto L119;
        DataCenter r45 = ((Widget) this).dataCenter;
        if (r45 == null) goto L132;
        Boolean r46 = (Boolean) r45.get("data_intimate_chat_support_send_gift_to_linker", Boolean.FALSE);
        if (r46 == null) goto L132;
        boolean r47 = r46.booleanValue();
    L133:
        if (r32 != null) goto L135;
    L161:
        if (r32 == null) goto L164;
        if (r47 == true) goto L164;
        r32.showSendGift = false;
    L164:
        DataCenter r48 = ((Widget) this).dataCenter;
        if (r48 == null) goto L169;
        Boolean r49 = (Boolean) r48.get("data_support_send_gift_to_official_channel_host", Boolean.TRUE);
        if (r49 == null) goto L169;
        boolean r50 = r49.booleanValue();
    L170:
        if (r32 == null) goto L175;
        IBaseUser r52 = r32.user;
        if (r52 == null) goto L174;
        String r53 = r52.getIdString();
    L177:
        if (os0.b.c().getIInteractService().isMicRoomHost(r53.toString()) == false) goto L180;
        if (r32 == null) goto L180;
        r32.showSendGift = r50;
    L180:
        if (r32 != null) goto L183;
        r6.a(EndType.EventIsNull, "");
        return;
    L183:
        IBaseUser r54 = r32.user;
        if (r54 == null) goto L188;
        String r55 = r54.getIdString();
        if (r55 == null) goto L190;
    L191:
        DataCenter r56 = ((Widget) this).dataCenter;
        if (r56 == null) goto L194;
        IBaseUser r210 = (IBaseUser) r56.get("data_user_in_room", null);
    L195:
        if (r210 == null) goto L199;
        t r57 = r210.getUserAttrExt();
        if (r57 == null) goto L199;
        boolean r110 = r57.isAdmin();
    L201:
        if (k.n(IMiddlewareUserService.class).user().isLogin() == false) goto L203;
        boolean r58 = Intrinsics.areEqual(k.n(IMiddlewareUserService.class).user().n(), r55);
    L204:
        DataCenter r59 = ((Widget) this).dataCenter;
        if (r59 == null) goto L207;
        IRoom r60 = (IRoom) r59.get("data_room", null);
    L208:
        if (r60 != null) goto L210;
    L212:
        boolean r62 = false;
    L213:
        if (r60 != null) goto L215;
    L219:
        boolean r63 = false;
    L220:
        DataCenter r111 = ((Widget) this).dataCenter;
        if (r111 == null) goto L223;
        IBaseUser r112 = (IBaseUser) r111.get("data_user_in_room");
    L224:
        if (r60 == null) goto L228;
        IBaseUser r113 = r60.getOwner();
        if (r113 == null) goto L228;
        String r114 = r113.getIdString();
    L229:
        if (r112 != null) goto L231;
    L235:
        boolean r115 = false;
    L236:
        r6.e(r55, r110, r58, r62, r63, r115);
        boolean r116 = r32.isForceSecret();
        boolean r117 = r32.isIntercomHideUserCard();
        String r118 = r32.getClickUserPosition();
        if (r32.isSkipPrivacyCheck() == false) goto L239;
        boolean r119 = true;
    L240:
        String r211 = "live_detail";
        boolean r64 = r58;
        String r212 = r55;
        boolean r65 = r115;
        String r213 = "";
        boolean r66 = r110;
        String r214 = r114;
        r6.f(r116, r117, r118, r119, r32.mSource);
        ALogger.i("AbsInteractionFragment.openProfile", "isAdmin: " + r66 + ", isToSelf: " + r64 + ", isToAnchor: " + r62 + ", isToUnionAnchor:" + r63 + ", selfIsAnchor: " + r65);
        r6.d(DataType.ForceShowProfile, Boolean.valueOf(r32.forceShowProfile));
        if (r32.forceShowProfile != true) goto L244;
        r66 = r66;
        r60 = r60;
        r6 = r6;
        r211 = r211;
        r213 = r213;
        ?? r67 = 0;
    L275:
        c0.a r68 = os0.b.c().getRoomServiceProxy().getRecordService();
        if (a0.a(((Widget) this).dataCenter) == null) goto L288;
        IAbilityCenter r69 = a0.a(((Widget) this).dataCenter);
        if (r69 == null) goto L280;
        IRoomRecordService r70 = (IRoomRecordService) r69.getAbility(IRoomRecordService.class);
    L281:
        if (r70 == null) goto L288;
        IAbilityCenter r72 = a0.a(((Widget) this).dataCenter);
        if (r72 == null) goto L287;
        IRoomRecordService r73 = r72.getAbility(IRoomRecordService.class);
        if (r73 == null) goto L287;
        boolean r74 = r73.isRecording();
    L289:
        if (r74 == false) goto L294;
        if (r68.k() == false) goto L294;
        r6.d(DataType.IsClearAndRecord, Boolean.TRUE);
        r67 = 1;
    L294:
        if (zq(r60) == false) goto L532;
        if (r60 == null) goto L532;
        o0.a.getClass();
        if (o0.a.b(r212) == false) goto L302;
        String r75 = r212;
        if (Intrinsics.areEqual(r75, r214) == false) goto L303;
        boolean r76 = true;
    L304:
        s r77 = os0.b.c().getIMicRoomService();
        if (r77 != null) goto L307;
    L309:
        boolean r78 = false;
    L310:
        if (r77 == null) goto L315;
        if (r78 == false) goto L315;
        if (r77.isLoyalAudience() == false) goto L315;
        boolean r79 = true;
    L316:
        if (r78 == true) goto L318;
    L320:
        boolean r80 = false;
    L321:
        final ProfileMonitor r120 = r6;
        if (r60.isUnionLiveRoom() != true) goto L324;
        boolean r82 = true;
    L325:
        if (r82 == false) goto L327;
        boolean r121 = r60.isGuestAnchor(r75);
    L328:
        if (r78 == false) goto L335;
        if (r80 == false) goto L335;
        if (r65 == false) goto L332;
        String r83 = "carousel_anchor_c_carousel_host";
    L344:
        HashMap r84 = new HashMap();
        r84.put("click_type", r83);
        r84.put("request_page", r83);
        r84.put("to_user_id", r75);
        r84.put("profile_hide", String.valueOf(r67));
        r84.put("send_gift", String.valueOf(r32.showSendGift ? 1 : 0));
        r84.put("is_vr_machine", os0.b.c().getVrUtils().getVrMachineLogStr(((Widget) this).dataCenter));
        u r85 = r32.mCommentReportModel;
        if (r85 == null) goto L350;
        String r86 = r85.f();
        if (r86 != null) goto L349;
        r86 = r213;
    L349:
        r84.put("to_comment_type", r86);
    L350:
        String r87 = "guest";
        if (r82 == false) goto L369;
        if (r76 == false) goto L354;
        r87 = "anchor";
    L356:
        r84.put("is_joint_room", DataType.TRUE);
        if (r60.isUnionLiveInfoNotNull() == false) goto L371;
        DataCenter r88 = ((Widget) this).dataCenter;
        if (r88 == null) goto L361;
        String r89 = (String) r88.get("data_joint_anchor_id", r213);
    L362:
        if (r89 == null) goto L371;
        DataCenter r90 = ((Widget) this).dataCenter;
        if (r90 == null) goto L367;
        String r92 = (String) r90.get("data_joint_anchor_id", r213);
        if (r92 == null) goto L367;
    L368:
        r84.put("joint_anchor_id", r92);
    L367:
        r92 = r213;
        goto L368
    L361:
        r89 = null;
    L371:
        r84.put("to_user_type", r87);
        if (r32.isFromInteractEmojiPanel == false) goto L374;
        Object r122 = DataType.TRUE;
    L375:
        r84.put("is_emoji_panel", r122);
        String r93 = r32.mSource;
        if (r93 != null) goto L379;
        r93 = r213;
    L379:
        r84.put("source", r93);
        DataCenter r94 = ((Widget) this).dataCenter;
        if (r94 == null) goto L389;
        Integer r95 = (Integer) r94.get("data_link_state", 0);
        if (r95 == null) goto L384;
        int r96 = r95.intValue();
    L385:
        String r97 = os0.b.c().getIInteractService().changeMode2String(r96);
        if (r97 != null) goto L388;
        r97 = r213;
    L388:
        r84.put("send_gift_scene", r97);
        goto L389
    L384:
        r96 = 0;
    L389:
        LiveMode r98 = r60.getStreamType();
        int r99 = h1.a;
        r84.put("live_type", i1.a(r98));
        os0.b.c().getLiveSdkLogUtil().c(r84);
        if (TextUtils.isEmpty(r32.mEventModule) == true) goto L392;
        r84.put("event_module", r32.mEventModule);
    L392:
        int r100 = r32.order;
        if (r100 == (-1)) goto L396;
        r84.put("order", String.valueOf(r100));
    L396:
        if (TextUtils.isEmpty(r32.ksongUserType) == true) goto L399;
        r84.put("ksong_user_type", r32.ksongUserType);
    L399:
        if (TextUtils.isEmpty(r32.ksongToUserType) == true) goto L401;
        r84.put("ksong_to_user_type", r32.ksongToUserType);
    L401:
        IBaseUser r101 = r60.getOwner();
        if (r101 == null) goto L404;
        x r102 = r101.getIndustryCertification();
    L405:
        if (r102 == null) goto L408;
        r84.put("is_jade_room", DataType.TRUE);
        r84.put("EVENT_ORIGIN_FEATURE", "TEMAI");
    L408:
        if (os0.b.c().getLinkPlayerState().getData() != 2) goto L410;
        Object r123 = DataType.TRUE;
    L411:
        r84.put("is_line", r123);
        String r103 = r32.ktvChallengePlayerType;
        if (r103 == null) goto L415;
        r84.put("if_click_player", r103);
    L415:
        if (os0.b.b(((Widget) this).dataCenter).e() == false) goto L417;
        Object r104 = DataType.FALSE;
        r84.put("if_clear_mode", r104);
        Object r105 = r104;
    L426:
        boolean r106 = com.bytedance.android.live.revenue.core.util.h.a;
        ILinkService r107 = (ILinkService) com.bytedance.android.live.revenue.core.util.h.d(ILinkService.class);
        p11.h r108 = r107.mo470getPkService();
        if (r108 != null) goto L429;
    L435:
        r84.put("pk_id", r213);
        r84.put("is_in_pk", r105);
    L436:
        String r109 = r32.mUserStatus;
        if (r109 == null) goto L440;
        r84.put("user_status", r109);
    L440:
        if (TextUtils.isEmpty(r32.wearId) == false) goto L442;
        String r124 = "none";
    L443:
        r84.put("wear_id", r124);
        com.bytedance.android.livesdk.log.filter.u r125 = j0.l().c(IRoom.class);
        if (r125 == null) goto L454;
        if ((r125 instanceof com.bytedance.android.livesdk.log.filter.u) == false) goto L454;
        com.bytedance.android.livesdk.log.filter.u r126 = r125;
        if (r126.getMap().containsKey("log_pb") == false) goto L454;
        String r127 = (String) r126.getMap().get("log_pb");
        if (r127 != null) goto L452;
        r127 = r213;
    L452:
        r84.put("log_pb", r127);
    L454:
        if (a0.d(((Widget) this).dataCenter, false) == false) goto L456;
        r84.put("user_type", "anchor");
    L459:
        Map r128 = r32.getExtraProfileClickUserLog();
        if (r128 == null) goto L462;
        r84.putAll(r128);
        Unit r129 = Unit.INSTANCE;
    L462:
        j0 r130 = j0.l();
        am2.x r131 = new am2.x();
        r131.b = r211;
        r131.a = "live_interact";
        am2.c r132 = new am2.c();
        r132.a = r32.mClickUserPosition;
        r130.sendLog("livesdk_live_click_user", r84, new Object[]{am2.u.class, IRoom.class, r131, r132, new z(), n.f()});
        IGiftServiceExternal r133 = k.f(IGiftServiceExternal.class);
        if (r133 == null) goto L468;
        o r134 = r133.getRevenueEventCenter();
        if (r134 == null) goto L468;
        r134.f();
        Unit r135 = Unit.INSTANCE;
    L468:
        if (c1.b(((Widget) this).dataCenter) == false) goto L482;
        if (r60.getOwner() == null) goto L482;
        JSONObject r136 = new JSONObject();
        IBaseUser r137 = r60.getOwner();     // Catch: Exception -> L478
        if (r137 == null) goto L475;
        String r138 = r137.getIdString();     // Catch: Exception -> L478
    L476:
        r136.put("anchor_id", String.valueOf(r138));     // Catch: Exception -> L478
        r136.put("room_id", String.valueOf(r60.getId()));     // Catch: Exception -> L478
    L480:
        os0.b.c().getLiveRoomEventParamUtils().handleLiveAdExtraData(r136);
        ILiveDouPlusService r139 = k.n(ILiveDouPlusService.class);
        os0.c r140 = new os0.c();
        r140.a(r136);
        r140.b(c1.e(((Widget) this).dataCenter));
        r139.logEvent(true, "live_ad", "live_clickuser", r140.a);
        goto L482
    L475:
        r138 = null;
    L478:
        e = move-exception;
        ALogger.e("ProfileServiceWidget", e);
    L482:
        if (c1.c(((Widget) this).dataCenter) == true) goto L484;
    L495:
        JSONObject r141 = new JSONObject();
        ss0.b r142 = (ss0.b) y0.a.getValue();     // Catch: Exception -> L508
        if (r142 != null) goto L499;
    L501:
        String r143 = "native";
    L502:
        r141.put("type", r143);     // Catch: Exception -> L508
        if (r142.a() == false) goto L505;
        String r144 = UriProtector.parse(UriProtector.getQueryParameter(UriProtector.parse(r142.c()), "url")).getPath();     // Catch: Exception -> L508
    L506:
        r141.put("path", r144);     // Catch: Exception -> L508
    L510:
        LiveSlardarMonitor.monitorStatus("ttlive_monitor_click_user", 0, r141);
        r120.d(DataType.HideProfile, Boolean.valueOf(r67));
        if (r67 == 0) goto L514;
        r120.a(EndType.HideProfile, r213);
        return;
    L514:
        LiveSlardarMonitor.monitorStatus("ttlive_monitor_click_user_pre_show", 0, r141);
        int r145 = NewProfileSeeSelfTransitionDialogLauncher.d;
        if (NewProfileSeeSelfTransitionDialogLauncher.a.a(r32) == false) goto L530;
        r120.d(DataType.ProfileOpenMode, DataType.Transition);
        if (this.e != null) goto L519;
        this.e = new NewProfileSeeSelfTransitionDialogLauncher();
    L519:
        NewProfileSeeSelfTransitionDialogLauncher r146 = this.e;
        if (r146 == null) goto L526;
        FragmentActivity r147 = ContextUtil.contextToFragmentActivity(((Widget) this).context);
        DataCenter r148 = ((Widget) this).dataCenter;
        boolean r149 = isScreenPortrait();
        DataCenter r150 = ((Widget) this).dataCenter;
        if (r150 == null) goto L524;
        String r151 = (String) r150.get("log_enter_live_source", r213);
    L525:
        Disposable r152 = r146.d(r120, r147, r60, r148, r149, r210, r151, r32);
    L527:
        if (r152 == null) goto L552;
        this.a.add(r152);
        return;
    L552:
        return;
    L524:
        r151 = null;
        goto L525
    L526:
        r152 = null;
        goto L527
    L530:
        final IRoom r153 = r60;
        final IBaseUser r154 = r210;
        new ProfileServiceWidget$onEvent$5(this, r120, r153, r154, r32).m22invoke();
        return;
    L505:
        r144 = r213;
        goto L506
    L499:
        if (r142.a() == false) goto L501;
        r143 = "lynx";
    L508:
        e = move-exception;
        e.printStackTrace();
        goto L510
    L484:
        if (r60.getOwner() == null) goto L495;
        JSONObject r155 = new JSONObject();
        IBaseUser r156 = r60.getOwner();     // Catch: Exception -> L492
        if (r156 == null) goto L489;
        String r157 = r156.getIdString();     // Catch: Exception -> L492
    L490:
        r155.put("anchor_id", String.valueOf(r157));     // Catch: Exception -> L492
        r155.put("room_id", String.valueOf(r60.getId()));     // Catch: Exception -> L492
    L494:
        os0.b.c().getLiveRoomEventParamUtils().handleLiveAdExtraData(r155);
        ILiveDouPlusService r158 = k.n(ILiveDouPlusService.class);
        os0.c r159 = new os0.c();
        r159.a(r155);
        r159.b(c1.f(((Widget) this).dataCenter));
        r158.logEvent(true, "live_ad", "live_clickuser", r159.a);
        goto L495
    L489:
        r157 = null;
    L492:
        e = move-exception;
        ALogger.e("ProfileServiceWidget", e);
        goto L494
    L456:
        if (r66 == false) goto L458;
        r84.put("user_type", "admin");
        goto L459
    L458:
        r84.put("user_type", "user");
        goto L459
    L442:
        r124 = r32.wearId;
        goto L443
    L429:
        if (r108.getPkState() != 1) goto L435;
        j r160 = r107.mo471getRevenueLinkDataHolder();
        if (r160 == null) goto L433;
        Long r161 = Long.valueOf(r160.getPkId());
    L434:
        r84.put("pk_id", String.valueOf(r161.longValue()));
        r84.put("is_in_pk", DataType.TRUE);
        goto L436
    L433:
        r161 = null;
        goto L434
    L417:
        Object r162 = DataType.FALSE;
        com.bytedance.android.livesdk.chatroom.o r163 = os0.b.a();
        if (r163 == null) goto L424;
        m r164 = r163.isCleanMode();
        if (r164 == null) goto L424;
        if (((Boolean) r164.getValue()).booleanValue() != true) goto L424;
        Object r165 = DataType.TRUE;
    L425:
        r84.put("if_clear_mode", r165);
        r105 = r162;
    L424:
        r165 = r162;
        goto L425
    L410:
        r123 = DataType.FALSE;
        goto L411
    L404:
        r102 = null;
        goto L405
    L374:
        r122 = DataType.FALSE;
        goto L375
    L354:
        if (r121 == false) goto L356;
        r87 = "joint_anchor";
        goto L356
    L369:
        if (r76 == false) goto L371;
        r87 = "anchor";
        goto L371
    L332:
        if (r79 == false) goto L334;
        r83 = "loyal_audience_c_carousel_host";
        goto L344
    L334:
        r83 = "carousel_audience_c_carousel_host";
    L335:
        if (r65 == false) goto L339;
        if (r76 == false) goto L338;
        r83 = "anchor_c_anchor";
        goto L344
    L338:
        r83 = "anchor_c_audience";
        goto L344
    L339:
        if (r76 == false) goto L341;
        r83 = "audience_c_anchor";
        goto L344
    L341:
        if (r121 == false) goto L343;
        r83 = "live_audience_c_joint_anchor";
        goto L344
    L343:
        r83 = "audience_c_audience";
        goto L344
    L327:
        r121 = false;
        goto L328
    L324:
        r82 = false;
        goto L325
    L318:
        if (os0.b.c().getIInteractService().isMicRoomHost(r75) == false) goto L320;
        r80 = true;
    L315:
        r79 = false;
        goto L316
    L307:
        if (r77.isMicRoom(r60) == false) goto L309;
        r78 = true;
    L303:
        r76 = false;
        goto L304
    L302:
        r75 = r212;
    L532:
        r6.a(EndType.RoomIllegal, r213);
        return;
    L287:
        r74 = false;
        goto L289
    L280:
        r70 = null;
    L288:
        r74 = r68.l();
        goto L289
    L244:
        if (yq(r60, r66, r64, r62, r63, r65) == false) goto L246;
    L249:
        ALogger.i("AbsInteractionFragment.openProfile", "isForceSecret: " + r32.isForceSecret() + ", isIntercomHideUserCard" + r32.isIntercomHideUserCard());
        StringBuilder r166 = new StringBuilder("clickUserPosition: ");
        r166.append(r32.getClickUserPosition());
        r166.append(", isSkipPrivacyCheck: ");
        if (r32.isSkipPrivacyCheck() == false) goto L252;
        boolean r167 = true;
    L253:
        r166.append(r167);
        ALogger.i("AbsInteractionFragment.openProfile", r166.toString());
        if (TextUtils.equals(r32.getClickUserPosition(), "live_open_top_left_anchor") == false) goto L256;
    L273:
        r66 = r66;
        r60 = r60;
        r6 = r6;
        r211 = r211;
        r213 = r213;
        boolean r168 = false;
    L274:
        r6.d(DataType.HideProfileCheckFirst, Boolean.valueOf(r168));
        r67 = xq(r6, r60, r32, r212, r168);
        goto L275
    L256:
        if (TextUtils.equals(r32.getClickUserPosition(), "live_pk_right_anchor") == true) goto L273;
        if (r32.showProfileInfoCard() == true) goto L273;
        if (r32.isSkipPrivacyCheck() == false) goto L262;
        boolean r169 = true;
    L263:
        if (r169 == true) goto L273;
        ALogger.i("AbsInteractionFragment.openProfile", "source" + r32.mSource);
        if (TextUtils.equals(r32.mSource, NewProfileInfoViewModel.PAGE_NAME) == true) goto L269;
        if (TextUtils.equals(r32.mSource, "live_barrage") == true) goto L269;
    L271:
        f2.b(2131914660, 0);
    L272:
        r168 = true;
    L269:
        if (r32.forceShowToast == true) goto L271;
        r6.c = true;
        LiveRepoDialog.T90(r6, ContextUtil.contextToFragmentActivity(((Widget) this).context), isScreenPortrait(), r60, r32, s1.B(2131914661));
        goto L272
    L262:
        r169 = false;
        goto L263
    L252:
        r167 = false;
        goto L253
    L246:
        if (wq(r60, r32) == true) goto L249;
        if (r32.isIntercomHideUserCard() == false) goto L273;
    L239:
        r119 = false;
        goto L240
    L231:
        if (r112.getIdString() == null) goto L235;
        if (Intrinsics.areEqual(r112.getIdString(), r114) == false) goto L235;
        r115 = true;
    L228:
        r114 = null;
        goto L229
    L223:
        r112 = null;
        goto L224
    L215:
        if (r60.isUnionLiveRoom() != true) goto L219;
        if (r60.isGuestAnchor(r55) != true) goto L219;
        r63 = true;
        goto L220
    L210:
        if (Intrinsics.areEqual(r60.getOwnerUserIdString(), r55) == false) goto L212;
        r62 = true;
        goto L213
    L207:
        r60 = null;
        goto L208
    L203:
        r58 = false;
    L199:
        r110 = false;
        goto L201
    L194:
        r210 = null;
    L190:
        r55 = DataType.FALSE;
        goto L191
    L188:
        r55 = r32.getUserIdStr();
        if (r55 != null) goto L191;
    L174:
        r53 = r32.getUserIdStr();
        goto L177
    L175:
        r53 = "";
    L169:
        r50 = true;
        goto L170
    L135:
        if (Lists.isEmpty(this.g) == true) goto L161;
        if (r47 == false) goto L161;
        Iterator<? extends ILinkPlayerInfoBridge> r170 = this.g.iterator();
    L139:
        if (r170.hasNext() == false) goto L164;
        ILinkPlayerInfoBridge r171 = r170.next();
        if (r171 == null) goto L143;
        IBaseUser r172 = r171.getUser();
    L144:
        if (r172 == null) goto L139;
        IBaseUser r173 = r32.user;
        if (r173 == null) goto L154;
        String r174 = r173.getIdString();
        IBaseUser r175 = r171.getUser();
        if (r175 == null) goto L151;
        String r176 = r175.getIdString();
    L153:
        if (Intrinsics.areEqual(r174, r176) == false) goto L154;
    L160:
        r32.showSendGift = true;
        goto L164
    L151:
        r176 = null;
    L154:
        String r177 = r32.getUserIdStr();
        IBaseUser r178 = r171.getUser();
        if (r178 == null) goto L157;
        String r179 = r178.getIdString();
    L159:
        if (Intrinsics.areEqual(r177, r179) == false) goto L139;
    L157:
        r179 = null;
        goto L159
    L143:
        r172 = null;
    L132:
        r47 = false;
        goto L133
    L119:
        if (v.a(r44, 8) == false) goto L126;
        DataCenter r180 = ((Widget) this).dataCenter;
        if (r180 == null) goto L132;
        Boolean r181 = (Boolean) r180.get("data_audio_chat_support_send_gift_to_linker", Boolean.FALSE);
        if (r181 == null) goto L132;
        r47 = r181.booleanValue();
        goto L133
    L126:
        if (v.a(r44, 32) == false) goto L132;
        DataCenter r182 = ((Widget) this).dataCenter;
        if (r182 == null) goto L132;
        Boolean r183 = (Boolean) r182.get("data_big_party_support_send_gift_to_linker", Boolean.FALSE);
        if (r183 == null) goto L132;
        r47 = r183.booleanValue();
    L110:
        r44 = 0;
        goto L112
    L73:
        if (r32.isSkipExistPanelCheck() != true) goto L75;
        r35 = true;
    L70:
        r34 = false;
        goto L71
    L60:
        if (r29.c() != true) goto L62;
    L33:
        r18 = null;
        goto L34
    L29:
        r15 = null;
    L25:
        r12 = null;
        goto L26
    L5:
        r1 = null;
        goto L6
    }

    public final void onChanged(Object r4) {
        KVData r5 = (KVData) r4;
        if (isViewValid() == false) goto L27;
        if (r5 == null) goto L31;
        String r0 = r5.getKey();
        int r1 = r0.hashCode();
        if (r1 == (-1093702240)) goto L18;
        if (r1 == 1722450802) goto L12;
        return;
    L12:
        if (r0.equals("cmd_show_user_profile") == false) goto L28;
        UserProfileEvent r6 = (UserProfileEvent) r5.getData();
        if (r6 == null) goto L33;
        r6.interactLogLabel = (String) ((Widget) this).dataCenter.get("Log_interact_lable");
        Aq(r6);
        return;
    L33:
        return;
    L28:
        return;
    L18:
        if (r0.equals("data_online_changed_list") == false) goto L30;
        DataCenter r2 = ((Widget) this).dataCenter;
        if (r2 == null) goto L24;
        ArrayList r7 = (ArrayList) r2.get("data_online_changed_list", new ArrayList());
        if (r7 == null) goto L24;
    L25:
        this.g = r7;
        return;
    L24:
        r7 = new ArrayList();
        goto L25
    L30:
        return;
    L31:
        return;
    }

    public final void onLoad(Object[] r6) {
        boolean r7 = false;
        this.f = false;
        this.g = new ArrayList();
        Bq(v2.class, new AnonymousClass1(this));
        Bq(UserProfileEvent.class, new AnonymousClass2(this));
        Bq(ps0.a.class, new AnonymousClass3(this));
        if (((Boolean) gs.a.getValue()).booleanValue() == false) goto L25;
        DataCenter r0 = ((Widget) this).dataCenter;
        if (r0 == null) goto L25;
        IRoom r1 = (IRoom) r0.get("data_room", null);
        if (r1 == null) goto L25;
        Map r2 = jc6.a.a;
        String r3 = String.valueOf(r1.getId());
        Intrinsics.checkNotNullParameter(r3, "key");
        Map r4 = jc6.a.a;
        LinkedHashMap r5 = (LinkedHashMap) r4;
        if (((PublishSubject) r5.get(r3)) != null) goto L13;
        int r8 = com.bytedance.kmp.rxkmp.a.a;
        PublishSubject r9 = PublishSubject.create();
        r4.put(r3, r9);
    L14:
        if (r9 == null) goto L20;
        Observable r10 = r9.filter(c.a);
        if (r10 == null) goto L20;
        Observable r12 = r10.map(d.a);
        if (r12 == null) goto L20;
        int r13 = com.bytedance.kmp.rxkmp.b.a;
        Observable r14 = r12.observeOn(AndroidSchedulers.mainThread());
    L21:
        if (r14 == null) goto L25;
        Disposable r15 = r14.subscribe(new e(this));
        if (r15 == null) goto L25;
        RxUtilKt.c(r15, this.a);
    L20:
        r14 = null;
        goto L21
    L13:
        r9 = (PublishSubject) r5.get(r3);
    L25:
        Bq(ps0.d.class, new AnonymousClass4(this));
        DataCenter r16 = ((Widget) this).dataCenter;
        if (r16 == null) goto L30;
        DataCenter r17 = r16.observe("data_online_changed_list", this);
        if (r17 == null) goto L30;
        r17.observe("cmd_show_user_profile", this);
    L30:
        DataCenter r18 = ((Widget) this).dataCenter;
        if (r18 == null) goto L33;
        String r19 = (String) r18.get("data_white_cert_schema", null);
    L34:
        DataCenter r20 = ((Widget) this).dataCenter;
        if (r20 == null) goto L37;
        r20.put("data_white_cert_schema", null);
    L37:
        if (r19 != null) goto L39;
    L40:
        r7 = true;
    L41:
        if (r7 == false) goto L43;
        return;
    L43:
        if (isScreenPortrait() == false) goto L51;
        IBaseLiveActionHandler r22 = k.f(IBaseLiveActionHandler.class);
        if (r22 == null) goto L50;
        r22.handle(((Widget) this).context, r19);
        return;
    L50:
        return;
    L51:
        return;
    L39:
        if (r19.length() != 0) goto L41;
    L33:
        r19 = null;
        goto L34
    }

    public static boolean wq(IRoom r0, UserProfileEvent r1) {
        if (r1.isForceSecret() == true) goto L5;
    L12:
        return false;
    L5:
        if (((Boolean) o4.a.getValue()).booleanValue() == false) goto L12;
        if (r0 == null) goto L12;
        if (r0.getRoomAuthStatus() == null) goto L12;
        if (r0.getRoomAuthStatus().getEnableUserCard() == true) goto L12;
        return true;
    }

    public final <T> void Bq(Class<T> r2, Function1<? super T, Unit> r3) {
        RxUtilKt.c(xs2.b.a().b(r2).observeOn(AndroidSchedulers.mainThread()).subscribe(new b(r3)), this.a);
    }

    public final boolean xq(ProfileMonitor r10, IRoom r12, UserProfileEvent r13, String r14, boolean r15) {
        if (r13 != null) goto L4;
        return r15;
    L4:
        i r2 = os0.b.c().getIInteractService();
        if (r13.isAnonymous == false) goto L8;
        f2.c(s1.B(2131918948), 0);
        return true;
    L8:
        if (r13.user != null) goto L22;
        o0.a r3 = o0.a;
        String r8 = r13.getUserIdStr();
        r3.getClass();
        if (o0.a.b(r8) == false) goto L22;
        if (Intrinsics.areEqual("top_single_room_rank", r13.mSource) == false) goto L14;
    L17:
        if (r2 == null) goto L55;
        if (r2.isAnonymousUser(r14) == false) goto L55;
        f2.c(s1.B(2131918948), 0);
        return true;
    L55:
        return r15;
    L14:
        if (Intrinsics.areEqual("single_room_rank", r13.mSource) == true) goto L17;
        if (r13.mSource == null) goto L17;
    L22:
        if (k.f(IMiddlewareUserService.class) != null) goto L24;
    L35:
        IBaseUser r4 = r13.user;
        if (r4 != null) goto L38;
    L43:
        IBaseUser r5 = r13.user;
        if (r5 == null) goto L55;
        if (r5.isAnonymous() == true) goto L55;
        if (r2 == null) goto L55;
        if (r2.isAnonymousUser(r14) == false) goto L55;
        if (r13.forceShowToast == false) goto L53;
        f2.c(s1.B(2131919568), 0);
        return true;
    L53:
        r10.c = true;
        LiveRepoDialog.T90(r10, ContextUtil.contextToFragmentActivity(((Widget) this).context), isScreenPortrait(), r12, r13, s1.B(2131919568));
        return true;
    L38:
        if (r4.isAnonymous() == false) goto L43;
        if (r13.forceShowToast == false) goto L42;
        f2.c(s1.B(2131918948), 0);
        return true;
    L42:
        r10.c = true;
        LiveRepoDialog.T90(r10, ContextUtil.contextToFragmentActivity(((Widget) this).context), isScreenPortrait(), r12, r13, s1.B(2131918948));
        return true;
    L24:
        if (k.n(IMiddlewareUserService.class).user() == null) goto L35;
        if (Intrinsics.areEqual(k.n(IMiddlewareUserService.class).user().n(), r14) == false) goto L35;
        if (r2 != null) goto L29;
    L30:
        IBaseUser r6 = r13.user;
        if (r6 == null) goto L35;
        if (r6.isAnonymous() == false) goto L35;
    L34:
        f2.c(s1.B(2131918948), 0);
        return true;
    L29:
        if (r2.isAnonymousUser(r14) == true) goto L34;
        goto L30
    }

    public static boolean yq(IRoom r1, boolean r2, boolean r3, boolean r4, boolean r5, boolean r6) {
        if (((Boolean) o4.a.getValue()).booleanValue() == false) goto L15;
        if (r1 == null) goto L15;
        if (r1.getRoomAuthStatus() == null) goto L15;
        if (r1.getRoomAuthStatus().getEnableUserCard() == true) goto L15;
        if (r2 == true) goto L15;
        if (r3 == true) goto L15;
        if (r4 == true) goto L15;
        if (r5 == true) goto L15;
        if (r6 == true) goto L15;
        return true;
    L15:
        return false;
    }
}
