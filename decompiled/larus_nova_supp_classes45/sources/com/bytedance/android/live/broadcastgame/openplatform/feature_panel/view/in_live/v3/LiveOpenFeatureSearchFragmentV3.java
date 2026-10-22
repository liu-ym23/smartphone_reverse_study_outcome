package com.bytedance.android.live.broadcastgame.openplatform.feature_panel.view.in_live.v3;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
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
import com.bytedance.android.live.broadcastgame.api.AnchorGameContext;
import com.bytedance.android.live.broadcastgame.openplatform.feature_panel.adapter.OpenFeatureTabListAdapter;
import com.bytedance.android.live.broadcastgame.openplatform.feature_panel.base.OpenFeatureIconCallbackFrom;
import com.bytedance.android.live.broadcastgame.openplatform.feature_panel.viewholder.SearchHistoryViewBinder;
import com.bytedance.android.live.broadcastgame.openplatform.feature_panel.viewholder.SearchHistoryViewBinderV3;
import com.bytedance.android.live.broadcastgame.openplatform.feature_panel.viewmodel.AbsOpenFeaturePanelViewModel;
import com.bytedance.android.live.core.ui.BaseFragment;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.ui.LiveDoubleColorBallAnimationView;
import com.bytedance.android.livesdk.config.ft0;
import com.bytedance.android.livesdk.config.k81;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.text.StringsKt;
import me.drakeet.multitype.MultiTypeAdapter;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/openplatform/feature_panel/view/in_live/v3/LiveOpenFeatureSearchFragmentV3;", "Lcom/bytedance/android/live/core/ui/BaseFragment;", "<init>", "()V", "b", "livebroadcastgame-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveOpenFeatureSearchFragmentV3 extends BaseFragment {
    public static final /* synthetic */ int s = 0;
    public TextView d;
    public LiveDoubleColorBallAnimationView e;
    public RecyclerView f;
    public RecyclerView g;
    public LinearLayout h;
    public HSImageView i;
    public TextView j;
    public ImageView k;
    public EditText l;
    public AbsOpenFeaturePanelViewModel m;
    public final long n;
    public Long o;
    public c20.a p;
    public OpenFeatureTabListAdapter q;
    public final MultiTypeAdapter r;

    public static final class a implements SearchHistoryViewBinder.a {
        public final /* synthetic */ MultiTypeAdapter a;
        public final /* synthetic */ LiveOpenFeatureSearchFragmentV3 b;

        @Override // com.bytedance.android.live.broadcastgame.openplatform.feature_panel.viewholder.SearchHistoryViewBinder.a
        public final void a(String r3) {
            Intrinsics.checkNotNullParameter(r3, "name");
            LiveOpenFeatureSearchFragmentV3 r0 = this.b;
            EditText r1 = r0.l;
            if (r1 == null) goto L5;
            r1.setText(r3);
        L5:
            EditText r2 = r0.l;
            if (r2 == null) goto L8;
            r2.setSelection(r3.length());
        L8:
            r0.T90();
        }

        @Override // com.bytedance.android.live.broadcastgame.openplatform.feature_panel.viewholder.SearchHistoryViewBinder.a
        public final void b(String r2) {
            Intrinsics.checkNotNullParameter(r2, "keyWord");
            List r0 = this.a.a;
            if (r0 == null) goto L12;
            TypeIntrinsics.asMutableCollection(r0).remove(r2);
            if (this.a.a.size() >= 1) goto L9;
            TextView r3 = this.b.d;
            if (r3 == null) goto L9;
            UtilityKotlinExtentionsKt.t(r3);
        L9:
            this.a.notifyDataSetChanged();
            return;
        L12:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.MutableCollection<T>");
        }

        public a(MultiTypeAdapter r1, LiveOpenFeatureSearchFragmentV3 r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public static final class b {
    }

    static {
    }

    public final void T90() {
        EditText r0 = this.l;
        List<f10.f> r1 = null;
        if (r0 == null) goto L5;
        Editable r2 = r0.getText();
    L6:
        String r3 = StringsKt.trim(String.valueOf(r2)).toString();
        if (TextUtils.isEmpty(r3) == true) goto L28;
        U90(false);
        TextView r4 = this.d;
        if (r4 == null) goto L11;
        r4.setVisibility(8);
    L11:
        int r5 = com.bytedance.android.live.broadcastgame.opengame.utils.l.a;
        com.bytedance.android.live.broadcastgame.opengame.utils.l.a(getContext(), this.l);
        LiveDoubleColorBallAnimationView r6 = this.e;
        if (r6 == null) goto L14;
        UtilityKotlinExtentionsKt.w(r6);
    L14:
        AbsOpenFeaturePanelViewModel r7 = this.m;
        if (r7 == null) goto L22;
        a20.l r8 = r7.getFeatureSearchHandler();
        if (r8 == null) goto L22;
        long r9 = this.n;
        Long r11 = this.o;
        c20.a r12 = this.p;
        if (r12 == null) goto L21;
        r1 = r12.b;
    L21:
        r8.g(r9, r11, r3, r1);
    L22:
        AnchorGameContext.Companion.getClass();
        AnchorGameContext r13 = AnchorGameContext.a.a();
        if (r13 == null) goto L29;
        com.bytedance.live.datacontext.m<String> r14 = r13.getSearchWord();
        if (r14 == null) goto L30;
        r14.setValue(r3);
        return;
    L30:
        return;
    L29:
        return;
    L28:
        return;
    L5:
        r2 = null;
        goto L6
    }

    public LiveOpenFeatureSearchFragmentV3() {
        this.n = 2;
        MultiTypeAdapter r0 = new MultiTypeAdapter();
        r0.z2(String.class, new SearchHistoryViewBinderV3(new a(r0, this)));
        Unit r1 = Unit.INSTANCE;
        this.r = r0;
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
        return;
    L11:
        r4 = null;
        goto L12
    }

    public final void U90(boolean r1) {
        if (r1 == false) goto L11;
        RecyclerView r2 = this.f;
        if (r2 == null) goto L8;
        RecyclerView.Adapter r3 = r2.getAdapter();
        if (r3 == null) goto L8;
        r3.notifyDataSetChanged();
    L8:
        RecyclerView r4 = this.f;
        if (r4 == null) goto L15;
        UtilityKotlinExtentionsKt.w(r4);
        return;
    L15:
        return;
    L11:
        RecyclerView r5 = this.f;
        if (r5 == null) goto L17;
        UtilityKotlinExtentionsKt.t(r5);
        return;
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
        this.o = r3;
        AbsOpenFeaturePanelViewModel.Companion.getClass();
        this.m = AbsOpenFeaturePanelViewModel.a.a(true, this);
    }

    public static final void S90(LiveOpenFeatureSearchFragmentV3 r1, List r2) {
        EditText r0 = r1.l;
        if (r0 == null) goto L5;
        Editable r3 = r0.getText();
    L7:
        if (String.valueOf(r3).length() != 0) goto L9;
        boolean r4 = true;
    L10:
        if (r4 == true) goto L41;
        if (r2 != null) goto L14;
    L28:
        LinearLayout r5 = r1.h;
        if (r5 == null) goto L31;
        UtilityKotlinExtentionsKt.w(r5);
    L31:
        LiveDoubleColorBallAnimationView r6 = r1.e;
        if (r6 == null) goto L34;
        UtilityKotlinExtentionsKt.t(r6);
    L34:
        RecyclerView r7 = r1.g;
        if (r7 == null) goto L40;
        UtilityKotlinExtentionsKt.t(r7);
        return;
    L40:
        return;
    L14:
        if (r2.isEmpty() == true) goto L28;
        LiveDoubleColorBallAnimationView r8 = r1.e;
        if (r8 == null) goto L19;
        UtilityKotlinExtentionsKt.t(r8);
    L19:
        r1.r.notifyDataSetChanged();
        RecyclerView r9 = r1.g;
        if (r9 == null) goto L22;
        UtilityKotlinExtentionsKt.w(r9);
    L22:
        LinearLayout r11 = r1.h;
        if (r11 == null) goto L25;
        UtilityKotlinExtentionsKt.t(r11);
    L25:
        OpenFeatureTabListAdapter r12 = r1.q;
        if (r12 == null) goto L38;
        r12.setData(r2);
        return;
    L38:
        return;
    L41:
        return;
    L9:
        r4 = false;
        goto L10
    L5:
        r3 = null;
        goto L7
    }

    @Override // com.bytedance.android.live.core.ui.BaseFragment
    public final void onViewCreated(View r9, Bundle r11) {
        Intrinsics.checkNotNullParameter(r9, "view");
        super.onViewCreated(r9, r11);
        this.d = (TextView) r9.findViewById(2131366935);
        this.e = r9.findViewById(2131379091);
        this.f = r9.findViewById(2131384074);
        this.g = r9.findViewById(2131384075);
        this.h = (LinearLayout) r9.findViewById(2131385416);
        this.i = (HSImageView) r9.findViewById(2131385568);
        this.j = (TextView) r9.findViewById(2131365132);
        this.k = (ImageView) r9.findViewById(2131366949);
        this.l = (EditText) r9.findViewById(2131385411);
        AbsOpenFeaturePanelViewModel r12 = this.m;
        ViewGroup.LayoutParams r13 = null;
        if (r12 == null) goto L5;
        a20.d r14 = r12.getFeatureIconBehaviorController();
    L7:
        if ((r14 instanceof a20.e) == true) goto L9;
        r14 = null;
    L9:
        ArrayList r0 = new ArrayList();
        r0.add(new g20.c(r14, OpenFeatureIconCallbackFrom.TAB_LIST));
        r0.add(new g20.e(r14, OpenFeatureIconCallbackFrom.SEARCH, LiveOpenFeatureSearchFragmentV3$initAdapter$1.INSTANCE));
        this.q = new OpenFeatureTabListAdapter(CollectionsKt.emptyList(), r0, null);
        MultiTypeAdapter r15 = this.r;
        AbsOpenFeaturePanelViewModel r1 = this.m;
        if (r1 == null) goto L16;
        a20.l r2 = r1.getFeatureSearchHandler();
        if (r2 == null) goto L16;
        List r3 = r2.a();
        if (r3 == null) goto L16;
    L17:
        r15.a = r3;
        AbsOpenFeaturePanelViewModel r16 = this.m;
        if (r16 == null) goto L22;
        LiveData<List<f10.f>> r17 = r16.getOpenFeatureSearchResult();
        if (r17 == null) goto L22;
        r17.observe(this, new n(this));
    L22:
        int r4 = 0;
        if (((k81) ft0.a.getValue()).f() == false) goto L49;
        AbsOpenFeaturePanelViewModel r18 = this.m;
        if (r18 == null) goto L43;
        LiveData<c20.c> r19 = r18.getOpenFeatureTabListData();
        if (r19 == null) goto L43;
        c20.c r21 = (c20.c) r19.getValue();
        if (r21 == null) goto L43;
        List<c20.a> r22 = r21.c;
        if (r22 == null) goto L43;
        Iterator<T> r23 = r22.iterator();
    L34:
        if (r23.hasNext() == false) goto L41;
        Object r5 = r23.next();
        if (((c20.a) r5).a != 6) goto L38;
        boolean r6 = true;
    L39:
        if (r6 == false) goto L34;
    L42:
        c20.a r7 = (c20.a) r5;
    L44:
        this.p = r7;
        AbsOpenFeaturePanelViewModel r24 = this.m;
        if (r24 == null) goto L49;
        LiveData<c20.c> r25 = r24.getOpenFeatureTabListData();
        if (r25 == null) goto L49;
        r25.observe(this, new o(this));
        goto L49
    L38:
        r6 = false;
        goto L39
    L41:
        r5 = null;
    L43:
        r7 = null;
    L49:
        LinearLayout r26 = this.h;
        if (r26 == null) goto L52;
        r26.setVisibility(8);
    L52:
        RecyclerView r27 = this.g;
        if (r27 == null) goto L55;
        r27.setVisibility(8);
    L55:
        LiveDoubleColorBallAnimationView r28 = this.e;
        if (r28 == null) goto L58;
        UtilityKotlinExtentionsKt.t(r28);
    L58:
        LinearLayout r29 = this.h;
        if (r29 == null) goto L61;
        ViewGroup.LayoutParams r31 = r29.getLayoutParams();
    L63:
        if ((r31 instanceof ConstraintLayout.LayoutParams) == true) goto L65;
        r31 = null;
    L65:
        ConstraintLayout.LayoutParams r32 = (ConstraintLayout.LayoutParams) r31;
        if (r32 == null) goto L68;
        ((ViewGroup.MarginLayoutParams) r32).topMargin = s1.f(114.0f);
    L68:
        SimpleDraweeView r33 = this.i;
        if (r33 == null) goto L71;
        ViewGroup.LayoutParams r34 = r33.getLayoutParams();
    L73:
        if ((r34 instanceof LinearLayout.LayoutParams) == false) goto L76;
        r13 = r34;
    L76:
        LinearLayout.LayoutParams r110 = (LinearLayout.LayoutParams) r13;
        if (r110 == null) goto L79;
        r110.width = s1.f(180.0f);
        r110.height = s1.f(120.0f);
    L79:
        ImageLoader.bindImage(this.i, "https://lf1-webcastcdn-tos.douyinstatic.com/obj/live-android/img_empty_search.png");
        TextView r35 = this.j;
        if (r35 == null) goto L82;
        r35.setOnClickListener(new p(this));
    L82:
        TextView r36 = this.j;
        if (r36 == null) goto L85;
        r36.setVisibility(0);
    L85:
        EditText r37 = this.l;
        if (r37 == null) goto L88;
        r37.setImeOptions(3);
    L88:
        EditText r38 = this.l;
        if (r38 == null) goto L91;
        r38.setSingleLine(true);
    L91:
        EditText r39 = this.l;
        if (r39 == null) goto L94;
        r39.setInputType(1);
    L94:
        EditText r41 = this.l;
        if (r41 == null) goto L97;
        r41.setOnEditorActionListener(new q(this));
    L97:
        EditText r42 = this.l;
        if (r42 == null) goto L100;
        r42.addTextChangedListener(new r(this));
    L100:
        EditText r43 = this.l;
        if (r43 == null) goto L103;
        r43.setOnFocusChangeListener(new s(this));
    L103:
        ImageView r44 = this.k;
        if (r44 == null) goto L106;
        r44.setOnClickListener(new t(this));
    L106:
        ImageView r45 = this.k;
        if (r45 == null) goto L109;
        r45.setVisibility(4);
    L109:
        TextView r46 = this.d;
        if (r46 == null) goto L112;
        r46.setOnClickListener(new u(this));
    L112:
        RecyclerView r47 = this.f;
        if (r47 == null) goto L115;
        LinearLayoutManager r111 = new LinearLayoutManager(getContext());
        r111.setStackFromEnd(true);
        r111.setReverseLayout(true);
        Unit r8 = Unit.INSTANCE;
        r47.setLayoutManager(r111);
    L115:
        RecyclerView r48 = this.f;
        if (r48 == null) goto L118;
        r48.setAdapter(this.r);
    L118:
        EditText r49 = this.l;
        if (r49 == null) goto L121;
        r49.setFocusable(true);
    L121:
        EditText r51 = this.l;
        if (r51 == null) goto L124;
        r51.setFocusableInTouchMode(true);
    L124:
        EditText r52 = this.l;
        if (r52 == null) goto L127;
        r52.requestFocus();
    L127:
        int r53 = com.bytedance.android.live.broadcastgame.opengame.utils.l.a;
        Context r54 = getContext();
        EditText r112 = this.l;
        if (r54 == null) goto L139;
        if (r112 == null) goto L139;
        r112.requestFocus();     // Catch: Exception -> L137
        Object r55 = r54.getSystemService("input_method");     // Catch: Exception -> L137
        if (r55 == null) goto L136;
        ((InputMethodManager) r55).showSoftInput(r112, 2);     // Catch: Exception -> L137
        goto L139
    L136:
        throw new NullPointerException("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");     // Catch: Exception -> L137
    L137:
        e = move-exception;
        e.printStackTrace();
    L139:
        RecyclerView r56 = this.f;
        if (r56 != null) goto L142;
    L152:
        TextView r57 = this.d;
        if (r57 == null) goto L155;
        UtilityKotlinExtentionsKt.t(r57);
    L155:
        RecyclerView r58 = this.g;
        if (r58 == null) goto L158;
        r58.setVisibility(8);
    L158:
        RecyclerView r59 = this.g;
        if (r59 == null) goto L161;
        r59.setOverScrollMode(2);
    L161:
        RecyclerView r61 = this.g;
        if (r61 == null) goto L164;
        r61.setLayoutManager(new LinearLayoutManager(getContext()));
    L164:
        RecyclerView r62 = this.g;
        if (r62 == null) goto L174;
        r62.setAdapter(this.q);
        return;
    L174:
        return;
    L142:
        if (r56.getVisibility() != 0) goto L152;
        RecyclerView r63 = this.f;
        if (r63 == null) goto L148;
        RecyclerView.Adapter r64 = r63.getAdapter();
        if (r64 == null) goto L148;
        r4 = r64.getItemCount();
    L148:
        if (r4 < 1) goto L152;
        TextView r65 = this.d;
        if (r65 == null) goto L155;
        UtilityKotlinExtentionsKt.w(r65);
        goto L155
    L71:
        r34 = null;
        goto L73
    L61:
        r31 = null;
    L16:
        r3 = CollectionsKt.emptyList();
        goto L17
    L5:
        r14 = null;
        goto L7
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        return r2.inflate(2131567082, r3, false);
    }
}
