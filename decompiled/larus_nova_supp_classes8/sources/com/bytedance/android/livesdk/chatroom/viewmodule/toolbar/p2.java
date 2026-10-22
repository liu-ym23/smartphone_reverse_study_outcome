package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar;

import com.ss.android.ugc.aweme.debug.LocalTestManager;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class p2 {
    public static final /* synthetic */ int q = 0;
    public boolean a;
    public boolean b;
    public boolean c;
    public boolean d;
    public boolean e;
    public boolean f;
    public boolean g;
    public boolean h;
    public boolean i;
    public boolean j;
    public boolean k;
    public boolean l;
    public boolean m;
    public boolean n;
    public boolean o;
    public ToolbarBroadcastFunction p;

    public static final class a {
    }

    static {
    }

    public final String toString() {
        LocalTestManager.a(new Class[]{wy.a.class});
        return "hasCommercePermission=" + this.b + ", hasCommerce=" + this.k + ", hasTransformWidgetPermission=" + this.e + ", hasAddTransformWidget=" + this.n + ", hasMiniAppPermission=" + this.a + ", hasMinApp=" + this.g + ", hasMixMiniApp=" + this.j + " hasWelfarePermission=" + this.d + ", hasWelfare=" + this.m + ", hasGamePromotePermission=" + this.c + ", hasGamePromote=" + this.l + ",  hasGroupPurchasePermission=" + this.f + ",  lastTriggered=" + this.p;
    }

    public final boolean a() {
        if (this.n == false) goto L5;
    L21:
        return false;
    L5:
        if (this.g == true) goto L21;
        if (this.k == true) goto L21;
        if (this.m == true) goto L21;
        if (this.l == true) goto L21;
        if (this.j == true) goto L21;
        if (this.i == true) goto L21;
        if (this.o == true) goto L21;
        if (this.h == true) goto L21;
        return true;
    }

    public final int c() {
        if (tb1.c.g == true) goto L5;
        return 0;
    L5:
        if (a() == false) goto L10;
        if (this.p != ToolbarBroadcastFunction.GAME_PROMOTE) goto L28;
    L8:
        return 1;
    L28:
        return 0;
    L10:
        if (this.k == false) goto L12;
        return 0;
    L12:
        if (this.n == false) goto L14;
        return 0;
    L14:
        if (this.g == false) goto L16;
        return 0;
    L16:
        if (this.i == false) goto L18;
        return 0;
    L18:
        if (this.m == false) goto L20;
        return 0;
    L20:
        if (this.c == true) goto L22;
        return 0;
    L22:
        if (this.j == false) goto L24;
        return 0;
    L24:
        if (this.o == false) goto L26;
        return 0;
    L26:
        if (this.h == false) goto L8;
        return 0;
    }

    public final int d() {
        if (tb1.c.g == true) goto L5;
        return 0;
    L5:
        if (a() == false) goto L10;
        if (this.p != ToolbarBroadcastFunction.GROUP_PURCHASE) goto L14;
    L8:
        return 1;
    L14:
        return 0;
    L10:
        if (this.n == false) goto L12;
        return 0;
    L12:
        if (this.o == true) goto L8;
        return 0;
    }

    public final int e() {
        if (tb1.c.a == true) goto L5;
        return 0;
    L5:
        if (this.j == false) goto L9;
        return 1;
    L9:
        return 0;
    }

    public final int f() {
        if (tb1.c.a == true) goto L5;
        return 0;
    L5:
        if (a() == false) goto L12;
        if (this.p == ToolbarBroadcastFunction.MINI_APP) goto L9;
        return 0;
    L9:
        if (this.a == false) goto L33;
    L10:
        return 1;
    L33:
        return 0;
    L12:
        if (b() == 0) goto L14;
        return 0;
    L14:
        if (this.h == false) goto L16;
        return 0;
    L16:
        if (this.a == true) goto L18;
        return 0;
    L18:
        if (this.n == false) goto L20;
        return 0;
    L20:
        if (this.m == false) goto L22;
        return 0;
    L22:
        if (this.l == false) goto L26;
        if (this.g == true) goto L26;
        return 0;
    L26:
        if (this.i == false) goto L28;
        return 0;
    L28:
        if (this.j == false) goto L30;
        return 0;
    L30:
        if (this.o == false) goto L10;
        return 0;
    }

    public final int g() {
        if (tb1.c.a == true) goto L5;
        return 0;
    L5:
        if (this.i == false) goto L9;
        return 1;
    L9:
        return 0;
    }

    public final int h() {
        if (tb1.c.a == true) goto L5;
        return 0;
    L5:
        if (a() == false) goto L10;
        if (this.p != ToolbarBroadcastFunction.TRANSFORM_WIDGET) goto L12;
        return 1;
    L12:
        return 0;
    L10:
        return this.n ? 1 : 0;
    }

    public p2() {
        this.p = ToolbarBroadcastFunction.COMMERCE;
    }

    public final int b() {
        if (a() == false) goto L8;
        if (this.p == ToolbarBroadcastFunction.COMMERCE) goto L30;
    L27:
        return 0;
    L30:
        return 1;
    L8:
        if (this.h == true) goto L27;
        if (this.n == true) goto L27;
        if (this.g == true) goto L27;
        if (this.m == true) goto L27;
        if (this.i == true) goto L27;
        if (this.l == false) goto L22;
        if (this.k == false) goto L27;
    L22:
        if (this.b == false) goto L27;
        if (this.j == true) goto L27;
        if (this.o == true) goto L27;
        return 1;
    }

    public final int i() {
        if (yt2.b.a().booleanValue() == true) goto L5;
        return 0;
    L5:
        if (this.d == true) goto L7;
        return 0;
    L7:
        if (j() != 0) goto L13;
        return 1;
    L13:
        return 0;
    }

    public final int j() {
        if (yt2.b.a().booleanValue() == true) goto L5;
        return 0;
    L5:
        if (a() == false) goto L12;
        if (this.p == ToolbarBroadcastFunction.WELFARE) goto L9;
        return 0;
    L9:
        if (this.d == false) goto L33;
    L10:
        return 1;
    L33:
        return 0;
    L12:
        if (this.n == false) goto L14;
        return 0;
    L14:
        if (this.g == false) goto L16;
        return 0;
    L16:
        if (this.i == false) goto L18;
        return 0;
    L18:
        if (this.k == false) goto L20;
        return 0;
    L20:
        if (this.l == false) goto L24;
        if (this.m == true) goto L24;
        return 0;
    L24:
        if (this.d == true) goto L26;
        return 0;
    L26:
        if (this.j == false) goto L28;
        return 0;
    L28:
        if (this.o == false) goto L30;
        return 0;
    L30:
        if (this.h == false) goto L10;
        return 0;
    }

    public final void k(ToolbarBroadcastFunction r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.p = r2;
    }
}
