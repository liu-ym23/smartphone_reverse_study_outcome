package com.bytedance.android.live.search.impl.search;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.base.model.user.IUser;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.ui.BaseFragment;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.android.live.search.impl.search.adapter.LiveSearchUserAdapter;
import com.bytedance.android.live.search.impl.search.adapter.LiveSearchUserViewHolder;
import com.bytedance.android.live.search.impl.search.viewmodel.LiveSearchUserViewModel;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livesdk.chatroom.ui.DouyinLoadingLayout;
import com.bytedance.android.livesdk.viewmodel.ListViewModel;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0005B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/live/search/impl/search/LiveSearchUserFragment;", "Lcom/bytedance/android/live/core/ui/BaseFragment;", "", "<init>", "()V", "a", "livesearchimpl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveSearchUserFragment extends BaseFragment {
    public static final /* synthetic */ int z = 0;
    public final String d;
    public final CompositeDisposable e;
    public final boolean f;
    public final List<User> g;
    public final List<String> h;
    public final List<User> i;
    public final List<User> j;
    public LiveSearchUserViewModel k;
    public RecyclerView l;
    public DouyinLoadingLayout m;
    public View n;
    public ImageView o;
    public TextView p;
    public TextView q;
    public LiveSearchUserAdapter r;
    public pa1.e s;
    public boolean t;
    public boolean u;
    public final Map<String, pa1.b> v;
    public final String w;
    public final d x;
    public final b y;

    public static final class a {
    }

    public static final class b implements com.bytedance.android.livesdk.viewmodel.e<User> {
        public final /* synthetic */ LiveSearchUserFragment a;

        public final void onError(Throwable r1) {
        }

        public final void onLoading() {
        }

        public b(LiveSearchUserFragment r1) {
            this.a = r1;
        }

        public final void onSuccess(List<User> r6, boolean r7) {
            if (r6 == null) goto L24;
            ArrayList r0 = new ArrayList();
            Iterator<T> r8 = r6.iterator();
        L5:
            if (r8.hasNext() == false) goto L12;
            Object r1 = r8.next();
            User r2 = (User) r1;
            boolean r4 = true;
            if (this.a.u == true) goto L10;
            r4 = true ^ Intrinsics.areEqual(r2.getIdString(), this.a.w);
        L10:
            if (r4 == false) goto L5;
            r0.add(r1);
            goto L5
        L12:
            List<User> r9 = CollectionsKt.toMutableList(r0);
            if (r9 == null) goto L25;
            LiveSearchUserAdapter r3 = this.a.r;
            if (r3 == null) goto L17;
            Intrinsics.checkNotNullParameter(r9, "list");
            int r5 = r3.a.size();
            r3.a = r9;
            r3.notifyItemRangeInserted(r5 - 1, r3.getItemCount() - r5);
            r3.notifyItemChanged(r3.getItemCount() - 1);
        L17:
            LiveSearchUserFragment r10 = this.a;
            r10.t = r7;
            ALogger.d(r10.d, "refreshListener set user list to data size:" + r9.size());
            return;
        L25:
            return;
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ LiveSearchUserViewModel a;

        public c(LiveSearchUserViewModel r1) {
            this.a = r1;
        }

        public final void accept(Object r1) {
            String r2 = (String) r1;
            this.a.searchUser();
        }
    }

    public static final class d implements com.bytedance.android.livesdk.viewmodel.e<User> {
        public final /* synthetic */ LiveSearchUserFragment a;

        public final void onLoading() {
            LiveSearchUserFragment r0 = this.a;
            View r1 = r0.n;
            if (r1 == null) goto L5;
            UtilityKotlinExtentionsKt.u(r1);
        L5:
            DouyinLoadingLayout r2 = r0.m;
            if (r2 == null) goto L9;
            UtilityKotlinExtentionsKt.w(r2);
            r2.b();
            return;
        }

        public d(LiveSearchUserFragment r1) {
            this.a = r1;
        }

        public final void onError(Throwable r4) {
            String r0 = this.a.d;
            StringBuilder r1 = new StringBuilder("refreshListener erroe,keyword:");
            LiveSearchUserViewModel r2 = this.a.k;
            if (r2 == null) goto L7;
            com.bytedance.live.datacontext.m<String> r3 = r2.getCurrentKeyword();
            if (r3 == null) goto L7;
            String r5 = (String) r3.getValue();
        L8:
            r1.append(r5);
            r1.append(",e:");
            r1.append(r4);
            ALogger.e(r0, r1.toString());
            LiveSearchUserFragment r6 = this.a;
            DouyinLoadingLayout r7 = r6.m;
            if (r7 == null) goto L11;
            r7.c();
        L11:
            DouyinLoadingLayout r8 = r6.m;
            if (r8 == null) goto L14;
            UtilityKotlinExtentionsKt.u(r8);
        L14:
            ImageView r9 = r6.o;
            if (r9 == null) goto L17;
            r9.setImageResource(2131249437);
        L17:
            View r10 = r6.n;
            if (r10 == null) goto L20;
            UtilityKotlinExtentionsKt.w(r10);
        L20:
            TextView r12 = r6.p;
            if (r12 == null) goto L23;
            r12.setText(s1.B(2131922369));
        L23:
            TextView r13 = r6.q;
            if (r13 == null) goto L27;
            r13.setText(s1.B(2131922370));
            return;
        L27:
            return;
        L7:
            r5 = null;
            goto L8
        }

        public final void onSuccess(List<User> r6, boolean r7) {
            LiveSearchUserFragment r0 = this.a;
            DouyinLoadingLayout r1 = r0.m;
            if (r1 == null) goto L5;
            r1.c();
        L5:
            DouyinLoadingLayout r2 = r0.m;
            if (r2 == null) goto L8;
            UtilityKotlinExtentionsKt.u(r2);
        L8:
            View r3 = r0.n;
            if (r3 == null) goto L11;
            UtilityKotlinExtentionsKt.u(r3);
        L11:
            if (r6 == null) goto L58;
            ArrayList r4 = new ArrayList();
            Iterator<T> r8 = r6.iterator();
        L14:
            if (r8.hasNext() == false) goto L21;
            Object r5 = r8.next();
            User r9 = (User) r5;
            boolean r10 = true;
            if (this.a.u == true) goto L19;
            r10 = true ^ Intrinsics.areEqual(r9.getIdString(), this.a.w);
        L19:
            if (r10 == false) goto L14;
            r4.add(r5);
            goto L14
        L21:
            List<User> r12 = CollectionsKt.toMutableList(r4);
            if (r12 == null) goto L59;
            LiveSearchUserAdapter r13 = this.a.r;
            if (r13 == null) goto L26;
            Intrinsics.checkNotNullParameter(r12, "list");
            r13.a = r12;
            r13.notifyDataSetChanged();
        L26:
            LiveSearchUserFragment r14 = this.a;
            r14.t = r7;
            String r15 = r14.d;
            StringBuilder r16 = new StringBuilder("refreshListener set user list to data size:");
            r16.append(r12.size());
            r16.append(",hasMore = ");
            r16.append(r7);
            r16.append(",keyword:");
            LiveSearchUserViewModel r17 = this.a.k;
            if (r17 == null) goto L31;
            com.bytedance.live.datacontext.m<String> r18 = r17.getCurrentKeyword();
            if (r18 == null) goto L31;
            String r19 = (String) r18.getValue();
        L32:
            r16.append(r19);
            ALogger.d(r15, r16.toString());
            if (r12.isEmpty() == false) goto L60;
            LiveSearchUserFragment r20 = this.a;
            DouyinLoadingLayout r22 = r20.m;
            if (r22 == null) goto L37;
            r22.c();
        L37:
            DouyinLoadingLayout r23 = r20.m;
            if (r23 == null) goto L40;
            UtilityKotlinExtentionsKt.u(r23);
        L40:
            View r24 = r20.n;
            if (r24 == null) goto L43;
            UtilityKotlinExtentionsKt.w(r24);
        L43:
            ImageView r25 = r20.o;
            if (r25 == null) goto L46;
            r25.setImageResource(2131250536);
        L46:
            TextView r26 = r20.p;
            if (r26 == null) goto L49;
            r26.setText(s1.B(2131922366));
        L49:
            TextView r27 = r20.q;
            if (r27 == null) goto L61;
            r27.setText(s1.B(2131922367));
            return;
        L61:
            return;
        L60:
            return;
        L31:
            r19 = null;
            goto L32
        L59:
            return;
        }
    }

    static {
    }

    public LiveSearchUserFragment() {
        this.d = "LiveSearchUserFragment[" + hashCode() + ']';
        this.e = new CompositeDisposable();
        this.f = true;
        this.g = new ArrayList();
        this.h = new ArrayList();
        this.i = new ArrayList();
        this.j = new ArrayList();
        this.s = new pa1.e(0);
        this.t = true;
        this.v = new LinkedHashMap();
        IUserService r0 = jc1.k.f(IUserService.class);
        if (r0 == null) goto L10;
        com.bytedance.android.livesdk.user.f r1 = r0.user();
        if (r1 == null) goto L10;
        IUser r2 = r1.b();
        if (r2 == null) goto L10;
        String r3 = r2.getIdString();
        if (r3 == null) goto L10;
    L11:
        this.w = r3;
        this.x = new d(this);
        this.y = new b(this);
        return;
    L10:
        r3 = DataType.FALSE;
        goto L11
    }

    public final void onDestroy() {
        super.onDestroy();
        ALogger.w(this.d, "start onDestroy");
        ((LinkedHashMap) this.v).clear();
        this.e.dispose();
    }

    public final void onCreate(Bundle r2) {
        super.onCreate(r2);
        this.k = com.bytedance.live.datacontext.d.b(this, null).a(LiveSearchUserViewModel.class);
    }

    public final View onCreateView(LayoutInflater r9, ViewGroup r10, Bundle r12) {
        Intrinsics.checkNotNullParameter(r9, "inflater");
        View r13 = r9.inflate(2131567419, r10, false);
        this.l = r13.findViewById(2131385003);
        this.m = r13.findViewById(2131385630);
        this.n = r13.findViewById(2131385629);
        this.o = (ImageView) r13.findViewById(2131376082);
        this.p = (TextView) r13.findViewById(2131391362);
        this.q = (TextView) r13.findViewById(2131391363);
        LiveSearchUserAdapter r14 = new LiveSearchUserAdapter();
        r14.c = this.u;
        r14.d = this.f;
        Unit r15 = Unit.INSTANCE;
        this.r = r14;
        ((ArrayList) this.i).clear();
        ((ArrayList) this.j).clear();
        final RecyclerView r16 = this.l;
        if (r16 == null) goto L5;
        r16.setLayoutManager(new LinearLayoutManager(r16.getContext(), 1, false));
        r16.setAdapter(this.r);
        r16.addOnScrollListener(new LiveSearchUserFragment$onCreateView$$inlined$apply$lambda$1(r16, this));
    L5:
        LiveSearchUserAdapter r17 = this.r;
        if (r17 == null) goto L8;
        Function3<User, LiveSearchUserViewHolder, Boolean, Unit> r18 = new LiveSearchUserFragment$onCreateView$$inlined$apply$lambda$2(this);
        Intrinsics.checkNotNullParameter(r18, "action");
        r17.b = r18;
        Function1<User, Boolean> r19 = new LiveSearchUserFragment$onCreateView$$inlined$apply$lambda$3(this);
        Intrinsics.checkNotNullParameter(r19, "action");
        r17.f = r19;
    L8:
        LiveSearchUserViewModel r1 = this.k;
        if (r1 == null) goto L11;
        ListViewModel.listSubscribe$default(r1, this, this.x, this.y, null, 8, null);
    L11:
        LiveSearchUserViewModel r110 = this.k;
        if (r110 == null) goto L14;
        r110.getCurrentKeyword().a().startWith(r110.getCurrentKeyword().getValue()).subscribe(new c(r110));
    L14:
        return r13;
    }
}
