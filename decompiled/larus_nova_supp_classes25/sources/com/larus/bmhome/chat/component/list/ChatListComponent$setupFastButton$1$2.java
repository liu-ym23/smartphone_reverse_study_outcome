package com.larus.bmhome.chat.component.list;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import by7.a;
import com.ixigua.lib.track.TrackParams;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.im.bean.bot.BotModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J \u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0007H\u0016¨\u0006\u000b"}, d2 = {"com/larus/bmhome/chat/component/list/ChatListComponent$setupFastButton$1$2", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "onScrollStateChanged", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "newState", "", "onScrolled", "dx", "dy", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class ChatListComponent$setupFastButton$1$2 extends RecyclerView.OnScrollListener {
    public final /* synthetic */ Ref.BooleanRef a;
    public final /* synthetic */ Ref.BooleanRef b;
    public final /* synthetic */ Ref.IntRef c;
    public final /* synthetic */ ChatListComponent d;

    public final void onScrollStateChanged(RecyclerView r6, int r7) {
        Intrinsics.checkNotNullParameter(r6, "recyclerView");
        int r0 = -1;
        LinearLayoutManager r1 = null;
        if (r7 == 1) goto L5;
    L14:
        if (r7 == 0) goto L16;
        return;
    L16:
        if (this.a.element == true) goto L42;
        this.b.element = false;
        LinearLayoutManager r8 = r6.getLayoutManager();
        if ((r8 instanceof LinearLayoutManager) == false) goto L20;
        LinearLayoutManager r9 = r8;
    L21:
        if (r9 == null) goto L23;
        int r10 = r9.findLastVisibleItemPosition();
    L24:
        int r11 = this.c.element;
        if (r10 <= r11) goto L43;
        if (r11 == (-1)) goto L44;
        this.a.element = true;
        a r12 = new a("swipe_chat_history");
        TrackParams r13 = new TrackParams();
        JSONObject r2 = new JSONObject();
        ChatListComponent r3 = this.d;
        r2.put("current_page", "chat");
        int r4 = ChatListComponent.W3;
        BotModel r5 = r3.j0();
        if (r5 == null) goto L30;
        String r14 = r5.getBotId();
    L31:
        r2.put("bot_id", r14);
        wc9.e r15 = r3.R4();
        if (r15 == null) goto L34;
        String r16 = ic8.n.f(r15);
    L35:
        r2.put("chat_type", r16);
        BotModel r17 = r3.j0();
        if (r17 == null) goto L38;
        r1 = r17.getBotType();
    L38:
        r2.put("bot_type", r1);
        Unit r18 = Unit.INSTANCE;
        r12.a.merge(r13.merge(r2));
        r12.b();
        return;
    L34:
        r16 = null;
        goto L35
    L30:
        r14 = null;
        goto L31
    L44:
        return;
    L43:
        return;
    L23:
        r10 = -1;
        goto L24
    L20:
        r9 = null;
        goto L21
    L42:
        return;
    L5:
        if (this.a.element == true) goto L14;
        if (this.b.element == true) goto L14;
        Ref.IntRef r19 = this.c;
        LinearLayoutManager r20 = r6.getLayoutManager();
        if ((r20 instanceof LinearLayoutManager) == false) goto L11;
        r1 = r20;
    L11:
        if (r1 == null) goto L13;
        r0 = r1.findLastVisibleItemPosition();
    L13:
        r19.element = r0;
        this.b.element = true;
    }

    public final void onScrolled(RecyclerView r2, int r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "recyclerView");
        super.onScrolled(r2, r3, r4);
        if (r4 == 0) goto L6;
        this.d.U1();
        return;
    }

    public ChatListComponent$setupFastButton$1$2(Ref.BooleanRef r1, Ref.BooleanRef r2, Ref.IntRef r3, ChatListComponent r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}
