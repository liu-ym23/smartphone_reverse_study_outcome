package com.bytedance.android.live.livepkaudience.list;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001\bR\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/bytedance/android/live/livepkaudience/list/PkGuestViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "", "t", "I", "getType", "()I", "type", "a", "livepkaudience-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PkGuestViewHolder extends RecyclerView.ViewHolder {
    public final int a;
    public final ImageView b;
    public final HSImageView c;
    public final TextView d;
    public final LinearLayout e;
    public final TextView f;
    public final TextView g;
    public final ImageView h;
    public final TextView i;
    public final ImageView j;
    public final View k;
    public final LinearLayout l;
    public final TextView m;
    public String n;
    public final LinearLayout o;
    public final TextView p;
    public final View q;
    public final TextView r;
    public final boolean s;
    public final int t;
    public final xk0.c u;
    public final Map<dl0.c, View> v;

    public static final class a {
    }

    static {
    }

    public final int getType() {
        return this.t;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public PkGuestViewHolder(View r3, int r4, xk0.c r5, Map<dl0.c, ? extends View> r6) {
        Intrinsics.checkNotNullParameter(r3, "view");
        Intrinsics.checkNotNullParameter(r6, "badgeTypeMap");
        super(r3);
        this.t = r4;
        this.u = r5;
        this.v = r6;
        this.a = 100;
        this.b = (ImageView) ((RecyclerView.ViewHolder) this).itemView.findViewById(2131375994);
        TextView r7 = (TextView) ((RecyclerView.ViewHolder) this).itemView.findViewById(2131390402);
        this.c = ((RecyclerView.ViewHolder) this).itemView.findViewById(2131376286);
        this.d = (TextView) ((RecyclerView.ViewHolder) this).itemView.findViewById(2131390975);
        this.e = (LinearLayout) ((RecyclerView.ViewHolder) this).itemView.findViewById(2131380597);
        this.f = (TextView) ((RecyclerView.ViewHolder) this).itemView.findViewById(2131391589);
        this.g = (TextView) ((RecyclerView.ViewHolder) this).itemView.findViewById(2131364615);
        this.h = (ImageView) ((RecyclerView.ViewHolder) this).itemView.findViewById(2131376272);
        this.i = (TextView) ((RecyclerView.ViewHolder) this).itemView.findViewById(2131390517);
        this.j = (ImageView) ((RecyclerView.ViewHolder) this).itemView.findViewById(2131376380);
        this.k = ((RecyclerView.ViewHolder) this).itemView.findViewById(2131373607);
        this.l = (LinearLayout) ((RecyclerView.ViewHolder) this).itemView.findViewById(2131381730);
        this.m = (TextView) ((RecyclerView.ViewHolder) this).itemView.findViewById(2131391017);
        this.n = "null";
        this.o = (LinearLayout) ((RecyclerView.ViewHolder) this).itemView.findViewById(2131377082);
        this.p = (TextView) ((RecyclerView.ViewHolder) this).itemView.findViewById(2131391487);
        this.q = ((RecyclerView.ViewHolder) this).itemView.findViewById(2131376713);
        this.r = (TextView) ((RecyclerView.ViewHolder) this).itemView.findViewById(2131391488);
        RoomContext.a r8 = RoomContext.Companion;
        RoomContext r1 = RoomContext.a.c(r8, null, 0, 3);
        if (r1 == null) goto L9;
        com.bytedance.live.datacontext.i r2 = r1.isAnchor();
        if (r2 == null) goto L9;
        Boolean r9 = (Boolean) r2.getValue();
        if (r9 == null) goto L9;
        boolean r10 = r9.booleanValue();
    L10:
        this.s = r10;
        RoomContext r11 = RoomContext.a.c(r8, null, 0, 3);
        if (r11 == null) goto L16;
        com.bytedance.live.datacontext.m r12 = r11.getRoom();
        if (r12 == null) goto L17;
        Room r13 = (Room) r12.getValue();
        return;
    L17:
        return;
    L16:
        return;
    L9:
        r10 = false;
        goto L10
    }
}
