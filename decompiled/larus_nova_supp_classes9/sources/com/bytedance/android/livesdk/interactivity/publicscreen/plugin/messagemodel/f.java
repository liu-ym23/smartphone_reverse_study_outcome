package com.bytedance.android.livesdk.interactivity.publicscreen.plugin.messagemodel;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.PSMessageViewHolder;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.PSTextMessageViewHolder;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.PublicScreenConfig$ViewBinderType;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.s;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class f implements com.bytedance.android.livesdk.interactivity.api.publicscreen.j<s, PSTextMessageViewHolder> {
    public static final PublicScreenConfig$ViewBinderType a = null;
    public static g52.e b;
    public static final f c = null;

    public f() {
    }

    static {
        c = new f();
        a = PublicScreenConfig$ViewBinderType.EMOJI_COMMON_TEXT;
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
    public final void b(PSMessageViewHolder r11, com.bytedance.android.livesdk.interactivity.api.publicscreen.i r13, int r14, g52.e r15) {
        PSTextMessageViewHolder r16 = (PSTextMessageViewHolder) r11;
        s r17 = (s) r13;
        Intrinsics.checkNotNullParameter(r16, "viewHolder");
        Intrinsics.checkNotNullParameter(r17, "item");
        if (r15 == null) goto L26;
        g52.e r18 = b;
        if (r18 != null) goto L7;
    L23:
        boolean r19 = false;
    L24:
        if (r19 == true) goto L26;
        b = new g52.e(r15.a, r15.b, r15.c, r15.d, r15.e, s1.f(3.0f), r15.g, r15.h, r15.i);
        goto L26
    L7:
        if (r18.a != r15.a) goto L23;
        if (r18.b != r15.b) goto L23;
        if (Intrinsics.areEqual(r18.c, r15.c) == false) goto L23;
        if (r18.d != r15.d) goto L23;
        if (r18.e != r15.e) goto L23;
        if (r18.g != r15.g) goto L23;
        if (r18.h != r15.h) goto L23;
        if (r18.i != r15.i) goto L23;
        r19 = true;
    L26:
        r16.W3(r17, b);
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.j
    public final void d(PSMessageViewHolder r2, com.bytedance.android.livesdk.interactivity.api.publicscreen.i r3, int r4, g52.e r5) {
        Intrinsics.checkNotNullParameter(r2, "viewHolder");
        Intrinsics.checkNotNullParameter(r3, "item");
        com.bytedance.android.livesdk.interactivity.api.publicscreen.j.a.a(this, r2, r3, r4, r5);
    }
}
