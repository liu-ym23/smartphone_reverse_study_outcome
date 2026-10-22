package com.bytedance.android.live.openplatform.impl.miniappanchor.choose.page.search;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.ui.BaseFragment;
import com.bytedance.android.live.openplatform.impl.miniappanchor.choose.model.MiniAppEntranceCell;
import com.bytedance.android.live.openplatform.impl.miniappanchor.choose.page.base.MiniAppChooseBaseViewModel;
import com.bytedance.android.live.openplatform.impl.miniappanchor.choose.utils.RecyclerViewScrollReportHelper;
import com.bytedance.android.live.openplatform.impl.miniappanchor.choose.view.error.OpenPlatformFullScreenErrorView;
import com.bytedance.android.livesdkapi.util.InfraKotlinExtsKt;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0005B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/miniappanchor/choose/page/search/MiniAppChooseSearchFragment;", "Lcom/bytedance/android/live/core/ui/BaseFragment;", "Lcom/bytedance/android/live/openplatform/impl/miniappanchor/choose/page/c;", "<init>", "()V", "a", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class MiniAppChooseSearchFragment extends BaseFragment implements com.bytedance.android.live.openplatform.impl.miniappanchor.choose.page.c {
    public static final /* synthetic */ int j = 0;
    public Map<Integer, View> d;
    public lp0.a e;
    public MiniAppChooseSearchViewModel f;
    public final Lazy g;
    public final Lazy h;
    public RecyclerViewScrollReportHelper<MiniAppEntranceCell> i;

    public static final class a {
    }

    static {
    }

    public MiniAppChooseSearchFragment() {
        this.d = new LinkedHashMap();
        this.g = InfraKotlinExtsKt.mainThreadLazy(new MiniAppChooseSearchFragment$searchHistoryAdapter$2(this));
        this.h = InfraKotlinExtsKt.mainThreadLazy(new MiniAppChooseSearchFragment$searchResultAdapter$2(this));
    }

    public final void hideLoading() {
        S90(2131379091).setVisibility(8);
    }

    public final void onDestroy() {
        super.onDestroy();
        lp0.a r0 = this.e;
        if (r0 == null) goto L8;
        com.bytedance.android.live.openplatform.impl.miniappanchor.choose.page.b r1 = r0.getContainer();
        if (r1 == null) goto L9;
        r1.j30(this);
        return;
    L9:
        return;
    }

    public final void onDestroyView() {
        super.onDestroyView();
        MiniAppChooseSearchViewModel r0 = this.f;
        if (r0 == null) goto L5;
        r0.saveHistoryList();
    L5:
        ((LinkedHashMap) this.d).clear();
    }

    public final void onPause() {
        super.onPause();
        int r0 = com.bytedance.android.live.openplatform.impl.base.utils.k.a;
        com.bytedance.android.live.openplatform.impl.base.utils.k.a(getContext(), S90(2131385411));
    }

    public static final void T90(MiniAppChooseSearchFragment r2) {
        String r0 = ((EditText) r2.S90(2131385411)).getText().toString();
        if (r0 == null) goto L11;
        String r1 = StringsKt.trim(r0).toString();
        if (TextUtils.isEmpty(r1) == true) goto L12;
        MiniAppChooseSearchViewModel r3 = r2.f;
        if (r3 == null) goto L13;
        r3.searchMiniApp(r1);
        return;
    L13:
        return;
    L12:
        return;
    L11:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
    }

    @Override // com.bytedance.android.live.openplatform.impl.miniappanchor.choose.page.c
    public final void MX(int r2) {
        if (r2 == 0) goto L5;
        int r3 = com.bytedance.android.live.openplatform.impl.base.utils.k.a;
        com.bytedance.android.live.openplatform.impl.base.utils.k.a(getContext(), S90(2131385411));
        return;
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

    public final void onCreate(Bundle r3) {
        super.onCreate(r3);
        lp0.a r4 = this.e;
        Intrinsics.checkNotNullParameter(this, "frag");
        Intrinsics.checkNotNullParameter(MiniAppChooseSearchViewModel.class, "modelClass");
        MiniAppChooseBaseViewModel r0 = (MiniAppChooseBaseViewModel) ViewModelProviders.of(this).get(MiniAppChooseSearchViewModel.class);
        r0.setScope(r4);
        this.f = (MiniAppChooseSearchViewModel) r0;
        lp0.a r5 = this.e;
        if (r5 == null) goto L8;
        com.bytedance.android.live.openplatform.impl.miniappanchor.choose.page.b r6 = r5.getContainer();
        if (r6 == null) goto L9;
        r6.Iz(this);
        return;
    L9:
        return;
    }

    public final void onViewCreated(View r6, Bundle r7) {
        Intrinsics.checkNotNullParameter(r6, "view");
        super.onViewCreated(r6, r7);
        hideLoading();
        ((OpenPlatformFullScreenErrorView) S90(2131371779)).R5();
        S90(2131385587).setOnClickListener(new com.bytedance.android.live.openplatform.impl.miniappanchor.choose.page.search.a(this));
        ((EditText) S90(2131385411)).setOnEditorActionListener(new b(this));
        ((EditText) S90(2131385411)).addTextChangedListener(new c(this));
        ((EditText) S90(2131385411)).setOnFocusChangeListener(new d(this));
        ((ImageView) S90(2131366949)).setOnClickListener(new e(this));
        ((ImageView) S90(2131366949)).setVisibility(4);
        ((TextView) S90(2131365132)).setOnClickListener(new f(this));
        RecyclerView r0 = S90(2131385498);
        LinearLayoutManager r1 = new LinearLayoutManager(getContext());
        r1.setStackFromEnd(true);
        r1.setReverseLayout(true);
        Unit r3 = Unit.INSTANCE;
        r0.setLayoutManager(r1);
        S90(2131385498).setAdapter((SearchHistoryAdapter) this.g.getValue());
        S90(2131385498).setVisibility(0);
        ((TextView) S90(2131366935)).setOnClickListener(new g(this));
        S90(2131385565).setOverScrollMode(2);
        S90(2131385565).setLayoutManager(new LinearLayoutManager(getContext()));
        S90(2131385565).setAdapter((SearchResultAdapter) this.h.getValue());
        S90(2131385565).setVisibility(8);
        this.i = new RecyclerViewScrollReportHelper(S90(2131385565), 1, 1, new h(this));
        ((EditText) S90(2131385411)).setFocusable(true);
        ((EditText) S90(2131385411)).setFocusableInTouchMode(true);
        ((EditText) S90(2131385411)).requestFocus();
        int r8 = com.bytedance.android.live.openplatform.impl.base.utils.k.a;
        Context r9 = getContext();
        View r10 = S90(2131385411);
        if (r9 == null) goto L14;
        if (r10 == null) goto L14;
        r10.requestFocus();     // Catch: Exception -> L12
        Object r11 = r9.getSystemService("input_method");     // Catch: Exception -> L12
        if (r11 == null) goto L11;
        ((InputMethodManager) r11).showSoftInput(r10, 2);     // Catch: Exception -> L12
        goto L14
    L11:
        throw new NullPointerException("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");     // Catch: Exception -> L12
    L12:
        e = move-exception;
        e.printStackTrace();
    L14:
        MiniAppChooseSearchViewModel r12 = this.f;
        if (r12 == null) goto L19;
        MutableLiveData<LinkedList<String>> r13 = r12.getHistoryListUiState();
        if (r13 == null) goto L19;
        r13.observe(getViewLifecycleOwner(), new i(this));
    L19:
        MiniAppChooseSearchViewModel r14 = this.f;
        if (r14 == null) goto L24;
        MutableLiveData<com.bytedance.android.live.openplatform.impl.base.utils.b<p>> r15 = r14.getSearchResultUiState();
        if (r15 == null) goto L24;
        r15.observe(getViewLifecycleOwner(), new k(this));
    L24:
        MiniAppChooseSearchViewModel r16 = this.f;
        if (r16 == null) goto L29;
        r16.loadHistoryList();
        return;
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        return r2.inflate(2131566944, r3, false);
    }
}
