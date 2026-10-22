package com.bytedance.android.live.profile;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.PointF;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;
import androidx.constraintlayout.widget.Barrier;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import ca0.o;
import com.bytedance.android.live.base.model.user.Appointment;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.base.model.user.NewProfileUser;
import com.bytedance.android.live.base.model.user.UserEvent;
import com.bytedance.android.live.base.model.user.UserProfileDataResp;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.monitor.LiveMonitor;
import com.bytedance.android.live.core.monitor.LiveSlardarMonitor;
import com.bytedance.android.live.core.monitor.LiveTracingMonitor;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.rxutils.autodispose.AutoDispose;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.live.core.utils.rxutils.autodispose.v;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.utils.screen.FoldScreenUtils;
import com.bytedance.android.live.gift.IGiftServiceExternal;
import com.bytedance.android.live.network.response.BaseResponse;
import com.bytedance.android.live.profile.customview.TransitionConstraintLayout;
import com.bytedance.android.live.profile.model.EnterExitStateType;
import com.bytedance.android.live.profile.model.ProfileRoomProxy;
import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.android.live.profile.monitor.EndType;
import com.bytedance.android.live.profile.monitor.EventType;
import com.bytedance.android.live.profile.monitor.ProfileMonitor;
import com.bytedance.android.live.profile.monitor.TimeType;
import com.bytedance.android.live.profile.p000enum.ProfileMode;
import com.bytedance.android.live.profile.ui.AnchorSeeAudienceBehavior;
import com.bytedance.android.live.profile.ui.AnchorSeeSelfBehavior;
import com.bytedance.android.live.profile.ui.AudienceSeeAnchorBehavior;
import com.bytedance.android.live.profile.ui.AudienceSeeAudienceBehavior;
import com.bytedance.android.live.profile.ui.AudienceSeeSelfBehavior;
import com.bytedance.android.live.profile.ui.MediaLiveRoomBehavior;
import com.bytedance.android.live.profile.ui.MicRoomBehavior;
import com.bytedance.android.live.profile.ui.NoAuthorityAudienceBehavior;
import com.bytedance.android.live.profile.ui.base.BaseUiBehavior;
import com.bytedance.android.live.profile.ui.base.m;
import com.bytedance.android.live.profile.ui.util.n;
import com.bytedance.android.live.profile.ui.util.t;
import com.bytedance.android.live.profile.usecase.NewProfileTrackUseCase;
import com.bytedance.android.live.room.api.panel.PanelName;
import com.bytedance.android.live.schema.api.WebcastRedirectException;
import com.bytedance.android.live.service.preinflate.ProfilePreInflateUtil;
import com.bytedance.android.live.service.preinflate.ProfilePreInflateViewInfo;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.LiveDialogFragment;
import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.android.livesdk.pannel.view.RadiusLayout;
import com.bytedance.android.livesdk.r3;
import com.bytedance.android.livesdk.t8;
import com.bytedance.android.livesdk.widget.LiveBottomSheetDialog;
import com.bytedance.android.livesdk.widget.LiveStandardSheetDialog;
import com.bytedance.android.livesdkapi.depend.event.FollowStateChangeEvent;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.follow.IFollowPair;
import com.bytedance.android.livesdkapi.service.IPerformanceManager;
import com.bytedance.badger.collect.impl.constants.Constants;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.larus.apm.impl.protector.RunnableProtector;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.childwindow.LandscapeChildDialogBoundsAdapter;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Predicate;
import j40.p0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.json.JSONException;
import org.json.JSONObject;
import rs0.b0;
import rs0.g0;
import rs0.m0;
import rs0.r;
import zg1.m1;
import zg1.w1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u000eB\u0007¢\u0006\u0004\b\f\u0010\rJ\u001c\u0010\b\u001a\u00020\u00072\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0003J\u0010\u0010\u000b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\t¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/live/profile/NewLiveProfileDialogFragment;", "Lcom/bytedance/android/livesdk/LiveDialogFragment;", "Lcom/bytedance/android/live/profile/seeselftransition/b;", "Lcom/bytedance/android/live/network/response/BaseResponse;", "Lcom/bytedance/android/live/base/model/user/UserProfileDataResp;", "Lcom/bytedance/android/live/base/model/user/UserProfileDataResp$UserProfileExtra;", "newResponse", "", "update", "Lcom/bytedance/android/livesdkapi/depend/event/FollowStateChangeEvent;", "event", "onEvent", "<init>", "()V", "a", "live-profile-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class NewLiveProfileDialogFragment extends LiveDialogFragment implements com.bytedance.android.live.profile.seeselftransition.b {
    public static final a A = null;
    public static long z;
    public final Lazy d;
    public BaseUiBehavior e;
    public View f;
    public long g;
    public DataCenter h;
    public com.bytedance.android.live.profile.model.c i;
    public final String j;
    public BaseResponse<UserProfileDataResp, UserProfileDataResp.UserProfileExtra> k;
    public boolean l;
    public final CompositeDisposable m;
    public com.bytedance.android.live.profile.seeselftransition.a n;
    public com.bytedance.android.live.profile.seeselftransition.k o;
    public final long p;
    public ProfileMonitor q;
    public boolean r;
    public boolean s;
    public long t;
    public final Lazy u;
    public final Lazy v;
    public final l w;
    public boolean x;
    public final b y;

    public static final class a {
        public a() {
        }

        public static NewLiveProfileDialogFragment a(ProfileMonitor r10, DataCenter r12, boolean r13, IRoom r14, String r15, UserProfileEvent r16, BaseResponse r17, long r18, ProfileMode r19, boolean r20) {
            Intrinsics.checkNotNullParameter(r10, "profileMonitor");
            Intrinsics.checkNotNullParameter(r16, "userProfileEvent");
            Intrinsics.checkNotNullParameter(r19, "profileMode");
            String r8 = "";
            if ((SystemClock.uptimeMillis() - NewLiveProfileDialogFragment.z) < 200) goto L5;
        L8:
            IBaseUser r4 = r16.user;
            if (r4 != null) goto L11;
            String r5 = r16.getUserIdStr();
        L12:
            if (r5 != null) goto L14;
            r5 = DataType.FALSE;
        L14:
            NewLiveProfileDialogFragment r6 = new NewLiveProfileDialogFragment();
            r6.q = r10;
            r6.g = r18;
            r6.k = r17;
            r6.setVertical(r13);
            r6.h = r12;
            com.bytedance.android.live.profile.model.c r7 = new com.bytedance.android.live.profile.model.c();
            Intrinsics.checkNotNullParameter(r5, "<set-?>");
            r7.a = r5;
            r7.b = r16.secUserId;
            r7.c = new ProfileRoomProxy(r14);
            r7.d = r14;
            if (r15 != null) goto L17;
            String r1 = "";
        L18:
            Intrinsics.checkNotNullParameter(r1, "<set-?>");
            r7.f = r1;
            String r2 = r16.mSource;
            if (r2 == null) goto L22;
            r8 = r2;
        L22:
            Intrinsics.checkNotNullParameter(r8, "<set-?>");
            r7.e = r8;
            r7.g = r16;
            Intrinsics.checkNotNullParameter(r19, "<set-?>");
            r7.h = r19;
            r7.i = r10;
            r7.j = r20;
            Unit r0 = Unit.INSTANCE;
            r6.i = r7;
            NewLiveProfileDialogFragment.z = SystemClock.uptimeMillis();
            return r6;
        L17:
            r1 = r15;
            goto L18
        L11:
            r5 = r4.getIdString();
            goto L12
        L5:
            if (r19 != ProfileMode.NONE) goto L8;
            ALogger.i(NewProfileInfoViewModel.TAG, "stop_quick_click");
            EndType r3 = EndType.ClickFrequently;
            ProfileMonitor.a r9 = ProfileMonitor.g;
            r10.a(r3, "");
            return null;
        }
    }

    public static final class b<T> implements Observer {
        public final /* synthetic */ NewLiveProfileDialogFragment a;

        public b(NewLiveProfileDialogFragment r1) {
            this.a = r1;
        }

        public final void onChanged(Object r3) {
            KVData r4 = (KVData) r3;
            if (r4 == null) goto L5;
            Object r5 = r4.getData();
        L7:
            if ((r5 instanceof IBaseUser) == false) goto L10;
            NewLiveProfileDialogFragment r0 = this.a;
            a r1 = NewLiveProfileDialogFragment.A;
            r0.T90().updateSelfUserFansGroup((IBaseUser) r5);
            return;
        L10:
            return;
        L5:
            r5 = null;
            goto L7
        }
    }

    public static final class c implements LiveBottomSheetDialog.m {
        public static final c a = null;

        static {
            a = new c();
        }

        public c() {
        }

        public final boolean disableDragDown() {
            return true;
        }

        public final /* synthetic */ boolean shouldInterceptSlide(int r1) {
            return true;
        }
    }

    public static final class d<T> implements Observer {
        public final /* synthetic */ NewLiveProfileDialogFragment a;

        public d(NewLiveProfileDialogFragment r1) {
            this.a = r1;
        }

        public final void onChanged(Object r3) {
            Boolean r4 = (Boolean) r3;
            NewLiveProfileDialogFragment r0 = this.a;     // Catch: Exception -> L9
            if (r4 == null) goto L6;
            boolean r5 = r4.booleanValue();     // Catch: Exception -> L9
        L7:
            a r1 = NewLiveProfileDialogFragment.A;     // Catch: Exception -> L9
            r0.Ni(r5);     // Catch: Exception -> L9
            return;
        L6:
            r5 = false;
        L9:
            e = move-exception;
            ALogger.i("TriangleManager", e.toString());
        }
    }

    public static final class e<T> implements Observer {
        public final /* synthetic */ NewLiveProfileDialogFragment a;

        public e(NewLiveProfileDialogFragment r1) {
            this.a = r1;
        }

        public final void onChanged(Object r8) {
            NewProfileUser r9 = (NewProfileUser) r8;
            ALogger.e("NewUserProfile_ProfilePre", "observer, shouldUpdate=" + this.a.r);
            NewLiveProfileDialogFragment r0 = this.a;
            if (r0.r == false) goto L9;
            r0.r = false;
            BaseUiBehavior r1 = r0.e;
            if (r1 == null) goto L7;
            r1.update(r9);
        L7:
            this.a.T90().ensureFinalDataAvailable();
            return;
        L9:
            if (r9 == null) goto L59;
            ProfileMonitor r2 = r0.q;
            if (r2 == null) goto L13;
            r2.i(TimeType.AssemblePanelStart);
        L13:
            NewLiveProfileDialogFragment r3 = this.a;
            ArrayList<com.bytedance.android.live.profile.model.d> r4 = com.bytedance.android.live.profile.ui.b.a;
            com.bytedance.android.live.profile.model.d r5 = r3.T90().getNewPageType(r9);
            ProfileMonitor r6 = this.a.q;
            if (r6 == null) goto L16;
            r6.d(DataType.PageType, r5.toString());
        L16:
            Unit r7 = Unit.INSTANCE;
            Intrinsics.checkNotNullParameter(r3, "fragment");
            Intrinsics.checkNotNullParameter(r5, "type");
            ALogger.i(NewProfileInfoViewModel.TAG, "livesdk_new_profile_createUI_" + r5.toString());
            if (com.bytedance.android.live.profile.ui.b.a.contains(r5) == false) goto L20;
            BaseUiBehavior r10 = new AudienceSeeAudienceBehavior(r3, r5);
        L53:
            r10.o(r9);
            r3.e = r10;
            ProfileMonitor r12 = this.a.q;
            if (r12 == null) goto L56;
            r12.i(TimeType.AssemblePanelEnd);
        L56:
            NewLiveProfileDialogFragment r13 = this.a;
            if (r13.s == true) goto L59;
            r13.T90().ensureFinalDataAvailable();
            goto L59
        L20:
            if (com.bytedance.android.live.profile.ui.b.b.contains(r5) == false) goto L23;
            r10 = new AudienceSeeSelfBehavior(r3, r5);
            goto L53
        L23:
            if (com.bytedance.android.live.profile.ui.b.d.contains(r5) == false) goto L26;
            r10 = new AudienceSeeAnchorBehavior(r3, r5);
            goto L53
        L26:
            if (com.bytedance.android.live.profile.ui.b.f.contains(r5) == false) goto L29;
            r10 = new com.bytedance.android.live.profile.ui.c(r3, r5);
            goto L53
        L29:
            if (com.bytedance.android.live.profile.ui.b.c.contains(r5) == false) goto L32;
            r10 = new AnchorSeeAudienceBehavior(r3, r5);
            goto L53
        L32:
            if (com.bytedance.android.live.profile.ui.b.e.contains(r5) == false) goto L35;
            r10 = new AnchorSeeSelfBehavior(r3, r5);
            goto L53
        L35:
            if (com.bytedance.android.live.profile.ui.b.g.contains(r5) == false) goto L38;
            r10 = new MediaLiveRoomBehavior(r3, r5);
            goto L53
        L38:
            if (com.bytedance.android.live.profile.ui.b.i.contains(r5) == false) goto L41;
            r10 = new NoAuthorityAudienceBehavior(r3, r5);
            goto L53
        L41:
            if (com.bytedance.android.live.profile.ui.b.j.contains(r5) == false) goto L44;
            r10 = new MicRoomBehavior(r3, r5);
            goto L53
        L44:
            if (r5.c != 4) goto L46;
            boolean r14 = true;
        L47:
            if (r14 == false) goto L50;
            r10 = new com.bytedance.android.live.profile.ui.d(r3, r5);
            goto L53
        L50:
            if (com.bytedance.android.live.profile.ui.b.h.contains(r5) == false) goto L52;
            r10 = new com.bytedance.android.live.profile.ui.a(r3, r5);
            goto L53
        L52:
            r10 = new AudienceSeeAudienceBehavior(r3, r5);
            goto L53
        L46:
            r14 = false;
        L59:
            final NewLiveProfileDialogFragment r15 = this.a;
            Disposable r16 = com.bytedance.android.live.profile.ui.base.i.j(r15.T90(), new NewLiveProfileDialogFragment$onDataLoadSuccess$1(r15));
            if (r16 == null) goto L62;
            RxUtilKt.c(r16, r15.m);
        L62:
            long r17 = SystemClock.uptimeMillis();
            LiveMonitor.a r18 = new LiveMonitor.a(r15.j, LiveTracingMonitor.EventModule.common);
            r18.j(r17 - r15.g);
            r18.l(0);
            r18.c("live");
            r18.a().report();
            NewProfileInfoViewModel r19 = r15.T90();
            View r20 = r15.f;
            if (r20 == null) goto L65;
            View r22 = r20.findViewById(2131380844);
        L66:
            r19.prepareEnter(r22, new NewLiveProfileDialogFragment$onDataLoadSuccess$2(r15));
            ua1.a r23 = com.bytedance.android.live.service.b.a();
            if (r23 == null) goto L78;
            r23.setOpenPanelCount(r23.getOpenPanelCount() + 1);
            ProfileMonitor r24 = r15.q;
            if (r24 == null) goto L72;
            r24.d(DataType.OpenPanelCount, Integer.valueOf(r23.getOpenPanelCount()));
        L72:
            if (com.bytedance.android.live.profile.ui.base.i.l(r15.T90()) == false) goto L79;
            r23.setOpenAnchorPanelCount(r23.getOpenAnchorPanelCount() + 1);
            ProfileMonitor r25 = r15.q;
            if (r25 == null) goto L80;
            r25.d(DataType.OpenAnchorPanelCount, Integer.valueOf(r23.getOpenAnchorPanelCount()));
            return;
        L80:
            return;
        L79:
            return;
        L78:
            return;
        L65:
            r22 = null;
            goto L66
        }
    }

    public static final class f<T> implements Consumer {
        public final /* synthetic */ NewLiveProfileDialogFragment a;

        public f(NewLiveProfileDialogFragment r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            NewLiveProfileDialogFragment r0 = this.a;
            r0.onEvent((FollowStateChangeEvent) r2);
        }
    }

    public static final class g<T> implements Consumer {
        public final /* synthetic */ NewLiveProfileDialogFragment a;

        public g(NewLiveProfileDialogFragment r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            UserEvent r5 = (UserEvent) r4;
            NewLiveProfileDialogFragment r0 = this.a;
            a r1 = NewLiveProfileDialogFragment.A;
            NewProfileInfoViewModel r2 = r0.T90();
            if (r5 == null) goto L9;
            IBaseUser r6 = r5.getUser();
            if (r6 == null) goto L9;
            py.j r7 = r6.getFollowInfoExt();
            if (r7 == null) goto L9;
            int r8 = (int) r7.getFollowStatus();
        L10:
            r2.updateFollowInfo(r8);
            return;
        L9:
            r8 = 0;
            goto L10
        }
    }

    public static final class h implements View.OnClickListener {
        public final /* synthetic */ NewLiveProfileDialogFragment a;

        public h(NewLiveProfileDialogFragment r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            os0.b.b(this.a.h).b(this.a.getActivity());
            this.a.Ni(false);
        }
    }

    public static final class i implements View.OnClickListener {
        public final /* synthetic */ NewLiveProfileDialogFragment a;

        public i(NewLiveProfileDialogFragment r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            os0.b.b(this.a.h).j(this.a.getActivity());
        }
    }

    public static final class j<T> implements Observer {
        public final /* synthetic */ NewLiveProfileDialogFragment a;

        public j(NewLiveProfileDialogFragment r1) {
            this.a = r1;
        }

        public final void onChanged(Object r3) {
            KVData r4 = (KVData) r3;
            if (r4 == null) goto L5;
            Object r5 = r4.getData();
        L7:
            if ((r5 instanceof IBaseUser) == false) goto L10;
            NewLiveProfileDialogFragment r0 = this.a;
            a r1 = NewLiveProfileDialogFragment.A;
            r0.T90().updateSelfUserFansGroup((IBaseUser) r5);
            return;
        L10:
            return;
        L5:
            r5 = null;
            goto L7
        }
    }

    public static final class k<T> implements Predicate {
        public static final k a = null;

        static {
            a = new k();
        }

        public k() {
        }

        public final boolean test(Object r2) {
            UserEvent r3 = (UserEvent) r2;
            Intrinsics.checkNotNullParameter(r3, "userEvent");
            if (r3.getStatus() != IBaseUser.Status.Login) goto L5;
            return true;
        L5:
            return false;
        }
    }

    public static final class l implements com.bytedance.android.live.room.api.panel.b {
        public final /* synthetic */ NewLiveProfileDialogFragment a;

        public static final class a implements Runnable {
            public final /* synthetic */ l a;
            public final /* synthetic */ Function1 b;

            public a(l r1, Function1 r2) {
                this.a = r1;
                this.b = r2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.b.invoke(Integer.valueOf(this.a.a.getContentViewHeight()));     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }
        }

        @Override // com.bytedance.android.live.room.api.panel.b
        public final int getUnionId() {
            return hashCode();
        }

        @Override // com.bytedance.android.live.room.api.panel.b
        public final PanelName getPanelName() {
            return PanelName.Profile;
        }

        public l(NewLiveProfileDialogFragment r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.live.room.api.panel.b
        public final void a(Function1<? super Integer, Unit> r2, Function1<? super String, Unit> r3) {
            Intrinsics.checkNotNullParameter(r2, "continueAction");
            Intrinsics.checkNotNullParameter(r3, "stopAction");
            View r0 = this.a.f;
            if (r0 == null) goto L5;
            r0.post(new a(this, r2));
            return;
        L5:
            r3.invoke("root view is null");
        }
    }

    public final NewProfileInfoViewModel T90() {
        return (NewProfileInfoViewModel) this.d.getValue();
    }

    @Override // com.bytedance.android.live.profile.seeselftransition.b
    public final void d80() {
        Ni(false);
    }

    public final String getDegradeTag() {
        return "profile_parallax";
    }

    @Override // com.bytedance.android.live.profile.seeselftransition.b
    public final LifecycleOwner getLifecycleOwner() {
        return this;
    }

    static {
        A = new a();
    }

    @Override // com.bytedance.android.live.profile.seeselftransition.b
    public final Pair<Integer, Integer> Ls() {
        View r0 = this.f;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.getWidth();
    L6:
        Integer r3 = Integer.valueOf(r2);
        View r4 = this.f;
        if (r4 == null) goto L10;
        r1 = r4.getHeight();
    L10:
        return TuplesKt.to(r3, Integer.valueOf(r1));
    L5:
        r2 = 0;
        goto L6
    }

    public final int getContentViewHeight() {
        BaseUiBehavior r0 = this.e;
        if (r0 == null) goto L9;
        com.bytedance.android.live.profile.profilecontext.a r1 = r0.i;
        if (r1 == null) goto L9;
        m r2 = com.bytedance.android.live.profile.ui.base.i.n(r1);
        if (r2 == null) goto L9;
        return r2.e();
    L9:
        return 0;
    }

    @Override // com.bytedance.android.live.profile.seeselftransition.b
    public final PointF v10() {
        ConstraintLayout r0 = (TransitionConstraintLayout) this.u.getValue();
        if (r0 == null) goto L5;
        Object r2 = (com.bytedance.android.live.profile.standard.honour.items.dressup.b) this.v.getValue();
        if ((r2 instanceof View) == true) goto L9;
        r2 = null;
    L9:
        View r3 = (View) r2;
        int r4 = 0;
        if (r3 != null) goto L12;
    L26:
        View r5 = this.f;
        if (r5 == null) goto L41;
        View r6 = r5.findViewById(2131380761);
        if (r6 == null) goto L41;
        int[] r7 = UIUtils.getLocationInAncestor(r6, r0);
        if (r7 == null) goto L34;
        double r1 = ((double) r0.getWidth()) * 0.67d;
        if (1 > ArraysKt.getLastIndex(r7)) goto L39;
        r4 = r7[1];
    L39:
        return new PointF((float) r1, (float) (((double) r4) + (((double) r6.getHeight()) * 0.5d)));
    L34:
        return new PointF(0.0f, 0.0f);
    L41:
        return new PointF(0.0f, 0.0f);
    L12:
        if (isVertical() == false) goto L26;
        int[] r8 = UIUtils.getLocationInAncestor(r3, r0);
        if (r8 != null) goto L18;
        return new PointF(0.0f, 0.0f);
    L18:
        if (ArraysKt.getLastIndex(r8) < 0) goto L20;
        int r9 = r8[0];
    L21:
        double r10 = ((double) r9) + (((double) r3.getWidth()) * 0.5d);
        if (1 > ArraysKt.getLastIndex(r8)) goto L24;
        r4 = r8[1];
    L24:
        double r12 = ((double) r4) + (((double) r3.getHeight()) * 0.5d);
        return new PointF((float) r10, (float) r12);
    L20:
        r9 = 0;
        goto L21
    L5:
        return new PointF(0.0f, 0.0f);
    }

    public NewLiveProfileDialogFragment() {
        setNoTitleAndCancelOutside(true);
        this.d = LazyKt.lazy(new NewLiveProfileDialogFragment$mNewProfileInfoViewModel$2(this));
        this.j = "ttlive_new_profile_page_loading";
        this.m = new CompositeDisposable();
        this.p = 2;
        this.u = LazyKt.lazy(new NewLiveProfileDialogFragment$transitionLayout$2(this));
        this.v = LazyKt.lazy(new NewLiveProfileDialogFragment$dressUpCard$2(this));
        this.w = new l(this);
        this.x = ((Boolean) p0.a.getValue()).booleanValue();
        this.y = new b(this);
    }

    public final boolean getEnableAdaptFold() {
        return this.x;
    }

    public final void Ni(boolean r2) {
        if (r2 == true) goto L17;
        int r3 = t.a;
        if (((ss0.a) b0.a.getValue()).c() == false) goto L17;
        ProfileMonitor r4 = this.q;
        if (r4 == null) goto L9;
        r4.g(EventType.CallDismiss);
    L9:
        T90().prepareExit();
        return;
    L17:
        dismiss();     // Catch: Exception -> L12
        return;
    L12:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r5 = DialogFragmentLancet.sLastShowStack;
        if (r5 == null) goto L20;
        com.bytedance.crash.d.d(r5, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    }

    public final void S90(DialogInterface r9) {
        Intrinsics.checkNotNullParameter(r9, "dialog");
        ProfileMonitor r0 = this.q;
        if (r0 == null) goto L5;
        r0.i(TimeType.DialogOnDismiss);
    L5:
        super.onDismiss(r9);
        com.bytedance.android.live.profile.model.c r10 = this.i;
        Long r1 = null;
        if (r10 != null) goto L8;
    L10:
        NewProfileTrackUseCase r12 = T90().getLogUseCase();
        long r2 = this.t;
        r12.getClass();
        LinkedHashMap r4 = new LinkedHashMap();
        int r5 = vt0.h.a;
        IMiddlewareUserService r6 = jc1.k.f(IMiddlewareUserService.class);
        if (r6 == null) goto L15;
        com.bytedance.android.livesdk.user.e r7 = r6.user();
        if (r7 == null) goto L15;
        String r8 = r7.n();
    L16:
        r4.put("request_page", vt0.h.a(String.valueOf(r8), r12.g.getTargetUser().baseProfileInfo.getIdStr(), r12.g.getRoom().getOwnerUserIdStr()));
        r4.put("to_user_id", r12.g.getTargetUser().baseProfileInfo.getIdStr());
        r4.put(Constants.Keys.duration, String.valueOf(System.currentTimeMillis() - r2));
        r12.f.a(r4);
        r12.B("livesdk_profile_card_duration", r4);
    L17:
        int r13 = n.a;
        jc1.k.n(IPerformanceManager.class).onModuleStop("dress_usercard");
        IGiftServiceExternal r14 = jc1.k.f(IGiftServiceExternal.class);
        if (r14 == null) goto L22;
        o r15 = r14.getRevenueEventCenter();
        if (r15 == null) goto L22;
        r15.b();
    L22:
        this.m.clear();
        BaseUiBehavior r16 = this.e;
        if (r16 == null) goto L29;
        Iterator<com.bytedance.android.live.profile.ui.base.g> r3 = r16.e.iterator();
    L26:
        if (r3.hasNext() == false) goto L28;
        r16.i(r3.next());
        goto L26
    L28:
        r16.j.clear();
    L29:
        this.e = null;
        xs2.b.a().post(new w1(false));
        int r17 = com.bytedance.android.live.room.api.panel.d.a;
        DataCenter r18 = this.h;
        com.bytedance.android.live.profile.model.c r19 = this.i;
        long r20 = 0;
        if (r19 == null) goto L34;
        ProfileRoomProxy r22 = r19.c;
        if (r22 == null) goto L34;
        long r23 = r22.getId();
    L35:
        com.bytedance.android.live.room.api.panel.c r24 = com.bytedance.android.live.room.api.panel.d.b(r18, r23);
        if (r24 == null) goto L39;
        r24.notifyPanelClose(PanelName.Profile, this.w);
    L39:
        if (this.l == false) goto L46;
        com.bytedance.android.live.profile.model.c r25 = this.i;
        if (r25 == null) goto L44;
        String r26 = r25.a;
        if (r26 == null) goto L44;
    L45:
        xs2.b.a().post(new m1(r26));
        this.l = false;
    L44:
        r26 = DataType.FALSE;
    L46:
        DataCenter r27 = this.h;
        if (r27 == null) goto L49;
        r27.removeObserver(this.y);
    L49:
        BaseResponse<UserProfileDataResp, UserProfileDataResp.UserProfileExtra> r28 = this.k;
        if (r28 == null) goto L88;
        Appointment r29 = T90().getTargetUser().appointment;
        if (r29 == null) goto L54;
        r1 = Long.valueOf(r29.PushStates);
    L54:
        Appointment r30 = ((UserProfileDataResp) r28.data).profileUser.appointment;
        if (r30 == null) goto L59;
        if (r1 == null) goto L58;
        r20 = r1.longValue();
    L58:
        r30.PushStates = r20;
    L59:
        com.bytedance.android.live.profile.model.c r32 = this.i;
        if (r32 == null) goto L63;
        String r33 = r32.a;
        if (r33 == null) goto L63;
    L64:
        ua1.a r34 = com.bytedance.android.live.service.b.a();
        if (r34 == null) goto L69;
        com.bytedance.android.live.service.prerequest.a r35 = r34.getPreRequestManager();
        if (r35 == null) goto L69;
        boolean r36 = r35.a(r33);
    L70:
        if (r36 == false) goto L77;
        ua1.a r37 = com.bytedance.android.live.service.b.a();
        if (r37 == null) goto L88;
        com.bytedance.android.live.service.prerequest.a r38 = r37.getPreRequestManager();
        if (r38 == null) goto L88;
        r38.e(r33, r28);
        goto L88
    L77:
        if (com.bytedance.android.live.profile.ui.base.i.l(T90()) == false) goto L88;
        UserProfileDataResp r39 = (UserProfileDataResp) r28.data;
        if (r39 == null) goto L83;
        NewProfileUser r40 = r39.profileUser;
        if (r40 == null) goto L83;
        r40.setFromOtherIntercomRoom(false);
    L83:
        ua1.a r42 = com.bytedance.android.live.service.b.a();
        if (r42 == null) goto L88;
        com.bytedance.android.live.service.prerequest.a r43 = r42.getPreRequestManager();
        if (r43 == null) goto L88;
        r43.e(r33, r28);
    L69:
        r36 = false;
    L63:
        r33 = "";
    L88:
        ProfileMonitor r44 = this.q;
        if (r44 == null) goto L91;
        DataType r45 = DataType.PreInflateType;
        Lazy r46 = ProfilePreInflateUtil.a;
        r44.d(r45, Integer.valueOf(((Integer) m0.a.getValue()).intValue()));
    L91:
        Lazy r47 = ProfilePreInflateUtil.a;
        ProfileMonitor r48 = this.q;
        if (r48 == null) goto L95;
        r48.d(DataType.GetXmlCacheCount, Integer.valueOf(ProfilePreInflateUtil.e));
        r48.d(DataType.HitXmlCacheCount, Integer.valueOf(ProfilePreInflateUtil.d));
        ProfilePreInflateUtil.b += ProfilePreInflateUtil.e;
        ProfilePreInflateUtil.c += ProfilePreInflateUtil.d;
        ALogger.i("NewUserProfile_PreLayout", "current check count: " + ProfilePreInflateUtil.e + ", hit count: " + ProfilePreInflateUtil.d + ", hit percentage: " + (((double) ProfilePreInflateUtil.d) / ((double) ProfilePreInflateUtil.e)));
        ALogger.i("NewUserProfile_PreLayout", "total check count: " + ProfilePreInflateUtil.b + ", hit count: " + ProfilePreInflateUtil.c + ", hit percentage: " + (((double) ProfilePreInflateUtil.c) / ((double) ProfilePreInflateUtil.b)));
        ProfilePreInflateUtil.e = 0;
        ProfilePreInflateUtil.d = 0;
    L95:
        ProfileMonitor r49 = this.q;
        if (r49 == null) goto L100;
        r49.a(EndType.Success, NewProfileInfoViewModel.TAG);
        return;
    L100:
        return;
    L34:
        r23 = 0;
    L15:
        r8 = null;
        goto L16
    L8:
        if (r10.j != true) goto L10;
        NewProfileTrackUseCase r50 = T90().getLogUseCase();
        long r52 = this.t;
        r50.getClass();
        r50.B("livesdk_my_live_duration", MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("stay_duration", String.valueOf(System.currentTimeMillis() - r52))}));
        goto L17
    }

    @Override // com.bytedance.android.live.profile.seeselftransition.b
    public final void Wl(com.bytedance.android.live.profile.seeselftransition.k r2) {
        Intrinsics.checkNotNullParameter(r2, "info");
        this.o = r2;
    }

    @Override // com.bytedance.android.live.profile.seeselftransition.b
    public final void es(float r2) {
        TransitionConstraintLayout r0 = (TransitionConstraintLayout) this.u.getValue();
        if (r0 == null) goto L6;
        r0.setOffset(r2);
        return;
    }

    @Override // com.bytedance.android.live.profile.seeselftransition.b
    public final void ks(PointF r2) {
        Intrinsics.checkNotNullParameter(r2, "pointF");
        TransitionConstraintLayout r0 = (TransitionConstraintLayout) this.u.getValue();
        if (r0 == null) goto L6;
        r0.setStartPoint(r2);
        return;
    }

    public final void onActivityCreated(Bundle r10) {
        ProfileMonitor r0 = this.q;
        if (r0 == null) goto L5;
        r0.i(TimeType.DialogOnActivityCreated);
    L5:
        Dialog r1 = getDialog();
        boolean r2 = true;
        setBanLandscapeStyleSetting(true);
        super.onActivityCreated(r10);
        View r12 = null;
        if (r1 == null) goto L8;
        Window r3 = r1.getWindow();
    L10:
        if (((Boolean) p0.a.getValue()).booleanValue() == false) goto L16;
        Configuration r4 = s1.getResources().getConfiguration();
        if (FoldScreenUtils.f() == false) goto L16;
        if (FoldScreenUtils.b(s1.getContext(), r4) != 0) goto L16;
        boolean r5 = true;
    L18:
        if (r3 == null) goto L65;
        if (PadConfigUtils.c() == true) goto L65;
        if (r5 == true) goto L65;
        if (isVertical() == true) goto L40;
        if (r3.l(getContext()) == false) goto L27;
    L29:
        r3.addFlags(1024);
        r3.setLayout(-1, -1);
        r3.setGravity(8388693);
        View r6 = r3.findViewById(2131389519);
        if (r6 == null) goto L38;
        ViewGroup.LayoutParams r7 = r6.getLayoutParams();
        if ((r7 instanceof CoordinatorLayout.LayoutParams) == true) goto L34;
        r7 = null;
    L34:
        CoordinatorLayout.LayoutParams r8 = (CoordinatorLayout.LayoutParams) r7;
        if (r8 == null) goto L38;
        ((ViewGroup.MarginLayoutParams) r8).width = UtilityKotlinExtentionsKt.i(352);
        r8.gravity = 8388613;
        r6.setLayoutParams(r8);
    L38:
        t8.d(r3);
    L63:
        r3.setBackgroundDrawable(new ColorDrawable(0));
        goto L65
    L27:
        if (((Boolean) g0.a.getValue()).booleanValue() == true) goto L29;
        r3.setType(WebcastRedirectException.UNKNOWN);
        goto L29
    L40:
        if (com.bytedance.android.live.profile.j.b() == false) goto L42;
        int r9 = RangesKt.coerceAtLeast(s1.w(), s1.y());
    L44:
        if (isVertical() == true) goto L46;
    L62:
        r3.setLayout(-1, r9 - s1.A());
        r3.setGravity(80);
        goto L63
    L46:
        if (r9 == s1.w()) goto L62;
        StringBuilder r13 = new StringBuilder("portraitHeight(");
        r13.append(r9);
        r13.append(") don't equal ResUtil.getScreenHeight. system resources: ");
        Resources r14 = Resources.getSystem();
        if (r14 == null) goto L52;
        DisplayMetrics r15 = WindowDisplayMetricsOverride.apply(r14, r14.getDisplayMetrics());
        if (r15 == null) goto L52;
        String r16 = r15.toString();
    L53:
        r13.append(r16);
        r13.append("activity resources: ");
        FragmentActivity r17 = getActivity();
        if (r17 == null) goto L60;
        Resources r18 = r17.getResources();
        if (r18 == null) goto L60;
        DisplayMetrics r19 = WindowDisplayMetricsOverride.apply(r18, r18.getDisplayMetrics());
        if (r19 == null) goto L60;
        String r20 = r19.toString();
    L61:
        r13.append(r20);
        ALogger.e("NewLiveProfileDialogFragment", r13.toString());
    L60:
        r20 = null;
    L52:
        r16 = null;
        goto L53
    L42:
        r9 = s1.w();
    L65:
        if (PadConfigUtils.c() == false) goto L76;
        com.bytedance.android.live.profile.model.c r22 = this.i;
        if (r22 == null) goto L76;
        if (r22.j != true) goto L76;
        if (r3 == null) goto L76;
        RadiusLayout r23 = r3.findViewById(2131389519);
        if (r23 == null) goto L76;
        if ((r23 instanceof RadiusLayout) == false) goto L76;
        r23.setMaxHeight(0);
    L76:
        int r24 = t.a;
        if (((ss0.a) b0.a.getValue()).c() == false) goto L89;
        Dialog r25 = getDialog();
        if (r25 == null) goto L86;
        Window r26 = r25.getWindow();
        if (r26 == null) goto L86;
        View r27 = r26.findViewById(2131389843);
        if (r27 == null) goto L86;
        r27.setOnClickListener(new com.bytedance.android.live.profile.c(this));
    L86:
        Dialog r28 = getDialog();
        if (r28 == null) goto L89;
        r28.setOnKeyListener(new com.bytedance.android.live.profile.d(this));
    L89:
        com.bytedance.android.live.profile.model.c r29 = this.i;
        if (r29 == null) goto L92;
        ProfileMode r30 = r29.h;
    L94:
        if (r30 != ProfileMode.NONE) goto L97;
        r2 = false;
    L97:
        if (r2 == false) goto L100;
        if (r3 == null) goto L100;
        r3.setDimAmount(0.0f);
    L100:
        if (r3 == null) goto L105;
        View r32 = r3.findViewById(2131389843);
        if (r32 == null) goto L105;
        r32.setContentDescription(s1.B(2131921754));
    L105:
        if (Build.VERSION.SDK_INT < 26) goto L115;
        Dialog r33 = getDialog();
        if (r33 == null) goto L109;
        Window r34 = r33.getWindow();
    L110:
        if (r34 == null) goto L112;
        r12 = r34.findViewById(2131389843);
    L112:
        if (r12 == null) goto L116;
        r12.setDefaultFocusHighlightEnabled(false);
        return;
    L116:
        return;
    L109:
        r34 = null;
        goto L110
    L115:
        return;
    L92:
        r30 = null;
    L16:
        r5 = false;
        goto L18
    L8:
        r3 = null;
        goto L10
    }

    public final void onCancel(DialogInterface r2) {
        Intrinsics.checkNotNullParameter(r2, "dialog");
        T90().onSlideDismiss();
    }

    public final void onCreate(Bundle r4) {
        ProfileMonitor r0 = this.q;
        if (r0 == null) goto L5;
        r0.i(TimeType.DialogOnCreate);
    L5:
        super.onCreate(r4);
        JSONObject r5 = new JSONObject();
        r5.put("type", "native");     // Catch: JSONException -> L8
        r5.put("is_new", "true");     // Catch: JSONException -> L8
    L10:
        LiveSlardarMonitor.monitorStatus("ttlive_profile_create", 0, r5);
        if (isVertical() == false) goto L13;
        int r6 = 2131954581;
    L14:
        setStyle(1, r6);
        this.t = System.currentTimeMillis();
        com.bytedance.android.live.profile.model.c r7 = this.i;
        if (r7 == null) goto L17;
        ProfileMode r1 = r7.h;
    L19:
        if (r1 != ProfileMode.NONE) goto L23;
        if (r7 != null) goto L22;
        return;
    L22:
        if (r7.j == true) goto L23;
        return;
    L23:
        setBottomSheetSlideProcessor(c.a);
        return;
    L17:
        r1 = null;
        goto L19
    L13:
        r6 = 2131954853;
    L8:
        e = move-exception;
        e.printStackTrace();
        goto L10
    }

    public final Dialog onCreateDialog(Bundle r3) {
        ProfileMonitor r0 = this.q;
        if (r0 == null) goto L5;
        r0.i(TimeType.DialogOnCreateDialog);
    L5:
        LiveStandardSheetDialog r4 = super.onCreateDialog(r3);
        if (PadConfigUtils.c() == true) goto L8;
    L12:
        return r4;
    L8:
        if ((r4 instanceof LiveStandardSheetDialog) == false) goto L12;
        int r1 = t.a;
        Window r2 = r4.getWindow();
        if (r2 == null) goto L12;
        r2.setWindowAnimations(2131954855);
        goto L12
    }

    public final void onDismiss(DialogInterface r2) {
        S90(r2);     // Catch: Throwable -> L5
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
        return;
    L5:
        th = move-exception;
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
        throw th;
    }

    public final void onEvent(FollowStateChangeEvent r3) {
        if (r3 == null) goto L25;
        IFollowPair r0 = r3.getFollowPair();
        if (r0 == null) goto L27;
        String r1 = r0.getUserIdString();
        com.bytedance.android.live.profile.model.c r2 = this.i;
        if (r2 == null) goto L11;
        String r4 = r2.a;
        if (r4 == null) goto L11;
    L12:
        boolean r5 = Intrinsics.areEqual(r1, r4);
        boolean r6 = true;
        if ((!r5) == false) goto L15;
        return;
    L15:
        IFollowPair r7 = r3.getFollowPair();
        if (r7 == null) goto L26;
        int r8 = r7.getFollowStatus();
        if (r8 != 1) goto L20;
    L23:
        this.l = r6;
        T90().updateFollowInfo(r8);
        return;
    L20:
        if (r8 == 2) goto L23;
        r6 = false;
        goto L23
    L26:
        return;
    L11:
        r4 = null;
        goto L12
    L27:
        return;
    }

    @Override // com.bytedance.android.live.profile.seeselftransition.b
    public final void setDressIconScale(float r2) {
        com.bytedance.android.live.profile.standard.honour.items.dressup.b r0 = (com.bytedance.android.live.profile.standard.honour.items.dressup.b) this.v.getValue();
        if (r0 == null) goto L6;
        r0.setDressIconScale(r2);
        return;
    }

    public final void setEnableAdaptFold(boolean r1) {
        this.x = r1;
    }

    public final void update(final BaseResponse<UserProfileDataResp, UserProfileDataResp.UserProfileExtra> r4) {
        ALogger.i("NewUserProfile_ProfilePre", "调用面板update, 状态: " + ((com.bytedance.android.live.profile.model.a) T90().getEnterExitState().getValue()).a);
        ProfileMonitor r0 = this.q;
        if (r0 == null) goto L5;
        r0.d(DataType.UpdateTimeNode, Integer.valueOf(((com.bytedance.android.live.profile.model.a) T90().getEnterExitState().getValue()).a.ordinal()));
    L5:
        Disposable r5 = com.bytedance.android.live.profile.ui.base.i.i(T90(), EnterExitStateType.WILL_ENTER, new AnonymousClass1(this, r4));
        if (r5 == null) goto L9;
        RxUtilKt.c(r5, this.m);
        return;
    }

    @Override // com.bytedance.android.live.profile.seeselftransition.b
    public final void BJ(com.bytedance.android.live.profile.seeselftransition.a r2, ProfileMode r3) {
        Intrinsics.checkNotNullParameter(r2, "manager");
        Intrinsics.checkNotNullParameter(r3, "profileMode");
        this.n = r2;
    }

    public final void onViewCreated(View r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r3, "view");
        ProfileMonitor r0 = this.q;
        if (r0 == null) goto L5;
        r0.i(TimeType.DialogOnViewCreated);
    L5:
        super.onViewCreated(r3, r4);
        if (this.f != null) goto L9;
        return;
    L9:
        if (((Boolean) r.a.getValue()).booleanValue() == false) goto L13;
        DataCenter r5 = this.h;
        if (r5 == null) goto L16;
        r5.observe("data_user_in_room", this.y);
    L16:
        com.bytedance.android.live.profile.model.c r6 = this.i;
        if (r6 == null) goto L29;
        T90().initThisViewModel(getContext(), r6, this.h);
        T90().getNeedClose().observe(this, new d(this));
        T90().getTargetUserInfoLiveData().observe(this, new e(this));
        T90().loadData(this.k);
        com.bytedance.android.live.profile.model.c r7 = this.i;
        if (r7 == null) goto L27;
        ProfileMode r8 = r7.h;
        if (r8 == null) goto L27;
        if (r8 == ProfileMode.NONE) goto L27;
        RxUtilKt.c(T90().getEnterExitState().filter(com.bytedance.android.live.profile.e.a).subscribe(new com.bytedance.android.live.profile.f(this, r8)), this.m);
    L27:
        ((ObservableSubscribeProxy) xs2.b.a().b(FollowStateChangeEvent.class).compose(RxUtil.bindUntilDestroy(this)).as(AutoDispose.bind(this))).subscribe(new f(this));
        ((v) jc1.k.n(IMiddlewareUserService.class).user().m().onBackpressureLatest().filter(k.a).as(AutoDispose.bind(this))).subscribe(new g(this));
        RxUtilKt.c(os0.b.c().registerLiveEventEnd(new NewLiveProfileDialogFragment$onViewCreated$$inlined$let$lambda$5(this)), this.m);
    L29:
        if (com.bytedance.android.live.core.utils.v.a() == false) goto L31;
    L32:
        View r9 = this.f;
        if (r9 == null) goto L44;
        View r10 = r9.findViewById(2131368621);
        if (r10 == null) goto L44;
        if ((r10 instanceof TextView) == true) goto L39;
        View r12 = null;
    L40:
        TextView r13 = (TextView) r12;
        if (r13 == null) goto L43;
        r13.setText("调试");
    L43:
        UtilityKotlinExtentionsKt.w(r10);
        r10.setOnClickListener(new h(this));
        goto L44
    L39:
        r12 = r10;
    L44:
        View r14 = this.f;
        if (r14 == null) goto L51;
        View r15 = r14.findViewById(2131368601);
        if (r15 == null) goto L52;
        UtilityKotlinExtentionsKt.w(r15);
        r15.setOnClickListener(new i(this));
        return;
    L52:
        return;
    L51:
        return;
    L31:
        if (com.bytedance.android.live.core.utils.v.a() == true) goto L32;
        return;
    L13:
        DataCenter r16 = this.h;
        if (r16 == null) goto L16;
        r16.observe("data_user_in_room", new j(this));
        goto L16
    }

    public final View onCreateView(LayoutInflater r3, ViewGroup r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r3, "inflater");
        if (com.bytedance.android.live.profile.b.a == false) goto L12;
        if (PadConfigUtils.c() == false) goto L8;
        int r6 = 2131565669;
    L15:
        ProfileMonitor r0 = this.q;
        if (r0 == null) goto L19;
        r0.i(TimeType.InflateViewStart);
    L19:
        if (ProfilePreInflateUtil.a() == true) goto L21;
        View r7 = r3.inflate(r6, r4, false);
    L29:
        this.f = r7;
        ProfileMonitor r8 = this.q;
        if (r8 == null) goto L32;
        r8.i(TimeType.InflateViewEnd);
    L32:
        View r9 = this.f;
        ProfileMode r10 = null;
        if (r9 == null) goto L35;
        Barrier r12 = r9.findViewById(2131380788);
    L36:
        if (r12 == null) goto L38;
        r12.setReferencedIds(new int[]{2131380784, 2131380855, 2131380859, 2131380856, 2131380741, 2131380792, 2131380854});
    L38:
        ProfileMonitor r13 = this.q;
        if (r13 == null) goto L45;
        DataType r14 = DataType.ProfileMode;
        com.bytedance.android.live.profile.model.c r1 = this.i;
        if (r1 == null) goto L43;
        ProfileMode r2 = r1.h;
    L44:
        r13.d(r14, r2);
        goto L45
    L43:
        r2 = null;
    L45:
        com.bytedance.android.live.profile.seeselftransition.k r15 = this.o;
        if (r15 == null) goto L59;
        com.bytedance.android.live.profile.model.c r16 = this.i;
        if (r16 == null) goto L52;
        r10 = r16.h;
    L52:
        if (r10 == ProfileMode.NONE) goto L59;
        TransitionConstraintLayout r17 = (TransitionConstraintLayout) this.u.getValue();
        if (r17 == null) goto L56;
        r17.setTransitionType(r15.a);
    L56:
        TransitionConstraintLayout r18 = (TransitionConstraintLayout) this.u.getValue();
        if (r18 == null) goto L59;
        r18.setSrcBitmap(r15.b);
    L59:
        int r19 = com.bytedance.android.live.room.api.panel.d.a;
        DataCenter r20 = this.h;
        com.bytedance.android.live.profile.model.c r22 = this.i;
        if (r22 == null) goto L64;
        ProfileRoomProxy r23 = r22.c;
        if (r23 == null) goto L64;
        long r24 = r23.getId();
    L65:
        com.bytedance.android.live.room.api.panel.c r25 = com.bytedance.android.live.room.api.panel.d.b(r20, r24);
        if (r25 == null) goto L69;
        r25.notifyPanelOpen(PanelName.Profile, this.w);
    L69:
        return this.f;
    L64:
        r24 = 0;
        goto L65
    L35:
        r12 = null;
        goto L36
    L21:
        if (PadConfigUtils.c() == false) goto L24;
        ProfilePreInflateViewInfo r26 = ProfilePreInflateViewInfo.TTLIVE_PROFILE_LAYOUT_HD;
    L27:
        r7 = ProfilePreInflateUtil.c(r26, getContext(), r3, r4, false);
        goto L29
    L24:
        if (isVertical() == false) goto L26;
        r26 = ProfilePreInflateViewInfo.TTLIVE_PROFILE_LAYOUT_PORT;
        goto L27
    L26:
        r26 = ProfilePreInflateViewInfo.TTLIVE_PROFILE_LAYOUT_LAND;
        goto L27
    L8:
        if (isVertical() == true) goto L10;
        r6 = 2131565671;
        goto L15
    L10:
        r6 = 2131565673;
        goto L15
    L12:
        if (PadConfigUtils.c() == false) goto L14;
        r6 = 2131565670;
        goto L15
    L14:
        r6 = 2131565672;
        goto L15
    }
}
