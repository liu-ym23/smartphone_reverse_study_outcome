package com.ss.android.lark.keyboard.plugin.tool.photo;

import android.content.Context;
import com.larksuite.component.universe_design.toast.UDToast;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.utils.UIHelper;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class e implements Runnable {
    public static final e a = null;

    static {
        a = new e();
    }

    public e() {
    }

    @Override // java.lang.Runnable
    public final void run() {
        String r0 = UIHelper.mustacheFormat(2131891178, "type", UIHelper.getString(2131891179));     // Catch: Throwable -> L5
        Context r1 = UIHelper.getContext();     // Catch: Throwable -> L5
        Intrinsics.checkNotNull(r0);     // Catch: Throwable -> L5
        UDToast.makeToast(r1, r0).show();     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L9;
        return;
    L9:
        throw th;
    }
}
