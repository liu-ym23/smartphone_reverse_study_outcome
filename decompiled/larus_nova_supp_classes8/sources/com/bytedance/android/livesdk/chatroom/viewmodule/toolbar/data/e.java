package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data;

import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ExtendedToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.a2;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.s;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class e implements com.bytedance.android.livesdk.chatroom.e, a2, com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.control.b {
    public boolean a;
    public int b;
    public List<String> c;
    public boolean d;
    public boolean e;
    public String f;
    public int g;
    public String h;
    public int i;
    public h j;
    public s<Object> k;
    public String l;
    public final ExtendedToolbarButton m;

    public final ToolbarButton e() {
        ExtendedToolbarButton r0 = this.m;
        if ((r0 instanceof ExtendedToolbarButton.b) == true) goto L5;
        return null;
    L5:
        return ((ExtendedToolbarButton.b) r0).i;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.control.b
    public final String getComponentName() {
        ExtendedToolbarButton r0 = this.m;
        if ((r0 instanceof ExtendedToolbarButton.b) == true) goto L5;
        r0 = null;
    L5:
        ExtendedToolbarButton.b r1 = (ExtendedToolbarButton.b) r0;
        if (r1 == null) goto L11;
        ToolbarButton r2 = r1.i;
        if (r2 == null) goto L11;
        String r3 = r2.name();
        if (r3 == null) goto L11;
        return r3;
    L11:
        return "null";
    }

    public final int hashCode() {
        int r1 = 1231;
        if (this.a == false) goto L5;
        int r0 = 1231;
    L6:
        int r2 = ((r0 * 31) + this.b) * 31;
        List<String> r3 = this.c;
        if (r3 == null) goto L9;
        int r4 = r3.hashCode();
    L10:
        int r5 = (r2 + r4) * 31;
        if (this.d == false) goto L13;
        int r6 = 1231;
    L14:
        int r7 = (r5 + r6) * 31;
        if (this.e == false) goto L17;
        int r8 = 1231;
    L18:
        int r9 = ((((((r7 + r8) * 31) + this.f.hashCode()) * 31) + this.h.hashCode()) * 31) + this.i;
        ExtendedToolbarButton r10 = this.m;
        if ((r10 instanceof ExtendedToolbarButton.c) == false) goto L26;
        int r11 = r9 * 31;
        if (((ExtendedToolbarButton.c) r10).r == true) goto L25;
        r1 = 1237;
    L25:
        return r11 + r1;
    L26:
        return r9;
    L17:
        r8 = 1237;
        goto L18
    L13:
        r6 = 1237;
        goto L14
    L9:
        r4 = 0;
        goto L10
    L5:
        r0 = 1237;
        goto L6
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.a2
    public final String debugName() {
        return this.f;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.control.b
    public final int getComponentId() {
        return this.g;
    }

    public final s<Object> getCustomView() {
        return this.k;
    }

    public final int getGroupType() {
        return this.i;
    }

    public e(ExtendedToolbarButton r2) {
        Intrinsics.checkNotNullParameter(r2, "extendedToolbarButton");
        this.m = r2;
        this.f = "";
        this.g = -1;
        this.h = "";
        this.i = 2;
        this.l = "";
    }

    public final boolean equals(Object r6) {
        if (this != r6) goto L5;
        return true;
    L5:
        ExtendedToolbarButton r2 = null;
        if (r6 == null) goto L8;
        Class<?> r3 = r6.getClass();
    L10:
        if ((!Intrinsics.areEqual(e.class, r3)) == false) goto L12;
        return false;
    L12:
        if (r6 == null) goto L50;
        e r7 = (e) r6;
        if (this.a == r7.a) goto L17;
        return false;
    L17:
        if (this.b == r7.b) goto L20;
        return false;
    L20:
        if ((!Intrinsics.areEqual(this.c, r7.c)) == false) goto L23;
        return false;
    L23:
        if (this.d == r7.d) goto L26;
        return false;
    L26:
        if (this.e == r7.e) goto L29;
        return false;
    L29:
        if ((!Intrinsics.areEqual(this.f, r7.f)) == false) goto L32;
        return false;
    L32:
        if ((!Intrinsics.areEqual(this.h, r7.h)) == false) goto L35;
        return false;
    L35:
        if (this.i == r7.i) goto L37;
        return false;
    L37:
        ExtendedToolbarButton r1 = this.m;
        if ((r1 instanceof ExtendedToolbarButton.c) == false) goto L48;
        boolean r4 = ((ExtendedToolbarButton.c) r1).r;
        ExtendedToolbarButton r8 = r7.m;
        if ((r8 instanceof ExtendedToolbarButton.c) == false) goto L43;
        r2 = r8;
    L43:
        ExtendedToolbarButton.c r5 = (ExtendedToolbarButton.c) r2;
        if (r5 != null) goto L46;
    L47:
        return false;
    L46:
        if (r4 != r5.r) goto L47;
    L48:
        return true;
    L50:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.MoreDialogButtonModel");
    L8:
        r3 = null;
        goto L10
    }

    public final void f(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.f = r2;
    }
}
