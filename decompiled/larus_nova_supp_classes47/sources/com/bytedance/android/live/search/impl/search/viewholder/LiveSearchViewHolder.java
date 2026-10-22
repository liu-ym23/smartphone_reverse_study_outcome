package com.bytedance.android.live.search.impl.search.viewholder;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.core.utils.FormatUtils;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.viewholder.BaseViewHolder;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.search.impl.search.b;
import com.bytedance.android.livesdk.config.uj;
import com.bytedance.android.livesdk.utils.p1;
import com.bytedance.android.livesdk.widget.LiveCoverOptView;
import com.bytedance.android.livesdkapi.depend.model.live.LiveHashTagInfo;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.common.utility.Lists;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.common.utility.UIUtils;
import j40.b4;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import qa1.e;
import sa1.d;
import sa1.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/search/impl/search/viewholder/LiveSearchViewHolder;", "Lcom/bytedance/android/live/core/viewholder/BaseViewHolder;", "Lcom/bytedance/android/livesdkapi/depend/model/live/Room;", "a", "livesearchimpl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveSearchViewHolder extends BaseViewHolder<Room> {
    public static int t;
    public static int u;
    public static int v;
    public final TextView a;
    public final HSImageView b;
    public final HSImageView c;
    public final TextView d;
    public final View e;
    public final TextView f;
    public final ImageView g;
    public final View h;
    public final TextView i;
    public Room j;
    public int k;
    public e l;
    public b m;
    public int n;
    public final View o;
    public final LiveCoverOptView p;
    public boolean q;
    public d r;
    public final ViewGroup s;

    public static final class a {
    }

    static {
        t = -1;
        u = -1;
        v = -1;
    }

    public final void unbind() {
        super.unbind();
        d r0 = this.r;
        if (r0 == null) goto L7;
        ViewGroup r1 = this.s;
        if (r1 == null) goto L7;
        r1.removeOnLayoutChangeListener(r0);
    L7:
        this.r = null;
    }

    public LiveSearchViewHolder(View r2, ViewGroup r3) {
        Intrinsics.checkNotNullParameter(r2, "itemView");
        Intrinsics.checkNotNullParameter(r3, "parent");
        super(r2);
        this.s = r3;
        this.a = (TextView) r2.findViewById(2131388772);
        this.b = r2.findViewById(2131378264);
        this.c = r2.findViewById(2131378456);
        this.d = (TextView) r2.findViewById(2131363364);
        this.e = r2.findViewById(2131376379);
        this.f = (TextView) r2.findViewById(2131379123);
        this.g = (ImageView) r2.findViewById(2131378516);
        this.h = r2.findViewById(2131378473);
        this.i = (TextView) r2.findViewById(2131378472);
        s1.B(2131922371);
        this.n = s1.j(2131169122);
        this.o = r2.findViewById(2131367812);
        this.p = r2.findViewById(2131378272);
    }

    public final void T3(Room r12, int r13) {
        this.j = r12;
        this.k = r13;
        String r14 = null;
        if (r12 != null) goto L5;
        ((RecyclerView.ViewHolder) this).itemView.setOnLongClickListener(null);
        return;
    L5:
        if (b4.a() == true) goto L7;
        ViewGroup.LayoutParams r0 = ((RecyclerView.ViewHolder) this).itemView.getLayoutParams();
        int r1 = this.n;
        r0.width = r1;
        r0.height = (r1 * 200) / 164;
        ((RecyclerView.ViewHolder) this).itemView.setLayoutParams(r0);
    L7:
        View r2 = this.h;
        if (r2 == null) goto L10;
        r2.setVisibility(0);
    L10:
        View r3 = this.e;
        if (r3 == null) goto L13;
        r3.setVisibility(8);
    L13:
        this.g.setVisibility(8);
        User r4 = r12.getOwner();
        LiveHashTagInfo r5 = r12.getLiveHashTagInfo();
        if (TextUtils.isEmpty(r12.getTitle()) == false) goto L34;
        uj r6 = uj.a;
        if (r6.getValue() != null) goto L18;
    L20:
        boolean r7 = false;
    L21:
        String r8 = "";
        if (r7 == false) goto L28;
        if (r5 == null) goto L25;
        this.a.setText(r5.name);
    L38:
        if (r12.isMediaRoom() == false) goto L50;
        TextView r9 = this.f;
        if (r9 == null) goto L42;
        r9.setVisibility(8);
    L42:
        User r10 = r12.getOwner();
        if (r10 == null) goto L50;
        if (TextUtils.isEmpty(r10.getRealNickName()) == true) goto L50;
        TextView r15 = this.a;
        if (r15 == null) goto L49;
        r15.setVisibility(0);
    L49:
        this.a.setText(r10.getRealNickName());
    L50:
        ImageModel r16 = r12.getCover();
        if (r16 != null) goto L53;
    L61:
        this.b.setImageResource(2131250288);
        if ((r16 instanceof ImageModel) == true) goto L64;
        r16 = null;
    L64:
        ImageModel r17 = r16;
        if (r17 != null) goto L67;
        U3(0, 0);
    L68:
        ImageModel r18 = r12.getFeedRoomLabel();
        if (r18 != null) goto L71;
    L74:
        this.c.setVisibility(8);
    L75:
        Room r19 = this.j;
        if (r19 == null) goto L89;
        TextView r20 = this.i;
        long r22 = 4;
        if (r19.getStatus() != r22) goto L81;
        String r23 = s1.B(2131922373);
    L82:
        r20.setText(r23);
        if (r19.getStatus() != r22) goto L85;
        this.d.setVisibility(4);
        goto L89
    L85:
        this.d.setText(p1.a(r19));
        if (p1.c(r19) == false) goto L88;
        this.d.setVisibility(8);
        goto L89
    L88:
        this.d.setVisibility(0);
        goto L89
    L81:
        r23 = s1.B(2131922372);
    L89:
        if (r4 == null) goto L92;
        r14 = r4.getCity();
    L92:
        if (StringUtils.isEmpty(r14) == false) goto L96;
        this.f.setVisibility(8);
        View r110 = this.e;
        if (r110 == null) goto L97;
        r110.setVisibility(8);
    L97:
        UIUtils.setViewVisibility(this.c, 8);
        UIUtils.setViewVisibility(this.o, 8);
        this.p.setVisibility(0);
        this.p.c(r12);
        ((RecyclerView.ViewHolder) this).itemView.setOnClickListener(new f(this, r12));
        return;
    L96:
        this.f.setText(r14);
        this.f.setVisibility(0);
        goto L97
    L71:
        if (Lists.isEmpty(r18.getUrls()) == true) goto L74;
        this.c.setVisibility(0);
        ImageLoader.bindImageWithAnimation(this.c, r18, new sa1.e(this), r18.isAnimated());
        goto L75
    L67:
        U3(r17.width, r17.height);
        goto L68
    L53:
        if (Lists.isEmpty(r16.getUrls()) == true) goto L61;
        ImageModel r24 = r16;
        ImageLoader.d r25 = ImageLoader.load(r24);
        r25.g = true;
        r25.f = false;
        r25.a(this.b);
        if (b4.a() == false) goto L68;
        d r26 = new d(this, r24);
        ViewGroup r27 = this.s;
        if (r27 == null) goto L60;
        r27.addOnLayoutChangeListener(r26);
    L60:
        Unit r28 = Unit.INSTANCE;
        this.r = r26;
        goto L68
    L25:
        if (r4 == null) goto L27;
        this.a.setText(r4.getRealNickName());
        goto L38
    L27:
        this.a.setText("");
        goto L38
    L28:
        TextView r29 = this.a;
        if (r4 == null) goto L33;
        String r30 = r4.getRealNickName();
        if (r30 == null) goto L33;
        r8 = r30;
    L33:
        r29.setText(r8);
        goto L38
    L18:
        if (((ng2.b) r6.getValue()).showChallenge == false) goto L20;
        r7 = true;
        goto L21
    L34:
        if (r5 == null) goto L36;
        this.a.setText(FormatUtils.format("%s#%s", new Object[]{r12.getTitle(), r5.name}));
        goto L38
    L36:
        this.a.setText(r12.getTitle());
        goto L38
    }

    public final void U3(int r3, int r4) {
        if (this.q == false) goto L5;
        int r0 = u;
    L6:
        t = r0;
        if (r0 > 0) goto L10;
        t = (this.s.getMeasuredWidth() - 3) / 2;
    L10:
        if (this.q == false) goto L12;
        u = t;
    L13:
        if (r3 <= 0) goto L17;
        if (r4 <= 0) goto L17;
        int r1 = (t * r4) / r3;
    L18:
        ViewGroup.LayoutParams r5 = this.b.getLayoutParams();
        int r6 = r5.width;
        int r2 = t;
        if (r6 == r2) goto L21;
    L23:
        r5.width = r2;
        r5.height = r1;
        this.b.setLayoutParams(r5);
        return;
    L21:
        if (r5.height != r1) goto L23;
        return;
    L17:
        r1 = t;
        goto L18
    L12:
        v = t;
        goto L13
    L5:
        r0 = v;
        goto L6
    }

    public final /* bridge */ /* synthetic */ void bind(Object r1, int r2) {
        T3((Room) r1, r2);
    }
}
