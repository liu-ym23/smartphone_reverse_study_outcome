package com.bytedance.android.livesdk.interactivity.comment.input.view;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livehostapi.business.IMiddlewareHostBusiness;
import com.bytedance.android.livesdk.chatroom.model.j;
import com.bytedance.android.livesdk.chatroom.model.l;
import com.bytedance.lighten.loader.SmartCircleImageView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import w62.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/comment/input/view/LiveVideoCommentSearchVideoViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "a", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveVideoCommentSearchVideoViewHolder extends RecyclerView.ViewHolder {
    public static final /* synthetic */ int s = 0;
    public final SmartCircleImageView a;
    public final TextView b;
    public final TextView c;
    public final TextView d;
    public final FrameLayout e;
    public final ViewGroup f;
    public final ImageView g;
    public final ViewGroup h;
    public final ViewGroup i;
    public final HSImageView j;
    public l k;
    public int l;
    public int m;
    public IMiddlewareHostBusiness.AwemeCustomPureVideoPlayerView n;
    public final g o;
    public final int p;
    public final int q;
    public final boolean r;

    public static final class a {
    }

    static {
    }

    public final void T3(boolean r7) {
        FrameLayout r0 = this.e;
        View r1 = null;
        if (r0 == null) goto L5;
        Integer r2 = Integer.valueOf(r0.getChildCount());
    L6:
        int r3 = r2.intValue();
        if (this.n == null) goto L20;
        if (r3 <= 0) goto L20;
        g r4 = this.o;
        l r5 = this.k;
        if (r5 == null) goto L16;
        j r6 = r5.a;
        if (r6 == null) goto L16;
        Long r8 = r6.e();
        if (r8 == null) goto L16;
        long r9 = r8.longValue();
    L18:
        if (r4.RH(r9) == false) goto L20;
        boolean r10 = true;
    L21:
        if (r10 == false) goto L28;
        if (r7 == true) goto L28;
        IMiddlewareHostBusiness.AwemeCustomPureVideoPlayerView r11 = this.n;
        if (r11 == null) goto L50;
        r11.resumeVideoPlayer();
        return;
    L50:
        return;
    L28:
        if (this.n != null) goto L30;
        w62.a r13 = w62.a.b;
        this.n = w62.a.C0291a.a().a;
    L30:
        this.e.removeAllViews();
        IMiddlewareHostBusiness.AwemeCustomPureVideoPlayerView r14 = this.n;
        if (r14 == null) goto L33;
        r1 = r14.asView();
    L33:
        if (r1 != null) goto L35;
    L42:
        this.o.Px();
        l r15 = this.k;
        if (r15 == null) goto L51;
        Object r16 = r15.c;
        if (r16 == null) goto L52;
        IMiddlewareHostBusiness.AwemeCustomPureVideoPlayerView r17 = this.n;
        if (r17 == null) goto L53;
        r17.startVideoPlayer(r16, this.l, this.m, 0);
        return;
    L53:
        return;
    L52:
        return;
    L51:
        return;
    L35:
        if (r1.getParent() == null) goto L41;
        ViewParent r18 = r1.getParent();
        if (r18 == null) goto L40;
        ((ViewGroup) r18).removeView(r1);
        goto L41
    L40:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    L41:
        this.e.addView(r1);
    L16:
        r9 = 0;
    L20:
        r10 = false;
        goto L21
    L5:
        r2 = null;
        goto L6
    }

    public LiveVideoCommentSearchVideoViewHolder(View r2, g r3, int r4, int r5, boolean r6) {
        Intrinsics.checkNotNullParameter(r2, "itemView");
        Intrinsics.checkNotNullParameter(r3, "callback");
        super(r2);
        this.o = r3;
        this.p = r4;
        this.q = r5;
        this.r = r6;
        this.a = r2.findViewById(2131392312);
        this.b = (TextView) r2.findViewById(2131392316);
        this.c = (TextView) r2.findViewById(2131392314);
        this.d = (TextView) r2.findViewById(2131392315);
        this.e = (FrameLayout) r2.findViewById(2131392283);
        this.f = (ViewGroup) r2.findViewById(2131392318);
        this.g = (ImageView) r2.findViewById(2131392339);
        this.h = (ViewGroup) r2.findViewById(2131392319);
        this.i = (ViewGroup) r2.findViewById(2131392311);
        this.j = r2.findViewById(2131392313);
    }
}
