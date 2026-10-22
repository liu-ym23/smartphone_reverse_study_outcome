package com.ss.android.lark.contact.base.contact_list.mvp;

import android.os.Vibrator;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.ss.android.lark.contact.base.common_ui.IndexBar;
import com.ss.android.lark.contact.base.contact_list.view.IndexRecyclerViewAdapter;
import com.ss.android.lark.statistics.Statistics;
import com.ss.android.lark.utils.LarkContext;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class j implements IndexBar.b {
    public IndexRecyclerViewAdapter.b a;
    public final /* synthetic */ RecyclerView b;
    public final /* synthetic */ ExternalContactView2.b c;

    @Override // com.ss.android.lark.contact.base.common_ui.IndexBar.b
    public final void b() {
        TextView r0 = this.c.b;
        if (r0 == null) goto L5;
        r0.setVisibility(8);
    L5:
        this.a = null;
    }

    @Override // com.ss.android.lark.contact.base.common_ui.IndexBar.b
    public final void a(String r4) {
        ExternalContactView2.b r0 = this.c;
        if (r0.d != null) goto L5;
        r0.d = (Vibrator) LarkContext.getApplication().getSystemService("vibrator");
    L5:
        r0.d.vibrate(10);
        d(r4);
        int r5 = com.ss.android.lark.contact.base.statistics.a.a;
        Statistics.sendEvent("contact_external_letter_click");
    }

    @Override // com.ss.android.lark.contact.base.common_ui.IndexBar.b
    public final void c(String r4) {
        ExternalContactView2.b r0 = this.c;
        if (r0.d != null) goto L5;
        r0.d = (Vibrator) LarkContext.getApplication().getSystemService("vibrator");
    L5:
        r0.d.vibrate(10);
        d(r4);
    }

    public final void d(String r6) {
        IndexRecyclerViewAdapter.b r0 = this.a;
        if (r0 != null) goto L5;
    L7:
        ExternalContactView2.b r1 = this.c;
        RecyclerView r2 = this.b;
        r1.getClass();
        IndexRecyclerViewAdapter r3 = r2.getAdapter();
        r3.getClass();
        IndexRecyclerViewAdapter.b r4 = new IndexRecyclerViewAdapter.a(r3).b(r6);
        this.a = r4;
        if (r4 == null) goto L15;
        int r5 = r4.c;
        ExternalContactView2.b r7 = this.c;
        RecyclerView r8 = this.b;
        r7.getClass();
        r8.getLayoutManager().scrollToPositionWithOffset(r5, 0);
        IndexRecyclerViewAdapter.b r9 = this.a;
        int r10 = r9.a;
        float r11 = r9.e;
        float r12 = ((r10 + 0.5f) - (r11 / 2.0f)) * ((this.c.c.getHeight() * 1.0f) / r11);
        ExternalContactView2.b r13 = this.c;
        TextView r14 = r13.b;
        if (r14 == null) goto L16;
        r14.setVisibility(0);
        r13.b.setText(r6);
        ViewGroup.LayoutParams r15 = r13.b.getLayoutParams();
        if ((r15 instanceof ViewGroup.MarginLayoutParams) == false) goto L17;
        ((ViewGroup.MarginLayoutParams) r15).topMargin = (int) r12;
        r13.b.setLayoutParams(r15);
        return;
    L17:
        return;
    L16:
        return;
    L15:
        return;
    L5:
        if (TextUtils.equals(r6, r0.b) == false) goto L7;
    }

    public j(ExternalContactView2.b r1, RecyclerView r2) {
        this.c = r1;
        this.b = r2;
    }
}
