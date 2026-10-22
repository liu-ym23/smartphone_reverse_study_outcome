package com.bytedance.android.live.revlink.impl.pk.dialog.fragment;

import android.app.Activity;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget;
import com.bytedance.android.live.core.utils.ContextUtil;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.android.live.revenue.common.ToastUtil;
import com.bytedance.android.live.revlink.impl.control.dialog.r;
import com.bytedance.android.live.revlink.impl.pk.dialog.adapter.PKRivalsSearchHistoryAdapter;
import com.bytedance.android.live.revlink.impl.pk.ui.PKRivalsSearchHistoryView;
import com.bytedance.android.live.revlink.impl.pk.ui.PKRivalsSearchRankListView;
import com.bytedance.android.live.revlink.impl.pk.ui.PKRivalsSearchRankTabColumn;
import com.bytedance.android.live.revlink.impl.pk.utils.SearchSourceFlag;
import com.bytedance.android.live.revlink.impl.pk.utils.u;
import com.bytedance.android.livesdk.chatroom.ui.SSLinearLayoutManager;
import com.bytedance.android.livesdk.link.model.IGroupRivals;
import com.bytedance.android.livesdk.link.model.IRivalRankRecommendResponse;
import com.bytedance.android.livesdk.link.model.s2;
import com.bytedance.android.livesdk.r3;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import me.drakeet.multitype.MultiTypeAdapter;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0001\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/pk/dialog/fragment/PKRivalsPanelSearchWidget;", "Lcom/bytedance/android/live/core/tetris/widgets/LiveRecyclableWidget;", "Lx31/j;", "Lcom/bytedance/android/live/revlink/impl/pk/ui/PKRivalsSearchHistoryView$a;", "a", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class PKRivalsPanelSearchWidget extends LiveRecyclableWidget implements x31.j, PKRivalsSearchHistoryView.a {
    public static final /* synthetic */ int x = 0;
    public boolean a;
    public ImageView b;
    public EditText c;
    public ImageView d;
    public RecyclerView e;
    public PKRivalsSearchHistoryView f;
    public View g;
    public final List<Pair<IGroupRivals.GroupType, PKRivalsSearchRankListView>> h;
    public IGroupRivals.GroupType i;
    public final PKRivalsPanelSearchWidget$mRivalsRankListViewsAdapter$1 j;
    public PKRivalsSearchRankListView k;
    public PKRivalsSearchRankListView l;
    public final Lazy m;
    public final List<String> n;
    public Disposable o;
    public final Lazy p;
    public final Lazy q;
    public final com.bytedance.android.live.revlink.impl.pk.dialog.presenter.j r;
    public final r s;
    public final View t;
    public final boolean u;
    public final String v;
    public final u w;

    public static final class a {
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ PKRivalsPanelSearchWidget a;

        public b(PKRivalsPanelSearchWidget r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            PKRivalsPanelSearchWidget r3 = this.a;
            int r0 = PKRivalsPanelSearchWidget.x;
            r3.Cq();
        }
    }

    public static final class c implements View.OnClickListener {
        public final /* synthetic */ PKRivalsPanelSearchWidget a;

        public c(PKRivalsPanelSearchWidget r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            this.a.Aq();
            this.a.r.h();
            EditText r3 = this.a.c;
            if (r3 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("mSearchEt");
        L5:
            r3.setText(null);
        }
    }

    public static final class d implements TextView.OnEditorActionListener {
        public final /* synthetic */ PKRivalsPanelSearchWidget a;

        public d(PKRivalsPanelSearchWidget r1) {
            this.a = r1;
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public final boolean onEditorAction(TextView r1, int r2, KeyEvent r3) {
            PKRivalsPanelSearchWidget r4 = this.a;
            int r5 = PKRivalsPanelSearchWidget.x;
            if (r2 != 3) goto L5;
            r4.Cq();
            return true;
        L5:
            r4.getClass();
            return false;
        }
    }

    public static final class e implements View.OnClickListener {
        public final /* synthetic */ PKRivalsPanelSearchWidget a;

        public e(PKRivalsPanelSearchWidget r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            r r3 = this.a.s;
            if (r3 != null) goto L5;
        L10:
            r r4 = this.a.s;
            if (r4 == null) goto L15;
            r4.v0();
            return;
        L15:
            return;
        L5:
            if (r3.s9() != 1) goto L10;
            r r5 = this.a.s;
            if (r5 == null) goto L14;
            r5.dismiss();
            return;
        }
    }

    public static final class f implements PKRivalsSearchRankTabColumn.a {
        public final /* synthetic */ PKRivalsPanelSearchWidget a;

        public f(PKRivalsPanelSearchWidget r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.live.revlink.impl.pk.ui.PKRivalsSearchRankTabColumn.a
        public final void a(IGroupRivals.GroupType r2) {
            Intrinsics.checkNotNullParameter(r2, "type");
            PKRivalsPanelSearchWidget.xq(this.a, r2);
        }
    }

    public static final class g<T> implements Observer {
        public final /* synthetic */ PKRivalsPanelSearchWidget a;

        public g(PKRivalsPanelSearchWidget r1) {
            this.a = r1;
        }

        public final void onChanged(Object r3) {
            PKRivalsPanelSearchWidget r0 = this.a;
            PKRivalsPanelSearchWidget.yq(r0, 1, (List) r3);
        }
    }

    public static final class h<T> implements Observer {
        public final /* synthetic */ PKRivalsPanelSearchWidget a;

        public h(PKRivalsPanelSearchWidget r1) {
            this.a = r1;
        }

        public final void onChanged(Object r8) {
            IRivalRankRecommendResponse r9 = (IRivalRankRecommendResponse) r8;
            DataCenter r0 = ((Widget) this.a).dataCenter;
            if (r0 == null) goto L8;
            if (com.bytedance.android.live.revlink.impl.pk.utils.c.a(r0) == true) goto L8;
            return;
        L8:
            if (this.a.v.length() <= 0) goto L10;
            boolean r1 = true;
        L11:
            if (r1 == true) goto L43;
            if (r9 == null) goto L31;
            s2 r2 = r9.getTabRivals();
            if (r2 == null) goto L31;
            int r3 = r2.getDefaultGroup();
            Iterator r4 = ((ArrayList) this.a.h).iterator();
            int r5 = 0;
        L18:
            if (r4.hasNext() == false) goto L26;
            if (((IGroupRivals.GroupType) ((Pair) r4.next()).getFirst()).ordinal() != r3) goto L22;
            boolean r6 = true;
        L23:
            if (r6 == true) goto L27;
            r5 = r5 + 1;
        L27:
            if (r5 < 0) goto L31;
            if (r5 >= ((ArrayList) this.a.h).size()) goto L31;
        L32:
            PKRivalsPanelSearchWidget r7 = this.a;
            PKRivalsPanelSearchWidget.xq(r7, (IGroupRivals.GroupType) ((Pair) ListProtector.get(r7.h, r5)).getFirst());
            ((PKRivalsSearchRankTabColumn) ((Widget) this.a).contentView.findViewById(2131385559)).setVisibility(0);
            ((Widget) this.a).contentView.findViewById(2131385560).setVisibility(0);
            PKRivalsPanelSearchWidget r10 = this.a;
            String r12 = ((Widget) r10).context.getResources().getString(2131917880);
            IGroupRivals.GroupType r13 = IGroupRivals.GroupType.GroupRivalsSearchPopularityRank;
            Pair r14 = PKRivalsPanelSearchWidget.wq(r10, r9, r12, r13);
            String r15 = (String) r14.component1();
            IGroupRivals r16 = (IGroupRivals) r14.component2();
            PKRivalsPanelSearchWidget r17 = this.a;
            String r18 = ((Widget) r17).context.getResources().getString(2131917860);
            IGroupRivals.GroupType r19 = IGroupRivals.GroupType.GroupRivalsSearchHourlyRank;
            Pair r20 = PKRivalsPanelSearchWidget.wq(r17, r9, r18, r19);
            String r22 = (String) r20.component1();
            IGroupRivals r23 = (IGroupRivals) r20.component2();
            ((PKRivalsSearchRankTabColumn) ((Widget) this.a).contentView.findViewById(2131385559)).b(r13, r15);
            ((PKRivalsSearchRankTabColumn) ((Widget) this.a).contentView.findViewById(2131385559)).b(r19, r22);
            PKRivalsSearchRankListView r24 = this.a.k;
            if (r24 == null) goto L35;
            r24.update(r16);
        L35:
            PKRivalsSearchRankListView r25 = this.a.l;
            if (r25 == null) goto L41;
            r25.update(r23);
            return;
        L41:
            return;
        L22:
            r6 = false;
            goto L23
        L26:
            r5 = -1;
        L31:
            r5 = 0;
            goto L32
        L43:
            return;
        L10:
            r1 = false;
            goto L11
        }
    }

    public static final class i<T> implements Observer {
        public final /* synthetic */ PKRivalsPanelSearchWidget a;

        public i(PKRivalsPanelSearchWidget r1) {
            this.a = r1;
        }

        public final void onChanged(Object r2) {
            if (Intrinsics.areEqual((Boolean) r2, Boolean.TRUE) == false) goto L17;
            PKRivalsSearchRankListView r3 = this.a.k;
            if (r3 == null) goto L10;
            MultiTypeAdapter r4 = r3.e;
            if (r4 != null) goto L9;
            Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
        L9:
            r4.notifyDataSetChanged();
        L10:
            PKRivalsSearchRankListView r5 = this.a.l;
            if (r5 == null) goto L18;
            MultiTypeAdapter r6 = r5.e;
            if (r6 != null) goto L15;
            Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
        L15:
            r6.notifyDataSetChanged();
            return;
        L18:
            return;
        }
    }

    static {
    }

    public final int getLayoutId() {
        return 2131566746;
    }

    public final void Aq() {
        RecyclerView r0 = this.e;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mSearchHistoryList");
    L5:
        r0.setVisibility(8);
    }

    public final void Bq() {
        PKRivalsSearchHistoryView r0 = this.f;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mSearchHistoryView");
    L5:
        r0.setVisibility(8);
    }

    public final void Cq() {
        EditText r0 = this.c;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mSearchEt");
    L5:
        boolean r2 = true;
        if (r0.getText().length() <= 0) goto L8;
        boolean r1 = true;
    L9:
        if (r1 == false) goto L43;
        zq();
        com.bytedance.android.live.revlink.impl.pk.dialog.presenter.j r4 = this.r;
        EditText r3 = this.c;
        if (r3 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("mSearchEt");
    L13:
        r4.j(r3.getText().toString(), 0, 20, "", true, this.v);
        Aq();
        Bq();
        View r5 = this.g;
        if (r5 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("mSearchBaseView");
    L16:
        r5.setVisibility(8);
        EditText r6 = this.c;
        if (r6 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("mSearchEt");
    L19:
        r6.setCursorVisible(false);
        HashMap r7 = new HashMap();
        r7.put("pksearch_type", DataType.FALSE);
        if (this.v.length() <= 0) goto L22;
        boolean r8 = true;
    L23:
        if (r8 == false) goto L25;
        String r9 = "activity";
    L26:
        r7.put("pk_description", r9);
        if (this.v.length() > 0) goto L30;
        r2 = false;
    L30:
        String r10 = "";
        if (r2 == false) goto L33;
        String r12 = this.v;
    L34:
        r7.put("pk_activity_type", r12);
        d31.d r13 = com.bytedance.android.live.revlink.impl.global.b.c0();
        if (r13 == null) goto L38;
        String r14 = r13.a();
        if (r14 == null) goto L38;
    L39:
        r7.put("anchor_connect_status", r14);
        d31.d r15 = com.bytedance.android.live.revlink.impl.global.b.c0();
        if (r15 == null) goto L42;
        r10 = r15.s();
    L42:
        r7.put("room_status", r10);
        r7.put("source", this.w.b);
        mz0.n r16 = new mz0.n();
        Map<String, String> r17 = r16.a;
        Intrinsics.checkNotNullParameter(r17, "map");
        Intrinsics.checkNotNullParameter(r7, "map");
        r17.putAll(r7);
        mz0.m r18 = new mz0.m();
        r18.b(LogCommon.ROOM);
        List<Object> r19 = r16.b;
        ArrayList r20 = (ArrayList) r19;
        r20.addAll(r18.a);
        cy0.e.a.getClass();
        cy0.j r22 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r23 = com.bytedance.android.scope.m.b(r22).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r23);
        ((mz0.i) ((f80.a) r23)).w3("livesdk_pksearch_launch", r16.a, r16.b);
        return;
    L38:
        r14 = "";
        goto L39
    L33:
        r12 = "";
        goto L34
    L25:
        r9 = "routine";
        goto L26
    L22:
        r8 = false;
        goto L23
    L43:
        SearchSourceFlag r24 = this.w.a;
        if (r24 != SearchSourceFlag.INVITE_LINKING) goto L46;
    L49:
        int r25 = 2131917785;
    L50:
        ToastUtil.a(r25, 0);
        return;
    L46:
        if (r24 == SearchSourceFlag.MAIN_LINK) goto L49;
        r25 = 2131921549;
        goto L50
    L8:
        r1 = false;
        goto L9
    }

    @Override // com.bytedance.android.live.revlink.impl.pk.ui.PKRivalsSearchHistoryView.a
    public final void Sn() {
        this.r.e();
    }

    public final void onUnload() {
        this.r.i(this);
    }

    public final void zq() {
        Activity r0 = ContextUtil.contextToActivity(getContext());
        Object r2 = null;
        if (r0 == null) goto L5;
        Object r1 = r0.getSystemService("input_method");
    L7:
        if ((r1 instanceof InputMethodManager) == false) goto L18;
        Activity r3 = ContextUtil.contextToActivity(getContext());
        if (r3 == null) goto L11;
        r2 = r3.getSystemService("input_method");
    L11:
        if (r2 == null) goto L17;
        InputMethodManager r4 = (InputMethodManager) r2;
        EditText r5 = this.c;
        if (r5 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("mSearchEt");
    L15:
        r4.hideSoftInputFromWindow(r5.getWindowToken(), 0);
        return;
    L17:
        throw new NullPointerException("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
    L18:
        return;
    L5:
        r1 = null;
        goto L7
    }

    public final void onInit(Object[] r7) {
        ImageView r8 = (ImageView) this.t.findViewById(2131385342);
        this.b = r8;
        if (r8 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mSearchIv");
    L5:
        r8.setOnClickListener(new b(this));
        ImageView r9 = (ImageView) this.t.findViewById(2131366936);
        this.d = r9;
        if (r9 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mClearBt");
    L8:
        r9.setOnClickListener(new c(this));
        final EditText r10 = (EditText) this.t.findViewById(2131385411);
        this.c = r10;
        if (this.u == true) goto L15;
        if (r10 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("mSearchEt");
    L12:
        if (r10 == null) goto L15;
        r10.postDelayed(new com.bytedance.android.live.revlink.impl.utils.d(r10), 100);
    L15:
        EditText r12 = this.c;
        if (r12 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("mSearchEt");
    L18:
        r12.setOnTouchListener((View.OnTouchListener) this.q.getValue());
        EditText r13 = this.c;
        if (r13 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("mSearchEt");
    L21:
        r13.addTextChangedListener((TextWatcher) this.p.getValue());
        EditText r14 = this.c;
        if (r14 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("mSearchEt");
    L24:
        r14.setOnEditorActionListener(new d(this));
        RecyclerView r15 = findViewById(2131385498);
        this.e = r15;
        if (r15 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException("mSearchHistoryList");
    L27:
        r15.setAdapter((PKRivalsSearchHistoryAdapter) this.m.getValue());
        RecyclerView r16 = this.e;
        if (r16 != null) goto L30;
        Intrinsics.throwUninitializedPropertyAccessException("mSearchHistoryList");
    L30:
        r16.setLayoutManager(new SSLinearLayoutManager(((Widget) this).context, 1));
        RecyclerView r17 = this.e;
        if (r17 != null) goto L33;
        Intrinsics.throwUninitializedPropertyAccessException("mSearchHistoryList");
    L33:
        r17.setItemViewCacheSize(16);
        PKRivalsSearchHistoryView r18 = (PKRivalsSearchHistoryView) findViewById(2131385499);
        this.f = r18;
        if (r18 != null) goto L36;
        Intrinsics.throwUninitializedPropertyAccessException("mSearchHistoryView");
    L36:
        r18.setCallBack(this);
        this.g = findViewById(2131385335);
        EditText r19 = this.c;
        if (r19 != null) goto L40;
        Intrinsics.throwUninitializedPropertyAccessException("mSearchEt");
    L40:
        if (r19.getText().length() != 0) goto L42;
        boolean r20 = true;
    L43:
        if (r20 == false) goto L45;
        this.r.h();
    L45:
        View r22 = this.t.findViewById(2131365114);
        if (r22 == null) goto L48;
        r22.setOnClickListener(new e(this));
    L48:
        View r23 = LayoutInflater.from(((Widget) this).context).inflate(2131566741, null);
        if (r23 == null) goto L76;
        this.k = (PKRivalsSearchRankListView) r23;
        View r24 = LayoutInflater.from(((Widget) this).context).inflate(2131566741, null);
        if (r24 == null) goto L74;
        this.l = (PKRivalsSearchRankListView) r24;
        PKRivalsSearchRankListView r25 = this.k;
        if (r25 == null) goto L55;
        r25.g(((Widget) this).dataCenter, IGroupRivals.GroupType.GroupRivalsSearchPopularityRank, this.r, this.w.a);
    L55:
        PKRivalsSearchRankListView r26 = this.l;
        if (r26 == null) goto L58;
        r26.g(((Widget) this).dataCenter, IGroupRivals.GroupType.GroupRivalsSearchHourlyRank, this.r, this.w.a);
    L58:
        PKRivalsSearchRankListView r27 = this.k;
        if (r27 == null) goto L61;
        List<Pair<IGroupRivals.GroupType, PKRivalsSearchRankListView>> r1 = this.h;
        ArrayList r2 = (ArrayList) r1;
        r2.add(TuplesKt.to(IGroupRivals.GroupType.GroupRivalsSearchPopularityRank, r27));
    L61:
        PKRivalsSearchRankListView r28 = this.l;
        if (r28 == null) goto L64;
        List<Pair<IGroupRivals.GroupType, PKRivalsSearchRankListView>> r3 = this.h;
        ArrayList r4 = (ArrayList) r3;
        r4.add(TuplesKt.to(IGroupRivals.GroupType.GroupRivalsSearchHourlyRank, r28));
    L64:
        ArrayList r29 = new ArrayList();
        Iterator r5 = ((ArrayList) this.h).iterator();
    L66:
        if (r5.hasNext() == false) goto L68;
        r29.add(((Pair) r5.next()).getFirst());
        goto L66
    L68:
        ((PKRivalsSearchRankTabColumn) ((Widget) this).contentView.findViewById(2131385559)).setupTabs(r29);
        ((Widget) this).contentView.findViewById(2131385560).setAdapter(this.j);
        ((Widget) this).contentView.findViewById(2131385560).addOnPageChangeListener(new AnonymousClass8(this));
        ((PKRivalsSearchRankTabColumn) ((Widget) this).contentView.findViewById(2131385559)).setOnPageSelectListener(new f(this));
        notifyDataSetChanged();
        ImageView r30 = this.b;
        if (r30 != null) goto L71;
        Intrinsics.throwUninitializedPropertyAccessException("mSearchIv");
    L71:
        r3.c(r30, s1.B(2131919654), true);
        return;
    L74:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.revlink.impl.pk.ui.PKRivalsSearchRankListView");
    L76:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.revlink.impl.pk.ui.PKRivalsSearchRankListView");
    L42:
        r20 = false;
        goto L43
    }

    public final void onLoad(Object[] r2) {
        this.r.d.observe(this, new g(this));
        this.r.g.observe(this, new h(this));
        this.r.h.observe(this, new i(this));
    }

    @Override // x31.j
    public final void onSearch(String r3) {
        Intrinsics.checkNotNullParameter(r3, "queryWord");
        Aq();
        Bq();
        View r0 = this.g;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mSearchBaseView");
    L5:
        r0.setVisibility(8);
        zq();
        EditText r1 = this.c;
        if (r1 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mSearchEt");
    L8:
        r1.setText(r3);
        this.a = true;
        EditText r4 = this.c;
        if (r4 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("mSearchEt");
    L11:
        r4.setCursorVisible(false);
        Disposable r5 = this.o;
        if (r5 != null) goto L14;
        return;
    L14:
        if (r5.isDisposed() == true) goto L18;
        r5.dispose();
        return;
    }

    @Override // com.bytedance.android.live.revlink.impl.pk.ui.PKRivalsSearchHistoryView.a
    public final void v8(String r9) {
        Intrinsics.checkNotNullParameter(r9, "words");
        this.r.j(r9, 0, 20, "", true, this.v);
        onSearch(r9);
        HashMap r10 = new HashMap();
        r10.put("pksearch_type", DataType.TRUE);
        boolean r1 = false;
        if (this.v.length() <= 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        String r2 = "activity";
    L9:
        r10.put("pk_description", r2);
        if (this.v.length() <= 0) goto L12;
        r1 = true;
    L12:
        String r3 = "";
        if (r1 == false) goto L15;
        String r4 = this.v;
    L16:
        r10.put("pk_activity_type", r4);
        d31.d r5 = com.bytedance.android.live.revlink.impl.global.b.c0();
        if (r5 == null) goto L20;
        String r6 = r5.a();
        if (r6 == null) goto L20;
    L21:
        r10.put("anchor_connect_status", r6);
        d31.d r7 = com.bytedance.android.live.revlink.impl.global.b.c0();
        if (r7 == null) goto L24;
        r3 = r7.s();
    L24:
        r10.put("room_status", r3);
        r10.put("source", this.w.b);
        mz0.n r8 = new mz0.n();
        Map<String, String> r12 = r8.a;
        Intrinsics.checkNotNullParameter(r12, "map");
        Intrinsics.checkNotNullParameter(r10, "map");
        r12.putAll(r10);
        mz0.m r13 = new mz0.m();
        r13.b(LogCommon.ROOM);
        List<Object> r14 = r8.b;
        ArrayList r15 = (ArrayList) r14;
        r15.addAll(r13.a);
        cy0.e.a.getClass();
        cy0.j r16 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r17 = com.bytedance.android.scope.m.b(r16).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r17);
        ((mz0.i) ((f80.a) r17)).w3("livesdk_pksearch_launch", r8.a, r8.b);
        return;
    L20:
        r6 = "";
        goto L21
    L15:
        r4 = "";
        goto L16
    L8:
        r2 = "routine";
        goto L9
    L5:
        r0 = false;
        goto L6
    }

    public static final void xq(PKRivalsPanelSearchWidget r6, IGroupRivals.GroupType r7) {
        if (r7 == r6.i) goto L39;
        List<Pair<IGroupRivals.GroupType, PKRivalsSearchRankListView>> r0 = r6.h;
        if ((r0 instanceof Collection) == true) goto L7;
    L9:
        Iterator r1 = ((ArrayList) r0).iterator();
    L11:
        if (r1.hasNext() == false) goto L18;
        if (((IGroupRivals.GroupType) ((Pair) r1.next()).getFirst()) != r7) goto L15;
        boolean r2 = true;
    L16:
        if (r2 == false) goto L11;
        boolean r3 = true;
    L19:
        if (r3 == false) goto L50;
        r6.i = r7;
        ((PKRivalsSearchRankTabColumn) ((Widget) r6).contentView.findViewById(2131385559)).a(r7);
        ViewPager r4 = ((Widget) r6).contentView.findViewById(2131385560);
        Iterator r5 = ((ArrayList) r6.h).iterator();
        int r8 = 0;
    L22:
        if (r5.hasNext() == false) goto L30;
        if (((IGroupRivals.GroupType) ((Pair) r5.next()).getFirst()) != r7) goto L26;
        boolean r9 = true;
    L27:
        if (r9 == true) goto L31;
        r8 = r8 + 1;
    L31:
        r4.setCurrentItem(r8, true);
        Iterator r10 = ((ArrayList) r6.h).iterator();
    L33:
        if (r10.hasNext() == false) goto L51;
        Pair r12 = (Pair) r10.next();
        PKRivalsSearchRankListView r13 = (PKRivalsSearchRankListView) r12.getSecond();
        if (((IGroupRivals.GroupType) r12.getFirst()) != r7) goto L37;
        boolean r14 = true;
    L38:
        r13.k = r14;
        r13.e();
        goto L33
    L37:
        r14 = false;
        goto L38
    L51:
        return;
    L26:
        r9 = false;
        goto L27
    L30:
        r8 = -1;
        goto L31
    L50:
        return;
    L15:
        r2 = false;
    L18:
        r3 = false;
        goto L19
    L7:
        if (((ArrayList) r0).isEmpty() == false) goto L9;
    }

    public static final void yq(PKRivalsPanelSearchWidget r5, int r6, List r7) {
        r5.getClass();
        if (r7 != null) goto L5;
        return;
    L5:
        if (r6 != 2) goto L14;
        PKRivalsSearchHistoryAdapter r0 = (PKRivalsSearchHistoryAdapter) r5.m.getValue();
        EditText r2 = r5.c;
        if (r2 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("mSearchEt");
    L9:
        int r3 = r2.getText().length();
        String r4 = r5.v;
        r0.getClass();
        Intrinsics.checkNotNullParameter(r7, "historyList");
        Intrinsics.checkNotNullParameter(r4, "activityName");
        r0.a = r6;
        ((ArrayList) r0.b).clear();
        ArrayList r8 = (ArrayList) r0.b;
        r8.addAll(r7);
        r0.c = r3;
        r0.d = r4;
        ((PKRivalsSearchHistoryAdapter) r5.m.getValue()).notifyDataSetChanged();
        RecyclerView r9 = r5.e;
        if (r9 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("mSearchHistoryList");
    L12:
        r9.setVisibility(0);
        return;
    L14:
        if (r6 != 1) goto L31;
        PKRivalsSearchHistoryView r10 = r5.f;
        if (r10 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("mSearchHistoryView");
    L18:
        r10.setData(r7);
        View r12 = r5.g;
        if (r12 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("mSearchBaseView");
    L21:
        r12.setVisibility(0);
        if (r7.isEmpty() == true) goto L27;
        PKRivalsSearchHistoryView r13 = r5.f;
        if (r13 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("mSearchHistoryView");
    L26:
        r13.setVisibility(0);
        return;
    L27:
        r5.Bq();
        return;
    }

    public static final Pair wq(PKRivalsPanelSearchWidget r2, IRivalRankRecommendResponse r3, String r4, IGroupRivals.GroupType r5) {
        r2.getClass();
        if (r3 == null) goto L15;
        s2 r6 = r3.getTabRivals();
        if (r6 == null) goto L15;
        Map r7 = r6.getGroupRivals();
        if (r7 == null) goto L15;
        IGroupRivals r8 = (IGroupRivals) r7.get(Long.valueOf(r5.ordinal()));
        if (r8 == null) goto L15;
        String r9 = r8.getGroupName();
        if (r9 == null) goto L17;
        if (TextUtils.isEmpty(r9) == true) goto L17;
        r4 = r9;
    L17:
        return TuplesKt.to(r4, r8);
    L15:
        r8 = null;
        goto L17
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [com.bytedance.android.live.revlink.impl.pk.dialog.fragment.PKRivalsPanelSearchWidget$mRivalsRankListViewsAdapter$1] */
    public PKRivalsPanelSearchWidget(com.bytedance.android.live.revlink.impl.pk.dialog.presenter.j r2, r r3, View r4, boolean r5, String r6, u r7) {
        Intrinsics.checkNotNullParameter(r2, "mPresenter");
        Intrinsics.checkNotNullParameter(r3, "mDialog");
        Intrinsics.checkNotNullParameter(r4, "mTopView");
        Intrinsics.checkNotNullParameter(r6, "mActivityName");
        Intrinsics.checkNotNullParameter(r7, "searchSource");
        this.r = r2;
        this.s = r3;
        this.t = r4;
        this.u = r5;
        this.v = r6;
        this.w = r7;
        this.h = new ArrayList();
        this.j = new PKRivalsPanelSearchWidget$mRivalsRankListViewsAdapter$1(this);
        LazyThreadSafetyMode r8 = LazyThreadSafetyMode.NONE;
        this.m = LazyKt.lazy(r8, new PKRivalsPanelSearchWidget$mHistoryAdapter$2(this));
        this.n = new ArrayList();
        this.p = LazyKt.lazy(r8, new PKRivalsPanelSearchWidget$mTextChangeListener$2(this));
        this.q = LazyKt.lazy(r8, new PKRivalsPanelSearchWidget$mOnEtTouchListener$2(this));
    }
}
