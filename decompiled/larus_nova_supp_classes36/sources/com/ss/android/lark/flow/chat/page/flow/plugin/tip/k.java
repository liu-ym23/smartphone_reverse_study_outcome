package com.ss.android.lark.flow.chat.page.flow.plugin.tip;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.chat.chatwindow.biz.component.keyboard.base.IKeyboardComponent;
import com.ss.android.lark.chat.chatwindow.biz.component.keyboard.coordinate.SceneCoordinateRecyclerView;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.message.IMessageListComponent;
import com.ss.android.lark.log.Log;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.ranges.RangesKt;
import m6b.v;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class k implements r7b.a.a {
    public final /* synthetic */ FlowMessageTipsPlugin a;

    public k(FlowMessageTipsPlugin r1) {
        this.a = r1;
    }

    public final boolean a() {
        FlowMessageTipsPlugin r0 = this.a;
        r0.getClass();
        long r1 = System.currentTimeMillis();
        IKeyboardComponent r3 = r0.o;
        if (r3 != null) goto L5;
    L7:
        boolean r4 = false;
    L8:
        if (r4 == true) goto L74;
        IMessageListComponent r5 = r0.n;
        if (r5 != null) goto L13;
    L15:
        boolean r6 = false;
    L16:
        if (r6 == true) goto L65;
        IMessageListComponent r7 = r0.n;
        if (r7 == null) goto L72;
        SceneCoordinateRecyclerView r8 = r7.Et();
        if (r8 == null) goto L75;
        LinearLayoutManager r9 = r8.getLayoutManager();
        LinearLayoutManager r10 = null;
        if ((r9 instanceof LinearLayoutManager) == false) goto L26;
        LinearLayoutManager r11 = r9;
    L27:
        if (r11 == null) goto L34;
        int r12 = r11.findLastVisibleItemPosition();
        RecyclerView.Adapter r13 = r8.getAdapter();
        if (r13 == null) goto L34;
        if (r12 >= (r13.getItemCount() - 10)) goto L34;
        boolean r14 = true;
    L36:
        if (r14 == true) goto L65;
        RecyclerView.LayoutManager r15 = r8.getLayoutManager();
        if ((r15 instanceof LinearLayoutManager) == false) goto L41;
        r10 = (LinearLayoutManager) r15;
    L41:
        if (r10 == null) goto L76;
        v.a.a.getClass();
        float r16 = RangesKt.coerceAtLeast((v.a() - 1) / 4.0f, 6.0f);
        int r17 = r10.findLastVisibleItemPosition();
        Log.d("FlowMessageTipsPlugin", "lastVisibleItemPosition is " + r17 + ", maxWeight is " + r16);
        ArrayList r18 = new ArrayList();
        IMessageListComponent r2 = r0.n;
        if (r2 == null) goto L48;
        List r19 = r2.h20();
        if (r19 == null) goto L48;
        r18.addAll(r19);
    L48:
        Log.d("FlowMessageTipsPlugin", "size of message list is " + r18.size());
        if (r17 >= 0) goto L51;
    L53:
        boolean r20 = false;
    L54:
        if (r20 == false) goto L77;
        int r21 = CollectionsKt.getLastIndex(r18);
        float r110 = 0.0f;
        if (r17 > r21) goto L68;
    L58:
        v r111 = v.a.a;
        int r112 = ((y6b.c) ListProtector.get(r18, r21)).getType().getNumber();
        Double r113 = (Double) ((HashMap) r111.b).get(Integer.valueOf(r112));
        if (r113 != null) goto L61;
        double r114 = 1.0d;
    L62:
        r110 = r110 + ((float) r114);
        Log.d("FlowMessageTipsPlugin", r21 + '/' + CollectionsKt.getLastIndex(r18) + ", current total weight is " + r110);
        if (r110 > r16) goto L64;
        if (r21 == r17) goto L68;
        r21 = r21 - 1;
        goto L58
    L64:
        Log.d("FlowMessageTipsPlugin", "show bottom tip, total weight is " + r110 + ", costs " + (System.currentTimeMillis() - r1) + " ms");
        goto L65
    L61:
        r114 = r113.doubleValue();
    L68:
        Log.d("FlowMessageTipsPlugin", "no bottom tip, total weight is " + r110 + ", costs " + (System.currentTimeMillis() - r1) + " ms");
        return false;
    L77:
        return false;
    L51:
        if (r17 >= r18.size()) goto L53;
        r20 = true;
        goto L54
    L76:
        return false;
    L34:
        r14 = false;
        goto L36
    L26:
        r11 = null;
        goto L27
    L75:
        return false;
    L72:
        return false;
    L65:
        return true;
    L13:
        if (r5.canLoadMore() != true) goto L15;
        r6 = true;
        goto L16
    L74:
        return false;
    L5:
        if (r3.Hx() != true) goto L7;
        r4 = true;
        goto L8
    }
}
