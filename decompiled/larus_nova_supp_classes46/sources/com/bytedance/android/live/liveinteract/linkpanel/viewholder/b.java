package com.bytedance.android.live.liveinteract.linkpanel.viewholder;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.bytedance.android.live.liveinteract.linkpanel.util.m;
import com.bytedance.android.live.liveinteract.linkpanel.util.o;
import com.bytedance.android.live.liveinteract.plantform.model.g0;
import com.bytedance.android.live.liveinteract.plantform.model.n0;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import java.lang.ref.WeakReference;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class b implements com.bytedance.android.live.liveinteract.linkpanel.util.a<com.bytedance.android.live.liveinteract.linkpanel.util.c.AbstractC0043c, n0> {
    public static WeakReference<n0> a;
    public static final b b = null;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ Function1 a;

        public a(Function1 r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            Function1 r0 = this.a;
            if (r0 == null) goto L6;
            Unit r3 = (Unit) r0.invoke(r2);
            return;
        }
    }

    public b() {
    }

    @Override // com.bytedance.android.live.liveinteract.linkpanel.util.a
    public final String c() {
        return "";
    }

    static {
        b = new b();
    }

    @Override // com.bytedance.android.live.liveinteract.linkpanel.util.a
    public final com.bytedance.android.live.liveinteract.linkpanel.util.c b() {
        com.bytedance.android.live.liveinteract.linkpanel.util.f.c.getClass();
        return com.bytedance.android.live.liveinteract.linkpanel.util.f.a;
    }

    @Override // com.bytedance.android.live.liveinteract.linkpanel.util.a
    public final View a(Context r2, ViewGroup r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "parent");
        return com.bytedance.android.live.liveinteract.linkpanel.util.f.c.a(r2, r3);
    }

    @Override // com.bytedance.android.live.liveinteract.linkpanel.util.a
    public final void d(View r3, Function1<? super View, Unit> r4) {
        Intrinsics.checkNotNullParameter(r3, "view");
        WeakReference<n0> r0 = a;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("data");
    L5:
        n0 r1 = r0.get();
        if (r1 != null) goto L8;
        return;
    L8:
        g0 r2 = r1.getMicPosTagFlex();
        if (r2 != null) goto L11;
        return;
    L11:
        TextView r5 = (TextView) r3.findViewById(2131390752);
        if (r5 == null) goto L14;
        Integer r6 = Integer.valueOf(r5.getVisibility());
    L16:
        if (r6.intValue() == 0) goto L20;
        if (r5 == null) goto L19;
        r5.setVisibility(0);
    L19:
        m.n("waiting_list", r2);
    L20:
        if (r5 == null) goto L22;
        r5.setText(r2.getPositionTagName());
    L22:
        o.a(r5, r2);
        if (TextUtils.isEmpty(r2.getTextColor()) == true) goto L26;
        if (r5 == null) goto L26;
        r5.setTextColor(ColorProtector.parseColor(r2.getTextColor()));
    L26:
        if (r5 == null) goto L29;
        r5.setOnClickListener(new a(r4));
        return;
    L29:
        return;
    L14:
        r6 = null;
        goto L16
    }
}
