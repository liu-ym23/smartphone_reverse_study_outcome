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
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001\bR\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/bytedance/android/live/livepkaudience/list/PkControlViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "", "c", "I", "getType", "()I", "type", "a", "livepkaudience-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PkControlViewHolder extends RecyclerView.ViewHolder {
    public final ImageView a;
    public final View b;
    public final int c;
    public final xk0.c d;
    public final Map<dl0.c, View> e;

    public static final class a {
    }

    static {
    }

    public final int getType() {
        return this.c;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public PkControlViewHolder(View r3, int r4, xk0.c r5, Map<dl0.c, ? extends View> r6) {
        Intrinsics.checkNotNullParameter(r3, "view");
        Intrinsics.checkNotNullParameter(r6, "badgeTypeMap");
        super(r3);
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.a = (ImageView) ((RecyclerView.ViewHolder) this).itemView.findViewById(2131375994);
        TextView r7 = (TextView) ((RecyclerView.ViewHolder) this).itemView.findViewById(2131390402);
        HSImageView r8 = ((RecyclerView.ViewHolder) this).itemView.findViewById(2131376286);
        TextView r9 = (TextView) ((RecyclerView.ViewHolder) this).itemView.findViewById(2131390975);
        LinearLayout r10 = (LinearLayout) ((RecyclerView.ViewHolder) this).itemView.findViewById(2131380597);
        ImageView r11 = (ImageView) ((RecyclerView.ViewHolder) this).itemView.findViewById(2131376272);
        TextView r12 = (TextView) ((RecyclerView.ViewHolder) this).itemView.findViewById(2131390517);
        ImageView r13 = (ImageView) ((RecyclerView.ViewHolder) this).itemView.findViewById(2131376380);
        this.b = ((RecyclerView.ViewHolder) this).itemView.findViewById(2131373607);
        LinearLayout r14 = (LinearLayout) ((RecyclerView.ViewHolder) this).itemView.findViewById(2131381730);
        RoomContext.a r15 = RoomContext.Companion;
        RoomContext r1 = RoomContext.a.c(r15, null, 0, 3);
        if (r1 == null) goto L9;
        com.bytedance.live.datacontext.i r2 = r1.isAnchor();
        if (r2 == null) goto L9;
        Boolean r16 = (Boolean) r2.getValue();
        if (r16 == null) goto L9;
        r16.booleanValue();
    L9:
        RoomContext r17 = RoomContext.a.c(r15, null, 0, 3);
        if (r17 == null) goto L15;
        com.bytedance.live.datacontext.m r18 = r17.getRoom();
        if (r18 == null) goto L16;
        Room r19 = (Room) r18.getValue();
        return;
    L16:
        return;
    }
}
