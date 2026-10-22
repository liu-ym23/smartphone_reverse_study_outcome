package com.bytedance.android.livesdk.interactivity.comment.newinput.provider;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.network.response.BaseResponse;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.livesdk.interactivity.comment.api.TruthQuestionApi;
import com.bytedance.android.livesdk.interactivity.comment.newinput.framework.InputPanelSectionContainer;
import com.bytedance.android.livesdk.interactivity.comment.newinput.framework.InputSectionType;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.bdlocation.BuildConfig;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import me.drakeet.multitype.MultiTypeAdapter;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class TruthSectionProvider implements com.bytedance.android.livesdk.interactivity.comment.newinput.framework.k<TruthPanelController, Object> {
    public final InputSectionType a;
    public com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g b;
    public TruthPanelController c;
    public View d;

    public final class TruthPanelController extends com.bytedance.android.livesdk.interactivity.comment.newinput.framework.j {
        public final LinearLayout c;
        public final RecyclerView d;
        public final TextView e;
        public final LinearLayout f;
        public final TextView g;
        public a h;
        public boolean i;
        public Disposable j;
        public final LinearLayoutManager k;
        public final MultiTypeAdapter l;
        public final List<Long> m;
        public final /* synthetic */ TruthSectionProvider n;

        public final class TruthQuestionViewBinder extends me.drakeet.multitype.b<a, TruthQuestionViewHolder> {
            public final Function1<com.bytedance.android.livesdk.interactivity.comment.model.c, Unit> b;
            public final /* synthetic */ TruthPanelController c;

            @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/comment/newinput/provider/TruthSectionProvider$TruthPanelController$TruthQuestionViewBinder$TruthQuestionViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
            public final class TruthQuestionViewHolder extends RecyclerView.ViewHolder {
                public final TextView a;
                public final /* synthetic */ TruthQuestionViewBinder b;

                public TruthQuestionViewHolder(TruthQuestionViewBinder r2, View r3) {
                    Intrinsics.checkNotNullParameter(r3, "itemView");
                    this.b = r2;
                    super(r3);
                    this.a = (TextView) r3.findViewById(2131383536);
                }
            }

            /* JADX WARN: Multi-variable type inference failed */
            public TruthQuestionViewBinder(TruthPanelController r2, Function1<? super com.bytedance.android.livesdk.interactivity.comment.model.c, Unit> r3) {
                Intrinsics.checkNotNullParameter(r3, "onItemSelect");
                this.c = r2;
                this.b = r3;
            }

            public final void b(RecyclerView.ViewHolder r7, Object r8) {
                TruthQuestionViewHolder r9 = (TruthQuestionViewHolder) r7;
                a r10 = (a) r8;
                Intrinsics.checkNotNullParameter(r9, "vh");
                Intrinsics.checkNotNullParameter(r10, "item");
                int r0 = r9.getAdapterPosition();
                Intrinsics.checkNotNullParameter(r10, "questionData");
                r9.a.setText(r10.a.a());
                r9.a.setSelected(r10.b);
                if (((ArrayList) r9.b.c.m).contains(Long.valueOf(r10.a.b())) == true) goto L8;
                int r1 = com.bytedance.android.livesdk.interactivity.comment.utils.i.a;
                com.bytedance.android.livesdk.interactivity.comment.model.c r2 = r10.a;
                Intrinsics.checkNotNullParameter(r2, "questionMeta");
                HashMap r3 = new HashMap();
                r3.put("module_name", "comment_expansion");
                r3.put("element_name", "question");
                r3.put("question_id", String.valueOf(r2.b()));
                String r4 = r2.a();
                if (r4 != null) goto L7;
                r4 = BuildConfig.FLAVOR;
            L7:
                r3.put("question_text", r4);
                com.bytedance.android.livesdk.log.j0.l().sendLog("livesdk_truth_question_show", r3, new Object[]{IRoom.class, new am2.x()});
                ((ArrayList) r9.b.c.m).add(Long.valueOf(r10.a.b()));
            L8:
                ((RecyclerView.ViewHolder) r9).itemView.setOnClickListener(new p1(r9, r10, r0));
            }

            public final RecyclerView.ViewHolder d(LayoutInflater r4, ViewGroup r5) {
                Intrinsics.checkNotNullParameter(r4, "inflater");
                Intrinsics.checkNotNullParameter(r5, "parent");
                return new TruthQuestionViewHolder(this, r4.inflate(2131565322, r5, false));
            }
        }

        public final class a {
            public final com.bytedance.android.livesdk.interactivity.comment.model.c a;
            public boolean b;

            public a(com.bytedance.android.livesdk.interactivity.comment.model.c r2) {
                Intrinsics.checkNotNullParameter(r2, "questionData");
                this.a = r2;
                this.b = false;
            }
        }

        public static final class b<T> implements Consumer {
            public final /* synthetic */ TruthPanelController a;

            public b(TruthPanelController r1) {
                this.a = r1;
            }

            public final void accept(Object r10) {
                com.bytedance.android.livesdk.interactivity.comment.model.d r11 = (com.bytedance.android.livesdk.interactivity.comment.model.d) ((BaseResponse) ((Response) r10)).data;
                if (r11 == null) goto L36;
                List<com.bytedance.android.livesdk.interactivity.comment.model.c> r13 = r11.a();
                if (r13 == null) goto L36;
                if ((!r13.isEmpty()) == true) goto L10;
                r13 = null;
            L10:
                if (r13 == null) goto L36;
                ArrayList r2 = new ArrayList();
                Iterator<T> r14 = r13.iterator();
            L13:
                if (r14.hasNext() == false) goto L27;
                T r3 = r14.next();
                com.bytedance.android.livesdk.interactivity.comment.model.c r4 = (com.bytedance.android.livesdk.interactivity.comment.model.c) r3;
                String r5 = r4.a();
                if (r5 != null) goto L17;
            L24:
                boolean r6 = false;
            L25:
                if (r6 == false) goto L13;
                r2.add(r3);
                goto L13
            L17:
                if (r5.length() <= 0) goto L19;
                boolean r7 = true;
            L20:
                if (r7 != true) goto L24;
                if (r4.b() <= 0) goto L24;
                r6 = true;
                goto L25
            L19:
                r7 = false;
                goto L20
            L27:
                ArrayList r15 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r2, 10));
                Iterator r1 = r2.iterator();
            L29:
                if (r1.hasNext() == false) goto L31;
                r15.add(new a((com.bytedance.android.livesdk.interactivity.comment.model.c) r1.next()));
                goto L29
            L31:
                MultiTypeAdapter r8 = this.a.l;
                int r9 = r15.size();
                List r16 = r15;
                if (r9 < 6) goto L35;
                r16 = r15.subList(0, 6);
            L35:
                r8.a = r16;
                this.a.l.notifyDataSetChanged();
                TruthPanelController.g(this.a, false);
            L37:
                this.a.i = false;
                return;
            L36:
                TruthPanelController.g(this.a, true);
                goto L37
            }
        }

        public static final class c<T> implements Consumer {
            public final /* synthetic */ TruthPanelController a;

            public c(TruthPanelController r1) {
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
                TruthPanelController.g(this.a, true);
                this.a.i = false;
            }
        }

        public final void h() {
            if (this.i == false) goto L5;
            return;
        L5:
            com.bytedance.android.livesdk.interactivity.comment.newinput.c r0 = this.b.V();
            Disposable r1 = null;
            if (r0 == null) goto L10;
            com.bytedance.android.livesdk.interactivity.comment.newinput.a r2 = r0.g;
            if (r2 == null) goto L10;
            r2.z = null;
        L10:
            this.h = null;
            ((ArrayList) this.m).clear();
            Disposable r3 = this.j;
            if (r3 == null) goto L13;
            r3.dispose();
        L13:
            this.i = true;
            TruthQuestionApi.a.getClass();
            TruthQuestionApi r4 = (TruthQuestionApi) com.bytedance.android.live.network.c.b().e(TruthQuestionApi.class);
            if (r4 == null) goto L26;
            com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r5 = this.n.b;
            if (r5 == null) goto L18;
            long r6 = r5.Z();
        L19:
            Observable<Response<com.bytedance.android.livesdk.interactivity.comment.model.d>> r7 = r4.getTruthQuestionList(r6);
            if (r7 == null) goto L26;
            Observable r8 = r7.subscribeOn(Schedulers.io());
            if (r8 == null) goto L26;
            Observable r9 = r8.observeOn(AndroidSchedulers.mainThread());
            if (r9 == null) goto L26;
            r1 = r9.subscribe(new b(this), new c(this));
            goto L26
        L18:
            r6 = 0;
        L26:
            this.j = r1;
        }

        public static final void g(TruthPanelController r0, boolean r1) {
            if (r1 == false) goto L4;
            UtilityKotlinExtentionsKt.t(r0.c);
            UtilityKotlinExtentionsKt.w(r0.f);
            return;
        L4:
            UtilityKotlinExtentionsKt.w(r0.c);
            UtilityKotlinExtentionsKt.t(r0.f);
        }

        public TruthPanelController(TruthSectionProvider r2, View r3, com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r4) {
            Intrinsics.checkNotNullParameter(r3, "view");
            Intrinsics.checkNotNullParameter(r4, "panelBridges");
            this.n = r2;
            super(r3, r4);
            this.c = (LinearLayout) r3.findViewById(2131367794);
            this.d = r3.findViewById(2131389410);
            this.e = (TextView) r3.findViewById(2131384137);
            TextView r5 = (TextView) r3.findViewById(2131388741);
            this.f = (LinearLayout) r3.findViewById(2131371756);
            this.g = (TextView) r3.findViewById(2131371750);
            this.k = new LinearLayoutManager(r3.getContext());
            this.l = new MultiTypeAdapter();
            this.m = new ArrayList();
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
        TruthPanelController r0 = this.c;
        if (r0 == null) goto L13;
        Disposable r1 = r0.j;
        if (r1 == null) goto L7;
        r1.dispose();
    L7:
        r0.j = null;
        r0.h = null;
        ((ArrayList) r0.m).clear();
        com.bytedance.android.livesdk.interactivity.comment.newinput.c r2 = r0.b.V();
        if (r2 == null) goto L14;
        com.bytedance.android.livesdk.interactivity.comment.newinput.a r3 = r2.g;
        if (r3 == null) goto L15;
        r3.z = null;
        return;
    L15:
        return;
    L14:
        return;
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.k
    public final void e() {
        View r0 = this.d;
        if (r0 == null) goto L14;
        com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r2 = this.b;
        if (r2 != null) goto L7;
    L9:
        com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r3 = this.b;
        if (r3 == null) goto L12;
        int r4 = r3.W();
    L13:
        com.bytedance.android.live.core.utils.a1.k(r0, r4);
        goto L14
    L12:
        r4 = 0;
        goto L13
    L7:
        if (r2.W() != 0) goto L9;
        int r5 = InputPanelSectionContainer.m;
        r4 = InputPanelSectionContainer.m;
    L14:
        com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r1 = this.b;
        if (r1 == null) goto L19;
        EditText r6 = r1.a;
        if (r6 == null) goto L19;
        r6.setText(BuildConfig.FLAVOR);
    L19:
        TruthPanelController r7 = this.c;
        if (r7 == null) goto L30;
        TruthPanelController.a r8 = r7.h;
        if (r8 == null) goto L24;
        r8.b = false;
    L24:
        r7.h = null;
        r7.l.notifyDataSetChanged();
        ((ArrayList) r7.m).clear();
        com.bytedance.android.livesdk.interactivity.comment.newinput.c r9 = r7.b.V();
        if (r9 == null) goto L31;
        com.bytedance.android.livesdk.interactivity.comment.newinput.a r10 = r9.g;
        if (r10 == null) goto L32;
        r10.z = null;
        return;
    L32:
        return;
    L31:
        return;
    }

    public TruthSectionProvider() {
        this.a = InputSectionType.TRUTH;
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
        View r1 = LayoutInflater.from(r0).inflate(2131566090, null);
        this.d = r1;
        final TruthPanelController r2 = new TruthPanelController(this, r1, r6);
        r2.d.setLayoutManager(r2.k);
        r2.l.z2(TruthPanelController.a.class, new TruthPanelController.TruthQuestionViewBinder(r2, new TruthSectionProvider$TruthPanelController$init$1(r2)));
        r2.d.setAdapter(r2.l);
        r2.e.setOnClickListener(new q1(r2));
        r2.g.setOnClickListener(new r1(r2));
        r2.h();
        Unit r7 = Unit.INSTANCE;
        this.c = r2;
        return r1;
    }
}
