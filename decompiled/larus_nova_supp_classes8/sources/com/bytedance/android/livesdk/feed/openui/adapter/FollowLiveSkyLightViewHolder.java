package com.bytedance.android.livesdk.feed.openui.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.viewholder.BaseViewHolder;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdk.chatroom.utils.a1;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.RoomExtra;
import com.bytedance.android.livesdkapi.view.HostAvatarBorderViewController;
import com.bytedance.android.livesdkapi.view.SaasLiveCircleView;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kw1.c;
import nw1.a;
import ry.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/feed/openui/adapter/FollowLiveSkyLightViewHolder;", "Lcom/bytedance/android/live/core/viewholder/BaseViewHolder;", "Lcom/bytedance/android/livesdkapi/depend/model/live/Room;", "", "saasfeed_release"}, k = 1, mv = {1, 4, 3})
public final class FollowLiveSkyLightViewHolder extends BaseViewHolder<Room> {
    public final HSImageView a;
    public final TextView b;
    public final Context c;
    public final SaasLiveCircleView d;
    public f e;
    public Room f;
    public final Float g;
    public final Integer h;
    public final f i;
    public final Function1<Room, Unit> j;
    public final String k;
    public final String l;

    public final void bind(Object r7, int r8) {
        Room r9 = (Room) r7;
        this.f = r9;
        ((RecyclerView.ViewHolder) this).itemView.setScaleX(1.0f);
        ((RecyclerView.ViewHolder) this).itemView.setScaleY(1.0f);
        ((RecyclerView.ViewHolder) this).itemView.setOnClickListener(new a(this, r9));
        if (r9 == null) goto L11;
        User r10 = r9.getOwner();
        if (r10 == null) goto L11;
        if (r10.getAvatarThumb() == null) goto L9;
        a1.x(this.a, r10.getAvatarThumb(), this.a.getWidth(), this.a.getHeight(), 2131251889);
    L10:
        this.b.setText(r10.getNickName());
        goto L11
    L9:
        ImageLoader.bindDrawableResource(this.a, 2131251889);
    L11:
        Resources r11 = this.c.getResources();
        if (r11 != null) goto L14;
    L22:
        this.d.setVisibility(0);
        f r12 = this.i;
        Long r0 = null;
        if (r12 == null) goto L28;
        if (this.e != null) goto L28;
        this.e = r12;
    L35:
        HostAvatarBorderViewController r13 = this.e;
        if ((r13 instanceof HostAvatarBorderViewController) == false) goto L41;
        if (r13 == null) goto L40;
        r13.bind(null, FollowLiveSkyLightViewHolder.class);
        goto L41
    L40:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdkapi.view.HostAvatarBorderViewController");
    L41:
        ((RecyclerView.ViewHolder) this).itemView.requestLayout();
        LinkedHashMap r14 = new LinkedHashMap();
        r14.put("enter_from_merge", this.k);
        r14.put("enter_method", this.l);
        Room r15 = this.f;
        String r1 = "";
        if (r15 == null) goto L45;
        String r16 = r15.getOwnerUserIdString();
        if (r16 == null) goto L45;
    L46:
        r14.put("anchor_id", r16);
        Room r17 = this.f;
        if (r17 == null) goto L50;
        String r18 = String.valueOf(r17.id);
        if (r18 == null) goto L50;
    L51:
        r14.put("room_id", r18);
        r14.put("action_type", "click");
        Room r19 = this.f;
        if (r19 == null) goto L55;
        String r20 = r19.getRequestId();
        if (r20 == null) goto L55;
    L56:
        r14.put("request_id", r20);
        Room r21 = this.f;
        if (r21 == null) goto L62;
        String r22 = r21.getLog_pb();
        if (r22 == null) goto L62;
        r1 = r22;
    L62:
        r14.put("log_pb", r1);
        Room r23 = this.f;
        if (r23 == null) goto L65;
        RoomExtra r24 = r23.getExtra();
    L67:
        if (r24 == null) goto L81;
        Room r25 = this.f;
        if (r25 == null) goto L74;
        RoomExtra r26 = r25.getExtra();
        if (r26 == null) goto L74;
        if (r26.getXiguaUid() == 0) goto L81;
    L74:
        Room r27 = this.f;
        if (r27 == null) goto L79;
        RoomExtra r28 = r27.getExtra();
        if (r28 == null) goto L79;
        Long r29 = Long.valueOf(r28.getXiguaUid());
    L80:
        r14.put("xg_uid", String.valueOf(r29));
    L79:
        r29 = null;
    L81:
        Room r30 = this.f;
        if (r30 != null) goto L84;
    L85:
        if (r30 == null) goto L87;
        r0 = Long.valueOf(r30.appId);
    L87:
        r14.put("anchor_aid", String.valueOf(r0));
    L88:
        c.d("livesdk_live_show", r14);
        Room r31 = this.f;
        if (r31 == null) goto L96;
        nn2.a r32 = nn2.a.d;
        if (nn2.a.a.a().b(r31.id) == false) goto L95;
        nn2.a.a.a();
        Intrinsics.checkNotNullParameter(r31, "room");
        Intrinsics.checkNotNullParameter("banner_ad", "adType");
        nn2.a.a("show", r31, "banner_ad");
        return;
    L95:
        return;
    L96:
        return;
    L84:
        if (r30.appId == 0) goto L88;
    L65:
        r24 = null;
    L55:
        r20 = "";
    L50:
        r18 = "";
    L45:
        r16 = "";
    L28:
        if (this.e != null) goto L35;
        HSImageView r2 = this.a;
        HostAvatarBorderViewController r33 = new HostAvatarBorderViewController(true, r2, r2, this.d);
        r33.mEventType = "homepage_follow";
        Unit r3 = Unit.INSTANCE;
        this.e = r33;
        r33.setCloseAnim(false);
        f r34 = this.e;
        if ((r34 instanceof HostAvatarBorderViewController) == true) goto L32;
        r34 = null;
    L32:
        HostAvatarBorderViewController r35 = (HostAvatarBorderViewController) r34;
        if (r35 == null) goto L35;
        r35.setIsFollowSkyLiveAnimScene(true);
        goto L35
    L14:
        if (r11.getConfiguration() == null) goto L22;
        Float r36 = this.g;
        if (r36 == null) goto L18;
        this.b.setTextSize(r36.floatValue());
    L18:
        Integer r37 = this.h;
        if (r37 == null) goto L21;
        this.b.setTextColor(r37.intValue());
        goto L22
    L21:
        this.b.setTextColor(this.c.getResources().getColor(2131107469));
        goto L22
    }

