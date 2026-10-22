package com.bytedance.android.live.revlink.impl.pk.dialog.viewholder;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/pk/dialog/viewholder/PKTitleViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/bytedance/android/live/revlink/impl/pk/ui/j;", "a", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class PKTitleViewHolder extends RecyclerView.ViewHolder implements com.bytedance.android.live.revlink.impl.pk.ui.j {
    public final View a;
    public String b;
    public boolean c;
    public y31.s.a d;
    public final boolean e;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.live.revlink.impl.pk.ui.j
    public final String G() {
        return this.b;
    }

    @Override // com.bytedance.android.live.revlink.impl.pk.ui.j
    public final void N(String r6) {
        Intrinsics.checkNotNullParameter(r6, "panelType");
        if (this.c == false) goto L13;
        yz0.k r7 = (yz0.k) com.bytedance.android.live.revenue.core.util.f.d(com.bytedance.android.live.revenue.core.util.j.C0.a(), yz0.k.class);
        if (r7 == null) goto L11;
        IRoom r8 = r7.getRoom();
        if (r8 == null) goto L11;
        IBaseUser r9 = r8.getOwner();
        if (r9 == null) goto L11;
        String r10 = iz.a.a(r9);
    L12:
        com.bytedance.tools.kcp.spongepreference.runtime.a r1 = l51.a.a0;
        KProperty[] r2 = l51.a.a;
        HashSet r4 = (HashSet) r1.getValue(null, r2[60]);
        r4.add(String.valueOf(r10));
        Intrinsics.checkNotNullParameter(r4, "<set-?>");
        r1.setValue(null, r2[60], r4);
    L11:
        r10 = null;
    L13:
        y31.s.a r12 = this.d;
        if (r12 != null) goto L16;
        return;
    L16:
        if (r12.d != true) goto L31;
        HashMap r13 = new HashMap();
        y31.s.a r0 = this.d;
        if (r0 != null) goto L20;
    L22:
        String r3 = "recommend_similar";
    L23:
        r13.put("control_type", r3);
        y31.s.a r5 = this.d;
        if (r5 == null) goto L27;
        String r14 = r5.f;
        if (r14 == null) goto L27;
    L28:
        r13.put("request_id", r14);
        mz0.n r15 = new mz0.n();
        Map<String, String> r16 = r15.a;
        Intrinsics.checkNotNullParameter(r16, "map");
        Intrinsics.checkNotNullParameter(r13, "map");
        r16.putAll(r13);
        mz0.m r17 = new mz0.m();
        r17.b(LogCommon.ROOM);
        ((ArrayList) r15.b).addAll(r17.a);
        cy0.e.a.getClass();
        cy0.j r18 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r19 = com.bytedance.android.scope.m.b(r18).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r19);
        ((mz0.i) ((f80.a) r19)).w3("livesdk_anchor_screen_control_show", r15.a, r15.b);
        return;
    L27:
        r14 = "";
        goto L28
    L20:
        if (r0.e != 0) goto L22;
        r3 = "recommend";
        goto L23
    }

    public PKTitleViewHolder(View r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "itemView");
        super(r2);
        this.e = r3;
        this.a = r2;
        this.b = "";
    }
}
