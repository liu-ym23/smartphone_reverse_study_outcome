package com.larus.bmhome.chat.markdown.ugc;

import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.bmhome.video.Content;
import com.larus.mainbot.impl.databinding.LarusMdUgcRecycleviewBinding;
import com.larus.platform.api.r2;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class i implements r2.a {
    public final /* synthetic */ Content a;
    public final /* synthetic */ MarkdownUgcWidget b;

    public final View a(String r9) {
        boolean r0 = true;
        if (r9 != null) goto L5;
    L8:
        boolean r2 = true;
    L9:
        RecyclerView r3 = null;
        if (r2 == false) goto L12;
    L59:
        return null;
    L12:
        if (Intrinsics.areEqual(r9, this.a.getItemId()) == true) goto L59;
        MarkdownUgcWidget r4 = this.b;
        List<Content> r5 = r4.p;
        if (r5 == null) goto L59;
        Iterator<Content> r6 = r5.iterator();
        int r7 = 0;
    L18:
        if (r6.hasNext() == false) goto L23;
        if (Intrinsics.areEqual(r6.next().getItemId(), r9) == true) goto L24;
        r7 = r7 + 1;
    L24:
        Integer r10 = Integer.valueOf(r7);
        if (r10.intValue() >= 0) goto L28;
        r0 = false;
    L28:
        if (r0 == true) goto L31;
        r10 = null;
    L31:
        if (r10 == null) goto L33;
        int r11 = r10.intValue();
    L34:
        LarusMdUgcRecycleviewBinding r1 = r4.r;
        if (r1 == null) goto L39;
        RecyclerView r8 = r1.b;
        if (r8 == null) goto L39;
        RecyclerView.LayoutManager r12 = r8.getLayoutManager();
    L41:
        if ((r12 instanceof LinearLayoutManager) == false) goto L43;
        LinearLayoutManager r13 = (LinearLayoutManager) r12;
    L44:
        if (r13 == null) goto L46;
        r13.scrollToPositionWithOffset(r11, 0);
    L46:
        LarusMdUgcRecycleviewBinding r14 = r4.r;
        if (r14 == null) goto L54;
        RecyclerView r15 = r14.b;
        if (r15 == null) goto L54;
        RecyclerView.ViewHolder r16 = r15.findViewHolderForAdapterPosition(r11);
        if (r16 == null) goto L54;
        View r17 = r16.itemView;
        if (r17 == null) goto L54;
        return r17;
    L54:
        LarusMdUgcRecycleviewBinding r18 = r4.r;
        if (r18 == null) goto L58;
        r3 = r18.b;
    L58:
        return r3;
    L43:
        r13 = null;
    L39:
        r12 = null;
        goto L41
    L33:
        r11 = CollectionsKt.getLastIndex(r5);
        goto L34
    L23:
        r7 = -1;
        goto L24
    L5:
        if (r9.length() == 0) goto L8;
        r2 = false;
        goto L9
    }

    public i(Content r1, MarkdownUgcWidget r2) {
        this.a = r1;
        this.b = r2;
    }
}
