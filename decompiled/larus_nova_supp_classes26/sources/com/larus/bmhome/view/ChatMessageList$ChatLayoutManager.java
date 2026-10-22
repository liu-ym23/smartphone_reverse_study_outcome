package com.larus.bmhome.view;

import android.content.Context;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.utils.logger.FLogger;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B+\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\u0004\b\t\u0010\nJ\u0012\u0010\u0006\u001a\u00020\b2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J*\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016J\u000e\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u0017J\u0010\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0018\u0010\u0019\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u0017H\u0016J$\u0010\u001b\u001a\u00020\b2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0016\u001a\u00020\u0017H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u001c"}, d2 = {"Lcom/larus/bmhome/view/ChatMessageList$ChatLayoutManager;", "Landroidx/recyclerview/widget/LinearLayoutManager;", "context", "Landroid/content/Context;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "onLayoutCompleted", "Lkotlin/Function0;", "", "<init>", "(Landroid/content/Context;Landroidx/recyclerview/widget/RecyclerView;Lkotlin/jvm/functions/Function0;)V", "getOnLayoutCompleted", "()Lkotlin/jvm/functions/Function0;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "onRequestChildFocus", "", "parent", "child", "Landroid/view/View;", "focused", "scrollPositionItemToEnd", "position", "", "scrollToPosition", "scrollToPositionWithOffset", "offset", "smoothScrollToPosition", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ChatMessageList$ChatLayoutManager extends LinearLayoutManager {
    public final RecyclerView a;
    public final Function0<Unit> b;

    public final boolean onRequestChildFocus(RecyclerView r1, RecyclerView.State r2, View r3, View r4) {
        Intrinsics.checkNotNullParameter(r1, "parent");
        Intrinsics.checkNotNullParameter(r2, "state");
        Intrinsics.checkNotNullParameter(r3, "child");
        return true;
    }

    public final void onLayoutCompleted(RecyclerView.State r1) {
        super.onLayoutCompleted(r1);
        Function0<Unit> r2 = this.b;
        if (r2 == null) goto L6;
        r2.invoke();
        return;
    }

    public final void scrollToPosition(int r4) {
        if (r4 != 0) goto L7;
        Lazy r0 = ChatMessageList.V0;
        if (ChatMessageList.b.a() == false) goto L7;
        FLogger.a.i("ChatMessageList", "prevent scroll to latest");
        return;
    L7:
        ChatMessageList r1 = this.a;
        if ((r1 instanceof ChatMessageList) == false) goto L10;
        ChatMessageList r2 = r1;
    L11:
        if (r2 == null) goto L13;
        Lazy r3 = ChatMessageList.V0;
        r2.W("scrollToPosition", r4, null);
    L13:
        super.scrollToPosition(r4);
        return;
    L10:
        r2 = null;
        goto L11
    }

    public final void scrollToPositionWithOffset(int r4, int r5) {
        if (r4 != 0) goto L7;
        Lazy r0 = ChatMessageList.V0;
        if (ChatMessageList.b.a() == false) goto L7;
        FLogger.a.i("ChatMessageList", "prevent scroll to latest");
        return;
    L7:
        ChatMessageList r1 = this.a;
        if ((r1 instanceof ChatMessageList) == false) goto L10;
        ChatMessageList r2 = r1;
    L11:
        if (r2 == null) goto L13;
        Integer r3 = Integer.valueOf(r5);
        Lazy r6 = ChatMessageList.V0;
        r2.W("scrollToPositionWithOffset", r4, r3);
    L13:
        super.scrollToPositionWithOffset(r4, r5);
        return;
    L10:
        r2 = null;
        goto L11
    }

    public ChatMessageList$ChatLayoutManager(Context r2, ChatMessageList r3, com.larus.bmhome.chat.component.list.k r4) {
        Intrinsics.checkNotNullParameter(r3, "recyclerView");
        super(r2, 1, true);
        this.a = r3;
        this.b = r4;
    }

    public final void smoothScrollToPosition(RecyclerView r2, RecyclerView.State r3, int r4) {
        if (r4 != 0) goto L7;
        Lazy r0 = ChatMessageList.V0;
        if (ChatMessageList.b.a() == false) goto L7;
        FLogger.a.i("ChatMessageList", "prevent scroll to latest");
        return;
    L7:
        super.smoothScrollToPosition(r2, r3, r4);
    }
}
