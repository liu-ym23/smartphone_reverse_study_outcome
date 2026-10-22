package com.ss.android.lark.feed.shared.page.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.lark.pb.feed.v1.AppFeedCardType;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.h6ah4i.android.widget.advrecyclerview.utils.AbstractSwipeableItemViewHolder;
import com.larksuite.framework.utils.CollectionUtils;
import com.larksuite.framework.utils.DevEnvUtil;
import com.ss.android.lark.base.adapter.LarkRecyclerViewBaseAdapter;
import com.ss.android.lark.biz.im.api.FeedCard;
import com.ss.android.lark.feed.app.entity.FeedFolderCompat;
import com.ss.android.lark.feed.app.entity.UIFeedCard;
import com.ss.android.lark.feed.export.feedcard.action.FeedActionType;
import com.ss.android.lark.feed.shared.data.ICache$Operation;
import com.ss.android.lark.feed.shared.data.UpdateRecord;
import com.ss.android.lark.feed.shared.page.adapter.exception.FeedCardFactoryNotFoundException;
import com.ss.android.lark.feed.shared.page.binder2.BaseFeedSwipeableViewHolder;
import com.ss.android.lark.feed.shared.page.binder2.FeedCommonViewHolder;
import com.ss.android.lark.feed.shared.page.binder2.n;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.y0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class FeedListAdapter extends LarkRecyclerViewBaseAdapter<RecyclerView.ViewHolder, UIFeedCard> implements ueb.a {
    public RecyclerView a;
    public final veb.a b;
    public final teb.f c;
    public f d;
    public zeb.a e;
    public zeb.b f;
    public h g;
    public e h;
    public final yeb.a i;
    public final reb.a<com.ss.android.lark.feed.export.feedcard.e> j;
    public seb.b k;
    public c l;
    public g m;
    public UpdateRecord n;
    public boolean o;
    public final com.ss.android.lark.feed.shared.page.a p;

    public class a implements veb.a.b {
        public final /* synthetic */ FeedListAdapter a;

        public a(FeedListAdapter r1) {
            this.a = r1;
        }

        @Override // veb.a.b
        public final void a(DiffUtil.DiffResult r3, UpdateRecord r4) {
            c r0 = this.a.l;
            if (r0 == null) goto L5;
            r0.a(r4);
        L5:
            FeedListAdapter.y2(this.a, r4.b);
            r3.dispatchUpdatesTo(this.a);
            c r5 = this.a.l;
            if (r5 == null) goto L9;
            r5.b(r4);
            return;
        }
    }

    public static /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[ICache$Operation.Type.values().length];
            a = r0;
            r0[ICache$Operation.Type.UNKNOWN.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L14:
            a[ICache$Operation.Type.ADD.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L18:
            a[ICache$Operation.Type.REMOVE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L22:
            a[ICache$Operation.Type.MOVE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L16:
            a[ICache$Operation.Type.UPDATE.ordinal()] = 5;     // Catch: NoSuchFieldError -> L13
            return;
        }
    }

    public interface c {
        void a(UpdateRecord r1);

        void b(UpdateRecord r1);
    }

    public final class d implements com.ss.android.lark.feed.export.feedcard.g {
        public final /* synthetic */ FeedListAdapter a;

        public d(FeedListAdapter r1) {
            this.a = r1;
        }

        public final void a(String r5, Function1<? super UIFeedCard, Boolean> r6) {
            List r0 = FeedListAdapter.z2(this.a);
            if (CollectionUtils.isEmpty(r0) == true) goto L11;
            int r1 = 0;
        L6:
            if (r1 >= r0.size()) goto L11;
            UIFeedCard r2 = (UIFeedCard) ListProtector.get(r0, r1);
            if (y0.a(r2.getId(), r5) == true) goto L13;
            r1 = r1 + 1;
        L13:
            if (((Boolean) r6.invoke(r2)).booleanValue() == false) goto L21;
            if (r1 >= 0) goto L16;
            return;
        L16:
            if (r1 >= r0.size()) goto L23;
            this.a.notifyItemChanged(r1);
            return;
        L23:
            return;
        L21:
            return;
        L11:
            r2 = null;
            r1 = -1;
            goto L13
        }
    }

    public interface e {
        void a();
    }

    public interface f {
        void a();
    }

    public interface g {
        void a(int r1, UIFeedCard r2);
    }

    public interface h {
    }

    public final void B2() {
        boolean r0 = false;
        this.o = false;
        StringBuilder r1 = new StringBuilder("resume update,  has_pending_record = ");
        if (this.n == null) goto L5;
        r0 = true;
    L5:
        r1.append(r0);
        Log.i("FeedListAdapter", r1.toString());
        UpdateRecord r2 = this.n;
        if (r2 == null) goto L9;
        update(r2);
        this.n = null;
        return;
    }

    public final boolean onFailedToRecycleView(RecyclerView.ViewHolder r1) {
        return true;
    }

    @Override // ueb.a
    public final boolean y() {
        return true;
    }

    @Override // ueb.a
    public final List<FeedActionType> D1() {
        ArrayList r0 = new ArrayList();
        heb.a.a.getFeedDependency().getClass();
        FeedFolderCompat r1 = FeedFolderCompat.INSTANCE;
        if (r1.getMESSAGE_WITHOUT_DOUBAO().isSameFolderWith(r1.getDONE()) == false) goto L5;
        r0.add(FeedActionType.DONE);
    L5:
        return r0;
    }

    @Override // ueb.a
    public final List<FeedActionType> w0() {
        return new ArrayList();
    }

    @Override // ueb.a
    public final f c1() {
        return this.d;
    }

    @Override // ueb.a
    public final zeb.b f2() {
        return this.f;
    }

    @Override // ueb.a
    public final zeb.a z() {
        return this.e;
    }

    public static teb.a A2(ViewGroup r3) {
        View r0 = new View(r3.getContext());
        r0.setLayoutParams(new RecyclerView.LayoutParams(-1, 0));
        return new teb.a(r0);
    }

    public static /* synthetic */ List z2(FeedListAdapter r0) {
        return ((LarkRecyclerViewBaseAdapter) r0).items;
    }

    @Override // ueb.a
    public final void G1(e r1) {
        this.h = r1;
    }

    public long getItemId(int r6) {
        String r0 = ((UIFeedCard) ListProtector.get(((LarkRecyclerViewBaseAdapter) this).items, r6)).getId();
        long r3 = CastLongProtector.parseLong(((UIFeedCard) ListProtector.get(((LarkRecyclerViewBaseAdapter) this).items, r6)).getId());     // Catch: Throwable -> L5
    L8:
        if (r3 != (-1)) goto L18;
        return UUID.fromString(r0).getMostSignificantBits();
    L11:
        e = move-exception;
        Log.e("FeedListAdapter", "invalid uuid:" + r0, e);
        return r3;
    L18:
        return r3;
    L5:
        th = move-exception;
        Log.e("SafeParseUtils", th.getMessage());
        r3 = -1;
        goto L8
    }

    public int getItemViewType(int r6) {
        UIFeedCard r7 = (UIFeedCard) getItem(r6);
        if (r7 != null) goto L7;
        Log.e("FeedListAdapter", "get item view type, getItem is empty");
        return -1;
    L7:
        if (this.j.a(r7.getType(), r7.getBizType()) == null) goto L15;
        if (r7.getType() != FeedCard.Type.APP_FEED) goto L13;
        return r7.getBizType().getValue() + 2000;
    L13:
        return r7.getType().getNumber() + 1000;
    L15:
        if (DevEnvUtil.isDebugMode(this.i.getHost().getContext()) == true) goto L19;
        Log.e("FeedListAdapter", "not registered in the feed card factory");
        return -1;
    L19:
        throw new FeedCardFactoryNotFoundException(r7.getClass());
    }

    public void onAttachedToRecyclerView(RecyclerView r1) {
        super/*androidx.recyclerview.widget.RecyclerView.Adapter*/.onAttachedToRecyclerView(r1);
        r1.getContext();
        this.a = r1;
    }

    public final void onViewRecycled(RecyclerView.ViewHolder r2) {
        super/*androidx.recyclerview.widget.RecyclerView.Adapter*/.onViewRecycled(r2);
        if ((r2 instanceof BaseFeedSwipeableViewHolder) == false) goto L6;
        ((BaseFeedSwipeableViewHolder) r2).onViewRecycled();
        return;
    }

    public void update(UpdateRecord r4) {
        if (this.o == false) goto L7;
        Log.w("FeedListAdapter", "update isPauseUpdate");
        this.n = r4;
        return;
    L7:
        if (CollectionUtils.isEmpty(r4.f) == true) goto L13;
        ((LarkRecyclerViewBaseAdapter) this).items = r4.b;
        Iterator<ICache$Operation> r5 = r4.f.iterator();
        if (r5.hasNext() == true) goto L11;
        return;
    L11:
        ICache$Operation r6 = r5.next();
        int[] r0 = b.a;
        r6.getClass();
        throw null;
    L13:
        veb.a r1 = this.b;
        if (r1.d != null) goto L16;
        r1.b = false;
        r1.c = null;
        ArrayList r2 = new ArrayList();
        r2.addAll(r1.e.getItems());
        veb.a.RunnableC0313a r3 = new veb.a.RunnableC0313a(r1, r2, r4);
        r1.d = r3;
        r1.f.execute(r3);
        return;
    L16:
        Log.i("FeedSharedModule_DiffHelper", "[FeedItems] start diff, has pendingRunnable, pending update, items size=" + ((ArrayList) r4.b).size());
        r1.c = r4;
    }

    public static /* synthetic */ void y2(FeedListAdapter r0, List r1) {
        ((LarkRecyclerViewBaseAdapter) r0).items = r1;
    }

    public void C2(int r2, int r3) {
        if (r2 > (-1)) goto L5;
        return;
    L5:
        if (r2 >= getItemCount()) goto L9;
        this.a.getLayoutManager().scrollToPositionWithOffset(r2, r3);
        return;
    }

    public void onBindViewHolder(RecyclerView.ViewHolder r11, int r12) {
        UIFeedCard r0 = (UIFeedCard) getItem(r12);
        if (r0 != null) goto L6;
        Log.e("FeedListAdapter", "bind view holder, get item is empty");
        return;
    L6:
        r0.setDataObserver(this.c);
        g r2 = this.m;
        if (r2 == null) goto L10;
        r2.a(r12, r0);
    L10:
        if ((r11 instanceof FeedCommonViewHolder) == false) goto L41;
        FeedCommonViewHolder r13 = (FeedCommonViewHolder) r11;
        com.ss.android.lark.feed.export.feedcard.e r14 = this.j.a(r13.A, r13.B);
        boolean r3 = false;
        if (r13.y == null) goto L32;
        if (r14 == null) goto L32;
        r13.z = r14.c(this.i);
        com.ss.android.lark.feed.shared.page.a r15 = this.p;
        yeb.a r1 = this.i;
        Intrinsics.checkNotNullParameter(r0, "uiFeedCard");
        Intrinsics.checkNotNullParameter(r15, "paramsFactory");
        Intrinsics.checkNotNullParameter(this, "itemContainer");
        Intrinsics.checkNotNullParameter(r1, "feedCardContext");
        r13.H = r0;
        Job r7 = r13.C;
        if (r7 == null) goto L17;
        Job.DefaultImpls.cancel$default(r7, null, 1, null);
    L17:
        r13.s.setSelected(false);
        com.ss.android.lark.feed.export.feedcard.h r8 = r13.y;
        if (r8 == null) goto L20;
        r8.b(((RecyclerView.ViewHolder) r13).itemView, r0, r15, r1);
    L20:
        r13.V3(r0, this);
        seb.b r16 = this.k;
        yeb.a r9 = this.i;
        Intrinsics.checkNotNullParameter(r0, "uiFeedCard");
        Intrinsics.checkNotNullParameter(this, "itemContainer");
        Intrinsics.checkNotNullParameter(r9, "feedCardContext");
        com.ss.android.lark.feed.shared.page.binder2.e r6 = new com.ss.android.lark.feed.shared.page.binder2.e(r13, r16);
        r13.H = r0;
        r13.I = r16;
        r13.J = this;
        r13.K = r6;
        r13.k = r0.isSwipedLeftPinned();
        boolean r4 = r0.isSwipeRightPinned();
        r13.l = r4;
        r13.w = false;
        if (r13.k == true) goto L29;
        if (r4 == true) goto L29;
        if (((AbstractSwipeableItemViewHolder) r13).e != 0.0f) goto L26;
        r3 = true;
    L26:
        if (r3 == true) goto L29;
        ((AbstractSwipeableItemViewHolder) r13).e = 0.0f;
    L29:
        if ((!((ArrayList) r13.u).isEmpty()) == false) goto L31;
        ((ArrayList) r13.u).clear();
        r13.X3();
    L31:
        r13.s.setOnLongClickListener(new com.ss.android.lark.feed.shared.page.binder2.f(r13, r0, r16, this, r6));
        r13.s.setOnClickListener(new com.ss.android.lark.feed.shared.page.binder2.d(r9, r0, r13));
        return;
    L32:
        StringBuilder r5 = new StringBuilder("FeedCommonViewHolder bindView error occurs! openFeedCell is null?");
        if (r13.y != null) goto L35;
        boolean r17 = true;
    L36:
        r5.append(r17);
        r5.append(", factory is null?");
        if (r14 != null) goto L39;
        r3 = true;
    L39:
        r5.append(r3);
        r5.append(", feedId:");
        r5.append(r0.getId());
        Log.e("FeedListAdapter", r5.toString());
        return;
    L35:
        r17 = false;
        goto L36
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r6, int r7) {
        if (r7 < 1000) goto L28;
        AppFeedCardType r2 = AppFeedCardType.UNKNOWN_APP_FEED_CARD_TYPE;
        if (r7 < 2000) goto L7;
        r2 = AppFeedCardType.fromValue(r7 - 2000);
        FeedCard.Type r8 = FeedCard.Type.APP_FEED;
    L8:
        View r1 = LayoutInflater.from(r6.getContext()).inflate(2131561592, r6, false);
        if (r8 != null) goto L12;
        Log.e("FeedListAdapter", "onCreateViewHolder feedType is null, inflate empty view holder!");
        return A2(r6);
    L12:
        com.ss.android.lark.feed.export.feedcard.e r3 = this.j.a(r8, r2);
        if (r3 != null) goto L16;
        Log.e("FeedListAdapter", "onCreateViewHolder factory is empty, inflate empty view holder!");
        return A2(r6);
    L16:
        com.ss.android.lark.feed.export.feedcard.h r9 = r3.b(r1);
        FeedCommonViewHolder r0 = new FeedCommonViewHolder(r1, this.i);
        r0.y = r9;
        if (r9 == null) goto L26;
        View r4 = ((RecyclerView.ViewHolder) r0).itemView;
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type android.view.ViewGroup");
        com.ss.android.lark.feed.export.feedcard.a r10 = r9.a((ViewGroup) r4);
        View r5 = r10.a;
        if (r5 == null) goto L22;
        r0.s.addView(r5);
        goto L26
    L22:
        n r11 = FeedCommonViewHolder.M;
        if (r11 == null) goto L25;
        r11.b(r0.n, r0.s, r10);
        goto L26
    L25:
        Log.e("FeedSharedModule_FeedCommonViewHolder", "layoutStrategy is empty");
    L26:
        Intrinsics.checkNotNullParameter(r8, "<set-?>");
        r0.A = r8;
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        r0.B = r2;
        return r0;
    L7:
        r8 = FeedCard.Type.forNumber(r7 - 1000);
        goto L8
    L28:
        Log.e("FeedListAdapter", "bind error, inflate empty view holder!");
        return A2(r6);
    }

    public FeedListAdapter(reb.a<com.ss.android.lark.feed.export.feedcard.e> r3, com.ss.android.lark.feed.export.feedcard.d r4, bw7.b r5) {
        a r0 = new a(this);
        this.p = new com.ss.android.lark.feed.shared.page.a();
        veb.a r1 = new veb.a(this);
        this.b = r1;
        r1.a = r0;
        this.c = new teb.f(this);
        this.j = r3;
        this.i = new yeb.a(r4, new d(this), r5);
    }
}
