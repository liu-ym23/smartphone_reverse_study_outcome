package com.larksuite.component.universe_design.menu;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.larksuite.component.universe_design.dimension.UDDimension;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class e implements c.g {
    public final /* synthetic */ List<g> a;
    public final /* synthetic */ c.f b;

    @Override // com.larksuite.component.universe_design.menu.c.g
    public final ViewGroup create(Context r6) {
        Intrinsics.checkNotNullParameter(r6, "context");
        int r1 = h.a;
        List<g> r2 = this.a;
        c.f r3 = this.b;
        List<Integer> r4 = r3.h;
        r3.getClass();
        Intrinsics.checkNotNullParameter(r6, "context");
        Intrinsics.checkNotNullParameter(r2, "itemList");
        Intrinsics.checkNotNullParameter(r4, "dividerPositions");
        RecyclerView r0 = new RecyclerView(r6);
        r0.setOverScrollMode(2);
        r0.setLayoutManager(new LinearLayoutManager(r6));
        h.b r5 = new h.b(r6);
        Intrinsics.checkNotNullParameter(r2, "dataList");
        r5.b.clear();
        r5.b.addAll(r2);
        r5.notifyDataSetChanged();
        if (r5.c == false) goto L5;
        r5.c = false;
        r5.notifyDataSetChanged();
    L5:
        r0.setAdapter(r5);
        r0.addItemDecoration(new MenuDividerItemDecoration(r6, r4));
        int r7 = (int) new UDDimension.Dp(4.0f).toPixels(r6);
        r0.setPadding(r7, r7, r7, r7);
        r0.setClipToPadding(false);
        FrameLayout r8 = new FrameLayout(r6);
        r8.setBackground(ContextCompat.getDrawable(r6, 2131256312));
        r8.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        r8.addView(r0);
        return r8;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public e(List<? extends g> r1, c.f r2) {
        this.a = r1;
        this.b = r2;
    }
}
