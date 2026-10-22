package com.bytedance.android.live.search.impl.search;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.ui.BaseFragment;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.android.live.search.impl.search.adapter.LiveSearchResultAdapter;
import com.bytedance.android.live.search.impl.search.adapter.LiveSearchResultDecoration;
import com.bytedance.android.live.search.impl.search.callback.OnRecyclerViewFlingListener;
import com.bytedance.android.live.search.impl.search.model.LiveSearchResultParam;
import com.bytedance.android.live.search.impl.search.viewmodel.LiveSearchIntermediateViewModel;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livehostapi.business.IHostBusiness;
import com.bytedance.android.livesdk.utils.e5;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.feed.ArgumentsBuilder;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.google.gson.JsonObject;
import com.larus.apm.impl.protector.RunnableProtector;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
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
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\u00020\u0004B\u0007¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/live/search/impl/search/LiveSearchContainerFragment;", "Lcom/bytedance/android/live/core/ui/BaseFragment;", "Lqa1/d;", "Lra1/f;", "Lqa1/f;", "<init>", "()V", "livesearchimpl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveSearchContainerFragment extends BaseFragment implements qa1.d<ra1.f>, qa1.f {
    public RecyclerView d;
    public View e;
    public LiveSearchResultAdapter f;
    public boolean g;
    public LiveSearchIntermediateViewModel h;
    public final h i;
    public String j;
    public com.bytedance.android.live.search.impl.search.b k;
    public View l;
    public View m;
    public boolean n;
    public View o;
    public View p;
    public View q;
    public View r;
    public c s;
    public View t;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ LiveSearchContainerFragment a;

        /* JADX INFO: renamed from: com.bytedance.android.live.search.impl.search.LiveSearchContainerFragment$a$a, reason: collision with other inner class name */
        public static final class C0220a implements Observer<IBaseUser> {
            public final /* synthetic */ a a;

            public final void onComplete() {
            }

            public final void onError(Throwable r2) {
                Intrinsics.checkNotNullParameter(r2, "e");
            }

            public final void onSubscribe(Disposable r2) {
                Intrinsics.checkNotNullParameter(r2, "d");
            }

            public C0220a(a r1) {
                this.a = r1;
            }

            public final void onNext(Object r4) {
                Intrinsics.checkNotNullParameter((IBaseUser) r4, "iUser");
                LiveSearchContainerFragment r5 = this.a.a;
                h r0 = r5.i;
                String r1 = r5.j;
                boolean r6 = r5.n;
                int r2 = h.k;
                r0.a(r1, null, r6);
            }
        }

        public a(LiveSearchContainerFragment r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r4) {
            if (this.a.getActivity() == null) goto L6;
            com.bytedance.android.livesdk.user.f r5 = jc1.k.n(IUserService.class).user();
            FragmentActivity r0 = this.a.getActivity();
            com.bytedance.android.livesdk.user.l.a r1 = new com.bytedance.android.livesdk.user.l.a();
            r1.a = s1.B(2131920130);
            r5.login(r0, new com.bytedance.android.livesdk.user.l(r1)).subscribe(new C0220a(this));
            return;
        }
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ LiveSearchContainerFragment a;

        public b(LiveSearchContainerFragment r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r4) {
            LiveSearchContainerFragment r5 = this.a;
            h r0 = r5.i;
            String r1 = r5.j;
            boolean r6 = r5.n;
            int r2 = h.k;
            r0.a(r1, null, r6);
        }
    }

    public static final class c implements Runnable {
        public final /* synthetic */ LiveSearchContainerFragment a;
        public final /* synthetic */ String b;
        public final /* synthetic */ boolean c;

        public c(LiveSearchContainerFragment r1, String r2, boolean r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.T90(this.b, this.c);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public final String getSpm() {
        return "a100.a216";
    }

    @Override // qa1.d
    public final void k7() {
    }

    @Override // qa1.f
    public final void x1() {
    }

    @Override // qa1.f
    public final void preload() {
        if (this.g == false) goto L19;
        h r0 = this.i;
        String r5 = this.j;
        r0.getClass();
        Intrinsics.checkNotNullParameter(r5, "keyWord");
        if (r0.a == false) goto L8;
        return;
    L8:
        if ((r0.g instanceof ra1.b) == false) goto L10;
        r0.i.b(true, r5);
        return;
    L10:
        r0.a = true;
        r0.j.k7();
        ILiveSearchApi r1 = (ILiveSearchApi) com.bytedance.android.live.network.c.b().e(ILiveSearchApi.class);
        long r3 = r0.b;
        if (TextUtils.isEmpty(r0.f) == false) goto L13;
        String r7 = "normal_search";
    L14:
        String r9 = r0.c;
        String r10 = jc1.k.n(IHostBusiness.class).getNeedPersonalRecommend();
        if (r10 != null) goto L17;
        r10 = DataType.TRUE;
    L17:
        r0.h = r1.searchLiveList("https://search.amemv.com/aweme/v1/live/search/", r3, r5, 12, r7, "aweme_live_square", r9, r10, null).compose(RxUtil.rxSchedulerHelper()).subscribe(new i(r0), new j(r0));
        return;
    L13:
        r7 = r0.f;
        goto L14
    }

    @Override // qa1.d
    public final void r6() {
        View r0 = this.e;
        if (r0 == null) goto L5;
        r0.setVisibility(0);
    L5:
        View r1 = this.l;
        if (r1 == null) goto L8;
        r1.setVisibility(8);
    L8:
        View r2 = this.o;
        if (r2 == null) goto L11;
        r2.setVisibility(8);
    L11:
        this.g = false;
    }

    @Override // qa1.d
    public final void showLoading() {
        View r0 = this.e;
        if (r0 == null) goto L5;
        r0.setVisibility(8);
    L5:
        View r1 = this.l;
        if (r1 == null) goto L8;
        r1.setVisibility(8);
    L8:
        View r2 = this.o;
        if (r2 == null) goto L12;
        r2.setVisibility(8);
        return;
    }

    public LiveSearchContainerFragment() {
        this.i = new h(this);
        this.j = "";
    }

    @Override // qa1.f
    public final boolean hasMore() {
        return this.g;
    }

    public final void S90(boolean r6) {
        com.bytedance.android.livesdk.log.filter.o r0 = com.bytedance.android.livesdk.log.u.l().c(am2.t.class);
        if (r0 == null) goto L36;
        Map r1 = r0.getMap();
        if (r1 == null) goto L37;
        String r2 = DataType.TRUE;
        if (r6 == false) goto L9;
        Object r3 = DataType.TRUE;
    L10:
        r1.put("is_recommend", r3);
        if (r6 == true) goto L13;
        r1.remove("channel_id");
    L18:
        LiveSearchIntermediateViewModel r7 = this.h;
        if (r7 == null) goto L29;
        NextLiveData<LiveSearchResultParam> r8 = r7.getOpenSearchParam();
        if (r8 == null) goto L29;
        LiveSearchResultParam r9 = (LiveSearchResultParam) r8.getValue();
        if (r9 == null) goto L29;
        if (r9.isHintSearch() == true) goto L28;
        r2 = DataType.FALSE;
    L28:
        String r10 = (String) r1.put("is_default_search", r2);
    L29:
        com.bytedance.android.live.search.impl.search.b r12 = this.k;
        if (r12 == null) goto L33;
        String r13 = r12.f;
        if (r13 == null) goto L33;
    L34:
        r1.put("previous_page", r13);
        return;
    L33:
        r13 = "";
        goto L34
    L13:
        if (this.n == false) goto L15;
        String r14 = "10";
    L16:
        r1.put("channel_id", r14);
        goto L18
    L15:
        r14 = "21";
        goto L16
    L9:
        r3 = DataType.FALSE;
        goto L10
    L37:
        return;
    }

    @Override // qa1.d
    public final void cF(Exception r2) {
        Intrinsics.checkNotNullParameter(r2, "e");
        this.g = false;
    }

    @Override // qa1.d
    public final void dH(boolean r5) {
        View r0 = this.o;
        int r1 = 0;
        if (r0 == null) goto L5;
        r0.setVisibility(0);
    L5:
        View r2 = this.l;
        if (r2 == null) goto L8;
        r2.setVisibility(8);
    L8:
        View r3 = this.e;
        if (r3 == null) goto L11;
        r3.setVisibility(8);
    L11:
        View r4 = this.q;
        if (r4 == null) goto L17;
        if (r5 == false) goto L15;
        int r6 = 0;
    L16:
        r4.setVisibility(r6);
        goto L17
    L15:
        r6 = 8;
    L17:
        View r7 = this.p;
        if (r7 == null) goto L23;
        if (r5 == false) goto L21;
        r1 = 8;
    L21:
        r7.setVisibility(r1);
        return;
    }

    @Override // qa1.d
    public final void q10(Exception r2) {
        View r3 = this.e;
        if (r3 == null) goto L5;
        r3.setVisibility(8);
    L5:
        View r4 = this.o;
        if (r4 == null) goto L8;
        r4.setVisibility(8);
    L8:
        this.g = false;
        View r0 = this.l;
        if (r0 == null) goto L12;
        r0.setVisibility(0);
        return;
    }

    @Override // qa1.d
    public final void Ac(JsonObject r6, String r7) {
        Intrinsics.checkNotNullParameter(r7, "implId");
        LiveSearchIntermediateViewModel r1 = this.h;
        if (r1 == null) goto L20;
        NextLiveData<LiveSearchResultParam> r2 = r1.getOpenSearchParam();
        if (r2 == null) goto L21;
        LiveSearchResultParam r3 = (LiveSearchResultParam) r2.getValue();
        if (r3 == null) goto L22;
        int r4 = g.a;
        String r5 = r3.getKeyword();
        if (r5 != null) goto L11;
        r5 = "";
    L11:
        String r8 = r3.getEnterMethod();
        if (r6 != null) goto L14;
        r6 = new JsonObject();
    L14:
        Intrinsics.checkNotNullParameter(r5, "keyword");
        Intrinsics.checkNotNullParameter(r8, "enterMethod");
        Intrinsics.checkNotNullParameter(r6, "logPb");
        Intrinsics.checkNotNullParameter(r7, "implId");
        HashMap r0 = new HashMap();
        r0.put("enter_from", "live_square");
        r0.put("enter_method", r8);
        r0.put("search_type", "live_square");
        r0.put("search_keyword", r5);
        r0.put("log_pb", r6.toString());
        r0.put("impl_id", r7);
        com.bytedance.android.livesdk.log.u.l().e("search", r0, new Object[0]);
        HashMap r9 = new HashMap();
        if (e5.n() == false) goto L17;
        String r10 = "landscape";
    L18:
        r9.put("screen_direction", r10);
        r9.put("user_id", jc1.k.n(IUserService.class).user().n());
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_drawer_search_confirm", r9, new Object[]{Room.class});
        return;
    L17:
        r10 = "portrait";
        goto L18
    L22:
        return;
    L21:
        return;
    }

    @Override // qa1.d
    public final void C6(List r8, boolean r9) {
        Intrinsics.checkNotNullParameter(r8, "list");
        LiveSearchResultAdapter r0 = this.f;
        if (r0 == null) goto L56;
        ArrayList r1 = new ArrayList();
        Iterator r10 = r8.iterator();
    L6:
        if (r10.hasNext() == false) goto L10;
        ra1.a r2 = ((ra1.f) r10.next()).a();
        if (r2 == null) goto L6;
        r1.add(r2);
        goto L6
    L10:
        Intrinsics.checkNotNullParameter(r1, "rooms");
        ((ArrayList) r0.a).addAll(r1);
        r0.notifyItemRangeInserted(((ArrayList) r0.a).size() - r1.size(), r1.size());
        com.bytedance.android.live.search.impl.search.b r12 = r0.d;
        if (r12 == null) goto L22;
        List<ra1.a> r3 = r0.a;
        ArrayList r4 = new ArrayList();
        Iterator r5 = ((ArrayList) r3).iterator();
    L14:
        if (r5.hasNext() == false) goto L21;
        Room r6 = ((ra1.a) r5.next()).b();
        if (r6 == null) goto L18;
        Long r7 = Long.valueOf(r6.id);
    L19:
        if (r7 == null) goto L14;
        r4.add(r7);
        goto L14
    L18:
        r7 = null;
        goto L19
    L21:
        r12.b = CollectionsKt.toLongArray(r4);
    L22:
        com.bytedance.android.live.search.impl.search.b r13 = r0.d;
        if (r13 == null) goto L29;
        List<ra1.a> r14 = r0.a;
        ArrayList r15 = new ArrayList();
        Iterator r16 = ((ArrayList) r14).iterator();
    L26:
        if (r16.hasNext() == false) goto L28;
        r15.add(Integer.valueOf(ArgumentsBuilder.getRoomType(((ra1.a) r16.next()).b())));
        goto L26
    L28:
        r13.c = CollectionsKt.toIntArray(r15);
    L29:
        com.bytedance.android.live.search.impl.search.b r17 = r0.d;
        if (r17 == null) goto L45;
        List<ra1.a> r18 = r0.a;
        ArrayList r19 = new ArrayList();
        Iterator r20 = ((ArrayList) r18).iterator();
    L33:
        if (r20.hasNext() == false) goto L40;
        Room r22 = ((ra1.a) r20.next()).b();
        if (r22 == null) goto L37;
        String r23 = r22.getRequestId();
    L38:
        if (r23 == null) goto L33;
        r19.add(r23);
        goto L33
    L37:
        r23 = null;
        goto L38
    L40:
        Object[] r24 = r19.toArray(new String[0]);
        if (r24 == null) goto L44;
        r17.d = (String[]) r24;
        goto L45
    L44:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    L45:
        com.bytedance.android.live.search.impl.search.b r25 = r0.d;
        if (r25 == null) goto L56;
        List<ra1.a> r26 = r0.a;
        ArrayList r27 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r26, 10));
        Iterator r28 = ((ArrayList) r26).iterator();
    L49:
        if (r28.hasNext() == false) goto L51;
        r27.add(((ra1.a) r28.next()).a());
        goto L49
    L51:
        Object[] r29 = r27.toArray(new String[0]);
        if (r29 == null) goto L55;
        r25.e = (String[]) r29;
        goto L56
    L55:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    L56:
        this.g = r9;
    }

    public final void T90(String r8, boolean r9) {
        Intrinsics.checkNotNullParameter(r8, "keyword");
        LiveSearchResultAdapter r0 = this.f;
        if (r0 == null) goto L57;
        r0.y2(new ArrayList(), "");
        LiveSearchResultAdapter r1 = this.f;
        if (r1 == null) goto L7;
        r1.notifyDataSetChanged();
    L7:
        View r2 = this.t;
        if (r2 == null) goto L10;
        r2.setVisibility(8);
    L10:
        this.j = r8;
        Unit r3 = null;
        if (r9 == false) goto L49;
        h r10 = this.i;
        boolean r4 = this.n;
        r10.getClass();
        Intrinsics.checkNotNullParameter(r8, "keyWord");
        e r5 = r10.i;
        if (r4 == false) goto L15;
        int r6 = 10;
    L16:
        r5.b = r6;
        if (r4 == false) goto L19;
        String r7 = "homepage_fresh-live_cover";
    L20:
        Intrinsics.checkNotNullParameter(r7, "<set-?>");
        r5.c = r7;
        ra1.e r12 = com.bytedance.android.live.search.impl.search.a.f;
        if (r12 == null) goto L45;
        List<ra1.f> r13 = r12.f();
        if (r13 != null) goto L25;
    L27:
        boolean r14 = false;
    L28:
        if (r14 == true) goto L31;
        r12 = null;
    L31:
        if (r12 == null) goto L45;
        r10.g = r12.a();
        r10.a = false;
        r10.d = r12.d();
        r10.b = r12.c();
        r10.c = r12.e();
        boolean r15 = r12 instanceof ra1.b;
        if (r15 == false) goto L35;
        r10.i.d = ((ra1.b) r12).a;
    L35:
        List<ra1.f> r16 = r12.f();
        if (r16 != null) goto L38;
    L43:
        if (r3 == null) goto L45;
        return;
    L38:
        if ((true ^ r16.isEmpty()) == true) goto L41;
        r16 = null;
    L41:
        if (r16 == null) goto L43;
        r10.j.Kx(r16, r10.d, r8, r15);
        r3 = Unit.INSTANCE;
        goto L43
    L25:
        if ((!r13.isEmpty()) != true) goto L27;
        r14 = true;
    L45:
        if (TextUtils.isEmpty(r10.f) == false) goto L47;
        String r17 = "normal_search";
    L48:
        r10.a(r8, r17, r4);
        Unit r18 = Unit.INSTANCE;
        return;
    L47:
        r17 = r10.f;
        goto L48
    L19:
        r7 = "live_merge-live_cover";
        goto L20
    L15:
        r6 = 21;
        goto L16
    L49:
        LiveSearchIntermediateViewModel r19 = this.h;
        if (r19 == null) goto L56;
        NextLiveData<LiveSearchResultParam> r20 = r19.getOpenSearchParam();
        if (r20 == null) goto L56;
        LiveSearchResultParam r22 = (LiveSearchResultParam) r20.getValue();
        if (r22 == null) goto L56;
        r3 = r22.getEnterMethod();
    L56:
        this.i.a(r8, r3, this.n);
        return;
    L57:
        this.s = new c(this, r8, r9);
    }

    public final View onCreateView(LayoutInflater r6, ViewGroup r7, Bundle r8) {
        Intrinsics.checkNotNullParameter(r6, "inflater");
        View r9 = r6.inflate(2131567416, r7, false);
        FragmentActivity r10 = getActivity();
        if (r10 == null) goto L5;
        this.f = new LiveSearchResultAdapter(r10, this.k);
    L5:
        this.d = r9.findViewById(2131384076);
        this.e = r9.findViewById(2131371589);
        this.o = r9.findViewById(2131377882);
        this.p = r9.findViewById(2131377884);
        this.q = r9.findViewById(2131377883);
        this.r = r9.findViewById(2131389763);
        this.t = r9.findViewById(2131378461);
        TextView r12 = (TextView) r9.findViewById(2131378460);
        if (r12 == null) goto L14;
        IHostBusiness r13 = jc1.k.f(IHostBusiness.class);
        if (r13 != null) goto L10;
    L12:
        String r14 = s1.B(2131922365);
    L13:
        r12.setText(r14);
        goto L14
    L10:
        if (r13.isEnablePersonalRecommend() != true) goto L12;
        r14 = s1.B(2131922364);
    L14:
        View r15 = this.r;
        if (r15 == null) goto L17;
        r15.setOnClickListener(new a(this));
    L17:
        this.l = r9.findViewById(2131380670);
        View r16 = r9.findViewById(2131385585);
        this.m = r16;
        if (r16 == null) goto L20;
        r16.setOnClickListener(new b(this));
    L20:
        RecyclerView r17 = this.d;
        if (r17 == null) goto L26;
        GridLayoutManager r18 = new GridLayoutManager(getContext(), 2);
        r18.setSpanSizeLookup(new LiveSearchContainerFragment$getLayoutManager$1$1());
        r17.setLayoutManager(r18);
        OnRecyclerViewFlingListener r19 = new OnRecyclerViewFlingListener(r17, this);
        r19.e = 2;
        Unit r1 = Unit.INSTANCE;
        r17.setOnFlingListener(r19);
        r17.setAdapter(this.f);
        r17.setBackgroundColor(ColorProtector.parseColor("#f3000000"));
        RecyclerView r20 = this.d;
        if (r20 == null) goto L25;
        r20.setPadding(r20.getPaddingLeft(), r20.getPaddingTop(), r20.getPaddingRight(), r20.getPaddingBottom());
    L25:
        r17.addItemDecoration(new LiveSearchResultDecoration());
    L26:
        Context r22 = getContext();
        if ((r22 instanceof FragmentActivity) == true) goto L29;
        r22 = null;
    L29:
        FragmentActivity r23 = (FragmentActivity) r22;
        if (r23 == null) goto L32;
        this.h = (LiveSearchIntermediateViewModel) ViewModelProviders.of(r23).get(LiveSearchIntermediateViewModel.class);
    L32:
        c r24 = this.s;
        if (r24 == null) goto L35;
        r24.run();
    L35:
        this.s = null;
        if (com.bytedance.android.livesdk.utils.landscape.b.b() == true) goto L38;
        boolean r25 = false;
    L39:
        if (r25 == false) goto L43;
        RecyclerView r26 = this.d;
        if (r26 == null) goto L43;
        r26.setBackgroundColor(0);
    L43:
        return r9;
    L38:
        r25 = e5.n();
        goto L39
    }

    @Override // qa1.d
    public final void Hm(List r6, boolean r7, String r8, boolean r9) {
        Intrinsics.checkNotNullParameter(r6, "list");
        Intrinsics.checkNotNullParameter(r8, "keyword");
        View r0 = this.l;
        int r1 = 8;
        if (r0 == null) goto L5;
        r0.setVisibility(8);
    L5:
        View r2 = this.e;
        if (r2 == null) goto L8;
        r2.setVisibility(8);
    L8:
        View r3 = this.o;
        if (r3 == null) goto L11;
        r3.setVisibility(8);
    L11:
        LiveSearchResultAdapter r4 = this.f;
        if (r4 == null) goto L20;
        ArrayList r5 = new ArrayList();
        Iterator r10 = r6.iterator();
    L15:
        if (r10.hasNext() == false) goto L19;
        ra1.a r12 = ((ra1.f) r10.next()).a();
        if (r12 == null) goto L15;
        r5.add(r12);
        goto L15
    L19:
        r4.y2(r5, r8);
    L20:
        this.g = r7;
        View r13 = this.t;
        if (r13 == null) goto L25;
        if (r9 == false) goto L24;
        r1 = 0;
    L24:
        r13.setVisibility(r1);
    L25:
        if (r7 == true) goto L27;
    L29:
        S90(r9);
        return;
    L27:
        if (r6.size() > 6) goto L29;
        preload();
        goto L29
    }

    @Override // qa1.d
    public final void Kx(List r5, boolean r6, String r7, boolean r8) {
        Intrinsics.checkNotNullParameter(r5, "list");
        Intrinsics.checkNotNullParameter(r7, "keyword");
        View r0 = this.l;
        int r1 = 8;
        if (r0 == null) goto L5;
        r0.setVisibility(8);
    L5:
        View r2 = this.e;
        if (r2 == null) goto L8;
        r2.setVisibility(8);
    L8:
        View r3 = this.o;
        if (r3 == null) goto L11;
        r3.setVisibility(8);
    L11:
        LiveSearchResultAdapter r4 = this.f;
        if (r4 == null) goto L20;
        ArrayList r9 = new ArrayList();
        Iterator r10 = r5.iterator();
    L15:
        if (r10.hasNext() == false) goto L19;
        ra1.a r12 = ((ra1.f) r10.next()).a();
        if (r12 == null) goto L15;
        r9.add(r12);
        goto L15
    L19:
        r4.y2(r9, r7);
    L20:
        this.g = r6;
        View r13 = this.t;
        if (r13 == null) goto L25;
        if (r8 == false) goto L24;
        r1 = 0;
    L24:
        r13.setVisibility(r1);
    L25:
        S90(r8);
    }
}
