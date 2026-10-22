package q21;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.android.live.revlink.impl.multianchor.dialog.viewholder.AnchorLinkExpandViewHolder;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.scope.m;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import mz0.n;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a extends me.drakeet.multitype.b<C0297a, AnchorLinkExpandViewHolder> {
    public final AnchorLinkExpandViewHolder.b b;
    public final boolean c;

    /* JADX INFO: renamed from: q21.a$a, reason: collision with other inner class name */
    public static final class C0297a {
        public String a;
        public boolean b;
        public boolean c;

        public C0297a() {
        }
    }

    public a(AnchorLinkExpandViewHolder.b r2) {
        Intrinsics.checkNotNullParameter(r2, "listenr");
        this.b = r2;
        this.c = true;
    }

    public final void b(RecyclerView.ViewHolder r4, Object r5) {
        AnchorLinkExpandViewHolder r6 = (AnchorLinkExpandViewHolder) r4;
        C0297a r7 = (C0297a) r5;
        Intrinsics.checkNotNullParameter(r6, "holder");
        Intrinsics.checkNotNullParameter(r7, "item");
        String r0 = r7.a;
        boolean r1 = r7.b;
        boolean r8 = r7.c;
        r6.a.setText(r0);
        if (r1 == false) goto L5;
        r6.b.setRotationX(180.0f);
    L6:
        if (r8 == false) goto L12;
        HashMap r9 = new HashMap();
        r9.put("source", "link_banner");
        r9.put("anchor_connect_status", DataType.FALSE);
        r9.put("room_status", "live");
        if (com.bytedance.android.live.revenue.core.util.e.a(com.bytedance.android.livesdk.revenue.service.room.b.class).getRoom() == null) goto L10;
        IRoom r10 = com.bytedance.android.live.revenue.core.util.e.a(com.bytedance.android.livesdk.revenue.service.room.b.class).getRoom();
        Intrinsics.checkNotNull(r10);
        String r2 = r10.getAnchorId();
        Intrinsics.checkNotNull(r2);
        r9.put("anchor_id", r2);
        r9.put("room_id", String.valueOf(r10.getRoomId()));
    L10:
        n r12 = new n();
        Map<String, String> r3 = r12.a;
        Intrinsics.checkNotNullParameter(r3, "map");
        Intrinsics.checkNotNullParameter(r9, "map");
        r3.putAll(r9);
        cy0.e.a.getClass();
        cy0.j r13 = cy0.e.a.a;
        m.e.getClass();
        Object r14 = m.b(r13).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r14);
        ((mz0.i) ((f80.a) r14)).w3("livesdk_pk_more_mutual_show", r12.a, r12.b);
        return;
    L12:
        return;
    L5:
        r6.b.setRotationX(0.0f);
        goto L6
    }

    public final RecyclerView.ViewHolder d(LayoutInflater r4, ViewGroup r5) {
        Intrinsics.checkNotNullParameter(r4, "inflater");
        Intrinsics.checkNotNullParameter(r5, "parent");
        return new AnchorLinkExpandViewHolder(r4.inflate(2131566226, r5, false), this.b, this.c);
    }
}
