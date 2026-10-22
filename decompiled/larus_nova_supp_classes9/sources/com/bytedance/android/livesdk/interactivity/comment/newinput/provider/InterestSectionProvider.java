package com.bytedance.android.livesdk.interactivity.comment.newinput.provider;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.network.response.BaseResponse;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.livesdk.interactivity.comment.api.InterestChatApi;
import com.bytedance.android.livesdk.interactivity.comment.newinput.framework.InputPanelSectionContainer;
import com.bytedance.android.livesdk.interactivity.comment.newinput.framework.InputSectionType;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import me.drakeet.multitype.MultiTypeAdapter;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class InterestSectionProvider implements com.bytedance.android.livesdk.interactivity.comment.newinput.framework.k<InterestPanelController, Object> {
    public final InputSectionType a;
    public com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g b;
    public InterestPanelController c;
    public View d;

    public final class InterestPanelController extends com.bytedance.android.livesdk.interactivity.comment.newinput.framework.j {
        public final LinearLayout c;
        public final RecyclerView d;
        public final TextView e;
        public final TextView f;
        public final LinearLayout g;
        public final TextView h;
        public Disposable i;
        public final int j;
        public final Integer k;
        public final List<Integer> l;
        public final List<Long> m;
        public final String n;
        public final int o;
        public final int p;
        public final GridLayoutManager q;
        public final MultiTypeAdapter r;
        public boolean s;
        public final InterestSectionProvider$InterestPanelController$itemDecoration$1 t;
        public final com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g u;
        public final /* synthetic */ InterestSectionProvider v;

        public final class InterestKpViewBinder extends me.drakeet.multitype.b<com.bytedance.android.livesdk.interactivity.comment.model.a, InterestKpViewHolder> {
            public final Function1<com.bytedance.android.livesdk.interactivity.comment.model.a, Unit> b;
            public final /* synthetic */ InterestPanelController c;

            @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/comment/newinput/provider/InterestSectionProvider$InterestPanelController$InterestKpViewBinder$InterestKpViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
            public final class InterestKpViewHolder extends RecyclerView.ViewHolder {
                public final TextView a;
                public final /* synthetic */ InterestKpViewBinder b;

                public InterestKpViewHolder(InterestKpViewBinder r2, View r3) {
                    Intrinsics.checkNotNullParameter(r3, "itemView");
                    this.b = r2;
                    super(r3);
                    this.a = (TextView) r3.findViewById(2131375808);
                }
            }

            /* JADX WARN: Multi-variable type inference failed */
            public InterestKpViewBinder(InterestPanelController r2, Function1<? super com.bytedance.android.livesdk.interactivity.comment.model.a, Unit> r3) {
                Intrinsics.checkNotNullParameter(r3, "onItemSelect");
                this.c = r2;
                this.b = r3;
            }

            public final void b(RecyclerView.ViewHolder r7, Object r8) {
                InterestKpViewHolder r9 = (InterestKpViewHolder) r7;
                com.bytedance.android.livesdk.interactivity.comment.model.a r10 = (com.bytedance.android.livesdk.interactivity.comment.model.a) r8;
                Intrinsics.checkNotNullParameter(r9, "vh");
                Intrinsics.checkNotNullParameter(r10, "item");
                int r0 = r9.getAdapterPosition();
                Intrinsics.checkNotNullParameter(r10, "kpMeta");
                r9.a.setText(r10.b());
                r9.a.setSelected(((ArrayList) r9.b.c.l).contains(Integer.valueOf(r0)));
                if (((ArrayList) r9.b.c.m).contains(Long.valueOf(r10.a())) == true) goto L5;
                int r1 = com.bytedance.android.livesdk.interactivity.comment.utils.i.a;
                Intrinsics.checkNotNullParameter(r10, "kp");
                HashMap r2 = new HashMap();
                r2.put("module_name", "comment_expansion");
                r2.put("element_name", "interest_tag");
                r2.put("tag_id", String.valueOf(r10.a()));
                r2.put("tag_text", String.valueOf(r10.b()));
                com.bytedance.android.livesdk.log.j0.l().sendLog("livesdk_interest_card_show", r2, new Object[]{IRoom.class, new am2.x()});
                ((ArrayList) r9.b.c.m).add(Long.valueOf(r10.a()));
            L5:
                ((RecyclerView.ViewHolder) r9).itemView.setOnClickListener(new g0(r9, r0, r10));
            }

            public final RecyclerView.ViewHolder d(LayoutInflater r4, ViewGroup r5) {
                Intrinsics.checkNotNullParameter(r4, "inflater");
                Intrinsics.checkNotNullParameter(r5, "parent");
                return new InterestKpViewHolder(this, r4.inflate(2131565320, r5, false));
            }
        }

        public static final class a<T> implements Consumer {
            public final /* synthetic */ InterestPanelController a;

            public a(InterestPanelController r1) {
                this.a = r1;
            }

            public final void accept(Object r5) {
                com.bytedance.android.livesdk.interactivity.comment.model.b r6 = (com.bytedance.android.livesdk.interactivity.comment.model.b) ((BaseResponse) ((Response) r5)).data;
                if (r6 == null) goto L8;
                this.a.f.setText(r6.b());
                List<com.bytedance.android.livesdk.interactivity.comment.model.a> r7 = r6.a();
                if (r7 == null) goto L7;
                MultiTypeAdapter r1 = this.a.r;
                r1.a = r7;
                r1.notifyDataSetChanged();
                InterestPanelController.g(this.a, false);
            L9:
                this.a.s = false;
                return;
            L7:
                InterestPanelController.g(this.a, true);
                goto L9
            L8:
                InterestPanelController.g(this.a, true);
                goto L9
            }
        }

        public static final class b<T> implements Consumer {
            public final /* synthetic */ InterestPanelController a;

            public b(InterestPanelController r1) {
                this.a = r1;
            }

            public final void accept(Object r4) {
                Throwable r5 = (Throwable) r4;
                if (r5 == null) goto L15;
                String r6 = ga2.e.a(r5);
                if (r6 == null) goto L15;
                if (r6.length() <= 0) goto L9;
                boolean r2 = true;
            L10:
                if (r2 == true) goto L13;
                r6 = null;
            L13:
                if (r6 == null) goto L15;
                com.bytedance.android.live.core.utils.f2.c(r6, 0);
                goto L15
            L9:
                r2 = false;
            L15:
                InterestPanelController.g(this.a, true);
                this.a.s = false;
            }
        }

        public final Set<com.bytedance.android.livesdk.interactivity.comment.model.a> h() {
            com.bytedance.android.livesdk.interactivity.comment.newinput.c r0 = this.u.V();
            if (r0 == null) goto L7;
            com.bytedance.android.livesdk.interactivity.comment.newinput.a r1 = r0.g;
            if (r1 == null) goto L7;
            return r1.y;
        L7:
            return null;
        }

        public final void i() {
            if (this.s == false) goto L5;
            return;
        L5:
            ((ArrayList) this.l).clear();
            ((ArrayList) this.m).clear();
            Disposable r0 = this.i;
            if (r0 == null) goto L8;
            r0.dispose();
        L8:
            this.s = true;
            InterestChatApi.a.getClass();
            InterestChatApi r1 = (InterestChatApi) com.bytedance.android.live.network.c.b().e(InterestChatApi.class);
            if (r1 == null) goto L21;
            com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r2 = this.v.b;
            if (r2 == null) goto L13;
            long r3 = r2.Z();
        L14:
            Observable<Response<com.bytedance.android.livesdk.interactivity.comment.model.b>> r4 = r1.getInterestWord(r3);
            if (r4 == null) goto L21;
            Observable r5 = r4.subscribeOn(Schedulers.io());
            if (r5 == null) goto L21;
            Observable r6 = r5.observeOn(AndroidSchedulers.mainThread());
            if (r6 == null) goto L21;
            Disposable r7 = r6.subscribe(new a(this), new b(this));
        L22:
            this.i = r7;
            return;
        L13:
            r3 = 0;
        L21:
            r7 = null;
            goto L22
        }

        public static final void g(InterestPanelController r0, boolean r1) {
            if (r1 == false) goto L4;
            UtilityKotlinExtentionsKt.t(r0.c);
            UtilityKotlinExtentionsKt.w(r0.g);
            return;
        L4:
            UtilityKotlinExtentionsKt.w(r0.c);
            UtilityKotlinExtentionsKt.t(r0.g);
        }

        /* JADX WARN: Type inference failed for: r3v21, types: [com.bytedance.android.livesdk.interactivity.comment.newinput.provider.InterestSectionProvider$InterestPanelController$itemDecoration$1] */
        public InterestPanelController(InterestSectionProvider r3, View r4, com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r5) {
            Intrinsics.checkNotNullParameter(r4, "itemView");
            Intrinsics.checkNotNullParameter(r5, "panelBridges");
            this.v = r3;
            super(r4, r5);
            this.u = r5;
            this.c = (LinearLayout) this.a.findViewById(2131367794);
            this.d = this.a.findViewById(2131375558);
            this.e = (TextView) this.a.findViewById(2131384137);
            this.f = (TextView) this.a.findViewById(2131388741);
            this.g = (LinearLayout) this.a.findViewById(2131371756);
            this.h = (TextView) this.a.findViewById(2131371750);
            this.j = 3;
            this.k = (Integer) ec2.q.a.getValue();
            this.l = new ArrayList();
            this.m = new ArrayList();
            this.n = "、";
            this.o = UtilityKotlinExtentionsKt.i(8);
            this.p = UtilityKotlinExtentionsKt.i(12);
            this.q = new GridLayoutManager(this.a.getContext(), 3, 1, false);
            this.r = new MultiTypeAdapter();
            this.t = new InterestSectionProvider$InterestPanelController$itemDecoration$1(this);
        }
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.k
    public final void a() {
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.k
    public final void f() {
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.k
    public final void g(boolean r1) {
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.k
    public final void d() {
        InterestPanelController r0 = this.c;
        if (r0 == null) goto L9;
        Disposable r1 = r0.i;
        if (r1 == null) goto L7;
        r1.dispose();
    L7:
        r0.i = null;
        ((ArrayList) r0.l).clear();
        ((ArrayList) r0.m).clear();
        return;
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.k
    public final void e() {
        View r0 = this.d;
        if (r0 == null) goto L14;
        com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r1 = this.b;
        if (r1 != null) goto L7;
    L9:
        com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r2 = this.b;
        if (r2 == null) goto L12;
        int r3 = r2.W();
    L13:
        com.bytedance.android.live.core.utils.a1.k(r0, r3);
        goto L14
    L12:
        r3 = 0;
        goto L13
    L7:
        if (r1.W() != 0) goto L9;
        int r4 = InputPanelSectionContainer.m;
        r3 = InputPanelSectionContainer.m;
    L14:
        com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r5 = this.b;
        if (r5 == null) goto L21;
        Context r6 = r5.getContext();
        if (r6 == null) goto L21;
        com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r7 = this.b;
        if (r7 == null) goto L21;
        r7.t(r6);
    L21:
        InterestPanelController r8 = this.c;
        if (r8 == null) goto L28;
        ((ArrayList) r8.l).clear();
        Set<com.bytedance.android.livesdk.interactivity.comment.model.a> r9 = r8.h();
        if (r9 == null) goto L26;
        r9.clear();
    L26:
        ((ArrayList) r8.m).clear();
        r8.r.notifyDataSetChanged();
        return;
    }

    public InterestSectionProvider() {
        this.a = InputSectionType.INTEREST;
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.k
    public final InputSectionType b() {
        return this.a;
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.k
    public final com.bytedance.android.livesdk.interactivity.comment.newinput.framework.j c() {
        return this.c;
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.k
    public final View h(com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r6) {
        Intrinsics.checkNotNullParameter(r6, "panelBridge");
        Activity r0 = r6.getActivity();
        if (r0 != null) goto L5;
        return null;
    L5:
        this.b = r6;
        View r1 = LayoutInflater.from(r0).inflate(2131566064, null);
        this.d = r1;
        final InterestPanelController r2 = new InterestPanelController(this, r1, r6);
        r2.d.setLayoutManager(r2.q);
        r2.d.addItemDecoration(r2.t);
        r2.r.z2(com.bytedance.android.livesdk.interactivity.comment.model.a.class, new InterestPanelController.InterestKpViewBinder(r2, new InterestSectionProvider$InterestPanelController$init$1(r2)));
        r2.d.setAdapter(r2.r);
        r2.e.setOnClickListener(new h0(r2));
        r2.h.setOnClickListener(new i0(r2));
        r2.i();
        Unit r7 = Unit.INSTANCE;
        this.c = r2;
        return r1;
    }
}
