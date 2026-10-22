package com.ss.android.lark.contact.base.contact_search;

import android.app.Activity;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.larksuite.component.ui.button.LKUIButton;
import com.larksuite.component.ui.toast.LKUIToast;
import com.larksuite.framework.mvp.IView;
import com.larksuite.framework.utils.KeyboardUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.contact.base.dependency.ContactBaseModuleDependency;
import com.ss.android.lark.contact.base.statistics.InvHitPoint;
import com.ss.android.lark.profile.dto.ProfileFinishResult;
import com.ss.android.lark.profile.entity.Profile;
import com.ss.android.lark.statistics.Statistics;
import com.ss.android.lark.ui.CommonTitleBar;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.widget.recyclerview.item.BaseItemAdapter;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class b0 implements com.ss.android.lark.contact.base.contact_search.b {
    public final g0 a;
    public com.ss.android.lark.contact.base.contact_search.b.a b;
    public ConstraintLayout c;
    public CommonTitleBar d;
    public EditText e;
    public ImageView f;
    public RecyclerView g;
    public LinearLayout h;
    public com.ss.android.lark.compose.foundation.toast.g i;
    public BaseItemAdapter<v> j;
    public s k;
    public FrameLayout l;
    public RelativeLayout m;
    public LinearLayout n;
    public LKUIButton o;
    public TextView p;
    public final y q;

    public class a implements View.OnClickListener {
        public final /* synthetic */ b0 a;

        public a(b0 r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r1) {
            KeyboardUtils.hideKeyboard(this.a.a.getActivity());
        }
    }

    public class b implements Runnable {
        public final /* synthetic */ b0 a;

        @Override // java.lang.Runnable
        public final void run() {
            KeyboardUtils.showKeyboard(this.a.e);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public b(b0 r1) {
            this.a = r1;
        }
    }

    public class c implements TextWatcher {
        public final /* synthetic */ b0 a;

        @Override // android.text.TextWatcher
        public final void beforeTextChanged(CharSequence r1, int r2, int r3, int r4) {
        }

        @Override // android.text.TextWatcher
        public final void onTextChanged(CharSequence r1, int r2, int r3, int r4) {
        }

        public c(b0 r1) {
            this.a = r1;
        }

        @Override // android.text.TextWatcher
        public final void afterTextChanged(Editable r5) {
            String r6 = r5.toString().replace(" ", BuildConfig.FLAVOR);
            ImageView r0 = this.a.f;
            if (TextUtils.isEmpty(r6) == false) goto L5;
            int r1 = 8;
        L6:
            r0.setVisibility(r1);
            if (TextUtils.isEmpty(r6) == false) goto L10;
            b0 r7 = this.a;
            boolean r2 = v.h;
            r7.y4(new ArrayList());
            return;
        L10:
            b0 r3 = this.a;
            LinearLayout r4 = r3.h;
            if (r4 == null) goto L14;
            r4.setVisibility(8);
            r3.l.setVisibility(0);
            r3.m.setVisibility(0);
            r3.n.setVisibility(8);
            BaseItemAdapter<v> r8 = r3.j;
            boolean r9 = v.h;
            r8.a = new ArrayList();
            r3.j.notifyDataSetChanged();
        L14:
            b0 r10 = this.a;
            r10.getClass();
            if (r6.contains("@") == false) goto L17;
            r10.o.setText(2131892795);
        L18:
            r10.p.setText(r6);
            this.a.getClass();
            return;
        L17:
            r10.o.setText(2131892796);
            goto L18
        L5:
            r1 = 0;
            goto L6
        }
    }

    public class d implements TextView.OnEditorActionListener {
        public final /* synthetic */ b0 a;

        public d(b0 r1) {
            this.a = r1;
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public final boolean onEditorAction(TextView r2, int r3, KeyEvent r4) {
            if (r3 != 3) goto L6;
            b0 r5 = this.a;
            r5.b.x0(r5.e.getText().toString().replace(" ", BuildConfig.FLAVOR));
            KeyboardUtils.hideKeyboard(this.a.a.getActivity());
            return true;
        L6:
            return false;
        }
    }

    public class e implements View.OnClickListener {
        public final /* synthetic */ b0 a;

        public e(b0 r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            this.a.e.setText(BuildConfig.FLAVOR);
            this.a.f.setVisibility(8);
        }
    }

    public final void destroy() {
    }

    @Override // com.ss.android.lark.contact.base.contact_search.b
    public final void A3() {
        s r0 = this.k;
        if (r0 == null) goto L5;
        r0.g();
    L5:
        this.e.setText(BuildConfig.FLAVOR);
        this.l.setVisibility(8);
        KeyboardUtils.showKeyboard(this.e);
    }

    @Override // com.ss.android.lark.contact.base.contact_search.b
    public final void F2() {
        LinearLayout r0 = this.h;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.setVisibility(8);
        this.l.setVisibility(0);
        this.m.setVisibility(8);
        this.n.setVisibility(0);
        if (this.e.getText().toString().contains("@") == false) goto L8;
        this.o.setText(2131892795);
        return;
    L8:
        this.o.setText(2131892796);
    }

    @Override // com.ss.android.lark.contact.base.contact_search.b
    public final void N5() {
        LinearLayout r0 = this.h;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.setVisibility(0);
        this.l.setVisibility(8);
        BaseItemAdapter<v> r1 = this.j;
        boolean r2 = v.h;
        r1.a = new ArrayList();
        this.j.notifyDataSetChanged();
    }

    @Override // com.ss.android.lark.contact.base.contact_search.b
    public final void V1() {
        s r0 = this.k;
        if (r0 == null) goto L6;
        r0.l();
        return;
    }

    public final void create() {
        this.c = this.a.a(2131375647);
        this.d = this.a.a(2131375653);
        this.e = (EditText) this.a.a(2131375650);
        this.f = (ImageView) this.a.a(2131375649);
        RelativeLayout r0 = (RelativeLayout) this.a.a(2131375652);
        this.g = this.a.a(2131375628);
        this.h = (LinearLayout) this.a.a(2131375662);
        this.l = (FrameLayout) this.a.a(2131375658);
        this.m = (RelativeLayout) this.a.a(2131375660);
        TextView r1 = (TextView) this.a.a(2131375657);
        this.n = (LinearLayout) this.a.a(2131375656);
        this.o = this.a.a(2131375655);
        this.p = (TextView) this.a.a(2131375659);
        this.c.setOnClickListener(new a(this));
        this.e.post(new b(this));
        this.e.addTextChangedListener(new c(this));
        this.e.setOnEditorActionListener(new d(this));
        this.d.setImmersive(true);
        this.d.setLeftClickListener(new x(this));
        if (ContactBaseModuleDependency.b.isSmallB() == false) goto L5;
        this.d.setTitle(2131892413);
    L6:
        int r2 = 0;
        com.ss.android.lark.utils.q.b(new View[]{this.f});
        this.f.setOnClickListener(new e(this));
        BaseItemAdapter<v> r3 = new BaseItemAdapter();
        this.j = r3;
        boolean r4 = v.h;
        r3.a = new ArrayList();
        this.g.setAdapter(this.j);
        this.g.setLayoutManager(new LinearLayoutManager(this.a.getActivity()));
        this.l.setOnClickListener(new c0(this));
        com.ss.android.lark.utils.q.a(this.m);
        this.m.setOnClickListener(new d0(this));
        this.o.setOnClickListener(new e0(this));
        HashMap r5 = new HashMap();
        r5.put("APP_DISPLAY_NAME", UIHelper.getAppName());
        String r6 = UIHelper.mustacheFormat(2131892810, r5);
        f0 r7 = new f0(this);
        char[] r8 = r6.toCharArray();
        StringBuilder r9 = new StringBuilder();
        int r10 = r8.length;
        int r11 = 0;
        int r12 = 0;
    L7:
        if (r2 >= r10) goto L16;
        char r13 = r8[r2];
        if (r13 != '{') goto L12;
        r11 = r9.length();
    L15:
        r2 = r2 + 1;
        goto L7
    L12:
        if (r13 != '}') goto L14;
        r12 = r9.length();
        goto L15
    L14:
        r9.append(r13);
        goto L15
    L16:
        new SpannableString(r9.toString()).setSpan(r7, r11, r12, 33);
        return;
    L5:
        this.d.setTitle(2131892414);
        goto L6
    }

    @Override // com.ss.android.lark.contact.base.contact_search.b
    public Activity getActivity() {
        return this.a.getActivity();
    }

    @Override // com.ss.android.lark.contact.base.contact_search.b
    public final void i0() {
        LinearLayout r0 = this.h;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.removeCallbacks(this.q);
        if (this.i != null) goto L8;
        this.i = x08.a.a(getActivity(), 2131891846);
    L8:
        this.i.show();
    }

    @Override // com.ss.android.lark.contact.base.contact_search.b
    public final void l2() {
        if (this.i != null) goto L5;
        return;
    L5:
        LinearLayout r0 = this.h;
        if (r0 != null) goto L8;
        return;
    L8:
        r0.postDelayed(this.q, 200);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.ss.android.lark.contact.base.contact_search.y] */
    public b0(g0 r2) {
        this.q = new y(this);
        this.a = r2;
    }

    @Override // com.ss.android.lark.contact.base.contact_search.b
    public final void M0(String r8) {
        String r3 = this.e.getText().toString();
        s r0 = new s(this.a.getActivity(), r3, r8, new z(this, r3), new a0());
        r0.j();
        this.k = r0;
        Statistics.sendEvent("invite_people_external_search_nomatch_search", InvHitPoint.b(null));
        Statistics.sendEvent("invite_people_external_search_invite_view", InvHitPoint.b(null));
    }

    @Override // com.ss.android.lark.contact.base.contact_search.b
    public final void O5(ProfileFinishResult r6) {
        BaseItemAdapter<v> r0 = this.j;
        if (r0 == null) goto L22;
        Iterator r1 = r0.a.iterator();
    L6:
        if (r1.hasNext() == false) goto L13;
        v r2 = (v) r1.next();
        String r3 = r6.userId;
        Profile r4 = r2.e;
        if (r4 != null) goto L10;
        boolean r5 = false;
    L11:
        if (r5 == false) goto L6;
        int r7 = r2.g;
        r2.e.setIsFriend(r6.isFriend);
        r2.e.setIsRequestUserApplied(r6.isRequestUserApplied);
        r2.e.setIsTargetUserApplied(r6.isTargetUserApplied);
    L14:
        if (r7 == (-1)) goto L23;
        this.j.notifyItemChanged(r7);
        return;
    L23:
        return;
    L10:
        r5 = TextUtils.equals(r3, r4.getId());
        goto L11
    L13:
        r7 = -1;
        goto L14
    }

    public final void setViewDelegate(IView.IViewDelegate r1) {
        this.b = (com.ss.android.lark.contact.base.contact_search.b.a) r1;
    }

    @Override // com.ss.android.lark.contact.base.contact_search.b
    public final void showToast(String r2) {
        LKUIToast.show(this.a.getActivity(), r2);
    }

    @Override // com.ss.android.lark.contact.base.contact_search.b
    public final void v8(String r4) {
        if (this.g.getItemDecorationCount() < 1) goto L5;
        this.g.removeItemDecorationAt(0);
    L5:
        this.g.addItemDecoration(new InviteExternalSearchDescoration(getActivity(), r4));
    }

    @Override // com.ss.android.lark.contact.base.contact_search.b
    public final void y4(List<? extends bec.a> r3) {
        LinearLayout r0 = this.h;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.setVisibility(8);
        this.l.setVisibility(8);
        BaseItemAdapter<v> r1 = this.j;
        r1.a = r3;
        r1.notifyDataSetChanged();
    }
}
