package com.bytedance.android.live.search.impl.search;

import am2.x;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.ui.BaseFragment;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.search.impl.search.adapter.LiveSearchResultAdapter;
import com.bytedance.android.live.search.impl.search.model.LiveSearchResultParam;
import com.bytedance.android.live.search.impl.search.viewmodel.LiveSearchIntermediateViewModel;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livesdk.config.dr0;
import com.bytedance.android.livesdk.r3;
import com.bytedance.android.livesdk.utils.e5;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0001\u0006B\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/live/search/impl/search/LiveSearchResultFragment;", "Lcom/bytedance/android/live/core/ui/BaseFragment;", "Lpa1/a;", "Lcom/bytedance/android/live/search/impl/search/LiveSearchIntermediateView$c;", "<init>", "()V", "a", "livesearchimpl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveSearchResultFragment extends BaseFragment implements pa1.a, LiveSearchIntermediateView.c {
    public static int x;
    public static String y;
    public LiveSearchIntermediateView d;
    public LiveSearchContainerFragment e;
    public ViewGroup f;
    public EditText g;
    public View h;
    public View i;
    public View j;
    public TextView k;
    public ViewGroup l;
    public int m;
    public View n;
    public String o;
    public LiveSearchIntermediateViewModel p;
    public boolean q;
    public pa1.d r;
    public k s;
    public boolean t;
    public boolean u;
    public String v;
    public ViewGroup w;

    public static final class a {
    }

    public final String getSpm() {
        return "a100.a218";
    }

    @Override // pa1.a
    public final void iV(long r1) {
    }

    static {
        x = -1;
        y = "";
    }

    public static String S90() {
        String[] r0 = (String[]) dr0.a.getValue();
        if (r0 != null) goto L5;
    L11:
        boolean r3 = true;
    L12:
        if (r3 == false) goto L16;
        x = -1;
        String r1 = s1.B(2131921604);
        y = r1;
        return r1;
    L16:
        if (x >= 0) goto L19;
        x = (int) (System.currentTimeMillis() % ((long) r0.length));
    L19:
        if (x < r0.length) goto L21;
        x = 0;
    L21:
        int r2 = x;
        String r4 = r0[r2];
        y = r4;
        x = r2 + 1;
        return r4;
    L5:
        if (r0.length != 0) goto L7;
        boolean r5 = true;
    L8:
        if (r5 == true) goto L11;
        r3 = false;
        goto L12
    L7:
        r5 = false;
        goto L8
    }

    public final void W90() {
        LiveSearchIntermediateView r0 = this.d;
        if (r0 == null) goto L20;
        LiveSearchIntermediateViewModel r1 = r0.a;
        if (r1 == null) goto L9;
        NextLiveData<Integer> r2 = r1.getIntermediateState();
        if (r2 == null) goto L9;
        Integer r3 = (Integer) r2.getValue();
    L10:
        if (r3 == null) goto L15;
        boolean r4 = true;
        if (r3.intValue() != 1) goto L15;
    L16:
        if (r4 == true) goto L20;
        r0.a();
        LiveSearchIntermediateViewModel r5 = r0.a;
        if (r5 == null) goto L20;
        r5.openSearchSquare();
    L15:
        r4 = false;
    L9:
        r3 = null;
    L20:
        this.m = 2;
        com.bytedance.android.live.search.impl.search.a.e = 2;
        if (U90() == false) goto L31;
        LiveSearchContainerFragment r6 = this.e;
        if (r6 == null) goto L32;
        LiveSearchResultAdapter r7 = r6.f;
        if (r7 == null) goto L27;
        r7.y2(new ArrayList(), "");
    L27:
        LiveSearchResultAdapter r8 = r6.f;
        if (r8 == null) goto L33;
        r8.notifyDataSetChanged();
        return;
    L33:
        return;
    L32:
        return;
    }

    public final void X90() {
        LiveSearchIntermediateView r0 = this.d;
        if (r0 == null) goto L14;
        EditText r2 = this.g;
        if (r2 == null) goto L10;
        Editable r3 = r2.getText();
        if (r3 == null) goto L10;
        String r4 = r3.toString();
        if (r4 == null) goto L10;
    L11:
        Intrinsics.checkNotNullParameter(r4, "keyword");
        r0.a();
        LiveSearchIntermediateViewModel r1 = r0.a;
        if (r1 == null) goto L14;
        r1.openSearchSug(r4);
    L10:
        r4 = "";
    L14:
        this.m = 2;
        com.bytedance.android.live.search.impl.search.a.e = 2;
        if (U90() == false) goto L25;
        LiveSearchContainerFragment r5 = this.e;
        if (r5 == null) goto L26;
        LiveSearchResultAdapter r6 = r5.f;
        if (r6 == null) goto L21;
        r6.y2(new ArrayList(), "");
    L21:
        LiveSearchResultAdapter r7 = r5.f;
        if (r7 == null) goto L27;
        r7.notifyDataSetChanged();
        return;
    L27:
        return;
    L26:
        return;
    }

    @Override // pa1.a
    public final void tl() {
        TextView r0 = this.k;
        if (r0 == null) goto L5;
        r0.setText(S90());
    L5:
        int r1 = g.a;
        g.a(y, "search_bar_outer");
    }

    public LiveSearchResultFragment() {
        this.m = 2;
        this.o = "";
        this.v = "live_merge";
    }

    public final boolean U90() {
        if (com.bytedance.android.livesdk.utils.landscape.b.b() == true) goto L7;
        return false;
    L7:
        return e5.n();
    }

    public final void onDestroy() {
        super.onDestroy();
        int r0 = com.bytedance.android.live.search.impl.search.helper.a.a;
        com.bytedance.android.live.search.impl.search.helper.a.a(this.g);
        this.t = false;
        LiveSearchIntermediateView r1 = this.d;
        if (r1 == null) goto L7;
        LiveSearchIntermediateViewModel r2 = r1.a;
        if (r2 == null) goto L7;
        r2.hideIntermediate();
    L7:
        this.o = "";
        if (this.q == true) goto L10;
        return;
    L10:
        if (this.m != 1) goto L20;
        LiveSearchContainerFragment r3 = this.e;
        if (r3 == null) goto L21;
        String r4 = com.bytedance.android.live.search.impl.search.a.a;
        com.bytedance.android.live.search.impl.search.a.f = r3.i.g;
        RecyclerView r5 = r3.d;
        if (r5 == null) goto L16;
        RecyclerView.LayoutManager r6 = r5.getLayoutManager();
    L17:
        b90.b.b(r6);
        return;
    L16:
        r6 = null;
        goto L17
    L21:
        return;
    }

    public final void onPause() {
        super.onPause();
        int r0 = com.bytedance.android.live.search.impl.search.helper.a.a;
        com.bytedance.android.live.search.impl.search.helper.a.a(this.g);
    }

    @Override // pa1.a
    public final void Bp(boolean r5) {
        this.q = r5;
        View r0 = this.j;
        if (r0 == null) goto L9;
        if (r5 == false) goto L6;
        int r6 = 0;
    L7:
        r0.setVisibility(r6);
        goto L9
    L6:
        r6 = 8;
    L9:
        if (this.q == true) goto L12;
        com.bytedance.android.live.search.impl.search.a.f = null;
        com.bytedance.android.live.search.impl.search.a.e = 0;
        com.bytedance.android.live.search.impl.search.a.a = "";
        com.bytedance.android.live.search.impl.search.a.b = 0;
        com.bytedance.android.live.search.impl.search.a.c = "";
        com.bytedance.android.live.search.impl.search.a.d = 0;
        return;
    }

    @Override // pa1.a
    public final void OC(boolean r1) {
        S90();
        T90(!r1);
    }

    public final void T90(boolean r6) {
        if (this.q == true) goto L10;
        Z90(true, !r6);
        int r7 = g.a;
        HashMap r8 = new HashMap();
        r8.put("enter_from", "live_square");
        com.bytedance.android.livesdk.log.u.l().e("enter_search", r8, new Object[0]);
        HashMap r9 = new HashMap();
        if (e5.n() == false) goto L7;
        String r0 = "landscape";
    L8:
        r9.put("screen_direction", r0);
        r9.put("user_id", jc1.k.n(IUserService.class).user().n());
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_drawer_search_click", r9, new Object[]{Room.class});
        goto L10
    L7:
        r0 = "portrait";
    L10:
        if (this.t == true) goto L12;
        this.s = new k(this);
        return;
    L12:
        EditText r10 = this.g;
        if (r10 == null) goto L15;
        r10.setCursorVisible(true);
    L15:
        EditText r12 = this.g;
        if (r12 == null) goto L20;
        Editable r13 = r12.getText();
        if (r13 == null) goto L20;
        String r14 = r13.toString();
    L22:
        if (TextUtils.isEmpty(r14) == true) goto L24;
        X90();
        return;
    L24:
        W90();
        return;
    L20:
        r14 = null;
        goto L22
    }

    public final void Y90(ViewGroup r3) {
        Intrinsics.checkNotNullParameter(r3, "inputContainer");
        this.f = r3;
        this.g = (EditText) r3.findViewById(2131371812);
        this.n = r3.findViewById(2131364676);
        this.j = r3.findViewById(2131391360);
        this.h = r3.findViewById(2131376580);
        this.i = r3.findViewById(2131379263);
        TextView r0 = (TextView) r3.findViewById(2131391361);
        this.k = r0;
        if (r0 == null) goto L5;
        r0.setImportantForAccessibility(4);
    L5:
        this.l = (ViewGroup) r3.findViewById(2131372759);
        EditText r4 = this.g;
        if (r4 == null) goto L8;
        r4.addTextChangedListener(new l(this));
    L8:
        EditText r5 = this.g;
        if (r5 == null) goto L11;
        ViewCompat.setAccessibilityDelegate(r5, new LiveSearchResultFragment$initInputView$$inlined$let$lambda$1(this));
    L11:
        EditText r6 = this.g;
        if (r6 == null) goto L14;
        r6.setOnTouchListener(new m(this));
    L14:
        View r7 = this.n;
        if (r7 == null) goto L17;
        r7.setOnClickListener(new n(this));
    L17:
        View r8 = this.j;
        if (r8 == null) goto L20;
        r8.setOnClickListener(new o(this));
    L20:
        EditText r9 = this.g;
        if (r9 == null) goto L23;
        r9.setOnEditorActionListener(new p(this));
    L23:
        r3.a(this.n, s1.B(2131914420));
    }

    @Override // com.bytedance.android.live.search.impl.search.LiveSearchIntermediateView.c
    public final void d50(LiveSearchResultParam r2) {
        Intrinsics.checkNotNullParameter(r2, "param");
        if (this.q == false) goto L6;
        V90(r2, false);
        return;
    }

    public final void onCreate(Bundle r4) {
        super.onCreate(r4);
        FragmentActivity r5 = getActivity();
        if (r5 == null) goto L5;
        this.p = (LiveSearchIntermediateViewModel) ViewModelProviders.of(r5).get(LiveSearchIntermediateViewModel.class);
        String r0 = com.bytedance.android.live.search.impl.search.a.a;
        com.bytedance.android.live.search.impl.search.a.d = r5.hashCode();
    L5:
        com.bytedance.android.livesdk.log.filter.o r6 = com.bytedance.android.livesdk.log.u.l().c(x.class);
        String r1 = com.bytedance.android.live.search.impl.search.a.a;
        if (r6 == null) goto L12;
        Map r2 = r6.getMap();
        if (r2 == null) goto L12;
        if (r2.containsKey("enter_from_merge") != true) goto L12;
        String r7 = (String) r6.getMap().get("enter_from_merge");
    L13:
        com.bytedance.android.live.search.impl.search.a.c = r7;
        Bundle r8 = getArguments();
        if (r8 == null) goto L16;
        r8.getString("search_init_keyword");
        this.u = r8.getBoolean("home_refresh");
    L16:
        String r3 = "live_merge";
        if (TextUtils.isEmpty(com.bytedance.android.live.search.impl.search.a.c) == false) goto L19;
        String r9 = "live_merge";
    L20:
        if (r9 == null) goto L23;
        r3 = r9;
    L23:
        this.v = r3;
        return;
    L19:
        r9 = com.bytedance.android.live.search.impl.search.a.c;
    L12:
        r7 = "";
        goto L13
    }

    public final void setUserVisibleHint(boolean r1) {
        super/*androidx.fragment.app.Fragment*/.setUserVisibleHint(r1);
        k r2 = this.s;
        if (r2 == null) goto L6;
        r2.run();
        return;
    }

    public final void V90(LiveSearchResultParam r10, boolean r12) {
        String r0 = r10.getKeyword();
        if (TextUtils.isEmpty(r10.getRealSearchWord()) == true) goto L5;
        r0 = r10.getRealSearchWord();
    L5:
        int r1 = com.bytedance.android.live.search.impl.search.helper.b.a;
        if (TextUtils.isEmpty(r0) == false) goto L8;
        boolean r2 = true;
    L28:
        if (r2 == false) goto L30;
        r0 = null;
    L41:
        String r4 = "";
        if (TextUtils.isEmpty(r0) == false) goto L47;
        EditText r13 = this.g;
        if (r13 == null) goto L91;
        r13.setText("");
        return;
    L91:
        return;
    L47:
        String r3 = r10.getKeyword();
        r10.setKeyword(r0);
        String r5 = com.bytedance.android.live.search.impl.search.a.a;
        String r6 = r10.getKeyword();
        if (r6 == null) goto L51;
        r4 = r6;
    L51:
        Intrinsics.checkNotNullParameter(r4, "<set-?>");
        com.bytedance.android.live.search.impl.search.a.a = r4;
        if (this.e != null) goto L58;
        LiveSearchContainerFragment r7 = new LiveSearchContainerFragment();
        b r8 = new b();
        r8.a = this.r;
        String r9 = this.v;
        Intrinsics.checkNotNullParameter(r9, "<set-?>");
        r8.f = r9;
        Unit r14 = Unit.INSTANCE;
        r7.k = r8;
        r7.n = this.u;
        this.e = r7;
        FragmentTransaction r15 = getChildFragmentManager().beginTransaction();
        LiveSearchContainerFragment r16 = this.e;
        Intrinsics.checkNotNull(r16);
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r15, r16, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_REPLACE, "container", 2131373275) == true) goto L57;
        r15 = r15.replace(2131373275, r16, "container");
    L57:
        r15.commitAllowingStateLoss();
    L58:
        this.m = 1;
        com.bytedance.android.live.search.impl.search.a.e = 1;
        LiveSearchIntermediateView r17 = this.d;
        if (r17 == null) goto L63;
        LiveSearchIntermediateViewModel r18 = r17.a;
        if (r18 == null) goto L63;
        r18.hideIntermediate();
    L63:
        EditText r19 = this.g;
        if (r19 == null) goto L66;
        r19.setText(r3);
    L66:
        View r20 = this.n;
        if (r20 == null) goto L69;
        r20.setVisibility(0);
    L69:
        EditText r22 = this.g;
        if (r22 == null) goto L72;
        r22.setCursorVisible(false);
    L72:
        int r23 = com.bytedance.android.live.search.impl.search.helper.a.a;
        com.bytedance.android.live.search.impl.search.helper.a.a(this.g);
        LiveSearchContainerFragment r24 = this.e;
        if (r24 == null) goto L92;
        String r110 = r10.getKeyword();
        Intrinsics.checkNotNull(r110);
        r24.T90(r110, r12);
        return;
    L92:
        return;
    L30:
        if (r0 == null) goto L41;
        f r25 = f.d;
        ra1.c r26 = new ra1.c(r0);
        r25.getClass();
        Intrinsics.checkNotNullParameter(r26, "history");
        List r27 = f.a();
        ArrayList r28 = new ArrayList();
        Iterator r29 = r27.iterator();
    L33:
        if (r29.hasNext() == false) goto L37;
        Object r30 = r29.next();
        if ((!TextUtils.equals(r26.a(), ((ra1.c) r30).a())) == false) goto L33;
        r28.add(r30);
        goto L33
    L37:
        List r32 = CollectionsKt.toMutableList(r28);
        ListProtector.add(r32, 0, r26);
        if (r32.size() <= 20) goto L40;
        r32 = r32.subList(0, 20);
    L40:
        f.b(r32);
        goto L41
    L8:
        if (r0 == null) goto L26;
        int r33 = r0.length() - 1;
        int r34 = 0;
        boolean r35 = false;
    L10:
        if (r34 > r33) goto L25;
        if (r35 == true) goto L13;
        int r36 = r34;
    L15:
        if (Intrinsics.compare(r0.charAt(r36), 32) > 0) goto L17;
        boolean r37 = true;
    L18:
        if (r35 == false) goto L19;
        if (r37 == false) goto L25;
        r33 = r33 - 1;
        goto L10
    L19:
        if (r37 == false) goto L20;
        r34 = r34 + 1;
        goto L10
    L20:
        r35 = true;
        goto L10
    L17:
        r37 = false;
        goto L18
    L13:
        r36 = r33;
    L25:
        String r38 = r0.subSequence(r34, r33 + 1).toString();
    L27:
        r2 = TextUtils.isEmpty(r38);
        goto L28
    L26:
        r38 = null;
        goto L27
    }

    public final void Z90(boolean r4, boolean r5) {
        pa1.d r0 = this.r;
        if (r0 == null) goto L6;
        r0.a(r4);
    L6:
        if (r4 == false) goto L18;
        EditText r6 = this.g;
        if (r6 == null) goto L10;
        r6.setHint(y);
    L10:
        View r7 = this.h;
        if (r7 == null) goto L13;
        r7.setVisibility(0);
    L13:
        View r8 = this.i;
        if (r8 == null) goto L16;
        r8.setVisibility(8);
    L16:
        if (r5 == false) goto L33;
        int r9 = g.a;
        g.a(y, "search_bar_inner");
        return;
    L33:
        return;
    L18:
        EditText r10 = this.g;
        if (r10 == null) goto L21;
        r10.setHint("");
    L21:
        TextView r12 = this.k;
        if (r12 == null) goto L24;
        r12.setText(y);
    L24:
        View r13 = this.h;
        if (r13 == null) goto L27;
        r13.setVisibility(8);
    L27:
        View r14 = this.i;
        if (r14 == null) goto L30;
        r14.setVisibility(0);
    L30:
        if (r5 == false) goto L35;
        int r15 = g.a;
        g.a(y, "search_bar_outer");
        return;
    }

    public final View onCreateView(LayoutInflater r3, ViewGroup r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r3, "inflater");
        View r6 = r3.inflate(2131567418, r4, false);
        LiveSearchIntermediateView r7 = (LiveSearchIntermediateView) r6.findViewById(2131385515);
        this.d = r7;
        if (r7 == null) goto L11;
        Intrinsics.checkNotNullParameter(this, "fragment");
        Intrinsics.checkNotNullParameter(this, "responder");
        FragmentActivity r8 = getActivity();
        r7.b = this;
        r7.c = getChildFragmentManager();
        if (r8 == null) goto L11;
        LiveSearchIntermediateViewModel r9 = (LiveSearchIntermediateViewModel) ViewModelProviders.of(r8).get(LiveSearchIntermediateViewModel.class);
        r7.a = r9;
        if (r9 == null) goto L11;
        NextLiveData<Integer> r10 = r9.getIntermediateState();
        if (r10 == null) goto L11;
        r10.observe(this, r7.f);
    L11:
        LiveSearchIntermediateView r12 = this.d;
        if (r12 == null) goto L14;
        r12.setOnDispatchTouchEventListener(new q(this));
    L14:
        LiveSearchIntermediateViewModel r13 = this.p;
        if (r13 == null) goto L19;
        NextLiveData<String> r14 = r13.getInputValue();
        if (r14 == null) goto L19;
        r14.observe(this, new r(this));
    L19:
        this.t = true;
        Bundle r15 = getArguments();
        if (r15 != null) goto L22;
    L24:
        ViewGroup r16 = this.f;
        ViewGroup.LayoutParams r17 = null;
        if (r16 == null) goto L27;
        View r18 = r16.getChildAt(0);
    L28:
        if (r18 != null) goto L30;
    L32:
        EditText r19 = this.g;
        if (r19 == null) goto L36;
        r19.setImeOptions(268435459);
    L36:
        if (U90() == false) goto L41;
        View r20 = this.j;
        if (r20 == null) goto L41;
        r20.setPadding(s1.f(16.0f), 0, 0, 0);
    L41:
        if ("V2005A".equals(Build.MODEL) == true) goto L43;
    L52:
        k r22 = this.s;
        if (r22 == null) goto L55;
        r22.run();
    L55:
        return r6;
    L43:
        if (puc.a.isVivoDevice() == false) goto L52;
        ViewGroup r23 = this.w;
        if (r23 == null) goto L48;
        r17 = r23.getLayoutParams();
    L48:
        if ((r17 instanceof RelativeLayout.LayoutParams) == false) goto L52;
        ((RelativeLayout.LayoutParams) r17).topMargin = s1.f(25.0f);
        ViewGroup r24 = this.w;
        if (r24 == null) goto L52;
        r24.setLayoutParams(r17);
        goto L52
    L30:
        if (U90() == false) goto L32;
        r18.setBackgroundResource(2131252927);
        goto L32
    L27:
        r18 = null;
        goto L28
    L22:
        if (r15.getBoolean("bundle_need_show_input_container_inside", false) == false) goto L24;
        ViewGroup r25 = (ViewGroup) r6.findViewById(2131378462);
        r25.setVisibility(0);
        View r26 = LayoutInflater.from(getContext()).inflate(2131567420, r25, false);
        r25.removeAllViews();
        r25.addView(r26);
        Y90(r25);
        this.w = r25;
        goto L24
    }
}
