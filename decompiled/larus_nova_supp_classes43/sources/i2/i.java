package i2;

import android.graphics.Rect;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ai.model.RenderType;
import com.bytedance.ai.model.k;
import com.bytedance.ai.model.objects.Applet;
import com.bytedance.ai.model.objects.PageInfo;
import com.bytedance.ai.model.objects.PageType;
import com.bytedance.android.ec.base.api.ai.AIStateLogRequest;
import k2.n;
import k2.s;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class i extends g {
    public static j a;
    public static final Lazy<i> b = null;

    public static final class a {
        public static i a() {
            return (i) i.b.getValue();
        }
    }

    static {
        b = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, new h());
    }

    @Override // i2.g, i2.j
    public final Rect b() {
        j r0 = a;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.b();
    }

    @Override // i2.j
    public final boolean e() {
        j r0 = a;
        if (r0 != null) goto L5;
    L7:
        boolean r1 = false;
    L8:
        if (r1 == true) goto L11;
        Lazy<f> r10 = f.i;
        if (f.a.a().e() == true) goto L11;
        return false;
    L11:
        return true;
    L5:
        if (r0.e() != true) goto L7;
        r1 = true;
        goto L8
    }

    @Override // i2.j
    public final boolean h() {
        j r0 = a;
        if (r0 != null) goto L5;
    L7:
        boolean r1 = false;
    L8:
        if (r1 == true) goto L11;
        Lazy<f> r10 = f.i;
        if (f.a.a().h() == true) goto L11;
        return false;
    L11:
        return true;
    L5:
        if (r0.h() != true) goto L7;
        r1 = true;
        goto L8
    }

    @Override // i2.j
    public final s j() {
        j r0 = a;
        if (r0 == null) goto L6;
        s r1 = r0.j();
        if (r1 == null) goto L6;
        return r1;
    L6:
        Lazy<f> r10 = f.i;
        return f.a.a().f;
    }

    public i() {
    }

    @Override // i2.j
    public final boolean g(String r10) {
        Intrinsics.checkNotNullParameter(r10, "viewId");
        com.bytedance.ai.utils.g.a.i("FloatingViewManagerDelegate", "remove floating window");
        j r0 = a;
        if (r0 == null) goto L5;
        r0.g(r10);
    L5:
        Lazy<f> r1 = f.i;
        if (f.a.a().h() == true) goto L8;
        return true;
    L8:
        return f.a.a().g(r10);
    }

    @Override // i2.j
    public final boolean a(String r10, boolean r11) {
        Intrinsics.checkNotNullParameter(r10, "viewId");
        j r0 = a;
        if (r0 == null) goto L5;
        r0.a(r10, r11);
    L5:
        Lazy<f> r1 = f.i;
        f.a.a().a(r10, r11);
        return true;
    }

    @Override // i2.j
    public final boolean c(String r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "pageName");
        Intrinsics.checkNotNullParameter(r11, "packageName");
        j r0 = a;
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.c(r10, r11);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // i2.j
    public final int d(s r10, PageInfo r11, FragmentActivity r12) {
        Intrinsics.checkNotNullParameter(r10, AIStateLogRequest.SOURCE_PAGE);
        Intrinsics.checkNotNullParameter(r11, "pageInfo");
        String r1 = null;
        if ((r10 instanceof com.bytedance.ai.model.widgets.c) == false) goto L5;
        com.bytedance.ai.model.widgets.c r0 = (com.bytedance.ai.model.widgets.c) r10;
    L6:
        if (r0 == null) goto L9;
        r1 = r0.getRenderType();
    L9:
        if (Intrinsics.areEqual(r1, RenderType.LYNX.getTypeName()) == false) goto L14;
        j r13 = a;
        if (r13 != null) goto L16;
        return 0;
    L16:
        return r13.d(r10, r11, r12);
    L14:
        Lazy<f> r14 = f.i;
        return f.a.a().d(r10, r11, r12);
    L5:
        r0 = null;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // i2.j
    public final void f(s r10, int r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, AIStateLogRequest.SOURCE_PAGE);
        String r1 = null;
        if ((r10 instanceof com.bytedance.ai.model.widgets.c) == false) goto L5;
        com.bytedance.ai.model.widgets.c r0 = (com.bytedance.ai.model.widgets.c) r10;
    L6:
        if (r0 == null) goto L9;
        r1 = r0.getRenderType();
    L9:
        if (Intrinsics.areEqual(r1, RenderType.LYNX.getTypeName()) == false) goto L13;
        j r13 = a;
        if (r13 == null) goto L15;
        r13.f(r10, r11, r12);
        return;
    L15:
        return;
    L13:
        Lazy<f> r14 = f.i;
        f.a.a().f(r10, r11, r12);
        return;
    L5:
        r0 = null;
        goto L6
    }

    public final boolean k(Applet r10, PageInfo r11, k r12) {
        Intrinsics.checkNotNullParameter(r10, "applet");
        Intrinsics.checkNotNullParameter(r11, "pageInfo");
        PageType r13 = r11.getPageType();
        PageType r14 = PageType.FLOATING_VIEW;
        if (r13 == r14) goto L6;
        return true;
    L6:
        if (Intrinsics.areEqual(n.b(r10, r11), RenderType.LYNX.getTypeName()) == true) goto L30;
        Intrinsics.checkNotNullParameter(r10, "applet");
        Intrinsics.checkNotNullParameter(r11, "pageInfo");
        if (r11.getPageType() == r14) goto L11;
        return true;
    L11:
        if (h() == false) goto L37;
        String r15 = r11.getPageName();
        s r0 = j();
        if (r0 == null) goto L17;
        PageInfo r1 = r0.getPageInfo();
        if (r1 == null) goto L17;
        String r16 = r1.getPageName();
    L19:
        if (Intrinsics.areEqual(r15, r16) == false) goto L22;
        r12.invoke("already hasFloatingView " + r11.getPageName());
    L21:
        return false;
    L22:
        s r17 = j();
        if (r17 == null) goto L27;
        String r18 = r17.getPageID();
        if (r18 == null) goto L27;
        boolean r19 = g(r18);
    L28:
        if (r19 == true) goto L39;
        r12.invoke("hasFloatingView and close current floating failed");
        goto L21
    L39:
        return true;
    L27:
        r19 = false;
    L17:
        r16 = null;
        goto L19
    L37:
        return true;
    L30:
        String r20 = r11.getPageName();
        if (r20 == null) goto L40;
        boolean r21 = c(r20, r11.getPackageName());
        if (r21 == false) goto L36;
        r12.invoke("already hasFloatingView " + r11.getPageName());
    L36:
        return true ^ r21;
    L40:
        return true;
    }
}
