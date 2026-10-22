package com.ss.android.lark.message.vote;

import android.text.TextUtils;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.notification.export.entity.INotificationHitPoint;
import com.ss.android.lark.statistics.Statistics;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a implements View.OnClickListener {
    public final /* synthetic */ VoteCardOptionsAdapter.ViewHolder a;
    public final /* synthetic */ irb.a b;
    public final /* synthetic */ int c;
    public final /* synthetic */ VoteCardOptionsAdapter d;

    @Override // android.view.View.OnClickListener
    public final void onClick(View r7) {
        ((RecyclerView.ViewHolder) this.a).itemView.setEnabled(false);
        irb.a r8 = this.b;
        boolean r1 = !r8.e;
        r8.e = r1;
        if (r1 == false) goto L22;
        VoteCardOptionsAdapter r9 = this.d;
        if (r9.b != 1) goto L15;
        r9.c = 1;
        int r10 = 0;
    L8:
        if (r10 >= this.d.getItems().size()) goto L23;
        if (r10 == this.c) goto L14;
        if (((irb.a) this.d.getItem(r10)).e == false) goto L14;
        ((irb.a) this.d.getItem(r10)).e = false;
    L14:
        r10 = r10 + 1;
    L23:
        int r11 = hva.a.a;
        if (this.d.b != 1) goto L26;
        boolean r12 = true;
    L27:
        irb.a r2 = this.b;
        String r3 = r2.a;
        boolean r4 = r2.e;
        Intrinsics.checkNotNullParameter(r3, "voteId");
        JSONObject r5 = new JSONObject();
        if (r4 == false) goto L30;
        String r6 = "true";
    L31:
        JSONObject r13 = r5.put("select_status", r6);
        if (r12 == false) goto L34;
        String r14 = INotificationHitPoint.ChatType.CHAT_TYPE_SINGLE;
    L35:
        Statistics.sendEvent("ex_platform_click_vote_items", r13.put("vote_type", r14).put("vote_id", r3));
        VoteCardOptionsAdapter r15 = this.d;
        VoteCardOptionsAdapter.a r16 = r15.d;
        if (r16 == null) goto L43;
        b r17 = (b) r16;
        if (r15.c > 0) goto L40;
        r17.b.setEnabled(false);
        r17.b.setText((CharSequence) ListProtector.get(r17.a.a, 1));
        r17.b.setTextColor(UIUtils.getColor(r17.c.a, 2131106620));
        goto L43
    L40:
        if (TextUtils.isEmpty(r17.a.d) == true) goto L43;
        r17.b.setEnabled(true);
        r17.b.setText((CharSequence) ListProtector.get(r17.a.a, 2));
        r17.b.setTextColor(UIUtils.getColor(r17.c.a, 2131106622));
    L43:
        trb.a r18 = this.d.g;
        if (r18 == null) goto L46;
        boolean r0 = this.b.e;
        v5b.c r19 = ((com.ss.android.lark.message.vote.message.b) r18).a;
        int r20 = urb.b.a;
        urb.b.a.a(r19.getChatId(), r19.getId(), r19.getcId(), Message.Type.CARD);
    L46:
        this.d.notifyDataSetChanged();
        return;
    L34:
        r14 = "multi";
        goto L35
    L30:
        r6 = "false";
        goto L31
    L26:
        r12 = false;
        goto L27
    L15:
        r9.c = 0;
        int r21 = 0;
    L17:
        if (r21 >= this.d.getItems().size()) goto L23;
        if (((irb.a) this.d.getItem(r21)).e == false) goto L21;
        this.d.c++;
    L21:
        r21 = r21 + 1;
        goto L17
    L22:
        VoteCardOptionsAdapter r22 = this.d;
        int r23 = r22.c - 1;
        r22.c = r23;
        r22.c = Math.max(0, r23);
        goto L23
    }

    public a(VoteCardOptionsAdapter r1, VoteCardOptionsAdapter.ViewHolder r2, irb.a r3, int r4) {
        this.d = r1;
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
