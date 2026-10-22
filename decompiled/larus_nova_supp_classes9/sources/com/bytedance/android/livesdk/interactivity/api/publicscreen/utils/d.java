package com.bytedance.android.livesdk.interactivity.api.publicscreen.utils;

import com.bytedance.android.livesdk.chatroom.clearscreen.ClearScreenConst;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class d implements jg1.a {
    public static final ClearScreenConst.InteractType a = null;
    public static final d b = null;

    public d() {
    }

    public final boolean a() {
        return false;
    }

    public final boolean b() {
        return false;
    }

    public final void c() {
    }

    public final long d() {
        return 300;
    }

    public final boolean e(jg1.b.a r2) {
        Intrinsics.checkNotNullParameter(r2, "param");
        return true;
    }

    public final void f() {
    }

    static {
        b = new d();
        a = ClearScreenConst.InteractType.AUDIENCE_PS_CONFIG_DIALOG_SHOW;
    }

    public final ClearScreenConst.AnimType g() {
        return ClearScreenConst.AnimType.TRANS;
    }

    public final ClearScreenConst.InteractType getInteractType() {
        return a;
    }
}
