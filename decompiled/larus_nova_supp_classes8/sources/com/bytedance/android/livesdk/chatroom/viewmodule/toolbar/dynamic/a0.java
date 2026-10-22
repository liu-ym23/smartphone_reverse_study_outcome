package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic;

import android.text.TextUtils;
import android.util.SparseArray;
import com.bytedance.android.live.core.setting.LiveInfraSettingKeys;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdkapi.room.handler.toolbar.NewToolbarButtonConstants;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public abstract class a0 {
    public static final SparseArray<w> e = null;
    public final Lazy a;
    public final Lazy b;
    public final w c;
    public final NewToolbarButtonConstants d;

    public static final class a {
        public static ToolbarButton a(int r1, boolean r2, boolean r3) {
            w r4 = a0.e.get(r1);
            if (r4 == null) goto L11;
            if (r2 == false) goto L8;
            if (r3 == false) goto L14;
            return r4.d;
        L14:
            return r4.c;
        L8:
            if (r3 == false) goto L16;
            return r4.b;
        L16:
            return r4.a;
        L11:
            return null;
        }
    }

    public a0() {
        this(null, null, 7);
    }

    public void a(ToolbarButton r1) {
    }

    public void b(ToolbarButton r1) {
    }

    public com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b d(s r2) {
        Intrinsics.checkNotNullParameter(r2, "button");
        return null;
    }

    public com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b e(s r2) {
        Intrinsics.checkNotNullParameter(r2, "button");
        return null;
    }

    public com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b f(s r2) {
        Intrinsics.checkNotNullParameter(r2, "button");
        return null;
    }

    public com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b g(s r1, boolean r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r1, "button");
        return null;
    }

    public abstract w j();

    public abstract NewToolbarButtonConstants k();

    public void n(boolean r2) {
        Intrinsics.checkNotNullParameter("", "reason");
    }

    public boolean o() {
        return this instanceof com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.config.i;
    }

    public void p() {
    }

    static {
        e = new SparseArray();
    }

    public boolean m() {
        int r0 = com.bytedance.android.livesdk.config.setting.s.a;
        return ((com.bytedance.android.livesdk.config.setting.u) LiveInfraSettingKeys.LIVE_NEW_TOOLBAR_FUNCTION_CHANGE.getValue()).b();
    }

    public String i(boolean r3, boolean r4) {
        String r0 = k().getName();
        if (TextUtils.isEmpty(r0) == false) goto L5;
        return "";
    L5:
        StringBuilder r1 = new StringBuilder();
        r1.append(r0);
        if (r3 == false) goto L8;
        String r5 = "_More";
    L9:
        r1.append(r5);
        String r6 = r1.toString();
        StringBuilder r2 = new StringBuilder();
        r2.append(r6);
        if (r4 == false) goto L12;
        String r7 = "_Anchor";
    L13:
        r2.append(r7);
        return r2.toString();
    L12:
        r7 = "_Audience";
        goto L13
    L8:
        r5 = "_Toolbar";
        goto L9
    }

    public final ToolbarButton l(boolean r2, boolean r3) {
        w r0 = (w) this.a.getValue();
        if (r2 == false) goto L7;
        if (r3 == false) goto L12;
        return r0.d;
    L12:
        return r0.c;
    L7:
        if (r3 == false) goto L10;
        return r0.b;
    L10:
        return r0.a;
    }

    public a0(zr2.v r3, NewToolbarButtonConstants r4, int r5) {
        if ((r5 & 2) == 0) goto L6;
        r3 = null;
    L6:
        if ((r5 & 4) == 0) goto L8;
        r4 = null;
    L8:
        this.c = r3;
        this.d = r4;
        Lazy r6 = LazyKt.lazy(new ToolbarComponentConfig$mappingRule$2(this));
        this.a = r6;
        Lazy r7 = LazyKt.lazy(new ToolbarComponentConfig$constants$2(this));
        this.b = r7;
        int r8 = ((NewToolbarButtonConstants) r7.getValue()).getId();
        w r9 = (w) r6.getValue();
        Intrinsics.checkNotNullParameter(r9, "rule");
        e.put(r8, r9);
    }

    public boolean c(s r2, boolean r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r2, "button");
        if (h(r2, r3, Boolean.valueOf(r4)) == null) goto L5;
        return true;
    L5:
        return false;
    }

    public final com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b h(s r3, boolean r4, Boolean r5) {
        Intrinsics.checkNotNullParameter(r3, "button");
        if (r3.m == true) goto L5;
        if (r5 == null) goto L8;
        boolean r1 = r5.booleanValue();
    L9:
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b r2 = g(r3, r4, r1);
        if (r2 == null) goto L13;
        return r2;
    L13:
        if (Intrinsics.areEqual(r5, Boolean.TRUE) == false) goto L17;
        if (r4 == false) goto L22;
        return d(r3);
    L22:
        return e(r3);
    L17:
        if (r4 == false) goto L20;
        Intrinsics.checkNotNullParameter(r3, "button");
        return null;
    L20:
        return f(r3);
    L8:
        r1 = false;
        goto L9
    L5:
        return new u();
    }
}
