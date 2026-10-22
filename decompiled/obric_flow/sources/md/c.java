package md;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import av.i;
import com.bytedance.ies.bullet.core.e;
import com.bytedance.ies.bullet.core.f;
import com.bytedance.ies.bullet.service.sdk.d;
import com.lynx.tasm.utils.g;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f20064a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final e f20065b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Uri f20066c;
    public final Bundle d;
    public int e;
    public int f;
    public int g;

    public c(String r10, Uri r11, Bundle r12, Context r13) {
        Intrinsics.checkNotNullParameter(r10, "bid");
        Intrinsics.checkNotNullParameter(r11, "url");
        Intrinsics.checkNotNullParameter(r12, "bundle");
        Intrinsics.checkNotNullParameter(r13, "context");
        this.f20066c = r11;
        this.d = r12;
        this.e = 300;
        this.f = -1;
        this.g = -1;
        Lazy r5 = f.f5312b;
        e r14 = td.b.b().b(r10, r11, r12, false, null);
        this.f20065b = r14;
        this.f20064a = r14.getSessionId();
        Lazy r15 = com.bytedance.android.anniex.base.depend.a.f3114c;
        ((com.bytedance.android.anniex.base.depend.c) r15.getValue()).getClass();
        ((com.bytedance.android.anniex.base.depend.c) r15.getValue()).getClass();
        if ((r13 instanceof Activity) == false) goto L6;
        a(r13);
        return;
    }

    public final void a(Context r10) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Lazy r5 = d.e;
        d r11 = i.e();
        e r12 = this.f20065b;
        rd.b r13 = r12.g.f21723a;
        r11.getClass();
        d.b(r13, td.d.class);
        if (xq.b.o() == true) goto L5;
        r12.g.getClass();
    L5:
        this.e = (int) (((double) 1000) * 0.3d);
        int r14 = g.b(g.e(r10).f20226a, r10);
        Resources r15 = r10.getResources();
        int r16 = 0;
        if (r15 == null) goto L10;
        Configuration r17 = r15.getConfiguration();
        if (r17 == null) goto L10;
        int r18 = r17.screenWidthDp;
    L11:
        int r19 = g.b(r18, r10);
        int r20 = g.b(g.e(r10).f20226a, r10);
        int r21 = com.bytedance.ies.bullet.base.utils.logger.a.f5258a;
        com.bytedance.ies.bullet.base.utils.logger.a.c("PopupLog", "initWidth: 窗口宽度 = " + r19 + "px = " + r18 + "dp");
        com.bytedance.ies.bullet.base.utils.logger.a.c("PopupLog", "initWidth: 默认宽度, 线上默认尺寸 match_parent");
        if ((-1) <= r20) goto L14;
        com.bytedance.ies.bullet.base.utils.logger.a.c("PopupLog", "initWidth: 超过窗口宽度, 弹窗宽度 = match_parent");
    L15:
        int r22 = g.b(g.e(r10).f20227b, r10);
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r10, "context");
        int r23 = r10.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (r23 <= 0) goto L19;
        r10.getResources().getDimensionPixelSize(r23);
    L19:
        if ((r10 instanceof Activity) == false) goto L21;
        Activity r24 = (Activity) r10;
    L22:
        if (r24 == null) goto L31;
        Window r25 = r24.getWindow();
        if (r25 == null) goto L31;
        Rect r26 = new Rect();
        r25.getDecorView().getWindowVisibleDisplayFrame(r26);
        int r27 = r26.top;
        int r28 = r26.bottom;
        if (r25.getDecorView().getHeight() == 0) goto L28;
    L30:
        r22 = r28;
        Unit r29 = Unit.INSTANCE;
        goto L31
    L28:
        if (r26.top != 0) goto L30;
        r28 = r28 + r27;
    L31:
        this.f = r22;
        this.g = r14;
        Resources r30 = r10.getResources();
        if (r30 == null) goto L36;
        Configuration r31 = r30.getConfiguration();
        if (r31 == null) goto L36;
        int r32 = r31.screenWidthDp;
    L37:
        Resources r33 = r10.getResources();
        if (r33 == null) goto L42;
        Configuration r34 = r33.getConfiguration();
        if (r34 == null) goto L42;
        r16 = r34.screenHeightDp;
    L42:
        com.bytedance.ies.bullet.base.utils.logger.a.c("PopupLog", "initHeight: 窗口宽高 = (" + g.b(r32, r10) + "px, " + g.b(r16, r10) + "px) = (" + r32 + "dp, " + r16 + "dp)");
        com.bytedance.ies.bullet.base.utils.logger.a.c("PopupLog", "initHeight: 默认高度, 线上默认尺寸 match_parent");
        if ((-1) <= this.f) goto L45;
        com.bytedance.ies.bullet.base.utils.logger.a.c("PopupLog", "initHeight: 超过窗口高度, 弹窗高度 = match_parent");
    L46:
        Activity r35 = ug.a.a(r10);
        if (r35 == null) goto L53;
        Window r36 = r35.getWindow();
        if (r36 == null) goto L53;
        View r37 = r36.getDecorView();
        if (r37 == null) goto L53;
        g.h(r37.getWidth(), r10);
    L53:
        com.bytedance.ies.bullet.base.utils.logger.a.c("PopupLog", "initRadius: 弹窗圆角 = 0px");
        return;
    L45:
        com.bytedance.ies.bullet.base.utils.logger.a.c("PopupLog", "initHeight: 弹窗高度 = -1px");
    L36:
        r32 = 0;
        goto L37
    L21:
        r24 = null;
        goto L22
    L14:
        com.bytedance.ies.bullet.base.utils.logger.a.c("PopupLog", "initWidth: 弹窗宽度 = -1px");
    L10:
        r18 = 0;
        goto L11
    }

    public final boolean b() {
        return Intrinsics.areEqual(new vd.a(this.f20065b.g.f21723a, "delay_open", null).f22372b, Boolean.TRUE);
    }

    public final boolean c() {
        return Intrinsics.areEqual(new vd.a(this.f20065b.g.f21723a, "scan_open", null).f22372b, Boolean.TRUE);
    }

    public final boolean d() {
        return Intrinsics.areEqual(new vd.a(this.f20065b.g.f21723a, "show_on_success", Boolean.FALSE).f22372b, Boolean.TRUE);
    }
}
