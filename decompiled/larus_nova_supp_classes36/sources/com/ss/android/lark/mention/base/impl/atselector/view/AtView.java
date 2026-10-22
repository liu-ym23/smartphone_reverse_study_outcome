package com.ss.android.lark.mention.base.impl.atselector.view;

import android.content.Context;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.larksuite.framework.mvp.IView;
import com.larksuite.framework.ui.stickyheader.AnimationFixStickyRecyclerHeadersDecoration;
import com.larksuite.framework.utils.ExternalKeyboardUtils;
import com.larksuite.framework.utils.KeyboardUtils;
import com.larksuite.framework.utils.UIUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.appreciablelib.AppreciableKit;
import com.ss.android.lark.featuregating.FeatureGatingModule;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.mention.base.impl.atselector.IItemContainer;
import com.ss.android.lark.mention.base.impl.atselector.bean.BaseAtBean;
import com.ss.android.lark.mention.base.impl.atselector.view.adapter.AtHeaderSelectedAdapter;
import com.ss.android.lark.mention.base.impl.atselector.view.adapter.AtSelectAdapter;
import com.ss.android.lark.mention.base.impl.atselector.view.tracker.VisibilityScrollListener;
import com.ss.android.lark.mention.base.impl.statistics.MentionBoardHitPoint;
import com.ss.android.lark.picker.base.view.keyboard.KeyboardSelectionHelperKt;
import com.ss.android.lark.ui.CommonTitleBar;
import com.ss.android.lark.ui.CommonTitleBarConstants;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.utils.y0;
import com.ss.android.lark.widget.ChatWindowPtrLoadingHeader;
import com.ss.android.lark.widget.ptr.LKUIPtrClassicFrameLayout;
import com.ss.android.lark.widget.quick_sidebar.QuickSideBarTipsView;
import com.ss.android.lark.widget.quick_sidebar.QuickSideBarView;
import com.suite.lark.emm.design.edittext.SCEditText;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.channels.SendChannel;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public class AtView implements com.ss.android.lark.mention.base.impl.atselector.e, m {
    public static final Long o = null;
    public TextView a;
    public final Context b;
    public final e c;
    public AtSelectAdapter d;
    public AtSelectAdapter e;
    public AtHeaderSelectedAdapter f;
    public final HashMap<String, Integer> g;
    public int h;
    public com.ss.android.lark.mention.base.impl.atselector.e.a i;
    public frb.a j;
    public final b k;
    public final c l;
    public n m;

    @BindView(9726)
    View mLoadEmptyView;

    @BindView(9560)
    LKUIPtrClassicFrameLayout mPtrFrame;

    @BindView(9992)
    View mQuickSideBarCover;

    @BindView(9990)
    QuickSideBarTipsView mQuickSideBarTipView;

    @BindView(9991)
    QuickSideBarView mQuickSideBarView;

    @BindView(9253)
    RecyclerView mRecommendRecyclerView;

    @BindView(10006)
    LinearLayout mRecyclerViewLayout;

    @BindView(10087)
    LinearLayout mSearchBar;

    @BindView(10253)
    TextView mSearchEmptyHintTV;

    @BindView(10097)
    SCEditText mSearchEt;

    @BindView(10110)
    RecyclerView mSearchResultRV;

    @BindView(9086)
    LinearLayout mSelectAtLayout;

    @BindView(10116)
    RecyclerView mSelectedRV;

    @BindView(10290)
    CommonTitleBar mTitleBar;
    public final a n;

    public class a implements TextWatcher {
        public final /* synthetic */ AtView a;

        @Override // android.text.TextWatcher
        public final void beforeTextChanged(CharSequence r1, int r2, int r3, int r4) {
        }

        @Override // android.text.TextWatcher
        public final void onTextChanged(CharSequence r1, int r2, int r3, int r4) {
        }

        public a(AtView r1) {
            this.a = r1;
        }

        @Override // android.text.TextWatcher
        public final void afterTextChanged(Editable r9) {
            AtView r0 = this.a;
            n r1 = r0.m;
            if (r1 == null) goto L5;
            String r10 = r9.toString();
            r1.getClass();
            Intrinsics.checkNotNullParameter(r10, "text");
            BuildersKt.launch$default(r1.a, null, null, new TextChangeDebounceHelper$onTextChanged$1(r1, r10, null), 3, null);
            return;
        L5:
            r0.k(r9.toString());
        }
    }

    public class b implements IItemContainer.a {
        public final /* synthetic */ AtView a;

        public b(AtView r1) {
            this.a = r1;
        }

        @Override // com.ss.android.lark.mention.base.impl.atselector.IItemContainer.a
        public final void a(BaseAtBean r2) {
            this.a.i.u4(r2);
        }

        @Override // com.ss.android.lark.mention.base.impl.atselector.IItemContainer.a
        public final void b(BaseAtBean r2) {
            this.a.i.l8(r2);
        }

        @Override // com.ss.android.lark.mention.base.impl.atselector.IItemContainer.a
        public final void c(BaseAtBean r2) {
            this.a.i.l1(r2);
        }
    }

    public class c implements AtHeaderSelectedAdapter.a {
        public final /* synthetic */ AtView a;

        public c(AtView r1) {
            this.a = r1;
        }
    }

    public class d implements Runnable {
        public final /* synthetic */ AtView a;

        @Override // java.lang.Runnable
        public final void run() {
            this.a.mRecyclerViewLayout.setVisibility(8);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public d(AtView r1) {
            this.a = r1;
        }
    }

    public interface e {
        void a(AtView r1);

        void b(com.ss.android.lark.mention.base.impl.atselector.bean.d r1);

        void showToast(String r1);

        void y();
    }

    static {
        o = 300L;
    }

    public final void create() {
        this.c.a(this);
        String r0 = com.ss.android.lark.mention.base.impl.statistics.a.a;
        AppreciableKit.Companion r1 = AppreciableKit.Companion;
        r1.getInstance().spanStart(com.ss.android.lark.mention.base.impl.statistics.a.a, "init_view_cost");
        this.mTitleBar.setTitle(2131892269);
        this.mTitleBar.setLeftTextOnly(CommonTitleBarConstants.TEXT_CANCEL);
        this.mTitleBar.addAction(new g(this, UIUtils.getString(this.b, 2131892181)));
        this.mTitleBar.setLeftClickListener(new h(this));
        TextView r2 = this.mTitleBar.getRightText();
        this.a = r2;
        r2.setPadding(0, 0, UIUtils.dp2px(this.b, 15.0f), 0);
        LinearLayoutManager r3 = new LinearLayoutManager(this.b, 1, false);
        this.mRecommendRecyclerView.setLayoutManager(r3);
        this.mRecommendRecyclerView.getItemAnimator().setSupportsChangeAnimations(false);
        this.mRecommendRecyclerView.getItemAnimator().setRemoveDuration(0);
        this.mRecommendRecyclerView.getItemAnimator().setAddDuration(0);
        this.mRecyclerViewLayout.setVisibility(8);
        AtSelectAdapter r4 = new AtSelectAdapter();
        this.d = r4;
        r4.b = 0;
        r4.notifyItemRangeChanged(0, r4.getItemCount());
        AtSelectAdapter r5 = this.d;
        r5.c = this.k;
        this.mRecommendRecyclerView.setAdapter(r5);
        AnimationFixStickyRecyclerHeadersDecoration r6 = new AnimationFixStickyRecyclerHeadersDecoration(this.d);
        this.mRecommendRecyclerView.addItemDecoration(r6);
        LinearLayoutManager r7 = new LinearLayoutManager(this.b, 1, false);
        this.mSearchResultRV.setLayoutManager(r7);
        this.e = new AtSelectAdapter();
        this.mSearchResultRV.getItemAnimator().setSupportsChangeAnimations(false);
        this.mSearchResultRV.setAdapter(this.e);
        AtSelectAdapter r8 = this.e;
        r8.c = this.k;
        AtHeaderSelectedAdapter r9 = new AtHeaderSelectedAdapter();
        this.f = r9;
        r9.b = this.l;
        this.mSelectedRV.setLayoutManager(new LinearLayoutManager(this.b, 0, false));
        this.mSelectedRV.setAdapter(this.f);
        com.ss.android.lark.mention.base.impl.atselector.e.a r10 = this.i;
        if (r10 != null) goto L5;
    L15:
        ChatWindowPtrLoadingHeader r11 = new ChatWindowPtrLoadingHeader(this.b);
        this.mPtrFrame.setKeepHeaderWhenRefresh(true);
        this.mPtrFrame.setFooterView(r11);
        this.mPtrFrame.addPtrUIHandler(r11);
        this.mPtrFrame.disableWhenHorizontalMove(true);
        this.mPtrFrame.setPtrHandler(new i(this));
        this.mQuickSideBarView.setVisibility(8);
        this.mQuickSideBarCover.setVisibility(0);
        r1.getInstance().spanEnd(com.ss.android.lark.mention.base.impl.statistics.a.a, "init_view_cost");
        this.mQuickSideBarView.setOnQuickSideBarTouchListener(new j(this));
        this.mRecommendRecyclerView.addOnScrollListener(new k(this));
        this.mSearchBar.setOnClickListener(new l(this));
        this.mSearchEt.setOnFocusChangeListener(new com.ss.android.lark.mention.base.impl.atselector.view.a(this));
        this.mSearchEt.addTextChangedListener(this.n);
        int r12 = com.ss.android.lark.mention.base.a.a;
        if (FeatureGatingModule.getFeatureGatingService().isEnable("core.picker.search_by_pinyin") == false) goto L18;
        this.mSearchEt.setImeOptions(3);
    L18:
        this.mSearchResultRV.addOnScrollListener(new f(this));
        if (FeatureGatingModule.getFeatureGatingService().isEnable("core.mention.disable_search_debounce") == true) goto L22;
        Log.i("AtView", "initDebounceHelper");
        long r13 = o.longValue();
        int r14 = n.f;
        Intrinsics.checkNotNullParameter(this, "onDebouncedTextChange");
        CoroutineScope r15 = CoroutineScopeKt.CoroutineScope(Dispatchers.getMain().plus(SupervisorKt.SupervisorJob$default(null, 1, null)));
        n r16 = new n(r15, r13, this);
        r16.e = BuildersKt.launch$default(r15, null, null, new TextChangeDebounceHelper$startDebounceCollection$1(r16, null), 3, null);
        this.m = r16;
        return;
    L22:
        return;
    L5:
        if (r10.V0() == false) goto L15;
        String r17 = "";
        if (this.i.n6() != null) goto L9;
        String r18 = "";
    L10:
        frb.a r19 = new frb.a(r18, false);
        this.j = r19;
        this.mRecommendRecyclerView.addOnScrollListener(new VisibilityScrollListener(r19));
        if (this.i.n6() == null) goto L14;
        r17 = this.i.n6();
    L14:
        int r20 = com.ss.android.lark.mention.base.a.a;
        frb.a r21 = new frb.a(r17, FeatureGatingModule.getFeatureGatingService().isEnable("lark.myai.new_qa_im_at_ai_fix_mention_searchpanel"));
        this.mSearchResultRV.addOnScrollListener(new VisibilityScrollListener(r21));
        goto L15
    L9:
        r18 = this.i.n6();
        goto L10
    }

    public final void destroy() {
        SCEditText r0 = this.mSearchEt;
        if (r0 == null) goto L5;
        r0.removeTextChangedListener(this.n);
    L5:
        n r1 = this.m;
        if (r1 == null) goto L12;
        Job r2 = r1.e;
        if (r2 == null) goto L10;
        Job.DefaultImpls.cancel$default(r2, null, 1, null);
    L10:
        SendChannel.a.a(r1.d);
        CoroutineScopeKt.cancel$default(r1.a, null, 1, null);
    L12:
        if (this.j == null) goto L15;
        ((LinkedHashMap) frb.a.e).clear();
        ((LinkedHashMap) frb.a.f).clear();
        return;
    }

    @Override // com.ss.android.lark.mention.base.impl.atselector.e
    public final void o7() {
        this.mPtrFrame.refreshComplete();
        String r0 = UIHelper.getString(2131892008);
        this.c.showToast(r0);
    }

    public final void s() {
        if (this.mSearchResultRV.getVisibility() != 0) goto L7;
        if (this.mRecommendRecyclerView.getVisibility() == 0) goto L7;
    L8:
        KeyboardSelectionHelperKt.enableKeyboardNavigation(this.mSearchResultRV, this.e, this.mSearchEt);
        return;
    L7:
        if (TextUtils.isEmpty(this.mSearchEt.getText().toString().trim()) == false) goto L8;
        KeyboardSelectionHelperKt.enableKeyboardNavigation(this.mRecommendRecyclerView, this.d, this.mSearchEt);
    }

    @Override // com.ss.android.lark.mention.base.impl.atselector.e
    public final int y0() {
        return this.h;
    }

    @Override // com.ss.android.lark.mention.base.impl.atselector.e
    public final void G8(List<BaseAtBean> r2) {
        AtSelectAdapter r0 = this.d;
        if (r0 == null) goto L7;
        if (r2 == null) goto L8;
        r0.resetSelectPosition();
        this.d.diff(r2);
        this.d.d = true;
        return;
    L8:
        return;
    }

    @Override // com.ss.android.lark.mention.base.impl.atselector.e
    public final void S3(List<BaseAtBean> r2) {
        AtSelectAdapter r0 = this.e;
        if (r0 == null) goto L7;
        if (r2 == null) goto L8;
        r0.resetSelectPosition();
        this.e.resetAll(r2);
        this.e.d = true;
        return;
    L8:
        return;
    }

    @Override // com.ss.android.lark.mention.base.impl.atselector.e
    public final void T5(Map<String, BaseAtBean> r4) {
        int r0 = (this.h + 1) % 2;
        this.h = r0;
        AtSelectAdapter r1 = this.d;
        if (r1 == null) goto L5;
        r1.b = r0;
        r1.notifyItemRangeChanged(0, r1.getItemCount());
        o(r4);
    L5:
        AtSelectAdapter r5 = this.e;
        if (r5 == null) goto L9;
        r5.b = this.h;
        r5.notifyItemRangeChanged(0, r5.getItemCount());
        return;
    }

    @Override // com.ss.android.lark.mention.base.impl.atselector.view.m
    public final void h(String r1) {
        k(r1);
    }

    @Override // com.ss.android.lark.mention.base.impl.atselector.e
    public final void j1(com.ss.android.lark.mention.base.impl.atselector.bean.d r2) {
        KeyboardUtils.hideKeyboard(this.b);
        this.c.b(r2);
    }

    public final void k(String r4) {
        if (TextUtils.isEmpty(r4) == false) goto L5;
        Log.i("AtView", "handleTextChange clearSearchResult");
        this.e.clear();
        this.e.d = true;
        this.mSearchResultRV.setVisibility(4);
        this.mPtrFrame.setVisibility(4);
        this.mQuickSideBarView.setVisibility(0);
        this.mQuickSideBarCover.setVisibility(8);
        this.mLoadEmptyView.setVisibility(8);
        this.mQuickSideBarTipView.setVisibility(8);
        this.mRecommendRecyclerView.setVisibility(0);
        s();
        return;
    L5:
        Log.i("AtView", "handleTextChange: " + r4.length());
        this.i.onSearch(r4);
    }

    public final void o(Map<String, BaseAtBean> r4) {
        if (this.h == 1) goto L5;
        this.a.setText(2131892181);
        if (this.d == null) goto L17;
        this.i.b6();
        return;
    L17:
        return;
    L5:
        if (r4.isEmpty() == false) goto L7;
        this.a.setText(2131892187);
        this.a.setTextColor(UDColorUtils.getColor(this.b, 2131106622));
    L9:
        if (this.d == null) goto L15;
        this.i.f6();
        return;
    L15:
        return;
    L7:
        this.a.setText(UIHelper.mustacheFormat(2131892073, "count", Integer.toString(r4.size())));
        this.a.setTextColor(UDColorUtils.getColor(this.b, 2131105548));
        goto L9
    }

    @Override // com.ss.android.lark.mention.base.impl.atselector.e
    public final void o3(String r7) {
        this.mPtrFrame.refreshComplete();
        if (r7.equals(this.mSearchEt.getText().toString().trim()) == true) goto L5;
        return;
    L5:
        this.e.clear();
        this.e.d = true;
        this.mSearchResultRV.setVisibility(4);
        this.mPtrFrame.setVisibility(4);
        this.mRecommendRecyclerView.setVisibility(4);
        this.mLoadEmptyView.setVisibility(0);
        s();
        String r0 = UIHelper.mustacheFormat(2131892028, "search_key", r7);
        int r2 = r0.indexOf("'");
        int r1 = r0.lastIndexOf("'");
        TextView r3 = this.mSearchEmptyHintTV;
        r3.setText(y0.b(r0, r2, r1, r7, y9c.d.c(r3.getContext(), 2131102125)));
    }

    @Override // com.ss.android.lark.mention.base.impl.atselector.e
    public final void p1(List<BaseAtBean> r5) {
        this.g.clear();
        p(false, r5);
        this.d.resetSelectPosition();
        this.d.resetAll(r5);
        this.d.d = true;
        int r1 = com.ss.android.lark.mention.base.a.a;
        if (FeatureGatingModule.getFeatureGatingService().isEnable("core.mention.show_recommend_when_select") == false) goto L5;
        this.mRecommendRecyclerView.setVisibility(0);
    L5:
        s();
        this.mRecommendRecyclerView.post(new com.ss.android.lark.mention.base.impl.atselector.view.b());
        fsb.f.b().f(this.mRecommendRecyclerView);
        MentionBoardHitPoint.b(true, r5);
        com.ss.android.lark.mention.base.impl.atselector.e.a r6 = this.i;
        if (r6 != null) goto L8;
        return;
    L8:
        if (r6.V0() == false) goto L15;
        frb.a r7 = this.j;
        if (r7 == null) goto L16;
        r7.d = false;
        ((LinkedHashMap) frb.a.e).clear();
        ((LinkedHashMap) frb.a.f).clear();
        this.mRecommendRecyclerView.post(new com.ss.android.lark.mention.base.impl.atselector.view.d(this));
        return;
    L16:
        return;
    }

    @Override // com.ss.android.lark.mention.base.impl.atselector.e
    public final void s4(int r4) {
        AtSelectAdapter r0 = this.e;
        if (r0 == null) goto L6;
        r0.notifyItemRangeChanged(0, r4, "sensitiveInfo");
        return;
    }

    public final void setViewDelegate(IView.IViewDelegate r1) {
        this.i = (com.ss.android.lark.mention.base.impl.atselector.e.a) r1;
    }

    public AtView(Context r2, e r3) {
        this.g = new HashMap();
        this.h = 0;
        this.k = new b(this);
        this.l = new c(this);
        this.n = new a(this);
        this.b = r2;
        this.c = r3;
        if (aoc.b.a() == false) goto L6;
        Boolean r4 = ExternalKeyboardUtils.a;
        ExternalKeyboardUtils.c(new com.ss.android.lark.mention.base.impl.atselector.view.c());
        return;
    }

    @Override // com.ss.android.lark.mention.base.impl.atselector.e
    public final void D4(Map<String, BaseAtBean> r3, boolean r4) {
        o(r3);
        if (r3.isEmpty() == false) goto L5;
        this.f.diff(r3.values());
        this.mRecyclerViewLayout.post(new d(this));
        return;
    L5:
        this.mRecyclerViewLayout.setVisibility(0);
        this.f.diff(r3.values());
        if (r4 == false) goto L10;
        this.mSelectedRV.getLayoutManager().scrollToPosition(this.f.getItemCount() - 1);
        return;
    }

    @Override // com.ss.android.lark.mention.base.impl.atselector.e
    public final void E8(String r4, List<BaseAtBean> r5) {
        this.mPtrFrame.refreshComplete();
        if (r4.equals(this.mSearchEt.getText().toString().trim()) == true) goto L5;
        return;
    L5:
        p(true, r5);
        this.mSearchResultRV.scrollToPosition(0);
        this.mPtrFrame.setVisibility(0);
        this.mLoadEmptyView.setVisibility(8);
        this.mSearchResultRV.setVisibility(0);
        this.mQuickSideBarTipView.setVisibility(8);
        this.mQuickSideBarView.setVisibility(8);
        this.mRecommendRecyclerView.setVisibility(8);
        this.e.resetSelectPosition();
        this.e.resetAll(r5);
        this.e.d = true;
        s();
        MentionBoardHitPoint.b(false, r5);
    }

    public final void p(boolean r8, List<BaseAtBean> r9) {
        if (r8 == true) goto L16;
        ArrayList r10 = new ArrayList();
        Iterator<BaseAtBean> r11 = r9.iterator();
        int r2 = 0;
    L6:
        if (r11.hasNext() == false) goto L15;
        BaseAtBean r3 = r11.next();
        if (r3 == null) goto L14;
        if (r3.getType() != 0) goto L14;
        String r4 = String.valueOf(r3.getPinyin());
        if (this.g.containsKey(r4.toUpperCase()) == true) goto L14;
        this.g.put(r4.toUpperCase(), Integer.valueOf(r2));
        r10.add(r4.toUpperCase());
    L14:
        r2 = r2 + 1;
        goto L6
    L15:
        this.mQuickSideBarView.setLetters(r10);
        this.mQuickSideBarView.setVisibility(0);
        this.mQuickSideBarCover.setVisibility(8);
        return;
    L16:
        this.mQuickSideBarView.setVisibility(8);
        this.mQuickSideBarCover.setVisibility(0);
    }
}
