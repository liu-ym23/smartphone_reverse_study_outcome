package com.bytedance.android.live.liveinteract.linkpanel.util;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.widget.HSImageView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class e implements a<c.b, IBaseUser> {
    public static final c.b a = null;
    public static WeakReference<IBaseUser> b;
    public static final e c = null;

    public e() {
    }

    @Override // com.bytedance.android.live.liveinteract.linkpanel.util.a
    public final String c() {
        return "";
    }

    static {
        c = new e();
        a = c.b.a;
    }

    public final boolean f() {
        WeakReference<IBaseUser> r0 = b;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("user");
    L5:
        IBaseUser r1 = r0.get();
        if (r1 != null) goto L9;
        return false;
    L9:
        if (vm2.d.v() == false) goto L16;
        List r2 = e(r1);
        if (r2 != null) goto L13;
        return false;
    L13:
        if (r2.isEmpty() == true) goto L24;
        return true;
    L24:
        return false;
    L16:
        py.d r3 = r1.getUserHonor();
        if (r3 == null) goto L19;
        py.k r4 = r3.getNewImIconWithLevel();
    L20:
        if (r4 == null) goto L25;
        return true;
    L25:
        return false;
    L19:
        r4 = null;
        goto L20
    }

    @Override // com.bytedance.android.live.liveinteract.linkpanel.util.a
    public final c b() {
        return a;
    }

    public static List e(IBaseUser r7) {
        List r8 = r7.getBadgeImageListV2();
        if (r8 == null) goto L17;
        ArrayList r1 = new ArrayList();
        Iterator r9 = r8.iterator();
    L6:
        if (r9.hasNext() == false) goto L11;
        Object r2 = r9.next();
        if (CollectionsKt.contains((List) vm2.d.g1.getValue(null, vm2.d.a[108(0x6c, float:1.51E-43)]), ((py.k) r2).getImageType()) == false) goto L6;
        r1.add(r2);
        goto L6
    L11:
        return r1;
    L17:
        return null;
    }

    public final void g(IBaseUser r2) {
        b = new WeakReference(r2);
    }

    @Override // com.bytedance.android.live.liveinteract.linkpanel.util.a
    public final View a(Context r3, ViewGroup r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "parent");
        if (vm2.d.v() == false) goto L7;
        return LayoutInflater.from(r3).inflate(2131565208, r4, false);
    L7:
        return LayoutInflater.from(r3).inflate(2131565207, r4, false);
    }

    @Override // com.bytedance.android.live.liveinteract.linkpanel.util.a
    public final void d(View r10, Function1<? super View, Unit> r11) {
        Intrinsics.checkNotNullParameter(r10, "view");
        WeakReference<IBaseUser> r12 = b;
        if (r12 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("user");
    L5:
        IBaseUser r13 = r12.get();
        if (r13 != null) goto L9;
        return;
    L9:
        if (vm2.d.v() == false) goto L23;
        List r14 = e(r13);
        View r0 = r10.findViewById(2131374502);
        if (r0 != null) goto L14;
        return;
    L14:
        if ((r0 instanceof LinearLayout) == false) goto L40;
        LinearLayout r1 = (LinearLayout) r0;
        r1.removeAllViews();
        if (r14 == null) goto L22;
        Iterator r15 = r14.iterator();
    L20:
        if (r15.hasNext() == false) goto L41;
        py.k r3 = (py.k) r15.next();
        HSImageView r2 = new HSImageView(r10.getContext());
        r1.addView(r2, new LinearLayout.LayoutParams((int) UtilityKotlinExtentionsKt.h(r3.getWidth()), (int) UtilityKotlinExtentionsKt.h(r3.getHeight())));
        ImageUtil.loadImage(r2, r3, -1, -1, true, 0, null);
        goto L20
    L41:
        return;
    L22:
        return;
    L40:
        return;
    L23:
        HSImageView r16 = r10.findViewById(2131376293);
        r16.setVisibility(0);
        py.d r17 = r13.getUserHonor();
        if (r17 == null) goto L26;
        py.k r18 = r17.getNewImIconWithLevel();
    L27:
        if (r18 == null) goto L29;
        int r4 = r18.getWidth();
    L30:
        if (r18 == null) goto L32;
        int r5 = r18.getHeight();
    L33:
        if (r4 <= 0) goto L36;
        if (r5 <= 0) goto L36;
        ViewGroup.LayoutParams r6 = r16.getLayoutParams();
        r6.width = (int) UtilityKotlinExtentionsKt.h(r4);
        r6.height = (int) UtilityKotlinExtentionsKt.h(r5);
        Unit r7 = Unit.INSTANCE;
        r16.setLayoutParams(r6);
    L36:
        ImageUtil.loadImage(r16, r18, 0);
        return;
    L32:
        r5 = 0;
        goto L33
    L29:
        r4 = 0;
        goto L30
    L26:
        r18 = null;
        goto L27
    }
}
