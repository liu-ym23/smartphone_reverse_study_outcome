package com.bytedance.android.livesdk.drawer.history;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.base.model.follow.ScheduledLiveItem;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import java.util.LinkedHashMap;
import java.util.Objects;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class c extends me.drakeet.multitype.b<ScheduledLiveItem, HistoryViewHolder> {
    public final e b;
    public final boolean c;

    public final void f(RecyclerView.ViewHolder r2) {
        Intrinsics.checkNotNullParameter((HistoryViewHolder) r2, "holder");
    }

    public c(e r1, boolean r2) {
        this.b = r1;
        this.c = r2;
    }

    public final void b(RecyclerView.ViewHolder r7, Object r8) {
        HistoryViewHolder r9 = (HistoryViewHolder) r7;
        ScheduledLiveItem r10 = (ScheduledLiveItem) r8;
        Intrinsics.checkNotNullParameter(r9, "holder");
        Intrinsics.checkNotNullParameter(r10, "item");
        r9.getClass();
        Intrinsics.checkNotNullParameter(r10, "item");
        ImageUtil.loadRoundImage(r9.a, r10.getAvatar());
        r9.d.setText(r10.getNickName());
        boolean r1 = true;
        if (r10.getRoom() == null) goto L23;
        Room r0 = r10.getRoom();
        if (r0 == null) goto L41;
        com.bytedance.android.live.core.view.a r3 = r9.f;
        r3.getClass();
        r3.c = true;
        com.bytedance.android.live.core.view.a r2 = r9.f;
        r2.c(0);
        r2.d();
        r9.c.setVisibility(0);
        r9.b.setVisibility(0);
        Intrinsics.checkNotNullParameter(r0, "room");
        LinkedHashMap r4 = new LinkedHashMap();
        User r5 = r0.getOwner();
        String r6 = "";
        if (r5 == null) goto L10;
        String r11 = r5.getIdString();
        if (r11 == null) goto L10;
    L11:
        r4.put("anchor_id", r11);
        String r12 = r0.getIdStr();
        if (r12 != null) goto L14;
        r12 = "";
    L14:
        r4.put("room_id", r12);
        r4.put("enter_from_merge", "drawer_hot");
        r4.put("enter_method", "live_history");
        r4.put("action_type", "click");
        String r13 = r0.getRequestId();
        if (r13 != null) goto L18;
        r13 = "";
    L18:
        r4.put("request_id", r13);
        String r14 = r0.getLog_pb();
        if (r14 == null) goto L22;
        r6 = r14;
    L22:
        r4.put("log_pb", r6);
        u.l().sendLog("livesdk_live_show", r4, new Object[0]);
        r9.e.setText(r0.getTitle());
    L10:
        r11 = "";
    L41:
        r9.h.setOnClickListener(new d(r9, r10));
        return;
    L23:
        com.bytedance.android.live.core.view.a r15 = r9.f;
        r15.getClass();
        r15.c = false;
        com.bytedance.android.live.core.view.a r16 = r9.f;
        r16.a();
        r16.c(8);
        r9.c.setVisibility(8);
        r9.b.setVisibility(8);
        r10.getNickName();
        r9.b.getVisibility();
        Objects.toString(r9.f);
        StringBuilder r17 = new StringBuilder();
        String r18 = r10.getScheduledText();
        if (r18 != null) goto L26;
    L29:
        boolean r19 = true;
    L30:
        if (r19 == true) goto L32;
        r17.append(r10.getScheduledText() + '\n');
    L32:
        String r20 = r10.getAnnouncementContent();
        if (r20 != null) goto L35;
    L38:
        if (r1 == true) goto L40;
        r17.append(r10.getAnnouncementContent());
    L40:
        r9.e.setText(r17);
        goto L41
    L35:
        if (r20.length() == 0) goto L38;
        r1 = false;
        goto L38
    L26:
        if (r18.length() == 0) goto L29;
        r19 = false;
        goto L30
    }

    public final RecyclerView.ViewHolder d(LayoutInflater r4, ViewGroup r5) {
        Intrinsics.checkNotNullParameter(r4, "inflater");
        Intrinsics.checkNotNullParameter(r5, "parent");
        return new HistoryViewHolder(r4.inflate(2131566162, r5, false), r5.getContext(), this.b, this.c);
    }
}
