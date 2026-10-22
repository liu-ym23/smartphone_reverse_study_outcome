package com.bytedance.android.livesdk.interactivity.publicscreen.utils;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.livesdk.chatroom.widget.LiveMessageRecyclerView;
import com.bytedance.android.livesdk.interactivity.api.entity.DisplayTimeRecorder;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.ui.MessageViewHolder;
import java.util.Iterator;
import java.util.LinkedHashSet;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class TextMessageTimeRecorder implements LiveMessageRecyclerView.c {
    public final LinkedHashSet<com.bytedance.android.livesdk.interactivity.api.entity.f<?>> a;
    public LiveMessageRecyclerView b;
    public final TextMessageTimeRecorder$visibleDetector$1 c;

    public final void a() {
    }

    /* JADX WARN: Type inference failed for: r3v5, types: [com.bytedance.android.livesdk.interactivity.api.entity.d] */
    public final void b() {
        LiveMessageRecyclerView r0 = this.b;
        if (r0 != null) goto L5;
        return;
    L5:
        RecyclerView.LayoutManager r1 = r0.getLayoutManager();
        if ((r1 instanceof LinearLayoutManager) == true) goto L8;
        r1 = null;
    L8:
        LinearLayoutManager r2 = (LinearLayoutManager) r1;
        if (r2 != null) goto L11;
        return;
    L11:
        LinkedHashSet r3 = new LinkedHashSet();
        int r4 = r2.findFirstVisibleItemPosition();
        int r5 = r2.findLastVisibleItemPosition();
        if (r4 > r5) goto L25;
    L13:
        RecyclerView.ViewHolder r6 = r0.findViewHolderForAdapterPosition(r4);
        if ((r6 instanceof MessageViewHolder) == true) goto L16;
        r6 = null;
    L16:
        MessageViewHolder r7 = (MessageViewHolder) r6;
        if (r7 == null) goto L23;
        com.bytedance.android.livesdk.interactivity.api.entity.f<?> r8 = r7.a;
        if (r8 == null) goto L23;
        if (r8.D().b() == false) goto L23;
        r3.add(r8);
    L23:
        if (r4 == r5) goto L25;
        r4 = r4 + 1;
    L25:
        Iterator r9 = r3.iterator();
    L27:
        if (r9.hasNext() == false) goto L33;
        com.bytedance.android.livesdk.interactivity.api.entity.f r10 = (com.bytedance.android.livesdk.interactivity.api.entity.f) r9.next();
        if (this.a.contains(r10) == true) goto L27;
        h80.c<DisplayTimeRecorder> r11 = r10.D();
        ?? r13 = new com.bytedance.android.livesdk.interactivity.api.entity.d();
        Object r14 = r11.a;
        if (r14 == null) goto L27;
        r13.accept(r14);
        goto L27
    L33:
        Iterator<T> r15 = this.a.iterator();
    L35:
        if (r15.hasNext() == false) goto L41;
        com.bytedance.android.livesdk.interactivity.api.entity.f r16 = (com.bytedance.android.livesdk.interactivity.api.entity.f) r15.next();
        if (r3.contains(r16) == true) goto L35;
        Object r17 = r16.D().a;
        if (r17 == null) goto L35;
        ((DisplayTimeRecorder) r17).a(com.bytedance.android.livesdk.interactivity.api.entity.g.b.a);
        goto L35
    L41:
        this.a.clear();
        this.a.addAll(r3);
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.bytedance.android.livesdk.interactivity.publicscreen.utils.TextMessageTimeRecorder$visibleDetector$1] */
    public TextMessageTimeRecorder() {
        this.a = new LinkedHashSet();
        this.c = new TextMessageTimeRecorder$visibleDetector$1(this);
    }
}
