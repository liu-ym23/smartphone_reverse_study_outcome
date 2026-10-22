package com.bytedance.android.live.liveinteract.linkpanel.util;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.a1;
import com.bytedance.android.live.core.utils.q0;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class x implements com.bytedance.android.live.liveinteract.linkpanel.util.a<c.d, IBaseUser> {
    public static WeakReference<IBaseUser> a;
    public static WeakReference<List<com.bytedance.android.live.liveinteract.plantform.model.v>> b;
    public static String c;
    public static final c.d d = null;
    public static final x e = null;

    public static final class a extends q0 {
        public final /* synthetic */ HSImageView a;

        public a(HSImageView r1) {
            this.a = r1;
        }

        public final void h(py.k r2, int r3, int r4) {
            HSImageView r5 = this.a;
            a1.p(r5, (a1.d(r5) * r3) / r4);
        }
    }

    public x() {
    }

    static {
        e = new x();
        c = "";
        d = c.d.a;
    }

    public final boolean e() {
        WeakReference<IBaseUser> r0 = a;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("data");
    L5:
        IBaseUser r1 = r0.get();
        if (r1 != null) goto L8;
        return false;
    L8:
        py.j r2 = r1.getFollowInfo();
        py.k r3 = null;
        if (r2 == null) goto L11;
        Long r4 = Long.valueOf(r2.getFollowStatus());
    L12:
        WeakReference<List<com.bytedance.android.live.liveinteract.plantform.model.v>> r5 = b;
        if (r5 == null) goto L31;
        List<com.bytedance.android.live.liveinteract.plantform.model.v> r6 = r5.get();
        if (r6 == null) goto L31;
        Iterator<T> r7 = r6.iterator();
    L18:
        if (r7.hasNext() == false) goto L25;
        Object r8 = r7.next();
        if (((com.bytedance.android.live.liveinteract.plantform.model.v) r8).getType() != 4) goto L22;
        boolean r9 = true;
    L23:
        if (r9 == false) goto L18;
    L26:
        com.bytedance.android.live.liveinteract.plantform.model.v r10 = (com.bytedance.android.live.liveinteract.plantform.model.v) r8;
        if (r10 == null) goto L31;
        com.bytedance.android.live.liveinteract.plantform.model.x r11 = r10.getEcomViewTag();
        if (r11 == null) goto L31;
        r3 = r11.getEcomViewTag();
        goto L31
    L22:
        r9 = false;
        goto L23
    L25:
        r8 = null;
    L31:
        if (r4 != null) goto L34;
    L35:
        if (r4 != null) goto L38;
    L39:
        if (r3 != null) goto L41;
        return false;
    L41:
        if (r3.isValid() != true) goto L50;
    L42:
        return true;
    L50:
        return false;
    L38:
        if (r4.longValue() == 3) goto L42;
    L34:
        if (r4.longValue() == 2) goto L42;
    L11:
        r4 = null;
        goto L12
    }

    @Override // com.bytedance.android.live.liveinteract.linkpanel.util.a
    public final c b() {
        return d;
    }

    @Override // com.bytedance.android.live.liveinteract.linkpanel.util.a
    public final String c() {
        return c;
    }

    @Override // com.bytedance.android.live.liveinteract.linkpanel.util.a
    public final View a(Context r3, ViewGroup r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "parent");
        return LayoutInflater.from(r3).inflate(2131565215, r4, false);
    }

    @Override // com.bytedance.android.live.liveinteract.linkpanel.util.a
    public final void d(View r12, Function1<? super View, Unit> r13) {
        Intrinsics.checkNotNullParameter(r12, "view");
        WeakReference<IBaseUser> r14 = a;
        if (r14 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("data");
    L5:
        IBaseUser r15 = r14.get();
        if (r15 != null) goto L8;
        return;
    L8:
        py.j r16 = r15.getFollowInfo();
        if (r16 == null) goto L11;
        Long r17 = Long.valueOf(r16.getFollowStatus());
    L12:
        WeakReference<List<com.bytedance.android.live.liveinteract.plantform.model.v>> r1 = b;
        if (r1 == null) goto L31;
        List<com.bytedance.android.live.liveinteract.plantform.model.v> r2 = r1.get();
        if (r2 == null) goto L31;
        Iterator<T> r3 = r2.iterator();
    L18:
        if (r3.hasNext() == false) goto L25;
        Object r4 = r3.next();
        if (((com.bytedance.android.live.liveinteract.plantform.model.v) r4).getType() != 4) goto L22;
        boolean r5 = true;
    L23:
        if (r5 == false) goto L18;
    L26:
        com.bytedance.android.live.liveinteract.plantform.model.v r6 = (com.bytedance.android.live.liveinteract.plantform.model.v) r4;
        if (r6 == null) goto L31;
        com.bytedance.android.live.liveinteract.plantform.model.x r7 = r6.getEcomViewTag();
        if (r7 == null) goto L31;
        py.k r8 = r7.getEcomViewTag();
    L32:
        TextView r9 = (TextView) r12.findViewById(2131390667);
        HSImageView r10 = r12.findViewById(2131376655);
        r9.setTextColor(s1.h(2131108569));
        r9.setPadding((int) s1.e(6.0f), 0, (int) s1.e(6.0f), 0);
        if (r17 != null) goto L36;
    L38:
        if (r17 != null) goto L41;
    L43:
        if (r8 != null) goto L45;
        return;
    L45:
        if (r8.isValid() != true) goto L56;
        UtilityKotlinExtentionsKt.w(r10);
        UtilityKotlinExtentionsKt.u(r9);
        r12.setBackground(null);
        ImageUtil.loadImage(r10, r8, new a(r10));
        c = "frequently_browse";
        return;
    L56:
        return;
    L41:
        if (r17.longValue() != 3) goto L43;
        UtilityKotlinExtentionsKt.w(r9);
        UtilityKotlinExtentionsKt.u(r10);
        r12.setBackgroundResource(2131248856);
        r9.setText(s1.B(2131923024));
        c = "fan_label";
        return;
    L36:
        if (r17.longValue() != 2) goto L38;
        UtilityKotlinExtentionsKt.w(r9);
        UtilityKotlinExtentionsKt.u(r10);
        r12.setBackgroundResource(2131248856);
        r9.setText(s1.B(2131923026));
        return;
    L22:
        r5 = false;
        goto L23
    L25:
        r4 = null;
    L31:
        r8 = null;
        goto L32
    L11:
        r17 = null;
        goto L12
    }
}
