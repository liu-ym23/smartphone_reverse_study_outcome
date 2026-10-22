package com.bytedance.android.live.profile.ui.component.descriptioncomponent.mylive;

import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class j implements ProfileTabsComponent.b {
    public final /* synthetic */ TabAdapter.TabViewHolder a;
    public final /* synthetic */ int b;
    public final /* synthetic */ com.bytedance.android.live.profile.ui.base.h c;

    @Override // com.bytedance.android.live.profile.ui.component.descriptioncomponent.mylive.ProfileTabsComponent.b
    public final void a(int r2, boolean r3) {
        if (this.b != r2) goto L19;
        com.bytedance.android.live.profile.ui.base.m r4 = com.bytedance.android.live.profile.ui.base.i.n(this.c);
        Integer r5 = null;
        if (r4 == null) goto L7;
        Integer r6 = r4.b();
    L8:
        com.bytedance.android.live.profile.ui.base.m r0 = com.bytedance.android.live.profile.ui.base.i.n(this.c);
        if (r0 == null) goto L11;
        r5 = r0.c();
    L11:
        if (r6 == null) goto L20;
        if (r5 != null) goto L14;
        return;
    L14:
        if (r6.intValue() >= r5.intValue()) goto L22;
        RecyclerView r7 = (RecyclerView) this.a.a.getValue();
        if (r7 == null) goto L23;
        r7.scrollToPosition(0);
        return;
    L23:
        return;
    L22:
        return;
    L20:
        return;
    L7:
        r6 = null;
        goto L8
    }

    public j(TabAdapter.TabViewHolder r1, int r2, com.bytedance.android.live.profile.ui.base.h r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
