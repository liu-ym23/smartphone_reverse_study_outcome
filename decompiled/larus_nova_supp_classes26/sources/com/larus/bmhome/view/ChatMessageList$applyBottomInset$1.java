package com.larus.bmhome.view;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.bmhome.chat.cell.view.AbstractMessageBoxContainerView;
import com.larus.im.bean.message.Message;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\f"}, d2 = {"com/larus/bmhome/view/ChatMessageList$applyBottomInset$1", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ChatMessageList$applyBottomInset$1 extends RecyclerView.ItemDecoration {
    public final /* synthetic */ ChatMessageList a;
    public final /* synthetic */ int b;

    public ChatMessageList$applyBottomInset$1(ChatMessageList r1, int r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void getItemOffsets(Rect r8, View r9, RecyclerView r10, RecyclerView.State r11) {
        Intrinsics.checkNotNullParameter(r8, "outRect");
        Intrinsics.checkNotNullParameter(r9, "view");
        Intrinsics.checkNotNullParameter(r10, "parent");
        Intrinsics.checkNotNullParameter(r11, "state");
        super.getItemOffsets(r8, r9, r10, r11);
        boolean r2 = true;
        int r3 = 0;
        if (r9.getVisibility() != 8) goto L5;
        boolean r12 = true;
    L6:
        if (r12 == true) goto L85;
        if (com.larus.utils.e1.r(this.a.getChildViewHolder(r9).itemView) == true) goto L85;
        this.a.getClass();
        Intrinsics.checkNotNullParameter(r9, "view");
        Message r0 = null;
        Object r1 = null;
        if ((r9 instanceof AbstractMessageBoxContainerView) == false) goto L13;
        AbstractMessageBoxContainerView r13 = (AbstractMessageBoxContainerView) r9;
    L15:
        if (r13 == null) goto L17;
        boolean r4 = r13.getNeedTopMargin();
    L18:
        Boolean r5 = Boolean.valueOf(r4);
        if (r13 == null) goto L21;
        boolean r14 = r13.getNeedBottomMargin();
    L22:
        Pair r6 = new Pair(r5, Boolean.valueOf(r14));
        LinearLayoutManager r15 = r10.getLayoutManager();
        if (r15 != null) goto L26;
        return;
    L26:
        if ((r15 instanceof LinearLayoutManager) == false) goto L28;
        LinearLayoutManager r16 = r15;
    L29:
        if (r16 != null) goto L31;
        return;
    L31:
        boolean r7 = ((Boolean) r6.getFirst()).booleanValue();
        boolean r17 = ((Boolean) r6.getSecond()).booleanValue();
        int r18 = r16.getPosition(r9);
        boolean r19 = ChatMessageList.w(this.a, r9);
        if (r16.getReverseLayout() == false) goto L65;
        if (r7 == false) goto L37;
        if (r19 == true) goto L37;
        int r110 = this.a.getSpacing();
    L38:
        r8.top = r110;
        if (r17 == false) goto L64;
        List r111 = ChatMessageList.v(this.a);
        if (r111 == null) goto L50;
        Iterator r112 = r111.iterator();
    L45:
        if (r112.hasNext() == false) goto L49;
        Object r20 = r112.next();
        if ((!com.larus.bmhome.chat.bean.d.L0((Message) r20)) == false) goto L45;
        r1 = r20;
    L49:
        r0 = (Message) r1;
    L50:
        if (r18 != 0) goto L64;
        if (r0 != null) goto L53;
    L55:
        boolean r113 = false;
    L56:
        if (r113 == true) goto L64;
        if (r0 != null) goto L59;
    L61:
        r2 = false;
    L62:
        if (r2 == true) goto L64;
        r3 = this.b;
        goto L64
    L59:
        if (com.larus.bmhome.chat.bean.d.E0(r0) != true) goto L61;
    L53:
        if (com.larus.bmhome.chat.bean.d.O0(r0) != true) goto L55;
        r113 = true;
    L64:
        r8.bottom = r3;
    L77:
        if (r19 == true) goto L95;
        t1a.b r114 = ei9.c.a(this.a);
        if (r114 == null) goto L96;
        saa.a r115 = r114.o(Reflection.getOrCreateKotlinClass(saa.a.class));
        if (r115 == null) goto L97;
        r115.wM(r10, r9, r8);
        return;
    L97:
        return;
    L96:
        return;
    L95:
        return;
    L37:
        r110 = 0;
        goto L38
    L65:
        if (r7 == false) goto L69;
        if (r19 == true) goto L69;
        int r116 = this.a.getSpacing();
    L70:
        r8.bottom = r116;
        if (r17 == false) goto L76;
        if (r18 != 0) goto L76;
        if (r19 == true) goto L76;
        r3 = this.a.getSpacing();
    L76:
        r8.top = r3;
    L69:
        r116 = 0;
        goto L70
    L28:
        r16 = null;
        goto L29
    L21:
        r14 = true;
        goto L22
    L17:
        r4 = true;
        goto L18
    L13:
        r13 = null;
    L85:
        if (ChatMessageList.w(this.a, r9) == true) goto L98;
        t1a.b r117 = ei9.c.a(this.a);
        if (r117 == null) goto L99;
        saa.a r118 = r117.o(Reflection.getOrCreateKotlinClass(saa.a.class));
        if (r118 == null) goto L100;
        r118.wM(r10, r9, r8);
        return;
    L100:
        return;
    L99:
        return;
    L98:
        return;
    L5:
        r12 = false;
        goto L6
    }
}
