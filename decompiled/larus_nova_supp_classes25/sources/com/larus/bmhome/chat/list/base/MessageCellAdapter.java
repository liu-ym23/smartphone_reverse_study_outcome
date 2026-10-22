package com.larus.bmhome.chat.list.base;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.cell.view.AbstractMessageBoxContainerView;
import com.larus.bmhome.chat.cell.view.MessageFullBoxContainerView;
import com.larus.bmhome.chat.cell.view.MessageInboxContainerView;
import com.larus.bmhome.chat.cell.view.MessageNoBoxContainerView;
import com.larus.bmhome.chat.cell.view.MessageOutboxContainerView;
import com.larus.bmhome.chat.layout.item.i;
import com.larus.bmhome.chat.layout.item.t;
import com.larus.list.arch.FlowListAdapter;
import com.larus.list.arch.FlowListViewHolder;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import gd8.d;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import mf8.a;
import mf8.c;
import xc8.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\"\u0010\u0006\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH\u0016J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u000bH\u0002¨\u0006\u0012"}, d2 = {"Lcom/larus/bmhome/chat/list/base/MessageCellAdapter;", "STATE", "Lcom/larus/bmhome/chat/cell/BaseMessageCellState;", "Lcom/larus/list/arch/FlowListAdapter;", "<init>", "()V", "getParentViewHolder", "Lcom/larus/list/arch/FlowListViewHolder;", "context", "Landroid/content/Context;", "cellView", "Landroid/view/View;", "getItemViewType", "", "position", "tryProcessMargin", "", "view", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public abstract class MessageCellAdapter<STATE extends b> extends FlowListAdapter<STATE> {
    public MessageCellAdapter() {
    }

    public final int getItemViewType(int r5) {
        List r0 = z2();
        boolean r2 = false;
        if (r5 >= 0) goto L5;
    L7:
        if (r2 == true) goto L10;
        return -1;
    L10:
        int r1 = ((b) ListProtector.get(r0, r5)).e();
        return (super.getItemViewType(r5) + r1) + 1;
    L5:
        if (r5 >= r0.size()) goto L7;
        r2 = true;
        goto L7
    }

    public final FlowListViewHolder<STATE> A2(final Context r10, View r11) {
        Intrinsics.checkNotNullParameter(r10, "context");
        AbstractMessageBoxContainerView r1 = null;
        if (r11 != null) goto L5;
        return null;
    L5:
        boolean r2 = r11 instanceof i;
        if (r2 == false) goto L26;
        i r6 = (i) r11;
        if (r6.getBoxType() != 1) goto L26;
        int r3 = c.a;
        Intrinsics.checkNotNullParameter(r10, "context");
    L20:
        th = move-exception;
        FLogger.a.e("MessageNitaViewHelper", "generateMessageOutboxContainerView. msg=" + th.getMessage());
    L22:
        MessageOutboxContainerView r0 = null;
    L23:
        if (r0 != null) goto L25;
        r0 = new MessageOutboxContainerView(r10, null);
    L25:
        r0.V5(((FlowListAdapter) this).d, r6);
    L50:
        if ((r0 instanceof AbstractMessageBoxContainerView) == false) goto L52;
        r1 = (AbstractMessageBoxContainerView) r0;
    L52:
        if (r1 == null) goto L54;
        r1.setNeedTopMargin(true);
    L54:
        if (r1 == null) goto L57;
        r1.setNeedBottomMargin(true);
    L57:
        if ((r11 instanceof t) == false) goto L63;
        Pair<Boolean, Boolean> r12 = ((t) r11).getItemSpace();
        if (r1 == null) goto L61;
        r1.setNeedTopMargin(((Boolean) r12.getFirst()).booleanValue());
    L61:
        if (r1 == null) goto L63;
        r1.setNeedBottomMargin(((Boolean) r12.getSecond()).booleanValue());
    L63:
        MessageCellHolder r13 = new MessageCellHolder(r0);
        ((FlowListViewHolder) r13).a = ((FlowListAdapter) this).a;
        return r13;
    L11:
        if (z2.a.enablePreloadChatPageView().b() == false) goto L22;
        o37.c.e.getClass();     // Catch: Throwable -> L20
        if (o37.c.f("chat_holder_nita") == false) goto L22;
        if ((r10 instanceof Activity) == false) goto L22;
        final d r4 = o37.c.e("chat_holder_nita");     // Catch: Throwable -> L20
        int r5 = gd8.c.b;     // Catch: Throwable -> L20
        View r7 = (View) gd8.c.a.a("CHAT_MESSAGE_OUTBOX", new mf8.b(r4, r10));     // Catch: Throwable -> L20
        if ((r7 instanceof MessageOutboxContainerView) == false) goto L22;
        r0 = (MessageOutboxContainerView) r7;     // Catch: Throwable -> L20
    L26:
        if (r2 == false) goto L30;
        i r8 = (i) r11;
        if (r8.getBoxType() != 3) goto L30;
        r0 = new MessageFullBoxContainerView(r10, null);
        r0.V5(((FlowListAdapter) this).d, r8);
    L30:
        if (r2 == false) goto L48;
        int r9 = c.a;
        Intrinsics.checkNotNullParameter(r10, "context");
    L42:
        th = move-exception;
        FLogger.a.e("MessageNitaViewHelper", "generateMessageInboxContainerView. msg=" + th.getMessage());
    L44:
        r0 = null;
    L45:
        if (r0 != null) goto L47;
        r0 = new MessageInboxContainerView(r10, null);
    L47:
        r0.V5(((FlowListAdapter) this).d, (i) r11);
        goto L50
    L33:
        if (z2.a.enablePreloadChatPageView().b() == false) goto L44;
        o37.c.e.getClass();     // Catch: Throwable -> L42
        if (o37.c.f("chat_holder_nita") == false) goto L44;
        if ((r10 instanceof Activity) == false) goto L44;
        final d r14 = o37.c.e("chat_holder_nita");     // Catch: Throwable -> L42
        int r15 = gd8.c.b;     // Catch: Throwable -> L42
        MessageOutboxContainerView r16 = (View) gd8.c.a.a("CHAT_MESSAGE_INBOX", new a(r14, r10));     // Catch: Throwable -> L42
        if ((r16 instanceof MessageInboxContainerView) == false) goto L44;
        r0 = (MessageInboxContainerView) r16;     // Catch: Throwable -> L42
        goto L45
    L48:
        r0 = new MessageNoBoxContainerView(r10, null);
        r0.setupContainerView(r11);
        goto L50
    }

    public /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder r1, int r2) {
        B2((FlowListViewHolder) r1, r2);
    }
}
