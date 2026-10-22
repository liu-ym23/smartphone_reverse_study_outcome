package com.bytedance.android.livesdk.feed.live;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.base.model.feed.FeedItem;
import com.bytedance.android.live.core.viewholder.BaseViewHolder;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livehostapi.business.depend.ad.IAdViewTrackService;
import com.bytedance.android.livesdk.feed.context.LiveFeedContext;
import com.bytedance.android.livesdk.feed.f;
import com.bytedance.android.livesdk.feed.feed.FeedDataKey;
import com.bytedance.android.livesdk.feed.j;
import com.bytedance.android.livesdkapi.depend.model.live.HotsoonAd;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.common.utility.collection.CollectionUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import g60.c;
import io.reactivex.subjects.PublishSubject;
import jw1.n;
import jw1.o;
import jw1.p;
import jw1.q;
import jw1.r;
import jw1.s;
import jw1.t;
import jw1.w;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public class HotsoonLiveAdViewHolder extends BaseViewHolder<FeedItem> {
    public static final /* synthetic */ int s = 0;
    public final HSImageView a;
    public final TextView b;
    public final TextView c;
    public final TextView d;
    public final ImageView e;
    public int f;
    public FeedItem g;
    public final View h;
    public final boolean i;
    public boolean j;
    public boolean k;
    public boolean l;
    public final n m;
    public final PublishSubject<Object> n;
    public final PublishSubject<Object> o;
    public final IAdViewTrackService p;
    public final f q;
    public final FeedDataKey r;

    public final void V3() {
        if (this.p == null) goto L12;
        FeedItem r0 = this.g;
        if (r0 != null) goto L7;
        return;
    L7:
        if (r0.getItem() != null) goto L9;
        return;
    L9:
        if ((this.g.getItem() instanceof HotsoonAd) == false) goto L15;
        HotsoonAd r1 = this.g.getItem();
        this.p.bind(r1.getTrackMixId(1), ((RecyclerView.ViewHolder) this).itemView);
        return;
    L15:
        return;
    }

    public final void W3() {
        LiveFeedContext.hostService().hsHostFunc().tryBindDownloadManager(((RecyclerView.ViewHolder) this).itemView.getContext(), ((RecyclerView.ViewHolder) this).itemView.hashCode(), this.m, this.g.adJSONObject);
    }

    public final void onViewAttachedToWindow() {
        super.onViewAttachedToWindow();
        FeedItem r0 = this.g;
        if (r0 != null) goto L5;
    L9:
        V3();
        return;
    L5:
        if (r0.getItem() == null) goto L9;
        if ((this.g.getItem() instanceof HotsoonAd) == false) goto L9;
        HotsoonAd r1 = this.g.getItem();
        LiveFeedContext.hostService().hsHostFunc().adLog(((RecyclerView.ViewHolder) this).itemView.getContext(), "feed_ad", "show", r1.getId(), 0, r1.buildEventCommonParams());
        LiveFeedContext.hostService().hsHostFunc().sendAdStats(((RecyclerView.ViewHolder) this).itemView.getContext(), r1.getTrackUrlList(), false, new Object[]{this.g.adJSONObject, "show"});
        goto L9
    }

    public final void onViewDetachedFromWindow() {
        super.onViewDetachedFromWindow();
        if (this.p == null) goto L21;
        FeedItem r1 = this.g;
        if (r1 != null) goto L7;
        return;
    L7:
        if (r1.getItem() != null) goto L9;
        return;
    L9:
        if ((this.g.getItem() instanceof HotsoonAd) == false) goto L24;
        HotsoonAd r2 = this.g.getItem();
        JSONObject r3 = this.p.unbind(r2.getTrackMixId(1));     // Catch: JSONException -> L16
        JSONObject r11 = r2.buildEventCommonParams();     // Catch: JSONException -> L16
        if (r3 == null) goto L14;
        long r5 = r3.optLong("duration", 0);     // Catch: JSONException -> L16
        r3.put("play_50", r3.optLong("play_100", 0));     // Catch: JSONException -> L16
        r3.remove("duration");     // Catch: JSONException -> L16
        r11.put("duration", r5);     // Catch: JSONException -> L16
        r11.put("ad_extra_data", r3);     // Catch: JSONException -> L16
    L14:
        LiveFeedContext.hostService().hsHostFunc().adLog(((RecyclerView.ViewHolder) this).itemView.getContext(), "feed_ad", "show_over", r2.getId(), 0, r11);     // Catch: JSONException -> L16
        return;
    L16:
        e = move-exception;
        e.printStackTrace();
        return;
    L24:
        return;
    }

    public final void unbind() {
        super.unbind();
        if (this.g == null) goto L6;
        LiveFeedContext.hostService().hsHostFunc().tryUnBindDowloadManager(((RecyclerView.ViewHolder) this).itemView.getContext(), ((RecyclerView.ViewHolder) this).itemView.hashCode(), this.g.adJSONObject);
    L6:
        if (this.k == false) goto L11;
        this.k = false;
        if (this.g == null) goto L12;
        LiveFeedContext.hostService().hsHostFunc().unBindHost(((RecyclerView.ViewHolder) this).itemView.getContext(), this.g.adJSONObject);
        return;
    L12:
        return;
    }

    public final void T3(String r13) {
        FeedItem r0 = this.g;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.getItem() != null) goto L7;
        return;
    L7:
        if ((this.g.getItem() instanceof HotsoonAd) == false) goto L15;
        HotsoonAd r1 = this.g.getItem();
        if (r1.getType().equals("app") == false) goto L11;
        LiveFeedContext.hostService().hsHostFunc().onClickEvent(((RecyclerView.ViewHolder) this).itemView.getContext(), this.g.adJSONObject, "feed_ad", r13, true);
        return;
    L11:
        LiveFeedContext.hostService().hsHostFunc().adLog(((RecyclerView.ViewHolder) this).itemView.getContext(), "feed_ad", "click", r1.getId(), 0, r1.buildEventCommonParams(r13, 0));
        LiveFeedContext.hostService().hsHostFunc().sendAdStats(((RecyclerView.ViewHolder) this).itemView.getContext(), r1.getClickTrackUrlList(), true, new Object[]{this.g.adJSONObject, "click"});
        return;
    }

    public final void U3(FeedItem r6, int r7) {
        if (r6 != null) goto L4;
        return;
    L4:
        if (r6.getItem() != null) goto L6;
        return;
    L6:
        if ((r6.getItem() instanceof HotsoonAd) == false) goto L25;
        HotsoonAd r0 = r6.getItem();
        int r2 = 2;
        if (r7 == 1) goto L14;
        if (r7 == 2) goto L14;
        r2 = -1;
    L19:
        if (r7 != 3) goto L21;
        r2 = 4;
    L21:
        LiveFeedContext.hostService().hsHostFunc().onAdActionCLick(((RecyclerView.ViewHolder) this).itemView.getContext(), r6.adJSONObject, r2, new Object[0]);
        return;
    L14:
        if (r0.getDisplayType() != 1) goto L17;
        r2 = 1;
        goto L19
    L17:
        if (r0.isUseCompoundLandPage() == false) goto L19;
        r2 = 3;
        goto L19
    }

    public final void bind(Object r6, int r7) {
        final FeedItem r8 = (FeedItem) r6;
        this.g = r8;
        if (this.k == true) goto L8;
        this.k = true;
        if (r8 == null) goto L8;
        LiveFeedContext.hostService().hsHostFunc().bindHost(((RecyclerView.ViewHolder) this).itemView.getContext(), this.g.adJSONObject, new Object[]{new w(this)});
    L8:
        if (this.f > 0) goto L10;
        this.f = UIUtils.getScreenWidth(this.a.getContext());
    L10:
        HSImageView r9 = this.a;
        int r2 = this.f;
        r9.setLayoutParams(new RelativeLayout.LayoutParams(r2, r2));
        if (r8 != null) goto L13;
        return;
    L13:
        if ((r8.getItem() instanceof HotsoonAd) == false) goto L42;
        HotsoonAd r10 = r8.getItem();
        this.b.setOnClickListener(new o(this, r8));
        ((RecyclerView.ViewHolder) this).itemView.setOnClickListener(new p(this, r8));
        if (this.i == false) goto L18;
        ((RecyclerView.ViewHolder) this).itemView.setOnLongClickListener(new q(this));
    L19:
        this.h.setOnClickListener(new r(this, r8));
        if (CollectionUtils.isEmpty(r10.getImageList()) == true) goto L27;
        if (ListProtector.get(r10.getImageList(), 0) == null) goto L27;
        if (CollectionUtils.isEmpty(((HotsoonAd.SimpleImage) ListProtector.get(r10.getImageList(), 0)).getUrlList()) == true) goto L27;
        this.a.setImageURI((String) ListProtector.get(((HotsoonAd.SimpleImage) ListProtector.get(r10.getImageList(), 0)).getUrlList(), 0));
    L27:
        if (TextUtils.isEmpty(r10.getTitle()) == true) goto L29;
        this.b.setText(r10.getTitle());
        this.b.setVisibility(0);
    L31:
        if (TextUtils.isEmpty(r10.getLabel()) == true) goto L33;
        this.d.setText(r10.getLabel());
    L33:
        this.c.setText(r10.getButtonText());
        W3();
        PublishSubject<Object> r11 = this.n;
        if (r11 == null) goto L36;
        register(r11.subscribe(new s(this), new c()));
    L36:
        PublishSubject<Object> r12 = this.o;
        if (r12 == null) goto L41;
        register(r12.subscribe(new t(this), new c()));
        return;
    L41:
        return;
    L29:
        this.b.setVisibility(8);
        goto L31
    L18:
        ((RecyclerView.ViewHolder) this).itemView.setOnLongClickListener(null);
        goto L19
    }

    /* JADX WARN: Type inference failed for: r4v3, types: [jw1.n] */
    public HotsoonLiveAdViewHolder(View r4, f r5, FeedDataKey r6, j r7, PublishSubject r8, PublishSubject r9) {
        super(r4);
        this.f = -1;
        boolean r0 = false;
        this.k = false;
        this.a = r4.findViewById(2131375969);
        this.b = (TextView) r4.findViewById(2131388772);
        this.c = (TextView) r4.findViewById(2131390107);
        this.e = (ImageView) r4.findViewById(2131376352);
        this.h = r4.findViewById(2131362200);
        this.d = (TextView) r4.findViewById(2131389446);
        this.m = new n(this);
        if (r6 == null) goto L8;
        if (r7 == null) goto L8;
        if (r7.b(r6.c) == false) goto L8;
        r0 = true;
    L8:
        this.i = r0;
        this.q = r5;
        this.r = r6;
        this.n = r8;
        this.o = r9;
        this.p = LiveFeedContext.hostService().hsHostFunc().provideViewTrackService();
    }
}
