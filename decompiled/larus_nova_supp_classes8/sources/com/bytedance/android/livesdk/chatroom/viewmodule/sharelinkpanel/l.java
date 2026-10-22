package com.bytedance.android.livesdk.chatroom.viewmodule.sharelinkpanel;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public abstract class l {
    public l() {
    }

    public abstract String b();

    public abstract int c();

    public abstract String d();

    public abstract String e();

    public boolean a(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        if (puc.a.isInstalledApp(r2, d()) == true) goto L6;
        return false;
    L6:
        return true;
    }
}
