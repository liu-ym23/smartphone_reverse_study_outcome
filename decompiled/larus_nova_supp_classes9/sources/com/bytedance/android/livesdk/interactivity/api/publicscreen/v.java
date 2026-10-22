package com.bytedance.android.livesdk.interactivity.api.publicscreen;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class v implements j<s, PSTextMessageViewHolder> {
    public static final PublicScreenConfig$ViewBinderType a = null;
    public static final v b = null;

    public v() {
    }

    static {
        b = new v();
        a = PublicScreenConfig$ViewBinderType.COMMON_TEXT;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.j
    public final PublicScreenConfig$ViewBinderType a() {
        return a;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.j
    public final PSMessageViewHolder c(LayoutInflater r3, ViewGroup r4, g52.c r5) {
        Intrinsics.checkNotNullParameter(r3, "layoutInflater");
        Intrinsics.checkNotNullParameter(r4, "parent");
        View r6 = r3.inflate(2131566377, r4, false);
        if (r6.getLayoutParams() != null) goto L6;
        r6.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
    L6:
        return new PSTextMessageViewHolder(r6, r5);
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.j
    public final void b(PSMessageViewHolder r1, i r2, int r3, g52.e r4) {
        PSTextMessageViewHolder r5 = (PSTextMessageViewHolder) r1;
        s r6 = (s) r2;
        Intrinsics.checkNotNullParameter(r5, "viewHolder");
        Intrinsics.checkNotNullParameter(r6, "item");
        r5.W3(r6, r4);
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.j
    public final void d(PSMessageViewHolder r2, i r3, int r4, g52.e r5) {
        Intrinsics.checkNotNullParameter(r2, "viewHolder");
        Intrinsics.checkNotNullParameter(r3, "item");
        j.a.a(this, r2, r3, r4, r5);
    }
}
