package com.bytedance.android.live.liveinteract.videotalk.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.liveinteract.api.utils.m;
import com.bytedance.android.live.liveinteract.plantform.model.c1;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/liveinteract/videotalk/adapter/VideoRoomAudiencePreApplyViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "a", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class VideoRoomAudiencePreApplyViewHolder extends RecyclerView.ViewHolder {
    public final HSImageView a;
    public final TextView b;
    public final TextView c;
    public final LinearLayout d;
    public final TextView e;
    public final ImageView f;
    public final boolean g;
    public final IRoom h;
    public String i;
    public final a j;
    public final Map<com.bytedance.android.live.liveinteract.linkpanel.util.c, View> k;

    public interface a {
        void a(c1 r1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public VideoRoomAudiencePreApplyViewHolder(View r2, a r3, Map<com.bytedance.android.live.liveinteract.linkpanel.util.c, ? extends View> r4) {
        Intrinsics.checkNotNullParameter(r2, "itemView");
        Intrinsics.checkNotNullParameter(r4, "badgeTypeMap");
        super(r2);
        this.j = r3;
        this.k = r4;
        this.a = r2.findViewById(2131376286);
        this.b = (TextView) r2.findViewById(2131390975);
        this.c = (TextView) r2.findViewById(2131391589);
        this.d = (LinearLayout) r2.findViewById(2131380597);
        this.e = (TextView) r2.findViewById(2131382185);
        this.f = (ImageView) r2.findViewById(2131376272);
        Boolean r5 = m.i().isAnchor();
        if (r5 == null) goto L5;
        boolean r6 = r5.booleanValue();
    L6:
        this.g = r6;
        com.bytedance.live.datacontext.m r7 = m.i().getRoom();
        if (r7 == null) goto L9;
        IRoom r8 = (IRoom) r7.getValue();
    L10:
        this.h = r8;
        this.i = "";
        return;
    L9:
        r8 = null;
        goto L10
    L5:
        r6 = false;
        goto L6
    }
}
