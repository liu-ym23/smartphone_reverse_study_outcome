package com.ss.android.lark.feed.shared.page.utils;

import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class b {
    public static boolean b() {
        return heb.a.a.getFeatureGatingDependency().isEnable("lark.feed.anim.disable");
    }

    public static void a(RecyclerView r3) {
        if (b() == false) goto L7;
        if (r3 == null) goto L8;
        r3.getItemAnimator().setRemoveDuration(0);
        r3.getItemAnimator().setMoveDuration(0);
        return;
    L8:
        return;
    }
}
