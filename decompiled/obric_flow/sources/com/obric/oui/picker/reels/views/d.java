package com.obric.oui.picker.reels.views;

import android.R;
import android.view.ViewGroup;
import android.widget.TextView;
import com.obric.oui.orecyclerview.widget.RecyclerView;
import com.obric.oui.orecyclerview.widget.a0;
import com.obric.oui.orecyclerview.widget.x0;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class d extends a0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList f14078b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ WheelView f14079c;

    public d(WheelView r5) {
        Intrinsics.checkNotNullParameter(r5, "this$0");
        this.f14079c = r5;
        this.f14078b = new ArrayList();
    }

    @Override // com.obric.oui.orecyclerview.widget.a0
    public final int getItemCount() {
        int r5 = this.f14078b.size();
        if (r5 != 0) goto L6;
        return 0;
    L6:
        WheelView r10 = this.f14079c;
        if (r10.f14059w == false) goto L10;
        return r5 * 1000;
    L10:
        return r5 + (r10.f() * 2);
    }

    @Override // com.obric.oui.orecyclerview.widget.a0
    public final void onBindViewHolder(x0 r5, int r10) {
        final int r11 = 0;
        final e r12 = (e) r5;
        Intrinsics.checkNotNullParameter(r12, "holder");
        int r13 = WheelView.C;
        final WheelView r14 = this.f14079c;
        int r15 = r14.b(r10);
        boolean r16 = r14.f14059w;
        ArrayList r17 = this.f14078b;
        if (r16 == false) goto L6;
        r12.g.setAlpha(1.0f);
        float r18 = r14.f14045h;
        TextView r19 = r12.g;
        r19.setTextSize(0, r18);
        r19.setText((CharSequence) r17.get(r15));
        r12.itemView.setOnClickListener(new c(r12, r14, r11));
        return;
    L6:
        if (r14.g(r15) == false) goto L8;
        r12.g.setAlpha(1.0f);
        float r20 = r14.f14045h;
        TextView r21 = r12.g;
        r21.setTextSize(0, r20);
        r21.setText((CharSequence) r17.get(r15));
        final int r22 = 1;
        r12.itemView.setOnClickListener(new c(r12, r14, r22));
        return;
    L8:
        r12.g.setAlpha(0.0f);
        r12.g.setText("");
        r12.itemView.setOnClickListener(null);
    }

    @Override // com.obric.oui.orecyclerview.widget.a0
    public final x0 onCreateViewHolder(ViewGroup r5, int r10) {
        Intrinsics.checkNotNullParameter(r5, "parent");
        TextView r11 = new TextView(r5.getContext());
        r11.setId(R.id.text1);
        WheelView r12 = this.f14079c;
        r11.setLayoutParams(new RecyclerView.LayoutParams(-1, r12.e));
        r11.setGravity(17);
        r11.setTextSize(0, r12.f14045h);
        r11.setIncludeFontPadding(false);
        return new e(r11);
    }
}