    public FollowLiveSkyLightViewHolder(View r2, Integer r3, Integer r4, Integer r5, Float r6, Integer r7, f r8, Function1<? super Room, Unit> r9, String r10, String r11) {
        Intrinsics.checkNotNullParameter(r2, "itemView");
        Intrinsics.checkNotNullParameter(r9, "onItemClick");
        Intrinsics.checkNotNullParameter(r10, "enterFromMerge");
        Intrinsics.checkNotNullParameter(r11, "enterMethod");
        super(r2);
        this.g = r6;
        this.h = r7;
        this.i = r8;
        this.j = r9;
        this.k = r10;
        this.l = r11;
        this.a = r2.findViewById(2131376157);
        this.b = (TextView) r2.findViewById(2131390975);
        Context r12 = r2.getContext();
        this.c = r12;
        SaasLiveCircleView r13 = r2.findViewById(2131376366);
        this.d = r13;
        LinearLayout r14 = (LinearLayout) r2.findViewById(2131378486);
        TextView r15 = (TextView) r2.findViewById(2131390896);
        Drawable r16 = r14.getBackground();
        if ((r16 instanceof GradientDrawable) == false) goto L13;
        if (r3 == null) goto L14;
        r3.intValue();
        GradientDrawable r17 = (GradientDrawable) r16;
        r17.setStroke(r12.getResources().getDimensionPixelSize(2131168627), r3.intValue());
        if (r5 == null) goto L8;
        r17.setCornerRadius(r5.intValue());
    L8:
        if (r4 == null) goto L10;
        r17.setColor(r4.intValue());
        r13.setColors(r4.intValue(), r4.intValue());
    L11:
        r14.setBackground(r16);
        return;
    L10:
        r13.setColors(ColorProtector.parseColor("#FF1764"), ColorProtector.parseColor("#ED3495"));
        goto L11
    L14:
        return;
    }
}
