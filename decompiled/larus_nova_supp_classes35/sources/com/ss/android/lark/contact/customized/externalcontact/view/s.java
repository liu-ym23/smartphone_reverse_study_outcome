package com.ss.android.lark.contact.customized.externalcontact.view;

import android.os.Vibrator;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.ss.android.lark.contact.base.common_ui.IndexBar;
import com.ss.android.lark.contact.base.contact_list.view.IndexRecyclerViewAdapter;
import com.ss.android.lark.statistics.Statistics;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.widget.recyclerview.CommonRecyclerView;
import com.tencent.qqmusic.third.api.contract.BuildConfig;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class s implements IndexBar.b {
    public IndexRecyclerViewAdapter.b a;
    public final /* synthetic */ IndexRecyclerViewAdapter b;
    public final /* synthetic */ int c;
    public final /* synthetic */ RecyclerView d;
    public final /* synthetic */ u e;

    @Override // com.ss.android.lark.contact.base.common_ui.IndexBar.b
    public final void b() {
        TextView r0 = this.e.b;
        if (r0 == null) goto L5;
        r0.setVisibility(8);
    L5:
        this.a = null;
    }

    @Override // com.ss.android.lark.contact.base.common_ui.IndexBar.b
    public final void a(String r4) {
        u r0 = this.e;
        if (r0.f != null) goto L5;
        r0.f = (Vibrator) LarkContext.getApplication().getSystemService("vibrator");
    L5:
        r0.f.vibrate(10);
        d(r4);
        int r5 = com.ss.android.lark.contact.base.statistics.a.a;
        Statistics.sendEvent("contact_external_letter_click");
    }

    @Override // com.ss.android.lark.contact.base.common_ui.IndexBar.b
    public final void c(String r4) {
        u r0 = this.e;
        if (r0.f != null) goto L5;
        r0.f = (Vibrator) LarkContext.getApplication().getSystemService("vibrator");
    L5:
        r0.f.vibrate(10);
        d(r4);
    }

    public final void d(String r7) {
        if (this.e.e == true) goto L5;
    L10:
        IndexRecyclerViewAdapter.b r0 = this.a;
        if (r0 != null) goto L13;
    L15:
        IndexRecyclerViewAdapter r1 = this.b;
        r1.getClass();
        IndexRecyclerViewAdapter.b r2 = new IndexRecyclerViewAdapter.a(r1).b(r7);
        this.a = r2;
        if (r2 == null) goto L25;
        int r3 = this.c + r2.c;
        u r4 = this.e;
        RecyclerView r5 = this.d;
        r4.getClass();
        r5.getLayoutManager().scrollToPositionWithOffset(r3, 0);
        u r6 = this.e;
        boolean r8 = r6.e;
        IndexRecyclerViewAdapter.b r9 = this.a;
        int r10 = r9.a + (r8 ? 1 : 0);
        float r11 = r9.e + (r8 ? 1 : 0);
        float r12 = ((r10 + 0.5f) - (r11 / 2.0f)) * ((r6.c.getHeight() * 1.0f) / r11);
        u r13 = this.e;
        TextView r14 = r13.b;
        if (r14 == null) goto L22;
        r14.setVisibility(0);
        r13.b.setText(r7);
        ViewGroup.LayoutParams r15 = r13.b.getLayoutParams();
        if ((r15 instanceof ViewGroup.MarginLayoutParams) == false) goto L22;
        ((ViewGroup.MarginLayoutParams) r15).topMargin = (int) r12;
        r13.b.setLayoutParams(r15);
    L22:
        this.e.c.setFocusIndex(r10);
        return;
    L25:
        return;
    L13:
        if (TextUtils.equals(r7, r0.b) == false) goto L15;
        return;
    L5:
        if (TextUtils.equals(r7, BuildConfig.FLAVOR) == false) goto L10;
        this.a = null;
        View r16 = this.e.d;
        if (r16 == null) goto L24;
        r16.performClick();
        return;
    }

    public s(u r1, IndexRecyclerViewAdapter r2, int r3, CommonRecyclerView r4) {
        this.e = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}
