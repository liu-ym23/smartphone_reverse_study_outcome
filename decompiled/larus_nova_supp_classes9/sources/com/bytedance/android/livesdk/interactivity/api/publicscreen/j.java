package com.bytedance.android.livesdk.interactivity.api.publicscreen;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.PSMessageViewHolder;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.i;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public interface j<T extends i, VH extends PSMessageViewHolder> {

    public static final class a {
        public static <T extends i, VH extends PSMessageViewHolder> void a(j<T, VH> r1, PSMessageViewHolder r2, i r3, int r4, g52.e r5) {
            Intrinsics.checkNotNullParameter(r2, "viewHolder");
            Intrinsics.checkNotNullParameter(r3, "item");
            if (r3 == null) goto L10;
            if (r2 == null) goto L8;
            r1.b(r2, r3, r4, r5);
            return;
        L8:
            throw new IllegalArgumentException("Invalid type ".concat(r3.getClass().getName()));
        L10:
            throw new IllegalArgumentException("Invalid type ".concat(r3.getClass().getName()));
        }
    }

    PublicScreenConfig$ViewBinderType a();

    void b(VH r1, T r2, int r3, g52.e r4);

    VH c(LayoutInflater r1, ViewGroup r2, g52.c r3);

    void d(PSMessageViewHolder r1, i r2, int r3, g52.e r4);
}
