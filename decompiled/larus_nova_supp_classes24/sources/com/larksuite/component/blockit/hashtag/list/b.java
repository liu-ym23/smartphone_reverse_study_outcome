package com.larksuite.component.blockit.hashtag.list;

import android.content.res.Resources;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.TypedValue;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.bytedance.common.utility.collection.CollectionUtils;
import com.larksuite.component.ui.toast.LKUIToast;
import com.larksuite.framework.mvp.IView;
import com.larksuite.framework.ui.DividerDecoration;
import com.larksuite.framework.utils.UIUtils;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class b implements k {
    public final View a;
    public final a b;
    public final Map<String, Object> c;
    public k.a d;
    public HashTagSwipeAdapter e;

    public interface a {
        void a();

        FragmentActivity b();
    }

    @Override // com.larksuite.framework.mvp.ILifecycle
    public final void destroy() {
    }

    @Override // com.larksuite.framework.mvp.ILifecycle
    public final void create() {
        this.a.findViewById(2131388775).setTitle(2131892503);
        this.a.findViewById(2131388775).setLeftImageResource(2131237608);
        FragmentActivity r0 = this.b.b();
        if (r0 == null) goto L5;
        String r1 = UIUtils.getString(r0, 2131892486);
        SpannableString r2 = new SpannableString(r1);
        r2.setSpan(new ForegroundColorSpan(r0.getResources().getColor(2131103404)), 0, r1.length(), 33);
        this.e = new HashTagSwipeAdapter(r0, new f(this, r0, r2), true, true);
        this.a.findViewById(2131384906).setAdapter(this.e);
        this.a.findViewById(2131384906).setItemAnimator(null);
        this.a.findViewById(2131384906).setLayoutManager(new LinearLayoutManager(this.a.getContext()));
        this.a.findViewById(2131384906).setOnScrollListener(new HashTagListView$initView$1$2(this));
        DividerDecoration.a r3 = new DividerDecoration.a(r0);
        float r4 = UIUtils.dp2px(r0, 0.5f);
        Resources r5 = r3.a;
        r3.b = (int) TypedValue.applyDimension(0, r4, WindowDisplayMetricsOverride.apply(r5, r5.getDisplayMetrics()));
        r3.c = r3.a.getColor(2131103453);
        float r6 = UIUtils.dp2px(r0, 16.0f);
        Resources r7 = r3.a;
        this.a.findViewById(2131384906).addItemDecoration(new DividerDecoration(r3.b, (int) TypedValue.applyDimension(0, r6, WindowDisplayMetricsOverride.apply(r7, r7.getDisplayMetrics())), r3.c), 0);
    L5:
        ((TextView) this.a.findViewById(2131389993)).setOnClickListener(new g(this));
    }

    @Override // com.larksuite.component.blockit.hashtag.list.k
    public final void O7(String r3) {
        Intrinsics.checkNotNullParameter(r3, "text");
        if (TextUtils.isEmpty(r3) == false) goto L5;
        return;
    L5:
        LKUIToast.show(this.a.getContext(), 2131237612, r3);
    }

    @Override // com.larksuite.component.blockit.hashtag.list.k
    public final void c1(String r2) {
        Intrinsics.checkNotNullParameter(r2, "text");
        if (TextUtils.isEmpty(r2) == false) goto L5;
        return;
    L5:
        LKUIToast.show(this.a.getContext(), r2);
    }

    @Override // com.larksuite.component.blockit.hashtag.list.k
    public final void f7(l r6) {
        Intrinsics.checkNotNullParameter(r6, "initData");
        HashTagSwipeAdapter r0 = this.e;
        if (r0 == null) goto L6;
        r0.A2(r6.a);
    L6:
        if (CollectionUtils.isEmpty(r6.a) == true) goto L8;
        ((TextView) this.a.findViewById(2131389994)).setVisibility(0);
        this.a.findViewById(2131384906).setVisibility(0);
        ((FrameLayout) this.a.findViewById(2131372650)).setVisibility(8);
        return;
    L8:
        ((TextView) this.a.findViewById(2131389994)).setVisibility(0);
        this.a.findViewById(2131384906).setVisibility(8);
        ((FrameLayout) this.a.findViewById(2131372650)).setVisibility(0);
    }

    @Override // com.larksuite.framework.mvp.IView
    public final void setViewDelegate(IView.IViewDelegate r1) {
        this.d = (k.a) r1;
    }

    public b(View r2, HashTagListFragment.a r3, Map r4) {
        Intrinsics.checkNotNullParameter(r2, "mRootView");
        Intrinsics.checkNotNullParameter(r3, "mViewDependency");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
