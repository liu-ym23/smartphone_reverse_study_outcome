package w62;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livehostapi.business.IMiddlewareHostBusiness;
import com.bytedance.android.livesdk.chatroom.model.j;
import com.bytedance.android.livesdk.chatroom.model.l;
import com.bytedance.android.livesdk.gift.platform.business.effect.assets.IAssetsManager;
import com.bytedance.android.livesdk.interactivity.comment.input.view.LiveVideoCommentSearchVideoViewHolder;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.lighten.loader.SmartCircleImageView;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import java.text.SimpleDateFormat;
import java.util.Date;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class b extends me.drakeet.multitype.b<l, LiveVideoCommentSearchVideoViewHolder> {
    public final g b;
    public final int c;
    public final int d;
    public final boolean e;

    public final void e(RecyclerView.ViewHolder r4) {
        LiveVideoCommentSearchVideoViewHolder r5 = (LiveVideoCommentSearchVideoViewHolder) r4;
        Intrinsics.checkNotNullParameter(r5, "holder");
        g r0 = r5.o;
        l r1 = r5.k;
        if (r1 == null) goto L9;
        j r2 = r1.a;
        if (r2 == null) goto L9;
        Long r3 = r2.e();
        if (r3 == null) goto L9;
        long r6 = r3.longValue();
    L11:
        if (r0.RH(r6) == false) goto L14;
        r5.T3(false);
        return;
    L14:
        return;
    L9:
        r6 = 0;
        goto L11
    }

    public final void f(RecyclerView.ViewHolder r4) {
        LiveVideoCommentSearchVideoViewHolder r5 = (LiveVideoCommentSearchVideoViewHolder) r4;
        Intrinsics.checkNotNullParameter(r5, "holder");
        g r0 = r5.o;
        l r1 = r5.k;
        if (r1 == null) goto L9;
        j r2 = r1.a;
        if (r2 == null) goto L9;
        Long r3 = r2.e();
        if (r3 == null) goto L9;
        long r6 = r3.longValue();
    L11:
        if (r0.l00(r6) == true) goto L18;
        r5.e.removeAllViews();
        IMiddlewareHostBusiness.AwemeCustomPureVideoPlayerView r7 = r5.n;
        if (r7 == null) goto L16;
        r7.stopVideoPlayer();
    L16:
        r5.n = null;
        return;
    L18:
        return;
    L9:
        r6 = 0;
        goto L11
    }

    public final void b(RecyclerView.ViewHolder r13, Object r14) {
        LiveVideoCommentSearchVideoViewHolder r15 = (LiveVideoCommentSearchVideoViewHolder) r13;
        l r16 = (l) r14;
        Intrinsics.checkNotNullParameter(r15, "holder");
        Intrinsics.checkNotNullParameter(r16, "item");
        r15.getClass();
        Intrinsics.checkNotNullParameter(r16, "awemeInfo");
        r15.k = r16;
        j r0 = r16.a;
        SmartCircleImageView r1 = r15.a;
        String r2 = null;
        if (r0 == null) goto L5;
        String r3 = r0.a();
    L6:
        ImageLoader.bindImage(r1, r3);
        TextView r4 = r15.b;
        String r5 = BuildConfig.FLAVOR;
        if (r0 == null) goto L11;
        String r6 = r0.g();
        if (r6 == null) goto L11;
    L12:
        r4.setText(r6);
        long r7 = 0;
        if (r0 == null) goto L17;
        Long r8 = r0.c();
        if (r8 == null) goto L17;
        long r9 = r8.longValue();
    L19:
        if (r9 <= 0) goto L25;
        TextView r10 = r15.c;
        String r11 = new SimpleDateFormat("yyyy.MM.dd").format(new Date(r9 * ((long) IAssetsManager.DownloadAssetsSource.SOURCE_LOCAL_SEND_GIFT_NOW)));     // Catch: Exception -> L23
    L24:
        r10.setText(r11);
    L23:
        r11 = BuildConfig.FLAVOR;
    L25:
        TextView r17 = r15.d;
        if (r0 == null) goto L30;
        String r18 = r0.h();
        if (r18 == null) goto L30;
        r5 = r18;
    L30:
        r17.setText(r5);
        boolean r19 = r16.b;
        if (r19 == false) goto L33;
        r15.g.setBackgroundResource(2131253237);
    L34:
        l r20 = r15.k;
        if (r20 == null) goto L37;
        r20.b = r19;
    L37:
        r15.h.setOnClickListener(new d(r15, r16));
        if (r15.r == false) goto L40;
        r15.f.setOnClickListener(new e(r15, r16));
        UtilityKotlinExtentionsKt.w(r15.f);
    L41:
        if (r0 == null) goto L45;
        Long r21 = r0.i();
        if (r21 == null) goto L45;
        long r23 = r21.longValue();
    L46:
        if (r0 == null) goto L51;
        Long r24 = r0.d();
        if (r24 == null) goto L51;
        r7 = r24.longValue();
    L51:
        if (r23 <= r7) goto L53;
        boolean r25 = true;
    L54:
        int r26 = r15.p;
        int r27 = r15.q;
        if (r25 == false) goto L57;
        r27 = (int) (r26 * 0.5625f);
    L58:
        r15.l = r26;
        r15.m = r27;
        ViewGroup.LayoutParams r28 = r15.i.getLayoutParams();
        if ((r28 instanceof LinearLayout.LayoutParams) == true) goto L61;
        r28 = null;
    L61:
        LinearLayout.LayoutParams r29 = (LinearLayout.LayoutParams) r28;
        if (r29 == null) goto L64;
        r29.width = r15.l;
        r29.height = r15.m;
        r15.i.setLayoutParams(r29);
    L64:
        GenericDraweeHierarchy r30 = r15.j.getHierarchy();
        if (r30 == null) goto L67;
        r30.setPlaceholderImage(2131108484);
    L67:
        HSImageView r31 = r15.j;
        j r110 = r16.a;
        if (r110 == null) goto L70;
        r2 = r110.b();
    L70:
        ImageLoader.bindImage(r31, r2, r15.l, r15.m);
        UtilityKotlinExtentionsKt.w(r15.j);
        r15.j.setOnClickListener(new f(r15));
        return;
    L57:
        r26 = (int) (r27 * 0.5625f);
        goto L58
    L53:
        r25 = false;
    L45:
        r23 = 0;
        goto L46
    L40:
        r15.f.setOnClickListener(null);
        UtilityKotlinExtentionsKt.t(r15.f);
        goto L41
    L33:
        r15.g.setBackgroundResource(2131253238);
    L17:
        r9 = 0;
    L11:
        r6 = BuildConfig.FLAVOR;
        goto L12
    L5:
        r3 = null;
        goto L6
    }

    public final RecyclerView.ViewHolder d(LayoutInflater r9, ViewGroup r10) {
        Intrinsics.checkNotNullParameter(r9, "inflater");
        Intrinsics.checkNotNullParameter(r10, "parent");
        return new LiveVideoCommentSearchVideoViewHolder(r9.inflate(2131567578, r10, false), this.b, this.c, this.d, this.e);
    }

    public b(Context r1, g r2, int r3, int r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r2, "selectSearchVideoCallback");
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }
}
