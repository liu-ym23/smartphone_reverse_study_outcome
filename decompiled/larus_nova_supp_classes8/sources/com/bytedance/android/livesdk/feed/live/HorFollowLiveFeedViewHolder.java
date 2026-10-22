package com.bytedance.android.livesdk.feed.live;

import am2.x;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.live.base.model.feed.FeedItem;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.core.utils.h1;
import com.bytedance.android.live.core.viewholder.BaseViewHolder;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livehostapi.TTLiveSDK;
import com.bytedance.android.livehostapi.business.depend.feed.IHostAvatarBorderController;
import com.bytedance.android.livesdk.chatroom.ui.SSLinearLayoutManager;
import com.bytedance.android.livesdk.feed.BannerSwipeRefreshLayout;
import com.bytedance.android.livesdk.feed.context.LiveFeedContext;
import com.bytedance.android.livesdk.log.filter.m0;
import com.bytedance.android.livesdk.log.filter.n0;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.common.utility.Lists;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.HashMap;
import java.util.List;
import jw1.l;
import jw1.m;
import kw1.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public class HorFollowLiveFeedViewHolder extends BaseViewHolder<FeedItem> {
    public static final /* synthetic */ int d = 0;
    public final RecyclerView a;
    public List<FeedItem> b;
    public final Context c;

    public class a extends RecyclerView.Adapter<BaseViewHolder> {
        public final /* synthetic */ HorFollowLiveFeedViewHolder a;

        public final int getItemCount() {
            return this.a.b.size();
        }

        public a(HorFollowLiveFeedViewHolder r1) {
            this.a = r1;
        }

        public final void onViewAttachedToWindow(RecyclerView.ViewHolder r5) {
            BaseViewHolder r6 = (BaseViewHolder) r5;
            super.onViewAttachedToWindow(r6);
            int r7 = r6.getPosition();
            if (r7 >= 0) goto L5;
            return;
        L5:
            if (r7 < this.a.b.size()) goto L7;
            return;
        L7:
            if (((FeedItem) ListProtector.get(this.a.b, r7)) != null) goto L10;
            return;
        L10:
            if ((((FeedItem) ListProtector.get(this.a.b, r7)).getItem() instanceof Room) == false) goto L34;
            Room r8 = ((FeedItem) ListProtector.get(this.a.b, r7)).getItem();
            if (r8.getBaseOwner() != null) goto L15;
            String r0 = "0";
        L16:
            HashMap r1 = new HashMap();
            r1.put("log_pb", r8.getLog_pb());
            r1.put("anchor_id", String.valueOf(r0));
            r1.put("request_id", r8.getRequestId());
            r1.put("room_id", String.valueOf(r8.getId()));
            r1.put("show_type", "stay");
            if (r8.isLiveTypeAudio() == false) goto L19;
            String r2 = "voice_live";
        L20:
            r1.put("live_type", r2);
            if (r8.isThirdParty() == false) goto L23;
            String r3 = "thirdparty";
        L24:
            r1.put("streaming_type", r3);
            r1.put("enter_from_merge", "live_merge");
            r1.put("enter_method", "follow_live");
            r1.put("event_belong", "live_view");
            r1.put("event_page", "live");
            r1.put("event_type", "core");
            r1.put("event_module", "live");
            r1.put("action_type", "click");
            r1.putAll(h1.a(r8));
            n0 r9 = u.l().c(x.class);
            if ((r9 instanceof n0) == false) goto L29;
            String r10 = r9.i;
            if (r10 == null) goto L29;
            r1.put("distribute_source", r10);
        L29:
            m0.J(r1);
            c.d("livesdk_live_show", r1);
            return;
        L23:
            r3 = "general";
            goto L24
        L19:
            r2 = "video_live";
            goto L20
        L15:
            r0 = r8.getBaseOwner().getIdString();
            goto L16
        }

        public final void onBindViewHolder(RecyclerView.ViewHolder r2, int r3) {
            BaseViewHolder r4 = (BaseViewHolder) r2;
            if (r3 >= 0) goto L5;
            return;
        L5:
            if (r3 < this.a.b.size()) goto L8;
            return;
        L8:
            if (ListProtector.get(this.a.b, r3) == null) goto L14;
            r4.bind(ListProtector.get(this.a.b, r3), r3);
            return;
        }

        public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r2, int r3) {
            return new b(this.a, r2);
        }
    }

    public class b extends BaseViewHolder<FeedItem> {
        public final HSImageView a;
        public final TextView b;
        public final View c;
        public IHostAvatarBorderController d;
        public final a e;
        public final /* synthetic */ HorFollowLiveFeedViewHolder f;

        public class a implements View.OnAttachStateChangeListener {
            public final /* synthetic */ b a;

            public a(b r1) {
                this.a = r1;
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public final void onViewAttachedToWindow(View r1) {
                IHostAvatarBorderController r2 = this.a.d;
                if (r2 == null) goto L6;
                r2.playAnimation();
                return;
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public final void onViewDetachedFromWindow(View r1) {
                IHostAvatarBorderController r2 = this.a.d;
                if (r2 == null) goto L6;
                r2.stopAnimation();
                return;
            }
        }

        public final void onViewAttachedToWindow() {
            super.onViewAttachedToWindow();
            IHostAvatarBorderController r0 = this.d;
            if (r0 == null) goto L6;
            r0.playAnimation();
            return;
        }

        public final void onViewDetachedFromWindow() {
            super.onViewDetachedFromWindow();
            IHostAvatarBorderController r0 = this.d;
            if (r0 == null) goto L6;
            r0.stopAnimation();
            return;
        }

        public b(HorFollowLiveFeedViewHolder r4, ViewGroup r5) {
            this.f = r4;
            super(LayoutInflater.from(r5.getContext()).inflate(2131566016, r5, false));
            this.e = new a(this);
            this.a = ((RecyclerView.ViewHolder) this).itemView.findViewById(2131389611);
            this.b = (TextView) ((RecyclerView.ViewHolder) this).itemView.findViewById(2131389614);
            View r6 = TTLiveSDK.hostService().hostApp().liveCircleView(r5.getContext());
            if ((r6 instanceof View) == false) goto L6;
            View r7 = r6;
            this.c = r7;
            r7.setLayoutParams(((RecyclerView.ViewHolder) this).itemView.findViewById(2131389612).getLayoutParams());
            int r8 = (int) UIUtils.dip2Px(r5.getContext(), 3.0f);
            r7.setPadding(r8, r8, r8, r8);
            ((FrameLayout) ((RecyclerView.ViewHolder) this).itemView.findViewById(2131389462)).addView(r7, 0);
            ((RecyclerView.ViewHolder) this).itemView.findViewById(2131374802).setVisibility(0);
            return;
        }

        public final void bind(Object r5, int r6) {
            final FeedItem r7 = (FeedItem) r5;
            if (r7 != null) goto L6;
            return;
        L6:
            if ((r7.getItem() instanceof Room) == false) goto L22;
            User r8 = r7.getItem().getBaseOwner();
            if (r8 == null) goto L16;
            ImageModel r1 = r8.getAvatarThumb();
            if (r1 != null) goto L13;
        L15:
            this.b.setText(r8.getNickName());
            goto L16
        L13:
            if (Lists.isEmpty(r1.getUrls()) == true) goto L15;
            this.a.setImageURI((String) ListProtector.get(r1.getUrls(), 0));
        L16:
            this.a.setVisibility(8);
            this.a.setVisibility(0);
            IHostAvatarBorderController r9 = LiveFeedContext.hostService().hostApp().avatarBorderController();
            this.d = r9;
            if (r9 == null) goto L19;
            r9.bindAvatarAndBorder(this.a, this.c, true);
            this.d.setBorderVisibility(0);
            this.d.playAnimation();
            this.a.addOnAttachStateChangeListener(this.e);
        L19:
            ((RecyclerView.ViewHolder) this).itemView.setOnClickListener(new m(this, r7));
            return;
        }
    }

    public HorFollowLiveFeedViewHolder(View r4, BannerSwipeRefreshLayout.a r5) {
        super(r4);
        Context r6 = r4.getContext();
        this.c = r6;
        RecyclerView r0 = (RecyclerView) ((RecyclerView.ViewHolder) this).itemView.findViewById(2131389613);
        this.a = r0;
        r0.setLayoutManager(new SSLinearLayoutManager(r6, 0));
        r0.setOnTouchListener(new l(this));
        r5.b(r0);
    }

    public final void bind(Object r1, int r2) {
        FeedItem r3 = (FeedItem) r1;
        if ((r3 instanceof com.bytedance.android.livesdk.feed.feed.c) == false) goto L7;
        this.b = ((com.bytedance.android.livesdk.feed.feed.c) r3).a;
        this.a.setAdapter(new a(this));
        return;
    }
}
