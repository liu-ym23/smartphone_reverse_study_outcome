package com.bytedance.android.livesdk.interactivity.publicscreen.selectedmessage.view.aiagent;

import am2.x;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatDialog;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.a1;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdk.chatroom.MiddlewareRoomContext;
import com.bytedance.android.livesdk.chatroom.widget.LiveMessageRecyclerView;
import com.bytedance.android.livesdk.chatroom.widget.SpaceItemDecoration;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.selectedmessage.SelectedMsgABHelper;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.PublicScreenStyleHelper;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.p;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.q;
import com.bytedance.android.livesdk.interactivity.common.accessibility.MessageRvAccessibilityDelegate;
import com.bytedance.android.livesdk.interactivity.publicscreen.selectedmessage.presenter.SelectedMsgViewManager;
import com.bytedance.android.livesdk.interactivity.publicscreen.selectedmessage.strategy.SelectedMsgBuffer;
import com.bytedance.android.livesdk.interactivity.publicscreen.selectedmessage.strategy.SelectedMsgListAdapter;
import com.bytedance.android.livesdk.interactivity.publicscreen.selectedmessage.view.PSSelectedMessageDialog;
import com.bytedance.android.livesdk.interactivity.publicscreen.selectedmessage.view.SelectedMsgLayoutManager;
import com.bytedance.android.livesdk.interactivity.publicscreen.selectedmessage.view.aiagent.quickability.PaddingItemDecoration;
import com.bytedance.android.livesdk.interactivity.publicscreen.selectedmessage.view.aiagent.quickability.QuickAbilityAdapter;
import com.bytedance.android.livesdk.interactivity.utils.PublicScreenMessageMonitor;
import com.bytedance.android.livesdk.interactivity.utils.t;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.android.livesdk.schema.interfaces.IBaseLiveActionHandler;
import com.bytedance.android.livesdk.utils.x0;
import com.bytedance.android.livesdkapi.depend.model.live.AIPublicScreenContainer;
import com.bytedance.android.livesdkapi.depend.model.live.Ability;
import com.bytedance.android.livesdkapi.depend.model.live.IAbility;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.larus.apm.impl.protector.RunnableProtector;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.lang.ref.WeakReference;
import java.text.SimpleDateFormat;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class AiAgentPSSelectedMsgView extends FrameLayout implements com.bytedance.android.livesdk.interactivity.publicscreen.selectedmessage.presenter.a.InterfaceC0191a, ha2.a {
    public static final int P = 0;
    public static final int Q = 0;
    public static final int R = 0;
    public static final int S = 0;
    public static final int T = 0;
    public static final int U = 0;
    public static final int V = 0;
    public static final int W = 0;
    public AiAgentViewStateHolder A;
    public List<? extends View> B;
    public List<? extends View> C;
    public List<? extends View> D;
    public List<? extends View> E;
    public List<? extends View> F;
    public List<? extends View> G;
    public List<? extends View> H;
    public List<? extends View> I;
    public List<? extends View> J;
    public ia2.e K;
    public final e52.a L;
    public final DataCenter M;
    public final CompositeDisposable N;
    public final fa2.a O;
    public boolean a;
    public boolean b;
    public boolean c;
    public boolean d;
    public boolean e;
    public boolean f;
    public final LiveMessageRecyclerView g;
    public final View h;
    public final View i;
    public final SelectedMsgLayoutManager j;
    public final SpaceItemDecoration k;
    public final Handler l;
    public final Function1<com.bytedance.android.livesdk.interactivity.api.entity.f<?>, Map<String, String>> m;
    public final c n;
    public final SelectedMsgListAdapter o;
    public final h p;
    public final com.bytedance.android.livesdk.interactivity.publicscreen.selectedmessage.presenter.a q;
    public View r;
    public HSImageView s;
    public TextView t;
    public FrameLayout u;
    public FrameLayout v;
    public ImageView w;
    public FrameLayout x;
    public TextView y;
    public ImageView z;

    public static final class UIParams {
        public static final Lazy c = null;
        public static final Lazy d = null;
        public static final a e = null;
        public final int a;
        public final int b;

        public static final class a {
            public a() {
            }
        }

        static {
            e = new a();
            c = LazyKt.lazy(AiAgentPSSelectedMsgView$UIParams$Companion$paramsMap$2.INSTANCE);
            d = LazyKt.lazy(AiAgentPSSelectedMsgView$UIParams$Companion$aiParamsMap$2.INSTANCE);
        }

        public UIParams(float r1, float r2) {
            this.a = s1.f(r1);
            this.b = s1.f(r2);
        }
    }

    public static final class a {
    }

    public static final class b implements Runnable {
        public final /* synthetic */ AiAgentPSSelectedMsgView a;
        public final /* synthetic */ String b;

        public b(AiAgentPSSelectedMsgView r1, String r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            ia2.e r0 = this.a.K;     // Catch: Throwable -> L6
            if (r0 == null) goto L9;
            r0.b(String.valueOf(this.b));     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }
    }

    static {
        P = s1.f(54.0f);
        Q = s1.f(78.0f);
        R = s1.f(40.0f);
        S = s1.f(11.0f);
        T = s1.f(10.0f);
        U = s1.f(4.0f);
        V = s1.f(6.0f);
        W = s1.f(10.0f);
    }

    private final ia2.e getQuickAbilityViewManager() {
        ia2.e r0 = this.K;
        if (r0 != null) goto L10;
        r0 = new ia2.e(this.M, this.n, this.N);
        this.K = r0;
        FrameLayout r1 = this.v;
        AiAgentPSSelectedMsgView$getQuickAbilityViewManager$1$1 r2 = new AiAgentPSSelectedMsgView$getQuickAbilityViewManager$1$1(this);
        Intrinsics.checkNotNullParameter(r2, "onRecyclerViewSelfClick");
        if (r1 == null) goto L10;
        Context r3 = r1.getContext();
        if (r3 == null) goto L10;
        r0.a = true;
        ((ArrayList) r0.c).clear();
        RecyclerView r5 = new RecyclerView(r3);
        r5.setHorizontalFadingEdgeEnabled(true);
        r5.setFadingEdgeLength(UtilityKotlinExtentionsKt.i(10));
        r5.setOnTouchListener(new ia2.d(new GestureDetector(r3, new ia2.c(r2))));
        LinearLayoutManager r4 = new LinearLayoutManager(r3);
        r4.setOrientation(0);
        Unit r6 = Unit.INSTANCE;
        r5.setLayoutManager(r4);
        r5.setAdapter(new QuickAbilityAdapter(r0, r0.c));
        r5.addItemDecoration(new PaddingItemDecoration());
        r0.b = r5;
        r1.addView(r5, new ViewGroup.LayoutParams(-1, -2));
    L10:
        return r0;
    }

    public final void i() {
        if (fa2.b.a(this.O) == false) goto L47;
        AIPublicScreenContainer r0 = this.O.getAiPublicScreenContainer();
        List r1 = null;
        if (r0 == null) goto L7;
        py.k r2 = r0.getIcon();
    L8:
        ImageLoader.bindImage(this.s, r2);
        TextView r3 = this.t;
        if (r3 == null) goto L14;
        if (r0 == null) goto L12;
        String r4 = r0.getWelcomeTip();
    L13:
        r3.setText(r4);
        goto L14
    L12:
        r4 = null;
    L14:
        TextView r5 = this.y;
        if (r5 == null) goto L20;
        if (r0 == null) goto L18;
        String r6 = r0.getNickName();
    L19:
        r5.setText(r6);
        goto L20
    L18:
        r6 = null;
    L20:
        ia2.e r7 = getQuickAbilityViewManager();
        AIPublicScreenContainer r8 = this.O.getAiPublicScreenContainer();
        if (r8 == null) goto L23;
        r1 = r8.getAbilities();
    L23:
        ((ArrayList) r7.c).clear();
        if (r1 == null) goto L34;
        List r9 = r1;
        ArrayList r10 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r9, 10));
        Iterator r11 = r9.iterator();
    L27:
        if (r11.hasNext() == false) goto L33;
        Ability r13 = (IAbility) r11.next();
        if (r13 == null) goto L32;
        r10.add(new ia2.b(r13, r7.a));
        goto L27
    L32:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdkapi.depend.model.live.Ability");
    L33:
        ((ArrayList) r7.c).addAll(r10);
    L34:
        RecyclerView r14 = r7.b;
        if (r14 == null) goto L40;
        RecyclerView.Adapter r15 = r14.getAdapter();
        if (r15 == null) goto L40;
        r15.notifyDataSetChanged();
    L40:
        if (((ArrayList) r7.c).size() <= 0) goto L48;
        RecyclerView r16 = r7.b;
        if (r16 == null) goto L49;
        r16.scrollToPosition(0);
        return;
    L49:
        return;
    L48:
        return;
    L7:
        r2 = null;
        goto L8
    }

    public final boolean m() {
        List<? extends com.bytedance.android.livesdk.interactivity.api.entity.f<?>> r0 = this.o.b;
        if (r0 != null) goto L7;
        return true;
    L7:
        return r0.isEmpty();
    }

    @Override // ha2.a
    public final void onClear() {
        com.bytedance.android.livesdk.interactivity.publicscreen.selectedmessage.presenter.a r0 = this.q;
        ((ArrayList) r0.e).clear();
        r0.f.i();
        SelectedMsgBuffer r1 = r0.c;
        ((ArrayDeque) r1.b).clear();
        ((PriorityQueue) r1.c).clear();
        AiAgentViewStateHolder r2 = this.A;
        if (r2 == null) goto L9;
        ga2.d.a("AiAgentViewStateHolder onClear");
        Disposable r3 = r2.c;
        if (r3 == null) goto L7;
        r3.dispose();
    L7:
        r2.c = null;
        return;
    }

    public final void t() {
        AiAgentViewStateHolder r0 = this.A;
        if (r0 == null) goto L5;
        AiAgentViewState r1 = r0.a;
    L6:
        if (r1 == null) goto L41;
        int r2 = com.bytedance.android.livesdk.interactivity.publicscreen.selectedmessage.view.aiagent.b.d[r1.ordinal()];
        if (r2 == 1) goto L30;
        if (r2 != 2) goto L13;
        HSImageView r3 = this.s;
        if (r3 == null) goto L28;
        a1.o(r3, S);
    L28:
        ViewGroup.LayoutParams r4 = getLayoutParams();
        r4.height = Q;
        getLayoutParams().width = -1;
        setLayoutParams(getLayoutParams());
        return;
    L13:
        if (r2 != 3) goto L15;
        HSImageView r5 = this.s;
        if (r5 == null) goto L24;
        a1.o(r5, T);
    L24:
        ViewGroup.LayoutParams r6 = getLayoutParams();
        r6.height = R;
        getLayoutParams().width = -2;
        setLayoutParams(getLayoutParams());
        return;
    L15:
        if (r2 != 4) goto L42;
        int r7 = PublicScreenStyleHelper.a();
        UIParams.e.getClass();
        UIParams r8 = (UIParams) ((Map) UIParams.d.getValue()).get(Integer.valueOf(r7));
        if (r8 != null) goto L20;
        r8 = new UIParams(130.0f, 0.0f);
    L20:
        ViewGroup.LayoutParams r9 = getLayoutParams();
        r9.height = r8.a;
        getLayoutParams().width = -1;
        setLayoutParams(getLayoutParams());
        LiveMessageRecyclerView r10 = this.g;
        int r11 = r8.b;
        r10.setPadding(0, r11, 0, r11);
        return;
    L42:
        return;
    L30:
        if (m() == false) goto L32;
        UtilityKotlinExtentionsKt.t(this.g);
        UtilityKotlinExtentionsKt.w(this.i);
        ViewGroup.LayoutParams r13 = getLayoutParams();
        r13.height = P;
        getLayoutParams().width = -1;
        setLayoutParams(getLayoutParams());
        return;
    L32:
        UtilityKotlinExtentionsKt.w(this.g);
        UtilityKotlinExtentionsKt.t(this.i);
        int r14 = PublicScreenStyleHelper.a();
        UIParams.e.getClass();
        UIParams r15 = (UIParams) ((Map) UIParams.c.getValue()).get(Integer.valueOf(r14));
        if (r15 != null) goto L35;
        r15 = new UIParams(94.0f, 4.0f);
    L35:
        ViewGroup.LayoutParams r16 = getLayoutParams();
        r16.height = r15.a;
        getLayoutParams().width = -1;
        setLayoutParams(getLayoutParams());
        LiveMessageRecyclerView r17 = this.g;
        int r18 = r15.b;
        r17.setPadding(0, r18, 0, r18);
        return;
    L41:
        return;
    L5:
        r1 = null;
        goto L6
    }

    @Override // ha2.a
    public final boolean d() {
        if (getVisibility() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // ha2.a
    public fa2.c getMessageHandler() {
        return this.q;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r5) {
        if (r5 == null) goto L18;
        if (r5.getAction() != 0) goto L18;
        AiAgentViewStateHolder r0 = this.A;
        AiAgentViewState r1 = null;
        if (r0 == null) goto L8;
        AiAgentViewState r2 = r0.a;
    L10:
        if (r2 == AiAgentViewState.AI_AGENT_EMPTY) goto L15;
        if (r0 == null) goto L14;
        r1 = r0.a;
    L14:
        if (r1 != AiAgentViewState.AI_AGENT_MESSAGE) goto L18;
    L15:
        if (r0 == null) goto L18;
        r0.c();
        goto L18
    L8:
        r2 = null;
    L18:
        return super.dispatchTouchEvent(r5);
    }

    public final void k(boolean r2) {
        if (r2 == false) goto L13;
        HSImageView r3 = this.s;
        if (r3 == null) goto L6;
        UtilityKotlinExtentionsKt.t(r3);
    L6:
        TextView r4 = this.t;
        if (r4 == null) goto L9;
        a1.m(r4, W);
    L9:
        TextView r5 = this.y;
        if (r5 == null) goto L37;
        a1.m(r5, W);
        return;
    L37:
        return;
    L13:
        AIPublicScreenContainer r6 = this.O.getAiPublicScreenContainer();
        if (r6 == null) goto L16;
        py.k r7 = r6.getIcon();
    L17:
        if (r7 != null) goto L27;
        HSImageView r8 = this.s;
        if (r8 == null) goto L21;
        UtilityKotlinExtentionsKt.t(r8);
    L21:
        TextView r9 = this.t;
        if (r9 == null) goto L24;
        a1.m(r9, W);
    L24:
        TextView r10 = this.y;
        if (r10 == null) goto L38;
        a1.m(r10, W);
        return;
    L38:
        return;
    L27:
        HSImageView r11 = this.s;
        if (r11 == null) goto L30;
        UtilityKotlinExtentionsKt.w(r11);
    L30:
        TextView r13 = this.t;
        if (r13 == null) goto L33;
        a1.m(r13, V);
    L33:
        TextView r14 = this.y;
        if (r14 == null) goto L40;
        a1.m(r14, V);
        return;
    L40:
        return;
    L16:
        r7 = null;
        goto L17
    }

    public final String l(boolean r2) {
        if (this.O.c() == true) goto L5;
        return "normal";
    L5:
        if (r2 == true) goto L7;
        return "ai";
    L7:
        if (this.O.b() == false) goto L10;
        return "ai_assistant#2";
    L10:
        if (this.O.a() == true) goto L17;
        return "ai";
    L17:
        return "ai_assistant#1";
    }

    public final void n(Map<String, String> r6) {
        AiAgentViewState r2 = null;
        if (this.O.b() == false) goto L28;
        if (PadConfigUtils.c() == true) goto L7;
    L11:
        Context r0 = getContext();
        AIPublicScreenContainer r3 = this.O.getAiPublicScreenContainer();
        if (r3 == null) goto L21;
        String r4 = r3.getAreaSchema();
        if (r4 == null) goto L21;
        if (r4.length() <= 0) goto L18;
        boolean r5 = true;
    L19:
        if (r5 == false) goto L21;
    L22:
        if (r0 == null) goto L32;
        if (r4 == null) goto L32;
        IBaseLiveActionHandler r7 = jc1.k.f(IBaseLiveActionHandler.class);
        if (r7 == null) goto L32;
        r7.handle(r0, r4);
    L32:
        LinkedHashMap r1 = new LinkedHashMap();
        AiAgentViewStateHolder r8 = this.A;
        if (r8 == null) goto L35;
        r2 = r8.a;
    L35:
        if (r2 == null) goto L43;
        int r9 = com.bytedance.android.livesdk.interactivity.publicscreen.selectedmessage.view.aiagent.b.c[r2.ordinal()];
        if (r9 != 1) goto L40;
        String r10 = "expand#0";
    L47:
        r1.put("show_type", r10);
        r1.put("msg_show_area", "ai_assistant");
        if (r6 == null) goto L52;
        String r11 = r6.get("msg_id");
        if (r11 == null) goto L52;
        r1.put("msg_id", r11);
    L52:
        if (r6 == null) goto L56;
        String r13 = r6.get("msg_type");
        if (r13 == null) goto L56;
        r1.put("msg_type", r13);
    L56:
        Boolean r14 = p.a;
        p.c("action_sheet", r1, this.M);
        return;
    L40:
        if (r9 != 2) goto L42;
        r10 = "expand#1";
        goto L47
    L42:
        if (r9 != 3) goto L43;
        r10 = "collapse";
    L43:
        r10 = BuildConfig.FLAVOR;
        goto L47
    L18:
        r5 = false;
    L21:
        r4 = null;
        goto L22
    L7:
        if (((Boolean) SelectedMsgABHelper.e.getValue()).booleanValue() == false) goto L11;
        Context r15 = getContext();
        if (r15 == null) goto L32;
        o(r15);
        goto L32
    L28:
        if (this.O.a() == false) goto L58;
        Context r16 = getContext();
        if (r16 == null) goto L32;
        o(r16);
        goto L32
    }

    public final void o(Context r6) {
        LinkedHashMap r0 = new LinkedHashMap();
        r0.put("click_type", "msg_more");
        r0.put("selected_mode_type", l(false));
        j0.l().sendLog("livesdk_selected_message_layer_click", r0, new Object[]{IRoom.class, x.class});
        AppCompatDialog r1 = new PSSelectedMessageDialog(r6, this.M, this.N, this.O);
        if (DialogLancet.shouldBlockDialogShow(r1) == false) goto L9;
        DialogLancet.handleBlockedDialogShow(r1);
        return;
    L9:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L8
    L6:
        DialogLancet.beforeDialogShow(r1);
        r1.show();
        DialogLancet.afterDialogShow(r1);
    }

    @Override // ha2.a
    public void onEvent(o42.b r3) {
        Intrinsics.checkNotNullParameter(r3, "event");
        t();
        SelectedMsgListAdapter r4 = this.o;
        e52.a r0 = this.L;
        r4.getClass();
        Intrinsics.checkNotNullParameter(r0, "textMessageConfig");
        r4.c = r0;
        int r1 = q.e(true, true);
        this.o.d = q.a(this.L, true, true);
        this.k.a = r1;
        Iterator r5 = ((ArrayList) this.q.e).iterator();
    L4:
        if (r5.hasNext() == false) goto L6;
        ((com.bytedance.android.livesdk.interactivity.api.entity.f) r5.next()).F = null;
        goto L4
    L6:
        this.o.notifyDataSetChanged();
    }

    @Override // com.bytedance.android.livesdk.interactivity.publicscreen.selectedmessage.presenter.a.InterfaceC0191a
    public final void pa(int r3) {
        this.o.notifyItemRangeRemoved(0, r3);
        if (this.A == null) goto L6;
        ga2.d.a("AiAgentViewStateHolder messageRemove");
    L6:
        if (m() == false) goto L9;
        t();
        return;
    }

    public final boolean s(boolean r4) {
        if (this.a == false) goto L5;
    L7:
        boolean r0 = false;
    L8:
        if (r0 == true) goto L12;
        if (this.c == true) goto L12;
    L17:
        return false;
    L12:
        if (this.o.getItemCount() <= 0) goto L17;
        if (r4 == false) goto L15;
        this.c = true;
        this.g.smoothScrollToPosition(this.o.getItemCount() - 1);
    L16:
        return true;
    L15:
        this.g.scrollToPosition(this.o.getItemCount() - 1);
        goto L16
    L5:
        if (this.b == true) goto L7;
        r0 = true;
        goto L8
    }

    public static final void h(AiAgentPSSelectedMsgView r7, AiAgentViewState r8) {
        r7.getClass();
        int r0 = com.bytedance.android.livesdk.interactivity.publicscreen.selectedmessage.view.aiagent.b.a[r8.ordinal()];
        if (r0 == 1) goto L26;
        if (r0 == 2) goto L20;
        if (r0 == 3) goto L14;
        if (r0 != 4) goto L32;
        List<? extends View> r1 = r7.J;
        if (r1 != null) goto L33;
        List<? extends View> r2 = r7.B;
        List<? extends View> r5 = r7.F;
        if (r2 == null) goto L32;
        if (r5 == null) goto L32;
        r1 = CollectionsKt.minus(r2, r5);
        r7.J = r1;
    L33:
        if (r1 == null) goto L40;
        Iterator<T> r3 = r1.iterator();
    L36:
        if (r3.hasNext() == false) goto L40;
        View r6 = (View) r3.next();
        if (r6 == null) goto L36;
        UtilityKotlinExtentionsKt.t(r6);
    L40:
        int r4 = com.bytedance.android.livesdk.interactivity.publicscreen.selectedmessage.view.aiagent.b.b[r8.ordinal()];
        if (r4 != 1) goto L43;
        List<? extends View> r9 = r7.C;
        if (r9 == null) goto L82;
        Iterator<T> r10 = r9.iterator();
    L78:
        if (r10.hasNext() == false) goto L82;
        View r11 = (View) r10.next();
        if (r11 == null) goto L78;
        UtilityKotlinExtentionsKt.w(r11);
    L82:
        p(r7.g, r7);
        r7.setBackgroundResource(2131249929);
        return;
    L43:
        if (r4 == 2) goto L65;
        if (r4 == 3) goto L56;
        if (r4 == 4) goto L47;
        int r13 = ga2.d.a;
        ga2.d.a("changeViewsState, ignored state: " + r8.desc());
        return;
    L47:
        List<? extends View> r14 = r7.F;
        if (r14 == null) goto L55;
        Iterator<T> r15 = r14.iterator();
    L51:
        if (r15.hasNext() == false) goto L55;
        View r16 = (View) r15.next();
        if (r16 == null) goto L51;
        UtilityKotlinExtentionsKt.w(r16);
    L55:
        p(r7.g, r7.x);
        r7.setBackgroundResource(2131249930);
        r7.k(false);
        return;
    L56:
        List<? extends View> r17 = r7.E;
        if (r17 == null) goto L64;
        Iterator<T> r18 = r17.iterator();
    L60:
        if (r18.hasNext() == false) goto L64;
        View r19 = (View) r18.next();
        if (r19 == null) goto L60;
        UtilityKotlinExtentionsKt.w(r19);
    L64:
        p(r7.g, r7.x);
        r7.setBackgroundResource(2131249930);
        r7.getQuickAbilityViewManager().a(r7.u, false);
        r7.k(true);
        return;
    L65:
        List<? extends View> r20 = r7.D;
        if (r20 == null) goto L73;
        Iterator<T> r21 = r20.iterator();
    L69:
        if (r21.hasNext() == false) goto L73;
        View r23 = (View) r21.next();
        if (r23 == null) goto L69;
        UtilityKotlinExtentionsKt.w(r23);
    L73:
        p(r7.g, r7.x);
        r7.setBackgroundResource(2131249930);
        r7.getQuickAbilityViewManager().a(r7.v, true);
        r7.k(false);
        return;
    L32:
        r1 = null;
        goto L33
    L14:
        r1 = r7.I;
        if (r1 != null) goto L33;
        List<? extends View> r24 = r7.B;
        List<? extends View> r25 = r7.E;
        if (r24 == null) goto L32;
        if (r25 == null) goto L32;
        r1 = CollectionsKt.minus(r24, r25);
        r7.I = r1;
        goto L33
    L20:
        r1 = r7.H;
        if (r1 != null) goto L33;
        List<? extends View> r26 = r7.B;
        List<? extends View> r27 = r7.D;
        if (r26 == null) goto L32;
        if (r27 == null) goto L32;
        r1 = CollectionsKt.minus(r26, r27);
        r7.H = r1;
        goto L33
    L26:
        r1 = r7.G;
        if (r1 != null) goto L33;
        List<? extends View> r28 = r7.B;
        List<? extends View> r29 = r7.C;
        if (r28 == null) goto L32;
        if (r29 == null) goto L32;
        r1 = CollectionsKt.minus(r28, r29);
        r7.G = r1;
        goto L33
    }

    public static void p(LiveMessageRecyclerView r1, ViewGroup r2) {
        if (r2 != null) goto L5;
        return;
    L5:
        if (Intrinsics.areEqual(UtilityKotlinExtentionsKt.p(r1), r2) == false) goto L7;
        return;
    L7:
        UtilityKotlinExtentionsKt.q(r1);
        r2.addView(r1, 0);
    }

    @Override // com.bytedance.android.livesdk.interactivity.publicscreen.selectedmessage.presenter.a.InterfaceC0191a
    public final void DI(int r2, long r3) {
        this.j.p(r2);
        this.j.b = (int) r3;
    }

    @Override // ha2.a
    public final void f(String r7, boolean r8) {
        if (r8 == false) goto L17;
        i();
        AiAgentViewStateHolder r1 = this.A;
        if (r1 == null) goto L17;
        ga2.d.a("AiAgentViewStateHolder modeChange");
        if (r1.e.a() == false) goto L12;
        r1.d();
        if (r1.e.b() == false) goto L11;
        AiAgentViewState r2 = AiAgentViewState.AI_AGENT_EMPTY;
    L16:
        r1.a(r2, AiAgentViewChangeReason.MODE_CHANGE);
        goto L17
    L11:
        r2 = AiAgentViewState.AI_AGENT_MESSAGE;
        goto L16
    L12:
        Disposable r3 = r1.c;
        if (r3 == null) goto L15;
        r3.dispose();
    L15:
        r1.c = null;
        r2 = AiAgentViewState.NO_OR_OLD_AI;
    L17:
        com.bytedance.android.livesdk.interactivity.publicscreen.selectedmessage.presenter.a r4 = this.q;
        int r5 = SelectedMsgABHelper.b().cacheNumAfterSettingChange;
        SelectedMsgBuffer r6 = r4.c;
        if (r8 == false) goto L20;
        ((ArrayDeque) r6.b).clear();
        ((PriorityQueue) r6.c).clear();
        int r9 = ga2.d.a;
        Intrinsics.checkNotNullParameter("ai mode change, clear all message", "msg");
        ALogger.i("PSSelectedMessage", "ai mode change, clear all message");
    L26:
        f2.c(r7, 0);
        ha2.a.C0234a.a(this, true, null, 14);
        return;
    L20:
        int r10 = ((ArrayDeque) r6.b).size() - RangesKt.coerceAtMost(r5, ((ArrayDeque) r6.b).size());
        if (r10 <= 0) goto L25;
        int r11 = 0;
    L23:
        if (r11 >= r10) goto L25;
        ((ArrayDeque) r6.b).poll();
        r11 = r11 + 1;
    L25:
        int r13 = ga2.d.a;
        ALogger.i("PSSelectedMessage", "buffer message batch clear. clear num: " + r10);
        goto L26
    }

    @Override // com.bytedance.android.livesdk.interactivity.publicscreen.selectedmessage.presenter.a.InterfaceC0191a
    public final void fc(int r7, int r8) {
        this.o.notifyItemRangeInserted(r7, r8);
        if (r8 <= 0) goto L11;
        s(true);
        AiAgentViewStateHolder r1 = this.A;
        if (r1 == null) goto L11;
        ga2.d.a("AiAgentViewStateHolder messageInsert");
        AiAgentViewState r3 = AiAgentViewState.NO_OR_OLD_AI;
        AiAgentViewState r0 = AiAgentViewState.AI_AGENT_MESSAGE;
        r1.b(new AiAgentViewState[]{r3, AiAgentViewState.AI_AGENT_EMPTY, r0, AiAgentViewState.AI_AGENT_FOLD});
        r1.c();
        AiAgentViewState r2 = r1.a;
        if (r2 == r3) goto L11;
        if (r2 == r0) goto L11;
        r1.a(r0, AiAgentViewChangeReason.MESSAGE_INSERT);
    L11:
        if (r7 != 0) goto L15;
        if (r8 <= 0) goto L16;
        t();
        return;
    L16:
        return;
    }

    @Override // ha2.a
    public final void g(String r6, String r7) {
        Pair[] r0 = new Pair[3];
        r0[0] = TuplesKt.to("selected_mode_type", l(true));
        if (r6 != null) goto L5;
        r6 = BuildConfig.FLAVOR;
    L5:
        r0[1] = TuplesKt.to("show_from", r6);
        if (r7 != null) goto L8;
        r7 = BuildConfig.FLAVOR;
    L8:
        r0[2] = TuplesKt.to("show_type", r7);
        Map r8 = MapsKt.mutableMapOf(r0);
        int r9 = com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.b.a;
        ia2.e r10 = this.K;
        if (r10 == null) goto L13;
        WeakReference<DataCenter> r11 = r10.getDataCenter();
        if (r11 == null) goto L13;
        DataCenter r13 = r11.get();
    L14:
        com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.b.a(r8, r13);
        j0.l().sendLog("livesdk_selected_message_layer_show", r8, new Object[]{IRoom.class});
        return;
    L13:
        r13 = null;
        goto L14
    }

    @Override // ha2.a
    public final void a(boolean r3, String r4, boolean r5) {
        int r0 = ga2.d.a;
        ga2.d.a("setInSupportedLinkState, inSupportedScene: " + r3 + ", autoOpen: " + r5);
        if (r5 == false) goto L5;
        this.f = true;
        i();
    L5:
        this.d = r3;
        j(r4, "live_type_change", "new_open");
    }

    @Override // ha2.a
    public final void c(boolean r3, String r4, boolean r5) {
        int r0 = ga2.d.a;
        ga2.d.a("setInSupportedAudioScene, inSupportedAudioScene: " + r3 + ", autoOpen: " + r5);
        if (r5 == false) goto L5;
        this.f = true;
        i();
    L5:
        j(r4, "audio_scene_change", "new_open");
    }

    @Override // ha2.a
    public final void e(boolean r3, String r4, boolean r5) {
        int r0 = ga2.d.a;
        ga2.d.a("setInSupportedVideoTalkRoomScene, inSupportedScene: " + r3 + ", autoOpen: " + r5);
        if (r5 == false) goto L5;
        this.f = true;
        i();
    L5:
        this.e = r3;
        j(r4, "live_type_change", "new_open");
    }

    public final boolean j(String r6, String r7, String r8) {
        MiddlewareRoomContext r0 = MiddlewareRoomContext.a.c(MiddlewareRoomContext.Companion, this.M, 0, 2);
        if (r0 == null) goto L7;
        com.bytedance.live.datacontext.i r1 = r0.getLiveMode();
        if (r1 == null) goto L7;
        LiveMode r2 = (LiveMode) r1.getValue();
    L9:
        if (r2 != LiveMode.VIDEO) goto L18;
        if (this.f == true) goto L13;
    L24:
        boolean r3 = false;
    L26:
        if (r3 != d()) goto L28;
        return false;
    L28:
        if (r3 == false) goto L50;
        UtilityKotlinExtentionsKt.w(this);
        this.M.put("cmd_selected_message_change_visible_state", Boolean.TRUE);
        g(r7, r8);
        com.bytedance.android.livesdk.interactivity.publicscreen.selectedmessage.presenter.a r4 = this.q;
        r4.f.f();
        r4.b = true;
        SimpleDateFormat r5 = PublicScreenMessageMonitor.a;
        ((t) PublicScreenMessageMonitor.v.getValue()).d = true;
        AiAgentViewStateHolder r9 = this.A;
        if (r9 == null) goto L39;
        ga2.d.a("AiAgentViewStateHolder containerShow");
        if (r9.e.a() == false) goto L37;
        r9.d();
        if (r9.e.b() == false) goto L36;
        AiAgentViewState r10 = AiAgentViewState.AI_AGENT_EMPTY;
    L38:
        r9.a(r10, AiAgentViewChangeReason.CONTAINER_SHOW);
        goto L39
    L36:
        r10 = AiAgentViewState.AI_AGENT_MESSAGE;
        goto L38
    L37:
        r10 = AiAgentViewState.NO_OR_OLD_AI;
    L39:
        ALogger.i("QuickAbilityViewManager", "calculateVisibility，showFrom=" + r7 + ",showType= " + r8);
        if (r8 != null) goto L42;
    L59:
        if (r6 != null) goto L61;
    L64:
        boolean r11 = true;
    L65:
        if (r11 == true) goto L67;
        f2.c(r6, 0);
        ga2.d.a(r6);
    L67:
        return true;
    L61:
        if (StringsKt.isBlank(r6) == true) goto L64;
        r11 = false;
        goto L65
    L42:
        if (Intrinsics.areEqual(r8, "new_open") == false) goto L46;
        if (Intrinsics.areEqual(r7, "screen_assistant_setting") == true) goto L59;
    L46:
        if (Intrinsics.areEqual(r8, "new_open") == true) goto L48;
    L49:
        post(new b(this, r7));
        goto L59
    L48:
        if (Intrinsics.areEqual(r7, "live_take_show") == true) goto L59;
    L50:
        UtilityKotlinExtentionsKt.t(this);
        com.bytedance.android.livesdk.interactivity.publicscreen.selectedmessage.presenter.a r13 = this.q;
        r13.f.b.removeCallbacksAndMessages(null);
        r13.b = false;
        SelectedMsgBuffer r14 = r13.c;
        ((ArrayDeque) r14.b).clear();
        ((PriorityQueue) r14.c).clear();
        int r15 = RangesKt.coerceAtLeast(((ArrayList) r13.e).size() - r13.d.listMaxSizeWhenHide, 0);
        ((ArrayList) r13.e).subList(0, r15).clear();
        com.bytedance.android.livesdk.interactivity.publicscreen.selectedmessage.presenter.a.InterfaceC0191a r16 = (com.bytedance.android.livesdk.interactivity.publicscreen.selectedmessage.presenter.a.InterfaceC0191a) ((q46.b) r13).a;
        if (r16 == null) goto L53;
        r16.pa(r15);
    L53:
        ga2.d.b(r15, "visibility change");
        SimpleDateFormat r17 = PublicScreenMessageMonitor.a;
        ((t) PublicScreenMessageMonitor.v.getValue()).d = false;
        AiAgentViewStateHolder r18 = this.A;
        if (r18 == null) goto L59;
        ga2.d.a("AiAgentViewStateHolder containerHide");
        Disposable r19 = r18.c;
        if (r19 == null) goto L58;
        r19.dispose();
    L58:
        r18.c = null;
        goto L59
    L13:
        if (this.d == false) goto L24;
        if (this.e == false) goto L24;
    L23:
        r3 = true;
        goto L26
    L18:
        if (r2 != LiveMode.AUDIO) goto L24;
        if (this.f == false) goto L24;
        if (SelectedMsgABHelper.c(this.M) == false) goto L24;
    L7:
        r2 = null;
        goto L9
    }

    @Override // ha2.a
    public final void b(boolean r1, String r2, String r3, String r4) {
        this.f = r1;
        if (r1 == true) goto L5;
    L7:
        j(r2, r3, r4);
        return;
    L5:
        if (Intrinsics.areEqual(r4, "new_open") == false) goto L7;
        i();
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    public AiAgentPSSelectedMsgView(Context r18, e52.a r19, DataCenter r20, CompositeDisposable r21, SelectedMsgViewManager r23) {
        Intrinsics.checkNotNullParameter(r18, "context");
        Intrinsics.checkNotNullParameter(r19, "publicScreenConfig");
        Intrinsics.checkNotNullParameter(r20, "dataCenter");
        Intrinsics.checkNotNullParameter(r21, "cd");
        Intrinsics.checkNotNullParameter(r23, "selectedDataSource");
        super(r18, null, 0);
        this.L = r19;
        this.M = r20;
        this.N = r21;
        this.O = r23;
        this.d = SelectedMsgABHelper.f(r20, null);
        this.e = SelectedMsgABHelper.g(r20, null);
        SelectedMsgABHelper.e(r20);
        SelectedMsgLayoutManager r4 = new SelectedMsgLayoutManager(r18);
        this.j = r4;
        SpaceItemDecoration r6 = new SpaceItemDecoration(1, q.e(true, true), false);
        this.k = r6;
        Handler r9 = new Handler(Looper.getMainLooper());
        this.l = r9;
        Function1<com.bytedance.android.livesdk.interactivity.api.entity.f<?>, Map<String, String>> r10 = new AiAgentPSSelectedMsgView$envParamsGenerator$1(this);
        this.m = r10;
        g r11 = new g(this);
        c r13 = new c(this);
        this.n = r13;
        SelectedMsgListAdapter r14 = new SelectedMsgListAdapter(r10, r11, r13);
        this.o = r14;
        this.p = new h(this);
        com.bytedance.android.livesdk.interactivity.publicscreen.selectedmessage.presenter.a r15 = new com.bytedance.android.livesdk.interactivity.publicscreen.selectedmessage.presenter.a(r19, r9, r20, r23);
        this.q = r15;
        FrameLayout.inflate(r18, 2131566777, this);
        LinearLayout.LayoutParams r3 = new LinearLayout.LayoutParams(-1, -2);
        r3.setMargins(0, U, 0, 0);
        setLayoutParams(r3);
        LiveMessageRecyclerView r5 = (LiveMessageRecyclerView) findViewById(2131385845);
        this.g = r5;
        View r7 = findViewById(2131380320);
        this.h = r7;
        View r16 = findViewById(2131371576);
        this.i = r16;
        r7.setOnClickListener(new com.bytedance.android.livesdk.interactivity.publicscreen.selectedmessage.view.aiagent.a(this, r18));
        this.r = findViewById(2131362372);
        this.s = (HSImageView) findViewById(2131362368);
        this.t = (TextView) findViewById(2131362367);
        this.u = (FrameLayout) findViewById(2131362371);
        this.v = (FrameLayout) findViewById(2131362370);
        this.w = (ImageView) findViewById(2131362374);
        this.x = (FrameLayout) findViewById(2131362369);
        this.y = (TextView) findViewById(2131362375);
        this.z = (ImageView) findViewById(2131362373);
        View r1 = this.r;
        if (r1 == null) goto L5;
        r1.setOnClickListener(x0.a(new AiAgentPSSelectedMsgView$setAiAgentViewClickListener$1(this)));
    L5:
        ImageView r2 = this.w;
        if (r2 == null) goto L8;
        r2.setOnClickListener(x0.a(new AiAgentPSSelectedMsgView$setAiAgentViewClickListener$2(this)));
    L8:
        ImageView r8 = this.z;
        if (r8 == null) goto L11;
        r8.setOnClickListener(x0.a(new AiAgentPSSelectedMsgView$setAiAgentViewClickListener$3(this)));
    L11:
        this.B = CollectionsKt.listOf(new View[]{r5, r7, r16, this.r, this.s, this.t, this.w, this.x, this.v, this.u, this.y, this.z});
        this.C = CollectionsKt.listOf(new View[]{r5, r7, r16});
        this.D = CollectionsKt.listOf(new View[]{this.r, this.s, this.t, this.w, this.v});
        this.E = CollectionsKt.listOf(new View[]{this.r, this.u, this.w, this.x, r5});
        this.F = CollectionsKt.listOf(new View[]{this.r, this.y, this.z});
        AiAgentViewStateHolder r17 = new AiAgentViewStateHolder(r13);
        f r24 = new f(this);
        Intrinsics.checkNotNullParameter(r24, "listener");
        r17.d = r24;
        Unit r25 = Unit.INSTANCE;
        this.A = r17;
        ga2.d.a("AiAgentViewStateHolder init");
        r17.b(new AiAgentViewState[]{AiAgentViewState.DEFAULT});
        if (r17.e.a() == false) goto L14;
        AiAgentViewState r26 = AiAgentViewState.AI_AGENT_EMPTY;
    L15:
        r17.a(r26, AiAgentViewChangeReason.INIT);
        List<com.bytedance.android.livesdk.interactivity.api.entity.f<?>> r27 = r15.e;
        Intrinsics.checkNotNullParameter(r27, "messages");
        r14.b = r27;
        ((q46.b) r15).a = this;
        r5.setCanScrollUp(true);
        r5.setHasFixedSize(true);
        r5.setLayoutManager(r4);
        r5.addItemDecoration(r6);
        r5.setAccessibilityDelegateCompat(new MessageRvAccessibilityDelegate(r5));
        r5.setAdapter(r14);
        r5.setItemAnimator(null);
        r5.addOnScrollListener(new AiAgentPSSelectedMsgView$initMessageRecycleView$1(this));
        r5.setOnTouchListener(new d(this, new GestureDetector(getContext(), new e(this))));
        Intrinsics.checkNotNullParameter(r19, "textMessageConfig");
        r14.c = r19;
        Intrinsics.checkNotNullParameter(LayoutInflater.from(getContext()), "layoutInflater");
        r14.d = q.a(r19, true, true);
        t();
        j(null, null, null);
        return;
    L14:
        r26 = AiAgentViewState.NO_OR_OLD_AI;
        goto L15
    }
}
