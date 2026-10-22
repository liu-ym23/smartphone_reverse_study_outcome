package com.ss.android.lark.image.utils;

import android.content.Context;
import com.bumptech.glide.load.engine.GlideException;
import com.larksuite.component.universe_design.toast.UDToast;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.UICallbackExecutor;
import com.larksuite.framework.utils.NetworkUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.log.Log;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class b {
    public static boolean a;

    public static final class a implements Runnable {
        public final /* synthetic */ Context a;

        public a(Context r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            UDToast.show(this.a, 2131892012);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
    }

    @JvmStatic
    public static final boolean a(Context r4, ErrorResult r5) {
        Intrinsics.checkNotNullParameter(r4, "context");
        if (r5 == null) goto L5;
        int r1 = r5.getErrorCode();
    L7:
        if (NetworkUtils.d(r4) == false) goto L9;
    L14:
        return true;
    L9:
        if (a == true) goto L12;
        a = true;
        UICallbackExecutor.execute(new a(r4));
    L12:
        if (GlideException.isGlideException(r1) == false) goto L14;
        Log.e("ImageCommonUtils", "load image failed:" + r5 + ", but net is not available");
        return false;
    L5:
        r1 = 0;
        goto L7
    }
}
