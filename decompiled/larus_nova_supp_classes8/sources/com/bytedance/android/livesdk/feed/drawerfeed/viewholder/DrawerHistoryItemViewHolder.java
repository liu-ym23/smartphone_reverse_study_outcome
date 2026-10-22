package com.bytedance.android.livesdk.feed.drawerfeed.viewholder;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.TextView;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.base.model.feed.FeedItem;
import com.bytedance.android.live.base.model.follow.ScheduledLiveItem;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.viewholder.BaseViewHolder;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livehostapi.business.IHostBusiness;
import com.bytedance.android.livehostapi.business.depend.feed.IDrawerFeedAction;
import com.bytedance.android.livehostapi.platform.IHostAction;
import com.bytedance.android.livesdk.config.gp;
import com.bytedance.android.livesdk.feed.c1;
import com.bytedance.android.livesdk.feed.drawerfeed.utils.WrapperLinearLayoutManager;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import me.drakeet.multitype.Items;
import me.drakeet.multitype.MultiTypeAdapter;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003J\b\u0010\u0005\u001a\u00020\u0004H\u0007J\b\u0010\u0006\u001a\u00020\u0004H\u0007¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/livesdk/feed/drawerfeed/viewholder/DrawerHistoryItemViewHolder;", "Lcom/bytedance/android/live/core/viewholder/BaseViewHolder;", "Lcom/bytedance/android/live/base/model/feed/FeedItem;", "Landroidx/lifecycle/LifecycleObserver;", "", "onResume", "onDestroy", "livefeed_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class DrawerHistoryItemViewHolder extends BaseViewHolder<FeedItem> implements LifecycleObserver {
    public static final /* synthetic */ int n = 0;
    public final CompositeDisposable a;
    public final RecyclerView b;
    public final MultiTypeAdapter c;
    public FeedItem d;
    public final Items e;
    public final View f;
    public final TextView g;
    public final TextView h;
    public boolean i;
    public final b j;
    public final View k;
    public final Lifecycle l;
    public final IDrawerFeedAction m;

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.feed.drawerfeed.viewholder.DrawerHistoryItemViewHolder$1, reason: invalid class name */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "p1", "Lcom/bytedance/android/live/base/model/feed/FeedItem;", "invoke"}, k = 3, mv = {1, 4, 3})
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<FeedItem, Unit> {
        public AnonymousClass1(DrawerHistoryItemViewHolder r8) {
            super(1, r8, DrawerHistoryItemViewHolder.class, "onItemDelete", "onItemDelete(Lcom/bytedance/android/live/base/model/feed/FeedItem;)V", 0);
        }

        public final void invoke(FeedItem r10) {
            DrawerHistoryItemViewHolder r0 = (DrawerHistoryItemViewHolder) ((CallableReference) this).receiver;
            int r1 = DrawerHistoryItemViewHolder.n;
            r0.getClass();
            if (r10 == null) goto L53;
            Ref.IntRef r2 = new Ref.IntRef();
            r2.element = -1;
            FeedItem r3 = r0.d;
            int r4 = 0;
            if (r3 == null) goto L21;
            List r5 = r3.getLiveHistoryItems();
            if (r5 == null) goto L21;
            Iterator r6 = r5.iterator();
            int r7 = 0;
        L11:
            if (r6.hasNext() == false) goto L21;
            Object r8 = r6.next();
            int r9 = r7 + 1;
            if (r7 >= 0) goto L15;
            CollectionsKt.throwIndexOverflow();
        L15:
            ScheduledLiveItem r11 = ((FeedItem) r8).scheduledLive;
            if (r11 == null) goto L20;
            if (r11.equals(r10.scheduledLive) != true) goto L20;
            r2.element = r7;
        L20:
            r7 = r9;
        L21:
            int r12 = r2.element;
            if (r12 < 0) goto L34;
            FeedItem r13 = r0.d;
            if (r13 == null) goto L28;
            List r14 = r13.getLiveHistoryItems();
            if (r14 == null) goto L28;
            r4 = r14.size();
        L28:
            if (r12 >= r4) goto L34;
            FeedItem r15 = r0.d;
            if (r15 == null) goto L34;
            List r16 = r15.getLiveHistoryItems();
            if (r16 == null) goto L34;
            FeedItem r17 = (FeedItem) ListProtector.remove(r16, r2.element);
        L34:
            r0.T3(r0.d);
            r0.W3(r0.d);
            if (r10.getHistoryStatus() != FeedItem.HistoryStatus.NORMAL) goto L51;
            RecyclerView r18 = r0.b;
            if (r18 != null) goto L39;
        L45:
            new Handler(Looper.getMainLooper()).post(new s(r0, r2));
            return;
        L39:
            if (r18.isComputingLayout() == true) goto L45;
            RecyclerView r19 = r0.b;
            if (r19 == null) goto L45;
            if (r19.getScrollState() != 0) goto L45;
            r0.c.notifyItemRangeRemoved(r2.element, 1);
            return;
        L51:
            return;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            invoke((FeedItem) r1);
            return Unit.INSTANCE;
        }
    }

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ DrawerHistoryItemViewHolder a;

        public a(DrawerHistoryItemViewHolder r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r5) {
            FeedItem r6 = this.a.d;
            FeedItem.HistoryStatus r0 = null;
            if (r6 == null) goto L5;
            FeedItem.HistoryStatus r7 = r6.getHistoryStatus();
        L7:
            if (r7 != FeedItem.HistoryStatus.NO_LOGIN) goto L9;
            DrawerHistoryItemViewHolder r8 = this.a;
            r8.getClass();
            com.bytedance.android.livesdk.user.f r1 = jc1.k.n(IUserService.class).user();
            Context r2 = ((RecyclerView.ViewHolder) r8).itemView.getContext();
            com.bytedance.android.livesdk.user.l.a r3 = new com.bytedance.android.livesdk.user.l.a();
            r3.c = -1;
            r1.login(r2, new com.bytedance.android.livesdk.user.l(r3)).subscribe(r8.j);
            r8.a.add(jc1.k.n(IUserService.class).user().m().filter(p.a).subscribe(new q(r8), r.a));
            return;
        L9:
            FeedItem r9 = this.a.d;
            if (r9 == null) goto L13;
            r0 = r9.getHistoryStatus();
        L13:
            if (r0 != FeedItem.HistoryStatus.NO_PERiMISSION) goto L17;
            DrawerHistoryItemViewHolder r10 = this.a;
            r10.getClass();
            jc1.k.n(IHostAction.class).handleSchema(((RecyclerView.ViewHolder) r10).itemView.getContext(), "aweme://setting/browsing_history", new Bundle());
            return;
        L17:
            return;
        L5:
            r7 = null;
            goto L7
        }
    }

    public static final class b extends com.bytedance.android.livesdk.user.h<IBaseUser> {
        public final /* synthetic */ DrawerHistoryItemViewHolder a;

        public b(DrawerHistoryItemViewHolder r1) {
            this.a = r1;
        }

        public final void onSubscribe(Disposable r2) {
            Intrinsics.checkNotNullParameter(r2, "d");
            this.a.a.add(r2);
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ DrawerHistoryItemViewHolder a;

        public c(DrawerHistoryItemViewHolder r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            FeedItem r5 = (FeedItem) r4;
            DrawerHistoryItemViewHolder r0 = this.a;
            if (r5 != null) goto L5;
            int r6 = DrawerHistoryItemViewHolder.n;
            r0.getClass();
            return;
        L5:
            FeedItem r1 = r0.d;
            if (r1 == null) goto L8;
            r1.setLiveHistoryItems(r5.getLiveHistoryItems());
            r1.setHistoryStatus(r5.getHistoryStatus());
            r1.setHasMoreHistoryItems(r5.getHasMoreHistoryItems());
        L8:
            r0.T3(r0.d);
            r0.W3(r0.d);
            if (r5.getHistoryStatus() != FeedItem.HistoryStatus.NORMAL) goto L22;
            RecyclerView r7 = r0.b;
            if (r7 != null) goto L13;
        L19:
            new Handler(Looper.getMainLooper()).post(new t(r0));
            return;
        L13:
            if (r7.isComputingLayout() == true) goto L19;
            RecyclerView r8 = r0.b;
            if (r8 == null) goto L19;
            if (r8.getScrollState() != 0) goto L19;
            r0.c.notifyDataSetChanged();
            return;
        }
    }

    public static final class d<T> implements Consumer {
        public static final d a = null;

        static {
            a = new d();
        }

        public d() {
        }

        public final /* bridge */ /* synthetic */ void accept(Object r1) {
            Throwable r2 = (Throwable) r1;
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public final void onDestroy() {
        this.l.removeObserver(this);
        this.a.dispose();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public final void onResume() {
        FeedItem r0 = this.d;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.getHistoryStatus() != FeedItem.HistoryStatus.NO_PERiMISSION) goto L11;
        IHostBusiness r1 = jc1.k.f(IHostBusiness.class);
        if (r1 == null) goto L11;
        boolean r2 = true;
        if (r1.hasLiveHistoryPermission() != true) goto L11;
    L12:
        if (r2 == true) goto L15;
        r0 = null;
    L15:
        if (r0 == null) goto L19;
        V3();
        return;
    L19:
        return;
    L11:
        r2 = false;
        goto L12
    }

    public final void V3() {
        Disposable r0 = c1.a().observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io()).subscribe(new c(this), d.a);
        this.a.add(r0);
    }

    public static void U3(String r3) {
        LinkedHashMap r0 = new LinkedHashMap();
        r0.put("enter_from_merge", "drawer_hot");
        r0.put("enter_method", "live_history_card");
        IUserService r1 = jc1.k.f(IUserService.class);
        if (r1 == null) goto L8;
        com.bytedance.android.livesdk.user.f r2 = r1.user();
        if (r2 == null) goto L8;
        String r4 = r2.n();
        if (r4 == null) goto L8;
    L9:
        r0.put("user_id", r4);
        r0.put("empty_reason", r3);
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_history_empty", r0, new Object[0]);
        return;
    L8:
        r4 = "";
        goto L9
    }

    public final void T3(FeedItem r9) {
        if (r9 != null) goto L5;
        return;
    L5:
        if (r9.getHistoryStatus() == FeedItem.HistoryStatus.NORMAL) goto L7;
        return;
    L7:
        this.e.clear();
        List r0 = r9.getLiveHistoryItems();
        if (r0 == null) goto L15;
        long r2 = r0.size();
        gp r4 = gp.a;
        if (r2 <= r4.getValue().a()) goto L12;
        int r3 = (int) r4.getValue().a();
    L13:
        this.e.addAll(r0.subList(0, r3));
        goto L15
    L12:
        r3 = r0.size();
    L15:
        if (this.e.size() == 0) goto L17;
    L19:
        int r1 = this.e.size();
        List r5 = r9.getLiveHistoryItems();
        if (r5 == null) goto L22;
        int r6 = r5.size();
    L23:
        if (r1 >= r6) goto L25;
        this.i = true;
    L31:
        if (r9.getHasMoreHistoryItems() == false) goto L33;
    L34:
        this.e.add(k0.a);
        return;
    L33:
        if (this.i == true) goto L34;
        return;
    L25:
        int r7 = this.e.size();
        List r8 = r9.getLiveHistoryItems();
        if (r8 == null) goto L31;
        if (r7 != r8.size()) goto L31;
        this.i = false;
        goto L31
    L22:
        r6 = 0;
        goto L23
    L17:
        if (r9.getHasMoreHistoryItems() == true) goto L19;
        r9.setHistoryStatus(FeedItem.HistoryStatus.EMPTY);
        this.i = false;
        goto L31
    }

    public final void W3(FeedItem r7) {
        if (r7 != null) goto L5;
        return;
    L5:
        if (r7.getHistoryStatus() != FeedItem.HistoryStatus.NO_LOGIN) goto L23;
        View r8 = this.f;
        if (r8 == null) goto L9;
        r8.setVisibility(0);
    L9:
        TextView r9 = this.h;
        if (r9 == null) goto L12;
        r9.setVisibility(0);
    L12:
        RecyclerView r10 = this.b;
        if (r10 == null) goto L15;
        r10.setVisibility(8);
    L15:
        TextView r11 = this.g;
        if (r11 == null) goto L18;
        r11.setText(s1.C(2131916588, new Object[]{s1.B(2131916590)}));
    L18:
        TextView r12 = this.h;
        if (r12 == null) goto L21;
        r12.setText(s1.B(2131916584));
    L21:
        U3("no_register");
        return;
    L23:
        if (r7.getHistoryStatus() != FeedItem.HistoryStatus.EMPTY) goto L38;
        View r13 = this.f;
        if (r13 == null) goto L27;
        r13.setVisibility(0);
    L27:
        TextView r14 = this.h;
        if (r14 == null) goto L30;
        r14.setVisibility(8);
    L30:
        RecyclerView r15 = this.b;
        if (r15 == null) goto L33;
        r15.setVisibility(8);
    L33:
        TextView r16 = this.g;
        if (r16 == null) goto L36;
        r16.setText(s1.C(2131916588, new Object[]{s1.B(2131916589)}));
    L36:
        U3("no_record");
        return;
    L38:
        if (r7.getHistoryStatus() != FeedItem.HistoryStatus.NO_PERiMISSION) goto L56;
        View r17 = this.f;
        if (r17 == null) goto L42;
        r17.setVisibility(0);
    L42:
        TextView r18 = this.h;
        if (r18 == null) goto L45;
        r18.setVisibility(0);
    L45:
        RecyclerView r19 = this.b;
        if (r19 == null) goto L48;
        r19.setVisibility(8);
    L48:
        TextView r20 = this.g;
        if (r20 == null) goto L51;
        r20.setText(s1.C(2131916588, new Object[]{s1.B(2131916591)}));
    L51:
        TextView r21 = this.h;
        if (r21 == null) goto L54;
        r21.setText(s1.B(2131916585));
    L54:
        U3("no_authority");
        return;
    L56:
        if (r7.getHistoryStatus() != FeedItem.HistoryStatus.NORMAL) goto L70;
        View r22 = this.f;
        if (r22 == null) goto L60;
        r22.setVisibility(8);
    L60:
        TextView r23 = this.h;
        if (r23 == null) goto L63;
        r23.setVisibility(8);
    L63:
        RecyclerView r24 = this.b;
        if (r24 == null) goto L71;
        r24.setVisibility(0);
        return;
    L71:
        return;
    }

    public final void bind(Object r1, int r2) {
        FeedItem r3 = (FeedItem) r1;
        if (r3 == null) goto L20;
        this.d = r3;
        T3(r3);
        W3(r3);
        if (r3.getHistoryStatus() != FeedItem.HistoryStatus.NORMAL) goto L18;
        RecyclerView r4 = this.b;
        if (r4 != null) goto L10;
    L16:
        new Handler(Looper.getMainLooper()).post(new o(this));
        return;
    L10:
        if (r4.isComputingLayout() == true) goto L16;
        RecyclerView r5 = this.b;
        if (r5 == null) goto L16;
        if (r5.getScrollState() != 0) goto L16;
        this.c.notifyDataSetChanged();
        return;
    L18:
        return;
    }

    public DrawerHistoryItemViewHolder(View r7, Lifecycle r8, IDrawerFeedAction r9) {
        Intrinsics.checkNotNullParameter(r8, "lifecycle");
        super(r7);
        this.k = r7;
        this.l = r8;
        this.m = r9;
        this.a = new CompositeDisposable();
        MultiTypeAdapter r0 = new MultiTypeAdapter();
        this.c = r0;
        Items r1 = new Items();
        this.e = r1;
        TextView r2 = null;
        if (r7 == null) goto L5;
        RecyclerView r3 = (RecyclerView) r7.findViewById(2131374393);
    L6:
        this.b = r3;
        if (r7 == null) goto L9;
        View r4 = r7.findViewById(2131388753);
    L10:
        this.f = r4;
        if (r7 == null) goto L13;
        TextView r5 = (TextView) r7.findViewById(2131390563);
    L14:
        this.g = r5;
        if (r7 == null) goto L17;
        r2 = (TextView) r7.findViewById(2131362061);
    L17:
        this.h = r2;
        r0.z2(FeedItem.class, new l0(new AnonymousClass1(this), r9));
        r0.z2(k0.class, new m0(r9));
        if (r3 == null) goto L20;
        r3.addItemDecoration(new DrawerHistoryItemViewHolder$2$1());
        r3.setLayoutManager(new WrapperLinearLayoutManager(r3.getContext()));
        r0.a = r1;
        r3.setAdapter(r0);
    L20:
        if (r2 == null) goto L22;
        r2.setOnClickListener(new a(this));
    L22:
        r8.addObserver(this);
        this.j = new b(this);
        return;
    L13:
        r5 = null;
        goto L14
    L9:
        r4 = null;
        goto L10
    L5:
        r3 = null;
        goto L6
    }
}
