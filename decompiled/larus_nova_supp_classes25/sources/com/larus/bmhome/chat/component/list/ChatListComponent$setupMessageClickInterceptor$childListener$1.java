package com.larus.bmhome.chat.component.list;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.view.actionbar.api.ChatUIBlockConfig;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0007"}, d2 = {"com/larus/bmhome/chat/component/list/ChatListComponent$setupMessageClickInterceptor$childListener$1", "Landroidx/recyclerview/widget/RecyclerView$OnChildAttachStateChangeListener;", "onChildViewAttachedToWindow", "", "view", "Landroid/view/View;", "onChildViewDetachedFromWindow", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class ChatListComponent$setupMessageClickInterceptor$childListener$1 implements RecyclerView.OnChildAttachStateChangeListener {
    public final /* synthetic */ ss8.g a;
    public final /* synthetic */ ChatListComponent b;
    public final /* synthetic */ int c;

    public final void onChildViewAttachedToWindow(View r6) {
        Intrinsics.checkNotNullParameter(r6, "view");
        boolean r0 = this.a.bc(ChatUIBlockConfig.DISABLE_MSG_LONG_PRESS);
        FLogger.a.d(this.b.n, "[ClickInterceptor] onChildAttached, blocked=" + r0 + ", view=" + r6.getClass().getSimpleName());
        if (r0 == false) goto L6;
        ChatListComponent.E3(this.b, this.c, r6);
        return;
    }

    public final void onChildViewDetachedFromWindow(View r3) {
        Intrinsics.checkNotNullParameter(r3, "view");
        ChatListComponent.G3(this.c, this.b, r3);
    }

    public ChatListComponent$setupMessageClickInterceptor$childListener$1(ss8.g r1, ChatListComponent r2) {
        this.a = r1;
        this.b = r2;
        this.c = 2131365588;
    }
}
