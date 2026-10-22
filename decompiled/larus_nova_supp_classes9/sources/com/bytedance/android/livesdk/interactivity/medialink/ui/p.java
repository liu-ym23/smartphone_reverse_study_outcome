package com.bytedance.android.livesdk.interactivity.medialink.ui;

import android.view.View;
import com.bytedance.android.livesdk.interactivity.medialink.ui.window.UILayout;
import com.bytedance.android.livesdk.interactivity.medialink.ui.window.WindowLayoutType;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class p implements c {
    public q a;
    public boolean b;
    public final View c;
    public final boolean d;
    public final boolean e;
    public final boolean f;
    public final boolean g;
    public final Function1<Integer, Boolean> h;
    public final Function1<UILayout, Boolean> i;
    public final Function1<WindowLayoutType, Boolean> j;
    public final Function1<? super Boolean, Unit> k;

    @Override // com.bytedance.android.livesdk.interactivity.medialink.ui.c
    public final boolean b() {
        return this.b;
    }

    @Override // com.bytedance.android.livesdk.interactivity.medialink.ui.c
    public final boolean c() {
        return this.f;
    }

    @Override // com.bytedance.android.livesdk.interactivity.medialink.ui.c
    public final boolean d() {
        return this.e;
    }

    @Override // com.bytedance.android.livesdk.interactivity.medialink.ui.c
    public final boolean e() {
        return this.d;
    }

    @Override // com.bytedance.android.livesdk.interactivity.medialink.ui.c
    public final boolean f() {
        return this.g;
    }

    @Override // com.bytedance.android.livesdk.interactivity.medialink.ui.c
    public final boolean a(UILayout r2) {
        Intrinsics.checkNotNullParameter(r2, "uiLayout");
        return ((Boolean) this.i.invoke(r2)).booleanValue();
    }

    @Override // com.bytedance.android.livesdk.interactivity.medialink.ui.c
    public final boolean g(WindowLayoutType r2) {
        Intrinsics.checkNotNullParameter(r2, "type");
        return ((Boolean) this.j.invoke(r2)).booleanValue();
    }

    @Override // com.bytedance.android.livesdk.interactivity.medialink.ui.c
    public final void h(boolean r2) {
        this.k.invoke(Boolean.valueOf(r2));
    }

    @Override // com.bytedance.android.livesdk.interactivity.medialink.ui.c
    public final boolean i(int r2) {
        return ((Boolean) this.h.invoke(Integer.valueOf(r2))).booleanValue();
    }

    public final void j(boolean r1) {
        this.b = r1;
        q r2 = this.a;
        if (r2 == null) goto L6;
        r2.a(this);
        return;
    }

    public p(View r4, boolean r5, boolean r6, Function1 r7, Function1 r8, Function1 r9, int r10) {
        if ((r10 & 4) == 0) goto L6;
        r5 = false;
    L6:
        if ((r10 & 8) == 0) goto L9;
        r6 = false;
    L9:
        if ((r10 & 16) == 0) goto L11;
        boolean r0 = true;
    L13:
        if ((r10 & 32) == 0) goto L16;
        r7 = MediaWindowComponent$1.INSTANCE;
    L16:
        if ((r10 & 64) == 0) goto L19;
        r8 = MediaWindowComponent$2.INSTANCE;
    L19:
        if ((r10 & 128) == 0) goto L22;
        r9 = MediaWindowComponent$3.INSTANCE;
    L22:
        if ((r10 & 256) == 0) goto L24;
        MediaWindowComponent$4 r11 = MediaWindowComponent$4.INSTANCE;
    L25:
        Intrinsics.checkNotNullParameter(r7, "validInWindowCount");
        Intrinsics.checkNotNullParameter(r8, "validWhenUILayout");
        Intrinsics.checkNotNullParameter(r9, "validWhenWindowLayoutType");
        Intrinsics.checkNotNullParameter(r11, "onShowSet");
        this.c = r4;
        this.d = false;
        this.e = r5;
        this.f = r6;
        this.g = r0;
        this.h = r7;
        this.i = r8;
        this.j = r9;
        this.k = r11;
        return;
    L24:
        r11 = null;
        goto L25
    L11:
        r0 = false;
        goto L13
    }
}
