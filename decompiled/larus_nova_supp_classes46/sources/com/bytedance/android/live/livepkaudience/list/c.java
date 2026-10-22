package com.bytedance.android.live.livepkaudience.list;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.bytedance.android.live.liveinteract.plantform.model.MicPosTagInfo;
import com.bytedance.android.live.liveinteract.plantform.model.WaitingListUser;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class c implements dl0.a<dl0.c.AbstractC0198c, WaitingListUser> {
    public static final dl0.c.AbstractC0198c.a a = null;
    public static WeakReference<WaitingListUser> b;
    public static final c c = null;

    public c() {
    }

    static {
        c = new c();
        a = dl0.c.AbstractC0198c.a.a;
    }

    @Override // dl0.a
    public final dl0.c b() {
        return a;
    }

    @Override // dl0.a
    public final void c(View r3) {
        Intrinsics.checkNotNullParameter(r3, "view");
        WeakReference<WaitingListUser> r0 = b;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("data");
    L5:
        WaitingListUser r1 = r0.get();
        if (r1 != null) goto L8;
        return;
    L8:
        MicPosTagInfo r2 = r1.getMicPosTag();
        if (r2 != null) goto L11;
        return;
    L11:
        TextView r4 = (TextView) r3.findViewById(2131390752);
        if (r4 == null) goto L14;
        r4.setText(r2.getPositionTagName());
    L14:
        el0.j.a(r4);
        if (r4 == null) goto L17;
        Integer r5 = Integer.valueOf(r4.getVisibility());
    L19:
        if (r5.intValue() == 0) goto L22;
        if (r4 == null) goto L22;
        r4.setVisibility(0);
    L22:
        if (r4 == null) goto L25;
        r4.setOnClickListener(new b());
        return;
    L25:
        return;
    L17:
        r5 = null;
        goto L19
    }

    @Override // dl0.a
    public final View a(Context r3, ViewGroup r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "parent");
        return LayoutInflater.from(r3).inflate(2131565212, r4, false);
    }
}
