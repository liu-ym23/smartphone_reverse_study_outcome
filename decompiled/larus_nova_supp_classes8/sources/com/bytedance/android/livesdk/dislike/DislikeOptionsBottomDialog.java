package com.bytedance.android.livesdk.dislike;

import android.R;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Vibrator;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.live.base.model.longpresspanel.ItemIdentity;
import com.bytedance.android.live.base.model.user.FollowInfo;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.monitor.SafetyGuard;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.screen.FoldScreenUtils;
import com.bytedance.android.live.platformplayer.model.LivePanelType;
import com.bytedance.android.live.room.api.ILiveShareService;
import com.bytedance.android.live.room.api.panel.PanelName;
import com.bytedance.android.live.room.api.screenrotation.api.IScreenRotateService;
import com.bytedance.android.livehostapi.TTLiveSDK;
import com.bytedance.android.livehostapi.business.IHostBusiness;
import com.bytedance.android.livehostapi.business.IHostLiveAd;
import com.bytedance.android.livehostapi.business.depend.livead.ILiveFeedbackManager;
import com.bytedance.android.livehostapi.business.depend.livead.model.LiveFeedbackParams;
import com.bytedance.android.livesdk.LiveDialogFragment;
import com.bytedance.android.livesdk.TTLiveSDKContext;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.config.bf1;
import com.bytedance.android.livesdk.config.e81;
import com.bytedance.android.livesdk.config.l2;
import com.bytedance.android.livesdk.config.m70;
import com.bytedance.android.livesdk.config.pd0;
import com.bytedance.android.livesdk.config.qd0;
import com.bytedance.android.livesdk.config.sr;
import com.bytedance.android.livesdk.dislike.action.NotifyAction;
import com.bytedance.android.livesdk.dislike.action.OptionAction;
import com.bytedance.android.livesdk.dislike.action.b0;
import com.bytedance.android.livesdk.dislike.adapter.ExpandItemListAdapter;
import com.bytedance.android.livesdk.dislike.layout.IMContactLayoutV2;
import com.bytedance.android.livesdk.dislike.layout.IMMoreContactDescItemLayout;
import com.bytedance.android.livesdk.dislike.layout.IMMoreContactLayout;
import com.bytedance.android.livesdk.dislike.layout.OptionDescItemLayoutV2;
import com.bytedance.android.livesdk.dislike.layout.RecommendToFriendsLayout;
import com.bytedance.android.livesdk.dislike.layout.ShareFansItemLayout;
import com.bytedance.android.livesdk.dislike.layout.ShareLiveToDailyLayout;
import com.bytedance.android.livesdk.dislike.preload.datamanager.LLPanelPreprocessor;
import com.bytedance.android.livesdk.dislike.preload.loader.LPPanelViewRecycler;
import com.bytedance.android.livesdk.user.UserApi;
import com.bytedance.android.livesdk.utils.LivePanelsOptUtil;
import com.bytedance.android.livesdk.widget.LiveBottomSheetDialog;
import com.bytedance.android.livesdk.widget.LiveHorizontalScrollView;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatusStyle;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.RoomAuthStatus;
import com.bytedance.android.livesdkapi.distribution.EXTERNAL_CONFIG_TYPE;
import com.bytedance.android.livesdkapi.distribution.IExternalConfigJudger;
import com.bytedance.android.livesdkapi.imagerecognition.ImageRecognitionButton;
import com.bytedance.android.livesdkapi.model.CommunityFoldFixConfig;
import com.bytedance.android.livesdkapi.model.ReportConfig;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.ies.bullet.pool.util.PoolUtilKt;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.childwindow.LandscapeChildDialogBoundsAdapter;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import j40.c4;
import j40.d4;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.sequences.SequencesKt;
import org.json.JSONArray;
import zg1.h1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/dislike/DislikeOptionsBottomDialog;", "Lcom/bytedance/android/livesdk/LiveDialogFragment;", "a", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class DislikeOptionsBottomDialog extends LiveDialogFragment {
    public static final /* synthetic */ int y1 = 0;
    public int A;
    public int B;
    public int C;
    public boolean D;
    public int E;
    public OptionDescItemLayoutV2 F;
    public NotifyAction G;
    public boolean H;
    public List<? extends n> H0;
    public boolean I;
    public DataCenter J;
    public long K;
    public RoomAuthStatus.Style L;
    public n L0;
    public Integer M;
    public Disposable N;
    public RecyclerView O;
    public int P;
    public Fragment P0;
    public int Q;
    public ILiveFeedbackManager R;
    public JSONArray S;
    public JSONArray T;
    public final List<View> U;
    public pt1.a V;
    public String V0;
    public boolean W;
    public boolean X;
    public boolean Y;
    public List<? extends n> Z;
    public final Lazy b1;
    public final Lazy d;
    public final Lazy e;
    public final Lazy f;
    public final Lazy g;
    public final g g1;
    public final Lazy h;
    public boolean h1;
    public final Lazy i;
    public final Lazy j;
    public final Lazy k;
    public LLPanelPreprocessor k0;
    public boolean k1;
    public final Lazy l;
    public final Lazy m;
    public final Lazy n;
    public final Lazy o;
    public final Lazy p;
    public List<? extends n> p0;
    public final Room p1;
    public ActionsManager q;
    public LiveHorizontalScrollView r;
    public View s;
    public LinearLayout t;
    public LinearLayout u;
    public LinearLayout v;
    public final String v1;
    public List<LinearLayout> w;
    public u x;
    public final String x1;
    public int y;
    public int z;

    public static final class a {
    }

    public static final class b implements ILiveFeedbackManager.Callback {
        public final /* synthetic */ DislikeOptionsBottomDialog a;
        public final /* synthetic */ List b;
        public final /* synthetic */ List c;

        public final void onFeedbackSubmitted() {
            this.a.dismiss();     // Catch: Exception -> L5
        L9:
            xs2.b r0 = xs2.b.a();
            Room r1 = this.a.p1;
            if (r1 == null) goto L12;
            r1.setAdLegacyDislikeShouldRequest(false);
            Unit r2 = Unit.INSTANCE;
        L13:
            r0.post(new h1(r1));
            return;
        L12:
            r1 = null;
        L5:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
            Throwable r3 = DialogFragmentLancet.sLastShowStack;
            if (r3 == null) goto L9;
            com.bytedance.crash.d.d(r3, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            goto L9
        }

        public b(DislikeOptionsBottomDialog r1, List r2, List r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    public static final class c implements com.bytedance.android.live.base.model.user.q {
        public final /* synthetic */ DislikeOptionsBottomDialog a;
        public final /* synthetic */ Ref.ObjectRef b;

        public final void a(List<com.bytedance.android.live.base.model.user.f> r10) {
            if (this.a.isAdded() == true) goto L5;
            return;
        L5:
            ActionsManager r0 = this.a.q;
            if (r0 != null) goto L8;
            return;
        L8:
            if ((!r10.isEmpty()) == true) goto L11;
            r10 = null;
        L11:
            if (r10 != null) goto L13;
        L27:
            this.a.T90((List) this.b.element);
            int r11 = com.bytedance.android.live.room.api.panel.d.a;
            Room r12 = r0.d;
            if (r12 == null) goto L30;
            long r4 = r12.getRoomId();
        L31:
            com.bytedance.android.live.room.api.panel.c r13 = com.bytedance.android.live.room.api.panel.d.b(null, r4);
            if (r13 == null) goto L34;
            r13.notifyPanelOpen(PanelName.LongPress, this.a.g1);
        L34:
            this.a.ha0(true);
            LivePanelsOptUtil.d(r0.f);
            return;
        L30:
            r4 = 0;
            goto L31
        L13:
            if (DislikeOptionsBottomDialog.S90(this.a, ItemIdentity.IM_MESSAGE.getKey()) == false) goto L18;
            Iterator<T> r1 = r10.iterator();
        L16:
            if (r1.hasNext() == false) goto L18;
            com.bytedance.android.live.base.model.user.f r5 = (com.bytedance.android.live.base.model.user.f) r1.next();
            List r6 = (List) this.b.element;
            Intrinsics.checkNotNullParameter(r5, "contact");
            r6.add(new l(r5, new com.bytedance.android.livesdk.dislike.action.l(r0, r5), ItemType.IM_MESSAGE));
        L18:
            Integer r2 = this.a.M;
            int r7 = (int) 2;
            if (r2 == null) goto L24;
            if (r2.intValue() != r7) goto L24;
        L26:
            TTLiveSDK.hostService().user().fetchActiveStatusList(this.a, r10);
        L24:
            if (DislikeOptionsBottomDialog.S90(this.a, ItemIdentity.MORE_FRIENDS.getKey()) == false) goto L26;
            u r3 = r0.o();
            ((List) this.b.element).add(r3);
            this.a.x = r3;
            goto L26
        }

        public c(DislikeOptionsBottomDialog r1, Ref.ObjectRef r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public static final class d implements View.OnClickListener {
        public final /* synthetic */ u a;

        public d(u r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            this.a.b.b(r2);
        }
    }

    public static final class e implements LiveBottomSheetDialog.j {
        public e() {
        }

        public final boolean a() {
            return true;
        }
    }

    public static final class f extends a81.b.a {
        public final /* synthetic */ DislikeOptionsBottomDialog a;

        public f(DislikeOptionsBottomDialog r1) {
            this.a = r1;
        }

        public final void b(int r2) {
            DislikeOptionsBottomDialog r0 = this.a;
            if (r2 != 0) goto L5;
            int r3 = UtilityKotlinExtentionsKt.i(375);
        L6:
            r0.A = r3;
            return;
        L5:
            r3 = UIUtils.getScreenWidth(r0.getContext());
            goto L6
        }
    }

    public static final class g implements com.bytedance.android.live.room.api.panel.b {
        public final /* synthetic */ DislikeOptionsBottomDialog a;

        public static final class a implements Runnable {
            public final /* synthetic */ g a;
            public final /* synthetic */ Function1 b;

            public a(g r1, Function1 r2) {
                this.a = r1;
                this.b = r2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                Function1 r0 = this.b;     // Catch: Throwable -> L8
                View r1 = this.a.a.s;     // Catch: Throwable -> L8
                if (r1 == null) goto L5;
                int r2 = r1.getHeight();     // Catch: Throwable -> L8
            L6:
                r0.invoke(Integer.valueOf(r2));     // Catch: Throwable -> L8
                return;
            L5:
                r2 = 0;
            L8:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L12;
                return;
            L12:
                throw th;
            }
        }

        public final int getUnionId() {
            return hashCode();
        }

        public final PanelName getPanelName() {
            return PanelName.LongPress;
        }

        public g(DislikeOptionsBottomDialog r1) {
            this.a = r1;
        }

        public final void a(Function1<? super Integer, Unit> r2, Function1<? super String, Unit> r3) {
            Intrinsics.checkNotNullParameter(r2, "continueAction");
            Intrinsics.checkNotNullParameter(r3, "stopAction");
            View r0 = this.a.s;
            if (r0 == null) goto L5;
            r0.post(new a(this, r2));
            return;
        L5:
            r3.invoke("root view is null");
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.dislike.DislikeOptionsBottomDialog$onViewCreated$1, reason: invalid class name */
    public static final class AnonymousClass1 implements m {
        public final /* synthetic */ DislikeOptionsBottomDialog a;
        public final /* synthetic */ View b;

        @Override // com.bytedance.android.livesdk.dislike.m
        public final String a() {
            return this.a.V0;
        }

        @Override // com.bytedance.android.livesdk.dislike.m
        public final void b() {
            DislikeOptionsBottomDialog r0 = this.a;
            if (r0.D == true) goto L5;
        L15:
            LinearLayout r1 = this.a.t;
            if (r1 == null) goto L21;
            Iterator r2 = SequencesKt.toList(SequencesKt.filter(UtilityKotlinExtentionsKt.g(r1), new DislikeOptionsBottomDialog$onViewCreated$1$showAdFeedbackOptions$$inlined$run$lambda$1(this))).iterator();
        L19:
            if (r2.hasNext() == false) goto L21;
            r1.removeView((View) r2.next());
        L21:
            ILiveFeedbackManager r3 = this.a.R;
            if (r3 == null) goto L26;
            r3.showFeedbackView();
            return;
        L26:
            return;
        L5:
            if (r0.E > 1) goto L15;
            View r4 = r0.s;
            if (r4 == null) goto L9;
            ViewGroup.LayoutParams r5 = r4.getLayoutParams();
        L10:
            if (r5 == null) goto L12;
            r5.height = -2;
        L12:
            View r6 = this.a.s;
            if (r6 == null) goto L15;
            r6.setLayoutParams(r5);
            goto L15
        L9:
            r5 = null;
            goto L10
        }

        @Override // com.bytedance.android.livesdk.dislike.m
        public final boolean c() {
            DislikeOptionsBottomDialog r0 = this.a;
            int r1 = DislikeOptionsBottomDialog.y1;
            if (r0.ea0() == false) goto L9;
            ILiveFeedbackManager r2 = this.a.R;
            if (r2 == null) goto L9;
            if (r2.enableOptionsStyle() != true) goto L9;
            return true;
        L9:
            return false;
        }

        @Override // com.bytedance.android.livesdk.dislike.m
        public final void dismiss() {
            this.a.dismiss();     // Catch: Exception -> L5
            return;
        L5:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
            Throwable r0 = DialogFragmentLancet.sLastShowStack;
            if (r0 == null) goto L12;
            com.bytedance.crash.d.d(r0, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            return;
        }

        @Override // com.bytedance.android.livesdk.dislike.m
        public Context getContext() {
            return this.b.getContext();
        }

        @Override // com.bytedance.android.livesdk.dislike.m
        public final void refreshData() {
            User r1 = null;
            if (sr.a.getValue().booleanValue() == false) goto L8;
            Room r0 = this.a.p1;
            if (r0 == null) goto L7;
            r1 = r0.getOwner();
        L7:
            com.bytedance.android.live.room.api.follow.b.c(r1, "DislikeOptionsBottomDialog-onViewCreated-2", this.a.p1, new DislikeOptionsBottomDialog$onViewCreated$1$refreshData$1(this));
            return;
        L8:
            DislikeOptionsBottomDialog r2 = this.a;
            int r3 = DislikeOptionsBottomDialog.y1;
            r2.U90(true, null);
        }

        public AnonymousClass1(DislikeOptionsBottomDialog r1, View r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    static {
    }

    public DislikeOptionsBottomDialog() {
        this(null, null, null, null, null);
    }

    public final int Y90() {
        return ((Number) this.p.getValue()).intValue();
    }

    public final int Z90() {
        return ((Number) this.e.getValue()).intValue();
    }

    public final int aa0() {
        return ((Number) this.d.getValue()).intValue();
    }

    public final LPPanelViewRecycler ca0() {
        return (LPPanelViewRecycler) this.b1.getValue();
    }

    public final void ia0() {
        if (this.D == true) goto L5;
    L15:
        LinearLayout r0 = this.t;
        if (r0 == null) goto L21;
        Iterator r1 = SequencesKt.toList(SequencesKt.filter(UtilityKotlinExtentionsKt.g(r0), new DislikeOptionsBottomDialog$showAdFeedbackOptions$$inlined$run$lambda$1(this))).iterator();
    L19:
        if (r1.hasNext() == false) goto L21;
        r0.removeView((View) r1.next());
    L21:
        ILiveFeedbackManager r2 = this.R;
        if (r2 == null) goto L26;
        r2.showFeedbackView();
        return;
    L26:
        return;
    L5:
        if (this.E > 1) goto L15;
        View r3 = this.s;
        if (r3 == null) goto L9;
        ViewGroup.LayoutParams r4 = r3.getLayoutParams();
    L10:
        if (r4 == null) goto L12;
        r4.height = -2;
    L12:
        View r5 = this.s;
        if (r5 == null) goto L15;
        r5.setLayoutParams(r4);
        goto L15
    L9:
        r4 = null;
        goto L10
    }

    public final boolean ea0() {
        if (am2.n.f().c().length() <= 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L8;
    L12:
        return false;
    L8:
        if (this.S.length() <= 0) goto L10;
        return true;
    L10:
        if (this.T.length() <= 0) goto L12;
        return true;
    L5:
        r0 = false;
        goto L6
    }

    public final boolean getEnableAdaptFold() {
        return this.k1;
    }

    public final boolean getShouldUseNewPanel() {
        return this.h1;
    }

    public static void fa0(ViewGroup r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        Iterator r4 = UtilityKotlinExtentionsKt.g(r3).iterator();
    L6:
        if (r4.hasNext() == false) goto L21;
        View r0 = (View) r4.next();
        if ((r0 instanceof OptionDescItemLayoutV2) == true) goto L10;
        r0 = null;
    L10:
        OptionDescItemLayoutV2 r1 = (OptionDescItemLayoutV2) r0;
        if (r1 == null) goto L6;
        String r2 = r1.d;
        if (r2 == null) goto L6;
        if (r2.length() <= 0) goto L18;
        boolean r5 = true;
    L19:
        if (r5 == false) goto L6;
        com.bytedance.android.livesdk.sharedpref.f.d(new com.bytedance.android.livesdk.sharedpref.e("long_press_dot_".concat(r2), Boolean.FALSE), Boolean.TRUE);
        goto L6
    L18:
        r5 = false;
        goto L19
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v0 */
    /* JADX WARN: Type inference failed for: r6v31, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r6v58 */
    public final void T90(List<n> r32) {
        Ref.IntRef r2 = new Ref.IntRef();
        r2.element = 0;
        this.E = 0;
        Iterator<n> r4 = r32.iterator();
    L3:
        ?? r6 = 1;
        if (r4.hasNext() == false) goto L15;
        n r5 = r4.next();
        if ((r5 instanceof l) == true) goto L3;
        if ((!Intrinsics.areEqual(r5, this.x)) == false) goto L3;
        if ((r5 instanceof z) == true) goto L3;
        if ((r5 instanceof j) == true) goto L3;
        r2.element++;
        goto L3
    L15:
        ViewGroup.MarginLayoutParams r7 = new ViewGroup.MarginLayoutParams(-1, -2);
        int r8 = UtilityKotlinExtentionsKt.i(12);
        r7.leftMargin = r8;
        r7.rightMargin = r8;
        if (this.r != null) goto L21;
        View r9 = getLayoutInflater().inflate(2131565631, null);
        if ((r9 instanceof LiveHorizontalScrollView) == true) goto L20;
        r9 = null;
    L20:
        this.r = (LiveHorizontalScrollView) r9;
    L21:
        Ref.ObjectRef r10 = new Ref.ObjectRef();
        r10.element = null;
        ArrayList r11 = new ArrayList();
        if (t.c() == false) goto L34;
        View r12 = getLayoutInflater().inflate(2131565630, null);
        r10.element = r12;
        if (r12 == null) goto L26;
        RecyclerView r13 = (RecyclerView) r12.findViewById(2131371896);
    L27:
        this.O = r13;
        ArrayList r14 = new ArrayList();
        Iterator<T> r15 = r32.iterator();
    L29:
        if (r15.hasNext() == false) goto L33;
        Object r16 = r15.next();
        if ((r16 instanceof j) == false) goto L29;
        r14.add(r16);
        goto L29
    L33:
        r11.addAll(r14);
        goto L34
    L26:
        r13 = null;
    L34:
        LinearLayout r17 = this.t;
        if (r17 != null) goto L37;
    L284:
        View r3 = this.s;
        if (r3 == null) goto L321;
        if (this.I == false) goto L289;
    L319:
        r3.requestLayout();
        goto L321
    L289:
        if (this.E == 0) goto L321;
        if (t.a() == false) goto L312;
        int r18 = ((Number) this.o.getValue()).intValue();
        int r19 = this.E;
        int r20 = r2.element;
        int r21 = (this.z * this.Q) + (((Number) this.n.getValue()).intValue() * this.Q);
        if (r19 != 0) goto L296;
        r21 = ba0(r20);
    L296:
        int r22 = r18 + r21;
        RecyclerView r23 = this.O;
        if (r23 == null) goto L301;
        RecyclerView.Adapter r24 = r23.getAdapter();
        if (r24 == null) goto L301;
        int r110 = (r24.getItemCount() * Y90()) + ((Number) this.g.getValue()).intValue();
    L302:
        int r25 = r22 + r110;
        float r26 = this.E * 1.0f;
        if (t.b() == false) goto L305;
    L308:
        float r27 = 3.5f;
    L309:
        int r28 = r25 + ((int) (Math.min(r26, r27) * Y90()));
        ViewGroup.LayoutParams r29 = r3.getLayoutParams();
        if (r29 == null) goto L319;
        r29.height = Math.min(r28, (this.B * 2) / 3);
        goto L319
    L305:
        if (t.c() == true) goto L308;
        r27 = 5.5f;
    L301:
        r110 = 0;
        goto L302
    L312:
        int r30 = this.z + ((Number) this.n.getValue()).intValue();
        if (this.E != 0) goto L315;
        int r31 = ba0(r2.element);
    L316:
        int r33 = ((((Number) this.o.getValue()).intValue() + (this.E * Y90())) + r31) + 0;
        int r34 = this.C + r30;
        ViewGroup.LayoutParams r35 = r3.getLayoutParams();
        if (r35 == null) goto L319;
        r35.height = Math.min(r33, Math.min(r34, (this.B * 2) / 3));
        goto L319
    L315:
        r31 = r30;
    L321:
        if (this.X == false) goto L355;
        this.Z = r32;
        return;
    L355:
        return;
    L37:
        if (r17.getChildCount() <= 0) goto L39;
        ca0().recycle(r17);
    L39:
        r17.removeAllViews();
        if (com.bytedance.android.livesdk.model.b.d() == true) goto L208;
        LiveHorizontalScrollView r111 = this.r;
        if (r111 == null) goto L44;
        PoolUtilKt.a(r111);
    L44:
        r17.addView(this.r);
        LiveHorizontalScrollView r112 = this.r;
        if (r112 == null) goto L47;
        ((ArrayList) this.U).add(r112);
    L47:
        View r36 = (View) r10.element;
        if (r36 == null) goto L50;
        r17.addView(r36);
        ((ArrayList) this.U).add(r36);
    L50:
        int r37 = this.A;
        int r38 = r2.element;
        if (r37 >= 720) goto L54;
        this.z = ((Number) this.k.getValue()).intValue();
        this.y = ((Number) this.k.getValue()).intValue();
    L60:
        LiveHorizontalScrollView r39 = this.r;
        if (r39 == null) goto L63;
        LinearLayout r40 = (LinearLayout) r39.findViewById(2131385234);
    L64:
        this.u = r40;
        LiveHorizontalScrollView r41 = this.r;
        if (r41 == null) goto L67;
        LinearLayout r42 = (LinearLayout) r41.findViewById(2131385688);
    L68:
        this.v = r42;
        if (com.bytedance.android.livesdk.model.b.e() == false) goto L76;
        LinearLayout r43 = this.u;
        if (r43 == null) goto L73;
        r43.removeAllViews();
    L73:
        LinearLayout r44 = this.v;
        if (r44 == null) goto L76;
        r44.removeAllViews();
    L76:
        ILiveFeedbackManager r113 = this.R;
        if (r113 == null) goto L79;
        boolean r45 = r113.addFeedbackView(this.s, r17, this.U, this.S, this.T, new b(this, r32, r11));
    L80:
        this.D = r45;
        ArrayList r46 = new ArrayList();
        Iterator<n> r47 = r32.iterator();
        ViewGroup r48 = null;
        int r114 = 0;
    L82:
        if (r47.hasNext() == false) goto L185;
        n r115 = r47.next();
        if ((r115 instanceof u) == false) goto L145;
        if (Intrinsics.areEqual(r115, this.x) == false) goto L108;
        u r116 = (u) r115;
        Context r117 = r17.getContext();
        IMMoreContactLayout r118 = ca0().pollMoreContactView();
        if (r118 == null) goto L90;
        PoolUtilKt.a(r118);
        IMMoreContactLayout r49 = r118;
    L91:
        r49.update(r116);
        r49.setBackgroundResource(2131249493);
        r17.addView(r49, r7);
        ILiveShareService r119 = jc1.k.f(ILiveShareService.class);
        if (r119 == null) goto L95;
        Pair r120 = r119.getSharePanelMoreText();
        if (r120 == null) goto L95;
    L96:
        boolean r50 = ((Boolean) r120.component1()).booleanValue();
        String r121 = (String) r120.component2();
        if (r50 == false) goto L143;
        Intrinsics.checkNotNullParameter(r121, "text");
        IMMoreContactDescItemLayout r51 = r49.a;
        if (r121 != null) goto L101;
        r51.getClass();
        goto L143
    L101:
        TextView r52 = r51.a;
        if (r52 == null) goto L104;
        r52.setText(r121);
    L104:
        TextView r53 = r51.a;
        if (r53 == null) goto L143;
        r53.setContentDescription(r53.getText() + " 按钮");
    L143:
        r114 = r114 + 1;
        Iterator<n> r122 = r47;
        ViewGroup r54 = r48;
    L183:
        r47 = r122;
        r6 = 1;
        r48 = r54;
    L95:
        r120 = new Pair(Boolean.FALSE, "");
        goto L96
    L90:
        r49 = new IMMoreContactLayout(r117);
        goto L91
    L108:
        if (r2.element != r6) goto L137;
        u r123 = (u) r115;
        Context r55 = r17.getContext();
        View r56 = getLayoutInflater().inflate(2131565633, this.u);
        if (r56 == null) goto L143;
        ImageView r124 = (ImageView) r56.findViewById(2131374718);
        if (r124 == null) goto L114;
        r124.setImageResource(r123.c.a);
    L114:
        TextView r125 = (TextView) r56.findViewById(2131368819);
        if (r125 == null) goto L131;
        r125.setText(r55.getResources().getText(r123.c.b));
        String r57 = r123.c.c;
        if (r57 != null) goto L119;
    L128:
        TextPaint r58 = r125.getPaint();
        if (r58 == 0) goto L131;
        r58.setFakeBoldText(r6);
        goto L131
    L119:
        if (r57.length() <= 0) goto L121;
        boolean r59 = true;
    L122:
        if (r59 != r6) goto L128;
        CharSequence r60 = r123.c.c;
        if (r60 != null) goto L127;
        r60 = r125.getText();
    L127:
        r125.setText(r60);
        goto L128
    L121:
        r59 = false;
    L131:
        r56.setOnClickListener(new i(r123));
        if (this.X == false) goto L143;
        OptionAction r61 = r123.b;
        if (r61.d == false) goto L143;
        OptionAction.e(r61);
        goto L143
    L137:
        if (t.b() == true) goto L139;
    L142:
        da0((u) r115, X90(this.A, r2.element, r114), r17.getContext(), this.u);
        goto L143
    L139:
        if (this.P <= 6) goto L142;
        r46.add(r115);
        goto L143
    L145:
        if ((r115 instanceof l) == false) goto L162;
        this.E += r6;
        IMContactLayoutV2 r62 = ca0().pollIMContactLayoutV2();
        if (r62 != null) goto L149;
        r62 = new IMContactLayoutV2(r17.getContext());
    L149:
        r62.setFragment(this);
        r62.update((l) r115);
        Integer r126 = this.M;
        r122 = r47;
        int r63 = (int) 2;
        if (r126 != null) goto L153;
    L157:
        r62.b(false, "");
    L158:
        if (r48 != null) goto L160;
        r62.setBackgroundResource(2131249492);
    L161:
        r17.addView(r62, r7);
        r54 = r62;
        goto L183
    L160:
        r62.setBackgroundColor(-1);
        goto L161
    L153:
        if (r126.intValue() != r63) goto L157;
        RoomAuthStatus.Style r64 = this.L;
        if (r64 == null) goto L158;
        r62.b(true, r64.getContent());
        goto L158
    L162:
        r122 = r47;
        if ((r115 instanceof z) == false) goto L167;
        this.E++;
        ShareFansItemLayout r65 = new ShareFansItemLayout(r17.getContext());
        r65.update((z) r115);
        r65.setBackgroundResource(2131249492);
        r17.addView(r65, r7);
        r54 = r65;
        goto L183
    L167:
        if ((r115 instanceof y) == false) goto L176;
        this.E++;
        RecommendToFriendsLayout r66 = ca0().pollRecommendToFriendsLayout();
        if (r66 != null) goto L171;
        r66 = new RecommendToFriendsLayout(r17.getContext(), null, 6, 0);
    L171:
        r66.update((y) r115);
        if (r48 != null) goto L174;
        r66.setBackgroundResource(2131249492);
    L175:
        r17.addView(r66, r7);
        r54 = r66;
        goto L183
    L174:
        r66.setBackgroundColor(-1);
        goto L175
    L176:
        r54 = r48;
        if ((r115 instanceof a0) == false) goto L183;
        this.E++;
        ShareLiveToDailyLayout r67 = new ShareLiveToDailyLayout(r17.getContext(), null, 6, 0);
        r67.update((a0) r115, this.p1);
        if (r48 != null) goto L181;
        r67.setBackgroundResource(2131249492);
    L182:
        r17.addView(r67, r7);
        r54 = r67;
        goto L183
    L181:
        r67.setBackgroundColor(-1);
        goto L182
    L185:
        if (this.x != null) goto L188;
        if (r48 == null) goto L188;
        r48.setBackgroundResource(2131249493);
    L188:
        Context r68 = r17.getContext();
        List r69 = CollectionsKt.take(r46, (int) Math.ceil(((double) r46.size()) / 2.0d));
        List r70 = CollectionsKt.takeLast(r46, r46.size() / 2);
        LinearLayout r71 = this.v;
        if (r71 == null) goto L191;
        r71.setVisibility(0);
    L191:
        Iterator r72 = r69.iterator();
        int r73 = 0;
    L193:
        if (r72.hasNext() == false) goto L198;
        u r75 = (u) r72.next();
        OptionAction r76 = r75.b;
        if (r76 == null) goto L197;
        OptionAction.e(r76);
    L197:
        da0(r75, X90(this.A, r69.size(), r73), r68, this.u);
        r73 = r73 + 1;
        goto L193
    L198:
        Iterator r77 = r70.iterator();
        int r78 = 0;
    L200:
        if (r77.hasNext() == false) goto L205;
        u r79 = (u) r77.next();
        OptionAction r80 = r79.b;
        if (r80 == null) goto L204;
        OptionAction.e(r80);
    L204:
        da0(r79, X90(this.A, r70.size(), r78), r68, this.v);
        r78 = r78 + 1;
        goto L200
    L205:
        RecyclerView r81 = this.O;
        if (r81 == null) goto L283;
        r81.setLayoutManager(new LinearLayoutManager(r81.getContext(), 1, false));
        r81.setAdapter(new ExpandItemListAdapter(r11));
    L283:
        r17.requestLayout();
        goto L284
    L79:
        r45 = false;
        goto L80
    L67:
        r42 = null;
        goto L68
    L63:
        r40 = null;
        goto L64
    L54:
        if (t.b() == true) goto L58;
        if (r38 <= 4) goto L58;
        int r82 = (((r37 - aa0()) - (Z90() * 4)) * 6) / 25;
    L59:
        this.y = r82;
        this.z = r82;
    L58:
        r82 = ((r37 - (aa0() * 2)) - (Z90() * 3)) / 4;
        goto L59
    L208:
        ActionsManager r83 = this.q;
        if (r83 == null) goto L283;
        boolean r84 = this.I;
        ArrayList r85 = new ArrayList();
        int r86 = com.bytedance.android.livesdk.model.b.a().getStyle();
        if (r86 == 2) goto L217;
        if (r86 == 4) goto L217;
        if (r86 == 6) goto L217;
        boolean r87 = false;
    L218:
        if (r87 == true) goto L224;
        if (r84 == true) goto L221;
    L223:
        r85.add(r83.g(l2.a.getValue().booleanValue()));
    L226:
        if (com.bytedance.android.livesdk.model.b.b(null) == false) goto L228;
        r85.add(r83.j());
    L228:
        List r88 = CollectionsKt.toMutableList(CollectionsKt.filterNotNull(r85));
        if (r88 == null) goto L283;
        Context r89 = getContext();
        if (r89 == null) goto L283;
        r88.addAll(r32);
        if ((r88.size() % 2) != 0) goto L237;
        int r90 = 4;
    L238:
        int r91 = (r90 - (r88.size() % r90)) % r90;
        if (r88.size() != 4) goto L241;
        r90 = 2;
        r91 = 0;
    L241:
        int r92 = 1;
        if (1 > r91) goto L256;
    L243:
        ActionsManager r93 = this.q;
        if (r93 == null) goto L246;
        u r94 = new u(new nt1.c(2131252287, 2131916236, "", false, true, false, null, 96), new b0(r93), ItemType.BLANK_SPACE);
    L248:
        if ((r94 instanceof n) == true) goto L250;
        r94 = null;
    L250:
        if (r94 == null) goto L256;
        r88.add(r94);
        if (r92 == r91) goto L256;
        r92 = r92 + 1;
        goto L243
    L246:
        r94 = null;
    L256:
        if (this.w != null) goto L258;
        this.w = new ArrayList();
    L258:
        int r95 = r88.size();
        int r96 = 0;
        LinearLayout r97 = null;
    L259:
        if (r96 >= r95) goto L283;
        Object r127 = ListProtector.get(r88, r96);
        if ((r127 instanceof u) == true) goto L263;
        r127 = null;
    L263:
        u r128 = (u) r127;
        if (r128 == null) goto L282;
        int r129 = r96 % r90;
        if (r129 != 0) goto L280;
        View r130 = getLayoutInflater().inflate(2131565631, null);
        if ((r130 instanceof LiveHorizontalScrollView) == true) goto L271;
        r130 = null;
    L271:
        LiveHorizontalScrollView r131 = (LiveHorizontalScrollView) r130;
        if (r131 == null) goto L280;
        r97 = (LinearLayout) r131.findViewById(2131385234);
        List<LinearLayout> r132 = this.w;
        if (r132 == null) goto L276;
        ((ArrayList) r132).add(r97);
    L276:
        LinearLayout r133 = this.t;
        if (r133 == null) goto L280;
        r133.addView(r131);
    L280:
        if (r97 == null) goto L282;
        da0(r128, X90(this.A, r90, r129), r89, r97);
    L282:
        r96 = r96 + 1;
        goto L259
    L237:
        r90 = 3;
        goto L238
    L221:
        if (com.bytedance.android.livesdk.model.b.e() == false) goto L223;
    L224:
        r85.add(r83.f());
        r85.add(r83.e());
    L217:
        r87 = true;
        goto L218
    }

    public final void V90(List<n> r4) {
        ActionsManager r0 = this.q;
        if (r0 != null) goto L5;
        return;
    L5:
        if (m70.a.getValue().getLiveShareLiveToDailyEnable() == true) goto L7;
        a0 r1 = null;
    L8:
        if (r1 == null) goto L12;
        r4.add(r1);
        return;
    L12:
        return;
    L7:
        r1 = new a0(new com.bytedance.android.livesdk.dislike.action.z(r0), ItemType.SHARE_LIVE_TO_DAILY);
        goto L8
    }

    public final void W90(DialogInterface r5) {
        Intrinsics.checkNotNullParameter(r5, "dialog");
        super.onDismiss(r5);
        this.Y = true;
        fa0(this.u);
        fa0(this.v);
        List<LinearLayout> r6 = this.w;
        if (r6 == null) goto L9;
        ArrayList r7 = (ArrayList) r6;
        Iterator r0 = r7.iterator();
    L6:
        if (r0.hasNext() == false) goto L8;
        fa0((LinearLayout) r0.next());
        goto L6
    L8:
        r7.clear();
    L9:
        Disposable r8 = this.N;
        if (r8 == null) goto L12;
        r8.dispose();
    L12:
        ha0(false);
        List<? extends n> r1 = this.Z;
        if (r1 == null) goto L23;
        Iterator<? extends n> r2 = r1.iterator();
    L16:
        if (r2.hasNext() == false) goto L22;
        n r3 = r2.next();
        if ((r3 instanceof u) == false) goto L16;
        OptionAction r4 = r3.b;
        if (r4.d == false) goto L16;
        r4.c();
        goto L16
    L22:
        this.Z = null;
    L23:
        LLPanelPreprocessor r9 = this.k0;
        if (r9 == null) goto L26;
        ((com.bytedance.android.livesdk.dislike.preload.context.a) r9.c.getValue()).d(false);
    L26:
        LinearLayout r10 = this.t;
        if (r10 == null) goto L29;
        ca0().recycle(r10);
    L29:
        this.E = 0;
        int r11 = com.bytedance.android.live.room.api.panel.d.a;
        Room r12 = this.p1;
        if (r12 == null) goto L32;
        long r13 = r12.id;
    L33:
        com.bytedance.android.live.room.api.panel.c r14 = com.bytedance.android.live.room.api.panel.d.b(null, r13);
        if (r14 == null) goto L45;
        r14.notifyPanelClose(PanelName.LongPress, this.g1);
        return;
    L45:
        return;
    L32:
        r13 = 0;
        goto L33
    }

    public final int ba0(int r2) {
        if (r2 != 1) goto L5;
        int r3 = ((Number) this.i.getValue()).intValue() + ((Number) this.h.getValue()).intValue();
        int r0 = ((Number) this.f.getValue()).intValue();
    L7:
        return r3 + r0;
    L5:
        r3 = this.z + ((Number) this.h.getValue()).intValue();
        r0 = ((Number) this.f.getValue()).intValue();
        goto L7
    }

    public final void ga0(String r3) {
        if (((Boolean) d4.a.getValue()).booleanValue() == false) goto L18;
        dismiss();     // Catch: Exception -> L6
        return;
    L6:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");     // Catch: Exception -> L11
        Throwable r0 = DialogFragmentLancet.sLastShowStack;     // Catch: Exception -> L11
        if (r0 == null) goto L19;
        com.bytedance.crash.d.d(r0, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");     // Catch: Exception -> L11
        return;
    L19:
        return;
    L11:
        e = move-exception;
        SafetyGuard.a(null, e, r3.concat(" dismiss 异常"));
        return;
    }

    public final void ha0(boolean r5) {
        if (this.W == true) goto L5;
        return;
    L5:
        if (r5 == true) goto L7;
        ALogger.i("DislikeOptionsBottomDialog", "send close LivePanelEvent ");
        xs2.b r6 = xs2.b.a();
        ds0.b r0 = new ds0.b();
        r0.a(LivePanelType.OLD_LONG_PRESS);
        Intrinsics.checkNotNullParameter("close", "<set-?>");
        r0.b = "close";
        Unit r1 = Unit.INSTANCE;
        r6.post(r0);
        return;
    L7:
        if (this.Y == true) goto L12;
        ALogger.i("DislikeOptionsBottomDialog", "send open LivePanelEvent");
        xs2.b r7 = xs2.b.a();
        ds0.b r2 = new ds0.b();
        r2.a(LivePanelType.OLD_LONG_PRESS);
        Intrinsics.checkNotNullParameter("open", "<set-?>");
        r2.b = "open";
        WeakReference r3 = new WeakReference(getDialog());
        Intrinsics.checkNotNullParameter(r3, "<set-?>");
        r2.d = r3;
        r2.e = 2131384813;
        Unit r4 = Unit.INSTANCE;
        r7.post(r2);
        return;
    }

    public final void onActivityCreated(Bundle r3) {
        super.onActivityCreated(r3);
        Dialog r4 = getDialog();
        if (r4 == null) goto L8;
        Window r5 = r4.getWindow();
        if (r5 == null) goto L9;
        r5.setBackgroundDrawableResource(R.color.transparent);
        r5.setGravity(80);
        r5.setLayout(-1, -2);
        com.bytedance.android.annie.util.i.d(r5);
        WindowManager.LayoutParams r0 = r5.getAttributes();
        r0.dimAmount = 0.0f;
        r5.setAttributes(r0);
        return;
    L9:
        return;
    }

    public final void onCreate(Bundle r6) {
        super.onCreate(r6);
        setStyle(1, 2131954578);
        Room r0 = this.p1;
        if (r0 == null) goto L38;
        User r1 = r0.getOwner();
        if (r1 == null) goto L38;
        if (r1.isFollowing() != true) goto L38;
        HashMap r7 = new HashMap();
        Room r2 = this.p1;
        if (r2 == null) goto L14;
        User r3 = r2.getOwner();
        if (r3 == null) goto L14;
        String r4 = r3.getIdStr();
    L15:
        r7.put("target_uid", String.valueOf(r4));
        Room r5 = this.p1;
        if (r5 == null) goto L20;
        User r8 = r5.getOwner();
        if (r8 == null) goto L20;
        String r9 = r8.getCastSecUid();
    L21:
        r7.put("sec_target_uid", String.valueOf(r9));
        r7.put("packed_level", String.valueOf(2));
        r7.put("request_from", "live_push_settings");
        Room r10 = this.p1;
        if (r10 == null) goto L24;
        Long r11 = Long.valueOf(r10.id);
    L25:
        r7.put("current_room_id", String.valueOf(r11.longValue()));
        Room r12 = this.p1;
        if (r12 == null) goto L30;
        User r13 = r12.getOwner();
        if (r13 == null) goto L30;
        String r14 = r13.getIdStr();
    L31:
        r7.put("anchor_id", String.valueOf(r14));
        Room r15 = this.p1;
        if (r15 == null) goto L36;
        User r16 = r15.getOwner();
        if (r16 == null) goto L36;
        String r17 = r16.getCastSecUid();
    L37:
        r7.put("sec_anchor_id", String.valueOf(r17));
        this.N = ((UserApi) com.bytedance.android.live.network.c.b().e(UserApi.class)).queryUser(r7).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.bytedance.android.livesdk.dislike.g(this), new h(this));
    L36:
        r17 = null;
    L30:
        r14 = null;
        goto L31
    L24:
        r11 = null;
    L20:
        r9 = null;
    L14:
        r4 = null;
    L38:
        this.W = pd0.a.getValue().booleanValue();
        this.X = qd0.a.getValue().booleanValue();
        DataCenter r18 = this.J;
        if (r18 == null) goto L46;
        ImageRecognitionButton r19 = s32.b.c(r18);
        if (r19 != null) goto L43;
        return;
    L43:
        if (r19.getScene() != 2) goto L48;
        ALogger.i("DislikeOptionsBottomDialog", "register btm page");
        BtmSDK.INSTANCE.registerBtmPageOnCreate(this, "a1128.b83869", null);
        return;
    L48:
        return;
    }

    public final Dialog onCreateDialog(Bundle r3) {
        LiveBottomSheetDialog r4 = super.onCreateDialog(r3);
        if ((r4 instanceof LiveBottomSheetDialog) == false) goto L5;
        r4.setLiveBottomSheetDismissProcessor(new e());
    L5:
        return r4;
    }

    public final void onDismiss(DialogInterface r2) {
        W90(r2);     // Catch: Throwable -> L5
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

    public final void setEnableAdaptFold(boolean r1) {
        this.k1 = r1;
    }

    public final void setShouldUseNewPanel(boolean r1) {
        this.h1 = r1;
    }

    public static final boolean S90(DislikeOptionsBottomDialog r4, String r5) {
        r4.getClass();
        RoomContext r6 = RoomContext.a.c(RoomContext.Companion, r4.J, 0, 2);
        if (r6 == null) goto L12;
        com.bytedance.live.datacontext.n r7 = r6.getExternalConfigJudger();
        if (r7 == null) goto L13;
        IExternalConfigJudger r8 = (IExternalConfigJudger) r7.getValue();
        if (r8 != null) goto L9;
        return true;
    L9:
        if (r8.disable(EXTERNAL_CONFIG_TYPE.LongPressPanel, r5) != true) goto L15;
        return false;
    L15:
        return true;
    L13:
        return true;
    L12:
        return true;
    }

    public final void U90(boolean r19, Boolean r20) {
        Ref.ObjectRef r3 = new Ref.ObjectRef();
        List<? extends n> r4 = this.p0;
        long r6 = 0;
        if (r4 == null) goto L11;
        if ((!r4.isEmpty()) == true) goto L8;
        r4 = null;
    L8:
        if (r4 == null) goto L11;
        List<n> r0 = new ArrayList(r4);
    L35:
        r3.element = r0;
        if (r0.size() != 0) goto L45;
        ALogger.i("DislikeOptionsBottomDialog", "options is empty, dismiss now");
        dismiss();     // Catch: Exception -> L40
    L40:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r1 = DialogFragmentLancet.sLastShowStack;
        if (r1 == null) goto L45;
        com.bytedance.crash.d.d(r1, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
    L45:
        if (t.b() == false) goto L47;
        this.P = ((List) r3.element).size();
        this.Q = 2;
    L47:
        this.I = r19;
        this.C = ((int) (Y90() * 5.5f)) + ((Number) this.o.getValue()).intValue();
        Context r2 = getContext();
        if (r2 == null) goto L50;
        Object r5 = r2.getSystemService("vibrator");
    L52:
        if ((r5 instanceof Vibrator) == true) goto L54;
        r5 = null;
    L54:
        Vibrator r7 = (Vibrator) r5;
        if (r7 == null) goto L57;
        r7.vibrate(15);
    L57:
        ReportConfig r8 = bf1.a.getValue();
        if (r8 == null) goto L62;
        List r9 = r8.longPressShowList;
        if (r9 == null) goto L62;
        List r10 = CollectionsKt.toMutableList(r9);
    L64:
        if (com.bytedance.android.livesdk.model.b.d() == false) goto L68;
        if (r10 == null) goto L68;
        r10.remove("message");
    L68:
        if (((Boolean) c4.a.getValue()).booleanValue() == false) goto L78;
        if (TTLiveSDKContext.getHostService() != null) goto L74;
        SafetyGuard.a(null, null, "长按面板获取 TTLiveSDKContext.getHostService() 为 null");
        ga0("长按面板获取 TTLiveSDKContext.getHostService() 为 null");
        return;
    L74:
        if (TTLiveSDKContext.getHostService().h() != null) goto L78;
        SafetyGuard.a(null, null, "长按面板获取 TTLiveSDKContext.getHostService().user() 为 null");
        ga0("长按面板获取 TTLiveSDKContext.getHostService().user() 为 null");
        return;
    L78:
        if (TTLiveSDKContext.getHostService().h().isLogin() == true) goto L81;
        V90((List) r3.element);
        T90((List) r3.element);
        return;
    L81:
        List r11 = (List) r3.element;
        if (this.L0 == null) goto L108;
        Iterator r12 = r11.iterator();
        int r13 = -1;
        n r15 = null;
        int r14 = -1;
        int r16 = 0;
    L86:
        if (r12.hasNext() == false) goto L99;
        Object r17 = r12.next();
        int r18 = r16 + 1;
        if (r16 >= 0) goto L90;
        CollectionsKt.throwIndexOverflow();
    L90:
        n r110 = (n) r17;
        ItemType r21 = r110.a;
        if (r21 != ItemType.OPT_RECOMMEND) goto L94;
        r15 = r110;
        r13 = r16;
    L94:
        if (r21 != ItemType.FOLLOW) goto L96;
    L97:
        r14 = r16;
    L98:
        r16 = r18;
        goto L86
    L96:
        if (r21 != ItemType.UNFOLLOW) goto L98;
    L99:
        if (r13 < 0) goto L108;
        if (r14 < 0) goto L108;
        if (r13 >= r14) goto L108;
        ListProtector.remove(r11, r13);
        n r22 = this.L0;
        if (r22 == null) goto L106;
        ListProtector.add(r11, r13, r22);
    L106:
        if (r15 == null) goto L108;
        ListProtector.add(r11, r14 + 1, r15);
    L108:
        r3.element = r11;
        if (r10 != null) goto L111;
    L114:
        Room r23 = this.p1;
        if (r23 == null) goto L119;
        RoomAuthStatus r24 = r23.getRoomAuthStatus();
        if (r24 == null) goto L119;
        int r25 = (int) r24.getShowShare();
    L120:
        this.M = Integer.valueOf(r25);
        Room r26 = this.p1;
        if (r26 == null) goto L127;
        RoomAuthStatus r27 = r26.getRoomAuthStatus();
        if (r27 == null) goto L127;
        RoomAuthStatus.RoomAuthSpecialStyle r28 = r27.roomAuthSpecialStyle;
        if (r28 == null) goto L127;
        IRoomAuthStatusStyle r29 = r28.getShareStyle();
    L128:
        this.L = (RoomAuthStatus.Style) r29;
        Integer r30 = this.M;
        int r31 = (int) 2;
        if (r30 != null) goto L132;
    L139:
        Room r32 = this.p1;
        if (r32 == null) goto L151;
        User r33 = r32.getOwner();
        if (r33 == null) goto L151;
        if (r33.getSecret() != 1) goto L151;
        T90((List) r3.element);
        int r34 = com.bytedance.android.live.room.api.panel.d.a;
        com.bytedance.android.live.room.api.panel.c r35 = com.bytedance.android.live.room.api.panel.d.b(null, this.p1.getRoomId());
        if (r35 == null) goto L148;
        r35.notifyPanelOpen(PanelName.LongPress, this.g1);
    L148:
        ha0(true);
        return;
    L151:
        if (tb1.c.a == false) goto L255;
        List r36 = (List) r3.element;
        RoomContext.a r37 = RoomContext.Companion;
        RoomContext r38 = RoomContext.a.c(r37, this.J, 0, 2);
        if (r38 == null) goto L161;
        com.bytedance.live.datacontext.n r39 = r38.getExternalConfigJudger();
        if (r39 == null) goto L161;
        IExternalConfigJudger r40 = (IExternalConfigJudger) r39.getValue();
        if (r40 == null) goto L161;
        if (r40.disable(EXTERNAL_CONFIG_TYPE.LongPressPanel, ItemIdentity.SHARE_FANS.getKey()) != true) goto L161;
    L188:
        V90((List) r3.element);
        List r41 = (List) r3.element;
        RoomContext r42 = RoomContext.a.c(r37, this.J, 0, 2);
        if (r42 == null) goto L197;
        com.bytedance.live.datacontext.n r43 = r42.getExternalConfigJudger();
        if (r43 == null) goto L197;
        IExternalConfigJudger r44 = (IExternalConfigJudger) r43.getValue();
        if (r44 == null) goto L197;
        if (r44.disable(EXTERNAL_CONFIG_TYPE.LongPressPanel, ItemIdentity.RECOMMEND_TO_FRIENDS.getKey()) != true) goto L197;
    L203:
        List<? extends n> r45 = this.H0;
        if (r45 != null) goto L206;
    L243:
        TTLiveSDK.hostService().user().loadRecentContact(25, new c(this, r3));
        Unit r46 = Unit.INSTANCE;
        return;
    L206:
        if ((!r45.isEmpty()) == true) goto L209;
        r45 = null;
    L209:
        if (r45 == null) goto L243;
        ((List) r3.element).addAll(r45);
        Iterator<T> r47 = r45.iterator();
    L212:
        if (r47.hasNext() == false) goto L219;
        Object r48 = r47.next();
        if (((n) r48).a != ItemType.MORE_FRIENDS) goto L216;
        boolean r49 = true;
    L217:
        if (r49 == false) goto L212;
    L220:
        n r50 = (n) r48;
        if (r50 != null) goto L223;
    L227:
        Integer r51 = this.M;
        if (r51 != null) goto L231;
    L232:
        ActionsManager r52 = this.q;
        if (r52 == null) goto L235;
        u r53 = r52.o();
    L236:
        this.x = r53;
        T90((List) r3.element);
        int r54 = com.bytedance.android.live.room.api.panel.d.a;
        Room r55 = this.p1;
        if (r55 == null) goto L239;
        r6 = r55.getRoomId();
    L239:
        com.bytedance.android.live.room.api.panel.c r56 = com.bytedance.android.live.room.api.panel.d.b(null, r6);
        if (r56 == null) goto L242;
        r56.notifyPanelOpen(PanelName.LongPress, this.g1);
    L242:
        ha0(true);
        LivePanelsOptUtil.d(this.J);
        return;
    L235:
        r53 = null;
        goto L236
    L231:
        if (r51.intValue() == r31) goto L235;
    L223:
        if ((r50 instanceof u) == true) goto L225;
        r50 = null;
    L225:
        r53 = (u) r50;
        if (r53 != null) goto L236;
    L216:
        r49 = false;
        goto L217
    L219:
        r48 = null;
    L197:
        ActionsManager r57 = this.q;
        if (r57 == null) goto L203;
        int r58 = ActionsManager.g;
        y r59 = r57.s(false);
        if (r59 == null) goto L203;
        r41.add(r59);
    L161:
        pt1.a r60 = this.V;
        if (r60 == null) goto L188;
        IHostBusiness r61 = jc1.k.f(IHostBusiness.class);
        if (r61 != null) goto L166;
    L168:
        boolean r62 = false;
    L169:
        if (r62 == false) goto L188;
        Room r63 = r60.a;
        if (r63 != null) goto L173;
    L182:
        boolean r64 = false;
    L183:
        if (r64 == false) goto L188;
        ActionsManager r65 = this.q;
        if (r65 == null) goto L188;
        Intrinsics.checkNotNullParameter(r60, "shareFansHelper");
        r36.add(new z(r60, new com.bytedance.android.livesdk.dislike.action.y(r65), ItemType.SHARE_FANS));
        goto L188
    L173:
        if (r63.getRoomId() == 0) goto L182;
        Map r66 = r60.a.anchorAbMap;
        if (r66 == null) goto L178;
        String r67 = (String) r66.get("allow_shared_to_fans");
    L180:
        if (Intrinsics.areEqual(r67, "true") == false) goto L182;
        r64 = true;
        goto L183
    L178:
        r67 = null;
        goto L180
    L166:
        if (r61.isEnablePersonalRecommend() != true) goto L168;
        r62 = true;
        goto L169
    L255:
        return;
    L132:
        if (r30.intValue() != r31) goto L139;
        RoomAuthStatus.Style r68 = this.L;
        if (r68 != null) goto L136;
    L137:
        T90((List) r3.element);
        return;
    L136:
        if (r68.getUnableStyle() != 0) goto L139;
    L127:
        r29 = null;
    L119:
        r25 = (int) 0;
        goto L120
    L111:
        if (r10.contains("message") == true) goto L114;
        T90((List) r3.element);
        return;
    L62:
        r10 = null;
        goto L64
    L50:
        r5 = null;
    L11:
        if (t.b() == false) goto L16;
        ALogger.i("DislikeOptionsBottomDialog", "button area has two lines");
        ActionsManager r69 = this.q;
        if (r69 == null) goto L23;
        r0 = r69.w(r20);
    L24:
        RoomContext r70 = RoomContext.a.c(RoomContext.Companion, this.J, 0, 2);
        if (r70 == null) goto L29;
        com.bytedance.live.datacontext.n r71 = r70.getExternalConfigJudger();
        if (r71 == null) goto L29;
        final IExternalConfigJudger r72 = (IExternalConfigJudger) r71.getValue();
    L30:
        if (r72 == null) goto L33;
        if (r0 == null) goto L33;
        CollectionsKt.removeAll(r0, new DislikeOptionsBottomDialog$getOptionItems$1(r72));
    L33:
        if (r0 != null) goto L35;
        r0 = new ArrayList();
    L29:
        r72 = null;
    L23:
        r0 = null;
        goto L24
    L16:
        if (t.c() == false) goto L20;
        ALogger.i("DislikeOptionsBottomDialog", "one line with patch");
        ActionsManager r73 = this.q;
        if (r73 == null) goto L23;
        r0 = r73.v(r20);
        goto L24
    L20:
        ALogger.i("DislikeOptionsBottomDialog", "keep current state");
        ActionsManager r75 = this.q;
        if (r75 == null) goto L23;
        r0 = r75.m(r19, r20);
        goto L24
    }

    public final void onViewCreated(View r9, Bundle r10) {
        Intrinsics.checkNotNullParameter(r9, "view");
        this.Y = false;
        this.s = r9.findViewById(2131384813);
        this.t = (LinearLayout) r9.findViewById(2131381606);
        AnonymousClass1 r2 = new AnonymousClass1(this, r9);
        Room r3 = this.p1;
        String r11 = this.v1;
        if (r11 != null) goto L5;
        String r4 = "";
    L6:
        String r12 = this.x1;
        if (r12 != null) goto L9;
        String r5 = "";
    L10:
        this.q = new ActionsManager(r2, r3, r4, r5, this.J);
        LLPanelPreprocessor r13 = this.k0;
        if (r13 == null) goto L13;
        this.q = r13.b;
    L13:
        this.A = UIUtils.getScreenWidth(getContext());
        if (FoldScreenUtils.e() == true) goto L16;
    L18:
        this.B = UIUtils.getScreenHeight(getContext());
        this.V = new pt1.a(this.p1);
        User r0 = null;
        if (ea0() == true) goto L21;
        LiveFeedbackParams r7 = null;
    L22:
        if (r7 == null) goto L29;
        IHostLiveAd r14 = jc1.k.f(IHostLiveAd.class);
        if (r14 == null) goto L26;
        ILiveFeedbackManager r15 = r14.createFeedbackManager(r7);
    L27:
        this.R = r15;
        goto L29
    L26:
        r15 = null;
    L29:
        if (sr.a.getValue().booleanValue() == false) goto L34;
        Room r16 = this.p1;
        if (r16 == null) goto L33;
        r0 = r16.getOwner();
    L33:
        com.bytedance.android.live.room.api.follow.b.c(r0, "DislikeOptionsBottomDialog-onViewCreated-1", this.p1, new AnonymousClass4(this));
    L35:
        HashMap r17 = new HashMap();
        r17.put("layer_show_page", "live_detail");
        r17.put("event_page", "live_detail");
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_click_trans_layer", r17, new Object[]{am2.x.class, Room.class});
        IScreenRotateService r18 = jc1.k.f(IScreenRotateService.class);
        if (r18 == null) goto L39;
        r18.registerOnConfigChanged(this.J, new f(this));
        return;
    L39:
        return;
    L34:
        U90(false, null);
        goto L35
    L21:
        am2.n r19 = am2.n.f();
        r7 = new LiveFeedbackParams("long_press", r19.c(), r19.a(), r19.d(), "live_ad");
        goto L22
    L16:
        if (((CommunityFoldFixConfig) e81.b.getValue()).getEnableExperience() == false) goto L18;
        this.A = UtilityKotlinExtentionsKt.i(375);
        goto L18
    L9:
        r5 = r12;
        goto L10
    L5:
        r4 = r11;
        goto L6
    }

    public final LinearLayout.LayoutParams X90(int r6, int r7, int r8) {
        LinearLayout.LayoutParams r0 = new LinearLayout.LayoutParams(-2, -2);
        r0.gravity = 17;
        r0.topMargin = ((Number) this.f.getValue()).intValue();
        r0.bottomMargin = ((Number) this.g.getValue()).intValue();
        if (r6 >= 720) goto L10;
        r0.width = this.y;
        r0.height = this.z;
        if (r8 != 0) goto L7;
        int r9 = ((Number) this.l.getValue()).intValue();
    L8:
        r0.leftMargin = r9;
    L31:
        return r0;
    L7:
        r9 = ((Number) this.m.getValue()).intValue();
        goto L8
    L10:
        if (r7 != 1) goto L12;
        r0.width = 0;
        r0.height = ((Number) this.i.getValue()).intValue();
        r0.gravity = 8388611;
        r0.weight = 1.0f;
        r0.rightMargin = aa0();
    L25:
        if (r8 != 0) goto L28;
        r0.leftMargin = aa0();
        goto L31
    L28:
        if (r8 != (r7 - 1)) goto L30;
        r0.leftMargin = Z90();
        r0.rightMargin = aa0();
        goto L31
    L30:
        r0.leftMargin = Z90();
        goto L31
    L12:
        if (r7 == 2) goto L19;
        if (r7 == 3) goto L19;
        if (r7 == 4) goto L19;
        r0.width = this.y;
        r0.height = ((Number) this.j.getValue()).intValue();
        r0.rightMargin = 0;
    L19:
        if (t.b() == true) goto L21;
    L23:
        r0.width = 0;
        r0.height = ((Number) this.j.getValue()).intValue();
        r0.weight = 1.0f;
        goto L25
    L21:
        if (this.P <= 6) goto L23;
        r0.width = this.y;
        r0.height = ((Number) this.j.getValue()).intValue();
        r0.rightMargin = 0;
        goto L25
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        return r2.inflate(2131565624, r3, false);
    }

    public final void da0(u r17, LinearLayout.LayoutParams r18, Context r19, LinearLayout r20) {
        OptionDescItemLayoutV2 r3 = ca0().pollpollOptionDescItemLayoutV2();
        if (r3 != null) goto L5;
        r3 = new OptionDescItemLayoutV2(r19);
    L5:
        r3.setOnClickListener(new d(r17));
        r3.update(r17.c);
        OptionAction r4 = r17.b;
        if ((r4 instanceof NotifyAction) == false) goto L18;
        long r5 = this.K;
        if (r5 == 0) goto L17;
        ((NotifyAction) r4).f = r5;
        int r8 = bn2.k.a(r5);
        if (this.H == true) goto L16;
        Long r6 = Long.valueOf(this.K);
        Room r7 = this.p1;
        if (r7 == null) goto L14;
        String r9 = r7.getOwnerUserIdString();
    L15:
        bn2.k.c(r6, r9, "long_press", this.H);
        this.H = true;
        goto L16
    L14:
        r9 = null;
    L16:
        nt1.c r10 = r17.c;
        r3.update(new nt1.c(r8, r10.b, r10.c, r10.d, false, false, null, 112));
    L17:
        this.F = r3;
        this.G = (NotifyAction) r17.b;
    L18:
        if (r20 == null) goto L21;
        r20.addView(r3, r18);
    L21:
        if (this.X == false) goto L26;
        OptionAction r1 = r17.b;
        if (r1.d == false) goto L27;
        OptionAction.e(r1);
        return;
    L27:
        return;
    }

    public DislikeOptionsBottomDialog(Room r1, String r2, String r3, Boolean r4, Bundle r5) {
        this.p1 = r1;
        this.v1 = r2;
        this.x1 = r3;
        this.d = LazyKt.lazy(DislikeOptionsBottomDialog$SOLID_SIDE_MARGIN$2.INSTANCE);
        this.e = LazyKt.lazy(DislikeOptionsBottomDialog$SOLID_MID_MARGIN$2.INSTANCE);
        this.f = LazyKt.lazy(DislikeOptionsBottomDialog$SOLID_BUTTON_TOP_MARGIN$2.INSTANCE);
        this.g = LazyKt.lazy(new DislikeOptionsBottomDialog$SOLID_BUTTON_BOTTOM_MARGIN$2(this));
        this.h = LazyKt.lazy(DislikeOptionsBottomDialog$SOLID_BUTTON_BOTTOM_MARGIN_EMPTY$2.INSTANCE);
        this.i = LazyKt.lazy(DislikeOptionsBottomDialog$SINGLE_BUTTON_HEIGHT$2.INSTANCE);
        this.j = LazyKt.lazy(DislikeOptionsBottomDialog$RECT_BUTTON_DEFAULT_HEIGHT$2.INSTANCE);
        this.k = LazyKt.lazy(DislikeOptionsBottomDialog$NARROW_SCREEN_RECT_BUTTON_WIDTH_HEIGHT$2.INSTANCE);
        this.l = LazyKt.lazy(new DislikeOptionsBottomDialog$NARROW_SCREEN_LEFT_MARGIN$2(this));
        this.m = LazyKt.lazy(new DislikeOptionsBottomDialog$NARROW_SCREEN_MID_MARGIN$2(this));
        this.n = LazyKt.lazy(new DislikeOptionsBottomDialog$SCROLL_MARGIN_BOTTOM_SOLID$2(this));
        this.o = LazyKt.lazy(DislikeOptionsBottomDialog$HEIGHT_OFFSET$2.INSTANCE);
        this.p = LazyKt.lazy(DislikeOptionsBottomDialog$HEIGHT_ITEM$2.INSTANCE);
        if (r1 == null) goto L9;
        User r6 = r1.getOwner();
        if (r6 == null) goto L9;
        FollowInfo r7 = r6.getFollowInfo();
        if (r7 == null) goto L9;
        long r8 = r7.getPushStatus();
    L10:
        this.K = r8;
        boolean r9 = true;
        this.Q = 1;
        this.S = new JSONArray();
        this.T = new JSONArray();
        this.U = new ArrayList();
        this.b1 = LazyKt.lazy(new DislikeOptionsBottomDialog$viewRecycler$2(this));
        this.g1 = new g(this);
        setNoTitleAndCancelOutside(true);
        if (r5 == null) goto L31;
        Serializable r10 = r5.getSerializable("extra_params_live_ad_enter_room");
        if ((r10 instanceof HashMap) == true) goto L16;
        r10 = null;
    L16:
        HashMap r11 = (HashMap) r10;
        if (r11 == null) goto L31;
        String r12 = (String) r11.get("category_detail");
        String r13 = (String) r11.get("new_filter_words");
        Result.Companion r14 = Result.Companion;     // Catch: Throwable -> L28
        if (TextUtils.isEmpty(r12) == true) goto L24;
        this.S = new JSONArray(r12);     // Catch: Throwable -> L28
    L24:
        if (TextUtils.isEmpty(r13) == true) goto L26;
        this.T = new JSONArray(r13);     // Catch: Throwable -> L28
    L26:
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L28
    L28:
        th = move-exception;
        Result.Companion r15 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    L31:
        if (((CommunityFoldFixConfig) e81.b.getValue()).getEnableExperience() == true) goto L33;
    L35:
        r9 = false;
    L36:
        this.h1 = r9;
        this.k1 = r9;
        return;
    L33:
        if (FoldScreenUtils.f() == false) goto L35;
    L9:
        r8 = 2;
        goto L10
    }
}
