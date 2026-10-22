package com.ss.android.lark.feed.shared.page.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.h6ah4i.android.widget.advrecyclerview.utils.AbstractSwipeableItemViewHolder;
import com.larksuite.framework.utils.CollectionUtils;
import com.larksuite.framework.utils.ICUUtils;
import com.ss.android.lark.appsetting.api.SettingManager;
import com.ss.android.lark.base.adapter.LarkRecyclerViewBaseAdapter;
import com.ss.android.lark.biz.im.api.FeedCard;
import com.ss.android.lark.feed.app.entity.UIFeedCard;
import com.ss.android.lark.feed.shared.data.UpdateRecord;
import com.ss.android.lark.feed.shared.data.expired_fold.FeedExpiredFoldThresholdConfig;
import com.ss.android.lark.feed.shared.hitpoint.FeedHitPointNew;
import com.ss.android.lark.feed.shared.page.binder2.BaseFeedSwipeableViewHolder;
import com.ss.android.lark.feed.shared.page.binder2.FeedCommonViewHolder;
import com.ss.android.lark.feed.shared.page.binder2.FeedExpiredFoldHintViewHolder;
import com.ss.android.lark.feed.shared.page.binder2.l;
import com.ss.android.lark.feed.shared.page.binder2.m;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.statistics.Statistics;
import com.ss.android.lark.utils.UIHelper;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import teb.g;
import z5c.y3;
import zdc.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class LarkFeedInBoxListAdapter extends FeedListAdapter implements bw7.e<RecyclerView.ViewHolder> {
    public final Object q;
    public c r;
    public UIFeedCard s;
    public boolean t;
    public final boolean u;
    public teb.d v;

    public class a implements veb.a.b {
        public final /* synthetic */ LarkFeedInBoxListAdapter a;

        public a(LarkFeedInBoxListAdapter r1) {
            this.a = r1;
        }

        @Override // veb.a.b
        public final void a(DiffUtil.DiffResult r3, UpdateRecord r4) {
            LarkFeedInBoxListAdapter.E2(this.a, r4.b);
            FeedListAdapter.c r0 = this.a.l;
            if (r0 == null) goto L5;
            r0.a(r4);
        L5:
            r3.dispatchUpdatesTo(this.a);
            FeedListAdapter.c r5 = this.a.l;
            if (r5 == null) goto L9;
            r5.b(r4);
            return;
        }
    }

    public class b extends RecyclerView.OnScrollListener {
        public final /* synthetic */ LarkFeedInBoxListAdapter a;

        public b(LarkFeedInBoxListAdapter r1) {
            this.a = r1;
        }

        public final void onScrollStateChanged(RecyclerView r1, int r2) {
            super.onScrollStateChanged(r1, r2);
            this.a.getClass();
        }
    }

    public interface c {
        void a();

        void b();
    }

    public class d extends cw7.c {
        public LarkFeedInBoxListAdapter b;
        public final int c;
        public final /* synthetic */ LarkFeedInBoxListAdapter d;

        public final void a() {
            this.b = null;
        }

        public final void c() {
        }

        public final void b() {
            UIFeedCard r0 = this.b.G2(this.c);
            UIFeedCard r1 = this.d.s;
            if (r1 == null) goto L5;
            r1.setSwipedLeftPinned(false);
            this.b.notifyItemChanged(this.d.s);
        L5:
            this.d.s = r0;
            r0.setSwipedLeftPinned(true);
            this.b.notifyItemChanged(r0);
            FeedHitPointNew.b(FeedHitPointNew.FeedMainClickParam.FEED_LEFTSLIDE, null, null, neb.e.a(r0));
        }

        public d(LarkFeedInBoxListAdapter r1, LarkFeedInBoxListAdapter r2, int r3) {
            this.d = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    public class e extends cw7.f {
        public final RecyclerView.ViewHolder b;
        public final int c;
        public final /* synthetic */ LarkFeedInBoxListAdapter d;

        public final void b() {
            UIFeedCard r0 = this.d.G2(this.c);
            UIFeedCard r1 = this.d.s;
            if (r1 == null) goto L5;
            r1.setSwipedLeftPinned(false);
        L5:
            this.d.s = r0;
            FeedHitPointNew.b(FeedHitPointNew.FeedMainClickParam.FEED_RIGHTSLIDE, null, null, neb.e.a(r0));
            r0.setSwipeRightPinned(true);
        }

        public final void c() {
            BaseFeedSwipeableViewHolder r0 = this.b;
            if ((r0 instanceof BaseFeedSwipeableViewHolder) == false) goto L6;
            r0.l = true;
            return;
        }

        public e(LarkFeedInBoxListAdapter r1, RecyclerView.ViewHolder r2, int r3) {
            this.d = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    public class f extends cw7.d {
        public LarkFeedInBoxListAdapter b;
        public final int c;

        public final void a() {
            this.b = null;
        }

        public final void c() {
        }

        public final void b() {
            UIFeedCard r0 = this.b.G2(this.c);
            r0.setSwipedLeftPinned(false);
            r0.setSwipeRightPinned(false);
            this.b.notifyItemChanged(r0);
        }

        public f(LarkFeedInBoxListAdapter r1, int r2) {
            this.b = r1;
            this.c = r2;
        }
    }

    public final void F2() {
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.l = null;
        this.m = null;
        veb.a r1 = this.b;
        r1.a = null;
        r1.f.shutdown();
        r1.c = null;
    }

    public final void I2() {
        UIFeedCard r0 = this.s;
        if (r0 == null) goto L6;
        r0.setSwipedLeftPinned(false);
        this.s.setSwipeRightPinned(false);
        notifyItemChanged(this.s);
        return;
    }

    public int getItemCount() {
        return ((LarkRecyclerViewBaseAdapter) this).items.size();
    }

    public static void D2(LarkFeedInBoxListAdapter r3) {
        Object r0 = r3.q;
        monitor-enter(r0);
    L13:
        th = move-exception;
        throw th;
    L5:
        if (CollectionUtils.isEmpty(((LarkRecyclerViewBaseAdapter) r3).items) == false) goto L7;
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L13
        return;
    L7:
        if (((LarkRecyclerViewBaseAdapter) r3).items.get(0) == null) goto L11;
        if (((UIFeedCard) ((LarkRecyclerViewBaseAdapter) r3).items.get(0)).getIsExpiredFoldHint() == false) goto L11;
        ((LarkRecyclerViewBaseAdapter) r3).items.remove(0);     // Catch: Throwable -> L13
        r3.notifyItemRemoved(0);     // Catch: Throwable -> L13
        goto L11
    }

    public UIFeedCard G2(int r2) {
        if (r2 < getItemCount()) goto L7;
        return null;
    L7:
        return (UIFeedCard) ListProtector.get(((LarkRecyclerViewBaseAdapter) this).items, r2);
    }

    public final void H2(String r4) {
        if (r4 != null) goto L4;
        return;
    L4:
        int r0 = 0;
    L6:
        if (r0 >= ((LarkRecyclerViewBaseAdapter) this).items.size()) goto L18;
        UIFeedCard r1 = (UIFeedCard) ListProtector.get(((LarkRecyclerViewBaseAdapter) this).items, r0);
        if (r1 == null) goto L12;
        if (r1.getId().equals(r4) == false) goto L12;
        notifyItemChanged(r1);
        return;
    L12:
        r0 = r0 + 1;
        goto L6
    }

    public /* bridge */ /* synthetic */ Object getItem(int r1) {
        return G2(r1);
    }

    @Override // com.ss.android.lark.feed.shared.page.adapter.FeedListAdapter
    public long getItemId(int r6) {
        UIFeedCard r7 = G2(r6);
        if (r7 != null) goto L5;
    L16:
        return -1;
    L5:
        if (r7.getIsExpiredFoldHint() == true) goto L16;
        long r2 = CastLongProtector.parseLong(r7.getId());     // Catch: Throwable -> L10
    L13:
        if (r2 == (-1)) goto L15;
        return r2;
    L15:
        return r7.getId().hashCode();
    L10:
        th = move-exception;
        Log.e("SafeParseUtils", th.getMessage());
        r2 = -1;
        goto L13
    }

    @Override // com.ss.android.lark.feed.shared.page.adapter.FeedListAdapter
    public int getItemViewType(int r2) {
        UIFeedCard r0 = G2(r2);
        if (r0 == null) goto L9;
        if (r0.getIsExpiredFoldHint() == false) goto L9;
        return Integer.MAX_VALUE;
    L9:
        return super.getItemViewType(r2);
    }

    @Override // com.ss.android.lark.feed.shared.page.adapter.FeedListAdapter
    public void onAttachedToRecyclerView(RecyclerView r2) {
        super.onAttachedToRecyclerView(r2);
        this.a.addOnScrollListener(new b(this));
    }

    @Override // com.ss.android.lark.feed.shared.page.adapter.FeedListAdapter
    public void update(UpdateRecord r2) {
        super.update(r2);
        teb.d r3 = this.v;
        if (r3 == null) goto L6;
        r3.b.postOnAnimation(r3.f);
        return;
    }

    public static /* synthetic */ void E2(LarkFeedInBoxListAdapter r0, List r1) {
        ((LarkRecyclerViewBaseAdapter) r0).items = r1;
    }

    @Override // com.ss.android.lark.feed.shared.page.adapter.FeedListAdapter
    public final void C2(int r2, int r3) {
        this.a.getLayoutManager().scrollToPositionWithOffset(r2, r3);
    }

    public final void H(RecyclerView.ViewHolder r1, int r2) {
        this.t = true;
    }

    @Override // com.ss.android.lark.feed.shared.page.adapter.FeedListAdapter
    public void onBindViewHolder(RecyclerView.ViewHolder r6, int r7) {
        if (getItemViewType(r7) == Integer.MAX_VALUE) goto L5;
        super.onBindViewHolder(r6, r7);
        return;
    L5:
        if ((r6 instanceof FeedExpiredFoldHintViewHolder) == false) goto L27;
        FeedExpiredFoldHintViewHolder r8 = (FeedExpiredFoldHintViewHolder) r6;
        r8.b.setVisibility(0);
        int r9 = com.ss.android.lark.feed.shared.hitpoint.a.a;
        s5c.a r10 = y3.p;
        r10.getClass();
        Statistics.sendEvent("feed_msg_guidance_view", s5c.d.b.c(r10));
        TextView r11 = r8.e;
        keb.a.a.getClass();
        peb.b r0 = heb.a.a;
        Locale r1 = r0.getSettingDependency().getCacheLanguageSetting();
        Intrinsics.checkNotNull(r1);
        Map<String, keb.b> r2 = ((FeedExpiredFoldThresholdConfig) SettingManager.getInstance().get(FeedExpiredFoldThresholdConfig.class)).b();
        keb.b r3 = null;
        if (r2 == null) goto L9;
        keb.b r4 = r2.get("Lark_IM_FilterClutter_Onboard_Title");
    L10:
        String r5 = keb.a.a(r1, r4);
        if (r5 != null) goto L13;
        r5 = UIHelper.getString(2131891122);
    L13:
        r11.setText(r5);
        TextView r12 = r8.f;
        Locale r13 = r0.getSettingDependency().getCacheLanguageSetting();
        Intrinsics.checkNotNull(r13);
        Map<String, keb.b> r14 = ((FeedExpiredFoldThresholdConfig) SettingManager.getInstance().get(FeedExpiredFoldThresholdConfig.class)).b();
        if (r14 == null) goto L16;
        r3 = r14.get("Lark_IM_FilterClutter_Onboard_Desc");
    L16:
        String r15 = keb.a.a(r13, r3);
        if (r15 != null) goto L23;
        String r16 = UIHelper.getString(2131891121);
        ICUUtils.FormatArgsBuilder r17 = new ICUUtils.FormatArgsBuilder();
        Integer r18 = ((FeedExpiredFoldThresholdConfig) SettingManager.getInstance().get(FeedExpiredFoldThresholdConfig.class)).a();
        if (r18 == null) goto L21;
        int r19 = r18.intValue();
    L22:
        r17.a(Integer.valueOf(r19));
        r15 = ICUUtils.icuFormat(r16, r17.a);
        goto L23
    L21:
        r19 = 14;
    L23:
        r12.setText(r15);
        r8.c.setOnClickListener(new l(r8));
        r8.d.setOnClickListener(new m(r8));
        return;
    L9:
        r4 = null;
        goto L10
    }

    @Override // com.ss.android.lark.feed.shared.page.adapter.FeedListAdapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r3, int r4) {
        if (r4 != Integer.MAX_VALUE) goto L7;
        return new FeedExpiredFoldHintViewHolder(LayoutInflater.from(r3.getContext()).inflate(2131561097, r3, false), new g(this));
    L7:
        return super.onCreateViewHolder(r3, r4);
    }

    public LarkFeedInBoxListAdapter(reb.a<com.ss.android.lark.feed.export.feedcard.e> r1, com.ss.android.lark.feed.export.feedcard.d r2, bw7.b r3) {
        super(r1, r2, r3);
        this.q = new Object();
        a r4 = new a(this);
        this.u = true;
        this.b.a = r4;
        setHasStableIds(true);
    }

    public final void J2(RecyclerView.ViewHolder r2, int r3, boolean r4) {
        if (this.t == false) goto L22;
        this.t = false;
        c r0 = this.r;
        if (r0 == null) goto L8;
        r0.b();
    L8:
        if ((r2 instanceof FeedCommonViewHolder) == false) goto L23;
        UIFeedCard r5 = G2(r3);
        if (r5 == null) goto L24;
        aeb.f r6 = ((FeedCommonViewHolder) r2).z;
        if (r6 == null) goto L25;
        if (r4 == true) goto L15;
    L17:
        if (r4 == false) goto L19;
        return;
    L19:
        if (r5.isSwipeRightPinned() == true) goto L28;
        r6.l(r5);
        return;
    L28:
        return;
    L15:
        if (r5.isSwipedLeftPinned() == true) goto L17;
        r6.g(r5);
        return;
    L25:
        return;
    L24:
        return;
    L23:
        return;
    }

    public final void b0(RecyclerView.ViewHolder r2, int r3, int r4) {
        if (r4 != 3) goto L6;
        J2(r2, r3, false);
        return;
    L6:
        if (r4 != 1) goto L10;
        J2(r2, r3, true);
        return;
    }

    public final cw7.a q2(RecyclerView.ViewHolder r3, int r4, int r5) {
        if (r5 != 1) goto L5;
    L29:
        c r6 = this.r;
        if (r6 == null) goto L32;
        r6.a();
    L32:
        I2();
        return null;
    L5:
        if (r5 == 2) goto L22;
        if (r5 == 4) goto L9;
        return null;
    L9:
        UIFeedCard r7 = G2(r4);
        if (r7.isSwipedLeftPinned() == false) goto L14;
        return new f(this, r4);
    L14:
        if ((r3 instanceof BaseFeedSwipeableViewHolder) == false) goto L22;
        if (((BaseFeedSwipeableViewHolder) r3).l == false) goto L20;
        return new dfb.g(this, r3, r7, this.g);
    L20:
        return new e(this, r3, r4);
    L22:
        if ((r3 instanceof BaseFeedSwipeableViewHolder) == false) goto L29;
        if (((BaseFeedSwipeableViewHolder) r3).l == false) goto L28;
        return new f(this, r4);
    L28:
        return new d(this, this, r4);
    }

    public final int Q1(RecyclerView.ViewHolder r8, int r9, int r10, int r11) {
        int r1 = 0;
        if (this.u == true) goto L5;
        return 0;
    L5:
        int r0 = dfb.a.a;
        Intrinsics.checkNotNullParameter(r8, "holder");
        boolean r3 = true;
        if ((r8 instanceof FeedCommonViewHolder) == true) goto L8;
        heb.a.a.getFeedDependency().getClass();
        Intrinsics.checkNotNullParameter(r8, "holder");
        boolean r2 = false;
    L10:
        if (r2 == false) goto L27;
        if (G2(r9).getType() == FeedCard.Type.BOX) goto L14;
        boolean r4 = true;
    L15:
        if (r4 == false) goto L27;
        int r5 = seb.b.d;
        Intrinsics.checkNotNullParameter(r8, "holder");
        if ((r8 instanceof BaseFeedSwipeableViewHolder) == false) goto L21;
        BaseFeedSwipeableViewHolder r12 = (BaseFeedSwipeableViewHolder) r8;
        if (h.c(r12.r1(), r10, r11) == false) goto L21;
        r1 = r12.T3();
    L21:
        if (r1 == 8194) goto L23;
    L25:
        return r1;
    L23:
        if (G2(r9).equals(this.s) == true) goto L25;
        I2();
        this.s = null;
        goto L25
    L14:
        r4 = false;
    L27:
        if ((r8 instanceof AbstractSwipeableItemViewHolder) == true) goto L29;
    L39:
        return 0;
    L29:
        if (G2(r9).getType() != FeedCard.Type.BOX) goto L32;
        r3 = false;
    L32:
        if (r3 == false) goto L39;
        if (h.c(((AbstractSwipeableItemViewHolder) r8).r1(), r10, r11) == false) goto L39;
        if (G2(r9).equals(this.s) == true) goto L38;
        I2();
        this.s = null;
    L38:
        return 8194;
    L8:
        r2 = true;
        goto L10
    }
}
