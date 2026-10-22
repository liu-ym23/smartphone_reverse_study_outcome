package com.bytedance.android.live.revlink.impl.pk.dialog.viewholder;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.android.livesdk.link.model.o3;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/pk/dialog/viewholder/PkReserveViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/bytedance/android/live/revlink/impl/pk/ui/j;", "a", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class PkReserveViewHolder extends RecyclerView.ViewHolder implements com.bytedance.android.live.revlink.impl.pk.ui.j {
    public static final /* synthetic */ int b = 0;
    public y31.t.a a;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.live.revlink.impl.pk.ui.j
    public final String G() {
        return "";
    }

    @Override // com.bytedance.android.live.revlink.impl.pk.ui.j
    public final void N(String r2) {
        Intrinsics.checkNotNullParameter(r2, "panelType");
    }

    public PkReserveViewHolder(View r2) {
        Intrinsics.checkNotNullParameter(r2, "view");
        super(r2);
    }

    public static final void T3(PkReserveViewHolder r5, int r6) {
        r5.getClass();
        LinkedHashMap r0 = new LinkedHashMap();
        y31.t.a r1 = r5.a;
        if (r1 != null) goto L5;
    L7:
        String r2 = "invited";
    L8:
        r0.put("tab", r2);
        String r3 = "";
        r0.put("channel_id", "");
        String r4 = DataType.FALSE;
        r0.put("pk_id", DataType.FALSE);
        r0.put("anchor_connect_status", DataType.FALSE);
        y31.t.a r7 = r5.a;
        if (r7 == null) goto L15;
        o3 r8 = r7.e;
        if (r8 == null) goto L15;
        if (r8.getButtonStatus() != 1) goto L15;
        r4 = DataType.TRUE;
    L15:
        r0.put("right_user_status", r4);
        y31.t.a r9 = r5.a;
        if (r9 == null) goto L21;
        IBaseUser r10 = r9.a;
        if (r10 == null) goto L21;
        String r12 = r10.getUserId();
        if (r12 == null) goto L21;
    L22:
        r0.put("right_user_id", r12);
        y31.t.a r13 = r5.a;
        if (r13 == null) goto L30;
        IRoom r14 = r13.b;
        if (r14 == null) goto L30;
        String r15 = String.valueOf(r14.getRoomId());
        if (r15 == null) goto L30;
        r3 = r15;
    L30:
        r0.put("right_room_id", r3);
        if (r6 != 0) goto L33;
        String r16 = "reply";
    L34:
        r0.put("btn_type", r16);
        mz0.n r17 = new mz0.n();
        Map<String, String> r18 = r17.a;
        Intrinsics.checkNotNullParameter(r18, "map");
        Intrinsics.checkNotNullParameter(r0, "map");
        r18.putAll(r0);
        mz0.m r19 = new mz0.m();
        r19.b(LogCommon.ROOM);
        List<Object> r20 = r17.b;
        ArrayList r22 = (ArrayList) r20;
        r22.addAll(r19.a);
        cy0.e.a.getClass();
        cy0.j r23 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r24 = com.bytedance.android.scope.m.b(r23).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r24);
        ((mz0.i) ((f80.a) r24)).w3("livesdk_pk_invite_record_page_click", r17.a, r17.b);
        return;
    L33:
        r16 = "pk_invite";
    L21:
        r12 = "";
        goto L22
    L5:
        if (r1.h != 0) goto L7;
        r2 = "invite";
        goto L8
    }
}
