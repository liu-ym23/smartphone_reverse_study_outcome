package com.ss.android.lark.mention.base.impl.atselector.doubaoview;

import android.text.TextUtils;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.mention.base.impl.atselector.bean.BaseAtBean;
import com.ss.android.lark.mention.base.impl.atselector.bean.SkeletonAtBean;
import com.ss.android.lark.mention.base.impl.atselector.doubaoview.adapter.DoubaoAtSelectBaseAdapter;
import com.ss.android.lark.utils.UIHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class c {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void a(DoubaoMentionPanelUi r9, j r10, DoubaoMentionPanelView.c r11) {
        Intrinsics.checkNotNullParameter(r9, "ui");
        Intrinsics.checkNotNullParameter(r10, "state");
        boolean r0 = !TextUtils.isEmpty(r10.c);
        if (r0 == false) goto L5;
        b r2 = r10.b;
    L6:
        DoubaoAtSelectBaseAdapter r3 = r9.a;
        String r4 = "";
        if (r0 == false) goto L9;
        String r5 = r10.c;
    L10:
        r3.getClass();
        if (r5 == null) goto L13;
        String r6 = StringsKt.trim(r5).toString();
    L14:
        if (r6 == null) goto L18;
        r4 = r6;
    L18:
        if (Intrinsics.areEqual(r3.c, r4) == true) goto L21;
        r3.c = r4;
    L21:
        DoubaoAtSelectBaseAdapter r7 = r9.a;
        int r8 = 0;
        if (r0 == true) goto L24;
    L26:
        boolean r12 = false;
    L28:
        if (r7.d == r12) goto L31;
        r7.d = r12;
    L31:
        TextView r13 = r9.c;
        if (r10.g == false) goto L34;
        int r14 = 2131891629;
    L35:
        r13.setText(UIHelper.getString(r14));
        Log.d("DoubaoMentionPanelView", "render inSearch=" + r0 + ", keyLen=" + r10.c.length() + ", requestId=" + r10.d + ", load=" + r2.getClass().getSimpleName());
        if ((r2 instanceof b.c) == false) goto L39;
        r9.f.setVisibility(8);
        return;
    L39:
        if ((r2 instanceof b.d) == false) goto L75;
        r9.f.setVisibility(8);
        List r15 = r9.a.getItems();
        ArrayList r16 = new ArrayList();
        Iterator r17 = r15.iterator();
    L42:
        if (r17.hasNext() == false) goto L52;
        Object r18 = r17.next();
        BaseAtBean r19 = (BaseAtBean) r18;
        if (r10.h == false) goto L46;
    L49:
        boolean r20 = true;
    L50:
        if (r20 == false) goto L42;
        r16.add(r18);
        goto L42
    L46:
        if (r19.getType() != 8) goto L49;
        r20 = false;
        goto L50
    L52:
        List r110 = CollectionsKt.toMutableList(r16);
        if (r110.size() == r9.a.getItems().size()) goto L55;
        r9.a.resetAll(r110);
    L55:
        if (r0 == false) goto L69;
        ArrayList r1 = new ArrayList();
        if (r10.g == false) goto L62;
        int r111 = RangesKt.coerceAtLeast(r110.size(), 1);
    L59:
        if (r8 >= r111) goto L67;
        r1.add(new SkeletonAtBean());
        r8 = r8 + 1;
    L67:
        r9.a.resetAll(r1);
        return;
    L62:
        if ((!r110.isEmpty()) == false) goto L66;
        r1.add(CollectionsKt.first(r110));
        int r112 = r110.size() - 1;
    L64:
        if (r8 >= r112) goto L67;
        r1.add(new SkeletonAtBean());
        r8 = r8 + 1;
        goto L64
    L66:
        r1.add(new SkeletonAtBean());
        goto L67
    L69:
        if (r10.g == false) goto L118;
        r9.e.setVisibility(0);
        List r113 = CollectionsKt.toMutableList(r9.a.getItems());
        ArrayList r114 = new ArrayList();
        int r115 = RangesKt.coerceAtLeast(r113.size(), 1);
    L71:
        if (r8 >= r115) goto L73;
        r114.add(new SkeletonAtBean());
        r8 = r8 + 1;
        goto L71
    L73:
        r9.a.resetAll(r114);
        return;
    L118:
        return;
    L75:
        if ((r2 instanceof b.e) == false) goto L83;
        r9.f.setVisibility(8);
        r9.e.setVisibility(0);
        if (r0 == false) goto L81;
        Log.i("DoubaoMentionPanelView", "render success inSearch=true -> realShowMentionPanelView(true)");
        if (r11 == null) goto L81;
        r11.d(true);
    L81:
        r9.e.scrollToPosition(0);
        LinearLayoutManager r116 = r9.e.getLayoutManager();
        Intrinsics.checkNotNull(r116, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
        r116.scrollToPositionWithOffset(0, 0);
        r9.a.resetAll(CollectionsKt.toMutableList(((b.e) r2).a));
        return;
    L83:
        if ((r2 instanceof b.a) == false) goto L95;
        Log.i("DoubaoMentionPanelView", "render empty inSearch=" + r0);
        r9.a.clear();
        r9.e.setVisibility(4);
        TextView r21 = r9.f;
        if (r10.g == false) goto L87;
        r8 = 8;
    L87:
        r21.setVisibility(r8);
        TextView r22 = r9.f;
        if (r0 == false) goto L90;
        String r117 = UIHelper.mustacheFormat(2131892028, "search_key", r10.c);
    L91:
        r22.setText(r117);
        if (r11 == null) goto L121;
        r11.c();
        return;
    L121:
        return;
    L90:
        r117 = UIHelper.getString(2131892028);
        goto L91
    L95:
        if ((r2 instanceof b.C0175b) == false) goto L107;
        b.C0175b r23 = (b.C0175b) r2;
        Log.e("DoubaoMentionPanelView", "load error", r23.b);
        Log.i("DoubaoMentionPanelView", "render error inSearch=" + r0);
        r9.a.clear();
        r9.e.setVisibility(4);
        TextView r24 = r9.f;
        if (r10.g == false) goto L99;
        r8 = 8;
    L99:
        r24.setVisibility(r8);
        TextView r25 = r9.f;
        String r118 = r23.a;
        if (StringsKt.isBlank(r118) == false) goto L102;
        r118 = UIHelper.getString(2131892028);
    L102:
        r25.setText(r118);
        if (r11 == null) goto L123;
        r11.c();
        return;
    L123:
        return;
    L107:
        throw new NoWhenBranchMatchedException();
    L34:
        r14 = 2131890882;
        goto L35
    L24:
        if (r10.f == false) goto L26;
        r12 = true;
        goto L28
    L13:
        r6 = null;
        goto L14
    L9:
        r5 = "";
        goto L10
    L5:
        r2 = r10.a;
        goto L6
    }
}
