package com.bytedance.android.live.revlink.impl.pk.dialog.fragment;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.android.live.revenue.common.k0;
import com.bytedance.android.live.revlink.impl.pk.dialog.contract.InteractPkBanContract$View;
import com.bytedance.android.live.uikit.rtl.AutoRTLImageView;
import com.bytedance.android.livesdk.chatroom.ui.SSLinearLayoutManager;
import com.bytedance.android.livesdk.link.model.j3;
import com.bytedance.android.livesdk.link.model.k3;
import com.bytedance.android.livesdk.link.model.u0;
import com.bytedance.android.livesdk.r3;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.badger.collect.impl.constants.Constants;
import com.bytedance.live.kmp.core.KmpEnv;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import me.drakeet.multitype.MultiTypeAdapter;
import x31.q;
import x31.r;
import y31.v;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/pk/dialog/fragment/InteractPkBanListFragment;", "Lcom/bytedance/android/live/revlink/impl/pk/dialog/contract/InteractPkBanContract$View;", "<init>", "()V", "a", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class InteractPkBanListFragment extends InteractPkBanContract$View {
    public static final /* synthetic */ int p = 0;
    public Map<Integer, View> g;
    public int h;
    public boolean i;
    public MultiTypeAdapter j;
    public ArrayList<Object> k;
    public final Handler l;
    public View m;
    public q n;
    public final String o;

    public static final class a {
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ InteractPkBanListFragment a;

        public b(InteractPkBanListFragment r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            InteractPkBanListFragment r3 = this.a;
            int r0 = InteractPkBanListFragment.p;
            r3.d.v0();
        }
    }

    public static final class c implements Runnable {
        public final /* synthetic */ InteractPkBanListFragment a;

        public c(InteractPkBanListFragment r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            InteractPkBanListFragment r0 = this.a;     // Catch: Throwable -> L6
            int r1 = InteractPkBanListFragment.p;     // Catch: Throwable -> L6
            r r2 = (r) r0.f;     // Catch: Throwable -> L6
            if (r2 == null) goto L9;
            r2.f("", true);     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }
    }

    static {
    }

    @Override // com.bytedance.android.live.revlink.impl.control.dialog.RevInteractDialogFragmentBaseContract$View
    public final float U90() {
        return 432.0f;
    }

    @Override // com.bytedance.android.live.revlink.impl.control.dialog.RevInteractDialogFragmentBaseContract$View
    public final View V90() {
        AutoRTLImageView r0 = new AutoRTLImageView(getContext());
        com.bytedance.android.live.core.resources.e.a r2 = com.bytedance.android.live.core.resources.e.Companion;
        r2.getClass();
        float r3 = 32;
        int r4 = s1.f(r3);
        r2.getClass();
        r0.setLayoutParams(new RelativeLayout.LayoutParams(r4, s1.f(r3)));
        r0.setImageDrawable(s1.m(2131251314));
        r0.setOnClickListener(new b(this));
        r3.c(r0, s1.B(2131918649), true);
        return r0;
    }

    @Override // com.bytedance.android.live.revlink.impl.control.dialog.RevInteractDialogFragmentBaseContract$View
    public final String X90() {
        if (this.h != 2) goto L10;
        Context r0 = getContext();
        if (r0 == null) goto L14;
        String r1 = r0.getString(2131914709);
        if (r1 != null) goto L15;
        return "";
    L15:
        return r1;
    L14:
        return "";
    L10:
        Context r2 = getContext();
        if (r2 == null) goto L16;
        r1 = r2.getString(2131914708);
        if (r1 != null) goto L15;
        return "";
    L16:
        return "";
    }

    @Override // com.bytedance.android.live.revlink.impl.pk.dialog.contract.InteractPkBanContract$View
    public final void ba0() {
        View r0 = this.m;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mPreloadProgressIcon");
    L5:
        r0.setVisibility(8);
        fa0(null);
    }

    public final Map<String, String> ea0() {
        LinkedHashMap r0 = new LinkedHashMap();
        yz0.k r1 = (yz0.k) com.bytedance.android.live.revenue.core.util.f.d(com.bytedance.android.live.revenue.core.util.j.C0.a(), yz0.k.class);
        if (r1 == null) goto L5;
        IRoom r2 = r1.getRoom();
    L6:
        if (r2 == null) goto L9;
        r0.put("anchor_id", String.valueOf(r2.getId()));
        r0.put("room_id", String.valueOf(iz.a.a(r2.getOwner())));
    L9:
        if (this.h != 2) goto L11;
        String r3 = DataType.TRUE;
    L12:
        r0.put("reject_type", r3);
        return r0;
    L11:
        r3 = "2";
        goto L12
    L5:
        r2 = null;
        goto L6
    }

    public InteractPkBanListFragment() {
        this.g = new LinkedHashMap();
        this.h = 2;
        this.i = true;
        this.l = new Handler();
        StringBuilder r0 = new StringBuilder("https://");
        String r1 = k0.a;
        r0.append(k0.a);
        r0.append("/obj/live-android/ttlive_bg_pk_ban_empty.png");
        this.o = r0.toString();
    }

    public final void onDestroy() {
        super.onDestroy();
        this.l.removeCallbacksAndMessages(null);
        r r0 = (r) this.f;
        if (r0 == null) goto L6;
        ((com.bytedance.android.livesdk.common.c) r0).a = null;
        return;
    }

    public final void onDestroyView() {
        super.onDestroyView();
        r r0 = (r) this.f;
        if (r0 == null) goto L5;
        r0.h();
    L5:
        ArrayList<Object> r1 = this.k;
        if (r1 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("dataList");
    L8:
        r1.clear();
        ((LinkedHashMap) this.g).clear();
    }

    public final void onResume() {
        super.onResume();
        if (this.i == false) goto L9;
        r r0 = (r) this.f;
        if (r0 == null) goto L7;
        r0.f("", true);
    L7:
        this.i = false;
        return;
    }

    @Override // com.bytedance.android.live.revlink.impl.pk.dialog.contract.InteractPkBanContract$View
    public final void ca0(k3 r3) {
        View r0 = this.m;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mPreloadProgressIcon");
    L5:
        r0.setVisibility(8);
        fa0(r3);
    }

    public final View da0(int r3) {
        if (this.g != null) goto L5;
        this.g = new LinkedHashMap();
    L5:
        View r0 = this.g.get(Integer.valueOf(r3));
        if (r0 != null) goto L14;
        View r1 = getView();
        if (r1 == null) goto L12;
        View r2 = r1.findViewById(r3);
        if (r2 == null) goto L12;
        this.g.put(Integer.valueOf(r3), r2);
        return r2;
    L12:
        return null;
    L14:
        return r0;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    public final void fa0(k3 r12) {
        String r3 = null;
        boolean r6 = false;
        if (r12 == null) goto L16;
        j3 r7 = r12.getList();
        if (r7 == null) goto L7;
        List r8 = r7.getList();
    L8:
        List r9 = r8;
        if (r9 != null) goto L11;
    L14:
        boolean r10 = true;
    L15:
        if (r10 == true) goto L16;
    L27:
        RecyclerView r2 = (RecyclerView) da0(2131384076);
        if (r2 == null) goto L30;
        r2.setVisibility(0);
    L30:
        LinearLayout r0 = (LinearLayout) da0(2131390556);
        if (r0 == null) goto L33;
        r0.setVisibility(8);
    L33:
        if (r12 == null) goto L109;
        j3 r1 = r12.getList();
        if (r1 == null) goto L110;
        List r4 = r1.getList();
        if (r4 == null) goto L111;
        MultiTypeAdapter r5 = this.j;
        if (r5 != null) goto L41;
        Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
    L41:
        j3 r13 = r12.getList();
        if (r13 == null) goto L44;
        r3 = r13.getNextCursor();
    L44:
        ArrayList<Object> r14 = this.k;
        if (r14 != null) goto L48;
        Intrinsics.throwUninitializedPropertyAccessException("dataList");
    L48:
        if (r14.isEmpty() == true) goto L64;
        ArrayList<Object> r15 = this.k;
        if (r15 != null) goto L52;
        Intrinsics.throwUninitializedPropertyAccessException("dataList");
    L52:
        ArrayList<Object> r16 = this.k;
        if (r16 != null) goto L56;
        Intrinsics.throwUninitializedPropertyAccessException("dataList");
    L56:
        if ((ListProtector.get(r15, r16.size() - 1) instanceof v.a) == false) goto L64;
        ArrayList<Object> r17 = this.k;
        if (r17 != null) goto L60;
        Intrinsics.throwUninitializedPropertyAccessException("dataList");
    L60:
        ArrayList<Object> r18 = this.k;
        if (r18 != null) goto L63;
        Intrinsics.throwUninitializedPropertyAccessException("dataList");
    L63:
        ListProtector.remove(r17, r18.size() - 1);
    L64:
        ArrayList<Object> r19 = this.k;
        if (r19 != null) goto L67;
        Intrinsics.throwUninitializedPropertyAccessException("dataList");
    L67:
        List r20 = r4;
        ArrayList r22 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r20, 10));
        Iterator r23 = r20.iterator();
    L69:
        if (r23.hasNext() == false) goto L71;
        u0 r24 = (u0) r23.next();
        y31.h.a r25 = new y31.h.a();
        r25.a = r24;
        r22.add(r25);
        goto L69
    L71:
        r19.addAll(r22);
        v.a r110 = new v.a();
        if (r3 != null) goto L74;
    L86:
        if (r3 != null) goto L88;
    L100:
        ArrayList<Object> r111 = this.k;
        if (r111 != null) goto L103;
        Intrinsics.throwUninitializedPropertyAccessException("dataList");
    L103:
        r5.a = r111;
        MultiTypeAdapter r112 = this.j;
        if (r112 != null) goto L106;
        Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
    L106:
        r112.notifyDataSetChanged();
        return;
    L88:
        if (r3.length() <= 0) goto L90;
        r6 = true;
    L90:
        if (r6 != true) goto L100;
        ArrayList<Object> r26 = this.k;
        if (r26 != null) goto L95;
        Intrinsics.throwUninitializedPropertyAccessException("dataList");
    L95:
        if (r26.size() <= 6) goto L100;
        r110.a = s1.B(2131917932);
        ArrayList<Object> r27 = this.k;
        if (r27 != null) goto L99;
        Intrinsics.throwUninitializedPropertyAccessException("dataList");
    L99:
        r27.add(r110);
        goto L100
    L74:
        if (r3.length() <= 0) goto L76;
        boolean r28 = true;
    L77:
        if (r28 != true) goto L86;
        ArrayList<Object> r29 = this.k;
        if (r29 != null) goto L82;
        Intrinsics.throwUninitializedPropertyAccessException("dataList");
    L82:
        if (r29.size() > 6) goto L86;
        r r113 = (r) this.f;
        if (r113 == null) goto L100;
        r113.e();
        goto L100
    L76:
        r28 = false;
        goto L77
    L111:
        return;
    L110:
        return;
    L109:
        return;
    L11:
        if (r9.isEmpty() == true) goto L14;
        r10 = false;
        goto L15
    L7:
        r8 = null;
    L16:
        ArrayList<Object> r30 = this.k;
        if (r30 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("dataList");
    L20:
        if (r30.isEmpty() == false) goto L27;
        RecyclerView r32 = (RecyclerView) da0(2131384076);
        if (r32 == null) goto L24;
        r32.setVisibility(8);
    L24:
        LinearLayout r33 = (LinearLayout) da0(2131390556);
        if (r33 == null) goto L33;
        r33.setVisibility(0);
        goto L33
    }

    public final void setUserVisibleHint(boolean r2) {
        super/*androidx.fragment.app.Fragment*/.setUserVisibleHint(r2);
        RecyclerView r0 = da0(2131384076);
        if (r0 == null) goto L6;
        r0.setNestedScrollingEnabled(r2);
        r0.requestLayout();
    L6:
        if (this.i == false) goto L10;
        if (r2 == false) goto L11;
        this.l.post(new c(this));
        this.i = false;
        return;
    L11:
        return;
    }

    public final void onViewCreated(View r6, Bundle r7) {
        Intrinsics.checkNotNullParameter(r6, "view");
        KmpEnv r0 = KmpEnv.a;
        if (KmpEnv.a() == false) goto L5;
        int r1 = 2131382879;
    L6:
        View r2 = r6.findViewById(r1);
        this.m = r2;
        if (r2 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("mPreloadProgressIcon");
    L9:
        r2.setVisibility(0);
        this.k = new ArrayList();
        MultiTypeAdapter r3 = new MultiTypeAdapter();
        this.j = r3;
        r3.z2(y31.h.a.class, new y31.h(this.h, this));
        MultiTypeAdapter r4 = this.j;
        if (r4 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
    L12:
        r4.z2(v.a.class, new v());
        RecyclerView r5 = da0(2131384076);
        MultiTypeAdapter r8 = this.j;
        if (r8 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
    L15:
        r5.setAdapter(r8);
        da0(2131384076).setLayoutManager(new SSLinearLayoutManager(getContext(), 1));
        da0(2131384076).setItemViewCacheSize(8);
        da0(2131384076).setItemAnimator(null);
        da0(2131384076).addOnScrollListener(new AnonymousClass1(this));
        ImageLoader.bindImage(da0(2131371584), this.o);
        mz0.n r9 = new mz0.n();
        Map<String, String> r10 = r9.a;
        Intrinsics.checkNotNullParameter(r10, "map");
        Map<String, String> r12 = ea0();
        Intrinsics.checkNotNullParameter(r12, "map");
        r10.putAll(r12);
        cy0.e.a.getClass();
        cy0.j r13 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r14 = com.bytedance.android.scope.m.b(r13).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r14);
        ((mz0.i) ((f80.a) r14)).w3("livesdk_reject_pk_anchor_settings_show", r9.a, r9.b);
        super.onViewCreated(r6, r7);
        return;
    L5:
        r1 = 2131382880;
        goto L6
    }

    @Override // x31.s
    public final void rd(final int r3, u0 r4) {
        Intrinsics.checkNotNullParameter(r4, Constants.Keys.DATA);
        r r0 = (r) this.f;
        if (r0 == null) goto L5;
        r0.g(r4, new InteractPkBanListFragment$onRemove$1(this, r3));
    L5:
        Map<String, String> r5 = ea0();
        r5.put("removed_anchor_id", String.valueOf(r4.getUserId()));
        mz0.n r6 = new mz0.n();
        Map<String, String> r1 = r6.a;
        Intrinsics.checkNotNullParameter(r1, "map");
        Intrinsics.checkNotNullParameter(r5, "map");
        r1.putAll(r5);
        cy0.e.a.getClass();
        cy0.j r7 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r8 = com.bytedance.android.scope.m.b(r7).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r8);
        ((mz0.i) ((f80.a) r8)).w3("livesdk_reject_pk_anchor_settings_click", r6.a, r6.b);
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        return r2.inflate(2131566056, r3, false);
    }
}
