package com.ss.android.lark.reaction.widget.detailwindow.pager;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.larksuite.component.ui.loading.LKUIStatus;
import com.larksuite.framework.callback.CallbackManager;
import com.larksuite.framework.callback.UIGetDataCallback;
import com.larksuite.framework.thread.CoreThreadPool;
import com.ss.android.lark.reaction.widget.detailwindow.ReactionPopupFacade;
import com.ss.android.lark.reaction.widget.detailwindow.bean.DetailUserInfo;
import com.ss.android.lark.reaction.widget.detailwindow.bean.ReactionDetailViewModel;
import com.ss.android.lark.utils.UIHelper;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public class ReactionListFragment extends Fragment {
    public static final /* synthetic */ int n = 0;
    public e d;
    public ViewGroup e;
    public RecyclerView f;
    public ReactionListAdapter g;
    public ReactionPopupFacade.c h;
    public ReactionPopupFacade.b i;
    public boolean j;
    public int k;
    public LKUIStatus l;
    public final CallbackManager m;

    public ReactionListFragment() {
        this.k = UIHelper.dp2px(56.0f);
        this.m = new CallbackManager();
    }

    public final void onDestroy() {
        super.onDestroy();
        LKUIStatus r0 = this.l;
        if (r0 != null) goto L5;
    L10:
        this.m.cancelCallbacks();
        return;
    L5:
        if (r0.i != 2) goto L7;
        boolean r1 = true;
    L8:
        if (r1 == false) goto L10;
        r0.b();
        goto L10
    L7:
        r1 = false;
        goto L8
    }

    public final void T90(ReactionDetailViewModel r2) {
        if (r2 != null) goto L5;
        return;
    L5:
        if (this.g != null) goto L8;
        return;
    L8:
        if (TextUtils.isEmpty(r2.getTipText()) == true) goto L10;
        ReactionListAdapter r0 = this.g;
        r0.e = r2.getTipText();
        return;
    L10:
        this.g.e = "";
    }

    public final void onCreate(Bundle r4) {
        super.onCreate(r4);
        this.d = new e(this.i);
        if (getArguments() == null) goto L8;
        ReactionDetailViewModel r5 = (ReactionDetailViewModel) getArguments().getSerializable("reaction_info");
        this.j = getArguments().getBoolean("need_loading");
        this.k = getArguments().getInt("bottom_padding", this.k);
        if (r5 == null) goto L9;
        this.d.b = r5;
        return;
    L9:
        return;
    }

    public final void onViewCreated(View r3, Bundle r4) {
        this.f = this.e.findViewById(2131392858);
        int r1 = 0;
        this.f.setLayoutManager(new LinearLayoutManager(getContext(), 1, false));
        Context r5 = getContext();
        ReactionDetailViewModel r0 = this.d.b;
        if (r0 != null) goto L5;
        List<DetailUserInfo> r2 = new ArrayList();
    L6:
        this.g = new ReactionListAdapter(r5, r2);
        T90(this.d.b);
        this.f.setAdapter(this.g);
        ViewGroup r6 = this.e;
        LKUIStatus.b r7 = new LKUIStatus.b(r6);
        r7.e = v2c.a.a(r6.getContext(), 100.0f);
        this.l = new LKUIStatus(r7);
        if (this.j == false) goto L18;
        ReactionDetailViewModel r8 = this.d.b;
        if (r8 != null) goto L11;
        List<DetailUserInfo> r9 = new ArrayList();
    L12:
        int r10 = r9.size();
        ReactionDetailViewModel r11 = this.d.b;
        if (r11 == null) goto L16;
        r1 = r11.getTotalCount();
    L16:
        if (r10 >= r1) goto L18;
        this.l.e();
        final e r12 = this.d;
        final UIGetDataCallback r13 = new UIGetDataCallback(this.m.wrapAndAddCallback(new AnonymousClass1(this)));
        r12.getClass();
        CoreThreadPool.getDefault().getCachedThreadPool().execute(new d(r12, r13));
        goto L18
    L11:
        r9 = r8.getUserInfoList();
    L18:
        this.g.c = new a(this);
        return;
    L5:
        r2 = r0.getUserInfoList();
        goto L6
    }

    public static ReactionListFragment S90(ReactionDetailViewModel r3, boolean r4, int r5) {
        ReactionListFragment r0 = new ReactionListFragment();
        Bundle r1 = new Bundle();
        r1.putSerializable("reaction_info", r3);
        r1.putSerializable("need_loading", Boolean.valueOf(r4));
        r1.putInt("bottom_padding", r5);
        r0.setArguments(r1);
        return r0;
    }

    public final View onCreateView(LayoutInflater r3, ViewGroup r4, Bundle r5) {
        ViewGroup r6 = (ViewGroup) r3.inflate(2131561238, r4, false);
        this.e = r6;
        r6.setPadding(r6.getPaddingLeft(), this.e.getPaddingTop(), this.e.getPaddingRight(), this.k);
        return this.e;
    }
}
