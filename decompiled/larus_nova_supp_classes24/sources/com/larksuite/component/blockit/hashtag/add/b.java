package com.larksuite.component.blockit.hashtag.add;

import android.content.res.Resources;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.TypedValue;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.larksuite.component.blockit.entity.TagPermissionType;
import com.larksuite.component.blockit.hashtag.list.HashTagSwipeAdapter;
import com.larksuite.component.ui.toast.LKUIToast;
import com.larksuite.framework.mvp.IView;
import com.larksuite.framework.ui.DividerDecoration;
import com.larksuite.framework.utils.CollectionUtils;
import com.larksuite.framework.utils.UIUtils;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class b implements j {
    public final View a;
    public final a b;
    public final boolean c;
    public final Map<String, Object> d;
    public j.a e;
    public HashTagSwipeAdapter f;
    public FragmentActivity g;
    public String h;

    public interface a {
        FragmentActivity getActivity();
    }

    @Override // com.larksuite.framework.mvp.ILifecycle
    public final void destroy() {
    }

    @Override // com.larksuite.framework.mvp.ILifecycle
    public final void create() {
        this.g = this.b.getActivity();
        if (this.c == false) goto L5;
        JSONObject r0 = new JSONObject(this.d);
        String r3 = UUID.randomUUID().toString();
        this.h = r3;
        r0.put("session_id", r3);
        qy7.a.a("pano_tag_mention_begin", r0);
        this.a.findViewById(2131388775).setTitle(2131892478);
        ((TextView) this.a.findViewById(2131390067)).setText(UIUtils.getString(this.g, 2131892490));
    L6:
        EditText r1 = (EditText) this.a.findViewById(2131371788);
        r1.addTextChangedListener(new c(this));
        r1.setOnFocusChangeListener(new d(r1, this));
        ((ImageView) this.a.findViewById(2131375940)).setOnClickListener(new e(this));
        ((FrameLayout) this.a.findViewById(2131372659)).setOnClickListener(new f(this));
        this.a.findViewById(2131384907).setLayoutManager(new LinearLayoutManager(this.a.getContext()));
        DividerDecoration.a r2 = new DividerDecoration.a(this.g);
        float r4 = UIUtils.dp2px(this.g, 0.5f);
        Resources r5 = r2.a;
        r2.b = (int) TypedValue.applyDimension(0, r4, WindowDisplayMetricsOverride.apply(r5, r5.getDisplayMetrics()));
        r2.c = r2.a.getColor(2131103453);
        float r6 = UIUtils.dp2px(this.g, 16.0f);
        Resources r7 = r2.a;
        this.a.findViewById(2131384907).addItemDecoration(new DividerDecoration(r2.b, (int) TypedValue.applyDimension(0, r6, WindowDisplayMetricsOverride.apply(r7, r7.getDisplayMetrics())), r2.c), 0);
        FragmentActivity r8 = this.g;
        if (r8 == null) goto L10;
        this.f = new HashTagSwipeAdapter(r8, new g(this, r8), false, this.c);
        this.a.findViewById(2131384907).setAdapter(this.f);
        return;
    L10:
        return;
    L5:
        this.a.findViewById(2131388775).setTitle(2131892487);
        this.a.findViewById(2131388775).setLeftImageResource(2131237608);
        ((TextView) this.a.findViewById(2131390067)).setText(UIUtils.getString(this.g, 2131892488));
        goto L6
    }

    @Override // com.larksuite.component.blockit.hashtag.add.j
    public final void finish() {
        FragmentActivity r0 = this.b.getActivity();
        if (r0 == null) goto L5;
        r0.setResult(-1);
    L5:
        FragmentActivity r1 = this.b.getActivity();
        if (r1 == null) goto L9;
        r1.finish();
        return;
    }

    @Override // com.larksuite.component.blockit.hashtag.add.j
    public final void d5(k r4) {
        Intrinsics.checkNotNullParameter(r4, "initData");
        HashTagSwipeAdapter r0 = this.f;
        if (r0 == null) goto L6;
        r0.A2(r4.a);
    L6:
        if (CollectionUtils.isNotEmpty(r4.a) == false) goto L8;
        ((TextView) this.a.findViewById(2131390067)).setVisibility(0);
        this.a.findViewById(2131384907).setVisibility(0);
    L10:
        if (this.c == true) goto L13;
        JSONObject r5 = new JSONObject(this.d);
        r5.put("session_id", this.h);
        r5.put("if_input", false);
        qy7.a.a("pano_mention_input_word", r5);
        return;
    L13:
        return;
    L8:
        ((TextView) this.a.findViewById(2131390067)).setVisibility(8);
        this.a.findViewById(2131384907).setVisibility(8);
        goto L10
    }

    @Override // com.larksuite.framework.mvp.IView
    public final void setViewDelegate(IView.IViewDelegate r1) {
        this.e = (j.a) r1;
    }

    @Override // com.larksuite.component.blockit.hashtag.add.j
    public final void G0(String r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "message");
        if (TextUtils.isEmpty(r2) == false) goto L5;
        return;
    L5:
        if (r3 == 0) goto L7;
        LKUIToast.show(this.g, r3, r2);
        return;
    L7:
        LKUIToast.show(this.g, r2);
    }

    @Override // com.larksuite.component.blockit.hashtag.add.j
    public final void Q6(String r23, List<oy7.e> r24, boolean r25) {
        Intrinsics.checkNotNullParameter(r23, "query");
        ArrayList r1 = new ArrayList();
        if (this.c == false) goto L8;
        if (r25 == false) goto L8;
        oy7.e r2 = new oy7.e("", "", ((EditText) this.a.findViewById(2131371788)).getText().toString(), false, false, true, false, "", "", TagPermissionType.Private.value(), null, true, 1024);
        if (TextUtils.isEmpty(r23) == true) goto L8;
        r1.add(r2);
    L8:
        if (r24 == null) goto L12;
        List r3 = CollectionsKt.toMutableList(r24);
        if (r3 == null) goto L12;
        r1.addAll(r3);
    L12:
        HashTagSwipeAdapter r4 = this.f;
        if (r4 == null) goto L16;
        r4.A2(r1);
    L16:
        if (CollectionUtils.isNotEmpty(r1) == false) goto L18;
        this.a.findViewById(2131384907).setVisibility(0);
    L20:
        if (TextUtils.isEmpty(r23) == false) goto L22;
    L27:
        ((LinearLayout) this.a.findViewById(2131385417)).setVisibility(8);
    L29:
        if (TextUtils.isEmpty(r23) == true) goto L31;
    L33:
        ((TextView) this.a.findViewById(2131390067)).setVisibility(8);
    L35:
        if (this.c == true) goto L38;
        JSONObject r5 = new JSONObject(this.d);
        r5.put("session_id", this.h);
        r5.put("if_input", !TextUtils.isEmpty(r23));
        qy7.a.a("pano_mention_input_word", r5);
        return;
    L38:
        return;
    L31:
        if (CollectionUtils.isNotEmpty(r24) == false) goto L33;
        ((TextView) this.a.findViewById(2131390067)).setVisibility(0);
        goto L35
    L22:
        if (CollectionUtils.isEmpty(r1) == false) goto L27;
        ((LinearLayout) this.a.findViewById(2131385417)).setVisibility(0);
        String r10 = "未搜索到“" + r23 + "”相关结果";
        int r6 = StringsKt.indexOf$default(r10, r23, 0, false, 6, null);
        int r7 = r23.length() + r6;
        SpannableString r8 = new SpannableString(r10);
        FragmentActivity r9 = this.g;
        if (r9 == null) goto L26;
        r8.setSpan(new ForegroundColorSpan(r9.getResources().getColor(2131103404)), r6, r7, 33);
    L26:
        ((TextView) this.a.findViewById(2131391358)).setText(r8);
        goto L29
    L18:
        this.a.findViewById(2131384907).setVisibility(8);
        goto L20
    }

    public b(View r2, AddHashTagFragment.a r3, boolean r4, Map r5) {
        Intrinsics.checkNotNullParameter(r2, "mRootView");
        Intrinsics.checkNotNullParameter(r3, "mViewDependency");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
    }
}
