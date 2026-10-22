package com.bytedance.android.live.liveinteract.linkpanel.util;

import android.content.Context;
import android.graphics.drawable.NinePatchDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.livesdk.chatroom.utils.a3;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class d implements com.bytedance.android.live.liveinteract.linkpanel.util.a<c.a, com.bytedance.android.live.profit.fansclub.b> {
    public static final c.a a = null;
    public static WeakReference<com.bytedance.android.live.profit.fansclub.b> b;
    public static final d c = null;

    public static final class a implements a3.b {
        public final /* synthetic */ TextView a;
        public final /* synthetic */ com.bytedance.android.live.profit.fansclub.b b;

        public final void onFail() {
        }

        public final void a(NinePatchDrawable r2) {
            Intrinsics.checkNotNullParameter(r2, "ninePatchDrawable");
            this.a.setText(this.b.a);
        }

        public a(TextView r1, com.bytedance.android.live.profit.fansclub.b r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public d() {
    }

    @Override // com.bytedance.android.live.liveinteract.linkpanel.util.a
    public final String c() {
        return "";
    }

    static {
        c = new d();
        a = c.a.a;
    }

    public final boolean f() {
        WeakReference<com.bytedance.android.live.profit.fansclub.b> r0 = b;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("data");
    L5:
        com.bytedance.android.live.profit.fansclub.b r1 = r0.get();
        if (r1 == null) goto L8;
        py.k r2 = r1.b();
    L9:
        if (r2 == null) goto L11;
        return true;
    L11:
        return false;
    L8:
        r2 = null;
        goto L9
    }

    @Override // com.bytedance.android.live.liveinteract.linkpanel.util.a
    public final c b() {
        return a;
    }

    public final void g(com.bytedance.android.live.profit.fansclub.b r2) {
        b = new WeakReference(r2);
    }

    public static com.bytedance.android.live.profit.fansclub.b e(IBaseUser r10, List r11) {
        Intrinsics.checkNotNullParameter(r10, "user");
        com.bytedance.android.live.profit.fansclub.a r2 = null;
        if (r11 == null) goto L17;
        Iterator r12 = r11.iterator();
    L6:
        if (r12.hasNext() == false) goto L13;
        Object r3 = r12.next();
        if (((com.bytedance.android.live.liveinteract.plantform.model.v) r3).getType() != 5) goto L10;
        boolean r4 = true;
    L11:
        if (r4 == false) goto L6;
    L14:
        com.bytedance.android.live.liveinteract.plantform.model.v r5 = (com.bytedance.android.live.liveinteract.plantform.model.v) r3;
        if (r5 == null) goto L17;
        com.bytedance.android.live.liveinteract.plantform.model.w r13 = r5.getEcomFansClubTag();
    L18:
        if (r13 == null) goto L26;
        py.k r6 = r13.getEcomFansClubTag();
        if (r6 == null) goto L26;
        if (r6.isValid() != true) goto L26;
        return new com.bytedance.android.live.profit.fansclub.b(r13.getClubName(), 0, new com.bytedance.android.live.profit.fansclub.j(0), new com.bytedance.android.live.profit.fansclub.a(r13.getClubName(), r13.getEcomFansClubTag()), null);
    L26:
        if (((Number) vm2.d.e1.getValue(null, vm2.d.a[106(0x6a, float:1.49E-43)])).intValue() != 0) goto L33;
        com.bytedance.android.live.profit.fansclub.o r14 = yt0.c.c();
        if (r14 == null) goto L60;
        com.bytedance.android.live.profit.fansclub.g r15 = r14.P5(r10);
        if (r15 != null) goto L32;
        return null;
    L32:
        return r15.a;
    L60:
        return null;
    L33:
        com.bytedance.android.live.profit.fansclub.o r16 = yt0.c.c();
        if (r16 == null) goto L38;
        com.bytedance.android.live.profit.fansclub.g r17 = r16.P5(r10);
        if (r17 == null) goto L38;
        com.bytedance.android.live.profit.fansclub.b r18 = r17.a;
    L39:
        if (r18 == null) goto L62;
        com.bytedance.android.live.base.model.user.t r19 = r10.getFansClub();
        if (r19 == null) goto L63;
        py.h r110 = r19.getData();
        if (r110 == null) goto L64;
        py.u r111 = r110.getBadge();
        if (r111 == null) goto L65;
        Map r112 = r111.getIcons();
        if (r112 == null) goto L66;
        py.k r113 = (py.k) r112.get(4);
        if (r113 == null) goto L67;
        r113.setImageType(51);
        com.bytedance.android.live.profit.fansclub.a r0 = r18.d;
        if (r0 == null) goto L54;
        r2 = com.bytedance.android.live.profit.fansclub.a.a(r0, r113);
    L54:
        return com.bytedance.android.live.profit.fansclub.b.a(r18, r2);
    L67:
        return null;
    L66:
        return null;
    L65:
        return null;
    L64:
        return null;
    L63:
        return null;
    L62:
        return null;
    L38:
        r18 = null;
        goto L39
    L10:
        r4 = false;
        goto L11
    L13:
        r3 = null;
    L17:
        r13 = null;
        goto L18
    }

    @Override // com.bytedance.android.live.liveinteract.linkpanel.util.a
    public final View a(Context r3, ViewGroup r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "parent");
        return LayoutInflater.from(r3).inflate(2131565205, r4, false);
    }

    @Override // com.bytedance.android.live.liveinteract.linkpanel.util.a
    public final void d(View r4, Function1<? super View, Unit> r5) {
        Intrinsics.checkNotNullParameter(r4, "view");
        WeakReference<com.bytedance.android.live.profit.fansclub.b> r6 = b;
        if (r6 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("data");
    L5:
        com.bytedance.android.live.profit.fansclub.b r7 = r6.get();
        if (r7 != null) goto L8;
        return;
    L8:
        FrameLayout r0 = (FrameLayout) r4.findViewById(2131372116);
        TextView r8 = (TextView) r4.findViewById(2131390602);
        py.k r1 = r7.b();
        r0.setVisibility(0);
        int r2 = a3.d;
        a3.a.a(r0, r1, new a(r8, r7), 0.0f);
    }
}
