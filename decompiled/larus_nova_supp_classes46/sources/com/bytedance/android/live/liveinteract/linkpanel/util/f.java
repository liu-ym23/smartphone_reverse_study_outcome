package com.bytedance.android.live.liveinteract.linkpanel.util;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.plantform.model.g0;
import com.bytedance.android.livesdk.utils.r2;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import java.lang.ref.WeakReference;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class f implements com.bytedance.android.live.liveinteract.linkpanel.util.a<c.AbstractC0043c, ILinkPlayerInfoBridge> {
    public static final c.AbstractC0043c.b a = null;
    public static WeakReference<ILinkPlayerInfoBridge> b;
    public static final f c = null;

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

    public f() {
    }

    @Override // com.bytedance.android.live.liveinteract.linkpanel.util.a
    public final String c() {
        return "";
    }

    static {
        c = new f();
        a = c.AbstractC0043c.b.a;
    }

    public final boolean e() {
        WeakReference<ILinkPlayerInfoBridge> r0 = b;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("data");
    L5:
        ILinkPlayerInfoBridge r1 = r0.get();
        if (r1 == null) goto L16;
        g0 r2 = r1.getMicPosTagInfo();
        if (r2 != null) goto L11;
        return false;
    L11:
        if (r2.getTagType() > 0) goto L13;
        return false;
    L13:
        if (r2.a(r2.getPositionTagName()) == false) goto L18;
        return true;
    L18:
        return false;
    L16:
        return false;
    }

    @Override // com.bytedance.android.live.liveinteract.linkpanel.util.a
    public final c b() {
        return a;
    }

    @Override // com.bytedance.android.live.liveinteract.linkpanel.util.a
    public final View a(Context r3, ViewGroup r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "parent");
        return LayoutInflater.from(r3).inflate(2131565209, r4, false);
    }

    @Override // com.bytedance.android.live.liveinteract.linkpanel.util.a
    public final void d(View r4, Function1<? super View, Unit> r5) {
        Intrinsics.checkNotNullParameter(r4, "view");
        WeakReference<ILinkPlayerInfoBridge> r0 = b;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("data");
    L5:
        ILinkPlayerInfoBridge r1 = r0.get();
        if (r1 != null) goto L8;
        return;
    L8:
        g0 r2 = r1.getMicPosTagInfo();
        if (r2 != null) goto L11;
        return;
    L11:
        TextView r6 = (TextView) r4.findViewById(2131390752);
        if (r6 == null) goto L14;
        r6.setText(r2.getPositionTagName());
    L14:
        o.a(r6, r2);
        if (TextUtils.isEmpty(r2.getTextColor()) == true) goto L18;
        if (r6 == null) goto L18;
        r6.setTextColor(ColorProtector.parseColor(r2.getTextColor()));
    L18:
        if (r6 == null) goto L20;
        Integer r3 = Integer.valueOf(r6.getVisibility());
    L22:
        if (r3.intValue() == 0) goto L28;
        if (r6 == null) goto L26;
        r6.setVisibility(0);
    L26:
        if (r1.isHasExposed() == true) goto L28;
        m.n("apply_list", r2);
    L28:
        if (r6 == null) goto L31;
        r6.setOnClickListener(new a(r5));
        return;
    L31:
        return;
    L20:
        r3 = null;
        goto L22
    }
}
