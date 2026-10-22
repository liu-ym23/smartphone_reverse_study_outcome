package com.bytedance.android.live.ktv.common.view;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.ktv.common.view.adapter.OpusPreviewAdapter;
import com.bytedance.android.live.liveinteract.interactivesong.panel.MvSelectListView;
import com.bytedance.android.livesdk.ktvapi.model.mv.j;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public class g<T> implements com.bytedance.android.livesdk.ktvapi.model.mv.e<T> {
    public RecyclerView a;
    public OpusPreviewAdapter<T> b;
    public FrameLayout c;
    public final LinearLayout d;
    public final Context e;
    public final j<T> f;
    public com.bytedance.android.livesdk.ktvapi.model.mv.i<T> g;

    public final RecyclerView c() {
        RecyclerView r0 = this.a;
        if (r0 != null) goto L13;
        r0 = new RecyclerView(this.e);
        this.a = r0;
        r0.setNestedScrollingEnabled(false);
        r0.setLayoutParams(new ViewGroup.MarginLayoutParams(-1, -2));
        if (this.b != null) goto L12;
        RecyclerView r3 = this.a;
        if (r3 == null) goto L10;
        int r4 = r3.getWidth();
    L11:
        OpusPreviewAdapter<T> r2 = new OpusPreviewAdapter(r4, this.f, new f(this));
        this.b = r2;
        Unit r5 = Unit.INSTANCE;
        r0.setAdapter(r2);
        goto L12
    L10:
        r4 = 0;
    L12:
        GridLayoutManager r6 = new GridLayoutManager(r0.getContext(), 3, 1, false);
        Unit r1 = Unit.INSTANCE;
        r0.setLayoutManager(r6);
    L13:
        return r0;
    }

    public View e() {
        return this.c;
    }

    public final Context getContext() {
        return this.e;
    }

    public final void a(MvSelectListView.a r2) {
        Intrinsics.checkNotNullParameter(r2, "cb");
        this.g = r2;
    }

    public final void b(List<? extends T> r2) {
        OpusPreviewAdapter<T> r0 = this.b;
        if (r0 == null) goto L5;
        r0.a = r2;
    L5:
        if (r0 == null) goto L8;
        r0.notifyDataSetChanged();
        return;
    }

    public final void d(com.bytedance.android.live.liveinteract.interactivesong.panel.c r3) {
        Intrinsics.checkNotNullParameter(r3, "p");
        OpusPreviewAdapter<T> r0 = this.b;
        if (r0 == null) goto L6;
        Intrinsics.checkNotNullParameter(r3, "<set-?>");
        r0.c = r3;
        return;
    }

    public g(Context r2, j<T> r3, com.bytedance.android.livesdk.ktvapi.model.mv.i<T> r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "vhProvider");
        this.e = r2;
        this.f = r3;
        this.g = r4;
        LinearLayout r5 = new LinearLayout(r2);
        r5.setOrientation(1);
        r5.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        Unit r6 = Unit.INSTANCE;
        this.d = r5;
        if (e() == null) goto L5;
        r5.addView(e());
    L5:
        r5.addView(c());
    }
}
