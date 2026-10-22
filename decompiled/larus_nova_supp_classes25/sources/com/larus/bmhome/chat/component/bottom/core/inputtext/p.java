package com.larus.bmhome.chat.component.bottom.core.inputtext;

import android.view.ViewTreeObserver;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.bmhome.chat.adapter.MessageAdapter;
import com.larus.bmhome.chat.component.list.u7;
import com.larus.im.bean.message.Message;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class p implements ViewTreeObserver.OnPreDrawListener {
    public final /* synthetic */ RecyclerView a;
    public final /* synthetic */ ChatInputMentionPanelController b;

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public final boolean onPreDraw() {
        if (this.a.getHeight() > 0) goto L5;
        return true;
    L5:
        ViewTreeObserver r0 = this.b.q;
        if (r0 != null) goto L8;
    L10:
        boolean r3 = false;
    L11:
        if (r3 == false) goto L13;
        r0.removeOnPreDrawListener(this);
    L13:
        ChatInputMentionPanelController r1 = this.b;
        if (r1.p == this) goto L16;
        return true;
    L16:
        Integer r4 = null;
        r1.p = null;
        r1.q = null;
        r1.o = null;
        this.a.setTag(2131365551, Boolean.FALSE);
        if (this.b.i == false) goto L19;
        return true;
    L19:
        LinearLayoutManager r2 = this.a.getLayoutManager();
        if ((r2 instanceof LinearLayoutManager) == false) goto L22;
        LinearLayoutManager r5 = r2;
    L23:
        ChatInputMentionPanelController r6 = this.b;
        if (r6.n == false) goto L26;
        int r7 = 0;
    L52:
        if (r5 == null) goto L69;
        if (r7 < 0) goto L60;
        RecyclerView.Adapter r8 = this.a.getAdapter();
        if (r8 == null) goto L57;
        int r9 = r8.getItemCount();
    L58:
        if (r7 >= r9) goto L60;
        boolean r10 = true;
    L61:
        if (r10 == false) goto L69;
        ChatInputMentionPanelController r11 = this.b;
        if (r11.n == false) goto L66;
        int r12 = 0;
    L67:
        r5.scrollToPositionWithOffset(r7, r12);
        return false;
    L66:
        r12 = r11.m;
        goto L67
    L57:
        r9 = 0;
    L60:
        r10 = false;
    L69:
        return true;
    L26:
        String r13 = r6.k;
        if (r13 == null) goto L49;
        u7 r14 = r6.c.u3();
        if (r14 == null) goto L41;
        MessageAdapter r15 = r14.MF();
        if (r15 == null) goto L41;
        Iterator r16 = ((ArrayList) r15.getCurrentList()).iterator();
        int r17 = 0;
    L34:
        if (r16.hasNext() == false) goto L39;
        if (Intrinsics.areEqual(((Message) r16.next()).getMessageId(), r13) == true) goto L40;
        r17 = r17 + 1;
    L40:
        Integer r18 = Integer.valueOf(r17);
    L42:
        if (r18 == null) goto L49;
        if (r18.intValue() == (-1)) goto L46;
        boolean r19 = true;
    L47:
        if (r19 == false) goto L49;
        r4 = r18;
        goto L49
    L46:
        r19 = false;
        goto L47
    L39:
        r17 = -1;
    L41:
        r18 = null;
    L49:
        if (r4 == null) goto L51;
        r7 = r4.intValue();
        goto L52
    L51:
        r7 = this.b.l;
        goto L52
    L22:
        r5 = null;
        goto L23
    L8:
        if (r0.isAlive() != true) goto L10;
        r3 = true;
        goto L11
    }

    public p(RecyclerView r1, ChatInputMentionPanelController r2) {
        this.a = r1;
        this.b = r2;
    }
}
