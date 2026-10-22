package com.bytedance.android.live.liveinteract.linkpanel.util;

import android.content.Context;
import android.graphics.drawable.Animatable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.live.core.utils.p0;
import com.bytedance.android.live.core.widget.HSImageView;
import com.facebook.imagepipeline.image.ImageInfo;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class y implements com.bytedance.android.live.liveinteract.linkpanel.util.a<c.e, IBaseUser> {
    public static final c.e a = null;
    public static WeakReference<IBaseUser> b;
    public static final y c = null;

    public static final class a implements p0 {
        public final /* synthetic */ HSImageView a;

        public a(HSImageView r1) {
            this.a = r1;
        }

        public final /* synthetic */ void a(ImageInfo r1, Animatable r2) {
        }

        public final /* synthetic */ void b(py.k r1, Exception r2) {
        }

        public final /* synthetic */ void d(ImageInfo r1) {
        }

        public final /* synthetic */ void e(py.k r1) {
        }

        public final void c(py.k r1, int r2, int r3, boolean r4) {
            this.a.setAspectRatio(r2 / r3);
        }
    }

    public y() {
    }

    @Override // com.bytedance.android.live.liveinteract.linkpanel.util.a
    public final String c() {
        return "";
    }

    static {
        c = new y();
        a = c.e.a;
    }

    public final boolean e() {
        Object r2 = null;
        if (((Number) vm2.d.e1.getValue(null, vm2.d.a[106(0x6a, float:1.49E-43)])).intValue() != 0) goto L5;
        return false;
    L5:
        WeakReference<IBaseUser> r0 = b;
        if (r0 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("data");
    L8:
        IBaseUser r1 = r0.get();
        if (r1 != null) goto L11;
        return false;
    L11:
        List r3 = r1.getBadgeImageListV2();
        if (r3 == null) goto L26;
        Iterator r4 = r3.iterator();
    L15:
        if (r4.hasNext() == false) goto L25;
        Object r5 = r4.next();
        Integer r6 = ((py.k) r5).getImageType();
        if (r6 != null) goto L20;
    L22:
        boolean r7 = false;
    L23:
        if (r7 == false) goto L15;
        r2 = r5;
        goto L25
    L20:
        if (r6.intValue() != 59) goto L22;
        r7 = true;
    L25:
        r2 = (py.k) r2;
    L26:
        if (r2 == null) goto L34;
        return true;
    L34:
        return false;
    }

    @Override // com.bytedance.android.live.liveinteract.linkpanel.util.a
    public final c b() {
        return a;
    }

    public final void f(IBaseUser r2) {
        b = new WeakReference(r2);
    }

    @Override // com.bytedance.android.live.liveinteract.linkpanel.util.a
    public final View a(Context r3, ViewGroup r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "parent");
        return LayoutInflater.from(r3).inflate(2131565216, r4, false);
    }

    @Override // com.bytedance.android.live.liveinteract.linkpanel.util.a
    public final void d(View r6, Function1<? super View, Unit> r7) {
        Intrinsics.checkNotNullParameter(r6, "view");
        HSImageView r8 = r6.findViewById(2131376647);
        WeakReference<IBaseUser> r9 = b;
        if (r9 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("data");
    L5:
        IBaseUser r10 = r9.get();
        py.k r1 = null;
        Object r2 = null;
        r1 = null;
        if (r10 == null) goto L22;
        List r11 = r10.getBadgeImageListV2();
        if (r11 == null) goto L22;
        Iterator r12 = r11.iterator();
    L11:
        if (r12.hasNext() == false) goto L21;
        Object r3 = r12.next();
        Integer r4 = ((py.k) r3).getImageType();
        if (r4 != null) goto L16;
    L18:
        boolean r5 = false;
    L19:
        if (r5 == false) goto L11;
        r2 = r3;
        goto L21
    L16:
        if (r4.intValue() != 59) goto L18;
        r5 = true;
    L21:
        r1 = (py.k) r2;
    L22:
        ImageUtil.loadImage(r8, r1, new a(r8));
        r8.setVisibility(0);
    }
}
