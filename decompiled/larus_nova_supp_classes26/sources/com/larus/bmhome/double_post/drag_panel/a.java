package com.larus.bmhome.double_post.drag_panel;

import android.view.ViewGroup;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final /* synthetic */ class a implements Runnable {
    public final /* synthetic */ ViewGroup a;

    public /* synthetic */ a(ViewGroup r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ViewGroup r0 = this.a;
        int r1 = ChatAwemeFeedComponent.V;
        r0.setVisibility(8);
        r0.setAlpha(1.0f);
    }
}
