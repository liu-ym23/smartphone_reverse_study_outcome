package com.larus.bmhome.view;

import android.view.View;
import android.view.ViewTreeObserver;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.utils.logger.FLogger;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class ChatMessageList$g implements ViewTreeObserver.OnPreDrawListener {
    public final /* synthetic */ ChatMessageList a;
    public final /* synthetic */ int b;

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public final boolean onPreDraw() {
        ChatMessageList$ChatLayoutManager r0 = this.a.getLayoutManager();
        ChatMessageList$ChatLayoutManager r2 = null;
        if ((r0 instanceof ChatMessageList$ChatLayoutManager) == false) goto L5;
        ChatMessageList$ChatLayoutManager r1 = r0;
    L6:
        if (r1 == null) goto L8;
        Integer r3 = Integer.valueOf(r1.findFirstVisibleItemPosition());
    L9:
        ChatMessageList$ChatLayoutManager r4 = this.a.getLayoutManager();
        if ((r4 instanceof ChatMessageList$ChatLayoutManager) == false) goto L12;
        ChatMessageList$ChatLayoutManager r5 = r4;
    L13:
        if (r5 == null) goto L15;
        Integer r6 = Integer.valueOf(r5.findLastVisibleItemPosition());
    L16:
        ChatMessageList$ChatLayoutManager r7 = this.a.getLayoutManager();
        if ((r7 instanceof ChatMessageList$ChatLayoutManager) == false) goto L19;
        ChatMessageList$ChatLayoutManager r8 = r7;
    L20:
        if (r8 == null) goto L22;
        Integer r9 = Integer.valueOf(r8.findLastCompletelyVisibleItemPosition());
    L23:
        ChatMessageList$ChatLayoutManager r10 = this.a.getLayoutManager();
        if ((r10 instanceof ChatMessageList$ChatLayoutManager) == false) goto L26;
        ChatMessageList$ChatLayoutManager r11 = r10;
    L28:
        if (r11 == null) goto L40;
        View r12 = r11.findViewByPosition(this.b);
        if (r12 == null) goto L40;
        ChatMessageList r13 = this.a;
        int r14 = this.b;
        int r15 = r13.getHeight() - r12.getHeight();
        if (r14 != 0) goto L34;
        int r16 = i5.h();
    L35:
        int r17 = r15 - r16;
        FLogger.a.d("ChatMessageList", "scrollToTargetMsgByPos onPreDraw pos=" + r14 + " off=" + r17 + " firstVisiblePos=" + r3 + " lastVisiblePos=" + r6 + " lastCompletablePos=" + r9);
        RecyclerView.LayoutManager r18 = r13.getLayoutManager();
        if ((r18 instanceof ChatMessageList$ChatLayoutManager) == false) goto L38;
        r2 = (ChatMessageList$ChatLayoutManager) r18;
    L38:
        if (r2 == null) goto L40;
        r2.scrollToPositionWithOffset(r14, r17);
        goto L40
    L34:
        r16 = 0;
    L40:
        this.a.getViewTreeObserver().removeOnPreDrawListener(this);
        return false;
    L26:
        r11 = null;
        goto L28
    L22:
        r9 = null;
        goto L23
    L19:
        r8 = null;
        goto L20
    L15:
        r6 = null;
        goto L16
    L12:
        r5 = null;
        goto L13
    L8:
        r3 = null;
        goto L9
    L5:
        r1 = null;
        goto L6
    }

    public ChatMessageList$g(ChatMessageList r1, int r2) {
        this.a = r1;
        this.b = r2;
    }
}
