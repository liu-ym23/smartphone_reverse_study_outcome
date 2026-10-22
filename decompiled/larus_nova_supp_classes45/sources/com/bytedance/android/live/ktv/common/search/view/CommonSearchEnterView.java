package com.bytedance.android.live.ktv.common.search.view;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.IBinder;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.ContextUtil;
import com.bytedance.android.live.core.utils.ListUtils;
import com.bytedance.android.live.core.utils.SpannableStringUtils;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.ktv.common.model.api.s;
import com.bytedance.android.live.ktv.common.model.api.t;
import com.bytedance.android.live.ktv.common.model.api.u;
import com.bytedance.android.live.ktv.common.ordersong.theme.KtvOrderSongThemeManager;
import com.bytedance.android.live.ktv.common.ordersong.view.KtvPullLoadingAnimView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002:\u0001QB'\b\u0007\u0012\u0006\u0010J\u001a\u00020I\u0012\n\b\u0002\u0010L\u001a\u0004\u0018\u00010K\u0012\b\b\u0002\u0010N\u001a\u00020M¢\u0006\u0004\bO\u0010PJ\u0012\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0016\u0010\f\u001a\u00020\u00052\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\nH\u0016J\b\u0010\u000e\u001a\u00020\rH\u0016R\u001d\u0010\u0014\u001a\u0004\u0018\u00010\u000f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u001d\u0010\u0019\u001a\u0004\u0018\u00010\u00158BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0011\u001a\u0004\b\u0017\u0010\u0018R\u001d\u0010\u001d\u001a\u0004\u0018\u00010\u00038BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u0011\u001a\u0004\b\u001b\u0010\u001cR\u001d\u0010\"\u001a\u0004\u0018\u00010\u001e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001f\u0010\u0011\u001a\u0004\b \u0010!R\u001d\u0010%\u001a\u0004\u0018\u00010\u00038BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b#\u0010\u0011\u001a\u0004\b$\u0010\u001cR\u001d\u0010*\u001a\u0004\u0018\u00010&8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b'\u0010\u0011\u001a\u0004\b(\u0010)R\u001d\u0010-\u001a\u0004\u0018\u00010\u00158BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b+\u0010\u0011\u001a\u0004\b,\u0010\u0018R\u001d\u00102\u001a\u0004\u0018\u00010.8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b/\u0010\u0011\u001a\u0004\b0\u00101R\u001d\u00105\u001a\u0004\u0018\u00010.8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b3\u0010\u0011\u001a\u0004\b4\u00101R\u001d\u00109\u001a\u0004\u0018\u00010\u00018BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b6\u0010\u0011\u001a\u0004\b7\u00108R\u001d\u0010>\u001a\u0004\u0018\u00010:8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b;\u0010\u0011\u001a\u0004\b<\u0010=R\u001b\u0010C\u001a\u00020?8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b@\u0010\u0011\u001a\u0004\bA\u0010BR\u001b\u0010H\u001a\u00020D8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bE\u0010\u0011\u001a\u0004\bF\u0010G¨\u0006R"}, d2 = {"Lcom/bytedance/android/live/ktv/common/search/view/CommonSearchEnterView;", "Landroid/widget/FrameLayout;", "", "Landroid/view/View;", "searchResultView", "", "setSearchResultView", "Lcom/bytedance/android/live/ktv/common/search/view/q;", "outerCallback", "setOuterCallback", "Lkotlin/Function0;", "cancelAction", "setCancelAction", "", "getSearchStartTime", "Landroid/widget/TextView;", "f", "Lkotlin/Lazy;", "getTvCancel", "()Landroid/widget/TextView;", "tvCancel", "Landroidx/constraintlayout/widget/ConstraintLayout;", "g", "getSearchBar", "()Landroidx/constraintlayout/widget/ConstraintLayout;", "searchBar", "h", "getBtnKtvSearch", "()Landroid/view/View;", "btnKtvSearch", "Landroid/widget/EditText;", "i", "getEtSearch", "()Landroid/widget/EditText;", "etSearch", "j", "getBtnClear", "btnClear", "Landroidx/recyclerview/widget/RecyclerView;", "k", "getSearchGuessWord", "()Landroidx/recyclerview/widget/RecyclerView;", "searchGuessWord", "l", "getHistoryHotWord", "historyHotWord", "Lcom/bytedance/android/live/ktv/common/search/view/CommonHotWordHistoryView;", "m", "getSearchHistory", "()Lcom/bytedance/android/live/ktv/common/search/view/CommonHotWordHistoryView;", "searchHistory", "n", "getHotWord", "hotWord", "o", "getSearchLoadingContainer", "()Landroid/widget/FrameLayout;", "searchLoadingContainer", "Lcom/bytedance/android/live/ktv/common/ordersong/view/KtvPullLoadingAnimView;", "p", "getSearchLoadingAnim", "()Lcom/bytedance/android/live/ktv/common/ordersong/view/KtvPullLoadingAnimView;", "searchLoadingAnim", "Lcom/bytedance/android/live/ktv/common/search/view/CommonSearchGuessWordAdapter;", "r", "getCommonSearchGuessWordAdapter", "()Lcom/bytedance/android/live/ktv/common/search/view/CommonSearchGuessWordAdapter;", "commonSearchGuessWordAdapter", "Landroid/text/TextWatcher;", "s", "getTextWatch", "()Landroid/text/TextWatcher;", "textWatch", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyle", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "livektv-common_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class CommonSearchEnterView extends FrameLayout {
    public static final /* synthetic */ int v = 0;
    public q a;
    public final String b;
    public int c;
    public long d;
    public View e;
    public final Lazy f;
    public final Lazy g;
    public final Lazy h;
    public final Lazy i;
    public final Lazy j;
    public final Lazy k;
    public final Lazy l;
    public final Lazy m;
    public final Lazy n;
    public final Lazy o;
    public final Lazy p;
    public com.bytedance.android.live.ktv.common.search.viewmodel.a q;
    public final Lazy r;
    public final Lazy s;
    public Function0<Unit> t;
    public final boolean u;

    public static final class a {
    }

    static {
    }

    public CommonSearchEnterView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public CommonSearchEnterView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    private final View getBtnClear() {
        return (View) this.j.getValue();
    }

    private final View getBtnKtvSearch() {
        return (View) this.h.getValue();
    }

    private final CommonSearchGuessWordAdapter getCommonSearchGuessWordAdapter() {
        return (CommonSearchGuessWordAdapter) this.r.getValue();
    }

    private final EditText getEtSearch() {
        return (EditText) this.i.getValue();
    }

    private final ConstraintLayout getHistoryHotWord() {
        return (ConstraintLayout) this.l.getValue();
    }

    private final CommonHotWordHistoryView getHotWord() {
        return (CommonHotWordHistoryView) this.n.getValue();
    }

    private final ConstraintLayout getSearchBar() {
        return (ConstraintLayout) this.g.getValue();
    }

    private final RecyclerView getSearchGuessWord() {
        return (RecyclerView) this.k.getValue();
    }

    private final CommonHotWordHistoryView getSearchHistory() {
        return (CommonHotWordHistoryView) this.m.getValue();
    }

    private final KtvPullLoadingAnimView getSearchLoadingAnim() {
        return (KtvPullLoadingAnimView) this.p.getValue();
    }

    private final FrameLayout getSearchLoadingContainer() {
        return (FrameLayout) this.o.getValue();
    }

    private final TextWatcher getTextWatch() {
        return (TextWatcher) this.s.getValue();
    }

    private final TextView getTvCancel() {
        return (TextView) this.f.getValue();
    }

    public final void g() {
        if (this.c == 4) goto L5;
        i(4);
    L5:
        EditText r0 = getEtSearch();
        if (r0 == null) goto L10;
        CharSequence r1 = r0.getHint();
        if (r1 == null) goto L10;
        String r2 = r1.toString();
    L12:
        if ((!Intrinsics.areEqual(r2, this.b)) == false) goto L16;
        EditText r3 = getEtSearch();
        if (r3 == null) goto L16;
        r3.setHint(this.b);
    L16:
        e();
        return;
    L10:
        r2 = null;
        goto L12
    }

    public final void e() {
        Activity r0 = ContextUtil.contextToActivity(getContext());
        IBinder r1 = null;
        if (r0 == null) goto L5;
        Object r2 = r0.getSystemService("input_method");
    L7:
        if ((r2 instanceof InputMethodManager) == false) goto L18;
        EditText r3 = getEtSearch();
        if (r3 == null) goto L11;
        IBinder r4 = r3.getWindowToken();
    L12:
        if (r4 == null) goto L19;
        InputMethodManager r5 = (InputMethodManager) r2;
        EditText r6 = getEtSearch();
        if (r6 == null) goto L16;
        r1 = r6.getWindowToken();
    L16:
        r5.hideSoftInputFromWindow(r1, 0);
        return;
    L19:
        return;
    L11:
        r4 = null;
        goto L12
    L18:
        return;
    L5:
        r2 = null;
        goto L7
    }

    public final void f() {
        EditText r0 = getEtSearch();
        if (r0 == null) goto L5;
        r0.requestFocus();
    L5:
        Activity r1 = ContextUtil.contextToActivity(getContext());
        if (r1 == null) goto L8;
        Object r2 = r1.getSystemService("input_method");
    L10:
        if ((r2 instanceof InputMethodManager) == false) goto L15;
        EditText r3 = getEtSearch();
        if (r3 == null) goto L16;
        ((InputMethodManager) r2).showSoftInput(r3, 0);
        return;
    L16:
        return;
    L15:
        return;
    L8:
        r2 = null;
        goto L10
    }

    public long getSearchStartTime() {
        return this.d;
    }

    public static final /* synthetic */ View a(CommonSearchEnterView r0) {
        return r0.getBtnClear();
    }

    public static final /* synthetic */ EditText b(CommonSearchEnterView r0) {
        return r0.getEtSearch();
    }

    public final void d(String r2) {
        EditText r0 = getEtSearch();
        if (r0 == null) goto L8;
        if (r2 != null) goto L7;
        r2 = this.b;
    L7:
        r0.setHint(r2);
    L8:
        EditText r3 = getEtSearch();
        if (r3 == null) goto L11;
        r3.setCursorVisible(true);
    L11:
        i(1);
        if (this.c == 1) goto L14;
        i(1);
    L14:
        com.bytedance.android.live.ktv.common.search.viewmodel.a r4 = this.q;
        if (r4 == null) goto L17;
        r4.syncHotWords();
    L17:
        com.bytedance.android.live.ktv.common.search.viewmodel.a r5 = this.q;
        if (r5 == null) goto L20;
        r5.loadSearchHistory();
    L20:
        f();
        TextView r6 = getTvCancel();
        if (r6 == null) goto L24;
        r6.setVisibility(0);
        return;
    }

    public final void i(int r7) {
        int r0 = this.c;
        if (r0 != 4) goto L8;
        if (r7 == r0) goto L8;
        q r1 = this.a;
        if (r1 == null) goto L8;
        r1.onSearchReset();
    L8:
        boolean r2 = true;
        if (r7 != 1) goto L13;
        com.bytedance.android.live.ktv.common.search.viewmodel.a r3 = this.q;
        if (r3 == null) goto L13;
        r3.loadSearchHistory();
    L13:
        this.c = r7;
        RecyclerView r4 = getSearchGuessWord();
        if (r4 != null) goto L16;
    L20:
        ConstraintLayout r5 = getHistoryHotWord();
        if (r5 == null) goto L26;
        if (r7 != 1) goto L24;
        int r6 = 0;
    L25:
        r5.setVisibility(r6);
        goto L26
    L24:
        r6 = 8;
    L26:
        View r8 = this.e;
        if (r8 == null) goto L33;
        if (r7 != 4) goto L30;
        int r9 = 0;
    L31:
        r8.setVisibility(r9);
        goto L33
    L30:
        r9 = 8;
    L33:
        if (r7 == 3) goto L36;
        r2 = false;
    L36:
        if (r2 == false) goto L46;
        FrameLayout r11 = getSearchLoadingContainer();
        if (r11 == null) goto L40;
        r11.setVisibility(0);
    L40:
        KtvPullLoadingAnimView r12 = getSearchLoadingAnim();
        if (r12 == null) goto L43;
        r12.setVisibility(0);
    L43:
        KtvPullLoadingAnimView r13 = getSearchLoadingAnim();
        if (r13 == null) goto L56;
        r13.R5();
        return;
    L56:
        return;
    L46:
        KtvPullLoadingAnimView r14 = getSearchLoadingAnim();
        if (r14 == null) goto L49;
        r14.setVisibility(8);
    L49:
        KtvPullLoadingAnimView r15 = getSearchLoadingAnim();
        if (r15 == null) goto L52;
        r15.S5();
    L52:
        FrameLayout r16 = getSearchLoadingContainer();
        if (r16 == null) goto L58;
        r16.setVisibility(8);
        return;
    L58:
        return;
    L16:
        if (r7 != 2) goto L18;
        int r17 = 0;
    L19:
        r4.setVisibility(r17);
        goto L20
    L18:
        r17 = 8;
        goto L19
    }

    public final void j(List<s> r12) {
        if (ListUtils.isEmpty(r12) == true) goto L5;
    L7:
        int r0 = this.c;
        if (r0 == 3) goto L11;
        if (r0 == 4) goto L11;
        i(2);
    L11:
        RecyclerView r1 = getSearchGuessWord();
        if (r1 == null) goto L14;
        r1.setAdapter(getCommonSearchGuessWordAdapter());
    L14:
        if (r12 == null) goto L34;
        ArrayList r2 = new ArrayList();
        Iterator<T> r3 = r12.iterator();
    L17:
        if (r3.hasNext() == false) goto L25;
        s r4 = (s) r3.next();
        ArrayList r5 = new ArrayList();
        List<t> r6 = r4.d();
        if (r6 == null) goto L24;
        Iterator<T> r7 = r6.iterator();
    L22:
        if (r7.hasNext() == false) goto L24;
        t r8 = (t) r7.next();
        r5.add(new Pair(Integer.valueOf((int) r8.a()), Integer.valueOf(((int) r8.b()) + 1)));
    L24:
        r2.add(SpannableStringUtils.getDiffColorSpannable(r4.b(), r4.a(), r5));
        goto L17
    L25:
        CommonSearchGuessWordAdapter r9 = getCommonSearchGuessWordAdapter();
        r9.getClass();
        Intrinsics.checkNotNullParameter(r2, "wordList");
        Intrinsics.checkNotNullParameter(r12, "guessList");
        ((ArrayList) r9.a).clear();
        ((ArrayList) r9.a).addAll(r2);
        ((ArrayList) r9.b).clear();
        ArrayList r11 = (ArrayList) r9.b;
        r11.addAll(r12);
        RecyclerView r13 = getSearchGuessWord();
        if (r13 == null) goto L28;
        r13.setLayoutManager(new LinearLayoutManager(getContext()));
    L28:
        getCommonSearchGuessWordAdapter().notifyDataSetChanged();
        return;
    L34:
        return;
    L5:
        if (this.c == 4) goto L7;
        i(1);
    }

    public final void k(List<String> r4) {
        if (r4 == null) goto L7;
        List<String> r5 = r4;
        ArrayList r0 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r5, 10));
        Iterator<T> r6 = r5.iterator();
    L5:
        if (r6.hasNext() == false) goto L8;
        r0.add(new u((String) r6.next()));
    L8:
        CommonHotWordHistoryView r7 = getSearchHistory();
        if (r7 == null) goto L13;
        r7.b(0, r0);
        return;
    L13:
        return;
    L7:
        r0 = null;
        goto L8
    }

    public final void l(List<u> r3) {
        CommonHotWordHistoryView r0 = getHotWord();
        if (r0 == null) goto L6;
        r0.b(1, r3);
        return;
    }

    public void setCancelAction(Function0<Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "cancelAction");
        this.t = r2;
    }

    public void setOuterCallback(q r2) {
        Intrinsics.checkNotNullParameter(r2, "outerCallback");
        this.a = r2;
        this.q = r2.e();
    }

    public void setSearchResultView(View r1) {
        this.e = r1;
    }

    public static final boolean c(CommonSearchEnterView r4, int r5) {
        if (r5 != 3) goto L31;
        EditText r6 = r4.getEtSearch();
        String r2 = null;
        if (r6 == null) goto L23;
        Editable r7 = r6.getText();
        if (r7 == null) goto L23;
        if (StringsKt.isBlank(r7) != true) goto L23;
        EditText r8 = r4.getEtSearch();
        if (r8 == null) goto L15;
        CharSequence r9 = r8.getHint();
        if (r9 == null) goto L15;
        String r11 = r9.toString();
    L17:
        if ((!Intrinsics.areEqual(r11, r4.b)) == false) goto L23;
        EditText r12 = r4.getEtSearch();
        if (r12 == null) goto L28;
        CharSequence r13 = r12.getHint();
        if (r13 == null) goto L28;
        r2 = r13.toString();
    L28:
        if (r2 != null) goto L30;
        r2 = "";
    L30:
        r4.h(r2, "ugc", false);
        return true;
    L15:
        r11 = null;
    L23:
        EditText r14 = r4.getEtSearch();
        if (r14 == null) goto L28;
        Editable r15 = r14.getText();
        if (r15 == null) goto L28;
        r2 = r15.toString();
        goto L28
    L31:
        r4.getClass();
        return false;
    }

    public CommonSearchEnterView(Context r4, AttributeSet r5, int r6) {
        Intrinsics.checkNotNullParameter(r4, "context");
        super(r4, r5, r6);
        this.b = s1.B(2131918574);
        this.c = 1;
        this.f = LazyKt.lazy(new CommonSearchEnterView$tvCancel$2(this));
        this.g = LazyKt.lazy(new CommonSearchEnterView$searchBar$2(this));
        this.h = LazyKt.lazy(new CommonSearchEnterView$btnKtvSearch$2(this));
        this.i = LazyKt.lazy(new CommonSearchEnterView$etSearch$2(this));
        this.j = LazyKt.lazy(new CommonSearchEnterView$btnClear$2(this));
        this.k = LazyKt.lazy(new CommonSearchEnterView$searchGuessWord$2(this));
        this.l = LazyKt.lazy(new CommonSearchEnterView$historyHotWord$2(this));
        this.m = LazyKt.lazy(new CommonSearchEnterView$searchHistory$2(this));
        this.n = LazyKt.lazy(new CommonSearchEnterView$hotWord$2(this));
        this.o = LazyKt.lazy(new CommonSearchEnterView$searchLoadingContainer$2(this));
        this.p = LazyKt.lazy(new CommonSearchEnterView$searchLoadingAnim$2(this));
        this.r = LazyKt.lazy(new CommonSearchEnterView$commonSearchGuessWordAdapter$2(this));
        this.s = LazyKt.lazy(new CommonSearchEnterView$textWatch$2(this));
        TypedArray r7 = r4.obtainStyledAttributes(r5, new int[]{2130973964});
        boolean r0 = r7.getBoolean(0, false);
        this.u = r0;
        r7.recycle();
        if (r0 == false) goto L5;
        int r8 = 2131566461;
    L6:
        LayoutInflater.from(r4).inflate(r8, this);
        View r9 = getBtnKtvSearch();
        if (r9 == null) goto L9;
        r9.setOnClickListener(new l(this));
    L9:
        EditText r11 = getEtSearch();
        if (r11 == null) goto L12;
        r11.setHintTextColor(KtvOrderSongThemeManager.a(KtvOrderSongThemeManager.j));
    L12:
        EditText r12 = getEtSearch();
        if (r12 == null) goto L15;
        r12.setTextColor(KtvOrderSongThemeManager.a(KtvOrderSongThemeManager.j));
    L15:
        View r13 = getBtnKtvSearch();
        if (r13 == null) goto L18;
        KtvOrderSongThemeManager.c(r13, KtvOrderSongThemeManager.i);
    L18:
        View r14 = getBtnClear();
        if (r14 == null) goto L21;
        KtvOrderSongThemeManager.c(r14, KtvOrderSongThemeManager.m);
    L21:
        View r15 = getBtnClear();
        if (r15 == null) goto L24;
        r15.setOnClickListener(new m(this));
    L24:
        TextView r16 = getTvCancel();
        if (r16 == null) goto L27;
        r16.setOnClickListener(new n(this));
    L27:
        EditText r17 = getEtSearch();
        if (r17 == null) goto L30;
        r17.setOnTouchListener(new o(this));
    L30:
        EditText r18 = getEtSearch();
        if (r18 == null) goto L33;
        r18.addTextChangedListener(getTextWatch());
    L33:
        EditText r19 = getEtSearch();
        if (r19 == null) goto L36;
        r19.setOnEditorActionListener(new p(this));
    L36:
        ConstraintLayout r21 = getSearchBar();
        if (r21 == null) goto L39;
        KtvOrderSongThemeManager.c(r21, KtvOrderSongThemeManager.h);
    L39:
        EditText r22 = getEtSearch();
        if (r22 == null) goto L42;
        r22.setHintTextColor(KtvOrderSongThemeManager.a(KtvOrderSongThemeManager.a));
    L42:
        CommonHotWordHistoryView r23 = getSearchHistory();
        if (r23 == null) goto L45;
        r23.setHistoryRemoveAction(new CommonSearchEnterView$initHistoryAndHotWordView$1(this));
    L45:
        CommonHotWordHistoryView r24 = getSearchHistory();
        if (r24 == null) goto L48;
        r24.setHotWordHistoryClickAction(new CommonSearchEnterView$initHistoryAndHotWordView$2(this));
    L48:
        CommonHotWordHistoryView r25 = getHotWord();
        if (r25 == null) goto L51;
        r25.setHotWordHistoryClickAction(new CommonSearchEnterView$initHistoryAndHotWordView$3(this));
    L51:
        i(1);
        CommonHotWordHistoryView r26 = getSearchHistory();
        if (r26 == null) goto L54;
        r26.setVisibility(8);
    L54:
        TextView r27 = getTvCancel();
        if (r27 == null) goto L58;
        KtvOrderSongThemeManager.d(r27, KtvOrderSongThemeManager.f);
        return;
    L58:
        return;
    L5:
        r8 = 2131566462;
        goto L6
    }

    public final void h(String r6, String r7, boolean r8) {
        ALogger.i("CommonSearchEnterView", "trySearch");
        if (r6.length() <= 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L8;
        return;
    L8:
        if (StringsKt.trim(r6).toString().length() <= 0) goto L10;
        boolean r1 = true;
    L11:
        if (r1 == false) goto L32;
        this.d = System.currentTimeMillis();
        e();
        com.bytedance.android.live.ktv.common.search.viewmodel.a r2 = this.q;
        if (r2 == null) goto L15;
        r2.doSearch(r6, true, r7, r8);
    L15:
        i(3);
        EditText r9 = getEtSearch();
        if (r9 == null) goto L18;
        r9.setCursorVisible(false);
    L18:
        EditText r11 = getEtSearch();
        if (r11 == null) goto L21;
        r11.removeTextChangedListener(getTextWatch());
    L21:
        EditText r12 = getEtSearch();
        if (r12 == null) goto L24;
        r12.addTextChangedListener(getTextWatch());
    L24:
        EditText r13 = getEtSearch();
        if (r13 == null) goto L27;
        r13.setText(r6);
    L27:
        EditText r14 = getEtSearch();
        if (r14 == null) goto L33;
        r14.setSelection(r6.length());
        return;
    L33:
        return;
    L32:
        return;
    L10:
        r1 = false;
        goto L11
    L5:
        r0 = false;
        goto L6
    }

    public /* synthetic */ CommonSearchEnterView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
