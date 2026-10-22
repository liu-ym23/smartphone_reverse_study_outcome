package com.bytedance.android.live.broadcastgame.openplatform.feature_panel.view.in_live;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.broadcastgame.openplatform.feature_panel.adapter.OpenFeatureTabListAdapter;
import com.bytedance.android.live.broadcastgame.openplatform.feature_panel.viewholder.SearchHistoryViewBinder;
import com.bytedance.android.live.broadcastgame.openplatform.feature_panel.viewmodel.AbsOpenFeaturePanelViewModel;
import com.bytedance.android.live.core.ui.BaseFragment;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ExtendedToolbarButton;
import com.bytedance.android.livesdk.config.ft0;
import com.bytedance.android.livesdk.config.k81;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.text.StringsKt;
import me.drakeet.multitype.MultiTypeAdapter;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/openplatform/feature_panel/view/in_live/LiveOpenFeatureSearchFragment;", "Lcom/bytedance/android/live/core/ui/BaseFragment;", "<init>", "()V", "b", "livebroadcastgame-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveOpenFeatureSearchFragment extends BaseFragment {
    public static final /* synthetic */ int l = 0;
    public Map<Integer, View> d;
    public AbsOpenFeaturePanelViewModel e;
    public final com.bytedance.android.live.broadcastgame.openplatform.feature_panel.business.e f;
    public final long g;
    public Long h;
    public c20.a i;
    public OpenFeatureTabListAdapter j;
    public final MultiTypeAdapter k;

    public static final class a implements SearchHistoryViewBinder.a {
        public final /* synthetic */ MultiTypeAdapter a;
        public final /* synthetic */ LiveOpenFeatureSearchFragment b;

        @Override // com.bytedance.android.live.broadcastgame.openplatform.feature_panel.viewholder.SearchHistoryViewBinder.a
        public final void a(String r4) {
            Intrinsics.checkNotNullParameter(r4, "name");
            LiveOpenFeatureSearchFragment r0 = this.b;
            int r1 = LiveOpenFeatureSearchFragment.l;
            ((EditText) r0.S90(2131385411)).setText(r4);
            ((EditText) r0.S90(2131385411)).setSelection(r4.length());
            r0.V90();
        }

        @Override // com.bytedance.android.live.broadcastgame.openplatform.feature_panel.viewholder.SearchHistoryViewBinder.a
        public final void b(String r2) {
            Intrinsics.checkNotNullParameter(r2, "keyWord");
            List r0 = this.a.a;
            if (r0 == null) goto L10;
            TypeIntrinsics.asMutableCollection(r0).remove(r2);
            if (this.a.a.size() >= 1) goto L7;
            UtilityKotlinExtentionsKt.t(this.b.S90(2131366935));
        L7:
            this.a.notifyDataSetChanged();
            return;
        L10:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.MutableCollection<T>");
        }

        public a(MultiTypeAdapter r1, LiveOpenFeatureSearchFragment r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public static final class b {
    }

    static {
    }

    public LiveOpenFeatureSearchFragment() {
        this.d = new LinkedHashMap();
        this.f = new com.bytedance.android.live.broadcastgame.openplatform.feature_panel.business.e();
        this.g = 2;
        MultiTypeAdapter r0 = new MultiTypeAdapter();
        r0.z2(String.class, new SearchHistoryViewBinder(new a(r0, this)));
        Unit r1 = Unit.INSTANCE;
        this.k = r0;
    }

    public final void U90() {
        ((LinearLayout) S90(2131385416)).setVisibility(8);
        S90(2131384075).setVisibility(8);
        UtilityKotlinExtentionsKt.t(S90(2131379091));
    }

    public final void V90() {
        String r1 = ((EditText) S90(2131385411)).getText().toString();
        if (r1 == null) goto L28;
        String r2 = StringsKt.trim(r1).toString();
        if (TextUtils.isEmpty(r2) == true) goto L29;
        W90(false);
        ((TextView) S90(2131366935)).setVisibility(8);
        int r3 = com.bytedance.android.live.broadcastgame.opengame.utils.l.a;
        com.bytedance.android.live.broadcastgame.opengame.utils.l.a(getContext(), S90(2131385411));
        UtilityKotlinExtentionsKt.w(S90(2131379091));
        if (((k81) ft0.a.getValue()).b() == false) goto L21;
        c20.a r0 = this.i;
        if (r0 == null) goto L21;
        if (r0.a != 6) goto L21;
        AbsOpenFeaturePanelViewModel r4 = this.e;
        if (r4 == null) goto L30;
        a20.l r5 = r4.getFeatureSearchHandler();
        if (r5 == null) goto L31;
        c20.a r6 = this.i;
        if (r6 == null) goto L19;
        List<f10.f> r7 = r6.b;
    L20:
        r5.i(r2, r7);
        return;
    L19:
        r7 = null;
        goto L20
    L31:
        return;
    L30:
        return;
    L21:
        AbsOpenFeaturePanelViewModel r8 = this.e;
        if (r8 == null) goto L33;
        a20.l r9 = r8.getFeatureSearchHandler();
        if (r9 == null) goto L34;
        r9.j(this.g, this.h, r2);
        return;
    L34:
        return;
    L33:
        return;
    L29:
        return;
    L28:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
    }

    @Override // com.bytedance.android.live.core.ui.BaseFragment
    public final void onDestroyView() {
        super.onDestroyView();
        int r0 = com.bytedance.android.live.broadcastgame.opengame.utils.l.a;
        Context r1 = getContext();
        FragmentActivity r2 = getActivity();
        if (r2 == null) goto L11;
        Window r3 = r2.getWindow();
        if (r3 == null) goto L11;
        View r4 = r3.getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L12;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r5 = ThreadMethodProxy.currentThread();
        if (r5 == com.larus.home.impl.utils.c.a) goto L12;
        com.larus.home.impl.utils.c.a(r5, "getDecorView");
    L12:
        com.bytedance.android.live.broadcastgame.opengame.utils.l.a(r1, r4);
        ((LinkedHashMap) this.d).clear();
        return;
    L11:
        r4 = null;
        goto L12
    }

    public final View S90(int r3) {
        if (this.d != null) goto L5;
        this.d = new LinkedHashMap();
    L5:
        View r0 = this.d.get(Integer.valueOf(r3));
        if (r0 != null) goto L14;
        View r1 = getView();
        if (r1 == null) goto L12;
        View r2 = r1.findViewById(r3);
        if (r2 == null) goto L12;
        this.d.put(Integer.valueOf(r3), r2);
        return r2;
    L12:
        return null;
    L14:
        return r0;
    }

    public final void W90(boolean r2) {
        if (r2 == false) goto L8;
        RecyclerView.Adapter r3 = S90(2131384074).getAdapter();
        if (r3 == null) goto L7;
        r3.notifyDataSetChanged();
    L7:
        UtilityKotlinExtentionsKt.w(S90(2131384074));
        return;
    L8:
        UtilityKotlinExtentionsKt.t(S90(2131384074));
    }

    @Override // com.bytedance.android.live.core.ui.BaseFragment
    public final void onCreate(Bundle r5) {
        super.onCreate(r5);
        Long r3 = null;
        RoomContext r6 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r6 == null) goto L9;
        com.bytedance.live.datacontext.m r7 = r6.getRoom();
        if (r7 == null) goto L9;
        Room r8 = (Room) r7.getValue();
        if (r8 == null) goto L9;
        r3 = Long.valueOf(r8.getRoomId());
    L9:
        this.h = r3;
        AbsOpenFeaturePanelViewModel.Companion.getClass();
        this.e = AbsOpenFeaturePanelViewModel.a.a(true, this);
    }

    public static final void T90(LiveOpenFeatureSearchFragment r8, List r9) {
        String r0 = ((EditText) r8.S90(2131385411)).getText().toString();
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L12;
        return;
    L12:
        if (r9 != null) goto L14;
    L23:
        UtilityKotlinExtentionsKt.w(r8.S90(2131385416));
        UtilityKotlinExtentionsKt.t(r8.S90(2131379091));
        UtilityKotlinExtentionsKt.t(r8.S90(2131384075));
        return;
    L14:
        if (r9.isEmpty() == true) goto L23;
        r8.f.d();
        Iterator r3 = r9.iterator();
    L18:
        if (r3.hasNext() == false) goto L20;
        f10.f r4 = (f10.f) r3.next();
        r4.u = r8.f.a(((ExtendedToolbarButton.c) r4).s, r4.t);
        goto L18
    L20:
        UtilityKotlinExtentionsKt.t(r8.S90(2131379091));
        r8.k.notifyDataSetChanged();
        UtilityKotlinExtentionsKt.w(r8.S90(2131384075));
        UtilityKotlinExtentionsKt.t(r8.S90(2131385416));
        OpenFeatureTabListAdapter r11 = r8.j;
        if (r11 == null) goto L26;
        r11.setData(r9);
        return;
    L26:
        return;
    L5:
        if (r0.length() == 0) goto L8;
        r1 = false;
        goto L9
    }

    @Override // com.bytedance.android.live.core.ui.BaseFragment
    public final void onViewCreated(View r7, Bundle r8) {
        Intrinsics.checkNotNullParameter(r7, "view");
        super.onViewCreated(r7, r8);
        AbsOpenFeaturePanelViewModel r9 = this.e;
        ViewGroup.LayoutParams r11 = null;
        if (r9 == null) goto L5;
        a20.d r12 = r9.getFeatureIconBehaviorController();
    L7:
        if ((r12 instanceof a20.e) == true) goto L9;
        r12 = null;
    L9:
        ArrayList r0 = new ArrayList();
        ft0 r1 = ft0.a;
        if (((k81) r1.getValue()).b() == false) goto L12;
        r0.add(new f20.d(r12));
    L12:
        r0.add(new f20.e(r12));
        this.j = new OpenFeatureTabListAdapter(CollectionsKt.emptyList(), r0, null);
        MultiTypeAdapter r13 = this.k;
        AbsOpenFeaturePanelViewModel r2 = this.e;
        if (r2 == null) goto L19;
        a20.l r3 = r2.getFeatureSearchHandler();
        if (r3 == null) goto L19;
        List r4 = r3.a();
        if (r4 == null) goto L19;
    L20:
        r13.a = r4;
        AbsOpenFeaturePanelViewModel r14 = this.e;
        if (r14 == null) goto L25;
        LiveData<List<f10.f>> r15 = r14.getOpenFeatureSearchResult();
        if (r15 == null) goto L25;
        r15.observe(this, new q(this));
    L25:
        int r5 = 0;
        if (((k81) r1.getValue()).f() == false) goto L49;
        AbsOpenFeaturePanelViewModel r16 = this.e;
        if (r16 == null) goto L33;
        LiveData<Integer> r17 = r16.getOpenFeatureTabIndexData();
        if (r17 == null) goto L33;
        Integer r18 = (Integer) r17.getValue();
        if (r18 == null) goto L33;
    L34:
        int r19 = r18.intValue();
        AbsOpenFeaturePanelViewModel r6 = this.e;
        if (r6 == null) goto L43;
        LiveData<c20.c> r21 = r6.getOpenFeatureTabListData();
        if (r21 == null) goto L43;
        c20.c r22 = (c20.c) r21.getValue();
        if (r22 == null) goto L43;
        List<c20.a> r23 = r22.c;
        if (r23 == null) goto L43;
        c20.a r24 = (c20.a) CollectionsKt.getOrNull(r23, r19);
    L44:
        this.i = r24;
        AbsOpenFeaturePanelViewModel r25 = this.e;
        if (r25 == null) goto L49;
        LiveData<c20.c> r26 = r25.getOpenFeatureTabListData();
        if (r26 == null) goto L49;
        r26.observe(this, new r(this));
    L43:
        r24 = null;
    L33:
        r18 = 0;
    L49:
        U90();
        ViewGroup.LayoutParams r27 = ((LinearLayout) S90(2131385416)).getLayoutParams();
        if ((r27 instanceof ConstraintLayout.LayoutParams) == true) goto L52;
        r27 = null;
    L52:
        ConstraintLayout.LayoutParams r28 = (ConstraintLayout.LayoutParams) r27;
        if (r28 == null) goto L55;
        ((ViewGroup.MarginLayoutParams) r28).topMargin = s1.f(114.0f);
    L55:
        ViewGroup.LayoutParams r29 = ((HSImageView) S90(2131385568)).getLayoutParams();
        if ((r29 instanceof LinearLayout.LayoutParams) == false) goto L59;
        r11 = r29;
    L59:
        LinearLayout.LayoutParams r31 = (LinearLayout.LayoutParams) r11;
        if (r31 == null) goto L62;
        r31.width = s1.f(180.0f);
        r31.height = s1.f(120.0f);
    L62:
        ImageLoader.bindImage((HSImageView) S90(2131385568), "https://lf1-webcastcdn-tos.douyinstatic.com/obj/live-android/img_empty_search.png");
        ((TextView) S90(2131365132)).setOnClickListener(new s(this));
        ((TextView) S90(2131365132)).setVisibility(0);
        if (((k81) r1.getValue()).f() == false) goto L69;
        c20.a r32 = this.i;
        if (r32 == null) goto L69;
        if (r32.a != 6) goto L69;
        ((EditText) S90(2131385411)).setHint("搜索互动工具");
    L70:
        ((EditText) S90(2131385411)).setImeOptions(3);
        ((EditText) S90(2131385411)).setSingleLine(true);
        ((EditText) S90(2131385411)).setInputType(1);
        ((EditText) S90(2131385411)).setOnEditorActionListener(new t(this));
        ((EditText) S90(2131385411)).addTextChangedListener(new u(this));
        ((EditText) S90(2131385411)).setOnFocusChangeListener(new v(this));
        ((ImageView) S90(2131366949)).setOnClickListener(new w(this));
        ((ImageView) S90(2131366949)).setVisibility(4);
        ((TextView) S90(2131366935)).setOnClickListener(new x(this));
        RecyclerView r33 = S90(2131384074);
        LinearLayoutManager r34 = new LinearLayoutManager(getContext());
        r34.setStackFromEnd(true);
        r34.setReverseLayout(true);
        Unit r35 = Unit.INSTANCE;
        r33.setLayoutManager(r34);
        S90(2131384074).setAdapter(this.k);
        ((EditText) S90(2131385411)).setFocusable(true);
        ((EditText) S90(2131385411)).setFocusableInTouchMode(true);
        ((EditText) S90(2131385411)).requestFocus();
        int r36 = com.bytedance.android.live.broadcastgame.opengame.utils.l.a;
        Context r37 = getContext();
        View r38 = S90(2131385411);
        if (r37 == null) goto L83;
        if (r38 == null) goto L83;
        r38.requestFocus();     // Catch: Exception -> L80
        Object r39 = r37.getSystemService("input_method");     // Catch: Exception -> L80
        if (r39 == null) goto L79;
        ((InputMethodManager) r39).showSoftInput(r38, 2);     // Catch: Exception -> L80
        goto L83
    L79:
        throw new NullPointerException("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");     // Catch: Exception -> L80
    L80:
        e = move-exception;
        e.printStackTrace();
    L83:
        if (S90(2131384074).getVisibility() != 0) goto L89;
        RecyclerView.Adapter r41 = S90(2131384074).getAdapter();
        if (r41 == null) goto L87;
        r5 = r41.getItemCount();
    L87:
        if (r5 < 1) goto L89;
        UtilityKotlinExtentionsKt.w(S90(2131366935));
    L90:
        S90(2131384075).setVisibility(8);
        S90(2131384075).setOverScrollMode(2);
        S90(2131384075).setLayoutManager(new LinearLayoutManager(getContext()));
        S90(2131384075).setAdapter(this.j);
        return;
    L89:
        UtilityKotlinExtentionsKt.t(S90(2131366935));
    L69:
        ((EditText) S90(2131385411)).setHint("搜索小程序");
    L19:
        r4 = CollectionsKt.emptyList();
        goto L20
    L5:
        r12 = null;
        goto L7
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        return r2.inflate(2131567081, r3, false);
    }
}
