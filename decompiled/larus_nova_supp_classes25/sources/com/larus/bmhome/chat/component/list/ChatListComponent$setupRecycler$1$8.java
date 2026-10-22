package com.larus.bmhome.chat.component.list;

import android.graphics.Rect;
import android.view.View;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.databinding.LarusPageChatBinding;
import com.larus.bmhome.view.ChatMessageList;
import com.larus.im.bean.message.Message;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J \u0010\u000e\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\rH\u0016R\u001b\u0010\u0002\u001a\u00020\u00038BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0011"}, d2 = {"com/larus/bmhome/chat/component/list/ChatListComponent$setupRecycler$1$8", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "boostDur", "", "getBoostDur", "()J", "boostDur$delegate", "Lkotlin/Lazy;", "onScrollStateChanged", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "newState", "", "onScrolled", "dx", "dy", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class ChatListComponent$setupRecycler$1$8 extends RecyclerView.OnScrollListener {
    public final Lazy a;
    public final /* synthetic */ ChatListComponent b;
    public final /* synthetic */ LarusPageChatBinding c;

    public ChatListComponent$setupRecycler$1$8(ChatListComponent r1, LarusPageChatBinding r2) {
        this.b = r1;
        this.c = r2;
        this.a = LazyKt.lazy(new p6());
    }

    public final void onScrollStateChanged(RecyclerView r7, int r8) {
        Intrinsics.checkNotNullParameter(r7, "recyclerView");
        super.onScrollStateChanged(r7, r8);
        ChatListComponent r0 = this.b;
        int r1 = ChatListComponent.W3;
        r0.v4().C(r7, r8);
        if (r8 == 0) goto L7;
        if (r8 != 1) goto L8;
        this.b.X3("user_dragging");
    L8:
        if (r8 == 1) goto L10;
    L14:
        if (r8 != 0) goto L20;
        LarusPageChatBinding r9 = this.b.h4();
        if (r9 == null) goto L20;
        ChatMessageList r10 = r9.n;
        if (r10 == null) goto L20;
        final ChatListComponent r2 = this.b;
        r10.post(new o6(r2));
    L20:
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this.b), null, null, new ChatListComponent$setupRecycler$1$8$onScrollStateChanged$2(this.b, r8, null), 3, null);
        return;
    L10:
        if (((Number) this.a.getValue()).longValue() <= 0) goto L14;
        com.larus.platform.api.m0 r11 = (com.larus.platform.api.m0) this.b.q3.getValue();
        if (r11 == null) goto L14;
        r11.c(((Number) this.a.getValue()).longValue());
        goto L14
    L7:
        this.b.X3("scroll_idle");
        goto L8
    }

    public final void onScrolled(RecyclerView r9, int r10, int r11) {
        Intrinsics.checkNotNullParameter(r9, "recyclerView");
        super.onScrolled(r9, r10, r11);
        ChatListComponent r0 = this.b;
        int r1 = ChatListComponent.W3;
        r0.v4().u(r9, r10, r11);
        LinearLayoutManager r12 = this.c.n.getLayoutManager();
        if ((r12 instanceof LinearLayoutManager) == false) goto L5;
        LinearLayoutManager r13 = r12;
    L6:
        if (r13 != null) goto L8;
        return;
    L8:
        boolean r2 = true;
        int r3 = 0;
        if (r9.getHeight() > 0) goto L11;
    L13:
        boolean r4 = false;
    L14:
        if (r4 == false) goto L60;
        View r5 = r13.getChildAt(0);
        if (r5 == null) goto L18;
        ChatListComponent r6 = this.b;
        int r14 = r13.getPosition(r5);
        Rect r7 = new Rect();
        r5.getLocalVisibleRect(r7);
        r6.Q = new Pair(Integer.valueOf(r14), Integer.valueOf(r7.bottom - r5.getHeight()));
    L18:
        if (r11 == 0) goto L60;
        this.b.c4("list_scroll");
        this.b.g7();
        ChatListComponent r15 = this.b;
        if (r15.F6() == true) goto L22;
    L26:
        r2 = false;
    L27:
        if (r2 == true) goto L60;
        ChatListComponent r16 = this.b;
        if (r16.F6() == false) goto L60;
        List r17 = r16.getCurrentList();
        if (r17 == null) goto L60;
        Map<String, com.larus.bmhome.chat.manager.d0> r8 = com.larus.bmhome.chat.manager.e0.a;
        com.larus.bmhome.chat.manager.d0 r18 = com.larus.bmhome.chat.manager.e0.a(r16.G4());
        if (r18 == null) goto L60;
        Iterator r19 = r17.iterator();
    L39:
        if (r19.hasNext() == false) goto L48;
        String r20 = ((Message) r19.next()).getLocalMessageId();
        Message r21 = r18.a;
        if (r21 == null) goto L43;
        String r22 = r21.getLocalMessageId();
    L45:
        if (Intrinsics.areEqual(r20, r22) == true) goto L49;
        r3 = r3 + 1;
    L49:
        if (r3 < 0) goto L60;
        int r110 = r18.b;
        if (r110 <= 0) goto L60;
        ChatMessageList r23 = r16.o5();
        if (r23 == null) goto L60;
        if (r23.M(r3, r110, r16.k70()) == false) goto L60;
        r16.Z3("list_scroll_group_read");
        goto L60
    L43:
        r22 = null;
        goto L45
    L48:
        r3 = -1;
        goto L49
    L22:
        if (r15.S3 == false) goto L26;
        if (r15.j6() == false) goto L26;
    L60:
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this.b), null, null, new ChatListComponent$setupRecycler$1$8$onScrolled$2(this.b, r9, null), 3, null);
        return;
    L11:
        if (Intrinsics.areEqual(r9.getTag(2131365551), Boolean.TRUE) == true) goto L13;
        r4 = true;
        goto L14
    L5:
        r13 = null;
        goto L6
    }
}
