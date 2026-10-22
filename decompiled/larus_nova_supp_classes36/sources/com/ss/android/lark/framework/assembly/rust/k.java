package com.ss.android.lark.framework.assembly.rust;

import com.bytedance.lark.pb.basic.v1.Command;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class k implements com.ss.android.lark.sdk.d {
    public final /* synthetic */ InitRustSdkTaskForSimple a;

    public final Long a(String r1) {
        return null;
    }

    public final void b() {
    }

    public final boolean d() {
        return true;
    }

    public final boolean e() {
        return false;
    }

    public final String getUserId() {
        return this.a.c.g();
    }

    public k(InitRustSdkTaskForSimple r1) {
        this.a = r1;
    }

    public final boolean c(Command r2) {
        Intrinsics.checkNotNullParameter(r2, "command");
        if (Intrinsics.areEqual(r2, Command.SET_DEVICE) == false) goto L5;
    L10:
        return true;
    L5:
        if (Intrinsics.areEqual(r2, Command.MAKE_USER_ONLINE) == true) goto L10;
        if (Intrinsics.areEqual(r2, Command.GET_INIT_SETTINGS) == true) goto L10;
        return false;
    }
}
